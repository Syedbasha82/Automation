package bg.framework.app.functional.test.reFactoring;

import static bg.framework.app.functional.entities.FunctionalCategory.AccountOverview;
import static bg.framework.app.functional.entities.FunctionalCategory.Refactoring;
import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SiebelDataBase;
import bg.framework.app.functional.util.TestDataHelper;

public class AccountOverviewTest extends TestBase  {
	SiebelDataBase siebelDataBase = new SiebelDataBase();
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Smoke})
	    //Mandatory Fields in Userprofile.xml : UCRN,Gas Account Number
	    public void verifyGasAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify the look and feel content of the Account overview page for a BG active Gas account holder");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Elec Account Number
	    public void verifyElecAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify the look and feel , content of the Account overview page for a BG active Electricity account holder.");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Account Number
	    public void verifyDualAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify the look and feel content of the Account overview page for a BG active Dual Fuel account holder");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN, Account Number
	    public void verifyJIAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify the look and feel content of the Account overview page for a BG active Joint Invoice account holder");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Gas and Elec Account Number
	    public void verifyDualInactiveAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify Account overview page for an Dual Fuel account holder with 1 active BG account and 1 inactive BG account");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            siebelDataBase.setAccountStatus(userProfile.getElecAccount(), -7);
	            siebelDataBase.setAccountStatus(userProfile.getGasAccount(), +11);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Gas and Electricity Account Number
	    public void verifyDualClosedAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify Account overview page for a single fuel account holder with 1 closed BG account");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            siebelDataBase.setStatus(userProfile.getElecAccount(), +7,"Closed");
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Gas and Account Number
	    public void verifyGasBGSAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify Account overview page for an account holder with 1 active BG account and 1 service account");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("HomeSerivcesGasAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN and Account Number
	    public void verifyElecBGSAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify the look and feel , content of the Account overview page for a BG active Service only account holder");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServciesAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,BGS and Account Number
	    public void verifyBGSClosedAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify Account overview page for a BG active Service account and  a closed BGR account holder");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesElecAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            siebelDataBase.setStatus(userProfile.getElecAccount(), +7,"Closed");
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Account Number
	    public void verifyBGSASVAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify the look and feel of the Account overview page for a Service account holder with ASV and IB due");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Gas,Elec and Account Number
	    public void verifyASVAccAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify the look and feel of the Account overview page for a Service account holder with only ASV due");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,BGS Account Number
	    public void verifyBGSIBAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify the look and feel of the Account overview page for a Service account holder with only IB due");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview})
	    //Mandatory Fields in Userprofile.xml : UCRN,Gas Account Number
	    public void verifyBillLinkAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify Account overview page for a BGR account holder with an information link to view the latest bill");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Gas Account Number
	    public void verifyInfoLinkAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify Account overview page for a BGR account holder with an information link to view the latest statement");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }

	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Gas,Elec and Account Number
	    public void verifyLatestBillLinkAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify Account overview page for a BGR dual fuel account link to view the latest statement of latest bill");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Gas,Elec and Account Number
	    public void verifyNectarPageAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify whether the user is able to navigate to the Nectar registration journey by clicking on the Register Now link");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .verifyNectarPage()
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Gas,Elec and Account Number
	    public void verifyNectarLinkAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify whether the user is able to navigate to the nectar points page by clicking on the your nectar points link at the top");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Gas Account Number
	    public void verifyAccountYourmsgOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify whether the user is able to navigate your messages page by clicking on the Your messages at the top section of the page");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Gas Account Number
	    public void verifyCallLinkAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify whether the user is displayed with an overlay on clicking on the We need you to call us link against Nectar");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Elec Account Number
	    public void verifyTempLinkAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify whether the user is displayed with an overlay on clicking on the Temporarily unavailable link against Nectar");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Elec Account Number
	    public void verifyCrossSellLinkAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify whether the user with the cross sell offers for a pure BGS account holder and is able to navigate to offer landing page");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Elec Account Number
	    public void verifyUpSellLinkAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify whether the user dispalyed with the Up sell offers for a pure BGS account holder and able to navigate offer landing page");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Elec Account Number
	    public void verifyAddMissingAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify whether an overlay to add missing accounts is been displayed in the Accounts Overview page");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)	                
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Elec Account Number
	    public void verifyBrowserBackAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify the browser back functionality after navigating to the Account overview page");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .verifybrowserback()
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Gas and Elec Account Number
	    public void verifyMixedAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "verify whether only the accounts related to BG are displayed in the page for a Mixed user and vice versa");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Gas Account Number
	    public void verifyBGSSOAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify the look and feel of the Account overview page for a user with a matured BG account along with SSO account");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("Gas+SSO");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Gas Account Number
	    public void verifyBGWTPAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify the look and feel of the Account overview page for a user with a matured BG account along with WTP account");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("Gas+WTP");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Account Number
	    public void verifySSOWTPAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify the look and feel of the Account overview page for a user with a SSO account along with a WTP account");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("SSO+WTP");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Account Number
	    public void verifySSOBGSAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify the look and feel of the Account overview page for a user with a SSO account along with a service account");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("SSO+BGS");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Account Number
	    public void verifyWTPBGSAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify the look and feel of the Account overview page for a user with a WTP account along with a service account");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("WTP+BGS");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Account Number
	    public void verifyMultiplyAddrAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify whether all accounts are displayed in the account overview page for a multiple supplier address customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("WTP+BGS");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Gas and Elec Account Number
	    public void verifyMultiplyAddrInactiveAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify whether all accounts are displayed in the account overview page for a multiple supplier address customer(one account in both the address being inactive and rest accounts being active)");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            siebelDataBase.setAccountStatus(userProfile.getElecAccount(), -7);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Gas Account Number
	    public void verifySEGasAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify the look and feel content of the Account overview page for a SE active Gas account holder");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            siebelDataBase.setBrandSainsbury(userProfile.getGasAccount());
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Gas Account Number
	    public void verifyESRAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify whether the ESR status is properly displayed on the Account Overview page for a user who has not generated an ESR");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Gas Account Number
	    public void verifyESRHalfAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify whether the ESR status is properly displayed on the Account Overview page for a user who has half generated the report");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Gas Account Number
	    public void verifyESRReportAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify whether the ESR status is properly displayed on the Account Overview page for a user who has generated as ESR report");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Gas Account Number
	    public void verifyBackDateAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify if contact details overlay gets displayed when a BG only customer with login timestamp backdated greater than 6 months in BG");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .logout();
	    }
	 
	 
	 ////////////////////////////////////////////////BGB - BAU - july 28th Release//////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////BGB - BAU - july 28th Release//////////////////////////////////////////////////////////////////////////////////
	 
	 
	 
	 
	 
	 
	 
}
