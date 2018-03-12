package bg.framework.app.functional.test.selfServe;

import bg.framework.app.functional.action.common.HomePageAction;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import bg.framework.app.functional.util.SiebelDataBase;
import org.testng.annotations.Test;

import static bg.framework.app.functional.entities.FunctionalCategory.ManagePersonalDetails;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import static bg.framework.app.functional.entities.FunctionalCategory.Complex;
import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 03/04/12
 * Time: 11:34
 * To change this template use File | Settings | File Templates.
 */

public class ManagePersonalDetailsTest extends TestBase {

    @SuppressWarnings("unchecked")
    /*@Test(groups = {Regression, ManagePersonalDetails})
    public void verifyOAMElecMpd() {
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        Report.createTestLogHeader("Manage Personal Details", "OAM user Manage Personal Details Journey");
        getCustomerDetailsToUserProfileOAM(userProfile);
        UserProfile userProfileReset = userProfile;
        try {
            new HomePageAction()
                    .navigateToLogin()
                    .login(userProfile)
                    .navigateToAccountSummaryPage(userProfile)
                    .navigateToManagePersonalDetailsPage()
                    .fillValidDataInManagePersonalDetailsPage(userProfile)
                    .verifyConfirmationOverLayClickLogin()
                    .login(userProfile)
                    .verifyLogin(userProfile.getLastName(), userProfile.getAccNumber());
            getCustomerDetailsToUserProfileOAM(userProfileReset);
            userProfile = userProfileReset;
        } finally {
        }
    }*/
    
   @Test(groups = {Regression, ManagePersonalDetails})
    public void verifyOAMGASMPD() {
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        Report.createTestLogHeader("Manage Personal Details", "OAM user Manage Personal Details Journey");
        getCustomerDetailsToUserProfileOAM(userProfile);
        UserProfile userProfileReset = userProfile;
        try {
            new HomePageAction()
                    .navigateToLogin()
                    .login(userProfile)
                    .navigateToAccountSummaryPage(userProfile)
                    .navigateToManagePersonalDetailsPage()
                    .fillValidDataInManagePersonalDetailsPage(userProfile)
                    .verifyConfirmationOverLayClickLogin()
                    .login(userProfile)
                    .verifyLogin(userProfile.getLastName(), userProfile.getAccNumber());
            getCustomerDetailsToUserProfileOAM(userProfileReset);
            userProfile = userProfileReset;
        } finally {
        }
    }
    
    @Test(groups = {Regression, ManagePersonalDetails})
    public void verifyOAMDualMPD() {
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        Report.createTestLogHeader("Manage Personal Details", "OAM user Manage Personal Details Journey");
        getCustomerDetailsToUserProfileOAM(userProfile);
        UserProfile userProfileReset = userProfile;
        try {
            new HomePageAction()
                    .navigateToLogin()
                    .login(userProfile)
                    .navigateToAccountSummaryPage(userProfile)
                    .navigateToManagePersonalDetailsPage()
                    .fillValidDataInManagePersonalDetailsPage(userProfile)
                    .verifyConfirmationOverLayClickLogin()
                    .login(userProfile)
                    .verifyLogin(userProfile.getLastName(), userProfile.getAccNumber());
            getCustomerDetailsToUserProfileOAM(userProfileReset);
            userProfile = userProfileReset;
        } finally {
        }
    }
    
    @Test(groups = {Regression, ManagePersonalDetails})
    public void verifyFieldValidation()
    {
    	UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        Report.createTestLogHeader("Manage Personal Details", "OAM user Manage Personal Details Journey");
        getCustomerDetailsToUserProfileOAM(userProfile);
        UserProfile userProfileReset = userProfile;
        try {
            new HomePageAction()
                    .navigateToLogin()
                    .login(userProfile)
                    .navigateToAccountSummaryPage(userProfile)
                    .navigateToManagePersonalDetailsPage()
                    .verifyFieldValidation();
            		
            getCustomerDetailsToUserProfileOAM(userProfileReset);
            userProfile = userProfileReset;
        } finally {
        }
    }
	
    @Test(groups = {Smoke, ManagePersonalDetails})
    public void verifyOAMGasMPDUpdateJourney()
    {
    	UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        Report.createTestLogHeader("Manage Personal Details", "OAM Gas user Manage Personal Details Journey");
        
        getCustomerDetailsToUserProfileOAM(userProfile);
        UserProfile userProfileReset = userProfile;
        try {
            new HomePageAction()
                    .navigateToLogin()
                    .login(userProfile)
                    .navigateToAccountSummaryPage(userProfile)
            		.navigateToContactUs()
                    .navigateToMovingHomePage()
               		.navigateToManagePersonalDetailsPage()
            		.fillValidDataInManagePersonalDetailsPage(userProfile)
            		.verifyFillDataWithDB(userProfile)
            		.verifyFillDataWithSiebel(userProfile)
            		.verifyConfirmationOverLayClickLogin()
            		.login(userProfile)
            		//.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
            		.navigateToAccountSummaryPage(userProfile)
            		.navigateToManagePersonalDetailsPage()
            		.logout();
            		
                    getCustomerDetailsToUserProfileOAM(userProfileReset);
            userProfile = userProfileReset;
        } finally {
        }
    }
    
