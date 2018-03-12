package bg.framework.app.functional.test.sales;

import static bg.framework.app.functional.entities.FunctionalCategory.RollOff;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.sales.RollOffAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class RollOffTest extends TestBase{

	/* Run in BG Site - Gas Customer*/
    @SuppressWarnings("unchecked")
	@Test(groups = {RollOff})
	public void verifyRollOffGasCustomer() {
    	UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        Report.createTestLogHeader("Roll Off - Price Promise March 2013", "Verify Roll Off Journey for Gas Customer");
        new HomePageAction()
		        .navigatetoLoginPage()
		        .loginDetails(userProfile)
        		.navigatetoRollOffLandingPage()
        		.verifybreadcrumb()
        		.validateRollOffPage(userProfile)
        		.verifyAudit(userProfile)
        		.logout();
    }
    /* Run in BG Site - ElectricityAccount Customer*/
    @SuppressWarnings("unchecked")
	@Test(groups = {RollOff})
	public void verifyRollOffElecCustomer() {
    	UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        Report.createTestLogHeader("Roll Off - Price Promise March 2013", "Verify Roll Off Journey for Electricity Customer");
        new HomePageAction()
		        .navigatetoLoginPage()
		        .loginDetails(userProfile)
        		.navigatetoRollOffLandingPage()
        		.verifybreadcrumb()
        		.validateRollOffPage(userProfile)
        		.verifyAudit(userProfile)
        		.logout();
    }
    /* Run in BG Site - JIAccount Customer*/
    @SuppressWarnings("unchecked")
	@Test(groups = {RollOff})
	public void verifyRollOffJICustomer() {
    	UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        Report.createTestLogHeader("Roll Off - Price Promise March 2013", "Verify Roll Off Journey for JI Customer");
        new HomePageAction()
		        .navigatetoLoginPage()
		        .loginDetails(userProfile)
        		.navigatetoRollOffLandingPage()
        		.verifybreadcrumb()
        		.validateRollOffPage(userProfile)
        		.verifyAudit(userProfile)
        		.logout();
    }
    /* Run in BG Site - JIAccount Customer*/
    @SuppressWarnings("unchecked")
	@Test(groups = {RollOff})
	public void verifyRollOffJIElecCustomer() {
    	UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        Report.createTestLogHeader("Roll Off - Price Promise March 2013", "Verify Roll Off Journey for JI -Electricity Customer");
        new HomePageAction()
		        .navigatetoLoginPage()
		        .loginDetails(userProfile)
        		.navigatetoRollOffLandingPage()
        		.verifybreadcrumb()
        		.validateRollOffPage(userProfile)
        		.verifyAudit(userProfile)
        		.logout();
    }
    /* Run in BG Site - JIAccount Customer*/
    @SuppressWarnings("unchecked")
	@Test(groups = {RollOff})
	public void verifyRollOffJIOtherTariffCustomer() {
    	UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        Report.createTestLogHeader("Roll Off - Price Promise March 2013", "Verify Roll Off Journey for JI Customer with Other Tariff");
        new HomePageAction()
		        .navigatetoLoginPage()
		        .loginDetails(userProfile)
        		.navigatetoRollOffLandingPage()
        		.verifybreadcrumb()
        		.validateRollOffPage(userProfile)
        		.logout();
    }
    /* Run in BG Site - DualAccount Customer*/
    @SuppressWarnings("unchecked")
	@Test(groups = {RollOff})
	public void verifyRollOffDualCustomer() {
    	UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        Report.createTestLogHeader("Roll Off - Price Promise March 2013", "Verify Roll Off Journey for Dual Customer");
        new HomePageAction()
		        .navigatetoLoginPage()
		        .loginDetails(userProfile)
        		.navigatetoRollOffLandingPage()
        		.verifybreadcrumb()
        		.validateRollOffPage(userProfile)
        		.verifyAudit(userProfile)
        		.logout();
    }
    /* Run in BG Site - DualGasAccount Customer*/
    @SuppressWarnings("unchecked")
	@Test(groups = {RollOff})
	public void verifyRollOffDualGasCustomer() {
    	UserProfile userProfile = new TestDataHelper().getUserProfile("DualGasAccount");
        Report.createTestLogHeader("Roll Off - Price Promise March 2013", "Verify Roll Off Journey for Dual Gas Customer");
        new HomePageAction()
		        .navigatetoLoginPage()
		        .loginDetails(userProfile)
        		.navigatetoRollOffLandingPage()
        		.verifybreadcrumb()
        		.validateRollOffPage(userProfile)
        		.verifyAudit(userProfile)
        		.logout();
    }
    /* Run in BG Site - DualElecAccount Customer*/
    @SuppressWarnings("unchecked")
	@Test(groups = {RollOff})
	public void verifyRollOffDualElecCustomer() {
    	UserProfile userProfile = new TestDataHelper().getUserProfile("DualElecAccount");
        Report.createTestLogHeader("Roll Off - Price Promise March 2013", "Verify Roll Off Journey for Dual Electricity Customer");
        new HomePageAction()
		        .navigatetoLoginPage()
		        .loginDetails(userProfile)
        		.navigatetoRollOffLandingPage()
        		.verifybreadcrumb()
        		.validateRollOffPage(userProfile)
        		.verifyAudit(userProfile)
        		.logout();
    }
    /* Run in BG Site - Gas Customer*/
    @SuppressWarnings("unchecked")
	@Test(groups = {RollOff})
	public void verifyRollOffGasClosedAccCustomer() {
    	UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        Report.createTestLogHeader("Roll Off - Price Promise March 2013", "Verify Roll Off Journey for Gas Closed Account Customer");
        new HomePageAction()
		        .navigatetoLoginPage()
		        .loginDetails(userProfile)
        		.navigatetoRollOffLandingPage()
        		.verifybreadcrumb()
        		.validateRollOffPage(userProfile)
        		.verifyAudit(userProfile)
        		.logout();
    }
    /* Run in BG Site - Gas Customer*/
    @SuppressWarnings("unchecked")
	@Test(groups = {RollOff})
	public void verifyRollOffWTPCustomer() {
    	UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        Report.createTestLogHeader("Roll Off - Price Promise March 2013", "Verify Roll Off Journey for Gas Customer");
        new HomePageAction()
		        .navigatetoLoginPage()
		        .loginDetails(userProfile)
        		.navigatetoRollOffLandingPage()
        		.verifybreadcrumb()
        		.validateRollOffPage(userProfile)
        		.verifyAudit(userProfile)
        		.logout();
    }
    /* Run in BG Site - Gas Customer*/
    @SuppressWarnings("unchecked")
	@Test(groups = {RollOff})
	public void verifyRollOffSSOCustomer() {
    	UserProfile userProfile = new TestDataHelper().getUserProfile("SSOAccount");
        Report.createTestLogHeader("Roll Off - Price Promise March 2013", "Verify Roll Off Journey for SSO Customer");
        new HomePageAction()
		        .navigatetoLoginPage()
		        .loginDetails(userProfile)
        		.navigatetoRollOffLandingPage()
        		.verifybreadcrumb()
        		.validateRollOffPage(userProfile)
        		.verifyAudit(userProfile)
        		.logout();
    }
}
