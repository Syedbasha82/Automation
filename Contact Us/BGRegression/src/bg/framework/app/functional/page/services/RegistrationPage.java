package bg.framework.app.functional.page.services;

import java.util.Properties;

import bg.framework.app.functional.entities.LandLord;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;

public class RegistrationPage extends BasePage {
	private final static String FILE_NAME="resources/services/Registration.properties";
	private static Properties pageProperties=new PropertyLoader(FILE_NAME).load();
	private LandLord landLord;
	public RegistrationPage(LandLord landLord) {
		this.landLord=landLord;
	}

	public void enterPersonalDetails(){
		verifyAndInputById(pageProperties.getProperty("Registration.referenceNumberText"), "Customer reference number", landLord.getAccountNumber());
		verifyAndSelectDropDownBox(pageProperties.getProperty("Registration.titleSelect"), "Title", landLord.getTitle());
		verifyAndInputById(pageProperties.getProperty("Registration.firstNameText"), "First name", landLord.getfName());
		verifyAndInputById(pageProperties.getProperty("Registration.lastNameText"), "Last name", landLord.getSurName());
	}
	
	public void clickRegisterButton(){
		verifyAndClick(pageProperties.getProperty("Registration.registerButton"), "Register button");
	}
	
	public void registrationFirstPageSuccess(){
		verifyIsTextPresent("Register Personal Details");
	}
	
	public void registrationSecondPageSuccess(){
		verifyIsTextPresent("Register Accounts verification");
	}
	
	public void enterLoginDetails(){
		verifyAndInputById(pageProperties.getProperty("Registration.emailText"), "Email", landLord.getEmail());
		verifyAndInputById(pageProperties.getProperty("Registration.confirmEmailText"), "Confirm Email", landLord.getEmail());
		verifyAndInputById(pageProperties.getProperty("Registration.passwordText"), "Password", landLord.getPassword());
		verifyAndInputById(pageProperties.getProperty("Registration.confirmPasswordText"), "Confirm Password", landLord.getPassword());
		verifyAndInputById(pageProperties.getProperty("Registration.telePhoneText"), "Telephone Number", landLord.getTelephone());
		verifyAndSelectDropDownBox(pageProperties.getProperty("Registration.telePhoneTypeSelect"), "Telephone type", "Home");		
	}
	
	public void clickTermsCheckBox(){
		verifyAndClick(pageProperties.getProperty("Registration.termsCheck"), "Terms and condition Check box");
	}
	
	public void clickContinueButton(){
		verifyAndClick(pageProperties.getProperty("Registration.continueButton"), "Continue button");
	}
	
	public void registrationSuccess(){
		verifyIsTextPresent("Successfull");
	}
}
