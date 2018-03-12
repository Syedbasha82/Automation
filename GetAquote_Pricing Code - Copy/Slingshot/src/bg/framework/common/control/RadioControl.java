package bg.framework.common.control;

import org.openqa.selenium.WebElement;

public class RadioControl extends UIControl {

    public RadioControl(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void setValue(String value) {
        webElement.click();
    }
}
