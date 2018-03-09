package bg.framework.common.control;

import org.openqa.selenium.WebElement;

public class TextBoxControl extends UIControl {

    public TextBoxControl(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void setValue(String value) {
        webElement.sendKeys(value);
    }

    public void click() {
        webElement.click();
    }

    public void clearValue() {
        webElement.clear();
    }
}
