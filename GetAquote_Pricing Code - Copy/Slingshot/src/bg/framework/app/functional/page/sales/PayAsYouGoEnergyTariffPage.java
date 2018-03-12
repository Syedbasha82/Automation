package bg.framework.app.functional.page.sales;

import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

import java.util.List;
import java.util.Properties;

/*  Class    : PayAsYouGoEnergyTariffPage
    Description: Class to Verify the Pay As You Go Energy Tariff Price Finder Journey
 */
public class PayAsYouGoEnergyTariffPage extends AZTariffPage {
    private final static String FILE_NAME = "resources/sales/PayAsYouGoTariffPage.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    public void fillTariffDetails() {
        String tariff = "Pay As You Go";
        browser.wait(getWaitTime());
        //verifyAndClickWithXpath(pageProperties.getProperty("PayAsYouGo.ShowUnitRates"),"Unit Rates Page");
        verifyAndClickWithLinkText(tariff + " Energy rates", "Unit rates");
        browser.wait(4000);
        String postcode;
        List<String> energyType = browser.getFromDropBox("id", pageProperties.getProperty("PayAsYouGo.fuelType"));
        for (int y = 0; y < energyType.size(); y++) {
            browser.selectfromDropBox("id", pageProperties.getProperty("PayAsYouGo.fuelType"), energyType.get(y));
            for (int i = 0; i < getRegions().length; i++) {
                postcode = getPostcode(i);
                if (browser.isElementVisible(pageProperties.getProperty("PayAsYouGo.postcode"))) {
                    browser.clearValue(pageProperties.getProperty("PayAsYouGo.postcode"));
                    browser.input(pageProperties.getProperty("PayAsYouGo.postcode"), postcode);
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("PayAsYouGo.submit"))) {
                    browser.wait(getWaitTime());
                    browser.clickWithXpath(pageProperties.getProperty("PayAsYouGo.submit"));
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("PayAsYouGo.submit"))) {
                    browser.wait(getWaitTime());

                    browser.clickWithXpath(pageProperties.getProperty("PayAsYouGo.submit"));
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("PayAsYouGo.CashCardPath"))) {
                    verifyCashCard(energyType.get(y), tariff, getRegions()[i], postcode);
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("PayAsYouGo.DirectDebitPath"))) {
                    verifyDirectDebit(energyType.get(y), tariff, getRegions()[i], postcode);
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("PayAsYouGo.PrepaymentPath"))) {
                    verifyPrePayment(energyType.get(y), tariff, getRegions()[i], postcode);
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("PayAsYouGo.Monthly"))) {
                    verifyAveragePrice(energyType.get(y), tariff, getRegions()[i]);
                }
            }
        }
    }

    public void navigateToOurTariffPage() {

        if (browser.isTextPresent(pageProperties.getProperty("PayAsYouGo.OurTariffPage"))) {
            browser.clickWithLinkText(pageProperties.getProperty("PayAsYouGo.OurTariffPage"));
            Report.updateTestLog("Navigate to A-Z tariff page", "PASS");
        } else {
            Report.updateTestLog("Navigate to A-Z tariff page", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToDualAcquisitionPage() {
        if (browser.isElementVisible(pageProperties.getProperty("PayAsYouGo.GasElecSwitchNow"))) {
            browser.click(pageProperties.getProperty("PayAsYouGo.GasElecSwitchNow"));
            Report.updateTestLog("Dual Order button for Standard is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Dual Order button for Standard is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToGasAcquisitionPage() {
        if (browser.isElementVisible(pageProperties.getProperty("PayAsYouGo.GasOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("PayAsYouGo.GasOnlySwitchNow"));
            Report.updateTestLog("Gas Order button for Standard Tariff is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Gas Order button for Standard Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToElecAcquisitionPage() {
        if (browser.isElementVisible(pageProperties.getProperty("PayAsYouGo.ElecOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("PayAsYouGo.ElecOnlySwitchNow"));
            Report.updateTestLog("Electricity Order button for Standard Tariff is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Electricity Order button for Standard Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

}


