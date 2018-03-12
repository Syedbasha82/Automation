package bg.framework.app.functional.test.selfServe;

import org.testng.annotations.Test;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import static bg.framework.app.functional.entities.FunctionalCategory.BillHistory;
import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class BillHistoryTest extends TestBase{
	
	
	@Test(groups = {Smoke,BillHistory})
	public void viewBillHistoryForGas(){
		Report.createTestLogHeader("ViewBillHistory", "GasAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("GasAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyCustomerAddressAction(userProfile.getGasAccount())
        .navigateToAccountSummaryPage(userProfile)
        .navigateToBillHistory()
        .verifyAndViewBills()
        .logout();
        
	}
	
	
	@Test(groups = {Regression,BillHistory})
	public void viewBillHistoryForElectricity(){
		Report.createTestLogHeader("ViewBillHistory", "ElectricityAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("ElectricityAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyCustomerAddressAction(userProfile.getElecAccount())
        .navigateToAccountSummaryPage(userProfile)
        .navigateToBillHistory()
        .verifyAndViewBills()
        .logout();
	}
	
	@Test(groups = {Regression,BillHistory})
	public void viewBillHistoryForDual(){
		Report.createTestLogHeader("ViewBillHistory", "DualAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("DualAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyCustomerAddressAction(userProfile.getGasAccount())
        .navigateToAccountSummaryPage(userProfile)
        .navigateToBillHistory()
        .verifyAndViewBills()
        .verifyCustomerAddressAction(userProfile.getElecAccount())
        .navigateToAccountSummaryPage(userProfile)
        .navigateToBillHistory()
        .verifyAndViewBills()
        .logout();
	}
	
	@Test(groups = {Regression,BillHistory})
	public void viewBillHistoryForJI(){
		Report.createTestLogHeader("ViewBillHistory", "JIAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("JIAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyCustomerAddressAction(userProfile.getGasAccount())
        .navigateToAccountSummaryPage(userProfile)
        .navigateToBillHistory()
        .verifyAndViewBills()
        .logout();
	}
	
	
}
