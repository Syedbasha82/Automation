package bg.framework.app.functional.test.sales;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import org.testng.annotations.Test;

import static bg.framework.app.functional.entities.FunctionalCategory.*;


public class AZTariffTest extends TestBase {

    @SuppressWarnings("unchecked")
    @Test(groups = {PriceFinder, Regression, BG})
    public void verifyAZTariffPriceFinder() {
        Report.createTestLogHeader("Price Finder", "A - Z Page");
        new HomePageAction()
                .navigateToOurTariffPage()
                .navigateToAZTariffPage()
                .VerifyAZTariffPage();
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {PriceFinder, Regression})
    public void onlineEnergyPriceFinder() {
        Report.createTestLogHeader("Price Finder", "Online Energy Tariff Journey");
        new HomePageAction()
                .navigateToOurTariffPage()
                .navigateToOnlineEnergyTariffPage()
                .verifyOnlineEnergyTariffPage();
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {PriceFinder, Regression})
    public void standardEnergyPriceFinder() {
        Report.createTestLogHeader("Price Finder", "Standard Tariff Page");
        new HomePageAction()
                .navigateToOurTariffPage()
                .navigateToStandardTariffPage()
                .VerifyStandardTariffPage();
    }

  /*  @SuppressWarnings("unchecked")
    @Test(groups = {PriceFinder, Regression, BG})
    public void fixedPriceJune2013PriceFinder() {
        Report.createTestLogHeader("Price Finder", "Fixed Price June 2013 Tariff Page");
        new HomePageAction()
                .navigateToOurTariffPage()
                .navigateToFixedPriceMay2014()
                .validateFixedPriceTariffDetails();
    }*/

    @SuppressWarnings("unchecked")
    @Test(groups = {PriceFinder, Regression, BG})
    public void energySharePriceFinder() {
        Report.createTestLogHeader("Price Finder", "Energy Share Tariff Page");
        new HomePageAction()
                .navigateToOurTariffPage()
                .navigateToEnergyShareTariffPage()
                .VerifyEnergyShareTariffPage();
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {PriceFinder, Regression, Fusion})
    public void onlinePriceFreezeJune2013Tariff() {
        Report.createTestLogHeader("Price Finder", "Online Price Freeze June 2013 Tariff Page");
        new HomePageAction()
                .navigateToOurTariffPage()
                .navigateToOnlinePriceFreezeJune2013Tariff()
                .OnlinePriceFreezeJune2013PF();
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {PriceFinder, Regression, BG})
    public void payAsYouGoEnergyPriceFinder() {
        Report.createTestLogHeader("Price Finder", "Pay As You Go Energy Tariff Page");
        new HomePageAction()
                .navigateToOurTariffPage()
                .navigateToPAYGTariffPage()
                .VerifyPayAsYouGoEnergyTariffPage();
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {PriceFinder, Regression, Fusion, BG})
    public void verifyOurTariffPriceFinder() {
        Report.createTestLogHeader("Price Finder", "Our Tariff Page");
        new HomePageAction()
                .navigateToOurTariffPage()
                .verifyOurTariffPriceFinder();
    }
}