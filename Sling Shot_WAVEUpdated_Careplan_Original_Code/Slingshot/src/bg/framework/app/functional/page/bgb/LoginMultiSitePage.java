package bg.framework.app.functional.page.bgb;

import bg.framework.app.functional.action.bgb.LoginMultiSiteAction;
import bg.framework.app.functional.action.bgb.SearchInvoicesAction;
import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.RegistrationProfile;
import bg.framework.app.functional.entities.SearchInvoiceProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

//import bg.framework.common.functional.WebDriverProvider;

public class LoginMultiSitePage extends BasePage {
    private final static String FILE_NAME = "resources/bgb/LoginMultiSite.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
    private RegistrationProfile registrationProfile;
    private SearchInvoiceProfile searchInvoiceProfile;

    public LoginMultiSitePage() {

    }

    public LoginMultiSitePage(RegistrationProfile registrationProfile) {
        this.registrationProfile = registrationProfile;
    }

    public LoginMultiSiteAction enterValidCredentials(RegistrationProfile registrationProfile) {
	
	browser.wait(4000);
        verifyAndInputById(pageProperties.getProperty("BGBLogin.emailID"), "Email ID Text Box", registrationProfile.getEmail());
        verifyAndInputById(pageProperties.getProperty("BGBLogin.password"), "Password Text Box", registrationProfile.getPassword());

        return new LoginMultiSiteAction();
    }
    public LoginMultiSiteAction enterValidCredentialsNew(RegistrationProfile registrationProfile) {
    	
    	browser.wait(4000);
            verifyAndInputById(pageProperties.getProperty("BGBLogin.emailID"), "Email ID Text Box", registrationProfile.getEmail());
            verifyAndInputById(pageProperties.getProperty("BGBLogin.password"), "Password Text Box", registrationProfile.getPassword());

            return new LoginMultiSiteAction();
        }
    public LoginMultiSiteAction enterValidUpperCase(RegistrationProfile registrationProfile) {
	
	browser.wait(4000);
        verifyAndInputById(pageProperties.getProperty("BGBLogin.emailID"), "Email ID Text Box", registrationProfile.getEmail().toUpperCase());
        verifyAndInputById(pageProperties.getProperty("BGBLogin.password"), "Password Text Box", registrationProfile.getPassword());

        return new LoginMultiSiteAction();
    }
    public LoginMultiSiteAction enterValidLowerCase(RegistrationProfile registrationProfile) {
	
	browser.wait(4000);
        verifyAndInputById(pageProperties.getProperty("BGBLogin.emailID"), "Email ID Text Box", registrationProfile.getEmail().toLowerCase());
        verifyAndInputById(pageProperties.getProperty("BGBLogin.password"), "Password Text Box", registrationProfile.getPassword());

        return new LoginMultiSiteAction();
    }

    public void checkRememberBox() {
        verifyAndClick(pageProperties.getProperty("BGBLogin.rememberCheck"), "Remember My id check Box");

    }

    public void clickLogout() {
        verifyAndClickWithLinkText("Logout", "Logout Link");

    }
    
    public void clickMyProfile() {
       // verifyAndClickWithLinkText("My profile", "My Profile Link");
        verifyAndClickWithXpath(pageProperties.getProperty("BGBLogin.PROFILE"), "PROFILELINK");
        browser.wait(1000);
    }

    public void verifyDisabledUserError() {
	
        if (browser.isTextPresent(pageProperties.getProperty("BGBLogin.disableError"))) {
            Report.updateTestLog("Error Message for acount disabled is displayed correctly", "PASS");
        } else {

            Report.updateTestLog("Error Message for acount disabled   is not displayed correctly", "FAIL");
        }
    }

    public LoginMultiSiteAction submitCredentialsToLogin() {
        verifyAndClick(pageProperties.getProperty("BGBLogin.login"), "Login Button");

        return new LoginMultiSiteAction();
    }

    public void verifyPrePopulatedEmail(String emailID) {
    browser.wait(2000);
        String email = browser.getAttribute(pageProperties.getProperty("BGBLogin.emailID"), "value");
        email = email.trim();
        //System.out.println("Email"+email);
        if (email.equalsIgnoreCase(emailID)) {
            Report.updateTestLog("Email id " + emailID + " is prepopulated ", "PASS");
        } else {

            Report.updateTestLog("Email id " +emailID + " is not prepopulated ", "FAIL");
        }
        //System.out.println(email);
    }


