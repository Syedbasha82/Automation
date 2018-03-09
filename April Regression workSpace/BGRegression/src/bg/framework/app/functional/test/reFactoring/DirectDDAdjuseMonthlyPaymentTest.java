package bg.framework.app.functional.test.reFactoring;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.action.reFactoring.AccOverviewAction;
import bg.framework.app.functional.action.reFactoring.PPMateAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.FunctionalCategory;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

import org.testng.annotations.Test;
import bg.framework.app.functional.action.reFactoring.AccountSummaryAction;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.reFactoring.DirectDDAdjuseMonthlyPaymentAction;
import static bg.framework.app.functional.entities.FunctionalCategory.MonthlyPayment;

public class DirectDDAdjuseMonthlyPaymentTest extends TestBase {
	
/*
 * May 26th Release 	
 */
	
/***
 *11743  Ensure customers recommended installment is not lower than minimum installment
 ***/	
	
	@Test(groups = {MonthlyPayment})
	public void VerifytheMinimumamount_fordebitaccount(){
		 Report.createTestLogHeader("Compare the Direct Debit Amount","with the New Payment ");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		new HomePageAction()
        .navigateToLogin()
        .login(userProfile)
	    .navigateToAccountSummaryPage(userProfile);	
		new DirectDDAdjuseMonthlyPaymentAction()
		.navigatetoManageyourdirectdebitPage()
		.navigatetoMonthlyPaymentPage()
		.verifyPaymentAmount()
		.verifysmallnumber()
		.ComparePaymentAmount()
		.EnterPaymentAmount()
		.ValidateAdjustmentAmount()
		.VerifyConfirmationPage();
			
	  }
	
	
	
	
	@Test(groups = {MonthlyPayment})
	public void VerifytheMinimumamount_forcreditaccount(){
		 Report.createTestLogHeader("Compare the Direct Debit Amount","with the New Payment ");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		new HomePageAction()
        .navigateToLogin()
        .login(userProfile)
	    .navigateToAccountSummaryPage(userProfile);	
		//new DirectDDAdjuseMonthlyPaymentAction()
		
	}
	
	
	}
	
	
	


