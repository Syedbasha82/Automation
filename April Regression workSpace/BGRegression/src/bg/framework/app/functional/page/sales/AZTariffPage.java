package bg.framework.app.functional.page.sales;

import bg.framework.app.functional.entities.PriceFinder;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

import java.util.List;
import java.util.Properties;

public class AZTariffPage extends BasePage {
    private final static String FILE_NAME = "resources/sales/AZTariffPage.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
    String meter2[] = {"Gas", "Elec SR", "Elec 2R"};

    public void fillTariffDetails() {
        String payment;
        String[] paymentType;
        paymentType = new String[2];
        browser.wait(getWaitTime());
        String postcode;
        List<String> fuelType = browser.getFromDropBox("id", pageProperties.getProperty("AZTariffPage.fuelType"));
        for (int y = 0; y < fuelType.size(); y++) {
            browser.selectfromDropBox("id",pageProperties.getProperty("AZTariffPage.fuelType"), fuelType.get(y));
            List<String> tariffDetails = getMeterList(pageProperties.getProperty("AZTariffPage.tariff"));
            for (int x = 0; x < tariffDetails.size(); x++) {
                String tariff = tariffDetails.get(x);
                browser.selectfromDropBox("id", pageProperties.getProperty("AZTariffPage.tariff"), tariff);
                for (int i = 0; i < getRegions().length; i++) {
                    postcode = getPostcode(i);
                    if (browser.isElementVisible(pageProperties.getProperty("AZTariffPage.postcode"))) {
                        browser.clearValue(pageProperties.getProperty("AZTariffPage.postcode"));
                        browser.input(pageProperties.getProperty("AZTariffPage.postcode"), postcode);
                    }
                    if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.submit"))) {
                        browser.wait(getWaitTime());
                        browser.clickWithXpath(pageProperties.getProperty("AZTariffPage.submit"));
                    }
                    if (fuelType.get(y).equalsIgnoreCase("gas")) {
                        paymentType[0] = "QCC";
                        paymentType[1] = "MDD";
                    } else if (fuelType.get(y).equalsIgnoreCase("electricity single rate")) {
                        paymentType[0] = " SRQCC";
                        paymentType[1] = " SRMDD";
                    } else {
                        paymentType[0] = " 2RQCC";
                        paymentType[1] = " 2RMDD";
                    }
                    for (int z = 0; z < paymentType.length; z++) {
                        payment = tariffDetails.get(x) + meter2[y] + paymentType[z] + getRegions()[i];
                        PriceFinder pricefinder = new TestDataHelper().getPFdata(payment);
                        String paymentT;
                        if (paymentType[z].length() > 3) {
                            paymentT = paymentType[z].substring(3);
                        } else {
                            paymentT = paymentType[z];
                        }
                        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.CashCardPath"))) {
                            verifyCashCard(tariffDetails, x, fuelType, y, pricefinder, postcode, paymentT);
                        }
                        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.DirectDebitPath"))) {
                            verifyDirectDebit(tariffDetails, x, fuelType, y, pricefinder, postcode, paymentT);
                        }
                        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.PrepaymentPath"))) {
                            verifyPrePayment(tariffDetails, x, fuelType, y, pricefinder, postcode, paymentT);
                        }
                        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.Monthly"))) {
                            verifyAveragePrice(tariffDetails, x, fuelType, y, pricefinder, postcode, paymentT);
                        }
                    }
                }
            }
        }
    }

    public void navigateToOurTariffPage() {
        if (browser.isTextPresent(pageProperties.getProperty("AZTariffPage.OurTariffPage"))) {
            browser.clickWithLinkText(pageProperties.getProperty("AZTariffPage.OurTariffPage"));
            Report.updateTestLog("Navigate to A-Z tariff page", "PASS");
        } else {
            Report.updateTestLog("Navigate to A-Z tariff page", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void verifyCashCard(List<String> tariffDetails, int x, List<String> meter, int y, PriceFinder pricefinder, String postcode, String paymentT) {
        Report.updateTestLog("Price Finder : Tariff :" + tariffDetails.get(x) + ", " +
                "Meter Type :" + meter.get(y) + ", Payment Type : Cash/Card" + ", Post Code :" + postcode, "PASS");
        String t1Act = pricefinder.getT1();
        String tier1Act = ceilDouble(t1Act, "0.00");
        String t1Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage." + paymentT + "t1"));
        String tier1Disp = ceilDouble(t1Disp, "0.00");
        if (tier1Disp.equalsIgnoreCase(tier1Act)) {
            Report.updateTestLog("Price Finder Tier 1 Verification Done :" + tier1Act, "PASS");
        } else {
            Report.updateTestLog("Price Finder Tier 1 Verification actual :" + tier1Act + ", displayed :" + tier1Disp, "FAIL");
        }
        String t2Act = pricefinder.getT2();
        String tier2Act = ceilDouble(t2Act, "0.00");
        String t2Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage." + paymentT + "t2"));
        String tier2Disp = ceilDouble(t2Disp, "0.00");
        if (tier2Disp.equalsIgnoreCase(tier2Act)) {
            Report.updateTestLog("Price Finder Tier 2 Verification Done :" + tier2Act, "PASS");
        } else {
            Report.updateTestLog("Price Finder Tier 2 Verification actual :" + tier2Act + ", displayed :" + tier2Disp, "FAIL");
        }
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage." + paymentT + "t3"))) {
            String t3Act = pricefinder.getN();
            String tier3Act = ceilDouble(t3Act, "0.00");
            String t3Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage." + paymentT + "t3"));
            String tier3Disp = ceilDouble(t3Disp, "0.00");
            if (tier3Disp.equalsIgnoreCase(tier3Act)) {
                Report.updateTestLog("Price Finder Night Verification Done :" + tier3Act, "PASS");
            } else {
                Report.updateTestLog("Price Finder Night Verification actual :" + tier3Act + ", displayed :" + tier3Disp, "FAIL");
            }
        }
    }

    public void verifyDirectDebit(List<String> tariffDetails, int x, List<String> meter, int y, PriceFinder pricefinder, String postcode, String paymentT) {
        Report.updateTestLog("Price Finder : Tariff :" + tariffDetails.get(x) + ", " +
                "Meter Type :" + meter.get(y) + ", Payment Type :Direct Debit" + ", Post Code :" + postcode, "PASS");
        String t1Act = pricefinder.getT1();
        String tier1Act = ceilDouble(t1Act, "0.00");
        String t1Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.QCCt1"));
        String tier1Disp = ceilDouble(t1Disp, "0.00");
        if (tier1Disp.equalsIgnoreCase(tier1Act)) {
            Report.updateTestLog("Price Finder Tier 1 Verification Done :" + tier1Act, "PASS");
        } else {
            Report.updateTestLog("Price Finder Tier 1 Verification actual :" + tier1Act + ", displayed :" + tier1Disp, "FAIL");
        }
        String t2Act = pricefinder.getT2();
        String tier2Act = ceilDouble(t2Act, "0.00");
        String t2Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.QCCt2"));
        String tier2Disp = ceilDouble(t2Disp, "0.00");
        if (tier2Disp.equalsIgnoreCase(tier2Act)) {
            Report.updateTestLog("Price Finder Tier 2 Verification Done :" + tier2Act, "PASS");
        } else {
            Report.updateTestLog("Price Finder Tier 2 Verification actual:" + tier2Act + ", displayed" + tier2Disp, "FAIL");
        }
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage." + paymentT + "t3"))) {
            String t3Act = pricefinder.getN();
            String tier3Act = ceilDouble(t3Act, "0.00");
            String t3Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.QCCt3"));
            String tier3Disp = ceilDouble(t3Disp, "0.00");
            if (tier3Disp.equalsIgnoreCase(tier3Act)) {
                Report.updateTestLog("Price Finder Night Verification Done :" + tier3Act, "PASS");
            } else {
                Report.updateTestLog("Price Finder Night Verification actual :" + tier3Act + ", displayed :" + tier3Disp, "FAIL");
            }
        }
    }

    public void verifyPrePayment(List<String> tariffDetails, int x, List<String> meter, int y, PriceFinder pricefinder, String postcode, String paymentT) {
        Report.updateTestLog("Price Finder : Tariff :" + tariffDetails.get(x) + ", " +
                "Meter Type :" + meter.get(y) + ", Payment Type : Prepayment" + ", Post Code :" + postcode, "PASS");
        String t1Act = pricefinder.getT1();
        String tier1Act = ceilDouble(t1Act, "0.00");
        String t1Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.QCCt1"));
        String tier1Disp = ceilDouble(t1Disp, "0.00");
        if (tier1Disp.equalsIgnoreCase(tier1Act)) {
            Report.updateTestLog("Price Finder Tier 1 Verification Done :" + tier1Act, "PASS");
        } else {
            Report.updateTestLog("Price Finder Tier 1 Verification actual :" + tier1Act + ", displayed :" + tier1Disp, "FAIL");
        }
        String t2Act = pricefinder.getT2();
        String tier2Act = ceilDouble(t2Act, "0.00");
        String t2Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.QCCt2"));
        String tier2Disp = ceilDouble(t2Disp, "0.00");
        if (tier2Disp.equalsIgnoreCase(tier2Act)) {
            Report.updateTestLog("Price Finder Tier 2 Verification Done :" + tier2Act, "PASS");
        } else {
            Report.updateTestLog("Price Finder Tier 2 Verification actual:" + tier2Act + ", displayed" + tier2Disp, "FAIL");
        }
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage." + paymentT + "t3"))) {
            String t3Act = pricefinder.getN();
            String tier3Act = ceilDouble(t3Act, "0.00");
            String t3Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.QCCt3"));
            String tier3Disp = ceilDouble(t3Disp, "0.00");
            if (tier3Disp.equalsIgnoreCase(tier3Act)) {
                Report.updateTestLog("Price Finder Night Verification Done :" + tier3Act, "PASS");
            } else {
                Report.updateTestLog("Price Finder Night Verification actual :" + tier3Act + ", displayed :" + tier3Disp, "FAIL");
            }
        }
    }

    public void verifyAveragePrice(List<String> tariffDetails, int x, List<String> meter, int y, PriceFinder pricefinder, String postcode, String paymentT) {
        String monthly = pricefinder.getMonthly();
        String monDisp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.Monthly"));
        if (monDisp.contains("."))
            monDisp = monDisp.substring(0, monDisp.indexOf("."));
        monDisp = monDisp.substring(2, monDisp.length());
        System.out.println(monDisp);
        if (monDisp.equalsIgnoreCase(monthly)) {
            Report.updateTestLog("Average Price Monthly Bill Verification Done :" + monthly, "PASS");
        } else {
            Report.updateTestLog("Average Price Monthly Bill Verification actual :" + monthly + ", displayed :" + monDisp, "FAIL");
        }
        String quarterly = pricefinder.getQuarterly();
        String quartDisp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.Quarterly"));
        if (quartDisp.contains("."))
            quartDisp = quartDisp.substring(0, quartDisp.indexOf("."));
        quartDisp = quartDisp.substring(2, quartDisp.length());
        if (quartDisp.equalsIgnoreCase(quarterly)) {
            Report.updateTestLog("Average Price quarterly Bill Verification Done :" + quarterly, "PASS");
        } else {
            Report.updateTestLog("Average Price quarterly Bill Verification actual :" + quarterly + ", displayed :" + quartDisp, "FAIL");
        }
        String annually = pricefinder.getYearly();
        String AnnDisp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.Yearly"));
        if (AnnDisp.contains("."))
            AnnDisp = AnnDisp.substring(0, AnnDisp.indexOf("."));
        AnnDisp = AnnDisp.substring(2, AnnDisp.length());
        if (AnnDisp.equalsIgnoreCase(annually)) {
            Report.updateTestLog("Average Price Yearly Bill Verification Done :" + annually, "PASS");
        } else {
            Report.updateTestLog("Average Price Yearly Bill Verification actual :" + annually + ", displayed :" + AnnDisp, "FAIL");
        }
    }

    public String[] getRegions() {
        String[] region;
        region = new String[14];
        region[0] = "Eastern";
        region[1] = "East Midlands";
        region[2] = "London";
        region[3] = "ManWeb";
        region[4] = "Midlands";
        region[5] = "Northern";
        region[6] = "Norweb";
        region[7] = "ScotHydro";
        region[8] = "ScotPower";
        region[9] = "Seeboard";
        region[10] = "Southern";
        region[11] = "Swalec";
        region[12] = "Sweb";
        region[13] = "Yorkshire";
        return region;
    }

    public void verifyCashCard(String fuelType, String tariff, String region, String postcode) {
        String meter;
        if (fuelType.equalsIgnoreCase("gas")) {
            meter = meter2[0];
        } else if (fuelType.equalsIgnoreCase("electricity single rate")) {
            meter = meter2[1];
        } else {
            meter = meter2[2];
        }
        String payment = tariff + meter + "QCC" + region;
        PriceFinder priceFinder = new TestDataHelper().getPFdata(payment);
        Report.updateTestLog("Price Finder : Tariff : " + tariff + ", " +
                "Meter Type :" + fuelType + ", Payment Type : Cash/Card" + ", Post Code :" + postcode, "PASS");
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.Tier1"))) {
            String t1Act = priceFinder.getT1();
            String tier1Act = ceilDouble(t1Act, "0.00");
            String t1Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.QCCt1"));
            String tier1Disp = ceilDouble(t1Disp, "0.00");

            if (tier1Disp.equalsIgnoreCase(tier1Act)) {
                Report.updateTestLog("Price Finder Tier 1 Verification Done :" + tier1Act, "PASS");
            } else {
                Report.updateTestLog("Price Finder Tier 1 Verification actual :" + tier1Act + ", displayed :" + tier1Disp, "FAIL");
            }
        }
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.Tier2"))) {
            String t2Act = priceFinder.getT2();
            String tier2Act = ceilDouble(t2Act, "0.00");
            String t2Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.QCCt2"));
            String tier2Disp = ceilDouble(t2Disp, "0.00");
            if (tier2Disp.equalsIgnoreCase(tier2Act)) {
                Report.updateTestLog("Price Finder Tier 2 Verification Done :" + tier2Act, "PASS");
            } else {
                Report.updateTestLog("Price Finder Tier 2 Verification actual :" + tier2Act + ", displayed :" + tier2Disp, "FAIL");
            }
        }
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.NightRate"))) {
            if (fuelType.equalsIgnoreCase("Economy 7")) {
                String t3Act = priceFinder.getN();
                String tier3Act = ceilDouble(t3Act, "0.00");
                String t3Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.QCCt3"));
                String tier3Disp = ceilDouble(t3Disp, "0.00");
                if (tier3Disp.equalsIgnoreCase(tier3Act)) {
                    Report.updateTestLog("Price Finder Night Verification Done :" + tier3Act, "PASS");
                } else {
                    Report.updateTestLog("Price Finder Night Verification actual :" + tier3Act + ", displayed :" + tier3Disp, "FAIL");
                }
            }
        }
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.StandingCharge"))) {
            String t1Act = priceFinder.getT1();
            String tier1Act = ceilDouble(t1Act, "0.00");
            String t1Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.QCCStandingCharge"));
            String tier1Disp = ceilDouble(t1Disp, "0.00");

            if (tier1Disp.equalsIgnoreCase(tier1Act)) {
                Report.updateTestLog("Price Finder Standing Charge Verification Done :" + tier1Act, "PASS");
            } else {
                Report.updateTestLog("Price Finder Standing Charge Verification actual :" + tier1Act + ", displayed :" + tier1Disp, "FAIL");
            }
        }
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.UnitRate"))) {
            String t1Act = priceFinder.getT1();
            String tier1Act = ceilDouble(t1Act, "0.00");
            String t1Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.QCCUnitRate"));
            String tier1Disp = ceilDouble(t1Disp, "0.00");

            if (tier1Disp.equalsIgnoreCase(tier1Act)) {
                Report.updateTestLog("Price Finder Unit Rate Verification Done :" + tier1Act, "PASS");
            } else {
                Report.updateTestLog("Price Finder Unit Rate Verification actual :" + tier1Act + ", displayed :" + tier1Disp, "FAIL");
            }
        }
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.NightRate"))) {
            if (fuelType.equalsIgnoreCase("Economy 7")) {
                String t1Act = priceFinder.getT1();
                String tier1Act = ceilDouble(t1Act, "0.00");
                String t1Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.QCCNightRate"));
                String tier1Disp = ceilDouble(t1Disp, "0.00");

                if (tier1Disp.equalsIgnoreCase(tier1Act)) {
                    Report.updateTestLog("Price Finder Night Rate Verification Done :" + tier1Act, "PASS");
                } else {
                    Report.updateTestLog("Price Finder Night Rate Verification actual :" + tier1Act + ", displayed :" + tier1Disp, "FAIL");
                }
            }
        }
    }

    public void verifyDirectDebit(String fuelType, String tariff, String region, String postcode) {
        String meter;
        if (fuelType.equalsIgnoreCase("gas")) {
            meter = meter2[0];
        } else if (fuelType.equalsIgnoreCase("electricity single rate")) {
            meter = meter2[1];
        } else {
            meter = meter2[2];
        }
        String payment = tariff + meter + "MDD" + region;
        PriceFinder priceFinder = new TestDataHelper().getPFdata(payment);
        Report.updateTestLog("Price Finder : Tariff : " + tariff + ", " +
                "Meter Type :" + fuelType + ", Payment Type : Direct Debit" + ", Post Code :" + postcode, "PASS");
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.Tier1"))) {
            String t1Act = priceFinder.getT1();
            String tier1Act = ceilDouble(t1Act, "0.00");
            String t1Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.MDDt1"));
            String tier1Disp = ceilDouble(t1Disp, "0.00");

            if (tier1Disp.equalsIgnoreCase(tier1Act)) {
                Report.updateTestLog("Price Finder Tier 1 Verification Done :" + tier1Act, "PASS");
            } else {
                Report.updateTestLog("Price Finder Tier 1 Verification actual :" + tier1Act + ", displayed :" + tier1Disp, "FAIL");
            }
        }
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.Tier2"))) {
            String t2Act = priceFinder.getT2();
            String tier2Act = ceilDouble(t2Act, "0.00");
            String t2Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.MDDt2"));
            String tier2Disp = ceilDouble(t2Disp, "0.00");
            if (tier2Disp.equalsIgnoreCase(tier2Act)) {
                Report.updateTestLog("Price Finder Tier 2 Verification Done :" + tier2Act, "PASS");
            } else {
                Report.updateTestLog("Price Finder Tier 2 Verification actual :" + tier2Act + ", displayed :" + tier2Disp, "FAIL");
            }
        }
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.NightRate"))) {
            if (fuelType.equalsIgnoreCase("Economy 7")) {
                String t3Act = priceFinder.getN();
                String tier3Act = ceilDouble(t3Act, "0.00");
                String t3Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.MDDt3"));
                String tier3Disp = ceilDouble(t3Disp, "0.00");
                if (tier3Disp.equalsIgnoreCase(tier3Act)) {
                    Report.updateTestLog("Price Finder Night Verification Done :" + tier3Act, "PASS");
                } else {
                    Report.updateTestLog("Price Finder Night Verification actual :" + tier3Act + ", displayed :" + tier3Disp, "FAIL");
                }
            }
        }
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.StandingCharge"))) {
            String t1Act = priceFinder.getT1();
            String tier1Act = ceilDouble(t1Act, "0.00");
            String t1Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.MDDStandingCharge"));
            String tier1Disp = ceilDouble(t1Disp, "0.00");

            if (tier1Disp.equalsIgnoreCase(tier1Act)) {
                Report.updateTestLog("Price Finder Standing Charge Verification Done :" + tier1Act, "PASS");
            } else {
                Report.updateTestLog("Price Finder Standing Charge Verification actual :" + tier1Act + ", displayed :" + tier1Disp, "FAIL");
            }
        }
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.UnitRate"))) {
            String t1Act = priceFinder.getT1();
            String tier1Act = ceilDouble(t1Act, "0.00");
            String t1Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.MDDUnitRate"));
            String tier1Disp = ceilDouble(t1Disp, "0.00");

            if (tier1Disp.equalsIgnoreCase(tier1Act)) {
                Report.updateTestLog("Price Finder Unit Rate Verification Done :" + tier1Act, "PASS");
            } else {
                Report.updateTestLog("Price Finder Unit Rate Verification actual :" + tier1Act + ", displayed :" + tier1Disp, "FAIL");
            }
        }
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.NightRate"))) {
            String t1Act = priceFinder.getT1();
            String tier1Act = ceilDouble(t1Act, "0.00");
            String t1Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.MDDNightRate"));
            String tier1Disp = ceilDouble(t1Disp, "0.00");

            if (tier1Disp.equalsIgnoreCase(tier1Act)) {
                Report.updateTestLog("Price Finder Night Rate Verification Done :" + tier1Act, "PASS");
            } else {
                Report.updateTestLog("Price Finder Night Rate Verification actual :" + tier1Act + ", displayed :" + tier1Disp, "FAIL");
            }
        }
    }

    public void verifyPrePayment(String fuelType, String tariff, String region, String postcode) {
        String meter;
        if (fuelType.equalsIgnoreCase("gas")) {
            meter = meter2[0];
        } else if (fuelType.equalsIgnoreCase("electricity single rate")) {
            meter = meter2[1];
        } else {
            meter = meter2[2];
        }
        String payment = tariff + meter + "PPM" + region;
        PriceFinder priceFinder = new TestDataHelper().getPFdata(payment);
        Report.updateTestLog("Price Finder : Tariff : " + tariff + ", " +
                "Meter Type :" + fuelType + ", Payment Type : Pre Payment" + ", Post Code :" + postcode, "PASS");
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.Tier1"))) {
            String t1Act = priceFinder.getT1();
            String tier1Act = ceilDouble(t1Act, "0.00");
            String t1Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.PPMt1"));
            String tier1Disp = ceilDouble(t1Disp, "0.00");

            if (tier1Disp.equalsIgnoreCase(tier1Act)) {
                Report.updateTestLog("Price Finder Tier 1 Verification Done :" + tier1Act, "PASS");
            } else {
                Report.updateTestLog("Price Finder Tier 1 Verification actual :" + tier1Act + ", displayed :" + tier1Disp, "FAIL");
            }
        }
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.Tier2"))) {
            String t2Act = priceFinder.getT2();
            String tier2Act = ceilDouble(t2Act, "0.00");
            String t2Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.PPMt2"));
            String tier2Disp = ceilDouble(t2Disp, "0.00");
            if (tier2Disp.equalsIgnoreCase(tier2Act)) {
                Report.updateTestLog("Price Finder Tier 2 Verification Done :" + tier2Act, "PASS");
            } else {
                Report.updateTestLog("Price Finder Tier 2 Verification actual :" + tier2Act + ", displayed :" + tier2Disp, "FAIL");
            }
        }
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.NightRate"))) {
            String t3Act = priceFinder.getN();
            String tier3Act = ceilDouble(t3Act, "0.00");
            String t3Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.PPMt3"));
            String tier3Disp = ceilDouble(t3Disp, "0.00");
            if (tier3Disp.equalsIgnoreCase(tier3Act)) {
                Report.updateTestLog("Price Finder Night Verification Done :" + tier3Act, "PASS");
            } else {
                Report.updateTestLog("Price Finder Night Verification actual :" + tier3Act + ", displayed :" + tier3Disp, "FAIL");
            }
        }
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.StandingCharge"))) {
            String t1Act = priceFinder.getT1();
            String tier1Act = ceilDouble(t1Act, "0.00");
            String t1Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.PPMStandingCharge"));
            String tier1Disp = ceilDouble(t1Disp, "0.00");

            if (tier1Disp.equalsIgnoreCase(tier1Act)) {
                Report.updateTestLog("Price Finder Standing Charge Verification Done :" + tier1Act, "PASS");
            } else {
                Report.updateTestLog("Price Finder Standing Charge Verification actual :" + tier1Act + ", displayed :" + tier1Disp, "FAIL");
            }
        }
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.UnitRate"))) {
            String t1Act = priceFinder.getT1();
            String tier1Act = ceilDouble(t1Act, "0.00");
            String t1Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.PPMUnitRate"));
            String tier1Disp = ceilDouble(t1Disp, "0.00");

            if (tier1Disp.equalsIgnoreCase(tier1Act)) {
                Report.updateTestLog("Price Finder Unit Rate Verification Done :" + tier1Act, "PASS");
            } else {
                Report.updateTestLog("Price Finder Unit Rate Verification actual :" + tier1Act + ", displayed :" + tier1Disp, "FAIL");
            }
        }
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.NightRate"))) {
            String t1Act = priceFinder.getT1();
            String tier1Act = ceilDouble(t1Act, "0.00");
            String t1Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.PPMNightRate"));
            String tier1Disp = ceilDouble(t1Disp, "0.00");

            if (tier1Disp.equalsIgnoreCase(tier1Act)) {
                Report.updateTestLog("Price Finder Night Rate Verification Done :" + tier1Act, "PASS");
            } else {
                Report.updateTestLog("Price Finder Night Rate Verification actual :" + tier1Act + ", displayed :" + tier1Disp, "FAIL");
            }
        }
    }

    public void verifyPrePayment2(String fuelType, String tariff, String region, String postcode) {
        String meter;
        if (fuelType.equalsIgnoreCase("gas")) {
            meter = meter2[0];
        } else if (fuelType.equalsIgnoreCase("electricity single rate")) {
            meter = meter2[1];
        } else {
            meter = meter2[2];
        }
        String payment = tariff + meter + "PPM" + region;
        PriceFinder priceFinder = new TestDataHelper().getPFdata(payment);
        Report.updateTestLog("Price Finder : Tariff : " + tariff + ", " +
                "Meter Type :" + fuelType + ", Payment Type : Pre Payment" + ", Post Code :" + postcode, "PASS");
        String t1Act = priceFinder.getT1();
        String tier1Act = ceilDouble(t1Act, "0.00");
        String t1Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.PPMt1"));
        String tier1Disp = ceilDouble(t1Disp, "0.00");

        if (tier1Disp.equalsIgnoreCase(tier1Act)) {
            Report.updateTestLog("Price Finder Tier 1 Verification Done :" + tier1Act, "PASS");
        } else {
            Report.updateTestLog("Price Finder Tier 1 Verification actual :" + tier1Act + ", displayed :" + tier1Disp, "FAIL");
        }
        String t2Act = priceFinder.getT2();
        String tier2Act = ceilDouble(t2Act, "0.00");
        String t2Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.PPMt2"));
        String tier2Disp = ceilDouble(t2Disp, "0.00");
        if (tier2Disp.equalsIgnoreCase(tier2Act)) {
            Report.updateTestLog("Price Finder Tier 2 Verification Done :" + tier2Act, "PASS");
        } else {
            Report.updateTestLog("Price Finder Tier 2 Verification actual :" + tier2Act + ", displayed :" + tier2Disp, "FAIL");
        }
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.PPMt3"))) {
            String t3Act = priceFinder.getN();
            String tier3Act = ceilDouble(t3Act, "0.00");
            String t3Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.PPMt3"));
            String tier3Disp = ceilDouble(t3Disp, "0.00");
            if (tier3Disp.equalsIgnoreCase(tier3Act)) {
                Report.updateTestLog("Price Finder Night Verification Done :" + tier3Act, "PASS");
            } else {
                Report.updateTestLog("Price Finder Night Verification actual :" + tier3Act + ", displayed :" + tier3Disp, "FAIL");
            }
        }
    }

    public void verifyDirectDebit2(String fuelType, String tariff, String region, String postcode) {
        String meter;
        if (fuelType.equalsIgnoreCase("gas")) {
            meter = meter2[0];
        } else if (fuelType.equalsIgnoreCase("electricity single rate")) {
            meter = meter2[1];
        } else {
            meter = meter2[2];
        }
        String payment = tariff + meter + "MDD" + region;
        PriceFinder priceFinder = new TestDataHelper().getPFdata(payment);
        Report.updateTestLog("Price Finder : Tariff : " + tariff + ", " +
                "Meter Type :" + fuelType + ", Payment Type : Direct Debit" + ", Post Code :" + postcode, "PASS");
        String t1Act = priceFinder.getT1();
        String tier1Act = ceilDouble(t1Act, "0.00");
        String t1Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.MDDt1"));
        String tier1Disp = ceilDouble(t1Disp, "0.00");

        if (tier1Disp.equalsIgnoreCase(tier1Act)) {
            Report.updateTestLog("Price Finder Tier 1 Verification Done :" + tier1Act, "PASS");
        } else {
            Report.updateTestLog("Price Finder Tier 1 Verification actual :" + tier1Act + ", displayed :" + tier1Disp, "FAIL");
        }
        String t2Act = priceFinder.getT2();
        String tier2Act = ceilDouble(t2Act, "0.00");
        String t2Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.MDDt2"));
        String tier2Disp = ceilDouble(t2Disp, "0.00");
        if (tier2Disp.equalsIgnoreCase(tier2Act)) {
            Report.updateTestLog("Price Finder Tier 2 Verification Done :" + tier2Act, "PASS");
        } else {
            Report.updateTestLog("Price Finder Tier 2 Verification actual :" + tier2Act + ", displayed :" + tier2Disp, "FAIL");
        }
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AZTariffPage.MDDt3"))) {
            String t3Act = priceFinder.getN();
            String tier3Act = ceilDouble(t3Act, "0.00");
            String t3Disp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.MDDt3"));
            String tier3Disp = ceilDouble(t3Disp, "0.00");
            if (tier3Disp.equalsIgnoreCase(tier3Act)) {
                Report.updateTestLog("Price Finder Night Verification Done :" + tier3Act, "PASS");
            } else {
                Report.updateTestLog("Price Finder Night Verification actual :" + tier3Act + ", displayed :" + tier3Disp, "FAIL");
            }
        }
    }

    public void verifyAveragePrice(String fuelType, String tariff, String region) {
        String meter;
        if (fuelType.equalsIgnoreCase("gas")) {
            meter = meter2[0];
        } else if (fuelType.equalsIgnoreCase("electricity single rate")) {
            meter = meter2[1];
        } else {
            meter = meter2[2];
        }
        String payment = tariff + meter + "MDD" + region;
        PriceFinder priceFinder = new TestDataHelper().getPFdata(payment);
        String monthly = priceFinder.getMonthly();
        String monDisp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.Monthly"));
        if (monDisp.contains("."))
            monDisp = monDisp.substring(0, monDisp.indexOf("."));
        monDisp = monDisp.substring(2, monDisp.length());
        System.out.println(monDisp);
        if (monDisp.equalsIgnoreCase(monthly)) {
            Report.updateTestLog("Average Price Monthly Bill Verification Done :" + monthly, "PASS");
        } else {
            Report.updateTestLog("Average Price Monthly Bill Verification actual :" + monthly + ", displayed :" + monDisp, "FAIL");
        }
        String quarterly = priceFinder.getQuarterly();
        String quartDisp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.Quarterly"));
        if (quartDisp.contains("."))
            quartDisp = quartDisp.substring(0, quartDisp.indexOf("."));
        quartDisp = quartDisp.substring(2, quartDisp.length());
        if (quartDisp.equalsIgnoreCase(quarterly)) {
            Report.updateTestLog("Average Price quarterly Bill Verification Done :" + quarterly, "PASS");
        } else {
            Report.updateTestLog("Average Price quarterly Bill Verification actual :" + quarterly + ", displayed :" + quartDisp, "FAIL");
        }
        String annually = priceFinder.getYearly();
        String AnnDisp = browser.getTextByXpath(pageProperties.getProperty("AZTariffPage.Yearly"));
        if (AnnDisp.contains("."))
            AnnDisp = AnnDisp.substring(0, AnnDisp.indexOf("."));
        AnnDisp = AnnDisp.substring(2, AnnDisp.length());
        if (AnnDisp.equalsIgnoreCase(annually)) {
            Report.updateTestLog("Average Price Yearly Bill Verification Done :" + annually, "PASS");
        } else {
            Report.updateTestLog("Average Price Yearly Bill Verification actual :" + annually + ", displayed :" + AnnDisp, "FAIL");
        }
    }
}

