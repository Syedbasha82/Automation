package bg.framework.app.functional.action.sales;

import bg.framework.app.functional.page.sales.FixedPriceJune2013TariffPage;
import bg.framework.app.functional.page.sales.StandardTariffPage;

/**
 * Created by IntelliJ IDEA.
 * User: !boobalas
 * Date: 31/01/12
 * Time: 11:51
 * To change this template use File | Settings | File Templates.
 */
public class FixedPriceJune2013TariffAction {

    public void validateFixedPriceTariffDetails() {
        FixedPriceJune2013TariffPage fixedPriceJune2013TariffPage = new FixedPriceJune2013TariffPage();
        fixedPriceJune2013TariffPage.fillTariffDetails();
    }

    public AcquisitionAction navigateToGasOrderPage() {
        FixedPriceJune2013TariffPage fixedPriceJune2013TariffPage = new FixedPriceJune2013TariffPage();
        fixedPriceJune2013TariffPage.navigateToGasAcquisitionPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToElecOrderPage() {
        FixedPriceJune2013TariffPage fixedPriceJune2013TariffPage = new FixedPriceJune2013TariffPage();
        fixedPriceJune2013TariffPage.navigateToElecAcquisitionPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToDualOrderPage() {
        FixedPriceJune2013TariffPage fixedPriceJune2013TariffPage = new FixedPriceJune2013TariffPage();
        fixedPriceJune2013TariffPage.navigateToDualAcquisitionPage();
        return new AcquisitionAction();
               
    }
    
    public AcquisitionAction navigateToEnergySmartDualOrderPage() {
    	FixedPriceJune2013TariffPage fixedPriceJune2013TariffPage = new FixedPriceJune2013TariffPage();
    	fixedPriceJune2013TariffPage.navigateToEnergySmartDualOrderPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToEnergySmartElectricityOrderPage() {
    	FixedPriceJune2013TariffPage fixedPriceJune2013TariffPage = new FixedPriceJune2013TariffPage();
    	fixedPriceJune2013TariffPage.navigateToEnergySmartElectricityOrderPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToEnergySmartGasOrderPage() {
    	FixedPriceJune2013TariffPage fixedPriceJune2013TariffPage = new FixedPriceJune2013TariffPage();
    	fixedPriceJune2013TariffPage.navigateToEnergySmartGasOrderPage();
        return new AcquisitionAction();
    }


}
