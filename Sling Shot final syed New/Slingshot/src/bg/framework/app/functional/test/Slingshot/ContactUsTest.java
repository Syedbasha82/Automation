package bg.framework.app.functional.test.Slingshot;

import static bg.framework.app.functional.entities.FunctionalCategory.BGBRegistration;
import static bg.framework.app.functional.entities.FunctionalCategory.Slingshot;
import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import bg.framework.app.functional.action.Slingshot.ContactUsAction;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class ContactUsTest extends TestBase {
	
	@SuppressWarnings("unchecked")
	@Test(groups ={Slingshot,Smoke,BGBRegistration})	
	
    public void verifyAnonymousContactus() throws Exception {
		UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs"); 
		 Report.createTestLogHeader("ContactUs", "To Verify user can perform contact us anonymously");
		  new ContactUsAction()
		  .navigateToContactUsPage()
		  .submitQuerry(userProfile,"Anonymous");
	
	}
	
	@SuppressWarnings("unchecked")
	@Test(groups ={Slingshot,Smoke,BGBRegistration})	
	
    public void verifyLoggedInContactus() throws Exception {
		UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs"); 
		 Report.createTestLogHeader("ContactUs", "To Verify OAM user can perform contact us sucessfully");
		 new LoginAction()
		 .BgbloginDetailsNew(userProfile)
		.BgbVerifyLogin(userProfile);
		  new ContactUsAction()
		  .navigateToContactUsPageLogin()
		  .submitQuerry(userProfile,"OAM");
		
		
	
	}
	
	@SuppressWarnings("unchecked")
	@Test(groups ={Slingshot,Smoke,BGBRegistration})	
	
    public void verifyLoggedInLandingFunctinalityInContactus() throws Exception {
		UserProfile userProfile = new TestDataHelper().getUserProfile("ContactUs"); 
		 Report.createTestLogHeader("ContactUs", "To Verify Contact Us Form OAM Landing Page");
		  new ContactUsAction()
		  .navigateToContactUsPage()
		  .verifyLoginLandingPageFunctionality(userProfile);
		
		
	
	}
	
	@AfterMethod
    public void runAfterClass1(ITestResult result) {
        FiddlerRunning fiddlerRunning = new FiddlerRunning();
        String testName = result.getMethod().getMethodName();
        fiddlerRunning.runFiddlerAfter(testName);
    }

}
