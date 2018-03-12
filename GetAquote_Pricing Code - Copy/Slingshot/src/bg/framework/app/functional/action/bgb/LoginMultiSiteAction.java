package bg.framework.app.functional.action.bgb;

import bg.framework.app.functional.entities.RegistrationProfile;
import bg.framework.app.functional.page.bgb.LoginMultiSitePage;
import bg.framework.app.functional.page.bgb.MultiSiteHomePage;
import bg.framework.app.functional.page.bgb.RegistrationPage;
import bg.framework.app.functional.page.bgb.SearchInvoicesPage;
import bg.framework.app.functional.page.bgb.UserAccountPage;

/**
 * Class Name: LoginMultiSiteAction Description: Action to Login Scenarios
 **/
public class LoginMultiSiteAction {
    private RegistrationProfile registrationProfile;

    public LoginMultiSiteAction() {

    }

    public LoginMultiSiteAction(RegistrationProfile registrationProfile) {

	this.registrationProfile = registrationProfile;

    }

    public LoginMultiSiteAction loginPageAction() {
	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage();
	bgLoginPage.verifyLoginPage();
	return this;
    }

    /**
	 * Method Name: login Description: Method to Login the multisite application
     **/
    public LoginMultiSiteAction login() {
	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage();
	bgLoginPage.enterValidCredentials(registrationProfile);
	bgLoginPage.submitCredentialsToLogin();
	return this;
    }

	public LoginMultiSiteAction enterValidCredentialsNew() {
	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage();
		bgLoginPage.enterValidCredentialsNew(registrationProfile);
	bgLoginPage.submitCredentialsToLogin();
	return this;
    }

	public LoginMultiSiteAction loginwithResetPassword() {
	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage();
		bgLoginPage.loginwithResetPassword(registrationProfile);
		// bgLoginPage.submitCredentialsToLogin();
	return this;
    }

    /**
	 * Method Name: login Description: Method to Login the multisite application
     **/
    public LoginMultiSiteAction loginLowerCaseinSensitive() {
	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage();
	bgLoginPage.enterValidLowerCase(registrationProfile);
		bgLoginPage.submitCredentialsToLogin();

	return this;
    }

    /**
	 * Method Name: login Description: Method to Login the multisite application
     **/
    public LoginMultiSiteAction loginUpperCaseinSensitive() {
	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage();
	bgLoginPage.enterValidUpperCase(registrationProfile);
		bgLoginPage.submitCredentialsToLogin();

	return this;
    }

    /**
	 * Method Name: loginLandingPageAction Description: Method to verify Login
     * landing page
     **/
    public LoginMultiSiteAction loginLandingPageAction() {
	UserAccountPage userAccount = new UserAccountPage();
	userAccount.verifyNormalAccount();
	return this;

    }

    /**
	 * Method Name: verifyNormalAccountAction Description: Method to verify
	 * Login landing page
     **/
    public LoginMultiSiteAction verifyNormalAccountAction() {
	UserAccountPage userAccount = new UserAccountPage();
	userAccount.verifyNormalAccount();
	return this;

    }

    /**
	 * Method Name: loginLandingPageAction Description: Method to verify Login
     * landing page
     **/
    public LoginMultiSiteAction verifySuperAccountAction() {
	UserAccountPage userAccount = new UserAccountPage();
	userAccount.verifySuperAccount();
	return this;

    }

    /**
	 * Method Name: checkRememberLogin Description: Method to click on remember
     * my id and then Login
     **/
    public LoginMultiSiteAction checkRememberLogin() {
	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage();
	bgLoginPage.enterValidCredentials(registrationProfile);
	bgLoginPage.checkRememberBox();
	bgLoginPage.submitCredentialsToLogin();
	return this;
    }

    /**
	 * Method Name: clickLogoutAction Description: Method to click on logout
     **/
    public LoginMultiSiteAction clickLogoutAction() {
	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage();
	bgLoginPage.clickLogout();
	return this;
    }

