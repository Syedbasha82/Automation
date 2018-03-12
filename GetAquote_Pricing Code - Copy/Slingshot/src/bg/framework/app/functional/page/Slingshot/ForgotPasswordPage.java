package bg.framework.app.functional.page.Slingshot;

import java.util.Properties;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.SlingshotErrorMessages;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;


/**
 ClassName: ForgotPasswordPage
 Description: To verify Forgotten Password journey
 */
public class ForgotPasswordPage extends BasePage {
	private final static int password_Link_Sent_Success= 55; 
	private final static int password_Link_Sent_Failure= 55;
	
	
	 private final static String FILE_NAME = "resources/Slingshot/ForgottenPassword.properties";
	 private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	 
	
	public void verifyResetYourPasswordPage(){
		
	}
	public void verifyPageTitle(){
		verifyPageTitle(pageProperties.getProperty("ForgottenPasswordPage.Title"));
	}
	public void enterEmail(String email){		
		if(verifyIsTextPresent(pageProperties.getProperty("ForgottenPasswordPage.Header"))){
			verifyAndInputById(pageProperties.getProperty("ForgottenPasswordPage.EmailFieldId"), "Email Address",email );
		}
		else{
			Report.updateTestLog("'Reset your password' page verification is done", "FAIL");
		}
	}
	
	public void clickContinueButton(){
		verifyAndClickWithXpath(pageProperties.getProperty("ForgottenPasswordPage.ContinueButtonXpath"), "Continue button");
		browser.wait(getWaitTime());
	}
	
