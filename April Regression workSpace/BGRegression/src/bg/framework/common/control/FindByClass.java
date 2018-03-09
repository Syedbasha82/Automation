package bg.framework.common.control;

import org.openqa.selenium.By;

public class FindByClass implements Finder {
    private String className;

    public FindByClass(String className) {
        this.className = className;
    }


    public By by() {
        return By.className(className);
    }

}
