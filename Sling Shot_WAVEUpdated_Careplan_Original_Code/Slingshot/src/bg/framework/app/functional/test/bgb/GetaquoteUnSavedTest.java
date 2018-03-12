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

public class GetaquoteUnSavedTest extends TestBase {
	
	
/**************************1st Year********************************/

//   @Test(groups = {Regression,GetaQuoteSS})
//	 @Test(groups = {GetaQuoteSS})
	public void electricityWithAddressMonthlyUnSaved() {
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
					.clickCalculateQuoteForElec()
					.verifyUnSavedQuoteStatus()
					.retreiveElectricityQuotesUI()
					.saveCurrentQuote1Year()
					.retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus()
					.clickMonthlyQuotepageContinue()
					.salesafter2ndtab();
    }
	}

//	 @Test(groups = {GetaQuoteSS})
	public void electricityWithAddressQuarterUnSaved() {
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
					.clickCalculateQuoteForElec().verifyUnSavedQuoteStatus().retreiveElectricityQuotesUI()
					.selectElectricityPaymentOptionQuaterly()
					.saveCurrentQuote1Year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus()
					.clickQuaterlyQuotepageContinue()
					.salesafter2ndtab();
    }
	}

//	 @Test(groups = {GetaQuoteSS})
	public void electricityWithAddressMonthlyUnSavedPC() {
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
					.clickCalculateQuoteForElec().verifyUnSavedQuoteStatus().retreiveElectricityQuotesUI()
					.saveCurrentQuote1Year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus()
					.clickMonthlyQuotepageContinue()
					.salesafter2ndtab();
    }
	}

	// @Test(groups = {GetaQuoteSS})
	public void electricityWithAddressQuarterUnSavedPC() {
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
					.clickCalculateQuoteForElec().verifyUnSavedQuoteStatus().retreiveElectricityQuotesUI()
					.selectElectricityPaymentOptionQuaterly()
					.saveCurrentQuote1Year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus()
					.clickQuaterlyQuotepageContinue()
					.salesafter2ndtab();
    }
	}

	/********************************************2nd Year*************************************/
	
	// @Test(groups = {GetaQuoteSS})
	public void electricityMonthlySecondYearUnSaved() {
		Report.createTestLogHeader(
				"Get A Quote-Electricity Monthly Calculation for 2 Year contract with Address",
				"AnonymousJourney");
		for (int j = 0; j <= 0; j++)
		{
        GetAQuoteDetails getDetails = new TestDataHelper()
                .getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickElecquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterElectricityAddress(getDetails)
					.enterConsumptionForEle(getDetails, j)
					.clickCalculateQuoteForElec().verifyUnSavedQuoteStatus()
					.validateSecondYearContractMonthly(getDetails)
					.saveCurrentQuote2Year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus()
					.clickQuaterlyContinueQuotePage2ndYear()
					.salesafter2ndtab();
    }
	}

	// @Test(groups = {GetaQuoteSS})
	public void electricityQuarterSecondYearUnSaved() {
		Report.createTestLogHeader(
				"Get A Quote-Electricity Quarter Calculation for 2 Year contract with Address",
				"AnonymousJourney");
		for (int j = 0; j <= 0; j++)
		{
        GetAQuoteDetails getDetails = new TestDataHelper()
                .getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickElecquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterElectricityAddress(getDetails)
					.enterConsumptionForEle(getDetails, j)
					.clickCalculateQuoteForElec().verifyUnSavedQuoteStatus()
					.validateSecondYearContractQuarter(getDetails)
					.saveCurrentQuote2Year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus()
					.clickQuaterlyContinueQuotePage2ndYear()
					.salesafter2ndtab();
    }
	}

	// @Test(groups = {GetaQuoteSS})
	public void electricityMonthlySecondYearUnSavedPC() {
		Report.createTestLogHeader(
				"Get A Quote-Electricity 2 Year Monthly Calculation with Supply Code",
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
					.clickCalculateQuoteForElec().verifyUnSavedQuoteStatus()
					.validateSecondYearContractMonthly(getDetails)
					.saveCurrentQuote2Year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus()
					.clickQuaterlyContinueQuotePage2ndYear()
					.salesafter2ndtab();
		}
	}

	// @Test(groups = {GetaQuoteSS})
	public void electricityQuarterSecondYearUnSavedPC() {
		Report.createTestLogHeader(
				"Get A Quote-Electricity 2 Year Quarter Calculation with Supply Code",
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
					.clickCalculateQuoteForElec().verifyUnSavedQuoteStatus()
					.validateSecondYearContractQuarter(getDetails)
					.saveCurrentQuote2Year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus()
					.clickQuaterlyContinueQuotePage2ndYear()
					.salesafter2ndtab();
		}
	}

	/********************************************3rd Year*************************************/

