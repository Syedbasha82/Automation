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

public class LandlordTest extends TestBase{

	@Test(groups = {FunctionalCategory.Eshop})
	public void landLordJourneyForAnonymousCustomer(){
		Report.createTestLogHeader("LandLord Quote", "For Anonymous Journey");
		final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("NationalAcquisition");
		
		new repairAndCoverAction("Anonymous","yes","Annual","sameAddr")
	    .navigateToLandlordLandingPage()
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
	public void  landLordJourneyForLoggedInEnergyCustomer(){
		Report.createTestLogHeader("LandLord Quote", "For Energy customer Journey with different Address");
		final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("NationalAcquisition");
		
		new HomePageAction()
		.navigateToLogin()
		.loginDetails(userProfile);
		new repairAndCoverAction("LoggedIn","no","Monthly","diffAddr")
	    .navigateToLandlordLandingPage()
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
	
	@Test(groups = {FunctionalCategory.Eshop})
	public void verifylandLordPricingForLondon(){
		Report.createTestLogHeader("LandLord Quote", "Pricing verification for London");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("LondonAcquisition");
		
		new repairAndCoverAction("Anonymous","yes","Monthly","sameAddr")
		.navigateToLandlordLandingPage()
		.verifyLandlordPriceValues(acquisition);
		
	}
	
	@Test(groups = {FunctionalCategory.Eshop})
	public void verifylandLordJourneyPricingForNational(){
		Report.createTestLogHeader("LandLord Quote", "Pricing verification for National");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("NationalAcquisition");
		
		new repairAndCoverAction("Anonymous","yes","Monthly","sameAddr")
		.navigateToLandlordLandingPage()
		.verifyLandlordPriceValues(acquisition);
		
	}
}
