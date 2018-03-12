
 package bg.framework.app.functional.test.selfServe;

import static bg.framework.app.functional.entities.FunctionalCategory.Acquisition;
import static bg.framework.app.functional.entities.FunctionalCategory.CHIAppointment;
import static bg.framework.app.functional.entities.FunctionalCategory.InProgress;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import static bg.framework.app.functional.entities.FunctionalCategory.SalesRegressionAnonymous;
import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;
import static bg.framework.app.functional.entities.FunctionalCategory.SubmitMeterRead;


import org.testng.annotations.Test;

import java.io.IOException; 
import java.text.ParseException;
import java.util.NoSuchElementException;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.common.LoginAction;

import bg.framework.app.functional.action.sales.CHIAppointmentAction;
import bg.framework.app.functional.action.sales.UpsellAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.action.selfServe.EmergentPostCodeFinderAction;
import bg.framework.app.functional.action.selfServe.SMRAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.FunctionalCategory;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;

import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;



import bg.framework.app.functional.action.selfServe.MessageCentreAction;
import bg.framework.app.functional.action.reFactoring.SiteSearchAction;
import bg.framework.app.functional.entities.PredictNextBill;
import bg.framework.app.functional.action.selfServe.NectarAction;
import bg.framework.app.functional.action.selfServe.MakeAPaymentActionNew;
 
import bg.framework.app.functional.action.reFactoring.ModelSalesAction;
import bg.framework.app.functional.action.reFactoring.ViewBillAction;
import bg.framework.app.functional.action.reFactoring.EnergyUsageAction;
import bg.framework.app.functional.action.reFactoring.repairAndCoverAction;

import bg.framework.app.functional.entities.HomeMove;
import bg.framework.app.functional.action.selfServe.HomeMoveAction;
 
import bg.framework.app.functional.entities.LandLord;
import bg.framework.app.functional.action.services.LandlordActionNew;
 

public class SSRVSmokeTest extends TestBase
{

 //For Login, Account Overview & Account Summary of all customer types	 
	
	// Final Description: Need to modify cross cell script in Acc. Overview for JI,DUAL & HC. and also Need to modify Acc. summ. script for Dual (dropdown)

	 /////////////////////////////////////////////////////////////////////////LOGIN,AccountOverview,AccountSummary///////////////////////////////////////////////////////////////  
	   
	
   @SuppressWarnings("unchecked") 
   @Test(groups = {Smoke})
   
   

   public void Login()throws IOException, ParseException
     {
	       
	      String userAccount[] = {"JIAccount"};
	     
	 	  UserProfile userProfile;
		 
		  for (int i=0; i< userAccount.length; i++)
		    {
			    userProfile = new TestDataHelper().getUserProfile(userAccount[i]); 
			    Report.createTestLogHeader("Login, Account Overview & Summary of " + userProfile.getcustType(),"Login - Account Overview - Account Summary");
			
			    try
			      {
			    	new HomePageAction()
			    	      	.navigateToLogin();
			    	new LoginAction()
			    		    .loginUserDetails(userProfile)
			    	        .accountOverviewLogInUserValidation(userProfile)
			    	        .verifyAccountOverviewAction()
			    		    .navigateToAccountSummaryPage()
						    .verifyAccountSummaryPageAction(userProfile.getAccNumber())
						    .logout();
			     }
			  catch (NoSuchElementException e) 
				 {
				  e.printStackTrace();
				 }
		    	 
		    } 
 	    	    	
    }
	   
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
   
   
  /// For Cross Sell Journey 

   /// Final Description: Mentioned above.
   