//	 @Test(groups = {GetaQuoteSS})
	public void electricityMonthlyThirdYearUnsaved() {
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
					.clickCalculateQuoteForElec().verifyUnSavedQuoteStatus().click3rdYearTab()
					.saveCurrentQuote3year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus()
					.click3rdYearTab()
					.clickQuaterlyContinueQuotePage3rdYear()
					.salesafter2ndtab();
		}
	}

	// @Test(groups = {GetaQuoteSS})
	public void electricityQuaterlyThirdYearUnsaved() {
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
					.clickCalculateQuoteForElec().verifyUnSavedQuoteStatus().clickQuaterlybutton3rdYear()
					.saveCurrentQuote3year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus()
					.clickQuaterlybutton3rdYear()
					.clickQuaterlyContinueQuotePage3rdYear()
					.salesafter2ndtab();
		}
	}

	// @Test(groups = {GetaQuoteSS})
	public void electricityMonthlyThirdYearSCUnsaved() {
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
					.clickCalculateQuoteForElec().verifyUnSavedQuoteStatus().click3rdYearTab()
					.saveCurrentQuote3year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus()
					.click3rdYearTab()
					.clickQuaterlyContinueQuotePage3rdYear()
					.salesafter2ndtab();
		}
	}

	// @Test(groups = {GetaQuoteSS})
	public void electricityQuaterlyThirdYearSCUnsaved() {
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
					.clickCalculateQuoteForElec().verifyUnSavedQuoteStatus().clickQuaterlybutton3rdYear()
					.saveCurrentQuote3year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus()
					.clickQuaterlybutton3rdYear()
					.clickQuaterlyContinueQuotePage3rdYear()
					.salesafter2ndtab();
		}
	}

	/********************************************Compare All tab*************************************/
	
	// @Test(groups = {GetaQuoteSS})
	public void compareAllJourneyEleUnsaved() throws Exception {
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
					.clickCalculateQuoteForElec().verifyUnSavedQuoteStatus().clickcompareallTab()
					.saveCurrentQuoteCompareAllTab()
					.retreiveSavedQuote(getDetails).verifySavedQuoteStatus();
		}
	}

	// @Test(groups = { GetaQuoteSS})
	public void compareAllJourneyEleAddressUnsaved() {
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
					.clickCalculateQuoteForElec().verifyUnSavedQuoteStatus().clickcompareallTab()
					.clickQuaterlybuttonCompareAllTab()
					.saveCurrentQuoteCompareAllTab()
					.retreiveSavedQuote(getDetails).verifySavedQuoteStatus();
		}
	}

	/********************************************GAS*************************************/
	/********************************************1st Year*************************************/

	// @Test(groups = { GetaQuoteSS})
	public void gasUnSaved1YearMonthlyGasMeterNOGas() throws InterruptedException {
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
					.verifyUnSavedQuoteStatus()
					.click1stYearTabGas().saveCurrentQuote1year()
					.retreiveSavedQuote(getDetails).verifySavedQuoteStatus();
		}
	}

	// @Test(groups = { GetaQuoteSS})
	public void gasUnSaved1YearQuarterGasMeterNOGas() throws InterruptedException {
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
					.verifyUnSavedQuoteStatus()
					.click1stYearTabGas()
					.clickQuaterlybutton1stYearGas(getDetails)
					.saveCurrentQuote1year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus();
		}
	}

	// @Test(groups = { GetaQuoteSS})
	public void gasUnSaved1YearmonthlyGasMeterYESGas() throws InterruptedException {
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
					.gasMeterYESandNO(getDetails).verifyUnSavedQuoteStatus()
					.click1stYearTabGas()
					.saveCurrentQuote1year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus();
		}
	}

	public void gasUnSaved1YearQuarterGasMeterYESGas() throws InterruptedException {
		Report.createTestLogHeader(
				"GAS Journey-_1Year_quarter CalaulationGasMeter_YESGas",
				"AnonymousJourney");
		for (int j = 0; j <= 0; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterConsumptionForGas(getDetails, j)
					.gasMeterYESandNO(getDetails).verifyUnSavedQuoteStatus()
					.click1stYearTabGas()
					.clickQuaterlybutton1stYearGas(getDetails)
					.saveCurrentQuote1year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus();
		}
	}

	/********************************************2nd Year*************************************/

	// @Test(groups = { GetaQuoteSS})
	public void gasUnSaved2YearMonthlyGasMeterNOGas() throws InterruptedException {
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
					.verifyUnSavedQuoteStatus()
					.click2ndYearTab().saveCurrentQuote2Year()
					.savedtextverificationmonthly(getDetails)
					.retreiveSavedQuote(getDetails).verifySavedQuoteStatus();

		}
	}

	// @Test(groups = { GetaQuoteSS})
	public void gasUnSaved2YearQuarterGasMeterNOGas() throws InterruptedException {
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
					.verifyUnSavedQuoteStatus()
					.click2ndYearTab()
					.clickQuaterlybutton2ndYearGas(getDetails)
					.saveCurrentQuote2Year()
					.savedtextverificationquarter(getDetails)
					.retreiveSavedQuote(getDetails).verifySavedQuoteStatus();

		}
	}

	// @Test(groups = { GetaQuoteSS})
	public void gasUnSaved2YearMonthlyGasMeterYESGas() throws InterruptedException {
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
					.gasMeterYESandNO(getDetails)
					.verifyUnSavedQuoteStatus()
					.click2ndYearTab()
					.saveCurrentQuote2Year()
					.savedtextverificationmonthly(getDetails)
					.retreiveSavedQuote(getDetails).verifySavedQuoteStatus();
		}
	}

	// @Test(groups = { GetaQuoteSS})
	public void gasUnSaved2YearquarterGasMeterYESGas() throws InterruptedException {
		Report.createTestLogHeader(
				"GAS Journey-2Year_quarter CalaulationGasMeter_YESGas",
				"AnonymousJourney");
		for (int j = 0; j <= 0; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetAQuoteAction().clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterConsumptionForGas(getDetails, j)
					.gasMeterYESandNO(getDetails)
					.verifyUnSavedQuoteStatus()
					.click2ndYearTab()
					.clickQuaterlybutton2ndYearGas(getDetails)
					.saveCurrentQuote2Year()
					.savedtextverificationquarter(getDetails)
					.retreiveSavedQuote(getDetails).verifySavedQuoteStatus();
		}
	}

	/********************************************3rd Year*************************************/

