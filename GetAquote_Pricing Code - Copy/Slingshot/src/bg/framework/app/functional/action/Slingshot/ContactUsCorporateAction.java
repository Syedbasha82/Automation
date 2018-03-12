/**
 * 
 */
package bg.framework.app.functional.action.Slingshot;

import bg.framework.app.functional.page.Slingshot.ContactUsBusinessPage;
import bg.framework.app.functional.page.Slingshot.ContactUsCorporatePage;

/**
 * @author 208070
 *
 */
public class ContactUsCorporateAction {

	
	public ContactUsCorporateAction verifyMyAccountandBilling() {
		new ContactUsCorporatePage().verifyMyAccountandBilling();
		return new ContactUsCorporateAction();	
	}
	
	public ContactUsCorporateAction verifyMovingPremises() {
		new ContactUsCorporatePage().verifyMovingPremises();
		return new ContactUsCorporateAction();
	}
	
	public ContactUsCorporateAction verifyBreakdownandServices() {
		new ContactUsCorporatePage().verifyBreakdownandServices();
		return new ContactUsCorporateAction();
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

	public ContactUsBusinessAction navigatetoEmailContactUslink(String Tab) {
		new ContactUsBusinessPage().navigatetoEmailContactUslink(Tab);
		return new ContactUsBusinessAction();
	}
	
	public ContactUsCorporateAction logout() {
		new ContactUsCorporatePage().logout();
		return new ContactUsCorporateAction();	
	}

}
