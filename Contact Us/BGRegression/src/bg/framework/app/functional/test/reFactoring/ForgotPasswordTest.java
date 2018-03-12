package bg.framework.app.functional.test.reFactoring;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.reFactoring.ForgotPasswordAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;

import static bg.framework.app.functional.entities.FunctionalCategory.ForgotPassword;
import static bg.framework.app.functional.entities.FunctionalCategory.Refactoring;

/**
   ClassName:  ForgotPasswordTest
   Description: To verify Forgotten Password Journey Scenarios
 */
public class ForgotPasswordTest extends TestBase {

    @SuppressWarnings("unchecked")
    @Test(groups = {ForgotPassword})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Password
    public void verifyForgottenPasswordJourneyGasCustomer() {
            Report.createTestLogHeader("Forgotten Password Journey", "To Verify whether Gas Account user can successfully complete Forgotten Password journey");
            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
            activateCustomerDetailsInOnlineDB(userProfile);
            getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
                    .navigateToForgottenPasswordScreen()
                    .verifyOneTimePwd(userProfile)
                    .verifyAudit(userProfile)
                    .loginandVerifyDetails(userProfile);
    }
    @SuppressWarnings("unchecked")
    @Test(groups = {ForgotPassword})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Password
    public void verifyForgottenPasswordJourneyElecCustomer() {
            Report.createTestLogHeader("Forgotten Password Journey", "To Verify whether ElectricityAccount user can successfully complete Forgotten Password journey");
            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
            activateCustomerDetailsInOnlineDB(userProfile);
            getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
                    .navigateToForgottenPasswordScreen()
                    .verifyOneTimePwd(userProfile)
                    .verifyAudit(userProfile)
                    .loginandVerifyDetails(userProfile);
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {ForgotPassword})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Password
    public void verifyForgottenPasswordJourneyDualCustomer() {
            Report.createTestLogHeader("Forgotten Password Journey", "To Verify whether Dual Account user can successfully complete Forgotten Password journey");
            UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
            activateCustomerDetailsInOnlineDB(userProfile);
            getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
                    .navigateToForgottenPasswordScreen()
                    .verifyOneTimePwd(userProfile)
                    .verifyAudit(userProfile)
                    .loginandVerifyDetails(userProfile);
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {ForgotPassword})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Password
    public void verifyForgottenPasswordJourneyJICustomer() {
            Report.createTestLogHeader("Forgotten Password Journey", "To Verify whether JI Account user can successfully complete Forgotten Password journey");
            UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
            activateCustomerDetailsInOnlineDB(userProfile);
            getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
                    .navigateToForgottenPasswordScreen()
                    .verifyOneTimePwd(userProfile)
                    .verifyAudit(userProfile)
                    .loginandVerifyDetails(userProfile);
    }
    @SuppressWarnings("unchecked")
    @Test(groups = {ForgotPassword})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Password
    public void verifyForgottenPasswordJourneyBGSCustomer() {
            Report.createTestLogHeader("Forgotten Password Journey", "To Verify whether Home Services Account user can successfully complete Forgotten Password journey");
            UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");
            activateCustomerDetailsInOnlineDB(userProfile);
            getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
                    .navigateToForgottenPasswordScreen()
                    .verifyOneTimePwd(userProfile)
                    .verifyAudit(userProfile)
                    .loginandVerifyDetails(userProfile);
    }
    @SuppressWarnings("unchecked")
    @Test(groups = {ForgotPassword})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Password
    public void verifyForgottenPasswordJourneyMixedCustomer() {
            Report.createTestLogHeader("Forgotten Password Journey", "To Verify whether Mixed Brand Customer user can successfully complete Forgotten Password journey");
            UserProfile userProfile = new TestDataHelper().getUserProfile("MixedBrandCustomer");
            activateCustomerDetailsInOnlineDB(userProfile);
            getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
                    .navigateToForgottenPasswordScreen()
                    .verifyOneTimePwd(userProfile)
                    .verifyAudit(userProfile)
                    .loginandVerifyDetails(userProfile);
    }
    @SuppressWarnings("unchecked")
    @Test(groups = {ForgotPassword})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Password
    public void verifyForgottenPasswordJourneyInactiveCustomer() {
            Report.createTestLogHeader("Forgotten Password Journey", "To Verify whether Inactive Greater and Less than 6 months Account user can successfully complete Forgotten Password journey");
            UserProfile userProfile = new TestDataHelper().getUserProfile("InactiveAccount");
            new HomePageAction()
                    .navigateToForgottenPasswordScreen()
                    .verifyOneTimePwd(userProfile)
                    .verifyAudit(userProfile)
                    .loginandVerifyDetails(userProfile);
    }
    @SuppressWarnings("unchecked")
    @Test(groups = {ForgotPassword})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Password
    public void verifyForgottenPasswordJourneyInactivelessCustomer() {
            Report.createTestLogHeader("Forgotten Password Journey", "To Verify whether Inactive Less than 6 Months Account user can successfully complete Forgotten Password journey");
            UserProfile userProfile = new TestDataHelper().getUserProfile("InactiveAccount");
            activateCustomerDetailsInOnlineDB(userProfile);
            getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
                    .navigateToForgottenPasswordScreen()
                    .verifyOneTimePwd(userProfile)
                    .verifyAudit(userProfile)
                    .loginandVerifyDetails(userProfile);
    }
    @SuppressWarnings("unchecked")
    @Test(groups = {ForgotPassword})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Password
    public void verifyForgottenPasswordJourneyAutoRegCustomer() {
            Report.createTestLogHeader("Forgotten Password Journey", "To Verify whether Auto Reg Account user can successfully complete Forgotten Password journey");
            UserProfile userProfile = new TestDataHelper().getUserProfile("AutoRegAccount");
            activateCustomerDetailsInOnlineDB(userProfile);
            getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
                    .navigateToForgottenPasswordScreen()
                    .verifyOneTimePwd(userProfile)
                    .verifyAudit(userProfile)
                    .loginandVerifyDetails(userProfile);
    }
    @SuppressWarnings("unchecked")
    //@Test(groups = {ForgotPassword})
    // Field blank Error scenario
    public void verifyErrorMessages() {
        Report.createTestLogHeader("Forgotten Password Journey", "To Verify field level validations in Forgotten Password Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToForgottenPasswordScreen()
                .verifyFieldLevelErrors(userProfile);
    }
    @SuppressWarnings("unchecked")
    //@Test(groups = {ForgotPassword})
    //Invalid Email ID
    public void verifyEmailFieldErrorMessages() {
        Report.createTestLogHeader("Forgotten Password Journey", "To Verify Email field level validations in Forgotten Password Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        new HomePageAction()
                .navigateToForgottenPasswordScreen()
                .validateEmailAddressField(userProfile);
    }
    @SuppressWarnings("unchecked")
    //@Test(groups = {ForgotPassword})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Password
    public void verifyNewPwdFieldErrorMessages() {
        Report.createTestLogHeader("Forgotten Password Journey", "To Verify New Password field level validations in Forgotten Password Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        new HomePageAction()
                .navigateToForgottenPasswordScreen()
                .validateNewPwdAddressField(userProfile);
    }
    @SuppressWarnings("unchecked")
    @Test(groups = {ForgotPassword})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Password
    public void verifyForgottenPasswordJourneyDDCPSPage() {
        Report.createTestLogHeader("Forgotten Password Journey", "To Verify whether user can successfully complete Forgotten Password journey from DDCPS Login Page");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        new HomePageAction()
                .navigateToLogin()
                .navigateToForgottenPasswordScreen()
                .verifyOneTimePwd(userProfile)
                .validateDirectDebitPwd(userProfile)
                .verifyOneTimePwd(userProfile)
                .verifyAudit(userProfile)
                .loginandVerifyDetails(userProfile);
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {ForgotPassword})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Password
    public void verifyForgottenPasswordEShopJourney() {
        Report.createTestLogHeader("Forgotten Password Journey", "To Verify  user can successfully complete Forgotten Password journey from Energy Shop Forced Login Page");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        new ForgotPasswordAction()
                .navigateToEshopOrderPage(acquisition)
                .navigateToForgottenPasswordScreen()
                .verifyOneTimePwd(userProfile)
                .verifyAudit(userProfile)
                .loginandVerifyDetails(userProfile);
    }
    @SuppressWarnings("unchecked")
    @Test(groups = {ForgotPassword})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Password
    public void verifyForgottenPasswordJourneybackButton() {
            Report.createTestLogHeader("Forgotten Password Journey", "To Verify Back Button Functionality in Forgotten Password journey");
            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
            activateCustomerDetailsInOnlineDB(userProfile);
            getCustomerDetailsToUserProfileOAM(userProfile);
            new HomePageAction()
                    .navigateToForgottenPasswordScreen()
                    .verifyOneTimePwd(userProfile)
                    .verifyAudit(userProfile)
                    .backbuttonchangeEmail();
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {ForgotPassword})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Password
    public void verifyForgottenPasswordJourneywithOldPwd() {
            Report.createTestLogHeader("Forgotten Password Journey", "To Verify User can able to " +
                    "Login with Old Password ,Without Reset the Password in Forgotten Password journey");
            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
            new HomePageAction()
                    .navigateToForgottenPasswordScreen()
                    .enterEmailAddress(userProfile)
                    .loginUserDetails(userProfile);

    }

}