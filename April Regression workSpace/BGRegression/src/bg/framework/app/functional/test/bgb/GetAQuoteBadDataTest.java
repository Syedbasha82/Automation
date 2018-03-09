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

public class GetAQuoteBadDataTest extends TestBase {

	/********************************************Electricity*************************************/
	
//  @Test(groups = {Regression,GetaQuoteSS})
//	@Test(groups = {GetaQuoteSS})
	public void electricityBadOrganizationName() {
		 
			Report.createTestLogHeader( "BadData_BadOrganization Name-ELE",
			        "AnonymousJourney");
			Report.updateTestLog(
			        "Testing with Bad Organization name:",
			        "DONE");
		GetAQuoteDetails getDetails = new TestDataHelper()
		        .getGetAQuoteDetails ("getAQuote_BadData");
		String[] badOrganizations = getDetails.getbadOrganizations();
		for (int i = 0; i < badOrganizations.length; i++) {
			getDetails.setbusinessname(badOrganizations[i].trim());
			new GetAQuoteAction().clickElecquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterElectricityAddress(getDetails)
					.enterConsumptionForEle(getDetails, 0)
					.clickCalculateQuoteForElec()
					.verifyBadDataTypeUnsaved()
					.retreiveElectricityQuotesUI()
					.saveCurrentQuote1Year()
					.retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatusBaddata()
					.clickMonthlyQuotepageContinue()
					.verifyBadDataType();
	}
 }
	 
//	@Test(groups = {GetaQuoteSS})
	public void electricityBadTeleNo() {
			Report.createTestLogHeader( "BadData_BadTelePhone No_Name-ELE",
			        "AnonymousJourney");
			Report.updateTestLog(
			        "Testing with Bad Telephone No:",
			        "DONE");
			GetAQuoteDetails getDetails = new TestDataHelper()
	        .getGetAQuoteDetails ("getAQuote_BadData");
			String[] badPhoneNumbers = getDetails.getbadTelephones();
			for (int i = 0; i < badPhoneNumbers.length; i++) {
			getDetails.setbadTelephones(badPhoneNumbers[i].trim());
			new GetAQuoteAction().clickElecquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterElectricityAddress(getDetails)
					.enterConsumptionForEle(getDetails, 0)
					.clickCalculateQuoteForElec()
					.verifyBadDataTypeUnsaved()
					.retreiveElectricityQuotesUI()
					.saveCurrentQuote1Year()
					.retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatusBaddata()
			        .clickMonthlyQuotepageContinue()
					.verifyBadDataType();
		}
	}
	
//	@Test(groups = {GetaQuoteSS})
	public void electricityBadOrganizationNameAndTeleNo() {
	
		Report.createTestLogHeader( "BadData_BadOrganization Name and Telephone No-ELE",
		        "AnonymousJourney");
		Report.updateTestLog(
		        "Testing with Bad Organization name and Telephone No:",
		        "DONE");
		
		GetAQuoteDetails getDetails = new TestDataHelper()
        .getGetAQuoteDetails ("getAQuote_BadData");
		String[] badOrganizations = getDetails.getbadOrganizations();
		String[] badPhoneNumbers = getDetails.getbadTelephones();
		for (int i = 0; i < 1; i++) {
			getDetails.setbusinessname(badOrganizations[i].trim());
			getDetails.setbadTelephones(badPhoneNumbers[i].trim());
		new GetAQuoteAction().clickElecquoteLink()
				.enterGetaQuoteDetails(getDetails)
				.enterElectricityAddress(getDetails)
				.enterConsumptionForEle(getDetails, 0)
				.clickCalculateQuoteForElec()
				.verifyBadDataTypeUnsaved()
				.retreiveElectricityQuotesUI()
				.saveCurrentQuote1Year()
				.retreiveSavedQuote(getDetails)
				.verifySavedQuoteStatusBaddata()
				.clickMonthlyQuotepageContinue()
				.verifyBadDataType();
}
}

	/********************************************Gas***************************************/
	
//	 @Test(groups = { GetaQuoteSS})
	public void gasBadOrganizationName() throws InterruptedException {
		Report.createTestLogHeader(
				"BadData_Bad Organization Name -GAS",
				"BadData_Bad Organization Name");
		GetAQuoteDetails getDetails = new TestDataHelper()
		        .getGetAQuoteDetails ("getAQuote_BadData");
		String[] badOrganizations = getDetails.getbadOrganizations();
		for (int i = 0; i < badOrganizations.length; i++) {
		getDetails.setbusinessname(badOrganizations[i].trim());
			new GetAQuoteAction().clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterConsumptionForGas(getDetails, 0)
					.clickGasMeterOptionNO().gasMeterYESandNO(getDetails)
					.verifyBadDataTypeUnsaved()
					.click1stYearTabGas().saveCurrentQuote1year()
					.retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatusBaddata()
					.clickMonthlyQuotepageContinue()
					.verifyBadDataType();
		}
	}
 
//	 @Test(groups = { GetaQuoteSS})
	public void gasBadTeleNo() throws InterruptedException {
		Report.createTestLogHeader(
				"BadData_BadTelePhone No_Name-GAS",
				"BadData_BadTelePhone No_Name");
		GetAQuoteDetails getDetails = new TestDataHelper()
        .getGetAQuoteDetails ("getAQuote_BadData");
		String[] badPhoneNumbers = getDetails.getbadTelephones();
		for (int i = 0; i < badPhoneNumbers.length; i++) {
			getDetails.setbadTelephones(badPhoneNumbers[i].trim());
			new GetAQuoteAction().clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterConsumptionForGas(getDetails, 0)
					.clickGasMeterOptionNO().gasMeterYESandNO(getDetails)
					.verifyBadDataTypeUnsaved()
					.click1stYearTabGas().saveCurrentQuote1year()
					.retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatusBaddata()
					.clickMonthlyQuotepageContinue()
					.verifyBadDataType();
		}
	}
	
//	 @Test(groups = { GetaQuoteSS})
	public void gasBadOrganizationNameAndTeleNo() throws InterruptedException {
		Report.createTestLogHeader(
				"BadData_Bad Organization Name and Telephone No -GAS",
				"BadData_Bad Organization Name and Telephone No");

		GetAQuoteDetails getDetails = new TestDataHelper()
        .getGetAQuoteDetails ("getAQuote_BadData");
		String[] badOrganizations = getDetails.getbadOrganizations();
		String[] badPhoneNumbers = getDetails.getbadTelephones();
		for (int i = 0; i < 1; i++) {
			getDetails.setbusinessname(badOrganizations[i].trim());
			getDetails.setbadTelephones(badPhoneNumbers[i].trim());
			new GetAQuoteAction().clickGasquoteLink()
					.enterGetaQuoteDetails(getDetails)
					.enterConsumptionForGas(getDetails, 0)
					.clickGasMeterOptionNO().gasMeterYESandNO(getDetails)
					.verifyBadDataTypeUnsaved()
					.click1stYearTabGas().saveCurrentQuote1year()
					.retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatusBaddata()
			        .clickMonthlyQuotepageContinue()
					.verifyBadDataType();
		}
	}
	

