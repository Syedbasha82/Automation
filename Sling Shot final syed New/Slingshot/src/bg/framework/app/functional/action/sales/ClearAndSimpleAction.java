package bg.framework.app.functional.action.sales;


import bg.framework.app.functional.page.sales.ClearAndSimplePage;

public class ClearAndSimpleAction {
    public AcquisitionAction navigateToGasOrderPage() {
    	ClearAndSimplePage clearAndSimplePage = new ClearAndSimplePage();
    	clearAndSimplePage.navigateToGasAcquisitionPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToElecOrderPage() {
    	ClearAndSimplePage clearAndSimplePage = new ClearAndSimplePage();
    	clearAndSimplePage.navigateToElecAcquisitionPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToDualOrderPage() {
    	ClearAndSimplePage clearAndSimplePage = new ClearAndSimplePage();
    	clearAndSimplePage.navigateToDualAcquisitionPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToEnergySmartDualOrderPage() {
    	ClearAndSimplePage clearAndSimplePage = new ClearAndSimplePage();
    	clearAndSimplePage.navigateToEnergySmartDualOrderPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToEnergySmartElectricityOrderPage() {
    	ClearAndSimplePage clearAndSimplePage = new ClearAndSimplePage();
    	clearAndSimplePage.navigateToEnergySmartElectricityOrderPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToEnergySmartGasOrderPage() {
    	ClearAndSimplePage clearAndSimplePage = new ClearAndSimplePage();
    	clearAndSimplePage.navigateToEnergySmartGasOrderPage();
        return new AcquisitionAction();
    }


   
}
