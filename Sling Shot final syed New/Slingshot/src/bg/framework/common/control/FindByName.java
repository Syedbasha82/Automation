package bg.framework.common.control;

import org.openqa.selenium.By;


public class FindByName implements Finder {
    private String name;

    public FindByName(String name) {
        this.name = name;
    }

    public By by() {
        return By.name(name);
     
    }


}
