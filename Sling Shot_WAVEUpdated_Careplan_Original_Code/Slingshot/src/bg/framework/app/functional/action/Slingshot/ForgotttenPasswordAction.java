package bg.framework.app.functional.action.Slingshot;


import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.Slingshot.ForgotPasswordPage;

public class ForgotttenPasswordAction {

	public ForgotttenPasswordAction openForgottenPasswordUrl(){
		ForgotPasswordPage forgotPasswordpage = new ForgotPasswordPage();
		//forgotPasswordpage.openForgottenPasswordUrl();
		return new ForgotttenPasswordAction();	
	}
	public ForgotttenPasswordAction enterEmail(UserProfile userProfile){
		ForgotPasswordPage forgotPasswordpage = new ForgotPasswordPage();
		forgotPasswordpage.verifyPageTitle();
		forgotPasswordpage.enterEmail(userProfile.getEmail());
		forgotPasswordpage.clickContinueButton();
		return new ForgotttenPasswordAction();	
	}
	public ForgotttenPasswordAction clickContinueButton(UserProfile userProfile){
		ForgotPasswordPage forgotPasswordpage = new ForgotPasswordPage();
		forgotPasswordpage.clickContinueButton();
		return new ForgotttenPasswordAction();	
	}
	public ForgotttenPasswordAction verifyPasswordRemainderSentPage(UserProfile userProfile){
		ForgotPasswordPage forgotPasswordpage = new ForgotPasswordPage();
		forgotPasswordpage.verifyPasswordRemainderSentPage(userProfile);
		return new ForgotttenPasswordAction();	
	}
	public ForgotttenPasswordAction openResetPasswordLink(UserProfile userProfile){
		ForgotPasswordPage forgotPasswordpage = new ForgotPasswordPage();
		//forgotPasswordpage.clickHomePageLink();
		forgotPasswordpage.openResetPasswordUrl();
		return new ForgotttenPasswordAction();	
	}
	public ForgotttenPasswordAction openResetPasswordUrl(UserProfile userProfile){
		ForgotPasswordPage forgotPasswordpage = new ForgotPasswordPage();
		forgotPasswordpage.openResetPasswordUrl();
		return new ForgotttenPasswordAction();	
	}

	public ForgotttenPasswordAction enterNewPasswordFields(UserProfile userProfile){
		ForgotPasswordPage forgotPasswordpage = new ForgotPasswordPage();
		forgotPasswordpage.enterNewPasswordFields(userProfile.getNewPassword(),userProfile.getNewPassword());
		return new ForgotttenPasswordAction();	
	}	
	public ForgotttenPasswordAction clickLoginLinkInResetPasswordSuccessPage(){		
		ForgotPasswordPage forgotPasswordpage = new ForgotPasswordPage();		
		forgotPasswordpage.clickLoginLinkInResetPasswordSuccessPage();
		return new ForgotttenPasswordAction();	
	}
	public LoginAction verifyAuditDetails(UserProfile userProfile){
		ForgotPasswordPage forgotPasswordpage = new ForgotPasswordPage();
		forgotPasswordpage.verifyAuditDetails(userProfile);		
		return new LoginAction();	
	}	
	public LoginAction resetToOldPassword(UserProfile userProfile){
		ForgotPasswordPage forgotPasswordpage = new ForgotPasswordPage();
		forgotPasswordpage.resetToOldPassword(userProfile);		
		return new LoginAction();	
	}
	public ForgotttenPasswordAction checkLoginAndHelpandServicePromo(){		
		ForgotPasswordPage forgotPasswordpage = new ForgotPasswordPage();
		forgotPasswordpage.checkLoginAndHelpandServicePromo();		
		return new ForgotttenPasswordAction();	
	}

	public ForgotttenPasswordAction verifyPasswordResetSuccessPage(){		
		ForgotPasswordPage forgotPasswordpage = new ForgotPasswordPage();
		forgotPasswordpage.verifyPasswordResetSuccessPage();		
		return new ForgotttenPasswordAction();	
	}
	public ForgotttenPasswordAction verifyResetPasswordLinkInvalidPage(){		
		ForgotPasswordPage forgotPasswordpage = new ForgotPasswordPage();
		forgotPasswordpage.verifyResetPasswordLinkInvalidPage();		
		return new ForgotttenPasswordAction();	
	}

	public ForgotttenPasswordAction verifyPasswordChangeInDB(UserProfile userProfile){		
		ForgotPasswordPage forgotPasswordpage = new ForgotPasswordPage();
		forgotPasswordpage.verifyPasswordChangeInDB(userProfile);		
		return new ForgotttenPasswordAction();	
	}
	public ForgotttenPasswordAction verifyBrowserBackButton(){		
		ForgotPasswordPage forgotPasswordpage = new ForgotPasswordPage();
		//forgotPasswordpage.verifyPageTitle("Password reset");
		forgotPasswordpage.verifyBrowserBackButton();
		forgotPasswordpage.verifyPageTitle("Reset your password");	
		return new ForgotttenPasswordAction();	
	}
	public ForgotttenPasswordAction verifyBrowserBackButtonInResetPasswordPage(){		
		ForgotPasswordPage forgotPasswordpage = new ForgotPasswordPage();
		forgotPasswordpage.verifyPageTitle("Reset your password");
		forgotPasswordpage.verifyBrowserBackButton();
		//forgotPasswordpage.verifyPageTitle("Reset your password");
		return new ForgotttenPasswordAction();	
	}
	public ForgotttenPasswordAction validateNewPasswordField(UserProfile userProfile){		
		ForgotPasswordPage forgotPasswordpage = new ForgotPasswordPage();
		forgotPasswordpage.validateNewPasswordField();		
		return new ForgotttenPasswordAction();
	}
	public ForgotttenPasswordAction validateErrorEmailAddressField(UserProfile userProfile){		
		ForgotPasswordPage forgotPasswordpage = new ForgotPasswordPage();
		forgotPasswordpage.validateEmailAddressField(userProfile);		
		return new ForgotttenPasswordAction();
	}
	public ForgotttenPasswordAction validateNewPasswordFieldError(){		
		ForgotPasswordPage forgotPasswordpage = new ForgotPasswordPage();
		forgotPasswordpage.validateNewPasswordField();		
		return new ForgotttenPasswordAction();
	}

	public ForgotttenPasswordAction verifyNewPasswordForLast12(){		
		ForgotPasswordPage forgotPasswordpage = new ForgotPasswordPage();
		forgotPasswordpage.verifyNewPasswordForLast12();		
		return new ForgotttenPasswordAction();
	}
	public ForgotttenPasswordAction clickLoginLinkInEmailSentPage(){		
		ForgotPasswordPage forgotPasswordpage = new ForgotPasswordPage();		
		forgotPasswordpage.clickLoginLinkInEmailSentPage();
		return new ForgotttenPasswordAction();	
	}
	public ForgotttenPasswordAction logOut() {
		ForgotPasswordPage forgotPasswordpage = new ForgotPasswordPage();		
		forgotPasswordpage.logout();
		return new ForgotttenPasswordAction();
	}
}
