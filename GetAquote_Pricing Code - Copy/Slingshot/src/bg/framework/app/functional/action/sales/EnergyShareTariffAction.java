package bg.framework.app.functional.action.sales;

import bg.framework.app.functional.page.sales.EnergyShareTariffPage;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 25/01/12
 * Time: 16:04
 * To change this template use File | Settings | File Templates.
 */
public class EnergyShareTariffAction {
    public AcquisitionAction navigateToGasOrderPage() {
        EnergyShareTariffPage energyShareTariffPage = new EnergyShareTariffPage();
        energyShareTariffPage.navigateToGasAcquisitionPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToElecOrderPage() {
        EnergyShareTariffPage energyShareTariffPage = new EnergyShareTariffPage();
        energyShareTariffPage.navigateToElecAcquisitionPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToDualOrderPage() {
        EnergyShareTariffPage energyShareTariffPage = new EnergyShareTariffPage();
        energyShareTariffPage.navigateToDualAcquisitionPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToEnergySmartDualOrderPage() {
        EnergyShareTariffPage energyShareTariffPage = new EnergyShareTariffPage();
        energyShareTariffPage.navigateToEnergySmartDualOrderPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToEnergySmartElectricityOrderPage() {
        EnergyShareTariffPage energyShareTariffPage = new EnergyShareTariffPage();
        energyShareTariffPage.navigateToEnergySmartElectricityOrderPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToEnergySmartGasOrderPage() {
        EnergyShareTariffPage energyShareTariffPage = new EnergyShareTariffPage();
        energyShareTariffPage.navigateToEnergySmartGasOrderPage();
        return new AcquisitionAction();
    }


    public EnergyShareTariffAction VerifyEnergyShareTariffPage() {
        EnergyShareTariffPage energyShareTariffPage = new EnergyShareTariffPage();
        energyShareTariffPage.fillTariffDetails();
        return this;
    }

    public OurTariffAction navigateToOurTariffPage() {
        EnergyShareTariffPage azTariffPage = new EnergyShareTariffPage();
        azTariffPage.navigateToOurTariffPage();
        return new OurTariffAction();
    }
}

