package bg.framework.app.functional.test.selfServe;


import static bg.framework.app.functional.entities.FunctionalCategory.*;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.selfServe.EmergentPostCodeFinderAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;

public class EmergencyPostCodeFinderTest extends TestBase {
	
	/*
     *  
     *  Anonymous Emergency Post Code Journey
     */
	 @Test(groups = {EmergenyPostCode,Smoke,AnonymousRegression})
public void emergencyPostCode()
{
	Report.createTestLogHeader("Emergency Post Code Journey test", "Anonymous");
	new HomePageAction()
	.navigateToLogout();
    new EmergentPostCodeFinderAction()
    .navigateToEmergencies()
    .enterThePostCode();
}
	 
	 /*
	     *  Mandatory field in UserProfile: UCRN,Account Number,GasAccount,Email.
	     *  OAM Emergency Post Code Journey
	     */
	 @Test(groups = {EmergenyPostCode,Smoke})
	 public void oamEmergencyPostCode()
	 {
		 Report.createTestLogHeader("Emergency Post Code Journey test", "OAM");
		    UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount") ;
			new HomePageAction()
			.navigateToLogout();
		    new EmergentPostCodeFinderAction()		    
		    .navigateToLogin(userProfile)
		    .loginUser(userProfile)
		    .navigateToEmergencies()
		    .enterThePostCode()
		    .logOut();
		    
	 }
}
