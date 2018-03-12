package bg.framework.app.functional.page.sales;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.PriceFinder;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

import java.util.List;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 12/01/12
 * Time: 02:11
 * To change this template use File | Settings | File Templates.
 */
public class OurTariffsPage extends AZTariffPage {
    private final static String FILE_NAME = "resources/sales/OurTariffPage.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    public void navigateToAZTariffPage() {

        if (browser.isTextPresent(pageProperties.getProperty("OurTariffPage.AZTariff"))) {
            browser.clickWithLinkText(pageProperties.getProperty("OurTariffPage.AZTariff"));

            Report.updateTestLog("Navigate to A-Z tariff page", "PASS");
        } else {

            Report.updateTestLog("Navigate to A-Z tariff page", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToStandardTariffPage() {

        if (browser.isTextPresent(pageProperties.getProperty("OurTariffPage.StandardTariff"))) {
            browser.clickWithLinkText(pageProperties.getProperty("OurTariffPage.StandardTariff"));
            Report.updateTestLog("Navigate to Standard Tariff Page", "PASS");
        } else {

            Report.updateTestLog("Navigate to Standard Tariff Page", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToPAYGTariffPage() {
    	
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("OurTariffPage.PAYGTariff"))) {
            browser.clickWithXpath(pageProperties.getProperty("OurTariffPage.PAYGTariff"));
            Report.updateTestLog("Navigate to Pay as you go tariff page", "PASS");
        } else {

            Report.updateTestLog("Navigate to Pay as you go tariff page", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToFixedPriceJune2013TariffPage() {

        if (browser.isTextPresent(pageProperties.getProperty("OurTariffPage.FixedPriceTariff"))) {
            browser.clickWithLinkText(pageProperties.getProperty("OurTariffPage.FixedPriceTariff"));
            Report.updateTestLog("Navigate to FixedPrice June 2013 Tariff Page", "PASS");
        }else {

        	Report.updateTestLog("Navigate to FixedPrice June 2013 Tariff Page", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToOnlineEnergyTariffPage() {

        if (browser.isTextPresent(pageProperties.getProperty("OurTariffPage.OnlineEnergy"))) {
            browser.clickWithLinkText(pageProperties.getProperty("OurTariffPage.OnlineEnergy"));
            Report.updateTestLog("Navigate to Online Energy Tariff Page", "PASS");
        } else {

            Report.updateTestLog("Navigate to Online Energy Tariff Page", "FAIL");
        }

        browser.wait(getWaitTime());
    }

    public void navigateToEnergyShareTariffPage() {

        if (browser.isTextPresent(pageProperties.getProperty("OurTariffPage.EnergyShare"))) {
            browser.clickWithLinkText(pageProperties.getProperty("OurTariffPage.EnergyShare"));
            Report.updateTestLog("Navigate to Energy Share Tariff Page", "PASS");
        } else {

            Report.updateTestLog("Navigate to Energy Share Tariff Page", "FAIL");
        }

        browser.wait(getWaitTime());
    }
    
    public void navigateToFixedPriceMay2014() {

        if (browser.isTextPresent(pageProperties.getProperty("OurTariffPage.FixedPriceMay2014"))) {
            browser.clickWithLinkText(pageProperties.getProperty("OurTariffPage.FixedPriceMay2014"));
            Report.updateTestLog("Navigate to FixedPriceMay2014 Tariff Page", "PASS");
        } else {

            Report.updateTestLog("Navigate to FixedPriceMay2014 Tariff Page", "FAIL");
        }

        browser.wait(getWaitTime());
    }
    
    public void navigateToOnlineVariableAugust2013() {

    	browser.wait(getWaitTime());
        if (browser.isTextPresent(pageProperties.getProperty("OurTariffPage.OnlineVariableAugust2013"))) {
            browser.clickWithLinkText(pageProperties.getProperty("OurTariffPage.OnlineVariableAugust2013"));
            Report.updateTestLog("Navigate to OnlineVariableAugust2013 Tariff Page", "PASS");
        } else {

            Report.updateTestLog("Navigate to OnlineVariableAugust2013 Tariff Page", "FAIL");
        }

        browser.wait(getWaitTime());
    }
    
    public void navigateToDiscountVariableAugust2013() {

        if (browser.isTextPresent(pageProperties.getProperty("OurTariffPage.DiscountVariableAugust2013"))) {
            browser.clickWithLinkText(pageProperties.getProperty("OurTariffPage.DiscountVariableAugust2013"));
            Report.updateTestLog("Navigate to DiscountVariableAugust2013 Tariff Page", "PASS");
        } else {

            Report.updateTestLog("Navigate to DiscountVariableAugust2013 Tariff Page", "FAIL");
        }

        browser.wait(getWaitTime());
    }
    
    
    public void navigateToClearAndSimple() {
    	 browser.wait(getWaitTime()); 

        if (browser.isTextPresent(pageProperties.getProperty("OurTariffPage.ClearAndSimple"))) {
            browser.clickWithLinkText(pageProperties.getProperty("OurTariffPage.ClearAndSimple"));
            Report.updateTestLog("Navigate to ClearAndSimple Tariff Page", "PASS");
        } else {

            Report.updateTestLog("Navigate to ClearAndSimple Tariff Page", "FAIL");
        }
    	
        browser.wait(getWaitTime());
    }
    
    public void navigateToZeusTariff99() {

        if (browser.isTextPresent(pageProperties.getProperty("OurTariffPage.ZeusTariff99"))) {
            browser.clickWithLinkText(pageProperties.getProperty("OurTariffPage.ZeusTariff99"));
            Report.updateTestLog("Navigate to ZeusTariff99 Tariff Page", "PASS");
        } else {

            Report.updateTestLog("Navigate to ZeusTariff99 Tariff Page", "FAIL");
        }

        browser.wait(getWaitTime());
    }
    

    public void navigateToOnlinePriceFreezeJune2013Tariff() {

        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("OurTariffPage.FixedPriceMay2014"))) {
            browser.clickWithXpath(pageProperties.getProperty("OurTariffPage.FixedPriceMay2014"));
            Report.updateTestLog("Navigate to FixedPriceMay2014 Tariff Page", "PASS");
        } else {

            Report.updateTestLog("Navigate to FixedPriceMay2014 Tariff Page", "FAIL");
        }

        browser.wait(getWaitTime());
    }

    public void fillTariffDetails() {
        String payment;
        String[] paymentType;
        paymentType = new String[2];
        browser.wait(getWaitTime());
        String[] region;
        String postcode;
        List<String> meter = browser.getFromDropBox("id", pageProperties.getProperty("OurTariffPage.fuelType"));
        for (int y = 0; y < meter.size(); y++) {
            browser.selectfromDropBox("id", pageProperties.getProperty("OurTariffPage.fuelType"), meter.get(y));
            List<String> tariffDetails = getMeterList(pageProperties.getProperty("OurTariffPage.tariff"));

            for (int x = 0; x < tariffDetails.size(); x++) {
                String tariff = tariffDetails.get(x);
                browser.selectfromDropBox("id", pageProperties.getProperty("OurTariffPage.tariff"), tariff);
                String meter2[] = {"Gas", "Elec", "Elec"};
                for (int i = 0; i < getRegions().length; i++) {
                    postcode = getPostcode(i);
                    if (browser.isElementVisible(pageProperties.getProperty("OurTariffPage.postcode"))) {
                        browser.clearValue(pageProperties.getProperty("OurTariffPage.postcode"));
                        browser.input(pageProperties.getProperty("OurTariffPage.postcode"), postcode);
                    }
                    if (browser.isElementVisibleWithXpath(pageProperties.getProperty("OurTariffPage.submit"))) {
                        browser.wait(getWaitTime());
                        browser.clickWithXpath(pageProperties.getProperty("OurTariffPage.submit"));
                    }
                    if (meter.get(y).equalsIgnoreCase("gas")) {
                        paymentType[0] = "QCC";
                        paymentType[1] = "MDD";
                        //paymentType[2] = "PPM";
                    } else if (meter.get(y).equalsIgnoreCase("electricity single rate")) {
                        paymentType[0] = " SRQCC";
                        paymentType[1] = " SRMDD";
                        //paymentType[2] = " SRPPM";
                    } else {
                        paymentType[0] = " 2RQCC";
                        paymentType[1] = " 2RMDD";
                        //paymentType[2] = " 2RPPM";
                    }
                    for (int z = 1; z < paymentType.length; z++) {
                        payment = tariffDetails.get(x) + meter2[y] + paymentType[z] + getRegions()[i];
                        PriceFinder pricefinder = new TestDataHelper().getPFdata(payment);
                        String paymentT;
                        if (paymentType[z].length() > 3) {
                            paymentT = paymentType[z].substring(3);
                        } else {
                            paymentT = paymentType[z];
                            if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.CashCardPath"))) {
                                verifyCashCard(tariffDetails, x, meter, y, pricefinder, postcode, paymentT);
                            }
                            if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.DirectDebitPath"))) {
                                verifyDirectDebit(tariffDetails, x, meter, y, pricefinder, postcode, paymentT);
                            }
                            if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.PrepaymentPath"))) {
                                verifyPrePayment(tariffDetails, x, meter, y, pricefinder, postcode, paymentT);
                            }
                            if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.Monthly"))) {
                                verifyAveragePrice(tariffDetails, x, meter, y, pricefinder, postcode, paymentT);
                            }
                        }
                    }
                }
            }

        }
    }


}
