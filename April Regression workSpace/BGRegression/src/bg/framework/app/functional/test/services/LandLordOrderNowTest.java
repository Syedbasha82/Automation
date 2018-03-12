package bg.framework.app.functional.test.services;

import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import static bg.framework.app.functional.entities.FunctionalCategory.SalesRegressionAnonymous;
import static bg.framework.app.functional.entities.FunctionalCategory.Services;

import java.util.ArrayList;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.services.GetAQuoteAction;
import bg.framework.app.functional.action.services.NavigationAction;
import bg.framework.app.functional.entities.LandLord;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class LandLordOrderNowTest extends TestBase{

	@Test(groups = {Regression, Services,SalesRegressionAnonymous})
    public void batchProcessDebitDCP12() {
       Report.createTestLogHeader("LandLord", "Batch process test using Anonymous user with direct -debit CP12");
       final LandLord landLord= new TestDataHelper().getLandLord("gas");
      
       ArrayList<Object> price = new NavigationAction(landLord) 
       		 .navigateToLoginPage().loginAction(landLord)
 			 .navigateToLandLordAction()             
             .singleEntryTellUsAction()
             .packageAction().selectAddOnAction(1)
             .nextPropertyAction().getAQuoteAction()
             .verifyTotalPriceAction();
       String date=new OnlineDBConnector().DBsysdate();
         new GetAQuoteAction(landLord)
             .orderNowAction()
             .contactUsAction(landLord)
             .standAloneCP12DebitDAction(price)
             .termsAndConditionAction(date)
             .batch(date);             
	}
	
	@Test(groups = {Regression,Services,SalesRegressionAnonymous})
    public void batchProcessCreditDCP12() {
       Report.createTestLogHeader("LandLord", "Batch process test using Anonymous user with credit -debit CP12");
       final LandLord landLord= new TestDataHelper().getLandLord("gas");
       
       ArrayList<Object> price = new NavigationAction(landLord)             
 			 .navigateToLandLordAction()             
             .singleEntryTellUsAction()
             .packageAction().selectAddOnAction(1)
             .nextPropertyAction().getAQuoteAction()
             .verifyTotalPriceAction();
       String date=new OnlineDBConnector().DBsysdate();
       new GetAQuoteAction(landLord)
             .orderNowAction()
             .contactUsAction(landLord)
             .standAloneCP12CreditDAction(price)
             .termsAndConditionAction(date)
             .batch(date);                           
	}
	
	@Test(groups = {Regression,Services,SalesRegressionAnonymous})
    public void batchProcessCreditDHC() {
       Report.createTestLogHeader("LandLord", "Batch process test using Anonymous user with credit debit -Home care ");
       final LandLord landLord= new TestDataHelper().getLandLord("credit");      
       ArrayList<Object> price = new NavigationAction(landLord)             
 			 .navigateToLandLordAction()             
             .singleEntryTellUsAction()
             .packageAction().selectAddOnAction(1)
             .nextPropertyAction().getAQuoteAction()
             .verifyTotalPriceAction();
       String date=new OnlineDBConnector().DBsysdate();
       new GetAQuoteAction(landLord)
             .orderNowAction()
             .contactUsAction(landLord)
             .payForHomeCCreditDAction(price)
             .termsAndConditionAction(date)
             .batch(date);                           
	}
	
	@Test(groups = {Regression,Services,SalesRegressionAnonymous})
	 public void batchProcessAnnualDHC() {
	       Report.createTestLogHeader("LandLord", "Batch process test using Anonymous user with Annual debit -Home care ");
	       final LandLord landLord= new TestDataHelper().getLandLord("homecare");
	       
	       ArrayList<Object> price = new NavigationAction(landLord)             
	 			 .navigateToLandLordAction()             
	             .singleEntryTellUsAction()
	             .packageAction().selectAddOnAction(1)
	             .nextPropertyAction().getAQuoteAction()
	             .verifyTotalPriceAction();
	       String date=new OnlineDBConnector().DBsysdate();
	       new GetAQuoteAction(landLord)
	             .orderNowAction()
	             .contactUsAction(landLord)
	             .payForHomeCAnnualDebitDAction(price)
	             .termsAndConditionAction(date)
	             .batch(date);  	                        
		}
	
	@Test(groups = {Regression, Services,SalesRegressionAnonymous})
    public void batchProcessMonthlyDHC() {
       Report.createTestLogHeader("LandLord", "Batch process using Anonymous user with monthly debit -Home care ");
       final LandLord landLord= new TestDataHelper().getLandLord("homecare");
       
       ArrayList<Object> price = new NavigationAction(landLord)             
 			 .navigateToLandLordAction()             
             .singleEntryTellUsAction()
             .packageAction().selectAddOnAction(1)
             .nextPropertyAction().getAQuoteAction()
             .verifyTotalPriceAction();
       String date=new OnlineDBConnector().DBsysdate();
       new GetAQuoteAction(landLord)
             .orderNowAction()
             .contactUsAction(landLord)
             .payForHomeCDebitDAction(price)
             .termsAndConditionAction(date)
             .batch(date);                           
	}
	
	
	
	@Test(groups = {Regression, Services,SalesRegressionAnonymous})
	 public void batchProcessCP12AndDHC() {
	       Report.createTestLogHeader("LandLord", "Batch process using Anonymous user with dedit card for multi property");
	       final LandLord landLord= new TestDataHelper().getLandLord("gas");
	      
	       ArrayList<Object> price = new NavigationAction(landLord)             
	 			 .navigateToLandLordAction()             
	             .multiEntryTellUsAction(5)
	             .selectMultiAddPackageAction()
	             .getAQuoteAction()
	             .verifyTotalPriceAction();
	       String date=new OnlineDBConnector().DBsysdate();
	       new GetAQuoteAction(landLord)
	             .orderNowAction()
	             .contactUsAction(landLord)
	             .standAloneCP12DebitDAction(price)
	             .payForHomeCDebitDAction(price)
	             .termsAndConditionAction(date)
	             .batch(date);  	                         
		}
	
	@Test(groups = {Regression,Services})
    public void contactUsOAMErrorMessageTest() {
        Report.createTestLogHeader("LandLord", "Error Message verification for OAM customer");
       final LandLord landLord= new TestDataHelper().getLandLord("OAM");
             new NavigationAction(landLord) 
             .navigateToLoginPage()
             .loginAction(landLord)
 			 .navigateToLandLordAction()             
             .singleEntryTellUsAction()
             .packageAction().selectAddOnAction(1)
             .nextPropertyAction().getAQuoteAction()
             .orderNowAction()
             .verifyOrderNowAction()
             .contactPrePopulatedAction();
	}
	
	@Test(groups = {Regression,Services})
    public void contactUsErrorMessageTest() {
        Report.createTestLogHeader("LandLord", "Error Message verification in contact us section  CP12");
       final LandLord landLord= new TestDataHelper().getLandLord("homecare");
             new NavigationAction(landLord)             
 			 .navigateToLandLordAction()             
             .singleEntryTellUsAction()
             .packageAction().selectAddOnAction(1)
             .nextPropertyAction().getAQuoteAction()
             .orderNowAction()
             .verifyOrderNowAction()
             .contactUsErrorAction();                        
	}
	
	@Test(groups = { Regression,Services})
    public void contactUsEditMessageTest() {
        Report.createTestLogHeader("LandLord", "Editing contact us in customer section  CP12");
       final LandLord landLord= new TestDataHelper().getLandLord("gas");
             new NavigationAction(landLord)             
 			 .navigateToLandLordAction()             
             .singleEntryTellUsAction()
             .packageAction().selectAddOnAction(1)
             .nextPropertyAction().getAQuoteAction()
             .orderNowAction()
             .verifyOrderNowAction()
             .editContactUsAction();                                    
	}
			
	@Test(groups = { Regression, Services})
	 public void errorMessageGSC() {
	       Report.createTestLogHeader("LandLord", "Error message verification for GSC");
	       final LandLord landLord= new TestDataHelper().getLandLord("gas");	     
	       new NavigationAction(landLord)             
	 			 .navigateToLandLordAction()             
	             .singleEntryTellUsAction()
	             .packageAction().selectAddOnAction(1)
	             .nextPropertyAction().getAQuoteAction()
	             .verifyTotalPriceAction();
	       new GetAQuoteAction(landLord).orderNowAction()
	             .verifyOrderNowAction()
	             .contactUsAction(landLord)
	             .standAloneErrorAction();
	}
	
	@Test(groups = {Regression,  Services})
	 public void errorMessageHC() {
	       Report.createTestLogHeader("LandLord", "Error message verification for Home Care");
	       final LandLord landLord= new TestDataHelper().getLandLord("homecare");	     
	       new NavigationAction(landLord)             
	 			 .navigateToLandLordAction()             
	             .singleEntryTellUsAction()
	             .packageAction().selectAddOnAction(1)
	             .nextPropertyAction().getAQuoteAction()
	             .verifyTotalPriceAction();
	       new GetAQuoteAction(landLord).orderNowAction()
	             .verifyOrderNowAction()
	             .contactUsAction(landLord)
	             .payForPackageErrorAction();
	}
	
	
	@Test(groups = { Regression, Services})
	 public void accountSummaryOAM() {
	       Report.createTestLogHeader("LandLord", "Account summary book appointment");
	       final LandLord landLord= new TestDataHelper().getLandLord("BookEng");	     
	       new NavigationAction(landLord) 
	       		.navigateToLoginPage()
	       		.loginAction(landLord)
	       		.verifyAccountOverViewAction()
	       		.navigateToAccountSummaryAction(landLord.getAccountNumber())
	       		.bookAppointmentAction();
	}
	
	@Test(groups = {  Regression,Services})
	 public void accountSummaryBookEngOAM() {
	       Report.createTestLogHeader("LandLord", "Account summary Book engineer");
	       final LandLord landLord= new TestDataHelper().getLandLord("BookEng");	     
	       new NavigationAction(landLord) 
	       		.navigateToLoginPage()
	       		.loginAction(landLord)
	       		.verifyAccountOverViewAction()
	       		.navigateToAccountSummaryAction(landLord.getAccountNumber())
	       		.bookEngAppointmentAction(landLord);
	}
	
	 @Test(groups = {Regression, Services})
	 public void upCellToHC300() {
	       Report.createTestLogHeader("LandLord", "Account summary up cell to HC300");
	       final LandLord landLord= new TestDataHelper().getLandLord("HCIII");		      
	       new NavigationAction(landLord) 
	       		.navigateToLoginPage()
	       		.loginAction(landLord)
	       		.verifyAccountOverViewAction()
	       		.navigateToAccountSummaryAction(landLord.getAccountNumber())
	       		.upCellHC300Action();
	}
	 
	 @Test(groups = {Regression, Services})
	 public void upCellToHC200() {
	       Report.createTestLogHeader("LandLord", "Account summary up cell to HC200");
	       final LandLord landLord= new TestDataHelper().getLandLord("HCII");		      
	       new NavigationAction(landLord) 
	       		.navigateToLoginPage()
	       		.loginAction(landLord)
	       		.verifyAccountOverViewAction()
	       		.navigateToAccountSummaryAction(landLord.getAccountNumber())
	       		.upCellHC200Action();
	}
	 
	 @Test(groups = {Regression, Services})
	 public void upCellToHC400() {
	       Report.createTestLogHeader("LandLord", "Account summary up cell to HC400");
	       final LandLord landLord= new TestDataHelper().getLandLord("HCIV");		      
	       new NavigationAction(landLord) 
	       		.navigateToLoginPage()
	       		.loginAction(landLord)
	       		.verifyAccountOverViewAction()
	       		.navigateToAccountSummaryAction(landLord.getAccountNumber())
	       		.upCellHC400Action();
	}
	 
	 @Test(groups = {Regression, Services})
	 public void viewDairyTest() {
	       Report.createTestLogHeader("LandLord", "AccountSummary View dairy verification");
	       final LandLord landLord= new TestDataHelper().getLandLord("ViewDairy");		      
	       new NavigationAction(landLord) 
	       		.navigateToLoginPage()
	       		.loginAction(landLord)
	       		.verifyAccountOverViewAction()
	       		.navigateToAccountSummaryAction(landLord.getAccountNumber())
	       		.viewDairyAction();
	}
	 
	 @Test(groups = {Regression,Services})
	    public void optOUTCheck() {
	       Report.createTestLogHeader("LandLord", "OPT OUT Verifycation");
	       final LandLord landLord= new TestDataHelper().getLandLord("gas");
	      
	       ArrayList<Object> price = new NavigationAction(landLord) 
	       		 .navigateToLoginPage().loginAction(landLord)
	 			 .navigateToLandLordAction()             
	             .singleEntryTellUsAction()
	             .packageAction().selectAddOnAction(1)
	             .nextPropertyAction().getAQuoteAction()
	             .verifyTotalPriceAction();
	         new GetAQuoteAction(landLord).orderNowAction()
	             .verifyOrderNowAction()
	             .contactUsAction(landLord)
	             .standAloneCP12DebitDAction(price)
	             .optOutAction();
	                         
		}
	
	@Test(groups = { Regression,Services})
	 public void forgotPasswordTest() {
	       Report.createTestLogHeader("LandLord", "Forget password test");
	       UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
           activateCustomerDetailsInOnlineDB(userProfile);
           getCustomerDetailsToUserProfileOAM(userProfile);	     
	       new NavigationAction() 
	       		.navigateToLoginPage()
	       		.navigateToForgotPasswordAction()
	       		.verifyOneTimePwd(userProfile);
	      
//           new HomePageAction()
//                   .navigateToForgottenPasswordScreen()
//                   .verifyOneTimePwd(userProfile)
//                   .loginandVerifyDetails(userProfile);
	}
	
	@Test(groups = {Regression,Services})
	 public void registerNowTest() {
	       Report.createTestLogHeader("LandLord", "Registration test");
	       final LandLord landLord= new TestDataHelper().getLandLord("registration");	     
	       new NavigationAction(landLord) 	       		
	       		.navigateToRegisterNowAction()
	       		.registrationFirstStepAction()
	       		.registrationSecondStepAction();
	}
}
