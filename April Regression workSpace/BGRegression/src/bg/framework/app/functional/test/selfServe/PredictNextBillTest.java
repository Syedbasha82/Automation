package bg.framework.app.functional.test.selfServe;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.PredictNextBill;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.GlobalErrorMessages;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import static bg.framework.app.functional.entities.FunctionalCategory.PredictNextBill;
import static bg.framework.app.functional.entities.FunctionalCategory.*;

public class PredictNextBillTest extends TestBase {
	/*
	 * Mandatory Fields
	 * UCRN and Account Number in userprofile.xml
	 * Estimated meter reads from SAP to be given in predictnextbill.xml
	 * Scenario - CM_02, CM_03 , ES_02 , ES_03
	 */
	
	@Test(groups={/*Regression,PredictNextBill,*/OAMRegression})
	public void predictNextBillForElectricity() throws IOException
	{
		Report.createTestLogHeader("PredictNextBill", "For Conventional and Esmart ElectricityAccount");
		//final PredictNextBill pnb=new TestDataHelper().getPNBData("PNBElectricityTestData");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage03()
		.navigateToPredictNextBill("EnergyUsage",userProfile)
		.verifyPNBPageLinks()
		.verifyIntialPNBPage()
		//.verifyMeterDials()
		//.selectMeterTypeAndEnterRead("plausible",pnb.getGasEstimate(),pnb.getElecEstimate(),pnb.getElecDualEstimate())
		//.clickPredictNextBill()
		//.verifyPredictedBillPage()
		.verifyUnitRatePrice()
		.verifyStandingRatePrice()
		.verifyElectClicktarifflink()
		.verifyElectTariffUnitRatePrice()
		.verifyTariffStandingRatePrice();
		//.resetPNBValue()
		//.pnbLogout();
	}
	
	
	@Test(groups={/*Regression,*/OAMRegression})
	public void predictNextBillForGas() throws IOException	
	{
		Report.createTestLogHeader("PredictNextBill", "For Conventional & Esmart GasAccount");
		final PredictNextBill pnb=new TestDataHelper().getPNBData("PNBGasTestData");
		UserProfile userProfile= new TestDataHelper().getUserProfile("GasAccount");
		
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage03()
		.navigateToPredictNextBill("EnergyUsage",userProfile)
		.verifyPNBPageLinks()
		.verifyIntialPNBPage()
		//.verifyMeterDials()
		//.selectMeterTypeAndEnterRead("plausible",pnb.getGasEstimate(),pnb.getElecEstimate(),pnb.getElecDualEstimate())
		//.clickPredictNextBill()
		//.verifyPredictedBillPage()
		.verifyUnitRatePrice()
		.verifyStandingRatePrice()
		.verifyElectClicktarifflink()
		.verifyElectTariffUnitRatePrice()
		.verifyTariffStandingRatePrice();
		//.resetPNBValue()
		//.pnbLogout();
	}
	
	
	/*
	 * Mandatory Fields
	 * UCRN and Account Number in userprofile.xml
	 * Estimated meter reads from SAP to be given in predictnextbill.xml
	 * Scenario - CM_04 , CM_05 ,ES_04,ES_05
	 */
	@Test(groups={/*Regression,PredictNextBill,*/OAMRegression})
	public void predictNextBillForElectricity_old() throws IOException
	{
		Report.createTestLogHeader("PredictNextBill", "For Conventional and Esmart ElectricityAccount");
		final PredictNextBill pnb=new TestDataHelper().getPNBData("PNBElectricityTestData");
		UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousElecAccount");
		new HomePageAction().navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("EnergyUsage",userProfile)
		.verifyPNBPageLinks()
		.verifyIntialPNBPage()
		//.verifyMeterDials()
		//.selectMeterTypeAndEnterRead("plausible",pnb.getGasEstimate(),pnb.getElecEstimate(),pnb.getElecDualEstimate())
		//.clickPredictNextBill()
		//.verifyPredictedBillPage()
		.verifyUnitRatePrice()
		.verifyStandingRatePrice()
		.verifyElectClicktarifflink()
		.verifyElectTariffUnitRatePrice()
		.verifyTariffStandingRatePrice()
		//.resetPNBValue()
		.pnbLogout();
	}
	
	
	/*
	 * 	Mandatory Fields
	 * 	UCRN and Account Number in userprofile.xml
	 * 	Estimated meter reads from SAP to be given in predictnextbill.xml
	 *	Scenario - CM_08 , CM_09  ,ES_08, ES_09
	 */
	@Test(groups={/*Regression,*/OAMRegression})
	public void predictNextBillForJI() throws IOException
	{
		Report.createTestLogHeader("PredictNextBill", "For conventional and energySmartJIAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("JIAccount");
		final PredictNextBill pnb=new TestDataHelper().getPNBData("PNBJITestData");
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage03()
		.navigateToPredictNextBill("EnergyUsage",userProfile)
		.verifyPNBPageLinks()
		.verifyIntialPNBPage()
		//.verifyMeterDials()
		//.selectMeterTypeAndEnterRead("plausible",pnb.getGasEstimate(),pnb.getElecEstimate(),pnb.getElecDualEstimate())
		//.clickPredictNextBill()
		//.verifyPredictedBillPage()
		.verifyUnitRatePrice()
		.verifyStandingRatePrice()
		.verifyElectClicktarifflink()
		.verifyElectTariffUnitRatePrice()
		.verifyTariffStandingRatePrice();
		//.resetPNBValue()
		//.pnbLogout();
	}
	
	
	/*
	 * Mandatory Fields
	 * UCRN and Account Number in userprofile.xml
	 * Estimated meter reads from SAP to be given in predictnextbill.xml
	 * Scenario - CM_10 , CM_11 , ES_10, ES_11
	 */
	@Test(groups={Regression})
	public void predictNextBillForJIE7() throws IOException
	{
		Report.createTestLogHeader("PredictNextBill","For conventional and JI with Economy 7 account");
		final PredictNextBill pnb=new TestDataHelper().getPNBData("PNBJIDualTestData");
		UserProfile userProfile= new TestDataHelper().getUserProfile("JIE7Account");
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("EnergyUsage",userProfile)
		.verifyPNBPageLinks()
		.verifyIntialPNBPage()
		.verifyMeterDials()
		.selectMeterTypeAndEnterRead("plausible",pnb.getGasEstimate(),pnb.getElecEstimate(),pnb.getElecDualEstimate())
		.clickPredictNextBill()
		.verifyPredictedBillPage()
		//.resetPNBValue()
		.pnbLogout();
	}
	
	
	/*
	 * Mandatory Fields
	 * UCRN and Account Number in userprofile.xml
	 * Estimated meter reads from SAP to be given in predictnextbill.xml
	 * Scenario - CM_21
	 */
	@Test(groups={Regression})
	public void predictNextBillForGasWithoutFirstBill() throws IOException
	{
		Report.createTestLogHeader("PredictNextBill", "For Account without first bill");
		final PredictNextBill pnb=new TestDataHelper().getPNBData("PNBGasTestData");
		UserProfile userProfile= new TestDataHelper().getUserProfile("GasAccount");
		ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.PredictNextBill_ErrorCode);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("EnergyUsage",userProfile)
		.verifyPNBPageLinks()
		.verifyLIcallFailorWithoutBill(errList)
		.verifyMeterDials()
		.selectMeterTypeAndEnterRead("plausible",pnb.getGasEstimate(),pnb.getElecEstimate(),pnb.getElecDualEstimate())
		.clickPredictNextBill()
		.verifyPredictedBillPage()
		.pnbLogout();
		
	}
	
	
	/*
	 * Mandatory Fields
	 * UCRN and Account Number in userprofile.xml
	 * Scenario - CM_12
	 */
	@Test(groups={Regression})
	public void pnbMeterDialsErrorValidation()
	{
		Report.createTestLogHeader("PredictNextBill", "Error validation for no entry on meter read");
		UserProfile userProfile= new TestDataHelper().getUserProfile("ElectricityAccount");
		ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.PredictNextBill_ErrorCode);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("EnergyUsage",userProfile)
		.verifyPNBPageLinks()
		.verifyIntialPNBPage()
		.verifyMeterDials()
		.clickPredictNextBill()
		.errorMessageWithoutMeterRead(errList)
		.pnbLogout();
	}
	
	
	/*
	 * Mandatory Fields
	 * UCRN and Account Number in userprofile.xml
	 * Scenario - CM_22,CM_23,ES_20,ES_21
	 * Enter implausible meter reads in PredictNextBill.xml
	 * Low and high implausible values can be changed.
	 */
	@Test(groups={Regression})
	public void predictNextBillImplausibleErrorValidationGas() throws IOException
	{
		Report.createTestLogHeader("PredictNextBill", "Implausible error validation For Gas Account");
		final PredictNextBill pnb=new TestDataHelper().getPNBData("PNBGasImplausibleTestData");
		UserProfile userProfile= new TestDataHelper().getUserProfile("GasAccount");
		ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.PredictNextBill_ErrorCode);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("EnergyUsage",userProfile)
		.verifyPNBPageLinks()
		.verifyIntialPNBPage()
		.verifyMeterDials()
		.selectMeterTypeAndEnterRead("plausible",pnb.getGasEstimate(),pnb.getElecEstimate(),pnb.getElecDualEstimate())
		.clickPredictNextBill()
		.verifyImpausibleErrorMessageImplausible(errList)
		.pnbLogout();
	}
	
	
	/*
	 * Mandatory Fields
	 * UCRN and Account Number in userprofile.xml
	 * Scenario - CM_22,CM_23,ES 20,ES 21
	 * Enter implausible meter reads in PredictNextBill.xml
	 * Low and high implausible values can be changed.
	 */
	@Test(groups={Regression})
	public void predictNextBillImplausibleErrorValidationElec() throws IOException
	{
		Report.createTestLogHeader("PredictNextBill", "Implausible error validation For Elec account");
		final PredictNextBill pnb=new TestDataHelper().getPNBData("PNBElectricityImplausibleTestData");
		UserProfile userProfile= new TestDataHelper().getUserProfile("ElectricityAccount");
		ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.PredictNextBill_ErrorCode);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("EnergyUsage",userProfile)
		.verifyPNBPageLinks()
		.verifyIntialPNBPage()
		.verifyMeterDials()
		.selectMeterTypeAndEnterRead("plausible",pnb.getGasEstimate(),pnb.getElecEstimate(),pnb.getElecDualEstimate())
		.clickPredictNextBill()
		.verifyImpausibleErrorMessageImplausible(errList)
		.pnbLogout();
	}
	
	
	/*
	 * Mandatory Fields
	 * UCRN and Account Number in userprofile.xml
	 * Scenario - CM_22,CM_23,ES 20,ES 21
	 * Enter implausible meter reads in PredictNextBill.xml
	 * Low and high implausible values can be changed.
	 */
	@Test(groups={Regression})
	public void predictNextBillImplausibleErrorValidationJI() throws IOException
	{
		Report.createTestLogHeader("PredictNextBill", "Implausible error validation for JI account");
		final PredictNextBill pnb=new TestDataHelper().getPNBData("PNBJIImplausibleTestData");
		UserProfile userProfile= new TestDataHelper().getUserProfile("JIAccount");
		ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.PredictNextBill_ErrorCode);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("EnergyUsage",userProfile)
		.verifyPNBPageLinks()
		.verifyIntialPNBPage()
		.verifyMeterDials()
		.selectMeterTypeAndEnterRead("plausible",pnb.getGasEstimate(),pnb.getElecEstimate(),pnb.getElecDualEstimate())
		.clickPredictNextBill()
		.verifyImpausibleErrorMessageImplausible(errList)
		.pnbLogout();
	}
	
	
	/*
	 *  Mandatory Fields
	 *  UCRN and Account Number in userprofile.xml
	 *  Estimated meter reads from SAP to be given in predictnextbill.xml
	 *  Scenario - CM_14
	 *  Change the getUserProfile to Gas,Elec,JI for coverage
	 */
	@Test(groups={Regression})
	public void resetValueAfterPNB() throws IOException
	{
		Report.createTestLogHeader("PredictNextBill", "verify reset value");
		final PredictNextBill pnb=new TestDataHelper().getPNBData("PNBElectricityTestData");
		UserProfile userProfile= new TestDataHelper().getUserProfile("ElectricityAccount");
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("EnergyUsage",userProfile)
		.verifyPNBPageLinks()
		.verifyIntialPNBPage()
		.verifyMeterDials()
		.selectMeterTypeAndEnterRead("plausible",pnb.getGasEstimate(),pnb.getElecEstimate(),pnb.getElecDualEstimate())
		.clickPredictNextBill()
		.verifyPredictedBillPage()
		.resetPNBValue()
		.pnbLogout();
	}
	
	
	/*
	 * Mandatory Fields
	 * UCRN and Account Number in userprofile.xml
	 * Scenario - ES_01,CM_01
	 */
	@Test(groups={Regression})
	public void predictNextBillLICallFailForGas()
	{
		Report.createTestLogHeader("PredictNextBill", "LI call Fail For Conventional GasAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("GasAccount");
		ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.PredictNextBill_ErrorCode);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("EnergyUsage",userProfile)
		.verifyPNBPageLinks()
		.verifyLIcallFailorWithoutBill(errList)
		.verifyMeterDials()
		.pnbLogout();
	}
	
	
	/*
	 * Mandatory Fields
	 * UCRN and Account Number in userprofile.xml
	 * Scenario - ES_01,CM_01
	 */
	@Test(groups={Regression,PredictNextBill})
	public void predictNextBillLICallFailForElectricity()
	
	{
		Report.createTestLogHeader("PredictNextBill", "LI Call Fail For Conventional ElectricityAccount");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.PredictNextBill_ErrorCode);
		new HomePageAction().navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("EnergyUsage",userProfile)
		.verifyPNBPageLinks()
		.verifyLIcallFailorWithoutBill(errList)
		.verifyMeterDials()
		.pnbLogout();
	}
	
	
	/*
	 * Mandatory Fields
	 * UCRN and Account Number in userprofile.xml
	 * Scenario - ES_01,CM_01
	 */
	@Test(groups={Regression})
	public void predictNextBillLICallFailForJI()
	{
		Report.createTestLogHeader("PredictNextBill", "LI Call Fail For Conventional JIAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("JIAccount");
		ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.PredictNextBill_ErrorCode);
		new HomePageAction().navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("EnergyUsage",userProfile)
		.verifyPNBPageLinks()
		.verifyLIcallFailorWithoutBill(errList)
		.verifyMeterDials()
		.pnbLogout();
	}
	
						//Smart meter customer
	
	/*
	 *  Mandatory Fields
	 *  UCRN and Account Number in userprofile.xml
	 *  Scenario - SM-03, SM_03
	 */
	@Test(groups={Regression})
	public void pnbVerificationSmartElectricityCustomer()
	{
		Report.createTestLogHeader("PredictNextBill", "For Smart Meter Electricity Account");
		UserProfile userProfile= new TestDataHelper().getUserProfile("ElectricityAccount");
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("MeterReadSection",userProfile)
		.verifyPNBPageLinks()
		.verifyWhatsThisLink()
		.verifyPredictedBillPage()
		.pnbLogout();
	}
	
	
	/*
	 *  Mandatory Fields
	 *  UCRN and Account Number in userprofile.xml
	 *  Scenario - SM-04	
	 */
	@Test(groups={Regression})
	public void pnbVerificationSmartGasCustomer()
	{
		Report.createTestLogHeader("PredictNextBill", "For Smart Meter Gas Account");
		UserProfile userProfile= new TestDataHelper().getUserProfile("GasAccount");
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("EnergyUsage",userProfile)
		.verifyPNBPageLinks()
		.verifyWhatsThisLink()
		.verifyPredictedBillPage()
		.pnbLogout();
	}
	
	
	/*
	 *  Mandatory Fields
	 *  UCRN and Account Number in userprofile.xml
	 *  Scenario - SM-08
	 */
	@Test(groups={Regression})
	public void pnbVerificationSmartJICustomer()
	{
		Report.createTestLogHeader("PredictNextBill", "For Smart Meter Energy Account");
		UserProfile userProfile= new TestDataHelper().getUserProfile("JIAccount");
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("MeterReadSection",userProfile)
		.verifyPNBPageLinks()
		.verifyWhatsThisLink()
		.verifyPredictedBillPage()
		.pnbLogout();
	}
	
	
	/*
	 *  Mandatory Fields
	 *  UCRN and Account Number in userprofile.xml
	 *  Scenario - SM-05
	 *  
	 */
	@Test(groups={Regression})
	public void pnbVerificationMixedSmartJICustomer() throws IOException
	{
		Report.createTestLogHeader("PredictNextBill", "For Mixed Smart Meter Energy Account");
		UserProfile userProfile= new TestDataHelper().getUserProfile("JIAccount");
		final PredictNextBill pnb=new TestDataHelper().getPNBData("PNBJITestData");
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("Billing",userProfile)
		.verifyPNBPageLinks()
		.verifyMeterDials()
		.selectMeterTypeAndEnterRead("plausible",pnb.getGasEstimate(),pnb.getElecEstimate(),pnb.getElecDualEstimate())
		.clickPredictNextBill()
		.verifyPredictedBillPage()
		.pnbLogout();
	}
	
	//verify MI call Error message.
	
	@Test(groups={Regression})
	public void pnbMIcallFailVerificationSmartJICustomer()
	{
		Report.createTestLogHeader("PredictNextBill", "For Smart Meter Energy Account");
		UserProfile userProfile= new TestDataHelper().getUserProfile("JIAccount");
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("MeterReadSection",userProfile)
		.verifyMIcallFail()
		.pnbLogout();
	}
	
	//verify dropdown box

	@Test(groups={Regression})
	public void pnbddverify()
	{
		Report.createTestLogHeader("PredictNextBill", "For Conventional & Esmart GasAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("GasAccount");
		new HomePageAction().navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("EnergyUsage",userProfile)
		.accountSelect("850001306373")
		.verifydropDownBoxForDualCusomer();
	}
	
	
	/*
	 *  Mandatory Fields
	 *  UCRN and Account Number in userprofile.xml
	 *  Estimated meter reads from SAP to be given in predictnextbill.xml
	 *  Scenario - ES_19
	 */
	@Test(groups={Regression,PredictNextBill})
	public void predictNextBillElecThroughSMR()
	{
		Report.createTestLogHeader("PredictNextBill Via SMR", "For Energysmart ElectricityAccount");
		final PredictNextBill pnb=new TestDataHelper().getPNBData("PNBElectricityTestData");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("SMR",userProfile)
		.enterInputsForSMRJourney(pnb.getElecEstimate())
		.navigateToPNBAfterSMR()
		.verifyPNBPageLinks()
		.verifyPredictedBillPage()
		.pnbLogout();
	}
	
	
	/*
	 * 	Mandatory Fields
	 * 	UCRN and Account Number in userprofile.xml
	 * 	Estimated meter reads from SAP to be given in predictnextbill.xml
	 *	Scenario - ES_19	
	 */
	@Test(groups={Regression})
	public void predictNextBillJIThroughSMR()
	{
		Report.createTestLogHeader("PredictNextBill Via SMR", "For energySmartJIAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("JIAccount");
		final PredictNextBill pnb=new TestDataHelper().getPNBData("PNBJITestData");
		new HomePageAction().navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("SMR",userProfile)
		.enterInputsForSMRJourney(pnb.getGasEstimate(),pnb.getElecEstimate())
		.navigateToPNBAfterSMR()
		.verifyPNBPageLinks()
		.verifyPredictedBillPage()
		.pnbLogout();
	}
	
	
	/*
	 * 	Mandatory Fields
	 * 	UCRN and Account Number in userprofile.xml
	 *	Scenario - SM_15	
	 */
	@Test(groups={Regression})
	public void predictNextBillAccSumReads()
	{
		Report.createTestLogHeader("PredictNextBill AccSummary meter Read check", "For SmartAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("GasAccount");
		new HomePageAction().navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("AccSummaryCheck",userProfile)
		.verifyPNBPageLinks()
		.verifyPredictedBillPage()
		.pnbLogout();
	}
	
	
	
	/*
	 * Mandatory Fields
	 * UCRN and Account Number of EnergySmart account in userprofile.xml
	 * Estimated meter reads from SAP to be given in predictnextbill.xml
	 * Scenario - ES_02 , ES_03
	 */
	@Test(groups={Regression})
	public void predictNextBillForESGas() throws IOException	
	{
		Report.createTestLogHeader("PredictNextBill", "For Conventional & Esmart GasAccount");
		final PredictNextBill pnb=new TestDataHelper().getPNBData("PNBGasTestData");
		UserProfile userProfile= new TestDataHelper().getUserProfile("GasAccount");
		
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("Billing",userProfile)
		.verifyPNBPageLinks()
		.verifyIntialPNBPage()
		.verifyMeterDials()
		.selectMeterTypeAndEnterRead("plausible",pnb.getGasEstimate(),pnb.getElecEstimate(),pnb.getElecDualEstimate())
		.clickPredictNextBill()
		.verifyPredictedBillPage()
		//.resetPNBValue()
		.pnbLogout();
	}
	
	
	/*
	 * Mandatory Fields
	 * UCRN and Account Number of EnergySmart account  in userprofile.xml
	 * Estimated meter reads from SAP to be given in predictnextbill.xml
	 * Scenario - ES_04,ES_05
	 */
	@Test(groups={Regression,PredictNextBill})
	public void predictNextBillForESElectricity() throws IOException
	{
		Report.createTestLogHeader("PredictNextBill", "For Conventional and Esmart ElectricityAccount");
		final PredictNextBill pnb=new TestDataHelper().getPNBData("PNBElectricityTestData");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		new HomePageAction().navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("EnergyUsage",userProfile)
		.verifyPNBPageLinks()
		.verifyIntialPNBPage()
		.verifyMeterDials()
		.selectMeterTypeAndEnterRead("plausible",pnb.getGasEstimate(),pnb.getElecEstimate(),pnb.getElecDualEstimate())
		.clickPredictNextBill()
		.verifyPredictedBillPage()
		//.resetPNBValue()
		.pnbLogout();
	}
	
	
	/*
	 * 	Mandatory Fields
	 * 	UCRN and Account Number of EnergySmart account  in userprofile.xml
	 * 	Estimated meter reads from SAP to be given in predictnextbill.xml
	 *	Scenario - ES_08, ES_09
	 */
	@Test(groups={Regression})
	public void predictNextBillForESJI() throws IOException
	{
		Report.createTestLogHeader("PredictNextBill", "For conventional and energySmartJIAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("JIAccount");
		final PredictNextBill pnb=new TestDataHelper().getPNBData("PNBJITestData");
		new HomePageAction().navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("EnergyUsage",userProfile)
		.verifyPNBPageLinks()
		.verifyIntialPNBPage()
		.verifyMeterDials()
		.selectMeterTypeAndEnterRead("plausible",pnb.getGasEstimate(),pnb.getElecEstimate(),pnb.getElecDualEstimate())
		.clickPredictNextBill()
		.verifyPredictedBillPage()
		//.resetPNBValue()
		.pnbLogout();
	}
	
	
	/*
	 * Mandatory Fields
	 * UCRN and Account Number of EnergySmart account  in userprofile.xml
	 * Estimated meter reads from SAP to be given in predictnextbill.xml
	 * Scenario - ES_10, ES_11
	 */
	@Test(groups={Regression})
	public void predictNextBillForESJIE7() throws IOException
	{
		Report.createTestLogHeader("PredictNextBill","For conventional and JI with Economy 7 account");
		final PredictNextBill pnb=new TestDataHelper().getPNBData("PNBJIDualTestData");
		UserProfile userProfile= new TestDataHelper().getUserProfile("JIE7Account");
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("EnergyUsage",userProfile)
		.verifyPNBPageLinks()
		.verifyIntialPNBPage()
		.verifyMeterDials()
		.selectMeterTypeAndEnterRead("plausible",pnb.getGasEstimate(),pnb.getElecEstimate(),pnb.getElecDualEstimate())
		.clickPredictNextBill()
		.verifyPredictedBillPage()
		//.resetPNBValue()
		.pnbLogout();
	}
	
	
	/*
	 * Mandatory Fields
	 * UCRN and Account Number in userprofile.xml
	 * Scenario - ES_20,ES_21
	 * Enter implausible meter reads in PredictNextBill.xml
	 * Low and high implausible values can be changed.
	 */
	@Test(groups={Regression})
	public void predictNextBillImplausibleErrorValidationESGas() throws IOException
	{
		Report.createTestLogHeader("PredictNextBill", "Implausible error validation For Gas Account");
		final PredictNextBill pnb=new TestDataHelper().getPNBData("PNBGasImplausibleTestData");
		UserProfile userProfile= new TestDataHelper().getUserProfile("GasAccount");
		ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.PredictNextBill_ErrorCode);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("EnergyUsage",userProfile)
		.verifyPNBPageLinks()
		.verifyIntialPNBPage()
		.verifyMeterDials()
		.selectMeterTypeAndEnterRead("plausible",pnb.getGasEstimate(),pnb.getElecEstimate(),pnb.getElecDualEstimate())
		.clickPredictNextBill()
		.verifyImpausibleErrorMessageImplausible(errList)
		.pnbLogout();
	}
	
	
	/*
	 * Mandatory Fields
	 * UCRN and Account Number in userprofile.xml
	 * Scenario - ES 20,ES 21
	 * Enter implausible meter reads in PredictNextBill.xml
	 * Low and high implausible values can be changed.
	 */
	@Test(groups={Regression})
	public void predictNextBillImplausibleErrorValidationESElec() throws IOException
	{
		Report.createTestLogHeader("PredictNextBill", "Implausible error validation For Elec account");
		final PredictNextBill pnb=new TestDataHelper().getPNBData("PNBElectricityImplausibleTestData");
		UserProfile userProfile= new TestDataHelper().getUserProfile("ElectricityAccount");
		ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.PredictNextBill_ErrorCode);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("EnergyUsage",userProfile)
		.verifyPNBPageLinks()
		.verifyIntialPNBPage()
		.verifyMeterDials()
		.selectMeterTypeAndEnterRead("plausible",pnb.getGasEstimate(),pnb.getElecEstimate(),pnb.getElecDualEstimate())
		.clickPredictNextBill()
		.verifyImpausibleErrorMessageImplausible(errList)
		.pnbLogout();
	}
	
	
	/*
	 * Mandatory Fields
	 * UCRN and Account Number in userprofile.xml
	 * Scenario - ES 20,ES 21
	 * Enter implausible meter reads in PredictNextBill.xml
	 * Low and high implausible values can be changed.
	 */
	@Test(groups={Regression})
	public void predictNextBillImplausibleErrorValidationESJI() throws IOException
	{
		Report.createTestLogHeader("PredictNextBill", "Implausible error validation for JI account");
		final PredictNextBill pnb=new TestDataHelper().getPNBData("PNBJIImplausibleTestData");
		UserProfile userProfile= new TestDataHelper().getUserProfile("JIAccount");
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("EnergyUsage",userProfile)
		.verifyPNBPageLinks()
		.verifyIntialPNBPage()
		.verifyMeterDials()
		.selectMeterTypeAndEnterRead("plausible",pnb.getGasEstimate(),pnb.getElecEstimate(),pnb.getElecDualEstimate())
		.clickPredictNextBill()
		//.verifyImpausibleErrorMessageImplausible(errList)
		.pnbLogout();
	}
	
	@Test(groups={Regression})
	public void predictNextBillImplausibleErr() throws IOException
	{
		Report.createTestLogHeader("PredictNextBill", "Implausible error validation for JI account");
		final PredictNextBill pnb=new TestDataHelper().getPNBData("PNBJIImplausibleTestData");
		UserProfile userProfile= new TestDataHelper().getUserProfile("GasAccount");
		ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.PredictNextBill_ErrorCode);
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("EnergyUsage",userProfile)
		.verifyPNBPageLinks()
		.verifyIntialPNBPage()
		.verifyMeterDials()
		.selectMeterTypeAndEnterRead("plausible",pnb.getGasEstimate(),pnb.getElecEstimate(),pnb.getElecDualEstimate())
		.clickPredictNextBill()
		.verifyImpausibleErrorMessageImplausible(errList)
		.pnbLogout();
	}
	/*
	 * To Verify the PNB Journey Not Applicable for TOU Tariffs
	 */
	@Test(groups={Regression})
	public void predictNextBillErrorOutforTOU() throws IOException	
	{
		Report.createTestLogHeader("PredictNextBill- ErrorOut for TOU", "predictNextBillErrorOutforTOU");
		final PredictNextBill pnb=new TestDataHelper().getPNBData("PNBGasTestData");
		UserProfile userProfile= new TestDataHelper().getUserProfile("ElectricityAccount1");
		
		new HomePageAction()	
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToPredictNextBill("Billing",userProfile)
		.verifyErrorMessage()
		.pnbLogout();
	
}
}
