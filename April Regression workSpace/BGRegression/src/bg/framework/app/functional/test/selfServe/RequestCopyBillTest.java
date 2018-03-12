package bg.framework.app.functional.test.selfServe;

import org.testng.annotations.Test;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.action.selfServe.RequestCopyBillAction;
import static bg.framework.app.functional.entities.FunctionalCategory.*;


public class RequestCopyBillTest extends TestBase {
	
	//Data : BG OAM Gas, Cash/cheque, Esmart clear and simple
	@Test(groups = {Acquisition})
	public void verifyGasRequestBill(){
		Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For Gas Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile);
		new RequestCopyBillAction()
			.navigatetoBillingHistory()
			.verifyViewBills()
			.requestBillCopy()
			.logout();
			
	}
	
	
	//Data : BG OAM Electricity, Direct Debit, Esmart Fixed Price
		@Test(groups = {Acquisition})
		public void verifyElecRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For Electricity Direct Debit Account");
			UserProfile userProfile = new TestDataHelper().getUserProfile("ElectiricityAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
	
		//Data : BG OAM JI, Direct Debit, Esmart Clear Simple
		@Test(groups = {Acquisition})
		public void verifyJIDirectDebitRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For JI Direct Debit Account");
			UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}	
				
		//Data : BG OAM JI, Cash/Cheque , Esmart Online variable Nov 2013
		@Test(groups = {Acquisition})
		public void verifyJICashchequeRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For JI cash/cheque Account");
			UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : BG OAM quarterly Dual fuel(Gas active with elec inactive > 6 months), Cash/Cheque , quarterly billing fixed price
		@Test(groups = {Acquisition})
		public void verifyquarterlyDualFuelRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For quarterly Dual Fuel Account");
			UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
	
		//Data : BG OAM Gas with Gas reassessment statement with actual meter read, Direct debit, quarterly billing 
		@Test(groups = {Acquisition})
		public void verifyOAMquarterlyGasReassessmentRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For quarterly Gas Reassessment Fuel Account");
			UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : BG OAM JI with estimated quarterly JI bill, Cash/cheque, quarterly billing Clear Simple
		@Test(groups = {Acquisition})
		public void verifyOAMJIEstimatedquarterlyRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For JI Estimated quarterly Fuel Account");
			UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : BG OAM JI with actual quarterly JI statement, Direct debit, Esmart Clear Simple
		@Test(groups = {Acquisition})
		public void verifyOAMJIActualquarterlyRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For JI Actual quarterly statement");
			UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : BG OAM quarterly Gas+EE50 account, Direct debit, Esmart Fixed Price
		@Test(groups = {Acquisition})
		public void verifyOAMquarterlyGasEE50RequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For quarterly Gas+EE50 Account");
			UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : BG OAM Final Electricity(Dual rate meter), Cash/Cheque, quarterly billing Discount variable August 2013
		@Test(groups = {Acquisition})
		public void verifyOAMFinalElectricityRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For Final Electricity Account");
			UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : BG OAM Dual account with Estimated Final Dual fuel bills, Cash/Cheque, quarterly billing with fixed price
		@Test(groups = {Acquisition})
		public void verifyOAMEstimatedFinalDualFuelRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For Estimated Final Dual fuel Account");
			UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : BG OAM Gas account with Actual final gas statement, Direct debit, quarterly billing with fixed price
		@Test(groups = {Acquisition})
		public void verifyOAMGasActualFinalRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For Gas Account with actual final statement");
			UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : BG OAM JI account with Estimated final JI statement, Direct debit, quarterly billing with Clear Simple
		@Test(groups = {Acquisition})
		public void verifyOAMJIEstimatedFinalRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For JI Account with Estimated final statement");
			UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : BG OAM Electricity account with Actual quarterly replacement bill, Cash/cheque, Quarterly billing with Clear Simple
		@Test(groups = {Acquisition})
		public void verifyOAMElecActualQuarterlyReplacementRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For Electricity Account with Actual quarterly replacement bill");
			UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : BG OAM Gas account with estimated quarterly gas replacement bill, Cash/cheque, Quarterly billing with fixed price
		@Test(groups = {Acquisition})
		public void verifyOAMGasEstimatedQuarterlyReplacementRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For Gas Account with Estimated quarterly replacement bill");
			UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : BG OAM Electricity Dual rate account with estimated quarterly electricity replacement statement, Direct Debit, Quarterly billing with clear simple
		@Test(groups = {Acquisition})
		public void verifyOAMElecEstimatedQuarterlyReplacementRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For Electricity Account with Estimated quarterly replacement statement");
			UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : BG OAM JI account with estimated quarterly JI replacement statement, Direct Debit, Quarterly billing with Fixed price
		@Test(groups = {Acquisition})
		public void verifyOAMJIEstimatedQuarterlyReplacementRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For JI Account with Estimated quarterly replacement statement");
			UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : BG OAM Gas account with Actual quarterly Gas bill, Cash/Cheque, Quarterly billing with Online variable
		@Test(groups = {Acquisition})
		public void verifyOAMGasActualQuarterlyRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For Gas Account with Actual quarterly Gas Bill");
			UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : BG OAM Gas account with Estimated Gas statement, Cash/Cheque, Quarterly billing with Online variable
		@Test(groups = {Acquisition})
		public void verifyOAMGasEstimatedRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For Gas Account with estimated Gas statement");
			UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : BG OAM Electricity dual rate account with Actual electricity annual bill, Cash/Cheque, Quarterly billing with Fixed price
		@Test(groups = {Acquisition})
		public void verifyOAMElecDualRateAnnualBillEstimatedRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For Electricity Account with actual annual electricity bill");
			UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : BG OAM Gas+EE50 account with Estimated annual statement, Direct Debit, Quarterly billing with Discount variable
		@Test(groups = {Acquisition})
		public void verifyOAMGasEE50EstimatedAnnualRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For Gas EE50 Account with Estimated annual statement");
			UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : BG OAM JI account with Estimated Reassessment statement, Direct Debit, Quarterly billing with Clear Simple
		@Test(groups = {Acquisition})
		public void verifyOAMJIEstimatedAnnualReassessmentRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For JI Account with Estimated Reassessment statement");
			UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : BG OAM JI account with Actual Quarterly JI Annual statement, Direct Debit, Quarterly billing with Fixed Price
		@Test(groups = {Acquisition})
		public void verifyOAMJIActualAnnualReassessmentRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For JI Account with Actual Annual  statement");
			UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : BG OAM Gas account with Quarterly Gas Annual Bill, Direct Debit, Quarterly billing
		@Test(groups = {Acquisition})
		public void verifyOAMGasAnnualBillRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For Gas Account with Quarterly gas Annual bill");
			UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : BG OAM Gas account, Quarterly billing
				@Test(groups = {Acquisition})
				public void verifyPaymentMessageRequestBill(){
					Report.createTestLogHeader("Request Copy Bill Test", "Verify Payment Message displayed in the Gas statement");
					UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
					new HomePageAction()
						.navigateToLogin()
						.login(userProfile)
						.navigateToAccountSummaryPage(userProfile);
					new RequestCopyBillAction()
						.navigatetoBillingHistory()
						.verifyViewBills()
						.requestBillCopy()
						.logout();

				}
				
		//Data : SE OAM JI account with estimated quarterly JI annual statement, Direct Debit, Quarterly billing
		@Test(groups = {Acquisition})
		public void verifySEquarterlyJIannualRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For JI Account with Estimated Quarterly JI Annual bill");
			UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : SE OAM Gas account with estimated quarterly Gas Final bill, cash/cheque, Quarterly billing
		@Test(groups = {Acquisition})
		public void verifySEGSasFinalRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For Gas Account with Estimated Quarterly Gas Final bill");
			UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : SE OAM JI account with actual quarterly JI Final bill, cash/cheque, Quarterly billing
		@Test(groups = {Acquisition})
		public void verifySEActualJIFinalRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For JI Account with Actual Quarterly JI Final bill");
			UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : SE OAM JI account with estimated quarterly JI reassessment statement, Diret debit
		@Test(groups = {Acquisition})
		public void verifySEEstimatedJIReassessmentRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For JI Account with estimated quarterly JI reassessment");
			UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : SE OAM Gas account with Dual Meter read, Cash/Cheque, Quarterly Billing
		@Test(groups = {Acquisition})
		public void verifySEGasActualFinalRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For Gas Account with Actual Final Dual Fuel");
			UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : SE OAM JI account with JI bill with estimated meter read, Cash/Cheque, Quarterly Billing clear simple
		@Test(groups = {Acquisition})
		public void verifySEJIEstimatedRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For JI Account with Estimated Meter read");
			UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : SE OAM JI account with actual JI statement, Direct Debit, Esmart Fixed price
		@Test(groups = {Acquisition})
		public void verifySEJIActualRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For JI Account with Actual statement");
			UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : SE OAM Electricity account with Estimated Electricity replacement bill, cash/cheque, Quarterly Billing online variable
		@Test(groups = {Acquisition})
		public void verifySEElectricityEstimatedFinalRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For Electricity Account with Estimated Electricity replacement statement");
			UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : SE OAM Dual Fuel account with Dual Fuel replacement statement, direct debit, Quarterly Billing online variable sep 2014
		@Test(groups = {Acquisition})
		public void verifySEDualReplacementRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For Electricity Account with Estimated Electricity replacement statement");
			UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
		
		//Data : SE OAM Gas account with Gas Reassessment statement with Actual meter read, direct debit, Quarterly Billing
		@Test(groups = {Acquisition})
		public void verifySEGasReassessmentRequestBill(){
			Report.createTestLogHeader("Request Copy Bill Test", "Verify Copy Bills For Gas Account with actual meter read");
			UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile);
			new RequestCopyBillAction()
				.navigatetoBillingHistory()
				.verifyViewBills()
				.requestBillCopy()
				.logout();

		}
}
