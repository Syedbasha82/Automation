package bg.framework.app.functional.test.Slingshot_Broker;

import static bg.framework.app.functional.entities.FunctionalCategory.Regression;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.Slingshot.SapCrmAction;
import bg.framework.app.functional.action.Slingshot_Broker.RegistrationAction;
import bg.framework.app.functional.entities.CrmUserProfile;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class RegistrationTest extends TestBase{
	
	//TS_Broker_Registration_01:To verify whether the broker is able to register successfully
	//TS_Broker_Registration_03:To verify whether the broker registration page is displayed after clicking on the registration link(Register now) in the corresponding broker's email
	//TS_Broker_Registration_14:To verify the registration successful confirmation page is displayed after entering the mandatory details in the registration page and after clicking continue button 
	//TS_Broker_Registration_17	To verify whether the Registration successful email is sent to the respective user after the registration is successful

	@Test(groups={Regression})
	public void verifyBrokerRegistration(){
		Report.createTestLogHeader("Broker_Registration", "Verifies whether the broker is able to register successfully");
		UserProfile userProfile = new TestDataHelper().getUserProfile("BrokerRegistartion");
		//CrmUserProfile crmuserProfile = new TestDataHelper().getCrmUserProfile("SlingshotCrmDetails"); 
		/*new SapCrmAction()
		 .loginDetails(crmuserProfile)
		 .searchByAccountId(crmuserProfile, userProfile);*/
		new RegistrationAction()
		.openEncryptURL(userProfile)
		.fillRegistrationDetails(userProfile)
		.verifyThankYouPage()
		.clickLoginLink()
		.verifyAuditEntry(userProfile)
		.verifyEmailIdInDb(userProfile)
		;
	}
	
	//TS_Broker_Registration_32	To verify whether the "your email address is already registered" page is displayed on clicking the email registration link for the second time after the successful registration
	@Test(groups={Regression})
	public void verifyAlreadyRegisteredLink(){
		Report.createTestLogHeader("Broker_Registration", "Verifies already registered page is displayed on clicking the email registration link for the second time after the successful registration");
		UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");
		new RegistrationAction()
		.verifyAlreadyRegisteredLink();
	}
	
	//TS_Broker_Registration_29	"To verify whether the ""Registration link invalid"" page is displayed when the 
	//a)URL is pasted in the browser as invalid/wrong format	
	//TS_Broker_Registration_31	"To verify the link navigations of  ""Registration link invalid"" page
	@Test(groups={Regression})
	public void verifyInvalidLink(){
		Report.createTestLogHeader("Broker_Registration", "Verifies whether the Registration link invalid page is displayed");
		UserProfile userProfile = new TestDataHelper().getUserProfile("BrokerRegistartion");
		new RegistrationAction()
		.verifyInvalidLink(userProfile)
		.verifyRegistrationInvalidPageLinks();
	}
	
	//TS_Broker_Registration_09	"To verify whether appropriate error message (Inline and top) is Last name field displayed when,
	//a)Field is empty	//b)Invalid/special characters	//c)More than 40 characters	//d)Single character"

	@Test(groups={Regression})
	public void validateLastNameErrorMessages(){
		Report.createTestLogHeader("Broker_Registration", "Verifies whether the Registration link invalid page is displayed");
		UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");
		new RegistrationAction()	
		.openEncryptURL(userProfile)
		.validateLastNameErrorMessage(userProfile);		
	}
}
