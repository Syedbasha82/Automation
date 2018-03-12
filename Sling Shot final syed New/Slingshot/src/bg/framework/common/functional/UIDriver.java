package bg.framework.common.functional;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class UIDriver implements WebDriver {

    private final Logger log = LoggerFactory.getLogger(UIDriver.class);

    private WebDriver _webDriver;

    public UIDriver(WebDriver webDriver) {
        _webDriver = webDriver;
    }

    public void get(String s) {
        _webDriver.get(s);
    }

    public String getCurrentUrl() {
        return _webDriver.getCurrentUrl();
    }

    public String getTitle() {
        return _webDriver.getTitle();
    }

    public List<WebElement> findElements(By by) {
        return _webDriver.findElements(by);
    }

    public WebElement findElement(final By by) {
        WebDriverWait wait = new WebDriverWait(_webDriver, 1);

        try {
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver _webDriver) {
                    return (_webDriver.findElement(by) != null);
                }
            });
        } catch (Exception e) {
            log.info(e.getMessage());
            System.out.println();
        }
        return _webDriver.findElement(by);
    }

    //
    // public WebElement findElement(By by) {
    //
    // return _webDriver.findElement(by);
    // }

    public String getPageSource() {
        return _webDriver.getPageSource();
    }

    public void close() {
        _webDriver.close();
    }

    public void quit() {
        _webDriver.quit();
    }

    public Set<String> getWindowHandles() {
        return _webDriver.getWindowHandles();
    }

    public String getWindowHandle() {
        return _webDriver.getWindowHandle();
    }

    public TargetLocator switchTo() {
        return _webDriver.switchTo();
    }

    public Navigation navigate() {
        return _webDriver.navigate();
    }

    public void captureScreen(String file) {
        File screenShotFile = ((TakesScreenshot) _webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile, new File(file));
        } catch (IOException e) {
            e.printStackTrace(); // To change body of catch statement use File |
            // Settings | File Templates.
        }
    }

    public Options manage() {
        return null; // To change body of implemented methods use File |
        // Settings | File Templates.
    }

    public void ExecuteJavascript(String jCommand) {
        JavascriptExecutor js = (JavascriptExecutor) _webDriver;
        try{
            System.out.println("XXXXX "+js.executeScript(jCommand,"electric", true));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public boolean isElementPresent(String locator) {

        return false;
    }

    public void browserBack() {
        _webDriver.navigate().back();       
        
    }
    
    public void deleteAllCookies(){
    	_webDriver.manage().deleteAllCookies();
    }
    
    public WebDriver getWebDriver(){
    	return _webDriver;
    }
}

    
