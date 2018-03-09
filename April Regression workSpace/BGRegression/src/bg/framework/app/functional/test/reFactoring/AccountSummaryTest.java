package bg.framework.app.functional.test.reFactoring;


import static bg.framework.app.functional.entities.FunctionalCategory.AccountSummary;
import static bg.framework.app.functional.entities.FunctionalCategory.Qtp;
import static bg.framework.app.functional.entities.FunctionalCategory.Refactoring;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import static bg.framework.app.functional.entities.FunctionalCategory.*;

public class AccountSummaryTest extends TestBase{
	
		/*	Mandatory Fields in Userprofile.xml : UCRN,Account Number	
		 *  Dual customer with payment card.	 
		 */
	  	@Test(groups = {AccountSummary,Refactoring,Qtp})	    
	    public void accountSummaryDual() {
	        Report.createTestLogHeader("Account Summary Journey of Dual customer", "Verify account summary page of dual customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
	          //  getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction()
                .navigateToLogin()
                //.loginDetails(userProfile)
                //.navigateToLoginPage()	            
	            .loginUserDetails(userProfile)
            
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getGasAccount())
	                .navigateToAccountSummaryPage()
	                .verifyAccountSummaryPageAction(userProfile.getAccNumber())
	                .navigateToAccountOverview()
	                .verifyAddress(userProfile.getElecAccount())
	                .setAccountNumber(userProfile.getElecAccount(),userProfile)
	                .navigateToAccountSummaryPage()
	                .verifyAccountSummaryPageAction(userProfile.getAccNumber()).logout();
	    }
	  
