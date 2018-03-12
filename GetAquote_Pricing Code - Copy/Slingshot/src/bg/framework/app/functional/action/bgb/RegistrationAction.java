package bg.framework.app.functional.action.bgb;

import bg.framework.app.functional.entities.RegistrationProfile;
import bg.framework.app.functional.page.bgb.RegistrationPage;
import bg.framework.app.functional.util.OnlineDBConnector;

//import bg.framework.app.functional.util.PIStubResponseHelper;

public class RegistrationAction {

    private RegistrationProfile registrationProfile;

    //private List<Map<String, String>> stubServiceResponses;
    // Report report = new Report();
    // String logPath = null;
    //  private PersonalDetailsPage personalDetailsPage;
    public RegistrationAction() {
    }

    public RegistrationAction(RegistrationProfile registrationProfile) {
        this.registrationProfile = registrationProfile;

    }

    /*
      ******************************************************************************
           Method :registrationStep1SuccessAction

         Created On:12/02/2011
         Description: This method enters input for first page.
      ******************************************************************************
      */
    public RegistrationAction registrationAccDetAction() {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        //new PIStubResponseHelper().setupStubResposesTo(stubServiceResponses.get(stubResponseIndex));

        registrationPage.enterRegisterationAccNum();
        registrationPage.registrationContinueAction();
        registrationPage.verifyPersonalDetailsReg();
        return new RegistrationAction(registrationProfile);
    }

    public void clicktermsAndConditionAction() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickTermsAndConditionLink();
        registrationPage.verifyTermsAndConditionLink();
    }

    /*
      ******************************************************************************
           Method :registrationStep2SuccessAction

         Created On:12/02/2011
         Description: This method enters input in second page.
      ******************************************************************************
      */
    public RegistrationAction registrationNavigatetoThirdStep() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
//    	new PIStubResponseHelper().setupStubResposesTo(stubServiceResponses.get(stubResponseIndex));
////    	registrationPage.gotoStep2Reg();
        registrationPage.enterRegisterationPassword();
        registrationPage.registrationContinueAction();
        return new RegistrationAction(registrationProfile);
    }
    public RegistrationAction registrationStep2Cancel() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
//    	new PIStubResponseHelper().setupStubResposesTo(stubServiceResponses.get(stubResponseIndex));
////    	registrationPage.gotoStep2Reg();
        registrationPage.enterRegisterationPassword();
        registrationPage.registrationCancelAction();
        registrationPage.verifyRegFirstPage();
        return new RegistrationAction(registrationProfile);
    }

    /*
      ******************************************************************************
           Method :regStep2UncheckMarAction

         Created On:12/02/2011
         Description: This method un checks marketing option.
      ******************************************************************************
      */
    public RegistrationAction regUncheckMarAction() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        //new PIStubResponseHelper().setupStubResposesTo(stubServiceResponses.get(stubResponseIndex));
//    	registrationPage.gotoStep2Reg();
        registrationPage.enterRegisterationPassword();
        registrationPage.unCheckMarketingOpt();
        registrationPage.registrationContinueAction();
        return new RegistrationAction(registrationProfile);
    }

    /*
      ******************************************************************************
           Method :regStep2UncheckTerms and condition check box

         Created On:12/02/2011
         Description: This method un checks terms and condition option.
      ******************************************************************************
      */
    public RegistrationAction regUncheckTermsAction() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        //new PIStubResponseHelper().setupStubResposesTo(stubServiceResponses.get(stubResponseIndex));
//    	registrationPage.gotoStep2Reg();
        registrationPage.enterRegisterationPassword();
        registrationPage.unCheckTC();
        registrationPage.registrationContinueAction();
        return new RegistrationAction(registrationProfile);
    }

    /*
      ******************************************************************************
           Method :regStep2UncheckMarOpTCAction

         Created On:12/02/2011
         Description: This method Unchecks marketing option and terms & condition .
      ******************************************************************************
      */
    public RegistrationAction regUncheckMarOpTCAction() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        //new PIStubResponseHelper().setupStubResposesTo(stubServiceResponses.get(stubResponseIndex));