//	@Test(groups = { GetaQuoteSS})
	public void gasUnSaved3YearMonthlyGasMeterNOGas() throws InterruptedException {
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
					.verifyUnSavedQuoteStatus()
					.click3rdYearTabGas()
					.saveCurrentQuote3year()
					.savedtextverificationmonthly(getDetails)
					.retreiveSavedQuote(getDetails).verifySavedQuoteStatus();
		}
	}

//	 @Test(groups = { GetaQuoteSS})
	public void gasUnSaved3YearMonthlyGasMeterYESGas() throws InterruptedException {
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
					.gasMeterYESandNO(getDetails)
					.verifyUnSavedQuoteStatus()
					.click3rdYearTabGas()
					.saveCurrentQuote3year()
					.savedtextverificationmonthly(getDetails)
					.retreiveSavedQuote(getDetails).verifySavedQuoteStatus();
		}
	}

//	 @Test(groups = { GetaQuoteSS})
	public void gasUnSaved3YearQuarterGasMeterNOGas() throws InterruptedException {
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
					.verifyUnSavedQuoteStatus()
					.click3rdYearTabGas()
					.clickQuaterlybutton3rdYearGas(getDetails)
					.saveCurrentQuote3year()
					.savedtextverificationquarter(getDetails)
					.retreiveSavedQuote(getDetails).verifySavedQuoteStatus();
		}
	}

