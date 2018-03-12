package bg.framework.app.functional.test.Slingshot;

import static bg.framework.app.functional.entities.FunctionalCategory.Regression;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.Slingshot.MakingComplaintsAction;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

/**
 * @author 292238
 *
 */
public class MakingComplaintTest extends TestBase{
	
	String strJourney[] = {"Business","Corporate"};
	
	//TC_MC_Bus_001,2,4: To check whether the user can able to contact customer care team by clicking email us link and whether the "email us" landing page is getting displayed for Logged in customers(end to end flow)
	//TC_MC_Bus_008,15,16: Check whether the address of the particular account is prepopulated for logged in customers
	@Test(groups={Regression})
	public void verifyEmailUsInComplaints_Business(){
		Report.createTestLogHeader("Making complaint-Business", "Verifies making a complaint Test journey");
		UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");
		new MakingComplaintsAction().bgbLoginUser()
		.bgbloginDetails(userProfile)
		.openMakingComplaintPage(strJourney[0])
		.enterComplaintsFields(userProfile)
		.verifyConfirmationinPage(userProfile)
		.logoutSession();
	}
	//TC_MC_Corporate_001	"Validate whether the user is able to proceed Complaints journey by Clicking ""Make a complaint"" from support centre (contact us) for Logged in customers"
	//TC_MC_Corporate_002	"a) Verify the look and feel of ""Making  a complaint"" landing page for Logged in customers
	//b) Verify the link navigations in ""Making  a complaint"" landing page for Logged in customers 1)LHN 2)RHN(""download our code of practice "" )"
	//TC_MC_Corporate_003	To check whether the user can able to contact customer care team by clicking email us link and whether the "email us" landing page is getting displayed for Logged in customers(end to end flow)

	@Test(groups={Regression})
	public void verifyEmailUsInComplaints_Corporate(){
		Report.createTestLogHeader("Making complaint-Corporate", "Verifies making a complaint Test journey for Corporate");
		UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");
		new MakingComplaintsAction().bgbLoginUser()
		.bgcloginDetails(userProfile)
		.openMakingComplaintPage(strJourney[1])
		.enterComplaintsFields(userProfile)
		.verifyConfirmationinPage(userProfile)
		.logoutSession();
	}
	//TC_MC_Bus_003: Verify the link navigations in "Making  a complaint" landing page for Logged in customers
	//TC_MC_Bus_005: Verify the link navigations in "Email us" landing page for logged in customers
	//TC_MC_Bus_027	Verify the LHN and link navigations in Email Us landing page.

	@Test(groups={Regression})
	public void verifyMakingComplaintsPageLinks(){
		Report.createTestLogHeader("Making complaint-Business", "Verify the link navigations in Email us landing page for logged in customers");
		UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");
		new MakingComplaintsAction().bgbLoginUser()
		.bgbloginDetails(userProfile)
		.openMakingComplaintPage(strJourney[0])
		.verifyLinks()
		.enterComplaintsFields(userProfile)
		.verifyConfirmationinPage(userProfile)
		.logoutSession();
	}
	//TC_MC_Corporate_004,TC_MC_Corporate_021,TC_MC_Corporate_028	"a)Verify the look and feel of ""Email us"" landing page for logged in customers 
	//b) Verify the link navigations in ""Email us"" landing page for logged in customers i)LHN	ii)RHN iii)""Where I can find this"" link of account number field"
	//TC_MC_Bus_005: Verify the link navigations in "Email us" landing page for logged in customers
	//TC_MC_Corporate_009:Verify the link navigations of Confirmation  page for logged in customer
		@Test(groups={Regression})
		public void verifyMakingComplaintsPageLinks_Corporate(){
			Report.createTestLogHeader("Making complaint-Corporate", "Verify the link navigations in Email us landing page for logged in corporate customers");
			UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");
			new MakingComplaintsAction().bgbLoginUser()
			.bgbloginDetails(userProfile)
			.openMakingComplaintPage(strJourney[1])
			.verifyLinks()
			.enterComplaintsFields(userProfile)
			.verifyConfirmationinPage(userProfile)
			.logoutSession();
		}
	/*@Test(groups ={Regression})	
	public void verifyMakingComplaintsEmailUsLoggedInCustomers(){
	Report.createTestLogHeader("Making complaint_Business", "Validate whether the email us landing page is getting displayed for Logged in customers");
	UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");
	new MakingComplaintsAction().bgbLoginUser()
	.bgbloginDetails(userProfile)
	.openMakingComplaintPage()
	.verifyWhereCanIFindThisLink();
	}*/
	//TC_MC_Bus_006, 7: Verify the "Account number" field validations and its error message for more than 15 accounts 
	@Test(groups={Regression})
	public void verifyMakingComplaintsAccountNumberField(){
		Report.createTestLogHeader("Making complaint-Business", "Verify the Account number field validations and its error message for more than 15 accounts ");
		UserProfile userProfile = new TestDataHelper().getUserProfile("Morethan15Account");
		new MakingComplaintsAction().bgbLoginUser()		
		.openMakingComplaintPage(strJourney[0])
		.validateAccountNumberField(userProfile)
		.logoutSession();
}
	//TC_MC_Bus_009: Verify the  "Complaint regarding" field validations  and its error message for logged in customer
	@Test(groups={Regression})
	public void verifyAndValidateQueryComplaintField(){
		Report.createTestLogHeader("Making complaint-Business", "Verify the  Complaint regarding field validations  and its error message for logged in customer");
		UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");
		new MakingComplaintsAction().bgbLoginUser()
		.bgbloginDetails(userProfile)
		.openMakingComplaintPage(strJourney[0])
		.verifyAndValidateQueryComplaintField(userProfile);
}

