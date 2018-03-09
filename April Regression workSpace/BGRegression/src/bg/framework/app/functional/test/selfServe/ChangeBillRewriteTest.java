package bg.framework.app.functional.test.selfServe;

import static bg.framework.app.functional.entities.FunctionalCategory.AccountSummary;
import static bg.framework.app.functional.entities.FunctionalCategory.ManagePersonalDetails;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.action.selfServe.ChangeBillRewriteAction;

import bg.framework.app.functional.action.services.AccountOverViewAction;
import bg.framework.app.functional.entities.FunctionalCategory;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;


public class ChangeBillRewriteTest extends TestBase {

	@Test(groups = {Regression, ManagePersonalDetails})
	
	public void changeBill(){
		final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		Report.createTestLogHeader("Change Bill request journey", "Changing the bill date for a logged in customer");
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile);
		new ChangeBillRewriteAction()
		.changeDate(userProfile);
		new AccountOverviewAction()
		.navigateToAccountSummaryPage(userProfile);
		new ChangeBillRewriteAction()
		.dateVerification(userProfile);
	}
}