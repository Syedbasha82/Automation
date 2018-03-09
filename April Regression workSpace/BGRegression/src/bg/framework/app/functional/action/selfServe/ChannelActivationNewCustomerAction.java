package bg.framework.app.functional.action.selfServe;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.page.selfServe.CAMeterDetailsPage;
import bg.framework.app.functional.page.selfServe.CAPaymentOptionsPage;
import bg.framework.app.functional.page.selfServe.CAPersonalDetailsPage;
import bg.framework.app.functional.page.selfServe.CAReviewOrderPage;
import bg.framework.app.functional.page.selfServe.ClearAndSimpleTariffPage;
import bg.framework.app.functional.page.selfServe.ComboRegisterYourInterestAndSmartMeterLandingPage;
import bg.framework.app.functional.page.selfServe.GetAQuotePage;
import bg.framework.app.functional.page.selfServe.OurTariffsPage;
import bg.framework.app.functional.page.selfServe.RegisterYourInterestPage;
import bg.framework.app.functional.page.selfServe.SmartMeterLandingPage;
import bg.framework.app.functional.page.selfServe.YourOrderDetailsPage;
import bg.framework.app.functional.page.selfServe.YourResultsPage;

public class ChannelActivationNewCustomerAction {

	// public SubmitMeterReadPage submitMeterReadPage = new
	// SubmitMeterReadPage();
	public SmartMeterLandingPage smartMeterLandingPage = new SmartMeterLandingPage();

	public GetAQuotePage getaQuotePage = new GetAQuotePage();

	public ChannelActivationNewCustomerAction navigateTocomboRegisterInterestSMlandingPage() {

		smartMeterLandingPage.navigateTocomboRegisterInterestSMlandingPage();
		return this;

	}

	public ChannelActivationNewCustomerAction selectYesOption() {

		new ComboRegisterYourInterestAndSmartMeterLandingPage()
				.selectYesOption();
		return this;

	}

	public ChannelActivationNewCustomerAction selectNoOption() {

		new ComboRegisterYourInterestAndSmartMeterLandingPage()
				.selectNoOption();
		return this;

	}

	public ChannelActivationNewCustomerAction verifyComboRegisterInterestSMlandingPageYesOption() {

		new ComboRegisterYourInterestAndSmartMeterLandingPage()
				.verifyYesOption();
		return this;

	}

	public ChannelActivationNewCustomerAction verifyComboRegisterInterestSMlandingPageNoOption() {

		new ComboRegisterYourInterestAndSmartMeterLandingPage()
				.verifyNoOption();
		return this;

	}

	public ChannelActivationNewCustomerAction fillDetailsForRegisterInterest(
			UserProfile userProfile) {

		new ComboRegisterYourInterestAndSmartMeterLandingPage()
				.fillDetailsForRegisterInterest(userProfile);
		return this;

	}

	public ChannelActivationNewCustomerAction answerScreeningQuestions(
			UserProfile userProfile) {
		new ComboRegisterYourInterestAndSmartMeterLandingPage()
				.answerScreeningQuestions(userProfile);
		return this;

	}

	public ChannelActivationNewCustomerAction checkPropertySuitability() {
		new ComboRegisterYourInterestAndSmartMeterLandingPage()
				.checkPropertySuitability();
		return this;

	}

	public ChannelActivationNewCustomerAction verifyRegisterYourInterestLinkAtSMLpage() {
		new ComboRegisterYourInterestAndSmartMeterLandingPage()
				.verifyRegisterYourInterestLinkAtSMLpage();
		return this;

	}

	public ChannelActivationNewCustomerAction navigateToRegisterYourInterestPage() {
		new ComboRegisterYourInterestAndSmartMeterLandingPage()
				.navigateToRegisterYourInterestPage();
		return this;

	}

	public ChannelActivationNewCustomerAction verifyGetAQuotePage() {
		// TODO Auto-generated method stub

		new GetAQuotePage().verifyGetAQuotePage();
		return this;

	}

	public ChannelActivationNewCustomerAction getAQuote(UserProfile userProfile) {
		// TODO Auto-generated method stub

		getaQuotePage.selectQuoteForGasAndElectricity();

		getaQuotePage.selectDualFuelTarrifYes();

		getaQuotePage.enterSupplyDetails(userProfile);

		getaQuotePage.enterContactDetails();

		return this;

	}

	public ChannelActivationNewCustomerAction verifyYourResultsPage() {
		// TODO Auto-generated method stub

		new YourResultsPage().verifyYourResultsPage();
		return this;

	}

	public ChannelActivationNewCustomerAction switchToTarrifs(int tariff) {
		// TODO Auto-generated method stub

		new YourResultsPage().switchNow(tariff);
		return this;

	}

	public ChannelActivationNewCustomerAction navigateToClearAndSimpleTariffPage() {
		// TODO Auto-generated method stub

		new OurTariffsPage().navigateToClearAndSimpleTariffPage();
		return this;

	}

	public ChannelActivationNewCustomerAction navigateToPricePromiseJuly2015TariffPage() {
		// TODO Auto-generated method stub

		new OurTariffsPage().navigateToPricePromiseJuly2015TariffPage();
		return this;

	}

	public ChannelActivationNewCustomerAction navigateToFixPriceOct2014TariffPage() {
		// TODO Auto-generated method stub

		new OurTariffsPage().navigateToFixPriceOct2014TariffPage();
		return this;

	}

