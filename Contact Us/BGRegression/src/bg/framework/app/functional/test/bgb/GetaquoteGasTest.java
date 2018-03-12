/*package bg.framework.app.functional.test.bgb;

import static bg.framework.app.functional.entities.FunctionalCategory.GetaQuoteSS;
import org.testng.annotations.Test;
import bg.framework.app.functional.action.bgb.GetAQuoteAction;
import bg.framework.app.functional.action.bgb.GetaquoteCombinedEnergyAction;
import bg.framework.app.functional.entities.GetAQuoteDetails;
import bg.framework.app.functional.page.bgb.GetaQuoteDetailsPage;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class GetaquoteGasTest extends TestBase {

	 ******************** Mandatory Fields For Gas Journey******************
    (File Name -- getaQuoteDetails.xml)
    <firstName>Macrose</firstName>
	<lastName>Brown</lastName>
	<ddlTitle>Mr</ddlTitle>
	<businessname>MarryBrown</businessname>
	<emailAddress>Mac@bgdigitaltest.com</emailAddress>
	<telephone>0987654321</telephone>
	<annualElecSpend>5678</annualElecSpend>
	<postCode>ch36nu</postCode>
	<charityNumber>5645</charityNumber>
	<annualGasSpend>111</annualGasSpend>
	<gasmeterRefnumber>9205396401</gasmeterRefnumber>
 ******************************************************************************

*//**************** Gas 1st Year Monthly Quarter Validation *************************//*

	// @Test(groups = { GetaQuoteSS})
	public void firstYearMonthlyGasMeterNoGas() throws InterruptedException {
	Report.createTestLogHeader(
				"GAS Journey-_1Year_monthly CalaulationGasMeter_NOGas",
	"AnonymousJourney");
		String monthlyquarter = "1";
		String gas="gas";
		for (int j = 0; j <= 2; j++) {
	GetAQuoteDetails getDetails = new TestDataHelper()
	.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction()
					.clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
			.enterConsumptionForGas(getDetails, j)
					.clickGasMeterOptionNO()
					.gasMeterYESandNO(getDetails)
					.click1stYearTabGas()
					.saveCurrentQuote1year()
			.retreiveSavedQuote(getDetails)
			.verifySavedQuoteStatus()
					.click1stYearTabGas()
					.gasunitpricefromdbMonthlyQuarter1Year(getDetails, monthlyquarter, gas)
					.calculatingConsumption1YearGas(getDetails, j)
					.clickContinueQuotePage1stYearGas()
			.clickContinuElecSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsMonthly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);

	}
	}

	// @Test(groups = { GetaQuoteSS})
	public void firstYearQuarterGasMeterNoGas() throws InterruptedException {
	Report.createTestLogHeader(
				"GAS Journey-_1Year_quarter CalaulationGasMeter_NOGas",
	"AnonymousJourney");
		String monthlyquarter = "4";
		String gas="gas";
		for (int j = 0; j <= 2; j++) {
	GetAQuoteDetails getDetails = new TestDataHelper()
	.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction()
					.clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
			.enterConsumptionForGas(getDetails, j)
					.clickGasMeterOptionNO()
					.gasMeterYESandNO(getDetails)
					.click1stYearTabGas()
					.clickQuaterlybutton1stYearGas(getDetails)
					.saveCurrentQuote1year()
			.retreiveSavedQuote(getDetails)
			.verifySavedQuoteStatus()
					.click1stYearTabGas()
					.clickQuaterlybutton1stYearGas(getDetails)
					.gasunitpricefromdbMonthlyQuarter1Year(getDetails, monthlyquarter, gas)
					.calculatingConsumption1YearGas(getDetails, j)
					.clickContinueQuotePage1stYearGas()
			.clickContinuElecSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsQuaterly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);
	}
	}

	// @Test(groups = { GetaQuoteSS})
	public void firstYearMonthlyGasMeterYesGas()
			throws InterruptedException {
	Report.createTestLogHeader(
				"GAS Journey-_1Year_monthly CalaulationGasMeter_YESGas",
	"AnonymousJourney");
		String monthlyquarter = "1";
		String gas="gas";
		for (int j = 0; j <= 2; j++)
	{
	GetAQuoteDetails getDetails = new TestDataHelper()
	.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction()
					.clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
			.enterConsumptionForGas(getDetails, j)
					.gasMeterYESandNO(getDetails)
					.click1stYearTabGas()
					.saveCurrentQuote1year()
			.retreiveSavedQuote(getDetails)
			.verifySavedQuoteStatus()
					.click1stYearTabGas()
					.gasunitpricefromdbMonthlyQuarter1Year(getDetails, monthlyquarter, gas)
					.calculatingConsumption1YearGas(getDetails, j)
					.clickContinueQuotePage1stYearGas()
			.clickContinuElecSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsMonthly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);
	}
	}

	// @Test(groups = { GetaQuoteSS})
	public void firstYearQuarterGasMeterYesGas()
			throws InterruptedException {
	Report.createTestLogHeader(
				"GAS Journey-_1Year_quarter CalaulationGasMeter_YESGas",
	"AnonymousJourney");
		String monthlyquarter = "4";
		String gas="gas";
		for (int j = 0; j <= 2; j++) {
	GetAQuoteDetails getDetails = new TestDataHelper()
	.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction()
					.clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
			.enterConsumptionForGas(getDetails, j)
					.gasMeterYESandNO(getDetails)
					.click1stYearTabGas()
					.clickQuaterlybutton1stYearGas(getDetails)
					.saveCurrentQuote1year()
			.retreiveSavedQuote(getDetails)
			.verifySavedQuoteStatus()
					.click1stYearTabGas()
					.clickQuaterlybutton1stYearGas(getDetails)
					.gasunitpricefromdbMonthlyQuarter1Year(getDetails, monthlyquarter, gas)
					.calculatingConsumption1YearGas(getDetails, j)
					.clickContinueQuotePage1stYearGas()
			.clickContinuElecSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsQuaterly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);
	}
	}


*//**************** Gas 2nd Year Monthly Quarter Validation *************************//*

	// @Test(groups = { GetaQuoteSS})
	public void secondYearMonthlyGasMeterNoGas()
			throws InterruptedException {
	Report.createTestLogHeader(
				"GAS Journey-_2Year_monthly CalaulationGasMeter_NOGas",
	"AnonymousJourney");
		String monthlyquarter = "2";
		String gas="gas";
		for (int j = 0; j <= 2; j++) {
	GetAQuoteDetails getDetails = new TestDataHelper()
	.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction()
					.clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
			.enterConsumptionForGas(getDetails, j)
					.clickGasMeterOptionNO()
					.gasMeterYESandNO(getDetails)
					.click2ndYearTab()
					.saveCurrentQuote2year()
			.retreiveSavedQuote(getDetails)
			.verifySavedQuoteStatus()
					.click2ndYearTab()
					.gasunitpricefromdbMonthlyQuarter2Year(getDetails, monthlyquarter, gas)
					.calculatingConsumption2YearGas(getDetails, j)
					.clickContinueQuotePage2ndYearGas()
			.clickContinuElecSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsMonthly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);
	}
	}

	// @Test(groups = { GetaQuoteSS})
	public void secondYearQuarterGasMeterNoGas()
			throws InterruptedException {
	Report.createTestLogHeader(
				"GAS Journey-_2Year_quarter CalaulationGasMeter_NOGas",
	"AnonymousJourney");
		String monthlyquarter = "5";
		String gas="gas";
		for (int j = 0; j <= 2; j++) {
	GetAQuoteDetails getDetails = new TestDataHelper()
	.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction()
					.clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
			.enterConsumptionForGas(getDetails, j)
					.clickGasMeterOptionNO()
					.gasMeterYESandNO(getDetails)
					.click2ndYearTab()
					.clickQuaterlybutton2ndYearGas(getDetails)
					.saveCurrentQuote2year()
			.retreiveSavedQuote(getDetails)
			.verifySavedQuoteStatus()
					.click2ndYearTab()
					.clickQuaterlybutton2ndYearGas(getDetails)
					.gasunitpricefromdbMonthlyQuarter2Year(getDetails, monthlyquarter, gas)
					.calculatingConsumption2YearGas(getDetails, j)
					.clickContinueQuotePage2ndYearGas()
			.clickContinuElecSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsQuaterly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);
	}
	}

	// @Test(groups = { GetaQuoteSS})
	public void secondYearMonthlyGasMeterYesGas()
			throws InterruptedException {
	Report.createTestLogHeader(
				"GAS Journey-_2Year_monthly CalaulationGasMeter_YESGas",
	"AnonymousJourney");
		String monthlyquarter = "2";
		String gas="gas";
		for (int j = 0; j <= 2; j++)
	{
	GetAQuoteDetails getDetails = new TestDataHelper()
	.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction()
					.clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
			.enterConsumptionForGas(getDetails, j)
					.gasMeterYESandNO(getDetails)
					.click2ndYearTab()
					.saveCurrentQuote2year()
			.retreiveSavedQuote(getDetails)
			.verifySavedQuoteStatus()
					.click2ndYearTab()
					.gasunitpricefromdbMonthlyQuarter2Year(getDetails, monthlyquarter, gas)
					.calculatingConsumption2YearGas(getDetails, j)
					.clickContinueQuotePage2ndYearGas()
			.clickContinuElecSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsMonthly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);
	}
	}

	// @Test(groups = { GetaQuoteSS})
	public void secondYearQuarterGasMeterYesGas()
			throws InterruptedException {
	Report.createTestLogHeader(
				"GAS Journey-_2Year_quarter CalaulationGasMeter_YESGas",
	"AnonymousJourney");
		String monthlyquarter = "5";
		String gas="gas";
		for (int j = 0; j <= 2; j++) {
	GetAQuoteDetails getDetails = new TestDataHelper()
	.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction()
					.clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
			.enterConsumptionForGas(getDetails, j)
					.gasMeterYESandNO(getDetails)
					.click2ndYearTab()
					.clickQuaterlybutton2ndYearGas(getDetails)
					.saveCurrentQuote2year()
			.retreiveSavedQuote(getDetails)
			.verifySavedQuoteStatus()
					.click2ndYearTab()
					.clickQuaterlybutton2ndYearGas(getDetails)
					.gasunitpricefromdbMonthlyQuarter2Year(getDetails, monthlyquarter, gas)
					.calculatingConsumption2YearGas(getDetails, j)
					.clickContinueQuotePage2ndYearGas()
			.clickContinuElecSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsQuaterly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);
	}
	}


*//**************** Gas 3rd Year Monthly Quarter Validation *************************//*

	// @Test(groups = { GetaQuoteSS})
	public void thirdYearMonthlyGasMeterNoGas() throws InterruptedException {
	    Report.createTestLogHeader(
				"GAS Journey-_3Year_monthly CalaulationGasMeter_NOGas",
	            "AnonymousJourney");
		String monthlyquarter = "3";
		String gas="gas";
		for (int j = 0; j <= 2; j++)
	    {
	    	 GetAQuoteDetails getDetails = new TestDataHelper()
	         .getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction()
					.clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
			    .enterConsumptionForGas(getDetails, j)
					.clickGasMeterOptionNO()
					.gasMeterYESandNO(getDetails)
					.click3rdYearTabGas()
					.saveCurrentQuote3year()
			    .retreiveSavedQuote(getDetails)
			    .verifySavedQuoteStatus()
					.click3rdYearTabGas()
					.gasunitpricefromdbMonthlyQuarter3Year(getDetails, monthlyquarter, gas)
					.calculatingConsumption3YearGas(getDetails, j)
                .clickQuaterlyContinueQuotePage3rdYear()
			    .clickContinuElecSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsMonthly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);

	}
	}

	// @Test(groups = { GetaQuoteSS})
	public void thirdYearQuarterGasMeterNoGas() throws InterruptedException {
	    Report.createTestLogHeader(
				"GAS Journey-_3Year_Quarter CalaulationGasMeter_NOGas",
	            "AnonymousJourney");
		String monthlyquarter = "6";
		String gas="gas";
		for (int j = 0; j <= 2; j++)

	    {
	    	 GetAQuoteDetails getDetails = new TestDataHelper()
	         .getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction()
					.clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
			    .enterConsumptionForGas(getDetails, j)
					.clickGasMeterOptionNO()
					.gasMeterYESandNO(getDetails)
					.click3rdYearTabGas()
					.clickQuaterlybutton3rdYearGas(getDetails)
					.saveCurrentQuote3year()
			    .retreiveSavedQuote(getDetails)
			    .verifySavedQuoteStatus()
					.click3rdYearTabGas()
					.clickQuaterlybutton3rdYearGas(getDetails)
					.gasunitpricefromdbMonthlyQuarter3Year(getDetails, monthlyquarter, gas)
					.calculatingConsumption3YearGas(getDetails, j)
                .clickQuaterlyContinueQuotePage3rdYear()
			    .clickContinuElecSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsQuaterly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);
	}
	}

	// @Test(groups = { GetaQuoteSS})
	public void thirdYearMonthlyGasMeterYesGas()
			throws InterruptedException {
	    Report.createTestLogHeader(
				"GAS Journey-_3Year_monthly CalaulationGasMeter_YESGas",
	            "AnonymousJourney");
		String monthlyquarter = "3";
		String gas="gas";
		for (int j = 0; j <= 2; j++)
	    {
	    	 GetAQuoteDetails getDetails = new TestDataHelper()
	         .getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction()
					.clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
			    .enterConsumptionForGas(getDetails, j)
					.gasMeterYESandNO(getDetails)
					.click3rdYearTabGas()
					.saveCurrentQuote3year()
			    .retreiveSavedQuote(getDetails)
			    .verifySavedQuoteStatus()
					.click3rdYearTabGas()
					.gasunitpricefromdbMonthlyQuarter3Year(getDetails, monthlyquarter, gas)
					.calculatingConsumption3YearGas(getDetails, j)
                .clickQuaterlyContinueQuotePage3rdYear()
			    .clickContinuElecSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsMonthly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);

	}
	}

	// @Test(groups = { GetaQuoteSS})
	public void thirdYearQuarterGasMeterYesGas()
			throws InterruptedException {
	    Report.createTestLogHeader(
				"GAS Journey-_3Year_Quarter CalaulationGasMeter_YESGas",
	            "AnonymousJourney");
		String monthlyquarter = "6";
		String gas="gas";
		for (int j = 0; j <= 2; j++)
	    {
	    	 GetAQuoteDetails getDetails = new TestDataHelper()
	         .getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction()
					.clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
			    .enterConsumptionForGas(getDetails, j)
					.gasMeterYESandNO(getDetails)
					.click3rdYearTabGas()
					.clickQuaterlybutton3rdYearGas(getDetails)
					.saveCurrentQuote3year()
			    .retreiveSavedQuote(getDetails)
			    .verifySavedQuoteStatus()
					.click3rdYearTabGas()
					.clickQuaterlybutton3rdYearGas(getDetails)
					.gasunitpricefromdbMonthlyQuarter3Year(getDetails, monthlyquarter, gas)
					.calculatingConsumption3YearGas(getDetails, j)
                .clickQuaterlyContinueQuotePage3rdYear()
			    .clickContinuElecSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsQuaterly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);

	}
	}


*//**************** Gas Compare All Tab *************************//*

//	@Test(groups = { GetaQuoteSS})
	public void compareAllJourneyGasMonthly() throws InterruptedException {
	    Report.createTestLogHeader(
	            "Compare All Journey GAS-Comparing Unit,Night and Standing charge for 1st,2nd and 3rd Years-Monthly Calculation",
	            "AnonymousJourney");
	    	
		for (int j = 0; j <= 2; j++)
	    {
	    GetAQuoteDetails getDetails = new TestDataHelper()
	            .getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
	            .enterConsumptionForGas(getDetails, j)
					.clickGasMeterOptionNO().gasMeterYESandNO(getDetails)
					.compareAllRatesMonthlyGas();
	}
	}

//	@Test(groups = { GetaQuoteSS})
	public void compareAllJourneyGasQuarterly() throws InterruptedException {
	    Report.createTestLogHeader(
	            "Compare All Journey GAS-Comparing Unit,Night and Standing charge for 1st,2nd and 3rd Years-Quarter Calculation",
	            "AnonymousJourney");
		for (int j = 0; j <= 2; j++)
	    {
	    GetAQuoteDetails getDetails = new TestDataHelper()
	            .getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
	            .enterConsumptionForGas(getDetails, j)
					.clickGasMeterOptionNO().gasMeterYESandNO(getDetails)
					.compareAllRatesQuarterGas();
	}
	}

//	 @Test(groups = { GetaQuoteSS})
	public void compareAllJourneySignupMonthlyGas()
			throws InterruptedException {
    Report.createTestLogHeader(
            "Compare All Journey GAS-Comparing Sign Up Monthly-1st,2nd and 3 rd Year",
            "AnonymousJourney");
		for (int j = 0; j <= 2; j++)
    {
    	 GetAQuoteDetails getDetails = new TestDataHelper()
         .getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction()
					.clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
		    .enterConsumptionForGas(getDetails, j)
					.clickGasMeterOptionNO()
					.gasMeterYESandNO(getDetails)
					.compareAllMonthlySignUPGAS(j)
	        .clickContinuElecSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsMonthly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);
		}
	}

//	@Test(groups = { GetaQuoteSS})
	public void compareAllJourneySignupQuarterlyGas()
			throws InterruptedException {
  Report.createTestLogHeader(
          "Compare All Journey GAS-Comparing Sign Up Quarterly-1st,2nd and 3 rd Year",
          "AnonymousJourney");
		for (int j = 0; j <= 2; j++)
  {
  	 GetAQuoteDetails getDetails = new TestDataHelper()
       .getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction()
					.clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
		    .enterConsumptionForGas(getDetails, j)
					.clickGasMeterOptionNO()
					.gasMeterYESandNO(getDetails)
					.compareAllQuarterSignUPGAS(j)
	        .clickContinuElecSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsQuaterly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);
		}
	}

}
*/