    public void enterInvalidCredentials() {
//        String email[] = new String[4];
//        String pwd[] = new String[4];
//        email[0] = "anand@vm.com";
//        email[1] = "anand@vm.com";
//        email[2] = "anand@vm.com";
//        email[3] = "anand@vm.com";
//        pwd[0] = "pass1";
//        pwd[1] = "pass2";
//        pwd[2] = "pass3";
//        pwd[3] = "pass4";
//        
	String email[]= {"",registrationProfile.getEmail(),registrationProfile.getEmail(),registrationProfile.getEmail()};
	String pwd[]= {"pass1","","password1","password1"};
        LoginMultiSitePage bgLoginPage = new LoginMultiSitePage();
        for (int i = 0; i < 4; i++) {
            verifyAndInputById(pageProperties.getProperty("BGBLogin.emailID"), "Email ID Text Box", email[i]);
            verifyAndInputById(pageProperties.getProperty("BGBLogin.password"), "Password Text Box", pwd[i]);
            bgLoginPage.submitCredentialsToLogin();
            browser.wait(3000);
            verifyLoginError();
            
        }

    }
    private void verifyLoginError(){
	ArrayList<String> errorList = new ArrayList<String>();
        errorList.add(ErrorMessages.ACCOUNT_LOCKED);
        errorList.add(ErrorMessages.EMAIL_MANDATORY);
        errorList.add(ErrorMessages.PASSWORD_MANDATORY);
        errorList.add(ErrorMessages.USER_NOT_AUTHENTICATED);
        String error="yes";
        for(String s:errorList) {
        if(browser.isTextPresent(s)) {
            Report.updateTestLog("Error Message for <b>"+s+"</b> is displayed correctly", "PASS");
            error="yes";
            break;
        }else {
            error="no";
        }        
        }
        if(error.equals("no")){
            Report.updateTestLog("Error Message is not displayed correctly", "FAIL");
        }
       }

    public void enterInactiveuser(RegistrationProfile registrationProfile) {

        LoginMultiSitePage bgLoginPage = new LoginMultiSitePage();
        browser.wait(3000);
        verifyAndInputById(pageProperties.getProperty("BGBLogin.emailID"), "Email ID Text Box", registrationProfile.getEmail());
        verifyAndInputById(pageProperties.getProperty("BGBLogin.password"), "Password Text Box", registrationProfile.getPassword());

        bgLoginPage.submitCredentialsToLogin();
        browser.wait(10000);
        if (browser.isTextPresent(pageProperties.getProperty("BGBLogin.loginError1"))) {
            Report.updateTestLog("Error Message for acount Inactive is displayed correctly", "PASS");
        } else {

            Report.updateTestLog("Error Message for acount Inactive   is not displayed correctly", "FAIL");
        }


    }

    public void verifyTemporaryPasswordSentPage() {
        
        if (browser.isTextPresent(pageProperties.getProperty("BGBLogin.temporaryPassword"))) {

            Report.updateTestLog("Temporary password sent Page is displayed correctly", "PASS");
        } else {

            Report.updateTestLog("Temporary password sent Page  is not displayed correctly", "FAIL");
        }
    }

    public void verifyLoginPage() {
        browser.wait(2000);
        if (browser.isTextPresent(pageProperties.getProperty("BGBLogin.loginPage"))) {

            Report.updateTestLog("Login Page is displayed correctly", "PASS");
        } else {

            Report.updateTestLog("Login Page  is not displayed correctly", "FAIL");
        }

    }

    public void verifyForgetPasswordPage() {
	browser.wait(1000);
        if (browser.isTextPresent(pageProperties.getProperty("BGBLogin.forgotPage"))) {

            Report.updateTestLog("Forgotten password Page is displayed correctly", "PASS");
        } else {

            Report.updateTestLog("Forgotten password Page  is not displayed correctly", "FAIL");
        }
    }

