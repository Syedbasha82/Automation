package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.entities.Slinshot.CompareTariff;
import bg.framework.app.functional.page.reFactoring.SEGetAQuotePage;

public class SEGetAQuoteAction {
	
	public SEGetAQuoteAction navigateToSEGetAquotePage () {
		SEGetAQuotePage SEGetAQuotePage=new SEGetAQuotePage();
		SEGetAQuotePage.navigateToSEGetAquotePage();
		return this;	
		}
	/*public SEGetAQuoteAction selectOnlineAcct () {
		SEGetAQuotePage SEGetAQuotePage=new SEGetAQuotePage();
		SEGetAQuotePage.selectOnlineAcct();
		return this;	
		}*/
	public SEGetAQuoteAction enterPostCodeNew (CompareTariff CompareTariff, UserProfile userProfile) {
		SEGetAQuotePage SEGetAQuotePage=new SEGetAQuotePage();
		SEGetAQuotePage.enterPostCodeNew(CompareTariff,userProfile);
		return this;	
		}
	/*public SEGetAQuoteAction SelectNewProp (UserProfile userProfile) {
		SEGetAQuotePage SEGetAQuotePage=new SEGetAQuotePage();
		SEGetAQuotePage.SelectNewProp(userProfile);
		return this;	
		}*/
	
	/*public SEGetAQuoteAction enterTelephoneNumber (UserProfile userProfile) {
		SEGetAQuotePage SEGetAQuotePage=new SEGetAQuotePage();
		SEGetAQuotePage.enterTelephoneNumber(userProfile);
		return this;	
		}*/
	/*public SEGetAQuoteAction enterPostCode (UserProfile userProfile) {
		SEGetAQuotePage SEGetAQuotePage=new SEGetAQuotePage();
		SEGetAQuotePage.enterPostCode(userProfile);
		return this;	
		}*/
	
	/*public SEGetAQuoteAction selectGasQuote () {
		SEGetAQuotePage GetAquotePage=new SEGetAQuotePage();
		SEGetAQuotePage.selectGasQuote();
		return this;	
		}
	
	public SEGetAQuoteAction selectElectQuote () {
		SEGetAQuotePage SEGetAQuotePage=new SEGetAQuotePage();
		SEGetAQuotePage.selectElectQuote();
		return this;	
		}
	public SEGetAQuoteAction selectCompareTariff (String TariffList) {
		SEGetAQuotePage SEGetAQuotePage=new SEGetAQuotePage();
		SEGetAQuotePage.SelectCompareTariff(TariffList);
		return this;	
		}*/
	
	public SEGetAQuoteAction clickInfo (CompareTariff CompareTariff) {
		SEGetAQuotePage SEGetAQuotePage=new SEGetAQuotePage();
		SEGetAQuotePage.clickInfo(CompareTariff);
		return this;	
		}
	

	public SEGetAQuoteAction verifyPricing (CompareTariff CompareTariff) {
		SEGetAQuotePage SEGetAQuotePage=new SEGetAQuotePage();
		SEGetAQuotePage.verifyPricing(CompareTariff);
		return this;	
		}
	
	public SEGetAQuoteAction closeTariff() {
		SEGetAQuotePage SEGetAQuotePage=new SEGetAQuotePage();
		SEGetAQuotePage.closeTariff();
		return this;	
		}
	
	
	public SEGetAQuoteAction QuoteVerification(CompareTariff CompareTariff){
		SEGetAQuotePage SEGetAQuotePage = new SEGetAQuotePage(); 
		SEGetAQuotePage.SingleFuel(CompareTariff);
		return this;
	}
	public SEGetAQuoteAction VerifyFuelStatus(UserProfile userProfile,CompareTariff CompareTariff){
		SEGetAQuotePage SEGetAQuotePage = new SEGetAQuotePage(); 
		SEGetAQuotePage.VerifyFuelStatus(userProfile,CompareTariff);
		return this;
	}
	/*public SEGetAQuoteAction VerifyDuelFuelUserProfile userProfile,CompareTariff CompareTariff){
		SEGetAQuotePage SEGetAQuotePage = new SEGetAQuotePage(); 
		SEGetAQuotePage.DuelFuel(userProfile,CompareTariff);
		return this;
	}*/
	
	

}
