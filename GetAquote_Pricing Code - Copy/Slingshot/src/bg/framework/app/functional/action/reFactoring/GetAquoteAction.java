package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.entities.Slinshot.CompareTariff;
import bg.framework.app.functional.page.reFactoring.GetAquotePage;
import bg.framework.app.functional.entities.Acquisition;

public class GetAquoteAction {
	
	public GetAquoteAction navigateToGetAquotepage () {
		GetAquotePage GetAquotePage=new GetAquotePage();
		GetAquotePage.navigateToGetAquotePage();
		return this;	
		}
	public GetAquoteAction selectOnlineAcct () {
		GetAquotePage GetAquotePage=new GetAquotePage();
		GetAquotePage.selectOnlineAcct();
		return this;	
		}
	public GetAquoteAction enterPostCodeNew (CompareTariff CompareTariff, UserProfile userProfile) {
		GetAquotePage GetAquotePage=new GetAquotePage();
		GetAquotePage.enterPostCodeNew(CompareTariff,userProfile);
		return this;	
		}
	public GetAquoteAction SelectNewProp (UserProfile userProfile) {
		GetAquotePage GetAquotePage=new GetAquotePage();
		GetAquotePage.SelectNewProp(userProfile);
		return this;	
		}
	
	public GetAquoteAction enterTelephoneNumber (UserProfile userProfile) {
		GetAquotePage GetAquotePage=new GetAquotePage();
		GetAquotePage.enterTelephoneNumber(userProfile);
		return this;	
		}
	public GetAquoteAction enterPostCode (UserProfile userProfile) {
		GetAquotePage GetAquotePage=new GetAquotePage();
		GetAquotePage.enterPostCode(userProfile);
		return this;	
		}
	
	public GetAquoteAction selectGasQuote () {
		GetAquotePage GetAquotePage=new GetAquotePage();
		GetAquotePage.selectGasQuote();
		return this;	
		}
	
	public GetAquoteAction selectElectQuote () {
		GetAquotePage GetAquotePage=new GetAquotePage();
		GetAquotePage.selectElectQuote();
		return this;	
		}
	public GetAquoteAction selectCompareTariff (String TariffList) {
		GetAquotePage GetAquotePage=new GetAquotePage();
		GetAquotePage.SelectCompareTariff(TariffList);
		return this;	
		}
	
	public GetAquoteAction clickInfo (CompareTariff CompareTariff) {
		GetAquotePage GetAquotePage=new GetAquotePage();
		GetAquotePage.clickInfo(CompareTariff);
		return this;	
		}
	
	public GetAquoteAction BuyTariff (CompareTariff CompareTariff, UserProfile userProfile) {
		GetAquotePage GetAquotePage=new GetAquotePage();
		GetAquotePage.BuyTariff(CompareTariff, userProfile);
		return this;	
		}
	public GetAquoteAction PaymentDetail (Acquisition acquisition) {
		GetAquotePage GetAquotePage=new GetAquotePage();
		GetAquotePage.PaymentDetail(acquisition);
		return this;	
		}
	
	public GetAquoteAction verifyPricing (CompareTariff CompareTariff) {
		GetAquotePage GetAquotePage=new GetAquotePage();
		GetAquotePage.verifyPricing(CompareTariff);
		return this;	
		}
	
	public GetAquoteAction closeTariff() {
		GetAquotePage GetAquotePage=new GetAquotePage();
		GetAquotePage.closeTariff();
		return this;	
		}
	public GetAquoteAction TariffpricingVerification(CompareTariff CompareTariff){
		GetAquotePage GetAquotePage = new GetAquotePage(); 
		GetAquotePage.TariffpricingVerification(CompareTariff);
		return this;
	}
	
	public GetAquoteAction QuoteVerification(CompareTariff CompareTariff){
		GetAquotePage GetAquotePage = new GetAquotePage(); 
		GetAquotePage.SingleFuel(CompareTariff);
		return this;
	}
	public GetAquoteAction VerifyFuelStatus(UserProfile userProfile,CompareTariff CompareTariff){
		GetAquotePage GetAquotePage = new GetAquotePage(); 
		GetAquotePage.VerifyFuelStatus(userProfile,CompareTariff);
		return this;
	}
	public GetAquoteAction VerifyDuelFuel(UserProfile userProfile,CompareTariff CompareTariff){
		GetAquotePage GetAquotePage = new GetAquotePage(); 
		GetAquotePage.DuelFuel(userProfile,CompareTariff);
		return this;
	}
	
	public GetAquoteAction VerifyFuelStatus_Buy(CompareTariff CompareTariff, UserProfile userProfile){
		GetAquotePage GetAquotePage = new GetAquotePage(); 
		GetAquotePage.VerifyFuelStatus_Buy(CompareTariff, userProfile);
		return this;
	}
	
	public GetAquoteAction GasQuotePricing(CompareTariff CompareTariff){
		GetAquotePage GetAquotePage = new GetAquotePage(); 
		GetAquotePage.GasQuotePricing(CompareTariff);
		return this;
	}
	
	public GetAquoteAction ElectQuotePricing(CompareTariff CompareTariff){
		GetAquotePage GetAquotePage = new GetAquotePage(); 
		GetAquotePage.ElectQuotePricing(CompareTariff);
		return this;
	}
	public GetAquoteAction BuyElectTariff(CompareTariff CompareTariff, UserProfile userProfile){
		GetAquotePage GetAquotePage = new GetAquotePage(); 
		GetAquotePage.BuyElectTariff(CompareTariff, userProfile);
		return this;
	}
	public GetAquoteAction BuyGasTariff(CompareTariff CompareTariff, UserProfile userProfile){
		GetAquotePage GetAquotePage = new GetAquotePage(); 
		GetAquotePage.BuyGasTariff(CompareTariff, userProfile);
		return this;
	}
	public GetAquoteAction SingleFuelBuynow(CompareTariff CompareTariff, UserProfile userProfile){
		GetAquotePage GetAquotePage = new GetAquotePage(); 
		GetAquotePage.SingleFuelBuynow(CompareTariff, userProfile);
		return this;
	}
	
}
