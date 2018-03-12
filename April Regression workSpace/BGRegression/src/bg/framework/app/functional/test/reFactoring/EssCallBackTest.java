package bg.framework.app.functional.test.reFactoring;

import bg.framework.app.functional.action.common.HomePageAction;

import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.action.reFactoring.EssCallBackAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;

import static bg.framework.app.functional.entities.FunctionalCategory.Refactoring;
import static bg.framework.app.functional.entities.FunctionalCategory.EssCallBack;
import static bg.framework.app.functional.entities.FunctionalCategory.SalesRegressionAnonymous;
import static bg.framework.app.functional.entities.FunctionalCategory.SalesRegressionOAM;

/**
 * ESS Call Back Scenarios
 */
public class EssCallBackTest extends TestBase {

	/* Run in BG Site - Anonymous Customer*/
    @SuppressWarnings("unchecked")
	@Test(groups ={EssCallBack , SalesRegressionAnonymous})
	public void verifyBGAnonymousSingleESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Anonymous Journey with Single Product Selection with All Products in British Gas Site");
        new HomePageAction()
			.navigateToLogout();
        new EssCallBackAction()
                .navigateToESSCallbackPage()
                .navigateToRequestaCallBackPage()
                .selectSingleProduct();

    }
    /* Run in SE Site - Anonymous Customer*/
    @Test(groups ={EssCallBack , SalesRegressionAnonymous})
	public void verifySEAnonymousSingleESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Anonymous Journey with Single Product Selection with All in Sainsbury's site");
        new HomePageAction()
			.navigateToLogout();
        new EssCallBackAction()
                .navigateToESSCallbackPage()
                .navigateToSERequestaCallBackPage()
                .selectSESingleProduct();
    }
    /* Run in BG Site - Anonymous Customer*/
    @SuppressWarnings("unchecked")
	@Test(groups ={EssCallBack , SalesRegressionAnonymous})
	public void verifyBGAnonymousMultipleESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Anonymous Journey with Multiple Product Selection from Energy Savers Store Page");
        new HomePageAction()
			.navigateToLogout();
        new EssCallBackAction()
                .navigateToESSCallbackPage()
                .navigateToRequestaCallBackPage()
                .selectMultipleProduct()
                .enterAnonyRequestCallBackDetails()
                .verifyMultipleProduct()
                .navigateToContinueShoppingPage();
    }
    /* Run in BG Site - Anonymous Customer*/
    @SuppressWarnings("unchecked")
	@Test(groups ={EssCallBack , SalesRegressionAnonymous})
	public void verifyBGHeatingESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Anonymous Journey with Multiple Product Selection from Heating Page from LHS");
        new HomePageAction()
		.navigateToLogout();
        new EssCallBackAction()
                .navigateToESSCallbackPage()
                .navigateToHeatingPage()
                .navigateToRequestaCallBackPage()
                .selectMultipleProduct()
                .enterAnonyRequestCallBackDetails()
                .verifyMultipleProduct()
                .navigateToContinueShoppingPage();
    }
    /* Run in BG Site - Anonymous Customer*/
    @SuppressWarnings("unchecked")
	@Test(groups ={EssCallBack , SalesRegressionAnonymous})
	public void verifyBGHeatingBottomESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Anonymous Journey with Multiple Product Selection from Heating Page from Bottom");
        new HomePageAction()
		.navigateToLogout();
        new EssCallBackAction()
                .navigateToESSCallbackPage()
                .navigateToHeatingPage()
                .navigateToBottomRequestCallBack()
                .selectMultipleProduct()
                .enterAnonyRequestCallBackDetails()
                .verifyMultipleProduct()
                .navigateToContinueShoppingPage();
    }
    
    /* Run in BG Site - Anonymous Customer*/
    @SuppressWarnings("unchecked")
	@Test(groups ={EssCallBack , SalesRegressionAnonymous})
	public void verifyBGStandByPowerESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Anonymous Journey with Multiple Product Selection from StandBy Power Page from LHS");
        new HomePageAction()
		.navigateToLogout();
        new EssCallBackAction()
                .navigateToESSCallbackPage()
                .navigateToStandbypowersaversLink()
                .navigateToRequestaCallBackPage()
                .selectMultipleProduct()
                .enterAnonyRequestCallBackDetails()
                .verifyMultipleProduct()
                .navigateToContinueShoppingPage();
    }
    
    @SuppressWarnings("unchecked")
	@Test(groups ={EssCallBack , SalesRegressionAnonymous})
	public void verifyBGStandByPowerBottomESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Anonymous Journey with Multiple Product Selection from StandBy Power Page from Bottom");
        new HomePageAction()
		.navigateToLogout();
        new EssCallBackAction()
                .navigateToESSCallbackPage()
                .navigateToStandbypowersaversLink()
                .navigateToBottomRequestCallBack()
                .selectMultipleProduct()
                .enterAnonyRequestCallBackDetails()
                .verifyMultipleProduct()
                .navigateToContinueShoppingPage();
    }
    
    @SuppressWarnings("unchecked")
	@Test(groups ={EssCallBack , SalesRegressionAnonymous})
	public void verifyBGGreenGadgetsESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Anonymous Journey with Multiple Product Selection from Green Gadgets Page from LHS");
        new HomePageAction()
		.navigateToLogout();
        new EssCallBackAction()
                .navigateToESSCallbackPage()
                .navigateToGreenGadgets()
                .navigateToRequestaCallBackPage()
                .selectMultipleProduct()
                .enterAnonyRequestCallBackDetails()
                .verifyMultipleProduct()
                .navigateToContinueShoppingPage();
    }
    
    @SuppressWarnings("unchecked")
	@Test(groups ={EssCallBack , SalesRegressionAnonymous})
	public void verifyBGGreenGadgetsBottomESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Anonymous Journey with Multiple Product Selection from Green Gadgets Page from Bottom");
        new HomePageAction()
		.navigateToLogout();
        new EssCallBackAction()
                .navigateToESSCallbackPage()
                .navigateToGreenGadgets()
                .navigateToBottomRequestCallBack()
                .selectMultipleProduct()
                .enterAnonyRequestCallBackDetails()
                .verifyMultipleProduct()
                .navigateToContinueShoppingPage();
    }

    @SuppressWarnings("unchecked")
	@Test(groups ={EssCallBack,Refactoring , SalesRegressionAnonymous})
	public void verifyErrorMessagesESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Field Level Validations for ESS Call Back Page");
        new HomePageAction()
		.navigateToLogout();
        new EssCallBackAction()
                .navigateToESSCallbackPage()
                .navigateToRequestaCallBackPage()
                .verifyErrorMessages();
    }
    @SuppressWarnings("unchecked")
	@Test(groups ={EssCallBack,Refactoring,SalesRegressionOAM})
	public void verifyBGGasESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "GAS Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        //activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
		.navigateToLogout();
        new LoginAction()
                .loginUser(userProfile)
                .navigateToRequestCallBackPage()
                .navigateToRequestaCallBackPage()
                .selectMultipleProduct()
                .enterRequestCallBackDetails(userProfile)
                .verifyMultipleProduct()
                .logout();
    }

    @SuppressWarnings("unchecked")
	@Test(groups ={EssCallBack,Refactoring,SalesRegressionOAM})
	public void verifyBGElecESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Electricity Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
		.navigateToLogout();
        new LoginAction()
                .loginUser(userProfile)
                .navigateToRequestCallBackPage()
                .navigateToRequestaCallBackPage()
                .selectMultipleProduct()
                .enterRequestCallBackDetails(userProfile)
                .verifyMultipleProduct()
                .logout();
    }
    
	@SuppressWarnings("unchecked")
	@Test(groups ={EssCallBack,Refactoring,SalesRegressionOAM})
	public void verifyBGJIESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Joint Invoice (JI) Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        //activateCustomerDetailsInOnlineDB(userProfile);
      //  getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
		.navigateToLogout();
        new LoginAction()
                .loginUser(userProfile)
                .navigateToRequestCallBackPage()
                .navigateToRequestaCallBackPage()
                .selectMultipleProduct()
                .enterRequestCallBackDetails(userProfile)
                .verifyMultipleProduct()
                .logout();
    }
	
    @SuppressWarnings("unchecked")
	@Test(groups ={EssCallBack,Refactoring,SalesRegressionOAM})
	public void verifyBGMixedESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Mixed Brand Customer Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        //activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
		.navigateToLogout();
        new LoginAction()
                .loginUser(userProfile)
                .navigateToRequestCallBackPage()
                .selectMultipleProduct()
                .enterRequestCallBackDetails(userProfile)
                .verifyMultipleProduct()
                .logout();
    }
    
    @SuppressWarnings("unchecked")
	@Test(groups ={EssCallBack,Refactoring,SalesRegressionOAM})
	public void verifyBGServicesESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "BG Services Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");
        //activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
		.navigateToLogout();
        new LoginAction()
                .loginUser(userProfile)
                .navigateToRequestCallBackPage()
                .selectMultipleProduct()
                .enterRequestCallBackDetails(userProfile)
                .verifyMultipleProduct()
                .logout();
    }
    
	@SuppressWarnings("unchecked")
	@Test(groups ={EssCallBack,Refactoring,SalesRegressionOAM})
	public void verifyBGDualESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Dual Fuel Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        //activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
		.navigateToLogout();
        new LoginAction()
                .loginUser(userProfile)
                .navigateToRequestCallBackPage()
                .navigateToRequestaCallBackPage()
                .selectMultipleProduct()
                .enterRequestCallBackDetails(userProfile)
                .verifyMultipleProduct()
                .logout();
    }
    @SuppressWarnings("unchecked")
	@Test(groups ={EssCallBack,Refactoring})
	public void verifySEGasESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "SE GAS Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        //activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
		.navigateToLogout();
        new LoginAction()
                .loginUser(userProfile)
                .navigateToRequestCallBackPage()
                .selectSEMultipleProduct()
                .enterRequestCallBackDetails(userProfile)
                .verifySEMultipleProduct()
                .logout();
    }
	
    @SuppressWarnings("unchecked")
	@Test(groups ={EssCallBack,Refactoring})
	public void verifySEAnonymousMultipleESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Anonymous Journey with Multiple Product Selection in SE Site");
        new HomePageAction()
		.navigateToLogout();
        new EssCallBackAction()
                .navigateToESSCallbackPage()
                .navigateToSERequestaCallBackPage()
                .selectSEMultipleProduct()
                .enterAnonyRequestCallBackDetails()
                .verifySEMultipleProduct()
                .navigateToSaveCreatePage();
    }
    
    ////Mandatory field: UCRN
    @SuppressWarnings("unchecked")
	@Test(groups ={EssCallBack,Refactoring})
	public void verifyBGFreezedESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Verify Freezed AccountESSCallBack Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("FreezedAccount");
        //activateCustomerDetailsInOnlineDB(userProfile);
        //getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
				.navigateToLogout();
        new LoginAction()
                .loginUser(userProfile)
        		.loginErrorForFreezedAccount(userProfile);
    }
}
