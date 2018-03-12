package bg.framework.app.functional.test.sales;


import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.sales.AcquisitionAction;
import bg.framework.app.functional.action.sales.StandardTariffAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.FunctionalCategory;
import static bg.framework.app.functional.entities.FunctionalCategory.InProgress;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import static bg.framework.app.functional.entities.FunctionalCategory.Complex;
import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;



import static bg.framework.app.functional.entities.FunctionalCategory.Acquisition;


public class AcquisitionTest extends TestBase {
   
    
     @Test(groups = {FunctionalCategory.Acquisition,Regression,Smoke})     
     public void standardAcquisition(){
      	
      	 Report.createTestLogHeader("standardAcquisition", "Acquisition");
      	
      	  final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
          final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
      	
          new HomePageAction()      
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToStandardTariffPage()
          .navigateToDualOrderPage()
          .yourOrderAnonymousNavigation(acquisition, userProfile)
          .enterPersonalDetailsPage(acquisition, userProfile)
          .enterCurrentServices(acquisition)
          .QuarterlyCashCheque(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyLeadData()
          .domarssalesRunBatch(acquisition.getShopBatch())    
          .checkMediaCode(acquisition.getStandardCode())
          .backToHomePage()   
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToStandardTariffPage()
          .navigateToGasOrderPage()
          .yourOrderAnonymousNavigation(acquisition, userProfile)
          .enterPersonalDetailsPage(acquisition, userProfile)
          .gasPrepaymentCurrentServicesPageNavigation(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyLeadData()
          .domarssalesRunBatch(acquisition.getShopBatch())   
          .checkMediaCode(acquisition.getStandardCode())
          .backToHomePage()
          .navigateToProductsAndServicesPage()
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToStandardTariffPage()
          .navigateToElecOrderPage()
          .yourOrderAnonymousNavigation(acquisition, userProfile)
          .enterPersonalDetailsPage(acquisition, userProfile)
          .enterCurrentServices(acquisition)
          .enterPaymentOptions(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyLeadData()
          .domarssalesRunBatch(acquisition.getShopBatch()) 
          .checkMediaCode(acquisition.getStandardCode())   
          .backToHomePage();     
          
    }
     
     
     /*Execute in Fusion Site */
     
     @Test(groups = {FunctionalCategory.Acquisition,Regression})     
     public void standardAcquisitionFusion(){
      	
      	 Report.createTestLogHeader("standardAcquisition", "Acquisition Fusion Test");
      	
      	  final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
          final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
      	
          new HomePageAction()      
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToStandardTariffPage()
          .navigateToDualOrderPage()
          .yourOrderAnonymousNavigation(acquisition, userProfile)
          .enterPersonalDetailsPage(acquisition, userProfile)
          .enterCurrentServices(acquisition)
          .QuarterlyCashCheque(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyLeadData()
          .domarssalesRunBatch(acquisition.getShopBatch())    
          .checkMediaCode(acquisition.getStandardCode())
          .backToHomePage()   
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToStandardTariffPage()
          .navigateToGasOrderPage()
          .yourOrderAnonymousNavigation(acquisition, userProfile)
          .enterPersonalDetailsPage(acquisition, userProfile)
          .enterCurrentServices(acquisition)
          .enterPaymentOptions(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyLeadData()
          .domarssalesRunBatch(acquisition.getShopBatch())   
          .checkMediaCode(acquisition.getStandardCode())
          .backToHomePage()
          .navigateToProductsAndServicesPage()
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToStandardTariffPage()
          .navigateToElecOrderPage()
          .yourOrderAnonymousNavigation(acquisition, userProfile)
          .enterPersonalDetailsPage(acquisition, userProfile)
          .enterCurrentServices(acquisition)
          .enterPaymentOptions(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyLeadData()
          .domarssalesRunBatch(acquisition.getShopBatch()) 
          .checkMediaCode(acquisition.getStandardCode())   
          .backToHomePage();     
          
    }
    
     
    
     @Test(groups = {FunctionalCategory.Acquisition,Regression,Smoke})     
     public void onlineEnergyAcquisition(){
      	
      	 Report.createTestLogHeader("onlineEnergyAcquisition", "Acquisition");
      	
      	 final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
         final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
      	
          new HomePageAction()
          .navigateToProductsAndServicesPage()
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToOnlineEnergyTariffPage()
          .navigateToDualOrderPage()
          .yourOrderAnonymousNavigation(acquisition, userProfile)
          .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
          .gasDefaultCurrentServicesPageNavigation(acquisition)
          .enterPaymentOptions(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyLeadData()
          .domarssalesRunBatch(acquisition.getShopBatch())
          .checkMediaCode(acquisition.getDualonlineenergyTariffCode())
          .deleteWTP(userProfile)
          .backToHomePage()
          .navigateToProductsAndServicesPage()
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToOnlineEnergyTariffPage()
          .navigateToGasOrderPage()
      	  .yourOrderAnonymousNavigation(acquisition, userProfile)
      	  .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
          .gasDefaultCurrentServicesPageNavigation(acquisition)
          .enterPaymentOptions(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyLeadData()
          .domarssalesRunBatch(acquisition.getShopBatch())
          .checkMediaCode(acquisition.getGasonlineenergyTariffCode())
          .deleteWTP(userProfile)
          .backToHomePage()
          .navigateToProductsAndServicesPage()
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToOnlineEnergyTariffPage()
          .navigateToElecOrderPage()
      	  .yourOrderAnonymousNavigation(acquisition, userProfile)
      	  .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
          .gasDefaultCurrentServicesPageNavigation(acquisition)
          .enterPaymentOptions(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyLeadData()
          .domarssalesRunBatch(acquisition.getShopBatch())
          .checkMediaCode(acquisition.getEleconlineenergyTariffCode())
          .deleteWTP(userProfile);          
    }
     
     /*Execute in Fusion Site */
     
     @Test(groups = {FunctionalCategory.Acquisition,Regression})     
     public void onlineEnergyAcquisitionFusion(){
      	
      	 Report.createTestLogHeader("onlineEnergyAcquisition", "Acquisition");
      	
      	 final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
         final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
      	
          new HomePageAction()
          .navigateToProductsAndServicesPage()
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToOnlineEnergyTariffPage()
          .navigateToDualOrderPage()
          .yourOrderAnonymousNavigation(acquisition, userProfile)
          .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
          .gasDefaultCurrentServicesPageNavigation(acquisition)
          .enterPaymentOptions(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyLeadData()
          .domarssalesRunBatch(acquisition.getShopBatch())
          .checkMediaCode(acquisition.getDualonlineenergyTariffCode())
          .deleteWTP(userProfile)
          .backToHomePage()
          .navigateToProductsAndServicesPage()
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToOnlineEnergyTariffPage()
          .navigateToGasOrderPage()
      	  .yourOrderAnonymousNavigation(acquisition, userProfile)
      	  .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
          .gasDefaultCurrentServicesPageNavigation(acquisition)
          .enterPaymentOptions(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyLeadData()
          .domarssalesRunBatch(acquisition.getShopBatch())
          .checkMediaCode(acquisition.getGasonlineenergyTariffCode())
          .deleteWTP(userProfile)
          .backToHomePage()
          .navigateToProductsAndServicesPage()
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToOnlineEnergyTariffPage()
          .navigateToElecOrderPage()
      	  .yourOrderAnonymousNavigation(acquisition, userProfile)
      	  .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
          .gasDefaultCurrentServicesPageNavigation(acquisition)
          .enterPaymentOptions(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyLeadData()
          .domarssalesRunBatch(acquisition.getShopBatch())
          .checkMediaCode(acquisition.getEleconlineenergyTariffCode())
          .deleteWTP(userProfile);          
    }
    
    
     
     @Test(groups = {FunctionalCategory.Acquisition,Regression,Smoke})     
     public void fixedPriceJuneAcquisition(){
      	
      	  Report.createTestLogHeader("All Acquisition with Lead - Batch Test", "Print Lead Data");
      	
      	  final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
          final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
      	
          new HomePageAction()         
                  
          .navigateToProductsAndServicesPage()
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToFixedPriceMay2014()
          .navigateToGasOrderPage()
          .yourOrderAnonymousNavigation(acquisition, userProfile)
          .enterPersonalDetailsPage(acquisition, userProfile)
          .gasDefaultCurrentServicesPageNavigation(acquisition)
          .enterPaymentOptions(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyLeadData()
          .domarssalesRunBatch(acquisition.getShopBatch())         
          .backToHomePage()
          .navigateToProductsAndServicesPage()
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToFixedPriceMay2014()
          .navigateToElecOrderPage()
          .yourOrderAnonymousNavigation(acquisition, userProfile)
          .enterPersonalDetailsPage(acquisition, userProfile)
          .enterCurrentServices(acquisition)
          .QuarterlyCashCheque(acquisition)
          .verifyThankYouPage(userProfile)
          .verifyLeadData()
          .domarssalesRunBatch(acquisition.getShopBatch())      
          .backToHomePage();
    }

    
     @Test(groups = {FunctionalCategory.Acquisition,Regression,InProgress})   
     public void energyShareAcquisition(){
      	
      	  Report.createTestLogHeader("energyShareAcquisition", "Acquisition");    	
      	  final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
          final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
      	
          new HomePageAction()
                      
          .navigateToProductsAndServicesPage()
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToEnergyShareTariffPage()
          .navigateToElecOrderPage()
          .yourOrderAnonymousNavigation(acquisition, userProfile)
          .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
          .enterCurrentServices(acquisition)
          .enterPaymentOptions(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyLeadData()
          .domarssalesRunBatch(acquisition.getShopBatch())
          .deleteWTP(userProfile)
          .backToHomePage();
    }

   
    @Test(groups = {FunctionalCategory.Acquisition,Regression,InProgress})  
    public void energySharegasAcquisition(){
      	
     	 Report.createTestLogHeader("energyShareAcquisition", "Acquisition");
     	
     	 final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
         final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
         
         new HomePageAction()      
         .navigateToLogin()
         .login(userProfile)
         .navigateToProductAndServicesPage()
         .navigateToGasAndElectricityPage()
         .navigateToOurTariffsPage()
         .navigateToEnergyShareTariffPage()
         .navigateToElecOrderPage()
         .yourOrderGasBG(acquisition)
         .enterPersonalDetailsPage(acquisition, userProfile)
         .enterCurrentServices(acquisition)
         .enterPaymentOptions(acquisition)
         .reviewOrderPageNavigation()
         .verifyThankYouPage(userProfile)
         .verifyLeadData()
         .domarssalesRunBatch(acquisition.getShopBatch())
         .deleteWTP(userProfile)
         .logoutFromThankYouPage();
         
    }
    
    
    
    @Test(groups = {FunctionalCategory.Acquisition,Regression,InProgress})   
    public void energySharelecConversion(){
      	
     	 Report.createTestLogHeader("energyShareAcquisition", "Acquisition");
     	
     	 final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
         final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
         getCustomerDetailsToUserProfileOAM(userProfile);
         new HomePageAction()
         .navigateToLogin()
         .login(userProfile)
         .navigateToProductAndServicesPage()
         .navigateToGasAndElectricityPage()
         .navigateToOurTariffsPage()
         .navigateToEnergyShareTariffPage()
         .navigateToElecOrderPage()
         .yourOrderElecBG(acquisition)
         .reviewOrderPageNavigation()
         .verifyThankYouPage(userProfile)
         .verifyLeadData()
         .deleteWTP(userProfile)
         .logoutFromThankYouPage();
         
    }
         
    
   
    @Test(groups = {FunctionalCategory.Acquisition,Regression})
    public void gASConversionElectricityDualAcquisitionOnlineEnergyOAM() {
        Report.createTestLogHeader("AcquisitionConversion Test", "GASConversions Online Energy ElectricityDualAcquisitionOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToGasOrderPage()
                .yourOrderGasBG(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToDualOrderPage()
                .yourOrderGasBG(acquisition)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToElecOrderPage()
                .yourOrderGasBG(acquisition)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();

    }

    
        @Test(groups = {FunctionalCategory.Acquisition,Regression})

        public void gASConversionElectricityDualAcquisitionStandardOAM() {
            Report.createTestLogHeader("AcquisitionConversion Test", "GASConversions Standard ElectricityDualAcquisitionOAM");
            final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
            final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
            getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
                    
                    .navigateToLogin()
                    .login(userProfile)
                    .navigateToProductAndServicesPage()
                    .navigateToGasAndElectricityPage()
                    .navigateToOurTariffsPage()
                    .navigateToStandardTariffPage()
                    .navigateToGasOrderPage()
                    .yourOrderGasBG(acquisition)
                    .reviewOrderPageNavigation()
                    .verifyThankYouPage(userProfile)
                    .logoutFromThankYouPage()
                    .navigateToLogin()
                    .login(userProfile)
                    .navigateToProductAndServicesPage()
                    .navigateToGasAndElectricityPage()
                    .navigateToOurTariffsPage()
                    .navigateToStandardTariffPage()
                    .navigateToDualOrderPage()
                    .yourOrderGasBG(acquisition)
                    .enterPersonalDetailsPage(acquisition, userProfile)
                    .enterCurrentServices(acquisition)
                    .enterPaymentOptions(acquisition)
                    .reviewOrderPageNavigation()
                    .verifyThankYouPage(userProfile)
                    .logoutFromThankYouPage()
                    .navigateToLogin()
                    .login(userProfile)
                    .navigateToProductAndServicesPage()
                    .navigateToGasAndElectricityPage()
                    .navigateToOurTariffsPage()
                    .navigateToStandardTariffPage()
                    .navigateToElecOrderPage()
                    .yourOrderGasBG(acquisition)
                    .enterPersonalDetailsPage(acquisition, userProfile)
                    .enterCurrentServices(acquisition)
                    .enterPaymentOptions(acquisition)
                    .reviewOrderPageNavigation()
                    .verifyThankYouPage(userProfile)
                    .logoutFromThankYouPage();


        }

    
        @Test(groups = {FunctionalCategory.Acquisition,Regression})

        public void gASConversionElectricityDualAcquisitionFixedPriceJune2013TariffOAM() {
            Report.createTestLogHeader("AcquisitionConversion Test", "GASConversions FixedPriceJune2013Tariff ElectricityDualAcquisitionOAM");
            final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
            final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
            getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
                    .navigateToLogin()
                    .login(userProfile)
                    .navigateToProductAndServicesPage()
                    .navigateToGasAndElectricityPage()
                    .navigateToOurTariffsPage()
                    .navigateToFixedPriceMay2014()
                    .navigateToGasOrderPage()
                    .yourOrderGasBG(acquisition)
                    .reviewOrderPageNavigation()
                    .verifyThankYouPage(userProfile)
                    .logoutFromThankYouPage()
                    .navigateToLogin()
                    .login(userProfile)
                    .navigateToProductAndServicesPage()
                    .navigateToGasAndElectricityPage()
                    .navigateToOurTariffsPage()
                    .navigateToFixedPriceMay2014()
                    .navigateToDualOrderPage()
                    .yourOrderGasBG(acquisition)
                    .enterPersonalDetailsPage(acquisition, userProfile)
                    .enterCurrentServices(acquisition)
                    .enterPaymentOptions(acquisition)
                    .reviewOrderPageNavigation()
                    .verifyThankYouPage(userProfile)
                    .logoutFromThankYouPage()
                    .navigateToLogin()
                    .login(userProfile)
                    .navigateToProductAndServicesPage()
                    .navigateToGasAndElectricityPage()
                    .navigateToOurTariffsPage()
                    .navigateToFixedPriceMay2014()
                    .navigateToElecOrderPage()
                    .yourOrderGasBG(acquisition)
                    .enterPersonalDetailsPage(acquisition, userProfile)
                    .enterCurrentServices(acquisition)
                    .enterPaymentOptions(acquisition)
                    .reviewOrderPageNavigation()
                    .verifyThankYouPage(userProfile)
                    .logoutFromThankYouPage();


        }




    
    @Test(groups = {FunctionalCategory.Acquisition,Regression})

    public void gASConversionElectricityDualStandardAcquisitionForcedLogin() {
        Report.createTestLogHeader("AcquisitionConversion Test", "ForcedLoginGASConversionElectricityDualStandardAcquisitionOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        
        new HomePageAction()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToGasOrderPage()
                .forcedLoginYourOrderPage(acquisition,userProfile)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToDualOrderPage()
                .forcedLoginYourOrderPage(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToElecOrderPage()
                .forcedLoginYourOrderPage(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();


    }

   
    @Test(groups = {FunctionalCategory.Acquisition,Regression})

    public void gASConversionElectricityDualOnlineEnergyAcquisitionForcedLogin() {
        Report.createTestLogHeader("AcquisitionConversion Test", "ForcedLoginGASConversionElectricityDualOnlineEnergyAcquisitionOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToGasOrderPage()
                .forcedLoginYourOrderPage(acquisition,userProfile)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToDualOrderPage()
                .forcedLoginYourOrderPage(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToElecOrderPage()
                .forcedLoginYourOrderPage(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();


    }

    
    @Test(groups = {FunctionalCategory.Acquisition,Regression})

    public void gASConversionElectricityDualFixedPriceJune2013TariffAcquisitionForcedLogin() {
        Report.createTestLogHeader("AcquisitionConversion Test", "ForcedLoginGASConversionElectricityDualFixedPriceJune2013TariffAcquisitionOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToFixedPriceMay2014()
                .navigateToGasOrderPage()
                .forcedLoginYourOrderPage(acquisition,userProfile)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToFixedPriceMay2014()
                .navigateToDualOrderPage()
                .forcedLoginYourOrderPage(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToFixedPriceMay2014()
                .navigateToElecOrderPage()
                .forcedLoginYourOrderPage(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();


    }

     
    @Test(groups = {FunctionalCategory.Acquisition,Regression})

     public void electricityAllConversionOnlineEnergyGasAndDualAcquisition() {
        Report.createTestLogHeader("Acquisition Conversion Test", "ElectricityAllConversionOnlineEnergyGasDualAcquisitionOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("ElecConversion");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToElecOrderPage()
                .yourOrderElecBG(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToDualOrderPage()
                .yourOrderElecBG(acquisition)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToGasOrderPage()
                .yourOrderElecBG(acquisition)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();


    }

   
    
    @Test(groups = {FunctionalCategory.Acquisition,Regression})

    public void electricityAllConversionStandardGasAndDualAcquisition() {
        Report.createTestLogHeader("AcquisitionConversion Test", "ElectricityAllConversionStandardGasDualAcquisitionOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("ElecConversion");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        
        new HomePageAction()

                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToElecOrderPage()
                .yourOrderElecBG(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToDualOrderPage()
                .yourOrderElecBG(acquisition)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToGasOrderPage()
                .yourOrderElecBG(acquisition)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();


    }

    
    @Test(groups = {FunctionalCategory.Acquisition,Regression})

    public void electricityAllConversionFixedPriceJune2013TariffPageGasAndDualAcquisition() {
        Report.createTestLogHeader("AcquisitionConversion Test", "ElectricityAllConversionFixedPriceJune2013TariffPageGasDualAcquisitionOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("ElecConversion");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToElecOrderPage()
                .yourOrderElecBG(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToFixedPriceMay2014()
                .navigateToDualOrderPage()
                .yourOrderElecBG(acquisition)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToGasOrderPage()
                .yourOrderElecBG(acquisition)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();


    }

    
    @Test(groups = {FunctionalCategory.Acquisition,Regression})
    public void electricityAllConversionGasAndDualStandardAcquisitionForcedLogin() {
        Report.createTestLogHeader("AcquisitionConversion Scenario", "ForcedLoginElectricityConversionStandardGasDualAcquisitionOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("ElecConversion");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
          
        new HomePageAction()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToElecOrderPage()
                .forcedLoginYourOrderPage(acquisition,userProfile)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToDualOrderPage()
                .forcedLoginYourOrderPage(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToGasOrderPage()
                .forcedLoginYourOrderPage(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();


    }

    
    @Test(groups = {FunctionalCategory.Acquisition,Regression})
    public void electricityAllConversionGasAndDualOnlineEnergyAcquisitionForcedLogin() {
        Report.createTestLogHeader("AcquisitionConversion Scenario", "ForcedLoginElectricityConversionOnlineEnergyGasDualAcquisitionOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("ElecConversion");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToElecOrderPage()
                .forcedLoginYourOrderPage(acquisition,userProfile)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToDualOrderPage()
                .forcedLoginYourOrderPage(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToGasOrderPage()
                .forcedLoginYourOrderPage(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();


    }

    @Test(groups = {FunctionalCategory.Acquisition,Regression})
    public void ElectricityAllConversionGasAndDualFixedPriceJune2013TariffAcquisitionForcedLogin() {
        Report.createTestLogHeader("AcquisitionConversion Scenario", "ForcedLogin ElectricityConversion FixedPriceJune2013TariffGasDualAcquisitionOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("ElecConversion");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToFixedPriceMay2014()
                .navigateToElecOrderPage()
                .forcedLoginYourOrderPage(acquisition,userProfile)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToFixedPriceMay2014()
                .navigateToDualOrderPage()
                .forcedLoginYourOrderPage(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToFixedPriceMay2014()
                .navigateToGasOrderPage()
                .forcedLoginYourOrderPage(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();


    }
    
    
    
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Smoke})
    public void ConversionElecStandard() {

            Report.createTestLogHeader("Conversion Test", "ConversionElecStandard");
            final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
            final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
            getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
                    .navigateToLogin()
                    .login(userProfile)
                    .navigateToProductAndServicesPage()
                    .navigateToGasAndElectricityPage()
                    .navigateToOurTariffsPage()
                    .navigateToStandardTariffPage()
                    .navigateToElecOrderPage()
                    .yourOrderElecBG(acquisition)
                    .reviewOrderPageNavigation()
                    .verifyThankYouPage(userProfile)
                    .logoutFromThankYouPage();

        }
    
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Smoke})
    public void ConversionElecOnlineEnergy() {

                Report.createTestLogHeader("Conversion Test", "Conversion Elec OnlineEnergy");
                final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
                final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
                getCustomerDetailsToUserProfileOAM(userProfile);
                new HomePageAction()
                        .navigateToLogin()
                        .login(userProfile)
                        .navigateToProductAndServicesPage()
                        .navigateToGasAndElectricityPage()
                        .navigateToOurTariffsPage()
                        .navigateToOnlineEnergyTariffPage()
                        .navigateToElecOrderPage()
                        .yourOrderElecBG(acquisition)
                        .reviewOrderPageNavigation()
                        .verifyThankYouPage(userProfile)
                        .logoutFromThankYouPage();


            }
    
     @Test(groups = {FunctionalCategory.Acquisition,Regression,Smoke})
     public void ConversionElecFixedPriceJune2013TariffPage() {

                Report.createTestLogHeader("Conversion Test", "Conversion Elec FixedPriceJune2013TariffPage");
                final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
                final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
                getCustomerDetailsToUserProfileOAM(userProfile);
                new HomePageAction()
                        .navigateToLogin()
                        .login(userProfile)
                        .navigateToProductAndServicesPage()
                        .navigateToGasAndElectricityPage()
                        .navigateToOurTariffsPage()
                        .navigateToFixedPriceMay2014()
                        .navigateToElecOrderPage()
                        .yourOrderElecBG(acquisition)
                        .reviewOrderPageNavigation()
                        .verifyThankYouPage(userProfile)
                        .logoutFromThankYouPage();


            }
    
     @Test(groups = {FunctionalCategory.Acquisition,Regression,Smoke})
     public void ConversionGasStandard() {

            Report.createTestLogHeader("Conversion Test", "ConversionGasStandard");
            final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
            final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
            getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
                    .navigateToLogin()
                    .login(userProfile)
                    .navigateToProductAndServicesPage()
                    .navigateToGasAndElectricityPage()
                    .navigateToOurTariffsPage()
                    .navigateToStandardTariffPage()
                    .navigateToGasOrderPage()
                    .yourOrderGasBG(acquisition)
                    .reviewOrderPageNavigation()
                    .verifyThankYouPage(userProfile)
                    .verifyLeadData()           
                    .logoutFromThankYouPage();

        }
    
     @Test(groups = {FunctionalCategory.Acquisition,Regression,Smoke})
    public void ConversionGasOnlineEnergy() {

            Report.createTestLogHeader("Conversion Test", "ConversionGasOnlineEnergy");
            final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
            final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
            getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
                    .navigateToLogin()
                    .login(userProfile)
                    .navigateToProductAndServicesPage()
                    .navigateToGasAndElectricityPage()
                    .navigateToOurTariffsPage()
                    .navigateToOnlineEnergyTariffPage()
                    .navigateToGasOrderPage()
                    .yourOrderGasBG(acquisition)
                    .reviewOrderPageNavigation()
                    .verifyThankYouPage(userProfile)
                    .logoutFromThankYouPage();


        }
   
     @Test(groups = {FunctionalCategory.Acquisition,Regression,Smoke})
    public void ConversionGasFixedPriceJune2013TariffPage() {

            Report.createTestLogHeader("Conversion Test", "ConversionGasFixedPriceJune2013TariffPage");
            final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
            final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
            getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
            
                    .navigateToLogin()
                    .login(userProfile)
                    .navigateToProductAndServicesPage()
                    .navigateToGasAndElectricityPage()
                    .navigateToOurTariffsPage()
                    .navigateToFixedPriceMay2014()
                    .navigateToGasOrderPage()
                    .yourOrderGasBG(acquisition)
                    .reviewOrderPageNavigation()
                    .verifyThankYouPage(userProfile)
                    .verifyLeadData()
                    .changeTariff(userProfile.getGasAccount())
                    .logoutFromThankYouPage();


        }
   
     @Test(groups = {FunctionalCategory.Acquisition,Regression,Smoke})
    public void ConversionDualStandard() {

        Report.createTestLogHeader("Conversion Test", "DualConversionStandard");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToDualOrderPage()
                .yourOrderDualBG(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();


    }

   
     @Test(groups = {FunctionalCategory.Acquisition,Regression,Smoke})
     public void ConversionDualOnlineEnergy() {

        Report.createTestLogHeader("Conversion Test", "ConversionDualOnlineEnergy");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToDualOrderPage()
                .yourOrderDualBG(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();


    }

    
     @Test(groups = {FunctionalCategory.Acquisition,Regression,Smoke})
    public void ConversionDualFixedPriceJune2013TariffPage() {

        Report.createTestLogHeader("Conversion Test", "ConversionDualFixedPriceJune2013TariffPage");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToFixedPriceMay2014()
                .navigateToDualOrderPage()
                .yourOrderDualBG(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();


    }


     @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})

     public void sSOGasElecDualAcquisitionStandardTariff() {
        Report.createTestLogHeader("AcquisitionConversion Scenario", "SSOGasDualAcquisitionOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("ElecConversion");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("SSOAccount");
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToGasOrderPage()
                .yourOrderAnonymousNavigation(acquisition, userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToElecOrderPage()
                .yourOrderAnonymousNavigation(acquisition, userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToDualOrderPage()
                .yourOrderAnonymousNavigation(acquisition, userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();


    }

   
     @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})

     public void sSOGasElecDualAcquisitionFixedPriceJune2013Tariff() {
        Report.createTestLogHeader("AcquisitionConversion Scenario", "SSOGasDualFixedPriceJune2013AcquisitionOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("ElecConversion");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("SSOAccount");
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToFixedPriceMay2014()
                .navigateToGasOrderPage()
                .yourOrderAnonymousNavigation(acquisition, userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToFixedPriceMay2014()
                .navigateToElecOrderPage()
                .yourOrderAnonymousNavigation(acquisition, userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToFixedPriceMay2014()
                .navigateToDualOrderPage()
                .yourOrderAnonymousNavigation(acquisition, userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();


    }

   
     @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})

    public void sSOGasElecDualAcquisitionOETariff() {
        Report.createTestLogHeader("AcquisitionConversion Scenario", "SSOGasDualAcquisitionOnlineEnergyOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("ElecConversion");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("SSOAccount");
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToGasOrderPage()
                .yourOrderAnonymousNavigation(acquisition, userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToElecOrderPage()
                .yourOrderAnonymousNavigation(acquisition, userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToDualOrderPage()
                .yourOrderAnonymousNavigation(acquisition, userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();


    }

     @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})
    public void sSOGasElecDualEnergySmartAcquisition() {
        Report.createTestLogHeader("SSO EnergySmart Account Different supply Address Scenario", "Dual Acquisition-Gas Acquisition-Elec Acqusition");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("OAMHomeServicesAccount");
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToEnergySmartElectricityOrderPage()
                .energySmartAcquisitionYourOrderPage(acquisition,userProfile)
                .energySmartAddressSelection(acquisition)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToEnergySmartElectricityOrderPage()
                .energySmartAcquisitionYourOrderPage(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToDualOrderPage()
                .energySmartAcquisitionYourOrderPage(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();


    }
 
     
   /* Can Add - Journey ( Gas- Eligible for Energy Smart Customer - Who can Register for Energy Smart */
     
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})
    public void gasBgEnergySmartElectricityAcquisition() {
        Report.createTestLogHeader("Energy Smart Gas OAM Test", "Can Add Electricity Journey");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("EnergySmartCanAddGasAccount1");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToEnergySmartElectricityOrderPage()
                .yourOrderGasBG(acquisition)
                .gasBgEnergySmartElectricityAcquisition(acquisition)
                .enterCurrentServices(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage();
    }

    
    /* Can Add - Journey ( Gas- Eligible for Energy Smart Customer - Who can Register for Energy Smart */
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})

    public void gasBgEnergySmartDualOrder() {
        Report.createTestLogHeader("Energy Smart Gas OAM Test", "Can Add Dual Journey");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("EnergySmartCanAddGasAccount2");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToEnergySmartDualOrderPage()
                .yourOrderGasBG(acquisition)
                .gasBGEnergySmartDualOrder(acquisition)
                .enterCurrentServices(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage();
                

    }

    /* Can Add - Journey ( Gas- Eligible for Energy Smart Customer) - Who can Register for Energy Smart */
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})
    public void gasBgEnergySmartGasConversion() {
        Report.createTestLogHeader("Energy Smart Gas OAM Test", "Can Add Gas Journey");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("EnergySmartCanAddGasAccount3");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToEnergySmartGasOrderPage()
                .yourOrderGasBG(acquisition)
                .gasBGEnergySmartGasConversion(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();
    }

    /* Can Add - Journey ( Gas- Eligible for Energy Smart Customer) - Who can Register for Energy Smart */
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})
    public void elecBgEnergySmartElecConversion() {
        Report.createTestLogHeader("Energy Smart Elec OAM Test", "Can Add Elec Journey");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("EnergySmartCanAddElectricityAccount1");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToEnergySmartElectricityOrderPage()
                .yourOrderElecBG(acquisition)
                .elecBGEnergySmartElecConversion(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();
    }

    /* Can Add - Journey ( Electricity- Eligible for Energy Smart Customer) - Who can Register for Energy Smart */
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})

    public void elecBgEnergySmartDualOrder() {
        Report.createTestLogHeader("Energy Smart Elec OAM Test", "Can Add Dual Journey");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("EnergySmartCanAddElectricityAccount2");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToEnergySmartDualOrderPage()
                .yourOrderElecBG(acquisition)
                .elecBGEnergySmartDualOrder(acquisition)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();

    }

    /* Can Add - Journey ( Gas- Eligible for Energy Smart Customer) - Who can Register for Energy Smart */
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})

    public void elecBgEnergySmartGasAcquisition() {
        Report.createTestLogHeader("Energy Smart Elec OAM Test", "Can Add Gas Journey");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("EnergySmartCanAddElectricityAccount3");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToEnergySmartGasOrderPage()
                .yourOrderElecBG(acquisition)
                .elecBGEnergySmartGasAcquisition(acquisition)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();
    }
  
       
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Smoke})

    public void payAsYouGoAnonymous() {
        Report.createTestLogHeader("Acquisition Test", "Payge AnonymousJourney");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("Prepayment (SmartCard)");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
        new HomePageAction()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToPAYGTariffPage()
                .navigateToGasOrderPage()
                .payAsYouGoYourOrderDetails(acquisition)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .backToHomePage()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToPAYGTariffPage()
                .navigateToElecOrderPage()
                .payAsYouGoYourOrderDetails(acquisition)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .backToHomePage()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToPAYGTariffPage()
                .navigateToDualOrderPage()
                .payAsYouGoYourOrderDetails(acquisition)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .backToHomePage();

    }

   
    @Test(groups = {FunctionalCategory.Acquisition,Regression})

    public void payAsYouGoOAMGas() {
        
        Report.createTestLogHeader("PayAsYouGoEnergy gas Test", "OAMJourney");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("Prepayment (Smartkey)");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()

                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToPAYGTariffPage()
                .navigateToGasOrderPage()
                .payAsYouGoYourOrderDetails(acquisition)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage();


    }

    
    @Test(groups = {FunctionalCategory.Acquisition,Regression})

    public void payAsYouGoOAMElectricity() {
        Report.createTestLogHeader("PayAsYouGoEnergyElectricity Test", "OAMJourney");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("Prepayment (Token)");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()

                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToPAYGTariffPage()
                .navigateToElecOrderPage()
                .payAsYouGoYourOrderDetails(acquisition)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();


    }

   
    @Test(groups = {FunctionalCategory.Acquisition,Regression})

    public void payAsYouGoOAMDual() {
        Report.createTestLogHeader("PayAsYouGoEnergy Dual Test", "OAMJourney");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("Prepayment Economy 7 (Smartcard)");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()

                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToPAYGTariffPage()
                .navigateToDualOrderPage()
                .payAsYouGoYourOrderDetails(acquisition)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .payAsYouGoYourOrderDetails(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();

    }

   
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Smoke})
    public void energySmartStandardAcquisitionAnonymous() {
        Report.createTestLogHeader("Energy Smart Standard Tariff Acquisition Test", "AnonymousJourney");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("AnonymousESAcquisitionDual");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
         
        new HomePageAction()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToEnergySmartDualOrderPage()
                .energySmartAcquisitionYourOrderPage(acquisition,userProfile)
                .energySmartPersonalDetailsPage(acquisition)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .deleteWTP(userProfile)
                .domarssalesRunBatch(acquisition.getSmartBatch())
                .checkMediaCode(acquisition.getEnergySmartCode())
                .backToHomePage()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToEnergySmartGasOrderPage()
                .energySmartAcquisitionYourOrderPage(acquisition,userProfile)
                .energySmartPersonalDetailsPage(acquisition)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .deleteWTP(userProfile)
                .domarssalesRunBatch(acquisition.getSmartBatch())
                .checkMediaCode(acquisition.getEnergySmartCode())
                .backToHomePage()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToEnergySmartElectricityOrderPage()
                .energySmartAcquisitionYourOrderPage(acquisition,userProfile)
                .energySmartPersonalDetailsPage(acquisition)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .deleteWTP(userProfile)
                .domarssalesRunBatch(acquisition.getSmartBatch())
                .checkMediaCode(acquisition.getEnergySmartCode())
                .backToHomePage();
                
                

    }

   
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Smoke})
    public void energySmartOnlineEnergyAcquisitionAnonymous() {
        Report.createTestLogHeader("Energy Smart Online Energy Tariff Acquisition Test", "AnonymousJourney");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("AnonymousESAcquisitionDual");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
        new HomePageAction()
	        .navigateToProductsAndServicesPage()
	        .navigateToGasAndElectricityPage()
	        .navigateToOurTariffsPage()
	        .navigateToOnlineEnergyTariffPage()
	        .navigateToEnergySmartDualOrderPage()
	        .energySmartAcquisitionYourOrderPage(acquisition,userProfile)
	        .energySmartPersonalDetailsPage(acquisition)
	        .gasDefaultCurrentServicesPageNavigation(acquisition)
	        .enterPaymentOptions(acquisition)
	        .reviewOrderPageNavigation()
	        .verifyThankYouPage(userProfile)
	        .verifyLeadData()
	        .deleteWTP(userProfile)
	        .domarssalesRunBatch(acquisition.getSmartBatch())
            .checkMediaCode(acquisition.getEnergySmartCode())
	        .backToHomePage()
	        .navigateToProductsAndServicesPage()
	        .navigateToGasAndElectricityPage()
	        .navigateToOurTariffsPage()
	        .navigateToOnlineEnergyTariffPage()
	        .navigateToEnergySmartGasOrderPage()
	        .energySmartAcquisitionYourOrderPage(acquisition,userProfile)
	        .energySmartPersonalDetailsPage(acquisition)
	        .gasDefaultCurrentServicesPageNavigation(acquisition)
	        .enterPaymentOptions(acquisition)
	        .reviewOrderPageNavigation()
	        .verifyThankYouPage(userProfile)
	        .verifyLeadData()
	        .deleteWTP(userProfile)
	        .domarssalesRunBatch(acquisition.getSmartBatch())
            .checkMediaCode(acquisition.getEnergySmartCode())
	        .backToHomePage()
	        .navigateToProductsAndServicesPage()
	        .navigateToGasAndElectricityPage()
	        .navigateToOurTariffsPage()
	        .navigateToOnlineEnergyTariffPage()
	        .navigateToEnergySmartElectricityOrderPage()
	        .energySmartAcquisitionYourOrderPage(acquisition,userProfile)
	        .energySmartPersonalDetailsPage(acquisition)
	        .gasDefaultCurrentServicesPageNavigation(acquisition)
	        .enterPaymentOptions(acquisition)
	        .reviewOrderPageNavigation()
	        .verifyThankYouPage(userProfile)
	        .verifyLeadData()
	        .deleteWTP(userProfile)
	        .domarssalesRunBatch(acquisition.getSmartBatch())
            .checkMediaCode(acquisition.getEnergySmartCode())
	        .backToHomePage();
	


    }

    @Test(groups = {FunctionalCategory.Acquisition,Regression,Smoke})
    public void energySmartFixedPriceAcquisitionAnonymous() {
        Report.createTestLogHeader("Energy Smart Fixed Price Tariff Acquisition Test", "AnonymousJourney");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("AnonymousESAcquisitionDual");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
        new HomePageAction()
	        .navigateToProductsAndServicesPage()
	        .navigateToGasAndElectricityPage()
	        .navigateToOurTariffsPage()
	        .navigateToFixedPriceMay2014()
	        .navigateToEnergySmartDualOrderPage()
	        .energySmartAcquisitionYourOrderPage(acquisition,userProfile)
	        .energySmartPersonalDetailsPage(acquisition)
	        .gasDefaultCurrentServicesPageNavigation(acquisition)
	        .enterPaymentOptions(acquisition)
	        .reviewOrderPageNavigation()
	        .verifyThankYouPage(userProfile)
	        .verifyLeadData()
	        .deleteWTP(userProfile)
	        .domarssalesRunBatch(acquisition.getSmartBatch())
            .checkMediaCode(acquisition.getEnergySmartCode())
	        .backToHomePage()
	        .navigateToProductsAndServicesPage()
	        .navigateToGasAndElectricityPage()
	        .navigateToOurTariffsPage()
	        .navigateToFixedPriceMay2014()
	        .navigateToEnergySmartGasOrderPage()
	        .energySmartAcquisitionYourOrderPage(acquisition,userProfile)
	        .energySmartPersonalDetailsPage(acquisition)
	        .gasDefaultCurrentServicesPageNavigation(acquisition)
	        .enterPaymentOptions(acquisition)
	        .reviewOrderPageNavigation()
	        .verifyThankYouPage(userProfile)
	        .verifyLeadData()
	        .deleteWTP(userProfile)
	        .domarssalesRunBatch(acquisition.getSmartBatch())
            .checkMediaCode(acquisition.getEnergySmartCode())
	        .backToHomePage()
	        .navigateToProductsAndServicesPage()
	        .navigateToGasAndElectricityPage()
	        .navigateToOurTariffsPage()
	        .navigateToFixedPriceMay2014()
	        .navigateToEnergySmartElectricityOrderPage()
	        .energySmartAcquisitionYourOrderPage(acquisition,userProfile)
	        .energySmartPersonalDetailsPage(acquisition)
	        .gasDefaultCurrentServicesPageNavigation(acquisition)
	        .enterPaymentOptions(acquisition)
	        .reviewOrderPageNavigation()
	        .verifyThankYouPage(userProfile)
	        .verifyLeadData()
	        .deleteWTP(userProfile)
	        .domarssalesRunBatch(acquisition.getSmartBatch())
            .checkMediaCode(acquisition.getEnergySmartCode())
	        .backToHomePage();

    }
    
   

        
    @Test(groups = {FunctionalCategory.Acquisition,Regression})

    public void energySmartDifferentSupplyAddressElectricity() {
        Report.createTestLogHeader("Acquisition Test", "AnonymousJourney");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToEnergySmartDualOrderPage()
                .energySmartDifferentSupplyAddressElec(acquisition)
                .energySmartAddressSelection(acquisition)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToEnergySmartDualOrderPage()
                .energySmartDifferentSupplyAddressElec(acquisition)
                .energySmartAddressSelection(acquisition)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();


    }
   
    @Test(groups = {FunctionalCategory.Acquisition,Regression})
    public void energySmartDifferentSupplyAddressGas() {
        Report.createTestLogHeader("Energy Smart Test", "EnergySmartDifferentSupplyAddressGas");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToEnergySmartDualOrderPage()
                .energySmartDifferentSupplyAddressGas(acquisition)
                .energySmartAddressSelection(acquisition)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToEnergySmartDualOrderPage()
                .energySmartDifferentSupplyAddressGas(acquisition)
                .energySmartAddressSelection(acquisition)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();

    }

    /*IneligibleEnergySmartGas is mandatory*/
    
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})
    public void inEligibleEnergySmartGas() {
        Report.createTestLogHeader("EnergySmart Test", "InEligible for Energy Smart Gas Verification");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("IneligibleEnergySmartGas");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToEnergySmartDualOrderPage()
                .yourOrderGasBG(acquisition)
                .inEligibleEnergySmartMessage()
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToEnergySmartDualOrderPage()
                .yourOrderGasBG(acquisition)
                .inEligibleEnergySmartMessage()
                .logoutFromThankYouPage();


    }
    /*IneligibleEnergySmartElec is mandatory*/
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})

    public void inEligibleEnergySmartElectricity() {
        Report.createTestLogHeader("Energy Smart Test", "InEligible for Energy Smart Electricity Verification");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("IneligibleEnergySmartElec");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToEnergySmartDualOrderPage()
                .yourOrderElecBG(acquisition)
                .inEligibleEnergySmartMessage()
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToEnergySmartDualOrderPage()
                .yourOrderElecBG(acquisition)
                .inEligibleEnergySmartMessage()
                .logoutFromThankYouPage();


    }
    /*IneligibleEnergySmartDual is mandatory*/
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})

    public void inEligibleEnergySmartDual() {
        Report.createTestLogHeader("Acquisition Test", "AnonymousJourney");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("IneligibleEnergySmartDual");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToEnergySmartDualOrderPage()
                .yourOrderDualBG(acquisition)
                .inEligibleEnergySmartMessage();


    }

    /* Gas Already Registered with Energy Smart*/
    
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})
    public void energySmartGasConversions() {
        Report.createTestLogHeader("EnergySmart Test", "Conversion Journey All Tariffs");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("EnergySmartGas");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToEnergySmartDualOrderPage()
                .yourOrderGasBG(acquisition)
                .energySmartGasBGOrderDual(acquisition)
                .enterCurrentServices(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToEnergySmartGasOrderPage()
                .yourOrderGasBG(acquisition)
                .energySmartGasBGOrderGas(acquisition)
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToEnergySmartElectricityOrderPage()
                .yourOrderGasBG(acquisition)
                .energySmartGasBGOrderElec(acquisition)
                .enterCurrentServices(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage();


    }

    /* Electricity Already Registered with Energy Smart*/
    
    
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})
        public void energySmartElecConversions() {
            Report.createTestLogHeader("Energy Smart  Test", "energySmartElecConversions");
            final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
            final UserProfile userProfile = new TestDataHelper().getUserProfile("EnergySmartElec");
            getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
                    .navigateToLogin()
                    .login(userProfile)
                    .navigateToProductAndServicesPage()
                    .navigateToGasAndElectricityPage()
                    .navigateToOurTariffsPage()
                    .navigateToStandardTariffPage()
                    .navigateToEnergySmartDualOrderPage()
                    .yourOrderElecBG(acquisition)
                    .energySmartElecBGOrderDual(acquisition)
                    .gasDefaultCurrentServicesPageNavigation(acquisition)
                    .variableDirectDebitPayment(acquisition)
                    .reviewOrderPageNavigation()
                    .verifyThankYouPage(userProfile)
                    .verifyLeadData()
                    .logoutFromThankYouPage()
                    .navigateToLogin()
                    .login(userProfile)
                    .navigateToProductAndServicesPage()
                    .navigateToGasAndElectricityPage()
                    .navigateToOurTariffsPage()
                    .navigateToStandardTariffPage()
                    .navigateToEnergySmartElectricityOrderPage()
                    .yourOrderElecBG(acquisition)
                    .energySmartElecBGOrderElec(acquisition)
                    .verifyThankYouPage(userProfile)
                    .verifyLeadData()
                    .logoutFromThankYouPage()
                    .navigateToLogin()
                    .login(userProfile)
                    .navigateToProductAndServicesPage()
                    .navigateToGasAndElectricityPage()
                    .navigateToOurTariffsPage()
                    .navigateToStandardTariffPage()
                    .navigateToEnergySmartGasOrderPage()
                    .yourOrderElecBG(acquisition)
                    .energySmartElecBGOrderGas(acquisition)
                    .gasDefaultCurrentServicesPageNavigation(acquisition)
                    .variableDirectDebitPayment(acquisition)
                    .reviewOrderPageNavigation()
                    .verifyThankYouPage(userProfile)
                    .verifyLeadData()
                    .logoutFromThankYouPage();


        }

    /* Must change - Journey ( Gas- Web Saver customer is mandatory */
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})

    public void mustchangegasBgEnergySmartElectricityAcquisition() {
    	Report.createTestLogHeader(" Energy Smart Gas Journey", "Must change - Elec");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("MustchangeGas1");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToEnergySmartElectricityOrderPage()
                .yourOrderGasBG(acquisition)
                .gasBgEnergySmartElectricityAcquisition(acquisition)
                .enterCurrentServices(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();
    }

    /* Must change - Journey ( Gas- Web Saver customer is mandatory */
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})

    public void mustchangegasBgEnergySmartDualOrder() {
    	Report.createTestLogHeader(" Energy Smart Gas Journey", "Must change - Dual");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("MustchangeGas2");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToEnergySmartDualOrderPage()
                .yourOrderGasBG(acquisition)
                .gasBGEnergySmartDualOrder(acquisition)
                .enterCurrentServices(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();

    }

    /* Must change - Journey ( Gas- Web Saver customer is mandatory */
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})
    public void mustchangegasBgEnergySmartGasConversion() {
        Report.createTestLogHeader(" Energy Smart Gas Journey", "Must change - Gas");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("MustchangeGas3");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToEnergySmartGasOrderPage()
                .yourOrderGasBG(acquisition)
                .gasBGEnergySmartGasConversion(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();
    }

    /* Must change - Journey ( Elec- Web Saver customer is mandatory */
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})
    public void mustchangeelecBgEnergySmartElecConversion() {
    	Report.createTestLogHeader(" Energy Smart Electricity Journey", "Must change - Elec");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("MustchangeElec1");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToEnergySmartElectricityOrderPage()
                .yourOrderElecBG(acquisition)
                .elecBGEnergySmartElecConversion(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();
    }

    /* Must change - Journey ( Elec- Web Saver customer is mandatory */
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})
    public void mustchangeelecBgEnergySmartDualOrder() {
    	Report.createTestLogHeader(" Energy Smart Electricity Journey", "Must change - Dual");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("MustchangeElec2");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToEnergySmartDualOrderPage()
                .yourOrderElecBG(acquisition)
                .elecBGEnergySmartDualOrder(acquisition)
                .enterCurrentServices(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();

    }

    /* Must change - Journey ( Elec- Web Saver customer is mandatory */
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})

    public void mustchangeelecBgEnergySmartGasAcquisition() {
    	Report.createTestLogHeader(" Energy Smart Electricity Journey", "Must change - Gas");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("MustchangeElec3");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToEnergySmartElectricityOrderPage()
                .yourOrderElecBG(acquisition)
                .elecBGEnergySmartGasAcquisition(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();
    }
   
    
    
 
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})
    public void validateAcquisition() {


        Report.createTestLogHeader("AcquisitionConversion Test", "GASConversionElectricityDualAcquisitionOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("gas");
        getCustomerDetailsToUserProfileOAM(userProfile);

        new AcquisitionAction()
                .yourOrderAnonymousNavigation(acquisition, userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .validatePaymentOptions(acquisition)
                .enterPaymentOptions(acquisition)
                .validateReviewOrder()
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile);

    }
   
    /*Inprogress- Forced Registration*/
    
    @Test(groups = {FunctionalCategory.Acquisition,Regression,InProgress})

    public void gASConversionElectricityDualOnlineEnergyAcquisitionForcedRegistration() {
        Report.createTestLogHeader("AcquisitionConversion Test", "ForcedLoginGASConversionElectricityDualOnlineEnergyAcquisitionOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        new HomePageAction()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToGasOrderPage()
                .forcedRegistrationYourOrderPage(acquisition,userProfile)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToDualOrderPage()
                .forcedRegistrationYourOrderPage(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage()
                .navigateToProductsAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToElecOrderPage()
                .forcedLoginYourOrderPage(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();


    }

   
    @Test(groups = {FunctionalCategory.Acquisition,Regression})

    public void electricityAllConversionOnlineEnergyGasAndDualAcquisitionEE50() {
       Report.createTestLogHeader("AcquisitionConversion Test", "ElectricityAllConversionOnlineEnergyGasDualAcquisitionOAM");
       final Acquisition acquisition = new TestDataHelper().getAcquisitionData("ElecConversion");
       final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
       getCustomerDetailsToUserProfileOAM(userProfile);
       new HomePageAction()
              
               .navigateToLogin()
               .login(userProfile)
               .navigateToProductAndServicesPage()
               .navigateToGasAndElectricityPage()
               .navigateToOurTariffsPage()
               .navigateToOnlineEnergyTariffPage()
               .navigateToDualOrderPage()
               .yourOrderElecBG(acquisition)
               .enterPersonalDetailsPage(acquisition, userProfile)
               .gasDefaultCurrentServicesPageNavigation(acquisition)
               .enterPaymentOptionsEE50(acquisition)
               .reviewOrderPageNavigation()
               .verifyLeadData()
               .verifyThankYouPage(userProfile)
               .domarssalesRunBatch(acquisition.getShopBatch())
               .logoutFromThankYouPage()
               .navigateToLogin()
               .login(userProfile)
               .navigateToProductAndServicesPage()
               .navigateToGasAndElectricityPage()
               .navigateToOurTariffsPage()
               .navigateToOnlineEnergyTariffPage()
               .navigateToGasOrderPage()
               .yourOrderElecBG(acquisition)
               .enterPersonalDetailsPage(acquisition, userProfile)
               .gasDefaultCurrentServicesPageNavigation(acquisition)
               .enterPaymentOptionsEE50(acquisition)
               .reviewOrderPageNavigation()
               .verifyThankYouPage(userProfile)
               .logoutFromThankYouPage();


   }

  
    @Test(groups = {FunctionalCategory.Acquisition,Regression})

   public void electricityAllConversionStandardGasAndDualAcquisitionEE50() {
       Report.createTestLogHeader("AcquisitionConversion Test", "ElectricityAllConversionStandardGasDualAcquisitionOAM");
       final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
       final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
       getCustomerDetailsToUserProfileOAM(userProfile);
       
       new HomePageAction()
              
               .navigateToLogin()
               .login(userProfile)
               .navigateToProductAndServicesPage()
               .navigateToGasAndElectricityPage()
               .navigateToOurTariffsPage()
               .navigateToStandardTariffPage()
               .navigateToDualOrderPage()
               .yourOrderElecBG(acquisition)
               .enterPersonalDetailsPage(acquisition, userProfile)
               .enterCurrentServices(acquisition)
               .enterPaymentOptionsEE50(acquisition)
               .reviewOrderPageNavigation()
               .verifyThankYouPage(userProfile)
               .verifyLeadData()
               .domarssalesRunBatch(acquisition.getShopBatch())
               .logoutFromThankYouPage()
               .navigateToLogin()
               .login(userProfile)
               .navigateToProductAndServicesPage()
               .navigateToGasAndElectricityPage()
               .navigateToOurTariffsPage()
               .navigateToStandardTariffPage()
               .navigateToGasOrderPage()
               .yourOrderElecBG(acquisition)
               .enterPersonalDetailsPage(acquisition, userProfile)
               .enterCurrentServices(acquisition)
               .QuarterlyCashChequeEE50(acquisition)
               .reviewOrderPageNavigation()
               .verifyThankYouPage(userProfile)
               .logoutFromThankYouPage();


   }

   
   @Test(groups = {FunctionalCategory.Acquisition,Regression})

   public void electricityAllConversionFixedPriceJune2013TariffPageGasAndDualAcquisitionEE50() {
       Report.createTestLogHeader("AcquisitionConversion Test", "ElectricityAllConversionFixedPriceJune2013TariffPageGasDualAcquisitionOAM");
       final Acquisition acquisition = new TestDataHelper().getAcquisitionData("ElecConversion");
       final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
       getCustomerDetailsToUserProfileOAM(userProfile);
       new HomePageAction()
               .navigateToLogin()
               .login(userProfile)
               .navigateToProductAndServicesPage()
               .navigateToGasAndElectricityPage()
               .navigateToOurTariffsPage()
               .navigateToFixedPriceMay2014()
               .navigateToDualOrderPage()
               .yourOrderElecBG(acquisition)
               .enterPersonalDetailsPage(acquisition, userProfile)
               .enterCurrentServices(acquisition)
               .enterPaymentOptions(acquisition)
               .reviewOrderPageNavigation()
               .verifyThankYouPage(userProfile)
               .logoutFromThankYouPage()
               .navigateToLogin()
               .login(userProfile)
               .navigateToProductAndServicesPage()
               .navigateToGasAndElectricityPage()
               .navigateToOurTariffsPage()
               .navigateToOnlineEnergyTariffPage()
               .navigateToGasOrderPage()
               .yourOrderElecBG(acquisition)
               .enterPersonalDetailsPage(acquisition, userProfile)
               .gasDefaultCurrentServicesPageNavigation(acquisition)
               .enterPaymentOptions(acquisition)
               .reviewOrderPageNavigation()
               .verifyThankYouPage(userProfile)
               .logoutFromThankYouPage();

   }

   
    

    
   
    
    
}