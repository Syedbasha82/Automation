package bg.framework.common.functional;

//import bg.framework.app.functional.page.Slingshot.Set;
import bg.framework.app.functional.util.Report;
import bg.framework.common.control.*;
import bsh.org.objectweb.asm.Constants;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.internal.seleniumemulation.GetXpathCount;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;

import com.thoughtworks.selenium.Selenium;

import java.io.IOException;
import java.lang.Object;
import java.util.List;

import javax.swing.UIDefaults;

public class UIOperation {

    protected UIDriver uiDriver;
    public UIOperation browser;
    protected Verify verify = new Verify();

    public UIOperation(UIDriver uiDriver) {
        this.uiDriver = uiDriver;
    }


    public String getAttributeByXpath(String xPath, String Attribute) {
        UIControl controlType = new ControlProvider().getControl(new FindByXpath(xPath));
        return controlType.getAttribute(Attribute);
    }

    public boolean isSelectedByXpath(String xpath) {
        try {
            WebElement webElement;
            webElement = uiDriver.findElement(By.xpath(xpath));
            if (webElement.isSelected()) {
                return true;
            }
        } catch (NoSuchElementException ex) {
            return false;
        }
        return false;
    }

    public String getAttribute(String locator, String Attribute) {

        UIControl controlType = new ControlProvider().getControl(new FindById(locator));
        return controlType.getAttribute(Attribute);

    }

    public void clickWithLinkText(String linkText) {
        UIControl controlType = new ControlProvider().getControl(new FindElement(
                linkText, "linkText"));
        controlType.setValue(linkText);
    }

    public void input(String id, String value) {
        UIControl controlType = new ControlProvider().getControl(new FindById(id));
        controlType.setValue(value);
    	
    }
    public void inputdata(String id, String value) {
    	uiDriver.findElement(By.id(id)).sendKeys(value);    	
    }
    

    public void clearValue(String id) {
        UIControl controlType = new ControlProvider().getControl(new FindById(id));
        controlType.clearValue();
    }

    public void clearValueByName(String name) {
        UIControl controlType = new ControlProvider().getControl(new FindByName(name));
        controlType.clearValue();
    }

    public void clearValueByXpath(String xpath) {
        UIControl controlType = new ControlProvider().getControl(new FindByXpath(xpath));
        controlType.clearValue();
    }

    public void inputByName(String name, String value) {
        UIControl controlType = new ControlProvider().getControl(new FindByName(name));
        controlType.clearValue();
        controlType.setValue(value);
    }

    public void click(String locator) {
        UIControl controlType = new ControlProvider().getControl(new FindById(locator));
        controlType.setValue(locator);
    }

    public boolean isSelected(String locator) {
        try {
            WebElement webElement;
            webElement = uiDriver.findElement(By.id(locator));
            if (webElement.isSelected()) {
                return true;
            }
        } catch (NoSuchElementException ex) {
            return false;
        }
        return false;
    }

    public void clickWithName(String locator) {
        UIControl controlType = new ControlProvider().getControl(new FindByName(locator));
        controlType.setValue(locator);
    }

    public void selectWindow(String windowTitle) {
        uiDriver.switchTo().window(windowTitle);
    }
    

    public boolean isTextVisible(String text) {
        // WebElement we =
        // uiDriver.findElement(By.xpath("//*[contains(.,'"+text+"')]"));
        WebElement we = uiDriver.findElement(By.xpath(text));
        System.out.println("is displayed " + we.isDisplayed());
        System.out.println("is enabled " + we.isEnabled());
        System.out.println("is attribute " + we.getAttribute(text));
        return we.isDisplayed();
    }
    public boolean isTextbox_empty(String xpath)
    {
    WebElement we =uiDriver.findElement(By.xpath(xpath));
    if(we.getText().equals(" "))
    {
    	System.out.println("i am in");
    	return true;
    }
    	
		return false;
	 }
    public void swtichToDefaultContent() {
        uiDriver.switchTo().defaultContent();        
    }

    public void selectWindowById(int windowId) {
        uiDriver.switchTo().frame(windowId);
    }
   
    public void selectWindowById(String windowName){
    	uiDriver.switchTo().frame(windowName);
    }
    public void selectWindowByName(String windowName) {
        uiDriver.switchTo().frame(windowName);
    }
    public void execJS(String jCommand) {
        uiDriver.ExecuteJavascript(jCommand);
    }

    public void closeAlert() {
        Alert alert = uiDriver.switchTo().alert();
        // wait(1000);
        if (alert.getText() != null) {
            alert.accept();
        }
    }

