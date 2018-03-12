package bg.framework.app.functional.page.sales;

import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;


import java.util.Properties;


public class DiscountVariableAugust2013Page extends AZTariffPage {
    private final static String FILE_NAME = "resources/sales/DiscountVariableAugust2013Page.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();


    public void navigateToDualAcquisitionPage() {
        if (browser.isElementVisible(pageProperties.getProperty("DiscountVariableAugust2013.GasElecSwitchNow"))) {
            browser.click(pageProperties.getProperty("DiscountVariableAugust2013.GasElecSwitchNow"));
            Report.updateTestLog("Dual Order button for DiscountVariableAugust2013 is clicked successfully", "PASS");
        } else if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Standard.GasOnlySwitchNowF1"))) {
            browser.clickWithXpath(pageProperties.getProperty("DiscountVariableAugust2013.GasOnlySwitchNowF1"));
            Report.updateTestLog("Dual Order button for DiscountVariableAugust2013 is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Dual Order button for DiscountVariableAugust2013 is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToGasAcquisitionPage() {
        if (browser.isElementVisible(pageProperties.getProperty("DiscountVariableAugust2013.GasOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("DiscountVariableAugust2013.GasOnlySwitchNow"));
            Report.updateTestLog("Gas Order button for DiscountVariableAugust2013 Tariff is clicked successfully", "PASS");
        } else if (browser.isElementVisibleWithXpath(pageProperties.getProperty("DiscountVariableAugust2013.GasElecSwitchNowF1"))) {
            browser.clickWithXpath(pageProperties.getProperty("DiscountVariableAugust2013.GasElecSwitchNowF1"));
            Report.updateTestLog("Gas Order button for DiscountVariableAugust2013 is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Gas Order button for DiscountVariableAugust2013 Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToElecAcquisitionPage() {
        if (browser.isElementVisible(pageProperties.getProperty("DiscountVariableAugust2013.ElecOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("DiscountVariableAugust2013.ElecOnlySwitchNow"));
            Report.updateTestLog("Electricity Order button for DiscountVariableAugust2013 Tariff is clicked successfully", "PASS");
        } else if (browser.isElementVisibleWithXpath(pageProperties.getProperty("DiscountVariableAugust2013.ElecOnlySwitchNowF1"))) {
            browser.clickWithXpath(pageProperties.getProperty("DiscountVariableAugust2013.ElecOnlySwitchNowF1"));
            Report.updateTestLog("Electricity Order button for DiscountVariableAugust2013 is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Electricity Order button for DiscountVariableAugust2013 Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToEnergySmartGasOrderPage() {
        if (browser.isElementVisible(pageProperties.getProperty("DiscountVariableAugust2013.EmergySmartAddonGas"))) {
            browser.click(pageProperties.getProperty("DiscountVariableAugust2013.EmergySmartAddonGas"));
            Report.updateTestLog("Energy Smart Addon is selected successfully for Gas", "PASS");
        } else {
            Report.updateTestLog("Energy Smart Addon is not selected successfully for Gas", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("DiscountVariableAugust2013.GasOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("DiscountVariableAugust2013.GasOnlySwitchNow"));
            Report.updateTestLog("Gas Order button for Standard Tariff is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Gas Order button for Standard Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToEnergySmartElectricityOrderPage() {
        if (browser.isElementVisible(pageProperties.getProperty("DiscountVariableAugust2013.EmergySmartAddonElec"))) {
            browser.click((pageProperties.getProperty("DiscountVariableAugust2013.EmergySmartAddonElec")));
            Report.updateTestLog(" Energy Smart Addon is selected successfully for Elec", "PASS");
        } else {
            Report.updateTestLog("Energy Smart Addon is not selected successfully for Elec", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("DiscountVariableAugust2013.ElecOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("DiscountVariableAugust2013.ElecOnlySwitchNow"));
            Report.updateTestLog("Electricity Order button for Standard Tariff is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Electricity Order button for Standard Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToEnergySmartDualOrderPage() {
        if (browser.isElementVisible(pageProperties.getProperty("DiscountVariableAugust2013.EmergySmartAddonDual"))) {
            browser.click((pageProperties.getProperty("DiscountVariableAugust2013.EmergySmartAddonDual")));
            Report.updateTestLog(" Energy Smart Addon is selected successfully for Dual", "PASS");
        } else {
            Report.updateTestLog("Energy Smart Addon is not selected successfully for Dual", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("DiscountVariableAugust2013.GasElecSwitchNow"))) {
            browser.click(pageProperties.getProperty("DiscountVariableAugust2013.GasElecSwitchNow"));
            Report.updateTestLog("Dual Order button for Standard is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Dual Order button for Standard is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

   
}

