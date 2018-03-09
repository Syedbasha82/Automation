package bg.framework.app.functional.test.selfServe;


import static bg.framework.app.functional.entities.FunctionalCategory.Acquisition;

import org.testng.annotations.Test;

import static bg.framework.app.functional.entities.FunctionalCategory.Ddcps;
import static bg.framework.app.functional.entities.FunctionalCategory.MakeAPayment;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.reFactoring.AccountSummaryAction;
import bg.framework.app.functional.action.reFactoring.DDcpsRewriteAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.action.selfServe.MakeAPaymentActionNew;
import bg.framework.app.functional.entities.MakeAPaymentProfile;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import static bg.framework.app.functional.entities.FunctionalCategory.*;
//import bg.framework.app.functional.test.reFactoring.VideoRecordfile;

public class MakeApaymentTestNew extends TestBase  {
	
////////////////////////////////MAKE A PAYMENT REWRITE///////////////////
	
///****CONDITION FOR TEST DATA:
//////Customer should not have stored card details in Manage my payment card section////////////////////////////////////  
	
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyMasterCardElec() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-ElectricityAccount Customer-Master Card");
        int cardType=3;     
        new HomePageAction()
	       .navigateToLogin()
	       .login(userProfile)
	       .navigateToAccountSummaryPage(userProfile);		       
       new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigatetoMakeAPaymentPage()
           .makeAPaymentJourney(cardType)
           .confirmYourPaymentPage()
           .verify3DSecurePage()
           .verifyConfirmationPage()
           .verifyMAPManageSection();
       new AccountOverviewAction()
		   .logout();
    }
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyVisaDebitElec() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-ElectricityAccount Customer-Master Card");
        int cardType=0;     
        new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage04();		       
       new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigatetoMakeAPaymentPage()
           .makeAPaymentJourney(cardType)
           .confirmYourPaymentPage()
           //.verify3DSecurePage()
           .verifyConfirmationPage();
           //.verifyMAPManageSection();
       new AccountOverviewAction()
		   .logout();
    }
	
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyMasterCardGas() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-GasAccount Customer-Master Card");
        int cardType=3;     
        new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage04();		       
       new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigatetoMakeAPaymentPage()
           .makeAPaymentJourney(cardType)
           .confirmYourPaymentPage()
           .verifyConfirmationPage()
           .verifyMAPManageSection();
           new AccountOverviewAction()
		    .logout();
           
           
    }
	
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyVisaDebitDual() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-DualAccount Customer-Master Card");
        int cardType=0;     
        new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage04();	
        new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigatetoMakeAPaymentPage()
           .makeAPaymentJourney(cardType)
           .confirmYourPaymentPage()
           //.verify3DSecurePage()
           .verifyConfirmationPage()
           .verifyMAPManageSection();
       new AccountOverviewAction()
		    .logout();
      
    }
	
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyVisaDebitCardJI() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-JIAccount Customer-masterCard");
        int cardType=0;     
        new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage04();		       
       new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigatetoMakeAPaymentPage()
           .makeAPaymentJourney(cardType)
           .confirmYourPaymentPage()
          // .verify3DSecurePage()
           .verifyConfirmationPage()
           .verifyMAPManageSection();
       new AccountOverviewAction()
		    .logout();
    }
	
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyVisaDeltaElec() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-ElectricityAccount Customer-Master Card");
        int cardType=1;     
        new HomePageAction()
	       .navigateToLogin()
	       .login(userProfile)
	       .navigateToAccountSummaryPage(userProfile);		       
       new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigatetoMakeAPaymentPage()
           .makeAPaymentJourney(cardType)
           .confirmYourPaymentPage()
           .verifyConfirmationPage()
           .verifyMAPManageSection();
       new AccountOverviewAction()
		   .logout();
    }
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyVisaCreditElec() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-ElectricityAccount Customer-Master Card");
        int cardType=2;     
        new HomePageAction()
	       .navigateToLogin()
	       .login(userProfile)
	       .navigateToAccountSummaryPage(userProfile);		       
       new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigatetoMakeAPaymentPage()
           .makeAPaymentJourney(cardType)
           .confirmYourPaymentPage()
           .verifyConfirmationPage()
           .verifyMAPManageSection();
       new AccountOverviewAction()
		   .logout();
    }
	
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyVisaDebitGas() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-GasAccount Customer-Master Card");
        int cardType=0;     
        new HomePageAction()
	       .navigateToLogin()
	       .login(userProfile)
	       .navigateToAccountSummaryPage(userProfile);		       
       new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigatetoMakeAPaymentPage()
           .makeAPaymentJourney(cardType)
           .confirmYourPaymentPage()
           .verify3DSecurePage()
           .verifyConfirmationPage();
           //.verifyMAPManageSection();
       new AccountOverviewAction()
		    .logout();
    }
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyVisaDeltaGas() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-GasAccount Customer-Master Card");
        int cardType=1;     
        new HomePageAction()
	       .navigateToLogin()
	       .login(userProfile)
	       .navigateToAccountSummaryPage(userProfile);		       
       new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigatetoMakeAPaymentPage()
           .makeAPaymentJourney(cardType)
           .confirmYourPaymentPage()
           .verifyConfirmationPage()
           .verifyMAPManageSection();
       new AccountOverviewAction()
		    .logout();
    }
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyVisaCreditGas() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-GasAccount Customer-Master Card");
        int cardType=2;     
        new HomePageAction()
	       .navigateToLogin()
	       .login(userProfile)
	       .navigateToAccountSummaryPage(userProfile);		       
       new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigatetoMakeAPaymentPage()
           .makeAPaymentJourney(cardType)
           .confirmYourPaymentPage()
           .verifyConfirmationPage()
           .verifyMAPManageSection();
       new AccountOverviewAction()
		    .logout();
    }
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyMeasterDual() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-DualAccount Customer-Master Card");
        int cardType=3;     
        new HomePageAction()
	       .navigateToLogin()
	       .login(userProfile)
	       .navigateToElectricityAccountSummaryPage(userProfile);    
        new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigatetoMakeAPaymentPage()
           .makeAPaymentJourney(cardType)
           .confirmYourPaymentPage()
           .verifyConfirmationPage()
           .verifyMAPManageSection();
       new AccountOverviewAction()
		    .logout();
       new HomePageAction()
           .navigateToLogin()
           .login(userProfile)
           .navigateToGasAccountSummaryPage(userProfile);	       
       new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigatetoMakeAPaymentPage()
           .makeAPaymentJourney(cardType)
           .confirmYourPaymentPage()
           .verifyConfirmationPage()
           .verifyMAPManageSection();
       new AccountOverviewAction()
	       .logout();
    }
	
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyVisaDeltaDual() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-DualAccount Customer-Master Card");
        int cardType=1;     
        new HomePageAction()
	       .navigateToLogin()
	       .login(userProfile)
	       .navigateToElectricityAccountSummaryPage(userProfile);    
        new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigatetoMakeAPaymentPage()
           .makeAPaymentJourney(cardType)
           .confirmYourPaymentPage()
           .verifyConfirmationPage()
           .verifyMAPManageSection();
       new AccountOverviewAction()
		    .logout();
       new HomePageAction()
           .navigateToLogin()
           .login(userProfile)
           .navigateToGasAccountSummaryPage(userProfile);	       
       new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigatetoMakeAPaymentPage()
           .makeAPaymentJourney(cardType)
           .confirmYourPaymentPage()
           .verifyConfirmationPage()
           .verifyMAPManageSection();
       new AccountOverviewAction()
	       .logout();
    }
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyVisaCreditDual() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-DualAccount Customer-Master Card");
        int cardType=2;     
        new HomePageAction()
	       .navigateToLogin()
	       .login(userProfile)
	       .navigateToElectricityAccountSummaryPage(userProfile);    
        new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigatetoMakeAPaymentPage()
           .makeAPaymentJourney(cardType)
           .confirmYourPaymentPage()
           .verifyConfirmationPage()
           .verifyMAPManageSection();
       new AccountOverviewAction()
		    .logout();
       new HomePageAction()
           .navigateToLogin()
           .login(userProfile)
           .navigateToGasAccountSummaryPage(userProfile);	       
       new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigatetoMakeAPaymentPage()
           .makeAPaymentJourney(cardType)
           .confirmYourPaymentPage()
           .verifyConfirmationPage()
           .verifyMAPManageSection();
       new AccountOverviewAction()
	       .logout();
    }
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyMasredCardJI() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-JIAccount Customer-masterCard");
        int cardType=3;     
        new HomePageAction()
	       .navigateToLogin()
	       .login(userProfile)
	       .navigateToAccountSummaryPage(userProfile);		       
       new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigatetoMakeAPaymentPage()
           .makeAPaymentJourney(cardType)
           .confirmYourPaymentPage()
           .verifyConfirmationPage()
           .verifyMAPManageSection();
       new AccountOverviewAction()
		    .logout();
    }
	
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyVisaDeltaJI() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-JIAccount Customer-masterCard");
        int cardType=1;     
        new HomePageAction()
	       .navigateToLogin()
	       .login(userProfile)
	       .navigateToAccountSummaryPage(userProfile);		       
       new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigatetoMakeAPaymentPage()
           .makeAPaymentJourney(cardType)
           .confirmYourPaymentPage()
           .verifyConfirmationPage()
           .verifyMAPManageSection();
       new AccountOverviewAction()
		    .logout();
    }
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyVisaCreditJI() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        Report.createTestLogHeader("MakeAPayment", "OAM-JIAccount Customer-masterCard");
        int cardType=2;     
        new HomePageAction()
	       .navigateToLogin()
	       .login(userProfile)
	       .navigateToAccountSummaryPage(userProfile);		       
       new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigatetoMakeAPaymentPage()
           .makeAPaymentJourney(cardType)
           .confirmYourPaymentPage()
           .verifyConfirmationPage()
           .verifyMAPManageSection();
       new AccountOverviewAction()
		    .logout();
    }
