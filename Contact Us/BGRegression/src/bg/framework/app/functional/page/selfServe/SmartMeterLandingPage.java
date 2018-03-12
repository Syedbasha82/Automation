package bg.framework.app.functional.page.selfServe;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.Report;

public class SmartMeterLandingPage extends BasePage {

	public void navigateTocomboRegisterInterestSMlandingPage() {

		/*
		 * browser.open(ApplicationConfig.APP_BG_URL +
		 * "/SmartMeter/Channel-Activation/");
		 */

		browser.open(ApplicationConfig.APP_BG_URL + "/upgrade/smartmeter/");
		Report.updateTestLog(
				"Navigated to Combo Register your interest and Smart Meter Landing Page Successfully !!",
				"Pass");

	}
}