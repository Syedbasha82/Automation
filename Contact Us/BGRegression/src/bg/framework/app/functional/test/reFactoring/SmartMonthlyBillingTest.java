package bg.framework.app.functional.test.reFactoring;

import static bg.framework.app.functional.entities.FunctionalCategory.Acquisition;
import static bg.framework.app.functional.entities.FunctionalCategory.BG;
import static bg.framework.app.functional.entities.FunctionalCategory.Conversion;
import static bg.framework.app.functional.entities.FunctionalCategory.Qtp;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import static bg.framework.app.functional.entities.FunctionalCategory.Zeus;

import java.io.IOException;
import java.util.ArrayList;

import net.sf.saxon.functions.ForceCase;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.action.reFactoring.AccOverviewAction;
import bg.framework.app.functional.action.reFactoring.SmartMonthlyBillingAction;
import bg.framework.app.functional.action.reFactoring.ViewBillAction;
import bg.framework.app.functional.action.sales.AcquisitionAction;
import bg.framework.app.functional.action.selfServe.AccountSummaryAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.FunctionalCategory;
import bg.framework.app.functional.entities.PredictNextBill;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.GlobalErrorMessages;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;


public class SmartMonthlyBillingTest extends TestBase {

//////////////////////////////////////////////////////////////////////////////////////////////////////////////Negative TestCases////////////////

/*
 * *****************************************TC_Negative_001*********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void singleFuelTrilliantSmartMeterSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"GasAccount");
	
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("GasAccount");
	ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.ReFactoring_SMB_supplyaddresstempErrorCode);
	Report.updateTestLog(
			"************SmartMonthlyBilling_Negative_TC_01***************", "DONE");
	// SMB_Negative_001

		
		new HomePageAction()
		.navigateToLogin() 
		.login(userProfile)
		.navigateToSMBnegativetemp(errList);
			
			//.loginSMBNegative(userProfile)
			//.navigateToAccountSummaryPageSMBNegative(userProfile);
}		

/*
 * *****************************************TC_Negative_002*********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void duelFuelLogicaSmartMeterSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.ReFactoring_SMB_supplyaddresstempErrorCode);
	Report.updateTestLog(
			"************SmartMonthlyBilling_Negative_TC_02***************", "DONE");
	// SMB_Negative_002
	
	
	new HomePageAction()
	.navigateToLogin()
	.login(userProfile)
	.navigateToSMBnegativetemp(errList);

		/*new HomePageAction()
			.navigateToLogin()
			.loginSMBNegative(userProfile)
			.navigateToAccountSummaryPageSMBNegative(userProfile);	*/
}		

/*
 * *****************************************TC_Negative_003*********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void duelFuelDumbMeterSMB() {

	//Report.createTestLogHeader("Smart Monthly Billing",
			//"DualAccount");
	
	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.ReFactoring_SMB_supplyaddresstempErrorCode);
	Report.updateTestLog(
			"************SmartMonthlyBilling_Negative_TC_03***************", "DONE");
	// SMB_Negative_003

		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToSMBnegativetemp(errList);
		
		/*.navigateToLogin()
			.loginSMBNegative(userProfile)
			.navigateToAccountSummaryPageSMBNegative(userProfile);*/
}	

/*
 * *****************************************TC_Negative_004*********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void duelFuelWithEleTrillantAndGasDumbSMB() {

	//Report.createTestLogHeader("Smart Monthly Billing",
			//"DualAccount");
	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.ReFactoring_SMB_supplyaddresstempErrorCode);
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");

	Report.updateTestLog(
			"************SmartMonthlyBilling_Negative_TC_04***************", "DONE");
	// SMB_Negative_004
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToSMBnegativetemp(errList);
		//new HomePageAction()
			//.navigateToLogin()
				//.navigateToSMB()
				//.forcedRegistrationYourOrderPageSMB(acquisition, userProfile)
				//.confirmSMBAddressnegative(errList);
					//.confirmSMBAddress();
			
			//.login(userProfile)
			//.verifySMBLink();		
}	

/*
 * *****************************************TC_Negative_005*********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void duelFuelBillingBlockStatusSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");

	Report.updateTestLog(
			"************SmartMonthlyBilling_Negative_TC_05***************", "DONE");
	// SMB_Negative_005

		new HomePageAction()
			.navigateToLogin()
			.loginSMB(userProfile)
			.navigateToAccountSummaryPageSMB(userProfile)	
			.confirmSMBAddress()
			.confirmSMBAddressLink();
}

/*
 * *****************************************TC_Negative_006*********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void duelFuelWithInvoiceBlockStatusSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");

	Report.updateTestLog(
			"************SmartMonthlyBilling_Negative_TC_06***************", "DONE");
	// SMB_Negative_006

		new HomePageAction()
			.navigateToLogin()
			.loginSMB(userProfile)
			.navigateToAccountSummaryPageSMB(userProfile)	
			.confirmSMBAddress()
			.confirmSMBAddressLink();
}

/*
 * *****************************************TC_Negative_007*********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void jIAccountWithFusionSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"JIAccount");
	
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("JIAccount");

	Report.updateTestLog(
			"************SmartMonthlyBilling_Negative_TC_07***************", "DONE");
	// SMB_Negative_007
	String debt="NO";
    String accountType="MFDD";
    String GasAccount="DD";
    String Option="DDPayment";
		new HomePageAction()
		.navigateToSMB()
		.forcedRegistrationYourOrderPageSMB(acquisition, userProfile)		
		.forcedLoginOnlySMB(acquisition, userProfile)
		.confirmSMBAddress()
		.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
		.reviewOrderPageNavigationSMB()
		.verifyThankYouPage(userProfile)
		.getEshopLeadIDSMB(userProfile);
}

/*
 * *****************************************TC_Negative_008*********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void DebtGreaterThan500SMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_Negative_TC_08***************", "DONE");
	// SMB_Negative_008
	String debt="YES";
    String accountType="MFDD";
    String GasAccount="CC";
    String Option="CCPayment";
	
	new HomePageAction()
	.navigateToSMB()
	.forcedRegistrationYourOrderPageSMB(acquisition, userProfile)		
	.confirmSMBAddress()
	.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
	.reviewOrderPageNavigationSMB()
	.verifyThankYouPage(userProfile)
	.getEshopLeadIDSMB(userProfile)
	.getOAMdetailsSMB(userProfile); 
	
		/*new HomePageAction()
			.navigateToLogin()
			.loginSMB(userProfile)
			.navigateToAccountSummaryPageSMB(userProfile)	
			.confirmSMBAddress()
			.confirmSMBAddressLink();*/
}

/*
 * *****************************************TC_Negative_009*********************************
 */
@Test(groups = { FunctionalCategory.Acquisition })
public void duelFuelAccountInActiveDisputeSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");

	Report.updateTestLog(
			"************SmartMonthlyBilling_Negative_TC_09***************", "DONE");
	// SMB_Negative_009

		new HomePageAction()
			.navigateToLogin()
			.loginSMB(userProfile)
			.navigateToAccountSummaryPageSMB(userProfile)	
			.confirmSMBAddress()
			.confirmSMBAddressLink();
}

/*
 * *****************************************TC_Negative_010*********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void duelFuelAccountInMovingOutSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.ReFactoring_SMB_supplyaddresstempErrorCode);
	Report.updateTestLog(
			"************SmartMonthlyBilling_Negative_TC_010***************", "DONE");
	// SMB_Negative_010

		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToSMBnegativetemp(errList);
			/*.navigateToLogin()
			.loginSMB(userProfile)
			.navigateToAccountSummaryPageSMB(userProfile)	
			.confirmSMBAddress()
			.confirmSMBAddressLink();*/
}

