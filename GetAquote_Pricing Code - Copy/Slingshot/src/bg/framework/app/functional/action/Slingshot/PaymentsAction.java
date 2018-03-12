/**
 * 
 */
package bg.framework.app.functional.action.Slingshot;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.Slingshot.PaymentsPage;

/**
 * @author 208070
 *
 */
public class PaymentsAction {
	public PaymentsAction verifyLinks() {
		new PaymentsPage().verifyLinks();
		return new PaymentsAction();	
	}

	public PaymentsAction navigatetoMakeAPayment() {
		new PaymentsPage().navigatetoMakeAPayment();
		return new PaymentsAction();	
	}

	public PaymentsAction paymentDetails(UserProfile userProfile) {
		new PaymentsPage().paymentDetails(userProfile);
		return new PaymentsAction();	
	}

	public PaymentsAction errorValidation(UserProfile userProfile) {
		new PaymentsPage().errorValidation(userProfile);
		return new PaymentsAction();	
	}

	public PaymentsAction logOut() {
		new PaymentsPage().logOut();
		return new PaymentsAction();
		
	}
	public PaymentsAction TwoCardlimit(int increment, UserProfile userProfile) {
		new PaymentsPage().TwoCardlimit(increment, userProfile);
		return new PaymentsAction();
	}

	public PaymentsAction navigatetoMakeAPaymentError() {
		new PaymentsPage().navigatetoMakeAPaymentError();
		return new PaymentsAction();
	}
}