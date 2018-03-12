package bg.framework.app.functional.test.reFactoring;

import static bg.framework.app.functional.entities.FunctionalCategory.AccountOverview;
import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.reFactoring.SandRToolAction;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;

public class SandRToolTest extends TestBase {
	@Test(groups = {AccountOverview,Smoke})
	public void verifySandRQuotePage(){
		Report.createTestLogHeader("S And R Tool Journey validation", "Feasible validation");
		new SandRToolAction()
		.selectQuoteStatus()
		.navigateToSummaryPage()
		.navigateToWaitAdvicePage();
	}
}