/*
 * *****************************************TC_Negative_011*********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void duelFuelimplausibleReadExistsStatusSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");

	Report.updateTestLog(
			"************SmartMonthlyBilling_Negative_TC_011***************", "DONE");
	// SMB_Negative_011

		new HomePageAction()
			.navigateToLogin()
			.loginSMB(userProfile)
			.navigateToAccountSummaryPageSMB(userProfile)	
			.confirmSMBAddress()
			.confirmSMBAddressLink();
}

/*
 * *****************************************TC_Negative_012*********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void duelFuelAccountInInvalidTarrifSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");

	Report.updateTestLog(
			"************SmartMonthlyBilling_Negative_TC_012***************", "DONE");
	// SMB_Negative_012

		new HomePageAction()
			.navigateToLogin()
			.loginSMB(userProfile)
			.navigateToAccountSummaryPageSMB(userProfile)	
			.confirmSMBAddress()
			.confirmSMBAddressLink();
}

/*
 * *****************************************TC_Negative_013*********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void duelFuelAlreadyRegisteredWithSMBSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.ReFactoring_SMB_supplyaddresstempErrorCode);
	Report.updateTestLog(
			"************SmartMonthlyBilling_Negative_TC_013***************", "DONE");
	// SMB_Negative_013

		/*new HomePageAction()
			.navigateToLogin()
			.loginSMB(userProfile)
			.navigateToAccountSummaryPageSMB(userProfile)	
			.confirmSMBAddress()
			.confirmSMBAddressLink();*/
	new HomePageAction()
	.navigateToLogin()
	.login(userProfile)
	.navigateToSMBnegativetemp(errList);
}

/*
 * *****************************************TC_Negative_014*********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void duelFuelAndFuelDirectCustomersSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.ReFactoring_SMB_supplyaddresstempErrorCode);
	Report.updateTestLog(
			"************SmartMonthlyBilling_Negative_TC_014***************", "DONE");
	// SMB_Negative_014

		
	new HomePageAction()
	.navigateToLogin()
	.login(userProfile)
	.navigateToSMBnegativetemp(errList);
	
	/*new HomePageAction()
			.navigateToLogin()
			.loginSMB(userProfile)
			.navigateToAccountSummaryPageSMB(userProfile)	
			.confirmSMBAddress()
			.confirmSMBAddressLink();*/	
	}

/*
 * *****************************************TC_Negative_015*********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void duelFuelPrePaymentMeterModeSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.ReFactoring_SMB_supplyaddresstempErrorCode);
	Report.updateTestLog(
			"************SmartMonthlyBilling_Negative_TC_015***************", "DONE");
	// SMB_Negative_015

		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToSMBnegativetemp(errList);
		
		/*new HomePageAction()
			.navigateToLogin()
			.loginSMB(userProfile)
			.navigateToAccountSummaryPageSMB(userProfile)	
			.confirmSMBAddress()
			.confirmSMBAddressLink();*/
}

