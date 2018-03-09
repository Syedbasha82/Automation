package bg.framework.app.functional.test.sales;


import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.sales.GasAndElectricityAction;
import bg.framework.app.functional.entities.FunctionalCategory;
import bg.framework.app.functional.entities.PriceDetails;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import bg.framework.app.functional.action.sales.GetAQuoteActionNew;
import org.testng.annotations.Test;

public class GetAQuoteNewTest extends TestBase {
	private String[] postCodes = {"AL10 8UW" , "LE12 9LX", "BR1 7YJ", "L22 5QH", "B10 9JU" , "DH2 7GH", "BB2 7DF" , "AB14 7GH",
			"DG10 7FG","KT17 3BH","BH7 6WD","CF10 6FG" , "BA3 7GH" ,"WF10 3NA"};
	private String[] paymentoptions = {"MDD","QCC","PPM"};

	@Test(groups = {FunctionalCategory.Eshop})
	public void verifyAnonymousJourney(){
		Report.createTestLogHeader("Get A Quote", "Anonymous journey for QCC payment");
		final PriceDetails getAPrice = new TestDataHelper().getPriceDetails("Anonymous");
		for(String postCode : postCodes){
			Report.updateTestLog("*******************" + postCode  + "**********************", "Pass");
			for(String payment : paymentoptions){
				Report.updateTestLog("*******************" + payment  + "**********************", "Pass");
				String[] fuelTypes = {"Gas","Elec","Dual"};
				for (String Fuel : fuelTypes){
					Report.updateTestLog("*******************" + Fuel  + "**********************", "Pass");
					new GetAQuoteActionNew("New",Fuel,"Anonymous")
					.navigateToGetAQuotePage()
					.enteringPostCode(postCode)
					.selectFuelType()
					.selectPaymentType(payment)
					.EnterDetails(getAPrice,"yes","AnoyCust")
					.verifyQuoteResultPage()
					.verifyTCRValue(Fuel, payment,postCode);
				}
			}
		}
	}

	@Test(groups = {FunctionalCategory.Eshop})
	public void verifyOAMGasJourneyNewAddr(){
		Report.createTestLogHeader("Get A Quote", "OAM Gas Journey for new Address");
		final PriceDetails getAPrice = new TestDataHelper().getPriceDetails("Anonymous");
		final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
			for(String payment : paymentoptions){
				Report.updateTestLog("*******************" + payment  + "**********************", "Pass");
				String[] fuelTypes = {"Gas","Elec","Dual"};
				for (String Fuel : fuelTypes){
					new HomePageAction()
					.navigateToLogin()
					.loginDetails(userProfile)
					.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount());
					new GetAQuoteActionNew("New",Fuel,"Gas")
					.navigateToGetAQuotePage()
					.selectAddress()
					.enterPostCode(getAPrice)
					.selectFuelType()
					.selectPaymentType(payment)
					.EnterDetails(getAPrice,"yes","OAM")
					.verifyQuoteResultPage()
					.logout();

				}
			}
	}

	@Test(groups = {FunctionalCategory.Eshop})
	public void verifyOAMElecJourneyNewAddr(){
		Report.createTestLogHeader("Get A Quote", "OAM Electricity Journey for new Address");
		final PriceDetails getAPrice = new TestDataHelper().getPriceDetails("Anonymous");
		final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");

		for(String payment : paymentoptions){
			String[] fuelTypes = {"Gas","Elec","Dual"};
			for (String Fuel : fuelTypes){
				new HomePageAction()
				.navigateToLogin()
				.loginDetails(userProfile)
				.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount());
				new GetAQuoteActionNew("New",Fuel,"Elec")
				.navigateToGetAQuotePage()
				.selectAddress()
				.enterPostCode(getAPrice)
				.selectFuelType()
				.selectPaymentType(payment)
				.EnterDetails(getAPrice,"yes","OAM")
				.verifyQuoteResultPage()
				.logout();

			}

		}
	}

	@Test(groups = {FunctionalCategory.Eshop})
	public void verifyOAMDualJourneyNewAddr(){
		Report.createTestLogHeader("Get A Quote", "OAM Dual Journey for new Address");
		final PriceDetails getAPrice = new TestDataHelper().getPriceDetails("Anonymous");
		final UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		for(String payment : paymentoptions){
			String[] fuelTypes = {"Gas","Elec","Dual"};
			for (String Fuel : fuelTypes){
				new HomePageAction()
				.navigateToLogin()
				.loginDetails(userProfile)
				.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount());
				new GetAQuoteActionNew("New",Fuel,"Dual")
				.navigateToGetAQuotePage()
				.selectAddress()
				.enterPostCode(getAPrice)
				.selectFuelType()
				.selectPaymentType(payment)
				.EnterDetails(getAPrice,"yes","OAM")
				.verifyQuoteResultPage()
				.logout();
			}

		}
	}

	@Test(groups = {FunctionalCategory.Eshop})
	public void verifyOAMGasJourneyExistAddr(){
		Report.createTestLogHeader("Get A Quote", "OAM Gas Journey for Existing Address logged in customer");
		final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		final PriceDetails getAPrice = new TestDataHelper().getPriceDetails("Anonymous");
		for(String payment : paymentoptions){
			String[] fuelTypes = {"Gas","Elec"};
			for (String Fuel : fuelTypes){
				new HomePageAction()
				.navigateToLogin()
				.loginDetails(userProfile)
				.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount());
				new GetAQuoteActionNew("Exist",Fuel,"Gas")
				.navigateToGetAQuotePage()
				.selectAddress()
				.selectFuelType()
				.selectPaymentType(payment)
				.EnterDetails(getAPrice,"yes","OAM")
				.verifyQuoteResultPage()
				.logout();
			}	
		}
	}

	@Test(groups = {FunctionalCategory.Eshop})
	public void verifyOAMElecJourneyExistAddr(){
		Report.createTestLogHeader("Get A Quote", "OAM Electricity Journey for Existing Address logged in customer");
		final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		final PriceDetails getAPrice = new TestDataHelper().getPriceDetails("Anonymous");
		for(String payment : paymentoptions){
			String[] fuelTypes = {"Gas","Elec"};
			for (String Fuel : fuelTypes){
				new HomePageAction()
				.navigateToLogin()
				.loginDetails(userProfile)
				.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount());
				new GetAQuoteActionNew("Exist",Fuel,"Elec")
				.navigateToGetAQuotePage()
				.selectAddress()
				.selectFuelType()
				.selectPaymentType(payment)
				.EnterDetails(getAPrice,"yes","OAM")
				.verifyQuoteResultPage()
				.logout();
			}
		}
	}

	@Test(groups = {FunctionalCategory.Eshop})
	public void verifyOAMDualJourneyExistAddr(){
		Report.createTestLogHeader("Get A Quote", "OAM Dual Journey for Existing Address logged in customer");
		final UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		String Fuel = "Dual";
		new HomePageAction()
		.navigateToLogin()
		.loginDetails(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount());
		new GetAQuoteActionNew("Exist",Fuel,"Dual")
		.navigateToGetAQuotePage()
		.selectAddress()
		.verifyQuoteResultPage();
	}

}
