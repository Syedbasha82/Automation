/*package bg.framework.app.functional.test.bgb;

import org.testng.annotations.Test;
import static bg.framework.app.functional.entities.FunctionalCategory.GetaQuoteSS;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import bg.framework.app.functional.action.bgb.GetAQuoteAction;
import bg.framework.app.functional.action.bgb.GetaquoteCombinedEnergyAction;
import bg.framework.app.functional.entities.GetAQuoteDetails;
import bg.framework.app.functional.page.bgb.GetaQuoteDetailsPage;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class GetaquoteAbandonTest extends TestBase {

*//**********************Electricity Journey Abandon*******************************//*

//   @Test(groups = {Regression,GetaQuoteSS})
//	 @Test(groups = {GetaQuoteSS})
	public void electricityAbandon() {
		Report.createTestLogHeader(
				"Get A Quote-Electricity Journey Abandon",
		        "AnonymousJourney");
		GetAQuoteDetails getDetails = new TestDataHelper()
		        .getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickElecquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterElectricityAddress(getDetails)
					.enterConsumptionForEle(getDetails, 0)
					.verifyAbandonedQuoteStatus(getDetails);
	}
	
*//*********************GasJourney Abandon***************************************//*

//	@Test(groups = { GetaQuoteSS})
	public void gasAbandon() {
		Report.createTestLogHeader(
				"GAS Journey- Abandon",
		        "AnonymousJourney");
		GetAQuoteDetails getDetails = new TestDataHelper()
		        .getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterConsumptionForGas(getDetails, 0)
		        .verifyAbandonedQuoteStatus(getDetails);
	}
		
*//*********************DualJourney Abandon***************************************//*

//	@Test(groups = { GetaQuoteSS})
	public void dualAbandon() {
		Report.createTestLogHeader(
				"DUAL Journey- Abandon",
				"AnonymousJourney");
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetaquoteCombinedEnergyAction()
				.clickCombinedEnergyLink()
				.enterGetaQuoteDetails(getDetails)
				.electricityAddressAndUsage(getDetails)
				.verifyAbandonedQuoteStatus(getDetails);
	}
}
*/