package bg.framework.app.functional.test.selfServe;

import org.testng.annotations.Test;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.selfServe.HomeMoveAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import bg.framework.app.functional.entities.HomeMove;

import static bg.framework.app.functional.entities.FunctionalCategory.HomeMove;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import static bg.framework.app.functional.entities.FunctionalCategory.OnHold;
import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;
import static bg.framework.app.functional.entities.FunctionalCategory.*;
public class HomeMoveTest extends TestBase{
	
	//------------------------------------------------MOVEIN------------------------------------------------------//
	
	/*
     *  Mandatory field in UserProfile: UCRN and Account Number
     *  
     *  Performs HomeMovein journey for Gas Customer 
     */
	@Test(groups = {HomeMove}) 
    public void preMoveOAMGasCustomerMoveInBundleDD() {
		Report.createTestLogHeader("PreMove_OAMGAS_MoveInBundle_DirectDebit", "GasAccount");
		int preMoveInDate=28;	
		int numberOfPrevAddress=1;
		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveTestData");    
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		new HomePageAction()
        		.navigateToLogin()
        		.login(userProfile)
        		.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
        		.navigateToAccountSummaryPage(userProfile)
        		.navigateToMovingHome("Existing")
        		.navigateToMovingInOnly()
        		.selectProductsMovingInBundle()
        		.enterMovingInDetails(homeMove,preMoveInDate)
        		.selectMoveInAddress(homeMove)
        		.enterPreviousAddressHistory(homeMove)
        		.selectNumberPreviousAddresses(homeMove,numberOfPrevAddress)
        		.selectPaymentTypeDirectDebit()
        		.enterBankDetailsForPayment(homeMove)
        		.navigateToConfirmationPage()
        		.logoutHomeMove();
        		
	}
	
	
	
