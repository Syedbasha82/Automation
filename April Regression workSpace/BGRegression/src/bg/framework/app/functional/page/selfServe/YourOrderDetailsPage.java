package bg.framework.app.functional.page.selfServe;

import java.util.Properties;

import org.openqa.selenium.internal.selenesedriver.IsElementDisplayed;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class YourOrderDetailsPage extends BasePage {

	private final static String FILE_NAME = "resources/selfServe/YourOrderDetailsPage.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME)
			.load();

	public void continueToPersonalDetailsPage() {

		verifyAndSelectDropDownBox(
				pageProperties
						.getProperty("YourOrderDetailsPage.CurrentGasSupplierDropDownId"),

				"Current Gas Supplier ",
				pageProperties
						.getProperty("YourOrderDetailsPage.CurrentGasSupplierDefault"));

		verifyAndSelectDropDownBox(
				pageProperties
						.getProperty("YourOrderDetailsPage.CurrentElectricitySupplierDropDownId"),

				"Current Electricity Supplier ",
				pageProperties
						.getProperty("YourOrderDetailsPage.CurrentElectricitySupplierDefault"));
		verifyAndClick(
				pageProperties
						.getProperty("YourOrderDetailsPage.ContinueButtonId"),
				"Continue Button");

	}

	
}