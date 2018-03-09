package bg.framework.app.functional.page.sales;

import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

//import sun.plugin.extension.NativeExtensionInstaller;


/* Function  : EnergySharePage
   Created by: kathir
   Created On: 26-12-2011
   Description: Function which contains all the methods related to Price Finder Page
                Scenarios like Anonymous Journey,OAM Journey and Negative Scenarios Covered
 */
public class EnergyShareTariffPage extends AZTariffPage {
    private final static String FILE_NAME = "resources/sales/EnergyShareTariffPage.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    public void fillTariffDetails() {
        String tariff = "Energyshare";
        browser.wait(getWaitTime());
        //verifyAndClickWithXpath(pageProperties.getProperty("EnergySharePage.ShowUnitRates"),"Unit Rates Page");
        verifyAndClickWithLinkText("energyshare tariff rates", "Unit rates");
        browser.wait(4000);
        String postcode;

        List<String> energyType = browser.getFromDropBox("id", pageProperties.getProperty("EnergySharePage.fuelType"));
        for (int y = 0; y < energyType.size(); y++) {
            browser.selectfromDropBox("id", pageProperties.getProperty("EnergySharePage.fuelType"), energyType.get(y));
            String meter2[] = {"Gas", "Elec", "Elec"};
            if (energyType.size() == 2) {
                meter2 = Arrays.copyOfRange(meter2, meter2.length - 2, meter2.length);
            }
            System.out.println("meter 2 " + meter2[0]);
            System.out.println("meter 2 " + meter2[1]);
            for (int i = 0; i < getRegions().length; i++) {
                postcode = getPostcode(i);
                if (browser.isElementVisible(pageProperties.getProperty("EnergySharePage.postcode"))) {
                    browser.clearValue(pageProperties.getProperty("EnergySharePage.postcode"));
                    browser.input(pageProperties.getProperty("EnergySharePage.postcode"), postcode);
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("EnergySharePage.submit"))) {
                    browser.wait(getWaitTime());
                    browser.clickWithXpath(pageProperties.getProperty("EnergySharePage.submit"));
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("EnergySharePage.CashCardPath"))) {
                    if (browser.isTextPresent("Cash/Card"))
                        verifyCashCard(energyType.get(y), tariff, getRegions()[i], postcode);
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("EnergySharePage.DirectDebitPath"))) {
                    verifyDirectDebit(energyType.get(y), tariff, getRegions()[i], postcode);
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("EnergySharePage.PrepaymentPath"))) {
                    verifyPrePayment(energyType.get(y), tariff, getRegions()[i], postcode);
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("EnergySharePage.Monthly"))) {
                    verifyAveragePrice(energyType.get(y), tariff, getRegions()[i]);
                }
            }
        }
    }


    private String getElementStringValue(Element parent, String element) {
        NodeList nl = parent.getElementsByTagName(element);
        if (nl.getLength() == 0) {
            return element;
        }
        Node n = nl.item(0).getFirstChild();
        if (n == null) {
            return element;
        }
        return n.getNodeValue();
    }


    public void navigateToEnergyShop() {
        //do navigation click here

    }

    public void navigateToDualAcquisitionPage() {
        if (browser.isElementVisible(pageProperties.getProperty("StandardTariffPage.GasElecSwitchNow"))) {
            browser.click(pageProperties.getProperty("StandardTariffPage.GasElecSwitchNow"));
            Report.updateTestLog("Dual Order button for Standard is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Dual Order button for Standard is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToGasAcquisitionPage() {
        if (browser.isElementVisible(pageProperties.getProperty("StandardTariffPage.GasOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("StandardTariffPage.GasOnlySwitchNow"));
            Report.updateTestLog("Gas Order button for Standard Tariff is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Gas Order button for Standard Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToElecAcquisitionPage() {
    	if (browser.isTextPresent(pageProperties.getProperty("EnergySharePage.SwitchNowLink"))) {
            browser.clickWithLinkText(pageProperties.getProperty("EnergySharePage.SwitchNowLink"));
            Report.updateTestLog("Electricity Order button for EnergySharePage Tariff is clicked successfully ", "PASS");
        } else {

            Report.updateTestLog("Electricity Order button for StaEnergySharePagendard Tariff is clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToEnergySmartGasOrderPage() {
        if (browser.isElementVisible(pageProperties.getProperty("StandardTariffPage.EmergySmartAddonGas"))) {
            browser.click(pageProperties.getProperty("StandardTariffPage.EmergySmartAddonGas"));
            Report.updateTestLog("Energy Smart Addon is selected successfully for Gas", "PASS");
        } else {
            Report.updateTestLog("Energy Smart Addon is not selected successfully for Gas", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("StandardTariffPage.GasOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("StandardTariffPage.GasOnlySwitchNow"));
            Report.updateTestLog("Gas Order button for Standard Tariff is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Gas Order button for Standard Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToEnergySmartElectricityOrderPage() {
        if (browser.isElementVisible(pageProperties.getProperty("StandardTariffPage.EmergySmartAddonElec"))) {
            browser.click((pageProperties.getProperty("StandardTariffPage.EmergySmartAddonElec")));
            Report.updateTestLog(" Energy Smart Addon is selected successfully for Elec", "PASS");
        } else {
            Report.updateTestLog("Energy Smart Addon is not selected successfully for Elec", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("StandardTariffPage.ElecOnlySwitchNow"))) {
            browser.click(pageProperties.getProperty("StandardTariffPage.ElecOnlySwitchNow"));
            Report.updateTestLog("Electricity Order button for Standard Tariff is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Electricity Order button for Standard Tariff is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToEnergySmartDualOrderPage() {
        if (browser.isElementVisible(pageProperties.getProperty("StandardTariffPage.EmergySmartAddonDual"))) {
            browser.click((pageProperties.getProperty("StandardTariffPage.EmergySmartAddonDual")));
            Report.updateTestLog(" Energy Smart Addon is selected successfully for Dual", "PASS");
        } else {
            Report.updateTestLog("Energy Smart Addon is not selected successfully for Dual", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("StandardTariffPage.GasElecSwitchNow"))) {
            browser.click(pageProperties.getProperty("StandardTariffPage.GasElecSwitchNow"));
            Report.updateTestLog("Dual Order button for Standard is clicked successfully", "PASS");
        } else {
            Report.updateTestLog("Dual Order button for Standard is not clicked successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToOurTariffPage() {

        if (browser.isTextPresent(pageProperties.getProperty("EnergySharePage.OurTariffPage"))) {
            browser.clickWithLinkText(pageProperties.getProperty("EnergySharePage.OurTariffPage"));

            Report.updateTestLog("Navigate to A-Z tariff page", "PASS");
        } else {

            Report.updateTestLog("Navigate to A-Z tariff page", "FAIL");
        }
        browser.wait(getWaitTime());
    }

}

