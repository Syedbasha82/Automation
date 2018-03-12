package bg.framework.app.functional.test.reFactoring;

import static bg.framework.app.functional.entities.FunctionalCategory.ASVIB;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class CompleteTest {
	
	/*
	 * BookingComplete_TC_01
	 * ASV Journey with GAC added
	 * 
	 * 
	 */
	@Test(groups = { ASVIB, Regression }) 
	public void asvBookingCompleteWithGAC()
	{
		Report.createTestLogHeader("Booking Complete - ASV Journey Test - GAC Added", "HomeSerivcesAccount");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeSerivcesAccount");
		
		new HomePageAction()
		.navigateToLogin()
		.loginUserDetails(userProfile)
		.navigateToAccountSummaryPageASV()
		.verifyAccountOverview("Ideal")		
		.logout();
	}

}
