package bg.framework.app.functional.action.selfServe;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.selfServe.ChangeBillRewritePage;


public class ChangeBillRewriteAction {

	public  ChangeBillRewriteAction changeDate(UserProfile userprofile){
		new ChangeBillRewritePage().changeDate(userprofile);
		return this;
	}
	
	public  ChangeBillRewriteAction dateVerification(UserProfile userProfile){
		new ChangeBillRewritePage().dateVerification(userProfile);
		return this;
	}
}
