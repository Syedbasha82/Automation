package bg.framework.common.control;

import org.openqa.selenium.WebElement;

public class ButtonControl extends UIControl {

    public ButtonControl(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void setValue(String value) {
        webElement.click();
    }
}