/*
 * *****************************************TC_Negative_016*********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void duelFuelWithdrawingToAnotherSupplierSMB(){

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");

	Report.updateTestLog(
			"************SmartMonthlyBilling_Negative_TC_016***************", "DONE");
	// SMB_Negative_016

		new HomePageAction()
			.navigateToLogin()
			.loginSMB(userProfile)
			.navigateToAccountSummaryPageSMB(userProfile)	
			.confirmSMBAddress()
			.confirmSMBAddressLink();
}

/*
 * *****************************************TC_Negative_017*********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void jIAccountAlreadyWithdrawnSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"JIAccount");
	
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("JIAccount");

	Report.updateTestLog(
			"************SmartMonthlyBilling_Negative_TC_017***************", "DONE");
	// SMB_Negative_017

		new HomePageAction()
			.navigateToLogin()
			.loginSMB(userProfile)
			.navigateToAccountSummaryPageSMB(userProfile)	
			.confirmSMBAddress()
			.confirmSMBAddressLink();
}

/*
 * *****************************************TC_Negative_018*********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void duelFuelAndComplexMeterSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");

	Report.updateTestLog(
			"************SmartMonthlyBilling_Negative_TC_018***************", "DONE");
	// SMB_Negative_018

		new HomePageAction()
			.navigateToLogin()
			.loginSMB(userProfile)
			.navigateToAccountSummaryPageSMB(userProfile)	
			.confirmSMBAddress()
			.confirmSMBAddressLink();
}

/*
 * *****************************************TC_Negative_019*********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void QuartelyBillPEEAUserUnableToUpgradeSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"GasAccount");
	
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("GasAccount");

	Report.updateTestLog(
			"************SmartMonthlyBilling_Negative_TC_019***************", "DONE");
	// SMB_Negative_019

		new HomePageAction()
			.navigateToLogin()
			.loginSMBNegative(userProfile)
			.navigateToAccountSummaryPageSMBNegative(userProfile);	
}		

//////////////////////////////////////////////////////////////////////////////////////////////////////////////Siebel Mastered users////////////////

/*
 * *****************************************TC_Siebel_001*********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void SiebelJICaChSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"JIAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("JIAccount");
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_Siebel_TC_01***************", "DONE");
	// SMB_Siebel_001
     String debt="NO";
     String accountType="MFDD";
     String GasAccount="CC";
     String Option="CCPayment";
         
	new HomePageAction()
			//.navigateToLogin()
			//.loginSMB(userProfile)
			//.navigateToAccountSummaryPageSMB(userProfile)	
			.navigateToSMB()
			.forcedLoginOnlySMB(acquisition, userProfile)	
			.confirmSMBAddress()
			.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
			.reviewOrderPageNavigationSMB()
			.verifyThankYouPage(userProfile)
			.getEshopLeadIDSMB(userProfile)
			.getOAMdetailsSMB(userProfile); 
	}

/*
 *  *****************************************TC_Siebel_002********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void SiebelDualGCCECCSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_TC_02***************", "DONE");
	// SMB_Siebel_002
     String debt="YES";
     String accountType="MFDD";
     String GasAccount="CC";
     String Option="CCPayment";
         
	new HomePageAction()
			.navigateToSMB()
			.forcedLoginOnlySMB(acquisition, userProfile)	
			.confirmSMBAddress()
			.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
			.reviewOrderPageNavigationSMB()
			.verifyThankYouPage(userProfile)
			.getEshopLeadIDSMB(userProfile);	
	}

/*
 *  *****************************************TC_Siebel_003********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void SiebelDualGCCEDDSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_TC_03***************", "DONE");
	// SMB_Siebel_003
     String debt="NO";
     String accountType="MFDD";
     String GasAccount="CC";
     String Option="CCPayment";
         
	new HomePageAction()
			.navigateToSMB()
			.forcedLoginOnlySMB(acquisition, userProfile)	
			//.forcedRegistrationYourOrderPageSMB(acquisition, userProfile)
			.confirmSMBAddress()
			.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
			.reviewOrderPageNavigationSMB()
			.verifyThankYouPage(userProfile)
			.getEshopLeadIDSMB(userProfile);
}

/*
 *  *****************************************TC_Siebel_004********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void SiebelJIGCCECCSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"JIAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("JIAccount");
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_Siebel_TC_04***************", "DONE");
	// SMB_Siebel_004
     String debt="NO";
     String accountType="MFDD";
     String GasAccount="CC";
     String Option="DDPayment";
         
	new HomePageAction()
	
		//	.navigateToLogin()
			//.loginSMB(userProfile)
	//.navigateToAccountSummaryPageSMB(userProfile)
			.navigateToSMB()
			.forcedLoginOnlySMB(acquisition, userProfile)			
			.confirmSMBAddress()
			.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
			.reviewOrderPageNavigationSMB()
			.verifyThankYouPage(userProfile)
			.getEshopLeadIDSMB(userProfile);
}

/*
 *  *****************************************TC_Siebel_005********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void SiebelJIGDDECCSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"JIAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("JIAccount");
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_Siebel_TC_05***************", "DONE");
	// SMB_Siebel_005
     String debt="NO";
     String accountType="MFDD";
     String GasAccount="DD";
     String Option="DDPayment";
         
	new HomePageAction()
			//.navigateToLogin()
			//.loginSMB(userProfile)
			//.navigateToAccountSummaryPageSMB(userProfile)
			.navigateToSMB()
			.forcedLoginOnlySMB(acquisition, userProfile)		
			.confirmSMBAddress()
			.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
			.reviewOrderPageNavigationSMB()
			.verifyThankYouPage(userProfile)
			.getEshopLeadIDSMB(userProfile);
}

/*
 *  *****************************************TC_Siebel_006, TC_Siebel_007********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void SiebelduelGDDEDDSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_Siebel_TC_07***************", "DONE");
	// SMB_Siebel_006
     String debt="NO";
     String accountType="MFDD";
     String GasAccount="DD";
     String Option="DDPayment";
     //new OnlineDBConnector().deRegister(userProfile.getUCRN());    
	new HomePageAction()
			.navigateToSMB()
			.forcedLoginOnlySMB(acquisition, userProfile)
			//.forcedRegistrationYourOrderPageSMB(acquisition, userProfile)
			.confirmSMBAddress()
			.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
			.reviewOrderPageNavigationSMB()
			.verifyThankYouPage(userProfile)
			.getEshopLeadIDSMB(userProfile);
			//.getOAMdetailsSMB(userProfile);
		}

/*
 *  *****************************************TC_Siebel_008********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void SiebelduelGCCEDDSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_TC_08***************", "DONE");
	// SMB_Siebel_008
     String debt="NO";
     String accountType="MFDD";
     String GasAccount="CC";
     String Option="DDPayment";
         
	new HomePageAction()
			
			.navigateToSMB()
			//.forcedLoginOnlySMB(acquisition, userProfile)
			.forcedRegistrationYourOrderPageSMB(acquisition, userProfile)
			.confirmSMBAddress()
			.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
			.reviewOrderPageNavigationSMB()
			.verifyThankYouPage(userProfile)
			.getEshopLeadIDSMB(userProfile)           
			.getOAMdetailsSMB(userProfile);   
			
		}

/*
 *  *****************************************TC_Siebel_009********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void SiebeldualGDDECCSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_Siebel_TC_09***************", "DONE");
	// SMB_Siebel_009
     String debt="NO";
     String accountType="MFDD";
     String GasAccount="DD";
     String Option="DDPayment";
         
	new HomePageAction()
			//.navigateToLogin()
			//.loginSMB(userProfile)
			//.navigateToAccountSummaryPageSMB(userProfile)
			.navigateToSMB()
			.forcedLoginOnlySMB(acquisition, userProfile)
			.confirmSMBAddress()
			.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
			.reviewOrderPageNavigationSMB()
			.verifyThankYouPage(userProfile)
			.getEshopLeadIDSMB(userProfile);              
			
		}

/*
 *  *****************************************TC_Siebel_010********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void SiebelJIGDDEDDSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"JIAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("JIAccount");
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_Siebel_TC_10***************", "DONE");
	// SMB_Siebel_010
     String debt="NO";
     String accountType="MFDD";
     String GasAccount="DD";
     String Option="DDPayment";
         
	new HomePageAction()
			.navigateToSMB()
			.forcedLoginOnlySMB(acquisition, userProfile)
			.confirmSMBAddress()
			.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
			.reviewOrderPageNavigationSMB()
			.verifyThankYouPage(userProfile)
			.getEshopLeadIDSMB(userProfile);
		}

/*
 *  *****************************************TC_Siebel_011********************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void SiebelJIGDDMVDDSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"JIAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("JIAccount");
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_Siebel_TC_11***************", "DONE");
	// SMB_Siebel_011
     String debt="NO";
     String accountType="MVDD";
     String GasAccount="DD";
     String Option="DDPayment";
         
	new HomePageAction()
			//.navigateToLogin()
			//.loginSMB(userProfile)
			//.navigateToAccountSummaryPageSMB(userProfile)
			.navigateToSMB()
			.forcedLoginOnlySMB(acquisition, userProfile)			
			.confirmSMBAddress()
			.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
			.reviewOrderPageNavigationSMB()
			.verifyThankYouPage(userProfile)
			.getEshopLeadIDSMB(userProfile);
		}

/*
 *  *****************************************TC_Siebel_012********************************
 */
/*
@Test(groups = { FunctionalCategory.Acquisition })
public void SiebelduelGCCECCSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_TC_12***************", "DONE");
	// SMB_Siebel_012
     String debt="YES";
     String accountType="MFDD";
     String GasAccount="CC";
     String Option="CCPayment";
         
	new HomePageAction()
			.navigateToLogin()
			.loginSMB(userProfile)
			.navigateToAccountSummaryPageSMB(userProfile)
			.confirmSMBAddress()
			.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
			.reviewOrderPageNavigationSMB()
			.verifyThankYouPage(userProfile).verifyEshopLeadData()
			.getEshopLeadIDSMB(userProfile);
			
		}

*/
/*
 *  *****************************************TC_Siebel_Email_001*************************
 */

@Test(groups = { FunctionalCategory.Acquisition })
public void SiebelduelGCCECCEmailSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_TC_01***************", "DONE");
	// SMB_Siebel_001
     String debt="YES";
     String accountType="MFDD";
     String GasAccount="CC";
     String Option="CCPayment";
         
	new HomePageAction()
			.navigateToLogin()
			.loginSMB(userProfile)
			.navigateToAccountSummaryPageSMB(userProfile)
			.confirmSMBAddress()
			.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
			.reviewOrderPageNavigationSMB()
			.verifyThankYouPage(userProfile).verifyEshopLeadData()
			.getEshopLeadIDSMB(userProfile);
		}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////CRM Mastered users////////////////

/*
* *****************************************TC_CRM_001************************************
*/

@Test(groups = { FunctionalCategory.Acquisition })
public void CRMJIGCCECCSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"JIAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("JIAccount");
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_CRM_TC_01***************", "DONE");
	// SMB_CRM_01
     String debt="YES";
     String accountType="MVDD";
     String GasAccount="CC";
     String Option="CCPayment";
         
	new HomePageAction()
			.navigateToLogin()
			.loginSMB(userProfile)
			.navigateToAccountSummaryPageSMB(userProfile)
			.confirmSMBAddress()
			.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
			.reviewOrderPageNavigationSMB()
			.verifyThankYouPage(userProfile).verifyEshopLeadData()
			.getEshopLeadIDSMB(userProfile);
		}


/*
* *****************************************TC_CRM_002************************************
*/

