package bg.framework.app.functional.test.selfServe;



import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.selfServe.SMRAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.RunQTP;
import bg.framework.app.functional.util.TestDataHelper;

import org.testng.annotations.Test;

import static bg.framework.app.functional.entities.FunctionalCategory.*;

public class SubmitMeterReadTest extends TestBase {

	 @Test(groups = { SubmitMeterRead,Regression,InProgress })
	 	//Yet to make Sap Validations
	public void submitPlausibleElecMeter() {
		Report.createTestLogHeader("Submit Meter Read.", "Plausible Electricity Meter");

		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		try {
			registerCustomerDetailsInOnlineDB(userProfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//getCustomerDetailsToUserProfileOAM(userProfile);
		userProfile.setAccNumber(userProfile.getElecAccount());
		/*new SMRAction().resetMeterRead(userProfile.getElecAccount()) .resetMeterRead("85000000058");*/
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage04()
		        .navigateToSMRPage()
		        .setPlausbileReading(userProfile.getElecAccount())
		        .confirmAccountSelection().submitMeterReads()
		        .verifyMeterConfirmation(userProfile.getElecAccount(), userProfile)
		        .logout();

	}
	 
	 @Test(groups = { SubmitMeterRead,Regression })
		public void submitImPlausibleElecMeter() {
			Report.createTestLogHeader("Submit Meter Read.", "Implaussible Electricity Meter");

			UserProfile userProfile = new TestDataHelper()
			        .getUserProfile("ElectricityAccount");

			// getCustomerDetailsToUserProfileOAM(userProfile);
		//	userProfile.setAccNumber(userProfile.getElecAccount());
		//	new SMRAction().resetMeterRead(userProfile.getAccNumber());
			new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage04()
			        .navigateToSMRPage()
			        .setImPlausbileReading(userProfile.getAccNumber())
			        .confirmAccountSelection().submitMeterReads()
			        .verifyMeterConfirmation(userProfile.getAccNumber(), userProfile)
			        .logout();
			//new RunQTP().runQTP("sample.vbs", userProfile.getAccNumber());

		}
	 
	 @Test(groups = { SubmitMeterRead,Smoke })
		//Yet to make Sap Validations
		public void submitPlausibleGasMeter() {
			Report.createTestLogHeader("Submit Meter Read.", "Plausible Gas Meter");
			

			UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");

			userProfile.setAccNumber(userProfile.getGasAccount());
			
			//getCustomerDetailsToUserProfileOAM(userProfile);

			//new SMRAction().resetMeterRead(userProfile.getGasAccount());
			new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage04()
			        .navigateToSMRPage()
			        .setPlausbileReading(userProfile.getGasAccount())
			        .confirmAccountSelection()		        
			        .verifyMeterConfirmation(userProfile.getGasAccount(), userProfile)
			        .logout();
		}
		@Test(groups = { SubmitMeterRead,Smoke })
		public void submitImPlausibleGasMeter() {
			Report.createTestLogHeader("Submit Meter Read.", "ImPlausible Gas Meter");


			UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");

			userProfile.setAccNumber(userProfile.getGasAccount());

			//getCustomerDetailsToUserProfileOAM(userProfile);

			//new SMRAction().resetMeterRead(userProfile.getGasAccount());// .resetMeterRead("85000000058");
			new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage04()
			        .navigateToSMRPage()
			        .setImPlausbileReading(userProfile.getGasAccount())
			        .confirmAccountSelection()
			        .verifyMeterConfirmation(userProfile.getGasAccount(), userProfile)
			        .logout();
		}
	 
	 @Test(groups = { SubmitMeterRead,Regression,InProgress })
	 public void submitPlausibleElecDualMeter() {
			Report.createTestLogHeader("Submit Meter Read.", "Plausible Electricity Meter");

			UserProfile userProfile = new TestDataHelper()
			        .getUserProfile("ElectricityAccount");
			try {
				registerCustomerDetailsInOnlineDB(userProfile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//getCustomerDetailsToUserProfileOAM(userProfile);
			userProfile.setAccNumber(userProfile.getElecAccount());
			new SMRAction().resetMeterRead(userProfile.getElecAccount());// .resetMeterRead("85000000058");
			new HomePageAction().navigateToLogin().login(userProfile)
			        .navigateToAccountSummaryPage(userProfile).navigateToSMRPage()
			        .setPlausibleReadingElecDay(userProfile.getElecAccount())
			        .confirmAccountSelection().submitMeterReads()
			        .verifyMeterConfirmation(userProfile.getElecAccount(), userProfile);

		}
	 @Test(groups = { SubmitMeterRead,Regression,InProgress })
	 public void submitPlausibleJIMixedElecDualMeter() {
			Report.createTestLogHeader("Submit Meter Read.", "Plausible Electricity Meter");

			UserProfile userProfile = new TestDataHelper()
			        .getUserProfile("JIAccount");
			try {
				registerCustomerDetailsInOnlineDB(userProfile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//getCustomerDetailsToUserProfileOAM(userProfile);
			userProfile.setAccNumber(userProfile.getElecAccount());
			new SMRAction().resetMeterRead(userProfile.getElecAccount());// .resetMeterRead("85000000058");
			new HomePageAction().navigateToLogin().login(userProfile)
			        .navigateToAccountSummaryPage(userProfile).navigateToSMRPage()
			        .setPlausibleReadingMixedElecDay(userProfile.getElecAccount())
			        .confirmAccountSelection().submitMeterReads()
			        .verifyMeterConfirmation(userProfile.getElecAccount(), userProfile);

		}
	 
	 
	 @Test(groups = { SubmitMeterRead,Regression })
		public void submitImPlausibleLowElecDualMeter() {
			Report.createTestLogHeader("Submit Meter Read.", "Implaussible Electricity Dual Meter");

			UserProfile userProfile = new TestDataHelper()
			        .getUserProfile("ElectricityAccount");

			// getCustomerDetailsToUserProfileOAM(userProfile);
		//	userProfile.setAccNumber(userProfile.getElecAccount());
		//	new SMRAction().resetMeterRead(userProfile.getAccNumber());
			new HomePageAction().navigateToLogin().login(userProfile)
			        .navigateToAccountSummaryPage(userProfile).navigateToSMRPage()
			        .setImPlausbileReadingLowElecDay(userProfile.getAccNumber())
			        .confirmAccountSelection().submitImplaussibleMeterRead()
			        .verifyMeterConfirmation(userProfile.getAccNumber(), userProfile);
			new RunQTP().runQTP("sample.vbs", userProfile.getAccNumber());

		}

	
	
	
	@Test(groups = { SubmitMeterRead,Regression,InProgress })
 	//Yet to make Sap Validations
	public void submitPlausibleElecMeterDeepLink() {
	Report.createTestLogHeader("Submit Meter Read.", "Plausible Electricity Meter");

	UserProfile userProfile = new TestDataHelper()
	        .getUserProfile("ElectricityAccount");
	try {
		registerCustomerDetailsInOnlineDB(userProfile);
	} catch (Exception e) {
		e.printStackTrace();
	}
	getCustomerDetailsToUserProfileOAM(userProfile);
	userProfile.setAccNumber(userProfile.getElecAccount());
	new SMRAction().resetMeterRead(userProfile.getElecAccount());// .resetMeterRead("85000000058");
	new HomePageAction().navigateToSMRDeepLink().login(userProfile);
	        new SMRAction()
	        .setPlausbileReading(userProfile.getElecAccount())
	        .confirmAccountSelection().submitMeterReads()
	        .verifyMeterConfirmation(userProfile.getElecAccount(), userProfile);

}

	
	//Data Required Electricity account with Nectar sign up
	@Test(groups = { SubmitMeterRead,Regression,InProgress })
public void submitMeterReadNectarSignup() {
	Report.createTestLogHeader("Submit Meter Read.", "Submit Meter Read with Nectar Sign up");

	UserProfile userProfile = new TestDataHelper()
	        .getUserProfile("ElectricityAccount");
	try {
		registerCustomerDetailsInOnlineDB(userProfile);
	} catch (Exception e) {
		e.printStackTrace();
	}
	getCustomerDetailsToUserProfileOAM(userProfile);
	userProfile.setAccNumber(userProfile.getElecAccount());
	new SMRAction().resetMeterRead(userProfile.getElecAccount());// .resetMeterRead("85000000058");
	new HomePageAction().navigateToLogin().login(userProfile)
	        .navigateToAccountSummaryPage(userProfile).navigateToSMRPage()
	        .setPlausbileReadingNectar(userProfile.getElecAccount())
	        .nectarSignUp()
	        .submitMeterReadings()
	        .verifyNectarConfirmation();

	
	}
	
	//Submit meter read Finally billed customer
		@Test(groups = { SubmitMeterRead,Regression,InProgress })
	public void submitMeterReadFinallyBilled() {
		Report.createTestLogHeader("Submit Meter Read.", "Submit Meter Read For finally Billed customer");

		UserProfile userProfile = new TestDataHelper()
		        .getUserProfile("ElectricityAccount");
		try {
			registerCustomerDetailsInOnlineDB(userProfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//getCustomerDetailsToUserProfileOAM(userProfile);
		userProfile.setAccNumber(userProfile.getElecAccount());
		new SMRAction().resetMeterRead(userProfile.getElecAccount());// .resetMeterRead("85000000058");
		new HomePageAction().navigateToLogin().login(userProfile)
		        .navigateToAccountSummaryPage(userProfile).navigateToSMRPage()
		        .submitFinallyBilledReadings(userProfile.getElecAccount())
		        .submitMeterReadings()
		        .verifyFinallyBilledMsg();

		
		}
		
    //Sprint 04 changes
		
		@Test(groups = { SubmitMeterRead,Regression,InProgress })
		public void submitMeterReadClosedGas() {
			Report.createTestLogHeader("Submit Meter Read", "Submit Meter Read For Closed Gas Account customer");

			UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
			try {
				registerCustomerDetailsInOnlineDB(userProfile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//getCustomerDetailsToUserProfileOAM(userProfile);
			userProfile.setAccNumber(userProfile.getGasAccount());
			new SMRAction().resetMeterRead(userProfile.getGasAccount());
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile)
				.navigateToSMRPage()
				.verifyClosedAccountinSMR(userProfile)
				.logout();		
			}
		
		@Test(groups = { SubmitMeterRead,Regression,InProgress })
		public void submitMeterReadClosedElectricity() {
			Report.createTestLogHeader("Submit Meter Read", "Submit Meter Read For Closed Electricity Account customer");

			UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
			try {
				registerCustomerDetailsInOnlineDB(userProfile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//getCustomerDetailsToUserProfileOAM(userProfile);
			userProfile.setAccNumber(userProfile.getElecAccount());
			new SMRAction().resetMeterRead(userProfile.getElecAccount());
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile)
				.navigateToSMRPage()
				.verifyClosedAccountinSMR(userProfile)
				.logout();		
			}
		
		@Test(groups = { SubmitMeterRead,Regression,InProgress })
		public void submitMeterReadClosedJI() {
			Report.createTestLogHeader("Submit Meter Read", "Submit Meter Read For Closed JI Account customer");

			UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
			try {
				registerCustomerDetailsInOnlineDB(userProfile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//getCustomerDetailsToUserProfileOAM(userProfile);
			userProfile.setAccNumber(userProfile.getAccNumber());
			new SMRAction().resetMeterRead(userProfile.getAccNumber());
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile)
				.navigateToSMRPage()
				.verifyClosedAccountinSMR(userProfile)
				.logout();		
			}
		
		@Test(groups = { SubmitMeterRead,Regression,InProgress })
		public void submitMeterReadClosedDual() {
			Report.createTestLogHeader("Submit Meter Read.", "Submit Meter Read For Closed Dual Account customer");

			UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
			try {
				registerCustomerDetailsInOnlineDB(userProfile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//getCustomerDetailsToUserProfileOAM(userProfile);
			userProfile.setAccNumber(userProfile.getAccNumber());
			new SMRAction().resetMeterRead(userProfile.getAccNumber());
			new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.navigateToAccountSummaryPage(userProfile)
				.navigateToSMRPage()
				.verifyClosedAccountinSMR(userProfile)
				.logout();		
			}

		
		 @Test(groups = { SubmitMeterRead,Regression,InProgress })
		 	//Yet to make Sap Validations
		public void verifySMRCheckBoxElec2RateValid() {
			Report.createTestLogHeader("Submit Meter Read.", "submitMeterRead To Check Check Box Not Present Elec2rate");

			UserProfile userProfile = new TestDataHelper()
			        .getUserProfile("ElectricityAccount");
			try {
				registerCustomerDetailsInOnlineDB(userProfile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//getCustomerDetailsToUserProfileOAM(userProfile);
			userProfile.setAccNumber(userProfile.getElecAccount());
			new SMRAction().resetMeterRead(userProfile.getElecAccount());// .resetMeterRead("85000000058");
			new HomePageAction().navigateToLogin().login(userProfile)
			        .navigateToAccountSummaryPage(userProfile).navigateToSMRPage()
			        .setPlausbileReadingMeterReadForDayReading(userProfile.getElecAccount())
			        .setPlausbileReadingMeterReadForNightReading(userProfile.getElecAccount())
			        .confirmAccountSelection().submitMeterReads()
			        .verifyMeterConfirmation(userProfile.getElecAccount(), userProfile);

		}
		 @Test(groups = { SubmitMeterRead,Regression,InProgress })
		 public void verifySMRAnonymousGas(){
			 
			 Report.createTestLogHeader("Submit Meter Read.", "submitMeterRead To Check Check Box Not Present Anonymous "); 
			 UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousGasAccount");
		        
			 try {
					registerCustomerDetailsInOnlineDB(userProfile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				userProfile.setAccNumber(userProfile.getAccNumber());
				new SMRAction()
				.resetMeterRead(userProfile.getAccNumber())
				.navigateToSMRAnonymousPage()
				.findYourAccounts(userProfile)
				.setPlausibleReadingAnonymous(userProfile.getAccNumber())
				.verifyMeterConfirmationAnonymous(userProfile.getElecAccount(), userProfile);
				/*.resetMeterRead(userProfile.getAccNumber())
				.navigateToSMRAnonymousPage()
				.findYourAccountsByPostCode(userProfile)
				.setPlausibleReadingAnonymous(userProfile.getAccNumber())
				.verifyMeterConfirmationAnonymous(userProfile.getElecAccount(), userProfile);*/
				
				
		 }
		 @Test(groups = { SubmitMeterRead,Regression,InProgress })
		 public void verifySMRAnonymousElec(){
			 
			 Report.createTestLogHeader("Submit Meter Read.", "submitMeterRead To Check Check Box Not Present Anonymous "); 
			 UserProfile userProfile = new TestDataHelper()
		        .getUserProfile("AnonymousElecAccount");
			 try {
					registerCustomerDetailsInOnlineDB(userProfile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				userProfile.setAccNumber(userProfile.getAccNumber());
				new SMRAction()
				.resetMeterRead(userProfile.getAccNumber())
				.navigateToSMRAnonymousPage()
				.findYourAccounts(userProfile)
				.setPlausibleReadingAnonymous(userProfile.getAccNumber())
				.verifyMeterConfirmationAnonymous(userProfile.getElecAccount(), userProfile)
				.resetMeterRead(userProfile.getAccNumber())
				.navigateToSMRAnonymousPage()
				.findYourAccountsByPostCode(userProfile)
				.setPlausibleReadingAnonymous(userProfile.getAccNumber())
				.verifyMeterConfirmationAnonymous(userProfile.getElecAccount(), userProfile);
				
				 
				
		 }
		 @Test(groups = { SubmitMeterRead,Regression,InProgress })
		 public void verifySMRAnonymousDualSingle(){
			 
			 Report.createTestLogHeader("Submit Meter Read.", "submitMeterRead To Check Check Box Not Present Anonymous Dual Single"); 
			 UserProfile userProfile = new TestDataHelper()
		        .getUserProfile("AnonymousDualAccount");
			 try {
					registerCustomerDetailsInOnlineDB(userProfile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				userProfile.setAccNumber(userProfile.getAccNumber());
				new SMRAction()
				.resetMeterRead(userProfile.getAccNumber())
				.navigateToSMRAnonymousPage()
				.findYourAccounts(userProfile)
				.setPlausibleReadingsDual(userProfile.getAccNumber())
				.verifyMeterConfirmationAnonymous(userProfile.getElecAccount(), userProfile)
				.resetMeterRead(userProfile.getAccNumber())
				.navigateToSMRAnonymousPage()
				.findYourAccountsByPostCode(userProfile)
				.setPlausibleReadingsDual(userProfile.getAccNumber())
				.verifyMeterConfirmationAnonymous(userProfile.getElecAccount(), userProfile);
				
				
		 }
		 @Test(groups = { SubmitMeterRead,Regression,InProgress })
		 public void verifySMRAnonymousDualElecE7(){
			 
			 Report.createTestLogHeader("Submit Meter Read.", "submitMeterRead To Check Check Box Not Present Anonymous Dual Single"); 
			 UserProfile userProfile = new TestDataHelper()
		        .getUserProfile("AnonymousDualAccount");
			 try {
					registerCustomerDetailsInOnlineDB(userProfile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				userProfile.setAccNumber(userProfile.getAccNumber());
				new SMRAction()
				.resetMeterRead(userProfile.getAccNumber())
				.navigateToSMRAnonymousPage()
				.findYourAccounts(userProfile)
				.setPlausibleReadingsDualE7(userProfile.getAccNumber())
				.verifyMeterConfirmationAnonymous(userProfile.getElecAccount(), userProfile)
				.resetMeterRead(userProfile.getAccNumber())
				.navigateToSMRAnonymousPage()
				.findYourAccountsByPostCode(userProfile)
				.setPlausibleReadingsDualE7(userProfile.getAccNumber())
				.verifyMeterConfirmationAnonymous(userProfile.getElecAccount(), userProfile);
				
				
		 }
		 @Test(groups = { SubmitMeterRead,Regression,InProgress })
		 public void verifySMRAnonymousJISingle(){
			 
			 Report.createTestLogHeader("Submit Meter Read.", "submitMeterRead To Check Check Box Not Present Anonymous JI Single"); 
			 UserProfile userProfile = new TestDataHelper()
		        .getUserProfile("AnonymousJIAccount");
			 try {
					registerCustomerDetailsInOnlineDB(userProfile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				userProfile.setAccNumber(userProfile.getAccNumber());
				new SMRAction()
				.resetMeterRead(userProfile.getAccNumber())
				.navigateToSMRAnonymousPage()
				.findYourAccounts(userProfile)
				.setPlausibleReadingsDual(userProfile.getAccNumber())
				.verifyMeterConfirmationAnonymous(userProfile.getElecAccount(), userProfile)
				.resetMeterRead(userProfile.getAccNumber())
				.navigateToSMRAnonymousPage()
				.findYourAccountsByPostCode(userProfile)
				.setPlausibleReadingsDual(userProfile.getAccNumber())
				.verifyMeterConfirmationAnonymous(userProfile.getElecAccount(), userProfile);
				
		 }
		 @Test(groups = { SubmitMeterRead,Regression,InProgress })
		 public void verifySMRAnonymousJIDualMeter(){
			 
			 Report.createTestLogHeader("Submit Meter Read.", "submitMeterRead To Check Check Box Not Present Anonymous JI Dual Elec"); 
			 UserProfile userProfile = new TestDataHelper()
		        .getUserProfile("AnonymousJIAccount");
			 try {
					registerCustomerDetailsInOnlineDB(userProfile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				userProfile.setAccNumber(userProfile.getAccNumber());
				new SMRAction()
				.resetMeterRead(userProfile.getAccNumber())
				.navigateToSMRAnonymousPage()
				.findYourAccounts(userProfile)
				.setPlausibleReadingAnonymousJIGas(userProfile.getAccNumber())
				.verifyMeterConfirmationAnonymous(userProfile.getElecAccount(), userProfile)
				.resetMeterRead(userProfile.getAccNumber())
				.navigateToSMRAnonymousPage()
				.findYourAccountsByPostCode(userProfile)
				.setPlausibleReadingAnonymousJIGas(userProfile.getAccNumber())
				.verifyMeterConfirmationAnonymous(userProfile.getElecAccount(), userProfile);
				
				
		 }
////////////////////////////////////////ANONYMOUS SMR ALONG WITH REGISTRATION////////////////////////////////////////////////////////////////////////////
		 
		 @Test(groups = { SubmitMeterRead,Regression,InProgress })
		 public void verifySMRAnonymousGasWithReg(){
			 
			 Report.createTestLogHeader("Submit Meter Read.", "submitMeterRead To Check Check Box Not Present Anonymous "); 
			 UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");///Give valid Non OAM Customer Details////
			 new OnlineDBConnector().deRegister(userProfile.getUCRN());   
			 try {
					registerCustomerDetailsInOnlineDB(userProfile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//userProfile.setAccNumber(userProfile.getAccNumber());
				
				new SMRAction()
				.resetMeterRead(userProfile.getAccNumber())
				.navigateToSMRAnonymousPage()
				.findYourAccounts(userProfile)
				.setPlausibleReadingAnonymous(userProfile.getAccNumber())
				.verifyMeterConfirmationAnonymous(userProfile.getElecAccount(), userProfile)
				.verifyQuickRegisterOverlay()
				.verifyAccountPresence()
				.logout();
				/* new OnlineDBConnector().deRegister(userProfile.getUCRN());
				 new SMRAction()
				    .resetMeterRead(userProfile.getAccNumber())
					.navigateToSMRAnonymousPage()
					.findYourAccountsByPostCode(userProfile)
					.setPlausibleReadingAnonymous(userProfile.getAccNumber())
					.verifyMeterConfirmationAnonymous(userProfile.getElecAccount(), userProfile)
					.verifyQuickRegisterOverlay()
					.verifyAccountPresence()
				    .logout();
				*/
		 }	 
		 @Test(groups = { SubmitMeterRead,Regression,InProgress })
		 public void verifySMRAnonymousElecWithReg (){
			 
			 Report.createTestLogHeader("Submit Meter Read.", "submitMeterRead To Check Check Box Not Present Elec with Reg "); 
			 UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousElecAccount");///Give valid Non OAM Customer Details////
			 new OnlineDBConnector().deRegister(userProfile.getUCRN());   
			 try {
					registerCustomerDetailsInOnlineDB(userProfile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//userProfile.setAccNumber(userProfile.getAccNumber());
				
				new SMRAction()
				.resetMeterRead(userProfile.getAccNumber())
				.navigateToSMRAnonymousPage()
				.findYourAccounts(userProfile)
				.setPlausibleReadingAnonymous(userProfile.getAccNumber())
				.verifyMeterConfirmationAnonymous(userProfile.getElecAccount(), userProfile)
				.verifyQuickRegisterOverlay()
				.verifyAccountPresence();
				 new HomePageAction()
				 .logout();
				/* new OnlineDBConnector().deRegister(userProfile.getUCRN());
				 new SMRAction()
				    .resetMeterRead(userProfile.getAccNumber())
					.navigateToSMRAnonymousPage()
					.findYourAccountsByPostCode(userProfile)
					.setPlausibleReadingAnonymous(userProfile.getAccNumber())
					.verifyMeterConfirmationAnonymous(userProfile.getElecAccount(), userProfile)
					.verifyQuickRegisterOverlay()
					.verifyAccountPresence();
					 new HomePageAction()
					 .logout();*/
				
		 }	 
		 @Test(groups = { SubmitMeterRead,Regression,InProgress })
		 public void verifySMRAnonymousDualSingleWithReg(){
			 
			 Report.createTestLogHeader("Submit Meter Read.", "submitMeterRead To Check Check Box Not Present Anonymous Dual Single"); 
			 UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousDualAccount");
			 new OnlineDBConnector().deRegister(userProfile.getUCRN());   
			 try {
					registerCustomerDetailsInOnlineDB(userProfile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//userProfile.setAccNumber(userProfile.getAccNumber());
				new SMRAction()
				.resetMeterRead(userProfile.getAccNumber())
				.navigateToSMRAnonymousPage()
				.findYourAccounts(userProfile)
				.setPlausibleReadingsDual(userProfile.getAccNumber())
				.verifyMeterConfirmationAnonymous(userProfile.getElecAccount(), userProfile)
				.verifyQuickRegisterOverlay()
				.verifyAccountPresence();
				 new HomePageAction()
				 .logout();
				/* new OnlineDBConnector().deRegister(userProfile.getUCRN());
				 new SMRAction()
				    .resetMeterRead(userProfile.getAccNumber())
					.navigateToSMRAnonymousPage()
					.findYourAccountsByPostCode(userProfile)
					.setPlausibleReadingsDual(userProfile.getAccNumber())
					.verifyMeterConfirmationAnonymous(userProfile.getElecAccount(), userProfile)
					.verifyQuickRegisterOverlay()
					.verifyAccountPresence();
					 new HomePageAction()
					 .logout();*/
				
		 }
		 @Test(groups = { SubmitMeterRead,Regression,InProgress })
		 public void verifySMRAnonymousDualSingleWithRegOLD(){
			 
			 Report.createTestLogHeader("Submit Meter Read.", "submitMeterRead To Check Check Box Not Present Anonymous Dual Single"); 
			 UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousDualAccount");
			 new OnlineDBConnector().deRegister(userProfile.getUCRN());   
			 try {
					registerCustomerDetailsInOnlineDB(userProfile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				userProfile.setAccNumber(userProfile.getAccNumber());
				new SMRAction()
				.resetMeterRead(userProfile.getAccNumber())
				.navigateToSMRAnonymousPage()
				.findYourAccounts(userProfile)
				.setPlausibleReadingsDual(userProfile.getAccNumber())
				.verifyMeterConfirmationAnonymous(userProfile.getElecAccount(), userProfile)
				.EnterRegistrationDetailas()
				.verifyQuickRegisterOverlay()
				.verifyAccountPresence();
				 new HomePageAction()
				 .logout();
				 new OnlineDBConnector().deRegister(userProfile.getUCRN());
				 new SMRAction()
				    .resetMeterRead(userProfile.getAccNumber())
					.navigateToSMRAnonymousPage()
					.findYourAccountsByPostCode(userProfile)
					.setPlausibleReadingsDual(userProfile.getAccNumber())
					.verifyMeterConfirmationAnonymous(userProfile.getElecAccount(), userProfile)
					.EnterRegistrationDetailas()
					.verifyQuickRegisterOverlay()
					.verifyAccountPresence();
					 new HomePageAction()
					 .logout();
				
		 }
		 @Test(groups = { SubmitMeterRead,Regression,InProgress })
		 public void verifySMRAnonymousDualE7WithReg(){
			 
			 Report.createTestLogHeader("Submit Meter Read.", "submitMeterRead To Check Check Box Not Present Anonymous Dual Single"); 
			 UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousDualAccount");
			 new OnlineDBConnector().deRegister(userProfile.getUCRN());   
			 try {
					registerCustomerDetailsInOnlineDB(userProfile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				userProfile.setAccNumber(userProfile.getAccNumber());
				new SMRAction()
				.resetMeterRead(userProfile.getAccNumber())
				.navigateToSMRAnonymousPage()
				.findYourAccounts(userProfile)
				.setPlausibleReadingsDualE7(userProfile.getAccNumber())
				.verifyMeterConfirmationAnonymous(userProfile.getElecAccount(), userProfile)
				.EnterRegistrationDetailas()
				.verifyQuickRegisterOverlay()
				.verifyAccountPresence();
				 new HomePageAction()
				 .logout();
				/* new OnlineDBConnector().deRegister(userProfile.getUCRN());
				 new SMRAction()
				    .resetMeterRead(userProfile.getAccNumber())
					.navigateToSMRAnonymousPage()
					.findYourAccountsByPostCode(userProfile)
					.setPlausibleReadingsDualE7(userProfile.getAccNumber())
					.verifyMeterConfirmationAnonymous(userProfile.getElecAccount(), userProfile)
					.EnterRegistrationDetailas()
					.verifyQuickRegisterOverlay()
					.verifyAccountPresence();
					 new HomePageAction()
					 .logout();
				*/
		 }
		 @Test(groups = { SubmitMeterRead,Regression,InProgress })
		 public void verifySMRAnonymousJISingleWithReg(){
			 
			 Report.createTestLogHeader("Submit Meter Read.", "submitMeterRead To Check Check Box Not Present Anonymous Dual Single"); 
			 UserProfile userProfile = new TestDataHelper() .getUserProfile("AnonymousJIAccount");
			 new OnlineDBConnector().deRegister(userProfile.getUCRN());   
			 try {
					registerCustomerDetailsInOnlineDB(userProfile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				userProfile.setAccNumber(userProfile.getAccNumber());
				new SMRAction()
				.resetMeterRead(userProfile.getAccNumber())
				.navigateToSMRAnonymousPage()
				.findYourAccounts(userProfile)
				.setPlausibleReadingAnonymousJI(userProfile.getAccNumber())
				.verifyMeterConfirmationAnonymous(userProfile.getElecAccount(), userProfile)
				.verifyQuickRegisterOverlay()
				.verifyAccountPresence();
				 new HomePageAction()
				 .logout();
				/* new OnlineDBConnector().deRegister(userProfile.getUCRN());
				 new SMRAction()
				.resetMeterRead(userProfile.getAccNumber())
				.navigateToSMRAnonymousPage()
				.findYourAccountsByPostCode(userProfile)
				.setPlausibleReadingAnonymousJI(userProfile.getAccNumber())
				.verifyMeterConfirmationAnonymous(userProfile.getElecAccount(), userProfile)
				.verifyQuickRegisterOverlay()
				.verifyAccountPresence();
				new HomePageAction()
				.logout();
				*/
				
		 }
		 @Test(groups = { SubmitMeterRead,Regression,InProgress })
		 public void verifySMRAnonymousJIDualMeterWithReg(){
			 
			 Report.createTestLogHeader("Submit Meter Read.", "submitMeterRead To Check Check Box Not Present Anonymous JI Dual Elec"); 
			 UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousJIAccount");
			 new OnlineDBConnector().deRegister(userProfile.getUCRN());   
			 try {
					registerCustomerDetailsInOnlineDB(userProfile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				userProfile.setAccNumber(userProfile.getAccNumber());
				new SMRAction()
				.resetMeterRead(userProfile.getAccNumber())
				.navigateToSMRAnonymousPage()
				.findYourAccounts(userProfile)
				.setPlausibleReadingAnonymousJIGas(userProfile.getAccNumber())
				.verifyMeterConfirmationAnonymous(userProfile.getElecAccount(), userProfile)
				.verifyQuickRegisterOverlay()
				.verifyAccountPresence();
				 new HomePageAction()
				 .logout();
				 new OnlineDBConnector().deRegister(userProfile.getUCRN());
				 new SMRAction()
				    .resetMeterRead(userProfile.getAccNumber())
					.navigateToSMRAnonymousPage()
					.findYourAccountsByPostCode(userProfile)
					.setPlausibleReadingAnonymousJIGas(userProfile.getAccNumber())
					.verifyMeterConfirmationAnonymous(userProfile.getElecAccount(), userProfile)
					.verifyQuickRegisterOverlay()
					.verifyAccountPresence();
					 new HomePageAction()
					 .logout();
				
				
		 }
		 
///////////////////////////////////////////SMR FROM ACCOUNT OVERVIEW/////////////////////////////////////////////////////////////////////////////////////
		

			 @Test(groups = { SubmitMeterRead,Regression,InProgress })
			 	//Yet to make Sap Validations
			public void smrFromAccountOverviewElec() {
				Report.createTestLogHeader("Submit Meter Read From Account Overview", "Plausible Electricity Meter");

				UserProfile userProfile = new TestDataHelper()
				        .getUserProfile("ElectricityAccount");
				try {
					registerCustomerDetailsInOnlineDB(userProfile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//getCustomerDetailsToUserProfileOAM(userProfile);
				userProfile.setAccNumber(userProfile.getElecAccount());
				new SMRAction().resetMeterRead(userProfile.getElecAccount());// .resetMeterRead("85000000058");
				new HomePageAction()
				.navigateToLogin()
				.login(userProfile);
				new SMRAction()
				.navigateToSMRFromAccountOverview()
				.setPlausbileReading(userProfile.getElecAccount())
		        .confirmAccountSelection().submitMeterReads()
		        .verifyMeterConfirmation(userProfile.getElecAccount(), userProfile);
				
				        

			}		 
			 @Test(groups = { SubmitMeterRead,Regression,InProgress })
			 	//Yet to make Sap Validations
			public void smrFromAccountOverviewElecImplausible() {
				Report.createTestLogHeader("Submit Meter Read From Account Overview", "Plausible Electricity Meter");

				UserProfile userProfile = new TestDataHelper()
				        .getUserProfile("ElectricityAccount");
				try {
					registerCustomerDetailsInOnlineDB(userProfile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//getCustomerDetailsToUserProfileOAM(userProfile);
				userProfile.setAccNumber(userProfile.getElecAccount());
				new SMRAction().resetMeterRead(userProfile.getElecAccount());// .resetMeterRead("85000000058");
				new HomePageAction()
				.navigateToLogin()
				.login(userProfile);
				new SMRAction()
				.navigateToSMRFromAccountOverview()
				.setImPlausbileReading(userProfile.getElecAccount())
		        .confirmAccountSelection().submitMeterReads()
		        .verifyMeterConfirmation(userProfile.getElecAccount(), userProfile);
				
				        

			}		 


		

			 @Test(groups = { SubmitMeterRead,Regression,InProgress })
			 	//Yet to make Sap Validations
			public void smrFromAccountOverviewDual() {
				Report.createTestLogHeader("Submit Meter Read From Account Overview", "Plausible Dual Meter");

				UserProfile userProfile = new TestDataHelper()
				        .getUserProfile("DualAccount");
				try {
					registerCustomerDetailsInOnlineDB(userProfile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//getCustomerDetailsToUserProfileOAM(userProfile);
				userProfile.setAccNumber(userProfile.getElecAccount());
				new SMRAction().resetMeterRead(userProfile.getElecAccount());// .resetMeterRead("85000000058");
				new HomePageAction()
				.navigateToLogin()
				.login(userProfile);
				new SMRAction()
				.navigateToSMRFromAccountOverviewDualGas(userProfile)
				.setPlausibleReadingsDualGas(userProfile.getAccNumber())
		        .confirmAccountSelection().submitMeterReads()
		        .verifyMeterConfirmation(userProfile.getElecAccount(), userProfile)
		        .logout();
		        /*.navigateToAccountOverview()
		        .navigateToSMRFromAccountOverviewDualElec(userProfile)
				.setPlausibleReadingElec(userProfile.getAccNumber())
		        .confirmAccountSelection().submitMeterReads()
		        .verifyMeterConfirmation(userProfile.getElecAccount(), userProfile);*/
				        

			}	
			 @Test(groups = { SubmitMeterRead,Regression,InProgress })
			 	//Yet to make Sap Validations
			public void smrFromAccountOverviewJI() {
				Report.createTestLogHeader("Submit Meter Read From Account Overview", "Plausible Dual Meter");

				UserProfile userProfile = new TestDataHelper()
				        .getUserProfile("JIAccount");
				try {
					registerCustomerDetailsInOnlineDB(userProfile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//getCustomerDetailsToUserProfileOAM(userProfile);
				userProfile.setAccNumber(userProfile.getElecAccount());
				new SMRAction().resetMeterRead(userProfile.getElecAccount());// .resetMeterRead("85000000058");
				new HomePageAction()
				.navigateToLogin()
				.login(userProfile);
				new SMRAction()
				.navigateToSMRFromAccountOverview()
				.setPlausibleReadingsDualGas(userProfile.getAccNumber())
		        .confirmAccountSelection().submitMeterReads()
		        .verifyMeterConfirmation(userProfile.getElecAccount(), userProfile)
		        .logout();
			 }
			
			 @Test(groups = { SubmitMeterRead,Regression,InProgress })
			 public void submitPlausibleElecDualMeterFromAccountOverview() {
					Report.createTestLogHeader("Submit Meter Read.", "Plausible Electricity Meter");

					UserProfile userProfile = new TestDataHelper()
					        .getUserProfile("ElectricityAccount");
					try {
						registerCustomerDetailsInOnlineDB(userProfile);
					} catch (Exception e) {
						e.printStackTrace();
					}
					//getCustomerDetailsToUserProfileOAM(userProfile);
					userProfile.setAccNumber(userProfile.getElecAccount());
					new SMRAction().resetMeterRead(userProfile.getElecAccount());// .resetMeterRead("85000000058");
					new HomePageAction()
					.navigateToLogin()
					.login(userProfile);
					new SMRAction()
					        .navigateToSMRFromAccountOverviewDualElec(userProfile)
					        .setPlausibleReadingElecDay(userProfile.getElecAccount())
					        .confirmAccountSelection().submitMeterReads()
					        .verifyMeterConfirmation(userProfile.getElecAccount(), userProfile);

				}
			 @Test(groups = { SubmitMeterRead,Smoke })
				//Yet to make Sap Validations
				public void submitPlausibleGasMeterFromAccountOverview() {
					Report.createTestLogHeader("Submit Meter Read.", "Plausible Gas Meter");
					

					UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");

					userProfile.setAccNumber(userProfile.getGasAccount());
					
					//getCustomerDetailsToUserProfileOAM(userProfile);

					//new SMRAction().resetMeterRead(userProfile.getGasAccount());
					new HomePageAction()
					.navigateToLogin()
					.login(userProfile);
					new SMRAction()
			                .navigateToSMRFromAccountOverviewDualGas(userProfile)
			                .setPlausbileReading(userProfile.getGasAccount())
			                .confirmAccountSelection()
			                .verifyMeterConfirmation(userProfile.getGasAccount(), userProfile);

				}
				@Test(groups = { SubmitMeterRead,Smoke })
				public void submitImPlausibleGasMeterFromAccountOverview() {
					Report.createTestLogHeader("Submit Meter Read.", "ImPlausible Gas Meter");


					UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");

					userProfile.setAccNumber(userProfile.getGasAccount());

					//getCustomerDetailsToUserProfileOAM(userProfile);

					new SMRAction().resetMeterRead(userProfile.getGasAccount());// .resetMeterRead("85000000058");
					new HomePageAction()
					.navigateToLogin()
					.login(userProfile);
					new SMRAction()
					        .navigateToSMRFromAccountOverviewDualGas(userProfile)
					        .setImPlausbileReading(userProfile.getGasAccount())
					        .confirmAccountSelection()
					        .verifyMeterConfirmation(userProfile.getGasAccount(), userProfile);

				}
				
}
