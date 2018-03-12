/**
 * 
 */
package bg.framework.app.functional.test.tetris;

import static bg.framework.app.functional.entities.FunctionalCategory.Slingshot;
import static bg.framework.app.functional.entities.FunctionalCategory.Tetris;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.tetris.CopyBillRequestAction;
import bg.framework.app.functional.action.tetris.CorporateCallbackAction;
import bg.framework.app.functional.action.tetris.LargeBusinessElectricityCallBackAction;
import bg.framework.app.functional.action.tetris.MarketingConsentAction;
import bg.framework.app.functional.action.tetris.MeterReadRemainderAction;
import bg.framework.app.functional.action.tetris.StatementOfAccountRequestAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

/**
 * @author 292238
 *
 */
public class MeterReadRemainderTest extends TestBase{
	@Test(groups={Tetris})	
	public void verifyMeterReadRemainderJourney() throws Exception{
		Report.createTestLogHeader("Meter read remainder request","Verifies functionality of meter read remainder request page");		
		UserProfile userProfile= new TestDataHelper().getUserProfile("tetris-contactUs");
		new MeterReadRemainderAction().openMeterReadRemainderPage(userProfile)
		.verifyAndEntervalues(userProfile)
		.verifyThankYouPage(userProfile)
		.verifyDBDetails(userProfile);
	}
	@Test(groups = {Slingshot})
	public void validateCallBackOverlayFields() {
		Report.createTestLogHeader("Meter read remainder request", "Validates all the fields from Meter read remainder request page");
		UserProfile userProfile = new TestDataHelper().getUserProfile("tetris-contactUs");
		
		new MeterReadRemainderAction().openMeterReadRemainderPage(userProfile)
		.validateFirstnameFields(userProfile);
	
}
}
