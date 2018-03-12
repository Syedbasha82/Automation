package bg.framework.app.functional.action.sales;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.sales.RepairQuotePage;

public class RepairQuoteAction {

	public  RepairQuoteAction navigateToRepairQuotePage(){
		new RepairQuotePage().navigateToRepairQuotePage();
		return this;
	}
	public  RepairQuoteAction getServiceQuoteDetails(String ServiceType){
		new RepairQuotePage().getServiceQuoteDetails(ServiceType);
		return this;
	}
	public  RepairQuoteAction getContactDetails(UserProfile userProfile,String ServiceType,String Customer){
		new RepairQuotePage().getContactDetails(userProfile,ServiceType,Customer);
		return this;
	}
	public  RepairQuoteAction OrdernowPage(){
		new RepairQuotePage().OrdernowPage();
		return this;
	}
	public  RepairQuoteAction getPaymentDetails(UserProfile userProfile){
		new RepairQuotePage().getPaymentDetails(userProfile);
		return this;
	}
	public  RepairQuoteAction getTermsAndOrderDetails(){
		new RepairQuotePage().getTermsAndOrderDetails();
		return this;
	}
	public  RepairQuoteAction verifyLeadTabledata_GetquotesAudit(UserProfile userProfile){
		new RepairQuotePage().verifyLeadTabledata_GetquotesAudit(userProfile);
		return this;
	}
}