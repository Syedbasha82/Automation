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
import bg.framework.app.functional.entities.BAAProfile;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.selfServe.BookAnAppointmentPage;
//import bg.framework.app.functional.page.selfServe.CQAdminPage;
//import bg.framework.app.functional.page.selfServe.CQContentSelLoginPage;
import bg.framework.app.functional.page.selfServe.CQSMRPage;


public class BookAnAppointmentAction {
	
	
	
	 public BookAnAppointmentAction BAAFlow(BAAProfile userprofile) {
		 BookAnAppointmentPage BookAnAppointmentPage = new BookAnAppointmentPage();              
		 BookAnAppointmentPage.BAAFlow(userprofile);
		return new BookAnAppointmentAction();
	} 

	 public BookAnAppointmentAction NavigatetoBAA() {
		 BookAnAppointmentPage BookAnAppointmentPage = new BookAnAppointmentPage();              
		 BookAnAppointmentPage.navigatetoBAAPage();
		return new BookAnAppointmentAction();
	} 
	 
	 public BookAnAppointmentAction BAAFlowAutoSearch(BAAProfile userprofile) {
		 BookAnAppointmentPage BookAnAppointmentPage = new BookAnAppointmentPage();              
		 BookAnAppointmentPage.BAAFlowAutoSearch(userprofile);
		return new BookAnAppointmentAction();
	}

	 public BookAnAppointmentAction BAAFlowInvalidPostCode(BAAProfile userprofile) {
		 BookAnAppointmentPage BookAnAppointmentPage = new BookAnAppointmentPage();              
		 BookAnAppointmentPage.BAAFlowInvalidPostCode(userprofile);
		return new BookAnAppointmentAction();
	}
	 
	 
	 public BookAnAppointmentAction BAANonWorkingBoilerQuote(BAAProfile userprofile) {
		 BookAnAppointmentPage BookAnAppointmentPage = new BookAnAppointmentPage();              
		 BookAnAppointmentPage.BAANonWorkingBoilerQuote(userprofile);
		return new BookAnAppointmentAction();
	}

	 public BookAnAppointmentAction BAANonBoilerQuote(BAAProfile userprofile) {
		 BookAnAppointmentPage BookAnAppointmentPage = new BookAnAppointmentPage();              
		 BookAnAppointmentPage.BAANonBoilerQuote(userprofile);
		return new BookAnAppointmentAction();
	}
	 
	 public BookAnAppointmentAction BAAFlowWithCancel(BAAProfile userprofile) {
		 BookAnAppointmentPage BookAnAppointmentPage = new BookAnAppointmentPage();              
		 BookAnAppointmentPage.BAAFlowWithCancel(userprofile);
		return new BookAnAppointmentAction();
	}
	 
}
