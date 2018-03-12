package bg.framework.app.functional.action.sales;


import bg.framework.app.functional.page.sales.FixedPriceMay2014Page;

public class FixedPriceMay2014Action {
    public AcquisitionAction navigateToGasOrderPage() {
    	FixedPriceMay2014Page fixedPriceMay2014Page = new FixedPriceMay2014Page();
    	fixedPriceMay2014Page.navigateToGasAcquisitionPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToElecOrderPage() {
    	FixedPriceMay2014Page fixedPriceMay2014Page = new FixedPriceMay2014Page();
    	fixedPriceMay2014Page.navigateToElecAcquisitionPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToDualOrderPage() {
    	FixedPriceMay2014Page fixedPriceMay2014Page = new FixedPriceMay2014Page();
    	fixedPriceMay2014Page.navigateToDualAcquisitionPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToEnergySmartDualOrderPage() {
    	FixedPriceMay2014Page fixedPriceMay2014Page = new FixedPriceMay2014Page();
    	fixedPriceMay2014Page.navigateToEnergySmartDualOrderPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToEnergySmartElectricityOrderPage() {
    	FixedPriceMay2014Page fixedPriceMay2014Page = new FixedPriceMay2014Page();
    	fixedPriceMay2014Page.navigateToEnergySmartElectricityOrderPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToEnergySmartGasOrderPage() {
    	FixedPriceMay2014Page fixedPriceMay2014Page = new FixedPriceMay2014Page();
    	fixedPriceMay2014Page.navigateToEnergySmartGasOrderPage();
        return new AcquisitionAction();
    }


   
}