    @Test(groups = {Regression, ManagePersonalDetails})
    public void verifyOAMElecMPDUpdateJourney()
    {
    	UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        Report.createTestLogHeader("Manage Personal Details", "OAM Electricity user Manage Personal Details Journey");
        
        getCustomerDetailsToUserProfileOAM(userProfile);
        UserProfile userProfileReset = userProfile;
        try {
            new HomePageAction()
                    .navigateToLogin()
                    .login(userProfile)
                    .navigateToAccountSummaryPage(userProfile)
            		.navigateToContactUs()
                    .navigateToMovingHomePage()
               		.navigateToManagePersonalDetailsPage()
            		.fillValidDataInManagePersonalDetailsPage(userProfile)
            		.verifyFillDataWithDB(userProfile)
            		.verifyFillDataWithSiebel(userProfile)
            		.verifyConfirmationOverLayClickLogin()
            		.login(userProfile)
            		//.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
            		.navigateToAccountSummaryPage(userProfile)
            		.navigateToManagePersonalDetailsPage()
            		.logout();
            		
                    getCustomerDetailsToUserProfileOAM(userProfileReset);
            userProfile = userProfileReset;
        } finally {
        }
    }
    
    @Test(groups = {Regression,Complex,ManagePersonalDetails})
    public void verifyOAMJIMPDUpdateJourney()
    {
    	UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        Report.createTestLogHeader("Manage Personal Details", "OAM JI user Manage Personal Details Journey");
        
       // getCustomerDetailsToUserProfileOAM(userProfile);
        UserProfile userProfileReset = userProfile;
        try {
            new HomePageAction()
                    .navigateToLogin()
                    .login(userProfile)
                    .navigateToAccountSummaryPage(userProfile)
            		.navigateToContactUs()
                    .navigateToMovingHomePage()
               		.navigateToManagePersonalDetailsPage()
            		.fillValidDataInManagePersonalDetailsPage(userProfile)
            		.verifyFillDataWithDB(userProfile)
            		.verifyFillDataWithSiebel(userProfile)
            		.verifyConfirmationOverLayClickLogin()
            		.login(userProfile)
            		//.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
            		.navigateToAccountSummaryPage(userProfile)
            		.navigateToManagePersonalDetailsPage()
            		.logout();
            		
                    getCustomerDetailsToUserProfileOAM(userProfileReset);
            userProfile = userProfileReset;
        } finally {
        }
    }
    
    @Test(groups = {Regression, ManagePersonalDetails})
    public void verifyOAMHomeServiceMPDUpdateJourney()
    {
    	UserProfile userProfile = new TestDataHelper().getUserProfile("HomeSerivcesAccount");
        Report.createTestLogHeader("Manage Personal Details", "OAM Home Services user Manage Personal Details Journey");
        
        getCustomerDetailsToUserProfileOAM(userProfile);
        UserProfile userProfileReset = userProfile;
        try {
            new HomePageAction()
                    .navigateToLogin()
                    .login(userProfile)
                    .navigateToAccountSummaryPage(userProfile)
            		.navigateToContactUs()
                    .navigateToMovingHomePage()
               		.navigateToManagePersonalDetailsPage()
            		.fillValidDataInManagePersonalDetailsPage(userProfile)
            		.verifyFillDataWithDB(userProfile)
            		.verifyFillDataWithSiebel(userProfile)
            		.verifyConfirmationOverLayClickLogin()
            		.login(userProfile)
            		//.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
            		.navigateToAccountSummaryPage(userProfile)
            		.navigateToManagePersonalDetailsPage()
            		.logout();
            		
                    getCustomerDetailsToUserProfileOAM(userProfileReset);
            userProfile = userProfileReset;
        } finally {
        }
    }
    
    @Test(groups = {Regression, ManagePersonalDetails})
    public void verifyOAMInActiveMPDUpdateJourney()
    {
    	UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        Report.createTestLogHeader("Manage Personal Details", "OAM Gas Inactive user Manage Personal Details Journey");
        
        getCustomerDetailsToUserProfileOAM(userProfile);
        new SiebelDataBase().setAccountStatus(userProfile.getAccNumber(), -4);
        UserProfile userProfileReset = userProfile;
        try {
            new HomePageAction()
                    .navigateToLogin()
                    .login(userProfile)
                    .navigateToAccountSummaryPage(userProfile)
            		.navigateToContactUs()
                    .navigateToMovingHomePage()
               		.navigateToManagePersonalDetailsPage()
            		.fillValidDataInManagePersonalDetailsPage(userProfile)
            		.verifyFillDataWithDB(userProfile)
            		.verifyFillDataWithSiebel(userProfile)
            		.verifyConfirmationOverLayClickLogin()
            		.login(userProfile)
            		//.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
            		.navigateToAccountSummaryPage(userProfile)
            		.navigateToManagePersonalDetailsPage()
            		.logout();
            		
                    getCustomerDetailsToUserProfileOAM(userProfileReset);
            userProfile = userProfileReset;
        } finally {
        }
    }
    
    @Test(groups = {Regression,Complex, ManagePersonalDetails})
    public void verifyOAMSSOMPD()
    {
    	UserProfile userProfile = new TestDataHelper().getUserProfile("SSOAccount");
        Report.createTestLogHeader("Manage Personal Details", "OAM SSO user Manage Personal Details Journey");
        getCustomerDetailsToUserProfileOAM(userProfile);
        UserProfile userProfileReset = userProfile;
        try {
            new HomePageAction()
                    .navigateToLogin()
                    .login(userProfile)
                    .navigateToAccountSummaryPage(userProfile)
            		.navigateToContactUs()
                    .navigateToMovingHomePage()
               		.navigateToManagePersonalDetailsPage();
            // Check the err msg validation
            getCustomerDetailsToUserProfileOAM(userProfileReset);
            userProfile = userProfileReset;
        } finally {
        }
    }
}
