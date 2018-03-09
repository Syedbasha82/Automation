package bg.framework.app.functional.test.sales;


import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.action.sales.GasApplianceCoverAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.GasApplianceCover;


import static bg.framework.app.functional.entities.FunctionalCategory.*;

public class GasApplianceCoverTest {
	
	@Test(groups = {Acquisition,Regression})
	public void GasApplianceCoverJourney2Extras(){
		
           Report.createTestLogHeader("GasApplianceCover", "Gas Appliance Cover Add Any 2 Extras Journey");
           //GasApplianceCover GasAppliance = new TestDataHelper().getallGasApplianceCover("GasAppliance");
           final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
           new GasApplianceCoverAction()
                              .navigateToGasApplianceCoverPage()
                              .navigateToWhatareYourContactDetailsSection()
                              .navigateToAddAny2ExtrasSection()
                              .navigateTo2ApplianceSection()
                              .verifyEditLink()
                              .verifyOrderNowPage()
                              .verifyContactDetailsSection()
                              .verifyNectarPointsSection()
                              .verifyEnterYourAddressSection()
                              .verifyEnterPaymentDetails()
                              .verifyTermsAndConditions()
                              .verifyThankYouPage();
   		
		
	}

	@Test(groups = {Acquisition,Regression})
	public void GasApplianceCoverJourney6Extras(){
		
           Report.createTestLogHeader("GasApplianceCover", "Gas Appliance Cover Add Any 6 Extras Journey");
           //GasApplianceCover GasAppliance = new TestDataHelper().getallGasApplianceCover("GasAppliance");
           final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
           new GasApplianceCoverAction()
                              .navigateToGasApplianceCoverPage()
                              .navigateToWhatareYourContactDetailsSection()
                              .navigateToAddAny6ExtrasSection()
                              .navigateTo6ApplianceSection()
                              .verifyEditLink()
                              .verifyOrderNowPage()
                              .verifyContactDetailsSection()
                              .verifyNectarPointsSection()
                              .verifyEnterYourAddressSection()
                              .verifyEnterPaymentDetails()
                              .verifyTermsAndConditions()
                              .verifyThankYouPage();
   		
		
	}

	@Test(groups = {Acquisition,Regression})
	public void GasApplianceCoverJourney(){
		
           Report.createTestLogHeader("GasApplianceCover", "Gas Appliance Cover Without Extras Journey");
           //GasApplianceCover GasAppliance = new TestDataHelper().getallGasApplianceCover("GasAppliance");
           final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
           new GasApplianceCoverAction()
                              .navigateToGasApplianceCoverPage()
                              .navigateToWhatareYourContactDetailsSection()
                              .selectNone()
                              .navigateToApplianceSection()
                              .verifyEditLink()
                              .verifyOrderNowPage()
                              .verifyContactDetailsSection()
                              .verifyNectarPointsSection()
                              .verifyEnterYourAddressSection()
                              .verifyEnterPaymentDetails()
                              .verifyTermsAndConditions()
                              .verifyThankYouPage();
   		
		
	}

}
