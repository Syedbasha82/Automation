package bg.framework.app.functional.test.reFactoring;

import bg.framework.app.functional.test.common.TestBase;

import static bg.framework.app.functional.entities.FunctionalCategory.BGBRegistration;
import static bg.framework.app.functional.entities.FunctionalCategory.Slingshot;
import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;
import static bg.framework.app.functional.entities.FunctionalCategory.TariffList;
import bg.framework.app.functional.entities.Slinshot.CompareTariff;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.action.reFactoring.SETariffInformationAction;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.entities.Slinshot.TariffList;
import org.testng.annotations.Test;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.FunctionalCategory;

public class SETariffInformationTest extends TestBase {
	
	@SuppressWarnings("unchecked")
    @Test(groups ={Slingshot,Smoke,BGBRegistration})
	public void VerifySETariffPricing_AnonymousJourney() throws Exception {
	
	Report.createTestLogHeader("Tariff Verification", "Anonymous Sign Up");
	UserProfile userProfile = new TestDataHelper().getUserProfile("GetAquote");
	try {
		for (String x : FuelTariffList()) {
			CompareTariff CompareTariff = new TestDataHelper().getCompareTariffProfile(x);
			Report.updateTestLog(" ***************** Tariff : " + x  + " ***************** ", "PASS");


	new SETariffInformationAction()
	.navigateToSETariffInformationPage()
	.enterPostCodeNew(CompareTariff)
	.SelectTariff(CompareTariff)
	.SelectPaymentType(CompareTariff)
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
					
					/*"G Price Freeze November 2018  1",
					"G Price Freeze November 2018  2",
					"G Price Freeze November 2018  3",
					"G Price Freeze November 2018  4",
					"G Price Freeze November 2018  5",
					"G Price Freeze November 2018  6",
					"G Price Freeze November 2018  7",
					"G Price Freeze November 2018  8",
					"G Price Freeze November 2018  9",
					"G Price Freeze November 2018  10",
					"G Price Freeze November 2018  11",
					"G Price Freeze November 2018  12",
					"G Price Freeze November 2018  13",
					"G Price Freeze November 2018  14",
					"G Price Freeze November 2018  15",
					"G Price Freeze November 2018  16",
					"G Price Freeze November 2018  17",
					"G Price Freeze November 2018  18",
					"G Price Freeze November 2018  19",
					"G Price Freeze November 2018  20",
					"G Price Freeze November 2018  21",
					"G Price Freeze November 2018  22",
					"G Price Freeze November 2018  23",
					"G Price Freeze November 2018  24",
					"G Price Freeze November 2018  25",
					"G Price Freeze November 2018  26",
					"G Price Freeze November 2018  27",
					"G Price Freeze November 2018  28",
					"E Price Freeze November 2018  1",
					"E Price Freeze November 2018  2",
					"E Price Freeze November 2018  3",
					"E Price Freeze November 2018  4",
					"E Price Freeze November 2018  5",
					"E Price Freeze November 2018  6",
					"E Price Freeze November 2018  7",
					"E Price Freeze November 2018  8",
					"E Price Freeze November 2018  9",
					"E Price Freeze November 2018  10",
					"E Price Freeze November 2018  11",
					"E Price Freeze November 2018  12",
					"E Price Freeze November 2018  13",
					"E Price Freeze November 2018  14",
					"E Price Freeze November 2018  15",
					"E Price Freeze November 2018  16",
					"E Price Freeze November 2018  17",
					"E Price Freeze November 2018  18",
					"E Price Freeze November 2018  19",
					"E Price Freeze November 2018  20",
					"E Price Freeze November 2018  21",
					"E Price Freeze November 2018  22",
					"E Price Freeze November 2018  23",
					"E Price Freeze November 2018  24",
					"E Price Freeze November 2018  25",
					"E Price Freeze November 2018  26",
					"E Price Freeze November 2018  27",
					"E Price Freeze November 2018  28"*/

					"E Price Freeze November 2018  26"
					
			};
			return FuelList;
			}
	

}
