package bg.framework.app.functional.page.obsolete;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.GlobalErrorMessages;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 22/02/12
 * Time: 07:44
 * To change this template use File | Settings | File Templates.
 */
public class ForgottenPasswordPage extends BasePage {
    private SimpleJdbcTemplate jdbcTemplate;
    private final static String FILE_NAME = "resources/selfServe/ForgottenPassword.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
    OnlineDBConnector dbconnector = new OnlineDBConnector();

    public void validateForgottenPasswordJourney(UserProfile userProfile) {
        browser.wait(1000);
        verifyIsTextPresent(pageProperties.getProperty("ForgottenPassword.Header"));
        verifyAndInputById(pageProperties.getProperty("ForgottenPassword.EmailIDField"), "Customer Email Address", userProfile.getEmail());
        //verifyAndClickWithName(pageProperties.getProperty("ForgottenPassword.ContinueButton"),"Continue Button");
        verifyAndClickWithXpath(pageProperties.getProperty("ForgottenPassword.ContinueButton"), "Continue Button");
        browser.wait(1000);

        //Setting up the user's temp password as temp12345
        new OnlineDBConnector().updateTempPassword(userProfile.getUCRN());

        verifyAndClickWithLinkText(pageProperties.getProperty("ForgottenPassword.GoBackToLoginLink"), "Go back to Login "); //Go to your account link not working

        verifyAndInputById("login-email", "Login ID", userProfile.getEmail());
        verifyAndInputById("login-password", "Temp Password", "temp12345");
        verifyAndClickWithClass("btn-input", "Login Button");
        browser.wait(getWaitTime());

        verifyAndInputById(pageProperties.getProperty("ForgottenPassword.YourTempPasswordField"), "Temporary Password", "temp12345");
        verifyAndInputById(pageProperties.getProperty("ForgottenPassword.YourNewPassword"), "New Password", "password12");
        verifyAndInputById(pageProperties.getProperty("ForgottenPassword.ConfirmPassword"), "ReEnter New Password", "password12");
        verifyAndClickWithName(pageProperties.getProperty("ForgottenPassword.PasswordSubmitButton"), "Submit Temporary Password Button");
        browser.wait(1000);
        verifyIsTextPresent(pageProperties.getProperty("ForgottenPassword.ConfirmationMessage"));

        //verifyAndClickWithLinkText(" asda ","asdasd "); //Go to your account link not working
        verifyAndClickWithLinkText(pageProperties.getProperty("ForgottenPassword.ContinueToYourAccount"), "Go back to Login ");

        // verifyAndInputById("login-email", "Login ID", userProfile.getEmail());
        //verifyAndInputById("login-password", "Temp Password", "password12");
        //("btn-input", "Login Button");
        //browser.wait(getWaitTime());

        verifyIsElementVisibleById("logoutMsg", "Home Page");
    }

