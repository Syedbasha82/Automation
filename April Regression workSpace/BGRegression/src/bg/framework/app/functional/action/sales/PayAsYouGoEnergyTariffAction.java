package bg.framework.app.functional.action.sales;

import bg.framework.app.functional.page.sales.PayAsYouGoEnergyTariffPage;

/**
 * Created by IntelliJ IDEA.
 * User: !boobalas
 * Date: 31/01/12
 * Time: 11:51
 * To change this template use File | Settings | File Templates.
 */
public class PayAsYouGoEnergyTariffAction {

    public PayAsYouGoEnergyTariffAction VerifyPayAsYouGoEnergyTariffPage() {
        PayAsYouGoEnergyTariffPage payAsYouGoEnergyTariffPage = new PayAsYouGoEnergyTariffPage();
        payAsYouGoEnergyTariffPage.fillTariffDetails();
        return this;
    }

    public OurTariffAction navigateToOurTariffPage() {
        PayAsYouGoEnergyTariffPage azTariffPage = new PayAsYouGoEnergyTariffPage();
        azTariffPage.navigateToOurTariffPage();
        return new OurTariffAction();
    }

    public AcquisitionAction navigateToGasOrderPage() {
        PayAsYouGoEnergyTariffPage payAsYouGoEnergyTariffPage = new PayAsYouGoEnergyTariffPage();
        payAsYouGoEnergyTariffPage.navigateToGasAcquisitionPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToElecOrderPage() {
        PayAsYouGoEnergyTariffPage payAsYouGoEnergyTariffPage = new PayAsYouGoEnergyTariffPage();
        payAsYouGoEnergyTariffPage.navigateToElecAcquisitionPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToDualOrderPage() {
        PayAsYouGoEnergyTariffPage payAsYouGoEnergyTariffPage = new PayAsYouGoEnergyTariffPage();
        payAsYouGoEnergyTariffPage.navigateToDualAcquisitionPage();
        return new AcquisitionAction();
    }


}
