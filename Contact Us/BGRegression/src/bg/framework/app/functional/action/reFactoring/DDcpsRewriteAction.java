package bg.framework.app.functional.action.reFactoring;

import java.util.ArrayList;

import bg.framework.app.functional.entities.Ddcps;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.page.selfServe.AccountSummaryPage;
import bg.framework.app.functional.page.reFactoring.DDcpsRewritePage;

public class DDcpsRewriteAction {
	
	private Ddcps ddcps;
	private UserProfile userProfile;
	public DDcpsRewriteAction()
	{
		
	}
	
	public DDcpsRewriteAction(Ddcps ddcps)
	{
		this.ddcps=ddcps;
	}
	public DDcpsRewriteAction(Ddcps ddcps,UserProfile userProfile)
	{
		this.ddcps=ddcps;
		this.userProfile=userProfile;
	}
	
	
	public DDcpsRewriteAction detailedPlanBreakDown()
	{
		DDcpsRewritePage planBreakDown=new DDcpsRewritePage(ddcps);
		planBreakDown.detailedPlanBreakDown();
		return this;
	}
	
	public DDcpsRewriteAction makeAPaymentManageDD(String mkpType,String recalc)
	{
		DDcpsRewritePage makeAPayment=new DDcpsRewritePage(ddcps);
		makeAPayment.makeAPaymentManageDD(mkpType,recalc);
		return this;
	}
	public DDcpsRewriteAction makeAPaymentManageDD(String mkpType)
	{
		String recalc="withRecalculate";
		DDcpsRewritePage makeAPayment=new DDcpsRewritePage(ddcps);
		makeAPayment.makeAPaymentManageDD(mkpType,recalc);
		return this;
	}
	public DDcpsRewriteAction navigateToCreditRefund(UserProfile userProfile,ArrayList<String> errList)
	{
		DDcpsRewritePage creditRefund=new DDcpsRewritePage(ddcps);
		creditRefund.navigateToCreditRefund(userProfile,errList);
		return this;
	}
	public DDcpsRewriteAction manageDDmeterReadOverlay()
	{
		DDcpsRewritePage creditRefund=new DDcpsRewritePage(ddcps);
		creditRefund.manageDDmeterReadOverlay();
		return this;
	}
	public DDcpsRewriteAction manageDDUpdatebankDetails()
	{
		DDcpsRewritePage updateBankDetails=new DDcpsRewritePage(ddcps);
		updateBankDetails.manageDDUpdatebankDetails();
		return this;
	}
	
