package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.action.selfServe.ASVIBAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.IBPage;
import bg.framework.app.functional.page.selfServe.ASVIBPage;

public class IBAction {

	public IBAction navigateToIdentifyFault(int intFlag) {
		new IBPage().navigateToIdentifyFault(intFlag);
		return this;
	}

	public IBAction navigatePriorityPage(int intFlag) {
		new IBPage().navigatePriorityPage(intFlag);
		return this;
	}

	public ASVIBAction navigatePriorityPageASV(int intFlag) {
		new IBPage().navigatePriorityPage(intFlag);
		return new ASVIBAction();
	}

	public BookingCompleteAction navigatePriorityPageBook(int intFlag) {
		new IBPage().navigatePriorityPage(intFlag);
		return new BookingCompleteAction();
	}

	public IBAction verifyAddress(UserProfile userProfile) {
		new IBPage().verifyAddress(userProfile);
		return this;
	}
	
	public ASVIBAction verifyAddressASVIB(UserProfile userProfile) {
		new IBPage().verifyAddress(userProfile);
		return new ASVIBAction();
	}
	
	public ASVIBAction verifyAddressIB(UserProfile userProfile) {
		new IBPage().verifyAddress(userProfile);
		return new ASVIBAction();
	}

	public IBAction verifyEmergencyMessage(int intflag) {
		new IBPage().verifyEmergencyMessage(intflag);
		return this;
	}

	public ASVIBAction verifyEmergencyMessageASV(int intflag) {
		new IBPage().verifyEmergencyMessage(intflag);
		return new ASVIBAction();
	}

	public IBAction clickFaultCategory(String strCategory) {
		new IBPage().clickFaultCategory(strCategory);
		return this;
	}

	public IBAction verifyPriorityPage(String intFlag) {
		new IBPage().verifyPriorityPage(intFlag);
		return this;
	}

	public ASVIBAction verifyPriorityPageASV(String intFlag) {
		new IBPage().verifyPriorityPage(intFlag);
		return new ASVIBAction();
	}

	public IBAction runVBS(UserProfile userProfile, String strType) {
		new IBPage().runVBS(userProfile, strType);
		return this;
	}
	public ASVIBAction runVBSASV(UserProfile userProfile, String strType) {
		new IBPage().runVBS(userProfile, strType);
		return new ASVIBAction();
	}
	
	public FastTrackAction runVBSFT(UserProfile userProfile, String strType) {
		new IBPage().runVBS(userProfile, strType);
		return new FastTrackAction();
	}

	public IBAction verifyFaultPage() {
		new IBPage().verifyFaultPage();
		return this;
	}
	
	public ASVIBAction verifyFaultPageASVIB() {
		new IBPage().verifyFaultPage();
		return new ASVIBAction();
	}

	public IBAction checkCalendarPage() {
		new IBPage().checkCalendarPage();
		return this;
	}

	public IBAction logout() {
		new AccountOverviewAction().logout();
		return this;
	}

	public IBAction clickChangeAppointment() {
		new IBPage().clickChangeAppointment();
		return this;
	}

	public IBAction clickChangeAppliance() {
		new IBPage().clickChangeAppliance();
		return this;
	}

	public IBAction navigateToReview() {

		new IBPage().navigateToReview();
		return this;
	}

	public IBAction verifyCalendarPage() {

		new IBPage().verifyCalendarPage();
		return this;
	}
	
	public ASVIBAction verifyCalendarPageASVIB() {

		new IBPage().verifyCalendarPage();
		return new ASVIBAction();
	}

	public IBAction navigateToPriority() {
		new IBPage().navigateToPriority();
		return this;
	}

	public IBAction clickFaultItemCheck() {
		new IBPage().clickFaultItemCheck();
		return this;
	}

	public IBAction selectAppointment(String strSlotType) {
		new IBPage().selectAnAppointment(strSlotType);
		return this;
	}

	public ASVIBAction selectAppointmentASV(String strSlotType) {
		new IBPage().selectAnAppointment(strSlotType);
		return new ASVIBAction();
	}

	public IBAction selectAnyAppointment() {
		new IBPage().selectAnyAppointment();
		return this;
	}

	public ASVIBAction selectAnyAppointmentASV() {
		new IBPage().selectAnyAppointment();
		return new ASVIBAction();
	}

	public IBAction verifyNoWeekendSlot(String strSlotType) {
		new IBPage().verifyNoWeekendSlot(strSlotType);
		return this;
	}

	public ASVAction selectNoAppointmentASV(String strSlotType) {
		new IBPage().selectNoAppointment(strSlotType);
		return new ASVAction();
	}

	public IBAction selectNoAppointment(String strSlotType) {
		new IBPage().selectNoAppointment(strSlotType);
		return this;
	}

