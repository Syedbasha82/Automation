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
		public class ContactUsBusinessTest extends TestBase {
			static String[] Tabs={"MyAccountandBilling", "SwitchingtoBG", "MyMeterReadingsandMeter", "MovingPremises", "BreakdownandServices"};
			//Business - TC_CU_Bus_002 -- Validate whether the "Contact Us" landing page is displayed for logged in customers and verify the look and feel of "Contact Us" landing page for Logged in customers
			//Business - TC_CU_Bus_003	 -- Validate the links in 'Do it online'panel are getting displayed and link navigations while the user selects 'My account and billing' radio button for logged in customer
			@SuppressWarnings("unchecked")
			@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsMyAccountandBillingBusiness(){
					Report.createTestLogHeader("ContactUs - Business", "Validate the links in Do it online panel are getting displayed and link navigations while the user selects My account and billing radio button for logged in customer");
				UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
				new HomePageAction()
				.BgbnavigateToLogin()
				.BgbloginDetails(userProfile)
				.navigatetoContactUslink()
				.verifyMyAccountandBilling()
				.verifySwitchingtoBritishGas()
				.verifyMyMeterReadingsandMeter()
				.verifyMovingPremises()
				.verifyBreakdownandServices()
				.logout();
			}
		
			//Business - TC_CU_Bus_005 -- Validate the links in 'Do it online'panel are getting displayed and link navigations while the user selects 'Switching to British Gas' radio button for logged in customer
			@SuppressWarnings("unchecked")
			//	@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsSwitchingtoBritishGas(){
				Report.createTestLogHeader("ContactUs - Business", "Validate the links in Do it onlin'panel are getting displayed and link navigations while the user selects Switching to British Gas radio button for logged in customer");
				UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
				new HomePageAction()
				.BgbnavigateToLogin()
				.BgbloginDetails(userProfile)
				.navigatetoContactUslink()
				.verifySwitchingtoBritishGas()
				.logout();
			}
		
			//Business - TC_CU_Bus_007 -- Validate the links in 'Do it online'panel are getting displayed and link navigations while the user selects 'My Meter Readings and Meter' radio button for logged in customer
			@SuppressWarnings("unchecked")
			//		@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsMyMeterReadingsandMeter(){
				Report.createTestLogHeader("ContactUs - Business", "Validate the links in Do it online panel are getting displayed and link navigations while the user selects My Meter Readings and Meter radio button for logged in customer");
				UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
				new HomePageAction()
				.BgbnavigateToLogin()
				.BgbloginDetails(userProfile)
				.navigatetoContactUslink()
				.verifyMyMeterReadingsandMeter()
				.logout();
			}
		
			//Business - TC_CU_Bus_027 -- Validate the links in 'Do it online'panel are getting displayed and link navigations while the user selects 'MovingPremises' radio button for logged in customer
			@SuppressWarnings("unchecked")
			//		@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsMovingPremises(){
				Report.createTestLogHeader("ContactUs - Business", "Validate the links in Do it online panel are getting displayed and link navigations while the user selects MovingPremises radio button for logged in customer");
				UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
				new HomePageAction()
				.BgbnavigateToLogin()
				.BgbloginDetails(userProfile)
				.navigatetoContactUslink()
				.verifyMovingPremises()
				.logout();
			}		
		
			//Business - TC_CU_Bus_029 -- Validate the links in 'Do it online'panel are getting displayed and link navigations while the user selects 'Breakdown & servicing' radio button for logged in customer
			//Business - TC_CU_Bus_030 -- Validate whether the links in "Help & advice" panel are getting displayed and link navigations while the user selects "Breakdown & servicing" radio button for logged in customer
			@SuppressWarnings("unchecked")
			//		@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsBreakdownandServicing(){
				Report.createTestLogHeader("ContactUs - Business", "Validate the links in Do it online panel are getting displayed and link navigations while the user selects Breakdown & servicing radio button for logged in customer");
				UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
				new HomePageAction()
				.BgbnavigateToLogin()
				.BgbloginDetails(userProfile)
				.navigatetoContactUslink()
				.verifyBreakdownandServices()
				.logout();
			}				
			//Business - TC_CU_Bus_015 -- Verify the user can select the menu from the tab option " My account & billing " in "Query regarding" drop down field for logged in customer
			@SuppressWarnings("unchecked")
			@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsEmailUsMyAccountandBillingdropdown(){
				Report.createTestLogHeader("ContactUs - Business", "Verify the user can select the menu from the tab option My account & billing in Query regarding drop down field for logged in customer");
				UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
				new HomePageAction()
				.BgbnavigateToLogin()
				.BgbloginDetails(userProfile)
				.navigatetoContactUslink();
				for(int i=0;i<Tabs.length;i++){
					new ContactUsBusinessAction()
					.selectTab(Tabs[i])
					.navigatetoEmailContactUslink(Tabs[i])
					.verifyEmailUs(Tabs[i]);
				}
				new ContactUsBusinessAction()
				.logout();
			}
			//Business - TC_CU_Bus_016 -- Verify the user can select the menu from the tab option "Switching to British Gas" in "Query regarding" drop down field for logged in customer
			@SuppressWarnings("unchecked")
			//		@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsEmailUsSwitchingtoBritishGasdropdown(){
				Report.createTestLogHeader("ContactUs - Business", "Verify the user can select the menu from the tab option Switching to British Gas in Query regarding drop down field for logged in customer");
				UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
				new HomePageAction()
				.BgbnavigateToLogin()
				.BgbloginDetails(userProfile)
				.navigatetoContactUslink()
				.selectSwitchingtoBGtab()
				.navigatetoEmailContactUslink("SwitchingtoBG")
				.verifyEmailUs("SwitchingtoBG")
				.logout();
			}
			//Business - TC_CU_Bus_034 -- Verify the user can select the menu from the tab option "My meter readings & meter" in "Query regarding" drop down field for logged in customer
			@SuppressWarnings("unchecked")
			//		@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsEmailUsMyMeterReadingsandMeterdropdown(){
				Report.createTestLogHeader("ContactUs - Business", "Verify the user can select the menu from the tab option My meter readings & meter in Query regarding drop down field for logged in customer");
				UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
				new HomePageAction()
				.BgbnavigateToLogin()
				.BgbloginDetails(userProfile)
				.navigatetoContactUslink()
				.selectMyMeterReadingsandMetertab()
				.navigatetoEmailContactUslink("MyMeterReadingsandMeter")
				.verifyEmailUs("MyMeterReadingsandMeter")
				.logout();
			}
		
			//Business - TC_CU_Bus_035 -- Verify the user can select the menu from the tab option "Moving premises" in "Query regarding" drop down field for logged in customer
			@SuppressWarnings("unchecked")
			//		@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsEmailUsMovingPremisesdropdown(){
				Report.createTestLogHeader("ContactUs - Business", "Verify the user can select the menu from the tab option Moving premises in Query regarding drop down field for logged in customer");
				UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
				new HomePageAction()
				.BgbnavigateToLogin()
				.BgbloginDetails(userProfile)
				.navigatetoContactUslink()
				.selectMovingPremisestab()
				.navigatetoEmailContactUslink("MovingPremises")
				.verifyEmailUs("MovingPremises")
				.logout();
			}
		
			//Business - TC_CU_Bus_036 -- Verify the user can select the menu from the tab option " Breakdown & servicing" in "Query regarding" drop down field for logged in customer
			@SuppressWarnings("unchecked")
			//		@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsEmailUsBreakdownandServicesdropdown(){
				Report.createTestLogHeader("ContactUs - Business", "Verify the user can select the menu from the tab option Breakdown & servicing in Query regarding drop down field for logged in customer");
				UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
				new HomePageAction()
				.BgbnavigateToLogin()
				.BgbloginDetails(userProfile)
				.navigatetoContactUslink()
				.selectBreakdownandServicestab()
				.navigatetoEmailContactUslink("BreakdownandServices")
				.verifyEmailUs("BreakdownandServices")
				.logout();
			}
		
			//Business - TC_CU_Bus_004 -- Validate the "Search" button functionality of   "Help & advice"  panel of "My account and billing" radio button for logged in customer
			@SuppressWarnings("unchecked")
			@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsSearchMyAccountandBilling(){
				Report.createTestLogHeader("ContactUs - Business", "Validate the Search button functionality of Help & advice panel of My account and billing radio button for logged in customer");
				String[] search={"VAT", "transfer", "refund", "premises", "Breakdown"};
				String[] content={"How much VAT am I paying?", "Account transfer times", "Getting a refund on a credit balance", "How long will the moving premises process take?", "Breakdown callouts"};
				UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
				new HomePageAction()
				.BgbnavigateToLogin()
				.BgbloginDetails(userProfile)
				.navigatetoContactUslink();
				for(int i=0;i<Tabs.length;i++){
					new ContactUsBusinessAction()
					.selectTab(Tabs[i])
					.SearchFuctionality(search[i] , content[i], Tabs[i]);
				}
				new ContactUsBusinessAction()
				.logout();
			}
			//Business - TC_CU_Bus_006 -- Validate the "Search" button functionality of   "Help & advice"  panel of "Switching to British Gas" radio button for logged in customer
			@SuppressWarnings("unchecked")
			//		@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsSearchSwitchingtoBritishGas(){
				Report.createTestLogHeader("ContactUs - Business", "Validate the Search button functionality of Help & advice panel of Switching to British Gas radio button for logged in customer");
				UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
				new HomePageAction()
				.BgbnavigateToLogin()
				.BgbloginDetails(userProfile)
				.navigatetoContactUslink()
				.selectSwitchingtoBGtab()
				.SearchFuctionality("transfer" , "Account transfer times", "SwitchingtoBG")
				.logout();
			}
			//Business - TC_CU_Bus_009 -- Validate the "Search" button functionality of   "Help & advice"  panel of "My meter readings & meter" radio button for logged in customer
			@SuppressWarnings("unchecked")
			//		@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsSearchMyMeterReadingsandMeter(){
				Report.createTestLogHeader("ContactUs - Business", "Validate the Search button functionality of Help & advice panel of My meter readings & meter radio button for logged in customer");
				UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
				new HomePageAction()
				.BgbnavigateToLogin()
				.BgbloginDetails(userProfile)
				.navigatetoContactUslink()
				.selectMyMeterReadingsandMetertab()
				.SearchFuctionality("refund" , "Getting a refund on a credit balance", "MyMeterReadingsandMeter")
				.logout();
			}
			//Business - TC_CU_Bus_028 -- Validate the "Search" button functionality of   "Help & advice"  panel of "Moving premises" radio button for logged in customer
			@SuppressWarnings("unchecked")
			//		@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsSearchMovingPremises(){
				Report.createTestLogHeader("ContactUs - Business", "Validate the Search button functionality of Help & advice panel of 'Moving premises radio button for logged in customer");
				UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
				new HomePageAction()
				.BgbnavigateToLogin()
				.BgbloginDetails(userProfile)
				.navigatetoContactUslink()
				.selectMovingPremisestab()
				.SearchFuctionality("premises" , "Supplying energy to my new premises", "MovingPremises")
				.logout();
			}
			//Business - TC_CU_Bus_031 -- Validate the "Search" button functionality of   "Help & advice"  panel of "Breakdown & servicing" radio button for logged in customer
			@SuppressWarnings("unchecked")
			//		@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsSearchBreakdownandServices(){
				Report.createTestLogHeader("ContactUs - Business", "Validate the Search button functionality of Help & advice panel of Breakdown & servicing radio button for logged in customer");
				UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
				new HomePageAction()
				.BgbnavigateToLogin()
				.BgbloginDetails(userProfile)
				.navigatetoContactUslink()
				.selectBreakdownandServicestab()
				.SearchFuctionality("Breakdown" , "Breakdown callouts?", "BreakdownandServices")
				.logout();
			}	
		
			//Business - TC_CU_Bus_025	 -- Vaildate whether the user is able to proceed "Contact Us" journey by navigations in home page for Anonymous customers
			//Business - TC_CU_Bus_026  --	a)Validate whether the "Contact Us" landing page is displayed for Anonymous customers, b)Verify the look and feel of"Contact Us" landing page for Anonymous customers, 	c)Verify the link navigations in "Contact Us" landing page for Anonymous customers 1)LHN ,2)RHN	
			@SuppressWarnings("unchecked")
					@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsAnonymousCustomers(){
				Report.createTestLogHeader("ContactUs - Business", "Vaildate whether the user is able to proceed Contact Us journey by navigations in home page for Anonymous customers");
				new HomePageAction()
				.BgbnavigateToLogin()
				.navigatetoContactUslink()
				.verifyLHN();
			}
		
			//Business - TC_CU_Bus_032  --	To check whether the user can able to contact customer care team by clicking email us link for Anonymous customers and validate whether the "email us" landing page is getting displayed for Anonymous customers
			@SuppressWarnings("unchecked")
							@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsEmailUsAnonymousCustomers(){
				Report.createTestLogHeader("ContactUs - Business", "validate whether the email us landing page is getting displayed for Anonymous customers");
				new HomePageAction()
				.BgbnavigateToLogin()
				.navigatetoContactUslink()
				.navigatetoEmailContactUslink("MyAccountandBilling");
			}
		
			//Business - TC_CU_Bus_010  --	To check whether the user can able to contact customer care team by clicking email us link for logged in customers and validate whether the "email us" landing page is getting displayed for Logged in customers, Verify the link navigations in "Email us" landing page for logged in customers a)LHN  b)RHN c)"Where I can find this" link of account number field
			@SuppressWarnings("unchecked")
									@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsEmailUsLoggedInCustomers(){
				Report.createTestLogHeader("ContactUs - Business", "Validate whether the email us landing page is getting displayed for Logged in customers");
				UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
				new HomePageAction()
				.BgbnavigateToLogin()
				.BgbloginDetails(userProfile)
				.navigatetoContactUslink()
				.navigatetoEmailContactUslink("MyAccountandBilling")
				.verifyWhereCanIFindThisLink()
				.logout();
			}
			//Business - TC_CU_Bus_013  --	To Check whether the site address is getting displayed for normal account of logged in customers and to Check whether the Billing address is getting displayed for collective account  of logged in customers.
			@SuppressWarnings("unchecked")
					@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsSiteAddressLoggedInCustomers(){
				Report.createTestLogHeader("ContactUs - Business", "Validate whether the site address is getting displayed for Logged in customers");
				UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
				new HomePageAction()
				.BgbnavigateToLogin()
				.BgbloginDetails(userProfile)
				.AddressCapturing()
				.navigatetoContactUslink()
				.navigatetoEmailContactUslink("MyAccountandBilling")
				.verifyAddressinEmailUs(userProfile)
				.logout();
			}
			//Business - TC_CU_Bus_001	--	Vaildate whether the user is able to proceed "Contact Us" journey by navigations in home page for Logged in customers(end to end flow)		
			//Business - TC_CU_Bus_020  --	Verify the functionality of Submit button for logged in customer and check whether Confirmation page is getting displayed after submitting  the complaint for logged in customer
			@SuppressWarnings("unchecked")
					@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsConfirmationPageLoggedInCustomers(){
				Report.createTestLogHeader("ContactUs - Business", "Verify the functionality of Confirmation page for Logged in customers");
				UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
				new HomePageAction()
				.BgbnavigateToLogin()
				.BgbloginDetails(userProfile)
				.AddressCapturing()
				.navigatetoContactUslink()
				.navigatetoEmailContactUslink("MyAccountandBilling")
				.verifyConfirmationinEmailUsLoggedInCust(userProfile)
				.logout();
			}
		
			//Business - TC_CU_Bus_047  --	a)Check whether address results are displayed after clicking "Find address" button" for BGB Anonymous customer 	b)Check whether the user can select an address from the list of address displayed for BGB Anonymous customer
			//Business - TC_CU_Bus_038  --	Verify "First name" field validations and its error message for anonymous customer	a)field is empty	b)length is greater than 40	c)length is lesser than 40	d)Numeric
			@SuppressWarnings("unchecked")
							@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsFirstnameAndErrorMsg(){
				Report.createTestLogHeader("ContactUs - Business", "Verify First name field validations and its error message for BGB anonymous customer");
				UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
				new HomePageAction()
				.BgbnavigateToLogin()
				.navigatetoContactUslink()
				.navigatetoEmailContactUslink("MyAccountandBilling")
				.validateFirstName(userProfile, "BGCustomer", "BG Customer Radio Button");
			}
			//Business - TC_CU_Bus_054  --	a)Check whether address results are displayed after clicking "Find address" button" for NON BGB Anonymous customer 	b)Check whether the user can select an address from the list of address displayed for NON BGB Anonymous customer
			@SuppressWarnings("unchecked")
							@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsFinderAddressNONBGB(){
				Report.createTestLogHeader("ContactUs - Business", "Verify First name field validations and its error message for NON BGB anonymous customer");
				UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
				new HomePageAction()
				.BgbnavigateToLogin()
				.navigatetoContactUslink()
				.navigatetoEmailContactUslink("MyAccountandBilling")
				.validateFirstName(userProfile, "NonBGCustomer", "NON BG Customer Radio Button");
			}
		
			//Business - TC_CU_Bus_055  --	a)Check whether the email address overlay is getting displayed and the user can enter address manually by clicking "Enter your address manually" link for non BGB Anonymous customer b)Verify the look and feel of Email address overlay for non BGB Anonymous customer
			//Business - TC_CU_Bus_049  --  Validate the functionalities of buttons in Email address overlay for BGB Anonymous customer a)County (drop down)  b)Submit(button)
		
			@SuppressWarnings("unchecked")
							@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsEnterAddressManuallyNonBGB(){
				Report.createTestLogHeader("ContactUs - Business", "Verify enter address manually by clicking Enter your address manually link for Non BGB Customers");
				UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
				new HomePageAction()
				.BgbnavigateToLogin()
				.navigatetoContactUslink()
				.navigatetoEmailContactUslink("MyAccountandBilling")
				.validateEnterAddressManually(userProfile, "NonBGCustomer", "NON BG Customer Radio Button");
			}
			//Business - TC_CU_Bus_022  --  a)Check whether the email address overlay is getting displayed and the user can enter address manually by clicking "Enter your address manually" link for BGB Anonymous customer b)Verify the look and feel of Email address overlay for BGB Anonymous customer
			//Business - TC_CU_Bus_050  --  a)Check whether the email address overlay is getting displayed and the user can enter address manually by clicking "Enter your address manually" link for BGB Anonymous customer b)Verify the look and feel of Email address overlay for BGB Anonymous customer
			//Business - TC_CU_Bus_057  --  a)Check whether Confirmation page is getting displayed after submitting  the complaint for anonymous customer b)Verify the look and feel of Confirmation  page for anonymous customer c)Verify the link navigations of Confirmation  page for anonymous customer
			//Business - TC_CU_Bus_059  --  a)Check whether confirmation email is triggered to customer for anonymous customer with attachment and with same unique reference number
			@SuppressWarnings("unchecked")
							@Test(groups ={Slingshot,Smoke,BGBRegistration})	
			public void verifyContactUsEnterAddressManuallyBGB(){
				Report.createTestLogHeader("ContactUs - Business", "Verify enter address manually by clicking Enter your address manually link for BGB Customers");
				UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs");
				new HomePageAction()
				.BgbnavigateToLogin()
				.navigatetoContactUslink()
				.navigatetoEmailContactUslink("MyAccountandBilling")
				.validateEnterAddressManually(userProfile, "BGCustomer", "BG Customer Radio Button");
			}
		
		}
