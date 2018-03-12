package bg.framework.app.functional.test.reFactoring;
import static bg.framework.app.functional.entities.FunctionalCategory.UnitRates;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import org.testng.annotations.Test;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.action.selfServe.AccountSummaryAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.selfServe.AccountOverviewPage;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class UnitRatesTest extends TestBase {
	/*
	 * Mandatory Fields
	 * Email ID and Account Number in userprofile.xml
	 * Choose an Account which has the post code given in the code list
	 * Verify the Tariff names which appears in the screen is available in the array given in the code, if not add it in the array.
	 */ 
	@Test(groups = {Regression,UnitRates})
	public void verifyUnitRatesforElectricity() {
		Report.createTestLogHeader("Unit Rates test", "Electricity account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.verifyUnitRates(userProfile,"Electricity").logout();

	}
	/*
	 * Mandatory Fields
	 * Email ID and Account Number in userprofile.xml
	 * Choose an Account which has the post code given in the code list
	 * Verify the Tariff names which appears in the screen is available in the array given in the code, if not add it in the array.
	 */ 
	@Test(groups = {Regression,UnitRates})
	public void verifyUnitRatesforGas() {
		Report.createTestLogHeader("Unit Rates test", "Gas account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.verifyUnitRates(userProfile,"Gas").logout();

	}
	/*
	 * Mandatory Fields
	 * Email ID and Account Number in userprofile.xml
	 * Choose an Account which has the post code given in the code list
	 * Verify the Tariff names which appears in the screen is available in the array given in the code, if not add it in the array.
	 */ 
	@Test(groups = {Regression,UnitRates})
	public void verifyUnitRatesforJI() {
		Report.createTestLogHeader("Unit Rates test", "JI Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");

		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.verifyUnitRates(userProfile,"JI").logout();


	}/*
	 * Mandatory Fields
	 * Email ID and Account Number in userprofile.xml
	 * Choose an Account which has the post code given in the code list
	 * Verify the Tariff names which appears in the screen is available in the array given in the code, if not add it in the array.
	 */ 
	@Test(groups = {Regression,UnitRates})
	public void verifyUnitRatesforDual() {
		Report.createTestLogHeader("Unit Rates test", "Dual Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToGasAccountSummaryPage(userProfile)
		.verifyUnitRates(userProfile,"Gasdual")
		.navigatetoAccountoverview();
		new AccountOverviewAction()
		.navigateToElectricityAccountSummaryPage(userProfile)
		.verifyUnitRates(userProfile,"Electricitydual")
		.logout();

	}
}

