package bg.framework.app.functional.test.zeus;


import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.sales.AcquisitionAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.FunctionalCategory;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;

import static bg.framework.app.functional.entities.FunctionalCategory.*;


public class EnergySmartTest extends TestBase {

      
    
    @Test(groups = {Acquisition, BG})
    public void servicesGasElecDualCASEnergySmartAcquisition() {
        Report.createTestLogHeader("SSO EnergySmart Account CAS", "Dual Acquisition-Gas Acquisition-Elec Acqusition");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("HomeSerivcesAccount");
       
       getCustomerDetailsToUserProfileOAM(userProfile);
        
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
    public void servicesGasElecDualOVAEnergySmartAcquisition() {
        Report.createTestLogHeader("Services EnergySmart Account", " OVA Dual Acquisition-Gas Acquisition-Elec Acqusition");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("HomeSerivcesAccount");
       
       getCustomerDetailsToUserProfileOAM(userProfile);
        
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)               
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineVariableAugust2013()
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
                .navigateToOnlineVariableAugust2013()
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
                .navigateToOnlineVariableAugust2013()
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
    public void servicesGasElecDualfpmEnergySmartAcquisition() {
        Report.createTestLogHeader("SSO EnergySmart Account FPM", "Dual Acquisition-Gas Acquisition-Elec Acqusition");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("HomeSerivcesAccount");
       
       getCustomerDetailsToUserProfileOAM(userProfile);
        
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)               
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToFixedPriceMay2014()
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
                .navigateToFixedPriceMay2014()
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
                .navigateToFixedPriceMay2014()
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

    public void gasBgEnergySmartElectricityAcquisition() {
        Report.createTestLogHeader("Energy Smart Gas OAM Test", "Can Add Electricity Journey");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToEnergySmartElectricityOrderPage()
                .yourOrderGasBG(acquisition,userProfile)
                .gasBgEnergySmartElectricityAcquisition(acquisition)
                .enterCurrentServices(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage();
    }
   

   
    @Test(groups = {Acquisition, InProgress})

    public void gasBgEnergySmartDualOrder() {
        Report.createTestLogHeader("Energy Smart Gas OAM Test", "Can Add Dual Journey");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToEnergySmartDualOrderPage()
                .yourOrderGasBG(acquisition,userProfile)
                .gasBGEnergySmartDualOrder(acquisition)
                .enterCurrentServices(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage();

    }
    
    



   
    @Test(groups = {Acquisition, InProgress})
    public void gasBgEnergySmartGasConversion() {
        Report.createTestLogHeader("Energy Smart Gas OAM Test", "Can Add Gas Journey");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToEnergySmartGasOrderPage()
                .yourOrderGasBG(acquisition,userProfile)
                .gasBGEnergySmartGasConversion(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage();
    }

    
    @Test(groups = {Acquisition, InProgress})
    public void elecBgEnergySmartElecConversion() {
        Report.createTestLogHeader("Energy Smart Elec OAM Test", "Can Add Elec Journey");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToEnergySmartElectricityOrderPage()
                .yourOrderElecBG(acquisition,userProfile)
                .elecBGEnergySmartElecConversion(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage();
    }

   
    @Test(groups = {Acquisition, InProgress})

    public void elecBgEnergySmartDualOrder() {
        Report.createTestLogHeader("Energy Smart Elec OAM Test", "Can Add Dual Journey");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToEnergySmartDualOrderPage()
                .yourOrderElecBG(acquisition,userProfile)
                .elecBGEnergySmartDualOrder(acquisition)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage();

    }

    
    @Test(groups = {Acquisition, InProgress})

    public void elecBgEnergySmartGasAcquisition() {
        Report.createTestLogHeader("Energy Smart Elec OAM Test", "Can Add Gas Journey");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToEnergySmartGasOrderPage()
                .yourOrderElecBG(acquisition,userProfile)
                .elecBGEnergySmartGasAcquisition(acquisition)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage();
    }

    
        
      
       
       
       
    @Test(groups = {Acquisition, BG})   
    public void energySmartClearAndSimpleAcquisitionAnonymous() {
        Report.createTestLogHeader("Energy Smart Clear And SimpleTariff Acquisition Test", "AnonymousJourney");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("AnonymousESAcquisitionDual");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
         
        new HomePageAction()
                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToEnergySmartDualOrderPage()
                .energySmartAcquisitionYourOrderPage(acquisition,userProfile)
                .energySmartPersonalDetailsPage(acquisition)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .deleteWTP(userProfile)
                .domarssalesRunBatch(acquisition.getSmartBatch())
                .checkMediaCode(acquisition.getEnergySmartCode())
                .backToHomePage()
                
                
                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToEnergySmartGasOrderPage()
                .energySmartAcquisitionYourOrderPage(acquisition,userProfile)
                .energySmartPersonalDetailsPage(acquisition)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .deleteWTP(userProfile)
                .domarssalesRunBatch(acquisition.getSmartBatch())
                .checkMediaCode(acquisition.getEnergySmartCode())
                .backToHomePage()
                
                
                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToEnergySmartElectricityOrderPage()
                .energySmartAcquisitionYourOrderPage(acquisition,userProfile)
                .energySmartPersonalDetailsPage(acquisition)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .deleteWTP(userProfile)
                .domarssalesRunBatch(acquisition.getSmartBatch())
                .checkMediaCode(acquisition.getEnergySmartCode())
                .backToHomePage();
                
                

    }

   
    @Test(groups = {Acquisition, BG})

    public void energySmartOnlineVariableAugust2013AcquisitionAnonymous() {
        Report.createTestLogHeader("Energy Smart OnlineVariableAugust2013 Tariff Acquisition Test", "AnonymousJourney");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("AnonymousESAcquisitionDual");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
        new HomePageAction()
	        
	        .navigateToGasAndElectricityPage()
	        .navigateToOurTariffsPage()
	        .navigateToOnlineVariableAugust2013()
	        .navigateToEnergySmartDualOrderPage()
	        .energySmartAcquisitionYourOrderPage(acquisition,userProfile)
	        .energySmartPersonalDetailsPage(acquisition)
	        .gasDefaultCurrentServicesPageNavigation(acquisition)
	        .enterPaymentOptions(acquisition)
	        .reviewOrderPageNavigation()
	        .verifyThankYouPage(userProfile)
	        .verifyLeadData()
	        .getLeadID()
	        .deleteWTP(userProfile)
	        .domarssalesRunBatch(acquisition.getSmartBatch())
            .checkMediaCode(acquisition.getEnergySmartCode())
	        .backToHomePage()
	        
	        
	        .navigateToGasAndElectricityPage()
	        .navigateToOurTariffsPage()
	        .navigateToOnlineVariableAugust2013()
	        .navigateToEnergySmartGasOrderPage()
	        .energySmartAcquisitionYourOrderPage(acquisition,userProfile)
	        .energySmartPersonalDetailsPage(acquisition)
	        .gasDefaultCurrentServicesPageNavigation(acquisition)
	        .enterPaymentOptions(acquisition)
	        .reviewOrderPageNavigation()
	        .verifyThankYouPage(userProfile)
	        .verifyLeadData()
	        .getLeadID()
	        .deleteWTP(userProfile)
	        .domarssalesRunBatch(acquisition.getSmartBatch())
            .checkMediaCode(acquisition.getEnergySmartCode())
	        .backToHomePage()
	        
	        
	        .navigateToGasAndElectricityPage()
	        .navigateToOurTariffsPage()
	        .navigateToOnlineVariableAugust2013()
	        .navigateToEnergySmartElectricityOrderPage()
	        .energySmartAcquisitionYourOrderPage(acquisition,userProfile)
	        .energySmartPersonalDetailsPage(acquisition)
	        .gasDefaultCurrentServicesPageNavigation(acquisition)
	        .enterPaymentOptions(acquisition)
	        .reviewOrderPageNavigation()
	        .verifyThankYouPage(userProfile)
	        .verifyLeadData()
	        .getLeadID()
	        .deleteWTP(userProfile)
	        .domarssalesRunBatch(acquisition.getSmartBatch())
            .checkMediaCode(acquisition.getEnergySmartCode())
	        .backToHomePage();
	


    }

    @Test(groups = {Acquisition, BG})

    public void energySmartFixedPriceMay2014AcquisitionAnonymous() {
        Report.createTestLogHeader("Energy Smart FixedPriceMay2014 Tariff Acquisition Test", "AnonymousJourney");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("AnonymousESAcquisitionDual");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
        new HomePageAction()
	        
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
	        .getLeadID()
	        .deleteWTP(userProfile)
	        .domarssalesRunBatch(acquisition.getSmartBatch())
            .checkMediaCode(acquisition.getEnergySmartCode())
	        .backToHomePage()
	        
	        
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
	        .getLeadID()
	        .deleteWTP(userProfile)
	        .domarssalesRunBatch(acquisition.getSmartBatch())
            .checkMediaCode(acquisition.getEnergySmartCode())
	        .backToHomePage()
	        
	       
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
	        .getLeadID()
	        .deleteWTP(userProfile)
	        .domarssalesRunBatch(acquisition.getSmartBatch())
            .checkMediaCode(acquisition.getEnergySmartCode())
	        .backToHomePage();
	


    }
    
   
   @Test(groups = {Acquisition, BG})

    public void elecBgEnergySmartGasAcquisitionCanAddForcedLogin() {
        Report.createTestLogHeader("Energysmart  Test", "Must Change for Gas ");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToEnergySmartElectricityOrderPage()
                .forcedLoginYourOrderPage(acquisition, userProfile)
                .elecBGEnergySmartElecConversion(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage();
    }
   
   @Test(groups = {Acquisition, BG})

   public void elecBgEnergySmartelecConvCanAddForcedLogin() {
       Report.createTestLogHeader("Energysmart  Test", "Must Change for Gas ");
       final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
       final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
       getCustomerDetailsToUserProfileOAM(userProfile);
       new HomePageAction()
		       .navigateToGasAndElectricityPage()
		       .navigateToOurTariffsPage()
		       .navigateToClearAndSimple()
		       .navigateToEnergySmartElectricityOrderPage()
		       .forcedLoginYourOrderPage(acquisition, userProfile)
               .elecBGEnergySmartElecConversion(acquisition)
               .variableDirectDebitPayment(acquisition)
               .reviewOrderPageNavigation()
               .verifyThankYouPage(userProfile)
               .verifyLeadData()
               .logoutFromThankYouPage();
   }
   
   @Test(groups = {Acquisition, BG})

   public void elecBgEnergySmartDualAcquisitionCanAddForcedLogin() {
       Report.createTestLogHeader("Energysmart  Test", "Can Add for Gas ");
       final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
       final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
       getCustomerDetailsToUserProfileOAM(userProfile);
       new HomePageAction()
		       .navigateToGasAndElectricityPage()
		       .navigateToOurTariffsPage()
		       .navigateToClearAndSimple()
		       .navigateToEnergySmartElectricityOrderPage()
		       .forcedLoginYourOrderPage(acquisition, userProfile)
               .elecBGEnergySmartDualOrder(acquisition)
               .variableDirectDebitPayment(acquisition)
               .reviewOrderPageNavigation()
               .verifyThankYouPage(userProfile)
               .verifyLeadData()
               .logoutFromThankYouPage();
   }
   
   
    @Test(groups = {Acquisition, BG})
    public void gasBgEnergySmartElectricityAcquisitionCanAddForcedLogin() {
        Report.createTestLogHeader("Energysmart  Test", "Can Add  for Elec ");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineVariableAugust2013()
                .navigateToEnergySmartElectricityOrderPage()
                .forcedLoginYourOrderPage(acquisition, userProfile)
                .gasBgEnergySmartElectricityAcquisition(acquisition)
                .enterCurrentServices(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage();
    }
    
    @Test(groups = {Acquisition, BG})
    public void gasBgEnergySmartgasAcquisitionCanAddForcedLogin() {
        Report.createTestLogHeader("Energysmart  Test", "Can Add for Gas ");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
		        .navigateToGasAndElectricityPage()
		        .navigateToOurTariffsPage()
		        .navigateToOnlineVariableAugust2013()
		        .navigateToEnergySmartElectricityOrderPage()
		        .forcedLoginYourOrderPage(acquisition, userProfile)
                .gasBGEnergySmartGasConversion(acquisition)
                .enterCurrentServices(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage();
    }
    
    @Test(groups = {Acquisition, BG})
    public void gasBgEnergySmartDualAcquisitionCanAddForcedLogin() {
        Report.createTestLogHeader("Energysmart  Test", "Can Add  for Dual ");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
		        .navigateToGasAndElectricityPage()
		        .navigateToOurTariffsPage()
		        .navigateToOnlineVariableAugust2013()
		        .navigateToEnergySmartElectricityOrderPage()
		        .forcedLoginYourOrderPage(acquisition, userProfile)
                .gasBGEnergySmartDualOrder(acquisition)
                .enterCurrentServices(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage();
    }
    
    
    @Test(groups = {Acquisition, BG})
    public void clearandsimpleEsmartForcedRegistratition() {
        Report.createTestLogHeader("Energysmart  Test", "Can Add  for Elec ");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
        onlineDBConnector.deRegister(userProfile.getUCRN());
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        new HomePageAction()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineVariableAugust2013()
                .navigateToEnergySmartElectricityOrderPage()
                .forcedRegistrationYourOrderPage(acquisition, userProfile)
                .gasBgEnergySmartElectricityAcquisition(acquisition)
                .enterCurrentServices(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage();
    }
    
    @Test(groups = {Acquisition, BG})
    public void OVAEsmartForcedRegistratition() {
        Report.createTestLogHeader("Energysmart  Test", "Can Add for Gas ");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
        onlineDBConnector.deRegister(userProfile.getUCRN());
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        
        new HomePageAction()
		        .navigateToGasAndElectricityPage()
		        .navigateToOurTariffsPage()
		        .navigateToOnlineVariableAugust2013()
		        .navigateToEnergySmartElectricityOrderPage()
		        .forcedRegistrationYourOrderPage(acquisition, userProfile)
                .gasBGEnergySmartGasConversion(acquisition)
                .enterCurrentServices(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage();
    }
    
    @Test(groups = {Acquisition, BG})
    public void fPMEsmartForcedRegistratition() {
        Report.createTestLogHeader("Energysmart Conversion Test", "Can Add  for Dual ");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
        onlineDBConnector.deRegister(userProfile.getUCRN());
        getCustomerDetailsToUserProfileAnonymous(userProfile);
       
        new HomePageAction()
		        .navigateToGasAndElectricityPage()
		        .navigateToOurTariffsPage()
		        .navigateToOnlineVariableAugust2013()
		        .navigateToDualOrderPage()
		        .forcedRegistrationYourOrderPage(acquisition, userProfile)
                .energySmartGasBGOrderDual(acquisition)
                .enterCurrentServices(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage();
    }
        
    @Test(groups = {Acquisition, BG})

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
                .navigateToFixedPriceMay2014()
                .navigateToEnergySmartDualOrderPage()
                .energySmartDifferentSupplyAddressElec(acquisition)
                .energySmartAddressSelection(acquisition)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .logoutFromThankYouPage()
                
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineVariableAugust2013()
                .navigateToEnergySmartDualOrderPage()
                .energySmartDifferentSupplyAddressElec(acquisition)
                .energySmartAddressSelection(acquisition)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .logoutFromThankYouPage()
                
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToEnergySmartDualOrderPage()
                .energySmartDifferentSupplyAddressElec(acquisition)
                .energySmartAddressSelection(acquisition)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .logoutFromThankYouPage();



    }
   
    @Test(groups = {Acquisition, BG})

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
                .navigateToClearAndSimple()
                .navigateToEnergySmartDualOrderPage()
                .energySmartDifferentSupplyAddressGas(acquisition)
                .energySmartAddressSelection(acquisition)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .logoutFromThankYouPage()
                
                
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineVariableAugust2013()
                .navigateToEnergySmartDualOrderPage()
                .energySmartDifferentSupplyAddressGas(acquisition)
                .energySmartAddressSelection(acquisition)
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .logoutFromThankYouPage();

    }

    
    @Test(groups = {Acquisition, BG})

    public void inEligibleEnergySmartGas() {
        Report.createTestLogHeader("EnergySmart Test", "InEligible for Energy Smart Gas Verification");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToEnergySmartDualOrderPage()
                .yourOrderGasBG(acquisition,userProfile)
                .inEligibleEnergySmartMessage()
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineVariableAugust2013()
                .navigateToEnergySmartDualOrderPage()
                .yourOrderGasBG(acquisition,userProfile)
                .inEligibleEnergySmartMessage()
                .logoutFromThankYouPage();


    }

    @Test(groups = {Acquisition, BG})

    public void inEligibleEnergySmartElectricity() {
        Report.createTestLogHeader("Energy Smart Test", "InEligible for Energy Smart Electricity Verification");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToEnergySmartDualOrderPage()
                .yourOrderElecBG(acquisition,userProfile)
                .inEligibleEnergySmartMessage()
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineVariableAugust2013()
                .navigateToEnergySmartDualOrderPage()
                .yourOrderElecBG(acquisition,userProfile)
                .inEligibleEnergySmartMessage()
                .logoutFromThankYouPage();


    }
    
    @Test(groups = {Acquisition, BG})

    public void inEligibleEnergySmartDual() {
        Report.createTestLogHeader("Acquisition Test", "AnonymousJourney");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineVariableAugust2013()
                .navigateToEnergySmartDualOrderPage()
                .yourOrderDualBG(acquisition,userProfile)
                .inEligibleEnergySmartMessage();


    }

    
    @Test(groups = {Acquisition, BG})

    public void energySmartGasConversions() {
        Report.createTestLogHeader("EnergySmart Test", "Conversion Journey All Tariffs");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToEnergySmartDualOrderPage()
                .yourOrderGasBG(acquisition,userProfile)
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
                .navigateToClearAndSimple()
                .navigateToEnergySmartGasOrderPage()
                .yourOrderGasBG(acquisition,userProfile)
                .energySmartGasBGOrderGas(acquisition)
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToEnergySmartElectricityOrderPage()
                .yourOrderGasBG(acquisition,userProfile)
                .energySmartGasBGOrderElec(acquisition)
                .enterCurrentServices(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage();


    }

  
        @Test(groups = {Acquisition, BG})

        public void energySmartElecConversions() {
            Report.createTestLogHeader("Energy Smart  Test", "energySmartElecConversions");
            final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
            final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
            getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
                    .navigateToLogin()
                    .login(userProfile)
                    .navigateToProductAndServicesPage()
                    .navigateToGasAndElectricityPage()
                    .navigateToOurTariffsPage()
                    .navigateToClearAndSimple()
                    .navigateToEnergySmartDualOrderPage()
                    .yourOrderElecBG(acquisition,userProfile)
                    .energySmartElecBGOrderDual(acquisition)
                    .gasDefaultCurrentServicesPageNavigation(acquisition)
                    .variableDirectDebitPayment(acquisition)
                    .reviewOrderPageNavigation()
                    .verifyLeadData()
                    .verifyThankYouPage(userProfile)
                    .logoutFromThankYouPage()
                    .navigateToLogin()
                    .login(userProfile)
                    .navigateToProductAndServicesPage()
                    .navigateToGasAndElectricityPage()
                    .navigateToOurTariffsPage()
                    .navigateToClearAndSimple()
                    .navigateToEnergySmartElectricityOrderPage()
                    .yourOrderElecBG(acquisition,userProfile)
                    .energySmartElecBGOrderElec(acquisition,userProfile)
                    .verifyThankYouPage(userProfile)
                    .verifyLeadData()
                    .logoutFromThankYouPage()
                    .navigateToLogin()
                    .login(userProfile)
                    .navigateToProductAndServicesPage()
                    .navigateToGasAndElectricityPage()
                    .navigateToOurTariffsPage()
                    .navigateToClearAndSimple()
                    .navigateToEnergySmartGasOrderPage()
                    .yourOrderElecBG(acquisition,userProfile)
                    .energySmartElecBGOrderGas(acquisition)
                    .gasDefaultCurrentServicesPageNavigation(acquisition)
                    .variableDirectDebitPayment(acquisition)
                    .reviewOrderPageNavigation()
                    .verifyThankYouPage(userProfile)
                    .verifyLeadData()
                    .logoutFromThankYouPage();


        }

    
    @Test(groups = {Acquisition})

    public void mustchangegasBgEnergySmartElectricityAcquisition() {
        Report.createTestLogHeader("Acquisition Test", "AnonymousJourney");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToEnergySmartElectricityOrderPage()
                .yourOrderGasBG(acquisition,userProfile)
                .gasBgEnergySmartElectricityAcquisition(acquisition)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
		        .reviewOrderPageNavigation()
		        .verifyThankYouPage(userProfile)
		        .verifyLeadData()
		        .logoutFromThankYouPage();
    }

   
    @Test(groups = {Acquisition})

    public void mustchangegasBgEnergySmartDualOrder() {
        Report.createTestLogHeader("Acquisition Test", "AnonymousJourney");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToEnergySmartDualOrderPage()
                .yourOrderGasBG(acquisition,userProfile)
                .gasBGEnergySmartDualOrder(acquisition)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage();

    }

    
    @Test(groups = {Acquisition})
    public void mustchangegasBgEnergySmartGasConversion() {
        Report.createTestLogHeader("Acquisition Test", "AnonymousJourney");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToEnergySmartGasOrderPage()
                .yourOrderGasBG(acquisition,userProfile)
                .gasBGEnergySmartGasConversion(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage();
    }

    
    @Test(groups = {Acquisition})
    public void mustchangeelecBgEnergySmartElecConversion() {
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
                .navigateToClearAndSimple()
                .navigateToEnergySmartElectricityOrderPage()
                .yourOrderElecBG(acquisition,userProfile)
                .elecBGEnergySmartElecConversion(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage();
    }

   
    @Test(groups = {Acquisition})

    public void mustchangeelecBgEnergySmartDualOrder() {
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
                .navigateToClearAndSimple()
                .navigateToEnergySmartDualOrderPage()
                .yourOrderElecBG(acquisition,userProfile)
                .elecBGEnergySmartDualOrder(acquisition)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage();

    }

   
    @Test(groups = {Acquisition})

    public void mustchangeelecBgEnergySmartGasAcquisition() {
        Report.createTestLogHeader("EnergySmart Test", "mustchangeelecBgEnergySmartGasAcquisition");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToEnergySmartElectricityOrderPage()
                .yourOrderGasBG(acquisition,userProfile)
                .gasBgEnergySmartElectricityAcquisition(acquisition)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage();
    }
   
    
    
 
    
    
   
      
}