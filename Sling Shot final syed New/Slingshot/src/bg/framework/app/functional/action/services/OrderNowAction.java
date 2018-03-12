package bg.framework.app.functional.action.services;

import java.util.ArrayList;

import org.springframework.core.annotation.Order;

import bg.framework.app.functional.entities.LandLord;
import bg.framework.app.functional.page.services.OrderNowPage;

public class OrderNowAction {
	private LandLord landLord;
	
	public OrderNowAction(LandLord landLord) {
		this.landLord=landLord;
	}

	public OrderNowAction verifyOrderNowAction(){
		final OrderNowPage orderNowPage=new OrderNowPage();
		orderNowPage.verifyOrderNowPage();
		return this;
	}
	
	public OrderNowAction contactUsAction(LandLord landLord){
		final OrderNowPage orderNowPage=new OrderNowPage(landLord);
		orderNowPage.enterContactSection();
		orderNowPage.clickSearchButton();
		orderNowPage.selectAddress(1);
		orderNowPage.clickNextButton();
		return this;
	}
	
	public OrderNowAction contactUsErrorAction(){
		final OrderNowPage orderNowPage=new OrderNowPage(landLord);
		orderNowPage.contactUsErrorVerification();
		return this;
	}
	
	public OrderNowAction contactPrePopulatedAction(){
		final OrderNowPage orderNowPage=new OrderNowPage(landLord);
		orderNowPage.contactUsPerpolutatedCheck();
		return this;
	}
	
	public OrderNowAction editContactUsAction(){
		final OrderNowPage orderNowPage=new OrderNowPage(landLord);
		orderNowPage.contactUsEditVerification();
		return this;
	}
	
	public OrderNowAction standAloneCP12DebitDAction(ArrayList<Object> price){
		final OrderNowPage orderNowPage=new OrderNowPage(landLord);
		orderNowPage.clickCP12DirectDebit();
		orderNowPage.verifyPopulatedPrice(price);
		orderNowPage.enterStandAloneDebitDetail();
		orderNowPage.clickStandAloneNextButton();
		return this;
	}

	public OrderNowAction standAloneCP12CreditDAction(ArrayList<Object> price){
		final OrderNowPage orderNowPage=new OrderNowPage(landLord);
		orderNowPage.clickCP12CreditDebit();
		orderNowPage.verifyPopulatedPrice(price);
		orderNowPage.enterStandAloneCreditDetail();
		orderNowPage.clickStandAloneNextButton();
		return this;
	}
	
	public OrderNowAction payForHomeCDebitDAction(ArrayList<Object> price){
		final OrderNowPage orderNowPage=new OrderNowPage(landLord);
		orderNowPage.clickHCMonthlyDebit();
		//orderNowPage.verifyPopulatedPrice(price);
		orderNowPage.enterPayForHomeDebitDetail();
		orderNowPage.clickPayNextButton();
		return this;
	}
	
	public OrderNowAction payForHomeCAnnualDebitDAction(ArrayList<Object> price){
		final OrderNowPage orderNowPage=new OrderNowPage(landLord);
		orderNowPage.clickHCAnualDebit();
		//orderNowPage.verifyPopulatedPrice(price);
		orderNowPage.enterPayForHomeAnnualDebitDetail();
		orderNowPage.clickPayNextButton();
		return this;
	}
	public OrderNowAction payForHomeCCreditDAction(ArrayList<Object> price){
		final OrderNowPage orderNowPage=new OrderNowPage(landLord);
		orderNowPage.clickHCAnnualCredit();
		orderNowPage.verifyPopulatedPrice(price);
		orderNowPage.enterPayForHomeCreditDetail();
		orderNowPage.clickPayNextButton();
		return this;
	}
	
	public OrderNowAction termsAndConditionAction(String date){
		final OrderNowPage orderNowPage=new OrderNowPage();
		orderNowPage.clickCP12TermsCondition();
		orderNowPage.clickContactTermsCondition();
		orderNowPage.clickPlaceOrderButton();
		orderNowPage.verifyPaymentSuccess(date);
		return this;
	}
	
	public OrderNowAction standAloneErrorAction(){
		final OrderNowPage orderNowPage=new OrderNowPage(landLord);
		orderNowPage.clickCP12DirectDebit();	
		orderNowPage.verifyDebitCardError();
		orderNowPage.clickCP12CreditDebit();
		orderNowPage.verifyCreditCardError();
		return this;
	}
	
	public OrderNowAction payForPackageErrorAction(){
		final OrderNowPage orderNowPage=new OrderNowPage(landLord);
		orderNowPage.clickHCMonthlyDebit();	
    	orderNowPage.verifyDebitCardError();
		orderNowPage.clickHCAnualDebit();
		orderNowPage.verifyDebitCardError();
		orderNowPage.clickHCAnnualCredit();
		orderNowPage.verifyCreditCardError();
		return this;
	}
	
	public void optOutAction(){
		final OrderNowPage orderNowPage=new OrderNowPage(landLord);
		orderNowPage.optOutCheck();	
	}
	
	
	public void batch(String date){
		final OrderNowPage orderNowPage=new OrderNowPage(landLord);
		orderNowPage.runBatch(date);
		orderNowPage.leadDataAfterBatch(date);
	}
	
}
