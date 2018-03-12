package bg.framework.app.functional.action.selfServe;

import bg.framework.app.functional.entities.Ddcps;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.page.selfServe.AccountSummaryPage;
import bg.framework.app.functional.page.selfServe.DdcpsPage;

public class DdcpsAction {
	
	private Ddcps ddcps;
	public DdcpsAction()
	{
		
	}
	public DdcpsAction(Ddcps ddcps)
	{
		this.ddcps=ddcps;
	}
	
	public DdcpsAction enterReadingMonthlyCustomer(String accType)
	{
		DdcpsPage enterReading=new DdcpsPage(ddcps);
		enterReading.enterReadingMonthlyCustomer(accType);
		return this;
	}
	
	public DdcpsAction selectAccountsForSwitchingToDD(UserProfile userProfile,String accType)
	{
		DdcpsPage selectAccounts=new DdcpsPage(ddcps);
		selectAccounts.selectAccountsForSwitchingToDD(userProfile,accType);
		return this;
	}
	public DdcpsAction meterReadOverlay(String accType)
	{
		DdcpsPage overlay=new DdcpsPage(ddcps);
		overlay.meterReadOverlay(accType);
		return this;
		
	}
	public DdcpsAction enterPaymentDateForQuarterlyCustomer()
	{
		DdcpsPage enterPayDate=new DdcpsPage(ddcps);
		enterPayDate.enterPaymentDateForQuarterlyCustomer();
		return this;
	}
	
	public DdcpsAction paymentAmountAndCreditRefund()
	{
		DdcpsPage paymentAmount=new DdcpsPage(ddcps);
		paymentAmount.paymentAmountAndCreditRefund();
		return this;
	}
	public DdcpsAction setUpDDMakeAPayment()
	{
		DdcpsPage setUpMkp=new DdcpsPage(ddcps);
		setUpMkp.setUpDDMakeAPayment();
		return this;
	}
	
	public DdcpsAction enterBankDetailsForQuarterlyCustomer()
	{
		DdcpsPage bankDetails=new DdcpsPage(ddcps);
		bankDetails.enterBankDetailsForQuarterlyCustomer();
		return this;
	}
	
	public DdcpsAction reviewAndConfirmDDSetUp()
	{
		DdcpsPage reviewDDSetup=new DdcpsPage(ddcps);
		reviewDDSetup.reviewAndConfirmDDSetUp();
		return this;
	}
	public DdcpsAction confirmationOverlay()
	{
		DdcpsPage overlay=new DdcpsPage(ddcps);
		overlay.confirmationOverlay();
		return this;
	}
	public DdcpsAction navigateToPayBalanceNow()
	{
		DdcpsPage payNow=new DdcpsPage(ddcps);
		payNow.navigateToPayBalanceNow();
		return this;
	}
	public DdcpsAction navigateToBankDetailsPayBalanceLater()
	{
		DdcpsPage toBankDetails=new DdcpsPage(ddcps);
		toBankDetails.navigateToBankDetailsPayBalanceLater();
		return this;
	}
	public DdcpsAction enterBankDetailsForMonthlyCustomer()
	{
		DdcpsPage enterBankDetails=new DdcpsPage(ddcps);
		enterBankDetails.enterBankDetailsForMonthlyCustomer();
		return this;
	}
	public DdcpsAction confirmDetailsAndPrivacyPolicy()
	{
		DdcpsPage confirmDetails=new DdcpsPage(ddcps);
		confirmDetails.confirmDetailsAndPrivacyPolicy();
		return this;
	}
	
	public AccountSummaryAction navigateToYourAccount()
	{
		DdcpsPage backToAccount=new DdcpsPage(ddcps);
		backToAccount.navigateToYourAccount();
		return new AccountSummaryAction();
	}
	
	public DdcpsAction detailedPlanBreakDown()
	{
		DdcpsPage planBreakDown=new DdcpsPage(ddcps);
		planBreakDown.detailedPlanBreakDown();
		return this;
	}
	
	public DdcpsAction adjustMonthlyPayment()
	{
		DdcpsPage adjustPayment=new DdcpsPage(ddcps);
		adjustPayment.adjustMonthlyPayment();
		return this;
	}
	public DdcpsAction makeAPaymentManageDD()
	{
		DdcpsPage makeAPayment=new DdcpsPage(ddcps);
		makeAPayment.makeAPaymentManageDD();
		return this;
	}
	public DdcpsAction manageDDCreditRefund()
	{
		DdcpsPage creditRefund=new DdcpsPage(ddcps);
		creditRefund.manageDDCreditRefund();
		return this;
	}
	public DdcpsAction manageDDUpdatebankDetails()
	{
		DdcpsPage updateBankDetails=new DdcpsPage(ddcps);
		updateBankDetails.manageDDUpdatebankDetails();
		return this;
	}
	public DdcpsAction manageDDFlexiPaymentPlan()
	{
		DdcpsPage flexiPaymentPlan=new DdcpsPage();
		flexiPaymentPlan.manageDDFlexiPaymentPlan();
		return this;
	}
	public DdcpsAction submitMeterReadInManageDD()
	{
		DdcpsPage submitMeterRead=new DdcpsPage();
		submitMeterRead.submitMeterReadInManageDD();
		return this;
	}
	public DdcpsAction nextInstallmentDetailsVerification()
	{
		DdcpsPage nextInstallment=new DdcpsPage();
		nextInstallment.nextInstallmentDetailsVerification();
		return this;
	}
	public void logOut()
	{
		AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    	accountSummaryPage.logoutPage();
	}
	public void logOutLink()
	{
		LegacyLoginPage legacyLoginPage =new LegacyLoginPage();
		legacyLoginPage.logOut();
	}
	public DdcpsAction navigatetoDirectDebit() {
		DdcpsPage navigatetoDD=new DdcpsPage();
		navigatetoDD.navigatetoDirectDebit();
		return new DdcpsAction();
	}
	public DdcpsAction SignUpDD() {
		DdcpsPage SignUpDD=new DdcpsPage();
		SignUpDD.SignUpDD();
		return new DdcpsAction();
	}
	public DdcpsAction CreateOnlineAccount() {
		DdcpsPage CreateOnlineAccount=new DdcpsPage();
		CreateOnlineAccount.CreateOnlineAccount();
		return new DdcpsAction();
	}
	public DdcpsAction verifyErrorMessage() {
		DdcpsPage verifyErrorMessage=new DdcpsPage();
		verifyErrorMessage.verifyErrorMessage();
		return new DdcpsAction();
	}
		
	}

