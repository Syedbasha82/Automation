package bg.framework.app.functional.test.bgb;

import java.io.FileNotFoundException;
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

public class GetaquoteElectricityTest extends TestBase {

	/* ******************** Mandatory Fields For Electricity Journey******************
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
		<defaultConsumptionRateClass1>15000</defaultConsumptionRateClass1>
		<defaultConsumptionRateClass2>25000</defaultConsumptionRateClass2>
		<defaultConsumptionRateClass3>15000</defaultConsumptionRateClass3>
		<defaultConsumptionRateClass4>25000</defaultConsumptionRateClass4>
		<defaultConsumptionRateClass5>60000</defaultConsumptionRateClass5>
		<defaultConsumptionRateClass6>80000</defaultConsumptionRateClass6>
		<defaultConsumptionRateClass7>100000</defaultConsumptionRateClass7>
		<defaultConsumptionRateClass8>120000</defaultConsumptionRateClass8>
	 *******************************************************************************/

	/**************** Electricity 1st Year Monthly Quarter Validation *************************/

//	 @Test(groups = { GetaQuoteSS})
	public void electricityMonthlyFirstYearAddress() {
	       Report.createTestLogHeader(
	               "Get A Quote-Electricity 1st Year Monthly Calculation with Address",
	               "AnonymousJourney");
		String FirstMonthly = "1";
		String electricity="ele";
		for (int j = 0; j <= 2; j++) {
	       GetAQuoteDetails getDetails = new TestDataHelper()
	               .getGetAQuoteDetails ("gaqdetails");
			new GetAQuoteAction()
					.clickElecquoteLink()
					.enterGetaQuoteDetails(getDetails)
		       .enterElectricityAddress(getDetails)
		       .enterConsumptionForEle(getDetails, j)
		       .clickCalculateQuoteForElec()
		       .retreiveElectricityQuotesUI()
					.saveCurrentQuote1Year()
		       .retreiveSavedQuote(getDetails)
		       .verifySavedQuoteStatus()
					.firstYearAddressCalMonthlyQuarter(getDetails, FirstMonthly, electricity)
					.calculatingConsumption1Year(getDetails, j)
	           .clickMonthlyQuotepageContinue()
	           .navigateToElecRbYesSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsMonthly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);
	   }
	}

	// @Test(groups = {GetaQuoteSS})
	public void electricityQuarterFirstYearAddress() {
        Report.createTestLogHeader(
                "Get A Quote-Electricity 1st Year Quaterly calculation with Address",
                "AnonymousJourney");
		String FirstQuarter = "4";
		String electricity="ele";
		for (int j = 0; j <= 2; j++)
        {
        GetAQuoteDetails getDetails = new TestDataHelper()
                .getGetAQuoteDetails ("gaqdetails");
			new GetAQuoteAction()
					.clickElecquoteLink()
					.enterGetaQuoteDetails(getDetails)
            .enterElectricityAddress(getDetails)
            .enterConsumptionForEle(getDetails, j)
            .clickCalculateQuoteForElec()
            .selectElectricityPaymentOptionQuaterly()
            .retreiveElectricityQuotesUI()
            .selectElectricityPaymentOptionQuaterly()
					.firstYearAddressCalMonthlyQuarter(getDetails, FirstQuarter, electricity)
					.calculatingConsumption1Year(getDetails, j)
            .clickQuaterlyQuotepageContinue()
            .navigateToElecRbYesSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsQuaterly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);
    }
 }

