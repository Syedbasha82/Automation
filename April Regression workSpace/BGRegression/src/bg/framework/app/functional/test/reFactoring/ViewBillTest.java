
package bg.framework.app.functional.test.reFactoring;
import static bg.framework.app.functional.entities.FunctionalCategory.ViewBill;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.reFactoring.ViewBillAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.action.selfServe.AccountSummaryAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import bg.framework.app.functional.action.reFactoring.ViewBillAction;
import static bg.framework.app.functional.entities.FunctionalCategory.*;


public class ViewBillTest extends TestBase{
	/*
	 * Mandatory Fields
	 * Email ID and Account Number in userprofile.xml
	 */
	@Test(groups = {/*Regression,ViewBill,*//*OAMRegression*/})
	public void viewBillHistoryForElectricity(){
		//acc("Elect,...")
		Report.createTestLogHeader("ViewBill", "ElectricityAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("ElectricityAccount");
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage01()
		.clickSeeYourStatementLink()
        .navigateToBillHistory()
        .verifyAndViewBills()
        .viewDifferentStatements()
        .logout();
	}
	
	@Test(groups = {Regression,ViewBill,OAMRegression})
	public void viewBillHistoryForGas(){
		Report.createTestLogHeader("ViewBill", "GasAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("GasAccount");
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage01()
		.clickSeeYourStatementLink()
        .navigateToBillHistory()
        .verifyAndViewBills()
        .viewDifferentStatements()
        .logout();
	}
	
	@Test(groups = {Regression,ViewBill,OAMRegression})
	public void viewBillHistoryForJI(){
		Report.createTestLogHeader("ViewBill", "JIAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("JIAccount");
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage01()
		.clickSeeYourStatementLink()
        .navigateToBillHistory()
        .verifyAndViewBills()
        .viewDifferentStatements()
        .logout();
	}
	
	@Test(groups = {Regression,ViewBill,OAMRegression})
	public void viewBillHistoryForDual(){
		Report.createTestLogHeader("ViewBill", "DualAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("DualAccount");
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage01()
		.clickSeeYourStatementLink()
        .navigateToBillHistory()
        .verifyAndViewBills()
        .viewDifferentStatements()
        .logout();
	}
	
    @Test(groups = {Regression,ViewBill})
    public void DeeplinkTestGasAccount(){
    	//acc("GasAccount")
		Report.createTestLogHeader("ViewBill", "ElectricityAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("GasAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new ViewBillAction()
		.navigateToDeeplink(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile);
        new ViewBillAction()
        .verifyViewBillPage()
        .logout();
        
        
       
      
	}
    @Test(groups = {Regression,ViewBill})
    public void DeeplinkTestJIAccount(){
		Report.createTestLogHeader("ViewBill", "ElectricityAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("JIAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new ViewBillAction()
		.navigateToDeeplink(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile);
        new ViewBillAction()
        .verifyViewBillPage()
        .logout();
        
        
       
      
	}/*
	 * Mandatory Fields
	 * Email ID and Account Number in userprofile.xml
	 */
    /*
	 * Mandatory Fields
	 * Email ID and Account Number in userprofile.xml
	 */
    
    /*
	 * Mandatory Fields
	 * Email ID and Account Number in userprofile.xml
	 */
    

}