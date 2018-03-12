package bg.framework.app.functional.page.selfServe;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 10/11/11
 * Time: 15:59
 * To change this template use File | Settings | File Templates.
 */

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

import java.util.List;
import java.util.Properties;

//import bg.framework.app.functional.util.SshClient;
//import static org.apache.commons.lang.StringUtils.isNotEmpty;
//import com.jcraft.jsch.JSchException;
//import org.apache.jasper.tagplugins.jstl.core.Catch;
//import org.apache.xalan.trace.PrintTraceListener;

public class LegacyContactUsPage extends BasePage {
    private final static String FILE_NAME = "resources/selfServe/ContactUsPage.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    String logPath = null;

    public LegacyContactUsPage() {
    }

    public LegacyContactUsPage(UserProfile userProfile) {

    }

    public void verifyUserDetailsOnPageOAM(UserProfile userProfile) {

    }

    public void verifyUserDetailsOnPageAnonymous(String logPath) {
        this.logPath = logPath;
        validateTitleError();
        validateFirstNameError();
        validateSurnameError();
        validateHouseNumber();

    }

    public void verifyUserDetailsOnPagePreSubmit() {

    }

    public void SubmitForm() {

    }

    public void fillEnquiryDetails() {
        List<String> enquiryDetails = getReasonList();
        for (int x = 1; x < enquiryDetails.size(); x++) {
            System.out.println(enquiryDetails.get(x));
            browser.selectfromDropBox("id", "accountType", enquiryDetails.get(x));
            browser.wait(getWaitTime());
            Boolean a = browser.isElementVisible("selectedReason");
            if (a) {
                List<String> category = browser.getFromDropBox("id", "selectedReason");
                for (int y = 1; y < category.size(); y++) {
                    System.out.println(category.get(y));
                    browser.selectfromDropBox("id", "selectedReason", category.get(y));
                }
            }
        }
    }

    public List<String> getReasonList() {
        List<String> reason = browser.getFromDropBox("id", "accountType");
        return reason;
    }

