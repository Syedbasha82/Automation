package bg.framework.app.functional.action.selfServe;

//import bg.framework.app.functional.action.reFactoring.AccountSummaryAction;
import bg.framework.app.functional.action.selfServe.PBFlagAction;
import bg.framework.app.functional.action.sales.GetAPriceAction;
import bg.framework.app.functional.action.sales.ProductAndServicesAction;
import bg.framework.app.functional.entities.Ddcps;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.LegacyHomePage;
import bg.framework.app.functional.page.selfServe.AccountOverviewPage;
import bg.framework.app.functional.page.selfServe.AccountSummaryPage;
import bg.framework.app.functional.page.selfServe.BillHistoryPage;
import bg.framework.app.functional.page.selfServe.HomeMovePage;
import bg.framework.app.functional.page.selfServe.PredictNextBillPage;
import bg.framework.app.functional.page.selfServe.RequestPaymentCardPage;
import bg.framework.app.functional.page.selfServe.DdcpsPage;

public class AccountSummaryAction {
	private UserProfile userProfile;

    public AccountSummaryAction() {

    }

    public AccountSummaryAction(UserProfile userProfile) {
        UserProfile userProfile1 = userProfile;
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
        accountsummaryPage.clickSeeYourStatementLink();
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
    public PredictNextBillAction navigateToPredictNextBill(String triggerPoint,UserProfile userProfile){
    	PredictNextBillPage navigateToPNB=new PredictNextBillPage();
    	navigateToPNB.navigateToPredictNextBill(triggerPoint,userProfile);
    	return new PredictNextBillAction(userProfile);
    }
    
}