@Test(groups = { FunctionalCategory.Acquisition })
public void CRMdualGCCECCSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_CRM_TC_02***************", "DONE");
	// SMB_CRM_02
     String debt="YES";
     String accountType="MVDD";
     String GasAccount="CC";
     String Option="CCPayment";
         
	new HomePageAction()
			.navigateToLogin()
			.loginSMB(userProfile)
			.navigateToAccountSummaryPageSMB(userProfile)
			.confirmSMBAddress()
			.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
			.reviewOrderPageNavigationSMB()
			.verifyThankYouPage(userProfile).verifyEshopLeadData()
			.getEshopLeadIDSMB(userProfile);
		}

/*
* *****************************************TC_CRM_003************************************
*/

@Test(groups = { FunctionalCategory.Acquisition })
public void CRMdualGCCEDDSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_CRM_TC_03***************", "DONE");
	// SMB_CRM_03
     String debt="YES";
     String accountType="MVDD";
     String GasAccount="CC";
     String Option="CCPayment";
         
	new HomePageAction()
		.navigateToSMB()
		.forcedRegistrationYourOrderPageSMB(acquisition, userProfile)
		.confirmSMBAddress()
		.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
		.reviewOrderPageNavigationSMB()
		.verifyThankYouPage(userProfile).verifyEshopLeadData()
		.getEshopLeadIDSMB(userProfile);
		}

/*
* *****************************************TC_CRM_004************************************
*/

@Test(groups = { FunctionalCategory.Acquisition })
public void CRMJIGCCEDDSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"JIAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("JIAccount");
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_CRM_TC_04***************", "DONE");
	// SMB_CRM_04
     String debt="YES";
     String accountType="MVDD";
     String GasAccount="CC";
     String Option="DDPayment";
         
	new HomePageAction()
			.navigateToSMB()
			.forcedRegistrationYourOrderPageSMB(acquisition, userProfile)
			.confirmSMBAddress()
			.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
			.reviewOrderPageNavigationSMB()
			.verifyThankYouPage(userProfile).verifyEshopLeadData()
			.getEshopLeadIDSMB(userProfile);
		}

/*
* *****************************************TC_CRM_005************************************
*/

@Test(groups = { FunctionalCategory.Acquisition })
public void CRMdualGDDECCSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_CRM_TC_05***************", "DONE");
	// SMB_CRM_05
     String debt="YES";
     String accountType="MVDD";
     String GasAccount="CC";
     String Option="DDPayment";
         
	new HomePageAction()
		.navigateToSMB()
		.forcedLoginOnlySMB(acquisition, userProfile)
		.confirmSMBAddress()
		.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
		.reviewOrderPageNavigationSMB()
		.verifyThankYouPage(userProfile).verifyEshopLeadData()
		.getEshopLeadIDSMB(userProfile);
		}

/*
* *****************************************TC_CRM_006************************************
*/

@Test(groups = { FunctionalCategory.Acquisition })
public void CRMdualGDDEDDSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_CRM_TC_06***************", "DONE");
	// SMB_CRM_06
     String debt="YES";
     String accountType="MVDD";
     String GasAccount="CC";
     String Option="DDPayment";
         
	new HomePageAction()
		.navigateToSMB()
		.forcedLoginOnlySMB(acquisition, userProfile)
		.confirmSMBAddress()
		.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
		.reviewOrderPageNavigationSMB()
		.verifyThankYouPage(userProfile).verifyEshopLeadData()
		.getEshopLeadIDSMB(userProfile);
		}

/*
* *****************************************TC_CRM_007************************************
*/

@Test(groups = { FunctionalCategory.Acquisition })
public void CRMdualGDDEDDReturnToAccountSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_CRM_TC_07***************", "DONE");
	// SMB_CRM_07
     String debt="YES";
     String accountType="MVDD";
     String GasAccount="CC";
     String Option="DDPayment";
         
	new HomePageAction()
		.navigateToSMB()
		.forcedLoginOnlySMB(acquisition, userProfile)
		.confirmSMBAddress()
		.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
		.reviewOrderPageNavigationSMB()
		.verifyThankYouPage(userProfile).verifyEshopLeadData()
		.getEshopLeadIDSMB(userProfile);
		}

/*
* *****************************************TC_CRM_008************************************
*/

@Test(groups = { FunctionalCategory.Acquisition })
public void CRMdualGCCEDDIneligibleSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_CRM_TC_08***************", "DONE");
	// SMB_CRM_08
     String debt="YES";
     String accountType="MVDD";
     String GasAccount="CC";
     String Option="DDPayment";
         
	new HomePageAction()
			.navigateToSMB()
			.forcedRegistrationYourOrderPageSMB(acquisition, userProfile)
			.confirmSMBAddress()
			.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
			.reviewOrderPageNavigationSMB()
			.verifyThankYouPage(userProfile).verifyEshopLeadData()
			.getEshopLeadIDSMB(userProfile);
		}

/*
* *****************************************TC_CRM_009************************************
*/

@Test(groups = { FunctionalCategory.Acquisition })
public void CRMdualGCCEDDeSmartSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_CRM_TC_09***************", "DONE");
	// SMB_CRM_09
     String debt="YES";
     String accountType="MVDD";
     String GasAccount="CC";
     String Option="DDPayment";
         
	new HomePageAction()
			.navigateToSMB()
			.forcedRegistrationYourOrderPageSMB(acquisition, userProfile)
			.confirmSMBAddress()
			.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
			.reviewOrderPageNavigationSMB()
			.verifyThankYouPage(userProfile).verifyEshopLeadData()
			.getEshopLeadIDSMB(userProfile);
		}

/*
* *****************************************TC_CRM_010************************************
*/

@Test(groups = { FunctionalCategory.Acquisition })
public void CRMdualGCCECCPaymentOverlaySMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_CRM_TC_10***************", "DONE");
	// SMB_CRM_10
     String debt="YES";
     String accountType="MFDD";
     String GasAccount="CC";
     String Option="DDPayment";
         
	new HomePageAction()
			.navigateToSMB()
			.forcedLoginOnlySMB(acquisition, userProfile)
			.confirmSMBAddress()
			.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
			.reviewOrderPageNavigationSMB()
			.verifyThankYouPage(userProfile).verifyEshopLeadData()
			.getEshopLeadIDSMB(userProfile);
	}
		

/*
* *****************************************TC_CRM_011************************************
*/

@Test(groups = { FunctionalCategory.Acquisition })
public void CRMSingleTrillantSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.ReFactoring_SMB_supplyaddresstempErrorCode);
	Report.updateTestLog(
			"************SmartMonthlyBilling_CRM_TC_11***************", "DONE");
	// SMB_CRM_11

         
	new HomePageAction()
			.navigateToLogin()
			.loginSMB(userProfile)
			.navigateToSMBnegativetemp(errList);
	}

/*
* *****************************************TC_CRM_012************************************
*/

@Test(groups = { FunctionalCategory.Acquisition })
public void CRMdualGDDECCMultipleAddressSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_CRM_TC_12***************", "DONE");
	// SMB_CRM_12
	 String debt="NO";
     String accountType="MFDD";
     String GasAccount="CC";
     String Option="CCPayment";
         
	new HomePageAction()
			.navigateToSMB()
			.forcedLoginOnlySMB(acquisition, userProfile)
			.confirmSMBAddress()
			.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
			.reviewOrderPageNavigationSMB()
			.verifyThankYouPage(userProfile).verifyEshopLeadData()
			.getEshopLeadIDSMB(userProfile);
	}



//////////////////////////////////////////////////////////////////////////////////////////////////////////////Error Messages////////////////

