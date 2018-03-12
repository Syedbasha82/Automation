/**
 * 
 */
package bg.framework.app.functional.test.Slingshot_Broker;

import static bg.framework.app.functional.entities.FunctionalCategory.CsaAgent;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import static bg.framework.app.functional.entities.FunctionalCategory.Slingshot;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.Slingshot.CustomerServiceAgentAction;
import bg.framework.app.functional.action.Slingshot_Broker.PartnerServiceAgentAction;
import bg.framework.app.functional.action.Slingshot_Broker.RegistrationAction;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.CrmUserProfile;
import bg.framework.app.functional.entities.SMRAccountDetails;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
/**
 * @author 208070
 *
 */
public class PartnerServiceAgentTest extends TestBase{
	
		//TS_Agent_01_E2E -- To verify whether the Partner service agent is able to register a Broker through Partner service agent journey
		//TS_Agent_03 -- To verify whether the broker registered through CSA  is able to log in via broker partner portal
		//TS_Agent_18 -- To verify whether Register user page is displayed when clicking Register user link in Partner service agent page
		@Test(groups ={Slingshot,Regression,CsaAgent})	
		public void verifyPartnerServiceAgentRegisterUser() throws Exception {
			Report.createTestLogHeader("PSA Journey", "To verify whether the Partner service agent is able to register a Broker through Partner service agent journey");
			UserProfile userProfile = new TestDataHelper().getUserProfile("PSABroker");
			CrmUserProfile crmuserProfile = new TestDataHelper().getCrmUserProfile("SlingshotCrmDetails"); 
			new PartnerServiceAgentAction()
			.navigateToPSARegistration()
			.clickRegisteraUser(userProfile);
			/*new SapCrmAction()
			 .loginDetails(crmuserProfile)
			 .searchByAccountId(crmuserProfile, userProfile);*/
			new RegistrationAction()
			.openEncryptURL(userProfile)
			.fillRegistrationDetails(userProfile)
			.verifyThankYouPage()
			.clickLoginLink()
			.verifyAuditEntry(userProfile)
			.verifyEmailIdInDb(userProfile);
			}
			
		
		//TS_Agent_02_E2E -- To verify whether the Partner service agent is able to look up a Broker through "Partner service agent" journey
		//TS_Agent_08 -- To verify the link "Find user" link navigates to the "Update user details" page when entering Email address or Contact person BP number in "Look up user" page
		//TS_Agent_09 -- To verify the details of the particular logged in broker is prepopulated in the "Update user details" page
		@Test(groups ={Slingshot,Regression,CsaAgent})	
		public void verifyPartnerServiceAgentLookUpUser() throws Exception {
			Report.createTestLogHeader("CSA", "To verify updated user details page through Look up user navigation");
			UserProfile userProfile = new TestDataHelper().getUserProfile("PSABroker");
				//deregisterinBgbonline(userProfile);  
				//Register a user 
				/*new PartnerServiceAgentAction()
				.navigateToPSARegistration()
				.clickRegisteraUser(userProfile);
				new RegistrationAction()
				.openEncryptURL(userProfile)
				.fillRegistrationDetails(userProfile)
				.verifyThankYouPage()
				.clickLoginLink()
				.verifyAuditEntry(userProfile)
				.verifyEmailIdInDb(userProfile);
				//verify Lookup User functionality
*/				new PartnerServiceAgentAction()
					.navigateToPSARegistration()
					.verifyFindUser(userProfile)
					.verifyUpdateUserDetailsPage()
					.verifyUserAccountInformation(userProfile);		
					}
		
		//TS_Agent_10_E2E -- To verify whether the account status of broker is successfully changed by agent
		@Test(groups ={Slingshot,Regression,CsaAgent})	
		public void verifyPartnerServiceAgentLookUpUserFunctionality() throws Exception {
			Report.createTestLogHeader("CSA", "To verify whether the account status of broker is successfully changed by agent");
			UserProfile userProfile = new TestDataHelper().getUserProfile("PSABroker");
				/*deregisterinBgbonline(userProfile);  
				//Register a user 
				new PartnerServiceAgentAction()
				.navigateToPSARegistration()
				.clickRegisteraUser(userProfile);*/
				
				//verify Lookup User functionality
				new PartnerServiceAgentAction()
					.navigateToPSARegistration()
					.verifyFindUser(userProfile)
					.updateAndVerifyStatus(userProfile);
		}	
		
