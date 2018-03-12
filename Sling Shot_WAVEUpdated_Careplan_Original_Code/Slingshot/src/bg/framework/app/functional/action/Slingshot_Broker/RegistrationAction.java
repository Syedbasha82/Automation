package bg.framework.app.functional.action.Slingshot_Broker;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.Slingshot_Broker.RegistrationPage;

public class RegistrationAction {
	public static String regURL;
	public RegistrationAction openEncryptURL(UserProfile userProfile){
		RegistrationPage regPage = new RegistrationPage();
		regURL = regPage.openURL(userProfile);
		return this;
	}
	public RegistrationAction fillRegistrationDetails(UserProfile userProfile){
		RegistrationPage regPage = new RegistrationPage();
		regPage.fillRegistrationDetails(userProfile);
		return this;
	}
	public RegistrationAction verifyThankYouPage(){
		RegistrationPage regPage = new RegistrationPage();
		regPage.verifyThankYouPage();
		return this;
	}
	public RegistrationAction clickLoginLink(){
		RegistrationPage regPage = new RegistrationPage();
		regPage.clickLoginLink();
		return this;
	}
	public RegistrationAction verifyAuditEntry(UserProfile userProfile){
		RegistrationPage regPage = new RegistrationPage();
		regPage.verifyAuditEntry(userProfile);
		return this;
	}
	public RegistrationAction verifyEmailIdInDb(UserProfile userProfile){
		RegistrationPage regPage = new RegistrationPage();
		regPage.verifyEmailIdInDb(userProfile);
		return this;
	}
	public RegistrationAction verifyRegistrationPageLinks(){
		RegistrationPage regPage = new RegistrationPage();
		regPage.verifyRegistrationPageLinks();
		return this;
	}
	public RegistrationAction verifyInvalidLink(UserProfile userProfile){
		RegistrationPage regPage = new RegistrationPage();
		regPage.verifyInvalidLink(userProfile);
		return this;
	}
	public RegistrationAction verifyRegistrationInvalidPageLinks(){
		RegistrationPage regPage = new RegistrationPage();
		regPage.verifyRegistrationInvalidPageLinks();
		return this;
	}
	public RegistrationAction verifyAlreadyRegisteredLink(){
		RegistrationPage regPage = new RegistrationPage();
		System.out.println(regURL);
		regPage.verifyAlreadyRegisteredLink(regURL);
		
		return this;
	}
	public RegistrationAction validateLastNameErrorMessage(UserProfile userProfile){
		RegistrationPage regPage = new RegistrationPage();
		regPage.validateLastNameErrorMessage(userProfile);
		return this;
	}
	
}
