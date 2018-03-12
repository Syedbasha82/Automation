package bg.framework.app.functional.action.Slingshot_Broker;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.Slingshot_Broker.LoginAndPasswordPage;
import bg.framework.app.functional.page.common.LegacyLoginPage;

public class LoginAndPasswordAction {
	
	
	public LoginAndPasswordAction VerifyWelcomeToYourPartnerPortalOverlay(){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.landingPageOverlayForLevelonetwothreeBroker();	
		return this;
	}
	
	public LoginAndPasswordAction VerifyLinkNavigationofWelcomeToYourPartnerPortalOverlay(){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.welcometoBrokerPortalOverlay();	
		return this;
	}
	public LoginAndPasswordAction VerifytheLandingPageNavigation(){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.verifytheLandingPageforLevel123brokers();	
		return this;
	}
	public LoginAndPasswordAction VerifytheLandingPageNavigationforlevel123brokers(){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.verifytheLandingPageforLevel4brokers();	
		return this;
	}
	
	public LoginAndPasswordAction verifytheLandingPageforLevel4brokers(){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.verifytheLandingPageforLevel4brokers();	
		return this;
	}
		
	public LoginAndPasswordAction verifymydetailslinknavigation(){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.mydetailslinknavigation();	
		return this;
	}
	public LoginAndPasswordAction verifymydetails_Edit(UserProfile userProfile){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.mydetails_editpage(userProfile);	
		broker.verifymobileandtelephoneUpdateAudit(userProfile);
		return this;
	}
	public LoginAndPasswordAction verifymydetailscancel(){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.mydetails_Cancel();	
		return this;
	}
	
	public LoginAndPasswordAction verifymydetailsconfirmationpagelinks(){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.mydetailsconfirmationpage();	
		return this;
	}
	public LoginAndPasswordAction BgbloginUser(UserProfile userProfile){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		System.out.println("Before login page...................");
		broker.BgbloginUser(userProfile);	
		return this;
	}
	public LoginAndPasswordAction BgbloginUser_password(UserProfile userProfile){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.BgbloginUser_password(userProfile);	
		return this;
	}
	public LoginAndPasswordAction BgbloginUser_remembermails(UserProfile userProfile){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.BgbloginUser_remembermails(userProfile);	
		return this;
	}
	
	public LoginAndPasswordAction BgbloginUserdetails(UserProfile userProfile){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.BgbloginUserdetails(userProfile);	
		return this;
	}
	public LoginAndPasswordAction verifyLoginTimeStamp(UserProfile userProfile){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.verifyLoginTimeStamp(userProfile);	
		return this;
	}
	public LoginAndPasswordAction verifylevel1andlevel2access(){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.level1and2accessiblejourney();	
		return this;
	}
	public LoginAndPasswordAction verifylevel3access(){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.level3accessiblejourney();	
		return this;
	}
	public LoginAndPasswordAction verifylevel4access(){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.level4accessiblejourney();	
		return this;
	}
	public LoginAndPasswordAction verifylevel5access(){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.level5accessiblejourney();	
		return this;
	}
	
	public LoginAndPasswordAction verifyAuditDetailsInDb(UserProfile userProfile){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.verifyAuditDetailsInDb(userProfile,"4");	
		return this;
	}
	public LoginAndPasswordAction logout(){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.logout();	
		return this;
	}
	public LoginAndPasswordAction VerifyPrePopulateEmailorPass(UserProfile userProfile){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.VerifyPrePopulateEmailorPass(userProfile);	
		return this;
	}
	public LoginAndPasswordAction emailErrorMsgValidation(UserProfile userProfile) {
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
        broker.loginEmailErrorMessageValidation(userProfile);
        return this;
    }
	public LoginAndPasswordAction loginPasswordErrorMessageValidation(UserProfile userProfile) {
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
        broker.loginPasswordErrorMessageValidation(userProfile);
        return this;
    }
	public LoginAndPasswordAction loginPage() {
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
        broker.loginPage();
        return this;
    }
	public LoginAndPasswordAction resetyourpasswordPage(UserProfile userProfile) {
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
        broker.passwordresetpage(userProfile);
        return this;
    }
	public LoginAndPasswordAction passwordreminderset(UserProfile userProfile) {
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
        broker.passwordreminderset(userProfile);
        return this;
    }
	public LoginAndPasswordAction verifypasswordreminderemail(UserProfile userProfile) {
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
        broker.passwordreminderemail(userProfile);
        return this;
    }
	public LoginAndPasswordAction clickLoginLinkInEmailSentPage() {
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
        broker.clickLoginLinkInEmailSentPage();
        return this;
    }
	public LoginAndPasswordAction verifyAuditDetails(UserProfile userProfile) {
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
        broker.verifyAuditDetails(userProfile);
        broker.verifyLeadTable_newpasswordupdated(userProfile);
        return this;
    }
	public LoginAndPasswordAction BgbnavigateToLoginPage() {
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
        broker.BgbnavigateToLoginPage();
        return this;
    }
	
	public LoginAndPasswordAction Bgloginpage() {
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
        broker.loginpage();
        return this;
    }
	
