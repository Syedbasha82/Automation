package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.page.reFactoring.EnergyUsagePage;
import bg.framework.app.functional.page.reFactoring.ViewBillPage;

public class EnergyUsageAction {

	public EnergyUsageAction navigateToEnergyUsage() {
		EnergyUsagePage energy=new EnergyUsagePage();
		energy.navigateToEnergyUsage();
    	return new EnergyUsageAction();
    }

	public EnergyUsageAction verifyLinks() {
		EnergyUsagePage energy=new EnergyUsagePage();
		energy.verifyLinks();
    	return new EnergyUsageAction();
		
	}

	public EnergyUsageAction viewallbills() {
		EnergyUsagePage energy=new EnergyUsagePage();
		energy.viewallbills();
    	return new EnergyUsageAction();
		
	}

	public void logout() {
		// TODO Auto-generated method stub
		
	}

}
