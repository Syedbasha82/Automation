package bg.framework.app.functional.page.selfServe;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import org.openqa.selenium.NoSuchElementException;

import java.util.Properties;

public class SelfRegistrationPage extends BasePage {

    private final static String File_RegPage = "resources/reFactoring/RegistrationPageRewrite.properties";
    private static Properties regPageProperties = new PropertyLoader(File_RegPage).load();
    private final static String File_YourAcctPage = "resources/selfServe/"
            + ApplicationConfig.BRAND + "AccountOverview.properties";
    private static Properties yourAcctPageProperties = new PropertyLoader(
            File_YourAcctPage).load();
    private final static String email_Domain = "bgdigitaltest.co.uk";
    private final static String confirm_EmailMismatchChar = "a";
    private final static String noNectarValue = "4";
    private final static String addNewNectarValue = "2";
    private final static String addExistingNectarValue = "1";
    private final static String acceptTermsValue = "Y";
    public static String curRegAcctnumber = "";
    public static String curRegEmailAddress = "";
    String logPath = null;

    OnlineDBConnector dbconnector = new OnlineDBConnector();
    String systemDate;
    String ReferenceNo;

    public SelfRegistrationPage() {
    }

    public void registerUpdateYourDetails(UserProfile selfRegisterData,
                                          String accountNumber) {
        String logInfo = "";
        String logStatus = "PASS";

        try {

            curRegAcctnumber = accountNumber;
            logInfo = logInfo + " Registering using Account number: <b>"
                    + curRegAcctnumber + " </b>. ";
            browser.clearValue(regPageProperties.getProperty("RegistrationPage.AccNoText"));
            browser.input(regPageProperties.getProperty("RegistrationPage.AccNoText"),
                    curRegAcctnumber);

            browser.selectfromDropBox("id", regPageProperties.getProperty("RegistrationPage.TitleSelectId"), selfRegisterData.getTitle());

            browser.clearValue(regPageProperties.getProperty("RegistrationPage.FirstNameTextId"));
            browser.input(
                    regPageProperties.getProperty("RegistrationPage.FirstNameTextId"),
                    selfRegisterData.getFirstName());

            browser.clearValue(regPageProperties.getProperty("RegistrationPage.LastNameTextId"));
            browser.input(
                    regPageProperties.getProperty("RegistrationPage.LastNameTextId"),
                    selfRegisterData.getLastName());

            browser.clickWithXpath(regPageProperties
                    .getProperty("RegistrationPage.Continue1ButtonXPath"));

            String emailData = selfRegisterData.getEmail();
            String confirmEmailData = selfRegisterData.getEmail();
            String emailOnPage = browser.getAttribute(
                    regPageProperties.getProperty("RegistrationPage.EmailTextId"),
                    "value");
            if (emailOnPage.trim().length() > 0)
                logInfo = logInfo + " Email address prepopulated on PageLoad: "
                        + emailOnPage + ". \n";
            else
                logInfo = logInfo
                        + "<b> Email address field is not populated on page load. </b>"
                        + emailOnPage + ". \n";

            if (null != emailOnPage && !emailOnPage.trim().equals("")
                    && emailOnPage.contains("@")) {
                emailOnPage = emailOnPage.substring(0, emailOnPage.indexOf('@'));

            } else if (null != emailOnPage && emailOnPage.trim().equals(""))
                emailOnPage = null;

            String emailAddress = emailOnPage == null ? emailData : emailOnPage + "@"
                    + email_Domain;

            if (null == confirmEmailData
                    || !confirmEmailData.trim().equalsIgnoreCase("invalid")) {
                confirmEmailData = emailAddress;
            } else {
                confirmEmailData = confirm_EmailMismatchChar + emailAddress;

            }

            browser.clearValue(regPageProperties
                    .getProperty("RegistrationPage.EmailTextId"));

            browser.input(regPageProperties.getProperty("RegistrationPage.EmailTextId"),
                    emailAddress);
            curRegEmailAddress = emailAddress;
            logInfo = logInfo + "Updating user email address as '" + emailAddress + "'. ";
            if (browser.getAttribute(
                    regPageProperties.getProperty("RegistrationPage.ConfirmEmailTextId"),
                    "value").length() > 0) {
                logInfo = logInfo
                        + "<b> Confirm Email Text is not blank on Page Load.</b> The value is: "
                        + browser.getAttribute(regPageProperties
                        .getProperty("RegistrationPage.ConfirmEmailTextId"),
                        "value") + "\n ";
                logStatus = "FAIL";
            }

            browser.input(
                    regPageProperties.getProperty("RegistrationPage.ConfirmEmailTextId"),
                    confirmEmailData);

            browser.input(
                    regPageProperties.getProperty("RegistrationPage.PasswordTextId"),
                    selfRegisterData.getPassword());
            browser.input(regPageProperties
                    .getProperty("RegistrationPage.ConfirmPasswordTextId"),
                    selfRegisterData.getPassword());

            browser.selectfromDropBox("id", regPageProperties
                    .getProperty("RegistrationPage.Security_questionSelectId"),
                    selfRegisterData.getSecurityQuestion());

            browser.input(regPageProperties
                    .getProperty("RegistrationPage.Security_answerTextId"),
                    selfRegisterData.getSecurityAnswer());

            browser.input(regPageProperties.getProperty("RegistrationPage.PhoneTextId"),
                    selfRegisterData.getPhoneNumber());

            browser.selectfromDropBox("id",
                    regPageProperties.getProperty("RegistrationPage.PhoneTypeSelectId"),
                    selfRegisterData.getPhoneType());

            //String acceptTerms = "y";
            //if (acceptTerms.startsWith(acceptTermsValue.toLowerCase())) {
                browser.click(regPageProperties
                        .getProperty("RegistrationPage.acceptTermsCheckBoxId"));
           // }

            // Update Nectar InformationHere
            String nectarInput = selfRegisterData.getNectarValue();
            if (browser.isElementVisible(regPageProperties
                    .getProperty("RegistrationPage.NoNectarRadioId"))) {
                if (nectarInput.trim().equalsIgnoreCase(noNectarValue)) {
                    browser.click(regPageProperties
                            .getProperty("RegistrationPage.NoNectarRadioId"));
                    logInfo = logInfo + " No Nectar Needed option. ";
                } else if (nectarInput.trim().equalsIgnoreCase(addNewNectarValue)) {
                    browser.click(regPageProperties
                            .getProperty("RegistrationPage.AddNewNectarRadioId"));
                    logInfo = logInfo + " Selected Add New Nectar Option. ";
                } else if (nectarInput.trim().equalsIgnoreCase(addExistingNectarValue)) {
                    browser.click(regPageProperties
                            .getProperty("RegistrationPage.card_number"));
                    browser.input(regPageProperties
                            .getProperty("RegistrationPage.NectarTextId"),
                            selfRegisterData.getNectarValue());
                    logInfo = logInfo
                            + " Selected Add Existing Nectar Option. Added the Card: "
                            + selfRegisterData.getNectarValue() + ". ";
                }

                String acceptNectarTerms = selfRegisterData.getAcceptTerms()
                        .toLowerCase();
                if (browser.isElementVisible(regPageProperties
                        .getProperty("RegistrationPage.NectarTermsCheckBoxId"))) {
                    if (acceptNectarTerms.startsWith(acceptTermsValue.toLowerCase())) {
                        browser.click(regPageProperties
                                .getProperty("RegistrationPage.NectarTermsCheckBoxId"));
                    }
                }
            }
            // Update Log if Nectar Option Not Found on Page.
            else {
                logInfo = logInfo + "<b>No Nectar Radio button Not Found on Page. </b>";

            }

            browser.clickWithXpath(regPageProperties
                    .getProperty("RegistrationPage.Continue2ButtonXPath"));
            Thread.sleep(1000);
            // Verify Registration Success Messsage
            if (browser.isTextPresent(regPageProperties
                    .getProperty("RegistrationPage.SuccessMessage")))
                logInfo = logInfo
                        + " User Registration Completed.<b>Success Message found on Page. ";
            else {
                logInfo = logInfo
                        + " User Registration Completed.<b>Success Message not found.</b> User is in Page: "
                        + browser.getTextByXpath("//title");

                logStatus = "FAIL";
            }

            // Verify Nectar Confirmation Message.
            if (addNewNectarValue.trim().equalsIgnoreCase(
                    selfRegisterData.getNectarValue().trim())
                    || addExistingNectarValue.trim().equalsIgnoreCase(
                    selfRegisterData.getNectarValue().trim())) {
                if (browser.isTextPresent(regPageProperties
                        .getProperty("RegistrationPage.NewNectarSuccessMessage")))
                    logInfo = logInfo
                            + " New Nectar Added Success Message found on Page. ";
                else {
                    logInfo = logInfo
                            + " <b>Nectar Success Message not found.</b> User is in Page: "
                            + browser.getTextByXpath("//title") + ". ";
                    logStatus = "FAIL";
                }

            }
        } catch (NoSuchElementException ex) {
            logInfo = logInfo + "Caught Exception: " + ex.getMessage() + ". \n";
            logStatus = "FAIL";

            ex.printStackTrace();
            Report.updateTestLog(logInfo, logStatus);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void goToYourAccount() {
        verifyAndClickWithLinkText(regPageProperties.getProperty("RegistrationPage.GotoYourAccLnk"), "Go to your account");
        new LegacyLoginPage().continueToMyAccount();
    }
    public void enterAndValidateEmailId(UserProfile userProfile){
    	verifyAndInputById(regPageProperties.getProperty("RegistrationPage.EmailTextId"),"To be Register Email Address", userProfile.getEmail()); 	
    }
}
