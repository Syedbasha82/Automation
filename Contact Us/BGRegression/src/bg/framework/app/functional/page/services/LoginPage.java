package bg.framework.app.functional.page.services;

import java.util.Properties;

import bg.framework.app.functional.entities.LandLord;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;

public class LoginPage extends BasePage{
	private final static String FILE_NAME="resources/services/LoginPage.properties";
	private static Properties pageProperties=new PropertyLoader(FILE_NAME).load();
	
	public void login(LandLord landLord){
		verifyAndInputById(pageProperties.getProperty("LoginPage.userNameText"), "Email ", landLord.getEmail());
		verifyAndInputById(pageProperties.getProperty("LoginPage.passwordText"), "Password", landLord.getPassword());
		verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.submitButton"), "Login button");
	}
	public void verifyLoginSuccessPage(){
//		if(browser.isTextPresent("Continue to my account")){
//			browser.clickWithLinkText("Continue to my account");
//		}
		verifyIsTextPresent("Your accounts");
		
	}
	
	public void clickForgotPasswordLink(){
		verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.forgotPasswordLink"), "Forfot password link");
	}
	
}
