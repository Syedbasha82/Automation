package bg.framework.app.functional.test.bgb;

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

public class GetaquoteSaveTest extends TestBase {

	/********************************************1st Year*************************************/

//   @Test(groups = {Regression,GetaQuoteSS})
//	 @Test(groups = {GetaQuoteSS})
	public void electricityWithAddressMonthlySaved() {
		Report.createTestLogHeader(
				"Get A Quote-Electricity 1st Year Monthly Saved Journey with Address",
				"AnonymousJourney");
		for (int j = 0; j <= 0; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickElecquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterElectricityAddress(getDetails)
					.enterConsumptionForEle(getDetails, j)
					.clickCalculateQuoteForElec().retreiveElectricityQuotesUI()
					.saveCurrentQuote1Year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus();
		}
	}

	// @Test(groups = {Regression,GetaQuoteSS})
//	 @Test(groups = {GetaQuoteSS})
	public void electricityWithAddressQuarterSaved() {
		Report.createTestLogHeader(
				"Get A Quote-Electricity 1st Year Quarter Saved Journey with Address",
                "AnonymousJourney");
		for (int j = 0; j <= 0; j++) {
        GetAQuoteDetails getDetails = new TestDataHelper()
                .getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickElecquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterElectricityAddress(getDetails)
					.enterConsumptionForEle(getDetails, j)
					.clickCalculateQuoteForElec().retreiveElectricityQuotesUI()
					.selectElectricityPaymentOptionQuaterly()
					.saveCurrentQuote1Year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus();
    }
	}

	// @Test(groups = {GetaQuoteSS})
	public void electricityWithAddressMonthlySavedPC() {
		Report.createTestLogHeader(
				"Get A Quote-Electricity 1st Year Monthly Saved Journey with SupplyCode",
                "AnonymousJourney");
		int ProfileClass = 1;
		for (int j = 0; j <= 0; j++)
		{
        GetAQuoteDetails getDetails = new TestDataHelper()
                .getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickElecquoteLink().enterGetaQuoteDetails(
					getDetails);
			new GetaquoteCombinedEnergyAction()
					.enterSupplycodeMannualyElectricity(getDetails)
					.updateSupplypointValues(ProfileClass);
			new GetAQuoteAction().enterConsumptionForEle(getDetails, j)
					.clickCalculateQuoteForElec().retreiveElectricityQuotesUI()
					.saveCurrentQuote1Year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus();
    }
	}

	// @Test(groups = {GetaQuoteSS})
	public void electricityWithAddressQuarterSavedPC() {
		Report.createTestLogHeader(
				"Get A Quote-Electricity 1st Year Quarter Saved Journey with SupplyCode",
				"AnonymousJourney");
		int ProfileClass = 1;
		for (int j = 0; j <= 0; j++)
		{
        GetAQuoteDetails getDetails = new TestDataHelper()
                .getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickElecquoteLink().enterGetaQuoteDetails(
					getDetails);
			new GetaquoteCombinedEnergyAction()
					.enterSupplycodeMannualyElectricity(getDetails)
					.updateSupplypointValues(ProfileClass);
			new GetAQuoteAction().enterConsumptionForEle(getDetails, j)
					.clickCalculateQuoteForElec().retreiveElectricityQuotesUI()
					.selectElectricityPaymentOptionQuaterly()
					.saveCurrentQuote1Year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus();
    }
	}

	/********************************************2nd Year*************************************/
	
	// @Test(groups = {GetaQuoteSS})
	public void electricityMonthlySecondYearSaved() {
		Report.createTestLogHeader(
				"Get A Quote-Electricity 2nd Year Monthly Saved Journey with Address",
				"AnonymousJourney");
		for (int j = 0; j <= 0; j++)

		{
        GetAQuoteDetails getDetails = new TestDataHelper()
                .getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickElecquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterElectricityAddress(getDetails)
					.enterConsumptionForEle(getDetails, j)
					.clickCalculateQuoteForElec()
					.validateSecondYearContractMonthly(getDetails)
					.saveCurrentQuote2Year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus();
		}
	}

