package bg.framework.app.functional.action.sales;

import bg.framework.app.functional.page.sales.OnlineEnergyTariffPage;

/**
 * Created by IntelliJ IDEA.
 * User: !boobalas
 * Date: 31/01/12
 * Time: 10:07
 * To change this template use File | Settings | File Templates.
 */
public class OnlineEnergyTariffAction {

    public AcquisitionAction navigateToGasOrderPage() {
        OnlineEnergyTariffPage onlineEnergyTariffPage = new OnlineEnergyTariffPage();
        onlineEnergyTariffPage.navigateToGasAcquisitionPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToElecOrderPage() {
        OnlineEnergyTariffPage onlineEnergyTariffPage = new OnlineEnergyTariffPage();
        onlineEnergyTariffPage.navigateToElecAcquisitionPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToDualOrderPage() {
        OnlineEnergyTariffPage onlineEnergyTariffPage = new OnlineEnergyTariffPage();
        onlineEnergyTariffPage.navigateToDualAcquisitionPage();
        return new AcquisitionAction();
    }

    public OnlineEnergyTariffAction verifyOnlineEnergyTariffPage() {
        OnlineEnergyTariffPage onlineEnergyTariffPage = new OnlineEnergyTariffPage();
        onlineEnergyTariffPage.fillTariffDetails();
        return this;
    }

    public OurTariffAction navigateToOurTariffPage() {
        OnlineEnergyTariffPage azTariffPage = new OnlineEnergyTariffPage();
        azTariffPage.navigateToOurTariffPage();
        return new OurTariffAction();
    }

    public AcquisitionAction navigateToEnergySmartGasOrderPage() {
        OnlineEnergyTariffPage onlineEnergyTariffPage = new OnlineEnergyTariffPage();
        onlineEnergyTariffPage.navigateToEnergySmartGasOrderPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToEnergySmartElectricityOrderPage() {
        OnlineEnergyTariffPage onlineEnergyTariffPage = new OnlineEnergyTariffPage();
        onlineEnergyTariffPage.navigateToEnergySmartElectricityOrderPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToEnergySmartDualOrderPage() {
        OnlineEnergyTariffPage onlineEnergyTariffPage = new OnlineEnergyTariffPage();
        onlineEnergyTariffPage.navigateToEnergySmartDualOrderPage();
        return new AcquisitionAction();
    }


}
