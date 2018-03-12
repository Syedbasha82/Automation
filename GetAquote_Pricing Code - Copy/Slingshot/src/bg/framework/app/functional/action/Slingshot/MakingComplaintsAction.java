/**
 * 
 */
package bg.framework.app.functional.action.Slingshot;

import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.Slingshot.ContactUsBusinessPage;
import bg.framework.app.functional.page.Slingshot.MakingComplaintsPage;
import bg.framework.app.functional.page.common.LegacyHomePage;
import bg.framework.app.functional.page.common.LegacyLoginPage;

/**
 * @author 292238
 *
 */
public class MakingComplaintsAction {
	String accountNum, address;
	 public MakingComplaintsAction bgbLoginUser() {
			LegacyHomePage legacyHomePage = new LegacyHomePage();
			legacyHomePage.BgbnavigateToLoginPage(); 
			return new MakingComplaintsAction();
		}
	 public MakingComplaintsAction bgbloginDetails(UserProfile userProfile) {
	        LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
	        legacyLoginPage.BgbloginUser(userProfile); 
	       String address = new MakingComplaintsPage().getAddress();
	        return new MakingComplaintsAction();
	    }
	public MakingComplaintsAction openMakingComplaintPage(String journey){
		MakingComplaintsPage makingComplaintsPage = new MakingComplaintsPage();
		makingComplaintsPage.openMakingComplaintPage(journey);
		return this;
	}
	public MakingComplaintsAction enterComplaintsFields(UserProfile userProfile){
		MakingComplaintsPage makingComplaintsPage = new MakingComplaintsPage();
		 makingComplaintsPage.verifyContactUsInComplaints(userProfile);
		// makingComplaintsPage.verifyAddress(address);
		return this;
	}
	public MakingComplaintsAction verifyConfirmationinPage(UserProfile userProfile){
		MakingComplaintsPage makingComplaintsPage = new MakingComplaintsPage();
		makingComplaintsPage.verifyConfirmationinPage(userProfile);
		return this;
	}
	public MakingComplaintsAction verifyLinks(){
		MakingComplaintsPage makingComplaintsPage = new MakingComplaintsPage();
		makingComplaintsPage.verifyLinks();
		makingComplaintsPage.verifyContactUsPageLinks();
		return this;
	}
	public MakingComplaintsAction verifyWhereCanIFindThisLink() {
		new MakingComplaintsPage().verifyWhereCanIFindThisLink();
		return new MakingComplaintsAction();
	}
	public MakingComplaintsAction validateAccountNumberField(UserProfile userProfile){
		new MakingComplaintsPage().validateAccountNumberField(userProfile);
		return new MakingComplaintsAction();
	}
	public MakingComplaintsAction verifyAndValidateQueryComplaintField(UserProfile userProfile){
		new MakingComplaintsPage().verifyAndValidateQueryComplaintField(userProfile);
		return new MakingComplaintsAction();
	}
	public MakingComplaintsAction verifyAndValidatePreferContactField(UserProfile userProfile){
		new MakingComplaintsPage().verifyAndValidatePreferContactField(userProfile);
		return new MakingComplaintsAction();
	}
	public MakingComplaintsAction verifyConfirmation(){
		new MakingComplaintsPage().verifyConfirmation();
		return new MakingComplaintsAction();
	}
	public MakingComplaintsAction verifyAllContactUsOptions(){
		MakingComplaintsPage makingComplaintsPage =new MakingComplaintsPage();
		makingComplaintsPage.verifyCallUs();
		makingComplaintsPage.verifyEmailUs();
		makingComplaintsPage.verifyEmailUs2();
		//makingComplaintsPage.verifyCallUs2();
		makingComplaintsPage.verifyWriteUsStep2();
		makingComplaintsPage.verifyEmailUs3();
		makingComplaintsPage.verifyWriteUsStep3();
		return new MakingComplaintsAction();
	}

public MakingComplaintsAction openMakingComplaint(String journey){
	MakingComplaintsPage makingComplaintsPage = new MakingComplaintsPage();
	makingComplaintsPage.openMakingComplaint(journey);
	return this;
}
public MakingComplaintsAction validateEnterAddressManually(UserProfile userProfile, String Cust, String Wordings,String addr) {
	new MakingComplaintsPage().validateEnterAddressManually(userProfile, Cust, Wordings, addr);
	return new MakingComplaintsAction();
	
} public MakingComplaintsAction bgcloginDetails(UserProfile userProfile) {
    LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
    legacyLoginPage.bgcloginUser(userProfile); 
  
    return new MakingComplaintsAction();
}
public MakingComplaintsAction verifyYourComplaintField(UserProfile userProfile, String Cust, String Wordings,String addr) {
	new MakingComplaintsPage().verifyYourComplaintField(userProfile, Cust, Wordings, addr);   
    return new MakingComplaintsAction();
}
public MakingComplaintsAction logoutSession(){
	MakingComplaintsPage makingComplaintsPage = new MakingComplaintsPage();
	makingComplaintsPage.logoutSession();
	return this;
}

}