	  	/*	Mandatory Fields in Userprofile.xml : UCRN,Account Number	
		 *  Dual fuel customer with payment card.	 
		 */
	  	@Test(groups = {/*AccountSummary,Refactoring,Qtp,*/OAMRegression})	    
	    public void accountSummaryDualFuel() {
	        Report.createTestLogHeader("Account Summary Journey of DualFuel customer", "Verify account summary page of dual fuel customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
	            //getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction()
                .navigateToLogin()
                //.loginDetails(userProfile)
                //.navigateToLoginPage()	        
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	            	.verifyAddress(userProfile.getGasAccount())
	                .navigateToAccountSummaryPage()
	                .verifyAccountSummaryPageAction(userProfile.getAccNumber())
	                .navigateToAccountOverview()
	                .verifyAddress(userProfile.getElecAccount())
	                .setAccountNumber(userProfile.getElecAccount(),userProfile)
	                .navigateToAccountSummaryPage()
	                .verifyAccountSummaryPageAction(userProfile.getAccNumber()).logout();
	    }
	  	
	  	/*	Mandatory Fields in Userprofile.xml : UCRN,Account Number	
		 *  Gas customer with monthly fixed.	 
		 */
	  	
	  	@Test(groups = {AccountSummary,Refactoring})	    
	    public void accountSummaryGasMonthlyFixed() {
	        Report.createTestLogHeader("Account Summary Journey of Gas customer", "Verify account summary page of gas customer with monthly fixed");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	                .verifyAccountSummaryPageAction(userProfile.getAccNumber()).logout();            
	    }
	  	
	 	/*	Mandatory Fields in Userprofile.xml : UCRN,Account Number	
		 *  Gas customer with Fixed DD Credit.	 
		 */
	  	@Test(groups = {AccountSummary,Refactoring})	    
	    public void accountSummaryGasFixedDDCredit() {
	        Report.createTestLogHeader("Account Summary Journey of Gas customer", "Verify account summary page of gas customer with Fixed DD Credit");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	                .verifyAccountSummaryPageAction(userProfile.getAccNumber()).logout();            
	    }
	 	/*	Mandatory Fields in Userprofile.xml : UCRN,Account Number	
		 *  Gas customer with variable DD credit 
		 */
	 	@Test(groups = {AccountSummary,Refactoring})	    
	    public void accountSummaryGasVariableDDCredit() {
	        Report.createTestLogHeader("Account Summary Journey of Gas customer", "Verify account summary page of gas customer with variable DD credit");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	                .verifyAccountSummaryPageAction(userProfile.getAccNumber()).logout();            
	    }
	 	/*	Mandatory Fields in Userprofile.xml : UCRN,Account Number	
		 *  Gas customer with Single rate	 
		 */
	 	@Test(groups = {AccountSummary,Refactoring})	    
	    public void accountSummaryGasSingleRate() {
	        Report.createTestLogHeader("Account Summary Journey of Gas customer", "Verify account summary page of gas customer with Single rate");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	                .verifyAccountSummaryPageAction(userProfile.getAccNumber())
	                .logout();            
	    }
	 	/*	Mandatory Fields in Userprofile.xml : UCRN,Account Number	
		 *  Gas customer with monthly single rate smart meter.	 
		 */
	 	@Test(groups = {AccountSummary})	    
	    public void accountSummaryGasSingleRateSmartMeter() {
	        Report.createTestLogHeader("Account Summary Journey of Gas customer", "Verify account summary page of gas customer with single rate smart meter");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	                .verifyAccountSummaryPageAction(userProfile.getAccNumber())
	                .logout();            
	    }
	  	
	 	/*	Mandatory Fields in Userprofile.xml : UCRN,Account Number	
		 *  Electricity customer with Fixed DD and balance debit.	 
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void accountSummaryElectricityFixedDD() {
	        Report.createTestLogHeader("Account Summary Journey of Electricity customer", "Verify account summary page of Electricity customer with Fixed DD and balance debit");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	                .verifyAccountSummaryPageAction(userProfile.getAccNumber()).logout();              
	    }
		/*	Mandatory Fields in Userprofile.xml : UCRN,Account Number	
		 *  Electricity customer with TOU Tariff 
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void accountSummaryElectricityFixedDDTOU() {
	        Report.createTestLogHeader("Account Summary Journey of Electricity customer", "Verify account summary page of Electricity customer with Fixed DD and balance debit");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            //getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	            	.verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	                .verifyAccountSummaryPageTOU(userProfile.getAccNumber()).logout();
	    }
	  	
		/*	Mandatory Fields in Userprofile.xml : UCRN,Account Number	
		 *  Electricity customer with Fixed payment and balance debit.	 
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void accountSummaryElectricityFixedPayment() {
	        Report.createTestLogHeader("Account Summary Journey of Electricity customer", "Verify account summary page of Electricity customer with Fixed payment and balance debit");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	                .verifyAccountSummaryPageAction(userProfile.getAccNumber()).logout();              
	    }
		
		/*	Mandatory Fields in Userprofile.xml : UCRN,Account Number	
		 *  Electricity customer with Single rate non energy.	 
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void accountSummaryElectricitySingleRate() {
	        Report.createTestLogHeader("Account Summary Journey of Electricity customer", "Verify account summary page of Electricity customer with Single rate non energy");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccountInactive");
	       //     getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	                .verifyAccountSummaryPageAction(userProfile.getAccNumber()).logout();              
	    }
		
		/*	Mandatory Fields in Userprofile.xml : UCRN,Account Number	
		 *  Electricity customer with dual rate non energy.	 
		 */
		@Test(groups = {/*AccountSummary,Refactoring,*/OAMRegression})	    
	    public void accountSummaryElectricityDualRate() {
	        Report.createTestLogHeader("Account Summary Journey of Electricity customer", "Verify account summary page of Electricity customer with dual rate non energy");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	     //       getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	                .verifyAccountSummaryPageAction(userProfile.getAccNumber()).logout();              
	    }
		
		/*	Mandatory Fields in Userprofile.xml : UCRN,Account Number	
		 *  Electricity customer with dual rate energy.	 
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void accountSummaryElectricityDualRateEnergy() {
	        Report.createTestLogHeader("Account Summary Journey of Electricity customer", "Verify account summary page of Electricity customer with dual rate energy");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	                .verifyAccountSummaryPageAction(userProfile.getAccNumber()).logout();              
	    }
	 	
		/*	Mandatory Fields in Userprofile.xml : UCRN,Account Number	
		 *  JI customer with dual monthly payment.	 
		 */
	  	@Test(groups = {AccountSummary,Refactoring})	    
	    public void accountSummaryJIMonthlyPayment() {
	        Report.createTestLogHeader("Account Summary Journey of JI customer", "Verify account summary page of JI customer with dual monthly payment");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	                .verifyAccountSummaryPageAction(userProfile.getAccNumber()).logout();           
	    }
	  
	  	/*	Mandatory Fields in Userprofile.xml : UCRN,Account Number	
		 *  JI customer with smart meter read.	 
		 */
	  	@Test(groups = {AccountSummary,Refactoring})	    
	    public void accountSummaryJISmartMeterRead() {
	        Report.createTestLogHeader("Account Summary Journey of JI customer", "Verify account summary page of JI customer with smart meter read");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	                .verifyAccountSummaryPageAction(userProfile.getAccNumber()).logout();           
	    }
	  	
	  	/*	Mandatory Fields in Userprofile.xml : UCRN,Account Number	
		 *  JI customer with standing order.	 
		 */
	  	@Test(groups = {AccountSummary,Refactoring})	    
	    public void accountSummaryJIStandingOrder() {
	        Report.createTestLogHeader("Account Summary Journey of JI customer", "Verify account summary page of JI customer with standing order");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	                .verifyAccountSummaryPageAction(userProfile.getAccNumber()).logout();           
	    }
	  	
	  	/*	Mandatory Fields in Userprofile.xml : UCRN,Account Number	
		 *  JI customer with payment type credit card	 
		 */
	  	@Test(groups = {AccountSummary,Refactoring})	    
	    public void accountSummaryJICreditCard() {
	        Report.createTestLogHeader("Account Summary Journey of JI customer", "Verify account summary page of JI customer with payment type credit card");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	                .verifyAccountSummaryPageAction(userProfile.getAccNumber()).logout();           
	    }
	  	
	  	/*	Mandatory Fields in Userprofile.xml : UCRN,Account Number	
		 *  JI customer with single rate customer.	 
		 */
	  	@Test(groups = {/*AccountSummary,Refactoring,*/OAMRegression})	    
	    public void accountSummaryJISingleRate() {
	        Report.createTestLogHeader("Account Summary Journey of JI customer", "Verify account summary page of JI customer with single rate");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
	      //      getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	                .verifyAccountSummaryPageAction(userProfile.getAccNumber()).logout();           
	    }
	  	
	  	/*	Mandatory Fields in Userprofile.xml : UCRN,Account Number	
		 *  JI customer with dual rate.	 
		 */
	  	@Test(groups = {AccountSummary,Refactoring})	    
	    public void accountSummaryJIDualRate() {
	        Report.createTestLogHeader("Account Summary Journey of JI customer", "Verify account summary page of JI customer with dual rate");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	                .verifyAccountSummaryPageAction(userProfile.getAccNumber()).logout();           
	    }
	  	
	  	/*	Mandatory Fields in Userprofile.xml : UCRN,Account Number	
		 *  JI customer with dual rate energy.	 
		 */
	  	@Test(groups = {AccountSummary,Refactoring})	    
	    public void accountSummaryJIDualRateEnergy() {
	        Report.createTestLogHeader("Account Summary Journey of JI customer", "Verify account summary page of JI customer with dual rate energy");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	                .verifyAccountSummaryPageAction(userProfile.getAccNumber()).logout();           
	    }
	  	
	  	/*	Mandatory Fields in Userprofile.xml : UCRN, BGSAccount	
		 *  	 SSO account
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void accountSummarySSO() {
	        Report.createTestLogHeader("Account Summary Journey of SSO customer", "Verify account summary page of SSO customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("SSOAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()	            		                	
	                .setAccountNumber(userProfile.getBgsAccount(),userProfile)
	                .navigateToAccountSummaryPage()	                
	                .verifiyAccountSummaryForSSOandWTPAction().logout();              
	    }
		
		/*	Mandatory Fields in Userprofile.xml : UCRN, BGSAccount	
		 *   WTP account
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void accountSummaryWTP() {
	        Report.createTestLogHeader("Account Summary Journey of WTP customer", "Verify account summary page of WTP customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("WTPAccount");
	            //getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction()
	            	.navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()	
	            	.setAccountNumber(userProfile.getBgsAccount(),userProfile)
	                .navigateToAccountSummaryPage()
	                .verifiyAccountSummaryForSSOandWTPAction().logout();             
	    }
		
		/*	Mandatory Fields in Userprofile.xml : UCRN, BGSAccount	
		 *   BGS account
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void accountSummaryBGS() {
	        Report.createTestLogHeader("Account Summary Journey of BGS customer", "Verify account summary page of BGS customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");
	            //getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber()).logout();             
	    }
		
		/*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   Dual fuel BGS account
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void accountSummaryDualFuelBGS() {
	        Report.createTestLogHeader("Account Summary Journey of Dual fuel BGS customer", "Verify account summary page of Dual fuel BGS customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	                .verifyAccountSummaryPageAction(userProfile.getAccNumber()).logout();             
	    }
		
		/*	Mandatory Fields in Userprofile.xml : UCRN, BGSAccount	
		 *  JI customer with dual rate energy.	 
		 */
	    @Test(groups = {AccountSummary,Refactoring})	  
	    public void accountsummaryBGSNotDue() {
	        Report.createTestLogHeader("Account Summary Journey of BGS", "Verify annual service of BGS customer ASV is not due");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServciesAccount");
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .verifyAccountOverviewAction()
	                .navigateToAccountSummaryPage()
	                .serviceNotDueAction().logout();	              
	    }
	    
	    /*	Mandatory Fields in Userprofile.xml : UCRN, BGSAccount	
		 *  JI customer with dual rate energy.	 
		 */
	    @Test(groups = {AccountSummary,Refactoring})	    
	    public void accountSummaryBGSIsDue() {
	        Report.createTestLogHeader("Account Summary Journey of BGS", "Verify annual service of BGS customer ASV is due");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccountIB");
	            new LoginAction()
	            	.loginUserDetails(userProfile)
	                .verifyAccountOverviewAction()
	                .navigateToAccountSummaryPage()
	                .serviceDueAction().logout();	              
	    }
	    
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   BGS customer with ASV due & engineer booked.
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellASVDueandBookEng() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of Dual fuel BGS customer", "Verify account summary page of BGS customer with ASV due and Engineer booked");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServciesAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   Electricity account
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellElectricity() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of electricity customer", "Verify account summary page of electricity customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   Gas account
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellGas() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of gascustomer", "Verify account summary page of gas customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   JI account
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellJI() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of JI customer", "Verify account summary page of JI customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   SSO electricity account
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellSSOElectricity() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of SSO electricity", "Verify account summary page of SSO electricity customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("SSOAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   SSO gas account
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellSSOGas() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of SSO gas customer", "Verify account summary page of SSO gas customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   WTP electricity account
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellWTPElectricity() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of WTP electricity customer", "Verify account summary page of WTP electricity customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   WTP gas account
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellWTPGas() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of WTP gas customer", "Verify account summary page of WTP gas customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   dual fuel HC100 account
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellDualFuelHC100() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of  dual fuel HC100 customer", "Verify account summary page of  dual fuel HC100 customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   dual fuel HC200 account
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellDualFuelHC200() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of dual fuel HC200 customer", "Verify account summary page of dual fuel HC200customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   dual fuel HC300 account
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellDualFuelHC300() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of dual fuel HC300 customer", "Verify account summary page of dual fuel HC300 customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   dual fuel HC400 account
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellDualFuelHC400() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of dual fuel HC400 customer", "Verify account summary page ofdual fuel HC400 customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   Gas + WTP(Electricity) account
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellGasPlusWTPElectricty() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of Gas + WTP(Electricity) customer", "Verify account summary page of Gas + WTP(Electricity) customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   Gas + SSO(Electricity) account
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellGasPlusSSOElectricty() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of Gas + WTP(Electricity) customer", "Verify account summary page of Gas + WTP(Electricity) customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 * Gas + HC100 account  
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellGasHC100() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of Gas + HC100 customer", "Verify account summary page of Gas + HC100 customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   Gas + HC200 account
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellGasHC200() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of Gas + HC200 customer", "Verify account summary page of Dual Gas + HC200 customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   Gas + HC300 account
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellGasHC300() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of Gas + HC300 customer", "Verify account summary page of Gas + HC300 customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   Electricity + HC100 account
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellElectricityHC100() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of Electricity + HC100 customer", "Verify account summary page of Electricity + HC100 customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   Electricity + HC200 account
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellElectricityHC200() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of Electricity + HC200 customer", "Verify account summary page of Electricity + HC200 customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   Electricity + HC300 account
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellElectricityHC300() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of Electricity + HC300 customer", "Verify account summary page of Electricity + HC300 customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   Electricity + WTP(Gas) account 
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellElectricityPlusWTPElectricty() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of Electricity + WTP(Gas) account  customer", "Verify account summary page of Electricity + WTP(Gas) account customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellADualFuel() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of Dual fuel BGS customer", "Verify account summary page of Dual fuel BGS customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   Dual and Service account
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellDualService() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of Dual and Service account customer", "Verify account summary page of Dual and Service customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   Home care 100 account
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellHomeCare100() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of Home care 100 customer", "Verify account summary page of Home care 100 customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   Home care 200 account
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellHomeCare200() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of Home care 200 customer", "Verify account summary page of Home care 200 customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   Home care 300 account
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellHomeCare300() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of Home care 300 customer", "Verify account summary page of Home care 300 customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   Home care 400 account
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellHomeCare400() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of Home care 400 customer", "Verify account summary page of Home care 400 customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   JI and Home care 100
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellJIHomeCare100() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of JI and Home care 100 customer", "Verify account summary page of JI and Home care 100 customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   JI and Home care 200
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellJIHomeCare200() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of JI and Home care 200 customer", "Verify account summary page of JI and Home care 200 customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   JI and Home care 300
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellJIHomeCare300() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of JI and Home care 300 customer", "Verify account summary page of JI and Home care 300 customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}
		
		 
	    /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   JI and Home care 400
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void crossCellJIHomeCare400() {
	        Report.createTestLogHeader("Account Summary cross cell Journey of JI and Home care 400 customer", "Verify account summary page of JI and Home care 400 customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	               .verifyAccountSummaryCrossCellAction().logout();
		}			
		
		 /*	Mandatory Fields in Userprofile.xml : UCRN, Account	number
		 *   Verifying the links in account summary page
		 */
		@Test(groups = {AccountSummary,Refactoring})	    
	    public void linkVerification() {
	        Report.createTestLogHeader("Account Summary link verification", "Verify account summary page of JI and Home care 400 customer");
	            UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
	            getCustomerDetailsToUserProfileOAM(userProfile);
	            new HomePageAction().navigateToLoginPage()	            
	            	.loginUserDetails(userProfile)
	            	.verifyAccountOverviewAction()
	                .verifyAddress(userProfile.getAccNumber())
	                .navigateToAccountSummaryPage()
	                .verifyingLinks()
	                .logout();
		}	
		
}