    /**
	 * Method Name: verifyDisabledErrorAction Description: Method to
	 * verifyDisabledUserError
     **/
    public LoginMultiSiteAction verifyDisabledErrorAction() {
	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage();
	bgLoginPage.verifyDisabledUserError();
	return this;
    }

    /**
	 * Method Name: verifyPrePopulatedTextAndLoginAction Description: Method to
	 * verifyPrePopulated email during Login Action
     **/
    public LoginMultiSiteAction verifyPrePopulatedTextAndLoginAction() {
	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage();
	bgLoginPage.verifyPrePopulatedEmail(registrationProfile.getEmail());
	bgLoginPage.enterPassword(registrationProfile.getPassword());
	bgLoginPage.clickLogin();
	return this;

    }

    /**
	 * Method Name: invalidCredentialsAction Description: Method to verify
     * invalidCredentialsAction
     **/
    public LoginMultiSiteAction invalidCredentialsAction() {
		LoginMultiSitePage bgLoginPage = new LoginMultiSitePage(
				registrationProfile);
	bgLoginPage.enterInvalidCredentials();

		// bgLoginPage.accountLock();
	 return this;
    }

    /**
	 * Method Name: navigateToLoginPageAction Description: Method to
     * navigateToLoginPageAction
     **/
    public LoginMultiSiteAction navigateToLoginPageAction() {
	MultiSiteHomePage bgHomePage = new MultiSiteHomePage();
	// LoginMultiSitePage bgLoginPage=bgHomePage.navigateToLoginPage();
	return new LoginMultiSiteAction(registrationProfile);
    }

    /**
	 * Method Name: navigateToLoginPageAction Description: Method to
     * navigateToLoginPageAction
     **/
    public void inactiveuserAction() {
	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage();
	bgLoginPage.enterInactiveuser(registrationProfile);
	// return bgLoginPage;
    }

    public LoginMultiSiteAction normalUserAccountAction() {
	UserAccountPage userAccountPage = new UserAccountPage();
	userAccountPage.verifyNormalAccount();
	return this;
    }

    public LoginMultiSiteAction superUserAccountAction() {
	UserAccountPage userAccountPage = new UserAccountPage();
	userAccountPage.verifySuperAccount();
	return this;
    }

	public LoginMultiSiteAction forgetPasswordInvalidEmailAction(
			String systemDate, String expAuditType) {
	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage();
	bgLoginPage.clickForgetPasswordLink();
		bgLoginPage.enterForgetPasswordInvalidEmail(systemDate, expAuditType);
	return this;

    }

	public LoginMultiSiteAction forgetPasswordvalidEmailAction(
			String systemDate, String expAuditType) {
	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage();
		bgLoginPage.enterForgetPasswordValidEmail(registrationProfile,
				systemDate, expAuditType);

	return this;

    }

    public LoginMultiSiteAction forgetPasswordCancelAction() {
	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage();
	bgLoginPage.clickForgetPasswordLink();
	bgLoginPage.verifyForgetPasswordPage();
	bgLoginPage.clickCancelLink();
	bgLoginPage.clickReturnToLogin();
	bgLoginPage.verifyLoginPage();
	return this;
    }

    public LoginMultiSiteAction forgetPasswordAction() {

	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage(
		registrationProfile);
	bgLoginPage.clickForgetPasswordLink();
	bgLoginPage.verifyForgetPasswordPage();
	bgLoginPage.enterEmailAddress();
		// bgLoginPage.enterPassword(registrationProfile.getPassword());
	bgLoginPage.clickSubmitButton();
	return this;
    }

	public LoginMultiSiteAction verifyInvTempPassAction(String systemDate,
			String expAuditType) {

	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage(
		registrationProfile);

		bgLoginPage.verifyInvTempPassword(registrationProfile, systemDate,
				expAuditType);
	return this;
    }

