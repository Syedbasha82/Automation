package bg.framework.app.functional.test.reFactoring;

import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.FunctionalCategory;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import static bg.framework.app.functional.entities.FunctionalCategory.*;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.reFactoring.EshopAction;
import bg.framework.app.functional.entities.EshopTariffProfile;


public class ESmartTestNew extends TestBase{ 
	private int TariffIncrement;
	private int FuelIncrement;
	private String Tariff;
	private String Fuel;
	
	@Test(groups = {FunctionalCategory.Esmart})
	public void verifyAnonymousEsmartTariff(){
		Report.createTestLogHeader("Esmart Acquisition Journey", "Anonymous Journey");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("Anonymous");
		final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
		
		TariffIncrement = 1;
		while((Tariff = eshopTariff.getTariff(TariffIncrement)) != ""){
			Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
			FuelIncrement = 1;
			while((Fuel = eshopTariff.getFueltariff(TariffIncrement, FuelIncrement)) != ""){
				new EshopAction(Fuel,"Esmart","AnonymousCust")
					.navigateToGasandElectricityPage()
					.navigateToOurTariffsPage()
					.selectTariff(Tariff)
					.selectFuel(Fuel)
					.fillYourOrderPageDetails(acquisition,"AnonymousAddr","Normal")
					.enterPersonalDetails(acquisition,userProfile,"AnonymousAddr","Normal")
					.enterCurrentMeterDetails(acquisition,Fuel)
					.enterPaymentDetails(acquisition)
					.enterReviewOrderDetails()
					//.verifyEshopLeadType()
					//.verifyEshopLeadID()
					.verifyThankyouPage(Fuel);
				
					
				++FuelIncrement;
			}
			++TariffIncrement;
		}
		TariffIncrement = 1;
	}
	
	@Test(groups = {FunctionalCategory.Esmart})
	public void verifyGasEsmartTariff(){
		Report.createTestLogHeader("ESmart OAM Acquisition Journey", "Gas Customer Acquisition Journey");
		final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("Gas");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile;
		
		TariffIncrement = 1;
		while((Tariff = eshopTariff.getTariff(TariffIncrement)) != ""){
			Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
			userProfile = new TestDataHelper().getUserProfile("GasAccount"+TariffIncrement);
			FuelIncrement = 1;
			while((Fuel = eshopTariff.getFueltariff(TariffIncrement, FuelIncrement)) != ""){
				new HomePageAction()	                
                	.navigateToLogin()
                	.login(userProfile);
				new EshopAction(Fuel,"Esmart","GasCust")
					.navigateToGasandElectricityPage()
					.navigateToOurTariffsPage()
					.selectTariff(Tariff)
					.selectFuel(Fuel)
					.fillYourOrderPageDetails(acquisition,"SameAddr","OAM")
					.enterPersonalDetails(acquisition,userProfile,"SameAddr","OAM")
					.enterCurrentMeterDetails(acquisition,Fuel)
					.enterPaymentDetails(acquisition)
					.enterReviewOrderDetails()
					//.verifyEshopLeadType()
					//.verifyEshopLeadID()
					.verifyThankyouPage(Fuel)
					.logout()
					.backToHomepage();
					
				++FuelIncrement;
			}
			++TariffIncrement;
		}
		TariffIncrement = 1;
					
	}
	
	
	@Test(groups = {FunctionalCategory.Esmart})
	public void verifyElectricityEsmartTariff(){
		Report.createTestLogHeader("Esmart OAM Acquisition Journey", "Electricity Customer Acquisition Journey");
		final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("Electricity");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile;
		
		TariffIncrement = 1;
		while((Tariff = eshopTariff.getTariff(TariffIncrement)) != ""){
			Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
			userProfile = new TestDataHelper().getUserProfile("ElectricityAccount"+TariffIncrement);
			FuelIncrement = 1;
			while((Fuel = eshopTariff.getFueltariff(TariffIncrement, FuelIncrement)) != ""){
				new HomePageAction()	                
                	.navigateToLogin()
                	.login(userProfile);
				new EshopAction(Fuel,"Esmart","ElectricityCust")
					.navigateToGasandElectricityPage()
					.navigateToOurTariffsPage()
					.selectTariff(Tariff)
					.selectFuel(Fuel)
					.fillYourOrderPageDetails(acquisition,"DiffAddr","OAM")
					.enterPersonalDetails(acquisition,userProfile,"DiffAddr","OAM")
					.enterCurrentMeterDetails(acquisition,Fuel)
					.enterPaymentDetails(acquisition)
					.enterReviewOrderDetails()
					//.verifyEshopLeadType()
					//.verifyEshopLeadID()
					.verifyThankyouPage(Fuel)
					.logout()
					.backToHomepage();
					
				++FuelIncrement;
			}
			++TariffIncrement;
		}
		TariffIncrement = 1;
	}
	
	
	@Test(groups = {FunctionalCategory.Esmart})
	public void verifyDualEsmartTariff(){
		Report.createTestLogHeader("Esmart OAM Acquisition Journey", "Dual Customer Acquisition Journey");
		final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("Dual");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile;
		
		TariffIncrement = 1;
		while((Tariff = eshopTariff.getTariff(TariffIncrement)) != ""){
			Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
			userProfile = new TestDataHelper().getUserProfile("DualAccount"+TariffIncrement);
			FuelIncrement = 1;
			while((Fuel = eshopTariff.getFueltariff(TariffIncrement, FuelIncrement)) != ""){
				new HomePageAction()	                
                	.navigateToLogin()
                	.login(userProfile);
				new EshopAction(Fuel,"Esmart","DualCust")
					.navigateToGasandElectricityPage()
					.navigateToOurTariffsPage()
					.selectTariff(Tariff)
					.selectFuel(Fuel)
					.fillYourOrderPageDetails(acquisition,"SameAddr","OAM")
					.enterPersonalDetails(acquisition,userProfile,"SameAddr","OAM")
					.enterCurrentMeterDetails(acquisition,Fuel)
					.enterPaymentDetails(acquisition)
					.enterReviewOrderDetails()
					//.verifyEshopLeadType()
					//.verifyEshopLeadID()
					.verifyThankyouPage(Fuel)
					.logout()
					.backToHomepage();
					
				++FuelIncrement;
			}
			++TariffIncrement;
		}
		TariffIncrement = 1;
					
	}
	
	
	@Test(groups = {FunctionalCategory.Esmart})
	public void verifyBGSEsmartTariff(){
		Report.createTestLogHeader("Esmart OAM Acquisition Journey", "BGS Customer Acquisition Journey");
		final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("BGS");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");
		
		TariffIncrement = 1;
		while((Tariff = eshopTariff.getTariff(TariffIncrement)) != ""){
			Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
			FuelIncrement = 1;
			while((Fuel = eshopTariff.getFueltariff(TariffIncrement, FuelIncrement)) != ""){
				new HomePageAction()	                
                	.navigateToLogin()
                	.login(userProfile);
				new EshopAction(Fuel,"Esmart","BGSCust")
					.navigateToGasandElectricityPage()
					.navigateToOurTariffsPage()
					.selectTariff(Tariff)
					.selectFuel(Fuel)
					.fillYourOrderPageDetails(acquisition,"DiffAddr","Normal")
					.enterPersonalDetails(acquisition,userProfile,"DiffAddr","Normal")
					.enterCurrentMeterDetails(acquisition,Fuel)
					.enterPaymentDetails(acquisition)
					.enterReviewOrderDetails()
					//.verifyEshopLeadType()
					//.verifyEshopLeadID()
					.verifyThankyouPage(Fuel)
					.logout()
					.backToHomepage();
					
				++FuelIncrement;
			}
			++TariffIncrement;
		}
		TariffIncrement = 1;
					
	}
	
