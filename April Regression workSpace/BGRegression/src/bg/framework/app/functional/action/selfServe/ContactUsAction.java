package bg.framework.app.functional.action.selfServe;

import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.selfServe.ContactUsPage;

/**
 * Created by IntelliJ IDEA.
 * User: !athimook
 * Date: 07/12/11
 * Time: 14:04
 * To change this template use File | Settings | File Templates.
 */

public class ContactUsAction {

    public ContactUsAction(UserProfile userProfile) {
        UserProfile userProfile1 = userProfile;
    }

    public ContactUsAction() {

    }

    public ContactUsAction verifyOAMFieldLeverErrors(UserProfile userProfile) {
        ContactUsPage contactUsPage = new ContactUsPage();
        contactUsPage.validateOAMErrorMessages(userProfile);
        return this;
    }

    public ContactUsAction verifyAnonymousFieldLevelErrors(UserProfile userProfile) {
        ContactUsPage contactUsPage = new ContactUsPage();
        contactUsPage.validateAnonymousErrorMessages(userProfile);
        return this;
    }

    public ContactUsAction verifyContactUsOAM(UserProfile userProfile,String strType) {
        ContactUsPage contactUsPage = new ContactUsPage();
        contactUsPage.submitForm(userProfile,strType);
        return this;
    }

    public ContactUsAction verifyCategoryAndProductDropdown(String BrandName) {
        ContactUsPage contactUsPage = new ContactUsPage();
        contactUsPage.verifyDropDownList(BrandName);
        return this;
    }

    public ContactUsAction verifyContactUsAnon(UserProfile userProfile,String strType) {
        ContactUsPage contactUsPage = new ContactUsPage();
        contactUsPage.submitForm(userProfile,strType);
        return this;
    }
    public ContactUsAction verifyContactusJourney() {
        ContactUsPage contactUsPage = new ContactUsPage();
        contactUsPage.verifyContactusJourney();
        return this;
    }
    public LoginAction navigateToLoginPage(UserProfile userProfile) {
        ContactUsPage contactUsPage = new ContactUsPage(userProfile);
        contactUsPage.logInToYourAccount();
        return new LoginAction();
    }
    
    public ContactUsAction contactuspageValidation() {
        ContactUsPage contactUsPage = new ContactUsPage();
        contactUsPage.contactuspageValidation();
        return this;
    }
}
