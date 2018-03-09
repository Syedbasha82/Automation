package bg.framework.app.functional.action.selfServe;

import java.util.ArrayList;

import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.action.reFactoring.AccOverviewAction;
import bg.framework.app.functional.action.reFactoring.PaymentHistoryAction;
import bg.framework.app.functional.action.sales.AcquisitionAction;
import bg.framework.app.functional.action.sales.BoilersAndCentralHeatingAction;
import bg.framework.app.functional.action.sales.CrossSellAction;
import bg.framework.app.functional.action.sales.GasAndElectricityAction;
import bg.framework.app.functional.action.sales.GetAPriceAction;
import bg.framework.app.functional.action.sales.ProductAndServicesAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.LegacyHomePage;
import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.page.reFactoring.CorrespondancePage;
import bg.framework.app.functional.page.reFactoring.PaymentHistoryPage;
import bg.framework.app.functional.page.reFactoring.RegistrationPage;
import bg.framework.app.functional.page.reFactoring.SmartMonthlyBillingPage;
import bg.framework.app.functional.page.sales.GetAPricePage;
import bg.framework.app.functional.page.selfServe.AccountOverviewPage;
import bg.framework.app.functional.page.selfServe.AccountSummaryPage;
import bg.framework.app.functional.page.selfServe.CQSMRPage;
import bg.framework.app.functional.page.selfServe.CancelAnAppointmentPage;
import bg.framework.app.functional.page.selfServe.HomeMovePage;
import bg.framework.app.functional.page.selfServe.ResheduleAppointmentPage;
import bg.framework.app.functional.page.selfServe.UpgradeToSmartMeterPage;
import bg.framework.app.functional.util.RunQTP;

/**
 * Created by IntelliJ IDEA. User: !jithendb Date: 23/03/12 Time: 10:15 To
 * change this template use File | Settings | File Templates.
 */

public class AccountOverviewAction {
	private UserProfile userProfile;