//	 @Test(groups = { GetaQuoteSS})
	public void gasUnSaved3YearQuarterGasMeterYESGas() throws InterruptedException {
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
					.gasMeterYESandNO(getDetails)
					.verifyUnSavedQuoteStatus()
					.click3rdYearTabGas()
					.clickQuaterlybutton3rdYearGas(getDetails)
					.saveCurrentQuote3year()
					.savedtextverificationquarter(getDetails)
					.retreiveSavedQuote(getDetails).verifySavedQuoteStatus();
		}
	}
	
	/********************************************Compare All tab*************************************/
	
//	@Test(groups = { GetaQuoteSS})
	public void comparealltabUnsavedGas() throws InterruptedException {
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
	            .verifyUnSavedQuoteStatus()
	            .clickcompareallTab()
				.saveCurrentQuoteCompareAllTab()
				.savedtextverificationmonthly(getDetails)
				.retreiveSavedQuote(getDetails).verifySavedQuoteStatus();
	}
	}


/*************************************DUAL Journey Supply Code-Gas Meter**********************************************************/

//	@Test(groups = {GetaQuoteSS})
	public void dualFirstWithoutAddressMonthlyUnSaved() {
		Report.createTestLogHeader(
				"Get A Quote-Dual 1st Year Monthly Saved, Unsaved, Sales jurney with Profile class, Gasmeter",
				"AnonymousJourney");
		String Qrnno="1";
		for (int j = 0; j <= 0; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetaquoteCombinedEnergyAction()
				.clickCombinedEnergyLink()
				.enterGetaQuoteDetails(getDetails)
				.enterSupplycodeMannualyElectricity(getDetails)
				.updateSupplypointValues(1)
				.enterConsumptionForEle(getDetails, j)
				.gascSupplyDetailsManually(getDetails)
				.enterConsumptionForGas(getDetails, j)
				.calculateQuoteForElec()
				.verifyUnSavedQuoteStatus(Qrnno)
				.saveCurrentQuote1Year()
				.retreiveSavedQuote(getDetails)
				.verifySavedQuoteStatus()
				.clickMonthlyQuotepageContinue1stYear();
			new GetAQuoteAction()
				.salesafter2ndtab();
		}
		}
	
//	@Test(groups = {GetaQuoteSS})
	public void dualFirstWithoutAddressQuarterUnSaved() {
		Report.createTestLogHeader(
				"Get A Quote-Dual 1st Year Quarter Saved, Unsaved, Sales jurney with Profile class, Gasmeter",
				"AnonymousJourney");
		String Qrnno="1";
		for (int j = 0; j <= 0; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetaquoteCombinedEnergyAction()
				.clickCombinedEnergyLink()
				.enterGetaQuoteDetails(getDetails)
				.enterSupplycodeMannualyElectricity(getDetails)
				.updateSupplypointValues(1)
				.enterConsumptionForEle(getDetails, j)
				.gascSupplyDetailsManually(getDetails)
				.enterConsumptionForGas(getDetails, j)
				.calculateQuoteForElec()
				.clickQuaterlybutton1stYear(getDetails)
				.verifyUnSavedQuoteStatus(Qrnno)
				.saveCurrentQuote1Year()
				.retreiveSavedQuote(getDetails)
				.verifySavedQuoteStatus()
				.clickMonthlyQuotepageContinue1stYear();
			new GetAQuoteAction()
				.salesafter2ndtab();
		}
		}

