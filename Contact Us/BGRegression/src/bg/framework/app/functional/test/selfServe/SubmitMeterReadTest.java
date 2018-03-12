package bg.framework.app.functional.test.selfServe;



import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.selfServe.SMRAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.RunQTP;
import bg.framework.app.functional.util.TestDataHelper;

import org.testng.annotations.Test;

import static bg.framework.app.functional.entities.FunctionalCategory.*;

public class SubmitMeterReadTest extends TestBase {

	 @Test(groups = { SubmitMeterRead,Regression,InProgress })
	 	//Yet to make Sap Validations
	public void submitPlausibleElecMeter() {
		Report.createTestLogHeader("Submit Meter Read.", "Plausible Electricity Meter");

		UserProfile userProfile = new TestDataHelper()
		        .getUserProfile("ElectricityAccount");
		try {
			registerCustomerDetailsInOnlineDB(userProfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		getCustomerDetailsToUserProfileOAM(userProfile);
		userProfile.setAccNumber(userProfile.getElecAccount());
		new SMRAction().resetMeterRead(userProfile.getElecAccount());// .resetMeterRead("85000000058");
		new HomePageAction().navigateToLogin().login(userProfile)
		        .navigateToAccountSummaryPage(userProfile).navigateToSMRPage()
		        .setPlausbileReading(userProfile.getElecAccount())
		        .confirmAccountSelection().submitMeterReads()
		        .verifyMeterConfirmation(userProfile.getElecAccount(), userProfile);

	}
	 
	 @Test(groups = { SubmitMeterRead,Regression })
	public void submitImPlausibleElecMeter() {
		Report.createTestLogHeader("Submit Meter Read.", "Implaussible Electricity Meter");

		UserProfile userProfile = new TestDataHelper()
		        .getUserProfile("ElectricityAccount");

		// getCustomerDetailsToUserProfileOAM(userProfile);
	//	userProfile.setAccNumber(userProfile.getElecAccount());
	//	new SMRAction().resetMeterRead(userProfile.getAccNumber());
		new HomePageAction().navigateToLogin().login(userProfile)
		        .navigateToAccountSummaryPage(userProfile).navigateToSMRPage()
		        .setImPlausbileReading(userProfile.getAccNumber())
		        .confirmAccountSelection().submitImplaussibleMeterRead()
		        .verifyMeterConfirmation(userProfile.getAccNumber(), userProfile);
		new RunQTP().runQTP("sample.vbs", userProfile.getAccNumber());

	}

	@Test(groups = { SubmitMeterRead,Smoke })
	//Yet to make Sap Validations
	public void submitPlausibleGasMeter() {
		Report.createTestLogHeader("Submit Meter Read.", "Plausible Gas Meter");
		

		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");

		userProfile.setAccNumber(userProfile.getGasAccount());
		
		//getCustomerDetailsToUserProfileOAM(userProfile);

		//new SMRAction().resetMeterRead(userProfile.getGasAccount());
		new HomePageAction().navigateToLogin().login(userProfile)
		        .navigateToAccountSummaryPage(userProfile).navigateToSMRPage()
		        .setPlausbileReading(userProfile.getGasAccount())
		        .confirmAccountSelection()		        
		        .verifyMeterConfirmation(userProfile.getGasAccount(), userProfile);

	}
	@Test(groups = { SubmitMeterRead,Smoke })
	public void submitImPlausibleGasMeter() {
		Report.createTestLogHeader("Submit Meter Read.", "ImPlausible Gas Meter");


		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");

		userProfile.setAccNumber(userProfile.getGasAccount());

		getCustomerDetailsToUserProfileOAM(userProfile);

		new SMRAction().resetMeterRead(userProfile.getGasAccount());// .resetMeterRead("85000000058");
		new HomePageAction().navigateToLogin().login(userProfile)
		        .navigateToAccountSummaryPage(userProfile)
		        .navigateToSMRPage()
		        .setImPlausbileReading(userProfile.getGasAccount())
		        .confirmAccountSelection()
		        .verifyMeterConfirmation(userProfile.getGasAccount(), userProfile);

	}
	
	
	@Test(groups = { SubmitMeterRead,Regression,InProgress })
 	//Yet to make Sap Validations
	public void submitPlausibleElecMeterDeepLink() {
	Report.createTestLogHeader("Submit Meter Read.", "Plausible Electricity Meter");

	UserProfile userProfile = new TestDataHelper()
	        .getUserProfile("ElectricityAccount");
	try {
		registerCustomerDetailsInOnlineDB(userProfile);
	} catch (Exception e) {
		e.printStackTrace();
	}
	getCustomerDetailsToUserProfileOAM(userProfile);
	userProfile.setAccNumber(userProfile.getElecAccount());
	new SMRAction().resetMeterRead(userProfile.getElecAccount());// .resetMeterRead("85000000058");
	new HomePageAction().navigateToSMRDeepLink().login(userProfile);
	        new SMRAction()
	        .setPlausbileReading(userProfile.getElecAccount())
	        .confirmAccountSelection().submitMeterReads()
	        .verifyMeterConfirmation(userProfile.getElecAccount(), userProfile);

}

	
	//Data Required Electricity account with Nectar sign up
	@Test(groups = { SubmitMeterRead,Regression,InProgress })
public void submitMeterReadNectarSignup() {
	Report.createTestLogHeader("Submit Meter Read.", "Submit Meter Read with Nectar Sign up");

	UserProfile userProfile = new TestDataHelper()
	        .getUserProfile("ElectricityAccount");
	try {
		registerCustomerDetailsInOnlineDB(userProfile);
	} catch (Exception e) {
		e.printStackTrace();
	}
	getCustomerDetailsToUserProfileOAM(userProfile);
	userProfile.setAccNumber(userProfile.getElecAccount());
	new SMRAction().resetMeterRead(userProfile.getElecAccount());// .resetMeterRead("85000000058");
	new HomePageAction().navigateToLogin().login(userProfile)
	        .navigateToAccountSummaryPage(userProfile).navigateToSMRPage()
	        .setPlausbileReadingNectar(userProfile.getElecAccount())
	        .nectarSignUp()
	        .submitMeterReadings()
	        .verifyNectarConfirmation();

	
	}
	
	//Submit meter read Finally billed customer
		@Test(groups = { SubmitMeterRead,Regression,InProgress })
	public void submitMeterReadFinallyBilled() {
		Report.createTestLogHeader("Submit Meter Read.", "Submit Meter Read For finally Billed customer");

		UserProfile userProfile = new TestDataHelper()
		        .getUserProfile("ElectricityAccount");
		try {
			registerCustomerDetailsInOnlineDB(userProfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//getCustomerDetailsToUserProfileOAM(userProfile);
		userProfile.setAccNumber(userProfile.getElecAccount());
		new SMRAction().resetMeterRead(userProfile.getElecAccount());// .resetMeterRead("85000000058");
		new HomePageAction().navigateToLogin().login(userProfile)
		        .navigateToAccountSummaryPage(userProfile).navigateToSMRPage()
		        .submitFinallyBilledReadings(userProfile.getElecAccount())
		        .submitMeterReadings()
		        .verifyFinallyBilledMsg();

		
		}
		
    //Sprint 04 changes
		
		@Test(groups = { SubmitMeterRead,Regression,InProgress })
		public void submitMeterReadClosedGas() {
			Report.createTestLogHeader("Submit Meter Read", "Submit Meter Read For Closed Gas Account customer");

			UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
			try {
				registerCustomerDetailsInOnlineDB(userProfile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//getCustomerDetailsToUserProfileOAM(userProfile);
			userProfile.setAccNumber(userProfile.getGasAccount());
			new SMRAction().resetMeterRead(userProfile.getGasAccount());
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile)
				.navigateToSMRPage()
				.verifyClosedAccountinSMR(userProfile)
				.logout();		
			}
		
		@Test(groups = { SubmitMeterRead,Regression,InProgress })
		public void submitMeterReadClosedElectricity() {
			Report.createTestLogHeader("Submit Meter Read", "Submit Meter Read For Closed Electricity Account customer");

			UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
			try {
				registerCustomerDetailsInOnlineDB(userProfile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//getCustomerDetailsToUserProfileOAM(userProfile);
			userProfile.setAccNumber(userProfile.getElecAccount());
			new SMRAction().resetMeterRead(userProfile.getElecAccount());
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile)
				.navigateToSMRPage()
				.verifyClosedAccountinSMR(userProfile)
				.logout();		
			}
		
		@Test(groups = { SubmitMeterRead,Regression,InProgress })
		public void submitMeterReadClosedJI() {
			Report.createTestLogHeader("Submit Meter Read", "Submit Meter Read For Closed JI Account customer");

			UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
			try {
				registerCustomerDetailsInOnlineDB(userProfile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//getCustomerDetailsToUserProfileOAM(userProfile);
			userProfile.setAccNumber(userProfile.getAccNumber());
			new SMRAction().resetMeterRead(userProfile.getAccNumber());
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile)
				.navigateToSMRPage()
				.verifyClosedAccountinSMR(userProfile)
				.logout();		
			}
		
		@Test(groups = { SubmitMeterRead,Regression,InProgress })
		public void submitMeterReadClosedDual() {
			Report.createTestLogHeader("Submit Meter Read.", "Submit Meter Read For Closed Dual Account customer");

			UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
			try {
				registerCustomerDetailsInOnlineDB(userProfile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//getCustomerDetailsToUserProfileOAM(userProfile);
			userProfile.setAccNumber(userProfile.getAccNumber());
			new SMRAction().resetMeterRead(userProfile.getAccNumber());
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile)
				.navigateToSMRPage()
				.verifyClosedAccountinSMR(userProfile)
				.logout();		
			}
}
