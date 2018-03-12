package bg.framework.app.functional.action.sales;


import bg.framework.app.functional.page.sales.OnlineVariableAugustPage;
/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 25/01/12
 * Time: 16:04
 * To change this template use File | Settings | File Templates.
 */
public class OnlineVariableAugust2013Action {
    public AcquisitionAction navigateToGasOrderPage() {
    	OnlineVariableAugustPage onlineVariableAugustPage = new OnlineVariableAugustPage();
    	onlineVariableAugustPage.navigateToGasAcquisitionPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToElecOrderPage() {
    	OnlineVariableAugustPage onlineVariableAugustPage = new OnlineVariableAugustPage();
    	onlineVariableAugustPage.navigateToElecAcquisitionPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToDualOrderPage() {
    	OnlineVariableAugustPage onlineVariableAugustPage = new OnlineVariableAugustPage();
    	onlineVariableAugustPage.navigateToDualAcquisitionPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToEnergySmartDualOrderPage() {
    	OnlineVariableAugustPage onlineVariableAugustPage = new OnlineVariableAugustPage();
    	onlineVariableAugustPage.navigateToEnergySmartDualOrderPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToEnergySmartElectricityOrderPage() {
    	OnlineVariableAugustPage onlineVariableAugustPage = new OnlineVariableAugustPage();
    	onlineVariableAugustPage.navigateToEnergySmartElectricityOrderPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction navigateToEnergySmartGasOrderPage() {
    	OnlineVariableAugustPage onlineVariableAugustPage = new OnlineVariableAugustPage();
    	onlineVariableAugustPage.navigateToEnergySmartGasOrderPage();
        return new AcquisitionAction();
    }


    
}
