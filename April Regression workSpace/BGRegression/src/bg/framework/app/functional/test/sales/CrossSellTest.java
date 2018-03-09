package bg.framework.app.functional.test.sales;

import static bg.framework.app.functional.entities.FunctionalCategory.Acquisition;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.sales.CrossSellAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class CrossSellTest extends TestBase  {
	
	 @Test(groups = {Acquisition})
	 public void verifyCrossSellgasAccount() {

		 Report.createTestLogHeader("Cross sell Test ", "GAS  Journey");
	        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	        
	       // getCustomerDetailsToUserProfileOAM(userProfile);
	        
	        new HomePageAction()
	                .navigateToLogin()
	                .login(userProfile)
	                .navigateTOAddElectrticityPage()
	                .navigateToDualOrderPage()
	                .yourOrderGasBG(acquisition, userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyLeadData()
	                .domarssalesRunBatch(acquisition.getShopBatch()) 
	              
	              .backToHomePage();
	                
	 }

	 
	 
 @Test(groups = {Acquisition})

	    public void verifyCrossSellElecAccount() {

		 Report.createTestLogHeader("Cross sell Test ", "Electricity  Journey");
	        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	        
	        //getCustomerDetailsToUserProfileOAM(userProfile);
	        
	        new HomePageAction()
	                .navigateToLogin()
	                .login(userProfile)
	                .navigateTOAddGasPage()
	                //.navigateTariffsPage()
	                //.navigateToClearAndSimple()               
	               // .navigateToDualOrderPage()
	                .yourOrderElecBG(acquisition, userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyLeadData()
	               .domarssalesRunBatch(acquisition.getShopBatch()) 
	              .backToHomePage();
	 }
	 
	 
	 @Test(groups = {Acquisition})

	    public void verifyCrossSellHomeCareAccount() {

		 Report.createTestLogHeader("Cross sell Test ", "Home care   Journey");
	        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	        
	       // getCustomerDetailsToUserProfileOAM(userProfile);
	        
	        new HomePageAction()
	                .navigateToLogin()
	                .login(userProfile)
	                .navigateTOAddHomeCarePage()
	                .navigateTOOrderHomeCareHundred()
	                .enterHomecareDetails(acquisition)
	                .enterNectaroptionone()
	                .enterConfirmOrder()
	                .verifyHomecarehundred()
	                .navigateHomecaretwohundred()
	                .enterHomecareDetails(acquisition)
	                .enterNectaroptiontwo()
	                .enterConfirmOrder()
	                .verifyHomecaretwohundred()
	                .navigateHomecarethreehundred()
	                .enterHomecareDetails(acquisition)
	                .enterNectaroptionthree()
	                .enterConfirmOrder()
	                .verifyHomecarethreehundred()
	                .navigateHomecarefourhundred()
	                .enterHomecareDetails(acquisition)
	                .enterNectaroptionfour()
	                .enterConfirmOrder()
	                .verifyHomecarefourhundred();
	                
	 }
	 @Test(groups = {Acquisition})
	 public void verifyCrossSellHomeCareDualAccount() {

		 Report.createTestLogHeader("Cross sell Test ", "GAS  Journey");
	        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	        
	       // getCustomerDetailsToUserProfileOAM(userProfile);
	        
	        new HomePageAction()
	                .navigateToLogin()
	                .login(userProfile)
	                .navigateTOAddElectrticityPage()
	                .navigateToDualOrderPage()
	                .yourOrderGasBG(acquisition, userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyLeadData()
	                .domarssalesRunBatch(acquisition.getShopBatch()) 
	              
	              .backToHomePage();
	                
	 }
	//Data Required : Dual SSO 
		 @Test(groups = {Acquisition})

		    public void verifyCrossSellHomeCareDualSSOAccount() {

			 Report.createTestLogHeader("Cross sell Test ", "Home care Journey for Dual sso account");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("SSOAccount");
		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);
		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOAddHomeCarePage()
		                .navigateTOOrderHomeCareHundred()
		                .enterHomecareDetails(acquisition)
		                .enterNectaroptionone()
		                .enterConfirmOrder()
		                .verifyHomecarehundred()
		                .navigateHomecaretwohundred()
		                .enterHomecareDetails(acquisition)
		                .enterNectaroptiontwo()
		                .enterConfirmOrder()
		                .verifyHomecaretwohundred()
		                .navigateHomecarethreehundred()
		                .enterHomecareDetails(acquisition)
		                .enterNectaroptionthree()
		                .enterConfirmOrder()
		                .verifyHomecarethreehundred()
		                .navigateHomecarefourhundred()
		                .enterHomecareDetails(acquisition)
		                .enterNectaroptionfour()
		                .enterConfirmOrder()
		                .verifyHomecarefourhundred();
		                
		 }
	 
	 	/*Mandatory Fields: UCRN and Account number of Pure Gas Account
	 	 * (without any other fuel)
	 	 * */	
				
	 @Test(groups={Acquisition})
		
		public void verifyCrossSellAndAddElectricity()
		{
			Report.createTestLogHeader("Cross sell Test Add Electricity", "GasAccount");
			final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
			final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
					new HomePageAction()
					.navigateToLogin()
					.login(userProfile)
					.navigateTOAddElectrticityPage()
					.switchToElectricity()
					.yourOrderGasBG(acquisition, userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile);
	                
		 }
		 
	 /*Mandatory Fields: UCRN and Account number of Pure Electricity Account
	 	 * (without any other fuel)
	 	 * */
		@Test(groups={Acquisition})
		
		public void verifyCrossSellAndAddGas()
		{
			Report.createTestLogHeader("Cross sell Test Add GAS", "ElectricityAccount");
			final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
			final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
					new HomePageAction()
					.navigateToLogin()
					.login(userProfile)
					.navigateTOAddGasPage()
					.switchToGas()
					.yourOrderElecBG(acquisition, userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile);
		}
	
		 @Test(groups={Acquisition})
			
			public void verifyCrossSellForClosedAccount()
			{
				Report.createTestLogHeader("Cross sell verification for Closed Account", "GasAccount");
				//final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
				final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
				  new HomePageAction()
							.navigateToLogout();
						new HomePageAction()
							.navigateToLogin()
							.login(userProfile);
						new CrossSellAction()
							.loginErrorForClosedAccount();
		                
			 }
		 
		 @Test(groups={Acquisition})
			
			public void verifyCrossSellForSSOAccount()
			{
				Report.createTestLogHeader("Cross sell verification for SSO Account Add Electricity End to End", "GasAccount");
				//final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
				final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
				  new HomePageAction()
							.navigateToLogout();
						new HomePageAction()
							.navigateToLogin()
							.login(userProfile);
						new CrossSellAction()
							.CrossCellCheck1();

		                
			 }
		 @Test(groups={Acquisition})
			
			public void verifyCrossSellForSSOAccountHomeCare()
			{
				Report.createTestLogHeader("Cross sell verification for SSO Account Add HomeCare End to End", "GasAccount");
				//final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
				final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
				  new HomePageAction()
							.navigateToLogout();
						new HomePageAction()
							.navigateToLogin()
							.login(userProfile);
						new CrossSellAction()
							.CrossCellCheck2();
						
		                
			 }
		 @Test(groups={Acquisition})
			
			public void verifyCrossSellWTPAccount()
			{
				Report.createTestLogHeader("Cross sell verification for WTP Account ADD Eelectricity", "GasAccount");
				//final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
				final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
				  new HomePageAction()
							.navigateToLogout();
						new HomePageAction()
							.navigateToLogin()
							.login(userProfile);
						new CrossSellAction()
							.CrossCellCheck1();

		                
			 }
		 @Test(groups={Acquisition})
			
			public void verifyCrossSellWTPAccountHomeCare()
			{
				Report.createTestLogHeader("Cross sell verification for WTP Account ADD HomeCare", "GasAccount");
				//final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
				final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
				  new HomePageAction()
							.navigateToLogout();
						new HomePageAction()
							.navigateToLogin()
							.login(userProfile);
						new CrossSellAction()
							.CrossCellCheck2();
						
		                
			 }
		 
		 //Sprint 06
		 
		 @Test(groups = {Acquisition})
		    public void verifyElecCrossSellHomeCare100with0excess() {
			 Report.createTestLogHeader("Cross sell Test ", "Home care 100 - 0 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);	        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess0()
		                .orderHomecare100()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
      }
		 @Test(groups = {Acquisition})
		    public void verifyElecCrossSellHomeCare200with0excess() {
			 Report.createTestLogHeader("Cross sell Test ", "Home care 200 - 0 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);	        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess0()
		                .orderHomecare200()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
   }
		 @Test(groups = {Acquisition})
		    public void verifyElecCrossSellHomeCare300with0excess() {
			 Report.createTestLogHeader("Cross sell Test ", "Home care 300 - 0 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);	        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess0()
		                .orderHomecare300()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
   }
		 @Test(groups = {Acquisition})
		    public void verifyElecCrossSellHomeCare300with0excessDualaccount() {
			 Report.createTestLogHeader("Cross sell Test ", "Home care 300 - 0 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);	        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess0()
		                .orderHomecare300()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}
		 @Test(groups = {Acquisition})
		    public void verifyElecCrossSellHomeCare400with0excess() {
			 Report.createTestLogHeader("Cross sell Test ", "Home care 400 - 0 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);	        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess0()
		                .orderHomecare400()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
   }
		 @Test(groups = {Acquisition})
		    public void verifyElecCrossSellHomeCare400with0excessJIAccount() {
			 Report.createTestLogHeader("Cross sell Test ", "Home care 400 - 0 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);	        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess0()
		                .orderHomecare400()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}
		 
		 @Test(groups = {Acquisition})
		 public void verifyElecCrossSellHomeCare100with50excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 100 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare100()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
   }
		 @Test(groups = {Acquisition})
		 public void verifyElecCrossSellHomeCare200with50excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 200 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare200()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
   }
		 @Test(groups = {Acquisition})
		 public void verifyElecCrossSellHomeCare300with50excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 300 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare300()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
   }
		 @Test(groups = {Acquisition})
		 public void verifyElecCrossSellHomeCare400with50excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 400 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare400()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
   }
		 @Test(groups = {Acquisition})
		 public void verifyElecCrossSellHomeCare100with99excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 100 - 99 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess99()
		                .orderHomecare100()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
   }
		 @Test(groups = {Acquisition})
		 public void verifyElecCrossSellHomeCare200with99excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 200 - 99 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess99()
		                .orderHomecare200()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
   }
		 @Test(groups = {Acquisition})
		 public void verifyElecCrossSellHomeCare300with99excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 300 - 99 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess99()
		                .orderHomecare300()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
   }
		 @Test(groups = {Acquisition})
		 public void verifyElecCrossSellHomeCare400with99excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 400 - 99 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess99()
		                .orderHomecare400()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
   }
		 @Test(groups = {Acquisition})
		    public void verifyDualCrossSellHomeCare100with0excess() {
			 Report.createTestLogHeader("Cross sell Test ", "Home care 100 - 0 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);	        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess0()
		                .orderHomecare100()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
         }
		 
		 @Test(groups = {Acquisition})
		 public void verifyDualCrossSellHomeCare100with50excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 100 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare100()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
         }
		 @Test(groups = {Acquisition})
		 public void verifyDualCrossSellHomeCare100with50excessClosedAccount() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 100 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("ClosedAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare100()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
         }
		 @Test(groups = {Acquisition})
		 public void verifyDualCrossSellHomeCare100with99excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 100 - 99 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess99()
		                .orderHomecare100()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
        }
		 @Test(groups = {Acquisition})
		    public void verifyDualCrossSellHomeCare200with0excess() {
			 Report.createTestLogHeader("Cross sell Test ", "Home care 200 - 0 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);	        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess0()
		                .orderHomecare200()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
      }
		 
		 @Test(groups = {Acquisition})
		 public void verifyDualCrossSellHomeCare200with50excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 200 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare200()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
      }
		 @Test(groups = {Acquisition})
		 public void verifyDualCrossSellHomeCare200with50excessSSOAccount() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 200 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("SSOAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare200()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
      }
		 @Test(groups = {Acquisition})
		 public void verifyDualCrossSellHomeCare200with99excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 200 - 99 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess99()
		                .orderHomecare200()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
     }
		 @Test(groups = {Acquisition})
		    public void verifyDualCrossSellHomeCare300with0excess() {
			 Report.createTestLogHeader("Cross sell Test ", "Home care 300 - 0 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);	        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess0()
		                .orderHomecare300()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
   }
		 
		 @Test(groups = {Acquisition})
		 public void verifyDualCrossSellHomeCare300with50excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 300 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare200()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
   }
		 @Test(groups = {Acquisition})
		 public void verifyDualCrossSellHomeCare300with99excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 300 - 99 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess99()
		                .orderHomecare300()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
  }
		 @Test(groups = {Acquisition})
		    public void verifyDualCrossSellHomeCare400with0excess() {
			 Report.createTestLogHeader("Cross sell Test ", "Home care 400 - 0 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);	        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess0()
		                .orderHomecare400()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}
		 
		 @Test(groups = {Acquisition})
		 public void verifyDualCrossSellHomeCare400with50excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 400 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare400()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}
		 @Test(groups = {Acquisition})
		 public void verifyDualCrossSellHomeCare400with99excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 400 - 99 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess99()
		                .orderHomecare400()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}
		 
		 
		 
		 @Test(groups = {Acquisition})
		    public void verifyGasCrossSellHomeCare100with0excess() {
			 Report.createTestLogHeader("Cross sell Test ", "Home care 100 - 0 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);	        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess0()
		                .orderHomecare100()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
      }
		 
		 @Test(groups = {Acquisition})
		 public void verifyGasCrossSellHomeCare100with50excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 100 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare100()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
      }
		 @Test(groups = {Acquisition})
		 public void verifyGasCrossSellHomeCare100with99excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 100 - 99 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess99()
		                .orderHomecare100()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
     }
		 @Test(groups = {Acquisition})
		    public void verifyGasCrossSellHomeCare200with0excess() {
			 Report.createTestLogHeader("Cross sell Test ", "Home care 200 - 0 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);	        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess0()
		                .orderHomecare200()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
   }
		 
		 @Test(groups = {Acquisition})
		 public void verifyGasCrossSellHomeCare200with50excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 200 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare200()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
   }
		 
		 @Test(groups = {Acquisition})
		 public void verifyGasCrossSellHomeCare200with50excessSSOAccount() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 200 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("SSOAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare200()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
   }
		 @Test(groups = {Acquisition})
		 public void verifyGasCrossSellHomeCare200with99excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 200 - 99 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess99()
		                .orderHomecare200()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
  }
		 @Test(groups = {Acquisition})
		    public void verifyGasCrossSellHomeCare300with0excess() {
			 Report.createTestLogHeader("Cross sell Test ", "Home care 300 - 0 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);	        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess0()
		                .orderHomecare300()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}
		 
		 @Test(groups = {Acquisition})
		 public void verifyGasCrossSellHomeCare300with50excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 300 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare200()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}
		 @Test(groups = {Acquisition})
		 public void verifyGasCrossSellHomeCare300with50excessMultiplesupplyaddress() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 300 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("MultiplesupplyaddressAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare200()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}
		 @Test(groups = {Acquisition})
		 public void verifyGasCrossSellHomeCare300with99excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 300 - 99 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess99()
		                .orderHomecare300()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}
		 @Test(groups = {Acquisition})
		 public void verifyGasCrossSellHomeCare300with99excessDualAccount() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 300 - 99 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess99()
		                .orderHomecare300()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}
		 @Test(groups = {Acquisition})
		    public void verifyGasCrossSellHomeCare400with0excess() {
			 Report.createTestLogHeader("Cross sell Test ", "Home care 400 - 0 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);	        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess0()
		                .orderHomecare400()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}
		 
		 @Test(groups = {Acquisition})
		 public void verifyGasCrossSellHomeCare400with50excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 400 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare400()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}
		 @Test(groups = {Acquisition})
		 public void verifyGasCrossSellHomeCare400with99excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 400 - 99 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess99()
		                .orderHomecare400()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}	 
		 
		 
		 
		 
		 

		 @Test(groups = {Acquisition})
		    public void verifyJICrossSellHomeCare100with0excess() {
			 Report.createTestLogHeader("Cross sell Test ", "Home care 100 - 0 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);	        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess0()
		                .orderHomecare100()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
      }
		 
		 @Test(groups = {Acquisition})
		 public void verifyJICrossSellHomeCare100with50excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 100 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare100()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
      }
		 @Test(groups = {Acquisition})
		 public void verifyJICrossSellHomeCare100with99excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 100 - 99 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess99()
		                .orderHomecare100()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
     }
		 @Test(groups = {Acquisition})
		    public void verifyJICrossSellHomeCare200with0excess() {
			 Report.createTestLogHeader("Cross sell Test ", "Home care 200 - 0 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);	        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess0()
		                .orderHomecare200()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
   }
		 
		 @Test(groups = {Acquisition})
		 public void verifyJICrossSellHomeCare200with50excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 200 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare200()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
   }
		 @Test(groups = {Acquisition})
		 public void verifyJICrossSellHomeCare200with99excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 200 - 99 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess99()
		                .orderHomecare200()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
  }
		 @Test(groups = {Acquisition})
		    public void verifyJICrossSellHomeCare300with0excess() {
			 Report.createTestLogHeader("Cross sell Test ", "Home care 300 - 0 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);	        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess0()
		                .orderHomecare300()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}
		 
		 @Test(groups = {Acquisition})
		 public void verifyJICrossSellHomeCare300with50excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 300 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare200()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}
		 @Test(groups = {Acquisition})
		 public void verifyJICrossSellHomeCare300with99excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 300 - 99 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess99()
		                .orderHomecare300()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}
		 @Test(groups = {Acquisition})
		    public void verifyJICrossSellHomeCare400with0excess() {
			 Report.createTestLogHeader("Cross sell Test ", "Home care 400 - 0 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);	        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess0()
		                .orderHomecare400()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}
		 
		 @Test(groups = {Acquisition})
		 public void verifyJICrossSellHomeCare400with50excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 400 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare400()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}
		 @Test(groups = {Acquisition})
		 public void verifyJICrossSellHomeCare400with99excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 400 - 99 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess99()
		                .orderHomecare400()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}	 
		
		 
		 

		 @Test(groups = {Acquisition})
		    public void verifyHomeServicesCrossSellHomeCare100with0excess() {
			 Report.createTestLogHeader("Cross sell Test ", "Home care 100 - 0 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);	        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess0()
		                .orderHomecare100()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
      }
		 
		 @Test(groups = {Acquisition})
		 public void verifyHomeServicesCrossSellHomeCare100with50excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 100 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare100()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
      }
		 @Test(groups = {Acquisition})
		 public void verifyHomeServicesCrossSellHomeCare100with99excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 100 - 99 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess99()
		                .orderHomecare100()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
     }
		 @Test(groups = {Acquisition})
		    public void verifyHomeServicesCrossSellHomeCare200with0excess() {
			 Report.createTestLogHeader("Cross sell Test ", "Home care 200 - 0 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);	        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess0()
		                .orderHomecare200()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
   }
		 
		 @Test(groups = {Acquisition})
		 public void verifyHomeServicesCrossSellHomeCare200with50excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 200 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare200()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
   }
		 @Test(groups = {Acquisition})
		 public void verifyHomeServicesCrossSellHomeCare200with99excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 200 - 99 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess99()
		                .orderHomecare200()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
  }
		 @Test(groups = {Acquisition})
		    public void verifyHomeServicesCrossSellHomeCare300with0excess() {
			 Report.createTestLogHeader("Cross sell Test ", "Home care 300 - 0 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);	        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess0()
		                .orderHomecare300()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}
		 
		 @Test(groups = {Acquisition})
		 public void verifyHomeServicesCrossSellHomeCare300with50excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 300 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare300()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}
		 @Test(groups = {Acquisition})
		 public void verifyHomeServicesCrossSellHomeCare300with50excessMultiplesupplyaddress() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 300 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("MultiplysupplyaddressAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare300()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}
		 @Test(groups = {Acquisition})
		 public void verifyHomeServicesCrossSellHomeCare300with99excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 300 - 99 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess99()
		                .orderHomecare300()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}
		 @Test(groups = {Acquisition})
		    public void verifyHomeServicesCrossSellHomeCare400with0excess() {
			 Report.createTestLogHeader("Cross sell Test ", "Home care 400 - 0 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);	        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess0()
		                .orderHomecare400()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}
		 
		 @Test(groups = {Acquisition})
		 public void verifyHomeServicesCrossSellHomeCare400with50excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 400 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare400()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}
		 @Test(groups = {Acquisition})
		 public void verifyHomeServicesCrossSellHomeCare400with99excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 400 - 99 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess99()
		                .orderHomecare400()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}	
		 //sheryn@capgemini.com
		 @Test(groups = {Acquisition})
		 public void verifyClosedAccntCrossSellHomeCare100with50excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 100 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("ClosedAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare100()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}
		 
		 
		 @Test(groups = {Acquisition})
		 public void verifyClosedAccntCrossSellHomeCare200with50excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 200 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("ClosedAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare200()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
   }
		 
		 
		 @Test(groups = {Acquisition})
		 public void verifyClosedAccountCrossSellHomeCare300with50excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 300 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("ClosedAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare300()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
		 	}
		 
		 
		 @Test(groups = {Acquisition})
		 public void verifyClosedAccountCrossSellHomeCare400with50excess() {
		 Report.createTestLogHeader("Cross sell Test ", "Home care 400 - 50 Excess Journey");
		        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("ClosedAccount");		        
		       // getCustomerDetailsToUserProfileOAM(userProfile);		        
		        new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile)
		                .navigateTOHomeCarePage()
		                .verifyandclickExcess50()
		                .orderHomecare400()
		                .verifyCrossSellEndToEnd(userProfile, acquisition)
		                .logout();                
}
		
}
