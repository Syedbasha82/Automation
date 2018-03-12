package bg.framework.app.functional.test.reFactoring;

import static bg.framework.app.functional.entities.FunctionalCategory.BGBRegistration;
import static bg.framework.app.functional.entities.FunctionalCategory.Slingshot;
import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.reFactoring.SECompareEnergyTariffAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.entities.Slinshot.CompareTariff;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class SECompareEnergyTariffTest extends TestBase {
	
	@SuppressWarnings("unchecked")
    @Test(groups ={Slingshot,Smoke,BGBRegistration})
	public void VerifySECompareTariffPricing_AnonymousJourney() throws Exception {
		Report.createTestLogHeader("SE Compare Tariff Verification", "Anonymous Sign Up");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GetAquote");
		try {
			for (String x : FuelTariffList()) {
				CompareTariff CompareTariff = new TestDataHelper().getCompareTariffProfile(x);
				Report.updateTestLog(" ***************** Tariff : " + x  + " ***************** ", "PASS");
	
    	new SECompareEnergyTariffAction()
		.navigateToSEcompareTariffPage()
		.enterPostCodeNew(CompareTariff)
		.VerifyFuelStatus(CompareTariff);
    }
		Report.updateTestLog("*******************Tariff Verification Completed  **********************" , "Pass");
	
		}
    catch (Exception e) {
		e.printStackTrace();
	}
		
			}
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			private String[] FuelTariffList(){

				String [] FuelList ={
						
						"G Price Promise August 2019  1",
						"G Price Promise August 2019  2",
						"G Price Promise August 2019  3",
						"G Price Promise August 2019  4",
						"G Price Promise August 2019  5",
						"G Price Promise August 2019  6",
						"G Price Promise August 2019  7",
						"G Price Promise August 2019  8",
						"G Price Promise August 2019  9",
						"G Price Promise August 2019  10",
						"G Price Promise August 2019  11",
						"G Price Promise August 2019  12",
						"G Price Promise August 2019  13",
						"G Price Promise August 2019  14",
						"G Price Promise August 2019  15",
						"G Price Promise August 2019  16",
						"G Price Promise August 2019  17",
						"G Price Promise August 2019  18",
						"G Price Promise August 2019  19",
						"G Price Promise August 2019  20",
						"G Price Promise August 2019  21",
						"G Price Promise August 2019  22",
						"G Price Promise August 2019  23",
						"G Price Promise August 2019  24",
						"G Price Promise August 2019  25",
						"G Price Promise August 2019  26",
						"G Price Promise August 2019  27",
						"G Price Promise August 2019  28",
						"E Price Promise August 2019  1",
						"E Price Promise August 2019  2",
						"E Price Promise August 2019  3",
						"E Price Promise August 2019  4",
						"E Price Promise August 2019  5",
						"E Price Promise August 2019  6",
						"E Price Promise August 2019  7",
						"E Price Promise August 2019  8",
						"E Price Promise August 2019  9",
						"E Price Promise August 2019  10",
						"E Price Promise August 2019  11",
						"E Price Promise August 2019  12",
						"E Price Promise August 2019  13",
						"E Price Promise August 2019  14",
						"E Price Promise August 2019  15",
						"E Price Promise August 2019  16",
						"E Price Promise August 2019  17",
						"E Price Promise August 2019  18",
						"E Price Promise August 2019  19",
						"E Price Promise August 2019  20",
						"E Price Promise August 2019  21",
						"E Price Promise August 2019  22",
						"E Price Promise August 2019  23",
						"E Price Promise August 2019  24",
						"E Price Promise August 2019  25",
						"E Price Promise August 2019  26",
						"E Price Promise August 2019  27",
						"E Price Promise August 2019  28"
						
										};
				return FuelList;
				}
			
			
}