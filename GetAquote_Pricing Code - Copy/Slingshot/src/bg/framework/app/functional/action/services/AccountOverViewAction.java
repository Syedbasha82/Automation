package bg.framework.app.functional.action.services;

import bg.framework.app.functional.page.services.AccountOverViewPage;
import bg.framework.app.functional.page.services.AccountSummaryPage;

public class AccountOverViewAction {

	public AccountSummaryAction navigateToAccountSummaryAction(String accountNumber){
		AccountOverViewPage accountOverViewPage=new AccountOverViewPage();
		accountOverViewPage.clickManageAccount(accountNumber);
		return new AccountSummaryAction();
	}
	
	
}
