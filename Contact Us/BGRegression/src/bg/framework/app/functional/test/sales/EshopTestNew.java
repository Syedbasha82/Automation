package bg.framework.app.functional.test.sales;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.sales.EshopActionNew;
import bg.framework.app.functional.action.sales.GasAndElectricityAction;
import bg.framework.app.functional.action.sales.GetAQuoteActionNew;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.EshopTariffProfile;
import bg.framework.app.functional.entities.FunctionalCategory;
import bg.framework.app.functional.entities.GetAPrice;
import bg.framework.app.functional.entities.GetAPricePageProfile;
import bg.framework.app.functional.entities.PriceDetails;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;

public class EshopTestNew extends TestBase{
	private String Tariff;
	private String Fuel;
	private int TariffIncrement;
	private int FuelIncrement;

	@Test(groups = { FunctionalCategory.Acquisition })
	public void verifyEshopAnonymousJourney(){

		Report.createTestLogHeader("Eshop Acquisition Journey", "Anonymous Journey");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("Anonymous");
		final PriceDetails getAPrice = new TestDataHelper().getPriceDetails("Anonymous");
		final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");

		String payment ="MDD";
		TariffIncrement = 1;
		while((Tariff = eshopTariff.getTariff(TariffIncrement)) !="" ){
			Report.updateTestLog("********************"    +Tariff+   "**********************", "Pass");
			FuelIncrement = 1;
			while((Fuel = eshopTariff.getFueltariff(TariffIncrement, FuelIncrement)) != ""){
				System.out.println("111111111111111111111111111111111111111"+  Fuel);
				new GetAQuoteActionNew("New",Fuel,"Anonymous")
				.navigateToGetAQuotePage()
				.enterPostCode(getAPrice)
				.selectFuelType()
				.selectPaymentType(payment)
				.EnterDetails(getAPrice,"no", "AnoyCust")
				.verifyQuoteResultPage();
				new EshopActionNew(Fuel,"Eshop","AnonymousCust","New")
				.selectTariff(Tariff,eshopTariff)
				.fillOrderDetailsPage(acquisition)
				.JourneyType(payment, acquisition, userProfile)
				//.verifyEshopLeadID()
				//.verifyEshopLeadType(userProfile)
				.verifyThankyouPage();	
				++FuelIncrement;
			}
			++TariffIncrement;
		}	
	}

	@Test(groups = { FunctionalCategory.Acquisition })
	public void verifyEshopLoggedInGasAnonymousJourney(){

		Report.createTestLogHeader("Eshop Acquisition Journey", "Anonymous Journey for gas account");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("Anonymous");
		final PriceDetails getAPrice = new TestDataHelper().getPriceDetails("Anonymous");
		final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");

		String payment ="MDD";
		TariffIncrement = 1;
		while((Tariff = eshopTariff.getTariff(TariffIncrement)) !="" ){
			Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
			FuelIncrement = 1;
			while((Fuel = eshopTariff.getFueltariff(TariffIncrement, FuelIncrement)) != ""){
				new HomePageAction()	                
				.navigateToLogin()
				.login(userProfile);
				new GetAQuoteActionNew("New",Fuel,"Gas")
				.navigateToGetAQuotePage()
				.selectAddress()
				.enterPostCode(getAPrice)
				.selectFuelType()
				.selectPaymentType(payment)
				.EnterDetails(getAPrice,"no", "OAM")
				.verifyQuoteResultPage();
				new EshopActionNew(Fuel,"Eshop","Gas","New")
				.selectTariff(Tariff,eshopTariff)
				.fillOrderDetailsPage(acquisition)
				.JourneyType(payment, acquisition, userProfile)
				//.verifyEshopLeadID()
				//.verifyEshopLeadType(userProfile)
				.verifyThankyouPage()
				.logout();
				++FuelIncrement;
			}
			++TariffIncrement;
		}
	}

