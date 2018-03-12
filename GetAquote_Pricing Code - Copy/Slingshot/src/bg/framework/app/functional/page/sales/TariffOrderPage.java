package bg.framework.app.functional.page.sales;

import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;

import java.util.Properties;

public class TariffOrderPage extends BasePage {
    private final static String FILE_NAME = "resources/sales/AcquisitionNewBlue.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    public void clickOrderButton() {
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.OrderBtn")))
            browser.clickWithXpath(pageProperties.getProperty("Acquisition.OrderBtn"));
        browser.wait(getWaitTime());
    }

}
