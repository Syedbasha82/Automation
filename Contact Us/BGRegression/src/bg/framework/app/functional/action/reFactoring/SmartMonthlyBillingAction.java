package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.page.reFactoring.SmartMonthlyBillingPage;

public class SmartMonthlyBillingAction {
	
	public SmartMonthlyBillingAction navigateToSMB(){
		SmartMonthlyBillingPage SMBPage=new SmartMonthlyBillingPage();
		SMBPage.navigateToSMB();
		
		return this;
		
	}
	
	public SmartMonthlyBillingAction verifyTrilliantErrorMsg(){
		SmartMonthlyBillingPage SMBPage=new SmartMonthlyBillingPage();
		SMBPage.verifyTrilliantErrorMsg();
		
		return this;
		
	}

}
