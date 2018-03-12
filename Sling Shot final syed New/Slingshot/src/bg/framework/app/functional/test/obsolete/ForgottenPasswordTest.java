package bg.framework.app.functional.test.obsolete;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;


import static bg.framework.app.functional.entities.FunctionalCategory.Obsolete;

public class ForgottenPasswordTest extends TestBase {
    @SuppressWarnings("unchecked")
    @Test(groups = {Obsolete})
    public void verifyForgottenPasswordJourneyGasCustomer() {
        Report.createTestLogHeader("Forgotten Password Journey", "To Verify whether the Gas Only Account user can successfully complete Forgotten Password journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .navigateToForgottenPasswordScreen()
                .verifyForgottenPasswordJourney(userProfile);
    }
    @SuppressWarnings("unchecked")
        @Test(groups = {Obsolete})
        public void verifyForgottenPasswordJourneyElecCustomer() {
            Report.createTestLogHeader("Forgotten Password Journey", "To Verify whether the Electricity Only Account user can successfully complete Forgotten Password journey");
            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
                    .navigateToLogin()
                    .navigateToForgottenPasswordScreen()
                    .verifyForgottenPasswordJourney(userProfile);
        }
    @SuppressWarnings("unchecked")
        @Test(groups = {Obsolete})
        public void verifyForgottenPasswordJourneyDualCustomer() {
            Report.createTestLogHeader("Forgotten Password Journey", "To Verify whether the Dual Only Account user can successfully complete Forgotten Password journey");
            UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
                    .navigateToLogin()
                    .navigateToForgottenPasswordScreen()
                    .verifyForgottenPasswordJourney(userProfile);
        }
    @SuppressWarnings("unchecked")
        @Test(groups = {Obsolete})
        public void verifyForgottenPasswordJourneyJiCustomer() {
            Report.createTestLogHeader("Forgotten Password Journey", "To Verify whether the JI Only Account user can successfully complete Forgotten Password journey");
            UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        OnlineDBConnector odc = new OnlineDBConnector();
        System.out.println(userProfile.getEmail());
            new HomePageAction()
                    .navigateToLogin()
                    .navigateToForgottenPasswordScreen()
                    .verifyForgottenPasswordJourney(userProfile);
        }

    @SuppressWarnings("unchecked")
    @Test(groups = {Obsolete})
    public void verifyErrorMessages() {
        Report.createTestLogHeader("Forgotten Password", "To Verify field level validations in Forgotten Password Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .navigateToForgottenPasswordScreen()
                .verifyFieldLevelErrors(userProfile);
    }
}