    public void wait(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickWithClass(String locator) {
        UIControl controlType = new ControlProvider()
                .getControl(new FindByClass(locator));
        controlType.setValue(locator);
        
    }

    public void clickWithXpath(String xpath) {
        UIControl controlType = new ControlProvider().getControl(new FindByXpath(xpath));
        controlType.setValue(xpath);
    }
    

    public boolean isElementVisible(String locator) {
        WebElement webElement;
        try {
            webElement = uiDriver.findElement(By.id(locator));
            if (webElement.isDisplayed()) {
                return true;
            }
            
            return false;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementVisibleWithClass(String locator) {
        WebElement webElement;
        try {
            webElement = uiDriver.findElement(By.className(locator));
            if (webElement.isDisplayed()) {
                return true;
            }
            return false;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementVisibleWithName(String locator) {
        WebElement webElement;
        try {
            webElement = uiDriver.findElement(By.name(locator));
            if (webElement.isDisplayed()) {
                return true;
            }
            return false;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void captureScreen(String file) {
        uiDriver.captureScreen(file);
    }

    public boolean isElementVisibleWithXpath(String xPath) {
        try {
            WebElement webElement;
            webElement = uiDriver.findElement(By.xpath(xPath));
            if (webElement.isDisplayed()) {
                return true;
            }

        } catch (NoSuchElementException ex) {
            return false;
        }
        
        return false;
    }
    
    public void clickbutton(String item)
    {
    	uiDriver.findElement(By.id(item)).click();
    }

    public void open(String url) {
        uiDriver.switchTo().defaultContent();
        uiDriver.get(url);
    }
    public void refresh(){
        uiDriver.manage().deleteAllCookies();
        uiDriver.navigate().to("resources/common/ClearCacheFirefox.html");
        uiDriver.navigate().refresh();
    }
    public void close() {
        // uiDriver.switchTo().defaultContent();
//        uiDriver.close();
         uiDriver.quit();
    }

    public void inputWithName(String locator, String value) {
        UIControl controlType = new ControlProvider().getControl(new FindByName(locator));
        controlType.setValue(value);
    }

    public void selectfromDropBox(String locatorType, String locator, String value) {
        if (locatorType.equals("id")) {
            new ControlProvider().getSelectControl(new FindById(locator)).setValue(value);
        } else {
            new ControlProvider().getSelectControl(new FindByName(locator)).setValue(value);
        }
    }
  
    
    public void selectfromDropBoxByXpath(String xpath, String value) {
        new ControlProvider().getSelectControl(new FindByXpath(xpath)).setValue(value);        
    }
        public void selectFromDropBoxByID(String locatorType, String locator) {
        if (locatorType.equals("id")) {
            String value = new ControlProvider().getSelectControl(new FindById(locator)).getOptions().get(0).getText();
            System.out.println(value);
            new ControlProvider().getSelectControl(new FindById(locator)).setValue(value);
        } else {
            String value = new ControlProvider().getSelectControl(new FindById(locator)).getOptions().get(0).getText();
            System.out.println(value);
            new ControlProvider().getSelectControl(new FindByName(locator)).setValue(
                    value);
        }
    }
    
    public String getTextFromDropBox(String locatorType, String locator) {
        String elementList;
        if (locatorType.equalsIgnoreCase("id")) {
            elementList = new ControlProvider().getSelectControl(new FindById(locator))
                    .getValue();
        } else {
            elementList = new ControlProvider().getSelectControl(new FindByName(locator))
                    .getValue();
        }
        return elementList;
    }

    public ArrayList<String> getFromDropBox(String locatorType, String locator) {
        List<WebElement> elementList = new ArrayList();
        ArrayList<String> textList = new ArrayList();
        if (locatorType.equalsIgnoreCase("id")) {
            elementList = new ControlProvider().getSelectControl(new FindById(locator))
                    .getOptions();
        } else {
            elementList = new ControlProvider().getSelectControl(new FindByName(locator))
                    .getOptions();
        }

        for (int num = 0; num < elementList.size(); num++) {
            textList.add(elementList.get(num).getText());
        }
        return textList;
    }

    public void hitEnterKey() {
        uiDriver.findElement(By.xpath("//div[@id='submit']")).click();
    }
    public void hitEnterKeyxpath(String xpath) {
        uiDriver.findElement(By.xpath(xpath)).sendKeys(Keys.ENTER);
    }
    public String getText(String locator) {
        return uiDriver.findElement(By.id(locator)).getText();
    }

    public String getTextByXpath(String xPath) {
        return uiDriver.findElement(By.xpath(xPath)).getText();
    }

    public boolean isTextPresent(String text) {
        String xpath = "";
        if (!text.contains("'"))
            xpath = "//*[contains(text(),'" + text + "')]";
        else
            xpath = "//*[contains(text(),\"" + text + "\")]";
        List<WebElement> textElements = uiDriver.findElements(By.xpath(xpath));
        if (textElements.size() > 0) {
            return true;
        }

        return false;
    }

    public String getURL() {
        return uiDriver.getCurrentUrl();
    }
    
   /* public void getLocation() {
    	Point point = uiDriver.findElement(By.xpath("")).
    	
    	
    }*/
    
    
    
    public int locationVerificationX(String locator){
    	Point point = uiDriver.findElement(By.xpath(locator)).getLocation();
    	int x = point.x;
    	return x;
    } 
    public int locationVerificationY(String locator){
    	Point point = uiDriver.findElement(By.xpath(locator)).getLocation();
    	int Y = point.y;
    	return Y;
    } 
    
    
    public int imageWidth(String locator){
    	Dimension dimesions =  uiDriver.findElement(By.xpath(locator)).getSize();
    	int Width = dimesions.width;
    	return Width;
    } 
    public int imageHeight(String locator){
    	Dimension dimesions =  uiDriver.findElement(By.xpath(locator)).getSize();
    	int Height = dimesions.height;
    	return Height;
    } 
    
    
    
 public String getTitle(){
	 return uiDriver.getTitle();
 }
    public void inputByXpath(String xPath, String value) {
        UIControl controlType = new ControlProvider().getControl(new FindByXpath(xPath));
        controlType.setValue(value);
    }

    public int getRowCountByXpath(String tablexPath) {

        WebElement table_element = uiDriver.findElement(By.xpath(tablexPath));
        List<WebElement> tr_collection = table_element.findElements(By.xpath(tablexPath
                + "/tbody/tr"));
        	System.out.println("tr_collection"+tr_collection);
        return tr_collection.size();

    }

    public int getColCountByXpath(String tablexPath) {
        WebElement table_element = uiDriver.findElement(By.xpath(tablexPath));
        List<WebElement> tr_collection = table_element.findElements(By.xpath(tablexPath
                + "/tbody/tr[1]/td"));
        return tr_collection.size();
    }

    public String getCellValueByXpath(String tablexPath, int rowNum, int colNum) {
        System.out.println("Gonna use: " + tablexPath + "/tbody/tr[" + rowNum + "]/td["
                + colNum + "]");
        WebElement cellElement = uiDriver.findElement(By.xpath(tablexPath + "/tbody/tr["
                + rowNum + "]/td[" + colNum + "]"));
        return cellElement.getText();
    }

    public int getChildElementsCountByXpath(String xpath) {
        return uiDriver.findElements(By.xpath(xpath)).size();
    }

    public void browserBack() {
        uiDriver.browserBack();
            }
    public void executeScript(String script){
        //JavascriptExecutor js = (JavascriptExecutor) uiDriver;
        uiDriver.ExecuteJavascript(script);

    }
    
    public WebElement getChildelementBasedonOrder(String xpath, int indexno){
        List<WebElement> all_element = uiDriver.findElements(By.xpath(xpath));
        
        if (all_element.size() > indexno )  {           
        return all_element.get(indexno);
        }
        else {
         return null; }
                      
            }
    
    public void WaitForElementWithId(String Id){
        WebDriver webDriver = WebDriverProvider.getCurrentDriver();
        WebDriverWait wait = new WebDriverWait(webDriver,100);        
        
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Id)));
        
     }

    
    public void deleteAllCookies(){
    	uiDriver.deleteAllCookies();
    }

    /**
	* Executes a script on an element
	* @note Really should only be used when the web driver is sucking at exposing
	* functionality natively
	* @param script The script to execute
	* @param element The target of the script, referenced as arguments[0]
	*/
	public void trigger(String script, WebElement element) {
	    ((JavascriptExecutor)uiDriver.getWebDriver()).executeScript(script, element);
	}
	 
	/** Executes a script
	* @note Really should only be used when the web driver is sucking at exposing
	* functionality natively
	* @param script The script to execute
	*/
	public Object trigger(String script) {
	    return ((JavascriptExecutor)uiDriver.getWebDriver()).executeScript(script);
	}
	 
	/**
	* Opens a new tab for the given URL
	* @param url The URL to 
	 * @throws JavaScriptException If unable to open tab
	*/
	public void openTab(String url) {
		
	    String script = "var d=document,a=d.createElement('a');a.target='_blank';a.href='%s';a.innerHTML='.';d.body.appendChild(a);return a";
	    Object element = trigger(String.format(script, url));
	    if (element instanceof WebElement) {
	        WebElement anchor = (WebElement) element; anchor.click();
	        trigger("var a=arguments[0];a.parentNode.removeChild(a);", anchor);
	    }      
	    
	}
	
	public void switchWindowToPrev(String strUrlTitle)
	{
	 
		uiDriver.switchTo().window(strUrlTitle);
	}		

	public void swithnewwindow_getTitle()
	{
		String winHandleBefore = uiDriver.getWindowHandle();
		for(String winHandle : uiDriver.getWindowHandles()){
			uiDriver.switchTo().window(winHandle);			
		}
		Report.updateTestLog("New Window Title name is appreared As Expected"+getWindowTitle(),"Pass");
		uiDriver.close();
		uiDriver.switchTo().window(winHandleBefore);
	}

	
	public String getWindowTitle()
	{
	 
		return uiDriver.getTitle();
	}
public void switchToPrevFrame(){
	uiDriver.switchTo().frame("relative=up");
	
}
public void closeCrmAlert(){
	try{
		if(uiDriver.switchTo().alert().getText()!=null){
			uiDriver.switchTo().alert().accept();
			Report.updateTestLog("Dialog box get closed", "DONE");
		}
	}
    catch(Exception e){
    	Report.updateTestLog("Exception", "FAIL");
    }
}

public void clickcsssele(){
	uiDriver.findElement(By.cssSelector("p.accordion-head plus"));
}

/*public String executeScriptGetText(String script){
    //JavascriptExecutor js = (JavascriptExecutor) uiDriver;
    String gettext=uiDriver.ExecuteJavascript(script);
    return gettext;
}*/

public void clickWithCss(String css) {
   /* UIControl controlType = new ControlProvider().getControl(new FindByXpath(xpath));
    controlType.setValue(xpath);*/
    uiDriver.findElement(By.cssSelector(css)).click();
    
    /*UIControl controlType = new ControlProvider().getControl(new (xpath));
    controlType.setValue(xpath);*/
}

public boolean isElementVisibleWithCss(String css) {
    WebElement webElement;
    try {
        webElement = uiDriver.findElement(By.cssSelector(css));
        if (webElement.isDisplayed()) {
            return true;
        }
        return false;
    } catch (NoSuchElementException e) {
        return false;
    }
}

public boolean isCheckBoxSelectedWithXpath(String xPath) {
    try {
        
        boolean webElement = uiDriver.findElement(By.xpath(xPath)).isSelected();
        if (webElement==true) {
            return true;
        }

    } catch (NoSuchElementException ex) {
        return false;
    }
    
    return false;
}
public void clickLinkWithXpath(String xpath) {
	WebElement webElement;
	try{
	webElement = uiDriver.findElement(By.xpath(xpath));
	if(webElement.isDisplayed()){
		webElement.click();
	}
	}
	catch(NoSuchElementException ex){
		
	}
}
public void clickGAQviamousemove() {
	
	try{
         browser.wait(1000);
		WebElement menu=uiDriver.findElement(By.xpath(".//*[@id='mega-menu']/ul/div/li[1]/a"));
		WebElement menu1=uiDriver.findElement(By.xpath(".//*[@id='mega-menu']/ul/div/li[1]/ul/li/div/div/div[1]/div[4]/div[2]/div[2]/div/div/div/div/div/p[1]/span/a"));
		Actions action =new Actions(uiDriver);
		action.moveToElement(menu).build().perform();
	}
	catch(NoSuchElementException ex){
		
	}
}

public void performMouseHover() {
	uiDriver.mouseOver();
	
}


public String selectdropdownoptionbyindex(String xpath,int value) {
	Select select;
	String usertypevalue=null;
	try{
		select = new Select(uiDriver.findElement(By.id(xpath)));
		System.out.println("assigned");
		select.selectByIndex(value);
		System.out.println("selected");		
	}
	catch(NoSuchElementException ex){
		
	}
	return usertypevalue;
}
public WebElement getElementByXpath(String locator){
    WebElement element = uiDriver.findElement(By.xpath(locator));
    return element;
  }
public void handleMultipleWindows(String windowTitle) {
    Set<String> windows = uiDriver.getWindowHandles();

    for (String window : windows) {
    	uiDriver.switchTo().window(window);
        if (uiDriver.getTitle().contains(windowTitle)) {
            return;
        }
    }
}
}