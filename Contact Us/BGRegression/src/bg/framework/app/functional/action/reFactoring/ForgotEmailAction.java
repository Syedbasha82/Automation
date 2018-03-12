package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.ForgotEmailPage;

public class ForgotEmailAction {

    public ForgotEmailAction verifyForgotEmailPage(UserProfile userProfile) {
        ForgotEmailPage forgotEmailPage = new ForgotEmailPage();
        forgotEmailPage.validateForgotEmail(userProfile);
        return this;
    }

    public ForgotEmailAction verifyForgotEmailPageFieldValidation(UserProfile userProfile) {
        ForgotEmailPage forgotEmailPage = new ForgotEmailPage();
        forgotEmailPage.validateForgotEmailFields(userProfile);
        return this;
    }

    public ForgotEmailAction verifyForgotEmailBreadCrumbValidation(UserProfile userProfile) {
        ForgotEmailPage forgotEmailPage = new ForgotEmailPage();
        forgotEmailPage.verifyingForgotEmailBreadCrumb();
        return this;
    }

    public ForgotEmailAction verifyForgotEmailWhereCanIFindValidation(UserProfile userProfile) {
        ForgotEmailPage forgotEmailPage = new ForgotEmailPage();
        forgotEmailPage.validateForgotEmailWhereCanIFind();
        return this;
    }

    public ForgotEmailAction verifyForgotEmailTitleValidation(UserProfile userProfile) {
        ForgotEmailPage forgotEmailPage = new ForgotEmailPage();
        //forgotEmailPage.validateForgotEmailTitle();
        return this;
    }

    public ForgotEmailAction verifyEnterEmailValidation(UserProfile userProfile) {
        ForgotEmailPage forgotEmailPage = new ForgotEmailPage();
        forgotEmailPage.validateEnterEmail(userProfile);
        return this;
    }

    public ForgotEmailAction verifyAccountNumErrorMsg(UserProfile userProfile) {
        ForgotEmailPage forgotEmailPage = new ForgotEmailPage();
        forgotEmailPage.accountNumberErrorMsgValidation(userProfile);
        return this;
    }

    public ForgotEmailAction verifyFirstNameErrorMsg(UserProfile userProfile) {
        ForgotEmailPage forgotEmailPage = new ForgotEmailPage();
        forgotEmailPage.firstNameErrorMsgValidation(userProfile);
        return this;
    }

    public ForgotEmailAction verifyLastNameErrorMsg(UserProfile userProfile) {
        ForgotEmailPage forgotEmailPage = new ForgotEmailPage();
        forgotEmailPage.lastNameErrorMsgValidation(userProfile);
        return this;
    }

    public ForgotEmailAction verifyDBConversionData(UserProfile userProfile) {
        ForgotEmailPage forgotEmailPage = new ForgotEmailPage();
        forgotEmailPage.validateDBConversionErrorMessage(userProfile);
        return this;
    }

    public ForgotEmailAction verifyAccountLockEmailAddress(UserProfile userProfile) {
        ForgotEmailPage forgotEmailPage = new ForgotEmailPage();
        forgotEmailPage.verifyAccountLockValidation(userProfile);
        return this;
    }

    public ForgotEmailAction validateActiveAccount(UserProfile userProfile) {
        ForgotEmailPage forgotEmailPage = new ForgotEmailPage();
        forgotEmailPage.verifyActiveAccount(userProfile);
        return this;
    }

    public ForgotEmailAction validateInactiveAccount(UserProfile userProfile) {
        ForgotEmailPage forgotEmailPage = new ForgotEmailPage();
        forgotEmailPage.verifyInactiveAccount(userProfile);
        return this;
    }


}
