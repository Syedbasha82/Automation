package bg.framework.app.functional.test.common;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SiebelDataBase;
import bg.framework.common.functional.UIDriver;
import bg.framework.common.functional.WebDriverFactory;
import bg.framework.common.functional.WebDriverProvider;

public class TestBase {
	
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) throws InterruptedException, IOException {
    	//Runtime.getRuntime().exec("C://Documents and Settings//!raghavp2//Desktop//test.exe");
       
        //Runtime.getRuntime().exec("C://Documents and Settings//!raghavp2//Desktop//test.exe");
    	if(ApplicationConfig.Application_MakeAPayment.equalsIgnoreCase("false"))
    	{
        	 UIDriver uiDriver = WebDriverProvider.getCurrentDriver();
        if (ApplicationConfig.BRAND.equalsIgnoreCase("bg")) {
            uiDriver.get(ApplicationConfig.APP_BG_URL);
            Thread.sleep(10000);
            //Runtime.getRuntime().exec("C://Documents and Settings//!raghavp2//Desktop//test.exe");
            // uiDriver.get(ApplicationConfig.LOGIN_URL);
        } else if (ApplicationConfig.BRAND.equalsIgnoreCase("bg")) {
            uiDriver.get(ApplicationConfig.APP_BG_URL);
        } else if (ApplicationConfig.BRAND.equalsIgnoreCase("bgb")) {
            uiDriver.get(ApplicationConfig.APP_BGB_URL);            
        } else if (ApplicationConfig.BRAND.equalsIgnoreCase("services")) {
            uiDriver.get(ApplicationConfig.APP_SERVICES_URL);
        } else if (ApplicationConfig.BRAND.equalsIgnoreCase("fusion")) {
            uiDriver.get(ApplicationConfig.APP_FUSION_URL);
        } 
    	}
        //Runtime.getRuntime().exec("C://Documents and Settings//!raghavp2//Desktop//test.exe");
        Thread.sleep(1000);
        
    }

    private void updateBrand(UserProfile userProfile) {
        SiebelDataBase sd = new SiebelDataBase();
        if (ApplicationConfig.BRAND.equalsIgnoreCase("bg")) {
            sd.setBrandBritishGas(userProfile.getAccNumber());
        } else if (ApplicationConfig.BRAND.equalsIgnoreCase("fusion")) {
            sd.setBrandSainsbury(userProfile.getAccNumber());
        }
    }

    public void getCustomerDetailsToUserProfileOAM(UserProfile userProfile) {
        updateBrand(userProfile);
        OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
        SiebelDataBase sd = new SiebelDataBase();
        sd.setAccountStatus(userProfile.getAccNumber(),0);
        List<String> address = sd.getAddress(userProfile.getAccNumber());
        if (address.get(0).isEmpty() || address.get(0) == null) {
            userProfile.setHomeNumber(address.get(1));
        } else {
            userProfile.setHomeNumber(address.get(0));
        }
        if (address.get(4).isEmpty() || address.get(4) == null) {
            userProfile.setPostCode("SE23 1LN");
        } else {
            userProfile.setPostCode(address.get(4));
        }
        String strTitle = sd.getTitle(userProfile.getUCRN());
        if (strTitle.equalsIgnoreCase("Mr & Mrs")) {
            userProfile.setTitle("Mrs");
        } else {
            userProfile.setTitle(sd.getTitle(userProfile.getUCRN()));
        }
        userProfile.setFirstName(sd.getFirstName(userProfile.getUCRN()));
        userProfile.setLastName(sd.getLastName(userProfile.getUCRN()));
        if (userProfile.getTitle().equals("") || userProfile.getFirstName().equals( "") || userProfile.getLastName().equals( "")) {
            Report.updateTestLog("User details are not present in Siebel", "FAIL");
        } else {
            Report.updateTestLog("Precondition: Customer details stored in Userprofile from Siebel", "DONE");
            userProfile.setPhoneType(sd.getTelephoneType(userProfile.getUCRN()));
            userProfile.setPhoneNumber(sd.getTelephoneNumber(userProfile.getUCRN()));
            String strUCRN = userProfile.getUCRN();
            String strRetreiveEmailQry = "select count(*) from po_ta_oam_customer where UCRN='USERUCRN'";
            strRetreiveEmailQry = strRetreiveEmailQry.replace("USERUCRN", strUCRN);
            int recCount = onlineDBConnector.getRegDBCount(strRetreiveEmailQry);
            if (recCount > 0) {
                userProfile.setEmail(onlineDBConnector.getUserEmail(userProfile.getUCRN()));
                userProfile.setSecurityQuestion(onlineDBConnector.getSecurityQuestion(userProfile.getUCRN()));
                userProfile.setSecurityAnswer(onlineDBConnector.getSecurityAnswer(userProfile.getUCRN()));
            } else {
                int intRandomNumbers;
                Random random = new Random();
                intRandomNumbers = random.nextInt(1000);
                System.out.print("automation_sele" + intRandomNumbers + "@bgdigitaltest.co.uk");
                userProfile.setEmail("automation_sele" + intRandomNumbers + "@bgdigitaltest.co.uk");
                userProfile.setSecurityQuestion("Place of birth");
                userProfile.setSecurityAnswer("password12");
                try {
                    onlineDBConnector.addexistinguserprofileinDB(userProfile);
                } catch (Exception e) {
                    Report.updateTestLog("Precondition Error :" + e, "FAIL");
                }

            }
            try {
                onlineDBConnector.activateUser(userProfile.getUCRN());
            } catch (Exception e) {
                Report.updateTestLog("Precondition Error :" + e, "FAIL");
            }
        }
    }

    public void getCustomerDetailsToUserProfileAnonymous(UserProfile userProfile) {
        updateBrand(userProfile);
        OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
        SiebelDataBase sd = new SiebelDataBase();
        List<String> address = sd.getAddress(userProfile.getAccNumber());
        if (address.get(0)==null || address.get(0).isEmpty()&&!(address.get(1)==null)) {
            userProfile.setHomeNumber(address.get(1));
        } else {
            userProfile.setHomeNumber(address.get(0));
        }
        if (address.get(4).isEmpty() || address.get(4) == null) {
            userProfile.setPostCode("SE23 1LN");
        } else {
            userProfile.setPostCode(address.get(4));
        }
        String strTitle = sd.getTitle(userProfile.getUCRN());
        if (strTitle.equalsIgnoreCase("Mr & Mrs")) {
            userProfile.setTitle("Mrs");
        } else {
            userProfile.setTitle(sd.getTitle(userProfile.getUCRN()));
        }
        userProfile.setFirstName(sd.getFirstName(userProfile.getUCRN()));
        userProfile.setLastName(sd.getLastName(userProfile.getUCRN()));
        if (userProfile.getTitle() == "" || userProfile.getFirstName() == "" || userProfile.getLastName() == "") {
            Report.updateTestLog("Precondition: User details are not present in Siebel", "FAIL");
        } else {
            Report.updateTestLog("Precodnition: Customer details stored in Userprofile from Siebel", "DONE");
            userProfile.setPhoneType(sd.getTelephoneType(userProfile.getUCRN()));
            userProfile.setPhoneNumber(sd.getTelephoneNumber(userProfile.getUCRN()));
            String strUCRN = userProfile.getUCRN();
            String strRetreiveEmailQry = "select count(*) from po_ta_oam_customer where UCRN='USERUCRN'";
            strRetreiveEmailQry = strRetreiveEmailQry.replace("USERUCRN", strUCRN);
            int recCount = onlineDBConnector.getRegDBCount(strRetreiveEmailQry);
            if (recCount > 0) {
                userProfile.setEmail(onlineDBConnector.getUserEmail(userProfile.getUCRN()));
                userProfile.setSecurityQuestion(onlineDBConnector.getSecurityQuestion(userProfile.getUCRN()));
                userProfile.setSecurityAnswer(onlineDBConnector.getSecurityAnswer(userProfile.getUCRN()));
                Report.updateTestLog("Precondition: Customer details stored in Userprofile taken from DVSOL", "DONE");
            } else {
                int intRandomNumbers;
                Random random = new Random();
                intRandomNumbers = random.nextInt(1000);
                System.out.print("automation_sele" + intRandomNumbers + "@bgdigitaltest.co.uk");
                userProfile.setEmail("automation_sele" + intRandomNumbers + "@bgdigitaltest.co.uk");
                userProfile.setSecurityQuestion("Place of birth");
                userProfile.setSecurityAnswer("london");
                Report.updateTestLog("Precondition: Customer details stored in Userprofile taken from DVSOL", "DONE");
            }
            try {
                onlineDBConnector.deRegister(userProfile.getUCRN());
            } catch (Exception e) {
                Report.updateTestLog("Precondition Error :" + e, "FAIL");
            }
        }
    }

    public void delCustomerDetailsFromOnlineDB(UserProfile userProfile) {
        UserProfile profile = new UserProfile();
        OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
        onlineDBConnector.deRegister(userProfile.getUCRN());
        profile = null;
        onlineDBConnector = null;
    }

    public void activateCustomerDetailsInOnlineDB(UserProfile userProfile) {
        OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
        System.out.println("ucrn " + userProfile.getUCRN());
        onlineDBConnector.activateUser(userProfile.getUCRN());
        onlineDBConnector = null;
    }

    public void registerCustomerDetailsInOnlineDB(UserProfile userProfile) {
        OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
        onlineDBConnector.addexistinguserprofileinDB(userProfile);
        onlineDBConnector = null;
    }

    private void updateBrandName(String accNumber) {
        SiebelDataBase SiebelDB = new SiebelDataBase();
        if (ApplicationConfig.BRAND.equalsIgnoreCase("bg")) {
            SiebelDB.setBrandBritishGas(accNumber);
        } else {
            SiebelDB.setBrandSainsbury(accNumber);
        }
    }

    public void updateAccStatus(String accNumber, int period) {
        SiebelDataBase SiebelDB = new SiebelDataBase();
        SiebelDB.setAccountStatus(accNumber, period);
    }

    @AfterMethod(alwaysRun = true)
    public void reportWrapUp() {
        Report.finalWrapUp();
        Report.intPassCount = 0;
        Report.intFailCount = 0;
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        try {
//          WebDriverProvider.quitDriver();  
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error closing webdriver session." + e.getMessage(), e);
        }
    }

    @BeforeSuite(alwaysRun = true)
    public void CreateTestLogPath() {
        Report.createTestLogPath();
    }
    
