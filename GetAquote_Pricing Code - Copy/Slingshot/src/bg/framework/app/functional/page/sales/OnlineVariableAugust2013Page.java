package bg.framework.app.functional.page.sales;

import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

import java.util.List;
import java.util.Properties;

//import sun.plugin.extension.NativeExtensionInstaller;


/* Function  : Standard
   Created by: kathir
   Created On: 26-12-2011
   Description: Function which contains all the methods related to Price Finder Page
                Scenarios like Anonymous Journey,OAM Journey and Negative Scenarios Covered
 */
public class OnlineVariableAugust2013Page extends AZTariffPage {
    private final static String FILE_NAME = "resources/sales/StandardTariffPage.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    public void fillTariffDetails() {
        String tariff = "Standard";
        browser.wait(getWaitTime());
        //verifyAndClickWithXpath(pageProperties.getProperty("Standard.ShowUnitRates"),"Unit Rates Page");
        verifyAndClickWithLinkText(tariff + " tariff rates", "Unit rates");
        browser.wait(3000);
        String postcode;
        List<String> energyType = browser.getFromDropBox("id", pageProperties.getProperty("Standard.fuelType"));
        for (int y = 0; y < energyType.size(); y++) {
            verifyAndSelectDropDownBox(pageProperties.getProperty("Standard.fuelType"), "Fuel Type", energyType.get(y));
            for (int i = 0; i < getRegions().length; i++) {
                postcode = getPostcode(i);
                if (browser.isElementVisible(pageProperties.getProperty("Standard.postcode"))) {
                    browser.clearValue(pageProperties.getProperty("Standard.postcode"));
                    browser.input(pageProperties.getProperty("Standard.postcode"), postcode);
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Standard.submit"))) {
                    browser.wait(getWaitTime());
                    browser.clickWithXpath(pageProperties.getProperty("Standard.submit"));
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty(tariff + ".CashCardPath"))) {
                    verifyCashCard(energyType.get(y), tariff, getRegions()[i], postcode);
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty(tariff + ".DirectDebitPath"))) {
                    verifyDirectDebit(energyType.get(y), tariff, getRegions()[i], postcode);
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty(tariff + ".PrepaymentPath"))) {
                    verifyPrePayment(energyType.get(y), tariff, getRegions()[i], postcode);
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty(tariff + ".Monthly"))) {
                    verifyAveragePrice(energyType.get(y), tariff, getRegions()[i]);
                }
            }
        }
    }

    public void navigateToEnergyShop() {
        //do navigation click here
    }

    public void navigateToDualAcquisitionPage() {
        if (browser.isElementVisible(pageProperties.getProperty("Standard.GasElecSwitchNow"))) {
            browser.click(pageProperties.getProperty("Standard.GasElecSwitchNow"));
            Report.updateTestLog("Dual Order button for Standard is clicked successfully", "PASS");
        } else if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Standard.GasOnlySwitchNowF1"))) {
            browser.clickWithXpath(pageProperties.getProperty("Standard.GasOnlySwitchNowF1"));
            Report.updateTestLog("Dual Order button for Standard is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Dual Order button for Standard is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToGasAcquisitionPage() {
        if (browser.isElementVisible(pageProperties.getProperty("Standard.GasOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("Standard.GasOnlySwitchNow"));
            Report.updateTestLog("Gas Order button for Standard Tariff is clicked successfully", "PASS");
        } else if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Standard.GasElecSwitchNowF1"))) {
            browser.clickWithXpath(pageProperties.getProperty("Standard.GasElecSwitchNowF1"));
            Report.updateTestLog("Gas Order button for Standard is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Gas Order button for Standard Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToElecAcquisitionPage() {
        if (browser.isElementVisible(pageProperties.getProperty("Standard.ElecOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("Standard.ElecOnlySwitchNow"));
            Report.updateTestLog("Electricity Order button for Standard Tariff is clicked successfully", "PASS");
        } else if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Standard.ElecOnlySwitchNowF1"))) {
            browser.clickWithXpath(pageProperties.getProperty("Standard.ElecOnlySwitchNowF1"));
            Report.updateTestLog("Electricity Order button for Standard is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Electricity Order button for Standard Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToEnergySmartGasOrderPage() {
        if (browser.isElementVisible(pageProperties.getProperty("Standard.EmergySmartAddonGas"))) {
            browser.click(pageProperties.getProperty("Standard.EmergySmartAddonGas"));
            Report.updateTestLog("Energy Smart Addon is selected successfully for Gas", "PASS");
        } else {
            Report.updateTestLog("Energy Smart Addon is not selected successfully for Gas", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("Standard.GasOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("Standard.GasOnlySwitchNow"));
            Report.updateTestLog("Gas Order button for Standard Tariff is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Gas Order button for Standard Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToEnergySmartElectricityOrderPage() {
        if (browser.isElementVisible(pageProperties.getProperty("Standard.EmergySmartAddonElec"))) {
            browser.click((pageProperties.getProperty("Standard.EmergySmartAddonElec")));
            Report.updateTestLog(" Energy Smart Addon is selected successfully for Elec", "PASS");
        } else {
            Report.updateTestLog("Energy Smart Addon is not selected successfully for Elec", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("Standard.ElecOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("Standard.ElecOnlySwitchNow"));
            Report.updateTestLog("Electricity Order button for Standard Tariff is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Electricity Order button for Standard Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToEnergySmartDualOrderPage() {
        if (browser.isElementVisible(pageProperties.getProperty("Standard.EmergySmartAddonDual"))) {
            browser.click((pageProperties.getProperty("Standard.EmergySmartAddonDual")));
            Report.updateTestLog(" Energy Smart Addon is selected successfully for Dual", "PASS");
        } else {
            Report.updateTestLog("Energy Smart Addon is not selected successfully for Dual", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("Standard.GasElecSwitchNow"))) {
            browser.click(pageProperties.getProperty("Standard.GasElecSwitchNow"));
            Report.updateTestLog("Dual Order button for Standard is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Dual Order button for Standard is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToOurTariffPage() {

        if (browser.isTextPresent(pageProperties.getProperty("Standard.OurTariffPage"))) {
            browser.clickWithLinkText(pageProperties.getProperty("Standard.OurTariffPage"));

            Report.updateTestLog("Navigate to A-Z tariff page", "PASS");
        } else {

            Report.updateTestLog("Navigate to A-Z tariff page", "FAIL");
        }
        browser.wait(getWaitTime());
    }
}

