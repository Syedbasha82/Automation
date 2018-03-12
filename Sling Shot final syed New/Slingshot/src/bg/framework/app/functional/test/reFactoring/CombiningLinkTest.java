package bg.framework.app.functional.test.reFactoring;

import static bg.framework.app.functional.entities.FunctionalCategory.ASVIB;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class CombiningLinkTest extends TestBase{
	
	/* CombineLink_TC_01
	 * IB Journey combined with Booked IB - Keep appointment
	 * 
	 * 
	 */
	@Test(groups = { ASVIB,Regression })
	public void ibBookingWithBookedIBKeepAppointment()
	{
		Report.createTestLogHeader("Combine Link -IB combined with Booked IB Journey Test - Keep slots - Different Appointment", "HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeSerivcesAccount");
		
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
	
	 /* CombineLink_TC_02
	 * IB Journey combined with ASV - Keep appointment
	 * 
	 * 
	 */	
	@Test(groups = { ASVIB ,Regression })
	public void ibBookingWithASVKeepAppointment()
	{
		Report.createTestLogHeader("Combine Link -ASV combined with IB Journey Test - View all slots - keep Appointment - Added COD", "HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeSerivcesAccount");
		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)		
		.navigateToAccountSummaryPageASV()
		.bookAnEngineer(userProfile, "ASV")
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
		.navigateToConfirmation(userProfile, 4)
		.navigateTrackCancelChange();
	
	}
	
	 /* CombineLink_TC_03
	 * ASV Journey combined with IB added COD
	 * 
	 * 
	 */
	@Test(groups = { ASVIB ,Regression})
	public void asvBookingWithIB()
	{
		Report.createTestLogHeader("Combine Link -ASV combined with IB Journey Test - Book First - Added GAC & COD", "HomeSerivcesAccount");
		UserProfile userProfile= new TestDataHelper()
				.getUserProfile("HomeSerivcesAccount");
		
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
		.navigateTrackCancelChange()
		.logout();
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.bookAnEngineer(userProfile, "ASV")
		.changeAppointment(1)
		.reviewDetailsPage()			
		.navigateToConfirmation()
		.navigateTrackCancelChange();
	
	}
	
}
