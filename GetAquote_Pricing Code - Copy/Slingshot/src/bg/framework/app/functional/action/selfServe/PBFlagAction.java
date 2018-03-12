package bg.framework.app.functional.action.selfServe;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.selfServe.AccountOverviewPage;
import bg.framework.app.functional.page.selfServe.AccountSummaryPage;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.page.selfServe.PBFlagPage;



public class PBFlagAction {
	private UserProfile userProfile;
	public PBFlagAction(UserProfile userProfile) {
		this.userProfile=userProfile;
	}
	
	public AccountOverviewAction paperLessBillingAction(){
		final PBFlagPage pbFlag=new PBFlagPage(userProfile);
		pbFlag.clickCheckBox();
		pbFlag.clickContinueButton();
		pbFlag.verifyPaperlessBillingSuccess();
		return new AccountOverviewAction();
	}
	
//	public PBFlagAction verifyAddress(){
//		AccountOverviewPage accountOverviewPage=new AccountOverviewPage();
//		accountOverviewPage.verifyCustomerAddress(userProfile, userProfile.getAccNumber());
//		return this;
//	}

}
