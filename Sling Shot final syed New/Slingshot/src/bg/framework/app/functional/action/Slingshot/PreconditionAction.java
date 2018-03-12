package bg.framework.app.functional.action.Slingshot;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.Slingshot.CustomerServiceAgentPage;
import bg.framework.app.functional.page.Slingshot.RegistrationPage;
import bg.framework.app.functional.page.common.LegacyHomePage;
import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class PreconditionAction {
	public PreconditionAction registerDetails(UserProfile userProfile){
		LegacyHomePage legacyHomePage = new LegacyHomePage();
		legacyHomePage.navigateToBgbRegistrationPage();
		new RegistrationPage()

		    .registerDetailsFirstPage(userProfile)
		    .registerDetailsSecondPage(userProfile)
		    .openUrlandVerifyRegistration(userProfile)
		    .verifyAfterEncryptedUrl();

		return this;

	} 

	public PreconditionAction registerCsaDetails(UserProfile userProfile){
		LegacyHomePage legacyHomePage = new LegacyHomePage();
		legacyHomePage.navigateToCsaRegistrationPage();
		CustomerServiceAgentPage csapage = new CustomerServiceAgentPage();
		csapage.clickRegisteraUser();
		new RegistrationPage()
		.verifyRegistrationPageByCsa(userProfile)
		.openEncryptUrlandRegister(userProfile)
		.registerFirstPageCsa(userProfile)
		.registerDetailsSecondPage(userProfile)
		.openUrlandVerifyRegistration(userProfile)
		.verifyAfterEncryptedUrl();
		return this;

	} 

	public PreconditionAction verifyLogin(UserProfile userProfile){
		LegacyHomePage legacyHomePage = new LegacyHomePage();
		legacyHomePage.BgbnavigateToLoginPage();
		LegacyLoginPage legacy= new LegacyLoginPage();
		legacy.BgbloginUser(userProfile);
		legacy.logOut();
		return this;

	} 


}