	public IBAction selectAnAppointmentWeekend(String strSlotType) {
		new IBPage().selectAnAppointmentWeekend(strSlotType);
		return this;
	}

	public ASVIBAction selectAnAppointmentWeekendASV(String strSlotType) {
		new IBPage().selectAnAppointmentWeekend(strSlotType);
		return new ASVIBAction();
	}

	public IBAction selectNoSlotWeekEndBankHoliday(String strSlotType) {
		new IBPage().selectNoSlotWeekEndBankHoliday(strSlotType);
		return this;
	}

	public IBAction selectAnAppointmentWeekDay(String strSlotType) {
		new IBPage().selectAnAppointmentWeekDay(strSlotType);
		return this;
	}

	public IBAction selectAnAppointment(String strSlotType) {
		new IBPage().selectAnAppointment(strSlotType);
		return this;
	}
	
	public IBAction selectAnAppointmentReschedule(String strSlotType) {
		new IBPage().selectAnAppointmentReschedule(strSlotType);
		return this;
	}

	public ASVAction selectAnAppointmentWeekDayASV(String strSlotType) {
		new IBPage().selectAnAppointmentWeekDay(strSlotType);
		return new ASVAction();
	}

	public IBAction reviewDetailsPage() {
		new IBPage().reviewDetailsPage();
		return this;
	}

	public IBAction selectThisAppointment() {
		new IBPage().selectThisAppointment();
		return this;
	}

	public ASVIBAction reviewDetailsPageASVIB() {
		new IBPage().reviewDetailsPage();
		return new ASVIBAction();
	}

	public IBAction accountSummaryChange() {
		new IBPage().accountSummaryChange();
		return this;
	}

	public IBAction navigateToConfirmation() {
		new IBPage().navigateToConfirmation();
		return this;
	}

	public BookingCompleteAction navigateToConfirmationBooking() {
		new IBPage().navigateToConfirmation();
		return new BookingCompleteAction();
	}

	public ASVIBAction navigateToConfirmationASV() {
		new IBPage().navigateToConfirmation();
		return new ASVIBAction();
	}

	public IBAction verifyConfirmationPage() {
		new IBPage().verifyConfirmationPage();
		return this;
	}
	
	public ASVIBAction verifyConfirmationPageASV() {
		new IBPage().verifyConfirmationPage();
		return new ASVIBAction();
	}

	public IBAction changeAppointment(int intOption) {
		new IBPage().changeAppointment(intOption);
		return this;
	}

	public IBAction checkBothAppointments(String strApp1, String strApp2) {
		new IBPage().checkBothAppointments(strApp1, strApp2);
		return this;
	}

	public BookingCompleteAction navigateToAccountSummary2(
			UserProfile userProfile) {
		new IBPage().navigateToAccountSummary2(userProfile);
		return new BookingCompleteAction();
	}

	public IBAction addCOD(UserProfile userProfile) {
		new ASVIBPage().addCOD(userProfile);
		return this;
	}

	public ASVIBAction addCODASVIB(UserProfile userProfile) {
		new ASVIBPage().addCOD(userProfile);
		return new ASVIBAction();
	}

	public IBAction addGAC() {
		new ASVIBPage().addGAC();
		return this;
	}

	public IBAction clickGAC() {
		new ASVIBPage().clickGAC();
		return this;
	}

	public IBAction verifyLinkNavigation(String strType) {
		new IBPage().verifyLinkNavigation(strType);
		return this;
	}

	public IBAction navigateBack() {
		new IBPage().navigateBack();
		return this;
	}

	public IBAction selectFirstAvailableSlot() {
		new IBPage().selectFirstAvailableSlot();
		return this;
	}

	public ASVIBAction verifyEmailConfirmation(UserProfile userProfile,
			String strTransactionType) {
		new IBPage().verifyEmailConfirmation(userProfile, strTransactionType);
		return new ASVIBAction();
	}

	public IBAction verifyEmailConfirmationIB(UserProfile userProfile,
			String strTransactionType) {
		new IBPage().verifyEmailConfirmation(userProfile, strTransactionType);
		return new IBAction();
	}
	
	public IBAction testHornors() {
		new IBPage().testHornors();
		return new IBAction();
	}

	public IBAction verifySlot(String strSlotType)
	{
		new IBPage().verifySlot(strSlotType);
		return new IBAction();
	}
	
	public ASVIBAction verifySlotASVIB(String strSlotType)
	{
		new IBPage().verifySlot(strSlotType);
		return new ASVIBAction();
	}
	
	public ASVAction verifySlotASV(String strSlotType)
	{
		new IBPage().verifySlot(strSlotType);
		return new ASVAction();
	}
	public BookingCompleteAction verifySlotBook(String strSlotType)
	{
		new IBPage().verifySlot(strSlotType);
		return new BookingCompleteAction();
	}
}
