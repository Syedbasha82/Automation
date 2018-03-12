package bg.framework.app.functional.test.selfServe;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.RegistrationPage;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SiebelDataBase;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;

import static bg.framework.app.functional.entities.FunctionalCategory.*;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;

public class RegistrationTest extends TestBase {
	private static final String UNCHECKED = "unchecked";
	SiebelDataBase siebelDataBase = new SiebelDataBase();

	/*Userprofile - AccNumber,UCRN,ElecAccount*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void activeElecLessSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user can successfully Register");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setAccountStatus(userProfile.getElecAccount(), +5);
        siebelDataBase.setBrandBritishGas(userProfile.getElecAccount());
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getElecAccount())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getElecAccount())
                .verifyAccountPresense(userProfile.getElecAccount())
                .logout();
    }
	/*Userprofile - AccNumber,UCRN,ElecAccount*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration}) 
    public void registerContractOwnerAccount() {
        Report.createTestLogHeader("Registration", "To Verify whether the responsibility type with Contract owner can successfully Register");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getElecAccount())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getElecAccount())
                .verifyAccountPresense(userProfile.getElecAccount())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN,ElecAccount*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration})
    public void registerOtherContractOwnerAccount() {
        Report.createTestLogHeader("Registration", "To Verify whether the responsibility type with Other Contract owner can successfully Register");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Other Contract Owner");
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getElecAccount())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getElecAccount())
                .verifyAccountPresense(userProfile.getElecAccount())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN,ElecAccount*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring })
    public void inactiveElecLessSixReg() {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Less than six months Account user can successfully Register");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        siebelDataBase.setAccountStatus(userProfile.getElecAccount(), -5);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getElecAccount())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getElecAccount())
                .verifyAccountPresense(userProfile.getElecAccount())
                .logout();
    }

    /*Userprofile - AccNumber,UCRN,GasAccount*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void inactiveGasSixReg() {
       Report.createTestLogHeader("Registration", "To Verify whether the Gas inactive less than six months Account user can successfully Register");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        //activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        preRegister(userProfile);
        siebelDataBase.setAccountStatus(userProfile.getGasAccount(), -4);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getGasAccount())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getGasAccount())
                .verifyAccountPresense(userProfile.getGasAccount())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN,gasAccount*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration})
    public void activeGasLessSixReg() {
        Report.createTestLogHeader("Registration", "To Verify whether the Gas Only Account user can successfully Register");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        preRegister(userProfile);
        siebelDataBase.setAccountStatus(userProfile.getGasAccount(), +5);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getGasAccount())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getGasAccount())
                .verifyAccountPresense(userProfile.getGasAccount())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN,JIAccount*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void inactiveJILessSixReg() {
    	Report.createTestLogHeader("Registration", "To Verify whether the JI and BGS inactive less than six months Account user can successfully Register");
    	UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
    	//activateCustomerDetailsInOnlineDB(userProfile);
    	getCustomerDetailsToUserProfileAnonymous(userProfile);
    	preRegister(userProfile);
    	new HomePageAction()
		    	.navigateToRegistration()
		    	.registerUpdateYourDetails(userProfile, userProfile.getAccNumber())
		    	.goToYourAccount()
		    	.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
		    	.verifyAccountPresense(userProfile.getAccNumber())
		    	.verifyAccountPresense(userProfile.getBgsAccount())
		    	.logout();
    }
    /*Userprofile - AccNumber,UCRN,gasAccount,elecAccount*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyDualFuelAccReg() {
        Report.createTestLogHeader("Registration", "To verify whether an user can complete a Normal Registration journey for Dual Fuel(Both Gas & Elec Active)"); 
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        //activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        preRegister(userProfile);
        siebelDataBase.setAccountStatus(userProfile.getGasAccount(), +11);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getGasAccount())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getGasAccount())
                .verifyAccountPresense(userProfile.getElecAccount())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyJIAccReg() {
        Report.createTestLogHeader("Registration","To verify whether an user can complete a Normal Registration journey for JI Account");               
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getAccNumber())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
                .verifyAccountPresense(userProfile.getAccNumber())
                .logout();
    } 
    /*Userprofile - AccNumber,UCRN,gasAccount,elecAccount,nectarValue=2*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyDualandBGSAccReg() {
        Report.createTestLogHeader("Registration","To verify whether an user can complete a Normal Registration journey for Dual Fuel with BGS account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getAccNumber())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
                .verifyAccountPresense(userProfile.getAccNumber())
                .verifyAccountPresense(userProfile.getGasAccount())
                .verifyAccountPresense(userProfile.getBgsAccount())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN,gasAccount,nectarValue=1,nectarNumber*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyDualwithJIRegistration() {
        Report.createTestLogHeader("Registration","To verify whether an user can complete a Normal Registration journey for Dual Fuel and JI Account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccountDual");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getAccNumber())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
                .verifyAccountPresense(userProfile.getAccNumber())
                .verifyAccountPresense(userProfile.getGasAccount())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN,gasAccount,nectarValue=2*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring, Refactoring})
    public void inactiveJIwithBGSRegistration() {
        Report.createTestLogHeader("Registration","To verify whether an user can complete a Normal Registration journey for inactive JI account with BGS account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIandBGSAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getAccNumber())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
                .verifyAccountPresense(userProfile.getAccNumber())
                .verifyAccountPresense(userProfile.getBgsAccount())
                .logout();
    }
    
    /*Userprofile - AccNumber,UCRN,gasAccount,nectarValue=2*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring, Refactoring})
    public void inactiveGaswithBGSRegistration() {
        Report.createTestLogHeader("Registration","To verify whether an user can complete a Normal Registration journey for Gas account with BGS account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeSerivcesGasAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getBgsAccount())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getBgsAccount())
                .verifyAccountPresense(userProfile.getGasAccount())
                .verifyAccountPresense(userProfile.getBgsAccount())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN,gasAccount,nectarValue=2*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring, Refactoring})
    public void inactiveElecwithBGSRegistration() {
        Report.createTestLogHeader("Registration","To verify whether an user can complete a Normal Registration journey for Electricity account with BGS account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeSerivcesElecAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getBgsAccount())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getBgsAccount())
                .verifyAccountPresense(userProfile.getElecAccount())
                .verifyAccountPresense(userProfile.getBgsAccount())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN,gasAccount,elecAccount,nectarValue=2*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring, Refactoring})
    public void activeDualSSORegistrtion() {
        Report.createTestLogHeader("Registration","To verify whether an user can complete a Normal Registration journey for Dual Fuel with SSO account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getElecAccount())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getElecAccount())
                .verifyAccountPresense(userProfile.getElecAccount())
                .verifyAccountPresense(userProfile.getGasAccount())
                .logout();
    }
    
    /*Userprofile - AccNumber,UCRN,SSO account*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring, Refactoring})
    public void activeSSORegistration() {
        Report.createTestLogHeader("Registration","To verify whether an user can complete a Normal Registration journey for SSO account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("SSOAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getAccNumber())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
                .verifyAccountPresense(userProfile.getAccNumber())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN,bgsAccount*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyBGSRenewalLessSixReg() {
        Report.createTestLogHeader("Registration","To Verify whether registration can be possible if user is having One BGS account(Renewal status in Contracts(Siebel))");
        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServciesAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getAccNumber(), -5,"Renewal");
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getAccNumber())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
                .verifyAccountPresense(userProfile.getAccNumber())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifybrowserBackFunctionality() {
        Report.createTestLogHeader("Registration","Verify whether the Browser back functionality is working properly in all the pages of the Registration journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .verifyBrowserback(userProfile);

    }
    /*Userprofile - AccNumber,UCRN,bgsAccount,elecAccount*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyElecDomesticAccReg() {
        Report.createTestLogHeader("Registration","Verify that customer is able to do registration journey when Account Type is equal to Domestic");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getElecAccount())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getElecAccount())
                .verifyAccountPresense(userProfile.getElecAccount())
                        //.verifyAccountAbsense(userProfile.getGasAccount())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN,gasAccount*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void activeGasBGSLessSixReg() {
        Report.createTestLogHeader("Registration","Verify whether the thin profile customer is able to do registration journey and verify the status change");
        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeSerivcesGasAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getGasAccount())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getGasAccount())
                .verifyAccountPresense(userProfile.getGasAccount())
                .verifyAccountPresense(userProfile.getBgsAccount())
                .logout();
    }
    /*Accout Type :Auto reg*/
    /*Userprofile - AccNumber,UCRN*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyAutoRegAccount() {
        Report.createTestLogHeader("Registration","Verify whether the Auto reg customer is able to do registration journey ");
        UserProfile userProfile = new TestDataHelper().getUserProfile("AutoRegAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getAccNumber())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
                .verifyAccountPresense(userProfile.getAccNumber())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN,bgsAccount*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring,Refactoring})
    public void verifyBGSAccReg() {
        Report.createTestLogHeader("Registration","Verify that an active BGS home security account customer is able to do registration journey.");
        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServciesAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getAccNumber())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
                .verifyAccountPresense(userProfile.getAccNumber())
                .logout();
    }
    
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring,Refactoring})
    public void InactiveEleclessthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Inactive less then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -5,"Inactive");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration, Regression})
    //Mandatory Fields: 
    //ucrn.
    //ProfileName=JIandBGSAccount
    public void verifyJIBGSAccReg() {
        Report.createTestLogHeader("Registration", "To Verify whether Ji and BGS account user can successfully Register");
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIandBGSAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        preRegister(userProfile);
        new HomePageAction()
	        .navigateToRegistration()
	        .registerUpdateYourDetails(userProfile, userProfile.getAccNumber())
	        .goToYourAccount()
	        .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
	        .verifyAccountPresense(userProfile.getAccNumber())
	        .verifyAccountPresense(userProfile.getBgsAccount())
	        .logout();
    }

    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration, Regression})
    //Mandatory Fields: 
    //ucrn.
    //ProfileName=MixedBrandCustomer
    public void verifyMixedbrandRegistration() {
        Report.createTestLogHeader("Registration", "To Verify whether a user with mixed accounts can successfully Register");
        UserProfile userProfile = new TestDataHelper().getUserProfile("MixedBrandCustomer");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        preRegister(userProfile);
        new HomePageAction()
	        .navigateToRegistration()
	        .registerUpdateYourDetails(userProfile, userProfile.getElecAccount())
	        .goToYourAccount()
	        .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getElecAccount())
	        .verifyAccountPresense(userProfile.getElecAccount())
	        .verifyAccountAbsense(userProfile.getGasAccount())
	        .logout();
    }
    
    /*Userprofile - AccNumber,UCRN,ElecAccount[Smart Meter Account]*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifySmartMeterAccReg() throws Exception {
        Report.createTestLogHeader("Registration", "To verify whether a smart meter customer is able to complete a normal registration journey.");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setAccountStatus(userProfile.getElecAccount(), +5);
        siebelDataBase.setBrandBritishGas(userProfile.getElecAccount());
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getElecAccount())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getElecAccount())
                .verifyAccountPresense(userProfile.getElecAccount())
                .logout();
    }
    
    /*Userprofile - AccNumber,UCRN,Landlord account*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyLandlordandJIAccReg() throws Exception {
        Report.createTestLogHeader("Registration", "To verify whether an user can able to complete a Normal Registration journey for Landlord and JI customer");
        UserProfile userProfile = new TestDataHelper().getUserProfile("LandlordJIAccount");
        //putty.go();
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getAccNumber())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
                .verifyAccountPresense(userProfile.getAccNumber())
                .verifyAccountPresense(userProfile.getBgsAccount())
                .logout();
    }
    
    /*Userprofile - AccNumber,UCRN,Multiple Landlord account*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyMultipleLandlordAccReg() throws Exception {
        Report.createTestLogHeader("Registration", "To verify whether a Multiple Landlord service account customer can able to complete a Normal Registration journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("LandlordAccount");
        //putty.go();
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getAccNumber())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
                .verifyAccountPresense(userProfile.getAccNumber())
                .logout();
    }
    
    /*Userprofile - AccNumber,UCRN,Multiple accounts*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyMultiplePropertiesAccReg() throws Exception {
        Report.createTestLogHeader("Registration", "To verify whether an user having multiple properties account can able to complete a Normal Registration journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("LandlordAccount");
        //putty.go();
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getAccNumber())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
                .verifyAccountPresense(userProfile.getAccNumber())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN,JI account*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyjointCustomersTwoMembershipAccReg() throws Exception {
        Report.createTestLogHeader("Registration", "To verify that for joint customers  two membership(M1 and M2) are created for Customer1(BP1(Gas) and BP2(Electricity))");
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        //putty.go();
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getAccNumber())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
                .verifyAccountPresense(userProfile.getAccNumber())
                .logout();
    }
    
    /*Userprofile - AccNumber,UCRN,JI Victor account*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyJIVictorAccReg() throws Exception {
        Report.createTestLogHeader("Registration", "Verify whether the user is able to do Normal Registration journey with Victor and Victim Account  JI");
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        //putty.go();
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getAccNumber())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
                .verifyAccountPresense(userProfile.getAccNumber())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN,Elec account[Non Uk Billing]*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyNonUKBillingAccReg() throws Exception {
        Report.createTestLogHeader("Registration", "To verify whether the customer with non UK postcode in  billing and UK postcode in correspondance address is able to do registration journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("NonUKAccount");
        //putty.go();
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getAccNumber())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
                .verifyAccountPresense(userProfile.getAccNumber())
                .logout();
    }
    
    /*Userprofile - AccNumber,UCRN,Gas account[Uk Billing]*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyUKAddrandNonUkBillingAddrAccReg() throws Exception {
        Report.createTestLogHeader("Registration", "To verify whether the customer with non UK postcode in correspondance address and UK postcode in billing is able to do registration journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("NonUKAccount");
        //putty.go();
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getAccNumber())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
                .verifyAccountPresense(userProfile.getAccNumber())
                .logout();
    }
    
    /*Userprofile - AccNumber,UCRN,Finally Billed Account*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyFinallyBilledEnergyAccReg() throws Exception {
        Report.createTestLogHeader("Registration", "To verify whether an user can complete a Normal Registration journey  for Finally billed  BG Energy account");
        UserProfile userProfile = new TestDataHelper().getUserProfile("BilledAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getAccNumber(), -5,"Active");
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getAccNumber())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
                .verifyAccountPresense(userProfile.getAccNumber())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN,Victim JI Account*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyVictimJIAccReg() throws Exception {
        Report.createTestLogHeader("Registration", "To verify whether customer using victim account number of JI account with the Status Mark for Deletion trying to do Registration Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        //putty.go();
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getAccNumber())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
                .verifyAccountPresense(userProfile.getAccNumber())
                .logout();
    }
    
    private void preRegister(UserProfile userProfile) {
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
        onlineDBConnector.deRegister(userProfile.getUCRN());
    }
    /*Give missing Acct - AccNumber
    Userprofile - UCRN,elecAccount,gasAccount
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void addMissingAccountScenario() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether Missing accounts are registered");
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setAccountStatus(userProfile.getElecAccount(), +5);
        siebelDataBase.setBrandBritishGas(userProfile.getElecAccount());
        siebelDataBase.setAccountStatus(userProfile.getAccNumber(), +5);
        siebelDataBase.setBrandBritishGas(userProfile.getAccNumber());
        new HomePageAction()
                .navigateToRegistration()
                .registerAccountNum(userProfile)
                .verifyMissingAccount(userProfile)
                .enterRegisterDetails(userProfile)
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getElecAccount())
                .verifyAccountPresense(userProfile.getElecAccount())
                .verifyAccountPresense(userProfile.getAccNumber())
                .logout();
    } 
    */
    