	// @Test(groups = {GetaQuoteSS})
	public void electricityQuarterSecondYearSaved() {
		Report.createTestLogHeader(
				"Get A Quote-Electricity 2nd Year Quarter Saved Journey with Address",
				"AnonymousJourney");
		for (int j = 0; j <= 0; j++)

		{
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickElecquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterElectricityAddress(getDetails)
					.enterConsumptionForEle(getDetails, j)
					.clickCalculateQuoteForElec()
					.validateSecondYearContractQuarter(getDetails)
					.saveCurrentQuote2Year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus();
    }
	}

	// @Test(groups = {GetaQuoteSS})
	public void electricityMonthlySecondYearSavedPC() {
		Report.createTestLogHeader(
				"Get A Quote-Electricity 2nd Year Monthly Saved Journey with Supply Code",
                "AnonymousJourney");
		for (int j = 0; j <= 0; j++)

		{
        GetAQuoteDetails getDetails = new TestDataHelper()
                .getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickElecquoteLink().enterGetaQuoteDetails(
					getDetails);
			new GetaquoteCombinedEnergyAction()
					.enterSupplycodeMannualyElectricity(getDetails)
					.updateSupplypointValues(1);
			new GetAQuoteAction().enterConsumptionForEle(getDetails, j)
					.clickCalculateQuoteForElec()
					.validateSecondYearContractMonthly(getDetails)
					.saveCurrentQuote2Year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus();
    }
	}

	// @Test(groups = {GetaQuoteSS})
	public void electricityQuarterSecondYearSavedPC() {
		Report.createTestLogHeader(
				"Get A Quote-Electricity 2nd Year Quarter Saved Journey with Supply Code",
                "AnonymousJourney");
		for (int j = 0; j <= 0; j++)
		{
        GetAQuoteDetails getDetails = new TestDataHelper()
                .getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickElecquoteLink().enterGetaQuoteDetails(
					getDetails);
			new GetaquoteCombinedEnergyAction()
					.enterSupplycodeMannualyElectricity(getDetails)
					.updateSupplypointValues(1);
			new GetAQuoteAction().enterConsumptionForEle(getDetails, j)
					.clickCalculateQuoteForElec()
					.validateSecondYearContractQuarter(getDetails)
					.saveCurrentQuote2Year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus();
    }
	}

	/********************************************3rd Year*************************************/

	// @Test(groups = {GetaQuoteSS})
	public void electricityMonthlyThirdYear() {
		Report.createTestLogHeader(
				"Get A Quote-Third year Monthy Calculation with Address",
				"AnonymousJourney");
		for (int j = 0; j <= 0; j++)
		{
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickElecquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterElectricityAddress(getDetails)
					.enterConsumptionForEle(getDetails, j)
					.clickCalculateQuoteForElec().click3rdYearTab()
					.saveCurrentQuote3year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus();
		}
	}

	// @Test(groups = {GetaQuoteSS})
	public void electricityQuaterlyThirdYear() {
		Report.createTestLogHeader(
				"Get A Quote-Third year Quarter Calculation with Address",
				"AnonymousJourney");
		for (int j = 0; j <= 0; j++)
		{
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickElecquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterElectricityAddress(getDetails)
					.enterConsumptionForEle(getDetails, j)
					.clickCalculateQuoteForElec().clickQuaterlybutton3rdYear()
					.saveCurrentQuote3year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus();
		}
	}

	// @Test(groups = {GetaQuoteSS})
	public void electricityMonthlyThirdYearSC() {
		Report.createTestLogHeader(
				"Get A Quote-Third year With Supply Code Monthly Calculation",
				"AnonymousJourney");
		for (int j = 0; j <= 0; j++)
		{
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickElecquoteLink().enterGetaQuoteDetails(
					getDetails);
			new GetaquoteCombinedEnergyAction()
					.enterSupplycodeMannualyElectricity(getDetails)
					.updateSupplypointValues(1);
			new GetAQuoteAction().enterConsumptionForEle(getDetails, j)
					.clickCalculateQuoteForElec().click3rdYearTab()
					.saveCurrentQuote3year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus();
		}
	}

