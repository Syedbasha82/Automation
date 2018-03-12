package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.repairAndCoverPage;

public class repairAndCoverAction {
	private static String boilerType;
	private static String paymentType;
	private static String addrType;
	private static String custType;
	public repairAndCoverAction(){
		
	}
	
	public repairAndCoverAction(String custType,String boilerType,String paymentType,String addrType){
		this.boilerType = boilerType;
		this.paymentType = paymentType;
		this.addrType = addrType;
		this.custType = custType;
	}
 
	public repairAndCoverAction navigateToBoilerLandingPage(){
		repairAndCoverPage CoverPage = new repairAndCoverPage(custType,boilerType,paymentType,addrType);
		CoverPage.navigateToBoilerLandingPage();
		return new repairAndCoverAction();
	}
	public repairAndCoverAction navigateToHECLandingPage(){
		repairAndCoverPage CoverPage = new repairAndCoverPage(custType,boilerType,paymentType,addrType);
		CoverPage.navigateToHECLandingPage();
		return new repairAndCoverAction();
	}
	public repairAndCoverAction navigateToKACLandingPage(){
		repairAndCoverPage CoverPage = new repairAndCoverPage(custType,boilerType,paymentType,addrType);
		CoverPage.navigateToKACLandingPage();
		return new repairAndCoverAction();
	}
	public repairAndCoverAction navigateToLandlordLandingPage(){
		repairAndCoverPage CoverPage = new repairAndCoverPage(custType,boilerType,paymentType,addrType);
		CoverPage.navigateToLandlordLandingPage();
		return new repairAndCoverAction();
	}
	public repairAndCoverAction selectFirstAppointment(){
		repairAndCoverPage CoverPage = new repairAndCoverPage(custType,boilerType,paymentType,addrType);
		CoverPage.selectFirstAppointment();
		return new repairAndCoverAction();
	} 
	public repairAndCoverAction validateAddressPostCode(UserProfile userProfile){
		repairAndCoverPage CoverPage = new repairAndCoverPage(custType,boilerType,paymentType,addrType);
		CoverPage.validateAddressPostCode(userProfile);
		return new repairAndCoverAction();
	}
	public repairAndCoverAction validateNoAppointment(UserProfile userProfile){
		repairAndCoverPage CoverPage = new repairAndCoverPage(custType,boilerType,paymentType,addrType);
		CoverPage.validateNoAppointment(userProfile);
		return new repairAndCoverAction();
	}
	public repairAndCoverAction inputPostCode(Acquisition acquisition, UserProfile userProfile){
		repairAndCoverPage CoverPage = new repairAndCoverPage();
		CoverPage.inputPostCode(acquisition,userProfile);
		return new repairAndCoverAction();
	}
	public repairAndCoverAction changeAddress(){
		repairAndCoverPage CoverPage = new repairAndCoverPage();
		CoverPage.changeAddress();
		return new repairAndCoverAction();
	}
	public repairAndCoverAction verifyAddressChange(){
		repairAndCoverPage CoverPage = new repairAndCoverPage();
		CoverPage.verifyAddressChange();
		return new repairAndCoverAction();
	}
	public repairAndCoverAction enteringContactDetails(UserProfile userProfile,Acquisition acquisition){
		repairAndCoverPage CoverPage = new repairAndCoverPage(custType,boilerType,paymentType,addrType);
		CoverPage.enteringContactDetails(userProfile,acquisition);
		return new repairAndCoverAction();
	}
	public repairAndCoverAction enterPostCode(Acquisition acquisition){
		repairAndCoverPage CoverPage = new repairAndCoverPage(custType,boilerType,paymentType,addrType);
		CoverPage.enterPostCode(acquisition);
		return new repairAndCoverAction();
	}
	public repairAndCoverAction verifyAndSelectAppointmentSlot(){
		repairAndCoverPage CoverPage = new repairAndCoverPage(custType,boilerType,paymentType,addrType);
		CoverPage.verifyAndSelectAppointmentSlot();
		return new repairAndCoverAction();
	} 
	public repairAndCoverAction verifyRepairAndCoverPage(){
		repairAndCoverPage CoverPage = new repairAndCoverPage(custType,boilerType,paymentType,addrType);
		CoverPage.verifyRepairAndCoverPage();
		return new repairAndCoverAction();
	}
	public repairAndCoverAction navigateToOrderNowPage(){
		repairAndCoverPage CoverPage = new repairAndCoverPage(custType,boilerType,paymentType,addrType);
		CoverPage.navigateToOrderNowPage();
		return new repairAndCoverAction();
	}
	public repairAndCoverAction selectingBoilerType(){
		repairAndCoverPage CoverPage = new repairAndCoverPage(custType,boilerType,paymentType,addrType);
		CoverPage.selectingBoilerType();
		return new repairAndCoverAction();
	}
	public repairAndCoverAction paymentForFixedPriceRepair(Acquisition acquisition){
		repairAndCoverPage CoverPage = new repairAndCoverPage(custType,boilerType,paymentType,addrType);
		CoverPage.paymentForFixedPriceRepair(acquisition);
		return new repairAndCoverAction();
	}
	public repairAndCoverAction paymentForMonthlyCover(Acquisition acquisition){
		repairAndCoverPage CoverPage = new repairAndCoverPage(custType,boilerType,paymentType,addrType);
		CoverPage.paymentForMonthlyCover(acquisition);
		return new repairAndCoverAction();
	}
	public repairAndCoverAction enteringTermsAndConditions(UserProfile userProfile){
		repairAndCoverPage CoverPage = new repairAndCoverPage(custType,boilerType,paymentType,addrType);
		CoverPage.enteringTermsAndConditions(userProfile);
		return new repairAndCoverAction();
	}
	public repairAndCoverAction verifyThankYouPage(){
		repairAndCoverPage CoverPage = new repairAndCoverPage(custType,boilerType,paymentType,addrType);
		CoverPage.verifyThankYouPage();
		return new repairAndCoverAction();
	}
	public repairAndCoverAction verifyKACPriceValues(Acquisition acquisition){
		repairAndCoverPage CoverPage = new repairAndCoverPage(custType,boilerType,paymentType,addrType);
		CoverPage.verifyKACPriceValues(acquisition);
		return new repairAndCoverAction();
	}
	public repairAndCoverAction anonymousRegistration(UserProfile userProfile){
		repairAndCoverPage CoverPage = new repairAndCoverPage(custType,boilerType,paymentType,addrType);
		CoverPage.anonymousRegistration(userProfile);
		return new repairAndCoverAction();
	}
	public repairAndCoverAction verifyLandlordPriceValues(Acquisition acquisition){
		repairAndCoverPage CoverPage = new repairAndCoverPage(custType,boilerType,paymentType,addrType);
		CoverPage.verifyLandlordPriceValues(acquisition);
		return new repairAndCoverAction();
	}
	
	public repairAndCoverAction verifyAnonymousRegis(){
		repairAndCoverPage CoverPage = new repairAndCoverPage(custType,boilerType,paymentType,addrType);
		CoverPage.verifyAnonymousRegis();
		return new repairAndCoverAction();
	}
	public repairAndCoverAction anonymousAudit(UserProfile userProfile){
		repairAndCoverPage CoverPage = new repairAndCoverPage(custType,boilerType,paymentType,addrType);
		CoverPage.anonymousAudit(userProfile);
		return new repairAndCoverAction();
	}
	public repairAndCoverAction loginVerification(){
		repairAndCoverPage CoverPage = new repairAndCoverPage(custType,boilerType,paymentType,addrType);
		CoverPage.loginVerification();
		return new repairAndCoverAction();
	}
}
