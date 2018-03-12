package bg.framework.app.functional.test.reFactoring;


import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.FunctionalCategory;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SiebelDataBase;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;

import static bg.framework.app.functional.entities.FunctionalCategory.ForgotEmail;
import static bg.framework.app.functional.entities.FunctionalCategory.Refactoring;
import static bg.framework.app.functional.entities.FunctionalCategory.OAMRegression;

public class ForgotEmailTest extends TestBase {

    @SuppressWarnings("unchecked")
    //@Test(groups ={ForgotEmail})
    @Test(groups = {/*FunctionalCategory.ForgotEmail*/OAMRegression}) 
    //Mandatory Fields in Userprofile.xml : UCRN
    public void verifyGasForgotEmailPage_Old() {
        Report.createTestLogHeader("Forgot Email Journey", "To Verify Gas OAM user can successfully complete Forgot Email Address Journey for Gas Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousGasAccount");
            new HomePageAction()
            		.navigatetoForgotEmailPage()
                    .validateForgotEmailNew(userProfile)
                    //.verifyForgotEmailBreadCrumbValidation(userProfile)
                    //.verifyForgotEmailWhereCanIFindValidation(userProfile)
                    .verifyForgotEmailTitleValidationNew(userProfile);
                    //.verifyEnterEmailValidation(userProfile);
       
    }

    @SuppressWarnings("unchecked")
    @Test(groups ={/*ForgotEmail*/OAMRegression})
    //Mandatory Fields in Userprofile.xml : UCRN
    public void verifyElecForgotEmailPage() {
        Report.createTestLogHeader("Forgot Email Journey", "To Verify Electricity OAM user can successfully complete Forgot Email Address Journey for Elec Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousElecAccount");
        new HomePageAction()
        .navigatetoForgotEmailPage()
       .validateForgotEmailNew(userProfile)
        //.verifyForgotEmailBreadCrumbValidation(userProfile)                    
        //.verifyForgotEmailWhereCanIFindValidation(userProfile)
        .verifyForgotEmailTitleValidationNew(userProfile)
        .verifyEnterEmailValidationNew(userProfile);
      //  .verifyEnterEmailValidation(userProfile);
        }
    
    @SuppressWarnings("unchecked")
    @Test(groups ={/*ForgotEmail*/OAMRegression})
    //Mandatory Fields in Userprofile.xml : UCRN
    public void verifyGasForgotEmailPage() {
        Report.createTestLogHeader("Forgot Email Journey", "To Verify Gas OAM user can successfully complete Forgot Email Address Journey for Gas Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousGasAccount");
        new HomePageAction()
        .navigatetoForgotEmailPage()
       .validateForgotEmailNew(userProfile)
        //.verifyForgotEmailBreadCrumbValidation(userProfile)                    
        //.verifyForgotEmailWhereCanIFindValidation(userProfile)
        .verifyForgotEmailTitleValidationNew(userProfile)
        .verifyEnterEmailValidationNew(userProfile);
      //  .verifyEnterEmailValidation(userProfile);
        }
    
    @SuppressWarnings("unchecked")
    @Test(groups ={/*ForgotEmail*/OAMRegression})
    //Mandatory Fields in Userprofile.xml : UCRN
    public void verifyJIForgotEmailPage() {
        Report.createTestLogHeader("Forgot Email Journey", "To Verify JI OAM user can successfully complete Forgot Email Address Journey for JI Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousJIAccount");
        new HomePageAction()
        .navigatetoForgotEmailPage()
       .validateForgotEmailNew(userProfile)
        //.verifyForgotEmailBreadCrumbValidation(userProfile)                    
        //.verifyForgotEmailWhereCanIFindValidation(userProfile)
        .verifyForgotEmailTitleValidationNew(userProfile)
        .verifyEnterEmailValidationNew(userProfile);
      //  .verifyEnterEmailValidation(userProfile);
        }
    
 

    
    
