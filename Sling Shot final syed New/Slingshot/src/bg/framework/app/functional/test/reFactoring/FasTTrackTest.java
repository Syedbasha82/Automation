package bg.framework.app.functional.test.reFactoring;

import static bg.framework.app.functional.entities.FunctionalCategory.*;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.reFactoring.FastTrackAction;
import bg.framework.app.functional.action.selfServe.ASVIBAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class FasTTrackTest extends TestBase{
	
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
		.fastTrackASVLogin(userProfile).verifyAddress(userProfile)
		.fastTrackConfirmAddressDetails(userProfile).verifyAddress(userProfile)
		.fastTrackSelectAppointment("FF").verifyAddress(userProfile)
		.fastTrackReviewPageDetailsAC(userProfile)
		.addGAC()
		.addCOD(userProfile).verifyAddress(userProfile)
		.fastTrackConfirmationPage();
		/*.loginUserDetails(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.accountSummarycancelAppointment()
		.logout();*/
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
				.getUserProfile("HomeSerivcesAccount");
		
		new FastTrackAction()
		.fastTrackASVLogin(userProfile)
		.fastTrackConfirmAddressDetails(userProfile)
		.fastTrackSelectAppointment("ALLDAY")
		.fastTrackReviewPageDetailsACIB(userProfile)
		.addGAC()
		.addCODASVIB(userProfile)
		.fastTrackConfirmationPage()
		.navigateTrackCancelChangeIB()		
		.runVBSFT(userProfile, "ASV")
		.loginUserDetails(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.accountSummarycancelAppointment()		
		.logout();
	}
}
