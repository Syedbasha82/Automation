package bg.framework.app.functional.page.sales;

import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;


import java.util.Properties;





public class OnlineVariableAugustPage extends AZTariffPage {
    private final static String FILE_NAME = "resources/sales/OnlineVariableAugust2013Page.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    
    public void navigateToDualAcquisitionPage() {
        
    	if (browser.isElementVisible(pageProperties.getProperty("OnlineVariableAugust2013Page.GasElecSwitchNow"))) {
    		 //browser.clickWithXpath("//*[contains(@id,'gaselectricityaddon1')]");
    		browser.click(pageProperties.getProperty("OnlineVariableAugust2013Page.GasElecSwitchNow"));
            Report.updateTestLog("Dual Order button for OnlineVariableAugust2013 is clicked successfully", "PASS");
        } else if (browser.isElementVisibleWithXpath(pageProperties.getProperty("OnlineVariableAugust2013Page.GasElecSwitchNowF1"))) {
        	//browser.clickWithXpath("//*[contains(@id,'gaselectricityaddon1')]");
        	browser.clickWithXpath(pageProperties.getProperty("OnlineVariableAugust2013Page.GasElecSwitchNowF1"));
            Report.updateTestLog("Dual Order button for OnlineVariableAugust2013 is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Dual Order button for OnlineVariableAugust2013 is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToGasAcquisitionPage() {
        if (browser.isElementVisible(pageProperties.getProperty("OnlineVariableAugust2013Page.GasOnlySwitchNow"))) {
        	//browser.clickWithXpath("//*[contains(@id,'gasonlyaddon1')]");
        	browser.click(pageProperties.getProperty("OnlineVariableAugust2013Page.GasOnlySwitchNow"));
            Report.updateTestLog("Gas Order button for OnlineVariableAugust2013 Tariff is clicked successfully", "PASS");
        } else if (browser.isElementVisibleWithXpath(pageProperties.getProperty("OnlineVariableAugust2013Page.GasOnlySwitchNowF1"))) {
        	//browser.clickWithXpath("//*[contains(@id,'gasonlyaddon1')]");
        	browser.clickWithXpath(pageProperties.getProperty("OnlineVariableAugust2013Page.GasOnlySwitchNowF1"));
            Report.updateTestLog("Gas Order button for OnlineVariableAugust2013 is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Gas Order button for OnlineVariableAugust2013 Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToElecAcquisitionPage() {
        if (browser.isElementVisible(pageProperties.getProperty("OnlineVariableAugust2013Page.ElecOnlySwitchNow"))) {
        	//browser.clickWithXpath("//*[contains(@id,'electricityonlyaddon1')]");
            browser.click(pageProperties.getProperty("OnlineVariableAugust2013Page.ElecOnlySwitchNow"));
            Report.updateTestLog("Electricity Order button for OnlineVariableAugust2013 Tariff is clicked successfully", "PASS");
        } else if (browser.isElementVisibleWithXpath(pageProperties.getProperty("OnlineVariableAugust2013Page.ElecOnlySwitchNowF1"))) {
        	//browser.clickWithXpath("//*[contains(@id,'electricityonlyaddon1')]");
        	browser.clickWithXpath(pageProperties.getProperty("OnlineVariableAugust2013Page.ElecOnlySwitchNowF1"));
            Report.updateTestLog("Electricity Order button for OnlineVariableAugust2013 is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Electricity Order button for OnlineVariableAugust2013 Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToEnergySmartGasOrderPage() {
        if (browser.isElementVisible(pageProperties.getProperty("OnlineVariableAugust2013Page.EmergySmartAddonGas"))) {
            browser.click(pageProperties.getProperty("OnlineVariableAugust2013Page.EmergySmartAddonGas"));
            Report.updateTestLog("Energy Smart Addon is selected successfully for Gas", "PASS");
        } else {
            Report.updateTestLog("Energy Smart Addon is not selected successfully for Gas", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("OnlineVariableAugust2013Page.GasOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("OnlineVariableAugust2013Page.GasOnlySwitchNow"));
            Report.updateTestLog("Gas Order button for Energy Smart Addon is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Gas Order button for Energy Smart Addon is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToEnergySmartElectricityOrderPage() {
        if (browser.isElementVisible(pageProperties.getProperty("OnlineVariableAugust2013Page.EmergySmartAddonElec"))) {
            browser.click((pageProperties.getProperty("OnlineVariableAugust2013Page.EmergySmartAddonElec")));
            Report.updateTestLog(" Energy Smart Addon is selected successfully for Elec", "PASS");
        } else {
            Report.updateTestLog("Energy Smart Addon is not selected successfully for Elec", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("OnlineVariableAugust2013Page.ElecOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("OnlineVariableAugust2013Page.ElecOnlySwitchNow"));
            Report.updateTestLog("Electricity Order button for Energy Smart Addon  is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Electricity Order button for Energy Smart Addon  is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToEnergySmartDualOrderPage() {
        if (browser.isElementVisible(pageProperties.getProperty("OnlineVariableAugust2013Page.EmergySmartAddonDual"))) {
            browser.click((pageProperties.getProperty("OnlineVariableAugust2013Page.EmergySmartAddonDual")));
            Report.updateTestLog(" Energy Smart Addon is selected successfully for Dual", "PASS");
        } else {
            Report.updateTestLog("Energy Smart Addon is not selected successfully for Dual", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("OnlineVariableAugust2013Page.GasElecSwitchNow"))) {
            browser.click(pageProperties.getProperty("OnlineVariableAugust2013Page.GasElecSwitchNow"));
            Report.updateTestLog("Dual Order button for Energy Smart Addon  clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Dual Order button for Energy Smart Addon  is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    
}