	// @Test(groups = {GetaQuoteSS})
	public void electricityQuaterlyThirdYearSC() {
		Report.createTestLogHeader(
				"Get A Quote-Third year With Supply Code Quarter Calculation",
				"AnonymousJourney");
		for (int j = 0; j <= 0; j++)

		{
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickElecquoteLink().enterGetaQuoteDetails(
					getDetails);
			new GetaquoteCombinedEnergyAction()
					.enterSupplycodeMannualyElectricity(getDetails)
					.updateSupplypointValues(1);
			new GetAQuoteAction().enterConsumptionForEle(getDetails, j)
					.clickCalculateQuoteForElec().clickQuaterlybutton3rdYear()
					.saveCurrentQuote3year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus();
		}
	}

	/********************************************Comapre All Tab*************************************/

	// @Test(groups = {GetaQuoteSS})
	public void compareAllSavedEle() throws Exception {
		Report.createTestLogHeader(
				"Compare All Journey Electricity-Comparing Unit,Night and Standing charge for 1st,2nd and 3rd Years-WIth supplyCode and DB Valilation",
				"AnonymousJourney");

		for (int j = 0; j <= 0; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickElecquoteLink().enterGetaQuoteDetails(
					getDetails);
			new GetaquoteCombinedEnergyAction()
					.enterSupplycodeMannualyElectricity(getDetails)
					.updateSupplypointValues(1);
			new GetAQuoteAction().enterConsumptionForEle(getDetails, j)
					.clickCalculateQuoteForElec().clickcompareallTab()
					.saveCurrentQuoteCompareAllTab()
					.retreiveSavedQuote(getDetails).verifySavedQuoteStatus();
		}
	}

	// @Test(groups = { GetaQuoteSS})
	public void compareAllSavedEleAddress() {
		Report.createTestLogHeader(
				"Compare All Journey Electricity-Comparing Unit,Night and Standing charge for 1st,2nd and 3rd Years-Quarter and Monthly Calculation--With Address",
				"AnonymousJourney");
		for (int j = 0; j <= 0; j++)
		{
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickElecquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterElectricityAddress(getDetails)
					.enterConsumptionForEle(getDetails, j)
					.clickCalculateQuoteForElec().clickcompareallTab()
					.clickQuaterlybuttonCompareAllTab()
					.saveCurrentQuoteCompareAllTab()
					.retreiveSavedQuote(getDetails).verifySavedQuoteStatus();
		}
	}

	/********************************************Gas*************************************/
	
	/********************************************1st Year*************************************/

	// @Test(groups = { GetaQuoteSS})
	public void gasSaved1YearMonthlyGasMeterNoGas() throws InterruptedException {
		Report.createTestLogHeader(
				"GAS Journey-_1Year_monthly CalaulationGasMeter_NOGas",
				"AnonymousJourney");
		for (int j = 0; j <= 0; j++)
		{
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterConsumptionForGas(getDetails, j)
					.clickGasMeterOptionNO().gasMeterYESandNO(getDetails)
					.click1stYearTabGas().saveCurrentQuote1year()
					.retreiveSavedQuote(getDetails).verifySavedQuoteStatus();
		}
	}

	// @Test(groups = { GetaQuoteSS})
	public void gasSaved1YearQuarterGasMeterNoGas() throws InterruptedException {
		Report.createTestLogHeader(
				"GAS Journey-_1Year_quarter CalaulationGasMeter_NOGas",
				"AnonymousJourney");
		for (int j = 0; j <= 0; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterConsumptionForGas(getDetails, j)
					.clickGasMeterOptionNO().gasMeterYESandNO(getDetails)
					.click1stYearTabGas()
					.clickQuaterlybutton1stYearGas(getDetails)
					.saveCurrentQuote1year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus();
		}
	}

