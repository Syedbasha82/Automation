package bg.framework.app.functional.test.sales;

import static bg.framework.app.functional.entities.FunctionalCategory.InProgress;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import static bg.framework.app.functional.entities.FunctionalCategory.SubmitMeterRead;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.action.sales.TOUChangeAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.FunctionalCategory;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;

public class TOUChangeTest extends TestBase {
	
////////////////////////////////////////////////////////////////////////         ANONYMOUS FLOW         \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

//	##################################################################################### MVDD ############################################################################ //
	// Before running : Change email, first name and last name  in XML file for every test in all anonymous flows.
	
	 @Test(groups = { SubmitMeterRead,Regression,InProgress })
	public void NewCustAnonymousFlowMvddFirstTariff(){
		Report.createTestLogHeader("TOU","New Customer MVDD payment 1st tariff");
		UserProfile userProfile = new TestDataHelper().getUserProfile("TouAnnoymous");
		final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		String Flow ="Pros&Smart";
		String AddressDD="2";
		String PayType="MVDD";
		String MvddTariff="First";
		String Customer ="newCustomer";
		String PPMeter ="No";
		String Eco7 = "No";
		String Flat = "No";
		String FuseBox = "Yes";
		String Smart = "No";
		String Nectar = "AddCard";
		String Meter ="Half";
		new TOUChangeAction()
		.navigateToTOULandingPage(Flow)
		.selectCustomer(Customer)
		.newCustomerContinue()
		.newCustScreeningQues(PPMeter , Eco7, Flat, FuseBox, Smart)
		.screeningContinue()
		.newCusFlowDeciderForMvdd( acquisition, userProfile, AddressDD,PayType,MvddTariff,Nectar,Meter);
		new LoginAction().login(userProfile);
		new TOUChangeAction()
		.verifySalesOrderCreation();
		}
	 
	 @Test(groups = { SubmitMeterRead,Regression,InProgress })
		public void NewCustAnonymousFlowMvddSecondTariff(){
			Report.createTestLogHeader("TOU","New Customer MVDD payment 2nd tariff");
			UserProfile userProfile = new TestDataHelper().getUserProfile("TouAnnoymous");
			final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
			String Flow ="Pros&Smart";
			String AddressDD="2";
			String PayType="MVDD";
			String MvddTariff="Second";
			String Customer ="newCustomer";
			String PPMeter ="No";
			String Eco7 = "No";
			String Flat = "No";
			String FuseBox = "Yes";
			String Smart = "No";
			String Nectar = "SignUp";
			String Meter ="Daily";
			new TOUChangeAction()
			.navigateToTOULandingPage(Flow)
			.selectCustomer(Customer)
			.newCustomerContinue()
			.newCustScreeningQues(PPMeter , Eco7, Flat, FuseBox, Smart)
			.screeningContinue()
			.newCusFlowDeciderForMvdd( acquisition, userProfile, AddressDD,PayType,MvddTariff,Nectar,Meter);
			new LoginAction().login(userProfile);
			new TOUChangeAction()
			.verifySalesOrderCreation();
			}
	 
	 @Test(groups = { SubmitMeterRead,Regression,InProgress })
		public void NewCustAnonymousFlowMvddThirdTariff(){
			Report.createTestLogHeader("TOU","New Customer MVDD payment 3rd tariff");
			UserProfile userProfile = new TestDataHelper().getUserProfile("TouAnnoymous");
			final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
			String Flow ="Pros&Smart";
			String AddressDD="2";
			String PayType="MVDD";
			String MvddTariff="Third";
			String Customer ="newCustomer";
			String PPMeter ="No";
			String Eco7 = "No";
			String Flat = "No";
			String FuseBox = "Yes";
			String Smart = "No";
			String Nectar = "Later";
			String Meter ="Monthly";
			new TOUChangeAction()
			.navigateToTOULandingPage(Flow)
			.selectCustomer(Customer)
			.newCustomerContinue()
			.newCustScreeningQues(PPMeter , Eco7, Flat, FuseBox, Smart)
			.screeningContinue()
			.newCusFlowDeciderForMvdd( acquisition, userProfile, AddressDD,PayType,MvddTariff,Nectar,Meter);
			new LoginAction().login(userProfile);
			new TOUChangeAction()
			.verifySalesOrderCreation();
			}
	 
