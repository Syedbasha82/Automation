package bg.framework.app.functional.test.reFactoring;

import static bg.framework.app.functional.entities.FunctionalCategory.Acquisition;
import static bg.framework.app.functional.entities.FunctionalCategory.BG;
import static bg.framework.app.functional.entities.FunctionalCategory.Complex;
import static bg.framework.app.functional.entities.FunctionalCategory.Conversion;
import static bg.framework.app.functional.entities.FunctionalCategory.GAP;
import static bg.framework.app.functional.entities.FunctionalCategory.Qtp;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import static bg.framework.app.functional.entities.FunctionalCategory.Zeus;

import java.util.ArrayList;

import oracle.net.resolver.NavAddress;

import org.testng.annotations.Test;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.sales.AcquisitionAction;
import bg.framework.app.functional.action.sales.GetAPriceAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.FunctionalCategory;
import bg.framework.app.functional.entities.GetAPrice;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.GlobalErrorMessages;
import bg.framework.app.functional.page.sales.ThankYouPage;
import bg.framework.app.functional.page.sales.YourOrderPage;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SiebelDataBase;
import bg.framework.app.functional.util.TestDataHelper;

public class EsmartTest extends TestBase {
	
	/*
	 * ------------------------------------------------------------------------------------Regression Test Cases
	 */
	
