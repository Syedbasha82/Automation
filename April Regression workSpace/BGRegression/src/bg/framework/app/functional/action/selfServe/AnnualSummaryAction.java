package bg.framework.app.functional.action.selfServe;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.selfServe.AnnualSummaryPage;


public class AnnualSummaryAction {

	public AnnualSummaryAction navigateToAnnualSummaryPage() {
		AnnualSummaryPage AnnualSummaryPage=new AnnualSummaryPage();
		AnnualSummaryPage.navigateToAnnualSummaryPage();
		return new AnnualSummaryAction ();
	}
	public AnnualSummaryAction verifyAnnualSummarypage() {
		AnnualSummaryPage AnnualSummaryPage=new AnnualSummaryPage();
		AnnualSummaryPage.verifyAnnualSummarypage();
		return new AnnualSummaryAction ();
	}
	public AnnualSummaryAction annualSummaryVerification(String AccountType) {
		AnnualSummaryPage AnnualSummaryPage=new AnnualSummaryPage();
		AnnualSummaryPage.annualSumaryVerification(AccountType);
		return new AnnualSummaryAction ();
	}
	public AnnualSummaryAction navigateToBillHistory (){
		AnnualSummaryPage AnnualSummaryPage=new AnnualSummaryPage();
		AnnualSummaryPage.navigateToBillHistory ();
		return new AnnualSummaryAction ();
	}
	public AnnualSummaryAction navigateToAnnualSummaryThroughDeepLink (){
		AnnualSummaryPage AnnualSummaryPage=new AnnualSummaryPage();
		AnnualSummaryPage.navigateToAnnualSummaryThroughDeepLink ();
		return new AnnualSummaryAction ();
	}
	
	public AnnualSummaryAction clickViewPDFLink (UserProfile userprofile){
		AnnualSummaryPage AnnualSummaryPage=new AnnualSummaryPage();
		AnnualSummaryPage.clickViewPDFLink (userprofile);
		return new AnnualSummaryAction ();
	}
	}
	

