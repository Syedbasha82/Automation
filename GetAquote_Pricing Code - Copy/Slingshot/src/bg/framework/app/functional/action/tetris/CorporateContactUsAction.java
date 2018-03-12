package bg.framework.app.functional.action.tetris;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.tetris.CorporateContactUsPage;

public class CorporateContactUsAction {
	
public CorporateContactUsAction openCorparateContactUspage(UserProfile userProfile){
	CorporateContactUsPage contactUsPage = new CorporateContactUsPage();
	contactUsPage.openCorparateContactUspage();
	contactUsPage.entervalidData(userProfile);
	contactUsPage.verifyLeadTable(userProfile);
	return this;	
}

}
