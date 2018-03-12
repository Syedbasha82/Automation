package bg.framework.common.control;

import org.openqa.selenium.By;

public class FindByXpath implements Finder {
    private String xpath;
  

    public FindByXpath(String xpath) {
        this.xpath = xpath;
    }

    public By by() {
        return By.xpath(xpath);
    }
    
   

}
