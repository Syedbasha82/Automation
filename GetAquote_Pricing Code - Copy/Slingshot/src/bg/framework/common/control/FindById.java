package bg.framework.common.control;

import org.openqa.selenium.By;


public class FindById implements Finder {

    private String id;

    public FindById(String id) {
        this.id = id;
    }


    public By by() {
        return By.id(id);
    }

}
