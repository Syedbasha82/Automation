package bg.framework.app.functional.test.obsolete;

import static bg.framework.app.functional.entities.FunctionalCategory.Obsolete;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SiebelDataBase;
import bg.framework.app.functional.util.TestDataHelper;

/**
 * Created by IntelliJ IDEA.
 * User: Karthigai Priyan P
 * Date: 20/02/12
 * Time: 15:12
 * To change this template use File | Settings | File Templates.
 */
public class ChangeEmailAddressTest extends TestBase {

    @SuppressWarnings("unchecked")
    @Test(groups = {Obsolete})
    public void verifyJourneyGasCustomer() {
        Report.createTestLogHeader("Change Email Address", "To Verify whether the Gas Only Account user can successfully complete Change Email Address Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin();
                //.navigateToScreen();
               // .verify(userProfile);
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {Obsolete})
    public void verifyJourneyElectricityCustomer() {
        Report.createTestLogHeader("Change Email Address", "To Verify whether the Electricity Only Account user can successfully complete Change Email Address Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin();
                ///.navigateToScreen();
              //  .verify(userProfile);
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {Obsolete})
    public void verifyJourneyDualCustomer() {
        Report.createTestLogHeader("Change Email Address", "To Verify whether the Dual Account user can successfully complete Change Email Address Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin();
               // .navigateToScreen();
               // .verify(userProfile);
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {Obsolete})
    public void verifyJourneyJICustomer() {
        Report.createTestLogHeader("Change Email Address", "To Verify whether the JI Account user can successfully complete Change Email Address Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin();
               // .navigateToScreen();
               // .verify(userProfile);
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {Obsolete})
    public void verifyJourneyInactiveLessSixMonthsCustomer() {
        Report.createTestLogHeader("Change Email Address", "To Verify whether Account with inactive less six months user can successfully complete Change Email Address Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        SiebelDataBase siebelDataBase = new SiebelDataBase();
        siebelDataBase.setStatus(userProfile.getAccNumber(), 4, "Inactive");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin();
               // .navigateToScreen();
               // .verify(userProfile);
    }


    @SuppressWarnings("unchecked")
    @Test(groups = {Obsolete})
    public void verifyErrorMessages() {
        Report.createTestLogHeader("Change Email Address", "To Verify the Field level validation in Change Email Address Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin();
               // .navigateToScreen();
                //.verifyFieldLeverErrors(userProfile);
    }
}
