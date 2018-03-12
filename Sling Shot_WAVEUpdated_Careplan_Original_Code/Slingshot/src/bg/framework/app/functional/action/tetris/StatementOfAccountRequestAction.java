/**
 * 
 */
package bg.framework.app.functional.action.tetris;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.tetris.CopyBillRequestPage;
import bg.framework.app.functional.page.tetris.LargeBusinessElectricityCallBackPage;
import bg.framework.app.functional.page.tetris.StatementOfAccountPage;

/**
 * @author 292238
 *
 */
public class StatementOfAccountRequestAction {
	public StatementOfAccountRequestAction openStatementOfAccountPage(UserProfile userProfile){
		StatementOfAccountPage copyBillRequestPage = new StatementOfAccountPage();
		copyBillRequestPage.openStatementRequestPage();
		return this;	
	}
	public StatementOfAccountRequestAction verifyAndEntervalues(UserProfile userProfile){
		StatementOfAccountPage copyBillRequestPage = new StatementOfAccountPage();
		copyBillRequestPage.entervalidData(userProfile);
		copyBillRequestPage.clickSubmitButton();
		return this;	
	}
	public StatementOfAccountRequestAction verifyThankYouPage(UserProfile userProfile){
		StatementOfAccountPage copyBillRequestPage = new StatementOfAccountPage();
		copyBillRequestPage.verifyThankYouPage();
		return this;	
	}
	public StatementOfAccountRequestAction verifyDBDetails(UserProfile userProfile){
		StatementOfAccountPage copyBillRequestPage = new StatementOfAccountPage();
		copyBillRequestPage.verifyLeadTable(userProfile);
		return this;	
	}
	public StatementOfAccountRequestAction verifyAddAnotherAccount(UserProfile userProfile){
		StatementOfAccountPage statementRequestPage = new StatementOfAccountPage();
		statementRequestPage.entervalidData(userProfile);
		statementRequestPage.verifyAddAnotherAccount();
		statementRequestPage.verifyRequestedBill();
		statementRequestPage.entervalidData(userProfile);
		statementRequestPage.verifyAddAnotherAccount();
		statementRequestPage.verifyRequestedBill();
		return this;	
	}
}
