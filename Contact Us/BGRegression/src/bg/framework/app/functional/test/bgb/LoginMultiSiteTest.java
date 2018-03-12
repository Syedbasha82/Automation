package bg.framework.app.functional.test.bgb;

import bg.framework.app.functional.action.bgb.LoginMultiSiteAction;
import bg.framework.app.functional.action.bgb.SearchInvoicesAction;
import bg.framework.app.functional.entities.RegistrationProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class LoginMultiSiteTest extends TestBase {
    /*
     * This function makes a normal user to login acount
     * and verifies success page of normal user
     */

    @SuppressWarnings("unchecked")
    // @Test(groups = {RegresBGBMS})
    public void verifyLoginNormalAccount() {
        OnlineDBConnector online = new OnlineDBConnector();
        String systemDate = online.DBsysdate();
        Report.createTestLogHeader("BGB Login", "Multisite Login for Normal user");
        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("Valid");
        new LoginMultiSiteAction(registrationProfile)
                .navigateToLoginPageAction()
                .loginPageAction()
                .login()
                .normalUserAccountAction()
                .dbVerificationAction(systemDate);
        //.loginLandingPageAction();
    }

    /*
          * This function makes a super user to login acount
          * and verifies success page of super user
          */
    @SuppressWarnings("unchecked")
    //@Test(groups = {RegresBGBMS})
    public void verifyLoginSuperAccount() {
        String logPath = null;
        OnlineDBConnector online = new OnlineDBConnector();
        String systemDate = online.DBsysdate();
        //System.out.println(logPath);
        Report.createTestLogHeader("BGB Login", "Multisite Login for Super user");

        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("Valid");
        new LoginMultiSiteAction(registrationProfile)
                .navigateToLoginPageAction()
                .loginPageAction()
                .login()
                .superUserAccountAction()
                .loginLandingPageAction()
                .dbVerificationAction(systemDate);
    }

    /*
    * This function makes a super user to login acount
    * and verifies success page of super user
    */
    @SuppressWarnings("unchecked")
    // @Test(groups = {RegresBGBMS})
    public void loginvalid() {

        Report.createTestLogHeader("BGB Login", "Multisite Login for Login valid");

        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("Valid");
        new LoginMultiSiteAction(registrationProfile)
                .navigateToLoginPageAction()
                .loginPageAction()
                .loginLowerCaseinSensitive()
                .normalUserAccountAction()
                .verifynameAction()
                .clickLogoutAction()
                .loginUpperCaseinSensitive()
                .normalUserAccountAction()
                .verifynameAction();
    }

    /*
          * This function enters In valid login details for 4 times
          * and verifies account account lock message
          */
//    @SuppressWarnings("unchecked")
   // @Test(groups = {RegresBGBMS})
    public void accountLock() {
	OnlineDBConnector online = new OnlineDBConnector();
	 String systemDate = online.DBsysdate();
	 String expAuditType = "ACCOUNT_LOCK";
        Report.createTestLogHeader("BGB Login", "Multisite Login for account lock scenario");
        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("Valid");
        new LoginMultiSiteAction(registrationProfile)
                .navigateToLoginPageAction()
                .loginPageAction()
                .invalidCredentialsAction();
                //.dbVerifyAction(systemDate, expAuditType);
                
    }
//
//    /*
//          * This function enters In-Active user's login details
//          * and verifies error message of In-Active user
//          */
//    @SuppressWarnings("unchecked")
//		@Test(groups = {RegresBGBMS})
//    public void verifyinactiveuser() {
//        Report.createTestLogHeader("BGB Login", "Multisite Login for inactive user");
//        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("inactiveuser");
//        new LoginMultiSiteAction(registrationProfile).inactiveuserAction();
//
//    }

    @SuppressWarnings("unchecked")
   // @Test(groups = {RegresBGBMS})
    public void rememberLogin() {
        Report.createTestLogHeader("BGB Login", "Multisite Login for remember my id ");
        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("Valid");
        new LoginMultiSiteAction(registrationProfile)
                .navigateToLoginPageAction()
                .loginPageAction()
                .checkRememberLogin()
                .clickLogoutAction()
                .clickLoginPageAction()
                .verifyPrePopulatedTextAndLoginAction()
                .clickLogoutAction();
    }

    @SuppressWarnings("unchecked")
    //@Test(groups = {RegresBGBMS})
    public void disabledUserLogin() {
        Report.createTestLogHeader("BGB Login", "Multisite Login for disbaled user");
        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("Valid");
        new LoginMultiSiteAction(registrationProfile)
                .navigateToLoginPageAction()
                .loginPageAction()
                .login()
                .loginLandingPageAction()
                .changeDeActiveInDBAction()
                .clickLogoutAction()
                .openLoginPageAction()
                .login()
                .verifyDisabledErrorAction()
                .changeActiveInDBAction();
    }

    @SuppressWarnings("unchecked")
  //  @Test(groups = {RegresBGBMS})
    public void forgetPasswordEmailInvalidValidation() {
	OnlineDBConnector online = new OnlineDBConnector();
	 String systemDate = online.DBsysdate();
	 String expAuditType = "TEMP_PASS_FAILURE_NONEXISTENT_USER";
        Report.createTestLogHeader("BGB Login", "Multisite Forgot Password InValid");
        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("Valid");
        new LoginMultiSiteAction(registrationProfile)
                .navigateToLoginPageAction()
                .loginPageAction()
                .forgetPasswordInvalidEmailAction(systemDate,expAuditType);

    }	

    @SuppressWarnings("unchecked")
//    @Test(groups = {RegresBGBMS})
    public void forgetPasswordEmailvalidValidation() {
	OnlineDBConnector online = new OnlineDBConnector();
	 String systemDate = online.DBsysdate();
	 String expAuditType1 = "TEMP_PASS_GENERATED";
	 String expAuditType2 = "PASSWORD_RESET_SUCCESS";
        Report.createTestLogHeader("BGB Login", "Multisite Forgot Password Valid");
        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("Valid");
        new LoginMultiSiteAction(registrationProfile)
                .navigateToLoginPageAction()
                .loginPageAction()
                .forgetPasswordvalidEmailAction(systemDate,expAuditType1)
                .resetToTestPasswordAction()
                .setNewPasswordAction(systemDate,expAuditType2)
                .login()
                .loginLandingPageAction()
                .clickLogoutAction();


    }

    @SuppressWarnings("unchecked")
    //@Test(groups = {RegresBGBMS})
    public void forgetPasswordCancel() {
        Report.createTestLogHeader("BGB Login", "Multisite Login for forgot password cancel");
        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("normal");

        new LoginMultiSiteAction(registrationProfile)
                .navigateToLoginPageAction()
                .loginPageAction()
                .forgetPasswordCancelAction();
    }

    @SuppressWarnings("unchecked")
   // @Test(groups = {RegresBGBMS})
    public void forgetPasswordEndToEnd() {
	OnlineDBConnector online = new OnlineDBConnector();
	 String systemDate = online.DBsysdate();
	// String expAuditType1 = "TEMP_PASS_GENERATED";
	 String expAuditType2 = "PASSWORD_RESET_SUCCESS";
        Report.createTestLogHeader("BGB Login", "Multisite Forgot Password End to End");
        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("Valid");
        new LoginMultiSiteAction(registrationProfile)
                .navigateToLoginPageAction()
                .loginPageAction()
                .forgetPasswordAction()
                .tempPasswordSentAction()
                .setNewPasswordAction(systemDate,expAuditType2)
                //.updatePassAction()
                .login()
                .loginLandingPageAction()
        		//.updatePassAction()
        		.clickLogoutAction();
    }

    @SuppressWarnings("unchecked")
//     @Test(groups = {RegresBGBMS})
    public void forgetPasswordValidateErrorMsg() {
	OnlineDBConnector online = new OnlineDBConnector();
	 String systemDate = online.DBsysdate();
	 String expAuditType1 = "PASSWORD_RESET_FAILURE";
	 String expAuditType2 = "PASSWORD_RESET_SUCCESS";
        Report.createTestLogHeader("BGB Login", "Multisite Forgot Password error message validations");
        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("Valid");
        new LoginMultiSiteAction(registrationProfile)
                .navigateToLoginPageAction()
                .loginPageAction()
                .forgetPasswordAction()
                .tempPasswordSentAction()
                .verifyInvTempPassAction(systemDate,expAuditType1)
                .setNewPasswordAction(systemDate,expAuditType2)
               // .updatePassAction()
                .login()
                .loginLandingPageAction();
    }

    @SuppressWarnings("unchecked")
    //@Test(groups = {RegresBGBMS})
    public void searchInvoicesSessionLayout() {
        Report.createTestLogHeader("BGB SearchInvoices", "Multisite searchInvoicesSessionLayout");
        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("Valid");
        LoginMultiSiteAction login = new LoginMultiSiteAction(registrationProfile);
        SearchInvoicesAction search = new SearchInvoicesAction(registrationProfile);
        login.login();
        search.enterAllSearchDetailsAction().verifyResultsAction();
        login.verifySessionLayoutAction().loginLandingPageAction();
        search.verifyResultsAction();

    }

    @SuppressWarnings("unchecked")
    // @Test(groups = {RegresBGBMS})
    public void searchInvoicesSessionLayoutCancel() {
        Report.createTestLogHeader("BGB SearchInvoices", "Multisite searchInvoicesSessionLayout");
        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("Valid");
        new LoginMultiSiteAction(registrationProfile)

                .login()
                .verifySessionLayoutCloseAction();

    }
}