	@Test(groups = { FunctionalCategory.Acquisition })
	public void verifyEshopLoggedInElecAnonymousJourney(){

		Report.createTestLogHeader("Eshop Acquisition Journey", "Anonymous Journey for Electricity account");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("Anonymous");
		final PriceDetails getAPrice = new TestDataHelper().getPriceDetails("Anonymous");
		final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");

		String payment ="MDD";
		TariffIncrement = 1;
		while((Tariff = eshopTariff.getTariff(TariffIncrement)) !="" ){
			Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
			FuelIncrement = 1;
			while((Fuel = eshopTariff.getFueltariff(TariffIncrement, FuelIncrement)) != ""){
				new HomePageAction()	                
				.navigateToLogin()
				.login(userProfile);
				new GetAQuoteActionNew("New",Fuel,"Elec")
				.navigateToGetAQuotePage()
				.selectAddress()
				.enterPostCode(getAPrice)
				.selectFuelType()
				.selectPaymentType(payment)
				.EnterDetails(getAPrice,"no", "AnoyCust")
				.verifyQuoteResultPage();
				new EshopActionNew(Fuel,"Eshop","Elec","New")
				.selectTariff(Tariff,eshopTariff)
				.fillOrderDetailsPage(acquisition)
				.JourneyType(payment, acquisition, userProfile)
				//.verifyEshopLeadID()
				//.verifyEshopLeadType(userProfile)
				.verifyThankyouPage()
				.logout();
				++FuelIncrement;
			}
			++TariffIncrement;
		}
	}

	@Test(groups = { FunctionalCategory.Acquisition })
	public void verifyEshopLoggedInDualAnonymousJourney(){

		Report.createTestLogHeader("Eshop Acquisition Journey", "Anonymous Journey for Dual account");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("Anonymous");
		final PriceDetails getAPrice = new TestDataHelper().getPriceDetails("Anonymous");
		final UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");

		String payment ="MDD";
		TariffIncrement = 1;
		while((Tariff = eshopTariff.getTariff(TariffIncrement)) !="" ){
			Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
			FuelIncrement = 1;
			while((Fuel = eshopTariff.getFueltariff(TariffIncrement, FuelIncrement)) != ""){
				new HomePageAction()	                
				.navigateToLogin()
				.login(userProfile);
				new GetAQuoteActionNew("New",Fuel,"Dual")
				.navigateToGetAQuotePage()
				.selectAddress()
				.enterPostCode(getAPrice)
				.selectFuelType()
				.selectPaymentType(payment)
				.EnterDetails(getAPrice,"no", "AnoyCust")
				.verifyQuoteResultPage();
				new EshopActionNew(Fuel,"Eshop","Dual","New")
				.selectTariff(Tariff,eshopTariff)
				.fillOrderDetailsPage(acquisition)
				.JourneyType(payment, acquisition, userProfile)
				//.verifyEshopLeadID()
				//.verifyEshopLeadType(userProfile)
				.verifyThankyouPage()
				.logout();
				++FuelIncrement;
			}
			++TariffIncrement;
		}
	}
	
	@Test(groups = { FunctionalCategory.Acquisition })
	public void verifyEshopLoggedInJIAccountAnonymousJourney(){

		Report.createTestLogHeader("Eshop Acquisition Journey", "Anonymous Journey for JI account");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("Anonymous");
		final PriceDetails getAPrice = new TestDataHelper().getPriceDetails("Anonymous");
		final UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");

		String payment ="MDD";
		TariffIncrement = 1;
		while((Tariff = eshopTariff.getTariff(TariffIncrement)) !="" ){
			Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
			FuelIncrement = 1;
			while((Fuel = eshopTariff.getFueltariff(TariffIncrement, FuelIncrement)) != ""){
				new HomePageAction()	                
				.navigateToLogin()
				.login(userProfile);
				new GetAQuoteActionNew("New",Fuel,"JI")
				.navigateToGetAQuotePage()
				.selectAddress()
				.enterPostCode(getAPrice)
				.selectFuelType()
				.selectPaymentType(payment)
				.EnterDetails(getAPrice,"no", "AnoyCust")
				.verifyQuoteResultPage();
				new EshopActionNew(Fuel,"Eshop","Dual","New")
				.selectTariff(Tariff,eshopTariff)
				.fillOrderDetailsPage(acquisition)
				.JourneyType(payment, acquisition, userProfile)
				//.verifyEshopLeadID()
				//.verifyEshopLeadType(userProfile)
				.verifyThankyouPage()
				.logout();
				++FuelIncrement;
			}
			++TariffIncrement;
		}
	}
	
