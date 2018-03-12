package bg.framework.app.functional.page.bgb;

import bg.framework.app.functional.action.bgb.RegistrationAction;
import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.RegistrationProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.common.functional.Verify;

import java.util.Properties;

import static org.apache.commons.lang.StringUtils.isNotEmpty;


public class RegistrationPage extends BasePage {

    private final static String FILE_NAME = "resources/bgb/BGBRegistration.properties";
    private static Properties regpageProperties = new PropertyLoader(FILE_NAME).load();

    private RegistrationProfile registrationProfile;
    // Report report = new Report();
    // String logPath = null;

    private String invalidAccNo;
    RegistrationAction regAction = new RegistrationAction(registrationProfile);

    public RegistrationPage(RegistrationProfile registrationProfile) {
        this.registrationProfile = registrationProfile;
    }

    public RegistrationPage() {
    }

    /*
      ******************************************************************************
           Method :enterRegisterationAccNum


         Description: This method enters Account Number.
      ******************************************************************************
      */
    public void enterRegisterationAccNum() {

        browser.wait(1000);
        verifyAndInputById(regpageProperties.getProperty("BGBRegistration.accountNumber"), "Account No Text Box", registrationProfile.getAccountNumber());


    }

    /*
         ******************************************************************************
              Method :enterRegisterationAccNums


            Description: This method clicks continue button.
         ******************************************************************************
         */
    public void enterRegisterationAccNumWithAlphabet() {

        browser.wait(3000);
        String alphabetAccountNumber[] = new String[2];
        alphabetAccountNumber[0] = "A" + registrationProfile.getAccountNumber();
        alphabetAccountNumber[1] = registrationProfile.getAccountNumber();
        for (int i = 0; i < 2; i++) {
            verifyAndInputById(regpageProperties.getProperty("BGBRegistration.accountNumber"), "Account No Text Box", alphabetAccountNumber[i]);
            registrationContinueAction();
            verifyPersonalDetailsReg();
            openRegPage();
        }
    }

    /*
      ******************************************************************************
           Method :registrationContinueAction


         Description: This method clicks continue button.
      ******************************************************************************
      */
    public void registrationContinueAction() {

        verifyAndClick(regpageProperties.getProperty("BGBRegistration.continueButton"), "Continue Button");

    }

    /*
      ******************************************************************************
           Method :registrationCancelAction


         Description: This method clicks the cancel link.
      ******************************************************************************
      */
    public void registrationCancelAction() {

        browser.clickWithName(regpageProperties.getProperty("BGBRegistration.cancelLink"));

    }

    /*
      ******************************************************************************
           Method :enterRegisterationPassword


         Description: This method enters password and re type password and clicks
         marketing option and terms and condition check boxes.
      ******************************************************************************
      */
    public RegistrationAction enterRegisterationPassword() throws InterruptedException {
       
        verifyAndInputById(regpageProperties.getProperty("BGBRegistration.password"), "Password Text Box", registrationProfile.getPassword());
        verifyAndInputById(regpageProperties.getProperty("BGBRegistration.reenterPassword"), "Re-enter Password Text Box", registrationProfile.getPassword());
        verifyAndClick(regpageProperties.getProperty("BGBRegistration.TermsAndCond"), "Terms and Cond check Box");
        verifyAndClick(regpageProperties.getProperty("BGBRegistration.marketingOpt"), "Marketing Opt check Box");


        return regAction;
    }

    /*
      ******************************************************************************
           Method :unCheckMarketingOpt

         Created On:12/03/2011
         Description: This method clicks marketing option check box.
      ******************************************************************************
      */
    public void unCheckMarketingOpt() {
        verifyAndClick(regpageProperties.getProperty("BGBRegistration.marketingOpt"), "Marketing Opt check Box");


    }