//	 @Test(groups = {GetaQuoteSS})
	public void electricityMonthlyFirstYearSupplyCode() {
       Report.createTestLogHeader(
               "Get A Quote-Electricity 1st Year Monthly Calculation with Supply Code",
               "AnonymousJourney");
		int ProfileClass = 2;
		String FirstMonthly = "1";
		String electricity="ele";
		for (int j = 0; j <= 2; j++)
       {
       GetAQuoteDetails getDetails = new TestDataHelper()
               .getGetAQuoteDetails ("gaqdetails");
			new GetAQuoteAction().clickElecquoteLink().enterGetaQuoteDetails(
					getDetails);
  new GetaquoteCombinedEnergyAction()
			 .enterSupplycodeMannualyElectricity(getDetails)
			 .updateSupplypointValues(ProfileClass);
  new GetAQuoteAction()
           .enterConsumptionForEle(getDetails, j)
           .clickCalculateQuoteForElec()
           .retreiveElectricityQuotesUI()
					.firstYearCalulationQuarterMonthlyAndNotch(getDetails, ProfileClass, FirstMonthly, electricity)
					.calculatingConsumption1Year(getDetails, j)
           .clickMonthlyQuotepageContinue()
           .navigateToElecRbYesSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsMonthly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);
   }
	}

	// @Test(groups = {GetaQuoteSS})
	public void electricityQuarterFirstYearSupplyCode() {
       Report.createTestLogHeader(
               "Get A Quote-Electricity 1st Year Quarter Calculation with SupplyCode",
               "AnonymousJourney");
		int ProfileClass = 2;
		String FirstQuarter = "4";
		String electricity="ele";
		for (int j = 0; j <= 2; j++) {
       GetAQuoteDetails getDetails = new TestDataHelper()
               .getGetAQuoteDetails ("gaqdetails");
			new GetAQuoteAction().clickElecquoteLink().enterGetaQuoteDetails(
					getDetails);
  new GetaquoteCombinedEnergyAction()
			 .enterSupplycodeMannualyElectricity(getDetails)
			 .updateSupplypointValues(ProfileClass);
  new GetAQuoteAction()
           .enterConsumptionForEle(getDetails, j)
           .clickCalculateQuoteForElec()
           .retreiveElectricityQuotesUI()
           .selectElectricityPaymentOptionQuaterly()
					.firstYearCalulationQuarterMonthlyAndNotch(getDetails, ProfileClass, FirstQuarter, electricity)
					.calculatingConsumption1Year(getDetails, j)
           .clickMonthlyQuotepageContinue()
           .navigateToElecRbYesSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsQuaterly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);
   }
	}

	/**************** Electricity 2nd Year Monthly Quarter Validation *************************/

	// @Test(groups = {GetaQuoteSS})
	public void electricityMonthlySecondYearAddress() {
      Report.createTestLogHeader(
              "Get A Quote-Electricity Monthly Calculation for 2 Year contract with Address",
              "AnonymousJourney");
		String SecondMonthly = "2";
		String electricity="ele";
		for (int j = 0; j <= 2; j++) {
      GetAQuoteDetails getDetails = new TestDataHelper()
         .getGetAQuoteDetails ("gaqdetails");
			new GetAQuoteAction()
					.clickElecquoteLink()
					.enterGetaQuoteDetails(getDetails)
          .enterElectricityAddress(getDetails)
          .enterConsumptionForEle(getDetails, j)
          .clickCalculateQuoteForElec()
					.click2ndYearTab()
					.secondYearAddressCalMonthlyQuarter(getDetails,	SecondMonthly, electricity)
					.calculatingConsumption2Year(getDetails, j)
	      .clickQuaterlyContinueQuotePage2ndYear()
          .navigateToElecRbYesSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsMonthly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);
  }
	}

	// @Test(groups = {GetaQuoteSS})
	public void electricityQuaterlySecondYearAddress() {
      Report.createTestLogHeader(
              "Get A Quote-Electricity Quarterly Calculation for 2 Year contract with Address",
              "AnonymousJourney");
		String SecondQuarter = "5";
		String electricity="ele";
		for (int j = 0; j <= 2; j++)
      {
      GetAQuoteDetails getDetails = new TestDataHelper()
              .getGetAQuoteDetails ("gaqdetails");
			new GetAQuoteAction()
					.clickElecquoteLink()
					.enterGetaQuoteDetails(getDetails)
          .enterElectricityAddress(getDetails)
          .enterConsumptionForEle(getDetails, j)
          .clickCalculateQuoteForElec()
          .validateSecondYearContractQuarter(getDetails)
					.secondYearAddressCalMonthlyQuarter(getDetails,	SecondQuarter, electricity)
					.calculatingConsumption2Year(getDetails, j)
	      .clickQuaterlyContinueQuotePage2ndYear()
	      .navigateToElecRbYesSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsQuaterly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);
  }
	}

	// @Test(groups = {GetaQuoteSS})
	public void electricityMonthlySecondYearSupplyCode() {
    Report.createTestLogHeader(
            "Get A Quote-Electricity 2 Year Monthly Calculation with Supply Code",
            "AnonymousJourney");
		int ProfileClass = 1;
		String SecondMonthly = "2";
		String electricity="ele";
		for (int j = 0; j <= 2; j++) {
    GetAQuoteDetails getDetails = new TestDataHelper()
            .getGetAQuoteDetails ("gaqdetails");
			new GetAQuoteAction().clickElecquoteLink().enterGetaQuoteDetails(
					getDetails);
     new GetaquoteCombinedEnergyAction()
			 .enterSupplycodeMannualyElectricity(getDetails)
					.updateSupplypointValues(ProfileClass);
  new GetAQuoteAction()
            .enterConsumptionForEle(getDetails, j)
            .clickCalculateQuoteForElec()
					.click2ndYearTab()
					.secondYearCalulationQuarterMonthlyAndNotch(getDetails,	ProfileClass, SecondMonthly, electricity)
					.calculatingConsumption2Year(getDetails, j)
		    .clickQuaterlyContinueQuotePage2ndYear()
	        .navigateToElecRbYesSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsMonthly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);
		}
	}

	// @Test(groups = {GetaQuoteSS})
	public void electricityQuaterlySecondYearSupplyCode() {
    Report.createTestLogHeader(
            "Get A Quote-Electricity 2 Year Quarter Calculation with Supply Code",
            "AnonymousJourney");
		int ProfileClass = 2;
		String SecondQuarter = "5";
		String electricity="ele";
		for (int j = 0; j <= 2; j++) {
    GetAQuoteDetails getDetails = new TestDataHelper()
            .getGetAQuoteDetails ("gaqdetails");
			new GetAQuoteAction().clickElecquoteLink().enterGetaQuoteDetails(
					getDetails);
    new GetaquoteCombinedEnergyAction()
			 .enterSupplycodeMannualyElectricity(getDetails)
					.updateSupplypointValues(ProfileClass);
 new GetAQuoteAction()
           .enterConsumptionForEle(getDetails, j)
           .clickCalculateQuoteForElec()
           .validateSecondYearContractQuarter(getDetails)
					.secondYearCalulationQuarterMonthlyAndNotch(getDetails,	ProfileClass, SecondQuarter, electricity)
					.calculatingConsumption2Year(getDetails, j)
	    .clickQuaterlyContinueQuotePage2ndYear()
	    .navigateToElecRbYesSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsQuaterly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);
		}
	}

	/**************** Electricity 3rd Year Monthly Quarter Validation *************************/
	// @Test(groups = {GetaQuoteSS})
	public void electricityMonthlyThirdYearAddress() {
      Report.createTestLogHeader(
				"Get A Quote-Electricity 3 Year Monthly Calculation with Address",
              "AnonymousJourney");
		String ThirdMonthly = "3";
		String electricity="ele";
		for (int j = 0; j <= 2; j++)
      {
      GetAQuoteDetails getDetails = new TestDataHelper()
              .getGetAQuoteDetails ("gaqdetails");
			new GetAQuoteAction()
					.clickElecquoteLink()
					.enterGetaQuoteDetails(getDetails)
          .enterElectricityAddress(getDetails)
          .enterConsumptionForEle(getDetails, j)
          .clickCalculateQuoteForElec()
          .click3rdYearTab()
					.saveCurrentQuote3year()
          .retreiveSavedQuote(getDetails)
          .verifySavedQuoteStatus()
          .click3rdYearTab()
					.thirdYearAddressCalMonthlyQuarter(getDetails, ThirdMonthly, electricity)
					.calculatingConsumption3Year(getDetails, j)
	      .clickQuaterlyContinueQuotePage3rdYear()
          .navigateToElecRbYesSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsMonthly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);
  }
	}

	// @Test(groups = {GetaQuoteSS})
	public void electricityQuarterhirdYearAddress() {
      Report.createTestLogHeader(
				"Get A Quote-Electricity 3 Year Quarter Calculation with Address",
              "AnonymousJourney");
		String ThirdQuarter = "6";
		String electricity="ele";
		for (int j = 0; j <= 2; j++)
      {
      GetAQuoteDetails getDetails = new TestDataHelper()
              .getGetAQuoteDetails ("gaqdetails");
			new GetAQuoteAction()
					.clickElecquoteLink()
					.enterGetaQuoteDetails(getDetails)
          .enterElectricityAddress(getDetails)
          .enterConsumptionForEle(getDetails, j)
          .clickCalculateQuoteForElec()
          .clickQuaterlybutton3rdYear()
					.thirdYearAddressCalMonthlyQuarter(getDetails, ThirdQuarter, electricity)
					.calculatingConsumption3Year(getDetails, j)
	      .clickQuaterlyContinueQuotePage3rdYear()
	      .navigateToElecRbYesSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsQuaterly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);
  }
	}

	// @Test(groups = {GetaQuoteSS})
	public void electricityMonthlyThirdYearSupplyCode() {
    Report.createTestLogHeader(
				"Get A Quote-Electricity 3 Year Monthly Calculation with Supply Code",
            "AnonymousJourney");
		int ProfileClass = 1;
		String ThirdMonthly = "3";
		String electricity="ele";
		for (int j = 0; j <= 2; j++)
    {
    GetAQuoteDetails getDetails = new TestDataHelper()
            .getGetAQuoteDetails ("gaqdetails");
			new GetAQuoteAction().clickElecquoteLink().enterGetaQuoteDetails(
					getDetails);
     new GetaquoteCombinedEnergyAction()
			 .enterSupplycodeMannualyElectricity(getDetails)
					.updateSupplypointValues(ProfileClass);
  new GetAQuoteAction()
            .enterConsumptionForEle(getDetails, j)
            .clickCalculateQuoteForElec()
            .click3rdYearTab()
					.saveCurrentQuote3year()
            .retreiveSavedQuote(getDetails)
            .verifySavedQuoteStatus()
            .click3rdYearTab()
					.thirdYearCalulationQuarterMonthlyAndNotch(getDetails, ProfileClass, ThirdMonthly, electricity)
					.calculatingConsumption3Year(getDetails, j)
	        .clickQuaterlyContinueQuotePage3rdYear()
	        .navigateToElecRbYesSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsMonthly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);
		}
	}

