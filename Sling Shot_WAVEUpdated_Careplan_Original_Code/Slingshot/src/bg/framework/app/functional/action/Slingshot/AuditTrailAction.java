/**
 * 
 */
package bg.framework.app.functional.action.Slingshot;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.Slingshot.AuditTrailPage;

/**
 * @author sundarg1
 *
 */
public class AuditTrailAction {

	public AuditTrailAction verifyAuditDetailsUsingEmail(UserProfile userProfile){
		AuditTrailPage auditDetailsPage = new AuditTrailPage();
		auditDetailsPage.verifyAuditTrailDetailsEmail(userProfile);
		return this;
	}
	public AuditTrailAction emailErrorMessageValidation(){
		AuditTrailPage auditDetailsPage = new AuditTrailPage();
		auditDetailsPage.emailErrorMessageValidation();
		return this;
	}

	public AuditTrailAction verifyAuditTable(String email){
		AuditTrailPage auditDetailsPage = new AuditTrailPage();
		auditDetailsPage.verifyAuditTableUsingEmail(email);
		return this;
	}
	public AuditTrailAction openViewAuditTrailURl(){
		AuditTrailPage auditDetailsPage = new AuditTrailPage();
		auditDetailsPage.openViewAuditTrailPage();		
		return this;	
	}
	public AuditTrailAction verifyAuditDetailsUsingBpOrgNumber(UserProfile userProfile){
		AuditTrailPage auditDetailsPage = new AuditTrailPage();
		auditDetailsPage.verifyAuditTrailDetailsBpOrg(userProfile);
		return this;
	}

	public AuditTrailAction verifyDateRangeValue(UserProfile userProfile){
		AuditTrailPage auditDetailsPage = new AuditTrailPage();
		auditDetailsPage.verifyDateRangeValue(userProfile);
		return this;
	}
	public AuditTrailAction verifyAuditTableForBP(String BpNumber){
		AuditTrailPage auditDetailsPage = new AuditTrailPage();
		auditDetailsPage.verifyAuditTableUsingBpOrg(BpNumber);
		return this;
	}
	public AuditTrailAction verifyFutureDateSelection(){
		AuditTrailPage auditDetailsPage = new AuditTrailPage();
		auditDetailsPage.checkForFutureDateSelection();
		return this;
	}
	public AuditTrailAction bpnumberErrorMessageValidation(){
		AuditTrailPage auditDetailsPage = new AuditTrailPage();
		auditDetailsPage.bpnumberErrorMessageValidation();
		return this;
	}
}
