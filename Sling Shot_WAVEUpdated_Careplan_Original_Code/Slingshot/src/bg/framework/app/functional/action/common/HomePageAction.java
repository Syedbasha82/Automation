package bg.framework.app.functional.action.common;

import java.util.ArrayList;

import bg.framework.app.functional.action.reFactoring.ChangeEmailAction;
import bg.framework.app.functional.action.reFactoring.ForgotEmailAction;
import bg.framework.app.functional.action.reFactoring.ForgotPasswordAction;
import bg.framework.app.functional.action.reFactoring.RegistrationAction;
import bg.framework.app.functional.action.Slingshot.BgbRegistrationAction;
import bg.framework.app.functional.action.reFactoring.PaymentHistoryAction;
import bg.framework.app.functional.action.sales.*;
import bg.framework.app.functional.action.selfServe.ContactUsAction;
import bg.framework.app.functional.action.selfServe.HelpAndAdviceAction;
import bg.framework.app.functional.action.selfServe.SelfServeRegistrationAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.Slingshot.CustomerServiceAgentPage;
import bg.framework.app.functional.page.Slingshot.RegistrationPage;
import bg.framework.app.functional.page.common.LegacyHomePage;
import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.page.reFactoring.PaymentHistoryPage;

//import bg.framework.app.functional.action.selfServe.SelfServeRegistrationAction;
//import bg.framework.app.functional.action.selfServe.SelfServeRegistrationAction;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 23/01/12
 * Time: 17:14
 * To change this template use File | Settings | File Templates.
 */
public class HomePageAction {
    public OurTariffAction navigateToOurTariffPage() {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToOurTariffsPage();
        return new OurTariffAction();
    }

    public ProductAndServicesAction navigateToProductsAndServicesPage() {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToProductsAndServicesPage();
        return new ProductAndServicesAction();
    }

    public LoginAction navigateToLogin() {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToLoginPage();
        return new LoginAction();
    }

    public ContactUsAction navigateToContactUsPage() {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToContactUsPage();
        return new ContactUsAction();
    }

    public HomePageAction navigateToLoginFromYourAccount() {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToLoginPage();
        return new HomePageAction();
    }

    public GetAPriceAction navigateToGetAPrice() {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToGetAPricePage();
        return new GetAPriceAction();
    }

    public HelpAndAdviceAction navigatetoHelpAndAdvicePage() {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToHelpandAdvicePage();
        return new HelpAndAdviceAction();
    }

    public ChangeEmailAction navigateToChangeEmailAddressPage() {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToLoginPage();
        legacyHomePage.navigateToChangeEmailAddressPage();
        return new ChangeEmailAction();
    }

    public BoilersAndCentralHeatingAction navigateToBoilersAndCentralHeating() {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToBoilersAndHeating();
        return new BoilersAndCentralHeatingAction();
    }

    public SelfServeRegistrationAction navigateToSelfServeRegistration() {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToSelfServeRegistrationPage();
        return new SelfServeRegistrationAction();
    }

    public RegistrationAction navigateToRegistration() {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToSelfServeRegistrationPage();
        return new RegistrationAction();
    }
    
    public ForgotPasswordAction navigateToForgottenPasswordScreen() {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToLoginPage();
        legacyHomePage.navigateToForgottenPassword();
        return new ForgotPasswordAction();
    }
    public GasAndElectricityAction navigateToGasAndElectricityPage(){
        new LegacyHomePage().navigateTOGasAndElectricityPage();
        return new GasAndElectricityAction();
    }
    
    public AcquisitionAction navigateToGasAndElectricityPage1(){
        new LegacyHomePage().navigateTOGasAndElectricityPage();
        return new AcquisitionAction();
    }
    public ForgotEmailAction navigatetoForgotEmailPage() {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToLoginPage();
        legacyHomePage.navigatetoForgotEmailPage();
        return new ForgotEmailAction();
    }

    public ForgotEmailAction navigatetoForgotEmailViaForgotPassScreen() {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToLoginPage();
        legacyHomePage.navigatetoForgotEmailViaForgotPassword();
        return new ForgotEmailAction();
    }
    
    public LoginAction navigateToLoginPage() {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToLoginPage();
        return new LoginAction();
    }
    
    public ArrayList<String> navigateToCQ5() {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        ArrayList<String> a1= legacyHomePage.navigateToCQ5LoginPage();
        return a1;
    }    
   
    public PaymentHistoryAction verifyPaymentHistory(UserProfile userProfile){
    	PaymentHistoryPage paymentHistoryPage = new PaymentHistoryPage();
    	paymentHistoryPage.paymentsHistoryLinkValidation();
        return new PaymentHistoryAction();
    	
    }
    public LoginAction navigateToYouAccPage() {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateYourAccLoginPage();
        return new LoginAction();
    }
    
    public LoginAction BgbnavigateToLogin() {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.BgbnavigateToLoginPage(); //11-Dec
        return new LoginAction();
    }
    
    public HomePageAction loginfromNewRegistrationPage() {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.loginfromNewRegPage();
        return new HomePageAction();
    }
    
    public HomePageAction openUrlVerifyLandingpage(){
    	LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.openUrlVerifyLandingPage();
    	return new HomePageAction();
    }
    
    public BgbRegistrationAction navigateToBgbRegistration() {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToBgbRegistrationPage();
        return new BgbRegistrationAction();
    }
    
    public BgbRegistrationAction navigateToCsaRegistration() {
	        LegacyHomePage legacyHomePage = new LegacyHomePage();
	        legacyHomePage.navigateToCsaRegistrationPage();
	        return new BgbRegistrationAction();
     }
    
    public LoginAction BgcnavigateToLogin() {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.BgcnavigateToLoginPage(); //11-Dec
        return new LoginAction();
    }
    public LoginAction BgcnavigatetoCorporate() {
    	LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.BgcnavigatetoCorporate(); //11-Dec
        return new LoginAction();
	}
    public BgbRegistrationAction verifyAndRegister(UserProfile userprofile) {
        RegistrationPage registerPage = new RegistrationPage();
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToBgbRegistrationPage();
        registerPage.verifyAndRegister(userprofile);
      
        return new BgbRegistrationAction();
 }
    public SelfServeRegistrationAction clickRegistration(String triggerPoint) {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.clickRegistration(triggerPoint);
        return new SelfServeRegistrationAction();
    }
    
    
    
}
