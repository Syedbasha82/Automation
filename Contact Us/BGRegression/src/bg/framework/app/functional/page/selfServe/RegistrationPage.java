package bg.framework.app.functional.page.selfServe;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

import java.util.Properties;

//import com.sun.jna.platform.win32.Netapi32Util;

/* Class  : RegistrationPage
 Created by: shanthi
 Created On: 23-12-2011
 Description: Function which contains all the methods related to RegistrationPage

 */
public class RegistrationPage extends BasePage {

    private final static String FILE_NAME = "resources/selfServe/RegistrationPage.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    String logPath = null;

    OnlineDBConnector dbconnector = new OnlineDBConnector();
    String systemDate;
    String ReferenceNo;

    public RegistrationPage() {
    }

    public RegistrationPage(UserProfile regProfile) {

    }

    /*
      * Method : enterRegistrationFirstStep Created by: shanthi Created On:
      * 23-12-2011 Description: Method to Enter first step of registration
      * Journey
      */
    public void enterRegistrationFirstStep(UserProfile userProfile) {
        browser.selectfromDropBox("id",
                pageProperties.getProperty("ContactUsPage.contactCategoryID"),
                "Gas/Electricity Enquiries");
        browser.selectfromDropBox("id",
                pageProperties.getProperty("ContactUsPage.contactReasonID"), "Refunds");
        browser.input(pageProperties.getProperty("ContactUsPage.contactQuery"), "just testing");
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.emailAddress"))) {
            browser.input(pageProperties.getProperty("ContactUsPage.emailAddress"),
                    userProfile.getEmail());
            Report.updateTestLog("Email Address Entered", "PASS");
        } else {
            Report.updateTestLog("Email Address Not Entered", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.telephoneNumber"))) {
            browser.input(pageProperties.getProperty("ContactUsPage.telephoneNumber"),
                    userProfile.getMobileNumber());
            Report.updateTestLog("TelePhone Number Entered", "PASS");
        } else {
            Report.updateTestLog("TelePhone Number Not Entered", "FAIL");
        }
        browser.click(pageProperties.getProperty("ContactUsPage.smsContactPreference"));
        browser.click(pageProperties.getProperty("ContactUsPage.telephoneContactPreference"));
        browser.click(pageProperties.getProperty("ContactUsPage.emailContactPreference"));
        if (browser.isElementVisibleWithXpath(pageProperties
                .getProperty("ContactUsPage.sendButton"))) {
            browser.clickWithXpath(pageProperties.getProperty("ContactUsPage.sendButton"));
            Report.updateTestLog("Anonymous Journey Completed", "PASS");
        } else {
            Report.updateTestLog("Anonymous Journey Not Completed", "FAIL");
        }
    }

    public void enterAccPref(UserProfile userProfile) {
        String emailId = browser.getText("RegisterationPage.Email");
        if (!emailId.equals("")) {
            Report.updateTestLog("Email Id is prepopulated", "PASS");
        } else {
            Report.updateTestLog("Email Id is NOT prepopulated", "FAIL");
            browser.input(pageProperties.getProperty("RegisterationPage.Email"),
                    userProfile.getEmail());
        }
        browser.input(pageProperties.getProperty("RegisterationPage.Email"), userProfile.getEmail());
        browser.input(pageProperties.getProperty("RegisterationPage.Email_repeat"),
                userProfile.getEmail());
        browser.input(pageProperties.getProperty("RegisterationPage.Password"),
                userProfile.getPassword());
        browser.input(pageProperties.getProperty("RegisterationPage.Password_repeat"),
                userProfile.getPassword());
        browser.selectfromDropBox("id",
                pageProperties.getProperty("RegisterationPage.Security_question"),
                userProfile.getPassword());
        browser.input(pageProperties.getProperty("RegisterationPage.Security_answer"),
                userProfile.getPassword());
        browser.selectfromDropBox("id", pageProperties.getProperty("RegisterationPage.Phone_type"),
                userProfile.getPassword());
        browser.input(pageProperties.getProperty("RegisterationPage.Phone"),
                userProfile.getPassword());

        browser.clickWithXpath(pageProperties.getProperty("RegisterationPage.Continue2"));

    }

}
