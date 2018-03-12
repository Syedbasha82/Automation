package bg.framework.common.control;

import org.openqa.selenium.WebElement;

public class TextAreaControl extends UIControl {

    public TextAreaControl(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void setValue(String value) {
        webElement.sendKeys(value);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void click() {
        webElement.click();
    }
}