	public ChannelActivationNewCustomerAction verifyClearAndSimpleTariffPage() {

		new ClearAndSimpleTariffPage().verifyClearAndSimpleTariffPage();
		return this;

	}

	public ChannelActivationNewCustomerAction switchToGasAndElectricity() {

		new ClearAndSimpleTariffPage().switchToGasAndElectricity();

		return this;

	}

	public ChannelActivationNewCustomerAction selectEsmartCheckbox() {

		new ClearAndSimpleTariffPage().selectEsmartCheckbox();

		return this;

	}

	public ChannelActivationNewCustomerAction continueToPersonalDetailsPage() {

		new YourOrderDetailsPage().continueToPersonalDetailsPage();

		return this;

	}

	public ChannelActivationNewCustomerAction continueToMeterDetailsPage(
			UserProfile userProfile) {

		new CAPersonalDetailsPage().continueToMeterDetailsPage(userProfile);

		return this;

	}

	public ChannelActivationNewCustomerAction continueToMeterDetailsPageEsmart(
			UserProfile userProfile) {

		new CAPersonalDetailsPage()
				.continueToMeterDetailsPageEsmart(userProfile);

		return this;

	}

	public ChannelActivationNewCustomerAction continueToPaymentOptionsPage() {

		new CAMeterDetailsPage().continueToPaymentOptionsPage();

		return this;

	}

	public ChannelActivationNewCustomerAction continueToReviewOrderPage(
			UserProfile userProfile) {

		new CAPaymentOptionsPage().continueToReviewOrderPage(userProfile);

		return this;

	}

	public ChannelActivationNewCustomerAction continueToReviewOrderPageWithDirectDebit(
			UserProfile userProfile) {

		new CAPaymentOptionsPage().selectMonthlyFixedDirectDebit();

		new CAPaymentOptionsPage().continueToReviewOrderPage(userProfile);

		return this;

	}

	public ChannelActivationNewCustomerAction continueToReviewOrderPageWithVariableDirectDebit(
			UserProfile userProfile) {

		new CAPaymentOptionsPage().selectMonthlyVariableDirectDebit();

		new CAPaymentOptionsPage().continueToReviewOrderPage(userProfile);

		return this;

	}

	public ChannelActivationNewCustomerAction verifyAndConfirmOrder() {

		new CAReviewOrderPage().verifyAndConfirmOrder();

		return this;

	}

	public ChannelActivationNewCustomerAction verifyLeadCreation() {

		new CAReviewOrderPage().verifyLeadCreation();

		return this;

	}

	public ChannelActivationNewCustomerAction verifyLeadType() {

		new CAReviewOrderPage().verifyLeadType();

		return this;

	}

	public ChannelActivationNewCustomerAction verifyLeadStatusBefore() {

		new CAReviewOrderPage().verifyLeadStatusBefore();

		return this;

	}

	public ChannelActivationNewCustomerAction verifyLeadStatusAfter() {

		new CAReviewOrderPage().verifyLeadStatusAfter();

		return this;

	}

	public ChannelActivationNewCustomerAction runAcqBatch() {

		new CAReviewOrderPage().runAcqBatch();

		return new ChannelActivationNewCustomerAction();
	}

	public ChannelActivationNewCustomerAction runESmartBatch() {

		new CAReviewOrderPage().runESmartBatch();

		return new ChannelActivationNewCustomerAction();
	}

	public ChannelActivationNewCustomerAction registerInterest(
			UserProfile userProfile) {
		new RegisterYourInterestPage().registerInterest(userProfile);
		return this;

	}

	public ChannelActivationNewCustomerAction verifyInterestRegistration() {

		new RegisterYourInterestPage().verifyInterestRegistration();

		return this;
	}

	public ChannelActivationNewCustomerAction runRegIntBatch() {

		new RegisterYourInterestPage().runRegIntBatch();

		return this;
	}

	public ChannelActivationNewCustomerAction switchToSmartTariff(int i,
			int fuelIncrement) {
		// TODO Auto-generated method stub

		new OurTariffsPage().switchToSmartTariff(i, fuelIncrement);
		return this;
	}

	public AccountOverviewAction verifyLogin(UserProfile userProfile) {

		LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
		legacyLoginPage.loginUser(userProfile);
		return new AccountOverviewAction(userProfile);

	}

	public ChannelActivationNewCustomerAction verifyGetAQuoteLeadCreation() {

		new YourResultsPage().verifyGetAQuoteLeadCreation();
		return this;

	}

	public ChannelActivationNewCustomerAction verifyQuoteLeadStatusBefore() {
		new YourResultsPage().verifyQuoteLeadStatusBefore();
		return this;

	}

	public ChannelActivationNewCustomerAction runQuoteBatch() {
		new YourResultsPage().runQuoteBatch();
		return this;

	}

	public ChannelActivationNewCustomerAction verifyQuoteLeadStatusAfter() {

		new YourResultsPage().verifyQuoteLeadStatusAfter();

		return this;

	}

	public ChannelActivationNewCustomerAction continueToPaymentOptionsPage(
			int fuelIncrement) {
		new CAMeterDetailsPage().continueToPaymentOptionsPage(fuelIncrement);

		return this;

	}

}
