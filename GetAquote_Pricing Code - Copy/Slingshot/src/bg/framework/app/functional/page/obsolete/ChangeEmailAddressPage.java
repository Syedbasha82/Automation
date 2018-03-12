package bg.framework.app.functional.page.obsolete;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.GlobalErrorMessages;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 21/02/12
 * Time: 12:26
 * To change this template use File | Settings | File Templates.
 */
public class ChangeEmailAddressPage extends BasePage {
    private SimpleJdbcTemplate jdbcTemplate;
    private final static String FILE_NAME = "resources/selfServe/ChangeEmailAddressNewBlue.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
    OnlineDBConnector dbconnector = new OnlineDBConnector();

    public void validateChangeEmailAddressJourney(UserProfile userProfile) {
        String strNewEmailAddress = "cea" + userProfile.getEmail();
        verifyAndInputById(pageProperties.getProperty("ChangeEmailAddress.OldEmailTextBox"), "Old Email ID Text Box", userProfile.getEmail());
        verifyAndInputById(pageProperties.getProperty("ChangeEmailAddress.PasswordTextBox"), "Password Text Box", userProfile.getPassword());
        verifyAndInputById(pageProperties.getProperty("ChangeEmailAddress.NewEmailAddress"), "New Email Address Text Box", strNewEmailAddress);
        verifyAndInputById(pageProperties.getProperty("ChangeEmailAddress.ConfirmNewEmailAddress"), "Confirm New Email Address Text Box", strNewEmailAddress);
        verifyAndClickWithXpath(pageProperties.getProperty("ChangeEmailAddress.ContinueButton"), "Continue Button");
        browser.wait(10000);
        if (browser.isTextPresent(pageProperties.getProperty("ChangeEmailAddress.ConfirmationMessage1"))) {
            Report.updateTestLog("Email Updation confirmation message '" + pageProperties.getProperty("ChangeEmailAddress.ConfirmationMessage1") + "' exist in the confirmation screen", "PASS");
            if (browser.isTextPresent(pageProperties.getProperty("ChangeEmailAddress.ConfirmationMessage2"))) {
                Report.updateTestLog("Email Updation confirmation message '" + pageProperties.getProperty("ChangeEmailAddress.ConfirmationMessage2") + "' exist in the confirmation screen", "PASS");
                if (browser.isTextPresent(strNewEmailAddress)) {
                    Report.updateTestLog("New Email Address '" + strNewEmailAddress + "' displayed in the confirmation screen", "PASS");
                } else {
                    Report.updateTestLog("New Email Address '" + strNewEmailAddress + "' is not displayed in the confirmation screen", "FAIL");
                }
            } else {
                Report.updateTestLog("Email Updation confirmation message '" + pageProperties.getProperty("ChangeEmailAddress.ConfirmationMessage2") + "' does not exist in the confirmation screen", "FAIL");
            }

            /*if (browser.isTextPresent(pageProperties.getProperty("ChangeEmailAddress.ConfirmationMessage3"))) {
                Report.updateTestLog("Email Updation confirmation message '" + pageProperties.getProperty("ChangeEmailAddress.ConfirmationMessage3") + "' exist in the confirmation screen", "PASS");
            } else {
                Report.updateTestLog("Email Updation confirmation message '" + pageProperties.getProperty("ChangeEmailAddress.ConfirmationMessage3") + "' does not exist in the confirmation screen", "FAIL");
            }*/
            if (browser.isTextPresent(pageProperties.getProperty("ChangeEmailAddress.LoginToYourAccountLink"))) {
                Report.updateTestLog("Login to your account link exist in the confirmation screen", "PASS");
            } else {
                Report.updateTestLog("Login to your account link does not exist in the confirmation screen", "FAIL");
            }
        } else {
            Report.updateTestLog("Change Email Address Journey is not successful.", "FAIL");
        }
        new OnlineDBConnector().updateUserEmail(userProfile.getUCRN(), userProfile.getEmail());
    }

