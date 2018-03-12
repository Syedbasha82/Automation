package bg.framework.app.functional.test.Slingshot_Broker;

import static bg.framework.app.functional.entities.FunctionalCategory.Login;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import static bg.framework.app.functional.entities.FunctionalCategory.Slingshot;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.Slingshot_Broker.LoginAndPasswordAction;
import bg.framework.app.functional.action.Slingshot.ForgotttenPasswordAction;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class LoginAndPasswordTest extends TestBase{
	
//TS_Login&Password Mgmt_01_E2E  To verify whether the user is able to login by giving valid credentials and check the following for level 1 broker	a)Audit entry in DB
//TS_Login&Password Mgmt_14  	 To verify whether the user is able to login by giving valid username and password
//TS_Login&Password Mgmt_46      To verify whether audit entries is made in Online database for the following	a)Login	
	
	@Test(groups = { Regression,Slingshot})
	public void validatethelogincredentials() {		
		Report.createTestLogHeader("Login Verification","To verify whether the user is able to login by giving valid credentials and check db and audit entry");
		UserProfile userProfile = new TestDataHelper().getUserProfile("Loginandpassword");
					new LoginAndPasswordAction()
					.BgbloginUser(userProfile)		
					.loginpasswordlandingpagetitle()
					.verifyLoginTimeStamp(userProfile)
					.verifyAuditDetailsInDb(userProfile) //  have to update the Audit id
					.logout();
	}
	
//TS_Login&Password Mgmt_04 To verify whether the last email address is prefilled in the email address field when "Remember my email" was checked previously

	@Test(groups = { Regression,Slingshot})
	public void loginRemembermyEmail() {
		Report.createTestLogHeader("Login Verification","Check Remember email and verify the prepopulated email");
		UserProfile userProfile = new TestDataHelper().getUserProfile("Loginandpassword");
			new LoginAndPasswordAction()
				.BgbloginUser_remembermails(userProfile)
				.logout()
				.VerifyPrePopulateEmailorPass(userProfile)
				.BgbloginUser_password(userProfile)
				.logout();
	}
//TS_Login&Password Mgmt_09 To verify whether the link navigations of the british gas partner portal login page for the following a)Breadcrumb
	
	@SuppressWarnings("unchecked")
	@Test(groups = { Regression,Slingshot})		
	public void verifyloginandpasswordbreadcrumb() {
		Report.createTestLogHeader("Login Journey","Verifies whether user is able to login to application from the Password Reset confirmation page  of Forgotten password journey");
		UserProfile userProfile = new TestDataHelper().getUserProfile("Loginandpassword");
			new LoginAndPasswordAction()
				.BgbnavigateToLoginPage() 
				.verifyAndClickForgottenPasswordLink()
				.loginpasswordlandingpagebreadcrumb()
				.RHNnavigation()
				.enterEmail(userProfile);				
	}	
	
//TS_Login&Password Mgmt_12 - To verify whether the error message is displayed for the broker whose status is freeze in DB and trying to Login to Broker portal. Include in recent sheet
		@Test(groups = { Regression,Slingshot,Login})
		public void verifyFreezeAccountUser() {
			Report.createTestLogHeader("Login Verification",
					"Verify Freeze account user and emailvalidation flag with N cannot logon");
			UserProfile userProfile = new TestDataHelper()
			.getUserProfile("Loginandpassword");
			new LoginAndPasswordAction()
			.BgbnavigateToLoginPage() 
			.verifyFreezedAccount(userProfile);
		}
//TS_Login&Password Mgmt_15_E2E To verify the E2E flow of the forgot password journey
//TS_Login&Password Mgmt_16 To verify whether the "Reset your password" page is displayed by clicking "Forgot password" link in the login page of Broker portal
//TS_Login&Password Mgmt_19 To verify whether the "Password reminder sent" page is displayed by entering the email address in "Reset your password" page and after clicking continue button
//TS_Login&Password Mgmt_22 To verify whether the "password reminder email" is displayed by entering the email address in "Reset your password" page and after clicking continue button
//TS_Login&Password Mgmt_24 To verify the link navigations of "Password reminder email" page a)On clicking Reset my password-"Password reset screen" should be displayed (positive flow)
//TS_Login&Password Mgmt_31 To verify whether "Password reset confirmation screen" is displayed by entering the valid password in the "Password reset page"and after clicking on "Continue" button
//TS_Login&Password Mgmt_33 To verify whether the link navigations for the following 	a)Login to British gas partner portal- should navigate to Login page 	b)Footer	
//TS_Login&Password Mgmt_34 To verify whether the "Password reset confirmation email" is sent by entering the password and clicking continue on "Password reset screen" page
//TS_Login&Password Mgmt_36 To verify the link navigations of "Password reset  confirmation email" 	a)Login to British gas partner portal-should navigate to Login page	b)Other links if any	

			@Test(groups ={Slingshot,Regression})
			public void verifyForgotPasswordJourney(){
				Report.createTestLogHeader("Forgotten Password Journey", "Verifies a user whether able to do forgotten Password journey and verifies audit details");
				UserProfile userProfile = new TestDataHelper().getUserProfile("Loginandpassword");		
				new LoginAndPasswordAction()
				.Bgloginpage() 
				.verifyAndClickForgottenPasswordLink()				
				.enterEmail(userProfile)			
				.verifyPasswordRemainderSentPage(userProfile)
				.openResetPasswordUrl(userProfile)		
				.enterNewPasswordFields_pwd(userProfile)		
				.clickLoginLinkInResetPasswordSuccessPage()
				.verifyPasswordChangeInDBbroker(userProfile)
				.verifyAuditDetails(userProfile)
				.loginWithNewPasswordbroker(userProfile);			
				new ForgotttenPasswordAction().resetToOldPassword(userProfile);//have to analyse
			}
//TS_Login&Password Mgmt_44 Verify whether the email address field is case insensitive in the login page
			
			@Test(groups = { Regression,Slingshot})
			public void loginEmailPasswordErrorMessageValidation() {
				Report.createTestLogHeader("Login Verification","Verify whether the email address field is case insensitive in the login page");
				UserProfile userProfile = new TestDataHelper().getUserProfile("Loginandpassword");		
				new LoginAndPasswordAction()
				.BgbnavigateToLoginPage() 
				.emailErrorMsgValidation(userProfile);			
			}
			
//TS_Login&Password Mgmt_43 Verify whether proper Error message is displayed in the Login page and LOGIN_TRY_COUNT count in 
							//BUSINESS_TA_CUSTOMER_REG  gets stored as n times when a slingshot  customer tries to login to the application with a invalid password (max to 3).		
			@Test(groups = { Regression,Slingshot})
			public void loginVerificationTryCount() {
				Report.createTestLogHeader("Login Verification","Verify whether the email address field is case insensitive in the login page");
				UserProfile userProfile = new TestDataHelper().getUserProfile("Loginandpassword1");		
				new LoginAndPasswordAction()
				.BgbnavigateToLoginPage() 
				.enterPasswordIsCaseSensitive(userProfile)
				.clickverifyLoginTryCountInDb(userProfile, "1")
				.enterPasswordIsCaseSensitive(userProfile)
				.clickverifyLoginTryCountInDb(userProfile, "2")
				.enterPasswordIsCaseSensitive(userProfile)
				.clickverifyLoginTryCountInDb(userProfile, "3")				
				.Bgblogin_csauser(userProfile)		
				.clickbgclickFinduser()
				.BgbloginUser(userProfile);
				//.clickverifyLoginTryCountInDb(userProfile,"null");
				
			}		
// ================================================================================== Landing page =====================================================================
// =====================================================================================================================================================================	
			
//TS_Landingpage_59 To verify whether the Level 1 and 2 brokers are displayed with the following in the landing page 	
			
			@Test(groups = { Regression,Slingshot})
			public void validateLevel1brokerlandingpage() {		
				Report.createTestLogHeader("Login Verification","To verify whether the user is able to login by giving valid credentials and check db and audit entry");
				UserProfile userProfile = new TestDataHelper().getUserProfile("Loginandpassword");
						new HomePageAction().
							BgbnavigateToLogin(); // have to verify the common url
							new LoginAndPasswordAction()
							.BgbloginUser(userProfile)		
							.verifylevel1andlevel2access()//  have to update the Audit id
							.verifymydetails_Editbutton(userProfile)
							.clickbacktohome()
							.logout();
			}
//TS_Landingpage_59 To verify whether the Level 1 and 2 brokers are displayed with the following in the landing page 				
			@Test(groups = { Regression,Slingshot})
			public void validateLevel2brokerlandingpage() {		
				Report.createTestLogHeader("Login Verification","To verify whether the user is able to login by giving valid credentials and check db and audit entry");
				UserProfile userProfile = new TestDataHelper().getUserProfile("Loginandpassword");
							new HomePageAction().
							BgbnavigateToLogin(); // have to verify the common url
							new LoginAndPasswordAction()
							.BgbloginUser(userProfile)		
							.verifylevel1andlevel2access()//  have to update the Audit id
							.verifymydetails_Editbutton(userProfile)
							.clickbacktohome()
							.logout();
			}
//TS_Landingpage_68_E2E To verify whether the following landing pages are navigated by clicking pod/LHN link in the partner portal landing page.
			@Test(groups = { Regression,Slingshot})
			public void validateLevel3brokerlandingpage() {		
				Report.createTestLogHeader("Login Verification","To verify whether the user is able to login by giving valid credentials and check db and audit entry");
				UserProfile userProfile = new TestDataHelper().getUserProfile("Loginandpassword");
						new HomePageAction().
							BgbnavigateToLogin(); // have to verify the common url
							new LoginAndPasswordAction()
							.BgbloginUser(userProfile)		
							.verifylevel3access()//  have to update the Audit id
							.verifymydetails_Editbutton(userProfile)
							.clickbacktohome()
							.logout();
			}
//TS_Landingpage_75_E2E To verify whether the following landing pages are navigated by clicking pod/LHN link in the partner portal landing page.
			@Test(groups = { Regression,Slingshot})
			public void validateLevel4brokerlandingpage() {		
				Report.createTestLogHeader("Login Verification","To verify whether the user is able to login by giving valid credentials and check db and audit entry");
				UserProfile userProfile = new TestDataHelper().getUserProfile("Loginandpassword");
							new HomePageAction().
							BgbnavigateToLogin(); // have to verify the common url
							new LoginAndPasswordAction()
							.BgbloginUser(userProfile)		
							.verifylevel4access()//  have to update the Audit id
							.verifymydetails_Editbutton(userProfile)
							.clickbacktohome()
							.logout();
			}	
//TS_Landingpage_81_E2E To verify whether the following landing pages are navigated by clicking pod/LHN link in the partner portal landing page.
			@Test(groups = { Regression,Slingshot})
			public void validateLevel5brokerlandingpage() {		
				Report.createTestLogHeader("Login Verification","To verify whether the user is able to login by giving valid credentials and check db and audit entry");
				UserProfile userProfile = new TestDataHelper().getUserProfile("Loginandpassword");
							new HomePageAction().
							BgbnavigateToLogin(); // have to verify the common url
							new LoginAndPasswordAction()
							.BgbloginUser(userProfile)		
							.verifylevel5access()//  have to update the Audit id
							.verifymydetails_Editbutton(userProfile)
							.clickbacktohome()
							.logout();
			}	
//TS_Landingpage_90_E2E To verify whether the End to End flow for the Update Details page by clicking "update your details"link in the landing page for all the levels of brokers.
//TS_Landingpage_89     To verify whether a maximum of five contact numbers can be added in both the fields each separated by commas.
//TS_Landingpage_86		To verify whether the Telephone number and mobile number fields can be edited by clicking on "Edit" in  the personal details section.	
			@Test(groups = { Regression,Slingshot})
			public void verifyUpdateyourpersonaldetails() {		
				Report.createTestLogHeader("Login Verification","To verify whether the user is able to login by giving valid credentials and check db and audit entry");
				UserProfile userProfile = new TestDataHelper().getUserProfile("Loginandpassword1");
							new HomePageAction().
							BgbnavigateToLogin(); // have to verify the common url
							new LoginAndPasswordAction()
							.BgbloginUser(userProfile)
							.verifymydetails_Editbutton(userProfile)
							.Audit_updateuserdetails(userProfile)
							.logout();
			}	
			
				
}

