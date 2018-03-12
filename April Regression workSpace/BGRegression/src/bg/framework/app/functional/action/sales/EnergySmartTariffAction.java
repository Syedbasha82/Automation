package bg.framework.app.functional.action.sales;


import bg.framework.app.functional.page.sales.EnergySmartTariffPage;

/**
 * Created by IntelliJ IDEA.
 * User: !boobalas
 * Date: 13/03/12
 * Time: 05:25
 * To change this template use File | Settings | File Templates.
 */
public class EnergySmartTariffAction {


    public AcquisitionAction navigateToAddEnergySmartPage() {
        EnergySmartTariffPage energySmartTariffPage = new EnergySmartTariffPage();
        energySmartTariffPage.navigateToAnonyEnergySmartPage();
        return new AcquisitionAction();
    }
    
    

    public AcquisitionAction navigateToEnergySmartDualPage() {
        EnergySmartTariffPage energySmartTariffPage = new EnergySmartTariffPage();
        energySmartTariffPage.clickAddEnergySmartPageDual();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToEnergySmartGasPage() {
        EnergySmartTariffPage energySmartTariffPage = new EnergySmartTariffPage();
        energySmartTariffPage.clickAddEnergySmartPageGas();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToEnergySmartElecPage() {
        EnergySmartTariffPage energySmartTariffPage = new EnergySmartTariffPage();
        energySmartTariffPage.clickAddEnergySmartPageElec();
        return new AcquisitionAction();
    }

}