	 @Test(groups = { SubmitMeterRead,Regression,InProgress })
		public void NewCustAnonymousFlowMvddFourthTariff(){
			Report.createTestLogHeader("TOU","New Customer MVDD payment 4th tariff");
			UserProfile userProfile = new TestDataHelper().getUserProfile("TouAnnoymous");
			final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
			String Flow ="Pros&Smart";
			String AddressDD="2";
			String PayType="MVDD";
			String MvddTariff="Fourth";
			String Customer ="newCustomer";
			String PPMeter ="No";
			String Eco7 = "No";
			String Flat = "No";
			String FuseBox = "Yes";
			String Smart = "No";
			String Nectar = "No";
			String Meter ="Half";
			new TOUChangeAction()
			.navigateToTOULandingPage(Flow)
			.selectCustomer(Customer)
			.newCustomerContinue()
			.newCustScreeningQues(PPMeter , Eco7, Flat, FuseBox, Smart)
			.screeningContinue()
			.newCusFlowDeciderForMvdd( acquisition, userProfile, AddressDD,PayType,MvddTariff,Nectar,Meter);
			new LoginAction().login(userProfile);
			new TOUChangeAction()
			.verifySalesOrderCreation();
			}
	 
//		##################################################################################### CC ############################################################################ //
	 
	 @Test(groups = { SubmitMeterRead,Regression,InProgress })
		public void NewCustAnonymousFlowCcFirstTariff(){
			Report.createTestLogHeader("TOU","New Customer CC payment 1st tariff");
			UserProfile userProfile = new TestDataHelper().getUserProfile("TouAnnoymous");
			final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
			String Flow ="Pros&Smart";
			String AddressDD="2";
			String PayType="CC";
			String CCTariff="First";
			String Customer ="newCustomer";
			String PPMeter ="No";
			String Eco7 = "No";
			String Flat = "No";
			String FuseBox = "Yes";
			String Smart = "No";
			String Nectar = "AddCard";
			String Meter ="Half";
			new TOUChangeAction()
			.navigateToTOULandingPage(Flow)
			.selectCustomer(Customer)
			.newCustomerContinue()
			.newCustScreeningQues(PPMeter , Eco7, Flat, FuseBox, Smart)
			.screeningContinue()
			.newCusFlowDeciderForCC( acquisition, userProfile, AddressDD,PayType,CCTariff,Nectar,Meter);
			new LoginAction().login(userProfile);
			new TOUChangeAction()
			.verifySalesOrderCreation();
			}
	 
	 @Test(groups = { SubmitMeterRead,Regression,InProgress })
		public void NewCustAnonymousFlowCcSecondTariff(){
			Report.createTestLogHeader("TOU","New Customer CC payment 2nd tariff");
			UserProfile userProfile = new TestDataHelper().getUserProfile("TouAnnoymous");
			final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
			String Flow ="Pros&Smart";
			String AddressDD="2";
			String PayType="CC";
			String CCTariff="Second";
			String Customer ="newCustomer";
			String PPMeter ="No";
			String Eco7 = "No";
			String Flat = "No";
			String FuseBox = "Yes";
			String Smart = "No";
			String Nectar = "SignUp";
			String Meter ="Daily";
			new TOUChangeAction()
			.navigateToTOULandingPage(Flow)
			.selectCustomer(Customer)
			.newCustomerContinue()
			.newCustScreeningQues(PPMeter , Eco7, Flat, FuseBox, Smart)
			.screeningContinue()
			.newCusFlowDeciderForCC( acquisition, userProfile, AddressDD,PayType,CCTariff,Nectar,Meter);
			new LoginAction().login(userProfile);
			new TOUChangeAction()
			.verifySalesOrderCreation();
			}
	 
	 @Test(groups = { SubmitMeterRead,Regression,InProgress })
		public void NewCustAnonymousFlowCcThirdTariff(){
			Report.createTestLogHeader("TOU","New Customer CC payment 3rd tariff");
			UserProfile userProfile = new TestDataHelper().getUserProfile("TouAnnoymous");
			final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
			String Flow ="Pros&Smart";
			String AddressDD="2";
			String PayType="CC";
			String CCTariff="Third";
			String Customer ="newCustomer";
			String PPMeter ="No";
			String Eco7 = "No";
			String Flat = "No";
			String FuseBox = "Yes";
			String Smart = "No";
			String Nectar = "Later";
			String Meter ="Monthly";
			new TOUChangeAction()
			.navigateToTOULandingPage(Flow)
			.selectCustomer(Customer)
			.newCustomerContinue()
			.newCustScreeningQues(PPMeter , Eco7, Flat, FuseBox, Smart)
			.screeningContinue()
			.newCusFlowDeciderForCC( acquisition, userProfile, AddressDD,PayType,CCTariff,Nectar,Meter);
			new LoginAction().login(userProfile);
			new TOUChangeAction()
			.verifySalesOrderCreation();
			}
	 
//		##################################################################################### Pay As you Go ############################################################################ //	 
	 