    /*
      ******************************************************************************
           Method :unCheckTC

         Created On:12/03/2011
         Description: This method clicks terms and condition check box.
      ******************************************************************************
      */
    public void unCheckTC() {
        verifyAndClick(regpageProperties.getProperty("BGBRegistration.TermsAndCond"), "Terms and Cond check Box");
        //browser.click(regpageProperties.getProperty("BGBRegistration.TermsAndCond"));
//      browser.click(regpageProperties.getProperty("BGBRegistration.marketingOpt"));
    }

    /*
      ******************************************************************************
           Method :enterInvalidPassword

         Created On:12/03/2011
         Description: This method enters password and re type password and clicks
         marketing option and terms and condition check boxes.
      ******************************************************************************
      */
    public void enterInvalidPassword(String pwd, String repwd) {
        //   verifyAndInputById(regpageProperties.getProperty("BGBRegistration.reenterPassword"), "Re-enter Password Text Box", registrationProfile.getPassword());

        if (isNotEmpty(registrationProfile.getPassword())) {
            verifyAndInputById(regpageProperties.getProperty("BGBRegistration.password"), "Password Text Box", pwd);
        }
        if (isNotEmpty(registrationProfile.getConfPassword())) {
            verifyAndInputById(regpageProperties.getProperty("BGBRegistration.reenterPassword"), "Re-enter Password Text Box", repwd);
        }
        verifyAndClick(regpageProperties.getProperty("BGBRegistration.TermsAndCond"), "Terms and Cond check Box");
        verifyAndClick(regpageProperties.getProperty("BGBRegistration.marketingOpt"), "Marketing Opt check Box");
        verifyAndClick(regpageProperties.getProperty("BGBRegistration.continueButton"), "Continue Button");

//        browser.clickWithXpath(regpageProperties.getProperty("BGBRegistration.continueButton"));
    }

    /*
      ******************************************************************************
           Method :verifyRegistrationSuccessPage


         Description: This method verifies the text present in the third page.
      ******************************************************************************
      */
    public RegistrationAction verifyRegistrationSuccessPage() {
        browser.wait(2000);
        String expText = "Thank you for registering";
        //String thkypuDisp = browser.getTextByXpath(regpageProperties.getProperty("BGBRegistration.ThankYouPageText"));
        if (browser.isTextPresent(expText)) {
            //System.out.println("true");
            Report.updateTestLog("Registration Success Page is displayed correctly", "PASS");
        } else {
            //System.out.println("false");
            Report.updateTestLog("Registration Success Page  is not displayed correctly", "FAIL");
        }
        //Verify.assertTrue(browser.isTextPresent("Thank you for registering"));
        return new RegistrationAction();

        //Verify.assertTrue(browser.isTextPresent("Thank you for registering"));
    }
    /*
          ******************************************************************************
               Method :accountValid

             Created On:12/03/2011
             Description: This method validates Account number with number of
             valid account number.
          ******************************************************************************
          */

    public void enterValidAccountNumberThirdTime(String sysDate) {
        String[] validAccountNo = new String[3];
        validAccountNo[0] = "45545";
        validAccountNo[1] = "A4455";
        validAccountNo[2] = registrationProfile.getAccountNumber();
        OnlineDBConnector dbfunctions = new OnlineDBConnector();
        for (int i = 0; i < 3; i++) {
            sysDate = dbfunctions.DBsysdate();
            browser.clearValue(regpageProperties.getProperty("BGBRegistration.accountNumber"));
            verifyAndInputById(regpageProperties.getProperty("BGBRegistration.accountNumber"), "Account Number", validAccountNo[i]);
            verifyAndClick(regpageProperties.getProperty("BGBRegistration.continueButton"), "Continue Button");
            if (i != 2) {
                verifyErrorTextAccNo();

                verifyAuditTable();
                verifyAuditType(sysDate);
                verifyTransType(sysDate);
            }
        }
    }
    /*
          ******************************************************************************
               Method :accountValid

             Created On:12/03/2011
             Description: This method validates Account number with number of
             valid account number.
          ******************************************************************************
          */

