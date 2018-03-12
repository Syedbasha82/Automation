package bg.framework.app.functional.action.services;

import bg.framework.app.functional.entities.LandLord;
import bg.framework.app.functional.page.services.AccountSummaryPage;

public class AccountSummaryAction {

	
	public void bookAppointmentAction(){
		final AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
		accountSummaryPage.clickBookAppointment();
		accountSummaryPage.firstStepAppointment();
		accountSummaryPage.secondStepEng();
		accountSummaryPage.thirdStepEng();
		accountSummaryPage.annualBookingSucess();
		
	}
	
	public void bookEngAppointmentAction(LandLord landLord){
		final AccountSummaryPage accountSummaryPage=new AccountSummaryPage(landLord);
		accountSummaryPage.clickEngBookAppointment();
		accountSummaryPage.firstStepEng();
		accountSummaryPage.secondStepEng();
		accountSummaryPage.thirdStepEng();
		accountSummaryPage.engAppointmentsuccess();
	}
	
	public void upCellHC300Action(){
		final AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
		accountSummaryPage.clickUpCellHC300();
	}
	
	public void upCellHC200Action(){
		final AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
		accountSummaryPage.clickUpCellHC200();
	}
	public void upCellHC400Action(){
		final AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
		accountSummaryPage.clickUpCellHC400();
	}
	
	public void viewDairyAction(){
		final AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
		accountSummaryPage.verifyViewDairyLinks();
		accountSummaryPage.clickViewDairy();
		accountSummaryPage.verifyViewDairy();
	}
}