/*
* *****************************************TC_Error_01************************************
*/
@Test(groups = { FunctionalCategory.Acquisition })
public void LandingPageerrorSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"Error validation for Login Screen");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.ReFactoring_SMB_LoginDetailsErrorCode);
	//ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.ReFactoring_SMB_LoginDetailsErrorCode);
	Report.updateTestLog(
			"************SmartMonthlyBilling_Error_TC_001***************", "DONE");
	// SMB_Negative_001
	        
	new HomePageAction()
			.navigateToSMB()		
			.verifyforcelogindetailsSMB(userProfile, errList);	
	new HomePageAction()
			.navigateToSMB()	
			.verifyforceregistrationdetailsSMB(userProfile, errList);		
	}

/*
* *****************************************TC_Error_02************************************
*/
@Test(groups = { FunctionalCategory.Acquisition })
public void SupplyaddressPageerrorSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"Error validation for Supply Address Screen");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.ReFactoring_SMB_supplyaddressErrorCode);
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_Error_TC_002***************", "DONE");
	// SMB_Negative_001
	        
	new HomePageAction()
			.navigateToSMB()		
			.forcedLoginOnlySMB(acquisition, userProfile)
			.verifysupplyaddressSMB(userProfile, errList);
					
	}

/*
* *****************************************TC_Error_04************************************
*/
@Test(groups = { FunctionalCategory.Acquisition })
public void BankdetailserrorSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"Error validation for Bank Details Screen");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.ReFactoring_SMB_BankDetailsErrorCode); 
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_Error_TC_004***************", "DONE");
	// SMB_Negative_004
	 /*String debt="NO";
     String accountType="MFDD";
     String GasAccount="CC";
     String Option="DDPayment";*/         
	
     new HomePageAction()
			.navigateToSMB()
			.forcedLoginOnlySMB(acquisition, userProfile)
			.confirmSMBAddress()
			//.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
			.verifyBankdetailsSMB(userProfile, errList);
	}

/*
* *****************************************TC_Error_03************************************
*/
@Test(groups = { FunctionalCategory.Acquisition })
public void PaymentdetailserrorSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"Error validation for Payment Screen");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.ReFactoring_SMB_PaymentDetailsErrorCode);
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_Error_TC_003***************", "DONE");
	// SMB_Negative_003
	 String debt="Yes";
     String accountType="MFDD";
     String GasAccount="CC";
     String Option="CCPayment";
         
	new HomePageAction()
			.navigateToSMB()			
			.forcedLoginOnlySMB(acquisition, userProfile)
			.confirmSMBAddress()
			//.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
			.verifyPaymentdetailsSMB(userProfile, errList);
	}

/*
* *****************************************TC_Error_05************************************
*/
@Test(groups = { FunctionalCategory.Acquisition })
public void RevieworderdetailserrorSMB() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"Error validation for Review Order Screen");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");
	
	
	Report.updateTestLog(
			"************SmartMonthlyBilling_Error_TC_005***************", "DONE");
	// SMB_Negative_005
	 String debt="NO";
     String accountType="MFDD";
     String GasAccount="CC";
     String Option="DDPayment";
     ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.ReFactoring_SMB_ReviewOrderErrorCode);  
	new HomePageAction()
			.navigateToSMB()
			.forcedLoginOnlySMB(acquisition, userProfile)
			.confirmSMBAddress()
			.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
			//.reviewOrderPageNavigationSMB()			
			.verifyRevieworderdetailsSMB(userProfile, errList);
	}




//Regression SMB scenarios - Energy shop Conversion
@Test(groups = {Regression })
public void ConversionDualFixedPriceJune2014() {

  Report.createTestLogHeader("Conversion  - Energy Shop", "Conversion Dual Fixed Price June 2013");
  final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
  final UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
  //getCustomerDetailsToUserProfileOAM(userProfile);
  new HomePageAction()
          .navigateToLogin()
          .login(userProfile)                
          .navigateToGasAndElectricityPage()
          .navigateToOurTariffsPage()
          .navigateToFixedPriceMay2014()
          .navigateToDualOrderPage()
          .yourOrderDualBG(acquisition,userProfile)
          .reviewOrderPageNavigation()
          .verifyThankYouPage(userProfile)
          .verifyEshopLeadData()
          .verifyAuditEventID(userProfile)
          .logoutFromConvThankYouPage()
          .changeTariff(userProfile.getGasAccount())
          .changeTariff(userProfile.getElecAccount());
}

//Regression - Account Summary
@Test(groups = { Regression })
public void duelFuelAccountSummarySMB() {

	Report.createTestLogHeader("Smart Monthly Billing - Account Summary","DualAccount");	
	final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");

	String debt="NO";
    String accountType="MVDD";
    String GasAccount="DD";
    String Option="DDPayment";
        
	new HomePageAction()
			.navigateToSMB()
			.forcedLoginOnlySMB(acquisition, userProfile)
			.confirmSMBAddress()
			.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
			.reviewOrderPageNavigationSMB()
			.verifyThankYouPage(userProfile)
			.gobacktoaccountsummarypageSMB(userProfile)
			.getEshopLeadIDSMB(userProfile);
		}

//Regression - E smart verification
@Test(groups = { Regression})
public void conversionCTDualFixFall() {
	Report.createTestLogHeader("Esmart for SMB","Smart Monthly Billing  - Dual Account");
	final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");

	acquisition.setTarifffordual(acquisition.gettariffClearSimple());
	new HomePageAction().navigateToLogin().login(userProfile)
			.navigateToProductAndServicesPage()
			.navigateToGasAndElectricityPage()
			.navigateToOurTariffsPage()
			.navigateToFixedPriceMay2014()
			.navigateToEnergySmartDualOrderPage()
			.yourOrderDualBG(acquisition, userProfile)
			.Verifyesmarterrormessage();
    }

