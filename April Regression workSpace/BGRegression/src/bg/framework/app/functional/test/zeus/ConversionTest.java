package bg.framework.app.functional.test.zeus;


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
            getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
                    .navigateToLogin()
                    .login(userProfile)                   
                    .navigateToGasAndElectricityPage()
                    .navigateToOurTariffsPage()
                    .navigateToClearAndSimple()
                    .navigateToElecOrderPage()
                    .yourOrderElecBG(acquisition,userProfile)
                    .reviewOrderPageNavigation()
                    .verifyThankYouPage(userProfile)
                    .verifyLeadData()
                    .changeTariff(userProfile.getElecAccount())
                    .logoutFromThankYouPage();

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
                        .yourOrderElecBG(acquisition,userProfile)
                        .reviewOrderPageNavigation()
                        .verifyThankYouPage(userProfile)
                        .verifyLeadData()
                        .changeTariff(userProfile.getElecAccount())
                        .logoutFromThankYouPage();


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
                        .yourOrderElecBG(acquisition,userProfile)
                        .reviewOrderPageNavigation()
                        .verifyThankYouPage(userProfile)
                        .verifyLeadData()
                        .changeTariff(userProfile.getElecAccount())
                        .logoutFromThankYouPage();


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
                    .yourOrderGasBG(acquisition,userProfile)
                    .reviewOrderPageNavigation()
                    .verifyThankYouPage(userProfile)
                    .verifyLeadData()
                    .changeTariff(userProfile.getGasAccount())
                    .logoutFromThankYouPage();                 
        }
    
    @Test(groups = {Acquisition,Conversion,Zeus,Qtp })
      public void ConversionGasOnlineVariableAugust2013() {

            Report.createTestLogHeader("Conversion Test", "ConversionGasOnlineVariableAugust2013");
            final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
            final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
           //getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
                    .navigateToLogin()
                    .login(userProfile)
                    
                    .navigateToGasAndElectricityPage()
                    .navigateToOurTariffsPage()
                    .navigateToOnlineVariableAugust2013()
                    .navigateToGasOrderPage()
                    .yourOrderGasBG(acquisition,userProfile)
                    .reviewOrderPageNavigation()
                    .verifyThankYouPage(userProfile)
                    .verifyLeadData()
                    .changeTariff(userProfile.getGasAccount())
                    .logoutFromThankYouPage();


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
                    .yourOrderGasBG(acquisition,userProfile)
                    .reviewOrderPageNavigation()
                    .verifyThankYouPage(userProfile)
                    .verifyLeadData()
                    .changeTariff(userProfile.getGasAccount())
                    .logoutFromThankYouPage();


        }
   
    @Test(groups = {Acquisition,Conversion,Zeus,Qtp })
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
                .yourOrderDualBG(acquisition,userProfile)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .changeTariff(userProfile.getGasAccount())
                .logoutFromThankYouPage();

    }

   
     @Test(groups = {Acquisition,Conversion,Zeus,Qtp })
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
                .yourOrderDualBG(acquisition,userProfile)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .changeTariff(userProfile.getGasAccount())
                .logoutFromThankYouPage();

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
                .yourOrderDualBG(acquisition,userProfile)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .verifyLeadData()
                .changeTariff(userProfile.getGasAccount())
                .logoutFromThankYouPage();
    }
      
    
           
       
               


        
    

      
      
      
}