	@Test(groups = { FunctionalCategory.Acquisition })
	public void verifyEshopLoggedInSSOAnonymousJourney(){

		Report.createTestLogHeader("Eshop Acquisition Journey", "Anonymous Journey for SSO account");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("Anonymous");
		final PriceDetails getAPrice = new TestDataHelper().getPriceDetails("Anonymous");
		final UserProfile userProfile = new TestDataHelper().getUserProfile("SSOAccount");

		String payment ="MDD";
		TariffIncrement = 1;
		while((Tariff = eshopTariff.getTariff(TariffIncrement)) !="" ){
			Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
			FuelIncrement = 1;
			while((Fuel = eshopTariff.getFueltariff(TariffIncrement, FuelIncrement)) != ""){
				new HomePageAction()	                
				.navigateToLogin()
				.login(userProfile);
				new GetAQuoteActionNew("New",Fuel,"SSO")
				.navigateToGetAQuotePage()
				.enterPostCode(getAPrice)
				.selectFuelType()
				.selectPaymentType(payment)
				.EnterDetails(getAPrice,"no", "AnoyCust")
				.verifyQuoteResultPage();
				new EshopActionNew(Fuel,"Eshop","AnonymousCust","New")
				.selectTariff(Tariff,eshopTariff)
				.fillOrderDetailsPage(acquisition)
				.JourneyType(payment, acquisition, userProfile)
				//.verifyEshopLeadID()
				//.verifyEshopLeadType(userProfile)
				.verifyThankyouPage()
				.logout();
				++FuelIncrement;
			}
			++TariffIncrement;
		}
	}
	
	@Test(groups = { FunctionalCategory.Acquisition })
	public void verifyEshopLoggedInWTPAnonymousJourney(){

		Report.createTestLogHeader("Eshop Acquisition Journey", "Anonymous Journey for WTP account");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("Anonymous");
		final PriceDetails getAPrice = new TestDataHelper().getPriceDetails("Anonymous");
		final UserProfile userProfile = new TestDataHelper().getUserProfile("WTPAccount");

		String payment ="MDD";
		TariffIncrement = 1;
		while((Tariff = eshopTariff.getTariff(TariffIncrement)) !="" ){
			Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
			FuelIncrement = 1;
			while((Fuel = eshopTariff.getFueltariff(TariffIncrement, FuelIncrement)) != ""){
				new HomePageAction()	                
				.navigateToLogin()
				.login(userProfile);
				new GetAQuoteActionNew("New",Fuel,"WTP")
				.navigateToGetAQuotePage()
				.enterPostCode(getAPrice)
				.selectFuelType()
				.selectPaymentType(payment)
				.EnterDetails(getAPrice,"no", "AnoyCust")
				.verifyQuoteResultPage();
				new EshopActionNew(Fuel,"Eshop","AnonymousCust","New")
				.selectTariff(Tariff,eshopTariff)
				.fillOrderDetailsPage(acquisition)
				.JourneyType(payment, acquisition, userProfile)
				//.verifyEshopLeadID()
				//.verifyEshopLeadType(userProfile)
				.verifyThankyouPage()
				.logout();
				++FuelIncrement;
			}
			++TariffIncrement;
		}
	}
	
	public void verifyEshopLoggedInServicesAccountAnonymousJourney(){

		Report.createTestLogHeader("Eshop Acquisition Journey", "Anonymous Journey for Services account");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("Anonymous");
		final PriceDetails getAPrice = new TestDataHelper().getPriceDetails("Anonymous");
		final UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");

		String payment ="QCC";
		TariffIncrement = 1;
		while((Tariff = eshopTariff.getTariff(TariffIncrement)) !="" ){
			Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
			FuelIncrement = 1;
			while((Fuel = eshopTariff.getFueltariff(TariffIncrement, FuelIncrement)) != ""){
				new HomePageAction()	                
				.navigateToLogin()
				.login(userProfile);
				new GetAQuoteActionNew("New",Fuel,"Services")
				.navigateToGetAQuotePage()
				.selectAddress()
				.enterPostCode(getAPrice)
				.selectFuelType()
				.selectPaymentType(payment)
				.EnterDetails(getAPrice,"no", "AnoyCust")
				.verifyQuoteResultPage();
				new EshopActionNew(Fuel,"Eshop","AnonymousCust","New")
				.selectTariff(Tariff,eshopTariff)
				.fillOrderDetailsPage(acquisition)
				.JourneyType(payment, acquisition, userProfile)
				//.verifyEshopLeadID()
				//.verifyEshopLeadType(userProfile)
				.verifyThankyouPage()
				.logout();
				++FuelIncrement;
			}
			++TariffIncrement;
		}
	}

