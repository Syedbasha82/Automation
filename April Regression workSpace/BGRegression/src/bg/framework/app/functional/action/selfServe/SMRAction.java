package bg.framework.app.functional.action.selfServe;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.page.selfServe.AccountOverviewPage;
import bg.framework.app.functional.page.selfServe.SubmitMeterReadPage;
import bg.framework.app.functional.util.OnlineDBConnector;

public class SMRAction {

	public SubmitMeterReadPage submitMeterReadPage = new SubmitMeterReadPage();

	public SMRAction selectAccount(String accountNumber) {
		submitMeterReadPage.selectAccount(accountNumber);
		return this;

	}

	public SMRAction confirmAccountSelection() {

		submitMeterReadPage.confirmAccountSelection();
		return this;

	}
	public SMRAction navigateToSMRAnonymousPage() {

		submitMeterReadPage.navigateToSMRAnonymousPage();
		return this;

	}
	public SMRAction navigateToSMRFromAccountOverview() {

		submitMeterReadPage.navigateToSMRFromAccountOverview();
		return this;

	}
	public SMRAction navigateToSMRFromAccountOverviewDualGas(UserProfile userProfile) {

		submitMeterReadPage.navigateToSMRFromAccountOverviewDualGas(userProfile);
		return this;

	}
	public SMRAction navigateToSMRFromAccountOverviewDualElec(UserProfile userProfile) {

		submitMeterReadPage.navigateToSMRFromAccountOverviewDualElec(userProfile);
		return this;

	}
	public SMRAction navigateToAccountOverview() {

		submitMeterReadPage.navigateToAccountOverview();
		return this;

	}
	public SMRAction findYourAccounts(UserProfile userProfile) {

		submitMeterReadPage.findYourAccounts(userProfile);
		return this;

	}
	public SMRAction findYourAccountsByPostCode(UserProfile userProfile) {

		submitMeterReadPage.findYourAccountsByPostCode(userProfile);
		return this;

	}
	public SMRAction setPlausibleReadingAnonymousJIGas(String accountNumber) {
		submitMeterReadPage.setPlausibleReadingAnonymousJIGas(accountNumber);
		return this;

	}
	public SMRAction setPlausbileReading(String accountNumber) {
		submitMeterReadPage.setPlausbileReadingMeterRead(accountNumber);
		return this;

	}
	public SMRAction setPlausibleReadingAnonymous(String accountNumber) {
		submitMeterReadPage.setPlausibleReadingAnonymous(accountNumber);
		return this;

	}
	public SMRAction setPlausibleReadingAnonymousDual(String accountNumber) {
		submitMeterReadPage.setPlausibleReadingAnonymousDual(accountNumber);
		return this;

	}
	public SMRAction setPlausibleReadingsDual(String accountNumber) {
		submitMeterReadPage.setPlausibleReadingsDual(accountNumber);
		return this;

	}
	public SMRAction setPlausibleReadingsDualE7(String accountNumber) {
		submitMeterReadPage.setPlausibleReadingsDualE7(accountNumber);
		return this;

	}
	public SMRAction setPlausibleReadingElec(String accountNumber) {
		submitMeterReadPage.setPlausibleReadingElec(accountNumber);
		return this;

	}
	public SMRAction setPlausibleReadingsDualGas(String accountNumber) {
		submitMeterReadPage.setPlausibleReadingsDualGas(accountNumber);
		return this;

	}
	public SMRAction setPlausibleReadingAnonymousJI(String accountNumber) {
		submitMeterReadPage.setPlausibleReadingAnonymousJI(accountNumber);
		return this;

	}
	public SMRAction setPlausibleReadingElecDay(String accountNumber) {
		submitMeterReadPage.setPlausibleReadingElecDay(accountNumber);
		return this;

	}
	public SMRAction setPlausibleReadingMixedElecDay(String accountNumber) {
		submitMeterReadPage.setPlausibleReadingMiedElecDay(accountNumber);
		return this;

	}
	
