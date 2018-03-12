package bg.framework.app.functional.action.common;


import bg.framework.app.functional.action.Slingshot.AccountOverViewAction;
import bg.framework.app.functional.action.Slingshot.BusinessMovesAction;
import bg.framework.app.functional.action.Slingshot.ConnectionsandMeteringAction;
import bg.framework.app.functional.action.Slingshot.ContactUsBusinessAction;
import bg.framework.app.functional.action.Slingshot.ContactUsCorporateAction;
import bg.framework.app.functional.action.Slingshot.ForgottenEmailAction;
import bg.framework.app.functional.action.Slingshot.AccountSummaryAction;
import bg.framework.app.functional.action.Slingshot.BgbRegistrationAction;
import bg.framework.app.functional.action.Slingshot.ManagePersonalDetailsAction;
import bg.framework.app.functional.action.Slingshot.StatementOfAccountAction;
import bg.framework.app.functional.action.reFactoring.EssCallBackAction;
import bg.framework.app.functional.action.reFactoring.ForgotEmailAction;
import bg.framework.app.functional.action.reFactoring.ForgotPasswordAction;
import bg.framework.app.functional.action.Slingshot.ForgotttenPasswordAction;
import bg.framework.app.functional.action.reFactoring.PaymentHistoryAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.action.selfServe.ChangeEmailAction;
import bg.framework.app.functional.action.selfServe.ContactUsAction;
import bg.framework.app.functional.action.reFactoring.AccOverviewAction;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.Slingshot.AccountOverviewPage;
import bg.framework.app.functional.page.Slingshot.AccountSummaryPage;
import bg.framework.app.functional.page.Slingshot.BusinessMovesPage;
import bg.framework.app.functional.page.Slingshot.ConnectionsandMeteringPage;
import bg.framework.app.functional.page.Slingshot.ContactUsBusinessPage;
import bg.framework.app.functional.page.Slingshot.ContactUsCorporatePage;
import bg.framework.app.functional.page.Slingshot.ManagePersonalDetailsPage;
import bg.framework.app.functional.page.Slingshot.RegistrationPage;
import bg.framework.app.functional.page.Slingshot.StatementOfAccountPage;
import bg.framework.app.functional.page.common.LegacyHomePage;
import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.page.reFactoring.ESSCallBackPage;
import bg.framework.app.functional.page.reFactoring.PaymentHistoryPage;
import bg.framework.app.functional.util.OnlineDBConnector;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 25/01/12
 * Time: 15:43
 * To change this template use File | Settings | File Templates.
 */
public class LoginAction {
	 private static String strEmail="temp@cognizant.com";
	 private static String strTempPwd = "temp1234";
	  private static int BGBUSINESS_LOGOUT_SUCCESSFUL = 25;

    public AccountOverviewAction login(UserProfile userProfile) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.loginUser(userProfile);
        return new AccountOverviewAction(userProfile);
    }

    public ContactUsAction loginUserAutoDirectToContactUsPage(UserProfile userProfile) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.loginUserAutoDirectToContactUsPage(userProfile);
        return new ContactUsAction(userProfile);
    }

    public ChangeEmailAction navigateToChangeEmailAddressScreen() {
        new LegacyLoginPage().navigateToChangeEmailAddress();
        return new ChangeEmailAction();
    }

    public ForgotEmailAction navigateToForgottenEmailAddressScreen() {
        new LegacyLoginPage().navigateToForgottenEmailAddress();
        return new ForgotEmailAction();
    }

    public ForgotEmailAction navigatetoForgotEmailPage() {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.navigatetoForgotEmailPage();
        return new ForgotEmailAction();
    }

    public ForgotEmailAction navigatetoForgotEmailViaForgotPassScreen() {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.navigatetoForgotEmailViaForgotPassword();
        return new ForgotEmailAction();
    }

    public LoginAction verifyLockedAccount(UserProfile userProfile) {
        LegacyLoginPage loginPage = new LegacyLoginPage();
        loginPage.verifyAccountLock(userProfile);
        return this;
    }

    public AccountOverviewAction loginErrorValidation(UserProfile userProfiles) {
        LegacyLoginPage loginPage = new LegacyLoginPage();
        loginPage.loginErrorValidation(userProfiles);
        return new AccountOverviewAction();
    }

    public LoginAction loginForInactiveAccount(UserProfile userProfile) {
        LegacyLoginPage loginPage = new LegacyLoginPage();
        loginPage.loginForInactiveAccount(userProfile);
        return this;
    }

    public LoginAction emailCheckBoxVerification(UserProfile userProfile) {
        LegacyLoginPage loginPage = new LegacyLoginPage();
        loginPage.emailCheckBoxVerification(userProfile);
        return this;
    }

    public ForgotPasswordAction navigateToForgottenPasswordScreen() {
        new LegacyLoginPage().navigateToForgottenPassword();
        return new ForgotPasswordAction();
    }
    public LoginAction loginUser(UserProfile userProfile) {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToLoginPage();
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.loginUser(userProfile);
        return new LoginAction();
    }
    public EssCallBackAction navigateToRequestCallBackPage(){
        ESSCallBackPage essCallBackPage = new ESSCallBackPage();
        essCallBackPage.navigateToRequestCallBackPage();
        return new EssCallBackAction();
    }
    public AccountOverviewAction loginDetails(UserProfile userProfile) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.loginUser(userProfile);
        //legacyLoginPage.loginUserDetails(userProfile);
        return new AccountOverviewAction(userProfile);
    }
    public AccOverviewAction loginUserDetails(UserProfile userProfile) {
    	LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToLoginPage();
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();        
        legacyLoginPage.loginUserDetails(userProfile);
        return new AccOverviewAction(userProfile);
    }
    
   public AccountSummaryAction BgbloginDetails(UserProfile userProfile) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        AccountOverviewPage accOverviewpage =   new AccountOverviewPage();
        legacyLoginPage.BgbloginUser(userProfile);
