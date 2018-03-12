package bg.framework.app.functional.action.Slingshot;

import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.page.reFactoring.AccountOverviewPage;
import bg.framework.app.functional.page.reFactoring.PBFlagPage;
import bg.framework.app.functional.page.reFactoring.PaymentHistoryPage;
import bg.framework.app.functional.action.reFactoring.BookingCompleteAction;
import bg.framework.app.functional.action.reFactoring.IBAction;
import bg.framework.app.functional.action.reFactoring.PaymentHistoryAction;
import bg.framework.app.functional.page.Slingshot.AccoOverviewPage;
import bg.framework.app.functional.page.Slingshot.AccountSummaryPage;


public class AccoOverviewAction {
	private UserProfile userProfile;

	public AccoOverviewAction(){

	}
	public AccoOverviewAction(UserProfile userProfile){
		this.userProfile=userProfile;	
	}
	public AccoOverviewAction accountOverviewLogInUserValidation(UserProfile userProfile) {
		new AccountOverviewPage().accountOverviewLogInUserValidation(userProfile);
		return new AccoOverviewAction();
	}
	public LoginAction logout() {
		new AccoOverviewPage().logout();
		return new LoginAction();
	}

	public AccoOverviewAction verifyAccountOverviewAction(){
		new AccountOverviewPage().AccountOverViewVerification(userProfile);
		return this;
	}

	public AccoOverviewAction verifyAddress(String accountNumber){
		new AccountOverviewPage().verifyCustomerAddress(accountNumber);
		return this;		 
	}
	public AccoOverviewAction setAccountNumber(String accountNumber,UserProfile userProfile){
		userProfile.setAccNumber(accountNumber);
		return new AccoOverviewAction(userProfile);
	}

	public AccoOverviewAction addMissingAccountverification( ) {
		new AccountOverviewPage().verifyAddMissingAccount();
		return new AccoOverviewAction();
	}
	public AccoOverviewAction verifybrowserback( ) {
		new AccountOverviewPage().verifyBrowserback();
		return new AccoOverviewAction();
	}
	public AccoOverviewAction verifyNectarPage( ) {
		new AccountOverviewPage().registerNectarPage();
		return new AccoOverviewAction();
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
	public AccoOverviewAction calllogs(UserProfile userProfile) {
		LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
		String strStatus = "Active";	
		legacyLoginPage.calllogs_test(strStatus, userProfile.getAccNumber(),userProfile.getUCRN());
		return this;
	}

	public AccountSummaryAction BgbverifyLogin(String lastname, String accNumber) {
		AccoOverviewPage AccoOver = new  AccoOverviewPage();
		AccoOver.AccountOverViewVerification(userProfile);
		return new AccountSummaryAction();
	}

}
