package bg.framework.app.functional.page.services;

import java.util.Properties;

import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;

public class AccountOverViewPage extends BasePage{
	private final static String FILE_NAME="resources/services/AccountOverView.properties";
	private static Properties pageProperties=new PropertyLoader(FILE_NAME).load();
	
	
	public void verifyAccountOverViewPage(){
		verifyIsTextPresent("Your accounts");
	}
	
	public void clickManageAccount(String accountNumber){
		 browser.wait(4000);
	        verifyAndClickWithXpath((pageProperties.getProperty(
	                "AccountOverView.manageAccountLink").replace("USERACCOUNTNUMBER",
	                		accountNumber)), "Manage Account Link for "+accountNumber);
	}
	
	 
}
