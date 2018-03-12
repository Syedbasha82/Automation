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
		Report.createTestLogHeader("Booking Complete - ASV Journey Test - GAC Added", "HomeServciesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");
		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAccountOverview("Ideal")
		.clickBookThisAppointment(userProfile,"ASV").verifyAddressIB(userProfile)
		.reviewDetailsPage(userProfile).addGAC().navigateToConfirmationASV()
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
		Report.createTestLogHeader("Booking Complete - ASV Journey Test - View Slots - Book First", "HomeServciesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");
		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAccountOverview("Ideal")
		.navigateToViewAllAppointmentsIB()
		.selectFirstAvailableSlot()
		.reviewDetailsPage(userProfile)
		.navigateToConfirmationASV()
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
		Report.createTestLogHeader("Booking Complete -ASV combined with IB Journey Test - Book First - Added GAC & COD", "HomeServciesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");
		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAccountOverview("Ideal")
		.bookAnEngineerIB(userProfile, "IV")		
		.navigateToIdentifyFault(0,userProfile).navigatePriorityPage(0)		
		.selectFirstAvailableSlot().reviewDetailsPage(userProfile)
		.navigateToConfirmationASV()
		.navigateTrackCancelChange()
		.bookAnEngineerIB(userProfile, "ASV")					
		.navigateToIdentifyFault(0,userProfile).navigatePriorityPage(0).changeAppointment(1)
		.reviewDetailsPage(userProfile).navigateToConfirmationASV()
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
		Report.createTestLogHeader("ASV PI Call Error Message in confirmation page", "HomeServciesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");
		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)		
		.navigateToAccountSummaryPageASV()
		.navigateToViewAllAppointmentsIB()
		.selectAnyAppointment()
		.reviewDetailsPage(userProfile)
		.navigateToConfirmationASV()
		.verifyPiCallErrorMessageConf()
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
		Report.createTestLogHeader("Combine Link -ASV combined with IB Journey Test - Book First - Added GAC & COD", "HomeServciesAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("HomeServciesAccount");		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.bookAnEngineerIB(userProfile, "IV")
		.navigateToIdentifyFault(0,userProfile).navigatePriorityPage(0)		
		.selectAnyAppointment().reviewDetailsPage(userProfile)
		.navigateToConfirmationASV()
		.navigateTrackCancelChange()		
		.bookAnEngineerIB(userProfile, "IV")
		.navigateToIdentifyFault(0,userProfile).navigatePriorityPage(0)	
		.changeAppointment(1).reviewDetailsPage(userProfile)
		.navigateToConfirmationASV().navigateTrackCancelChange()				
		.bookAnEngineerIB(userProfile, "ASV")
		.changeAppointment(1)
		.reviewDetailsPage(userProfile)			
		.navigateToConfirmationASV()
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
		Report.createTestLogHeader("Contact Details -ASV - Book First - Check Mobile Number", "HomeServciesAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("HomeServciesAccount");		
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
		Report.createTestLogHeader("Contact Details -ASV - Book First - Modify Home Number", "HomeServciesAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("HomeServciesAccount");		
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
		Report.createTestLogHeader("Contact Details -ASV RESCHEDULING - Book First - Modify Home Number", "HomeServciesAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("HomeServciesAccount");		
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
		Report.createTestLogHeader("Completed -ASV Journey Test-", "HomeServciesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");
		
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
		Report.createTestLogHeader("Booking Controls - ASV Journey Test ", "HomeServciesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");
		
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
		Report.createTestLogHeader("Status Bar Controls - ASV Journey Test ", "HomeServciesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");
		
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
			Report.createTestLogHeader("ASV due and no time slots", "HomeServciesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeServciesAccount");
			
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
			Report.createTestLogHeader("ASV PI Call Error Message", "HomeServciesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeServciesAccount");
			
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
			Report.createTestLogHeader("ASV PI Call - Getappointment slot -  Error Message", "HomeServciesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeServciesAccount");
			
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
			Report.createTestLogHeader("ASV - Verify Links and Navigation -  Error Message", "HomeServciesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeServciesAccount");
			
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
			Report.createTestLogHeader("ASV - Verify Links and Navigation -  Error Message", "HomeServciesAccount");
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
			Report.createTestLogHeader("Completed -ASV Journey Test-COMP", "HomeServciesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeServciesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.navigateToViewAllAppointmentsIB()
			.selectAnAppointment("PM2to4")
			.reviewDetailsPage(userProfile)
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
			Report.createTestLogHeader("Completed -ASV Journey Test-HOLD", "HomeServciesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeServciesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.navigateToViewAllAppointmentsIB()
			.selectAnAppointment("8to10")
			.reviewDetailsPage(userProfile)
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
			Report.createTestLogHeader("Completed -ASV Journey Test-SITE", "HomeServciesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeServciesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.navigateToViewAllAppointmentsIB()
			.selectAnAppointment("10to12")
			.reviewDetailsPage(userProfile)
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
			Report.createTestLogHeader("Completed -ASV Journey Test-GAC", "HomeServciesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeServciesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.navigateToViewAllAppointmentsIB()
			.selectAnAppointment("AM")
			.reviewDetailsPage(userProfile)
			.addGAC()			
			.navigateToConfirmationASV()
			.navigateTrackCancelChangeBook()
			//.verifyAccountOverviewASV("Site")	
			.accountSummarycancelAppointment()
			.logout();
		}
		
		/* BookAnASV_TC_28
		 * ASV in HOLD status
		 * 
		 */
		@Test(groups = { ASVIB })
		public void bookCompleteASVFFCod()
		{
			Report.createTestLogHeader("Completed -ASV Journey Test-COD-FF", "HomeServciesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeServciesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.navigateToViewAllAppointmentsIB()
			.selectAnAppointment("FF")
			.reviewDetailsPage(userProfile)			
			.addCODASVIB(userProfile)			
			.navigateTrackCancelChangeBook()
			.accountSummarycancelAppointment()
			.logout();
		}
		
		
//------------------------------------------------------------------------------------------------------------------------
		
		/* CancelASV_TC_01
		 * The user should be an OAM user.
         * The user should have a BGS account.
         * 			 
		 */
		@Test(groups = { ASVIB })
		public void asvBookingCancel()
		{
			Report.createTestLogHeader("ASV Cancel appointment from account summary page", "HomeServciesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeServciesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)
			.navigateToAccountSummaryPageASV()
			.verifyAccountOverview("Ideal")
			.navigateToViewAllAppointmentsIB()
			.selectAnyAppointment()
			.reviewDetailsPage(userProfile)
			.navigateToConfirmationASV()							
			.navigateTrackCancelChange()
			.accountSummarycancelAppointment()
			.logout();
				
		}
		
		
		/* CancelASV_TC_02
		 * The user should be an OAM user.
         * The user should have a BGS account.
         * 			 
		 */
		@Test(groups = { ASVIB })
		public void asvBookingCancelFromView()
		{
			Report.createTestLogHeader("ASV Cancel appointment from view details page", "HomeServciesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeServciesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)
			.navigateToAccountSummaryPageASV()
			.verifyAccountOverview("Ideal")
			.navigateToViewAllAppointmentsIB()
			.selectAnyAppointment()
			.reviewDetailsPage(userProfile)
			.navigateToConfirmationASV()							
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
		@Test(groups = { ASVIB })
		public void CombiningBreakdownFromView()
		{
			Report.createTestLogHeader("CombiningBreakdown appointment from view details page", "HomeServciesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeServciesAccount");
			
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
		@Test(groups = { ASVIB })
		public void asvRescheduleVerifyNavigation()
		{
			Report.createTestLogHeader("ASV - Reschedule - Verify Navigation Page - HC200", "HomeServciesAccount");
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
		@Test(groups = { ASVIB })
		public void asvBookingChangeFromReview()
		{
			Report.createTestLogHeader("ASV - Verify Changing appliance from review Page ", "HomeServciesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeCare200Account");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.navigateToViewAllAppointmentsIB()
			.selectAnyAppointment()			
			.reviewDetailsPage(userProfile)			
			.navigateToConfirmationASV()
			.navigateTrackCancelChangeASV()
			.accountSummaryChangeAppointmentIB()			
			.verifyCalendarPage()
			.selectAnyAppointment()
			.reviewDetailsPage(userProfile)
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
		@Test(groups = { ASVIB })
		public void asvBookingChangeFromReviewCompleteJourney()
		{
			Report.createTestLogHeader("ASV - Verify Changing appliance from review Page-Complete Journey ", "HomeServciesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeServciesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.navigateToViewAllAppointmentsIB()
			.selectAnyAppointment()			
			.reviewDetailsPage(userProfile)			
			.navigateToConfirmationASV()
			.navigateTrackCancelChangeASV()
			.accountSummaryChangeAppointmentIB()			
			.verifyCalendarPage()
			.selectAnyAppointment()
			.reviewDetailsPage(userProfile)
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
		@Test(groups = { ASVIB })
		public void asvBookingChangeCOMP8to10slot()
		{
			Report.createTestLogHeader("ASV - Verify Comp Status - 8am to 10am slot ", "HomeServciesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeServciesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.navigateToViewAllAppointmentsIB()
			.selectAnyAppointment()			
			.reviewDetailsPage(userProfile)			
			.navigateToConfirmationASV()
			.navigateTrackCancelChangeASV()
			.accountSummaryChangeAppointmentIB()			
			.verifyCalendarPage()
			.selectAnAppointment("8to10")
			.reviewDetailsPage(userProfile)
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
		@Test(groups = { ASVIB })
		public void asvBookingChangePend10to12slot()
		{
			Report.createTestLogHeader("ASV - Verify Comp Status - 10am to 12pm slot ", "HomeServciesAccount");
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
			.reviewDetailsPage(userProfile)
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
		@Test(groups = { ASVIB })
		public void asvBookingChangePend4to6slot()
		{
			Report.createTestLogHeader("ASV - Verify Comp Status - 4pm to 6pm slot ", "HomeServciesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeCare300Account");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.navigateToViewAllAppointmentsIB()
			.selectAnyAppointment()			
			.reviewDetailsPage(userProfile)			
			.navigateToConfirmationASV()
			.navigateTrackCancelChangeASV()
			.accountSummaryChangeAppointmentIB()			
			.verifyCalendarPage()
			.selectAnAppointment("PMElec")
			.reviewDetailsPage(userProfile)
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
		@Test(groups = { ASVIB })
		public void asvEmailConfirmationCOD()
		{
			Report.createTestLogHeader("ASV - Email Confirmation - COD ", "HomeServciesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeServciesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.navigateToViewAllAppointmentsIB()
			.selectAnyAppointment()			
			.reviewDetailsPage(userProfile)
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
		@Test(groups = { ASVIB })
		public void asvEmailConfirmationCODUnsuccessful()
		{
			Report.createTestLogHeader("ASV - Email Confirmation - COD Unsuccessful", "HomeServciesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeServciesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.navigateToViewAllAppointmentsIB()
			.selectAnyAppointment()			
			.reviewDetailsPage(userProfile)
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
		@Test(groups = { ASVIB })
		public void asvEmailConfirmationFlexi()
		{
			Report.createTestLogHeader("ASV - Email Confirmation - Flexi Customer", "HomeServciesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeCareFlexiAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)		
			.navigateToAccountSummaryPageASV()
			.navigateToViewAllAppointmentsIB()
			.selectAnyAppointment()			
			.reviewDetailsPage(userProfile)
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
		@Test(groups = { ASVIB })
		public void asvEmailConfirmationCODPending()
		{
			Report.createTestLogHeader("ASV - Email Confirmation - COD Pending", "HomeServciesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeServciesAccount");
			
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
			Report.createTestLogHeader("Booking Complete - ASV Journey Test - GAC Added", "HomeServciesAccount");
			UserProfile userProfile = new TestDataHelper()
					.getUserProfile("HomeServciesAccount");
			
			new HomePageAction()
			.navigateToLogin()
			.loginUserDetails(userProfile)
			.navigateToAccountSummaryPageASV()
			.verifyAccountOverview("Ideal")
			.clickBookThisAppointment(userProfile,"ASV")
			.verifyAddressIB(userProfile)
			.reviewDetailsPage(userProfile)
			.addGAC()
			.addCOD(userProfile).verifyAddressASVIB(userProfile)
			.navigateTrackCancelChange()
			//.runVBSASV(userProfile, "ASV")
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
							Report.createTestLogHeader("Combining ASV and IB - Different Appointment - Na 1 & Na 2 status - Hc 300", "HomeServciesAccount");
							UserProfile userProfile = new TestDataHelper()
									.getUserProfile("HomeCare300Account");
							
							new HomePageAction()					
							.navigateToLogin()
							.loginUserDetails(userProfile)		
							.navigateToAccountSummaryPageASV()
							.verifyAccountOverview("NA1") 
							.bookAnEngineer(userProfile, "IV").verifyAddressIB(userProfile)		
							.navigateToIdentifyFault(1,userProfile)	
							.navigatePriorityPageBook(1)							
							.changeAppointmentIB(2).verifyAddress(userProfile).verifySlot("PMElec")
							.selectAnAppointment("PMElec").verifyAddress(userProfile).verifySlot("PMElec")
							.reviewDetailsPage(userProfile)
							.navigateToConfirmationASV().verifyAddressIB(userProfile).verifySlotASVIB("PMElec")
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
							Report.createTestLogHeader("Combining ASV and IB - Different Appointment - SITE status - Hc 300", "HomeServciesAccount");
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
							.reviewDetailsPage(userProfile)
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
							Report.createTestLogHeader("Combining ASV and IB - Same Appointment - AllDay ", "HomeServciesAccount");
							UserProfile userProfile = new TestDataHelper()
									.getUserProfile("HomeServciesAccount");
							
							new HomePageAction()
							.navigateToLogin()
							.loginUserDetails(userProfile)	
							.navigateToAccountSummaryPageASV()
							.verifyAccountOverview("ideal").verifyAddressASV(userProfile).verifySlotASVIB("AllDay")
							.bookAnEngineerIB(userProfile, "IV")	
							.navigateToIdentifyFault(0,userProfile).navigatePriorityPage(0)
							.verifyAddress(userProfile).verifySlot("AllDay")						
							.selectAnAppointment("AllDay").verifyAddress(userProfile).verifySlot("AllDay")
					        .reviewDetailsPage(userProfile).navigateToConfirmation().verifyAddress(userProfile).verifySlotASVIB("AllDay")		               
							.navigateTrackCancelChange()
							.bookAnEngineerBook(userProfile, "ASV")
							.changeAppointmentIB(1).verifyAddress(userProfile).verifySlot("AllDay")
							.reviewDetailsPage(userProfile).verifyAddress(userProfile).verifySlot("AllDay")
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
							Report.createTestLogHeader("Combining ASV and IB - Same Appointment - 10am to 12pm ", "HomeServciesAccount");
							UserProfile userProfile = new TestDataHelper()
									.getUserProfile("HomeServciesAccount");
							
							new HomePageAction()
							.navigateToLogin()
							.loginUserDetails(userProfile)		
							.navigateToAccountSummaryPageASV()
							.verifyAccountOverview("ideal")
							.bookAnEngineerIB(userProfile, "IV")		
							.navigateToIdentifyFault(0,userProfile).navigatePriorityPage(0)
							
							.selectAnAppointment("10to12")
					        .reviewDetailsPageASVIB(userProfile).navigateToConfirmation()			               
							.navigateTrackCancelChange()
							.navigateToViewAllAppointmentsBook()
							.changeAppointmentIB(1)
							.reviewDetailsPage(userProfile)
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
							Report.createTestLogHeader("Combining ASV and IB same appointment - AM slot", "HomeServciesAccount");
							UserProfile userProfile = new TestDataHelper()
									.getUserProfile("HomeServciesAccount");
							
							new HomePageAction()
							.navigateToLogin()
							.loginUserDetails(userProfile)		
							.navigateToAccountSummaryPageASV()
							.verifyAccountOverview("ideal")
							.navigateToViewAllAppointmentsIB()
							.selectAnAppointment("AM").reviewDetailsPage(userProfile)
							.navigateToConfirmationASV()
							.navigateTrackCancelChange()
												
							.bookAnEngineerIB(userProfile, "IV")		
							.navigateToIdentifyFault(0,userProfile).navigatePriorityPageBook(0)
							
							.changeAppointmentIB(2)
							.selectAnAppointment("AM")
					        .reviewDetailsPageASVIB(userProfile)	.navigateToConfirmation()		               
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
							Report.createTestLogHeader("Combining ASV and IB - 2Hr slot - 10am to 12pm", "HomeServciesAccount");
							UserProfile userProfile = new TestDataHelper()
									.getUserProfile("HomeServciesAccount");
							
							new HomePageAction()
							.navigateToLogin()
							.loginUserDetails(userProfile)		
							.navigateToAccountSummaryPageASV()
							.verifyAccountOverview("ideal").verifyAddressASV(userProfile)
							.navigateToViewAllAppointmentsIB().verifySlot("10to12").verifyAddress(userProfile)
							.selectAnAppointment("10to12").verifySlot("10to12").verifyAddress(userProfile).reviewDetailsPage(userProfile)
							.navigateToConfirmationASV()
							.verifySlot("10to12").verifyAddressASVIB(userProfile)							
							.navigateTrackCancelChange()
												.verifySlot("10to12").verifyAddressASVIB(userProfile)
							.bookAnEngineerIB(userProfile, "IV")		
							.navigateToIdentifyFault(0,userProfile).navigatePriorityPageBook(0)					
							.changeAppointmentIB(2)
							.selectAnAppointment("10to12").verifySlot("10to12").verifyAddress(userProfile)
					        .reviewDetailsPageASVIB(userProfile).navigateToConfirmation().verifySlot("10to12").verifyAddressASVIB(userProfile)			               
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
							Report.createTestLogHeader("Combining ASV and IB - preference slot - PM slot", "HomeServciesAccount");
							UserProfile userProfile = new TestDataHelper()
									.getUserProfile("HomeServciesAccount");
							
							new HomePageAction()
							.navigateToLogin()
							.loginUserDetails(userProfile)		
							.navigateToAccountSummaryPageASV()
							.verifyAccountOverview("ideal")
							.navigateToViewAllAppointmentsIB().verifyAddress(userProfile).verifySlot("PM")
							.selectAnAppointment("PM").reviewDetailsPage(userProfile)
							.navigateToConfirmationASV().verifyAddress(userProfile).verifySlotBook("PM")
							.navigateTrackCancelChange()
												.verifyAddressIB(userProfile).verifySlotASVIB("PM")
							.bookAnEngineerIB(userProfile, "IV").verifyAddress(userProfile)		
							.navigateToIdentifyFault(0,userProfile).navigatePriorityPageBook(0)
							.changeAppointmentIB(1)		
							.verifyAddress(userProfile)	
					        .reviewDetailsPageASVIB(userProfile)
					        .navigateToConfirmation()
					        .verifyAddressBook(userProfile)	
							.navigateTrackCancelChange()
							.accountSummarycancelAppointment()
							.logout();
						
						}
						
						
//		-------------------------------------------------------------------------------------------------------------------			
}
