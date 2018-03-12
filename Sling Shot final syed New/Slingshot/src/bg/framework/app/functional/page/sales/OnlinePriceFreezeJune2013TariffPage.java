package bg.framework.app.functional.page.sales;

import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

import java.util.List;
import java.util.Properties;

public class OnlinePriceFreezeJune2013TariffPage extends AZTariffPage {
    private final static String FILE_NAME = "resources/sales/OnlinePriceFreezeJune2013TariffPage.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
    int stepName = 0;

    public void fillTariffDetails() {
        String tariff = "Online Price Freeze June 2013";
        verifyAndClickWithLinkText(tariff + " rates", "Unit rates");
        browser.wait(getWaitTime());
        String postcode;
        String meter2[] = {"Gas", "Elec", "Elec"};

        List<String> energyType = browser.getFromDropBox("id", pageProperties.getProperty("OnlinePriceFreezeJune2013TariffPage.fuelType"));
        for (int y = 0; y < energyType.size(); y++) {
            browser.selectfromDropBox("id", pageProperties.getProperty("OnlinePriceFreezeJune2013TariffPage.fuelType"), energyType.get(y));
            for (int i = 0; i < getRegions().length; i++) {
                postcode = getPostcode(i);
                if (browser.isElementVisible(pageProperties.getProperty("OnlinePriceFreezeJune2013TariffPage.postcode"))) {
                    browser.clearValue(pageProperties.getProperty("OnlinePriceFreezeJune2013TariffPage.postcode"));
                    browser.input(pageProperties.getProperty("OnlinePriceFreezeJune2013TariffPage.postcode"), postcode);
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("OnlinePriceFreezeJune2013TariffPage.submit"))) {
                    browser.wait(getWaitTime());

                    browser.clickWithXpath(pageProperties.getProperty("OnlinePriceFreezeJune2013TariffPage.submit"));
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("OnlinePriceFreezeJune2013TariffPage.CashCardPath"))) {

                    verifyCashCard(energyType.get(y), tariff, getRegions()[i], postcode);
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("OnlinePriceFreezeJune2013TariffPage.DirectDebitPath"))) {

                    verifyDirectDebit(energyType.get(y), tariff, getRegions()[i], postcode);
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("OnlinePriceFreezeJune2013TariffPage.PrepaymentPath"))) {

                    verifyPrePayment(energyType.get(y), tariff, getRegions()[i], postcode);
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("OnlinePriceFreezeJune2013TariffPage.Monthly"))) {

                    verifyAveragePrice(energyType.get(y), tariff, getRegions()[i]);
                }
            }
        }

    }

    public void navigateToDualAcquisitionPage() {
        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.GasElecSwitchNow"))) {
            browser.click(pageProperties.getProperty("Acquisition.GasElecSwitchNow"));
            Report.updateTestLog("Order button is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Order button is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToGasAcquisitionPage() {
        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.GasOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("Acquisition.GasOnlySwitchNow"));
            Report.updateTestLog("Order button is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Order button is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToElecAcquisitionPage() {
        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.ElecOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("Acquisition.ElecOnlySwitchNow"));
            Report.updateTestLog("Order button is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Order button is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    private static double ceilDouble(String value) {
        double dbl = Double.parseDouble(value);
// DecimalFormat formatter = new DecimalFormat(format);
//return  formatter.format(dbl);
        return dbl;
    }

    public void navigateToOurTariffPage() {

        if (browser.isTextPresent(pageProperties.getProperty("OnlinePriceFreezeJune2013TariffPage.OurTariffPage"))) {
            browser.clickWithLinkText(pageProperties.getProperty("OnlinePriceFreezeJune2013TariffPage.OurTariffPage"));

            Report.updateTestLog("Navigate to A-Z tariff page", "PASS");
        } else {

            Report.updateTestLog("Navigate to A-Z tariff page", "FAIL");
        }
        browser.wait(getWaitTime());
    }

}