    @SuppressWarnings("unchecked")
    @Test(groups ={/*ForgotEmail*/OAMRegression})
    //Mandatory Fields in Userprofile.xml : UCRN
    public void verifyJIForgotEmailPage_Old() {
        Report.createTestLogHeader("Forgot Email Journey", "To Verify JI OAM user can successfully complete Forgot Email Address Journey for JI Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousJIAccount");
            new HomePageAction()
            .navigatetoForgotEmailPage()
            .verifyForgotEmailPage(userProfile)
            .verifyForgotEmailBreadCrumbValidation(userProfile)                   
            .verifyForgotEmailWhereCanIFindValidation(userProfile)
            //.verifyForgotEmailTitleValidation(userProfile)
            .verifyEnterEmailValidation(userProfile);
        }
   
    
    @SuppressWarnings("unchecked")
    @Test(groups ={/*ForgotEmail*/OAMRegression})
    //Mandatory Fields in Userprofile.xml : UCRN
    public void verifyDualForgotEmailPage() {
        Report.createTestLogHeader("Forgot Email Journey", "To Verify Dual OAM user can successfully complete Forgot Email Address Journey for DualAccount Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        new HomePageAction()
        .navigatetoForgotEmailPage()
       .validateForgotEmailNew(userProfile)
        //.verifyForgotEmailBreadCrumbValidation(userProfile)                    
        //.verifyForgotEmailWhereCanIFindValidation(userProfile)
        .verifyForgotEmailTitleValidationNew(userProfile)
        .verifyEnterEmailValidationNew(userProfile);
      //  .verifyEnterEmailValidation(userProfile);
        }
     
    
    @SuppressWarnings("unchecked")
    @Test(groups ={ForgotEmail})
    //Mandatory Fields in Userprofile.xml : UCRN
    public void verifyDualForgotEmailPage_Old() {
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
    @Test(groups ={ForgotEmail})
    public void verifyGasErrorMessage() {
        Report.createTestLogHeader("Forgot Email Journey", "Error Message Validation for Forgot Email Address Journey for Gas Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
            new HomePageAction().navigatetoForgotEmailPage()
                    .verifyAccountNumErrorMsg(userProfile)
                    .verifyFirstNameErrorMsg(userProfile)
                    .verifyLastNameErrorMsg(userProfile);
        }


    @SuppressWarnings("unchecked")
    @Test(groups = {ForgotEmail})
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
    
    @SuppressWarnings("unchecked")
    @Test(groups ={ForgotEmail})
    //Mandatory Fields in Userprofile.xml : UCRN,BGS Accnt
    public void verifyBGSActiveForgotEmailPage() {
        Report.createTestLogHeader("Forgot Email Journey", "To Verify BGS Active OAM user can successfully complete Forgot Email Address Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccountIB");
            new HomePageAction().navigatetoForgotEmailPage()
                    .verifyForgotEmailPage(userProfile)
                    .verifyForgotEmailBreadCrumbValidation(userProfile)
                    .verifyForgotEmailWhereCanIFindValidation(userProfile)
                    .verifyForgotEmailTitleValidation(userProfile)
                    .verifyEnterEmailValidation(userProfile);
        }
    
    @SuppressWarnings("unchecked")
    @Test(groups ={ForgotEmail})
    //Mandatory Fields in Userprofile.xml : UCRN,BGS Accnt
    public void verifyBGSInActiveForgotEmailPage() {
        Report.createTestLogHeader("Forgot Email Journey", "To Verify BGS InActive OAM user can successfully complete Forgot Email Address Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServciesAccount");
        SiebelDataBase siebelDataBase = new SiebelDataBase();
            new HomePageAction().navigatetoForgotEmailPage()
                    .verifyForgotEmailPage(userProfile)
                    .verifyForgotEmailBreadCrumbValidation(userProfile)
                    .verifyForgotEmailWhereCanIFindValidation(userProfile)
                    .verifyForgotEmailTitleValidation(userProfile)
                    .verifyEnterEmailValidation(userProfile);
        }
    
    @SuppressWarnings("unchecked")
    @Test(groups ={ForgotEmail})
    //Mandatory Fields in Userprofile.xml : UCRN,BGS Accnt
    public void verifyBGSGasActiveForgotEmailPage() {
        Report.createTestLogHeader("Forgot Email Journey", "To Verify BGS and Gas Active OAM user can successfully complete Forgot Email Address Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeSerivcesGasAccount");
            new HomePageAction().navigatetoForgotEmailPage()
                    .verifyForgotEmailPage(userProfile)
                    .verifyForgotEmailBreadCrumbValidation(userProfile)
                    .verifyForgotEmailWhereCanIFindValidation(userProfile)
                    .verifyForgotEmailTitleValidation(userProfile)
                    .verifyEnterEmailValidation(userProfile);
        }
    @SuppressWarnings("unchecked")
    @Test(groups ={ForgotEmail})
    //Mandatory Fields in Userprofile.xml : UCRN,BGS Accnt
    public void verifyBGSElecActiveForgotEmailPage() {
        Report.createTestLogHeader("Forgot Email Journey", "To Verify BGS and Gas Active OAM user can successfully complete Forgot Email Address Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeSerivcesElecAccount");
            new HomePageAction().navigatetoForgotEmailPage()
                    .verifyForgotEmailPage(userProfile)
                    .verifyForgotEmailBreadCrumbValidation(userProfile)
                    .verifyForgotEmailWhereCanIFindValidation(userProfile)
                    .verifyForgotEmailTitleValidation(userProfile)
                    .verifyEnterEmailValidation(userProfile);
        }
}