	// @Test(groups = { GetaQuoteSS})
	public void gasSaved1YearMonthlyGasMeterYesGas() throws InterruptedException {
		Report.createTestLogHeader(
				"GAS Journey-_1Year_monthly CalaulationGasMeter_YESGas",
				"AnonymousJourney");
		for (int j = 0; j <= 0; j++)
		{
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterConsumptionForGas(getDetails, j)
					.gasMeterYESandNO(getDetails).click1stYearTabGas()
					.saveCurrentQuote1year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus();
		}
	}

	// @Test(groups = { GetaQuoteSS})
	public void gasSaved1YearQuarterGasMeterYesGas() throws InterruptedException {
		Report.createTestLogHeader(
				"GAS Journey-_1Year_quarter CalaulationGasMeter_YESGas",
				"AnonymousJourney");
		for (int j = 0; j <= 0; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterConsumptionForGas(getDetails, j)
					.gasMeterYESandNO(getDetails).click1stYearTabGas()
					.clickQuaterlybutton1stYearGas(getDetails)
					.saveCurrentQuote1year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus();
		}
	}

	/********************************************2nd Year*************************************/

	// @Test(groups = { GetaQuoteSS})
	public void gasSaved2YearMonthlyGasMeterNoGas() throws InterruptedException {
		Report.createTestLogHeader(
				"GAS Journey-2Year_monthly CalaulationGasMeter_NOGas",
				"AnonymousJourney");
		for (int j = 0; j <= 0; j++)
		{
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterConsumptionForGas(getDetails, j)
					.clickGasMeterOptionNO().gasMeterYESandNO(getDetails)
					.click2ndYearTab().saveCurrentQuote2Year()
					.savedtextverificationmonthly(getDetails)
					.retreiveSavedQuote(getDetails).verifySavedQuoteStatus();
		}
	}

	// @Test(groups = { GetaQuoteSS})
	public void gasSaved2YearQuarterGasMeterNoGas() throws InterruptedException {
		Report.createTestLogHeader(
				"GAS Journey-2Year_quarter CalaulationGasMeter_NOGas",
				"AnonymousJourney");
		for (int j = 0; j <= 0; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)

					.enterConsumptionForGas(getDetails, j)
					.clickGasMeterOptionNO().gasMeterYESandNO(getDetails)
					.click2ndYearTab()
					.clickQuaterlybutton2ndYearGas(getDetails)
					.saveCurrentQuote2Year()
					.savedtextverificationquarter(getDetails)
					.retreiveSavedQuote(getDetails).verifySavedQuoteStatus();
		}
	}

	// @Test(groups = { GetaQuoteSS})
	public void gasSaved2YearMonthlyGasMeterYesGas() throws InterruptedException {
		Report.createTestLogHeader(
				"GAS Journey-2Year_monthly CalaulationGasMeter_YESGas",
				"AnonymousJourney");
		for (int j = 0; j <= 0; j++)
		{
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterConsumptionForGas(getDetails, j)
					.gasMeterYESandNO(getDetails).click2ndYearTab()
					.saveCurrentQuote2Year()
					.savedtextverificationmonthly(getDetails)
					.retreiveSavedQuote(getDetails).verifySavedQuoteStatus();
		}
	}

	// @Test(groups = { GetaQuoteSS})
	public void gasSaved2YearQuarterGasMeterYesGas() throws InterruptedException {
		Report.createTestLogHeader(
				"GAS Journey-2Year_quarter CalaulationGasMeter_YESGas",
				"AnonymousJourney");
		for (int j = 0; j <= 0; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterConsumptionForGas(getDetails, j)
					.gasMeterYESandNO(getDetails).click2ndYearTab()
					.clickQuaterlybutton2ndYearGas(getDetails)
					.saveCurrentQuote2Year()
					.savedtextverificationquarter(getDetails)
					.retreiveSavedQuote(getDetails).verifySavedQuoteStatus();
		}
	}

	/********************************************3rd Year*************************************/

