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
		 //new AccountOverviewPage().verifyCustomerAddress(accountNumber);
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
	 public AccountSummaryAction navigateToAccountSummaryPage01(){		
		 AccountOverviewAction accountOverviewAction= new AccountOverviewAction();
		 accountOverviewAction.navigateToAccountSummaryPage01();
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
	 public BookingCompleteAction navigateToAccountSummaryPageAsv(UserProfile userProfile){		
		 AccountOverviewAction accountOverviewAction= new AccountOverviewAction();
		 accountOverviewAction.navigateToAccountSummaryPage(userProfile);
	 return new BookingCompleteAction();
	 }
	 public BookingCompleteAction navigateToBookAnEngineerNow(){		
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
	 public AccOverviewAction verifyDebitandCredit(UserProfile userProfile){
		 new AccountOverviewPage().verifyDebitandCredit(userProfile);
		 return this;
	 }
	 public BookingCompleteAction navigateToFirstServiceVisitPageASV(){		
		 AccountOverviewAction accountOverviewAction= new AccountOverviewAction();
		 accountOverviewAction.navigateToFVAccountSummaryPage(userProfile);
	 return new BookingCompleteAction();
	 }

 /*-----------------------------------------------SMB Phase 2-------------------------------------------------- */
	 
	 	 
		public AccOverviewAction clickManageAccount(){
			AccountOverviewPage AOpage = new AccountOverviewPage();
			AOpage.clickManageAccount();
			return this;
		}
		public AccOverviewAction clickChangeBillDate(){
			AccountOverviewPage AOpage = new AccountOverviewPage();
			AOpage.clickChangeBillDate();
			return this;
		}
		
		public AccOverviewAction selectDateDropDown(){
			AccountOverviewPage AOpage = new AccountOverviewPage();
			AOpage.selectDateDropDown();
			return this;
		}
		
		public AccOverviewAction clickSubmitButton(){
			AccountOverviewPage AOpage = new AccountOverviewPage();
			AOpage.clickSubmitButton();
			return this;
		}
		public AccOverviewAction validateChangeBillDate(){
			AccountOverviewPage AOpage = new AccountOverviewPage();
			AOpage.validateChangeBillDate();
			return this;
		}
		
		public AccOverviewAction ChangebillDateDB(){
			AccountOverviewPage AOpage = new AccountOverviewPage();
			AOpage.ChangebillDateDB();
			return this;
		}
				
		public AccOverviewAction viewLatestStatement(){
			AccountOverviewPage AOpage = new AccountOverviewPage();
			AOpage.viewLatestStatement();
			return this;
		}
		
		public AccOverviewAction verifyFirstBillNotification(){
			AccountOverviewPage AOpage = new AccountOverviewPage();
			AOpage.verifyFirstBillNotification();
			return this;
		}
		
		public AccOverviewAction selectAddress(){
			AccountOverviewPage AOpage = new AccountOverviewPage();
			AOpage.selectAddress();
			return this;
		}
		
		
		public AccOverviewAction openSMBUrl(){
			AccountOverviewPage AOpage = new AccountOverviewPage();
			AOpage.openSMBUrl();
			return this;
		}




}
