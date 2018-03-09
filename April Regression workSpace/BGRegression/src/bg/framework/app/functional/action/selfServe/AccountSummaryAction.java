package bg.framework.app.functional.action.selfServe;

//import bg.framework.app.functional.action.reFactoring.AccountSummaryAction;
import bg.framework.app.functional.action.common.HomePageAction;

import bg.framework.app.functional.action.reFactoring.ConsumptionHubRewriteAction;
import bg.framework.app.functional.action.reFactoring.DDcpsRewriteAction;
import bg.framework.app.functional.action.reFactoring.MeterReadHistoryAction;
import bg.framework.app.functional.action.reFactoring.UnitRatesAction;
import bg.framework.app.functional.action.reFactoring.ViewBillAction;
import bg.framework.app.functional.action.selfServe.DdcpsAction;
import bg.framework.app.functional.action.sales.AcquisitionAction;
import bg.framework.app.functional.action.sales.GetAPriceAction;
import bg.framework.app.functional.action.sales.ProductAndServicesAction;
import bg.framework.app.functional.entities.Ddcps;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.LegacyHomePage;
import bg.framework.app.functional.page.reFactoring.ConsumptionHubRewritePage;
import bg.framework.app.functional.page.reFactoring.DDcpsRewritePage;
import bg.framework.app.functional.page.reFactoring.MeterReadHistoryPage;
import bg.framework.app.functional.page.reFactoring.UnitRatesPage;
import bg.framework.app.functional.page.reFactoring.ViewBillPage;
import bg.framework.app.functional.page.sales.YourOrderPage;
import bg.framework.app.functional.page.selfServe.DdcpsPage;
import bg.framework.app.functional.page.selfServe.AccountOverviewPage;
import bg.framework.app.functional.page.selfServe.AccountSummaryPage;
import bg.framework.app.functional.page.selfServe.BillHistoryPage;
import bg.framework.app.functional.page.selfServe.HomeMovePage;
import bg.framework.app.functional.page.selfServe.PredictNextBillPage;
import bg.framework.app.functional.page.selfServe.RequestPaymentCardPage;
import bg.framework.app.functional.page.selfServe.UpgradeToSmartMeterPage;


public class AccountSummaryAction {
	private UserProfile userProfile;
	private Ddcps ddcps;

    public AccountSummaryAction() {

    }

    public AccountSummaryAction(UserProfile userProfile) {
        UserProfile userProfile1 = userProfile;
    }
    
    public AcquisitionAction confirmSMBAddress(){
        new YourOrderPage().confirmSMBAddress();
       return new AcquisitionAction();
     }

    public SMRAction navigateToSMRPage() {

        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.navigateToSMR();
        return new SMRAction();
    }

