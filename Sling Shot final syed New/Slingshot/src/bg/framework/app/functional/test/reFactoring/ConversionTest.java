package bg.framework.app.functional.test.reFactoring;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.sales.AcquisitionAction;
import bg.framework.app.functional.entities.Acquisition;
import static bg.framework.app.functional.entities.FunctionalCategory.Conversion;
import static bg.framework.app.functional.entities.FunctionalCategory.Zeus;
import static bg.framework.app.functional.entities.FunctionalCategory.Acquisition;
import static bg.framework.app.functional.entities.FunctionalCategory.Qtp;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;


public class ConversionTest extends TestBase { 
       
    @Test(groups = {Acquisition,Conversion,Zeus,Qtp })
    public void ConversionElecClearAndSimple() {

            Report.createTestLogHeader("Conversion Test", "Conversion Electricity ClearAndSimple Tariff");
            final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
            final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
            //getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
                    .navigateToLogin()
                    .login(userProfile)                   
                    .navigateToGasAndElectricityPage()
                    .navigateToOurTariffsPage()
                    .navigateToClearAndSimple()
                    .navigateToElecOrderPage()
                    .yourOrderElecBG(acquisition)
                    .reviewOrderPageNavigation()
                    .verifyThankYouPage(userProfile)
                    .verifyEshopLeadData()
                    .logoutFromConvThankYouPage()
                    .changeTariff(userProfile.getElecAccount());
                    

        }
    
    @Test(groups = {Acquisition,Conversion,Zeus,Qtp })
    public void ConversionElecOnlineVariableAugust2013() {

                Report.createTestLogHeader("Conversion Test", "Conversion Elec OnlineVariableAugust2013");
                final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
                final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
                getCustomerDetailsToUserProfileOAM(userProfile);
                new HomePageAction()
                        .navigateToLogin()
                        .login(userProfile)                        
                        .navigateToGasAndElectricityPage()
                        .navigateToOurTariffsPage()
                        .navigateToOnlineVariableAugust2013()
                        .navigateToElecOrderPage()
                        .yourOrderElecBG(acquisition)
                        .reviewOrderPageNavigation()
                        .verifyThankYouPage(userProfile)
                        .verifyEshopLeadData()
                        .logoutFromConvThankYouPage()
                        .changeTariff(userProfile.getElecAccount());


            }
    
      @Test(groups = {Acquisition,Conversion,Zeus,Qtp })
      public void ConversionElecFixedPriceMay2014() {
    	  
                Report.createTestLogHeader("Conversion Test", "Conversion Electricity FixedPriceMay2014");
                final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
                final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
                getCustomerDetailsToUserProfileOAM(userProfile);
                new HomePageAction()
                        .navigateToLogin()
                        .login(userProfile)                     
                        .navigateToGasAndElectricityPage()
                        .navigateToOurTariffsPage()
                        .navigateToFixedPriceMay2014()
                        .navigateToElecOrderPage()
                        .yourOrderElecBG(acquisition)
                        .reviewOrderPageNavigation()
                        .verifyThankYouPage(userProfile)
                        .verifyEshopLeadData()
                        .logoutFromConvThankYouPage()
                        .changeTariff(userProfile.getElecAccount());


            }
    
