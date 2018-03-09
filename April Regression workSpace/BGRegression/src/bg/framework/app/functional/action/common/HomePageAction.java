package bg.framework.app.functional.action.common;

import java.util.ArrayList;

import bg.framework.app.functional.action.reFactoring.AccountSummaryAction;
import bg.framework.app.functional.action.reFactoring.ChangeEmailAction;
import bg.framework.app.functional.action.reFactoring.ForgotEmailAction;
import bg.framework.app.functional.action.reFactoring.ForgotPasswordAction;
import bg.framework.app.functional.action.reFactoring.RegistrationAction;
import bg.framework.app.functional.action.reFactoring.PaymentHistoryAction;
import bg.framework.app.functional.action.sales.*;
import bg.framework.app.functional.action.selfServe.ChannelActivationNewCustomerAction;
import bg.framework.app.functional.action.selfServe.ContactUsAction;
import bg.framework.app.functional.action.selfServe.HelpAndAdviceAction;
import bg.framework.app.functional.action.selfServe.SelfServeRegistrationAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.LegacyHomePage;
import bg.framework.app.functional.action.sales.BoilersAndCentralHeatingAction;
import bg.framework.app.functional.action.sales.GasAndElectricityAction;
import bg.framework.app.functional.action.sales.GetAPriceAction;
import bg.framework.app.functional.action.sales.OurTariffAction;
import bg.framework.app.functional.action.sales.ProductAndServicesAction;
import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.page.reFactoring.AccountSummaryPage;
import bg.framework.app.functional.page.reFactoring.PaymentHistoryPage;
import bg.framework.app.functional.page.reFactoring.SmartMonthlyBillingPage;

//import bg.framework.app.functional.action.selfServe.SelfServeRegistrationAction;
//import bg.framework.app.functional.action.selfServe.SelfServeRegistrationAction;

