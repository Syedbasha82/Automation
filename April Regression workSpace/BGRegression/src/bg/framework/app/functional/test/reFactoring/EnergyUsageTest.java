package bg.framework.app.functional.test.reFactoring;
import static bg.framework.app.functional.entities.FunctionalCategory.EnergyUsage;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import static bg.framework.app.functional.entities.FunctionalCategory.ViewBill;

import org.testng.annotations.Test;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.reFactoring.EnergyUsageAction;
import bg.framework.app.functional.action.reFactoring.ViewBillAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import static bg.framework.app.functional.entities.FunctionalCategory.*;

public class EnergyUsageTest extends TestBase {
	/*
	 * Mandatory Fields
	 * Email ID and Account Number in userprofile.xml
	 */
	@Test(groups = {Regression,EnergyUsage})
	public void EnergyusageForElectricity_EmberPage(){
		Report.createTestLogHeader("EnergyUsage", "ElectricityAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("ElectricityAccount");
		//getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile);
		//.navigateToAccountSummaryPage(userProfile);
		new EnergyUsageAction()
		.navigateToEnergyUsageNew()
		.verifyLinks()
		.viewallbills();
		new ViewBillAction()
		.verifyAndViewBills()
		.viewDifferentStatements()
		.logout();
	}
	
	@Test(groups = {Regression,EnergyUsage})
	public void EnergyusageForElectricity_CQPage(){
		Report.createTestLogHeader("EnergyUsage", "ElectricityAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("ElectricityAccount");
		//getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile);
		//.navigateToAccountSummaryPageNew01(userProfile);
		new EnergyUsageAction()
		.navigateToEnergyUsageNew()
		.verifyLinks()
		.viewallbills();
		new ViewBillAction()
		.verifyAndViewBills()
		.viewDifferentStatements()
		.logout();
	}
	
	
	/*
	 * Mandatory Fields
	 * Email ID and Account Number in userprofile.xml
	 */
	@Test(groups = {/*Regression,EnergyUsage,*/OAMRegression})
	public void EnergyusageForGas_EmberPage(){
		Report.createTestLogHeader("EnergyUsage", "GasAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("GasAccount");
	//	getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile);
		new EnergyUsageAction()
		.navigateToEnergyUsage()
		.verifyLinks()
		.viewallbills();
		new ViewBillAction()
		.verifyAndViewBills()
	//	.viewDifferentStatements()
		.logout();
	}
	
	@Test(groups = {/*Regression,EnergyUsage,*/OAMRegression})
	public void EnergyusageForGas_CQPage(){
		Report.createTestLogHeader("EnergyUsage", "GasAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("GasAccount");
	//	getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile);
		//.navigateToAccountSummaryPageNew01(userProfile);
		new EnergyUsageAction()
		.navigateToEnergyUsageNew()
		.verifyLinks()
		.viewallbills();
		new ViewBillAction()
		.verifyAndViewBills()
	//	.viewDifferentStatements()
		.logout();
	}
	
	/*
	 * Mandatory Fields
	 * Email ID and Account Number in userprofile.xml
	 */
	@Test(groups = {/*Regression,EnergyUsage,*/OAMRegression})
	public void EnergyusageForJI_EmberPage(){
		Report.createTestLogHeader("EnergyUsage", "JIAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("JIAccount");
//		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile);
		new EnergyUsageAction()
		.navigateToEnergyUsage()
		.verifyLinks()
		.viewallbills();
		new ViewBillAction()
		.verifyAndViewBills()
	//	.viewDifferentStatements()
		.logout();
	}
	
	@Test(groups = {/*Regression,EnergyUsage,*/OAMRegression})
	public void EnergyusageForJI_CQPage(){
		Report.createTestLogHeader("EnergyUsage", "JIAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("JIAccount");
//		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPageNew01(userProfile);
		new EnergyUsageAction()
		.navigateToEnergyUsage()
		.verifyLinks()
		.viewallbills();
		new ViewBillAction()
		.verifyAndViewBills()
	//	.viewDifferentStatements()
		.logout();
	}
	/*
	 * Mandatory Fields
	 * Email ID and Account Number in userprofile.xml
	 */
	@Test(groups = {Regression,EnergyUsage})
	public void EnergyusageForDual_EmberPage(){
		Report.createTestLogHeader("EnergyUsage", "DualAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("DualAccount");
	//	getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile);
		new EnergyUsageAction()
		.navigateToEnergyUsage()
		.verifyLinks()
		.viewallbills();
		new ViewBillAction()
		.verifyAndViewBills()
		.viewDifferentStatements()
		.navigatetoElectricity()
		.navigateToBillHistory()
		.verifyAndViewBills()
		.viewDifferentStatements()
		.logout();
	}
	
	@Test(groups = {Regression,EnergyUsage})
	public void EnergyusageForDual_CQPage(){
		Report.createTestLogHeader("EnergyUsage", "DualAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("DualAccount");
	//	getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPageNew01(userProfile);
		new EnergyUsageAction()
		.navigateToEnergyUsage()
		.verifyLinks()
		.viewallbills();
		new ViewBillAction()
		.verifyAndViewBills()
		.viewDifferentStatements()
		.navigatetoElectricity()
		.navigateToBillHistory()
		.verifyAndViewBills()
		.viewDifferentStatements()
		.logout();
	}
	
}
