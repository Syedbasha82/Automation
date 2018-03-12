/**
 * 
 */
package bg.framework.app.functional.action.Slingshot_Broker;

import bg.framework.app.functional.action.Slingshot.CustomerServiceAgentAction;
import bg.framework.app.functional.entities.SMRAccountDetails;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.Slingshot_Broker.PartnerServiceAgentPage;
import bg.framework.app.functional.page.Slingshot_Broker.ViewBillPartnerPage;
import bg.framework.app.functional.page.Slingshot.CustomerServiceAgentPage;
import bg.framework.app.functional.page.Slingshot.RegistrationPage;
import bg.framework.app.functional.page.common.LegacyHomePage;
import bg.framework.app.functional.util.TestDataHelper;

/**
 * @author 208070
 *
 */
public class PartnerServiceAgentAction {

	public PartnerServiceAgentAction navigateToPSARegistration() {
		PartnerServiceAgentPage PSA = new PartnerServiceAgentPage();
		PSA.navigateToPSARegistration();
        return this;
 }

	public PartnerServiceAgentAction clickRegisteraUser(UserProfile userProfile) {
		PartnerServiceAgentPage PSA = new PartnerServiceAgentPage();
        PSA.clickRegisteraUser(userProfile);
        return this;
 }
	public PartnerServiceAgentAction verifyFindUser(UserProfile userProfile) {
		PartnerServiceAgentPage PSA = new PartnerServiceAgentPage();
		PSA.clickLookUpUser();
		PSA.enterEmailIdInFindUser(userProfile);
		PSA.clickFindUser();
        return this;
 }
	public PartnerServiceAgentAction verifyUpdateUserDetailsPage() {
		PartnerServiceAgentPage PSA = new PartnerServiceAgentPage();
        PSA.verifyUpdateUserDetailsPage();
        return this;
 }
	public PartnerServiceAgentAction verifyUserAccountInformation(UserProfile userProfile) {
		PartnerServiceAgentPage PSA = new PartnerServiceAgentPage();
        PSA.verifyStatusInUi(userProfile);
        PSA.verifyUserAccountInfoInDb(userProfile);
        return this;
 }
	public PartnerServiceAgentAction updateAndVerifyStatus(UserProfile userProfile) {
		PartnerServiceAgentPage PSA = new PartnerServiceAgentPage();
		PSA.updateStatusInUi(userProfile,"FREEZED");
		PSA.verifyStatusInDbAfterUpdated(userProfile,"Y");
		PSA.updateOrRevertProfileStatusInDb(userProfile,1,"Revert");
		PSA.clickCsaLoginInThankYouPage();
		PSA.clickLookUpUser();
		PSA.enterEmailIdInFindUser(userProfile);
		PSA.clickFindUser();
		PSA.updateStatusInUi(userProfile,"LOCKED");
		PSA.verifyStatusInDbAfterUpdated(userProfile,"LOCKED");
		PSA.updateOrRevertProfileStatusInDb(userProfile,2,"Revert");
		PSA.clickCsaLoginInThankYouPage();
		PSA.clickLookUpUser();
		PSA.enterEmailIdInFindUser(userProfile);
		PSA.clickFindUser();
		PSA.updateStatusInUi(userProfile,"ACTIVE");
		PSA.verifyStatusInDbAfterUpdated(userProfile,"ACTIVE");
		PSA.updateOrRevertProfileStatusInDb(userProfile,2,"Revert");
        return this;
 }
	public PartnerServiceAgentAction clickAndverifyRegister(UserProfile userProfile) {
		PartnerServiceAgentPage PSA = new PartnerServiceAgentPage();
		RegistrationPage rsapage = new RegistrationPage();
		//PSA.clickRegisteraUser();
        rsapage.verifyRegistrationPageByCsa(userProfile);
        /*csapage.enterRegisterEmail(userProfile);
        csapage.clickRegisterButton();*/
        PSA.verifyAfterRegistration(userProfile);        
        return this;
 }

	public PartnerServiceAgentAction verifyAuditTrail(UserProfile userProfile) {
		PartnerServiceAgentPage PSA = new PartnerServiceAgentPage();
		 PSA.verifyAuditTrail(userProfile);     
		return null;
	}
	public PartnerServiceAgentAction verifyPasswordLink(UserProfile userProfile) {
		PartnerServiceAgentPage PSA = new PartnerServiceAgentPage();
		PSA.checkPasswordReset();
		PSA.verifyPasswordResetPage(userProfile);
		PSA.verifyResetPasswordFlag(userProfile);
        /*csapage.enterNewPassword();
        csapage.resetOldPassword(userProfile);*/
        return this;
 }

	public PartnerServiceAgentAction verifyImpersonateLink(SMRAccountDetails smrProfile) {
		PartnerServiceAgentPage PSA = new PartnerServiceAgentPage();
		ViewBillPartnerAction PartnerLogin = new ViewBillPartnerAction();
		PSA.checkImpersonateLink();
		PartnerLogin.downloadAndVerifyBill(smrProfile);
		
		return this;
	}
}
