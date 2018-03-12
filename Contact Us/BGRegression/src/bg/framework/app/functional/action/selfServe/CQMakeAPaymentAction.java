package bg.framework.app.functional.action.selfServe;
import java.util.ArrayList;

import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.action.reFactoring.ChangeEmailAction;
import bg.framework.app.functional.action.reFactoring.ForgotEmailAction;
import bg.framework.app.functional.action.reFactoring.ForgotPasswordAction;
import bg.framework.app.functional.action.reFactoring.RegistrationAction;
import bg.framework.app.functional.action.sales.*;
import bg.framework.app.functional.action.selfServe.ContactUsAction;
import bg.framework.app.functional.action.selfServe.HelpAndAdviceAction;
import bg.framework.app.functional.action.selfServe.SelfServeRegistrationAction;
//import bg.framework.app.functional.page.common.LegacyHomePage;
//import bg.framework.app.functional.page.selfServe.CQAdminPage;
//import bg.framework.app.functional.page.selfServe.CQContentSelLoginPage;
import bg.framework.app.functional.page.selfServe.CQMakeAPaymentPage;
import bg.framework.app.functional.page.selfServe.CQSMRPage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.entities.MakeAPaymentProfile;
import bg.framework.app.functional.entities.UserProfile;


public class CQMakeAPaymentAction {
	
	
	
	public CQMakeAPaymentAction SelectAccount(MakeAPaymentProfile makeAPaymentProfile) {
    	CQMakeAPaymentPage CQMakeAPaymentPage = new CQMakeAPaymentPage();
    	CQMakeAPaymentPage.SelectAccount(makeAPaymentProfile.getAccNumber());
           return new CQMakeAPaymentAction();
}
	public CQMakeAPaymentAction navigateToMAPPage() {
    	CQMakeAPaymentPage CQMakeAPaymentPage = new CQMakeAPaymentPage();
    	
    	CQMakeAPaymentPage.navigateToMAPPage();
           return new CQMakeAPaymentAction();
}
	public CQMakeAPaymentAction ClickonContinue() {
    	CQMakeAPaymentPage CQMakeAPaymentPage = new CQMakeAPaymentPage();
    	CQMakeAPaymentPage.ClickonContinue();
           return new CQMakeAPaymentAction();
}
	
	public CQMakeAPaymentAction EnterAmount() {
    	CQMakeAPaymentPage CQMakeAPaymentPage = new CQMakeAPaymentPage();
    	CQMakeAPaymentPage.EnterAmount();
           return new CQMakeAPaymentAction();
}
	
	public CQMakeAPaymentAction EnterCardDetails(MakeAPaymentProfile makeAPaymentProfile) {
    	CQMakeAPaymentPage CQMakeAPaymentPage = new CQMakeAPaymentPage();
    	CQMakeAPaymentPage.EnterCardDetails(makeAPaymentProfile);
           return new CQMakeAPaymentAction();
}
	
	public CQMakeAPaymentAction VerifyCardConfirmation(MakeAPaymentProfile makeAPaymentProfile) {
    	CQMakeAPaymentPage CQMakeAPaymentPage = new CQMakeAPaymentPage();
    	CQMakeAPaymentPage.VerifyCardConfirmation(makeAPaymentProfile);
           return new CQMakeAPaymentAction();
}
	
	public CQMakeAPaymentAction VerifyConfirmationLastCheck(MakeAPaymentProfile makeAPaymentProfile) {
    	CQMakeAPaymentPage CQMakeAPaymentPage = new CQMakeAPaymentPage();
    	CQMakeAPaymentPage.VerifyConfirmationLastCheck(makeAPaymentProfile);
           return new CQMakeAPaymentAction();
}
	
	
	public CQMakeAPaymentAction Verify3DSecurePage(MakeAPaymentProfile makeAPaymentProfile) {
    	CQMakeAPaymentPage CQMakeAPaymentPage = new CQMakeAPaymentPage();
    	CQMakeAPaymentPage.Verify3DSecurePage(makeAPaymentProfile);
           return new CQMakeAPaymentAction();
}
	
	public CQMakeAPaymentAction EnterCardDetailsWithNoCardSecurtityNumber(MakeAPaymentProfile makeAPaymentProfile) {
    	CQMakeAPaymentPage CQMakeAPaymentPage = new CQMakeAPaymentPage();
    	CQMakeAPaymentPage.EnterCardDetailsWithNoCardSecurtityNumber(makeAPaymentProfile);
           return new CQMakeAPaymentAction();
}
	 public CQMakeAPaymentAction navigateToLoginPageMAP() {
		 CQMakeAPaymentPage CQMakeAPaymentPage = new CQMakeAPaymentPage();              
		 CQMakeAPaymentPage.navigateToLoginPageMAP();
 		return new CQMakeAPaymentAction();
 	} 

	 
	 
	 public CQMakeAPaymentAction loginUser(MakeAPaymentProfile makeAPaymentProfile) {
		 CQMakeAPaymentPage CQMakeAPaymentPage = new CQMakeAPaymentPage();              
		 CQMakeAPaymentPage.loginUser(makeAPaymentProfile);
 		return new CQMakeAPaymentAction();
 	} 
}
