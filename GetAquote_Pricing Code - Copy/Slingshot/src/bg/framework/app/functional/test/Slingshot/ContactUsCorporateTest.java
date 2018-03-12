/**
 * 
 */
package bg.framework.app.functional.test.Slingshot;

import static bg.framework.app.functional.entities.FunctionalCategory.BGBRegistration;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import static bg.framework.app.functional.entities.FunctionalCategory.Slingshot;
import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.Slingshot.ContactUsBusinessAction;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

/**
 * @author 208070
 *
 */
public class ContactUsCorporateTest extends TestBase {
	static String[] Tabs={"MyAccountandBilling", "SwitchingtoBG", "MyMeterReadingsandMeter", "MovingPremises", "BreakdownandServices"};
	//Corporate - TC_CU_Corporate_002 -- Validate whether the "Contact Us" landing page is displayed for logged in customers and verify the look and feel of "Contact Us" landing page for Logged in customers
	//Corporate - TC_CU_Corporate_003	 -- Validate the links in 'Do it online'panel are getting displayed and link navigations while the user selects 'My account and billing' radio button for logged in customer
	@SuppressWarnings("unchecked")
	@Test(groups ={Slingshot,Smoke,BGBRegistration})	
	public void verifyContactUsMyAccountandBillingCorporate(){
		Report.createTestLogHeader("ContactUs - Corporate", "Validate the links in Do it online panel are getting displayed and link navigations while the user selects My account and billing radio button for logged in customer");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
		new HomePageAction()
		.BgcnavigateToLogin()
		.BgcloginDetails(userProfile)
		.navigatetoContactUsCorporatelink()
		.verifyMyAccountandBilling()
		.verifyMovingPremises()
		.verifyBreakdownandServices()
		.logout();
	}

	//Corporate - TC_CU_Corporate_004 -- Validate the "Search" button functionality of   "Help & advice"  panel of "My account and billing" radio button for logged in customer
	@SuppressWarnings("unchecked")
	@Test(groups ={Slingshot,Smoke,BGBRegistration})	
	public void verifyContactUsSearchMyAccountandBilling(){
		String[] search={"Payment options", "transfer", "estimating", "premises", "Breakdown"};
		String[] content={"Payment options", "Transferring your account", "Estimating your usage", "What should I do if I am moving into a new premise?", "Breakdown callouts"};
		Report.createTestLogHeader("ContactUs - Corporate", "Validate the Search button functionality of Help & advice panel of My account and billing radio button for logged in customer");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
		new HomePageAction()
		.BgcnavigateToLogin()
		.BgcloginDetails(userProfile)
		.navigatetoContactUsCorporatelink();
		for(int i=0;i<Tabs.length;i++){
			new ContactUsBusinessAction()
			.selectTab(Tabs[i])
			.SearchFuctionality(search[i] , content[i], Tabs[i]);
		}
		new ContactUsBusinessAction()
		.logout();
	}
	//Corporate - TC_CU_Corporate_005 -- Validate the "Search" button functionality of   "Help & advice"  panel of "Switching to British Gas" radio button for logged in customer
	@SuppressWarnings("unchecked")
	@Test(groups ={Slingshot,Smoke,BGBRegistration})	
	public void verifyContactUsSearchSwitchingtoBritishGas(){
		Report.createTestLogHeader("ContactUs - Corporate", "Validate the Search button functionality of Help & advice panel of Switching to British Gas radio button for logged in customer");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
		new HomePageAction()
		.BgcnavigateToLogin()
		.BgcloginDetails(userProfile)
		.navigatetoContactUsCorporatelink()
		.selectSwitchingtoBGtab()
		.SearchFuctionality("transfer" , "Transferring your account", "SwitchingtoBG")
		.logout();
	}
	//Corporate - TC_CU_Corporate_007 -- Validate the "Search" button functionality of   "Help & advice"  panel of "My meter readings & meter" radio button for logged in customer
	@SuppressWarnings("unchecked")
	@Test(groups ={Slingshot,Smoke,BGBRegistration})	
	public void verifyContactUsSearchMyMeterReadingsandMeter(){
		Report.createTestLogHeader("ContactUs - Corporate", "Validate the Search button functionality of Help & advice panel of My meter readings & meter radio button for logged in customer");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
		new HomePageAction()
		.BgcnavigateToLogin()
		.BgcloginDetails(userProfile)
		.navigatetoContactUsCorporatelink()
		.selectMyMeterReadingsandMetertab()
		.SearchFuctionality("estimating" , "Estimating your usage", "MyMeterReadingsandMeter")
		.logout();
	}
	//Corporate - TC_CU_Corporate_08  --	To check whether the user can able to contact customer care team by clicking email us link for logged in customers and validate whether the "email us" landing page is getting displayed for Logged in customers, Verify the link navigations in "Email us" landing page for logged in customers a)LHN  b)RHN c)"Where I can find this" link of account number field
	@SuppressWarnings("unchecked")
	@Test(groups ={Slingshot,Smoke,BGBRegistration})	
	public void verifyContactUsEmailUsLoggedInCustomers(){
		Report.createTestLogHeader("ContactUs - Corporate", "Validate whether the email us landing page is getting displayed for Logged in customers");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
		new HomePageAction()
		.BgcnavigateToLogin()
		.BgcloginDetails(userProfile)
		.navigatetoContactUsCorporatelink()
		.navigatetoEmailContactUslink("MyAccountandBilling")
		.verifyWhereCanIFindThisLink();
	}
	//Corporate - TC_CU_Corporate_012 -- Verify the user can select the menu from the tab option " My account & billing " in "Query regarding" drop down field for logged in customer
	@SuppressWarnings("unchecked")
	@Test(groups ={Slingshot,Smoke,BGBRegistration})	
	public void verifyContactUsEmailUsMyAccountandBillingdropdown(){
		String[] Tabs1={"MyAccountandBilling", "SwitchingtoBG", "MyMeterReadingsandMeter"};
		Report.createTestLogHeader("ContactUs - Corporate", "Verify the user can select the menu from the tab option My account & billing in Query regarding drop down field for logged in customer");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
		new HomePageAction()
		.BgcnavigateToLogin()
		.BgcloginDetails(userProfile)
		.navigatetoContactUsCorporatelink();
		for(int i=0;i<Tabs.length;i++){
			new ContactUsBusinessAction()
			.selectTab(Tabs[i])
			.navigatetoEmailContactUsCorporatelink(Tabs[i])
			.verifyEmailUs(Tabs[i]);
		}
		new ContactUsBusinessAction()
		.logout();
	}
	//Corporate - TC_CU_Corporate_013 -- Verify the user can select the menu from the tab option "Switching to British Gas" in "Query regarding" drop down field for logged in customer
	@SuppressWarnings("unchecked")
	@Test(groups ={Slingshot,Smoke,BGBRegistration})	
	public void verifyContactUsEmailUsSwitchingtoBritishGasdropdown(){
		Report.createTestLogHeader("ContactUs - Business", "Verify the user can select the menu from the tab option Switching to British Gas in Query regarding drop down field for logged in customer");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
		new HomePageAction()
		.BgcnavigateToLogin()
		.BgcloginDetails(userProfile)
		.navigatetoContactUsCorporatelink()
		.selectSwitchingtoBGtab()
		.navigatetoEmailContactUslink("SwitchingtoBG")
		.verifyEmailUs("SwitchingtoBG")
		.logout();
	}
	//Corporate - TC_CU_Corporate_024 -- Validate the links in 'Do it online'panel are getting displayed and link navigations while the user selects 'MovingPremises' radio button for logged in customer
			@SuppressWarnings("unchecked")
	@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsMovingPremises(){
				Report.createTestLogHeader("ContactUs - Corporate", "Validate the links in Do it online panel are getting displayed and link navigations while the user selects MovingPremises radio button for logged in customer");
			    UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
			    new HomePageAction()
			    .BgcnavigateToLogin()
				.BgcloginDetails(userProfile)
		    	.navigatetoContactUsCorporatelink()
		    	.verifyMovingPremises()
		    	.logout();
		   	}		
			
