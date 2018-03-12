package bg.framework.app.functional.action.selfServe;
import bg.framework.app.functional.page.selfServe.AccountOverviewPage;
import bg.framework.app.functional.page.selfServe.RequestPaymentCardPage;

public class RequestPaymentCardAction {

	public RequestPaymentCardAction navigateToOrderNewPaymentCard(){
		RequestPaymentCardPage requestpaymentcardpage = new RequestPaymentCardPage();
		requestpaymentcardpage.navigateToOrderNewPaymentCard();
		return new RequestPaymentCardAction();
		}
	
	public RequestPaymentCardAction submitYourDetails(){
		RequestPaymentCardPage requestpaymentcardpage = new RequestPaymentCardPage();
		requestpaymentcardpage.submitYourDetails();
		return new RequestPaymentCardAction();
	}
	
	public RequestPaymentCardAction enterDiffDeliveryAddress(){
		RequestPaymentCardPage requestpaymentcardpage = new RequestPaymentCardPage();
		requestpaymentcardpage.enterDiffDeliveryAddress();
		return new RequestPaymentCardAction();
	}
	
	
	public RequestPaymentCardAction verifyElecPaymentConfirmation(){
		RequestPaymentCardPage requestpaymentcardpage = new RequestPaymentCardPage();
		requestpaymentcardpage.verifyElecPaymentConfirmation();
		 new AccountOverviewPage().logout();
		return new RequestPaymentCardAction();
	}
	
	public RequestPaymentCardAction verifyGasPaymentConfirmation(){
		RequestPaymentCardPage requestpaymentcardpage = new RequestPaymentCardPage();
		requestpaymentcardpage.verifyGasPaymentConfirmation();
		 new AccountOverviewPage().logout();
		return new RequestPaymentCardAction();
	}
}