    public void validateTitleError() {
        browser.selectfromDropBox("id", "accountType", "Gas/Electricity Enquiries");
        browser.selectfromDropBox("id", "selectedReason", "Refunds");
        browser.inputByName(pageProperties.getProperty("ContactUsPage.oldTextArea"), "just testing");

        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.oldFirstName"))) {
            browser.input(pageProperties.getProperty("ContactUsPage.oldFirstName"), "test");
        }
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.oldLastName"))) {
            browser.input(pageProperties.getProperty("ContactUsPage.oldLastName"), "test");
        }
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.oldHouseNumber"))) {
            browser.input(pageProperties.getProperty("ContactUsPage.oldHouseNumber"), "12");
        }
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.oldPostcode"))) {
            browser.input(pageProperties.getProperty("ContactUsPage.oldPostcode"), "se23 1ln");
        }
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.oldEmailAddress"))) {
            browser.input(pageProperties.getProperty("ContactUsPage.oldEmailAddress"), "test@bgdigitaltest.com");
        }
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.oldTelephoneNumber"))) {
            browser.input(pageProperties.getProperty("ContactUsPage.oldTelephoneNumber"), "01234567890");
        }
        browser.clickWithXpath(pageProperties.getProperty("ContactUsPage.submitButton"));

        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ContactUsPage.oldErrorField"))) {
            Report.updateTestLog("negative Title Field Validation", "FAIL");
        } else {
            Report.updateTestLog("Error not present for negative Title field validation", "FAIL");
        }
    }

    public void validateFirstNameError() {
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.oldTitle"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.oldTitle"), "Mr");
        }
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.oldFirstName"))) {
            browser.clearValue(pageProperties.getProperty("ContactUsPage.oldFirstName"));
        }
        browser.clickWithXpath(pageProperties.getProperty("ContactUsPage.submitButton"));
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ContactUsPage.oldErrorField"))) {
            Report.updateTestLog("Empty FirstName Field Validation", "PASS");
        } else {
            Report.updateTestLog("Empty FirstName Field Validation", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.oldFirstName"))) {
            browser.clearValue(pageProperties.getProperty("ContactUsPage.oldFirstName"));
            browser.input(pageProperties.getProperty("ContactUsPage.oldFirstName"), "test1");
        }
        browser.clickWithXpath(pageProperties.getProperty("ContactUsPage.submitButton"));
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ContactUsPage.oldErrorField"))) {
            Report.updateTestLog("AlphaNumeric FirstName Field Validation", "PASS");
        } else {
            Report.updateTestLog("AlphaNumeric FirstName Field Validation", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.oldFirstName"))) {
            browser.clearValue(pageProperties.getProperty("ContactUsPage.oldFirstName"));
            browser.input(pageProperties.getProperty("ContactUsPage.oldFirstName"), "test&");
        }
        browser.clickWithXpath(pageProperties.getProperty("ContactUsPage.submitButton"));
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ContactUsPage.oldErrorField"))) {
            Report.updateTestLog("Special characters FirstName Field Validation", "PASS");
        } else {
            Report.updateTestLog("Special characters FirstName Field Validation", "FAIL");
        }
    }

    public void validateSurnameError() {
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.oldFirstName"))) {
            browser.clearValue(pageProperties.getProperty("ContactUsPage.oldFirstName"));
            browser.input(pageProperties.getProperty("ContactUsPage.oldFirstName"), "test");
        }
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.oldLastName"))) {
            browser.clearValue(pageProperties.getProperty("ContactUsPage.oldLastName"));
            //browser.input(pageProperties.getProperty("ContactUsPage.oldLastName"),"test");
        }
        browser.clickWithXpath(pageProperties.getProperty("ContactUsPage.submitButton"));
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ContactUsPage.oldErrorField"))) {
            Report.updateTestLog("Empty Surname Field Validation", "PASS");
        } else {
            Report.updateTestLog("Empty Surname Field Validation", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.oldLastName"))) {
            //browser.clearValue(pageProperties.getProperty("ContactUsPage.oldLastName"));
            browser.input(pageProperties.getProperty("ContactUsPage.oldLastName"), "te1st1");
        }
        browser.clickWithXpath(pageProperties.getProperty("ContactUsPage.submitButton"));
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ContactUsPage.oldErrorField"))) {
            Report.updateTestLog("AlphaNumeric Surname Field Validation", "PASS");
        } else {
            Report.updateTestLog("AlphaNumeric Surname Field Validation", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.oldLastName"))) {
            browser.clearValue(pageProperties.getProperty("ContactUsPage.oldLastName"));
            browser.input(pageProperties.getProperty("ContactUsPage.oldLastName"), "te#st&");
        }
        browser.clickWithXpath(pageProperties.getProperty("ContactUsPage.submitButton"));
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ContactUsPage.oldErrorField"))) {
            Report.updateTestLog("Special Characters Surname Field Validation", "PASS");
        } else {
            Report.updateTestLog("Special Characters Surname Field Validation", "FAIL");
        }
    }

    public void validateHouseNumber() {
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.oldLastName"))) {
            browser.clearValue(pageProperties.getProperty("ContactUsPage.oldLastName"));
            browser.input(pageProperties.getProperty("ContactUsPage.oldLastName"), "test");
        }
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.oldHouseNumber"))) {
            browser.clearValue(pageProperties.getProperty("ContactUsPage.oldHouseNumber"));
            browser.input(pageProperties.getProperty("ContactUsPage.oldHouseNumber"), "te#st&");
        }
        browser.clickWithXpath(pageProperties.getProperty("ContactUsPage.submitButton"));
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ContactUsPage.oldErrorField"))) {
            Report.updateTestLog("Special Characters House No/name Validation", "PASS");
        } else {
            Report.updateTestLog("Special Characters House No/name Field Validation", "FAIL");
        }
    }
    /*public void runAutoCefBatch(){
                SshClient sshClient = new SshClient();
        try {
            sshClient.connect("wl_fit", "wl_fit", "10.224.70.44", 22);
            if(sshClient.isConnected()){
            //sshClient.send("ls -l");    }
            System.out.println(sshClient.send("ls -l")); }
            sshClient.disconnect();
        } catch (JSchException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }*/
}