//    	registrationPage.gotoStep2Reg();
        registrationPage.enterRegisterationPassword();
        registrationPage.unCheckMarketingOpt();
        registrationPage.unCheckTC();
        registrationPage.registrationContinueAction();
        return new RegistrationAction(registrationProfile);
    }

    /*
      ******************************************************************************
           Method :verifyRegistrationSuccess

         Created On:12/02/2011
         Description: This method verifies text in third page.
      ******************************************************************************
      */
    public RegistrationAction verifyRegistrationSuccess() {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        registrationPage.verifyRegistrationSuccessPage();
        return new RegistrationAction(registrationProfile);
    }

    /*
      ******************************************************************************
           Method :verifyRegFirstStep


         Description: This method verifies text in first page.
      ******************************************************************************
      */
    public RegistrationAction setupTestDataForRegAction() {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        registrationPage.setupTestDataForReg();
        return new RegistrationAction(registrationProfile);
    }

    /*
      ******************************************************************************
           Method :verifyRegFirstStep


         Description: This method verifies text in first page.
      ******************************************************************************
      */
    public RegistrationAction verifyRegFirstStepAction() {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        registrationPage.verifyRegFirstPage();
        return this;
    }

    /*
      ******************************************************************************
           Method :verifyRegSecondStep

         Created On:12/02/2011
         Description: This method verifies text in second page.
      ******************************************************************************
      */
    public RegistrationAction verifyRegSecondStep() {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        registrationPage.verifyRegSecondPage();
        return new RegistrationAction();
    }

    /*
      ******************************************************************************
           Method :registrationStep1InvalidAcctAction

         Created On:12/02/2011
         Description: This method enters invalid input in first page.
      ******************************************************************************
      */
    public RegistrationAction registrationThirdAttemptAction(String sysDate) {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        //new PIStubResponseHelper().setupStubResposesTo(stubServiceResponses.get(stubResponseIndex));
        registrationPage.enterValidAccountNumberThirdTime(sysDate);
        registrationPage.verifyPersonalDetailsReg();
        return new RegistrationAction(registrationProfile);
    }


    /*
      ******************************************************************************
           Method :registrationStep1InvalidAcctAction

         Created On:12/02/2011
         Description: This method enters invalid input in first page.
      ******************************************************************************
      */
    public RegistrationAction registrationAfterThirdAttemptAction(String sysDate) {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        //new PIStubResponseHelper().setupStubResposesTo(stubServiceResponses.get(stubResponseIndex));
        registrationPage.enterValidAccountNoFourthTime(sysDate);
        registrationPage.verifyPersonalDetailsReg();
        return new RegistrationAction(registrationProfile);
    }

    /*
      ******************************************************************************
           Method :verifyRegStep1InvalidAcctErrorAction


         Description: This method verifies error message at page 1.
      ******************************************************************************
      */
    public RegistrationAction verifyRegStep1InvalidAcctErrorAction() {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        registrationPage.verifyErrorText();
        return new RegistrationAction(registrationProfile);
    }

    /*
      ******************************************************************************
           Method :verifyRegErrorAction


         Description: This method verifies error message.
      ******************************************************************************
      */
    public void verifyRegErrorAction() {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        registrationPage.verifyErrorTextTerms();
    }

    /*
      ******************************************************************************
           Method :verifyRedirectedPage

         Description: This method verifies text in login page.
      ******************************************************************************
      */
    public RegistrationAction verifyRedirectedPage() {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        registrationPage.verifyLoginSuccessPage();
        return new RegistrationAction(registrationProfile);
    }

    public RegistrationAction verifyAccountLockError() {
        RegistrationPage registrationPage = new RegistrationPage();

        registrationPage.verifyLockMsg();
        //registrationPage.quitBrowser();
        return new RegistrationAction(registrationProfile);
    }

    /*
      ******************************************************************************
           Method :accountInvalid

         Description: This method validates Account number with number of
         invalid account number.
      ******************************************************************************
      */
    public RegistrationAction accountInvalidAction() {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        registrationPage.accountInvalid();
        return new RegistrationAction(registrationProfile);
    }

    /*
      ******************************************************************************
           Method :accountValidationAction

         Description: This method validates Account number with number of
         valid account number.
      ******************************************************************************
      */
    public void accountValidationAction() {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        registrationPage.enterRegisterationAccNumWithAlphabet();


    }

    /*
      ******************************************************************************
           Method :openRegURLAction

         Description: This method opens correct encrypted URL.
      ******************************************************************************
      */
    public RegistrationAction openRegURLAction() {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        registrationPage.openRegPage();
        return new RegistrationAction(registrationProfile);
    }

    /*
      ******************************************************************************
           Method :invalidURLAction

         Description: This method opens an invalid URL.
      ******************************************************************************
      */
    public RegistrationAction invalidURLAction() {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        registrationPage.openInvalidPage();
        return new RegistrationAction(registrationProfile);
    }

    /*
      ******************************************************************************
           Method :verifyInvalidURLPageAction

         Description: This method validates error on invalid URL.
      ******************************************************************************
      */
    public RegistrationAction verifyInvalidURLPageAction() {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        registrationPage.verifyExpiredUrlPage();
        return new RegistrationAction(registrationProfile);
    }

    /*
      ******************************************************************************
           Method :existUserAccnoAction

         Description: This method verifies error message.
      ******************************************************************************
      */
    public void existUserAccnoAction() {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        registrationPage.verifyErrorTextExistUser();
    }

    /*
      ******************************************************************************
           Method :accnoNotRegAction

         Description: This method validates an invalid account number and appropriate
         error message.
      ******************************************************************************
      */
    public void accnoNotRegAction() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        //	new PIStubResponseHelper().setupStubResposesTo(stubServiceResponses.get(stubResponseIndex));
        registrationPage.enterRegisterationAccNum();
        registrationPage.registrationContinueAction();
        registrationPage.verifyErrorTextAccNo();

    }

    /*
      ******************************************************************************
           Method :pwdInvalidationAction

         Description: This method validates password with number of invalid passwords.
      ******************************************************************************
      */
    public RegistrationAction pwdInvalidationAction() {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        registrationPage.pwdInvalidationPage();
        return new RegistrationAction(registrationProfile);
    }

    /*
      ******************************************************************************
           Method :pwdInvalidationAction

         Description: This method validates password with number of invalid passwords.
      ******************************************************************************
      */
    public RegistrationAction pwdLenInvalidationAction() {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        registrationPage.pwdLenInvalidationPage();
        return new RegistrationAction(registrationProfile);
    }

    public void verifyDBmarketingOptAction() {
        String strQuery = "Select count(*) from BG_BUSINESS_TA_CUSTOMER_REG Where EMAIL = '" + registrationProfile.getEmail() + "' AND MARKETING_CONSENT = 'Y'";
        // We have to add DataBase Related codes..
        OnlineDBConnector dbfunctions = new OnlineDBConnector();
        int regRowCount = dbfunctions.getRegDBCount(strQuery);
        if (regRowCount >= 1) {
            //report.updateTestLog(logPath,"1","Marketing Consent has been updated successfully after Registration","PASS");

        } else {
            //report.updateTestLog(logPath,"1", "Marketing Consent has not been updated successfully after Registration","FAIL");
        }
        // We have to add DataBase Related codes..

    }

    public RegistrationAction verifyDBAfterRegistrationAction() {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        registrationPage.verifyDBAfterRegistration();
        return new RegistrationAction(registrationProfile);
    }

    public RegistrationAction verifyDBmarketingOptUncheckAction() {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        registrationPage.verifyDBAfterRegistration();
        return new RegistrationAction();
    }

    public void verifyDBreg() {

        String strQuery = "Select Email from BG_BUSINESS_TA_CUSTOMER_REG where Email like 'a%'";
        // We have to add DataBase Related codes..
        OnlineDBConnector dbfunctions = new OnlineDBConnector();
        String regEmail = dbfunctions.getColumn("Email", strQuery);
        //System.out.println(regEmail);

    }

    /*
      ******************************************************************************
           Method :redirectLoginPageAction
         Created By: Shanthi B
         Created On:12/03/2011
         Description: This method navigate to login page.
      ******************************************************************************
      */
    public void redirectLoginPageAction() {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        registrationPage.redirectLoginPage();
        registrationPage.newLoginPage();
        LoginMultiSiteAction loginMultiSiteAction = new LoginMultiSiteAction();
        loginMultiSiteAction.normalUserAccountAction();
        //registrationPage.verifyLoginSuccessPage();
    }

    public void verifyValidityInDBAction() {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        registrationPage.verifyURLValidity();
    }

    public void verifyTransTypeAction() {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        registrationPage.verifyTransType("REGISTRATION");
    }

    public void verifyAuditTypeAction() {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        registrationPage.verifyAuditType("INVALID_ACCOUNT");
    }

    public void verifyAuditTableAction() {
        RegistrationPage registrationPage = new RegistrationPage(registrationProfile);
        registrationPage.verifyAuditTable();
    }
}

