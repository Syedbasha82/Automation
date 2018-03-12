package bg.framework.app.functional.page.common;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.DirectDebit;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SshClient;
import bg.framework.app.functional.page.common.SlingshotErrorMessages;
import bg.framework.common.functional.UIOperation;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jcraft.jsch.JSchException;

public class LegacyLoginPage extends BasePage  {

	private final static String FILE_NAME = "resources/common/LoginPage.properties";

	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	private static String dataXml;
	private static String strPwd = "temp1234" ;
	private static int BGBUSINESS_LOGOUT_SUCCESSFUL = 25;
	SlingshotErrorMessages errormsg = new SlingshotErrorMessages();
	public void loginUser(UserProfile userProfile) {

		final String expectedEmailAdd = new OnlineDBConnector().getUserEmail(userProfile.getUCRN());
		//browser.open("http://10.224.70.18/content/bgbusiness/youraccount/bgbusiniessLogin.html");
		browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("LoginPage.LoginUrl"));
		verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id", expectedEmailAdd);
		//verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id", userProfile.getEmail());
		verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password", userProfile.getPassword());
		//browser.clickWithClass(pageProperties.getProperty("LoginPage.LoginSubmitClass"));
		browser.clickWithXpath(pageProperties.getProperty("LoginPage.NewLoginSubmitXpath"));
		browser.wait(getWaitTime());
		continueToMyAccount();
		//closeInfoOverlay();
	}

	public void closeInfoOverlay(){
		if(browser.isElementVisible(pageProperties.getProperty("LoginPage.InfOverlay"))){       		
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LoginPage.closeOverlay"))){
				browser.clickWithXpath(pageProperties.getProperty("LoginPage.closeOverlay"));
				browser.wait(getWaitTime());
			}
		}
	}
	public void continueToMyAccount(){
		browser.wait(3000);
		if(browser.isElementVisibleWithXpath(".//*[@id='splash_overlay']/div/div[3]/div[2]/div/p[6]/span/a")){
			browser.clickWithLinkText("Continue to my account");
		}
		if (browser.isElementVisibleWithXpath(pageProperties.getProperty("LoginPage.welcomeMessage"))) {
			Report.updateTestLog("User logged in Successfully", "PASS");
			browser.clickWithXpath(pageProperties.getProperty("LoginPage.welcomeMessage"));
		}
	}
	public void loginUserAutoDirectToContactUsPage(UserProfile userProfile) {
		loginUser(userProfile);

	}

	public void navigateToChangeEmailAddress() {
		verifyAndClickWithLinkText(pageProperties.getProperty("LoginPage.ChangeEmailAddressLink"), "Change My Email Address Link");
	}

	public void navigateToForgottenEmailAddress() {
		verifyAndClickWithLinkText(pageProperties.getProperty("LoginPage.ForgottenEmailAddressLink"), "I've Forgotten my Email Address Link");
		browser.wait(getWaitTime());
	}

	public void navigateToForgottenPassword() {
		verifyAndClickWithLinkText(pageProperties.getProperty("LoginPage.ForgottenPasswordLink"), "I've Forgotten My Password Link");
	}

	public void navigatetoForgotEmailPage() {
		if (browser.isElementVisibleWithXpath(pageProperties.getProperty("LoginPage.ForgotEmailID"))) {
			browser.clickWithXpath(pageProperties.getProperty(("LoginPage.ForgotEmailID")));
			browser.wait(getWaitTime());
		}
	}

	public void navigatetoForgotEmailViaForgotPassword() {
		browser.clickWithXpath(pageProperties.getProperty("LoginPage.ForgotPasswordID"));
		browser.wait(getWaitTime());
		if (browser.isElementVisibleWithXpath(pageProperties.getProperty("LoginPage.ForgotEmailID"))) {
			browser.clickWithXpath("//a[contains(@title,'forgotten my')]");
		}
	}

	public void verifyAccountLock(UserProfile userProfile) {
		OnlineDBConnector onlinedbconnector = new OnlineDBConnector();
		onlinedbconnector.dbAccountunlock(userProfile.getUCRN());

		String[] password = new String[3];
		password[0] = "pass1";
		password[1] = "pass2";
		password[2] = "pass3";
		for (int i = 0; i < 3; i++) {
			browser.wait(1000);
			userProfile.setPassword("pass");
			loginUser(userProfile);
			if (verifyIsTextPresent(GlobalErrorMessages.NEW_NEW_BLUE_LOGINTRYCOUNT_1)) {
				Report.updateTestLog("invalid password login attempt 1", "PASS");
			}
			browser.wait(1000);
			loginUser(userProfile);
			if (verifyIsTextPresent(GlobalErrorMessages.NEW_NEW_BLUE_LOGINTRYCOUNT_2)) {
				Report.updateTestLog("invalid password login attempt 2", "PASS");
			}
			loginUser(userProfile);
			if (verifyIsTextPresent(GlobalErrorMessages.NEW_NEW_BLUE_LOGINTRYCOUNT_3)) {
				Report.updateTestLog("Account is locked after 3 attempts", "PASS");
			} else {
				Report.updateTestLog("Account is not locked", "FAIL");
			}
		}
		int freeze_acct = onlinedbconnector.getLoginTryCount(userProfile.getUCRN());
		if (freeze_acct == 3) {
			Report.updateTestLog("DB Account Lock verification ", "PASS");
		} else {
			Report.updateTestLog("DB Account Lock verification ", "FAIL");
		}
	}

	public void loginErrorValidation(UserProfile userProfile) {
		String[] errormsg = new String[3];
		errormsg[0] = "The email address or password you have entered is incorrect.";
		errormsg[1] = "A required field has not been completed.";
		String[] EmailID = new String[3];
		EmailID[0] = "prathap898@centrica.com";
		EmailID[1] = "prathap898@centrica.com";
		EmailID[2] = userProfile.getEmail();
		String[] password = new String[3];
		password[0] = "pass1";
		password[1] = "";
		password[2] = userProfile.getPassword();
		for (int i = 0; i < 3; i++) {
			browser.wait(1000);
			browser.input(pageProperties.getProperty("LoginPage.Email"), EmailID[i]);
			Report.updateTestLog("Login with email id:" + userProfile.getEmail(), "DONE");
			browser.input(pageProperties.getProperty("LoginPage.Password"), password[i]);
			browser.clickWithClass(pageProperties.getProperty("LoginPage.LoginSubmitClass"));
			browser.wait(1000);
			String expectedName = errormsg[i];
			if (i == 0) {
				String actualName1 = browser.getTextByXpath(pageProperties.getProperty("LoginPage.loginerror1"));
				if (expectedName.equalsIgnoreCase(actualName1)) {
					Report.updateTestLog("Login error by using wrong password and username", "PASS");
				} else {
					Report.updateTestLog("Login error by using wrong password and username", "FAIL");
				}
			}
			if (i == 1) {

				String actualName2 = browser.getTextByXpath(pageProperties.getProperty("LoginPage.loginerror2"));
				if (expectedName.equalsIgnoreCase(actualName2)) {
					Report.updateTestLog("Login error by using wrong password and username", "PASS");
				} else {
					Report.updateTestLog("Login error by using wrong password and username", "FAIL");
				}
			}
		}
	}

	public void loginForInactiveAccount(UserProfile userProfile) {
		loginUser(userProfile);
		String expectedName;
		expectedName="This is because you haven't used it for over 6 months. Give us a call on 0800 048 0505 and we can get your account back online quickly and easily.";
		String actualName = browser.getTextByXpath(pageProperties.getProperty("LoginPage.logininactive1"));

		if (actualName.contains(expectedName)) {
			Report.updateTestLog("Error message while Login account inactive  pastdate greater than 6 mths", "PASS");
		} else {
			Report.updateTestLog("Error message while Login account inactive  pastdate greater than 6 mths", "FAIL");
		}
	}

	public void emailCheckBoxVerification(UserProfile userProfile) {
		browser.wait(1000);
		browser.input(pageProperties.getProperty("LoginPage.Email"),
				userProfile.getEmail());
		Report.updateTestLog("Login with email id:" + userProfile.getEmail(), "DONE");
		browser.input(pageProperties.getProperty("LoginPage.Password"),
				userProfile.getPassword());
		Report.updateTestLog("Login with password:" + userProfile.getPassword(), "DONE");
		browser.click(pageProperties.getProperty("LoginPage.EmailCheckBox"));
		Report.updateTestLog("Email check box is clicked", "DONE");
		browser.clickWithXpath(pageProperties.getProperty("LoginPage.LoginSubmitClass"));
		browser.wait(1000);
		verifyPageTitle("Log in");
		continueToMyAccount();
		Report.updateTestLog("Login to application", "DONE");
		browser.wait(2000);
		String title=browser.getTextByXpath("//title");
		verifyPageTitle("Account overview");
		browser.clickWithXpath(pageProperties.getProperty("LoginPage.LogOut"));
		//browser.clickWithLinkText(pageProperties.getProperty("LoginPage.LogOut"));
		Report.updateTestLog("Logout of application", "DONE");
		String actualValue = browser.getAttribute(pageProperties.getProperty("LoginPage.Email"),"value");
		if (actualValue.contains(userProfile.getEmail())) {
			Report.updateTestLog("Email Populated in text box", "PASS");
		} else {
			Report.updateTestLog("Email is not Populated in text box", "FAIL");
		}
		browser.click(pageProperties.getProperty("LoginPage.EmailCheckBox"));


	}
	public void logOut(){
		verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.LogOut"),"Log out Link");
		getWaitTime();
		browser.wait(3000);
	}
	public void loginUserDetails(UserProfile userProfile) {
		final String expectedEmailAdd = new OnlineDBConnector().getUserEmail(userProfile.getUCRN());
		verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id", expectedEmailAdd);
		verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password", userProfile.getPassword());
		browser.clickWithXpath(pageProperties.getProperty("LoginPage.NewLoginSubmitXpath"));
		browser.wait(getWaitTime());
		continueToMyAccount();

	}
	public void verifyLastLoginTimestampOverlay(){
		if(browser.isElementVisible(pageProperties.getProperty("LoginPage.LastLoginsixmonthOverlay"))){
			verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.updateMyDetailsButton"),"updateMyDetailsButtonUpdate My Details Button");
			browser.wait(3000);
			String strTitle = browser.getTextByXpath("//title");
			if(strTitle.contains(pageProperties.getProperty("LoginPage.updateYourDetails"))){

			}
		}
	}
	public void calllogs_test(String strStatus, String intAccNumber, String intUCRN ){

		SshClient sshClient= new SshClient();
		try {
			sshClient.connect(); 
			//PrintWriter out = new PrintWriter("C:\\Documents and Settings\\!boobalas\\My Documents\\Check_Putty.txt");
			if(sshClient.isConnected()){
				System.out.println(sshClient.send("cd domains/wl_fit/crx-quickstart/logs"));
				System.out.println(sshClient.send("cp error.log putty_current.txt"));
				dataXml = sshClient.send("tail -n 1000 putty_current.txt");
				System.out.println(dataXml);

				if (dataXml.contains(intUCRN)) {        
					System.out.println("UCRN Verification is successful and  UCRN is Present in Response log" + intUCRN); 
					Report.updateTestLog("UCRN Verification is successful and  UCRN Number is Present in Response log; UCRN Number = " + intUCRN, "PASS");

					if(dataXml.contains(intAccNumber)){
						System.out.println("Account Number Verification is successful and  Account Number is Present in Response log" + intAccNumber);
						Report.updateTestLog("Account Number Verification is successful and  Account Number is Present in Response log is " + intAccNumber, "PASS");
					}
					else{
						Report.updateTestLog("Account Number Verification is NOT successful", "Warning");
					}
					if(dataXml.contains(strStatus)){
						System.out.println("Account Status Verification is successful" + strStatus);
						Report.updateTestLog("Account Status Verification is successful; Status = " + strStatus, "PASS");
					}
					else{
						Report.updateTestLog("Account Status Verification is NOT successful " , "Warning");
					}       	          

				} 

				else {
					System.out.println("UCRN Verification is not present in Response log" + intUCRN);
					Report.updateTestLog("UCRN Verification is NOT successful ", "Warning");
				} 
				//out.println(sshClient.send("cat putty_current.txt"));
			}		
			System.out.println("Log validated did not find some contets.");
		} catch (JSchException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public LegacyLoginPage BgbloginUser(UserProfile userProfile) {	
	    browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("LoginPage.LoginUrl"));
	 	browser.wait(getWaitTime());
	 	browser.wait(10000);
	 	Report.updateTestLog("Web T Login Page is displayed", "WARN");
		BgbLoginEmail(userProfile.getEmail());
		BgbLoginPassword(userProfile.getPassword());
		Report.updateTestLog("UserName and Password is enetered successfully", "WARN");
		//verifyAndSelectCheckBoxByID(pageProperties.getProperty("LoginPage.RememberEmail"), "Remember Email");
		BgbLoginSubmit();
		browser.wait(getWaitTime());
		Report.updateTestLog("Account Overview page is dipslayed Successfully", "WARN");
		return this;
	}
	public LegacyLoginPage BgbloginPage() {	
	    browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("LoginPage.LoginUrl"));
	 	browser.wait(getWaitTime());
	 	browser.wait(10000);
		/*BgbLoginEmail(userProfile.getEmail());
		BgbLoginPassword(userProfile.getPassword());*/
		//verifyAndSelectCheckBoxByID(pageProperties.getProperty("LoginPage.RememberEmail"), "Remember Email");
		//BgbLoginSubmit();
		browser.wait(getWaitTime());
		Report.updateTestLog("Login PAge is displayed in the Login Page", "WARN");
		return this;
	}
	
	public void BgbLoginEmail(String email){
		//verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id", email);
		//verifyAndInputByXpath(pageProperties.getProperty("LoginPage.EmailXpath"), "email", email);
		WebDriver driver = null;
		 WebElement emailid =driver.findElement(By.xpath("//*[@name='email']"));
		 
		 
	}
	
	public void BgbLoginEmailNew(UserProfile userProfile){
		browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("LoginPage.LoginUrl"));
	 	browser.wait(getWaitTime());
	 	browser.wait(10000);
	 	Report.updateTestLog("Web T Login Page is displayed", "WARN");
		browser.Enterinput(userProfile.getEmail());
		browser.EnterPassword(userProfile.getPassword());
		Report.updateTestLog("Login Credentials Entered Successfully", "WARN");
		browser.clicksubmit();
		
		 
	}
	
	public void BgbLoginPassword(String password){
		//verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password", password);
		verifyAndInputByXpath(pageProperties.getProperty("LoginPage.PasswordXpath"), "Password", password);
		

	}
	public void BgbLoginSubmit(){
		//verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.NewLoginSubmitXpath"), "Submit button");
		verifyAndClickWithXpath(pageProperties.getProperty("Login.LoginButton"), "Submit button");

	}

	public void ClickGoToBusinessSite(UserProfile userProfile) {
		verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.GotoBusinessLink"), "GoToBusinessSite");
		browser.wait(getWaitTime());
	}
	public void EnterInvalidEmailorPass(UserProfile userProfile) {
		browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("LoginPage.LoginUrl"));
		browser.wait(getWaitTime());
		verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id","S3e4r5t6u@bgtest.co.uk");
		verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password", userProfile.getPassword());
		browser.clickWithXpath(pageProperties.getProperty("LoginPage.NewLoginSubmitXpath"));
		browser.wait(getWaitTime());   
	}

	public void VerifyPrePopulateEmailorPass(UserProfile userProfile) {
		String prepopulate=browser.getAttribute(pageProperties.getProperty("LoginPage.Email"),"value");
		if (prepopulate.equalsIgnoreCase(userProfile.getEmail()))
		{
			Report.updateTestLog("Prepopulate email id is displayed(Remember Email)", "Pass");
			Report.updateTestLog("Login details are auto populated","WARN");
		}
		else
		{
			Report.updateTestLog("Prepopulate email id is not displayed(Remember Email)"+"Prepopulated id is :"+prepopulate+"Given email is:"+userProfile.getEmail(), "Fail");
		}
	}

	public void CheckRememberEmail(UserProfile userProfile) {

		verifyCheckBoxSelectedWithXpath(pageProperties.getProperty("LoginPage.RemembermyEmail"),"Remember check box");

	}

	public void loginEmailErrorMessageValidation(UserProfile userProfile) {

		String[] email = new String[4];
		email[0]="";
		email[1]="qw2w3w3w@bgtest.co.uk";
		email[2]="length60";
		email[3]="smartinsight_25@smart@bgtest.co.uk";
		String Email = "Emailvalidation";
		enterInvalidEmail(userProfile,email[0],Email);
		getErrorMsgLoginscreen(errormsg.Login_EmailEmpty);
		enterInvalidEmail(userProfile,email[1],Email);
		getErrorMsgLoginscreen(errormsg.Login_EmailNotRegistered);
		enterInvalidEmail(userProfile,email[3],Email);
		getErrorMsgLoginscreen(errormsg.Login_EmailInccorectFormat);
	}

	public void loginPasswordErrorMessageValidation(UserProfile userProfile) {
		String[] pass = new String[3];
		pass[0]="";
		pass[1]="qw2w3w3w@bgtest.co.uk";
		enterInvalidEmail(userProfile,pass[0],"Passwordvaldiation");
		getErrorMsgLoginscreen(errormsg.Login_PasswordEmpty);
		enterInvalidEmail(userProfile,userProfile.getEmail(),"Passwordvaldiation");
		getErrorMsgLoginscreen(errormsg.Login_PasswordIncorrect);

	}
	public void enterInvalidEmail(UserProfile userProfile,String value,String Validation){
		if(Validation=="Emailvalidation"){
			if(value=="length60"){
				String emailInv="SmartinsightsmartinsightsmartinsightSmartinsight@bgtest.co.uk";	
				verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id",emailInv);
			}else{
				verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id",value);		
			}
			verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password", userProfile.getPassword());
			browser.clickWithXpath(pageProperties.getProperty("LoginPage.NewLoginSubmitXpath"));
		}else{
			verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id",userProfile.getEmail());
			verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password", value);
			browser.clickWithXpath(pageProperties.getProperty("LoginPage.NewLoginSubmitXpath"));
		}
		getWaitTime();
	}

	public void getErrorMsgLoginscreen(String emailErrorMessage) {
		try{
			String errormsgvalue=browser.getTextByXpath(pageProperties.getProperty("LoginPage.ErrorMessageDisplayed"));

			Report.updateTestLog("Login screen-Error msg Expected Result: "+emailErrorMessage+" Actual Result: "+errormsgvalue,errormsgvalue.contains(emailErrorMessage)?"Pass":"Fail");
		}catch(Exception e){
			Report.updateTestLog("Error locating xpath in error msg section :"+e, "Fail");
		}

	}

	public void enterEmailCaseSensitive(UserProfile userProfile) {

		String emailCase=userProfile.getEmail();
		if ((emailCase != null) && (emailCase.contains("@") )){
			try{
				String[] emailsplit=emailCase.split("@");
				boolean isuppercase=Character.isUpperCase(emailsplit[0].charAt(0));
				if (isuppercase){
					String convertEmaillower=emailsplit[0].toLowerCase();
					String convertEmailid=emailsplit[1].toLowerCase();
					verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id",convertEmaillower+"@"+convertEmailid); 
				}else{
					String convertEmaillower=emailsplit[0].toUpperCase();
					String converEmailid=emailsplit[1].toUpperCase();
					verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id",convertEmaillower+"@"+converEmailid); 
				}
			}catch(Exception e){
				Report.updateTestLog("Exception when the string is converted to uppercase or lower case :"+e, "Fail");
			}

			verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password", userProfile.getPassword());
			verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.NewLoginSubmitXpath"), "Submit button");
			//browser.clickWithXpath(pageProperties.getProperty("LoginPage.NewLoginSubmitXpath"));
			browser.wait(getWaitTime());
			//continueToMyAccount();
			//closeInfoOverlay();
		}else{
			Report.updateTestLog("Email address in the userprofile.xml file is null/Invalid :"+emailCase, "Fail");
		}

	}

	public void verifyBrowserBackPage(UserProfile userProfile) {
		browser.browserBack();
		browser.wait(getWaitTime());
		verifyIsTextPresent("Log in");	 
	}

	public void closeBrowser() {
		browser.close();
		Report.updateTestLog("Browser Closed succesfully", "Pass");
	}

	public void loginErrorMsgPage(){

	}

	public void verifyLoginErrorFreezeAccount(UserProfile userProfile){
		new OnlineDBConnector().updateFreezeAccountStatus(userProfile, "Y","INACTIVE");
		BgbloginUser(userProfile);
		getErrorMsgLoginscreen(SlingshotErrorMessages.Login_FreezeAccount);
		new OnlineDBConnector().updateFreezeAccountStatus(userProfile, "N","ACTIVE");
	}

	public void verifyLoginErrorForInactiveUser(UserProfile userProfile){
		new OnlineDBConnector().updateIsEmailValidationFlag(userProfile, "N","INPROGRESS");
		BgbloginUser(userProfile);
		getErrorMsgLoginscreen(SlingshotErrorMessages.Login_InprogressAccount);
		new OnlineDBConnector().updateIsEmailValidationFlag(userProfile, "Y","ACTIVE");
	}
	public void verifyAndClickForgottenEmailLink(){
   browser.wait(3000);
	verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.ForgottenEmaillinkNew"), "I've forgotten my email");
		/*if(verifyIsTextPresent("Log in to your business account")){
			Report.updateTestLog("Login into your account page is displayed", "WARN");
			System.out.println("zeesssssssssssssss");
			//verifyIsElementVisibleWithXpath(pageProperties.getProperty("LoginPage.ForgottenEmaillink"), "I've forgotten my email");
			verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.ForgottenEmaillinkNew"), "I've forgotten my email");
		}*/
	}

	public void verifyAndClickForgottenPasswordLink(){

		if(verifyIsTextPresent("Your account")){
			browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("LoginPage.LoginUrl"));
			browser.wait(getWaitTime());
			if(verifyIsTextPresent("Log in")){
				verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.ForgottenPasswordLink"), "I've forgotten my password");
				browser.wait(getWaitTime());
			}
			else {
				Report.updateTestLog("Log in page is displayed", "FAIL");
				verifyIsElementVisibleWithXpath(pageProperties.getProperty("LoginPage.ForgottenPasswordLink"), "I've forgotten my password");
			}}
	}
	public void verifyAuditDetails(UserProfile userProfile){
		OnlineDBConnector dbFunctions = new OnlineDBConnector();
		String sysDate = dbFunctions.DBsysdateDdmmyyhhmi(); 
		dbFunctions.verifyAuditDetails(sysDate,BGBUSINESS_LOGOUT_SUCCESSFUL);
		int getAudittype=dbFunctions.getAuditTypeIdMs(userProfile.getEmail(), sysDate, BGBUSINESS_LOGOUT_SUCCESSFUL);
		if(getAudittype>=1){
			Report.updateTestLog("Audit entry is made as expected: "+BGBUSINESS_LOGOUT_SUCCESSFUL, "PASS");

		}else{
			Report.updateTestLog("Audit entry is made as expected: "+BGBUSINESS_LOGOUT_SUCCESSFUL, "FAIL");
		}

	}
	public void verifyLoginTryCount(UserProfile userProfile){
		OnlineDBConnector db= new OnlineDBConnector();
		String loginTryCount =db.verifyLoginTryCount(userProfile.getEmail());
		if (loginTryCount.equals(0)){
			Report.updateTestLog("Login Try Count is '0' so you can continue ", "PASS");
		}
		else{
			db.updateDB("update bg_business_ta_customer_reg set LOGIN_TRY_COUNT = '0' where email = '"+userProfile.getEmail()+"'");
			db.updateDB("commit");
			Report.updateTestLog("Login Try Count is set to '0'", "PASS");    	
		}
	}
	public void setUpperCasePassword(UserProfile userProfile){	
		browser.wait(getWaitTime());
		if(browser.isTextPresent("Your account")){
		}
		else{
			browser.open(ApplicationConfig.APP_BG_URL); 
		}
		verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id", userProfile.getEmail());
		verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password",strPwd.toUpperCase());
		verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.LoginButtonXpath"), "Log in");
		browser.wait(getWaitTime());
	}

	public void loginWithUpperCaseEmailId(UserProfile userProfile){
		browser.open(ApplicationConfig.APP_BG_URL);
		browser.wait(getWaitTime());
		if(browser.isTextPresent("Your account")){
		}
		else{
			browser.open(ApplicationConfig.APP_BG_URL); 
		}
		verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id", userProfile.getEmail().toUpperCase());
		verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password",userProfile.getPassword());
		verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.LoginButtonXpath"), "Log in");
		browser.wait(getWaitTime());
	}
	public void loginWithNewPassword(String Pwd, UserProfile userProfile){
		if(browser.isTextPresent("Your account")){
			browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("LoginPage.LoginUrl"));
			browser.wait(getWaitTime());
			if(browser.isTextPresent("Your account")){

			}
			else{
				browser.open(ApplicationConfig.APP_BG_URL); 
			}
			OnlineDBConnector onlinedbconnector = new OnlineDBConnector();
			String password=  onlinedbconnector.getPasswordUsingEmail(userProfile.getEmail());	
			verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id", userProfile.getEmail());
			verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password",Pwd); 
			verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.LoginButtonXpath"), "Log in");
			browser.wait(getWaitTime()); 
		}
	}
	public void loginWithNewEmail(UserProfile userProfile){
		if(browser.isTextPresent("Your account")){
		}
		else{
			browser.open(ApplicationConfig.APP_BG_URL); 	
		}	 	
		verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id", userProfile.getEmail());
		OnlineDBConnector db = new OnlineDBConnector();
		String pwd = db.getPasswordUsingEmail(userProfile.getEmail());
		try{
			if(pwd.equals("n4Kp6Mk+aaGmJ2pzjQswYmp8o44="))
			{
				verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password",strPwd); 
			}
			else if(pwd.equals("EMKPnPBmhZXUXBCQp7Sirpjt+lg=")){					
				verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password",userProfile.getPassword()); 
			}
			else{
				Report.updateTestLog("Please check the passsword in DB", "FAIL");
			}
			verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.LoginButtonXpath"), "Log in");
			browser.wait(getWaitTime());
		}
		catch(Exception e){
			Report.updateTestLog("Exception occured" + e, "FAIL");
		}
	}
	public void EnterInvalidPwd(UserProfile userProfile){
		browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("LoginPage.LoginUrl"));
		browser.wait(getWaitTime());
		verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id", userProfile.getEmail());
		verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password",userProfile.getPassword().toUpperCase());
		verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.LoginButtonXpath"), "Log in");
		browser.wait(getWaitTime());    
	}
	public void checkLoginTryCountToThree(UserProfile userProfile){
		try{
			OnlineDBConnector db= new OnlineDBConnector();
			String loginTryCount =db.verifyLoginTryCount(userProfile.getEmail());
			if (loginTryCount != null){
				//Report.updateTestLog("Login Try Count is '3' so you can continue ", "PASS");
				
				if(loginTryCount.equals(3))
					db.updateDB("update bg_business_ta_customer_reg set LOGIN_TRY_COUNT = '1' where email = '"+userProfile.getEmail()+"'");
				db.updateDB("commit");
			}
			else{
				db.updateDB("update bg_business_ta_customer_reg set LOGIN_TRY_COUNT = '1' where email = '"+userProfile.getEmail()+"'");
				db.updateDB("commit");
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public void verifyErrorMessageAndClickForgottenPasswordLink(){
		if(verifyIsTextPresent("Your account")){
			String errorMsg = browser.getTextByXpath(pageProperties.getProperty("LoginPage.ErrorMessageDisplayed"));
			if (errorMsg.contains(SlingshotErrorMessages.slingshot_FP_loginTryCountErrorline1)){
				Report.updateTestLog("Displayed error message: "+errorMsg+"Actual error message: "+SlingshotErrorMessages.slingshot_FP_loginTryCountErrorline1, "PASS");
			}
			else {
				Report.updateTestLog("Displayed error message: "+errorMsg+"Actual error message: "+SlingshotErrorMessages.slingshot_FP_loginTryCountErrorline1, "PASS");
			}
			verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.ResettingPasswordLink"), "Resetting your password link");
		}
		else {
			Report.updateTestLog("Your account page is displayed", "FAIL");
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("LoginPage.ForgottenPasswordLink"), "I've forgotten my password");

		}
	}

	public void verifyErrorMessageLogin(){
		getErrorMsgLoginscreen(errormsg.Login_EmailNotValidated);

	}

	public void verifyErrorMessageFreezeaccount(){
		getErrorMsgLoginscreen(errormsg.Login_FreezeAccount);
	}	

	public void resetLoginTryCount(UserProfile userProfile){
		OnlineDBConnector db= new OnlineDBConnector();
		String loginTryCount =db.verifyLoginTryCount(userProfile.getEmail());
		if (loginTryCount.equals(0)){
			System.out.println("Login Try Count is '0' so you can continue ");
		}
		else{
			db.updateDB("update bg_business_ta_customer_reg set LOGIN_TRY_COUNT = '0' where email = '"+userProfile.getEmail()+"'");
			db.updateDB("commit");   
			System.out.println("Login Try Count is not set to '0' so you can't continue ");}}


	public void loginWithMPDChangeData(String strEmail,String strTempPwd,UserProfile userProfile,int loginType){
		OnlineDBConnector db =new OnlineDBConnector();
		try{
			String strEmailUpdated = db.getEmailUsingBP(userProfile.getBpnumber());
			verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id", strEmail);
			String strPasswordUpdated = db.getPasswordUsingEmail(strEmail);

			switch(loginType){
			case 0:
				if(strPasswordUpdated.equals("n4Kp6Mk+aaGmJ2pzjQswYmp8o44="))
				{
					verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password",strTempPwd);
					verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.LoginButtonXpath"), "Log in");
					browser.wait(getWaitTime());
				}
				else{
					//Report.updateTestLog("check password updation", "FAIL");
					verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password",userProfile.getPassword());
					verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.LoginButtonXpath"), "Log in");
					browser.wait(getWaitTime());}
				break;

			case 1:
				if(strPasswordUpdated.equals("n4Kp6Mk+aaGmJ2pzjQswYmp8o44="))
				{					
					verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password",strTempPwd.toUpperCase());
					verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.LoginButtonXpath"), "Log in");
					browser.wait(getWaitTime());
				}
				else{
					verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password",userProfile.getPassword().toUpperCase());
					verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.LoginButtonXpath"), "Log in");
					browser.wait(getWaitTime());}
				break;
			case 2:			
				verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id", strEmailUpdated.toUpperCase());
				verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password",userProfile.getPassword());
				verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.LoginButtonXpath"), "Log in");
				browser.wait(getWaitTime());				
				break;
			}
		}
		catch(Exception e){

		}
	}
	public void loginWithMPDChangeData_new(UserProfile userProfile){
		browser.wait(getWaitTime());
	 	browser.wait(10000);
		BgbLoginEmail(userProfile.getNewEmail());
		BgbLoginPassword(userProfile.getPassword());
		Report.updateTestLog("New Email and Password is entered successfully", "WARN");
		BgbLoginSubmit();
		browser.wait(getWaitTime());
			
		
		
	}
	public void loginWithUpdatedEmailAddress(String tempEmail,UserProfile userProfile){
		verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id",tempEmail);
		verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password",userProfile.getPassword());
		verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.LoginButtonXpath"), "Log in");
		browser.wait(getWaitTime());
	}
	public void loginWithUpdatedPassword(String tempPassword,UserProfile userProfile){
		verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id",userProfile.getEmail());
		verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password",tempPassword);
		verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.LoginButtonXpath"), "Log in");
		browser.wait(getWaitTime());
	}
	public void enterPasswordIsCaseSensitive(UserProfile userProfile) {
		verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id",userProfile.getEmail());
		String passwordcase=userProfile.getPassword();
		if (passwordcase != null){
			boolean isuppercase=Character.isUpperCase(passwordcase.charAt(0));
			if (isuppercase){
				String convertpassword=passwordcase.toLowerCase();
				verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password",convertpassword); 
			}else{
				String convertpassword=passwordcase.toUpperCase();
				verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password",convertpassword); 
			}
			verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.NewLoginSubmitXpath"), "Submit button");
			browser.wait(getWaitTime());
		}else{
			Report.updateTestLog("EPassword in the userprofile.xml file is null/Invalid :", "Fail");
		}
		verifyPageTitle(pageProperties.getProperty("LoginPage.LoginPageTitle"));
	}
	public void verifyBrowserBackFunctionality(){
		browser.browserBack();
		browser.wait(getWaitTime());
		if(browser.getTitle().toString().trim().contains("Account overview")){
			Report.updateTestLog("Browser remains in same page when user clicks browser back button in Account overview page", "PASS");
		}
		else{
			Report.updateTestLog("Browser remains in same page when user clicks browser back button in Account overview page", "FAIL");
		}
	}

	public void BgbDirectDebitLogin(DirectDebit directDebit) {
		verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id", directDebit.getEmail());
		verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password", directDebit.getPassword());
		verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.NewLoginSubmitXpath"), "Submit button");
		browser.wait(getWaitTime());
		//continueToMyAccount();
		//closeInfoOverlay();
	}

	public void BgbPassword(String password) {	
		verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password", password);
	}
	public void BgbClickSubmit() {	
		verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.NewLoginSubmitXpath"), "Submit button");
		browser.wait(getWaitTime());
	}
	public void verifyErrorMessageAndClickForgottenEmailLink(){
		if(verifyIsTextPresent("Your account")){
			String errorMsg = browser.getTextByXpath(pageProperties.getProperty("LoginPage.ErrorMessageDisplayed"));
			if (errorMsg.contains(SlingshotErrorMessages.slingshot_FP_loginTryCountErrorline1)){
				Report.updateTestLog("Displayed error message: "+errorMsg+"Actual error message: "+SlingshotErrorMessages.slingshot_FP_loginTryCountErrorline1, "PASS");
				//verifyIsElementVisibleWithXpath(pageProperties.getProperty("LoginPage.ForgottenEmaillink"), "I've forgotten my email");
			}
			else {
				Report.updateTestLog("Displayed error message: "+errorMsg+"Actual error message: "+SlingshotErrorMessages.slingshot_FP_loginTryCountErrorline1, "FAIL");
			}
			verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.ResettingEmailLink"), "Resetting your email link");
		}
		else {
			Report.updateTestLog("Your account page is displayed", "FAIL");
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("LoginPage.ForgottenEmailAddressLink"), "I've forgotten my email address");

		}
	}
	public LegacyLoginPage BgcloginUser(UserProfile userProfile) {	
		//browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("LoginPage.BgcURL"));
		browser.wait(getWaitTime());
		verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id", userProfile.getEmail());	
		verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password", userProfile.getPassword());
		CheckRememberEmail(userProfile);
		verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.NewLoginSubmitXpath"), "Submit button");
		browser.wait(getWaitTime());
		return this;
	}
	public LegacyLoginPage bgcloginUser(UserProfile userProfile) {	
		browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("LoginPage.CorporateLoginUrl"));
		browser.wait(getWaitTime());
		BgbLoginEmail(userProfile.getEmail());
		BgbLoginPassword(userProfile.getPassword());
		BgbLoginSubmit();
		browser.wait(getWaitTime());
		return this;
	}
	
	public LegacyLoginPage BgbloginSetupDDUser(UserProfile userProfile) {	
		//browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("LoginPage.LoginUrl"));
		browser.open(ApplicationConfig.APP_BG_URL+"/business/your-account/login?journey=setupdd&accountnumber=600193960&cid=eMail2DDPercentLogin");
		Report.updateTestLog("Login Page Displayed", "WARN");
		browser.wait(getWaitTime());
		BgbLoginEmail(userProfile.getEmail());
		BgbLoginPassword(userProfile.getPassword());
		BgbLoginSubmitNew();
		browser.wait(getWaitTime());
		return this;
	}
	public void BgbLoginSubmitNew(){
		verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.NewLoginSubmitXpathNew"), "Submit button");
		browser.wait(getWaitTime());
		Report.updateTestLog("Account Summary Page", "Pass");

	}
	public LegacyLoginPage BgbloginUserNew(UserProfile userProfile) {	
	    browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("LoginPage.LoginUrl"));
	 	browser.wait(getWaitTime());
		BgbLoginEmail(userProfile.getNewEmail());
		browser.wait(10000);
		browser.wait(10000);
		BgbLoginPassword(userProfile.getPassword());
		Report.updateTestLog("New Email is entered", "WARN");
		//verifyAndSelectCheckBoxByID(pageProperties.getProperty("LoginPage.RememberEmail"), "Remember Email");
		BgbLoginSubmit();
		browser.wait(getWaitTime());
		Report.updateTestLog("Login Page is loaded", "WARN");
		
		System.out.println("im in login page");
		return this;
	}
	
public void clickManageAccountLink (UserProfile userProfile) {
		
		
		verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.AccountSummary").replace("ACCOUNTNUMBER", userProfile.getAccNumber()),"Manage account link");
		
		
	
		
		
	}
	
	
}