	public SMRAction setPlausbileReadingMeterReadForDayReading(String accountNumber) {
		submitMeterReadPage.setPlausbileReadingMeterReadForDayReading(accountNumber);
		return this;

	}
	public SMRAction setPlausbileReadingMeterReadForNightReading(String accountNumber) {
		submitMeterReadPage.setPlausbileReadingMeterReadForNightReading(accountNumber);
		return this;

	}

	public SMRAction submitMeterReads() {
		submitMeterReadPage.submitMeterReads();
		return this;

	}

	public SMRAction submitImplaussibleMeterRead() {
		submitMeterReadPage.submitImplaussibleMeterRead();
		return this;
	}

	public SMRAction resetMeterRead(String accountNumber) {
		new OnlineDBConnector().resetMeterReadCount(accountNumber);
		return this;
	}

	public SMRAction verifyMeterConfirmation(String accountNumber, UserProfile userProfile) {
		submitMeterReadPage.verifyMeterConfirmation(accountNumber, userProfile);
		return this;

	}
	public SMRAction  verifyMeterConfirmationAnonymous(String accountNumber, UserProfile userProfile) {
		submitMeterReadPage. verifyMeterConfirmationAnonymous(accountNumber, userProfile);
		return this;

	}
	public SMRAction  EnterRegistrationDetailas() {
		submitMeterReadPage.EnterRegistrationDetailas();
		return this;

	}
	public SMRAction  verifyQuickRegisterOverlay() {
		submitMeterReadPage.verifyQuickRegisterOverlay();
		return this;

	}
	public SMRAction  verifyAccountPresence() {
		submitMeterReadPage.verifyAccountPresence();
		return this;

	}

	public SMRAction setImPlausbileReading(String accountNumber) {
		submitMeterReadPage.setImPlausbileReadingHigh(accountNumber);
		return this;
	}
	public SMRAction setImPlausbileReadingLowElecDay(String accountNumber) {
		submitMeterReadPage.setImPlausbileReadingLowElecDay(accountNumber);
		return this;
	}
	
	public SMRAction setPlausbileReadingNectar(String accountNumber) {
		submitMeterReadPage.setPlausbileReadingNectar(accountNumber);
		return this;
	}
	
	public SMRAction nectarSignUp() {
		submitMeterReadPage.nectarSignUp();
		return this;

	}
	
	public SMRAction submitMeterReadings() {
		submitMeterReadPage.submitMeterReads();
		return this;

	}
	
	public SMRAction verifyNectarConfirmation() {
		submitMeterReadPage.verifyNectarConfirmation();
		return this;

	}

	public SMRAction verifyFinallyBilledMsg() {
		submitMeterReadPage.verifyFinallyBilledMsg();
		return this;

	}
	
	public SMRAction submitFinallyBilledReadings(String accountNumber) {
		submitMeterReadPage.submitFinallyBilledReadings(accountNumber);
		return this;

	}
	public SMRAction verifyClosedAccountinSMR(UserProfile userProfile) {

		submitMeterReadPage.verifyClosedAccountSMR(userProfile.getAccNumber());
		return this;

	}
	public SMRAction logout () {
		new LegacyLoginPage().logOut();
		return this;
	}


/* Added for BGMO Start */
public SMRAction verifySmartMeterLinkAtMeterReadingPage() {
		new AccountOverviewPage().verifySmartMeterLink();
		return this;
	}

	public SMRAction verifyNoSmartMeterLinkAtMeterReadingPage() {
		new AccountOverviewPage().verifyNoSmartMeterLink();
		return this;
	}

	public AccountOverviewAction navigateToAccountOverviewPage() {
		new SubmitMeterReadPage().navigateToAccountOverviewPage();
		return new AccountOverviewAction();
	}

/* Added for BGMO End */
	
}
