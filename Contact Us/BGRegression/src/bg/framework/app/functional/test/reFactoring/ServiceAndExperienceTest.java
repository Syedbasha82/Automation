	package bg.framework.app.functional.test.reFactoring;

import static bg.framework.app.functional.entities.FunctionalCategory.ASVIB;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;

import java.util.ArrayList;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.reFactoring.FastTrackAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.GlobalErrorMessages;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class ServiceAndExperienceTest extends TestBase{


	/*
	 * IB Journey combined with Booked IB - Keep appointment
	 * 
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingStd() 
	{
		Report.createTestLogHeader("Booking Complete -IB combined with Booked IB Journey Test - Keep slots",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
				"ideal").verifyAddressBook(userProfile).bookAnEngineerIB(userProfile, "IV")
				.verifyAddress(userProfile).navigateToIdentifyFault(1,userProfile)
				.navigatePriorityPage(0).verifyAddressSAE(userProfile).selectSlotType("Std")
				.selectAnAppointmentStdIB("AllDay").verifyAddress(userProfile)
				.reviewDetailsPage(userProfile).navigateToConfirmation()
				.verifyAddressBook(userProfile).navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();
	}
	
	@Test(groups = { ASVIB, Regression })
	public void ibBookingStdError() {
		Report.createTestLogHeader(
						"Booking Complete -IB combined with Booked IB Journey Test - Keep slots ",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");
		ArrayList<String> errList= new HomePageAction().navigateToCQ5List(GlobalErrorMessages.ReFactoring_ASV_IB_ErrorCode);
		
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
				"ideal").verifyAddressBook(userProfile).bookAnEngineerIB(userProfile, "IV")
				.verifyAddress(userProfile).navigateToIdentifyFault(1,userProfile)
				.navigatePriorityPage(0).verifyAddressSAE(userProfile).selectSlotType("Std")
				.selectAnAppointmentStdIB("AllDay").verifyAddress(userProfile).verifyErrorReviewPage(userProfile, errList);
	}

	/*
	 * ------------------------------------------------------------------------------------Book A BreakDown Test Cases
	 */
	
	/*
	 * *****************BookABreakDown_TC_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibVerifyChangeAppointment() {
		Report.createTestLogHeader(
						"Book A Breakdown -IB Journey Test to verify Change Appointment Link",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");
		
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(1,userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("AM").reviewDetailsPage(userProfile).verifySlot("AM")
		.clickChangeAppointment().verifyAddressSAE(userProfile).verifyCalendarPage().logout();
	}
	
	/*
	 * *****************BookABreakDown_TC_02*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibVerifyChangeAppliance() {
		Report.createTestLogHeader(
						"Book A Breakdown -IB Journey Test to verify Change Appliance Link",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");
		
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(1,userProfile)
		.navigatePriorityPage(0).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPage().clickChangeAppliance()		
		.verifyFaultPage().logout();
	}
	
	/*
	 * *****************BookABreakDown_TC_03*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibFirstAvailableHalfDay() {
		
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to select First Available Standard slot from calendar Page and Add GAC",
				"HomeSerivcesAccount");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");	
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(1,userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectFirstAvailableStdIB().verifyAddress(userProfile)
		.reviewDetailsPage(userProfile).addGAC().navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().accountSummarycancelAppointment()
		.logout();
	}
	
	/*
	 * *****************BookABreakDown_TC_04*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibPreferenceSlot() {
		Report.createTestLogHeader(
						"Book A Breakdown -IB Journey Test to select a Evening slot",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");
		
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(1,userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("EVE")
		.verifyAddress(userProfile)	.reviewDetailsPage(userProfile)
		.verifySlot("EVE").addGAC().navigateToConfirmation().verifySlot("EVE")
		.confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange().verifySlotASVIB("EVE")
		.accountSummarycancelAppointment().logout();
	}
	
	/*
	 * *****************BookABreakDown_TC_05*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibFirstAvailableStandardSlots() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to select First Available 2 Hour slot from calendar Page and Add GAC",
				"HomeSerivcesAccount");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(1,userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectFirstAvailable2HrIB().verifyAddress(userProfile)
		.reviewDetailsPage(userProfile).addGAC().navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummarycancelAppointment()
		.logout();
	}
	
	/*
	 * ----------------------------------------------------------------------------------End Of Book A BreakDown Test Cases
	 */
	
	
	

	/*
	 * ----------------------------------------------------------------------------------Book A BreakDown BS2 Test Cases
	 */
	
	/*
	 * *****************BookABreakDownBS2_TC_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibVerifyChangeAppointmentBS2() {
		Report.createTestLogHeader(
						"Book A Breakdown -IB Journey Test to verify Change Appointment Link",
						"HomeCare400Account");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");
		
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(1,userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("EVE").reviewDetailsPage(userProfile).verifySlot("EVE")
		.clickChangeAppointment().verifyAddressSAE(userProfile).verifyCalendarPage().logout();
	}
		
	/*
	 * *****************BookABreakDownBS2_TC_02*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibFirstAvailableHalfDayBS2() {
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to select First Available Standard slot from calendar Page and Add GAC BS2",
				"HomeSerivcesAccount");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
.verifyAddressBook(userProfile)
.firstAvailableSlot(userProfile)
.bookAnEngineerIB(userProfile, "IV")
.verifyAddress(userProfile)
.navigateToIdentifyFault(1,userProfile)
.navigatePriorityPage(1).verifyAddress(userProfile)
.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
.verifyCalendarPageSAE().selectFirstAvailableStdIB().verifyAddress(userProfile)
.reviewDetailsPage(userProfile).addGAC().navigateToConfirmation().confirmationTotalChk(userProfile)
.verifyAddressASVIB(userProfile).navigateTrackCancelChange().accountSummarycancelAppointment()
.logout();
	}
	
	/*
	 * *****************BookABreakDownBS2_TC_03*****************
	 */
	/*
	 * Book a breakdown using Evening slot and Change to Alloc status
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibPreferenceSlotALLOC() {
		Report.createTestLogHeader(
						"Book A Breakdown -IB Journey Test to select a Evening slot",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");
		
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("ALLOC").verifyAccountOverview("Ideal")
		.verifyAddressIB(userProfile).verifySlot("AllDay")		
		.logout();
	}
	
	/*
	 * *****************BookABreakDownBS2_TC_04*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibFirstAvailableStandardSlotsBS2() {
	
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to select First Available 2 Hour slot from calendar Page and Add GAC",
				"HomeCare400Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
.verifyAddressBook(userProfile)
.firstAvailableSlot(userProfile)
.bookAnEngineerIB(userProfile, "IV")
.verifyAddress(userProfile)
.navigateToIdentifyFault(1,userProfile)
.navigatePriorityPage(1).verifyAddress(userProfile)
.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
.verifyCalendarPageSAE().selectFirstAvailable2HrIB().verifyAddress(userProfile)
.reviewDetailsPage(userProfile).addGAC().navigateToConfirmation().confirmationTotalChk(userProfile)
.verifyAddressASVIB(userProfile).navigateTrackCancelChange().accountSummarycancelAppointment()
.logout();
	}
	
	/*
	 * ----------------------------------------------------------------------------------End Of Book A BreakDown BS2 Test Cases
	 */
	
	
	
	
	
	 /*
	  * ---------------------------------------------------------------------------------Book A BreakDown Excess Test Cases
	  */
	
	/*
	 * *****************ExcessBreakdown_TC_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibVerifyChangeAppointmentExcess() {
		Report.createTestLogHeader(
						"Book A Breakdown -IB Journey Test to verify Change Appointment Link for Excess Account",
						"HomeCare100Account");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");
		
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(1,userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("AM").reviewDetailsPage(userProfile).verifySlot("AM")
		.clickChangeAppointment().verifyAddressSAE(userProfile).verifyCalendarPage().logout();
	}

	/*
	 * *****************ExcessBreakdown_TC_02*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibVerifyErrorMessage() {
		Report.createTestLogHeader(
						"Book A Breakdown -IB Journey Test to verify error message for Excess Account when HC is turned off",
						"HomeCare100Account");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");
		ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.ReFactoring_ASV_IB_ErrorCode);
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		.verifyAddressSAE(userProfile)
		.verifyErrorMessage(errList)
		.logout();
	}

	/*
	 * *****************ExcessBreakdown_TC_04*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibPreferenceSlotExcess() {
		Report.createTestLogHeader(
						"Book A Breakdown -IB Journey Test to select a Evening slot for Excess Account",
						"HomeCare300Account");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");
		
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(1,userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("FF").verifyAddress(userProfile)
		.reviewDetailsPage(userProfile).verifySlot("FF").addGAC().navigateToConfirmation()
		.verifySlot("FF").confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().verifySlotASVIB("FF")
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * ----------------------------------------------------------------------------------End Of Book A BreakDown Excess Test Cases
	 */
	
	
	
	

	 /*
	  * ---------------------------------------------------------------------------------Book An ASV Test Cases
	  */
	
	/*
	 * *****************BookAnAsv_TC_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvVerifyChangeAppointmentASV() {
		Report.createTestLogHeader(
						"Book An ASV -ASV Journey Test to verify Change Appointment Link for Excess Account",
						"HomeCare100Account");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");
		
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointmentsIB()
		.verifyAddress(userProfile)
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("AM").reviewDetailsPage(userProfile).verifySlot("AM")
		.clickChangeAppointment().verifyAddressSAE(userProfile).verifyCalendarPage().logout();
	}

	/*
	 * *****************BookAnAsv_TC_02*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvFirstStdSlot() {
		Report.createTestLogHeader(
						"Book An ASV -ASV Journey Test to select First Available Standard Slot",
						"HomeCare300Account");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");
		
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressSAE(userProfile)
		.navigateToASVStdSlotIB(userProfile)
		.verifyAddress(userProfile)
		.reviewDetailsPage(userProfile).addGAC().addCOD(userProfile)
		.verifyAddress(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}
	
	/*
	 * *****************BookAnAsv_TC_03*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvFirst2HrSlot() {
		Report.createTestLogHeader(
						"Book An ASV -ASV Journey Test to select First Available 2 Hour Slot",
						"HomeCare100Account");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");
		
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressSAE(userProfile)
		.navigateToASV2HrSlotIB(userProfile)
		.verifyAddress(userProfile)
		.reviewDetailsPage(userProfile).addCOD(userProfile)
		.verifyAddress(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	* *****************BookAnAsv_TC_06*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvFirstStdCalendar() {
		Report.createTestLogHeader(
						"Book An ASV -ASV Journey Test to select first available standard slot from calendar",
						"HomeCare100Account");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");
		
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointmentsIB()
		.verifyAddress(userProfile)
		.verifyAddressSAE(userProfile)
		.selectFirstAvailableStdIB().reviewDetailsPage(userProfile).verifySlot("AM")
		.clickChangeAppointment().verifyAddressSAE(userProfile).verifyCalendarPage().logout();
	}
	
	/*
	* *****************BookAnAsv_TC_07*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvFirst2HrCalendar() {
		Report.createTestLogHeader(
				"Book An ASV -ASV Journey Test to select first available 2 Hour slot from calendar",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
.verifyAddressBook(userProfile)
.firstAvailableSlot(userProfile)
.navigateToViewAllAppointmentsIB()
.verifyAddress(userProfile)
.verifyAddressSAE(userProfile)
.selectFirstAvailableStdIB().reviewDetailsPage(userProfile).verifySlot("AM")
.clickChangeAppointment().verifyAddressSAE(userProfile).verifyCalendarPage().logout();
	}
	
	/*
	 * ------------------------------------------------------------------------------------End Of Book An ASV s Test Cases
	 */
	
	
	
	
	
	/*
	 * ------------------------------------------------------------------------------------Cancel ASV Test Cases
	 */

	/*
	 * *****************CancelASV_TC_02*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvCancelViewDetail() {
		Report.createTestLogHeader(
				"Cancel An ASV -Cancel ASV Journey Test to cancel from view  detail",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

	new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointmentsIB()
		.verifyAddress(userProfile)
		.verifyAddressSAE(userProfile)
		.selectFirstAvailableStdIB().reviewDetailsPage(userProfile).navigateToConfirmationASV()
		.navigateTrackCancelChange()
		.viewDetails().accountSummaryChangeAppointment()
		.verifyAddressIBPage(userProfile)
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrIB("8to10")
		.reviewDetailsPage(userProfile)
		.navigateToConfirmationASV()
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}
	
	/*
	 * ------------------------------------------------------------------------------------End of Cancel ASV Test Cases
	 */
	
	
	
	
	/*
	 * ------------------------------------------------------------------------------------Combining ASV + IB Test Cases
	 */

	/*
	 * *****************CombiningASV-Breakdown_TC_02*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvIbcombineVerifyChangeAppointment() {
		Report.createTestLogHeader(
				"Combining -Combining ASV  and IB Journey Test to verify change appointment link",
				"HomeCare300Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare300Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointment2HrIB("10to12").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressBook(userProfile)
.bookAnEngineerIB(userProfile, "ASV")
.changeAppointmentSAE(2)
.selectAnAppointment2HrIB("10to12")
.reviewDetailsPage(userProfile)
.clickChangeAppointment()
.verifyCalendarPageSAE().selectAnAppointment2HrIB("10to12").reviewDetailsPage(userProfile).navigateToConfirmationASV()
.navigateTrackCancelChange().accountSummarycancelAppointment().logout();
	}
	
	
	/*
	 * *****************CombiningASV-Breakdown_TC_03*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvIbcombineFirst2HrSlot() {
		Report.createTestLogHeader(
				"Combining -Combining ASV  and IB Journey Test to comibine 2Hr slots from calendar",
				"HomeCare200Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV()
.verifyAccountOverview("Ideal")
.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointment2HrIB("10to12").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressBook(userProfile)
.bookAnEngineerIB(userProfile, "ASV")
.changeAppointmentSAE(2)
.selectFirstAvailable2HrIB()
.reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange().accountSummarycancelAppointment().logout();
	}
	
	
	/*
	 * *****************CombiningASV-Breakdown_TC_04*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvIbcombineFirstStdSlot() {
		Report.createTestLogHeader(
				"Combining -Combining ASV  and IB Journey Test to comibine Standard slots from calendar",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointment2HrIB("10to12").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressBook(userProfile)
.bookAnEngineerIB(userProfile, "ASV")
.changeAppointmentSAE(2)
.selectFirstAvailable2HrIB()
.reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange().accountSummarycancelAppointment().logout();
	}
	
	
	/*
	 * *****************CombiningASV-Breakdown_TC_05*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvIbcombineAlldaySlot() {
		Report.createTestLogHeader(
				"Combining -Combining ASV  and IB Journey Test to comibine All day from calendar",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointment2HrIB("10to12").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressBook(userProfile)
.bookAnEngineerIB(userProfile, "ASV")
.changeAppointmentSAE(2)
.selectAnAppointmentStdIB("AllDay")
.reviewDetailsPage(userProfile).verifyAddress(userProfile).verifySlot("AllDay")
.navigateToConfirmationASV()
.navigateTrackCancelChange().accountSummarycancelAppointment().logout();
	}
	/*
	 * -----------------------------------------------------------------------------------End of Combining ASV + IB Test Cases
	 */
	
	
	
	/*
	* ------------------------------------------------------------------------------------Combining IB + IB BS1 Test Cases
	 */

	/*
	 * *****************CombiningBreakdownBS1_TC_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibIbcombineVerifyChangeAppointmentBS1() {
		Report.createTestLogHeader(
				"Combining -Combining IB  and IB Journey Test to verify change appointment link",
				"HomeCare200Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointment2HrIB("10to12").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressBook(userProfile)
.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddress(userProfile)
.changeAppointmentSAE(2)
.selectAnAppointment2HrIB("10to12")
.reviewDetailsPage(userProfile)
.clickChangeAppointment()
.verifyCalendarPageSAE().selectAnAppointment2HrIB("10to12").reviewDetailsPage(userProfile).navigateToConfirmationASV()
.navigateTrackCancelChange().accountSummarycancelAppointment().logout();
	}
	
	
	/*
	 * *****************CombiningBreakdownBS1_TC_03*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibIbcombineDiffAppointmentBS1() {
		Report.createTestLogHeader(
				"Combining -Combining IB  and IB Journey Test to choose new Appointment",
				"HomeCare200Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("AM").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressBook(userProfile)
.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddress(userProfile)
.changeAppointmentSAE(2)
.selectAnAppointmentStdIB("EVE")
.reviewDetailsPage(userProfile)
.clickChangeAppointment()
.verifyCalendarPageSAE().selectAnAppointment2HrIB("10to12").reviewDetailsPage(userProfile).navigateToConfirmationASV()
.navigateTrackCancelChange().accountSummarycancelAppointment().logout();
	}
	
	
	/*
	 * *****************CombiningBreakdownBS1_TC_04*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibIbcombineKeepAppointmentBS1() {
		Report.createTestLogHeader(
				"Combining -Combining IB  and IB Journey Test to Keep Appointment",
				"HomeCare200Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("EVE").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressBook(userProfile)
.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddress(userProfile)
.changeAppointment(1)
.reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange().accountSummarycancelAppointment().logout();
	}
	
	/*
	* -----------------------------------------------------------------------------------End of Combining IB + IB BS1 Test Cases
	 */
	
	
	

	/*
	* -----------------------------------------------------------------------------------Combining IB + IB BS2 Test Cases
	 */

	/*
	 * *****************CombiningBreakdownBS2_TC_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibIbcombineVerifyChangeAppointmentBS2() {
		Report.createTestLogHeader(
				"Combining -Combining IB  and IB Journey Test to verify change appointment link",
				"HomeCare400Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("AllDay").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressBook(userProfile)
.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddress(userProfile)
.changeAppointmentSAE(2)
.selectAnAppointmentStdIB("AllDay")
.reviewDetailsPage(userProfile)
.clickChangeAppointment()
.verifyCalendarPageSAE().selectAnAppointment2HrIB("10to12").reviewDetailsPage(userProfile).navigateToConfirmationASV()
.navigateTrackCancelChange().accountSummarycancelAppointment().logout();
	}
	
	/*
	 * *****************CombiningBreakdownBS2_TC_03*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibIbcombineKeepAppointmentBS2() {
		Report.createTestLogHeader(
				"Combining -Combining IB  and IB Journey Test to Keep Appointment",
				"HomeCare400Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("EVE").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressBook(userProfile)
.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddress(userProfile)
.changeAppointment(1)
.reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange().accountSummarycancelAppointment().logout();
	}
	
	/*
	* ------------------------------------------------------------------------------------End of Combining IB + IB BS2 Test Cases
	 */
	
	
	/*
	* ------------------------------------------------------------------------------------FastTrack Test Cases
	 */
	
	/*
	 * *****************FastTrack_TC_01*****************
	 */
	public void fastTrackBookingComplete()
	{
		Report.createTestLogHeader("FastTrack Journey Test", "HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("FastTrackASV");
		
		
		
		new FastTrackAction()
		.fastTrackASVLogin(userProfile).verifyAddress(userProfile)
		.fastTrackConfirmAddressDetailsSAE(userProfile)
		.selectAnAppointmentStdFastTrack("AM").verifyAddress(userProfile)
		.fastTrackReviewPageDetailsAC(userProfile)
		.fastTrackNavigateToConfirmation().verifyAddress(userProfile)
		.fastTrackConfirmationPageAsv();
	}
	
	/*
	 * *****************FastTrack_TC_02*****************
	 */
	public void fastTrackBookingCompleteCODGAC()
	{
		Report.createTestLogHeader("FastTrack Journey Test with COD & GAC", "HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("FastTrackASV");
		
		
		
		new FastTrackAction()
		.fastTrackASVLogin(userProfile).verifyAddress(userProfile)
		.fastTrackConfirmAddressDetailsSAE(userProfile)
		.selectAnAppointmentStdFastTrack("FF").verifyAddress(userProfile)
		.fastTrackReviewPageDetailsAC(userProfile).addGAC().addCOD(userProfile).verifyAddress(userProfile)
		.fastTrackConfirmationPageAsv();
	}

	/*
	 * *****************FastTrack_TC_03*****************
	 */
	public void fastTrackBookingCompleteGAC()
	{
		Report.createTestLogHeader("FastTrack Journey Test with GAC", "HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("FastTrackASV");
		
		
		
		new FastTrackAction()
		.fastTrackASVLogin(userProfile).verifyAddress(userProfile)
		.fastTrackConfirmAddressDetailsSAE(userProfile)
		.selectAnAppointmentStdFastTrack("FF").verifyAddress(userProfile)
		.fastTrackReviewPageDetailsAC(userProfile).addCOD(userProfile).verifyAddress(userProfile)
		.fastTrackConfirmationPageAsv();
	}
	
	/*
	* *****************FastTrack_TC_04*****************
	 */
	public void fastTrackBookedError()
	{
		Report.createTestLogHeader("FastTrack Journey Test with already booked ASV", "HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("FastTrackASV");
		
		new FastTrackAction()
		.fastTrackASVLogin(userProfile).verifyAddress(userProfile)
		.fastTrackConfirmAddressDetails(userProfile)
		.verifyAddress(userProfile)
		.verifyBookedSlotPage()
		.fastTrackConfirmationPageAsv();
	}

	
	/*
	* *****************FastTrack_TC_05*****************
	 */
	public void fastTrackNA2Error()
	{
		Report.createTestLogHeader("FastTrack Journey Test with NA2 Status", "HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("FastTrackASV");
		
		new FastTrackAction()
		.fastTrackASVLogin(userProfile)
		.fastTrackConfirmAddressDetails(userProfile)	
		.verifyNA2Message();
	}

	
	/*
	 * *****************FastTrack_TC_07*****************
	 */
	public void fastTrackReschedule()
	{
		Report.createTestLogHeader("FastTrack Journey Test Reschedule", "HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("FastTrackASV");
		
		
		
		new FastTrackAction()
		.fastTrackASVLogin(userProfile).verifyAddress(userProfile)
		.fastTrackConfirmAddressDetailsSAE(userProfile)
		.selectAnAppointmentStdFastTrack("FF").verifyAddress(userProfile)
		.fastTrackReviewPageDetailsAC(userProfile).addCOD(userProfile).verifyAddress(userProfile)
		.fastTrackConfirmationPageAsv();
		
		new HomePageAction()
		.navigateToLoginPage()		
		.loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAddressASV(userProfile).viewDetails().accountSummaryChangeAppointmentIB()
.verifyAddressSAE(userProfile).selectAnAppointmentStdIB("AM").reviewDetailsPage(userProfile).navigateToConfirmationASV()
.accountOverviewBookAnEngineer().accountSummarycancelAppointment().logout();

	}

	/*
	 * *****************FastTrack_TC_08*****************
	 */
	public void fastTrackCancel()
	{
		Report.createTestLogHeader("FastTrack Journey Test Cacnel online", "HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("FastTrackASV");
		
		
		
		new FastTrackAction()
		.fastTrackASVLogin(userProfile).verifyAddress(userProfile)
		.fastTrackConfirmAddressDetailsSAE(userProfile)
		.selectAnAppointmentStdFastTrack("FF").verifyAddress(userProfile)
		.fastTrackReviewPageDetailsAC(userProfile).fastTrackConfirmationPage()
		.verifyAddress(userProfile)
		.fastTrackConfirmationPageAsv();
		
		new HomePageAction()
		.navigateToLoginPage()		
		.loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().accountSummarycancelAppointment().logout();
	}

	 
	/*
	 * *****************FastTrack_TC_09*****************
	 */
	public void fastTrackNoEve()
	{
		Report.createTestLogHeader("FastTrack Journey Test to verify No Eve Slot", "HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("FastTrackASV");

		new FastTrackAction()
		.fastTrackASVLogin(userProfile)
		.fastTrackConfirmAddressDetailsSAE(userProfile)
		.selectNoAppointment("EVE")
		;		
		
	}

	/*
	
	/*
	 * *****************FastTrack_TC_14*****************
	 */
	public void fastTrackView()
	{
		Report.createTestLogHeader("FastTrack Journey Test view Detail", "HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("FastTrackASV");
		
		
		
		new FastTrackAction()
		.fastTrackASVLogin(userProfile).verifyAddress(userProfile)
		.fastTrackConfirmAddressDetailsSAE(userProfile)
		.selectAnAppointmentStdFastTrack("FF").verifyAddress(userProfile)
		.fastTrackReviewPageDetailsAC(userProfile).fastTrackConfirmationPage().verifyAddress(userProfile)
		.fastTrackConfirmationPageAsv();
		
		new HomePageAction()
		.navigateToLoginPage()		
		.loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().viewDetailsCompletePage(userProfile);
	}
	/*
	 * ------------------------------------------------------------------------------------End Of FastTrack Test Cases
	 */
	
	
	
	

	/*
	* ------------------------------------------------------------------------------------Reschedule ASV Test Cases
	 */
	
	/*
	* *****************RescheduleASV_TC_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvRescheduleChangeAppointment() {
		Report.createTestLogHeader(
						"verify change appointment link from status",
						"HomeCare100Account");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");
		
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointmentsIB()
		.verifyAddress(userProfile)
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("AM")
		.reviewDetailsPage(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyConfirmationPage().verifyAddressASVIB(userProfile).navigateTrackCancelChange().accountSummaryChangeAppointmentIB()
		.verifyCalendarPage().logout();
	}
	
	/*
	* *****************RescheduleASV_TC_02	*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvRescheduleChangeAppointmentReview() {
		Report.createTestLogHeader(
						"verify change appointment link from Review",
						"HomeCare100Account");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");
		
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointmentsIB()
		.verifyAddress(userProfile)
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("PM")
		.reviewDetailsPage(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyConfirmationPage().verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentSAE().selectAnAppointmentStdIB("PM").reviewDetailsPage(userProfile).clickChangeAppointment()
		.verifyCalendarPage().logout();
	}
	
	/*
	* *****************RescheduleASV_TC_04	*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvRescheduleFirstAvailaleSlot() {
		Report.createTestLogHeader(
						"Reschedule FF booked ASV by First Available slot",
						"HomeCare100Account");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");
		
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointmentsIB()
		.verifyAddress(userProfile)
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("PM")
		.reviewDetailsPage(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyConfirmationPage().verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentSAE().selectFirstAvailable2HrIB().reviewDetailsPage(userProfile)
		.navigateToConfirmationASV().navigateTrackCancelChange().accountSummarycancelAppointment().logout();
	}
	
	/*
	* *****************RescheduleASV_TC_05	*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvReschedule2HrSlot() {
		Report.createTestLogHeader(
						"Reschedule by 2Hr slot",
						"HomeCare100Account");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare200Account");
		
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointmentsIB()
		.verifyAddress(userProfile)
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("PM")
		.reviewDetailsPage(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyConfirmationPage().verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentSAE().selectAnAppointment2HrIB("12to2").reviewDetailsPage(userProfile)
		.navigateToConfirmationASV().navigateTrackCancelChange().accountSummarycancelAppointment().logout();
	}
	
	/*
	* ------------------------------------------------------------------------------------End Of Reschedule ASV Test Cases
	 */
	


	/*
	* ------------------------------------------------------------------------------------Reschedule IB BS1 Test Cases
	 */

	/*
	 * *****************RescheduleBreakdown_TC_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibRescheduleVerifyChangeAppointmentBS1() {
		Report.createTestLogHeader(
				"Rescheduling IB and check change appointment link from review page",
				"HomeCare300Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare300Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("PM").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressASVIB(userProfile)
.viewDetails()
.accountSummaryChangeAppointmentIB()
.navigatePriorityPageSAE(5)
.selectAnAppointmentStdIB("PM")
.reviewDetailsPage(userProfile)
.clickChangeAppointment()
.verifyCalendarPageSAE()
.selectAnAppointmentStdIB("PM")
.reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange().accountSummarycancelAppointment().logout();
	}
	
	/*
	 * *****************RescheduleBreakdown_TC_02*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibRescheduleFirst2HrSlot() {
		Report.createTestLogHeader(
				"Rescheduling IB using First Available 2 Hour Slot",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("EVE").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.viewDetails()
.accountSummaryChangeAppointmentIB()
.navigatePriorityPageSAE(1)
.selectFirstAvailable2HrIB()
.reviewDetailsPage(userProfile)
.clickChangeAppointment()
.verifyCalendarPageSAE()
.selectFirstAvailable2HrIB()
.reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange().accountSummarycancelAppointment().logout();
	}
	
	/*
	 * *****************RescheduleBreakdown_TC_04*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibRescheduleFirstStdSlot() {
		Report.createTestLogHeader(
				"Rescheduling IB using First Available Standard Slot",
				"HomeCare200Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("EVE").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.viewDetails()
.accountSummaryChangeAppointmentIB()
.navigatePriorityPageSAE(1)
.selectFirstAvailableStdIB()
.reviewDetailsPage(userProfile)
.clickChangeAppointment()
.reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange().accountSummarycancelAppointment().logout();
	}
	/*
	* ------------------------------------------------------------------------------------End Of Reschedule IB BS1 Test Cases
	 */
	

	
	
	/*
	* ------------------------------------------------------------------------------------Reschedule IB BS2 Test Cases
	 */

	/*
	 * *****************RescheduleBreakdown_TC_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibRescheduleVerifyChangeAppointmentBS2() {
		Report.createTestLogHeader(
				"Rescheduling IB and check change appointment link from review page",
				"HomeCare400Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("PM").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressASVIB(userProfile)
.viewDetails()
.accountSummaryChangeAppointmentIB()
.navigatePriorityPageSAE(5)
.selectAnAppointmentStdIB("PM")
.reviewDetailsPage(userProfile)
.clickChangeAppointment()
.verifyCalendarPageSAE()
.selectAnAppointmentStdIB("PM")
.reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange().accountSummarycancelAppointment().logout();
	}
	
	/*
	 * *****************RescheduleBreakdown_TC_02*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibReschedule2HrSlotBS2() {
		Report.createTestLogHeader(
				"Rescheduling IB using 10to12 2 Hour Slot",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("EVE").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.viewDetails()
.accountSummaryChangeAppointmentIB()
.navigatePriorityPageSAE(0)
.selectAnAppointment2HrIB("8to10")
.reviewDetailsPage(userProfile)
.clickChangeAppointment()
.verifyCalendarPageSAE()
.selectAnAppointment2HrIB("10to12")
.reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange().accountSummarycancelAppointment().logout();
	}
	
	/*
	* ------------------------------------------------------------------------------------End Of Reschedule IB BS2 Test Cases
	 */
	
	
	

	/*
	* ------------------------------------------------------------------------------------2 Hour Slot Test Cases
	 */

	/*
	 * *****************2HR_TC_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ib2HrSlot8to10Yes(){
		Report.createTestLogHeader(
				"Book IB using 8to10 2 Hour Slot with priority",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddressSAE(userProfile)
.selectAnAppointment2HrIB("8to10").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}

	/*
	 * *****************2HR_TC_02*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ib2HrSlot8to10No(){
		Report.createTestLogHeader(
				"Book IB using 8to10 2 Hour Slot without priority",
				"HomeCare200Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointment2HrIB("8to10").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}

	/*
	 * *****************2HR_TC_03*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ib2HrSlot10to12Yes(){
		Report.createTestLogHeader(
				"Book IB using 10to12 2 Hour Slot with priority",
				"HomeCare300Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare300Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddressSAE(userProfile)
.selectAnAppointment2HrIB("10to12").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}
	

	/*
	 * *****************2HR_TC_04*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ib2HrSlot10to12No(){
		Report.createTestLogHeader(
				"Book IB using 10to12 2 Hour Slot without priority",
				"HomeCare400Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointment2HrIB("10to12").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}
	
	/*
	 * *****************2HR_TC_05*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ib2HrSlot12to2Yes(){
		Report.createTestLogHeader(
				"Book IB using 12 - 2 2 Hour Slot with priority",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddressSAE(userProfile)
.selectAnAppointment2HrIB("12to2").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}

	/*
	 * *****************2HR_TC_06*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ib2HrSlot12to2No(){
		Report.createTestLogHeader(
				"Book IB using 12to2 2 Hour Slot without priority",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointment2HrIB("12to2").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}

	/*
	 * *****************2HR_TC_07*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ib2HrSlot2to4Yes(){
		Report.createTestLogHeader(
				"Book IB using 2 - 4 2 Hour Slot with priority",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddressSAE(userProfile)
.selectAnAppointment2HrIB("2to4").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}

	/*
	 * *****************2HR_TC_08*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ib2HrSlot2to4No(){
		Report.createTestLogHeader(
				"Book IB using 2to4 2 Hour Slot without priority",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointment2HrIB("2to4").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}

	/*
	 * *****************2HR_TC_09*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ib2HrSlot4to6Yes(){
		Report.createTestLogHeader(
				"Book IB using 4-6 2 Hour Slot with priority",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddressSAE(userProfile)
.selectAnAppointment2HrIB("4to6").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}

	/*
	 * *****************2HR_TC_13*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ib2HrSlot6to8YesWeekend(){
		Report.createTestLogHeader(
				"Book IB using 6to8 2 Hour Slot with priority",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddressSAE(userProfile)
.selectAnAppointment2HrIB("6to8").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}

	/*
	 * *****************2HR_TC_15*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ib2HrSlot6to8YesWeekendYes(){
		Report.createTestLogHeader(
				"Book IB using 6to8 2 Hour Slot with priority",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddressSAE(userProfile)
.selectAnAppointment2HrWeekend("6to8").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}
	
	/*
	 * *****************2HR_TC_16*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ib2HrSlot6to8YesWeekendNo(){
		Report.createTestLogHeader(
				"Book IB using 6to8 2 Hour Slot without priority",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointment2HrWeekend("6to8").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}
	/*
	* ------------------------------------------------------------------------------------End Of 2 Hour Slot Test Cases
	 */
	
	

	/*
	* ------------------------------------------------------------------------------------AllDay Slot Test Cases
	 */

	/*
	 * *****************ALLDAY Slot_TC_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibAlldaySlotYes(){
		Report.createTestLogHeader(
				"Book IB using All Day Slot with priority",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("AllDay").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}
	
	/*
	 * *****************ALLDAY Slot_TC_02*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibAlldaySlotNo(){
		Report.createTestLogHeader(
				"Book IB using All Day Slot without priority",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("AllDay").reviewDetailsPage(userProfile).addGAC()
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}
	
	/*
	 * *****************ALLDAY Slot_TC_03*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibAlldaySlotYesWeekend(){
		Report.createTestLogHeader(
				"Book IB using All Day Slot with priority on weekend",
				"HomeCare400Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.clickFaultCategory("Electric", userProfile)
.navigatePriorityPage(1)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdWeekend("AllDay").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}

	/*
	 * *****************ALLDAY Slot_TC_04*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibAlldaySlotYesWeekendKAC(){
		Report.createTestLogHeader(
				"Book IB using All Day Slot with priority on weekend for KAC",
				"HomeCare400Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.clickFaultCategory("Electric", userProfile)
.navigatePriorityPage(1)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdWeekend("AllDay").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}
	
	/*
	 * *****************ALLDAY Slot_TC_06*****************
	 * Bank Holiday should be on the last row of slot table and All day
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibAlldaySlotYesBankHoliday(){
		Report.createTestLogHeader(
				"Book IB using All Day Slot with priority on Bank Holiday",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("AllDay").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}
	
	/*
	 * *****************ALLDAY Slot_TC_08*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibIBAlldaySlotNo(){
		Report.createTestLogHeader(
				"Combine IB and IB using All Day Slot without priority",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("AllDay").reviewDetailsPage(userProfile).addGAC()
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressBook(userProfile)
.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddress(userProfile)
.changeAppointmentSAE(2)
.selectAnAppointmentStdIB("AllDay").reviewDetailsPage(userProfile).addGAC()
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}
	
	/*
	 * *****************ALLDAY Slot_TC_09*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibAsvAlldaySlotNo(){
		Report.createTestLogHeader(
				"Combine ASV and IB using All Day Slot with priority",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal").verifyAddressASV(userProfile)
.navigateToViewAllAppointmentsSAE()
.selectAnAppointmentStdIB("AllDay").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressBook(userProfile)
.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddress(userProfile)
.changeAppointmentSAE(2)
.selectAnAppointmentStdIB("AllDay").reviewDetailsPage(userProfile).addGAC()
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}

	/*
	 * *****************ALLDAY Slot_TC_10*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibIbBookedOffline(){
		Report.createTestLogHeader(
				"Combine ASV and IB Booked Offline",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV()
.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddress(userProfile)
.changeAppointmentSAE(2)
.selectAnAppointmentStdIB("AllDay").reviewDetailsPage(userProfile).addGAC()
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}

	/*
	* ------------------------------------------------------------------------------------End Of AllDay Slot Test Cases
	 */

	
	

	/*
	* ------------------------------------------------------------------------------------AM Slot Test Cases
	 */

	/*
	 * *****************AM Slot_TC_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibAmSlotYes(){
		Report.createTestLogHeader(
				"Book IB using AM Slot with priority",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("AM").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}
	
	/*
	 * *****************AM Slot_TC_02*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibAMSlotNo(){
		Report.createTestLogHeader(
				"Book IB using AM Slot without priority",
				"HomeCare200Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("AllDay").reviewDetailsPage(userProfile).addGAC()
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}
	
	/*
	 * *****************AM Slot_TC_05*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibAsvAMSlotNo(){
		Report.createTestLogHeader(
				"Combine ASV and IB using AM Slot with priority",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal").verifyAddressASV(userProfile)
.navigateToViewAllAppointmentsSAE()
.selectAnAppointmentStdIB("AM").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressBook(userProfile)
.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddress(userProfile)
.changeAppointmentSAE(2)
.selectAnAppointmentStdIB("AM").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}
	
	/*
	 * *****************ALLDAY Slot_TC_06*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibIbAMSlotYes(){
		Report.createTestLogHeader(
				"Combine IB and IB using AM Slot with priority",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("AM").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressBook(userProfile)
.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddress(userProfile)
.changeAppointmentSAE(2)
.selectAnAppointmentStdIB("AM").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}

	/*
	* -----------------------------------------------------------------------------------End Of AM Slot Test Cases
	 */

	
	
	

	/*
	* -----------------------------------------------------------------------------------EVE Slot Test Cases
	 */

	/*
	 * *****************EVE Slot_TC_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibEveSlotYes(){
		Report.createTestLogHeader(
				"Book IB using Eve Slot with priority",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("EVE").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}

	/*
	 * *****************EVE Slot_TC_08*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibIbEveSlotYes(){
		Report.createTestLogHeader(
				"Combine IB and IB using EVE Slot with priority",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("EVE").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressBook(userProfile)
.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddress(userProfile)
.changeAppointmentSAE(2)
.selectAnAppointmentStdIB("EVE").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}

	/*
	 * *****************EVE Slot_TC_09*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibAsvEveSlotYes(){
		Report.createTestLogHeader(
				"Combine ASV and IB using EVE Slot with priority Flexi 200",
				"HomeCare200Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal").verifyAddressASV(userProfile)
.navigateToViewAllAppointmentsSAE()
.selectAnAppointmentStdIB("AM").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressBook(userProfile)
.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddress(userProfile)
.changeAppointmentSAE(2)
.selectAnAppointmentStdIB("EVE").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}
	
	/*
	* -----------------------------------------------------------------------------------End Of EVE Slot Test Cases
	 */

	
	

	/*
	* -----------------------------------------------------------------------------------FF Slot Test Cases
	 */

	/*
	 * *****************FF Slot_TC_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibFFSlotNo(){
		Report.createTestLogHeader(
				"Book IB using FF Slot without priority Flexi 200",
				"HomeCare200Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("FF").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}
	
	/*
	 * *****************FF Slot_TC_02*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibFFSlotYes(){
		Report.createTestLogHeader(
				"Book IB using FF Slot with priority Flexi 300",
				"HomeCare300Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare300Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("FF").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}
	
	/*
	 * *****************FF Slot_TC_03*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibIbFFSlotYes(){
		Report.createTestLogHeader(
				"Combine IB and IB using FF Slot with priority",
				"HomeCare400Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("FF").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressBook(userProfile)
.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddress(userProfile)
.changeAppointmentSAE(2)
.selectAnAppointmentStdIB("FF").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}

	/*
	* -----------------------------------------------------------------------------------End Of FF Slot Test Cases
	 */

	
	

	/*
	* ----------------------------------------------------------------------------------PM Slot Test Cases
	 */

	/*
	 * *****************PM Slot_TC_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibPMSlotNo(){
		Report.createTestLogHeader(
				"Book IB using PM Slot without priority Flexi 400",
				"HomeCare400Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("PM").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}
	
	/*
	 * *****************PM Slot_TC_02*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibPMSlotYes(){
		Report.createTestLogHeader(
				"Book IB using PM Slot with priority Flexi 300",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("PM").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}
	
	/*
	 * *****************PM Slot_TC_03*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibPMSlotNoWeekend(){
		Report.createTestLogHeader(
				"Book IB using PM Slot without priority Flexi 400 on Weekend",
				"HomeCare400Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdWeekend("PM").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}
	
	/*
	 * *****************PM Slot_TC_04*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibPMSlotYesWeekend(){
		Report.createTestLogHeader(
				"Book IB using PM Slot with priority Flexi 300 on Weekend",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdWeekend("PM").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}

	/*
	 * *****************PM Slot_TC_05*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibPMSlotYesGas(){
		Report.createTestLogHeader(
				"Book IB using PM Slot with priority ",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("PM").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}

	/*
	 * *****************PM Slot_TC_09*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibAsvPMSlotYes(){
		Report.createTestLogHeader(
				"Combine ASV and IB using PM Slot with priority ",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal").verifyAddressASV(userProfile)
.navigateToViewAllAppointmentsIB()
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("PM").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressBook(userProfile)
.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddress(userProfile)
.changeAppointmentSAE(2)
.selectAnAppointmentStdIB("PM").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}

	/*
	 * *****************PM Slot_TC_10*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibPMSlotYesHec(){
		Report.createTestLogHeader(
				"Book IB using PM Slot with priority-HEC",
				"HomeCare400Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.clickFaultCategory("Electric", userProfile)
.navigatePriorityPage(1)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdWeekend("PM").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}

	/*
	 * *****************PM Slot_TC_11*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibPMSlotNoBankHoliday(){
		Report.createTestLogHeader(
				"Book IB using PM Slot without priority Flexi 400 on Bank Holiday",
				"HomeCare400Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("PM").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}
	
	/*
	 * *****************PM Slot_TC_12*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibPMSlotYesBankHoliday(){
		Report.createTestLogHeader(
				"Book IB using PM Slot with priority on Bank Holiday",
				"HomeCare100Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("PM").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}
	
	/*
	 * *****************PM Slot_TC_13*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibPMSlotNoBankHolidayHec(){
		Report.createTestLogHeader(
				"Book IB using PM Slot without priority Flexi 400 on Bank Holiday - HEC",
				"HomeCare400Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");

new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.clickFaultCategory("Electric", userProfile)
.navigatePriorityPage(0)
.verifyAddressSAE(userProfile)
.selectAnAppointmentStdIB("PM").reviewDetailsPage(userProfile)
.navigateToConfirmationASV()
.navigateTrackCancelChange()
.verifyAddressIB(userProfile)
.accountSummarycancelAppointment().logout();
	}

	/*
	* ------------------------------------------------------------------------------------End Of PM Slot Test Cases
	 */
	
	

	/*
	 * *****************2Hour_No_Slot_1*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void errorMessage2HrSlot(){
		Report.createTestLogHeader(
				"Book IB using 2 Hour Slot to verify error message",
				"HomeCare200Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");
ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.Sae_no_2Hr_Slot);
new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddressSAE(userProfile)
.verifyErrorMessage(errList).logout();
	}

	/*
	 * *****************Preference_No_Slot_2*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void errorMessagePrefSlot(){
		Report.createTestLogHeader(
				"Book IB using Pref Slot to verify error message",
				"HomeCare200Account");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");
ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.Sae_no_Pref_Slot);
new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")

.bookAnEngineer(userProfile, "IV")
.verifyAddressIB(userProfile)
.navigateToIdentifyFault(0, userProfile)
.navigatePriorityPage(1)
.verifyAddressSAE(userProfile)
.selectSlotType("Std")
.verifyErrorMessage(errList).logout();
	}

	@Test(groups = { ASVIB, Regression })
	public void FirstServiceVisitFirst2HrSlot() {
		Report.createTestLogHeader(
						"Book An ASV -First Service Visit Journey Test to select First Available 2 Hour Slot",
						"HomeCare100Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare100Account");
		
		new HomePageAction()
		.navigateToLogin()
		
		.loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAccountOverview("Ideal")
		.verifyAddressSAE(userProfile)
		.navigateToASV2HrSlotIB(userProfile)
		.verifyAddress(userProfile)
		.reviewDetailsPage(userProfile)
		.navigateToConfirmation()
		.verifyAddress(userProfile)
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.viewDetailsCompletePage(userProfile)
		.accountSummaryChangeAppointmentSAE()
		.selectAnAppointment2HrIB("10to12")
		.reviewDetailsPage(userProfile)
		.navigateToConfirmationASV()
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}
}
