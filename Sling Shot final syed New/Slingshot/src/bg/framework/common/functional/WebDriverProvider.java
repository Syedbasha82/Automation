package bg.framework.common.functional;

import bg.framework.app.functional.common.ApplicationConfig;


public class WebDriverProvider {

    private static WebDriverProvider webDriverProvider;
    private static UIDriver uiDriver;

    public static WebDriverProvider instance() {
        if (webDriverProvider == null) {
            webDriverProvider = new WebDriverProvider();
        }
        return webDriverProvider;
    }

    public static void makeDriver() {
        uiDriver = new UIDriver(new WebDriverFactory().getDriver(WebDriverFactory.browserType.valueOf(ApplicationConfig.BROWSER)));
    }

    public static UIDriver getCurrentDriver() {
        if (uiDriver == null) {
            makeDriver();
        }
        return uiDriver;
    }

      
    public static UIDriver getWebDriver() {
        return uiDriver;
    }

    public static void quitDriver() {
        if (uiDriver != null) {
            uiDriver.quit();
            uiDriver = null;
        }
    }
}
