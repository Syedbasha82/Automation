package bg.framework.app.functional.test.selfServe;

import static bg.framework.app.functional.entities.FunctionalCategory.Complex;
import static bg.framework.app.functional.entities.FunctionalCategory.Login;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.RunQTP;
import bg.framework.app.functional.util.TestDataHelper;

public class UpgradeToSmartMeterTest extends TestBase {

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Dual_OAM_Email_TC_008() {
		Report.createTestLogHeader("OAB_Digital_Func_008",
				"Upgrade to smart meter Dual_OAM ");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Dual_OAM_Email_008");

		getCustomerDetailsToUserProfileOAM(userProfile);

		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToLogin()
				.login(userProfile)
				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifyLogin(userProfile.getLastName(),
						userProfile.getGasAccount())

				.navigateToUpgradeSmartMeterPage()

				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Dual_OAM_Email_TC_011() {
		Report.createTestLogHeader("OAB_Digital_Func_011",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Electricity_OAM_Email_011");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToLogin()
				.login(userProfile)
				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifyAddress(userProfile.getAccNumber())
				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Dual_OAM_Email_TC_043() {
		Report.createTestLogHeader("OAB_Digital_Func_043",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Joint Invoice_OAM_Email_043");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToLogin()
				.login(userProfile)
				.verifyLogin(userProfile.getLastName(),
						userProfile.getAccNumber())

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifySOStatus().logout();

	}

	// ----------------------With Registration---------------------------
	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_JI_Non_OAM_Letter_TC_049() {
		Report.createTestLogHeader("OAB_Digital_Func_049",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JI_Non_OAM_Letter_049");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);
		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)
				.verifyLogin(userProfile.getLastName(),
						userProfile.getAccNumber())

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Dual_Non_OAM_Letter_TC_022() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_Dual_Non_OAM_Letter_TC_022",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Dual_Non_OAM_Letter_022");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);
		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)
				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifyLogin(userProfile.getLastName(),
						userProfile.getGasAccount())

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Electricity_Non_OAM_Letter_TC_019() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_Electricity_Non_OAM_Letter_TC_019",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Electricity_Non_OAM_Letter_019");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);
		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)
				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifySOStatus().logout();

	}

	// -------------------------------------------------------------
	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Electricity_OAM_Email_TC_007() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_Electricity_OAM_Email_TC_007",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Electricity_OAM_Email_007");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);
		new HomePageAction()
				.getSONumber()
				.navigateToLogin()
				.login(userProfile)
				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Electricity_OAM_Email_TC_009() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_Electricity_OAM_Email_TC_009",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Electricity_OAM_Email_009");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToLogin()
				.login(userProfile)
				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToElectricityAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Electricity_OAM_Email_TC_025() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_Electricity_OAM_Email_TC_025",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Electricity_OAM_Email_025");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToLogin()
				.login(userProfile)
				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Electricity_OAM_Email_TC_031() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_Electricity_OAM_Email_TC_031",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Electricity_OAM_Email_031");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToLogin()
				.login(userProfile)
				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_JI_OAM_Email_TC_044() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_JI_OAM_Email_TC_044",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JI_OAM_Email_044");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToLogin()
				.login(userProfile)
				.verifyLogin(userProfile.getLastName(),
						userProfile.getAccNumber())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifySOStatus().verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_JI_OAM_Email_TC_045() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_JI_OAM_Email_TC_045",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JI_OAM_Email_045");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToLogin()
				.login(userProfile)
				.verifyLogin(userProfile.getLastName(),
						userProfile.getAccNumber())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_JI_OAM_Email_TC_052() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_JI_OAM_Email_TC_052",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JI_OAM_Email_052");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToLogin()
				.login(userProfile)
				.verifyLogin(userProfile.getLastName(),
						userProfile.getAccNumber())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_JI_OAM_Email_TC_055() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_JI_OAM_Email_TC_055",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JI_OAM_Email_055");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToLogin()
				.login(userProfile)
				.verifyLogin(userProfile.getLastName(),
						userProfile.getAccNumber())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	// -------------------------------------------------------------------
	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Electricity_Non_OAM_Email_TC_013() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_Electricity_Non_OAM_Email_TC_013",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Electricity_Non_OAM_Email_013");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()

				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()

				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyIsThisWrongAddressAlert().verifyTimeoutAlert()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Electricity_Non_OAM_Email_TC_015() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_Electricity_Non_OAM_Email_TC_015",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Electricity_Non_OAM_Email_015");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Electricity_Non_OAM_Email_TC_017() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_Electricity_Non_OAM_Email_TC_017",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Electricity_Non_OAM_Email_017");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Electricity_Non_OAM_Email_TC_027() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_Electricity_Non_OAM_Email_TC_027",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Electricity_Non_OAM_Email_027");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Electricity_Non_OAM_Email_TC_033() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_Electricity_Non_OAM_Email_TC_033",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Electricity_Non_OAM_Email_033");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Electricity_Non_OAM_Email_TC_037() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_Electricity_Non_OAM_Email_TC_037",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Electricity_Non_OAM_Email_037");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Electricity_Non_OAM_Email_TC_039() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_Electricity_Non_OAM_Email_TC_039",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Electricity_Non_OAM_Email_039");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Electricity_Non_OAM_Email_TC_041() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_Electricity_Non_OAM_Email_TC_041",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Electricity_Non_OAM_Email_041");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Electricity_Non_OAM_Letter_TC_021() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_Electricity_Non_OAM_Letter_TC_021",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Electricity_Non_OAM_Letter_021");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Electricity_Non_OAM_Letter_TC_023() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_Electricity_Non_OAM_Letter_TC_023",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Electricity_Non_OAM_Letter_023");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Electricity_Non_OAM_Letter_TC_029() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_Electricity_Non_OAM_Letter_TC_029",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Electricity_Non_OAM_Letter_029");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Electricity_Non_OAM_Letter_TC_035() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_Electricity_Non_OAM_Letter_TC_035",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Electricity_Non_OAM_Letter_035");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_JI_Non_OAM_Email_TC_046() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_JI_Non_OAM_Email_TC_046",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JI_Non_OAM_Email_046");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getAccNumber())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_JI_Non_OAM_Email_TC_047() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_JI_Non_OAM_Email_TC_047",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JI_Non_OAM_Email_047");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getAccNumber())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_JI_Non_OAM_Email_TC_048() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_JI_Non_OAM_Email_TC_048",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JI_Non_OAM_Email_048");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getAccNumber())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_JI_Non_OAM_Email_TC_053() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_JI_Non_OAM_Email_TC_053",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JI_Non_OAM_Email_053");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getAccNumber())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_JI_Non_OAM_Email_TC_056() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_JI_Non_OAM_Email_TC_056",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JI_Non_OAM_Email_056");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getAccNumber())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_JI_Non_OAM_Email_TC_058() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_JI_Non_OAM_Email_TC_058",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JI_Non_OAM_Email_058");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getAccNumber())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_JI_Non_OAM_Letter_TC_050() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_JI_Non_OAM_Letter_TC_050",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JI_Non_OAM_Letter_050");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getAccNumber())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_JI_Non_OAM_Letter_TC_054() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_JI_Non_OAM_Letter_TC_054",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JI_Non_OAM_Letter_054");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getAccNumber())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_JI_Non_OAM_Letter_TC_057() {
		Report.createTestLogHeader(
				"upgradeToSmartMeterTest_JI_Non_OAM_Letter_TC_057",
				"Upgrade to smart meter");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JI_Non_OAM_Letter_057");

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getAccNumber())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Dual_OAM_Email_010() {
		Report.createTestLogHeader("OAB_Digital_Func_010",
				"Upgrade to smart meter Dual_OAM ");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Dual_OAM_Email_010");

		// writing Contract acc number in Default.xls for SO Creation QTP Test
		// Case.

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToLogin()
				.login(userProfile)
				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifyLogin(userProfile.getLastName(),
						userProfile.getGasAccount())
				.navigateToElectricityAccountSummaryPage(userProfile)

				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifySOStatus().verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToElectricityAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Dual_OAM_Email_012() {
		Report.createTestLogHeader("OAB_Digital_Func_012",
				"Upgrade to smart meter Dual_OAM ");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Dual_OAM_Email_012");

		// writing Contract acc number in Default.xls for SO Creation QTP Test
		// Case.

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToLogin()
				.login(userProfile)
				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifyLogin(userProfile.getLastName(),
						userProfile.getGasAccount())
				.navigateToElectricityAccountSummaryPage(userProfile)

				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifySOStatus().verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToElectricityAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Dual_OAM_Email_026() {
		Report.createTestLogHeader("OAB_Digital_Func_026",
				"Upgrade to smart meter Dual_OAM ");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Dual_OAM_Email_026");

		// writing Contract acc number in Default.xls for SO Creation QTP Test
		// Case.

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToLogin()
				.login(userProfile)
				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifyLogin(userProfile.getLastName(),
						userProfile.getGasAccount())
				.navigateToElectricityAccountSummaryPage(userProfile)

				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifySOStatus().verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToElectricityAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Dual_OAM_Email_032() {
		Report.createTestLogHeader("OAB_Digital_Func_032",
				"Upgrade to smart meter Dual_OAM ");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Dual_OAM_Email_032");

		// writing Contract acc number in Default.xls for SO Creation QTP Test
		// Case.

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToLogin()
				.login(userProfile)
				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifyLogin(userProfile.getLastName(),
						userProfile.getGasAccount())
				.navigateToElectricityAccountSummaryPage(userProfile)

				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifySOStatus().verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToElectricityAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage();

	}

	// _____with registration ________________________________________

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Dual_Non_OAM_Email_014() {
		Report.createTestLogHeader("OAB_Digital_Func_014",
				"Upgrade to smart meter Dual_Non_OAM ");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Dual_Non_OAM_Email_014");

		// writing Contract acc number in Default.xls for SO Creation QTP Test
		// Case.

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifyLogin(userProfile.getLastName(),
						userProfile.getGasAccount())
				.navigateToElectricityAccountSummaryPage(userProfile)

				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifySOStatus().verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToElectricityAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Dual_Non_OAM_Email_016() {
		Report.createTestLogHeader("OAB_Digital_Func_016",
				"Upgrade to smart meter Dual_Non_OAM ");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Dual_Non_OAM_Email_016");
		// uiDriver.get(ApplicationConfig.APP_SERVICES_URL);

		// writing Contract acc number in Default.xls for SO Creation QTP Test
		// Case.

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifyLogin(userProfile.getLastName(),
						userProfile.getGasAccount())
				.navigateToElectricityAccountSummaryPage(userProfile)

				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifySOStatus().verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToElectricityAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Dual_Non_OAM_Email_018() {
		Report.createTestLogHeader("OAB_Digital_Func_018",
				"Upgrade to smart meter Dual_Non_OAM ");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Dual_Non_OAM_Email_018");

		// writing Contract acc number in Default.xls for SO Creation QTP Test
		// Case.

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifyLogin(userProfile.getLastName(),
						userProfile.getGasAccount())
				.navigateToElectricityAccountSummaryPage(userProfile)

				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifySOStatus().verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToElectricityAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Dual_Non_OAM_Letter_020() {
		Report.createTestLogHeader("OAB_Digital_Func_020",
				"Upgrade to smart meter Dual_Non_OAM ");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Dual_Non_OAM_Letter_020");

		// writing Contract acc number in Default.xls for SO Creation QTP Test
		// Case.

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifyLogin(userProfile.getLastName(),
						userProfile.getGasAccount())
				.navigateToElectricityAccountSummaryPage(userProfile)

				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifySOStatus().verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToElectricityAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Dual_Non_OAM_Letter_024() {
		Report.createTestLogHeader("OAB_Digital_Func_024",
				"Upgrade to smart meter Dual_Non_OAM ");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Dual_Non_OAM_Letter_024");

		// writing Contract acc number in Default.xls for SO Creation QTP Test
		// Case.

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifyLogin(userProfile.getLastName(),
						userProfile.getGasAccount())
				.navigateToElectricityAccountSummaryPage(userProfile)

				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifySOStatus().verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToElectricityAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Dual_Non_OAM_Email_028() {
		Report.createTestLogHeader("OAB_Digital_Func_028",
				"Upgrade to smart meter Dual_Non_OAM ");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Dual_Non_OAM_Email_028");

		// writing Contract acc number in Default.xls for SO Creation QTP Test
		// Case.

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifyLogin(userProfile.getLastName(),
						userProfile.getGasAccount())
				.navigateToElectricityAccountSummaryPage(userProfile)

				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifySOStatus().verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToElectricityAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Dual_Non_OAM_Letter_030() {
		Report.createTestLogHeader("OAB_Digital_Func_030",
				"Upgrade to smart meter Dual_Non_OAM ");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Dual_Non_OAM_Letter_030");

		// writing Contract acc number in Default.xls for SO Creation QTP Test
		// Case.

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifyLogin(userProfile.getLastName(),
						userProfile.getGasAccount())
				.navigateToElectricityAccountSummaryPage(userProfile)

				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifySOStatus().verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToElectricityAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Dual_Non_OAM_Email_034() {
		Report.createTestLogHeader("OAB_Digital_Func_034",
				"Upgrade to smart meter Dual_Non_OAM ");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Dual_Non_OAM_Email_034");

		// writing Contract acc number in Default.xls for SO Creation QTP Test
		// Case.

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifyLogin(userProfile.getLastName(),
						userProfile.getGasAccount())
				.navigateToElectricityAccountSummaryPage(userProfile)

				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifySOStatus().verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToElectricityAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Dual_Non_OAM_Letter_036() {
		Report.createTestLogHeader("OAB_Digital_Func_036",
				"Upgrade to smart meter Dual_Non_OAM ");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Dual_Non_OAM_Letter_036");

		// writing Contract acc number in Default.xls for SO Creation QTP Test
		// Case.

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifyLogin(userProfile.getLastName(),
						userProfile.getGasAccount())
				.navigateToElectricityAccountSummaryPage(userProfile)

				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifySOStatus().verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToElectricityAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Dual_Non_OAM_Email_038() {
		Report.createTestLogHeader("OAB_Digital_Func_038",
				"Upgrade to smart meter Dual_Non_OAM ");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Dual_Non_OAM_Email_038");

		// writing Contract acc number in Default.xls for SO Creation QTP Test
		// Case.

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifyLogin(userProfile.getLastName(),
						userProfile.getGasAccount())
				.navigateToElectricityAccountSummaryPage(userProfile)

				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifySOStatus().verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToElectricityAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Dual_Non_OAM_Email_040() {
		Report.createTestLogHeader("OAB_Digital_Func_040",
				"Upgrade to smart meter Dual_Non_OAM ");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Dual_Non_OAM_Email_040");

		// writing Contract acc number in Default.xls for SO Creation QTP Test
		// Case.

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifyLogin(userProfile.getLastName(),
						userProfile.getGasAccount())
				.navigateToElectricityAccountSummaryPage(userProfile)

				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifySOStatus().verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToElectricityAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_Dual_Non_OAM_Email_042() {
		Report.createTestLogHeader("OAB_Digital_Func_042",
				"Upgrade to smart meter Dual_Non_OAM ");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("Dual_Non_OAM_Email_042");

		// writing Contract acc number in Default.xls for SO Creation QTP Test
		// Case.

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getElecAccount())
				.verifyLogin(userProfile.getLastName(),
						userProfile.getGasAccount())
				.navigateToElectricityAccountSummaryPage(userProfile)

				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifySOStatus().verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToElectricityAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getElecAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()
				.navigateToGasAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getGasAccount())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage();

	}

	// verifications needed
	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_JI_Non_OAM_Letter_051() {
		Report.createTestLogHeader("OAB_Digital_Func_051",
				"Upgrade to smart meter  ");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JI_Non_OAM_Letter_051");

		// writing Contract acc number in Default.xls for SO Creation QTP Test
		// Case.

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getAccNumber())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	// will nedd verifications
	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_JI_Non_OAM_Email_059() {
		Report.createTestLogHeader("OAB_Digital_Func_059",
				"Upgrade to smart meter JI_Non_OAM ");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JI_Non_OAM_Email_059");

		// writing Contract acc number in Default.xls for SO Creation QTP Test
		// Case.

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getAccNumber())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

	@Test(groups = { Regression, Complex, Login })
	public void upgradeToSmartMeterTest_JI_Non_OAM_Email_060() {
		Report.createTestLogHeader("OAB_Digital_Func_060",
				"Upgrade to smart meter JI_Non_OAM");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JI_Non_OAM_Email_060");

		// writing Contract acc number in Default.xls for SO Creation QTP Test
		// Case.

		getCustomerDetailsToUserProfileOAM(userProfile);
		new RunQTP()
				.runQTP1(
						"/BGRegression/src/bg/framework/app/functional/util/vbsScripts/SO_Creation.vbs",
						userProfile);

		new HomePageAction()
				.getSONumber()
				.navigateToRegistration()
				.registerEnterYourDetails(userProfile)

				.verifyLogin(userProfile.getLastName(),
						userProfile.getAccNumber())
				.verifySmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifySmartMeterLinkAtAccountSummaryPage().navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifySmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage()

				.navigateToUpgradeSmartMeterPage()
				.verifyIsThisWrongAddressAlert().verifyTimeoutAlert()
				.verifyAddress(userProfile.getAccNumber())
				.navigateToChooseAnAppointmentPage()
				.verifyAvailableApoointments().checkAvailableBookingSlot()
				.navigateToReviewDetailsPage()
				.navigateToConfirmationPage(userProfile)
				.verifyAddressAndReferenceNo().navigateToYourAccountPage()
				.verifyNoSmartMeterLinkAtAccountOverviewPage()
				.navigateToAccountSummaryPage(userProfile)
				.verifyNoSmartMeterLinkAtAccountSummaryPage()
				.navigateToSMRPage()
				.setPlausbileReading(userProfile.getAccNumber())
				.confirmAccountSelection().submitMeterReads()
				.verifyNoSmartMeterLinkAtMeterReadingPage()
				.navigateToAccountOverviewPage().verifySOStatus().logout();

	}

}
