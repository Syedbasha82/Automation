package bg.framework.app.functional.test.reFactoring;

import static bg.framework.app.functional.entities.FunctionalCategory.Regression;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.selfServe.AccountSummaryAction;
import bg.framework.app.functional.action.reFactoring.ConsumptionHubRewriteAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class ConsumptionHubRewriteTest extends TestBase{
	
	
	
	/*--------------------------------UK Usage-------------------*/
	//TC_014,TC_02,TC_03
	@Test(groups={Regression})
	public void UKUsageByPostCode()
	{
		Report.createTestLogHeader("DDCPS Bank details journey For Gas Customer", "TC_014,TC_02,TC_03 GasAccount");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToUKEnergyUsage()
		.updateLocationBy("PostCode","Gas");
	}
	
	
	
	//TC_018,TC_19,TC_04,TC_05
	@Test(groups={Regression})
	public void UKUsageByLocation()
	{
		Report.createTestLogHeader("DDCPS Bank details journey For Gas Customer", "TC_018,TC_19,TC_04,TC_05 GasAccount");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		
		new AccountSummaryAction()
		/*.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)*/
		.navigateToUKEnergyUsage()
		.updateLocationBy("Location","Gas");
	}
	
	//TC_001,TC_008
	@Test(groups={Regression})
	public void UKUsageAnonymous()
	{
		Report.createTestLogHeader("DDCPS Bank details journey For Anonymous Customer", "TC_001,TC_008 GasAccount");
		new AccountSummaryAction()
		.navigateToUKEnergyUsage()
		.updateLocationBy("PostCode","Gas");
	}
	
	
	//TC_021,TC_024,TC_025
	@Test(groups={Regression})
	public void UKUsageErrorMessage()
	{
		Report.createTestLogHeader("DDCPS Bank details journey For ErrorMessage", "TC_021,TC_024,TC_025 GasAccount");
		
		new AccountSummaryAction()
		.navigateToUKEnergyUsage()
		.updateLocationErrorMessage("PostCode", "Gas");
	}
	

	
	
	
			/*--------------------------------City Usage-------------------*/	
	
	//TC_003,TC_005,TC_006
	@Test(groups={Regression})
	public void cityUsageGas()
	{
		Report.createTestLogHeader("City usage for Gas customer", "TC_003,TC_005,TC_006 GasAccount");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToCityComparison()
		.changeCities("Gas")
		.logout();
	}
	
	
	
	//TC_004,TC_016,TC_26,TC_27,TC_28
	@Test(groups={Regression})
	public void cityUsageElectricity()
	{
		Report.createTestLogHeader("City usage for Electricity customer", "TC_004,TC_016,TC_26,TC_27,TC_28 ElectricityAccount");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToCityComparison()
		.changeCities("Electricity")
		.logout();
		
		
	}
	
	//TC_024,TC_025
	@Test(groups={Regression})
	public void cityUsageBGS()
	{
		Report.createTestLogHeader("City usage for BGS customer", "TC_024,TC_025 Home services Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HomeservicesAccount");
		
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToCityComparison()
		.changeCities("Gas")
		.logout();
		
		
	}
	
	//TC_007,TC_012
	@Test(groups={Regression})
	public void cityUsageAnonymous()
	{
		Report.createTestLogHeader("City usage Anonymous", "TC_007,TC_012 GasAccount");
		new AccountSummaryAction()
		.navigateToCityComparison()
		.changeCities("Gas");
	}
	
	
	//TC_008,TC_029,TC_030
	@Test(groups={Regression})
	public void cityUsageUsingPageNavigation()
	{
		Report.createTestLogHeader("City usage Page Navigation", "TC_008,TC_029,TC_030 GasAccount");
		new AccountSummaryAction()
		.navigateToCityComparison()
		.cityResultsPageNavigation();
	}
	
	
	//TC_014
	@Test(groups={Regression})
	public void cityUsageMultiCityVerification()
	{
		Report.createTestLogHeader("City usage for Electricity customer", "TC_014 ElectricityAccount");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToCityComparison()
		.multiCityOverlay();
	}
	
	//TC_010, TC_021
	@Test(groups={Regression})
	public void verifyClearenceFuelToggle()
	{
		Report.createTestLogHeader("TC_010, TC_021 City usage for Electricity Customer", "TC_010, TC_021 GasAccount");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		
		new AccountSummaryAction()
		.navigateToCityComparison()
		.enterCityDetails()
		.verifyFuelToggle()
		.verifyCitySelection();
	}
	
	//TC_011
	@Test(groups={Regression})
	public void verifySortingOrder()
	{
		Report.createTestLogHeader("TC_011 City usage", "TC_011 GasAccount");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		
		new AccountSummaryAction()
		.navigateToCityComparison()
		.verifySortOrderCity("Descending")
		.verifySortOrderCity("Ascending");
	}
	
	/*********************************************CONSUMPTION COMPARISON************************************/
	
	//TC_001, TC_005 
	@Test(groups={Regression})
	public void verifyRefineYourComparisonforHouseTerraced()
	{
		Report.createTestLogHeader("Consumption Comparison For OAM Customer", "TC_001,TC_005");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToCompareEnergyUsage()
			.selectAccount(userProfile.getAccNumber())
			.enterRefineComparisonDetails("Terraced","","","")
			.logout();
			
	}
	
	//TC_002,TC_006 
	@Test(groups={Regression})
	public void verifyRefineYourComparisonforHouseSemiDetached()
	{
		Report.createTestLogHeader("Consumption Comparison For OAM Customer House type Semidetached", "TC_002");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToCompareEnergyUsage()
			.selectAccount(userProfile.getAccNumber())
			.enterRefineComparisonDetails("Semi-detached","","","")
			.logout();
			
	}
	
	//TC_003 
	@Test(groups={Regression})
	public void verifyRefineYourComparisonforHouseDetached()
	{
		Report.createTestLogHeader("Consumption Comparison For OAM Customer House type detached", "TC_003");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToCompareEnergyUsage()
			.selectAccount(userProfile.getAccNumber())
			.enterRefineComparisonDetails("Detached","","","")
			.logout();
			
	}
	
	
	//TC_004
	@Test(groups={Regression})
	public void verifyRefineYourComparisonforHouseFlat()
	{
		Report.createTestLogHeader("Consumption Comparison For OAM Customer House type Flat", "TC_004");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToCompareEnergyUsage()
			.selectAccount(userProfile.getAccNumber())
			.enterRefineComparisonDetails("Flat / Maisonette","","","")
			.logout();
			
	}
	
	//TC_007
	@Test(groups={Regression})
	public void verifyRefineYourComparisonforOccupants1()
	{
		Report.createTestLogHeader("Consumption Comparison For OAM Customer occupant 1", "TC_007");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToCompareEnergyUsage()
			.selectAccount(userProfile.getAccNumber())
			.enterRefineComparisonDetails("","","Occupants1","")
			.logout();
			
	}
	
	//TC_008
	@Test(groups={Regression})
	public void verifyRefineYourComparisonforOccupants2()
	{
		Report.createTestLogHeader("Consumption Comparison For OAM Customer occupant 2", "TC_008");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToCompareEnergyUsage()
			.selectAccount(userProfile.getAccNumber())
			.enterRefineComparisonDetails("","","Occupants2","")
			.logout();
	}
	
	//TC_009
	@Test(groups={Regression})
	public void verifyRefineYourComparisonforOccupants3()
	{
		Report.createTestLogHeader("Consumption Comparison For OAM Customer occupant 3", "TC_009");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToCompareEnergyUsage()
			.selectAccount(userProfile.getAccNumber())
			.enterRefineComparisonDetails("","","Occupants3","")
			.logout();
	}
	
	//TC_010
	@Test(groups={Regression})
	public void verifyRefineYourComparisonforBedroom1()
	{
		Report.createTestLogHeader("Consumption Comparison For OAM Customer Bedroom 1", "TC_010");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToCompareEnergyUsage()
			.selectAccount(userProfile.getAccNumber())
			.enterRefineComparisonDetails("","BedroomSelect1","","")
			.logout();
	}
	
	//TC_011
	@Test(groups={Regression})
	public void verifyRefineYourComparisonforBedroom2()
	{
		Report.createTestLogHeader("Consumption Comparison For OAM Customer Bedroom 2", "TC_011");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToCompareEnergyUsage()
			.selectAccount(userProfile.getAccNumber())
			.enterRefineComparisonDetails("","BedroomSelect2","","")
			.logout();
	}
	
	//TC_012
	@Test(groups={Regression})
	public void verifyRefineYourComparisonforBedroom3()
	{
		Report.createTestLogHeader("Consumption Comparison For OAM Customer Bedroom 3", "TC_012");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToCompareEnergyUsage()
			.selectAccount(userProfile.getAccNumber())
			.enterRefineComparisonDetails("","BedroomSelect3","","")
			.logout();
	}
	
	//TC_013, TC_014
	//Test Data Required -Single BGS
	@Test(groups={Regression})
	public void verifyConsumptionComparisonBGS(){
		Report.createTestLogHeader("Consumption Comparison For OAM BGS Customer", "TC_013, TC_014");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");
		
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.verifyConsumptionComparisonBGSAccount()
			.logout();
	}
	
	//TC_015
	//Test Data Required -Dual Account
	@Test(groups={Regression})
	public void verifyConsumptionComparisonGasandElec(){
		Report.createTestLogHeader("Consumption Comparison For OAM Dual Customer", "TC_015");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)	
			.navigateToAccountSummaryPage(userProfile)
			.navigateToCompareEnergyUsage()
			.selectAccount(userProfile.getGasAccount())
			.verifyComparisonDetails()
			.selectAccount(userProfile.getElecAccount())
			//.verifyComparisonDetails()
			.logout();
	}

		//TC_018 complete
		//Test Data Required - New customer with less than 3 months billing
		@Test(groups={Regression})
		public void verifyConsumptionComparisonNewCustomer(){
			Report.createTestLogHeader("Consumption Comparison For New Customer", "TC_018");
			UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
			
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)	
				.navigateToAccountSummaryPage(userProfile)
				.navigateToCompareEnergyUsage()
				.verifyErrorMessageNewCustomer()
				.logout();
		}
		
		//TC_019 Complete
		//Test Data Required - customer with 3 months after move out
		@Test(groups={Regression})
		public void verifyConsumptionComparison3MonthsAfterMoveOut(){
			Report.createTestLogHeader("Consumption Comparison For Move out Customer", "TC_019");
			UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
			
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)	
				.navigateToAccountSummaryPage(userProfile)
				.navigateToCompareEnergyUsage()
				.logout();
		}
		
		//TC_020 Complete
		//Test Data Required - customer within 3 months of move out
		@Test(groups={Regression})
		public void verifyConsumptionComparison3MonthsWithinMoveOut(){
			Report.createTestLogHeader("Consumption Comparison For 3 months within Move out Customer", "TC_020");
			UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
			
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)	
				.navigateToAccountSummaryPage(userProfile)
				.navigateToCompareEnergyUsage()
				.enterRefineDetails()
				.verifyUpdatePremiseData()
				.logout();
		}
				
		
		//TC_022, TC_023, TC_024, TC_025, TC_026
		//Test Data Required - OAM customer
		@Test(groups={Regression})
		public void verifyConsumptionCityComparison(){
			Report.createTestLogHeader("Consumption City Comparison", "TC_022, TC_023, TC_024, TC_025, TC_026");
			UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
			
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)	
				.navigateToAccountSummaryPage(userProfile)
				.navigateToCompareEnergyUsage()
				.EnterCityDetails()
				.logout();
		}
		
		//TC_027, TC_028, TC_029, TC_030, TC_031
		//Test Data Required - OAM customer
		@Test(groups={Regression})
		public void verifyConsumptionPostCodeComparison(){
			Report.createTestLogHeader("Consumption PostCode Comparison", "TC_027,TC_028,TC_029,TC_030,TC_031");
			UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
			
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)	
				.navigateToAccountSummaryPage(userProfile)
				.navigateToCompareEnergyUsage()
				.EnterPostCodeDetails()
				.logout();
		}
		
		//TC_036
		//Test Data Required - OAM customer
		@Test(groups={Regression})
		public void verifyConsumptionIncorrectPostcode(){
			Report.createTestLogHeader("Consumption Incorrect PostCode verify", "TC_036");
			UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
			
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)	
				.navigateToAccountSummaryPage(userProfile)
				.navigateToCompareEnergyUsage()
				.verifyIncorrectPostcode()
				.logout();
		}
		
		//TC_037
		//Test Data Required - OAM customer
		@Test(groups={Regression})
		public void verifyConsumptionPostcodeLogic(){
			Report.createTestLogHeader("Consumption Incorrect PostCode verify", "TC_037");
			UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
			
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)	
				.navigateToAccountSummaryPage(userProfile)
				.navigateToCompareEnergyUsage()
				.verifyPostCodeLogic()
				.logout();
		}
		
		
		//TC_044,TC_045, TC_021
		//Test Data Required - OAM customer
		@Test(groups={Regression})
		public void verifyOverwriteExistingDetails(){
			Report.createTestLogHeader("Consumption Comparison overwriting existing details", "TC_044,TC_021");
			UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
			
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)	
				.navigateToAccountSummaryPage(userProfile)
				.navigateToCompareEnergyUsage()
				.enterRefineDetails()
				.verifyUpdatePremiseData()
				.logout();
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)	
				.navigateToAccountSummaryPage(userProfile)
				.navigateToCompareEnergyUsage()
				.verifySavedData()
				.enterNewRefineDetails()
				.logout();
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)	
				.navigateToAccountSummaryPage(userProfile)
				.navigateToCompareEnergyUsage()
				.verifyNewSavedData()
				.logout();
				
		}
		
			
		//TC_046
		//Test Data Required - OAM Dual customer
		@Test(groups={Regression})
		public void verifyConsumptionComparisonToggleBetweenAccounts(){
			Report.createTestLogHeader("Consumption Comparison toggle between accounts", "TC_046");
			UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)	
				.navigateToAccountSummaryPage(userProfile)
				.navigateToCompareEnergyUsage()
				.selectAccount(userProfile.getGasAccount())
				.enterRefineComparisonDetails("","BedroomSelect1","","")
				.selectAccount(userProfile.getElecAccount())
				//.enterRefineComparisonDetails("Detached","","","")
				.logout();
		}
		
		//TC_047
		//Test Data Required - OAM Dual customer
		@Test(groups={Regression})
		public void verifyConsumptionComparisonValuesSameSession(){
			Report.createTestLogHeader("Consumption Comparison of Values in the same session", "TC_047");
			UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)	
				.navigateToAccountSummaryPage(userProfile)
				.navigateToCompareEnergyUsage()
				.selectAccount(userProfile.getGasAccount())
				.enterRefineComparisonDetails("Detached","","","")
				.verifySessionData()
				.logout();
		}
		
		//TC_048
		//Test Data Required - OAM Gas customer
		@Test(groups={Regression})
		public void verifyConsumptionComparisonErrorMessage(){
			Report.createTestLogHeader("Consumption Comparison error Message Verification", "TC_048");
			UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)	
				.navigateToAccountSummaryPage(userProfile)
				.navigateToCompareEnergyUsage()
				.verifyErrorMessage()
				.logout();
		}
		
		//TC_052
		//Test Data Required - OAM Gas customer with low end consumption
		@Test(groups={Regression})
		public void verifyUnderstandYourUsageLinkLowEndUser(){
			Report.createTestLogHeader("Understand your usage link", "TC_052");
			UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)	
				.navigateToAccountSummaryPage(userProfile)
				.navigateToCompareEnergyUsage()
				.verifyUnderstandYourUsageData("LowEnd")
				.logout();
		}
		
		//TC_054
		//Test Data Required - OAM Gas customer with High end consumption
		@Test(groups={Regression})
		public void verifyUnderstandYourUsageLinkHighEndUser(){
			Report.createTestLogHeader("Understand your usage link", "TC_054");
			UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)	
				.navigateToAccountSummaryPage(userProfile)
				.navigateToCompareEnergyUsage()
				.verifyUnderstandYourUsageData("HighEnd")
				.logout();
		}
		
		//TC_058
		//Test Data Required - OAM Gas Customer
		@Test(groups={Regression})
		public void verifyErrorTextPostcodeAndCity(){
			Report.createTestLogHeader("Verify Error text for postcode and city", "TC_058");
			UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)	
				.navigateToAccountSummaryPage(userProfile)
				.navigateToCompareEnergyUsage()
				.verifyPostcodeandCity()
				.logout();		
		}
		
		//TC_059
		//Test Data Required - OAM Gas Customer
		@Test(groups={Regression})
		public void verifyConsumptionCompaisonExtremeValues(){
			Report.createTestLogHeader("Verify Error text when", "TC_059");
			UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)	
				.navigateToAccountSummaryPage(userProfile)
				.navigateToCompareEnergyUsage()
				.verifyErrorTextExtremeValues()
				.logout();
		}
		
}
