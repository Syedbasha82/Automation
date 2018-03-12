package bg.framework.app.functional.test.reFactoring;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.action.reFactoring.AccOverviewAction;
import bg.framework.app.functional.action.selfServe.ChannelActivationAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.FunctionalCategory;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import static bg.framework.app.functional.entities.FunctionalCategory.PPMate;
import org.testng.annotations.Test;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.reFactoring.PPMateAction;

public class PPMateTest extends TestBase {

   @Test(groups = {PPMate})
	public void PrePayCustomerAddCardDetails(){
		 Report.createTestLogHeader("PPMate Journey", "Add Card Details - Dual Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		new HomePageAction()
        .navigateToLogin()
		.loginDetails(userProfile);
		//.navigateToAccountSummaryPage(userProfile);	
		new PPMateAction()
		.navigateToAccountSummaryPage(userProfile)
		.navigateToManagePaymentCardsPage()
		.cardStorageFunctionality();
	}
	
	@Test(groups = { PPMate })
	public void PrePayCustomerDeleteCardDetails(){
		 Report.createTestLogHeader("PPMate Journey", "Delete Card Details - Dual Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new HomePageAction()
        .navigateToLogin()
		.loginDetails(userProfile);
		new PPMateAction()
		.navigateToAccountSummaryPage(userProfile)
		.deleteCardFunctionality();
	}
	
	@Test(groups = { PPMate })
	public void verifyTopUpScenarioForGasCustomer_ExistingCard(){
		 Report.createTestLogHeader("PPMate Journey", "Top up scenario - Electricity Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		new HomePageAction()
        .navigateToLogin()
		.loginDetails(userProfile);
		//.navigateToAccountSummaryPage(userProfile);
		new PPMateAction()
		.navigateToAccountSummaryPage(userProfile)
		.navigateToTopupPage()
		//.VerifyEnterTopupamount()
		.topAndPayPageDetails()
		.verifyReviewAndConfirmPage();
	}
	
	@Test(groups = { PPMate })
	public void verifyTopUpScenarioForElectricityCustomer_ExistingCard(){
		 Report.createTestLogHeader("PPMate Journey", "Top up scenario - Electricity Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		new HomePageAction()
        .navigateToLogin()
		.loginDetails(userProfile);
		new PPMateAction()
		.navigateToAccountSummaryPage(userProfile)
		.navigateToTopupPage()
		.topAndPayPageDetails()
		.verifyReviewAndConfirmPage();
	}
	@Test(groups = { PPMate })
	public void verifyTopUpScenarioForElectricityCustomer_NewCard(){
		 Report.createTestLogHeader("PPMate Journey", "Top up scenario - Electricity Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		new HomePageAction()
        .navigateToLogin()
		.loginDetails(userProfile);
		new PPMateAction()
		.navigateToAccountSummaryPage(userProfile)
		.navigateToTopupPage()
		.VerifyAddPaymentCard()
		.VerifyEnterTopupamount()
		.AddPaymentcardFunctionality()	
		.verifyReviewAndConfirmPage();
	}
	
	@Test(groups = { PPMate })
	public void verifyTopUpScenarioForDualCustomer(){
		 Report.createTestLogHeader("PPMate Journey", "Top up scenario - Dual Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new HomePageAction()
        .navigateToLogin()
		.loginDetails(userProfile);
		new PPMateAction()
		.navigateToAccountSummaryPage(userProfile)
		.navigateToTopupPage()
		.topAndPayPageDetails()
		.verifyReviewAndConfirmPage();
	}	
	@Test(groups = { PPMate })
	public void verifyverifyUpdatePreference(){
		 Report.createTestLogHeader("PPMate Journey", "verifyUpdatePreference - Electricity Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		new HomePageAction()
        .navigateToLogin()
		.loginDetails(userProfile);
		new PPMateAction()
		.VerifynavigateToUpdateDetailsPage()
		.VerifyMeterreadfrequency()
		.updateDetailsPage();
		new HomePageAction()
		.logout();
		new HomePageAction()
        .navigateToLogin()
		.loginDetails(userProfile);
		new PPMateAction()
		.VerifynavigateToUpdateDetailsPage()
		.VerifyfrequecyMetercontent();
		
		
   }
}
	

