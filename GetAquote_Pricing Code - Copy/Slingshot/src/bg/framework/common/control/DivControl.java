package bg.framework.common.control;

import org.openqa.selenium.WebElement;

public class DivControl extends UIControl {

    public DivControl(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void setValue(String value) {
        webElement.submit();
    }
}
