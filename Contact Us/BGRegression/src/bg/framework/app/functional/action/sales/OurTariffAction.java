package bg.framework.app.functional.action.sales;

import bg.framework.app.functional.page.sales.OurTariffsPage;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 12/01/12
 * Time: 02:26
 * To change this template use File | Settings | File Templates.
 */
public class OurTariffAction {
    public AZTariffAction navigateToAZTariffPage() {
        OurTariffsPage ourTariffsPage = new OurTariffsPage();
        ourTariffsPage.navigateToAZTariffPage();
        return new AZTariffAction();
    }

    public StandardTariffAction navigateToStandardTariffPage() {
        OurTariffsPage ourTariffsPage = new OurTariffsPage();
        ourTariffsPage.navigateToStandardTariffPage();
        return new StandardTariffAction();
    }

    public FixedPriceJune2013TariffAction navigateToPriceCheck2014TariffPage() {
        OurTariffsPage ourTariffsPage = new OurTariffsPage();
        ourTariffsPage.navigateToFixedPriceJune2013TariffPage();
        return new FixedPriceJune2013TariffAction();
    }

    public OnlineEnergyTariffAction navigateToOnlineEnergyTariffPage() {
        OurTariffsPage ourTariffsPage = new OurTariffsPage();
        ourTariffsPage.navigateToOnlineEnergyTariffPage();
        return new OnlineEnergyTariffAction();
    }

    public PayAsYouGoEnergyTariffAction navigateToPAYGTariffPage() {
        OurTariffsPage ourTariffsPage = new OurTariffsPage();
        ourTariffsPage.navigateToPAYGTariffPage();
        return new PayAsYouGoEnergyTariffAction();
    }

    public EnergyShareTariffAction navigateToEnergyShareTariffPage() {
        OurTariffsPage ourTariffsPage = new OurTariffsPage();
        ourTariffsPage.navigateToEnergyShareTariffPage();
        return new EnergyShareTariffAction();
    }

    public OnlinePriceFreezeJune2013TariffAction navigateToOnlinePriceFreezeJune2013Tariff() {
        OurTariffsPage ourTariffsPage = new OurTariffsPage();
        ourTariffsPage.navigateToOnlinePriceFreezeJune2013Tariff();
        return new OnlinePriceFreezeJune2013TariffAction();
    }

    public OurTariffAction verifyOurTariffPriceFinder() {
        OurTariffsPage ourTariffsPage = new OurTariffsPage();
        ourTariffsPage.fillTariffDetails();
        return this;
    }
    public DiscountVariableAugust2013Action navigateToDiscountVariableAugust2013() {
        OurTariffsPage ourTariffsPage = new OurTariffsPage();
        ourTariffsPage.navigateToDiscountVariableAugust2013();
        return new DiscountVariableAugust2013Action();
    }
    public FixedPriceMay2014Action navigateToFixedPriceMay2014() {
        OurTariffsPage ourTariffsPage = new OurTariffsPage();
        ourTariffsPage.navigateToFixedPriceMay2014();
        return new FixedPriceMay2014Action();
    }
    
    public OnlineVariableAugust2013Action navigateToOnlineVariableAugust2013() {
        OurTariffsPage ourTariffsPage = new OurTariffsPage();
        ourTariffsPage.navigateToOnlineVariableAugust2013();
        return new OnlineVariableAugust2013Action();
    }
    
    public ClearAndSimpleAction navigateToClearAndSimple() {
        OurTariffsPage ourTariffsPage = new OurTariffsPage();
        ourTariffsPage.navigateToClearAndSimple();
        return new ClearAndSimpleAction();
    }
    
    public ClearAndSimpleAction navigateToClearAndSimpleXpath() {
        OurTariffsPage ourTariffsPage = new OurTariffsPage();
        ourTariffsPage.navigateToClearAndSimpleXpath();
        return new ClearAndSimpleAction();
    }
    
    public ClearAndSimpleAction navigateToFixedPriceMay2014Xpath() {
        OurTariffsPage ourTariffsPage = new OurTariffsPage();
        ourTariffsPage.navigateToFixedPriceMay2014Xpath();
        return new ClearAndSimpleAction();
    }
    
    public ClearAndSimpleAction navigateToOnlineVariableAugust2013Xpath() {
        OurTariffsPage ourTariffsPage = new OurTariffsPage();
        ourTariffsPage.navigateToOnlineVariableAugust2013Xpath();
        return new ClearAndSimpleAction();
    }
    
    public ZeusTariff99Action navigateToZeusTariff99() {
        OurTariffsPage ourTariffsPage = new OurTariffsPage();
        ourTariffsPage.navigateToZeusTariff99();
        return new ZeusTariff99Action();
    }

}
