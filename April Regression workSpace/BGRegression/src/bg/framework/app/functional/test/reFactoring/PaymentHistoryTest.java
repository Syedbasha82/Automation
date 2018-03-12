package bg.framework.app.functional.test.reFactoring;

import java.text.ParseException;

import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.reFactoring.PaymentHistoryAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;

import static bg.framework.app.functional.entities.FunctionalCategory.PaymentHistory;
import static bg.framework.app.functional.entities.FunctionalCategory.Refactoring;

public class PaymentHistoryTest extends TestBase  {
	
	 @SuppressWarnings("unchecked")
	 @Test(groups ={PaymentHistory})
	    //Mandatory Fields in Userprofile.xml : UCRN
	 public void verifyPaymentMeterReadHistoryGasCustomer() throws ParseException {
	     Report.createTestLogHeader("Payment Meter Read History Journey", "To Verify Payment and Meter Read History For Gas Customer");
	     UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	     ////getCustomerDetailsToUserProfileOAM(userProfile);
	     new HomePageAction()
	     .navigateToLoginPage()
		 .loginUserDetails(userProfile)
			     	//.verifyAccountOverviewAction()
			       //.verifyAddress(userProfile.getElecAccount())
		 			.navigateToAccountSummaryPage01()
			        .verifyPaymentHistory(userProfile)
			        //.verifyMakeAPayment(userProfile.getElecAccount())
			        .verifySearchField(userProfile.getSecurityQuestion())
			        .verifyTransactionHistoryItems()
			        .verifyDateField()
			        .verifyBillHistory();
			        //.verifyMeterReadHistory(userProfile.getElecAccount());
	    }
	       
	 @SuppressWarnings("unchecked")
	 @Test(groups ={PaymentHistory})
	    //Mandatory Fields in Userprofile.xml : UCRN
	 public void verifyPaymentMeterReadHistoryElecCustomer() throws ParseException {
	     Report.createTestLogHeader("Payment Meter Read History Journey", "To Verify Payment and Meter Read History For Elec Customer");
	     UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	     new HomePageAction()
	     .navigateToLoginPage()
		 .loginUserDetails(userProfile)
			     	//.verifyAccountOverviewAction()
			       //.verifyAddress(userProfile.getElecAccount())
		 			.navigateToAccountSummaryPage01()
			        .verifyPaymentHistory(userProfile)
			        //.verifyMakeAPayment(userProfile.getElecAccount())
			        .verifySearchField(userProfile.getSecurityQuestion())
			        .verifyTransactionHistoryItems()
			        .verifyDateField()
			        .verifyBillHistory();
			        //.verifyMeterReadHistory(userProfile.getElecAccount());
	    }
	 
	 @SuppressWarnings("unchecked")
	 @Test(groups ={PaymentHistory})
	    //Mandatory Fields in Userprofile.xml : UCRN
	 public void verifyPaymentMeterReadHistoryDualCustomer() throws ParseException {
	     Report.createTestLogHeader("Payment Meter Read History Journey", "To Verify Payment and Meter Read History For Dual Customer");
	     UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
	     new HomePageAction()
	     			.navigateToLoginPage()
			     	.loginUserDetails(userProfile)
			     	.verifyAccountOverviewAction()
			        //.verifyAddress(userProfile.getAccNumber())
			        .navigateToAccountSummaryPage()
			        .verifyPaymentHistory(userProfile)
			        .verifyMakeAPayment(userProfile.getAccNumber())
			        .verifySearchField(userProfile.getSecurityQuestion())
			        .verifyTransactionHistoryItems()
			        .verifyDateField()
			        .verifyBillHistory();
			        //.verifyMeterReadHistory(userProfile.getAccNumber());
			}
	 
	 @SuppressWarnings("unchecked")
	 @Test(groups ={PaymentHistory})
	    //Mandatory Fields in Userprofile.xml : UCRN
	 public void verifyPaymentMeterReadHistoryJICustomer() throws ParseException {
	     Report.createTestLogHeader("Payment Meter Read History Journey", "To Verify Payment and Meter Read History For JI Customer");
	     UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
	     //getCustomerDetailsToUserProfileOAM(userProfile);
	     new HomePageAction()
			.navigateToLoginPage()
	     	.loginUserDetails(userProfile)
	     	.verifyAccountOverviewAction()
	        //.verifyAddress(userProfile.getAccNumber())
	        .navigateToAccountSummaryPage()
	        .verifyPaymentHistory(userProfile)
	        .verifyMakeAPayment(userProfile.getAccNumber())
	        .verifySearchField(userProfile.getSecurityQuestion())
	        .verifyTransactionHistoryItems()
	        .verifyDateField()
	        .verifyBillHistory();
	        //.verifyMeterReadHistory(userProfile.getAccNumber());
	}

	 @SuppressWarnings("unchecked")
	 @Test(groups ={PaymentHistory})
	    //Mandatory Fields in Userprofile.xml : UCRN
	 public void verifyPaymentMeterReadHistoryJICustomer_Old() throws ParseException {
	     Report.createTestLogHeader("Payment Meter Read History Journey", "To Verify Payment and Meter Read History For JI Customer");
	     UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
	     //getCustomerDetailsToUserProfileOAM(userProfile);
	     new HomePageAction()
	     			.navigateToLoginPage()
			     	.loginUserDetails(userProfile)
			     	.verifyAccountOverviewAction()
			        //.verifyAddress(userProfile.getAccNumber())
			        .navigateToAccountSummaryPage()
			        .verifyPaymentHistory(userProfile)
			        .verifyMakeAPayment(userProfile.getAccNumber())
			        .verifySearchField(userProfile.getSecurityQuestion())
			        .verifyTransactionHistoryItems()
			        .verifyDateField()
			        .verifyBillHistory()
			        .verifyMeterReadHistory(userProfile.getAccNumber());
			}
	 
	 @SuppressWarnings("unchecked")
	 @Test(groups ={PaymentHistory})
	    //Mandatory Fields in Userprofile.xml : UCRN
	 public void verifyPaymentMeterReadHistoryHomeServCustomer() throws ParseException {
	     Report.createTestLogHeader("Payment Meter Read History Journey", "To Verify Payment and Meter Read History For Home Services Customer");
	     UserProfile userProfile = new TestDataHelper().getUserProfile("HomeSerivcesAccount");
	     new HomePageAction()   
	     			.navigateToLoginPage()
			     	.loginUserDetails(userProfile)
			     	.verifyAccountOverviewAction()
			        //.verifyAddress(userProfile.getAccNumber())
			        .navigateToAccountSummaryPage()
			        .verifyPaymentHistory(userProfile)
			        .verifyMakeAPayment(userProfile.getAccNumber())
			        .verifySearchField(userProfile.getSecurityQuestion())
			        .verifyTransactionHistoryItems()
			        .verifyDateField()
			        .verifyBillHistory();
			        //.verifyMeterReadHistory(userProfile.getAccNumber());
			}
	 
	
}
