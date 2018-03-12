package bg.framework.app.functional.test.selfServe;

import static bg.framework.app.functional.entities.FunctionalCategory.ASVIB;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.selfServe.ASVIBAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class ASVIBTest extends TestBase {

	/*
     *  Mandatory field in UserProfile: UCRN,Account Number,Email.
     *  BGS ASV Journey For Booking First Slot
     */
	@Test(groups = { ASVIB,Regression })
	public void asvJourneyBookThisAppointment() {
		Report.createTestLogHeader("ASV Journey Test", "HomeServicesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServicesAccount");

		new HomePageAction().navigateToLogin();
		new ASVIBAction().loginUser(userProfile)
				.navigateToAccountSummaryPage(userProfile)
				.bookAnEngineer(userProfile, "ASV")
				.navigateToConfirmation(userProfile, 4).logout();
	}

	/*
     *  Mandatory field in UserProfile: UCRN,Account Number,Email.
     *  BGS IB Journey For Booking First Slot
     */
	@Test(groups = { ASVIB,Regression })
	public void ibJourneyBookThisAppointment() {

		Report.createTestLogHeader(
				"IB Journey Test To Book Current Appointment",
				"HomeServicesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServicesAccount");

		
		new HomePageAction().navigateToLogin();
		new ASVIBAction().loginUser(userProfile)
				.navigateToAccountSummaryPage(userProfile)
				.bookAnEngineer(userProfile, "IV").navigateToIdentifyFault(userProfile).navigateToReview(1)
				.navigateToConfirmation(userProfile, 1).logout();
	}

	/*
     *  Mandatory field in UserProfile: UCRN,Account Number,Email.
     *  BGS IB Journey For Booking and printing appointment
     */
	@Test(groups = { ASVIB ,Regression})
	public void ibJourneyToPrintAppointment() {
		Report.createTestLogHeader("IB Journey Test To Print Appointment",
				"HomeServicesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServicesAccount");
		
		new HomePageAction().navigateToLoginPage();

		new ASVIBAction().loginUser(userProfile)
				.navigateToAccountSummaryPage(userProfile).bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(userProfile).navigateToReview(1)
				.navigateToConfirmation(userProfile, 1)
				.navigateTrackCancelChange().viewDetails().verifyPrint()
				.logout();

	}

	
	/*
     *  Mandatory field in UserProfile: UCRN,Account Number,Email.
     *  BGS IB Journey For Reschedule and keep same appointment
     */
	@Test(groups = { ASVIB,Regression })
	public void IbJourneyToChangeAndKeepAppointment() {
		Report.createTestLogHeader(
				"Intermediate Breakdown Journey ,combine and keep Current Appointment,combine and change different slots",
				"HomeServicesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServicesAccount");
		
		new HomePageAction().navigateToLogin();

		new ASVIBAction().loginUser(userProfile)
				.navigateToAccountSummaryPage(userProfile).bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(userProfile)
		.navigateToReview(1)
				.navigateToConfirmation(userProfile, 1)
				.navigateTrackCancelChange()
				.logout();
		new ASVIBAction().loginUser(userProfile)
		.navigateToAccountSummaryPage(userProfile).bookAnEngineer(userProfile, "IV");
		new ASVIBAction().navigateToIdentifyFault(userProfile).navigateToReview(1).changeAppointment(1)
				.navigateToConfirmation(userProfile, 4)
				.navigateTrackCancelChange().logout();
				new ASVIBAction().loginUser(userProfile)
				.navigateToAccountSummaryPage(userProfile).bookAnEngineer(userProfile, "IV");
		new ASVIBAction().navigateToIdentifyFault(userProfile)
		.navigateToReview(1).changeAppointment(2)
				.navigateToConfirmation(userProfile, 1)
				.navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();

	}

	
	/*
     *  Mandatory field in UserProfile: UCRN,Account Number,Email.
     *  BGS IB Journey For Reschedule and keep same appointment
     */
	@Test(groups = { ASVIB,Regression })
	public void ibJourneyToJoinASVOverdue() {
		Report.createTestLogHeader(
				"IB Journey Test - Join ASV Overdue with IB",
				"HomeServicesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServicesAccount");

		new HomePageAction().navigateToLogin();
		
		new ASVIBAction().loginUser(userProfile)
				.navigateToAccountSummaryPage(userProfile).bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(userProfile)
		.navigateToReview(1).continueWithASV()
		.selectAnAppointment()
		.reviewDetailsPage()
		.navigateToConfirmation()
				
				.navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();

	}

	/*
     *  Mandatory field in UserProfile: UCRN,Account Number,Email.
     *  BGS IB Journey For Reschedule and change appointment
     */
	@Test(groups = { ASVIB,Regression })
	public void ibJourneyToChangeAppointment() {
		Report.createTestLogHeader("IB Journey Test To Change Appointment",
				"HomeServicesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServicesAccount");

		new HomePageAction().navigateToLogin();

		new ASVIBAction().loginUser(userProfile)
				.navigateToAccountSummaryPage(userProfile)
				.bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(userProfile)
		.navigateToReview(1)
				.navigateToConfirmation(userProfile, 1)
				.navigateTrackCancelChange()
				.accountSummaryChangeAppointmentIB()
				.navigatePriorityPage(4)
				.selectAnyAppointment()
				
				.reviewDetailsPage(userProfile)
				.navigateToConfirmation()
				.verifyConfirmationPageASV()
				.navigateTrackCancelChange()
				.accountSummarycancelAppointment()
				.logout();

	}

	/*
     *  Mandatory field in UserProfile: UCRN,Account Number,Email.
     *  BGS IB Journey For cancelling appointment
     */
	@Test(groups = { ASVIB ,Regression })
	public void ibJourneyToCancelAppointment() {
		Report.createTestLogHeader("IB Journey Test To Cancel Appointment",
				"HomeServicesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServicesAccount");

		new HomePageAction().navigateToLogin();
		

		new ASVIBAction().loginUser(userProfile)
				.navigateToAccountSummaryPage(userProfile).bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(userProfile)
		.navigateToReview(1)
				.navigateToConfirmation(userProfile, 1)
				.navigateTrackCancelChange().accountSummarycancelAppointment();
		// .logout();

	}

	/*
     *  Mandatory field in UserProfile: UCRN,Account Number,Email.
     *  BGS IB Journey For adding COD
     */
	@Test(groups = { ASVIB,Regression})
	public void ibJourneyAddCod() {

		Report.createTestLogHeader("IB Journey Test To Add COD",
				"HomeServicesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServicesAccount");

		
		new HomePageAction().navigateToLogin();
				new ASVIBAction()
				.loginUser(userProfile)
				.navigateToAccountSummaryPage(userProfile)
				.bookAnEngineer(userProfile, "IV")
				.navigateToIdentifyFault(userProfile)
				.navigateToReview(1)
				.navigateToConfirmation(userProfile, 3)
				.navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();
	}

	/*
     *  Mandatory field in UserProfile: UCRN,Account Number,Email.
     *  BGS IB Journey For combining with ASV
     */
	@Test(groups = { ASVIB,Regression })
	public void IbJourneyToJoinWithASV() {
		Report.createTestLogHeader(
				"IB Journey Test To Join With ASV Appointment",
				"HomeServicesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServicesAccount");
		
		
		new HomePageAction().navigateToLogin();

		new ASVIBAction()
		.loginUser(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.bookAnEngineer(userProfile, "ASV")
		//.selectAnAppointment()
		.reviewDetailsPage()
		.navigateToConfirmation()
		//.navigateToConfirmation(userProfile, 4)
		.navigateTrackCancelChange()
		/*.logout();
		new ASVIBAction()
		.loginUser(userProfile)
		.navigateToAccountSummaryPage(userProfile)*/
		.bookAnEngineer(userProfile, "IV")		
		.navigateToIdentifyFault(userProfile)		
		.navigateToReview(1)
		.changeAppointment(1)
		.navigateToConfirmation(userProfile, 4)
		.navigateTrackCancelChange()
		.logout();

	}

	/*
     *  Mandatory field in UserProfile: UCRN,Account Number,Email.
     *  BGS ASV Journey  with No Time Slot
     */
	@Test(groups = { ASVIB , Regression })
	public void asvNoTimeSlot() {
		Report.createTestLogHeader("ASV journey for no time slot",
				"HomeServicesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServicesAccount");	
		
		new HomePageAction().navigateToLogin();	

		new ASVIBAction()
		.loginUser(userProfile)
		.navigateToASVFromOverviewPage()
		.noSlotAvailable()
		.logout();
	}

	/*
     *  Mandatory field in UserProfile: UCRN,Account Number,Email.
     *  BGS ASV Journey  with selecting different Time Slot
     */
	@Test(groups = { ASVIB  })
	public void asvDifferentTimeSlot() {
		Report.createTestLogHeader("ASV journey for different time slot",
				"HomeServicesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServicesAccount");
		
		new HomePageAction().navigateToLogin();

		new ASVIBAction().loginUser(userProfile)
				.navigateToAccountSummaryPage(userProfile)
				.navigateToViewAllAppointments().selectAnAppointment()
				.reviewDetailsPage().navigateToConfirmation()
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();
	}

	/*
     *  Mandatory field in UserProfile: UCRN,Account Number,Email.
     *  BGS ASV Journey  for cancelling booked appointment
     */
	@Test(groups = { ASVIB ,Regression })
	public void asvCancelAppointment() {
		Report.createTestLogHeader("ASV journey cancel appointment",
				"HomeServicesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServicesAccount");
		
		new HomePageAction().navigateToLogin();

		new ASVIBAction().loginUser(userProfile)
				.navigateToAccountSummaryPage(userProfile)
				.navigateToViewAllAppointments().selectAnAppointment()
				.reviewDetailsPage().navigateToConfirmation()
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();
	}

	/*
     *  Mandatory field in UserProfile: UCRN,Account Number,Email.
     *  BGS ASV Journey  for changing booked appointment
     */
	@Test(groups = { ASVIB,Regression  })
	public void asvChangeAppointment() {
		Report.createTestLogHeader("ASV journey change appointment",
				"HomeServicesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServicesAccount");
		
		new HomePageAction().navigateToLogin();

		new ASVIBAction().loginUser(userProfile)
				.navigateToAccountSummaryPage(userProfile)
				.navigateToViewAllAppointments().selectAnAppointment()
				.reviewDetailsPage().navigateToConfirmation()
				.navigateTrackCancelChange().accountSummaryChangeAppointment()
				.selectAnAppointment().reviewDetailsPage()
				.navigateToConfirmation().navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();
	}

	/*
     *  Mandatory field in UserProfile: UCRN,Account Number,Email.
     *  BGS ASV Journey  for adding COD
     */
	@Test(groups = { ASVIB, Regression  })
	public void asvWithCOD() {
		Report.createTestLogHeader("ASV journey add with COD",
				"HomeServicesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServicesAccount");
		
		new HomePageAction().navigateToLogin();

		new ASVIBAction().loginUser(userProfile)
				.navigateToAccountSummaryPage(userProfile)
				.navigateToViewAllAppointments().selectAnAppointment()
				.reviewDetailsPage().addCOD(userProfile)
				.navigateTrackCancelChange().accountSummarycancelAppointment()
				.logout();
	}

	/*
     *  Mandatory field in UserProfile: UCRN,Account Number,Email.
     *  BGS ASV Journey  for Adding GAC
     */
	@Test(groups = { ASVIB , Regression })
	public void asvWithGAC() {
		Report.createTestLogHeader("ASV journey with GAC",
				"HomeServicesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServicesAccount");
		
		new HomePageAction().navigateToLogin();

		new ASVIBAction().loginUser(userProfile)
				.navigateToAccountSummaryPage(userProfile)
				.navigateToViewAllAppointments().selectAnAppointment()
				.reviewDetailsPage().addGAC().navigateTrackCancelChange()
				.accountSummarycancelAppointment().logout();
	}
	
	/*
	 * Mandatory field in ASVIB.properties: UserID , Postcode
     *  Mandatory field in UserProfile: UCRN,Account Number,Email.
     *  Fast Track ASV Booking-OAM 
     */
	@Test(groups = { ASVIB ,Regression})
	public void fastTrackASVBooking() {
		Report.createTestLogHeader("Fast Track OAM ASV  booking",
				"HomeServicesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServicesAccount");
		new ASVIBAction()
		.fastTrackASVnavigateToLogin()
		.fastTrackASVLogin()
		.fastTrackConfirmAddressDetails()
		.fastTrackSelectAppointment()
		.fastTrackReviewPageDetailsAC(userProfile)
		.fastTrackConfirmationPage()
		.loginUser(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.accountSummarycancelAppointment()
		.logout();
	}
	
	/*
	 * Mandatory field in ASVIB.properties: UserID , Postcode
     *  Mandatory field in UserProfile: UCRN,Account Number,Email.
     *  Fast Track ASV Booking - Anonymous Account
     */
	@Test(groups = { ASVIB,Regression })
	public void fastTrackAnonymousASVBooking() {
		Report.createTestLogHeader("Fast Track Anonymous ASV booking",
				"HomeServicesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServicesAccount");	
		new ASVIBAction()
		.fastTrackASVnavigateToLogin()
		.fastTrackASVLogin()
		.fastTrackConfirmAddressDetails()
		.fastTrackSelectAppointment()
		.fastTrackReviewPageDetailsAC(userProfile)
		.fastTrackConfirmationPage()
		.loginUser(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.accountSummarycancelAppointment()
		.logout();
	}
	
	/* Combining_TC_04
	 * IB Journey combined with Booked IB - Keep appointment
	 * Priority 'Y' for both
	 * HC400
	 */
	@Test(groups = { ASVIB,Regression })
	public void ibBookingWithBookedIBKeepAppointmentBothPriorY()
	{
		Report.createTestLogHeader("Combine Link -IB combined with Booked IB Journey Test with both has priority - Keep slots ", "HomeServicesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare400Account");
		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)		
		.navigateToAccountSummaryPageASV()
		.bookAnEngineerIB(userProfile, "IV")
		.navigateToIdentifyFault(1,userProfile)
		.navigatePriorityPage(1)
		.selectAnyAppointment()
		.reviewDetailsPage(userProfile)
		.navigateToConfirmationASV()
		.logoutReturn()
		.navigateToLogin()
		.loginUserDetails(userProfile)		
		.navigateToAccountSummaryPageASV()
		.bookAnEngineerIB(userProfile, "IV")
		.navigateToIdentifyFault(1,userProfile)
		.navigatePriorityPageASV(1)
		.changeAppointment(1)
		.reviewDetailsPage()
		.navigateToConfirmation()
		.navigateTrackCancelChange()
		.logout();	
		
	}

	 /*  ViewDiary_002
	  * Mandatory field in UserProfile: UCRN,Account Number,Email.
     *  BGS IB Journey For combining with ASV
     */
	@Test(groups = { ASVIB,Regression })
	public void ibJourneyToJoinASVViewDiary() {
		Report.createTestLogHeader(
				"View Diary - IB Journey Test To Join With ASV Appointment",
				"HomeServicesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServicesAccount");
		
		
		new HomePageAction().navigateToLogin();

		new ASVIBAction()
		.loginUser(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.bookAnEngineer(userProfile, "ASV")
		.navigateToConfirmation(userProfile, 4)
		.navigateTrackCancelChange()
		/*.logout();
		new ASVIBAction()
		.loginUser(userProfile)
		.navigateToAccountSummaryPage(userProfile)*/
		.bookAnEngineer(userProfile, "IV")		
		.navigateToIdentifyFault(userProfile)		
		.navigateToReview(1)
		.changeAppointment(1)
		.navigateToConfirmation(userProfile, 4)
		.navigateTrackCancelChangeBook()
		.verifyAccountOverview("Booked")
		.logout();

	}

	/* Cancel_TC_02
	 * IB Journey combined with Booked IB
	 * HC 300 Flexi
	 * 
	 */
	@Test(groups = { ASVIB,Regression })
	public void cancelIbBookingWithBookedIB()
	{
		Report.createTestLogHeader("Cancel Appointment -IB combined with Booked IB Journey Test", "HomeServicesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");
		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)		
		.navigateToAccountSummaryPageASV()
		.verifyAccountOverview("ideal")
		.bookAnEngineer(userProfile, "IV")
		.navigateToIdentifyFault(userProfile)
		.navigateToReview(1)
		.selectAnAppointment()
		.navigateToConfirmation(userProfile, 4)
		.navigateTrackCancelChange()
		.logoutReturn()
		.navigateToLogin()
		.loginUserDetails(userProfile)		
		.navigateToAccountSummaryPageASV()
		.bookAnEngineer(userProfile, "IV")
		.navigateToIdentifyFault(userProfile)
		.navigateToReview(1)	
		.changeAppointment(1)
		.navigateToConfirmation(userProfile, 1)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();	
	}
	
	/* Cancel_TC_03
	 * IB Journey combined with Booked IB
	 * HC 300 Flexi
	 * 
	 */
	@Test(groups = { ASVIB,Regression })
	public void cancelIbBookingWithBookedIBPriority()
	{
		Report.createTestLogHeader("Cancel Appointment -IB combined with Booked IB Journey Test", "HomeServicesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");
		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)		
		.navigateToAccountSummaryPageASV()
		.verifyAccountOverview("ideal")
		.bookAnEngineer(userProfile, "IV")
		.navigateToIdentifyFault(1,userProfile)
		.navigatePriorityPageASV(1)
		.navigateToReview(1)
		.selectAnAppointment()
		.navigateToConfirmation(userProfile, 4)
		.navigateTrackCancelChange()
		.logoutReturn()
		.navigateToLogin()
		.loginUserDetails(userProfile)		
		.navigateToAccountSummaryPageASV()
		.bookAnEngineer(userProfile, "IV")
		.navigateToIdentifyFault(userProfile)
		.navigateToReview(1)	
		.changeAppointment(1)
		.navigateToConfirmation(userProfile, 1)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();	
	}

	/* Rescheduling_TC_01
	 * IB Journey combined with Booked IB with Priority 'N'
	 * Changed to Priority 'Y'
	 * HC300flexi
	 */
	@Test(groups = { ASVIB,Regression })
	public void rescheduleIbBookingWithBookedIBWithPrior()
	{
		Report.createTestLogHeader("Reschedule Appointment -IB combined with Booked IB Journey Test - ", "HomeServicesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeCare300Account");
		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)		
		.navigateToAccountSummaryPageASV()
		.verifyAccountOverview("ideal")
		.bookAnEngineer(userProfile, "IV")
		.navigateToIdentifyFault(userProfile)
		.navigateToReview(1)
		.selectAnAppointment()
		.navigateToConfirmation(userProfile, 4)
		.navigateTrackCancelChange()
		.logoutReturn()
		.navigateToLogin()
		.loginUserDetails(userProfile)		
		.navigateToAccountSummaryPageASV()
		.bookAnEngineer(userProfile, "IV")
		.navigateToIdentifyFault(userProfile)
		.navigateToReview(1)
		.changeAppointment(1)
		.navigateToConfirmation(userProfile, 1)
		.navigateTrackCancelChangeIB()
		.accountSummaryChange()
		.navigatePriorityPage(2)
		.selectAnyAppointment()
		.reviewDetailsPage(userProfile)
		.navigateToConfirmationASV()
		.logout();
	}
	
	/* Rescheduling_TC_08
	 * IB Journey combined with ASV with prior
	 * Changed to priority 'Y'
	 * 
	 */
	@Test(groups = { ASVIB,Regression})
	public void rescheduleIbBookingWithASVWithoutPrior()
	{
		Report.createTestLogHeader("Rescheduling -ASV combined with IB Journey Test - Without Priority ", "HomeServicesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServicesAccount");
		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)		
		.navigateToAccountSummaryPageASV()
		.verifyAccountOverview("ideal")
		.bookAnEngineerIB(userProfile, "ASV")					
		.selectAnyAppointment()
		.reviewDetailsPage(userProfile)
		.navigateToConfirmationASV()
		.logoutReturn()
		.navigateToLogin()
		.loginUserDetails(userProfile)		
		.navigateToAccountSummaryPageASV()
		.bookAnEngineerIB(userProfile, "IV")
		.navigateToIdentifyFault(1,userProfile)
		.navigatePriorityPage(0)
		.selectAnyAppointment()
		.reviewDetailsPage(userProfile)
		.navigateToConfirmationASV()
		.navigateTrackCancelChangeIB()
		.accountSummaryChange()
		.navigatePriorityPage(1)
		.selectAnyAppointment()
		.reviewDetailsPage(userProfile)
		.navigateToConfirmationASV()
		.logout();
	
	}

	/* Cancel_TC_04
	 * IB Journey combined with ASV with prior
	 * Changed to priority 'Y'
	 * HC300Flexi
	 */
	@Test(groups = { ASVIB,Regression})
	public void cancelIbBookingWithASVWithoutPrior()
	{
		Report.createTestLogHeader("Cancel -ASV combined with IB Journey Test - With Priority ", "HomeServicesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServicesAccount");
		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)		
		.navigateToAccountSummaryPageASV()
		.verifyAccountOverview("ideal")
		.bookAnEngineerIB(userProfile, "ASV")					
		.selectAnyAppointment()
		.reviewDetailsPage(userProfile)
		.navigateToConfirmationASV()
		.logoutReturn()
		.navigateToLogin()
		.loginUserDetails(userProfile)		
		.navigateToAccountSummaryPageASV()
		.bookAnEngineerIB(userProfile, "IV")
		.navigateToIdentifyFault(1,userProfile)
		.navigatePriorityPage(0)
		.selectFirstAvailableSlot()
		.reviewDetailsPage(userProfile)
		.navigateToConfirmationASV()
		.navigateTrackCancelChangeIB()
		.accountSummaryChange()
		.navigatePriorityPage(1)
		.selectFirstAvailableSlot()
		.reviewDetailsPage(userProfile)
		.navigateToConfirmationASV()
		.accountSummarycancelAppointment()
		.logout();
	
	}

	/* NA_TC_16			
	 * IB rescheduled in NA1 status
	 * Ib should be booked
	 * Rescheduled offline
	 * Set as NA1 status in WMIS
	 */
	@Test(groups = { ASVIB })
	public void na1IB()
	{
		Report.createTestLogHeader("IB NA1 -IB Journey Test-", "HomeServicesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServicesAccount");
		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)		
		.navigateToAccountSummaryPageASV()
		.verifyAccountOverviewASV("NA1")			
		.logout();
	}


}