//	@Test(groups = {GetaQuoteSS})
	public void dualSecondWithoutAddressMonthlyUnSaved() {
		Report.createTestLogHeader(
				"Get A Quote-Dual 2nd Year Monthly Saved, Unsaved, Sales jurney with Profile class, Gasmeter",
				"AnonymousJourney");
		String Qrnno="2";
		for (int j = 0; j <= 0; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetaquoteCombinedEnergyAction()
				.clickCombinedEnergyLink()
				.enterGetaQuoteDetails(getDetails)
				.enterSupplycodeMannualyElectricity(getDetails)
				.updateSupplypointValues(1)
				.enterConsumptionForEle(getDetails, j)
				.gascSupplyDetailsManually(getDetails)
				.enterConsumptionForGas(getDetails, j)
				.calculateQuoteForElec()
				.click2ndYearTabDual(getDetails)
				.verifyUnSavedQuoteStatus(Qrnno)
				.saveCurrentQuote2Year()
				.retreiveSavedQuote(getDetails)
				.verifySavedQuoteStatus()
				.click2ndYearTabDual(getDetails)
				.clickMonthlyQuotepageContinue2ndYear();
			new GetAQuoteAction()
				.salesafter2ndtab();
		}
		}
	
//	@Test(groups = {GetaQuoteSS})
	public void dualSecondWithoutAddressQuarterUnSaved() {
		Report.createTestLogHeader(
				"Get A Quote-Dual 2nd Year Quarter Saved, Unsaved, Sales jurney with Profile class, Gasmeter",
				"AnonymousJourney");
		String Qrnno="2";
		for (int j = 0; j <= 0; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetaquoteCombinedEnergyAction()
				.clickCombinedEnergyLink()
				.enterGetaQuoteDetails(getDetails)
				.enterSupplycodeMannualyElectricity(getDetails)
				.updateSupplypointValues(1)
				.enterConsumptionForEle(getDetails, j)
				.gascSupplyDetailsManually(getDetails)
				.enterConsumptionForGas(getDetails, j)
				.calculateQuoteForElec()
				.validateSecondYearContractQuarter(getDetails)
				.verifyUnSavedQuoteStatus(Qrnno)
				.saveCurrentQuote2Year()
				.retreiveSavedQuote(getDetails)
				.verifySavedQuoteStatus()
				.validateSecondYearContractQuarter(getDetails)
				.clickMonthlyQuotepageContinue2ndYear();
			new GetAQuoteAction()
				.salesafter2ndtab();
		}
		}


//	@Test(groups = {GetaQuoteSS})
	public void dualthirdWithoutAddressMonthlyUnSaved() {
		Report.createTestLogHeader(
				"Get A Quote-Dual 3rd Year Monthly Saved, Unsaved, Sales jurney with Profile class, Gasmeter",
				"AnonymousJourney");
		String Qrnno="3";
		for (int j = 0; j <= 0; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetaquoteCombinedEnergyAction()
				.clickCombinedEnergyLink()
				.enterGetaQuoteDetails(getDetails)
				.enterSupplycodeMannualyElectricity(getDetails)
				.updateSupplypointValues(1)
				.enterConsumptionForEle(getDetails, j)
				.gascSupplyDetailsManually(getDetails)
				.enterConsumptionForGas(getDetails, j)
				.calculateQuoteForElec()
				.click3rdYearTabDual(getDetails)
				.verifyUnSavedQuoteStatus(Qrnno)
				.saveCurrentQuote3Year()
				.retreiveSavedQuote(getDetails)
				.verifySavedQuoteStatus()
				.click3rdYearTabDual(getDetails)
				.clickMonthlyQuotepageContinue3rdYear();
			new GetAQuoteAction()
				.salesafter2ndtab();
		}
		}
	