	public AccountOverviewAction(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public AccountOverviewAction() {

	}

	public AccountSummaryAction navigateToAccountSummaryPage(UserProfile userProfile) {
		new AccountOverviewPage().navigateToAccountSummaryPage(userProfile);
		return new AccountSummaryAction();
	}
	
	public AccountSummaryAction navigateToAccountSummaryPage01() {
		new AccountOverviewPage().navigateToAccountSummaryPageNew02();
		return new AccountSummaryAction();
	}
	public AccountSummaryAction navigateToAccountSummaryPage03() {
		new AccountOverviewPage().navigateToAccountSummaryPageNew03();
		return new AccountSummaryAction();
	}
	public AccountSummaryAction navigateToAccountSummaryPage04() {
		new AccountOverviewPage().navigateToAccountSummaryPageNew04();
		return new AccountSummaryAction();
	}

	public AccountSummaryAction navigateToAccountSummaryPageNew(UserProfile userProfile, String status) {
		new AccountOverviewPage().navigateToAccountSummaryPageNew(userProfile,status);
		return new AccountSummaryAction();
	}
	
	public AccountSummaryAction navigateToAccountSummaryPageNew01(UserProfile userProfile) {
		new AccountOverviewPage().navigateToAccountSummaryPageNew01(userProfile);
		return new AccountSummaryAction();
	}

	public AccountSummaryAction navigateToAccountSummaryPageSMBNegative(
			UserProfile userProfile) {
		new AccountOverviewPage()
				.navigateToAccountSummaryPageSMBNegative(userProfile);
		return new AccountSummaryAction();

	}

	public AccountSummaryAction navigateToAccountSummaryPageSMB(
			UserProfile userProfile) {
		new AccountOverviewPage().navigateToAccountSummaryPageSMB(userProfile);
		return new AccountSummaryAction();
	}

	public AccountSummaryAction navigateTAlloAccountSummaryPage(
			UserProfile userProfile) {
		new AccountOverviewPage().navigateToAllYourAccount(userProfile);
		return new AccountSummaryAction();
	}

	public AccountOverviewAction verifyLogin(String lastname, String accNumber) {
		// new LegacyLoginPage().loginUser(userProfile);
		new AccountOverviewPage().verifyLogin(lastname, accNumber);
		return this;
	}
	public AccountOverviewAction verifyAccountSummary() {
		// new LegacyLoginPage().loginUser(userProfile);
		new AccountOverviewPage().verifyAccountSummary();
		return this;
	}
	public AccountOverviewAction verifyAccountSummaryforPend() {
		// new LegacyLoginPage().loginUser(userProfile);
		new AccountOverviewPage().verifyAccountSummaryforPend();
		return this;
	}
	public AccountOverviewAction verifyAccountSummaryforCOMP() {
		// new LegacyLoginPage().loginUser(userProfile);
		new AccountOverviewPage().verifyAccountSummaryforCOMP();
		return this;
	}
	public AccountOverviewAction  verifyAccountSummaryforDONE() {
		// new LegacyLoginPage().loginUser(userProfile);
		new AccountOverviewPage(). verifyAccountSummaryforDONE();
		return this;
	}
	public AccountOverviewAction  verifyAccountSummaryforNoSlots() {
		// new LegacyLoginPage().loginUser(userProfile);
		new AccountOverviewPage(). verifyAccountSummaryforNoSlots();
		return this;
	}
	
	public AccountOverviewAction verifyAccountSummaryForNoServiceAccount() {
		// new LegacyLoginPage().loginUser(userProfile);
		new AccountOverviewPage().verifyAccountSummaryForNoServiceAccount();
		return this;
	}
	public AccountOverviewAction navigateToAccountSummaryForMoreThanOneServiceAccount(UserProfile userProfile) {
		// new LegacyLoginPage().loginUser(userProfile);
		new AccountOverviewPage().navigateToAccountSummaryForMoreThanOneServiceAccount(userProfile);
		return this;
	}
	public AccountOverviewAction verifySMBLink() {
		SmartMonthlyBillingPage SMBHomePage = new SmartMonthlyBillingPage();
		SMBHomePage.verifySMBLink();
		return this;
	}

	public AccountOverviewAction verifyCustomerAddressAction(
			String accountNumber) {
		AccountOverviewPage accountOverviewPage = new AccountOverviewPage();
		accountOverviewPage.veifyCustomerAddress(userProfile, accountNumber);
		return this;
	}

	public AccountOverviewAction setAccountNumberAction(String accountNumber,
			UserProfile userProfile) {
		AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
		// accountSummaryPage.setAccountNumber(accountNumber,userProfile);
		userProfile.setAccNumber(accountNumber);
		return this;
	}

	public AccountOverviewAction verifyAccountPresense(String accNumber) {
		new AccountOverviewPage().verifyAccountPresence(accNumber);
		return this;
	}

	public AccountOverviewAction verifyAccountAbsense(String accNumber) {
		new AccountOverviewPage().verifyAccountAbsence(accNumber);
		return this;
	}

	public ContactUsAction navigateToContactUsPage() {
		new AccountOverviewPage().navigateToContactUsPage();
		return new ContactUsAction();
	}

	public GetAPriceAction navigateToGetAPrice() {
		new AccountOverviewPage().navigateToGetAPrice();
		return new GetAPriceAction();
	}

	public LoginAction logout() {
		new AccountOverviewPage().logout();
		return new LoginAction();
	}

	public AccountOverviewAction verifyInactiveLessSix() {
		AccountOverviewPage accountOverviewPage = new AccountOverviewPage();
		// accountOverviewPage.loginForInactiveLessThanSix(userProfile);
		return this;
	}

	public ProductAndServicesAction navigateToProductAndServicesPage() {
		AccountOverviewPage accountOverviewPage = new AccountOverviewPage();
		accountOverviewPage.navigateToProductsAndServicesPage();
		return new ProductAndServicesAction();
	}

	public GasAndElectricityAction navigateToGasAndElectricityPage() {
		new AccountOverviewPage().navigateTOGasAndElectricityPage();
		return new GasAndElectricityAction();
	}

	public GasAndElectricityAction navigateTOGasAndElectricityPageSE() {
		new AccountOverviewPage().navigateTOGasAndElectricityPageSE();
		return new GasAndElectricityAction();
	}

	public BoilersAndCentralHeatingAction navigateToBoilersAndCentralHeating() {
		AccountOverviewPage accountOverviewPage = new AccountOverviewPage();
		// accountOverviewPage.navigateToBoilersAndHeating();

		return new BoilersAndCentralHeatingAction();
	}

	public AcquisitionAction navigateTOAddElectrticityPage() {
		new AccountOverviewPage().navigateTOAddElectrticityPage();
		return new AcquisitionAction();
	}

	public AcquisitionAction navigateTOAddDualPage() {
		new AccountOverviewPage().navigateTOAddDualPage();
		return new AcquisitionAction();
	}

	public AcquisitionAction navigateTOAddGasPage() {
		new AccountOverviewPage().navigateTOAddGasPage();
		return new AcquisitionAction();
	}

	public AccountOverviewAction navigateTOAddHomeCarePage() {
		new AccountOverviewPage().navigateTOAddHomeCarePage();
		return this;
	}

	public CrossSellAction navigateTOOrderHomeCareHundred() {
		new AccountOverviewPage().navigateToOrderHomeCareHundred();
		return new CrossSellAction();
	}

	public AccountOverviewAction verifyRegisteredUser(UserProfile userProfile,
			String lastname, String accNumber) {
		// new OnlineDBConnector().activateUser(userProfile.getUCRN());
		// new LegacyLoginPage().loginUser(userProfile);
		new AccountOverviewPage().verifyLogin(lastname, accNumber);
		return this;

	}
	
	public AccountOverviewAction verifyAccountPresenseNew(UserProfile userProfile,String accNumber){
		new AccountOverviewPage().verifyAccountPresence(accNumber);
		new AccountOverviewPage().verifyUpdatedToPaperless(userProfile);
		return this;
	}

	public AccountOverviewAction revertToPaper(){
		new CorrespondancePage().navigateToDocumentsLink();
		new CorrespondancePage().revertToPaper();
		return new AccountOverviewAction();
	}

	public AccountOverviewAction logoutlink(){
		new CorrespondancePage().CorrespondanceLogout();
		return this;
	}


	public CrossSellAction errorMessgaeSE(String brand) {
		new AccountOverviewPage().errorMessgaeSE(brand);
		return new CrossSellAction();
	}

	public AccountOverviewAction navigateToSeeUnitRates() {
		AccountOverviewPage accountOverviewPage = new AccountOverviewPage();
		accountOverviewPage.navigateToSeeUnitRates();
		return this;
	}

	public AccountSummaryAction verifyCrossSell(UserProfile userProfile) {
		AccountOverviewPage crossSell = new AccountOverviewPage();
		crossSell.verifyCrossSell(userProfile);
		return new AccountSummaryAction();
	}

	public AccOverviewAction navigateToCrossellVerification() {

		return new AccOverviewAction(userProfile);
	}

	public AccountSummaryAction verifyUpSell(UserProfile userProfile) {
		AccountOverviewPage UpSell = new AccountOverviewPage();
		UpSell.verifyUpSell(userProfile);
		return new AccountSummaryAction();
	}

	public void navigateToHome() {
		HomeMovePage navigateToHome = new HomeMovePage();
		navigateToHome.navigateToHome();
	}

	public HomeMoveAction logoutHomeMove() {
		HomeMovePage logoutHomeMove = new HomeMovePage();
		logoutHomeMove.logoutHomeMovePage();
		return new HomeMoveAction();
	}

	public PaymentHistoryAction verifyPaymentHistory(UserProfile userProfile) {
		PaymentHistoryPage paymentHistoryPage = new PaymentHistoryPage();
		paymentHistoryPage.paymentsHistoryLinkValidation();
		return new PaymentHistoryAction();

	}

	public AccountOverviewAction verifyRegisteredNewUser(
			UserProfile userProfile, String lastname, String accNumber) {
		new LegacyLoginPage().loginUser(userProfile);
		new AccountOverviewPage().verifyLogin(lastname, accNumber);
		new AccOverviewAction().calllogs(userProfile);
		return this;
	}

	public GetAPriceAction navigateToGetAQuotePage() {
		GetAPricePage getaPricePage = new GetAPricePage();
		getaPricePage.navigateToGetAQuotePage();
		return new GetAPriceAction();
	}

	public AccountOverviewAction verifyAccountPreRegFastrackTable(
			UserProfile userProfile) {
		RegistrationPage register = new RegistrationPage();
		register.verifyFastrackRegCustomer(userProfile.getUCRN());
		register.verifyRegProfileTempCustomer(userProfile.getUCRN());
		return this;
	}

	public AccountOverviewAction verifyAccountPreRegFastrackTableUCRN(
			UserProfile userProfile) {
		RegistrationPage register = new RegistrationPage();
		register.verifyFastrackRegCustomerUCRN(userProfile.getUCRN());
		register.verifyRegProfileTempCustomerUCRN(userProfile.getUCRN());
		return this;
	}

	public AccountOverviewAction verifyAccountPreRegFastrackTableEmail(
			UserProfile userProfile) {
		RegistrationPage register = new RegistrationPage();
		register.verifyFastrackRegCustomerEmail(userProfile.getEmail());
		register.verifyRegProfileTempCustomerEmail(userProfile.getEmail());
		return this;
	}

	public AccountOverviewAction verifyAccountPreRegFastrackWTPTable(
			UserProfile userProfile) {
		RegistrationPage register = new RegistrationPage();
		register.verifyFastrackRegWTPCustomer(userProfile.getUCRN());
		register.verifyRegProfileTempCustomer(userProfile.getUCRN());
		return this;
	}

	public AccountOverviewAction verifyAccountPreRegASVTableEmail(
			UserProfile userProfile) {
		RegistrationPage register = new RegistrationPage();
		register.verifyPreRegASVCustomerEmail(userProfile.getEmail());
		register.verifyPreRegASVTempCustomerEmail(userProfile.getEmail());
		return this;
	}

	public AccountOverviewAction verifyAccountPreRegASVTableUCRN(
			UserProfile userProfile) {
		RegistrationPage register = new RegistrationPage();
		register.verifyPreRegASVCustomerUCRN(userProfile.getUCRN());
		register.verifyPreRegASVTempCustomerUCRN(userProfile.getUCRN());
		return this;
	}

	/*public CQSMRPageAction clickonSMRLink(UserProfile userprofile) {
		CQSMRPage Cqsmr1page = new CQSMRPage();
		Cqsmr1page.clickonSMRLink(userprofile);
		return new CQSMRPageAction();
	}*/

	public AccountOverviewAction verifyAccountPreRegProfileTableUCRN(
			UserProfile userProfile) {
		RegistrationPage register = new RegistrationPage();
		register.verifyRegProfileTempCustomerUCRN(userProfile.getUCRN());
		return this;
	}

	public AccountOverviewAction verifyAccountPreRegProfileTableEmail(
			UserProfile userProfile) {
		RegistrationPage register = new RegistrationPage();
		register.verifyRegProfileTempCustomerEmail(userProfile.getEmail());
		return this;
	}

	public AccountOverviewAction verifyAccountPreRegPBTableUCRN(
			UserProfile userProfile) {
		RegistrationPage register = new RegistrationPage();
		register.verifyPreRegPBCustomerUCRN(userProfile.getUCRN());
		register.verifyRegProfileTempCustomerUCRN(userProfile.getUCRN());
		return this;
	}

	public AccountOverviewAction verifyAccountPreRegPBTableEmail(
			UserProfile userProfile) {
		RegistrationPage register = new RegistrationPage();
		register.verifyPreRegPBCustomerEmail(userProfile.getEmail());
		register.verifyRegProfileTempCustomerEmail(userProfile.getEmail());
		return this;
	}

	public AccountOverviewAction navigateToSMBnegativetemp(
			ArrayList<String> errList) {
		SmartMonthlyBillingPage SMBHomePage = new SmartMonthlyBillingPage();
		SMBHomePage.navigateToSMBnegativetemp(errList);

		return new AccountOverviewAction();
	}

	public AccountSummaryAction navigateToFVAccountSummaryPage(
			UserProfile userProfile) {
		new AccountOverviewPage().navigatetoFirstServiceVisitPage();
		return new AccountSummaryAction();
	}

	public CrossSellAction navigateTOHomeCarePage() {
		new AccountOverviewPage().navigateTOAddHomeCarePage();
		return new CrossSellAction();
	}

	/* Added for BGMO start */

	public AccountSummaryAction navigateToElectricityAccountSummaryPage(
			UserProfile userProfile) {
		new AccountOverviewPage()
				.navigateToElectricityAccountSummaryPage(userProfile);
		return new AccountSummaryAction();
	}

	public AccountSummaryAction navigateToGasAccountSummaryPage(
			UserProfile userProfile) {
		new AccountOverviewPage().navigateToGasAccountSummaryPage(userProfile);
		return new AccountSummaryAction();
	}

	public UpgradeToSmartMeterAction navigateToUpgradeSmartMeterPage() {
		new UpgradeToSmartMeterPage().navigateToUpgradeSmartMeterPage();
		return new UpgradeToSmartMeterAction();
	}

	public UpgradeToSmartMeterAction navigateToCancelAnAppointmentPage() {
		new UpgradeToSmartMeterPage().navigateToUpgradeSmartMeterPage();
		return new UpgradeToSmartMeterAction();
	}

	public AccountOverviewAction cancelAnAppointment(UserProfile userProfile) {
		new CancelAnAppointmentPage().cancelAppointment(userProfile);
		new CancelAnAppointmentPage().VerifyAppointmentCancelation();
		return this;
	}

	public UpgradeToSmartMeterAction resheduleAppointment() {
		new ResheduleAppointmentPage().navigateToResheduleAnAppointmentPage();
		return new UpgradeToSmartMeterAction();
	}

	public AccountOverviewAction verifySmartMeterLinkAtAccountOverviewPage() {
		new AccountOverviewPage().verifySmartMeterLink();
		return this;
	}

	public AccountOverviewAction verifyNoSmartMeterLinkAtAccountOverviewPage() {
		new AccountOverviewPage().verifyNoSmartMeterLink();
		return this;
	}

	public AccountOverviewAction verifySOStatus() {
		new RunQTP()
				.runQTP1("BGRegression/src/bg/framework/app/functional/util/vbsScripts/Verify_SO_Status.vbs");
		new AccountOverviewPage().verifySOStatus();
		return this;
	}

	public AccountOverviewAction verifyCancelSOStatus() {
		new RunQTP()
				.runQTP1("BGRegression/src/bg/framework/app/functional/util/vbsScripts/Verify_SO_Status.vbs");
		new AccountOverviewPage().verifyCancelSOStatus();
		return this;
	}

	public AccountOverviewAction getSONumberForCancelOrReschedule() {
		LegacyHomePage legacyHomePage = new LegacyHomePage();
		legacyHomePage.getSONumberForCancelOrReschedule();
		return this;
	}

	/* Added for BGMO end */

	public AccountOverviewAction verifyAddress(String accNumber) {

		new AccOverviewAction().verifyAddress(accNumber);

		return this;
	}

	public CQSMRPageAction clickonSMRLink(UserProfile userProfile2) {
		// TODO Auto-generated method stub
		
		 CQSMRPage Cqsmr1page = new CQSMRPage();
		 Cqsmr1page.clickonSMRLink(userProfile2); 
		 return new CQSMRPageAction(); }
	
	/*SMB Phase 2*/
	
	
	public AccountSummaryAction verifyMAPPageCID() {
		new AccountOverviewPage().verifyMAPPageCID();
		return new AccountSummaryAction();
	}
	
	
	
	
	
	
	
	
	}
