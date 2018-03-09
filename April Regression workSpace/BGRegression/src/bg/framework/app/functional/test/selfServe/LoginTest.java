package bg.framework.app.functional.test.selfServe;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.sales.AcquisitionAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SiebelDataBase;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;

import static bg.framework.app.functional.entities.FunctionalCategory.*;

public class LoginTest extends TestBase {

	SiebelDataBase siebelDB = new SiebelDataBase();
	//Mandatory field : UCRN in userprofile
    @Test(groups = {Regression,Complex,Login})
    public void loginVerificationForJIAndElectricity() {
        Report.createTestLogHeader("Login Verification", "Login for JI and Electricity ");
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAndElectricity");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
                .verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
                .logout();
    }
    
  //Mandatory field : UCRN of a Smart Meter Customer in userprofile 
    @Test(groups = {Regression,Login})
    public void loginVerificationForSmartCustomer() {
        Report.createTestLogHeader("Login Verification For Smart Customer", "Gas account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
        .logout();
    }

  //Mandatory field : UCRN of a smart meter customer in userprofile .
    @Test(groups = {Regression,Login})
    public void loginEmailCheckVerificationSmartCustomer() {
        Report.createTestLogHeader("Remember Email verification for smart customer ", "Gas Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        SiebelDataBase siebelDataBase = new SiebelDataBase();
        siebelDataBase.setAccountStatus(userProfile.getAccNumber(), 3);
        new HomePageAction()
                .navigateToLogin()
                .emailCheckBoxVerification(userProfile);


    }
  //Mandatory field : UCRN and Account Number in userprofile
    @Test(groups = {Login,Regression})
    public void loginVerificationForElectricity() {
        Report.createTestLogHeader("Login Verification", "Login for Electricity");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .loginDetails(userProfile)
                .verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
        .logout();
    }

  //Mandatory field : UCRN and Account Number in userprofile
    @Test(groups = {Login,Regression})
    public void loginVerificationForDualAccount() {
        Report.createTestLogHeader("Login Verification", "Login for Dual account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .loginDetails(userProfile)
                .verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
                .verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
        .logout();
    }


  //Mandatory field : UCRN and Account Number in userprofile
    @Test(groups = {Login})
    public void loginVerificationForGasAccount() {
        Report.createTestLogHeader("Login Verification", "Login for Gas account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
      //  getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .loginDetails(userProfile)
                .verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
        .logout();
    }

  //Mandatory field : UCRN and Account Number in userprofile.
    @Test(groups = { Login})
    public void loginVerificationForElectricityAccount() {
        Report.createTestLogHeader("Login Verification", "Login for Inactive less than 6 months Electricity account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
    //    siebelDB.setAccountStatus(userProfile.getElecAccount(), -4);
  //      getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .loginDetails(userProfile)
                .verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
        .logout();
    }

  //Mandatory field : UCRN and Account Number in userprofile
    @Test(groups = {Login,Regression})
    public void loginVerificationForJIAccount() {
        Report.createTestLogHeader("Login Verification", "Login for JI account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
    //    getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .loginDetails(userProfile)
                .verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
        .logout();
    }

  //Mandatory field : UCRN and Account Number in userprofile
    @Test(groups = { Login,Regression})
    public void loginVerificationForNonOAMAccount() {
        Report.createTestLogHeader("Login Verification", "Negative Login for Dual account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
   //     getCustomerDetailsToUserProfileAnonymous(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .loginDetails(userProfile)
                .verifyAccountAbsense(userProfile.getAccNumber())
                .logout();
    }
    //Mandatory field : UCRN and Account Number in userprofile .
   @Test(groups = {Login,Complex,Regression})
    public void loginVerificationForDualAccountAndJI() {
        Report.createTestLogHeader("Login Verification", "Login for Dual and JI account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAndDualAccount");
  //      getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .loginDetails(userProfile)
                .verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
                .verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
                .verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
        .logout();
    }
   //Mandatory field : UCRN and Account Number in userprofile .
    @Test(groups = {Login,Regression})
    public void loginVerificationForDualAndBGS() {
        Report.createTestLogHeader("Login Verification", "Login for dual BGS account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
  //      getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .loginDetails(userProfile)
                .verifyLogin(userProfile.getLastName(), userProfile.getBgsAccount())
                .verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
                .verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
        .logout();
    }
    //Mandatory field : UCRN and Account Number in userprofile .
    @Test(groups = {Login,Complex,Regression})
    public void loginVerificationForWTPGasAndElectricity() {
        Report.createTestLogHeader("Login Verification", "Login for WTP Gas + Electricity account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("WTPAndGasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .loginDetails(userProfile)
                .verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
                .verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
        .logout();
    }
    
    //  Mandatory field : UCRN and Account Number in userprofile
   @Test(groups = {Login,Complex,Regression})
    public void loginVerificationForWTPElectricityAndGasAccount() {
        Report.createTestLogHeader("Login Verification", "login for British Gas account (WTP Electricity + Gas account)");
        UserProfile userProfile = new TestDataHelper().getUserProfile("WTPAndElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .loginDetails(userProfile)
                .verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
                .verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
        .logout();
    }


  //Mandatory : UCRN, and Account Number EMail.
    @Test(groups = {Login,Regression})

    public void loginVerificationForGasSSOAccount() {
        Report.createTestLogHeader("Login Verification", "login for British Gas account with SSO account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("SSOAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .loginDetails(userProfile)
                .verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
                .verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
        .logout();
    }


    //Mandatory field : UCRN and Account Number in userprofile .
    @Test(groups = {Login,Regression,Complex})
    public void loginLockedAccountVerification() {
        Report.createTestLogHeader("Account Login Verification", "Account Lock after 3 Incorrect passwords");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        OnlineDBConnector db = new OnlineDBConnector();
        db.dbAccountlock(userProfile.getUCRN());
        new HomePageAction()
                .navigateToLogin()
                .verifyLockedAccount(userProfile);
    }


    //Mandatory field : UCRN and Account Number in userprofile .
    @Test(groups = {Login,Regression})
    public void loginErrorVerification() {
        Report.createTestLogHeader("Account Login Verification", "Login with incorrect credentials");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
  //      getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .loginErrorValidation(userProfile)
                .logout();

    }

    //Mandatory field : UCRN and Account Number in userprofile .

    @Test(groups = {Login,Regression })
    public void loginInactiveLessSixVerification() {
        Report.createTestLogHeader("Account Login Verification ", "Login account inactive less than 6 mths");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
 //       getCustomerDetailsToUserProfileOAM(userProfile);
//        SiebelDataBase siebelDataBase = new SiebelDataBase();
//        siebelDataBase.setAccountStatus(userProfile.getAccNumber(), -3);
        new HomePageAction()
                .navigateToLogin()
                .loginDetails(userProfile)
                .verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
                .verifyInactiveLessSix()
        .logout();
    }

    //Mandatory field : UCRN and Account Number in userprofile .

    @Test(groups = {Login,Regression})
    public void loginInactiveMoreVerification() {
        Report.createTestLogHeader("Account Login Verification ", "Error message while Login account inactive greater than 6 mths");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
   //     getCustomerDetailsToUserProfileOAM(userProfile);
  //      SiebelDataBase siebelDataBase = new SiebelDataBase();
   //     siebelDataBase.setAccountStatus(userProfile.getAccNumber(), -9);
        new HomePageAction()
                .navigateToLogin()
                .loginForInactiveAccount(userProfile);
    }
    //Mandatory field : UCRN and Account Number in userprofile .
    @Test(groups = {Login,Regression})
    public void loginEmailCheckVerification() {
        Report.createTestLogHeader("Account Login Verification ", "Email Check verification");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        SiebelDataBase siebelDataBase = new SiebelDataBase();
        siebelDataBase.setAccountStatus(userProfile.getAccNumber(), 3);
        new HomePageAction()
                .navigateToLogin()
                .emailCheckBoxVerification(userProfile);


    }
    //  Mandatory field : UCRN and Account Number in userprofile
    @Test(groups = {Login,Regression})
    public void loginVerificationForSSOAccount() {
        Report.createTestLogHeader("Login Verification", "Verify Login for SSO only account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("SSOAccount");
    //    getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .loginDetails(userProfile)
                .verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
        .logout();
    }
//  Mandatory field : UCRN and Account Number in userprofile
    @Test(groups = {Login,Regression})
    public void loginVerificationForMulSupplyAddrAccount() {
        Report.createTestLogHeader("Login Verification", "Verify login for British Gas account (dual account)multiple supplier address");
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .loginDetails(userProfile)
                .verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
                .verifyLogin(userProfile.getLastName(),userProfile.getGasAccount())
        .logout();
    }
    //  Mandatory field : UCRN and Account Number in userprofile
    @Test(groups = {Login,Regression})
    public void loginVerificationForDualJIMulSupplyAddrAccount() {
        Report.createTestLogHeader("Login Verification", "Verify login for British Gas account (dual account + JI )multiple supplier address");
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .loginDetails(userProfile)
                .verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
                .verifyLogin(userProfile.getLastName(),userProfile.getAccNumber())
        .logout();
    }
    //  Mandatory field : UCRN and Account Number in userprofile
    @Test(groups = {Login,Regression})
    public void loginVerificationForDualBGSMulSupplyAddrAccount() {
        Report.createTestLogHeader("Login Verification", "Verify login for British Gas account (dual account + BGS)multiple supplier address");
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .loginDetails(userProfile)
                .verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
                .verifyLogin(userProfile.getLastName(),userProfile.getAccNumber())
        .logout();
    }
    
    //  Mandatory field : UCRN and Account Number in userprofile
    @Test(groups = {Login,Complex})
    public void loginVerificationForAutoRegAccount() {
        Report.createTestLogHeader("Login Verification", "Verify whether AR customer is displayed with the Account overview page while trying to login to the application from login page");
        UserProfile userProfile = new TestDataHelper().getUserProfile("AutoRegAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .loginDetails(userProfile)
                .verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
        .logout();
    }
//  Mandatory field : UCRN and Account Number in userprofile
    @Test(groups = {Login,Regression})
    public void forcedLoginforEnergySmartCustomer() {
        Report.createTestLogHeader("Forced Login Energy Smart", "Verify whether the user is able to login to the application when navigated from the ESmart Your Order page Forced login");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        
        new AcquisitionAction()
                .goToElecClearAndSimplesmart()
                .forcedLoginYourOrderPage(acquisition, userProfile)
                .logoutFromThankYouPage();
    }
//  Mandatory field : UCRN and Account Number in userprofile
    @Test(groups = {Login,Regression}) 
    public void forcedLoginforEnergyShopCustomer() {
        Report.createTestLogHeader("Forced Login Energy Shop", "Verify whether the user is able to login to the application when navigated from the EShop Your order details page Forced Registration");
        final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
        final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        
        new AcquisitionAction()
                .goToElecClearAndSimplesmart()
                .forcedLoginYourOrderPage(acquisition, userProfile)
                .logoutFromThankYouPage();
    }
//  Mandatory field : UCRN and Account Number in userprofile
    @Test(groups = {Login,Regression})
    public void loginVerificationForMixedInactiveAccount() {
        Report.createTestLogHeader("Mixed customer Login Verification", "Verifyount");
        UserProfile userProfile = new TestDataHelper().getUserProfile("MixedBrandCustomer");
        siebelDB.setAccountStatus(userProfile.getElecAccount(), +12);
        siebelDB.setBrandSainsbury(userProfile.getGasAccount());
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .loginDetails(userProfile)
                .verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
        .logout();
    }
    
//  Mandatory field : UCRN and BGS & Elec Account Number in userprofile
    @Test(groups = {Login,Regression})
    public void loginVerificationForInactiveBGSAccount() {
        Report.createTestLogHeader("Login Verification", "Verify that Acount");
        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeSerivcesAccount");
        siebelDB.setAccountStatus(userProfile.getBgsAccount(), -5);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .loginDetails(userProfile)
                .verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
        .logout();
    }
    
    //  Mandatory field : UCRN and Elec Account Number in userprofile
    @Test(groups = {Login,Regression})
    public void loginVerificationForInactiveElecAccount() {
        Report.createTestLogHeader("Login Verification", "Accoun with in 6 months");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        siebelDB.setAccountStatus(userProfile.getElecAccount(), -5);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .loginDetails(userProfile)
                .verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
        .logout();
    }
   
    //  Mandatory field : UCRN and Elec Account Number in userprofile
    @Test(groups = {Login,Regression})
    public void loginVerificationForMPDOverlayverification() {
        Report.createTestLogHeader("Login Verification", "Verify that a Manage Personal Details Overlay will open when a Mixed customer logged in into BG before 6 months");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        siebelDB.setAccountStatus(userProfile.getElecAccount(), -5);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .loginDetails(userProfile)
                .verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
        .logout();
    }

}
