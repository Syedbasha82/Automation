package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.entities.ModelSalesProducts;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.AccountOverviewPage;
import bg.framework.app.functional.page.reFactoring.CorrespondancePage;
import bg.framework.app.functional.page.reFactoring.ModelSalesPage;
import bg.framework.app.functional.page.sales.UpsellPage;

public class ModelSalesAction {
	
	private static String customerType;
	private static String postCodeType;
	private static String jCIDiscount;
	
	public ModelSalesAction(String customerType,String postCodeType, String jCIDiscount){
		
		this.customerType = customerType;
		this.postCodeType = postCodeType;
		this.jCIDiscount = jCIDiscount;
	}  
	
	public ModelSalesAction(){
		
	}
    
	public ModelSalesAction selectingPackage(ModelSalesProducts modelSalesProducts){
		ModelSalesPage modelSales = new ModelSalesPage(customerType,postCodeType,jCIDiscount);
		modelSales.selectingPackage(modelSalesProducts);
		return new ModelSalesAction();
	}
	public ModelSalesAction selectingProduct(ModelSalesProducts modelSalesProducts){
		ModelSalesPage modelSales = new ModelSalesPage(customerType,postCodeType,jCIDiscount);
		modelSales.selectingProduct(modelSalesProducts);
		return new ModelSalesAction();
	}
	public ModelSalesAction navigateToGetAQuotePage(){
		ModelSalesPage modelSales = new ModelSalesPage(customerType,postCodeType,jCIDiscount);
		modelSales.navigateToGetAQuotePage();
		return new ModelSalesAction();
	}
	public ModelSalesAction selectingExcess(ModelSalesProducts modelSalesProducts){
		ModelSalesPage modelSales = new ModelSalesPage(customerType,postCodeType,jCIDiscount);
		modelSales.selectingExcess(modelSalesProducts);
		return new ModelSalesAction();
	}
	public ModelSalesAction enteringBoilerDetails(ModelSalesProducts modelSalesProducts){
		ModelSalesPage modelSales = new ModelSalesPage(customerType,postCodeType,jCIDiscount);
		modelSales.enteringBoilerDetails(modelSalesProducts);
		return new ModelSalesAction();
	}
	public ModelSalesAction selectingPaymentOption(ModelSalesProducts modelSalesProducts,String productConflictType){
		ModelSalesPage modelSales = new ModelSalesPage(customerType,postCodeType,jCIDiscount);
		modelSales.selectingPaymentOption(modelSalesProducts,productConflictType);
		return new ModelSalesAction();
	}
	public ModelSalesAction yourBasketPage(){
		ModelSalesPage modelSales = new ModelSalesPage(customerType,postCodeType,jCIDiscount);
		modelSales.yourBasketPage();
		return new ModelSalesAction();
	}
	public ModelSalesAction yourDetailsPage(String BillingAddrType){
		ModelSalesPage modelSales = new ModelSalesPage(customerType,postCodeType,jCIDiscount);
		modelSales.yourDetailsPage(BillingAddrType);
		return new ModelSalesAction();
	}
	public ModelSalesAction yourPaymentsDetails(ModelSalesProducts modelSalesProducts){
		ModelSalesPage modelSales = new ModelSalesPage(customerType,postCodeType,jCIDiscount);
		modelSales.yourPaymentsDetails(modelSalesProducts);
		return new ModelSalesAction();
	}
	public ModelSalesAction yourAccountSettingPage(String OAMReg){
		ModelSalesPage modelSales = new ModelSalesPage(customerType,postCodeType,jCIDiscount);
		modelSales.yourAccountSettingPage(OAMReg);
		return new ModelSalesAction();
	}
	public ModelSalesAction reviewYourOrderPage(){
		ModelSalesPage modelSales = new ModelSalesPage(customerType,postCodeType,jCIDiscount);
		modelSales.reviewYourOrderPage();
		return new ModelSalesAction();
	}
	public ModelSalesAction navigateToProductsAndServicesPage(){
		ModelSalesPage modelSales = new ModelSalesPage(customerType,postCodeType,jCIDiscount);
		modelSales.navigateToProductsAndServicesPage();
		return new ModelSalesAction();
	}
	public ModelSalesAction confirmationPage(){
		ModelSalesPage modelSales = new ModelSalesPage(customerType,postCodeType,jCIDiscount);
		modelSales.confirmationPage();
		return new ModelSalesAction();
	}
	public ModelSalesAction verifyTransactiondetails(UserProfile userProfile){
		ModelSalesPage modelSales = new ModelSalesPage(customerType,postCodeType,jCIDiscount);
		modelSales.verifyTransactiondetails(userProfile);
		return new ModelSalesAction();
	}
	public ModelSalesAction verifyAccountOverview(){
		ModelSalesPage modelSales = new ModelSalesPage(customerType,postCodeType,jCIDiscount);
		modelSales.verifyAccountOverview();
		return new ModelSalesAction();
	}
	public ModelSalesAction closingOverlay(){
		ModelSalesPage modelSales = new ModelSalesPage(customerType,postCodeType,jCIDiscount);
		modelSales.closingOverlay();
		return new ModelSalesAction();
	}