    public void enterValidAccountNoFourthTime(String sysDate) {
        String[] validAccountNo = new String[4];
        validAccountNo[0] = "45545";
        validAccountNo[1] = "A4455";
        validAccountNo[2] = "A4df455";
        validAccountNo[3] = registrationProfile.getAccountNumber();
        OnlineDBConnector dbfunctions = new OnlineDBConnector();
        for (int i = 0; i < 4; i++) {
            sysDate = dbfunctions.DBsysdate();
            browser.clearValue(regpageProperties.getProperty("BGBRegistration.accountNumber"));
            verifyAndInputById(regpageProperties.getProperty("BGBRegistration.accountNumber"), "Account Number", validAccountNo[i]);
            verifyAndClick(regpageProperties.getProperty("BGBRegistration.continueButton"), "Continue Button");
            if (i != 3) {
                verifyErrorTextAccNo();
                verifyAuditTable();
                verifyAuditType(sysDate);
                verifyTransType(sysDate);
            }
            if (i == 2) {
                //browser.close();
                openRegPage();
            }
        }
    }

    public void verifyURLValidity() {

    }

    /*
          ******************************************************************************
               Method :accountInvalid

             Created On:12/03/2011
             Description: This method validates Account number with number of
             invalid account number.
          ******************************************************************************
          */
    public void accountInvalid() {
        //RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        //new PIStubResponseHelper().setupStubResposesTo(stubServiceResponses.get(stubResponseIndex));
        String[] invalidAccountNo = new String[3];
        invalidAccountNo[0] = "d4578541";
        invalidAccountNo[1] = "87%#87!";
        invalidAccountNo[2] = "@*$&$**";
//           
        for (int i = 0; i < 3; i++) {
            browser.clearValue(regpageProperties.getProperty("BGBRegistration.accountNumber"));
            invalidAccountPage(invalidAccountNo[i]);
            verifyErrorTextAccNo();
            //registrationPage.openRegPage();
        }

    }

    /*
          ******************************************************************************
               Method :verifyPersonalDetailsReg

             Created On:12/03/2011
             Description: This method verifies First name, Last name and email ID exist
             Browser.
          ******************************************************************************
          */
    public void verifyPersonalDetailsReg() {
        browser.wait(2000);

        String expFname = registrationProfile.getFirstName();
        expFname = expFname.trim();
        //	String actFname = browser.getTextByXpath(regpageProperties.getProperty("BGBRegistration.FirstName"));
        if (browser.isTextPresent(expFname)) {
            Report.updateTestLog("First name " + expFname + " is displayed correctly", "PASS");
        } else {
            Report.updateTestLog("First name " + expFname + "  is not displayed correctly", "FAIL");
        }
        String expLname = registrationProfile.getLastName();
        //String actLname = browser.getTextByXpath(regpageProperties.getProperty("BGBRegistration.LastName"));
        if (browser.isTextPresent(expLname)) {
            Report.updateTestLog("Last name " + expLname + " is displayed correctly", "PASS");
        } else {
            Report.updateTestLog("Last name " + expLname + "  is not displayed correctly", "FAIL");
        }

        String expEmail = registrationProfile.getEmail();
        //String actEmail = browser.getTextByXpath(regpageProperties.getProperty("BGBRegistration.Email"));
        if (browser.isTextPresent(expEmail)) {
            Report.updateTestLog("Email " + expEmail + " is displayed correctly", "PASS");
        } else {
            Report.updateTestLog("Email " + expEmail + " is not displayed correctly", "FAIL");
        }


    }

