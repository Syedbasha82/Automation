package bg.framework.app.functional.test.selfServe;

import static bg.framework.app.functional.entities.FunctionalCategory.AccountSummary;
import static bg.framework.app.functional.entities.FunctionalCategory.Complex;
import static bg.framework.app.functional.entities.FunctionalCategory.InProgress;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;
import static bg.framework.app.functional.entities.FunctionalCategory.Qtp;
import static bg.framework.app.functional.entities.FunctionalCategory.Complex;
import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SiebelDataBase;
import bg.framework.app.functional.util.TestDataHelper;
public class AccountSummaryTest extends TestBase {
	/*
	 *  Mandatory field in UserProfile: UCRN and Account Number
	 */
	@Test(groups = {Regression,AccountSummary})
	public void verifyAccountOverviewForElectricity() {
		Report.createTestLogHeader("Account summary test", "Electricity account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		//getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
		//.verifyCustomerAddressAction(userProfile.getElecAccount())
		.navigateToAccountSummaryPage(userProfile)
		.verifyAccountSummaryPageAction(userProfile.getElecAccount())
		.logoutAction();
	}


	/*
	 *  Mandatory field in UserProfile: UCRN and Account Number, gasAccount, elecAccount
	 */
	@Test(groups = {Regression,AccountSummary,Qtp,Smoke})
	public void verifyAccountOverviewforDual() {
		Report.createTestLogHeader("Account Login Verification", "Dual account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);

		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
		.verifyCustomerAddressAction(userProfile.getElecAccount())  
		.setAccountNumberAction(userProfile.getElecAccount(),userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.verifyAccountSummaryPageAction(userProfile.getElecAccount())
		.allAccountOverviewPageAction()
		.verifyCustomerAddressAction(userProfile.getGasAccount()) 
		.setAccountNumberAction(userProfile.getGasAccount(),userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.verifyAccountSummaryPageAction(userProfile.getGasAccount())
		.logoutAction();
	}

	/*
	 *  Mandatory field in UserProfile: UCRN and Account Number
	 */
	@Test(groups = {  Regression, AccountSummary,Complex ,Qtp })
	public void verifyAccountOverviewforJI() {
		Report.createTestLogHeader("Account Login Verification", "JI account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.verifyCustomerAddressAction(userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile)
		.verifyAccountSummaryPageAction(userProfile.getAccNumber())
		.logoutAction();
	}
	/*
	 *  Mandatory field in UserProfile: UCRN and Account Number
	 */
	@Test(groups = {AccountSummary,Qtp,Smoke})
	public void verifyAccountSummaryforGas() {
		Report.createTestLogHeader("Account Login Verification", "Gas account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
		.verifyCustomerAddressAction(userProfile.getGasAccount())
		.navigateToAccountSummaryPage(userProfile)
		.verifyAccountSummaryPageAction(userProfile.getGasAccount())
		.logoutAction();
	}
	/*
	 *  Mandatory field in UserProfile: UCRN and Account Number
	 */
	@Test(groups = {Regression, AccountSummary,Complex,Qtp})
	public void verifyAccountSummaryforWTP() {
		Report.createTestLogHeader("Account Login Verification", "WTP Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("WTPAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
		.navigateToAccountSummaryPage(userProfile)
		.verifyWTPAccountAndSSOAccountAction()
		.logoutAction();
	}
	/*
	 *  Mandatory field in UserProfile: UCRN and Account Number
	 */
	@Test(groups = {Regression, AccountSummary, Complex,Qtp})
	public void verifyAccountSummaryforSSO() {
		Report.createTestLogHeader("Account Login Verification", "SSO Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("SSOAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile)
		.verifyWTPAccountAndSSOAccountAction()
		.logoutAction();
	}

	/*
	 *  Mandatory field in UserProfile: UCRN and Account Number of an account which has smart meter reading.
	 */
	@Test(groups = {Regression,AccountSummary})
	public void verifyAccountSummaryforSmartCustomer() {
		Report.createTestLogHeader("Account Summary verification For Smart Customer", "Gas account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
		.verifyCustomerAddressAction(userProfile.getGasAccount())
		.navigateToAccountSummaryPage(userProfile)
		.verifyAccountSummaryPageAction(userProfile.getGasAccount())
		.logoutAction();
	}
	/*
	 *  Mandatory field in UserProfile: UCRN and Account Number
	 */
	@Test(groups = {Regression, AccountSummary,Complex,Qtp})
	public void verifyAccountSummaryforBGSAccount() {
		Report.createTestLogHeader("Account Login Verification", "BGS Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("BGSAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile)
		.verifyBGSAccountAction()
		.logoutAction();
	}

	@Test(groups = { Regression,AccountSummary})
	public void verifyAccountSummaryinactiveLessThanSixMonthsForGas() {
		Report.createTestLogHeader("Account inactive less than six months verification for account summary", "Gas account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		SiebelDataBase siebelDataBase = new SiebelDataBase();
		siebelDataBase.setAccountStatus(userProfile.getAccNumber(), -3);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
		.verifyInactiveLessSix()
		.logout();
	}

	/*
	 * Mandatory fields in UserProfile.xml: UCRN and ACCOUNTNUMBER For dual rate Electricity account on standard tariff and MagneticCard Payment 
	 */
	@Test(groups = {Regression,AccountSummary,Complex})
	public void verifyTarrifOverlayForElectricityDualRateAccountOnStandardTariff() {
		Report.createTestLogHeader("verifyTarrifOverlayForElectricity", "Electricity account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
		.verifyCustomerAddressAction(userProfile.getElecAccount())
		.navigateToAccountSummaryPage(userProfile)
		.navigateToSeeUnitRates()
		.logoutAction();
	}
	/*
	 * Mandatory fields in UserProfile.xml: UCRN and ACCOUNT NUMBER for Single rate Electricity account on Fixed price 2011 and VDD Payment
	 */
	@Test(groups = { Regression,AccountSummary,Complex})
	public void verifyTarrifOverlayForVDDElectricitySingleRateAccountOnFixedPrice2013() {
		Report.createTestLogHeader("verifyTarrifOverlayForElectricity", "Electricity account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
		.verifyCustomerAddressAction(userProfile.getElecAccount())
		.navigateToAccountSummaryPage(userProfile)
		.navigateToSeeUnitRates()
		.logoutAction();
	}
	/*
	 * Mandatory fields in UserProfile.xml: UCRN and ACCOUNT NUMBER for Gas account on Future Energy Plus and Cash/Cheque Payment
	 */

	@Test(groups = { Regression,AccountSummary,Complex})
	public void verifyTarrifOverlayForCashChequeGasAccountOnFutureEnergyPlus() {
		Report.createTestLogHeader("verifyTarrifOverlayForElectricity", "Gas account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
		.verifyCustomerAddressAction(userProfile.getGasAccount())
		.navigateToAccountSummaryPage(userProfile)
		.navigateToSeeUnitRates()
		.logoutAction();
	}
	/*
	 * Mandatory fields in UserProfile.xml: UCRN and ACCOUNT NUMBER for Electricity account on WebSaver 11 with Energy Smart tariff and DD Payment
	 */
	@Test(groups = {Regression, AccountSummary,Complex})
	public void verifyTarrifOverlayForDDelectricityAccountOnWebSaver13WithEnergySmartTariff() {
		Report.createTestLogHeader("verifyTarrifOverlayForElectricity", "Electricity account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
		.verifyCustomerAddressAction(userProfile.getElecAccount())
		.navigateToAccountSummaryPage(userProfile)
		.navigateToSeeUnitRates()
		.logoutAction();
	}
	/*
	 * Mandatory fields in UserProfile.xml: UCRN and ACCOUNT NUMBER for GasAccount on Fixed Price August2013 and StandingOrder Payment
	 */
	@Test(groups = { Regression,AccountSummary,Complex})
	public void verifyTarrifOverlayForGasAccountFixedPriceAugust2013() {
		Report.createTestLogHeader("verifyTarrifOverlayForElectricity", "Gas account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
		.verifyCustomerAddressAction(userProfile.getGasAccount())
		.navigateToAccountSummaryPage(userProfile)
		.navigateToSeeUnitRates()
		.logoutAction();
	}
	/*
	 * Mandatory field in UserProfile: UCRN and Account Number 
	 */

	@Test(groups={Regression,AccountSummary})
	public void accountHistoryForGas(){
		Report.createTestLogHeader("Account Summary History For Gas", "GasAccount");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		//getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(),userProfile.getGasAccount())
		//.verifyCustomerAddressAction(userProfile.getGasAccount())
		.navigateToAccountSummaryPage(userProfile)
		.viewPaymentHistory()
		.logoutAction();
	}
	/*
	 * Mandatory field in UserProfile: UCRN and Account Number 
	 */
	@Test(groups={Regression,AccountSummary})
	public void accountHistoryForElectricity(){
		Report.createTestLogHeader("Account Summary History For Electricity", "ElectricityAccount");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(),userProfile.getElecAccount())
		.verifyCustomerAddressAction(userProfile.getElecAccount())
		.navigateToAccountSummaryPage(userProfile)
		.viewPaymentHistory()
		.logoutAction();
	}
	/*
	 * Mandatory field in UserProfile: UCRN and Account Number 
	 */
	@Test(groups={Regression,AccountSummary,Complex})
	public void accountHistoryForJI(){
		Report.createTestLogHeader("Account Summary History For JI", "JIAccount");
		UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(),userProfile.getAccNumber())
		.verifyCustomerAddressAction(userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile)
		.viewPaymentHistory()
		.logoutAction();
	}
	/*
	 * Mandatory field in UserProfile: UCRN and Account Number of a smart meter customer.
	 */
	@Test(groups={Regression,AccountSummary})
	public void accountHistoryForSmartMeterCustomer(){
		Report.createTestLogHeader("Account Summary History For SmartMeterCustomer", "GasAccount");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(),userProfile.getAccNumber())
		.verifyCustomerAddressAction(userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile)
		.viewPaymentHistory()
		.logoutAction();
	}

	/*
	 * Mandatory field in UserProfile: UCRN and Account Number 
	 */

	@Test(groups={Regression,AccountSummary})
	public void accountPaymentHistoryInactiveLessThanSixMonths(){
		Report.createTestLogHeader("Account Summary History For Gas Inactive Less than six months", "GasAccount");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		SiebelDataBase siebelDataBase = new SiebelDataBase();
		siebelDataBase.setAccountStatus(userProfile.getAccNumber(), -3);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(),userProfile.getGasAccount())
		.verifyInactiveLessSix()
		.navigateToAccountSummaryPage(userProfile)
		.viewPaymentHistory()
		.logoutAction();
	}
	/*
	 *  Mandatory field in UserProfile: UCRN and Account Number of Electricity account.
	 */

	@Test(groups = {Regression,AccountSummary})
	public void verifyCrossSellForElectricity() {
		Report.createTestLogHeader("Account summary test", "Electricity account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
		.verifyCustomerAddressAction(userProfile.getElecAccount())
		.navigateToCrossellVerification()
		.verifyAccountOverviewAction()
		.logout();
	}
	/*
	 * Mandatory field in UserProfile: UCRN and Account Number of Gas account.
	 */
	@Test(groups = {Smoke,AccountSummary})
	public void verifyCrossSellForGas() {
		Report.createTestLogHeader("Account summary test", "Gas account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
		.verifyCustomerAddressAction(userProfile.getGasAccount())
		.navigateToCrossellVerification()
		.verifyAccountOverviewAction()
		.logout();
	}

	/*
	 * Mandatory field in UserProfile: UCRN and Account Number of Gas account with smart meter reading
	 */
	@Test(groups = {Regression,AccountSummary})
	public void verifyCrossSellForSmartMeterRead() {
		Report.createTestLogHeader("Account summary test For Smart meter read customer","Gas account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
		.verifyCustomerAddressAction(userProfile.getGasAccount())
		.verifyCrossSell(userProfile)
		.logoutAction();
	}
	@Test(groups = {Regression, AccountSummary,InProgress})
	public void verifyUpSellForGas() {
		Report.createTestLogHeader("Account summary test", "Gas account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HomeSerivcesAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
		.verifyCustomerAddressAction(userProfile.getGasAccount())
		.verifyUpSell(userProfile)
		.logoutAction();
	}
	
	///////////////////////////////////// SERVICES EMAIL /////////////////////////////////////

	/////// single account - paperless /////////////
	@Test(groups = {  Regression, AccountSummary,Complex ,Qtp })
	public void verifyAccountSummaryForHC100() {
		Report.createTestLogHeader("Account Summary  Verification", "HomeCare100Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare100Account");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
		//.verifyCustomerAddressAction(userProfile.getElecAccount())
		.navigateToAccountSummaryPage(userProfile)
		.verifyGoPaperlessSection()
		.logoutAction();
	}

	////////////single account - paper //////////////////
	@Test(groups = {  Regression, AccountSummary,Complex ,Qtp })
	public void verifyAccountSummaryForHC200() {
		Report.createTestLogHeader("Account Summary  Verification", "HomeCare200Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare200Account");
	//	getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
		//.verifyCustomerAddressAction(userProfile.getElecAccount())
		.navigateToAccountSummaryPage(userProfile)
		.verifyGoPaperlessSection()
		.logoutAction();
	}

	////////////////Multiple paper (2 accounts) ///////////////
	@Test(groups = {  Regression, AccountSummary,Complex ,Qtp })
	public void verifyAccountSummaryForHC100AndGACAccount() {
		Report.createTestLogHeader("Account Summary  Verification", "HC100AndGACAccount");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC100AndGACAccount");
//		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
		//.verifyCustomerAddressAction(userProfile.getElecAccount())
		.navigateToAccountSummaryPage(userProfile)
		.verifyGoPaperlessSection()
		.logoutAction();
	}

	////////////////Multiple paper(3 accounts) ///////////////
	@Test(groups = {  Regression, AccountSummary,Complex ,Qtp })
	public void verifyAccountSummaryForKACHC200HECAccount() {
		Report.createTestLogHeader("Account Summary  Verification", "KACHC200HECAccount");
		UserProfile userProfile = new TestDataHelper().getUserProfile("KACHC200HECAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
		//.verifyCustomerAddressAction(userProfile.getElecAccount())
		.navigateToAccountSummaryPage(userProfile)
		.verifyGoPaperlessSection()
		.logoutAction();
	}

	///////////////// Multiple paper (4 accounts) ////////////////////
	@Test(groups = {  Regression, AccountSummary,Complex ,Qtp })
	public void verifyAccountSummaryForHC100HC200KACAndHECAccount() {
		Report.createTestLogHeader("Account Summary  Verification", "HC100HC200KACAndHECAccount");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC100HC200KACAndHECAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
		//.verifyCustomerAddressAction(userProfile.getElecAccount())
		.navigateToAccountSummaryPage(userProfile)
		.verifyGoPaperlessSection()
		.logoutAction();
	}

	//////////////////////1 paper 1 paperless ///////////////////////
	@Test(groups = {  Regression, AccountSummary,Complex ,Qtp })
	public void verifyAccountSummaryForHC100AndGAC() {
		Report.createTestLogHeader("Account Summary  Verification", "HC100(paper) and GAC(paperless) Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC100AndGACAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
		//.verifyCustomerAddressAction(userProfile.getElecAccount())
		.navigateToAccountSummaryPage(userProfile)
		.verifyGoPaperlessSection()
		.logoutAction();
	}

	///////////////// 1 paper 2 paperless ///////////////////////
	@Test(groups = {  Regression, AccountSummary,Complex ,Qtp })
	public void verifyAccountSummaryForKACHC200HEC() {
		Report.createTestLogHeader("Account Summary  Verification", "HC200(paper), HEC(paperless) and KAC(paperless) Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("KACHC200HECAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
		//.verifyCustomerAddressAction(userProfile.getElecAccount())
		.navigateToAccountSummaryPage(userProfile)
		.verifyGoPaperlessSection()
		.logoutAction();
	}

	//////////////////1 paper 3 paperless ///////////////////
	@Test(groups = {  Regression, AccountSummary,Complex ,Qtp })
	public void verifyAccountSummaryForHC100HC200HC300AndHC400() {
		Report.createTestLogHeader("Account Summary  Verification", "HC100(paper) HC200(paperless) HC300(paperless) And HC400(paperless) Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC100HC200HC300AndHC400Account");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
		//.verifyCustomerAddressAction(userProfile.getElecAccount())
		.navigateToAccountSummaryPage(userProfile)
		.verifyGoPaperlessSection()
		.logoutAction();
	}

	////////////////////////////2 paper 2 paperless //////////////////////
	@Test(groups = {  Regression, AccountSummary,Complex ,Qtp })
	public void verifyAccountSummaryForHC100HC200KACAndHEC() {
		Report.createTestLogHeader("Account Summary  Verification", "HC100(paper), HC200(paper), HEC(paperless) and KAC(paperless) Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC100HC200KACAndHECAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
		//.verifyCustomerAddressAction(userProfile.getElecAccount())
		.navigateToAccountSummaryPage(userProfile)
		.verifyGoPaperlessSection()
		.logoutAction();
	}

	//////////////////2 paper 1 paperless //////////////////
	@Test(groups = {  Regression, AccountSummary,Complex ,Qtp })
	public void verifyAccountSummaryForHECKACAndGACAccount() {
		Report.createTestLogHeader("Account Summary  Verification", "KAC(paper), HEC(paper) and GAC(paperless) Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HECKACAndGACAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
		//.verifyCustomerAddressAction(userProfile.getElecAccount())
		.navigateToAccountSummaryPage(userProfile)
		.verifyGoPaperlessSection()
		.logoutAction();
	}

	//////////////////1 paperless 3 paper ///////////////////////
	@Test(groups = {  Regression, AccountSummary,Complex ,Qtp })
	public void verifyAccountSummaryForHC100HC200KACAndHECPartial() {
		Report.createTestLogHeader("Account Summary  Verification", "HC100(paperless) HC200(paper) KAC(paper) And HEC(paper) Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC100HC200KACAndHECAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
		//.verifyCustomerAddressAction(userProfile.getElecAccount())
		.navigateToAccountSummaryPage(userProfile)
		.verifyGoPaperlessSection()
		.logoutAction();
	}
	/////////////////// 2 paperless ///////////////////////
	@Test(groups = {  Regression, AccountSummary,Complex ,Qtp })
	public void verifyAccountSummaryForHC100AndHC200Account() {
		Report.createTestLogHeader("Account Summary  Verification", "HC100(paperless) And HC200(paperless) Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC100AndHC200Account");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
		//.verifyCustomerAddressAction(userProfile.getElecAccount())
		.navigateToAccountSummaryPage(userProfile)
		.verifyGoPaperlessSection()
		.logoutAction();
	}

	////////////////////4 paperless ////////////////////////
	@Test(groups = {  Regression, AccountSummary,Complex ,Qtp })
	public void verifyAccountSummaryForHC100HC200KACAndHECPaperless() {
		Report.createTestLogHeader("Account Summary  Verification", "HC100(paperless) And HC200(paperless) Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC100HC200KACAndHECAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
		//.verifyCustomerAddressAction(userProfile.getElecAccount())
		.navigateToAccountSummaryPage(userProfile)
		.verifyGoPaperlessSection()
		.logoutAction();
	}

	/////////////// Multiple  paperless (3 accounts) ///////////////////
	@Test(groups = {  Regression, AccountSummary,Complex ,Qtp })
	public void verifyAccountSummaryForSOKACAndHC400FlexiAccount() {
		Report.createTestLogHeader("Account Summary  Verification", "SO(paperless) KAC(paperless) And HC400Flexi(paperless)Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("SOKACAndHC400FlexiAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
		//.verifyCustomerAddressAction(userProfile.getElecAccount())
		.navigateToAccountSummaryPage(userProfile)
		.verifyGoPaperlessSection()
		.logoutAction();
	}


}
