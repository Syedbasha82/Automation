/**
 * @author 208070
 *
 */
package bg.framework.app.functional.test.Slingshot;

import static bg.framework.app.functional.entities.FunctionalCategory.BGBRegistration;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import static bg.framework.app.functional.entities.FunctionalCategory.Slingshot;
import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.Slingshot.AccountSummaryAction;
import bg.framework.app.functional.action.Slingshot.ContactUsBusinessAction;
import bg.framework.app.functional.action.Slingshot.PaymentsAction;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class PaymentsTest extends TestBase{
	
	@SuppressWarnings("unchecked")
	@Test(groups ={Slingshot,Smoke,BGBRegistration})	
	public void verifyPaymentsLink(){
	 	Report.createTestLogHeader("Payments", "Payments Functionality");
	    UserProfile userProfile = new TestDataHelper().getUserProfile("Payments");
	    new LoginAction()
		.BgbloginDetails(userProfile)
		.BgbverifyLogin(userProfile)
		//.verifyCustomerAccountDetails(userProfile)
		//.verifyDataVerification(userProfile)
		.clickManageAccountLink(userProfile)
		//.auditVerificationOfEmail(userProfile)
		//.verifyLoginTimeStamp(userProfile)
		.navigatetoPayments()
		//.verifyLinks()
		.navigatetoMakeAPayment()
		.paymentDetails(userProfile)
		.logOut();
	    
	    
	}
	
	@SuppressWarnings("unchecked")
	@Test(groups ={Slingshot,Smoke,BGBRegistration})	
	public void ErrorValidation(){
	 	Report.createTestLogHeader("Payments", "Payments Functionality - Error Validation");
	    UserProfile userProfile = new TestDataHelper().getUserProfile("Payments");
	    new LoginAction()
		.BgbloginDetails(userProfile)
		.BgbverifyLogin(userProfile)
//		.verifyCustomerAccountDetails(userProfile)
//		.verifyDataVerification(userProfile)
		.clickManageAccountLink(userProfile)
		.auditVerificationOfEmail(userProfile)
		.verifyLoginTimeStamp(userProfile)
		.navigatetoPayments()
		.navigatetoMakeAPayment()
		.errorValidation(userProfile)
		.logOut();
	    
	    
	}
	
	@SuppressWarnings("unchecked")
	@Test(groups ={Slingshot,Smoke,BGBRegistration})	
	public void  TwoCardperAccount(){
	 	Report.createTestLogHeader("Payments", "Payments Functionality - Two Card per Account");
	    UserProfile userProfile = new TestDataHelper().getUserProfile("Payments");
	    int increment=1;
	    new LoginAction()
		.BgbloginDetails(userProfile)
		.BgbverifyLogin(userProfile);
//		.verifyCustomerAccountDetails(userProfile)
//		.verifyDataVerification(userProfile)
		do{
			new AccountSummaryAction()
		.clickManageAccountLink(userProfile)
		.auditVerificationOfEmail(userProfile)
		.verifyLoginTimeStamp(userProfile)
		.navigatetoPayments();
		if(increment==3)
			new PaymentsAction().navigatetoMakeAPaymentError();
		else
		{
			new PaymentsAction().navigatetoMakeAPayment();
			new PaymentsAction().TwoCardlimit(increment, userProfile);
		}
			increment++;
		}while(increment<=3);
		new PaymentsAction()
		.logOut();
	    
	    
	}
}
