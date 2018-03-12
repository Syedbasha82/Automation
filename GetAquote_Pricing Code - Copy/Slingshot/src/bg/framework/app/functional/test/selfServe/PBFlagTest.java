package bg.framework.app.functional.test.selfServe;


import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import static bg.framework.app.functional.entities.FunctionalCategory.PBFlag;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;

public class PBFlagTest extends TestBase{
	@Test(groups = {PBFlag})
    public void pbFlagVerificationForElectricity() {
        Report.createTestLogHeader("PB Flag Test", "PB Flag - Test");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .verifyCustomerAddressAction(userProfile.getElecAccount())
                .navigateToAccountSummaryPage(userProfile)
                .navigateToPbFlagPage()
                .paperLessBillingAction()            
                .logout();
    }
	
	@Test(groups = {Regression,PBFlag})
    public void pbFlagVerificationForGas() {
        Report.createTestLogHeader("PB Flag Test", "PB Flag - Test");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
        .navigateToLoginPage()
        .login(userProfile)
        .verifyCustomerAddressAction(userProfile.getGasAccount())
        .navigateToAccountSummaryPage(userProfile)
        .navigateToPbFlagPage()
        .paperLessBillingAction()             
        .logout();
    }
	
	@Test(groups = {Regression,PBFlag})
    public void pbFlagVerificationForDual() {
        Report.createTestLogHeader("PB Flag Test", "PB Flag - Test");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
        .navigateToLogin()
        .login(userProfile)
        .verifyCustomerAddressAction(userProfile.getGasAccount())
        .navigateToAccountSummaryPage(userProfile)
        .navigateToPbFlagPage()
        .paperLessBillingAction()             
        .logout();
    }
	
	@Test(groups = {Regression,PBFlag})
    public void pbFlagVerificationForJI() {
        Report.createTestLogHeader("PB Flag Test", "PB Flag - Test");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
        .navigateToLogin()
        .login(userProfile)
        .verifyCustomerAddressAction(userProfile.getGasAccount())
        .navigateToAccountSummaryPage(userProfile)
        .navigateToPbFlagPage()
        .paperLessBillingAction()             
        .logout();
    }
	
	@Test(groups = {Regression,PBFlag})
    public void pbFlagVerificationForBGS() {
        Report.createTestLogHeader("PB Flag Test", "Non existance of go paperless link verification for BGS Customer");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
        .navigateToLogin()
        .login(userProfile)
        .verifyCustomerAddressAction(userProfile.getGasAccount())
        .navigateToAccountSummaryPage(userProfile)
        .verifyPBFlagLinkAction()               
        .logout();
    }
	
	@Test(groups = {Regression,PBFlag})
    public void pbFlagVerificationForSSO() {
        Report.createTestLogHeader("PB Flag Test", "Non existance of go paperless link verification for SSO Customer");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
        .navigateToLogin()
        .login(userProfile)
        .verifyCustomerAddressAction(userProfile.getGasAccount())
        .navigateToAccountSummaryPage(userProfile)
        .verifyPBFlagLinkAction()             
        .logout();
    }
}