//Regression  - Predict Next Bill verification
@Test(groups={Regression})
public void predictNextBillForJI() throws IOException
{
	Report.createTestLogHeader("PredictNextBill", "For Smart Meter Energy Account");
	UserProfile userProfile= new TestDataHelper().getUserProfile("JIAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile)
				.navigateToPredictNextBill("EnergyUsage",userProfile)
				.verifyPNBPageLinks()
				.verifyWhatsThisLink()
				.verifyPredictedBillPage()
				.pnbLogout();
	/*Report.createTestLogHeader("PredictNextBill", "For Energy smart and trilliant JIAccount");
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
	.pnbLogout();*/
}

// Regression - Payment History Page
@Test(groups = { Regression })
public void duelFuelAccountSummaryPaymentHistorySMB() {

	Report.createTestLogHeader("Smart Monthly Billing - Account Summary","DualAccount");	
	final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");

	String debt="YES";
    String accountType="MVDD";
    String GasAccount="CC";
    String Option="DDPayment";
        
	new HomePageAction()
			.navigateToSMB()
			.forcedRegistrationYourOrderPageSMB(acquisition, userProfile)
			.confirmSMBAddress()
			.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
			.reviewOrderPageNavigationSMB()
			.verifyThankYouPage(userProfile).verifyEshopLeadData()
			.getEshopLeadIDSMB(userProfile);
		}





/*--------------------------------------------------------------SMB Phase 2-----------------------------------------------------------------*/


/*Journey - SMB Targetting 
Test Case - FR14.02_01
*/

@Test(groups = { FunctionalCategory.Acquisition })
public void SMBTargetting(){

	Report.createTestLogHeader("Smart Monthly Billing","SMB Targetting");
	
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");

	Report.updateTestLog(
			"************SmartMonthlyBilling_Negative_TC_016***************", "DONE");
	// SMB_Negative_016
		new HomePageAction()
			.navigateToLogin()
			.loginSMB(userProfile)
			.navigateToAccountSummaryPageSMB(userProfile);
			//.AccSumSMBPromotionalMsg();
		new ViewBillAction();
			//.clickViewLatestBill()
			//.verifySMBPromotionalMsgVBill();
			}
		

/*-----------------------------------------------------------------SMB Trilliant Eligibility Rules - Trilliant Single fuel---------------------------------------------------*/


@Test(groups = { FunctionalCategory.Acquisition })
public void singleFuelBillingBlockTrilliantSMB() {

	Report.createTestLogHeader("Smart Monthly Billing","verify Single Fuel Trilliant user is not able to upgrade to SMB when the status of the account is Billing Block");
	
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("FuelDirect");
		Report.updateTestLog(
			"************SmartMonthlyBilling_Negative_TC_01***************", "DONE");
	
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile);
			new SmartMonthlyBillingAction()
				.navigateToSMB()
				.verifyTrilliantErrorMsg();
			new HomePageAction()
				.navigateToLogout();
		final Acquisition acquisition1 = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile1 = new TestDataHelper().getUserProfile("InvoiceBlock");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile1);
			new SmartMonthlyBillingAction()
				.navigateToSMB()
				.verifyTrilliantErrorMsg();
			new HomePageAction()
				.navigateToLogout();
		final Acquisition acquisition2 = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile2 = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile2);
			new SmartMonthlyBillingAction()
				.navigateToSMB()
				.verifyTrilliantErrorMsg();
			new HomePageAction()
				.navigateToLogout();
		final Acquisition acquisition3 = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile3 = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile3);
			new SmartMonthlyBillingAction()
				.navigateToSMB()
				.verifyTrilliantErrorMsg();
			new HomePageAction()
				.navigateToLogout();
		final Acquisition acquisition4 = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile4 = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile4);
			new SmartMonthlyBillingAction()
				.navigateToSMB()
				.verifyTrilliantErrorMsg();
			new HomePageAction()
				.navigateToLogout();
		final Acquisition acquisition5 = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile5 = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile5);
			new SmartMonthlyBillingAction()
				.navigateToSMB()
				.verifyTrilliantErrorMsg();
			new HomePageAction()
				.navigateToLogout();
		final Acquisition acquisition6 = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile6 = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile);
			new SmartMonthlyBillingAction()
				.navigateToSMB()
				.verifyTrilliantErrorMsg();
			new HomePageAction()
				.navigateToLogout();
		final Acquisition acquisition7 = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile7 = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile);
			new SmartMonthlyBillingAction()
				.navigateToSMB()
				.verifyTrilliantErrorMsg();
			new HomePageAction()
				.navigateToLogout();
		final Acquisition acquisition8 = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile8 = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile);
			new SmartMonthlyBillingAction()
				.navigateToSMB()
				.verifyTrilliantErrorMsg();
			new HomePageAction()
				.navigateToLogout();
		
	}		

@Test(groups = { FunctionalCategory.Acquisition })
public void SMBEligibilityLogica() {

	Report.createTestLogHeader("Smart Monthly Billing","verify Single Fuel Trilliant user is not able to upgrade to SMB when the status of the account is Billing Block");
	
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("FuelDirect");
		Report.updateTestLog(
			"************SmartMonthlyBilling_Negative_TC_01***************", "DONE");
	
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile);
			new SmartMonthlyBillingAction()
				.navigateToSMB()
				.verifyTrilliantErrorMsg();
			new HomePageAction()
				.navigateToLogout();
		final Acquisition acquisition1 = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile1 = new TestDataHelper().getUserProfile("InvoiceBlock");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile1);
			new SmartMonthlyBillingAction()
				.navigateToSMB()
				.verifyTrilliantErrorMsg();
			new HomePageAction()
				.navigateToLogout();
		final Acquisition acquisition2 = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile2 = new TestDataHelper().getUserProfile("ImpausibleReadExists");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile2);
			new SmartMonthlyBillingAction()
				.navigateToSMB()
				.verifyTrilliantErrorMsg();
			new HomePageAction()
				.navigateToLogout();
		final Acquisition acquisition3 = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile3 = new TestDataHelper().getUserProfile("PrepaymentError");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile3);
			new SmartMonthlyBillingAction()
				.navigateToSMB()
				.verifyTrilliantErrorMsg();
			new HomePageAction()
				.navigateToLogout();
		final Acquisition acquisition4 = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile4 = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile4);
			new SmartMonthlyBillingAction()
				.navigateToSMB()
				.verifyTrilliantErrorMsg();
			new HomePageAction()
				.navigateToLogout();
		final Acquisition acquisition5 = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile5 = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile5);
			new SmartMonthlyBillingAction()
				.navigateToSMB()
				.verifyTrilliantErrorMsg();
			new HomePageAction()
				.navigateToLogout();
		final Acquisition acquisition6 = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile6 = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile6);
			new SmartMonthlyBillingAction()
				.navigateToSMB()
				.verifyTrilliantErrorMsg();
			new HomePageAction()
				.navigateToLogout();
		final Acquisition acquisition7 = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile7 = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile7);
			new SmartMonthlyBillingAction()
				.navigateToSMB()
				.verifyTrilliantErrorMsg();
			new HomePageAction()
				.navigateToLogout();
		final Acquisition acquisition8 = new TestDataHelper()
		.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile8 = new TestDataHelper().getUserProfile("GasAccount");
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile8);
			new SmartMonthlyBillingAction()
				.navigateToSMB()
				.verifyTrilliantErrorMsg();
			new HomePageAction()
				.navigateToLogout();
			final Acquisition acquisition9 = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
			final UserProfile userProfile9 = new TestDataHelper().getUserProfile("GasAccount");
				new HomePageAction()
					.navigateToLogin()
					.login(userProfile9);
				new SmartMonthlyBillingAction()
					.navigateToSMB()
					.verifyTrilliantErrorMsg();
				new HomePageAction()
					.navigateToLogout();
				final Acquisition acquisition10 = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
				final UserProfile userProfile10 = new TestDataHelper().getUserProfile("GasAccount");
					new HomePageAction()
						.navigateToLogin()
						.login(userProfile10);
					new SmartMonthlyBillingAction()
						.navigateToSMB()
						.verifyTrilliantErrorMsg();
					new HomePageAction()
						.navigateToLogout();
		}	


/*@Test(groups = { FunctionalCategory.Acquisition })
		public void singleFuelChangeBillDate() {

	Report.createTestLogHeader("Smart Monthly Billing","verify Single Fuel SMB registered user is able to change the bill date");
	
	//final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper().getUserProfile("NormalCust");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile);
	}*/

@Test(groups = { FunctionalCategory.Acquisition })
public void SFuelFirstBillNotifcn() {

	Report.createTestLogHeader("Smart Monthly Billing","verify Single Fuel SMB registered user is is displayed with the first bill notification");
	//final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper().getUserProfile("NormalCust");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile);
		new AccOverviewAction();
			//.clickManageAccount()
			//.viewLatestStatement();
	}


@Test(groups = { FunctionalCategory.Acquisition })
public void DFuelFirstBillNotifcn() {

	Report.createTestLogHeader("Smart Monthly Billing","verify Dual Fuel SMB registered user is is displayed with the first bill notification");
	//final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper().getUserProfile("NormalCust");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile);
		new AccOverviewAction();
			//.clickManageAccount()
			//.viewLatestStatement();
	}