    public void verifyResetPasswordPage() {
        String expText = "Reset your password";
        browser.wait(2000);
        //	String forgotDisp = browser.getTextByXpath(pageProperties.getProperty("BGBLogin.resetPasswordLabel"));
        if (browser.isTextPresent(expText)) {

            Report.updateTestLog("Reset your password Page is displayed correctly", "PASS");
        } else {

            Report.updateTestLog("Reset your password Page  is not displayed correctly", "FAIL");
        }
    }
    public void verifyInvTempPassword(RegistrationProfile registrationProfile,String systemDate, String expAuditType) {
	openLoginPage();
	enterEmailAddress();
	enterPassword(registrationProfile.getConfPassword());
	clickLogin();
	String invTempPass = "";
	String invNewPass = "password12";
	String invConfNewPass = "password12";
	setNewPasswordInv(invTempPass,invNewPass,invConfNewPass);
//	verifyDbResetPass(systemDate, expAuditType);
	//clickLogin();
	verifyErrorTxtPass(0);
	 invTempPass = "passwrd13";
	 invNewPass = "password12";
	 invConfNewPass = "password12";
	setNewPasswordInv(invTempPass,invNewPass,invConfNewPass);
	//verifyDbResetPass(systemDate, expAuditType);
	//clickLogin();
	verifyErrorTxtPass(1);
	 invTempPass = "password13";
	 invNewPass = "password13";
	 invConfNewPass = "password13";
	setNewPasswordInv(invTempPass,invNewPass,invConfNewPass);
	//verifyDbResetPass(systemDate, expAuditType);
	//clickLogin();
	verifyErrorTxtPass(2);
    }	
   
