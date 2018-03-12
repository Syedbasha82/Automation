/* Page:YourAccountsPage
 * CreatedBy: Banu
 * Created On: 02-01-2012
 * Description: Verification of the respective accounts in Your Accounts Page 
 */
package bg.framework.app.functional.page.selfServe;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SiebelDataBase;

import java.util.Properties;

public class YourAccountsPage extends BasePage {

    private final static String FILE_NAME = "resources/selfServe/" + "YourAccountPage"
            + ApplicationConfig.BRAND + ".properties";
    //private final static String FILE_NAME ="resources/selfServe/YourAccountPage.properties";
    private final static String SMR_FILE_NAME = "resources/selfServe/SubmitMeterReadPage.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    public void Verification(UserProfile userProfile) {

        browser.wait(getWaitTime());


        if (browser.isTextPresent(userProfile.getLastName())) {
            Report.updateTestLog(
                    "Customer Name with title:<b>" + userProfile.getLastName()
                            + "</b>found ", "PASS");
        } else {
            Report.updateTestLog("Customer Name with title:<b>" + userProfile.getTitle()
                    + " " + userProfile.getLastName() + "</b> not found ", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToProductsAndServicesPage() {
        browser.wait(getWaitTime());
        if (browser.isElementVisibleWithXpath(pageProperties
                .getProperty("YourAccountPage.ProductAndServices"))) {
            // System.out.println("link text: "+pageProperties.getProperty("YourAccountPage.ProductAndServices"));
            browser.clickWithXpath(pageProperties
                    .getProperty("YourAccountPage.ProductAndServices"));
            browser.wait(getWaitTime());
            Report.updateTestLog("Products and Services Link is clicked", "PASS");
        } else {
            Report.updateTestLog("Products and Services Link is not clicked", "FAIL");
        }

    }

    public void navigateToContactUsPage() {
        browser.open(ApplicationConfig.ContactUs_URL);
        // if
        // (browser.isTextPresent(pageProperties.getProperty("YourAccountPage.ContactUs"))){
        // browser.clickWithLinkText(pageProperties.getProperty("YourAccountPage.ContactUs"));
        // }
        browser.wait(getWaitTime());
    }

    public void navigateToAccount() {
        String logInfo = "";
        String logStatus = "DONE";

        if (browser.isElementVisibleWithXpath(pageProperties
                .getProperty("YourAccountPage.Overlay.ContinueToAcctXpath"))) {
            browser.clickWithXpath(pageProperties
                    .getProperty("YourAccountPage.Overlay.ContinueToAcctXpath"));
            logInfo = logInfo + "Selected Continue to Account in the Overlay";
        }
        Report.updateTestLog(logInfo, logStatus);

    }

    public void loginConfirmation(UserProfile userProfile) {

        String actualName = browser.getTextByXpath(pageProperties
                .getProperty("LoginPagedetails.lastname"));
        String expectedName = new SiebelDataBase().getTitle(userProfile.getUCRN()) + " "
                + new SiebelDataBase().getLastName(userProfile.getUCRN());
        System.out.print(expectedName + " is expected.   ");

        if (expectedName.equalsIgnoreCase(actualName)) {
            Report.updateTestLog("Name Verification is done" + actualName, "PASS");
        } else {
            Report.updateTestLog("Name Verification  Verification actual :" + actualName
                    + ", displayed :" + expectedName, "FAIL");
        }

        if (browser.isElementVisibleWithXpath(pageProperties
                .getProperty("LoginPagedetails.manageacct"))) {

            Report.updateTestLog("Manage Account Verification is displayed", "PASS");
        } else {
            Report.updateTestLog("Manage Account Verification is not displayed", "FAIL");
        }

        browser.clickWithXpath(pageProperties.getProperty("LoginPagedetails.Logout"));
        Report.updateTestLog("Logout of application", "DONE");

    }

    public void logout() {
        String logInfo = "";
        String logStatus = "PASS";

        if (browser.isTextPresent(pageProperties
                .getProperty("YourAccountPage.LogoutLinkText"))) {
            logInfo = logInfo + "Log out- Link found on page. ";
            browser.clickWithXpath(pageProperties
                    .getProperty("YourAccountPage.LogoutLinkXPath"));
            String expectedPageTitle = pageProperties.getProperty(
                    "YourAccountPage.AnonymousTitle").trim();
            String actualPageTitle = browser.getTextByXpath("//title").trim();

            if (!expectedPageTitle.equalsIgnoreCase(actualPageTitle)) {
                logInfo = logInfo
                        + "<b> Expected Log-out Page Title does not Match with Expected.</b> Expected Page Title: "
                        + expectedPageTitle + ". Actual page Title: " + actualPageTitle
                        + ". ";
                logStatus = "FAIL";

            } else
                logInfo = logInfo + " Log-out Page title matches with Expected. ";
            Report.updateTestLog(logInfo, logStatus);

        }

    }

    public void clickManageAccount(String accountNumber) {
        browser.wait(10000);

        if (browser.isElementVisibleWithXpath(pageProperties.getProperty(
                "YourAccountPage.ManageAccountXPath").replace("USERACCOUNTNUMBER",
                accountNumber))) {
            browser.clickWithXpath(pageProperties.getProperty(
                    "YourAccountPage.ManageAccountXPath").replace("USERACCOUNTNUMBER",
                    accountNumber));
            Report.updateTestLog(
                    "Manage account link <b>" + accountNumber + "</b> exist", "PASS");
            Report.updateTestLog("Manage account link <b>" + accountNumber
                    + "</b> clicked", "PASS");
        } else {
            Report.updateTestLog("Manage account link <b>" + accountNumber
                    + "</b> not exist", "FAIL");
            Report.updateTestLog("Manage account link <b>" + accountNumber
                    + "</b> not clicked", "FAIL");
        }
    }
}