      @Test(groups = {Acquisition,Conversion,Zeus,Qtp })
      public void ConversionGasClearAndSimple() {

            Report.createTestLogHeader("Conversion Test", "ConversionGasClearAndSimple");
            final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
            final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
           getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
                    .navigateToLogin()
                    .login(userProfile)                  
                    .navigateToGasAndElectricityPage()
                    .navigateToOurTariffsPage()
                    .navigateToClearAndSimple()
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
      public void ConversionGasOnlineVariableAugust2013() {

            Report.createTestLogHeader("Conversion Test", "ConversionGasOnlineVariableAugust2013");
            final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
            final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
            getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
                    .navigateToLogin()
                    .login(userProfile)                    
                    .navigateToGasAndElectricityPage()
                    .navigateToOurTariffsPage()
                    .navigateToOnlineVariableAugust2013()
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
    public void ConversionGasFixedPriceMay2014() {

            Report.createTestLogHeader("Conversion Test", "ConversionGasFixedPriceMay2014");
            final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
            final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
            getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
                    .navigateToLogin()
                    .login(userProfile)                    
                    .navigateToGasAndElectricityPage()
                    .navigateToOurTariffsPage()
                    .navigateToFixedPriceMay2014()
                    .navigateToGasOrderPage()
                    .yourOrderGasBG(acquisition)
                    .reviewOrderPageNavigation()
                    .verifyThankYouPage(userProfile)
                    .verifyEshopLeadData()
                    .verifyAuditEventID(userProfile)
                    .logoutFromConvThankYouPage()
                    .changeTariff(userProfile.getGasAccount());


        }
   
    //@Test(groups = {Acquisition,Conversion,Zeus,Qtp })
    @Test(groups = {Acquisition})
    public void ConversionDualOnlineVariableAugust2013() {

        Report.createTestLogHeader("Conversion Test", "DualConversionOnlineVariableAugust2013");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
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
                .changeTariff(userProfile.getGasAccount())
                .changeTariff(userProfile.getElecAccount());

    }

   
     //@Test(groups = {Acquisition,Conversion,Zeus,Qtp })
     @Test(groups = {Acquisition})
      public void ConversionDualClearAndSimple() {

        Report.createTestLogHeader("Conversion Test", "ConversionDualClearAndSimple");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)              
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToClearAndSimple()
                .navigateToDualOrderPage()
                .yourOrderDualBG(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyEshopLeadData()
                .verifyAuditEventID(userProfile)
                .logoutFromConvThankYouPage()
                .changeTariff(userProfile.getGasAccount())
                .changeTariff(userProfile.getElecAccount());

    }
 
      @Test(groups = {Acquisition,Conversion,Zeus,Qtp })
      public void ConversionDualFixedPriceMay2014() {

        Report.createTestLogHeader("Conversion Test", "ConversionDualFixedPriceMay2014");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)                
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToFixedPriceMay2014()
                .navigateToDualOrderPage()
                .yourOrderDualBG(acquisition)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyEshopLeadData()
                .verifyAuditEventID(userProfile)
                .logoutFromConvThankYouPage()
                .changeTariff(userProfile.getGasAccount())
                .changeTariff(userProfile.getElecAccount());
    }
      @Test(groups = {Acquisition,Conversion,Zeus,Qtp })
      public void ConversionJIOnlineVariableAugust2013() {
          Report.createTestLogHeader("Conversion Test", "JI Account Conversion OnlineVariableAugust2013");
          final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
          final UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
          getCustomerDetailsToUserProfileOAM(userProfile);
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
        public void ConversionJIClearAndSimple() {

          Report.createTestLogHeader("Conversion Test", "Conversion JI Account ClearAndSimple");
          final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
          final UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
          getCustomerDetailsToUserProfileOAM(userProfile);
          new HomePageAction()
                  .navigateToLogin()
                  .login(userProfile)              
                  .navigateToGasAndElectricityPage()
                  .navigateToOurTariffsPage()
                  .navigateToClearAndSimple()
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
        public void ConversionJIFixedPriceMay2014() {

          Report.createTestLogHeader("Conversion Test", "Conversion JI Account FixedPriceMay2014");
          final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
          final UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
          getCustomerDetailsToUserProfileOAM(userProfile);
          new HomePageAction()
                  .navigateToLogin()
                  .login(userProfile)                
                  .navigateToGasAndElectricityPage()
                  .navigateToOurTariffsPage()
                  .navigateToFixedPriceMay2014()
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
        public void ConversionElecFixFallMarch() {

                Report.createTestLogHeader("Conversion Test", "Conversion Electricity Fix and Fall March Tariff");
                final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
                final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
                //getCustomerDetailsToUserProfileOAM(userProfile);
                new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile);
                new AcquisitionAction()
		        		.goToElecFixAndFallMarch()
                        .yourOrderElecBG(acquisition)
                        .reviewOrderPageNavigation()
                        .verifyThankYouPage(userProfile)
                        .verifyEshopLeadData()
                        .logoutFromConvThankYouPage()
                        .changeTariff(userProfile.getElecAccount());
            } 
        
        @Test(groups = {Acquisition,Conversion,Zeus,Qtp })
        public void ConversionGasFixFallMarch() {

                Report.createTestLogHeader("Conversion Test", "Conversion Gas Fix and Fall March Tariff");
                final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
                final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
                //getCustomerDetailsToUserProfileOAM(userProfile);
                new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile);
                new AcquisitionAction()
		        		.goToGasFixAndFallMarch()
                        .yourOrderGasBG(acquisition)
                        .reviewOrderPageNavigation()
                        .verifyThankYouPage(userProfile)
                        .verifyEshopLeadData()
                        .logoutFromConvThankYouPage()
                        .changeTariff(userProfile.getElecAccount());
        }
        @Test(groups = {Acquisition,Conversion,Zeus,Qtp })
        public void ConversionDualFixFallMarch() {

                Report.createTestLogHeader("Conversion Test", "Conversion Dual Fix and Fall March Tariff");
                final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
                final UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
                //getCustomerDetailsToUserProfileOAM(userProfile);
                new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile);
                new AcquisitionAction()
		        		.goToDualFixAndFallMarch()
                        .yourOrderDualBG(acquisition)
                        .reviewOrderPageNavigation()
                        .verifyThankYouPage(userProfile)
                        .verifyEshopLeadData()
                        .logoutFromConvThankYouPage()
                        .changeTariff(userProfile.getElecAccount());
        }
        
        @Test(groups = {Acquisition,Conversion,Zeus,Qtp })
        public void ConversionJIFixFallMarch() {

                Report.createTestLogHeader("Conversion Test", "Conversion JI Fix and Fall March Tariff");
                final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
                final UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
                //getCustomerDetailsToUserProfileOAM(userProfile);
                new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile);
                new AcquisitionAction()
		        		.goToDualFixAndFallMarch()
                        .yourOrderDualBG(acquisition)
                        .reviewOrderPageNavigation()
                        .verifyThankYouPage(userProfile)
                        .verifyEshopLeadData()
                        .logoutFromConvThankYouPage()
                        .changeTariff(userProfile.getElecAccount());
        }
        
