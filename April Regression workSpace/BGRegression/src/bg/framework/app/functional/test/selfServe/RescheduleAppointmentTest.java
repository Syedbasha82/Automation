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

public class RescheduleAppointmentTest extends TestBase {

	UIDriver uiDriver = WebDriverProvider.getCurrentDriver();

	// Mandatory field : UCRN in userprofile
	@Test(groups = { Regression, Complex, Login })
	public void rescheduleAppointmentTest_Dual_OAM_Email_TC_001() {
		Report.createTestLogHeader(
				"rescheduleAppointmentTest_Dual_OAM_Email_TC_001",
				"Reschedule an appointment");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Dual_OAM_Email_001");

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
				.resheduleAppointment().verifyAvailableApoointments()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.navigateToYourAccountPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void rescheduleAppointmentTest_Electricity_OAM_Email_TC_002() {
		Report.createTestLogHeader(
				"rescheduleAppointmentTest_Electricity_OAM_Email_TC_002",
				"Reschedule an appointment");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Electricity_OAM_Email_002");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.getSONumberForCancelOrReschedule()
				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifyAddress(userProfile.getAccNumber())
				.resheduleAppointment().verifyAvailableApoointments()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.navigateToYourAccountPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void rescheduleAppointmentTest_JI_OAM_Email_TC_003() {
		Report.createTestLogHeader(
				"rescheduleAppointmentTest_JI_OAM_Email_TC_003",
				"Reschedule an appointment");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JI_OAM_Email_003");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.getSONumberForCancelOrReschedule()
				.verifyLogin(userProfile.getLastName(),
						userProfile.getAccNumber())
				.verifyAddress(userProfile.getAccNumber())
				.resheduleAppointment().verifyAvailableApoointments()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.navigateToYourAccountPage().verifySOStatus().logout();

	}
}
