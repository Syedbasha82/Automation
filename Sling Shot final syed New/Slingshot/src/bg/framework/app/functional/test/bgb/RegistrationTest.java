package bg.framework.app.functional.test.bgb;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.bgb.RegistrationAction;
import bg.framework.app.functional.entities.RegistrationProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import static bg.framework.app.functional.entities.FunctionalCategory.RegresBGBMS;

public class RegistrationTest extends TestBase {
    /*
           Method :ManualRedirectLoginPage03
         Description:This test is to verify whether end to end  registration journye works fine
      */
    @SuppressWarnings("unchecked")
   //@Test(groups = {RegresBGBMS})
    public void registrationEndtoEndNormal() throws InterruptedException {
        Report.createTestLogHeader("BGB Registration", "Multisite Registration for RegistrationEndtoEndNormal");

        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("normal");
        //  try {
        new RegistrationAction(registrationProfile)
                .setupTestDataForRegAction()
                .openRegURLAction()
                .verifyRegFirstStepAction()
                .registrationAccDetAction()
                .registrationNavigatetoThirdStep()
                .verifyRegistrationSuccess()
                .verifyRedirectedPage()
                .verifyDBAfterRegistrationAction();
        //}
        //catch(SystemException e) {
        //  e.errorLog();
        //System.out.println(e);
        //}
    }


    @SuppressWarnings("unchecked")
///   @Test(groups = {RegresBGBMS})
    public void registrationEndtoEndSuper() throws InterruptedException {

        Report.createTestLogHeader("BGB Registration for SuperUser", "Multisite Registration for RegistrationEndtoEndSuper");

        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("normal");
        // try {
        new RegistrationAction(registrationProfile)
                .setupTestDataForRegAction()
                .openRegURLAction()
                .verifyRegFirstStepAction()
                .registrationAccDetAction()
                .registrationNavigatetoThirdStep()
                .verifyRegistrationSuccess()
                .verifyRedirectedPage()
                .verifyDBAfterRegistrationAction();
        //} catch (SystemException e) {
        //  e.errorLog();
        // e.printStackTrace();
        //}
    }

    /*
      *****************************************************************************
          Method :PasswordvalidationValidValues13

         Description:This test is to verify the positive flow for step 2 page by giving valid passwords.
     ******************************************************************************
      */
    @SuppressWarnings("unchecked")
//    @Test(groups = {RegresBGBMS})
    //mandatory fields:
    public void passwordvalidationValidValues() {
        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("normal");
        Report.createTestLogHeader("BGB Registration", "Multisite Registration for PasswordvalidationValidValues");

        //try {
        new RegistrationAction(registrationProfile)
                .setupTestDataForRegAction()
                .openRegURLAction()
                .verifyRegFirstStepAction()
                .registrationAccDetAction()
                .pwdInvalidationAction()
                .pwdLenInvalidationAction();
//	} catch (SystemException e) {
//	    e.errorLog();
//	    e.printStackTrace();
//	}


    }

    //    //	/*
//	 ******************************************************************************
//	  	Method :RegEmailLinkNavigationNormal_07
//		
//		Description:This test is to verify the registration link opens properly
//	 ******************************************************************************
//	 */
//
//	@SuppressWarnings("unchecked")
//	////@Test(groups = {RegresBGBMS})
//	public void regEmailLinkValidity() {
//		RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("normal");
//		Report.createTestLogHeader("BGB Registration","Multisite Registration");
//		new RegistrationAction(registrationProfile)
//		.openRegURLAction()
//		.verifyRegFirstStepAction();		
//    }
    @SuppressWarnings("unchecked")
   // @Test(groups = {RegresBGBMS})
    public void regEmailLinkExpired() {
        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("AlreadyRegExpired");
        Report.createTestLogHeader("BGB Registration", "Multisite Registration for expired");
        new RegistrationAction(registrationProfile)
                .invalidURLAction()
                .verifyInvalidURLPageAction();
    }

