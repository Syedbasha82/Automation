package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.page.reFactoring.SandRToolPage;

public class SandRToolAction {

	public SandRToolAction selectQuoteStatus(){
		new SandRToolPage().selectQuoteStatus();
		return new SandRToolAction();
	}
    public SandRToolAction navigateToSummaryPage(){
    	new SandRToolPage().navigateToSummaryPage();
    	return new SandRToolAction();
    }
    public SandRToolAction navigateToWaitAdvicePage(){
    	new SandRToolPage().navigateToWaitAdvicePage();
    	return new SandRToolAction();
    }
}

