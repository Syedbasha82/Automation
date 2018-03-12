/**
 * 
 */
package bg.framework.app.functional.action.Slingshot;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.Slingshot.PaymentsPage;

/**
 * @author 208070
 *
 */
public class PaymentsAction {
	public PaymentsAction verifyLinks() {
		new PaymentsPage().verifyLinks();
		return new PaymentsAction();	
	}

	public PaymentsAction navigatetoMakeAPayment() {
		new PaymentsPage().navigatetoMakeAPayment();
		return new PaymentsAction();	
	}

	
	
	
	public PaymentsAction paymentDetails(UserProfile userProfile) {
		new PaymentsPage().paymentDetails(userProfile);
		return new PaymentsAction();	
	}

	public PaymentsAction errorValidation(UserProfile userProfile) {
		new PaymentsPage().errorValidation(userProfile);
		return new PaymentsAction();	
	}

	public PaymentsAction logOut() {
		new PaymentsPage().logOut();
		return new PaymentsAction();
		
	}
	public PaymentsAction paymentDue() {
		new PaymentsPage().paymentDue();
		return new PaymentsAction();	
	}
	
	public PaymentsAction TwoCardlimit(int increment, UserProfile userProfile) {
		new PaymentsPage().TwoCardlimit(increment, userProfile);
		return new PaymentsAction();
	}

	public PaymentsAction navigatetoMakeAPaymentError() {
		new PaymentsPage().navigatetoMakeAPaymentError();
		return new PaymentsAction();
	}
	public PaymentsAction navigateToManageYourPaymentsCards() {
		new PaymentsPage().navigateToManageYourPaymentsCards();
		return new PaymentsAction();	
	}
	public PaymentsAction verifyAndDeleteCardsInManageTable() {
		new PaymentsPage().verifyAndDeleteCardsInManageTable();
		return new PaymentsAction();	
	}
	public PaymentsAction verifyAndEditCardsInManageTable() {
		new PaymentsPage().verifyAndEditCardsInManageTable();
		return new PaymentsAction();	
	}
	public PaymentsAction cardStorageFunctionality() {
		new PaymentsPage().cardStorageFunctionality();
		return new PaymentsAction();	
	}
	
	public PaymentsAction paymentViaNewCard(String SaveCard) {
		new PaymentsPage().paymentViaNewCard(SaveCard);
		return new PaymentsAction();	
	}
	
	public PaymentsAction verifySummaryPage() {
		new PaymentsPage().verifySummaryPage();
		return new PaymentsAction();	
	}
	public PaymentsAction verifyAccountsummary() {
		new PaymentsPage().verifyAccountsummary();
		return new PaymentsAction();	
	}
	public PaymentsAction paymentViaNewCard_NotClickSaveButton(UserProfile userProfile) {
		new PaymentsPage().paymentViaNewCard_NotClickSaveButton(userProfile);
		return new PaymentsAction();	
	}
	public PaymentsAction paymentViaNewCard_InValidAmount() {
		new PaymentsPage().paymentViaNewCard_InValidAmount();
		return new PaymentsAction();	
	}
	public PaymentsAction VerifypaymentViaExistingCard(UserProfile userProfile) {
		new PaymentsPage().VerifypaymentViaExistingCard(userProfile);
		return new PaymentsAction();	
	}
	public PaymentsAction VerifypaymentViaExistingCardNew(UserProfile userProfile) {
		new PaymentsPage().VerifypaymentViaExistingCardNew(userProfile);
		return new PaymentsAction();	
	}
	public PaymentsAction verifySetupDD() {
		new PaymentsPage().verifySetupDD();
		return new PaymentsAction();	
	}
	public PaymentsAction verifyamendDD(UserProfile userProfile) {
		new PaymentsPage().verifyamendDD(userProfile);
		return new PaymentsAction();	
	}
	public PaymentsAction VerifyAccountSummaryPage() {
		new PaymentsPage().VerifyAccountSummaryPage();
		return new PaymentsAction();	
	}
	public PaymentsAction VerifyPaymentforDebitDDAccount() {
		new PaymentsPage().VerifyPaymentforDebitDDAccount();
		return new PaymentsAction();	
	}
	public PaymentsAction VerifyPaymentforZeroBalanceAccount() {
		new PaymentsPage().VerifyPaymentforZeroBalanceAccount();
		return new PaymentsAction();	
	}
	public PaymentsAction VerifyAccountSummaryPage_forCreditAccount() {
		new PaymentsPage().VerifyAccountSummaryPage_forCreditAccount();
		return new PaymentsAction();	
	}
	
	
	
	
}