        @Test(groups = {Acquisition,Conversion,Zeus,Qtp })
        public void ConversionElecFixFallNovember() {

                Report.createTestLogHeader("Conversion Test", "Conversion Electricity Fix and Fall November Tariff");
                final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
                final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
                //getCustomerDetailsToUserProfileOAM(userProfile);
                new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile);
                new AcquisitionAction()
		        		.goToElecFixandFallNovember()
                        .yourOrderElecBG(acquisition)
                        .reviewOrderPageNavigation()
                        .verifyThankYouPage(userProfile)
                        .verifyEshopLeadData()
                        .logoutFromConvThankYouPage()
                        .changeTariff(userProfile.getElecAccount());
            } 
        
        @Test(groups = {Acquisition,Conversion,Zeus,Qtp })
        public void ConversionGasFixFallNovember() {

                Report.createTestLogHeader("Conversion Test", "Conversion Gas Fix and Fall November Tariff");
                final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
                final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
                //getCustomerDetailsToUserProfileOAM(userProfile);
                new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile);
                new AcquisitionAction()
		        		.goToGasFixandFallNovember()
                        .yourOrderGasBG(acquisition)
                        .reviewOrderPageNavigation()
                        .verifyThankYouPage(userProfile)
                        .verifyEshopLeadData()
                        .logoutFromConvThankYouPage()
                        .changeTariff(userProfile.getElecAccount());
        }
        @Test(groups = {Acquisition,Conversion,Zeus,Qtp })
        public void ConversionDualFixFallNovember() {

                Report.createTestLogHeader("Conversion Test", "Conversion Dual Fix and Fall November Tariff");
                final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
                final UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
                //getCustomerDetailsToUserProfileOAM(userProfile);
                new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile);
                new AcquisitionAction()
		        		.goToDualFixandFallNovember()
                        .yourOrderDualBG(acquisition)
                        .reviewOrderPageNavigation()
                        .verifyThankYouPage(userProfile)
                        .verifyEshopLeadData()
                        .logoutFromConvThankYouPage()
                        .changeTariff(userProfile.getElecAccount());
        }
        @Test(groups = {Acquisition,Conversion,Zeus,Qtp })
        public void ConversionJIFixFallNovember() {

                Report.createTestLogHeader("Conversion Test", "Conversion JI Fix and Fall November Tariff");
                final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
                final UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
                //getCustomerDetailsToUserProfileOAM(userProfile);
                new HomePageAction()
		                .navigateToLogin()
		                .login(userProfile);
                new AcquisitionAction()
		        		.goToDualFixandFallNovember()
                        .yourOrderDualBG(acquisition)
                        .reviewOrderPageNavigation()
                        .verifyThankYouPage(userProfile)
                        .verifyEshopLeadData()
                        .logoutFromConvThankYouPage()
                        .changeTariff(userProfile.getElecAccount());
        }
}
