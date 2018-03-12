package bg.framework.common.control;

import bg.framework.common.functional.UIDriver;
import bg.framework.common.functional.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


import java.util.List;

public abstract class UIControl {

    protected UIDriver webdriver;
    protected String value;
    protected String locator;
    protected WebElement webElement;

    public UIControl(WebElement webElement) {
        this.webElement = webElement;
        webdriver = WebDriverProvider.getCurrentDriver();
    }

    public String getValue() {
        return webElement.getText();
    }

    public abstract void setValue(String value);

    public void clearValue() {
        webElement.clear();
    }

    public List<WebElement> getOptions() {
        return webElement.findElements(By.tagName("option"));
    }

    public void sendKeys(Keys key) {
        webElement.sendKeys(key);
    }

    public String getAttribute(String attribute) {
        return this.webElement.getAttribute(attribute);
    } 
}
