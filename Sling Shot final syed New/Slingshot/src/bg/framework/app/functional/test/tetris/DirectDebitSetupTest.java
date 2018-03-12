/**
 * 
 */
package bg.framework.app.functional.test.tetris;

import static bg.framework.app.functional.entities.FunctionalCategory.Tetris;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.tetris.DirectDebitSetupAction;
import bg.framework.app.functional.action.tetris.MarketingConsentAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

/**
 * @author 292238
 *
 */
public class DirectDebitSetupTest extends TestBase{
	@Test(groups={Tetris})	
	public void verifyDirectDebitTest() throws Exception{
		Report.createTestLogHeader("Direct debit setup","Verifies functionality of Direct debit setup page");		
		UserProfile userProfile= new TestDataHelper().getUserProfile("tetris-contactUs");
		new DirectDebitSetupAction().openDirectDebitSetupPage(userProfile)
		.verifyAndEntervalues(userProfile)
		.verifyThankYouPage(userProfile)
		.verifyDBDetails(userProfile);
	}
}
