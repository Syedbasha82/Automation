/**
 * 
 */
package bg.framework.app.functional.test.tetris;

import static bg.framework.app.functional.entities.FunctionalCategory.Tetris;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.tetris.CorporateContactUsAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

/**
 * @author 292238
 *
 */
public class CorporateContactUsTest extends TestBase{
	@Test(groups={Tetris})	
	public void corporateContactUsJourney() throws Exception{
		Report.createTestLogHeader("Corporate contact us","To verify the corporate contact us page");		
		UserProfile userProfile= new TestDataHelper().getUserProfile("tetris-contactUs");
		new CorporateContactUsAction().openCorparateContactUspage(userProfile);
	}

}
