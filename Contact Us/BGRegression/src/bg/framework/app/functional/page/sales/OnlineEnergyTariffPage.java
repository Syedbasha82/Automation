package bg.framework.app.functional.page.sales;

import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

import java.util.List;
import java.util.Properties;

public class OnlineEnergyTariffPage extends AZTariffPage {
    private final static String FILE_NAME = "resources/sales/OnlineEnergyTariffPage.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    public void fillTariffDetails() {
        String tariff = "Online Energy";
        browser.wait(getWaitTime());
        //verifyAndClickWithXpath(pageProperties.getProperty("OnlineEnergyTariffPage.ShowUnitRates"),"Unit Rates Page");

        verifyAndClickWithLinkText(tariff + " rates", "Unit rates");
        browser.wait(getWaitTime());
        String postcode;
        List<String> energyType = browser.getFromDropBox("id", pageProperties.getProperty("OnlineEnergyTariffPage.fuelType"));
        for (int y = 0; y < energyType.size(); y++) {
            browser.selectfromDropBox("id", pageProperties.getProperty("OnlineEnergyTariffPage.fuelType"), energyType.get(y));
            for (int i = 0; i < getRegions().length; i++) {
                postcode = getPostcode(i);
                if (browser.isElementVisible(pageProperties.getProperty("OnlineEnergyTariffPage.postcode"))) {
                    browser.clearValue(pageProperties.getProperty("OnlineEnergyTariffPage.postcode"));
                    browser.input(pageProperties.getProperty("OnlineEnergyTariffPage.postcode"), postcode);
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("OnlineEnergyTariffPage.submit"))) {
                    browser.wait(getWaitTime());

                    browser.clickWithXpath(pageProperties.getProperty("OnlineEnergyTariffPage.submit"));
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("OnlineEnergyTariffPage.CashCardPath"))) {
                    verifyCashCard(energyType.get(y), tariff, getRegions()[i], postcode);
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("OnlineEnergyTariffPage.DirectDebitPath"))) {
                    verifyDirectDebit(energyType.get(y), tariff, getRegions()[i], postcode);
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("OnlineEnergyTariffPage.PrepaymentPath"))) {
                    verifyPrePayment(energyType.get(y), tariff, getRegions()[i], postcode);
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("OnlineEnergyTariffPage.Monthly"))) {
                    verifyAveragePrice(energyType.get(y), tariff, getRegions()[i]);
                }
            }
        }
    }

    public void navigateToDualAcquisitionPage() {
        if (browser.isElementVisible(pageProperties.getProperty("OnlineEnergyTariffPage.GasElecSwitchNow"))) {
            browser.click(pageProperties.getProperty("OnlineEnergyTariffPage.GasElecSwitchNow"));
            Report.updateTestLog("Dual Order button for OnlineEnergy is clicked successfully", "PASS");
        } else if (browser.isElementVisibleWithXpath(pageProperties.getProperty("OnlineEnergyTariffPage.GasElecSwitchNowF1"))) {
            browser.clickWithXpath(pageProperties.getProperty("OnlineEnergyTariffPage.GasElecSwitchNowF1"));
            Report.updateTestLog("Dual Order button for OnlineEnergy Tariff is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Dual Order button for OnlineEnergy is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToGasAcquisitionPage() {
        if (browser.isElementVisible(pageProperties.getProperty("OnlineEnergyTariffPage.GasOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("OnlineEnergyTariffPage.GasOnlySwitchNow"));
            Report.updateTestLog("Gas Order button for OnlineEnergy Tariff is clicked successfully", "PASS");
        } else if (browser.isElementVisibleWithXpath(pageProperties.getProperty("OnlineEnergyTariffPage.GasOnlySwitchNowF1"))) {
            browser.clickWithXpath(pageProperties.getProperty("OnlineEnergyTariffPage.GasOnlySwitchNowF1"));
            Report.updateTestLog("Gas Order button for OnlineEnergy Tariff is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Gas Order button for OnlineEnergy Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToElecAcquisitionPage() {
        if (browser.isElementVisible(pageProperties.getProperty("OnlineEnergyTariffPage.ElecOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("OnlineEnergyTariffPage.ElecOnlySwitchNow"));
            Report.updateTestLog("Electricity Order button for OnlineEnergy Tariff is clicked successfully", "PASS");
        } else if (browser.isElementVisibleWithXpath(pageProperties.getProperty("OnlineEnergyTariffPage.ElecOnlySwitchNowF1"))) {
            browser.clickWithXpath(pageProperties.getProperty("OnlineEnergyTariffPage.ElecOnlySwitchNowF1"));
            Report.updateTestLog("Electricity button for OnlineEnergy Tariff is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Electricity Order button for OnlineEnergy Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToEnergySmartGasOrderPage() {
        if (browser.isElementVisible(pageProperties.getProperty("OnlineEnergyTariffPage.EmergySmartAddonGas"))) {
            browser.click(pageProperties.getProperty("OnlineEnergyTariffPage.EmergySmartAddonGas"));
            Report.updateTestLog("Energy Smart Addon is selected successfully for Gas", "PASS");
        } else {
            Report.updateTestLog("Energy Smart Addon is not selected successfully for Gas", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("OnlineEnergyTariffPage.GasOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("OnlineEnergyTariffPage.GasOnlySwitchNow"));
            Report.updateTestLog("Gas Order button for OnlineEnergy Tariff is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Gas Order button for OnlineEnergy Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToEnergySmartElectricityOrderPage() {
        if (browser.isElementVisible(pageProperties.getProperty("OnlineEnergyTariffPage.EmergySmartAddonElec"))) {
            browser.click((pageProperties.getProperty("OnlineEnergyTariffPage.EmergySmartAddonElec")));
            Report.updateTestLog(" Energy Smart Addon is selected successfully for Elec", "PASS");
        } else {
            Report.updateTestLog("Energy Smart Addon is not selected successfully for Elec", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("OnlineEnergyTariffPage.ElecOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("OnlineEnergyTariffPage.ElecOnlySwitchNow"));
            Report.updateTestLog("Electricity Order button for OnlineEnergy Tariff is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Electricity Order button for OnlineEnergy Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToEnergySmartDualOrderPage() {
        if (browser.isElementVisible(pageProperties.getProperty("OnlineEnergyTariffPage.EmergySmartAddonDual"))) {
            browser.click((pageProperties.getProperty("OnlineEnergyTariffPage.EmergySmartAddonDual")));
            Report.updateTestLog(" Energy Smart Addon is selected successfully for Dual", "PASS");
        } else {
            Report.updateTestLog("Energy Smart Addon is not selected successfully for Dual", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("OnlineEnergyTariffPage.GasElecSwitchNow"))) {
            browser.click(pageProperties.getProperty("OnlineEnergyTariffPage.GasElecSwitchNow"));
            Report.updateTestLog("Dual Order button for OnlineEnergy is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Dual Order button for OnlineEnergy is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToOurTariffPage() {
        if (browser.isTextPresent(pageProperties.getProperty("OnlineEnergyTariffPage.OurTariffPage"))) {
            browser.clickWithLinkText(pageProperties.getProperty("OnlineEnergyTariffPage.OurTariffPage"));

            Report.updateTestLog("Navigate to A-Z tariff page", "PASS");
        } else {

            Report.updateTestLog("Navigate to A-Z tariff page", "FAIL");
        }
        browser.wait(getWaitTime());
    }
}

