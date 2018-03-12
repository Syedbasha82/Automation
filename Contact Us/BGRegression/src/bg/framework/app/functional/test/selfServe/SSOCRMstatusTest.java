package bg.framework.app.functional.test.selfServe;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.selfServe.SSOCRMstatusAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;
import static bg.framework.app.functional.entities.FunctionalCategory.*;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;


public class SSOCRMstatusTest extends TestBase{
	private static final String UNCHECKED = "unchecked";
	
	//Data - single SSO OAM CRM customer, SSO staus - Acquisition rejected 
	 	@SuppressWarnings(UNCHECKED)
	    @Test(groups = {BGRRegistration})
	    public void verifySSOAcquisitionRejected() throws Exception {
	        Report.createTestLogHeader("SSO CRM Status", "To Verify OAM SSO Acquisition rejected status");
	        UserProfile userProfile = new TestDataHelper().getUserProfile("SSOAcquisitionRejectedAccount");
	        new HomePageAction()
	        	.navigateToLogin()
	        	.login(userProfile)
	        	.navigateToAccountSummaryPage(userProfile);
	        new SSOCRMstatusAction()
	        	.verifySSOAcquisitionRejection().logout();
    
	 }
	 	
	 	////Data - single SSO OAM CRM customer, SSO staus - Sale Lost
	 	@SuppressWarnings(UNCHECKED)
	    @Test(groups = {BGRRegistration})
	    public void verifySSOSaleLost() throws Exception {
	 		  Report.createTestLogHeader("SSO CRM Status", "To Verify OAM SSO Sale Lost customer");
		      UserProfile userProfile = new TestDataHelper().getUserProfile("SSOSalesLostAccount");
		      new HomePageAction()
	        	.navigateToLogin()
	        	.login(userProfile);
		      new SSOCRMstatusAction()
		      	.loginSSOErrorValidation()
		      	.logout();
	 	}
	 	
	 	 
	 	//Data - single SSO OAM CRM customer, SSO staus -  Meter Read Window Open 
		 	@SuppressWarnings(UNCHECKED)
		    @Test(groups = {BGRRegistration})
		    public void verifySSOMeterReadOpen() throws Exception {
		        Report.createTestLogHeader("SSO CRM Status", "To Verify OAM SSO Meter Read Open");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("SSOMeterReadOpenAccount");
		        new HomePageAction()
		        	.navigateToLogin()
		        	.login(userProfile)
		        	.navigateToAccountSummaryPage(userProfile);
		        new SSOCRMstatusAction()
		        	.verifySSOMeterReadOpen()
		        	.logout();
	    
		 }
		 	
		 	
		 	//Data - single SSO OAM CRM customer, SSO staus -  Pending Security Deposit 
		 	@SuppressWarnings(UNCHECKED)
		    @Test(groups = {BGRRegistration})
		    public void verifySSOPendingSecurityDeposit() throws Exception {
		        Report.createTestLogHeader("SSO CRM Status", "To Verify OAM SSO Pending Security Deposit");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("SSOPendingSecurityDepositAccount");
		        new HomePageAction()
		        	.navigateToLogin()
		        	.login(userProfile)
		        	.navigateToAccountSummaryPage(userProfile);
		        new SSOCRMstatusAction()
		        	.verifySSOPendingSecurityDeposit()
		        	.logout();
	    
		 }
		 	
		 	 
		 	//Data - single SSO OAM CRM customer, SSO staus -  Acquisition Sent 
			 	@SuppressWarnings(UNCHECKED)
			    @Test(groups = {BGRRegistration})
			    public void verifySSOAcquisitionSent() throws Exception {
			        Report.createTestLogHeader("SSO CRM Status", "To Verify OAM SSO Acquisition sent");
			        UserProfile userProfile = new TestDataHelper().getUserProfile("SSOAcquisitionSentAccount");
			        new HomePageAction()
			        	.navigateToLogin()
			        	.login(userProfile)
			        	.navigateToAccountSummaryPage(userProfile);
			        new SSOCRMstatusAction()
			        	.verifySSOAcquisitionSent()
			        	.logout();
		    
			 }
			 	
			 	
			//Data - single SSO OAM CRM customer, SSO staus -  Objection Raised 
		 	@SuppressWarnings(UNCHECKED)
		    @Test(groups = {BGRRegistration})
		    public void verifySSOObjectionRaised() throws Exception {
		        Report.createTestLogHeader("SSO CRM Status", "To Verify OAM SSO Objection Raised");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("SSOObjectionRaisedAccount");
		        new HomePageAction()
		        	.navigateToLogin()
		        	.login(userProfile)
		        	.navigateToAccountSummaryPage(userProfile);
		        new SSOCRMstatusAction()
		        	.verifySSOObjectionRaised()
		        	.logout();
	    
		 }
		 	
		 	
		 	//Data - single SSO OAM CRM customer, SSO staus -  Objection Window Open 
		 	@SuppressWarnings(UNCHECKED)
		    @Test(groups = {BGRRegistration})
		    public void verifySSOObjectionwindowOpen() throws Exception {
		        Report.createTestLogHeader("SSO CRM Status", "To Verify OAM SSO Objection Window Open");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("SSOObjectionWindowOpenAccount");
		        new HomePageAction()
		        	.navigateToLogin()
		        	.login(userProfile)
		        	.navigateToAccountSummaryPage(userProfile);
		        new SSOCRMstatusAction()
		        	.verifySSOObjectionwindowOpen()
		        	.logout();
	    
		 }
		 	
		 	//Data - single SSO OAM CRM customer, SSO staus -  Pending Cool-Off 
		 	@SuppressWarnings(UNCHECKED)
		    @Test(groups = {BGRRegistration})
		    public void verifySSOPendingCooloff() throws Exception {
		        Report.createTestLogHeader("SSO CRM Status", "To Verify OAM SSO Pending Cool-Off");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("SSOPendingCooloffAccount");
		        new HomePageAction()
		        	.navigateToLogin()
		        	.login(userProfile)
		        	.navigateToAccountSummaryPage(userProfile);
		        new SSOCRMstatusAction()
		        	.verifySSOPendingCooloff()
		        	.logout();
		        
		        
		 }
		 
			//Data - single SSO OAM CRM customer, SSO staus -	Submitted 
		 	@SuppressWarnings(UNCHECKED)
		    @Test(groups = {BGRRegistration})
		    public void verifySSOSubmitted() throws Exception {
		        Report.createTestLogHeader("SSO CRM Status", "To Verify OAM SSO Submitted contract");
		        UserProfile userProfile = new TestDataHelper().getUserProfile("SSOSubmittedAccount");
		        new HomePageAction()
		        	.navigateToLogin()
		        	.login(userProfile)
		        	.navigateToAccountSummaryPage(userProfile);
		        new SSOCRMstatusAction()
		        	.verifySSOSubmitted()
		        	.logout();
		        			
		 }
		 	

		 	

}
