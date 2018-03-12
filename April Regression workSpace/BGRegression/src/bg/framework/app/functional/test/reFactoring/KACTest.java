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

public class KACTest extends TestBase{

	@Test(groups = {FunctionalCategory.Eshop})
	public void verifyKACQuoteForAnonymousCustomer(){
		Report.createTestLogHeader("KAC Quote", "Anonymous Journey with same billing address through Monthly payment");
		final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("NationalAcquisition");
		
		new repairAndCoverAction("Anonymous","yes","Monthly","sameAddr")
	    .navigateToKACLandingPage()
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
	public void verifyKACQuoteForLoggedInGasCustomer(){
		Report.createTestLogHeader("KAC Quote", "For Energy customer Journey with different billing address through annual payment");
		final UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("LondonAcquisition");
		
		new HomePageAction()
		.navigateToLogin()
		.loginDetails(userProfile);
		new repairAndCoverAction("LoggedIn","no","Annual","diffAddr")
	    .navigateToKACLandingPage()
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
	public void verifyKACPricingForLondon(){
		Report.createTestLogHeader("KAC Quote", "Pricing verification for London Region");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("LondonAcquisition");
	
		new repairAndCoverAction("Anonymous","yes","Monthly","sameAddr")
		.navigateToKACLandingPage()
		.verifyKACPriceValues(acquisition);
		
	}
	
	@Test(groups = {FunctionalCategory.Eshop})
	public void verifyKACPricingForNational(){
		Report.createTestLogHeader("KAC Quote", "Pricing verification for National Region");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("NationalAcquisition");
				
		new repairAndCoverAction("Anonymous","yes","Monthly","sameAddr")
		.navigateToKACLandingPage()
		.verifyKACPriceValues(acquisition);
		
	}
	
}
