package bg.framework.app.functional.test.sales;

import static bg.framework.app.functional.entities.FunctionalCategory.Acquisition;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class CrossSellTest extends TestBase  {
	
	// @Test(groups = {Acquisition})

	    public void verifyCrossSellgasAccount() {

		 Report.createTestLogHeader("Cross sell Test ", "GAS  Journey");
	        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	        
	       // getCustomerDetailsToUserProfileOAM(userProfile);
	        
	        new HomePageAction()
	                .navigateToLogin()
	                .login(userProfile)
	                .navigateTOAddElectrticityPage()
	                //.navigateToDualOrderPage()
	                .yourOrderGasBG(acquisition)
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
	                .yourOrderElecBG(acquisition)
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
	        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	        
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
					.yourOrderGasBG(acquisition)
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
					.yourOrderElecBG(acquisition)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile);
		}
	
}
