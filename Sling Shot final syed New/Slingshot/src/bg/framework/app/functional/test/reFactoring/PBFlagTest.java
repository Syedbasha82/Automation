package bg.framework.app.functional.test.reFactoring;


import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SiebelDataBase;
import bg.framework.app.functional.util.TestDataHelper;
import static bg.framework.app.functional.entities.FunctionalCategory.PBFlag;
import static bg.framework.app.functional.entities.FunctionalCategory.Refactoring;
import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;

public class PBFlagTest extends TestBase{
	@Test(groups = {PBFlag,Refactoring})
    public void pbFlagVerificationForElectricity() {
        Report.createTestLogHeader("PB Flag Test", "PB Flag Electricity- Test");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLoginPage()
                .loginUserDetails(userProfile)
                .verifyAddress(userProfile.getAccNumber()).navigateToAccountSummaryPage()
                .navigateToPbFlagPage()
                .paperLessBillingAction()            
                .logout();
    }
	@Test(groups = {PBFlag,Smoke})
    public void pbFlagVerificationForGas() {
        Report.createTestLogHeader("PB Flag Test", "PB Flag gas - Test");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLoginPage()
                .loginUserDetails(userProfile)
                .verifyAddress(userProfile.getAccNumber()).navigateToAccountSummaryPage()
                .navigateToPbFlagPage()
                .paperLessBillingAction()           
               .logout();
    }
	@Test(groups = {PBFlag,Refactoring})
    public void pbFlagVerificationForJI() {
        Report.createTestLogHeader("PB Flag Test", "PB Flag JI account - Test");
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLoginPage()
                .loginUserDetails(userProfile)
                .verifyAddress(userProfile.getAccNumber()).navigateToAccountSummaryPage()
                .navigateToPbFlagPage()
                .paperLessBillingAction()            
                .logout();
    }
	@Test(groups = {PBFlag,Refactoring})
    public void pbFlagVerificationForDual() {
        Report.createTestLogHeader("PB Flag Test", "PB Flag already have nectar dual Test");
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLoginPage()
                .loginUserDetails(userProfile)
                .verifyAddress(userProfile.getAccNumber()).navigateToAccountSummaryPage()
                .navigateToPbFlagPage()
                .paperLessBillingAction()            
               .logout();
    }	
	
	@Test(groups = {PBFlag,Refactoring})
    public void pbFlagVerificationForJIInactive() {
        Report.createTestLogHeader("PB Flag Test", "PB Flag JI account inactive - Test");
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        new SiebelDataBase().setAccountStatus(userProfile.getElecAccount(), -4);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLoginPage()
                .loginUserDetails(userProfile)
                .verifyAddress(userProfile.getAccNumber()).navigateToAccountSummaryPage()
                .navigateToPbFlagPage()
                .paperLessBillingAction()            
                .logout();
    }
	
	@Test(groups = {PBFlag,Refactoring})
    public void pbFlagVerificationForDualInactive() {
        Report.createTestLogHeader("PB Flag Test", "PB Flag Dual account inactive - Test");
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        new SiebelDataBase().setAccountStatus(userProfile.getElecAccount(), -4);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLoginPage()
                .loginUserDetails(userProfile)
                .verifyAddress(userProfile.getAccNumber()).navigateToAccountSummaryPage()
                .navigateToPbFlagPage()
                .paperLessBillingAction()            
                .logout();
    }
	
	@Test(groups = {PBFlag,Refactoring})
    public void pbFlagAddNectorVerificationForElectricity() {
        Report.createTestLogHeader("PB Flag Test", "PB Flag Add nectar with electricity test");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLoginPage()
                .loginUserDetails(userProfile)
                .verifyAddress(userProfile.getAccNumber()).navigateToAccountSummaryPage()
                .navigateToPbFlagPage()
                .paperLessAddNector()      
        .logout();
    }	
	@Test(groups = {PBFlag,Refactoring})
    public void pbFlagAddNectorVerificationForJI() {
        Report.createTestLogHeader("PB Flag Test", "PB Flag add nectar Test");
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLoginPage()
                .loginUserDetails(userProfile)
                .verifyAddress(userProfile.getAccNumber()).navigateToAccountSummaryPage()
                .navigateToPbFlagPage()
                .paperLessAddNector()     
        .logout();
    }
	
