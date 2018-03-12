package bg.framework.app.functional.page.obsolete;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
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
public class ForgottenEmailPage extends BasePage {
    private SimpleJdbcTemplate jdbcTemplate;
    private final static String FILE_NAME = "resources/selfServe/ForgottenEmailNewBlue.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
    OnlineDBConnector dbconnector = new OnlineDBConnector();

    public void validateForgottenEmailAddressJourney(UserProfile userProfile) {
        new OnlineDBConnector().updateUserEmail(userProfile.getUCRN(), userProfile.getEmail());
        verifyAndInputById(pageProperties.getProperty("ForgottenEmail.CustomerReferenceNumber"), "Customer Reference Number", userProfile.getGasAccount());
        verifyAndSelectDropDownBox(pageProperties.getProperty("ForgottenEmail.Title"), "Title", userProfile.getTitle());
        verifyAndInputById(pageProperties.getProperty("ForgottenEmail.FirstName"), "First Name", userProfile.getFirstName());
        verifyAndInputById(pageProperties.getProperty("ForgottenEmail.SurName"), "Sur Name", userProfile.getLastName());
        verifyAndClickWithXpath(pageProperties.getProperty("ForgottenEmail.GetEmailAddressButton"), "Get Email Address Button");
        verifyIsElementVisibleWithXpath(pageProperties.getProperty("ForgottenEmail.ConfirmationPageBreadCrumb"), "Retrieve Email Confirmation Screen's Bread Crumb");
        verifyIsElementVisibleWithXpath(pageProperties.getProperty("ForgottenEmail.ConfirmationMessage"), "Retrieve Email Confirmation Message");
        verifyIsTextPresent(userProfile.getEmail());
        verifyIsTextPresent(pageProperties.getProperty("ForgottenEmail.LoginToYourAccount"));

    }

    public void verifyBlankFieldsError() {
        verifyAndClickWithXpath(pageProperties.getProperty("ForgottenEmail.GetEmailAddressButton"), "Get Email Address Button");
        verifyIsElementVisibleWithXpath(pageProperties.getProperty("ForgottenEmail.FieldErrorMessage"), "Error Message for all field blank");
    }

    public void validateCustomerReferenceNumberField(UserProfile userProfile) {
        new OnlineDBConnector().updateUserEmail(userProfile.getUCRN(), userProfile.getEmail());

        String[] getAccNumber;
        getAccNumber = new String[6];
        getAccNumber[0] = "abcdefghtest";    //InvalidEmailID
        getAccNumber[1] = "£$%$%^&&";   //InvalidEmailID
        getAccNumber[2] = "";   //InvalidEmailID
        getAccNumber[3] = "123456789";   //InvalidEmailID
        getAccNumber[4] = "850002345";
        getAccNumber[5] = "1234567891111212";
        for (int i = 0; i < 6; i++) {
            verifyAndInputById(pageProperties.getProperty("ForgottenEmail.CustomerReferenceNumber"), "Customer Reference Number", getAccNumber[i]);
            verifyAndSelectDropDownBox(pageProperties.getProperty("ForgottenEmail.Title"), "Title", userProfile.getTitle());
            verifyAndInputById(pageProperties.getProperty("ForgottenEmail.FirstName"), "First Name", userProfile.getFirstName());
            verifyAndInputById(pageProperties.getProperty("ForgottenEmail.SurName"), "Sur Name", userProfile.getLastName());
            verifyAndClickWithXpath(pageProperties.getProperty("ForgottenEmail.GetEmailAddressButton"), "Get Email Address Button");
            verifyIsElementVisibleWithXpath(pageProperties.getProperty("ForgottenEmail.FieldErrorMessage"), "Customer Reference Number field validation for the value '" + getAccNumber[i] + "'");
        }
    }

    public void validateTitleField(UserProfile userProfile) {
        new OnlineDBConnector().updateUserEmail(userProfile.getUCRN(), userProfile.getEmail());
        verifyAndInputById(pageProperties.getProperty("ForgottenEmail.CustomerReferenceNumber"), "Customer Reference Number", userProfile.getGasAccount());
        verifyAndSelectDropDownBox(pageProperties.getProperty("ForgottenEmail.Title"), "Title", "Please select");
        verifyAndInputById(pageProperties.getProperty("ForgottenEmail.FirstName"), "First Name", userProfile.getFirstName());
        verifyAndInputById(pageProperties.getProperty("ForgottenEmail.SurName"), "Sur Name", userProfile.getLastName());
        verifyAndClickWithXpath(pageProperties.getProperty("ForgottenEmail.GetEmailAddressButton"), "Get Email Address Button");
        verifyIsElementVisibleWithXpath(pageProperties.getProperty("ForgottenEmail.FieldErrorMessage"), "Title field validation");
    }