	@Test(groups = {FunctionalCategory.Esmart})
	public void verifySSOEsmartTariff(){
		Report.createTestLogHeader("Esmart OAM Acquisition Journey", "SSO Customer Acquisition Journey");
		final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("SSO");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper().getUserProfile("SSOAccount");
		
		TariffIncrement = 1;
		while((Tariff = eshopTariff.getTariff(TariffIncrement)) != ""){
			Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
			FuelIncrement = 1;
			while((Fuel = eshopTariff.getFueltariff(TariffIncrement, FuelIncrement)) != ""){
				new HomePageAction()	                
                	.navigateToLogin()
                	.login(userProfile);
				new EshopAction(Fuel,"Esmart","SSOCust")
					.navigateToGasandElectricityPage()
					.navigateToOurTariffsPage()
					.selectTariff(Tariff)
					.selectFuel(Fuel)
					.fillYourOrderPageDetails(acquisition,"DiffAddr","Normal")
					.enterPersonalDetails(acquisition,userProfile,"DiffAddr","Normal")
					.enterCurrentMeterDetails(acquisition,Fuel)
					.enterPaymentDetails(acquisition)
					.enterReviewOrderDetails()
					//.verifyEshopLeadType()
					//.verifyEshopLeadID()
					.verifyThankyouPage(Fuel)
					.logout()
					.backToHomepage();
					
				++FuelIncrement;
			}
			++TariffIncrement;
		}
		TariffIncrement = 1;
					
	}
	
