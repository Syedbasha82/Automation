package bg.framework.app.functional.action.sales;

import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.action.selfServe.ContactUsAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.LegacyHomePage;
import bg.framework.app.functional.page.sales.RollOffPage;
import bg.framework.app.functional.page.selfServe.AccountOverviewPage;
import bg.framework.app.functional.page.selfServe.ContactUsPage;

public class RollOffAction {
	
	public RollOffAction(){
		
	}
	public RollOffAction navigatetoRollOffLandingPage() {
		RollOffPage rollOffPage = new RollOffPage();
		rollOffPage.navigatetoRollOffLandingPage();
        return this;
    }
	public RollOffAction verifybreadcrumb() {
		RollOffPage rollOffPage = new RollOffPage();
		rollOffPage.verifybreadcrumb();
        return this;
    }
	public RollOffAction validateRollOffPage(UserProfile userProfile) {
		RollOffPage rollOffPage = new RollOffPage();
		rollOffPage.validateRollOffPage(userProfile);
        return this;
    }
	public RollOffAction verifyAudit(UserProfile userProfile) {
		RollOffPage rollOffPage = new RollOffPage();
		//rollOffPage.verifyAuditDetails(userProfile);
        return this;
    }
	public RollOffAction logout() {
		new AccountOverviewPage().logout();
        return new RollOffAction();
    }
}
