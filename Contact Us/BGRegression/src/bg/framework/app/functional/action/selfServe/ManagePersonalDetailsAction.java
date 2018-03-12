package bg.framework.app.functional.action.selfServe;

import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.selfServe.ManagePersonalDetailsPage;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 03/04/12
 * Time: 11:35
 * To change this template use File | Settings | File Templates.
 */
public class ManagePersonalDetailsAction {


    public ManagePersonalDetailsAction fillValidDataInManagePersonalDetailsPage(UserProfile userProfile) {
        ManagePersonalDetailsPage managePersonalDetailsPage = new ManagePersonalDetailsPage();
        managePersonalDetailsPage.fillValidDataInManagePersonalDetailsPage(userProfile);
        return new ManagePersonalDetailsAction();
    }
    
    public ManagePersonalDetailsAction verifyFillDataWithDB(UserProfile userProfile) {
        ManagePersonalDetailsPage managePersonalDetailsPage = new ManagePersonalDetailsPage();
        managePersonalDetailsPage.verifyFillDataWithDB(userProfile);
        return new ManagePersonalDetailsAction();
    }
    
    public ManagePersonalDetailsAction verifyFillDataWithSiebel(UserProfile userProfile) {
        ManagePersonalDetailsPage managePersonalDetailsPage = new ManagePersonalDetailsPage();
        managePersonalDetailsPage.verifyFillDataWithSiebel(userProfile);
        return new ManagePersonalDetailsAction();
    }
    
    public ManagePersonalDetailsAction ClickSaveChangesButton() {
        ManagePersonalDetailsPage managePersonalDetailsPage = new ManagePersonalDetailsPage();
        managePersonalDetailsPage.ClickSaveChangesButton();
        return new ManagePersonalDetailsAction();
    }

    public AccountOverviewAction VerifyConfirmationOverLayGotToMyAccount() {
        ManagePersonalDetailsPage managePersonalDetailsPage = new ManagePersonalDetailsPage();
        managePersonalDetailsPage.VerifyConfirmationOverLayGotToMyAccount();
        return new AccountOverviewAction();
    }

    public LoginAction verifyConfirmationOverLayClickLogin() {
        ManagePersonalDetailsPage managePersonalDetailsPage = new ManagePersonalDetailsPage();
        managePersonalDetailsPage.verifyConfirmationOverLayAndClickLogin();
        return new LoginAction();
    }
    
    public ManagePersonalDetailsAction logout() {
    	ManagePersonalDetailsPage managePersonalDetailsPage = new ManagePersonalDetailsPage();
    	managePersonalDetailsPage.logout();
    	return new ManagePersonalDetailsAction();
    }
    public ManagePersonalDetailsAction verifyFieldValidation() {
    	ManagePersonalDetailsPage managePersonalDetailsPage = new ManagePersonalDetailsPage();
    	managePersonalDetailsPage.verifyFieldValidation();
    	return new ManagePersonalDetailsAction();
    }
    
    public ManagePersonalDetailsAction verifyMPDSapNetweaver(UserProfile userProfile) {
    	ManagePersonalDetailsPage managePersonalDetailsPage = new ManagePersonalDetailsPage();
    	managePersonalDetailsPage.verifyMPDSapNetweaver(userProfile);
    	return new ManagePersonalDetailsAction();
    }
}