    public void verifyErrorTxtPass(final int iteration)
    {
	String strText;
	String error=null;
        error=browser.getTextByXpath(pageProperties.getProperty("BGBLogin.errorMsgTempPass"));
        switch (iteration) {
        	case 0:
                    strText = ErrorMessages.TEMP_PASSWORD_MANDATORY;
                    if (error.contains(strText)) {
                	    Report.updateTestLog("Error Text <b>"+strText+" </b>displayed correctly", "PASS");
            	    } 
                    else {
                	 Report.updateTestLog("Error Text <b>"+strText+"</b> not displayed correctly","FAIL");
                    }
                    break;
        	case 1:
                    strText = ErrorMessages.TEMP_PASSWORD_INCORRECT;
                    if (error.contains(strText)) {
                	    Report.updateTestLog("Error Text <b>"+strText+"</b> displayed correctly", "PASS");
            	    } 
                    else {
                	 Report.updateTestLog("Error Text <b>"+strText+"</b> not displayed correctly","FAIL");
                    }
                    break;
        	case 2:
                    strText = ErrorMessages.SAME_AS_TEMP_PASSWORD;
                    if (error.contains(strText)) {
                	    Report.updateTestLog("Error Text <b>"+strText+"</b>  displayed correctly", "PASS");
            	    } 
                    else {
                	 Report.updateTestLog("Error Text <b>"+strText+"</b>  not displayed correctly","FAIL");
                    }
                    break;
        }
        
    }
    public void verifySuccessForgorPasswordPage() {
       // String expText = "You have successfully changed your password";
        
        //	String forgotDisp = browser.getTextByXpath(pageProperties.getProperty("BGBLogin.forgotPasswordSuccessLabel"));
        if (browser.isTextPresent(pageProperties.getProperty("BGBLogin.tempPassowrdSuccess"))) {

            Report.updateTestLog("Successfull password Page is displayed correctly", "PASS");
        } else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BGBLogin.errorMsgTempPass"))) {
            String strText;
    		String error=null;
            error=browser.getTextByXpath(pageProperties.getProperty("BGBLogin.errorMsgTempPass"));
           
            strText = ErrorMessages.RESET_PASSWORD_FAILED;
            if (error.contains(strText)) {
        	    Report.updateTestLog("PI is down Error - "+strText+" displayed", "FAIL");
    	    } 
            else {

            Report.updateTestLog("Successfull password Page  is not displayed correctly", "FAIL");
            }
        }
        
       
                   
    }

    public void accountLock() {

        if (browser.isTextPresent("Your Account Locked")) {
            Report.updateTestLog("Your Account Locked is displayed correctly", "PASS");
        } else {

            Report.updateTestLog("Your Account Locked is not displayed correctly", "FAIL");


        }
    }

    public void clickForgetPasswordLink() {
        verifyAndClickWithXpath(pageProperties.getProperty("BGBLogin.forgetPasswordLink"), "Forgot Passowrd Link");

    }

    public void enterForgetPasswordInvalidEmail(String systemDate,String expAuditType) {
        String email[] = new String[3];
        email[0] = "wrong@email.com";
        email[1] = " ";
        email[2] = "unregister@email.com";
        for (int i = 0; i <=2; i++) {
            verifyAndInputById(pageProperties.getProperty("BGBLogin.emailID"), "Email Id Text Box", email[i]);
            verifyAndClickWithXpath(pageProperties.getProperty("BGBLogin.submit"), "Submit Button");
            verifyForgetPasswordErrorMessage();
            if (i!=1) {
            verifyDbResetPass(email[i],systemDate, expAuditType);
            }
        }
    }

    public void enterForgetPasswordValidEmail(RegistrationProfile registrationProfile,String systemDate,String expAuditType) {
        String email[] = new String[3];
        email[0] = registrationProfile.getEmail();
        email[1] = registrationProfile.getEmail().toUpperCase();
        email[2] = registrationProfile.getEmail().toLowerCase();
        for (int i = 0; i < 3; i++) {
         
            clickForgetPasswordLink();
            verifyAndInputById(pageProperties.getProperty("BGBLogin.emailID"), "Email Id Text Box", email[i]);
            clickSubmitButton();
            verifyForgetPasswordSuccess();
            verifyDbResetPass(registrationProfile.getEmail(),systemDate, expAuditType);            
            openLoginPage();
            
        }
    }

    public void clickSubmitButton() {
        verifyAndClickWithXpath(pageProperties.getProperty("BGBLogin.submit"), "Submit Button");
    }


    public void clickCancelLink() {
        verifyAndClickWithLinkText("Cancel", "Cancel Link");

    }

    public void verifyForgetPasswordSuccess() {
	browser.wait(1000);
        if (browser.isTextPresent(pageProperties.getProperty("BGBLogin.temporaryPassword"))) {
            Report.updateTestLog("Success Message for ForgetPassword is displayed correctly", "PASS");
        } else {

            Report.updateTestLog("Success Message for ForgetPassword  is not displayed correctly", "FAIL");
        }

    }

    public void verifyForgetPasswordErrorMessage() {
        if (browser.isTextPresent(pageProperties.getProperty("BGBLogin.forgotPasswordError"))) {
            Report.updateTestLog("Error Message for ForgetPasswordError is displayed correctly", "PASS");
        } else {

            Report.updateTestLog("Error Message for ForgetPasswordError is not displayed correctly", "FAIL");
        }

    }
    
    public void verifyusername(){
    	browser.wait(2000);
    	verifyAndClick(pageProperties.getProperty("BGBLogin.my-profile"), "Click MyProfile Link");
    	String corname=browser.getTextByXpath(pageProperties.getProperty("BGBLogin.cournerName"));
//    	String a1="Hello prasad santha , Logout";
    	String a2[]=corname.split(",");
    	String a3[]=a2[0].split("Hello");
    	String a4=a3[1];
    	
    	String firstname=browser.getTextByXpath(pageProperties.getProperty("BGBLogin.fname"));
    	String surname=browser.getTextByXpath(pageProperties.getProperty("BGBLogin.sname"));
    	String a5=firstname+" "+surname;
    	
    	if(a4.trim().equals(a5.trim())){
    		 Report.updateTestLog("User name is displayed in the right corner correctly: "+a5.trim(), "PASS");
    	}
    	else{
    		Report.updateTestLog("User name is not displayed in the right corner correctly:  "+a5.trim(), "FAIL");
    	}
    }

    public void openLoginPage() {
        browser.open(ApplicationConfig.BGB_MS_LOGIN);
    }
    public void clickforgotpasswordlink(RegistrationProfile registrationProfile) {
    	
    	verifyAndClickWithXpath(pageProperties.getProperty("BGBLogin.my-forgotpasswordlink"), "Click forgotpasswordlink");
    	browser.wait(3000);
    	String email=registrationProfile.getEmail();
    	verifyAndInputByXpath(pageProperties.getProperty("BGBLogin.forgetpasswordemail")," Enter Email Address" ,registrationProfile.getEmail());
    	verifyAndClickWithXpath(pageProperties.getProperty("BGBLogin.my-forgotpasswordSubmit"),"Click forgot password submit button" );
    	browser.wait(5000);
    	//String email1=registrationProfile.getEmail();
    	new OnlineDBConnector()
    	.passwordreset(email);
    }
    
    
    public void clickReturnToLogin() {
        verifyAndClick(pageProperties.getProperty("BGBLogin.returnLogin"), "ReturnLogin");


    }

     public void clickLogin() {
        verifyAndClick(pageProperties.getProperty("BGBLogin.login"), "Login");

    }
    public void clickLoginHome() {
    if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BGBLogin.loginHome"))) {
        verifyAndClickWithXpath(pageProperties.getProperty("BGBLogin.loginHome"), "Login in Home Page");
    }else {
    openLoginPage();
    }

    }

    public void enterEmailAddress() {
        verifyAndInputById(pageProperties.getProperty("BGBLogin.emailID"), "Email ID Text Box", registrationProfile.getEmail());


    }

    public void enterPassword(String password) {
        verifyAndInputById(pageProperties.getProperty("BGBLogin.password"), "Password Text Box", password);

    }

    public void setNewPassword() {
        verifyAndInputById(pageProperties.getProperty("BGBLogin.tempPasswordText"), "TempPassword Text Box", registrationProfile.getConfPassword());
        verifyAndInputById(pageProperties.getProperty("BGBLogin.password"), "Password Text Box", registrationProfile.getPassword());
        verifyAndInputById(pageProperties.getProperty("BGBLogin.rePassword"), "Confirm Password Text Box", registrationProfile.getPassword());
        verifyAndClick(pageProperties.getProperty("BGBLogin.continueButton"), "Continue Button");

    }
    public void setNewPasswordNew() {
        verifyAndInputById(pageProperties.getProperty("BGBLogin.tempPasswordText"), "TempPassword Text Box", registrationProfile.getConfPassword());
        verifyAndInputById(pageProperties.getProperty("BGBLogin.password"), "Password Text Box","password13");
        verifyAndInputById(pageProperties.getProperty("BGBLogin.rePassword"), "Confirm Password Text Box", "password13");
        verifyAndClick(pageProperties.getProperty("BGBLogin.continueButton"), "Continue Button");
        browser.wait(2000);
    }
    public void loginwithResetPassword(RegistrationProfile registrationProfile) {
    	browser.wait(4000);
        verifyAndInputById(pageProperties.getProperty("BGBLogin.emailID"), "Email ID Text Box", registrationProfile.getEmail());
        verifyAndInputById(pageProperties.getProperty("BGBLogin.password"), "Password Text Box", "password13");
        verifyAndClick(pageProperties.getProperty("BGBLogin.login"), "Login Button");
        browser.wait(4000);
    }
    
    
    
    public void setNewPasswordInv(String tempPass, String newPass, String confNewPass) {
        verifyAndInputById(pageProperties.getProperty("BGBLogin.tempPasswordText"), "TempPassword Text Box", tempPass);
        verifyAndInputById(pageProperties.getProperty("BGBLogin.password"), "Password Text Box", newPass);
        verifyAndInputById(pageProperties.getProperty("BGBLogin.rePassword"), "Confirm Password Text Box", confNewPass);
        verifyAndClick(pageProperties.getProperty("BGBLogin.continueButton"), "Continue Button");

    }

    public void changeToActiveUser(String email) {

        String query = "update [BGB_Synergy].[dbo].[T_ONLINE_USER] set ind_active=1 where txt_online_user_name='" + email + "'";

        executeQuerySynergy(query);

    }
    
    public void resetToTestPassword() {
	OnlineDBConnector online=new OnlineDBConnector();
	online.updateTestPassword(registrationProfile.getEmail());
    }
    public void resetToDefPassword() {
	OnlineDBConnector online=new OnlineDBConnector();
	online.updateDefPassword(registrationProfile.getEmail());
    }

    public void changeToDeActiveUser(String email) {
        String query = "update [BGB_Synergy].[dbo].[T_ONLINE_USER] set ind_active=0 where txt_online_user_name='" + email + "'";
        //System.out.println(query);
        executeQuerySynergy(query);

    }
    
    public void verifyDatabase(String systemDate){    	
    	OnlineDBConnector online=new OnlineDBConnector();
    	String auditType=online.getAuditTypeMs(registrationProfile.getEmail(), systemDate);
    	String auditEventType=online.getAuditType(auditType);
    	String transType=online.getTransactionTypeMs(registrationProfile.getEmail(), systemDate);
    	String transEventType=online.getTransType(transType);
    	if(auditEventType.equals("LOGIN_SUCCESSFUL")){
    		 Report.updateTestLog("Audit Type " + auditEventType + " has been updated successfully during Login", "PASS");	
    	}
    	else{
    		 Report.updateTestLog("Audit Type " + auditEventType + " has not been updated successfully during Login", "FAIL");
    	}
    	if(transEventType.equals("LOGIN")){
    		 Report.updateTestLog("Transaction Type " + transEventType + " has been updated successfully during Login", "PASS");
    	}
    	else{
    		 Report.updateTestLog("Audit Type " + transEventType + " has not been updated successfully during Login", "FAIL");
    	}    		
    }

    private void executeQuerySynergy(String query) {

        Connection conn = null;
        String connectionString = "jdbc:sqlserver://wycvwappx040;user=MSOnline-developers;password=Slamm$R@ge";
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionString);
            Statement st = conn.createStatement();
            int i = st.executeUpdate(query);
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn = null;
        }
    }

    public void verifySessionLayout() {
	 Calendar calendar = Calendar.getInstance();
        for (int i = 1; i <= 19; i++) {
            browser.wait(59990);           
        }
        browser.wait(5000);
//        for(int i=1;i<=4;i++)
//            browser.wait(59990);
//        Calendar calendar1 = Calendar.getInstance();
//	System.out.println(calendar1.getTime());
//        System.out.println(calendar.getTime());
        if (browser.isTextPresent("Secure connection: You are about to be logged out")) {
            Report.updateTestLog("Session layout text displayed", "PASS");
        } else {
            Report.updateTestLog("Session layout text not displayed", "FAIL");
        }
        verifyAndClickWithXpath(pageProperties.getProperty("BGBLogin.keepMeLoggedInButton"),"Keep me logged in button");
      
    }
    public void verifySessionLayoutClose() {
         //  for (int i = 1; i <= 19; i++) {
          //     browser.wait(59990);           
          // }
   	for(int i=1;i<=4;i++)
           browser.wait(59990);

           if (browser.isTextPresent("Secure connection: You are about to be logged out")) {
               Report.updateTestLog("Session layout text displayed", "PASS");
           } else {
               Report.updateTestLog("Session layout text not displayed", "FAIL");
           }
           verifyAndClickWithXpath(pageProperties.getProperty("BGBLogin.closeSessionTimeout"),"Close Session");
           browser.wait(2000);
          if( browser.isElementVisibleWithXpath("//a[@href='/business/corporate/']")) {
              Report.updateTestLog("Session Log out","PASS");
          }
          else {
              Report.updateTestLog("Session not log out","FAIL");
          }
         
       }
    public void verifyDbResetPass(String emailId,String systemDate,String expAuditType){    	
    	OnlineDBConnector online=new OnlineDBConnector();
    	int auditEventType=online.getAuditTypeId(expAuditType);    
    	//System.out.println("atype"+emailId+systemDate+auditEventType);
    	int auditType=online.getAuditTypeIdMs(emailId, systemDate, auditEventType);
    		
    	if(auditType >0){
    		 Report.updateTestLog("Audit Type " + expAuditType + " has been updated successfully during Login", "PASS");	
    	}
    	else{
    		 Report.updateTestLog("Audit Type " + expAuditType + " has not been updated successfully during Login", "FAIL");
    	}
    	  		
    }
}
