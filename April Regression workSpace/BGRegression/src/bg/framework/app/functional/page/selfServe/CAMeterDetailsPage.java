package bg.framework.app.functional.page.selfServe;

import java.util.Properties;

import org.openqa.selenium.InvalidElementStateException;

import bg.framework.app.functional.action.sales.AcquisitionAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class CAMeterDetailsPage extends BasePage {
	// private final static String FILE_NAME =
	// "resources/sales/"+ApplicationConfig.BRAND+"Acquisition.properties";
	/*
	 * private final static String FILE_NAME =
	 * "resources/ReFactoring/BGAcquisition.properties"; private static
	 * Properties pageProperties = new PropertyLoader(FILE_NAME) .load();
	 */

	private final static String FILE_NAME = "resources/selfServe/CAMeterDetailsPage.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME)
			.load();

	public void continueToPaymentOptionsPage() {

		verifyAndSelectDropDownBox(
				pageProperties.getProperty("MeterDetailsPage.gasmetertype"),
				"gas meter type", "Credit Meter");

		verifyAndClick(
				pageProperties.getProperty("MeterDetailsPage.smartmeterno"),
				"smart meter no option");

		verifyAndSelectDropDownBox(
				pageProperties.getProperty("MeterDetailsPage.elecmetertype"),
				"elec meter type", "Single Rate Credit");

		verifyAndClick(
				pageProperties.getProperty("MeterDetailsPage.elecmeterno"),
				"elec smart meter no option");

		verifyAndClick(
				pageProperties.getProperty("MeterDetailsPage.continuebutton"),
				"continue button");

	}

	public void continueToPaymentOptionsPage(int fuel) {

		switch (fuel) {
		case 1:
			verifyAndSelectDropDownBox(
					pageProperties.getProperty("MeterDetailsPage.gasmetertype"),
					"gas meter type", "Credit Meter");

			verifyAndClick(
					pageProperties.getProperty("MeterDetailsPage.smartmeterno"),
					"smart meter no option");

			verifyAndSelectDropDownBox(
					pageProperties
							.getProperty("MeterDetailsPage.elecmetertype"),
					"elec meter type", "Single Rate Credit");

			verifyAndClick(
					pageProperties.getProperty("MeterDetailsPage.elecmeterno"),
					"elec smart meter no option");

			verifyAndClick(
					pageProperties
							.getProperty("MeterDetailsPage.continuebutton"),
					"continue button");
			break;
		case 2:
			verifyAndSelectDropDownBox(
					pageProperties.getProperty("MeterDetailsPage.gasmetertype"),
					"gas meter type", "Credit Meter");

			verifyAndClick(
					pageProperties.getProperty("MeterDetailsPage.smartmeterno"),
					"smart meter no option");
			verifyAndClick(
					pageProperties
							.getProperty("MeterDetailsPage.continuebutton"),
					"continue button");
			break;
		case 3:
			verifyAndSelectDropDownBox(
					pageProperties
							.getProperty("MeterDetailsPage.elecmetertype"),
					"elec meter type", "Single Rate Credit");

			verifyAndClick(
					pageProperties.getProperty("MeterDetailsPage.elecmeterno"),
					"elec smart meter no option");

			verifyAndClick(
					pageProperties
							.getProperty("MeterDetailsPage.continuebutton"),
					"continue button");
			break;
		default:
			verifyAndSelectDropDownBox(
					pageProperties.getProperty("MeterDetailsPage.gasmetertype"),
					"gas meter type", "Credit Meter");

			verifyAndClick(
					pageProperties.getProperty("MeterDetailsPage.smartmeterno"),
					"smart meter no option");

			verifyAndSelectDropDownBox(
					pageProperties
							.getProperty("MeterDetailsPage.elecmetertype"),
					"elec meter type", "Single Rate Credit");

			verifyAndClick(
					pageProperties.getProperty("MeterDetailsPage.elecmeterno"),
					"elec smart meter no option");

			verifyAndClick(
					pageProperties
							.getProperty("MeterDetailsPage.continuebutton"),
					"continue button");
		}

	}
}
