package bg.framework.app.functional.test.sales;


import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;
import static bg.framework.app.functional.entities.FunctionalCategory.BG;
import static bg.framework.app.functional.entities.FunctionalCategory.Conversion;
import static bg.framework.app.functional.entities.FunctionalCategory.Acquisition;

/**
 * Created by IntelliJ IDEA.
 * User: !boobalas
 * Date: 14/12/11
 * Time: 06:30
 * To change this template use File | Settings | File Templates.
 */
public class ConversionTest extends TestBase {
    //@SuppressWarnings("unchecked")
    @Test(groups = {Acquisition})

    public void ConversionDualStandard() {

        Report.createTestLogHeader("Conversion Test", "DualConversionStandard");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("dual");
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToDualOrderPage()
                .yourOrderDualBG(acquisition, userProfile)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();


    }


    //@SuppressWarnings("unchecked")
    @Test(groups = {Acquisition})


    public void ConversionGasStandard() {

        Report.createTestLogHeader("Conversion Test", "ConversionGasStandard");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("gas");
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToGasOrderPage()
                .yourOrderGasBG(acquisition, userProfile)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();


    }

    //@SuppressWarnings("unchecked")
    @Test(groups = {Acquisition})

    public void ConversionElecStandard() {

        Report.createTestLogHeader("Conversion Test", "ConversionElecStandard");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("OAMElectricityAccount");
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToStandardTariffPage()
                .navigateToElecOrderPage()
                .yourOrderElecBG(acquisition, userProfile)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();


    }

    //@SuppressWarnings("unchecked")
    @Test(groups = {Acquisition})

    public void ConversionDualOnlineEnergy() {

        Report.createTestLogHeader("Conversion Test", "GasDualConversion");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("dual");
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToDualOrderPage()
                .yourOrderDualBG(acquisition, userProfile)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();


    }


    //@SuppressWarnings("unchecked")
    @Test(groups = {Acquisition})


    public void ConversionGasOnlineEnergy() {

        Report.createTestLogHeader("Conversion Test", "ConversionGasStandard");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("gas");
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToGasOrderPage()
                .yourOrderGasBG(acquisition, userProfile)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();


    }

    //@SuppressWarnings("unchecked")
    @Test(groups = {Acquisition})

    public void ConversionElecOnlineEnergy() {

        Report.createTestLogHeader("Conversion Test", "ConversionElecOnlineEnergy");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("elec");
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToProductAndServicesPage()
                .navigateToGasAndElectricityPage()
                .navigateToOurTariffsPage()
                .navigateToOnlineEnergyTariffPage()
                .navigateToElecOrderPage()
                .yourOrderElecBG(acquisition, userProfile)
                .reviewOrderPageNavigation()
                .verifyThankYouPage(userProfile)
                .logoutFromThankYouPage();


    }


}