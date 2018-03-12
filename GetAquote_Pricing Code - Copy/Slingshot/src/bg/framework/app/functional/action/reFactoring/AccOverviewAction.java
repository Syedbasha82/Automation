package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.page.reFactoring.AccountOverviewPage;
import bg.framework.app.functional.page.reFactoring.PBFlagPage;
import bg.framework.app.functional.page.reFactoring.PaymentHistoryPage;
import bg.framework.app.functional.action.reFactoring.PaymentHistoryAction;



public class AccOverviewAction {
	private UserProfile userProfile;
	
	public AccOverviewAction(){
		
	}
	public AccOverviewAction(UserProfile userProfile){
	this.userProfile=userProfile;	
	}
	 public AccOverviewAction accountOverviewLogInUserValidation(UserProfile userProfile) {
	        new AccountOverviewPage().accountOverviewLogInUserValidation(userProfile);
	        return new AccOverviewAction();
	    }
	 public LoginAction logout() {
	        new AccountOverviewPage().logout();
	        return new LoginAction();
	    }
	
	 public AccOverviewAction verifyAccountOverviewAction(){
		 new AccountOverviewPage().AccountOverViewVerification(userProfile);
		 return this;
	 }
	 
	 public AccOverviewAction verifyAddress(String accountNumber){
		 new AccountOverviewPage().verifyCustomerAddress(accountNumber);
		return this;		 
	 }
//	 public AccOverviewAction setAccountNumberAction(String accountNumber,UserProfile userProfile ){
//		 userProfile.setAccNumber(accountNumber);
//		 return this;
//	 }
	 
	 public AccOverviewAction setAccountNumber(String accountNumber,UserProfile userProfile){
		 userProfile.setAccNumber(accountNumber);
		 return new AccOverviewAction(userProfile);
	 }
	 
	 public AccountSummaryAction navigateToAccountSummaryPage(){		
		 AccountOverviewAction accountOverviewAction= new AccountOverviewAction();
		 accountOverviewAction.navigateToAccountSummaryPage(userProfile);
	 return new AccountSummaryAction(userProfile);
	 }
	 public AccOverviewAction addMissingAccountverification( ) {
	        new AccountOverviewPage().verifyAddMissingAccount();
	        return new AccOverviewAction();
	 }
	 public AccOverviewAction verifybrowserback( ) {
	        new AccountOverviewPage().verifyBrowserback();
	        return new AccOverviewAction();
	 }
	 public AccOverviewAction verifyNectarPage( ) {
	        new AccountOverviewPage().registerNectarPage();
	        return new AccOverviewAction();
	 }
	 
	 public BookingCompleteAction navigateToAccountSummaryPageASV(){		
		 AccountOverviewAction accountOverviewAction= new AccountOverviewAction();
		 accountOverviewAction.navigateToAccountSummaryPage(userProfile);
	 return new BookingCompleteAction();
	 }
	 public IBAction navigateToAccountSummaryPageIB(){		
		 AccountOverviewAction accountOverviewAction= new AccountOverviewAction();
		 accountOverviewAction.navigateToAccountSummaryPage(userProfile);
	 return new IBAction();
	 }
	 public AccOverviewAction calllogs(UserProfile userProfile) {
	  	  LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
	  	  String strStatus = "Active";	
	      legacyLoginPage.calllogs_test(strStatus, userProfile.getAccNumber(),userProfile.getUCRN());
	 return this;
	 }
	 
	 
}
