package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.page.reFactoring.ChangeEmailPage;
import bg.framework.app.functional.page.reFactoring.ForgotPasswordPage;
import bg.framework.app.functional.page.sales.YourOrderPage;
import bg.framework.app.functional.util.OnlineDBConnector;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 22/02/12
 * Time: 07:43
 * To change this template use File | Settings | File Templates.
 */
public class ForgotPasswordAction {

    public ForgotPasswordAction verifyForgottenPasswordJourney(UserProfile userProfile) {
        new ForgotPasswordPage()
                .validateForgottenPasswordJourney(userProfile);
        return new ForgotPasswordAction();
    }

    public ForgotPasswordAction verifyFieldLevelErrors(UserProfile userProfile) {
        new ForgotPasswordPage()
                .validateErrorMessages(userProfile);
        return this;
    }

    public ForgotPasswordAction validateEmailAddressField(UserProfile userProfile) {
        new ForgotPasswordPage()
                .validateEmailAddressField(userProfile);
        return this;
    }

    public ForgotPasswordAction validateNewPwdAddressField(UserProfile userProfile) {
        ForgotPasswordPage forgotPasswordPage= new ForgotPasswordPage();
                forgotPasswordPage.validateNewPasswordField(userProfile);
                forgotPasswordPage.validateTempPasswordField(userProfile);
        return this;
    }

    public ForgotPasswordAction verifyForgotPwdErrorMsg(UserProfile userProfile) {
        new ForgotPasswordPage()
                .validatePasswordFieldErrorMsg(userProfile);
        return this;
    }

    public ForgotPasswordAction verifyOneTimePwd(UserProfile userProfile) {
        new ForgotPasswordPage()
                .navigateToOneTimePasswordPage(userProfile);

        return this;
    }
    public ForgotPasswordAction verifyLastPassword(UserProfile userProfile) {
        new ForgotPasswordPage()
                .verifyLastPasswordPage(userProfile);

        return this;
    }

    public ForgotPasswordAction validateDirectDebitPwd(UserProfile userProfile) {
        new ForgotPasswordPage()
                .selectDirectDebit(userProfile);
        return this;
    }

    public ForgotPasswordAction navigateToEshopOrderPage(Acquisition acq) {

        new HomePageAction()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple();
        new YourOrderPage()
                .gasSelection(acq);
        new YourOrderPage()
                .elecSelection(acq);
        return this;
    }

    public ForgotPasswordAction navigateToForgottenPasswordScreen() {
        new LegacyLoginPage().navigateToForgottenPassword();
        return new ForgotPasswordAction();
    }
    public ForgotPasswordAction backbuttonchangeEmail() {
        ChangeEmailPage changeEmailpage = new ChangeEmailPage();
        changeEmailpage.verifyBrowserBackbutton();
        return this;
    }
    public LoginAction enterEmailAddress(UserProfile userProfile) {
        ForgotPasswordPage forgotPwd = new ForgotPasswordPage();
        forgotPwd.enterOnlineEmailAddress(userProfile);
        return new LoginAction();

    }

    public ForgotPasswordAction loginandVerifyDetails(UserProfile userProfile){
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.loginUser(userProfile);
        legacyLoginPage.logOut();
       return this;
    }
    
    public ForgotPasswordAction verifyAudit(UserProfile userProfile){
    	ForgotPasswordPage forgotPwd = new ForgotPasswordPage();
    	forgotPwd.verifyAuditEntry(userProfile);
    	return this;
    }
}