/////////////////////////////////////////////////Delete Card Details/////////////////////////////////////////////
	///////////DATA Condition:User Should not have Stored Card Details Previously///////////////////////////////////////////////
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyVisaDebitJIDeleteCardDetails() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        Report.createTestLogHeader("MakeAPayment Delete Card Details", "OAM-JIAccount Customer-Visa Debit Card");
        int cardType=0;     
        new HomePageAction()
	       .navigateToLogin()
	       .login(userProfile)
	       .navigateToAccountSummaryPage(userProfile);		       
       new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigatetoMakeAPaymentPage()
           .makeAPaymentJourney(cardType)
           .confirmYourPaymentPage()
           .verify3DSecurePage()
           .verifyConfirmationPage()
           .navigatetoPaymentsPageFromMAP()
           .navigateToManagePaymentCardDetailsPage()
           .verifyMAPManageSection()
           .editCard()
           .verifyEditedDetails()
           .deleteCard();
       new AccountOverviewAction()
		    .logout();
    }
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyVisaDebitElecDeleteCardDetails() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        Report.createTestLogHeader("MakeAPayment Delete Card Details", "OAM-ElectricityAccount Customer-Visa Debit Card");
        int cardType=0;     
        new HomePageAction()
	       .navigateToLogin()
	       .login(userProfile)
	       .navigateToAccountSummaryPage(userProfile);		       
       new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigatetoMakeAPaymentPage()
           .makeAPaymentJourney(cardType)
           .confirmYourPaymentPage()
           .verify3DSecurePage()
           .verifyConfirmationPage()
           .navigatetoPaymentsPageFromMAP()
           .navigateToManagePaymentCardDetailsPage()
           .verifyMAPManageSection()
           .editCard()
           .deleteCard();
       new AccountOverviewAction()
		   .logout();
    }
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyVisaDebitGasDeleteCardDetails() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        Report.createTestLogHeader("MakeAPayment Delete Card Details", "OAM-GasAccount Customer-Visa Debit Card");
        int cardType=0;     
        new HomePageAction()
	       .navigateToLogin()
	       .login(userProfile)
	       .navigateToAccountSummaryPage(userProfile);		       
       new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigatetoMakeAPaymentPage()
           .makeAPaymentJourney(cardType)
           .confirmYourPaymentPage()
           .verify3DSecurePage()
           .verifyConfirmationPage()
           .navigatetoPaymentsPageFromMAP()
           .navigateToManagePaymentCardDetailsPage()
           .verifyMAPManageSection()
           .editCard()
           .deleteCard();
       new AccountOverviewAction()
		    .logout();
    }
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentJourneyVisaDebitDualDeleteCardDetails() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        Report.createTestLogHeader("MakeAPayment Delete Card Details", "OAM-DualAccount Customer-Master Card");
        int cardType=0;     
        new HomePageAction()
	       .navigateToLogin()
	       .login(userProfile)
	       .navigateToElectricityAccountSummaryPage(userProfile);    
        new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigatetoMakeAPaymentPage()
           .makeAPaymentJourney(cardType)
           .confirmYourPaymentPage()
           .verify3DSecurePage()
           .verifyConfirmationPage()
           .navigatetoPaymentsPageFromMAP()
           .navigateToManagePaymentCardDetailsPage()
           .verifyMAPManageSection()
           .editCard()
           .deleteCard();
       new AccountOverviewAction()
		    .logout();
       new HomePageAction()
           .navigateToLogin()
           .login(userProfile)
           .navigateToGasAccountSummaryPage(userProfile);	       
       new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigatetoMakeAPaymentPage()
           .makeAPaymentJourney(cardType)
           .confirmYourPaymentPage()
           .verify3DSecurePage()
           .verifyConfirmationPage()
           .navigatetoPaymentsPageFromMAP()
           .navigateToManagePaymentCardDetailsPage()
           .verifyMAPManageSection()
           .editCard()
           .deleteCard();
       new AccountOverviewAction()
	       .logout();
    }
	
	///////////////////////////////////Deeplink Test/////////////////////////
	@Test(groups = {MakeAPayment})
	 public void verifyMAPDeepLinkJourneyMasredCardJIAnonymous(){
		Report.createTestLogHeader("MAP Deep Link CID code Check", "JI Account");
		UserProfile userProfile=new TestDataHelper().getUserProfile("JIAccount");
		new HomePageAction()
		.navigateToLoginMAPDeepLink()
		.verifyMAPLoginPageCID()
		.login(userProfile)
		.verifyMAPPageCID();
	    new AccountOverviewAction()
		 .logout();
		
	}
	@Test(groups={Ddcps,Regression})
	public void verifyMAPDeepLinkJourneyMasredCardJILoggedin(){
	Report.createTestLogHeader("MAP Deep Link CID code Check Logged In", "Dual Account");
	UserProfile userProfile=new TestDataHelper().getUserProfile("JIAccount");
	new HomePageAction()
	.navigateToLogin()
	.login(userProfile)
	.navigateToAccountSummaryPage(userProfile);
	new HomePageAction()
	.navigateToLoginMAPDeepLink();
	new AccountOverviewAction()
	.verifyMAPPageCID();
	new DDcpsRewriteAction()
		.logOut();
	}
