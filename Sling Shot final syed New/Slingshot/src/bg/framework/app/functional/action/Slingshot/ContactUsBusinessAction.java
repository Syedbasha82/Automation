/**
 * 
 */
package bg.framework.app.functional.action.Slingshot;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.Slingshot.ContactUsBusinessPage;
import bg.framework.app.functional.page.Slingshot.ContactUsCorporatePage;

/**
 * @author 208070
 *
 */
public class ContactUsBusinessAction {

	public ContactUsBusinessAction verifyMyAccountandBilling() {
			new ContactUsBusinessPage().verifyMyAccountandBilling();
			return new ContactUsBusinessAction();
	}

	
	public ContactUsBusinessAction verifySwitchingtoBritishGas() {
		new ContactUsBusinessPage().verifySwitchingtoBritishGas();
		return new ContactUsBusinessAction();
	}

	public ContactUsBusinessAction verifyMyMeterReadingsandMeter() {
		new ContactUsBusinessPage().verifyMyMeterReadingsandMeter();
		return new ContactUsBusinessAction();
	}
	

	public ContactUsBusinessAction verifyMovingPremises() {
		new ContactUsBusinessPage().verifyMovingPremises();
		return new ContactUsBusinessAction();
	}

	public ContactUsBusinessAction verifyBreakdownandServices() {
		new ContactUsBusinessPage().verifyBreakdownandServices();
		return new ContactUsBusinessAction();
	}
	
	public ContactUsBusinessAction navigatetoContactUslink(){
		new ContactUsBusinessPage().navigatetoContactUslink();
		return new ContactUsBusinessAction();	
	}

	public ContactUsBusinessAction navigatetoEmailContactUslink(String Tab) {
		new ContactUsBusinessPage().navigatetoEmailContactUslink(Tab);
		return new ContactUsBusinessAction();
	}
	public ContactUsBusinessAction navigatetoEmailContactUsCorporatelink(String Tab) {
		new ContactUsCorporatePage().navigatetoEmailContactUsCorporatelink(Tab);
		return new ContactUsBusinessAction();
	}

	public ContactUsBusinessAction verifyEmailUs(String Tab) {
		new ContactUsBusinessPage().verifyEmailUs(Tab);
		return new ContactUsBusinessAction();
	}

	public ContactUsBusinessAction selectMyAccountandBillingtab() {
		new ContactUsBusinessPage().selectMyAccountandBillingtab();
		return new ContactUsBusinessAction();
	}

	public ContactUsBusinessAction selectSwitchingtoBGtab() {
		new ContactUsBusinessPage().selectSwitchingtoBGtab();
		return new ContactUsBusinessAction();
	}
	
	public ContactUsBusinessAction selectMyMeterReadingsandMetertab() {
		new ContactUsBusinessPage().selectMyMeterReadingsandMetertab();
		return new ContactUsBusinessAction();
	}
	
	public ContactUsBusinessAction selectMovingPremisestab() {
		new ContactUsBusinessPage().selectMovingPremisestab();
		return new ContactUsBusinessAction();
	}
	
	public ContactUsBusinessAction selectBreakdownandServicestab() {
		new ContactUsBusinessPage().selectBreakdownandServicestab();
		return new ContactUsBusinessAction();
	}

	public ContactUsBusinessAction logout() {
		new ContactUsBusinessPage().logout();
		return new ContactUsBusinessAction();
	}

	public ContactUsBusinessAction SearchFuctionality(String search, String content, String tab) {
			new ContactUsBusinessPage().SearchFuctionality(search, content, tab);
			return new ContactUsBusinessAction();
	}

	public ContactUsBusinessAction verifyLHN() {
		new ContactUsBusinessPage().verifyLHN();
		return new ContactUsBusinessAction();
	}

	public ContactUsBusinessAction verifyWhereCanIFindThisLink() {
		new ContactUsBusinessPage().verifyWhereCanIFindThisLink();
		return new ContactUsBusinessAction();
	}

	public ContactUsBusinessAction verifyAddressinEmailUs(UserProfile userProfile) {
		new ContactUsBusinessPage().verifyAddressinEmailUs(userProfile);
		return new ContactUsBusinessAction();
	}

	public ContactUsBusinessAction verifyConfirmationinEmailUsLoggedInCust(UserProfile userProfile) {
		new ContactUsBusinessPage().verifyConfirmationinEmailUsLoggedInCust(userProfile);
		return new ContactUsBusinessAction();
		
	}

	public ContactUsBusinessAction validateFirstName(UserProfile userProfile, String Cust, String Wordings) {
		new ContactUsBusinessPage().validateFirstName(userProfile, Cust, Wordings);
		return new ContactUsBusinessAction();
	}

	public ContactUsBusinessAction validateEnterAddressManually(UserProfile userProfile, String Cust, String Wordings) {
		new ContactUsBusinessPage().validateEnterAddressManually(userProfile, Cust, Wordings);
		return new ContactUsBusinessAction();
		
	}

	public ContactUsCorporateAction navigatetoContactUsCorporatelink() {
		new ContactUsCorporatePage().navigatetoContactUsCorporatelink();
		return new ContactUsCorporateAction();	
	}

	public ContactUsBusinessAction selectTab(String tab) {
		new ContactUsBusinessPage().selectTab(tab);
		return new ContactUsBusinessAction();	
	}

	

	

	

}