//	@Test(groups = { GetaQuoteSS})
	public void gasSaved3YearMonthlyGasMeterNoGas() throws InterruptedException {
		Report.createTestLogHeader(
				"GAS Journey-_3Year_monthly CalaulationGasMeter_NOGas",
				"AnonymousJourney");
		for (int j = 0; j <= 0; j++)
		{
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterConsumptionForGas(getDetails, j)
					.clickGasMeterOptionNO().gasMeterYESandNO(getDetails)
					.click3rdYearTabGas()
					.saveCurrentQuote3year()
					.savedtextverificationmonthly(getDetails)
					.retreiveSavedQuote(getDetails).verifySavedQuoteStatus();
		}
	}

//	 @Test(groups = { GetaQuoteSS})
	public void gasSaved3YearQuarterGasMeterNoGas() throws InterruptedException {
		Report.createTestLogHeader(
				"GAS Journey-_3Year_quarter CalaulationGasMeter_NOGas",
				"AnonymousJourney");
		for (int j = 0; j <= 0; j++)
		{
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterConsumptionForGas(getDetails, j)
					.clickGasMeterOptionNO().gasMeterYESandNO(getDetails)
					.click3rdYearTabGas()
					.clickQuaterlybutton3rdYearGas(getDetails)
					.saveCurrentQuote3year()
					.savedtextverificationquarter(getDetails)
					.retreiveSavedQuote(getDetails).verifySavedQuoteStatus();
		}
	}
	
//	 @Test(groups = { GetaQuoteSS})
	public void gasSaved3YearMonthlyGasMeterYesGas() throws InterruptedException {
		Report.createTestLogHeader(
				"GAS Journey-_3Year_monthly CalaulationGasMeter_YESGas",
				"AnonymousJourney");
		for (int j = 0; j <= 0; j++)
		{
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterConsumptionForGas(getDetails, j)
					.gasMeterYESandNO(getDetails).click3rdYearTabGas()
					.saveCurrentQuote3year()
					.savedtextverificationmonthly(getDetails)
					.retreiveSavedQuote(getDetails).verifySavedQuoteStatus();
		}
	}

//	 @Test(groups = { GetaQuoteSS})
	public void gasSaved3YearQuarterGasMeterYesGas() throws InterruptedException {
		Report.createTestLogHeader(
				"GAS Journey-_3Year_quarter CalaulationGasMeter_YESGas",
				"AnonymousJourney");
		for (int j = 0; j <= 0; j++)
		{
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterConsumptionForGas(getDetails, j)
					.gasMeterYESandNO(getDetails).click3rdYearTabGas()
					.clickQuaterlybutton3rdYearGas(getDetails)
					.saveCurrentQuote3year()
					.savedtextverificationquarter(getDetails)
					.retreiveSavedQuote(getDetails).verifySavedQuoteStatus();
		}
	}
	
	/********************************************Compare All Tab*************************************/
	
//	@Test(groups = { GetaQuoteSS})
	public void comparealltabSavedGas() throws InterruptedException {
	    Report.createTestLogHeader(
	            "DB_PRICE_ValidationGas_Journey for 1st,2nd and 3rd Year",
	            "AnonymousJourney");
	    for(int j=0;j<=0;j++)
	    {
	    GetAQuoteDetails getDetails = new TestDataHelper()
	            .getallGetAQuoteDetails("gaqdetails");
	    new GetAQuoteAction().clickGasquoteLink().enterGetaQuoteDetails(getDetails)
	            .enterConsumptionForGas(getDetails, j)
	            .clickGasMeterOptionNO()
	            .gasMeterYESandNO(getDetails)
	            .clickcompareallTab()
				.saveCurrentQuoteCompareAllTab()
				.savedtextverificationmonthly(getDetails)
				.retreiveSavedQuote(getDetails).verifySavedQuoteStatus();
	}
	}
	
	/********************************************Gas Journey*****************************************/
	
	
}
