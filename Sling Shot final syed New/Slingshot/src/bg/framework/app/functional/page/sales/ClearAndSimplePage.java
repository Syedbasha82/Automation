package bg.framework.app.functional.page.sales;

import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;


import java.util.Properties;


public class ClearAndSimplePage extends AZTariffPage {
    private final static String FILE_NAME = "resources/sales/ClearAndSimplePage.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();


    public void navigateToDualAcquisitionPage() {
        if (browser.isElementVisible(pageProperties.getProperty("ClearAndSimplePage.GasElecSwitchNow"))) {
            browser.click(pageProperties.getProperty("ClearAndSimplePage.GasElecSwitchNow"));
            Report.updateTestLog("Dual Order button for ClearAndSimplePage is clicked successfully", "PASS");
        } else if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ClearAndSimplePage.GasElecSwitchNowF1"))) {
            browser.clickWithXpath(pageProperties.getProperty("ClearAndSimplePage.GasElecSwitchNowF1"));
            Report.updateTestLog("Dual Order button for ClearAndSimplePage is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Dual Order button for ClearAndSimplePage is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToGasAcquisitionPage() {
        if (browser.isElementVisible(pageProperties.getProperty("ClearAndSimplePage.GasOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("ClearAndSimplePage.GasOnlySwitchNow"));
            Report.updateTestLog("Gas Order button for ClearAndSimplePage Tariff is clicked successfully", "PASS");
        } else if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ClearAndSimplePage.GasOnlySwitchNowF1"))) {
            browser.clickWithXpath(pageProperties.getProperty("ClearAndSimplePage.GasOnlySwitchNowF1"));
            Report.updateTestLog("Gas Order button for ClearAndSimplePage is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Gas Order button for ClearAndSimplePage Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToElecAcquisitionPage() {
        if (browser.isElementVisible(pageProperties.getProperty("ClearAndSimplePage.ElecOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("ClearAndSimplePage.ElecOnlySwitchNow"));
            Report.updateTestLog("Electricity Order button for ClearAndSimplePage Tariff is clicked successfully", "PASS");
        } else if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ClearAndSimplePage.ElecOnlySwitchNowF1"))) {
            browser.clickWithXpath(pageProperties.getProperty("ClearAndSimplePage.ElecOnlySwitchNowF1"));
            Report.updateTestLog("Electricity Order button for ClearAndSimplePage is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Electricity Order button for ClearAndSimplePage Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToEnergySmartGasOrderPage() {
        if (browser.isElementVisible(pageProperties.getProperty("ClearAndSimplePage.EmergySmartAddonGas"))) {
            browser.click(pageProperties.getProperty("ClearAndSimplePage.EmergySmartAddonGas"));
            Report.updateTestLog("Energy Smart Addon is selected successfully for Gas", "PASS");
        } else {
            Report.updateTestLog("Energy Smart Addon is not selected successfully for Gas", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("ClearAndSimplePage.GasOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("ClearAndSimplePage.GasOnlySwitchNow"));
            Report.updateTestLog("Gas Order button for ClearAndSimplePage Tariff is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Gas Order button for ClearAndSimplePage Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToEnergySmartElectricityOrderPage() {
        if (browser.isElementVisible(pageProperties.getProperty("ClearAndSimplePage.EmergySmartAddonElec"))) {
            browser.click((pageProperties.getProperty("ClearAndSimplePage.EmergySmartAddonElec")));
            Report.updateTestLog(" Energy Smart Addon is selected successfully for Elec", "PASS");
        } else {
            Report.updateTestLog("Energy Smart Addon is not selected successfully for Elec", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("ClearAndSimplePage.ElecOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("ClearAndSimplePage.ElecOnlySwitchNow"));
            Report.updateTestLog("Electricity Order button for ClearAndSimplePage Tariff is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Electricity Order button for ClearAndSimplePage Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToEnergySmartDualOrderPage() {
        if (browser.isElementVisible(pageProperties.getProperty("ClearAndSimplePage.EmergySmartAddonDual"))) {
            browser.click((pageProperties.getProperty("ClearAndSimplePage.EmergySmartAddonDual")));
            Report.updateTestLog(" Energy Smart Addon is selected successfully for Dual", "PASS");
        } else {
            Report.updateTestLog("Energy Smart Addon is not selected successfully for Dual", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("ClearAndSimplePage.GasElecSwitchNow"))) {
            browser.click(pageProperties.getProperty("ClearAndSimplePage.GasElecSwitchNow"));
            Report.updateTestLog("Dual Order button for ClearAndSimplePage is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Dual Order button for ClearAndSimplePage is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

   
}

