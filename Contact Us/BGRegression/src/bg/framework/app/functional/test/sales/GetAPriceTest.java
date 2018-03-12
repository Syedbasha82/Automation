package bg.framework.app.functional.test.sales;

import bg.framework.app.functional.action.common.HomePageAction;

import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.GetAPrice;
import bg.framework.app.functional.entities.GetAPricePageProfile;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import bg.framework.app.functional.action.sales.AcquisitionAction;
import bg.framework.app.functional.action.sales.GetAPriceAction;
import org.testng.annotations.Test;

import bg.framework.app.functional.action.sales.GasAndElectricityAction;


import static bg.framework.app.functional.entities.FunctionalCategory.*;

public class GetAPriceTest extends TestBase {

    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP})
    public void verifyAnonymousJourney() {
        try{
        Report.createTestLogHeader("Get A Price", "AnonymousJourney");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
       // new HomePageAction()
           //   .navigateToGasAndElectricityPage();
       new GasAndElectricityAction()
                .navigateToGetAPricePage()
                .verifyAndEnterGAPAnonymousDetails(getaPrice);
        }catch(Exception e){
            e.printStackTrace();
            Report.updateTestLog("Unexpected error", "FAIL");
        }
    }
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Regression})
    public void newVerifyAnonymousCurrentSupplier(){
    	 
    	        Report.createTestLogHeader("Get A Price", "New Anonymous Current Supplier");
    	        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
    	     
    	       new GetAPriceAction()
    	        		.navigateToGetAQuotePage()
    	        		.enterAnonymousDetails();
    }
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Regression})
    public void newVerifyOAMCurrentSupplier(){
    	 
    	       Report.createTestLogHeader("Get A Price", "New OAM Current Supplier");
    	       GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
    	       UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
    	       new HomePageAction()
    	                .navigateToLogin()
    	                .login(userProfile);
    	       new GetAPriceAction()
    	        		.navigateToGetAQuotePage()
    	        		.enterAnonymousDetails();
    }
    
    
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Saber,SalesRegressionAnonymous})
    public void newVerifyAnonymousJourney(){
    	 
    	        Report.createTestLogHeader("Get A Price", "New Anonymous Journey");
    	        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
    	     
    	       new GetAPriceAction()
    	        		.navigateToGetAQuotePage()
    	                .enterGAPAnonymousDetails()
    	                .runBatchGetAQuote()
    	                .verifyLeadDB();
    }
    
    
    
    @SuppressWarnings("unchecked")
    @Test(groups = {GAP})
    public void verifyOAMJourney() {
        try{
        Report.createTestLogHeader("Get A Price", "OAM Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
       // getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile);
                  new GasAndElectricityAction()
                .navigateToGetAPricePage()
             /*   .navigateToGasAndElectricityPage()
                .navigateToGetAPricePage()*/
                .verifyAndEnterOAMGAPDetails(getaPrice,userProfile); 
                  
        }catch(Exception e){
            e.printStackTrace();
            Report.updateTestLog("Unexpected error"+e.getMessage(), "FAIL");
        }
    }
    
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Saber , SalesRegressionOAM})
    public void newVerifyOAMElecSupplierJourney() {


      
        Report.createTestLogHeader("Get A Price", "Saber OAM Electricity Supplier Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile);
        new GasAndElectricityAction()
                .navigateToGetAPricePage()
                .enterOAMGAPDetails(userProfile)
        		.runBatchGetAQuote()
        		.verifyLeadDB()
        		.logout();
    }
    
    
  
    @SuppressWarnings("unchecked")
    @Test(groups = {Saber , SalesRegressionOAM})
    public void newVerifyOAMElecSupplierPayAsYouGoJourney() {
      
        Report.createTestLogHeader("Get A Price", "Saber OAM Electricity Supplier Pay As You Go Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile);
        new GasAndElectricityAction()
        		.navigateToGetAPricePage()
                .enterOAMGAPPayAsYouGoDetails(userProfile)
        		.runBatchGetAQuote()
        		.verifyLeadDB()
        		.logout();
    }
    
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Saber , SalesRegressionOAM})
    public void newVerifyOAMDualSupplierJourney() {
        Report.createTestLogHeader("Get A Price", "Saber OAM Dual Supplier Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile);
        new GasAndElectricityAction()
        		.navigateToGetAPricePage()
                .enterOAMGAPDualDetails(userProfile) 
        		.runBatchGetAQuote()
        		.verifyLeadDB()
        		.logout();
    }
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Saber , SalesRegressionOAM})
    public void newVerifyOAMDualSupplierPayAsYouGoJourney() {
        Report.createTestLogHeader("Get A Price", "Saber OAM Dual Supplier Pay As You Go Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile);
        new GasAndElectricityAction()
        		.navigateToGetAPricePage()
                .enterOAMGAPDualPayAsYouGoDetails(userProfile) 
                .runBatchGetAQuote()
        		.verifyLeadDB()
        		.logout();
    }
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Saber , SalesRegressionOAM})
    public void newVerifyOAMGasSupplierJourney() {
        try{
        Report.createTestLogHeader("Get A Price", "Saber OAM Gas Supplier Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile); 
        new GasAndElectricityAction()
                .navigateToGetAPricePage()
                .enterOAMGAPGasDetails(userProfile)
        		.runBatchGetAQuote()
				.verifyLeadDB()
				.logout();
        }catch(Exception e){
            e.printStackTrace();
            Report.updateTestLog("Unexpected error"+e.getMessage(), "FAIL");
        }
    }
    
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Saber , SalesRegressionOAM})
    public void newVerifyOAMGasSupplierPayAsYouGoJourney() {
        try{
        Report.createTestLogHeader("Get A Price", "Saber OAM Gas Supplier Pay As You Go Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile);
        new GasAndElectricityAction()
        		.navigateToGetAPricePage()
                .enterOAMGAPGasPayAsYouGoDetails(userProfile)
                .runBatchGetAQuote()
        		.verifyLeadDB()
        		.logout();
        }catch(Exception e){
            e.printStackTrace();
            Report.updateTestLog("Unexpected error"+e.getMessage(), "FAIL");
        }
    }
    
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP, BG})
    public void verifyAllGAPGasSupplierAnonymousJourney() {
        try{
        Report.createTestLogHeader("Get A Price", "Verify All Gas supplier details in Get a Price journey");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
       // new HomePageAction()
       //         .navigateToGasAndElectricityPage()
      //.navigateToGetAPricePage()
        new GasAndElectricityAction()
                .navigateToGetAPricePage()
                .verifyAllGasSupplierGAPDetails(getaPrice);
        	
        }catch(Exception e){
            e.printStackTrace();
            Report.updateTestLog("Unexpected error", "FAIL");
        }
    }
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Saber,SalesRegressionAnonymous})
    public void newVerifyAllGAPGasSupplierAnonymousJourney() {

        
        Report.createTestLogHeader("Get A Price", "New Verify All Anonymous Gas supplier details in Get a Price journey");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
        new GetAPriceAction()
        		.navigateToGetAQuotePage()
                .newVerifyAllGasSupplierGAPDetails(getaPrice)
        		.runBatchGetAQuote()
        		.verifyLeadDB();
    }
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Saber,SalesRegressionAnonymous})
    public void newVerifyAllGAPGasSupplierPayAsYouGoAnonymousJourney() {
        
        Report.createTestLogHeader("Get A Price", "New Verify All Anonymous Gas supplier Pay As Go in Get a Price journey");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
        new GetAPriceAction()
        		.navigateToGetAQuotePage()
                .newVerifyAllGasSupplierGAPPayAsYouGoDetails(getaPrice)
        		.runBatchGetAQuote()
        		.verifyLeadDB();
    }
    

    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP, BG})
    public void verifyAllGAPElectricitySupplierAnonymousJourney(){
        try{
        Report.createTestLogHeader("Get A Price", "Verify All Electricity supplier in Get a Price Journey");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
       /* new HomePageAction()
                .navigateToGasAndElectricityPage()
                .navigateToGetAPricePage()*/
       new GasAndElectricityAction()
                .navigateToGetAPricePage()
                .verifyAllElecSupplierGAPDetails(getaPrice); ;
        }catch(Exception e){
            e.printStackTrace();
            Report.updateTestLog("Unexpected error", "FAIL");
        }
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {Saber,SalesRegressionAnonymous})
    public void newVerifyAllGAPElectricitySupplierAnonymousJourney() {
      
        Report.createTestLogHeader("Get A Price", "New Verify All Anonymous Electricity supplier in Get a Price Journey");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
        new GetAPriceAction()
				.navigateToGetAQuotePage()
                .newVerifyAllElecSupplierGAPDetails(getaPrice)
                .runBatchGetAQuote()
                .verifyLeadDB();
        }

    
    public void verifyAllDualSupplierAnonymous() {
        try{
        Report.createTestLogHeader("Get A Price", "Verify All Gas supplier details in Get a Price journey");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
      
        new GasAndElectricityAction()
                .navigateToGetAPricePage()
                .verifyAllGasSupplierGAPDetails(getaPrice);
        
        new GasAndElectricityAction()
        
        .navigateToGetAPricePage()
        .verifyAllGasSupplierGAPDetails(getaPrice);
        	
        }catch(Exception e){
            e.printStackTrace();
            Report.updateTestLog("Unexpected error", "FAIL");
        }
    }
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Saber,SalesRegressionAnonymous})
    public void newVerifyAllGAPElectricitySupplierPayAsYouGoAnonymousJourney() {
      
        Report.createTestLogHeader("Get A Price", "New Verify All Anonymous Electricity supplier Pay As Go in Get a Price journey");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
        new GetAPriceAction()
				.navigateToGetAQuotePage()
                .newVerifyAllElecSupplierPayAsYouGoGAPDetails(getaPrice)
                .runBatchGetAQuote()
                .verifyLeadDB();
        }

    
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP, BG})
    public void verifyGAPDualFuelAnonymousJourney() {
       
        Report.createTestLogHeader("Get A Price", "Verify All Anonymous Dual Fuel Details");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
     /*   new HomePageAction()
        .navigateToGasAndElectricityPage()
        .navigateToGetAPricePage()*/
     new GasAndElectricityAction()
        .navigateToGetAPricePage()
        .verifyAllDualSupplierGAPDetails(getaPrice);
       
        }

    @SuppressWarnings("unchecked")
    @Test(groups = {Saber,SalesRegressionAnonymous})
    public void newVerifyGAPDualFuelAnonymousJourney() {

   
        Report.createTestLogHeader("Get A Price", "New Verify All Anonymous Dual Fuel Details");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
        new GetAPriceAction()
			.navigateToGetAQuotePage()
			.newVerifyAllDualSupplierGAPDetails(getaPrice)
        	.runBatchGetAQuote()
        	.verifyLeadDB();
      
    }
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Saber,SalesRegressionAnonymous})
    public void newVerifyGAPDualFuelPayAsYouGoAnonymousJourney() {
   
        Report.createTestLogHeader("Get A Price", "New Verify All Anonymous Dual Fuel Pay As  You Go Details");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
        new GetAPriceAction()
			.navigateToGetAQuotePage()
			.newVerifyAllDualSupplierPayAsYouGoGAPDetails(getaPrice)
        	.runBatchGetAQuote()
        	.verifyLeadDB();
      
    }
    
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP})
    public void verifyGAPFieldValidation() {
        Report.createTestLogHeader("Get A Price", "Field level validation");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
      /* new HomePageAction()
                .navigateToGasAndElectricityPage()
                .navigateToGetAPricePage()*/
        new GasAndElectricityAction()
                .navigateToGetAPricePage()
                .verifyErrorValidationsGAPDetails(getaPrice);
    }
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Saber,SalesRegressionAnonymous})
    public void newVerifyGAPFieldValidation()
    {
    	Report.createTestLogHeader("Get A Price", "Field level validation");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
        new GetAPriceAction()
		.navigateToGetAQuotePage()
		.verifyAndEnterGAQAnonymousDetails();
    }
    
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP, BG,SalesRegressionAnonymous})
    public void newBGEndToEndEnergyShop(){
    	Report.createTestLogHeader("Get A Price", "End to End BG Energy Shop Journey for Anonymous user ");
    	GetAPricePageProfile getAPricePageProfile = new TestDataHelper().getAPricePageProfile("BGENDTOEND");
    	for(int energyShopCount = 1; energyShopCount < Integer.parseInt(getAPricePageProfile.getTariffCount()) + 1 ; energyShopCount++){
    		try{
    			Report.updateTestLog("**************************************************************************", "");
    			Report.updateTestLog("**************************************************************************", "");
    			Report.updateTestLog("BG End To End Energyshop for Anonymous user for "+new GetAPriceAction().getTariffsEndTOEnd(energyShopCount,"BG"), "Pass");
    			Report.updateTestLog("**************************************************************************", "");
    			Report.updateTestLog("**************************************************************************", "");
    			GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
                UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
                Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
                new GetAPriceAction()
                	.navigateToGetAQuotePage()
                	.enterGAPAnonymousDetailsEntire(new GetAPriceAction().getTariffsEndTOEnd(energyShopCount,"BG"),"EnergyShop");
                new AcquisitionAction()
                	.yourOrderAnonymousNavigation(acquisition,userProfile)
                    .enterPersonalDetailsPage(acquisition, userProfile)
                    .enterCurrentServices(acquisition)
                    .enterPaymentOptions(acquisition)
                    .reviewOrderPageNavigation()
                    .verifyThankYouPage(userProfile)
                 //   .getEshopLeadID()
                  //  .verifyEshopLeadData()
                  //  .domarssalesRunBatch(acquisition.getShopBatch())
                   // .deleteWTP(userProfile)
                    .backToHomePage();
                	   
    		}
    		catch(org.openqa.selenium.NoSuchElementException e){
    			
    		}
    		
    	}
    }
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP, BG,SalesRegressionAnonymous})
    public void newBGEndToEndEnergySmart(){
    	Report.createTestLogHeader("Get A Price", "End to End BG Energy Smart Journey for Anonymous user ");
    	GetAPricePageProfile getAPricePageProfile = new TestDataHelper().getAPricePageProfile("BGENDTOEND");
    	for(int energySmartCount = 1; energySmartCount < Integer.parseInt(getAPricePageProfile.getTariffCount()) + 1 ; energySmartCount++){
    		try{
    		Report.updateTestLog("**************************************************************************", "");
			Report.updateTestLog("**************************************************************************", "");
			Report.updateTestLog("Get A Price", "End to End BG Smart Journey for Anonymous user "+ new GetAPriceAction().getTariffsEndTOEnd(energySmartCount,"BG"));
			Report.updateTestLog("**************************************************************************", "");
			Report.updateTestLog("**************************************************************************", "");
			GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
            UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
            Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
            new GetAPriceAction()
            	.navigateToGetAQuotePage()
            	.enterGAPAnonymousDetailsEntire(new GetAPriceAction().getTariffsEndTOEnd(energySmartCount,"BG"),"EnergySmart");
            new AcquisitionAction()
            	.yourOrderAnonymousNavigation(acquisition,userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
              /*  .getEshopLeadID()
                .verifyEshopLeadData()
                .domarssalesRunBatch(acquisition.getShopBatch())
                .deleteWTP(userProfile)*/
                .backToHomePage();
    	}
    	catch(org.openqa.selenium.NoSuchElementException e){
    		
    	}
    	}
    }
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP, BG})
    public void newSEEndToEndEnergyShop(){
    	Report.createTestLogHeader("Get A Price", "End to End SE Energy Shop Journey for Anonymous user ");
    	GetAPricePageProfile getAPricePageProfile = new TestDataHelper().getAPricePageProfile("SEENDTOEND");
    	for(int energyShopCount = 1; energyShopCount < Integer.parseInt(getAPricePageProfile.getTariffCount()) + 1 ; energyShopCount++){
    	try{
    		Report.updateTestLog("**************************************************************************", "");
    		Report.updateTestLog("**************************************************************************", "");
    		Report.updateTestLog("Get A Price", "End to End SE Journey for Anonymous user "+ new GetAPriceAction().getTariffsEndTOEnd(energyShopCount,"SE"));
    		Report.updateTestLog("**************************************************************************", "");
			Report.updateTestLog("**************************************************************************", "");
			Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
            GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
            UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
            new GetAPriceAction()
            	.navigateToGetAQuotePage()
            	.enterGAPDualAnonymousDetailsEntire(new GetAPriceAction().getTariffsEndTOEnd(energyShopCount,"SE"),"EnergyShop");
            new AcquisitionAction()
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
    		}
    		catch(org.openqa.selenium.NoSuchElementException e){
    			
    		}
            }
    	
    }
    
   

    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP, BG , SalesRegressionOAM})
    public void newVerifyEntireOAMClearSimpleEnergyShop() {
      
        Report.createTestLogHeader("Get A Price", "End to End Journey for OAM user ClearSimpleEnergyShop");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        new HomePageAction()
        .navigateToLogin()
        .login(userProfile);
        new GetAPriceAction()
        	.navigateToGetAQuotePage()
        	.enterGAPAnonymousDetailsEntire("ClearSimple","EnergyShop");
        new AcquisitionAction()
        	.yourOrderAnonymousNavigation(acquisition,userProfile)
            .enterPersonalDetailsPage(acquisition, userProfile)
            .enterCurrentServices(acquisition)
            .enterPaymentOptions(acquisition)
            .reviewOrderPageNavigation()
            .verifyThankYouPage(userProfile)
            .getEshopLeadID()
            .verifyEshopLeadData()
            .backToHomePage();
        }
  
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP})
    public void verifyAnonymousEnergyShopJourneyElec() {
        Report.createTestLogHeader("Get A Price", "Energy Shop Anonymous Journey Electricity");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
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
                .verifyEshopLeadData()
                .getEshopLeadID()
                //.domarssalesRunBatch(acquisition.getShopBatch())
                .deleteWTP(userProfile);
               // .backToHomePage();
    }
    
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP})
    public void verifyAnonymousEnergysmartJourneyElec() {
        Report.createTestLogHeader("Get A Price", "Energy Smart Anonymous Journey Electricity");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
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
                 .verifyEshopLeadData()
                .getEshopLeadID()
            /*    .verifyLeadData()
                .getLeadID()*/
                .deleteWTP(userProfile);
               /* .domarssalesRunBatch(acquisition.getSmartBatch());*/
    }
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP})
    public void verifyAnonymousEnergyShopJourneyGas() {
        Report.createTestLogHeader("Get A Price", "Energy Shop Anonymous Journey Gas");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
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
                .verifyEshopLeadData()
                .getEshopLeadID()
                .deleteWTP(userProfile);
             //   .backToHomePage();
    }
    
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP})
    public void verifyAnonymousEnergyShopJourneyDual() {
        Report.createTestLogHeader("Get A Price", "Energy Shop Anonymous Journey Dual");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
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
                .verifyEshopLeadData()
                .getEshopLeadID()
                .deleteWTP(userProfile);
                //.backToHomePage();
    }
    
    
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP})
    public void verifyAnonymousEnergyShopJourneyESmartDual() {
        Report.createTestLogHeader("Get A Price", "Energy Smart Anonymous Journey Dual");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
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
                .deleteWTP(userProfile);
               // .backToHomePage();
    }
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP})
    public void verifyAnonymousEnergyShopJourneyESmartGas() {
        Report.createTestLogHeader("Get A Price", "Energy Smart Anonymous Journey Gas");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
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
                .deleteWTP(userProfile);
               // .backToHomePage();
    }
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP})
    public void verifyAnonymousEnergyShopJourneyESmartElec() {
        Report.createTestLogHeader("Get A Price", "Energy Shop Anonymous Journey Electricity");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
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
                .deleteWTP(userProfile);
                //.backToHomePage();
    }
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP})
    public void verifyAnonymousEnergyShopJourneyGasOAM() {
        Report.createTestLogHeader("Get A Price", "Energy Shop Anonymous Journey Gas OAM");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        new HomePageAction()
                .navigateToGasAndElectricityPage()
                .navigateToGetAPricePage()
                .verifyAndEnterGAPDetails(getaPrice, userProfile)
                .switchTariff(getaPrice)
                .yourOrderGasBG(acquisition, userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .backToHomePage();
    }
    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP})
    public void verifyAnonymousEnergyShopJourneyElecOAM() {
        Report.createTestLogHeader("Get A Price", "Energy Shop Anonymous Journey Electricity OAM");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        new HomePageAction()
                .navigateToGasAndElectricityPage()
                .navigateToGetAPricePage()
                .verifyAndEnterGAPDetails(getaPrice, userProfile)
                .switchTariff(getaPrice)
                .yourOrderElecBG(acquisition, userProfile)
                .enterPersonalDetailsPage(acquisition, userProfile)
                .enterCurrentServices(acquisition)
                .enterPaymentOptions(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .backToHomePage();
    }
    
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP})
    public void sprint1TC1() {
        Report.createTestLogHeader("Get A Price - Dual", "TC1");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("Dual");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
        new GasAndElectricityAction()
               
                .navigateToGetAPricePage()
                .verifyAndEnterGAPDetails(getaPrice, userProfile);
                
    }
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP})
    public void sprint1TC11() {
        Report.createTestLogHeader("Get A Price- Gas", "TC11");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("Gas");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
        new GasAndElectricityAction()
               
                .navigateToGetAPricePage()
                .verifyAndEnterGAPDetails(getaPrice, userProfile);
                
    }
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP})
    public void sprint1TC12() {
        Report.createTestLogHeader("Get A Price- Elec", "TC12");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("Electricity");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
        new GasAndElectricityAction()
               
                .navigateToGetAPricePage()
                .verifyAndEnterGAPDetails(getaPrice, userProfile);
                
    }
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP})
    public void sprint1TC2() {
        Report.createTestLogHeader("Get A Price", "Electricity");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("Electricity");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        new HomePageAction()
        .navigateToLogin()
        .login(userProfile);         
        new GasAndElectricityAction()   
        .navigateToGetAPricePage()
        .verifyAndEnterGAPDetails(getaPrice, userProfile);
        new AcquisitionAction()
        .logoutFromThankYouPage();
                
    }
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP})
    public void sprint1TC3() {
        Report.createTestLogHeader("Get A Price", "TC GAS");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        //getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
        .navigateToLogin()
        .login(userProfile);         
        new GasAndElectricityAction()   
        .navigateToGetAPricePage()
        .verifyAndEnterGAPDetails(getaPrice, userProfile);
        new AcquisitionAction()
        .logoutFromThankYouPage();
                
    }
    
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP})
    public void sprint1TC4() {
        Report.createTestLogHeader("Get A Price", "HomeServciesAccount");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServciesAccount");
        //getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
        .navigateToLogin()
        .login(userProfile);         
        new GasAndElectricityAction()   
        .navigateToGetAPricePage()
        .verifyAndEnterGAPDetails(getaPrice, userProfile);
        new AcquisitionAction()
        .logoutFromThankYouPage();
                
    }
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP})
    public void sprint1TC5() {
        Report.createTestLogHeader("Get A Price", "TC  Dual Account");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        //getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
        .navigateToLogin()
        .login(userProfile);         
        new GasAndElectricityAction()   
        .navigateToGetAPricePage()
        .verifyAndEnterGAPDetails(getaPrice, userProfile);
        new AcquisitionAction()
        .logoutFromThankYouPage();
                
    }
    
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP})
    public void sprint1TC6() {
        Report.createTestLogHeader("Get A Price", " JIAccount");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        //getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
        .navigateToLogin()
        .login(userProfile);         
        new GasAndElectricityAction()   
        .navigateToGetAPricePage()
        .verifyAndEnterGAPDetails(getaPrice, userProfile);
        new AcquisitionAction()
        .logoutFromThankYouPage();
                
    }
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP})
    public void sprint1TC7() {
        Report.createTestLogHeader("Get A Price", " SSOAccount");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("SSOAccount");
        //getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
        .navigateToLogin()
        .login(userProfile);         
        new GasAndElectricityAction()   
        .navigateToGetAPricePage()
        .verifyAndEnterGAPDetails(getaPrice, userProfile);
        new AcquisitionAction()
        .logoutFromThankYouPage();
                
    }
    
    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, GAP})
    public void sprint1TC8() {
        Report.createTestLogHeader("Get A Price", " wtpAccount");
        GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("WTPAccount");
        //getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
        .navigateToLogin()
        .login(userProfile);         
        new GasAndElectricityAction()   
        .navigateToGetAPricePage()
        .verifyAndEnterGAPDetails(getaPrice, userProfile);
        new AcquisitionAction()
        .logoutFromThankYouPage();
    }
    
        @SuppressWarnings("unchecked")
        @Test(groups = {Regression, GAP})
        public void sprint1TC9() {
            Report.createTestLogHeader("Get A Price", "TC ServicesAccount");
            GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("anonymous");
            Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
            UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServciesAccount");
            //getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
            .navigateToLogin()
            .login(userProfile);         
            new GasAndElectricityAction()   
            .navigateToGetAPricePage()
            .verifyAndEnterGAPDetails(getaPrice, userProfile);
            new AcquisitionAction()
            .logoutFromThankYouPage();
                
    }
 
    
    
}