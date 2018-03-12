	package bg.framework.app.functional.test.reFactoring;

import static bg.framework.app.functional.entities.FunctionalCategory.ASVIB;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class LandlordPhase2Test extends TestBase{


	/*
	 * ------------------------------------------------------------------------------------Book A BreakDown BS1 Test Cases
	 */

	/*ze
	 * *****************TC_LDPH2_D2_IB_BS1_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibFirstAvailableStandardSlots() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to select First Available standard Hour slot from calendar Page ",
				"HomeCare100Account - TC_LDPH2_D2_IB_BS1_01");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectFirstAvailableStdIB().verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentIB()
		.navigatePriorityPage(0)
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("AM")
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmationASV()
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}
	
	/*
	 * *****************TC_LDPH2_D2_IB_BS1_02*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibFirstAvailable2HrSlots() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to select First Available 2 Hour slot from calendar Page ",
				"HomeCare200Account - TC_LDPH2_D2_IB_BS1_02");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectFirstAvailable2HrIB().verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentIB()
		.navigatePriorityPage(0)
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrIB("10to12")
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmationASV()
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_IB_BS1_03*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibAllDaySlots() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to select All Day slot from calendar Page ",
				"HomeCare300Account - TC_LDPH2_D2_IB_BS1_03");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare300Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("AllDay").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_IB_BS1_04*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ib8to10Slots() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to select All Day slot from calendar Page ",
				"HomeCare100Account - TC_LDPH2_D2_IB_BS1_04");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("8to10").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile).verifyEmailConfirmation(
				userProfile, "BOOK_APPT")
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_IB_BS1_05*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibFFSlots() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to select FF slot from calendar Page ",
				"HomeCare200Account - TC_LDPH2_D2_IB_BS1_05");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("FF").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_IB_BS1_06*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibPMSlots() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to select PM slot from calendar Page ",
				"HomeCare300Account - TC_LDPH2_D2_IB_BS1_06");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare300Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("FF").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile).verifyEmailConfirmation(
				userProfile, "BOOK_APPT")
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummarycancelAppointment()
		.logout();
	}


	/*
	 * *****************TC_LDPH2_D2_IB_BS1_11*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibChangeAppointmentReview() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to verify change appointment Link in review page ",
				"HomeCare300Account - TC_LDPH2_D2_IB_BS1_11");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare300Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("FF").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).clickChangeAppointment().verifyCalendarPage()		
		.logout();
	}

	/*
	 * ------------------------------------------------------------------------------------End Of Book A BreakDown BS1 Test Cases
	 */

	
	
	
	
	
	/*
	 * ------------------------------------------------------------------------------------Book A BreakDown BS2 Test Cases
	 */

	/*
	 * *****************TC_LDPH2_D2_IB_BS2_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibFirstAvailableStandardSlotsBS2() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to select First Available Preference Hour slot from calendar Page ",
				"HomeCare400Account - TC_LDPH2_D2_IB_BS2_01");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectFirstAvailableStdIB().verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentIB()
		.navigatePriorityPage(0)
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("AM")
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmationASV()
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}
	
	/*
	 * *****************TC_LDPH2_D2_IB_BS2_02*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibFirstAvailable2HrSlotsBS2() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to select First Available 2 Hour slot from calendar Page ",
				"HomeCare400Account - TC_LDPH2_D2_IB_BS2_02");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectFirstAvailable2HrIB().verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummarycancelAppointment()
		.logout();
	}
	

	/*
	 * *****************TC_LDPH2_D2_IB_BS2_03*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibAnySlotsBS2() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to select Home Electric appliance ",
				"HomeCare400Account - TC_LDPH2_D2_IB_BS2_03");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.clickFaultCategory("Electric", userProfile)
		.navigatePriorityPage(2).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("8to10").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile)
		//.addCOD(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummarycancelAppointment()
		.logout();
	}


	/*
	 * *****************TC_LDPH2_D2_IB_BS2_05*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibFFSlotsBS2() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to select FF slot from calendar Page ",
				"HomeCare400Account - TC_LDPH2_D2_IB_BS2_05");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("FF").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}
	
	/*
	 * *****************TC_LDPH2_D2_IB_BS2_09****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibChangeAppointmentReviewBS2() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to verify change appointment Link in review page ",
				"HomeCare400Account - TC_LDPH2_D2_IB_BS2_09");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("8to10").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).clickChangeAppointment().verifyCalendarPage()		
		.logout();
	}
	 
	/*
	 * *****************TC_LDPH2_D2_IB_BS2_13****************
	 * Already booked with FF slot
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibNA1NA2BS2() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to verify NA1 and NA2 Status ",
				"HomeCare400Account - TC_LDPH2_D2_IB_BS2_13");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAddressBook(userProfile)
		.verifyAccountOverview("NA1")
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_IB_BS2_14****************
	 * Already booked with FF slot
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibNAWBS2() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to verify NAW Status ",
				"HomeCare400Account - TC_LDPH2_D2_IB_BS2_14");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAddressBook(userProfile)
		.verifyAccountOverview("NAW")
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_IB_BS2_15****************
	 * Already booked with FF slot
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibHoldBS2() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to verify HOLD Status ",
				"HomeCare400Account - TC_LDPH2_D2_IB_BS2_15");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAddressBook(userProfile)
		.verifyAccountOverview("Hold")
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_IB_BS2_16****************
	 * Already booked with AM slot
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibCompBS2() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to verify COMP Status ",
				"HomeCare400Account - TC_LDPH2_D2_IB_BS2_16");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAddressBook(userProfile)
		.verifyAccountOverview("Comp")
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_IB_BS2_17****************
	 * Already booked with PM slot
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibPMBS2() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to verify DISP Status ",
				"HomeCare400Account - TC_LDPH2_D2_IB_BS2_17");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAddressBook(userProfile)
		.verifyAccountOverview("DISP")
		.logout();
	}
	
	/*
	 * ------------------------------------------------------------------------------------End Of Book A BreakDown BS2 Test Cases
	 */
	
	

	/*
	 * ------------------------------------------------------------------------------------Book A BreakDown Excess Test Cases
	 */

	/*
	 * *****************TC_LDPH2_D2_IB_Excess_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibFirstAvailableStandardSlotsExcess() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to select First Available standard Hour slot from calendar Page ",
				"HomeCare100AccountEx - TC_LDPH2_D2_IB_Excess_01");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100AccountEx");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectFirstAvailableStdIB().verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentIB()
		.navigatePriorityPage(0)
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrIB("10to12")
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmationASV()
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}
	
	/*
	 * *****************TC_LDPH2_D2_IB_Excess_02*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibFirstAvailable2HrSlotsEx() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to select First Available 2 Hour slot from calendar Page ",
				"HomeCare200AccountEx - TC_LDPH2_D2_IB_Excess_02");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200AccountEx");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectFirstAvailable2HrIB().verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_IB_Excess_03*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibAllDaySlotsEx() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to select All Day slot from calendar Page ",
				"HomeCare300AccountEx - TC_LDPH2_D2_IB_Excess_03");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare300AccountEx");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("AllDay").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_IB_Excess_04*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ib8to10SlotsEx() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to select All Day slot from calendar Page ",
				"HomeCare400AccountEx - TC_LDPH2_D2_IB_Excess_04");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400AccountEx");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		//.navigateToIdentifyFault(0, userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("8to10").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_IB_Excess_05*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibFFSlotsEx() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to select FF slot from calendar Page ",
				"HomeCare200AccountEx - TC_LDPH2_D2_IB_Excess_05");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200AccountEx");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("FF").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_IB_Excess_06*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibPMSlotsEx() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to select PM slot from calendar Page ",
				"HomeCare400AccountEx - TC_LDPH2_D2_IB_Excess_06");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400AccountEx");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("FF").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_IB_Excess_09*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibChangeApplianceReviewx() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to verify change appliance Link in review page ",
				"HomeCare300AccountEx - TC_LDPH2_D2_IB_Excess_09");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare300AccountEx");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("8to10").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).clickChangeAppliance().verifyFaultPage()		
		.logout();
	}


	/*
	 * *****************TC_LDPH2_D2_IB_Excess_10*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibChangeAppointmentReviewEx() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to verify change appointment Link in review page ",
				"HomeCare400AccountEx - TC_LDPH2_D2_IB_Excess_10");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400AccountEx");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("8to10").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).clickChangeAppointment().verifyCalendarPage()		
		.logout();
	}

	/*
	 * ------------------------------------------------------------------------------------End Of Book A BreakDown Excess Test Cases
	 */


	

	/*
	 * ------------------------------------------------------------------------------------Book An ASV Test Cases
	 */

	/*
	 * *****************TC_LDPH2_D2_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvFirstPrefSlotAccSummary() {
			
		Report.createTestLogHeader(
				"Book An ASV -ASV Journey Test to select First Available preference Hour slot from Acc Summary Page ",
				"HomeCare100Account - TC_LDPH2_D2_01");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)		
		.verifyAddressSAE(userProfile)
		.navigateToASVStdSlotIB(userProfile)
		.verifyAddressLL(userProfile)
		.continueLandlord()
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointment()
		.verifyAddressIBPage(userProfile)
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdLL("AM")
		.continueLandlordOverlay(1, "Std")
		.verifyAddressIB(userProfile)
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmationASV()
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_02*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvFirst2HrSlotAccSummary() {
			
		Report.createTestLogHeader(
				"Book An ASV -ASV Journey Test to select First Available 2 Hour Hour slot from Acc Summary Page - COD,GAC",
				"HomeCare100Account - TC_LDPH2_D2_02");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)		
		.verifyAddressSAE(userProfile)
		.navigateToASV2HrSlotIB(userProfile)
		.verifyAddressLL(userProfile)
		.continueLandlordOverlay(3, "NA")
		.continueLandlord()
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addGAC().addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentIB()
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrIB("8to10")
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmationASV()
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_03*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvFirstPrefSlotCalendar() {
			
		Report.createTestLogHeader(
				"Book An ASV -ASV Journey Test to select First Available preference Hour slot from Calendar Page - COD ",
				"HomeCare100Account - TC_LDPH2_D2_03");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)	
		.navigateToViewAllAppointments()
		.verifyAddressSAE(userProfile)
		.selectFirstAvailableStdLL()
		.continueLandlordOverlay(3, "2Hr")
		.continueLandlord()
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_04*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvFirst2HrSlotCalendar() {
			
		Report.createTestLogHeader(
				"Book An ASV -ASV Journey Test to select First Available 2 Hour Hour slot from Calendar Page ",
				"HomeCare100Account - TC_LDPH2_D2_04");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointments()
		.verifyAddressSAE(userProfile)
		.selectFirstAvailable2HrIB()
		.verifyAddressLL(userProfile)
		.continueLandlordOverlay(1,"2Hr")
		.continueLandlord()
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentIB()
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrLL("8to10")
		.continueLandlordOverlay(1,"2Hr")
		.verifyAddressIB(userProfile)		
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmationASV()
		.navigateTrackCancelChange()
		.accountSummarycancelAppointmentLL()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_05*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvAMCPL12() {
			
		Report.createTestLogHeader(
				"Book An ASV -ASV Journey Test to select AM slot from Calendar Page - CPL12 Lesser - GAC ",
				"HomeCare100Account - TC_LDPH2_D2_05");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointments()
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdLL("AM")
		.continueLandlordOverlay(1,"2Hr")
		.continueLandlord()
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addGAC().navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentIB()
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrLL("8to10")
		.continueLandlordOverlay(1,"2Hr")
		.verifyAddressIB(userProfile)		
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmationASV()
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_06*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvPM() {
			
		Report.createTestLogHeader(
				"Book An ASV -ASV Journey Test to select PM slot from Calendar Page ",
				"HomeCare100Account - TC_LDPH2_D2_06");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointments()
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdLL("PM")	
		.continueLandlordOverlay(3, "Std")
		.continueLandlord()
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()	
				.accountSummarycancelAppointment().verifyAddressIBPage(userProfile).verifyEmailConfirmation(
						userProfile, "CANCEL_APPT")
		.logout();
	}
	
	/*
	 * *****************TC_LDPH2_D2_07*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvFFCPL12COD() {
			
		Report.createTestLogHeader(
				"Book An ASV -ASV Journey Test to select FF slot from Calendar Page - COD - CPL12 Lesser",
				"HomeCare100Account - TC_LDPH2_D2_07");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointments()
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdLL("FF")
		.continueLandlordOverlay(1,"2Hr")
		.continueLandlord()
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_08*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvAllDayCPL12CODGAC() {
			
		Report.createTestLogHeader(
				"Book An ASV -ASV Journey Test to select AllDay slot from Calendar Page - COD + GAC - CPL12 Lesser",
				"HomeCare100Account - TC_LDPH2_D2_08");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointments()
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdLL("AllDay")
		.continueLandlordOverlay(1,"2Hr")
		.continueLandlord()
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addGAC().addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummarycancelAppointment()
		.logout();
	}
	
	/*
	 * *****************TC_LDPH2_D2_09*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asv12to2CPL12() {
			
		Report.createTestLogHeader(
				"Book An ASV -ASV Journey Test to select 12-2 slot from Calendar Page -  CPL12 Lesser",
				"HomeCare100Account - TC_LDPH2_D2_09");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointments()
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrLL("12to2")
		.continueLandlordOverlay(1,"2Hr")
		.continueLandlord()
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummarycancelAppointment()
		.logout();
	}
	
	/* 
	 * *****************TC_LDPH2_D2_10*****************	
 	 * 	 
	 */
	
	@Test(groups = { ASVIB ,Regression}) 
	public void asvVerifyLinkNavigation()
	{
		Report.createTestLogHeader(
				"Book An ASV -verify Links",
				"HomeCare100Account - TC_LDPH2_D2_10");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");
		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)		
		.navigateToAccountSummaryPageASV()
		.verifyAccountOverview("ideal")
		.verifyAddressSAE(userProfile)
		.navigateToASV2HrSlotIB(userProfile)
		.verifyAddressLL(userProfile)
		.continueLandlordOverlay(3	, "NA")
		.continueLandlord()
		.reviewDetailsPageLL(userProfile)
		.clickCancel()
		.verifyLinkNavigation("IB")
		.verifyFaultPage()		
		.logout();
		
	}

	/*
	 * *****************TC_LDPH2_D2_13****************
	 * Already booked with 8to10 slot
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvDisp() {
			
		Report.createTestLogHeader(
				"Book An ASV -ASV Journey Test to verify DISP Status ",
				"HomeCare100Account - TC_LDPH2_D2_13");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAddressIB(userProfile)
		.verifySlotBook("8to10")		
		.verifyAccountOverview("Disp")
		.logout();
	}
	
	/*
	 * *****************TC_LDPH2_D2_14****************
	 * Already booked with 10to12 slot
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvHold() {
			
		Report.createTestLogHeader(
				"Book An ASV -ASV Journey Test to verify Hold Status ",
				"HomeCare100Account - TC_LDPH2_D2_14");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAddressIB(userProfile)
		.verifySlotBook("10to12")		
		.verifyAccountOverview("Hold")
		.logout();
	}
	
	/*
	 * *****************TC_LDPH2_D2_15****************
	 * Already booked with 12to2 slot
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvRoute() {
			
		Report.createTestLogHeader(
				"Book An ASV -ASV Journey Test to verify Route Status ",
				"HomeCare100Account - TC_LDPH2_D2_15");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAddressIB(userProfile)
		.verifySlotBook("12to2")		
		.verifyAccountOverview("Route")
		.logout();
	}
	
	/*
	 * *****************TC_LDPH2_D2_16****************
	 * Already booked with 8to10 slot
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvNA1NA2() {
			
		Report.createTestLogHeader(
				"Book An ASV -ASV Journey Test to verify NA1 and NA2 Status ",
				"HomeCare100Account - TC_LDPH2_D2_16");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAddressIB(userProfile)
		.verifySlotBook("8to10")		
		.verifyAccountOverview("NA1")
		.logout();
	}

	/*	
	 * *****************TC_LDPH2_D2_17****************
	 * Already booked with PM slot
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvNAW() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to verify NAW Status ",
				"HomeCare100Account - TC_LDPH2_D2_17");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAddressIB(userProfile)
		.verifySlotBook("FF")	
		.verifyAccountOverview("NAW")
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_18****************
	 * Already booked with 10to12 slot
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvSite() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to verify SITE Status ",
				"HomeCare100Account - TC_LDPH2_D2_18");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV()
.verifyAddressIB(userProfile)
.verifySlotBook("10to12")	
.verifyAccountOverview("Site")
.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_19****************
	 * Already booked with FF slot
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvAlloc() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to verify Alloc Status ",
				"HomeCare100Account - TC_LDPH2_D2_19");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
new HomePageAction()
.navigateToLogin().loginUserDetails(userProfile)
.navigateToAccountSummaryPageASV()
.verifyAddressIB(userProfile)
.verifySlotBook("FF")	
.verifyAccountOverview("Alloc")
.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_20*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvChangeAppointmentReview() {
			
		Report.createTestLogHeader(
				"Book An ASV -ASV Journey Test to verify change appointment Link in review page ",
				"HomeCare100Account - TC_LDPH2_D2_20");
		UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointmentsIB()
		.verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("8to10").verifyAddressLL(userProfile)
		.continueLandlord()		
		.reviewDetailsPageLL(userProfile).clickChangeAppointment().verifyCalendarPage().logout();
	}

	/*
	 * *****************TC_LDPH2_D2_22*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvDiffAppointment() {
			
		Report.createTestLogHeader(
				"Book An ASV -ASV Journey Test to select different appointment ",
				"HomeCare100Account - TC_LDPH2_D2_22");
		UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointmentsIB()
		.verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE()
		.selectAnAppointment2HrLL("8to10")
		.continueLandlordOverlay(0,"2Hr")
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrLL("8to10")		
		.continueLandlordOverlay(3,"NA")	
		.continueLandlord()
		.verifyAddress(userProfile)		
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.viewDetails()
		.accountSummaryChangeAppointmentIB()
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrLL("8to10")
		.verifyAddressIB(userProfile)		
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmationASV()
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()		
		.logout();
	}
	
	/*
	 * *****************TC_LDPH2_D2_23*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvSameAppointment() {
			
		Report.createTestLogHeader(
				"Book An ASV -ASV Journey Test to select Same appointment ",
				"HomeCare100Account - TC_LDPH2_D2_23");
		UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointmentsIB()
		.verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrLL("8to10")
		.continueLandlordOverlay(1,"2Hr")		
		.continueLandlord()
		.verifyAddress(userProfile)		
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().accountSummarycancelAppointment()		
		.logout();
	}

	/*
	 * ------------------------------------------------------------------------------------End Of Book An ASV Test Cases
	 */


	/*
	 * ------------------------------------------------------------------------------------Cancel Test Cases
	 */

	/*
	 * *****************TC_LDPH2_D2_CAN_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvCancelView() {
			
		Report.createTestLogHeader(
				"Cancel An ASV -Cancel an ASV from view details Page ",
				"HomeCare100Account - TC_LDPH2_D2_CAN_01");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)		
		.verifyAddressASV(userProfile)
		.navigateToViewAllAppointmentsIB()
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrIB("10to12")
		.verifyAddressLL(userProfile)
		.continueLandlordOverlay(3, "2Hr")
		.continueLandlord()
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummarycancelAppointment()
		.logout();
	}
	
	/*
	 * *****************TC_LDPH2_D2_CAN_02*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvCancelSummary() {
			
		Report.createTestLogHeader(
				"Cancel An ASV -Cancel an ASV from Acc Summary Page ",
				"HomeCare100Account - TC_LDPH2_D2_CAN_02");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)		
		.verifyAddressASV(userProfile)
		.navigateToViewAllAppointmentsIB()
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrIB("8to10")		
		.verifyAddressLL(userProfile)
		.continueLandlord()
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_CAN_04*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void asvCancelSummaryCOD() {
			
		Report.createTestLogHeader(
				"Cancel An ASV -Cancel an ASV from Acc Summary Page - COD ",
				"HomeCare100Account - TC_LDPH2_D2_CAN_04");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)		
		.verifyAddressSAE(userProfile)
		//.navigateToASVStdSlotIB(userProfile)
		.navigateToASV2HrSlotIB(userProfile)
		.verifyAddressLL(userProfile)
		.continueLandlord()
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_CAN_05*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibCancelView() {
			
		Report.createTestLogHeader(
				"Cancel A Breakdown -IB Journey Test to cancel from view details Page ",
				"HomeCare300Account - TC_LDPH2_D2_CAN_05");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare300Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE()
		//.selectAnAppointmentStdIB("FF")
		.selectAnAppointment2HrIB("8to10")
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummarycancelAppointment()
		.logout();
	}
	
	/*
	 * *****************TC_LDPH2_D2_CAN_06*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibCancelSummary() {
			
		Report.createTestLogHeader(
				"Cancel A Breakdown -IB Journey Test to cancel from account Summary ",
				"HomeCare300Account - TC_LDPH2_D2_CAN_06");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare300Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("FF").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_CAN_09*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void ibCancelViewCP12() {
			
		Report.createTestLogHeader(
				"Cancel A Breakdown -IB Journey Test to cancel from View Details Page ",
				"HomeCare300Account - TC_LDPH2_D2_CAN_09");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare300Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("8to10").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * ------------------------------------------------------------------------------------End of Cancel Test Cases
	 */
	
	
	
	
	/*
	 * ------------------------------------------------------------------------------------Combining IB BS1 Test Cases
	 */

	/*
	 * *****************CombiningBreakdownBS1_TC_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void combIBChangeApplianceCalendarBS1() {
			
		Report.createTestLogHeader(
				"Combining Breakdown -IB Journey Test to verify change appliance Link in Calendar page ",
				"HomeCare100Account - CombiningBreakdownBS1_TC_01");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("8to10").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).changeAppointment(2).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPage().clickChangeAppliance().verifyFaultPage().clickCancelASV()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************CombiningBreakdownBS1_TC_02****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void combIBChangeApplianceReviewBS1() {
			
		Report.createTestLogHeader(
				"Combining Breakdown -IB Journey Test to verify change appliance Link in review page ",
				"HomeCare200Account - CombiningBreakdownBS1_TC_02");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("8to10").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).changeAppointment(2).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("8to10").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).clickChangeAppliance().verifyFaultPage()		
		.clickCancelASV()
		.accountSummarycancelAppointment()
		.logout();
	}
	
	/*
	 * *****************CombiningBreakdownBS1_TC_03*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void combIBChangeAppointmentReviewBS1() {
			
		Report.createTestLogHeader(
				"Combining Breakdown -IB Journey Test to verify change appointment Link in review page ",
				"HomeCare300Account - CombiningBreakdownBS1_TC_03");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare300Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("PM").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).changeAppointment(2).verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("PM").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).clickChangeAppointment().verifyCalendarPage()		
		.clickCancelASV()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************CombiningBreakdownBS1_TC_05*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void combIBAllDay() {
			
		Report.createTestLogHeader(
				"Combining Breakdown -IB Journey Test All Day slot ",
				"HomeCare300Account - CombiningBreakdownBS1_TC_05");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare300Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("AllDay").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).changeAppointment(2).verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("AllDay").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************CombiningBreakdownBS1_TC_06*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void combIBAllDaySameSlot() {
			
		Report.createTestLogHeader(
				"Combining Breakdown -IB Journey Test All Day slot - Keep Slot ",
				"HomeCare200Account - CombiningBreakdownBS1_TC_06");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("AllDay").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).changeAppointment(1)
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************CombiningBreakdownBS1_TC_07*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void combIB6to8COD() {
			
		Report.createTestLogHeader(
				"Combining Breakdown -IB Journey Test 6 to 8 slot",
				"HomeCare300Account - CombiningBreakdownBS1_TC_07");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare300Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("6to8").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile)
		.addCOD(userProfile)		
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).changeAppointment(1)
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************CombiningBreakdownBS1_TC_08*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void combIBFirstSlot() {
			
		Report.createTestLogHeader(
				"Combining Breakdown -IB Journey Test First Slot",
				"HomeCare200Account - CombiningBreakdownBS1_TC_08");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("AllDay").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).changeAppointment(2)
		.verifyAddressSAE(userProfile)
		.selectFirstAvailable2HrIB()
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummaryChangeAppointmentIB()
		.navigatePriorityPage(2)
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrIB("8to10")
		.reviewDetailsPage(userProfile)
		.navigateToConfirmationASV()
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************CombiningBreakdownBS1_TC_09*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void combIBDiffSlotCOD() {
			
		Report.createTestLogHeader(
				"Combining Breakdown -IB Journey Test 6 to 8 slot -Diff Slot",
				"HomeCare300Account - CombiningBreakdownBS1_TC_09");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare300Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("6to8").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile)
		.addCOD(userProfile)		
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).changeAppointment(2)
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrIB("6to8")
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************CombiningBreakdownBS1_TC_10*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void combIBViewDetail() {
			
		Report.createTestLogHeader(
				"Combining Breakdown -IB Journey Test View Detail",
				"HomeCare300Account - CombiningBreakdownBS1_TC_10");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare300Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("AM").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).changeAppointment(2)
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("AM")
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()		
		.viewDetailsCompletePage(userProfile)
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * ------------------------------------------------------------------------------------End of Combining IB BS1 Test Cases
	 */
	
	
	
	

	/*
	 * ------------------------------------------------------------------------------------Combining IB BS12 Test Cases
	 */

	/*
	 * *****************CombiningBreakdownBS2_TC_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void combIBChangeApplianceCalendarBS2() {
			
		Report.createTestLogHeader(
				"Combining Breakdown -IB Journey Test to verify change appliance Link in Calendar page ",
				"HomeCare400Account - CombiningBreakdownBS2_TC_01");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("8to10").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).changeAppointment(2).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPage().clickChangeAppliance().verifyFaultPage().clickCancelASV()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************CombiningBreakdownBS2_TC_02****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void combIBChangeApplianceReviewBS2() {
			
		Report.createTestLogHeader(
				"Combining Breakdown -IB Journey Test to verify change appliance Link in review page ",
				"HomeCare400Account - CombiningBreakdownBS2_TC_02");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("8to10").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.verifyAddressASVIB(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).changeAppointment(2).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("EVE").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).clickChangeAppliance().verifyFaultPage()		
		.clickCancelASV()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************CombiningBreakdownBS2_TC_03****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void combIBAMSlotBS2COD() {
			
		Report.createTestLogHeader(
				"Combining Breakdown BS2 -IB Journey Test AM slot - COD ",
				"HomeCare400Account - CombiningBreakdownBS2_TC_03");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("AM").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile)
		.addCOD(userProfile)		
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).changeAppointment(2).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("AM").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}
	
	/*
	 * *****************CombiningBreakdownBS2_TC_04****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void combIB8to10BS2COD() {
			
		Report.createTestLogHeader(
				"Combining Breakdown BS2 -IB Journey Test 8to10 slot - COD ",
				"HomeCare400Account - CombiningBreakdownBS2_TC_04");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("8to10").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).changeAppointment(2).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("8to10").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}
	
	/*
	 * *****************CombiningBreakdownBS2_TC_05****************
	 * Already booked with PM slot
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void combRoute() {
			
		Report.createTestLogHeader(
				"Combining IB -IB Journey Test to verify Route Status ",
				"HomeCare400Account - CombiningBreakdownBS2_TC_06");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAddressIB(userProfile)
		.verifySlotBook("PM")		
		.verifyAccountOverview("Route")
		.logout();
	}

	/*
	 * *****************CombiningBreakdownBS2_TC_06****************
	 * Already booked with AM slot
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void combDisp() {
			
		Report.createTestLogHeader(
				"Combining IB -IB Journey Test to verify Disp Status ",
				"HomeCare400Account - CombiningBreakdownBS2_TC_06");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAddressIB(userProfile)
		.verifySlotBook("AM")		
		.verifyAccountOverview("Disp")
		.logout();
	}
		
	/*
	 * *****************CombiningBreakdownBS2_TC_07****************
	 * Already booked with FF slot
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void combHold() {
			
		Report.createTestLogHeader(
				"Combining IB -IB Journey Test to verify Hold Status ",
				"HomeCare400Account - CombiningBreakdownBS2_TC_07");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAddressIB(userProfile)
		.verifySlotBook("FF")		
		.verifyAccountOverview("Hold")
		.logout();
	}
	
	/*
	 * *****************CombiningBreakdownBS2_TC_08****************
	 * Already booked with AM slot
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void combSite() {
			
		Report.createTestLogHeader(
				"Combining IB -IB Journey Test to verify Site Status ",
				"HomeCare400Account - CombiningBreakdownBS2_TC_08");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAddressIB(userProfile)
		.verifySlotBook("AM")		
		.verifyAccountOverview("Site")
		.logout();
	}

	/*
	 * ------------------------------------------------------------------------------------End of Combining IB BS2 Test Cases
	 */

	
	
	
	
	/*
	 * ------------------------------------------------------------------------------------Combining ASV and IB Test Cases
	 */

	/*
	 * *****************TC_LDPH2_D2_ASVIB_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void combASVIBChangeAppliance() {
			
		Report.createTestLogHeader(
				"Combining ASV  and IB -ASVIB Journey Test to click change appliance from Calendar Page ",
				"HomeCare100Account - TC_LDPH2_D2_ASVIB_01");
		UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1)		
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("AM")	
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.bookAnEngineer(userProfile, "ASV")
		.changeAppointmentLL(2).continueLandlordOverlay(0, "Std").verifyAddressSAE(userProfile).selectAnAppointmentStdLL("AM")
		.continueLandlordOverlay(0,"2Hr").verifyAddressIB(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile).verifyCalendarPage()
		.clickChangeAppliance().verifyFaultPage().clickCancelASV()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_ASVIB_02*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void combASVIB() {
			
		Report.createTestLogHeader(
				"Combining ASV  and IB -ASVIB Journey Test  ",
				"HomeCare100Account - TC_LDPH2_D2_ASVIB_02");
		UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0)		
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("AM")	
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.bookAnEngineer(userProfile, "ASV")
		.changeAppointment(2).verifyAddress(userProfile).verifyAddressSAE(userProfile).selectAnAppointment2HrLL("8to10")
		.continueLandlordOverlay(1,"2Hr")
		.continueLandlord()
		.selectedAppChk(userProfile).verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_ASVIB_03*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void combASVIB10to12() {
			
		Report.createTestLogHeader(
				"Combining ASV  and IB -ASVIB Journey Test 10 to 12 slot ",
				"HomeCare100Account - TC_LDPH2_D2_ASVIB_03");
		UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0)		
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("AM")	
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.bookAnEngineer(userProfile, "ASV")
		.changeAppointment(2).verifyAddress(userProfile).verifyAddressSAE(userProfile).selectAnAppointment2HrIB("10to12")
		.verifyAddressLL(userProfile)
		.continueLandlordOverlay(1,"2Hr")
		.continueLandlord()
		.selectedAppChk(userProfile).verifyAddress(userProfile).reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile).verifyEmailConfirmation(
				userProfile, "BOOK_APPT")
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_ASVIB_04*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void combASVIB10to12SameSlot() {
			
		Report.createTestLogHeader(
				"Combining ASV  and IB -ASVIB Journey Test 10 to 12 slot Same slot",
				"HomeCare100Account - TC_LDPH2_D2_ASVIB_04");
		UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0)		
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("AM")		
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.bookAnEngineer(userProfile, "ASV")
		.changeAppointment(1).verifyAddressLL(userProfile)
		.continueLandlordOverlay(1,"2Hr")
		.continueLandlord()
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_ASVIB_05*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void combASVIBChangeAppointment() {
			
		Report.createTestLogHeader(
				"Combining ASV  and IB -ASVIB Journey Test to click change appointment from Calendar Page ",
				"HomeCare300Account - TC_LDPH2_D2_ASVIB_05");
		UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare300Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1)		
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("AM")				
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.bookAnEngineer(userProfile, "ASV")
		.changeAppointment(2).verifyAddress(userProfile).verifyAddressSAE(userProfile)
		.selectAnAppointmentStdLL("AM")		
		.continueLandlordOverlay(1,"2Hr")
		.continueLandlord()
		.selectedAppChk(userProfile).verifyAddress(userProfile)
		.clickChangeAppointment().verifyCalendarPage().clickCancel().verifyAddressASVIB(userProfile)
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_ASVIB_06*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void combASVIBFirstSlot() {
			
		Report.createTestLogHeader(
				"Combining ASV  and IB -ASVIB Journey Test to select first available slot from Calendar Page ",
				"HomeCare200Account - TC_LDPH2_D2_ASVIB_06");
		UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0)		
		.verifyAddressSAE(userProfile)
		.selectFirstAvailable2HrIB()
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.bookAnEngineer(userProfile, "ASV")
		.changeAppointment(1).verifyAddressLL(userProfile)
		.continueLandlordOverlay(1,"2Hr")
		.continueLandlord()
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()		
		.accountSummaryChangeAppointment()
		.verifyAddressIBPage(userProfile)
		.navigatePriorityPageSAE(0)
		.selectAnAppointment2HrLL("10to12")
		.continueLandlordOverlay(3, "2Hr")
		.verifyAddressIB(userProfile)
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmationASV()
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_ASVIB_07*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void combASVIBAllDaySameSlot() {
			
		Report.createTestLogHeader(
				"Combining ASV  and IB -ASVIB Journey Test All Day slot Same slot",
				"HomeCare100Account - TC_LDPH2_D2_ASVIB_07");
		UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0)		
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("AllDay")		
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.bookAnEngineer(userProfile, "ASV")
		.changeAppointment(1).verifyAddressLL(userProfile)
		.continueLandlordOverlay(1,"2Hr")		
		.continueLandlord()
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}
	
	/*
	 * *****************TC_LDPH2_D2_ASVIB_12*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void combASVIBPMSameSlot() {
			
		Report.createTestLogHeader(
				"Combining ASV  and IB -ASVIB Journey Test PM slot Same slot",
				"HomeCare100Account - TC_LDPH2_D2_ASVIB_07");
		UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0)		
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("PM")		
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.bookAnEngineer(userProfile, "ASV")
		.changeAppointmentLL(1)
		//.verifyAddressLL(userProfile)
		.continueLandlordOverlay(0,"Std")
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdLL("PM")
		.continueLandlord()
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_ASVIB_13*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void combASVIBPMSameSlotCP12() {
			
		Report.createTestLogHeader(
				"Combining ASV  and IB -ASVIB Journey Test PM slot Same slot -CP12",
				"HomeCare100Account - TC_LDPH2_D2_ASVIB_13");
		UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0)		
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("PM")		
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.bookAnEngineer(userProfile, "ASV")
		.changeAppointment(1).verifyAddressLL(userProfile)
		.continueLandlordOverlay(1,"2Hr")
		.continueLandlord()
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}
		
	/*
	 * *****************TC_LDPH2_D2_ASVIB_14*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void combASVIBPMDiffSlotCP12() {
			
		Report.createTestLogHeader(
				"Combining ASV  and IB -ASVIB Journey Test PM slot Diff slot -CP12",
				"HomeCare100Account - TC_LDPH2_D2_ASVIB_14");
		UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0)		
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("PM")		
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.bookAnEngineer(userProfile, "ASV")
		.changeAppointmentLL(1)
		.continueLandlordOverlay(0,"Std")
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdLL("PM")
		.continueLandlordOverlay(3, "Std")
		.continueLandlord()
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * ------------------------------------------------------------------------------------End of Combining ASV and IB Test Cases
	 */

	
	
	
	

	/*
	 * ------------------------------------------------------------------------------------Energy Extra IB Test Cases
	 */

	/*
	 * *****************EE_TC_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void eeIB50CODGAC() {
			
		Report.createTestLogHeader(
				"Book A EE Breakdown -IB Journey Test with No priority",
				"EnergyExtra50Account - EE_TC_01");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("EnergyExtra50Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("FF").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addGAC().addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************EE_TC_02*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void eeIB200CODGAC() {
			
		Report.createTestLogHeader(
				"Book A EE Breakdown -IB Journey Test with No priority",
				"EnergyExtra200Account - EE_TC_02");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("EnergyExtra200Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("FF").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addGAC().addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************EE_TC_03*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void eeIB400CODGAC() {
			
		Report.createTestLogHeader(
				"Book A EE Breakdown -IB Journey Test with priority",
				"EnergyExtra400Account - EE_TC_03");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("EnergyExtra400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("FF").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addGAC().addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************EE_TC_04*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void eeIB200FlexiCODGAC() {
			
		Report.createTestLogHeader(
				"Book A EE Breakdown -IB Journey Test with priority",
				"EnergyExtra200FlexiAccount - EE_TC_04");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("EnergyExtra200FlexiAccount");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("FF").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addGAC().addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummarycancelAppointment()
		.logout();
	}


	/*
	 * *****************EE_TC_05*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void eeReschedIB50AM() {
			
		Report.createTestLogHeader(
				"Reschedule A EE Breakdown -IB Journey Test with No priority",
				"EnergyExtra50Account - EE_TC_05");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("EnergyExtra50Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("AM").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentIB()
		.navigatePriorityPage(2)
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("AM")
		.reviewDetailsPageLL(userProfile)
		.clickChangeAppointment()
		.verifyCalendarPage()
		.clickCancel()
		.verifyAddressASVIB(userProfile)
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************EE_TC_06*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void eeReschedIB200() {
			
		Report.createTestLogHeader(
				"Reschedule A EE Breakdown -IB Journey Test with No priority",
				"EnergyExtra200Account - EE_TC_06");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("EnergyExtra200Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("6to8").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentIB()
		.navigatePriorityPage(2)
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrIB("6to8")
		.reviewDetailsPageLL(userProfile)
		.clickChangeAppointment()
		.verifyCalendarPage()
		.clickCancel()
		.verifyAddressASVIB(userProfile)
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************EE_TC_07*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void eeReschedIB400() {
			
		Report.createTestLogHeader(
				"Reschedule A EE Breakdown -IB Journey Test with No priority",
				"eeReschedIB400Account - EE_TC_07");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("EnergyExtra400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("6to8").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentIB()
		.navigatePriorityPage(2)
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrIB("6to8")
		.reviewDetailsPageLL(userProfile)
		.clickChangeAppointment()
		.verifyCalendarPage()
		.clickCancel()
		.verifyAddressASVIB(userProfile)
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************EE_TC_08*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void eeReschedIB200Flexi() {
			
		Report.createTestLogHeader(
				"Reschedule A EE Breakdown -IB Journey Test with No priority",
				"eeReschedIB200FlexiAccount - EE_TC_08");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("EnergyExtra200FlexiAccount");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("AM").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentIB()
		.navigatePriorityPage(2)
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("AM")
		.reviewDetailsPageLL(userProfile)
		.clickChangeAppointment()
		.verifyCalendarPage()
		.clickCancel()
		.verifyAddressASVIB(userProfile)
		.accountSummarycancelAppointment()
		.logout();
	}
	
	/*
	 * ------------------------------------------------------------------------------------End of Energy Extra IB Test Cases
	 */
	
	
	

	/*
	 * ------------------------------------------------------------------------------------Linking Test Cases
	 */

	/*
	 * *****************Linking ASV_IB_TC_03****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void linkChangeAppliance() {
			
		Report.createTestLogHeader(
				"Linking -linking ASV Journey Test to verify change appliance link on the Review page ",
				"HomeCare200Account - Linking ASV_IB_TC_03");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0).verifyAddressASVIB(userProfile).continueWithASVIB()
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("8to10").verifyAddressLL(userProfile)
		.continueLandlord()
		.reviewDetailsPageLL(userProfile).clickChangeAppliance()
		.verifyFaultPage().clickCancelASV()
		.logout();
	}
	
	/*
	 * *****************Linking ASV_IB_TC_04****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void link2to4GAC() {
			
		Report.createTestLogHeader(
				"Linking -linking ASV Journey Test 2 to 4 slot - GAC ",
				"HomeCare300Account - Linking ASV_IB_TC_04");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare300Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddressASVIB(userProfile).continueWithASVIB()
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("2to4").verifyAddressLL(userProfile)
		.continueLandlord()
		.reviewDetailsPageLL(userProfile).addGAC().navigateToConfirmation()
		.verifyAddress(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************Linking ASV_IB_TC_05****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void link12to2COD() {
			
		Report.createTestLogHeader(
				"Linking -linking ASV Journey Test 12 to 2 - COD ",
				"HomeCare100Account - Linking ASV_IB_TC_05");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddressASVIB(userProfile).continueWithASVIB()
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("12to2").verifyAddressLL(userProfile)
		.continueLandlord()
		.reviewDetailsPageLL(userProfile).addCOD(userProfile)
		.verifyAddress(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}
	
	/*
	 * *****************Linking ASV_IB_TC_06****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void link10to12CODGAC() {
			
		Report.createTestLogHeader(
				"Linking -linking ASV Journey Test 10 to 12 - COD + GAC",
				"HomeCare300Account - Linking ASV_IB_TC_06");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare300Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddressASVIB(userProfile).continueWithASVIB()
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("10to12").verifyAddressLL(userProfile)
		.continueLandlord()
		.reviewDetailsPageLL(userProfile).addGAC().addCOD(userProfile)
		.verifyAddress(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}
	
	/*
	 * *****************Linking ASV_IB_TC_07****************
	 * Already booked with FF slot with No priority
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void linkNA1NA2() {
			
		Report.createTestLogHeader(
				"Link -Link Journey Test to verify NA1 and NA2 Status ",
				"HomeCare300Account - Linking ASV_IB_TC_07");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAddressBook(userProfile)
		.verifyAccountOverview("NA1")
		.logout();
	}
	
	/*
	 * *****************Linking ASV_IB_TC_08****************
	 * Already booked with PM slot with No priority
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void linkNAW() {
			
		Report.createTestLogHeader(
				"Link -Link Journey Test to verify NAW Status ",
				"HomeCare100Account - Linking ASV_IB_TC_08");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAddressBook(userProfile)
		.verifyAccountOverview("NAW")
		.logout();
	}
	
	/*
	 * *****************Linking ASV_IB_TC_09****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void linkAMGAC() {
			
		Report.createTestLogHeader(
				"Linking -linking ASV Journey Test AM slot",
				"HomeCare100Account - Linking ASV_IB_TC_09");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0).verifyAddressASVIB(userProfile).continueWithASVIB()
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("AM").verifyAddressLL(userProfile)
		.continueLandlord()
		.reviewDetailsPageLL(userProfile).addGAC().navigateToConfirmation()
		.verifyAddress(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}
	
	/*
	 * ------------------------------------------------------------------------------------End of Linking Test Cases
	 */
	
	
	

	/*
	 * ------------------------------------------------------------------------------------Reschedule ASV Test Cases
	 */
	
	/*
	 * *****************TC_LDPH2_D2_REASV_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void reschedASV() {
			
		Report.createTestLogHeader(
				"Reschedule ASV -ASV Journey Test to select AM slot , Reschedule from status bar ",
				"HomeCare400Account - TC_LDPH2_D2_REASV_01");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointments()
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdLL("AM")
		.continueLandlordOverlay(1,"2Hr")
		.continueLandlord()
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.accountSummaryChangeAppointment()
		.verifyAddress(userProfile).verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("AM")
		.verifyAddress(userProfile).reviewDetailsPageLL(userProfile)
		.navigateToConfirmation().confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_REASV_02*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void reschedASVChangeAppointment() {
			
		Report.createTestLogHeader(
				"Reschedule ASV -ASV Journey Test to select PM slot- , verify Change appointment Link",
				"HomeCare400Account - TC_LDPH2_D2_REASV_02");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointments()
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdLL("AM")
		.continueLandlordOverlay(1,"2Hr")
		.continueLandlord()
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.accountSummaryChangeAppointment()
		.verifyAddress(userProfile).verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("AM")
		.verifyAddress(userProfile).reviewDetailsPageLL(userProfile)
		.clickChangeAppointment()
		.verifyCalendarPage()
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("PM")
		.reviewDetailsPageLL(userProfile)
		.clickChangeAppointment().verifyCalendarPage().verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("PM")
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_REASV_03*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void reschedASV12to2() {
			
		Report.createTestLogHeader(
				"Reschedule ASV -ASV Journey Test to select 12 to 2 slot ",
				"HomeCare200Account - TC_LDPH2_D2_REASV_03");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointments()
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrLL("12to2")
		.continueLandlordOverlay(1,"2Hr")
		.continueLandlord()
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.verifyAddress(userProfile)
		.verifyAddress(userProfile)
		.accountSummaryChange()
		.verifyAddress(userProfile).verifyAddressSAE(userProfile)
		.selectAnAppointment2HrLL("12to2")
		.verifyAddressIB(userProfile).reviewDetailsPageLL(userProfile)
		.navigateToConfirmationASV()
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_REASV_04*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void reschedASVirstSlotCOD() {
			
		Report.createTestLogHeader(
				"Reschedule ASV -ASV Journey Test - COD ",
				"HomeCare200Account - TC_LDPH2_D2_REASV_03");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointments()
		.verifyAddressSAE(userProfile)
		.selectFirstAvailable2HrLL()
		.continueLandlordOverlay(1,"2Hr")
		.continueLandlord()
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.accountSummaryChangeAppointment()
		.verifyAddress(userProfile).verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("AM")
		.verifyAddress(userProfile).reviewDetailsPageLL(userProfile)
		.clickChangeAppointment()
		.verifyCalendarPage()
		.verifyAddressSAE(userProfile)
		.selectFirstAvailable2HrIB()
		.reviewDetailsPageLL(userProfile)
		.clickChangeAppointment().verifyCalendarPage().verifyAddressSAE(userProfile)
		.selectFirstAvailable2HrIB()
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_REASV_06*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void reschedASVFFCOD() {
			
		Report.createTestLogHeader(
				"Reschedule ASV -ASV Journey Test - COD ",
				"HomeCare100Account - TC_LDPH2_D2_REASV_06");
		UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointments()
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdLL("FF")
		.continueLandlordOverlay(1,"2Hr")
		.continueLandlord()
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.accountSummaryChangeAppointment()
		.verifyAddress(userProfile).verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("FF")
		.verifyAddress(userProfile).reviewDetailsPageLL(userProfile)
		.clickChangeAppointment()
		.verifyCalendarPage()
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("FF")
		.reviewDetailsPageLL(userProfile)
		.clickChangeAppointment().verifyCalendarPage().verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("FF")
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_REASV_010*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void reschedASVDiffSlot() {
			
		Report.createTestLogHeader(
				"Reschedule ASV -ASV Journey Test to select Diff slot ",
				"HomeCare200Account - TC_LDPH2_D2_REASV_010");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointments()
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrLL("12to2")
		.continueLandlordOverlay(0,"2Hr")
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrLL("12to2")
		.continueLandlordOverlay(3, "NA")
		.continueLandlord()
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.verifyAddressIBPage(userProfile)
		.accountSummaryChange()
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrIB("12to2")
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_REASV_011*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void reschedASVSameSlot() {
			
		Report.createTestLogHeader(
				"Reschedule ASV -ASV Journey Test to select same slot ",
				"HomeCare200Account - TC_LDPH2_D2_REASV_011");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointments()
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrLL("12to2")
		.continueLandlordOverlay(1,"2Hr")
		.continueLandlord()
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.verifyAddressIBPage(userProfile)
		.accountSummaryChange()
		.verifyAddress(userProfile).verifyAddressSAE(userProfile)
		.selectAnAppointment2HrLL("12to2")
		.continueLandlordOverlay(1,"2Hr")
		.verifyAddressIB(userProfile)
		.reviewDetailsPageLL(userProfile)
		.clickChangeAppointment()
		.verifyCalendarPage()
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrLL("12to2")
		.continueLandlordOverlay(1,"2Hr")
		.verifyAddressIB(userProfile)
		.reviewDetailsPageLL(userProfile)
		.clickChangeAppointment().verifyCalendarPage().verifyAddressSAE(userProfile)
		.selectAnAppointment2HrLL("12to2")
		.continueLandlordOverlay(1,"2Hr")
		.verifyAddressIB(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * ------------------------------------------------------------------------------------End of Reschedule ASV Test Cases
	 */
	
	
	
	
	
	
	/*
	 * ------------------------------------------------------------------------------------Reschedule IB Test Cases
	 */

	/*
	 * *****************TC_LDPH2_D2_REBS1_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void reschedIBChangeAppointment() {
			
		Report.createTestLogHeader(
				"Reschedule A Breakdown -IB Journey Test to verify change appointment - 12 to 2 slot ",
				"HomeCare100Account - TC_LDPH2_D2_REBS1_01");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("12to2").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile)
		//.addCOD(userProfile)
		.navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentIB()
		.navigatePriorityPage(0)
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrIB("12to2")
		.reviewDetailsPageLL(userProfile)
		.clickChangeAppointment()
		.verifyCalendarPage()
		.clickCancel()
		.verifyAddressASVIB(userProfile)
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_REBS1_02*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void reschedIBEve() {
			
		Report.createTestLogHeader(
				"Reschedule A Breakdown -IB Journey Test - Evening slot ",
				"HomeCare200Account - TC_LDPH2_D2_REBS1_02");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("EVE").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentIB()
		.navigatePriorityPage(1)
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("EVE")
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_REBS1_03*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void reschedIBFirstSlot() {
			
		Report.createTestLogHeader(
				"Reschedule A Breakdown -IB Journey Test - First slot ",
				"HomeCare300Account - TC_LDPH2_D2_REBS1_03");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare300Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("EVE").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentIB()
		.navigatePriorityPage(1)
		.verifyAddressSAE(userProfile)
		.selectFirstAvailableStdIB()
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}
	 
	/*
	 * * *****************TC_LDPH2_D2_REBS1_04*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void reschedIB6to8() {
			
		Report.createTestLogHeader(
				"Reschedule A Breakdown -IB Journey Test - 6 to 8 slot ",
				"HomeCare200Account - TC_LDPH2_D2_REBS1_04");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(1, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("6to8").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentIB()
		.navigatePriorityPage(1)
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrIB("6to8")
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_REBS1_05*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void reschedIBChangeAppointmentEVE() {
			
		Report.createTestLogHeader(
				"Reschedule A Breakdown -IB Journey Test to verify change appointment - Evening slot ",
				"HomeCare200Account - TC_LDPH2_D2_REBS1_05");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("EVE").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentIB()
		.navigatePriorityPage(1)
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("EVE")
		.reviewDetailsPageLL(userProfile)
		.clickChangeAppointment()
		.verifyCalendarPage()
		.clickCancel()
		.verifyAddressASVIB(userProfile)
		.accountSummarycancelAppointment()
		.logout();
	}
	 
	/*
	 * * *****************TC_LDPH2_D2_REBS1_07*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void reschedIB6to8Ex() {
			
		Report.createTestLogHeader(
				"Reschedule A Breakdown -IB Journey Test - 6 to 8 slot ",
				"HomeCare200AccountEx - TC_LDPH2_D2_REBS1_07");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200AccountEx");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("6to8").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentIB()
		.navigatePriorityPage(1)
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrIB("6to8")
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}


	/*
	 * ------------------------------------------------------------------------------------End of Reschedule IB Test Cases
	 */

	

	/*
	 * ------------------------------------------------------------------------------------Reschedule IB BS2 Test Cases
	 */
	
	/*
	 * *****************TC_LDPH2_D2_REBS2_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void reschedIBFFBS2() {
			
		Report.createTestLogHeader(
				"Reschedule A Breakdown -IB Journey Test - FF slot ",
				"HomeCare400Account - TC_LDPH2_D2_REBS2_01");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("FF").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentIB()
		.navigatePriorityPage(0)
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("FF")
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_REBS1_02*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void reschedIBChangeAppointmentBS2COD() {
			
		Report.createTestLogHeader(
				"Reschedule A Breakdown -IB Journey Test to verify change appointment - 2 to 4 slot - COD",
				"HomeCare400Account - TC_LDPH2_D2_REBS1_02");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("2to4").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentIB()
		.navigatePriorityPage(0)
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrIB("2to4")
		.reviewDetailsPageLL(userProfile)
		.clickChangeAppointment()
		.verifyCalendarPage()
		.clickCancel()
		.verifyAddressASVIB(userProfile)
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * * *****************TC_LDPH2_D2_REBS1_03*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void reschedIB8to10BS2() {
			
		Report.createTestLogHeader(
				"Reschedule A Breakdown -IB Journey Test - 8 to 10 slot",
				"HomeCare400Account - TC_LDPH2_D2_REBS1_03");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("8to10").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentIB()
		.navigatePriorityPage(0)
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrIB("8to10")
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * * *****************TC_LDPH2_D2_REBS1_04*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void reschedIB8to10BS2COD() {
			
		Report.createTestLogHeader(
				"Reschedule A Breakdown -IB Journey Test - 8 to 10 slot - COD ",
				"HomeCare400Account - TC_LDPH2_D2_REBS1_04");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("8to10").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentIB()
		.navigatePriorityPage(1)
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrIB("8to10")
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * * *****************TC_LDPH2_D2_REBS1_05*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void reschedIB10to12BS2() {
			
		Report.createTestLogHeader(
				"Reschedule A Breakdown -IB Journey Test - 10 to 12 ",
				"HomeCare400Account - TC_LDPH2_D2_REBS1_05");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("10to12").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentIB()
		.navigatePriorityPage(1)
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrIB("10to12")
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************TC_LDPH2_D2_REBS1_06*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void reschedIBFirstSlotBS2() {
			
		Report.createTestLogHeader(
				"Reschedule A Breakdown -IB Journey Test - First slot ",
				"HomeCare400Account - TC_LDPH2_D2_REBS1_06");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("EVE").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentIB()
		.navigatePriorityPage(0)
		.verifyAddressSAE(userProfile)
		.selectFirstAvailableStdIB()
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}
		
	/*
	 * * *****************TC_LDPH2_D2_REBS1_08*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void reschedIB6to8BS2COD() {
			
		Report.createTestLogHeader(
				"Reschedule A Breakdown -IB Journey Test - 6 to 8 slot - COD ",
				"HomeCare400Account - TC_LDPH2_D2_REBS1_08");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("6to8").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentIB()
		.navigatePriorityPage(2)
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrIB("6to8")
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPage().changeAppointment(2).verifyAddressSAE(userProfile)
		.selectAnAppointment2HrIB("6to8").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentIB()
		.navigatePriorityPage(1)
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrIB("6to8")
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}
		
	/*
	 * ------------------------------------------------------------------------------------End of Reschedule IB Test Cases
	 */
	
	

	/*
	 * ------------------------------------------------------------------------------------CR Appliance Test Cases
	 */
	
	/*
	 * *****************CR_Appliance_TC_01*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void crApplianceCheckLi() {
			
		Report.createTestLogHeader(
				"CR Appliance -verify installation text - LI",
				"HomeCare100Account - CR_Appliance_TC_01");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.verifyAddressIB(userProfile)
		.verifyAddressLL(userProfile)
		.verifyInstallationText()
		.logout();
	}
	
	/*
	 * *****************CR_Appliance_TC_02*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void crApplianceCheckLig() {
			
		Report.createTestLogHeader(
				"CR Appliance -verify installation text - LIG",
				"HomeCare200Account - CR_Appliance_TC_02");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.verifyAddressIB(userProfile)
		.verifyAddressLL(userProfile)
		.verifyInstallationText()
		.logout();
	}

	/*
	 * *****************CR_Appliance_TC_03*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void crApplianceCheckReviewLi() {
			
		Report.createTestLogHeader(
				"CR Appliance -verify review appliance page  - LI",
				"HomeCare300Account - CR_Appliance_TC_03");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare300Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)		
		.verifyAddressSAE(userProfile)
		.navigateToASVStdSlotIB(userProfile)
		.verifyAddressLL(userProfile)
		.continueLandlord()
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentSAE()
		.selectAnAppointment2HrIB("8to10")
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmationASV()
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************CR_Appliance_TC_04*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void crApplianceReviewCheckLig() {
			
		Report.createTestLogHeader(
				"CR Appliance -verify review appliance page  - LIG",
				"HomeCare400Account - CR_Appliance_TC_04");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointments()
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdLL("AM")
		.continueLandlordOverlay(0,"Std")
		.continueLandlord()
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addGAC().navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummarycancelAppointment()
		.logout();
	}
	
	/*
	 * *****************CR_Appliance_TC_05*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void crApplianceFirstSlotReviewCheckLig() {
			
		Report.createTestLogHeader(
				"CR Appliance -verify review appliance page  - LIG - Flexi",
				"HomeCare100Account - CR_Appliance_TC_05");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointments()
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdLL("AM")
		.continueLandlordOverlay(0,"Std")
		.continueLandlord()
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addGAC().navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************CR_Appliance_TC_06*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void crApplianceReviewCheckViewSlotsLi() {
			
		Report.createTestLogHeader(
				"CR Appliance -verify review appliance page - view - LI - Flexi",
				"HomeCare200Account - CR_Appliance_TC_06");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointments()
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrLL("2to4")
		.continueLandlordOverlay(1,"2Hr")
		.continueLandlord()
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addGAC().navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************CR_Appliance_TC_07*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void CRcombASVIBKeepSlot() {
			
		Report.createTestLogHeader(
				"CR Appliance - Combining ASV  and IB -ASVIB Journey Test - LIG  ",
				"HomeCare300Account - CR_Appliance_TC_07");
		UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0)		
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrIB("8to10")	
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.bookAnEngineer(userProfile, "ASV")
		.changeAppointmentLL(1)
		.continueLandlordOverlay(3, "Std")
		.continueLandlord()
		.selectedAppChk(userProfile).verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************CR_Appliance_TC_11*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void CRcombIBASVDiffSlot() {
			
		Report.createTestLogHeader(
				"CR Appliance - Combining IB  and ASV -ASVIB Journey Test   ",
				"HomeServciesAccount - CR_Appliance_TC_11");
		UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)		
		.bookAnEngineerIB(userProfile, "ASV")
		.verifyAddressLL(userProfile)
		.continueLandlordOverlay(3, "2Hr")
		.continueLandlord()
		.selectedAppChk(userProfile).verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0)	
		.changeAppointment(1)
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrIB("10to12")	
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************CR_Appliance_TC_12*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void crReschedASV() {
			
		Report.createTestLogHeader(
				"Reschedule ASV -ASV Journey Test to select AM slot , Reschedule from status bar ",
				"HomeCare400Account - CR_Appliance_TC_12");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointments()
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdLL("AM")
		.continueLandlordOverlay(1,"Std")
		.continueLandlord()
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.accountSummaryChangeAppointment()
		.verifyAddress(userProfile).verifyAddressLL(userProfile)
		.continueLandlordOverlay(3, "Std")
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("AM")
		.verifyAddress(userProfile).reviewDetailsPageLL(userProfile)
		.navigateToConfirmation().confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************CR_Appliance_TC_13*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void crReschedIBEve() {
			
		Report.createTestLogHeader(
				"Reschedule A Breakdown -IB Journey Test - Evening slot ",
				"HomeCare200Account - CR_Appliance_TC_13");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("EVE").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummaryChangeAppointmentIB()
		.navigatePriorityPage(1)
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("EVE")
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************CR_Appliance_TC_14*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void crReviewAppASV() {
			
		Report.createTestLogHeader(
				"Review App ASV -ASV Journey Test to verify review appliance ",
				"HomeCare400Account - CR_Appliance_TC_14");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointments()
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrLL("12to2")
		.continueLandlordOverlay(1,"2Hr")
		.verifyReviewAppText()
		.logout();
	}

	/*
	 * *****************CR_Appliance_TC_15*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void crReviewAppHeatASV() {
			
		Report.createTestLogHeader(
				"Review App ASV -ASV Journey Test to verify review appliance Heating ",
				"HomeCare400Account - CR_Appliance_TC_15");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointments()
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdLL("AM")
		.continueLandlordOverlay(1,"Std")
		.verifyReviewAppTextHeating()
		.logout();
	}

	/*
	 * *****************CR_Appliance_TC_33*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void crBs2App() {
			
		Report.createTestLogHeader(
				"CR appliance check to select Home Electric appliance and check review appliance page presence ",
				"HomeCare400Account - CR_Appliance_TC_33");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare400Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.clickFaultCategory("Electric", userProfile)
		.navigatePriorityPage(0).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("AllDay").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************CRM_IB_TC_21*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void crIbFFSlots() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to select FF slot from calendar Page ",
				"KAC - CRM_IB_TC_21");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("FF").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
		.accountSummarycancelAppointment()
		.logout();
	}


	/*
	 * *****************CRM_IB_TC_25*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void crIb2to4Slots() {
			
		Report.createTestLogHeader(
				"Book A Breakdown -IB Journey Test to select All Day slot from calendar Page ",
				"HomeCare100Account - CRM_IB_TC_25");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")
		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		.navigatePriorityPage(0).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("2to4").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * * *****************CRM_Reschedule IB_TC_31*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void crReschedIBIB6to8() {
			
		Report.createTestLogHeader(
				"Reschedule A Breakdown -IB Journey Test - 6 to 8 slot ",
				"HomeCare300Account - CRM_Reschedule IB_TC_31");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare300Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.clickFaultCategory("Gas", userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("6to8").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.clickFaultCategory("Gas", userProfile)
		.navigatePriorityPage(1).changeAppointment(2).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointment2HrIB("6to8").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).addCOD(userProfile).confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.viewDetails()
		.accountSummaryChangeAppointmentIB()
		.navigatePriorityPage(1)
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrIB("6to8")
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************CRM_RescheduleASV_TC_34*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void crReschedASV12to2() {
			
		Report.createTestLogHeader(
				"Reschedule ASV -ASV Journey Test to select 12 to 2 slot ",
				"HomeCare200Account - CRM_RescheduleASV_TC_34");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare200Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.navigateToViewAllAppointments()
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrLL("12to2")
		.continueLandlordOverlay(1,"2Hr")
		.continueLandlord()
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.accountSummaryChangeAppointment()
		.verifyAddress(userProfile).verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("AM")
		.verifyAddress(userProfile).reviewDetailsPageLL(userProfile)
		.clickChangeAppointment()
		.verifyCalendarPage()
		.verifyAddressSAE(userProfile)
		.selectAnAppointment2HrIB("12to2")
		.reviewDetailsPageLL(userProfile)
		.clickChangeAppointment().verifyCalendarPage().verifyAddressSAE(userProfile)
		.selectAnAppointment2HrIB("12to2")
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * ------------------------------------------------------------------------------------End of CR Appliance Test Cases
	 */
	
	
	
	
	/*
	 * ------------------------------------------------------------------------------------Email confirmation Test Cases
	 */
	
	/*
	 * *****************Confirmation_Email_03*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void emailCombIBFFDay() {
			
		Report.createTestLogHeader(
				"Combining Breakdown -IB Journey Test All Day slot ",
				"HomeCare300Account - Confirmation_Email_03");
UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare300Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		//.clickFaultCategory("Heating", userProfile)
		.navigatePriorityPage(1).verifyAddress(userProfile)
		.selectedAppChk(userProfile).verifyAddressSAE(userProfile)
		.verifyCalendarPageSAE().selectAnAppointmentStdIB("FF").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.navigateToIdentifyFault(0, userProfile)
		//.clickFaultCategory("Heating", userProfile)
		.navigatePriorityPage(1).changeAppointment(2).verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("FF").verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.verifyEmailConfirmationStatusIB(userProfile)
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * *****************Confirmation_Email_05*****************
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void emailCombASVIBEveSameSlot() {
			
		Report.createTestLogHeader(
				"Combining ASV  and IB -ASVIB Journey Test PM slot Same slot",
				"HomeCare100Account - Confirmation_Email_05");
		UserProfile userProfile = new TestDataHelper()
		.getUserProfile("HomeCare100Account");
		new HomePageAction()
		.navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
		.verifyAddressBook(userProfile)
		.firstAvailableSlot(userProfile)
		.bookAnEngineerIB(userProfile, "IV")		
		.verifyAddress(userProfile)
		.clickFaultCategory("Heating", userProfile)
		.navigatePriorityPage(0)		
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdIB("EVE")		
		.verifyAddress(userProfile)
		.reviewDetailsPageLL(userProfile).navigateToConfirmation().confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile).navigateTrackCancelChange()
		.bookAnEngineer(userProfile, "ASV")
		.changeAppointment(1).verifyAddressLL(userProfile)
		.continueLandlordOverlay(0,"Std")
		.verifyAddressSAE(userProfile)
		.selectAnAppointmentStdLL("EVE")
		.continueLandlord()
		.reviewDetailsPageLL(userProfile)
		.navigateToConfirmation()
		.verifyEmailConfirmationStatusIB(userProfile)
		.confirmationTotalChk(userProfile)
		.verifyAddressASVIB(userProfile)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/*
	 * ------------------------------------------------------------------------------------End of Email confirmation Test Cases
	 */
}
