package bg.framework.app.functional.test.sales;


import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.action.sales.KitchenApplianceCoverAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.KitchenApplianceCover;


import static bg.framework.app.functional.entities.FunctionalCategory.*;


public class KitchenApplianceCoverTest extends TestBase {
	
	@Test(groups = {Acquisition,Regression})
	public void KitchenApplianceCoverJourney2Extras(){
		
           Report.createTestLogHeader("KitchenApplianceCover", "Kitchen Appliance Cover Journey");
           //KitchenApplianceCover kitchenAppliance = new TestDataHelper().getallKitchenApplianceCover("KitchenAppliance");
           final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
           
		new KitchenApplianceCoverAction()
		
                              .navigateToKitchenApplianceCoverPage()
                              .navigateToWhatareYourContactDetailsSection()
                              .navigateToAddAny2ExtrasSection()
                              .navigateTo2ApplianceSection()
                              .verifyEditLink()
                              .verifyOrderNowPagefor5Appliances()
                              .verifyContactDetailsSection()
                              .verifyNectarPointsSection()
                              .verifyEnterYourAddressSection()
                              .verifyEnterPaymentDetails()
                              .verifyTermsAndConditions()
                              .verifyThankYouPage();
   		
		
	}

	@Test(groups = {Acquisition,Regression})
	public void KitchenApplianceCoverJourney6Extras(){
		
           Report.createTestLogHeader("KitchenApplianceCover", "Kitchen Appliance Cover Journey");
           //KitchenApplianceCover kitchenAppliance = new TestDataHelper().getallKitchenApplianceCover("KitchenAppliance");
           final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
           new KitchenApplianceCoverAction()
                              .navigateToKitchenApplianceCoverPage()
                              .navigateToWhatareYourContactDetailsSection()
                              .navigateToAddAny6ExtrasSection()
                              .navigateTo6ApplianceSection()
                              .verifyEditLink()
                              .verifyOrderNowPagefor9Appliances()
                              .verifyContactDetailsSection()
                              .verifyNectarPointsSection()
                              .verifyEnterYourAddressSection()
                              .verifyEnterPaymentDetails()
                              .verifyTermsAndConditions()
                              .verifyThankYouPage();
   		
		
	}

	@Test(groups = {Acquisition,Regression})
	public void KitchenApplianceCoverJourney(){
		
           Report.createTestLogHeader("KitchenApplianceCover", "Kitchen Appliance Cover Journey");
           //KitchenApplianceCover kitchenAppliance = new TestDataHelper().getallKitchenApplianceCover("KitchenAppliance");
           final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
           new KitchenApplianceCoverAction()
                              .navigateToKitchenApplianceCoverPage()
                              .navigateToWhatareYourContactDetailsSection()
                              .selectNone()
                              .navigateToApplianceSection()
                              .verifyEditLink()
                              .verifyOrderNowPagefor3Appliances()
                              .verifyContactDetailsSection()
                              .verifyNectarPointsSection()
                              .verifyEnterYourAddressSection()
                              .verifyEnterPaymentDetails()
                              .verifyTermsAndConditions()
                              .verifyThankYouPage();
   		
		
	}
}
