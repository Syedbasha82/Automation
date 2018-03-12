package bg.framework.app.functional.page.selfServe;

import java.util.Properties;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class ClearAndSimpleTariffPage extends BasePage {

	private final static String FILE_NAME = "resources/selfServe/ClearAndSimplePage.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME)
			.load();

	public void verifyClearAndSimpleTariffPage() {

		verifyIsTextPresent(
				pageProperties
						.getProperty("ClearAndSimplePage.GasAndElectricitySectionText"),
				"Gas And Electricity Section");

		verifyIsTextPresent(
				pageProperties
						.getProperty("ClearAndSimplePage.GasOnlySectionText"),
				"Gas And Electricity Section");

		verifyIsTextPresent(
				pageProperties
						.getProperty("ClearAndSimplePage.ElectricityOnlySectionText"),
				"Gas And Electricity Section");

	}

	public void switchToGasAndElectricity() {

		if (browser
				.isElementVisible(pageProperties
						.getProperty("ClearAndSimplePage.GasAndElectricitySwitchNowButtonId"))) {

			verifyAndClick(
					pageProperties
							.getProperty("ClearAndSimplePage.GasAndElectricitySwitchNowButtonId"),
					"Clear And Simple Gas And Electricity SwitchNow Button");

			if (!browser.getTitle().contains("EnergySmart")) {

				browser.open(ApplicationConfig.APP_BG_URL
						+ "/EnergyFeature/EnergySales/orderType/StandardEnergy/feature/EnergySmart/energyType/Dual/");
			}
		}

		else if (browser.isElementVisibleWithClass("btn-comp.btncomp-primary")) {
			verifyAndClickWithClass("btn-comp.btncomp-primary",
					"Clear And Simple Gas And Electricity SwitchNow Button");
		}

	}

	public void selectEsmartCheckbox() {
		verifyAndSelectCheckBoxByID(
				pageProperties
						.getProperty("ClearAndSimplePage.GasAndElectricityCheckboxId"),
				"Clear And Simple Gas And Electricity Checkbox");
	}
}