    private void verifyBlankFieldsError() {
        verifyAndClickWithXpath(pageProperties.getProperty("ChangeEmailAddress.ContinueButton"), "In Change Email Address page, Continue Button");
        browser.wait(2000);
        verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSGHeader);
        verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSGSubHeader);
        verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSG_EmailIDField);
        verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSG_PasswordField);
    }

    public void validateOldEmailError(UserProfile userProfile) {
        String strNewEmailAddress = "cea" + userProfile.getEmail();
        String[] getOldEmailAddress;
        getOldEmailAddress = new String[4];
        getOldEmailAddress[0] = "1234567";    //InvalidEmailID
        getOldEmailAddress[1] = "abc%^&de";   //InvalidEmailID
        getOldEmailAddress[2] = "";   //InvalidEmailID
        getOldEmailAddress[3] = "1234567@tessco.co.uk";   //InvalidEmailID
        for (int i = 0; i < 4; i++) {

            verifyAndInputById(pageProperties.getProperty("ChangeEmailAddress.OldEmailTextBox"), "Old Email Text Box", getOldEmailAddress[i]);
            verifyAndInputById(pageProperties.getProperty("ChangeEmailAddress.PasswordTextBox"), "Password Text Box", userProfile.getPassword());
            verifyAndInputById(pageProperties.getProperty("ChangeEmailAddress.NewEmailAddress"), "New Email Address Text Box", strNewEmailAddress);
            verifyAndInputById(pageProperties.getProperty("ChangeEmailAddress.ConfirmNewEmailAddress"), "Confirm New Email Address Text Box", strNewEmailAddress);
            verifyAndClickWithXpath(pageProperties.getProperty("ChangeEmailAddress.ContinueButton"), "Continue Button");
            browser.wait(2000);
            if (i == 3) {
                verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSG_EmailIDFieldEmailNotPresentInDB);
            } else {
                verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSG_EmailIDField);
            }
        }
    }

    private void validatePasswordError(UserProfile userProfile) {
        String strNewEmailAddress = "cea" + userProfile.getEmail();
        String[] getPassword;
        getPassword = new String[4];
        getPassword[0] = "12";    //InvalidEmailID
        getPassword[1] = "%^&de";   //InvalidEmailID
        getPassword[2] = "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq";   //InvalidEmailID
        getPassword[3] = "";
        for (int i = 0; i < 4; i++) {
            verifyAndInputById(pageProperties.getProperty("ChangeEmailAddress.OldEmailTextBox"), "Old Email Text Box", userProfile.getEmail());
            verifyAndInputById(pageProperties.getProperty("ChangeEmailAddress.PasswordTextBox"), "Password Text Box", getPassword[i]);
            verifyAndInputById(pageProperties.getProperty("ChangeEmailAddress.NewEmailAddress"), "New Email Address Text Box", strNewEmailAddress);
            verifyAndInputById(pageProperties.getProperty("ChangeEmailAddress.ConfirmNewEmailAddress"), "Confirm New Email Address Text Box", strNewEmailAddress);
            verifyAndClickWithXpath(pageProperties.getProperty("ChangeEmailAddress.ContinueButton"), "Continue Button");
            browser.wait(2000);
            if (i == 3) {
                verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSG_PasswordField);
            } else {
                verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSG_PasswordFieldCondition);
            }
        }
    }

    private void validateNewEmailAddressError(UserProfile userProfile) {
        String strNewEmailAddress = "cea" + userProfile.getEmail();
        String[] getNewEmailAddress;
        getNewEmailAddress = new String[4];
        getNewEmailAddress[0] = "1234567";    //InvalidEmailID
        getNewEmailAddress[1] = "abc%^&de";   //InvalidEmailID
        getNewEmailAddress[2] = "";   //InvalidEmailID
        getNewEmailAddress[3] = "12345 qwe";   //InvalidEmailID
        for (int i = 0; i < 4; i++) {
            verifyAndInputById(pageProperties.getProperty("ChangeEmailAddress.OldEmailTextBox"), "Old Email Text Box", userProfile.getEmail());
            verifyAndInputById(pageProperties.getProperty("ChangeEmailAddress.PasswordTextBox"), "Password Text Box", userProfile.getPassword());
            verifyAndInputById(pageProperties.getProperty("ChangeEmailAddress.NewEmailAddress"), "New Email Address Text Box", getNewEmailAddress[i]);
            verifyAndInputById(pageProperties.getProperty("ChangeEmailAddress.ConfirmNewEmailAddress"), "Confirm New Email Address Text Box", getNewEmailAddress[i]);
            verifyAndClickWithXpath(pageProperties.getProperty("ChangeEmailAddress.ContinueButton"), "Continue Button");
            browser.wait(2000);
            verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSG_EmailIDField);
        }
    }

    private void validateConfirmNewEmailAddressError(UserProfile userProfile) {
        verifyAndInputById(pageProperties.getProperty("ChangeEmailAddress.OldEmailTextBox"), "Old Email Text Box", userProfile.getEmail());
        verifyAndInputById(pageProperties.getProperty("ChangeEmailAddress.PasswordTextBox"), "Password Text Box", userProfile.getPassword());
        verifyAndInputById(pageProperties.getProperty("ChangeEmailAddress.NewEmailAddress"), "New Email Address Text Box", "abc@bgdigitaltest.co.uk");
        verifyAndInputById(pageProperties.getProperty("ChangeEmailAddress.ConfirmNewEmailAddress"), "Confirm New Email Address Text Box", "abc123@bgdigitaltest.co.uk");
        verifyAndClickWithXpath(pageProperties.getProperty("ChangeEmailAddress.ContinueButton"), "Continue Button");
        browser.wait(2000);
        verifyIsTextPresent(GlobalErrorMessages.NewBlue_ErrorMSG_NewEmailAndConfirmEmailMismatch);
    }

    public void validateErrorMessages(UserProfile userProfile) {
        verifyBlankFieldsError();
        validateOldEmailError(userProfile);
        validatePasswordError(userProfile);
        validateNewEmailAddressError(userProfile);
        validateConfirmNewEmailAddressError(userProfile);
    }
}
