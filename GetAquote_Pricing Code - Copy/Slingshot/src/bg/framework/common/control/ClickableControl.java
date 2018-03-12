package bg.framework.common.control;

import org.openqa.selenium.WebElement;

public class ClickableControl extends UIControl {

    public ClickableControl(WebElement webElement) {
        super(webElement);
    }


    @Override
    public void setValue(String value) {
        webElement.click();
    }
}
