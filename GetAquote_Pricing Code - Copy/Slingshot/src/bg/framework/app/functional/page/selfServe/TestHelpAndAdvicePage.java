package bg.framework.app.functional.page.selfServe;

import bg.framework.app.functional.page.common.*;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

import java.util.Properties;

public class TestHelpAndAdvicePage extends BasePage {
    private final static String FILE_NAME = "resources/selfServe/HelpAndAdvicePage.Properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    public TestHelpAndAdvicePage() {
    }

    public void verifyLinksHelpAndAdvicePage() {
        browser.wait(10000);
        for (int i = 1; i <= 10; i++) {
            browser.wait(10000);
            browser.clickWithXpath(pageProperties.getProperty("HelpAndAdvicePage.Linkxpath") + "[" + i + "]/div[2]/h4/a");
            browser.wait(10000);
            verifyContent(i);
            navigatetoHelpandAdvice();
        }
    }

    public void verifyLinksHeaderFooter() {
        navigateToAboutUsPage();
        navigateToContactUsPage();
        navigateToEmergenciesPage();
        navigateToTermsconditionsPage();
        navigateToPrivacyPage();
    }

    public void verifySubLandingPageLinks() {
        verifyBillsAndPaymentsSublandingPage();
        verifyTariffsAddonsSublandingPage();
        verifyOnlineAccountSublandingPage();
        verifyPayAsYouGoEnergySublandingPage();
        verifyBoilerHomeCareSublandingPage();
        verifyMovingHomeSublandingPage();
        verifyNectarSublandingPage();
        verifyMoreSublandingPage();
    }

    private void verifyContent(int i) {

        String strValue = pageProperties.getProperty("HelpAndAdvicePage.Linkxpathname" + "[" + i + "]");
        String actualValue = browser.getTextByXpath(pageProperties.getProperty("HelpAndAdvicePage.SublandingPage"));
        if (actualValue.trim().contains(strValue.trim()))
            Report.updateTestLog("Sublanding Page Verification " + ":" + strValue + " Text Verified", "PASS");
        else {
            Report.updateTestLog("Sublanding Page Verification " +
                    "Expected :" + strValue + "Actual :" + actualValue + " Text Missing", "FAIL");
        }
    }

    public void verifySublandingPage() {
        if (browser.isElementVisible(pageProperties.getProperty("HelpAndAdvicePage.YesButton"))) {
            browser.click(pageProperties.getProperty("HelpAndAdvicePage.YesButton"));
            browser.wait(5000);
            browser.input(pageProperties.getProperty("HelpAndAdvicePage.CommentBox"), "It's Good");
            browser.clickWithXpath(pageProperties.getProperty("HelpAndAdvicePage.SendButton"));
            String strThnk = browser.getText(pageProperties.getProperty("HelpAndAdvicePage.ThankComments"));
            Report.updateTestLog("Comments Verified  :" + strThnk, "PASS");
        } else {
            Report.updateTestLog("Comments Not Verified ", "FAIL");
        }
    }

    private void verifyBillsAndPaymentsSublandingPage() {

        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("HelpAndAdvicePage.BillsAndPaymentsLandingPageLink"))) {
            String strLnk = browser.getTextByXpath(pageProperties.getProperty("HelpAndAdvicePage.BillsAndPaymentsLandingPageLink"));
            browser.clickWithXpath(pageProperties.getProperty("HelpAndAdvicePage.BillsAndPaymentsLandingPageLink"));
            Report.updateTestLog("Link Verified  :" + strLnk, "PASS");
        }
        for (int i = 1; i <= 8; i++) {
            browser.clickWithLinkText(pageProperties.getProperty("HelpAndAdvicePage.BillAndPaymentsLandingPage" + "[" + i + "]"));
            browser.wait(2000);
            String strVal = pageProperties.getProperty("HelpAndAdvicePage.BillAndPaymentsLandingPage" + "[" + i + "]");
            if (browser.isTextPresent(strVal)) {
                Report.updateTestLog("Sublanding Page Verification :" + strVal + " Text Verified", "PASS");
            } else {
                Report.updateTestLog("Sublanding Page Verification " + strVal + "Expected Text Missing", "FAIL");
            }
        }
        navigatetoHelpandAdvice();
    }

    private void verifyTariffsAddonsSublandingPage() {

        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("HelpAndAdvicePage.TariffsAddonsLandingPageLink"))) {
            String strLnk = browser.getTextByXpath(pageProperties.getProperty("HelpAndAdvicePage.TariffsAddonsLandingPageLink"));
            browser.clickWithXpath(pageProperties.getProperty("HelpAndAdvicePage.TariffsAddonsLandingPageLink"));
            Report.updateTestLog("Link Verified  :" + strLnk, "PASS");
        }
        for (int i = 1; i <= 3; i++) {

            verifyAndClickWithLinkText(pageProperties.getProperty("HelpAndAdvicePage.TariffsAddons" + "[" + i + "]"), "Tariff Link : " + pageProperties.getProperty("HelpAndAdvicePage.TariffsAddons" + "[" + i + "]"));
            browser.wait(2000);
            String strVal = pageProperties.getProperty("HelpAndAdvicePage.TariffsAddons" + "[" + i + "]");
            if (browser.isTextPresent(strVal)) {
                Report.updateTestLog("Sublanding Page Verification :" + strVal + " Text Verified", "PASS");
            } else {
                Report.updateTestLog("Sublanding Page Verification " + strVal + "Expected Text Missing", "FAIL");
            }
        }
        navigatetoHelpandAdvice();
    }

    private void verifyOnlineAccountSublandingPage() {

        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("HelpAndAdvicePage.OnlineAccountLandingPageLink"))) {
            String strLnk = browser.getTextByXpath(pageProperties.getProperty("HelpAndAdvicePage.OnlineAccountLandingPageLink"));
            browser.clickWithXpath(pageProperties.getProperty("HelpAndAdvicePage.OnlineAccountLandingPageLink"));
            Report.updateTestLog("Link Verified  :" + strLnk, "PASS");
        }
        for (int i = 1; i <= 5; i++) {
            browser.clickWithLinkText(pageProperties.getProperty("HelpAndAdvicePage.OnlineAccount" + "[" + i + "]"));
            browser.wait(2000);
            String strVal = pageProperties.getProperty("HelpAndAdvicePage.OnlineAccount" + "[" + i + "]");
            if (browser.isTextPresent(strVal)) {
                Report.updateTestLog("Sublanding Page Verification :" + strVal + " Text Verified", "PASS");
            } else {
                Report.updateTestLog("Sublanding Page Verification " + strVal + "Expected Text Missing", "FAIL");
            }
        }
        navigatetoHelpandAdvice();
    }

    private void verifyPayAsYouGoEnergySublandingPage() {

        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("HelpAndAdvicePage.PayAsYouGoEnergyLandingPageLink"))) {
            String strLnk = browser.getTextByXpath(pageProperties.getProperty("HelpAndAdvicePage.PayAsYouGoEnergyLandingPageLink"));
            browser.clickWithXpath(pageProperties.getProperty("HelpAndAdvicePage.PayAsYouGoEnergyLandingPageLink"));
            Report.updateTestLog("Link Verified  :" + strLnk, "PASS");
        }
        for (int i = 1; i <= 5; i++) {
            browser.clickWithLinkText(pageProperties.getProperty("HelpAndAdvicePage.PayAsYouGoEnergy" + "[" + i + "]"));
            browser.wait(2000);
            String strVal = pageProperties.getProperty("HelpAndAdvicePage.PayAsYouGoEnergy" + "[" + i + "]");
            if (browser.isTextPresent(strVal)) {
                Report.updateTestLog("Sublanding Page Verification :" + strVal + " Text Verified", "PASS");
            } else {
                Report.updateTestLog("Sublanding Page Verification " + strVal + "Expected Text Missing", "FAIL");
            }
        }
        navigatetoHelpandAdvice();
    }

    private void verifyBoilerHomeCareSublandingPage() {

        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("HelpAndAdvicePage.BoilerHomeCareLandingPageLink"))) {
            String strLnk = browser.getTextByXpath(pageProperties.getProperty("HelpAndAdvicePage.BoilerHomeCareLandingPageLink"));
            browser.clickWithXpath(pageProperties.getProperty("HelpAndAdvicePage.BoilerHomeCareLandingPageLink"));
            Report.updateTestLog("Link Verified  :" + strLnk, "PASS");
        }
        for (int i = 1; i <= 4; i++) {
            verifyAndClickWithLinkText(pageProperties.getProperty("HelpAndAdvicePage.BoilerHomeCare" + "[" + i + "]"), "Link : " + pageProperties.getProperty("HelpAndAdvicePage.BoilerHomeCare" + "[" + i + "]"));
            browser.wait(2000);
            String strVal = pageProperties.getProperty("HelpAndAdvicePage.BoilerHomeCare" + "[" + i + "]");
            if (browser.isTextPresent(strVal)) {
                Report.updateTestLog("Sublanding Page Verification :" + strVal + " Text Verified", "PASS");
            } else {
                Report.updateTestLog("Sublanding Page Verification " + strVal + "Expected Text Missing", "FAIL");
            }
        }
        navigatetoHelpandAdvice();
    }

    private void verifyMovingHomeSublandingPage() {

        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("HelpAndAdvicePage.MovingHomeLandingPageLink"))) {
            String strLnk = browser.getTextByXpath(pageProperties.getProperty("HelpAndAdvicePage.MovingHomeLandingPageLink"));
            browser.clickWithXpath(pageProperties.getProperty("HelpAndAdvicePage.MovingHomeLandingPageLink"));
            Report.updateTestLog("Link Verified  :" + strLnk, "PASS");
        }
        for (int i = 1; i <= 3; i++) {
            verifyAndClickWithLinkText(pageProperties.getProperty("HelpAndAdvicePage.MovingHome" + "[" + i + "]"), "Link " + pageProperties.getProperty("HelpAndAdvicePage.MovingHome" + "[" + i + "]"));
            browser.wait(2000);
            String strVal = pageProperties.getProperty("HelpAndAdvicePage.MovingHome" + "[" + i + "]");
            if (browser.isTextPresent(strVal)) {
                Report.updateTestLog("Sublanding Page Verification :" + strVal + " Text Verified", "PASS");
            } else {
                Report.updateTestLog("Sublanding Page Verification " + strVal + "Expected Text Missing", "FAIL");
            }
        }
        navigatetoHelpandAdvice();
    }

    private void verifyNectarSublandingPage() {

        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("HelpAndAdvicePage.NectarLandingPageLink"))) {
            String strLnk = browser.getTextByXpath(pageProperties.getProperty("HelpAndAdvicePage.NectarLandingPageLink"));
            browser.clickWithXpath(pageProperties.getProperty("HelpAndAdvicePage.NectarLandingPageLink"));
            Report.updateTestLog("Link Verified  :" + strLnk, "PASS");
        }
        for (int i = 1; i <= 3; i++) {
            browser.clickWithLinkText(pageProperties.getProperty("HelpAndAdvicePage.Nectar" + "[" + i + "]"));
            browser.wait(2000);
            String strVal = pageProperties.getProperty("HelpAndAdvicePage.Nectar" + "[" + i + "]");
            if (browser.isTextPresent(strVal)) {
                Report.updateTestLog("Sublanding Page Verification :" + strVal + " Text Verified", "PASS");
            } else {
                Report.updateTestLog("Sublanding Page Verification " + strVal + "Expected Text Missing", "FAIL");
            }
        }
        navigatetoHelpandAdvice();
    }

    private void verifyMoreSublandingPage() {

        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("HelpAndAdvicePage.MoreLandingPageLink"))) {
            String strLnk = browser.getTextByXpath(pageProperties.getProperty("HelpAndAdvicePage.MoreLandingPageLink"));
            browser.clickWithXpath(pageProperties.getProperty("HelpAndAdvicePage.MoreLandingPageLink"));
            Report.updateTestLog("Link Verified  :" + strLnk, "PASS");
        }
        for (int i = 1; i <= 3; i++) {
            browser.clickWithLinkText(pageProperties.getProperty("HelpAndAdvicePage.More" + "[" + i + "]"));
            browser.wait(2000);
            String strVal = pageProperties.getProperty("HelpAndAdvicePage.More" + "[" + i + "]");
            if (browser.isTextPresent(strVal)) {
                Report.updateTestLog("Sublanding Page Verification :" + strVal + " Text Verified", "PASS");
            } else {
                Report.updateTestLog("Sublanding Page Verification " + strVal + "Expected Text Missing", "FAIL");
            }
        }
        navigatetoHelpandAdvice();
    }

    public void navigatetoHelpandAdvice() {
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("HelpAndAdvicePage.HelpAndAdviceLink"))) {
            browser.clickWithXpath(pageProperties.getProperty("HelpAndAdvicePage.HelpAndAdviceLink"));
        }
    }

    public void navigatetoSublandingPage() {
        browser.clickWithXpath(pageProperties.getProperty("HelpAndAdvicePage.Linkxpath") + "[1]/div[2]/h4/a");
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("HelpAndAdvicePage.BillAndPaymentsLink"))) {
            String strLnk = browser.getTextByXpath(pageProperties.getProperty("HelpAndAdvicePage.BillAndPaymentsLink"));
            browser.clickWithXpath(pageProperties.getProperty("HelpAndAdvicePage.BillAndPaymentsLink"));
            Report.updateTestLog("Link Verified  :" + strLnk, "PASS");
            browser.wait(5000);
            String strQuesLnk = browser.getTextByXpath(pageProperties.getProperty("HelpAndAdvicePage.SubLandingBillAndPaymentsLink"));
            browser.clickWithXpath(pageProperties.getProperty("HelpAndAdvicePage.SubLandingBillAndPaymentsLink"));
            Report.updateTestLog("Link Verified  :" + strQuesLnk, "PASS");
            browser.wait(5000);
        }

    }

    public void searchHelpandAdvice() {
        if (browser.isElementVisible(pageProperties.getProperty("HelpAndAdvicePage.SearchTextBox"))) {
            browser.input(pageProperties.getProperty("HelpAndAdvicePage.SearchTextBox"), "bills");
            browser.click(pageProperties.getProperty("HelpAndAdvicePage.SearchButton"));
            browser.wait(2000);
            String strText = browser.getTextByXpath(pageProperties.getProperty("HelpAndAdvicePage.SearchResults"));
            Report.updateTestLog("Search Text Verified  :" + strText, "PASS");
        } else {
            Report.updateTestLog("Search Text Not Verified  ", "FAIL");
        }
        navigatetoHelpandAdvice();
    }

    public void navigateToAboutUsPage() {
        if (browser.isTextPresent(pageProperties.getProperty("HelpAndAdvicePage.Aboutus"))) {
            browser.clickWithLinkText(pageProperties.getProperty("HelpAndAdvicePage.Aboutus"));
            browser.isTextPresent("About us");
            Report.updateTestLog("Navigate to About Us page", "PASS");
        } else {
            Report.updateTestLog("Navigate to About Us page", "FAIL");
        }
        browser.wait(getWaitTime());
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToHelpandAdvicePage();
    }

    public void navigateToContactUsPage() {
        if (browser.isTextPresent(pageProperties.getProperty("HelpAndAdvicePage.ContactUsLink"))) {
            browser.clickWithLinkText(pageProperties.getProperty("HelpAndAdvicePage.ContactUsLink"));
            browser.isTextPresent("Contact us");
            Report.updateTestLog("Navigate to Contact Us page", "PASS");
        } else {
            Report.updateTestLog("Navigate to Contact Us page", "FAIL");
        }
        browser.wait(getWaitTime());
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToHelpandAdvicePage();
    }

    public void navigateToEmergenciesPage() {
        if (browser.isTextPresent(pageProperties.getProperty("HelpAndAdvicePage.Emergencies"))) {
            browser.clickWithLinkText(pageProperties.getProperty("HelpAndAdvicePage.Emergencies"));
            browser.isTextPresent("Emergencies");
            Report.updateTestLog("Navigate to Emergencies page", "PASS");
        } else {
            Report.updateTestLog("Navigate to Emergencies page", "FAIL");
        }
        browser.wait(getWaitTime());
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToHelpandAdvicePage();
    }

    public void navigateToTermsconditionsPage() {
        if (browser.isTextPresent(pageProperties.getProperty("HelpAndAdvicePage.Emergencies"))) {
            browser.clickWithLinkText(pageProperties.getProperty("HelpAndAdvicePage.Emergencies"));
            browser.isTextPresent("Terms and Conditions");
            Report.updateTestLog("Navigate to Terms and Conditions page", "PASS");
        } else {
            Report.updateTestLog("Navigate to Terms and Conditions page", "FAIL");
        }
        browser.wait(getWaitTime());
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToHelpandAdvicePage();
    }

    public void navigateToPrivacyPage() {
        if (browser.isTextPresent(pageProperties.getProperty("HelpAndAdvicePage.Privacy"))) {
            browser.clickWithLinkText(pageProperties.getProperty("HelpAndAdvicePage.Privacy"));
            browser.isTextPresent("Privacy");
            Report.updateTestLog("Navigate to Privacy page", "PASS");
        } else {
            Report.updateTestLog("Navigate to Privacy page", "FAIL");
        }
        browser.wait(getWaitTime());
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToHelpandAdvicePage();
    }
}
