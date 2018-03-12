package bg.framework.app.functional.page.bgb;

import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;

import java.util.Properties;

//import bg.framework.common.functional.WebDriverProvider;

public class MultiSiteHomePage extends BasePage {
    private final static String FILE_NAME = "resources/bgb/LoginMultiSite.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    public LoginMultiSitePage navigateToLoginPage() {
        //System.out.println("Home Page");
        browser.wait(5000);
        verifyAndClickWithLinkText("Terms and Condition", "Terms and Condition Link");
        //browser.clickWithLinkText("Terms and Condition");
        verifyAndClickWithXpath(pageProperties.getProperty("BGBLogin.homeLogin"), "Home Login");

        return new LoginMultiSitePage();
    }

}
