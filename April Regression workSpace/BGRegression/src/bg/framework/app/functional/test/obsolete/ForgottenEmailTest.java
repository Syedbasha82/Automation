package bg.framework.app.functional.test.obsolete;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;


import static bg.framework.app.functional.entities.FunctionalCategory.Obsolete;

public class ForgottenEmailTest extends TestBase {
    @SuppressWarnings("unchecked")
    @Test(groups = {Obsolete})
    public void verifyChangeForgottenEmailJourneyGasCustomer() {
        Report.createTestLogHeader("Forgotten Email", "To Verify whether the Gas Only Account user can successfully complete Forgotten Email Address Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .navigateToForgottenEmailAddressScreen();
               // .verifyForgottenEmailJourney(userProfile);
    }
    @SuppressWarnings("unchecked")
    @Test(groups = {Obsolete})
    public void verifyChangeForgottenEmailJourneyElecCustomer() {
        Report.createTestLogHeader("Forgotten Email", "To Verify whether the Electricity Only Account user can successfully complete Forgotten Email Address Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .navigateToForgottenEmailAddressScreen();
              //  .verifyForgottenEmailJourney(userProfile);
    }
    @SuppressWarnings("unchecked")
    @Test(groups = {Obsolete})
    public void verifyChangeForgottenEmailJourneyDualCustomer() {
        Report.createTestLogHeader("Forgotten Email", "To Verify whether the Dual Account user can successfully complete Forgotten Email Address Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .navigateToForgottenEmailAddressScreen();
              //  .verifyForgottenEmailJourney(userProfile);
    }
    @SuppressWarnings("unchecked")
    @Test(groups = {Obsolete})
    public void verifyChangeForgottenEmailJourneyJICustomer() {
        Report.createTestLogHeader("Forgotten Email", "To Verify whether the JI Only Account user can successfully complete Forgotten Email Address Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .navigateToForgottenEmailAddressScreen();
              //  .verifyForgottenEmailJourney(userProfile);
    }
    @SuppressWarnings("unchecked")
    @Test(groups = {Obsolete})
    public void verifyErrorMessages() {
        Report.createTestLogHeader("Change Email Address", "To Verify field level validations in Forgotten Email Address Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .navigateToForgottenEmailAddressScreen();
              //  .verifyFieldLeverErrors(userProfile);
        Report.verificationPointCounts();
    }
}
