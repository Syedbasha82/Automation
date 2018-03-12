package bg.framework.app.functional.page.selfServe;

import java.util.Properties;

import javax.swing.Box.Filler;

import org.openqa.selenium.InvalidElementStateException;

import bg.framework.app.functional.action.sales.AcquisitionAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class CAPaymentOptionsPage extends BasePage {
	// private final static String FILE_NAME =
	// "resources/sales/"+ApplicationConfig.BRAND+"Acquisition.properties";
	/*
	 * private final static String FILE_NAME =
	 * "resources/ReFactoring/BGAcquisition.properties"; private static
	 * Properties pageProperties = new PropertyLoader(FILE_NAME) .load();
	 */

	private final static String FILE_NAME = "resources/selfServe/CAPaymentOptionsPage.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME)
			.load();

	public void selectMonthlyFixedDirectDebit() {

		verifyAndClick(
				pageProperties
						.getProperty("CAPaymentOptionsPage.monthlyDirectDebit"),
				"Monthly Fixed Direct Debit Radio");

	}

	public void selectMonthlyVariableDirectDebit() {

		verifyAndClick(
				pageProperties
						.getProperty("CAPaymentOptionsPage.MONTHLY_VARIABLE_DIRECT_DEBIT"),
				"Monthly Variable Direct Debit Radio");

	}

	public void continueToReviewOrderPage(UserProfile userProfile) {

		if (browser.isElementVisible(pageProperties
				.getProperty("CAPaymentOptionsPage.bankAccountNumber"))) {

			verifyAndInputById(
					pageProperties
							.getProperty("CAPaymentOptionsPage.bankAccountNumber"),
					"bankAccountNumber", userProfile.getAccNumber());

			browser.execJS("document.getElementById('"
					+ pageProperties
							.getProperty("CAPaymentOptionsPage.sortCode1")
					+ "').setAttribute('value','" + userProfile.getsortCode1()
					+ "')");
			Report.updateTestLog("Sort Code 1 Text box filled with Value: "
					+ userProfile.getsortCode1(), "Done");

			browser.execJS("document.getElementById('"
					+ pageProperties
							.getProperty("CAPaymentOptionsPage.sortCode2")
					+ "').setAttribute('value','" + userProfile.getsortCode2()
					+ "')");
			Report.updateTestLog("Sort Code 2 Text box filled with Value: "
					+ userProfile.getsortCode2(), "Done");
			browser.execJS("document.getElementById('"
					+ pageProperties
							.getProperty("CAPaymentOptionsPage.sortCode3")
					+ "').setAttribute('value','" + userProfile.getsortCode3()
					+ "')");
			Report.updateTestLog("Sort Code 3 Text box filled with Value: "
					+ userProfile.getsortCode3(), "Done");

			/*
			 * browser.execJS(
			 * "document.getElementById('sortCode2').setAttribute('value','25')"
			 * );
			 * 
			 * browser.execJS(
			 * "document.getElementById('sortCode3').setAttribute('value','52')"
			 * );
			 */

			/*
			 * browser.input(pageProperties
			 * .getProperty("CAPaymentOptionsPage.sortCode1"), "54");
			 * 
			 * verifyAndInputById( pageProperties
			 * .getProperty("CAPaymentOptionsPage.sortCode1"), "sortCode1",
			 * "54"); browser.click(pageProperties
			 * .getProperty("CAPaymentOptionsPage.sortCode2"));
			 * 
			 * verifyAndInputById( pageProperties
			 * .getProperty("CAPaymentOptionsPage.sortCode2"), "sortCode2",
			 * "25");
			 * 
			 * browser.click(pageProperties
			 * .getProperty("CAPaymentOptionsPage.sortCode3"));
			 * verifyAndInputById( pageProperties
			 * .getProperty("CAPaymentOptionsPage.sortCode3"), "sortCode3",
			 * "65");
			 */

			verifyAndInputById(
					pageProperties
							.getProperty("CAPaymentOptionsPage.accountHolderName"),
					"accountHolderName", userProfile.getFirstName() + " "
							+ userProfile.getLastName());

			verifyAndSelectDropDownBox(
					pageProperties
							.getProperty("CAPaymentOptionsPage.paymentDate"),
					"paymentDate", userProfile.getDayOfBirth());

			verifyAndSelectDropDownBox(
					pageProperties
							.getProperty("CAPaymentOptionsPage.annualGasSpendDuration"),
					"annualGasSpendDuration", userProfile.getGasSpendDuration());

			verifyAndInputById(
					pageProperties
							.getProperty("CAPaymentOptionsPage.annualGasSpendAmount"),
					"annualGasSpendAmount", userProfile
							.getannualGasSpendAmount());

			verifyAndSelectDropDownBox(
					pageProperties
							.getProperty("CAPaymentOptionsPage.annualElecSpendDuration"),
					"annualElecSpendDuration", userProfile
							.getElecSpendDuration());

			verifyAndInputById(
					pageProperties
							.getProperty("CAPaymentOptionsPage.annualElecSpendAmount"),
					"annualElecSpendAmount", userProfile
							.getannualElecSpendAmount());
		}

		verifyAndClick(
				pageProperties
						.getProperty("CAPaymentOptionsPage.continuebutton"),
				"continuebutton");
	}
}
