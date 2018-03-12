package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.AccountOverviewPage;
import bg.framework.app.functional.page.reFactoring.PBFlagPage;



public class PBFlagAction {
	private UserProfile userProfile;
	public PBFlagAction(UserProfile userProfile) {
		this.userProfile=userProfile;
	}
	
	public PBFlagAction paperLessBillingAction(){
		final PBFlagPage pbFlag=new PBFlagPage(userProfile);
		pbFlag.clickCheckBox();
		pbFlag.clickContinueButton();
		pbFlag.verifyPaperlessBillingSuccess();
		return this;
	}
	public PBFlagAction paperLessNectorCardLater(){
		final PBFlagPage pbFlag=new PBFlagPage(userProfile);
		pbFlag.clickCheckBox();
		pbFlag.clickNectorLater();
		pbFlag.clickTermsAndCondotion();
		pbFlag.clickContinueButton();
		pbFlag.verifyPaperlessBillingSuccess();
		return this;
	}
	
	public PBFlagAction paperLessNoThanks(){
		final PBFlagPage pbFlag=new PBFlagPage(userProfile);
		pbFlag.clickCheckBox();
		pbFlag.clickNoThanks();		
		pbFlag.clickContinueButton();
		pbFlag.verifyPaperlessBillingSuccess();
		return this;
	}
	
	public PBFlagAction paperLessSignUp(){
		final PBFlagPage pbFlag=new PBFlagPage(userProfile);
		pbFlag.clickCheckBox();
		pbFlag.clickSignUp();
		pbFlag.clickTermsAndCondotion();
		pbFlag.clickContinueButton();
		pbFlag.verifyPaperlessBillingSuccess();
		return this;
	}
	public PBFlagAction paperLessAddNector(){
		final PBFlagPage pbFlag=new PBFlagPage(userProfile);
		pbFlag.clickCheckBox();
		pbFlag.clickCardNumber();
		pbFlag.enterNectorCardNumber();
		pbFlag.clickTermsAndCondotion();
		pbFlag.clickContinueButton();
		pbFlag.verifyPaperlessBillingSuccess();
		return this;
	}
	public PBFlagAction verifyAddress(){
		AccountOverviewPage accountOverviewPage=new AccountOverviewPage();
		accountOverviewPage.verifyCustomerAddress(userProfile.getAccNumber());
		return this;
	}
	
	public void logout(){
		new AccountOverviewPage().logout();
	}

}
