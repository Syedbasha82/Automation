package bg.framework.app.functional.action.reFactoring;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.AccountOverviewPage;
import bg.framework.app.functional.page.reFactoring.AccountSummaryPage;
import bg.framework.app.functional.page.reFactoring.PaymentHistoryPage;



public class AccountSummaryAction{
	private UserProfile userProfile;
	
	
	public AccountSummaryAction(){
		
	}
	public  AccountSummaryAction(UserProfile userProfile){
	this.userProfile=userProfile;	
	}

	 public PBFlagAction navigateToPbFlagPage(){
	    AccountSummaryPage accountsummaryPage=new AccountSummaryPage();
	    accountsummaryPage.clickSeeYourStatementLink();
	    accountsummaryPage.clickGoPaperLessLink();
	    return new PBFlagAction(userProfile);    	
	    }
	 
	 public AccountSummaryAction serviceNotDueAction(){
		 AccountSummaryPage accountsummaryPage=new AccountSummaryPage();
		 accountsummaryPage.verifyServiceNotDue();
		 return this;
	 }
	 
	 public AccountSummaryAction serviceDueAction(){
		 AccountSummaryPage accountsummaryPage=new AccountSummaryPage();
		 accountsummaryPage.verifyServiceIsDue();
		 return this;
	 }
	 public AccountSummaryAction verifyAccountSummaryPageAction(String accountNumber){
		 AccountSummaryPage accountsummaryPage=new AccountSummaryPage();
		// accountsummaryPage.crossCellVerification();
		 accountsummaryPage.verifyAccountSummaryPage(accountNumber);
		 return this;
	 }
	public AccountSummaryAction verifyAccountSummaryPageTOU(String accountNumber){
		 AccountSummaryPage accountsummaryPage=new AccountSummaryPage();
		// accountsummaryPage.crossCellVerification();
		 accountsummaryPage.verifyAccountSummaryPageTOU(accountNumber);
		 return this;
	 
	 }
	 public AccOverviewAction navigateToAccountOverview(){
		 AccountSummaryPage accountsummaryPage=new AccountSummaryPage();
		 accountsummaryPage.clickViewAllAccounts();
		 return new AccOverviewAction();
	 }
	 public AccountSummaryAction verifyAccountSummaryCrossCellAction(){
		 AccountSummaryPage accountsummaryPage=new AccountSummaryPage();
		 accountsummaryPage.crossCellVerification();
		 return this;
	 }
	 
	 public AccountSummaryAction verifiyAccountSummaryForSSOandWTPAction(){
		 AccountSummaryPage accountsummaryPage=new AccountSummaryPage();
		 accountsummaryPage.verifySSOAccount();
		 return this;
	 }
	 public AccountSummaryAction logout() {
		 AccountSummaryPage accountsummaryPage=new AccountSummaryPage();
		 accountsummaryPage.logout();
		return this;
	}
	 
	 public AccountSummaryAction verifyPBFlagLinkAction(){
		 AccountSummaryPage accountsummaryPage=new AccountSummaryPage();
		 accountsummaryPage.clickSeeYourStatementLink();
		 accountsummaryPage.pbFlagLinkNonExistverification();
		 return this;
	 }
	 public AccountSummaryAction navigatelinkPaperlesslink(){
		 AccountSummaryPage accountsummaryPage=new AccountSummaryPage();
		 accountsummaryPage.navigaelinkPaperlesslink();
		 return this;
	 }
	 
	 public AccountSummaryAction verifyingLinks(){
		 AccountSummaryPage accountSummaryPage= new AccountSummaryPage();
		 accountSummaryPage.verifyingLinksAccountSummaryPage();
		 return this;
	 }
	 
	 public PaymentHistoryAction verifyPaymentHistory(UserProfile userProfile){
	    	PaymentHistoryPage paymentHistoryPage = new PaymentHistoryPage();
	    	paymentHistoryPage.paymentsHistoryLinkValidation();
	        return new PaymentHistoryAction();
	    	
	    }
	
}
