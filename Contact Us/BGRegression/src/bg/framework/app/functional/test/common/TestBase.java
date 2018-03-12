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
import bg.framework.app.functional.entities.CRMExecutionDataProfile;
import bg.framework.app.functional.entities.SiebelExecutionDataProfile;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SiebelDataBase;
import bg.framework.app.functional.util.TestDataHelper;
import bg.framework.common.functional.UIDriver;
import bg.framework.common.functional.WebDriverProvider;
import bg.framework.app.functional.util.SapNetWeaverPage;
import bg.framework.app.functional.page.common.LegacyHomePage;


public class TestBase {
	public static String CustomerData = ""; 
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) throws InterruptedException, IOException {
    	//Runtime.getRuntime().exec("C://Documents and Settings//!raghavp2//Desktop//test.exe");
       
        //Runtime.getRuntime().exec("C://Documents and Settings//!raghavp2//Desktop//test.exe");
    	System.out.println("the application mkp is"+ ApplicationConfig.Application_MakeAPayment);
    	if(ApplicationConfig.Application_MakeAPayment.equalsIgnoreCase("false"))
    	{
        	 UIDriver uiDriver = WebDriverProvider.getCurrentDriver();
        if (ApplicationConfig.BRAND.equalsIgnoreCase("bg")) {
        	System.out.println("@$@$@$@$@$@$@$@@@@@@@@@@@@@  "+ApplicationConfig.APP_BG_URL);
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
    
    
    public void getCustomerDetailsToUserProfileOAM(UserProfile userProfile){
    	/*OnlineDBConnector oldb = new OnlineDBConnector();
    	String CustomerDB = oldb.getCustomerMasterDB(userProfile.getUCRN());
    	try{
    		if(CustomerDB.equalsIgnoreCase("X")){
    			CustomerData = "SAPCRM";
    			userProfile.setBusinessPartnerID(oldb.getBPnumber(userProfile.getUCRN()));
    			Report.updateTestLog("Customer data is found in the SAP CRM", "Pass");
        		getCustomerDetailsToUserProfileOAMSAPCRM(userProfile);
        		//getCustomerDetailsToUserProfileOAMSIEBEL(userProfile);
        	}
    	}
    	catch(java.lang.NullPointerException Null){    
    		CustomerData = "SIEBEL";
    		Report.updateTestLog("Customer data is found in the Siebel", "Pass");
    		getCustomerDetailsToUserProfileOAMSIEBEL(userProfile);
    	}*/
    }
    
    
    public void getCustomerDetailsToUserProfileOAMSAPCRM(UserProfile userProfile) {
    	try{
    		//updateBrand(userProfile);
    		OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
            SapNetWeaverPage sapUserDetail = new SapNetWeaverPage();
            try{
            	if(sapUserDetail.executeSAPCRM(userProfile) == false){
            		CRMExecutionDataProfile CRMExecutionData = new TestDataHelper().getCRMExecutionDataProfile(userProfile.getBusinessPartnerID());
                	userProfile.setHomeNumber(CRMExecutionData.getHomenumber());
                    if(CRMExecutionData.getPostcode() == ""){
                    	CRMExecutionData.setPostcode("SE23 1LN");
                    }
                    else{
                    	userProfile.setPostCode(CRMExecutionData.getPostcode());
                    }
                    userProfile.setTitle(CRMExecutionData.getTitle());
                    userProfile.setFirstName(CRMExecutionData.getFirtsname());
                    userProfile.setLastName(CRMExecutionData.getLastname());
                    userProfile.setPhoneType(CRMExecutionData.getPhoneType());
                    userProfile.setPhoneNumber(CRMExecutionData.getPhoneNumber());

                }
                else{
                	try{
                		sapUserDetail.openSapCRM(userProfile);
                		userProfile.setHomeNumber(sapUserDetail.getHomeNumber());
                        if(sapUserDetail.getPostCode() == ""){
                        	userProfile.setPostCode("SE23 1LN");
                        }
                        else{
                        	userProfile.setPostCode(sapUserDetail.getPostCode());
                        }
                        userProfile.setTitle(sapUserDetail.getName("TITLE"));
                        userProfile.setFirstName(sapUserDetail.getName("FIRSTNAME"));
                        userProfile.setLastName(sapUserDetail.getName("LASTNAME"));
                        userProfile.setPhoneType(sapUserDetail.getTelephoneType());
                        userProfile.setPhoneNumber(sapUserDetail.getTelephoneNumber());
                        sapUserDetail.updateCRMExecutionData(userProfile);
                        sapUserDetail.returnUrl();
                	}
                	catch(Exception IE){
                		sapUserDetail.updateCRMExecutionData(userProfile);
                		sapUserDetail.returnUrl();
                	}
                	 
                }
            }
            catch(NullPointerException NullPointer){
            	try{
            		sapUserDetail.openSapCRM(userProfile);
            		userProfile.setHomeNumber(sapUserDetail.getHomeNumber());
                    if(sapUserDetail.getPostCode() == ""){
                    	userProfile.setPostCode("SE23 1LN");
                    }
                    else{
                    	userProfile.setPostCode(sapUserDetail.getPostCode());
                    }
                    userProfile.setTitle(sapUserDetail.getName("TITLE"));
                    userProfile.setFirstName(sapUserDetail.getName("FIRSTNAME"));
                    userProfile.setLastName(sapUserDetail.getName("LASTNAME"));
                    userProfile.setPhoneType(sapUserDetail.getTelephoneType());
                    userProfile.setPhoneNumber(sapUserDetail.getTelephoneNumber());
                    sapUserDetail.updateCRMExecutionData(userProfile);
                    sapUserDetail.returnUrl();
            	}
            	catch(Exception IE){
            		sapUserDetail.updateCRMExecutionData(userProfile);
            		sapUserDetail.returnUrl();
            	}
            }
            
            if(userProfile.getTitle().equals("Mr & Mrs")){
            	userProfile.setTitle("Mrs");
            }
            Report.updateTestLog("TITLE : "+userProfile.getTitle(), "Pass");
            Report.updateTestLog("FIRSTNAME : "+userProfile.getFirstName(), "Pass");
            Report.updateTestLog("LASTNAME : "+userProfile.getLastName(), "Pass");
            Report.updateTestLog("POSTCODE : "+userProfile.getaddr(), "Pass");
            Report.updateTestLog("Home Number :"+userProfile.getHomeNumber(), "Pass");
            Report.updateTestLog("PHONE TYPE :"+userProfile.getPhoneType(), "Pass");
            Report.updateTestLog("PHONE NUMBER :"+userProfile.getPhoneNumber(), "Pass");
            
            if (userProfile.getTitle().equals("") || userProfile.getFirstName().equals( "") || userProfile.getLastName().equals( "")) {
                Report.updateTestLog("User details are not present in SAP CRM", "FAIL");
            } else {
                Report.updateTestLog("Precodnition: Customer details stored in Userprofile from SAP CRM", "DONE");
                String strUCRN = userProfile.getUCRN();
                String strRetreiveEmailQry = "select count(*) from po_ta_oam_customer where UCRN='USERUCRN'";
                strRetreiveEmailQry = strRetreiveEmailQry.replace("USERUCRN", strUCRN);
                int recCount = onlineDBConnector.getRegDBCount(strRetreiveEmailQry);
                if (recCount > 0) {
                   // userProfile.setEmail(onlineDBConnector.getUserEmail(userProfile.getUCRN()));
                    userProfile.setSecurityQuestion(onlineDBConnector.getSecurityQuestion(userProfile.getUCRN()));
                    userProfile.setSecurityAnswer(onlineDBConnector.getSecurityAnswer(userProfile.getUCRN()));
                } else {
                    int intRandomNumbers;
                    Random random = new Random();
                    intRandomNumbers = random.nextInt(1000);
                    System.out.print("automation_sele" + intRandomNumbers + "@bgdigitaltest.co.uk");
                    //userProfile.setEmail("automation_sele" + intRandomNumbers + "@bgdigitaltest.co.uk");
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
    	catch(Exception e){
    		new SapNetWeaverPage().returnUrl();
    	}
              
    }

    
    public void getCustomerDetailsToUserProfileOAMSIEBEL(UserProfile userProfile){
    //	updateBrand(userProfile);
        OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
        SiebelDataBase sd = new SiebelDataBase();
        sd.setAccountStatus(userProfile.getAccNumber(),0);
        if(sd.executeSiebel(userProfile) == false){
        	System.out.println("EXECUTE SIEBEL NOT");
        	SiebelExecutionDataProfile SiebelExecutionData = new TestDataHelper().getSiebelExecutionDataProfile(userProfile.getUCRN());
        	userProfile.setHomeNumber(SiebelExecutionData.getHomenumber());
            if(SiebelExecutionData.getPostcode() == ""){
            	SiebelExecutionData.setPostcode("SE23 1LN");
            }
            else{
            	userProfile.setPostCode(SiebelExecutionData.getPostcode());
            }
            userProfile.setTitle(SiebelExecutionData.getTitle());
            userProfile.setFirstName(SiebelExecutionData.getFirtsname());
            userProfile.setLastName(SiebelExecutionData.getLastname());
            userProfile.setPhoneType(SiebelExecutionData.getPhoneType());
            userProfile.setPhoneNumber(SiebelExecutionData.getPhoneNumber());
        }
        else{
        	List<String> address = sd.getAddress(userProfile.getAccNumber());
            if (address.get(0).isEmpty()||address.get(0) == null) {
                userProfile.setHomeNumber(address.get(1));
            } else {
                userProfile.setHomeNumber(address.get(0));
            }
            if (address.get(4) == null || address.get(4).isEmpty()) {
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
                try {
					sd.updateSiebelExecutionData(userProfile);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
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

                
                try {
                    onlineDBConnector.activateUser(userProfile.getUCRN());
                } catch (Exception e) {
                    Report.updateTestLog("Precondition Error :" + e, "FAIL");
                }
            }
        }
       
        
    }
    
    /*public void getCustomerDetailsToUserProfileOAMSIEBEL(UserProfile userProfile) {
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
    }*/

    public void getCustomerDetailsToUserProfileAnonymous(UserProfile userProfile) {
    	OnlineDBConnector oldb = new OnlineDBConnector();
    	String CustomerDB = oldb.getCustomerMasterDB(userProfile.getUCRN());
    	System.out.println("@$#$#$#%#%#%#%" + CustomerDB);
    	try{
    		if(CustomerDB.equalsIgnoreCase("X")){
    			CustomerData = "SAPCRM";
    			userProfile.setBusinessPartnerID(oldb.getBPnumber(userProfile.getUCRN()));
    			getCustomerDetailsToUserProfileOAMSAPCRM(userProfile);
    		}
    	}
    	catch(java.lang.NullPointerException Null){    
    		CustomerData = "SIEBEL";
    		updateBrand(userProfile);
            OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
            SiebelDataBase sd = new SiebelDataBase();
            List<String> address = sd.getAddress(userProfile.getAccNumber());
            
            if(address.size() > 0){
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
                   // userProfile.setSecurityQuestion(onlineDBConnector.getSecurityQuestion(userProfile.getUCRN()));
                    //userProfile.setSecurityAnswer(onlineDBConnector.getSecurityAnswer(userProfile.getUCRN()));
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
    	new LegacyHomePage().logout();
        Report.finalWrapUp();
        Report.intPassCount = 0;
        Report.intFailCount = 0;
    }
    
    
    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        /*try {
            WebDriverProvider.quitDriver();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error closing webdriver session." + e.getMessage(), e);
        }*/
    }

    @BeforeSuite(alwaysRun = true)
    public void CreateTestLogPath() {
        Report.createTestLogPath();
    }
    
/*public void GetCustomerDetailsOnlineDb(UserProfile userProfile) {
        
        OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
            String strUCRN = userProfile.getUCRN();
            String strRetreiveEmailQry = "select count(*) from po_ta_oam_customer where UCRN='USERUCRN'";
            strRetreiveEmailQry = strRetreiveEmailQry.replace("USERUCRN", strUCRN);
            int recCount = onlineDBConnector.getRegDBCount(strRetreiveEmailQry);
            if (recCount > 0) {
                userProfile.setEmail(onlineDBConnector.getUserEmail(userProfile.getUCRN()));
                userProfile.setSecurityQuestion(onlineDBConnector.getSecurityQuestion(userProfile.getUCRN()));
                userProfile.setSecurityAnswer(onlineDBConnector.getSecurityAnswer(userProfile.getUCRN()));
            	Report.updateTestLog("Record present with the UCRN :"+strUCRN, "Pass");
            } else {
            	Report.updateTestLog("Record not present with the UCRN :"+strUCRN, "Fail");
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
    public int verifyLoginTryCount(UserProfile userProfile,int recCount) {
    	
    	final int loginTryCount = new OnlineDBConnector().verifyLoginTryCount(userProfile.getEmail());
        if (loginTryCount==recCount){
        	Report.updateTestLog("Login Try Count is set to ::"+recCount, "Pass");
         }
        else{
        	Report.updateTestLog("Login Try Count is set to ::"+recCount, "Fail");
        }
        return loginTryCount; 
    } 
*/}
