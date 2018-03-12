package bg.framework.app.functional.test.selfServe;


import static bg.framework.app.functional.entities.FunctionalCategory.Acquisition;

import org.testng.annotations.Test;
import static bg.framework.app.functional.entities.FunctionalCategory.MakeAPayment;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.reFactoring.AccountSummaryAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.action.selfServe.MakeAPaymentActionNew;
import bg.framework.app.functional.entities.MakeAPaymentProfile;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class MakeApaymentTestNew extends TestBase  {
	
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyVisaCardEle() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-ElectricityAccount-VisaCard");
        int cardType=0;     
       new HomePageAction()
		       .navigateToLogin()
		       .login(userProfile);
       new MakeAPaymentActionNew()
              .makeAPaymentJourney(userProfile, cardType);
       new AccountOverviewAction()
       		.logout();
    }
	
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyMasredCardEle() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-ElectricityAccount Customer-masterCard");
        int cardType=1;     
       new HomePageAction()
		       .navigateToLogin()
		       .login(userProfile);
       new MakeAPaymentActionNew()
              .makeAPaymentJourney(userProfile, cardType);
       new AccountOverviewAction()
  		.logout();
    }
	
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyMeastroEle() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-ElectricityAccount Customer-Meastro");
        int cardType=2;     
       new HomePageAction()
		       .navigateToLogin()
		       .login(userProfile);
       new MakeAPaymentActionNew()
              .makeAPaymentJourney(userProfile, cardType);
       new AccountOverviewAction()
  		.logout();
    }

	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyVisaCardGas() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-GasAccount-VisaCard");
        int cardType=0;     
       new HomePageAction()
		       .navigateToLogin()
		       .login(userProfile);
       new MakeAPaymentActionNew()
              .makeAPaymentJourney(userProfile, cardType);
       new AccountOverviewAction()
       		.logout();
    }
	
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyMasredCardGas() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-GasAccount Customer-masterCard");
        int cardType=1;     
       new HomePageAction()
		       .navigateToLogin()
		       .login(userProfile);
       new MakeAPaymentActionNew()
              .makeAPaymentJourney(userProfile, cardType);
       new AccountOverviewAction()
  		.logout();
    }
	
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyMeastroGas() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-GasAccount Customer-Meastro");
        int cardType=2;     
       new HomePageAction()
		       .navigateToLogin()
		       .login(userProfile);
       new MakeAPaymentActionNew()
              .makeAPaymentJourney(userProfile, cardType);
       new AccountOverviewAction()
  		.logout();
    }
	
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyVisaCardJI() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-JIAccount-VisaCard");
        int cardType=0;     
       new HomePageAction()
		       .navigateToLogin()
		       .login(userProfile);
       new MakeAPaymentActionNew()
              .makeAPaymentJourney(userProfile, cardType);
       new AccountOverviewAction()
       		.logout();
    }
	
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyMasredCardJI() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-JIAccount Customer-masterCard");
        int cardType=1;     
       new HomePageAction()
		       .navigateToLogin()
		       .login(userProfile);
       new MakeAPaymentActionNew()
              .makeAPaymentJourney(userProfile, cardType);
       new AccountOverviewAction()
  		.logout();
    }
	
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyMeastroJI() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-JIAccount Customer-Meastro");
        int cardType=2;     
       new HomePageAction()
		       .navigateToLogin()
		       .login(userProfile);
       new MakeAPaymentActionNew()
              .makeAPaymentJourney(userProfile, cardType);
       new AccountOverviewAction()
  		.logout();
    }
	
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyVisaCardJIDD() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount1");
        Report.createTestLogHeader("MakeAPayment", "OAM-JIDDAccount-VisaCard");
        int cardType=0;     
       new HomePageAction()
		       .navigateToLogin()
		       .login(userProfile);
       new MakeAPaymentActionNew()
              .makeAPaymentJourney(userProfile, cardType);
       new AccountOverviewAction()
       		.logout();
    }
	
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyMasredCardJIDD() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount1");
        Report.createTestLogHeader("MakeAPayment", "OAM-JIDDAccount Customer-masterCard");
        int cardType=1;     
       new HomePageAction()
		       .navigateToLogin()
		       .login(userProfile);
       new MakeAPaymentActionNew()
              .makeAPaymentJourney(userProfile, cardType);
       new AccountOverviewAction()
  		.logout();
    }
	
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyMeastroJIDD() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount1");
        Report.createTestLogHeader("MakeAPayment", "OAM-JIDDAccount Customer-Meastro");
        int cardType=2;     
       new HomePageAction()
		       .navigateToLogin()
		       .login(userProfile);
       new MakeAPaymentActionNew()
              .makeAPaymentJourney(userProfile, cardType);
       new AccountOverviewAction()
  		.logout();
    }
	
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyVisaCardDual() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-DualAccount-VisaCard");
        int cardType=0;     
       new HomePageAction()
		       .navigateToLogin()
		       .login(userProfile);
       new MakeAPaymentActionNew()
              .makeAPaymentJourney(userProfile, cardType);
       new AccountOverviewAction()
       		.logout();
    }
	
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyMasredCardDual() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-DualAccount Customer-masterCard");
        int cardType=1;     
       new HomePageAction()
		       .navigateToLogin()
		       .login(userProfile);
       new MakeAPaymentActionNew()
              .makeAPaymentJourney(userProfile, cardType);
       new AccountOverviewAction()
  		.logout();
    }
	
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyMeastroDual() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-DualAccount Customer-Maeatro");
        int cardType=2;     
       new HomePageAction()
		       .navigateToLogin()
		       .login(userProfile);
       new MakeAPaymentActionNew()
              .makeAPaymentJourney(userProfile, cardType);
       new AccountOverviewAction()
  		.logout();
    }
	
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyVisacardHome() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServiceAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-HomeServiceAccount-VisaCard");
        int cardType=0;     
       new HomePageAction()
		       .navigateToLogin()
		       .login(userProfile);
       new MakeAPaymentActionNew()
              .makeAPaymentJourney(userProfile, cardType);
       new AccountOverviewAction()
       		.logout();
    }
	
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyMasredCardHome() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServiceAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-HomeServiceAccount Customer-masterCard");
        int cardType=1;     
       new HomePageAction()
		       .navigateToLogin()
		       .login(userProfile);
       new MakeAPaymentActionNew()
              .makeAPaymentJourney(userProfile, cardType);
       new AccountOverviewAction()
  		.logout();
    }
	
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyMesstroHome() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServiceAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-HomeServiceAccount Customer-Messtro");
        int cardType=2;     
       new HomePageAction()
		       .navigateToLogin()
		       .login(userProfile);
       new MakeAPaymentActionNew()
              .makeAPaymentJourney(userProfile, cardType);
       new AccountOverviewAction()
  		.logout();
    
	}
	
}