    public void verifyBlankFieldsError(UserProfile userProfile) {
        verifyAndClickWithXpath(pageProperties.getProperty("ForgottenPassword.ContinueButton"), "Continue Button");
        verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSGHeader);
        verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSGSubHeader);
        verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSG_ForgottenPasswordBlankField);
        verifyAndInputById(pageProperties.getProperty("ForgottenPassword.EmailIDField"), "Customer Email Address", userProfile.getEmail());
        verifyAndClickWithXpath(pageProperties.getProperty("ForgottenPassword.ContinueButton"), "Continue Button");

        browser.wait(1000);

        //Setting up the user's temp password as temp12345
        new OnlineDBConnector().updateTempPassword(userProfile.getUCRN());

        //verifyAndClickWithLinkText(" asda ","asdasd "); //Go to your account link not working
        verifyAndClickWithLinkText(pageProperties.getProperty("ForgottenPassword.GoBackToLoginLink"), "Go back to Login ");

        verifyAndInputById("login-email", "Login ID", userProfile.getEmail());
        verifyAndInputById("login-password", "Temp Password", "temp12345");
        verifyAndClickWithClass("btn-input", "Login Button");
        browser.wait(getWaitTime());

        verifyAndClickWithName(pageProperties.getProperty("ForgottenPassword.PasswordSubmitButton"), "Submit Temporary Password Button");
        verifyIsElementVisibleWithXpath(pageProperties.getProperty("ForgottenPassword.FieldErrorMessage"), "Error Message for all field blank");
        verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSGHeader);
        verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSGSubHeader);
        verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSG_ForgottenPasswordBlankFieldTempPasswordPage);

        verifyAndInputById(pageProperties.getProperty("ForgottenPassword.YourTempPasswordField"), "Temporary Password", "temp12345");
        verifyAndInputById(pageProperties.getProperty("ForgottenPassword.YourNewPassword"), "New Password", "password12");
        verifyAndInputById(pageProperties.getProperty("ForgottenPassword.ConfirmPassword"), "ReEnter New Password", "password12");
        verifyAndClickWithName(pageProperties.getProperty("ForgottenPassword.PasswordSubmitButton"), "Submit Temporary Password Button");
        browser.wait(getWaitTime());
        browser.wait(1000);
        verifyIsTextPresent(GlobalErrorMessages.NewBlue_ForgottenPassword_ConfirmationMSG);

        verifyAndClickWithLinkText(pageProperties.getProperty("ForgottenPassword.GoBackToLoginLink"), "Go back to Login ");

        verifyAndInputById("login-email", "Login ID", userProfile.getEmail());
        verifyAndInputById("login-password", "Temp Password", "password12");
        verifyAndClickWithClass("btn-input", "Login Button");
        browser.wait(getWaitTime());

        verifyIsElementVisibleById("logoutMsg", "Home Page");
        verifyAndClickWithLinkText("Log out", "Log Out Link");
    }

    public void validateEmailAddressField(UserProfile userProfile) {


        String[] getEmailID;
        getEmailID = new String[5];
        getEmailID[0] = "abcdefghtest";    //InvalidEmailID
        getEmailID[1] = "£$%$%^&&";   //InvalidEmailID
        getEmailID[2] = "123456789";   //InvalidEmailID
        getEmailID[3] = "abc1234";
        getEmailID[4] = "kartic@bgdigitaltest.co.uk";

        for (int i = 0; i < 5; i++) {
            verifyAndInputById(pageProperties.getProperty("ForgottenPassword.EmailIDField"), "Customer Email Address", getEmailID[i]);
            verifyAndClickWithXpath(pageProperties.getProperty("ForgottenPassword.ContinueButton"), "Continue Button");

            browser.wait(1000);
            if (i == 4) {
                verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSGHeader);
                //verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSGSubHeader);
                verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSG_ForgottenPasswordIncorrectEmail);
            } else {
                verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSGHeader);
                verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSGSubHeader);
                verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSG_ForgottenPasswordEmailIDField);
            }
        }
        verifyAndClickWithLinkText(pageProperties.getProperty("ForgottenPassword.Cancel"), "Cancel Link");
        browser.wait(getWaitTime());
        browser.wait(1000);
    }

    public void validateNewPasswordField(UserProfile userProfile) {
        verifyAndInputById(pageProperties.getProperty("ForgottenPassword.EmailIDField"), "Customer Email Address", userProfile.getEmail());
        verifyAndClickWithXpath(pageProperties.getProperty("ForgottenPassword.ContinueButton"), "Continue Button");
        browser.wait(getWaitTime());
        browser.wait(1000);

        new OnlineDBConnector().updateTempPassword(userProfile.getUCRN());

        browser.wait(1000);

        //verifyAndClickWithLinkText(" asda ","asdasd "); //Go to your account link not working
        verifyAndClickWithLinkText(pageProperties.getProperty("ForgottenPassword.GoBackToLoginLink"), "Go back to Login ");

        verifyAndInputById("login-email", "Login ID", userProfile.getEmail());
        verifyAndInputById("login-password", "Temp Password", "temp12345");
        verifyAndClickWithClass("btn-input", "Login Button");
        browser.wait(getWaitTime());

        String[] getPassWord;
        getPassWord = new String[5];
        getPassWord[0] = "123";
        getPassWord[1] = "£$%&&";
        getPassWord[2] = "1a2b3c";
        getPassWord[3] = "abc";
        getPassWord[4] = "";

        for (int i = 0; i < 5; i++) {
            verifyAndInputById(pageProperties.getProperty("ForgottenPassword.YourTempPasswordField"), "Temporary Password", "temp12345");
            verifyAndInputById(pageProperties.getProperty("ForgottenPassword.YourNewPassword"), "New Password", getPassWord[i]);
            verifyAndInputById(pageProperties.getProperty("ForgottenPassword.ConfirmPassword"), "ReEnter New Password", getPassWord[i]);
            verifyAndClickWithName(pageProperties.getProperty("ForgottenPassword.PasswordSubmitButton"), "Submit Temporary Password Button");
            browser.wait(getWaitTime());
            browser.wait(1000);
            if (i == 4) {
                verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSGHeader);
                verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSGSubHeader);
                verifyIsElementVisibleWithXpath(pageProperties.getProperty("ForgottenPassword.FieldErrorMessage"), "New Password and ReenterN New Password field validation for the value '" + getPassWord[i] + "'");
            } else {
                verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSGHeader);
                verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSGSubHeader);
                verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSG_PasswordField);
            }
        }
    }

    public void validateTempPasswordField(UserProfile userProfile) {
        String[] arrTempPassWord;
        arrTempPassWord = new String[5];
        arrTempPassWord[0] = "123";
        arrTempPassWord[1] = "£$%&&";
        arrTempPassWord[2] = "1a2b3c";
        arrTempPassWord[3] = "abc";
        arrTempPassWord[4] = "";

        for (int i = 0; i < 5; i++) {
            verifyAndInputById(pageProperties.getProperty("ForgottenPassword.YourTempPasswordField"), "Temporary Password", arrTempPassWord[i]);
            verifyAndInputById(pageProperties.getProperty("ForgottenPassword.YourNewPassword"), "New Password", "password12");
            verifyAndInputById(pageProperties.getProperty("ForgottenPassword.ConfirmPassword"), "ReEnter New Password", "password12");
            verifyAndClickWithName(pageProperties.getProperty("ForgottenPassword.PasswordSubmitButton"), "Submit Temporary Password Button");
            browser.wait(getWaitTime());
            browser.wait(1000);
            if (i == 4) {
                verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSGHeader);

                verifyIsElementVisibleWithXpath(pageProperties.getProperty("ForgottenPassword.FieldErrorMessage"), "Temporary Password field validation for the value '" + arrTempPassWord[i] + "'");
            } else {
                verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSGHeader);

                verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSG_TempPasswordField);
            }
        }
    }

    public void validateErrorMessages(UserProfile userProfile) {
        verifyBlankFieldsError(userProfile);
        new HomePageAction()
                .navigateToForgottenPasswordScreen();
        validateEmailAddressField(userProfile);
        new LoginAction()
                .navigateToForgottenPasswordScreen();
        validateNewPasswordField(userProfile);
        validateTempPasswordField(userProfile);

    }
}
