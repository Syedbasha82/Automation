package bg.framework.app.functional.action.Slingshot;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.Slingshot.ContactUsPage;

public class ContactUsAction {

	public ContactUsAction navigateToContactUsPage(){
		ContactUsPage contactUsNewPage= new ContactUsPage ();
		contactUsNewPage.navigateToContactUsPage();
		return this;
		
	}
	public ContactUsAction navigateToContactUsPageLogin(){
		ContactUsPage contactUsNewPage= new ContactUsPage();
		contactUsNewPage.navigateToContactUsPageLogin();
		return this;
		
	}
	public ContactUsAction submitQuerry(UserProfile userProfile, String strType){
		ContactUsPage contactUsNewPage= new ContactUsPage ();
		contactUsNewPage.submitQuerry(userProfile,strType);
		return this;
		
	}
	public ContactUsAction verifyLoginLandingPageFunctionality(UserProfile userProfile){
		ContactUsPage contactUsNewPage= new ContactUsPage ();
		contactUsNewPage.verifyLoginLandingPageFunctionality(userProfile);
		return this;
		
	}
}