@Test(groups = { FunctionalCategory.Acquisition })
public void JIFuelFirstBillNotifcn() {

	Report.createTestLogHeader("Smart Monthly Billing","verify Dual Fuel SMB registered user is is displayed with the first bill notification");
	//final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper().getUserProfile("NormalCust");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile);
		new AccOverviewAction();
			//.clickManageAccount()
			//.viewLatestStatement();
	}

@Test(groups = { FunctionalCategory.Acquisition })
public void DOneFuelFirstBillNotifcn() {

	Report.createTestLogHeader("Smart Monthly Billing","verify Dual Fuel SMB registered user is is displayed with the first bill notification");
	//final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper().getUserProfile("NormalCust");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile);
		new AccOverviewAction();
			//.clickManageAccount()
			//.viewLatestStatement();
	}


/*-------------------------------------------------------------------------Logica Meters - Eligible for SMB-----------------------------------------------------------*/

@Test(groups = { FunctionalCategory.Acquisition })
public void singleCustLogicaSMB() {

	Report.createTestLogHeader("Smart Monthly Billing","To verify if a single fuel BG smart metered Logica head end user is successfully able to upgrade to SMB");
	final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper().getUserProfile("LogicaSingleGAs");
	
	String debt="NO";
    String accountType="MVDD";
    String GasAccount="DD";
    String Option="DDPayment";
	
	/*	new HomePageAction()
			.navigateToLogin()
			.login(userProfile);*/
		new AccOverviewAction();
			/*.clickManageAccount()*/
			//.openSMBUrl();
		new LoginAction()
			.login(userProfile);
		new AccountSummaryAction()
			.confirmSMBAddress()
		.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
		.reviewOrderPageNavigationSMB()
		.verifyThankYouPage(userProfile)
		.getEshopLeadIDSMB(userProfile)
		.getOAMdetailsSMB(userProfile);
	}

@Test(groups = { FunctionalCategory.Acquisition })
public void dualCustLogicaSMB() {

	Report.createTestLogHeader("Smart Monthly Billing","To verify if a dual fuel BG smart metered with Logica head end for 1 account and Trilliant for the other is successfully able to upgrade to SMB for both the accounts.");
	final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper().getUserProfile("SMBCust");
	
	String debt="NO";
    String accountType="CCPAY";
    String GasAccount="CC";
    String Option="DDPayment";
	
	/*	new HomePageAction()
			.navigateToLogin()
			.login(userProfile);*/
		new AccOverviewAction();
			/*.clickManageAccount()*/
			//.openSMBUrl();
		new LoginAction()
			.login(userProfile);
		new AccountSummaryAction()
			.confirmSMBAddress()
		.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
		.reviewOrderPageNavigationSMB()
		.verifyThankYouPage(userProfile);
	}

@Test(groups = { FunctionalCategory.Acquisition })
public void JICustLogicaSMB() {

	Report.createTestLogHeader("Smart Monthly Billing","To verify if a Joint Invoice BG smart metered with Logica head end  is successfully able to upgrade to SMB for both the accounts. ");
	final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper().getUserProfile("SMBCust");
	
	String debt="NO";
    String accountType="CCPAY";
    String GasAccount="CC";
    String Option="DDPayment";
	
	/*	new HomePageAction()
			.navigateToLogin()
			.login(userProfile);*/
		new AccOverviewAction();
			/*.clickManageAccount()*/
			//.openSMBUrl();
		new LoginAction()
			.login(userProfile);
		new AccountSummaryAction()
			.confirmSMBAddress()
		.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
		.reviewOrderPageNavigationSMB()
		.verifyThankYouPage(userProfile);
	}

/*-------------------------------------------------------------------Defaulted to Monthly---------------------------------------------------------------------*/

@Test(groups = { FunctionalCategory.Acquisition })
public void highRiskSMBSignUp() {

	Report.createTestLogHeader("SMB Defaulted to Monthly","To verify if a high risk Cash Cheque Smart customer defaulted to monthly billing by SMB upgradation.");
	final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper().getUserProfile("SMBCust");
	
	String debt="NO";	
    String accountType="CCPAY";
    String GasAccount="CC";
    String Option="DDPayment";
	
	/*	new HomePageAction()
			.navigateToLogin()
			.login(userProfile);*/
		new AccOverviewAction();
			/*.clickManageAccount()*/
			//.openSMBUrl();
		new LoginAction()
			.login(userProfile);
		new AccountSummaryAction()
			.confirmSMBAddress()
		.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
		.reviewOrderPageNavigationSMB()
		.verifyThankYouPage(userProfile);
	}

@Test(groups = { FunctionalCategory.Acquisition })
public void medRiskSMBSignUp() {

	Report.createTestLogHeader("SMB Defaulted to Monthly","To verify if a Medium risk Cash Cheque Smart customer defaulted to monthly billing by SMB upgradation.");
	final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper().getUserProfile("SMBCust");
	
	String debt="Yes";	
    String accountType="CCPAY";
    String GasAccount="CC";
    String Option="CCPayment";
	
	/*	new HomePageAction()
			.navigateToLogin()
			.login(userProfile);*/
		new AccOverviewAction();
			/*.clickManageAccount()*/
			//.openSMBUrl();
		new LoginAction()
			.login(userProfile);
		new AccountSummaryAction()
			.confirmSMBAddress()
		.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
		.reviewOrderPageNavigationSMB()
		.verifyThankYouPage(userProfile);
	}

@Test(groups = { FunctionalCategory.Acquisition })
public void lowRiskSMBSignUp() {

	Report.createTestLogHeader("SMB Defaulted to Monthly","To verify if a low risk Cash Cheque Smart customer defaulted to monthly billing by SMB upgradation.");
	final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper().getUserProfile("SMBCust");
	
	String debt="NO";	
    String accountType="CCPAY";
    String GasAccount="CC";
    String Option="DDPayment";
	
	/*	new HomePageAction()
			.navigateToLogin()
			.login(userProfile);*/
		new AccOverviewAction();
			/*.clickManageAccount()*/
			//.openSMBUrl();
		new LoginAction()
			.login(userProfile);
		new AccountSummaryAction()
			.confirmSMBAddress()
		.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
		.reviewOrderPageNavigationSMB()
		.verifyThankYouPage(userProfile);
	}
/*--------------------------------------------------------------------Logica Migration - Continue SMB----------------------------------------------------------------*/


@Test(groups = { FunctionalCategory.Acquisition })
public void singleMigrationSMBSignUp() {

	Report.createTestLogHeader("SMB Logica Migration","To verify if a Single fuel Gas or Elec BG Smart metered customer migrated from Trilliant to Logica sign up SMB.");
	final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper().getUserProfile("SMBCust");
	
	String debt="NO";	
    String accountType="CCPAY";
    String GasAccount="CC";
    String Option="DDPayment";
	
	/*	new HomePageAction()
			.navigateToLogin()
			.login(userProfile);*/
		new AccOverviewAction();
			/*.clickManageAccount()*/
			//.openSMBUrl();
		new LoginAction()
			.login(userProfile);
		new AccountSummaryAction()
			.confirmSMBAddress()
		.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
		.reviewOrderPageNavigationSMB()
		.verifyThankYouPage(userProfile);
	}

