package bg.framework.common.control;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownControl extends UIControl {

    public DropDownControl(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void setValue(String value) {
    	
        Select listBox = new Select(webElement);
        if(value.startsWith("index="))
        {
        	int selectIndex=Integer.parseInt(value.replace("index=", "").trim());
        	listBox.selectByIndex(selectIndex);
        	return;
        }
        listBox.selectByVisibleText(value);
     
        
    }
    
    @Override
    public String getValue(){
    	Select listBox = new Select(webElement);    	
    	webElement =listBox.getFirstSelectedOption();
    	return webElement.getText();
    }
    
    
}
