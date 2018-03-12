package bg.framework.app.functional.test.sales;

import static bg.framework.app.functional.entities.FunctionalCategory.BetterDeal;
import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;
import org.testng.annotations.Test;
import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.sales.BetterDealAction;
import bg.framework.app.functional.action.sales.EshopActionNew;
import bg.framework.app.functional.action.sales.GetAQuoteActionNew;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SiebelDataBase;
import bg.framework.app.functional.util.TestDataHelper;
import bg.framework.app.functional.entities.EshopTariffProfile;

public class BetterDealTest extends TestBase {

	private String Tariff;
	private String Fuel;
	private int TariffIncrement;
	private int FuelIncrement;
	/******************************************* Mandatory Data(UserProfile.xml) ***********************************************/
	/*---OAM ELE,GAS,JI,DUAL,
	 * Email ID
	 * Title
	 * First Name
	 * Last Name
	 * Home Number
	 * Post Code
	 * Gas Account Number
	 * Electricity Account Number
	
	
	*/
	
	@Test(groups = { BetterDeal, Smoke })
	public void betterDealForGas(){
    Report.createTestLogHeader("Better Deal", "Better Deal for Gas");
	UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousGasAccount");
	final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("Gas");
	 TariffIncrement = 1;
	 while((Tariff = eshopTariff.getTariff(TariffIncrement)) !="" ){
			Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
			FuelIncrement = 1;
			while((Fuel = eshopTariff.getFueltariff(TariffIncrement, FuelIncrement)) != ""){
				 String AccType="Single";
				 String FuelType="gas";
				new HomePageAction()
				        .navigateToLogin()
						.loginDetails(userProfile)
						.navigateToAccountSummaryPage(userProfile);
				new BetterDealAction().navigateToYourTariffCheckPage()
						.verifyYourTariffCheckPage(AccType);
				new BetterDealAction(Fuel, "Eshop", "Gas", "Exist")
						.selectTariff(Tariff, eshopTariff);
				new BetterDealAction()
						.verifyBetterdealOverlayAndConfirm(userProfile,FuelType)
						.verifyThankyouPage()
						.logout();
				/*new HomePageAction()
				        .navigateToLogin()
						.loginDetails(userProfile)
						.navigateToAccountSummaryPage(userProfile);
				new BetterDealAction(Fuel, "Eshop", "Elec", "Exist")
						.verifyChangedTariffInAccountSummaryPage(Tariff)
						.logout();*/
				++FuelIncrement;
			}
			++TariffIncrement;
		}
     
	
	}

	@Test(groups = { BetterDeal, Smoke })
	public void betterDealForElectricity(){
    Report.createTestLogHeader("Better Deal", "Better Deal for Electricity");
	UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousElecAccount");
	final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("Electricity");
	 TariffIncrement = 1;
	 while((Tariff = eshopTariff.getTariff(TariffIncrement)) !="" ){
			Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
			FuelIncrement = 1;
			while((Fuel = eshopTariff.getFueltariff(TariffIncrement, FuelIncrement)) != ""){
				String AccType = "Single";
				String FuelType = "elec";
				new HomePageAction()
				        .navigateToLogin()
						.loginDetails(userProfile)
						.navigateToAccountSummaryPage(userProfile);
				new BetterDealAction()
				        .navigateToYourTariffCheckPage()
						.verifyYourTariffCheckPage(AccType);
				new BetterDealAction(Fuel, "Eshop", "Elec", "Exist")
						.selectTariff(Tariff, eshopTariff);
				new BetterDealAction()
						.verifyBetterdealOverlayAndConfirm(userProfile,FuelType)
						.verifyThankyouPage()
						.logout();
				/*new HomePageAction()
				        .navigateToLogin()
						.loginDetails(userProfile)
						.navigateToAccountSummaryPage(userProfile);
				new BetterDealAction(Fuel, "Eshop", "Elec", "Exist")
				        .verifyChangedTariffInAccountSummaryPage(Tariff)
				        .logout();*/
				++FuelIncrement;
			}
			++TariffIncrement;
		}
     
	
	}
	@Test(groups = { BetterDeal, Smoke })
	public void betterDealForDual(){
    Report.createTestLogHeader("Better Deal", "Better Deal for Dual");
	UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousDualAccount");
	final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("Dual");
	 TariffIncrement = 1;
	 while((Tariff = eshopTariff.getTariff(TariffIncrement)) !="" ){
			Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
			FuelIncrement = 1;
			while((Fuel = eshopTariff.getFueltariff(TariffIncrement, FuelIncrement)) != ""){
				String AccType = "Dual";
				String FuelType = "gas";
				String accNum = userProfile.getElecAccount();
				System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+accNum);
				new HomePageAction()
				        .navigateToLogin()
						.loginDetails(userProfile)
						.navigateToAccountSummaryPage(userProfile);
				new BetterDealAction()
				        .navigateToYourTariffCheckPage()
						.verifyYourTariffCheckPage(AccType);
				new BetterDealAction(Fuel, "Eshop", "Dual", "Exist")
						.selectTariff(Tariff, eshopTariff);
				new BetterDealAction()
						.verifyBetterdealOverlayAndConfirm(userProfile,FuelType)
						.verifyThankyouPage()
						.logout();
				/*new HomePageAction()
				        .navigateToLogin()
						.loginDetails(userProfile)
						.navigateToAccountSummaryPage(userProfile);
				new BetterDealAction(Fuel, "Eshop", "Dual", "Exist")
				        .verifyChangedTariffInAccountSummaryPageforDual(Tariff,accNum)
				        .logout();*/
				++FuelIncrement;
			}
			++TariffIncrement;
		}
     
	
	}
	@Test(groups = { BetterDeal, Smoke })
	public void betterDealForJI(){
    Report.createTestLogHeader("Better Deal", "Better Deal for JI");
	UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousJIAccount");
	final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("JI");
	 TariffIncrement = 1;
	 while((Tariff = eshopTariff.getTariff(TariffIncrement)) !="" ){
			Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
			FuelIncrement = 1;
			while((Fuel = eshopTariff.getFueltariff(TariffIncrement, FuelIncrement)) != ""){
				String AccType = "JI";
				String FuelType = "gas";
				new HomePageAction()
				        .navigateToLogin()
						.loginDetails(userProfile)
						.navigateToAccountSummaryPage(userProfile);
				new BetterDealAction()
				        .navigateToYourTariffCheckPage()
						.verifyYourTariffCheckPage(AccType);
				new BetterDealAction(Fuel, "Eshop", "JI", "Exist")
						.selectTariff(Tariff, eshopTariff);
				new BetterDealAction()
						.verifyBetterdealOverlayAndConfirm(userProfile,FuelType)
						.verifyThankyouPage()
						.logout();
			/*	new HomePageAction()
				        .navigateToLogin()
						.loginDetails(userProfile)
						.navigateToAccountSummaryPage(userProfile);
				new BetterDealAction(Fuel, "Eshop", "JI", "Exist")
				        .verifyChangedTariffInAccountSummaryPageJI(Tariff)
				        .logout();*/
				++FuelIncrement;
			}
			++TariffIncrement;
		}
     
	
	}
}
