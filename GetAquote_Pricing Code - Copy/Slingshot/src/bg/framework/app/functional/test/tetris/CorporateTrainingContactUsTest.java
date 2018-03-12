/**
 * 
 */
package bg.framework.app.functional.test.tetris;

import static bg.framework.app.functional.entities.FunctionalCategory.Slingshot;
import static bg.framework.app.functional.entities.FunctionalCategory.Tetris;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.tetris.CorporateCallbackAction;
import bg.framework.app.functional.action.tetris.CorporateTrainingContactUsAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

/**
 * @author 292238
 *
 */
public class CorporateTrainingContactUsTest extends TestBase{
	@Test(groups={Tetris})	
	public void corporateTrainingContactUsJourney() throws Exception{
		Report.createTestLogHeader("Corporate training contact us","Verifies functionality of corporate training contact us page");		
		UserProfile userProfile= new TestDataHelper().getUserProfile("tetris-contactUs");
		new CorporateTrainingContactUsAction()
		.verifyTrainingContactUsAction(userProfile)
		.entervalidData(userProfile)
		.verifyThankYouPage()
		.verifyLeadTable(userProfile);
	}
	@Test(groups = {Slingshot})
	public void validateFieldsInTraingContactUs() {
		Report.createTestLogHeader("Corporate training contact us","Verifies the field validation in corporate training contact us page");
		UserProfile userProfile = new TestDataHelper().getUserProfile("tetris-contactUs");
		new CorporateTrainingContactUsAction()
		.verifyTrainingContactUsAction(userProfile)
		.validateFields(userProfile);
	
}
}