	/*
	 *  ******************************************* Acquisition and Conversion Journey for Existing Property********************************************** 
	 */

	@Test(groups = { FunctionalCategory.Acquisition })
	public void verifyEshopLoggedInGasOAMJourney(){
		Report.createTestLogHeader("Eshop Journey", "OAM Journey (Acquisition and Conversion) for gas account");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("Gas");
		final PriceDetails getAPrice = new TestDataHelper().getPriceDetails("Anonymous");
		final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");

		String payment ="MDD";
		TariffIncrement = 1;
		while((Tariff = eshopTariff.getTariff(TariffIncrement)) !="" ){
			Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
			FuelIncrement = 1;
			while((Fuel = eshopTariff.getFueltariff(TariffIncrement, FuelIncrement)) != ""){
				new HomePageAction()	                
				.navigateToLogin()
				.login(userProfile);
				new GetAQuoteActionNew("Exist",Fuel,"Gas")
				.navigateToGetAQuotePage()
				.selectAddress()
				.enterPostCode(getAPrice)
				.selectFuelType()
				.selectPaymentType(payment)
				.EnterDetails(getAPrice, "no", "AnoyCust")
				.verifyQuoteResultPage();
				new EshopActionNew(Fuel,"Eshop","Gas","Exist")
				.selectTariff(Tariff,eshopTariff)
				.fillOrderDetailsPage(acquisition)
				.JourneyType(payment, acquisition, userProfile)
				.verifyThankyouPage()
				.logout();
				++FuelIncrement;
			}
			++TariffIncrement;
		}
	}
	
	@Test(groups = { FunctionalCategory.Acquisition })
	public void verifyEshopLoggedInElectricityOAMJourney(){
		Report.createTestLogHeader("Eshop Journey", "OAM Journey (Acquisition and Conversion) for Electricity account");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("Electricity");
		final PriceDetails getAPrice = new TestDataHelper().getPriceDetails("Anonymous");
		final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");

		String payment ="MDD";
		TariffIncrement = 1;
		while((Tariff = eshopTariff.getTariff(TariffIncrement)) !="" ){
			Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
			FuelIncrement = 1;
			while((Fuel = eshopTariff.getFueltariff(TariffIncrement, FuelIncrement)) != ""){
				new HomePageAction()	                
				.navigateToLogin()
				.login(userProfile);
				new GetAQuoteActionNew("Exist",Fuel,"Elec")
				.navigateToGetAQuotePage()
				.selectAddress()
				.enterPostCode(getAPrice)
				.selectFuelType()
				.selectPaymentType(payment)
				.EnterDetails(getAPrice, "yes", "AnoyCust")
				.verifyQuoteResultPage();
				new EshopActionNew(Fuel,"Eshop","Elec","Exist")
				.selectTariff(Tariff,eshopTariff)
				.fillOrderDetailsPage(acquisition)
				.JourneyType(payment, acquisition, userProfile)
				.verifyThankyouPage()
				.logout();
				++FuelIncrement;
			}
			++TariffIncrement;
		}
	}


	@Test(groups = { FunctionalCategory.Acquisition })
	public void verifyEshopDualConversionJourney(){

		Report.createTestLogHeader("Eshop Conversion Journey", "Conversion Journey for Dual account");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("Dual");
		final UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");

		String payment ="MDD";
		TariffIncrement = 1;
		while((Tariff = eshopTariff.getTariff(TariffIncrement)) !="" ){
			Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
			FuelIncrement = 1;
			while((Fuel = eshopTariff.getFueltariff(TariffIncrement, FuelIncrement)) != ""){
				new HomePageAction()	                
				.navigateToLogin()
				.login(userProfile);
				new GetAQuoteActionNew("Exist",Fuel,"Dual")
				.navigateToGetAQuotePage()
				.selectAddress()
				.verifyQuoteResultPage();
				new EshopActionNew(Fuel,"Eshop","Dual","Exist")
				.selectTariff(Tariff,eshopTariff)
				.fillOrderDetailsPage(acquisition)
				.JourneyType(payment, acquisition, userProfile)
				.verifyThankyouPage()
				.logout();
				++FuelIncrement;
			}
			++TariffIncrement;
		}
	}

}