    /*
      ******************************************************************************
           Method :verifyRegFirstPage


         Description: This method verifies the text present in the first page.
      ******************************************************************************
      */
    public void verifyRegFirstPage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        String expText2 = "Registering to manage your account online is a quick 3-step process.";
        //String actText2 = browser.getTextByXpath(regpageProperties.getProperty("BGBRegistration.FirstPageText2"));
        if (browser.isTextPresent(expText2)) {

            Report.updateTestLog("Registration First Page is displayed correctly", "PASS");

        } else {

            Report.updateTestLog("Registration First Page  is not displayed correctly", "FAIL");
        }
        String expText1 = "Account number";
        //String actText1 = browser.getTextByXpath(regpageProperties.getProperty("BGBRegistration.FirstPageText1"));

        if (browser.isTextPresent(expText1)) {

            Report.updateTestLog("Account number Page is displayed correctly", "PASS");
        } else {
            Report.updateTestLog("Account number Page  is not displayed correctly", "FAIL");
        }

        //return regAction;
    }
    /*
      ******************************************************************************
           Method :verifyRegSecondPage


         Description: This method verifies the text present in the second page.
      ******************************************************************************
      */

    public RegistrationAction verifyRegSecondPage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        String expText1 = "Your details";
        //String actText1 = browser.getTextByXpath(regpageProperties.getProperty("BGBRegistration.SecondPageText"));
        if (browser.isTextPresent(expText1)) {

            Report.updateTestLog("Your details Page is displayed correctly", "PASS");
        } else {
            Report.updateTestLog("Your details Page  is not displayed correctly", "FAIL");
        }

        return new RegistrationAction();
    }

    /*
      ******************************************************************************
           Method :verifyRegStep1InvalidAcctPage

         Created On:12/04/2011
         Description: This method verifies the text present in the error page.
      ******************************************************************************
      */
    public void verifyRegInvalidAcctPage() {
        if (browser.isTextPresent(ErrorMessages.LINK_INVALID)) {
            Report.updateTestLog("Link invalid error text is displayed correctly", "PASS");
        } else {
            Report.updateTestLog("Link invalid error text is not displayed correctly", "FAIL");
        }
    }

    /*
      ******************************************************************************
           Method :verifyRegStep1AlreadyRegPage

         Created On:12/03/2011
         Description: This method verifies the text present in the error page.
      ******************************************************************************
      */
    public void verifyRegStep1AlreadyRegPage() {

        //error message has to be updated once business confirms on this.
        Verify.assertTrue(browser.isTextPresent(""));
    }

    /*
      ******************************************************************************
           Method :redirectLoginPage

         Created On:12/04/2011
         Description: This method clicks the lick text to navigate login page.
      ******************************************************************************
      */
    public void redirectLoginPage() {
        verifyAndClickWithLinkText(regpageProperties.getProperty("BGBRegistration.clickhereLink"), "Click here Link");

    }

    //    public void gotoStep2Reg(){
