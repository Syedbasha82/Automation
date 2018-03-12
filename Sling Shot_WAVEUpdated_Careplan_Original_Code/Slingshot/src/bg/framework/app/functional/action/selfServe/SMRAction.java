package bg.framework.app.functional.action.selfServe;

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

	public SMRAction verifyMeterConfirmation(String accountNumber) {
		submitMeterReadPage.verifyMeterConfirmation(accountNumber);
		return this;

	}

	public SMRAction setImPlausbileReading(String accountNumber) {
		submitMeterReadPage.setImPlausbileReadingHigh(accountNumber);
		return this;
	}
}