//	@Test(groups = {GetaQuoteSS})
	public void dualthirdWithoutAddressQuarterUnSaved() {
		Report.createTestLogHeader(
				"Get A Quote-Dual 3rd Year Quarter Saved, Unsaved, Sales jurney with Profile class, Gasmeter",
				"AnonymousJourney");
		String Qrnno="3";
		for (int j = 0; j <= 0; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetaquoteCombinedEnergyAction()
				.clickCombinedEnergyLink()
				.enterGetaQuoteDetails(getDetails)
				.enterSupplycodeMannualyElectricity(getDetails)
				.updateSupplypointValues(1)
				.enterConsumptionForEle(getDetails, j)
				.gascSupplyDetailsManually(getDetails)
				.enterConsumptionForGas(getDetails, j)
				.calculateQuoteForElec()
				.click3rdYearTabDualQuarter(getDetails)
				.verifyUnSavedQuoteStatus(Qrnno)
				.saveCurrentQuote3Year()
				.retreiveSavedQuote(getDetails)
				.verifySavedQuoteStatus()
				.click3rdYearTabDualQuarter(getDetails)
				.clickMonthlyQuotepageContinue3rdYear();
			new GetAQuoteAction()
				.salesafter2ndtab();
		}
		}
	
//	@Test(groups = {GetaQuoteSS})
	public void dualCompareTabWithoutAddressMonthlyUnSaved() {
		Report.createTestLogHeader(
				"Get A Quote-Dual 3rd Year Monthly Saved, Unsaved, Sales jurney with Profile class, Gasmeter",
				"AnonymousJourney");
		String Qrnno="4";
		for (int j = 0; j <= 0; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetaquoteCombinedEnergyAction()
				.clickCombinedEnergyLink()
				.enterGetaQuoteDetails(getDetails)
				.enterSupplycodeMannualyElectricity(getDetails)
				.updateSupplypointValues(1)
				.enterConsumptionForEle(getDetails, j)
				.gascSupplyDetailsManually(getDetails)
				.enterConsumptionForGas(getDetails, j)
				.calculateQuoteForElec()
				.clickCompreTabDual(getDetails)
				.verifyUnSavedQuoteStatus(Qrnno)
				.saveCurrentQuoteCompareAllTab()
				.retreiveSavedQuote(getDetails)
				.verifySavedQuoteStatus();

		}
		}
	
//	@Test(groups = {GetaQuoteSS})
	public void dualCompareTabWithoutAddressQuarterUnSaved() {
		Report.createTestLogHeader(
				"Get A Quote-Dual 3rd Year Quarter Saved, Unsaved, Sales jurney with Profile class, Gasmeter",
				"AnonymousJourney");
		String Qrnno="4";
		for (int j = 0; j <= 0; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetaquoteCombinedEnergyAction()
				.clickCombinedEnergyLink()
				.enterGetaQuoteDetails(getDetails)
				.enterSupplycodeMannualyElectricity(getDetails)
				.updateSupplypointValues(1)
				.enterConsumptionForEle(getDetails, j)
				.gascSupplyDetailsManually(getDetails)
				.enterConsumptionForGas(getDetails, j)
				.calculateQuoteForElec()
				.clickCompareTabDualQuarter(getDetails)
				.verifyUnSavedQuoteStatus(Qrnno)
				.saveCurrentQuoteCompareAllTab()
				.retreiveSavedQuote(getDetails)
				.verifySavedQuoteStatus();
		}
		}
	
/*************************************DUAL Journey Address-Address**********************************************************/

//	@Test(groups = {GetaQuoteSS})
	public void dualFirstWithAddressMonthlyUnSaved() {
		Report.createTestLogHeader(
				"Get A Quote-Dual 1st Year Monthly Saved, Unsaved, Sales jurney with Profile class, Gasmeter",
				"AnonymousJourney");
		String Qrnno="1";
		for (int j = 0; j <= 0; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetaquoteCombinedEnergyAction()
				.clickCombinedEnergyLink()
				.enterGetaQuoteDetails(getDetails)
				.electricityAddressAndUsage(getDetails)
				.enterConsumptionForEle(getDetails, j)
				.enterGasAddressAndUsage(getDetails)
				.enterConsumptionForGas(getDetails, j)
				.calculateQuoteForElec()
				.verifyUnSavedQuoteStatus(Qrnno)
				.saveCurrentQuote1Year()
				.retreiveSavedQuote(getDetails)
				.verifySavedQuoteStatus()
				.clickMonthlyQuotepageContinue1stYear();
			new GetAQuoteAction()
				.salesafter2ndtab();
		}
		}
	
