package bg.framework.app.functional.action.sales;

import bg.framework.app.functional.page.sales.StandardTariffPage;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 25/01/12
 * Time: 16:04
 * To change this template use File | Settings | File Templates.
 */
public class StandardTariffAction {
    public AcquisitionAction navigateToGasOrderPage() {
        StandardTariffPage standardTariffPage = new StandardTariffPage();
        standardTariffPage.navigateToGasAcquisitionPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToElecOrderPage() {
        StandardTariffPage standardTariffPage = new StandardTariffPage();
        standardTariffPage.navigateToElecAcquisitionPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToDualOrderPage() {
        StandardTariffPage standardTariffPage = new StandardTariffPage();
        standardTariffPage.navigateToDualAcquisitionPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToEnergySmartDualOrderPage() {
        StandardTariffPage standardTariffPage = new StandardTariffPage();
        standardTariffPage.navigateToEnergySmartDualOrderPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToEnergySmartElectricityOrderPage() {
        StandardTariffPage standardTariffPage = new StandardTariffPage();
        standardTariffPage.navigateToEnergySmartElectricityOrderPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToEnergySmartGasOrderPage() {
        StandardTariffPage standardTariffPage = new StandardTariffPage();
        standardTariffPage.navigateToEnergySmartGasOrderPage();
        return new AcquisitionAction();
    }


    public StandardTariffAction VerifyStandardTariffPage() {
        StandardTariffPage standardTariffPage = new StandardTariffPage();
        standardTariffPage.fillTariffDetails();
        return this;
    }

    public OurTariffAction navigateToOurTariffPage() {
        StandardTariffPage azTariffPage = new StandardTariffPage();
        azTariffPage.navigateToOurTariffPage();
        return new OurTariffAction();
    }
}
