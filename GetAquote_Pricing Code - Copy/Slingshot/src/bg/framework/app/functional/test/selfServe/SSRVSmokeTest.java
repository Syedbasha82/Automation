package bg.framework.app.functional.test.selfServe;

import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.action.sales.UpsellAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.action.selfServe.AccountSummaryAction;
import bg.framework.app.functional.action.selfServe.SMRAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.Ddcps;
import bg.framework.app.functional.entities.GetAPrice;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class SSRVSmokeTest extends TestBase{

	   @SuppressWarnings("unchecked")
	   @Test(groups = {Smoke})
	    public void verifySmokeTestPath1() {
	        Report.createTestLogHeader("Smoke Test Path 1", "HomePage_Tariff Page_Get a Price_ContactUs_Login_Acc Overview_AccountSummary_MPD_Logout");
	        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
	        UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
	        //Anonymous Get a Price
	        new HomePageAction()
	                .navigateToGasAndElectricityPage()
	                .navigateToGetAPricePage()
	                .verifyAndEnterGAPDetails(getaPrice, userProfile);
	       //Anonymous Contact Us
	        new HomePageAction()
		            .navigateToContactUsPage()
		            .verifyContactUsAnon(userProfile,"Anonymous");
	        //Login-Account Overview-Account Summary
	        UserProfile userProfile1 = new TestDataHelper().getUserProfile("GasAccount");
            getCustomerDetailsToUserProfileOAM(userProfile1);
            new HomePageAction()
	            	.navigateToYouAccPage()	            
	            	.loginUserDetails(userProfile1)
	            	.calllogs(userProfile1) 
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile1.getAccNumber())
	                .navigateToAccountSummaryPage()
	                .verifyAccountSummaryPageAction(userProfile1.getAccNumber());
           //Manage Personal Details 
           UserProfile userProfileReset = userProfile1;
           new AccountSummaryAction()
                   		.navigateToManagePersonalDetailsPage()
                		.fillValidDataInManagePersonalDetailsPage(userProfile1)
                		.verifyFillDataWithDB(userProfile1)
                		.verifyFillDataWithSiebel(userProfile1)
                		.verifyConfirmationOverLayClickLogin()
                		.login(userProfile1)
                		.navigateToAccountSummaryPage(userProfile1)
                		.navigateToManagePersonalDetailsPage()
                		.logout();
                		
                        getCustomerDetailsToUserProfileOAM(userProfileReset);
                        userProfile1 = userProfileReset;
	        
	 }
	 
	   @SuppressWarnings("unchecked")
	   @Test(groups = {Smoke})
	    public void verifySmokeTestPath2() {
	        Report.createTestLogHeader("Smoke Test Path 2", "HomePage_ForgotEmail_ForgotPwd_Login_Acc Overview_Acc Summary_DDCPS_Logout");
	        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	        getCustomerDetailsToUserProfileOAM(userProfile);
	        //Forgot Email Journey
            new HomePageAction()
            		.navigatetoForgotEmailPage()
                    .verifyForgotEmailPage(userProfile)
                    .verifyForgotEmailBreadCrumbValidation(userProfile)
                    .verifyForgotEmailWhereCanIFindValidation(userProfile)
                    .verifyForgotEmailTitleValidation(userProfile)
                    .verifyEnterEmailValidation(userProfile);
            
            activateCustomerDetailsInOnlineDB(userProfile);
            getCustomerDetailsToUserProfileOAM(userProfile);
            final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
            //Forgot Password Journey
            new HomePageAction()
                    .navigateToForgottenPasswordScreen()
                    .verifyOneTimePwd(userProfile)
                    .verifyAudit(userProfile);
            //Login-Account Overview-Account Summary-DDCPS
            new HomePageAction()
		        	.navigateToLoginPage()	            
		        	.loginUserDetails(userProfile)
		        	.calllogs(userProfile)
		        	.verifyAccountOverviewAction()
		            .verifyAddress(userProfile.getAccNumber())
		            .navigateToAccountSummaryPage() .verifyAccountSummaryPageAction(userProfile.getAccNumber());//DDCPS Journey
		            /*.switchToDD(ddcps)
					.selectAccountsForSwitchingToDD(userProfile,"Gas")
					.meterReadOverlay("Gas")
					.enterPaymentDateForQuarterlyCustomer()
					.paymentAmountAndCreditRefund()
					.setUpDDMakeAPayment()
					.enterBankDetailsForQuarterlyCustomer()
					.reviewAndConfirmDDSetUp()
					.logOutLink();*/
    
	   }
	
	    @Test(groups = { Smoke})
		public void verifySmokeTestPath3(){
	    	
			Report.createTestLogHeader("Smoke Test Path 3","Booking Complete -ASV combined with IB Journey Test - Book First - Added GAC & COD");
			UserProfile userProfile = new TestDataHelper().getUserProfile("HomeSerivcesAccount");
			getCustomerDetailsToUserProfileOAM(userProfile);
			//ASV-IB
			new HomePageAction()
					.navigateToLogin()
					.loginUserDetails(userProfile)
					.calllogs(userProfile)
					.navigateToAccountSummaryPageASV()
					.verifyAccountOverview("Ideal")
					.bookAnEngineer(userProfile, "IV")		
					.navigateToIdentifyFault()		
					.navigateToReview(1)		
					.selectAnAppointment()
					.navigateToConfirmation(userProfile, 4)
					.navigateTrackCancelChange()
					.bookAnEngineer(userProfile, "ASV")					
					.navigateToConfirmation(userProfile, 1)
					.navigateTrackCancelChange()
					.accountSummarycancelAppointment()
					.logout();
		}
	   
	    @SuppressWarnings("unchecked")
	    @Test(groups = {Smoke})
	    public void verifySmokeTestPath4() throws Exception {
	        Report.createTestLogHeader("Smoke Test Path 4", "Registration_Cross Sell_Up Sell_HelpAndAdvice_Make a Payment_SMR_Meter Read History");
	        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	        //Registration
	        preRegister(userProfile);	      
	        new HomePageAction()
	                .navigateToRegistration()
	                .registerUpdateYourDetails(userProfile, userProfile.getElecAccount())
	                .goToYourAccount()
	                .verifyRegisteredNewUser(userProfile,userProfile.getLastName(), userProfile.getElecAccount())
	                .verifyAccountPresense(userProfile.getElecAccount());	
	        //Cross sell
	        new AccountOverviewAction()
	                .navigateTOAddGasPage()
	                .yourOrderElecBG(acquisition)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyLeadData()
	                .domarssalesRunBatch(acquisition.getShopBatch()) 
	                .backToHomePage();
	         UserProfile userProfile1 = new TestDataHelper().getUserProfile("HomeCare200Account");	        
		     getCustomerDetailsToUserProfileOAM(userProfile1);
		     String value ="200";
		     //Upsell
		     new UpsellAction()
		                 .loginUser(userProfile)
		                 .verifyUpgradeCustomer(value);
		     //Help and Advice
		     new HomePageAction()
		             .navigatetoHelpAndAdvicePage()
		             .verifyLinksinPage()
		             .getHelpandAdviceAuditType(userProfile.getUCRN());
		     //Submit Meter Read
		     new SMRAction().resetMeterRead(userProfile.getElecAccount());
			 new HomePageAction()
					.navigateToLogin()
					.login(userProfile)
					.navigateToAccountSummaryPage(userProfile).navigateToSMRPage()
				    .setPlausbileReading(userProfile.getElecAccount())
				    .confirmAccountSelection().submitMeterReads()
				    .verifyMeterConfirmation(userProfile.getElecAccount());
			 // Make a payment
			 //Meter Read History
			 new LoginAction()	            
			     	.loginUserDetails(userProfile)
			     	.verifyAccountOverviewAction()
			        .verifyAddress(userProfile.getElecAccount())
			        .navigateToAccountSummaryPage()
			        .verifyPaymentHistory(userProfile)
			        .verifyMakeAPayment(userProfile.getElecAccount())
			        .verifySearchField(userProfile.getSecurityQuestion())
			        .verifyTransactionHistoryItems()
			        .verifyDateField()
			        .verifyBillHistory()
			        .verifyMeterReadHistory(userProfile.getElecAccount());
		        
	    }
	    private void preRegister(UserProfile userProfile) {
	        activateCustomerDetailsInOnlineDB(userProfile);
	        getCustomerDetailsToUserProfileAnonymous(userProfile);
	        OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
	        onlineDBConnector.deRegister(userProfile.getUCRN());
	    }
}
