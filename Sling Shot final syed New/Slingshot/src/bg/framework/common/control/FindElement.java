package bg.framework.common.control;

import org.openqa.selenium.By;

public class FindElement implements Finder {

    private String locator;
    private String locatorType;

    public FindElement(String locator, String locatorType) {
        this.locator = locator;
        this.locatorType = locatorType;
    }

    public enum locatorType1 {
        controlId,
        linkText,
        cssSelector,
        controlName,
        partialLinkText,
        className,
        xpath,
        tagName
    }


    public By by() {
        switch (locatorType1.valueOf(locatorType)) {
            case controlId:
                return By.id(locator);
            case linkText:
                return By.linkText(locator);
            case cssSelector:
                return By.cssSelector(locator);
            case controlName:
                return By.className(locator);
            case partialLinkText:
                return By.partialLinkText(locator);
            case className:
                return By.className(locator);
            case xpath:
                return By.xpath(locator);
            case tagName:
                return By.tagName(locator);
            default:
                return By.id(locator);
        }
    }
}
