package bg.framework.app.functional.page.selfServe;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.Report;

public class OurTariffsPage extends BasePage {

	public void navigateToClearAndSimpleTariffPage() {

		browser.open(ApplicationConfig.APP_BG_URL
				+ "/products-and-services/gas-and-electricity/our-energy-tariffs/clear-and-simple.html");
		Report.updateTestLog(
				"Navigated to Clear and Simple tariff Page Successfully !!",
				"Pass");

	}

	public void navigateToPricePromiseJuly2015TariffPage() {

		browser.open(ApplicationConfig.APP_BG_URL
				+ "/products-and-services/gas-and-electricity/our-energy-tariffs/price-promise-july-2015.html");
		Report.updateTestLog(
				"navigated To Price Promise July 2015 Tariff Page ", "Pass");

	}

	public void navigateToFixPriceOct2014TariffPage() {
		browser.open(ApplicationConfig.APP_BG_URL
				+ "/products-and-services/gas-and-electricity/our-energy-tariffs/fixed-price-october-2014.html");
		Report.updateTestLog("navigated To Fixed Price Oct2014 Tariff Page",
				"Pass");

	}

	public void switchToSmartTariff(int i, int fuelIncrement) {

		String energyType = "Dual/";
		switch (fuelIncrement) {
		case 1:
			break;
		case 2:
			energyType = "Gas/";
			break;
		case 3:
			energyType = "Elec/";
			break;
		default:
			energyType = "Dual/";
			break;

		}

		switch (i) {

		case 1:
			browser.open(ApplicationConfig.APP_BG_URL
					+ "/EnergyFeature/EnergySales/orderType/StandardEnergy/feature/EnergySmart/energyType/"+energyType);
			Report.updateTestLog("navigated To Standard EnergyTariff Page",
					"Pass");
			break;

		case 2:

			browser.open(ApplicationConfig.APP_BG_URL
					+ "/EnergyFeature/EnergySales/orderType/FixAndGiftCardMay2015/feature/EnergySmart/energyType/Dual/"+energyType);
			Report.updateTestLog(
					"navigated To Fix And Gift Card May 2015 Tariff Page",
					"Pass");
			break;

		case 3:

			browser.open(ApplicationConfig.APP_BG_URL
					+ "/EnergyFeature/EnergySales/orderType/FixAndFallFebruary2015/feature/EnergySmart/energyType/Dual/"+energyType);
			Report.updateTestLog(
					"navigated To Fix And Fall February 2015 Tariff Page",
					"Pass");
			break;

		case 4:

			browser.open(ApplicationConfig.APP_BG_URL
					+ "/EnergyFeature/EnergySales/orderType/FixedPriceMarch2016/feature/EnergySmart/energyType/Dual/"+energyType);
			Report.updateTestLog(
					"navigated To Fixed Price March 2016 Tariff Page", "Pass");
			break;
		default:
			browser.open(ApplicationConfig.APP_BG_URL
					+ "/EnergyFeature/EnergySales/orderType/StandardEnergy/feature/EnergySmart/energyType/Dual/"+energyType);
			Report.updateTestLog("navigated To Standard EnergyTariff Page",
					"Pass");

		}

	}

}