package bg.framework.common.control;

import bg.framework.common.functional.UIDriver;
import bg.framework.common.functional.WebDriverProvider;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.HashMap;
import java.util.NoSuchElementException;

public final class ControlProvider {
    protected static UIDriver uiDriver = WebDriverProvider.getCurrentDriver();

    private String elementType;
    //	private static String elementLocator;
    private WebElement webElement;

    public ControlProvider() {
    }

    private static UIControl controlType(String elementType, WebElement webElementControl, String id) {
        HashMap<String, UIControl> controlMap = new HashMap<String, UIControl>();
        controlMap.put("text", new TextBoxControl(webElementControl));
        controlMap.put("tel", new TextBoxControl(webElementControl));
        controlMap.put("email", new TextBoxControl(webElementControl));
        controlMap.put("password", new TextBoxControl(webElementControl));
        controlMap.put("textarea", new TextAreaControl(webElementControl));
        controlMap.put("checkbox", new CheckBoxControl(webElementControl));
        controlMap.put("button", new ButtonControl(webElementControl));
        controlMap.put("submit", new ButtonControl(webElementControl));
        controlMap.put("input", new ButtonControl(webElementControl));
        controlMap.put("radio", new RadioControl(webElementControl));
        controlMap.put("select", new DropDownControl(webElementControl));
        controlMap.put("a", new ClickableControl(webElementControl));
        controlMap.put("span", new SpanControl(webElementControl));
        controlMap.put("image", new ClickableControl(webElementControl));
        controlMap.put("img", new ClickableControl(webElementControl));
        controlMap.put("strong", new ClickableControl(webElementControl));
        controlMap.put("div", new ClickableControl(webElementControl));

        if (elementType == null || elementType.equals("")) {
            Reporter.log("Control with [id] : " + id + " not found on page");
            throw new RuntimeException("Control with [id] : " + id + " not found on page");
        } else {
            return (UIControl) controlMap.get(elementType);
        }
    }

    public UIControl getControl(Finder finder) {
        try {
            webElement = uiDriver.findElement(finder.by());
        } catch (NoSuchElementException e) {
            System.out.println("No Element Present");
        }
        return controlType(getElementType(webElement), webElement, "");
    }

    public UIControl getSelectControl(Finder finder) {
        webElement = uiDriver.findElement(finder.by());
        return controlType("select", webElement, "");
    }

    public static String getElementType(WebElement webElement) {
        String attribute = webElement.getAttribute("type");
        if (attribute == null || attribute.equalsIgnoreCase("")) {
            attribute = webElement.getTagName();
        }
        return attribute == null ? "a" : attribute;
    }

}