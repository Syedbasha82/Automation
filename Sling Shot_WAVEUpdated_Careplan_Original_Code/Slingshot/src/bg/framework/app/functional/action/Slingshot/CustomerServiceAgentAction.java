package bg.framework.app.functional.action.Slingshot;

import bg.framework.app.functional.page.Slingshot.CustomerServiceAgentPage;
import bg.framework.app.functional.page.Slingshot.RegistrationPage;
import bg.framework.app.functional.page.common.LegacyHomePage;
import bg.framework.app.functional.entities.UserProfile;
public class CustomerServiceAgentAction {
	UserProfile userProfile=new UserProfile();
	
	public CustomerServiceAgentAction navigateToCsaRegistration() {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToCsaRegistrationPage();
        return this;
 }
	
	public CustomerServiceAgentAction verifyCsaContentScreen() {
        CustomerServiceAgentPage csapage = new CustomerServiceAgentPage();
        csapage.verifyCsaAgentScreen();
        return this;
 }
	public CustomerServiceAgentAction clickAndverifyRegister(UserProfile userProfile) {
		CustomerServiceAgentPage csapage = new CustomerServiceAgentPage();
		RegistrationPage rsapage = new RegistrationPage();
        csapage.clickRegisteraUser();
        rsapage.verifyRegistrationPageByCsa(userProfile);
        /*csapage.enterRegisterEmail(userProfile);
        csapage.clickRegisterButton();*/
        csapage.verifyAfterRegistration(userProfile);        
        return this;
 }
	public CustomerServiceAgentAction valdiateBpNumber(UserProfile userProfile) {
		CustomerServiceAgentPage csapage = new CustomerServiceAgentPage();
        csapage.clickLookUpUser();
        csapage.validateBpNumber();
        return this;
 }
	
	public CustomerServiceAgentAction verifyFindUser(UserProfile userProfile) {
		CustomerServiceAgentPage csapage = new CustomerServiceAgentPage();
        csapage.clickLookUpUser();
        csapage.enterEmailIdInFindUser(userProfile);
        csapage.clickFindUser();
        return this;
 }
	public CustomerServiceAgentAction verifyUpdateUserDetailsPage() {
		CustomerServiceAgentPage csapage = new CustomerServiceAgentPage();
        csapage.verifyUpdateUserDetailsPage();
        return this;
 }
	/*public CustomerServiceAgentAction clickAndverifyRegister() {
		CustomerServiceAgentPage csapage = new CustomerServiceAgentPage();
        csapage.clickRegisteraUser();
        csapage.enterRegisterEmail();
        csapage.clickRegisterButton();
        csapage.verifyAfterRegistration(userProfile);        
        return this;
 }*/
	public CustomerServiceAgentAction verifyUserAccountInformation(UserProfile userProfile) {
		CustomerServiceAgentPage csapage = new CustomerServiceAgentPage();
        csapage.verifyStatusInUi(userProfile);
        csapage.verifyUserAccountInfoInDb(userProfile);
        return this;
 }
	public CustomerServiceAgentAction updateAndVerifyStatus(UserProfile userProfile) {
		CustomerServiceAgentPage csapage = new CustomerServiceAgentPage();
        csapage.updateStatusInUi(userProfile,"FREEZED");
        csapage.verifyStatusInDbAfterUpdated(userProfile,"Y");
        csapage.updateOrRevertProfileStatusInDb(userProfile,1,"Revert");
        csapage.clickCsaLoginInThankYouPage();
        csapage.enterEmailIdInFindUser(userProfile);
        csapage.clickFindUser();
        csapage.updateStatusInUi(userProfile,"LOCKED");
        csapage.verifyStatusInDbAfterUpdated(userProfile,"LOCKED");
        csapage.updateOrRevertProfileStatusInDb(userProfile,2,"Revert");
        return this;
 }
	public CustomerServiceAgentAction verifyRegisterEmailErrorMessage(UserProfile userProfile) {
		CustomerServiceAgentPage csapage = new CustomerServiceAgentPage();
        csapage.clickRegisteraUser();
        csapage.registerEmailErrorMessageValidation(userProfile);
        return this;
 }
	public CustomerServiceAgentAction verifyLookUpEmailErrorMessage(UserProfile userProfile) {
		CustomerServiceAgentPage csapage = new CustomerServiceAgentPage();
        csapage.clickLookUpUser();
        csapage.lookupEmailErrorMessageValidation(userProfile);
        return this;
 }
	public CustomerServiceAgentAction verifyPasswordLink(UserProfile userProfile) {
		CustomerServiceAgentPage csapage = new CustomerServiceAgentPage();
        csapage.checkPasswordReset();
        csapage.verifyPasswordResetPage();
        csapage.verifyResetPasswordFlag(userProfile);
        /*csapage.enterNewPassword();
        csapage.resetOldPassword(userProfile);*/
        return this;
 }
	public CustomerServiceAgentAction verifyEnterNewPassword(UserProfile userProfile) {
		CustomerServiceAgentPage csapage = new CustomerServiceAgentPage();
        csapage.checkPasswordReset();
        csapage.verifyPasswordResetPage();        
        return this;
 }
	public CustomerServiceAgentAction verifyFindUserBpNumber(UserProfile userProfile) {
		CustomerServiceAgentPage csapage = new CustomerServiceAgentPage();
        csapage.clickLookUpUser();
        csapage.enterBpNumberFindUser(userProfile);
        csapage.clickFindUser();
        csapage.verifyUpdateUserDetailsPage();
        return this;
 }

}
