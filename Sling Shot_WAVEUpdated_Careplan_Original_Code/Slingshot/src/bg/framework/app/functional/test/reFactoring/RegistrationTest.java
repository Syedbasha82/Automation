package bg.framework.app.functional.test.reFactoring;

import java.util.ArrayList;


import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.*;

import org.testng.annotations.Test;
import static bg.framework.app.functional.entities.FunctionalCategory.BGRRegistration;
import static bg.framework.app.functional.entities.FunctionalCategory.Refactoring;
import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;


public class RegistrationTest extends TestBase {
    Tunnel putty = new Tunnel();
    SiebelDataBase siebelDataBase = new SiebelDataBase();

    /*Userprofile - AccNumber,UCRN,ElecAccount*/
	@SuppressWarnings("unchecked")
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
                        //.verifyAccountAbsense(userProfile.getGasAccount())
                .logout();
    }
	/*Userprofile - AccNumber,UCRN,ElecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring}) 
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
                        //.verifyAccountAbsense(userProfile.getGasAccount())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN,ElecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
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
                        //.verifyAccountAbsense(userProfile.getGasAccount())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN,ElecAccount*/
    @SuppressWarnings("unchecked")
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
                        //.verifyAccountAbsense(userProfile.getGasAccount())
                .logout();
    }

    /*Userprofile - AccNumber,UCRN,ElecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void inactiveElecGreaterSixReg() {
       Report.createTestLogHeader("Registration", "To Verify whether the Electricity inactive greater than six months Account user can successfully Register");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        preRegister(userProfile);
        siebelDataBase.setAccountStatus(userProfile.getElecAccount(), -11);
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
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Smoke})
    public void activeGasLessSixReg() {
        Report.createTestLogHeader("Registration", "To Verify whether the Gas Only Account user can successfully Register");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        preRegister(userProfile);
        siebelDataBase.setAccountStatus(userProfile.getGasAccount(), +5);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getGasAccount())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getGasAccount())
                .verifyAccountPresense(userProfile.getGasAccount())
                        //.verifyAccountAbsense(userProfile.getGasAccount())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN,gasAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void inactiveGasLessSixReg() {
    	Report.createTestLogHeader("Registration", "To Verify whether the Gas active less than six months Account user can successfully Register with nectar not at the moments options.");
    	UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
    	//activateCustomerDetailsInOnlineDB(userProfile);
    	getCustomerDetailsToUserProfileAnonymous(userProfile);
    	preRegister(userProfile);

    	siebelDataBase.setAccountStatus(userProfile.getGasAccount(),-3);
    	new HomePageAction()
		    	.navigateToRegistration()
		    	.registerUpdateYourDetails(userProfile, userProfile.getGasAccount())
		    	.goToYourAccount()
		    	.verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getGasAccount())
		    	.verifyAccountPresense(userProfile.getElecAccount())
		    			//.verifyAccountAbsense(userProfile.getGasAccount())
		    	.logout();
    }
    /*Userprofile - AccNumber,UCRN,gasAccount,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void existingNectarCard() {
        Report.createTestLogHeader("Registration", "To verify whether an user can complete a Normal Registration journey for Dual Fuel(Both Gas & Elec Active)."); 
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
                        //.verifyAccountAbsense(userProfile.getGasAccount())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void addNectarLater() {
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
                        //.verifyAccountAbsense(userProfile.getGasAccount())
                .logout();
    } 
    /*Userprofile - AccNumber,UCRN,gasAccount,elecAccount,nectarValue=2*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring, Refactoring})
    public void newNectarCard() {
        Report.createTestLogHeader("Registration","To verify whether an user can complete a Normal Registration journey for Dual Fuelloyalty option I'd like to get a Nectar cardloyalty option I'd like to get a Nectar card");
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
                        //.verifyAccountAbsense(userProfile.getGasAccount())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN,gasAccount,nectarValue=1,nectarNumber*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring, Refactoring})
    public void dualwithJIRegistration() {
        Report.createTestLogHeader("Registration","To verify whether an user can complete a Normal Registration journey for Dual Fuel loyalty option I have a Nectar card");
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
                        //.verifyAccountAbsense(userProfile.getGasAccount())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN,gasAccount,nectarValue=2*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring, Refactoring})
    public void inactiveJIwithBGSRegistration() {
        Report.createTestLogHeader("Registration","To verify whether an user can complete a Normal Registration journey for inactive JI account with loyalty get me a card option");
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
                        //.verifyAccountAbsense(userProfile.getGasAccount())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN,gasAccount,elecAccount,nectarValue=2*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring, Refactoring})
    public void activeDualSSORegistrtion() {
        Report.createTestLogHeader("Registration","To verify whether an user can complete a Normal Registration journey for 'Dual Fuel + 1 SSO accounts with add my nectar card");
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
                        //.verifyAccountAbsense(userProfile.getGasAccount())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN,bgsAccount,nectarValue=2*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring,Refactoring})
    public void BGSLessSixReg() {
        Report.createTestLogHeader("Registration","To Verify whether registration can be possible if user is having One BGS account");
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
                        //.verifyAccountAbsense(userProfile.getGasAccount())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring,Refactoring})
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
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring, Refactoring})
    public void inactiveElecBGSGreaterSixReg() {
        Report.createTestLogHeader("Registration","Verify that customer is able to do registration journey when Account Type is equal to Domestic");
        UserProfile userProfile = new TestDataHelper().getUserProfile("BGSElecAccount");
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
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring,Refactoring})
    public void activeGasBGSLessSixReg() {
        Report.createTestLogHeader("Registration","Verify whether the thin profile customer is able to do registration journey and verify the status change ");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getGasAccount())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getGasAccount())
                .verifyAccountPresense(userProfile.getGasAccount())
                        //.verifyAccountAbsense(userProfile.getGasAccount())
                .logout();
    }
    /*Accout Type :Fast track pre reg*/
    /*Userprofile - AccNumber,UCRN,gasAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring,Refactoring})
    public void SixReg() {
        Report.createTestLogHeader("Registration","Verify whether the Fast track pre reg customer is able to do registration journey ");
        UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getGasAccount())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getGasAccount())
                .verifyAccountPresense(userProfile.getGasAccount())
                        //.verifyAccountAbsense(userProfile.getGasAccount())
                .logout();
    }
    /*Userprofile - AccNumber,UCRN,bgsAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring,Refactoring})
    public void inactiveGasBGSGreaterSixReg() {
        Report.createTestLogHeader("Registration","Verify that an active BGS home security account customer is able to do registration journey.");
        UserProfile userProfile = new TestDataHelper().getUserProfile("HomeSerivcesAccount");
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .registerUpdateYourDetails(userProfile, userProfile.getAccNumber())
                .goToYourAccount()
                .verifyRegisteredUser(userProfile,userProfile.getLastName(), userProfile.getAccNumber())
                .verifyAccountPresense(userProfile.getAccNumber())
                        //.verifyAccountAbsense(userProfile.getGasAccount())
                .logout();
        
    }
    
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring, Refactoring})
    public void useExistingNectarBGS() {
        Report.createTestLogHeader("Registration","Verify that a Customer with BG - Account and WTP account with WTP email id ");
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
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
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
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring,Refactoring})
    public void RenewalEleclessthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Renewal less then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        siebelDataBase.setStatus(userProfile.getElecAccount(), -5,"Renewal");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring,Refactoring})
    public void DeletedEleclessthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Deleted less then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        siebelDataBase.setStatus(userProfile.getElecAccount(), -5,"Deleted");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring,Refactoring})
    public void FinalisedEleclessthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Finalised less then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        siebelDataBase.setStatus(userProfile.getElecAccount(), -5,"Finalised");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring,Refactoring})
    public void FinalledEleclessthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Finalled less then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        siebelDataBase.setStatus(userProfile.getElecAccount(), -5,"Finalled");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring,Refactoring})
    public void CancelledEleclessthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Cancelled less then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        siebelDataBase.setStatus(userProfile.getElecAccount(), -5,"Cancelled");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring,Refactoring})
    public void LapsedEleclessthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Lapsed less then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        siebelDataBase.setStatus(userProfile.getElecAccount(), -5,"Lapsed");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring,Refactoring})
    public void DemandEleclessthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with On Demand less then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        siebelDataBase.setStatus(userProfile.getElecAccount(), -5,"On Demand");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring,Refactoring})
    public void ProspectEleclessthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Prospect less then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        siebelDataBase.setStatus(userProfile.getElecAccount(), -5,"Prospect");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void WithdrawingEleclessthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Withdrawing less then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        siebelDataBase.setStatus(userProfile.getElecAccount(), -5,"Withdrawing");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void liveEleclessthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Live less then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        siebelDataBase.setStatus(userProfile.getElecAccount(), -5,"Live");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void provisionalEleclessthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Provisional less then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        siebelDataBase.setStatus(userProfile.getElecAccount(), -5,"Provisional");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void PendingTonnEleclessthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Pending Tonn less then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        siebelDataBase.setStatus(userProfile.getElecAccount(), -5,"Pending Tonn");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void provisionalMoveinCompleteEleclessthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Provisional Move in Complete less then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        siebelDataBase.setStatus(userProfile.getElecAccount(), -5,"Provisional Move in Complete");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void provisionalMoveinFailedEleclessthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Provisional Move in Failed less then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        siebelDataBase.setStatus(userProfile.getElecAccount(), -5,"Provisional Move in Failed");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void provisionalMoveinPendingEleclessthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Provisional Move in Pending less then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        siebelDataBase.setStatus(userProfile.getElecAccount(), -5,"Provisional Move in Pending");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void pendingTransferEleclessthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Pending Transfer less then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        siebelDataBase.setStatus(userProfile.getElecAccount(), -5,"Pending Transfer");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void pendingFinalEleclessthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Pending Final less then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        siebelDataBase.setStatus(userProfile.getElecAccount(), -5,"Pending Final");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void voidEleclessthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Void less then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        siebelDataBase.setStatus(userProfile.getElecAccount(), -5,"Void");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void errorFinalEleclessthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Error Final less then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        siebelDataBase.setStatus(userProfile.getElecAccount(), -5,"Error Final");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void markfordeletionEleclessthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Mark for deletion less then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        siebelDataBase.setStatus(userProfile.getElecAccount(), -5,"Mark for deletion");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void pendingWithdrawalEleclessthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Pending Withdrawal less then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        siebelDataBase.setStatus(userProfile.getElecAccount(), -5,"Pending Withdrawal");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void withdrawingLetterPendingEleclessthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Withdrawing - Letter Pending less then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        siebelDataBase.setStatus(userProfile.getElecAccount(), -5,"Withdrawing - Letter Pending");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void closedEleclessthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Closed less then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        siebelDataBase.setStatus(userProfile.getElecAccount(), -5,"Closed");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void creditHoldEleclessthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Credit Hold less then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        siebelDataBase.setStatus(userProfile.getElecAccount(), -5,"Credit Hold");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void suspendedEleclessthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Suspended less then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        siebelDataBase.setStatus(userProfile.getElecAccount(), -5,"Suspended");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void waitingEleclessthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Waiting less then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setResponsibilityType(userProfile.getElecAccount(),"Contract Owner");
        siebelDataBase.setStatus(userProfile.getElecAccount(), -5,"Waiting");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void InactiveElecgreaterthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Inactive greater then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -11,"Inactive");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void RenewalElecgreaterthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Renewal greater then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -11,"Renewal");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void DeletedElecgreaterthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Deleted greater then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -11,"Deleted");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void FinalisedElecgreaterthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Finalised greater then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -11,"Finalised");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void FinalledElecgreaterthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Finalled greater then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -11,"Finalled");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void CancelledElecgreaterthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Cancelled greater then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -11,"Cancelled");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void LapsedElecgreaterthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Lapsed greater then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -11,"Lapsed");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void DemandElecgreaterthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with On Demand greater then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -11,"On Demand");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void ProspectElecgreaterthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Prospect greater then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -11,"Prospect");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void WithdrawingElecgreaterthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Withdrawing greater then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -11,"Withdrawing");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void liveElecgreaterthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Live greater then 6 months greater then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -11,"Live");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void provisionalElecgreaterthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Provisional greater then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -11,"Provisional");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void PendingTonnElecgreaterthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Pending Tonn greater then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -11,"Pending Tonn");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void provisionalMoveinCompleteElecgreaterthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Provisional Move in Complete greater then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -11,"Provisional Move in Complete");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void provisionalMoveinFailedElecgreaterthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Provisional Move in Failed greater then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -11,"Provisional Move in Failed");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void provisionalMoveinPendingElecgreaterthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Provisional Move in Pending greater then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -11,"Provisional Move in Pending");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void pendingTransferElecgreaterthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Pending Transfer greater then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -11,"Pending Transfer");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void pendingFinalElecgreaterthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Pending Final greater then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -11,"Pending Final");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void voidElecgreaterthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Void greater then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -11,"Void");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void errorFinalElecgreaterthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Error Final greater then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -11,"Error Final");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void markfordeletionElecgreaterthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Mark for deletion greater then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -11,"Mark for deletion");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void pendingWithdrawalElecgreaterthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Pending Withdrawal greater then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -11,"Pending Withdrawal");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void withdrawingLetterPendingElecgreaterthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Withdrawing - Letter Pending greater then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -11,"Withdrawing - Letter Pending");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void closedElecgreaterthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Closed greater then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -11,"Closed");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void creditHoldElecgreaterthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Credit Hold greater then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -11,"Credit Hold");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void suspendedElecgreaterthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Suspended greater then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -11,"Suspended");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void waitingElecgreaterthanSixReg() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Waiting greater then 6 months status");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setStatus(userProfile.getElecAccount(), -11,"Waiting");
        new HomePageAction()
                .navigateToRegistration()
                .registerInvalidAccountNum(userProfile);
    }
    /*Give missing Acct - AccNumber*/
    /*Userprofile - UCRN,elecAccount,gasAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void addMissingAccountScenario() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether Missing accounts are registered");
        UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
        //putty.go();
        preRegister(userProfile);
        siebelDataBase.setAccountStatus(userProfile.getElecAccount(), +5);
        siebelDataBase.setAccountStatus(userProfile.getGasAccount(), +5);
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

    private void preRegister(UserProfile userProfile) {
        activateCustomerDetailsInOnlineDB(userProfile);
        getCustomerDetailsToUserProfileAnonymous(userProfile);
        OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
        onlineDBConnector.deRegister(userProfile.getUCRN());
    }
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void verifyErrorMessage() {
		 Report.createTestLogHeader("Registration", "Error Message Validation");
		 UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		 ArrayList<String> errList= new HomePageAction().navigateToCQ5();
		 
		 new HomePageAction().navigateToRegistration()
		 .verifyAccountNumErrorMsg(userProfile,errList);
		 /*.verifyFirstNameErrorMsg(userProfile)
		 .verifyLastNameErrorMsg(userProfile)
		 .registerAccountNum(userProfile)
		 .verifyEmailAddressErrorMsg(userProfile)
		 .verifyPasswordErrorMsg(userProfile)
		 .verifySecurityErrorMsg(userProfile)
		 .verifyContactDetailsErrorMsg(userProfile)
		 .verifyNectarCardErrorMsg(userProfile)
		 .verifyAcceptTermsErrorMsg(userProfile);*/
	}
    /*Userprofile - AccNumber,UCRN,elecAccount*/
    @SuppressWarnings("unchecked")
    @Test(groups = {BGRRegistration,Refactoring})
    public void activeelecprepayment() throws Exception {
        Report.createTestLogHeader("Registration", "To Verify whether the Electricity Only Account user with Prepayment Type is not able to register");
        UserProfile userProfile = new TestDataHelper().getUserProfile("PrePayment");
        //putty.go();
        preRegister(userProfile);
        new HomePageAction()
                .navigateToRegistration()
                .registerPrepaymentAccountNum(userProfile);
    }
}



