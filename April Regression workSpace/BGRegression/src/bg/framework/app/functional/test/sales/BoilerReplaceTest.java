package bg.framework.app.functional.test.sales;

import bg.framework.app.functional.action.sales.BoilerReplaceAction;
import bg.framework.app.functional.entities.FunctionalCategory;
import bg.framework.app.functional.entities.FunctionalCategory.*;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;

import org.testng.annotations.Test;

public class BoilerReplaceTest extends TestBase{
	
	@Test(groups = {FunctionalCategory.Regression})
	public void verifyAnonymousWithGasCouncilNumber(){
		Report.createTestLogHeader("Boiler Replace Journey", "Boiler Replace Anonymous Journey with Gas Council Number");
		new BoilerReplaceAction()
			.navigateToBoilerReplacePage()
			.validateGCNBoilerReplace();
	}
	
	@Test(groups = {FunctionalCategory.Regression})
	public void verifyAnonymouswithBoilers(){
		Report.createTestLogHeader("Boiler Replace Journey", "Boiler Replace Anonymous Journey with Boiler Type");
		new BoilerReplaceAction()
			.navigateToBoilerReplacePage()
			.validateBoilersReplace();
	}
}
