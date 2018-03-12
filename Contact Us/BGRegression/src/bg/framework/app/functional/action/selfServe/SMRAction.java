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

	public SMRAction setPlausbileReading(String accountNumber) {
		submitMeterReadPage.setPlausbileReading(accountNumber);
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

	public SMRAction setImPlausbileReading(String accountNumber) {
		submitMeterReadPage.setImPlausbileReadingHigh(accountNumber);
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