    /*
      ******************************************************************************
           Method :AccnoValidationValid_03

         Description:This test is to verify the valid account number flow
      ******************************************************************************
      */
    @SuppressWarnings("unchecked")
//    @Test(groups = {RegresBGBMS})
    public void accnoValidationValid() {
        RegistrationProfile[] registrationProfile = new RegistrationProfile[3];
        registrationProfile[0] = new TestDataHelper().getRegistrationProfile("ValidTwoLetter");
        registrationProfile[1] = new TestDataHelper().getRegistrationProfile("ValidTwelveLetter");
        registrationProfile[2] = new TestDataHelper().getRegistrationProfile("ValidTwotoTwelve");

        Report.createTestLogHeader("BGB Registration", "Multisite Registration for AccnoValidationValid(2Letter,2-12,=12 Letter)");
        for (int i = 0; i < 3; i++) {
            new RegistrationAction(registrationProfile[i])
                    .setupTestDataForRegAction()
                    .openRegURLAction()
                    .accountValidationAction();
        }
    }

    /*
      ******************************************************************************
           Method :AccnoMorethanTwoAttempts_05

         Description:This test is to verify the validation when the invalid account no
                       entered for more than two times
      ******************************************************************************
      */
    @SuppressWarnings("unchecked")
//    @Test(groups = {RegresBGBMS})
    public void accountNumberValidinThirdAttempt() throws InterruptedException {

        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("normal");
        OnlineDBConnector dbfunctions = new OnlineDBConnector();
        String systemDate = dbfunctions.DBsysdate();

        Report.createTestLogHeader("BGB Registration", "Multisite Registration for AccountNumberValidinThirdAttempt");

        new RegistrationAction(registrationProfile)
                .setupTestDataForRegAction()
                .openRegURLAction()
                .verifyRegFirstStepAction()
                .registrationThirdAttemptAction(systemDate);

    }

    /*
      ******************************************************************************
           Method :AccnoMorethanTwoAttempts_05

         Description:This test is to verify the validation when the invalid account no
                       entered for more than two times
      ******************************************************************************
      */
    @SuppressWarnings("unchecked")
   //@Test(groups = {RegresBGBMS})
    public void accountNumberValidAfterThirdAttempt() throws InterruptedException {

        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("normal");
        OnlineDBConnector dbfunctions = new OnlineDBConnector();
        String logPath = null;
        Report.createTestLogHeader("BGB Registration", "Multisite Registration for AccountNumberValidAfterThirdAttempt");
        String systemDate = dbfunctions.DBsysdate();
        new RegistrationAction(registrationProfile)
                .setupTestDataForRegAction()
                .openRegURLAction()
                .verifyRegFirstStepAction()
                .registrationAfterThirdAttemptAction(systemDate);

    }

    /*
      ******************************************************************************
           Method :termsAndConditionTest

         Description:This test is to verify terms and condition link in the second page
      ******************************************************************************
      */
    @SuppressWarnings("unchecked")
    //@Test(groups = {RegresBGBMS})
    public void termsAndConditionTest() {
        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("normal");
        Report.createTestLogHeader("BGB Registration", "Multisite Registration to verify terms and conditions Link");
        new RegistrationAction(registrationProfile)
                .setupTestDataForRegAction()
                .openRegURLAction()
                .verifyRegFirstStepAction()
                .registrationAccDetAction()
                .clicktermsAndConditionAction();

    }

    /*
      ******************************************************************************
           Method :ManualRedirectLoginPage03

         Description:This test is to verify whether manual redirection of Login page
                     from registration success page is working fine
      ******************************************************************************
      */
    @SuppressWarnings("unchecked")
   // @Test(groups = {RegresBGBMS})
    public void manualRedirectLoginPage() throws InterruptedException {

        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("normal");


        Report.createTestLogHeader("BGB Registration", "Multisite Registration for ManualRedirectLoginPage");

        new RegistrationAction(registrationProfile)
                .setupTestDataForRegAction()
                .openRegURLAction()
                .verifyRegFirstStepAction()
                .registrationAccDetAction()

                .registrationNavigatetoThirdStep()
                .verifyRegistrationSuccess()
                .redirectLoginPageAction();

    }