//	 @Test(groups = {GetaQuoteSS})
	public void electricityQuarterThirdYearSupplyCode() {
    Report.createTestLogHeader(
				"Get A Quote-Electricity 3 Year Quarter Calculation with Supply Code",
            "AnonymousJourney");
		int ProfileClass = 1;
		String ThirdQuarter = "6";
		String electricity="ele";
		for (int j = 0; j <= 2; j++)
    {
    GetAQuoteDetails getDetails = new TestDataHelper()
            .getGetAQuoteDetails ("gaqdetails");
			new GetAQuoteAction().clickElecquoteLink().enterGetaQuoteDetails(
					getDetails);
    new GetaquoteCombinedEnergyAction()
			 .enterSupplycodeMannualyElectricity(getDetails)
					.updateSupplypointValues(ProfileClass);
 new GetAQuoteAction()
           .enterConsumptionForEle(getDetails, j)
           .clickCalculateQuoteForElec()
           .clickQuaterlybutton3rdYear()
					.thirdYearCalulationQuarterMonthlyAndNotch(getDetails, ProfileClass, ThirdQuarter, electricity)
					.calculatingConsumption3Year(getDetails, j)
	       .clickQuaterlyContinueQuotePage3rdYear()
	    .navigateToElecRbYesSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsQuaterly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);
		}
	}

	/***********************Compare All Tab Journey********************************************/

