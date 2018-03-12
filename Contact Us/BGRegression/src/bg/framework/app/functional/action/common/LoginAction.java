package bg.framework.app.functional.action.common;



import java.util.ArrayList;

import bg.framework.app.functional.action.reFactoring.EssCallBackAction;
import bg.framework.app.functional.action.reFactoring.ForgotEmailAction;
import bg.framework.app.functional.action.reFactoring.ForgotPasswordAction;
import bg.framework.app.functional.action.reFactoring.PaymentHistoryAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.action.selfServe.ChangeEmailAction;
import bg.framework.app.functional.action.selfServe.ContactUsAction;
import bg.framework.app.functional.action.reFactoring.AccOverviewAction;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.LegacyHomePage;
import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.page.reFactoring.ESSCallBackPage;
import bg.framework.app.functional.page.reFactoring.PaymentHistoryPage;
import bg.framework.app.functional.page.reFactoring.SmartMonthlyBillingPage;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 25/01/12
 * Time: 15:43
 * To change this template use File | Settings | File Templates.
 */
public class LoginAction {

    public AccountOverviewAction login(UserProfile userProfile) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.loginUser(userProfile);
        return new AccountOverviewAction(userProfile);
    }

    public AccountOverviewAction loginSMB(UserProfile userProfile) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.loginUserSMB(userProfile);
        return new AccountOverviewAction(userProfile);
    }
    public AccountOverviewAction loginSMBNegative(UserProfile userProfile) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.loginUserSMBNegative(userProfile);
        return new AccountOverviewAction(userProfile);
    }
    public ContactUsAction loginUserAutoDirectToContactUsPage(UserProfile userProfile) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.loginUserAutoDirectToContactUsPage(userProfile);
        return new ContactUsAction(userProfile);
    }
    public LoginAction navigateToSMBnegativetemp(ArrayList<String> errList) {
        SmartMonthlyBillingPage SMBHomePage = new SmartMonthlyBillingPage();
        SMBHomePage.navigateToSMBnegativetemp(errList);
        return new LoginAction();
    }

    public ChangeEmailAction navigateToChangeEmailAddressScreen() {
        new LegacyLoginPage().navigateToChangeEmailAddress();
        return new ChangeEmailAction();
    }

    public ForgotEmailAction navigateToForgottenEmailAddressScreen() {
        new LegacyLoginPage().navigateToForgottenEmailAddress();
        return new ForgotEmailAction();
    }

    public ForgotEmailAction navigatetoForgotEmailPage() {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.navigatetoForgotEmailPage();
        return new ForgotEmailAction();
    }

    public ForgotEmailAction navigatetoForgotEmailViaForgotPassScreen() {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.navigatetoForgotEmailViaForgotPassword();
        return new ForgotEmailAction();
    }

    public LoginAction verifyLockedAccount(UserProfile userProfile) {
        LegacyLoginPage loginPage = new LegacyLoginPage();
        loginPage.verifyAccountLock(userProfile);
        return this;
    }

    public AccountOverviewAction loginErrorValidation(UserProfile userProfiles) {
        LegacyLoginPage loginPage = new LegacyLoginPage();
        loginPage.loginErrorValidation(userProfiles);
        return new AccountOverviewAction();
    }

    public AccountOverviewAction loginErrorForFreezedAccount(UserProfile userProfiles) {
        LegacyLoginPage loginPage = new LegacyLoginPage();
        loginPage.loginErrorForFreezedAccount(userProfiles);
        return new AccountOverviewAction();
    }
    
    public LoginAction loginForInactiveAccount(UserProfile userProfile) {
        LegacyLoginPage loginPage = new LegacyLoginPage();
        loginPage.loginForInactiveAccount(userProfile);
        return this;
    }

    public LoginAction emailCheckBoxVerification(UserProfile userProfile) {
        LegacyLoginPage loginPage = new LegacyLoginPage();
        loginPage.emailCheckBoxVerification(userProfile);
        return this;
    }

    public ForgotPasswordAction navigateToForgottenPasswordScreen() {
        new LegacyLoginPage().navigateToForgottenPassword();
        return new ForgotPasswordAction();
    }
    public LoginAction loginUser(UserProfile userProfile) {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToLoginPage();
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.loginUser(userProfile);
        return new LoginAction();
    }
    public EssCallBackAction navigateToRequestCallBackPage(){
        ESSCallBackPage essCallBackPage = new ESSCallBackPage();
        essCallBackPage.navigateToRequestCallBackPage();
        return new EssCallBackAction();
    }
    public AccountOverviewAction loginDetails(UserProfile userProfile) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.loginUser(userProfile);
        //legacyLoginPage.loginUserDetails(userProfile);
        return new AccountOverviewAction(userProfile);
    }
    public AccountOverviewAction validateNewPasswordField(UserProfile userProfile) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.validateNewPasswordField(userProfile);
        //legacyLoginPage.loginUserDetails(userProfile);
        return new AccountOverviewAction(userProfile);
    }
    
    public AccOverviewAction loginUserDetails(UserProfile userProfile) {
    	LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToLoginPage();
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();        
        legacyLoginPage.loginUserDetails(userProfile);
        return new AccOverviewAction(userProfile);
    }
    
    
    public LoginAction GotoBusinessLink(UserProfile userProfile) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.ClickGoToBusinessSite(userProfile);
        //legacyLoginPage.loginUserDetails(userProfile);
        return new LoginAction();
    }
    public LoginAction EnterInvalidEmailorPwd(UserProfile userProfile) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.EnterInvalidEmailorPass(userProfile);
        //legacyLoginPage.loginUserDetails(userProfile);
        return new LoginAction();
    }
    
    public LoginAction VerifyLoginTryCount(UserProfile userProfile) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.EnterInvalidEmailorPass(userProfile);
        //legacyLoginPage.loginUserDetails(userProfile);
        return new LoginAction();
    }
    
    public LoginAction verifyPrepopulateEmailorPass(UserProfile userProfile) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.VerifyPrePopulateEmailorPass(userProfile);
        //legacyLoginPage.loginUserDetails(userProfile);
        return new LoginAction();
    }
    
    public LoginAction checkRemeberEmail(UserProfile userProfile) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.CheckRememberEmail(userProfile);
        //legacyLoginPage.loginUserDetails(userProfile);
        return new LoginAction();
    }
    
    public LoginAction emailErrorMsgValidation(UserProfile userProfile) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.loginEmailErrorMessageValidation(userProfile);
        return new LoginAction();
    }
    
    public LoginAction loginPasswordErrorMessageValidation(UserProfile userProfile) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.loginPasswordErrorMessageValidation(userProfile);
        return new LoginAction();
    }
    /*public LoginAction getErrorMessage(String email,String password) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.getErrorMsgLoginscreen(email ,password);
        //legacyLoginPage.loginUserDetails(userProfile);
        return new LoginAction();
    }*/
    
    
    public HomePageAction verifypageafterBrowserBack(UserProfile userProfile) {
    	LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.verifyBrowserBackPage(userProfile);
        //legacyLoginPage.loginUserDetails(userProfile);
        return new HomePageAction();
    }
    
    public HomePageAction closeBrowser() {
    	LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.closeBrowser();
        //legacyLoginPage.loginUserDetails(userProfile);
        return new HomePageAction();
    }
    public LoginAction loginPasswordErrorMessageValidation(UserProfile userProfile,ArrayList<String> errList) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
      //  legacyLoginPage.loginInvalidUser(userProfile,errList);
        return new LoginAction();
    }
}
