package bg.framework.app.functional.page.sales;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

import java.util.Properties;

public class ProductsAndServicesPage extends BasePage {
    private final static String FILE_NAME = "resources/sales/ProductAndServicesPage.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    public void navigateToGasAndElectricityPage() {

    	if (ApplicationConfig.BRAND.equalsIgnoreCase("fusion")) {
        	
     	   if (browser.isTextPresent(pageProperties.getProperty("ProductAndServicesPage.Compareourtariffs"))) {
                browser.clickWithLinkText(pageProperties.getProperty("ProductAndServicesPage.Compareourtariffs"));

                Report.updateTestLog("Navigate to Compare our tariffs tariff page", "PASS");
            } else {

            	 if (browser.isTextPresent(pageProperties.getProperty("ProductAndServicesPage.EnergyTariffs"))) {
                     browser.clickWithLinkText(pageProperties.getProperty("ProductAndServicesPage.EnergyTariffs"));

                     Report.updateTestLog("Navigate to Compare our tariffs tariff page", "PASS");
                 }
     
            }
        }
        
        else if (ApplicationConfig.BRAND.equalsIgnoreCase("bg")) {
        	
     	  /* if (browser.isTextPresent(pageProperties.getProperty("ProductAndServicesPage.GELink"))) {
                browser.clickWithLinkText(pageProperties.getProperty("ProductAndServicesPage.GELink"));

                Report.updateTestLog("Navigate to Gas And Electricity Link", "PASS");
            } else {

                Report.updateTestLog("Navigate to Gas And Electricity Link", "FAIL");
     
            }*/
        }
    }
    public void navigateToOurTariffsPage() {

        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ProductAndServicesPage.GasAndElectricity"))) {
            browser.clickWithXpath(pageProperties.getProperty("ProductAndServicesPage.GasAndElectricity"));
        }
        browser.wait(getWaitTime());
    }

    public void navigateBackToHomePage() {
        browser.click("back");
    }

    public void navigateToBoilersAndHeatingPage() {
        verifyAndClickWithLinkText(pageProperties.getProperty("ProductAndServicesPage.BoilersAndHeating"), "Boilers & Heating");
    }
}