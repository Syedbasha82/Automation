package bg.framework.app.functional.action.sales;

import bg.framework.app.functional.page.sales.BoilerReplacePage;

public class BoilerReplaceAction {
	
	public BoilerReplaceAction navigateToBoilerReplacePage(){
		new BoilerReplacePage().navigateToBoilerReplacePage();
		return new BoilerReplaceAction();
	}
	
	public BoilerReplaceAction validateGCNBoilerReplace(){
		new BoilerReplacePage().validateGCNBoilerReplace();
		return new BoilerReplaceAction();
	}
	
	public BoilerReplaceAction validateBoilersReplace(){
		new BoilerReplacePage().validateBoilersReplace();
		return new BoilerReplaceAction();
	}
}