//	@Test(groups = {GetaQuoteSS})
	public void dualFirstWithAddressQuarterUnSaved() {
		Report.createTestLogHeader(
				"Get A Quote-Dual 1st Year Quarter Saved, Unsaved, Sales jurney with Profile class, Gasmeter",
				"AnonymousJourney");
		String Qrnno="1";
		for (int j = 0; j <= 0; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetaquoteCombinedEnergyAction()
				.clickCombinedEnergyLink()
				.enterGetaQuoteDetails(getDetails)
				.electricityAddressAndUsage(getDetails)
				.enterConsumptionForEle(getDetails, j)
				.enterGasAddressAndUsage(getDetails)
				.enterConsumptionForGas(getDetails, j)
				.clickQuaterlybutton1stYear(getDetails)
				.calculateQuoteForElec()
				.verifyUnSavedQuoteStatus(Qrnno)
				.saveCurrentQuote1Year()
				.retreiveSavedQuote(getDetails)
				.verifySavedQuoteStatus()
				.clickMonthlyQuotepageContinue1stYear();
			new GetAQuoteAction()
				.salesafter2ndtab();
		}
		}

	@Test(groups = {GetaQuoteSS})
	public void dualSecondWithAddressMonthlyUnSaved() {
		Report.createTestLogHeader(
				"Get A Quote-Dual 2nd Year Monthly Saved, Unsaved, Sales jurney with Profile class, Gasmeter",
				"AnonymousJourney");
		String Qrnno="2";
		for (int j = 0; j <= 0; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetaquoteCombinedEnergyAction()
				.clickCombinedEnergyLink()
				.enterGetaQuoteDetails(getDetails)
				.electricityAddressAndUsage(getDetails)
				.enterConsumptionForEle(getDetails, j)
				.enterGasAddressAndUsage(getDetails)
				.enterConsumptionForGas(getDetails, j)
				.calculateQuoteForElec()
				.click2ndYearTabDual(getDetails)
				.verifyUnSavedQuoteStatus(Qrnno)
				.saveCurrentQuote2Year()
				.retreiveSavedQuote(getDetails)
				.verifySavedQuoteStatus()
				.click2ndYearTabDual(getDetails)
				.clickMonthlyQuotepageContinue2ndYear();
			new GetAQuoteAction()
				.salesafter2ndtab();
		}
		}
	
//	@Test(groups = {GetaQuoteSS})
	public void dualSecondWithAddressQuarterUnSaved() {
		Report.createTestLogHeader(
				"Get A Quote-Dual 2nd Year Quarter Saved, Unsaved, Sales jurney with Profile class, Gasmeter",
				"AnonymousJourney");
		String Qrnno="2";
		for (int j = 0; j <= 0; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetaquoteCombinedEnergyAction()
				.clickCombinedEnergyLink()
				.enterGetaQuoteDetails(getDetails)
				.electricityAddressAndUsage(getDetails)
				.enterConsumptionForEle(getDetails, j)
				.enterGasAddressAndUsage(getDetails)
				.enterConsumptionForGas(getDetails, j)
				.calculateQuoteForElec()
				.validateSecondYearContractQuarter(getDetails)
				.verifyUnSavedQuoteStatus(Qrnno)
				.saveCurrentQuote2Year()
				.retreiveSavedQuote(getDetails)
				.verifySavedQuoteStatus()
				.validateSecondYearContractQuarter(getDetails)
				.clickMonthlyQuotepageContinue2ndYear();
			new GetAQuoteAction()
				.salesafter2ndtab();
		}
		}


