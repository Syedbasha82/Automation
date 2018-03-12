package bg.framework.app.functional.test.reFactoring;



import static bg.framework.app.functional.entities.FunctionalCategory.Acquisition;
import static bg.framework.app.functional.entities.FunctionalCategory.BG;
import static bg.framework.app.functional.entities.FunctionalCategory.Complex;
import static bg.framework.app.functional.entities.FunctionalCategory.Conversion;
import static bg.framework.app.functional.entities.FunctionalCategory.GAP;
import static bg.framework.app.functional.entities.FunctionalCategory.Qtp;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import static bg.framework.app.functional.entities.FunctionalCategory.Zeus;

import org.testng.annotations.Test;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.sales.AcquisitionAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.FunctionalCategory;
import bg.framework.app.functional.entities.GetAPrice;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class EsmartTest extends TestBase
{

	    //Used Methods
	    
	    
	    
	    @Test(groups = {Acquisition, BG})
	    public void energySmartDifferentSupplyAddressAnonymous() {
	        Report.createTestLogHeader("Acquisition Test", "AnonymousJourney");
	         Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	         UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
	         
//		        Pure Acquisition_ES_74
	  
	          userProfile.setNectarValue("4");
	          acquisition.setGasSupplier("British Gas");
              acquisition.setElecSupplier("EDF Energy");
             acquisition.setFuelType("dual");
             acquisition.setPaymentType("MonthlyDD");
             acquisition.setCurrentGasSupplier("Credit Meter");
             acquisition.setCurrentElecSupplier("Single Rate Credit");
	        new HomePageAction()
	        		.navigateToGasAndElectricityPage()
	        		.navigateToOurTariffsPage()
	        		.navigateToFixedPriceMay2014()
	        		.navigateToDualOrderPage()      
	                .forcedRegisrationOnly(acquisition,userProfile)
	                .energySmartDifferentSupplyAddressDual(acquisition)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyLeadData()
	                .getLeadID()
	                .logoutFromThankYouPage();
	        
//	        Pure Acquisition_ES_83
	  	  
	          userProfile.setNectarValue("4");
	          acquisition.setGasSupplier("British Gas");
	          acquisition.setElecSupplier("British Gas");
	          acquisition.setFuelType("dual");
	          acquisition.setPaymentType("MonthlyDD");
	          acquisition.setCurrentGasSupplier("Credit Meter");
           acquisition.setCurrentElecSupplier("Single Rate Credit");
	        new HomePageAction()
	        		.navigateToGasAndElectricityPage()
	        		.navigateToOurTariffsPage()
	        		.navigateToFixedPriceMay2014()
	        		.navigateToDualOrderPage()      
	                .forcedRegisrationOnly(acquisition,userProfile)
	                .energySmartDifferentSupplyAddressDual(acquisition)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyLeadData()
	                .getLeadID()
	                .logoutFromThankYouPage();
	        
//	        Pure Acquisition_ES_75
	  	  
	          userProfile.setNectarValue("4");
	          acquisition.setGasSupplier("EDF Energy");
            acquisition.setElecSupplier("British Gas");
           acquisition.setFuelType("dual");
           acquisition.setPaymentType("MonthlyDD");
           acquisition.setCurrentGasSupplier("Credit Meter");
           acquisition.setCurrentElecSupplier("Two Rate / Economy 7 Credit");
	        new HomePageAction()
	        		.navigateToGasAndElectricityPage()
	        		.navigateToOurTariffsPage()
	        		.navigateToClearAndSimple()
	        		.navigateToDualOrderPage()      
	                .forcedRegisrationOnly(acquisition,userProfile)
	                .energySmartDifferentSupplyAddressDual(acquisition)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyLeadData()
	                .getLeadID()
	                .logoutFromThankYouPage();
	        
//	        Pure Acquisition_ES_85
	          userProfile.setNectarValue("1");
            acquisition.setGasSupplier("British Gas");
            acquisition.setElecSupplier("British Gas");
            acquisition.setFuelType("Gas");
            acquisition.setPaymentType("MonthlyVariableDirectDebit");
            acquisition.setCurrentGasSupplier("Credit Meter");
	        new HomePageAction()
	        .navigateToGasAndElectricityPage()
    		.navigateToOurTariffsPage()
    		.navigateToClearAndSimple()
    		.navigateToGasOrderPage() 
            .forcedRegisrationOnly(acquisition,userProfile)
            .energySmartDifferentSupplyAddressGas(acquisition)
            .enterPersonalDetailsPage(acquisition, userProfile)
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .variableDirectDebitPayment(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyLeadData()
	                .getLeadID()
	                .logoutFromThankYouPage();
	        
//	        Pure Acquisition_ES_77
	          userProfile.setNectarValue("1");
          acquisition.setGasSupplier("British Gas");
          acquisition.setElecSupplier("British Gas");
          acquisition.setFuelType("Gas");
          acquisition.setPaymentType("MonthlyDD");
          acquisition.setCurrentGasSupplier("Credit Meter");
	        new HomePageAction()
	        .navigateToGasAndElectricityPage()
  		.navigateToOurTariffsPage()
  		.navigateToClearAndSimple()
  		.navigateToGasOrderPage() 
          .forcedRegisrationOnly(acquisition,userProfile)
          .energySmartDifferentSupplyAddressGas(acquisition)
          .enterPersonalDetailsPage(acquisition, userProfile)
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .variableDirectDebitPayment(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyLeadData()
	                .getLeadID()
	                .logoutFromThankYouPage();
	        
//	        Pure Acquisition_ES_63
	          userProfile.setNectarValue("4");
          acquisition.setGasSupplier("British Gas");
          acquisition.setElecSupplier("EDF Energy");
          acquisition.setFuelType("Elec");
          acquisition.setPaymentType("MonthlyVariableDirectDebit");
          acquisition.setCurrentElecSupplier("Single Rate Credit");
	        new HomePageAction()
	        .navigateToGasAndElectricityPage()
    		.navigateToOurTariffsPage()
    		.navigateToOnlineVariableAugust2013()
    		.navigateToElecOrderPage()
            .forcedLoginOnly(acquisition, userProfile)
            .energySmartDifferentSupplyAddressElec(acquisition)
            .enterPersonalDetailsPage(acquisition, userProfile)
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .variableDirectDebitPayment(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyLeadData()
	                .getLeadID()
	                .logoutFromThankYouPage();
	        
//	        Pure Acquisition_ES_66
	          userProfile.setNectarValue("4");
        acquisition.setGasSupplier("EDF Energy");
        acquisition.setElecSupplier("British Gas");
        acquisition.setFuelType("Elec");
        acquisition.setPaymentType("MonthlyVariableDirectDebit");
        acquisition.setCurrentElecSupplier("Two Rate / Economy 7 Credit");
	        new HomePageAction()
	        .navigateToGasAndElectricityPage()	
  		.navigateToOurTariffsPage()
  		.navigateToClearAndSimple()
  		.navigateToElecOrderPage()      
          .forcedRegisrationOnly(acquisition, userProfile)
          .energySmartDifferentSupplyAddressElec(acquisition)
          .enterPersonalDetailsPage(acquisition, userProfile)
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .variableDirectDebitPayment(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyLeadData()
	                .getLeadID()
	                .logoutFromThankYouPage();
	        
//	        Pure Acquisition_ES_48
	          userProfile.setNectarValue("3");
        acquisition.setGasSupplier("EDF Energy");
        acquisition.setElecSupplier("British Gas");
        acquisition.setFuelType("Gas");
        acquisition.setPaymentType("MonthlyDD");
        acquisition.setCurrentElecSupplier("Credit Meter");
	        new HomePageAction()
	        .navigateToGasAndElectricityPage()
  		.navigateToOurTariffsPage()
  		.navigateToFixedPriceMay2014()
  		.navigateToGasOrderPage()   
          .forcedRegisrationOnly(acquisition, userProfile)
          .energySmartDifferentSupplyAddressGas(acquisition)
          .enterPersonalDetailsPage(acquisition, userProfile)
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .variableDirectDebitPayment(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyLeadData()
	                .getLeadID()
	                .logoutFromThankYouPage();
	         
	    }
	    
	    @Test(groups = {Acquisition, BG})
	    public void energySmartDifferentSupplyAddressElectricity() {
	        Report.createTestLogHeader("Acquisition Test", "AnonymousJourney");
	         Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	         UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	     
	    //    getCustomerDetailsToUserProfileOAM(userProfile);
//	        Pure Acquisition_ES_69
	          userProfile.setNectarValue("4");
              acquisition.setGasSupplier("EDF Energy");
              acquisition.setElecSupplier("British Gas");
              acquisition.setFuelType("dual");
              acquisition.setPaymentType("MonthlyDD");
              acquisition.setCurrentGasSupplier("Credit Meter");
              acquisition.setCurrentElecSupplier("Two Rate / Economy 7 Credit");
	        new HomePageAction()
	                .navigateToLogin()
	                .login(userProfile)
	                .navigateToProductAndServicesPage()
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToFixedPriceMay2014()
	                .navigateToEnergySmartDualOrderPage()	                
	                .energySmartDifferentSupplyAddressDual(acquisition)
	                  .enterPersonalDetailsPage(acquisition, userProfile)	 
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .variableDirectDebitPayment(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyLeadData()
	                .getLeadID()
	                .logoutFromThankYouPage();
	        
	        
	                
	                //	        Pure Acquisition_ES_82
	          userProfile.setNectarValue("4");
              acquisition.setGasSupplier("British Gas");
              acquisition.setElecSupplier("British Gas");
              acquisition.setFuelType("dual");
              acquisition.setPaymentType("MonthlyDD");
              acquisition.setCurrentGasSupplier("Credit Meter");
              acquisition.setCurrentElecSupplier("Two Rate / Economy 7 Credit");
	        new HomePageAction()
	                .navigateToLogin()
	                .login(userProfile)
	                .navigateToProductAndServicesPage()
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToFixedPriceMay2014()
	                .navigateToEnergySmartDualOrderPage()
	                .forcedLoginOnly(acquisition, userProfile)
	                .energySmartDifferentSupplyAddressDual(acquisition)
	                  .enterPersonalDetailsPage(acquisition, userProfile)	 
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .variableDirectDebitPayment(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyLeadData()
	                .getLeadID()
	                .logoutFromThankYouPage();
	                
	        

	        

	                
	        

	        
//	        Pure Acquisition_ES_42
	          userProfile.setNectarValue("1");
            acquisition.setGasSupplier("EDF Energy");
            acquisition.setElecSupplier("British Gas");
            acquisition.setFuelType("Gas");
            acquisition.setPaymentType("MonthlyVariableDirectDebit");
            acquisition.setCurrentElecSupplier("Credit Meter");
	        new HomePageAction()
	                .navigateToLogin()
	                .login(userProfile)
	                .navigateToProductAndServicesPage()
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToOnlineVariableAugust2013()
	                .navigateToEnergySmartGasOrderPage()
	                .energySmartDifferentSupplyAddressGas(acquisition)
	                  .enterPersonalDetailsPage(acquisition, userProfile)	 
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .variableDirectDebitPayment(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyLeadData()
	                .getLeadID()
	                .logoutFromThankYouPage();
	        
//	        Pure Acquisition_ES_50
	          userProfile.setNectarValue("1");
          acquisition.setGasSupplier("EDF Energy");
          acquisition.setElecSupplier("British Gas");
          acquisition.setFuelType("Gas");
          acquisition.setPaymentType("MonthlyVariableDirectDebit");
          acquisition.setCurrentGasSupplier("Credit Meter");
	        new HomePageAction()
	                .navigateToLogin()
	                .login(userProfile)
	                .navigateToProductAndServicesPage()
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToClearAndSimple()
	                .navigateToEnergySmartGasOrderPage()
	                .energySmartDifferentSupplyAddressGas(acquisition)
	                  .enterPersonalDetailsPage(acquisition, userProfile)	 
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .variableDirectDebitPayment(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyLeadData()
	                .getLeadID()
	                .logoutFromThankYouPage();
	        
	        
//	        Pure Acquisition_ES_53
	          userProfile.setNectarValue("4");
            acquisition.setGasSupplier("British Gas");
            acquisition.setElecSupplier("EDF Energy");
            acquisition.setFuelType("Gas");
            acquisition.setPaymentType("MonthlyVariableDirectDebit");
            acquisition.setCurrentGasSupplier("Credit Meter");
            new HomePageAction()  
            .navigateToLogin()
            .login(userProfile)
            .navigateToProductAndServicesPage()
            .navigateToGasAndElectricityPage()
            .navigateToOurTariffsPage()
            .navigateToClearAndSimple()
            .navigateToEnergySmartGasOrderPage()
            .energySmartDifferentSupplyAddressGas(acquisition)
              .enterPersonalDetailsPage(acquisition, userProfile)	 
            .gasDefaultCurrentServicesPageNavigation(acquisition)
            .variableDirectDebitPayment(acquisition)
            .reviewOrderPageNavigation()
            .verifyThankYouPage(userProfile)
            .verifyLeadData()
            .getLeadID()
            .logoutFromThankYouPage();
            
//	        Pure Acquisition_ES_55
	          userProfile.setNectarValue("4");
              acquisition.setGasSupplier("British Gas");
              acquisition.setElecSupplier("British Gas");
              acquisition.setFuelType("Gas");
              acquisition.setPaymentType("MonthlyVariableDirectDebit");
              acquisition.setCurrentGasSupplier("Credit Meter");
              new HomePageAction()  
              .navigateToLogin()
              .login(userProfile)
              .navigateToProductAndServicesPage()
              .navigateToGasAndElectricityPage()
              .navigateToOurTariffsPage()
              .navigateToFixedPriceMay2014()
              .navigateToEnergySmartGasOrderPage()
              .forcedLoginOnly(acquisition, userProfile)
              .energySmartDifferentSupplyAddressGas(acquisition)
                .enterPersonalDetailsPage(acquisition, userProfile)	 
              .gasDefaultCurrentServicesPageNavigation(acquisition)
              .variableDirectDebitPayment(acquisition)
              .reviewOrderPageNavigation()
              .verifyThankYouPage(userProfile)
              .verifyLeadData()
              .getLeadID()
              .logoutFromThankYouPage();
              
              
//  	        Pure Acquisition_ES_57
  	          userProfile.setNectarValue("4");
                acquisition.setGasSupplier("British Gas");
                acquisition.setElecSupplier("EDF Energy");
                acquisition.setFuelType("Gas");
                acquisition.setPaymentType("MonthlyDD");
                acquisition.setCurrentGasSupplier("Credit Meter");
                new HomePageAction()  
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToEnergySmartGasOrderPage()
                .forcedRegisrationOnly(acquisition, userProfile)
                .energySmartDifferentSupplyAddressGas(acquisition)
                  .enterPersonalDetailsPage(acquisition, userProfile)	 
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .logoutFromThankYouPage();
                
//  	        Pure Acquisition_ES_98
    	          userProfile.setNectarValue("1");
                  acquisition.setGasSupplier("British Gas");
                  acquisition.setElecSupplier("EDF Energy");
                  acquisition.setFuelType("Gas");
                  acquisition.setPaymentType("MonthlyVariableDirectDebit");
                  acquisition.setCurrentGasSupplier("Credit Meter");
                  new HomePageAction()  
                  .navigateToLogin()
                  .login(userProfile)
                  .navigateToProductAndServicesPage()
                  .navigateToGasAndElectricityPage()
                  .navigateToOurTariffsPage()
                  .navigateToClearAndSimple()
                  .navigateToEnergySmartGasOrderPage()
                  .forcedLoginOnly(acquisition, userProfile)
                  .energySmartDifferentSupplyAddressGas(acquisition)
                    .enterPersonalDetailsPage(acquisition, userProfile)	 
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
	         Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	         UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	       // getCustomerDetailsToUserProfileOAM(userProfile);
	        

//		        Pure Acquisition_ES_96
	          userProfile.setNectarValue("4");
             acquisition.setGasSupplier("British Gas");
             acquisition.setElecSupplier("EDF Energy");
             acquisition.setFuelType("dual");
             acquisition.setPaymentType("MonthlyVariableDirectDebit");
             acquisition.setCurrentGasSupplier("Credit Meter");
             acquisition.setCurrentElecSupplier("Single Rate Credit");
	        new HomePageAction()
	                .navigateToLogin()
	                .login(userProfile)
	                .navigateToProductAndServicesPage()
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToClearAndSimple()
	                .navigateToEnergySmartDualOrderPage()
	                .energySmartDifferentSupplyAddressDual(acquisition)
	                   .enterPersonalDetailsPage(acquisition, userProfile)	 
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .variableDirectDebitPayment(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyLeadData()
	                .getLeadID()
	                .logoutFromThankYouPage();
	        
//		        Pure Acquisition_ES_72
	          userProfile = new TestDataHelper().getUserProfile("GasAccount");
	          userProfile.setNectarValue("4");
             acquisition.setGasSupplier("British Gas");
             acquisition.setElecSupplier("EDF Energy");
             acquisition.setFuelType("dual");
             acquisition.setPaymentType("MonthlyVariableDirectDebit");
             acquisition.setCurrentGasSupplier("Credit Meter");
             acquisition.setCurrentElecSupplier("Single Rate Credit");
	        new HomePageAction()
	                .navigateToLogin()
	                .login(userProfile)
	                .navigateToProductAndServicesPage()
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToOnlineEnergyTariffPage()
	                .navigateToEnergySmartDualOrderPage()
	                .forcedRegistrationYourOrderPage(acquisition,userProfile)
	                .energySmartDifferentSupplyAddressDual(acquisition)
	                  .enterPersonalDetailsPage(acquisition, userProfile)	 
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyLeadData()
	                .getLeadID()
	                .logoutFromThankYouPage();

	        
//	        Pure Acquisition_ES_81
	          userProfile.setNectarValue("4");
              acquisition.setGasSupplier("British Gas");
              acquisition.setElecSupplier("British Gas");
              acquisition.setFuelType("dual");
              acquisition.setPaymentType("MonthlyDD");
              acquisition.setCurrentGasSupplier("Credit Meter");
              acquisition.setCurrentElecSupplier("Single Rate Credit");
	        new HomePageAction()
	                .navigateToLogin()
	                .login(userProfile)
	                .navigateToProductAndServicesPage()
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToOnlineVariableAugust2013()
	                .navigateToEnergySmartDualOrderPage()
	                .energySmartDifferentSupplyAddressDual(acquisition)
	                .enterPersonalDetailsPage(acquisition, userProfile)	                
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .variableDirectDebitPayment(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyLeadData()
	                .getLeadID()
	                .logoutFromThankYouPage();
	                
	      

                  
//      	        Pure Acquisition_ES_49
    	          userProfile.setNectarValue("4");
                  acquisition.setGasSupplier("British Gas");
                  acquisition.setElecSupplier("EDF Energy");
                  acquisition.setFuelType("Elec");
                  acquisition.setPaymentType("MonthlyDD");
                  acquisition.setCurrentElecSupplier("Single Rate Credit");
                  new HomePageAction()  
                  .navigateToLogin()
                  .login(userProfile)
                  .navigateToProductAndServicesPage()
                  .navigateToGasAndElectricityPage()
                  .navigateToOurTariffsPage()
                  .navigateToOnlineEnergyTariffPage()
                  .navigateToEnergySmartElectricityOrderPage()
                  .forcedRegisrationOnly(acquisition, userProfile)
                  .energySmartDifferentSupplyAddressElec(acquisition)
                   .enterPersonalDetailsPage(acquisition, userProfile)	 
                  .gasDefaultCurrentServicesPageNavigation(acquisition)
                  .variableDirectDebitPayment(acquisition)
                  .reviewOrderPageNavigation()
                  .verifyThankYouPage(userProfile)
                  .verifyLeadData()
                  .getLeadID()
                  .logoutFromThankYouPage();
                  
//      	        Pure Acquisition_ES_59
    	          userProfile.setNectarValue("1");
                  acquisition.setGasSupplier("British Gas");
                  acquisition.setElecSupplier("EDF Energy");
                  acquisition.setFuelType("Elec");
                  acquisition.setPaymentType("MonthlyVariableDirectDebit");
                  acquisition.setCurrentElecSupplier("Single Rate Credit");
    	        new HomePageAction()
    	                .navigateToLogin()
    	                .login(userProfile)
    	                .navigateToProductAndServicesPage()
    	                .navigateToGasAndElectricityPage()
    	                .navigateToOurTariffsPage()
    	                .navigateToClearAndSimple()
    	                .navigateToEnergySmartElectricityOrderPage()
    	                .energySmartDifferentSupplyAddressElec(acquisition)
    	                  .enterPersonalDetailsPage(acquisition, userProfile)	 
    	                .gasDefaultCurrentServicesPageNavigation(acquisition)
    	                .variableDirectDebitPayment(acquisition)
    	                .reviewOrderPageNavigation()
    	                .verifyThankYouPage(userProfile)
    	                .verifyLeadData()
    	                .getLeadID()
    	                .logoutFromThankYouPage();
    	        
//    	        Pure Acquisition_ES_60
    	          userProfile.setNectarValue("4");
                  acquisition.setGasSupplier("EDF Energy");
                  acquisition.setElecSupplier("British Gas");
                  acquisition.setFuelType("Elec");
                  acquisition.setPaymentType("MonthlyDD");
                  acquisition.setCurrentElecSupplier("Two Rate / Economy 7 Credit");
    	        new HomePageAction()
    	                .navigateToLogin()
    	                .login(userProfile)
    	                .navigateToProductAndServicesPage()
    	                .navigateToGasAndElectricityPage()
    	                .navigateToOurTariffsPage()
    	                .navigateToFixedPriceMay2014()
    	                .navigateToEnergySmartElectricityOrderPage()
    	                .energySmartDifferentSupplyAddressElec(acquisition)
    	                  .enterPersonalDetailsPage(acquisition, userProfile)	 
    	                .gasDefaultCurrentServicesPageNavigation(acquisition)
    	                .variableDirectDebitPayment(acquisition)
    	                .reviewOrderPageNavigation()
    	                .verifyThankYouPage(userProfile)
    	                .verifyLeadData()
    	                .getLeadID()
    	                .logoutFromThankYouPage();
    	        
    	        
//  	        Pure Acquisition_ES_97
  	          userProfile.setNectarValue("4");
                acquisition.setGasSupplier("British Gas");
                acquisition.setElecSupplier("EDF Energy");
                acquisition.setFuelType("Gas");
                acquisition.setPaymentType("MonthlyDD");
                acquisition.setCurrentGasSupplier("Credit Meter");
                new HomePageAction()  
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToEnergySmartGasOrderPage()
                .forcedRegisrationOnly(acquisition, userProfile)
                .energySmartDifferentSupplyAddressGas(acquisition)
                   .enterPersonalDetailsPage(acquisition, userProfile)	 
                .gasDefaultCurrentServicesPageNavigation(acquisition)
                .variableDirectDebitPayment(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .getLeadID()
                .logoutFromThankYouPage();
                
                
//  	        Pure Acquisition_ES_58
    	          userProfile.setNectarValue("4");
                  acquisition.setGasSupplier("British Gas");
                  acquisition.setElecSupplier("British Gas");
                  acquisition.setFuelType("Gas");
                  acquisition.setPaymentType("MonthlyDD");
                  acquisition.setCurrentGasSupplier("Credit Meter");
                  new HomePageAction()  
                  .navigateToLogin()
                  .login(userProfile)
                  .navigateToProductAndServicesPage()
                  .navigateToGasAndElectricityPage()
                  .navigateToOurTariffsPage()
                  .navigateToClearAndSimple()
                  .navigateToEnergySmartGasOrderPage()
                  .forcedRegisrationOnly(acquisition, userProfile)
                  .energySmartDifferentSupplyAddressGas(acquisition)
                    .enterPersonalDetailsPage(acquisition, userProfile)	 
                  .gasDefaultCurrentServicesPageNavigation(acquisition)
                  .variableDirectDebitPayment(acquisition)
                  .reviewOrderPageNavigation()
                  .verifyThankYouPage(userProfile)
                  .verifyLeadData()
                  .getLeadID()
                  .logoutFromThankYouPage();
	    }
	    
	    public void energySmartDifferentSupplyAddressDual()
	    {
	    	 Report.createTestLogHeader("Energy Smart Test", "EnergySmartDifferentSupplyAddressGas");
	         Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	         UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
	       // getCustomerDetailsToUserProfileOAM(userProfile);
	         
//		        Pure Acquisition_ES_70
	          userProfile.setNectarValue("4");
             acquisition.setGasSupplier("British Gas");
             acquisition.setElecSupplier("British Gas");
             acquisition.setFuelType("dual");
             acquisition.setPaymentType("MonthlyDD");
             acquisition.setCurrentGasSupplier("Credit Meter");
             acquisition.setCurrentElecSupplier("Single Rate Credit");
	        new HomePageAction()
	                .navigateToLogin()
	                .login(userProfile)
	                .navigateToProductAndServicesPage()
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToClearAndSimple()
	                .navigateToEnergySmartDualOrderPage()
	                .energySmartDifferentSupplyAddressDual(acquisition)
	                  .enterPersonalDetailsPage(acquisition, userProfile)	 
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .variableDirectDebitPayment(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyLeadData()
	                .getLeadID()
	                .logoutFromThankYouPage();
	        
	        
//	        Pure Acquisition_ES_76
	          userProfile.setNectarValue("4");
           acquisition.setGasSupplier("British Gas");
           acquisition.setElecSupplier("British Gas");
           acquisition.setFuelType("dual");
           acquisition.setPaymentType("MonthlyDD");
           acquisition.setCurrentGasSupplier("Credit Meter");
           acquisition.setCurrentElecSupplier("Single Rate Credit");
	        new HomePageAction()
	                .navigateToLogin()
	                .login(userProfile)
	                .navigateToProductAndServicesPage()
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToOnlineVariableAugust2013()
	                .navigateToEnergySmartDualOrderPage()
	                .energySmartDifferentSupplyAddressDual(acquisition)
	                  .enterPersonalDetailsPage(acquisition, userProfile)	 
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .variableDirectDebitPayment(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyLeadData()
	                .getLeadID()
	                .logoutFromThankYouPage();

	    }

	    public void energySmartDifferentSupplyAddressJI()
	    {
	    	 Report.createTestLogHeader("Energy Smart Test", "EnergySmartDifferentSupplyAddressGas");
	         Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	         UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
	       // getCustomerDetailsToUserProfileOAM(userProfile);
	         
//		        Pure Acquisition_ES_79
	          userProfile.setNectarValue("4");
             acquisition.setGasSupplier("British Gas");
             acquisition.setElecSupplier("British Gas");
             acquisition.setFuelType("dual");
             acquisition.setPaymentType("MonthlyDD");
             acquisition.setCurrentGasSupplier("Credit Meter");
             acquisition.setCurrentElecSupplier("Single Rate Credit");
	        new HomePageAction()
	                .navigateToLogin()
	                .login(userProfile)
	                .navigateToProductAndServicesPage()
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToFixedPriceMay2014()
	                .navigateToEnergySmartElectricityOrderPage()
	                .energySmartDifferentSupplyAddressElec(acquisition)
	                  .enterPersonalDetailsPage(acquisition, userProfile)	 
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .variableDirectDebitPayment(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyLeadData()
	                .getLeadID()
	                .logoutFromThankYouPage();

	    }
	    
	    public void validateErrorPaymentPage()
	    {
	    	Report.createTestLogHeader("Acquisition Test", " Your Order Page Validation");	        
	        new AcquisitionAction()
	        .errorPaymentPage();	 
	    }
	    
	    public void validateErrorReviewPage()
	    {
	    	Report.createTestLogHeader("Acquisition Test", " Your Order Page Validation");	        
	        new AcquisitionAction()
	        .errorReviewOrder();	 
	    }
	    
	    @Test(groups = {Regression, GAP})
	    
	    public void verifyAnonymousEnergyShopJourneyESmartGas() {
	        Report.createTestLogHeader("Get A Price", "Energy Shop Anonymous Journey");
	        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
	        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	        UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
	        
	        
//	     Pure Acquisition_GAP_07

         userProfile.setNectarValue("4");
         acquisition.setGasSupplier("British Gas");
         acquisition.setElecSupplier("British Gas");
         acquisition.setFuelType("dual");
         acquisition.setPaymentType("MonthlyDD");
         acquisition.setCurrentGasSupplier("Credit Meter");
         acquisition.setCurrentElecSupplier("Single Rate Credit");
	        new HomePageAction()
	                .navigateToGasAndElectricityPage()
	                .navigateToGetAPricePage()
	                .verifyAndEnterGAPDetails(getaPrice, userProfile)
	                .switchTariff(getaPrice)
	                .energySmartAcquisitionYourOrderPage(acquisition,userProfile)
	                .energySmartPersonalDetailsPage(acquisition)
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .getLeadID()
	                .verifyLeadData()	                
	                .domarssalesRunBatch(acquisition.getShopBatch())
	                .checkMediaCode(acquisition.getDualCsCode())
	                .deleteWTP(userProfile)
	                .backToHomePage();    
	          
	    }
	    
 @Test(groups = {Regression, GAP})
	    
	    public void verifyAnonymousEnergyShopJourneyESmartElec() {
	        Report.createTestLogHeader("Get A Price", "Energy Shop Anonymous Journey");
	        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
	        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	        UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
	        
	        
//	     Pure Acquisition_GAP_07

         userProfile.setNectarValue("1");
         acquisition.setGasSupplier("EDF Energy");
         acquisition.setElecSupplier("EDF Energy");
         acquisition.setFuelType("Gas");
         acquisition.setPaymentType("MonthlyDD");
         acquisition.setCurrentGasSupplier("Credit Meter");
         acquisition.setCurrentElecSupplier("Single Rate Credit");
	        new HomePageAction()
	                .navigateToGasAndElectricityPage()
	                .navigateToGetAPricePage()
	                .verifyAndEnterGAPDetails(getaPrice, userProfile)
	                .switchTariff(getaPrice)
	                .energySmartAcquisitionYourOrderPage(acquisition,userProfile)
	                .energySmartPersonalDetailsPage(acquisition)
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .getLeadID()
	                .verifyLeadData()	                
	                .domarssalesRunBatch(acquisition.getShopBatch())
	                .checkMediaCode(acquisition.getDualCsCode())
	                .deleteWTP(userProfile)
	                .backToHomePage();    
	          
	    }

 @Test(groups = {Regression, GAP})
 		public void verifyAnonymousEnergyShopJourneyGasOAM() {
     Report.createTestLogHeader("Get A Price", "Energy Shop Anonymous Journey");
     GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
     Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
     UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
     
//     Pure Acquisition_GAP_07

     userProfile.setNectarValue("1");
     acquisition.setGasSupplier("EDF Energy");
     acquisition.setElecSupplier("EDF Energy");
     acquisition.setFuelType("Gas");
     acquisition.setPaymentType("MonthlyDD");
     acquisition.setCurrentGasSupplier("Credit Meter");
     acquisition.setCurrentElecSupplier("Single Rate Credit");
     new HomePageAction()
             .navigateToGasAndElectricityPage()
             .navigateToGetAPricePage()
             .verifyAndEnterGAPDetails(getaPrice, userProfile)
             .switchTariff(getaPrice)
             .forcedRegisrationOnly(acquisition,userProfile)	    
	           .enterPersonalDetailsPage(acquisition, userProfile)	 
             .enterCurrentServices(acquisition)
             .enterPaymentOptions(acquisition)
             .reviewOrderPageNavigation()
             .verifyThankYouPage(userProfile)
             .getLeadID()
	         .verifyLeadData()	                
	         .domarssalesRunBatch(acquisition.getShopBatch())
	         .checkMediaCode(acquisition.getDualCsCode())
	         .deleteWTP(userProfile)
             .backToHomePage();
     
//   Pure Acquisition_GAP_04

   userProfile.setNectarValue("1");
   acquisition.setGasSupplier("EDF Energy");
   acquisition.setElecSupplier("EDF Energy");
   acquisition.setFuelType("Gas");
   acquisition.setPaymentType("MonthlyVariableDirectDebit");
   acquisition.setCurrentGasSupplier("Credit Meter");
   acquisition.setCurrentElecSupplier("Single Rate Credit");
   new HomePageAction()
           .navigateToGasAndElectricityPage()
           .navigateToGetAPricePage()
           .verifyAndEnterGAPDetails(getaPrice, userProfile)
           .switchTariff(getaPrice)
           .forcedLoginOnly(acquisition,userProfile)	    
	         .enterPersonalDetailsPage(acquisition, userProfile)	 
           .enterCurrentServices(acquisition)
           .enterPaymentOptions(acquisition)
           .reviewOrderPageNavigation()
           .verifyThankYouPage(userProfile)
           .getLeadID()
	       .verifyLeadData()	                
	       .domarssalesRunBatch(acquisition.getShopBatch())
	       .checkMediaCode(acquisition.getDualCsCode())
	       .deleteWTP(userProfile)
           .backToHomePage();
   
   
// Pure Acquisition_GAP_11

 userProfile.setNectarValue("1");
 acquisition.setGasSupplier("EDF Energy");
 acquisition.setElecSupplier("EDF Energy");
 acquisition.setFuelType("Gas");
 acquisition.setPaymentType("MonthlyDD");
 acquisition.setCurrentGasSupplier("Credit Meter");
 acquisition.setCurrentElecSupplier("Single Rate Credit");
 new HomePageAction()
         .navigateToGasAndElectricityPage()
         .navigateToGetAPricePage()
         .verifyAndEnterGAPDetails(getaPrice, userProfile)
         .switchTariff(getaPrice)
         .forcedLoginOnly(acquisition,userProfile)
	     .energySmartDifferentSupplyAddressDual(acquisition)
	       .enterPersonalDetailsPage(acquisition, userProfile)	 
         .enterCurrentServices(acquisition)
         .enterPaymentOptions(acquisition)
         .reviewOrderPageNavigation()
         .verifyThankYouPage(userProfile)
         .getLeadID()
	     .verifyLeadData()	                
	     .domarssalesRunBatch(acquisition.getShopBatch())
	     .checkMediaCode(acquisition.getDualCsCode())
	     .deleteWTP(userProfile)
         .backToHomePage();
 
 
//Pure Acquisition_GAP_12

userProfile.setNectarValue("1");
acquisition.setGasSupplier("EDF Energy");
acquisition.setElecSupplier("EDF Energy");
acquisition.setFuelType("Gas");
acquisition.setPaymentType("MonthlyVariableDirectDebit");
acquisition.setCurrentGasSupplier("Credit Meter");
acquisition.setCurrentElecSupplier("Single Rate Credit");
new HomePageAction()
       .navigateToGasAndElectricityPage()
       .navigateToGetAPricePage()
       .verifyAndEnterGAPDetails(getaPrice, userProfile)
       .switchTariff(getaPrice)
       .forcedLoginOnly(acquisition,userProfile)
	   .energySmartDifferentSupplyAddressDual(acquisition)
	     .enterPersonalDetailsPage(acquisition, userProfile)	 
       .enterCurrentServices(acquisition)
       .enterPaymentOptions(acquisition)
       .reviewOrderPageNavigation()
       .verifyThankYouPage(userProfile)
       .getLeadID()
	   .verifyLeadData()	                
	   .domarssalesRunBatch(acquisition.getShopBatch())
	   .checkMediaCode(acquisition.getDualCsCode())
	   .deleteWTP(userProfile)
       .backToHomePage();
 }
	
 @Test(groups = {FunctionalCategory.Acquisition})     
 		public void clearAndSimpleAcquisition(){
  	
  	 Report.createTestLogHeader("Clear And Simple Acquisition", "Dual , Gas , Electricity");	      	
  	  final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
      final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");	      
      
//    Pure Acquisition_ES_01
      userProfile.setNectarValue("1");
      acquisition.setGasSupplier("EDF Energy");
      acquisition.setFuelType("Gas");
      acquisition.setPaymentType("MonthlyVariableDirectDebit");
      acquisition.setCurrentGasSupplier("Credit Meter");
      new HomePageAction()
      
      .navigateToGasAndElectricityPage1()
      /*.navigateToOurTariffsPage()
      .navigateToClearAndSimple()
      .navigateToGasOrderPage()*/
      .yourOrderAnonymousNavigation(acquisition,userProfile)
      .enterPersonalDetailsPage(acquisition, userProfile)
      .enterCurrentServices(acquisition)
      .enterPaymentOptions(acquisition)
      .reviewOrderPageNavigation()
      .verifyThankYouPage(userProfile)
      .verifyEshopLeadData()
      .getEshopLeadID()
      .verifyAuditEventID(userProfile)
      .domarssalesRunBatch(acquisition.getShopBatch())    
      .checkMediaCode(acquisition.getGasCsCode())
      .backToHomePage();
       //Pure Acquisition_ES_03
      userProfile.setNectarValue("3");
  acquisition.setGasSupplier("EDF Energy");
  acquisition.setFuelType("Gas");
  acquisition.setPaymentType("MonthlyDD");
  acquisition.setCurrentGasSupplier("Credit Meter");   
  new HomePageAction()
  .navigateToGasAndElectricityPage1()
 /* .navigateToOurTariffsPage()
  .navigateToClearAndSimple()
  .navigateToGasOrderPage()*/
  .yourOrderAnonymousNavigation(acquisition,userProfile)
  .enterPersonalDetailsPage(acquisition, userProfile)
  .enterCurrentServices(acquisition)
  .enterPaymentOptions(acquisition)
  .reviewOrderPageNavigation()
  .verifyThankYouPage(userProfile)
  .verifyEshopLeadData()
  .getEshopLeadID()
  .verifyAuditEventID(userProfile)
  .domarssalesRunBatch(acquisition.getShopBatch())    
  .checkMediaCode(acquisition.getGasCsCode())
  .backToHomePage();
  
  //Pure Acquisition_ES_04
  userProfile.setNectarValue("4");
  acquisition.setGasSupplier("EDF Energy");
  acquisition.setFuelType("Gas");
  acquisition.setPaymentType("MonthlyDD");
  acquisition.setCurrentGasSupplier("Credit Meter");
new HomePageAction()
.navigateToGasAndElectricityPage1()
/*.navigateToOurTariffsPage()
.navigateToClearAndSimple()
.navigateToGasOrderPage()*/
.yourOrderAnonymousNavigation(acquisition,userProfile)
.enterPersonalDetailsPage(acquisition, userProfile)
.enterCurrentServices(acquisition)
.enterPaymentOptions(acquisition)
.reviewOrderPageNavigation()
.verifyThankYouPage(userProfile)
.verifyEshopLeadData()
.getEshopLeadID()
.verifyAuditEventID(userProfile)
.domarssalesRunBatch(acquisition.getShopBatch())    
.checkMediaCode(acquisition.getGasCsCode())
.backToHomePage();


//Pure Acquisition_ES_13
userProfile.setNectarValue("1");
acquisition.setGasSupplier("EDF Energy");
acquisition.setFuelType("Gas");
acquisition.setPaymentType("MonthlyVariableDirectDebit");
acquisition.setCurrentElecSupplier("Single Rate Credit");
new HomePageAction()
.navigateToGasAndElectricityPage1()
/*.navigateToOurTariffsPage()
.navigateToClearAndSimple()
.navigateToGasOrderPage()*/
.yourOrderAnonymousNavigation(acquisition,userProfile)
.enterPersonalDetailsPage(acquisition, userProfile)
.enterCurrentServices(acquisition)
.enterPaymentOptions(acquisition)
.reviewOrderPageNavigation()
.verifyThankYouPage(userProfile)
.verifyEshopLeadData()
.getEshopLeadID()
.verifyAuditEventID(userProfile)
.domarssalesRunBatch(acquisition.getShopBatch())    
.checkMediaCode(acquisition.getGasCsCode())
.backToHomePage();

//Pure Acquisition_ES_14
userProfile.setNectarValue("3");
acquisition.setGasSupplier("EDF Energy");
acquisition.setFuelType("Gas");
acquisition.setPaymentType("MonthlyDD");
acquisition.setCurrentElecSupplier("Two Rate / Economy 7 Credit");	
new HomePageAction()
.navigateToGasAndElectricityPage1()
/*.navigateToOurTariffsPage()
.navigateToClearAndSimple()
.navigateToGasOrderPage()*/
.yourOrderAnonymousNavigation(acquisition,userProfile)
.enterPersonalDetailsPage(acquisition, userProfile)
.enterCurrentServices(acquisition)
.enterPaymentOptions(acquisition)
.reviewOrderPageNavigation()
.verifyThankYouPage(userProfile)
.verifyEshopLeadData()
.getEshopLeadID()
.verifyAuditEventID(userProfile)
.domarssalesRunBatch(acquisition.getShopBatch())    
.checkMediaCode(acquisition.getGasCsCode())
.backToHomePage();
  
//Pure Acquisition_ES_16
userProfile.setNectarValue("3");
acquisition.setGasSupplier("EDF Energy");
acquisition.setFuelType("Elec");
acquisition.setPaymentType("MonthlyDD");
acquisition.setCurrentGasSupplier("Credit Meter");
new HomePageAction()
         
.navigateToGasAndElectricityPage1()
/*.navigateToOurTariffsPage()
.navigateToClearAndSimple()
.navigateToElecOrderPage()*/
.yourOrderAnonymousNavigation(acquisition,userProfile)
.enterPersonalDetailsPage(acquisition, userProfile)
.enterCurrentServices(acquisition)
.enterPaymentOptions(acquisition)
.reviewOrderPageNavigation()
.verifyThankYouPage(userProfile)
.verifyEshopLeadData()
.getEshopLeadID()
.verifyAuditEventID(userProfile)
.domarssalesRunBatch(acquisition.getShopBatch()) 
.checkMediaCode(acquisition.getElecCsCode())
.backToHomePage();   
          
// Pure Acquisition_ES_25
userProfile.setNectarValue("1");
	acquisition.setGasSupplier("EDF Energy");
	acquisition.setFuelType("dual");
	acquisition.setPaymentType("MonthlyVariableDirectDebit");
	acquisition.setCurrentElecSupplier("Single Rate Credit");
	
new HomePageAction()     
           
.navigateToGasAndElectricityPage1()
/* .navigateToOurTariffsPage()
.navigateToClearAndSimple()	        
.navigateToDualOrderPage()	*/          
.yourOrderAnonymousNavigation(acquisition,userProfile)
.enterPersonalDetailsPage(acquisition, userProfile)
.enterCurrentServices(acquisition)     
.enterPaymentOptions(acquisition)
.reviewOrderPageNavigation()
.verifyThankYouPage(userProfile)
.verifyEshopLeadData()
.getEshopLeadID()
.verifyAuditEventID(userProfile)
.domarssalesRunBatch(acquisition.getShopBatch())    
.checkMediaCode(acquisition.getDualCsCode())
.backToHomePage();

//Pure Acquisition_ES_27
userProfile.setNectarValue("3");
acquisition.setGasSupplier("EDF Energy");
acquisition.setFuelType("dual");
acquisition.setPaymentType("MonthlyDD");
acquisition.setCurrentElecSupplier("Single Rate Credit");

new HomePageAction()     
   
.navigateToGasAndElectricityPage1()
/* .navigateToOurTariffsPage()
.navigateToClearAndSimple()	        
.navigateToDualOrderPage()	*/          
.yourOrderAnonymousNavigation(acquisition,userProfile)
.enterPersonalDetailsPage(acquisition, userProfile)
.enterCurrentServices(acquisition)     
.enterPaymentOptions(acquisition)
.reviewOrderPageNavigation()
.verifyThankYouPage(userProfile)
.verifyEshopLeadData()
.getEshopLeadID()
.verifyAuditEventID(userProfile)
.domarssalesRunBatch(acquisition.getShopBatch())    
.checkMediaCode(acquisition.getDualCsCode())
.backToHomePage();

//Pure Acquisition_ES_29
userProfile.setNectarValue("1");
acquisition.setGasSupplier("EDF Energy");
acquisition.setFuelType("dual");
acquisition.setPaymentType("MonthlyVariableDirectDebit");
acquisition.setCurrentGasSupplier("Credit Meter");
acquisition.setCurrentElecSupplier("Two Rate / Economy 7 Credit");
new HomePageAction() 
.navigateToGasAndElectricityPage1()
/*.navigateToOurTariffsPage()
.navigateToClearAndSimple()	        
.navigateToDualOrderPage()	 */         
.yourOrderAnonymousNavigation(acquisition,userProfile)
.enterPersonalDetailsPage(acquisition, userProfile)
.enterCurrentServices(acquisition)     
.enterPaymentOptions(acquisition)
.reviewOrderPageNavigation()
.verifyThankYouPage(userProfile)
.verifyEshopLeadData()
.getEshopLeadID()
.verifyAuditEventID(userProfile)
.domarssalesRunBatch(acquisition.getShopBatch())    
.checkMediaCode(acquisition.getDualCsCode())
.backToHomePage();
}

@Test(groups = {FunctionalCategory.Acquisition})    
		public void OnlineVariableAugust2013Acquisition(){
  	
  	 Report.createTestLogHeader("onlineVariableAugust2013", "Dual, Gas , Elec");	      	
  	  Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
     final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
     
     //Pure Acquisition_ES_30
     userProfile.setNectarValue("2");
     acquisition.setGasSupplier("EDF Energy");
 	acquisition.setFuelType("dual");
 	acquisition.setPaymentType("MonthlyDD");
 	acquisition.setCurrentGasSupplier("Credit Meter");
 	acquisition.setCurrentElecSupplier("Two Rate / Economy 7 Credit");
      new HomePageAction()	          
          .navigateToGasAndElectricityPage1()
          /*.navigateToOurTariffsPage()
          .navigateToOnlineVariableAugust2013()
          .navigateToDualOrderPage()*/
          .yourOrderAnonymousNavigation(acquisition,userProfile)
          .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
          .gasDefaultCurrentServicesPageNavigation(acquisition)
          .QuarterlyCashCheque(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyEshopLeadData()
          .getEshopLeadID()
          .verifyAuditEventID(userProfile)
          .domarssalesRunBatch(acquisition.getShopBatch())
          .checkMediaCode(acquisition.getDualonlineenergyTariffCode())
          .deleteWTP(userProfile)
          .backToHomePage();
      
//    Pure Acquisition_ES_32
      userProfile.setNectarValue("4");
         acquisition.setGasSupplier("EDF Energy");
     	acquisition.setFuelType("dual");
     	acquisition.setPaymentType("MonthlyDD");
     	acquisition.setCurrentGasSupplier("Credit Meter");
     	acquisition.setCurrentElecSupplier("Two Rate / Economy 7 Credit");
          new HomePageAction()	          
          .navigateToGasAndElectricityPage1()
          /*.navigateToOurTariffsPage()
          .navigateToOnlineVariableAugust2013()
          .navigateToDualOrderPage()*/
	          .yourOrderAnonymousNavigation(acquisition,userProfile)
	          .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
	          .gasDefaultCurrentServicesPageNavigation(acquisition)
	          .QuarterlyCashCheque(acquisition)
	          .reviewOrderPageNavigation()
	          .verifyThankYouPage(userProfile)
	          .verifyEshopLeadData()
	          .getEshopLeadID()
	          .verifyAuditEventID(userProfile)
	          .domarssalesRunBatch(acquisition.getShopBatch())
	          .checkMediaCode(acquisition.getDualonlineenergyTariffCode())
	          .deleteWTP(userProfile)
	          .backToHomePage();
          

//		        Pure Acquisition_ES_93
          userProfile.setNectarValue("3");
		         acquisition.setGasSupplier("EDF Energy");
		         acquisition.setElecSupplier("EDF Energy");
		     	acquisition.setFuelType("dual");
		     	acquisition.setPaymentType("MonthlyDD");
		     	acquisition.setCurrentGasSupplier("Credit Meter");
		     	acquisition.setCurrentElecSupplier("Two Rate / Economy 7 Credit");
		          new HomePageAction()	          
		          .navigateToGasAndElectricityPage1()
		          /*.navigateToOurTariffsPage()
		          .navigateToOnlineVariableAugust2013()
		          .navigateToDualOrderPage()*/
			          .yourOrderAnonymousNavigation(acquisition,userProfile)
			          .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
			          .gasDefaultCurrentServicesPageNavigation(acquisition)
			          .QuarterlyCashCheque(acquisition)
			          .reviewOrderPageNavigation()
			          .verifyThankYouPage(userProfile)
			          .verifyEshopLeadData()
			          .getEshopLeadID()
			          .verifyAuditEventID(userProfile)
			          .domarssalesRunBatch(acquisition.getShopBatch())
			          .checkMediaCode(acquisition.getDualonlineenergyTariffCode())
			          .deleteWTP(userProfile)
			          .backToHomePage();
          
//    Pure Acquisition_ES_05
      
		          userProfile.setNectarValue("1");
      acquisition.setGasSupplier("EDF Energy");
      acquisition.setElecSupplier("EDF Energy");
      acquisition.setFuelType("Gas");
      acquisition.setPaymentType("MonthlyVariableDirectDebit");
      acquisition.setCurrentGasSupplier("Credit Meter");
      new HomePageAction()
      .navigateToGasAndElectricityPage1()
      /*.navigateToOurTariffsPage()
      .navigateToOnlineVariableAugust2013()
      .navigateToDualOrderPage()*/
      	  .yourOrderAnonymousNavigation(acquisition,userProfile)
      	  .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
          .gasDefaultCurrentServicesPageNavigation(acquisition)
          .enterPaymentOptions(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyEshopLeadData()
          .getEshopLeadID()
          .verifyAuditEventID(userProfile)
          .domarssalesRunBatch(acquisition.getShopBatch())
          .checkMediaCode(acquisition.getGasonlineenergyTariffCode())
          .deleteWTP(userProfile)
          .backToHomePage();
      
//    Pure Acquisition_ES_06
      userProfile.setNectarValue("2");
      acquisition.setGasSupplier("EDF Energy");
      acquisition.setElecSupplier("EDF Energy");
      acquisition.setFuelType("Gas");
      acquisition.setPaymentType("MonthlyDD");
      acquisition.setCurrentGasSupplier("Credit Meter");
      new HomePageAction()
      .navigateToGasAndElectricityPage1()
      /*.navigateToOurTariffsPage()
      .navigateToOnlineVariableAugust2013()
      .navigateToDualOrderPage()*/
      	  .yourOrderAnonymousNavigation(acquisition,userProfile)
      	  .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
          .gasDefaultCurrentServicesPageNavigation(acquisition)
          .enterPaymentOptions(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyEshopLeadData()
          .getEshopLeadID()
          .verifyAuditEventID(userProfile)
          .domarssalesRunBatch(acquisition.getShopBatch())
          .checkMediaCode(acquisition.getGasonlineenergyTariffCode())
          .deleteWTP(userProfile)
          .backToHomePage();
         
//    Pure Acquisition_ES_08
      userProfile.setNectarValue("4");
      acquisition.setGasSupplier("EDF Energy");
      acquisition.setElecSupplier("EDF Energy");
      acquisition.setFuelType("Gas");
      acquisition.setPaymentType("MonthlyDD");
      acquisition.setCurrentGasSupplier("Credit Meter");
      new HomePageAction()
      .navigateToGasAndElectricityPage1()
      /*.navigateToOurTariffsPage()
      .navigateToOnlineVariableAugust2013()
      .navigateToDualOrderPage()*/
      	  .yourOrderAnonymousNavigation(acquisition,userProfile)
      	  .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
          .gasDefaultCurrentServicesPageNavigation(acquisition)
          .enterPaymentOptions(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyEshopLeadData()
          .getEshopLeadID()
          .verifyAuditEventID(userProfile)
          .domarssalesRunBatch(acquisition.getShopBatch())
          .checkMediaCode(acquisition.getGasonlineenergyTariffCode())
          .deleteWTP(userProfile)
          .backToHomePage();
      

         



      
//    Pure Acquisition_ES_17
      userProfile.setNectarValue("1");
      acquisition.setGasSupplier("EDF Energy");
      acquisition.setElecSupplier("EDF Energy");
      acquisition.setFuelType("Elec");
      acquisition.setPaymentType("MonthlyVariableDirectDebit");
      acquisition.setCurrentElecSupplier("Single Rate Credit");
      new HomePageAction()
      .navigateToGasAndElectricityPage1()
      /*.navigateToOurTariffsPage()
      .navigateToOnlineVariableAugust2013()
      .navigateToDualOrderPage()*/
      	  .yourOrderAnonymousNavigation(acquisition,userProfile)
      	  .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
          .gasDefaultCurrentServicesPageNavigation(acquisition)
          .QuarterlyCashCheque(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyEshopLeadData()
          .getEshopLeadID()
          .verifyAuditEventID(userProfile)
          .domarssalesRunBatch(acquisition.getShopBatch())
          .checkMediaCode(acquisition.getEleconlineenergyTariffCode())
          .deleteWTP(userProfile);   
      
//    Pure Acquisition_ES_19
      userProfile.setNectarValue("3");
      acquisition.setGasSupplier("EDF Energy");
      acquisition.setElecSupplier("EDF Energy");
      acquisition.setFuelType("Elec");
      acquisition.setPaymentType("MonthlyDD");
      acquisition.setCurrentElecSupplier("Single Rate Credit");
      new HomePageAction()
      .navigateToGasAndElectricityPage1()
      /*.navigateToOurTariffsPage()
      .navigateToOnlineVariableAugust2013()
      .navigateToDualOrderPage()*/
      	  .yourOrderAnonymousNavigation(acquisition,userProfile)
      	  .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
          .gasDefaultCurrentServicesPageNavigation(acquisition)
          .QuarterlyCashCheque(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyEshopLeadData()
          .getEshopLeadID()
          .verifyAuditEventID(userProfile)
          .domarssalesRunBatch(acquisition.getShopBatch())
          .checkMediaCode(acquisition.getEleconlineenergyTariffCode())
          .deleteWTP(userProfile);
      
//    Pure Acquisition_ES_20
      userProfile.setNectarValue("4");
      acquisition.setGasSupplier("EDF Energy");
      acquisition.setElecSupplier("EDF Energy");
      acquisition.setFuelType("Elec");
      acquisition.setPaymentType("MonthlyDD");
      acquisition.setCurrentElecSupplier("Single Rate Credit");
      new HomePageAction()
      .navigateToGasAndElectricityPage1()
      /*.navigateToOurTariffsPage()
      .navigateToOnlineVariableAugust2013()
      .navigateToDualOrderPage()*/
      	  .yourOrderAnonymousNavigation(acquisition,userProfile)
      	  .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
          .gasDefaultCurrentServicesPageNavigation(acquisition)
          .QuarterlyCashCheque(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyEshopLeadData()
          .getEshopLeadID()
          .verifyAuditEventID(userProfile)
          .domarssalesRunBatch(acquisition.getShopBatch())
          .checkMediaCode(acquisition.getEleconlineenergyTariffCode())
          .deleteWTP(userProfile);
      
/*//	        Pure Acquisition_ES_49
      userProfile.setNectarValue("4");
      acquisition.setGasSupplier("British Gas");
      acquisition.setElecSupplier("EDF Energy");
      acquisition.setFuelType("Elec");
      acquisition.setPaymentType("MonthlyDD");
      acquisition.setCurrentElecSupplier("Single Rate Credit");
      new HomePageAction()
      .navigateToGasAndElectricityPage1()
      .navigateToOurTariffsPage()
      .navigateToOnlineVariableAugust2013()
      .navigateToDualOrderPage()
      	  .yourOrderAnonymousNavigation(acquisition,userProfile)
      	  .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
          .gasDefaultCurrentServicesPageNavigation(acquisition)
          .QuarterlyCashCheque(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyEshopLeadData()
          .getEshopLeadID()
          .verifyAuditEventID(userProfile)
          .domarssalesRunBatch(acquisition.getShopBatch())
          .checkMediaCode(acquisition.getEleconlineenergyTariffCode())
          .deleteWTP(userProfile);*/
      
//    Pure Acquisition_ES_90
      userProfile.setNectarValue("3");
      acquisition.setGasSupplier("EDF Energy");
      acquisition.setCurrentElecSupplier("EDF Energy");
      acquisition.setFuelType("Elec");
      acquisition.setPaymentType("MonthlyDD");
      acquisition.setCurrentElecSupplier("Single Rate Credit");
      new HomePageAction()
      .navigateToGasAndElectricityPage1()
      /*.navigateToOurTariffsPage()
      .navigateToOnlineVariableAugust2013()
      .navigateToDualOrderPage()*/
      	  .yourOrderAnonymousNavigation(acquisition,userProfile)
      	  .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
          .gasDefaultCurrentServicesPageNavigation(acquisition)
          .QuarterlyCashCheque(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyEshopLeadData()
          .getEshopLeadID()
          .verifyAuditEventID(userProfile)
          .domarssalesRunBatch(acquisition.getShopBatch())
          .checkMediaCode(acquisition.getEleconlineenergyTariffCode())
          .deleteWTP(userProfile);
}

 @Test(groups = {FunctionalCategory.Acquisition})     
 		public void fixedPriceMay2014Acquisition(){
  	
  	  Report.createTestLogHeader("Fixed Price May 2014", "Dual Gas and Elec Acquisition");	      	
  	  final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
      final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");	      
      
//    Pure Acquisition_ES_09
      userProfile.setNectarValue("1");
      acquisition.setGasSupplier("EDF Energy");
      acquisition.setFuelType("Gas");
      acquisition.setPaymentType("MonthlyVariableDirectDebit");	
      acquisition.setCurrentGasSupplier("Credit Meter");
      new HomePageAction()
            	                  	          
          .navigateToGasAndElectricityPage1()
          /*.navigateToOurTariffsPage()
          .navigateToFixedPriceMay2014()
          .navigateToGasOrderPage()*/
          .yourOrderAnonymousNavigation(acquisition,userProfile)
          .enterPersonalDetailsPage(acquisition, userProfile)
          .gasDefaultCurrentServicesPageNavigation(acquisition)
          .QuarterlyCashCheque(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyEshopLeadData()
          .getEshopLeadID()
          .verifyAuditEventID(userProfile)
          .domarssalesRunBatch(acquisition.getShopBatch())  
          .checkMediaCode(acquisition.getGasFP2013TariffCode())
          .deleteWTP(userProfile)
          .backToHomePage();
      

      
      
//        Pure Acquisition_ES_10
      userProfile.setNectarValue("2");
          acquisition.setGasSupplier("EDF Energy");
          acquisition.setFuelType("Gas");
          acquisition.setPaymentType("MonthlyDD");	
          acquisition.setCurrentGasSupplier("Credit Meter");
          new HomePageAction()
                	                  	          
          .navigateToGasAndElectricityPage1()
          /*.navigateToOurTariffsPage()
          .navigateToFixedPriceMay2014()
          .navigateToGasOrderPage()*/
	          .yourOrderAnonymousNavigation(acquisition,userProfile)
	          .enterPersonalDetailsPage(acquisition, userProfile)
	          .gasDefaultCurrentServicesPageNavigation(acquisition)
	          .QuarterlyCashCheque(acquisition)
	          .reviewOrderPageNavigation()
	          .verifyThankYouPage(userProfile)
	          .verifyEshopLeadData()
	          .getEshopLeadID()
	          .verifyAuditEventID(userProfile)
	          .domarssalesRunBatch(acquisition.getShopBatch())  
	          .checkMediaCode(acquisition.getGasFP2013TariffCode())
	          .deleteWTP(userProfile)
	          .backToHomePage();
          
//        Pure Acquisition_ES_11
          userProfile.setNectarValue("3");
          acquisition.setGasSupplier("EDF Energy");
          acquisition.setFuelType("Gas");
          acquisition.setPaymentType("MonthlyDD");	
          acquisition.setCurrentGasSupplier("Credit Meter");
          new HomePageAction()
                	                  	          
          .navigateToGasAndElectricityPage1()
          /*.navigateToOurTariffsPage()
          .navigateToFixedPriceMay2014()
          .navigateToGasOrderPage()*/
	          .yourOrderAnonymousNavigation(acquisition,userProfile)
	          .enterPersonalDetailsPage(acquisition, userProfile)
	          .gasDefaultCurrentServicesPageNavigation(acquisition)
	          .QuarterlyCashCheque(acquisition)
	          .reviewOrderPageNavigation()
	          .verifyThankYouPage(userProfile)
	          .verifyEshopLeadData()
	          .getEshopLeadID()
	          .verifyAuditEventID(userProfile)
	          .domarssalesRunBatch(acquisition.getShopBatch())  
	          .checkMediaCode(acquisition.getGasFP2013TariffCode())
	          .deleteWTP(userProfile)
	          .backToHomePage();
          
//        Pure Acquisition_ES_12
          userProfile.setNectarValue("4");
          acquisition.setGasSupplier("EDF Energy");
          acquisition.setFuelType("Gas");
          acquisition.setPaymentType("MonthlyDD");	
          acquisition.setCurrentGasSupplier("Credit Meter");
          new HomePageAction()
                	                  	          
          .navigateToGasAndElectricityPage1()
          /*.navigateToOurTariffsPage()
          .navigateToFixedPriceMay2014()
          .navigateToGasOrderPage()*/
	          .yourOrderAnonymousNavigation(acquisition,userProfile)
	          .enterPersonalDetailsPage(acquisition, userProfile)
	          .gasDefaultCurrentServicesPageNavigation(acquisition)
	          .QuarterlyCashCheque(acquisition)
	          .reviewOrderPageNavigation()
	          .verifyThankYouPage(userProfile)
	          .verifyEshopLeadData()
	          .getEshopLeadID()
	          .verifyAuditEventID(userProfile)
	          .domarssalesRunBatch(acquisition.getShopBatch())  
	          .checkMediaCode(acquisition.getGasFP2013TariffCode())
	          .deleteWTP(userProfile)
	          .backToHomePage();
          
//        Pure Acquisition_ES_21
          userProfile.setNectarValue("1");
          acquisition.setGasSupplier("EDF Energy");
          acquisition.setFuelType("Gas");
          acquisition.setPaymentType("MonthlyVariableDirectDebit");	
          acquisition.setCurrentGasSupplier("Credit Meter");
          new HomePageAction()
          .navigateToGasAndElectricityPage1()
          /*.navigateToOurTariffsPage()
          .navigateToFixedPriceMay2014()
          .navigateToGasOrderPage()*/
          .yourOrderAnonymousNavigation(acquisition,userProfile)
          .enterPersonalDetailsPage(acquisition, userProfile)
          .enterCurrentServices(acquisition)
          .QuarterlyCashCheque(acquisition)   
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyEshopLeadData() 
          .getEshopLeadID()
          .verifyAuditEventID(userProfile)
          .domarssalesRunBatch(acquisition.getShopBatch()) 
          .checkMediaCode(acquisition.getElecFP2013TariffCode())
          .deleteWTP(userProfile)
          .backToHomePage();
          
//        Pure Acquisition_ES_22
          userProfile.setNectarValue("2");
          acquisition.setGasSupplier("EDF Energy");
          acquisition.setFuelType("Gas");
          acquisition.setPaymentType("MonthlyDD");	
          acquisition.setCurrentGasSupplier("Credit Meter");
          new HomePageAction()
          .navigateToGasAndElectricityPage1()
          /*.navigateToOurTariffsPage()
          .navigateToFixedPriceMay2014()
          .navigateToGasOrderPage()*/
          .yourOrderAnonymousNavigation(acquisition,userProfile)
          .enterPersonalDetailsPage(acquisition, userProfile)
          .enterCurrentServices(acquisition)
          .QuarterlyCashCheque(acquisition)   
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyEshopLeadData() 
          .getEshopLeadID()
          .verifyAuditEventID(userProfile)
          .domarssalesRunBatch(acquisition.getShopBatch()) 
          .checkMediaCode(acquisition.getElecFP2013TariffCode())
          .deleteWTP(userProfile)
          .backToHomePage();
          
//        Pure Acquisition_ES_24
          userProfile.setNectarValue("4");
          acquisition.setGasSupplier("EDF Energy");
          acquisition.setFuelType("Gas");
          acquisition.setPaymentType("MonthlyDD");	
          acquisition.setCurrentGasSupplier("Credit Meter");
          new HomePageAction()
          .navigateToGasAndElectricityPage1()
          /*.navigateToOurTariffsPage()
          .navigateToFixedPriceMay2014()
          .navigateToGasOrderPage()*/
          .yourOrderAnonymousNavigation(acquisition,userProfile)
          .enterPersonalDetailsPage(acquisition, userProfile)
          .enterCurrentServices(acquisition)
          .QuarterlyCashCheque(acquisition)   
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyEshopLeadData() 
          .getEshopLeadID()
          .verifyAuditEventID(userProfile)
          .domarssalesRunBatch(acquisition.getShopBatch()) 
          .checkMediaCode(acquisition.getElecFP2013TariffCode())
          .deleteWTP(userProfile)
          .backToHomePage();
          
          
//        Pure Acquisition_ES_33
          userProfile.setNectarValue("1");
          acquisition.setGasSupplier("EDF Energy");
          acquisition.setFuelType("Gas");
          acquisition.setPaymentType("MonthlyVariableDirectDebit");	
          acquisition.setCurrentGasSupplier("Credit Meter");
          new HomePageAction()
          .navigateToGasAndElectricityPage1()
          /*.navigateToOurTariffsPage()
          .navigateToFixedPriceMay2014()
          .navigateToGasOrderPage()*/
          .yourOrderAnonymousNavigation(acquisition,userProfile)
          .enterPersonalDetailsPage(acquisition, userProfile)
          .enterCurrentServices(acquisition)
          .QuarterlyCashCheque(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyEshopLeadData()
          .getEshopLeadID()
          .verifyAuditEventID(userProfile)
          .domarssalesRunBatch(acquisition.getShopBatch()) 
          .checkMediaCode(acquisition.getDualFP2013TariffCode())
          .deleteWTP(userProfile)
          .backToHomePage();
          
//        Pure Acquisition_ES_34
          userProfile.setNectarValue("2");
          acquisition.setGasSupplier("EDF Energy");
          acquisition.setFuelType("Gas");
          acquisition.setPaymentType("MonthlyDD");	
          acquisition.setCurrentGasSupplier("Credit Meter");
          new HomePageAction()
          .navigateToGasAndElectricityPage1()
          /*.navigateToOurTariffsPage()
          .navigateToFixedPriceMay2014()
          .navigateToGasOrderPage()*/
          .yourOrderAnonymousNavigation(acquisition,userProfile)
          .enterPersonalDetailsPage(acquisition, userProfile)
          .enterCurrentServices(acquisition)
          .QuarterlyCashCheque(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyEshopLeadData()
          .getEshopLeadID()
          .verifyAuditEventID(userProfile)
          .domarssalesRunBatch(acquisition.getShopBatch()) 
          .checkMediaCode(acquisition.getDualFP2013TariffCode())
          .deleteWTP(userProfile)
          .backToHomePage();
          
//        Pure Acquisition_ES_35
          userProfile.setNectarValue("3");
          acquisition.setGasSupplier("EDF Energy");
          acquisition.setFuelType("Gas");
          acquisition.setPaymentType("MonthlyDD");	
          acquisition.setCurrentGasSupplier("Credit Meter");
          new HomePageAction()
          .navigateToGasAndElectricityPage1()
          /*.navigateToOurTariffsPage()
          .navigateToFixedPriceMay2014()
          .navigateToGasOrderPage()*/
          .yourOrderAnonymousNavigation(acquisition,userProfile)
          .enterPersonalDetailsPage(acquisition, userProfile)
          .enterCurrentServices(acquisition)
          .QuarterlyCashCheque(acquisition)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyEshopLeadData()
          .getEshopLeadID()
          .verifyAuditEventID(userProfile)
          .domarssalesRunBatch(acquisition.getShopBatch()) 
          .checkMediaCode(acquisition.getDualFP2013TariffCode())
          .deleteWTP(userProfile)
          .backToHomePage();
}

 		@Test(groups = {Acquisition,Conversion,Zeus,Qtp })
 		public void ConversionGasOnline() {

       Report.createTestLogHeader("Conversion Test", "ConversionGasClearAndSimple");
       final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
       final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
     // getCustomerDetailsToUserProfileOAM(userProfile);
     
  
     //Pure Conversion_CA_13
       acquisition.setFuelType("Gas");
      acquisition.setPaymentType("MonthDD");
       new HomePageAction()                              
               .navigateToGasAndElectricityPage()
               .navigateToOurTariffsPage()
               .navigateToOnlineEnergyTariffPage()
               .navigateToGasOrderPage()
               .yourOrderGasBG(acquisition)             
               .reviewOrderPageNavigation()
               .verifyThankYouPage(userProfile)
               .verifyEshopLeadData()
               .verifyAuditEventID(userProfile)
               .logoutFromConvThankYouPage()
               .changeTariff(userProfile.getGasAccount());    
       
     //Pure Conversion_CA_15
       acquisition.setFuelType("Gas");
      acquisition.setPaymentType("MonthDD");
       new HomePageAction()                              
               .navigateToGasAndElectricityPage()
               .navigateToOurTariffsPage()
               .navigateToOnlineEnergyTariffPage()
               .navigateToGasOrderPage()
               .yourOrderGasBG(acquisition)             
               .reviewOrderPageNavigation()
               .verifyThankYouPage(userProfile)
               .verifyEshopLeadData()
               .verifyAuditEventID(userProfile)
               .logoutFromConvThankYouPage()
               .changeTariff(userProfile.getGasAccount());    
   }	
 		
 		@Test(groups = {Acquisition,Conversion,Zeus,Qtp })
 		public void ConversionDualOnline() {

       Report.createTestLogHeader("Conversion Test", "ConversionGasClearAndSimple");
       final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
       final UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
       //  getCustomerDetailsToUserProfileOAM(userProfile);

       //Pure Conversion_CA_07
       acquisition.setPaymentType("MonthDD");       
       new HomePageAction()
               .navigateToGasAndElectricityPage()
               .navigateToOurTariffsPage()
               .navigateToOnlineEnergyTariffPage()
               .navigateToDualOrderPage()
               .yourOrderDualBG(acquisition)
               .reviewOrderPageNavigation()
               .verifyThankYouPage(userProfile)
               .verifyEshopLeadData()
               .verifyAuditEventID(userProfile)
               .logoutFromConvThankYouPage()
               .changeTariff(userProfile.getGasAccount());
       
     //Pure Conversion_CA_18
     //inactive elec account
       acquisition.setPaymentType("MonthDD");       
       new HomePageAction()
               .navigateToGasAndElectricityPage()
               .navigateToOurTariffsPage()
               .navigateToOnlineEnergyTariffPage()
               .navigateToDualOrderPage()
               .yourOrderDualBG(acquisition)
               .reviewOrderPageNavigation()
               .verifyThankYouPage(userProfile)
               .verifyEshopLeadData()
               .verifyAuditEventID(userProfile)
               .logoutFromConvThankYouPage()
               .changeTariff(userProfile.getGasAccount());
 		}
	
 		@Test(groups = {Acquisition,Conversion,Zeus,Qtp })
 		public void ConversionElecOnline() {

       Report.createTestLogHeader("Conversion Test", "ConversionGasClearAndSimple");
       final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
       final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
       //  getCustomerDetailsToUserProfileOAM(userProfile);

       //Pure Conversion_CA_04
       acquisition.setFuelType("Elec");
       acquisition.setPaymentType("MonthDD");       
       new HomePageAction()
               .navigateToGasAndElectricityPage()
               .navigateToOurTariffsPage()
               .navigateToOnlineEnergyTariffPage()
               .navigateToElecOrderPage()
               .yourOrderElecBG(acquisition)
               .reviewOrderPageNavigation()
               .verifyThankYouPage(userProfile)
               .verifyEshopLeadData()
               .verifyAuditEventID(userProfile)
               .logoutFromConvThankYouPage()
               .changeTariff(userProfile.getGasAccount());
     //Pure Conversion_CA_05  
       acquisition.setFuelType("Elec");
       acquisition.setPaymentType("MonthDD");       
       new HomePageAction()
               .navigateToGasAndElectricityPage()
               .navigateToOurTariffsPage()
               .navigateToFixedPriceMay2014()
               .navigateToElecOrderPage()
               .forcedLoginOnly(acquisition, userProfile)
               .enterPersonalDetailsPage(acquisition, userProfile)
               .reviewOrderPageNavigation()
               .verifyThankYouPage(userProfile)
               .verifyEshopLeadData()
               .verifyAuditEventID(userProfile)
               .logoutFromConvThankYouPage()
               .changeTariff(userProfile.getGasAccount());
     //Pure Conversion_CA_06  
       acquisition.setFuelType("Elec");
       acquisition.setPaymentType("MonthDD");       
       new HomePageAction()
               .navigateToGasAndElectricityPage()
               .navigateToOurTariffsPage()
               .navigateToClearAndSimple()
               .navigateToGasOrderPage()
               .forcedRegisrationOnly(acquisition, userProfile)
               .enterPersonalDetailsPage(acquisition, userProfile)
               .reviewOrderPageNavigation()
               .verifyThankYouPage(userProfile)
               .verifyEshopLeadData()
               .verifyAuditEventID(userProfile)
               .logoutFromConvThankYouPage()
               .changeTariff(userProfile.getGasAccount());
       
     //Pure Conversion_CA_13
       acquisition.setPaymentType("MonthDD");       
       new HomePageAction()
               .navigateToGasAndElectricityPage()
               .navigateToOurTariffsPage()
               .navigateToClearAndSimple()
               .navigateToGasOrderPage()
               .forcedLoginOnly(acquisition, userProfile)
               .enterPersonalDetailsPage(acquisition, userProfile)
               .reviewOrderPageNavigation()
               .verifyThankYouPage(userProfile)
               .verifyEshopLeadData()
               .verifyAuditEventID(userProfile)
               .logoutFromConvThankYouPage()
               .changeTariff(userProfile.getGasAccount());
   }	
 		
 		 @Test(groups = {Acquisition,Conversion,Zeus,Qtp })
 	    public void ConversionOnlineVariableAugust2013() {
 	          Report.createTestLogHeader("Conversion Test", "Gas Account Conversion OnlineVariableAugust2013");
 	          final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
 	          final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
 	          //getCustomerDetailsToUserProfileOAM(userProfile);
 
 	          
 	       //Pure Conversion_CA_10
  	         acquisition.setPaymentType("MonthDD");  
  	          new HomePageAction()
  	                  .navigateToLogin()
  	                  .login(userProfile)               
  	                  .navigateToGasAndElectricityPage()
  	                  .navigateToOurTariffsPage()
  	                  .navigateToOnlineVariableAugust2013()
  	                  .navigateToDualOrderPage()
  	                  .yourOrderDualBG(acquisition)
  	                  .reviewOrderPageNavigation()
  	                  .verifyThankYouPage(userProfile)
  	                  .verifyEshopLeadData()
  	                  .verifyAuditEventID(userProfile)
  	                  .logoutFromConvThankYouPage()
  	                  .changeTariff(userProfile.getAccNumber());

 	      }
 
 		 @Test(groups = {Acquisition,Conversion,Zeus,Qtp })
        
 		public void verifyAnonymousEnergyShopJourneyElec() {
 	        Report.createTestLogHeader("Get A Price", "Energy Shop Anonymous Journey");
 	        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
 	        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
 	        UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
 	        
 	     //Pure Conversion_CA_01
 	       acquisition.setFuelType("Gas");
  	       acquisition.setPaymentType("MonthDD");
  	        new HomePageAction()
  	                .navigateToGasAndElectricityPage()
  	                .navigateToGetAPricePage()
  	                .verifyAndEnterGAPDetails(getaPrice, userProfile)
  	                .switchTariff(getaPrice)
  	                .yourOrderAnonymousNavigation(acquisition,userProfile)
  	                .enterPersonalDetailsPage(acquisition, userProfile)
  	                .enterCurrentServices(acquisition)
  	                .enterPaymentOptions(acquisition)
  	                .reviewOrderPageNavigation()
  	                .verifyThankYouPage(userProfile)
  	                .getLeadID()
  	                .verifyLeadData()
  	                .domarssalesRunBatch(acquisition.getShopBatch())
  	                .backToHomePage();
 	       //Pure Conversion_CA_02
  	      acquisition.setFuelType("Gas");
 	       acquisition.setPaymentType("MonthDD");
 	        new HomePageAction()
 	                .navigateToGasAndElectricityPage()
 	                .navigateToGetAPricePage()
 	                .verifyAndEnterGAPDetails(getaPrice, userProfile)
 	                .switchTariff(getaPrice)
 	                .forcedLoginOnly(acquisition, userProfile)
 	                .enterPersonalDetailsPage(acquisition, userProfile)
 	                .enterCurrentServices(acquisition)
 	                .enterPaymentOptions(acquisition)
 	                .reviewOrderPageNavigation()
 	                .verifyThankYouPage(userProfile)
 	                .getLeadID()
 	                .verifyLeadData()
 	                .domarssalesRunBatch(acquisition.getShopBatch())
 	                .backToHomePage();
 	        
 	     //Pure Conversion_CA_09
  	       
 	       acquisition.setFuelType("dual");
  	       acquisition.setPaymentType("MonthDD");
  	        new HomePageAction()
  	                .navigateToGasAndElectricityPage()
  	                .navigateToGetAPricePage()
  	                .verifyAndEnterGAPDetails(getaPrice, userProfile)
  	                .switchTariff(getaPrice)
  	                .forcedRegisrationOnly(acquisition, userProfile)
  	                .enterPersonalDetailsPage(acquisition, userProfile)
  	                .enterCurrentServices(acquisition)
  	                .enterPaymentOptions(acquisition)
  	                .reviewOrderPageNavigation()
  	                .verifyThankYouPage(userProfile)
  	                .getLeadID()
  	                .verifyLeadData()
  	                .domarssalesRunBatch(acquisition.getShopBatch())
  	                .backToHomePage();
  	        
  	    //Pure Conversion_CA_12
   	       
  	       acquisition.setFuelType("dual");
   	       acquisition.setPaymentType("MonthDD");
   	        new HomePageAction()
   	                .navigateToGasAndElectricityPage()
   	                .navigateToGetAPricePage()
   	                .verifyAndEnterGAPDetails(getaPrice, userProfile)
   	                .switchTariff(getaPrice)
   	                .forcedLoginOnly(acquisition, userProfile)
   	                .enterPersonalDetailsPage(acquisition, userProfile)
   	                .enterCurrentServices(acquisition)
   	                .enterPaymentOptions(acquisition)
   	                .reviewOrderPageNavigation()
   	                .verifyThankYouPage(userProfile)
   	                .getLeadID()
   	                .verifyLeadData()
   	                .domarssalesRunBatch(acquisition.getShopBatch())
   	                .backToHomePage();
   	        
   	     //Pure Conversion_CA_14
    	       
   	       acquisition.setFuelType("dual");
    	       acquisition.setPaymentType("MonthDD");
    	        new HomePageAction()
    	                .navigateToGasAndElectricityPage()
    	                .navigateToGetAPricePage()
    	                .verifyAndEnterGAPDetails(getaPrice, userProfile)
    	                .switchTariff(getaPrice)
    	                .forcedRegisrationOnly(acquisition, userProfile)
    	                .enterPersonalDetailsPage(acquisition, userProfile)
    	                .enterCurrentServices(acquisition)
    	                .enterPaymentOptions(acquisition)
    	                .reviewOrderPageNavigation()
    	                .verifyThankYouPage(userProfile)
    	                .getLeadID()
    	                .verifyLeadData()
    	                .domarssalesRunBatch(acquisition.getShopBatch())
    	                .backToHomePage();
 	    }
 		
 		 @Test(groups = {Acquisition,Conversion,Zeus,Qtp })
        public void ConversionJIOnline() {

           Report.createTestLogHeader("Conversion Test", "Conversion JI Account Online");
           GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
           final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
           final UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
           //getCustomerDetailsToUserProfileOAM(userProfile);
           
           //Pure Conversion_CA_11
 	       acquisition.setFuelType("JI");
  	       acquisition.setPaymentType("MonthDD");
           new HomePageAction()
                   .navigateToLogin()
                   .login(userProfile)                
                   .navigateToGasAndElectricityPage()
                   .navigateToOurTariffsPage()
                   .navigateToOnlineEnergyTariffPage()
                   .navigateToDualOrderPage()
                   .yourOrderDualBG(acquisition)
                   .reviewOrderPageNavigation()
                   .verifyThankYouPage(userProfile)
                   .verifyEshopLeadData()
                   .verifyAuditEventID(userProfile)
                   .logoutFromConvThankYouPage()
                   .changeTariff(userProfile.getAccNumber());
           
           //Pure Conversion_CA_17
 	       acquisition.setFuelType("JI");
  	       acquisition.setPaymentType("MonthDD");
           new HomePageAction()                               
           .navigateToGasAndElectricityPage()
           .navigateToGetAPricePage()
           .verifyAndEnterGAPDetails(getaPrice, userProfile)
           .switchTariff(getaPrice)
           .forcedRegisrationOnly(acquisition, userProfile)
           .enterPersonalDetailsPage(acquisition, userProfile)                  
                   .reviewOrderPageNavigation()
                   .verifyThankYouPage(userProfile)
                   .verifyEshopLeadData()
                   .verifyAuditEventID(userProfile)
                   .logoutFromConvThankYouPage()
                   .changeTariff(userProfile.getAccNumber());
       }
 		 
 		 
 		@Test(groups = {Acquisition,Conversion,Zeus,Qtp })
 		 public void pureConversionEStoESJI()
 		 {
 			 Report.createTestLogHeader("Esmart Conversion", "Energy Account Energy smart to Energy smart");
 	         final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
 	         UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
 	         
 	         acquisition.setTarifffordual(acquisition.gettariffClearSimple());
 	         new HomePageAction()
 	         	.navigateToLogin()
	            .login(userProfile)
	            .navigateToProductAndServicesPage()
	            .navigateToGasAndElectricityPage()
	            .navigateToOurTariffsPage()
	            .navigateToClearAndSimple()
	            .navigateToEnergySmartDualOrderPage()
	            .yourOrderDualBG(acquisition)
	            .dualEnergysmartOrderDual(acquisition)
   				.verifyThankYouPage(userProfile)
   				.backToHomePage();
 	         
 	         acquisition.setTarifffordual(acquisition.gettariffOnlineVariable());
 	         new HomePageAction()
         		.navigateToLogin()
         		.login(userProfile)
         		.navigateToProductAndServicesPage()
         		.navigateToGasAndElectricityPage()
         		.navigateToOurTariffsPage()
         		.navigateToFixedPriceMay2014()
           		.navigateToEnergySmartDualOrderPage()
           		.yourOrderDualBG(acquisition)
           		.dualEnergysmartOrderDual(acquisition)
   				.verifyThankYouPage(userProfile)
   				.backToHomePage();
 	        
 	         acquisition.setTarifffordual(acquisition.gettariffFixFall());
 	       	 new HomePageAction()
   				.navigateToLogin()
   				.login(userProfile)
   				.navigateToProductAndServicesPage()
   				.navigateToGasAndElectricityPage()
   				.navigateToOurTariffsPage()
   				.navigateToOnlineVariableAugust2013()
   				.navigateToEnergySmartDualOrderPage()
   				.yourOrderDualBG(acquisition)
   				.dualEnergysmartOrderDual(acquisition)
   				.verifyThankYouPage(userProfile)
   				.backToHomePage();
 	         
 		 }
 		
 		
 		
 		@Test(groups = {Acquisition,Conversion,Zeus,Qtp })
		 public void pureConversionEStoESGas()
		 {
			 Report.createTestLogHeader("Esmart Conversion", "Gas Account Energy smart to Energy smart");
	         final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	         UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	         
	         acquisition.setTariffforgas(acquisition.gettariffClearSimple());
	         new HomePageAction()
	         	.navigateToLogin()
	            .login(userProfile)
	            .navigateToProductAndServicesPage()
	            .navigateToGasAndElectricityPage()
	            .navigateToOurTariffsPage()
	            .navigateToClearAndSimple()
	            .navigateToEnergySmartGasOrderPage()
	            .yourOrderGasBG(acquisition)
	            .energySmartGasBGOrderGas(acquisition)
	            .verifyThankYouPage(userProfile)
	            .logoutFromThankYouPage();
	         
	         acquisition.setTariffforgas(acquisition.gettariffOnlineVariable());
	        new HomePageAction()
	         	.navigateToLogin()
	         	.login(userProfile)
	         	.navigateToProductAndServicesPage()
	         	.navigateToGasAndElectricityPage()
	         	.navigateToOurTariffsPage()
	         	.navigateToOnlineVariableAugust2013()
	         	.navigateToEnergySmartGasOrderPage()
	            .yourOrderGasBG(acquisition)
	            .energySmartGasBGOrderGas(acquisition)
	            .verifyThankYouPage(userProfile)
	            .logoutFromThankYouPage();
	        
	        acquisition.setTariffforgas(acquisition.gettariffFixFall());
	       new HomePageAction()
        		.navigateToLogin()
        		.login(userProfile)
        		.navigateToProductAndServicesPage()
        		.navigateToGasAndElectricityPage()
        		.navigateToOurTariffsPage()
        		.navigateToFixedPriceMay2014()
          		.navigateToEnergySmartGasOrderPage()
	            .yourOrderGasBG(acquisition)
	            .energySmartGasBGOrderGas(acquisition)
          		.verifyThankYouPage(userProfile)
          		.logoutFromThankYouPage();
	         
		 }
 		
 		
 		@Test(groups = {Acquisition,Conversion,Zeus,Qtp })
		 public void pureConversionEStoESElec()
		 {
			 Report.createTestLogHeader("Esmart Conversion", "Elec Account Energy smart to Energy smart");
	         final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	         UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	         
	         acquisition.setTariffforelectricity(acquisition.gettariffClearSimple());
	         new HomePageAction()
	         	.navigateToLogin()
	            .login(userProfile)
	            .navigateToProductAndServicesPage()
	            .navigateToGasAndElectricityPage()
	            .navigateToOurTariffsPage()
	            .navigateToClearAndSimple()
	            .navigateToEnergySmartElectricityOrderPage()
	            .yourOrderElecBG(acquisition)
	            .energySmartElecBGOrderElec(acquisition)
	            .verifyThankYouPage(userProfile)
	            //.backToHomePage();
	            .logoutFromThankYouPage();
	         
	        
	        acquisition.setTariffforelectricity(acquisition.gettariffFixFall());
	       new HomePageAction()
       			.navigateToLogin()
       			.login(userProfile)
       			.navigateToProductAndServicesPage()
       			.navigateToGasAndElectricityPage()
       			.navigateToOurTariffsPage()
       			.navigateToFixedPriceMay2014()
         		.navigateToEnergySmartElectricityOrderPage()
	            .yourOrderElecBG(acquisition)
	            .energySmartElecBGOrderElec(acquisition)
         		.verifyThankYouPage(userProfile)
         		//.backToHomePage()
         		.logoutFromThankYouPage();
         		
	       
	       acquisition.setTariffforelectricity(acquisition.gettariffOnlineVariable());
	      new HomePageAction()
 				.navigateToLogin()
 				.login(userProfile)
 				.navigateToProductAndServicesPage()
 				.navigateToGasAndElectricityPage()
 				.navigateToOurTariffsPage()
 				.navigateToOnlineVariableAugust2013()
 				.navigateToEnergySmartElectricityOrderPage()
	            .yourOrderElecBG(acquisition)
	            .energySmartElecBGOrderElec(acquisition)
 				.verifyThankYouPage(userProfile)
 				//.backToHomePage();
	      		.logoutFromThankYouPage();
	         
		 }
 		
 		
 		@Test(groups = {Acquisition,Conversion,Zeus,Qtp })
		 public void pureConversionEStoESDual()
		 {
			 Report.createTestLogHeader("Esmart Conversion", "Energy Account Energy smart to Energy smart");
	         final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	         UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
	         
	         acquisition.setTarifffordual(acquisition.gettariffClearSimple());
 	         new HomePageAction()
 	         	.navigateToLogin()
	            .login(userProfile)
	            .navigateToProductAndServicesPage()
	            .navigateToGasAndElectricityPage()
	            .navigateToOurTariffsPage()
	            .navigateToClearAndSimple()
	            .navigateToEnergySmartDualOrderPage()
	            .yourOrderDualBG(acquisition)
	            .dualEnergysmartOrderDual(acquisition)
   				.verifyThankYouPage(userProfile)
   				.backToHomePage();
 	         
 	         acquisition.setTarifffordual(acquisition.gettariffOnlineVariable());
 	         new HomePageAction()
         		.navigateToLogin()
         		.login(userProfile)
         		.navigateToProductAndServicesPage()
         		.navigateToGasAndElectricityPage()
         		.navigateToOurTariffsPage()
         		.navigateToFixedPriceMay2014()
           		.navigateToEnergySmartDualOrderPage()
           		.yourOrderDualBG(acquisition)
           		.dualEnergysmartOrderDual(acquisition)
   				.verifyThankYouPage(userProfile)
   				.backToHomePage();
 	        
 	         acquisition.setTarifffordual(acquisition.gettariffFixFall());
 	       	 new HomePageAction()
   				.navigateToLogin()
   				.login(userProfile)
   				.navigateToProductAndServicesPage()
   				.navigateToGasAndElectricityPage()
   				.navigateToOurTariffsPage()
   				.navigateToOnlineVariableAugust2013()
   				.navigateToEnergySmartDualOrderPage()
   				.yourOrderDualBG(acquisition)
   				.dualEnergysmartOrderDual(acquisition)
   				.verifyThankYouPage(userProfile)
   				.backToHomePage();
	         
		 }
 		
 		
 		@Test(groups = {Acquisition,Conversion,Zeus,Qtp })
 		public void pureConversionMCGas()
 		{
 			Report.createTestLogHeader("Esmart Conversion", "Energy Account Energy smart to Energy smart");
	        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
 			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage()
				.navigateToOnlineVariableAugust2013()
				.navigateToEnergySmartGasOrderPage()
				.yourOrderGasBG(acquisition)
                .gasBGEnergySmartGasConversion(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .logoutFromThankYouPage();
 		}
 		
 		
 		
 		@Test(groups = {Acquisition})
 	    public void pureConversionMCElec() {
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
 	                .yourOrderElecBG(acquisition)
 	                .elecBGEnergySmartElecConversion(acquisition)
 	                .enterPaymentOptions(acquisition)
 	                .reviewOrderPageNavigation()
 	                .verifyThankYouPage(userProfile)
 	                .verifyLeadData()
 	                .logoutFromThankYouPage();
 	    }
 		
 		
 		
 		@Test(groups = {Acquisition})
 	    public void pureConversionMCDual() {
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
 	                .navigateToClearAndSimple()
 	                .navigateToEnergySmartDualOrderPage()
 	                .yourOrderDualBG(acquisition)
 	                .gasBGEnergySmartDualOrder(acquisition)
 	                .enterPaymentOptions(acquisition)
 	                .reviewOrderPageNavigation()
 	                .verifyThankYouPage(userProfile)
 	                .verifyLeadData()
 	                .logoutFromThankYouPage();
 	    }
 		
 		@Test(groups = {Acquisition,Conversion,Zeus,Qtp })
        public void conversionCTGas() {

           Report.createTestLogHeader("Conversion Testtt", "Change Tariff for Gas Account");
           final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
           final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
          
           //CT_01,02,03
           userProfile.setNectarValue("4");
	       acquisition.setGasSupplier("British Gas");
           acquisition.setElecSupplier("British Gas");
           acquisition.setFuelType("dual");
           acquisition.setTariff("clear-and-simple");
           new HomePageAction()
           		.navigateToLogin()
           		.login(userProfile)
	            .navigateToGasAndElectricityPage()
           		.navigateToOurTariffsPage()
           		.navigateToClearAndSimple()
           		.navigateToEnergySmartGasOrderPage()
           		.yourOrderGasBG(acquisition)   
           		.gasBGEnergySmartGasConversion(acquisition)
           		.enterPaymentOptions(acquisition)
           		.reviewOrderPageNavigation()
           		.verifyThankYouPage(userProfile)
           		.verifyEshopLeadData()
           		.verifyAuditEventID(userProfile)
           		.logoutFromConvThankYouPage();
           
           acquisition.setTariff("online-variable-february-2014");
           new HomePageAction()
      			.navigateToLogin()
      			.login(userProfile)
      			.navigateToGasAndElectricityPage()
      			.navigateToOurTariffsPage()
      			.navigateToOnlineVariableAugust2013()
      			.navigateToEnergySmartGasOrderPage()
      			.yourOrderGasBG(acquisition)   
      			.gasBGEnergySmartGasConversion(acquisition)
      			.enterPaymentOptions(acquisition)
      			.reviewOrderPageNavigation()
      			.verifyThankYouPage(userProfile)
      			.verifyEshopLeadData()
      			.verifyAuditEventID(userProfile)
      			.logoutFromConvThankYouPage();
           
           acquisition.setTariff("fix-and-fall-march-2014");
           new HomePageAction()
 				.navigateToLogin()
 				.login(userProfile)
 				.navigateToGasAndElectricityPage()
 				.navigateToOurTariffsPage()
 				.navigateToFixedPriceMay2014()
 				.navigateToEnergySmartGasOrderPage()
 				.yourOrderGasBG(acquisition)   
 				.gasBGEnergySmartGasConversion(acquisition)
 				.enterPaymentOptions(acquisition)
 				.reviewOrderPageNavigation()
 				.verifyThankYouPage(userProfile)
 				.verifyEshopLeadData()
 				.verifyAuditEventID(userProfile)
 				.logoutFromConvThankYouPage();
 		}
 		 

 		@Test(groups = {Acquisition,Conversion,Zeus,Qtp })
        public void conversionCTElec() {

           Report.createTestLogHeader("Conversion Test", "Change Tariff for Gas Account");
           final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
           final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
          
           //CT_01,02,03
           userProfile.setNectarValue("4");
	       acquisition.setGasSupplier("British Gas");
           acquisition.setElecSupplier("British Gas");
           acquisition.setFuelType("dual");
           acquisition.setTariff("clear-and-simple");
           new HomePageAction()
 				.navigateToLogin()
 				.login(userProfile)
 				.navigateToGasAndElectricityPage()
 				.navigateToOurTariffsPage()
 				.navigateToClearAndSimple()
 				.navigateToEnergySmartGasOrderPage()
 				.yourOrderGasBG(acquisition)   
 				.elecBGEnergySmartElecConversion(acquisition)
 				.enterPaymentOptions(acquisition)
 				.reviewOrderPageNavigation()
 				.verifyThankYouPage(userProfile)
 				.verifyEshopLeadData()
 				.verifyAuditEventID(userProfile)
 				.logoutFromConvThankYouPage();
           
           acquisition.setTariff("online-variable-february-2014");
           new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage()
				.navigateToClearAndSimple()
				.navigateToEnergySmartGasOrderPage()
				.yourOrderGasBG(acquisition)   
				.elecBGEnergySmartElecConversion(acquisition)
				.enterPaymentOptions(acquisition)
				.reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile)
				.verifyEshopLeadData()
				.verifyAuditEventID(userProfile)
				.logoutFromConvThankYouPage();
           	
           
           
 		}


 		@Test(groups = {Acquisition,Conversion,Zeus,Qtp })

 		public void conversionCTDual()
 		{
	
 			Report.createTestLogHeader("Conversion Test", "Change Tariff for Gas Account");
 			final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
 			final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
   
 			//CT_01,02,03
 			userProfile.setNectarValue("4");
 			acquisition.setGasSupplier("British Gas");
 			acquisition.setElecSupplier("British Gas");
 			acquisition.setFuelType("dual");
 			acquisition.setTariff("online-variable-february-2014");
 			new HomePageAction()
 				.navigateToLogin()
 				.login(userProfile)
 				.navigateToProductAndServicesPage()
 				.navigateToGasAndElectricityPage()
 				.navigateToOurTariffsPage()
 				.navigateToOnlineVariableAugust2013()
 				.navigateToEnergySmartDualOrderPage()
 				.yourOrderDualBG(acquisition)
 				.gasBGEnergySmartDualOrder(acquisition)
 				.enterPaymentOptions(acquisition)
				.reviewOrderPageNavigation()
 				.verifyThankYouPage(userProfile)
 				.verifyEshopLeadData()
 				.verifyAuditEventID(userProfile)
 				.logoutFromConvThankYouPage();
 			
 			
 			userProfile.setNectarValue("4");
 			acquisition.setGasSupplier("British Gas");
 			acquisition.setElecSupplier("British Gas");
 			acquisition.setFuelType("dual");
 			acquisition.setTariff("clear-and-simple");
 			new HomePageAction()
 				.navigateToLogin()
 				.login(userProfile)
 				.navigateToProductAndServicesPage()
 				.navigateToGasAndElectricityPage()
 				.navigateToOurTariffsPage()
 				.navigateToClearAndSimple()
 				.navigateToEnergySmartDualOrderPage()
 				.yourOrderDualBG(acquisition)
 				.gasBGEnergySmartDualOrder(acquisition)
 				.enterPaymentOptions(acquisition)
				.reviewOrderPageNavigation()
 				.verifyThankYouPage(userProfile)
 				.verifyEshopLeadData()
 				.verifyAuditEventID(userProfile)
 				.logoutFromConvThankYouPage();
 			
	

}


 		public void conversionCTJI()
 		{
 			//same as dual need to check the functionality
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
 	                .yourOrderGasBG(acquisition)
 	                .inEligibleEnergySmartMessage()
 	                .logoutFromThankYouPage()
 	                
 	                .navigateToLogin()
 	                .login(userProfile)
 	                .navigateToProductAndServicesPage()
 	                .navigateToGasAndElectricityPage()
 	                .navigateToOurTariffsPage()
 	                .navigateToOnlineVariableAugust2013()
 	                .navigateToEnergySmartDualOrderPage()
 	                .yourOrderGasBG(acquisition)
 	                .inEligibleEnergySmartMessage()
 	                .logoutFromThankYouPage();

 	    }
}