	//Corporate - TC_CU_Corporate_026 -- Validate the links in 'Do it online'panel are getting displayed and link navigations while the user selects 'Breakdown & servicing' radio button for logged in customer
	//Corporate - TC_CU_Corporate_027 -- Validate whether the links in "Help & advice" panel are getting displayed and link navigations while the user selects "Breakdown & servicing" radio button for logged in customer
			@SuppressWarnings("unchecked")
	@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsBreakdownandServicing(){
				Report.createTestLogHeader("ContactUs - Corporate", "Validate the links in Do it online panel are getting displayed and link navigations while the user selects Breakdown & servicing radio button for logged in customer");
			    UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
			    new HomePageAction()
			    .BgcnavigateToLogin()
				.BgcloginDetails(userProfile)
		    	.navigatetoContactUsCorporatelink()
		    	.verifyBreakdownandServices()
		    	.logout();
		   	}				
	//Corporate - TC_CU_Corporate_025 -- Validate the "Search" button functionality of   "Help & advice"  panel of "Moving premises" radio button for logged in customer
			@SuppressWarnings("unchecked")
			@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsSearchMovingPremises(){
				Report.createTestLogHeader("ContactUs - Corporate", "Validate the Search button functionality of Help & advice panel of Moving premises radio button for logged in customer");
			    UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
			    new HomePageAction()
			    .BgcnavigateToLogin()
				.BgcloginDetails(userProfile)
		    	.navigatetoContactUsCorporatelink()
		    	.selectMovingPremisestab()
		    	.SearchFuctionality("premises" , "Supplying energy to my new premises", "MovingPremises")
		    	.logout();
			}
	//Corporate - TC_CU_Corporate_028 -- Validate the "Search" button functionality of   "Help & advice"  panel of "Breakdown & servicing" radio button for logged in customer
			@SuppressWarnings("unchecked")
			@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsSearchBreakdownandServices(){
				Report.createTestLogHeader("ContactUs - Corporate", "Validate the Search button functionality of Help & advice panel of Breakdown & servicing radio button for logged in customer");
			    UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
			    new HomePageAction()
			    .BgcnavigateToLogin()
				.BgcloginDetails(userProfile)
		    	.navigatetoContactUsCorporatelink()
		    	.selectBreakdownandServicestab()
		    	.SearchFuctionality("Breakdown" , "Breakdown callouts?", "BreakdownandServices")
		    	.logout();
			}	
	//Corporate - TC_CU_Corporate_031 -- Verify the user can select the menu from the tab option "My meter readings & meter" in "Query regarding" drop down field for logged in customer
			@SuppressWarnings("unchecked")
			@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsEmailUsMyMeterReadingsandMeterdropdown(){
				Report.createTestLogHeader("ContactUs - Corporate", "Verify the user can select the menu from the tab option My meter readings & meter in Query regarding drop down field for logged in customer");
			    UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
			    new HomePageAction()
			    .BgcnavigateToLogin()
				.BgcloginDetails(userProfile)
		    	.navigatetoContactUsCorporatelink()
		    	.selectMyMeterReadingsandMetertab()
		    	.navigatetoEmailContactUslink("MyMeterReadingsandMeter")
		    	.verifyEmailUs("MyMeterReadingsandMeter")
		    	.logout();
		   	}
			
