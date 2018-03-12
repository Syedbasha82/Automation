package bg.framework.app.functional.action.sales;


import bg.framework.app.functional.page.sales.ZeusTariff99Page;

public class ZeusTariff99Action {
    public AcquisitionAction navigateToGasOrderPage() {
    	ZeusTariff99Page zeusTariff99Page = new ZeusTariff99Page();
    	zeusTariff99Page.navigateToGasAcquisitionPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToElecOrderPage() {
    	ZeusTariff99Page zeusTariff99Page = new ZeusTariff99Page();
    	zeusTariff99Page.navigateToElecAcquisitionPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToDualOrderPage() {
    	ZeusTariff99Page zeusTariff99Page = new ZeusTariff99Page();
    	zeusTariff99Page.navigateToDualAcquisitionPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToEnergySmartDualOrderPage() {
    	ZeusTariff99Page zeusTariff99Page = new ZeusTariff99Page();
    	zeusTariff99Page.navigateToEnergySmartDualOrderPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToEnergySmartElectricityOrderPage() {
    	ZeusTariff99Page zeusTariff99Page = new ZeusTariff99Page();
    	zeusTariff99Page.navigateToEnergySmartElectricityOrderPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToEnergySmartGasOrderPage() {
    	ZeusTariff99Page zeusTariff99Page = new ZeusTariff99Page();
    	zeusTariff99Page.navigateToEnergySmartGasOrderPage();
        return new AcquisitionAction();
    }


   
}
