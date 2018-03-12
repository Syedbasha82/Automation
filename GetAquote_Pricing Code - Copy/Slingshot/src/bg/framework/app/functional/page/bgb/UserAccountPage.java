package bg.framework.app.functional.page.bgb;

import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

import java.util.Properties;

public class UserAccountPage extends BasePage {
    private final static String FILE_NAME = "resources/bgb/LoginMultiSite.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    public void verifyNormalAccount() {
		String expText_1 = "My profile";
    	String loginDisp_1 = browser.getTextByXpath(pageProperties.getProperty("BGBLogin.PROFILE"));
    	if (loginDisp_1.equalsIgnoreCase(expText_1)){
			
    		Report.updateTestLog("My Profile Link is displayed correctly","PASS");				
		}
		else {
			
			Report.updateTestLog("My Profile Link is not displayed correctly","FAIL");
		} 
    	
		String expText_2 = "Download Invoices";
    	String loginDisp_2 = browser.getTextByXpath(pageProperties.getProperty("BGBLogin.DownloadInvoice"));
    	if (loginDisp_2.equalsIgnoreCase(expText_2)){
			
    		Report.updateTestLog("Download invoices is displayed correctly","PASS");				
		}
		else {
			
			Report.updateTestLog("Download invoices is not displayed correctly","FAIL");
		} 
/*
    	
        if (browser.isTextPresent("Download Invoices")) {

            Report.updateTestLog("Download invoices is displayed correctly", "PASS");
        } else {

            Report.updateTestLog("Download invoices is not displayed correctly", "FAIL");
        }
//		String expText = "Copy bills";
//    	String loginDisp = browser.getTextByXpath(pageProperties.getProperty("BGBLogin.copyText"));
//    	if (loginDisp.equalsIgnoreCase(expText)){
//			
//    		Report.updateTestLog("Copy bills is displayed correctly","PASS");				
//		}
//		else {
//			
//			Report.updateTestLog("Copy bills  is not displayed correctly","FAIL");
//		} 
//    	
//    	
    	String expTextprf = "My profile";
    	String actTextprf = browser.getTextByXpath(pageProperties.getProperty("BGBLogin.myProfileText"));
    	if (browser.isTextPresent(expTextprf)){
			
    		Report.updateTestLog("My profile is displayed correctly","PASS");				
		}
		else {
			
			Report.updateTestLog("My profile  is not displayed correctly","FAIL");
		} 
//    	String expTextMan = "Manage profiles";
//    	String actTextMan = browser.getTextByXpath(pageProperties.getProperty("BGBLogin.managePrfText"));
//    	if (actTextMan.equalsIgnoreCase(expTextMan)){
//			
//    		Report.updateTestLog("Manage profiles is displayed correctly","PASS");				
//		}
//		else {
//			
//			Report.updateTestLog("Login Page  is not displayed correctly","FAIL");
//		} 
//    	String expTextView = "Manage views";
//    	String actTextView = browser.getTextByXpath(pageProperties.getProperty("BGBLogin.manageViewText"));
//    	if (actTextView.equalsIgnoreCase(expTextView)){
//			
//    		Report.updateTestLog("Manage views is displayed correctly","PASS");				
//		}
//		else {
//			
//			Report.updateTestLog("Login Page  is not displayed correctly","FAIL");
//		} 	
*/    }

    public void verifySuperAccount() {

        if (browser.isTextPresent("Download Invoices")) {

            Report.updateTestLog("Download invoices is displayed correctly", "PASS");
        } else {

            Report.updateTestLog("Download invoices  is not displayed correctly", "FAIL");
        }
//		String expText = "Copy bills";
//    	String loginDisp = browser.getTextByXpath(pageProperties.getProperty("BGBLogin.copyText"));
//    	if (loginDisp.equalsIgnoreCase(expText)){
//			
//    		Report.updateTestLog("Copy bills is displayed correctly","PASS");				
//		}
//		else {
//			
//			Report.updateTestLog("Copy bills  is not displayed correctly","FAIL");
//		} 
//    	
//    	
    	String expTextprf = "My profile";
    	//String actTextprf = browser.getTextByXpath(pageProperties.getProperty("BGBLogin.myProfileText"));
    	if (browser.isTextPresent(expTextprf)){
			
    		Report.updateTestLog("My profile is displayed correctly","PASS");				
		}
		else {
			
			Report.updateTestLog("My profile  is not displayed correctly","FAIL");
		} 
    	String expTextMan = "Manage profiles";
    	//String actTextMan = browser.getTextByXpath(pageProperties.getProperty("BGBLogin.managePrfText"));
    	if (browser.isTextPresent(expTextMan)){
			
    		Report.updateTestLog("Manage profiles is displayed correctly","PASS");				
		}
		else {
			
			Report.updateTestLog("Login Page  is not displayed correctly","FAIL");
		} 
    	String expTextView = "Manage views";
    	//String actTextView = browser.getTextByXpath(pageProperties.getProperty("BGBLogin.manageViewText"));
    	if (browser.isTextPresent(expTextView)){
			
    		Report.updateTestLog("Manage views is displayed correctly","PASS");				
		}
		else {
			
			Report.updateTestLog("Login Page  is not displayed correctly","FAIL");
		} 
    }

    public void navigateToContactUsPage() {

    }
}
