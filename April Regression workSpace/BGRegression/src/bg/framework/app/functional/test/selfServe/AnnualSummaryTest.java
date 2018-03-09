package bg.framework.app.functional.test.selfServe;

import static bg.framework.app.functional.entities.FunctionalCategory.MakeAPayment;
import static bg.framework.app.functional.entities.FunctionalCategory.PaymentHistory;

import java.text.ParseException;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.reFactoring.AccountSummaryAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.action.selfServe.AnnualSummaryAction;
import bg.framework.app.functional.action.selfServe.BillHistoryAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;


/////////////////////////////////////////////////////////////////GAS Account/////////////////////////////////////////////////////////////////////////////////////////
public class AnnualSummaryTest extends TestBase {	 
	@Test(groups = {MakeAPayment})
	 public void verifyAnnualSummaryHistoryForGasCustomer(){
	 Report.createTestLogHeader("Annual Summary History Journey", "To Verify Annual Summary History For Gas Customer");	 
	 UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	 String AccountType="Gas";
	 new HomePageAction()
     .navigateToLogin()
     .login(userProfile);
	 new AccountOverviewAction ()
	     .navigateToAccountSummaryPage(userProfile);
	 new AnnualSummaryAction ()
	      .navigateToBillHistory()
	     .navigateToAnnualSummaryPage()
	     .verifyAnnualSummarypage()
	     .annualSummaryVerification(AccountType);
	  new AccountOverviewAction()
		 .logout();	 
	}
/////////////////////////////////////////////////////////////////Electricity Account/////////////////////////////////////////////////////////////////////////////////	 
	  @Test(groups = {MakeAPayment})
		 public void verifyAnnualSummaryHistoryForElectricityCustomer(){
		  Report.createTestLogHeader("Annual Summary History Journey", "To Verify Annual Summary History For electricity Customer");
		  
		// Report.createTestLogHeader("Annual Summary History Journey", "To Verify Annual Summary History For electricity Customer");	 
		 UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		 String AccountType="Electricity";
		 new HomePageAction()
		     .navigateToLogin()
		     .login(userProfile);
		 new AccountOverviewAction ()
		     .navigateToAccountSummaryPage(userProfile);
		 new AnnualSummaryAction ()
		      .navigateToBillHistory()
		     .navigateToAnnualSummaryPage()
		     .verifyAnnualSummarypage()
		     .annualSummaryVerification(AccountType);
		  new AccountOverviewAction()
			 .logout();	 
	  }
//////////////////////////////////////////////////////////////JI Account///////////////////////////////////////////////////////////////////////////////////////////	     
		  @Test(groups = {MakeAPayment})
			 public void verifyAnnualSummaryHistoryForJICustomer(){
			 Report.createTestLogHeader("Annual Summary History Journey", "To Verify Annual Summary History For JI Customer");	 
			 UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
			 String AccountType="JI";
			 new HomePageAction()
			     .navigateToLogin()
			     .login(userProfile);
			 new AccountOverviewAction ()
			     .navigateToAccountSummaryPage(userProfile);
			 new AnnualSummaryAction ()
			 .navigateToBillHistory()
			     .navigateToAnnualSummaryPage()
			     .verifyAnnualSummarypage()
			     .annualSummaryVerification(AccountType);
			  new AccountOverviewAction()
				 .logout();	 
		  }
			  
/////////////////////////////////////////////////////DUAL Account//////////////////////////////////////////////////////////////////////////////////////////			  
			  @Test(groups = {MakeAPayment})
				 public void verifyAnnualSummaryHistoryForDualCustomer(){
				 Report.createTestLogHeader("Annual Summary History Journey", "To Verify Annual Summary History For Dual Customer");	 
				 UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
				 String AccountType="Dual";
				 new HomePageAction()
				     .navigateToLogin()
				     .login(userProfile);
				 new AccountOverviewAction ()
				     .navigateToAccountSummaryPage(userProfile);
				 new AnnualSummaryAction ()
				 .navigateToBillHistory()
				     .navigateToAnnualSummaryPage()
				     .verifyAnnualSummarypage()
				     .annualSummaryVerification(AccountType);
				  new AccountOverviewAction()
					 .logout();	 	     	    
	     
	 }
			  
//////////////////////////////////////////////////////////////////////////////Multi Premise Customer////////////////////////////////////////////////////////		  
			  @Test(groups = {MakeAPayment})
				 public void verifyAnnualSummaryHistoryForMultiPremiseCustomer(){
				 Report.createTestLogHeader("Annual Summary History Journey", "To Verify Annual Summary History For Dual Customer in multiple premise");	 
				 UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
				 String AccountType="Dual";
				 new AnnualSummaryAction()
				 .navigateToAnnualSummaryThroughDeepLink();
				 new HomePageAction()
				 .navigateToLogin()
				 .login(userProfile);
				 new AnnualSummaryAction ()
				 .clickViewPDFLink(userProfile)
				 .verifyAnnualSummarypage()
				 .annualSummaryVerification(AccountType);
				 new AccountOverviewAction()
				 .logout();	 	     	    
	     
	 }
	
	
}


   
