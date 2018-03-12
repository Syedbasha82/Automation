package bg.framework.app.functional.test.reFactoring;

import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.action.reFactoring.EssCallBackAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;

import static bg.framework.app.functional.entities.FunctionalCategory.Refactoring;
import static bg.framework.app.functional.entities.FunctionalCategory.EssCallBack;
/**
 * ESS Call Back Scenarios
 */
public class EssCallBackTest extends TestBase {

	/* Run in BG Site - Anonymous Customer*/
    @SuppressWarnings("unchecked")
	@Test(groups ={EssCallBack})
	public void verifyBGAnonymousSingleESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Anonymous Journey with Single Product Selection with All Products in British Gas Site");
        new EssCallBackAction()
                .navigateToESSCallbackPage()
                .navigateToRequestaCallBackPage()
                .selectSingleProduct();

    }
    /* Run in SE Site - Anonymous Customer*/
    @Test(groups ={EssCallBack})
	public void verifySEAnonymousSingleESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Anonymous Journey with Single Product Selection with All in Sainsbury's site");
        new EssCallBackAction()
                .navigateToESSCallbackPage()
                .navigateToSERequestaCallBackPage()
                .selectSESingleProduct();
    }
    /* Run in BG Site - Anonymous Customer*/
    @SuppressWarnings("unchecked")
	@Test(groups ={EssCallBack})
	public void verifyBGAnonymousMultipleESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Anonymous Journey with Multiple Product Selection from Energy Savers Store Page");
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
	@Test(groups ={EssCallBack})
	public void verifyBGHeatingESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Anonymous Journey with Multiple Product Selection from Heating Page from LHS");
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
	@Test(groups ={EssCallBack})
	public void verifyBGHeatingBottomESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Anonymous Journey with Multiple Product Selection from Heating Page from Bottom");
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
	@Test(groups ={EssCallBack})
	public void verifyBGStandByPowerESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Anonymous Journey with Multiple Product Selection from StandBy Power Page from LHS");
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
	@Test(groups ={EssCallBack})
	public void verifyBGStandByPowerBottomESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Anonymous Journey with Multiple Product Selection from StandBy Power Page from Bottom");
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
	@Test(groups ={EssCallBack})
	public void verifyBGGreenGadgetsESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Anonymous Journey with Multiple Product Selection from Green Gadgets Page from LHS");
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
	@Test(groups ={EssCallBack})
	public void verifyBGGreenGadgetsBottomESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Anonymous Journey with Multiple Product Selection from Green Gadgets Page from Bottom");
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
	@Test(groups ={EssCallBack,Refactoring})
	public void verifyErrorMessagesESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Field Level Validations for ESS Call Back Page");
        new EssCallBackAction()
                .navigateToESSCallbackPage()
                .navigateToRequestaCallBackPage()
                .verifyErrorMessages();
    }
    @SuppressWarnings("unchecked")
	@Test(groups ={EssCallBack,Refactoring})
	public void verifyBGGasESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "GAS Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        //activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
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
	public void verifyBGElecESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Electricity Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
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
	public void verifyBGJIESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Joint Invoice (JI) Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        //activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
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
	public void verifyBGMixedESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Mixed Brand Customer Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("MixedBrandCustomer");
        //activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new LoginAction()
                .loginUser(userProfile)
                .navigateToRequestCallBackPage()
                .selectMultipleProduct()
                .enterRequestCallBackDetails(userProfile)
                .verifyMultipleProduct()
                .logout();
    }
    
    @SuppressWarnings("unchecked")
	@Test(groups ={EssCallBack,Refactoring})
	public void verifyBGServicesESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "BG Services Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");
        //activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
        new LoginAction()
                .loginUser(userProfile)
                .navigateToRequestCallBackPage()
                .selectMultipleProduct()
                .enterRequestCallBackDetails(userProfile)
                .verifyMultipleProduct()
                .logout();
    }
    
	@SuppressWarnings("unchecked")
	@Test(groups ={EssCallBack,Refactoring})
	public void verifyBGDualESSCallBack() {
        Report.createTestLogHeader("ESS Call Back ", "Dual Fuel Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        //activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileOAM(userProfile);
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
        new EssCallBackAction()
                .navigateToESSCallbackPage()
                .navigateToSERequestaCallBackPage()
                .selectSEMultipleProduct()
                .enterAnonyRequestCallBackDetails()
                .verifySEMultipleProduct()
                .navigateToSaveCreatePage();
    }
}
