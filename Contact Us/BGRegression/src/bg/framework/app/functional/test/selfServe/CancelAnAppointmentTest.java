package bg.framework.app.functional.test.selfServe;

import static bg.framework.app.functional.entities.FunctionalCategory.Complex;
import static bg.framework.app.functional.entities.FunctionalCategory.Login;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import bg.framework.common.functional.UIDriver;
import bg.framework.common.functional.WebDriverProvider;

public class CancelAnAppointmentTest extends TestBase {

	UIDriver uiDriver = WebDriverProvider.getCurrentDriver();

	// Mandatory field : UCRN in userprofile
	@Test(groups = { Regression, Complex, Login })
	public void cancelAnAppointment_Dual_OAM_Email_TC_004() {
		Report.createTestLogHeader("cancelAnAppointment_Dual_OAM_Email_TC_004",
				"Cancel an Appointment");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Dual_OAM_Email_004");

		getCustomerDetailsToUserProfileOAM(userProfile);

		new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.getSONumberForCancelOrReschedule()
				.verifyLogin(userProfile.getLastName(),
						userProfile.getGasAccount())
				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifyAddress(userProfile.getAccNumber())
				.cancelAnAppointment(userProfile).verifyCancelSOStatus()
				.logout();
	}

	@Test(groups = { Regression, Complex, Login })
	public void cancelAnAppointment_Electricity_OAM_Email_TC_005() {
		Report.createTestLogHeader(
				"cancelAnAppointment_Electricity_OAM_Email_TC_005",
				"Cancel an Appointment");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Electricity_OAM_Email_005");

		getCustomerDetailsToUserProfileOAM(userProfile);

		new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.getSONumberForCancelOrReschedule()
				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifyAddress(userProfile.getAccNumber())
				.cancelAnAppointment(userProfile).verifyCancelSOStatus()
				.logout();
	}

	@Test(groups = { Regression, Complex, Login })
	public void cancelAnAppointment_JI_OAM_Email_TC_006() {
		Report.createTestLogHeader("cancelAnAppointment_JI_OAM_Email_TC_006",
				"Cancel an Appointment");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JI_OAM_Email_006");

		getCustomerDetailsToUserProfileOAM(userProfile);

		new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.getSONumberForCancelOrReschedule()
				.verifyLogin(userProfile.getLastName(),
						userProfile.getAccNumber())
				.verifyAddress(userProfile.getAccNumber())
				.cancelAnAppointment(userProfile).verifyCancelSOStatus()
				.logout();
	}
}
