package bg.framework.app.functional.action.selfServe;

import java.io.IOException;
import java.util.ArrayList;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.selfServe.PredictNextBillPage;

public class PredictNextBillAction {
	private UserProfile userProfile;
	public PredictNextBillAction()
	{
		
	}
	public PredictNextBillAction(UserProfile userProfile){
		this.userProfile=userProfile;
	}
	public PredictNextBillAction verifyPNBPageLinks(){
    	PredictNextBillPage navigateToPNB=new PredictNextBillPage(userProfile);
    	navigateToPNB.verifyPNBPageLinks();
    	return this;
    }
	public PredictNextBillAction verifyIntialPNBPage(){
    	PredictNextBillPage navigateToPNB=new PredictNextBillPage(userProfile);
    	navigateToPNB.verifyIntialPNBPage();
    	return this;
    }
	public PredictNextBillAction verifyMeterDials(){
    	PredictNextBillPage meterDial=new PredictNextBillPage();
    	meterDial.verifyMeterDials();
    	return this;
    }
	public PredictNextBillAction selectMeterTypeAndEnterRead(String tolerance,String gasinput,String elecinput,String elecdualinput) throws IOException{
		PredictNextBillPage navigateToPNB=new PredictNextBillPage();
    	try {
			navigateToPNB.selectMeterTypeAndEnterRead(tolerance,gasinput,elecinput,elecdualinput);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return this;
	}
	public PredictNextBillAction clickPredictNextBill(){
		PredictNextBillPage navigateToPNB=new PredictNextBillPage();
    	navigateToPNB.clickPredictNextBill();
    	return this;
	}
	public PredictNextBillAction verifydropDownBoxForDualCusomer(){
		PredictNextBillPage ddBox=new PredictNextBillPage();
		ddBox.verifydropDownBoxForDualCusomer();
    	return this;
	}
	public PredictNextBillAction accountSelect(String accNum){
		PredictNextBillPage selectAccount=new PredictNextBillPage();
		selectAccount.accountSelect(accNum);
    	return this;
	}
	public PredictNextBillAction verifyPredictedBillPage(){
		PredictNextBillPage PNBPage=new PredictNextBillPage();
		PNBPage.verifyPredictedBillPage();
    	return this;
	}
	public PredictNextBillAction errorMessageWithoutMeterRead(ArrayList<String> errList){
		PredictNextBillPage errorMessage=new PredictNextBillPage();
		errorMessage.errorMessageWithoutMeterRead(errList);
    	return this;
	}
	public PredictNextBillAction resetPNBValue(){
		PredictNextBillPage reset=new PredictNextBillPage();
		reset.resetPNBValue();
    	return this;
	}
	public void pnbLogout()
	{
		PredictNextBillPage logout=new PredictNextBillPage();
		logout.pnbLogout();
	}
	public PredictNextBillAction verifyWhatsThisLink()
	{
		PredictNextBillPage whasThis=new PredictNextBillPage();
		whasThis.verifyWhatsThisLink();
		return this;
	}
	public PredictNextBillAction verifyImpausibleErrorMessageImplausible(ArrayList<String> errList)
	{
		PredictNextBillPage impErr=new PredictNextBillPage();
		impErr.verifyImpausibleErrorMessageImplausible(errList);
		return this;
	}
	public PredictNextBillAction verifyLIcallFailorWithoutBill(ArrayList<String> errList)
	{
		PredictNextBillPage liCallFail=new PredictNextBillPage();
		liCallFail.verifyLIcallFailorWithoutBill(errList);
		return this;
	}
	public PredictNextBillAction verifyMIcallFail()
	{
		PredictNextBillPage miCallFail=new PredictNextBillPage();
		miCallFail.verifyMIcallFail();
		return this;
	}
	public PredictNextBillAction enterInputsForSMRJourney(String elecEstimate)
	{
		PredictNextBillPage inputToSMR=new PredictNextBillPage(userProfile);
		inputToSMR.enterInputsForSMRJourney(elecEstimate);
		return this;
	}
	public PredictNextBillAction enterInputsForSMRJourney(String gasEstimate,String elecEstimate)
	{
		PredictNextBillPage inputToSMR=new PredictNextBillPage(userProfile);
		inputToSMR.enterInputsForSMRJourney(gasEstimate,elecEstimate);
		return this;
	}
	public PredictNextBillAction navigateToPNBAfterSMR()
	{
		PredictNextBillPage toPNB=new PredictNextBillPage(userProfile);
		toPNB.navigateToPNBAfterSMR();
		return this;
	}
	public PredictNextBillAction verifyErrorMessage() {
		PredictNextBillPage toPNB=new PredictNextBillPage(userProfile);
		toPNB.verifyErrorMessage();
		return this;
	}
	public PredictNextBillAction verifyUnitRatePrice()
	{
		PredictNextBillPage pricerate=new PredictNextBillPage();
		pricerate.verifyUnitRatePrice();
		return this;
	}
	public PredictNextBillAction verifyStandingRatePrice()
	{
		PredictNextBillPage pricerate=new PredictNextBillPage();
		pricerate.StandingchargePrice();
		return this;
	}
	public PredictNextBillAction verifyElectClicktarifflink()
	{
		PredictNextBillPage pricerate=new PredictNextBillPage();
		pricerate.ClickElecttarifflink();
		return this;
	}
	public PredictNextBillAction verifyGasClicktarifflink()
	{
		PredictNextBillPage pricerate=new PredictNextBillPage();
		pricerate.ClickGastarifflink();
		return this;
	}
	public PredictNextBillAction verifyElectTariffUnitRatePrice()
	{
		PredictNextBillPage pricerate=new PredictNextBillPage();
		pricerate.verifyElecTariffUnitRatePrice();
		return this;
	}
	public PredictNextBillAction verifyTariffStandingRatePrice()
	{
		PredictNextBillPage pricerate=new PredictNextBillPage();
		pricerate.TariffStandingchargePrice();
		return this;
	}
	public PredictNextBillAction verifyGasTariffUnitRatePrice()
	{
		PredictNextBillPage pricerate=new PredictNextBillPage();
		pricerate.verifyGasTariffUnitRatePrice();
		return this;
	}
	public PredictNextBillAction VerifyGasTariffStandingchargePrice()
	{
		PredictNextBillPage pricerate=new PredictNextBillPage();
		pricerate.VerifyGasTariffStandingchargePrice();
		return this;
	}
	public PredictNextBillAction VerifyCloseCurrentTariff()
	{
		PredictNextBillPage pricerate=new PredictNextBillPage();
		pricerate.closeCurrentTariff();
		return this;
	}
	public PredictNextBillAction verifyElectUnitRatePrice()
	{
		PredictNextBillPage pricerate=new PredictNextBillPage();
		pricerate.verifyElectUnitRatePrice();
		return this;
       }
	public PredictNextBillAction VerifyElectStandingchargePrice()
	{
		PredictNextBillPage pricerate=new PredictNextBillPage();
		pricerate.VerifyElectStandingchargePrice();
		return this;
       }

}