	//TC_MC_Corporate_006: a)Verify the  "Complaint regarding" field validations  and its error message for logged in customer
	@Test(groups={Regression})
	public void verifyAndValidateQueryComplaintField_Corporate(){
		Report.createTestLogHeader("Making complaint-Business", "Verify the  Complaint regarding field validations  and its error message for logged in corporate customer");
		UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");
		new MakingComplaintsAction().bgbLoginUser()
		.bgbloginDetails(userProfile)
		.openMakingComplaintPage(strJourney[1])
		.verifyAndValidateQueryComplaintField(userProfile)
		.logoutSession();
}
	//TC_MC_Bus_010: Verify "How would you prefer to be contacted" field validations and its error message for logged in customer
	@Test(groups={Regression})
	public void verifyAndValidatePreferContactField(){
		Report.createTestLogHeader("Making complaint-Corporate", "Verify How would you prefer to be contacted field validations and its error message for logged in customer");
		UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");
		new MakingComplaintsAction().bgbLoginUser()
		.bgbloginDetails(userProfile)
		.openMakingComplaintPage(strJourney[0])
		.verifyAndValidatePreferContactField(userProfile)
		.verifyConfirmation()
		.logoutSession();
}
	//TC_MC_Bus_019: a)To check whether the user can able to contact customer care team (step1) by clicking "Call us" link for Logged in customers and validate whether the "Call us"  overlay is getting displayed for Logged in customers and look and feel of "Call us"  overlayfor logged in customers
	//b)To check whether the user can able to contact customer care team by clicking "Write to us" link for Logged in customers and validate whether the "Write to us"  overlay is getting displayed for Logged in customers and look and feel of "Write to us"   overlayfor logged in customers
	//TC_MC_Bus_020:a) To check whether the user can able to customer service director (step2)   by clicking "Email the customer service director" link for Logged in customers and validate whether the "Email the customer service director"  overlay is getting displayed for Logged in customers and look and feel of "Email the customer service director"  overlay for logged in customers
	//b) To check whether the user can able to customer service director  by clicking  "Call us" link for Logged in customers and validate whether the "Call us"  overlay is getting displayed for Logged in customers and look and feel of"Call us"  overlayfor logged in customers
	//c)To check whether the user can able to customer service director  by clicking "Write to us"  link for Logged in customers and validate whether the "Write to us"   overlay is getting displayed for Logged in customers and look and feel of "Write to us"   overlayfor logged in customers
	//TC_MC_Bus_021:a) To check whether the user can able to customer service director (step3)   by clicking "By Email" link for Logged in customers and validate whether the "By email"   overlay is getting displayed for Logged in customers and look and feel of "By email"   overlay for logged in customers
	//b) To check whether the user can able to customer service director (step3)   by clicking "By Post" link for Logged in customers and validate whether the "By Post"   overlay is getting displayed for Logged in customers and verify the look and feel of "By Post" overlayfor logged in customers
	@Test(groups={Regression})
	public void verifyAllContactUsOptions(){
		Report.createTestLogHeader("Making complaint-Business", "Verifies whether the user can able to contact customer care team by all options provided");
		UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");
		new MakingComplaintsAction().bgbLoginUser()
		.bgbloginDetails(userProfile)
		.openMakingComplaint(strJourney[0])
		.verifyAllContactUsOptions()
		.logoutSession();		
}
	//TC_MC_Bus_023	"Validate whether the user is able to proceed Complaints journey by Clicking ""Make a complaint"" from support centre (contact us) for Anonymous  customers"
	//TC_MC_Bus_024	Validate whether the "Making  a complaint" landing page is displayed for Anonymous customers and verify the look and feel of "Making  a complaint" landing page for Anonymous customers
	//TC_MC_Bus_026	To check whether the user can able to contact customer care team by clicking email us link for  Anonymous customers and validate whether the "email us" landing page is getting displayed for anonymous customers and verify the look and feel of "Email us" landing page for Anonymous customers
	//TC_MC_Bus_031	Verify the functionality of Submit button for  Anonymous customer
	//TC_MC_Bus_043	Check whether the user can enter address manually by clicking "Enter your address manually" link for BGB Anonymous customer and check whether the email address overlay is getting displayed by clicking "Enter your address manually" link for BGB Anonymous customer
	//TC_MC_Bus_056	Check whether Confirmation  page is getting displayed after submitting  the complaint for Anonymous customer and verify the look and feel of Confirmation  page  for Anonymous customer and verify the link navigations of Confirmation  page for Anonymous customer
	//TC_MC_Bus_057	Check whether confirmation email is triggered to customer for Anonymous customer and verify the look and feel of confirmation email is triggered to customer for Anonymous customer and verify the link navigations of confirmation email is triggered to customer for Anonymous customer

