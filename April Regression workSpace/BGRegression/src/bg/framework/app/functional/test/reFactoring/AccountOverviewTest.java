package bg.framework.app.functional.test.reFactoring;

import static bg.framework.app.functional.entities.FunctionalCategory.AccountOverview;
import static bg.framework.app.functional.entities.FunctionalCategory.Refactoring;
import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
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
	        Report.createTestLogHeader("Account Overview Journey", "Verify Account overview page for a BG active Gas account holder");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	//            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction()
                .navigateToLoginPage();
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
	    //        getCustomerDetailsToUserProfileOAM(userProfile);
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
	     //       getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction()
	    		.navigateToLogin();
	    		//.login(userProfile);
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
	      //      getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction()
	 	       .navigateToLogin();
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
	            UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccountIB");
	            //getCustomerDetailsToUserProfileOAM(userProfile);
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
	            UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");
//	            getCustomerDetailsToUserProfileOAM(userProfile);
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
	            UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");
//	            getCustomerDetailsToUserProfileOAM(userProfile);
	  //          siebelDataBase.setStatus(userProfile.getElecAccount(), +7,"Closed");
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
//	            getCustomerDetailsToUserProfileOAM(userProfile);
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
//	            getCustomerDetailsToUserProfileOAM(userProfile);
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
//	            getCustomerDetailsToUserProfileOAM(userProfile);
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
	     //       getCustomerDetailsToUserProfileOAM(userProfile);
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
	        //    getCustomerDetailsToUserProfileOAM(userProfile);
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
	    //        getCustomerDetailsToUserProfileOAM(userProfile);
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
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	      //      getCustomerDetailsToUserProfileOAM(userProfile);
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
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	            //getCustomerDetailsToUserProfileOAM(userProfile);
	           /* new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidationWTP(userProfile)
	                .logout();*/
	    }
	 @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Refactoring})
	    //Mandatory Fields in Userprofile.xml : UCRN,Account Number
	    public void verifySSOWTPAccountOverview() {
	        Report.createTestLogHeader("Account Overview Journey", "Verify the look and feel of the Account overview page for a user with a SSO account along with a WTP account");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
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
	            UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");
//	            getCustomerDetailsToUserProfileOAM(userProfile);
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
	            UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");
//	            getCustomerDetailsToUserProfileOAM(userProfile);
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
	 
	 
	 // Sprint - 03 - 2013 changes
	    @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Smoke})
	    //Mandatory Fields in Userprofile.xml : UCRN,Gas Account Number
	    public void verifyGasClosedAccountOverview() {
	        Report.createTestLogHeader("Closed Account Link verification", "Verify Account overview page for a BG Inactive Closed Gas account holder");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	            siebelDataBase.setStatus(userProfile.getAccNumber(), -4,"Inactive");
	            //siebelDataBase.setAccountStatus(userProfile.getAccNumber(),-4);
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .verifyDebitandCredit(userProfile)
	                .logout();
	    }
	    
	    @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Smoke})
	    //Mandatory Fields in Userprofile.xml : UCRN,Elec Account Number
	    public void verifyElecClosedAccountOverview() {
	        Report.createTestLogHeader("Closed Account Link verification", "Verify Account overview page for a BG Inactive Closed Electricity account holder");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            siebelDataBase.setStatus(userProfile.getAccNumber(), -4,"Inactive");
	            //siebelDataBase.setAccountStatus(userProfile.getAccNumber(),-4);
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .verifyDebitandCredit(userProfile)
	                .logout();
	    }
	    @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Smoke})
	    //Mandatory Fields in Userprofile.xml : UCRN,Elec Account Number
	    public void verifyJIClosedAccountOverview() {
	        Report.createTestLogHeader("Closed Account Link verification", "Verify Account overview page for a BG Inactive Closed JI account holder");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
	            siebelDataBase.setStatus(userProfile.getAccNumber(), -4,"Inactive");
	            //siebelDataBase.setAccountStatus(userProfile.getAccNumber(),-4);
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .verifyDebitandCredit(userProfile)
	                .logout();
	    }
	    @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Smoke})
	    //Mandatory Fields in Userprofile.xml : UCRN,Gas Account Number
	    public void verifyDualInactiveClosedAccountOverview() {
	        Report.createTestLogHeader("Closed Account Link verification", "Verify Account overview page for a BG Inactive Closed Dual account holder");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount1");
	            siebelDataBase.setStatus(userProfile.getAccNumber(), -4,"Inactive");
	            //siebelDataBase.setAccountStatus(userProfile.getAccNumber(),-4);
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .verifyDebitandCredit(userProfile)
	                .logout();
	    }
	    @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Smoke})
	    //Mandatory Fields in Userprofile.xml : UCRN,Gas Account Number
	    public void verifyGasActiveClosedAccountOverview() {
	        Report.createTestLogHeader("Closed Account Link verification", "Verify Account overview page for a BG Active Closed Gas account holder");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccountInactive");
	            siebelDataBase.setStatus(userProfile.getAccNumber(), -4,"Active");
	            //siebelDataBase.setAccountStatus(userProfile.getAccNumber(),-4);
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .verifyDebitandCredit(userProfile)
	                .logout();
	    }
	    
	    @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Smoke})
	    //Mandatory Fields in Userprofile.xml : UCRN,Elec Account Number
	    public void verifyElecActiveClosedAccountOverview() {
	        Report.createTestLogHeader("Closed Account Link verification", "Verify Account overview page for a BG Active Closed Electricity account holder");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccountInactive");
	            siebelDataBase.setStatus(userProfile.getAccNumber(), -4,"Active");
	            //siebelDataBase.setAccountStatus(userProfile.getAccNumber(),-4);
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .verifyDebitandCredit(userProfile)
	                .logout();
	    }
	    @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Smoke})
	    //Mandatory Fields in Userprofile.xml : UCRN,Elec Account Number
	    public void verifyJIActiveClosedAccountOverview() {
	        Report.createTestLogHeader("Closed Account Link verification", "Verify Account overview page for a BG Active Closed JI account holder");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccountInactive");
	            siebelDataBase.setStatus(userProfile.getAccNumber(), -4,"Active");
	            //siebelDataBase.setAccountStatus(userProfile.getAccNumber(),-4);
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .verifyDebitandCredit(userProfile)
	                .logout();
	    }
	    @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Smoke})
	    //Mandatory Fields in Userprofile.xml : UCRN,Gas Account Number
	    public void verifyDualActiveClosedAccountOverview() {
	        Report.createTestLogHeader("Closed Account Link verification", "Verify Account overview page for a BG Active Closed Gas account holder");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount1");
	            siebelDataBase.setStatus(userProfile.getAccNumber(), -4,"Active");
	            //siebelDataBase.setAccountStatus(userProfile.getAccNumber(),-4);
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .verifyDebitandCredit(userProfile)
	                .logout();
	    }
	    
	    @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Smoke})
	    //Mandatory Fields in Userprofile.xml : UCRN,Gas Account Number
	    public void verifyGasWithdrawingClosedAccountOverview() {
	        Report.createTestLogHeader("Withdrawing Account verification", "Verify Account overview page for a BG Withdrawing Closed Gas account holder");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccountInactive");
	            siebelDataBase.setStatus(userProfile.getAccNumber(), -4,"Withdrawing");
	            //siebelDataBase.setAccountStatus(userProfile.getAccNumber(),-4);
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .verifyDebitandCredit(userProfile)
	                .logout();
	    }
	    
	    @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Smoke})
	    //Mandatory Fields in Userprofile.xml : UCRN,Elec Account Number
	    public void verifyElecWithdrawingClosedAccountOverview() {
	        Report.createTestLogHeader("Withdrawing Account verification", "Verify Account overview page for a BG Withdrawing Closed Electricity account holder");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccountInactive");
	            siebelDataBase.setStatus(userProfile.getAccNumber(), -4,"Withdrawing");
	            //siebelDataBase.setAccountStatus(userProfile.getAccNumber(),-4);
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .verifyDebitandCredit(userProfile)
	                .logout();
	    }
	    @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Smoke})
	    //Mandatory Fields in Userprofile.xml : UCRN,Account Number
	    public void verifyJIWithdrawingClosedAccountOverview() {
	        Report.createTestLogHeader("Withdrawing Account verification", "Verify Account overview page for a BG Withdrawing Closed JI account holder");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccountInactive");
	            siebelDataBase.setStatus(userProfile.getAccNumber(), -4,"Withdrawing");
	            //siebelDataBase.setAccountStatus(userProfile.getAccNumber(),-4);
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .verifyDebitandCredit(userProfile)
	                .logout();
	    }
	    @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Smoke})
	    //Mandatory Fields in Userprofile.xml : UCRN,Account Number
	    public void verifyDualWithdrawClosedAccountOverview() {
	        Report.createTestLogHeader("Withdrawing Account verification", "Verify Account overview page for a BG Withdrawing Closed Dual account holder");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount1");
	            siebelDataBase.setStatus(userProfile.getAccNumber(), -4,"Withdrawing");
	            //siebelDataBase.setAccountStatus(userProfile.getAccNumber(),-4);
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .verifyDebitandCredit(userProfile)
	                .logout();
	    }
	    
	    @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Smoke})
	    //Mandatory Fields in Userprofile.xml : UCRN,Gas Account Number
	    public void verifyGasWithdrawingActiveAccountOverview() {
	        Report.createTestLogHeader("Withdrawing Account verification", "Verify Account overview page for a BG Withdrawing active Gas account holder");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	            siebelDataBase.setStatus(userProfile.getAccNumber(), +4,"Withdrawing");
	            //siebelDataBase.setAccountStatus(userProfile.getAccNumber(),-4);
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .verifyDebitandCredit(userProfile)
	                .logout();
	    }
	    
	    @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Smoke})
	    //Mandatory Fields in Userprofile.xml : UCRN,Elec Account Number
	    public void verifyElecWithdrawingActiveAccountOverview() {
	        Report.createTestLogHeader("Withdrawing Account verification", "Verify Account overview page for a BG Withdrawing active Electricity account holder");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            siebelDataBase.setStatus(userProfile.getAccNumber(), +4,"Withdrawing");
	            //siebelDataBase.setAccountStatus(userProfile.getAccNumber(),-4);
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .verifyDebitandCredit(userProfile)
	                .logout();
	    }
	    @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Smoke})
	    //Mandatory Fields in Userprofile.xml : UCRN,Account Number
	    public void verifyJIWithdrawingActiveAccountOverview() {
	        Report.createTestLogHeader("Withdrawing Account verification", "Verify Account overview page for a BG Withdrawing active JI account holder");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
	            siebelDataBase.setStatus(userProfile.getAccNumber(), +4,"Withdrawing");
	            //siebelDataBase.setAccountStatus(userProfile.getAccNumber(),-4);
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .verifyDebitandCredit(userProfile)
	                .logout();
	    }
	    @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Smoke})
	    //Mandatory Fields in Userprofile.xml : UCRN,Account Number
	    public void verifyDualWithdrawActiveAccountOverview() {
	        Report.createTestLogHeader("Withdrawing Account verification", "Verify Account overview page for a BG Withdrawing Active Dual account holder");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount1");
	            siebelDataBase.setStatus(userProfile.getAccNumber(), +4,"Withdrawing");
	            //siebelDataBase.setAccountStatus(userProfile.getAccNumber(),-4);
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .verifyDebitandCredit(userProfile)
	                .logout();
	    }
	    
	    //Sprint 04 changes
	    
	    @SuppressWarnings("unchecked")
	    @Test(groups = {AccountOverview,Smoke})
	    //Mandatory Fields in Userprofile.xml : UCRN,Account Number
	    public void verifyJIClosedContractAccountOverview() {
	        Report.createTestLogHeader("Withdrawing Account verification", "Verify Account overview page for a BG Withdrawing active JI account holder");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
	            siebelDataBase.setStatus(userProfile.getAccNumber(), -4,"Inactive");
	            //siebelDataBase.setAccountStatus(userProfile.getAccNumber(),-4);
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .accountOverviewLogInUserValidation(userProfile)
	                .verifyDebitandCredit(userProfile)
	                .logout();
	    }
	    
	////// Service Emails Scenarios(only CRM Test data) ///////////
	    
		    @Test(groups = {AccountOverview,Refactoring})
		    //Mandatory Fields in Userprofile.xml : 
	        public void verifyHC100AndHC200ServiceEmailAccountOverview(){
		    Report.createTestLogHeader("Account Verification for paperless Billing","verify Account overview page for HC100 and HC200 Account");
		    UserProfile userProfile = new TestDataHelper().getUserProfile("HC100AndHC200Account");
		    new LoginAction()
		        .loginUserDetails(userProfile)
		        .accountOverviewLogInUserValidation(userProfile)
		        .logout();
		    }
		    
		    @Test(groups = {AccountOverview,Refactoring})
		    //Mandatory Fields in Userprofile.xml :
	        public void verifyHC100AndGACServiceEmailAccountOverview(){
		    Report.createTestLogHeader("Account Verification for paperless Billing","verify Account overview page for HC100 and GAC Account");
		    UserProfile userProfile = new TestDataHelper().getUserProfile("HC100AndGACAccount");
		    new LoginAction()
		        .loginUserDetails(userProfile)
		        .accountOverviewLogInUserValidation(userProfile)
		        .logout();
		    }
		    @Test(groups = {AccountOverview,Refactoring})
		    //Mandatory Fields in Userprofile.xml :
	        public void verifyHC100AndHC400ServiceEmailAccountOverview(){
		    Report.createTestLogHeader("Account Verification for paperless Billing","verify Account overview page for HC100 and HC400 Account");
		    UserProfile userProfile = new TestDataHelper().getUserProfile("HC100AndHC400Account");
		    new LoginAction()
		        .loginUserDetails(userProfile)
		        .accountOverviewLogInUserValidation(userProfile)
		        .logout();
		    }
		    
		    @Test(groups = {AccountOverview,Refactoring})
		    //Mandatory Fields in Userprofile.xml :
	        public void verifyHC200AndHC300ServiceEmailAccountOverview(){
		    Report.createTestLogHeader("Account Verification for paperless Billing","verify Account overview page for HC200 and HC300 Account");
		    UserProfile userProfile = new TestDataHelper().getUserProfile("HC200AndHC300Account");   
		    new LoginAction()
		        .loginUserDetails(userProfile)
		        .accountOverviewLogInUserValidation(userProfile)
		        .logout();
		    }
		    @Test(groups = {AccountOverview,Refactoring})
		    //Mandatory Fields in Userprofile.xml :
	        public void verifyHC200AndHC400ServiceEmailAccountOverview(){
		    Report.createTestLogHeader("Account Verification for paperless Billing","verify Account overview page for HC200 and HC400 Account");
		    UserProfile userProfile = new TestDataHelper().getUserProfile("HC200AndHC400Account");
		    new LoginAction()
		        .loginUserDetails(userProfile)
		        .accountOverviewLogInUserValidation(userProfile)
		        .logout();
		    }
		    @Test(groups = {AccountOverview,Refactoring})
		    //Mandatory Fields in Userprofile.xml :
	        public void verifyHC300AndHC400ServiceEmailAccountOverview(){
		    Report.createTestLogHeader("Account Verification for paperless Billing","verify Account overview page for HC300 and HC400 Account");
		    UserProfile userProfile = new TestDataHelper().getUserProfile("HC300AndHC400Account");
		    new LoginAction()
		        .loginUserDetails(userProfile)
		        .accountOverviewLogInUserValidation(userProfile)
		        .logout();
		    }
		    
		    @Test(groups = {AccountOverview,Refactoring})
		    //Mandatory Fields in Userprofile.xml :
	        public void verifyHC100HC200KACAndHECAccountServiceEmailAccountOverview(){
		    Report.createTestLogHeader("Account Verification for paperless Billing","verify Account overview page for HC100 HC200 KAC And HEC Account");
		    UserProfile userProfile = new TestDataHelper().getUserProfile("HC100HC200KACAndHECAccount");
		    new LoginAction()
		        .loginUserDetails(userProfile)
		        .accountOverviewLogInUserValidation(userProfile)
		        .logout();
		    }
		    
		    @Test(groups = {AccountOverview,Refactoring})
		    //Mandatory Fields in Userprofile.xml :
	        public void verifyHC200FlexiAndHC300FlexiServiceEmailAccountOverview(){
		    Report.createTestLogHeader("Account Verification for paperless Billing","verify Account overview page for HC200Flexi and HC300Flexi Account at different supply address");
		    UserProfile userProfile = new TestDataHelper().getUserProfile("HC200FlexiAndHC300FlexiAccount");
		    new LoginAction()
		        .loginUserDetails(userProfile)
		        .accountOverviewLogInUserValidation(userProfile)
		        .logout();
		    } 
		    @Test(groups = {AccountOverview,Refactoring})
		    //Mandatory Fields in Userprofile.xml :
	        public void verifyHC200FlexiAndHC400FlexiServiceEmailAccountOverview(){
		    Report.createTestLogHeader("Account Verification for paperless Billing","verify Account overview page for HC200Flexi and HC300Flexi Account at different supply address");
		    UserProfile userProfile = new TestDataHelper().getUserProfile("HC200FlexiAndHC400FlexiAccount");
		    new LoginAction()
		        .loginUserDetails(userProfile)
		        .accountOverviewLogInUserValidation(userProfile)
		        .logout();
		    } 
		    
		    @Test(groups = {AccountOverview,Refactoring})
		    //Mandatory Fields in Userprofile.xml :
	        public void verifyHC300FlexiAndHC400FlexiServiceEmailAccountOverview(){
		    Report.createTestLogHeader("Account Verification for paperless Billing","verify Account overview page for HC300Flexi and HC300Flexi Account at different supply address");
		    UserProfile userProfile = new TestDataHelper().getUserProfile("HC300FlexiAndHC400FlexiAccount");
		    new LoginAction()
		        .loginUserDetails(userProfile)
		        .accountOverviewLogInUserValidation(userProfile)
		        .logout();
		    } 
		    
		    @Test(groups = {AccountOverview,Refactoring})
		    //Mandatory Fields in Userprofile.xml :
	        public void verifyHC100FlexiAndHC200FlexiServiceEmailAccountOverview(){
		    Report.createTestLogHeader("Account Verification for paperless Billing","verify Account overview page for HC100Flexi and HC200Flexi Account at different supply address");
		    UserProfile userProfile = new TestDataHelper().getUserProfile("HC100FlexiAndHC200FlexiAccount");
		    new LoginAction()
		        .loginUserDetails(userProfile)
		        .accountOverviewLogInUserValidation(userProfile)
		        .logout();
		    } 
		    @Test(groups = {AccountOverview,Refactoring})
		    //Mandatory Fields in Userprofile.xml :
	        public void verifyHC100FlexiAndHC300FlexiServiceEmailAccountOverview(){
		    Report.createTestLogHeader("Account Verification for paperless Billing","verify Account overview page for HC100Flexi and HC300Flexi Account at different supply address");
		    UserProfile userProfile = new TestDataHelper().getUserProfile("HC100FlexiAndHC300FlexiAccount");
		    new LoginAction()
		        .loginUserDetails(userProfile)
		        .accountOverviewLogInUserValidation(userProfile)
		        .logout();
		    } 
		    @Test(groups = {AccountOverview,Refactoring})
		    //Mandatory Fields in Userprofile.xml :
	        public void verifyHC100FlexiAndHC400FlexiServiceEmailAccountOverview(){
		    Report.createTestLogHeader("Account Verification for paperless Billing","verify Account overview page for HC100Flexi and HC400Flexi Account at different supply address");
		    UserProfile userProfile = new TestDataHelper().getUserProfile("HC100FlexiAndHC400FlexiAccount");
		    new LoginAction()
		        .loginUserDetails(userProfile)
		        .accountOverviewLogInUserValidation(userProfile)
		        .logout();
		    } 
		    
		    @Test(groups = {AccountOverview,Refactoring})
		    //Mandatory Fields in Userprofile.xml :
	        public void verifyHC100FlexiServiceEmailAccountOverview(){
		    Report.createTestLogHeader("Account Verification for paperless Billing","verify Account overview page for HomeCare100 Flexi Account");
		    UserProfile userProfile = new TestDataHelper().getUserProfile("HC100FlexiAccount");
		    new LoginAction()
		        .loginUserDetails(userProfile)
		        .accountOverviewLogInUserValidation(userProfile)
		        .logout();       
		    } 
		    
		    @Test(groups = {AccountOverview,Refactoring})
		    //Mandatory Fields in Userprofile.xml :
	        public void verifyHC200FlexiServiceEmailAccountOverview(){
		    Report.createTestLogHeader("Account Verification for paperless Billing","verify Account overview page for HomeCare200 Flexi Account");
		    UserProfile userProfile = new TestDataHelper().getUserProfile("HC200FlexiAccount");
		    new LoginAction()
		        .loginUserDetails(userProfile)
		        .accountOverviewLogInUserValidation(userProfile)
		        .logout();
		    } 
		    
		    @Test(groups = {AccountOverview,Refactoring})
		    //Mandatory Fields in Userprofile.xml :
	        public void verifyHC300FlexiServiceEmailAccountOverview(){
		    Report.createTestLogHeader("Account Verification for paperless Billing","verify Account overview page for HomeCare300 Flexi Account");
		    UserProfile userProfile = new TestDataHelper().getUserProfile("HC300FlexiAccount");
		    new LoginAction()
		        .loginUserDetails(userProfile)
		        .accountOverviewLogInUserValidation(userProfile)
		        .logout();
		    } 
		    
		    @Test(groups = {AccountOverview,Refactoring})
		    //Mandatory Fields in Userprofile.xml :
	        public void verifyHC400FlexiServiceEmailAccountOverview(){
		    Report.createTestLogHeader("Account Verification for paperless Billing","verify Account overview page for HomeCare400 Flexi Account");
		    UserProfile userProfile = new TestDataHelper().getUserProfile("HC400FlexiAccount");
		    new LoginAction()
		        .loginUserDetails(userProfile)
		        .accountOverviewLogInUserValidation(userProfile)
		        .logout();
		    } 
		    @Test(groups = {AccountOverview,Refactoring})
		    //Mandatory Fields in Userprofile.xml :
	        public void verifyHC100ServiceEmailAccountOverview(){
		    Report.createTestLogHeader("Account Verification for paperless Billing","verify Account overview page for HomeCare100 Account");
		    UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare100Account");
		    new LoginAction()
		        .loginUserDetails(userProfile)
		        .accountOverviewLogInUserValidation(userProfile)
		        .logout();
		    } 
		    
		    @Test(groups = {AccountOverview,Refactoring})
		    //Mandatory Fields in Userprofile.xml :
	        public void verifyHC200ServiceEmailAccountOverview(){
		    Report.createTestLogHeader("Account Verification for paperless Billing","verify Account overview page for HomeCare200 Account");
		    UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare200Account");
		    new LoginAction()
		        .loginUserDetails(userProfile)
		        .accountOverviewLogInUserValidation(userProfile)
		        .logout();
		    } 
		    
		    @Test(groups = {AccountOverview,Refactoring})
		    //Mandatory Fields in Userprofile.xml :
	        public void verifyHC300ServiceEmailAccountOverview(){
		    Report.createTestLogHeader("Account Verification for paperless Billing","verify Account overview page for HomeCare300 Account");
		    UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare300Account");
		    new LoginAction()
		        .loginUserDetails(userProfile)
		        .accountOverviewLogInUserValidation(userProfile)
		        .logout();
		    } 
		    
		    @Test(groups = {AccountOverview,Refactoring})
		    //Mandatory Fields in Userprofile.xml :
	        public void verifyHC400ServiceEmailAccountOverview(){
		    Report.createTestLogHeader("Account Verification for paperless Billing","verify Account overview page for HomeCare400 Account");
		    UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare400Account");
		    new LoginAction()
		        .loginUserDetails(userProfile)
		        .accountOverviewLogInUserValidation(userProfile)
		        .logout();
		    } 
		    
		    @Test(groups = {AccountOverview,Refactoring})
		    //Mandatory Fields in Userprofile.xml :
	        public void verifyServicesAndEnergyServiceEmailAccountOverview(){
		    Report.createTestLogHeader("Account Verification for paperless Billing","verify Account overview page for Services And Energy Account");
		    UserProfile userProfile = new TestDataHelper().getUserProfile("ServicesAndEnergyAccount");
		    new LoginAction()
		        .loginUserDetails(userProfile)
		        .accountOverviewLogInUserValidation(userProfile)
		        .logout();
		    } 
		    
		    @Test(groups = {AccountOverview,Refactoring})
		    //Mandatory Fields in Userprofile.xml :
	        public void verifyEnergyServiceEmailAccountOverview(){
		    Report.createTestLogHeader("Account Verification for paperless Billing","verify Account overview page for Energy Account");
		    UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		    new LoginAction()
		        .loginUserDetails(userProfile)
		        .accountOverviewLogInUserValidation(userProfile)
		        .logout();
		    } 
		    
		//////// End of Services Emails Scenarios  ///////////////////       

}