	//Corporate - TC_CU_Corporate_022	 -- Vaildate whether the user is able to proceed "Contact Us" journey by navigations in home page for Anonymous customers
	//Corporate - TC_CU_Corporate_023  --	a)Validate whether the "Contact Us" landing page is displayed for Anonymous customers, b)Verify the look and feel of"Contact Us" landing page for Anonymous customers, 	c)Verify the link navigations in "Contact Us" landing page for Anonymous customers 1)LHN ,2)RHN	
			@SuppressWarnings("unchecked")
			@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsAnonymousCustomers(){
			 	Report.createTestLogHeader("ContactUs - Corporate", "Vaildate whether the user is able to proceed Contact Us journey by navigations in home page for Anonymous customers");
			    new HomePageAction()
			    .BgcnavigatetoCorporate()
			   	.navigatetoContactUslink()
		    	.verifyLHN();
		   	}
	//Corporate - TC_CU_Corporate_001	--	Vaildate whether the user is able to proceed "Contact Us" journey by navigations in home page for Logged in customers(end to end flow)
	//Corporate - TC_CU_Corporate_017  --	Verify the functionality of Submit button for logged in customer and check whether Confirmation page is getting displayed after submitting  the complaint for logged in customer
	//Corporate - TC_CU_Corporate_019  --   Check whether confirmation email is triggered to customer for logged in customer with attachment and verify the look and feel of confirmation email is triggered to customer for logged in customer and verify the link navigations of confirmation email is triggered to customer for logged in customer
	@SuppressWarnings("unchecked")
	@Test(groups ={Slingshot,Smoke,BGBRegistration})	
	public void verifyContactUsConfirmationPageLoggedInCustomers(){
		Report.createTestLogHeader("ContactUs - Corporate", "Verify the functionality of Confirmation page for Logged in customers");
	 	UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
	 	 new HomePageAction()
	 	 	.BgcnavigateToLogin()
			.BgcloginDetails(userProfile)
		    .AddressCapturing()
	    	.navigatetoContactUsCorporatelink()
	   	   	.navigatetoEmailContactUslink("MyAccountandBilling")
		    .verifyConfirmationinEmailUsLoggedInCust(userProfile);
	}
	//Corporate - TC_CU_Corporate_035  --  a)Check whether the email address overlay is getting displayed and the user can enter address manually by clicking "Enter your address manually" link for BGB Anonymous customer.b)Verify the look and feel of Email address overlay for BGB Anonymous customer. c)Validate the functionalities of buttons in Email address overlay for BGB Anonymous customer i)County (drop down) ii)Submit(button)
	//Corporate - TC_CU_Corporate_040  --  a)Check whether Confirmation page is getting displayed after submitting  the complaint for anonymous customer b)Verify the look and feel of Confirmation  page for anonymous customer c)Verify the link navigations of Confirmation  page for anonymous customer
	//Corporate - TC_CU_Corporate_042  --  a)Check whether confirmation email is triggered to customer for anonymous customer with attachment and with same unique reference number
	@SuppressWarnings("unchecked")
	@Test(groups ={Slingshot,Smoke,BGBRegistration})	
	public void verifyContactUsEnterAddressManuallyBGB(){
		Report.createTestLogHeader("ContactUs - Corporate", "Verify enter address manually by clicking Enter your address manually link for BGB Customers");
	 	UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
	 	 new HomePageAction()
	 	.BgcnavigatetoCorporate()
	   	.navigatetoContactUslink()
	   	.navigatetoEmailContactUslink("MyAccountandBilling")
	   	.validateEnterAddressManually(userProfile, "BGCustomer", "BG Customer Radio Button");
	}
}