	@Test(groups={Regression})
	public void verifyMakingComplaintEnterAddressManuallyBGB(){
		Report.createTestLogHeader("Making complaint-Business", "Verify enter address manually by clicking Enter your address manually link for BGB AnonymousCustomers");
	 	UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");
	 	new MakingComplaintsAction().bgbLoginUser()	
		.openMakingComplaintPage(strJourney[0])		
	   	.validateEnterAddressManually(userProfile, "BGCustomer", "BG Customer Radio Button","Manual")
	   	.verifyConfirmationinPage(userProfile)
	   	.logoutSession();
	}
	
	//TC_MC_Bus_042	Check whether address results are displayed after clicking "Find address" button" for BGB Anonymous customer and check whether the user can select an address from the list of address displayed for BGB Anonymous customer

	@Test(groups={Regression})
	public void verifyComplaintFindAddressBGB(){
		Report.createTestLogHeader("Making complaint-Business", "Verifies the user can select an address from the list of address displayed for BGB Anonymous customer");
	 	UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");
	 	new MakingComplaintsAction().bgbLoginUser()		
		.openMakingComplaintPage(strJourney[0])		
	   	.validateEnterAddressManually(userProfile, "BGCustomer", "BG Customer Radio Button","FindAddr")
	   	.verifyConfirmationinPage(userProfile)
	   	.logoutSession();
	}
	//TC_MC_Corporate_030	Check whether address results are displayed after clicking "Find address" button" for  non BGB Anonymous customer and check whether the user can select an address from the list of address displayed for non BGB Anonymous customer

	@Test(groups={Regression})
	public void verifyComplaintFindAddressBGC(){
		Report.createTestLogHeader("Making complaint-Corporate", "Verifies the user can select an address from the list of address displayed for BGC Anonymous customer");
	 	UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");
	 	new MakingComplaintsAction().bgbLoginUser()		
		.openMakingComplaintPage(strJourney[1])		
	   	.validateEnterAddressManually(userProfile, "BGCustomer", "BG Customer Radio Button","FindAddr")
	   	.verifyConfirmationinPage(userProfile)
	   	.logoutSession();
	}
	//TC_MC_Corporate_014	"Validate whether the user is able to proceed Complaints journey by Clicking ""Make a complaint"" from support centre (contact us)for Anonymous  customers"
	//TC_MC_Corporate_016	To check whether the user can able to contact customer care team by clicking email us link for  Anonymous customers and validate whether the "email us" landing page is getting displayed for anonymous customers and verify the look and feel of "Email us" landing page for Anonymous customers
	//TC_MC_Corporate_020	"a)Verify the functionality of Submit button for  Anonymous customer
	//TC_MC_Corporate_031	Check whether the user can enter address manually by clicking "Enter your address manually" link for non BGB Anonymous customer
	//TC_MC_Corporate_035	"a)Check whether confirmation email is triggered to customer for Anonymous customer and verify the look and feel of confirmation email is triggered to customer for Anonymous customer and verify the link navigations of confirmation email is triggered to customer for Anonymous customer 
	//b)verify the Customer receives email confirmation with same unique reference. "
	@Test(groups={Regression})
	public void verifyMakingComplaintEnterAddressManuallyBGC(){
		Report.createTestLogHeader("Making complaint-Corporate", "Verify enter address manually by clicking Enter your address manually link for BGC Customers");
	 	UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");
	 	new MakingComplaintsAction().bgbLoginUser()		
		.openMakingComplaintPage(strJourney[1])		
	   	.validateEnterAddressManually(userProfile, "BGCustomer", "BG Customer Radio Button","Manual")
	   	.verifyConfirmationinPage(userProfile)
	   	.logoutSession();
	}
	@Test(groups={Regression})
	public void verifyYourComplaintField(){
		Report.createTestLogHeader("Making complaint-Corporate", "Verify enter address manually by clicking Enter your address manually link for BGG Customers");
	 	UserProfile userProfile = new TestDataHelper().getUserProfile("BGBLessthanFiveAccounts");
	 	new MakingComplaintsAction().bgbLoginUser()		
		.openMakingComplaintPage(strJourney[1])		
	   	.verifyYourComplaintField(userProfile, "BGCustomer", "BG Customer Radio Button","Manual")
	   	.verifyConfirmationinPage(userProfile)
	   	.logoutSession();
	}
}
