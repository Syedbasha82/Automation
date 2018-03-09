package bg.framework.app.functional.page.sales;

import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

import java.util.List;
import java.util.Properties;

public class FixedPriceJune2013TariffPage extends AZTariffPage {
    private final static String FILE_NAME = "resources/sales/FixedPriceJune2013TariffPage.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    public void fillTariffDetails() {
        String tariff = "Fixed Price June 2013";
        browser.wait(getWaitTime());
        //verifyAndClickWithXpath(pageProperties.getProperty("FixedPriceJune2013TariffPage.ShowUnitRates"),"Unit Rates Page");
        verifyAndClickWithLinkText(tariff + " rates", "Unit rates");
        browser.wait(4000);
        String postcode;

        List<String> energyType = browser.getFromDropBox("id", pageProperties.getProperty("FixedPriceJune2013Page.fuelType"));
        for (int y = 0; y < energyType.size(); y++) {
            browser.selectfromDropBox("id", pageProperties.getProperty("FixedPriceJune2013Page.fuelType"), energyType.get(y));
            for (int i = 0; i < getRegions().length; i++) {
                postcode = getPostcode(i);
                if (browser.isElementVisible(pageProperties.getProperty("FixedPriceJune2013Page.postcode"))) {
                    browser.clearValue(pageProperties.getProperty("FixedPriceJune2013Page.postcode"));
                    browser.input(pageProperties.getProperty("FixedPriceJune2013Page.postcode"), postcode);
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("FixedPriceJune2013Page.submit"))) {
                    browser.wait(getWaitTime());

                    browser.clickWithXpath(pageProperties.getProperty("FixedPriceJune2013Page.submit"));
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("FixedPriceJune2013Page.CashCardPath"))) {
                    verifyCashCard(energyType.get(y), tariff, getRegions()[i], postcode);
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("FixedPriceJune2013Page.DirectDebitPath"))) {
                    verifyDirectDebit(energyType.get(y), tariff, getRegions()[i], postcode);
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("FixedPriceJune2013Page.PrepaymentPath"))) {
                    verifyPrePayment(energyType.get(y), tariff, getRegions()[i], postcode);
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("FixedPriceJune2013Page.Monthly"))) {
                    verifyAveragePrice(energyType.get(y), tariff, getRegions()[i]);
                }
            }
        }
    }


    public void navigateToDualAcquisitionPage() {
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("FixedPriceJune2013Page.GasElecSwitchNow"))) {
            browser.clickWithXpath(pageProperties.getProperty("FixedPriceJune2013Page.GasElecSwitchNow"));
            Report.updateTestLog("Dual Order button is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Dual Order button is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToGasAcquisitionPage() {
        if (browser.isElementVisible(pageProperties.getProperty("FixedPriceJune2013Page.GasOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("FixedPriceJune2013Page.GasOnlySwitchNow"));
            Report.updateTestLog("Gas Order button is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Gas Order button is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToElecAcquisitionPage() {
        if (browser.isElementVisible(pageProperties.getProperty("FixedPriceJune2013Page.ElecOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("FixedPriceJune2013Page.ElecOnlySwitchNow"));
            Report.updateTestLog("Elec Order button is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Elec Order button is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }


    public void navigateToOurTariffPage() {

        if (browser.isTextPresent(pageProperties.getProperty("FixedPriceJune2013Page.OurTariffPage"))) {
            browser.clickWithLinkText(pageProperties.getProperty("FixedPriceJune2013Page.OurTariffPage"));

            Report.updateTestLog("Navigate to A-Z tariff page", "PASS");
        } else {

            Report.updateTestLog("Navigate to A-Z tariff page", "FAIL");
        }
        browser.wait(getWaitTime());
    }
    
    public void navigateToEnergySmartGasOrderPage() {
        if (browser.isElementVisible(pageProperties.getProperty("FixedPriceJune2013Page.EmergySmartAddonGas"))) {
            browser.click(pageProperties.getProperty("FixedPriceJune2013Page.EmergySmartAddonGas"));
            Report.updateTestLog("Energy Smart Addon is selected successfully for Gas", "PASS");
        } else {
            Report.updateTestLog("Energy Smart Addon is not selected successfully for Gas", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("FixedPriceJune2013Page.GasOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("FixedPriceJune2013Page.GasOnlySwitchNow"));
            Report.updateTestLog("Gas Order button for Fixed Price Tariff is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Gas Order button for Fixed Price Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToEnergySmartElectricityOrderPage() {
        if (browser.isElementVisible(pageProperties.getProperty("FixedPriceJune2013Page.EmergySmartAddonElec"))) {
            browser.click((pageProperties.getProperty("FixedPriceJune2013Page.EmergySmartAddonElec")));
            Report.updateTestLog(" Energy Smart Addon is selected successfully for Elec", "PASS");
        } else {
            Report.updateTestLog("Energy Smart Addon is not selected successfully for Elec", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("FixedPriceJune2013Page.ElecOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("FixedPriceJune2013Page.ElecOnlySwitchNow"));
            Report.updateTestLog("Electricity Order button for Fixed Price Tariff is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Electricity Order button for Fixed Price Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToEnergySmartDualOrderPage() {
        if (browser.isElementVisible(pageProperties.getProperty("FixedPriceJune2013Page.EmergySmartAddonDual"))) {
            browser.click((pageProperties.getProperty("FixedPriceJune2013Page.EmergySmartAddonDual")));
            Report.updateTestLog(" Energy Smart Addon is selected successfully for Dual", "PASS");
        } else {
            Report.updateTestLog("Energy Smart Addon is not selected successfully for Dual", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("FixedPriceJune2013Page.GasElecSwitchNow"))) {
            browser.click(pageProperties.getProperty("FixedPriceJune2013Page.GasElecSwitchNow"));
            Report.updateTestLog("Dual Order button for Fixed Price is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Dual Order button for Fixed Price is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    
    
    
}


