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


public class EshopTest extends TestBase {
	
	private int TariffIncrement;
	private int FuelIncrement;
	private String Tariff;
	private String Fuel;
	
	@Test(groups = {FunctionalCategory.Eshop})
	public void verifyAnonymousEshopTariff(){
		Report.createTestLogHeader("Eshop Acquisition Journey", "Anonymous Journey");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("Anonymous");
		final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
		
		TariffIncrement = 1;
		while((Tariff = eshopTariff.getTariff(TariffIncrement)) != ""){
			Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
			FuelIncrement = 1;
			while((Fuel = eshopTariff.getFueltariff(TariffIncrement, FuelIncrement)) != ""){
				new EshopAction(Fuel,"Eshop","AnonymousCust")
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
	
	@Test(groups = {FunctionalCategory.Eshop})
	public void verifyGasEshopTariff(){
		Report.createTestLogHeader("Eshop OAM Acquisition Journey", "Gas Customer Acquisition Journey");
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
				new EshopAction(Fuel,"Eshop","GasCust")
					.navigateToGasandElectricityPage()
					.navigateToOurTariffsPage()
					.selectTariff(Tariff)
					.selectFuel(Fuel)
					.fillYourOrderPageDetails(acquisition,"SameAddr","Normal")
					.enterPersonalDetails(acquisition,userProfile,"SameAddr","Normal")
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
	
	
	@Test(groups = {FunctionalCategory.Eshop})
	public void verifyElectricityEshopTariff(){
		Report.createTestLogHeader("Eshop OAM Acquisition Journey", "Electricity Customer Acquisition Journey");
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
				new EshopAction(Fuel,"Eshop","ElecCust")
					.navigateToGasandElectricityPage()
					.navigateToOurTariffsPage()
					.selectTariff(Tariff)
					.selectFuel(Fuel)
					.fillYourOrderPageDetails(acquisition,"SameAddr","Normal")
					.enterPersonalDetails(acquisition,userProfile,"SameAddr","Normal")
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
	
	
	@Test(groups = {FunctionalCategory.Eshop})
	public void verifyDualEshopTariff(){
		Report.createTestLogHeader("Eshop OAM Acquisition Journey", "Dual Customer Acquisition Journey");
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
				new EshopAction(Fuel,"Eshop","DualCust")
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
	
	
	@Test(groups = {FunctionalCategory.Eshop})
	public void verifyBGSEshopTariff(){
		Report.createTestLogHeader("Eshop OAM Acquisition Journey", "BGS Customer Acquisition Journey");
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
				new EshopAction(Fuel,"Eshop","BGSCust")
					.navigateToGasandElectricityPage()
					.navigateToOurTariffsPage()
					.selectTariff(Tariff)
					.selectFuel(Fuel)
					.fillYourOrderPageDetails(acquisition,"SameAddr","Normal")
					.enterPersonalDetails(acquisition,userProfile,"SameAddr","Normal")
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
	
	@Test(groups = {FunctionalCategory.Eshop})
	public void verifySSOEshopTariff(){
		Report.createTestLogHeader("Eshop OAM Acquisition Journey", "SSO Customer Acquisition Journey");
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
				new EshopAction(Fuel,"Eshop","SSOCust")
					.navigateToGasandElectricityPage()
					.navigateToOurTariffsPage()
					.selectTariff(Tariff)
					.selectFuel(Fuel)
					.fillYourOrderPageDetails(acquisition,"SameAddr","Normal")
					.enterPersonalDetails(acquisition,userProfile,"SameAddr","Normal")
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
	
	@Test(groups = {FunctionalCategory.Eshop})
	public void verifyWTPEshopTariff(){
		Report.createTestLogHeader("Eshop OAM Acquisition Journey", "WTP Customer Acquisition Journey");
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
				new EshopAction(Fuel,"Eshop","WTPCust")
					.navigateToGasandElectricityPage()
					.navigateToOurTariffsPage()
					.selectTariff(Tariff)
					.selectFuel(Fuel)
					.fillYourOrderPageDetails(acquisition,"SameAddr","Normal")
					.enterPersonalDetails(acquisition,userProfile,"SameAddr","Normal")
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
	
	@Test(groups = {FunctionalCategory.Eshop})
	public void verifyGasConversionTariffs(){
		Report.createTestLogHeader("Eshop OAM Gas Conversion Journey", "Gas Conversion Journey");
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
				new EshopAction(Fuel,"Eshop","GasCust")
					.navigateToGasandElectricityPage()
					.navigateToOurTariffsPage()
					.selectTariff(Tariff)
					.selectFuel(Fuel)
					.fillConversionYourOrderPageDetails(acquisition)
					.enterReviewOrderDetails()
					.verifyThankyouPage("Gas")
					.logout()
					.backToHomepage();
					
			++TariffIncrement;
		}
	}
	
	
	@Test(groups = {FunctionalCategory.Eshop})
	public void verifyElectricityConversionTariffs(){
		Report.createTestLogHeader("Eshop OAM Electricity Conversion Journey", "Electricity Conversion Journey");
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
				new EshopAction(Fuel,"Eshop","ElecCust")
					.navigateToGasandElectricityPage()
					.navigateToOurTariffsPage()
					.selectTariff(Tariff)
					.selectFuel(Fuel)
					.fillConversionYourOrderPageDetails(acquisition)
					.enterReviewOrderDetails()
					.verifyThankyouPage("Electricity")
					.logout()
					.backToHomepage();
					
			++TariffIncrement;
		}
	}
	
	
	@Test(groups = {FunctionalCategory.Eshop})
	public void verifyDualConversionTariffs(){
		Report.createTestLogHeader("Eshop OAM Dual Conversion Journey", "Dual Conversion Journey");
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
				new EshopAction(Fuel,"Eshop","DualCust")
					.navigateToGasandElectricityPage()
					.navigateToOurTariffsPage()
					.selectTariff(Tariff)
					.selectFuel(Fuel)
					.fillConversionYourOrderPageDetails(acquisition)
					.enterReviewOrderDetails()
					.verifyThankyouPage("Dual")
					.logout()
					.backToHomepage();
					
			++TariffIncrement;
		}
	}
	
	
	@Test(groups = {FunctionalCategory.Eshop})
	public void verifyJIConversionTariffs(){
		Report.createTestLogHeader("Eshop OAM JI Conversion Journey", "JI Conversion Journey");
		final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("JI");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
		Fuel = "Gas";
		TariffIncrement = 1;
		while((Tariff = eshopTariff.getTariff(TariffIncrement)) != ""){
			Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
				new HomePageAction()	                
                	.navigateToLogin()
                	.login(userProfile);
				new EshopAction(Fuel,"Eshop","JICust")
					.navigateToGasandElectricityPage()
					.navigateToOurTariffsPage()
					.selectTariff(Tariff)
					.selectFuel(Fuel)
					.fillConversionYourOrderPageDetails(acquisition)
					.enterReviewOrderDetails()
					.verifyThankyouPage("Gas")
					.logout()
					.backToHomepage();
					
			++TariffIncrement;
		}
	}
	
	/****************************************    Part Acquisition And Part Conversion **************************************/  
	@Test(groups = {FunctionalCategory.Eshop})
	public void verifyGasTariffs(){
		Report.createTestLogHeader("Eshop OAM Gas Part Acquisition And Part Conversion Journey", "Gas Part Acquisition and Part Conversion Journey");
		final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("Gas");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		Fuel = "Dual";
		TariffIncrement = 1;
		while((Tariff = eshopTariff.getTariff(TariffIncrement)) != ""){
			Report.updateTestLog("********************************** "+Tariff+"************************", "Pass");
			     new HomePageAction()
			         .navigateToLogin()
			         .login(userProfile);
			     new EshopAction(Fuel,"Eshop","GasCust")
			         .navigateToGasandElectricityPage()
			         .navigateToOurTariffsPage()
			         .selectTariff(Tariff)
			         .selectFuel(Fuel)
			         .fillPartAcqAndPartConversionYourOrderPageDetails(acquisition,Fuel)
					 .enterPersonalDetails(acquisition,userProfile,"DiffAddr","Normal")
					 .enterCurrentMeterDetails(acquisition,Fuel)
					 .enterPaymentDetails(acquisition)
					 .enterReviewOrderDetails()
					 //.verifyEshopLeadType()
				    //.verifyEshopLeadID()
					 .verifyThankyouPage(Fuel)
					 .logout()
					 .backToHomepage();
						
				++TariffIncrement;
			}					
		}
	
	/****************************************    Error Validation for TOU CUSTOMERS**************************************/  
	@Test(groups = {FunctionalCategory.Eshop})
	public void verifyElectricityEshopTariffforTOU(){
		Report.createTestLogHeader("Eshop OAM Gas Part Acquisition And Part Conversion Journey for TOU Customers", "Error out for TOU Customers while EShop Journey");
		final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("Gas");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount1");
		Fuel = "Dual";
		new HomePageAction()
        .navigateToLogin()
        .login(userProfile);
    new EshopAction(Fuel,"Eshop","GasCust")
        .navigateToGasandElectricityPage()
        .navigateToOurTariffsPage()
        .selectTariff("Standard")
        .selectFuel(Fuel)
        .fillPartAcqAndPartConversionYourOrderPageDetails(acquisition,Fuel)
        .verifyErrorMessage()
        .logout()
        .backToHomepage();
}
}