//    	 UIDriver uiDriver = WebDriverProvider.getCurrentDriver();
//    	uiDriver.get(ApplicationConfig.REG_URL2);
//    	
//    }
    /*
      ******************************************************************************
           Method :clickTermsAndConditionLink

         Created On:12/03/2011
         Description: This method enter details of login page and click login button.
      ******************************************************************************
      */
    public void clickTermsAndConditionLink() {
        if (browser.isTextPresent(regpageProperties.getProperty("BGBRegistration.TermsAndCondLink"))) {
            Report.updateTestLog("Terms of Use Link is displayed correctly", "PASS");
            browser.clickWithLinkText(regpageProperties.getProperty("BGBRegistration.TermsAndCondLink"));

        } else {
            Report.updateTestLog("Terms of Use Link is not displayed correctly", "FAIL");
        }


        //need to add code for verifying hte terms of use
    }

    /*
      ******************************************************************************
           Method :clickTermsAndConditionLink

         Created On:12/03/2011
         Description: This method enter details of login page and click login button.
      ******************************************************************************
      */
    public void verifyTermsAndConditionLink() {
        if (browser.isTextPresent(regpageProperties.getProperty("BGBRegistration.TermsAndCondLink"))) {
            Report.updateTestLog("Terms of Use Page is displayed correctly", "PASS");


        } else {
            Report.updateTestLog("Terms of Use Page is not displayed correctly", "FAIL");
        }


        //need to add code for verifying hte terms of use
    }

    public void newLoginPage() {
//object properties has to be updated as the page is not yet received
        if (isNotEmpty(registrationProfile.getEmail())) {
            browser.input(regpageProperties.getProperty("BGBRegistration.loginID"), registrationProfile.getEmail());
        }
        if (isNotEmpty(registrationProfile.getPassword())) {
            browser.input(regpageProperties.getProperty("BGBRegistration.loginPassword"), registrationProfile.getPassword());
        }
        browser.click(regpageProperties.getProperty("BGBRegistration.loginButton"));

    }

    public void verifyLoginSuccessPage() {

        browser.wait(15000);
        String expText1 = "Login";
        //String actText1 = browser.getTextByXpath(regpageProperties.getProperty("BGBRegistration.loginText"));
        if (browser.isTextPresent(expText1)) {


            Report.updateTestLog("Login Page is displayed correctly", "PASS");
        } else {
            Report.updateTestLog("Login Page  is not displayed correctly", "FAIL");
        }

        //return new RegistrationAction();
    }

    /*
      ******************************************************************************
           Method :verifyLockMsg

         Created On:12/03/2011
         Description: This method enters account number and click continue button.
      ******************************************************************************
      */
    public void verifyLockMsg() {
        if (browser.isTextPresent("For security reasons we will not allow any further attempts today.")) {
            Report.updateTestLog("Error message for lock account is displayed correctly", "PASS");
        } else {
            Report.updateTestLog("Error message for lock account is not displayed correctly", "FAIL");
        } //WebDriverProvider.quitDriver();
    }

    /*
      ******************************************************************************
           Method :invalidAccountPage

         Created On:12/03/2011
         Description: This method enters account number and click continue button.
      ******************************************************************************
      */
    public void quitBrowser() {
        browser.close();
    }

    public void invalidAccountPage(String invAccNo) {
        verifyAndInputById(regpageProperties.getProperty("BGBRegistration.accountNumber"), "Account Number", invAccNo);
        verifyAndClick(regpageProperties.getProperty("BGBRegistration.continueButton"), "Continue Button");

    }

    /*
      ******************************************************************************
           Method :verifyErrorText


         Description: This method verifies the error text present in the page.
      ******************************************************************************
      */
    public void verifyErrorText() {

        //error message need to be updated
        //if (browser.isTextPresent("Sorry, we need you to look at the following areas of the form again")) {
        if (browser.isTextPresent(ErrorMessages.INVALID_ACCOUNT_NUMBER)) {
            Report.updateTestLog("Error message is displayed correctly", "PASS");
        } else {
            Report.updateTestLog("Error message is not displayed correctly", "FAIL");
        }

    }

    public void verifyErrorTextTerms() {

        //error message need to be updated 
        // if (browser.isTextPresent("Terms of Use :")) {
        if (browser.isTextPresent(ErrorMessages.TERMS_CONDITIONS_NOT_ACCEPTED)) {
            Report.updateTestLog("Error message for Terms and conditions is displayed correctly", "PASS");
        } else {
            Report.updateTestLog("Error message for Terms and conditions is not displayed correctly", "FAIL");
        }

    }

    /*
    ******************************************************************************
         Method :verifyErrorText


       Description: This method verifies the error text present in the page.
    ******************************************************************************
    */
    public void verifyErrorTextExistUser() {
        if (browser.getTextByXpath(regpageProperties.getProperty("BGBRegistration.expired")).equals(ErrorMessages.LINK_ALREADY_REGISTERED)) {
            Report.updateTestLog("Error message <b>"+ErrorMessages.LINK_ALREADY_REGISTERED+"</b> is displayed correctly", "PASS");
        } else {
            Report.updateTestLog("Error message <b>"+ErrorMessages.LINK_ALREADY_REGISTERED+"</b> is not displayed correctly", "FAIL");
        }

    }


    /*
          ******************************************************************************
               Method :verifyErrorText


             Description: This method verifies the error text present in the page.
          ******************************************************************************
          */
    public void verifyErrorTextAccNo() {

        if (browser.isTextPresent(ErrorMessages.INVALID_ACCOUNT_NUMBER)) {
            Report.updateTestLog("Error message " + ErrorMessages.INVALID_ACCOUNT_NUMBER + " is displayed correctly", "PASS");
        } else if (browser.isTextPresent(ErrorMessages.INVALID_ACCOUNT_NUMBER_ATTEMPTS)) {
            Report.updateTestLog("Error message " + ErrorMessages.INVALID_ACCOUNT_NUMBER_ATTEMPTS + " is displayed correctly", "PASS");
        } else {
            Report.updateTestLog("Error message invalid account no  is not displayed correctly", "FAIL");
        }

    }

    /*
              ******************************************************************************
                   Method :verifyErrorText


                 Description: This method verifies the error text present in the page.
              ******************************************************************************
              */
    public void verifyErrorTextPassword(int i) {
        switch (i) {
            case 0:
                passwordError(ErrorMessages.PASSWORD_INVALID);
                break;
            case 1:
                passwordError(ErrorMessages.PASSWORD_EMPTY);
                break;
            case 2:
                passwordError(ErrorMessages.CONFIRM_PASSWORD_EMPTY);
                break;
            case 3:
                passwordError(ErrorMessages.CONFIRM_PASSWORD_NOT_MATCH);
                break;
            case 4:
                passwordError(ErrorMessages.PASSWORD_SAME_AS_EMAIL);
               
        }
    }

    private void passwordError(String error) {
        browser.wait(2000);
        if (browser.isTextPresent(error)) {
            Report.updateTestLog("Error message <b>" + error + "</b> is displayed correctly", "PASS");
        } else {
            Report.updateTestLog("Error message <b>" + error + "</b> is not displayed correctly", "FAIL");

        }
    }

    /*
          ******************************************************************************
               Method :verifyInvalidUrlPage

             Created On:12/04/2011
             Description: This method verifies the text present in the error page.
          ******************************************************************************
          */
    public RegistrationAction verifyInvalidUrlPage() {
        // Error message yet to be added.
        if (browser.isTextPresent("")) {
            Report.updateTestLog("Error message is displayed correctly", "PASS");
        } else {
            Report.updateTestLog("Error message is not displayed correctly", "FAIL");
        }
        //Verify.assertTrue(browser.isTextPresent(""));
        return new RegistrationAction();
    }

    /*
          ******************************************************************************
               Method :verifyInvalidUrlPage

             Created On:12/04/2011
             Description: This method verifies the text present in the error page.
          ******************************************************************************
          */
    public RegistrationAction verifyExpiredUrlPage() {
        // Error message yet to be added.
        String expText2 = ErrorMessages.LINK_EXPIRED;
        //"Sorry, your registration link has expired and you are not able to continue.";//regpageProperties.getProperty("BGBRegistration.expiredMsg");
        //  String actText2 = browser.getTextByXpath(regpageProperties.getProperty("BGBRegistration.expired"));
        if ((browser.isTextPresent(expText2))) {
            //error message need to be updated

            Report.updateTestLog("Error message " + expText2 + " for expired Url is displayed correctly", "PASS");
        } else {
            Report.updateTestLog("Error message " + expText2 + " for expired Url is not displayed correctly", "FAIL");
        }

        //Verify.assertTrue(browser.isTextPresent(""));
        return new RegistrationAction();
    }

    /*
          ******************************************************************************
               Method :openRegPage

             Created On:12/04/2011
             Description: This method opens the expected URL.
          ******************************************************************************
          */
    public void openRegPage() {
        browser.open(ApplicationConfig.NEW_BGB_URL + registrationProfile.getUrl());
    }

    /*
      ******************************************************************************
           Method :openInvalidPage

         Created On:12/04/2011
         Description: This method opens the error URL.
      ******************************************************************************
      */
    public void openInvalidPage() {
//	 UIDriver uiDriver = WebDriverProvider.getCurrentDriver();
//	 if (ApplicationConfig.NEW_LOGIN.compareToIgnoreCase("true") == 0) {
//		 uiDriver.get(ApplicationConfig.NEW_BGB_INVALIDURL);
//     } else {
//         uiDriver.get(ApplicationConfig.APP_BGB_URL);
//	 } 
        browser.open(ApplicationConfig.NEW_BGB_URL + registrationProfile.getInValidUrl());
    }
