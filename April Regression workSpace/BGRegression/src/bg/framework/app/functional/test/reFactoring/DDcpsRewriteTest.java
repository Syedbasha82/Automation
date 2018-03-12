package bg.framework.app.functional.test.reFactoring;

import static bg.framework.app.functional.entities.FunctionalCategory.Ddcps;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;

import java.util.ArrayList;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.Ddcps;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.GlobalErrorMessages;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;


public class DDcpsRewriteTest extends TestBase{

	@Test(groups={Ddcps,Regression})
	public void ddcpsDBBankDetailsErrorValidation(){
		Report.createTestLogHeader("DDCPS Bank details journey For Gas Customer", "GasAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			//.manageDDUpdatebankDetails()
			//.verifyUpdatedDetails()
			.updateBDViaPlanBreakdown()
			.verifyUpdatedDetails()
			.logOut();
	}

//--------------------------Update Bank Details and Detailed Plan Breakdown--------------------
	
	
		//TC_01,
		@Test(groups={Ddcps,Regression})
		public void ddcpsCBDandDPBElecDual(){
			Report.createTestLogHeader("DDCPS Bank details Cancel link verification", "Electricity Dual Account");
			UserProfile userProfile=new TestDataHelper().getUserProfile("ElectricityAccount");
			final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile)
				.navigateToManageDD(ddcps,userProfile)
				.navigateToUpdateBankDetails()
				.verifyCancelOverlay("UpdateBankDetailsLink")
				.navigateToUpdateBankDetails()
				.inputBankDetails()
				.verifyUpdatedDetails()
				.detailedPlanBreakDown()	
				.logOut();
		}
		
		
		//TC_03
		@Test(groups={Ddcps,Regression})
		public void ddcpsCBDandDPBGas(){
			Report.createTestLogHeader("DDCPS Change Bank details,Cancel link verification and Detailed plan Breakdown", "Gas Account");
			UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
			final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile)
				.navigateToManageDD(ddcps,userProfile)
				.navigateToUpdateBankDetails()
				.verifyCancelOverlay("UpdateBankDetailsLink")
				.navigateToUpdateBankDetails()
				.inputBankDetails()
				.verifyUpdatedDetails()
				.detailedPlanBreakDown()	
				.logOut();
		}
		
		
		//TC_02
		@Test(groups={Ddcps,Regression})
		public void ddcpsCBDandDPBElectricity(){
			Report.createTestLogHeader("DDCPS Bank details Cancel link verification", "Electricity Account");
			UserProfile userProfile=new TestDataHelper().getUserProfile("ElectricityAccount");
			final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile)
				.navigateToManageDD(ddcps,userProfile)
				.navigateToUpdateBankDetails()
				.verifyCancelOverlay("UpdateBankDetailsLink")
				.navigateToUpdateBankDetails()
				.inputBankDetails()
				.verifyUpdatedDetails()
				.detailedPlanBreakDown()	
				.logOut();
		}
		
		
		//TC_04
		@Test(groups={Ddcps,Regression})
		public void ddcpsCBDandDPBJI(){
			Report.createTestLogHeader("DDCPS Bank details Cancel link verification", "JI Account");
			UserProfile userProfile=new TestDataHelper().getUserProfile("JIAccount");
			final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile)
				.navigateToManageDD(ddcps,userProfile)
				.navigateToUpdateBankDetails()
				.verifyCancelOverlay("UpdateBankDetailsLink")
				.navigateToUpdateBankDetails()
				.inputBankDetails()
				.verifyUpdatedDetails()
				.detailedPlanBreakDown()	
				.logOut();
		}
		
		
		@Test(groups={Ddcps,Regression})
		public void ddcpsCBDErrorVerifAndExceedsLimitVerif(){
			Report.createTestLogHeader("DDCPS CBD Error Validation", "GasAccount");
			UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
			final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
			ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.DDCPS_ErrorCode);
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile)
				.navigateToManageDD(ddcps,userProfile)
				.invalidDetailsErrMessageValidation(errList)
				.logOut();
		
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile)
				.navigateToManageDD(ddcps,userProfile)
				.navigateToUpdateBankDetails()
				.inputBankDetails()
				.verifyUpdatedDetails()
				.logOut();
		}

		/*---------------------------------DDCPS Update Bank Details---------------------------*/

	
	//TC_01 Electricity Dual Rate
	@Test(groups={Ddcps,Regression})
	public void ddcpsDB(){
		Report.createTestLogHeader("DDCPS Bank details Cancel link verification", "GasAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()	
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.navigateToUpdateBankDetails()
			.verifyCancelOverlay("UpdateBankDetailsLink")	
			.updateBDViaPlanBreakdown()
			.verifyUpdatedDetails()
			.logOut();
	}



	@Test(groups={Ddcps,Regression})
	public void ddcpsCBDElec(){
		Report.createTestLogHeader("DDCPS Bank details journey For Gas Customer", "GasAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.navigateToUpdateBankDetails()
			.verifyCancelOverlay("UpdateBankDetailsLink")
			.updateBDViaPlanBreakdown()
			.verifyUpdatedDetails()
			.logOut();
	}

	@Test(groups={Ddcps,Regression})
	public void ddcpsCBDviaDPBGas(){
		Report.createTestLogHeader("DDCPS Bank details journey For Gas Customer", "GasAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.navigateToUpdateBankDetails()
			.verifyCancelOverlay("UpdateBankDetailsLink")
			.updateBDViaPlanBreakdown()
			.verifyUpdatedDetails()
			.logOut();
	}


	@Test(groups={Ddcps,Regression})
	public void ddcpsCBDSamebankDetails(){
		Report.createTestLogHeader("DDCPS Bank details journey For Gas Customer", "GasAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.manageDDUpdatebankDetails()
			.verifyUpdatedDetails()
			.manageDDUpdatebankDetails()
			.verifyUpdatedDetails()
			.logOut();
	}
		
	@Test(groups={Ddcps,Regression})
	public void ddcpsCBDElectricity(){
		Report.createTestLogHeader("DDCPS Change Bank details", "ElectricityAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("ElectricityAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.manageDDUpdatebankDetails()
			.verifyUpdatedDetails()
			.logOut();
	}	


	@Test(groups={Ddcps,Regression})
	public void ddcpsCBDJI(){
		Report.createTestLogHeader("DDCPS Change Bank details", "JIAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("JIAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.manageDDUpdatebankDetails()
			.verifyUpdatedDetails()
			.logOut();
	}


	@Test(groups={Ddcps,Regression})
	public void ddcpsCBDSaveButtonFunc(){
		Report.createTestLogHeader("DDCPS Change Bank details", "JIAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("JIAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.manageDDUpdatebankDetails()
			.logOut();
	}
	@Test(groups={Ddcps,Regression})
	public void ddcpsCBD(){
		Report.createTestLogHeader("DDCPS Bank details journey For Gas Customer", "GasAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.navigateToUpdateBankDetails()
			.verifyCancelOverlay("UpdateBankDetailsLink")
			.updateBDViaPlanBreakdown()
			.verifyUpdatedDetails()
			.logOut();
	}


	@Test(groups={Ddcps,Regression})
	public void ddcpsDPB(){
		Report.createTestLogHeader("DDCPS Detailed plan breakdown", "ElectricityAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("ElectricityAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.detailedPlanBreakDown()
			.logOut();}
	
	
	@Test(groups={Ddcps,Regression})
	public void ddcpsDPBMissedPayment(){
		Report.createTestLogHeader("DDCPS Detailed plan breakdown for one  Missed Payment", "ElectricityAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("ElectricityAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.detailedPlanBreakDown()
			.logOut();}
	

//--------------------------------Get A Refund---------------------------

	@Test(groups={Ddcps,Regression})
	public void ddcpsGetARefund()
	{
		Report.createTestLogHeader("DDCPS Get A Refund", "GasAccount");
		ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.DDCPS_ErrorCode);
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)	
			.navigateToManageDD(ddcps,userProfile)
			.navigateToCreditRefund(userProfile,errList)
			.manageDDmeterReadOverlay()
			.verifyCancelOverlay("GetCreditRefundLink")
			.navigateToCreditRefund(userProfile,errList)
			.checkGARResetFunc()
			.credRefundAmount("SimpleRefund")
			.confirmCredRefund()
			.navigateToCreditRefund(userProfile,errList)
			.credRefundAmount("GreaterThanTolerance");
	}
	
	
	//For Error message Validation
	@Test(groups={Ddcps,Regression})
	public void ddcpsGetARefundForDebitCusomer()
	{
		Report.createTestLogHeader("DDCPS Get A Refund For Debit Customer", "GasAccount");
		ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.DDCPS_ErrorCode);
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.navigateToCreditRefund(userProfile,errList)
			.manageDDmeterReadOverlay()
			.manageDDErrorForDebitCustomer()
			.logOut();
	}
	
//---------------------------------Make A Payment-----------------
	
	//EDR
	//Mandatory Fields 
	@Test(groups={Ddcps,Regression})
	public void ddcpsMKPElecDual()
	{
		Report.createTestLogHeader("DDCPS Get A Refund", "ElectricityAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("ElectricityAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.makeAPaymentManageDD("payRecommended");
	}
	
	//JI without clicking recalculate
	@Test(groups={Ddcps,Regression})
	public void ddcpsMKPJIWithoutRecalculate()
	{
		Report.createTestLogHeader("DDCPS Get A Refund", "JIAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("JIAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.makeAPaymentManageDD("payRecommended","withoutRecalc");
	}
	
	
	@Test(groups={Ddcps,Regression})
	public void ddcpsMKPGas()
	{
		Report.createTestLogHeader("DDCPS Make A Payment", "GasAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.makeAPaymentManageDD("payRecommended");
	}
	
	@Test(groups={Ddcps,Regression})
	public void ddcpsMKPJI()
	{
		Report.createTestLogHeader("DDCPS Get A Refund", "JIAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("JIAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.makeAPaymentManageDD("paySimple");
	}
	
	@Test(groups={Ddcps,Regression})
	public void ddcpsMKP2()
	{
		Report.createTestLogHeader("DDCPS Get A Refund", "GasAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.navigateToMkp()
			//.verifyCancelOverlay("MakeAPaymentLink")
			.makeAPaymentManageDD("payRecommended");
	}
	
	
	@Test(groups={Ddcps,Regression})
	public void ddcpsMKP()
	{
		Report.createTestLogHeader("DDCPS Get A Refund", "GasAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.makeAPaymentManageDD("paySimple");
	}
	
	@Test(groups={Ddcps,Regression})
	public void ddcpsErrorDDREstricited()
	{
		Report.createTestLogHeader("DDCPS Error message validation For Access Denied or Payment Completed Customer", "GasAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.DDCPS_ErrorCode);
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.errorForAccessBlocked(errList)
			.logOut();
			
	}
	
	//---------------------------------Flexi Payment Plan-----------------
	
	//TC_01,TC_12,TC_15,TC_16,TC_20,TC_32,TC_33
	@Test(groups={Ddcps,Regression})
	public void ddcpsFlexiPaymentPlan()
	{
		Report.createTestLogHeader("DDCPS Flex your payment plan", "GasAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.navigateToFlexiPaymentPlan()
			.flexPaymentPlan()
			.logOut();
	}
	
	//TC_04,TC_27,TC_34,TC_41
	@Test(groups={Ddcps,Regression})
	public void ddcpsFlexiPaymentPlanElectricity()
	{
		Report.createTestLogHeader("DDCPS Flex your payment plan", "Electricity Account");
		UserProfile userProfile=new TestDataHelper().getUserProfile("ElectricityAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.navigateToFlexiPaymentPlan()
			.flexPaymentPlan()
			.logOut();
	}
	
	//TC_08,TC_25,TC_46,TC_52
	@Test(groups={Ddcps,Regression})
	public void ddcpsFlexiPaymentPlanJI()
	{
		Report.createTestLogHeader("DDCPS Flex your payment plan", "Energy Account");
		UserProfile userProfile=new TestDataHelper().getUserProfile("EnergyAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.navigateToFlexiPaymentPlan()
			.flexPaymentPlan()
			.logOut();
	}
	
	//---------------------------------Adjust Payment Plan-----------------
	
	@Test(groups={Ddcps,Regression})	
	public void ddcpsAdjustYourPaymentPlanForGas()
	{
		Report.createTestLogHeader("DDCPS Adjust your payment plan", "GasAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.navigateToAdjustMonthly()
			.adjustMonthly("All")
			.logOut();
	}
	
	@Test(groups={Ddcps,Regression})
	public void ddcpsAdjustYourPaymentPlanElectricity()
	{
		Report.createTestLogHeader("DDCPS Adjust your payment plan", "ElectricityAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.navigateToAdjustMonthly()
			.adjustMonthly("All")
			.logOut();
	}
	
	@Test(groups={Ddcps,Regression})
	public void ddcpsAdjustYourPaymentPlanJI()
	{
		Report.createTestLogHeader("DDCPS Adjust your payment plan", "JIAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("JIAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.navigateToAdjustMonthly()
			.adjustMonthly("All")
			.logOut();
	}
	
	@Test(groups={Ddcps,Regression})
	public void ddcpsEnterMeterRead()
	{
		Report.createTestLogHeader("DDCPS Adjust your payment plan", "GasAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.navigateToSubmitMeterRead(userProfile)
			.logOut();
	}
	
	//---------------------------------------------- GAR and SMR-------------------------------
	
	
	//TC_01,TC_02,TC_03,TC_05,TC_06,TC_08
	//TC_39,TC_42,TC_53
	@Test(groups={Ddcps,Regression})
	public void ddcpsGARandSMRForGas()
	{
		Report.createTestLogHeader("DDCPS Get A refund and SMR", "GasAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.DDCPS_ErrorCode);
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.navigateToSubmitMeterRead(userProfile)
			.navigateToCreditRefund(userProfile,errList)
			.checkGARResetFunc()
			.credRefundAmount("SimpleRefund")
			.navigateToCreditRefund(userProfile,errList)
			.credRefundAmount("GreaterThanTolerance")
			.logOut();
	}
	
	//TC_31,C_33,TC_35
	//TC_34,TC_49
	@Test(groups={Ddcps,Regression})
	public void ddcpsGARandSMRForElectricity()
	{
		Report.createTestLogHeader("DDCPS Get A refund and SMR", "ElectricityAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("ElectricityAccount");
		ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.DDCPS_ErrorCode);
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.navigateToSubmitMeterRead(userProfile)
			.navigateToCreditRefund(userProfile,errList)
			.checkGARResetFunc()
			.credRefundAmount("SimpleRefund")
			.navigateToCreditRefund(userProfile,errList)
			.credRefundAmount("GreaterThanTolerance")
			.logOut();
	}
	
	
	//TC_27,TC_28,TC_30
	@Test(groups={Ddcps,Regression})
	public void ddcpsGARandSMRForElecDual()
	{
		Report.createTestLogHeader("DDCPS Get A refund and SMR", "ElectricityAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("ElectricityAccount");
		ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.DDCPS_ErrorCode);
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.navigateToSubmitMeterRead(userProfile)
			.navigateToCreditRefund(userProfile,errList)
			.checkGARResetFunc()
			.credRefundAmount("SimpleRefund")
			.navigateToCreditRefund(userProfile,errList)
			.credRefundAmount("GreaterThanTolerance")
			.logOut();
	}
	
	
	//TC_43,45,57
	//TC_48
	@Test(groups={Ddcps,Regression})
	public void ddcpsGARandSMRForJI()
	{
		Report.createTestLogHeader("DDCPS Get A refund and SMR", "JIAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("JIAccount");
		ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.DDCPS_ErrorCode);
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.navigateToSubmitMeterRead(userProfile)
			.navigateToCreditRefund(userProfile,errList)
			.checkGARResetFunc()
			.credRefundAmount("SimpleRefund")
			.navigateToCreditRefund(userProfile,errList)
			.credRefundAmount("GreaterThanTolerance")
			.logOut();
	}
	
	
	
	//---------------------------------------- MKP and  Adjust Monthly--------------------------------------------
	
	//MKP-TC_22,TC_23,TC_25,TC_26
	//AMP-TC_03,TC_04,TC_05,TC_09,TC_14
	@Test(groups={Ddcps,Regression})
	public void ddcpsMKPandAMPGas()
	{
		Report.createTestLogHeader("DDCPS Adjust your payment plan and Make a payment", "GasAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.navigateToMkp()
			.makeAPaymentManageDD("paySimple","withRecalculate")
			.navigateToAdjustMonthly()
			.adjustMonthly("All")
			.logOut();
	}
	
	
	//MKP-TC_10,TC_13,TC_15,TC_16,TC_17,TC_19
	//AMP-TC_11,TC_13,TC_17
	@Test(groups={Ddcps,Regression})
	public void ddcpsMKPandAMPElectricity()
	{
		Report.createTestLogHeader("DDCPS Adjust your payment plan and Make a payment", "ElectricityAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("ElectricityAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			/*.navigateToMkp()
			.verifyCancelOverlay("MakeAPaymentLink")
			.makeAPaymentManageDD("paySimple","withRecalculate")*/
			.navigateToAdjustMonthly()
			.adjustMonthly("All")
			.logOut();
	}
	
	//MKP-TC_01,TC_02,TC_03,TC_05
	//AMP-TC_07,
	@Test(groups={Ddcps,Regression})
	public void ddcpsMKPandAMPElectricityDual()
	{
		Report.createTestLogHeader("DDCPS Adjust your payment plan and Make a payment", "ElectricityAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("ElectricityAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.navigateToMkp()
			.makeAPaymentManageDD("paySimple","withRecalculate")
			.navigateToAdjustMonthly()
			.adjustMonthly("All")
			.logOut();
	}
	
	//MKP-TC_33,TC_35,TC_34
	//AMP-TC_10,TC_16,TC_18(2pending),TC_19(1Pending)
	@Test(groups={Ddcps,Regression})
	public void ddcpsMKPandAMPJI()
	{
		Report.createTestLogHeader("DDCPS Adjust your payment plan and Make a payment", "JIAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("JIAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.navigateToMkp()
			.makeAPaymentManageDD("paySimple","withoutRecalc")
			.navigateToAdjustMonthly()
			.adjustMonthly("All")
			.logOut();
	}
	
	@Test(groups={Ddcps,Regression})
	public void ddcpsMKPErrValidation()
	{
		Report.createTestLogHeader("DDCPS Make a payment CQ5 Error validation", "ElectricityAccount");
		ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.DDCPS_ErrorCode);
		UserProfile userProfile=new TestDataHelper().getUserProfile("ElectricityAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		/*new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.navigateToMkp()
			.mkpErrValidation(errList)
			.logOut();*/
		
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToManageDD(ddcps,userProfile)
		.mkpTryExceeds(userProfile, errList)
		.logOut();
	}
	
	
	@Test(groups={Ddcps,Regression})
	public void ddcpsPayComplete()
	{
		Report.createTestLogHeader("DDCPS Make a payment CQ5 Error validation", "ElectricityAccount");
		ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.DDCPS_ErrorCode);
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.ddPayComplete(errList)
			.logOut();
	}
	
									//-------Manage DD Dashboard------//
	
	//TC_29,TC_30,TC_31- Change the Test data(GAS,JI) for coverage
	
	@Test(groups={Ddcps,Regression})
	public void ddcpsSmartRefreshLink()
	{
		Report.createTestLogHeader("DDCPS Refresh Link for smart customer", "ElectricityAccount");
		UserProfile userProfile=new TestDataHelper().getUserProfile("ElectricityAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)	
			.navigateToManageDD(ddcps,userProfile)
			.smartRefreshLink() 
			.logOut();
	}
	
	//-------------------SmokeTest Script-----------
	
	
	//Change Bank Details,Detailed Plan Breakdown,Adjust Monthly Payment,Make A Payment
	@Test(groups={Ddcps,Regression})
	public void ddcpsSmokeTestScript1()
	{
		Report.createTestLogHeader("DDCPS Smoke Test Script CBD,AMP,MKP,DPB", "GasAccount");
		//ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.DDCPS_ErrorCode);
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()	
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			/*.navigateToUpdateBankDetails()
			.inputBankDetails()
			.verifyUpdatedDetails()
			.detailedPlanBreakDown()*/
			.navigateToAdjustMonthly()
			.adjustMonthly("All")
			/*.navigateToMkp()
			.makeAPaymentManageDD("paySimple","withRecalculate")
			.navigateToCreditRefund(userProfile,errList)
			.credRefundAmount("SimpleRefund")*/
			.logOut();
	}
	
	
	//Flexi and Credit Refund
	@Test(groups={Ddcps,Regression})
	public void ddcpsSmokeTestScript2()
	{
		Report.createTestLogHeader("DDCPS Smoke Test Script For Flexi", "GasAccount");
		ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.DDCPS_ErrorCode);
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToManageDD(ddcps,userProfile)
			.navigateToSubmitMeterRead(userProfile)
			.navigateToCreditRefund(userProfile,errList)
			.credRefundAmount("SimpleRefund")
			.navigateToFlexiPaymentPlan()
			.flexPaymentPlan()
			.logOut();
	}
}