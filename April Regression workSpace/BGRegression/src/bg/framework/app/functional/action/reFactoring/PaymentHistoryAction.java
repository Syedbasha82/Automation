package bg.framework.app.functional.action.reFactoring;

import java.text.ParseException;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.PaymentHistoryPage;

public class PaymentHistoryAction {
	String balanceInApp;
	public PaymentHistoryAction(){
		
	}	
	public PaymentHistoryAction(String a){
		balanceInApp=a;
	}

	 public PaymentHistoryAction verifyPaymentsHistoryLinks() {
		    PaymentHistoryPage paymentHistoryPage = new PaymentHistoryPage();
		    paymentHistoryPage.paymentsHistoryLinkValidation();
	        return this;
	    }
	 
	 public PaymentHistoryAction verifyMakeAPayment(String accNumber) {
		    PaymentHistoryPage paymentHistoryPage = new PaymentHistoryPage();
	    paymentHistoryPage.makeAPaymentValidation(accNumber);
	        return this;
	    }
	
	 public PaymentHistoryAction verifyTransactionHistory(UserProfile userProfile) {
		    PaymentHistoryPage paymentHistoryPage = new PaymentHistoryPage();
		    paymentHistoryPage.transactionHistoryValidation(userProfile);
	        return this;
	    }
	 
	 public PaymentHistoryAction verifyTransactionHistoryItems() {
		    PaymentHistoryPage paymentHistoryPage = new PaymentHistoryPage();		    
	        return new PaymentHistoryAction(paymentHistoryPage.transactionHistoryTableValidation());
		 }
	 
	 public PaymentHistoryAction verifySearchField(String searchText) {
		    PaymentHistoryPage paymentHistoryPage = new PaymentHistoryPage();
	    paymentHistoryPage.searchFieldValidation(searchText);
	        return this;
	    }
	 
	 public PaymentHistoryAction verifyDateField() throws ParseException {
		    PaymentHistoryPage paymentHistoryPage = new PaymentHistoryPage();
		    paymentHistoryPage.dateFieldValidation();
        return new PaymentHistoryAction(balanceInApp);
	    }
	 
	 public PaymentHistoryAction verifyBillHistory() {
		    PaymentHistoryPage paymentHistoryPage = new PaymentHistoryPage();
		    paymentHistoryPage.billHistoryTableValidation();
        return new PaymentHistoryAction(balanceInApp);
	  }
	 
	 public PaymentHistoryAction verifyMeterReadHistory(String accNumber) throws ParseException {
		    PaymentHistoryPage paymentHistoryPage = new PaymentHistoryPage();
		    paymentHistoryPage.meterReadHistoryValidation(accNumber,balanceInApp);
	        return this;
	    }
	 public PaymentHistoryAction logout(){
		    PaymentHistoryPage paymentHistoryPage = new PaymentHistoryPage();
		    paymentHistoryPage.logout();
	        return this;
	    }
}
