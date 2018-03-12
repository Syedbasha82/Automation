package bg.framework.app.functional.action.sales;
import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.LegacyHomePage;
import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.page.sales.CHIAppointmentPage;
import bg.framework.app.functional.page.sales.UpsellPage;

public class CHIAppointmentAction {
	CHIAppointmentPage chiAppointment = new CHIAppointmentPage();

	public CHIAppointmentAction loginUser(UserProfile userProfile) {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToLoginPage();
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.loginUser(userProfile);
        return this;
    }
	public CHIAppointmentAction enterAppointmentBookingdetails() {
		chiAppointment.enterAppointmentBookingdetails();
        return this;
    }
	public CHIAppointmentAction navigateToAppointmentBookingpage() {
		LegacyHomePage legacyHomePage = new LegacyHomePage();
		legacyHomePage.navigateToProductsAndServicesPage();
		chiAppointment.navigateToAppointmentBookingpage();
		chiAppointment.navigateBookthisAppointmenPage();
        return this;
    }
	
	
	public CHIAppointmentAction enterPersonalDetailsRequestCallBack(UserProfile userProfile) {
		LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToNewBoilers();
        legacyHomePage.navigateToRequestCallBack();
		chiAppointment.enterPersonalDetailsRequestCallBack(userProfile);
        return this;
    }
	
	public CHIAppointmentAction enterPersonalDetailsBookApp(UserProfile userProfile) {
		LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToNewBoilers();
        legacyHomePage.navigateToBookApp();
        return this;
    }
	
	public CHIAppointmentAction firstPage(UserProfile userProfile) {
		chiAppointment.firstPage(userProfile);
        return this;
    }
	
	public CHIAppointmentAction secondPageCancel(UserProfile userProfile) {
		chiAppointment.secondPageCancel(userProfile);
        return this;
    }
	
	public CHIAppointmentAction secondPagePersonalDetails(UserProfile userProfile) {
		chiAppointment.secondPagePersonalDetails(userProfile);
        return this;
    }
	
	public CHIAppointmentAction postCodeErrorMessage(UserProfile userProfile) {
		chiAppointment.postCodeErrorMessage(userProfile);
        return this;
    }
	
	
	public CHIAppointmentAction enterPersonalDetails(UserProfile userProfile) {
		chiAppointment.enterPersonalDetails(userProfile);
        return this;
    }
	public CHIAppointmentAction verifyandConfirmAppointment() {
		chiAppointment.verifyandConfirmAppointment();
        return this;
    }
	public CHIAppointmentAction logout() {
        LegacyLoginPage legacyloginPage = new LegacyLoginPage();
        legacyloginPage.logOut();
        return this;
	}

}
