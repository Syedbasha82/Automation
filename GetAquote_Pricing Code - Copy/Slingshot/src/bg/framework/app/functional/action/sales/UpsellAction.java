package bg.framework.app.functional.action.sales;

import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.LegacyHomePage;
import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.page.sales.UpsellPage;

public class UpsellAction {
	UpsellPage upSellPage = new UpsellPage();

	public UpsellAction loginUser(UserProfile userProfile) {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToLoginPage();
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.loginUser(userProfile);
        return this;
    }
	public UpsellAction verifyUpgradeCustomer(String value) {
		upSellPage.verifyUpgradeCustomer(value);
        return this;
    }
	public UpsellAction logout() {
        LegacyLoginPage legacyloginPage = new LegacyLoginPage();
        legacyloginPage.logOut();
        return this;
	}
	
}