    /*
      ******************************************************************************
           Method :accountLockAndValidAccountTest

         Description:This test is to verify the validation when the invalid account no
                       entered for first three times and enters valid number
      ******************************************************************************
      */


    @SuppressWarnings("unchecked")
   // @Test(groups = {RegresBGBMS})

    public void accountLockAndValidAccountTest() {
        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("normal");
        Report.createTestLogHeader("BGB Registration", "Multisite Registration for account no field Lock");

        RegistrationAction regAction = new RegistrationAction(registrationProfile);
        new RegistrationAction(registrationProfile)
                .setupTestDataForRegAction()
                .openRegURLAction()
                .accountInvalidAction()
                .verifyAccountLockError()
                .openRegURLAction()
                .registrationAccDetAction();
    }


    /*
      ******************************************************************************
           Method :AccnoInValidation_03

         Description:This test is to verify the validation when the invalid account no
                       entered for first time
      ******************************************************************************
      */


    @SuppressWarnings("unchecked")
    //@Test(groups = {RegresBGBMS})
    public void accnoInValidation() {

        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("normal");
        String logPath = null;
        //System.out.println(logPath);
        Report.createTestLogHeader("BGB Registration", "Multisite Registration accnoInValidation");

        RegistrationAction regAction = new RegistrationAction(registrationProfile);
        new RegistrationAction(registrationProfile)
                .setupTestDataForRegAction()
                .openRegURLAction()
                .verifyRegFirstStepAction()
                .accountInvalidAction();
        //regAction.verifyRegSecondStep();
    }
    /*
      ******************************************************************************
           Method :ExistUserAccno

         Description:This test is to verify the validation when the invalid account no
                       entered for first time
      ******************************************************************************
      */

    @SuppressWarnings("unchecked")
   // @Test(groups = {RegresBGBMS})
    public void existUserAccno() throws InterruptedException {
        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("normal");
        Report.createTestLogHeader("BGB Registration", "Multisite Registration for exist user account no");
        new RegistrationAction(registrationProfile)
                .setupTestDataForRegAction()
                .openRegURLAction()
                .verifyRegFirstStepAction()
                .registrationAccDetAction()
                .registrationNavigatetoThirdStep()
                .verifyRegistrationSuccess()
                .verifyRedirectedPage()
                .verifyDBAfterRegistrationAction()
                .openRegURLAction()
                .existUserAccnoAction();


    }

    /*
      ******************************************************************************
           Method :AccnoNotReg

         Description:This test is to verify the validation when the invalid account no
                       entered for first time
      ******************************************************************************
      */
    @SuppressWarnings("unchecked")
    //@Test(groups = {RegresBGBMS})
    public void accnoNotReg() throws InterruptedException {

        //pistub part needs to be added
        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("NotRegistered");
        String logPath = null;
        //System.out.println(logPath);
        Report.createTestLogHeader("BGB Registration", "Multisite Registration for not registered customer");
        RegistrationAction regAction = new RegistrationAction(registrationProfile);
        new RegistrationAction(registrationProfile)
                .setupTestDataForRegAction()
                .openRegURLAction()
                .verifyRegFirstStepAction()
                .accnoNotRegAction();
        //regAction.registrationStep1SuccessAction();
        //regAction.verifyRegSecondStep();
    }


