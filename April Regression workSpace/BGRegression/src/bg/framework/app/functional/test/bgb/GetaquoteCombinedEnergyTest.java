package bg.framework.app.functional.test.bgb;

import org.testng.annotations.Test;

import static bg.framework.app.functional.entities.FunctionalCategory.GetaQuoteSS;
import bg.framework.app.functional.action.bgb.GetAQuoteAction;
import bg.framework.app.functional.action.bgb.GetaquoteCombinedEnergyAction;
import bg.framework.app.functional.entities.GetAQuoteDetails;
import bg.framework.app.functional.page.bgb.GetaQuoteDetailsPage;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class GetaquoteCombinedEnergyTest extends TestBase {

////////////////////////////////Default Consumption 1st Year Monthly/////////////////////////////////////////	
//	 @Test(groups = { GetaQuoteSS})
	public void defaultConsumption() {
		Report.createTestLogHeader(
				"Dual Journey with Address Monthly Calculation-1st Year",
				"AnonymousJourney");
		String FirstMonthly = "1";
		String Dual = "Dual";
		for (int j = 0; j <= 2; j++) {
        GetAQuoteDetails getDetails = new TestDataHelper()
                .getGetAQuoteDetails ("gaqdetails");
			new GetaquoteCombinedEnergyAction()
			        .clickCombinedEnergyLink()
					.enterGetaQuoteDetails(getDetails)
					.enterSupplycodeMannualyElectricity(getDetails)
					.elecSupplyDetailsManuall(getDetails)
					.enterGasAddressAndUsage(getDetails)
					.enterConsumptionForGas(getDetails, j )
					.calculateQuoteForElec()
					.firstYearTextVerify(getDetails)
					.saveCurrentQuote1Year()
					.retreiveSavedQuote(getDetails)
					.firstYearAddressCalMonthlyQuarter(getDetails, FirstMonthly, Dual)
					.gasunitpricefromdbMonthlyQuarter1stYear(getDetails, FirstMonthly, Dual)
					.firstYearCalculationForGasEle( getDetails, FirstMonthly)
			        .defaultConsumptionSupplyCode1year(getDetails,8);
			 new GetaquoteCombinedEnergyAction()
			 		.calculatingConsumption1YearGas( getDetails, j)
					.clickMonthlyQuotepageContinue1stYear();
		}
	}
        
	// //////////////////////1st Year//////////////////////////////////////////////////////

	// @Test(groups = { GetaQuoteSS})
	public void dualAddressMonthlyFirstYear() {
		Report.createTestLogHeader(
				"Dual Journey with Address Monthly Calculation-1st Year",
				"AnonymousJourney");
		String FirstMonthly = "1";
		String Dual = "Dual";
		for (int j = 0; j <= 2; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getGetAQuoteDetails ("gaqdetails");
        new GetaquoteCombinedEnergyAction()
           .clickCombinedEnergyLink()
           .enterGetaQuoteDetails(getDetails)
					.electricityAddressAndUsage(getDetails)
					.enterConsumptionForEle(getDetails, j)
           .enterGasAddressAndUsage(getDetails)
					.enterConsumptionForGas(getDetails, j)
					.calculateQuoteForElec()
					.firstYearTextVerify(getDetails)
					.saveCurrentQuote1Year()
					.retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus()
					.firstYearAddressCalMonthlyQuarter(getDetails, FirstMonthly, Dual)
					.gasunitpricefromdbMonthlyQuarter1stYear(getDetails, FirstMonthly, Dual)
					.firstYearCalculationForGasEle( getDetails, FirstMonthly)
					.calculatingConsumption1YearEle( getDetails, j)
					.calculatingConsumption1YearGas( getDetails, j)
					.clickMonthlyQuotepageContinue1stYear();
		}
	}

//	 @Test(groups = { GetaQuoteSS})
	public void dualAddressQuarterFirstYear() {
		Report.createTestLogHeader(
				"Dual Journey with Address Quarter Calculation-1st Year",
				"AnonymousJourney");
		String FirstQuarter = "4";
		String Dual = "Dual";
		for (int j = 0; j <= 2; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getGetAQuoteDetails ("gaqdetails");
			new GetaquoteCombinedEnergyAction()
					.clickCombinedEnergyLink()
					.enterGetaQuoteDetails(getDetails)
					.electricityAddressAndUsage(getDetails)
					.enterConsumptionForEle(getDetails, j)
					.enterGasAddressAndUsage(getDetails)
					.enterConsumptionForGas(getDetails, j)
					.calculateQuoteForElec()
					.firstYearTextVerify(getDetails)
					.saveCurrentQuote1Year()
					.retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus()
					.clickQuaterlybutton1stYearGas(getDetails)
					.firstYearAddressCalMonthlyQuarter(getDetails, FirstQuarter, Dual)
					.gasunitpricefromdbMonthlyQuarter1stYear(getDetails, FirstQuarter, Dual)
					.firstYearCalculationForGasEle(getDetails, FirstQuarter)
					.calculatingConsumption1YearEle(getDetails, j)
					.calculatingConsumption1YearGas( getDetails, j)
					.clickMonthlyQuotepageContinue1stYear();
		}
	}
        
        
//	 @Test(groups = { GetaQuoteSS})
		public void dualProfileClassMonthlyFirstYear() {
			Report.createTestLogHeader("Dual Journey-Supplycode Enter Mannualy-1 Year Monthly",
					"AnonymousJourney");
			String FirstMonthly = "1";
			String Dual = "Dual";
			for (int i = 0; i <= 2; i++) {
				GetAQuoteDetails getDetails = new TestDataHelper()
						.getGetAQuoteDetails ("gaqdetails");
				new GetaquoteCombinedEnergyAction()
				        .clickCombinedEnergyLink()
						.enterGetaQuoteDetails(getDetails)
						.enterSupplycodeMannualyElectricity(getDetails)
						.elecSupplyDetailsManuall(getDetails)
						.enterConsumptionForEle(getDetails, i)
						.enterGasAddressAndUsage(getDetails)
						.enterConsumptionForGas(getDetails, i)
						.calculateQuoteForElec()
						.firstYearTextVerify(getDetails)
						.saveCurrentQuote1Year()
						.retreiveSavedQuote(getDetails)
						.verifySavedQuoteStatus()
						.firstYearAddressCalMonthlyQuarter(getDetails, FirstMonthly, Dual)
						.gasunitpricefromdbMonthlyQuarter1stYear(getDetails, FirstMonthly, Dual)
						.firstYearCalculationForGasEle( getDetails, FirstMonthly)
						.calculatingConsumption1YearEle( getDetails, i)
						.calculatingConsumption1YearGas( getDetails, i)
						.clickMonthlyQuotepageContinue1stYear();
        }
		}	
   
//	 @Test(groups = { GetaQuoteSS})
		public void dualProfileClassQuarterFirstYear() {
			Report.createTestLogHeader("Dual Journey-Supplycode Enter Mannualy-1 Year Quarter",
					"AnonymousJourney");
			String FirstQuarter = "4";
			String Dual = "Dual";
			for (int i = 0; i <= 2; i++) {
        GetAQuoteDetails getDetails = new TestDataHelper()
                .getGetAQuoteDetails ("gaqdetails");
        new GetaquoteCombinedEnergyAction()
           .clickCombinedEnergyLink()
           .enterGetaQuoteDetails(getDetails)
           .enterSupplycodeMannualyElectricity(getDetails)
           .elecSupplyDetailsManuall(getDetails)
						.enterConsumptionForEle(getDetails, i)
						.enterGasAddressAndUsage(getDetails)
						.enterConsumptionForGas(getDetails, i)
						.calculateQuoteForElec()
						.firstYearTextVerify(getDetails)
						.saveCurrentQuote1Year()
						.retreiveSavedQuote(getDetails)
						.verifySavedQuoteStatus()
						.clickQuaterlybutton1stYearGas(getDetails)
						.firstYearAddressCalMonthlyQuarter(getDetails, FirstQuarter, Dual)
						.gasunitpricefromdbMonthlyQuarter1stYear(getDetails, FirstQuarter, Dual)
						.firstYearCalculationForGasEle( getDetails, FirstQuarter)
						.calculatingConsumption1YearEle( getDetails, i)
						.calculatingConsumption1YearGas( getDetails, i)
						.clickMonthlyQuotepageContinue1stYear();
        }
		}	
 
	// //////////////////////2nd Year//////////////////////////////////////////////////////

//	 @Test(groups = { GetaQuoteSS})
	public void dualAddressMonthlySecondYear() {
		Report.createTestLogHeader(
				"Dual Journey with Address Monthly Calculation-2nd Year",
				"AnonymousJourney");
		String secondMonthly = "2";
		String Dual = "Dual";
		for (int j = 0; j <= 2; j++) {
        GetAQuoteDetails getDetails = new TestDataHelper()
                .getGetAQuoteDetails ("gaqdetails");
        new GetaquoteCombinedEnergyAction()
        .clickCombinedEnergyLink()
        .enterGetaQuoteDetails(getDetails)
					.electricityAddressAndUsage(getDetails)
					.enterConsumptionForEle(getDetails, j)
					.enterGasAddressAndUsage(getDetails)
					.enterConsumptionForGas(getDetails, j)
					.calculateQuoteForElec()
					.firstYearTextVerify(getDetails)
					.saveCurrentQuote1Year()
					.retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus()
					.click2ndYearTabDual(getDetails)
					.secondYearAddressCalMonthlyQuarter(getDetails,	secondMonthly, Dual)
					.gasPricefromdbMonthlyQuarter2ndYear(getDetails,secondMonthly, Dual)
					.secondYearCalculationForGasEle(getDetails, secondMonthly)
				    .calculatingConsumption2YearEle(getDetails, j)
				    .calculatingConsumption2YearGas(getDetails, j)
					.clickMonthlyQuotepageContinue2ndYear();
        }
    }

//	 @Test(groups = { GetaQuoteSS})
	public void dualAddressQuarterSecondYear() {
		Report.createTestLogHeader(
				"Dual Journey with Address Quarter Calculation-2nd Year",
				"AnonymousJourney");
		String secondQuarter = "5";
		String Dual = "Dual";
		for (int j = 0; j <= 2; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getGetAQuoteDetails ("gaqdetails");
			new GetaquoteCombinedEnergyAction().clickCombinedEnergyLink()
					.enterGetaQuoteDetails(getDetails)
					.electricityAddressAndUsage(getDetails)
					.enterConsumptionForEle(getDetails, j)
					.enterGasAddressAndUsage(getDetails)
					.enterConsumptionForGas(getDetails, j)
					.calculateQuoteForElec().firstYearTextVerify(getDetails)
					.saveCurrentQuote1Year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus()
					.validateSecondYearContractQuarter(getDetails)
					.secondYearAddressCalMonthlyQuarter(getDetails,secondQuarter, Dual)
					.gasPricefromdbMonthlyQuarter2ndYear(getDetails, secondQuarter, Dual)
					.secondYearCalculationForGasEle(getDetails, secondQuarter)
				    .calculatingConsumption2YearEle(getDetails, j)
				    .calculatingConsumption2YearGas(getDetails, j)
					.clickMonthlyQuotepageContinue2ndYear();
		}
	}

 
//	 @Test(groups = { GetaQuoteSS})
		public void dualSupplyCodeMonthlySecondYear() {
			Report.createTestLogHeader("Dual Journey-Supplycode Enter Mannualy-2nd Year Monthly",
					"AnonymousJourney");
			String secondMonthly = "2";
			String Dual = "Dual";
			for (int i = 0; i <= 2; i++) {
        GetAQuoteDetails getDetails = new TestDataHelper()
                .getGetAQuoteDetails ("gaqdetails");
        new GetaquoteCombinedEnergyAction()
        .clickCombinedEnergyLink()
        .enterGetaQuoteDetails(getDetails)
        .enterSupplycodeMannualyElectricity(getDetails)
        .elecSupplyDetailsManuall(getDetails)
						.enterConsumptionForEle(getDetails, i)
        .enterGasAddressAndUsage(getDetails)
						.enterConsumptionForGas(getDetails, i)
						.calculateQuoteForElec()
						.saveCurrentQuote1Year()
						.retreiveSavedQuote(getDetails)
						.verifySavedQuoteStatus()
						.click2ndYearTabDual(getDetails)
						.secondYearAddressCalMonthlyQuarter(getDetails,	secondMonthly, Dual)
						.gasPricefromdbMonthlyQuarter2ndYear(getDetails,secondMonthly, Dual)
						.secondYearCalculationForGasEle(getDetails, secondMonthly)
					    .calculatingConsumption2YearEle(getDetails, i)
					    .calculatingConsumption2YearGas(getDetails, i)
						.clickMonthlyQuotepageContinue2ndYear();
        }
    }
 

 
//		 @Test(groups = { GetaQuoteSS})
			public void dualSupplyCodeQuarterSecondYear() {
				Report.createTestLogHeader("Dual Journey-Supplycode Enter Quarter-2nd Year Monthly",
                "AnonymousJourney");
				String secondQuarter = "5";
				String Dual = "Dual";
				for (int i = 0; i <= 2; i++) {
        GetAQuoteDetails getDetails = new TestDataHelper().getGetAQuoteDetails("gaqdetails");
        
					new GetaquoteCombinedEnergyAction()
					        .clickCombinedEnergyLink()
                .enterGetaQuoteDetails(getDetails)
							.enterSupplycodeMannualyElectricity(getDetails)
							.elecSupplyDetailsManuall(getDetails)
							.enterConsumptionForEle(getDetails, i)
							.enterGasAddressAndUsage(getDetails)
							.enterConsumptionForGas(getDetails, i)
							.calculateQuoteForElec()
							.saveCurrentQuote1Year()
							.retreiveSavedQuote(getDetails)
							.verifySavedQuoteStatus()
							.validateSecondYearContractQuarter(getDetails)
							.secondYearAddressCalMonthlyQuarter(getDetails,	secondQuarter, Dual)
							.gasPricefromdbMonthlyQuarter2ndYear(getDetails,secondQuarter, Dual)
							.secondYearCalculationForGasEle(getDetails, secondQuarter)
						    .calculatingConsumption2YearEle(getDetails, i)
						    .calculatingConsumption2YearGas(getDetails, i)
							.clickMonthlyQuotepageContinue2ndYear();
    }
			}
	// //////////////////////3rd Year//////////////////////////////////////////////////////

//	 @Test(groups = { GetaQuoteSS})
	public void dualAddressMonthlyThirdYear() {
        Report.createTestLogHeader(
				"Dual Journey with Address Monthly Calculation-3rd Year",
                "AnonymousJourney");
		String thirdMonthly = "3";
		String Dual = "Dual";
		for (int j = 0; j <= 2; j++) {
        GetAQuoteDetails getDetails = new TestDataHelper()
					.getGetAQuoteDetails ("gaqdetails");
			new GetaquoteCombinedEnergyAction()
					.clickCombinedEnergyLink()
                .enterGetaQuoteDetails(getDetails)
					.electricityAddressAndUsage(getDetails)
					.enterConsumptionForEle(getDetails, j)
					.enterGasAddressAndUsage(getDetails)
					.enterConsumptionForGas(getDetails, j)
					.calculateQuoteForElec()
					.firstYearTextVerify(getDetails)
					.saveCurrentQuote1Year()
					.retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus()
					.click3rdYearTabDual(getDetails)
					.thirdYearAddressCalMonthlyQuarter(getDetails,thirdMonthly, Dual)
					.gasPricefromdbMonthlyQuarter3rdYear(getDetails,thirdMonthly, Dual)
					.thirdYearCalculationForGasEle(getDetails, thirdMonthly)
				    .calculatingConsumption3YearEle(getDetails, j)
				    .calculatingConsumption3YearGas(getDetails, j)
					.clickMonthlyQuotepageContinue3rdYear();
    }
	}

//	@Test(groups = { GetaQuoteSS })
	public void dualAddressQuarterThirdYear() {
		Report.createTestLogHeader(
				"Dual Journey with Address Quarter Calculation-3rd Year",
                "AnonymousJourney");
		String thirdQuarter = "6";
		String Dual = "Dual";
		for (int j = 0; j <= 2; j++) {
        GetAQuoteDetails getDetails = new TestDataHelper()
					.getGetAQuoteDetails ("gaqdetails");
			new GetaquoteCombinedEnergyAction().clickCombinedEnergyLink()
					.enterGetaQuoteDetails(getDetails)
					.electricityAddressAndUsage(getDetails)
					.enterConsumptionForEle(getDetails, j)
					.enterGasAddressAndUsage(getDetails)
					.enterConsumptionForGas(getDetails, j)
					.calculateQuoteForElec().firstYearTextVerify(getDetails)
					.saveCurrentQuote1Year().retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus()
					.click3rdYearTabDualQuarter(getDetails)
					.thirdYearAddressCalMonthlyQuarter(getDetails,thirdQuarter, Dual)
					.gasPricefromdbMonthlyQuarter3rdYear(getDetails, thirdQuarter, Dual)
					.thirdYearCalculationForGasEle(getDetails, thirdQuarter)
				    .calculatingConsumption3YearEle(getDetails, j)
				    .calculatingConsumption3YearGas(getDetails, j)
				    .clickMonthlyQuotepageContinue3rdYear();
    }
	}
	
//	 @Test(groups = { GetaQuoteSS})
	public void dualSupplyCodeMonthlyThirdYear() {
		Report.createTestLogHeader(
				"Dual Journey with SupplyCode Monthly Calculation-3rd Year",
				"AnonymousJourney");
		String thirdMonthly = "3";
		String Dual = "Dual";
		for (int j = 0; j <= 2; j++) {
			GetAQuoteDetails getDetails = new TestDataHelper()
					.getGetAQuoteDetails ("gaqdetails");
			new GetaquoteCombinedEnergyAction()
			        .clickCombinedEnergyLink()
					.enterGetaQuoteDetails(getDetails)
					.enterSupplycodeMannualyElectricity(getDetails)
					.elecSupplyDetailsManuall(getDetails)
					.enterConsumptionForEle(getDetails, j)
					.enterGasAddressAndUsage(getDetails)
					.enterConsumptionForGas(getDetails, j)
					.calculateQuoteForElec()
					.saveCurrentQuote1Year()
					.retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus()
					.click3rdYearTabDual(getDetails)
					.thirdYearAddressCalMonthlyQuarter(getDetails,thirdMonthly, Dual)
					.gasPricefromdbMonthlyQuarter3rdYear(getDetails,thirdMonthly, Dual)
					.thirdYearCalculationForGasEle(getDetails, thirdMonthly)
				    .calculatingConsumption3YearEle(getDetails, j)
				    .calculatingConsumption3YearGas(getDetails, j)
					.clickMonthlyQuotepageContinue3rdYear();
		}
	}
	

//	 @Test(groups = { GetaQuoteSS})
	public void dualSupplyCodeQuarterThirdYear() {
        Report.createTestLogHeader(
				"Dual Journey with SupplyCode Quarter Calculation-3rd Year",
                "AnonymousJourney");
		String thirdQuarter = "6";
		String Dual = "Dual";
		for (int j = 0; j <= 2; j++) {
        GetAQuoteDetails getDetails = new TestDataHelper()
					.getGetAQuoteDetails ("gaqdetails");
			new GetaquoteCombinedEnergyAction()
			        .clickCombinedEnergyLink()
					.enterGetaQuoteDetails(getDetails)
					.enterSupplycodeMannualyElectricity(getDetails)
					.elecSupplyDetailsManuall(getDetails)
					.enterConsumptionForEle(getDetails, j)
					.enterGasAddressAndUsage(getDetails)
					.enterConsumptionForGas(getDetails, j)
					.calculateQuoteForElec()
					.saveCurrentQuote1Year()
					.retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatus()
					.click3rdYearTabDualQuarter(getDetails)
					.thirdYearAddressCalMonthlyQuarter(getDetails,thirdQuarter, Dual)
					.gasPricefromdbMonthlyQuarter3rdYear(getDetails,thirdQuarter, Dual)
					.thirdYearCalculationForGasEle(getDetails, thirdQuarter)
				    .calculatingConsumption3YearEle(getDetails, j)
				    .calculatingConsumption3YearGas(getDetails, j)
					.clickMonthlyQuotepageContinue3rdYear();
    }
	}
	

}
