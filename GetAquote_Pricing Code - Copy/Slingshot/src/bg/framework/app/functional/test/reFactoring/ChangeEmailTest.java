package bg.framework.app.functional.test.reFactoring;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;

import static bg.framework.app.functional.entities.FunctionalCategory.ChangeEmailAddress;
import static bg.framework.app.functional.entities.FunctionalCategory.Refactoring;
/**
  ClassName:ChangeEmailTest
 */
public class ChangeEmailTest extends TestBase {

    @SuppressWarnings("unchecked")
	@Test(groups ={ChangeEmailAddress})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Password
	public void verifyGasChangeEmailPage() {
        Report.createTestLogHeader("Change Email Address", "To Verify whether the Gas Only Account user can successfully complete Change Email Address Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToChangeEmailAddressPage()
                .changeEmailAddress(userProfile);
    }


    @SuppressWarnings("unchecked")
	@Test(groups ={ChangeEmailAddress})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Password
	public void verifyElecChangeEmailPage() {
        Report.createTestLogHeader("Change Email Address", "To Verify whether the Electricity Only Account user can successfully complete Change Email Address Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToChangeEmailAddressPage()
                .changeEmailAddress(userProfile);
    }

    @SuppressWarnings("unchecked")
	@Test(groups ={ChangeEmailAddress})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Password
	public void verifyDualChangeEmailPage() {
       Report.createTestLogHeader("Change Email Address", "To Verify whether the Dual Fuel Only Account user can successfully complete Change Email Address Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToChangeEmailAddressPage()
                .changeEmailAddress(userProfile);
    }

    @SuppressWarnings("unchecked")
	@Test(groups ={ChangeEmailAddress})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Password
	public void verifyJIChangeEmailPage() {
        Report.createTestLogHeader("Change Email Address", "To Verify whether the JI Only Account user can successfully complete Change Email Address Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToChangeEmailAddressPage()
                .changeEmailAddress(userProfile);
    }

    @SuppressWarnings("unchecked")
	@Test(groups ={ChangeEmailAddress})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Password
	public void verifyMixedBrandChangeEmailPage() {
       Report.createTestLogHeader("Change Email Address", "To Verify whether the Mixed Brand Only Account user can successfully complete Change Email Address Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("MixedBrandCustomer");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToChangeEmailAddressPage()
                .changeEmailAddress(userProfile);
    }

    @SuppressWarnings("unchecked")
	@Test(groups ={ChangeEmailAddress,Refactoring})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Email,Password
	public void verifySSOChangeEmailPage() {
        Report.createTestLogHeader("Change Email Address", "To Verify whether the SSO Only Account user can successfully complete Change Email Address Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("SSOAccount");
        new HomePageAction()
                .navigateToChangeEmailAddressPage()
                .changeSSOEmailAddress(userProfile);
    }

    @SuppressWarnings("unchecked")
	@Test(groups ={ChangeEmailAddress,Refactoring})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Password
	public void verifyBGSChangeEmailPage() {
       Report.createTestLogHeader("Change Email Address", "To Verify whether the Services Only Account user can successfully complete Change Email Address Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToChangeEmailAddressPage()
                .changeEmailAddress(userProfile);
    }

    @SuppressWarnings("unchecked")
	@Test(groups ={ChangeEmailAddress,Refactoring})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Email,Password
	public void verifyWTPChangeEmailPage() {
       Report.createTestLogHeader("Change Email Address", "To Verify whether the WTP Only Account user can successfully complete Change Email Address Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("WTPAccount");
        new HomePageAction()
                .navigateToChangeEmailAddressPage()
                .changeWTPEmailAddress(userProfile);
    }

    @SuppressWarnings("unchecked")
	@Test(groups ={ChangeEmailAddress,Refactoring})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Password
	public void verifyInactiveandActiveChangeEmailPage() {
       Report.createTestLogHeader("Change Email Address", "Inactive Greater than 6 months and Inactive less than 6 months Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("InactiveAccount");
        new HomePageAction()
                .navigateToChangeEmailAddressPage()
                .changeInactive(userProfile)
                .changeEmailAddress(userProfile);
    }

    @SuppressWarnings("unchecked")
	@Test(groups ={ChangeEmailAddress,Refactoring})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Password
	public void verifyInactiveLessChangeEmailPage() {
     Report.createTestLogHeader("Change Email Address", "Inactive less than 6 months Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("InactiveAccount");
        new HomePageAction()
                .navigateToChangeEmailAddressPage()
                .changelessInactive(userProfile)
                .changeEmailAddress(userProfile);
    }

    @SuppressWarnings("unchecked")
	@Test(groups ={ChangeEmailAddress,Refactoring})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Password
	public void verifyFinalBilledChangeEmailPage() {
       Report.createTestLogHeader("Change Email Address", "To Verify whether the Finally Billed Only Account user can successfully complete Change Email Address Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("InactiveAccount");
        new HomePageAction()
                .navigateToChangeEmailAddressPage()
                .changelessInactive(userProfile)
                .changeEmailAddress(userProfile);
    }

    @SuppressWarnings("unchecked")
	@Test(groups ={ChangeEmailAddress})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Password
	public void verifyAccLockedChangeEmailPage() {
       Report.createTestLogHeader("Change Email Address", "To Verify whether the Locked Account user can successfully complete Change Email Address Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        new HomePageAction()
                .navigateToChangeEmailAddressPage()
                .changeAccountlock(userProfile)
                .changeLockedAccEmailAddress(userProfile)
                .changeAccountUnlock(userProfile);
    }

    @SuppressWarnings("unchecked")
	@Test(groups ={ChangeEmailAddress})
    // Mandatory Fields to Update in Userprofile.xml: Invalid Email ID,Password
	public void verifyChangeEmailErrorPage() {
    Report.createTestLogHeader("Change Email Address", "Error Message and Field Level Validations");
        UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
        new HomePageAction()
                .navigateToChangeEmailAddressPage()
                .validateErrorMessages(userProfile);
    }

    @SuppressWarnings("unchecked")
	@Test(groups ={ChangeEmailAddress,Refactoring})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Password
	public void verifyPrepaymentChangeEmailPage() {
       Report.createTestLogHeader("Change Email Address", "To Verify whether the PrePayment Only Account user can successfully complete Change Email Address Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("PrePayment");
        new HomePageAction()
                .navigateToChangeEmailAddressPage()
                .changePrePaymentEmailAddress(userProfile);
    }

    @SuppressWarnings("unchecked")
	@Test(groups ={ChangeEmailAddress})
    // Mandatory Fields to Update in Userprofile.xml: UCRN,Password
	public void verifyBackButtonChangeEmailPage() {
       Report.createTestLogHeader("Change Email Address", "Verify Back Button Functionality");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToChangeEmailAddressPage()
                .changeEmailAddress(userProfile)
                .backbuttonchangeEmail();
    }
}