    public LoginMultiSiteAction tempPasswordSentAction() {

	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage(
		registrationProfile);
	bgLoginPage.verifyTemporaryPasswordSentPage();
	bgLoginPage.resetToTestPassword();

	return this;
    }

	public LoginMultiSiteAction updatePassAction() {
    	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage(
    			registrationProfile);
    	bgLoginPage.resetToTestPassword();
    	return this;
    }

	public LoginMultiSiteAction updateDefPassAction() {
    	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage(
    			registrationProfile);
    	bgLoginPage.resetToDefPassword();
    	return this;
    }

	public LoginMultiSiteAction setNewPasswordAction(String systemDate,
			String expAuditType) {
	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage(
		registrationProfile);
	bgLoginPage.openLoginPage();
	bgLoginPage.enterEmailAddress();
	bgLoginPage.enterPassword(registrationProfile.getConfPassword());
	bgLoginPage.clickLogin();
	bgLoginPage.verifyResetPasswordPage();
	bgLoginPage.setNewPassword();
	bgLoginPage.verifySuccessForgorPasswordPage();
		bgLoginPage.verifyDbResetPass(registrationProfile.getEmail(),
				systemDate, expAuditType);

	return this;
    }

	public LoginMultiSiteAction setNewPassword() {
    	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage(
    			registrationProfile);
		bgLoginPage.setNewPasswordNew();
	return this;
    }

    public LoginMultiSiteAction openLoginPageAction() {
	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage();
	bgLoginPage.openLoginPage();
	return this;
    }

    public LoginMultiSiteAction clickforgotpasswordlink() {
	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage();
	bgLoginPage.clickforgotpasswordlink(registrationProfile);
	return this;
    }

    public LoginMultiSiteAction clickLoginPageAction() {
	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage();
	bgLoginPage.clickLoginHome();
	return this;
    }

   // bgLoginPage.clickLogin();
    public LoginMultiSiteAction changeActiveInDBAction() {
	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage(
		registrationProfile);
	bgLoginPage.changeToActiveUser(registrationProfile.getEmail());
	return this;
    }

    public LoginMultiSiteAction changeDeActiveInDBAction() {
	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage(
		registrationProfile);
	bgLoginPage.changeToDeActiveUser(registrationProfile.getEmail());
	return this;
    }

    public LoginMultiSiteAction verifynameAction() {
	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage(
		registrationProfile);
	bgLoginPage.verifyusername();
	return this;
    }

    public LoginMultiSiteAction resetToTestPasswordAction() {
	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage(
		registrationProfile);
	bgLoginPage.resetToTestPassword();
	return this;
    }

    public void dbVerificationAction(String systemDate) {
	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage(
		registrationProfile);
	bgLoginPage.verifyDatabase(systemDate);
    }

	public LoginMultiSiteAction dbVerifyAction(String systemDate,
			String expAuditType) {
	LoginMultiSitePage bgLoginPage = new LoginMultiSitePage(
		registrationProfile);
		bgLoginPage.verifyDbResetPass(registrationProfile.getEmail(),
				systemDate, expAuditType);
	return this;
    }

    public LoginMultiSiteAction verifySessionLayoutAction() {
		final LoginMultiSitePage bgLoginPage = new LoginMultiSitePage(
				registrationProfile);
        bgLoginPage.verifySessionLayout();
        return this;
    }

    public LoginMultiSiteAction verifySessionLayoutCloseAction() {
		final LoginMultiSitePage bgLoginPage = new LoginMultiSitePage(
				registrationProfile);
        bgLoginPage.verifySessionLayoutClose();
        return this;
    }

    public MyProfileAction navigateToMyProfileAction()  {
		// LoginMultiSitePage bgLoginPage = new LoginMultiSitePage();
		// new
		// PIStubResponseHelper().setupStubResposesTo(stubServiceResponses.get(stubResponseIndex));

        LoginMultiSitePage bgLoginPage = new LoginMultiSitePage();
        bgLoginPage.clickMyProfile();
        return new MyProfileAction(registrationProfile);
    }

}
