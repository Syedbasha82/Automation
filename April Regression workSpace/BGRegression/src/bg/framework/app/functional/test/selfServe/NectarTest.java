package bg.framework.app.functional.test.selfServe;

import org.testng.annotations.Test;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.FunctionalCategory;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import bg.framework.app.functional.action.sales.AcquisitionAction;
import bg.framework.app.functional.action.selfServe.NectarAction;
import bg.framework.app.functional.util.OnlineDBConnector;
import static bg.framework.app.functional.entities.FunctionalCategory.*;


public class NectarTest extends TestBase {
	
	//Non-OAM Nectar Registration
	@Test(groups = {Nectar})
	public void anonymousNectarRegistration()
	{
		
		String CRN; 
		Report.createTestLogHeader("Nectar Test", "Anonymous Nectar Registration");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		CRN = userProfile.getAccNumber();
		new NectarAction()
			.navigateToProductAndServices()
			.navigateToNectarPointsPage()
			.navigateToRegisterPage()
			.fillRegisterDetails(CRN)
			.verifyLeadWithDB();

	}
	
	
	//OAM Nectar Registration
	@Test(groups=(Nectar))
	public void oamNectarRegistrationEectricity(){
		Report.createTestLogHeader("Nectar Test", "OAM Nectar Registration Electricity");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile);
		new NectarAction()
			.navigateToRegistrationPage()
			.getNectarCard()
			.verifyNectarRegister()
			.navigateToYourPointsPage()
			.verifyYourPointsPage()
			.logout();
	}
	
	@Test(groups=(Nectar))
	public void oamNectarRegistrationGas(){
		Report.createTestLogHeader("Nectar Test", "OAM Nectar Registration Electricity");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile);
		new NectarAction()
			.navigateToRegistrationPage()
			.getNectarCard()
			.verifyNectarRegister()
			.navigateToYourPointsPage()
			.verifyYourPointsPage()
			.logout();
	}
	@Test(groups=(Nectar))
	public void oamNectarRegistrationDual(){
		Report.createTestLogHeader("Nectar Test", "OAM Nectar Registration Dual");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile);
		new NectarAction()
			.navigateToRegistrationPage()
			.getNectarCard()
			.verifyNectarRegister()
			.navigateToYourPointsPage()
			.verifyYourPointsPage()
			.logout();
	}
	@Test(groups=(Nectar))
	public void oamNectarRegistrationJI(){
		Report.createTestLogHeader("Nectar Test", "OAM Nectar Registration JI");
		UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile);
		new NectarAction()
			.navigateToRegistrationPage()
			.getNectarCard()
			.verifyNectarRegister()
			.navigateToYourPointsPage()
			.verifyYourPointsPage()
			.logout();
	}
	
	
	//Update Your Nectar Card Journey
	@Test(groups = {Nectar})
	public void NectarOAM()
	{
		Report.createTestLogHeader("Nectar Test", "Nectar OAM Elect");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile);
		new NectarAction()
			.navigateToYourPointsPage()
			.navigateToUpdateNectarCard()
			.updateNectarCardNumber()
		    .navigateToYourPointsPage()
		    .verifyYourPointsPage()
		    .logout();
	}
	

	//BGS Update Your Nectar Card Journey 
	@Test(groups = {Nectar})
	public void bgsNectarOAM()
	{
		Report.createTestLogHeader("Nectar Test", "Nectar OAM for BGS");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile);
		new NectarAction()
			.navigateToYourPointsPage()
			.navigateToUpdateNectarCard()
			.updateNectarCardNumber()
		    .navigateToYourPointsPage()
		    .verifyYourPointsPage()
		    .logout();
	}
	
	/*//Loyalty Registration through Email Link
	@Test(groups = {Nectar})
	public void loyaltyRegistration(){
		Report.createTestLogHeader("Loyalty Registration", "Pre-Registration non-OAM");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		new NectarAction()
			.navigateToPreOamRegistration(userProfile.getEmail())
			.enterAccountInformation(userProfile.getLastName(),userProfile.getaddr());
	}*/
	

	//View Your Nectar Points
	@Test(groups = {Nectar})
	public void viewNectarPointsGas(){

		Report.createTestLogHeader("Nectar Test", "View Nectar Points Gas");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile);
		new NectarAction()
			.navigateToYourPointsPage()
			.verifyYourPointsPage()
			.logout();
	}
	@Test(groups = {Nectar})
	public void viewNectarPointsElec(){

		Report.createTestLogHeader("Nectar Test", "View Nectar Points Elec");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile);
		new NectarAction()
			.navigateToYourPointsPage()
			.verifyYourPointsPage()
			.logout();
	}
	@Test(groups = {Nectar})
	public void viewNectarPointsDual(){

		Report.createTestLogHeader("Nectar Test", "View Nectar Points Dual");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile);
		new NectarAction()
			.navigateToYourPointsPage()
			.verifyYourPointsPage()
			.logout();
	}
	@Test(groups = {Nectar})
	public void viewNectarPointsJI(){

		Report.createTestLogHeader("Nectar Test", "View Nectar Points JI");
		UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile);
		new NectarAction()
			.navigateToYourPointsPage()
			.verifyYourPointsPage()
			.logout();
	}
	
	//View Nectar Dashboard
	
	@Test(groups = {Nectar})
	public void viewNectarDashBoardElec(){

		Report.createTestLogHeader("Nectar Test", "View Nectar DashBoard Elec");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile);
		new NectarAction()
			.navigateToYourPointsPage()
			.verifyYourPointsPage()
			.navigateToPointsHistoryPage()
			.logout();
	}
	@Test(groups = {Nectar})
	public void viewNectarDashBoardGas(){

		Report.createTestLogHeader("Nectar Test", "View Nectar DashBoard Gas");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile);
		new NectarAction()
			.navigateToYourPointsPage()
			.verifyYourPointsPage()
			.navigateToPointsHistoryPage()
			.logout();
	}
	@Test(groups = {Nectar})
	public void viewNectarDashBoardDual(){

		Report.createTestLogHeader("Nectar Test", "View Nectar DashBoard Dual");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile);
		new NectarAction()
			.navigateToYourPointsPage()
			.verifyYourPointsPage()
			.navigateToPointsHistoryPage()
			.logout();
	}
	@Test(groups = {Nectar})
	public void viewNectarDashBoardJI(){

		Report.createTestLogHeader("Nectar Test", "View Nectar DashBoard JI");
		UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile);
		new NectarAction()
			.navigateToYourPointsPage()
			.verifyYourPointsPage()
			.navigateToPointsHistoryPage()
			.logout();
	}
	
	//Add Nectar Card Number
	@Test(groups = {Nectar})
	public void addNectarCard(){

		Report.createTestLogHeader("Nectar Test", "Add Nectar card");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile);
		new NectarAction()
			.navigateToYourPointsPage()
			.verifyNectarPointsPage()
			.addNectarCard()
			.verifyYourPointsPage()
			.logout();
	}
	
	
	//OAM Meter Read Nectar Option - Account needed (Electricity dual rate with quartely billing)
	//@Test(groups = {Nectar})
	public void verifyOAMMeterReadNectarAddLater(){

		Report.createTestLogHeader("Nectar Test", "OAM Meter read, Add Nectar Later");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile)
			.navigateToSMRPage()
			.setPlausbileReading(userProfile.getElecAccount())
			.confirmAccountSelection().submitMeterReads();
			
	}
	
	
	//Multiple business partner
	//Pre condition : ucrn 1 have two account gas and electricity
	//ucrn 2 should have same gas or elec account as that of ucrn 1
	@Test(groups = {Nectar})
	public void verifyMultipleBusinessPartner(){

		Report.createTestLogHeader("Nectar Test", "Multiple Business Partner");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		UserProfile userProfile2 = new TestDataHelper().getUserProfile("GasAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile);
		new NectarAction()
			.navigateToRegistrationPage()
			.getNectarCard()
			.verifyNectarRegister()
			.logout();
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile2);
		new NectarAction()
			.navigateToYourPointsPage()
			.logout();
		
	}
	
	
	//Foreign Address
	//Precondition : Addresses should be registered as foreign address
		@Test(groups = {Nectar})
		public void verifyForeignAddressRegistration(){
			Report.createTestLogHeader("Nectar Test", "Foreign Address");
			UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
			new HomePageAction()
			.navigateToLogin()
			.login(userProfile);
		new NectarAction()
			.navigateToRegistrationPage()
			.getNectarCard()
			.verifyNonRegister()
			.logout();
		
		}
		
		 @Test(groups = {FunctionalCategory.Acquisition})     
	 	 public void nectarRegistrationEsmart(){
	  	
	  	 Report.createTestLogHeader("Clear And Simple Acquisition", "Nectar Registration for ESmart");	      	
	  	  final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
	      final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");	      
	      
		//	    Pure Acquisition_ES_01
			    /*  new OnlineDBConnector().deRegister(userProfile.getUCRN());
			      userProfile.setNectarValue("1");
			      acquisition.setGasSupplier("EDF Energy");
			      acquisition.setFuelType("Gas");
			      acquisition.setPaymentType("MonthlyVariableDirectDebit");
			      acquisition.setCurrentGasSupplier("Credit Meter");*/
			      new HomePageAction()
			      .navigateToGasAndElectricityPage()
			      .navigateToOurTariffsPage()
			      .navigateToClearAndSimple()
			      .navigateToEnergySmartGasOrderPage()
			      .yourOrderAnonymousNavigationNew(acquisition,userProfile)
			      .enterPersonalDetailsPage(acquisition, userProfile)
			      .enterCurrentServices(acquisition)
			      .enterPaymentOptions(acquisition)
			      .reviewOrderPageNavigation()
			      .verifyThankYouPage(userProfile);
		 }
		 
			@Test(groups = {FunctionalCategory.Acquisition})     
		    public  void nectarRegistrationEshop(){     	
		     	 Report.createTestLogHeader("Clear And Simple Acquisition", "Nectar Registration for EShop");     	
		     	 final Acquisition acquisition = new TestDataHelper().getAcquisitionData("standardDualAcquisition");
		         final UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
		     	
		         new AcquisitionAction().logoutFromThankYouPage()         
		          .navigateToGasAndElectricityPage()
		          .navigateToOurTariffsPage()
		          .navigateToClearAndSimple()        
		          .navigateToDualOrderPage()	          
		          .yourOrderAnonymousNavigationNew(acquisition,userProfile)
			      .enterPersonalDetailsPage(acquisition, userProfile)
			      .enterCurrentServices(acquisition)
			      .enterPaymentOptionsNew(acquisition)
			      .reviewOrderPageNavigation()
			      .verifyThankYouPage(userProfile);
			}
}
