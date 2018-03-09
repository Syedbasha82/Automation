package bg.framework.app.functional.page.sales;

import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: !boobalas
 * Date: 13/03/12
 * Time: 05:30
 * To change this template use File | Settings | File Templates.
 */
public class EnergySmartTariffPage extends BasePage {


    private final static String FILE_NAME = "resources/sales/GasAndElectricityPage.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    public void clickAddEnergySmartPageDual() {
        clickAddEnergySmartPage();
        if (browser.isElementVisible(pageProperties.getProperty("GasAndElectricityPage.dual"))) {
            browser.click(pageProperties.getProperty("GasAndElectricityPage.dual"));
            Report.updateTestLog("Fuel Type selected is Dual ", "PASS");
        } else {
            Report.updateTestLog("Fuel Type selected is Dual", "FAIL");
        }

    }

    public void clickAddEnergySmartPageGas() {
        clickAddEnergySmartPage();
        if (browser.isElementVisible(pageProperties.getProperty("GasAndElectricityPage.Gas"))) {
            browser.click(pageProperties.getProperty("GasAndElectricityPage.Gas"));
            Report.updateTestLog("Fuel Type selected is Dual ", "PASS");
        } else {
            Report.updateTestLog("Fuel Type selected is Dual ", "FAIL");
        }
    }

    public void clickAddEnergySmartPageElec() {

        clickAddEnergySmartPage();

        if (browser.isElementVisible(pageProperties.getProperty("GasAndElectricityPage.Elec"))) {
            browser.click(pageProperties.getProperty("GasAndElectricityPage.Elec"));
            Report.updateTestLog("Fuel Type selected is Dual ", "PASS");
        } else {
            Report.updateTestLog("Fuel Type selected is Dual ", "FAIL");
        }
    }

    public void navigateToAnonyEnergySmartPage() {

       if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GasAndElectricityPage.EnergySmart"))) {
            browser.clickWithXpath(pageProperties.getProperty("GasAndElectricityPage.EnergySmart"));

            Report.updateTestLog("OurTariffs Link is clicked", "PASS");
        }
    	
    	
    	else {
            Report.updateTestLog("Our Tariffs Link is not clicked", "FAIL");
        }
        browser.wait(getWaitTime());
    }
    
    public void navigateToJoinBG() {

        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GasAndElectricityPage.JoinBG"))) {
             browser.clickWithXpath(pageProperties.getProperty("GasAndElectricityPage.JoinBG"));

             Report.updateTestLog("Join BG Link is clicked", "PASS");
         }
     	
     	
     	else {
             Report.updateTestLog("Join BG Link is not clicked", "FAIL");
         }
         browser.wait(getWaitTime());
     }

    public void clickAddEnergySmartPage() {

        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GasAndElectricityPage.AddEnergySmart"))) {
            browser.clickWithXpath(pageProperties.getProperty("GasAndElectricityPage.AddEnergySmart"));

            Report.updateTestLog("OurTariffs Link is clicked", "PASS");
        } else {
            Report.updateTestLog("Our Tariffs Link is not clicked", "FAIL");
        }
        browser.wait(getWaitTime());
    }

}
