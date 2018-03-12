package bg.framework.app.functional.test.selfServe;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.selfServe.ContactUsAction;
import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;
import bg.framework.app.functional.entities.UserProfile;
import static bg.framework.app.functional.entities.FunctionalCategory.*;

/**
 * Created by IntelliJ IDEA.
 * User: !athimook
 * Date: 24/11/11
 * Time: 15:20
 * To change this template use File | Settings | File Templates.
 */

public class ContactUsTest extends TestBase {
    @SuppressWarnings("unchecked")
    @Test(groups = {Contactus,Smoke,AnonymousRegression})
    public void verifyAnonymousJourney(){
        UserProfile userProfile =  new TestDataHelper().getUserProfile("ElectricityAccount");
        Report.createTestLogHeader("Contact Us","Anonymous Journey");
        //Pre condition Methods
        //getCustomerDetailsToUserProfileAnonymous(userProfile);
            new HomePageAction()
                .navigateToContactUsPage()
                .verifyContactUsAnon(userProfile,"Anonymous");
    }

    @SuppressWarnings("unchecked")
   @Test(groups = {/*Contactus,Smoke*//*OAMRegression*/})
    public void verifyOAMJourney() {
        Report.createTestLogHeader("Contact Us", "OAM Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //Pre condition Methods
  //      getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToContactUsPage()
                .verifyContactUsOAM(userProfile,"OAM");
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {Contactus,Smoke})
     public void verifyAnonymousContactusPageValidation() {
    	   Report.createTestLogHeader("Contact Us","Anonymous Journey Page Validation");
    	    new HomePageAction()
            .navigateToContactUsPage()
            .contactuspageValidation();
    }
    
//////////////////////////////////////////Contact US Journey Single Iteration///////////////
    @SuppressWarnings("unchecked")
    @Test(groups = {Contactus,Smoke,AnonymousRegression})
    public void verifyContactUsAnonymousJourney(){
        UserProfile userProfile =  new TestDataHelper().getUserProfile("ElectricityAccount");
        Report.createTestLogHeader("Contact Us","Anonymous Journey");
        //Pre condition Methods
        //getCustomerDetailsToUserProfileAnonymous(userProfile);
            new HomePageAction()
                .navigateToContactUsPage()
                .verifyContactusJourney();
    }
	/* @SuppressWarnings("unchecked")
    @Test(groups = {Regression, Contactus})
    public void verifyErrorMessagesForAnonymousCustomer() {
        Report.createTestLogHeader("Contact Us", "Field Level Error Validation for Anonymous customer");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
                //Pre condition Methods
        //getCustomerDetailsToUserProfileAnonymous(userProfile);
        try{
          new HomePageAction()
                .navigateToContactUsPage()
                .verifyAnonymousFieldLevelErrors(userProfile);
        }finally{
            // Post condition method
            //registerCustomerDetailsInOnlineDB(userProfile);
        }


    }


    @SuppressWarnings("unchecked")
    @Test(groups = {Regression, Contactus})
    public void verifyErrorMessagesforOAMCustomer() {
        Report.createTestLogHeader("Contact Us", "Field Level Error Validation for OAM customer");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //Pre condition Methods
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .navigateToContactUsPage()
                .verifyOAMFieldLeverErrors(userProfile);
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {Regression,Contactus})
    public void verifyLoginLink() {
        Report.createTestLogHeader("Contact Us", "verify login link");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
                //Pre condition Methods
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToContactUsPage()
                .navigateToLoginPage(userProfile)
                .loginUserAutoDirectToContactUsPage(userProfile);
    }

   @SuppressWarnings("unchecked")
   @Test(groups = {Regression,Contactus})
    public void verifyDropDownList(){
        Report.createTestLogHeader("Contact Us","Verify drop down lists");
        UserProfile userProfile =  new TestDataHelper().getUserProfile("ElectricityAccount");
       new HomePageAction()
                .navigateToContactUsPage();
        new ContactUsAction()
                .verifyCategoryAndProductDropdown(ApplicationConfig.BRAND);
    }*/
    
}