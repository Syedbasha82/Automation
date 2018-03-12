package bg.framework.app.functional.test.reFactoring;

	import bg.framework.app.functional.action.common.HomePageAction;
	import bg.framework.app.functional.action.sales.AcquisitionAction;
import bg.framework.app.functional.action.sales.StandardTariffAction;
	import bg.framework.app.functional.entities.Acquisition;
	import bg.framework.app.functional.entities.FunctionalCategory;
	import bg.framework.app.functional.entities.UserProfile;
	import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.OnlineDBConnector;
	import bg.framework.app.functional.util.Report;
	import bg.framework.app.functional.util.TestDataHelper;
	import org.testng.annotations.Test;
import static bg.framework.app.functional.entities.FunctionalCategory.*;

public class AcquisitionTest extends TestBase {
	
	@Test(groups = {FunctionalCategory.Acquisition})     
    public  void cASAcquisitionDualNewNectar(){     	
     	 Report.createTestLogHeader("Clear And Simple Acquisition", "Dual with Sign me Up a new nectar option");     	
     	 final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
         final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
     	
         new HomePageAction()         
	          .navigateToGasAndElectricityPage()
	          .navigateToOurTariffsPage()
	          .navigateToClearAndSimple()        
	          .navigateToDualOrderPage()	          
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
    public  void onlineVariableAugustAcquisitionGasNectarlater(){     	
     	 Report.createTestLogHeader("online January 2014 Acquisition", " Nectar Later Options");     	
     	 final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
         final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
     	
         new HomePageAction()         
	         .navigateToGasAndElectricityPage()
	         .navigateToOurTariffsPage()
	         .navigateToOnlineVariableAugust2013()	        
	         .navigateToDualOrderPage()
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
	}
	
	@Test(groups = {FunctionalCategory.Acquisition})     
    public  void CASAcquisitionGasNectarlater(){     	
     	 Report.createTestLogHeader("CAS Acquisition", " No Nectar Options");     	
     	 final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
         final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
     	
         new HomePageAction()         
	         .navigateToGasAndElectricityPage()
	         .navigateToOurTariffsPage()
	         .navigateToClearAndSimple()	        
	         .navigateToDualOrderPage()
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
	}
	
	@Test(groups = {FunctionalCategory.Acquisition})     
    public  void FPMAcquisitionGasNectarlater(){     	
     	 Report.createTestLogHeader("CAS Acquisition", " No Nectar Options");     	
     	 final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
         final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
     	
         new HomePageAction()         
	         .navigateToGasAndElectricityPage()
	         .navigateToOurTariffsPage()
	         .navigateToFixedPriceMay2014()	        
	         .navigateToDualOrderPage()
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
	}
	
	
	@Test(groups = {FunctionalCategory.Acquisition})     
    public  void fpmAcquisitionDualNewNectar(){     	
     	 Report.createTestLogHeader("OVN Acquisition", " No Nectar Options");     	
     	 final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
         final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
     	
         new HomePageAction()         
	         .navigateToGasAndElectricityPage()
	         .navigateToOurTariffsPage()
	         .navigateToFixedPriceMay2014()	        
	         .navigateToDualOrderPage()
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
	}
	@Test(groups = {FunctionalCategory.Acquisition})     
    public void OEElecAcquisitionwithNectar(){    	
     	  Report.createTestLogHeader("online Variable 2014 Acquisition", " Nectar not at the moments option");    	
     	  final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
          final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
     	
         new HomePageAction()                  
	         .navigateToGasAndElectricityPage()
	         .navigateToOurTariffsPage()
	         .navigateToOnlineVariableAugust2013()	        
	         .navigateToDualOrderPage()
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
	
	
	@Test(groups = {FunctionalCategory.Acquisition})     
    public  void OVNcquisitionDualNewNectar(){     	
     	 Report.createTestLogHeader("CAS 2014 Acquisition", "Dual with Sign me Up a new nectar option");     	
     	 final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
         final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
     	
         new HomePageAction()         
	          .navigateToGasAndElectricityPage()
	          .navigateToOurTariffsPage()
	          .navigateToClearAndSimple()     
	          .navigateToDualOrderPage()	          
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
    public  void FPMAcquisitionNoNectarlater(){     	
     	 Report.createTestLogHeader("FPM 2014 Acquisition", " No Nectar Options");     	
     	 final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
         final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
     	
         new HomePageAction()         
	         .navigateToGasAndElectricityPage()
	         .navigateToOurTariffsPage()
	         .navigateToFixedPriceMay2014()      
	         .navigateToDualOrderPage()
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
	}
	
	@Test(groups = {FunctionalCategory.Acquisition})     
    public void OVAAcquisitionwithNectar(){    	
     	  Report.createTestLogHeader("OVA Acquisition", " Nectar not at the moments option");    	
     	  final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
          final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
     	
         new HomePageAction()                  
	         .navigateToGasAndElectricityPage()
	         .navigateToOurTariffsPage()
	         .navigateToOnlineVariableAugust2013()        
	         .navigateToDualOrderPage()
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
	
	
	     @Test(groups = {FunctionalCategory.Acquisition})     
	     public  void clearAndSimpleAcquisition(){
	      	
	      	 Report.createTestLogHeader("Clear And Simple Acquisition", "Dual , Gas , Electricity");	      	
	      	  final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	          final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");	      	
	          new HomePageAction()
	          
		          .navigateToGasAndElectricityPage()
		          .navigateToOurTariffsPage()
		          .navigateToClearAndSimple()	        
		          .navigateToDualOrderPage()	          
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
		          .checkMediaCode(acquisition.getDualCsCode())
		          .backToHomePage()
		          
		          .navigateToGasAndElectricityPage()
		          .navigateToOurTariffsPage()
		          .navigateToClearAndSimple()
		          .navigateToGasOrderPage()
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
		          .checkMediaCode(acquisition.getGasCsCode())
		          .backToHomePage()
		         
		          .navigateToGasAndElectricityPage()
		          .navigateToOurTariffsPage()
		          .navigateToClearAndSimple()
		          .navigateToElecOrderPage()
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
		          .backToHomePage()
		          
		          .navigateToGasAndElectricityPage()
		          .navigateToOurTariffsPage()
		          .navigateToOnlineVariableAugust2013()
		          .navigateToGasOrderPage()
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
		          .checkMediaCode(acquisition.getGasonlineenergyTariffCode())
		          .deleteWTP(userProfile)
		          .backToHomePage()
		         
		          .navigateToGasAndElectricityPage()
		          .navigateToOurTariffsPage()
		          .navigateToOnlineVariableAugust2013()
		          .navigateToElecOrderPage()
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
	          new HomePageAction()         	                  	          
		          .navigateToGasAndElectricityPage()
		          .navigateToOurTariffsPage()
		          .navigateToFixedPriceMay2014()
		          .navigateToGasOrderPage()
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
		          .backToHomePage()
	          
	          
		          .navigateToGasAndElectricityPage()
		          .navigateToOurTariffsPage()
		          .navigateToFixedPriceMay2014()
		          .navigateToElecOrderPage()
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
		          .backToHomePage()
		          
		          
		          
		          .navigateToGasAndElectricityPage()
		          .navigateToOurTariffsPage()
		          .navigateToFixedPriceMay2014()
		          .navigateToDualOrderPage()
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
		          .yourOrderAnonymousNavigation(acquisition,userProfile)
		          .enterPersonalDetailsPage(acquisition, userProfile)
		          .enterCurrentServices(acquisition)     
		          .QuarterlyCashChequeEE50(acquisition)
		          .reviewOrderPageNavigation()
		          .verifyThankYouPage(userProfile)
		          .verifyEshopLeadData()
		          .getEshopLeadID()
		          .verifyAuditEventID(userProfile)
		          .domarssalesRunBatch(acquisition.getShopBatch())    
		          .checkMediaCode(acquisition.getStandardEE50Code())
		          .backToHomePage()
		          
		          .navigateToGasAndElectricityPage()
		          .navigateToOurTariffsPage()
		          .navigateToClearAndSimple()
		          .navigateToGasOrderPage()
		          .yourOrderAnonymousNavigation(acquisition,userProfile)
		          .enterPersonalDetailsPage(acquisition, userProfile)
		          .enterCurrentServices(acquisition)
		          .QuarterlyCashChequeEE50(acquisition)
		          .reviewOrderPageNavigation()
		          .verifyThankYouPage(userProfile)
		          .verifyEshopLeadData()
		          .getEshopLeadID()
		          .verifyAuditEventID(userProfile)
		          .domarssalesRunBatch(acquisition.getShopBatch())    
		          .checkMediaCode(acquisition.getStandardEE50Code())
		          .backToHomePage();	         	         	         
	    }
	    
	     @Test(groups = {FunctionalCategory.Acquisition})    
	     public void OnlineVariableAugust2013EE50Acquisition(){
	       	
	       	 Report.createTestLogHeader("Online Variable August2013 EE50 Acq", "Dual Gas and Elec");	       	
	       	  final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	          final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");	       	
	           new HomePageAction()	           
		           .navigateToGasAndElectricityPage()
		           .navigateToOurTariffsPage()
		           .navigateToOnlineVariableAugust2013()
		           .navigateToDualOrderPage()
		           .yourOrderAnonymousNavigation(acquisition,userProfile)
		           .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
		           .gasDefaultCurrentServicesPageNavigation(acquisition)
		           .QuarterlyCashChequeEE50(acquisition)
		           .reviewOrderPageNavigation()
		           .verifyThankYouPage(userProfile)
		           .verifyEshopLeadData()
		           .getEshopLeadID()
		           .verifyAuditEventID(userProfile)
		           .domarssalesRunBatch(acquisition.getShopBatch())
		           .checkMediaCode(acquisition.getStandardEE50Code())
		           .deleteWTP(userProfile)
		           .backToHomePage()
		           
		           .navigateToGasAndElectricityPage()
		           .navigateToOurTariffsPage()
		           .navigateToOnlineVariableAugust2013()
		           .navigateToGasOrderPage()
		       	   .yourOrderAnonymousNavigation(acquisition,userProfile)
		       	   .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
		           .gasDefaultCurrentServicesPageNavigation(acquisition)
		           .QuarterlyCashChequeEE50(acquisition)
		           .reviewOrderPageNavigation()
		           .verifyThankYouPage(userProfile)
		           .verifyEshopLeadData()
		           .getEshopLeadID()
		           .verifyAuditEventID(userProfile)
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
		          .yourOrderAnonymousNavigation(acquisition,userProfile)
		          .enterPersonalDetailsPage(acquisition, userProfile)
		          .gasDefaultCurrentServicesPageNavigation(acquisition)
		          .QuarterlyCashChequeEE50(acquisition)
		          .reviewOrderPageNavigation()
		          .verifyThankYouPage(userProfile)
		          .verifyEshopLeadData()
		          .getEshopLeadID()
		          .verifyAuditEventID(userProfile)
		          .domarssalesRunBatch(acquisition.getShopBatch())   
		          .checkMediaCode(acquisition.getStandardEE50Code())
		          .deleteWTP(userProfile)
		          .backToHomePage()		          
		          
		          .navigateToGasAndElectricityPage()
		          .navigateToOurTariffsPage()
		          .navigateToFixedPriceMay2014()
		          .navigateToElecOrderPage()
		          .yourOrderAnonymousNavigation(acquisition,userProfile)
		          .enterPersonalDetailsPage(acquisition, userProfile)
		          .enterCurrentServices(acquisition)
		          .QuarterlyCashChequeEE50(acquisition)
		          .reviewOrderPageNavigation()
		          .verifyThankYouPage(userProfile)
		          .verifyEshopLeadData()
		          .getEshopLeadID()
		          .verifyAuditEventID(userProfile)
		          .domarssalesRunBatch(acquisition.getShopBatch())  
		          .checkMediaCode(acquisition.getStandardEE50Code())
		          .deleteWTP(userProfile)
		          .backToHomePage();	          	          	         
	    }	     
	     
	    @Test(groups = {FunctionalCategory.Acquisition})
	    public void gasOAMElectricityDualAcquisitionONJ2014() {
	    	
	        Report.createTestLogHeader("AcquisitionConversion Test", " OnlineJanuary 2014  ElectricityDualAcquisitionOAM");
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
	                .yourOrderGasBG(acquisition)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .domarssalesRunBatch(acquisition.getShopBatch())     
	                .checkMediaCode(acquisition.getEleconlineenergyTariffCode())              
	                .logoutFromThankYouPage()	                
	                
	                .navigateToLogin()
	                .login(userProfile)                
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToOnlineVariableAugust2013()
	                .navigateToElecOrderPage()
	                .yourOrderGasBG(acquisition)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
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
	                    .yourOrderGasBG(acquisition)
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
	                    .logoutFromThankYouPage()	                    
	                    
	                    .navigateToLogin()
	                    .login(userProfile)                    
	                    .navigateToGasAndElectricityPage()
	                    .navigateToOurTariffsPage()
	                    .navigateToClearAndSimple()
	                    .navigateToElecOrderPage()
	                    .yourOrderGasBG(acquisition)
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
	                    .yourOrderGasBG(acquisition)
	                    .enterPersonalDetailsPage(acquisition, userProfile)
	                    .enterCurrentServices(acquisition)
	                    .enterPaymentOptions(acquisition)
	                    .reviewOrderPageNavigation()
	                    .verifyThankYouPage(userProfile)
	                    .verifyEshopLeadData()
	                    .getEshopLeadID()
	                    .verifyAuditEventID(userProfile)
	                    .domarssalesRunBatch(acquisition.getShopBatch())   
	                    .checkMediaCode(acquisition.getElecFP2013TariffCode())
	                    .logoutFromThankYouPage()
	                    
	                    .navigateToLogin()
	                    .login(userProfile)                    
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
	                    .verifyEshopLeadData()
	                    .getEshopLeadID()
	                    .verifyAuditEventID(userProfile)
	                    .domarssalesRunBatch(acquisition.getShopBatch())     
	                    .checkMediaCode(acquisition.getElecFP2013TariffCode())
	                    .logoutFromThankYouPage();
	        }
	    
	    @Test(groups = {FunctionalCategory.Acquisition})	    
	    public void gasOAMElectricityDualClearAndSimpleAcquisitionForcedLogin() {
	        Report.createTestLogHeader("AcquisitionConversion Test", "ForcedLogin GAS ConversionElectricity Dual ClearAndSimple AcquisitionOAM");
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
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
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
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
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
	                .verifyEshopLeadData()
	                .verifyAuditEventID(userProfile)
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
	                .verifyEshopLeadData()
	                .verifyAuditEventID(userProfile)
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
	                .verifyEshopLeadData()
	                .verifyAuditEventID(userProfile)
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
	                .verifyEshopLeadData()
	                .verifyAuditEventID(userProfile)
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
	                .yourOrderElecBG(acquisition)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .domarssalesRunBatch(acquisition.getShopBatch())     
	                .checkMediaCode(acquisition.getGasonlineenergyTariffCode())
	                .logoutFromThankYouPage()	                
	                
	                .navigateToLogin()
	                .login(userProfile)              
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToOnlineVariableAugust2013()
	                .navigateToGasOrderPage()
	                .yourOrderElecBG(acquisition)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
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
	                .yourOrderElecBG(acquisition)
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
	                .logoutFromThankYouPage()	                
	                
	                .navigateToLogin()
	                .login(userProfile)               
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToClearAndSimple()
	                .navigateToGasOrderPage()
	                .yourOrderElecBG(acquisition)
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
	                .yourOrderElecBG(acquisition)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .verifyAuditEventID(userProfile)
	                .domarssalesRunBatch(acquisition.getShopBatch())     
	                .checkMediaCode(acquisition.getGasFP2013TariffCode())
	                .logoutFromThankYouPage()	                	                
	                
	                .navigateToLogin()
	                .login(userProfile)                
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToFixedPriceMay2014()
	                .navigateToGasOrderPage()
	                .yourOrderElecBG(acquisition)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .verifyAuditEventID(userProfile)
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
	                .verifyEshopLeadData()
	                .verifyAuditEventID(userProfile)
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
	                .verifyEshopLeadData()
	                .verifyAuditEventID(userProfile)
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
	                .verifyEshopLeadData()
	                .verifyAuditEventID(userProfile)
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
	                .verifyEshopLeadData()
	                .verifyAuditEventID(userProfile)
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
	                .verifyEshopLeadData()
	                .verifyAuditEventID(userProfile)
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
	                .verifyEshopLeadData()
	                .verifyAuditEventID(userProfile)
	                .domarssalesRunBatch(acquisition.getShopBatch())     
	                .checkMediaCode(acquisition.getGasFP2013TariffCode())
	                .logoutFromThankYouPage();
	    }	    
	    
	    @Test(groups = {Acquisition, BG})
	    public void sSOGasElecDualAcquisitionClearAndSimpleTariff() {
	        Report.createTestLogHeader("Acquisition ClearAndSimple Scenario", "SSOGasDualAcquisitionOAM");
	        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("ElecConversion");
	        final UserProfile userProfile = new TestDataHelper().getUserProfile("SSOAccount");
	        getCustomerDetailsToUserProfileOAM(userProfile);
	        new HomePageAction()
	                .navigateToLogin()
	                .login(userProfile)	                
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToClearAndSimple()
	                .navigateToGasOrderPage()
	                .yourOrderAnonymousNavigation(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage()
	                .navigateToLogin()
	                .login(userProfile)
	                
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToClearAndSimple()
	                .navigateToElecOrderPage()
	                .yourOrderAnonymousNavigation(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage()
	                .navigateToLogin()
	                .login(userProfile)
	                
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                 .navigateToClearAndSimple()
	                .navigateToDualOrderPage()
	                .yourOrderAnonymousNavigation(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage();
	    }

	    @Test(groups = {Acquisition, BG})
	    public void servicesGasElecDualAcquisitionClearAndSimpleTariff() {
	        Report.createTestLogHeader("Acquisition ClearAndSimple Scenario", "SSOGasDualAcquisitionOAM");
	        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("ElecConversion");
	        final UserProfile userProfile = new TestDataHelper().getUserProfile("HomeSerivcesAccount");
	        getCustomerDetailsToUserProfileOAM(userProfile);
	        new HomePageAction()
	                .navigateToLogin()
	                .login(userProfile)	                
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToClearAndSimple()
	                .navigateToGasOrderPage()
	                .yourOrderAnonymousNavigation(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage()
	                .navigateToLogin()
	                .login(userProfile)
	                
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToClearAndSimple()
	                .navigateToElecOrderPage()
	                .yourOrderAnonymousNavigation(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage()
	                .navigateToLogin()
	                .login(userProfile)
	                
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                 .navigateToClearAndSimple()
	                .navigateToDualOrderPage()
	                .yourOrderAnonymousNavigation(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage();
	    }
	    
	    @Test(groups = {Acquisition, BG})
	    public void wTPGasElecDualAcquisitionClearAndSimpleTariff() {
	        Report.createTestLogHeader("Acquisition ClearAndSimple Scenario", "SSOGasDualAcquisitionOAM");
	        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("ElecConversion");
	        final UserProfile userProfile = new TestDataHelper().getUserProfile("WTPAccount");
	        getCustomerDetailsToUserProfileOAM(userProfile);
	        new HomePageAction()
	                .navigateToLogin()
	                .login(userProfile)	                
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToClearAndSimple()
	                .navigateToGasOrderPage()
	                .yourOrderAnonymousNavigation(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage()
	                .navigateToLogin()
	                .login(userProfile)
	                
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToClearAndSimple()
	                .navigateToElecOrderPage()
	                .yourOrderAnonymousNavigation(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage()
	                .navigateToLogin()
	                .login(userProfile)
	                
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                 .navigateToClearAndSimple()
	                .navigateToDualOrderPage()
	                .yourOrderAnonymousNavigation(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage();
	    }

	   
	   
	    @Test(groups = {Acquisition, BG})
	    public void servicesGasElecDualAcquisitionFixedPriceMay2014Tariff() {
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
	                .yourOrderAnonymousNavigation(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage()
	                .navigateToLogin()
	                .login(userProfile)
	                
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToFixedPriceMay2014()
	                .navigateToElecOrderPage()
	                .yourOrderAnonymousNavigation(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage()
	                .navigateToLogin()
	                .login(userProfile)
	                
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToFixedPriceMay2014()
	                .navigateToDualOrderPage()
	                .yourOrderAnonymousNavigation(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage();
	    }
	    
	    @Test(groups = {Acquisition, BG})
	    public void ssoGasElecDualAcquisitionFixedPriceMay2014Tariff() {
	        Report.createTestLogHeader("Acquisition Scenario", "SSOGasDualFixedPriceMay2014AcquisitionOAM");
	        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("ElecConversion");
	        final UserProfile userProfile = new TestDataHelper().getUserProfile("SSOAccount");
	        new HomePageAction()
	                .navigateToLogin()
	                .login(userProfile)               
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToFixedPriceMay2014()
	                .navigateToGasOrderPage()
	                .yourOrderAnonymousNavigation(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage()
	                .navigateToLogin()
	                .login(userProfile)
	                
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToFixedPriceMay2014()
	                .navigateToElecOrderPage()
	                .yourOrderAnonymousNavigation(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage()
	                .navigateToLogin()
	                .login(userProfile)
	                
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToFixedPriceMay2014()
	                .navigateToDualOrderPage()
	                .yourOrderAnonymousNavigation(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage();
	    }

	    
	    @Test(groups = {Acquisition, BG})
	    public void wTpGasElecDualAcquisitionFixedPriceMay2014Tariff() {
	        Report.createTestLogHeader("Acquisition Scenario", "SSOGasDualFixedPriceMay2014AcquisitionOAM");
	        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("ElecConversion");
	        final UserProfile userProfile = new TestDataHelper().getUserProfile("WTPAccount");
	        new HomePageAction()
	                .navigateToLogin()
	                .login(userProfile)               
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToFixedPriceMay2014()
	                .navigateToGasOrderPage()
	                .yourOrderAnonymousNavigation(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage()
	                .navigateToLogin()
	                .login(userProfile)
	                
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToFixedPriceMay2014()
	                .navigateToElecOrderPage()
	                .yourOrderAnonymousNavigation(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage()
	                .navigateToLogin()
	                .login(userProfile)
	                
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToFixedPriceMay2014()
	                .navigateToDualOrderPage()
	                .yourOrderAnonymousNavigation(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage();
	    }


	   
	   @Test(groups = {Acquisition, BG})
	   public void servicesGasElecDualAcquisitionOETariff() {
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
	                .yourOrderAnonymousNavigation(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage()
	                .navigateToLogin()
	                .login(userProfile)
	                
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToOnlineVariableAugust2013()
	                .navigateToElecOrderPage()
	                .yourOrderAnonymousNavigation(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage()
	                .navigateToLogin()
	                .login(userProfile)
	                
	               .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToOnlineVariableAugust2013()
	                .navigateToDualOrderPage()
	                .yourOrderAnonymousNavigation(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage();
	    }
	   
	   @Test(groups = {Acquisition, BG})
	   public void WTPGasElecDualAcquisitionOETariff() {
	        Report.createTestLogHeader("AcquisitionConversion Scenario", "SSOGasDualAcquisitionOVA2013OAM");
	        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("ElecConversion");
	        final UserProfile userProfile = new TestDataHelper().getUserProfile("WTPAccount");
	        new HomePageAction()
	                .navigateToLogin()
	                .login(userProfile)            
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToOnlineVariableAugust2013()
	                .navigateToGasOrderPage()
	                .yourOrderAnonymousNavigation(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage()
	                .navigateToLogin()
	                .login(userProfile)
	                
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToOnlineVariableAugust2013()
	                .navigateToElecOrderPage()
	                .yourOrderAnonymousNavigation(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage()
	                .navigateToLogin()
	                .login(userProfile)
	                
	               .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToOnlineVariableAugust2013()
	                .navigateToDualOrderPage()
	                .yourOrderAnonymousNavigation(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage();
	    }

	   @Test(groups = {Acquisition, BG})
	   public void ssoGasElecDualAcquisitionOETariff() {
	        Report.createTestLogHeader("AcquisitionConversion Scenario", "SSOGasDualAcquisitionOVA2013OAM");
	        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("ElecConversion");
	        final UserProfile userProfile = new TestDataHelper().getUserProfile("SSOAccount");
	        new HomePageAction()
	                .navigateToLogin()
	                .login(userProfile)            
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToOnlineVariableAugust2013()
	                .navigateToGasOrderPage()
	                .yourOrderAnonymousNavigation(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage()
	                .navigateToLogin()
	                .login(userProfile)
	                
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToOnlineVariableAugust2013()
	                .navigateToElecOrderPage()
	                .yourOrderAnonymousNavigation(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage()
	                .navigateToLogin()
	                .login(userProfile)
	                
	               .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToOnlineVariableAugust2013()
	                .navigateToDualOrderPage()
	                .yourOrderAnonymousNavigation(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .gasDefaultCurrentServicesPageNavigation(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
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
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .backToHomePage()
	                
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToPAYGTariffPage()
	                .navigateToElecOrderPage()
	                .payAsYouGoYourOrderDetails(acquisition)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .backToHomePage()
	                
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToPAYGTariffPage()
	                .navigateToDualOrderPage()
	                .payAsYouGoYourOrderDetails(acquisition)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
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
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage();
	    }

	    
	    @Test(groups = {Acquisition, BG})
	    public void payAsYouGoOAMElectricity() {
	        Report.createTestLogHeader("PayAsYouGoEnergyElectricity Test", "OAMJourney");
	        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("Prepayment (Token)");
	        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	      //  getCustomerDetailsToUserProfileOAM(userProfile);
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
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage();
	    }

	   
	    @Test(groups = {Acquisition, BG})
	    public void payAsYouGoOAMDual() {
	        Report.createTestLogHeader("PayAsYouGoEnergy Dual Test", "OAMJourney");
	        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("Prepayment Economy 7 (Smartcard)");
	        final UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
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
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .logoutFromThankYouPage();
	    }

	   

	   
	    @Test(groups = {FunctionalCategory.Acquisition})
	    public void oVA2013GasAndDualAcquisitionEE50() {
	       Report.createTestLogHeader("Acquisition Conversion Test", "ElectricityAllConversionOnlineEnergyGasDualAcquisitionOAM");
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
	               .yourOrderElecBG(acquisition)
	               .enterPersonalDetailsPage(acquisition, userProfile)
	               .gasDefaultCurrentServicesPageNavigation(acquisition)
	               .enterPaymentOptionsEE50(acquisition)
	               .reviewOrderPageNavigation()
	               .verifyThankYouPage(userProfile)
	               .verifyEshopLeadData()
	               .getEshopLeadID()
	               .verifyAuditEventID(userProfile)
	               .verifyThankYouPage(userProfile)
	               .domarssalesRunBatch(acquisition.getShopBatch())
	               .logoutFromThankYouPage()
	   
	               .navigateToLogin()
	               .login(userProfile)               
	               .navigateToGasAndElectricityPage()
	               .navigateToOurTariffsPage()
	               .navigateToOnlineVariableAugust2013()
	               .navigateToGasOrderPage()
	               .yourOrderElecBG(acquisition)
	               .enterPersonalDetailsPage(acquisition, userProfile)
	               .gasDefaultCurrentServicesPageNavigation(acquisition)
	               .enterPaymentOptionsEE50(acquisition)
	               .reviewOrderPageNavigation()
	               .verifyThankYouPage(userProfile)
	               .verifyEshopLeadData()
	               .getEshopLeadID()
	               .verifyAuditEventID(userProfile)
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
	               .yourOrderElecBG(acquisition)
	               .enterPersonalDetailsPage(acquisition, userProfile)
	               .enterCurrentServices(acquisition)
	               .enterPaymentOptionsEE50(acquisition)
	               .reviewOrderPageNavigation()
	               .verifyThankYouPage(userProfile)
	               .verifyEshopLeadData()
	               .getEshopLeadID()
	               .verifyAuditEventID(userProfile)
	               .domarssalesRunBatch(acquisition.getShopBatch())
	               .logoutFromThankYouPage()
	 
	               
	               .navigateToLogin()
	               .login(userProfile)            
	               .navigateToGasAndElectricityPage()
	               .navigateToOurTariffsPage()
	               .navigateToClearAndSimple()
	               .navigateToGasOrderPage()
	               .yourOrderElecBG(acquisition)
	               .enterPersonalDetailsPage(acquisition, userProfile)
	               .enterCurrentServices(acquisition)
	               .QuarterlyCashChequeEE50(acquisition)
	               .reviewOrderPageNavigation()
	               .verifyThankYouPage(userProfile)
	               .verifyEshopLeadData()
	               .getEshopLeadID()
	               .verifyAuditEventID(userProfile)
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
	               .yourOrderElecBG(acquisition)
	               .enterPersonalDetailsPage(acquisition, userProfile)
	               .enterCurrentServices(acquisition)
	               .enterPaymentOptions(acquisition)
	               .reviewOrderPageNavigation()
	               .verifyThankYouPage(userProfile)
	               .verifyEshopLeadData()
	               .getEshopLeadID()
	               .verifyAuditEventID(userProfile)
	               .domarssalesRunBatch(acquisition.getShopBatch())
	               .logoutFromThankYouPage()

	               
	               .navigateToLogin()
	               .login(userProfile)             
	               .navigateToGasAndElectricityPage()
	               .navigateToOurTariffsPage()
	               .navigateToOnlineVariableAugust2013()
	               .navigateToGasOrderPage()
	               .yourOrderElecBG(acquisition)
	               .enterPersonalDetailsPage(acquisition, userProfile)
	               .gasDefaultCurrentServicesPageNavigation(acquisition)
	               .enterPaymentOptions(acquisition)
	               .reviewOrderPageNavigation()
	               .verifyThankYouPage(userProfile)
	               .verifyEshopLeadData()
	               .getEshopLeadID()
	               .verifyAuditEventID(userProfile)
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
	        .yourOrderAnonymousNavigation(acquisition,userProfile)
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
	        .yourOrderElecBG(acquisition)
	        .enterPersonalDetailsPage(acquisition, userProfile)
	        .enterCurrentServices(acquisition)
	        .enterPaymentOptions(acquisition)
	        .reviewOrderPageNavigation()
	        .verifyThankYouPage(userProfile)
	        .verifyEshopLeadData()
	        .getEshopLeadID()
	        .verifyAuditEventID(userProfile)
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
	        .yourOrderAnonymousNavigation(acquisition,userProfile)
	        .enterPersonalDetailsPage(acquisition, userProfile)
	        .enterCurrentServices(acquisition)
	        .enterPaymentOptions(acquisition)
	        .reviewOrderPageNavigation()
	        .verifyThankYouPage(userProfile)
	        .verifyEshopLeadData()
	        .getEshopLeadID()
	        .verifyAuditEventID(userProfile)
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
	        .yourOrderAnonymousNavigation(acquisition,userProfile)
	        .enterPersonalDetailsPage(acquisition, userProfile)
	        .enterCurrentServices(acquisition)
	        .enterPaymentOptions(acquisition)
	        .reviewOrderPageNavigation()
	        .verifyThankYouPage(userProfile)
	        .verifyEshopLeadData()
	        .getEshopLeadID()
	        .verifyAuditEventID(userProfile)
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
	        .yourOrderAnonymousNavigation(acquisition,userProfile)
	        .enterPersonalDetailsPage(acquisition, userProfile)
	        .enterCurrentServices(acquisition)
	        .enterPaymentOptionsEE50(acquisition)
	        .reviewOrderPageNavigation()
	        .verifyThankYouPage(userProfile)
	        .verifyEshopLeadData()
	        .getEshopLeadID()
	        .verifyAuditEventID(userProfile)
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
	        .yourOrderAnonymousNavigation(acquisition,userProfile)
	        .enterPersonalDetailsPage(acquisition, userProfile)
	        .enterCurrentServices(acquisition)
	        .enterPaymentOptionsEE50(acquisition)
	        .reviewOrderPageNavigation()
	        .verifyThankYouPage(userProfile)
	        .verifyEshopLeadData()
	        .getEshopLeadID()
	        .verifyAuditEventID(userProfile)
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
	        .yourOrderAnonymousNavigation(acquisition,userProfile)
	        .enterPersonalDetailsPage(acquisition, userProfile)
	        .enterCurrentServices(acquisition)
	        .enterPaymentOptionsEE50(acquisition)
	        .reviewOrderPageNavigation()
	        .verifyThankYouPage(userProfile)
	        .verifyEshopLeadData()
	        .getEshopLeadID()
	        .verifyAuditEventID(userProfile)
	        .logoutFromThankYouPage();	                      
	    }
	    
	    @Test(groups = {FunctionalCategory.Acquisition})
	    public void dualOnlineEnergyAcquisitionForcedRegistration() {
	        Report.createTestLogHeader("AcquisitionConversion Test", "ForcedLogin GAS Conversion Electricity Dual OnlineEnergyAcquisitionOAM");
	        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	        OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
	        onlineDBConnector.deRegister(userProfile.getUCRN());
	        getCustomerDetailsToUserProfileAnonymous(userProfile);
	        new HomePageAction()	                
	                .navigateToProductsAndServicesPage()
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToOnlineVariableAugust2013()
	                .navigateToDualOrderPage()
	                .forcedRegistrationYourOrderPage(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .logoutFromThankYouPage();	                
	    }
	    
	    @Test(groups = {FunctionalCategory.Acquisition})
	    public void dualCASAcquisitionForcedRegistration() {
	        Report.createTestLogHeader("AcquisitionConversion Test", "Forced Registration Electricity Conversion Gas Dual OnlineEnergyAcquisitionOAM");
	        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	        OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
	        onlineDBConnector.deRegister(userProfile.getUCRN());
	        getCustomerDetailsToUserProfileAnonymous(userProfile);
	        new HomePageAction()	                
	                .navigateToProductsAndServicesPage()
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToOnlineVariableAugust2013()
	                .navigateToDualOrderPage()
	                .forcedRegistrationYourOrderPage(acquisition,userProfile)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .logoutFromThankYouPage();	                
	    }
	    @Test(groups = {FunctionalCategory.Acquisition})
	    public void dualConversionFPMForcedRegistration() {
	        Report.createTestLogHeader("AcquisitionConversion Test", "Forced Registration GAS Conversion Electricity Dual OnlineEnergyAcquisitionOAM");
	        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	        final UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
	        OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
	        onlineDBConnector.deRegister(userProfile.getUCRN());
	        getCustomerDetailsToUserProfileAnonymous(userProfile);
	        new HomePageAction()	                
	                .navigateToProductsAndServicesPage()
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToFixedPriceMay2014()
	                .navigateToDualOrderPage()
	                .forcedRegistrationYourOrderPage(acquisition,userProfile)	                
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .logoutFromThankYouPage();	                
	    }
	    
	    @Test(groups = {FunctionalCategory.Acquisition})     
	    public  void clearAndSimpleAcquisitionDualbackCancelverification(){     	
	     	 Report.createTestLogHeader("Clear And Simple Acquisition", "Dual with Back Button verification in Eshop Pages");     	
	     	 final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	         final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
	     	
	         new HomePageAction()         
		          .navigateToGasAndElectricityPage()
		          .navigateToOurTariffsPage()
		          .navigateToClearAndSimple()	        
		          .navigateToDualOrderPage()	          
		          .yourOrderAnonymousNavigation(acquisition,userProfile)
		          .enterPersonalDetailsPage(acquisition, userProfile)
		          .verifyandClickBackbutton()
		          .yourOrderAnonymousNavigation(acquisition,userProfile)
		          .enterPersonalDetailsPage(acquisition, userProfile)
		          .enterCurrentServices(acquisition)
		          .verifyandClickBackbutton()
		          .enterPersonalDetailsPage(acquisition, userProfile)
		          .enterCurrentServices(acquisition)
		          .enterPaymentOptions(acquisition)
		          .verifyandClickBackbutton()
		          .enterCurrentServices(acquisition)
		          .enterPaymentOptions(acquisition)
		          .reviewOrderPageNavigation();
	    }
	    @Test(groups = {FunctionalCategory.Acquisition})     
	    public  void clearAndSimpleAcquisitionDualPrevAddr(){     	
	     	 Report.createTestLogHeader("Clear And Simple Acquisition", "Dual with Previous address and post code verification");     	
	     	 final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	         final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
	     	
	         new HomePageAction()         
		          .navigateToGasAndElectricityPage()
		          .navigateToOurTariffsPage()
		          .navigateToClearAndSimple()	        
		          .navigateToDualOrderPage()	          
		          .yourOrderAnonymousNavigation(acquisition,userProfile)
		          .enterPersonalDetailsPagePrevAddr(acquisition, userProfile)
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
	    public  void clearAndSimpleAcquisitionDualTwoPrevAddr(){     	
	     	 Report.createTestLogHeader("Clear And Simple Acquisition", "Dual with Two Year Previous address and post code verification");     	
	     	 final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	         final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
	     	
	         new HomePageAction()         
		          .navigateToGasAndElectricityPage()
		          .navigateToOurTariffsPage()
		          .navigateToClearAndSimple()	        
		          .navigateToDualOrderPage()	          
		          .yourOrderAnonymousNavigation(acquisition,userProfile)
		          .enterPersonalDetailsPageTwoPrevAddr(acquisition, userProfile)
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
	     public  void clearAndSimpleSEAcquisition(){
	      	
	      	 Report.createTestLogHeader("Clear And Simple Fusion Acquisition", "Dual , Gas , Electricity");	      	
	      	  final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	          final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");	      	
	          new HomePageAction()
	          
		          .navigateToGasAndElectricityPage()
		          .navigateToOurTariffsPage()
		          .navigateToClearAndSimple()	        
		          .navigateToDualOrderPage()	          
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
	    public void elecOAMElectricityDualAcquisitionONJ12014() {
	    	
	        Report.createTestLogHeader("AcquisitionConversion Test", " OnlineJanuary2014 GasDualAcquisitionOAM");
	        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	        getCustomerDetailsToUserProfileOAM(userProfile);
	        new HomePageAction()	                
	                .navigateToLogin()
	                .login(userProfile)
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToOnlineEnergyTariffPage()
	                .navigateToDualOrderPage()
	                .yourOrderElecBG(acquisition)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .domarssalesRunBatch(acquisition.getShopBatch())     
	                .checkMediaCode(acquisition.getEleconlineenergyTariffCode())              
	                .logoutFromThankYouPage()	   ;             
	    }
	    
	    @Test(groups = {FunctionalCategory.Acquisition})
	    public void elecOAMElectricityDualAcquisitionPCJ2014() {
	    	
	        Report.createTestLogHeader("AcquisitionConversion Test", " Price Check GasDualAcquisitionOAM");
	        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	        getCustomerDetailsToUserProfileOAM(userProfile);
	        new HomePageAction()	                
	                .navigateToLogin()
	                .login(userProfile)
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToPriceCheck2014TariffPage()
	                .navigateToDualOrderPage()
	                .yourOrderElecBG(acquisition)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .domarssalesRunBatch(acquisition.getShopBatch())     
	                .checkMediaCode(acquisition.getEleconlineenergyTariffCode())              
	                .logoutFromThankYouPage()	   ;             
	    }
	    
	    
	    @Test(groups = {FunctionalCategory.Acquisition})
	    public void gasOAMElectricityDualAcquisitionONJ12014() {
	    	
	        Report.createTestLogHeader("AcquisitionConversion Test", " OnlineJanuary2014 ElectricityDualAcquisitionOAM");
	        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	       // getCustomerDetailsToUserProfileOAM(userProfile);
	        new HomePageAction()	                
	                .navigateToLogin()
	                .login(userProfile)
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
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .domarssalesRunBatch(acquisition.getShopBatch())     
	                .checkMediaCode(acquisition.getEleconlineenergyTariffCode())              
	                .logoutFromThankYouPage()	   ;             
	    }
	    
	    @Test(groups = {FunctionalCategory.Acquisition})
	    public void gasOAMElectricityDualAcquisitionPCJ2014() {
	    	
	        Report.createTestLogHeader("AcquisitionConversion Test", " Price Check ElectricityDualAcquisitionOAM");
	        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	      //  getCustomerDetailsToUserProfileOAM(userProfile);
	        new HomePageAction()	                
	                .navigateToLogin()
	                .login(userProfile)
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToPriceCheck2014TariffPage()
	                .navigateToDualOrderPage()
	                .yourOrderGasBG(acquisition)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .domarssalesRunBatch(acquisition.getShopBatch())     
	                .checkMediaCode(acquisition.getEleconlineenergyTariffCode())              
	                .logoutFromThankYouPage()	   ;             
	    }
	    
	    @Test(groups = {FunctionalCategory.Acquisition})	    
	    public void gasOAMElectricityDualOnlineJanuaryAcquisitionForcedLogin() {
	        Report.createTestLogHeader("AcquisitionConversion Test", "ForcedLogin GAS ConversionElectricityDualOnlineJanuarye AcquisitionOAM");
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
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .domarssalesRunBatch(acquisition.getShopBatch())     
	                .checkMediaCode(acquisition.getElecCsCode())	                	                
	                .logoutFromThankYouPage()  ;
	    }    
	    
	    @Test(groups = {FunctionalCategory.Acquisition})	    
	    public void elecOAMElectricityDualPriceCheckAcquisitionForcedLogin() {
	        Report.createTestLogHeader("AcquisitionConversion Test", "ForcedLogin GAS Conversion Gas Dual PriceCheck AcquisitionOAM");
	        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElecricityAccount");
	        getCustomerDetailsToUserProfileOAM(userProfile);
	        
	        new HomePageAction()	                	                
	                .navigateToGasAndElectricityPage()
	                .navigateToOurTariffsPage()
	                .navigateToPriceCheck2014TariffPage()
	                .navigateToDualOrderPage()
	                .forcedLoginYourOrderPage(acquisition,userProfile)
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
	                .logoutFromThankYouPage() ;
	    }
	    
	    
	    @Test(groups = {FunctionalCategory.Acquisition})
	    public void gasOAMElectricityDualAcquisitionONJ120141() {
	    	
	        Report.createTestLogHeader("AcquisitionConversion Test", "GAQ OnlineJanuary2014 ElectricityDualAcquisitionOAM");
	        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	       // getCustomerDetailsToUserProfileOAM(userProfile);
	        new HomePageAction()	                
	                .navigateToLogin()
	                .login(userProfile)
	                .navigateTOAddDualPage()
	                .yourOrderElecBG(acquisition)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .domarssalesRunBatch(acquisition.getShopBatch())     
	                .checkMediaCode(acquisition.getEleconlineenergyTariffCode())              
	                .logoutFromThankYouPage()	   ;             
	    }
	    
	    @Test(groups = {FunctionalCategory.Acquisition})
	    public void gasOAMElectricityDualAcquisitionPCJ20141() {
	    	
	        Report.createTestLogHeader("AcquisitionConversion Test", " GAQ Price Check ElectricityDualAcquisitionOAM");
	        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	        final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	      //  getCustomerDetailsToUserProfileOAM(userProfile);
	        new HomePageAction()	                
	                .navigateToLogin()
	                .login(userProfile)
	                .navigateTOAddElectrticityPage()
	                .yourOrderElecBG(acquisition)
	                .enterPersonalDetailsPage(acquisition, userProfile)
	                .enterCurrentServices(acquisition)
	                .enterPaymentOptions(acquisition)
	                .reviewOrderPageNavigation()
	                .verifyThankYouPage(userProfile)
	                .verifyEshopLeadData()
	                .getEshopLeadID()
	                .verifyAuditEventID(userProfile)
	                .domarssalesRunBatch(acquisition.getShopBatch())     
	                .checkMediaCode(acquisition.getEleconlineenergyTariffCode())              
	                .logoutFromThankYouPage()	   ;             
	    }

	    @Test(groups = {Acquisition, BG})
	    public void elecConversionGasCASForcedRegistration() {
	         Report.createTestLogHeader("AcquisitionConversion Test", "ForcedRegistrationDualCASOAM");
	         final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	         final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	         getCustomerDetailsToUserProfileAnonymous(userProfile);
	         OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
	         onlineDBConnector.deRegister(userProfile.getUCRN());
	         new HomePageAction()
		             .navigateToGasAndElectricityPage()
		             .navigateToOurTariffsPage()
		             .navigateToClearAndSimple()        
		             .navigateToDualOrderPage()	
	                 .forcedRegistrationYourOrderPage(acquisition,userProfile)
	                 .enterPersonalDetailsPage(acquisition, userProfile)
	                 .enterCurrentServices(acquisition)
	                 .enterPaymentOptions(acquisition)
	                 .reviewOrderPageNavigation()
	                 .verifyThankYouPage(userProfile)
	                 .verifyEshopLeadData()
	                 .logoutFromThankYouPage();
	        }
	    
	    
	    @Test(groups = {Acquisition, BG})
	    public void elecConversionGasFPMForcedRegistration() {
	         Report.createTestLogHeader("Electricity Test", "ForcedRegistrationFPMAcquisitionOAM");
	         final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	         final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	         getCustomerDetailsToUserProfileAnonymous(userProfile);
	         OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
	         onlineDBConnector.deRegister(userProfile.getUCRN());
	         new HomePageAction()
		             .navigateToGasAndElectricityPage()
		             .navigateToOurTariffsPage()
		             .navigateToFixedPriceMay2014()       
		             .navigateToDualOrderPage()	
	                 .forcedRegistrationYourOrderPage(acquisition,userProfile)
	                 .enterPersonalDetailsPage(acquisition, userProfile)
	                 .enterCurrentServices(acquisition)
	                 .enterPaymentOptions(acquisition)
	                 .reviewOrderPageNavigation()
	                 .verifyThankYouPage(userProfile)
	                 .verifyEshopLeadData()
	                 .logoutFromThankYouPage();
	        }
	    
	    
	    @Test(groups = {Acquisition, BG})
	    public void elecConversionGasOVNForcedRegistration() {
	         Report.createTestLogHeader("Electricity Test", "ForcedRegistrationOVAAcquisitionOAM");
	         final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	         final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	         getCustomerDetailsToUserProfileAnonymous(userProfile);
	         OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
	         onlineDBConnector.deRegister(userProfile.getUCRN());
	         new HomePageAction()
		             .navigateToGasAndElectricityPage()
		             .navigateToOurTariffsPage()
		             .navigateToOnlineVariableAugust2013()      
		             .navigateToDualOrderPage()	
	                 .forcedRegistrationYourOrderPage(acquisition,userProfile)
	                 .enterPersonalDetailsPage(acquisition, userProfile)
	                 .enterCurrentServices(acquisition)
	                 .enterPaymentOptions(acquisition)
	                 .reviewOrderPageNavigation()
	                 .verifyThankYouPage(userProfile)
	                 .verifyEshopLeadData()
	                 .logoutFromThankYouPage();
	        }
	    
	    @Test(groups = {Acquisition, BG})
	    public void DualCASForcedRegistration() {
	         Report.createTestLogHeader("ElectricityAccount", "ForcedRegistrationDualAcquisitionOAM");
	         final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	         final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	         getCustomerDetailsToUserProfileAnonymous(userProfile);
	         OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
	         onlineDBConnector.deRegister(userProfile.getUCRN());
	         new HomePageAction()
		             .navigateToGasAndElectricityPage()
		             .navigateToOurTariffsPage()
		             .navigateToClearAndSimple()        
		             .navigateToDualOrderPage()	
	                 .forcedRegistrationYourOrderPage(acquisition,userProfile)
	                 .enterPersonalDetailsPage(acquisition, userProfile)
	                 .enterCurrentServices(acquisition)
	                 .enterPaymentOptions(acquisition)
	                 .reviewOrderPageNavigation()
	                 .verifyThankYouPage(userProfile)
	                 .verifyEshopLeadData()
	                 .logoutFromThankYouPage();
	        }
	    
	    
	    @Test(groups = {Acquisition, BG})
	    public void DualFPMForcedRegistration() {
	         Report.createTestLogHeader("Electricity Account", "ForcedRegistration Dual FPM AcquisitionOAM");
	         final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	         final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	         getCustomerDetailsToUserProfileAnonymous(userProfile);
	         OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
	         onlineDBConnector.deRegister(userProfile.getUCRN());
	         new HomePageAction()
		             .navigateToGasAndElectricityPage()
		             .navigateToOurTariffsPage()
		             .navigateToFixedPriceMay2014()       
		             .navigateToDualOrderPage()	
	                 .forcedRegistrationYourOrderPage(acquisition,userProfile)
	                 .enterPersonalDetailsPage(acquisition, userProfile)
	                 .enterCurrentServices(acquisition)
	                 .enterPaymentOptions(acquisition)
	                 .reviewOrderPageNavigation()
	                 .verifyThankYouPage(userProfile)
	                 .verifyEshopLeadData()
	                 .logoutFromThankYouPage();
	        }
	    
	    
	    @Test(groups = {Acquisition, BG})
	    public void DualConversionGasOVNForcedRegistration() {
	         Report.createTestLogHeader("ElectricityAccount", "ForcedRegistration OVN OAM");
	         final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	         final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	         getCustomerDetailsToUserProfileAnonymous(userProfile);
	         OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
	         onlineDBConnector.deRegister(userProfile.getUCRN());
	         new HomePageAction()
		             .navigateToGasAndElectricityPage()
		             .navigateToOurTariffsPage()
		             .navigateToOnlineVariableAugust2013()      
		             .navigateToDualOrderPage()	
	                 .forcedRegistrationYourOrderPage(acquisition,userProfile)
	                 .enterPersonalDetailsPage(acquisition, userProfile)
	                 .enterCurrentServices(acquisition)
	                 .enterPaymentOptions(acquisition)
	                 .reviewOrderPageNavigation()
	                 .verifyThankYouPage(userProfile)
	                 .verifyEshopLeadData()
	                 .logoutFromThankYouPage();
	        }



	    
}
