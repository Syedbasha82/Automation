package bg.framework.app.functional.test.Slingshot;

import static bg.framework.app.functional.entities.FunctionalCategory.ForgotPassword;
import static bg.framework.app.functional.entities.FunctionalCategory.Slingshot;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;

import bg.framework.app.functional.action.Slingshot.CustomerServiceAgentAction;
import bg.framework.app.functional.action.Slingshot.ForgotttenPasswordAction;
import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends TestBase{

	@Test(groups ={Slingshot,Regression,ForgotPassword})
	//TC_Forgotten Password_TC002 : To verify whether customer  is able to do forgotten password journey from 'I've Forgotten by email' link present in Login page.
	//TC_Forgotten Password_TC028 : Validate Audit details on successful Forgotten Password journey in Online BGBUSINESS_TA_AUDIT_DETAILS table
	public void verifyForgotPasswordJourney(){
		Report.createTestLogHeader("Forgotten Password Journey", "Verifies a user whether able to do forgotten Password journey and verifies audit details");
		UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");		
		new LoginAction()
		.navigateToBgbLogin() 
		.verifyAndClickForgottenPasswordLink()
		.verifyResetPasswordPageFieldsFP()
		.enterEmail(userProfile)			
		.verifyPasswordRemainderSentPage(userProfile)
		.openResetPasswordLink(userProfile)		
		.enterNewPasswordFields(userProfile)		
		.clickLoginLinkInResetPasswordSuccessPage()
		.verifyPasswordChangeInDB(userProfile)
		.verifyAuditDetails(userProfile)
		.loginWithNewPassword(userProfile)
		.BgbverifyLogin(userProfile)
		.logOut()		
		;
		new ForgotttenPasswordAction().resetToOldPassword(userProfile);
	}

	@Test(groups ={Slingshot,Regression,ForgotPassword})
	//TC_Forgotten Password_TC004 : Verify error is thrown when the user enters invalid mail 
	public void validateErrorMessageForEmailField(){
		Report.createTestLogHeader("Forgotten Password Journey", "Verifies error is thrown when the user enters invalid mail");
		UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");		
		new LoginAction()
		.navigateToBgbLogin() 
		.verifyAndClickForgottenPasswordLinkFP()
		.validateErrorEmailAddressField(userProfile)
		.clickLoginLinkInEmailSentPage()
		;		
	}

	@Test(groups ={Slingshot,Regression,ForgotPassword})
	//TC_Forgotten Password_TC016 : Verify error is thrown when the user enters invalid passwords
	public void validateNewPasswordFieldErrorMessage(){
		Report.createTestLogHeader("Forgotten Password Journey", "Verifies error is thrown when the user enters invalid passwords");
		UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");
		new LoginAction()
		.navigateToBgbLogin() 
		.verifyAndClickForgottenPasswordLinkFP()
		.enterEmail(userProfile)
		.verifyPasswordRemainderSentPage(userProfile)		
		.openResetPasswordLink(userProfile)
		.validateNewPasswordFieldError()
		.clickLoginLinkInEmailSentPage()
		;		
	}

	@Test(groups ={Slingshot,Regression,ForgotPassword})
	//TC_Forgotten Password_TC011 : Verify the content  "Confirmation" tab (Your password has been changed) page of " Password reset" journey
	public void verifyConfirmationPageContent(){
		Report.createTestLogHeader("Forgotten Password Journey", "Verifies the content of your password has been changed and Password reset page");
		UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");
		new LoginAction()
		.navigateToBgbLogin() 
		.verifyAndClickForgottenPasswordLinkFP()
		.enterEmail(userProfile)		
		.verifyPasswordRemainderSentPage(userProfile)		
		.openResetPasswordLink(userProfile)
		.checkLoginAndHelpandServicePromo()
		.enterNewPasswordFields(userProfile)
		.clickLoginLinkInResetPasswordSuccessPage()
		;
		new ForgotttenPasswordAction().resetToOldPassword(userProfile);
	}

	@Test(groups ={Slingshot,Regression,ForgotPassword})
	//TC_Forgotten Password_TC012,TC_Forgotten Password_TC017, TC_Forgotten Password_TC019,TC_Forgotten Password_TC023 : To validate whether the OAM customer can modify the password through 'Forgotten password' link on the login page
	public void forgotPasswordJourneySuccess(){
		Report.createTestLogHeader("Forgotten Password Journey", "Verifies the end to end forgotten password journey");
		UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");		
		new LoginAction()
		.navigateToBgbLogin() 
		.verifyAndClickForgottenPasswordLinkFP()
		.enterEmail(userProfile)
		.verifyPasswordRemainderSentPage(userProfile)
		.openResetPasswordLink(userProfile)		
		.enterNewPasswordFields(userProfile)	
		.verifyPasswordResetSuccessPage()
		.clickLoginLinkInResetPasswordSuccessPage()
		.verifyPasswordChangeInDB(userProfile)
		.verifyAuditDetails(userProfile)
		.loginWithNewPassword(userProfile)
		.BgbverifyLogin(userProfile)	
		.logOut()
		;
		new ForgotttenPasswordAction().resetToOldPassword(userProfile);
	}

	// @Test(groups ={Slingshot,Regression,ForgotPassword})
	//TC_Forgotten Password_TC013,TC_Forgotten Password_TC014 : To validate whether the OAM customer cannot modify the password after 28 days  through 'Forgotten password' Expired link
	public void validateExpiredResetPasswordLink(){
		Report.createTestLogHeader("Forgotten Password Journey", "Verifies whether the customer cannot modify the password after 28 days  through Forgotten password Expired link");
		UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");
		new LoginAction()
		.navigateToBgbLogin() 
		.verifyAndClickForgottenPasswordLinkFP()
		.enterEmail(userProfile)	
		.openResetPasswordLink(userProfile)		
		.enterNewPasswordFields(userProfile)		
		.verifyResetPasswordLinkInvalidPage()
		.clickLoginLinkInEmailSentPage();
		new ForgotttenPasswordAction()
		.resetToOldPassword(userProfile);
	}

	@Test(groups ={Slingshot,Regression,ForgotPassword})
	//TC_Forgotten Password_TC015: To validate whether user is able to reset his/her password by the rest password link sent by the CSA
	public void validateResetPasswordLinkByCSA(){
		Report.createTestLogHeader("Forgotten Password Journey", "Validates whether user is able to reset his or her password by the rest password link sent by the CSA");
		UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");
		new CustomerServiceAgentAction()
		.navigateToCsaRegistration()
		.verifyFindUser(userProfile)
		.verifyEnterNewPassword(userProfile);		

		new ForgotttenPasswordAction()        	
		.openResetPasswordLink(userProfile)	
		.enterNewPasswordFields(userProfile)		
		.verifyPasswordResetSuccessPage()
		.clickLoginLinkInEmailSentPage();
		new ForgotttenPasswordAction().resetToOldPassword(userProfile);
	}

	@Test(groups ={Slingshot,Regression,ForgotPassword})
	//TC_Forgotten Password_TC021 : Verify the "Forgotten password" journey from the link in the error message displayed on Login page when user enters incorrect password
	public void verifyForgetPasswordWithErrorLink(){
		Report.createTestLogHeader("Forgotten Password Journey", "Verifies link in the error message displayed on Login page when user enters incorrect password");
		UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");
		new LoginAction()
		.navigateToBgbLogin() 
		// .EnterInvalidPwd(userProfile)
		.EnterInvalidPassword(userProfile)
		.verifyAndClickForgottenPasswordLink_FP(userProfile)	   	
		.enterEmail(userProfile)		
		.verifyPasswordRemainderSentPage(userProfile)
		.openResetPasswordLink(userProfile)		
		.enterNewPasswordFields(userProfile)		
		.verifyPasswordResetSuccessPage()
		.clickLoginLinkInResetPasswordSuccessPage()
		.verifyPasswordChangeInDB(userProfile)
		.verifyAuditDetails(userProfile)
		.loginWithNewPassword(userProfile)
		.BgbverifyLogin(userProfile)
		.logOut()
		;
		new ForgotttenPasswordAction().resetToOldPassword(userProfile);
	}

	@Test(groups ={Slingshot,Regression,ForgotPassword})
	//TC_Forgotten Password_TC025 : To verify the functionality of back button in Forgotten Password journey 
	public void validateBrowserBackButton(){
		Report.createTestLogHeader("Forgotten Password Journey", "Verifies the functionality of back button in Forgotten Password journey ");
		UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");
		new LoginAction()
		.navigateToBgbLogin() 
		.verifyAndClickForgottenPasswordLinkFP()
		.verifyBrowserBackButton()
		.enterEmail(userProfile)			
		.verifyPasswordRemainderSentPage(userProfile)
		.openResetPasswordLink(userProfile)	
		.verifyBrowserBackButtonInResetPasswordPage()
		.enterNewPasswordFields(userProfile)		
		.verifyPasswordResetSuccessPage()
		.clickLoginLinkInResetPasswordSuccessPage()
		.verifyPasswordChangeInDB(userProfile)
		.verifyAuditDetails(userProfile)
		.loginWithNewPassword(userProfile)
		.BgbverifyLogin(userProfile)
		.logOut()
		;
		new ForgotttenPasswordAction().resetToOldPassword(userProfile);		
	}
	@Test(groups ={Slingshot,Regression,ForgotPassword})
	//TC_Forgotten Password_TC023: Verify whether the user is able to  provide the last used 12 passwords while confirming the new password
	public void verifyLastUsed12PasswordForConfirmingNewPassword(){
		Report.createTestLogHeader("Forgotten Password Journey", "Verify whether the user is able to  provide the last used 12 passwords while confirming the new password");
		UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");

		new LoginAction()
		.navigateToBgbLogin() 
		.verifyAndClickForgottenPasswordLinkFP()
		.enterEmail(userProfile)	
		.openResetPasswordLink(userProfile)
		.verifyNewPasswordForLast12()
		.clickLoginLinkInResetPasswordSuccessPage()
		;
		new ForgotttenPasswordAction().resetToOldPassword(userProfile);
	}
}