//	 @Test(groups = {GetaQuoteSS})
	public void compareAllJourneyEle() throws Exception {
    Report.createTestLogHeader(
				"Compare All Journey Electricity-Comparing Unit,Night and Standing charge for 1st,2nd and 3rd Years",
            "AnonymousJourney");
		for (int i = 1; i <= 8; i++) {
			for (int j = 0; j <= 2; j++) {
    GetAQuoteDetails getDetails = new TestDataHelper()
            .getGetAQuoteDetails ("gaqdetails");
				new GetAQuoteAction().clickElecquoteLink()
						.enterGetaQuoteDetails(getDetails);
     new GetaquoteCombinedEnergyAction()
			 .enterSupplycodeMannualyElectricity(getDetails)
			 .updateSupplypointValues(i);
				new GetAQuoteAction().enterConsumptionForEle(getDetails, j)
            .clickCalculateQuoteForElec()
						.compareAllEleRatesMonthly()
						.compareAllEleRatesQuarterly();
    }
  }
   }

//	 @Test(groups = { GetaQuoteSS})
	public void compareAllJourneyEleAddress() {
    Report.createTestLogHeader(
				"Compare All Journey Electricity-Comparing Unit,Night and Standing charge for 1st,2nd and 3rd Years-Address",
            "AnonymousJourney");
		for (int j = 0; j <= 2; j++) {
    GetAQuoteDetails getDetails = new TestDataHelper()
            .getGetAQuoteDetails ("gaqdetails");
			new GetAQuoteAction().clickElecquoteLink()
					.enterGetaQuoteDetails(getDetails)
    .enterElectricityAddress(getDetails)
    .enterConsumptionForEle(getDetails, j)
					.clickCalculateQuoteForElec().compareAllEleRatesMonthly()
					.compareAllEleRatesQuarterly();

		}
	}

	// @Test(groups = { GetaQuoteSS})
	public void compareAllJourneySignupMonthly() throws InterruptedException {
    Report.createTestLogHeader(
            "Compare All Journey Electricity-Comparing Sign Up Monthly-1st,2nd and 3 rd Year",
            "AnonymousJourney");
		for (int j = 0; j <= 2; j++) {
    GetAQuoteDetails getDetails = new TestDataHelper()
            .getGetAQuoteDetails ("gaqdetails");
			new GetAQuoteAction().clickElecquoteLink().enterGetaQuoteDetails(
					getDetails);
     new GetaquoteCombinedEnergyAction()
			 .enterSupplycodeMannualyElectricity(getDetails)
			 .updateSupplypointValues(1);
			new GetAQuoteAction().enterConsumptionForEle(getDetails, j)
					.clickCalculateQuoteForElec().compareAllMonthlySignUP(j)
	        .clickContinuElecSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsMonthly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);

		}
	}

	// @Test(groups = { GetaQuoteSS})
	public void compareAllJourneySignupQuarterly()
			throws InterruptedException {
    Report.createTestLogHeader(
            "Compare All Journey Electricity-Comparing Sign Up Quarterly-1st,2nd and 3 rd Year",
            "AnonymousJourney");
		for (int j = 0; j <= 2; j++) {
    GetAQuoteDetails getDetails = new TestDataHelper()
            .getGetAQuoteDetails ("gaqdetails");
			new GetAQuoteAction().clickElecquoteLink().enterGetaQuoteDetails(
					getDetails);
     new GetaquoteCombinedEnergyAction()
			 .enterSupplycodeMannualyElectricity(getDetails)
			 .updateSupplypointValues(1);
			new GetAQuoteAction().enterConsumptionForEle(getDetails, j)
					.clickCalculateQuoteForElec().compareAllQuarterSignUP(j)
	        .clickContinuElecSupplypage(getDetails)
					.businessPageDetails(getDetails)
					.paymentPageDetailsQuaterly(getDetails)
					.summaryPage(getDetails).thankYouPage()
					.gaqDBLeadVerify(getDetails);
		}
	}

}