/**
 * Created by IntelliJ IDEA. User: !jithendb Date: 23/01/12 Time: 17:14 To
 * change this template use File | Settings | File Templates.
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

	public LoginAction navigateToLogout() {
		LegacyHomePage legacyHomePage = new LegacyHomePage();
		legacyHomePage.navigateToLogout();
		return new LoginAction();
	}

	public LoginAction navigateToLogin() {
		LegacyHomePage legacyHomePage = new LegacyHomePage();
		legacyHomePage.navigateToLoginPage();
		return new LoginAction();
	}
	public LoginAction navigateToLoginIBDeepLink(){
		LegacyHomePage legacyHomePage = new LegacyHomePage();
		legacyHomePage.navigateToLoginIBDeepLink();
		return new LoginAction();
	}
	public LoginAction navigateToLoginServiceDeepLink() {
		LegacyHomePage legacyHomePage = new LegacyHomePage();
		legacyHomePage.navigateToLoginServiceDeepLink();
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
	public RegistrationAction BgrnavigateToLoginPage() {
		LegacyHomePage legacyHomePage = new LegacyHomePage();
		legacyHomePage.BgrnavigateToLoginPage();
		return new RegistrationAction();
	}
	public RegistrationAction navigateToRegistrationNew() {
		LegacyHomePage legacyHomePage = new LegacyHomePage();
		legacyHomePage.navigateToSelfServeRegistrationPageNew();
		return new RegistrationAction();
	}
	
	public ForgotPasswordAction navigateToForgottenPasswordScreen() {
		LegacyHomePage legacyHomePage = new LegacyHomePage();
		legacyHomePage.navigateToLoginPage();
		legacyHomePage.navigateToForgottenPassword();
		return new ForgotPasswordAction();
	}

	public GasAndElectricityAction navigateToGasAndElectricityPage() {
		new LegacyHomePage().navigateTOGasAndElectricityPage();
		return new GasAndElectricityAction();
	}

	public AcquisitionAction navigateToGasAndElectricityPage1() {
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
		AccountSummaryPage accountsummaryPage = new AccountSummaryPage();
		//accountsummaryPage.logout();
		LegacyHomePage legacyHomePage = new LegacyHomePage();
		legacyHomePage.navigateToLoginPage();
		return new LoginAction();
	}

	public ArrayList<String> navigateToCQ5() {
		LegacyHomePage legacyHomePage = new LegacyHomePage();
		ArrayList<String> a1 = legacyHomePage.navigateToCQ5LoginPage();
		return a1;
	}

	public ArrayList<String> navigateToCQ5List(String[] strErrorCode) {
		LegacyHomePage legacyHomePage = new LegacyHomePage();
		ArrayList<String> a1 = legacyHomePage
				.navigateToCQ5LoginPageList(strErrorCode);
		return a1;
	}

	public PaymentHistoryAction verifyPaymentHistory(UserProfile userProfile) {
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
		legacyHomePage.BgbnavigateToLoginPage();
		return new LoginAction();
	}

	public HomePageAction loginfromNewRegistrationPage() {
		LegacyHomePage legacyHomePage = new LegacyHomePage();
		legacyHomePage.loginfromNewRegPage();
		return new HomePageAction();
	}

	public HomePageAction openUrlVerifyLandingpage() {
		LegacyHomePage legacyHomePage = new LegacyHomePage();
		legacyHomePage.openUrlVerifyLandingPage();
		return new HomePageAction();
	}

	public HomePageAction navigatetoLoginPage() {
		LegacyHomePage legacyHomePage = new LegacyHomePage();
		legacyHomePage.navigateToLoginPage();
		return this;
	}

	public RollOffAction loginDetails(UserProfile userProfile) {
		LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
		legacyLoginPage.loginUserDetails(userProfile);
		return new RollOffAction();
	}

	public LoginAction navigateToSMRDeepLink() {
		LegacyHomePage legacyHomePage = new LegacyHomePage();
		legacyHomePage.navigateToSMRDeepLink();
		return new LoginAction();
	}

	public AcquisitionAction navigateToSMB() {
		SmartMonthlyBillingPage SMBHomePage = new SmartMonthlyBillingPage();
		SMBHomePage.navigateToSMB();
		return new AcquisitionAction();
	}

	public AccountSummaryAction logout() {
		AccountSummaryPage accountsummaryPage = new AccountSummaryPage();
		accountsummaryPage.logout();
		return new AccountSummaryAction();
	}

	/* Added for BGMO Start */
	public HomePageAction getSONumber() {
		LegacyHomePage legacyHomePage = new LegacyHomePage();
		legacyHomePage.getSONumber();
		return this;
	}

	public HomePageAction getSONumberForCancelOrReschedule() {
		LegacyHomePage legacyHomePage = new LegacyHomePage();
		legacyHomePage.getSONumberForCancelOrReschedule();
		return this;
	}

	/* Added for BGMO End */

	
	
	public ChannelActivationNewCustomerAction navigateToSMLandingPage() {

		LegacyHomePage legacyHomePage = new LegacyHomePage();
		legacyHomePage.navigateToSMLandingPage();
		return new ChannelActivationNewCustomerAction();
	}

	public ChannelActivationNewCustomerAction navigateToOurNewTariffsPage() {

		LegacyHomePage legacyHomePage = new LegacyHomePage();
		legacyHomePage.navigateToOurNewTariffsPage();
		return new ChannelActivationNewCustomerAction();
	}
	public HomePageAction getSONumberForChannelActivation() {
		LegacyHomePage legacyHomePage = new LegacyHomePage();
		legacyHomePage.getSONumberForChannelActivation();
		return this;
	}
	public LoginAction navigateToLoginServiceDeepLinkFV() {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToLoginServiceDeepLinkFV();
        return new LoginAction();
        
        
  }
	
	public LoginAction  navigateToLoginMAPDeepLink() {
		LegacyHomePage legacyHomePage = new LegacyHomePage();
		legacyHomePage.navigateToLoginMAPDeepLink();
		return new LoginAction();
	}
}
