/**
 * 
 */
package bg.framework.app.functional.action.tetris;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.tetris.DirectDebitSetupPage;
import bg.framework.app.functional.page.tetris.MarketingConsentPage;

/**
 * @author 292238
 *
 */
public class DirectDebitSetupAction {
	public DirectDebitSetupAction openDirectDebitSetupPage(UserProfile userProfile){
		DirectDebitSetupPage directDebitPage = new DirectDebitSetupPage();
		directDebitPage.openDirectDebitSetupPage();
		return this;	
	}
	public DirectDebitSetupAction verifyAndEntervalues(UserProfile userProfile){
		DirectDebitSetupPage directDebitPage = new DirectDebitSetupPage();
		directDebitPage.entervalidData(userProfile);
		return this;	
	}
	public DirectDebitSetupAction verifyThankYouPage(UserProfile userProfile){
		DirectDebitSetupPage directDebitPage = new DirectDebitSetupPage();
		directDebitPage.verifyThankYouPage();
		return this;	
	}
	public DirectDebitSetupAction verifyDBDetails(UserProfile userProfile){
		DirectDebitSetupPage directDebitPage = new DirectDebitSetupPage();
		directDebitPage.verifyLeadTable(userProfile);
		return this;	
	}
}
