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

public class HECTest extends TestBase{


	/**************************************************************************
    Created By          : Vishnu Prasad
    Created Date        : 25-4-2014
    Test Case ID        : 06_HEC_Anony_Post Code,07_HEC_Logged_Energy_CAPTCHA,13_HEC_logged_enrgy_onlyoneappoinment
    ,14_HEC_annony_onlyoneappoinment, 17_HEC_logged_energy_addressprepopulate, 10_HEC_logged_enrgy_firstavailableslot,
    18_HEC_anony_addressprepopulate_multiple, 35_HEC_anony_payment modes, 36_HEC_anony_energy_payment modes,38_HEC_anony_diffwaystopay
    ,39_HEC_anony_paymentdets_validation,53_HEC_Anony_SuccessfullAppointment
    Short Description   : WTP Tube Map
	 ***************************************************************************/

	@Test(groups = {FunctionalCategory.Eshop})
	public void HECAnonymousJourney(){
		Report.createTestLogHeader("HEC", "Anonymous Sign Up");		
		final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("NationalAcquisition");
		String CustType="Anonymous";
		String Boilertype="yes";
		String PaymentType="Monthly"; 
		String Address="sameAddr";
		new repairAndCoverAction(CustType,Boilertype,PaymentType,Address)
		.navigateToHECLandingPage()
		.enterPostCode(acquisition)
		.selectFirstAppointment()
		.verifyRepairAndCoverPage()
		.navigateToOrderNowPage()
		.enteringContactDetails(userProfile,acquisition)
		.paymentForFixedPriceRepair(acquisition)
		.paymentForMonthlyCover(acquisition)
		.enteringTermsAndConditions(userProfile)
		.verifyThankYouPage()
		.anonymousRegistration(userProfile)
		.verifyAnonymousRegis()
		.anonymousAudit(userProfile);
		new HomePageAction()
		.logout();


		//.clickLoginThanYouPage()
	}


