package bg.framework.app.functional.page.services;

import java.util.Properties;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.page.common.BasePage;


public class HomePage extends BasePage {
	private final static String FILE_NAME="resources/services/HomePage.properties";
	private static Properties pageProperties=new PropertyLoader(FILE_NAME).load();
	
	public void navigateToLandLordPage(){
	browser.open(ApplicationConfig.LAND_LORD);
	}
	
	public void navigateToLoginPage(){
		verifyAndClickWithXpath(pageProperties.getProperty("HomePage.yourAccountLink"), "Your Account");
	}
	
	public void clickRegisterNowLink(){
		//verifyAndClickWithXpath(pageProperties.getProperty("HomePage.registerNowLink"), "Register now link");
		verifyAndClickWithXpath("//*[contains(text(),'Register now')]", "Register now link");
	}
	
	public void navigateToLandLord(){
		verifyAndClickWithLinkText(pageProperties.getProperty("HomePage.LandLordServices"), "LandLord services");
		verifyAndClickWithLinkText(pageProperties.getProperty("HomePage.LandLordGetAQuote"), "LandLord Get Quote");
	}
	
}
