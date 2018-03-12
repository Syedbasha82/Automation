package bg.framework.app.functional.test.reFactoring;

import static bg.framework.app.functional.entities.FunctionalCategory.ASVIB;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
 
public class BookingCompleteTest extends TestBase {
	
	/*
	 * BookingComplete_TC_01
	 * ASV Journey with GAC added
	 * 
	 * 
	 
	@Test(groups = { ASVIB ,Regression}) 
	public void asvBookingCompleteWithGAC()
	{
		Report.createTestLogHeader("Booking Complete - ASV Journey Test - GAC Added", "HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeSerivcesAccount");
		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAccountOverview()
		.clickBookThisAppointment(userProfile,"ASV")
		.GACReviewDetails()
		.addGAC()
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}*/
	
	
	/*
	 * BookingComplete_TC_04
	 * ASV Journey with view all slots and select the first available slot
	 * 
	 * 
	 
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
		.verifyAccountOverview()
		.navigateToViewAllAppointments()
		.selectAnAppointment()
		.reviewDetailsPage()
		.navigateToConfirmation()
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	}*/
	
	
	/*
	 * BookingComplete_TC_05
	 * IB Journey with added COD
	 * 
	 * 
	 
	@Test(groups = { ASVIB,Regression })
	public void ibBookingCompleteWithCOD()
	{
		Report.createTestLogHeader("Booking Complete - IB Journey Test - Book First - Added COD", "HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeSerivcesAccount");
		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAccountOverview()
		.bookAnEngineer(userProfile, "IV")
		.navigateToIdentifyFault()
		.navigateToReview(1)
		.navigateToConfirmation(userProfile, 3)
		.logout();
	}*/
	
	/*
	 * BookingComplete_TC_03
	 * ASV Journey combined with IB added COD
	 * 
	 * 
	 
	@Test(groups = { ASVIB,Regression })
	public void asvBookingWithIB()
	{
		Report.createTestLogHeader("Booking Complete -ASV combined with IB Journey Test - Book First - Added GAC & COD", "HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeSerivcesAccount");
		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAccountOverview()
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
	
	}*/
	
	
	/*
	 * BookingComplete_TC_06
	 * IB Journey combined with ASV - Keep appointment
	 * 
	 * 
	 */
	@Test(groups = { ASVIB,Regression})
	public void ibBookingWithASVKeepAppointment()
	{
		Report.createTestLogHeader("Booking Complete -ASV combined with IB Journey Test - View all slots - keep Appointment - Added COD", "HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeSerivcesAccount");
		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)		
		.navigateToAccountSummaryPageASV()
		.verifyAccountOverview("Ideal")
		.bookAnEngineer(userProfile, "ASV")
		.navigateToConfirmation(userProfile, 4)
		.navigateTrackCancelChange()
		.logout();
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)		
		.navigateToAccountSummaryPageASV()
		.verifyAccountOverview("Ideal")
		.bookAnEngineer(userProfile, "IV")		
		.navigateToIdentifyFault()
		.navigateToReview(1)
		.changeAppointment(2)
		.selectAnAppointment()
        .reviewDetailsPage()
        .addCOD(userProfile)        
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	
	}
	
	
	/*
	 * BookingComplete_TC_07
	 * IB Journey combined with ASV - different slot
	 * 
	 * 
	 */
	@Test(groups = { ASVIB , Regression })
	public void ibBookingWithASVDifferentAppointment()
	{
		Report.createTestLogHeader("Booking Complete -IB combined with ASV Journey Test - View all slots - Different Appointment", "HomeSerivcesAccount");
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
		.logout();
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)		
		.navigateToAccountSummaryPageASV()
		.verifyAccountOverview("Ideal") 
		.bookAnEngineer(userProfile, "IV")		
		.navigateToIdentifyFault()		
		.navigateToReview(1)
		.changeAppointment(2)
		.selectAnAppointment()
		.reviewDetailsPage()
		.navigateToConfirmation()
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
	
	}
	
	/*
	 * BookingComplete_TC_08
	 * IB Journey combined with Booked IB - Keep appointment
	 * 
	 * 
	 */
	@Test(groups = { ASVIB,Regression })
	public void ibBookingWithBookedIBKeepAppointment()
	{
		Report.createTestLogHeader("Booking Complete -IB combined with Booked IB Journey Test - Keep slots - Different Appointment", "HomeSerivcesAccount");
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
		.logout();
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)		
		.navigateToAccountSummaryPageASV()
		.bookAnEngineer(userProfile, "IV")
		.navigateToIdentifyFault()
		.navigateToReview(1)
		.changeAppointment(1)
		.navigateToConfirmation(userProfile, 1)
		.navigateTrackCancelChange();	
	}
	
	
	/*
	 * BookingComplete_TC_11
	 * ASV Journey For  - Keep appointment
	 * 
	 * 
	 */
	@Test(groups = { ASVIB,Regression })
	public void ibBookingForHomeCareFlexi()
	{
		Report.createTestLogHeader("Booking Complete for IB combined with Booked IB Journey Test Keep slots with Different Appointment", "HomeSerivcesAccount");
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
		//.reviewDetailsPage()
		.navigateToConfirmation(userProfile,4)
		.navigateTrackCancelChange()
		.accountSummarycancelAppointment()
		.logout();
			
	}

}
