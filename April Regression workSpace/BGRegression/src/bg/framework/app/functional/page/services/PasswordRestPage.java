package bg.framework.app.functional.page.services;

import java.util.Properties;

import com.gargoylesoftware.htmlunit.Page;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class PasswordRestPage extends BasePage{
	private final static String FILE_NAME="resources/services/PasswordReset.properties";
	private static Properties pageProperties=new PropertyLoader(FILE_NAME).load();
	
	
	 public void navigateToOneTimePasswordPage(UserProfile userProfile) {
	    	final String emailAddress = new OnlineDBConnector().getUserEmail(userProfile.getUCRN());
	    	final String dbPwd = new OnlineDBConnector().getPassword(userProfile.getUCRN());
	    	final String pwd = "password12";
	    	browser.wait(1000);
	    	enterEmailAddress(userProfile,emailAddress);
	    	new OnlineDBConnector().updateOneTimePassword(userProfile.getUCRN(),dbPwd);
	    	    	
	    	
	    		browser.open(ApplicationConfig.APP_BG_URL
				        + "/Password-Reset/Password-Temporary-Entry/"+emailAddress+"/1/"+pwd+"/");

			
	    	browser.wait(getWaitTime());
			enterTemporaryPwd("","password8");
	        verifyBrowserBackbutton();
	        new OnlineDBConnector().updateOneTimePassword(userProfile.getUCRN(),dbPwd);
	        verifyIsTextPresent(pageProperties.getProperty("ForgottenPassword.PasswordResetSuccess"));
	        verifyAndClickWithXpath(pageProperties.getProperty("ForgottenPassword.AccountLoginID"),"AccountLogin");
	        browser.wait(getWaitTime());

		}
	 
	 public void enterEmailAddress(UserProfile userProfile,String emailAddress) {

	    	verifyAndInputById(pageProperties.getProperty("ForgottenPassword.EmailIDField"), "Customer Email Address", emailAddress);
	        verifyAndClickWithXpath(pageProperties.getProperty("ForgottenPassword.ContinueButton"), "Continue Button");
	        browser.wait(1000);
	        Report.updateTestLog("Email is triggered to reset your Password ","PASS");
	      }
	 
	 public void enterTemporaryPwd(String tempPwd,String newPwd){
	    	verifyAndInputByXpath(pageProperties.getProperty("ForgottenPassword.NewPassword"), "New Password", newPwd);
	        verifyAndInputById(pageProperties.getProperty("ForgottenPassword.ConfirmPassword"), "ReEnter New Password", newPwd);
	        verifyAndClickWithName(pageProperties.getProperty("ForgottenPassword.PasswordSubmitButton"), "Submit Temporary Password Button");
	        browser.wait(getWaitTime());
	        browser.wait(1000);
	        //verifyIsTextPresent(pageProperties.getProperty("ForgottenPassword.PasswordResetConfirmation"));

	    }
	 
	 public void verifyBrowserBackbutton(){
	        browser.browserBack();
	        getWaitTime();
	        if (browser.isElementVisible(pageProperties.getProperty("ForgottenPassword.PasswordSubmitButton"))){
	           Report.updateTestLog("Browser Back Button is not working as expected","FAIL");
	        } else {
	            Report.updateTestLog("Browser Back Button is working as expected","PASS");
	        }
	    }

}
