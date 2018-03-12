package bg.framework.common.control;

import org.openqa.selenium.WebElement;

public class SpanControl extends UIControl {

    public SpanControl(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void setValue(String value) {
        webElement.click();
    }
}
