package bg.framework.app.functional.action.selfServe;

import bg.framework.app.functional.page.selfServe.BillHistoryPage;

public class BillHistoryAction {
	
	
	public AccountOverviewAction verifyAndViewBills(){
		BillHistoryPage verifyAndViewBills=new BillHistoryPage();
		verifyAndViewBills.verifyAndViewBills();
		return new AccountOverviewAction();
	}

	public BillHistoryAction viewDifferentStatements(){
		BillHistoryPage viewDifferentBill=new BillHistoryPage();
		viewDifferentBill.viewDifferentStatements();
		return this;
	}
}