	/********************************************DUAL***************************************/
	
//	 @Test(groups = { GetaQuoteSS})
	public void dualBadOrganizationName() throws InterruptedException {
		Report.createTestLogHeader(
				"BadData_Bad Organization Name -DUAL",
				"BadData_Bad Organization Name");
		GetAQuoteDetails getDetails = new TestDataHelper()
        .getGetAQuoteDetails ("getAQuote_BadData");
		String[] badOrganizations = getDetails.getbadOrganizations();
		for (int i = 0; i < badOrganizations.length; i++) {
		getDetails.setbusinessname(badOrganizations[i].trim());
		new GetaquoteCombinedEnergyAction()
			        .clickCombinedEnergyLink()
					.enterGetaQuoteDetails(getDetails)
					.enterSupplycodeMannualyElectricity(getDetails)
					.elecSupplyDetailsManuall(getDetails)
					.enterGasAddressAndUsage(getDetails)
					.enterConsumptionForGas(getDetails, 0)
					.calculateQuoteForElec()
					.verifyBadDataTypeUnsaved()
					.saveCurrentQuote1Year()
					.retreiveSavedQuote(getDetails)
					.verifySavedQuoteStatusBaddata()
					.clickMonthlyQuotepageContinue1stYear()
					.verifyBadDataType();
			
		}
	}
 
//	 @Test(groups = { GetaQuoteSS})
	public void dualBadTeleNo() throws InterruptedException {
		Report.createTestLogHeader(
				"BadData_BadTelePhone No_Name-DUAL",
				"BadData_BadTelePhone No_Name");
		GetAQuoteDetails getDetails = new TestDataHelper()
        .getGetAQuoteDetails ("getAQuote_BadData");
		String[] badPhoneNumbers = getDetails.getbadTelephones();
		for (int i = 0; i < badPhoneNumbers.length; i++) {
		getDetails.setbadTelephones(badPhoneNumbers[i].trim());
		new GetaquoteCombinedEnergyAction()
		        .clickCombinedEnergyLink()
				.enterGetaQuoteDetails(getDetails)
				.enterSupplycodeMannualyElectricity(getDetails)
				.elecSupplyDetailsManuall(getDetails)
				.enterGasAddressAndUsage(getDetails)
				.enterConsumptionForGas(getDetails, 0)
				.calculateQuoteForElec()
				.verifyBadDataTypeUnsaved()
				.saveCurrentQuote1Year()
				.retreiveSavedQuote(getDetails)
				.verifySavedQuoteStatusBaddata()
				.clickMonthlyQuotepageContinue1stYear()
				.verifyBadDataType();
		}
	}
	
//	@Test(groups = { GetaQuoteSS})
	public void dualBadOrganizationNameAndTeleNo() throws InterruptedException {
		Report.createTestLogHeader(
				"BadData_Bad Organization Name and Telephone No -DUAL",
				"BadData_Bad Organization Name and Telephone No");

		GetAQuoteDetails getDetails = new TestDataHelper()
        .getGetAQuoteDetails ("getAQuote_BadData");
		String[] badOrganizations = getDetails.getbadOrganizations();
		String[] badPhoneNumbers = getDetails.getbadTelephones();
		for (int i = 0; i < 1; i++) {
			getDetails.setbusinessname(badOrganizations[i].trim());
			getDetails.setbadTelephones(badPhoneNumbers[i].trim());
			new GetaquoteCombinedEnergyAction()
		        .clickCombinedEnergyLink()
				.enterGetaQuoteDetails(getDetails)
				.enterSupplycodeMannualyElectricity(getDetails)
				.elecSupplyDetailsManuall(getDetails)
				.enterGasAddressAndUsage(getDetails)
				.enterConsumptionForGas(getDetails, 0)
				.calculateQuoteForElec()
				.verifyBadDataTypeUnsaved()
				.saveCurrentQuote1Year()
				.retreiveSavedQuote(getDetails)
				.verifySavedQuoteStatusBaddata()
				.clickMonthlyQuotepageContinue1stYear()
				.verifyBadDataType();
		}
	}
}