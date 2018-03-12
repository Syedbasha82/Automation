/**
 * 
 */
package bg.framework.app.functional.test.tetris;

import static bg.framework.app.functional.entities.FunctionalCategory.Tetris;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.tetris.CopyBillRequestAction;
import bg.framework.app.functional.action.tetris.LargeBusinessElectricityCallBackAction;
import bg.framework.app.functional.action.tetris.MarketingConsentAction;
import bg.framework.app.functional.action.tetris.StatementOfAccountRequestAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

/**
 * @author 292238
 *
 */
public class StatementOfAccountTest extends TestBase{
	@Test(groups={Tetris})	
	public void verifyStatementOfAccount() throws Exception{
		Report.createTestLogHeader("Statement of account request","Verifies functionality of Statement of account request page");		
		UserProfile userProfile= new TestDataHelper().getUserProfile("tetris-contactUs");
		new StatementOfAccountRequestAction().openStatementOfAccountPage(userProfile)
		.verifyAndEntervalues(userProfile)
		.verifyThankYouPage(userProfile)
		.verifyDBDetails(userProfile);
	}
	@Test(groups={Tetris})	
	public void verifyAddAnotherAccountInSOA() throws Exception{
		Report.createTestLogHeader("Statement of account request","Verifies add another functionality of Statement of account request page");		
		UserProfile userProfile= new TestDataHelper().getUserProfile("tetris-contactUs");
		new StatementOfAccountRequestAction().openStatementOfAccountPage(userProfile)
		.verifyAddAnotherAccount(userProfile)
		.verifyAndEntervalues(userProfile)
		.verifyThankYouPage(userProfile)
		.verifyDBDetails(userProfile);
	}
}
