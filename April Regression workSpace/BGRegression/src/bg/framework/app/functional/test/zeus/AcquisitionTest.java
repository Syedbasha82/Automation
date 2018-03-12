package bg.framework.app.functional.test.zeus;


import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.sales.AcquisitionAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.FunctionalCategory;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;

import static bg.framework.app.functional.entities.FunctionalCategory.*;


public class AcquisitionTest extends TestBase {

    
    
     @Test(groups = {FunctionalCategory.Acquisition})     
     public void  clearAndSimpleAcquisition(){
      	
      	 Report.createTestLogHeader("Clear And Simple Acquisition", "Dual , Gas , Electricity");
      	
      	  final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
          final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
      	
          new HomePageAction()
          
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToClearAndSimple()
          .navigateToDualOrderPage()
          .yourOrderAnonymousNavigation(acquisition, userProfile)
          .enterPersonalDetailsPage(acquisition, userProfile)
          .enterCurrentServices(acquisition)     
          .QuarterlyCashCheque(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyLeadData()
          .getLeadID()
          .domarssalesRunBatch(acquisition.getShopBatch())    
          .checkMediaCode(acquisition.getDualCsCode())
          .backToHomePage()
          
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToClearAndSimple()
          .navigateToGasOrderPage()
          .yourOrderAnonymousNavigation(acquisition, userProfile)
          .enterPersonalDetailsPage(acquisition, userProfile)
          .enterCurrentServices(acquisition)
          .enterPaymentOptions(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyLeadData()
          .getLeadID()
          .domarssalesRunBatch(acquisition.getShopBatch())    
          .checkMediaCode(acquisition.getGasCsCode())
          .backToHomePage()
         
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToClearAndSimple()
          .navigateToElecOrderPage()
          .yourOrderAnonymousNavigation(acquisition, userProfile)
          .enterPersonalDetailsPage(acquisition, userProfile)
          .enterCurrentServices(acquisition)
          .enterPaymentOptions(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyLeadData()
          .getLeadID()
          .domarssalesRunBatch(acquisition.getShopBatch()) 
          .checkMediaCode(acquisition.getElecCsCode())
          .backToHomePage();     
          
    }
    
    
    @Test(groups = {FunctionalCategory.Acquisition})    
    public void OnlineVariableAugust2013Acquisition(){
      	
      	 Report.createTestLogHeader("onlineVariableAugust2013", "Dual, Gas , Elec");
      	
      	 final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
         final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
      	
          new HomePageAction()
          
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToOnlineVariableAugust2013()
          .navigateToDualOrderPage()
          .yourOrderAnonymousNavigation(acquisition, userProfile)
          .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
          .gasDefaultCurrentServicesPageNavigation(acquisition)
          .enterPaymentOptions(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyLeadData()
          .getLeadID()
          .domarssalesRunBatch(acquisition.getShopBatch())
          .checkMediaCode(acquisition.getDualonlineenergyTariffCode())
          .deleteWTP(userProfile)
          .backToHomePage()
          
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToOnlineVariableAugust2013()
          .navigateToGasOrderPage()
      	  .yourOrderAnonymousNavigation(acquisition, userProfile)
      	  .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
          .gasDefaultCurrentServicesPageNavigation(acquisition)
          .enterPaymentOptions(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyLeadData()
          .getLeadID()
          .domarssalesRunBatch(acquisition.getShopBatch())
          .checkMediaCode(acquisition.getGasonlineenergyTariffCode())
          .deleteWTP(userProfile)
          .backToHomePage()
         
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToOnlineVariableAugust2013()
          .navigateToElecOrderPage()
      	  .yourOrderAnonymousNavigation(acquisition, userProfile)
      	  .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
          .gasDefaultCurrentServicesPageNavigation(acquisition)
          .enterPaymentOptions(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyLeadData()
          .getLeadID()
          .domarssalesRunBatch(acquisition.getShopBatch())
          .checkMediaCode(acquisition.getEleconlineenergyTariffCode())
          .deleteWTP(userProfile);          
    }

    
     @Test(groups = {FunctionalCategory.Acquisition})     
     public void fixedPriceMay2014Acquisition(){
      	
      	  Report.createTestLogHeader("Fixed Price May 2014", "Dual , Gas , Elec");
      	
      	  final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
          final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
      	
          new HomePageAction()         
                  
          
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
          .getLeadID()
          .domarssalesRunBatch(acquisition.getShopBatch())  
          .checkMediaCode(acquisition.getGasFP2013TariffCode())
          .backToHomePage()
          
          
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToFixedPriceMay2014()
          .navigateToElecOrderPage()
          .yourOrderAnonymousNavigation(acquisition, userProfile)
          .enterPersonalDetailsPage(acquisition, userProfile)
          .enterCurrentServices(acquisition)
          .QuarterlyCashCheque(acquisition)   
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyLeadData()
          .getLeadID()
          .domarssalesRunBatch(acquisition.getShopBatch()) 
          .checkMediaCode(acquisition.getElecFP2013TariffCode())
          .backToHomePage()
          
          
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToFixedPriceMay2014()
          .navigateToDualOrderPage()
          .yourOrderAnonymousNavigation(acquisition, userProfile)
          .enterPersonalDetailsPage(acquisition, userProfile)
          .enterCurrentServices(acquisition)
          .QuarterlyCashCheque(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyLeadData()
          .getLeadID()
          .domarssalesRunBatch(acquisition.getShopBatch()) 
          .checkMediaCode(acquisition.getDualFP2013TariffCode())
          .backToHomePage();
    }

     @Test(groups = {FunctionalCategory.Acquisition})     
     public void  clearAndSimpleEE50Acquisition(){
      	
      	 Report.createTestLogHeader("Clear And Simple EE50 Acquisition", " Dual , Gas , Electricity");
      	
      	  final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
          final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
      	
          new HomePageAction()
          
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToClearAndSimple()
          .navigateToDualOrderPage()
          .yourOrderAnonymousNavigation(acquisition, userProfile)
          .enterPersonalDetailsPage(acquisition, userProfile)
          .enterCurrentServices(acquisition)     
          .QuarterlyCashChequeEE50(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyLeadData()
          .getLeadID()
          .domarssalesRunBatch(acquisition.getShopBatch())    
          .checkMediaCode(acquisition.getStandardEE50Code())
          .backToHomePage()
          
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToClearAndSimple()
          .navigateToGasOrderPage()
          .yourOrderAnonymousNavigation(acquisition, userProfile)
          .enterPersonalDetailsPage(acquisition, userProfile)
          .enterCurrentServices(acquisition)
          .enterPaymentOptionsEE50(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyLeadData()
          .getLeadID()
          .domarssalesRunBatch(acquisition.getShopBatch())    
          .checkMediaCode(acquisition.getStandardEE50Code())
          .backToHomePage();
         
         
          
    }
    
     @Test(groups = {FunctionalCategory.Acquisition})    
     public void OnlineVariableAugust2013EE50Acquisition(){
       	
       	 Report.createTestLogHeader(" OnlineVariableAugust2013 EE50 Acquisitions", " Dual, Gas , Elec");
       	
       	  final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
          final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
       	
           new HomePageAction()
           
           .navigateToGasAndElectricityPage()
           .navigateToOurTariffsPage()
           .navigateToOnlineVariableAugust2013()
           .navigateToDualOrderPage()
           .yourOrderAnonymousNavigation(acquisition, userProfile)
           .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
           .gasDefaultCurrentServicesPageNavigation(acquisition)
           .enterPaymentOptionsEE50(acquisition)
           .reviewOrderPageNavigation()
           .verifyThankYouPage(userProfile)
           .verifyLeadData()
           .getLeadID()
           .domarssalesRunBatch(acquisition.getShopBatch())
           .checkMediaCode(acquisition.getStandardEE50Code())
           .deleteWTP(userProfile)
           .backToHomePage()
           
           .navigateToGasAndElectricityPage()
           .navigateToOurTariffsPage()
           .navigateToOnlineVariableAugust2013()
           .navigateToGasOrderPage()
       	   .yourOrderAnonymousNavigation(acquisition, userProfile)
       	   .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
           .gasDefaultCurrentServicesPageNavigation(acquisition)
           .enterPaymentOptionsEE50(acquisition)
           .reviewOrderPageNavigation()
           .verifyThankYouPage(userProfile)
           .verifyLeadData()
           .getLeadID()
           .domarssalesRunBatch(acquisition.getShopBatch())
           .checkMediaCode(acquisition.getStandardEE50Code())
           .deleteWTP(userProfile)
           .backToHomePage();
               
     }


     @Test(groups = {FunctionalCategory.Acquisition})     
     public void fixedPriceMay2014EE50Acquisition(){
      	
      	  Report.createTestLogHeader("Fixed Price May 2014 EE50 Acquisitions", "Fuel Type  Dual , Gas , Elec");
      	
      	  final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
          final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
      	
          new HomePageAction()         
                  
          
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToFixedPriceMay2014()
          .navigateToGasOrderPage()
          .yourOrderAnonymousNavigation(acquisition, userProfile)
          .enterPersonalDetailsPage(acquisition, userProfile)
          .gasDefaultCurrentServicesPageNavigation(acquisition)
          .enterPaymentOptionsEE50(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyLeadData()
          .getLeadID()
          .domarssalesRunBatch(acquisition.getShopBatch())   
          .checkMediaCode(acquisition.getStandardEE50Code())
          .backToHomePage()
          
          
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToFixedPriceMay2014()
          .navigateToElecOrderPage()
          .yourOrderAnonymousNavigation(acquisition, userProfile)
          .enterPersonalDetailsPage(acquisition, userProfile)
          .enterCurrentServices(acquisition)
          .QuarterlyCashChequeEE50(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyLeadData()
          .getLeadID()
          .domarssalesRunBatch(acquisition.getShopBatch())  
          .checkMediaCode(acquisition.getStandardEE50Code())
          .backToHomePage();
          
          
         
    }


     
     
    @Test(groups = {FunctionalCategory.Acquisition})
    public void gasOAMElectricityDualAcquisitionOVA2013() {
        Report.createTestLogHeader("AcquisitionConversion Test", " OnlineVariableAugust2013 ElectricityDualAcquisitionOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                
                .navigateToLogin()
                .login(userProfile)
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineVariableAugust2013()
                .navigateToDualOrderPage()
                .yourOrderGasBG(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .domarssalesRunBatch(acquisition.getShopBatch())     
                .checkMediaCode(acquisition.getEleconlineenergyTariffCode())              
                .logoutFromThankYouPage()
                
                
                .navigateToLogin()
                .login(userProfile)                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineVariableAugust2013()
                .navigateToElecOrderPage()
                .yourOrderGasBG(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .domarssalesRunBatch(acquisition.getShopBatch())     
                .checkMediaCode(acquisition.getEleconlineenergyTariffCode())
                .logoutFromThankYouPage();

    }

    
     @Test(groups = {FunctionalCategory.Acquisition})

        public void gasOAMElectricityDualAcquisitionClearAndSimpleOAM() {
            Report.createTestLogHeader("AcquisitionConversion Test", " ClearAndSimple Electricity Dual AcquisitionOAM");
            final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
            final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
            getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
                               
                    .navigateToLogin()
                    .login(userProfile)                   
                    .navigateToGasAndElectricityPage()
                    .navigateToOurTariffsPage()
                    .navigateToClearAndSimple()
                    .navigateToDualOrderPage()
                    .yourOrderGasBG(acquisition,userProfile)
                    .enterPersonalDetailsPage(acquisition, userProfile)
                    .enterCurrentServices(acquisition)
                    .enterPaymentOptions(acquisition)
                    .reviewOrderPageNavigation()
                    .verifyThankYouPage(userProfile)
                    .verifyLeadData() 
                    .getLeadID()
                    .domarssalesRunBatch(acquisition.getShopBatch())     
                    .checkMediaCode(acquisition.getElecCsCode())
                    .logoutFromThankYouPage()
                    
                    
                    .navigateToLogin()
                    .login(userProfile)                    
                    .navigateToGasAndElectricityPage()
                    .navigateToOurTariffsPage()
                    .navigateToClearAndSimple()
                    .navigateToElecOrderPage()
                    .yourOrderGasBG(acquisition,userProfile)
                    .enterPersonalDetailsPage(acquisition, userProfile)
                    .enterCurrentServices(acquisition)
                    .enterPaymentOptions(acquisition)
                    .reviewOrderPageNavigation()
                    .verifyThankYouPage(userProfile)
                    .verifyLeadData()
                    .getLeadID()
                    .domarssalesRunBatch(acquisition.getShopBatch())     
                    .checkMediaCode(acquisition.getElecCsCode())
                    .logoutFromThankYouPage();


        }

    
    @Test(groups = {FunctionalCategory.Acquisition})
    public void gASOAMElectricityDualAcquisitionFixedPriceMay2014Tariff() {
            Report.createTestLogHeader("AcquisitionConversion Test", " FixedPriceMay2014Tariff ElectricityDualAcquisitionOAM");
            final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
            final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
            getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
                   
                    .navigateToLogin()
                    .login(userProfile)                   
                    .navigateToGasAndElectricityPage()
                    .navigateToOurTariffsPage()
                    .navigateToFixedPriceMay2014()
                    .navigateToDualOrderPage()
                    .yourOrderGasBG(acquisition,userProfile)
                    .enterPersonalDetailsPage(acquisition, userProfile)
                    .enterCurrentServices(acquisition)
                    .enterPaymentOptions(acquisition)
                    .reviewOrderPageNavigation()
                    .verifyThankYouPage(userProfile)
                    .verifyLeadData()    
                    .getLeadID()
                    .domarssalesRunBatch(acquisition.getShopBatch())   
                    .checkMediaCode(acquisition.getElecFP2013TariffCode())
                    .logoutFromThankYouPage()
                    
                    .navigateToLogin()
                    .login(userProfile)                    
                    .navigateToGasAndElectricityPage()
                    .navigateToOurTariffsPage()
                    .navigateToFixedPriceMay2014()
                    .navigateToElecOrderPage()
                    .yourOrderGasBG(acquisition,userProfile)
                    .enterPersonalDetailsPage(acquisition, userProfile)
                    .enterCurrentServices(acquisition)
                    .enterPaymentOptions(acquisition)
                    .reviewOrderPageNavigation()
                    .verifyThankYouPage(userProfile)
                    .verifyLeadData()
                    .getLeadID()
                    .domarssalesRunBatch(acquisition.getShopBatch())     
                    .checkMediaCode(acquisition.getElecFP2013TariffCode())
                    .logoutFromThankYouPage();


        }




    
    @Test(groups = {FunctionalCategory.Acquisition})
    
    public void gasOAMElectricityDualClearAndSimpleAcquisitionForcedLogin() {
        Report.createTestLogHeader("AcquisitionConversion Test", "ForcedLoginGASConversionElectricityDualClearAndSimpleAcquisitionOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        
        new HomePageAction()
                
                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToDualOrderPage()
                .forcedLoginYourOrderPage(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()           
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .domarssalesRunBatch(acquisition.getShopBatch())     
                .checkMediaCode(acquisition.getElecCsCode())
                
                
                .logoutFromThankYouPage()                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToElecOrderPage()
                .forcedLoginYourOrderPage(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .domarssalesRunBatch(acquisition.getShopBatch())     
                .checkMediaCode(acquisition.getElecCsCode())
                .logoutFromThankYouPage();


    }

   
    @Test(groups = {FunctionalCategory.Acquisition})

    public void electricityDualOVA2013AcquisitionForcedLogin() {
        Report.createTestLogHeader("AcquisitionConversion Test", "ForcedLoginGASConversionElectricityDualOnlineEnergyAcquisitionOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                
                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineVariableAugust2013()
                .navigateToDualOrderPage()
                .forcedLoginYourOrderPage(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .domarssalesRunBatch(acquisition.getShopBatch())     
                .checkMediaCode(acquisition.getEleconlineenergyTariffCode())
                .logoutFromThankYouPage()
                
                
                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineVariableAugust2013()
                .navigateToElecOrderPage()
                .forcedLoginYourOrderPage(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .domarssalesRunBatch(acquisition.getShopBatch())     
                .checkMediaCode(acquisition.getEleconlineenergyTariffCode())
                .logoutFromThankYouPage();


    }

    
    @Test(groups = {FunctionalCategory.Acquisition})

    public void electricityDualFPM2014AcquisitionForcedLogin() {
        Report.createTestLogHeader("AcquisitionConversion Test", "ForcedLoginGASConversionElectricityDualFixedPriceMay2014TariffAcquisitionOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
               
                
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
                .verifyLeadData()
                .domarssalesRunBatch(acquisition.getShopBatch())     
                .checkMediaCode(acquisition.getElecFP2013TariffCode())
                .logoutFromThankYouPage()
                
                
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
                .verifyLeadData()
                .domarssalesRunBatch(acquisition.getShopBatch())     
                .checkMediaCode(acquisition.getElecFP2013TariffCode())
                .logoutFromThankYouPage();


    }

     
     @Test(groups = {FunctionalCategory.Acquisition})

     public void OVA2013GasAndDualAcquisition() {
        Report.createTestLogHeader("AcquisitionConversion Test", "Elec Oam OnlineVariableAugust2013GasDualAcquisitionOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
               
               
                .navigateToLogin()
                .login(userProfile)               
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineVariableAugust2013()
                .navigateToDualOrderPage()
                .yourOrderElecBG(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .domarssalesRunBatch(acquisition.getShopBatch())     
                .checkMediaCode(acquisition.getGasonlineenergyTariffCode())
                .logoutFromThankYouPage()
                
                
                .navigateToLogin()
                .login(userProfile)              
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineVariableAugust2013()
                .navigateToGasOrderPage()
                .yourOrderElecBG(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .domarssalesRunBatch(acquisition.getShopBatch())     
                .checkMediaCode(acquisition.getGasonlineenergyTariffCode())
                .logoutFromThankYouPage();


    }

   
    
    @Test(groups = {FunctionalCategory.Acquisition})

    public void ClearAndSimpleGasAndDualAcquisition() {
        Report.createTestLogHeader("AcquisitionConversion Test", "ClearAndSimpleGasDualAcquisitionOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        
        new HomePageAction()

                
                .navigateToLogin()
                .login(userProfile)                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToDualOrderPage()
                .yourOrderElecBG(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .domarssalesRunBatch(acquisition.getShopBatch())     
                .checkMediaCode(acquisition.getGasCsCode())
                .logoutFromThankYouPage()
                
                
                .navigateToLogin()
                .login(userProfile)               
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToGasOrderPage()
                .yourOrderElecBG(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .domarssalesRunBatch(acquisition.getShopBatch())     
                .checkMediaCode(acquisition.getGasCsCode())
                .logoutFromThankYouPage();


    }

    
    @Test(groups = {FunctionalCategory.Acquisition})

    public void FixedPriceJune2014GasAndDualAcquisition() {
        Report.createTestLogHeader("AcquisitionConversion Test", "FixedPriceMay2014TariffPageGasDualAcquisitionOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                
                .navigateToLogin()
                .login(userProfile)                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToFixedPriceMay2014()
                .navigateToDualOrderPage()
                .yourOrderElecBG(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .domarssalesRunBatch(acquisition.getShopBatch())     
                .checkMediaCode(acquisition.getGasFP2013TariffCode())
                .logoutFromThankYouPage()
                
                
                
                .navigateToLogin()
                .login(userProfile)                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToFixedPriceMay2014()
                .navigateToGasOrderPage()
                .yourOrderElecBG(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .domarssalesRunBatch(acquisition.getShopBatch())     
                .checkMediaCode(acquisition.getGasFP2013TariffCode())
                .logoutFromThankYouPage();


    }

    
    @Test(groups = {Acquisition, BG})
  
    public void GasAndDualClearAndSimpleAcquisitionForcedLogin() {
        Report.createTestLogHeader("AcquisitionConversion Scenario", "ForcedLoginElec OAM ClearAndSimpleGasDualAcquisitionOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
          
        new HomePageAction()
                
                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToDualOrderPage()
                .forcedLoginYourOrderPage(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .domarssalesRunBatch(acquisition.getShopBatch())     
                .checkMediaCode(acquisition.getDualCsCode())
                .logoutFromThankYouPage()
                
                
                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToGasOrderPage()
                .forcedLoginYourOrderPage(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .domarssalesRunBatch(acquisition.getShopBatch())     
                .checkMediaCode(acquisition.getGasCsCode())
                .logoutFromThankYouPage();


    }

    
    @Test(groups = {Acquisition, BG})

    public void GasAndDualOnlineEnergyAcquisitionForcedLogin() {
        Report.createTestLogHeader("AcquisitionConversion Scenario", "ForcedLoginElectricityConversionOnlineEnergyGasDualAcquisitionOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
               
                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineVariableAugust2013()
                .navigateToDualOrderPage()
                .forcedLoginYourOrderPage(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .domarssalesRunBatch(acquisition.getShopBatch())     
                .checkMediaCode(acquisition.getDualonlineenergyTariffCode())
                .logoutFromThankYouPage()
                
                
                
                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineVariableAugust2013()
                .navigateToGasOrderPage()
                .forcedLoginYourOrderPage(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .domarssalesRunBatch(acquisition.getShopBatch())     
                .checkMediaCode(acquisition.getGasonlineenergyTariffCode())
                .logoutFromThankYouPage();


    }

   
    @Test(groups = {Acquisition, BG})

    public void GasAndDualFixedPriceMay2014TariffAcquisitionForcedLogin() {
        Report.createTestLogHeader("AcquisitionConversion Scenario", "ForcedLoginElectricityConversionFixedPriceMay2014TariffGasDualAcquisitionOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
               
                
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
                .verifyLeadData()
                .domarssalesRunBatch(acquisition.getShopBatch())     
                .checkMediaCode(acquisition.getDualFP2013TariffCode())                          
                .logoutFromThankYouPage()
                
                
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
                .verifyLeadData()
                .domarssalesRunBatch(acquisition.getShopBatch())     
                .checkMediaCode(acquisition.getGasFP2013TariffCode())
                .logoutFromThankYouPage();


    }
    
    
    
    
    @Test(groups = {Acquisition, BG})

    public void sSOGasElecDualAcquisitionClearAndSimpleTariff() {
        Report.createTestLogHeader("Acquisition ClearAndSimple Scenario", "SSOGasDualAcquisitionOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("ElecConversion");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("HomeSerivcesAccount");
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToGasOrderPage()
                .yourOrderAnonymousNavigation(acquisition, userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToElecOrderPage()
                .yourOrderAnonymousNavigation(acquisition, userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                 .navigateToClearAndSimple()
                .navigateToDualOrderPage()
                .yourOrderAnonymousNavigation(acquisition, userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .logoutFromThankYouPage();


    }

   
    @Test(groups = {Acquisition, BG})

    public void sSOGasElecDualAcquisitionFixedPriceMay2014Tariff() {
        Report.createTestLogHeader("Acquisition Scenario", "SSOGasDualFixedPriceMay2014AcquisitionOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("ElecConversion");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("HomeSerivcesAccount");
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)               
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
                .verifyLeadData()
                .getLeadID()
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                
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
                .verifyLeadData()
                .getLeadID()
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                
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
                .verifyLeadData()
                .getLeadID()
                .logoutFromThankYouPage();


    }

   
   @Test(groups = {Acquisition, BG})

    public void sSOGasElecDualAcquisitionOETariff() {
        Report.createTestLogHeader("AcquisitionConversion Scenario", "SSOGasDualAcquisitionOVA2013OAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("ElecConversion");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("HomeSerivcesAccount");
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)               
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineVariableAugust2013()
                .navigateToGasOrderPage()
                .yourOrderAnonymousNavigation(acquisition, userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineVariableAugust2013()
                .navigateToElecOrderPage()
                .yourOrderAnonymousNavigation(acquisition, userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineVariableAugust2013()
                .navigateToDualOrderPage()
                .yourOrderAnonymousNavigation(acquisition, userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .logoutFromThankYouPage();


    }


    @Test(groups = {Acquisition, BG})
    public void sSOGasElecDualEnergySmartAcquisition() {
        Report.createTestLogHeader("SSO EnergySmart Account Different supply Address Scenario", "Dual Acquisition-Gas Acquisition-Elec Acqusition");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("OAMHomeServicesAccount");
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)               
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
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
                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
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
                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToDualOrderPage()
                .energySmartAcquisitionYourOrderPage(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();


    }
    
          
      
       
    @Test(groups = {Acquisition, BG})

    public void payAsYouGoAnonymous() {
        Report.createTestLogHeader("Acquisition Test", "PAYGE Journey");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("Prepayment (SmartCard)");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
        new HomePageAction()
                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToPAYGTariffPage()
                .navigateToGasOrderPage()
                .payAsYouGoYourOrderDetails(acquisition)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .backToHomePage()
                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToPAYGTariffPage()
                .navigateToElecOrderPage()
                .payAsYouGoYourOrderDetails(acquisition)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .backToHomePage()
                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToPAYGTariffPage()
                .navigateToDualOrderPage()
                .payAsYouGoYourOrderDetails(acquisition)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .backToHomePage();
    }

   
    @Test(groups = {Acquisition, BG})
    public void payAsYouGoOAMGas() {
        
        Report.createTestLogHeader("PayAsYouGoEnergy gas Test", "OAMJourney");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("Prepayment (Smartkey)");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()

                .navigateToLogin()
                .login(userProfile)                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToPAYGTariffPage()
                .navigateToGasOrderPage()
                .payAsYouGoYourOrderDetails(acquisition)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .logoutFromThankYouPage();
    }

    
    @Test(groups = {Acquisition, BG})
    public void payAsYouGoOAMElectricity() {
        Report.createTestLogHeader("PayAsYouGoEnergyElectricity Test", "OAMJourney");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("Prepayment (Token)");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()

                .navigateToLogin()
                .login(userProfile)               
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToPAYGTariffPage()
                .navigateToElecOrderPage()
                .payAsYouGoYourOrderDetails(acquisition)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .logoutFromThankYouPage();
    }

   
    @Test(groups = {Acquisition, BG})
    public void payAsYouGoOAMDual() {
        Report.createTestLogHeader("PayAsYouGoEnergy Dual Test", "OAMJourney");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("Prepayment Economy 7 (Smartcard)");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("dual");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()

                .navigateToLogin()
                .login(userProfile)              
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToPAYGTariffPage()
                .navigateToDualOrderPage()
                .payAsYouGoYourOrderDetails(acquisition)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .payAsYouGoYourOrderDetails(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .logoutFromThankYouPage();
    }

   

   
    @Test(groups = {FunctionalCategory.Acquisition})
    public void oVA2013GasAndDualAcquisitionEE50() {
       Report.createTestLogHeader("AcquisitionConversion Test", "ElectricityAllConversionOnlineEnergyGasDualAcquisitionOAM");
       final Acquisition acquisition = new TestDataHelper().getAcquisitionData("ElecConversion");
       final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
       getCustomerDetailsToUserProfileOAM(userProfile);
       new HomePageAction()
              
               .navigateToLogin()
               .login(userProfile)              
               .navigateToGasAndElectricityPage()
               .navigateToOurTariffsPage()
               .navigateToOnlineVariableAugust2013()
               .navigateToDualOrderPage()
               .yourOrderElecBG(acquisition,userProfile)
               .enterPersonalDetailsPage(acquisition, userProfile)
               .gasDefaultCurrentServicesPageNavigation(acquisition)
               .enterPaymentOptionsEE50(acquisition)
               .reviewOrderPageNavigation()
               .verifyThankYouPage(userProfile)
               .verifyLeadData()
               .getLeadID()
               .verifyThankYouPage(userProfile)
               .domarssalesRunBatch(acquisition.getShopBatch())
               .logoutFromThankYouPage()
   
               .navigateToLogin()
               .login(userProfile)               
               .navigateToGasAndElectricityPage()
               .navigateToOurTariffsPage()
               .navigateToOnlineVariableAugust2013()
               .navigateToGasOrderPage()
               .yourOrderElecBG(acquisition,userProfile)
               .enterPersonalDetailsPage(acquisition, userProfile)
               .gasDefaultCurrentServicesPageNavigation(acquisition)
               .enterPaymentOptionsEE50(acquisition)
               .reviewOrderPageNavigation()
               .verifyThankYouPage(userProfile)
               .verifyLeadData()
               .getLeadID()
               .domarssalesRunBatch(acquisition.getShopBatch())
               .logoutFromThankYouPage();


   }

  
   @Test(groups = {FunctionalCategory.Acquisition})
   public void clearandsimpleGasAndDualAcquisitionEE50() {
       Report.createTestLogHeader("AcquisitionConversion Test", "ElectricityAllConversionStandardGasDualAcquisitionOAM");
       final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
       final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
       getCustomerDetailsToUserProfileOAM(userProfile);
       
       new HomePageAction()
              
               .navigateToLogin()
               .login(userProfile)              
               .navigateToGasAndElectricityPage()
               .navigateToOurTariffsPage()
               .navigateToClearAndSimple()
               .navigateToDualOrderPage()
               .yourOrderElecBG(acquisition,userProfile)
               .enterPersonalDetailsPage(acquisition, userProfile)
               .enterCurrentServices(acquisition)
               .enterPaymentOptionsEE50(acquisition)
               .reviewOrderPageNavigation()
               .verifyThankYouPage(userProfile)
               .verifyLeadData()
               .getLeadID()
               .domarssalesRunBatch(acquisition.getShopBatch())
               .logoutFromThankYouPage()
 
               
               .navigateToLogin()
               .login(userProfile)            
               .navigateToGasAndElectricityPage()
               .navigateToOurTariffsPage()
               .navigateToClearAndSimple()
               .navigateToGasOrderPage()
               .yourOrderElecBG(acquisition,userProfile)
               .enterPersonalDetailsPage(acquisition, userProfile)
               .enterCurrentServices(acquisition)
               .QuarterlyCashChequeEE50(acquisition)
               .reviewOrderPageNavigation()
               .verifyThankYouPage(userProfile)
               .verifyLeadData()
               .getLeadID()
               .domarssalesRunBatch(acquisition.getShopBatch())
               .logoutFromThankYouPage();


   }

   
   @Test(groups = {FunctionalCategory.Acquisition})
   public void fPM2014GasAndDualAcquisitionEE50() {
       Report.createTestLogHeader("AcquisitionConversion Test", "ElectricityAllConversionFixedPriceJune2013TariffPageGasDualAcquisitionOAM");
       final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
       final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
       getCustomerDetailsToUserProfileOAM(userProfile);
       new HomePageAction()
               .navigateToLogin()
               .login(userProfile)              
               .navigateToGasAndElectricityPage()
               .navigateToOurTariffsPage()
               .navigateToFixedPriceMay2014()
               .navigateToDualOrderPage()
               .yourOrderElecBG(acquisition,userProfile)
               .enterPersonalDetailsPage(acquisition, userProfile)
               .enterCurrentServices(acquisition)
               .enterPaymentOptions(acquisition)
               .reviewOrderPageNavigation()
               .verifyThankYouPage(userProfile)
               .verifyLeadData()
               .getLeadID()
               .domarssalesRunBatch(acquisition.getShopBatch())
               .logoutFromThankYouPage()

               
               .navigateToLogin()
               .login(userProfile)             
               .navigateToGasAndElectricityPage()
               .navigateToOurTariffsPage()
               .navigateToOnlineVariableAugust2013()
               .navigateToGasOrderPage()
               .yourOrderElecBG(acquisition,userProfile)
               .enterPersonalDetailsPage(acquisition, userProfile)
               .gasDefaultCurrentServicesPageNavigation(acquisition)
               .enterPaymentOptions(acquisition)
               .reviewOrderPageNavigation()
               .verifyThankYouPage(userProfile)
               .verifyLeadData()
               .getLeadID()
               .domarssalesRunBatch(acquisition.getShopBatch())
               .logoutFromThankYouPage();

   }

   
    
    
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})
    public void validateYourOrderPage() {

        Report.createTestLogHeader("Acquisition Test", " Your Order Page Validation");
        
        new AcquisitionAction()
        .validateYourOrder();
                

    }
    
    
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})
    public void validatePersonaleDetails() {

        Report.createTestLogHeader("Acquisition Test", "GASConversionElectricityDualAcquisitionOAM");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
        
        new AcquisitionAction()
        .yourOrderAnonymousNavigation(acquisition, userProfile)
        .enterCurrentServices(acquisition)
        .validateCurrentServices();
                       

    }
    
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})
    public void validate() {

        Report.createTestLogHeader("Tactical Dual Test", "Dual Acquisition ");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
       
        .navigateToLogin()
        .login(userProfile) 
        .navigateTOAddDualPage()
        .yourOrderElecBG(acquisition,userProfile)
        .enterPersonalDetailsPage(acquisition, userProfile)
        .enterCurrentServices(acquisition)
        .enterPaymentOptions(acquisition)
        .reviewOrderPageNavigation()
        .verifyThankYouPage(userProfile)
        .verifyLeadData()
        .getLeadID()
        .logoutFromThankYouPage();
                       

    }
    
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})
    public void validate1() {

        Report.createTestLogHeader("Tactical Gas Test", "Gas Acquisition ");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("HomeSerivcesAccount");
        //getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
       
        .navigateToLogin()
        .login(userProfile) 
        .navigateTOAddGasPage()
        .yourOrderAnonymousNavigation(acquisition, userProfile)
        .enterPersonalDetailsPage(acquisition, userProfile)
        .enterCurrentServices(acquisition)
        .enterPaymentOptions(acquisition)
        .reviewOrderPageNavigation()
        .verifyThankYouPage(userProfile)
        .verifyLeadData()
        .getLeadID()
        .logoutFromThankYouPage();
                       

    }
    

    @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})
    public void validate2() {

        Report.createTestLogHeader("Tactical Elec Test", "Elec Acquisition ");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("HomeSerivcesAccount");
        //getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
       
        .navigateToLogin()
        .login(userProfile) 
        .navigateTOAddElectrticityPage()
        .yourOrderAnonymousNavigation(acquisition, userProfile)
        .enterPersonalDetailsPage(acquisition, userProfile)
        .enterCurrentServices(acquisition)
        .enterPaymentOptions(acquisition)
        .reviewOrderPageNavigation()
        .verifyThankYouPage(userProfile)
        .verifyLeadData()
        .getLeadID()
        .logoutFromThankYouPage();
                       

    }
    
    
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})
    public void validate3() {

        Report.createTestLogHeader("Tactical Dual EE50 Test", "Dual Acquisition ");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("HomeSerivcesAccount");
        //getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
       
        .navigateToLogin()
        .login(userProfile) 
        .navigateTOAddDualPage()
        .yourOrderAnonymousNavigation(acquisition, userProfile)
        .enterPersonalDetailsPage(acquisition, userProfile)
        .enterCurrentServices(acquisition)
        .enterPaymentOptionsEE50(acquisition)
        .reviewOrderPageNavigation()
        .verifyThankYouPage(userProfile)
        .verifyLeadData()
        .getLeadID()
        .logoutFromThankYouPage();
                       

    }
    
    @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})
    public void validate4() {

        Report.createTestLogHeader("Tactical Gas EE50 Test", "Gas Acquisition ");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("HomeSerivcesAccount");
        //getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
       
        .navigateToLogin()
        .login(userProfile) 
        .navigateTOAddGasPage()
        .yourOrderAnonymousNavigation(acquisition, userProfile)
        .enterPersonalDetailsPage(acquisition, userProfile)
        .enterCurrentServices(acquisition)
        .enterPaymentOptionsEE50(acquisition)
        .reviewOrderPageNavigation()
        .verifyThankYouPage(userProfile)
        .verifyLeadData()
        .getLeadID()
        .logoutFromThankYouPage();
                       

    }
    

    @Test(groups = {FunctionalCategory.Acquisition,Regression,Complex})
    public void validate5() {

        Report.createTestLogHeader("Tactical Elec EE50 Test", "Elec Acquisition ");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("HomeSerivcesAccount");
        //getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
       
        .navigateToLogin()
        .login(userProfile) 
        .navigateTOAddElectrticityPage()
        .yourOrderAnonymousNavigation(acquisition, userProfile)
        .enterPersonalDetailsPage(acquisition, userProfile)
        .enterCurrentServices(acquisition)
        .enterPaymentOptionsEE50(acquisition)
        .reviewOrderPageNavigation()
        .verifyThankYouPage(userProfile)
        .verifyLeadData()
        .getLeadID()
        .logoutFromThankYouPage();
                       

    }

    

    
    
    
      
}