public void GetCustomerDetailsOnlineDb(UserProfile userProfile) {
        
        OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
            String bpnumber = userProfile.getBpnumber();
            System.out.println("Bpnumber is:"+bpnumber);
            String strRetreiveEmailQry = "select count(*) from BG_BUSINESS_TA_CUSTOMER_REG where " +
            		"BP_CONTACT_PERSON_NUMBER='bpnumber'";
            		
            strRetreiveEmailQry = strRetreiveEmailQry.replace("bpnumber", bpnumber);
            int recCount = onlineDBConnector.getRegDBCount(strRetreiveEmailQry);
            System.out.println("Record count is:"+recCount);
            if (recCount > 0) {
            	System.out.println("Bpnumber get:"+userProfile.getBpnumber());
            	String emailvalue=onlineDBConnector.getBgbEmail(userProfile.getBpnumber());
            	System.out.println("Online db value "+emailvalue);
                userProfile.setEmail(emailvalue);
//                userProfile.setSecurityQuestion(onlineDBConnector.getSecurityQuestion(userProfile.getUCRN()));
//                userProfile.setSecurityAnswer(onlineDBConnector.getSecurityAnswer(userProfile.getUCRN()));
            	Report.updateTestLog("Email address fetched for the account :"+userProfile+"is:"+emailvalue, "Pass");
            } else {
            	Report.updateTestLog("Record not present with the bpnumber :"+bpnumber, "Fail");
                int intRandomNumbers;
                Random random = new Random();
                intRandomNumbers = random.nextInt(1000);
                System.out.print("automation_sele" + intRandomNumbers + "@bgdigitaltest.co.uk");
                userProfile.setEmail("automation_sele" + intRandomNumbers + "@bgdigitaltest.co.uk");
                userProfile.setSecurityQuestion("Place of birth");
                userProfile.setSecurityAnswer("password12");
            }
                /*try {
                    onlineDBConnector.addexistinguserprofileinDB(userProfile);
                } catch (Exception e) {
                    Report.updateTestLog("Precondition Error :" + e, "FAIL");
                }
            
            try {
                onlineDBConnector.activateUser(userProfile.getUCRN());
            } catch (Exception e) {
                Report.updateTestLog("Precondition Error :" + e, "FAIL");
            }*/
        }
    
    public void callfirefox(){
    	
    	WebDriverProvider.makeDriver();
//    	getCurrentDriver();
    	//getDriver(WebDriverFactory.browserType.valueOf(ApplicationConfig.BROWSER));	
    }
    
    public void deregisterinBgbonline(UserProfile userProfile){
    	OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
    	onlineDBConnector.deRegisterinBgbonline(userProfile);
    }
    
    public void deleteContractAccountNo(UserProfile userProfile){
    	OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
    	onlineDBConnector.deRegisterContractAccount(userProfile.getAccNumber());
    	onlineDBConnector.deleteContractAccountNumber(userProfile.getAccNumber());
    }
    
}
