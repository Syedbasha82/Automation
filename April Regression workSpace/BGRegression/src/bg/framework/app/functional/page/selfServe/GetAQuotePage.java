package bg.framework.app.functional.page.selfServe;

import java.util.Properties;

import org.openqa.selenium.internal.selenesedriver.IsElementDisplayed;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class GetAQuotePage extends BasePage {

	private final static String FILE_NAME = "resources/selfServe/GetAQuotePage.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME)
			.load();

	public void verifyGetAQuotePage() {
		// TODO Auto-generated method stub

		verifyPageTitle(pageProperties.getProperty("GetAQuotePage.pageTitle"));

	}

	public void selectQuoteForGasAndElectricity() {
		// TODO Auto-generated method stub

		verifyAndClick(
				pageProperties.getProperty("GetAQuotePage.quoteForDualRadioId"),
				"Quote For Gas and Electricity Radio");

	}

	public void selectDualFuelTarrifYes() {
		// TODO Auto-generated method stub

		verifyAndClick(
				pageProperties.getProperty("GetAQuotePage.dualFuelTarrifYesId"),
				"Dual Fuel Tarrif Yes");

		verifyAndClick(
				pageProperties
						.getProperty("GetAQuotePage.nextFuelTypeButtonId"),
				"Next to Fuel Type Button");

	}

	public void enterSupplyDetails(UserProfile userProfile) {

		verifyAndSelectDropDownBox(
				pageProperties
						.getProperty("GetAQuotePage.energyCurrentSupplierId"),
				"Energy Current Supplier", userProfile
						.getCurrentEnergySupplier());
		verifyAndSelectDropDownBox(
				pageProperties
						.getProperty("GetAQuotePage.energyCurrentPaymentMethodDropdownId"),
				"Energy Current Payment Method Dropdown", userProfile
						.getCurrentEnergyPaymentMethod().trim());

		verifyAndSelectDropDownBox(
				pageProperties
						.getProperty("GetAQuotePage.energyCurrentTariffDropdownId"),
				"Energy Current Tariff Dropdown", userProfile
						.getCurrentEnergyTafiff());

		verifyAndInputById(
				pageProperties.getProperty("GetAQuotePage.gasSpendValueId"),
				"gas Spend Value", userProfile.getannualGasSpendAmount());

		verifyAndInputById(
				pageProperties
						.getProperty("GetAQuotePage.electricitySpendValueId"),
				"Electricity Spend Value", userProfile
						.getannualElecSpendAmount());
		verifyAndClick(
				pageProperties
						.getProperty("GetAQuotePage.nextGas-detailsButtonId"),
				"Next Gas-details Button");

	}

	public void enterContactDetails() {

		verifyAndSelectDropDownBox(
				pageProperties
						.getProperty("GetAQuotePage.telephoneNumber-telephoneTypeDropdownId"),
				" Telephone Number-telephone Type Dropdown", "Mobile");

		/*
		 * verifyAndSelectDropDownBox( pageProperties
		 * .getProperty("GetAQuotePage.energyCurrentPaymentMethodDropdownId"),
		 * "Energy Current Payment Method Dropdown", "Monthly_Direct_Debit");
		 * 
		 * verifyAndSelectDropDownBox( pageProperties
		 * .getProperty("GetAQuotePage.energyCurrentTariffDropdownId"),
		 * "Energy Current Tariff Dropdown", "Standard (Variable)");
		 * 
		 * verifyAndInputById(
		 * pageProperties.getProperty("GetAQuotePage.gasSpendValueId"),
		 * "gas Spend Value", "250");
		 * 
		 * verifyAndInputById( pageProperties
		 * .getProperty("GetAQuotePage.electricitySpendValueId"),
		 * "Electricity Spend Value", "150");
		 */
		verifyAndClick(
				pageProperties
						.getProperty("GetAQuotePage.nextYour-detailsButtonId"),
				"Next Your-details Button");

		browser.wait(1000);

		verifyAndClick(
				pageProperties.getProperty("GetAQuotePage.getQuoteButtonId"),
				"Get Quote Button");

	}

}