//	@Test(groups = {GetaQuoteSS})
	public void dualthirdWithAddressMonthlyUnSaved() {
		Report.createTestLogHeader(
				"Get A Quote-Dual 3rd Year Monthly Saved, Unsaved, Sales jurney with Profile class, Gasmeter",
				"AnonymousJourney");
		String Qrnno="3";
		for (int j = 0; j <= 0; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetaquoteCombinedEnergyAction()
				.clickCombinedEnergyLink()
				.enterGetaQuoteDetails(getDetails)
				.electricityAddressAndUsage(getDetails)
				.enterConsumptionForEle(getDetails, j)
				.enterGasAddressAndUsage(getDetails)
				.enterConsumptionForGas(getDetails, j)
				.click3rdYearTabDual(getDetails)
				.verifyUnSavedQuoteStatus(Qrnno)
				.saveCurrentQuote3Year()
				.retreiveSavedQuote(getDetails)
				.verifySavedQuoteStatus()
				.click3rdYearTabDual(getDetails)
				.clickMonthlyQuotepageContinue3rdYear();
			new GetAQuoteAction()
				.salesafter2ndtab();
		}
		}
	
//	@Test(groups = {GetaQuoteSS})
	public void dualthirdWithAddressQuarterUnSaved() {
		Report.createTestLogHeader(
				"Get A Quote-Dual 3rd Year Quarter Saved, Unsaved, Sales jurney with Profile class, Gasmeter",
				"AnonymousJourney");
		String Qrnno="3";
		for (int j = 0; j <= 0; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetaquoteCombinedEnergyAction()
				.clickCombinedEnergyLink()
				.enterGetaQuoteDetails(getDetails)
				.electricityAddressAndUsage(getDetails)
				.enterConsumptionForEle(getDetails, j)
				.enterGasAddressAndUsage(getDetails)
				.enterConsumptionForGas(getDetails, j)
				.click3rdYearTabDualQuarter(getDetails)
				.verifyUnSavedQuoteStatus(Qrnno)
				.saveCurrentQuote3Year()
				.retreiveSavedQuote(getDetails)
				.verifySavedQuoteStatus()
				.click3rdYearTabDualQuarter(getDetails)
				.clickMonthlyQuotepageContinue3rdYear();
			new GetAQuoteAction()
				.salesafter2ndtab();
		}
		}
	
//	@Test(groups = {GetaQuoteSS})
	public void dualCompareTabWithAddressMonthlyUnSaved() {
		Report.createTestLogHeader(
				"Get A Quote-Dual 3rd Year Monthly Saved, Unsaved, Sales jurney with Profile class, Gasmeter",
				"AnonymousJourney");
		String Qrnno="4";
		for (int j = 0; j <= 0; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetaquoteCombinedEnergyAction()
				.clickCombinedEnergyLink()
				.enterGetaQuoteDetails(getDetails)
				.electricityAddressAndUsage(getDetails)
				.enterConsumptionForEle(getDetails, j)
				.enterGasAddressAndUsage(getDetails)
				.enterConsumptionForGas(getDetails, j)
				.clickCompreTabDual(getDetails)
				.verifyUnSavedQuoteStatus(Qrnno)
				.saveCurrentQuoteCompareAllTab()
				.retreiveSavedQuote(getDetails)
				.verifySavedQuoteStatus();

		}
		}
	
//	@Test(groups = {GetaQuoteSS})
	public void dualCompareTabWithAddressQuarterUnSaved() {
		Report.createTestLogHeader(
				"Get A Quote-Dual 3rd Year Quarter Saved, Unsaved, Sales jurney with Profile class, Gasmeter",
				"AnonymousJourney");
		String Qrnno="4";
		for (int j = 0; j <= 0; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getallGetAQuoteDetails("gaqdetails");
			new GetaquoteCombinedEnergyAction()
				.clickCombinedEnergyLink()
				.enterGetaQuoteDetails(getDetails)
				.electricityAddressAndUsage(getDetails)
				.enterConsumptionForEle(getDetails, j)
				.enterGasAddressAndUsage(getDetails)
				.enterConsumptionForGas(getDetails, j)
				.clickCompareTabDualQuarter(getDetails)
				.verifyUnSavedQuoteStatus(Qrnno)
				.saveCurrentQuoteCompareAllTab()
				.retreiveSavedQuote(getDetails)
				.verifySavedQuoteStatus();
		}
		}
}