	@Test(groups = {FunctionalCategory.Esmart})
	public void verifyWTPEsmartTariff(){
		Report.createTestLogHeader("Esmart OAM Acquisition Journey", "WTP Customer Acquisition Journey");
		final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("WTP");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper().getUserProfile("WTPAccount");
		
		TariffIncrement = 1;
		while((Tariff = eshopTariff.getTariff(TariffIncrement)) != ""){
			Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
			FuelIncrement = 1;
			while((Fuel = eshopTariff.getFueltariff(TariffIncrement, FuelIncrement)) != ""){
				new HomePageAction()	                
                	.navigateToLogin()
                	.login(userProfile);
				new EshopAction(Fuel,"Esmart","WTPCust")
					.navigateToGasandElectricityPage()
					.navigateToOurTariffsPage()
					.selectTariff(Tariff)
					.selectFuel(Fuel)
					.fillYourOrderPageDetails(acquisition,"DiffAddr","Normal")
					.enterPersonalDetails(acquisition,userProfile,"DiffAddr","Normal")
					.enterCurrentMeterDetails(acquisition,Fuel)
					.enterPaymentDetails(acquisition)
					.enterReviewOrderDetails()
					//.verifyEshopLeadType()
					//.verifyEshopLeadID()
					.verifyThankyouPage(Fuel)
					.logout()
					.backToHomepage();
					
				++FuelIncrement;
			}
			++TariffIncrement;
		}
		TariffIncrement = 1;
					
	}
	
	
	/****************************************          CONVERSION JOURNEY 		*********************************************************/
	
	@Test(groups = {FunctionalCategory.Esmart})
	public void verifyGasEsmartConversionTariffs(){
		Report.createTestLogHeader("Esmart OAM Gas Conversion Journey", "Gas Conversion Journey");
		final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("Gas");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		Fuel = "Gas";
		TariffIncrement = 1;
		while((Tariff = eshopTariff.getTariff(TariffIncrement)) != ""){
			Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
				new HomePageAction()	                
                	.navigateToLogin()
                	.login(userProfile);
				new EshopAction(Fuel,"Esmart","GasCust")
					.navigateToGasandElectricityPage()
					.navigateToOurTariffsPage()
					.selectTariff(Tariff)
					.selectFuel("Gas")
					.fillConversionYourOrderPageDetails(acquisition)
					.enterReviewOrderDetails()
					.verifyThankyouPage("Gas")
					.logout()
					.backToHomepage();
					
			++TariffIncrement;
		}
	}
	
	
	@Test(groups = {FunctionalCategory.Esmart})
	public void verifyElectricityEsmartConversionTariffs(){
		Report.createTestLogHeader("Esmart OAM Electricity Conversion Journey", "Electricity Conversion Journey");
		final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("Electricity");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		Fuel = "Electricity";
		TariffIncrement = 1;
		while((Tariff = eshopTariff.getTariff(TariffIncrement)) != ""){
			Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
				new HomePageAction()	                
                	.navigateToLogin()
                	.login(userProfile);
				new EshopAction(Fuel,"Esmart","ElectricityCust")
					.navigateToGasandElectricityPage()
					.navigateToOurTariffsPage()
					.selectTariff(Tariff)
					.selectFuel("Electricity")
					.fillConversionYourOrderPageDetails(acquisition)
					.enterReviewOrderDetails()
					.verifyThankyouPage("Electricity")
					.logout()
					.backToHomepage();
					
			++TariffIncrement;
		}
	}
	
	
	@Test(groups = {FunctionalCategory.Esmart})
	public void verifyDualEsmartConversionTariffs(){
		Report.createTestLogHeader("Esmart OAM Dual Conversion Journey", "Dual Conversion Journey");
		final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("Dual");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		Fuel = "Dual";
		TariffIncrement = 1;
		while((Tariff = eshopTariff.getTariff(TariffIncrement)) != ""){
			Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
				new HomePageAction()	                
                	.navigateToLogin()
                	.login(userProfile);
				new EshopAction(Fuel,"Esmart","DualCust")
					.navigateToGasandElectricityPage()
					.navigateToOurTariffsPage()
					.selectTariff(Tariff)
					.selectFuel("Dual")
					.fillConversionYourOrderPageDetails(acquisition)
					.enterReviewOrderDetails()
					.verifyThankyouPage("Dual")
					.logout()
					.backToHomepage();
					
			++TariffIncrement;
		}
	}
	
	
	@Test(groups = {FunctionalCategory.Esmart})
	public void verifyJIEsmartConversionTariffs(){
		Report.createTestLogHeader("Esmart OAM JI Conversion Journey", "JI Conversion Journey");
		final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("JI");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
		Fuel = "JI";
		TariffIncrement = 1;
		while((Tariff = eshopTariff.getTariff(TariffIncrement)) != ""){
			Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
				new HomePageAction()	                
                	.navigateToLogin()
                	.login(userProfile);
				new EshopAction(Fuel,"Esmart","JICust")
					.navigateToGasandElectricityPage()
					.navigateToOurTariffsPage()
					.selectTariff(Tariff)
					.selectFuel("Gas")
					.fillConversionYourOrderPageDetails(acquisition)
					.enterReviewOrderDetails()
					.verifyThankyouPage("Gas")
					.logout()
					.backToHomepage();
					
			++TariffIncrement;
		}
	}
}
