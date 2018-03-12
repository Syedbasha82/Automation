package bg.framework.app.functional.test.selfServe;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.selfServe.DdcpsAction;
import bg.framework.app.functional.entities.Ddcps;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import bg.framework.app.functional.test.common.TestBase;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import static bg.framework.app.functional.entities.FunctionalCategory.Ddcps;
import static bg.framework.app.functional.entities.FunctionalCategory.InProgress;
public class DdcpsTest extends TestBase{
	/*
	 * ******************************************************************************
	         						DDCPS SETUP
	         					Quarterly Customer.
	    *******************************************************************************/
	/*
     *  Mandatory field in UserProfile: UCRN and Account Number
     *  
     *  RobotKeys are used in the scripts please avoid multi tasking.
     */
	@Test(groups={Regression,Ddcps})
	
	public void ddcpsSetupForGas(){
		Report.createTestLogHeader("DDCPS for Gas", "GasAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.switchToDD(ddcps)
			.selectAccountsForSwitchingToDD(userProfile,"Gas")
			.meterReadOverlay("Gas")
			.enterPaymentDateForQuarterlyCustomer()
			.paymentAmountAndCreditRefund()
			.setUpDDMakeAPayment()
			.enterBankDetailsForQuarterlyCustomer()
			.reviewAndConfirmDDSetUp()
			.logOutLink();
	}
	/*
     *  Mandatory field in UserProfile: UCRN and Account Number
     *  RobotKeys are used in the scripts please avoid multi tasking.
     *  Mention as ElecDual in meterReadoverlay if the electricity has dual rate meter read
     */
	
	@Test(groups={Regression,Ddcps})
	
	public void ddcpsSetupForElectricity(){
		Report.createTestLogHeader("DDCPS for Electricity", "ElectricityAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("ElectricityAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.switchToDD(ddcps)
			.selectAccountsForSwitchingToDD(userProfile,"Electricity")
			.meterReadOverlay("Electricity")
			.enterPaymentDateForQuarterlyCustomer()
			.paymentAmountAndCreditRefund()
			.setUpDDMakeAPayment()
			.enterBankDetailsForQuarterlyCustomer()
			.reviewAndConfirmDDSetUp()
			.logOutLink();
	}
	/*
     *  Mandatory field in UserProfile: UCRN and Account Number
     *  
     *  RobotKeys are used in the scripts please avoid multi tasking.
     */
	@Test(groups={Regression,Ddcps})
	
	public void ddcpsSetupForJI(){
		Report.createTestLogHeader("DDCPS Setup for JI", "JIAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("JIAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.switchToDD(ddcps)
			.selectAccountsForSwitchingToDD(userProfile,"Energy")
			.meterReadOverlay("JI")
			.enterPaymentDateForQuarterlyCustomer()
			.paymentAmountAndCreditRefund()
			.setUpDDMakeAPayment()
			.enterBankDetailsForQuarterlyCustomer()
			.reviewAndConfirmDDSetUp()
			.logOutLink();
	}
	/*
     *  Mandatory field in UserProfile: UCRN and Account Number
     *  
     *  RobotKeys are used in the scripts please avoid multi tasking.
     */
	@Test(groups={Regression,Ddcps})
	
	public void ddcpsSetupForDual(){
		Report.createTestLogHeader("DDCPS for Dual", "DualAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("DualAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.switchToDD(ddcps)
			.selectAccountsForSwitchingToDD(userProfile,"Dual")
			.meterReadOverlay("Dual")
			.enterPaymentDateForQuarterlyCustomer()
			.paymentAmountAndCreditRefund()
			.enterBankDetailsForQuarterlyCustomer()
			.reviewAndConfirmDDSetUp()
			.logOutLink();
	}

	/*
     *  Mandatory field in UserProfile: UCRN and Account Number
     *  
     *  RobotKeys are used in the scripts please avoid multi tasking.
     */
	
	@Test(groups={Regression,Ddcps})
	
	public void ddcpsSetupForGasInDebit(){
		Report.createTestLogHeader("DDCPS for Gas In Debit", "GasAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.switchToDD(ddcps)
			.selectAccountsForSwitchingToDD(userProfile,"Gas")
			.meterReadOverlay("Gas")
			.enterPaymentDateForQuarterlyCustomer()
			.reviewAndConfirmDDSetUp()
			.logOutLink();
	}  

	//---------------------------------------------MonthlyCustomer(EsmartCustomer)----------------------------------------
	/*
     *  Mandatory field in UserProfile: UCRN and Account Number
     *  
     *  RobotKeys are used in the scripts please avoid multi tasking.
     */
	@Test(groups={Regression,Ddcps})
	
	public void ddcpsSetupForGasMonthlyCustomer(){
		Report.createTestLogHeader("DDCPS for Gas", "GasAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.switchToDD(ddcps)						
			.enterReadingMonthlyCustomer("Gas")
			.confirmationOverlay()
			.navigateToBankDetailsPayBalanceLater()
			.enterBankDetailsForMonthlyCustomer()
			.confirmDetailsAndPrivacyPolicy()
			.navigateToYourAccount()
			.logoutAction();

	}
	/*
     *  Mandatory field in UserProfile: UCRN and Account Number
     *  
     *  RobotKeys are used in the scripts please avoid multi tasking.
     */
	@Test(groups={Regression,Ddcps})
	public void ddcpsSetupForElectricityMonthlyCustomer(){
		Report.createTestLogHeader("DDCPS for Electricity", "ElectricityAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("ElectricityAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.switchToDD(ddcps)						
			.enterReadingMonthlyCustomer("Electricity")
			.confirmationOverlay()
			.navigateToBankDetailsPayBalanceLater()
			.enterBankDetailsForMonthlyCustomer()
			.confirmDetailsAndPrivacyPolicy()
			.navigateToYourAccount()
			.logoutAction();

	}
	/*
     *  Mandatory field in UserProfile: UCRN and Account Number
     *  
     *  RobotKeys are used in the scripts please avoid multi tasking.
     */
	@Test(groups={Ddcps})
	public void ddcpsSetupForJIMonthlyCustomer(){
		Report.createTestLogHeader("DDCPS Setup for JI Monthly Customer", "JIAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("JIAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.switchToDD(ddcps)						
			.enterReadingMonthlyCustomer("JI")
			.confirmationOverlay()
			.navigateToBankDetailsPayBalanceLater()
			.enterBankDetailsForMonthlyCustomer()
			.confirmDetailsAndPrivacyPolicy()
			.navigateToYourAccount()
			.logoutAction();
		
	}
	/*
     *  Mandatory field in UserProfile: UCRN and Account Number
     *  
     *  RobotKeys are used in the scripts please avoid multi tasking.
     */
	@Test(groups={Ddcps,Regression})
	public void ddcpsSetupForDualMonthlyCustomer(){
		Report.createTestLogHeader("DDCPS Setup for Dual Monthly Customer", "DualAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("DualAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.switchToDD(ddcps)						
			.enterReadingMonthlyCustomer("Gas")
			.confirmationOverlay()
			.navigateToBankDetailsPayBalanceLater()
			.enterBankDetailsForMonthlyCustomer()
			.confirmDetailsAndPrivacyPolicy()
			.navigateToYourAccount()
			.logoutAction();

	}
	/*
	 * ******************************************************************************
	         						 DDCPS DASHBOARD
	         							Fixed DD
	    *******************************************************************************/
	/*
     *  Mandatory field in UserProfile: UCRN and Account Number
     *  
     *  RobotKeys are used in the scripts please avoid multi tasking.
     */
	@Test(groups={Ddcps,Regression})
	public void ddcpsDashBoardForGas(){
		Report.createTestLogHeader("DDCPS DashBoardfor Gas Customer", "GasAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		//getCustomerDetailsToUserProfileOAM(userProfile);
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps)
			.detailedPlanBreakDown()
			.adjustMonthlyPayment()
			.makeAPaymentManageDD()
			.manageDDCreditRefund()
			.manageDDUpdatebankDetails()
			.logOut();
		
	}
	/*
     *  Mandatory field in UserProfile: UCRN and Account Number
     *  
     *  RobotKeys are used in the scripts please avoid multi tasking.
     */
	@Test(groups={Ddcps,Regression})
	public void ddcpsDashBoardForElectricity(){
		Report.createTestLogHeader("DDCPS DashBoardfor Electricity Customer", "ElectricityAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("ElectricityAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps)
			.detailedPlanBreakDown()
			.adjustMonthlyPayment()
			.makeAPaymentManageDD()
			.manageDDCreditRefund()
			.manageDDUpdatebankDetails()
			.logOut();
		
	}
	/*
     *  Mandatory field in UserProfile: UCRN and Account Number
     *  
     *  RobotKeys are used in the scripts please avoid multi tasking.
     */
	@Test(groups={Ddcps,Regression})
	public void ddcpsDashBoardForDual(){
		Report.createTestLogHeader("DDCPS DashBoardfor Dual Customer", "DualAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("DualAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps)
			.detailedPlanBreakDown()
			.adjustMonthlyPayment()
			.makeAPaymentManageDD()
			.manageDDCreditRefund()
			.manageDDUpdatebankDetails()
			.logOut();
		
	}
	/*
     *  Mandatory field in UserProfile: UCRN and Account Number
     *  
     *  RobotKeys are used in the scripts please avoid multi tasking.
     */
	@Test(groups={Ddcps,Regression})
	public void ddcpsDashBoardForJI(){
		Report.createTestLogHeader("DDCPS DashBoardfor JI Customer", "JIAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("JIAccount");
		//getCustomerDetailsToUserProfileOAM(userProfile);
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps)
			.detailedPlanBreakDown()
			.adjustMonthlyPayment()
			.makeAPaymentManageDD()
			.manageDDCreditRefund()
			.manageDDUpdatebankDetails()
			.logOut();
		
	}
			//----------------------------------------Submit Meter Reading--------------------------
	/*
     *  Mandatory field in UserProfile: UCRN and Account Number
     *  
     */
	@Test(groups={Regression,  Ddcps})
	public void ddcpsSumitMeterReadingForGas(){
		Report.createTestLogHeader("DDCPS DashBoard Submit Meter Reading", "GasAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps)
			.submitMeterReadInManageDD()
			.logOut();
		
	}
			//----------------------------------------Verify Next Installment-----------------------------------
	/*
     *  Mandatory field in UserProfile: UCRN and Account Number
     *  
     */
	@Test(groups={Regression,Ddcps})
	public void ddcpsVerifyNextInstallmentForGas(){
		Report.createTestLogHeader("DDCPS DashBoard Verify Next Installment", "GasAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps)
			.nextInstallmentDetailsVerification()
			.logOut();
	}
	
	
	/*
     *  Mandatory field in UserProfile: UCRN and Account Number
     *  
     */
	@Test(groups={Regression,Ddcps})
	public void ddcpsVerifyNextInstallmentForElectricity(){
		Report.createTestLogHeader("DDCPS DashBoard Verify Next Installment", "GasAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("ElectricityAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps)
			.nextInstallmentDetailsVerification()
			.logOut();
	}
	/*
     *  Mandatory field in UserProfile: UCRN and Account Number
     *  
     */
	@Test(groups={Regression,Ddcps})
	public void ddcpsVerifyNextInstallmentForJI(){
		Report.createTestLogHeader("DDCPS DashBoard Verify Next Installment", "GasAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("JIAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps)
			.nextInstallmentDetailsVerification()
			.logOut();
	}
	
		//----------------------------------------Flexi customer-------------------------------------------
	/*
     *  Mandatory field in UserProfile: UCRN and Account Number
     *  
     *  RobotKeys are used in the scripts please avoid multi tasking.
     */
	@Test(groups={Regression,Ddcps})
	public void ddcpsFlexiForGas(){
		Report.createTestLogHeader("DDCPS DashBoard for Flexible payment Plan", "GasAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps)
			.manageDDFlexiPaymentPlan()
			.logOut();
	}
	
	
	/*
     *  Mandatory field in UserProfile: UCRN and Account Number
     *  
     *  RobotKeys are used in the scripts please avoid multi tasking.
     */
	@Test(groups={Regression,Ddcps})
	public void ddcpsFlexiForElectricity(){
		Report.createTestLogHeader("DDCPS DashBoard for Flexible payment Plan", "ElectricityAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("ElectricityAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps)
			.manageDDFlexiPaymentPlan()
			.logOut();
	}
}
