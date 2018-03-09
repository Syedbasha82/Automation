package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.selfServe.AccountSummaryAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.ViewBillPage;
import bg.framework.app.functional.page.selfServe.AccountOverviewPage;
import bg.framework.app.functional.page.selfServe.AccountSummaryPage;


public class ViewBillAction {

	public ViewBillAction clickSeeYourStatementLink(){
		ViewBillPage viewbillpage=new ViewBillPage();
		viewbillpage.clickSeeYourStatementLink();
		return new ViewBillAction();
	}


	public ViewBillAction navigateToBillHistory(){
		ViewBillPage viewbillpage=new ViewBillPage();
		viewbillpage.navigateToBillHistory();
		return new ViewBillAction();
	}

	public ViewBillAction verifyAndViewBills() {
		ViewBillPage viewDifferentBill=new ViewBillPage();
		viewDifferentBill.verifyAndViewBills();
		return new ViewBillAction();
	}

	public ViewBillAction viewDifferentStatements(){
		ViewBillPage viewDifferentBill=new ViewBillPage();
		viewDifferentBill.viewDifferentStatements();
		return this;
	}	

	public ViewBillAction logout(){
		ViewBillPage viewbillpage = new ViewBillPage();
		viewbillpage.logout();
		return this;

	}


	public void navigateToDeeplink(UserProfile userProfile){
		ViewBillPage viewbillpage = new ViewBillPage();
		viewbillpage.navigateToDeeplink(userProfile);
		return;
	}
	public ViewBillAction verifyViewBillPage(){
		ViewBillPage viewbillpage = new ViewBillPage();
		viewbillpage.verifyViewBillPage();
		return new ViewBillAction();
	}



	public ViewBillAction viewbillfordual() {
		ViewBillPage viewbillfordual=new ViewBillPage();
		viewbillfordual.viewbillfordual();
		return new ViewBillAction();
	}


	public ViewBillAction navigatetoElectricity() {
		ViewBillPage viewbillfordual=new ViewBillPage();
		viewbillfordual.navigatetoElectricity();
		return new ViewBillAction();
	}

	/*-------------------------------------------------------------SMB PHASE 2-------------------------------------------------------------------------------------- */

	public ViewBillAction clickViewLatestBill() {
		ViewBillPage VBPage=new ViewBillPage();
		VBPage.clickViewLatestBill();
		return this;
	}
	
	
	public ViewBillAction verifySMBPromotionalMsgVBill() {
		ViewBillPage VBPage=new ViewBillPage();
		VBPage.verifySMBPromotionalMsgVBill();
		return this;
	}


	
	
}
