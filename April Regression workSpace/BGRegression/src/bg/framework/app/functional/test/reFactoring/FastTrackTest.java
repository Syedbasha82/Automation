package bg.framework.app.functional.test.reFactoring;

import static bg.framework.app.functional.entities.FunctionalCategory.*;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.reFactoring.FastTrackAction;
import bg.framework.app.functional.action.reFactoring.ASVAction;
import bg.framework.app.functional.action.selfServe.ASVIBAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.IBPage;

import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class FastTrackTest extends TestBase{
	
	/* Fast Track_TC_02
	 * Fast Track Journey with added COD & GAC
	 * FF Slot
	 * 
	 */
	@Test(groups = { ASVIB,Regression })
	public void fastTrackASVBookingwithFFSlot() {
		Report.createTestLogHeader("Fast Track Customer with FF slots with COD and GAC","HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper().getUserProfile("FastTrackASV");	
		new FastTrackAction()
		.fastTrackASVLogin(userProfile)
		.fastTrackConfirmAddressDetails(userProfile)
		.fastTrackSelectAppointment("FF")
		.fastTrackReviewPageDetailsAC(userProfile)
		.addGAC()
		.addCOD(userProfile)
		.fastTrackConfirmationPage()
		.navigateToLoginPage()
		.loginUserDetails(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.accountSummarycancelAppointment()
		.logout();
	}
	
	/* Fast Track_TC_01,Fast Track_TC_04,Fast Track_TC_10
	 * Fast Track_TC_01
	 * Fast Track Journey with all day slot selection
	 * ALL Day Slot
	 * 
	 */
	@Test(groups = { ASVIB,Regression })
	public void fastTrackASVBookingwithAllDaySlot() {
		Report.createTestLogHeader("Fast Track Customer with All Day ","HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper().getUserProfile("FastTrackASV");	
		new FastTrackAction()
		.fastTrackASVLogin(userProfile).verifyAddress(userProfile)
		.fastTrackConfirmAddressDetails(userProfile).verifyAddress(userProfile)
		.fastTrackSelectAppointment("ALLDAY").verifyAddress(userProfile)
		.fastTrackReviewPageDetailsAC(userProfile).verifyAddress(userProfile)		
		.fastTrackNavigateToConfirmation().verifyAddress(userProfile)
		.fastTrackConfirmationPage()
		/*.loginUserDetails(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.accountSummarycancelAppointment()
		.logout()*/;
	}
	
	/* Fast Track_TC_05
	 * Fast Track Journey with already in NA2 Status
	 * 
	 * 
	 */
	@Test(groups = { ASVIB,Regression })
	public void fastTrackASVBookingwithNA2Status() {
		Report.createTestLogHeader("Fast Track Na2 Status ","HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper().getUserProfile("FastTrackASV");	
		new FastTrackAction()
		.fastTrackASVLogin(userProfile)
		.fastTrackConfirmAddressDetails(userProfile)	
		.verifyNA2Message();
	}
	
	/* Fast Track_TC_06
	 * Fast Track Journey with already in NAW Status
	 * Book already booked fasttrack asv in NAW status
	 * 
	 */
	@Test(groups = { ASVIB,Regression })
	public void fastTrackASVBookedwithNAWStatus() {
		Report.createTestLogHeader("Already Booked Fast Track with NaW Status ","HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper().getUserProfile("FastTrackASV");	
		new FastTrackAction()
		.fastTrackASVLogin(userProfile)
		.fastTrackConfirmAddressDetails(userProfile)	
		.verifyNA2Message();
	}

	/* Fast Track_TC_08
	 * Fast Track Journey 
	 * BS1 customer
	 * 
	 */
	@Test(groups = { ASVIB,Regression })
	public void fastTrackASVCancel() {
		Report.createTestLogHeader("Cancel Fast Track asv ","FastTrackASV");
		UserProfile userProfile = new TestDataHelper().getUserProfile("FastTrackASV");	
		new FastTrackAction()
		.fastTrackASVLogin(userProfile)
		.fastTrackConfirmAddressDetails(userProfile)
		.fastTrackSelectAppointment("ALLDAY")
		.fastTrackReviewPageDetailsAC(userProfile)		
		.fastTrackNavigateToConfirmation()
		.fastTrackConfirmationPage()
		.loginUserDetails(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.accountSummarycancelAppointment()
		.logout();
	}

	/* Fast Track_TC_09
	 * Fast Track Journey 
	 * BS1 customer without online account
	 * 
	 */
	@Test(groups = { ASVIB,Regression })
	public void fastTrackASVwithoutEVE() {
		Report.createTestLogHeader("Fast Track asv without Evening slot","FastTrackASV");
		UserProfile userProfile = new TestDataHelper().getUserProfile("FastTrackASV");	
		new FastTrackAction()
		.fastTrackASVLogin(userProfile)
		.fastTrackConfirmAddressDetails(userProfile)
		.selectNoAppointment("EVE");		
	}

	/* Fast Track_TC_11
	 * Fast Track Journey 
	 * BS1 customer without online account
	 * 
	 */
	@Test(groups = { ASVIB,Regression })
	public void fastTrackASVwithalreadyBooked() {
		Report.createTestLogHeader("Fast Track asv with already booked","FastTrackASV");
		UserProfile userProfile = new TestDataHelper().getUserProfile("FastTrackASV");	
		new FastTrackAction()
		.fastTrackASVLogin(userProfile)
		.fastTrackConfirmAddressDetails(userProfile)
		.verifyBookedSlotPage();		
	}

	/* END TO END 
	 * FASTTRACK Journey with COD,GAC added
	 * 
	 * 
	 */
	@Test(groups = { ASVIB ,Regression}) 
	public void fastTrackBookingCompleteEndToEnd()
	{
		Report.createTestLogHeader("Booking Complete - FastTrack Journey Test - COD,GAC Added", "HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("FastTrackASV");
		
		
		
	new FastTrackAction()
		.fastTrackASVLogin(userProfile)
		.fastTrackConfirmAddressDetails(userProfile)
		.fastTrackSelectAppointment("FF")
		.fastTrackReviewPageDetailsAC(userProfile)
		.addGAC()
		.addCOD(userProfile).verifyAddress(userProfile)
		.fastTrackConfirmationPageAsv();
		
		 String strWorkReq = new IBPage().runVBS(userProfile, "ASV");
		 new FastTrackAction()
		.loginUserDetails(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.verifyWorkReq(strWorkReq)
		.accountSummarycancelAppointment()		
		.logout();
	}
	
/////////////////////////////////////////////////////////////Fast Track One Click Registration/////////////////////////////////////////////////////////////////////////	

	//////Prerequisite:: Entry should be made in Table ASV_TA_Customer_Details/////////////////////	
	
	@Test(groups = { ASVIB,Regression })
    public void fastTrackASVBookingE2EwithOneClickRegistration() 
    {
          Report.createTestLogHeader("Fast Track Customer with FF slots with COD and GAC","HomeSerivcesAccount");
          UserProfile userProfile = new TestDataHelper().getUserProfile("FastTrackASV");
      	  new OnlineDBConnector().deRegister(userProfile.getUCRN());
          new FastTrackAction()
          .navigateToFastTrackPage()
          .fastTrackASVLogin(userProfile)
          .verifyAppointmentSelectionCalender()
          .fastTrackReviewPageDetailsAC(userProfile)
          .addGAC()
		  .addCOD(userProfile)
          .confirmButton()
          .fastTrackConfirmationPage()
          .fastTrackOneClickRegistrationPage(userProfile)
          .verifyAppointmentSectioninAccountOverview(userProfile)
          .navigateToAccountSummaryPageviaAppointmentLink()
          .verifyAppointmentSectioninAccountSummary()
          .accountSummarycancelAppointment()
          .logout();

  }

//////////////////////////////////////////////////////////////////////////Fast track OAM Customer//////////////////////////////////////////////////////////////////
	@Test(groups = { ASVIB,Regression })
    public void fastTrackASVBookingE2EwithGACCODCancel() 
    {
          Report.createTestLogHeader("Fast Track Customer with FF slots with COD and GAC","HomeSerivcesAccount");
          UserProfile userProfile = new TestDataHelper().getUserProfile("FastTrackASV");
          new FastTrackAction()
          .navigateToFastTrackPage()
          .ClickAccountSummary();
          new HomePageAction()
          .navigateToLogin().
          login(userProfile);
          new FastTrackAction()
          //.fastTrackASVLogin(userProfile)
          .ClickCancelbutton()
          .verifyAppointmentSelectionCalender()
          .fastTrackReviewPageDetailsAC(userProfile)
          .addGAC()
		  .addCOD(userProfile)
          .fastTrackConfirmationPage()
          .navigateToLoginPage()
          .loginUserDetails(userProfile)
          .verifyAppointmentSectioninAccountOverview(userProfile)
          .navigateToAccountSummaryPageviaAppointmentLink()
          .verifyAppointmentSectioninAccountSummary()
          .accountSummarycancelAppointment()
          .logout();

  }	
	
	
//////////////////////////////////////////////////Error Message Validation////////////////////////////
	@Test(groups = { ASVIB,Regression })
    public void fastTrackASVBookingToCheckErrorMsgForIvalidDetails() 
    {
          Report.createTestLogHeader("Fast Track ASVBooking To Check Error Msg For Ivalid Details","HomeSerivcesAccount");
          UserProfile userProfile = new TestDataHelper().getUserProfile("FastTrackASV");
          new FastTrackAction()
          .navigateToFastTrackPage()
          .fastTrackASVLogin(userProfile)
          .checkErrorMsgForInvalidDetails();

  }
	@Test(groups = { ASVIB,Regression })
    public void fastTrackASVBookingToCheckErrorMsgForSlotUnavailability() 
    {
          Report.createTestLogHeader("Fast Track ASVBooking To Check Error Msg For Slot Unavailability","HomeSerivcesAccount");
          UserProfile userProfile = new TestDataHelper().getUserProfile("FastTrackASV");
          new FastTrackAction()
          .navigateToFastTrackPage()
          .fastTrackASVLogin(userProfile)
          .checkErrorMsgForInvalidDetails();

  }
	@Test(groups = { ASVIB,Regression })
    public void fastTrackASVBookingE2EwithOneClickReg() 
    {
          Report.createTestLogHeader("Fast Track Customer with FF slots with COD and GAC","HomeSerivcesAccount");
          UserProfile userProfile = new TestDataHelper().getUserProfile("FastTrackASV");
          new FastTrackAction()
          .navigateToFastTrackPage()
          .fastTrackASVLogin(userProfile)
          .verifyAppointmentSelectionCalender()
          .fastTrackReviewPageDetailsAC(userProfile)
          .addGAC()
		  .addCOD(userProfile)
          .fastTrackConfirmationPage()
          .navigateToLoginPage()
          .loginUserDetails(userProfile)
          .verifyAppointmentSectioninAccountOverview(userProfile)
          .navigateToAccountSummaryPageviaAppointmentLink()
          .verifyAppointmentSectioninAccountSummary();
}
	@Test(groups = { ASVIB,Regression })
    public void fastTrackASVBookingReschedule() 
    {
          Report.createTestLogHeader("Fast Track Customer with FF slots with COD and GAC","HomeSerivcesAccount");
          UserProfile userProfile = new TestDataHelper().getUserProfile("FastTrackASV");
          new HomePageAction()
          .navigateToLoginPage()
          .loginUserDetails(userProfile);
          new FastTrackAction()
          .verifyAppointmentSectioninAccountOverview(userProfile)
          .navigateToAccountSummaryPageviaAppointmentLink()
          .verifyAppointmentSectioninAccountSummary();
          new ASVAction()
          .changeBooking();
          new FastTrackAction()
          .verifyAppointmentSelectionCalender()
          .fastTrackReviewPageDetailsAC(userProfile)
          .fastTrackNavigateToConfirmation()
          .fastTrackConfirmationPage();
          new ASVAction()
          .navigateToAccountSumaryPageFromConfirmationPage();
          new FastTrackAction()
          .verifyAppointmentSectioninAccountSummary()
          .accountSummarycancelAppointment()
          .logout();
  }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//Create an booking Appoitment for a post code and again try to book another appoitment and verify the error message is populating   

	@Test(groups = { ASVIB,Regression })
    public void fastTrackASVBookingRegistration() 
    {
          Report.createTestLogHeader("Fast Track Customer with FF slots with COD and GAC","HomeSerivcesAccount");
          UserProfile userProfile = new TestDataHelper().getUserProfile("FastTrackASV");
      	  new OnlineDBConnector().deRegister(userProfile.getUCRN());
          new FastTrackAction()
          .navigateToFastTrackPage()
          .fastTrackASVLogin(userProfile)
          .verifyAppointmentSelectionCalender()
          .fastTrackReviewPageDetailsAC(userProfile)
          .addGAC()
		  .addCOD(userProfile)
          .confirmButton()
          .fastTrackConfirmationPage()
          .fastTrackOneClickRegistrationPage(userProfile)
          .navigateToFastTrackPage()
          .fastTrackASVLogin(userProfile)
          .AgainChooseApoitmnet() 
          .logout();

  }	
	
	
	
	
	
}
