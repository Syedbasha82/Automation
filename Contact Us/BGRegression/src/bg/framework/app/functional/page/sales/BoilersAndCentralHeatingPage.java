package bg.framework.app.functional.page.sales;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;

import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 27/02/12
 * Time: 10:19
 * To change this template use File | Settings | File Templates.
 */
public class BoilersAndCentralHeatingPage extends BasePage {
    private final static String FILE_NAME = "resources/sales/BoilersAndCentralHeatingPage.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    public void navigateToBoilersAndHeatingCoverPage() {
        verifyAndClickWithLinkText(pageProperties.getProperty("BoilersAndCentralHeating.ViewInsuranceOptions"), "Boiler & Heating Cover");
    }

    public void navigateToGetAnInsuranceQuote() {
    	browser.open(ApplicationConfig.APP_BG_URL+"/products-and-services/boilers-and-central-heating.html");
        //verifyAndClick(pageProperties.getProperty("BoilersAndCentralHeating.getAnInsuranceQuote"), "Get an Insurance Quote");
    	browser.click(pageProperties.getProperty("BoilersAndCentralHeating.boiler"));
    	//browser.click(pageProperties.getProperty("BoilersAndCentralHeating.plumbing"));
    	browser.click(pageProperties.getProperty("BoilersAndCentralHeating.getAnInsuranceQuote"));
    	browser.wait(4000);
    }
}
