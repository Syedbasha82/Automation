package bg.framework.app.functional.test.selfServe;


import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;

import static bg.framework.app.functional.entities.FunctionalCategory.ForgotEmail;
import static bg.framework.app.functional.entities.FunctionalCategory.Refactoring;
import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;

public class ForgotEmailTest extends TestBase {

    @SuppressWarnings("unchecked")
    @Test(groups ={ForgotEmail})
    //Mandatory Fields in Userprofile.xml : UCRN
    public void verifyGasForgotEmailPage() {
        Report.createTestLogHeader("Forgot Email Journey", "To Verify Gas OAM user can successfully complete Forgot Email Address Journey for Gas Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
            new HomePageAction()
            		.navigatetoForgotEmailPage()
                    .verifyForgotEmailPage(userProfile)
                    .verifyForgotEmailBreadCrumbValidation(userProfile)
                    .verifyForgotEmailWhereCanIFindValidation(userProfile)
                    .verifyForgotEmailTitleValidation(userProfile)
                    .verifyEnterEmailValidation(userProfile);
       
    }

    @SuppressWarnings("unchecked")
    @Test(groups ={ForgotEmail})
    //Mandatory Fields in Userprofile.xml : UCRN
    public void verifyElecForgotEmailPage() {
        Report.createTestLogHeader("Forgot Email Journey", "To Verify Electricity OAM user can successfully complete Forgot Email Address Journey for Elec Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        new HomePageAction().navigatetoForgotEmailPage()
                    .verifyForgotEmailPage(userProfile)
                    .verifyForgotEmailBreadCrumbValidation(userProfile)                    
                    .verifyForgotEmailWhereCanIFindValidation(userProfile)
                    .verifyForgotEmailTitleValidation(userProfile)
                    .verifyEnterEmailValidation(userProfile);
        }
    
    
    @SuppressWarnings("unchecked")
    @Test(groups ={ForgotEmail})
    //Mandatory Fields in Userprofile.xml : UCRN
    public void verifyJIForgotEmailPage() {
        Report.createTestLogHeader("Forgot Email Journey", "To Verify JI OAM user can successfully complete Forgot Email Address Journey for JI Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
            new HomePageAction().navigatetoForgotEmailPage()
                    .verifyForgotEmailPage(userProfile)
                    .verifyForgotEmailBreadCrumbValidation(userProfile)                   
                    .verifyForgotEmailWhereCanIFindValidation(userProfile)
                    .verifyForgotEmailTitleValidation(userProfile)
                    .verifyEnterEmailValidation(userProfile);
        }
   
    
    @SuppressWarnings("unchecked")
    @Test(groups ={ForgotEmail})
    //Mandatory Fields in Userprofile.xml : UCRN
    public void verifyDualForgotEmailPage() {
        Report.createTestLogHeader("Forgot Email Journey", "To Verify Dual OAM user can successfully complete Forgot Email Address Journey for DualAccount");
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
            new HomePageAction().navigatetoForgotEmailPage()
                    .verifyForgotEmailPage(userProfile)
                    .verifyForgotEmailBreadCrumbValidation(userProfile)
                    .verifyForgotEmailWhereCanIFindValidation(userProfile)
                    .verifyForgotEmailTitleValidation(userProfile)
                    .verifyEnterEmailValidation(userProfile);
        }
    
    
    @SuppressWarnings("unchecked")
    @Test(groups ={ForgotEmail})
    //Mandatory Fields in Userprofile.xml : UCRN
    public void verifyMixedBrandForgotEmailPage() {
        Report.createTestLogHeader("Forgot Email Journey", "To Verify Mixed Brand OAM user can successfully complete Forgot Email Address Journey for MixedBrandCustomer");
        UserProfile userProfile = new TestDataHelper().getUserProfile("MixedBrandCustomer");
            new HomePageAction().navigatetoForgotEmailPage()
                    .verifyForgotEmailPage(userProfile)
                    .verifyForgotEmailBreadCrumbValidation(userProfile)
                    .verifyForgotEmailWhereCanIFindValidation(userProfile)
                    .verifyForgotEmailTitleValidation(userProfile)
                    .verifyEnterEmailValidation(userProfile);
        }
   
    @SuppressWarnings("unchecked")
    @Test(groups ={ForgotEmail,Refactoring})
    public void verifyGasErrorMessage() {
        Report.createTestLogHeader("Forgot Email Journey", "Error Message Validation for Forgot Email Address Journey for Gas Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
            new HomePageAction().navigatetoForgotEmailPage()
                    .verifyAccountNumErrorMsg(userProfile)
                    .verifyFirstNameErrorMsg(userProfile)
                    .verifyLastNameErrorMsg(userProfile);
        }


    @SuppressWarnings("unchecked")
    @Test(groups = {ForgotEmail,Refactoring})
    //Mandatory Fields in Userprofile.xml : UCRN
    public void verifyForgotEmailGasDBValidation() {
        Report.createTestLogHeader("Forgot Email Journey", "Database Validation For Gas Locked and Inactive accounts");
            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
            new HomePageAction().navigatetoForgotEmailViaForgotPassScreen()
               .verifyDBConversionData(userProfile)
               .verifyAccountLockEmailAddress(userProfile)
               .validateInactiveAccount(userProfile);
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {ForgotEmail})
    //Mandatory Fields in Userprofile.xml : UCRN
    public void verifyForgotEmailElecDBValidation() {
        Report.createTestLogHeader("Forgot Email Journey", "Database Validation For Electricity Locked and Inactive accounts");
            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
            new HomePageAction().navigatetoForgotEmailViaForgotPassScreen()
               .verifyDBConversionData(userProfile)
               .verifyAccountLockEmailAddress(userProfile)
               .validateInactiveAccount(userProfile);
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {ForgotEmail})
    //Mandatory Fields in Userprofile.xml : UCRN
    public void verifyForgotEmailJIDBValidation() {
        Report.createTestLogHeader("Forgot Email Journey", "Database Validation For JI Locked and Inactive accounts");
            UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
            new HomePageAction().navigatetoForgotEmailViaForgotPassScreen()
               .verifyDBConversionData(userProfile)
               .verifyAccountLockEmailAddress(userProfile)
               .validateInactiveAccount(userProfile);
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {ForgotEmail})
    //Mandatory Fields in Userprofile.xml : UCRN
    public void verifyForgotEmailDualAccDBValidation() {
        Report.createTestLogHeader("Forgot Email Journey", "Database Validation For Dual Account Locked and Inactive accounts");
            UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
            new HomePageAction().navigatetoForgotEmailViaForgotPassScreen()
               .verifyDBConversionData(userProfile)
               .verifyAccountLockEmailAddress(userProfile)
               .validateInactiveAccount(userProfile);
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {ForgotEmail})
    //Mandatory Fields in Userprofile.xml : UCRN
    public void verifyForgotEmailDMixedBrandDBValidation() {
        Report.createTestLogHeader("Forgot Email Journey", "Database Validation For Mixed Brand Customer Account Locked and Inactive accounts");
            UserProfile userProfile = new TestDataHelper().getUserProfile("MixedBrandCustomer");
            new HomePageAction().navigatetoForgotEmailViaForgotPassScreen()
               .verifyDBConversionData(userProfile)
               .verifyAccountLockEmailAddress(userProfile)
               .validateInactiveAccount(userProfile);
    }
}