///////////////////////////////////////////////////////////////////Store Card Details//////////////////////////////////////////////////////////
	
	/////*Condition for Test Data: Customer Should Not have Stored Card Details//////////
	
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentStoreCardDetailsNewForElec() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        Report.createTestLogHeader("MakeAPayment Storage Card Details", "OAM-ElectricityAccount"); 
       //VideoRecordfile.startRecording();
        new HomePageAction()
	       .navigateToLogin()
	       .login(userProfile)
	       .navigateToAccountSummaryPage(userProfile);		       
       new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigateToManagePaymentCardDetailsPage()
           .cardStorageFunctionality();
       new AccountOverviewAction()
		   .logout();
       //VideoRecordfile.stopRecording();
    }
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentStoreCardDetailsNewForGas() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        Report.createTestLogHeader("MakeAPayment Storage Card Details", "Gas Account"); 
        new HomePageAction()
	       .navigateToLogin()
	       .login(userProfile)
	       .navigateToAccountSummaryPage(userProfile);		       
       new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigateToManagePaymentCardDetailsPage()
           .cardStorageFunctionality();
       new AccountOverviewAction()
		   .logout();
    }
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentStoreCardDetailsNewForDual() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        Report.createTestLogHeader("MakeAPayment Storage Card Details", "OAM-DualAccount"); 
        new HomePageAction()
	       .navigateToLogin()
	       .login(userProfile)
	        .navigateToElectricityAccountSummaryPage(userProfile);   		       
       new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigateToManagePaymentCardDetailsPage()
           .cardStorageFunctionality();
       new AccountOverviewAction()
		   .logout();
       /*new HomePageAction()
       .navigateToLogin()
       .login(userProfile)
       .navigateToGasAccountSummaryPage(userProfile);	  		       
      new MakeAPaymentActionNew()
       .navigatetoPaymentsPage()
       .navigateToManagePaymentCardDetailsPage()
       .cardStorageFunctionality();
      new AccountOverviewAction()
	   .logout();*/
    }
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentStoreCardDetailsNewForJI() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        Report.createTestLogHeader("MakeAPayment Storage Card Details", "OAM-JIAccount"); 
        new HomePageAction()
	       .navigateToLogin()
	       .login(userProfile)
	       .navigateToAccountSummaryPage(userProfile);		       
       new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigateToManagePaymentCardDetailsPage()
           .cardStorageFunctionality();
       new AccountOverviewAction()
		   .logout();
    }
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentStoreCardDetailsE2EElec() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        Report.createTestLogHeader("MakeAPayment Storage Card Details E2E", "OAM-ElectricityAccount"); 
        new HomePageAction()
	       .navigateToLogin()
	       .login(userProfile)
	       .navigateToAccountSummaryPage(userProfile);		       
       new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigateToManagePaymentCardDetailsPage()
           .cardStorageFunctionalityE2E();
       new AccountOverviewAction()
		   .logout();
    }
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentStoreCardDetailsE2EGas() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        Report.createTestLogHeader("MakeAPayment Storage Card Details E2E", "OAM-GasAccount"); 
        new HomePageAction()
	       .navigateToLogin()
	       .login(userProfile)
	       .navigateToAccountSummaryPage(userProfile);		       
       new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigateToManagePaymentCardDetailsPage()
           .cardStorageFunctionalityE2E();
       new AccountOverviewAction()
		   .logout();
    }
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentStoreCardDetailsE2EDual() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        Report.createTestLogHeader("MakeAPayment Storage Card Details E2E", "OAM-DualAccount"); 
        new HomePageAction()
	       .navigateToLogin()
	       .login(userProfile)
	       .navigateToAccountSummaryPage(userProfile);		       
       new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigateToManagePaymentCardDetailsPage()
           .cardStorageFunctionalityE2E();
       new AccountOverviewAction()
		   .logout();
    }
	@Test(groups = {MakeAPayment})
    public void verifyMakeAPaymentStoreCardDetailsE2EJI() throws Exception {
        
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        Report.createTestLogHeader("MakeAPayment Storage Card Details E2E", "OAM-JIAccount"); 
        new HomePageAction()
	       .navigateToLogin()
	       .login(userProfile)
	       .navigateToAccountSummaryPage(userProfile);		       
       new MakeAPaymentActionNew()
           .navigatetoPaymentsPage()
           .navigateToManagePaymentCardDetailsPage()
           .cardStorageFunctionalityE2E();
       new AccountOverviewAction()
		   .logout();
    }
	}