package bg.framework.app.functional.test.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
    	//OnlineDBConnector oldb = new OnlineDBConnector();
    	//String CustomerDB = oldb.getCustomerMasterDB(userProfile.getUCRN());
    	String CustomerDB = "X";
    	//try{
    		if(CustomerDB.equalsIgnoreCase("X")){
    			CustomerData = "SAPCRM";
    			//userProfile.setBusinessPartnerID(oldb.getBPnumber(userProfile.getUCRN()));
    			Report.updateTestLog("Customer data is found in the SAP CRM", "Pass");
        		getCustomerDetailsToUserProfileOAMSAPCRM(userProfile);
        		//getCustomerDetailsToUserProfileOAMSIEBEL(userProfile);
        	}
    	/*}
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
          //  try{
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
                	//try{
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
        }
    	catch(Exception e){
    		new SapNetWeaverPage().returnUrl();
    	}
              
    }

    
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
    
}
