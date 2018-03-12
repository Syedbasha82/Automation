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
		        .verifyMeterConfirmation(userProfile.getElecAccount());

	}
	 @Test(groups = { SubmitMeterRead,Regression })
	public void submitImPlausibleElecMeter() {
		Report.createTestLogHeader("Submit Meter Read.", "Implaussible Electricity Meter");

		UserProfile userProfile = new TestDataHelper()
		        .getUserProfile("ElectricityAccount");

		 getCustomerDetailsToUserProfileOAM(userProfile);
		userProfile.setAccNumber(userProfile.getElecAccount());
		new SMRAction().resetMeterRead(userProfile.getAccNumber());
		new HomePageAction().navigateToLogin().login(userProfile)
		        .navigateToAccountSummaryPage(userProfile).navigateToSMRPage()
		        .setImPlausbileReading(userProfile.getAccNumber())
		        .confirmAccountSelection().submitImplaussibleMeterRead()
		        .verifyMeterConfirmation(userProfile.getAccNumber());
		new RunQTP().runQTP("sample.vbs", userProfile.getAccNumber());

	}

	@Test(groups = { SubmitMeterRead,Smoke })
	//Yet to make Sap Validations
	public void submitPlausibleGasMeter() {
		Report.createTestLogHeader("Submit Meter Read.", "Plausible Gas Meter");
		

		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");

		userProfile.setAccNumber(userProfile.getGasAccount());
		
		getCustomerDetailsToUserProfileOAM(userProfile);

		new SMRAction().resetMeterRead(userProfile.getGasAccount());
		new HomePageAction().navigateToLogin().login(userProfile)
		        .navigateToAccountSummaryPage(userProfile).navigateToSMRPage()
		        .setPlausbileReading(userProfile.getGasAccount())
		        .confirmAccountSelection()		        
		        .verifyMeterConfirmation(userProfile.getGasAccount());

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
		        .verifyMeterConfirmation(userProfile.getGasAccount());

	}
}
