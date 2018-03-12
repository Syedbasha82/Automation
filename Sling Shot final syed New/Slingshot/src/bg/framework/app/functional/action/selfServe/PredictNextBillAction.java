package bg.framework.app.functional.action.selfServe;

import java.io.IOException;

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
	public PredictNextBillAction errorMessageWithoutMeterRead(){
		PredictNextBillPage errorMessage=new PredictNextBillPage();
		errorMessage.errorMessageWithoutMeterRead();
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
	public PredictNextBillAction verifyImpausibleErrorMessageImplausible()
	{
		PredictNextBillPage impErr=new PredictNextBillPage();
		impErr.verifyImpausibleErrorMessageImplausible();
		return this;
	}
	public PredictNextBillAction verifyLIcallFailorWithoutBill()
	{
		PredictNextBillPage liCallFail=new PredictNextBillPage();
		liCallFail.verifyLIcallFailorWithoutBill();
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
}