// public void gotoStep2Reg(){
//   	 UIDriver uiDriver = WebDriverProvider.getCurrentDriver();
//   	 uiDriver.get(ApplicationConfig.REG_URL2);
//   	
//   }


    public RegistrationAction verifyDBAfterRegistration() {
        String strQuery = "Select count(*) from BG_BUSINESS_TA_CUSTOMER_REG Where EMAIL = '" + registrationProfile.getEmail() + "'";

        OnlineDBConnector dbfunctions = new OnlineDBConnector();
        int regRowCount = dbfunctions.getRegDBCount(strQuery);
        if (regRowCount >= 1) {
            Report.updateTestLog("DB has been updated successfully after Registration", "PASS");

        } else {
            Report.updateTestLog("DB has not been updated successfully after Registration", "FAIL");
        }
        return new RegistrationAction();
    }

    /*
    ******************************************************************************
         Method :pwdInvalidationAction

       Created On:12/03/2011
       Description: This method validates password with number of invalid passwords.
    ******************************************************************************
    */
    public RegistrationAction pwdInvalidationPage() {
        verifyRegSecondPage();
        /*String[] pwd = new String[6];
        String[] repwd = new String[6];
        pwd[0] = "xyz@centrica.com";
        repwd[0] = "xyzs@centrica.com";
        pwd[1] = "";
        repwd[1] = "corrPassword1";
        pwd[2] = "corrPassword1";
        repwd[2] = "";
        pwd[3] = "";
        repwd[3] = "";
        pwd[4] = "abcdpassword1";
        repwd[4] = "passwordCent";
        pwd[5] = registrationProfile.getEmail();
        repwd[5] = registrationProfile.getEmail();*/

        String[] pwd = {"xyz@centrica.com", "", "corrPassword1", "abcdpassword1", registrationProfile.getEmail()};
        String[] repwd = {"xyzs@centrica.com", "corrPassword1", "", "passwordCent", registrationProfile.getEmail()};

        for (int i = 0; i < pwd.length; i++) {
            enterInvalidPassword(pwd[i], repwd[i]);
            verifyErrorTextPassword(i);
        }


        return new RegistrationAction();
    }

    /*
    ******************************************************************************
         Method :pwdLenInvalidationAction

       Created On:12/03/2011
       Description: This method validates length of password.
    ******************************************************************************
    */
    public void pwdLenInvalidationPage() {
        String[] pwd = {"corrPas", "corrPassword1corrPassword1corrPassword1corrPassword1"};
        String[] repwd = {"corrPas", "corrPassword1corrPassword1corrPassword1corrPassword1"};
        for (int i = 0; i < pwd.length; i++) {
            enterInvalidPassword(pwd[i], repwd[i]);
            verifyErrorTextPassword(0);
        }
        pwd[0] = "corrPassword1";
        repwd[0] = "corrPassword1";
        enterInvalidPassword(pwd[0], repwd[0]);
        verifyRegistrationSuccessPage();
    }

    public void verifyDBmarketingOptUncheckPage() {
        //we have to open terms & condition page
        String strQuery = "Select count(*) from BG_BUSINESS_TA_CUSTOMER_REG Where EMAIL = '" + registrationProfile.getEmail() + "' AND MARKETING_CONSENT = 'N'";
        // We have to add DataBase Related codes..
        OnlineDBConnector dbfunctions = new OnlineDBConnector();
        int regRowCount = dbfunctions.getRegDBCount(strQuery);
        if (regRowCount >= 1) {
            Report.updateTestLog("Marketing Consent has been updated successfully after Registration", "PASS");

        } else {
            Report.updateTestLog("Marketing Consent has not been updated successfully after Registration", "FAIL");
        }

    }

    public RegistrationAction setupTestDataForReg() {

        String strQuery = "delete from BG_BUSINESS_TA_CUSTOMER_REG where Email ='" + registrationProfile.getEmail() + "'";

        OnlineDBConnector dbfunctions = new OnlineDBConnector();
        dbfunctions.updateDB(strQuery);
        return new RegistrationAction();
    }

    public RegistrationAction verifyAuditTable() {

        OnlineDBConnector dbfunctions = new OnlineDBConnector();
        int regRowCount = dbfunctions.verifyAuditBgbMs(registrationProfile.getEmail());
        if (regRowCount >= 1) {
            Report.updateTestLog("Audit table has been updated successfully during Registration", "PASS");

        } else {
            Report.updateTestLog("Audit table has not been updated successfully during Registration", "FAIL");
        }
        return new RegistrationAction();
    }

    public RegistrationAction verifyAuditType(String sysDate) {

        OnlineDBConnector dbfunctions = new OnlineDBConnector();
        String auditType = dbfunctions.getAuditTypeMs(registrationProfile.getEmail(), sysDate);

        String audTypeFromAudit = dbfunctions.getAuditType(auditType);
        String expAudType = "INVALID_ACCOUNT";
        // String expAudType1 = "INVALID_ACCOUNT_ATTEMPTS_EXCEEDED";
        if (audTypeFromAudit.contains(expAudType)) {
            Report.updateTestLog("Audit Type " + expAudType + " has been updated successfully during Registration", "PASS");

        } else {
            Report.updateTestLog("Audit Type " + expAudType + " has not been updated successfully during Registration", "FAIL");
        }
        return new RegistrationAction();
    }

    public RegistrationAction verifyTransType(String sysDate) {

        OnlineDBConnector dbfunctions = new OnlineDBConnector();
        String transType = dbfunctions.getTransactionTypeMs(registrationProfile.getEmail(), sysDate);
        String transTypeFromAudit = dbfunctions.getTransType(transType);
        String expTransType = "REGISTRATION";
        if (expTransType.equalsIgnoreCase(transTypeFromAudit)) {
            Report.updateTestLog("Audit Type " + expTransType + " has been updated successfully during Registration", "PASS");

        } else {
            Report.updateTestLog("Audit Type " + expTransType + " has not been updated successfully during Registration", "FAIL");
        }
        return new RegistrationAction();
    }

    public void verifyDBmarketingOptAction() {
        String strQuery = "Select count(*) from BG_BUSINESS_TA_CUSTOMER_REG Where EMAIL = '" + registrationProfile.getEmail() + "' AND MARKETING_CONSENT = 'Y'";
        // We have to add DataBase Related codes..
        OnlineDBConnector dbfunctions = new OnlineDBConnector();
        int regRowCount = dbfunctions.getRegDBCount(strQuery);
        if (regRowCount >= 1) {
            Report.updateTestLog("Marketing Consent has been updated successfully after Registration", "PASS");

        } else {
            Report.updateTestLog("Marketing Consent has not been updated successfully after Registration", "FAIL");
        }
        // We have to add DataBase Related codes..

    }
}
