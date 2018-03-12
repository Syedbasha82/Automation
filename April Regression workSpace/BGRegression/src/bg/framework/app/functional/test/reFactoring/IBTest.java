package bg.framework.app.functional.test.reFactoring;

import static bg.framework.app.functional.entities.FunctionalCategory.ASVIB;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;

import java.util.ArrayList;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.reFactoring.BookingCompleteAction;
import bg.framework.app.functional.action.reFactoring.IBAction;
import bg.framework.app.functional.action.selfServe.ASVIBAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.GlobalErrorMessages;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class IBTest extends TestBase {

	/*
	 * 
	 * BOOKING COMPLETE_TC_05 BookingComplete_TC_05 IB Journey with added COD
	 * 
	 */
	@Test(groups = { Regression })
	public void ibBookingCompleteWithCOD() {
		Report.createTestLogHeader(
				"Booking Complete - IB Journey Test - Book First - Added COD",
				"HomeServciesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"Ideal").verifyAddressBook(userProfile)
				.firstAvailableSlot(userProfile).bookAnEngineerIB(userProfile,
						"IV").verifyAddress(userProfile)
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(0).verifyAddress(userProfile)
				.selectedAppChk(userProfile).selectFirstAvailableSlot()
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.addCOD(userProfile).selectedAppChk(userProfile)
				.confirmationTotalChk(userProfile).verifyAddressASVIB(
						userProfile).navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * BookingComplete_TC_06 IB Journey combined with ASV - Keep appointment
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void BookingCompleteibBookingWithASVKeepAppointment() {
		Report
				.createTestLogHeader(
						"Booking Complete -ASV combined with IB Journey Test - View all slots - keep Appointment - Added COD",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "ASV")
				.reviewDetailsPage().addCOD(userProfile)
				.navigateTrackCancelChange()
				.verifyAccountOverview("ideal").bookAnEngineerIB(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(0).changeAppointment(2)
				.selectAnyAppointment().reviewDetailsPage(userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();

	}

	/*
	 * BookingComplete_TC_07 IB Journey combined with ASV - different slot
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithASVDifferentAppointment() {
		Report
				.createTestLogHeader(
						"Booking Complete -IB combined with ASV Journey Test - View all slots - Different Appointment",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").firstAvailableSlot(userProfile)
				.verifyAddressBook(userProfile).navigateToViewAllAppointments()
				.verifyAddressIB(userProfile).selectAnyAppointment()
				.verifyAddressBook(userProfile).reviewDetailsPage()
				.navigateToConfirmation().navigateTrackCancelChange()
				.verifyAccountOverview("ideal").verifyAddressBook(userProfile)
				.bookAnEngineer(userProfile, "IV").verifyAddressBook(
						userProfile).navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASVIB(0).changeAppointment(2)
				.verifyAddress(userProfile).selectedAppChk(userProfile)
				.selectAnyAppointment().reviewDetailsPage(userProfile)
				.navigateToConfirmation().confirmationTotalChk(userProfile)
				.verifyAddressBook(userProfile).navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();

	}

	/*
	 * BookingComplete_TC_08 IB Journey combined with Booked IB - Keep
	 * appointment
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void BookingCompleteibBookingWithBookedIBKeepAppointment() {
		Report
				.createTestLogHeader(
						"Booking Complete -IB combined with Booked IB Journey Test - Keep slots ",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").verifyAddressBook(userProfile)
				.bookAnEngineerIB(userProfile, "IV").verifyAddress(userProfile)
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(0).verifyAddress(userProfile)
				.selectAnyAppointment().verifyAddress(userProfile)
				.reviewDetailsPage(userProfile).selectedAppChk(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile)
				.confirmationTotalChk(userProfile)
				.verifyAddressBook(userProfile).navigateTrackCancelChangeIB()
				.verifyAddressASVIB(userProfile).bookAnEngineer(userProfile,
						"IV").verifyAddress(userProfile)
				.navigateToIdentifyFault(0, userProfile)
				.navigatePriorityPage(0).changeAppointment(1).verifyAddress(
						userProfile).reviewDetailsPage(userProfile).selectedAppChk(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile)
				.verifyAddressBook(userProfile)
				.navigateTrackCancelChange().verifyAddressASV(userProfile)
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * BookingComplete_TC_11 ASV Journey For - Keep appointment
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingForHomeCareFlexi() {
		Report.createTestLogHeader(
				"Booking Complete for IB Journey Test For HC Flexi",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").verifyAddressBook(userProfile)
				.bookAnEngineerIB(userProfile, "IV").verifyAddress(userProfile)
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(0).verifyAddress(userProfile)
				.selectAnyAppointment()
				.verifyAddress(userProfile)
				.reviewDetailsPage(userProfile)
				// .reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).verifyAddressBook(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();

	}

	// ------------------------------------------------------------------------------------------------------------------------

	/*
	 * CombiningBreakdownBS1_TC_18 CombineLink_TC_01 IB Journey combined with
	 * Booked IB - Keep appointment
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithBookedIBKeepAppointment() {
		Report
				.createTestLogHeader(
						"Combine Link -IB combined with Booked IB Journey Test - Keep slots - Different Appointment",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAddressBook(
						userProfile).bookAnEngineerIB(userProfile, "IV")
				.verifyAddress(userProfile).navigateToIdentifyFault(1,
						userProfile).navigatePriorityPage(0).verifyAddress(
						userProfile).selectAnAppointment("PM").verifyAddress(
						userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).verifyAddressBook(userProfile)
				.navigateTrackCancelChange().verifyAddressIB(userProfile).confirmationTotalChk(userProfile)
				.verifyAddressBook(userProfile)
				.bookAnEngineerIB(userProfile, "IV").verifyAddress(userProfile)
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(0).changeAppointment(1).verifyAddress(
						userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.navigateTrackCancelChange()				
				.verifyAddressASVIB(userProfile)
				.accountSummarycancelAppointment()
				.logout();
	}

	/*
	 * CombiningASV-Breakdown_TC_15 CombineLink_TC_02 IB Journey combined with
	 * ASV - Keep appointment
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithASVKeepAppointment() {
		Report
				.createTestLogHeader(
						"Combine Link -ASV combined with IB Journey Test - View all slots - keep Appointment - Added COD",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAddressBook(
						userProfile).bookAnEngineerIB(userProfile, "ASV")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile).addCODASVIB(userProfile)
				.navigateTrackCancelChangeIB().verifyAddressBook(userProfile)
				.verifyAddressBook(userProfile)
				.bookAnEngineerIB(userProfile, "IV").verifyAddress(userProfile)
				.navigateToIdentifyFault(0, userProfile)
				.navigatePriorityPage(0).changeAppointment(1).verifyAddress(
						userProfile).navigateToConfirmation().selectedAppChk(userProfile)
				.verifyAddressBook(userProfile).navigateTrackCancelChange()
				.verifyAddressBook(userProfile)
				.accountSummarycancelAppointment().logout();

	}

	// ------------------------------------------------------------------------------------------------------------------------

	/*
	 * BookABreakdown_TC_09,BookABreakdown_TC_12,BookABreakdown_TC_15,BookABreakdownBS2_TC_18,BookABreakdownBS2_TC_19,BookABreakdownBS2_TC_21,BookABreakdownBS2_TC_22
	 * ContactDetails_TC_05 IB Journey to check mobile number
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void contactDetailsIBHomeNumber() {
		Report.createTestLogHeader("Contact Details -IB - Check Home Number",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").verifyAddressBook(userProfile)
				.bookAnEngineerIB(userProfile, "IV").verifyAddress(userProfile)
				.navigateToIdentifyFault(0, userProfile)
				.navigatePriorityPage(0).verifyAddress(userProfile)
				.selectAnyAppointmentAsv().checkMobileNumber(userProfile)
				.logout();

	}

	// ------------------------------------------------------------------------------------------------------------------------

	/*
	 * BookABreakdown_TC_20,BookABreakdown_TC_09,BookABreakdown_TC_26 ALLDAY
	 * Slot_TC_01 IB Journey to check ALL DAY slots Preference slot should be
	 * turned ON GAS should be present
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibJourneyForPrefAllDaysSlotsGas() {
		Report.createTestLogHeader("All Day Slots-IB - Check slot timings",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		// new IBAction().runVBS(userProfile, "Preference");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").verifyAddressBook(userProfile)
				.bookAnEngineerIB(userProfile, "IV").verifyAddress(userProfile)
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(1).verifyAddress(userProfile)
				.selectAnAppointmentWeekDay("AllDay")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.verifySlot("AllDay").navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile)
				.verifySlotASVIB("AllDay").navigateTrackCancelChange()
				.verifySlotASVIB("AllDay").accountSummarycancelAppointment()
				.logout();
	}

	/*
	 * BookABreakdown_TC_17,BookABreakdown_TC_26 ALLDAY Slot_TC_02 IB Journey to
	 * check ALL DAY slots Preference slot should be turned OFF
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibJourneyForStdAllDaysSlots() {
		Report.createTestLogHeader(
				"All Day Slots-IB std slots - Check slot timings",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAddressBook(
						userProfile).verifyAccountOverview("ideal")
				.bookAnEngineerIB(userProfile, "IV").navigateToIdentifyFault(1,
						userProfile).navigatePriorityPage(0).verifyAddress(
						userProfile).selectAnAppointmentWeekDay("AllDay")
				.verifySlot("AllDay").verifyAddress(userProfile)
				.reviewDetailsPage(userProfile).navigateToConfirmation().selectedAppChk(userProfile)
				.confirmationTotalChk(userProfile)
				.verifySlot("AllDay").verifyAddressASVIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();
	}

	/*
	 * BookABreakdown_TC_20,BookABreakdown_TC_09,BookABreakdown_TC_26 ALLDAY
	 * Slot_TC_03 IB Journey to check ALL DAY slots Preference slot should be
	 * turned ON Elec should be present
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibJourneyForPrefAllDaysSlotsElec() {
		Report.createTestLogHeader(
				"All Day Slots-IB - Check slot timings - Elec appliance",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(1).verifyAddress(userProfile)
				.selectAnAppointmentWeekend("AllDay").verifySlot("AllDay")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation()
				.selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifySlot("AllDay")
				.verifyAddressIB(userProfile).navigateTrackCancelChange()
				.verifySlot("AllDay").verifyAddressIB(userProfile)
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * BookABreakdown_TC_29 ALLDAY Slot_TC_07 IB Journey to check ALL DAY slots
	 * on banking holiday n week days Preference slot should be turned ON Elec
	 * should be present 7th day in the slot should be a bank holiday
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibCombJourneyForPrefAllDaysSlotsGasBankHolidays() {
		Report
				.createTestLogHeader(
						"All Day Slots-IB booked on bank holidays - Check slot timings - Gas appliance",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(1).verifySlot("AllDay").verifyAddress(
						userProfile).selectAppointment("AllDay").verifySlot(
						"AllDay").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).navigateToConfirmation().selectedAppChk(userProfile)
						.confirmationTotalChk(userProfile).verifySlot(
						"AllDay").verifyAddressIB(userProfile).logoutReturn()
				.navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(1).changeAppointment(2)
				.selectAppointment("AllDay").verifySlot("AllDay")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifySlot("AllDay")
				.verifyAddressIB(userProfile).navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * BookABreakdown_TC_38 ALLDAY Slot_TC_06 IB Journey to check ALL DAY slots
	 * on bank holiday Preference slot should be turned ON GAS should be present
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibJourneyForPrefAllDaysSlotsGasBankHoliday() {
		Report
				.createTestLogHeader(
						"All Day Slots-IB booked on banking holiday - Check slot timings - Elec appliance",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(1).verifySlot("AllDay").verifyAddress(
						userProfile).selectAppointment("AllDay").verifySlot(
						"AllDay").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).navigateToConfirmation().selectedAppChk(userProfile)
						.confirmationTotalChk(userProfile).verifySlot(
						"AllDay").verifyAddressIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();
	}

	/*
	 * Combining ASV-Breakdown_TC_21 ALLDAY Slot_TC_09 IB Journey to check ALL
	 * DAY slots combined with ASV Preference slot should be turned ON 7TH day
	 * slot should be a bank holiday
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibCombASVJourneyForPrefAllDaysSlotsElec() {
		Report
				.createTestLogHeader(
						"All Day Slots-IB combined with ASV - Check slot timings - Elec appliance",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "ASV")
				.navigateToConfirmation(userProfile, 4)
				.navigateTrackCancelChange()/*.logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal")*/.bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(1).changeAppointment(2).verifySlot(
						"AllDay").verifyAddress(userProfile)
				.selectAnAppointmentWeekDay("AllDay").verifySlot("AllDay")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile)
				.confirmationTotalChk(userProfile).verifySlot("AllDay")
				.verifyAddressIB(userProfile).navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();
	}

	// ------------------------------------------------------------------------------------------------------------------------

	/*
	 * BookABreakdown_TC_19,BookABreakdownBS2_TC_21 FF Slot_TC_01 IB Journey to
	 * check FF slots Preference slot should be turned ON HC 100 Flexi customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibJourneyForPrefFFDaysSlotsHc100() {
		Report.createTestLogHeader(
				"FF Slots-IB - HC100 flexi - Check slot timings",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(1).verifySlot("FF").verifyAddress(
						userProfile).selectAppointment("FF").reviewDetailsPage(
						userProfile).verifySlot("FF")
				.verifyAddress(userProfile).navigateToConfirmation()
				.selectedAppChk(userProfile).confirmationTotalChk(userProfile)
				.verifySlot("FF").verifyAddressIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();
	}

	/*
	 * BookABreakdown_TC_08,BookABreakdownBS2_TC_21 FF Slot_TC_02 IB Journey to
	 * check FF slots Preference slot should be turned ON HC300 Flexi customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibJourneyForPrefFFDaysSlotsHc300() {
		Report.createTestLogHeader(
				"FF Slots-IB - HC 300 flexi - Check slot timings",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAddressBook(
						userProfile).verifyAccountOverview("ideal")
				.bookAnEngineerIB(userProfile, "IV").verifyAddress(userProfile)
				.navigateToIdentifyFault(1, userProfile).verifyAddress(
						userProfile).navigatePriorityPage(1).verifySlot("FF")
				.verifyAddress(userProfile).selectAppointment("FF").verifySlot(
						"FF").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).addCOD(userProfile).selectedAppChk(userProfile).verifySlot("FF")
				.verifyAddressIB(userProfile).navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * BookABreakdown_TC_26 FF Slot_TC_03 IB Journey to check FF slots
	 * Preference slot should be turned ON HC400 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibCombJourneyForPrefFFDaysSlotsHc400() {
		Report.createTestLogHeader(
				"FF Slots-IB Combined with IB - HC 400- Check slot timings",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1,userProfile)
				.navigatePriorityPageIB(0).selectAnyAppointment().reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile)
				.verifyAddressASVIB(userProfile)
				.navigateTrackCancelChange().logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineerIB(
						userProfile, "IV").navigateToIdentifyFault(1,
						userProfile).navigatePriorityPage(1).changeAppointment(
						2).verifySlot("FF").verifyAddress(userProfile)
				.selectAppointment("FF").verifySlot("FF").verifyAddress(
						userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile)
				.confirmationTotalChk(userProfile).verifySlot("FF").verifyAddressIB(
						userProfile).navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * BookABreakdown_TC_32 FF Slot_TC_05 IB Journey to check FF slots
	 * Preference slot should be turned ON HC100 customer Gas
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibJourneyForPrefFFDaysSlotsHc100Weekwend() {
		Report.createTestLogHeader(
				"FF Slots-IB - HC 100 - Check weekend slot ",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(1).verifySlot("FF").verifyAddress(
						userProfile).selectAnAppointmentWeekend("FF")
				.verifySlot("FF").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).verifySlot("FF")
				.verifyAddress(userProfile).navigateToConfirmation()
				.selectedAppChk(userProfile).confirmationTotalChk(userProfile)
				.verifyAddressASVIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();
	}

	// ------------------------------------------------------------------------------------------------------------------------

	/*
	 * BookABreakdown_TC_09 EVE Slot_TC_01 IB Journey to check EVE slots
	 * Preference slot should be turned ON HC 100 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibJourneyForPrefEveDaysSlotsHc100() {
		Report.createTestLogHeader("EVE Slots-IB - HC100 - Check slot timings",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(1).verifySlot("EVE").verifyAddress(
						userProfile).selectAppointment("EVE").verifySlot("EVE")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile)
				.confirmationTotalChk(userProfile).verifySlot("EVE").verifyAddressIB(
						userProfile).navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * BookABreakdown_TC_07 IB Journey to check AM slots Preference slot should
	 * be turned ON HC 100 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibJourneyForPrefAMDaysSlotsGACHc100() {
		Report.createTestLogHeader("AM Slots-IB - HC100 - Check slot timings",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").verifyAddressBook(userProfile)
				.bookAnEngineerIB(userProfile, "IV").verifyAddress(userProfile)
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(1).verifySlot("AM").verifyAddress(
						userProfile).selectAppointment("AM").verifySlot("AM")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.addGAC().verifySlot("AM").verifyAddressIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();
	}

	/*
	 * EVE Slot_TC_02 IB Journey to check EVE slots in weekdays Preference slot
	 * should be turned ON
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibJourneyForNoPrefEveDaysWeekDaysSlotsHc100() {
		Report.createTestLogHeader(
				"EVE Slots in weekdays-IB - HC100 - Check slot timings",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(1).verifySlot("EVE").verifyAddress(
						userProfile).selectAnAppointmentWeekDay("EVE")
				.verifySlot("EVE").verifyAddress(userProfile)
				.reviewDetailsPage(userProfile).navigateToConfirmation()
				.selectedAppChk(userProfile).confirmationTotalChk(userProfile)
				.verifySlot("EVE").verifyAddressIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();
	}

	/*
	 * BookABreakdown_TC_30 EVE Slot_TC_03 IB Journey to check EVE slots
	 * Preference slot should be turned ON HEC product
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibJourneyForNoPrefEveDaysWeekendSlotsHc100() {
		Report.createTestLogHeader(
				"No EVE Slots in weekend-IB - HC100 - Check slot timings",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(1).verifySlot("EVE").verifyAddress(
						userProfile).selectAnAppointmentWeekend("EVE")
				.verifySlot("EVE").verifyAddress(userProfile)
				.reviewDetailsPage(userProfile).navigateToConfirmation()
				.selectedAppChk(userProfile).confirmationTotalChk(userProfile)
				.verifySlot("EVE").verifyAddressIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();
	}

	/*
	 * BookABreakdownBS2_TC_29 EVE Slot_TC_05 IB Journey to check No EVE slots
	 * Preference slot should be turned ON Hc 400 flexi
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibJourneyForStdNoEveSlots() {
		Report.createTestLogHeader("No Eve Slots-IB - Check slot timings",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(0).verifySlot("EVE").verifyAddress(
						userProfile).selectNoAppointmentASV("EVE").logout();
	}

	/*
	 * CombiningBreakdownBS1_TC_18 EVE Slot_TC_08 IB Journey to check No EVE
	 * slots Preference slot should be turned ON Hc 400 flexi
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibCombJourneyForPrefEveSlots() {
		Report.createTestLogHeader(
				"Eve Slots available-IB combined slots- Check slot timings",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineerIB(
						userProfile, "IV").navigateToIdentifyFault(1,
						userProfile).navigatePriorityPage(1).verifySlot("EVE")
				.verifyAddress(userProfile).selectAppointment("EVE")
				.reviewDetailsPage(userProfile).navigateToConfirmation()
				.selectedAppChk(userProfile).confirmationTotalChk(userProfile)
				.verifySlot("EVE").verifyAddressIB(userProfile).logoutReturn()
				.navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineerIB(
						userProfile, "IV").navigateToIdentifyFault(1,
						userProfile).navigatePriorityPage(1).changeAppointment(
						2).verifySlot("EVE").verifyAddress(userProfile)
				.selectAppointment("EVE").verifySlot("EVE").verifyAddress(
						userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation()
				.selectedAppChk(userProfile).confirmationTotalChk(userProfile)
				.verifySlot("EVE").verifyAddressIB(
						userProfile).navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();
	}

	// ------------------------------------------------------------------------------------------------------------------------

	/*
	 * BookABreakdown_TC_18,BookABreakdownBS2_TC_21 PM Slot_TC_01 IB Journey to
	 * check PM slots Preference slot should be turned ON HC 400 flexi customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibJourneyForPref2HRSlotsHc400F() {
		Report
				.createTestLogHeader(
						"PM Slots-IB standard booking- HC400 flexi - Check slot timings",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(0).verifySlot("PM").verifyAddress(
						userProfile).selectAnAppointmentWeekDay("PM")
				.verifySlot("PM").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).navigateToConfirmation()
						.selectedAppChk(userProfile).confirmationTotalChk(userProfile)
						.verifySlot(
						"PM").verifyAddressIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();
	}

	/*
	 * BookABreakdownBS2_TC_10,BookABreakdownBS2_TC_19 PM Slot_TC_02 IB Journey
	 * to check PM slots Preference slot should be turned ON HC 100 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibJourneyForPref2HRSlotsHc100() {
		Report
				.createTestLogHeader(
						"PM Slots-IB priority booking- HC400 flexi - Check slot timings",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(1).verifySlot("PM").verifyAddress(
						userProfile).selectAnAppointmentWeekDay("PM")
				.verifySlot("PM").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile)
						.verifySlot(
						"PM").verifyAddressIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();
	}

	/*
	 * BookABreakdown_TC_39 PM Slot_TC_03 IB Journey to check PM slots
	 * Preference slot should be turned ON HC 400 flexi customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibJourneyForStdPMSlotsHc400F() {
		Report
				.createTestLogHeader(
						"PM Slots weekend-IB std booking- HC400 flexi - Check slot timings",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Flexi");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(1).verifySlot("PM").verifyAddress(
						userProfile).selectAnAppointmentWeekend("PM")
				.verifySlot("PM").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).navigateToConfirmation()
						.selectedAppChk(userProfile).confirmationTotalChk(userProfile)
						.verifySlot(
						"PM").verifyAddressIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();
	}

	/*
	 * BookABreakdownBS2_TC_30 PM Slot_TC_06 IB Journey to check PM slots
	 * Preference slot should be turned ON HC 400 customer Elec customer
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibJourneyForPriorityPMSlotsHc400Elec() {
		Report
				.createTestLogHeader(
						"PM Slots -IB priority booking- HC400 flexi - Check slot timings",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(1).verifySlot("PMElec").verifyAddress(
						userProfile).selectAppointmentASV("PMElec").logout();
	}

	/*
	 * CombiningASV-Breakdown_TC_27 PM Slot_TC_09 IB Journey to check PM slots
	 * Preference slot should be turned ON HC 400 customer Elec customer
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibCombASVJourneyForPriorityPMSlotsHc100() {
		Report
				.createTestLogHeader(
						"PM Slots - ASV IB Combined -IB priority booking- HC100 - Check slot timings",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "ASV")
				.navigateToConfirmation(userProfile, 4)
				.navigateTrackCancelChange().logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(1).verifySlot("PM").verifyAddress(
						userProfile).selectAppointmentASV("PM").logout();
	}

	/*
	 * BookABreakdown_TC_40 PM Slot_TC_10 IB Journey to check PM slots
	 * Preference slot should be turned ON HC 400 customer Elec customer
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBS2JourneyForPriorityPMSlots() {
		Report.createTestLogHeader(
				"PM Slots - IB -IB priority booking - Check slot timings",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.verifyFaultPage().clickFaultCategory("Electric", userProfile)

				.navigatePriorityPage(1).verifySlot("PM").verifyAddress(
						userProfile).selectAppointment("PM").verifySlot("PM")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile)
				.verifySlot("PM").verifyAddress(
						userProfile).logout();
	}

	/*
	 * BookABreakdown_TC_41 PM Slot_TC_12 IB Journey to check PM slots
	 * Preference slot should be turned ON 7th day should be a bank holiday
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBankHolidayJourneyForPriorityPMSlots() {
		Report.createTestLogHeader(
						"PM Slots - IB Bank Holiday -IB priority booking - Check slot timings",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview("Ideal")
				.bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(1).verifySlot("PM").verifyAddress(
						userProfile).selectAppointment("PM").verifySlot("PM")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile)
				.verifyAddressASVIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.verifyAddress(
						userProfile).logout();
	}

	// ------------------------------------------------------------------------------------------------------------------------

	/*
	 * BookABreakdown_TC_15 2HR_TC_01 Slot_TC_01 IB Journey to check 2HR slots
	 * Priority slot should be turned ON HC 100 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibJourneyForPrior2HRSlotsHc1008to10() {
		Report
				.createTestLogHeader(
						"2HR Slots 8 to 10-IB standard booking- HC100 - Check slot timings",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(1).verifySlot("2HR8to10").verifyAddress(
						userProfile).selectAnAppointmentWeekDay("2HR8to10")
				.verifySlot("2HR8to10").verifyAddress(userProfile)
				.reviewDetailsPage(userProfile).navigateToConfirmation()
				.selectedAppChk(userProfile).confirmationTotalChk(userProfile)
				.verifySlot("2HR8to10").verifyAddressIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();
	}

	/*
	 * BookABreakdown_TC_12 2HR_TC_01 Slot_TC_01 IB Journey to check 2HR slots
	 * Priority slot should be turned ON HC 100 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibJourneyForPrior2HRSlotsHc2002to4() {
		Report
				.createTestLogHeader(
						"2HR Slots 2 to 4 -IB standard booking- HC200 - Check slot timings",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare200Account");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(1).verifySlot("2HR4to6").verifyAddress(
						userProfile).selectAnAppointmentWeekDay("2HR4to6")
				.verifySlot("2HR4to6").verifyAddress(userProfile)
				.reviewDetailsPage(userProfile).navigateToConfirmation()
				.selectedAppChk(userProfile).confirmationTotalChk(userProfile)
				.verifySlot("2HR4to6").verifyAddressIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();
	}

	/*
	 * BookABreakdown_TC_25 2HR_TC_01 Slot_TC_02 IB Journey to check 2HR slots
	 * Standard slot should be turned ON HC 100 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibJourneyForSTD2HRSlotsHc3008to10() {
		Report
				.createTestLogHeader(
						"2HR Slots 8 to 10-IB standard booking- HC300 - Check slot timings",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(0).verifySlot("2HR4to6").verifyAddress(
						userProfile).selectAnAppointmentWeekDay("2HR8to10")
				.verifySlot("2HR4to6").verifyAddress(userProfile)
				.reviewDetailsPage(userProfile).navigateToConfirmation()
				.selectedAppChk(userProfile).confirmationTotalChk(userProfile)
				.verifySlot("2HR4to6").verifyAddressIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();
	}

	/*
	 * BookABreakdown_TC_28 2HR_TC_01 Slot_TC_10 IB Journey to check 2HR slots
	 * Standard slot should be turned ON HC 100 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibJourneyForSTD2HRSlotsHc1004to6() {
		Report
				.createTestLogHeader(
						"2HR Slots 4 to 6-IB standard booking- HC100 - Check slot timings",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(0).verifySlot("2HR4to6").verifyAddress(
						userProfile).selectAnAppointmentWeekDayASV("2HR4to6")
				.logout();
	}

	/*
	 * BookABreakdownBS2_TC_24 2HR_TC_01 Slot_TC_11 IB Journey to check 2HR
	 * slots Standard slot should be turned ON HC 400 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibJourneyForPrior2HRSlotsHc4004to6() {
		Report
				.createTestLogHeader(
						"2HR Slots 4 to 6-IB Priority booking- HC400 - Check slot timings",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(0).verifySlot("2HR4to6").verifyAddress(
						userProfile).selectAnAppointmentWeekDayASV("2HR4to6")
				.logout();
	}

	/*
	 * BookABreakdownBS2_TC_25 2HR_TC_01 Slot_TC_12 IB Journey to check 2HR
	 * slots Standard slot should be turned ON HC 400 customer Business Sector 2
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibJourneyForPrior2BS2HRSlotsHc4004to6() {
		Report
				.createTestLogHeader(
						"2HR Slots 4 to 6 -IB Priority booking- HC400 - Check slot timings",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.verifyFaultPage().clickFaultCategory("Electric", userProfile)

				.navigatePriorityPage(1).verifySlot("2HR4to6").verifyAddress(
						userProfile).selectAnAppointmentWeekDayASV("2HR4to6")
				.logout();
	}

	/*
	 * BookABreakdownBS2_TC_27 2HR_TC_01 Slot_TC_13 IB Journey to check 2HR
	 * slots Priority slot should be turned ON
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibJourneyForPrior2HRSlotsHc100Weekend() {
		Report
				.createTestLogHeader(
						"2HR Slots Weekend-IB Priority booking- HC100 - Check slot timings",
						"Homecare 400 flexi");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Flexi");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(1).verifySlot("2HR4to6").verifyAddress(
						userProfile).selectAnAppointmentWeekendASV("2HR4to6")
				.verifySlot("2HR4to6").verifyAddress(userProfile)
				.reviewDetailsPage(userProfile).navigateToConfirmation()
				.selectedAppChk(userProfile).confirmationTotalChk(userProfile)
				.verifySlot("2HR4to6").verifyAddressIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();
	}

	/*
	 * BookABreakdown_TC_33 2HR_TC_01 Slot_TC_14 IB Journey to check 2HR slots
	 * Standard slot should be turned ON
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibJourneyForStd2HRSlotsHc100Weekend() {
		Report
				.createTestLogHeader(
						"2HR Slots Weekend-IB standard booking- HC100 - Check slot timings",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(0).verifySlot("2HR4to6").verifyAddress(
						userProfile).selectAnAppointmentWeekendASV("2HR4to6")
				.verifySlot("2HR4to6").verifyAddress(userProfile)
				.reviewDetailsPage(userProfile).navigateToConfirmation()
				.selectedAppChk(userProfile).confirmationTotalChk(userProfile)
				.verifySlot("2HR4to6").verifyAddressIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();
	}

	// ------------------------------------------------------------------------------------------------------------------------

	/*
	 * Combining_TC_01 IB Journey combined with Booked IB - Keep appointment
	 * Priority 'N' for both
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithBookedIBKeepAppointmentNoPrior() {
		Report
				.createTestLogHeader(
						"Combine Link -IB combined with Booked IB Journey Test No priority for both - Keep slots - Different Appointment",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1,userProfile).navigatePriorityPageIB(0)
				.selectAnyAppointment().reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.navigateTrackCancelChange()/*.logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV()*/.bookAnEngineerIB(userProfile,
						"IV").navigateToIdentifyFault(1,userProfile).navigatePriorityPage(0).changeAppointment(1)
				.reviewDetailsPage(userProfile).navigateToConfirmation()
				.selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment().logout();

	}

	/*
	 * Combining_TC_02 IB Journey combined with Booked IB - Keep appointment
	 * Priority 'N' for first and 'Y' for next
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithBookedIBKeepAppointment1stPriorY() {
		Report
				.createTestLogHeader(
						"Combine Link -IB combined with Booked IB Journey Test with 2nd has priority - Keep slots - Different Appointment",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineerIB(
						userProfile, "IV").navigateToIdentifyFault(1,
						userProfile).navigatePriorityPage(1)
				.selectAnyAppointment().reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile)
				.verifyAddressASVIB(userProfile)
				.navigateTrackCancelChange().bookAnEngineerIB(
						userProfile, "IV").navigateToIdentifyFault(1,
						userProfile).navigatePriorityPageASV(0)
				.changeAppointment(1).reviewDetailsPage()
				.navigateToConfirmation().navigateTrackCancelChange().accountSummarycancelAppointment().logout();

	}

	/*
	 * Combining_TC_03 IB Journey combined with Booked IB - Keep appointment
	 * Priority 'N' for first and 'Y' for next
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithBookedIBKeepAppointment2ndPriorY() {
		Report
				.createTestLogHeader(
						"Combine Link -IB combined with Booked IB Journey Test with 2nd has priority - Keep slots - Different Appointment",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1,userProfile)
				.navigatePriorityPageIB(0).selectAnyAppointment().reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.navigateTrackCancelChange().logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineerIB(
						userProfile, "IV").navigateToIdentifyFault(1,
						userProfile).navigatePriorityPageASV(1)
				.changeAppointment(1).reviewDetailsPage()
				.navigateToConfirmation().navigateTrackCancelChange().accountSummarycancelAppointment().logout();

	}

	/*
	 * Combining_TC_04 IB Journey combined with Booked IB - Keep appointment
	 * Priority 'Y' for both
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithBookedIBKeepAppointmentBothPriorY() {
		Report
				.createTestLogHeader(
						"Combine Link -IB combined with Booked IB Journey Test with both has priority - Keep slots - Different Appointment",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineerIB(
						userProfile, "IV").navigateToIdentifyFault(1,
						userProfile).navigatePriorityPage(1)
				.selectAnyAppointment().reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile)
				.verifyAddressASVIB(userProfile).logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineerIB(
						userProfile, "IV").navigateToIdentifyFault(1,
						userProfile).navigatePriorityPageASV(1)
				.changeAppointment(1).reviewDetailsPage()
				.navigateToConfirmation().navigateTrackCancelChange().logout();

	}

	/*
	 * Combining_TC_05 IB Journey combined with Booked IB - Diff appointment
	 * Priority 'N' for both
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithBookedIBDiffAppointmentNoPrior() {
		Report
				.createTestLogHeader(
						"Combine Link -IB combined with Booked IB Journey Test No priority for both - Keep slots - Different Appointment",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1,userProfile)
				.navigatePriorityPageIB(0).selectAnyAppointment().reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile)
				.verifyAddressASVIB(userProfile)
				.navigateTrackCancelChange()/*.logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV()*/.bookAnEngineerIB(userProfile,
						"IV").navigateToIdentifyFault(1,userProfile).navigatePriorityPage(0)
				.changeAppointment(2).selectAnyAppointment().reviewDetailsPage(userProfile)		
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile)
				.verifyAddressASVIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment().logout();

	}

	/*
	 * Combining_TC_06 IB Journey combined with Booked IB - Diff appointment
	 * Priority 'N' for first and 'Y' for next
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithBookedIBDiffAppointment2ndPriorY() {
		Report
				.createTestLogHeader(
						"Combine Link -IB combined with Booked IB Journey Test with 2nd has priority - Diff slots - Different Appointment",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1,userProfile).navigatePriorityPageIB(0)
				.selectAnyAppointment().reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile)
				.verifyAddressASVIB(userProfile)
				.navigateTrackCancelChange()
				/*.logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV()*/
				.bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1,userProfile).navigatePriorityPageASV(1)
				.changeAppointment(1).reviewDetailsPageIB()
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();

	}

	// ------------------------------------------------------------------------------------------------------------------------

	/*
	 * Cancel_TC_01 IB Journey
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void cancelIbBooking() {
		Report.createTestLogHeader("Cancel Appointment -IB Journey Test",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1,userProfile).navigatePriorityPageIB(0)
				.selectAnyAppointment().reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * Cancel_TC_03 IB Journey combined with Booked IB
	 * 
	 * 
	 */
	
	@Test(groups = { ASVIB, Regression })
	public void cancelIbBookingWithBookedIB() {
		Report.createTestLogHeader(
				"Cancel Appointment -IB combined with Booked IB Journey Test",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1,userProfile).navigatePriorityPageIB(0)
				.selectAnyAppointment().reviewDetailsPage(userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.navigateTrackCancelChange()/*.logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV()*/.bookAnEngineerIB(userProfile,
						"IV").navigateToIdentifyFault(1,userProfile)
				.navigatePriorityPage(0).changeAppointment(1)
				.reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();
	}

	/*
	 * BookingComplete_TC_06 IB Journey combined with ASV
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void CancelIbBookingWithASV() {
		Report.createTestLogHeader(
				"Cancel Appointment -ASV combined with IB Journey Test ",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "ASV")
				.reviewDetailsPage(userProfile).navigateToConfirmationASV()
				.navigateTrackCancelChange()/*.logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV()*/.bookAnEngineerIB(
						userProfile, "IV").navigateToIdentifyFault(1,
						userProfile).navigatePriorityPageASV(1)
				.changeAppointment(1).reviewDetailsPage()
				.navigateToConfirmation().navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();
	}

	// ------------------------------------------------------------------------------------------------------------------------

	/*
	 * RescheduleBreakdownBS1_TC_05 Rescheduling_TC_01 IB Journey combined with
	 * Booked IB with Priority 'N'
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void RescheduleIbBookingWithBookedIBWithPrior() {
		Report
				.createTestLogHeader(
						"Reschedule Appointment -IB combined with Booked IB Journey Test - ",
						"HomeServciesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(userProfile).navigateToReviewIB(1)
				.selectAnyAppointmentASV().navigateToConfirmation(userProfile,
						4).navigateTrackCancelChange().bookAnEngineerIB(
						userProfile, "IV").navigateToIdentifyFault(1,userProfile)
						.navigatePriorityPage(0)
				.changeAppointment(1).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).navigateTrackCancelChangeIB()
				.accountSummaryChange().navigatePriorityPage(2)
				.selectAnyAppointment().reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * Rescheduling_TC_02 IB Journey combined with ASV
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void rescheduleIbBookingWithASV() {
		Report
				.createTestLogHeader(
						"Rescheduling -ASV combined with IB Journey Test - With Priority ",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "ASV")
				.reviewDetailsPage(userProfile).navigateToConfirmation().verifyAddressASVIB(userProfile)
				//.addCODASVIB(userProfile)
				.navigateTrackCancelChange()
				/*.logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal")*/.bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1,userProfile).navigatePriorityPage(0)
				.changeAppointment(2).selectAnyAppointment().reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).navigateTrackCancelChange().viewDetails()
				.accountSummaryChangeAppointmentIB().navigatePriorityPage(2)
				.selectAnyAppointment().navigateToConfirmationASV().navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();

	}

	/*
	 * RescheduleBreakdownBS1_TC_24 Rescheduling_TC_03 IB Journey combined with
	 * Booked IB with Priority 'N'
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void RescheduleIbBookingWithBookedIBWithoutPrior() {
		Report
				.createTestLogHeader(
						"Reschedule Appointment -IB combined with Booked IB Journey Test - without priority ",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(1).selectAnyAppointment()
				.reviewDetailsPage(userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.logoutReturn().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineerIB(
						userProfile, "IV").navigateToIdentifyFault(1,
						userProfile).navigatePriorityPage(1).changeAppointment(2)
				.selectAnyAppointment().reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).navigateTrackCancelChangeIB()
				.accountSummaryChange().navigatePriorityPage(2)
				.selectAnyAppointment().navigateToConfirmationASV().navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();
	}

	/*
	 * RescheduleBreakdownBS1_TC_25 Rescheduling_TC_08 IB Journey combined with
	 * ASV with prior
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void rescheduleIbBookingWithASVWithoutPrior() {
		Report
				.createTestLogHeader(
						"Rescheduling -ASV combined with IB Journey Test - Without Priority ",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "ASV")
				.reviewDetailsPage(userProfile)
				.navigateToConfirmationASV().navigateTrackCancelChange()
			/*.logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV()*/.bookAnEngineerIB(
						userProfile, "IV").navigateToIdentifyFault(1,
						userProfile).navigatePriorityPage(1).changeAppointment(2)
				.selectAnyAppointment().reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).navigateTrackCancelChangeIB()
				.accountSummaryChange().navigatePriorityPage(0)
				.selectAnyAppointment().navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();

	}

	// ------------------------------------------------------------------------------------------------------------------------
	/*
	 * EV_TC_01 Home Care 100
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void emergencyMessageIBHc100() {
		Report.createTestLogHeader(
				"Reschedule Appointment -IB Journey Test - HomeCare 100",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.verifyEmergencyMessageASV(0).logout();
	}

	/*
	 * EV_TC_02 Home Care 200
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void emergencyMessageIBHc200() {
		Report.createTestLogHeader(
				"Reschedule Appointment -IB Journey Test - HomeCare 200",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare200Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(3).verifyEmergencyMessageASV(0).logout();
	}

	/*
	 * EV_TC_03 Home Care 300
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void emergencyMessageIBHc300() {
		Report.createTestLogHeader(
				"Reschedule Appointment -IB Journey Test - HomeCare 300",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(0).verifyEmergencyMessageASV(0).logout();
	}

	/*
	 * EV_TC_04 Home Care 400
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void emergencyMessageIBHc400() {
		Report.createTestLogHeader(
				"Reschedule Appointment -IB Journey Test - HomeCare 400",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(0).selectAnyAppointment()
				.verifyEmergencyMessageASV(4).logout();
	}

	// ------------------------------------------------------------------------------------------------------------------------
	/*
	 * PQ_01 PRIORITY_BOOKING_GAS_CONTROLS=ON PRIORITY_BOOKING_ELEC_CONTROLS=ON
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void oNOffIBBothOn() {
		Report.createTestLogHeader("ON/OFF Both Priority ON -IB Journey Test",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(3).verifyPriorityPageASV("1a").logout();
	}

	/*
	 * PQ_02 PRIORITY_BOOKING_GAS_CONTROLS=OFF
	 * PRIORITY_BOOKING_ELEC_CONTROLS=OFF Business Sector 2
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void oNOffIBBothOff() {
		Report.createTestLogHeader("ON/OFF Both Priority OFF -IB Journey Test",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(3).verifyPriorityPageASV("0").logout();
	}

	/*
	 * PQ_03 PRIORITY_BOOKING_GAS_CONTROLS=OFF PRIORITY_BOOKING_ELEC_CONTROLS=ON
	 * Business Sector 2
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void oNOffIBElecON() {
		Report.createTestLogHeader("ON/OFF Elec Priority ON -IB Journey Test",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(3).verifyPriorityPageASV("1b").logout();
	}

	/*
	 * PQ_04 PRIORITY_BOOKING_GAS_CONTROLS=ON PRIORITY_BOOKING_ELEC_CONTROLS=OFF
	 * Business Sector 2
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void oNOffIBGasON() {
		Report.createTestLogHeader("ON/OFF Gas Priority ON -IB Journey Test",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(3).verifyPriorityPageASV("1b").logout();
	}

	/*
	 * PQ_07
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void oNOffASVON() {
		Report.createTestLogHeader("ON/OFF -ASV Journey Test",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "ASV")
				.verifyPriorityPageASV("0").logout();
	}

	// ------------------------------------------------------------------------------------------------------------------------
	/*
	 * BookABreakdown_TC_25 SITE_TC_02 IB in SITE status
	 * 
	 */
	@Test(groups = { ASVIB })
	public void siteIB() {
		Report.createTestLogHeader("IB Site -IB Journey Test-",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverviewASV(
						"Site").logout();
	}

	// ------------------------------------------------------------------------------------------------------------------------
	/*
	 * BookABreakdown_TC_19 PEND_TC_04 ASV Combined with IB in PEND status
	 * 
	 */
	@Test(groups = { ASVIB })
	public void pendIB() {
		Report.createTestLogHeader("IB Pend -IB Journey Test-",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverviewASV(
						"Pend").logout();
	}

	// ------------------------------------------------------------------------------------------------------------------------
	/*
	 * BookABreakdown_TC_22 SCHED_TC_02 IB in Sched status
	 * 
	 */
	@Test(groups = { ASVIB })
	public void schedIB() {
		Report.createTestLogHeader("IB Sched -IB Journey Test-",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1,userProfile).navigatePriorityPageIB(0)
				.selectAnyAppointment().reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.navigateTrackCancelChange().logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverviewASV(
						"Sched").logout();
	}

	// ------------------------------------------------------------------------------------------------------------------------

	/*
	 * Questions_01,Questions_02,Questions_03,Questions_04,Questions_05,Questions_06,Questions_07,Questions_08
	 * Questions_02 HC 200 Customer
	 */
	@Test(groups = { ASVIB, Regression })
	public void questionIBHc400() {
		Report.createTestLogHeader("Question Hc 400-IB Journey Test",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.clickFaultCategory("Electrics", userProfile).verifyPriorityPageASV("1b").logout();
	}

	/*
	 * Questions_01,Questions_02,Questions_03,Questions_04,Questions_05,Questions_06,Questions_07,Questions_08
	 * Questions_01 HC 100 Customer
	 */
	@Test(groups = { ASVIB, Regression })
	public void questionIBHc100() {
		Report.createTestLogHeader("Question Hc 100-IB Journey Test",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(3).verifyPriorityPageASV("1a").logout();
	}

	// ------------------------------------------------------------------------------------------------------------------------
	/*
	 * BookABreakdown_TC_18 ROUTE_TC_02 IB in Route status
	 * 
	 */
	@Test(groups = { ASVIB })
	public void routeIB() {
		Report.createTestLogHeader("IB Route -IB Journey Test-",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverviewASV(
						"Route").logout();
	}

	// ------------------------------------------------------------------------------------------------------------------------
	/*
	 * BookABreakdown_TC_20 DISP_TC_04 IB in DISP status
	 * 
	 */
	@Test(groups = { ASVIB })
	public void dispIB() {
		Report.createTestLogHeader("IB DISP -IB Journey Test-",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverviewASV(
						"DISP").logout();
	}

	// ------------------------------------------------------------------------------------------------------------------------
	/*
	 * BookABreakdown_TC_24 HOLD_TC_02 IB in Hold status
	 * 
	 */
	@Test(groups = { ASVIB })
	public void holdIB() {
		Report.createTestLogHeader("IB Hold -IB Journey Test-",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverviewASV(
						"Hold").logout();
	}

	// ------------------------------------------------------------------------------------------------------------------------

	/*
	 * Others_01 IB Journey combined with Booked IB - change appointment
	 * Priority 'N' HC100
	 */
	@Test(groups = { ASVIB, Regression })
	public void othersIBChangeAppointmentHc100() {
		Report
				.createTestLogHeader(
						"Others -IB combined with Booked IB - HC100- Change Appointment",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineerIB(
						userProfile, "IV").navigateToIdentifyFault(1,
						userProfile).navigatePriorityPage(1)
				.selectAnyAppointment().reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineerIB(
						userProfile, "IV").navigateToIdentifyFault(1,
						userProfile).navigatePriorityPageASV(0)
				.changeAppointment(1).reviewDetailsPageIB()
				.clickChangeAppointment().checkCalendarPage().selectAnyAppointment()
				.reviewDetailsPage(userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();

	}

	/*
	 * Others_02 IB Journey combined with Booked IB - change appliance Priority
	 * 'N' HC200
	 */
	@Test(groups = { ASVIB, Regression })
	public void othersIBChangeApplianceHc200() {
		Report
				.createTestLogHeader(
						"Others -IB combined with Booked IB - HC200 - Change Appliance",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare200Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineerIB(
						userProfile, "IV").navigateToIdentifyFault(1,
						userProfile).navigatePriorityPage(1)
				.selectAnyAppointment().reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineerIB(
						userProfile, "IV").navigateToIdentifyFault(1,
						userProfile).navigatePriorityPageASV(0)
				.changeAppointment(1).reviewDetailsPageIB()
				.clickChangeAppliance().verifyFaultPage().navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(0).selectAnyAppointment().reviewDetailsPage(userProfile)				
				.reviewDetailsPage(userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();

	}

	// ------------------------------------------------------------------------------------------------------------------------

	/*
	 * BookABreakdown_TC_16 NA_TC_02 IB in NA1 status
	 * 
	 */
	@Test(groups = { ASVIB })
	public void na1IB() {
		Report.createTestLogHeader("IB NA1 -IB Journey Test-",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverviewASV(
						"NA1").logout();
	}

	// ------------------------------------------------------------------------------------------------------------------------

	/*
	 * BookAnASV_TC_18 ALLOC_TC_02 IB in ALLOC status
	 * 
	 */
	@Test(groups = { ASVIB })
	public void allocIB() {
		Report.createTestLogHeader("IB ALLOC -IB Journey Test-",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverviewASV(
						"ALLOC").logout();
	}

	// ------------------------------------------------------------------------------------------------------------------------
	/*
	 * Bookingjourney_TC_02 IB Journey with Booking Control Flag OFF
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingControls() {
		Report.createTestLogHeader("Booking Controls - IB Journey Test ",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1,userProfile)
						.navigatePriorityPageASV(0).selectAnAppointmentBookingCtrlOffIB()
				.reviewDetailsPage(userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.confirmationImageCheck().navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();
	}

	/*
	 * Bookingjourney_TC_10 ASV should be booked with Booking Controls ON Booked
	 * ASV should be in PEND status Booking Controls should be OFF
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibOffCombinedASVONBookingControls() {
		Report
				.createTestLogHeader(
						"Booking Controls - IB Journey Test with Booking controls Off - Combined with Booked ASV Booking controls ON",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1,userProfile).navigatePriorityPageASV(0)
				.selectAnAppointmentBookingCtrlOffIB().reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).confirmationImageCheck()
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();

	}

	/*
	 * Bookingjourney_TC_11 IB should be booked with Booking Controls ON Booked
	 * IB should be in PEND status Booking Controls should be OFF
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibOffCombinedIBONBookingControls() {
		Report
				.createTestLogHeader(
						"Booking Controls - IB Journey Test with Booking controls Off - Combined with Booked IB Booking controls ON",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1,userProfile).navigatePriorityPageASV(0)
				.selectAnAppointmentBookingCtrlOffIB().reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).confirmationImageCheck()
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();

	}

	// ------------------------------------------------------------------------------------------------------------------------
	/*
	 * StatusbarOnline_TC_02 IB Journey should be booked
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibStatusBarControls() {
		Report.createTestLogHeader("Status Bar Controls - IB Journey Test ",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV()
				.verifyAccountOverview("PEND").viewDetailsCompletePage(
						userProfile).logout();
	}

	// ------------------------------------------------------------------------------------------------------------------------
	/*
	 * ALLDAY Slot_TC_04 KAC should be there for the customer
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void allDayKAC() {
		Report.createTestLogHeader(
				"All day slot - KAC - Bank holiday weekend ",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(1).selectNoSlotWeekEndBankHoliday(
						"AllDay").logout();
	}

	// ------------------------------------------------------------------------------------------------------------------------

	/*
	 * ExcessBreakdown_TC_04 The user should be an OAM user. The user should
	 * have a BGS account. The scenario should be verified for a Homecare 300
	 * Excess account. The appointment should be booked for 6pm-8pm slot.
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingCancelFromView() {
		Report.createTestLogHeader(
				"IB - AM appointment - Homeservice 300 Excess account",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(userProfile).navigatePriorityPageIB(0)
				.verifyAddress(userProfile)
				.selectAnAppointment("AM").verifySlot("AM").verifyAddress(
						userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.verifySlot("AM").verifyAddressIB(
						userProfile).navigateTrackCancelChange()
				.viewDetailsCompletePage(userProfile).verifySlot("AM")
				.verifyAddressIB(userProfile)
				.accountSummarycancelAppointmentViewDetail().logout();

	}

	/*
	 * ExcessBreakdown_TC_14 The user should be an OAM user. The user should
	 * have a BGS account. The scenario should be verified for a Homecare 200
	 * Excess account. The appointment should be booked for FF slot.
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingCancel() {
		Report.createTestLogHeader(
				"IB - FF Slot appointment - Homeservice 200 Excess account",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare200Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(userProfile).navigatePriorityPageIB(0)
				.verifySlot("FF").verifyAddress(userProfile)
				.selectAnAppointment("FF").verifySlot("FF").verifyAddress(
						userProfile).reviewDetailsPage(userProfile).addGAC()
				.verifySlot("FF").verifyAddressIB(
						userProfile).navigateTrackCancelChange()
				.viewDetailsCompletePage(userProfile).verifySlot("FF")
				.verifyAddressIB(userProfile)
				.accountSummarycancelAppointmentViewDetail().logout();

	}

	/*
	 * ExcessBreakdown_TC_13 The user should be an OAM user. The user should
	 * have a BGS account. The scenario should be verified for a Homecare 300
	 * Excess account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingVerifyNavigation() {
		Report.createTestLogHeader(
				"IB - Verify Navigation Page - Homeservice 300 Excess account",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").verifyLinkNavigation("ASV").navigateBack()
				.verifyLinkNavigation("IB").navigateBack().logout();

	}

	/*
	 * ExcessBreakdown_TC_10 The user should be an OAM user. The user should
	 * have a BGS account. The scenario should be verified for a Homecare 100
	 * Excess account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingChangeFromReview() {
		Report
				.createTestLogHeader(
						"IB - Verify Changing appliance from review Page - Homeservice 100 Excess account",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1,userProfile)
				.navigatePriorityPageIB(1).selectAnyAppointment().clickChangeAppliance().verifyFaultPage()
				.logout();
	}

	/*
	 * ExcessBreakdown_TC_01 The user should be an OAM user. The user should
	 * have a BGS account. The scenario should be verified for a Homecare 100
	 * Excess account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingChangeFromReviewPrior() {
		Report
				.createTestLogHeader(
						"IB - Verify Change appointment from review Page - Homeservice 100 Excess account - Priority",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageIB(1).verifySlot(
						"AM").verifyAddress(userProfile).selectAnAppointment(
						"AM").verifySlot("AM").verifyAddress(userProfile)
				.clickChangeAppointment().verifyFaultPage().verifyAddress(
						userProfile).logout();
	}

	/*
	 * ExcessBreakdown_TC_02 The user should be an OAM user. The user should
	 * have a BGS account. The scenario should be verified for a Homecare 100
	 * Excess account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingChangeApplianceFromReviewPrior() {
		Report
				.createTestLogHeader(
						"IB - Verify Change appliance from review Page - Homeservice 100 Excess account - Priority",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASVIB(1).verifySlot("EVE").verifyAddress(
						userProfile).selectAnAppointment("EVE").verifySlot(
						"EVE").verifyAddress(userProfile)
				.clickChangeAppliance().verifyAddress(userProfile)
				.verifyFaultPage().logout();
	}

	/*
	 * ExcessBreakdown_TC_03 The user should be an OAM user. The user should
	 * have a BGS account. The scenario should be verified for a Homecare 300
	 * Excess account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingHC300PMSlotPrior() {
		Report.createTestLogHeader(
				"IB - PM slot - Homeservice 300 Excess account - Priority",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageIB(1).verifySlot(
						"PM").verifyAddress(userProfile).selectAnAppointment(
						"PM").verifySlot("PM").verifyAddress(userProfile)
				.reviewDetailsPage(userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.verifySlot("PM").verifyAddressIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();
	}

	/*
	 * ExcessBreakdown_TC_07 The user should be an OAM user. The user should
	 * have a BGS account. The scenario should be verified for a Homecare 100
	 * Excess account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingChangeFromReviewStd() {
		Report
				.createTestLogHeader(
						"IB - Verify Change appointment from review Page - Homeservice 100 Excess account - Standard",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageIB(0).verifySlot(
						"AM").verifyAddress(userProfile).selectAnAppointment(
						"AM").verifySlot("AM").verifyAddress(userProfile)
				.clickChangeAppointment().verifyAddress(userProfile)
				.verifyFaultPage().logout();
	}

	/*
	 * ExcessBreakdown_TC_08 The user should be an OAM user. The user should
	 * have a BGS account. The scenario should be verified for a Homecare 100
	 * Excess account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingChangeApplianceFromReviewStd() {
		Report
				.createTestLogHeader(
						"IB - Verify Change appliance from review Page - Homeservice 100 Excess account - Standard",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageIB(0).verifySlot(
						"10to12").verifyAddress(userProfile)
				.selectAnAppointment("10to12").verifySlot("10to12")
				.verifyAddress(userProfile).clickChangeAppliance()
				.verifyAddress(userProfile).verifyFaultPage().logout();
	}

	/*
	 * ExcessBreakdown_TC_09 The user should be an OAM user. The user should
	 * have a BGS account. The scenario should be verified for a Homecare 200
	 * Excess account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingHC2002to4Slot() {
		Report.createTestLogHeader(
				"IB - 2pm to 4pm slot - Homeservice 200 Excess account",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare200Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(userProfile)
				.navigatePriorityPageIB(1).verifyAddress(
						userProfile).selectAnAppointment("PM2to4").verifySlot(
						"PM2to4").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot(
						"PM2to4").verifyAddressIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();
	}

	/*
	 * ExcessBreakdown_TC_11 The user should be an OAM user. The user should
	 * have a BGS account. The scenario should be verified for a Homecare 300
	 * Excess account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingHC300PMSlot() {
		Report.createTestLogHeader(
				"IB - PM slot - Homeservice 300 Excess account",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(userProfile)
				.navigatePriorityPageIB(1).verifySlot("PM").verifyAddress(
						userProfile).selectAnAppointment("PM").verifySlot("PM")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("PM").verifyAddressIB(
						userProfile).navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * ExcessBreakdown_TC_12 The user should be an OAM user. The user should
	 * have a BGS account. The scenario should be verified for a Homecare 200
	 * Excess account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingHC200FirstSlot() {
		Report.createTestLogHeader(
				"IB - First Available slot - Homeservice 200 Excess account",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare200Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(userProfile)
				.navigatePriorityPageIB(0).selectAnyAppointment().reviewDetailsPage(
						userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();
	}

	/*
	 * ExcessBreakdown_TC_15 The user should be an OAM user. The user should
	 * have a BGS account. The scenario should be verified for a Homecare 200
	 * account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingHC200AmSlotGAC() {
		Report.createTestLogHeader(
				"IB - AM slot - Homeservice 200 account - GAC",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare200Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageIB(1).verifySlot(
						"AM").verifyAddress(userProfile).selectAnAppointment(
						"AM").verifySlot("AM").verifyAddress(userProfile)
				.reviewDetailsPage(userProfile).addGAC()
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("AM").verifyAddressIB(
						userProfile).navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();
	}

	// ------------------------------------------------------------------------------------------------------------------------

	/*
	 * Linking_TC_01 The user should be an OAM user. The user should have a BGS
	 * account. The scenario should be verified for a Homecare 300 Excess
	 * account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibLinkingVerifyNavigation() {
		Report.createTestLogHeader(
				"IB - Verify Navigation Page - Homeservice 300 Excess account",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").verifyLinkNavigation("ASV").navigateBack()
				.verifyLinkNavigation("IB").navigateBack().logout();

	}

	/*
	 * Linking_TC_02 IB Journey - Change Appointment HC300 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibLinkingChangeAppointmentFromReview() {
		Report
				.createTestLogHeader(
						"Linking -IB combined with IB Journey Test - Change Applicance From Review",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAddressBook(
						userProfile).bookAnEngineer(userProfile, "IV")
				.verifyAddressBook(userProfile).navigateToIdentifyFault(1,
						userProfile).navigatePriorityPageASV(0)
				.continueWithASV().verifySlot("AM").verifyAddress(userProfile)
				.selectAnAppointment("AM").verifySlot("AM").verifyAddress(
						userProfile).reviewDetailsPage(userProfile)
				.clickChangeAppointment().verifyAddress(userProfile)
				.verifyCalendarPageASVIB().logout();
	}

	/*
	 * Linking_TC_03 IB Journey combined with IB - Change Appliance HC200
	 * customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibLinkingChangeApplianceFromReview() {

		Report
				.createTestLogHeader(
						"Linking -IB combined with IB Journey Test - Change Appliance From Review",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAddressBook(
						userProfile).bookAnEngineer(userProfile, "IV")
				.verifyAddressBook(userProfile).navigateToIdentifyFault(1,
						userProfile).navigatePriorityPageASV(0)
				.continueWithASV().verifySlot("AM").verifyAddress(userProfile)
				.selectAnAppointment("AM").verifySlot("AM").verifyAddress(
						userProfile).reviewDetailsPage(userProfile)
				.clickChangeAppliance().verifyAddress(userProfile)
				.verifyFaultPage().logout();
	}

	/*
	 * Linking_TC_04 The user should be an OAM user. The user should have a BGS
	 * account. The scenario should be verified for a Homecare 200 account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibLinkingChangeFromCalendar() {
		Report
				.createTestLogHeader(
						"IB - Verify Changing appliance from review Page - Homeservice 200 account",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare200Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").verifyAddressBook(userProfile)
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASVIB(0).continueWithASVIB()
				.clickChangeAppliance().verifyAddress(userProfile)
				.verifyFaultPage().logout();
	}

	/*
	 * Linking_TC_05 IB Journey combined with IB - Change Appointment HC300
	 * customer Prioirity Booking
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibLinkingChangeAppointmentFromReviewPrior() {
		Report
				.createTestLogHeader(
						"Linking -IB combined with IB Journey Test - Change Appointment From Review - Prior",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAddressBook(
						userProfile).bookAnEngineer(userProfile, "IV")
				.verifyAddressBook(userProfile).navigateToIdentifyFault(1,
						userProfile).navigatePriorityPageASV(1)
				.continueWithASV().verifyAddress(userProfile).verifySlot("EVE")
				.verifyAddress(userProfile).selectAnAppointment("EVE")
				.verifySlot("EVE").verifyAddress(userProfile)
				.reviewDetailsPage(userProfile).clickChangeAppointment()
				.verifyAddress(userProfile).verifyCalendarPageASVIB().logout();

	}

	/*
	 * Linking_TC_06 IB Journey combined with IB - Change Appointment HC100
	 * customer Standard Booking
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibLinkingChangeApplianceFromReviewStd() {
		Report
				.createTestLogHeader(
						"Linking -IB combined with IB Journey Test - Change Applicance From Review - Prior",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAddressBook(
						userProfile).bookAnEngineer(userProfile, "IV")
				.verifyAddressBook(userProfile).navigateToIdentifyFault(1,
						userProfile).navigatePriorityPageASV(1)
				.continueWithASV().verifySlot("PMElec").verifyAddress(
						userProfile).verifyCalendarPage().selectAnAppointment(
						"PMElec").verifySlot("PMElec").verifyAddress(
						userProfile).clickChangeAppliance().verifyAddress(
						userProfile).verifyFaultPageASVIB().logout();

	}

	/*
	 * Linking_TC_07 The user should be an OAM user. The user should have a BGS
	 * account. The scenario should be verified for a Homecare 300 account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibLinkingASVdueGAC() {
		Report.createTestLogHeader(
				"IB - Link with ASV due - Homeservice 300 account",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAddressBook(
						userProfile).bookAnEngineer(userProfile, "IV")
				.verifyAddressBook(userProfile).navigateToIdentifyFault(1,
						userProfile).navigatePriorityPageASV(1)
				.continueWithASV().verifySlot("EVE").verifyAddress(userProfile)
				.selectAnAppointment("PM2to4").verifySlot("PM2to4")
				.verifyAddress(userProfile).verifyAddress(userProfile)
				.reviewDetailsPage(userProfile).verifySlot("PM2to4")
				.verifyAddress(userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.verifySlot("PM2to4").verifyAddressIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();

	}

	/*
	 * Linking_TC_08 The user should be an OAM user. The user should have a BGS
	 * account. The scenario should be verified for a Homecare 100 account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibLinkingASVdueCOD() {
		Report.createTestLogHeader(
				"IB - Link with ASV due - Homeservice 100 account",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
		// .getUserProfile("HomeCare100Account");
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAddressBook(
						userProfile).bookAnEngineer(userProfile, "IV")
				.verifyAddressBook(userProfile).navigateToIdentifyFault(1,
						userProfile).navigatePriorityPageASV(1)

				.continueWithASV().verifySlot("12to2").verifyAddress(
						userProfile).selectAnAppointment("12to2").verifySlot(
						"12to2").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).verifySlot("12to2").verifyAddress(
						userProfile).addCOD(userProfile).selectedAppChk(userProfile).verifySlot("12to2")
				.verifyAddress(userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();

	}

	/*
	 * Linking_TC_18 The user should be an OAM user. The user should have a BGS
	 * account. The scenario should be verified for a Homecare 300 account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibLinkingASVdueALLOCStatus() {
		Report
				.createTestLogHeader(
						"IB - Link with ASV due - AM Slot - ALLOC status - Homeservice 300 account",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAddressBook(
						userProfile).bookAnEngineer(userProfile, "IV")
				.verifyAddressBook(userProfile).navigateToIdentifyFault(1,
						userProfile).navigatePriorityPageASV(0)
				.continueWithASV().verifyAddress(userProfile).testHornors()/*
																			 * selectAnAppointment("AM").verifyAddress(userProfile)
																			 * .reviewDetailsPage(userProfile).navigateToConfirmationBooking()
																			 * .verifyAddressBook(userProfile).navigateTrackCancelChange().verifyAccountOverviewASV("ALLOC")
																			 * .accountSummarycancelAppointment().logout()
																			 */;

	}

	/*
	 * Linking_TC_19 The user should be an OAM user. The user should have a BGS
	 * account. The scenario should be verified for a Homecare 100 account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibLinkingASVdueHOLDStatus() {
		Report
				.createTestLogHeader(
						"IB - Link with ASV due - AllDay Slot - HOLD status - Homeservice 300 account",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1,userProfile).navigatePriorityPageASV(0)
				.continueWithASV().verifySlot("AM")
				.verifyAddress(userProfile).selectAnAppointment("AM")
				.verifySlot("AM").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).navigateToConfirmation().verifyAddress(
						userProfile).verifySlotASVIB("AM")
				.navigateTrackCancelChangeBook().verifyAccountOverviewASV(
						"Hold").accountSummarycancelAppointment().logout();

	}

	/*
	 * Linking_TC_20 The user should be an OAM user. The user should have a BGS
	 * account. The scenario should be verified for a Homecare 300 account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibLinkingASVdueSITEStatus() {
		Report
				.createTestLogHeader(
						"IB - Link with ASV due - AllDay Slot - SITE status - Homeservice 300 account",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(userProfile)
				.navigateToReviewBook(1).continueWithASV().verifyAddress(
						userProfile).verifySlot("AllDay").selectAnAppointment(
						"AllDay").verifyAddress(userProfile).verifySlot(
						"AllDay").reviewDetailsPage(userProfile)
				.navigateToConfirmation().verifyAddress(userProfile)
				.verifySlotASVIB("AllDay").navigateTrackCancelChangeBook()
				.verifyAccountOverviewASV("Site")
				.accountSummarycancelAppointment().logout();

	}

	/*
	 * Linking_TC_21 The user should be an OAM user. The user should have a BGS
	 * account. The scenario should be verified for a Homecare 100 account. Asv
	 * should be overdue
	 */

	@Test(groups = { ASVIB, Regression })
	public void ibJourneyToJoinASVOverdue() {
		Report.createTestLogHeader("Linking - Join ASV Overdue with IB",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin();

		new ASVIBAction().loginUser(userProfile).navigateToAccountSummaryPage(
				userProfile).bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1,userProfile).navigatePriorityPageASV(0)
				.continueWithASVIB().verifySlot("AM")
				.verifyAddress(userProfile).selectAnAppointment("AM")
				.verifySlot("AM").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot(
						"AM").verifyAddressIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();

	}

	/*
	 * Linking_TC_24 The user should be an OAM user. The user should have a BGS
	 * account. The scenario should be verified for a Homecare 100 account. Asv
	 * should be overdue Hc200
	 */

	@Test(groups = { ASVIB, Regression })
	public void ibJourneyToJoinASVOverdueCOD() {
		Report.createTestLogHeader(
				"Linking - Join ASV Overdue with IB - Add COD",
				"HomeServciesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare200Account");
		new HomePageAction().navigateToLogin();
		new ASVIBAction().loginUser(userProfile).navigateToAccountSummaryPage(
				userProfile).bookAnEngineerIB(userProfile, "IV")
				.navigateToIdentifyFault(1,userProfile).navigatePriorityPageASV(0)
				.continueWithASVIB().verifySlot("PMElec").verifyAddress(
						userProfile).selectAnAppointment("PMElec").verifySlot(
						"PMElec").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).addCOD(userProfile).selectedAppChk(userProfile).verifySlot(
						"PMElec").verifyAddressIB(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();

	}

	/*
	 * Linking_TC_25 The user should be an OAM user. The user should have a BGS
	 * account. The scenario should be verified for a Homecare 200 account. Asv
	 * should be overdue Hc100
	 */

	@Test(groups = { ASVIB, Regression })
	public void ibJourneyToJoinASVOverdueGac() {
		Report.createTestLogHeader(
				"Linking - Join ASV Overdue with IB - Add GAC",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASVIB(1).continueWithASVIB().verifySlot(
						"EVE").verifyAddress(userProfile).selectAnAppointment(
						"EVE").verifySlot("EVE").verifyAddress(userProfile)
				.reviewDetailsPage(userProfile).addGAC()
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("EVE").verifyAddressIB(
						userProfile).navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();

	}

	/*
	 * // * Linking_TC_26 The user should be an OAM user. The user should have a
	 * BGS account. The scenario should be verified for a Homecare 100 account.
	 * Asv should be overdue Hc100
	 */

	@Test(groups = { ASVIB, Regression })
	public void ibJourneyToJoinASVOverdueAllDay() {
		Report.createTestLogHeader("Linking - Join ASV Overdue with IB ",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASVIB(0).continueWithASVIB().verifySlot(
						"AllDay").verifyAddress(userProfile)
				.selectAnAppointment("AllDay").verifySlot("AllDay")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("AllDay")
				.verifyAddressIB(userProfile).navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();

	}

	/*
	 * Linking_TC_27 The user should be an OAM user. The user should have a BGS
	 * account. The scenario should be verified for a Homecare 100 account. Asv
	 * should be overdue Hc100
	 */

	@Test(groups = { ASVIB, Regression })
	public void ibJourneyToJoinASVOverdue12to2() {
		Report.createTestLogHeader("Linking - Join ASV Overdue with IB ",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASVIB(1).continueWithASVIB().verifySlot(
						"12to2").verifyAddress(userProfile)
				.selectAnAppointment("12to2").verifySlot("12to2")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("12to2")
				.verifyAddressIB(userProfile).navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();

	}

	// ------------------------------------------------------------------------------------------------------------------------
	/*
	 * BookABreakdown_TC_01 The user should be an OAM user. The user should have
	 * a BGS account. The scenario should be verified for a Homecare 100
	 * account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookBreakdownVerifyNavigationHc100() {
		Report.createTestLogHeader(
				"IB - Verify Navigation Page - Homeservice 100 account",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").verifyAddressBook(userProfile)
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageIB(1).verifyAddress(userProfile)
				.verifySlot("AM").verifyAddress(userProfile)
				.selectAnAppointment("AM").verifySlot("AM").verifyAddress(
						userProfile).clickChangeAppointment().verifyAddress(
						userProfile).verifyCalendarPage().logout();
	}

	/*
	 * BookABreakdown_TC_02 The user should be an OAM user. The user should have
	 * a BGS account. The scenario should be verified for a Homecare 200
	 * account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookBreakdownVerifyNavigationHc200() {
		Report.createTestLogHeader(
				"IB - Verify Navigation Page - Homeservice 200 account",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare200Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAddressBook(
						userProfile).bookAnEngineer(userProfile, "IV")
				.verifyAddressBook(userProfile).navigateToIdentifyFault(1,
						userProfile).navigatePriorityPageIB(1)
				.verifySlot("EVE").verifyAddress(userProfile)
				.selectAnAppointment("EVE").verifySlot("EVE").verifyAddress(
						userProfile).clickChangeAppliance().verifyAddress(
						userProfile).verifyFaultPage().logout();
	}

	/*
	 * BookABreakdown_TC_04 The user should be an OAM user. The user should have
	 * a BGS account. The scenario should be verified for a Homecare 200
	 * account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookBreakdownVerifyNavigationHc200Std() {
		Report
				.createTestLogHeader(
						"IB - Verify Navigation Page - Homeservice 200 account - No Priority",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare200Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAddressBook(
						userProfile).bookAnEngineer(userProfile, "IV")
				.verifyAddressBook(userProfile).navigateToIdentifyFault(1,
						userProfile).navigatePriorityPageIB(0).verifySlot("PM")
				.verifyAddress(userProfile).selectAnAppointment("PM")
				.verifySlot("EVE").verifyAddress(userProfile)
				.clickChangeAppliance().verifyFaultPage().verifyAddress(
						userProfile).logout();
	}

	/*
	 * BookABreakdown_TC_06 The user should be an OAM user. The user should have
	 * a BGS account. The scenario should be verified for a Homecare 300 Excess
	 * account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookBreakdownVerifyNavigation() {
		Report.createTestLogHeader(
				"IB - Verify Navigation Page - Homeservice 300 account",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAddressBook(
						userProfile).verifyLinkNavigation("ASV").navigateBack()
				.verifyLinkNavigation("IB").navigateBack().logout();

	}

	/*
	 * BookABreakdown_TC_13 The user should be an OAM user. The user should have
	 * a BGS account.
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookBreakdownFirstSlotinCalendarGAC() {
		Report.createTestLogHeader("IB - Alloc status - Standard slot",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(0)

				.selectFirstAvailableSlot().reviewDetailsPage()
				.navigateToConfirmation().navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * BookABreakdown_TC_23 The user should be an OAM user. The user should have
	 * a BGS account. The scenario should be verified for a Homecare 300
	 * account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void AllocStatusIB() {
		Report.createTestLogHeader(
				"IB - Alloc status - Homeservice 300 account",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineerIB(userProfile,
						"IV").navigateToIdentifyFault(1,userProfile).navigatePriorityPageASV(0)
				.continueWithASV().verifySlot("AM")
				.verifyAddress(userProfile).selectAnAppointment("AM")
				.verifySlot("AM").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot(
						"AM").verifyAddressIB(userProfile)
				.navigateTrackCancelChangeBook().verifyAccountOverviewASV(
						"ALLOC").accountSummarycancelAppointment().logout();

	}

	/*
	 * BookABreakdown_TC_31 The user should be an OAM user. The user should have
	 * a BGS account. The scenario should be verified for a Homecare 100
	 * account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibJourneyForEveDaysSlotsHc100() {
		Report.createTestLogHeader("IB - Eve slot - Homeservice 100 account",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineerIB(
						userProfile, "IV").navigateToIdentifyFault(0,
						userProfile).navigatePriorityPage(1).verifySlot("EVE")
				.verifyAddress(userProfile).selectAnAppointment("EVE")
				.verifySlot("EVE").verifyAddress(userProfile)
				.reviewDetailsPage(userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.verifySlot("EVE").verifyAddressIB(userProfile)
				.navigateTrackCancelChangeBook()
				.verifyAccountOverviewASV("EVE").viewDetailsBook()
				.verifyAccountOverviewASV("EVE")
				.accountSummarycancelAppointment().logout();

	}

	// ------------------------------------------------------------------------------------------------------------------------

	// -------------------------------------------------------------------------------------------------------------------
	/*
	 * BookABreakdownBS2_TC_12 The user should be an OAM user. The user should
	 * have a BGS account. The scenario should be verified for a Homecare 400
	 * account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookABreakdownBS2ALLOCStatus() {
		Report
				.createTestLogHeader(
						"IB - Book A Breakdown BS2 - AllDay Slot - ALLOC status - Homeservice 400 account",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineerIB(
						userProfile, "IV").clickFaultCategory("Electric",
						userProfile)

				.navigatePriorityPageBook(1).navigateToReviewIB(1).verifySlot(
						"AllDay").verifyAddress(userProfile)
				.selectAnAppointment("AllDay").verifySlot("AllDay")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("AllDay")
				.verifyAddressIB(userProfile).navigateTrackCancelChangeBook()
				.verifyAccountOverviewASV("ALLOC")
				.accountSummarycancelAppointment().logout();

	}

	/*
	 * BookABreakdownBS2_TC_17 The user should be an OAM user. The user should
	 * have a BGS account. The scenario should be verified for a Homecare 400
	 * account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookABreakdownBS2COMPStatus() {
		Report
				.createTestLogHeader(
						"IB - Book A Breakdown BS2 - AM Slot - ALLOC status - Homeservice 400 account",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineerIB(
						userProfile, "IV").clickFaultCategory("Electric",
						userProfile)

				.navigatePriorityPageBook(1).navigateToReviewIB(1).verifySlot(
						"AM").verifyAddress(userProfile).selectAnAppointment(
						"AM").verifySlot("AM").verifyAddress(userProfile)
				.reviewDetailsPage(userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.verifySlot("AM").verifyAddressIB(userProfile)
				.navigateTrackCancelChangeBook().verifyAccountOverviewASV(
						"Comp").accountSummarycancelAppointment().logout();

	}

	/*
	 * BookABreakdownBS2_TC_07 The user should be an OAM user. The user should
	 * have a BGS account. The scenario should be verified for a Homecare 400
	 * account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookBreakdownBS2VerifyNavigation() {
		Report.createTestLogHeader(
				"IB - Verify Navigation Page - Homeservice 400 Excess account",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyLinkNavigation(
						"AccOverviewASV").navigateBack().verifyLinkNavigation(
						"AccOverviewIB").navigateBack().logout();

	}

	/*
	 * BookABreakdownBS2_TC_16 The user should be an OAM user. The user should
	 * have a BGS account. The scenario should be verified for a Homecare 400
	 * account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookABreakdownBS2SCHEDStatus() {
		Report
				.createTestLogHeader(
						"IB - Book A Breakdown BS2 - PM Slot - SCHED status - Homeservice 400 account",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineerIB(
						userProfile, "IV").clickFaultCategory("Electric",
						userProfile)

				.navigatePriorityPageBook(2).navigateToReviewIB(1).verifySlot(
						"PM").verifyAddress(userProfile).selectAnAppointment(
						"PM").verifySlot("PM").verifyAddress(userProfile)
				.reviewDetailsPage(userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.verifySlot("PM").verifyAddressIB(userProfile)
				.navigateTrackCancelChangeBook().verifyAccountOverviewASV(
						"Sched").accountSummarycancelAppointment().logout();
	}

	/*
	 * BookABreakdownBS2_TC_01 The user should be an OAM user. The user should
	 * have a BGS account. The scenario should be verified for a Homecare
	 * account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookBreakdownVerifyNavigationBS2EVE() {
		Report.createTestLogHeader(
				"IB - Verify Navigation Page - Evening Slot",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1).verifyAddressIB(userProfile)
				.verifySlot("EVE").selectAnAppointment("EVE").verifySlot("EVE")
				.verifyAddress(userProfile).clickChangeAppointment()
				.verifyAddress(userProfile).verifyCalendarPage().logout();
	}

	/*
	 * BookABreakdownBS2_TC_02 The user should be an OAM user. The user should
	 * have a BGS account. The scenario should be verified for a Homecare
	 * account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookBreakdownVerifyNavigationBS2FF() {
		Report.createTestLogHeader("IB - Verify Navigation Page - FF slot",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1).navigateToReviewIB(1).verifySlot(
						"FF").verifyAddress(userProfile).selectAnAppointment(
						"FF").verifySlot("FF").verifyAddress(userProfile)
				.clickChangeAppliance().verifyAddress(userProfile)
				.verifyCalendarPage().logout();
	}

	/*
	 * BookABreakdownBS2_TC_04 The user should be an OAM user. The user should
	 * have a BGS account. The scenario should be verified for a Homecare
	 * account.
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookBreakdownVerifyNavigationBS2EVEStd() {
		Report.createTestLogHeader(
				"IB - Verify Navigation Page - Evening Slot - Standard",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(0).navigateToReviewIB(1).verifySlot(
						"EVE").verifyAddress(userProfile).selectAnAppointment(
						"EVE").verifySlot("FF").verifyAddress(userProfile)
				.clickChangeAppointment().verifyAddress(userProfile)
				.verifyCalendarPage().logout();
	}

	// -------------------------------------------------------------------------------------------------------------------
	/*
	 * CombiningBreakdownBS1_TC_01 IB Journey combined with IB - different slot
	 * HC100 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbChangeApplianceBS1Hc100() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS1 -IB combined with IB Journey Test - Verify change appliacnce link -Hc100 ",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageIB(1).verifySlot("AM").verifyAddress(
						userProfile).selectAnAppointment("AM").verifySlot("AM")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("AM")
				.verifyAddressASVIB(userProfile).logoutReturn()
				.navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1)

				.changeAppointmentIB(2).verifyCalendarPage()
				.clickChangeAppliance().verifyAddress(userProfile)
				.verifyFaultPageASVIB().logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV()
				.accountSummarycancelAppointment().logout();

	}

	/*
	 * CombiningBreakdownBS1_TC_02 IB Journey combined with IB - different slot
	 * HC200 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbChangeApplianceBS1HC200() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS1 -IB combined with IB Journey Test - Verify change appliacnce link -Hc200 ",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare200Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageIB(1).verifySlot("10to12").verifyAddress(
						userProfile).selectAnAppointment("10to12").verifySlot(
						"10to12").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot(
						"10to12").verifyAddressASVIB(userProfile)
				.logoutReturn().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1)

				.changeAppointmentIB(2).verifyCalendarPage()
				.clickChangeAppliance().verifyFaultPageASVIB().logoutReturn()
				.navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV()
				.accountSummarycancelAppointment().logout();

	}

	/*
	 * CombiningBreakdownBS1_TC_03 IB Journey combined with IB - different slot
	 * HC300 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbChangeApplianceBS1HC300() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS1 -IB combined with IB Journey Test - Verify change appointment link -Hc300 ",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1).verifyAddressIB(userProfile)
				.selectAnAppointment("10to12").verifySlot("10to12")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("10to12")
				.verifyAddressASVIB(userProfile)
				.navigateTrackCancelChangeBook().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1).changeAppointmentIB(2).verifySlot(
						"10to12").verifyAddress(userProfile)
				.selectAnAppointment("10to12").verifySlot("10to12")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.clickChangeAppointment().verifyAddress(userProfile)
				.verifyCalendarPageASVIB().accountSummarycancelAppointment()
				.logout();
	}

	/*
	 * CombiningBreakdownBS1_TC_04 IB Journey combined with IB - DISP Status
	 * HC300 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbChangeApplianceBS1DISP() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS1 -IB combined with IB Journey Test - DISP status ",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1).navigateToReviewIB(1).verifySlot(
						"6to8").verifyAddress(userProfile).selectAnAppointment(
						"6to8").verifySlot("6to8").verifyAddress(userProfile)
				.reviewDetailsPage(userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.verifySlot("6to8").verifyAddressASVIB(userProfile)
				.logoutReturn().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1)

				.changeAppointmentIB(2).verifySlot("6to8").verifyAddress(
						userProfile).selectAnAppointment("6to8").verifySlot(
						"6to8").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot(
						"6to8").verifyAddressIB(userProfile)
				.navigateTrackCancelChangeBook().verifyAccountOverview("DISP")
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * CombiningBreakdownBS1_TC_05 IB Journey combined with IB - NA1 & NA2
	 * Status HC200 customer Book an IB and set the status to NA1 with priority
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbChangeApplianceBS1Na1Na2() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS1 -IB combined with IB Journey Test - NA1 & Na2 status ",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare200Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1)

				.changeAppointmentIB(2).verifySlot("6to8").verifyAddress(
						userProfile).selectAnAppointment("PM2to4").verifySlot(
						"6to8").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot(
						"6to8").verifyAddressIB(userProfile)
				.navigateTrackCancelChangeBook().verifyAccountOverview("Na1")
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * CombiningBreakdownBS1_TC_06 IB Journey combined with IB - Sched Status
	 * HC300 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbChangeApplianceBS1Sched() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS1 -IB combined with IB Journey Test - SCHED status ",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1).navigateToReviewIB(1).verifySlot(
						"6to8").verifyAddress(userProfile).selectAnAppointment(
						"6to8").verifySlot("6to8").verifyAddress(userProfile)
				.reviewDetailsPage(userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.verifySlot("6to8").verifyAddressIB(userProfile).logoutReturn()
				.navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1).changeAppointmentIB(2).verifySlot(
						"6to8").verifyAddress(userProfile).selectAnAppointment(
						"6to8").verifySlot("6to8").verifyAddress(userProfile)
				.reviewDetailsPage(userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.verifySlot("6to8").verifyAddressIB(userProfile)
				.navigateTrackCancelChangeBook().verifyAccountOverview("Sched")
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * CombiningBreakdownBS1_TC_07 IB Journey combined with IB - Alloc Status
	 * HC200 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbChangeApplianceBS1Alloc() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS1 -IB combined with IB Journey Test - Site status ",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare200Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1).navigateToReviewIB(1).verifySlot(
						"10to12").verifyAddress(userProfile)
				.selectAnAppointment("10to12").verifySlot("10to12")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("10to12")
				.verifyAddressIB(userProfile).logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1)

				.changeAppointmentIB(2).verifySlot("10to12").verifyAddress(
						userProfile).selectAnAppointment("10to12").verifySlot(
						"10to12").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot(
						"10to12").verifyAddressIB(userProfile)
				.navigateTrackCancelChangeBook().verifyAccountOverview("ALLOC")
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * CombiningBreakdownBS1_TC_08 IB Journey combined with IB - Site Status
	 * HC100 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbChangeApplianceBS1Site() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS1 -IB combined with IB Journey Test - Site status ",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1).navigateToReviewIB(1).verifySlot(
						"10to12").verifyAddress(userProfile)
				.selectAnAppointment("10to12").verifySlot("10to12")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("10to12")
				.verifyAddressIB(userProfile).logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1)

				.changeAppointmentIB(2).verifySlot("10to12").verifyAddress(
						userProfile).selectAnAppointment("10to12").verifySlot(
						"10to12").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot(
						"10to12").verifyAddressIB(userProfile)
				.navigateTrackCancelChangeBook().verifyAccountOverview("Site")
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * CombiningBreakdownBS1_TC_09 IB Journey combined with IB - Comp Status
	 * HC100 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbChangeApplianceBS1Comp() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS1 -IB combined with IB Journey Test - Comp status ",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1).navigateToReviewIB(1).verifySlot(
						"8to10").verifyAddress(userProfile)
				.selectAnAppointment("8to10").verifySlot("8to10")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("8to10")
				.verifyAddressIB(userProfile).logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1)

				.changeAppointmentIB(2).verifySlot("8to10").verifyAddress(
						userProfile).selectAnAppointment("8to10").verifySlot(
						"8to10").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot(
						"8to10").verifyAddressIB(userProfile)
				.navigateTrackCancelChangeBook().verifyAccountOverview("COMP")
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * CombiningBreakdownBS1_TC_10 IB Journey combined with IB - Hold Status
	 * HC100 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbChangeApplianceBS1Hold() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS1 -IB combined with IB Journey Test - Hold status ",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1).navigateToReviewIB(1).verifySlot(
						"PM2to4").verifyAddress(userProfile)
				.selectAnAppointment("PM2to4").verifySlot("PM2to4")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("PM2to4")
				.verifyAddressIB(userProfile).logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1)

				.changeAppointmentIB(2).verifySlot("PM2to4").verifyAddress(
						userProfile).selectAnAppointment("PM2to4").verifySlot(
						"PM2to4").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot(
						"PM2to4").verifyAddressIB(userProfile)
				.navigateTrackCancelChangeBook().verifyAccountOverview("Hold")
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * CombiningBreakdownBS1_TC_11 IB Journey combined with IB - Route Status
	 * HC200 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbChangeApplianceBS1Route() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS1 -IB combined with IB Journey Test - Route status ",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare200Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1).navigateToReviewIB(1).verifySlot(
						"PMElec").verifyAddress(userProfile)
				.selectAnAppointment("PMElec").verifySlot("PMElec")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("PMElec")
				.verifyAddressIB(userProfile).logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1)

				.changeAppointmentIB(2).verifySlot("PMElec").verifyAddress(
						userProfile).selectAnAppointment("PMElec").verifySlot(
						"PMElec").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot(
						"PMElec").verifyAddressIB(userProfile)
				.navigateTrackCancelChangeBook().verifyAccountOverview("Route")
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * CombiningBreakdownBS1_TC_14 IB Journey combined with IB - Change
	 * Appliance HC200 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbChangeApplianceBS1() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS1 -IB combined with IB Journey Test - Change Applicance ",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare200Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(userProfile).navigatePriorityPageIB(0)
				.verifySlot("PMElec").verifyAddress(userProfile)
				.selectAnAppointment("PMElec").verifySlot("PMElec")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("PMElec")
				.verifyAddressIB(userProfile).logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1)
				.changeAppointmentIB(2).clickChangeAppliance()
				.navigateToIdentifyFault(0, userProfile)
				.navigatePriorityPage(0)
				.verifyAddress(userProfile).selectAnAppointment("AM")
				.verifySlot("AM").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * CombiningBreakdownBS1_TC_15 IB Journey combined with IB - Change
	 * Appliance HC200 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbChangeApplianceBS1FromCalendar() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS1 -IB combined with IB Journey Test - Change Applicance From Calendar",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare200Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(userProfile).navigatePriorityPageIB(0)
				.verifySlot("AM").verifyAddress(userProfile)
				.selectAnAppointment("AM").verifySlot("AM").verifyAddress(
						userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("AM").verifyAddressIB(
						userProfile).navigateTrackCancelChangeBook()
				.bookAnEngineer(userProfile, "IV").navigateToIdentifyFault(1,
						userProfile).navigatePriorityPageASV(1)
				.changeAppointmentIB(2).clickChangeAppliance().navigateToIdentifyFault(0, userProfile)
				.navigatePriorityPage(0)
				.verifyAddress(userProfile).selectAnAppointment("AM")
				.verifySlot("AM").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * CombiningBreakdownBS1_TC_10 IB Journey combined with IB - different slot
	 * HC100 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbDifferentAppointmentBS1() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS1 -IB combined with IB Journey Test-Hc100 ",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1).verifyAddressIB(userProfile)
				.selectAnAppointment("12to2").verifySlot("12to2")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("12to2")
				.verifyAddressIB(userProfile).logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1)

				.changeAppointmentIB(2).verifySlot("12to2").verifyAddress(
						userProfile).selectAnAppointment("12to2").verifySlot(
						"12to2").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.navigateTrackCancelChangeBook()/*.verifyAccountOverview("Hold")*/
				.accountSummarycancelAppointment().logout();

	}

	/*
	 * CombiningBreakdownBS1_TC_22 IB Journey combined with IB - Same slot HC300
	 * customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbKeepAppointmentBS1() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS1 -IB combined with IB Journey Test-Hc300 - Keep slot",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1).verifyAddressIB(userProfile)
				.selectAnAppointment("12to2").verifySlot("12to2")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("12to2")
				.verifyAddressIB(userProfile).logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1)

				.changeAppointmentIB(1).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).navigateTrackCancelChangeBook()
				.accountSummarycancelAppointment().logout();

	}

	// -------------------------------------------------------------------------------------------------------------------

	/*
	 * CombiningBreakdownBS2_TC_04 IB Journey combined with IB - different slot
	 * HC400 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbDifferentAppointmentBS2() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS1 -IB combined with IB Journey Test-Hc400 ",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1).verifyAddressIB(userProfile).selectAnAppointment(
						"AM").verifySlot("AM").verifyAddress(userProfile)
				.reviewDetailsPage(userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.verifySlot("AM").verifyAddressIB(userProfile).logoutReturn()
				.navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1)

				.changeAppointmentIB(2).verifySlot("AM").verifyAddress(
						userProfile).selectAnAppointment("AM").verifySlot("AM")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("AM").verifyAddressIB(
						userProfile).navigateTrackCancelChangeBook()
				.accountSummarycancelAppointment().logout();

	}

	/*
	 * CombiningBreakdownBS2_TC_06 IB Journey combined with IB - different slot
	 * HC400 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbDifferentAppointmentBS28to10slot() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS1 -IB combined with IB Journey Test-Hc400 - 8 to 10 slot",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1).verifyAddressIB(userProfile)
				.selectAnAppointment("8to10").verifySlot("8to10")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("8to10")
				.verifyAddressASVIB(userProfile).logoutReturn()
				.navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1)

				.changeAppointmentIB(2).verifySlot("8to10").verifyAddress(
						userProfile).selectAnAppointment("8to10").verifySlot(
						"8to10").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot(
						"8to10").verifyAddressIB(userProfile)
				.navigateTrackCancelChangeBook()
				.accountSummarycancelAppointment().logout();

	}

	/*
	 * CombiningBreakdownBS2_TC_12 IB Journey combined with IB - DISP Status
	 * HC400 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbBS2DISP() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS2 -IB combined with IB Journey Test - DISP status ",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1).navigateToReviewIB(1)
				.selectAnAppointment("AM").reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1)

				.changeAppointmentIB(2).selectAnAppointment("AM")
				.reviewDetailsPage(userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.navigateTrackCancelChangeBook().verifyAccountOverview("DISP")
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * CombiningBreakdownBS2_TC_13 IB Journey combined with IB - NA1 & NA2
	 * Status HC400 customer Book an IB and set the status to NA1 with priority
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbBS3Na1Na2() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS2 -IB combined with IB Journey Test - NA1 & Na2 status ",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1)

				.changeAppointmentIB(2).selectAnAppointment("AllDay")
				.reviewDetailsPage(userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.navigateTrackCancelChangeBook().verifyAccountOverview("Na1")
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * CombiningBreakdownBS12_TC_11 IB Journey combined with IB - Hold Status
	 * HC400 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbBS2Hold() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS2 -IB combined with IB Journey Test - Hold status ",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1).navigateToReviewIB(1)
				.selectAnAppointment("AM").reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1)

				.changeAppointmentIB(2).selectAnAppointment("AM")
				.reviewDetailsPage(userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.navigateTrackCancelChangeBook().verifyAccountOverview("Hold")
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * CombiningBreakdownBS2_TC_10 IB Journey combined with IB - Route Status
	 * HC400 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbBS2Route() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS2 -IB combined with IB Journey Test - Route status ",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1).navigateToReviewIB(1)
				.selectAnAppointment("PM").reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1)

				.changeAppointmentIB(2).selectAnAppointment("PM")
				.reviewDetailsPage(userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.navigateTrackCancelChangeBook().verifyAccountOverview("Route")
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * CombiningBreakdownBS2_TC_15 IB Journey combined with IB - Hold Status
	 * HC400 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbBS2HoldFFSlot() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS2 -IB combined with IB Journey Test - Hold status - FF slot",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1).navigateToReviewIB(1)
				.selectAnAppointment("FF").reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1)

				.changeAppointmentIB(2).selectAnAppointment("FF")
				.reviewDetailsPage(userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.navigateTrackCancelChangeBook().verifyAccountOverview("Hold")
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * CombiningBreakdownBS2_TC_16 IB Journey combined with IB - Sched Status
	 * HC400 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbBS2Sched() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS2 -IB combined with IB Journey Test - SCHED status ",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1).navigateToReviewIB(1)
				.selectAnAppointment("FF").reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1)

				.changeAppointmentIB(2).selectAnAppointment("FF")
				.reviewDetailsPage(userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.navigateTrackCancelChangeBook().verifyAccountOverview("Sched")
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * CombiningBreakdownBS2_TC_23 IB Journey combined with IB - different slot
	 * HC400 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbDifferentAppointmentBS22HrSlot() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS1 -IB combined with IB Journey Test-Hc400 - 2 HR slot",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1).navigateToReviewIB(1)
				.selectAnAppointment("12to2").reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1)

				.changeAppointmentIB(2).selectAnAppointment("12to2")
				.reviewDetailsPage(userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.navigateTrackCancelChangeBook()
				.accountSummarycancelAppointment().logout();

	}

	/*
	 * CombiningBreakdownBS2_TC_19 IB Journey combined with IB - different slot
	 * HC400 customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbDifferentAppointmentBS2PMSlot() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS1 -IB combined with IB Journey Test-Hc400 - PM slot ",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageIB(0).verifySlot("PM").verifyAddress(
						userProfile).selectAnAppointment("PM").verifySlot("PM")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("PM").verifyAddressIB(
						userProfile).logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(0)

				.changeAppointmentIB(2).verifySlot("PM").verifyAddress(
						userProfile).selectAnAppointment("PM").verifySlot("PM")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("PM").verifyAddressIB(
						userProfile).navigateTrackCancelChangeBook()
				.accountSummarycancelAppointment().logout();

	}

	/*
	 * CombiningBreakdownBS2_TC_14 IB Journey combined with IB - different slot
	 * HC100 customer Naw status should be set
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbDifferentAppointmentBS2NAW() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS1 -IB combined with IB Journey Test-Hc100-Hold ",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare100Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1).navigateToReviewIB(1).verifySlot(
						"12to2").verifyAddress(userProfile)
				.selectAnAppointment("12to2").reviewDetailsPage(userProfile)
				.verifySlot("12to2").verifyAddress(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("12to2")
				.verifyAddressIB(userProfile).logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1)

				.changeAppointmentIB(2).verifySlot("12to2").verifyAddress(
						userProfile).selectAnAppointment("12to2").verifySlot(
						"12to2").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot(
						"12to2").verifyAddressIB(userProfile)
				.navigateTrackCancelChangeBook().verifyAccountOverview("Hold")
				.accountSummarycancelAppointment().logout();

	}

	/*
	 * CombiningBreakdownBS2_TC_17 IB Journey combined with IB - different slot
	 * HC100 customer Alloc status
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbDifferentAppointmentBS2Alloc() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS1 -IB combined with IB Journey Test- Alloc",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1).navigateToReviewIB(1).verifySlot(
						"AllDay").verifyAddress(userProfile)
				.selectAnAppointment("AllDay").verifySlot("AllDay")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("AllDay")
				.verifyAddressIB(userProfile).logoutReturn().navigateToLogin()
				.loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1)

				.changeAppointmentIB(2).verifySlot("AllDay").verifyAddress(
						userProfile).selectAnAppointment("AllDay").verifySlot(
						"AllDay").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot(
						"AllDay").verifyAddressIB(userProfile)
				.navigateTrackCancelChangeBook().verifyAccountOverview("ALLOC")
				.accountSummarycancelAppointment().logout();

	}

	/*
	 * CombiningBreakdownBS2_TC_18 IB Journey combined with IB - different slot
	 * SITE status
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingWithIbDifferentAppointmentBS2Site() {
		Report
				.createTestLogHeader(
						"CombiningBreakdownBS1 -IB combined with IB Journey Test - Site",
						"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1).navigateToReviewIB(1).verifySlot(
						"AM").verifyAddress(userProfile).selectAnAppointment(
						"AM").verifySlot("AM").verifyAddress(userProfile)
				.reviewDetailsPage(userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.verifySlot("AM").verifyAddressIB(userProfile).logoutReturn()
				.navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPageASV(1)

				.changeAppointmentIB(2).verifySlot("AM").verifyAddress(
						userProfile).selectAnAppointment("AM").verifySlot("AM")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("AM").verifyAddressIB(
						userProfile).navigateTrackCancelChangeBook()
				.verifyAccountOverview("Site")
				.accountSummarycancelAppointment().logout();

	}

	// -------------------------------------------------------------------------------------------------------------------

	/*
	 * CancelBreakdown_TC_01 The user should be an OAM user. The user should
	 * have a BGS account.
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibCancelFromView() {
		Report.createTestLogHeader("IB - Cancel from viewdiary",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(userProfile).navigateToReviewIB(1)
				.selectAnyAppointment().reviewDetailsPage(userProfile)
				.navigateToConfirmationBooking().navigateTrackCancelChange()
				.viewDetailsCompletePage(userProfile)
				.accountSummarycancelAppointmentViewDetail().logout();

	}

	/*
	 * CancelBreakdown_TC_02 The user should be an OAM user. The user should
	 * have a BGS account.
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibCancelFromViewwithGAC() {
		Report.createTestLogHeader("IB - Cancel from viewdiary - With GAC",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverview(
						"ideal").bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(userProfile).navigateToReviewIB(1)
				.selectAnyAppointment().reviewDetailsPage(userProfile).addGAC()
				.navigateToConfirmationBooking().navigateTrackCancelChange()
				.viewDetailsCompletePage(userProfile)
				.accountSummarycancelAppointmentViewDetail().logout();

	}

	// ------------------------------------------------------------------------------------------------------------------------

	/*
	 * RescheduleBreakdownBS2_TC_02 The user should be an OAM user. The user
	 * should have a BGS acount. 'No' option should be selected for Priority
	 * Booking on the Questionnaire page. The appointment should be rescheduled
	 * for 'FF' slot. The scenario should be verified for a HC 400 account
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibRescheduleBS2HC400FFSlot() {
		Report.createTestLogHeader("IB - FF slot - Homeservice 400 account",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV()													  .bookAnEngineerIB(userProfile,
													  "IV").clickFaultCategory("Electric",
													  userProfile).navigatePriorityPage(2)
													  .verifySlot("FF").verifyAddress(userProfile).selectAnAppointment("FF")
													  .verifySlot("FF").verifyAddress(userProfile).reviewDetailsPage(userProfile)
													  .navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("FF").verifyAddressIB(userProfile).navigateTrackCancelChange()													 
		.viewDetails().accountSummaryChangeAppointment()
				.navigateToReviewIB(2).verifySlot("FF").verifyAddress(
						userProfile).selectAnAppointment("FF").verifySlot("FF")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("FF").verifyAddressIB(
						userProfile).navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * RescheduleBreakdownBS2_TC_16 The user should be an OAM user. The user
	 * should have a BGS acount. 'No' option should be selected for Priority
	 * Booking on the Questionnaire page. The appointment should be rescheduled
	 * for 'AM' slot. The scenario should be verified for a HC 400 account
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibRescheduleBS2HC400AMslotSched() {
		Report.createTestLogHeader(
				"IB - AM slot - Homeservice 400 account - Sched status",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(userProfile)
				.navigateToReviewIB(1).verifySlot("AM").verifyAddress(
						userProfile).selectAnAppointment("AM").verifySlot("AM")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("AM").verifyAddressIB(
						userProfile).navigateTrackCancelChange()
				.accountSummaryChangeAppointment().navigateToReviewIB(2)
				.verifySlot("AM").verifyAddress(userProfile)
				.selectAnAppointment("AM").verifySlot("AM").verifyAddress(
						userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("AM").verifyAddressIB(
						userProfile).navigateTrackCancelChangeBook()
				.verifyAccountOverview("Sched")
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * RescheduleBreakdownBS2_TC_10 The user should be an OAM user. The user
	 * should have a BGS acount. 'No' option should be selected for Priority
	 * Booking on the Questionnaire page. The appointment should be rescheduled
	 * for 'PM' slot. The scenario should be verified for a HC 400 account
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibRescheduleBS2HC400AMslotPend() {
		Report.createTestLogHeader(
				"IB - PM slot - Homeservice 400 account - Pend status",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(userProfile)
				.navigateToReviewIB(1).verifySlot("PM").verifyAddress(
						userProfile).selectAnAppointment("PM").verifySlot("PM")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("PM").verifyAddressIB(
						userProfile).navigateTrackCancelChange()
				.accountSummaryChangeAppointment().navigateToReviewIB(2)
				.verifySlot("PM").verifyAddress(userProfile)
				.selectAnAppointment("PM").verifySlot("PM").verifyAddress(
						userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("PM").verifyAddressIB(
						userProfile).navigateTrackCancelChangeBook()
				.verifyAccountOverview("Pend")
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * RescheduleBreakdownBS2_TC_11 The user should be an OAM user. The user
	 * should have a BGS acount. 'No' option should be selected for Priority
	 * Booking on the Questionnaire page. The appointment should be rescheduled
	 * for 'AM' slot. The scenario should be verified for a HC 400 account
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibRescheduleBS2HC400AMslotDisp() {
		Report.createTestLogHeader(
				"IB - AM slot - Homeservice 400 account - Disp status",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(userProfile)
				.navigateToReviewIB(1).verifySlot("AM").verifyAddress(
						userProfile).selectAnAppointment("AM").verifySlot("AM")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("AM").verifyAddressIB(
						userProfile).navigateTrackCancelChange()
				.accountSummaryChangeAppointment().navigateToReviewIB(2)
				.verifySlot("AM").verifyAddress(userProfile)
				.selectAnAppointment("AM").verifySlot("AM").verifyAddress(
						userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("AM").verifyAddressIB(
						userProfile).navigateTrackCancelChangeBook()
				.verifyAccountOverview("DISP")
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * RescheduleBreakdownBS2_TC_12 The user should be an OAM user. The user
	 * should have a BGS acount. 'No' option should be selected for Priority
	 * Booking on the Questionnaire page. The appointment should be rescheduled
	 * for 'FF' slot. The scenario should be verified for a HC 400 account
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibRescheduleBS2HC400FFslotHold() {
		Report.createTestLogHeader(
				"IB - FF slot - Homeservice 400 account - Hold status",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(userProfile)
				.navigateToReviewIB(1).selectAnAppointment("FF")
				.reviewDetailsPage(userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.navigateTrackCancelChange().accountSummaryChangeAppointment()
				.navigateToReviewIB(2).verifySlot("FF").verifyAddress(
						userProfile).selectAnAppointment("FF").verifySlot("FF")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("FF").verifyAddressIB(
						userProfile).navigateTrackCancelChangeBook()
				.verifyAccountOverview("Hold")
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * RescheduleBreakdownBS2_TC_14 The user should be an OAM user. The user
	 * should have a BGS acount. 'No' option should be selected for Priority
	 * Booking on the Questionnaire page. The appointment should be rescheduled
	 * for 'AM' slot. The scenario should be verified for a HC 400 account
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibRescheduleBS2HC400AMslotComp() {
		Report.createTestLogHeader(
				"IB - AM slot - Homeservice 400 account - Comp status",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(userProfile)
				.navigateToReviewIB(1).verifySlot("AM").verifyAddress(
						userProfile).selectAnAppointment("AM").verifySlot("AM")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("AM").verifyAddressIB(
						userProfile).navigateTrackCancelChange()
				.accountSummaryChangeAppointment().navigateToReviewIB(2)
				.verifySlot("AM").verifyAddress(userProfile)
				.selectAnAppointment("AM").reviewDetailsPage(userProfile)
				.verifySlot("AM").verifyAddress(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("AM").verifyAddressIB(
						userProfile).navigateTrackCancelChangeBook()
				.verifyAccountOverview("COMP")
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * RescheduleBreakdownBS2_TC_13 The user should be an OAM user. The user
	 * should have a BGS acount. 'No' option should be selected for Priority
	 * Booking on the Questionnaire page. The appointment should be rescheduled
	 * for 'PM' slot. The scenario should be verified for a HC 400 account
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibRescheduleBS2HC400PMslotNa1Na2() {
		Report.createTestLogHeader(
				"IB - PM slot - Homeservice 400 account - Na1 & Na2 status",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverviewASV(
						"Ideal").accountSummaryChangeAppointment()
				.navigateToReviewIB(2).verifySlot("PM").verifyAddress(
						userProfile).selectAnAppointment("PM").verifySlot("PM")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("PM").verifyAddressIB(
						userProfile).navigateTrackCancelChangeBook()
				.verifyAccountOverview("Na1").accountSummarycancelAppointment()
				.logout();
	}

	/*
	 * RescheduleBreakdownBS2_TC_15 The user should be an OAM user. The user
	 * should have a BGS acount. 'No' option should be selected for Priority
	 * Booking on the Questionnaire page. The appointment should be rescheduled
	 * for 'AM' slot. The scenario should be verified for a HC 400 account
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibRescheduleBS2HC400AMslotNaw() {
		Report.createTestLogHeader(
				"IB - AM slot - Homeservice 400 account - Naw status",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyAccountOverviewASV(
						"Ideal").accountSummaryChangeAppointment()
				.navigateToReviewIB(2).verifySlot("AM").verifyAddress(
						userProfile).selectAnAppointment("AM").verifySlot("AM")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("AM").verifyAddressIB(
						userProfile).navigateTrackCancelChangeBook()
				.verifyAccountOverview("Naw").accountSummarycancelAppointment()
				.logout();
	}

	/*
	 * RescheduleBreakdownBS2_TC_17 The user should be an OAM user. The user
	 * should have a BGS acount. 'No' option should be selected for Priority
	 * Booking on the Questionnaire page. The appointment should be rescheduled
	 * for 'PM' slot. The scenario should be verified for a HC 400 account
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibRescheduleBS2HC400PMslotSite() {
		Report.createTestLogHeader(
				"IB - PM slot - Homeservice 400 account - Site status",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(userProfile)
				.navigateToReviewIB(1).verifySlot("PM").verifyAddress(
						userProfile).selectAnAppointment("PM").verifySlot("PM")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("PM").verifyAddressIB(
						userProfile).navigateTrackCancelChange()
				.accountSummaryChangeAppointment().navigateToReviewIB(2)
				.verifySlot("PM").verifyAddress(userProfile)
				.selectAnAppointment("PM").verifySlot("PM").verifyAddress(
						userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("PM").verifyAddressIB(
						userProfile).navigateTrackCancelChangeBook()
				.verifyAccountOverview("Site")
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * RescheduleBreakdownBS2_TC_18 The user should be an OAM user. The user
	 * should have a BGS acount. 'No' option should be selected for Priority
	 * Booking on the Questionnaire page. The appointment should be rescheduled
	 * for 'PM' slot. The scenario should be verified for a HC 400 account
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibRescheduleBS2HC400PMslotAlloc() {
		Report.createTestLogHeader(
				"IB - PM slot - Homeservice 400 account - Alloc status",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(userProfile)
				.navigateToReviewIB(1).verifySlot("PM").verifyAddress(
						userProfile).selectAnAppointment("PM").verifySlot("PM")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("PM").verifyAddressIB(
						userProfile).navigateTrackCancelChange()
				.accountSummaryChangeAppointment().navigateToReviewIB(2)
				.verifySlot("PM").verifyAddress(userProfile)
				.selectAnAppointment("PM").verifySlot("PM").verifyAddress(
						userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("PM").verifyAddressIB(
						userProfile).navigateTrackCancelChangeBook()
				.verifyAccountOverview("Alloc")
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * RescheduleBreakdownBS2_TC_21 The user should be an OAM user. The user
	 * should have a BGS account. 'No' option should be selected for Priority
	 * Booking on the Questionnaire page. The appointment should be rescheduled
	 * for '8am to 10am' slot. The scenario should be verified for a HC 400
	 * account
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibRescheduleBS2VerifyChangeAppliance() {
		Report.createTestLogHeader(
				"IB -Reschedule - Verify Navigation Page - HC400",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(userProfile)
				.navigateToReviewIB(1).verifySlot("8to10").verifyAddress(
						userProfile).selectAnAppointment("8to10").verifySlot(
						"8to10").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot(
						"8to10").verifyAddressIB(userProfile)
				.navigateTrackCancelChange().viewDetails()
				.accountSummarycancelAppointment().navigateToReviewIB(2)
				.verifySlot("8to10").verifyAddress(userProfile)
				.selectAnAppointment("8to10").verifySlot("8to10")
				.verifyAddress(userProfile).clickChangeAppointment()
				.verifyAddress(userProfile).verifyCalendarPage().logout();

	}

	/*
	 * RescheduleBreakdownBS2_TC_23 The user should be an OAM user. The user
	 * should have a BGS acount. 'No' option should be selected for Priority
	 * Booking on the Questionnaire page. The appointment should be rescheduled
	 * for First available slot. The scenario should be verified for a HC 400
	 * account
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibRescheduleBS2HC400FirstSlot() {
		Report.createTestLogHeader(
				"IB - First slot - Homeservice 400 account ",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(userProfile)
				.navigateToReviewIB(1).verifySlot("AM").verifyAddress(
						userProfile).selectAnAppointment("AM").verifySlot("AM")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("AM").verifyAddressIB(
						userProfile).navigateTrackCancelChange()
				.accountSummaryChangeAppointment().navigateToReviewIB(2)
				.selectFirstAvailableSlot().reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).navigateTrackCancelChangeBook()
				.verifyAccountOverview("COMP")
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * RescheduleBreakdownBS2_TC_25 The user should be an OAM user. The user
	 * should have a BGS account.
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibRescheduleBS2VerifyNavigation() {
		Report.createTestLogHeader("IB -Reschedule - Verify Navigation Page",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyLinkNavigation(
						"AccOverviewASV").navigateBack().verifyLinkNavigation(
						"AccOverviewIB").navigateBack().logout();

	}

	// -------------------------------------------------------------------------------------------------------------------

	/*
	 * RescheduleBreakdownBS1_TC_01 The user should be an OAM user. The user
	 * should have a BGS account. HC 200 Customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibRescheduleBS1VerifyNavigation() {
		Report.createTestLogHeader(
				"IB -Reschedule - Verify Navigation Page - HC200",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare200Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().verifyLinkNavigation("ASV")
				.navigateBack().verifyLinkNavigation("IB").navigateBack()
				.logout();

	}

	/*
	 * RescheduleBreakdownBS1_TC_02 The user should be an OAM user. The user
	 * should have a BGS account. HC 300 Customer
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibRescheduleBS1VerifyChangeAppliance() {
		Report.createTestLogHeader(
				"IB -Reschedule - Verify Navigation Page - HC300",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(userProfile)
				.navigateToReviewIB(1).verifySlot("AM").verifyAddress(
						userProfile).selectAnAppointment("AM").verifySlot("AM")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("AM").verifyAddressIB(
						userProfile).navigateTrackCancelChange().viewDetails()
				.accountSummaryChangeAppointment().navigateToReviewIB(2)
				.selectAnAppointment("PM").clickChangeAppointment()
				.verifyCalendarPage()
		// .logout()
		;

	}

	/*
	 * RescheduleBreakdownBS1_TC_13 The user should be an OAM user. The user
	 * should have a BGS acount. 'No' option should be selected for Priority
	 * Booking on the Questionnaire page. The appointment should be rescheduled
	 * for 'PM' slot. The scenario should be verified for a HC 100 account
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibRescheduleBS1HC100PMslotSched() {
		Report.createTestLogHeader(
				"IB - PM slot - Homeservice 100 account - Sched status",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageIB()/*
													 * .bookAnEngineer(userProfile,
													 * "IV").navigateToIdentifyFault(userProfile).navigateToReviewIB(1)
													 * .verifySlot("PM").verifyAddress(userProfile)
													 * .selectAnAppointment("PM").verifySlot("PM").verifyAddress(userProfile).reviewDetailsPage(userProfile)
													 * .verifySlot("PM").verifyAddress(userProfile).navigateToConfirmationASV()
													 * .verifySlot("PM").verifyAddressIB(userProfile).navigateTrackCancelChange()
													 * .accountSummaryChangeAppointment().navigateToReviewIB(2)
													 * .verifySlot("PM").verifyAddress(userProfile)
													 * .selectAnAppointment("PM").verifySlot("PM").verifyAddress(userProfile).reviewDetailsPage(userProfile)
													 * .navigateToConfirmationASV()
													 */
				.verifyAddressIB(userProfile).verifySlotBook("PM")
				.verifyAccountOverview("Sched")
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * RescheduleBreakdownBS1_TC_10 The user should be an OAM user. The user
	 * should have a BGS acount. 'No' option should be selected for Priority
	 * Booking on the Questionnaire page. The appointment should be rescheduled
	 * for 'AllDay' slot. The scenario should be verified for a HC 300 account
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibRescheduleBS1HC300AllDayslotDisp() {
		Report.createTestLogHeader(
				"IB - PM slot - Homeservice 300 account - Disp status",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(userProfile)
				.navigateToReviewIB(1).verifySlot("AllDay").verifyAddress(
						userProfile).selectAnAppointment("AllDay")
				.reviewDetailsPage(userProfile).verifySlot("AllDay")
				.verifyAddress(userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile)
				.verifySlot("AllDay").verifyAddressIB(userProfile)
				.navigateTrackCancelChange().accountSummaryChangeAppointment()
				.navigateToReviewIB(2).verifySlot("AllDay").verifyAddress(
						userProfile).selectAnAppointment("AllDay").verifySlot(
						"AllDay").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).verifySlot("AllDay").verifyAddress(
						userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot(
						"AllDay").verifyAddressIB(userProfile)
				.navigateTrackCancelChangeBook().verifyAccountOverview("DISP")
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * RescheduleBreakdownBS1_TC_09 The user should be an OAM user. The user
	 * should have a BGS acount. 'No' option should be selected for Priority
	 * Booking on the Questionnaire page. The appointment should be rescheduled
	 * for 'FF' slot. The scenario should be verified for a HC 100 account
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibRescheduleBS1HC100FFslotPend() {
		Report.createTestLogHeader(
				"IB - FF slot - Homeservice 100 account - Pend status",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV()/*
													 * .bookAnEngineer(userProfile,
													 * "IV").navigateToIdentifyFault(userProfile).navigateToReviewIB(1)
													 * .verifySlot("FF").verifyAddress(userProfile)
													 * .selectAnAppointment("FF").verifySlot("FF").verifyAddress(userProfile).reviewDetailsPage(userProfile)
													 * .verifySlot("FF").verifyAddress(userProfile).navigateToConfirmationASV()
													 * .verifySlot("FF").verifyAddressIB(userProfile).navigateTrackCancelChange()
													 * .accountSummaryChangeAppointment().navigateToReviewIB(2).verifySlot("FF").verifyAddress(userProfile)
													 * .selectAnAppointment("FF").verifySlot("FF").verifyAddress(userProfile).reviewDetailsPage(userProfile)
													 * .navigateToConfirmationASV()
													 */.verifyAddressIB(userProfile)
				.verifySlotBook("FF").verifyAccountOverview("Pend")
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * RescheduleBreakdownBS1_TC_11 The user should be an OAM user. The user
	 * should have a BGS acount. 'No' option should be selected for Priority
	 * Booking on the Questionnaire page. The appointment should be rescheduled
	 * for 'AM' slot. The scenario should be verified for a HC 200 account
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibRescheduleBS1HC200AMslotSite() {
		Report.createTestLogHeader(
				"IB - AM slot - Homeservice 100 account - Site status",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare200Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(userProfile)
				.navigateToReviewIB(1).verifySlot("AM").verifyAddress(
						userProfile).selectAnAppointment("AM").verifySlot("AM")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("AM").verifyAddressIB(
						userProfile).navigateTrackCancelChange()
				.accountSummaryChangeAppointment().navigateToReviewIB(2)
				.verifySlot("AM").verifyAddress(userProfile)
				.selectAnAppointment("AM").verifySlot("AM").verifyAddress(
						userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("AM").verifyAddressIB(
						userProfile).navigateTrackCancelChangeBook()
				.verifyAccountOverview("Site")
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * RescheduleBreakdownBS1_TC_12 The user should be an OAM user. The user
	 * should have a BGS acount. 'No' option should be selected for Priority
	 * Booking on the Questionnaire page. The appointment should be rescheduled
	 * for 'FF' slot. The scenario should be verified for a HC 300 account
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibRescheduleBS1HC300FFslotAlloc() {
		Report.createTestLogHeader(
				"IB - FF slot - Homeservice 300 account - Alloc status",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(userProfile)
				.navigateToReviewIB(1).verifySlot("FF").verifyAddress(
						userProfile).selectAnAppointment("FF").verifySlot("FF")
				.verifyAddress(userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("FF").verifyAddressIB(
						userProfile).navigateTrackCancelChange()
				.accountSummaryChangeAppointment().navigateToReviewIB(2)
				.verifySlot("FF").verifyAddress(userProfile)
				.selectAnAppointment("FF").verifySlot("FF").verifyAddress(
						userProfile).reviewDetailsPage(userProfile)
				.navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot("FF").verifyAddressIB(
						userProfile).navigateTrackCancelChangeBook()
				.verifyAccountOverview("ALLOC")
				.accountSummarycancelAppointment().logout();
	}

	/*
	 * RescheduleBreakdownBS1_TC_14 The user should be an OAM user. The user
	 * should have a BGS acount. 'No' option should be selected for Priority
	 * Booking on the Questionnaire page. The appointment should be rescheduled
	 * for 'AllDay' slot. The scenario should be verified for a HC 300 account
	 * IB should be booked and changed to COMP status.
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibRescheduleBS1HC300AllDayslotCompp() {
		Report.createTestLogHeader(
				"IB - PM slot - Homeservice 300 account - Comp status",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageIB()/*
													 * .bookAnEngineer(userProfile,
													 * "IV").navigateToIdentifyFault(userProfile).navigateToReviewIB(1)
													 * .verifySlot("AllDay").verifyAddress(userProfile)
													 * .selectAnAppointment("AllDay").verifySlot("AllDay").verifyAddress(userProfile).reviewDetailsPage(userProfile)
													 * .navigateToConfirmationASV().verifySlot("AllDay").verifyAddressIB(userProfile).navigateTrackCancelChange()
													 * .accountSummaryChangeAppointment().navigateToReviewIB(2).verifySlot("AllDay").verifyAddress(userProfile)
													 * .selectAnAppointment("AllDay").verifySlot("AllDay").verifyAddress(userProfile).reviewDetailsPage(userProfile)
													 * .navigateToConfirmationASV()
													 */.verifyAddress(userProfile)
				.verifySlotBook("AllDay").verifyAccountOverview("Comp")
				.accountSummarycancelAppointment().logout();
	}

	// ------------------------------------------------------------------------------------------------------------------------

	/*
	 * EmailConfirmation-Audit_TC_07 The user should be an OAM user. The user
	 * should have a BGS account.
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibEmailConfirmationCancelIB() {
		Report.createTestLogHeader("IB - Email Confirmation - Cancel ",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV()
				.navigateToViewAllAppointmentsIB().selectAnyAppointment()
				.reviewDetailsPage(userProfile).addCODASVIB(userProfile)
				.navigateTrackCancelChangeBook()
				.accountSummarycancelAppointmentIB().verifyEmailConfirmation(
						userProfile, "CANCEL_APPT").logout();
	}

	/*
	 * EmailConfirmation-Audit_TC_02 The user should be an OAM user. The user
	 * should have a BGS account.
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibEmailConfirmationBookIB() {
		Report.createTestLogHeader("IB - Email Confirmation - Book ",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV().bookAnEngineer(userProfile,
						"IV").navigateToIdentifyFault(userProfile)
				.navigateToReviewIB(1).verifySlot("AllDay").verifyAddress(
						userProfile).selectAnAppointment("AllDay").verifySlot(
						"AllDay").verifyAddress(userProfile).reviewDetailsPage(
						userProfile).navigateToConfirmation().selectedAppChk(userProfile).confirmationTotalChk(userProfile).verifyAddressASVIB(userProfile).verifySlot(
						"AllDay").verifyAddressIB(userProfile)
				.navigateTrackCancelChangeIB().verifyEmailConfirmation(
						userProfile, "BOOK_APPT")
				.accountSummarycancelAppointment().logout();
	}

	// ------------------------------------------------------------------------------------------------------------------------

	/*
	 * END TO END IB Journey with COD,GAC added
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression })
	public void ibBookingCompleteEndToEnd() {
		Report.createTestLogHeader(
				"Booking Complete - IB Journey Test - COD,GAC Added",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");

		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV()
				.navigateToViewAllAppointmentsIB().selectAnyAppointmentASV()
				.reviewDetailsPage().addGAC().addCOD(userProfile)
				.navigateTrackCancelChangeIB().runVBSASV(userProfile, "ASV")
				.accountSummarycancelAppointment().logout();
	}

	// -------------------------------------------------------------------------------------------------------------------
	@Test(groups = { ASVIB, Regression })
	public void verifyReviewErrorPage() {
		Report.createTestLogHeader(
				"Error messages - Review Page - Verification",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");
		ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.ReFactoring_ASV_IB_ErrorCode);
		/*ArrayList<String> errList = new ArrayList<String>();
		errList.add("Mobile number : Please enter a valid mobile number.");
		errList.add("Home number : Please enter a valid phone number starting with a '0'");*/
		
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV()
				/*.bookAnEngineerIB(userProfile, "ASV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(0).selectAnyAppointment()*/
				.bookAnEngineerIB(userProfile, "IB").navigateToIdentifyFault(0, userProfile)
				.navigatePriorityPage(0).selectAnyAppointment()
				
				.verifyErrorReviewPage(userProfile, errList).reviewDetailsPage(
						userProfile).navigateToConfirmationASV()
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();
	}
	
	@Test(groups = { ASVIB, Regression })
	public void verifyPaymentErrorPage() {
		Report.createTestLogHeader(
				"Error message - Payment page - verification",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");
		ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.ReFactoring_ASV_IB_Payment_ErrorCode);
		/*ArrayList<String> errList = new ArrayList<String>();
		errList.add("Card type : Please select a card type.");
	    errList.add("Card holder name : Please enter the name as it appears on your card.");
	    errList.add("Card number : Please enter the card number exactly as it appears on your card.");
	    errList.add("Card expiry date : Please enter the expiry date as it appears on your card.");
	    errList.add("Card security number : A required field has not been completed.");		    
	    errList.add("Card start date : Please enter the start date as it appears on your card.");	
	    errList.add("Issue number : Please enter a valid issue number.");
	    errList.add("Card security number : This should contain numbers only. This is a 3 digit security code which is printed on the reverse of your card, at the end of the signature panel.");
		*/
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
				.navigateToAccountSummaryPageASV()
				.bookAnEngineerIB(userProfile, "IV").navigateToIdentifyFault(1, userProfile)
				.navigatePriorityPage(0).selectAnyAppointment()
				.reviewDetailsPage(userProfile).verifyErrorPaymentPage(userProfile, errList)
				.logout();
	}
//	div[@id='errorMsgPaymentDetailEntry']/div/ul/li
	
	@Test(groups = { ASVIB, Regression })
	public void verifyBacklinks()
	{
		Report.createTestLogHeader(
				"Back links verification - verification",
				"HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");
		/*
		 * ********************IB
		 */
		new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.bookAnEngineerIB(userProfile, "IV").clickCancel()
		.verifyAddressBook(userProfile).verifyAccountOverview("Ideal")
		.bookAnEngineerIB(userProfile, "IV").navigateToIdentifyFault(0, userProfile)
		.verifyPriorityPage("2").clickBack().verifyAddressBook(userProfile)
		.verifyAccountOverview("Ideal").verifyAddressIB(userProfile).navigateToIdentifyFault(0, userProfile)
		.verifyPriorityPage("2").navigatePriorityPage(0).verifyCalendarPage().clickBack().verifyFaultPage()
		.navigateToIdentifyFault(0, userProfile).verifyPriorityPage("2").navigatePriorityPage(0)
		.verifyCalendarPage().selectAnyAppointment().verifyAddress(userProfile).reviewDetailsPage(userProfile)
		.clickBack().verifyCalendarPage().selectAnyAppointment().reviewDetailsPage(userProfile).clickCancel()
		.navigateToIdentifyFault(0, userProfile)
		.verifyPriorityPage("2").navigatePriorityPage(0).verifyCalendarPage().selectAnyAppointment().reviewDetailsPage(userProfile)
		.navigateToConfirmationASV().navigateTrackCancelChangeTrack().viewDetailsCompletePage(userProfile)
		/*
		 * ********************Reschedule
		 */
		
		.accountSummaryChangeAppointmentIB().verifyPriorityPage("2").navigatePriorityPage(0).clickCancelASV()
		.accountSummaryChangeAppointmentIB().verifyPriorityPage("2").navigatePriorityPage(0)
		.verifyCalendarPage().selectAnyAppointment().reviewDetailsPage(userProfile).clickBack()
		.verifyCalendarPage().clickBack().verifyPriorityPage("2").navigatePriorityPage(0)
		.verifyCalendarPage().selectAnyAppointment().reviewDetailsPage(userProfile).navigateToConfirmationASV()
		.viewDetailsCompletePage(userProfile).accountSummarycancelAppointment().verifyAddressBook(userProfile)
		.verifyAccountOverview("Ideal")
		
		/*
		 * ********************IB
		 */
		.bookAnEngineerIB(userProfile, "IV").navigateToIdentifyFault(0, userProfile)
		.verifyPriorityPage("2").clickBack().verifyAddressBook(userProfile)
		.verifyAccountOverview("Ideal").verifyAddressIB(userProfile).navigateToIdentifyFault(0, userProfile)
		.verifyPriorityPage("2").navigatePriorityPage(1).verifyCalendarPage().clickBack().verifyFaultPage()
		.navigateToIdentifyFault(0, userProfile).verifyPriorityPage("2").navigatePriorityPage(1)
		.verifyCalendarPage().selectAnyAppointment().verifyAddress(userProfile).reviewDetailsPage(userProfile)
		.clickBack().verifyCalendarPage().selectAnyAppointment().reviewDetailsPage(userProfile).clickCancel()
		.navigateToIdentifyFault(0, userProfile)
		.verifyPriorityPage("2").navigatePriorityPage(1).verifyCalendarPage().selectAnyAppointment().reviewDetailsPage(userProfile)
		.navigateToConfirmationASV().navigateTrackCancelChange()
		/*
		 * ********************IB + IB
		 */
		.bookAnEngineerIB(userProfile, "IV").navigateToIdentifyFault(0, userProfile)
		.verifyPriorityPage("2").clickBack()
		.verifyAddress(userProfile).navigateToIdentifyFault(0, userProfile)
		.verifyPriorityPage("2").navigatePriorityPage(1).verifyCalendarPage().clickBack().verifyFaultPage()
		.navigateToIdentifyFault(0, userProfile).verifyPriorityPage("2").navigatePriorityPage(1).changeAppointment(2)
		.verifyCalendarPage().selectAnyAppointment().verifyAddress(userProfile).reviewDetailsPage(userProfile)
		.clickBack().verifyCalendarPage().selectAnyAppointment().reviewDetailsPage(userProfile).clickCancel()
		.navigateToIdentifyFault(0, userProfile)
		.verifyPriorityPage("2").navigatePriorityPage(1).changeAppointment(2).verifyCalendarPage().selectAnyAppointment().reviewDetailsPage(userProfile)
		.navigateToConfirmationASV().navigateTrackCancelChangeTrack()
		.viewDetailsCompletePage(userProfile)
		/*
		 * ********************Reschedule IB
		 */
		.accountSummaryChangeAppointmentIB().verifyPriorityPage("2").navigatePriorityPage(1).clickCancelASV()
		.accountSummaryChangeAppointmentIB().verifyPriorityPage("2").navigatePriorityPage(1)
		.verifyCalendarPage().selectAnyAppointment().reviewDetailsPage(userProfile).clickBack()
		.verifyCalendarPage().clickBack().verifyPriorityPage("2").navigatePriorityPage(1)
		.verifyCalendarPage().selectAnyAppointment().reviewDetailsPage(userProfile).navigateToConfirmationASV()
		.viewDetailsCompletePage(userProfile).accountSummarycancelAppointment().verifyAddressBook(userProfile)
		.verifyAccountOverview("Ideal")
		/*
		 * ********************ASV
		 */
		.bookAnEngineerIB(userProfile, "ASV").verifyAddress(userProfile)
		.verifyCalendarPage().verifyCalendarPage().clickCancel()
		.selectFirstAvailableSlot().reviewDetailsPage(userProfile).clickBack()
		.verifyCalendarPage().selectAnyAppointment().reviewDetailsPage(userProfile).clickCancel().verifyAddressBook(userProfile)
		.bookAnEngineerIB(userProfile, "ASV").verifyAddress(userProfile)
		.verifyCalendarPage().selectAnyAppointment().reviewDetailsPage(userProfile).navigateToConfirmation()
		.verifyConfirmationPageASV().navigateTrackCancelChangeTrack();
		
	}
	// -----------------------------------------------------------------------------------------------------------
	/*
	 * 
	 * MultipleJobs_TC_01 IB Journey should be booked for BS1 & BS2
	 * 
	 * 
	 * 
	 * @Test(groups = { ASVIB, Regression }) public void mulitJobsIBBS1BS2() {
	 * Report.createTestLogHeader( "Multiple Status Bar Controls - IB Journey
	 * Test -BS1 & BS2", "HomeSerivcesAccount"); UserProfile userProfile = new
	 * TestDataHelper() .getUserProfile("HomeServciesAccount");
	 * 
	 * new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
	 * .navigateToAccountSummaryPageASV().bookAnEngineerIB( userProfile,
	 * "IV").verifyFaultPage() .clickFaultCategory("Home
	 * Electrics").clickFaultItemCheck()
	 * .clickFaultCategory("Gas").clickFaultItemCheck()
	 * .navigateToPriority().navigatePriorityPageASV(1)
	 * .selectAnAppointment().navigateToReviewIB(0)
	 * .navigateToConfirmationASV().navigateTrackCancelChangeBook()
	 * .verifyAccountOverview("PEND").viewDetailsCompletePage(
	 * userProfile).logout(); }
	 * 
	 * 
	 * MultipleJobs_TC_02 IB Journey should be booked for Different Address
	 * 
	 * 
	 * 
	 * @Test(groups = { ASVIB, Regression }) public void
	 * mulitJobsIBDiffAddress() { Report .createTestLogHeader( "Multiple Status
	 * Bar Controls - IB Journey Test - Different Address",
	 * "HomeSerivcesAccount"); UserProfile userProfile = new TestDataHelper()
	 * .getUserProfile("HomeServciesAccount");
	 * 
	 * new HomePageAction().navigateToLogin().loginUserDetails(userProfile)
	 * .navigateToAccountSummaryPageASV()
	 * .verifyAccountOverview("PEND").viewDetailsCompletePage(
	 * userProfile).logout(); } //
	 * -------------------------------------------------------------------------------------------------------------------
	 */

/////////////////////////////////IB BOOKING OVELAY VERIFICATION/////////////////////////////
@Test(groups = { ASVIB, Regression })
public void ibBookingOverlayVerificationNew(){
	Report.createTestLogHeader(
			"Booking Complete - IB Journey Test - COD,GAC Added",
			"HomeSerivcesAccount");
	UserProfile userProfile = new TestDataHelper()
			.getUserProfile("HomeServicesAccount");

	new HomePageAction()
	          .navigateToLogin()
	          .loginUserDetails(userProfile);
	new IBAction()
	          //.navigateToAccountSummaryPageAsv(userProfile)
	          .navigateToBookAnEngineerNow()   
			  .chooseAppliances()
			  .verifyOverlay()
			  .logout();
}
@Test(groups = { ASVIB, Regression })
public void ibBookingOverlayVerificationOld(){
	Report.createTestLogHeader(
			"IB Booking verify Overlay ",
			"HomeSerivcesAccount");
	UserProfile userProfile = new TestDataHelper()
			.getUserProfile("HomeServicesAccount");

	new HomePageAction()
	          .navigateToLogin()
	          .loginUserDetails(userProfile);
	new IBAction()
	          //.navigateToAccountSummaryPageAsv(userProfile)
	          .navigateToBookAnEngineerNow()   
			  .chooseAppliancesold()
			  .verifyOverlayOld()
			  .logout();
}
@Test(groups = { ASVIB, Regression })
public void ibBookingOverlayVerificationDeeplink(){
	Report.createTestLogHeader(
			"Booking Complete - IB Journey Test - COD,GAC Added",
			"HomeSerivcesAccount");
	UserProfile userProfile = new TestDataHelper()
			.getUserProfile("HomeServicesAccount");

	new HomePageAction()
	          .navigateToLoginIBDeepLink()
	          .loginUserDetails(userProfile);
	new IBAction()
	          //.navigateToAccountSummaryPageAsv(userProfile)
	          //.navigateToBookAnEngineerNow()   
			  .chooseAppliances()
			  .verifyOverlay()
			  .logout();
}
}