    //********Sprint 06-Pre-Reg Journeys********
    /*Userprofile - AccNumber,UCRN,GasAccount*/
    /* UCRN and Email should present in PO_TA_FT_REG and PO_TA_REG_PROFILE_TEMP tables*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyPreRegFastrackCustomer() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether UCRN and Email deleted after the Gas Only Account Fastrack Pre reg Customer can successfully Register");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        //putty.go();
        preRegister(userProfile);
        RegistrationPage register = new RegistrationPage();
    	register.verifyFastrackRegCustomer(userProfile.getUCRN());
    	register.verifyRegProfileTempCustomer(userProfile.getUCRN());
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getGasAccount())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getGasAccount())
                .verifyAccountPreRegFastrackTable(userProfile)
                .verifyAccountPresense(userProfile.getGasAccount())
                        //.verifyAccountAbsense(userProfile.getGasAccount())
                .logout();
    } 
    
    /*Userprofile - AccNumber,UCRN,GasAccount*/
    /* UCRN  should present in PO_TA_FT_REG and PO_TA_REG_PROFILE_TEMP tables*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyPreRegFastrackCustomerUCRN() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether UCRN deleted after the Gas Only Account Fastrack Pre reg Customer can successfully Register");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        //putty.go();
        preRegister(userProfile);
        RegistrationPage register = new RegistrationPage();
    	register.verifyFastrackRegCustomerUCRN(userProfile.getUCRN());
    	register.verifyRegProfileTempCustomerUCRN(userProfile.getUCRN());
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getGasAccount())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getGasAccount())
                .verifyAccountPreRegFastrackTableUCRN(userProfile)
                .verifyAccountPresense(userProfile.getGasAccount())
                        //.verifyAccountAbsense(userProfile.getGasAccount())
                .logout();
    } 
    
    /*Userprofile - AccNumber,UCRN,GasAccount*/
    /* Email should present in PO_TA_FT_REG and PO_TA_REG_PROFILE_TEMP tables*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyPreRegFastrackCustomerEmail() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether Email ID deleted after the Gas Only Account Fastrack Pre reg Customer can successfully Register");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        //putty.go();
        preRegister(userProfile);
        RegistrationPage register = new RegistrationPage();
    	register.verifyFastrackRegCustomerEmail(userProfile.getEmail());
    	register.verifyRegProfileTempCustomerEmail(userProfile.getEmail());
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getGasAccount())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getGasAccount())
                .verifyAccountPreRegFastrackTableEmail(userProfile)
                .verifyAccountPresense(userProfile.getGasAccount())
                        //.verifyAccountAbsense(userProfile.getGasAccount())
                .logout();
    } 
    /*Userprofile - AccNumber,UCRN,GasAccount*/
    /* UCRN and Email should present in PO_TA_REG_PROFILE_TEMP tables*/
    //UCRN and Email should not present in PO_TA_WTP_REG tables
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyPreRegFastrackWTPCustomer() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether UCRN and Email deleted after the BG Gas WTP Account Fastrack Pre reg Customer can successfully Register");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAndWTPAccount");
        //putty.go();
        preRegister(userProfile);
        RegistrationPage register = new RegistrationPage();
    	register.verifyFastrackRegWTPCustomer(userProfile.getEmail());
    	register.verifyRegProfileTempCustomer(userProfile.getUCRN());
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getGasAccount())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getGasAccount())
                .verifyAccountPreRegFastrackWTPTable(userProfile)
                .verifyAccountPresense(userProfile.getGasAccount())
                        //.verifyAccountAbsense(userProfile.getGasAccount())
                .logout();
    } 
    
    /*Userprofile - AccNumber,UCRN,BG - GasAccount and Elec - SE Account*/
    /* UCRN and Email should present in PO_TA_FT_REG and PO_TA_REG_PROFILE_TEMP tables*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyPreRegFastrackSECustomer() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether UCRN and Email deleted after the BG Gas and SE Electricity Account Fastrack Pre reg Customer can successfully Register");
        UserProfile userProfile = new TestDataHelper().getUserProfile("MixedBrandCustomer");
        //putty.go();
        preRegister(userProfile);
        RegistrationPage register = new RegistrationPage();
    	register.verifyFastrackRegCustomer(userProfile.getUCRN());
    	register.verifyRegProfileTempCustomer(userProfile.getUCRN());
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getGasAccount())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getGasAccount())
                .verifyAccountPreRegFastrackTable(userProfile)
                .verifyAccountPresense(userProfile.getGasAccount())
                .logout();
    } 
    /*Userprofile - AccNumber,UCRN,GasAccount*/
    /* UCRN should present in  PO_TA_REG_PROFILE_TEMP tables*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyPreRegEnergySSOCustomerUCRN() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether UCRN deleted after the BG Gas SSO Account Pre reg Customer can successfully Register");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAndSSOAccount");
        //putty.go();
        preRegister(userProfile);
        RegistrationPage register = new RegistrationPage();
    	register.verifyRegProfileTempCustomer(userProfile.getUCRN());
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getGasAccount())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getGasAccount())
                .verifyAccountPreRegProfileTableUCRN(userProfile)
                .verifyAccountPresense(userProfile.getGasAccount())
                .logout();
    } 
    
    /*Userprofile - AccNumber,UCRN,GasAccount*/
    /*Email should present in  PO_TA_REG_PROFILE_TEMP tables*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyPreRegEnergySSOCustomerEmail() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether Email deleted after the BG Gas SSO Account Pre reg Customer can successfully Register");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAndSSOAccount");
        //putty.go();
        preRegister(userProfile);
        RegistrationPage register = new RegistrationPage();
        register.verifyRegProfileTempCustomerEmail(userProfile.getEmail());
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getGasAccount())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getGasAccount())
                .verifyAccountPreRegProfileTableEmail(userProfile)
                .verifyAccountPresense(userProfile.getGasAccount())
                .logout();
    }
    
    /*Userprofile - AccNumber,UCRN,BGSAccount*/
    /* UCRN and Email should present in ASV_TA_REG_MI and ASV_TA_PRE_REG_TEMP tables*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyPreRegASVCustomerEmail() throws Exception {
        Report.createTestLogHeader("Registration", "To verify the customer is able to complete the Registration successfully when the Email address of the customer is already present in  BGS  Pre-Registration journey table");
        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServciesAccount");
        //putty.go();
        preRegister(userProfile);
        RegistrationPage register = new RegistrationPage();
    	register.verifyPreRegASVCustomerEmail(userProfile.getEmail());
    	register.verifyPreRegASVTempCustomerEmail(userProfile.getEmail());
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getAccNumber())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
                .verifyAccountPreRegASVTableEmail(userProfile)
                .verifyAccountPresense(userProfile.getAccNumber())
                        //.verifyAccountAbsense(userProfile.getGasAccount())
                .logout();
    }
    
    /*Userprofile - AccNumber,UCRN,BGSAccount*/
    /* UCRN and Email should present in ASV_TA_REG_MI and ASV_TA_PRE_REG_TEMP tables*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyPreRegASVCustomerUCRN() throws Exception {
        Report.createTestLogHeader("Registration", "To verify the customer is able to complete the Registration successfully when the UCRN of the customer is already present in  BGS  Pre-Registration journey table");
        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServciesAccount");
        //putty.go();
        preRegister(userProfile);
        RegistrationPage register = new RegistrationPage();
    	register.verifyPreRegASVCustomerEmail(userProfile.getEmail());
    	register.verifyPreRegASVTempCustomerEmail(userProfile.getEmail());
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getAccNumber())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
                .verifyAccountPreRegASVTableEmail(userProfile)
                .verifyAccountPresense(userProfile.getAccNumber())
                        //.verifyAccountAbsense(userProfile.getGasAccount())
                .logout();
    }
    
    /*Userprofile - AccNumber,UCRN,GasAccount*/
    /* UCRN and Email should present in PO_TA_PB_CUSTOMER and PO_TA_REG_PROFILE_TEMP tables*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyPreRegPBCustomerEmail() throws Exception {
        Report.createTestLogHeader("Registration", "To verify the customer is able to complete the Registration successfully when the Email address of the customer is already present in PB Pre-Registration journey table");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        //putty.go();
        preRegister(userProfile);
        RegistrationPage register = new RegistrationPage();
    	register.verifyPreRegPBCustomerEmail(userProfile.getEmail());
    	register.verifyRegProfileTempCustomerEmail(userProfile.getEmail());
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getAccNumber())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
                .verifyAccountPreRegASVTableEmail(userProfile)
                .verifyAccountPresense(userProfile.getAccNumber())
                        //.verifyAccountAbsense(userProfile.getGasAccount())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN,GasAccount*/
    /* UCRN and Email should present in PO_TA_PB_CUSTOMER and PO_TA_REG_PROFILE_TEMP tables*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyPreRegPBCustomerUCRN() throws Exception {
        Report.createTestLogHeader("Registration", "To verify the customer is able to complete the Registration successfully when the UCRN of the customer is already present in PB Pre-Registration journey table");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        //putty.go();
        preRegister(userProfile);
        RegistrationPage register = new RegistrationPage();
    	register.verifyPreRegPBCustomerUCRN(userProfile.getUCRN());
    	register.verifyRegProfileTempCustomerUCRN(userProfile.getUCRN());
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getAccNumber())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
                .verifyAccountPreRegPBTableUCRN(userProfile)
                .verifyAccountPresense(userProfile.getAccNumber())
                        //.verifyAccountAbsense(userProfile.getGasAccount())
                .logout();
    }
    
    //Already Registered Customer Scenarios-Sprint 06
    
    /*Userprofile - AccNumber,UCRN,GasAccount*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration})
    public void verifyAlreadyRegisteredCustomer() throws Exception {
        Report.createTestLogHeader("Registration", "To verify already registered user in  registration journey when user enters an already registered email");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .verifyAlreadyRegisteredCustomer(userProfile)
                .verifyAccountPresense(userProfile.getGasAccount());
    } 
    
    /*Userprofile - AccNumber,UCRN,GasAccount*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration})
    public void verifyAlreadyRegisteredCustomerForgotPwd() throws Exception {
        Report.createTestLogHeader("Registration", "To verify already registered user in  registration journey when user tries to do Forgot Password Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .verifyResetPassword(userProfile)
                .verifyResetPwd(userProfile);
    } 
    /*Userprofile - AccNumber,UCRN,SE -GasAccount*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration})
    public void verifyAlreadySERegisteredCustomer() throws Exception {
        Report.createTestLogHeader("Registration", "To verify Registration journey for Already registered customer in SE and Enter same email id in BG site");
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        siebelDataBase.setBrandSainsbury(userProfile.getGasAccount());
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .verifyAlreadyRegisteredCustomer(userProfile)
                .verifyAccountPresense(userProfile.getAccNumber());
        //Changing the brand again to BG
        siebelDataBase.setBrandBritishGas(userProfile.getGasAccount());
    } 
    
    /*Userprofile - AccNumber,UCRN,BG -GasAccount - SE Site*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration})
    public void verifyAlreadyBGRegisteredCustomerinSE() throws Exception {
        Report.createTestLogHeader("Registration", "To verify Registration journey for Already registered customer in BG and Enter same email id in SE site");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .verifyAlreadyRegisteredCustomer(userProfile)
                .verifyAccountPresense(userProfile.getGasAccount());
    } 
    
    /*Userprofile - AccNumber,UCRN,BG -GasAccount - SE Site*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration})
    public void verifyAlreadyBGWTPRegisteredCustomerinSE() throws Exception {
        Report.createTestLogHeader("Registration", "To verify Registration journey for Already registered customer in BG WTP and Enter same email id in SE site");
        UserProfile userProfile = new TestDataHelper().getUserProfile("WTPAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .verifyAlreadyRegisteredCustomer(userProfile)
                .verifyAccountPresense(userProfile.getGasAccount());
    } 
    
    /*Userprofile - AccNumber,UCRN,SE -SSOAccount*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration})
    public void verifyAlreadySESSORegisteredCustomer() throws Exception {
        Report.createTestLogHeader("Registration", "To verify Registration journey for Already registered customer in SE SSO and Enter same email id in BG site");
        UserProfile userProfile = new TestDataHelper().getUserProfile("SSOAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .verifyAlreadyRegisteredCustomer(userProfile)
                .verifyAccountPresense(userProfile.getAccNumber());
    } 
    
    /*Userprofile - AccNumber,UCRN,SE -ElecAccount*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration})
    public void verifyAlreadyRegisteredBGElecCustomer() throws Exception {
        Report.createTestLogHeader("Registration", "To verify alternate flow for already registered user in  registration journey when user enters an different email address");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .verifyAlreadyRegisteredCustomer(userProfile)
                .verifyAccountPresense(userProfile.getElecAccount()); 
    }
    
    /*Userprofile - AccNumber,UCRN,GasAccount*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration})
    public void verifyAlreadyRegisteredBGAutoRegCustomer() throws Exception {
        Report.createTestLogHeader("Registration", "To verify alternate flow for already registered Auto Reg user in  registration journey when user enters an different email address");
        UserProfile userProfile = new TestDataHelper().getUserProfile("AutoRegAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .verifyAlreadyRegisteredCustomer(userProfile)
                .verifyAccountPresense(userProfile.getAccNumber()); 
    }
    /*Userprofile - AccNumber,UCRN,ElecAccount*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration}) 
    public void registerEditEmailElecAccount() {
        Report.createTestLogHeader("Registration", "To Verify whether Electricity customer can Edit Email option for Registration");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .enterEditEmailId(userProfile)
                .registerUpdateYourDetails(userProfile, userProfile.getElecAccount())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getElecAccount())
                .verifyAccountPresense(userProfile.getElecAccount())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN,GasAccount*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration}) 
    public void registerEditEmailGasAccount() {
        Report.createTestLogHeader("Registration", "To Verify whether Gas customer can Edit Email option for Registration");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .enterEditEmailId(userProfile)
                .registerUpdateYourDetails(userProfile, userProfile.getGasAccount())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getGasAccount())
                .verifyAccountPresense(userProfile.getGasAccount())
                .logout();
    }
    
    /*Userprofile - AccNumber,UCRN,Accountnumber*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration}) 
    public void registerEditEmailJIAccount() {
        Report.createTestLogHeader("Registration", "To Verify whether JI customer can Edit Email option for Registration");
        UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .enterEditEmailId(userProfile)
                .registerUpdateYourDetails(userProfile, userProfile.getAccNumber())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
                .verifyAccountPresense(userProfile.getAccNumber())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN,Accountnumber*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration}) 
    public void registerEditEmailDualAccount() {
        Report.createTestLogHeader("Registration", "To Verify whether DUAL customer can Edit Email option for Registration");
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .enterEditEmailId(userProfile)
                .registerUpdateYourDetails(userProfile, userProfile.getAccNumber())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
                .verifyAccountPresense(userProfile.getAccNumber())
                .logout();
    }
    
    /*Userprofile - AccNumber,UCRN,bgsAccount*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration}) 
    public void registerEditEmailBgsAccount() {
        Report.createTestLogHeader("Registration", "To Verify whether BGS customer can Edit Email option for Registration");
        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServciesAccount");
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .enterEditEmailId(userProfile)
                .registerUpdateYourDetails(userProfile, userProfile.getAccNumber())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
                .verifyAccountPresense(userProfile.getAccNumber())
                .logout();
    }
    
    //Sprint 01 - Forgot Password
    
    /*Userprofile - AccNumber,UCRN,GasAccount*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration})
    public void verifyAlreadyRegisteredCustomerdiffEmailForgotPwd() throws Exception {
        Report.createTestLogHeader("Registration", "To verify already registered user in  registration journey when user tries to enter different email address to do Forgot Password Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");        
        getCustomerDetailsToUserProfileOAM(userProfile);
        userProfile.setEmail("ssrvbg_test12@bg.co.uk");
        new HomePageAction()
                .navigateToRegistration()
                .registerYourDetails(userProfile, userProfile.getAccNumber())
                .verifyResetPassword(userProfile)
                .verifyResetPwd(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,GasAccount*/
    @SuppressWarnings(UNCHECKED)
    @Test(groups = {BGRRegistration})
    public void verifyAlreadyRegisteredSECustomerEmailForgotPwd() throws Exception {
        Report.createTestLogHeader("Registration", "To verify already registered SE user in  registration journey when user tries to enter different email address to do Forgot Password Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");        
        getCustomerDetailsToUserProfileOAM(userProfile);
        userProfile.setEmail("ssrvse_test12@bg.co.uk");
        new HomePageAction()
                .navigateToRegistration()
                .registerYourDetails(userProfile, userProfile.getAccNumber())
                .verifyResetPassword(userProfile)
                .verifyResetPwd(userProfile);
    }
    
}