	 @Test(groups = { SubmitMeterRead,Regression,InProgress })
	 	public void NewCustAnonymousFlowPayGoFirstTariff(){
			Report.createTestLogHeader("TOU","New Customer Pay as you go payment First tariff");
			UserProfile userProfile = new TestDataHelper().getUserProfile("TouAnnoymous");
			final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
			String Flow ="Pros&Smart";
			String AddressDD="2";
			String PayType="PayAsYouGo";
			String PayGoTariff="First";
			String Customer ="newCustomer";
			String PPMeter ="No";
			String Eco7 = "No";
			String Flat = "No";
			String FuseBox = "Yes";
			String Smart = "No";
			String Nectar = "Later";
			String Meter ="Half";
			new TOUChangeAction()
			.navigateToTOULandingPage(Flow)
			.selectCustomer(Customer)
			.newCustomerContinue()
			.newCustScreeningQues(PPMeter , Eco7, Flat, FuseBox, Smart)
			.screeningContinue()
			.newCusFlowDeciderForPayGo( acquisition, userProfile, AddressDD,PayType,PayGoTariff,Nectar,Meter);
			}
	 
	 @Test(groups = { SubmitMeterRead,Regression,InProgress })
		public void NewCustAnonymousFlowPayGoSecondTariff(){
			Report.createTestLogHeader("TOU","New Customer Pay as you go payment Second tariff");
			UserProfile userProfile = new TestDataHelper().getUserProfile("TouAnnoymous");
			final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
			String Flow ="Pros&Smart";
			String AddressDD="2";
			String PayType="PayAsYouGo";
			String PayGoTariff="Second";
			String Customer ="newCustomer";
			String PPMeter ="No";
			String Eco7 = "No";
			String Flat = "No";
			String FuseBox = "Yes";
			String Smart = "No";
			String Nectar = "No";
			String Meter ="Daily";
			new TOUChangeAction()
			.navigateToTOULandingPage(Flow)
			.selectCustomer(Customer)
			.newCustomerContinue()
			.newCustScreeningQues(PPMeter , Eco7, Flat, FuseBox, Smart)
			.screeningContinue()
			.newCusFlowDeciderForPayGo( acquisition, userProfile, AddressDD,PayType,PayGoTariff,Nectar,Meter);
			}

//		##################################################################################### Monthly meter for pay as you go ############################################################################ //
	 
	 @Test(groups = { SubmitMeterRead,Regression,InProgress })
		public void NewCustAnonymousFlowPayGoSecondTariffMonthlyMeter(){
			Report.createTestLogHeader("TOU","New Customer Pay as you go payment First tariff");
			UserProfile userProfile = new TestDataHelper().getUserProfile("TouAnnoymous");
			final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
			String Flow ="Pros&Smart";
			String AddressDD="2";
			String PayType="PayAsYouGo";
			String PayGoTariff="Second";
			String Customer ="newCustomer";
			String PPMeter ="No";
			String Eco7 = "No";
			String Flat = "No";
			String FuseBox = "Yes";
			String Smart = "No";
			String Nectar = "No";
			String Meter ="Monthly";
			new TOUChangeAction()
			.navigateToTOULandingPage(Flow)
			.selectCustomer(Customer)
			.newCustomerContinue()
			.newCustScreeningQues(PPMeter , Eco7, Flat, FuseBox, Smart)
			.screeningContinue()
			.newCusFlowDeciderForPayGo( acquisition, userProfile, AddressDD,PayType,PayGoTariff,Nectar,Meter);
			}
	 
	 
////////////////////////////////////////////////////////////////////////       SMART METER Better Deal      \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	 
	 @Test(groups = { SubmitMeterRead,Regression,InProgress })
	 public void SmartmeterBetterDealSaturday(){
			Report.createTestLogHeader("TOU","Smartmeter customer Better Deal Saturday flow");
			UserProfile userProfile = new TestDataHelper().getUserProfile("TouSmartMeterBetterDeal");
			String Flow ="StandardMeter";
			String Customer ="smartmeter";
			String Tariff = "Saturday";
			new TOUChangeAction()
			.navigateToTOULandingPage(Flow)
	        .selectCustomer(Customer)
			.smartmeterContinue();
			new LoginAction()
			.login(userProfile);
			new TOUChangeAction()
			.upgradeNowLink()
			.selectTariff(Tariff)
			.orderFreeOverlay();
	 }
	 
	 @Test(groups = { SubmitMeterRead,Regression,InProgress })
	 public void SmartmeterBetterDealSunday(){
			Report.createTestLogHeader("TOU","Smartmeter customer Better Deal Sunday flow");
			UserProfile userProfile = new TestDataHelper().getUserProfile("TouSmartMeterBetterDeal");
			String Flow ="StandardMeter";
			String Customer ="smartmeter";
			String Tariff = "Sunday";
			new TOUChangeAction()
			.navigateToTOULandingPage(Flow)
	        .selectCustomer(Customer)
	        .smartmeterContinue();
			new LoginAction()
			.login(userProfile);
			new TOUChangeAction()
			.upgradeNowLink()
			.selectTariff(Tariff)
			.orderFreeOverlay();
	 }
	 
	 
////////////////////////////////////////////////////////////////////////         SMART METER Normal GAQ      \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

