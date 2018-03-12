package bg.framework.app.functional.action.services;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.services.LandlordPageNew;
import bg.framework.app.functional.entities.LandLord;


public class LandlordActionNew{
	
	public LandlordActionNew navigateLandLordPage(){
		new LandlordPageNew().navigateLandLordPage();
		return new LandlordActionNew();
	}
	
	public LandlordActionNew verifyPostCodeErrorMessage(){
		new LandlordPageNew().verifyPostCodeErrorMessage();
		return new LandlordActionNew();
	}
	
	public LandlordActionNew verifyMultipleProperty(String AddressType){
		new LandlordPageNew().verifyMultipleProperty(AddressType);
		return new LandlordActionNew();
	}
	
	public LandlordActionNew enterPostcodeDetails(String Postcode){
		new LandlordPageNew().enterPostcodeDetails(Postcode);
		return new LandlordActionNew();
	}
	
	
	public LandlordActionNew verifyPackagePricing(String Type,boolean BoilerCover){
		new LandlordPageNew().verifyPackagePricing(Type,BoilerCover);
		return new LandlordActionNew();
	}
	
	public LandlordActionNew fillPackageDetails(LandLord Landlord){
		new LandlordPageNew().fillPackageDetails(Landlord);
		return new LandlordActionNew();
	}
	
	public LandlordActionNew fillContactSectionAnonymous(String PostCode){
		new LandlordPageNew().fillContactSectionAnonymous(PostCode);
		return new LandlordActionNew();
	}
	
	public LandlordActionNew fillContactSectionLoggedIn(String PostCode){
		new LandlordPageNew().fillContactSectionLoggedIn(PostCode);
		return new LandlordActionNew();
	}
	
	public LandlordActionNew enterPaymentDetails(String PackageDetail){
		new LandlordPageNew().enterPaymentDetails(PackageDetail);
		return new LandlordActionNew();
	}
	
	public LandlordActionNew enterTermsAndConditions(String PackageDetail){
		new LandlordPageNew().enterTermsAndConditions(PackageDetail);
		return new LandlordActionNew();
	}
	
	public LandlordActionNew verifyThankYouPage(){
		new LandlordPageNew().verifyThankYouPage();
		return new LandlordActionNew();
	}
	
	public LandlordActionNew enterPackageDetails(LandLord Landlord){
		new LandlordPageNew().enterPackageDetails(Landlord);
		return new LandlordActionNew();
	}
	
	public LandlordActionNew verifyMultiplePropertyPackageDetails(LandLord Landlord, String PackageDetail){
		new LandlordPageNew().verifyMultiplePropertyPackageDetails(Landlord, PackageDetail);
		return new LandlordActionNew();
	}
	
}
