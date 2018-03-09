package bg.framework.common.functional;

import bg.framework.common.control.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.Robot;
import bg.framework.app.functional.util.Report;
import java.awt.event.KeyEvent;
import java.rmi.server.UID;

import org.openqa.selenium.JavascriptExecutor;

import java.util.Set;
import java.lang.Object;import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UIOperation {

    protected UIDriver uiDriver;
    protected Verify verify = new Verify();

    public UIOperation(UIDriver uiDriver) {
        this.uiDriver = uiDriver;
        //this.uiDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      
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

    public WebDriver selectWindow(String windowTitle) {
        return uiDriver.switchTo().window(windowTitle);
    }
  
    public WebDriver getDriver(){
    	return uiDriver.getDriver();
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

    public void swtichToDefaultContent() {
        uiDriver.switchTo().defaultContent();
    }

    public void selectWindowById(int windowId) {
        uiDriver.switchTo().frame(windowId);
    }

   public void selectWindowByName(String windowName) {
        uiDriver.switchTo().frame(windowName);
    }
    public void execJS(String jCommand) {
        uiDriver.ExecuteJavascript(jCommand);
    }
    
    public void WaitForElementWithXpath(String xpath){
        WebDriver webDriver = WebDriverProvider.getCurrentDriver();
        WebDriverWait wait = new WebDriverWait(webDriver,200);        
        
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        
     }

    public void closeAlert() {
        /*Alert alert = uiDriver.switchTo().alert();
        // wait(1000);
        if (alert.getText() != null) {
            alert.accept();
        }*/
    	
           int i=0;
           while(i++<10)
           {
                try
                {
                    Alert alert = uiDriver.switchTo().alert();
                    if (alert.getText() != null) {
                        alert.accept();
                    }
                    break;
                }
                catch(NoAlertPresentException e)
                {
                  wait(3000);
                  continue;
                }
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
        uiDriver.close();
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
            new ControlProvider().getSelectControl(new FindByName(locator)).setValue(
                    value);
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
public void trigger(String script, WebElement element) {
	    ((JavascriptExecutor)uiDriver.getWebDriver()).executeScript(script, element);
	}public Object trigger(String script) {
	    return ((JavascriptExecutor)uiDriver.getWebDriver()).executeScript(script);
	}
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
	
	public String getWindowTitle()
	{
	 
		return uiDriver.getTitle();
	}

	public String getWindowHandle()
	    {
    		return uiDriver.getWindowHandle();
	    }
    
    public Set<String> getWindowHandles(){
    	return uiDriver.getWindowHandles();
    }
    public void selectAppointmentSlot(String time, String date){
    	//List<WebElement> slots=uiDriver.findElements(By.xpath(".//*[@class='ui-helper-hidden-accessible']"));
    	int col=0,row=0;
    	for( int i=2;i<=4;i++){
    		if(uiDriver.findElement(By.xpath(".//*[@id='tab1']/tbody/tr[1]/th["+i+"]")).getText().contains(time)){
    			col=i-1;break;
    		}
    	}
    	for( int i=2;i<=6;i++){
    		if(uiDriver.findElement(By.xpath(".//*[@id='tab1']/tbody/tr["+i+"]/th[1]")).getText().contains(date)){
    			row=i;break;
    		}
    	}
    	uiDriver.findElement(By.xpath(".//*[@id='tab1']/tbody/tr["+row+"]/td["+col+"]/div/span")).click();
    	
    }
    public void selectAppointmentSlot1(String time, String date,String laterDates){
    	//List<WebElement> slots=uiDriver.findElements(By.xpath(".//*[@class='ui-helper-hidden-accessible']"));
    	int col=0,row=0;
    	for( int i=2;i<=4;i++){
    		if(uiDriver.findElement(By.xpath(".//*[@id='tab1']/tbody/tr[1]/th["+i+"]")).getText().contains(time)){
    			col=i-1;break;
    		}
    	}
    	
    	int i=2 , flag1=0,flag2=0;
    	
    	do {
    		 
    		 
    	for(i=2;i<=6;i++){
    		try{
    		if(uiDriver.findElement(By.xpath(".//*[@id='tab1']/tbody/tr["+i+"]/th[1]")).getText().contains(date)){
    			row=i;flag1=1;break;
    		}
    		
    		}catch(Exception e){
    			flag2=1;break;
    		}
    		
    	}
    	if (flag1==1||flag2==1){
    		break;
    	}else{
    		uiDriver.findElement(By.xpath(laterDates)).click();
    	}
    	
    	
    	}while(uiDriver.findElement(By.xpath(laterDates)).isEnabled());
    	
    	if(flag1==1){
    	uiDriver.findElement(By.xpath(".//*[@id='tab1']/tbody/tr["+row+"]/td["+col+"]/div/span")).click();
    	}else{
    		uiDriver.findElement(By.linkText("Book first available appointment")).click();
    	}
    	
    }
    

    public boolean isElementClickable(String locator) {
        WebElement webElement;
        try {
            webElement = uiDriver.findElement(By.id(locator));
            if (webElement.isEnabled()) {
                return true;
            }
            return false;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    public boolean isElementVisibleWithLinkText(String linkText) {
        try {
            WebElement webElement;
            webElement = uiDriver.findElement(By.linkText(linkText));
            if (webElement.isDisplayed()) {
                return true;
            }

        } catch (NoSuchElementException ex) {
            return false;
        }
        return false;
    }
    public String getTextByCSS(String css) {
        return uiDriver.findElement(By.cssSelector(css)).getText();
    }
    
    public String getAttributeByCSS(String css) {
        return uiDriver.findElement(By.cssSelector(css)).getAttribute("onclick");
    }
    
    public WebElement getElementByXpath(String locator){
    	WebElement element = uiDriver.findElement(By.xpath(locator));
    	return element;
    }
    
    public WebElement getElementByID(String locator){
    	WebElement element = uiDriver.findElement(By.id(locator));
    	return element;
    }
    
    public void dynamicWaituntilClickablebyXpath(String locator){
    	WebDriverWait driverWait = new WebDriverWait(uiDriver,15);
    	WebElement element = driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }
    
    public void dynamicWaituntilClickablebyID(String locator){
    	WebDriverWait driverWait = new WebDriverWait(uiDriver,15);
    	WebElement element = driverWait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
    }
    
    public void dynamicWaituntilVisiblebyXpath(String locator){
    	WebDriverWait driverWait = new WebDriverWait(uiDriver,15);
    	WebElement element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }
    public void Enteremailaddress(String name)
    {
    	uiDriver.findElement(By.xpath("//*[@class='form-control text-center email ember-view ember-text-field']")).sendKeys(name);
    }
    
    public void EnterConfirmemailaddress(String name)
    {
    	uiDriver.findElement(By.xpath("//*[@class='form-control text-center email-confirmation ember-view ember-text-field']")).sendKeys(name);
    }
    
    public void clickWithCss(String css) {
    	   /* UIControl controlType = new ControlProvider().getControl(new FindByXpath(xpath));
    	    controlType.setValue(xpath);*/
    	    uiDriver.findElement(By.cssSelector(css)).click();
    	    
    	    /*UIControl controlType = new ControlProvider().getControl(new (xpath));
    	    controlType.setValue(xpath);*/
    	}
    
    public void ClickTabKey() {
    	try
    	{
    		Robot robot = new Robot();
    		robot.keyPress(KeyEvent.VK_TAB);
    		robot.keyRelease(KeyEvent.VK_TAB);
    		
    	}
    	catch (Exception exp) {
        	exp.printStackTrace();
        }
    	
    	
    }
    
    public void ClickEnterKey() {
    	/*try
    	{
    		Robot robot = new Robot();
    		robot.keyPress(KeyEvent.VK_ENTER);
    		robot.keyRelease(KeyEvent.VK_ENTER);
    		
    	}
    	catch (Exception exp) {
        	exp.printStackTrace();
        }*/
    	
    	uiDriver.findElement(By.xpath("//*[@id='loginForm-submit']")).click();
    	
    	
    }
    public void ClickSpaceKey() {
    	try
    	{
    		Robot robot = new Robot();
    		robot.keyPress(KeyEvent.VK_SPACE);
    		robot.keyRelease(KeyEvent.VK_SPACE);
    		
    	}
    	catch (Exception exp) {
        	exp.printStackTrace();
        }
    	
    	
    }
    
    public void Enterinput(String name)
    {
    	uiDriver.findElement(By.xpath("//*[@id='loginForm-email']")).sendKeys(name);
    }
    
    public void EnterPassword(String name)
    {
    	uiDriver.findElement(By.xpath("//*[@id='loginForm-password']")).sendKeys(name);
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
    
}