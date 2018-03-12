package bg.framework.app.functional.test.reFactoring;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.reFactoring.ModelSalesAction;
import bg.framework.app.functional.action.sales.EshopActionNew;
import bg.framework.app.functional.action.sales.GetAQuoteActionNew;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.EshopTariffProfile;
import bg.framework.app.functional.entities.FunctionalCategory;
import bg.framework.app.functional.entities.ModelSalesCombinationsProfile;
import bg.framework.app.functional.entities.ModelSalesProducts;
import bg.framework.app.functional.entities.PriceDetails;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class ModelSalesTest extends TestBase{
	private static boolean flag;
/*	String[] Homecare = new ModelSalesProductsPage().Homecare();
	String[] Homecare100 = new ModelSalesProductsPage().Homecare100();
	String[] BoilerAndHeating = new ModelSalesProductsPage().BoilerAndHeating();
	String[] KAC = new ModelSalesProductsPage().KACProducts();
	String[] GAC = new ModelSalesProductsPage().GACProducts();*/
	private int ItemIncrement;
	private int i = 1;
	
	
 
			
			
			///////////////////////////////////////////////
			
			
			
			@Test(groups = {FunctionalCategory.ModelSales})
			public void verifyContractCreationForNewCustomers(){
				Report.createTestLogHeader("Model sales", "Verifying Contract creation for New Customers");
				int NoOfCombinations = 15;
				String combinations = "ServicesEmailNew";
				new ModelSalesAction("New","OutsideM25","NA")
				    .modelSalesFlow(NoOfCombinations,combinations);	    			
			}
			
			@Test(groups = {FunctionalCategory.ModelSales})
			public void verifyContractCreationForOAMCustomers(){
				Report.createTestLogHeader("Model sales", "Verifying Contract creation for HC 400 OAM - JCI OptIn Customers");
				final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
				int NoOfCombinations = 1;
				new HomePageAction()
				.navigateToLogin()
				.loginDetails(userProfile)
				.verifyLogin(userProfile.getLastName(),userProfile.getGasAccount());
				String combinations = "ServicesEmailNew";
				new ModelSalesAction("OAM","WithinM25","OptIn")
				    .modelSalesFlow(NoOfCombinations,combinations);	    			
			}
			
			
			@Test(groups = {FunctionalCategory.ModelSales})
			public void verifyPricingForNewCustomersTwoCombinations(){
				Report.createTestLogHeader("Model sales", "Verifying pricing for Two combination products");
				int NoOfCombinations = 20;
				String combinations = "TwoCombinationProducts";
				new ModelSalesAction("New","OutsideM25","NA")
				    .modelSalesPricingFlow(NoOfCombinations,combinations);	    			
			}
			
			
			@Test(groups = {FunctionalCategory.ModelSales})
			public void verifyPricingForNewCustomersThreeCombinations(){
				Report.createTestLogHeader("Model sales", "Verifying pricing for Two combination products");
				int NoOfCombinations = 10;
				String combinations = "ThreeCombinationProducts";
				new ModelSalesAction("New","WithinM25","NA")
				    .modelSalesPricingFlow(NoOfCombinations,combinations);	    			
			}
			
			@Test(groups = {FunctionalCategory.ModelSales})
			public void verifyPricingForNewCustomersFourCombinations(){
				Report.createTestLogHeader("Model sales", "Verifying pricing for Four combination products");
				int NoOfCombinations = 6;
				String combinations = "FourCombinationProducts";
				new ModelSalesAction("New","OutsideM25","NA")
				    .modelSalesPricingFlow(NoOfCombinations,combinations);	    			
			}
			
			@Test(groups = {FunctionalCategory.ModelSales})
			public void verifyPricingForNewCustomersFiveCombinations(){
				Report.createTestLogHeader("Model sales", "Verifying pricing for Five combination products");
				int NoOfCombinations = 5;
				String combinations = "FourCombinationProducts";
				new ModelSalesAction("New","OutsideM25","NA")
				    .modelSalesPricingFlow(NoOfCombinations,combinations);	    			
			}
			
			@Test(groups = {FunctionalCategory.ModelSales})
			public void verifyUddingstonJourney(){
				Report.createTestLogHeader("Model sales", "Verify uddingston journey - Energy and Service acquiring HC400 and BC");
				final UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare100Account");
				int NoOfCombinations = 1;
				String combinations = "ServicesEmailNew";
				new HomePageAction()
				.navigateToLogin()
				.loginDetails(userProfile)
				.verifyLogin(userProfile.getLastName(),userProfile.getGasAccount());
				new ModelSalesAction("OAM","WithinM25","NA")
				    .modelSalesFlow(NoOfCombinations,combinations);	    			
			}
			
			
			@Test(groups = {FunctionalCategory.ModelSales})
			public void verifyPricingforNewCustomerProducts(){
				Report.createTestLogHeader("Model sales journey", "Verifying pricing of Homecare Products - 2 Products Combinations - new customers");
				ModelSalesProducts modelSalesProducts = null;
				ModelSalesCombinationsProfile modelSales;
				while(new TestDataHelper().getModelSalesCombinationsProfile("ServicesEmailNew"+i).getProduct(1) != ""){
					 modelSales = new TestDataHelper().getModelSalesCombinationsProfile("ServicesEmailNew"+i);
						ItemIncrement = 1;
						while((modelSales.getProduct(ItemIncrement)) != ""){
							 modelSalesProducts = new TestDataHelper().getModelSalesProducts(modelSales.getProduct(ItemIncrement));
								System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhh" +modelSales.getProduct(ItemIncrement));
								new ModelSalesAction("New","WithinM25","NA")
								.navigateToProductsAndServicesPage()
								.selectingPackage(modelSalesProducts)
								.selectingProduct(modelSalesProducts)
								.navigateToGetAQuotePage()
								.selectingExcess(modelSalesProducts)
								.enteringBoilerDetails(modelSalesProducts)
								.selectingPaymentOption(modelSalesProducts,"AcceptChanges");
								ItemIncrement = ItemIncrement + 1;
								}
							 i++;
						}
						/*new ModelSalesAction("New","WithinM25","NA")
						.yourBasketPage()
						.yourDetailsPage("Same Addr")
						.yourPaymentsDetails(modelSalesProducts)
						.yourAccountSettingPage("OAMReg-OptIn")
						.reviewYourOrderPage()
						.confirmationPage();*/
				
			}
			
			@Test(groups = {FunctionalCategory.ModelSales})
			public void verifyOAMCustomerForExistingCustomer(){
				ModelSalesCombinationsProfile modelSales;
				ModelSalesProducts modelSalesProducts = null;
				Report.createTestLogHeader("Model sales", "Model sales journey through Esmart Acquisition");
				int NoOfCombinations = 10;
				String combinations = "ESProducts";
				String payment ="MDD";
				String postCode = "TS13 4HD";
				final PriceDetails getAPrice = new TestDataHelper().getPriceDetails("Anonymous");
				final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
				final EshopTariffProfile eshopTariff = new TestDataHelper().getEshopTariffProfile("Anonymous");
				final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
				for(int j = 3 ; j <= NoOfCombinations ; j++){
					modelSales = new TestDataHelper().getModelSalesCombinationsProfile(combinations+j);
					//new OnlineDBConnector().deRegisterAddress(postCode);
					new GetAQuoteActionNew("New","Gas","Anonymous")
					.navigateToGetAQuotePage()
					.enteringPostCode(postCode)
					.selectFuelType()
					.selectPaymentType(payment)
					.EnterDetails(getAPrice,"yes", "AnoyCust")
					.verifyQuoteResultPage();
					new EshopActionNew("Gas","Esmart","AnonymousCust","New")
					.selectTariff("Fix and Fall June 2016",eshopTariff)
					.fillOrderDetailsPage(acquisition)
					.JourneyType(payment, acquisition, userProfile)
					.verifyThankyouPage();
					new HomePageAction()
					.navigateToLogin()
					.loginWithEmailId();
					int ItemIncrement = 1;
					while((modelSales.getProduct(ItemIncrement)) != ""){
						modelSalesProducts = new TestDataHelper().getModelSalesProducts(modelSales.getProduct(ItemIncrement));
						new ModelSalesAction("OAM","OutsideM25","OptIn")
						.GAQWizardJourney(modelSalesProducts);
						ItemIncrement = ItemIncrement + 1;
					} 
					System.out.println("111111111111111111111111111111111111111111111111111" + ItemIncrement);
					new ModelSalesAction("OAM","OutsideM25","OptIn")
					.fulfillmentJourney(modelSalesProducts);
				}
			}
			
			
			@Test(groups = {FunctionalCategory.ModelSales})
			public void verifyWhetherOAMCustomerCanOptForServicesEmail(){
				Report.createTestLogHeader("Model sales", "Verifying Whether New customer can Sucessfully oPt for Services Email");
				int NoOfCombinations = 1;
				String combinations = "ServicesEmailNew";
				final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
				new HomePageAction()
				.navigateToLogin()
				.loginDetails(userProfile);
				//.verifyLogin(userProfile.getLastName(),userProfile.getGasAccount());
       			new ModelSalesAction("OAM","WithinM25","OptOut")
				    .modelSalesFlow(NoOfCombinations,combinations);
				   // .verifyingServicesEmail("OptIn");
			}
			
			
			@Test(groups = {FunctionalCategory.ModelSales})
			public void verifyWhetherOAMCustomerCreateContractSuccessfully(){
				Report.createTestLogHeader("Model sales", "Verifying Whether OAM customer can Sucessfully create contract");
				int NoOfCombinations = 1;
				String combinations = "ServicesEmailNew";
				final UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
				new HomePageAction()
				.navigateToLogin()
				.loginDetails(userProfile);
				//.verifyLogin(userProfile.getLastName(),userProfile.getGasAccount());
       			new ModelSalesAction("OAM","OutsideM25","OptOut")
				    .modelSalesFlow(NoOfCombinations,combinations);
				  //  .verifyingServicesEmail("OptIn");
			}
			


           ////////// Upgrade Scenarios //////////

			@Test(groups = {FunctionalCategory.ModelSales})
			public void upgradeHC200ToHC300(){
				Report.createTestLogHeader("Model sales journey", "Verify whether customer successfully upgrade from HC200 to HC300");
				final UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare200Account");
				String product = "Homecare300";
				new HomePageAction()
				.navigateToLogin()
				.loginDetails(userProfile)
				.verifyLogin(userProfile.getLastName(),userProfile.getAccNumber());
				new ModelSalesAction()
				.navigateToProductsAndServicesPage()
				.navigateToHomecare()
				.selectProductPage(product)
				.verifyUpgrade();
				new HomePageAction()
				.logout();
				
			}
			
			
			@Test(groups = {FunctionalCategory.ModelSales})
			public void upgradeHC300ToHC400(){
				Report.createTestLogHeader("Model sales journey", "Verify whether customer successfully upgrade from HC300 to HC400");
				final UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare300Account");
				String product = "Homecare400";
				new HomePageAction()
				.navigateToLogin()
				.loginDetails(userProfile)
				.verifyLogin(userProfile.getLastName(),userProfile.getAccNumber());
				new ModelSalesAction()
				.navigateToProductsAndServicesPage()
				.navigateToHomecare()
				.selectProductPage(product)
				.verifyUpgrade();
				new HomePageAction()
				.logout();
				
			}
			
			
			//////////// Downgrade Scenarios ////////////
			
			@Test(groups = {FunctionalCategory.ModelSales})
			public void downGradeHC200ToHC100(){
				Report.createTestLogHeader("Model sales journey", "Verify whether customer successfully downgrade from HC200 to HC100");
				final UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare200Account");
				String product = "Homecare100";
				new HomePageAction()
				.navigateToLogin()
				.loginDetails(userProfile)
				.verifyLogin(userProfile.getLastName(),userProfile.getAccNumber());
				new ModelSalesAction()
				.navigateToProductsAndServicesPage()
				.navigateToHomecare()
				.selectProductPage(product)
				.verifyAccountOverviewPage(userProfile);
				new HomePageAction()
				.logout();	
			}
			
			@Test(groups = {FunctionalCategory.ModelSales})
			public void downGradeHC300ToHC200(){
				Report.createTestLogHeader("Model sales journey", "Verify whether customer successfully downgrade from HC200 to HC100");
				final UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare300Account");
				String product = "Homecare200";
				new HomePageAction()
				.navigateToLogin()
				.loginDetails(userProfile)
				.verifyLogin(userProfile.getLastName(),userProfile.getAccNumber());
				new ModelSalesAction()
				.navigateToProductsAndServicesPage()
				.navigateToHomecare()
				.selectProductPage(product)
				.verifyAccountOverviewPage(userProfile);
				new HomePageAction()
				.logout();	
			}
			@Test(groups = {FunctionalCategory.ModelSales})
			public void downGradeHC300ToHC100(){
				Report.createTestLogHeader("Model sales journey", "Verify whether customer successfully downgrade from HC300 to HC100");
				final UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare300Account");
				String product = "Homecare100";
				new HomePageAction()
				.navigateToLogin()
				.loginDetails(userProfile)
				.verifyLogin(userProfile.getLastName(),userProfile.getAccNumber());
				new ModelSalesAction()
				.navigateToProductsAndServicesPage()
				.navigateToHomecare()
				.selectProductPage(product)
				.verifyAccountOverviewPage(userProfile);
				new HomePageAction()
				.logout();	
			}
			
			@Test(groups = {FunctionalCategory.ModelSales})
			public void downGradeHC400ToHC300(){
				Report.createTestLogHeader("Model sales journey", "Verify whether customer successfully downgrade from HC400 to HC300");
				final UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare400Account");
				String product = "Homecare300";
				new HomePageAction()
				.navigateToLogin()
				.loginDetails(userProfile)
				.verifyLogin(userProfile.getLastName(),userProfile.getAccNumber());
				new ModelSalesAction()
				.navigateToProductsAndServicesPage()
				.navigateToHomecare()
				.selectProductPage(product)
				.verifyAccountOverviewPage(userProfile);
				new HomePageAction()
				.logout();	
			}
			@Test(groups = {FunctionalCategory.ModelSales})
			public void downGradeHC400ToHC200(){
				Report.createTestLogHeader("Model sales journey", "Verify whether customer successfully downgrade from HC400 to HC200");
				final UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare400Account");
				String product = "Homecare200";
				new HomePageAction()
				.navigateToLogin()
				.loginDetails(userProfile)
				.verifyLogin(userProfile.getLastName(),userProfile.getAccNumber());
				new ModelSalesAction()
				.navigateToProductsAndServicesPage()
				.navigateToHomecare()
				.selectProductPage(product)
				.verifyAccountOverviewPage(userProfile);
				new HomePageAction()
				.logout();	
			}
			@Test(groups = {FunctionalCategory.ModelSales})
			public void downGradeHC400ToHC100(){
				Report.createTestLogHeader("Model sales journey", "Verify whether customer successfully downgrade from HC400 to HC100");
				final UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare400Account");
				String product = "Homecare100";
				new HomePageAction()
				.navigateToLogin()
				.loginDetails(userProfile)
				.verifyLogin(userProfile.getLastName(),userProfile.getAccNumber());
				new ModelSalesAction()
				.navigateToProductsAndServicesPage()
				.navigateToHomecare()
				.selectProductPage(product)
				.verifyAccountOverviewPage(userProfile);
				new HomePageAction()
				.logout();	
			}
			
			@Test(groups = {FunctionalCategory.ModelSales})
			public void downGradeHC200HC300ToHC100HC200(){
				Report.createTestLogHeader("Model sales journey", "Verify whether customer successfully downgrade from HC400 to HC100");
				final UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare200Account");
				String product = "Homecare100";
				String product1 = "Homecare200";
				new HomePageAction()
				.navigateToLogin()
				.loginDetails(userProfile)
				.verifyLogin(userProfile.getLastName(),userProfile.getAccNumber());
				new ModelSalesAction()
				.navigateToProductsAndServicesPage()
				.navigateToHomecare()
				.selectProductPage(product)
				.verifyAccountOverviewPage(userProfile)
				.navigateToProductsAndServicesPage()
				.changePremiseOfTheCustomer()
				.navigateToHomecare()
				.selectProductPage(product1)
				.verifyAccountOverviewPage(userProfile);
				new HomePageAction()
				.logout();	
			}
			
}

			
			
           




			

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	