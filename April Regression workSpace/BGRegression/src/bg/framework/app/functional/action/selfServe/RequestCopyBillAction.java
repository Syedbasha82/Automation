package bg.framework.app.functional.action.selfServe;
import bg.framework.app.functional.page.selfServe.RequestCopyBillPage;

public class RequestCopyBillAction {
	RequestCopyBillPage requestCopyBillPage = new RequestCopyBillPage();
	
	public RequestCopyBillAction navigatetoBillingHistory(){
		requestCopyBillPage.navigatetoBillingHistory();
		return this;
	}
	
	public RequestCopyBillAction verifyViewBills(){
		requestCopyBillPage.verifyViewBills();
		return this;
	}
	
	public RequestCopyBillAction requestBillCopy(){
		requestCopyBillPage.requestBillCopy();
		return this;
	}
	
	public RequestCopyBillAction logout(){
		requestCopyBillPage.logout();
		return this;
	}
}
