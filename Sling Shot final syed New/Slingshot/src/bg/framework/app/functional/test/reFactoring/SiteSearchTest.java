package bg.framework.app.functional.test.reFactoring;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.action.reFactoring.SiteSearchAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;
import static bg.framework.app.functional.entities.FunctionalCategory.SiteSearch;
import static bg.framework.app.functional.entities.FunctionalCategory.Refactoring;

public class SiteSearchTest extends TestBase {
	
	/* Validate site search property anonymous in different pages*/
	@SuppressWarnings("unchecked")
	@Test(groups ={SiteSearch})
	public void verifySiteSearchJourney() {
		Report.createTestLogHeader("Site Search", "Site Search Field Validation in different pages");
		new SiteSearchAction()
				.verifySiteSearchJourney()
				.verifySiteSearchErrorMsgs();
	}

	/*validate site search with different results*/
	@SuppressWarnings("unchecked")
	//@Test(groups ={SiteSearch})
	public void verifySiteSearch(){
		Report.createTestLogHeader("Site Search", "Existence of Site Search Property");
		new SiteSearchAction()
				.validateSiteSearchField();
	}		
	/* Logged in cutomer verifying site search in different pages*/
	@SuppressWarnings("unchecked")
	//@Test(groups ={SiteSearch})
	public void verifyOAMSiteSearchJourney() {
		Report.createTestLogHeader("Site Search", "Site Search Field Validation in different pages with logged in Customer");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		new SiteSearchAction()
				.loginDetails(userProfile)
				.verifySiteSearchErrorMsgs();
	}
	/* Logged in cutomer verifying site search results*/	
//	@Test(groups ={SiteSearch})
	public void verifyOAMSiteSearch(){
		Report.createTestLogHeader("Site Search", "Existence of Site Search Property with logged in Customer");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		new SiteSearchAction()
				.loginDetails(userProfile)
				.validateSiteSearchField();
	}
}