//        accOverviewpage.verifyAccountDetails(userProfile);
//        legacyLoginPage.loginUserDetails(userProfile);
        return new AccountSummaryAction();
    }
    public LoginAction GotoBusinessLink(UserProfile userProfile) {
        /*LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.ClickGoToBusinessSite(userProfile);*/ //11-Dec
        //legacyLoginPage.loginUserDetails(userProfile);
        return new LoginAction();
    }
    public LoginAction EnterInvalidEmailorPwd(UserProfile userProfile) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.EnterInvalidEmailorPass(userProfile);
        //legacyLoginPage.loginUserDetails(userProfile);
        return new LoginAction();
    }
    public LoginAction EnterInvalidPwd(UserProfile userProfile) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
//        legacyLoginPage.checkLoginTryCountToThree(userProfile);
        legacyLoginPage.EnterInvalidPwd(userProfile);
        //legacyLoginPage.loginUserDetails(userProfile);
        return new LoginAction();
    }
    public LoginAction VerifyLoginTryCount(UserProfile userProfile) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.EnterInvalidEmailorPass(userProfile);
        //legacyLoginPage.loginUserDetails(userProfile);
        return new LoginAction();
    }
    public LoginAction VerifyLoginTrycount(UserProfile userProfile){ 
    	LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
    	legacyLoginPage.verifyLoginTryCount(userProfile);
    	return new LoginAction();
    }
    
    public LoginAction verifyPrepopulateEmailorPass(UserProfile userProfile) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.VerifyPrePopulateEmailorPass(userProfile);
        //legacyLoginPage.loginUserDetails(userProfile);
        return new LoginAction();
    }
    
    public LoginAction checkRemeberEmail(UserProfile userProfile) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.CheckRememberEmail(userProfile);
        //legacyLoginPage.loginUserDetails(userProfile);
        return new LoginAction();
    }
    
    public LoginAction emailErrorMsgValidation(UserProfile userProfile) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.loginEmailErrorMessageValidation(userProfile);
        return new LoginAction();
    }
    
    public LoginAction loginPasswordErrorMessageValidation(UserProfile userProfile) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.loginPasswordErrorMessageValidation(userProfile);
        return new LoginAction();
    }
    /*public LoginAction getErrorMessage(String email,String password) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.getErrorMsgLoginscreen(email ,password);
        //legacyLoginPage.loginUserDetails(userProfile);
        return new LoginAction();
    }*/
    
    public AccountSummaryAction emailAddressInCaseSensitive(UserProfile userProfile) {
        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.enterEmailCaseSensitive(userProfile);
        //legacyLoginPage.loginUserDetails(userProfile);
        return new AccountSummaryAction();
    }
    public HomePageAction verifypageafterBrowserBack(UserProfile userProfile) {
    	LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.verifyBrowserBackPage(userProfile);
        //legacyLoginPage.loginUserDetails(userProfile);
        return new HomePageAction();
    } 
    
    public HomePageAction closeBrowser() {
    	LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.closeBrowser();
        //legacyLoginPage.loginUserDetails(userProfile);
        return new HomePageAction();
    }
    
    public HomePageAction bgblogout() {
    	AccountSummaryPage logout = new AccountSummaryPage();
        logout.logout();
        //legacyLoginPage.loginUserDetails(userProfile);
        return new HomePageAction();
    }
    
	public LoginAction verifyErrormsginLoginPage(){
		LegacyLoginPage legacyLoginPage = new LegacyLoginPage();	
		legacyLoginPage.getErrorMsgLoginscreen("");
			return this;
		}

	
	public LoginAction verifyFreezedAccount(UserProfile userProfile){
		   
	   	LegacyLoginPage legacyLoginPage = new LegacyLoginPage();	
	   	legacyLoginPage.verifyLoginErrorFreezeAccount(userProfile);		
   	     return this;
    }
	public LoginAction verifyInActiveAccount(UserProfile userProfile){
		   
	   	LegacyLoginPage legacyLoginPage = new LegacyLoginPage();	   
		legacyLoginPage.verifyLoginErrorForInactiveUser(userProfile);
   	     return this;
    }
	
   
	//Slingshot
	  public AccountSummaryAction loginWithNewPassword(UserProfile userProfile){
	    	LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
	        legacyLoginPage.loginWithNewPassword("temp1234",userProfile);
	    	 return new AccountSummaryAction();
	    }
	  public LoginAction loginWithUpperCasePassword(UserProfile userProfile){
	    	LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
	        legacyLoginPage.setUpperCasePassword(userProfile);
	    	 return new LoginAction();
	    }
	  public void verifyAuditDetails(UserProfile userProfile){
	    	LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
	    	legacyLoginPage.verifyAuditDetails(userProfile);
	    }
	  public AccountSummaryAction loginWithNewEmail(UserProfile userProfile){
	    	LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
	    	legacyLoginPage.loginWithNewEmail(userProfile);
	    	return new AccountSummaryAction();
	    }
	    public AccountSummaryAction loginWithUpperCaseEmailId(UserProfile userProfile){
	    	LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
	    	legacyLoginPage.loginWithUpperCaseEmailId(userProfile);
	    	return new AccountSummaryAction();
	    }
	    
	    public ForgottenEmailAction verifyAndClickForgottenEmailLink(){
	    	LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
	    	legacyLoginPage.verifyAndClickForgottenEmailLink();
	    	return new ForgottenEmailAction();
	    }
	    public ForgottenEmailAction verifyAndClickForgottenPasswordLink(){
	    	LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
	    	legacyLoginPage.verifyAndClickForgottenPasswordLink();
	    	return new ForgottenEmailAction();
	    }

	    /*public LoginAction verifyAuditdetails(UserProfile userProfile,String eventid) {
	    	 
	    	 LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
	    	 legacyLoginPage.verifyAuditDetailsInDb(userProfile, eventid);
	     	return this;
	     }
	    public LoginAction verifyLoginTryCount(UserProfile userProfile,String recCount) {
	     	
	    	LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
	    	legacyLoginPage.verifyLoginTryCountInDb(userProfile, recCount);
	    	
	        return this;
	     }  
*/
  public ForgotttenPasswordAction verifyAndClickForgottenPasswordLink_FP(UserProfile userProfile){
	    	LegacyLoginPage legacyLoginPage = new LegacyLoginPage();	    	
	    	legacyLoginPage.verifyErrorMessageAndClickForgottenPasswordLink();
//	    	legacyLoginPage.resetLoginTryCount(userProfile);
	    	return new ForgotttenPasswordAction();
	    }
	    public ForgotttenPasswordAction verifyAndClickForgottenPasswordLinkFP(){
	    	LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
	    	legacyLoginPage.verifyAndClickForgottenPasswordLink();
	    	return new ForgotttenPasswordAction();
	    }
	    public AccountSummaryAction loginWithMPDChangeData(UserProfile userProfile,int loginType){
	    	LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
	    	legacyLoginPage.loginWithMPDChangeData(strEmail,strTempPwd,userProfile,loginType);	    	
	    	return new AccountSummaryAction();
	    }
	    
	    public ManagePersonalDetailsAction resetPasswordFields(UserProfile userProfile){
	    	 ManagePersonalDetailsPage mpdPage = new ManagePersonalDetailsPage();
	    	 new  AccountSummaryPage().clickMPDLink(userProfile);
	    	 mpdPage.resetPasswordFields(userProfile.getEmail(),userProfile.getPassword());
	    	 mpdPage.ClickSaveChangesButton();
	    	// mpdPage.clickLogin();
	    	 return new ManagePersonalDetailsAction(); 
	     }
	    public AccountSummaryAction loginWithMPDChangeDataForCaseSensitve(UserProfile userProfile,int loginType){
	    	LegacyLoginPage legacyLoginPage = new LegacyLoginPage();	    	
	    	legacyLoginPage.loginWithMPDChangeData(strEmail,strTempPwd,userProfile,0);
	    	return new AccountSummaryAction();
	    }
	    public AccountSummaryAction loginWithUpdatedEmailAddress(UserProfile userProfile){
	    	LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
	    	legacyLoginPage.loginWithUpdatedEmailAddress(strEmail,userProfile);	    	
	    	return new AccountSummaryAction();
	    }

	    public AccountSummaryAction enterPasswordIsCaseSensitive(UserProfile userProfile){
	    	LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
	    	legacyLoginPage.enterPasswordIsCaseSensitive(userProfile);
	    	return new AccountSummaryAction();
	    }

	    
	    public LoginAction verifyBrowserBackFunctionality(UserProfile userProfile){
	    	LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
//	    	legacyLoginPage.verifyBrowserBackFunctionality();
			return new LoginAction();	
		    	
		    }

	    public LoginAction navigateToBgbLogin() {
	        new LegacyHomePage().BgbnavigateToLoginPage();
	        return new LoginAction();
	    }


	    public LoginAction EnterInvalidPassword(UserProfile userProfile) {
	        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
	        legacyLoginPage.checkLoginTryCountToThree(userProfile);
	        legacyLoginPage.EnterInvalidPwd(userProfile);
	        //legacyLoginPage.loginUserDetails(userProfile);
	        return new LoginAction();
	    }
	    public ForgottenEmailAction verifyErrorMessageAndClickForgottenEmailLink(UserProfile userProfile){
	    	LegacyLoginPage legacyLoginPage = new LegacyLoginPage();	    	
	    	legacyLoginPage.verifyErrorMessageAndClickForgottenEmailLink();
//	    	legacyLoginPage.resetLoginTryCount(userProfile);
	    	return new ForgottenEmailAction();
	    }



	    public BgbRegistrationAction verifyAndRegister(){
	    	RegistrationPage bgbpage=new RegistrationPage();
			return new BgbRegistrationAction();
	    	
	    }
	  

	    public ContactUsBusinessAction navigatetoContactUslink() {
			ContactUsBusinessPage navigatetoContactUslink = new ContactUsBusinessPage();
			navigatetoContactUslink.navigatetoContactUslink(); 
			return new ContactUsBusinessAction();
		}
		
		public ContactUsCorporateAction navigatetoContactUsCorporatelink() {
			new ContactUsCorporatePage().navigatetoContactUsCorporatelink();
			return new ContactUsCorporateAction();	
		}
		
		

		/**
		 * @param userProfile
		 * @return
		 */
		public AccountSummaryAction BgcloginDetails(UserProfile userProfile) {
			   LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
		       AccountOverviewPage accOverviewpage =   new AccountOverviewPage();
		       legacyLoginPage.BgcloginUser(userProfile); 
		       return new AccountSummaryAction();
			}
		public LoginAction bgbLoginUser() {
			LegacyHomePage legacyHomePage = new LegacyHomePage();
			legacyHomePage.BgbnavigateToLoginPage(); 
			return this;
		}

		public AccountOverViewAction bgbloginDetails(UserProfile userProfile) {
	        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
	        legacyLoginPage.BgbloginUser(userProfile);       
	        return new AccountOverViewAction();
	    }



		
		public AccountSummaryAction BgbLoginUser(UserProfile userProfile) {
			   LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
		       AccountOverviewPage accOverviewpage =   new AccountOverviewPage();
		       legacyLoginPage.BgbloginUser(userProfile); 
		       return new AccountSummaryAction();
			}
		


		public LoginAction BgbnavigateToLogin() {
            LegacyHomePage legacyHomePage = new LegacyHomePage();
            legacyHomePage.BgbnavigateToLoginPage(); 
            return this;
     }

		
		public StatementOfAccountAction verifySOADataThroughQTP(UserProfile userProfile) {
			StatementOfAccountPage AcctPage = new StatementOfAccountPage();
			//AcctPage.PaginationNumbersLink();
			AcctPage.verifyDataThroughQTP(userProfile);
			 return new StatementOfAccountAction(); 
			
		}

public AccountSummaryAction loginWithNewData(UserProfile userProfile,int loginType){
	LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
	legacyLoginPage.loginWithMPDChangeData(userProfile.getNewEmail(),strTempPwd,userProfile,loginType);	    	
	return new AccountSummaryAction();
}
public BusinessMovesAction clickBusinessMovesLink(){
	BusinessMovesPage businessMoves = 	new BusinessMovesPage();
	businessMoves.clickBusinessMovesLink();
	return new BusinessMovesAction();
}
public ConnectionsandMeteringAction navigatetoConnectionsandMetering() {
	new ConnectionsandMeteringPage().navigatetoConnectionsandMetering();
	return new ConnectionsandMeteringAction();			
}
public ConnectionsandMeteringAction retrieveTelephoneNo(UserProfile userProfile) {
	new ConnectionsandMeteringPage().retrieveTelephoneNo(userProfile);
	return new ConnectionsandMeteringAction();	
	
}
}