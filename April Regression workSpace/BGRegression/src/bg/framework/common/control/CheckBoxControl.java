package bg.framework.common.control;

import org.openqa.selenium.WebElement;

public class CheckBoxControl extends UIControl {
    public CheckBoxControl(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void setValue(String value) {
        /**
         * this used to be setSelected(); in the new version of selenium (2.0.9) that method has been removed;
         * details here > <a href="http://code.google.com/p/selenium/issues/attachmentText?id=2391&aid=23910003000&name=setSelectedRemoval.patch&token=eac56b15d0f25bea977a59776aaf0d0f"> setSelected Removal</a>
         * */
        webElement.click();
    }

    public boolean isSelected(String value) {
        return webElement.isSelected();
    }
}

