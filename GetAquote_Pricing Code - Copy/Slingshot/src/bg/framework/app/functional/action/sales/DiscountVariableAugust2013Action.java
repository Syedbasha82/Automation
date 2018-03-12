package bg.framework.app.functional.action.sales;


import bg.framework.app.functional.page.sales.DiscountVariableAugust2013Page;



public class DiscountVariableAugust2013Action {
    public AcquisitionAction navigateToGasOrderPage() {
    	DiscountVariableAugust2013Page discountVariableAugust2013Page = new DiscountVariableAugust2013Page();
    	discountVariableAugust2013Page.navigateToGasAcquisitionPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToElecOrderPage() {
    	DiscountVariableAugust2013Page discountVariableAugust2013Page = new DiscountVariableAugust2013Page();
    	discountVariableAugust2013Page.navigateToElecAcquisitionPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToDualOrderPage() {
    	DiscountVariableAugust2013Page discountVariableAugust2013Page = new DiscountVariableAugust2013Page();
    	discountVariableAugust2013Page.navigateToDualAcquisitionPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToEnergySmartDualOrderPage() {
    	DiscountVariableAugust2013Page discountVariableAugust2013Page = new DiscountVariableAugust2013Page();
    	discountVariableAugust2013Page.navigateToEnergySmartDualOrderPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToEnergySmartElectricityOrderPage() {
    	DiscountVariableAugust2013Page discountVariableAugust2013Page = new DiscountVariableAugust2013Page();
    	discountVariableAugust2013Page.navigateToEnergySmartElectricityOrderPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToEnergySmartGasOrderPage() {
    	DiscountVariableAugust2013Page discountVariableAugust2013Page = new DiscountVariableAugust2013Page();
    	discountVariableAugust2013Page.navigateToEnergySmartGasOrderPage();
        return new AcquisitionAction();
    }


    
}
