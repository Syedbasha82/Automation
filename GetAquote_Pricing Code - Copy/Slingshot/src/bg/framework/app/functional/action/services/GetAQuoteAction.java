package bg.framework.app.functional.action.services;

import java.util.ArrayList;

import bg.framework.app.functional.entities.LandLord;
import bg.framework.app.functional.page.services.GetAQuotePage;

public class GetAQuoteAction {
	private LandLord landLoard;

	
    public GetAQuoteAction() {
		
	}
	
	public GetAQuoteAction(LandLord landLoard){
		this.landLoard=landLoard;
	}

	public GetAQuoteAction singleEntryTellUsAction(){
		final GetAQuotePage getAQuotePage=new GetAQuotePage();
		getAQuotePage.enterTellUs(landLoard.getPostCode(),landLoard.getHouseNumber());
		getAQuotePage.selectAddress(1);
		getAQuotePage.clickNextButton();
		return this;		
	}
	public GetAQuoteAction multiEntryTellUsAction(int number){
		final GetAQuotePage getAQuotePage=new GetAQuotePage(landLoard);
		getAQuotePage.enterMultiTellUs(number);
		getAQuotePage.clickCancelLink(number);
		getAQuotePage.clickNextButton();
		return this;
	}	
	
	public GetAQuoteAction manualEntryAction(){
		final GetAQuotePage getAQuotePage=new GetAQuotePage(landLoard);
		getAQuotePage.enterTellUs(landLoard.getPostCode(),landLoard.getHouseNumber());
		getAQuotePage.clickEnterManualLink();
		getAQuotePage.verifyManualAddressError();
		getAQuotePage.verufyManualAddressSuccess();
		return this;
	}
	public GetAQuoteAction editPropertyAction(){
		final GetAQuotePage getAQuotePage=new GetAQuotePage(landLoard);		
		getAQuotePage.editProperty();		
		return this;
	}
	
	public GetAQuoteAction removeAndAddPropertyAction(int number){
		final GetAQuotePage getAQuotePage=new GetAQuotePage(landLoard);
		getAQuotePage.removeProperty(number);
		getAQuotePage.addProperty();
		return this;
	}
	public GetAQuoteAction packageAction(){
		final GetAQuotePage getAQuotePage=new GetAQuotePage(landLoard);
		getAQuotePage.selectPackage();		
		return this;
	}
	public GetAQuoteAction verifyInvalidPackageAction(){
		final GetAQuotePage getAQuotePage=new GetAQuotePage(landLoard);
		getAQuotePage.verifyInvalidPackage();
		return this;
	}
	
	public GetAQuoteAction selectAddOnAction(int index){
		final GetAQuotePage getAQuotePage=new GetAQuotePage(landLoard);
		getAQuotePage.selectAdd(index);		
		return this;
	}
	
	public GetAQuoteAction editPackageAction(int number){
		final GetAQuotePage getAQuotePage=new GetAQuotePage(landLoard);
		getAQuotePage.editPackage(number);
		getAQuotePage.selectPackage();
		getAQuotePage.selectAdd(number);		
		return this;
	}
	
	public GetAQuoteAction verifyInvalidDateAction(){
		final GetAQuotePage getAQuotePage=new GetAQuotePage(landLoard);	
		getAQuotePage.verifyInvalidDate();
		return this;
	}
	
//	public GetAQuoteAction verifyPackageAction(){
//		final GetAQuotePage getAQuotePage=new GetAQuotePage(landLoard);
//		final double price=getAQuotePage.verifyPackagePrice();
//		getAQuotePage.clickCompleteQuote();
//		getAQuotePage.verifyAmout(price);
//		return this;
//	}
//	
	public GetAQuoteAction multiPackageAction(){
		final GetAQuotePage getAQuotePage=new GetAQuotePage(landLoard);
		getAQuotePage.selectMultiPackage();
		return this;
	}
	
	public GetAQuoteAction selectMultiAddPackageAction(){
		final GetAQuotePage getAQuotePage=new GetAQuotePage(landLoard);
		getAQuotePage.selectMultiAddPackage();
		return this;
	}
	
	public GetAQuoteAction addAnotherPropertyAction(){
		final GetAQuotePage getAQuotePage=new GetAQuotePage(landLoard);
		getAQuotePage.addPropertyfromGetAQuote();
		return this;
	}
	
	public GetAQuoteAction verifySectionOne(){
		final GetAQuotePage getAQuotePage=new GetAQuotePage(landLoard);
		getAQuotePage.verifySectionOne();
		return this;
	}
	
	public ArrayList<Object> verifyTotalPriceAction(){
		return new GetAQuotePage(landLoard).verifyTotalPrice(0);
	}
	
	public GetAQuoteAction applyAllAction() {
		final GetAQuotePage getAQuotePage=new GetAQuotePage(landLoard);
		getAQuotePage.clickApplyAll();
		return this;
	}
	
	public GetAQuoteAction verificationAfterApplyAllAction(int count){
		final GetAQuotePage getAQuotePage=new GetAQuotePage(landLoard);
		getAQuotePage.verifyAfterApplyAll(count);		
		return this;		
	}	
	
	public GetAQuoteAction postCodeInvalidAction(){
		final GetAQuotePage getAQuotePage=new GetAQuotePage(landLoard);
		getAQuotePage.verifyPostCode();
		getAQuotePage.verifyUncoverPostCode();
		return this;
	}
	
	public GetAQuoteAction selectionErrorAction(){
		final GetAQuotePage getAQuotePage=new GetAQuotePage(landLoard);
		getAQuotePage.selectAddressError();
		return this;
	}
	
	public GetAQuoteAction whatsThisOverLayAction(){
		final GetAQuotePage getAQuotePage=new GetAQuotePage(landLoard);
		getAQuotePage.verifyWhatsThisOverLay();
		return this;
	}
	public GetAQuoteAction getAQuoteAction(){
		final GetAQuotePage getAQuotePage=new GetAQuotePage(landLoard);		
		getAQuotePage.verifyAddPropertyLink();
		getAQuotePage.clickCompleteQuote();
		getAQuotePage.verfifyGetAQuote();
		return this;
	}
	
	public GetAQuoteAction nextPropertyAction(){
		final GetAQuotePage getAQuotePage=new GetAQuotePage(landLoard);
		getAQuotePage.nextProperty();
		return this;
	}
	
	public GetAQuoteAction editMyQuoteAction(){
		final GetAQuotePage getAQuotePage=new GetAQuotePage(landLoard);
		getAQuotePage.clickEditMyQuote();
		return this;
	}
	
	public OrderNowAction orderNowAction(){
		final GetAQuotePage getAQuotePage=new GetAQuotePage(landLoard);
		getAQuotePage.clickOrderNow();
		return new OrderNowAction(landLoard);
	}
	
	public GetAQuoteAction logoutAction(){
		final GetAQuotePage getAQuotePage=new GetAQuotePage(landLoard);
		getAQuotePage.logout();
		return this;
	}
	
	public GetAQuoteAction endPackageAction(){
		final GetAQuotePage getAQuotePage=new GetAQuotePage(landLoard);
		getAQuotePage.endMultiPackage();
		return this;
	}
}
