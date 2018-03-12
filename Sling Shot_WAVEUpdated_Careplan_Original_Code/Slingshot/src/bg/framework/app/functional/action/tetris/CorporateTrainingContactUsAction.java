/**
 * 
 */
package bg.framework.app.functional.action.tetris;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.tetris.CorporateCallback_GasElecPage;
import bg.framework.app.functional.page.tetris.CorporateTrainingContactUs;

/**
 * @author 292238
 *
 */
public class CorporateTrainingContactUsAction {
	
	public CorporateTrainingContactUsAction verifyTrainingContactUsAction(UserProfile userProfile){ 
	CorporateTrainingContactUs contactUsPage = new CorporateTrainingContactUs();
	contactUsPage.openCorparateContactUspage();
	return this;
	}
	public CorporateTrainingContactUsAction entervalidData(UserProfile userProfile){ 
		CorporateTrainingContactUs contactUsPage = new CorporateTrainingContactUs();
		contactUsPage.entervalidData(userProfile);
		return this;
	}
	public CorporateTrainingContactUsAction verifyThankYouPage(){ 
		CorporateTrainingContactUs contactUsPage = new CorporateTrainingContactUs();
		contactUsPage.verifyThankYouPage();
		return this;
	}
	public CorporateTrainingContactUsAction verifyLeadTable(UserProfile userProfile){ 
		CorporateTrainingContactUs contactUsPage = new CorporateTrainingContactUs();
		contactUsPage.verifyLeadTable(userProfile);
		return this;
	}
	public CorporateTrainingContactUsAction validateFields(UserProfile userProfile){
		CorporateTrainingContactUs contactUsPage = new CorporateTrainingContactUs();
		contactUsPage.validateFieldsInTrainingContactUs(userProfile);
		return this;
	}
}