	public ModelSalesAction modelSalesFlow(int NoOfCombinations, String combinations){
		ModelSalesPage modelSales = new ModelSalesPage(customerType,postCodeType,jCIDiscount);
		modelSales.modelSalesFlow(NoOfCombinations,combinations);
		return new ModelSalesAction();
	}
	
	/*public ModelSalesAction verifyingServicesEmail(String ServicesEmail){
		CorrespondancePage cPage = new CorrespondancePage();
		cPage.verifyingServicesEmail(ServicesEmail);
		return new ModelSalesAction();
	}*/
	
	public ModelSalesAction selectProductPage(String product){
		ModelSalesPage modelSales = new ModelSalesPage(customerType,postCodeType,jCIDiscount);
		modelSales.selectProductPage(product);
		return new ModelSalesAction();
	}
	public ModelSalesAction navigateToHomecare(){
		ModelSalesPage modelSales = new ModelSalesPage(customerType,postCodeType,jCIDiscount);
		modelSales.navigateToHomecare();
		return new ModelSalesAction();
	}
	public ModelSalesAction verifyUpgrade(){
		UpsellPage upsellPage = new UpsellPage();
		upsellPage.verifyUpgrade();
		return new ModelSalesAction();
	}
	
	public ModelSalesAction verifyAccountOverviewPage(UserProfile userProfile){
		 new AccountOverviewPage().AccountOverViewVerification(userProfile);
		 return new ModelSalesAction();
	 }
	public ModelSalesAction changePremiseOfTheCustomer(){
		ModelSalesPage modelSales = new ModelSalesPage(customerType,postCodeType,jCIDiscount);
		modelSales.changePremiseOfTheCustomer();
		return new ModelSalesAction();
	}
	
	public ModelSalesAction modelSalesPricingFlow(int NoOfCombinations, String combinations){
		ModelSalesPage modelSales = new ModelSalesPage(customerType,postCodeType,jCIDiscount);
		modelSales.modelSalesFlowPricing(NoOfCombinations,combinations);
		return new ModelSalesAction();
	}
	public ModelSalesAction GAQWizardJourney(ModelSalesProducts modelSalesProducts){
		ModelSalesPage modelSales = new ModelSalesPage(customerType,postCodeType,jCIDiscount);
		modelSales.GAQWizardJourney(modelSalesProducts);
		return new ModelSalesAction();
	}
	public ModelSalesAction fulfillmentJourney(ModelSalesProducts modelSalesProducts){
		ModelSalesPage modelSales = new ModelSalesPage(customerType,postCodeType,jCIDiscount);
		modelSales.fulfillmentJourney(modelSalesProducts);
		return new ModelSalesAction();
	}
	
	
}
