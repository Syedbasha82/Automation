package bg.framework.app.functional.test.reFactoring;

import static bg.framework.app.functional.entities.FunctionalCategory.ASVIB;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.reFactoring.ASVAction;
import bg.framework.app.functional.action.selfServe.ASVIBAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class ASVTest extends TestBase{
//------------------------------------------------------------------------------------------------------------------------
	/* BookAnASV_TC_05
	 * BookingComplete_TC_01
	 * ASV Journey with GAC added
	 * 
	 * 
	 */
	@Test(groups = { ASVIB ,Regression}) 
	public void asvBookingComplete()
	{
		Report.createTestLogHeader("Booking Complete - ASV Journey Test - GAC Added", "HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");
		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAccountOverview("Ideal")
		.clickBookThisAppointment(userProfile,"ASV")
		.reviewDetailsPage()
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}
	
	/* BookAnASV_TC_19,BookAnASV_TC_20,BookAnASV_TC_21,BookAnASV_TC_27
	 * BookingComplete_TC_04
	 * ASV Journey with view all slots and select the first available slot
	 * 
	 */
	@Test(groups = { ASVIB,Regression })
	public void asvBookingCompleteViewSlotsBookFirst()
	{
		Report.createTestLogHeader("Booking Complete - ASV Journey Test - View Slots - Book First", "HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeSerivcesAccount");
		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAccountOverview("Ideal")
		.navigateToViewAllAppointments()
		.selectAnAppointment()
		.reviewDetailsPage()
		.navigateToConfirmation()
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}

	/* Linking_TC_22
	 * BookingComplete_TC_03
	 * ASV Journey combined with IB added COD
	 * 
	 * 
	 */
	@Test(groups = { ASVIB,Regression })
	public void BookingCompleteAsvBookingWithIB()
	{
		Report.createTestLogHeader("Booking Complete -ASV combined with IB Journey Test - Book First - Added GAC & COD", "HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeSerivcesAccount");
		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAccountOverview("Ideal")
		.bookAnEngineer(userProfile, "IV")		
		.navigateToIdentifyFault()		
		.navigateToReview(1)		
		.selectAnAppointment()
		.navigateToConfirmation(userProfile, 4)
		.navigateTrackCancelChange()
		.bookAnEngineer(userProfile, "ASV")					
		.navigateToConfirmation(userProfile, 1)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	
	}

	/* BookingComplete_TC_33
	 * GetAppointment Call should be triggered upon clicking View Account button from the Landing page.
	 * GetProductHoldings and GetOpenJobs call should be triggered upon Login.
	 * Confirm appointment slot' call should fail
	 * ASV should be due for the Customer.	 
	 */
	
	@Test(groups = { ASVIB ,Regression}) 
	public void asvPICallFailErrorMessageBookingComplete()
	{
		Report.createTestLogHeader("ASV PI Call Error Message in confirmation page", "HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeSerivcesAccount");
		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)		
		.navigateToAccountSummaryPageASV()
		.navigateToViewAllAppointments()
		.selectAnAppointment()
		.reviewDetailsPage()
		.navigateToConfirmation()
		.verifyPiCallErrorMessage()
		.logout();
	}
	//------------------------------------------------------------------------------------------------------------------------
	
	/* CombiningASV-Breakdown_TC_27
	 * CombineLink_TC_03
	 * ASV Journey combined with IB added COD
	 * 
	 * 
	 */
	@Test(groups = { ASVIB,Regression })
	public void asvBookingWithIB()
	{
		Report.createTestLogHeader("Combine Link -ASV combined with IB Journey Test - Book First - Added GAC & COD", "HomeSerivcesAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("HomeSerivcesAccount");		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.bookAnEngineer(userProfile, "IV")
		.navigateToIdentifyFault()
		.navigateToReview(1)
		.selectAnAppointment()
		.navigateToConfirmation(userProfile, 4)
		.navigateTrackCancelChange()
		.logoutReturn()
		.navigateToLogin()
		.loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.bookAnEngineer(userProfile, "IV")
		.navigateToIdentifyFault()
		.navigateToReview(1)
		.changeAppointment(1)
		.navigateToConfirmation(userProfile, 1)
		.navigateTrackCancelChange()
		.logoutReturn()
		.navigateToLogin()
		.loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.bookAnEngineer(userProfile, "ASV")
		.changeAppointment(1)
		.reviewDetailsPage()			
		.navigateToConfirmation()
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	
	}
	//------------------------------------------------------------------------------------------------------------------------
	
	/* BookAnASV_TC_19,BookAnASV_TC_27
	 * ContactDetails_TC_01
	 * ASV Journey to check phone number and mobile number
	 * 
	 * 
	 */
	@Test(groups = { ASVIB ,Regression})
	public void contactDetailsAsvBooking()
	{
		Report.createTestLogHeader("Contact Details -ASV - Book First - Check Mobile Number", "HomeSerivcesAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("HomeSerivcesAccount");		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.bookAnEngineerASV(userProfile, "ASV")
		.checkMobileNumber(userProfile)		
		.logout();
	
	}
	
	/* ContactDetails_TC_02
	 * ASV Journey to check and modify home number
	 * 
	 * 
	 */
	@Test(groups = { ASVIB ,Regression})
	public void contactDetailsAsvBookingHomeNumber()
	{
		Report.createTestLogHeader("Contact Details -ASV - Book First - Modify Home Number", "HomeSerivcesAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("HomeSerivcesAccount");		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.bookAnEngineerASV(userProfile, "ASV")
		.checkHomeNumber(userProfile)
		.modifyHomeNumber()
		.logout();
	
	}
	
	/* RescheduleASV_TC_13,RescheduleASV_TC_14,RescheduleASV_TC_15,RescheduleASV_TC_18
	 * ContactDetails_TC_03
	 * RESCHEDULING ASV Journey to check mobile number
	 * 
	 * 
	 */
	@Test(groups = { ASVIB ,Regression})
	public void contactDetailsAsvReschedulingMobileNumber()
	{
		Report.createTestLogHeader("Contact Details -ASV RESCHEDULING - Book First - Modify Home Number", "HomeSerivcesAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("HomeSerivcesAccount");		
		new HomePageAction().navigateToLogin();
		new ASVIBAction().loginUser(userProfile)
				.navigateToAccountSummaryPage(userProfile)
				.bookAnEngineer(userProfile, "ASV")				
		.navigateToConfirmation(userProfile, 1)
		.navigateTrackCancelChangeASV()
		.accountSummaryChangeAppointment()
		.selectAnAppointment()
		.checkNewMobileNumber(userProfile)		
		.logout();
	
	}

	//------------------------------------------------------------------------------------------------------------------------
	/* BookABreakdown_TC_21
	 * COMP_TC_01				
	 * ASV in COMP status
	 * 
	 */
	@Test(groups = { ASVIB })
	public void completeASVComp()
	{
		Report.createTestLogHeader("Completed -ASV Journey Test-", "HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeSerivcesAccount");
		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)		
		.navigateToAccountSummaryPageASV()
		.verifyAccountOverviewASV("Comp")					
		.logout();
	}

//------------------------------------------------------------------------------------------------------------------------
	/*
	 * Bookingjourney_TC_01
	 * ASV Journey with Booking Control Flag OFF
	 * 
	 * 
	 */
	@Test(groups = { ASVIB ,Regression}) 
	public void asvBookingControls()
	{
		Report.createTestLogHeader("Booking Controls - ASV Journey Test ", "HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeSerivcesAccount");
		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAccountOverview("Ideal")
		.clickBookThisAppointment(userProfile,"ASV")
		.selectAnAppointmentBookingCtrlOff()
		.reviewDetailsPage()	
		.navigateToConfirmation()
		.confirmationImageCheck()
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}
//------------------------------------------------------------------------------------------------------------------------
	/*
	 * StatusbarOnline_TC_01
	 * ASV Journey should be booked
	 * 
	 * 
	 */
	@Test(groups = { ASVIB ,Regression}) 
	public void asvStatusBarControls()
	{
		Report.createTestLogHeader("Status Bar Controls - ASV Journey Test ", "HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeSerivcesAccount");
		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)		
		.navigateToAccountSummaryPageASV()
		.verifyAccountOverview("PEND")
		.viewDetailsCompletePage(userProfile)
		.logout();
	}

//------------------------------------------------------------------------------------------------------------------------
		/*
		 * BookAnASV_TC_32
		 * ASV must be due & slots are not available in WMIS system
		 * 
		 * 
		 */
		@Test(groups = { ASVIB ,Regression}) 
		public void asvNoTimeSlots()
		{
			Report.createTestLogHeader("ASV due and no time slots", "HomeSerivcesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeSerivcesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.verifyErrorMessage()
			.logout();
		}
		
		/* BookAnASV_TC_33
		 * ASV must be due & slots are not available in WMIS system
		 * GetAppointment Call should be triggered upon clicking View Account button from the Landing page.
         * GetProductHoldings and GetOpenJobs call should be triggered upon Login.
         * Confirm appointment slot' call should fail         
		 * 
		 */
		@Test(groups = { ASVIB ,Regression}) 
		public void asvPICallFailErrorMessage()
		{
			Report.createTestLogHeader("ASV PI Call Error Message", "HomeSerivcesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeSerivcesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.navigateToViewAllAppointments()
			.selectAnAppointment()
			.reviewDetailsPage()
			.navigateToConfirmation()
			.verifyPiCallErrorMessage()
			.logout();
		}

		/* BookAnASV_TC_35
		 * ASV must be due & slots are not available in WMIS system
		 * GetAppointment Call should be triggered upon clicking View Account button from the Landing page.
		 * GetProductHoldings and GetOpenJobs call should be triggered upon Login.
		 * Get appointment slot' call should fail.
         * 		 
		 */
		@Test(groups = { ASVIB ,Regression}) 
		public void asvPICallFailAccSumaryErrorMessage()
		{
			Report.createTestLogHeader("ASV PI Call - Getappointment slot -  Error Message", "HomeSerivcesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeSerivcesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()			
			.verifyPiCallErrorMessage()
			.logout();
		}

		/* BookAnASV_TC_07
	 	 * The user should be an OAM user.
	 	 * The user should have a BGS account.
         * 		 
		 */
		@Test(groups = { ASVIB ,Regression}) 
		public void asvVerifyLinkNavigation()
		{
			Report.createTestLogHeader("ASV - Verify Links and Navigation -  Error Message", "HomeSerivcesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeSerivcesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.verifyAccountOverview("ideal")								
			.verifyLinkNavigation("ASV")
			.navigateBack()
			.verifyLinkNavigation("IB")
			.navigateBack()
			.logout();
			
		}

		/* BookAnASV_TC_01
	 	 * The user should be an OAM user.
	 	 * The user should have a BGS account.
         * Standard Slots
		 */
		@Test(groups = { ASVIB ,Regression}) 
		public void asvChangeFromCalendar()
		{
			Report.createTestLogHeader("ASV - Verify Links and Navigation -  Error Message", "HomeSerivcesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeServciesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.navigateToViewAllAppointmentsIB()
			.selectAnyAppointment()
			.clickChangeAppointment()		
			.verifyCalendarPage()
			.logout();
			
		}

		/* BookAnASV_TC_13				
		 * ASV in COMP status
		 * 
		 */
		@Test(groups = { ASVIB })
		public void bookCompleteASVComp()
		{
			Report.createTestLogHeader("Completed -ASV Journey Test-COMP", "HomeSerivcesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeSerivcesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.navigateToViewAllAppointmentsIB()
			.selectAnAppointment("PM2to4")
			.reviewDetailsPage()
			.navigateToConfirmationASV()
			.navigateTrackCancelChangeBook()
			.verifyAccountOverviewASV("Comp")					
			.logout();
		}
		
		/* BookAnASV_TC_15		
		 * ASV in HOLD status
		 * 
		 */
		@Test(groups = { ASVIB })
		public void bookCompleteASVHold()
		{
			Report.createTestLogHeader("Completed -ASV Journey Test-HOLD", "HomeSerivcesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeSerivcesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.navigateToViewAllAppointmentsIB()
			.selectAnAppointment("8to10")
			.reviewDetailsPage()
			.addGAC()
			.addCOD(userProfile)
			.navigateToConfirmationASV()
			.navigateTrackCancelChangeBook()
			.verifyAccountOverviewASV("Hold")					
			.logout();
		}
		
		/* BookAnASV_TC_17
		 * ASV in SITE status
		 * 
		 */
		@Test(groups = { ASVIB })
		public void bookCompleteASVSite()
		{
			Report.createTestLogHeader("Completed -ASV Journey Test-SITE", "HomeSerivcesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeSerivcesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.navigateToViewAllAppointmentsIB()
			.selectAnAppointment("10to12")
			.reviewDetailsPage()
			.navigateToConfirmationASV()
			.navigateTrackCancelChangeBook()
			.verifyAccountOverviewASV("Site")					
			.logout();
		}
		
		/* BookAnASV_TC_26
		 * ASV in HOLD status
		 * 
		 */
		@Test(groups = { ASVIB })
		public void bookCompleteASVAMGac()
		{
			Report.createTestLogHeader("Completed -ASV Journey Test-GAC", "HomeSerivcesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeSerivcesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.navigateToViewAllAppointmentsIB()
			.selectAnAppointment("AM")
			.reviewDetailsPage()
			.addGAC()			
			.navigateToConfirmationASV()
			.navigateTrackCancelChangeBook()
			.verifyAccountOverviewASV("Site")					
			.logout();
		}
		
		/* BookAnASV_TC_28
		 * ASV in HOLD status
		 * 
		 */
		@Test(groups = { ASVIB })
		public void bookCompleteASVFFCod()
		{
			Report.createTestLogHeader("Completed -ASV Journey Test-COD-FF", "HomeSerivcesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeSerivcesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.navigateToViewAllAppointmentsIB()
			.selectAnAppointment("FF")
			.reviewDetailsPage()			
			.addCODASVIB(userProfile)			
			.navigateTrackCancelChangeBook()								
			.logout();
		}
		
		
//------------------------------------------------------------------------------------------------------------------------
		
		/* CancelASV_TC_01
		 * The user should be an OAM user.
         * The user should have a BGS account.
         * 			 
		 */
		 
		public void asvBookingCancel()
		{
			Report.createTestLogHeader("ASV Cancel appointment from account summary page", "HomeSerivcesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeSerivcesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)
			.navigateToAccountSummaryPageASV()
			.verifyAccountOverview("Ideal")
			.navigateToViewAllAppointments()
			.selectAnAppointment()
			.reviewDetailsPage()
			.navigateToConfirmation()							
			.navigateTrackCancelChange()
			.accountSummarycancelAppointment()
			.logout();
				
		}
		
		
		/* CancelASV_TC_02
		 * The user should be an OAM user.
         * The user should have a BGS account.
         * 			 
		 */
		 
		public void asvBookingCancelFromView()
		{
			Report.createTestLogHeader("ASV Cancel appointment from view details page", "HomeSerivcesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeSerivcesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)
			.navigateToAccountSummaryPageASV()
			.verifyAccountOverview("Ideal")
			.navigateToViewAllAppointments()
			.selectAnAppointment()
			.reviewDetailsPage()
			.navigateToConfirmation()							
			.navigateTrackCancelChange()
			.viewDetailsCompletePage(userProfile)
			.accountSummarycancelAppointmentViewDetail()
			.logout();
				
		}
		
//------------------------------------------------------------------------------------------------------------------------
		
		/* CombiningBreakdownBS1_TC_23
		 * The user should be an OAM user.
         * The user should have a BGS account.
         * GetProductHoldings and GetOpenJobs call should be triggered upon Login.
		 */
		 
		public void CombiningBreakdownFromView()
		{
			Report.createTestLogHeader("CombiningBreakdown appointment from view details page", "HomeSerivcesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeSerivcesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)
			.navigateToAccountSummaryPageASV()
			.verifyAccountOverview("Ideal")
			.navigateToViewAllAppointments()
			.selectAnAppointment()
			.reviewDetailsPage()
			.navigateToConfirmation()							
			.navigateTrackCancelChange()
			.viewDetailsCompletePage(userProfile)
			.accountSummarycancelAppointmentViewDetail()
			.logout();
				
		}
//------------------------------------------------------------------------------------------------------------------------
		
		/* RescheduleASV_TC_19
		 * The user should be an OAM user.
         * The user should have a BGS account.
         * HC 200 Customer
         * 		 
		 */
		 
		public void asvRescheduleVerifyNavigation()
		{
			Report.createTestLogHeader("ASV - Reschedule - Verify Navigation Page - HC200", "HomeSerivcesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeCare200Account");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()											
			.verifyLinkNavigation("AccOverviewASV")
			.navigateBack()
			.verifyLinkNavigation("AccOverviewIB")
			.navigateBack()
			.logout();
				
		}

		/* RescheduleASV_TC_02
		 * The user should be an OAM user.
         * The user should have a BGS account.
         * 
         * 		 
		 */
		 
		public void asvBookingChangeFromReview()
		{
			Report.createTestLogHeader("ASV - Verify Changing appliance from review Page ", "HomeSerivcesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeCare200Account");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.navigateToViewAllAppointmentsIB()
			.selectAnyAppointmentASV()			
			.navigateToReviewIB(1)					
			.navigateToConfirmationASV()
			.navigateTrackCancelChangeASV()
			.accountSummaryChangeAppointmentIB()			
			.verifyCalendarPage()
			.selectAnyAppointment()
			.reviewDetailsPage()
			.navigateToConfirmationASV()
			.navigateTrackCancelChange()
			.accountSummarycancelAppointment()
			.logout();						
		}

		/* RescheduleASV_TC_17
		 * The user should be an OAM user.
         * The user should have a BGS account.
         * 
         * 		 
		 */
		 
		public void asvBookingChangeFromReviewCompleteJourney()
		{
			Report.createTestLogHeader("ASV - Verify Changing appliance from review Page-Complete Journey ", "HomeSerivcesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeSerivcesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.navigateToViewAllAppointmentsIB()
			.selectAnyAppointmentASV()			
			.navigateToReviewIB(1)					
			.navigateToConfirmationASV()
			.navigateTrackCancelChangeASV()
			.accountSummaryChangeAppointmentIB()			
			.verifyCalendarPage()
			.selectAnyAppointment()
			.reviewDetailsPage()
			.navigateToConfirmationASV()
			.navigateTrackCancelChange()
			.accountSummarycancelAppointment()
			.logout();						
		}

		
		/* RescheduleASV_TC_09
		 * The user should be an OAM user.
         * The user should have a BGS account.
         * HC 200
         * 		 
		 */
		 
		public void asvBookingChangeCOMP8to10slot()
		{
			Report.createTestLogHeader("ASV - Verify Comp Status - 8am to 10am slot ", "HomeSerivcesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeSerivcesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.navigateToViewAllAppointmentsIB()
			.selectAnyAppointmentASV()			
			.navigateToReviewIB(1)					
			.navigateToConfirmationASV()
			.navigateTrackCancelChangeASV()
			.accountSummaryChangeAppointmentIB()			
			.verifyCalendarPage()
			.selectAnAppointment("8to10")
			.reviewDetailsPage()
			.navigateToConfirmationASV()
			.navigateTrackCancelChangeBook()
			.verifyAccountOverview("COMP")
			.accountSummarycancelAppointment()			
			.logout();						
		}

		/* RescheduleASV_TC_11
		 * The user should be an OAM user.
         * The user should have a BGS account.
         * HC 200
         * 		 
		 */
		 
		public void asvBookingChangePend10to12slot()
		{
			Report.createTestLogHeader("ASV - Verify Comp Status - 10am to 12pm slot ", "HomeSerivcesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeCare200Account");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.navigateToViewAllAppointmentsIB()
			.selectAnyAppointmentASV()			
			.navigateToReviewIB(1)					
			.navigateToConfirmationASV()
			.navigateTrackCancelChangeASV()
			.accountSummaryChangeAppointmentIB()			
			.verifyCalendarPage()
			.selectAnAppointment("10to12")
			.reviewDetailsPage()
			.navigateToConfirmationASV()
			.navigateTrackCancelChangeBook()
			.verifyAccountOverview("Pend")
			.accountSummarycancelAppointment()			
			.logout();						
		}
		
		/* RescheduleASV_TC_12
		 * The user should be an OAM user.
         * The user should have a BGS account.
         * HC 300
         * 		 
		 */
		 
		public void asvBookingChangePend4to6slot()
		{
			Report.createTestLogHeader("ASV - Verify Comp Status - 4pm to 6pm slot ", "HomeSerivcesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeCare300Account");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.navigateToViewAllAppointmentsIB()
			.selectAnyAppointmentASV()			
			.navigateToReviewIB(1)					
			.navigateToConfirmationASV()
			.navigateTrackCancelChangeASV()
			.accountSummaryChangeAppointmentIB()			
			.verifyCalendarPage()
			.selectAnAppointment("PMElec")
			.reviewDetailsPage()
			.navigateToConfirmationASV()
			.navigateTrackCancelChangeBook()
			.verifyAccountOverview("Pend")
			.accountSummarycancelAppointment()			
			.logout();						
		}
		
		
//------------------------------------------------------------------------------------------------------------------------
		
		/* EmailConfirmation-Audit_TC_01
		 * The user should be an OAM user.
         * The user should have a BGS account.
         * 
         * 		 
		 */
		 
		public void asvEmailConfirmationCOD()
		{
			Report.createTestLogHeader("ASV - Email Confirmation - COD ", "HomeSerivcesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeSerivcesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.navigateToViewAllAppointmentsIB()
			.selectAnyAppointmentASV()			
			.navigateToReviewIB(1)
			.addCODASVIB(userProfile)
			.navigateTrackCancelChangeIB()	
			.verifyEmailConfirmation(userProfile,"BOOK_APPT")
			.accountSummarycancelAppointment()			
			.logout();						
		}
		
		/* EmailConfirmation-Audit_TC_10
		 * The user should be an OAM user.
         * The user should have a BGS account.
         * The Paymare tmust be down
         * 		 
		 */
		 
		public void asvEmailConfirmationCODUnsuccessful()
		{
			Report.createTestLogHeader("ASV - Email Confirmation - COD Unsuccessful", "HomeSerivcesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeSerivcesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.navigateToViewAllAppointmentsIB()
			.selectAnyAppointmentASV()			
			.navigateToReviewIB(1)
			.addCODASVIB(userProfile)
			.navigateTrackCancelChangeIB()	
			.verifyEmailConfirmation(userProfile,"PAYMENT UNSUCCESSFUL")						
			.logout();						
		}
		
		/* EmailConfirmation-Audit_TC_09
		 * The user should be an OAM user.
         * The user should have a BGS account.
         * Flexi Customer
         * 		 
		 */
		 
		public void asvEmailConfirmationFlexi()
		{
			Report.createTestLogHeader("ASV - Email Confirmation - Flexi Customer", "HomeSerivcesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeSerivcesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.navigateToViewAllAppointmentsIB()
			.selectAnyAppointmentASV()			
			.navigateToReviewIB(1)
			.navigateToConfirmationASV()			
			.navigateTrackCancelChangeIB()	
			.verifyEmailConfirmation(userProfile,"BOOK_APPT")
			.accountSummarycancelAppointment()			
			.logout();						
		}
		
		/* EmailConfirmation-Audit_TC_11
		 * The user should be an OAM user.
         * The user should have a BGS account.
         * ASV should be booked
         * COD must be pending 
		 */
		 
		public void asvEmailConfirmationCODPending()
		{
			Report.createTestLogHeader("ASV - Email Confirmation - COD Pending", "HomeSerivcesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeSerivcesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageIB()		
			.verifyEmailConfirmation(userProfile,"PAYMENT_PENDING")
			.accountSummarycancelAppointment()			
			.logout();						
		}
		
//------------------------------------------------------------------------------------------------------------------------
		
		 /* END TO END 
		 *  ASV Journey with COD,GAC added
		 * 
		 * 
		 */
		@Test(groups = { ASVIB ,Regression}) 
		public void asvBookingCompleteEndToEnd()
		{
			Report.createTestLogHeader("Booking Complete - ASV Journey Test - GAC Added", "HomeSerivcesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeSerivcesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)
			.navigateToAccountSummaryPageASV()
			.verifyAccountOverview("Ideal")
			.clickBookThisAppointment(userProfile,"ASV")
			.GACReviewDetails()
			.addGAC()
			.addCOD(userProfile)
			.navigateTrackCancelChangeIB()
			.runVBSASV(userProfile, "ASV")
			.accountSummarycancelAppointment()
			.logout();
		}
		
			
//------------------------------------------------------------------------------------------------------------------------
						

						/* CombiningASV-Breakdown_TC_04
						 * IB Journey combined with ASV - different slot
						 * ASV should be already booked and should be in - Na1 status
						 *  
						 */
						@Test(groups = { ASVIB , Regression })
						public void ibCombiningWithASVDifferentAppointmentNastatus()
						{
							Report.createTestLogHeader("Combining ASV and IB - Different Appointment - Na 1 & Na 2 status - Hc 300", "HomeSerivcesAccount");
							UserProfile userProfile = new TestDataHelper()
									.getUserProfile("HomeCare300Account");
							
							new HomePageAction()					
							.navigateToLogin()
							.loginUserDetails(userProfile)		
							.navigateToAccountSummaryPageASV()
							.verifyAccountOverview("NA1") 
							.bookAnEngineer(userProfile, "IV")		
							.navigateToIdentifyFault(1)	
							.navigatePriorityPageASV(1)
							.navigateToReview(1)
							.changeAppointmentIB(2)
							.selectAnAppointment("PMElec")
							.reviewDetailsPage()
							.navigateToConfirmationASV()
							.navigateTrackCancelChangeBook()
							.verifyAccountOverview("NA2")
							.accountSummarycancelAppointment()
							.logout();
						
						}
						
						/* CombiningASV-Breakdown_TC_09
						 * IB Journey combined with ASV - different slot
						 * IB should be already booked and should be in - SITE status
						 *  
						 */
						@Test(groups = { ASVIB , Regression })
						public void ibCombiningWithASVDifferentAppointmentSITEstatus()
						{
							Report.createTestLogHeader("Combining ASV and IB - Different Appointment - SITE status - Hc 300", "HomeSerivcesAccount");
							UserProfile userProfile = new TestDataHelper()
									.getUserProfile("HomeCare300Account");
							
							new HomePageAction()					
							.navigateToLogin()
							.loginUserDetails(userProfile)		
							.navigateToAccountSummaryPageASV()
							.verifyAccountOverviewASV("Site") 
							.navigateToViewAllAppointmentsBook()							
							.changeAppointmentIB(2)
							.selectAnAppointment("10to12")
							.reviewDetailsPage()
							.navigateToConfirmationASV()
							.navigateTrackCancelChangeBook()
							.verifyAccountOverview("Site")
							.accountSummarycancelAppointment()
							.logout();
						
						}
						
						/* CombiningASV-Breakdown_TC_21
						 * IB Journey combined with ASV - Same slot				
						 *  
						 */
						@Test(groups = { ASVIB , Regression })
						public void ibCombiningWithASVKeepAppointmentAllDay()
						{
							Report.createTestLogHeader("Combining ASV and IB - Same Appointment - AllDay ", "HomeSerivcesAccount");
							UserProfile userProfile = new TestDataHelper()
									.getUserProfile("HomeServciesAccount");
							
							new HomePageAction()
							.navigateToLogin()
							.loginUserDetails(userProfile)	
							.navigateToAccountSummaryPageASV()
							.verifyAccountOverview("ideal").verifyAddressASV(userProfile).verifySlotASVIB("AllDay")
							.bookAnEngineer(userProfile, "IV")	
							.navigateToIdentifyFault()
							.navigateToReviewIB(1).verifyAddress(userProfile).verifySlot("AllDay")						
							.selectAnAppointment("AllDay").verifyAddress(userProfile).verifySlot("AllDay")
					        .reviewDetailsPage().navigateToConfirmation().verifyAddress(userProfile).verifySlotASVIB("AllDay")		               
							.navigateTrackCancelChange()
							.navigateToViewAllAppointmentsBook()
							.changeAppointmentIB(1).verifyAddress(userProfile).verifySlot("AllDay")
							.reviewDetailsPage().verifyAddress(userProfile).verifySlot("AllDay")
							.navigateToConfirmationASV()
							.navigateTrackCancelChange()																			
							.accountSummarycancelAppointment()
							.logout();
						
						}
						
						/* CombiningASV-Breakdown_TC_16
						 * IB Journey combined with ASV - Same slot				
						 *  
						 */
						@Test(groups = { ASVIB , Regression })
						public void ibCombiningWithASVKeepAppointment10t012()
						{
							Report.createTestLogHeader("Combining ASV and IB - Same Appointment - 10am to 12pm ", "HomeSerivcesAccount");
							UserProfile userProfile = new TestDataHelper()
									.getUserProfile("HomeSerivcesAccount");
							
							new HomePageAction()
							.navigateToLogin()
							.loginUserDetails(userProfile)		
							.navigateToAccountSummaryPageASV()
							.verifyAccountOverview("ideal")
							.bookAnEngineer(userProfile, "IV")		
							.navigateToIdentifyFault()
							.navigateToReviewIB(1)							
							.selectAnAppointment("10to12")
					        .reviewDetailsPageASVIB()			               
							.navigateTrackCancelChange()
							.navigateToViewAllAppointmentsBook()
							.changeAppointmentIB(1)
							.reviewDetailsPage()
							.navigateToConfirmationASV()
							.navigateTrackCancelChange()																			
							.accountSummarycancelAppointment()
							.logout();
						
						}
						
						/* CombiningASV-Breakdown_TC_24
						 * IB Journey combined with ASV - different slot				
						 *  
						 */
						@Test(groups = { ASVIB , Regression })
						public void ibCombiningWithASVDifferentAppointmentAM()
						{
							Report.createTestLogHeader("Combining ASV and IB same appointment - AM slot", "HomeSerivcesAccount");
							UserProfile userProfile = new TestDataHelper()
									.getUserProfile("HomeSerivcesAccount");
							
							new HomePageAction()
							.navigateToLogin()
							.loginUserDetails(userProfile)		
							.navigateToAccountSummaryPageASV()
							.verifyAccountOverview("ideal")
							.navigateToViewAllAppointmentsIB()
							.selectAnAppointment("AM")
							.navigateToConfirmationASV()
							.navigateTrackCancelChange()
							.logoutReturn()
							.navigateToLogin()
							.loginUserDetails(userProfile)		
							.navigateToAccountSummaryPageASV()					
							.bookAnEngineer(userProfile, "IV")		
							.navigateToIdentifyFault()
							.navigateToReview(1)
							.changeAppointmentIB(2)
							.selectAnAppointment("AM")
					        .reviewDetailsPageASVIB()			               
							.navigateTrackCancelChange()
							.accountSummarycancelAppointment()
							.logout();
						
						}
						
						/* CombiningASV-Breakdown_TC_25
						 * IB Journey combined with ASV - different slot				
						 *  
						 */
						@Test(groups = { ASVIB , Regression })
						public void ibCombiningWithASVDifferentAppointment2Hr()
						{
							Report.createTestLogHeader("Combining ASV and IB - 2Hr slot - 10am to 12pm", "HomeSerivcesAccount");
							UserProfile userProfile = new TestDataHelper()
									.getUserProfile("HomeSerivcesAccount");
							
							new HomePageAction()
							.navigateToLogin()
							.loginUserDetails(userProfile)		
							.navigateToAccountSummaryPageASV()
							.verifyAccountOverview("ideal")
							.navigateToViewAllAppointmentsIB()
							.selectAnAppointment("10to12")
							.navigateToConfirmationASV()
							.navigateTrackCancelChange()
							.logoutReturn()
							.navigateToLogin()
							.loginUserDetails(userProfile)		
							.navigateToAccountSummaryPageASV()					
							.bookAnEngineer(userProfile, "IV")		
							.navigateToIdentifyFault()
							.navigateToReview(1)
							.changeAppointmentIB(2)
							.selectAnAppointment("10to12")
					        .reviewDetailsPageASVIB()			               
							.navigateTrackCancelChange()
							.accountSummarycancelAppointment()
							.logout();
						
						}
						
						/* CombiningASV-Breakdown_TC_26
						 * IB Journey combined with ASV - keep same slot				
						 *  
						 */
						@Test(groups = { ASVIB , Regression })
						public void ibCombiningWithASVKeepAppointmentPM()
						{
							Report.createTestLogHeader("Combining ASV and IB - preference slot - PM slot", "HomeSerivcesAccount");
							UserProfile userProfile = new TestDataHelper()
									.getUserProfile("HomeSerivcesAccount");
							
							new HomePageAction()
							.navigateToLogin()
							.loginUserDetails(userProfile)		
							.navigateToAccountSummaryPageASV()
							.verifyAccountOverview("ideal")
							.navigateToViewAllAppointmentsIB()
							.selectAnAppointment("PM")
							.navigateToConfirmationASV()
							.navigateTrackCancelChange()
							.logoutReturn()
							.navigateToLogin()
							.loginUserDetails(userProfile)		
							.navigateToAccountSummaryPageASV()					
							.bookAnEngineer(userProfile, "IV")		
							.navigateToIdentifyFault()
							.navigateToReview(1)
							.changeAppointmentIB(1)							
					        .reviewDetailsPageASVIB()			               
							.navigateTrackCancelChange()
							.accountSummarycancelAppointment()
							.logout();
						
						}
						
						
//		-------------------------------------------------------------------------------------------------------------------			
}
