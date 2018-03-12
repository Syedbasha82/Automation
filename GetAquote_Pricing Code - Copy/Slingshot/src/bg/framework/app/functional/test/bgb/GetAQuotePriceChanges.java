package bg.framework.app.functional.test.bgb;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.bgb.GetAQuoteAction;
import bg.framework.app.functional.action.bgb.GetaquoteCombinedEnergyAction;
import bg.framework.app.functional.entities.GetAQuoteDetails;
import bg.framework.app.functional.page.bgb.GetaQuoteDetailsPage;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import static bg.framework.app.functional.entities.FunctionalCategory.*;

public class GetAQuotePriceChanges extends TestBase {
	
/*****************************1,2 and 3 Year Contract Quarter Monthly--Electricity**********************************/	

//	 @Test(groups = { GetaQuoteSS})
	   public void priceChangesProfileclassMonthlyAndQuarter() {
	       Report.createTestLogHeader(
	               "Get A Quote-Electricity Price Chnages Journey 1st,2nd and 3rd Year montly and Quarter with Profile Class",
	               "AnonymousJourney");
			String FirstMonthly="1",FirstQuarter="4";
			String SecondMonthly="2",SecondQuarter="5";
			String ThirdMonthly="3",ThirdQuarter="6";
			String electricity="ele";
	       for(int i=1;i<=8;i++)
	       {
	       for(int j=0;j<=2;j++)
	       {
		GetAQuoteDetails getDetails = new TestDataHelper()
	               .getallGetAQuoteDetails("gaqdetails");
	  new GetAQuoteAction()
	  			.clickElecquoteLink().enterGetaQuoteDetails(getDetails);
	  new GetaquoteCombinedEnergyAction()
				 .enterSupplycodeMannualyElectricity(getDetails)
				 .updateSupplypointValues(i);
	  new GetAQuoteAction()
	           .enterConsumptionForEle(getDetails, j)
	           .clickCalculateQuoteForElec()
	           .retreiveElectricityQuotesUI()
			           //1 Year Monthly
			           .firstYearCalulationQuarterMonthlyAndNotch(getDetails, i ,FirstMonthly, electricity)
			           .calculatingConsumption1Year(getDetails, j)
					   //2 Year Monthly
			           .click2ndYearTab()
		       		   .secondYearCalulationQuarterMonthlyAndNotch(getDetails, i ,SecondMonthly, electricity)
		       		   .calculatingConsumption2Year(getDetails, j)	  
			  	       //3 Year Monthly
				       .click3rdYearTab()
				       .thirdYearCalulationQuarterMonthlyAndNotch(getDetails,i,ThirdMonthly, electricity)
				       .calculatingConsumption3Year(getDetails, j)	
			  		   //3 Year Quarter
			  		   .clickQuaterlybutton3rdYear()
			  		   .thirdYearCalulationQuarterMonthlyAndNotch(getDetails,i ,ThirdQuarter, electricity)
			  		   .calculatingConsumption3Year(getDetails, j)
			  		   //2 Year Quarter
		               .validateSecondYearContractQuarter(getDetails)
		               .secondYearCalulationQuarterMonthlyAndNotch(getDetails, i ,SecondQuarter, electricity)
		               .calculatingConsumption2Year(getDetails, j)
		               //1 Year Quarter
		 			   .click1stYearTabGas()
					   .selectElectricityPaymentOptionQuaterly()
					   .firstYearCalulationQuarterMonthlyAndNotch(getDetails, i ,FirstQuarter, electricity)
					   .calculatingConsumption1Year(getDetails, j);
	   }
	  }
	}
	
// @Test(groups = { GetaQuoteSS})
		public void priceChnagesAddressMonthlyAndQuarter() {
	       Report.createTestLogHeader(
				"Get A Quote-Electricity Price Chnages Journey 1st,2nd and 3rd Year montly and Quarter without Profile Class",
			        "AnonymousJourney");
		    String FirstMonthly="1",FirstQuarter="4";
			String SecondMonthly="2",SecondQuarter="5";
			String ThirdMonthly="3",ThirdQuarter="6";
			String electricity="ele";
	       for(int j=0;j<=2;j++)
	       {
	       GetAQuoteDetails getDetails = new TestDataHelper()
	               .getallGetAQuoteDetails("gaqdetails");
				   new GetAQuoteAction().clickElecquoteLink().enterGetaQuoteDetails(getDetails)
				       .enterElectricityAddress(getDetails)
		           .enterConsumptionForEle(getDetails, j)
		           .clickCalculateQuoteForElec()
		           .retreiveElectricityQuotesUI()
			           //1 Year Monthly
			           .firstYearAddressCalMonthlyQuarter(getDetails, FirstMonthly, electricity)
			           .calculatingConsumption1Year(getDetails, j)
					   //2 Year Monthly
			           .click2ndYearTab()
		       		   .secondYearAddressCalMonthlyQuarter(getDetails,SecondMonthly, electricity)
		       		   .calculatingConsumption2Year(getDetails, j)	  
			  	       //3 Year Monthly
				       .click3rdYearTab()
				       .thirdYearAddressCalMonthlyQuarter(getDetails, ThirdMonthly, electricity)
				       .calculatingConsumption3Year(getDetails, j)	
			  		   //3 Year Quarter
			  		   .clickQuaterlybutton3rdYear()
			  		   .thirdYearAddressCalMonthlyQuarter(getDetails, ThirdQuarter, electricity)
			  		   .calculatingConsumption3Year(getDetails, j)
			  		   //2 Year Quarter
		               .validateSecondYearContractQuarter(getDetails)
		               .secondYearAddressCalMonthlyQuarter(getDetails,SecondQuarter, electricity)
		               .calculatingConsumption2Year(getDetails, j)
		               //1 Year Quarter
		 			   .click1stYearTabGas()
		           .selectElectricityPaymentOptionQuaterly()
					   .firstYearAddressCalMonthlyQuarter(getDetails, FirstQuarter, electricity)
					   .calculatingConsumption1Year(getDetails, j);
		}
	}

//	 @Test(groups = { GetaQuoteSS})
	    public void priceChnagesProfileclassMonthlyAndQuarterDefaultConsumption() {
	     Report.createTestLogHeader(
	               "Get A Quote-Electricity Price Chnages Journey 1,2 3 Year montly and Quarter with Profile Class_Default Consumption",
	             "AnonymousJourney");
			String FirstMonthly="1",FirstQuarter="4";
			String SecondMonthly="2",SecondQuarter="5";
			String ThirdMonthly="3",ThirdQuarter="6";
			String electricity="ele";
	     for(int i=1;i<=8;i++)
	       {
	     GetAQuoteDetails getDetails = new TestDataHelper()
	             .getallGetAQuoteDetails("gaqdetails");
			  new GetAQuoteAction()
			  		   .clickElecquoteLink().enterGetaQuoteDetails(getDetails);
	     new GetaquoteCombinedEnergyAction()
	 			 .enterSupplycodeMannualyElectricity(getDetails)
					   .updateSupplypointValues(i);
	     new GetAQuoteAction()
	             .clickCalculateQuoteForElec()
			           .retreiveElectricityQuotesUI()
			           //1 Year Monthly
			           .firstYearCalulationQuarterMonthlyAndNotch(getDetails, i ,FirstMonthly, electricity)
			           .defaultConsumptionSupplyCode1year(getDetails,i)
					   //2 Year Monthly
			           .click2ndYearTab()
		       		   .secondYearCalulationQuarterMonthlyAndNotch(getDetails, i ,SecondMonthly, electricity)
		       		   .defaultConsumptionSupplyCode2year(getDetails,i)  
			  	       //3 Year Monthly
				       .click3rdYearTab()
				       .thirdYearCalulationQuarterMonthlyAndNotch(getDetails,i,ThirdMonthly, electricity)
				       .defaultConsumptionSupplyCode3year(getDetails,i)	
			  		   //3 Year Quarter
			  		   .clickQuaterlybutton3rdYear()
			  		   .thirdYearCalulationQuarterMonthlyAndNotch(getDetails,i ,ThirdQuarter, electricity)
			  		   .defaultConsumptionSupplyCode3year(getDetails,i)
			  		   //2 Year Quarter
		               .validateSecondYearContractQuarter(getDetails)
		               .secondYearCalulationQuarterMonthlyAndNotch(getDetails, i ,SecondQuarter, electricity)
		               .defaultConsumptionSupplyCode2year(getDetails,i)
		               //1 Year Quarter
		 			   .click1stYearTabGas()
					   .selectElectricityPaymentOptionQuaterly()
					   .firstYearCalulationQuarterMonthlyAndNotch(getDetails, i ,FirstQuarter, electricity)
					   .defaultConsumptionSupplyCode1year(getDetails,i);
	}
	  }
		
/*****************************1,2 and 3 Year Contract Quarter Monthly--Gas**********************************/	
			
//	 @Test(groups = { GetaQuoteSS})
	 public void priceChnagesGasMeterNoMonthlyAndQuarter() throws InterruptedException {
	     Report.createTestLogHeader(
			"Get A Quote-GAS Price Chnages Journey 1st,2nd and 3rd Year montly and Quarter with GAS Meter NO",
	             "AnonymousJourney");
			String FirstMonthly="1",FirstQuarter="4";
			String SecondMonthly="2",SecondQuarter="5";
			String ThirdMonthly="3",ThirdQuarter="6";
			String gas="gas";
	     for(int j=0;j<=2;j++)
	     {
			 GetAQuoteDetails getDetails = new TestDataHelper()
	             .getallGetAQuoteDetails("gaqdetails");
				new GetAQuoteAction().clickGasquoteLink().enterGetaQuoteDetails(getDetails)
					.enterConsumptionForGas(getDetails, j)
					.clickGasMeterOptionNO()
					.gasMeterYESandNO(getDetails)
					///1 Year Monthly///
					.click1stYearTabGas()
					.gasunitpricefromdbMonthlyQuarter1Year(getDetails,FirstMonthly, gas)
					.calculatingConsumption1YearGas(getDetails, j)
					///2 Year Monthly///
					.click2ndYearTab()
					.gasunitpricefromdbMonthlyQuarter2Year(getDetails,SecondMonthly, gas)
					.calculatingConsumption2YearGas(getDetails, j)
					///3 Year Monthly///
					.click3rdYearTabGas()
					.gasunitpricefromdbMonthlyQuarter3Year(getDetails,ThirdMonthly, gas)
					.calculatingConsumption3YearGas(getDetails, j)
					////3 Year Quarter///
					.click3rdYearTabGas()
					.clickQuaterlybutton3rdYearGas(getDetails)
		    		.gasunitpricefromdbMonthlyQuarter3Year(getDetails,ThirdQuarter, gas)
		    		.calculatingConsumption3YearGas(getDetails, j)
					///2 Year Quarter///
					.click2ndYearTab()
					.clickQuaterlybutton2ndYearGas(getDetails)
					.gasunitpricefromdbMonthlyQuarter2Year(getDetails,SecondQuarter, gas)
					.calculatingConsumption2YearGas(getDetails, j)
					///1 Year Quarter///
					.click1stYearTabGas()
					.clickQuaterlybutton1stYearGas(getDetails)
					.gasunitpricefromdbMonthlyQuarter1Year(getDetails,FirstQuarter, gas)
					.calculatingConsumption1YearGas(getDetails, j);
     	 }
	   }
	 
//   @Test(groups = { GetaQuoteSS})
     public void priceChnagesGasMeterYESMonthlyAndQuarter() throws InterruptedException {
    Report.createTestLogHeader(
			"Get A Quote-GAS Price Chnages Journey 1st,2nd and 3rd Year montly and Quarter with GAS Meter YES",
            "AnonymousJourney");
			String FirstMonthly="1",FirstQuarter="4";
			String SecondMonthly="2",SecondQuarter="5";
			String ThirdMonthly="3",ThirdQuarter="6";
			String gas="gas";
    for(int j=0;j<=2;j++)
    {
    GetAQuoteDetails getDetails = new TestDataHelper()
            .getallGetAQuoteDetails("gaqdetails");
				new GetAQuoteAction().clickGasquoteLink().enterGetaQuoteDetails(getDetails)
					.enterConsumptionForGas(getDetails, j)
					.gasMeterYESandNO(getDetails)
					///1 Year Monthly///
					.click1stYearTabGas()
					.gasunitpricefromdbMonthlyQuarter1Year(getDetails,FirstMonthly, gas)
					.calculatingConsumption1YearGas(getDetails, j)
					///2 Year Monthly///
					.click2ndYearTab()
					.gasunitpricefromdbMonthlyQuarter2Year(getDetails,SecondMonthly, gas)
					.calculatingConsumption2YearGas(getDetails, j)
					///3 Year Monthly///
					.click3rdYearTabGas()
					.gasunitpricefromdbMonthlyQuarter3Year(getDetails,ThirdMonthly, gas)
					.calculatingConsumption3YearGas(getDetails, j)
					////3 Year Quarter///
					.click3rdYearTabGas()
					.clickQuaterlybutton3rdYearGas(getDetails)
		    		.gasunitpricefromdbMonthlyQuarter3Year(getDetails,ThirdQuarter, gas)
		    		.calculatingConsumption3YearGas(getDetails, j)
					///2 Year Quarter///
					.click2ndYearTab()
					.clickQuaterlybutton2ndYearGas(getDetails)
					.gasunitpricefromdbMonthlyQuarter2Year(getDetails,SecondQuarter, gas)
					.calculatingConsumption2YearGas(getDetails, j)
					///1 Year Quarter///
					.click1stYearTabGas()
					.clickQuaterlybutton1stYearGas(getDetails)
					.gasunitpricefromdbMonthlyQuarter1Year(getDetails,FirstQuarter, gas)
					.calculatingConsumption1YearGas(getDetails, j);
			}
			}	
    
///////////////////////////////////////DUAL Journey////////////////////////////////////////////
//   @Test(groups = { GetaQuoteSS})
     public void dualAddressAllYear() {
 		Report.createTestLogHeader(
 				"Dual Journey with Address All Year",
 				"AnonymousJourney");
 		String FirstMonthly = "1",FirstQuarter="4";
 		String secondMonthly = "2",secondQuarter="5";
 		String thirdMonthly = "3",thirdQuarter="6";
 		String Dual = "Dual";
 		for (int j = 0; j <= 2; j++) {
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
 					.firstYearTextVerify(getDetails)
 					.saveCurrentQuote1Year()
            .retreiveSavedQuote(getDetails)
            .verifySavedQuoteStatus()
 					/////1st Year monthly/////
 					.firstYearAddressCalMonthlyQuarter(getDetails, FirstMonthly, Dual)
 					.gasunitpricefromdbMonthlyQuarter1stYear(getDetails, FirstMonthly, Dual)
 					.firstYearCalculationForGasEle( getDetails, FirstMonthly)
 					.calculatingConsumption1YearEle( getDetails, j)
 					.calculatingConsumption1YearGas( getDetails, j)
 					/////2nd Year monthly/////
 					.click2ndYearTabDual(getDetails)
					.secondYearAddressCalMonthlyQuarter(getDetails,	secondMonthly, Dual)
					.gasPricefromdbMonthlyQuarter2ndYear(getDetails,secondMonthly, Dual)
					.secondYearCalculationForGasEle(getDetails, secondMonthly)
				    .calculatingConsumption2YearEle(getDetails, j)
				    .calculatingConsumption2YearGas(getDetails, j)
				    /////3rd Year monthly/////
				    .click3rdYearTabDual(getDetails)
					.thirdYearAddressCalMonthlyQuarter(getDetails,thirdMonthly, Dual)
					.gasPricefromdbMonthlyQuarter3rdYear(getDetails,thirdMonthly, Dual)
					.thirdYearCalculationForGasEle(getDetails, thirdMonthly)
				    .calculatingConsumption3YearEle(getDetails, j)
				    .calculatingConsumption3YearGas(getDetails, j)
 					/////3rd Year Quarter////
				    .click3rdYearTabDualQuarter(getDetails)
					.thirdYearAddressCalMonthlyQuarter(getDetails,thirdQuarter, Dual)
					.gasPricefromdbMonthlyQuarter3rdYear(getDetails, thirdQuarter, Dual)
					.thirdYearCalculationForGasEle(getDetails, thirdQuarter)
				    .calculatingConsumption3YearEle(getDetails, j)
				    .calculatingConsumption3YearGas(getDetails, j)
				    /////2nd Year Quarter//////
				    .validateSecondYearContractQuarter(getDetails)
					.secondYearAddressCalMonthlyQuarter(getDetails,secondQuarter, Dual)
					.gasPricefromdbMonthlyQuarter2ndYear(getDetails, secondQuarter, Dual)
					.secondYearCalculationForGasEle(getDetails, secondQuarter)
				    .calculatingConsumption2YearEle(getDetails, j)
				    .calculatingConsumption2YearGas(getDetails, j)
				    /////1st Year Quarter//////
 					.clickQuaterlybutton1stYear(getDetails)
					.firstYearAddressCalMonthlyQuarter(getDetails, FirstQuarter, Dual)
					.gasunitpricefromdbMonthlyQuarter1stYear(getDetails, FirstQuarter, Dual)
					.firstYearCalculationForGasEle(getDetails, FirstQuarter)
					.calculatingConsumption1YearEle(getDetails, j)
					.calculatingConsumption1YearGas( getDetails, j);
    }
    }
     
//   @Test(groups = { GetaQuoteSS})
     public void dualSupplyCodeAllYear() {
    Report.createTestLogHeader(
 				"Dual Journey with dualSupplyCodeAllYear",
			        "AnonymousJourney");
 		String FirstMonthly = "1",FirstQuarter="4";
 		String secondMonthly = "2",secondQuarter="5";
 		String thirdMonthly = "3",thirdQuarter="6";
 		String Dual = "Dual";
    for(int i=1;i<=8;i++)
    {
 		for (int j = 0; j <= 2; j++) {
    GetAQuoteDetails getDetails = new TestDataHelper()
            .getallGetAQuoteDetails("gaqdetails");
    new GetaquoteCombinedEnergyAction()
 					.clickCombinedEnergyLink()
 					.enterGetaQuoteDetails(getDetails)
			 .enterSupplycodeMannualyElectricity(getDetails)
					.updateSupplypointValues(i)
           .enterConsumptionForEle(getDetails, j)
 					.enterGasAddressAndUsage(getDetails)
 					.enterConsumptionForGas(getDetails, j)
 					.calculateQuoteForElec()
 					.firstYearTextVerify(getDetails)
 					.saveCurrentQuote1Year()
 					.retreiveSavedQuote(getDetails)
 					.verifySavedQuoteStatus()
 					/////1st Year monthly/////
 					.firstYearAddressCalMonthlyQuarter(getDetails, FirstMonthly, Dual)
 					.gasunitpricefromdbMonthlyQuarter1stYear(getDetails, FirstMonthly, Dual)
 					.firstYearCalculationForGasEle( getDetails, FirstMonthly)
 					.calculatingConsumption1YearEle( getDetails, j)
 					.calculatingConsumption1YearGas( getDetails, j)
 					/////2nd Year monthly/////
 					.click2ndYearTabDual(getDetails)
					.secondYearAddressCalMonthlyQuarter(getDetails,	secondMonthly, Dual)
					.gasPricefromdbMonthlyQuarter2ndYear(getDetails,secondMonthly, Dual)
					.secondYearCalculationForGasEle(getDetails, secondMonthly)
				    .calculatingConsumption2YearEle(getDetails, j)
				    .calculatingConsumption2YearGas(getDetails, j)
				    /////3rd Year monthly/////
				    .click3rdYearTabDual(getDetails)
					.thirdYearAddressCalMonthlyQuarter(getDetails,thirdMonthly, Dual)
					.gasPricefromdbMonthlyQuarter3rdYear(getDetails,thirdMonthly, Dual)
					.thirdYearCalculationForGasEle(getDetails, thirdMonthly)
				    .calculatingConsumption3YearEle(getDetails, j)
				    .calculatingConsumption3YearGas(getDetails, j)
 					/////3rd Year Quarter////
				    .click3rdYearTabDualQuarter(getDetails)
					.thirdYearAddressCalMonthlyQuarter(getDetails,thirdQuarter, Dual)
					.gasPricefromdbMonthlyQuarter3rdYear(getDetails, thirdQuarter, Dual)
					.thirdYearCalculationForGasEle(getDetails, thirdQuarter)
				    .calculatingConsumption3YearEle(getDetails, j)
				    .calculatingConsumption3YearGas(getDetails, j)
				    /////2nd Year Quarter//////
				    .validateSecondYearContractQuarter(getDetails)
					.secondYearAddressCalMonthlyQuarter(getDetails,secondQuarter, Dual)
					.gasPricefromdbMonthlyQuarter2ndYear(getDetails, secondQuarter, Dual)
					.secondYearCalculationForGasEle(getDetails, secondQuarter)
				    .calculatingConsumption2YearEle(getDetails, j)
				    .calculatingConsumption2YearGas(getDetails, j)
				    /////1st Year Quarter//////
 					.clickQuaterlybutton1stYear(getDetails)
					.firstYearAddressCalMonthlyQuarter(getDetails, FirstQuarter, Dual)
					.gasunitpricefromdbMonthlyQuarter1stYear(getDetails, FirstQuarter, Dual)
					.firstYearCalculationForGasEle(getDetails, FirstQuarter)
					.calculatingConsumption1YearEle(getDetails, j)
					.calculatingConsumption1YearGas( getDetails, j);
		}
	 }
  }
    
    
//   @Test(groups = { GetaQuoteSS})
     public void dualSupplyCodeGasmeterAllYear() {
  Report.createTestLogHeader(
 				"Dual Journey with dualSupplyCodeGasmeterAllYear",
          "AnonymousJourney");
 		String FirstMonthly = "1",FirstQuarter="4";
 		String secondMonthly = "2",secondQuarter="5";
 		String thirdMonthly = "3",thirdQuarter="6";
 		String Dual = "Dual";
  for(int i=1;i<=8;i++)
  {
 		for (int j = 0; j <= 2; j++) {
		GetAQuoteDetails getDetails = new TestDataHelper()
          .getallGetAQuoteDetails("gaqdetails");
   new GetaquoteCombinedEnergyAction()
 					.clickCombinedEnergyLink()
 					.enterGetaQuoteDetails(getDetails)
			 .enterSupplycodeMannualyElectricity(getDetails)
					.updateSupplypointValues(i)
 					.enterConsumptionForEle(getDetails, j)
 					.gascSupplyDetailsManually(getDetails)
 					.enterConsumptionForGas(getDetails, j)
 					.calculateQuoteForElec()
 					.firstYearTextVerify(getDetails)
 					.saveCurrentQuote1Year()
		           .retreiveSavedQuote(getDetails)
 					.verifySavedQuoteStatus()
 					/////1st Year monthly/////
 					.firstYearAddressCalMonthlyQuarter(getDetails, FirstMonthly, Dual)
 					.gasunitpricefromdbMonthlyQuarter1stYear(getDetails, FirstMonthly, Dual)
 					.firstYearCalculationForGasEle( getDetails, FirstMonthly)
 					.calculatingConsumption1YearEle( getDetails, j)
 					.calculatingConsumption1YearGas( getDetails, j)
 					/////2nd Year monthly/////
 					.click2ndYearTabDual(getDetails)
					.secondYearAddressCalMonthlyQuarter(getDetails,	secondMonthly, Dual)
					.gasPricefromdbMonthlyQuarter2ndYear(getDetails,secondMonthly, Dual)
					.secondYearCalculationForGasEle(getDetails, secondMonthly)
				    .calculatingConsumption2YearEle(getDetails, j)
				    .calculatingConsumption2YearGas(getDetails, j)
				    /////3rd Year monthly/////
				    .click3rdYearTabDual(getDetails)
					.thirdYearAddressCalMonthlyQuarter(getDetails,thirdMonthly, Dual)
					.gasPricefromdbMonthlyQuarter3rdYear(getDetails,thirdMonthly, Dual)
					.thirdYearCalculationForGasEle(getDetails, thirdMonthly)
				    .calculatingConsumption3YearEle(getDetails, j)
				    .calculatingConsumption3YearGas(getDetails, j)
 					/////3rd Year Quarter////
				    .click3rdYearTabDualQuarter(getDetails)
					.thirdYearAddressCalMonthlyQuarter(getDetails,thirdQuarter, Dual)
					.gasPricefromdbMonthlyQuarter3rdYear(getDetails, thirdQuarter, Dual)
					.thirdYearCalculationForGasEle(getDetails, thirdQuarter)
				    .calculatingConsumption3YearEle(getDetails, j)
				    .calculatingConsumption3YearGas(getDetails, j)
				    /////2nd Year Quarter//////
				    .validateSecondYearContractQuarter(getDetails)
					.secondYearAddressCalMonthlyQuarter(getDetails,secondQuarter, Dual)
					.gasPricefromdbMonthlyQuarter2ndYear(getDetails, secondQuarter, Dual)
					.secondYearCalculationForGasEle(getDetails, secondQuarter)
				    .calculatingConsumption2YearEle(getDetails, j)
				    .calculatingConsumption2YearGas(getDetails, j)
				    /////1st Year Quarter//////
 					.clickQuaterlybutton1stYear(getDetails)
					.firstYearAddressCalMonthlyQuarter(getDetails, FirstQuarter, Dual)
					.gasunitpricefromdbMonthlyQuarter1stYear(getDetails, FirstQuarter, Dual)
					.firstYearCalculationForGasEle(getDetails, FirstQuarter)
					.calculatingConsumption1YearEle(getDetails, j)
					.calculatingConsumption1YearGas( getDetails, j);
		}
	}
 	}
   
//   @Test(groups = { GetaQuoteSS})
     public void dualSupplyCodeAllYearDefaultConsumption() {
  Report.createTestLogHeader(
 				"Dual Journey with dualSupplyCodeAllYear DefaultConsumption",
          "AnonymousJourney");
 		String FirstMonthly = "1",FirstQuarter="4";
 		String secondMonthly = "2",secondQuarter="5";
 		String thirdMonthly = "3",thirdQuarter="6";
 		String Dual = "Dual";
  for(int i=1;i<=8;i++)
  {
 		for (int j = 0; j <= 2; j++) {
  GetAQuoteDetails getDetails = new TestDataHelper()
          .getallGetAQuoteDetails("gaqdetails");
  new GetaquoteCombinedEnergyAction()
 					.clickCombinedEnergyLink()
 					.enterGetaQuoteDetails(getDetails)
			 .enterSupplycodeMannualyElectricity(getDetails)
					.updateSupplypointValues(i)
 					.enterGasAddressAndUsage(getDetails)
 					.enterConsumptionForGas(getDetails, j)
 					.calculateQuoteForElec()
 					.firstYearTextVerify(getDetails)
 					.saveCurrentQuote1Year()
            .retreiveSavedQuote(getDetails)
            .verifySavedQuoteStatus()
 					/////1st Year monthly/////
 					.firstYearAddressCalMonthlyQuarter(getDetails, FirstMonthly, Dual)
 					.gasunitpricefromdbMonthlyQuarter1stYear(getDetails, FirstMonthly, Dual)
 					.firstYearCalculationForGasEle( getDetails, FirstMonthly)
 					.defaultConsumptionSupplyCode1year(getDetails,i)
 					.calculatingConsumption1YearGas( getDetails, j)
 					/////2nd Year monthly/////
 					.click2ndYearTabDual(getDetails)
					.secondYearAddressCalMonthlyQuarter(getDetails,	secondMonthly, Dual)
					.gasPricefromdbMonthlyQuarter2ndYear(getDetails,secondMonthly, Dual)
					.secondYearCalculationForGasEle(getDetails, secondMonthly)
				    .defaultConsumptionSupplyCode2year(getDetails,i)
				    .calculatingConsumption2YearGas(getDetails, j)
				    /////3rd Year monthly/////
				    .click3rdYearTabDual(getDetails)
					.thirdYearAddressCalMonthlyQuarter(getDetails,thirdMonthly, Dual)
					.gasPricefromdbMonthlyQuarter3rdYear(getDetails,thirdMonthly, Dual)
					.thirdYearCalculationForGasEle(getDetails, thirdMonthly)
				    .defaultConsumptionSupplyCode3year(getDetails,i)
				    .calculatingConsumption3YearGas(getDetails, j)
 					/////3rd Year Quarter////
				    .click3rdYearTabDualQuarter(getDetails)
					.thirdYearAddressCalMonthlyQuarter(getDetails,thirdQuarter, Dual)
					.gasPricefromdbMonthlyQuarter3rdYear(getDetails, thirdQuarter, Dual)
					.thirdYearCalculationForGasEle(getDetails, thirdQuarter)
				    .defaultConsumptionSupplyCode3year(getDetails,i)
				    .calculatingConsumption3YearGas(getDetails, j)
				    /////2nd Year Quarter//////
				    .validateSecondYearContractQuarter(getDetails)
					.secondYearAddressCalMonthlyQuarter(getDetails,secondQuarter, Dual)
					.gasPricefromdbMonthlyQuarter2ndYear(getDetails, secondQuarter, Dual)
					.secondYearCalculationForGasEle(getDetails, secondQuarter)
				    .defaultConsumptionSupplyCode2year(getDetails,i)
				    .calculatingConsumption2YearGas(getDetails, j)
				    /////1st Year Quarter//////
 					.clickQuaterlybutton1stYear(getDetails)
					.firstYearAddressCalMonthlyQuarter(getDetails, FirstQuarter, Dual)
					.gasunitpricefromdbMonthlyQuarter1stYear(getDetails, FirstQuarter, Dual)
					.firstYearCalculationForGasEle(getDetails, FirstQuarter)
					.defaultConsumptionSupplyCode1year(getDetails,i)
					.calculatingConsumption1YearGas( getDetails, j);
    }
  }
   }
}
	