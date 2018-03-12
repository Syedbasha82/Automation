/**
 * 
 */
package bg.framework.app.functional.test.Slingshot;

import static bg.framework.app.functional.entities.FunctionalCategory.Slingshot;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import static bg.framework.app.functional.entities.FunctionalCategory.AuditTrial;
import org.testng.annotations.Test;

import bg.framework.app.functional.action.Slingshot.AuditTrailAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

/**
 * @author sundarg1
 *
 */
public class AuditTrialTest extends TestBase{

	@Test(groups ={Slingshot,Regression,AuditTrial})	
	public void verifyAuditDetailsUsingEmailLogin() throws Exception {
		Report.createTestLogHeader("Audit Trail Journey", "Verifies whether audit entry is made in audit details page while login with email");
		UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");
		new AuditTrailAction()
		.openViewAuditTrailURl()
		.verifyAuditDetailsUsingEmail(userProfile)
		.verifyAuditTable(userProfile.getEmail());
		;
	}
	@Test(groups ={Slingshot,Regression,AuditTrial})
	public void emailErrorMessageValidation(){
		Report.createTestLogHeader("Audit Trail Journey", "Validates the Email field error message in Audit trail page");
		new AuditTrailAction()
		.openViewAuditTrailURl()
		.emailErrorMessageValidation();		
	}
	@Test(groups ={Slingshot,Regression,AuditTrial})
	public void verifyAuditDetailsUsingBpOrgNumber() throws Exception {
		Report.createTestLogHeader("Audit Trail Journey", "Verifies whether audit entry is made in audit details page while login with Bp Org Number");
		UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");
		new AuditTrailAction()
		.openViewAuditTrailURl()
		.verifyAuditDetailsUsingBpOrgNumber(userProfile)
		.verifyAuditTableForBP(userProfile.getBpnumber());
		;
	}
	@Test(groups ={Slingshot,Regression,AuditTrial})
	public void verifyDateRangeSelection() throws Exception {
		Report.createTestLogHeader("Audit Trail Journey", "Verifies whether customer able to select date range morethan three months");
		UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");
		new AuditTrailAction()
		.openViewAuditTrailURl()
		.verifyDateRangeValue(userProfile)
		.verifyAuditTable(userProfile.getEmail());
		;
	}
	@Test(groups ={Slingshot,Regression,AuditTrial})
	public void verifyFutureDateSelection() throws Exception {
		Report.createTestLogHeader("Audit Trail Journey", "Verifies whether user not able to select future date in date picker");
		new AuditTrailAction()
		.openViewAuditTrailURl()
		.verifyFutureDateSelection();
		;
	}
	@Test(groups ={Slingshot,Regression,AuditTrial})
	public void bpnumberErrorMessageValidation(){
		Report.createTestLogHeader("Audit Trail Journey", "Validates the Bp Number field error message in Audit trail page");
		new AuditTrailAction()
		.openViewAuditTrailURl()
		.bpnumberErrorMessageValidation();		
	}
}