	public void verifyPasswordRemainderSentPage(UserProfile userProfile){
		verifyPageTitle(pageProperties.getProperty("ForgottenPasswordPage.PasswordRemainderSentHeader"));
		Report.updateTestLog("Password reset link sent to "+userProfile.getEmail(),"PASS");
		//verifyIsTextPresent(pageProperties.getProperty("ForgottenPasswordPage.BusinessHomeLink"));
	}
	public void clickHomePageLink(){
		verifyAndClickWithXpath(pageProperties.getProperty("ForgottenPasswordPage.BusinessHomeLink"), "British Gas Business home link");
		browser.wait(getWaitTime());
	}
	public void openResetPasswordUrl(){		
		//browser.open("https://10.224.70.18/business/new-password");
		browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("ForgottenPasswordPage.NewPasswordUrl"));
		//browser.openTab(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("ForgottenPasswordPage.NewPasswordUrl"));
		browser.wait(getWaitTime());
		//verifyPageTitle(pageProperties.getProperty("ForgottenPasswordPage.PasswordResetHeader"));
	}
	public void enterNewPasswordFields(String newPwd,String confirmNewPwd){
		verifyAndInputById(pageProperties.getProperty("ForgottenPasswordPage.NewPassword"), "New password ",newPwd);
		verifyAndInputById(pageProperties.getProperty("ForgottenPasswordPage.ConfirmNewPassword"), "Confirm New password ",confirmNewPwd);
		verifyAndClickWithXpath(pageProperties.getProperty("ForgottenPasswordPage.ContinueButtonXpath"), "Continue Button");
		browser.wait(getWaitTime());
	}
	public void verifyPasswordResetSuccessPage(){
		verifyPageTitle("Password reset confirmation");
		verifyIsTextPresent(pageProperties.getProperty("ForgottenPasswordPage.PasswordResetSuccessHeader"), "Password reset success message ");
		//verifyIsTextPresent(pageProperties.getProperty("ForgottenPasswordPage.PasswordChangeSuccess"), "Security text");
	}
	public void clickLoginLinkInResetPasswordSuccessPage(){		
		verifyAndClickWithXpath(pageProperties.getProperty("ForgottenPasswordPage.LoginLink"), "Login link");
		browser.wait(getWaitTime());
		verifyPageTitle("Log in to your account");
	}
	public void verifyAuditDetails(final UserProfile userProfile) {     	
		OnlineDBConnector dbfunctions = new OnlineDBConnector();       
	    String sysDate = dbfunctions.DBsysdateDdmmyyhhmi();            
	    System.out.println(dbfunctions.getAuditTypeIdMs(userProfile.getEmail(), sysDate,password_Link_Sent_Success));
	    int getAudittype=dbfunctions.getAuditTypeIdMs(userProfile.getEmail(), sysDate, password_Link_Sent_Success);
	    if(getAudittype>=1){
	      Report.updateTestLog("Audit entry is made as expected: "+password_Link_Sent_Success, "PASS");
	      
	    }else{
	    	Report.updateTestLog("Audit entry is made as expected: "+password_Link_Sent_Success, "FAIL");
	    }
	} 
	
	public void resetToOldPassword(UserProfile userProfile){
		OnlineDBConnector dbfunctions = new OnlineDBConnector();
		dbfunctions.passwordreset(userProfile.getEmail());
	}
	 
    public void validateEmailAddressField(UserProfile userProfile){
    	String[] emailAddr= {"","ganthimani.s@ganthimani.s@cognizant.com","chithraqwertyqwertyqwertyqwertyqwertyqweq@bgdigitaltal.co.uk","ganthimani.ssss@cognizant.com"};
    	    	for(int i = 0; i<emailAddr.length;i++){
    		switch(i){
    		case 0:
    			enterEmail(emailAddr[i]);
    			clickContinueButton();
    			errorMessageComparison(SlingshotErrorMessages.slingshot_FP_EmptyEmail);
    			break;
    		case 1:
    			enterEmail(emailAddr[i]);
    			clickContinueButton();
    			errorMessageComparison(SlingshotErrorMessages.slingshot_FP_InvalidEmail);
    			break;
    		case 2:
    			enterEmail(emailAddr[i]);
    			clickContinueButton();
    			errorMessageComparison(SlingshotErrorMessages.slingshot_FP_InaccurateLengthEmail);
    			break;
    		case 3:
    			enterEmail(emailAddr[i]);
    			clickContinueButton();
    			errorMessageComparison(SlingshotErrorMessages.slingshot_FP_EmailNotInDB);
    			break;
    		}
    	}
    }   
    
    //Capture the error message displayed and verify the actual and error message displayed by making a call to the verifyErrorMessage method
    public void errorMessageComparison(final String expectedErrorMsg) {
    	try{
        final String displayedErrorMsg = browser.getTextByXpath(pageProperties.getProperty("ForgottenPasswordPage.ErrorList"));
        verifyErrorMessage(displayedErrorMsg, expectedErrorMsg);
    	}
    	catch(Exception e){
    		Report.updateTestLog("Exception occured. Check password entered", "FAIL");
    	}
    }
    	 
     public void verifyErrorMessage(final String displayedErrorMsg, final String expectedErrorMsg) {
    	 System.out.println(displayedErrorMsg);
    	 System.out.println(expectedErrorMsg);
         if (displayedErrorMsg.trim().contains(expectedErrorMsg.trim())) {
             Report.updateTestLog("Expected error message was displyed. Expected error message:" + expectedErrorMsg +"Actual error message:"+displayedErrorMsg, "PASS");
         } else {
             Report.updateTestLog("Expected error message was displyed. Expected error message:" + expectedErrorMsg +"Actual error message:"+displayedErrorMsg, "FAIL");
         }
     }   
     
     public void checkLoginAndHelpandServicePromo(){
    	 verifyIsElementVisibleWithXpath(pageProperties.getProperty("ForgottenPasswordPage.LoginPromo"), "Login promo");
    	 verifyIsElementVisibleWithXpath(pageProperties.getProperty("ForgottenPasswordPage.LoginLinkInRHSPromo"), "Login link");
    	 verifyIsElementVisibleWithXpath(pageProperties.getProperty("ForgottenPasswordPage.HelpAndAdvice"), "Help & Advice");
    	 verifyIsElementVisibleWithXpath(pageProperties.getProperty("ForgottenPasswordPage.ForgotEmailLinkInRHS"), "Forgot email link");
    	 verifyIsElementVisibleWithXpath(pageProperties.getProperty("ForgottenPasswordPage.ChangeEmailLink"), "Change email link");
    	    	 
     }
     
     public void verifyResetPasswordLinkInvalidPage(){
    	 try{
    	 browser.isTextPresent(pageProperties.getProperty("ForgottenPasswordPage.ResetPasswordLinkInvalidPageTitle"));
    	 verifyPageTitle(pageProperties.getProperty("ForgottenPasswordPage.ResetPasswordLinkInvalidPageTitle"));
    	 verifyIsElementVisibleWithXpath(pageProperties.getProperty("ForgottenPasswordPage.ResetPasswordInvalid"), "Reset password link invalid header");
    	 verifyIsElementVisibleWithXpath(pageProperties.getProperty("ForgottenPasswordPage.SendPasswordResetLink"), "Send password reset link");
    	 }
    	 catch(Exception e)
    	 {    		
    	 Report.updateTestLog("Exception occured : "+ e, "FAIL");
    	 }
    	 }
     public void verifyPasswordChangeInDB(UserProfile userProfile){
    	 OnlineDBConnector db = new OnlineDBConnector();
    	 db.verifyPasswordChange(userProfile.getEmail());
     }
     
     public void verifyBrowserBackButton(){
    	 if(browser.getTitle().equalsIgnoreCase("Reset your password")){
    	 browser.browserBack(); 
    	 browser.wait(getWaitTime());
    	 }
     }
     public void verifyYourAccountPage(){
    	 verifyPageTitle("Log in to your account");
    	 browser.isTextPresent("Your Account");
     }
     public void validateNewPasswordField(){

     	String[] newPassword= {"","temp12","temp1234temp1234temp1234temp123456","temp1234*!@&$12"};
     	String[] confirmNewPassword = {"","temp12","temp1234temp1234temp1234temp123456","temp1234*!@&$12"};

     	for(int i = 0; i<newPassword.length;i++){
     		switch(i){
     		case 0:
     			enterNewPasswordFields(newPassword[i],confirmNewPassword[i]);
     			errorMessageComparison(SlingshotErrorMessages.SlingShot_EmptyPassword);
     			break;
     		case 1:
     			enterNewPasswordFields(newPassword[i],confirmNewPassword[i]);
     			errorMessageComparison(SlingshotErrorMessages.SlingShot_IncorrectPassword);
     			break;
     		case 2:
     			/*enterNewPasswordFields(newPassword[i],confirmNewPassword[i]);
     			errorMessageComparison(SlingshotErrorMessages.SlingShot_Passwordmorethan32Chars);*/
     			break;  
     		case 3:
     			/*enterNewPasswordFields(newPassword[i],confirmNewPassword[i]);
     			errorMessageComparison(SlingshotErrorMessages.SlingShot_PasswordWithSplChars);*/
     			break;  
     		}
     	}
     }
     
     public void verifyNewPasswordForLast12(){
    	 String[] newPassword = {"password1","password2","password3", "password4","password5","password6","password7"};
    	 String[] confirmNewPassword = {"password1","password2","password3", "password4","password5","password6","password7"};
    	 for(int i=0; i<newPassword.length;i++){
    		 enterNewPasswordFields(newPassword[i], confirmNewPassword[i]);
    		 verifyPasswordResetSuccessPage();
    		 openResetPasswordUrl();
    	 }
    	 enterNewPasswordFields(newPassword[4], confirmNewPassword[4]);
    	 verifyPasswordResetSuccessPageForLast12UsedPasswords();    	 
     }
 	public void verifyPasswordResetSuccessPageForLast12UsedPasswords(){
		verifyPageTitle("Password reset confirmation");
		verifyIsTextPresent(pageProperties.getProperty("ForgottenPasswordPage.PasswordResetSuccessHeader"), "Password reset success message ");
		Report.updateTestLog("User is able to  provide the last used 12 passwords while confirming the new password", "PASS");
	}
 	public void clickLoginLinkInEmailSentPage(){		
		verifyAndClickWithXpath(pageProperties.getProperty("ForgottenPasswordPage.LoginLinkInMailSentPage"), "Login link");
		browser.wait(getWaitTime());
	}
 	 public void logout(){
     	verifyAndClickWithXpath(pageProperties.getProperty("AccountSummary.Logout"), "Log out link");
     	//verifyIsTextPresent("You're now logged out of your account");
     	verifyPageTitle("Log in to your account");
     }
}
