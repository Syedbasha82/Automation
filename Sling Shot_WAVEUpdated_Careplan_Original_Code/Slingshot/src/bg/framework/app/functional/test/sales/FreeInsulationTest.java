package bg.framework.app.functional.test.sales;


import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.sales.AcquisitionAction;
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
public class FreeInsulationTest extends TestBase {
    
    @Test(groups = {Acquisition})
    public void callbackanonymousgas() {

        Report.createTestLogHeader("Anonymous Free Insulation Call Back Test", "Gas as refrence number");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        
       
        
        new AcquisitionAction()
        .freeInsulation()
        .enterfreeInsulation(acquisition, userProfile);       
    }
    
   
    @Test(groups = {Acquisition})

    public void callbackanonymouselec() {
        Report.createTestLogHeader("Anonymous Free Insulation Call Back Test", "Elec as reference number");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        new AcquisitionAction()
        .freeInsulation()
        .enterfreeInsulation(acquisition, userProfile);       
    }
    
  
    @Test(groups = {Acquisition})
    public void callbackanonymousdual() {

        Report.createTestLogHeader("Anonymous Free Insulation Call Back Test", "Dual as reference number");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        new AcquisitionAction()
        .freeInsulation()
        .enterfreeInsulation(acquisition, userProfile);       
    }
    
  
    @Test(groups = {Acquisition})
    public void callbackanonymousji() {

        Report.createTestLogHeader("Anonymous Free Insulation Call Back Test", "Ji as reference number");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        new AcquisitionAction()
        .freeInsulation()
        .enterfreeInsulation(acquisition, userProfile);       
    }
    
    @Test(groups = {Acquisition})
    public void callbackOAMGas() {
        Report.createTestLogHeader("OAM Free Insulation Call Back Test", "Gas as refrence number");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile);
        new AcquisitionAction()
        .freeInsulation()
        .enterfreeInsulation(acquisition, userProfile);                
    }
    

    @Test(groups = {Acquisition})
    public void callbackOAMElec() {
        Report.createTestLogHeader("OAM Free Insulation Call Back Test", "Elec as refrence number");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile);
        new AcquisitionAction()
        .freeInsulation()
        .enterfreeInsulation(acquisition, userProfile);                
    }
    

    @Test(groups = {Acquisition})
    public void callbackOAMDual() {

        Report.createTestLogHeader("OAM Free Insulation Call Back Test", "Dual as reference number");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile);
        new AcquisitionAction()
        .freeInsulation()
        .enterfreeInsulation(acquisition, userProfile)
        .logoutFromThankYouPage();
    }
    
    @Test(groups = {Acquisition})
    public void callbackOAMji() {

        Report.createTestLogHeader("OAM Free Insulation Call Back Test", "JI as reference number");
        Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile);
        new AcquisitionAction()
        .freeInsulation()
        .enterfreeInsulation(acquisition, userProfile);                
    }
}
    