		//TS_Agent_27 -- To verify whether the "no search results"page is displayed for the following a)search field empty b)no results for the particular search term
				@Test(groups ={Slingshot,Regression,CsaAgent})	
				public void verifyAuditTrailSearch() throws Exception {
					Report.createTestLogHeader("CSA Journey", "To verify the Password Reset functionality");
					UserProfile userProfile = new TestDataHelper().getUserProfile("PSABroker");
					//deregisterinBgbonline(userProfile);  
					//Register a user 
					/*new PartnerServiceAgentAction()
					.navigateToPSARegistration()
					.clickRegisteraUser(userProfile);
					new RegistrationAction()
					.openEncryptURL(userProfile)
					.fillRegistrationDetails(userProfile)
					.verifyThankYouPage()
					.clickLoginLink()
					.verifyAuditEntry(userProfile)
					.verifyEmailIdInDb(userProfile);*/
					new PartnerServiceAgentAction()
					.navigateToPSARegistration()
					.verifyAuditTrail(userProfile);
				 
				} 
				//TS_Broker_Agent_17_E2E -- To verify whether the reset password link has been sent to the broker and "reset password" process (E2E) flow is checked in the update user details page.
				@Test(groups ={Slingshot,Regression,CsaAgent})	
				public void verifyPasswordResetLink() throws Exception {
					Report.createTestLogHeader("CSA Journey", "To verify the Password Reset functionality");
					UserProfile userProfile = new TestDataHelper().getUserProfile("PSABroker");
					//deregisterinBgbonline(userProfile); 
					//Register a user 
					/*new PartnerServiceAgentAction()
					.navigateToPSARegistration()
					.clickRegisteraUser(userProfile);
					new SapCrmAction()
					 .loginDetails(crmuserProfile)
					 .searchByAccountId(crmuserProfile, userProfile);
					new RegistrationAction()
					.openEncryptURL(userProfile)
					.fillRegistrationDetails(userProfile)
					.verifyThankYouPage()
					.clickLoginLink()
					.verifyAuditEntry(userProfile)
					.verifyEmailIdInDb(userProfile);*/
					//verify Lookup User functionality
					new PartnerServiceAgentAction()
					.navigateToPSARegistration()
					.verifyFindUser(userProfile)
					.verifyPasswordLink(userProfile);	        
				}
				//TS_Broker_Agent_47_E2E -- To verify whether the Partner service agent is able to do view bill journey by impersonating the partner and check the E2E flow
				@Test(groups ={Slingshot,Regression,CsaAgent})	
				public void verifyImpersonateUserLink() throws Exception {
					Report.createTestLogHeader("CSA Journey", "To verify the Password Reset functionality");
					UserProfile userProfile = new TestDataHelper().getUserProfile("PSABroker");
					SMRAccountDetails smrProfile = new TestDataHelper().getAllSMRUserProfile("ViewBillPartner");
					//deregisterinBgbonline(userProfile); 
					//Register a user 
					/*new PartnerServiceAgentAction()
					.navigateToPSARegistration()
					.clickRegisteraUser(userProfile);
					new SapCrmAction()
					 .loginDetails(crmuserProfile)
					 .searchByAccountId(crmuserProfile, userProfile);
					new RegistrationAction()
					.openEncryptURL(userProfile)
					.fillRegistrationDetails(userProfile)
					.verifyThankYouPage()
					.clickLoginLink()
					.verifyAuditEntry(userProfile)
					.verifyEmailIdInDb(userProfile);*/
					//verify Lookup User functionality
					new PartnerServiceAgentAction()
					.navigateToPSARegistration()
					.verifyFindUser(userProfile)
					.verifyImpersonateLink(smrProfile);	        
				}
		
				
}

	
