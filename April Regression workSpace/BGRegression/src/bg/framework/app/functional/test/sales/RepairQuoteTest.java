package bg.framework.app.functional.test.sales;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.sales.RepairQuoteAction;
import bg.framework.app.functional.entities.FunctionalCategory;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;

public class RepairQuoteTest extends TestBase {

	//////////////////////////////////////////////////////////////////// Anonymous //////////////////////////////////////////////////////////////////
	
	@Test(groups = {FunctionalCategory.Regression})
	public void verifyBoilerServiceQuoteAnonymous(){
		final UserProfile userProfile = new TestDataHelper().getUserProfile("RepairQuote");
		Report.createTestLogHeader("Repair quote journey", "Repair quote for boiler service anonymous");
		String ServiceType="Boiler";
		String Customer="Anonymous";
		new RepairQuoteAction()
		.navigateToRepairQuotePage()
		.getServiceQuoteDetails(ServiceType)
		.getContactDetails(userProfile,ServiceType,Customer)
		.OrdernowPage()
		.getPaymentDetails(userProfile)
		.getTermsAndOrderDetails();
	}
	
	@Test(groups = {FunctionalCategory.Regression})
	public void verifyAnnualGasServiceQuoteAnonymous(){
		final UserProfile userProfile = new TestDataHelper().getUserProfile("RepairQuote");
		Report.createTestLogHeader("Repair quote journey", "Repair quote for annual gas service anonymous");
		String ServiceType="GasAppliance";
		String Customer="Anonymous";
		new RepairQuoteAction()
		.navigateToRepairQuotePage()
		.getServiceQuoteDetails(ServiceType)
		.getContactDetails(userProfile,ServiceType,Customer)
		.verifyLeadTabledata_GetquotesAudit(userProfile);
	}
	
	
	//////////////////////////////////////////////////////////////// Logged In ///////////////////////////////////////////////////////////
	
	@Test(groups = {FunctionalCategory.Regression})
	public void verifyBoilerServiceQuoteLoggedIn(){
		final UserProfile userProfile = new TestDataHelper().getUserProfile("RepairQuote");
		Report.createTestLogHeader("Repair quote journey", "Repair quote for boiler service logged in");
		String ServiceType="Boiler";
		String Customer="LoggedIn";
		new HomePageAction().navigateToLogin().login(userProfile);
		new RepairQuoteAction()
		.navigateToRepairQuotePage()
		.getServiceQuoteDetails(ServiceType)
		.getContactDetails(userProfile,ServiceType,Customer)
		.OrdernowPage()
		.getPaymentDetails(userProfile)
		.getTermsAndOrderDetails();
	}
	
	@Test(groups = {FunctionalCategory.Regression})
	public void verifyAnnualGasServiceQuoteLoggedIn(){
		final UserProfile userProfile = new TestDataHelper().getUserProfile("RepairQuote");
		Report.createTestLogHeader("Repair quote journey", "Repair quote for annual gas service logged in");
		String ServiceType="GasAppliance";
		String Customer="LoggedIn";
		new HomePageAction().navigateToLogin().login(userProfile);
		new RepairQuoteAction()
		.navigateToRepairQuotePage()
		.getServiceQuoteDetails(ServiceType)
		.getContactDetails(userProfile,ServiceType,Customer)
		.verifyLeadTabledata_GetquotesAudit(userProfile);
	}
}