	/*
	 * -----------------------------------------------------------------Pure Acquisition
	 */
	@Test(groups = { FunctionalCategory.Acquisition })
	public void clearAndSimpleAcquisition() {

		Report.createTestLogHeader("Clear And Simple Acquisition",
				"Dual , Gas , Electricity");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("NewUser");

		Report.updateTestLog(
				"************Pure Acquisition_ES_27***************", "DONE");
		// Pure Acquisition_ES_27

		userProfile.setNectarValue("3");
		acquisition.setGasSupplier("EDF Energy");
		acquisition.setFuelType("dual");
		acquisition.setPaymentType("MonthlyDD");
		acquisition.setCurrentElecSupplier("Single Rate Credit");

		new HomePageAction()

		.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple()
				.navigateToEnergySmartDualOrderPage()
				.yourOrderAnonymousNavigation(acquisition, userProfile)
				.enterPersonalDetailsPage(acquisition, userProfile)
				.enterCurrentServices(acquisition).enterPaymentOptions(
						acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.getEshopLeadID().deleteWTP(userProfile);

		/***********************************************************************
		 * 
		 * 
		 * Remaining TC's of ESMART
		 * 
		 * 
		 **********************************************************************/
		/*
		 * Report.updateTestLog("************Pure
		 * Acquisition_ES_01***************", "DONE"); // Pure Acquisition_ES_01
		 * new OnlineDBConnector().deRegister(userProfile.getUCRN());
		 * userProfile.setNectarValue("1"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyVariableDirectDebit");
		 * acquisition.setCurrentGasSupplier("Credit Meter"); new
		 * HomePageAction()
		 * 
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToClearAndSimple() .navigateToEnergySmartGasOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .enterPaymentOptions(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .verifyEshopLeadData() .getEshopLeadID()
		 * .verifyAuditEventID(userProfile)
		 * .domarssalesRunBatch(acquisition.getShopBatch())
		 * .checkMediaCode(acquisition.getGasCsCode()) .deleteWTP(userProfile);
		 * 
		 * 
		 * Report.updateTestLog("************Pure
		 * Acquisition_ES_03***************", "DONE"); //Pure Acquisition_ES_03
		 * new OnlineDBConnector().deRegister(userProfile.getUCRN());
		 * userProfile.setNectarValue("3"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter"); new
		 * HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToClearAndSimple()
		 * .navigateToEnergySmartGasOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .enterPaymentOptions(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .verifyEshopLeadData() .getEshopLeadID() .deleteWTP(userProfile);
		 * 
		 * Report.updateTestLog("************Pure
		 * Acquisition_ES_04***************", "DONE"); //Pure Acquisition_ES_04
		 * userProfile.setNectarValue("4"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter"); new
		 * HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToClearAndSimple()
		 * .navigateToEnergySmartGasOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .enterPaymentOptions(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .verifyEshopLeadData() .getEshopLeadID() .deleteWTP(userProfile) ;
		 * 
		 * Report.updateTestLog("************Pure
		 * Acquisition_ES_13***************", "DONE"); // Pure Acquisition_ES_13
		 * userProfile.setNectarValue("1");
		 * 
		 * acquisition.setGasSupplier("EDF Energy");
		 * acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyVariableDirectDebit");
		 * acquisition.setCurrentElecSupplier("Single Rate Credit"); new
		 * HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToClearAndSimple()
		 * .navigateToEnergySmartGasOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .enterPaymentOptions(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .verifyEshopLeadData() .getEshopLeadID() .deleteWTP(userProfile) ;
		 * Report.updateTestLog("************Pure
		 * Acquisition_ES_14***************", "DONE"); // Pure Acquisition_ES_14
		 * userProfile.setNectarValue("3");
		 * 
		 * acquisition.setGasSupplier("EDF Energy");
		 * acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentElecSupplier("Two Rate / Economy 7 Credit");
		 * new HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToClearAndSimple()
		 * .navigateToEnergySmartGasOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .enterPaymentOptions(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .verifyEshopLeadData() .getEshopLeadID() .deleteWTP(userProfile) ;
		 * Report.updateTestLog("************Pure
		 * Acquisition_ES_16***************", "DONE"); // Pure Acquisition_ES_16
		 * userProfile.setNectarValue("3");
		 * 
		 * acquisition.setGasSupplier("EDF Energy");
		 * acquisition.setFuelType("Elec");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter"); new
		 * HomePageAction()
		 * 
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToClearAndSimple()
		 * .navigateToEnergySmartElectricityOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .enterPaymentOptions(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .verifyEshopLeadData() .getEshopLeadID() .deleteWTP(userProfile) ;
		 * Report.updateTestLog("************Pure
		 * Acquisition_ES_25***************", "DONE"); // Pure Acquisition_ES_25
		 * userProfile.setNectarValue("1");
		 * 
		 * acquisition.setGasSupplier("EDF Energy");
		 * acquisition.setFuelType("dual");
		 * acquisition.setPaymentType("MonthlyVariableDirectDebit");
		 * acquisition.setCurrentElecSupplier("Single Rate Credit");
		 * 
		 * new HomePageAction()
		 * 
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToClearAndSimple() .navigateToEnergySmartDualOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .enterPaymentOptions(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .verifyEshopLeadData() .getEshopLeadID() .deleteWTP(userProfile) ;
		 */

		/*
		 * Report.updateTestLog("************Pure
		 * Acquisition_ES_29***************", "DONE"); // Pure Acquisition_ES_29
		 * 
		 * userProfile.setNectarValue("1"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setFuelType("dual");
		 * acquisition.setPaymentType("MonthlyVariableDirectDebit");
		 * acquisition.setCurrentGasSupplier("Credit Meter");
		 * acquisition.setCurrentElecSupplier("Two Rate / Economy 7 Credit");
		 * new HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToClearAndSimple()
		 * .navigateToEnergySmartDualOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .enterPaymentOptions(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .verifyEshopLeadData() .getEshopLeadID() .deleteWTP(userProfile);
		 */
	}

	@Test(groups = { FunctionalCategory.Acquisition })
	public void fixedPriceMay2014Acquisition() {

		Report.createTestLogHeader("Fixed Price May 2014",
				"Dual Gas and Elec Acquisition");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("NewUser");

		Report.updateTestLog(
				"************Pure Acquisition_ES_11***************", "DONE");
		// Pure Acquisition_ES_11
		userProfile.setNectarValue("3");
		acquisition.setGasSupplier("EDF Energy");
		acquisition.setFuelType("Gas");
		acquisition.setPaymentType("MonthlyDD");
		acquisition.setCurrentGasSupplier("Credit Meter");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		new HomePageAction()

		.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToFixedPriceMay2014()
				.navigateToEnergySmartGasOrderPage()
				.yourOrderAnonymousNavigation(acquisition, userProfile)
				.enterPersonalDetailsPage(acquisition, userProfile)
				.gasDefaultCurrentServicesPageNavigation(acquisition)
				.enterPaymentOptions(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.getEshopLeadID()

				.deleteWTP(userProfile);

		/***********************************************************************
		 * 
		 * 
		 * Remaining TC's of ESMART
		 * 
		 * 
		 **********************************************************************/
		/*
		 * Report.updateTestLog("************Pure
		 * Acquisition_ES_09***************", "DONE"); // Pure Acquisition_ES_09
		 * userProfile.setNectarValue("1"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyVariableDirectDebit");
		 * acquisition.setCurrentGasSupplier("Credit Meter"); new
		 * OnlineDBConnector().deRegister(userProfile.getUCRN()); new
		 * HomePageAction()
		 * 
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToFixedPriceMay2014() .navigateToEnergySmartGasOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .enterPaymentOptions(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID() /*.verifyAuditEventID(userProfile)
		 * .domarssalesRunBatch(acquisition.getShopBatch())
		 * .checkMediaCode(acquisition.getGasFP2013TariffCode())
		 * .deleteWTP(userProfile) ;
		 * 
		 * Report.updateTestLog("************Pure
		 * Acquisition_ES_10***************", "DONE"); // Pure Acquisition_ES_10
		 * userProfile.setNectarValue("2"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter"); new
		 * OnlineDBConnector().deRegister(userProfile.getUCRN()); new
		 * HomePageAction()
		 * 
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToFixedPriceMay2014() .navigateToEnergySmartGasOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .QuarterlyCashCheque(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID()
		 * 
		 * .deleteWTP(userProfile) ;
		 */

		/*
		 * Report.updateTestLog("************Pure
		 * Acquisition_ES_12***************", "DONE"); // Pure Acquisition_ES_12
		 * userProfile.setNectarValue("4"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter"); new
		 * OnlineDBConnector().deRegister(userProfile.getUCRN()); new
		 * HomePageAction()
		 * 
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToFixedPriceMay2014() .navigateToEnergySmartGasOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .QuarterlyCashCheque(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID()
		 * 
		 * .deleteWTP(userProfile) ; Report.updateTestLog("************Pure
		 * Acquisition_ES_21***************", "DONE"); // Pure Acquisition_ES_21
		 * userProfile.setNectarValue("1"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyVariableDirectDebit");
		 * acquisition.setCurrentGasSupplier("Credit Meter"); new
		 * OnlineDBConnector().deRegister(userProfile.getUCRN()); new
		 * HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToFixedPriceMay2014()
		 * .navigateToEnergySmartGasOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .QuarterlyCashCheque(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .verifyEshopLeadData() .getEshopLeadID()
		 * 
		 * .deleteWTP(userProfile) ; Report.updateTestLog("************Pure
		 * Acquisition_ES_22***************", "DONE"); // Pure Acquisition_ES_22
		 * userProfile.setNectarValue("2"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter"); new
		 * OnlineDBConnector().deRegister(userProfile.getUCRN()); new
		 * HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToFixedPriceMay2014()
		 * .navigateToEnergySmartGasOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .QuarterlyCashCheque(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .verifyEshopLeadData() .getEshopLeadID()
		 * 
		 * .deleteWTP(userProfile) ; Report.updateTestLog("************Pure
		 * Acquisition_ES_24***************", "DONE"); // Pure Acquisition_ES_24
		 * userProfile.setNectarValue("4"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter"); new
		 * OnlineDBConnector().deRegister(userProfile.getUCRN()); new
		 * HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToFixedPriceMay2014()
		 * .navigateToEnergySmartGasOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .QuarterlyCashCheque(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .verifyEshopLeadData() .getEshopLeadID()
		 * 
		 * .deleteWTP(userProfile) ;
		 * 
		 * Report.updateTestLog("************Pure
		 * Acquisition_ES_33***************", "DONE"); // Pure Acquisition_ES_33
		 * userProfile.setNectarValue("1"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyVariableDirectDebit");
		 * acquisition.setCurrentGasSupplier("Credit Meter"); new
		 * OnlineDBConnector().deRegister(userProfile.getUCRN()); new
		 * HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToFixedPriceMay2014()
		 * .navigateToEnergySmartGasOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .QuarterlyCashCheque(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .verifyEshopLeadData() .getEshopLeadID()
		 * 
		 * .deleteWTP(userProfile) ; Report.updateTestLog("************Pure
		 * Acquisition_ES_34***************", "DONE"); // Pure Acquisition_ES_34
		 * userProfile.setNectarValue("2"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter"); new
		 * OnlineDBConnector().deRegister(userProfile.getUCRN()); new
		 * HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToFixedPriceMay2014()
		 * .navigateToEnergySmartGasOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .QuarterlyCashCheque(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .verifyEshopLeadData() .getEshopLeadID()
		 * 
		 * .deleteWTP(userProfile) ; Report.updateTestLog("************Pure
		 * Acquisition_ES_35***************", "DONE"); // Pure Acquisition_ES_35
		 * userProfile.setNectarValue("3"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter"); new
		 * OnlineDBConnector().deRegister(userProfile.getUCRN()); new
		 * HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToFixedPriceMay2014()
		 * .navigateToEnergySmartGasOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .QuarterlyCashCheque(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .verifyEshopLeadData() .getEshopLeadID()
		 * 
		 * .deleteWTP(userProfile)
		 */
		;
	}

	@Test(groups = { Acquisition, BG })
	public void energySmartDifferentSupplyAddressElectricity() {
		Report.createTestLogHeader("Esmart Different supply address ",
				"Electricity");
		Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");
		String accountNumber=userProfile.getAccNumber();
		// getCustomerDetailsToUserProfileOAM(userProfile);

		// Pure Acquisition_ES_45
		Report.updateTestLog(
				"************Pure Acquisition_ES_45***************", "DONE");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());

		userProfile.setNectarValue("4");
		acquisition.setGasSupplier("EDF Energy");
		acquisition.setElecSupplier("British Gas");
		acquisition.setFuelType("Gas");
		acquisition.setPaymentType("MonthlyVariableDirectDebit");
		acquisition.setCurrentElecSupplier("Credit Meter");
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToClearAndSimple()
				.navigateToEnergySmartGasOrderPage().forcedRegisrationOnly(
						acquisition, userProfile)
				.energySmartDifferentSupplyAddressGas(acquisition)
				.enterPersonalDetailsPage(acquisition, userProfile)
				.gasDefaultCurrentServicesPageNavigation(acquisition)
				.variableDirectDebitPayment(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().getEshopLeadID()
				.deRegisterEsmart(accountNumber)
				.logoutFromThankYouPage();
		    
				/*new AcquisitionAction()
				.deRegisterEsmart(accountNumber);*/
		// Pure Acquisition_ES_66
		Report.updateTestLog(
				"************Pure Acquisition_ES_66***************", "DONE");
		userProfile.setNectarValue("4");
		acquisition.setGasSupplier("EDF Energy");
		acquisition.setElecSupplier("British Gas");
		acquisition.setFuelType("Elec");
		acquisition.setPaymentType("MonthlyVariableDirectDebit");
		acquisition.setCurrentElecSupplier("Two Rate / Economy 7 Credit");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToClearAndSimple()
				.navigateToEnergySmartElectricityOrderPage()
				.forcedRegisrationOnly(acquisition, userProfile)
				.energySmartDifferentSupplyAddressElec(acquisition)
				.enterPersonalDetailsPage(acquisition, userProfile)
				.gasDefaultCurrentServicesPageNavigation(acquisition)
				.variableDirectDebitPayment(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().getEshopLeadID()
				.deRegisterEsmart(accountNumber)
				.logoutFromThankYouPage();

		/***********************************************************************
		 * 
		 * 
		 * Remaining TC's of ESMART
		 * 
		 * 
		 **********************************************************************/

		// Pure Acquisition_ES_59
		/*
		 * userProfile.setNectarValue("1"); acquisition.setGasSupplier("British
		 * Gas"); acquisition.setElecSupplier("EDF Energy");
		 * acquisition.setFuelType("Elec");
		 * acquisition.setPaymentType("MonthlyVariableDirectDebit");
		 * acquisition.setCurrentElecSupplier("Single Rate Credit"); new
		 * HomePageAction() .navigateToLogin() .login(userProfile)
		 * .navigateToProductAndServicesPage()
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToClearAndSimple()
		 * .navigateToEnergySmartElectricityOrderPage()
		 * .elecSelection(acquisition)
		 * .energySmartDifferentSupplyAddressElec(acquisition)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .variableDirectDebitPayment(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID() .logoutFromThankYouPage();
		 * 
		 * 
		 *  // Pure Acquisition_ES_60 userProfile.setNectarValue("4");
		 * acquisition.setGasSupplier("EDF Energy");
		 * acquisition.setElecSupplier("British Gas");
		 * acquisition.setFuelType("Elec");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentElecSupplier("Two Rate / Economy 7 Credit");
		 * new HomePageAction() .navigateToLogin() .login(userProfile)
		 * .navigateToProductAndServicesPage()
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToFixedPriceMay2014()
		 * .navigateToEnergySmartElectricityOrderPage()
		 * .elecSelection(acquisition)
		 * .energySmartDifferentSupplyAddressElec(acquisition)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .variableDirectDebitPayment(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID() .logoutFromThankYouPage();
		 *  // Pure Acquisition_ES_79 /* userProfile.setNectarValue("4");
		 * acquisition.setGasSupplier("British Gas");
		 * acquisition.setElecSupplier("British Gas");
		 * acquisition.setFuelType("dual");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter");
		 * acquisition.setCurrentElecSupplier("Single Rate Credit"); new
		 * HomePageAction() .navigateToLogin() .login(userProfile)
		 * .navigateToProductAndServicesPage()
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToFixedPriceMay2014()
		 * .navigateToEnergySmartElectricityOrderPage()
		 * .energySmartDifferentSupplyAddressElec(acquisition)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .variableDirectDebitPayment(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID() .logoutFromThankYouPage();
		 *  // Pure Acquisition_ES_63
		 * 
		 * 
		 * userProfile.setNectarValue("4"); acquisition.setGasSupplier("British
		 * Gas"); acquisition.setElecSupplier("EDF Energy");
		 * acquisition.setFuelType("Elec");
		 * acquisition.setPaymentType("MonthlyVariableDirectDebit");
		 * acquisition.setCurrentElecSupplier("Single Rate Credit"); new
		 * HomePageAction()
		 * 
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToOnlineVariableAugust2013()
		 * .navigateToEnergySmartElectricityOrderPage()
		 * .forcedLoginOnly(acquisition, userProfile)
		 * .energySmartDifferentSupplyAddressElec(acquisition)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .variableDirectDebitPayment(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID() .logoutFromThankYouPage();
		 * 
		 * 
		 *  // Pure Acquisition_ES_75 /* new
		 * OnlineDBConnector().deRegister(userProfile.getUCRN());
		 * 
		 * userProfile.setNectarValue("4"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setElecSupplier("British Gas");
		 * acquisition.setFuelType("dual");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter");
		 * acquisition.setCurrentElecSupplier("Two Rate / Economy 7 Credit");
		 * new HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToClearAndSimple()
		 * .navigateToEnergySmartDualOrderPage()
		 * .forcedRegisrationOnly(acquisition,userProfile)
		 * .energySmartDifferentSupplyAddressDual(acquisition)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .enterPaymentOptions(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID() .logoutFromThankYouPage();
		 * 
		 * 
		 *  // Pure Acquisition_ES_48
		 * 
		 * new OnlineDBConnector().deRegister(userProfile.getUCRN());
		 * userProfile.setEmail("abc17@bgdigitaltest.co.uk");
		 * userProfile.setNectarValue("3"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setElecSupplier("British Gas");
		 * acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentElecSupplier("Credit Meter"); new
		 * HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToFixedPriceMay2014()
		 * .navigateToEnergySmartGasOrderPage()
		 * .forcedRegisrationOnly(acquisition, userProfile)
		 * .energySmartDifferentSupplyAddressGas(acquisition)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .variableDirectDebitPayment(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID() .logoutFromThankYouPage();
		 */
	}

	@Test(groups = { Acquisition, BG })
	public void energySmartDifferentSupplyAddressGas() {
		Report.createTestLogHeader("Energy Smart Test",
				"EnergySmartDifferentSupplyAddressGas");
		Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");
		 getCustomerDetailsToUserProfileOAM(userProfile);

		// Pure Acquisition_ES_42
		Report.updateTestLog(
				"************Pure Acquisition_ES_42***************", "DONE");
		userProfile.setNectarValue("1");
		acquisition.setGasSupplier("EDF Energy");
		acquisition.setElecSupplier("British Gas");
		acquisition.setFuelType("Gas");
		acquisition.setPaymentType("MonthlyVariableDirectDebit");
		acquisition.setCurrentElecSupplier("Credit Meter");
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToOnlineVariableAugust2013()
				.navigateToEnergySmartGasOrderPage().gasSelection(acquisition)
				.energySmartDifferentSupplyAddressGas(acquisition)
				.enterPersonalDetailsPage(acquisition, userProfile)
				.gasDefaultCurrentServicesPageNavigation(acquisition)
				.variableDirectDebitPayment(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().getEshopLeadID()
				.logoutFromThankYouPage();

		// Pure Acquisition_ES_50
		Report.updateTestLog(
				"************Pure Acquisition_ES_50***************", "DONE");
		userProfile.setNectarValue("1");
		acquisition.setGasSupplier("EDF Energy");
		acquisition.setElecSupplier("British Gas");
		acquisition.setFuelType("Gas");
		acquisition.setPaymentType("MonthlyVariableDirectDebit");
		acquisition.setCurrentGasSupplier("Credit Meter");
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple().navigateToEnergySmartGasOrderPage()
				.gasSelection(acquisition)
				.energySmartDifferentSupplyAddressGas(acquisition)
				.enterPersonalDetailsPage(acquisition, userProfile)
				.gasDefaultCurrentServicesPageNavigation(acquisition)
				.variableDirectDebitPayment(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().getEshopLeadID()
				.logoutFromThankYouPage();

		// Pure Acquisition_ES_57
		Report.updateTestLog(
				"************Pure Acquisition_ES_57***************", "DONE");
		userProfile.setNectarValue("4");
		acquisition.setGasSupplier("British Gas");
		acquisition.setElecSupplier("EDF Energy");
		acquisition.setFuelType("Gas");
		acquisition.setPaymentType("MonthlyDD");
		acquisition.setCurrentGasSupplier("Credit Meter");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		new HomePageAction()

		.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple().navigateToEnergySmartGasOrderPage()
				.gasSelection(acquisition).forcedRegisrationOnly(acquisition,
						userProfile).energySmartDifferentSupplyAddressGas(
						acquisition).enterPersonalDetailsPage(acquisition,
						userProfile).gasDefaultCurrentServicesPageNavigation(
						acquisition).enterPaymentOptions(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().getEshopLeadID()
				.logoutFromThankYouPage();

		/***********************************************************************
		 * 
		 * 
		 * Remaining TC's of ESMART
		 * 
		 * 
		 **********************************************************************/

		/*
		 * // Pure Acquisition_ES_74
		 * 
		 * 
		 * userProfile.setNectarValue("4"); acquisition.setGasSupplier("British
		 * Gas"); acquisition.setElecSupplier("EDF Energy");
		 * acquisition.setFuelType("dual");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter");
		 * acquisition.setCurrentElecSupplier("Single Rate Credit"); new
		 * HomePageAction()
		 * 
		 * 
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToFixedPriceMay2014() .navigateToEnergySmartDualOrderPage()
		 * .forcedRegisrationOnly(acquisition,userProfile)
		 * .energySmartDifferentSupplyAddressDual(acquisition)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .enterPaymentOptions(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID() .logoutFromThankYouPage();
		 *  // Pure Acquisition_ES_53 userProfile.setNectarValue("4");
		 * acquisition.setGasSupplier("British Gas");
		 * acquisition.setElecSupplier("EDF Energy");
		 * acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyVariableDirectDebit");
		 * acquisition.setCurrentGasSupplier("Credit Meter"); new
		 * HomePageAction()
		 * 
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToClearAndSimple() .navigateToEnergySmartGasOrderPage()
		 * .gasSelection(acquisition) .forcedLoginOnly(acquisition, userProfile)
		 * .energySmartDifferentSupplyAddressGas(acquisition)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .variableDirectDebitPayment(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID() .logoutFromThankYouPage();
		 *  // Pure Acquisition_ES_55 /*userProfile.setNectarValue("4");
		 * acquisition.setGasSupplier("British Gas");
		 * acquisition.setElecSupplier("British Gas");
		 * acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyVariableDirectDebit");
		 * acquisition.setCurrentGasSupplier("Credit Meter"); new
		 * HomePageAction()
		 * 
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToFixedPriceMay2014() .navigateToEnergySmartGasOrderPage()
		 * .gasSelection(acquisition) .forcedLoginOnly(acquisition, userProfile)
		 * .energySmartDifferentSupplyAddressGas(acquisition)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .variableDirectDebitPayment(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID() .logoutFromThankYouPage();
		 * 
		 * 
		 *  // Pure Acquisition_ES_98 userProfile.setNectarValue("1");
		 * acquisition.setGasSupplier("British Gas");
		 * acquisition.setElecSupplier("EDF Energy");
		 * acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyVariableDirectDebit");
		 * acquisition.setCurrentGasSupplier("Credit Meter"); new
		 * HomePageAction()
		 * 
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToClearAndSimple() .navigateToEnergySmartGasOrderPage()
		 * .gasSelection(acquisition) .forcedLoginOnly(acquisition, userProfile)
		 * .energySmartDifferentSupplyAddressGas(acquisition)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .variableDirectDebitPayment(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID() .logoutFromThankYouPage();
		 * 
		 * 
		 * 
		 * 
		 *  // Pure Acquisition_ES_97 new
		 * OnlineDBConnector().deRegister(userProfile.getUCRN());
		 * userProfile.setNectarValue("4");
		 * userProfile.setEmail("abcnew1@bgdigitaltest.co.uk");
		 * acquisition.setGasSupplier("British Gas");
		 * acquisition.setElecSupplier("EDF Energy");
		 * acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter"); new
		 * HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToClearAndSimple()
		 * .navigateToEnergySmartGasOrderPage() .elecSelection(acquisition)
		 * .forcedRegisrationOnly(acquisition, userProfile)
		 * .energySmartDifferentSupplyAddressGas(acquisition)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .variableDirectDebitPayment(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID() .logoutFromThankYouPage();
		 *  // Pure Acquisition_ES_72
		 *  /* userProfile.setNectarValue("4");
		 * acquisition.setGasSupplier("British Gas");
		 * acquisition.setElecSupplier("EDF Energy");
		 * acquisition.setFuelType("dual");
		 * acquisition.setPaymentType("MonthlyVariableDirectDebit");
		 * acquisition.setCurrentGasSupplier("Credit Meter");
		 * acquisition.setCurrentElecSupplier("Single Rate Credit"); new
		 * OnlineDBConnector().deRegister(userProfile.getUCRN());
		 * 
		 * new HomePageAction()
		 * 
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToOnlineVariableAugust2013()
		 * .navigateToEnergySmartDualOrderPage() .elecSelection(acquisition)
		 * .forcedRegisrationOnly(acquisition, userProfile)
		 * .energySmartDifferentSupplyAddressDual(acquisition)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .enterPaymentOptions(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID() .logoutFromThankYouPage();
		 */

	}

	@Test(groups = { Acquisition, Conversion, Zeus, Qtp })
	public void energySmartDifferentSupplyAddressDual() {
		Report.createTestLogHeader("Energy Smart Test",
				"EnergySmartDifferentSupplyAddressDual");
		Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		// getCustomerDetailsToUserProfileOAM(userProfile);

		// Pure Acquisition_ES_82
		Report.updateTestLog(
				"************Pure Acquisition_ES_82***************", "DONE");
		userProfile.setNectarValue("4");
		acquisition.setGasSupplier("British Gas");
		acquisition.setElecSupplier("British Gas");
		acquisition.setFuelType("dual");
		acquisition.setPaymentType("MonthlyDD");
		acquisition.setCurrentGasSupplier("Credit Meter");
		acquisition.setCurrentElecSupplier("Two Rate / Economy 7 Credit");
		new HomePageAction()

		.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToFixedPriceMay2014()
				.navigateToEnergySmartDualOrderPage().forcedLoginOnly(
						acquisition, userProfile)
				.energySmartDifferentSupplyAddressDual(acquisition)
				.enterPersonalDetailsPage(acquisition, userProfile)
				.gasDefaultCurrentServicesPageNavigation(acquisition)
				.variableDirectDebitPayment(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().getEshopLeadID()
				.logoutFromThankYouPage();

		// Pure Acquisition_ES_96
		Report.updateTestLog(
				"************Pure Acquisition_ES_96***************", "DONE");
		userProfile.setNectarValue("4");
		acquisition.setGasSupplier("British Gas");
		acquisition.setElecSupplier("EDF Energy");
		acquisition.setFuelType("dual");
		acquisition.setPaymentType("MonthlyVariableDirectDebit");
		acquisition.setCurrentGasSupplier("Credit Meter");
		acquisition.setCurrentElecSupplier("Single Rate Credit");
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple()
				.navigateToEnergySmartDualOrderPage()
				.elecSelection(acquisition)
				.energySmartDifferentSupplyAddressDual(acquisition)
				.enterPersonalDetailsPage(acquisition, userProfile)
				.gasDefaultCurrentServicesPageNavigation(acquisition)
				.variableDirectDebitPayment(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().getEshopLeadID()
				.logoutFromThankYouPage();

		/***********************************************************************
		 * 
		 * 
		 * Remaining TC's of ESMART
		 * 
		 * 
		 **********************************************************************/

		// Pure Acquisition_ES_81
		/*
		 * userProfile.setNectarValue("4"); acquisition.setGasSupplier("British
		 * Gas"); acquisition.setElecSupplier("British Gas");
		 * acquisition.setFuelType("dual");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter");
		 * acquisition.setCurrentElecSupplier("Single Rate Credit"); new
		 * HomePageAction() .navigateToLogin() .login(userProfile)
		 * .navigateToProductAndServicesPage()
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToOnlineVariableAugust2013()
		 * .navigateToEnergySmartDualOrderPage() .elecSelection(acquisition)
		 * .energySmartDifferentSupplyAddressDual(acquisition)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .variableDirectDebitPayment(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID() .logoutFromThankYouPage(); // Pure
		 * Acquisition_ES_69 userProfile.setNectarValue("4");
		 * acquisition.setGasSupplier("EDF Energy");
		 * acquisition.setElecSupplier("British Gas");
		 * acquisition.setFuelType("dual");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter");
		 * acquisition.setCurrentElecSupplier("Two Rate / Economy 7 Credit");
		 * new HomePageAction() .navigateToLogin() .login(userProfile)
		 * .navigateToProductAndServicesPage()
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToFixedPriceMay2014() .navigateToEnergySmartDualOrderPage()
		 * .gasSelection(acquisition)
		 * .energySmartDifferentSupplyAddressDual(acquisition)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .variableDirectDebitPayment(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID() .logoutFromThankYouPage();
		 * 
		 * 
		 * 
		 *  // Pure Acquisition_ES_70 userProfile.setNectarValue("4");
		 * acquisition.setGasSupplier("British Gas");
		 * acquisition.setElecSupplier("British Gas");
		 * acquisition.setFuelType("dual");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter");
		 * acquisition.setCurrentElecSupplier("Single Rate Credit"); new
		 * HomePageAction() .navigateToLogin() .login(userProfile)
		 * .navigateToProductAndServicesPage()
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToClearAndSimple() .navigateToEnergySmartDualOrderPage()
		 * .energySmartDifferentSupplyAddressDual(acquisition)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .variableDirectDebitPayment(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyLeadData() .getLeadID()
		 * .logoutFromThankYouPage();
		 * 
		 *  // Pure Acquisition_ES_76 /* userProfile.setNectarValue("4");
		 * acquisition.setGasSupplier("British Gas");
		 * acquisition.setElecSupplier("British Gas");
		 * acquisition.setFuelType("dual");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter");
		 * acquisition.setCurrentElecSupplier("Single Rate Credit"); new
		 * HomePageAction() .navigateToLogin() .login(userProfile)
		 * .navigateToProductAndServicesPage()
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToOnlineVariableAugust2013()
		 * .navigateToEnergySmartDualOrderPage()
		 * .energySmartDifferentSupplyAddressDual(acquisition)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .variableDirectDebitPayment(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyLeadData() .getLeadID()
		 * .logoutFromThankYouPage();
		 *  // Pure Acquisition_ES_58 userProfile.setNectarValue("4");
		 * acquisition.setGasSupplier("British Gas");
		 * acquisition.setElecSupplier("British Gas");
		 * acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter"); new
		 * HomePageAction()
		 * 
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToClearAndSimple() .navigateToEnergySmartGasOrderPage()
		 * .elecSelection(acquisition) .forcedRegisrationOnly(acquisition,
		 * userProfile) .energySmartDifferentSupplyAddressGas(acquisition)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .variableDirectDebitPayment(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID() .logoutFromThankYouPage();
		 * 
		 *  // Pure Acquisition_ES_49 /* userProfile.setNectarValue("4");
		 * acquisition.setGasSupplier("British Gas");
		 * acquisition.setElecSupplier("EDF Energy");
		 * acquisition.setFuelType("Elec");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentElecSupplier("Single Rate Credit"); new
		 * HomePageAction()
		 * 
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToOnlineVariableAugust2013()
		 * .navigateToEnergySmartElectricityOrderPage()
		 * .elecSelection(acquisition) .forcedRegisrationOnly(acquisition,
		 * userProfile) .energySmartDifferentSupplyAddressElec(acquisition)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .variableDirectDebitPayment(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID() .logoutFromThankYouPage();
		 */

	}

	@Test(groups = { Acquisition, Conversion, Zeus, Qtp })
	public void energySmartDifferentSupplyAddressJI() {
		Report.createTestLogHeader("Energy Smart Test",
				"EnergySmartDifferentSupplyAddressJI");
		Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JIAccount");
		// getCustomerDetailsToUserProfileOAM(userProfile);

		// Pure Acquisition_ES_77
		Report.updateTestLog(
				"************Pure Acquisition_ES_77***************", "DONE");
		userProfile.setNectarValue("1");
		acquisition.setGasSupplier("British Gas");
		acquisition.setElecSupplier("British Gas");
		acquisition.setFuelType("Gas");
		acquisition.setPaymentType("MonthlyDD");
		acquisition.setCurrentGasSupplier("Credit Meter");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		new HomePageAction()

		.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple().navigateToEnergySmartGasOrderPage()
				.forcedRegisrationOnly(acquisition, userProfile)
				.energySmartDifferentSupplyAddressGas(acquisition)
				.enterPersonalDetailsPage(acquisition, userProfile)
				.gasDefaultCurrentServicesPageNavigation(acquisition)
				.enterPaymentOptions(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.getEshopLeadID().logoutFromThankYouPage();

		/***********************************************************************
		 * 
		 * 
		 * Remaining TC's of ESMART
		 * 
		 * 
		 **********************************************************************/
		// Pure Acquisition_ES_83
		/*
		 * userProfile.setNectarValue("4"); acquisition.setGasSupplier("British
		 * Gas"); acquisition.setElecSupplier("British Gas");
		 * acquisition.setFuelType("dual");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter");
		 * acquisition.setCurrentElecSupplier("Single Rate Credit"); new
		 * HomePageAction()
		 * 
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToFixedPriceMay2014() .navigateToEnergySmartDualOrderPage()
		 * .forcedRegisrationOnly(acquisition,userProfile)
		 * .energySmartDifferentSupplyAddressDual(acquisition)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .enterPaymentOptions(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID() .logoutFromThankYouPage();
		 *  // Pure Acquisition_ES_85
		 * 
		 * userProfile.setNectarValue("1"); acquisition.setGasSupplier("British
		 * Gas"); acquisition.setElecSupplier("British Gas");
		 * acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyVariableDirectDebit");
		 * acquisition.setCurrentGasSupplier("Credit Meter"); new
		 * HomePageAction()
		 * 
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToClearAndSimple() .navigateToEnergySmartGasOrderPage()
		 * .forcedRegisrationOnly(acquisition,userProfile)
		 * .energySmartDifferentSupplyAddressGas(acquisition)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .variableDirectDebitPayment(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID() .logoutFromThankYouPage();
		 *  // Pure Acquisition_ES_78
		 * 
		 *  /* userProfile.setNectarValue("1");
		 * acquisition.setGasSupplier("British Gas");
		 * acquisition.setElecSupplier("British Gas");
		 * acquisition.setFuelType("Elec");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter");
		 * acquisition.setCurrentElecSupplier("Single Rate Credit"); new
		 * HomePageAction() .navigateToLogin() .login(userProfile)
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToFixedPriceMay2014()
		 * .navigateToEnergySmartElectricityOrderPage()
		 * .elecSelection(acquisition)
		 * .energySmartDifferentSupplyAddressGas(acquisition)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .variableDirectDebitPayment(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID() .logoutFromThankYouPage();
		 */
	}

	@Test(groups = { Acquisition, Conversion, Zeus, Qtp })
	public void validateErrorPaymentPage() {
		// Pure Acquisition_ES_105		
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("NewUser");
		Report.createTestLogHeader("Acquisition Test",
				" Your Order Page Validation");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		Report.updateTestLog(
				"************Pure Acquisition_ES_105***************", "DONE");
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToClearAndSimple()
				.navigateToEnergySmartGasOrderPage()
				.yourOrderAnonymousNavigation(acquisition, userProfile)
				.enterPersonalDetailsPage(acquisition, userProfile)
				.enterCurrentServices(acquisition).errorPaymentPage();
	}

	@Test(groups = { Regression, GAP })
	public void verifyAnonymousEnergyShopJourneyESmartGas() {
		Report.createTestLogHeader("Get A Price",
				"Energy Smart Anonymous Journey");
		GetAPrice getaPrice = new TestDataHelper()
				.getGetAPriceData("anonymous");
		Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("NewUser");

		// Pure Acquisition_GAP_01
		Report.updateTestLog(
				"************Pure Acquisition_GAP_11***************", "DONE");
		userProfile.setNectarValue("4");
		acquisition.setGasSupplier("EDF Energy");
		acquisition.setElecSupplier("EDF Energy");
		acquisition.setFuelType("Gas");
		acquisition.setPaymentType("MonthlyVariableDirectDebit");
		acquisition.setCurrentGasSupplier("Credit Meter");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToGetAPricePage().verifyAndEnterGAPDetails(getaPrice,
						userProfile).switchTariff(getaPrice)
				.energySmartAcquisitionYourOrderPage(acquisition, userProfile)
				.energySmartPersonalDetailsPage2(acquisition, userProfile)
				.gasDefaultCurrentServicesPageNavigation(acquisition)
				.enterPaymentOptions(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).getEshopLeadID()
				.verifyEshopLeadData().deleteWTP(userProfile);

	}

	@Test(groups = { FunctionalCategory.Acquisition })
	public void priceFinderFixAndFall() {
		Report.createTestLogHeader("Fix And Fall Acquisition",
				"Price Finder - Non - Oam Dual");
		Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");

		// Pure Acquisition_PF_10
		userProfile = new TestDataHelper().getUserProfile("GasAccount");
		acquisition.setElecSupplier("British Gas");
		acquisition.setGasSupplier("British Gas");
		acquisition.setCurrentGasSupplier("Single Rate Credit");
		acquisition.setFuelType("Elec");
		acquisition.setTarifffordual(acquisition.gettariffFixFall());
		// new OnlineDBConnector().deRegister(userProfile.getUCRN());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToClearAndSimple()
				.navigateToPriceFinder().fillPriceFinder(userProfile)
				.navigateWithEsmart().elecSelection(acquisition)
				.forcedLoginYourOrderPage(acquisition, userProfile)
				.dualEnergysmartOrderDual(acquisition).enterCurrentServices(
						acquisition).enterPaymentOptions(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().getEshopLeadID().deleteWTP(userProfile);

		
		/***********************************************************************
		 * 
		 * 
		 * Remaining TC's of ESMART
		 * 
		 * 
		 **********************************************************************/
		// Pure Acquisition_PF_07
		/*
		 * acquisition.setElecSupplier("British Gas");
		 * acquisition.setGasSupplier("British Gas");
		 * acquisition.setCurrentGasSupplier("Credit Meter");
		 * acquisition.setFuelType("Gas"); new
		 * OnlineDBConnector().deRegister(userProfile.getUCRN()); new
		 * HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToClearAndSimple()
		 * .navigateToPriceFinder() .fillPriceFinder(userProfile)
		 * .navigateWithEsmart() .gasFuelTypeSelect()
		 * .forcedRegisrationOnly(acquisition, userProfile)
		 * .energySmartDifferentSupplyAddressGas(acquisition)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .enterPaymentOptions(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .verifyEshopLeadData() .getEshopLeadID() .deleteWTP(userProfile);
		 * 
		 *  // Pure Acquisition_PF_13 userProfile= new
		 * TestDataHelper().getUserProfile("ElectricityAccount");
		 * acquisition.setElecSupplier("British Gas");
		 * acquisition.setGasSupplier("British Gas");
		 * acquisition.setCurrentGasSupplier("Economy7");
		 * acquisition.setFuelType("Dual"); new
		 * OnlineDBConnector().deRegister(userProfile.getUCRN()); new
		 * HomePageAction() .navigateToLogin() .login(userProfile)
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToClearAndSimple() .navigateToPriceFinder()
		 * .fillPriceFinder(userProfile) .navigateWithEsmart()
		 * .gasSelection(acquisition) .enterPersonalDetailsPage(acquisition,
		 * userProfile) .enterCurrentServices(acquisition)
		 * .enterPaymentOptions(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID() .deleteWTP(userProfile);
		 */

	}

	
	/*
	 * -----------------------------------------------------------------Pure Conversion
	 */
	//For Conversion If two or more TC methods are present in a method, Please run one by one by Commenting the other
	

	@Test(groups = { Acquisition, Conversion, Zeus, Qtp })
	public void ConversionGasOnline() {

		Report.createTestLogHeader("Conversion Test",
				"ConversionGasClearAndSimple");
		Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");
		acquisition.setTariffforgas(acquisition.gettariffFixFall());
		// getCustomerDetailsToUserProfileOAM(userProfile);

		// Pure Conversion_CA_02
		acquisition.setFuelType("Gas");
		acquisition.setPaymentType("MonthDD");
		// new OnlineDBConnector().deRegister(userProfile.getUCRN());
		acquisition.setTariffforgas(acquisition.gettariffFixFall());
		Report.updateTestLog("***********Pure Conversion_CA_02***********",
				"DONE");
		new HomePageAction()
				.navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage()
				.navigateToClearAndSimple()
				.navigateToEnergySmartGasOrderPage()
				.forcedLoginYourOrderPage(acquisition, userProfile)
				//.enterPersonalDetailsPage(acquisition, userProfile)
				.gasBGEnergySmartGasConversion(acquisition)
				.enterPaymentOptions(acquisition).payInNextMonth()
				.payNowOnline(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.verifyAuditEventID(userProfile)
				.logoutFromConvThankYouPage();
				//.changeTariff(userProfile.getGasAccount());

		// Pure Conversion_CA_15
		Report.updateTestLog("***********Pure Conversion_CA_15***********",
				"DONE");
		acquisition.setFuelType("Gas");
		acquisition.setPaymentType("MonthDD");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		acquisition.setTariffforgas(acquisition.gettariffFixFall());
		new HomePageAction()
				.navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage()
				.navigateToOnlineVariableAugust2013()
				.navigateToEnergySmartGasOrderPage()
				.forcedRegistrationYourOrderPage(acquisition, userProfile)
				.gasBGEnergySmartGasConversion(acquisition)
				// .enterPersonalDetailsPage(acquisition, userProfile)
				.enterPaymentOptions(acquisition).payInNextMonth()
				.payNowOnline(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.verifyAuditEventID(userProfile)
				.logoutFromConvThankYouPage();
				//.changeTariff(userProfile.getGasAccount());
		
		Report.updateTestLog("***********Part Acquition ConvAddElecForceLogin***********",
				"DONE");
		acquisition.setTarifffordual(acquisition.gettariffClearSimple());
		acquisition.setPaymentType(acquisition.getMonthlyFixedDD());
		acquisition.setCardType(acquisition.getVisaDebit());
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage()
				.navigateToOnlineVariableAugust2013()
				.navigateToEnergySmartDualOrderPage()
				.forcedRegistrationYourOrderPage(acquisition, userProfile)
				.gasBGEnergySmartDualOrder(acquisition).enterCurrentServices(
						acquisition).enterPaymentOptions(acquisition)
				.payNowOnline(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.logoutFromConvThankYouPage();
		
		/***********************************************************************
		 * 
		 * 
		 * Remaining TC's of ESMART
		 * 
		 * 
		 **********************************************************************/

		/*
		 * //Pure Conversion_CA_01 acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthDD"); new HomePageAction()
		 * .navigateToLogin() .login(userProfile)
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToClearAndSimple() .navigateToEnergySmartGasOrderPage()
		 * .yourOrderGasBG(acquisition,userProfile)
		 * //.enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasBGEnergySmartGasConversion(acquisition)
		 * .enterPaymentOptions(acquisition) .payInNextMonth()
		 * .payNowOnline(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .verifyAuditEventID(userProfile) .logoutFromConvThankYouPage()
		 * .changeTariff(userProfile.getGasAccount());
		 * 
		 * 
		 * 
		 * //Pure Conversion_CA_13 acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthDD"); new HomePageAction()
		 * .navigateToLogin() .login(userProfile)
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToOnlineVariableAugust2013() .navigateToGasOrderPage()
		 * .yourOrderGasBG(acquisition,userProfile) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .verifyAuditEventID(userProfile) .logoutFromConvThankYouPage()
		 * .changeTariff(userProfile.getGasAccount());
		 */
	}

	@Test(groups = { Acquisition, Conversion, Zeus, Qtp })
	public void ConversionJIOnline() {

		Report.createTestLogHeader("Conversion Test",
				"Conversion JI Account Online");
		GetAPrice getaPrice = new TestDataHelper()
				.getGetAPriceData("anonymous");
		Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JIAccount");
		// getCustomerDetailsToUserProfileOAM(userProfile);

		// Pure Conversion_CA_10
		
		  Report.updateTestLog("*********Pure Conversion_CA_10************",
		  "DONE");
		  acquisition.setTariffforgas(acquisition.gettariffClearSimple());
		  acquisition.setPaymentType("MonthDD"); new HomePageAction()
		  .navigateToLogin() .login(userProfile)
		  .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		  .navigateToOnlineVariableAugust2013()
		  .navigateToEnergySmartDualOrderPage() .yourOrderDualBG(acquisition,
		  userProfile) .gasBGEnergySmartDualOrder(acquisition)
		  .variableDirectDebitPayment(acquisition) .reviewOrderPageNavigation()
		  .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		  .verifyAuditEventID(userProfile) .logoutFromConvThankYouPage()
		  .changeTariff(userProfile.getAccNumber());
		 

		// Pure Conversion_CA_11
		Report.updateTestLog("*********Pure Conversion_CA_11************",
				"DONE");
		acquisition.setPaymentType("MonthDD");
		acquisition.setTarifffordual(acquisition.gettariffFixFall());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToClearAndSimple()
				.navigateToEnergySmartDualOrderPage().forcedLoginYourOrderPage(
						acquisition, userProfile).jiEnergysmartOrderJi(
						acquisition).enterPaymentOptions(acquisition)
				.payInNextMonth().payNowOnline(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().verifyAuditEventID(userProfile)
				.logoutFromConvThankYouPage().changeTariff(
						userProfile.getAccNumber());

		
		/***********************************************************************
		 * 
		 * 
		 * Remaining TC's of ESMART
		 * 
		 * 
		 **********************************************************************/
		// Pure Conversion_CA_17
		/*
		 * acquisition.setFuelType("JI"); acquisition.setPaymentType("MonthDD");
		 * new HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToGetAPricePage() .verifyAndEnterGAPDetails(getaPrice,
		 * userProfile) .switchTariff(getaPrice)
		 * .forcedRegisrationOnly(acquisition, userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasBGEnergySmartDualOrder(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .verifyAuditEventID(userProfile) .logoutFromConvThankYouPage()
		 * .changeTariff(userProfile.getAccNumber());
		 */
	}
	
	@Test(groups = { Acquisition, Conversion, Zeus, Qtp })
	public void pureConversionEStoESJI() {
		Report.createTestLogHeader("Esmart Conversion",
				"Energy Account Energy smart to Energy smart");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JIAccount");
		// TC_11
		
		 Report.updateTestLog("***********Pure Conversion_ES_11***********",
		 "DONE");
		 String accountNumber=userProfile.getAccNumber();
		  acquisition.setTarifffordual(acquisition.gettariffOnlineVariable());
		  new HomePageAction() .navigateToGasAndElectricityPage()
		  .navigateToOurTariffsPage() .navigateToFixedPriceMay2014()
		 .navigateToEnergySmartDualOrderPage()
		 .forcedLoginYourOrderPage(acquisition, userProfile)
		.jiEnergysmartOrderJi(acquisition) .verifyThankYouPage(userProfile)
		 //.getEshopLeadID() 
		.logoutFromThankYouPage();
		 

		// TC_17
		/*Report.updateTestLog("***********Pure Conversion_ES_17***********",
				"DONE");
		acquisition.setTarifffordual(acquisition.gettariffOnlineVariable());
		//new ThankYouPage().deleteWTP(userProfile);
		//new OnlineDBConnector().deRegister(userProfile.getUCRN());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToFixedPriceMay2014()
				.navigateToEnergySmartDualOrderPage()
				.forcedRegistrationYourOrderPage(acquisition, userProfile)
				.enterPersonalDetailsPage(acquisition, userProfile)
				.jiEnergysmartOrderJi(acquisition).verifyThankYouPage(
						userProfile)
				.getEshopLeadID()
				.deRegisterEsmart(accountNumber)
				.logoutFromThankYouPage();

		
		/***********************************************************************
		 * 
		 * 
		 * Remaining TC's of ESMART
		 * 
		 * 
		 **********************************************************************/
		/*
		 * acquisition.setTarifffordual(acquisition.gettariffFixFall()); new
		 * HomePageAction() .navigateToLogin() .login(userProfile)
		 * .navigateToProductAndServicesPage()
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToOnlineVariableAugust2013()
		 * .navigateToEnergySmartDualOrderPage() .yourOrderDualBG(acquisition,
		 * userProfile) .dualEnergysmartOrderDual(acquisition)
		 * .verifyThankYouPage(userProfile) .logoutFromThankYouPage();
		 */

		/*
		 * acquisition.setTarifffordual(acquisition.gettariffClearSimple()); new
		 * HomePageAction() .navigateToLogin() .login(userProfile)
		 * .navigateToProductAndServicesPage()
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToClearAndSimple() .navigateToEnergySmartDualOrderPage()
		 * .yourOrderDualBG(acquisition, userProfile)
		 * .dualEnergysmartOrderDual(acquisition)
		 * .verifyThankYouPage(userProfile) //.getEshopLeadID()
		 * .logoutFromThankYouPage();
		 */

	}

	@Test(groups = { Acquisition, Conversion, Zeus, Qtp })
	public void pureConversionEStoESGas() {
		Report.createTestLogHeader("Esmart Conversion",
				"Gas Account Energy smart to Energy smart");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");
		String accountNumber=userProfile.getAccNumber();
		acquisition.setTariffforgas(acquisition.gettariffFixFall());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToFixedPriceMay2014()
				.navigateToEnergySmartGasOrderPage().yourOrderGasBG(
						acquisition, userProfile).energySmartGasBGOrderGas(
						acquisition).verifyThankYouPage(userProfile)
						.deRegisterEsmart(accountNumber)
				.logoutFromThankYouPage();
		
		
		
		/***********************************************************************
		 * 
		 * 
		 * Remaining TC's of ESMART
		 * 
		 * 
		 **********************************************************************/
		/*
		 * acquisition.setTariffforgas(acquisition.gettariffClearSimple()); new
		 * HomePageAction() .navigateToLogin() .login(userProfile)
		 * .navigateToProductAndServicesPage()
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToClearAndSimple() .navigateToEnergySmartGasOrderPage()
		 * .yourOrderGasBG(acquisition,userProfile)
		 * .energySmartGasBGOrderGas(acquisition)
		 * .verifyThankYouPage(userProfile) .logoutFromThankYouPage();
		 * 
		 * acquisition.setTariffforgas(acquisition.gettariffOnlineVariable());
		 * new HomePageAction() .navigateToLogin() .login(userProfile)
		 * .navigateToProductAndServicesPage()
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToOnlineVariableAugust2013()
		 * .navigateToEnergySmartGasOrderPage()
		 * .yourOrderGasBG(acquisition,userProfile)
		 * .energySmartGasBGOrderGas(acquisition)
		 * .verifyThankYouPage(userProfile) .logoutFromThankYouPage();
		 */

	}

	@Test(groups = { Acquisition, Conversion, Zeus, Qtp })
	public void pureConversionEStoESDual() {
		Report.createTestLogHeader("Esmart Conversion",
				"Dual Account Energy smart to Energy smart");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		// TC 08,18
		String accountNumber=userProfile.getAccNumber();
		acquisition.setTarifffordual(acquisition.gettariffClearSimple());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToClearAndSimple()
				.navigateToEnergySmartDualOrderPage().forcedLoginYourOrderPage(
						acquisition, userProfile).jiEnergysmartOrderJi(
						acquisition).verifyThankYouPage(userProfile)
						.deRegisterEsmart(accountNumber)
				.logoutFromThankYouPage();
		
		/***********************************************************************
		 * 
		 * 
		 * Remaining TC's of ESMART
		 * 
		 * 
		 **********************************************************************/
		/*
		 * acquisition.setTarifffordual(acquisition.gettariffOnlineVariable());
		 * new HomePageAction() .navigateToLogin() .login(userProfile)
		 * .navigateToProductAndServicesPage()
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToFixedPriceMay2014() .navigateToEnergySmartDualOrderPage()
		 * .yourOrderDualBG(acquisition, userProfile)
		 * .dualEnergysmartOrderDual(acquisition)
		 * .verifyThankYouPage(userProfile) .logoutFromThankYouPage();
		 * 
		 * acquisition.setTarifffordual(acquisition.gettariffFixFall()); new
		 * HomePageAction() .navigateToLogin() .login(userProfile)
		 * .navigateToProductAndServicesPage()
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToOnlineVariableAugust2013()
		 * .navigateToEnergySmartDualOrderPage() .yourOrderDualBG(acquisition,
		 * userProfile) .dualEnergysmartOrderDual(acquisition)
		 * .verifyThankYouPage(userProfile) .logoutFromThankYouPage();
		 */
	}

	@Test(groups = { Acquisition, Conversion })
	public void pureConvGasViaGap() {
		Report.createTestLogHeader("Get A Price", "Energy smart dual Journey");
		GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("Dual");
		Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");

		// Pure Conversion_ES_13

		/*
		 * acquisition.setGasSupplier("EDF Energy");
		 * acquisition.setElecSupplier("British Gas");
		 * acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyVariableDirectDebit");
		 * acquisition.setCurrentGasSupplier("Credit Meter");
		 */
		acquisition.setTarifffordual(acquisition.gettariffClearSimple());

		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToGasAndElectricityPage().navigateToGetAPricePage()
				.verifyAndEnterGAPDetails(getaPrice, userProfile).switchTariff(
						"ClearAndSimple").yourOrderDualBG(acquisition,
						userProfile).jiEnergysmartOrderJi(acquisition)
				.variableDirectDebitPayment(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.getEshopLeadID().verifyEshopLeadData().deleteWTP(userProfile)
				.backToHomePage();
	}

	@Test(groups = { Acquisition, BG })
	public void inEligibleEnergySmartJI() {

		Report.createTestLogHeader("EnergySmart Test",
				"InEligible for Energy Smart Electricity Verification");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JIAccount");
		// getCustomerDetailsToUserProfileOAM(userProfile);
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple()
				.navigateToEnergySmartDualOrderPage()
				.forcedRegistrationYourOrderPage(acquisition, userProfile)
				.inEligibleEnergySmartMessage().logoutFromThankYouPage();
	}
	// Mandatory Field: The account must have a debt balance.
	@Test(groups = { Acquisition, Conversion })
	public void convPayNowGasClearSimple() {

		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Gas Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");

		acquisition.setTariffforgas(acquisition.gettariffClearSimple());
		acquisition.setPaymentType(acquisition.getMonthlyVDD());
		acquisition.setCardType(acquisition.getVisaDebit());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple().navigateToEnergySmartGasOrderPage()
				.yourOrderGasBG(acquisition, userProfile)
				.gasBGEnergySmartGasConversion(acquisition)
				.enterPaymentOptions(acquisition).payNowOnline(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromConvThankYouPage();
	}
	// Mandatory Field: The account must have a debt balance.
	@Test(groups = { Acquisition, Conversion })
	public void convPayLaterDualFixFall() {
		Report.createTestLogHeader("Conversion Test",
				"Dual account Fix and Fall");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");

		acquisition.setTariffforgas(acquisition.gettariffFixFall());
		acquisition.setPaymentType(acquisition.getMonthlyVDD());
		acquisition.setCardType(acquisition.getVisaDebit());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToFixedPriceMay2014()
				.navigateToEnergySmartDualOrderPage().yourOrderDualBG(
						acquisition, userProfile).gasBGEnergySmartDualOrder(
						acquisition).enterPaymentOptions(acquisition)
				.payInNextMonth().payNowOnline(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromConvThankYouPage();

	}
	// Mandatory Field: The account must have a debt balance.
	@Test(groups = { Acquisition, Conversion })
	public void convPayNowJIClearSimple() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for ji Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JIAccount");

		acquisition.setTariffforgas(acquisition.gettariffClearSimple());
		acquisition.setPaymentType(acquisition.getMonthlyVDD());
		acquisition.setCardType(acquisition.getVisaDebit());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple()
				.navigateToEnergySmartDualOrderPage().yourOrderDualBG(
						acquisition, userProfile).gasBGEnergySmartDualOrder(
						acquisition).enterPaymentOptions(acquisition)
				.payInNextMonth()
				 .payNowOnline(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromConvThankYouPage();
	}
	// Dual Eligible
	// TC_05
	@Test(groups = { Acquisition, Conversion })
	public void convDualCrossClearSimpleForceLogin() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Gas Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");

		acquisition.setTariffforgas(acquisition.gettariffFixFall());
		acquisition.setPaymentType(acquisition.getMonthlyDebCredCard());
		acquisition.setCardType(acquisition.getVisaDebit());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToClearAndSimple()
				.navigateToEnergySmartDualOrderPage().forcedLoginYourOrderPage(
						acquisition, userProfile).gasBGEnergySmartDualOrder(
						acquisition).enterPaymentOptions(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromConvThankYouPage();
	}
	// TC_03
	@Test(groups = { Acquisition, Conversion })
	public void convDualCrossFixFallForceReg() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Gas Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		new ThankYouPage().deleteWTP(userProfile);
		acquisition.setTarifffordual(acquisition.gettariffFixFall());
		acquisition.setPaymentType(acquisition.getMonthlyDebCredCard());
		acquisition.setCardType(acquisition.getVisaDebit());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToClearAndSimple()
				.navigateToEnergySmartDualOrderPage()
				.forcedRegistrationYourOrderPage(acquisition, userProfile)
				.gasBGEnergySmartDualOrder(acquisition).enterPaymentOptions(
						acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.logoutFromConvThankYouPage();
	}

	
	/*
	 * -----------------------------------------------------------------Part Acquistion Part COnversion
	 */

//	For PA/PC If two or more TC methods are present in a method, Please run one by one by Commenting the other
	@Test(groups = { Acquisition, BG })
	public void convGasCAAddElecForceReg() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Gas Account Force Reg");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");

		acquisition.setTarifffordual(acquisition.gettariffClearSimple());
		acquisition.setPaymentType(acquisition.getMonthlyFixedDD());
		acquisition.setCardType(acquisition.getVisaDebit());
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage()
				.navigateToOnlineVariableAugust2013()
				.navigateToEnergySmartDualOrderPage()
				.forcedRegistrationYourOrderPage(acquisition, userProfile)
				.gasBGEnergySmartDualOrder(acquisition).enterCurrentServices(
						acquisition).enterPaymentOptions(acquisition)
				.payNowOnline(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.logoutFromConvThankYouPage();
	}
	@Test(groups = { Acquisition, BG })
	public void convElecESAddGas() {
		Report.createTestLogHeader("Part Acquisition Conversion",
				"Elec Account Energy smart to Energy smart Add Gas");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");

		acquisition.setTariffforelectricity(acquisition.gettariffClearSimple());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple()
				.navigateToEnergySmartDualOrderPage().yourOrderElecBG(
						acquisition, userProfile).energySmartElecBGOrderElec(
						acquisition, userProfile).verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromThankYouPage();

		/***********************************************************************
		 * 
		 * 
		 * Remaining TC's of ESMART
		 * 
		 * 
		 **********************************************************************/
		/*
		 * acquisition.setTariffforelectricity(acquisition.gettariffOnlineVariable());
		 * new HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToFixedPriceMay2014()
		 * .navigateToEnergySmartGasOrderPage()
		 * .forcedLoginYourOrderPage(acquisition, userProfile)
		 * .energySmartElecBGOrderElec(acquisition)
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .logoutFromThankYouPage();
		 * 
		 * 
		 * acquisition.setTariffforelectricity(acquisition.gettariffClearSimple());
		 * new HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToFixedPriceMay2014()
		 * .navigateToEnergySmartGasOrderPage()
		 * .forcedRegistrationYourOrderPage(acquisition, userProfile)
		 * .energySmartElecBGOrderElec(acquisition)
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .logoutFromThankYouPage();
		 */

	}
	@Test(groups = { Acquisition, BG })
	public void convElecCAAddGasForceLogin() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Elec Account and Add Gas Force login");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");

		acquisition.setTarifffordual(acquisition.gettariffFixFall());
		acquisition.setPaymentType(acquisition.getMonthlyFixedDD());
		acquisition.setCardType(acquisition.getVisaDebit());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToFixedPriceMay2014()
				.navigateToEnergySmartDualOrderPage().forcedLoginYourOrderPage(
						acquisition, userProfile).elecBGEnergySmartDualOrder(
						acquisition).enterCurrentServices(acquisition)
				.enterPaymentOptions(acquisition).payInNextMonth()
				.payNowOnline(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.logoutFromConvThankYouPage();
	}
	@Test(groups = { Acquisition, BG })
	public void convElecCAAddGasForceReg() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Elec Account and Add Gas Force Regist");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());

		acquisition.setTarifffordual(acquisition.gettariffOnlineVariable());
		acquisition.setPaymentType(acquisition.getMonthlyFixedDD());
		acquisition.setCardType(acquisition.getVisaDebit());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToFixedPriceMay2014()
				.navigateToEnergySmartGasOrderPage()
				.forcedRegistrationYourOrderPage(acquisition, userProfile)
				.elecBGEnergySmartDualOrder(acquisition).enterCurrentServices(
						acquisition).enterPaymentOptions(acquisition)
				.payInNextMonth().payNowOnline(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromConvThankYouPage();
	}
	@Test(groups = { Acquisition, BG })
	public void convElecIneligiAddGas() {
		Report.createTestLogHeader("Conversion Test",
				"Add Gas for Ineligible Elec");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");

		acquisition.setTariffforgas(acquisition.gettariffClearSimple());
		acquisition.setPaymentType(acquisition.getMonthlyFixedDD());
		acquisition.setCardType(acquisition.getVisaDebit());

		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple()
				.navigateToEnergySmartDualOrderPage().yourOrderElecBG(
						acquisition, userProfile)
				.elecBGEnergySmartGasAcquisition(acquisition)
				.enterCurrentServices(acquisition).enterPaymentOptions(
						acquisition).payNowOnline(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromConvThankYouPage();
	}
/*
 * ---------------------------------------------------------------------------------------End Of Regression Test Cases
 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************
	 * ***************************************************************************************
	 * **********************************************************************************
	 ****************************************** Remaining TC's of ESMART*****************************************
	 * **********************************************************************************
	 * ***************************************************************************************
	 **************************************************************************/

	// Pure Acquistion_GAP_10
	@Test(groups = { Regression, GAP, BG })
	public void newVerifyEntireOAMClearSimpleEnergyShop() {

		Report.createTestLogHeader("Get A Price",
				"End to End Journey for OAM user Fix And Fall");
		Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		GetAPrice getaPrice = new TestDataHelper()
				.getGetAPriceData("anonymous");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");
		new HomePageAction().navigateToLogin().login(userProfile);
		new GetAPriceAction().navigateToGetAQuotePage()
				.verifyAndEnterGAPDetails(getaPrice, userProfile).switchTariff(
						"ClearAndSimple");
		new AcquisitionAction().energySmartDifferentSupplyAddressDual(
				acquisition).enterPersonalDetailsPage(acquisition, userProfile)
				.enterCurrentServices(acquisition).enterPaymentOptions(
						acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).getEshopLeadID()
				.verifyEshopLeadData().backToHomePage();
	}

	@Test(groups = { Acquisition, Conversion, Zeus, Qtp })
	public void pureConversionEStoESElec() {
		Report.createTestLogHeader("Esmart Conversion",
				"Elec Account Energy smart to Energy smart");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");

		acquisition.setTariffforelectricity(acquisition.gettariffClearSimple());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple()
				.navigateToEnergySmartElectricityOrderPage().yourOrderElecBG(
						acquisition, userProfile).energySmartElecBGOrderElec(
						acquisition, userProfile).verifyThankYouPage(userProfile)
				// .backToHomePage();
				.logoutFromThankYouPage();

		acquisition.setTariffforelectricity(acquisition
				.gettariffOnlineVariable());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToFixedPriceMay2014()
				.navigateToEnergySmartElectricityOrderPage().yourOrderElecBG(
						acquisition, userProfile).energySmartElecBGOrderElec(
						acquisition,userProfile).verifyThankYouPage(userProfile)
				// .backToHomePage()
				.logoutFromThankYouPage();

		acquisition.setTariffforelectricity(acquisition.gettariffFixFall());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToOnlineVariableAugust2013()
				.navigateToEnergySmartElectricityOrderPage().yourOrderElecBG(
						acquisition, userProfile).energySmartElecBGOrderElec(
						acquisition,userProfile).verifyThankYouPage(userProfile)
				// .backToHomePage();
				.logoutFromThankYouPage();

	}

	// & Payment_TC_14
	// WebSaver Data with debt balance
	@Test(groups = { Acquisition, Conversion })
	public void pureConversionMCGas() {
		Report.createTestLogHeader("Esmart Conversion", "Gas must change");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");
		acquisition.setTariffforgas(acquisition.gettariffOnlineVariable());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToOnlineVariableAugust2013()
				.navigateToEnergySmartGasOrderPage().yourOrderGasBG(
						acquisition, userProfile)
				.gasBGEnergySmartGasConversion(acquisition)
				.enterPaymentOptions(acquisition).payInNextMonth()
				.payNowOnline(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.logoutFromThankYouPage();
	}

	// & Payment TC_17
	// WebSaver Data with debt balance
	@Test(groups = { Acquisition })
	public void pureConversionMCElec() {
		Report.createTestLogHeader("Conversion Test", "AnonymousJourney");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple()
				.navigateToEnergySmartElectricityOrderPage().yourOrderElecBG(
						acquisition, userProfile)
				.elecBGEnergySmartElecConversion(acquisition)
				.enterPaymentOptions(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.logoutFromThankYouPage();
	}

	// Payment_TC_19

	@Test(groups = { Acquisition, Conversion })
	public void conversionCTGasClearSimple() {

		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Gas Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");

		acquisition.setTariffforgas(acquisition.gettariffClearSimple());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple().navigateToEnergySmartGasOrderPage()
				.yourOrderGasBG(acquisition, userProfile)
				.gasBGEnergySmartGasConversion(acquisition)
				.variableDirectDebitPayment(acquisition).payNowOnline(
						acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.logoutFromConvThankYouPage();
	}

	// PureConversion_ChangeTariff_TC_02,Payment Tc_02
	@Test(groups = { Acquisition, Conversion })
	public void conversionCTGasOnlineVariable() {

		Report.createTestLogHeader("Conversion Test",
				"Change Tariff Forced Login for Gas Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");

		acquisition.setTariffforgas(acquisition.gettariffOnlineVariable());

		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToFixedPriceMay2014()
				.navigateToEnergySmartGasOrderPage().forcedLoginYourOrderPage(
						acquisition, userProfile)
				.gasBGEnergySmartGasConversion(acquisition)
				.enterPaymentOptions(acquisition).payInNextMonth()
				.payNowOnline(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.logoutFromConvThankYouPage();
	}

	// //PureConversion_ChangeTariff_TC_03,Payment_TC_03
	@Test(groups = { Acquisition, Conversion })
	public void conversionCTGasFixFall() {

		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Gas Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");

		acquisition.setTariffforgas(acquisition.gettariffFixFall());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToFixedPriceMay2014()
				.navigateToEnergySmartGasOrderPage()
				.forcedRegistrationYourOrderPage(acquisition, userProfile)
				.gasBGEnergySmartGasConversion(acquisition)
				.enterPaymentOptions(acquisition).payInNextMonth()
				.payNowOnline(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.logoutFromConvThankYouPage();
	}

	// PureConversion_ChangeTariff_TC_05
	@Test(groups = { Acquisition, Conversion })
	public void conversionCTElecClearSimple() {

		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Elec Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");

		acquisition.setTariffforelectricity(acquisition.gettariffClearSimple());
		acquisition.setPaymentType(acquisition.getMonthlyFixedDD());
		acquisition.setCardType(acquisition.getVisaDebit());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple()
				.navigateToEnergySmartElectricityOrderPage().yourOrderElecBG(
						acquisition, userProfile)
				.elecBGEnergySmartElecConversion(acquisition)
				.enterPaymentOptions(acquisition).payInNextMonth()
				.payNowOnline(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.logoutFromConvThankYouPage();

	}

	// PureConversion_ChangeTariff_TC_06
	@Test(groups = { Acquisition, Conversion })
	public void conversionCTElecOnlineVariable() {

		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Gas Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");

		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		acquisition.setTariffforelectricity(acquisition
				.gettariffOnlineVariable());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToFixedPriceMay2014()
				.navigateToEnergySmartElectricityOrderPage()
				.forcedRegistrationYourOrderPage(acquisition, userProfile)
				.elecBGEnergySmartElecConversion(acquisition)
				.enterPaymentOptions(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.logoutFromConvThankYouPage();

	}

	// PureConversion_ChangeTariff_TC_07 and TC_08(as fixfallmarch has been
	// ommitted)
	@Test(groups = { Acquisition, Conversion })
	public void conversionCTDualFixFall() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Gas Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");

		acquisition.setTarifffordual(acquisition.gettariffClearSimple());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToFixedPriceMay2014()
				.navigateToEnergySmartDualOrderPage().yourOrderDualBG(
						acquisition, userProfile).gasBGEnergySmartDualOrder(
						acquisition).enterPaymentOptions(acquisition)
				.payInNextMonth().payNowOnline(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromConvThankYouPage();

	}

	// PureConversion_ChangeTariff_TC_10
	@Test(groups = { Acquisition, BG })
	public void conversionCTJIOnlineVariable() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for JI Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JIAccount");

		acquisition.setTariffforgas(acquisition.gettariffOnlineVariable());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToOnlineVariableAugust2013()
				.navigateToEnergySmartDualOrderPage().yourOrderDualBG(
						acquisition, userProfile).gasBGEnergySmartDualOrder(
						acquisition).enterPaymentOptions(acquisition)
				.payInNextMonth().payNowOnline(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromConvThankYouPage();
	}

	// PureConversion_ChangeTariff_TC_11
	@Test(groups = { Acquisition, BG })
	public void conversionCTJIFixFallForceLogin() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Gas Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JIAccount");

		acquisition.setTarifffordual(acquisition.gettariffFixFall());
		// acquisition.setPaymentType("");
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToFixedPriceMay2014()
				.navigateToEnergySmartDualOrderPage().forcedLoginYourOrderPage(
						acquisition, userProfile).elecBGEnergySmartDualOrder(
						acquisition).enterPaymentOptions(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromThankYouPage();
	}

	// PureConversion_ChangeTariff_TC_12
	@Test(groups = { Acquisition, BG })
	public void conversionCTJIFixFallForceReg() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Gas Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JIAccount");

		acquisition.setTariff(acquisition.gettariffFixFall());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToFixedPriceMay2014()
				.navigateToEnergySmartDualOrderPage()
				.forcedRegistrationYourOrderPage(acquisition, userProfile)
				.elecBGEnergySmartDualOrder(acquisition).enterPaymentOptions(
						acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyLeadData()
				.logoutFromThankYouPage();
	}

	// PureConversion_ChangeTariff_TC_13
	@Test(groups = { Acquisition, BG })
	public void conversionCTGasClearSimpleGetPrice() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Gas Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");

		acquisition.setTariff(acquisition.gettariffFixFall());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToClearAndSimple()
				.navigateToEnergySmartGasOrderPage()
				.gasBGEnergySmartGasConversion(acquisition)
				.enterPaymentOptions(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyLeadData()
				.logoutFromThankYouPage();
	}

	// PureConversion_ChangeTariff_TC_14
	@Test(groups = { Acquisition, BG })
	public void conversionCTElecOnlineVariablePriceFinder() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Gas Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");

		acquisition.setTariff(acquisition.gettariffFixFall());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage()
				.navigateToOnlineVariableAugust2013()
				.navigateTOYourOrderViaPriceFinder().yourOrderElecBG(
						acquisition, userProfile)
				.elecBGEnergySmartElecConversion(acquisition)
				.enterPaymentOptions(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.verifyAuditEventID(userProfile).logoutFromConvThankYouPage();

	}

	// PureConversion_ChangeTariff_TC_15
	@Test(groups = { Acquisition, BG })
	public void coversionCTInactiveLessSixGasFixFall() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff to fix and fall for inactive Gas Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");
		SiebelDataBase siebelDataBase = new SiebelDataBase();
		siebelDataBase.setAccountStatus(userProfile.getElecAccount(), -5);
		acquisition.setTariffforgas(acquisition.gettariffFixFall());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToFixedPriceMay2014()
				.navigateToEnergySmartGasOrderPage().yourOrderGasBG(
						acquisition, userProfile)
				.gasBGEnergySmartGasConversion(acquisition)
				.enterPaymentOptions(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.verifyAuditEventID(userProfile).logoutFromConvThankYouPage();
	}

	// PureConversion_ChangeTariff_TC_17
	@Test(groups = { Acquisition, BG })
	public void coversionCTInactiveDualClearSimpleForcedReg() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff to Clear and Simple for inactive Dual Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");
		SiebelDataBase siebelDataBase = new SiebelDataBase();
		siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),
				"Contract Owner");
		siebelDataBase.setAccountStatus(userProfile.getElecAccount(), -5);
		acquisition.setTariffforgas(acquisition.gettariffClearSimple());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple().navigateToEnergySmartGasOrderPage()
				.yourOrderGasBG(acquisition, userProfile)
				.gasBGEnergySmartGasConversion(acquisition)
				.enterPaymentOptions(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.verifyAuditEventID(userProfile).logoutFromConvThankYouPage();
	}

	// InEligible scenario for pure Gas account
	@Test(groups = { Acquisition, BG })
	public void inEligibleEnergySmartGasOnly() {
		Report.createTestLogHeader("EnergySmart Test",
				"InEligible for Energy Smart Gas Verification");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");
		// getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple().navigateToEnergySmartGasOrderPage()
				.yourOrderGasBG(acquisition, userProfile)
				.inEligibleEnergySmartMessage().enterCurrentServices(
						acquisition).enterPaymentOptions(acquisition)
				.payInNextMonth().payNowOnline(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromConvThankYouPage();
	}

	// InEligible scenario for pure Electricity account
	@Test(groups = { Acquisition, BG })
	public void inEligibleEnergySmartElectricityOnly() {

		Report.createTestLogHeader("EnergySmart Test",
				"InEligible for Energy Smart Electricity Verification");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");
		// getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple()
				.navigateToEnergySmartElectricityOrderPage().yourOrderElecBG(
						acquisition, userProfile)
				.inEligibleEnergySmartMessage().enterCurrentServices(
						acquisition).enterPaymentOptions(acquisition)
				.payInNextMonth().payNowOnline(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromConvThankYouPage();
	}

	@Test(groups = { Acquisition, BG })
	public void inEligibleEnergySmartGas() {

		Report.createTestLogHeader("EnergySmart Test",
				"InEligible for Energy Smart Electricity Verification");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");
		// getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple()
				.navigateToEnergySmartDualOrderPage().yourOrderGasBG(
						acquisition, userProfile)
				.inEligibleEnergySmartMessage().logoutFromConvThankYouPage();
	}

	@Test(groups = { Acquisition, BG })
	public void inEligibleEnergySmartElec() {
		Report.createTestLogHeader("EnergySmart Test",
				"InEligible for Energy Smart Electricity Verification");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");
		// getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple()
				.navigateToEnergySmartDualOrderPage().yourOrderElecBG(
						acquisition, userProfile)
				.inEligibleEnergySmartMessage().logoutFromConvThankYouPage();
	}

	// Pay_TC_03
	// Mandatory Field: The account must have a debt balance.
	@Test(groups = { Acquisition, Conversion })
	public void convPayLaterGasFixAndFallForceReg() {

		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Gas Account Force Reg");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");

		acquisition.setTariffforgas(acquisition.gettariffFixFall());
		acquisition.setPaymentType(acquisition.getMonthlyVDD());
		acquisition.setCardType(acquisition.getVisaDebit());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToFixedPriceMay2014()
				.navigateToEnergySmartGasOrderPage()
				.forcedRegistrationYourOrderPage(acquisition, userProfile)
				.gasBGEnergySmartGasConversion(acquisition)
				.enterPaymentOptions(acquisition).payInNextMonth()
				.payNowOnline(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.logoutFromConvThankYouPage();
	}

	//

	// Pay_TC_05
	// Mandatory Field: The account must have a debt balance.
	@Test(groups = { Acquisition, Conversion })
	public void convPayLaterElecClearSimpleForcedLogin() {

		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Electricity Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");

		acquisition.setTariffforgas(acquisition.gettariffClearSimple());
		acquisition.setPaymentType(acquisition.getMonthlyDebCredCard());
		acquisition.setCardType(acquisition.getVisaDebit());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToClearAndSimple()
				.navigateToEnergySmartElectricityOrderPage()
				.forcedLoginYourOrderPage(acquisition, userProfile)
				.elecBGEnergySmartElecConversion(acquisition)
				.enterPaymentOptions(acquisition).payInNextMonth()
				.payNowOnline(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.logoutFromConvThankYouPage();
	}

	// Pay_TC_09
	// Mandatory Field: The account must have a debt balance.
	@Test(groups = { Acquisition, Conversion })
	public void convPayNowDualClearSimpleForceReg() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Gas Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");

		acquisition.setTariffforgas(acquisition.gettariffClearSimple());
		acquisition.setPaymentType(acquisition.getMonthlyVDD());
		acquisition.setCardType(acquisition.getVisaDebit());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToFixedPriceMay2014()
				.navigateToEnergySmartDualOrderPage()
				.forcedRegistrationYourOrderPage(acquisition, userProfile)
				.gasBGEnergySmartDualOrder(acquisition).enterPaymentOptions(
						acquisition).payNowOnline(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromConvThankYouPage();
	}

	// Pay_TC_12
	// Mandatory Field: The account must have a debt balance.
	@Test(groups = { Acquisition, Conversion })
	public void convPayNowJIOnlineVariableForceReg() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for JI Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JIAccount");

		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		acquisition.setTarifffordual(acquisition.gettariffOnlineVariable());
		acquisition.setPaymentType(acquisition.getMonthlyVDD());
		acquisition.setCardType(acquisition.getVisaDebit());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToFixedPriceMay2014()
				.navigateToEnergySmartDualOrderPage()
				.forcedRegistrationYourOrderPage(acquisition, userProfile)
				.dualEnergysmartOrderDual(acquisition).enterPaymentOptions(
						acquisition).payNowOnline(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromConvThankYouPage();
	}

	// TC_21
	// Mandatory Field: The account must have a debt balance.
	@Test(groups = { Acquisition, Conversion })
	public void convPayNowDualFixFallForcedReg() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff PAY NOW for dUAL Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());

		acquisition.setTariffforgas(acquisition.gettariffFixFall());
		acquisition.setPaymentType(acquisition.getMonthlyDebCredCard());
		acquisition.setCardType(acquisition.getVisaDebit());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToFixedPriceMay2014()
				.navigateToEnergySmartDualOrderPage()
				.forcedRegistrationYourOrderPage(acquisition, userProfile)
				.gasBGEnergySmartDualOrder(acquisition).enterPaymentOptions(
						acquisition).payInNextMonth().payNowOnline(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromConvThankYouPage();

	}

	// TC_23
	// Must Change JI
	// Mandatory Field: The account must have a debt balance.
	@Test(groups = { Acquisition, BG })
	public void convPayNowMCJIOnlineForceLogin() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for JI Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JIAccount");

		acquisition.setTarifffordual(acquisition.gettariffOnlineVariable());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToFixedPriceMay2014()
				.navigateToEnergySmartDualOrderPage().forcedLoginYourOrderPage(
						acquisition, userProfile).elecBGEnergySmartDualOrder(
						acquisition).enterPaymentOptions(acquisition)
				.payNowOnline(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.logoutFromThankYouPage();
	}

	// Tc_28 and TC_25
	// Can Add
	// Mandatory Field: The account must have a debt balance.
	@Test(groups = { Acquisition, Conversion })
	public void convPayNowGasFixAndFall() {

		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Gas Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");

		acquisition.setTariffforgas(acquisition.gettariffClearSimple());
		acquisition.setPaymentType(acquisition.getMonthlyDebCredCard());
		acquisition.setCardType(acquisition.getVisaDebit());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToFixedPriceMay2014()
				.navigateToEnergySmartGasOrderPage().yourOrderGasBG(
						acquisition, userProfile)
				.gasBGEnergySmartGasConversion(acquisition)
				.enterPaymentOptions(acquisition).payNowOnline(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromConvThankYouPage();
	}

	// Pay_TC_30
	// Must Change-- input must be websaver account
	@Test(groups = { Acquisition, Conversion })
	public void convPayLaterMustChangeElecClearSimple() {

		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Elec Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");
		acquisition.setTariffforgas(acquisition.gettariffClearSimple());
		acquisition.setPaymentType(acquisition.getMonthlyFixedDD());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple()
				.navigateToEnergySmartElectricityOrderPage().yourOrderElecBG(
						acquisition, userProfile)
				.elecBGEnergySmartElecConversion(acquisition)
				.enterPaymentOptions(acquisition).payInNextMonth()
				.payNowOnline(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.logoutFromConvThankYouPage();
	}

	// Pay_TC_36
	// Direct debit customer no payment
	@Test(groups = { Acquisition, Conversion })
	public void convPayDDElecFixAndFall() {

		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Elec Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");

		acquisition.setTariffforgas(acquisition.gettariffFixFall());
		acquisition.setPaymentType(acquisition.getMonthlyFixedDD());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple().navigateToElecOrderPage()
				.yourOrderElecBG(acquisition, userProfile)
				.elecBGEnergySmartElecConversion(acquisition)
				.enterPaymentOptions(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.logoutFromConvThankYouPage();
	}

	// Multi Address

	// Conv_Multi Address TC_01
	@Test(groups = { Acquisition, Conversion })
	public void convMutiAddGasClearSimple() {

		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Gas Account in Multiple address");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");

		acquisition.setTariffforgas(acquisition.gettariffClearSimple());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple().navigateToEnergySmartGasOrderPage()
				.yourOrderGasBG(acquisition, userProfile)
				.gasBGEnergySmartGasConversion(acquisition)
				.enterPaymentOptions(acquisition).payNowOnline(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromConvThankYouPage();
	}

	// Conv_Multi Address TC_02
	@Test(groups = { Acquisition, Conversion })
	public void convMultiAddElecOnlineVariable() {

		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Electricity Account with multiple address");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");

		acquisition.setTariff(acquisition.gettariffOnlineVariable());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToOnlineVariableAugust2013()
				.navigateToEnergySmartElectricityOrderPage().yourOrderElecBG(
						acquisition, userProfile)
				.elecBGEnergySmartElecConversion(acquisition)
				.enterPaymentOptions(acquisition).payNowOnline(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromConvThankYouPage();

	}

	// Dual

	// Conv_Multi Address TC_03
	@Test(groups = { Acquisition, Conversion })
	public void convMCDualFixFallForceReg() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Dual Account with multiple address");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage()
				.navigateToOnlineVariableAugust2013()
				.navigateToEnergySmartDualOrderPage()
				.forcedRegistrationYourOrderPage(acquisition, userProfile)
				.gasBGEnergySmartDualOrder(acquisition).enterPaymentOptions(
						acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.logoutFromThankYouPage();
	}

	// TC_03,04,05 Change the cross dual data accordingly
	@Test(groups = { Acquisition, BG })
	public void convDualCrossOnlineVariable() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Dual Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");

		acquisition.setTarifffordual(acquisition.gettariffOnlineVariable());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToOnlineVariableAugust2013()
				.navigateToEnergySmartDualOrderPage().yourOrderDualBG(
						acquisition, userProfile).gasBGEnergySmartDualOrder(
						acquisition).enterPaymentOptions(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromConvThankYouPage();
		// TC_05
		/*
		 * acquisition.setTarifffordual(acquisition.gettariffClearSimple());
		 * 
		 * new HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToClearAndSimple()
		 * .navigateToEnergySmartDualOrderPage()
		 * .forcedLoginYourOrderPage(acquisition, userProfile)
		 * .gasBGEnergySmartDualOrder(acquisition)
		 * .enterPaymentOptions(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .logoutFromConvThankYouPage();
		 */
	}

	// TC_06
	@Test(groups = { Acquisition, BG })
	public void convJICrossOnlineVariable() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for JI Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JIAccount");

		acquisition.setTarifffordual(acquisition.gettariffOnlineVariable());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToOnlineVariableAugust2013()
				.navigateToEnergySmartDualOrderPage().yourOrderDualBG(
						acquisition, userProfile).gasBGEnergySmartDualOrder(
						acquisition).enterPaymentOptions(acquisition)
				.payInNextMonth().payNowOnline(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromConvThankYouPage();
	}

	// Part Acquisition and Part conversion
	// must change part acq conv
	// MC_Tc_01
	@Test(groups = { Acquisition, BG })
	public void convGasCAAddElec() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Gas Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");

		acquisition.setTarifffordual(acquisition.gettariffClearSimple());
		acquisition.setPaymentType(acquisition.getMonthlyFixedDD());
		acquisition.setCardType(acquisition.getVisaDebit());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple()
				.navigateToEnergySmartDualOrderPage().yourOrderGasBG(
						acquisition, userProfile).gasBGEnergySmartDualOrder(
						acquisition).enterCurrentServices(acquisition)
				.enterPaymentOptions(acquisition).payInNextMonth()
				.payNowOnline(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.logoutFromConvThankYouPage();
	}

	// TC_02
	@Test(groups = { Acquisition, BG })
	public void convGasCAAddElecForceLogin() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Gas Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");

		acquisition.setTarifffordual(acquisition.gettariffClearSimple());
		acquisition.setPaymentType(acquisition.getMonthlyFixedDD());
		acquisition.setCardType(acquisition.getVisaDebit());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToClearAndSimple()
				.navigateToEnergySmartDualOrderPage().forcedLoginYourOrderPage(
						acquisition, userProfile).gasBGEnergySmartDualOrder(
						acquisition).enterCurrentServices(acquisition)
				.enterPaymentOptions(acquisition).payNowOnline(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromConvThankYouPage();
	}

	// MC_TC_05
	@Test(groups = { Acquisition, BG })
	public void convElecMCAddGasForceReg() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Elec Account and Add Gas");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");
		acquisition.setTarifffordual(acquisition.gettariffFixFall());
		acquisition.setPaymentType(acquisition.getMonthlyFixedDD());
		acquisition.setCardType(acquisition.getVisaDebit());
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage()
				.navigateToOnlineVariableAugust2013()
				.navigateToEnergySmartDualOrderPage()
				.forcedRegistrationYourOrderPage(acquisition, userProfile)
				.elecBGEnergySmartDualOrder(acquisition).enterCurrentServices(
						acquisition).enterPaymentOptions(acquisition)
				.payNowOnline(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.logoutFromConvThankYouPage();
	}

	@Test(groups = { Acquisition, BG })
	public void convGasMCAddElec() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Gas Account and Add Elec");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");
		acquisition.setTarifffordual(acquisition.gettariffFixFall());
		acquisition.setPaymentType(acquisition.getMonthlyFixedDD());
		acquisition.setCardType(acquisition.getVisaDebit());
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToOnlineVariableAugust2013()
				.navigateToEnergySmartDualOrderPage().yourOrderGasBG(
						acquisition, userProfile).gasBGEnergySmartDualOrder(
						acquisition).enterCurrentServices(acquisition)
				.enterPaymentOptions(acquisition).payNowOnline(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromConvThankYouPage();
	}

	@Test(groups = { Acquisition, BG })
	public void convGasESAddElec() {
		Report.createTestLogHeader("Part Acquisition Conversion",
				"Gas Account Energy smart to Energy smart Add Elec");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");

		acquisition.setTariffforgas(acquisition.gettariffClearSimple());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple()
				.navigateToEnergySmartDualOrderPage().yourOrderGasBG(
						acquisition, userProfile).energySmartGasBGOrderGas(
						acquisition).verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromThankYouPage();

		/*
		 * acquisition.setTariffforgas(acquisition.gettariffFixFall()); new
		 * HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToFixedPriceMay2014()
		 * .navigateToEnergySmartGasOrderPage()
		 * .forcedLoginYourOrderPage(acquisition, userProfile)
		 * .energySmartGasBGOrderGas(acquisition)
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .logoutFromThankYouPage();
		 * 
		 * 
		 * 
		 * new OnlineDBConnector().deRegister(userProfile.getUCRN());
		 * acquisition.setTariffforgas(acquisition.gettariffOnlineVariable());
		 * new HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToFixedPriceMay2014()
		 * .navigateToEnergySmartGasOrderPage()
		 * .forcedRegistrationYourOrderPage(acquisition, userProfile)
		 * .energySmartGasBGOrderGas(acquisition)
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .logoutFromThankYouPage();
		 */

	}

	// TC_04

	// TC_07
	@Test(groups = { Acquisition, BG })
	public void convGasCAAddElecPayLater() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Gas Account and Add Elec");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");

		acquisition.setTarifffordual(acquisition.gettariffClearSimple());
		acquisition.setPaymentType(acquisition.getMonthlyFixedDD());
		acquisition.setCardType(acquisition.getVisaDebit());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple()
				.navigateToEnergySmartDualOrderPage().yourOrderGasBG(
						acquisition, userProfile).gasBGEnergySmartDualOrder(
						acquisition).enterCurrentServices(acquisition)
				.enterPaymentOptions(acquisition).payInNextMonth()
				.payNowOnline(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.logoutFromConvThankYouPage();
		/*
		 * new HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToFixedPriceMay2014()
		 * .navigateToEnergySmartGasOrderPage()
		 * .forcedLoginYourOrderPage(acquisition, userProfile)
		 * .gasBGEnergySmartDualOrder(acquisition)
		 * .enterCurrentServices(acquisition) .enterPaymentOptions(acquisition)
		 * .payInNextMonth() .payNowOnline(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .verifyEshopLeadData() .logoutFromConvThankYouPage();
		 * 
		 * 
		 * new HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToFixedPriceMay2014()
		 * .navigateToEnergySmartGasOrderPage()
		 * .forcedRegistrationYourOrderPage(acquisition, userProfile)
		 * .gasBGEnergySmartDualOrder(acquisition)
		 * .enterCurrentServices(acquisition) .enterPaymentOptions(acquisition)
		 * .payInNextMonth() .payNowOnline(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .verifyEshopLeadData() .logoutFromConvThankYouPage();
		 */
	}

	// Part Acq TC_04

	@Test(groups = { Acquisition, BG })
	public void convElecCAAddGasPayLater() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Elec Account and Add Gas");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");

		acquisition.setTarifffordual(acquisition.gettariffClearSimple());
		acquisition.setPaymentType(acquisition.getMonthlyFixedDD());
		acquisition.setCardType(acquisition.getVisaDebit());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple()
				.navigateToEnergySmartDualOrderPage().yourOrderElecBG(
						acquisition, userProfile).elecBGEnergySmartDualOrder(
						acquisition).enterCurrentServices(acquisition)
				.enterPaymentOptions(acquisition).payInNextMonth()
				.payNowOnline(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.logoutFromConvThankYouPage();
	}

	@Test(groups = { Acquisition, BG })
	public void convGasMultiAddressAddElec() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Gas Account in multi address");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");

		acquisition.setTarifffordual(acquisition.gettariffClearSimple());
		acquisition.setPaymentType(acquisition.getMonthlyFixedDD());
		acquisition.setCardType(acquisition.getVisaDebit());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple()
				.navigateToEnergySmartDualOrderPage().yourOrderGasBG(
						acquisition, userProfile).gasBGEnergySmartDualOrder(
						acquisition).enterCurrentServices(acquisition)
				.enterPaymentOptions(acquisition).payNowOnline(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromConvThankYouPage();
	}

	@Test(groups = { Acquisition, BG })
	public void convGasIneligiAddElec() {
		Report.createTestLogHeader("Conversion Test",
				"Add Elec for Ineligible gas");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");

		acquisition.setTarifffordual(acquisition.gettariffClearSimple());
		acquisition.setPaymentType(acquisition.getMonthlyFixedDD());
		acquisition.setCardType(acquisition.getVisaDebit());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple()
				.navigateToEnergySmartDualOrderPage().yourOrderGasBG(
						acquisition, userProfile).gasBGEnergySmartDualOrder(
						acquisition).enterCurrentServices(acquisition)
				.enterPaymentOptions(acquisition).payNowOnline(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromConvThankYouPage();
	}

	// partacq,conv_Ineligib_TC09
	@Test(groups = { Acquisition, BG })
	public void jiGasConvIneligi() {
		Report.createTestLogHeader("EnergySmart Test",
				"InEligible for Energy Smart Gas Conversion for JI account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JIAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple().navigateToEnergySmartGasOrderPage()
				.yourOrderGasBG(acquisition, userProfile)
				.inEligibleEnergySmartMessage().logoutFromThankYouPage();
	}

	@Test(groups = { FunctionalCategory.Acquisition })
	public void OnlineVariableAugust2013Acquisition() {
		/***********************************************************************
		 * 
		 * 
		 * Remaining TC's of ESMART
		 * 
		 * 
		 **********************************************************************/
		Report.createTestLogHeader("onlineVariableAugust2013",
				"Dual, Gas , Elec");
		Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("NewUser");
		Report.updateTestLog(
				"************Pure Acquisition_ES_30***************", "DONE");
		// Pure Acquisition_ES_30

		userProfile.setNectarValue("2");
		acquisition.setGasSupplier("EDF Energy");
		acquisition.setFuelType("dual");
		acquisition.setPaymentType("MonthlyDD");
		acquisition.setCurrentGasSupplier("Credit Meter");
		acquisition.setCurrentElecSupplier("Two Rate / Economy 7 Credit");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage()
				.navigateToOnlineVariableAugust2013()
				.navigateToEnergySmartGasOrderPage()
				.yourOrderAnonymousNavigation(acquisition, userProfile)
				.onlineAccountPersonalDetailsPageNavigation(acquisition,
						userProfile).gasDefaultCurrentServicesPageNavigation(
						acquisition).enterPaymentOptions(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().getEshopLeadID().verifyAuditEventID(
						userProfile).domarssalesRunBatch(
						acquisition.getShopBatch()).checkMediaCode(
						acquisition.getDualonlineenergyTariffCode())//
				.deleteWTP(userProfile);

		userProfile.setNectarValue("2");
		acquisition.setGasSupplier("EDF Energy");
		acquisition.setFuelType("dual");
		acquisition.setPaymentType("MonthlyDD");
		acquisition.setCurrentGasSupplier("Credit Meter");
		acquisition.setCurrentElecSupplier("Two Rate / Economy 7 Credit");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage()
				.navigateToOnlineVariableAugust2013()
				.navigateToEnergySmartElectricityOrderPage()
				.yourOrderAnonymousNavigation(acquisition, userProfile)
				.onlineAccountPersonalDetailsPageNavigation(acquisition,
						userProfile).gasDefaultCurrentServicesPageNavigation(
						acquisition).enterPaymentOptions(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().getEshopLeadID().verifyAuditEventID(
						userProfile).domarssalesRunBatch(
						acquisition.getShopBatch()).checkMediaCode(
						acquisition.getDualonlineenergyTariffCode())//
				.deleteWTP(userProfile);
		userProfile.setNectarValue("2");
		acquisition.setGasSupplier("EDF Energy");
		acquisition.setFuelType("dual");
		acquisition.setPaymentType("MonthlyDD");
		acquisition.setCurrentGasSupplier("Credit Meter");
		acquisition.setCurrentElecSupplier("Two Rate / Economy 7 Credit");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage()
				.navigateToOnlineVariableAugust2013()
				.navigateToEnergySmartDualOrderPage()
				.yourOrderAnonymousNavigation(acquisition, userProfile)
				.onlineAccountPersonalDetailsPageNavigation(acquisition,
						userProfile).gasDefaultCurrentServicesPageNavigation(
						acquisition).enterPaymentOptions(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().getEshopLeadID().verifyAuditEventID(
						userProfile).domarssalesRunBatch(
						acquisition.getShopBatch()).checkMediaCode(
						acquisition.getDualonlineenergyTariffCode())//
				.deleteWTP(userProfile);

		/*
		 * Report.updateTestLog("************Pure
		 * Acquisition_ES_32***************", "DONE"); // Pure Acquisition_ES_32
		 * 
		 * 
		 * userProfile.setNectarValue("4"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setFuelType("dual");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter");
		 * acquisition.setCurrentElecSupplier("Two Rate / Economy 7 Credit");
		 * new OnlineDBConnector().deRegister(userProfile.getUCRN()); new
		 * HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToOnlineVariableAugust2013()
		 * .navigateToEnergySmartDualOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .QuarterlyCashCheque(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID()
		 * 
		 * .deleteWTP(userProfile) ;
		 * 
		 * Report.updateTestLog("************Pure
		 * Acquisition_ES_93***************", "DONE"); // Pure Acquisition_ES_93
		 * new OnlineDBConnector().deRegister(userProfile.getUCRN());
		 * userProfile.setNectarValue("3"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setElecSupplier("EDF Energy");
		 * acquisition.setFuelType("dual");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter");
		 * acquisition.setCurrentElecSupplier("Two Rate / Economy 7 Credit");
		 * new HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToOnlineVariableAugust2013()
		 * .navigateToEnergySmartDualOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .QuarterlyCashCheque(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID()
		 * 
		 * .deleteWTP(userProfile) ; Report.updateTestLog("************Pure
		 * Acquisition_ES_05***************", "DONE"); // Pure Acquisition_ES_05
		 * new OnlineDBConnector().deRegister(userProfile.getUCRN());
		 * userProfile.setNectarValue("1"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setElecSupplier("EDF Energy");
		 * acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyVariableDirectDebit");
		 * acquisition.setCurrentGasSupplier("Credit Meter"); new
		 * HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToOnlineVariableAugust2013()
		 * .navigateToEnergySmartGasOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .enterPaymentOptions(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID()
		 * 
		 * .deleteWTP(userProfile) ; Report.updateTestLog("************Pure
		 * Acquisition_ES_06***************", "DONE"); // Pure Acquisition_ES_06
		 * new OnlineDBConnector().deRegister(userProfile.getUCRN());
		 * userProfile.setNectarValue("2"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setElecSupplier("EDF Energy");
		 * acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter"); new
		 * HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToOnlineVariableAugust2013()
		 * .navigateToEnergySmartGasOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .enterPaymentOptions(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID()
		 * 
		 * .deleteWTP(userProfile) ; Report.updateTestLog("************Pure
		 * Acquisition_ES_08***************", "DONE"); // Pure Acquisition_ES_08
		 * new OnlineDBConnector().deRegister(userProfile.getUCRN());
		 * userProfile.setNectarValue("4"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setElecSupplier("EDF Energy");
		 * acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter"); new
		 * HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToOnlineVariableAugust2013()
		 * .navigateToEnergySmartGasOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .enterPaymentOptions(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID()
		 * 
		 * .deleteWTP(userProfile) ; Report.updateTestLog("************Pure
		 * Acquisition_ES_17***************", "DONE"); // Pure Acquisition_ES_17
		 * new OnlineDBConnector().deRegister(userProfile.getUCRN());
		 * userProfile.setNectarValue("1"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setElecSupplier("EDF Energy");
		 * acquisition.setFuelType("Elec");
		 * acquisition.setPaymentType("MonthlyVariableDirectDebit");
		 * acquisition.setCurrentElecSupplier("Single Rate Credit"); new
		 * HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToOnlineVariableAugust2013()
		 * .navigateToEnergySmartElectricityOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .QuarterlyCashCheque(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID()
		 * 
		 * .deleteWTP(userProfile); Report.updateTestLog("************Pure
		 * Acquisition_ES_19***************", "DONE"); // Pure Acquisition_ES_19
		 * new OnlineDBConnector().deRegister(userProfile.getUCRN());
		 * userProfile.setNectarValue("3"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setElecSupplier("EDF Energy");
		 * acquisition.setFuelType("Elec");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentElecSupplier("Single Rate Credit"); new
		 * HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToOnlineVariableAugust2013()
		 * .navigateToEnergySmartElectricityOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .QuarterlyCashCheque(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID()
		 * 
		 * .deleteWTP(userProfile); Report.updateTestLog("************Pure
		 * Acquisition_ES_20***************", "DONE"); // Pure Acquisition_ES_20
		 * new OnlineDBConnector().deRegister(userProfile.getUCRN());
		 * userProfile.setNectarValue("4"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setElecSupplier("EDF Energy");
		 * acquisition.setFuelType("Elec");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentElecSupplier("Single Rate Credit"); new
		 * HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToOurTariffsPage() .navigateToOnlineVariableAugust2013()
		 * .navigateToEnergySmartElectricityOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .QuarterlyCashCheque(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .getEshopLeadID()
		 * 
		 * .deleteWTP(userProfile);
		 */

	}

	@Test(groups = { Acquisition, Conversion, Zeus, Qtp })
	public void validateErrorReviewPage() {// Pure Acquisition_ES_106
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("NewUser");
		Report.createTestLogHeader("Acquisition Test",
				" Your Order Page Validation");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToClearAndSimple()
				.navigateToEnergySmartGasOrderPage()
				.yourOrderAnonymousNavigation(acquisition, userProfile)
				.enterPersonalDetailsPage(acquisition, userProfile)
				.enterCurrentServices(acquisition).enterPaymentOptions(
						acquisition).errorReviewOrder();
	}

	@Test(groups = { FunctionalCategory.Acquisition, Regression, Complex })
	public void validateYourOrderPage() {
		// Pure Acquisition_ES_100
		Report.createTestLogHeader("Acquisition Test",
				"GASConversionElectricityDualAcquisitionOAM");
		ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.ReFactoring_Esmart_Yourorder_ErrorCode);
		
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("NewUser");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToClearAndSimple()
				.navigateToEnergySmartGasOrderPage().validateYourOrderCQ5(errList);

	}

	@Test(groups = { FunctionalCategory.Acquisition })
	public void priceFinderClearAndSimple() {
		Report.createTestLogHeader("Clear And Simple Acquisition",
				"Price Finder - Anonymous");
		Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("NewUser");
		// Pure Acquisition_PF_04
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		acquisition.setElecSupplier("EDF Energy");
		acquisition.setGasSupplier("EDF Energy");
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToClearAndSimple()
				.navigateToPriceFinder().fillPriceFinder(userProfile)
				.navigateWithEsmart().gasFuelTypeSelect()
				.yourOrderAnonymousNavigation(acquisition, userProfile)
				.enterPersonalDetailsPage(acquisition, userProfile)
				.gasDefaultCurrentServicesPageNavigation(acquisition)
				.enterPaymentOptions(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.getEshopLeadID().deleteWTP(userProfile);

	}

	@Test(groups = { FunctionalCategory.Acquisition, Regression, Complex })
	public void validatePersonaleDetails() {
		// Pure Acquisition_ES_101
		// Pure Acquisition_ES_102
		// Pure Acquisition_ES_104
		Report.createTestLogHeader("Acquisition Test",
				"GASConversionElectricityDualAcquisitionOAM");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("NewUser");
		ArrayList<String> errList = new HomePageAction().navigateToCQ5List(GlobalErrorMessages.ReFactoring_Esmart_Yourorder_ErrorCode);
		
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToClearAndSimple()
				.navigateToEnergySmartGasOrderPage()
				.yourOrderAnonymousNavigation(acquisition, userProfile)
				.enterPersonalDetailsPage(acquisition, userProfile)
				.validateCurrentServicesCQ5(errList);

	}

	@Test(groups = { FunctionalCategory.Acquisition, Regression, Complex })
	public void servicesGasElecDualAcquisitionClearAndSimpleTariff() {
		Report.createTestLogHeader("Acquisition ClearAndSimple Scenario",
				"HomeSerivcesAccount");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");
		// getCustomerDetailsToUserProfileOAM(userProfile);

		// Pure Acquisition_ES_37
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple().navigateToEnergySmartGasOrderPage()
				.yourOrderAnonymousNavigation(acquisition, userProfile)
				.enterPersonalDetailsPage(acquisition, userProfile)
				.enterCurrentServices(acquisition).enterPaymentOptions(
						acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.getEshopLeadID().verifyAuditEventID(userProfile)
				.logoutFromThankYouPage().navigateToLogin().login(userProfile);

	}

	@Test(groups = { FunctionalCategory.Acquisition, Regression, Complex })
	public void servicesGasElecDualAcquisitionFixedPriceMay2014Tariff() {
		Report.createTestLogHeader("Acquisition Scenario",
				"HomeSerivcesAccount");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("ElecConversion");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("HomeServciesAccount");
		// Pure Acquisition_ES_39
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToOnlineVariableAugust2013()
				.navigateToEnergySmartDualOrderPage()
				.yourOrderAnonymousNavigation(acquisition, userProfile)
				.enterPersonalDetailsPage(acquisition, userProfile)
				.enterCurrentServices(acquisition).enterPaymentOptions(
						acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.getEshopLeadID().verifyAuditEventID(userProfile)
				.logoutFromThankYouPage();
	}

	@Test(groups = { FunctionalCategory.Acquisition, Regression, Complex })
	public void clearAndSimpleEnergySmartAcquisition() {
		Report.createTestLogHeader("Acquisition", "Gas through Join BG");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("NewUser");
		// Pure Acquisition_ES_86
		/*
		 * new OnlineDBConnector().deRegister(userProfile.getUCRN());
		 * userProfile.setNectarValue("1"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyVariableDirectDebit");
		 * acquisition.setCurrentGasSupplier("Credit Meter"); new
		 * HomePageAction()
		 * 
		 * .navigateToGasAndElectricityPage() .navigateToEnergySmartPage()
		 * .navigateToAddEnergySmartPage() .navigateToJoinBG()
		 * //.navigateToOurTariffsPage() .navigateToClearAndSimpleXpath()
		 * .navigateToEnergySmartGasOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .enterPaymentOptions(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .verifyEshopLeadData() .getEshopLeadID() .deleteWTP(userProfile);
		 */

		// Pure Acquisition_ES_87
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		userProfile.setNectarValue("4");
		acquisition.setGasSupplier("EDF Energy");
		acquisition.setFuelType("Gas");
		acquisition.setPaymentType("MonthlyDD");
		acquisition.setCurrentGasSupplier("Credit Meter");
		new HomePageAction()

		.navigateToGasAndElectricityPage().navigateToEnergySmartPage()
				.navigateToAddEnergySmartPage().navigateToJoinBG()
				.navigateToOnlineVariableAugust2013Xpath()
				.navigateToEnergySmartGasOrderPage()
				.yourOrderAnonymousNavigation(acquisition, userProfile)
				.enterPersonalDetailsPage(acquisition, userProfile)
				.enterCurrentServices(acquisition).enterPaymentOptions(
						acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.getEshopLeadID().deleteWTP(userProfile);

		// Pure Acquisition_ES_89
		/*
		 * new OnlineDBConnector().deRegister(userProfile.getUCRN());
		 * userProfile.setNectarValue("3"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setFuelType("Elec");
		 * acquisition.setPaymentType("MonthlyVariableDirectDebit");
		 * acquisition.setCurrentElecSupplier("Single Rate Credit"); new
		 * HomePageAction()
		 * 
		 * .navigateToGasAndElectricityPage() .navigateToEnergySmartPage()
		 * .navigateToAddEnergySmartPage() .navigateToJoinBG()
		 * .navigateToClearAndSimpleXpath()
		 * .navigateToEnergySmartElectricityOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .enterPaymentOptions(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .verifyEshopLeadData() .getEshopLeadID() .deleteWTP(userProfile);
		 *  // Pure Acquisition_ES_90 /*new
		 * OnlineDBConnector().deRegister(userProfile.getUCRN());
		 * userProfile.setNectarValue("3"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setFuelType("Elec");
		 * acquisition.setPaymentType("MonthlyVariableDirectDebit");
		 * acquisition.setCurrentElecSupplier("Single Rate Credit"); new
		 * HomePageAction()
		 * 
		 * .navigateToGasAndElectricityPage() .navigateToEnergySmartPage()
		 * .navigateToAddEnergySmartPage() .navigateToJoinBG()
		 * .navigateToFixedPriceMay2014Xpath()
		 * .navigateToEnergySmartElectricityOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .enterPaymentOptions(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .verifyEshopLeadData() .getEshopLeadID() .deleteWTP(userProfile);
		 */

		// Pure Acquisition_ES_92
		/*
		 * new OnlineDBConnector().deRegister(userProfile.getUCRN());
		 * userProfile.setNectarValue("3"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setFuelType("Elec");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter");
		 * acquisition.setCurrentElecSupplier("Single Rate Credit"); new
		 * HomePageAction()
		 * 
		 * .navigateToGasAndElectricityPage() .navigateToEnergySmartPage()
		 * .navigateToAddEnergySmartPage() .navigateToJoinBG()
		 * .navigateToClearAndSimpleXpath()
		 * .navigateToEnergySmartDualOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .enterPaymentOptions(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .verifyEshopLeadData() .getEshopLeadID() .deleteWTP(userProfile);
		 *  // Pure Acquisition_ES_94 new
		 * OnlineDBConnector().deRegister(userProfile.getUCRN());
		 * userProfile.setNectarValue("3"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setFuelType("Elec");
		 * acquisition.setPaymentType("MonthlyVariableDirectDebit");
		 * acquisition.setCurrentGasSupplier("Credit Meter");
		 * acquisition.setCurrentElecSupplier("Single Rate Credit"); new
		 * HomePageAction()
		 * 
		 * .navigateToGasAndElectricityPage() .navigateToEnergySmartPage()
		 * .navigateToAddEnergySmartPage() .navigateToJoinBG()
		 * .navigateToFixedPriceMay2014Xpath()
		 * .navigateToEnergySmartDualOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .enterPaymentOptions(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .verifyEshopLeadData() .getEshopLeadID() .deleteWTP(userProfile);
		 *  // Pure Acquisition_ES_93 /* new
		 * OnlineDBConnector().deRegister(userProfile.getUCRN());
		 * userProfile.setNectarValue("3"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setFuelType("Elec");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter");
		 * acquisition.setCurrentElecSupplier("Single Rate Credit"); new
		 * HomePageAction()
		 * 
		 * .navigateToGasAndElectricityPage() .navigateToEnergySmartPage()
		 * .navigateToAddEnergySmartPage() .navigateToJoinBG()
		 * .navigateToFixedPriceMay2014Xpath()
		 * .navigateToEnergySmartDualOrderPage()
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .enterPaymentOptions(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .verifyEshopLeadData() .getEshopLeadID() .deleteWTP(userProfile);
		 */
	}

	@Test(groups = { Regression, GAP })
	public void verifyAnonymousEnergyShopJourneyESmartElec() {
		Report.createTestLogHeader("Get A Price", "Energy Shop Elec Journey");
		GetAPrice getaPrice = new TestDataHelper()
				.getGetAPriceData("anonymous");
		Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");

		// Pure Acquisition_GAP_04

		userProfile.setNectarValue("1");
		acquisition.setGasSupplier("EDF Energy");
		acquisition.setElecSupplier("British Gas");
		acquisition.setFuelType("Gas");
		acquisition.setPaymentType("MonthlyVariableDirectDebit");
		acquisition.setCurrentGasSupplier("Credit Meter");
		acquisition.setTarifffordual(acquisition.gettariffClearSimple());

		new HomePageAction()
				.navigateToGasAndElectricityPage()
				.navigateToGetAPricePage()
				.verifyAndEnterGAPDetails(getaPrice, userProfile)
				.switchTariff("OnlineVariable")
				// .yourOrderDualBG(acquisition, userProfile)
				.forcedLoginOnly(acquisition, userProfile)
				.elecBGEnergySmartDualAcquisition(acquisition)
				.gasDefaultCurrentServicesPageNavigation(acquisition)
				.enterPaymentOptions(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).getEshopLeadID()
				.verifyEshopLeadData().deleteWTP(userProfile).backToHomePage();

		// Pure Acquisition_GAP_07

		/*
		 * userProfile.setNectarValue("3"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setElecSupplier("British Gas");
		 * acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter");
		 * acquisition.setTarifffordual(acquisition.gettariffClearSimple());
		 * 
		 * new HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToGetAPricePage() .verifyAndEnterGAPDetails(getaPrice,
		 * userProfile) .switchTariff(getaPrice)
		 * //.energySmartAcquisitionYourOrderPage(acquisition,userProfile)
		 * .forcedRegisrationOnly(acquisition, userProfile)
		 * .energySmartPersonalDetailsPage(acquisition)
		 * .elecBGEnergySmartDualAcquisition(acquisition)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .enterPaymentOptions(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .getEshopLeadID()
		 * .verifyEshopLeadData() .deleteWTP(userProfile) .backToHomePage();
		 *  // Pure Acquisition_GAP_10
		 * 
		 * userProfile.setNectarValue("3"); acquisition.setGasSupplier("British
		 * Gas"); acquisition.setElecSupplier("British Gas");
		 * acquisition.setFuelType("Dual");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter");
		 * 
		 * new HomePageAction() .navigateToLogin() .login(userProfile)
		 * .navigateToGasAndElectricityPage() .navigateToGetAPricePage()
		 * .verifyAndEnterGAPDetails(getaPrice, userProfile)
		 * .switchTariff(getaPrice)
		 * .energySmartAcquisitionYourOrderPage(acquisition,userProfile)
		 * .energySmartDifferentSupplyAddressDual(acquisition)
		 * .energySmartPersonalDetailsPage(acquisition)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .enterPaymentOptions(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .getEshopLeadID()
		 * .verifyEshopLeadData() .deleteWTP(userProfile) .backToHomePage();
		 *  // Pure Acquisition_GAP_12
		 * 
		 * userProfile.setNectarValue("1"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setElecSupplier("British Gas");
		 * acquisition.setFuelType("Dual");
		 * acquisition.setPaymentType("MonthlyVariableDirectDebit");
		 * acquisition.setCurrentGasSupplier("Credit Meter");
		 * 
		 * new HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToGetAPricePage() .verifyAndEnterGAPDetails(getaPrice,
		 * userProfile) .switchTariff(getaPrice)
		 * .energySmartAcquisitionYourOrderPage(acquisition,userProfile)
		 * .forcedLoginOnly(acquisition, userProfile)
		 * .energySmartPersonalDetailsPage(acquisition)
		 * .gasDefaultCurrentServicesPageNavigation(acquisition)
		 * .enterPaymentOptions(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .getEshopLeadID()
		 * .verifyEshopLeadData() .deleteWTP(userProfile) .backToHomePage();
		 */

	}

	@Test(groups = { Regression, GAP })
	public void verifyAnonymousEnergyShopJourneyGasOAM() {
		/*
		 * Report.createTestLogHeader("Get A Price", "Energy Shop Gas Journey");
		 * GetAPrice getaPrice = new
		 * TestDataHelper().getGetAPriceData("anonymous"); Acquisition
		 * acquisition = new
		 * TestDataHelper().getAcquisitionData("standardDualAcquisition");
		 * UserProfile userProfile = new
		 * TestDataHelper().getUserProfile("ElectricityAccount");
		 *  // Pure Acquisition_GAP_07
		 * 
		 * userProfile.setNectarValue("1"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setElecSupplier("EDF Energy");
		 * acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter");
		 * acquisition.setCurrentElecSupplier("Single Rate Credit"); new
		 * HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToGetAPricePage() .verifyAndEnterGAPDetails(getaPrice,
		 * userProfile) .switchTariff(getaPrice)
		 * .forcedRegisrationOnly(acquisition,userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .enterPaymentOptions(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .getLeadID() .verifyLeadData()
		 * .domarssalesRunBatch(acquisition.getShopBatch())
		 * .checkMediaCode(acquisition.getDualCsCode()) .deleteWTP(userProfile)
		 * .backToHomePage();
		 *  // Pure Acquisition_GAP_04
		 * 
		 * userProfile.setNectarValue("1"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setElecSupplier("EDF Energy");
		 * acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyVariableDirectDebit");
		 * acquisition.setCurrentGasSupplier("Credit Meter");
		 * acquisition.setCurrentElecSupplier("Single Rate Credit"); new
		 * HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToGetAPricePage() .verifyAndEnterGAPDetails(getaPrice,
		 * userProfile) .switchTariff(getaPrice)
		 * .forcedLoginOnly(acquisition,userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .enterPaymentOptions(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .getLeadID() .verifyLeadData()
		 * .domarssalesRunBatch(acquisition.getShopBatch())
		 * .checkMediaCode(acquisition.getDualCsCode()) .deleteWTP(userProfile)
		 * .backToHomePage();
		 * 
		 *  // Pure Acquisition_GAP_11
		 * 
		 * userProfile.setNectarValue("1"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setElecSupplier("EDF Energy");
		 * acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyDD");
		 * acquisition.setCurrentGasSupplier("Credit Meter");
		 * acquisition.setCurrentElecSupplier("Single Rate Credit"); new
		 * HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToGetAPricePage() .verifyAndEnterGAPDetails(getaPrice,
		 * userProfile) .switchTariff(getaPrice)
		 * .forcedLoginOnly(acquisition,userProfile)
		 * .energySmartDifferentSupplyAddressDual(acquisition)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .enterPaymentOptions(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .getLeadID() .verifyLeadData()
		 * .domarssalesRunBatch(acquisition.getShopBatch())
		 * .checkMediaCode(acquisition.getDualCsCode()) .deleteWTP(userProfile)
		 * .backToHomePage();
		 * 
		 *  // Pure Acquisition_GAP_12
		 * 
		 * userProfile.setNectarValue("1"); acquisition.setGasSupplier("EDF
		 * Energy"); acquisition.setElecSupplier("EDF Energy");
		 * acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthlyVariableDirectDebit");
		 * acquisition.setCurrentGasSupplier("Credit Meter");
		 * acquisition.setCurrentElecSupplier("Single Rate Credit"); new
		 * HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToGetAPricePage() .verifyAndEnterGAPDetails(getaPrice,
		 * userProfile) .switchTariff(getaPrice)
		 * .forcedLoginOnly(acquisition,userProfile)
		 * .energySmartDifferentSupplyAddressDual(acquisition)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .enterPaymentOptions(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .getLeadID() .verifyLeadData()
		 * .domarssalesRunBatch(acquisition.getShopBatch())
		 * .checkMediaCode(acquisition.getDualCsCode()) .deleteWTP(userProfile)
		 * .backToHomePage();
		 */
	}

	@Test(groups = { Acquisition, Conversion, Zeus, Qtp })
	public void ConversionDualOnline() {

		Report.createTestLogHeader("Conversion Test", "ConversionDual");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");
		// getCustomerDetailsToUserProfileOAM(userProfile);

		// Pure Conversion_CA_07
		acquisition.setPaymentType("MonthDD");
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToOnlineEnergyTariffPage().navigateToDualOrderPage()
				.yourOrderDualBG(acquisition, userProfile)
				.gasBGEnergySmartDualOrder(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().verifyAuditEventID(userProfile)
				.logoutFromConvThankYouPage().changeTariff(
						userProfile.getGasAccount());

		// Pure Conversion_CA_18
		// inactive elec account
		acquisition.setPaymentType("MonthDD");
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToOnlineEnergyTariffPage().navigateToDualOrderPage()
				.yourOrderDualBG(acquisition, userProfile)
				.gasBGEnergySmartDualOrder(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().verifyAuditEventID(userProfile)
				.logoutFromConvThankYouPage().changeTariff(
						userProfile.getGasAccount());
	}

	@Test(groups = { Acquisition, Conversion, Zeus, Qtp })
	public void ConversionElecOnline() {

		Report.createTestLogHeader("Conversion Test", "ConversionElec");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");
		// getCustomerDetailsToUserProfileOAM(userProfile);

		// Pure Conversion_CA_04
		/*
		 * acquisition.setFuelType("Elec"); acquisition.setElecSupplier("EDF
		 * Energy"); acquisition.setPaymentType("MonthDD");
		 * acquisition.setTariffforelectricity(acquisition.gettariffOnlineVariable());
		 * new HomePageAction() .navigateToLogin() .login(userProfile)
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToOnlineVariableAugust2013()
		 * .navigateToEnergySmartElectricityOrderPage()
		 * .yourOrderElecBG(acquisition,userProfile)
		 * .elecBGEnergySmartElecConversion(acquisition)
		 * .enterPaymentOptions(acquisition) .payInNextMonth()
		 * .payNowOnline(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .verifyAuditEventID(userProfile) .logoutFromConvThankYouPage()
		 * .changeTariff(userProfile.getGasAccount());
		 */
		// Pure Conversion_CA_05
		acquisition.setTariffforelectricity(acquisition
				.gettariffOnlineVariable());
		acquisition.setFuelType("Elec");
		acquisition.setPaymentType("MonthDD");
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToFixedPriceMay2014()
				.navigateToEnergySmartElectricityOrderPage()
				.forcedLoginYourOrderPage(acquisition, userProfile)
				.elecBGEnergySmartElecConversion(acquisition)
				.enterPaymentOptions(acquisition).payInNextMonth()
				.payNowOnline(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.verifyAuditEventID(userProfile).logoutFromConvThankYouPage()
				.changeTariff(userProfile.getGasAccount());
		// Pure Conversion_CA_06
		acquisition.setFuelType("Elec");
		acquisition.setPaymentType("MonthDD");
		acquisition.setTariffforelectricity(acquisition.gettariffClearSimple());
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		new HomePageAction()
				.navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage()
				.navigateToClearAndSimple()
				.navigateToEnergySmartElectricityOrderPage()
				.forcedRegistrationYourOrderPage(acquisition, userProfile)
				// .enterPersonalDetailsPage(acquisition, userProfile)
				.elecBGEnergySmartElecConversion(acquisition)
				// .enterCurrentServices(acquisition)
				.enterPaymentOptions(acquisition).payNowOnline(acquisition)
				.payInNextMonth()

				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().verifyAuditEventID(userProfile)
				.logoutFromConvThankYouPage().changeTariff(
						userProfile.getGasAccount());

		// Pure Conversion_CA_13
		acquisition.setPaymentType("MonthDD");
		acquisition.setTariffforelectricity(acquisition.gettariffClearSimple());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage()
				.navigateToOnlineVariableAugust2013()
				.navigateToEnergySmartGasOrderPage().forcedLoginOnly(
						acquisition, userProfile).enterPersonalDetailsPage(
						acquisition, userProfile)
				.elecBGEnergySmartElecConversion(acquisition)
				.enterPaymentOptions(acquisition).payInNextMonth()
				.payNowOnline(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.verifyAuditEventID(userProfile).logoutFromConvThankYouPage()
				.changeTariff(userProfile.getGasAccount());
	}

	@Test(groups = { Acquisition, Conversion, Zeus, Qtp })
	public void ConversionOnlineVariableAugust2013() {
		Report.createTestLogHeader("Conversion Test",
				"Gas Account Conversion OnlineVariableAugust2013");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");
		// getCustomerDetailsToUserProfileOAM(userProfile);

		// Pure Conversion_CA_10
		acquisition.setPaymentType("MonthDD");
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToOnlineVariableAugust2013().navigateToDualOrderPage()
				.yourOrderDualBG(acquisition, userProfile)
				.gasBGEnergySmartDualOrder(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().verifyAuditEventID(userProfile)
				.logoutFromConvThankYouPage().changeTariff(
						userProfile.getAccNumber());

	}

	@Test(groups = { Acquisition, Conversion, Zeus, Qtp })
	public void verifyAnonymousEnergyShopJourneyElec() {
		Report.createTestLogHeader("Get A Price",
				"Energy Shop Anonymous Journey");
		GetAPrice getaPrice = new TestDataHelper()
				.getGetAPriceData("anonymous");
		Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("NewUser");

		// Pure Conversion_CA_02
		acquisition.setFuelType("Gas");
		acquisition.setPaymentType("MonthDD");
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToGetAPricePage().verifyAndEnterGAPDetails(getaPrice,
						userProfile).switchTariff(getaPrice).forcedLoginOnly(
						acquisition, userProfile).enterPersonalDetailsPage(
						acquisition, userProfile).enterCurrentServices(
						acquisition).enterPaymentOptions(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.getLeadID().verifyLeadData().domarssalesRunBatch(
						acquisition.getShopBatch()).backToHomePage();

		/*
		 * //Pure Conversion_CA_01 acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthDD"); new HomePageAction()
		 * .navigateToGasAndElectricityPage() .navigateToGetAPricePage()
		 * .verifyAndEnterGAPDetails(getaPrice, userProfile)
		 * .switchTariff(getaPrice)
		 * .yourOrderAnonymousNavigation(acquisition,userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .enterPaymentOptions(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .getLeadID() .verifyLeadData()
		 * .domarssalesRunBatch(acquisition.getShopBatch()) .backToHomePage();
		 * 
		 * 
		 * //Pure Conversion_CA_09
		 * 
		 * acquisition.setFuelType("dual");
		 * acquisition.setPaymentType("MonthDD"); new HomePageAction()
		 * .navigateToGasAndElectricityPage() .navigateToGetAPricePage()
		 * .verifyAndEnterGAPDetails(getaPrice, userProfile)
		 * .switchTariff(getaPrice) .forcedRegisrationOnly(acquisition,
		 * userProfile) .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .enterPaymentOptions(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .getLeadID() .verifyLeadData()
		 * .domarssalesRunBatch(acquisition.getShopBatch()) .backToHomePage();
		 * 
		 * //Pure Conversion_CA_12
		 * 
		 * acquisition.setFuelType("dual");
		 * acquisition.setPaymentType("MonthDD"); new HomePageAction()
		 * .navigateToGasAndElectricityPage() .navigateToGetAPricePage()
		 * .verifyAndEnterGAPDetails(getaPrice, userProfile)
		 * .switchTariff(getaPrice) .forcedLoginOnly(acquisition, userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .enterPaymentOptions(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .getLeadID() .verifyLeadData()
		 * .domarssalesRunBatch(acquisition.getShopBatch()) .backToHomePage();
		 * 
		 * //Pure Conversion_CA_14
		 * 
		 * acquisition.setFuelType("dual");
		 * acquisition.setPaymentType("MonthDD"); new HomePageAction()
		 * .navigateToGasAndElectricityPage() .navigateToGetAPricePage()
		 * .verifyAndEnterGAPDetails(getaPrice, userProfile)
		 * .switchTariff(getaPrice) .forcedRegisrationOnly(acquisition,
		 * userProfile) .enterPersonalDetailsPage(acquisition, userProfile)
		 * .enterCurrentServices(acquisition) .enterPaymentOptions(acquisition)
		 * .reviewOrderPageNavigation() .verifyThankYouPage(userProfile)
		 * .getLeadID() .verifyLeadData()
		 * .domarssalesRunBatch(acquisition.getShopBatch()) .backToHomePage();
		 */
	}

	
	/*
	 * -----------------------------------------------------------------Pure Conversion ValueAdded
	 */
	//For Conversion If two or more TC methods are present in a method, Please run one by one by Commenting the other
	

	@Test(groups = { Acquisition, Conversion, Zeus, Qtp })
	public void ConversionGasOnline_New() {

		Report.createTestLogHeader("Conversion Test",
				"ConversionGasClearAndSimple");
		Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");
		acquisition.setTariffforgas(acquisition.gettariffFixFall());
		// getCustomerDetailsToUserProfileOAM(userProfile);

		// Pure Conversion_CA_02
		acquisition.setFuelType("Gas");
		acquisition.setPaymentType("MonthDD");
		// new OnlineDBConnector().deRegister(userProfile.getUCRN());
		acquisition.setTariffforgas(acquisition.gettariffFixFall());
		Report.updateTestLog("***********Pure Conversion_CA_02***********",
				"DONE");
		String accountNumber=userProfile.getAccNumber();
		new HomePageAction()
				.navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage()
				.navigateToClearAndSimple()
				.navigateToEnergySmartGasOrderPage()
				.forcedLoginYourOrderPage(acquisition, userProfile)
				// .enterPersonalDetailsPage(acquisition, userProfile)
				.gasBGEnergySmartGasConversion(acquisition)
				.enterPaymentOptions(acquisition).payInNextMonth()
				.payNowOnline(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.verifyAuditEventID(userProfile)
				.logoutFromConvThankYouPage();
				//.changeTariff(userProfile.getGasAccount());

		/*Report.createTestLogHeader("Esmart Conversion",
				"Gas Account Energy smart to Energy smart");*/
		Report.updateTestLog("***********PureConversionEStoESGas***********",
				"DONE");
		acquisition.setTariffforgas(acquisition.gettariffFixFall());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToFixedPriceMay2014()
				.navigateToEnergySmartGasOrderPage().yourOrderGasBG(
						acquisition, userProfile).energySmartGasBGOrderGas(
						acquisition).verifyThankYouPage(userProfile)
						.deRegisterEsmart(accountNumber)
						.logoutFromThankYouPage();
		
		
		// Pure Conversion_CA_15
		Report.updateTestLog("***********Pure Conversion_CA_15***********",
				"DONE");
		acquisition.setFuelType("Gas");
		acquisition.setPaymentType("MonthDD");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		acquisition.setTariffforgas(acquisition.gettariffFixFall());
		new HomePageAction()
				.navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage()
				.navigateToOnlineVariableAugust2013()
				.navigateToEnergySmartGasOrderPage()
				.forcedRegistrationYourOrderPage(acquisition, userProfile)
				.gasBGEnergySmartGasConversion(acquisition)
				// .enterPersonalDetailsPage(acquisition, userProfile)
				.enterPaymentOptions(acquisition).payInNextMonth()
				.payNowOnline(acquisition).reviewOrderPageNavigation()
				.verifyThankYouPage(userProfile).verifyEshopLeadData()
				.verifyAuditEventID(userProfile)
				.deRegisterEsmart(accountNumber)
				.logoutFromConvThankYouPage();
				//.changeTariff(userProfile.getGasAccount());
		
		
		/***********************************************************************
		 * 
		 * 
		 * Remaining TC's of ESMART
		 * 
		 * 
		 **********************************************************************/

		/*
		 * //Pure Conversion_CA_01 acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthDD"); new HomePageAction()
		 * .navigateToLogin() .login(userProfile)
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToClearAndSimple() .navigateToEnergySmartGasOrderPage()
		 * .yourOrderGasBG(acquisition,userProfile)
		 * //.enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasBGEnergySmartGasConversion(acquisition)
		 * .enterPaymentOptions(acquisition) .payInNextMonth()
		 * .payNowOnline(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .verifyAuditEventID(userProfile) .logoutFromConvThankYouPage()
		 * .changeTariff(userProfile.getGasAccount());
		 * 
		 * 
		 * 
		 * //Pure Conversion_CA_13 acquisition.setFuelType("Gas");
		 * acquisition.setPaymentType("MonthDD"); new HomePageAction()
		 * .navigateToLogin() .login(userProfile)
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToOnlineVariableAugust2013() .navigateToGasOrderPage()
		 * .yourOrderGasBG(acquisition,userProfile) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .verifyAuditEventID(userProfile) .logoutFromConvThankYouPage()
		 * .changeTariff(userProfile.getGasAccount());
		 */
	}

	@Test(groups = { Acquisition, Conversion, Zeus, Qtp })
	public void ConversionJIOnline_New() {

		Report.createTestLogHeader("Conversion Test",
				"Conversion JI Account Online");
		GetAPrice getaPrice = new TestDataHelper()
				.getGetAPriceData("anonymous");
		Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JIAccount");
		// getCustomerDetailsToUserProfileOAM(userProfile);
		String accountNumber=userProfile.getAccNumber();
		// Pure Conversion_CA_10
		
		  Report.updateTestLog("*********Pure Conversion_CA_10************",
		  "DONE");
		  acquisition.setTariffforgas(acquisition.gettariffClearSimple());
		  acquisition.setPaymentType("MonthDD"); new HomePageAction()
		  .navigateToLogin() .login(userProfile)
		  .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		  .navigateToOnlineVariableAugust2013()
		  .navigateToEnergySmartDualOrderPage() .yourOrderDualBG(acquisition,
		  userProfile) .gasBGEnergySmartDualOrder(acquisition)
		  .variableDirectDebitPayment(acquisition) .reviewOrderPageNavigation()
		  .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		  .verifyAuditEventID(userProfile) .deRegisterEsmart(accountNumber).logoutFromConvThankYouPage()
		  .changeTariff(userProfile.getAccNumber());
		 

		// Pure Conversion_CA_11
		Report.updateTestLog("*********Pure Conversion_CA_11************",
				"DONE");
		acquisition.setPaymentType("MonthDD");
		acquisition.setTarifffordual(acquisition.gettariffFixFall());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToClearAndSimple()
				.navigateToEnergySmartDualOrderPage().forcedLoginYourOrderPage(
						acquisition, userProfile).jiEnergysmartOrderJi(
						acquisition).enterPaymentOptions(acquisition)
				.payInNextMonth().payNowOnline(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().verifyAuditEventID(userProfile)
				.logoutFromConvThankYouPage().changeTariff(
						userProfile.getAccNumber());

		 Report.updateTestLog("***********Pure Conversion_ES_11***********",
		 "DONE");
		  acquisition.setTarifffordual(acquisition.gettariffOnlineVariable());
		  new HomePageAction() .navigateToGasAndElectricityPage()
		  .navigateToOurTariffsPage() .navigateToFixedPriceMay2014()
		 .navigateToEnergySmartDualOrderPage()
		 .forcedLoginYourOrderPage(acquisition, userProfile)
		.jiEnergysmartOrderJi(acquisition) .verifyThankYouPage(userProfile)
		 //.getEshopLeadID() 
		.logoutFromThankYouPage();
		 

		// TC_17
		Report.updateTestLog("***********Pure Conversion_ES_17***********",
				"DONE");
		acquisition.setTarifffordual(acquisition.gettariffOnlineVariable());
		new ThankYouPage().deleteWTP(userProfile);
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToFixedPriceMay2014()
				.navigateToEnergySmartDualOrderPage()
				.forcedRegistrationYourOrderPage(acquisition, userProfile)
				.enterPersonalDetailsPage(acquisition, userProfile)
				.jiEnergysmartOrderJi(acquisition).verifyThankYouPage(
						userProfile)
				// .getEshopLeadID()
				.deRegisterEsmart(accountNumber)
				.logoutFromThankYouPage();

		/***********************************************************************
		 * 
		 * 
		 * Remaining TC's of ESMART
		 * 
		 * 
		 **********************************************************************/
		// Pure Conversion_CA_17
		/*
		 * acquisition.setFuelType("JI"); acquisition.setPaymentType("MonthDD");
		 * new HomePageAction() .navigateToGasAndElectricityPage()
		 * .navigateToGetAPricePage() .verifyAndEnterGAPDetails(getaPrice,
		 * userProfile) .switchTariff(getaPrice)
		 * .forcedRegisrationOnly(acquisition, userProfile)
		 * .enterPersonalDetailsPage(acquisition, userProfile)
		 * .gasBGEnergySmartDualOrder(acquisition) .reviewOrderPageNavigation()
		 * .verifyThankYouPage(userProfile) .verifyEshopLeadData()
		 * .verifyAuditEventID(userProfile) .logoutFromConvThankYouPage()
		 * .changeTariff(userProfile.getAccNumber());
		 */
	}
	
	@Test(groups = { Acquisition, Conversion, Zeus, Qtp })
	public void pureConversionDual_New() {
		
		Report.createTestLogHeader("Get A Price", "Energy smart dual Journey");
		GetAPrice getaPrice = new TestDataHelper().getGetAPriceData("Dual");
		Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");

		Report.updateTestLog("*********Esmart Conversion Dual Account Forced Login************",
				  "DONE");
		String accountNumber_Ele=userProfile.getElecAccount();
		String accountNumber_Gas=userProfile.getGasAccount();
		acquisition.setTariffforgas(acquisition.gettariffFixFall());
		acquisition.setPaymentType(acquisition.getMonthlyDebCredCard());
		acquisition.setCardType(acquisition.getVisaDebit());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToClearAndSimple()
				.navigateToEnergySmartDualOrderPage().forcedLoginYourOrderPage(
						acquisition, userProfile).gasBGEnergySmartDualOrder(
						acquisition).enterPaymentOptions(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromConvThankYouPage();
		
		Report.updateTestLog("*********Esmart Conversion Dual Account Energy smart to Energy smart************",
				  "DONE");
		// TC 08,18
		acquisition.setTarifffordual(acquisition.gettariffClearSimple());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToClearAndSimple()
				.navigateToEnergySmartDualOrderPage().forcedLoginYourOrderPage(
						acquisition, userProfile).jiEnergysmartOrderJi(
						acquisition).verifyThankYouPage(userProfile)
						.deRegisterEsmart(accountNumber_Ele)
						.deRegisterEsmart(accountNumber_Gas)
				.logoutFromThankYouPage();
		
		Report.updateTestLog("*********Esmart Conversion Dual Account Journey************",
				  "DONE");
		// Pure Conversion_ES_13

				/*
				 * acquisition.setGasSupplier("EDF Energy");
				 * acquisition.setElecSupplier("British Gas");
				 * acquisition.setFuelType("Gas");
				 * acquisition.setPaymentType("MonthlyVariableDirectDebit");
				 * acquisition.setCurrentGasSupplier("Credit Meter");
				 */
				acquisition.setTarifffordual(acquisition.gettariffClearSimple());

				new HomePageAction().navigateToLogin().login(userProfile)
						.navigateToGasAndElectricityPage().navigateToGetAPricePage()
						.verifyAndEnterGAPDetails(getaPrice, userProfile).switchTariff(
								"ClearAndSimple").yourOrderDualBG(acquisition,
								userProfile).jiEnergysmartOrderJi(acquisition)
						.variableDirectDebitPayment(acquisition)
						.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
						.getEshopLeadID().verifyEshopLeadData().deleteWTP(userProfile).deRegisterEsmart(accountNumber_Ele)
						.deRegisterEsmart(accountNumber_Gas)
						.backToHomePage();
		
				// TC_03
				Report.updateTestLog("*********Esmart Conversion Dual Account Change Tariff for Gas Account************",
						  "DONE");
				Report.createTestLogHeader("Conversion Test",
						"");
				new OnlineDBConnector().deRegister(userProfile.getUCRN());
				new ThankYouPage().deleteWTP(userProfile);
				acquisition.setTarifffordual(acquisition.gettariffFixFall());
				acquisition.setPaymentType(acquisition.getMonthlyDebCredCard());
				acquisition.setCardType(acquisition.getVisaDebit());
				new HomePageAction().navigateToGasAndElectricityPage()
						.navigateToOurTariffsPage().navigateToClearAndSimple()
						.navigateToEnergySmartDualOrderPage()
						.forcedRegistrationYourOrderPage(acquisition, userProfile)
						.gasBGEnergySmartDualOrder(acquisition).enterPaymentOptions(
								acquisition).reviewOrderPageNavigation()
						.verifyThankYouPage(userProfile).verifyEshopLeadData()
						.logoutFromConvThankYouPage();

		/***********************************************************************
		 * 
		 * 
		 * Remaining TC's of ESMART
		 * 
		 * 
		 **********************************************************************/
		/*
		 * acquisition.setTarifffordual(acquisition.gettariffOnlineVariable());
		 * new HomePageAction() .navigateToLogin() .login(userProfile)
		 * .navigateToProductAndServicesPage()
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToFixedPriceMay2014() .navigateToEnergySmartDualOrderPage()
		 * .yourOrderDualBG(acquisition, userProfile)
		 * .dualEnergysmartOrderDual(acquisition)
		 * .verifyThankYouPage(userProfile) .logoutFromThankYouPage();
		 * 
		 * acquisition.setTarifffordual(acquisition.gettariffFixFall()); new
		 * HomePageAction() .navigateToLogin() .login(userProfile)
		 * .navigateToProductAndServicesPage()
		 * .navigateToGasAndElectricityPage() .navigateToOurTariffsPage()
		 * .navigateToOnlineVariableAugust2013()
		 * .navigateToEnergySmartDualOrderPage() .yourOrderDualBG(acquisition,
		 * userProfile) .dualEnergysmartOrderDual(acquisition)
		 * .verifyThankYouPage(userProfile) .logoutFromThankYouPage();
		 */
	}


	// Mandatory Field: The account must have a debt balance.
	@Test(groups = { Acquisition, Conversion })
	public void convPayNowGasClearSimple_New() {

		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Gas Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("GasAccount");

		acquisition.setTariffforgas(acquisition.gettariffClearSimple());
		acquisition.setPaymentType(acquisition.getMonthlyVDD());
		acquisition.setCardType(acquisition.getVisaDebit());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple().navigateToEnergySmartGasOrderPage()
				.yourOrderGasBG(acquisition, userProfile)
				.gasBGEnergySmartGasConversion(acquisition)
				.enterPaymentOptions(acquisition).payNowOnline(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromConvThankYouPage();
	}
	// Mandatory Field: The account must have a debt balance.
	@Test(groups = { Acquisition, Conversion })
	public void convPayLaterDualFixFall_New() {
		Report.createTestLogHeader("Conversion Test",
				"Dual account Fix and Fall");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("DualAccount");

		acquisition.setTariffforgas(acquisition.gettariffFixFall());
		acquisition.setPaymentType(acquisition.getMonthlyVDD());
		acquisition.setCardType(acquisition.getVisaDebit());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToFixedPriceMay2014()
				.navigateToEnergySmartDualOrderPage().yourOrderDualBG(
						acquisition, userProfile).gasBGEnergySmartDualOrder(
						acquisition).enterPaymentOptions(acquisition)
				.payInNextMonth().payNowOnline(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromConvThankYouPage();

	}
	// Mandatory Field: The account must have a debt balance.
	@Test(groups = { Acquisition, Conversion })
	public void convPayNowJIClearSimple_New() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for ji Account");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("JIAccount");

		acquisition.setTariffforgas(acquisition.gettariffClearSimple());
		acquisition.setPaymentType(acquisition.getMonthlyVDD());
		acquisition.setCardType(acquisition.getVisaDebit());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple()
				.navigateToEnergySmartDualOrderPage().yourOrderDualBG(
						acquisition, userProfile).gasBGEnergySmartDualOrder(
						acquisition).enterPaymentOptions(acquisition)
				.payInNextMonth()
				 .payNowOnline(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromConvThankYouPage();
	}
	// Dual Eligible
	// TC_05
	
	

		
	@Test(groups = { Acquisition, BG })
	public void convElecCAAddGas_New() {
		Report.createTestLogHeader("Conversion Test",
				"Change Tariff for Elec Account and Add Gas Force Regist");
		final Acquisition acquisition = new TestDataHelper()
				.getAcquisitionData("standardDualAcquisition");
		final UserProfile userProfile = new TestDataHelper()
				.getUserProfile("ElectricityAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String accountNumber=userProfile.getAccNumber();
		acquisition.setTarifffordual(acquisition.gettariffOnlineVariable());
		acquisition.setPaymentType(acquisition.getMonthlyFixedDD());
		acquisition.setCardType(acquisition.getVisaDebit());
		new HomePageAction().navigateToGasAndElectricityPage()
				.navigateToOurTariffsPage().navigateToFixedPriceMay2014()
				.navigateToEnergySmartGasOrderPage()
				.forcedRegistrationYourOrderPage(acquisition, userProfile)
				.elecBGEnergySmartDualOrder(acquisition).enterCurrentServices(
						acquisition).enterPaymentOptions(acquisition)
				.payInNextMonth().payNowOnline(acquisition)
				.reviewOrderPageNavigation().verifyThankYouPage(userProfile)
				.verifyEshopLeadData().logoutFromConvThankYouPage();
		
		 Report.updateTestLog("*********Part Acquisition Conversion Elec Account Energy smart to Energy smart Add Gas*********",
				  "DONE");

		acquisition.setTariffforelectricity(acquisition.gettariffClearSimple());
		new HomePageAction().navigateToLogin().login(userProfile)
				.navigateToProductAndServicesPage()
				.navigateToGasAndElectricityPage().navigateToOurTariffsPage()
				.navigateToClearAndSimple()
				.navigateToEnergySmartDualOrderPage().yourOrderElecBG(
						acquisition, userProfile).energySmartElecBGOrderElec(
						acquisition,userProfile).verifyThankYouPage(userProfile)
				.verifyEshopLeadData().deRegisterEsmart(accountNumber).logoutFromThankYouPage();
		
		 Report.updateTestLog("*********Part Acquisition Conversion Change Tariff for Elec Account and Add Gas Force login*********",
				  "DONE");
		 

			acquisition.setTarifffordual(acquisition.gettariffFixFall());
			acquisition.setPaymentType(acquisition.getMonthlyFixedDD());
			acquisition.setCardType(acquisition.getVisaDebit());
			new HomePageAction().navigateToGasAndElectricityPage()
					.navigateToOurTariffsPage().navigateToFixedPriceMay2014()
					.navigateToEnergySmartDualOrderPage().forcedLoginYourOrderPage(
							acquisition, userProfile).elecBGEnergySmartDualOrder(
							acquisition).enterCurrentServices(acquisition)
					.enterPaymentOptions(acquisition).payInNextMonth()
					.payNowOnline(acquisition).reviewOrderPageNavigation()
					.verifyThankYouPage(userProfile).verifyEshopLeadData()
					.logoutFromConvThankYouPage();

	}
}