	public LoginAndPasswordAction verifyFreezedAccount(UserProfile userProfile) {
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
        broker.verifyLoginErrorFreezeAccount(userProfile);
        return this;
    }
	
	public LoginAndPasswordAction verifyloginpage() {
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
        broker.loginpage();
        return this;
    }
	public LoginAndPasswordAction verifyAndClickForgottenPasswordLink() {
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
        broker.verifyAndClickForgottenPasswordLink();
        return this;
    }
	public LoginAndPasswordAction verifyPasswordRemainderSentPage(UserProfile userProfile) {
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
        broker.verifyPasswordRemainderSentPage(userProfile);
       // broker.verifyLeadTable_resetpasswordmailsent(userProfile);
        return this;
    }
	public LoginAndPasswordAction enterEmail(UserProfile userProfile){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.verifyPageTitle1();
		broker.enterEmail(userProfile.getEmail());
		broker.clickContinueButton();
		return this;	
	}
	
	public LoginAndPasswordAction RHNnavigation(){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.RHNnavigationlink();		
		return this;	
	}
	public LoginAndPasswordAction openResetPasswordUrl(UserProfile userProfile){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.openResetPasswordUrl();		
		return this;	
	}
	public LoginAndPasswordAction enterNewPasswordFields(UserProfile userProfile){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.enterNewPasswordFields(userProfile.getNewPassword(),userProfile.getNewPassword());
		return this;	
	}
	public LoginAndPasswordAction enterNewPasswordFields_pwd(UserProfile userProfile){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.enterNewPasswordFields_pwd(userProfile);
		return this;	
	}
	public LoginAndPasswordAction clickLoginLinkInEmailSentPage(UserProfile userProfile){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.verifyPasswordRemainderSentPage(userProfile);		
		return this;	
	}
	
	public LoginAndPasswordAction verifyResetPasswordPageFields(){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.verifyResetPasswordPageFields();		
		return this;	
	}
	public LoginAndPasswordAction clickLoginLinkInResetPasswordSuccessPage(){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.clickLoginLinkInResetPasswordSuccessPage();		
		return this;	
	}
	public LoginAndPasswordAction verifyPasswordChangeInDB(UserProfile userProfile){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.verifyPasswordChangeInDB(userProfile);		
		return this;	
	}
	public LoginAndPasswordAction verifyPasswordChangeInDBbroker(UserProfile userProfile){
		LoginAndPasswordPage broker = new LoginAndPasswordPage();
		broker.verifyPasswordChangeInDB(userProfile);		
		return this;	
	}
	  public LoginAndPasswordAction loginWithNewPassword(UserProfile userProfile){
	    	LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
	        legacyLoginPage.loginWithNewPassword("temp1234",userProfile);
	    	 return this;
	    }
	  public LoginAndPasswordAction loginWithNewPasswordbroker(UserProfile userProfile){
			LoginAndPasswordPage broker = new LoginAndPasswordPage();
	        broker.loginWithNewPasswordbroker("temp1234",userProfile);
	    	 return this;
	    }
	  public LoginAndPasswordAction loginpasswordlandingpagetitle(){
			LoginAndPasswordPage broker = new LoginAndPasswordPage();
			broker.landingpage();
	    	 return this;
	    }
	  public LoginAndPasswordAction loginpasswordlandingpagebreadcrumb(){
			LoginAndPasswordPage broker = new LoginAndPasswordPage();
			broker.Loginandpassword_breadcrumb();
	    	 return this;
	    }
	  public LoginAndPasswordAction Audit_updateuserdetails(UserProfile userProfile){
			LoginAndPasswordPage broker = new LoginAndPasswordPage();
			broker.verifyLeadTable_Updateuserdetails(userProfile);
	    	 return this;
	    }
	  public LoginAndPasswordAction verifymydetails_Editbutton(UserProfile userProfile){
			LoginAndPasswordPage broker = new LoginAndPasswordPage();
			broker.maximumupdatein_contactandteleno(userProfile);
	    	 return this;
	    }
	  public LoginAndPasswordAction clickbacktohome(){
			LoginAndPasswordPage broker = new LoginAndPasswordPage();
			broker.bactohomepage();
	    	 return this;
	    }
	  public LoginAndPasswordAction clickverifyLoginTryCountInDb(UserProfile userProfile,String recCount){
			LoginAndPasswordPage broker = new LoginAndPasswordPage();
			broker.verifyLoginTryCountInDb(userProfile,recCount);
	    	 return this;
	    }
	 
	  public LoginAndPasswordAction Bgblogin_csauser(UserProfile userProfile){
			LoginAndPasswordPage broker = new LoginAndPasswordPage();
			broker.csauserpage(userProfile);
	    	 return this;
	    }
	  public LoginAndPasswordAction enterPasswordIsCaseSensitive(UserProfile userProfile){
			LoginAndPasswordPage broker = new LoginAndPasswordPage();
			broker.enterPasswordIsCaseSensitive(userProfile);
	    	 return this;
	    }
	  public LoginAndPasswordAction clickbgclickFinduser(){
			LoginAndPasswordPage broker = new LoginAndPasswordPage();
			broker.bgclickFinduser();
	    	 return this;
	    }
	  
	  
}
