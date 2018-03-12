package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.LegacyHomePage;
import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.page.reFactoring.SiteSearchPage;

public class SiteSearchAction {
	
	 public SiteSearchAction navigateToLogin() {
	        LegacyHomePage legacyHomePage = new LegacyHomePage();
	        legacyHomePage.navigateToLoginPage();
	        return new SiteSearchAction();
	    }
	 
	public SiteSearchAction verifySiteSearchJourney() {
        new SiteSearchPage()
              		.validateSiteSearch();
        return new SiteSearchAction();
    }
	
	public SiteSearchAction verifySiteSearchErrorMsgs() {
        new SiteSearchPage()
              		.validateSiteSearchErrorMsgs();
        return new SiteSearchAction();
    }
	
	public SiteSearchAction validateSiteSearchField( ) {
        new SiteSearchPage()
              		.siteSearchValidation();
        return new SiteSearchAction();
    }
	
	public SiteSearchAction loginDetails(UserProfile userProfile) {
		LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToLoginPage();
		new SiteSearchPage().loginUser(userProfile);
	    return new SiteSearchAction();
	}
}