    public AccountSummaryAction verifyAccountSummaryPageAction(String accountNumber) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.verifyAccountSummaryPage(accountNumber);
        return this;
    }
   

    public AccountOverviewAction allAccountOverviewPageAction(){
    	AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    	accountSummaryPage.navigateToAllAccountsPage();
        return new AccountOverviewAction();
   }

    public AccountSummaryAction navigateToAllYourAccountPage() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.navigateToAllYourAccount();
        return this;
    }

    public ContactUsAction navigateToContactUsPage() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.navigateToContactUsPage();
        return new ContactUsAction();
    }
   
    public AccountSummaryAction navigateToContactUs() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.navigateToContactUs();
        return new AccountSummaryAction();
    }
   
    public AccountSummaryAction navigateToMovingHomePage()
    {
    	AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        //accountSummaryPage.navigateToMovingHomePage();
        return new AccountSummaryAction();
    }
    

    public ProductAndServicesAction navigateToProductAndServicesPage() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.navigateToProductsAndServicesPage();
        return new ProductAndServicesAction();
    }

    public GetAPriceAction navigateToGetAPrice() {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToGetAPricePage();
        return new GetAPriceAction();
    }

    public HelpAndAdviceAction navigatetoHelpAndAdvicePage() {
        LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToHelpandAdvicePage();
        return new HelpAndAdviceAction();
    }

    public ManagePersonalDetailsAction navigateToManagePersonalDetailsPage() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.navigateToManagePersonalDetailsPage();
        return new ManagePersonalDetailsAction();
    }

    public AccountSummaryAction verifyWTPAccountAndSSOAccountAction(){
    	AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    	accountSummaryPage.verifyWTPAccount();
    	return this;
    }
    public AccountSummaryAction verifyBGSAccountAction(){
    	AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    	accountSummaryPage.verifyBGSAccount();
    	return this;
    }
    
    public void logoutAction(){
    	AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    	accountSummaryPage.logoutPage();
    }
    
    public HomeMoveAction navigateToMovingHome(String customerType ){
    	HomeMovePage homemovepage =new HomeMovePage();
    	homemovepage.navigateToMovingHome(customerType);
    	return new HomeMoveAction();
    }
    public AccountSummaryAction navigateToSeeUnitRates() {
        AccountOverviewPage accountOverviewPage = new AccountOverviewPage();
        accountOverviewPage.navigateToSeeUnitRates();
        return new AccountSummaryAction();
    }
    public AccountSummaryAction viewPaymentHistory(){
    	AccountSummaryPage paymentHistory = new AccountSummaryPage();
    	paymentHistory.viewPaymentHistory();
    	return new AccountSummaryAction();
    }
    public PBFlagAction navigateToPbFlagPage(){
        AccountSummaryPage accountsummaryPage=new AccountSummaryPage();
       // accountsummaryPage.clickSeeYourStatementLink();
        accountsummaryPage.clickGoPaperLessLink();
        return new PBFlagAction(userProfile);    	
        }
    public AccountOverviewAction verifyPBFlagLinkAction(){
		 AccountSummaryPage accountsummaryPage=new AccountSummaryPage();
		 accountsummaryPage.clickSeeYourStatementLink();
		 accountsummaryPage.pbFlagLinkNonExistverification();
		 return new AccountOverviewAction();
	 }
    
    public BillHistoryAction navigateToBillHistory(){
    	BillHistoryPage billHistoryPage=new BillHistoryPage();
    	billHistoryPage.navigateToBillHistory();
    	return new BillHistoryAction();
    }
    public RequestPaymentCardAction navigateToOrderNewPaymentCard(){
 	   RequestPaymentCardPage requestpaymentcardpage = new RequestPaymentCardPage(); 
 	   requestpaymentcardpage.navigateToOrderNewPaymentCard();
 	   return new RequestPaymentCardAction();
    }
    public DdcpsAction switchToDD(Ddcps ddcps){
    	DdcpsPage switchToDD=new DdcpsPage();
    	switchToDD.switchToDD();
    	return new DdcpsAction(ddcps);
    }
    public DdcpsAction navigateToManageDD(Ddcps ddcps){
    	DdcpsPage manageDD=new DdcpsPage();
    	manageDD.navigateToManageDD();
    	return new DdcpsAction(ddcps);
    }
    public DDcpsRewriteAction navigateToManageDD(Ddcps ddcps,UserProfile userProfile){
    	DDcpsRewritePage manageDDRewrite=new DDcpsRewritePage(ddcps,userProfile);
    	manageDDRewrite.navigateToManageDD();
    	return new DDcpsRewriteAction(ddcps,userProfile);
    }
    public PredictNextBillAction navigateToPredictNextBill(String triggerPoint,UserProfile userProfile){
    	PredictNextBillPage navigateToPNB=new PredictNextBillPage();
    	navigateToPNB.navigateToPredictNextBill(triggerPoint,userProfile);
    	return new PredictNextBillAction(userProfile);
    }
    
    public ConsumptionHubRewriteAction navigateToUKEnergyUsage()
    {
    	ConsumptionHubRewritePage ukEnergyUsage= new ConsumptionHubRewritePage();
    	ukEnergyUsage.navigateToUKEnergyUsage();
    	return new ConsumptionHubRewriteAction();
    }
    
    
    public ConsumptionHubRewriteAction navigateToCityComparison()
    {
    	ConsumptionHubRewritePage cityComparison= new ConsumptionHubRewritePage();
    	cityComparison.navigateToCityComparison();
    	return new ConsumptionHubRewriteAction();
    }
    
    public ConsumptionHubRewriteAction navigateToCompareEnergyUsage()
    {
    	ConsumptionHubRewritePage cityComparison= new ConsumptionHubRewritePage();
    	cityComparison.navigateToCompareEnergyUsage();
    	return new ConsumptionHubRewriteAction();
    }
    
    public ConsumptionHubRewriteAction verifyConsumptionComparisonBGSAccount(){
    	new ConsumptionHubRewritePage().verifyConsumptionComparisonBGSAccount();
    	return new ConsumptionHubRewriteAction();
    }

/* Added for BGMO Start */
    public AccountSummaryAction verifySmartMeterLinkAtAccountSummaryPage() {
        new AccountOverviewPage().verifySmartMeterLink();
        return this;
    }
    
    public AccountSummaryAction verifyNoSmartMeterLinkAtAccountSummaryPage() {
        new AccountOverviewPage().verifyNoSmartMeterLink();
        return this;
    }
    public AccountSummaryAction navigateToAccountOverviewPage() {
    	new UpgradeToSmartMeterPage().navigateToYourAccountPage();
        return this;
    }

	public ViewBillAction clickSeeYourStatementLink() {
		ViewBillPage viewbillpage=new ViewBillPage();
		//viewbillpage.clickSeeYourStatementLink();
		return new ViewBillAction();
	}

	public AccountSummaryAction verifyAccountSummaryPageTOU(String accountNumber) {
		AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.verifyAccountSummaryPageTOU(accountNumber);
        return this;
	}

	public MeterReadHistoryAction navigateToMeterReadHistory(){
		new MeterReadHistoryPage().navigateToMeterReadHistory();
		return new MeterReadHistoryAction();
		
	}
	
	
	public UnitRatesAction verifyUnitRates(UserProfile userProfile, String Fuel) {
		UnitRatesPage verifyUnitRates=new UnitRatesPage();
		verifyUnitRates.verifyUnitRates(userProfile, Fuel);
		return new UnitRatesAction();
		
	}

	public UnitRatesAction navigateToSeeUnitLink(String energy) {
		UnitRatesPage verifyUnitRates=new UnitRatesPage();
		verifyUnitRates.navigateToSeeUnitLink(energy);
		return new UnitRatesAction();
	}

	public MeterReadHistoryAction verifyMeterReadTable(String accountNumber, String Fuel) {
		MeterReadHistoryPage verifyMR=new MeterReadHistoryPage();
		verifyMR.verifyMeterReadTable(accountNumber, Fuel);
		return new MeterReadHistoryAction();
	}


	public AccountSummaryAction verifyGoPaperlessSection(){
		AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
		accountSummaryPage.verifyGoPaperlessSection();
		return this;
	}

/*SMB Phase 2*/
	
	public AccountSummaryAction AccSumSMBPromotionalMsg(){
		AccountSummaryPage accPage= new AccountSummaryPage();
		accPage.AccSumSMBPromotionalMsg();
		return this;
	}


}
