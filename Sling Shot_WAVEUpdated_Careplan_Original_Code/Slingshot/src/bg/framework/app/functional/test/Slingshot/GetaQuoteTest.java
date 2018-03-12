package bg.framework.app.functional.test.Slingshot;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.Slingshot.GetaQuoteAction;
import bg.framework.app.functional.action.Slingshot.MultiUserMultiViewAction;
import bg.framework.app.functional.action.Slingshot.SapCrmAction;
import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.entities.CrmUserProfile;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class GetaQuoteTest extends TestBase{
	
	// ********************************************* Get a Quote **************************************************************

//TS_quotes_011  Verify whether the "Your site details " page is getting displayed on clicking the "Next " button in the "Your contact details" page	
//TS_quotesR_053 Verify whether the user is navigate to the quote summary page when the user clicks 'Get a quote' button	
//TS_quotes_068(E to E) Verify whether the user able to submit the Electricity quote successfully
//TS_quotes_059 Verify whether the system display the green tick mark when the user select the yes for the "COT" question	
		@Test(groups ={})
		public void AnonymousElectGetaQuote()  {
			Report.createTestLogHeader("Get a Quote", "Verify whether the user able to submit the Electricity quote successfully"); 	   	  
			UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousGAQelec"); 	   
			CrmUserProfile crmuserProfile = new TestDataHelper().getCrmUserProfile("CrmDetailsforGetAQuote");
			new LoginAction()
			.BgbnavigateToLogin();
			new GetaQuoteAction()		
			.AnonymousGAQelec(userProfile)	
			.GAQ_Auditdetails(userProfile);
			//.SAPISU_GAQAction(userProfile)
	        //.loginDetailsforpaperbilling(crmuserProfile)
	        //.SearchCRMFields_GAQ(crmuserProfile,userProfile);		
			} 	
		
//TS_quotes_134(E to E) Verify whether the user able to submit the Gas quote successfully
//TS_quotesR_077 Verify whether the "Your site details " page is getting displayed on clicking the "Next " button in the "Your contact details" page		
//TS_quotes_125 Verify whether the system display the green tick mark when the user select the yes for the "COT" question 	
		@Test(groups ={})
		public void AnonymousGastGetaQuote()  {
			Report.createTestLogHeader("Get a Quote", "Verify whether the user able to submit the Gas quote successfully"); 	   	  
			UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousGAQgas"); 
			CrmUserProfile crmuserProfile = new TestDataHelper().getCrmUserProfile("CrmDetailsforGetAQuote");
			new LoginAction()
			.BgbnavigateToLogin();
			new GetaQuoteAction()			
			.AnonymousGAQgas(userProfile)
			.GAQ_Auditdetails(userProfile);
			/*.SAPISU_GAQAction(userProfile)
			.loginDetailsforpaperbilling(crmuserProfile)
	        .SearchCRMFields_GAQ(crmuserProfile,userProfile);	*/
		} 		
//TS_quotes_018  Verify whether the site address summary is getting displayed on clicking the confirm address in the site address section. 	
//TS_quotes_019  Verify whether the functionality of 'Remove link'  and "Back" link in the site details 		
//TS_quotesR_020 Verify whether the "Get a quote " button is disabled until all the details are entered in site details page.
//TS_quotes_021  Verify whether electricity meter details are displayed in site details page when the site details are entered.
//TS_quotes_023  Verify whether when customer selects 'No' in the 'Is this site in a <fuel> contract?' start date picker is displayed.	
//TS_quotes_024  Verify whether when customer selects 'Yes' in the 'Is this site in a <fuel> contract?' start and end date picker is displayed.
//TS_quotes_029  Verify whether the user is able to select the value from the drop down list of 'average spend'  and 'every' fields	
//TS_quotes_041	 Verify whether the functionality of the "get a quote" &  "back"  button in the site details page 	
		@Test
		public void AnonymousGAQverificationElec()  {
			Report.createTestLogHeader("Get a Quote", "Verify whether the user able to submit the Elec quote successfully"); 	   	  
			UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousGAQelec"); 	      
			new LoginAction()
			.BgbnavigateToLogin();
			new GetaQuoteAction()
			.AnonymousElecGasVerification(userProfile);		  	
			}
//TS_quotes_084  Verify whether the site address summary is getting displayed on clicking the confirm address in the site address section.
//TS_quotesR_087 Verify whether gas meter details are displayed in site details page when the site details are entered.		
//TS_quotes_095  Verify whether the user is able to select the value from the drop down list of 'average spend'  and 'every' fields		
//TS_quotes_097	 Verify whether the user is able to pick the date from the calendar for the "Preferred date for new contract" when the user select no for the existing contract
//TS_quotesR_107 Verify whether the functionality of the "get a quote" &  "back"  button in the site details page 		
		@Test(groups ={})
		public void AnonymousGAQverificationGas()  {
			Report.createTestLogHeader("Get a Quote", "Verify whether the user able to submit the Gas quote successfully"); 	   	  
			UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousGAQgas"); 	      
			new LoginAction()
			.BgbnavigateToLogin();
			new GetaQuoteAction()
			.AnonymousGAQGasVerification(userProfile);		  	
			}
//TS_quotes_036 a) Verify whether the user is navigate to the "large business confirmation" page when the user clicks the button "continue as large business" in "are you a large business" overlay
		//      b) Verify whether the content of the "large business confirmation" page 
		@Test(groups ={})
		public void AnonymousGAQLargerbusinessoverlayElec()  {
			Report.createTestLogHeader("Get a Quote", "Verify whether the content of the large business confirmation page for Elec" ); 	   	  
			UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousGAQelec"); 	      
			new LoginAction()
			.BgbnavigateToLogin();
			new GetaQuoteAction()
			.AnonymousGAQElec_LargerbusinessOverlay(userProfile);		  	
			}
//TS_quotes_102 a) Verify whether the user is navigate to the "large business confirmation" page when the user clicks the button "continue as large business" in "are you a large business" overlay
//          b) Verify whether the content of the "large business confirmation" page 
			@Test(groups ={})
			public void AnonymousGAQLargerbusinessoverlayGas()  {
			Report.createTestLogHeader("Get a Quote", "Verify whether the content of the large business confirmation page for Gas"); 	   	  
			UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousGAQgas"); 	      
			new LoginAction()
			.BgbnavigateToLogin();
			new GetaQuoteAction()
			.AnonymousGAQGas_LargerbusinessOverlay(userProfile);		  	
}
//TS_quotes_36 a) Verify whether the user is navigate to the "large business confirmation" page when the user clicks the button "continue as large business" in "are you a large business" overlay
				//      b) Verify whether the content of the "large business confirmation" page 
		@Test(groups ={})
		public void AnonymousGAQLBOverlaycloseandcontinueforElec()  {
			Report.createTestLogHeader("Get a Quote", "Verify whether the user is navigate to the large business confirmation page when the user clicks the button continue as large business for Elec"); 	   	  
			UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousGAQElecLargerunit"); 	      
			new LoginAction()
			.BgbnavigateToLogin();
			new GetaQuoteAction()
			.AnonymousGAQGas_LBoverlayforElec(userProfile);		  	
			}

		@Test(groups ={})
		public void AnonymousGAQLBOverlaycloseandcontinueforGas()  {
			Report.createTestLogHeader("Get a Quote", "Verify whether the user is navigate to the large business confirmation page when the user clicks the button continue as large business for Gas"); 	   	  
			UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousGAQGasLargerunit"); 	      
			new LoginAction()
			.BgbnavigateToLogin();
			new GetaQuoteAction()
			.AnonymousGAQGas_LBoverlayforGas(userProfile);		  	
			}

//TS_quotesR_045  Verify whether the  "please log into your account" page is displayed on clicking the "Next "link for customer who have already registered in online 		
		@Test(groups ={})
		public void AnonymousLoggeduserforElec()  {
			Report.createTestLogHeader("Get a Quote", "Verify whether the  please log into your account page is displayed on clicking the Next link for customer who have already registered in online  for elec"); 	   	  
			UserProfile userProfile = new TestDataHelper().getUserProfile("GAQloggedUserforElec"); 	      
			new LoginAction()
			.BgbnavigateToLogin();
			new GetaQuoteAction()			
			.AnonymousLoggesinforelec(userProfile);			  	
			}
//TS_quotes_111 Verify whether the  "please log into your account" page is displayed on clicking the "get a quote" button for customer who have already registered in online
//TS_quotes_112 Verify whether the user is able to login into the account on clicking 'Log in' link in "please log into your account" page   				
			@Test(groups ={})
			public void AnonymousLoggeduserforGas()  {
				Report.createTestLogHeader("Get a Quote", "VVerify whether the  please log into your account page is displayed on clicking the Next link for customer who have already registered in online  for Gas"); 	   	  
				UserProfile userProfile = new TestDataHelper().getUserProfile("GAQloggedUserforGas"); 	      
				new LoginAction()
				.BgbnavigateToLogin();
				new GetaQuoteAction()			
				.AnonymousLoggesinforGas(userProfile);			  	
				}
//TS_quotes_047 Verify whether the overlay is displayed when customer submits the quote without entering site details and Verify whether the content of the "Get a quote  with incomplete site" warning overlay
//TS_quotes_048 a) Verify whether the user is able to click the "get a quote" button in the "Get a quote with incomplete site" warning overlay 		
		@Test(groups ={})
		public void AnonymousGAQincompletesiteOverlayforelec()  {
			Report.createTestLogHeader("Get a Quote", "Verify whether the user able to submit the Gas quote successfully"); 	   	  
			UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousincompletesiteElec"); 	      
			new LoginAction()
			.BgbnavigateToLogin();
			new GetaQuoteAction()			
			.Anonymousincompletesiteoverlayforelec(userProfile);			  	
			}
//TS_quotesR_113 Verify whether the overlay is displayed when customer submits the quote without entering site details and Verify whether the content of the "Get a quote  with incomplete site" warning overlay
//TS_quotes_114 a) Verify whether the user is able to click the "get a quote" button in the "Get a quote with incomplete site" warning overlay 		
		@Test(groups ={})
		public void AnonymousGAQincompletesiteOverlayforgas()  {
			Report.createTestLogHeader("Get a Quote", "Verify whether the user able to submit the Gas quote successfully"); 	   	  
			UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousincompletesiteGas"); 	      
			new LoginAction()
			.BgbnavigateToLogin();
			new GetaQuoteAction()			
			.Anonymousincompletesiteoverlayforgas(userProfile);			  	
			}

//TS_quotes_038  Verify whether the user is able to click the "add another site" link in the site details page 	
//TS_quotes_013  Verify whether the 'Add another site' link is getting disabled once maximum limit is reached.		
//TS_quotes_017  Verify whether user can add a new site by clicking on add another site accordion.		
//TS_quotes_039 Verify whether the current site address details collapses and new site details will display in the site details page.
//TS_quotes_040 Verify whether the "Add another site" link  is disabled  when the user added  15 sites in the site details page with same start date and different date 
		@Test(groups ={})
		public void AnonymousAddMaximumSiteforElec()  {
			Report.createTestLogHeader("Get a Quote", "Verify whether the user able to submit the Gas quote successfully"); 	   	  
			UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousGAQelec"); 	      
			new LoginAction()
			.BgbnavigateToLogin();
			new GetaQuoteAction()			
			.MaxiumAddanothersiteElec(userProfile);			  	
			}
//TS_quotes_051 Verify whether the error message is displayed for meter De-energized. 	
		@Test(groups ={})
		public void Deenergisederrorvalidation()  {
			Report.createTestLogHeader("Get a Quote", "Verify whether the error message is displayed for meter De-energized."); 	   	  
			UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousDeenergized"); 	      
			new LoginAction()
			.BgbnavigateToLogin();
			new GetaQuoteAction()			
			.deenergisederror(userProfile);			  	
			}
//TS_quotes_052 Verify whether the error message is displayed for half hourly meter found.   		
		@Test(groups ={})
		public void ValidateHalfHourmeter()  {
			Report.createTestLogHeader("Get a Quote", "Verify whether the user able to submit the Gas quote successfully"); 	   	  
			UserProfile userProfile = new TestDataHelper().getUserProfile("Anmonymoushalfhourlymeter"); 	      
			new LoginAction()
			.BgbnavigateToLogin();
			new GetaQuoteAction()			
			.Validatehalfhourlymeter(userProfile);			  	
			}	
		
//TS_quotes_116 Verify whether the content of the error message for the multi meter   found when the user searched manually. 	 		
		@Test(groups ={})
		public void GAQmorefuelfound()  {
			Report.createTestLogHeader("Get a Quote", "Verify whether the user able to submit the Gas quote successfully"); 	   	  
			UserProfile userProfile = new TestDataHelper().getUserProfile("anonymousmorefuelfound"); 	      
			new LoginAction()
			.BgbnavigateToLogin();
			new GetaQuoteAction()			
			.morefuelfoundvalidation(userProfile);			  	
			}
//TS_quotes_117 Verify whether the content of error message display for the customer under the category of bad data 	
		@Test(groups ={})
		public void GAQbaddatavalidation()  {
			Report.createTestLogHeader("Get a Quote", " Verify whether the content of error message display for the customer under the category of bad data  for elec"); 	   	  
			UserProfile userProfile = new TestDataHelper().getUserProfile("Anonymousbaddatavalidation"); 	      
			new LoginAction()
			.BgbnavigateToLogin();
			new GetaQuoteAction()			
			.AnonymousGAQbaddata(userProfile);			  	
			}
//TS_quotes_65 Verify whether the user is able to click the "Request call back" button in the quote summary page 	
		@Test(groups ={})
		public void GAQsummaryRequestcallbackElec()  {
			Report.createTestLogHeader("Get a Quote", "Verify whether the user is able to click the Request call back button in the quote summary page for Elec"); 	   	  
			UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousGAQelec"); 	      
			new LoginAction()
			.BgbnavigateToLogin();
			new GetaQuoteAction()		
			.AnonymousGAQelec(userProfile)	
			.GAQ_Auditdetails(userProfile)		
			.AnonymousGAQSummaryRCB(userProfile);
			}
//TS_quotes_124 Verify whether the user is able to click the "Request call back" button in the quote summary page 	
		@Test(groups ={})
		public void GAQsummaryRequestcallbackGas()  {
			Report.createTestLogHeader("Get a Quote", "Verify whether the user is able to click the Request call back button in the quote summary page for Gas"); 	   	  
			UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousGAQgas"); 	      
			new LoginAction()
			.BgbnavigateToLogin();
			new GetaQuoteAction()		
			.AnonymousGAQGas(userProfile)	
			.GAQ_Auditdetails(userProfile)	
			.AnonymousGAQSummaryRCB(userProfile);
			}
		
//TS_quotes_083  Verify whether user can add a new site by clicking on add another site accordion.
//TS_quotes_106  Verify whether the user is unable to add more than 15 sites in the site details page by clicking the "Add another site" link 		
		@Test(groups ={})
		public void AnonymousAddMaximumSiteforGas()  {
			Report.createTestLogHeader("Get a Quote", "Verify whether the user able to submit the Gas quote successfully"); 	   	  
			UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousGAQgas"); 	      
			new LoginAction()
			.BgbnavigateToLogin();
			new GetaQuoteAction()			
			.MaxiumAddanothersiteGas(userProfile);			  	
			}		
//TS_quotes_152(E to E) Verify whether the user able to submit the Gas quote successfully by logging-in with valid credentials
	@Test(groups ={})
	public void VerifyLoggedGetaQuoteforgas()  {
		Report.createTestLogHeader("Get a Quote", "Verify whether the user able to submit the Gas quote successfully by logging-in with valid credentials"); 	   	  
		UserProfile userProfile = new TestDataHelper().getUserProfile("GAQloggedUserforGas"); 	      
		new LoginAction()
		.BgbnavigateToLogin()
		.BgbloginDetails(userProfile);
		new GetaQuoteAction()
		.ManageLinkNavigation(userProfile)
		.ClickGetaGasQuoteAction(userProfile)
		.GAQ_Auditdetails_logged(userProfile);
	}
//TS_quotes_143(E to E) whether the user able to submit the Electricity quote successfully by logging-in with valid credentials 	
	@Test(groups ={})
	public void VerifyLoggedGetaQuoteforElec()  {
		Report.createTestLogHeader("Get a Quote", "whether the user able to submit the Electricity quote successfully by logging-in with valid credentials for elec"); 	   	  
		UserProfile userProfile = new TestDataHelper().getUserProfile("GAQloggedUserforElec"); 	      
		new LoginAction()
		.BgbnavigateToLogin()
		.BgbloginDetails(userProfile);
		new GetaQuoteAction()
		.ManageLinkNavigation(userProfile)
		.ClickGetelecQuoteAction(userProfile)		 
		.GAQ_Auditdetails_logged(userProfile);
	}	
	
//TS_quotes_135 a)verify the user is able to click the "Get a quote " link from the account summary page
//				b) verify the user is able to navigate to request call back link by clicking on the "Request a call back " link  	
	@Test(groups ={})
	public void LoggedinRequestcallmebackElec()  {
		Report.createTestLogHeader("Get a Quote", "verify the user is able to navigate to request call back link by clicking on the Request a call back link for Elec"); 	   	  
		UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousGAQLoggedelec"); 	      
		new LoginAction()
		.BgbnavigateToLogin()
		.BgbloginDetails(userProfile);
		new GetaQuoteAction()
		.ManageLinkNavigation(userProfile)		
		.RequestcallmebackElecuser(userProfile);		  	
	} 	
//TS_quotes_144 a)verify the user is able to click the "Get a quote " link from the account summary page
	//          b) verify the user is able to navigate to request call back link by clicking on the "Request a call back " link 	
	@Test(groups ={})
	public void LoggedinRequestcallmebackGas()  {
		Report.createTestLogHeader("Get a Quote", "verify the user is able to navigate to request call back link by clicking on the Request a call back link for gas"); 	   	  
		UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousGAQLoggedgas"); 	      
		new LoginAction()
		.BgbnavigateToLogin()
		.BgbloginDetails(userProfile);
		new GetaQuoteAction()
		.ManageLinkNavigation(userProfile)		
		.RequestcallmebackGasuser(userProfile);		  	
	} 			
	
	
}