	public DDcpsRewriteAction verifyUpdatedDetails()
	{
		DDcpsRewritePage verifyUpdatedDetails=new DDcpsRewritePage(ddcps);
		verifyUpdatedDetails.verifyUpdatedDetails();
		return this;
	}
	public DDcpsRewriteAction manageDDFlexiPaymentPlan()
	{
		DDcpsRewritePage flexiPaymentPlan=new DDcpsRewritePage();
		flexiPaymentPlan.manageDDFlexiPaymentPlan();
		return this;
	}
	public DDcpsRewriteAction nextInstallmentDetailsVerification()
	{
		DDcpsRewritePage nextInstallment=new DDcpsRewritePage();
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
	public DDcpsRewriteAction updateBDViaPlanBreakdown()
	{
		DDcpsRewritePage updateBD=new DDcpsRewritePage(ddcps,userProfile);
		updateBD.updateBDViaPlanBreakdown();
		return this;
	}
	/*public DDcpsRewriteAction updateBDcancelOverlayVerification()
	{
		DDcpsRewritePage updateBD=new DDcpsRewritePage(ddcps,userProfile);
		updateBD.updateBDcancelOverlayVerification();
		return this;
	}*/
	public DDcpsRewriteAction invalidDetailsErrMessageValidation(ArrayList<String> errList)
	{
		DDcpsRewritePage updateBD=new DDcpsRewritePage(ddcps,userProfile);
		updateBD.invalidDetailsErrMessageValidation(errList);
		return this;
	}
	public DDcpsRewriteAction verifyCancelOverlay(String journey)
	{
		DDcpsRewritePage cancelOverlay=new DDcpsRewritePage(ddcps,userProfile);
		cancelOverlay.verifyCancelOverlay(journey);
		return this;
	}
	public DDcpsRewriteAction credRefundAmount(String refundRange)
	{
		DDcpsRewritePage credAmt=new DDcpsRewritePage(ddcps,userProfile);
		credAmt.credRefundAmount(refundRange);
		return this;
	}
	
	public DDcpsRewriteAction checkGARResetFunc()
	{
		DDcpsRewritePage resetFunc=new DDcpsRewritePage(ddcps,userProfile);
		resetFunc.checkGARResetFunc();
		return this;
	}
	public DDcpsRewriteAction confirmCredRefund()
	{
		DDcpsRewritePage confirmRefund=new DDcpsRewritePage(ddcps,userProfile);
		confirmRefund.confirmCredRefund();
		return this;
	}
	
	public DDcpsRewriteAction manageDDErrorForDebitCustomer()
	{
		DDcpsRewritePage errForDebitCust=new DDcpsRewritePage(ddcps,userProfile);
		errForDebitCust.manageDDErrorForDebitCustomer();
		return this;
	}
	public DDcpsRewriteAction navigateToUpdateBankDetails()
	{
		DDcpsRewritePage toUpdateBankDetails=new DDcpsRewritePage(ddcps);
		toUpdateBankDetails.navigateToUpdateBankDetails();
		return this;
	}
	public DDcpsRewriteAction navigateToMkp()
	{
		DDcpsRewritePage toMakeAPayment=new DDcpsRewritePage(ddcps);
		toMakeAPayment.navigateToMkp();
		return this;
	}
	
	
	public DDcpsRewriteAction navigateToFlexiPaymentPlan()
	{
		DDcpsRewritePage toFlexYourPayment=new DDcpsRewritePage(ddcps);
		toFlexYourPayment.navigateToFlexiPaymentPlan();
		return this;
	}
	
	
	public DDcpsRewriteAction errorForAccessBlocked(ArrayList<String> errList)
	{
		DDcpsRewritePage toMakeAPayment=new DDcpsRewritePage(ddcps);
		toMakeAPayment.errorForAccessBlocked(errList);
		return this;
	}
	
	
	public DDcpsRewriteAction flexPaymentPlan()
	{
		DDcpsRewritePage flexPaymentPlan=new DDcpsRewritePage(ddcps);
		flexPaymentPlan.flexPaymentPlan();
		return this;
	}
	
	
	public DDcpsRewriteAction adjustMonthly(String ampType)
	{
		DDcpsRewritePage adjustMonthly=new DDcpsRewritePage(ddcps);
		adjustMonthly.adjustMonthly(ampType);
		return this;
	}
	
	public DDcpsRewriteAction navigateToAdjustMonthly()
	{
		DDcpsRewritePage adjustMonthly=new DDcpsRewritePage(ddcps);
		adjustMonthly.navigateToAdjustMonthly();
		return this;
	}
	
	public DDcpsRewriteAction navigateToSubmitMeterRead(UserProfile 
			userProfile)
	{
		DDcpsRewritePage toSMR=new DDcpsRewritePage(ddcps,userProfile);
		toSMR.navigateToSubmitMeterRead(userProfile);
		return this;
	}
	
	public DDcpsRewriteAction inputBankDetails()
	{
		DDcpsRewritePage inputDetails=new DDcpsRewritePage(ddcps,userProfile);
		inputDetails.inputBankDetails();
		return this;
	}

	public DDcpsRewriteAction smartRefreshLink()
	{
		DDcpsRewritePage smartRefresh=new DDcpsRewritePage(ddcps,userProfile);
		smartRefresh.smartRefreshLink();
		return this;
	}
	
	public DDcpsRewriteAction mkpErrValidation(ArrayList<String> errList)
	{
		DDcpsRewritePage mkpErrValidation=new DDcpsRewritePage(ddcps,userProfile);
		mkpErrValidation.mkpErrValidation(errList);
		return this;
	}
	
	public DDcpsRewriteAction ddPayComplete(ArrayList<String> errList)
	{
		DDcpsRewritePage payComplete=new DDcpsRewritePage(ddcps,userProfile);
		payComplete.ddPayComplete(errList);
		return this;
	}
	
	public DDcpsRewriteAction mkpTryExceeds(UserProfile userProfile,ArrayList<String> errList)
	{
		DDcpsRewritePage payComplete=new DDcpsRewritePage(ddcps,userProfile);
		payComplete.mkpTryExceeds(userProfile,errList);
		return this;
	}
}