	@Test(groups = {PBFlag,Refactoring})
    public void pbFlagNectorLaterVerificationForGas() {
        Report.createTestLogHeader("PB Flag Test", "PB Flag nector card later- Test");
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLoginPage()
                .loginUserDetails(userProfile)
                .verifyAddress(userProfile.getAccNumber()).navigateToAccountSummaryPage()
                .navigateToPbFlagPage()
               .paperLessNectorCardLater()            
        .logout();
    }
	
	@Test(groups = {PBFlag})
    public void pbFlagNoThanksVerificationForDual() {
        Report.createTestLogHeader("PB Flag Test", "PB Flag no thanks- Test");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLoginPage()
                .loginUserDetails(userProfile)
                .verifyAddress(userProfile.getAccNumber()).navigateToAccountSummaryPage()
                .navigateToPbFlagPage()
                .paperLessNoThanks()
        .logout();
    }	
	@Test(groups = {PBFlag,Refactoring})
    public void pbFlagNoThanksVerificationForJI() {
        Report.createTestLogHeader("PB Flag Test", "PB Flag no thanks Test");
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLoginPage()
                .loginUserDetails(userProfile)
                .verifyAddress(userProfile.getAccNumber()).navigateToAccountSummaryPage()
                .navigateToPbFlagPage()
                .paperLessNoThanks()
        .logout();
    }
	@Test(groups = {PBFlag,Refactoring})
    public void pbFlagSignUpVerificationForGas() {
        Report.createTestLogHeader("PB Flag Test", "PB Flag - Test");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLoginPage()
                .loginUserDetails(userProfile)
                .verifyAddress(userProfile.getAccNumber()).navigateToAccountSummaryPage()
                .navigateToPbFlagPage()
                .paperLessSignUp()     
        .logout();
    }	
	@Test(groups = {PBFlag,Refactoring})
    public void pbFlagSignUpVerificationForDual() {
        Report.createTestLogHeader("PB Flag Test", "PB Flag - Test");
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLoginPage()
                .loginUserDetails(userProfile)
                .verifyAddress(userProfile.getAccNumber()).navigateToAccountSummaryPage()
                .navigateToPbFlagPage()
                .paperLessSignUp()     
        .logout();
    }	
	@Test(groups = {PBFlag,Refactoring})
    public void pbFlagSignUpVerificationForJI() {
        Report.createTestLogHeader("PB Flag Test", "PB Flag - Test");
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLoginPage()
                .loginUserDetails(userProfile)
                .verifyAddress(userProfile.getAccNumber()).navigateToAccountSummaryPage()
                .navigateToPbFlagPage()
                .paperLessSignUp()     
        .logout();
    }	
	@Test(groups = {PBFlag,Refactoring})
    public void pbFlagSignUpVerificationForElectricity() {
        Report.createTestLogHeader("PB Flag Test", "PB Flag - Test");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLoginPage()
                .loginUserDetails(userProfile)
                .verifyAddress(userProfile.getAccNumber()).navigateToAccountSummaryPage()
                .navigateToPbFlagPage()
                .paperLessSignUp()     
        .logout();
    }	
	

			
	@Test(groups = {PBFlag,Refactoring})
    public void pbFlagVerificationForBGS() {
        Report.createTestLogHeader("PB Flag Test", "Non existance of go paperless link verification for BGS Customer");
        UserProfile userProfile = new TestDataHelper().getUserProfile("HomecareAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLoginPage()
                .loginUserDetails(userProfile)
                .verifyAddress(userProfile.getAccNumber()).navigateToAccountSummaryPage()
                .verifyPBFlagLinkAction()           
        .logout();
    }	
	@Test(groups = {PBFlag,Refactoring})
    public void pbFlagVerificationForSSO() {
        Report.createTestLogHeader("PB Flag Test", "Non existance of go paperless link verification for SSO Customer");
        UserProfile userProfile = new TestDataHelper().getUserProfile("SSOAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLoginPage()
                .loginUserDetails(userProfile)
                .verifyAddress(userProfile.getAccNumber()).navigateToAccountSummaryPage()
                .verifyPBFlagLinkAction()            
        .logout();
    }
}