    public void validateFirstNameField(UserProfile userProfile) {
        new OnlineDBConnector().updateUserEmail(userProfile.getUCRN(), userProfile.getEmail());

        String[] getFirstName;
        getFirstName = new String[6];
        getFirstName[0] = "1234567891111212";    //Invalid First Name
        getFirstName[1] = "£$%$%^&&";   //Invalid First Name
        getFirstName[2] = "";   //Invalid First Name
        getFirstName[3] = "123456789";   //Invalid First Name
        getFirstName[4] = "850002345";
        getFirstName[5] = "abcdefghtest";
        for (int i = 0; i < 6; i++) {
            verifyAndInputById(pageProperties.getProperty("ForgottenEmail.CustomerReferenceNumber"), "Customer Reference Number", userProfile.getGasAccount());
            verifyAndSelectDropDownBox(pageProperties.getProperty("ForgottenEmail.Title"), "Title", userProfile.getTitle());
            verifyAndInputById(pageProperties.getProperty("ForgottenEmail.FirstName"), "First Name", getFirstName[i]);
            verifyAndInputById(pageProperties.getProperty("ForgottenEmail.SurName"), "Sur Name", userProfile.getLastName());
            verifyAndClickWithXpath(pageProperties.getProperty("ForgottenEmail.GetEmailAddressButton"), "Get Email Address Button");
            if (i == 5) {
                verifyIsElementVisibleWithXpath(pageProperties.getProperty("ForgottenEmail.FieldErrorMessage2"), "First Name field validation for the value '" + getFirstName[i] + "'");
            } else {
                verifyIsElementVisibleWithXpath(pageProperties.getProperty("ForgottenEmail.FieldErrorMessage"), "First Name field validation for the value '" + getFirstName[i] + "'");
            }
        }
    }

    public void validateLastNameField(UserProfile userProfile) {
        new OnlineDBConnector().updateUserEmail(userProfile.getUCRN(), userProfile.getEmail());

        String[] getSurName;
        getSurName = new String[6];
        getSurName[0] = "1234567891111212";    //Invalid First Name
        getSurName[1] = "£$%$%^&&";   //Invalid First Name
        getSurName[2] = "";   //Invalid First Name
        getSurName[3] = "123456789";   //Invalid First Name
        getSurName[4] = "850002345";
        getSurName[5] = "abcdefghtest";
        for (int i = 0; i < 6; i++) {
            verifyAndInputById(pageProperties.getProperty("ForgottenEmail.CustomerReferenceNumber"), "Customer Reference Number", userProfile.getGasAccount());
            verifyAndSelectDropDownBox(pageProperties.getProperty("ForgottenEmail.Title"), "Title", userProfile.getTitle());
            verifyAndInputById(pageProperties.getProperty("ForgottenEmail.FirstName"), "First Name", userProfile.getFirstName());
            verifyAndInputById(pageProperties.getProperty("ForgottenEmail.SurName"), "Sur Name", getSurName[i]);
            verifyAndClickWithXpath(pageProperties.getProperty("ForgottenEmail.GetEmailAddressButton"), "Get Email Address Button");
            if (i == 5) {
                verifyIsElementVisibleWithXpath(pageProperties.getProperty("ForgottenEmail.FieldErrorMessage2"), "Sur Name field validation for the value '" + getSurName[i] + "'");
            } else {
                verifyIsElementVisibleWithXpath(pageProperties.getProperty("ForgottenEmail.FieldErrorMessage"), "Sur Name field validation for the value '" + getSurName[i] + "'");
            }
        }
    }

    public void validateErrorMessages(UserProfile userProfile) {
        verifyBlankFieldsError();
        validateCustomerReferenceNumberField(userProfile);
        validateTitleField(userProfile);
        validateFirstNameField(userProfile);
        validateLastNameField(userProfile);
    }
}