 	  @SuppressWarnings("unchecked") 
	  @Test(groups = {Smoke})
	  public void CrossSell()throws IOException, ParseException
	    {
	     	 String userAccountCell[] = {"JIAccount"};
	    	 UserProfile userProfileCell;

			  for (int i=0; i<userAccountCell.length; i++)
			 	{
			 	 userProfileCell = new TestDataHelper().getUserProfile(userAccountCell[i]); 
			 	 Report.createTestLogHeader("Account Summary cross cell Journey of " + userProfileCell.getcustType(), " JIAccount");
			      
			      new HomePageAction().navigateToLoginPage()	            
			      	.loginUserDetails(userProfileCell)
			      	.verifyAccountOverviewAction()
	   	            .verifyAddress(userProfileCell.getAccNumber())
			        .navigateToAccountSummaryPage()
			        .verifyAccountSummaryCrossCellAction().logout();
				}
	     }
 	   
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	   
  /// For Forgot Email Journey	

 	 /// Final Description: Pass
      @SuppressWarnings("unchecked") 
	  @Test(groups = {Smoke})
	  public void verifyForgotEmail() 
      {
    	String userAccountForgotEmail[] = {"JIAccount"};
	    UserProfile userProfileForgotEmail; 
	    for (int i=0; i<userAccountForgotEmail.length; i++)
	 	{
	    userProfileForgotEmail = new TestDataHelper().getUserProfile(userAccountForgotEmail[i]); 
	   
        Report.createTestLogHeader("Forgot Email Journey of " + userProfileForgotEmail.getcustType(), " OAM user has been successfully completed");
       
            new HomePageAction()
            		//.navigateToLoginPage()
            		.navigatetoForgotEmailPage()
            		.verifyForgotEmailPage(userProfileForgotEmail)
                    .verifyForgotEmailBreadCrumbValidation(userProfileForgotEmail)
                    .verifyForgotEmailWhereCanIFindValidation(userProfileForgotEmail)
                    .verifyForgotEmailTitleValidation(userProfileForgotEmail)
                    .verifyEnterEmailValidation(userProfileForgotEmail);
	 	}
       
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
  
      
      /// For Treatment Message Journey  

      /// Final Description: Treatment is pass and Broadcast need to verify.
      
 	  /*@SuppressWarnings("unchecked") 
	  @Test(groups = {Smoke})
	  public void TreatmentMessage()throws IOException, ParseException
	    {
			 String userAccountTreat[] = {"JIAccount"};
			 UserProfile userProfileTreat;
			
			 	for (int i=0; i<userAccountTreat.length; i++)
			 	  {
			 		userProfileTreat = new TestDataHelper().getUserProfile(userAccountTreat[i]);
			 		Report.createTestLogHeader("Treament Message Centre Journey test","OAM");
	   	 			new MessageCentreAction().navigateToLogin().loginUser(userProfileTreat)
			 				  .navigateToMessages()
			 				  .chkUnreadMessages(userProfileTreat, ""+userProfileTreat.getcustType()+"")
			 				  .readUnreadMessages(userProfileTreat, ""+userProfileTreat.getcustType()+"", "Treatment")
			 				  .logout();
			 	  }
			 		    
			 String userAccountBroad[] = {"JIAccount"};
			 UserProfile userProfileBroad;
			// UserProfile userProfileGas = new TestDataHelper().getUserProfile("AnonymousGasAccount");
			 	for (int i=0; i<userAccountBroad.length; i++)
			 	  {
					userProfileBroad = new TestDataHelper().getUserProfile(userAccountBroad[i]);
					Report.createTestLogHeader("Broadcast Message Centre Journey test","OAM");
					new MessageCentreAction().navigateToLogin().loginUser(userProfileBroad)
								.navigateToMessages()
								.chkUnreadMessages(userProfileBroad, ""+userProfileBroad.getcustType()+"")
								.readUnreadMessages(userProfileBroad, ""+userProfileBroad.getcustType()+"", "Broadcast")
								.logout();
			 	  } 
	     }*/
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	  
  /// For Contact Us Journey 
 	  
 	 /// Final Description: Facing errors
 	  
 	  @SuppressWarnings("unchecked") 
	  @Test(groups = {Smoke})
	  public void ContactUs()throws IOException, ParseException
	    {
 		   UserProfile userProfileContactElec = new TestDataHelper().getUserProfile("AnonymousElecAccount");
          Report.createTestLogHeader("Contact Us","Anonymous Journey");       
           new HomePageAction()
 		       .navigateToContactUsPage()
 		       .verifyContactUsAnon(userProfileContactElec,"Anonymous");
           new HomePageAction()
         		.logout();
      
           /*Report.createTestLogHeader("Contact Us", "OAM Journey");
	       new HomePageAction()
	       	      .navigateToLogin()
	       	      .login(userProfileContactElec)
	       	      .navigateToContactUsPage()
	       	      .verifyContactUsOAM(userProfileContactElec,"OAM");
	        new HomePageAction()
	              .logout();*/
	    }
 	  

 // For Emergency Postcode Journey	 
 	  
 /// Final Description: Pass
 	  
 	@SuppressWarnings("unchecked") 
	@Test(groups = {Smoke})
	public void EmergencyPostCode()throws IOException, ParseException
	    {
 			UserProfile userProfileEmergtElec = new TestDataHelper().getUserProfile("AnonymousElecAccount");
	        Report.createTestLogHeader("Emergency Post Code Journey test", "OAM");
		   
			new HomePageAction()
				.navigateToLogout();
		    new EmergentPostCodeFinderAction()		    
			    .navigateToLogin(userProfileEmergtElec)
			    .loginUser(userProfileEmergtElec)
			    .navigateToEmergencies()
			    .enterThePostCode()
			    .logOut();
 	   
	    }
 	
 	/// For Predict NextBill Journey  

 	 /// Final Description: Might be problem with data.
 	
/* 	@SuppressWarnings("unchecked") 
	@Test(groups = {Smoke})
	public void PredictNextBill()throws IOException, ParseException
	    {
			
 		    UserProfile userProfilePNBElec = new TestDataHelper().getUserProfile("JIAccount");
 		    Report.createTestLogHeader("PredictNextBill", "For Conventional and Esmart ElectricityAccount");
			final PredictNextBill pnb=new TestDataHelper().getPNBData("PNBElectricityTestData");

			new HomePageAction()
					.navigateToLogin()
					.login(userProfilePNBElec)
					.navigateToAccountSummaryPage(userProfilePNBElec)
					.navigateToPredictNextBill("EnergyUsage",userProfilePNBElec)
					.verifyPNBPageLinks()
					.verifyIntialPNBPage()
					.verifyMeterDials()
					.selectMeterTypeAndEnterRead("plausible",pnb.getGasEstimate(),pnb.getElecEstimate(),pnb.getElecDualEstimate())
					.clickPredictNextBill()
					.verifyPredictedBillPage()
					//.resetPNBValue()
					.pnbLogout(); 
			
	
	    }*/
 	
  /// For View Bill Journey		  	
 	
 	 /// Final Description: Need to verify .navigateToBillHistory(), .verifyAndViewBills() and .viewDifferentStatements() methods.
 	
  @SuppressWarnings("unchecked") 
  @Test(groups = {Smoke})
  public void ViewBill()throws IOException, ParseException
	 {
	 UserProfile userProfileViewBillElec = new TestDataHelper().getUserProfile("JIAccount");
 	 Report.createTestLogHeader("ViewBill", "JIAccount");
 	 new HomePageAction()
 			 .navigateToLogin()
 			 .login(userProfileViewBillElec)
 			 .navigateToAccountSummaryPage(userProfileViewBillElec)
 			 .clickSeeYourStatementLink()
 			 .navigateToBillHistory()
 			 .verifyAndViewBills()
 			 .viewDifferentStatements()
 			 .logout();	
	 }
  
 /// For OAM Nectar Registration 
  
/// Final Description: Might be problem with data.
  
 @SuppressWarnings("unchecked") 
 @Test(groups = {Smoke})
  public void NectarRegistration()throws IOException, ParseException
	 {	
	 UserProfile userProfileNectarGas = new TestDataHelper().getUserProfile("AnonymousGasAccount");
	 Report.createTestLogHeader("Nectar Test", "OAM Nectar Registration Gas");
	
	 			new HomePageAction()
					.navigateToLogin()
					.login(userProfileNectarGas);
				new NectarAction()
					.navigateToRegistrationPage()
					.getNectarCard()
					.verifyNectarRegister()
					.navigateToYourPointsPage()
					.verifyYourPointsPage()
					.logout();
				
				
			
	 }	
 
 

 /// For Submit Meter Read Journey	   
 
/// Final Description: Need to modify Reading dials script
 
 @SuppressWarnings("unchecked") 
 @Test(groups = {Smoke})
  public void SubmitMeterRead()throws IOException, ParseException
	 {
	 Report.createTestLogHeader("Submit Meter Read.", "Plausible JI Meter");
		

		UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");

		userProfile.setAccNumber(userProfile.getGasAccount());
		
		//getCustomerDetailsToUserProfileOAM(userProfile);

		//new SMRAction().resetMeterRead(userProfile.getGasAccount());
		new HomePageAction().navigateToLogin().login(userProfile)
		        .navigateToAccountSummaryPage(userProfile).navigateToSMRPage()
		        .setPlausbileReading(userProfile.getGasAccount())
		        .confirmAccountSelection()		        
		        .verifyMeterConfirmation(userProfile.getGasAccount(), userProfile)
		        .logout();
	 
	 
	 }
 
/// For Manage Personal Details Journey  

//Final Description: Pass
 
 @SuppressWarnings("unchecked") 
 @Test(groups = {Smoke})
 public void ManagePersonalDetails()throws IOException, ParseException
	 { 	
	 UserProfile userProfileMPDHS = new TestDataHelper().getUserProfile("JIAccount");
     Report.createTestLogHeader("Manage Personal Details", "OAM Home Services user Manage Personal Details Journey");
     
     UserProfile userProfileReset = userProfileMPDHS;
     try {
         new HomePageAction()
                 .navigateToLogin()
                 .login(userProfileMPDHS)
                 .navigateToAccountSummaryPage(userProfileMPDHS)
         		 .navigateToContactUs()
                 .navigateToMovingHomePage()
            	 .navigateToManagePersonalDetailsPage()
         		 .fillValidDataInManagePersonalDetailsPage(userProfileMPDHS)
         		 .verifyFillDataWithDB(userProfileMPDHS)
         		 .verifyFillDataWithSiebel(userProfileMPDHS)
         		 .verifyConfirmationOverLayClickLogin()
         		 .login(userProfileMPDHS)
         		 .navigateToAccountSummaryPage(userProfileMPDHS)
         		 .navigateToManagePersonalDetailsPage()
         		 .logout()
         		 .verifyMPDSapNetweaver(userProfileMPDHS);
         		
         userProfileMPDHS = userProfileReset;
     } 
     finally 
     {
     }
	 }
 
 /// For Make a Payment Journey  

///Final Description: Need data
 
 @SuppressWarnings("unchecked") 
 @Test(groups = {Smoke})
 public void MakeAPayment()throws IOException, ParseException
	 { 	
	    UserProfile userProfileMAPDual = new TestDataHelper().getUserProfile("JIAccount");
 	    Report.createTestLogHeader("MakeAPayment", "OAM-ElectricityAccount Customer-Visa Debit");
	    int cardType=0;     
	    new HomePageAction()
		       .navigateToLogin()
		       .login(userProfileMAPDual)
		       .navigateToAccountSummaryPage(userProfileMAPDual);    
	    new MakeAPaymentActionNew()
	           .navigatetoPaymentsPage()
	           .navigatetoMakeAPaymentPage()
	           .makeAPaymentJourney(cardType)
	           .confirmYourPaymentPage()
	           .verifyConfirmationPage();
	    new AccountOverviewAction()
			    .logout();
	    
	    
	    /*new HomePageAction()
	           .navigateToLogin()
	           .login(userProfileMAPDual)
	           .navigateToGasAccountSummaryPage(userProfileMAPDual);	       
	    new MakeAPaymentActionNew()
	           .navigatetoPaymentsPage()
	           .navigatetoMakeAPaymentPage()
	           .makeAPaymentJourney(cardType)
	           .confirmYourPaymentPage()
	           .verifyConfirmationPage();
	    new AccountOverviewAction()
		       .logout(); */
	 
/*	 UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousElecAccount");
     Report.createTestLogHeader("MakeAPayment", "OAM-ElectricityAccount Customer-Master Card");
     int cardType1=3;     
     new HomePageAction()
	       .navigateToLogin()
	       .login(userProfile)
	       .navigateToAccountSummaryPage(userProfile);		       
    new MakeAPaymentActionNew()
        .navigatetoPaymentsPage()
        .navigatetoMakeAPaymentPage()
        .makeAPaymentJourney(cardType1)
        .confirmYourPaymentPage()
        .verifyConfirmationPage();
    new AccountOverviewAction()
		   .logout();*/
	 }
 
/// For Meter Read History Journey		   

/// Final Description: Need to verify script.
 
 @SuppressWarnings("unchecked") 
 @Test(groups = {Smoke})
 public void MeterReadHistory()throws IOException, ParseException
	 {
	 UserProfile userProfileMRHJI = new TestDataHelper().getUserProfile("JIAccount");
     Report.createTestLogHeader("MeterReadHistory", "JIAccount");
 	 
 		   		new HomePageAction()
 				   		.navigateToLogin()
 				   		.login(userProfileMRHJI)
 				   		.navigateToAccountSummaryPage(userProfileMRHJI)
 				   		.navigateToMeterReadHistory()
 				   		.verifylinks()
 				   		//.verifyMeterReadTable(userProfile.getGasAccount(),"Gas")
 				   		//.navigatetoElec()
 				   		//.verifyMeterReadTable(userProfile.getElecAccount(),"Electricity")
 				   		.logout();
	}
 
 /// For Energy Usage Journey  

/// Final Description: Need data
 
 @SuppressWarnings("unchecked") 
 @Test(groups = {Smoke})
 public void EnergyUsage()throws IOException, ParseException
	 {
	 
	 String userAccountEnergyUsage[] = {"JIAccount"};
	    UserProfile userProfileEU; 
	    for (int i=0; i<userAccountEnergyUsage.length; i++)
	 	{
	    	userProfileEU = new TestDataHelper().getUserProfile(userAccountEnergyUsage[i]); 
	   
     Report.createTestLogHeader("EnergyUsage of " + userProfileEU.getcustType(), " OAM users");
    
       
	  new HomePageAction()
			.navigateToLogin()
		    .login(userProfileEU)
			.navigateToAccountSummaryPage(userProfileEU);
	  new EnergyUsageAction()
			.navigateToEnergyUsage()
			.verifyLinks()
			.viewallbills();
	  new ViewBillAction()
			.verifyAndViewBills()
			.viewDifferentStatements()
			.navigatetoElectricity()
			.navigateToBillHistory()
			.verifyAndViewBills()
			.viewDifferentStatements()
			.logout();   
	 	}
	 }
 
/// For Bill History Journey  

/// Final Description: Pass
 /*
 @SuppressWarnings("unchecked") 
 @Test(groups = {Smoke})
 public void BillHistory()throws IOException, ParseException
	 {
	 
	 
		String userAccountViewBill[] = {"JIAccount"};
	    UserProfile userProfileBH; 
	    for (int i=0; i<userAccountViewBill.length; i++)
	 	{
	    userProfileBH = new TestDataHelper().getUserProfile(userAccountViewBill[i]); 
	    Report.createTestLogHeader("BillHistory of " + userProfileBH.getcustType(), " OAM users");
	    
 
	new HomePageAction()
		.navigateToLogin()
		.login(userProfileBH)
	    .navigateToAccountSummaryPage(userProfileBH)
	    .navigateToBillHistory()
	    .verifyAndViewBills()
	    .logout();
	 	}
	 }*/
 
/// For Payment History Journey  

/// Final Description: Need QTP for this script
 @SuppressWarnings("unchecked") 
 @Test(groups = {Smoke})
 public void PaymentHistory()throws IOException, ParseException
	 {
	
	 
   //  UserProfile userProfilePHGas = new TestDataHelper().getUserProfile("AnonymousGasAccount");
   
     String userAccountPayment[] = {"JIAccount"};
	 UserProfile userProfilePH;
	
	 	for (int i=0; i<userAccountPayment.length; i++)
	 	  {
	 		userProfilePH = new TestDataHelper().getUserProfile(userAccountPayment[i]); 
	 		 
	 		 Report.createTestLogHeader("Payment Meter Read History Journey of " + userProfilePH.getcustType(), "To Verify Payment For " + userProfilePH.getcustType()+" Customer");
		  
		      
			     new HomePageAction()
			     .navigateToLoginPage()
     			.loginUserDetails(userProfilePH)
		     	.verifyAccountOverviewAction()
		        .navigateToAccountSummaryPage()
		        .verifyPaymentHistory(userProfilePH)
		        .verifyMakeAPayment(userProfilePH.getGasAccount())
		        .verifySearchField(userProfilePH.getSecurityQuestion())
		        .verifyTransactionHistoryItems()
		        .verifyDateField()
		        .verifyBillHistory();
		     //   .verifyMeterReadHistory(userProfilePHGas.getGasAccount());	
	 	  }
	 }
 
/// For PB Flag Journey  

 /// Final Description: Need data
 @SuppressWarnings("unchecked") 
 @Test(groups = {Smoke})
 public void PBFlag()throws IOException, ParseException
	 {
	 Report.createTestLogHeader("PB Flag Test", "PB Flag no thanks- Test");
     UserProfile userProfilePBFDual = new TestDataHelper().getUserProfile("JIAccount");
  
     new HomePageAction()
             .navigateToLoginPage()
             .loginUserDetails(userProfilePBFDual)
              .verifyAddress(userProfilePBFDual.getAccNumber())
             .navigateToAccountSummaryPage()
             .navigateToPbFlagPage()
             .paperLessNoThanks()
             .logout();
	 }
 
 /// For LandLord Journey	

/// Final Description: Need check script at displayed price and the actual price and also discuss whether is this required r not.
 
/* @SuppressWarnings("unchecked") 
 @Test(groups = {Smoke})
 public void Landlord()throws IOException, ParseException
	 {			
	 	Report.createTestLogHeader("LandLord Journey", "Verify Landlord Package London without boiler cover");
		LandLord Landlord= new TestDataHelper().getLandLord("single");
		boolean BoilerCover = false;
		new LandlordActionNew()
			.navigateLandLordPage()
			.enterPostcodeDetails("TW18 3HE")
			.verifyPackagePricing("London",BoilerCover)
			.fillPackageDetails(Landlord)
			.fillContactSectionAnonymous("TW18 3HE")
			.enterPaymentDetails("")
			.enterTermsAndConditions("")
			.verifyThankYouPage();
		
	 }*/
 /// For Home Move Journey		

/// Final Description: Pass
 
 @SuppressWarnings("unchecked") 
 @Test(groups = {Smoke})
 public void HomeMove()throws IOException, ParseException
	 {
		 Report.createTestLogHeader("HomeMove LandLord For Anonymous", "Anonymous customer with with Move In and Move Out Three Add Account Holder");
		int moveOutDate=28;	
		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveLandLordTestData");
			new HomePageAction()
					.navigateToLogout();
	   		new HomeMoveAction()
	   				.navigateToMovingInForAnonymousCustomer()
	   				.navigateToLandlordMovingHome()
	   				.navigateToLandLordBusinessNature()
	   				.enterYourDetailsInLandLordMovingHome(homeMove)
	   				.enterSupplyAddressDetails(homeMove)
	   				.enterMoveHomeDetailsForLandLord("Dual",moveOutDate,homeMove)
	   				.editDetailsForLandLordHomeMove(homeMove, moveOutDate, "YourDetails")
	   				.homeMoveLandLordConfirmationPage()
	   				.navigateToHome();
	 }
 
	
 //For Registration Journey	    

/// Final Description: Need data
 
 @SuppressWarnings("unchecked") 
 @Test(groups = {Smoke})
 public void Registration()throws IOException, ParseException
	 {
	 UserProfile userProfileRegElec = new TestDataHelper().getUserProfile("JIAccount");	 
	 Report.createTestLogHeader("Regression Smoke Test","To Verify Registration for Dual Account");
		        try
		   		  {
		   		    new OnlineDBConnector().deRegister(userProfileRegElec.getUCRN());
		   			String registerType="DD";
		   			new HomePageAction()
		   			        .navigateToRegistration()
		   			        .registerUpdateYourDetailsNew(userProfileRegElec, userProfileRegElec.getAccNumber(),registerType)
		   			        .goToYourAccount()
		   			        .verifyRegisteredUser(userProfileRegElec,userProfileRegElec.getLastName(), userProfileRegElec.getAccNumber())
		   			        .verifyAccountPresense(userProfileRegElec.getAccNumber())
		   			        .logout();
		   			        
		   			new OnlineDBConnector().deRegister(userProfileRegElec.getUCRN());
		   			                  String registerType1="AccNo";
		   		    new HomePageAction()
		   			       .navigateToRegistration()
		   			       .registerUpdateYourDetailsNew(userProfileRegElec, userProfileRegElec.getAccNumber(),registerType1)
		   			       .goToYourAccount()
		   			       .verifyRegisteredUser(userProfileRegElec,userProfileRegElec.getLastName(), userProfileRegElec.getAccNumber())
		   			       .verifyAccountPresense(userProfileRegElec.getAccNumber())
		   			       .logout();
		   			new OnlineDBConnector().deRegister(userProfileRegElec.getUCRN());
		   			                  String registerType2="SO";
		   		    new HomePageAction()
		   			       .navigateToRegistration()
		   			       .registerUpdateYourDetailsNew(userProfileRegElec, userProfileRegElec.getAccNumber(),registerType2)
		   			       .goToYourAccount()
		   			       .verifyRegisteredUser(userProfileRegElec,userProfileRegElec.getLastName(), userProfileRegElec.getAccNumber())
		   			       .verifyAccountPresense(userProfileRegElec.getAccNumber())
		   			       .logout(); 
		   		}
		   		catch (NoSuchElementException e) 
		   			 {
		   			  e.printStackTrace();
		   			 }
	 }
 

 
 /// For Site Search Journey 

/// Final Description: Pass
 
 @SuppressWarnings("unchecked") 
 @Test(groups = {Smoke})
 public void SiteSearch()throws IOException, ParseException
	 {
      Report.createTestLogHeader("Site Search", "Site Search Field Validation in different pages");
	  new SiteSearchAction()
			.verifySiteSearchJourney("british")
			.verifySiteSearchErrorMsgs()
		    .validateDisplayedResults("british");	 

/*	 UserProfile userProfileSSGas = new TestDataHelper().getUserProfile("AnonymousGasAccount1");   	
	 Report.createTestLogHeader("Site Search", "Site Search Field Validation in different pages with logged in Customer");
	
	new HomePageAction()
	    	.navigateToLogin()
			.login(userProfileSSGas);	
	new SiteSearchAction()
			.verifySiteSearchErrorMsgs()
			.validateDisplayedResults("british");  */
	 }
 
 
 /// For Upsell Journey 

/// Final Description: Need data
 /*
 @SuppressWarnings("unchecked") 
 @Test(groups = {Smoke})
 public void Upsell()throws IOException, ParseException
	 {
	  UserProfile userProfileUSHC200 = new TestDataHelper().getUserProfile("HC200Account");
	  Report.createTestLogHeader("Upsell Test ", " Upgrade To 300");
	  String value ="300";
	  new UpsellAction()
              .loginUser(userProfileUSHC200)
              .verifyUpgradeCustomer300(value)
	          .logout();  
	}*/
 
 @SuppressWarnings("unchecked") 
 @Test(groups = {Smoke})
	public void boilerRepairAndCoverLoggedInGasJourney(){
		Report.createTestLogHeader("Boiler Test", "Logged In Sign Up with different address through Annual payment- london postcode");	
		final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("LondonAcquisition");
		new HomePageAction()	                
		.navigateToLogin()
		.login(userProfile);
		new repairAndCoverAction("LoggedIn","yes","Annual","diffAddr")
		.navigateToBoilerLandingPage()
		.enterPostCode(acquisition)
		.verifyAndSelectAppointmentSlot()
		.verifyRepairAndCoverPage()
		.navigateToOrderNowPage()
		.enteringContactDetails(userProfile,acquisition)
		.selectingBoilerType()
		.paymentForFixedPriceRepair(acquisition)
		.paymentForMonthlyCover(acquisition)
		.enteringTermsAndConditions(userProfile)
		.verifyThankYouPage()
	    .anonymousAudit(userProfile)
	    .loginVerification();
		new HomePageAction()
		.logout();

	}
 
 @SuppressWarnings("unchecked") 
 @Test(groups = {Smoke})
	public void verifyContractCreationForOAMCustomers(){
		Report.createTestLogHeader("Model sales", "Verifying Contract creation for HC 400 OAM - JCI OptIn Customers");
		final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		int NoOfCombinations = 1;
		new HomePageAction()
		.navigateToLogin()
		.loginDetails(userProfile)
		.verifyLogin(userProfile.getLastName(),userProfile.getGasAccount());
		String combinations = "ServicesEmailNew";
		new ModelSalesAction("OAM","WithinM25","OptIn")
		    .modelSalesFlow(NoOfCombinations,combinations);	    			
	}
	
 @SuppressWarnings("unchecked") 
 @Test(groups = {Smoke})
 public void verifyCHIAppointmentAnonymousNewYes() {
    /////////// Select Yes for Is your boiler currently working ? in Your Property Page/////////////////
 	
 	Report.createTestLogHeader("CHI Appointment New Booking", "Anonymous");
     UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");	        
     new CHIAppointmentAction()
     			.navigateToYourPropertyPage()
     			.enterDetailsInYourPropertyPageYes(userProfile)
     			.selectFirtAvailableAppointment()
     			.enterPersonalDetails(userProfile)
     			.verifyConfirmationPage();
     		
 }
 
 @SuppressWarnings("unchecked") 
 @Test(groups = {Smoke})
	public void verifyAnonymousNationalLandlordPackagePricingWithoutBoilerCover(){
		Report.createTestLogHeader("LandLord Journey", "Verify Landlord Package Pricing without boiler");
		LandLord Landlord= new TestDataHelper().getLandLord("single");
		boolean BoilerCover = false;
		new LandlordActionNew()
			.navigateLandLordPage()
			.enterPostcodeDetails("al7 4hd")
			.verifyPackagePricing("National",BoilerCover)
			.fillPackageDetails(Landlord)
			.fillContactSectionAnonymous("al7 4hd")
			.enterPaymentDetails("")
			.enterTermsAndConditions("")
			.verifyThankYouPage();
	}
 
}
 