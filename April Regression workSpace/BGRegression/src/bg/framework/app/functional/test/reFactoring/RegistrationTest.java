package bg.framework.app.functional.test.reFactoring;

import java.util.ArrayList;


import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.reFactoring.RegistrationAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.*;

import org.testng.annotations.Test;
import static bg.framework.app.functional.entities.FunctionalCategory.BGRRegistration;
import static bg.framework.app.functional.entities.FunctionalCategory.Refactoring;
import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;


public class RegistrationTest extends TestBase {
	Tunnel putty = new Tunnel();


	@Test(groups = {BGRRegistration,Refactoring})
	public void activeEleRegistrationAccountNo() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user can successfully Register Via Accout Number");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount1");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="AccNo";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}


	@Test(groups = {BGRRegistration,Refactoring})
	public void activeEleRegistrationViaEmail() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user can successfully Register Via Email");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="Email";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	@Test(groups = {BGRRegistration,Refactoring})
	public void activeEleRegistrationViaDD() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user can successfully Register Via DD");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	@Test(groups = {BGRRegistration,Refactoring})
	public void activeEleRegistrationViaSO() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user can successfully Register Via SO");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount1");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="SO";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationDD_03_BG ////////////////////////////////////////////////////////////

	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, DDNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void eleBGRegistrationViaDD() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user can successfully Register Via DD-BG");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationDD_11_BG ////////////////////////////////////////////////////////////

	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, DDNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void jiAIBGRegistrationViaDD() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the JI(Active+Inactive less than 6 month) Only Account user can successfully Register Via DD-BG");
		UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationDD_15_BG ////////////////////////////////////////////////////////////

	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, DDNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void dualBGRegistrationViaDD() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Dual Only Account user can successfully Register Via DD-BG");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationDD_18_BG ////////////////////////////////////////////////////////////

	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, DDNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void dualAIBGRegistrationViaDD() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Dual(active+inactive less than 3 months) Only Account user can successfully Register Via DD-BG");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}


	/////////////////////////////////////////TestCase ID: OnlineRegistrationDD_05_BG ////////////////////////////////////////////////////////////

	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, DDNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void jiBGRegistrationViaDD() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the JI Only Account user can successfully Register Via DD-BG");
		UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationDD_07_BG ////////////////////////////////////////////////////////////

	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, DDNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void singleBGRegistrationViaDD() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the single fual user can successfully Register Via DD-BG");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount1");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationDD_09_BG ////////////////////////////////////////////////////////////

	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, DDNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void dualsibelBGRegistrationViaDD() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the dual account user can successfully Register Via DD-BG");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationDD_17_BG ////////////////////////////////////////////////////////////

	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, DDNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void homeServiceBGRegistrationViaDD() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the HomeServicesAccount user can successfully Register Via DD-BG");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServiceAccount2");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="Email";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}


	/////////////////////////////////////////TestCase ID: OnlineRegistrationDD_19_BG ////////////////////////////////////////////////////////////

	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, DDNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void homeServiceJIBGRegistrationViaDD() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the JI+HomeService user can successfully Register Via DD-BG");
		UserProfile userProfile = new TestDataHelper().getUserProfile("JI+HomeService");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationDD_20_BG ////////////////////////////////////////////////////////////

	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, DDNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void homeServiceDualBGRegistrationViaDD() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the HomeServicesAccount+Dual user can successfully Register Via DD-BG");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount+Dual");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}


	/////////////////////////////////////////TestCase ID: OnlineRegistrationDD_21_BG ////////////////////////////////////////////////////////////

	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, DDNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void homeServiceDualAIBGRegistrationViaDD() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the HomeServicesAccount+Dual(active+inactive less 6 month) user can successfully Register Via DD-BG");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationDD_24_BG ////////////////////////////////////////////////////////////

	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, DDNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void homeDualBGRegistrationViaDD() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the HomeServicesAccount+Dual user can successfully Register Via DD-BG");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount+Dual");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}


	/////////////////////////////////////////////////SE---DD///////////////////////////////////////////////////////////////////////////////////////

	/////////////////////////////////////////TestCase ID: OnlineRegistrationDD_04_SE ////////////////////////////////////////////////////////////

	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, DDNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void eleActiveSERegistrationViaDD() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Electricity Account user can successfully Register Via DD-BG");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationDD_12_SE ////////////////////////////////////////////////////////////

	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, DDNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void jiActiveSERegistrationViaDD() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the JI Account user can successfully Register Via DD-BG");
		UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount1");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationDD_06_SE ////////////////////////////////////////////////////////////

	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, DDNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void jiActSERegistrationViaDD() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the JI Account user can successfully Register Via DD-BG");
		UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount1");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationDD_08_SE ////////////////////////////////////////////////////////////

	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, DDNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void singleSERegistrationViaDD() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the single user can successfully Register Via DD-BG");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationDD_10_SE ////////////////////////////////////////////////////////////

	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, DDNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void dualActSERegistrationViaDD() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Dual Account user can successfully Register Via DD-BG");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount1");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}


	/////////////////////////////////////////////////BG---EMAIL///////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////TestCase ID: OnlineRegistrationEmailAddress_13_BG////////////////////////////////////////////////////////   

	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr
	@Test(groups = {BGRRegistration,Refactoring})
	public void activeHDRegistrationViaEmail() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Homeservice+Dual Account user can successfully Register Via Email");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="Email";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType);
		new AccountOverviewAction()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationEmailAddress_14_BG////////////////////////////////////////////////////////   
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr
	@Test(groups = {BGRRegistration,Refactoring})
	public void dualActiveRegistrationViaEmail() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Dual Account(Active+Gas final billed) user can successfully Register Via Email");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="Email";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType);
		new AccountOverviewAction()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationEmailAddress_15_BG////////////////////////////////////////////////////////   
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr
	@Test(groups = {BGRRegistration,Refactoring})
	public void jiActiveRegistrationViaEmail() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the JI account user can successfully Register Via Email");
		UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="Email";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType);
		new AccountOverviewAction()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationEmailAddress_07_BG////////////////////////////////////////////////////////   
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr
	@Test(groups = {BGRRegistration,Refactoring})
	public void billActiveRegistrationViaEmail() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the (finally billed generated last 6 month) user can successfully Register Via Email");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="Email";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType);
		new AccountOverviewAction()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationEmailAddress_21_BG////////////////////////////////////////////////////////   
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr
	@Test(groups = {BGRRegistration,Refactoring})
	public void dualServiceActiveRegistrationViaEmail() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Dual Account(Active+Gas final billed) user can successfully Register Via Email");
		UserProfile userProfile = new TestDataHelper().getUserProfile("Homeservice+Dual");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="Email";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType);
		new AccountOverviewAction()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}
	/////////////////////////////////////////TestCase ID: OnlineRegistrationEmailAddress_22_BG////////////////////////////////////////////////////////   
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr
	@Test(groups = {BGRRegistration,Refactoring})
	public void jiRegistrationViaEmail() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the JI account user can successfully Register Via Email");
		UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="Email";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType);
		new AccountOverviewAction()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationEmailAddress_05_BG////////////////////////////////////////////////////////   
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr
	@Test(groups = {BGRRegistration,Refactoring})
	public void gasRegistrationViaEmail() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Gas account user can successfully Register Via Email");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="Email";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType);
		//.goToYourAccount()
		new AccountOverviewAction()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationEmailAddress_08_BG////////////////////////////////////////////////////////   
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr
	@Test(groups = {BGRRegistration,Refactoring})
	public void eleRegistrationViaEmail() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Electricity account user can successfully Register Via Email");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="Email";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType);
		new AccountOverviewAction()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationEmailAddress_12_BG////////////////////////////////////////////////////////   
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr
	@Test(groups = {BGRRegistration,Refactoring})
	public void homeRegistrationViaEmail() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Electricity account user can successfully Register Via Email");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServiceAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="Email";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType);
		new AccountOverviewAction()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationEmailAddress_23_BG////////////////////////////////////////////////////////   
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr
	@Test(groups = {BGRRegistration,Refactoring})
	public void dualRegistrationViaEmail() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Dual account user can successfully Register Via Email");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="Email";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType);
		new AccountOverviewAction()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}


	/////////////////////////////////////////////////SE---EMAIL///////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////TestCase ID: OnlineRegistrationEmailAddress_11_SE////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr
	@Test(groups = {BGRRegistration,Refactoring})
	public void jiSERegistrationViaEmail() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the JI account user can successfully Register Via Email");
		UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount1");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="Email";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType);
		new AccountOverviewAction()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationEmailAddress_16_SE////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr
	@Test(groups = {BGRRegistration,Refactoring})
	public void jiInactiveSERegistrationViaEmail() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the JI account(inactive greater and less 6 months) user can successfully Register Via Email");
		UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount1");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="Email";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType);
		new AccountOverviewAction()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationEmailAddress_06_SE////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr
	@Test(groups = {BGRRegistration,Refactoring})
	public void gasSERegistrationViaEmail() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Gas account user can successfully Register Via Email");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount1");
		//        new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="Email";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType);
		new AccountOverviewAction()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationEmailAddress_09_SE////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr
	@Test(groups = {BGRRegistration,Refactoring})
	public void eleSERegistrationViaEmail() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the ElectricityAccount user can successfully Register Via Email");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount1");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="Email";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType);
		new AccountOverviewAction()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationEmailAddress_19_SE////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr
	@Test(groups = {BGRRegistration,Refactoring})
	public void dualSERegistrationViaEmail() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the DualAccount user can successfully Register Via Email");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount1");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="Email";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType);
		new AccountOverviewAction()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}


	/////////////////////////////////////////////////BG---SSO///////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////TestCase ID: OnlineRegistrationSSO_01_BG //////////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, SalesNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void eleActiveRegistrationViaSO() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user can successfully Register Via SO");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="SO";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationSSO_03_BG //////////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, SalesNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void serviceActiveRegistrationViaSO() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the HomeServiceAccount Account user can successfully Register Via SO");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServiceAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="SO";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationSSO_10_BG //////////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, SalesNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void dualActiveRegistrationViaSO() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Dual(final billed+Joint) Account user can successfully Register Via SO");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="SO";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationSSO_11_BG //////////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, SalesNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void servicedemandActiveRegistrationViaSO() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the HomeServiceAccount(Service on demand) Account user can successfully Register Via SO");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServiceAccount1");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="SO";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationSSO_12_BG //////////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, SalesNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void energyssoActiveRegistrationViaSO() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Energy+SSO Account user can successfully Register Via SO");
		UserProfile userProfile = new TestDataHelper().getUserProfile("Energy+SSO");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="SO";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationSSO_09_BG //////////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, SalesNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void activeRegistrationViaSO() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the single user can successfully Register Via SO");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="SO";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationSSO_14_BG //////////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, SalesNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void dualactiveRegistrationViaSO() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the dual user can successfully Register Via SO");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="SO";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationSSO_16_BG //////////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, SalesNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void dualserviceRegistrationViaSO() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the dual+service user can successfully Register Via SO");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="SO";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}


	/////////////////////////////////////////TestCase ID: OnlineRegistrationSSO_17_BG //////////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, SalesNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void energyRegistrationViaSO() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Energy user can successfully Register Via SO");
		UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="SO";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationSSO_19_BG //////////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, SalesNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void dualinactiveRegistrationViaSO() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Dual(active+inactive) user can successfully Register Via SO");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="SO";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationSSO_21_BG //////////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, SalesNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void energyActiveRegistrationViaSO() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Energy user can successfully Register Via SO");
		UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="SO";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationSSO_25_BG //////////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, SalesNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void energyorserviceRegistrationViaSO() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Energy or Service user can successfully Register Via SO");
		UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="SO";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////////////SE---SSO///////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////TestCase ID: OnlineRegistrationSSO_02_SE //////////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, SalesNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void jiActiveRegistrationViaSO() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Energy Account user can successfully Register Via SO");
		UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount1");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="SO";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationSSO_13_SE //////////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, SalesNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void energySSOActiveRegistrationViaSO() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Energy+SSO Only Account user can successfully Register Via SO");
		UserProfile userProfile = new TestDataHelper().getUserProfile("Energy+SSO");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="SO";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationSSO_15_SE //////////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, SalesNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void dualSERegistrationViaSO() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Dual Account user can successfully Register Via SO");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount1");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="SO";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationSSO_22_SE //////////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, SalesNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void energySERegistrationViaSO() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Energy Account user can successfully Register Via SO");
		UserProfile userProfile = new TestDataHelper().getUserProfile("SSOAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="SO";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}



	/////////////////////////////////////////////////SE---Account///////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////TestCase ID: Registration_TC_023 //////////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, AccNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void serviceegistrationAccountNo() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Home service Account user can successfully Register Via Accout Number");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServiceAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="AccNo";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: Registration_TC_038 //////////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, AccNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void dualServiceRegistrationAccountNo() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the dual+homeservice(closed) Account user can successfully Register Via Accout Number");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount1");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="AccNo";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: Registration_TC_043 //////////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, AccNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void dualbillhomeRegistrationAccountNo() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the dual(Finally Billed)+homeservice Account user can successfully Register Via Accout Number");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="AccNo";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	} 

	/////////////////////////////////////////TestCase ID: Registration_TC_046 //////////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, AccNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void dualHomeRepRegistrationAccountNo() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the dual(ele-contract owner)+homeservice(Representative) Account user can successfully Register Via Accout Number");
		UserProfile userProfile = new TestDataHelper().getUserProfile("dual(ele-contract owner)+homeservice(Representative)");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="AccNo";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	} 
	/////////////////////////////////////////TestCase ID: Registration_TC_050 //////////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, AccNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void dualSSORegistrationAccountNo() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the dual+SSO Account user can successfully Register Via Accout Number");
		UserProfile userProfile = new TestDataHelper().getUserProfile("dual+SSO");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="AccNo";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	} 

	/////////////////////////////////////////TestCase ID: Registration_TC_067 //////////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, AccNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void PBRegistrationAccountNo() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the PB pre registartion customer can successfully Register Via Accout Number");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount1");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="AccNo";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	} 
	/////////////////////////////////////////TestCase ID: Registration_TC_068 //////////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, AccNo

	@Test(groups = {BGRRegistration,Refactoring})
	public void thisProfileRegistrationAccountNo() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Thin profile customer can successfully Register Via Accout Number");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="AccNo";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	} 
	/////////////////////////////////////////TestCase ID: Registration_TC_069 //////////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, AccNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void BGSPreRegistrationAccountNo() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the BGS pre registration customer can successfully Register Via Accout Number");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="AccNo";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	} 
	/////////////////////////////////////////TestCase ID: Registration_TC_070 //////////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, AccNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void FastTrackRegistrationAccountNo() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Registration through JI");
		UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount1");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="AccNo";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: Online_registration_PersonalDetails_04 //////////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, AccNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void dualBGRegistrationViaAccount() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the user can successfully Register Via Accout Number");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="AccNo";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistration_NectarRegistration_BG_01 //////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, AccNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void gasBGRegistrationViaAccountCrm() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the user can successfully Register Via Accout Number-Nectar Registration-CRM");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount1");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="AccNo";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber());
		new RegistrationAction()
		.nectarRegistration()
		.logout();
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistration_NectarRegistration_BG_02 /////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, AccNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void gasBGRegistrationViaAccountSibel() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the user can successfully Register Via Accout Number-Nectar registration-Sibel");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="AccNo";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber());
		new RegistrationAction()
		.nectarRegistration()
		.logout();
	}

	/////////////////////////////////////////////////SE---Cross Brand///////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////TestCase ID: OnlineRegistrationDD_16_SE ////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, AccNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void crossBrandSEDualDD() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the error message displayed- Cross Brand BG registered - Dual");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		String brand="SE";
		new HomePageAction()
		.loginDetails(userProfile);
		new AccountOverviewAction()
		.errorMessgaeSE(brand);
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationSSO_24_SE ////////////////////////////////////////////////////////

	@Test(groups = {BGRRegistration,Refactoring})
	public void crossBrandSEJIDD() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the error message displayed- Cross Brand BG registered -JI");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		String brand="SE";
		new HomePageAction()
		.loginDetails(userProfile);
		new AccountOverviewAction()
		.errorMessgaeSE(brand);
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationSSO_23_BG ////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr, AccNo
	@Test(groups = {BGRRegistration,Refactoring})
	public void energySSOActiveCrossBrandBG() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the error message displayed- Cross Brand SE registered -JI");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount1");
		String brand="BG";
		new HomePageAction()
		.loginDetails(userProfile);
		new AccountOverviewAction()
		.errorMessgaeSE(brand);
	}


	/////////////////////////////////////////////////BG---Option///////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////TestCase ID: OnlineRegistrationEmailAddress_01_BG ////////////////////////////////////////////////////////

	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr
	@Test(groups = {BGRRegistration,Refactoring})
	public void threeOptionValidationViaEmail() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Homeservice+Dual Account user can successfully Register Via Email");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="Email";
		String optionType="3";
		new HomePageAction()
		.navigateToRegistration()
		.optionButtonverification(userProfile, userProfile.getAccNumber(),registerType, optionType);
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationDD_27_BG ////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr
	@Test(groups = {BGRRegistration,Refactoring})
	public void dualValidationNoDD() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the DD Option is not presentactive greater than 6 month and less than 6 month");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="Email";
		new HomePageAction()
		.navigateToRegistration()
		.optionNoDD(userProfile, userProfile.getAccNumber(),registerType);
	}

	/////////////////////////////////////////TestCase ID: OnlineRegistrationDD_27_BG ////////////////////////////////////////////////////////
	//Mandatory Field: UCRN, Account No,First name, Last name, Title, Addr
	@Test(groups = {BGRRegistration,Refactoring})
	public void validationNoDD() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the DD Option is not presentactive greater than 6 month and less than 6 month");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="Email";
		new HomePageAction()
		.navigateToRegistration()
		.optionNoDD(userProfile, userProfile.getAccNumber(),registerType);
	}

	/////////GAS///////////////////////////////////////
	@Test(groups = {BGRRegistration,Refactoring})
	public void gasRegistration_Old() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the GasAccount user can successfully Register Via Email,ACCNO,DD,SO");
		UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousGasAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
		/*new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType0="Email";
		new HomePageAction()
		.navigateToRegistration()														
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType0);
		new AccountOverviewAction()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();*/
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType1="AccNo";
		new HomePageAction()
		.navigateToRegistration()																																														
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType1)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="SO";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	@Test(groups = {BGRRegistration,Refactoring})
	public void gasRegistration() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the GasAccount user can successfully Register Via Email,ACCNO,DD,SO");
		UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousGasAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew_01(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccountnew()
		.logout();
		
	}
	
	@Test(groups = {BGRRegistration,Refactoring})
	public void eleRegistration() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the ElectricityAccount user can successfully Register");
		UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousElecAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew_01(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccountnew()
		.logout();
		
	}
	

	/////////ElectricityAccount///////////////////////////////////////
	@Test(groups = {BGRRegistration,Refactoring})
	public void eleRegistration_Old() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the ElectricityAccount user can successfully Register");
		UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousElecAccount");

		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.BgrnavigateToLoginPage();
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew_01(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
		/*new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType0="Email";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType0);
		new AccountOverviewAction()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();*/
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType1="AccNo";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType1)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="SO";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	@Test(groups = {BGRRegistration,Refactoring})
	public void jiRegistration() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the JIAccount user can successfully Register");
		UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousJIAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew_01(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccountnew()
		.logout();
		
	}

	/////////JI///////////////////////////////////////
	@Test(groups = {BGRRegistration,Refactoring})
	public void jiRegistration_Old() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the JIAccount user can successfully Register Via Email,ACCNO,DD,SO");
		UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousJIAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
		/*new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType0="Email";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType0);
		new AccountOverviewAction()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();*/
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType1="AccNo";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType1)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="SO";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	@Test(groups = {BGRRegistration,Refactoring})
	public void homeRegistration() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the HomeAccount user can successfully Register");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew_01(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccountnew()
		.logout();
		
	}

	/////////HomeService///////////////////////////////////////
	@Test(groups = {BGRRegistration,Refactoring})
	public void homeRegistration_Old() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the HomeAccount user can successfully Register Via Email,ACCNO,DD,SO");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
		/*new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType0="Email";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType0);
		new AccountOverviewAction()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();*/
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType1="AccNo";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType1)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="SO";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}


	/////////DUAL///////////////////////////////////////
	
	@Test(groups = {BGRRegistration,Refactoring})
	public void dualRegistration() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the dualAccount user can successfully Register Via Email,ACCNO,DD,SO");
		UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousDualAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew_01(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccountnew()
		.logout();
	}
	
	
	@Test(groups = {BGRRegistration,Refactoring})
	public void dualRegistration_Old() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the dualAccount user can successfully Register Via Email,ACCNO,DD,SO");
		UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousDualAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
		/*new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType0="Email";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType0);
		new AccountOverviewAction()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();*/
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType1="AccNo";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType1)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="SO";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}


	/////////Inactive Account///////////////////////////////////////
	@Test(groups = {BGRRegistration,Refactoring})
	public void inActiveRegistration() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the InactiveAccount less than 5 month-user can successfully Register Via Email,ACCNO,DD,SO");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
		/*new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType0="Email";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType0);
		new AccountOverviewAction()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();*/
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType1="AccNo";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType1)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="SO";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////Sibel Account--SO///////////////////////////////////////
	@Test(groups = {BGRRegistration,Refactoring})
	public void gasRegistrationSSOSibel() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the GasAccount user can successfully Register Via SO-SibelData");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="SO";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	/////////Sibel Account--AccountNumber///////////////////////////////////////
	@Test(groups = {BGRRegistration,Refactoring})
	public void gasRegistrationAccnoSibel() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the GasAccount user can successfully Register Via AccountNO-SibelData");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount1");

		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="AccNo";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}



	////////////Simple Reg CR///////////////////#

	@Test(groups = {BGRRegistration,Refactoring})
	public void dualBGRegistrationViaAccountNo2() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the user can successfully Register Via Accout Number2");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="AccNo2";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}
	@Test(groups = {BGRRegistration,Refactoring})
	public void registrationviaDeepLink() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the user can successfully Register Via Accout Number2");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="AccNo2";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType);
		
	}
	@Test(groups = {BGRRegistration,Refactoring})
	public void registrationReload() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the user can successfully Register Via Accout Number2");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="AccNo2";
		new HomePageAction()
		.navigateToRegistration()
		.yourDetailsReload(userProfile, userProfile.getAccNumber(),registerType);
		
	}
	@Test(groups = {BGRRegistration,Refactoring})
	public void GasBGRegistrationViaAccountNo2() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the user can successfully Register Via Accout Number2");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="AccNo2";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	@Test(groups = {BGRRegistration,Refactoring})
	public void ElecBGRegistrationViaAccountNo2() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the user can successfully Register Via Accout Number2");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="AccNo2";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	@Test(groups = {BGRRegistration,Refactoring})
	public void JIBGRegistrationViaAccountNo2() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the user can successfully Register Via Accout Number2");
		UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="AccNo2";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	@Test(groups = {BGRRegistration,Refactoring})
	public void homeServiceBGRegistrationViaAccountNo2() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the HomeServicesAccount user can successfully Register Via Account Number2");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="AccNo2";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresense(userProfile.getAccNumber())
		.logout();
	}

	//////////////////Services Email Scenarios /////////

	@Test(groups = {BGRRegistration,Refactoring})
	public void homeCare100PaperlessRegistration() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the HomeCare100Account user can successfully Register Via DD,Account Number, SO, CRN by opting paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare100Account");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();  
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType1="AccNo";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType1)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="SO";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType3="AccNo2";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType3)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.logoutlink();    
	}

	@Test(groups = {BGRRegistration,Refactoring})
	public void homeCare300PaperlessRegistration() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the HomeCare300Account user can successfully Register Via DD,Account Number, SO, CRN by opting paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare300Account");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();

		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType1="AccNo";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType1)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="SO";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType3="AccNo2";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType3)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.logoutlink();
	}

	@Test(groups = {BGRRegistration,Refactoring})
	public void homeCare200PaperlessRegistration() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the HomeCare200Account user can successfully Register Via DD,Account Number, SO, CRN by opting paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare200Account");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType1="AccNo";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType1)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="SO";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType3="AccNo2";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType3)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.logoutlink();

	}

	@Test(groups = {BGRRegistration,Refactoring})
	public void homeCare400PaperlessRegistration() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the HomeCare400Account user can successfully Register Via DD,Account Number, SO, CRN by opting paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare400Account");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType1="AccNo";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType1)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="SO";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType3="AccNo2";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType3)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.logoutlink();
	}

	@Test(groups = {BGRRegistration,Refactoring})
	public void KACAccountPaperlessRegistration() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the energyAndServices Account user can successfully Register Via DD,Account Number, SO, CRN by opting paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("KACAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType1="AccNo";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType1)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="SO";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType3="AccNo2";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType3)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.logoutlink();
	}


	@Test(groups = {BGRRegistration,Refactoring})
	public void multipleAccountRegistration() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the HC100,HC200,KAC and HEC Account user can successfully Register Via DD,Account Number, SO, CRN by opting paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC100HC200KACAndHECAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType1="AccNo";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType1)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="SO";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType3="AccNo2";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType3)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.logoutlink();
	}

	@Test(groups = {BGRRegistration,Refactoring})
	public void GACWithL1CertificatePaperlessRegistration() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the GAC with L1 Account user can successfully Register Via DD,Account Number, SO, CRN by opting paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasApplianceCoverWithL1Account");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType1="AccNo";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType1)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="SO";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType3="AccNo2";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType3)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.logoutlink();      
	}

	@Test(groups = {BGRRegistration,Refactoring})
	public void GACKACAndHECAccountRegistration() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Account with GAC KAC And HEC Account user can successfully Register Via DD,Account Number, SO, CRN by opting paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GACKACAndHECAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType1="AccNo";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType1)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="SO";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType3="AccNo2";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType3)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.logoutlink();      
	}


	@Test(groups = {BGRRegistration,Refactoring})
	public void HC200AndHC200FlexiAccountRegistration() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the HC200 And HC200 Flexi Account user can successfully Register Via DD,Account Number, SO, CRN by opting paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC200AndHC200FlexiAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType1="AccNo";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType1)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="SO";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType3="AccNo2";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType3)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.logoutlink();    
	}

	@Test(groups = {BGRRegistration,Refactoring})
	public void HC200AndHC400AccountRegistration() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the HC200 And HC400 Account user can successfully Register Via DD,Account Number, SO, CRN by opting paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC200AndHC400Account");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType1="AccNo";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType1)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="SO";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType3="AccNo2";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType3)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.logoutlink();    
	}

	@Test(groups = {BGRRegistration,Refactoring})
	public void HC100AndHC200AccountPaperlessRegistration() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the HC100 And HC200 Account user can successfully Register via DD,Account Number, SO, CRN by opting paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC100AndHC200Account");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType1="AccNo";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType1)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="SO";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType3="AccNo2";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType3)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.logoutlink();    
	}

	@Test(groups = {BGRRegistration,Refactoring})
	public void HC100FlexiAccountRegistration() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the HC100 Flexi Account user can successfully Register Via DD,Account Number, SO, CRN by opting paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC100FlexiAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType1="AccNo";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType1)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="SO";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType3="AccNo2";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType3)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.logoutlink();   
	}

	@Test(groups = {BGRRegistration,Refactoring})
	public void HC200FlexiAccountRegistration() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the HC200 Flexi Account user can successfully Register Via DD,Account Number, SO, CRN by opting paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC200FlexiAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType1="AccNo";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType1)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="SO";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType3="AccNo2";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType3)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.logoutlink();   
	}

	@Test(groups = {BGRRegistration,Refactoring})
	public void HC300FlexiAccountRegistration() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the HC300 Flexi Account nominee user can successfully Register Via DD,Account Number, SO, CRN by opting paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC300FlexiAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType1="AccNo";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType1)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="SO";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType3="AccNo2";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType3)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.logoutlink();   
	}

	@Test(groups = {BGRRegistration,Refactoring})
	public void HC200FlexiAndHC300FlexiAccountPaperlessRegistration() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the HC200 Flexi And HC300 Flexi With LIG Account user can successfully Register Via DD,Account Number, SO, CRN by opting paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC200FlexiAndHC300FlexiAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType1="AccNo";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType1)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="SO";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType3="AccNo2";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType3)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.logoutlink();   
	}

	@Test(groups = {BGRRegistration,Refactoring})
	public void GasAndHC200AccountRegistration() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the Gas And HC200 Account user can successfully Register Via DD,Account Number, SO, CRN by opting paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAndHC200Account");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType1="AccNo";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType1)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="SO";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType3="AccNo2";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType3)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.logoutlink(); 
	}

	@Test(groups = {BGRRegistration,Refactoring})
	public void HC300HC400AndHC100FlexiPaperlessRegistration() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the HC300 HC400 And HC100Flexi Account user can successfully Register Via DD,Account Number, SO, CRN by opting paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC300HC400AndHC100FlexiAccount");
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType1="AccNo";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType1)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="SO";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType3="AccNo2";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType3)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.logoutlink(); 
	}

	@Test(groups = {BGRRegistration,Refactoring})
	public void SOKACAndHC400FlexiPaperlessRegistration() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the SO,KAC And HC400 Flexi Account user can successfully Register Via DD,Account Number, SO, CRN by opting paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("SOKACAndHC400FlexiAccount");     
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType1="AccNo";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType1)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="SO";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType3="AccNo2";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType3)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.logoutlink(); 
	}

	@Test(groups = {BGRRegistration,Refactoring})
	public void KACHC200HECAccountPaperlessRegistration() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the KAC HC200 And HECAccount user can successfully Register Via DD,Account Number, SO, CRN by opting paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("KACHC200HECAccount");     
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType1="AccNo";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType1)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="SO";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType3="AccNo2";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType3)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.logoutlink(); 
	} 

	@Test(groups = {BGRRegistration,Refactoring})
	public void HC100AndGACAccountPaperlessRegistration() throws Exception {
		Report.createTestLogHeader("Registration", "To Verify whether the HC100 And GAC Account user can successfully Register Via DD,Account Number, SO, CRN by opting paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC100AndGACAccount");     
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType="DD";
		new HomePageAction()
		.navigateToRegistration()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType1="AccNo";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType1)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType2="SO";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType2)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.revertToPaper()
		.logoutlink();
		new OnlineDBConnector().deRegister(userProfile.getUCRN());
		String registerType3="AccNo2";
		new HomePageAction()
		.navigateToRegistrationNew()
		.registerUpdateYourDetailsNew(userProfile, userProfile.getAccNumber(),registerType3)
		.goToYourAccount()
		.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		.verifyAccountPresenseNew(userProfile,userProfile.getAccNumber())
		.logoutlink(); 
	}

/////////////////////////////////////////////////////////TO CHECK EDIT FUNCTION IN YOUR DETAILS PAGE//////////////////////////////////

	
///////////////////////////////////////////////////////December 14th Release//////////////////////////////////////////////////////////////////
	
/////////GAS///////////////////////////////////////
@Test(groups = {BGRRegistration,Refactoring})
public void gasRegistrationNew() throws Exception {
	Report.createTestLogHeader("Registration", "To Verify whether the GasAccount user can successfully Register Via Email,ACCNO,DD,SO");
	UserProfile userProfile = new TestDataHelper().getUserProfile("AnonymousGasAccount");
	new OnlineDBConnector().deRegister(userProfile.getUCRN());
	String registerType="DD";
	new HomePageAction()
	.navigateToRegistration()
	.registerUpdateYourDetailsNew_01(userProfile, userProfile.getAccNumber(),registerType)
	.goToYourAccountnew()
	.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
	//.verifyAccountPresense(userProfile.getAccNumber())
	.logout();
	
}
	
	
	
	
}