@Test(groups = { FunctionalCategory.Acquisition })
public void dualMigrationSMBSignUp() {

	Report.createTestLogHeader("SMB Logica Migration","To verify if a Dual fuel Gas or Elec BG Smart metered customer migrated from Trilliant to Logica sign up SMB.");
	final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper().getUserProfile("SMBCust");
	
	String debt="NO";	
    String accountType="CCPAY";
    String GasAccount="CC";
    String Option="DDPayment";
	
	/*	new HomePageAction()
			.navigateToLogin()
			.login(userProfile);*/
		new AccOverviewAction();
			/*.clickManageAccount()*/
			//.openSMBUrl();
		new LoginAction()
			.login(userProfile);
		new AccountSummaryAction()
			.confirmSMBAddress()
		.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
		.reviewOrderPageNavigationSMB()
		.verifyThankYouPage(userProfile);
	}

@Test(groups = { FunctionalCategory.Acquisition })
public void JIMigrationSMBSignUp() {

	Report.createTestLogHeader("SMB Logica Migration","To verify if a Single fuel Gas or Elec BG Smart metered customer migrated from Trilliant to Logica sign up SMB.");
	final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper().getUserProfile("SMBCust");
	
	String debt="NO";	
    String accountType="CCPAY";
    String GasAccount="CC";
    String Option="DDPayment";
	
	/*	new HomePageAction()
			.navigateToLogin()
			.login(userProfile);*/
		new AccOverviewAction();
			/*.clickManageAccount()*/
			//.openSMBUrl();
		new LoginAction()
			.login(userProfile);
		new AccountSummaryAction()
			.confirmSMBAddress()
		.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
		.reviewOrderPageNavigationSMB()
		.verifyThankYouPage(userProfile);
	}


@Test(groups = { FunctionalCategory.Acquisition })
public void sampletest() {

	Report.createTestLogHeader("SMB Logica Migration","To verify if a Single fuel Gas or Elec BG Smart metered customer migrated from Trilliant to Logica sign up SMB.");
	final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper().getUserProfile("samplecust");
	
	String debt="NO";	
    String accountType="MVDD";
    String GasAccount="DD";
    String Option="DDPayment";
	
	/*	new HomePageAction()
			.navigateToLogin()
			.login(userProfile);*/
		new AccOverviewAction();
			/*.clickManageAccount()*/
			//.openSMBUrl();
		new LoginAction()
			.login(userProfile);
		/*new AccountSummaryAction()
			.confirmSMBAddress()
		.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
		.reviewOrderPageNavigationSMB()
		.verifyThankYouPage(userProfile);*/
	}
/*-----------------------------------------------------------------Change Bill Date-------------------------------------*/
@Test(groups = { FunctionalCategory.Acquisition })
public void singleFuelChangeBillDate() {

	Report.createTestLogHeader("SMB Change Bill Date","To verify if a single fuel SMB user is able to change the bill date.");
	final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper().getUserProfile("LogicaSingleGAs");
	new HomePageAction()
			.navigateToLogin()
			.login(userProfile);
		new AccOverviewAction();
			//.clickManageAccount()
			//.clickChangeBillDate()
			//.selectDateDropDown()
			//.clickSubmitButton()
			//.validateChangeBillDate()	
			//.ChangebillDateDB();
		new HomePageAction()
		.logout();
	}
/*-------------------------------------------------------------------------Dual Fuel Scenarios-----------------------------------------------------------*/

@Test(groups = { FunctionalCategory.Acquisition })
public void duelFuelCust() {

	Report.createTestLogHeader("Smart Monthly Billing","To verify if a single fuel BG smart metered Logica head end user is successfully able to upgrade to SMB");
	final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper().getUserProfile("SingleGasAcc");
	
	String debt="NO";
    String accountType="CCPAY";
    String GasAccount="CC";
    String Option="DDPayment";
		/*	new HomePageAction()
			.navigateToLogin()
			.login(userProfile);*/
		new AccOverviewAction();
			/*.clickManageAccount()*/
			//.openSMBUrl();
		new LoginAction()
			.login(userProfile);
		new AccountSummaryAction()
			.confirmSMBAddress()
		.enterPaymentOptionsSMB(acquisition, debt, accountType,GasAccount, Option)
		.reviewOrderPageNavigationSMB()
		.verifyThankYouPage(userProfile);
	}



/*--------------------------------------------- RMR Changes -----------------------------------------------*/


@Test(groups = { FunctionalCategory.Acquisition })
public void verifyTCRValueForElectricityCustomer(){
	Report.createTestLogHeader("Smart Monthly Billing","To verify TCR value for electricity customer");
	final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
	String acctType = "MVDD";
	String paymentType ="payNow";
	
}
}









/*
@Test(groups = { FunctionalCategory.Acquisition })
public void annonymousForceRegistrationForDualAccount() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");

	Report.updateTestLog(
			"************SmartMonthlyBilling_TC_NUM***************", "DONE");
	// Pure Acquisition_ES_27

	new HomePageAction()
			.navigateToSMB()
			.forcedRegistrationYourOrderPageSMB(acquisition, userProfile)
			//.forcedLoginOnly(acquisition, userProfile)
			.confirmSMBAddress()
			.enterPaymentOptions(acquisition)
			.reviewOrderPageNavigation()
			.verifyThankYouPage(userProfile).verifyEshopLeadData()
			.getEshopLeadID().deleteWTP(userProfile);
}

@Test(groups = { FunctionalCategory.Acquisition })
public void annonymousForceLoginForDualAccount() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"DualAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("DualAccount");

	Report.updateTestLog(
			"************SmartMonthlyBilling_TC_NUM***************", "DONE");
	// Pure Acquisition_ES_27

	new HomePageAction()
			.navigateToSMB()
			//.forcedRegistrationYourOrderPage(acquisition, userProfile)
			.forcedLoginOnlySMB(acquisition, userProfile)
			.confirmSMBAddress()
			.enterPaymentOptions(acquisition)
			.reviewOrderPageNavigation()
			.verifyThankYouPage(userProfile).verifyEshopLeadData()
			.getEshopLeadID().deleteWTP(userProfile);
}

@Test(groups = { FunctionalCategory.Acquisition })
public void annonymousForceRegistrationForJIAccount() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"JIAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("JIAccount");

	Report.updateTestLog(
			"************SmartMonthlyBilling_TC_NUM***************", "DONE");
	// Pure Acquisition_ES_27

	new HomePageAction()
			.navigateToSMB()
			.forcedRegistrationYourOrderPageSMB(acquisition, userProfile)
			//.forcedLoginOnly(acquisition, userProfile)
			.confirmSMBAddress()
			.enterPaymentOptions(acquisition)
			.reviewOrderPageNavigation()
			.verifyThankYouPage(userProfile).verifyEshopLeadData()
			.getEshopLeadID().deleteWTP(userProfile);
}

@Test(groups = { FunctionalCategory.Acquisition })
public void annonymousForceLoginForJIAccount() {

	Report.createTestLogHeader("Smart Monthly Billing",
			"JIAccount");
	final Acquisition acquisition = new TestDataHelper()
			.getAcquisitionData("standardDualAcquisition");
	final UserProfile userProfile = new TestDataHelper()
			.getUserProfile("JIAccount");

	Report.updateTestLog(
			"************SmartMonthlyBilling_TC_NUM***************", "DONE");
	// Pure Acquisition_ES_27

	

	new HomePageAction()
			.navigateToSMB()
			//.forcedRegistrationYourOrderPage(acquisition, userProfile)
			.forcedLoginOnlySMB(acquisition, userProfile)
			.confirmSMBAddress()
			.enterPaymentOptions(acquisition)
			.reviewOrderPageNavigation()
			.verifyThankYouPage(userProfile).verifyEshopLeadData()
			.getEshopLeadID().deleteWTP(userProfile);
}*/
