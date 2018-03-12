package bg.framework.common.control;

import org.openqa.selenium.By;

public class FindByCss implements Finder {
private String css;
	      

	        public FindByCss(String css) {
	            this.css = css;
	        }

	        public By by() {
	            return By.cssSelector(css);
	        }
	    
	    }



