package bg.framework.app.functional.test.reFactoring;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.reFactoring.repairAndCoverAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.FunctionalCategory;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class BoilerTest extends TestBase{


	@Test(groups = {FunctionalCategory.Eshop})
	public void boilerRepairAndCoverAnonymousJourney(){
		Report.createTestLogHeader("Boiler Test", "Anonymous Sign Up with same billing address through Monthly payment");	
		final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("NationalAcquisition");
		new repairAndCoverAction("Anonymous","yes","Monthly","sameAddr")
		.navigateToBoilerLandingPage()
		.enterPostCode(acquisition)
		.verifyAndSelectAppointmentSlot()
		.verifyRepairAndCoverPage()
		.navigateToOrderNowPage()
		.enteringContactDetails(userProfile,acquisition)
		.selectingBoilerType()
		.paymentForFixedPriceRepair(acquisition)
		.paymentForMonthlyCover(acquisition)
		.enteringTermsAndConditions(userProfile)
		.verifyThankYouPage()
		.anonymousRegistration(userProfile)
	    .verifyAnonymousRegis()
	    .anonymousAudit(userProfile);
		new HomePageAction()
		.logout();

	}

	@Test(groups = {FunctionalCategory.Eshop})
	public void boilerRepairAndCoverLoggedInGasJourney(){
		Report.createTestLogHeader("Boiler Test", "Logged In Sign Up with different address through Annual payment- london postcode");	
		final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("LondonAcquisition");
		new HomePageAction()	                
		.navigateToLogin()
		.login(userProfile);
		new repairAndCoverAction("LoggedIn","yes","Annual","diffAddr")
		.navigateToBoilerLandingPage()
		.enterPostCode(acquisition)
		.verifyAndSelectAppointmentSlot()
		.verifyRepairAndCoverPage()
		.navigateToOrderNowPage()
		.enteringContactDetails(userProfile,acquisition)
		.selectingBoilerType()
		.paymentForFixedPriceRepair(acquisition)
		.paymentForMonthlyCover(acquisition)
		.enteringTermsAndConditions(userProfile)
		.verifyThankYouPage()
	    .anonymousAudit(userProfile)
	    .loginVerification();
		new HomePageAction()
		.logout();

	}

	/*@Test(groups = {FunctionalCategory.Eshop})
	public void verifyAddressChange(){
		Report.createTestLogHeader("Boiler Test", "Address Change");	
		final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		new repairAndCoverAction("Anonymous","yes","Monthly","sameAddr")
		.navigateToBoilerLandingPage()
		.inputPostCode(AddressNo, userProfile)
		.changeAddress()
		.inputPostCode(AddressNo, userProfile)
		.verifyAddressChange();

	}*/

}