	@Test(groups = {FunctionalCategory.Eshop})
	public void HECAnonymousAnnualPayment(){
		Report.createTestLogHeader("HEC", "Anonymous Sign Up Annual Payment National Post code");		
		final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("NationalAcquisition");
		String CustType="Anonymous";
		String Boilertype="yes";
		String PaymentType="Annual";
		String Address="sameAddr";
		new repairAndCoverAction(CustType,Boilertype,PaymentType,Address)
		.navigateToHECLandingPage()
		.enterPostCode(acquisition)
		.selectFirstAppointment()
		.verifyRepairAndCoverPage()
		.navigateToOrderNowPage()
		.enteringContactDetails(userProfile,acquisition)	
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

	/**************************************************************************
    Created By          : Vishnu Prasad
    Created Date        : 25-4-2014
    Test Case ID        : 09_HEC_logged_Service_highpriorityslots,
    Short Description   : WTP Tube Map
	 ***************************************************************************/


	@Test(groups = {FunctionalCategory.Eshop})
	public void HECAnonymousViewAllAppntmnts(){
		Report.createTestLogHeader("HEC", "Anonymous View All appointments Sign Up");		
		final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
		final Acquisition acquisition = new TestDataHelper()
		.getAcquisitionData("NationalAcquisition");
		String CustType="Anonymous";
		String Boilertype="yes";
		String PaymentType="Monthly";
		String Address="sameAddr";
		new repairAndCoverAction(CustType,Boilertype,PaymentType,Address)
		.navigateToHECLandingPage()
		.enterPostCode(acquisition)
		.verifyAndSelectAppointmentSlot()
		.verifyRepairAndCoverPage()
		.navigateToOrderNowPage()
		.enteringContactDetails(userProfile,acquisition)	
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

	/**************************************************************************
    		Created By          : Vishnu Prasad
    		Created Date        : 25-4-2014
    		Test Case ID        : 09_HEC_logged_Service_highpriorityslots,
    		Short Description   : WTP Tube Map
	 **************************************************************************/
	@Test(groups = {FunctionalCategory.Eshop})
	public void validateAddressPostCode(){
		Report.createTestLogHeader("HEC", "Anonymous Sign Up");		
		final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
		final Acquisition acquisition = new TestDataHelper()
		.getAcquisitionData("NationalAcquisition");
		String CustType="Anonymous";
		String Boilertype="yes";
		String PaymentType="Monthly";
		String Address="sameAddr";
		new repairAndCoverAction(CustType,Boilertype,PaymentType,Address)
		.navigateToHECLandingPage()
		.validateAddressPostCode(userProfile);
	}

	/**************************************************************************
	Created By          : Vishnu Prasad
	Created Date        : 25-4-2014
	Test Case ID        : 09_HEC_logged_Service_highpriorityslots,
	Short Description   : WTP Tube Map
	 **************************************************************************/
	@Test(groups = {FunctionalCategory.Eshop})
	public void validateNoAppointment(){
		Report.createTestLogHeader("HEC", "Validate No Appointment Flow");		
		final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser1");
		final Acquisition acquisition = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		String CustType="Anonymous";
		String Boilertype="yes";
		String PaymentType="Monthly";
		String Address="sameAddr";
		new repairAndCoverAction(CustType,Boilertype,PaymentType,Address)
		.navigateToHECLandingPage()
		.validateNoAppointment(userProfile);

	}

	/**************************************************************************
		Created By          : Vishnu Prasad
		Created Date        : 25-4-2014
		Test Case ID        : 22_HEC_anony_re-enteraddressmanually
		Short Description   : Address Change
	 **************************************************************************/
	@Test(groups = {FunctionalCategory.Eshop})
	public void changeAddress(){
		Report.createTestLogHeader("HEC", "Anonymous Sign Up");		
		final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
		final Acquisition acquisition = new TestDataHelper()
		.getAcquisitionData("NationalAcquisition");
		String CustType="Anonymous";
		String Boilertype="yes";
		String PaymentType="Monthly";
		String Address="sameAddr";
		new repairAndCoverAction()
		.navigateToHECLandingPage()
		.inputPostCode(acquisition, userProfile)
		.changeAddress()
		.inputPostCode(acquisition, userProfile)
		.verifyAddressChange();

	}



	//changeAddress
	/**************************************************************************
			Created By          : Hemasundar
			Created Date        : 08-05-2014
			Test Case ID        : 14_HEC_annony_onlyoneappoinment,10_HEC_logged_enrgy_firstavailableslot,20_HEC_logged_energy_selectfromlist
			,26_HEC_logged_energy_newcontract_nationalpo,52_HEC_logged_energy_Terms&Cond
			Short Description   : Logged in Journey
	 **************************************************************************/
	@Test(groups = {FunctionalCategory.Eshop})
	public void loggedInFlow(){
		Report.createTestLogHeader("HEC", "Logged In flow National post code");		
		final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("NationalAcquisition");
		String CustType="LoggedIn";
		String Boilertype="yes";
		String PaymentType="Monthly";
		String Address="sameAddr";
		new HomePageAction().navigateToLogin().login(userProfile);
		new repairAndCoverAction(CustType,Boilertype,PaymentType,Address)
		.navigateToHECLandingPage()
		.enterPostCode(acquisition)
		.selectFirstAppointment()
		.verifyRepairAndCoverPage()
		.navigateToOrderNowPage()
		.enteringContactDetails(userProfile,acquisition)	
		.paymentForFixedPriceRepair(acquisition)
		.paymentForMonthlyCover(acquisition)
		.enteringTermsAndConditions(userProfile)
		.verifyThankYouPage()
		.anonymousAudit(userProfile)
		.loginVerification();
		new HomePageAction()
		.logout();

	}

	/**************************************************************************
			Created By          : Hemasundar
			Created Date        : 08-05-2014
			Test Case ID        : 27_HEC_logged_energy_newcontract_londonpo
			Short Description   : Logged in Journey
	 **************************************************************************/
	@Test(groups = {FunctionalCategory.Eshop})
	public void loggedInLondonPostCode(){
		Report.createTestLogHeader("HEC", "Logged In flow check whether the customer does not have active services");		
		final UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousElecAccount");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("LondonAcquisition");
		String CustType="LoggedIn";
		String Boilertype="yes";
		String PaymentType="Monthly";
		String Address="sameAddr";
		new HomePageAction().navigateToLogin().login(userProfile);
		new repairAndCoverAction(CustType,Boilertype,PaymentType,Address)
		.navigateToHECLandingPage()
		.enterPostCode(acquisition)
		.selectFirstAppointment()
		.verifyRepairAndCoverPage()
		.navigateToOrderNowPage()
		.enteringContactDetails(userProfile,acquisition)	
		.paymentForFixedPriceRepair(acquisition)
		.paymentForMonthlyCover(acquisition)
		.enteringTermsAndConditions(userProfile)
		.verifyThankYouPage()
		.anonymousAudit(userProfile)
		.loginVerification();
		new HomePageAction()
		.logout();

	}



	/**************************************************************************
		    Created By          : Vishnu Prasad
		    Created Date        : 25-4-2014
		    Test Case ID        : 06_HEC_Anony_Post Code,07_HEC_Logged_Energy_CAPTCHA,13_HEC_logged_enrgy_onlyoneappoinment
		    ,14_HEC_annony_onlyoneappoinment, 17_HEC_logged_energy_addressprepopulate, 10_HEC_logged_enrgy_firstavailableslot,
		    18_HEC_anony_addressprepopulate_multiple, 35_HEC_anony_payment modes, 36_HEC_anony_energy_payment modes,38_HEC_anony_diffwaystopay
		    ,39_HEC_anony_paymentdets_validation,53_HEC_Anony_SuccessfullAppointment
		    Short Description   : WTP Tube Map
	 ***************************************************************************/

	@Test(groups = {FunctionalCategory.Eshop})
	public void HECAnonymousEdit(){
		Report.createTestLogHeader("HEC", "Anonymous Sign Up");		
		final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
		final Acquisition acquisition = new TestDataHelper()
		.getAcquisitionData("LondonAcquisition");
		String CustType="Anonymous";
		String Boilertype="yes";
		String PaymentType="Monthly";
		String Address="sameAddr";
		new repairAndCoverAction(CustType,Boilertype,PaymentType,Address)
		.navigateToHECLandingPage()
		.enterPostCode(acquisition)
		.selectFirstAppointment()
		.verifyRepairAndCoverPage()
		.navigateToOrderNowPage()
		.enteringContactDetails(userProfile,acquisition)	
		.paymentForFixedPriceRepair(acquisition)
		.paymentForMonthlyCover(acquisition)
		.enteringTermsAndConditions(userProfile)
		.verifyThankYouPage();
	}
	

}