	 @Test(groups = { SubmitMeterRead,Regression,InProgress })
	 public void SmartmeterNormalGAQSaturday(){
			Report.createTestLogHeader("TOU","Smartmeter customer Normal GAQ flow");
			UserProfile userProfile = new TestDataHelper().getUserProfile("TouSmartMeter");
			String Flow ="StandardMeter";
			String Customer ="smartmeter";
			String GAQTariff = "Saturday";
			new TOUChangeAction()
			.navigateToTOULandingPage(Flow)
	        .selectCustomer(Customer)
	        .smartmeterContinue();
			new LoginAction()
			.login(userProfile);
			new TOUChangeAction()
			.GAQPage()
			.tariff(GAQTariff)
			.GAQFlow();

	 }
	 
	 @Test(groups = { SubmitMeterRead,Regression,InProgress })
	 public void SmartmeterNormalGAQSunday(){
			Report.createTestLogHeader("TOU","Smartmeter customer Normal GAQ flow");
			UserProfile userProfile = new TestDataHelper().getUserProfile("TouSmartMeter");
			String Flow ="StandardMeter";
			String Customer ="smartmeter";
			String GAQTariff = "Sunday";
			new TOUChangeAction()
			.navigateToTOULandingPage(Flow)
	        .selectCustomer(Customer)
	        .smartmeterContinue();
			new LoginAction()
			.login(userProfile);
			new TOUChangeAction()
			.GAQPage()
			.tariff(GAQTariff)
			.GAQFlow();

	 }
	 
////////////////////////////////////////////////////////////////////////    SMART METER MI Data     \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	 
	 @Test(groups = { SubmitMeterRead,Regression,InProgress })
	 public void SmartmeterMISunday(){
			Report.createTestLogHeader("TOU","Smartmeter customer Normal MI flow");
			UserProfile userProfile = new TestDataHelper().getUserProfile("TouSmartMeterMI");
			String Flow ="StandardMeter";
			String Customer ="smartmeter";
			String MiTariff = "Sunday";
			new TOUChangeAction()
			.navigateToTOULandingPage(Flow)
	        .selectCustomer(Customer)
	        .smartmeterContinue();
			new LoginAction()
			.login(userProfile);
			new TOUChangeAction()
			.MIFlow()
			.MiTariff(MiTariff);
     }
	 
	 @Test(groups = { SubmitMeterRead,Regression,InProgress })
	 public void SmartmeterMISaturday(){
			Report.createTestLogHeader("TOU","Smartmeter customer Normal MI flow");
			UserProfile userProfile = new TestDataHelper().getUserProfile("TouSmartMeterMI");
			String Flow ="StandardMeter";
			String Customer ="smartmeter";
			String MiTariff = "Saturday";
			new TOUChangeAction()
			.navigateToTOULandingPage(Flow)
	        .selectCustomer(Customer)
	        .smartmeterContinue();
			new LoginAction()
			.login(userProfile);
			new TOUChangeAction()
			.MIFlow()
			.MiTariff(MiTariff);
     }
	 
////////////////////////////////////////////////////////////////////////    Standard Meter CST In Eligible     \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

/////////////////////////// For both eligible and ineligible make data reset by functional flow then execute /////////////////////////////
	 
	 @Test(groups = { SubmitMeterRead,Regression,InProgress })
	 public void StandardmeterCSTIneligible(){
		 Report.createTestLogHeader("TOU","Standardmeter customer CST ineligible");
			UserProfile userProfile = new TestDataHelper().getUserProfile("StandardCSTInEligible");
			String Flow ="StandardMeter";
			String Customer ="standardBGmeter";
			String CSTFlow = "Ineligible";
			new TOUChangeAction()
			.navigateToTOULandingPage(Flow)
	        .selectCustomer(Customer)
	        .standardmeterContinue();
			new LoginAction()
			.login(userProfile);
			new TOUChangeAction()
			.cstLink(CSTFlow)
			.ineligibleFlow();
	 }
	 
	 
	 @Test(groups = { SubmitMeterRead,Regression,InProgress })
	 public void StandardmeterCSTEligible(){
		 Report.createTestLogHeader("TOU","Standardmeter customer CST eligible");
			UserProfile userProfile = new TestDataHelper().getUserProfile("StandardCSTEligible");
			String Flow ="StandardMeter";
			String Customer ="standardBGmeter";
			String CSTFlow = "Eligible";
			new TOUChangeAction()
			.navigateToTOULandingPage(Flow)
	        .selectCustomer(Customer)
	        .standardmeterContinue();
			new LoginAction()
			.login(userProfile);
			new TOUChangeAction()
			.cstLink(CSTFlow)
			.eligibleFlow();
}
}
	 

