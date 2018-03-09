package bg.framework.app.functional.test.selfServe;

import bg.framework.app.functional.action.common.HomePageAction;


import bg.framework.app.functional.action.selfServe.RequestPaymentCardAction;
import bg.framework.app.functional.action.selfServe.AccountSummaryAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.RunQTP;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;

import static bg.framework.app.functional.entities.FunctionalCategory.*;

public class RequestPaymentCardTest extends TestBase {
	
	//mandatory field: UserProfile.xml UCRN and Accno
	@Test(groups = {RequestPaymentCard})
	public void ElecOrderNewPaymentDiffAddress(){
		boolean PaymentType;
		Report.createTestLogHeader("Request Payment Card", "Electricity Account Order New Payment with diff delivery address");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		////getCustomerDetailsToUserProfileOAM(userProfile);
        //UserProfile userProfileReset = userProfile;
        
        new HomePageAction()
        	.navigateToLogin()
        	.login(userProfile)
        	.navigateToAccountSummaryPage(userProfile)
        	.navigateToOrderNewPaymentCard()
        	.enterDiffDeliveryAddress()
        	.submitYourDetails()
        	.verifyElecPaymentConfirmation();
        	    		
        	
	}
	
	//mandatory field: UserProfile.xml UCRN and Accno
	@Test(groups = {RequestPaymentCard})
	public void ElecOrderNewPayment(){
		boolean PaymentType;
		Report.createTestLogHeader("Request Payment Card", "Electricity Account Order New Payment");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		//getCustomerDetailsToUserProfileOAM(userProfile);
        //UserProfile userProfileReset = userProfile;
        
        new HomePageAction()
        	.navigateToLogin()
        	.login(userProfile)
        	.navigateToAccountSummaryPage(userProfile)
       		.navigateToOrderNewPaymentCard()
       		.submitYourDetails()
       		.verifyElecPaymentConfirmation();
        	
	}	
	
	//mandatory field: UserProfile.xml UCRN and Accno
	
	@Test(groups = {RequestPaymentCard,Smoke})
	public void GasOrderNewPayment(){
		boolean PaymentType;
		Report.createTestLogHeader("Request Payment Card", "Gas Account Order New Payment");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		//getCustomerDetailsToUserProfileOAM(userProfile);
        //UserProfile userProfileReset = userProfile;
        
        new HomePageAction()
        	.navigateToLogin()
        	.login(userProfile)
        	.navigateToAccountSummaryPage(userProfile)
       		.navigateToOrderNewPaymentCard()
       		.submitYourDetails()
       		.verifyGasPaymentConfirmation();
        	
	}
	
	
	//mandatory field: UserProfile.xml UCRN and Accno
	@Test(groups = {RequestPaymentCard})
	public void GasOrderNewPaymentDiffAddress(){
		boolean PaymentType;
		Report.createTestLogHeader("Request Payment Card", "Gas Account Order New Payment with diff delivery address");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	    //getCustomerDetailsToUserProfileOAM(userProfile);
        //UserProfile userProfileReset = userProfile;
        
        new HomePageAction()
        	.navigateToLogin()
        	.login(userProfile)
        	.navigateToAccountSummaryPage(userProfile)
       		.navigateToOrderNewPaymentCard()
       		.enterDiffDeliveryAddress()
       		.submitYourDetails()
       		.verifyGasPaymentConfirmation();
        	
	}
}