    /*
    ******************************************************************************
         Method :MarketingOptCheckAction
       Description:This test is to verify the Marketing Option check box is checked in second page.
    ******************************************************************************
    */
    @SuppressWarnings("unchecked")
   // @Test(groups = {RegresBGBMS})
    public void marketingTermsCheck() throws InterruptedException {

        //pistub part needs to be added
        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("normal");
        String logPath = null;
        //System.out.println(logPath);
        Report.createTestLogHeader("BGB Registration", "Multisite Registration for MarketingTermsCheck");
        RegistrationAction regAction = new RegistrationAction(registrationProfile);

        new RegistrationAction(registrationProfile)
                .setupTestDataForRegAction()
                .openRegURLAction()
                .verifyRegFirstStepAction()
                .registrationAccDetAction()

                .registrationNavigatetoThirdStep()
                .verifyRegistrationSuccess()
                .verifyDBAfterRegistrationAction()
                .verifyDBmarketingOptAction();

    }

    /*
      ******************************************************************************
           Method :MarketingOptUnCheckAction
         Description:This test is to verify the Marketing Option check box is Unchecked in second page.
      ******************************************************************************
      */
    @SuppressWarnings("unchecked")
   // @Test(groups = {RegresBGBMS})
    public void termsCheckMarketingUncheck() throws InterruptedException {


        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("normal");
        String logPath = null;
        //System.out.println(logPath);
        Report.createTestLogHeader("BGB Registration", "Multisite Registration FOR termsCheckMarketingUncheck");
        RegistrationAction regAction = new RegistrationAction(registrationProfile);

        new RegistrationAction(registrationProfile)
                .setupTestDataForRegAction()
                .openRegURLAction()
                .verifyRegFirstStepAction()
                .registrationAccDetAction()

                .regUncheckMarAction()
                .verifyRegistrationSuccess()
                .verifyDBAfterRegistrationAction()
                .verifyDBmarketingOptUncheckAction();

    }

    /*
      ******************************************************************************
           Method :MarOptTCUnCheckAction
         Created By: Shanthi B
         Created On:12/02/2011
         Description:This test is to verify the Marketing Option and Terms & condition check boxes are Unchecked in second page.
      ******************************************************************************
      */
    @SuppressWarnings("unchecked")
   // @Test(groups = {RegresBGBMS})
    public void termsMarkrtingUncheck() throws InterruptedException {

        //pistub part needs to be added
        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("normal");
        String logPath = null;
        //System.out.println(logPath);
        Report.createTestLogHeader("BGB Registration", "Multisite Registration for termsMarkrtingUncheck");
        RegistrationAction regAction = new RegistrationAction(registrationProfile);

        new RegistrationAction(registrationProfile)
                .setupTestDataForRegAction()
                .openRegURLAction()
                .verifyRegFirstStepAction()
                .registrationAccDetAction()

                .regUncheckMarOpTCAction()
                .verifyRegErrorAction();


    }

    @SuppressWarnings("unchecked")
   // @Test(groups = {RegresBGBMS})
    public void termsUncheckMarkrtingcheck() throws InterruptedException {


        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("normal");
        String logPath = null;
        //System.out.println(logPath);
        Report.createTestLogHeader("BGB Registration", "Multisite Registration for termsUncheckMarkrtingcheck");
        RegistrationAction regAction = new RegistrationAction(registrationProfile);

        new RegistrationAction(registrationProfile)
                .setupTestDataForRegAction()
                .openRegURLAction()
                .verifyRegFirstStepAction()
                .registrationAccDetAction()

                .regUncheckTermsAction()
                .verifyRegErrorAction();


    }
    @SuppressWarnings("unchecked")
    //@Test(groups = {RegresBGBMS})
    public void registrationStep2Cancel() throws InterruptedException {
        Report.createTestLogHeader("BGB Registration", "Multisite Registration for RegistrationEndtoEndNormal");

        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("normal");
        //  try {
        new RegistrationAction(registrationProfile)
                .setupTestDataForRegAction()
                .openRegURLAction()
                .verifyRegFirstStepAction()
                .registrationAccDetAction()
                .registrationStep2Cancel();
                
    }

}
