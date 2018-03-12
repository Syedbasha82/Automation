package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.PPMatePage;

public class PPMateAction {

	public PPMateAction cardStorageFunctionality(){
		PPMatePage ppMate = new PPMatePage();
		ppMate.cardStorageFunctionality();
		return new PPMateAction();
	}
	public PPMateAction navigateToAccountSummaryPage(UserProfile userProfile){
		PPMatePage ppMate = new PPMatePage();
		ppMate.navigateToAccountSummaryPage(userProfile);
		return new PPMateAction();
	}
	
	public PPMateAction deleteCardFunctionality(){
		PPMatePage ppMate = new PPMatePage();
		ppMate.deleteCardFunctionality();
		return new PPMateAction();
	}
	
	public PPMateAction navigateToTopupPage(){
		PPMatePage ppMate = new PPMatePage();
		ppMate.navigateToTopupPage();
		return new PPMateAction();
	}
	public PPMateAction VerifyAddPaymentCard(){
		PPMatePage ppMate = new PPMatePage();
		ppMate.AddPaymentCard();
		return new PPMateAction();
	}
	public PPMateAction VerifyEnterTopupamount(){
		PPMatePage ppMate = new PPMatePage();
		ppMate.EnterTopupamount();
		return new PPMateAction();
	}
	
	public PPMateAction topAndPayPageDetails(){
		PPMatePage ppMate = new PPMatePage();
		ppMate.topAndPayPageDetails();
		return new PPMateAction();
	}
	public PPMateAction verifyReviewAndConfirmPage(){
		PPMatePage ppMate = new PPMatePage();
		ppMate.verifyReviewAndConfirmPage();
		return new PPMateAction();
	}
	public PPMateAction updateCustomerDetails(UserProfile userProfile){
		PPMatePage ppMate = new PPMatePage();
		ppMate.updateCustomerDetails(userProfile);
		return new PPMateAction();
	}
	public PPMateAction AddPaymentcardFunctionality(){
		PPMatePage ppMate = new PPMatePage();
		ppMate.AddPaymentcardFunctionality();
		return new PPMateAction();
	}
	public PPMateAction VerifynavigateToUpdateDetailsPage(){
		PPMatePage ppMate = new PPMatePage();
		ppMate.navigateToUpdateDetailsPage();
		return new PPMateAction();
	}
	public PPMateAction VerifyMeterreadfrequency(){
		PPMatePage ppMate = new PPMatePage();
		ppMate.Meterreadfrequency();
		return new PPMateAction();
	}
	public PPMateAction VerifyfrequecyMetercontent(){
		PPMatePage ppMate = new PPMatePage();
		ppMate.contentVerification();
		return new PPMateAction();
	}
	public PPMateAction navigateToManagePaymentCardsPage(){
		PPMatePage ppMate = new PPMatePage();
		ppMate.navigateToManagePaymentCardsPage();
		return new PPMateAction();
	}
	public PPMateAction updateDetailsPage(){
		PPMatePage ppMate = new PPMatePage();
		ppMate.navigateToManagePaymentCardsPage();
		return new PPMateAction();
	}
}
