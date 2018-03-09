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
	public CHIAppointmentAction navigateToYourPropertyPage() {
		LegacyHomePage legacyHomePage = new LegacyHomePage();
		//legacyHomePage.navigateToProductsAndServicesPage();
		chiAppointment.navigateToAppointmentBookingpageNew();
		chiAppointment.navigateBookthisAppointmenPageNew();
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
	public CHIAppointmentAction enterDetailsInYourPropertyPageYes(UserProfile userProfile) {
		chiAppointment.enterDetailsInYourPropertyPageYes(userProfile);
        return this;
    }
	public CHIAppointmentAction enterDetailsInYourPropertyPageNo(UserProfile userProfile) {
		chiAppointment.enterDetailsInYourPropertyPageNo(userProfile);
        return this;
    }
	public CHIAppointmentAction enterDetailsInYourPropertyPageOAMNo() {
		chiAppointment.enterDetailsInYourPropertyPageOAMNo();
        return this;
    }
	public CHIAppointmentAction enterDetailsInYourPropertyPageOAMNyes() {
		chiAppointment.enterDetailsInYourPropertyPageOAMNyes();
        return this;
    }
	public CHIAppointmentAction verifyChooseYourAppointmentPage() {
		chiAppointment.verifyChooseYourAppointmentPage();
        return this;
    }
	public CHIAppointmentAction verifyChooseYourAppointmentPageandVerifyEditFunctionality() {
		chiAppointment.verifyChooseYourAppointmentPageandVerifyEditFunctionality();
        return this;
    }
	public CHIAppointmentAction verifyChooseYourAppointmentPageAndCancelAppointment() {
		chiAppointment.verifyChooseYourAppointmentPageAndCancelAppointment();
        return this;
    }
	public CHIAppointmentAction verifyChooseYourAppointmentPageAndVerifyBackFunctionality() {
		chiAppointment.verifyChooseYourAppointmentPageAndVerifyBackFunctionality();
        return this;
    }
	public CHIAppointmentAction verifyChooseYourAppointmentPageandVerifySlotsfor8weeks() {
		chiAppointment.verifyChooseYourAppointmentPageandVerifySlotsfor8weeks();
        return this;
    }
	public CHIAppointmentAction selectFirtAvailableAppointment() {
		chiAppointment.selectFirtAvailableAppointment();
        return this;
    }
	public CHIAppointmentAction selectAppointmentFromCalendar(String slotType,String timeSlot) {
		chiAppointment.selectAppointmentFromCalendar(slotType,timeSlot);
        return this;
    }
	public CHIAppointmentAction selectHalfDayAppointmentDay() {
		chiAppointment.selectHalfDayAppointmentDay();
        return this;
    }
	public CHIAppointmentAction verifyAppointmentSelectionCalenderFFSlot() {
		chiAppointment.verifyAppointmentSelectionCalenderFFSlot();
        return this;
    }
	public CHIAppointmentAction verifyAppointmentSelectionCalenderSecondSlot() {
		chiAppointment.verifyAppointmentSelectionCalenderSecondSlot();
        return this;
    }
	public CHIAppointmentAction verifyAppointmentSelectionCalenderThirdSlot() {
		chiAppointment.verifyAppointmentSelectionCalenderThirdSlot();
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
	public CHIAppointmentAction enterPersonalDetailsAndChangePostCode(UserProfile userProfile) {
		chiAppointment.enterPersonalDetailsAndChangePostCode(userProfile);
        return this;
    }
	public CHIAppointmentAction verifyChooseYourAppointmentPageAnonymous(UserProfile userProfile) {
		chiAppointment.verifyChooseYourAppointmentPageAnonymous(userProfile);
        return this;
    }
	public CHIAppointmentAction enterPersonalDetailsAndCancel(UserProfile userProfile) {
		chiAppointment.enterPersonalDetailsAndCancel(userProfile);
        return this;
    }
	
	public CHIAppointmentAction enterOAMPersonalDetails(UserProfile userProfile) {
		chiAppointment.enterOAMPersonalDetails(userProfile);
        return this;
    }

	public CHIAppointmentAction verifyandConfirmAppointment() {
		chiAppointment.verifyandConfirmAppointment();
        return this;
    }
	public CHIAppointmentAction verifyConfirmationPage() {
		chiAppointment.verifyConfirmationPage();
        return this;
    }
	public CHIAppointmentAction logout() {
        LegacyLoginPage legacyloginPage = new LegacyLoginPage();
        legacyloginPage.logOut();
        return this;
	}

}
