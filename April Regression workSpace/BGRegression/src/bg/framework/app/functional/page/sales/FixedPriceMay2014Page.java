package bg.framework.app.functional.page.sales;

import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;


import java.util.Properties;


public class FixedPriceMay2014Page extends AZTariffPage {
    private final static String FILE_NAME = "resources/sales/FixedPriceMay2014Page.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

   
    public void navigateToDualAcquisitionPage() {
        if (browser.isElementVisible(pageProperties.getProperty("FixedPriceMay2014Page.GasElecSwitchNow"))) {
            browser.click(pageProperties.getProperty("FixedPriceMay2014Page.GasElecSwitchNow"));
            Report.updateTestLog("Dual Order button for FixedPriceMay2014 is clicked successfully", "PASS");
        } else if (browser.isElementVisibleWithXpath(pageProperties.getProperty("FixedPriceMay2014Page.GasElecSwitchNowF1"))) {
            browser.clickWithXpath(pageProperties.getProperty("FixedPriceMay2014Page.GasElecSwitchNowF1"));
            Report.updateTestLog("Dual Order button for FixedPriceMay2014 is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Dual Order button for FixedPriceMay2014 is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToGasAcquisitionPage() {
        if (browser.isElementVisible(pageProperties.getProperty("FixedPriceMay2014Page.GasOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("FixedPriceMay2014Page.GasOnlySwitchNow"));
            Report.updateTestLog("Gas Order button for FixedPriceMay2014 Tariff is clicked successfully", "PASS");
        } else if (browser.isElementVisibleWithXpath(pageProperties.getProperty("FixedPriceMay2014Page.GasOnlySwitchNowF1"))) {
            browser.clickWithXpath(pageProperties.getProperty("FixedPriceMay2014Page.GasOnlySwitchNowF1"));
            Report.updateTestLog("Gas Order button for FixedPriceMay2014 is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Gas Order button for FixedPriceMay2014 Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToElecAcquisitionPage() {
        if (browser.isElementVisible(pageProperties.getProperty("FixedPriceMay2014Page.ElecOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("FixedPriceMay2014Page.ElecOnlySwitchNow"));
            Report.updateTestLog("Electricity Order button for Standard Tariff is clicked successfully", "PASS");
        } else if (browser.isElementVisibleWithXpath(pageProperties.getProperty("FixedPriceMay2014Page.ElecOnlySwitchNowF1"))) {
            browser.clickWithXpath(pageProperties.getProperty("FixedPriceMay2014Page.ElecOnlySwitchNowF1"));
            Report.updateTestLog("Electricity Order button for FixedPriceMay2014 is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Electricity Order button for FixedPriceMay2014 Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToEnergySmartGasOrderPage() {
        if (browser.isElementVisible(pageProperties.getProperty("FixedPriceMay2014Page.EmergySmartAddonGas"))) {
            browser.click(pageProperties.getProperty("FixedPriceMay2014Page.EmergySmartAddonGas"));
            Report.updateTestLog("Energy Smart Addon is selected successfully for Gas", "PASS");
        } else {
            Report.updateTestLog("Energy Smart Addon is not selected successfully for Gas", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("FixedPriceMay2014Page.GasOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("FixedPriceMay2014Page.GasOnlySwitchNow"));
            Report.updateTestLog("Gas Order button for FixedPriceMay2014 Tariff is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Gas Order button for FixedPriceMay2014 Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToEnergySmartElectricityOrderPage() {
        if (browser.isElementVisible(pageProperties.getProperty("FixedPriceMay2014Page.EmergySmartAddonElec"))) {
            browser.click((pageProperties.getProperty("FixedPriceMay2014Page.EmergySmartAddonElec")));
            Report.updateTestLog(" Energy Smart Addon is selected successfully for Elec", "PASS");
        } else {
            Report.updateTestLog("Energy Smart Addon is not selected successfully for Elec", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("FixedPriceMay2014Page.ElecOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("FixedPriceMay2014Page.ElecOnlySwitchNow"));
            Report.updateTestLog("Electricity Order button for FixedPriceMay2014 Tariff is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Electricity Order button for FixedPriceMay2014 Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToEnergySmartDualOrderPage() {
        if (browser.isElementVisible(pageProperties.getProperty("FixedPriceMay2014Page.EmergySmartAddonDual"))) {
            browser.click((pageProperties.getProperty("FixedPriceMay2014Page.EmergySmartAddonDual")));
            Report.updateTestLog(" Energy Smart Addon is selected successfully for Dual", "PASS");
        } else {
            Report.updateTestLog("Energy Smart Addon is not selected successfully for Dual", "FAIL");
        }
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("FixedPriceMay2014Page.GasElecSwitchNow"))) {
            browser.clickWithXpath(pageProperties.getProperty("FixedPriceMay2014Page.GasElecSwitchNow"));
            Report.updateTestLog("Dual Order button for FixedPriceMay2014 is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Dual Order button for FixedPriceMay2014 is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    
}