	/*
     *  Mandatory field in UserProfile: UCRN and Account Number
     *   
     *  Performs HomeMovein journey for Electricity Customer 
     */
	@Test(groups = {HomeMove}) 
    public void preMoveOAMElectricityCustomerMoveInBundleDD() {
		Report.createTestLogHeader("PreMove_OAMElectricity_MoveInBundle_DirectDebit", "ElectricityAccount");
		int preMoveInDate=28;	
		int numberOfPrevAddress=1;
		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveTestData");    
		UserProfile userProfile=new TestDataHelper().getUserProfile("ElectricityAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		String sysdate=new OnlineDBConnector().DBsysdate();
		new HomePageAction()
        		.navigateToLogin()
        		.login(userProfile)
        		.verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
        		.navigateToAccountSummaryPage(userProfile)
        		.navigateToMovingHome("Existing")
        		.navigateToMovingInOnly()
        		.selectProductsMovingInBundle()
        		.enterMovingInDetails(homeMove,preMoveInDate)
        		.selectMoveInAddress(homeMove)
        		.enterPreviousAddressHistory(homeMove)
        		.selectNumberPreviousAddresses(homeMove,numberOfPrevAddress)
        		.selectPaymentTypeDirectDebit()
        		.enterBankDetailsForPayment(homeMove)
        		.navigateToConfirmationPage()
        		.logoutHomeMove()
        		.runBatch(sysdate,"moveIn",userProfile);
	}
	
	/*
     *  Mandatory field in UserProfile: UCRN and Account Number
     *  
     *  Performs HomeMovein journey for JI Customer 
     */
	@Test(groups = {HomeMove}) 
    public void preMoveOAMJICustomerMoveInBundleDD() {
		Report.createTestLogHeader("PreMove_OAMJI_MoveInBundle_DirectDebit", "JIAccount");
		int preMoveInDate=28;	
		int numberOfPrevAddress=1;
		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveTestData");    
		UserProfile userProfile=new TestDataHelper().getUserProfile("JIAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
        		.navigateToLogin()
        		.login(userProfile)
        		.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
        		.navigateToAccountSummaryPage(userProfile)
        		.navigateToMovingHome("Existing")
        		.navigateToMovingInOnly()
        		.selectProductsMovingInBundle()
        		.enterMovingInDetails(homeMove,preMoveInDate)
        		.selectMoveInAddress(homeMove)
        		.enterPreviousAddressHistory(homeMove)
        		.selectNumberPreviousAddresses(homeMove,numberOfPrevAddress)
        		.selectPaymentTypeDirectDebit()
        		.enterBankDetailsForPayment(homeMove)
        		.navigateToConfirmationPage()
        		.logoutHomeMove();
	}
	
	/*
     *  Mandatory field in UserProfile: UCRN and Account Number
     *  
     *  Performs HomeMovein journey for Dual Customer 
     */
	@Test(groups = {HomeMove}) 
    public void preMoveOAMDualCustomerMoveInBundleDD() {
		Report.createTestLogHeader("PreMove_OAMDual_MoveInBundle_DirectDebit", "DualAccount");
		int preMoveInDate=28;	
		int numberOfPrevAddress=1;
		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveTestData");    
		UserProfile userProfile=new TestDataHelper().getUserProfile("DualAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
        		.navigateToLogin()
        		.login(userProfile)
        		.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
        		.navigateToAccountSummaryPage(userProfile)
        		.navigateToMovingHome("Existing")
        		.navigateToMovingInOnly()
        		.selectProductsMovingInBundle()
        		.enterMovingInDetails(homeMove,preMoveInDate)
        		.selectMoveInAddress(homeMove)
        		.enterPreviousAddressHistory(homeMove)
        		.selectNumberPreviousAddresses(homeMove,numberOfPrevAddress)
        		.selectPaymentTypeDirectDebit()
        		.enterBankDetailsForPayment(homeMove)
        		.navigateToConfirmationPage()
        		.logoutHomeMove();
	}
	
	/*
     *  Mandatory field in UserProfile: UCRN and Account Number
     *  
     *  Performs HomeMovein journey for BGS Customer 
     */
	
	@Test(groups = {HomeMove}) 
    public void preMoveOAMBGSCustomerMoveInBundleDD() {
		Report.createTestLogHeader("PreMove_OAMBGS_MoveInBundle_DirectDebit", "BGSAccount");
		int preMoveInDate=28;	
		int numberOfPrevAddress=1;
		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveTestData");    
		UserProfile userProfile=new TestDataHelper().getUserProfile("HomeServicesAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
        		.navigateToLogin()
        		.login(userProfile)
        		.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
        		.navigateToAccountSummaryPage(userProfile)
        		.navigateToMovingHome("Existing")
        		.navigateToMovingInOnly()
        		.selectProductsMovingInBundle()
        		.enterMovingInDetails(homeMove,preMoveInDate)
        		.selectMoveInAddress(homeMove)
        		.enterPreviousAddressHistory(homeMove)
        		.selectNumberPreviousAddresses(homeMove,numberOfPrevAddress)
        		.selectPaymentTypeDirectDebit()
        		.enterBankDetailsForPayment(homeMove)
        		.navigateToConfirmationPage()
        		.logoutHomeMove();
	}
	/*
     *  Mandatory field in UserProfile: UCRN and Account Number
     *  
     *  Performs HomeMovein journey for Gas Customer with different payment option 
     */
	@Test(groups = {HomeMove})
    public void moveInBundleDifferentPaymentForGasElecHomeService() {
		Report.createTestLogHeader("PostMove_OAMGas_MoveInBundle_DifferentPayment", "GasAccount");
		int postMoveInDate=-29;	
		int numberOfPrevAddress=3;
		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveTestData");
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
        		.navigateToLogin()
        		.login(userProfile)
        		.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
        		.navigateToAccountSummaryPage(userProfile)
        		.navigateToMovingHome("Existing")
        		.navigateToMovingInOnly()
        		.selectProductsMovingInBundle()
        		.enterMovingInDetails(homeMove,postMoveInDate)
        		.homeMoveaddressNotListed(homeMove)
        		.enterPreviousAddressHistory(homeMove)
        		.previousAddressNotListed(homeMove,numberOfPrevAddress)						
        		.enterMeterReadingForPostMoveCustomer(homeMove)
        		.selectPaymentTypeDifferentPayment()
        		.paymentOptionsForGasElectricityAndHomeservices()
        		.enterBankDetailsForPayment(homeMove)
        		.enterAnnualCreditCardDetails(homeMove)
        		.navigateToConfirmationPage()
        		.logoutHomeMove();
	}
	/*
     *  Mandatory field in UserProfile: UCRN and Account Number
     *  Performs move in by creating bundle and using different payment option
     */
	@Test(groups = {HomeMove})
    public void moveInOwnBundleDifferentPaymentForDualAndHomeServices(){
		Report.createTestLogHeader("CreatingOwnBundle_OAMGas_DifferentPayment", "GasAccount");
		int postMoveInDate=-5;	
		int numberOfPrevAddress=3;
		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveTestData");
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
        		.navigateToLogin()
        		.login(userProfile)
        		.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
        		.navigateToAccountSummaryPage(userProfile)
        		.navigateToMovingHome("Existing")
        		.navigateToMovingInOnly()
        		.selectProductsCreateBundle()
        		.enterMovingInDetails(homeMove,postMoveInDate)
        		.selectMoveInAddressWithDifferentBillAddress(homeMove)
        		.sendBillToAntherAddress(homeMove)
        		.enterPreviousAddressHistory(homeMove)
        		.selectNumberPreviousAddresses(homeMove,numberOfPrevAddress)
        		.enterMeterReadingForPostMoveCustomer(homeMove)
        		.selectPaymentTypeDifferentPayment()
        		.paymentOptionsForDualAndHomeServices()
        		.enterBankDetailsForPayment(homeMove)
        		.navigateToConfirmationPage()
        		.logoutHomeMove();
	}
	/*
     *  Mandatory field in UserProfile: UCRN and Account Number
     *  Performs Error validation for Bank Details
     */
	@Test(groups = {Regression,HomeMove})
	public void errorValidationForBankDetails(){
	
		Report.createTestLogHeader("ErrorValidationForBankDetails", "GasAccount");
	
		int preMoveInDate=30;
		int postMoveInDate=-35;
		int moveInDate=5;
		int numberOfPrevAddress=1;
		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveTestData");
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
				.navigateToAccountSummaryPage(userProfile)
				.navigateToMovingHome("Existing")
				.navigateToMovingInOnly()
				.selectProductsMovingInBundle()
				.enterMovingInDetails(homeMove,preMoveInDate)
				.errorMessageForMoveInDateOutOfLimit()
				.enterMovingInDetails(homeMove,postMoveInDate)
				.errorMessageForMoveInDateOutOfLimit()
				.enterMovingInDetails(homeMove,moveInDate)
				.selectMoveInAddress(homeMove)
				.enterPreviousAddressHistory(homeMove)
				.selectNumberPreviousAddresses(homeMove,numberOfPrevAddress)
				.selectPaymentTypeDirectDebit()
				.bankAccountDetailsErrorValidation()
				.navigateToConfirmationPage()
				.logoutHomeMove();
	}
	/*
     *  Mandatory fields in HomeMove.xml: All valid customer's personal details for which a match should be found in siebel.
     *  Performs MoveIn for Anonymous Customer.
     */
    @Test(groups = {HomeMove})
    public void preMoveAnonymousCustomerBundleDD(){
    	Report.createTestLogHeader("preMove_AnonymousCustomer_Bundle_DD", "Anonymous customer");
    	int preMoveInDate=28;	
		int numberOfPrevAddress=1;
    	final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveTestData");
		new HomePageAction()
				.navigateToLogout();
    	new HomeMoveAction()
    			.navigateToMovingInForAnonymousCustomer()
    			.navigateToStartMovingHomeForAnonymous()
    			.enterPersonalDetailsForAnonymousCustomer(homeMove)
    			.navigateToMovingInOnly()
    			.selectProductsMovingInBundle()						
    			.enterMovingInDetails(homeMove,preMoveInDate)
    			.homeMoveaddressNotListed(homeMove)
    			.enterPreviousAddressHistory(homeMove)
    			.previousAddressNotListed(homeMove,numberOfPrevAddress)
    			.selectDirectDebitAndunselectPaperLessBilling()
    			.enterBankDetailsForPayment(homeMove)
    			.navigateToConfirmationPage()
    			.navigateToHome();
    }
    /*
     *  Mandatory fields in HomeMove.xml: All valid customer's personal details for which a match is found in siebel.
     *  Performs MoveIn for Anonymous Customer using Different Payment
     */
    @Test(groups = {HomeMove})
    public void preMoveAnonymousCustomerUsingDifferentPayment(){ 
    	Report.createTestLogHeader("preMove_AnonymousCustomer_Bundle_DifferentPayment", "Anonymous customer");
    	int preMoveInDate=27;	
		int numberOfPrevAddress=2;
    	final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveTestData");
		new HomePageAction()
				.navigateToLogout();
    	new HomeMoveAction()
    			.navigateToMovingInForAnonymousCustomer()
    			.navigateToStartMovingHomeForAnonymous()
    			.enterPersonalDetailsForAnonymousCustomer(homeMove)
    			.enterMoveOutDetails(homeMove,preMoveInDate)
    			.navigateToMovingInOnly()
    			.unselectContactExistingSuppliers()
    			.selectProductsMovingInBundle()					
    			.enterMovingInDetails(homeMove,preMoveInDate)
    			.selectMoveInAddressWithDifferentBillAddress(homeMove)
    			.sendBillToAntherAddress(homeMove)
    			.enterPreviousAddressHistory(homeMove)
    			.previousAddressNotListed(homeMove,numberOfPrevAddress)
    			.selectPaymentTypeDifferentPayment()
    			.paymentOptionsForGasElectricityAndHomeservices()
    			.enterBankDetailsForPayment(homeMove)
    			.enterAnnualCreditCardDetails(homeMove)
    			.navigateToConfirmationPage()
    			.navigateToHome();
    }
    /*
     *  Mandatory fields in HomeMove.xml: All valid customer's personal details for which a match is found in siebel.
     *  Performs MoveIn for anonymous postmove customer using Direct debit.
     *  
     */
    @Test(groups = {HomeMove})
    public void postMoveAnonymousCustomerUsingDirectDebit(){
    	Report.createTestLogHeader("postMove_AnonymousCustomer_Bundle_DD", "Anonymous customer");
    	int moveInDate=-5;	
		int numberOfPrevAddress=1;
    	final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveTestData");
		new HomePageAction()
				.navigateToLogout();
    	new HomeMoveAction()
    			.navigateToMovingInForAnonymousCustomer()
    			.navigateToStartMovingHomeForAnonymous()
    			.enterPersonalDetailsForAnonymousCustomer(homeMove)
    			.navigateToMovingInOnly()
    			.unselectContactExistingSuppliers()
    			.selectProductsMovingInBundle()
    			.enterMovingInDetails(homeMove,moveInDate)
    			.selectMoveInAddress(homeMove)
    			.enterPreviousAddressHistory(homeMove)
    			.selectNumberPreviousAddresses(homeMove,numberOfPrevAddress)
    			.enterMeterReadingForPostMoveCustomer(homeMove)
    			.selectPaymentTypeDirectDebit()
    			.enterBankDetailsForPayment(homeMove)
    			.navigateToConfirmationPage()
    			.navigateToHome();
    }
    
    
    
    //-------------------------------------------------------MOVEOUT--------------------------------------------------//
    /*
     *  Mandatory field in UserProfile: UCRN and Account Number.
     *  Performs MoveOut For OAM Gas Customer.
     */ 
   @Test(groups = {HomeMove})
	public void moveOutForOAMGasCustomer(){
		Report.createTestLogHeader("PreMove_Moveout_OAMGasCustomer", "GasAccount");
		int moveOutDateOutOfLimit=35;
		int moveOutDate=8;	
		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveTestData");
		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
				.navigateToAccountSummaryPage(userProfile)
				.navigateToMovingHome("Existing")							
				.enterMoveOutDetailsForOAM(homeMove,moveOutDateOutOfLimit)
				.errorMessageForMoveInDateOutOfLimit()
				.enterMoveOutDetailsForOAM(homeMove,moveOutDate)
				.navigateToCloseAccountsPage()
				.selectCloseAllAccounts()
				.enterMeterReading("Gas")
				.navigateToForwardingAddressEntry()
				.enterForwardingAddressDetails(homeMove)
				.selectMarketingConsent()
				.navigateToHome();
	}
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number.
    *  Performs MoveOut For OAM Electricity Customer.
    */ 
  @Test(groups = {HomeMove})
	public void moveOutForOAMElectricityCustomer(){
		Report.createTestLogHeader("PreMove_Moveout_OAMElectricityCustomer", "Electricity Account");
		int moveOutDate=8;	
		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveTestData");
		UserProfile userProfile=new TestDataHelper().getUserProfile("ElectricityAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		String sysdate=new OnlineDBConnector().DBsysdate();
		
		new HomePageAction()			
				.navigateToLogin()
				.login(userProfile)
				.verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
				.navigateToAccountSummaryPage(userProfile)
				.navigateToMovingHome("Existing")							
				.enterMoveOutDetailsForOAM(homeMove,moveOutDate)
				.navigateToCloseAccountsPage()
				.selectCloseAllAccounts()
				.enterMeterReading("Electricity")
				.navigateToForwardingAddressEntry()
				.enterForwardingAddressDetails(homeMove)
				.selectMarketingConsent()
				.navigateToHome()
				.runBatch(sysdate,"moveOut",userProfile);
	}
  /*
   *  Mandatory field in UserProfile: UCRN and Account Number.
   *  Performs MoveOut For OAM Gas Customer.
   */ 
 @Test(groups = {HomeMove})
	public void moveOutForOAMBGSCustomer(){
		Report.createTestLogHeader("PreMove_Moveout_OAMGasCustomer", "BGSAccount");
		int moveOutDateOutOfLimit=35;
		int moveOutDate=8;	
		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveTestData");
		UserProfile userProfile=new TestDataHelper().getUserProfile("HomeServicesAccount");
		getCustomerDetailsToUserProfileOAM(userProfile);
		new HomePageAction()
				.navigateToLogin()
				.login(userProfile)
				.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
				.navigateToAccountSummaryPage(userProfile)
				.navigateToMovingHome("Existing")							
				.enterMoveOutDetailsForOAM(homeMove,moveOutDateOutOfLimit)
				.errorMessageForMoveInDateOutOfLimit()
				.enterMoveOutDetailsForOAM(homeMove,moveOutDate)
				.navigateToCloseAccountsPage()
				.selectCloseAllAccounts()
				.enterMeterReading("BGS")
				.navigateToForwardingAddressEntry()
				.enterForwardingAddressDetails(homeMove)
				.selectMarketingConsent()
				.navigateToHome();
	}
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number.
    *  Performs MoveOut For Anonymous Gas Customer.
    *  Give the account number to close in accountToClose field in HomeMove.xml
    */
   @Test(groups = {HomeMove})
   public void preMoveAnonymousMoveOut(){
   		Report.createTestLogHeader("preMove_MoveOut_Anonymous_Gas", "Anonymous customer");
   		int preMoveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveOutTestData");
		new HomePageAction()
				.navigateToLogout();
   		new HomeMoveAction()
   				.navigateToMovingInForAnonymousCustomer()
   				.navigateToStartMovingHomeForAnonymous()
   				.enterPersonalDetailsForAnonymousCustomer(homeMove)
   				.enterMoveOutDetails(homeMove, preMoveOutDate)
   				.navigateToCloseAccountsPage()
   				.addAccountsToCloseForAnonymous("Gas",homeMove)
   				.navigateToMeterRead()
   				.enterMeterReading("Gas")
   				.navigateToForwardingAddressEntry()
   				.enterForwardingAddressDetails(homeMove)
   				.navigateToSubmitMoveOut()
   				.navigateToHome();
   }
   //----------------------------------------------TRANSFER---------------------------------------------------//
   /*
    *  Mandatory fields in HomeMove.xml: All valid personal details of Gas customer for which a match is found in siebel.
    *  Performs Transfer Anonymous Gas Customer
    */
   @Test(groups = {HomeMove})
   public void preMoveAnonymousTransferForGasCustomer(){
   		Report.createTestLogHeader("preMove_Transfer_GasCustomer", "Anonymous customer");
   		int preMoveOutDate=-5;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveOutTestData");
		new HomePageAction()
				.navigateToLogout();
   		new HomeMoveAction()
   				.navigateToMovingInForAnonymousCustomer()
   				.navigateToStartMovingHomeForAnonymous()
   				.enterPersonalDetailsForAnonymousCustomer(homeMove)
   				.enterMoveOutDetails(homeMove, preMoveOutDate)
   				.navigateToTransferAccountsPage()
   				.selectAccountsToTransferAnonymous(homeMove)
   				.enterMovingInDetails(homeMove,preMoveOutDate)
   				.selectMoveInAddress(homeMove) 
   				.enterUpgradingDetails(0)
   				.navigateToConfirmationPage()
   				.navigateToHome();
  }
   
   /*
    *  Mandatory fields in HomeMove.xml: All valid personal details of Dual customer for which a match is found in siebel.
    *  Performs Transfer for Anonymous Dual Customer.
    */
   @Test(groups = {HomeMove})
   public void preMoveAnonymousTransferForDualCustomer(){
   		Report.createTestLogHeader("preMove_Transfer_DualCustomer", "Anonymous customer");
   		int preMoveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveOutDualTestData");
		new HomePageAction()
				.navigateToLogout();
   		new HomeMoveAction()
   				.navigateToMovingInForAnonymousCustomer()
   				.navigateToStartMovingHomeForAnonymous()
   				.enterPersonalDetailsForAnonymousCustomer(homeMove)
   				.enterMoveOutDetails(homeMove, preMoveOutDate)
   				.navigateToTransferAccountsPage()
   				.selectAccountsToTransferAnonymous(homeMove)
   				.enterMovingInDetails(homeMove,preMoveOutDate)
   				.selectMoveInAddress(homeMove)
   				.enterUpgradingDetails(0)
   				.navigateToConfirmationPage()
   				.navigateToHome();
   }
   /*
    *  Mandatory fields in HomeMove.xml: All valid personal details of Gas customer for which a match is found in siebel.
    *  Performs Transfer by adding Missing Products.
    */
   @Test(groups = {HomeMove})
   public void preMoveAnonymousTransferAddMissingProducts(){
   		Report.createTestLogHeader("preMove_Transfer_AddMissingProducts_Gas", "Anonymous customer");
   		int preMoveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveOutTestData");
		new HomePageAction()
				.navigateToLogout();
   		new HomeMoveAction()
   				.navigateToMovingInForAnonymousCustomer()
   				.navigateToStartMovingHomeForAnonymous()
   				.enterPersonalDetailsForAnonymousCustomer(homeMove)
   				.enterMoveOutDetails(homeMove, preMoveOutDate)
   				.navigateToTransferAccountsPage()
   				.selectAccountsToTransferAnonymous(homeMove)
   				.enterMovingInDetails(homeMove,preMoveOutDate)
   				.selectMoveInAddress(homeMove)
   				.enterUpgradingDetails(0)
   				.navigateToConfirmationPage()
   				.navigateToHome();
   }
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number
    */
   @Test(groups = {HomeMove})
   public void preMoveOAMTransferAddMissingProductsAndChangeDate(){
   		Report.createTestLogHeader("preMove_Transfer_OAM_changeMoveOutDate", "Gas customer");
   		int preMoveOutDate=28;	
   		int changeDate=27;
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveTestData");
   		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
   		getCustomerDetailsToUserProfileOAM(userProfile);
   		String sysdate=new OnlineDBConnector().DBsysdate();
   		new HomePageAction()
   				.navigateToLogin()
   				.login(userProfile)
   				.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
   				.navigateToAccountSummaryPage(userProfile)
   				.navigateToMovingHome("Existing")
   				.enterMoveOutDetailsForOAM(homeMove, preMoveOutDate)
   				.navigateToTransferAccountsPage()
   				.addMissingAccountsDetails(homeMove)
   				.selectTransferAllAccounts()
   				.enterMeterReading("Gas")
   				.selectRemindMeLaterForGasMeterRead()
   				.navigateToForwardingAddressEntry()
   				.enterForwardingAddressDetails(homeMove)
   				.sendBillToAntherAddress(homeMove)
   				.enterUpgradingDetails(0)
   				.changeMoveOutDate(changeDate,homeMove)
   				.navigateToConfirmationPage()
   				.logoutHomeMove()
   				.runBatch(sysdate, "transfer", userProfile);
   	  }
   
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number  of single meter read Electricity account
    */
   @Test(groups = {HomeMove})
   public void preMoveOAMElectricityTransfer(){
   		Report.createTestLogHeader("preMove_Transfer_OAM", "Electricity customer");
   		int preMoveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveTestData");
   		UserProfile userProfile=new TestDataHelper().getUserProfile("ElectricityAccount");
   		getCustomerDetailsToUserProfileOAM(userProfile);
   		new HomePageAction()
   				.navigateToLogin()
   				.login(userProfile)
   				.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
   				.navigateToAccountSummaryPage(userProfile)
   				.navigateToMovingHome("Existing")
   				.enterMoveOutDetailsForOAM(homeMove, preMoveOutDate)
   				.navigateToTransferAccountsPage()
   				.addMissingAccountsDetails(homeMove)
   				.selectTransferAllAccounts()
   				.enterMeterReading("Electricity")
   				.selectRemindMeLaterForElecMeterRead()
   				.navigateToForwardingAddressEntry()
   				.enterForwardingAddressDetails(homeMove)
   				.sendBillToAntherAddress(homeMove)
   				.enterUpgradingDetails(0)
   				.navigateToConfirmationPage()
   				.logoutHomeMove();
   	  }
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number
    */
   @Test(groups = {HomeMove})
   public void preMoveOAMJITransfer(){
   		Report.createTestLogHeader("preMove_Transfer_OAM", "JI customer");
   		int preMoveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveTestData");
   		UserProfile userProfile=new TestDataHelper().getUserProfile("JIAccount");
   		getCustomerDetailsToUserProfileOAM(userProfile);
   		new HomePageAction()
   				.navigateToLogin()
   				.login(userProfile)
   				.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
   				.navigateToAccountSummaryPage(userProfile)
   				.navigateToMovingHome("Existing")
   				.enterMoveOutDetailsForOAM(homeMove, preMoveOutDate)
   				.navigateToTransferAccountsPage()
   				.addMissingAccountsDetails(homeMove)
   				.selectTransferAllAccounts()			
   				.selectRemindMeLaterForGasMeterRead()
   				.navigateToForwardingAddressEntry()
   				.enterForwardingAddressDetails(homeMove)
   				.sendBillToAntherAddress(homeMove)
   				.enterUpgradingDetails(0)
   				.navigateToConfirmationPage()
   				.logoutHomeMove();
   	  }
   
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number
    */
   @Test(groups = {HomeMove})
   public void preMoveOAMBGSTransfer(){
   		Report.createTestLogHeader("preMove_Transfer_OAM", "BGS customer");
   		int preMoveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveTestData");
   		UserProfile userProfile=new TestDataHelper().getUserProfile("HomeServicesAccount");
   		getCustomerDetailsToUserProfileOAM(userProfile);
   		new HomePageAction()
   				.navigateToLogin()
   				.login(userProfile)
   				.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
   				.navigateToAccountSummaryPage(userProfile)
   				.navigateToMovingHome("Existing")
   				.enterMoveOutDetailsForOAM(homeMove, preMoveOutDate)
   				.navigateToTransferAccountsPage()
   				.addMissingAccountsDetails(homeMove)
   				.selectTransferAllAccounts()			//check
   				.enterMeterReading("Gas")
   				.selectRemindMeLaterForGasMeterRead()
   				.navigateToForwardingAddressEntry()
   				.enterForwardingAddressDetails(homeMove)
   				.sendBillToAntherAddress(homeMove)
   				.enterUpgradingDetails(0)
   				.navigateToConfirmationPage()
   				.logoutHomeMove();
   	  }
   
   
   //------------------------------------------------LandLord----------------------------------------------------------//
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number
    */
   @Test(groups = {HomeMove})
   public void homeMoveLandlordForOAMGas(){
   		Report.createTestLogHeader("HomeMove LandLord For Gas", "Gas customer");
   		int moveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveLandLordTestData");
   		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
   		getCustomerDetailsToUserProfileOAM(userProfile);
   		new HomePageAction()
   				.navigateToLogin()
   				.login(userProfile)
   				.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
   				.navigateToAccountSummaryPage(userProfile)
   				.navigateToMovingHome("LandLord")
   				.navigateToLandlordMovingHome()
   				.navigateToLandLordBusinessNature()
   				.enterYourDetailsInLandLordMovingHome(homeMove)
   				.enterSupplyAddressDetails(homeMove)
   				.enterMoveHomeDetailsForLandLord("Gas",moveOutDate,homeMove)
   				.editDetailsForLandLordHomeMove(homeMove, moveOutDate, "YourDetails")
   				.homeMoveLandLordConfirmationPage()
   				.logoutHomeMove();
}
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number
    */
   
   @Test(groups = {HomeMove})
   public void homeMoveLandlordForOAMElectricity(){
   		Report.createTestLogHeader("HomeMove LandLord For Electricity", "Electricity customer");
   		int moveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveLandLordTestData");
   		UserProfile userProfile=new TestDataHelper().getUserProfile("ElectricityAccount");
   		getCustomerDetailsToUserProfileOAM(userProfile);
   		new HomePageAction()
   				.navigateToLogin()
   				.login(userProfile)
   				.verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
   				.navigateToAccountSummaryPage(userProfile)
   				.navigateToMovingHome("LandLord")
   				.navigateToLandlordMovingHome()
   				.navigateToLandLordBusinessNature()
   				.enterYourDetailsInLandLordMovingHome(homeMove)
   				.enterSupplyAddressDetails(homeMove)
   				.enterMoveHomeDetailsForLandLord("Electricity",moveOutDate,homeMove)
   				.editDetailsForLandLordHomeMove(homeMove, moveOutDate, "YourDetails")
   				.homeMoveLandLordConfirmationPage()
   				.logoutHomeMove();
}
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number
    */
   
   @Test(groups = {HomeMove})
   public void homeMoveLandlordForOAMDual(){
   		Report.createTestLogHeader("HomeMove LandLord For Dual", "Dual customer");
   		int moveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveLandLordTestData");
   		UserProfile userProfile=new TestDataHelper().getUserProfile("DualAccount");
   		getCustomerDetailsToUserProfileOAM(userProfile);
   		new HomePageAction()
   				.navigateToLogin()
   				.login(userProfile)
   				.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
   				.navigateToAccountSummaryPage(userProfile)
   				.navigateToMovingHome("LandLord")
   				.navigateToLandlordMovingHome()
   				.navigateToLandLordBusinessNature()
   				.enterYourDetailsInLandLordMovingHome(homeMove)
   				.enterSupplyAddressDetails(homeMove)
   				.enterMoveHomeDetailsForLandLord("Dual",moveOutDate,homeMove)
   				.editDetailsForLandLordHomeMove(homeMove, moveOutDate, "YourDetails")
   				.homeMoveLandLordConfirmationPage()
   				.logoutHomeMove();
}
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number
    */
   @Test(groups = {Regression,HomeMove})
   public void homeMoveLandlordForOAMJI(){
   		Report.createTestLogHeader("HomeMove LandLord For JI", "JI customer");
   		int moveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveLandLordTestData");
   		UserProfile userProfile=new TestDataHelper().getUserProfile("JIAccount");
   		getCustomerDetailsToUserProfileOAM(userProfile);
   		new HomePageAction()
   				.navigateToLogin()
   				.login(userProfile)
   				.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
   				.navigateToAccountSummaryPage(userProfile)
   				.navigateToMovingHome("LandLord")
   				.navigateToLandlordMovingHome()
   				.navigateToLandLordBusinessNature()
   				.enterYourDetailsInLandLordMovingHome(homeMove)
   				.enterSupplyAddressDetails(homeMove)
   				.enterMoveHomeDetailsForLandLord("Dual",moveOutDate,homeMove)
   				.editDetailsForLandLordHomeMove(homeMove, moveOutDate, "YourDetails")
   				.homeMoveLandLordConfirmationPage()
   				.logoutHomeMove();
}
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number
    */
   @Test(groups = {HomeMove})
   public void homeMoveLandlordForOAMBGS(){
   		Report.createTestLogHeader("HomeMove LandLord For Electricity", "BGS customer");
   		int moveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveLandLordTestData");
   		UserProfile userProfile=new TestDataHelper().getUserProfile("HomeServicesAccount");
   		getCustomerDetailsToUserProfileOAM(userProfile);
   		new HomePageAction()
   				.navigateToLogin()
   				.login(userProfile)
   				.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
   				.navigateToAccountSummaryPage(userProfile)
   				.navigateToMovingHome("LandLord")
   				.navigateToLandlordMovingHome()
   				.navigateToLandLordBusinessNature()
   				.enterYourDetailsInLandLordMovingHome(homeMove)
   				.enterSupplyAddressDetails(homeMove)
   				.enterMoveHomeDetailsForLandLord("Gas",moveOutDate,homeMove)
   				.editDetailsForLandLordHomeMove(homeMove, moveOutDate, "YourDetails")
   				.homeMoveLandLordConfirmationPage()
   				.logoutHomeMove();
}
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number
    */
   @Test(groups = {HomeMove,AnonymousRegression})
   public void homeMoveLandlordForAnonymous(){
   		Report.createTestLogHeader("HomeMove LandLord For Anonymous", "Anonymous customer with with Move In and Move Out Three Add Account Holder");
   		int moveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveLandLordTestData");
		new HomePageAction()
				.navigateToLogout();
   		new HomeMoveAction()
   				.navigateToMovingInForAnonymousCustomer()
   				.navigateToLandlordMovingHome()
   				.navigateToLandLordBusinessNature()
   				.enterYourDetailsInLandLordMovingHome(homeMove)
   				.enterSupplyAddressDetails(homeMove)
   				.enterMoveHomeDetailsForLandLord("Dual",moveOutDate,homeMove)
   				.editDetailsForLandLordHomeMove(homeMove, moveOutDate, "YourDetails")
   				.homeMoveLandLordConfirmationPage()
   				.navigateToHome();
   }
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number
    */
   @Test(groups = {HomeMove,AnonymousRegression})
   public void homeMoveLandlordForDoubleAddAccHolderAnonymous(){
   		Report.createTestLogHeader("HomeMove LandLord For Anonymous", "Anonymous customer with with Move In and Move Out Double Add Account Holder");
   		int moveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveLandLordTestData");
		new HomePageAction()
				.navigateToLogout();
   		new HomeMoveAction()
   				.navigateToMovingInForAnonymousCustomer()
   				.navigateToLandlordMovingHome()
   				.navigateToLandLordBusinessNature()
   				.enterYourDetailsInLandLordMovingHome(homeMove)
   				.enterSupplyAddressDetails(homeMove)
   				.enterDoubleAddAccountForLandLord("Dual",moveOutDate,homeMove)
   				.editDetailsForLandLordHomeMove(homeMove, moveOutDate, "YourDetails")
   				.homeMoveLandLordConfirmationPage()
   				.navigateToHome();
   }
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number
    */
   @Test(groups = {HomeMove,AnonymousRegression})
   public void homeMoveLandlordForSingleAddAccHolderAnonymous(){
   		Report.createTestLogHeader("HomeMove LandLord For Anonymous", "Anonymous customer with Move In and Move Out Single Add Account Holder");
   		int moveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveLandLordTestData");
		new HomePageAction()
				.navigateToLogout();
   		new HomeMoveAction()
   				.navigateToMovingInForAnonymousCustomer()
   				.navigateToLandlordMovingHome()
   				.navigateToLandLordBusinessNature()
   				.enterYourDetailsInLandLordMovingHome(homeMove)
   				.enterSupplyAddressDetails(homeMove)
   				.enterSingleAddAccountForLandLord("Dual",moveOutDate,homeMove)
   				.editDetailsForLandLordHomeMove(homeMove, moveOutDate, "YourDetails")
   				.homeMoveLandLordConfirmationPage()
   				.navigateToHome();
   }
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number
    */
   @Test(groups = {HomeMove,AnonymousRegression})
   public void verifyLandlordForThreeAddAccHolderAnonymous(){
   		Report.createTestLogHeader("HomeMove LandLord For Anonymous", "Anonymous customer without Move In and Move Out Three Add Account Holder");
   		int moveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveLandLordTestData");
		new HomePageAction()
				.navigateToLogout();
   		new HomeMoveAction()
   				.navigateToMovingInForAnonymousCustomer()
   				.navigateToLandlordMovingHome()
   				.navigateToLandLordBusinessNature()
   				.enterYourDetailsInLandLordMovingHome(homeMove)
   				.enterSupplyAddressDetails(homeMove)
   				.enterMoveHomeDetailsForLandLord("Dual",moveOutDate,homeMove)
   				.editDetailsForLandLordHomeMove(homeMove, moveOutDate, "YourDetails")
   				.homeMoveLandLordConfirmationPage()
   				.navigateToHome();
   }
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number
    */
   @Test(groups = {HomeMove,AnonymousRegression})
   public void verifyLandlordForDoubleAddAccHolderAnonymous(){
   		Report.createTestLogHeader("HomeMove LandLord For Anonymous", "Anonymous customer without Move In and Move Out Double Add Account Holder");
   		int moveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveLandLordTestData");
		new HomePageAction()
				.navigateToLogout();
   		new HomeMoveAction()
   				.navigateToMovingInForAnonymousCustomer()
   				.navigateToLandlordMovingHome()
   				.navigateToLandLordBusinessNature()
   				.enterYourDetailsInLandLordMovingHome(homeMove)
   				.enterSupplyAddressDetails(homeMove)
   				.enterDoubleAddAccountForLandLord("Dual",moveOutDate,homeMove)
   				.editDetailsForLandLordHomeMove(homeMove, moveOutDate, "YourDetails")
   				.homeMoveLandLordConfirmationPage()
   				.navigateToHome();
   }
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number
    */
   @Test(groups = {HomeMove,AnonymousRegression})
   public void VerifyLandlordForSingleAddAccHolderAnonymous(){
   		Report.createTestLogHeader("HomeMove LandLord For Anonymous", "Anonymous customer without Move In and Move Out Single Add Account Holder");
   		int moveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveLandLordTestData");
		new HomePageAction()
				.navigateToLogout();
   		new HomeMoveAction()
   				.navigateToMovingInForAnonymousCustomer()
   				.navigateToLandlordMovingHome()
   				.navigateToLandLordBusinessNature()
   				.enterYourDetailsInLandLordMovingHome(homeMove)
   				.enterSupplyAddressDetails(homeMove)
   				.enterSingleAddAccountForLandLord("Dual",moveOutDate,homeMove)
   				.editDetailsForLandLordHomeMove(homeMove, moveOutDate, "YourDetails")
   				.homeMoveLandLordConfirmationPage()
   				.navigateToHome();
}
   
   //----------------------------------------------LETTING AGENTS--------------------------------------//
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number
    */
   @Test(groups = {HomeMove,AnonymousRegression})
   public void homeMoveLettingAgentsForAnonymous(){
   		Report.createTestLogHeader("HomeMove LandLord For Anonymous", "Anonymous customer with Move In and Move Out Three Add Account Holder for Letting Agents");
   		int moveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveLandLordTestData");
		new HomePageAction()
				.navigateToLogout();
   		new HomeMoveAction()
   				.navigateToMovingInForAnonymousCustomer()
   				.navigateToLandlordMovingHome()
   				.navigateToLettingAgentsBusinessNature()
   				.enterYourDetailsInLandLordMovingHome(homeMove)
   				.enterSupplyAddressDetails(homeMove)
   				.enterMoveHomeDetailsForLandLord("Dual",moveOutDate,homeMove)
   				.editDetailsForLandLordHomeMove(homeMove, moveOutDate, "YourDetails")
   				.homeMoveLandLordConfirmationPage()
   				.navigateToHome();
   }
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number
    */
   @Test(groups = {HomeMove,AnonymousRegression})
   public void homeMoveLettingAgentsForDoubleAddAccHolderAnonymous(){
   		Report.createTestLogHeader("HomeMove LandLord For Anonymous", "Anonymous customer with with Move In and Move Out Double Add Account Holder for Letting Agents");
   		int moveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveLandLordTestData");
		new HomePageAction()
				.navigateToLogout();
   		new HomeMoveAction()
   				.navigateToMovingInForAnonymousCustomer()
   				.navigateToLandlordMovingHome()
   				.navigateToLettingAgentsBusinessNature()
   				.enterYourDetailsInLandLordMovingHome(homeMove)
   				.enterSupplyAddressDetails(homeMove)
   				.enterDoubleAddAccountForLandLord("Dual",moveOutDate,homeMove)
   				.editDetailsForLandLordHomeMove(homeMove, moveOutDate, "YourDetails")
   				.homeMoveLandLordConfirmationPage()
   				.navigateToHome();
   }
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number
    */
   @Test(groups = {HomeMove,AnonymousRegression})
   public void homeMoveLettingAgentsForSingleAddAccHolderAnonymous(){
   		Report.createTestLogHeader("HomeMove LandLord For Anonymous", "Anonymous customer with Move In and Move Out Single Add Account Holder for Letting Agents");
   		int moveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveLandLordTestData");
		new HomePageAction()
				.navigateToLogout();
   		new HomeMoveAction()
   				.navigateToMovingInForAnonymousCustomer()
   				.navigateToLandlordMovingHome()
   				.navigateToLettingAgentsBusinessNature()
   				.enterYourDetailsInLandLordMovingHome(homeMove)
   				.enterSupplyAddressDetails(homeMove)
   				.enterSingleAddAccountForLandLord("Dual",moveOutDate,homeMove)
   				.editDetailsForLandLordHomeMove(homeMove, moveOutDate, "YourDetails")
   				.homeMoveLandLordConfirmationPage()
   				.navigateToHome();
   }
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number
    */
   @Test(groups = {HomeMove,AnonymousRegression})
   public void verifyLettingAgentsForThreeAddAccHolderAnonymous(){
   		Report.createTestLogHeader("HomeMove LandLord For Anonymous", "Anonymous customer without Move In and Move Out Three Add Account Holder for Letting Agents");
   		int moveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveLandLordTestData");
		new HomePageAction()
				.navigateToLogout();
   		new HomeMoveAction()
   				.navigateToMovingInForAnonymousCustomer()
   				.navigateToLandlordMovingHome()
   				.navigateToLettingAgentsBusinessNature()
   				.enterYourDetailsInLandLordMovingHome(homeMove)
   				.enterSupplyAddressDetails(homeMove)
   				.enterMoveHomeDetailsForLandLord("Dual",moveOutDate,homeMove)
   				.editDetailsForLandLordHomeMove(homeMove, moveOutDate, "YourDetails")
   				.homeMoveLandLordConfirmationPage()
   				.navigateToHome();
   }
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number
    */
   @Test(groups = {HomeMove,AnonymousRegression})
   public void verifyLettingAgentsForDoubleAddAccHolderAnonymous(){
   		Report.createTestLogHeader("HomeMove LandLord For Anonymous", "Anonymous customer without Move In and Move Out Double Add Account Holder for Letting Agents");
   		int moveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveLandLordTestData");
		new HomePageAction()
				.navigateToLogout();
   		new HomeMoveAction()
   				.navigateToMovingInForAnonymousCustomer()
   				.navigateToLandlordMovingHome()
   				.navigateToLettingAgentsBusinessNature()
   				.enterYourDetailsInLandLordMovingHome(homeMove)
   				.enterSupplyAddressDetails(homeMove)
   				.enterDoubleAddAccountForLandLord("Dual",moveOutDate,homeMove)
   				.editDetailsForLandLordHomeMove(homeMove, moveOutDate, "YourDetails")
   				.homeMoveLandLordConfirmationPage()
   				.navigateToHome();
   }
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number
    */
   @Test(groups = {HomeMove,AnonymousRegression})
   public void VerifyLettingAgentsForSingleAddAccHolderAnonymous(){
   		Report.createTestLogHeader("HomeMove LandLord For Anonymous", "Anonymous customer without Move In and Move Out Single Add Account Holder for Letting Agents");
   		int moveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveLandLordTestData");
		new HomePageAction()
				.navigateToLogout();
   		new HomeMoveAction()
   				.navigateToMovingInForAnonymousCustomer()
   				.navigateToLandlordMovingHome()
   				.navigateToLettingAgentsBusinessNature()
   				.enterYourDetailsInLandLordMovingHome(homeMove)
   				.enterSupplyAddressDetails(homeMove)
   				.enterSingleAddAccountForLandLord("Dual",moveOutDate,homeMove)
   				.editDetailsForLandLordHomeMove(homeMove, moveOutDate, "YourDetails")
   				.homeMoveLandLordConfirmationPage()
   				.navigateToHome();
}
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number
    */
   
   @Test(groups = {HomeMove})
   public void homeMoveLettingAgentsForOAMGas(){
   		Report.createTestLogHeader("HomeMove Letting For Gas", "Gas customer");
   		int moveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveLandLordTestData");
   		UserProfile userProfile=new TestDataHelper().getUserProfile("GasAccount");
   		getCustomerDetailsToUserProfileOAM(userProfile);
   		new HomePageAction()
   				.navigateToLogin()
   				.login(userProfile)
   				.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
   				.navigateToAccountSummaryPage(userProfile)
   				.navigateToMovingHome("LettingAgents")
   				.navigateToLandlordMovingHome()
   				.navigateToLettingAgentsBusinessNature()
   				.enterYourDetailsInLandLordMovingHome(homeMove)
   				.enterSupplyAddressDetails(homeMove)
   				.enterMoveHomeDetailsForLandLord("Gas",moveOutDate,homeMove)
   				.editDetailsForLandLordHomeMove(homeMove, moveOutDate, "YourDetails")
   				.homeMoveLandLordConfirmationPage()
   				.logoutHomeMove();
}
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number
    */
   
   @Test(groups = {HomeMove})
   public void homeMoveLettingAgentsForOAMElectricity(){
   		Report.createTestLogHeader("HomeMove Letting For Electricity", "Electricity customer");
   		int moveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveLandLordTestData");
   		UserProfile userProfile=new TestDataHelper().getUserProfile("ElectricityAccount");
   		getCustomerDetailsToUserProfileOAM(userProfile);
   		new HomePageAction()
   				.navigateToLogin()
   				.login(userProfile)
   				.verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
   				.navigateToAccountSummaryPage(userProfile)
   				.navigateToMovingHome("LettingAgents")
   				.navigateToLandlordMovingHome()
   				.navigateToLettingAgentsBusinessNature()
   				.enterYourDetailsInLandLordMovingHome(homeMove)
   				.enterSupplyAddressDetails(homeMove)
   				.enterMoveHomeDetailsForLandLord("Electricity",moveOutDate,homeMove)
   				.editDetailsForLandLordHomeMove(homeMove, moveOutDate, "YourDetails")
   				.homeMoveLandLordConfirmationPage()
   				.logoutHomeMove();
}
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number
    */
   @Test(groups = {HomeMove})
   public void homeMoveLettingAgentsForOAMDual(){
   		Report.createTestLogHeader("HomeMove LandLord For DualAccount", "Dual customer");
   		int moveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveLandLordTestData");
   		UserProfile userProfile=new TestDataHelper().getUserProfile("DualAccount");
   		getCustomerDetailsToUserProfileOAM(userProfile);
   		new HomePageAction()
   				.navigateToLogin()
   				.login(userProfile)
   				.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
   				.navigateToAccountSummaryPage(userProfile)
   				.navigateToMovingHome("LettingAgents")
   				.navigateToLandlordMovingHome()
   				.navigateToLettingAgentsBusinessNature()
   				.enterYourDetailsInLandLordMovingHome(homeMove)
   				.enterSupplyAddressDetails(homeMove)
   				.enterMoveHomeDetailsForLandLord("Dual",moveOutDate,homeMove)
   				.editDetailsForLandLordHomeMove(homeMove, moveOutDate, "YourDetails")
   				.homeMoveLandLordConfirmationPage()
   				.logoutHomeMove();
}
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number
    */
   @Test(groups = {HomeMove})
   public void homeMoveLettingAgentsForOAMJI(){
   		Report.createTestLogHeader("HomeMove LandLord For JIAccount", "JI customer");
   		int moveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveLandLordTestData");
   		UserProfile userProfile=new TestDataHelper().getUserProfile("JIAccount");
   		getCustomerDetailsToUserProfileOAM(userProfile);
   		new HomePageAction()
   				.navigateToLogin()
   				.login(userProfile)
   				.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
   				.navigateToAccountSummaryPage(userProfile)
   				.navigateToMovingHome("LettingAgents")
   				.navigateToLandlordMovingHome()
   				.navigateToLettingAgentsBusinessNature()
   				.enterYourDetailsInLandLordMovingHome(homeMove)
   				.enterSupplyAddressDetails(homeMove)
   				.enterMoveHomeDetailsForLandLord("Dual",moveOutDate,homeMove)
   				.editDetailsForLandLordHomeMove(homeMove, moveOutDate, "YourDetails")
   				.homeMoveLandLordConfirmationPage()
   				.logoutHomeMove();
}
   
   
   /*
    *  Mandatory field in UserProfile: UCRN and Account Number
    */
   @Test(groups = {HomeMove})
   public void homeMoveLettingAgentsForOAMBGS(){
   		Report.createTestLogHeader("HomeMove LandLord For BGSAccount", "BGS customer");
   		int moveOutDate=28;	
   		final HomeMove homeMove = new TestDataHelper().getHomeMoveData("HomeMoveLandLordTestData");
   		UserProfile userProfile=new TestDataHelper().getUserProfile("HomeServicesAccount");
   		getCustomerDetailsToUserProfileOAM(userProfile);
   		new HomePageAction()
   				.navigateToLogin()
   				.login(userProfile)
   				.verifyLogin(userProfile.getLastName(), userProfile.getGasAccount())
   				.navigateToAccountSummaryPage(userProfile)
   				.navigateToMovingHome("LettingAgents")
   				.navigateToLandlordMovingHome()
   				.navigateToLettingAgentsBusinessNature()
   				.enterYourDetailsInLandLordMovingHome(homeMove)
   				.enterSupplyAddressDetails(homeMove)
   				.enterMoveHomeDetailsForLandLord("Gas",moveOutDate,homeMove)
   				.editDetailsForLandLordHomeMove(homeMove, moveOutDate, "YourDetails")
   				.homeMoveLandLordConfirmationPage()
   				.logoutHomeMove();
}
   
   
}
