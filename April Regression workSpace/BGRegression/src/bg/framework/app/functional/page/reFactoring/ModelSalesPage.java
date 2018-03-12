package bg.framework.app.functional.page.reFactoring;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.ModelSalesCombinationsProfile;
import bg.framework.app.functional.entities.ModelSalesPricing;
import bg.framework.app.functional.entities.ModelSalesProducts;
import bg.framework.app.functional.entities.PriceFinderRMR;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class ModelSalesPage extends BasePage{
	private final static String FILE_NAME = "resources/Refactoring/ModelSalesPage.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	private static boolean BoilerFlag = false;
	private static boolean CHCFlag = false;
	private static boolean PDFlag = false;
	private static boolean HECFlag = false;
	private static boolean GAKFlag = false;
	private static boolean DefaultBoilerFlag = false;
	private static boolean HC200Flag = false;
	private static boolean HC300Flag = false;
	private static boolean HC100Flag = false;
	private static boolean HC400Flag = false;
	private static boolean AnnualDDFlag = false;
	private static boolean MonthlyDDFlag = false;
	private static boolean AnnualCardFlag = false;
	private static String Product;
	private static String customerType;
	private static String contractStatus;
	private static String jCIDiscount;
	public static String addr;
	private static String FinalSelectedProduct;
	private static String MorphedProduct = null;
	ModelSalesPricing modelSalesPricing;
	private static String postCodeType;
	private static String proInBasket;
	private static String newProduct;
	private static String removeProduct;
	public static String[][] basketProducts = new String[10][2];
	DecimalFormat f = new DecimalFormat("##.00");
	float monthlyPriceInExcess = 0, yearlyPriceInExcess = 0;
	public int i , j;
	public static float TotalyearlyPrice , TotalmonthlyPrice;
	public static boolean Flag = false;
	public static boolean jCIFlag = true;
	public static boolean payFlag = false;
	public static boolean NonOAMFlag = false;
	public static String pay;
	public static float TotalKACPrice;
	public static String email;
	public static String orderDate;
	public boolean WASHERDRYER = false, WASHINGMACHINE  = false ,DISHWASHER = false ,TUMBLEDRYER = false,COOKEROWEN = false,FRIDGE = false ,
			MICROWAVE = false, HOB = false, OWEN = false;
	public boolean FRE = false , HOB1 = false , CKR = false , MWH = false , WH = false,FFR = false;
	public static float TotalPrice = 0;
	public static String process;

	public ModelSalesPage(String customerType,String postCodeType,String jCIDiscount){


		this.customerType = customerType;
		this.postCodeType = postCodeType;
		this.jCIDiscount = jCIDiscount;
	}  

	public void navigateToProductsAndServicesPage(){
		browser.open(ApplicationConfig.APP_BG_URL+"/products-and-services.html");
	}

	// navigating to homecare package
	public void navigateToHomecare(){
		browser.open(ApplicationConfig.APP_BG_URL+"/products-and-services/homecare.html");
	}

	// Selecting package
	public void selectingPackage(ModelSalesProducts modelSalesProducts){
		String Package = modelSalesProducts.getPackage();
		if(Package.contains("HomeCare")){
			browser.open(ApplicationConfig.APP_BG_URL+"/products-and-services/homecare.html");
		}
		if(Package.contains("BoilerAndHeating")){
			browser.open(ApplicationConfig.APP_BG_URL+"/products-and-services/boilers-and-central-heating/cover.html");
		}
		if(Package.contains("ApplianceCover")){
			if(modelSalesProducts.getProduct().contains("GAK")){
				browser.open(ApplicationConfig.APP_BG_URL+"/content/britishgas/products-and-services/boilers-and-central-heating/boiler-service-and-safety-checks.html");
			}
			else{
				browser.open(ApplicationConfig.APP_BG_URL+"/products-and-services/home-appliances.html");
			}
		}
		if(Package.contains("HomeElectrics")){
			browser.open(ApplicationConfig.APP_BG_URL+"/products-and-services/home-electrics.html");
		}
		if(Package.contains("PlumbingAndDrainage")){
			browser.open(ApplicationConfig.APP_BG_URL+"/products-and-services/plumbing-and-drains.html");
		}
		getHoldingComponents(modelSalesProducts);
		getHoldingProducts(modelSalesProducts);
		process = "PACKAGE : " + modelSalesProducts.getPackage();
	}

	private static BigDecimal truncateDecimal(final String x, final int numberofDecimals) {
		return new BigDecimal(x).setScale(numberofDecimals, BigDecimal.ROUND_DOWN);
	}

	//navigating to Get a Quote page
	public void navigateToGetAQuotePage(){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.getAQuoteButton"))){
			verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.getAQuoteButton"),"Get A Quote Button");
			Report.updateTestLog("Get A Quote button is clicked successfully", "Pass");
		}
		browser.wait(5000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.startQuoteButton"))){
			verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.startQuoteButton"),"Start Quote Button");
			Report.updateTestLog("Start Quote button is clicked successfully", "Pass");
		}
	}

	// selecting products 
	public void selectingProduct(ModelSalesProducts modelSalesProducts){
		if(! modelSalesProducts.getProduct().contains("GAK")){
			selectProduct(modelSalesProducts);
		}
		else{
			Report.updateTestLog("Navigated to GAK page", "Warn");
		}
	}

	// selecting Product
	public void selectProductPage(String product){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage."+product))){
			verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage."+product)," Package :" + product + " is selected");
			Report.updateTestLog("Model sales Product : " + product + " is selected successfully", "Pass");
		}
		else{
			Report.updateTestLog("Error in selecting Model sales Product : " + product  , "Fail");
		}
		// clicking upgrade button

		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.upgradeButton"))){
			verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.upgradeButton")," Upgrade Button");          
		}

		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.manageButton"))){
			verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.manageButton")," manage Account Button");
		}
		
		
	}

	// Selecting Product
	public void selectProduct(ModelSalesProducts modelSalesProducts){
		String Excess , Products , Region , Type;
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage."+modelSalesProducts.getProduct()))){
			verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage."+modelSalesProducts.getProduct())," Package :" + modelSalesProducts.getProduct() + " is selected");
			Report.updateTestLog("Model sales Product : " + modelSalesProducts.getProduct() + " is selected successfully", "Pass");
		}
		else{
			Report.updateTestLog("Error in selecting Model sales Product : " + modelSalesProducts.getProduct()  , "Fail");
		}

		// pricing verification ////
		Excess = getHighestExcessValue(modelSalesProducts);
		if ((modelSalesProducts.getProduct()).contains("KAC-1")) {
			Products = "KAC-Microwave";
		} else {
			Products = modelSalesProducts.getProduct();
		}
		if((modelSalesProducts.getProduct()).contains("GAC1") || (modelSalesProducts.getProduct()).contains("GAC2") ||
				(modelSalesProducts.getProduct()).contains("GAC3") || (modelSalesProducts.getProduct()).contains("KAC-3") || (modelSalesProducts.getProduct()).contains("KAC-5")
				|| (modelSalesProducts.getPackage()).contains("KAC-9")){
			Type = "Bundle";
		} else {
			Type = "Standalone";
		}
		if(customerType == "New" || customerType == "NON-OAM"){
			if (Flag == false) {
				Region = "OutsideM25";
				Flag = true;
			} else {
				Region = postCodeType;
			}
		}
		else {
			Region = postCodeType;
		}
		System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii" + Flag + Region + jCIFlag + NonOAMFlag + payFlag );
		float yearlyPrice = getYearlyPricing(Products,Excess,Region,Type);
		float monthlyPrice1 = (yearlyPrice)/(12); 
		BigDecimal monthlyPrice = truncateDecimal(monthlyPrice1+"", 2);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSales.proMonthlyPrice"))){
			String displayedPrice = browser.getTextByXpath(pageProperties.getProperty("ModelSales.proMonthlyPrice"));
			if (displayedPrice.contains(monthlyPrice + "")) {
				Report.updateTestLog("Prices are matched : Displayed price : "+ displayedPrice + " Expected price : " + monthlyPrice,"Pass");
			} else {
				Report.updateTestLog("Mismatch in prices : Displayed price : "+ displayedPrice + " Expected price : " + monthlyPrice,"Fail");
			}
		}

		process = process + " PRODUCT : " +modelSalesProducts.getProduct();
		//gettingFinalPricesInTheBasket();
	}

	public float getPriceValue(String Products,String Excess,String Region,String Type){
		float yearlyPrice = 0;
		String combination = Products+Excess+Region+Type;
		modelSalesPricing = new TestDataHelper().getModelSalesPricing(combination);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" + combination);
		String yearlyPrice1 = modelSalesPricing.getAnnualPrice();
		yearlyPrice = Float.valueOf(yearlyPrice1);
		System.out.println("************************" + yearlyPrice1);
		return yearlyPrice;
	}

	public float getPriceWithCampaign(float yearlyPrice , ModelSalesProducts modelSalesProducts){
		float yearlyPrice1 = 0;
		if(! (modelSalesProducts.getPackage().contains("ApplianceCover"))){
			if((customerType == "New")){
				yearlyPrice1 = (float) ((yearlyPrice) - ((yearlyPrice ) * 0) -(6));
			}
			if((customerType == "OAM")){
				if (jCIFlag == false) {
					yearlyPrice1 = (float) ((yearlyPrice) - ((yearlyPrice ) * 0) -(6));
				}
				if((jCIFlag == true) && (jCIDiscount == "OptIn")){
					yearlyPrice1 = (float) ((yearlyPrice) - ((yearlyPrice ) * 0) -(12) -(6));
				}
				if((jCIFlag == true) && (jCIDiscount == "OptOut")){
					yearlyPrice1 = (float) ((yearlyPrice) - ((yearlyPrice ) * 0) -(6));
				}
			}
			if((customerType == "NON-OAM")){
				if(NonOAMFlag == false){
					yearlyPrice1 = (float) ((yearlyPrice) - ((yearlyPrice ) * 0) -(6));
				}
				if(NonOAMFlag == true){
					if (jCIFlag == false) {
						yearlyPrice1 = (float) ((yearlyPrice) - ((yearlyPrice ) * 0) -(6));
					}
					if((jCIFlag == true) && (jCIDiscount == "OptIn")){
						yearlyPrice1 = (float) ((yearlyPrice) - ((yearlyPrice ) * 0) -(12) -(6));
					}
					if((jCIFlag == true) && (jCIDiscount == "OptOut")){
						yearlyPrice1 = (float) ((yearlyPrice) - ((yearlyPrice ) * 0) -(6));
					}
				}
			}
		}
		else{
			yearlyPrice1 = yearlyPrice;
		}
		return yearlyPrice1;
	}


	// verifing yearly and monthly pricing ////
	public float getYearlyPricing(String Products,String Excess,String Region,String Type){
		float yearlyPrice = 0;
		String combination = Products+Excess+Region+Type;
		if ((customerType == "New")) {
			modelSalesPricing = new TestDataHelper().getModelSalesPricing(combination);
			String yearlyPrice1 = modelSalesPricing.getAnnualPrice();
			yearlyPrice = getCalculatedYearlyPrice(yearlyPrice1, Products ,modelSalesPricing.getCompaign());
		}
		if ((customerType == "OAM")) {
			modelSalesPricing = new TestDataHelper().getModelSalesPricing(combination);
			String yearlyPrice1 = modelSalesPricing.getAnnualPrice();
			yearlyPrice = getCalculatedYearlyPrice(yearlyPrice1, Products, modelSalesPricing.getCompaign());
			if (jCIFlag == false) {
				yearlyPrice = yearlyPrice;
			}
			if((jCIFlag == true) && (jCIDiscount == "OptIn")){
				yearlyPrice = yearlyPrice - (12);
			}
			if((jCIFlag == true) && (jCIDiscount == "OptOut")){
				yearlyPrice = yearlyPrice;
			}
		}
		if((customerType == "NON-OAM")){
			modelSalesPricing = new TestDataHelper().getModelSalesPricing(combination);
			String yearlyPrice1 = modelSalesPricing.getAnnualPrice();
			if(NonOAMFlag == false){
				yearlyPrice = getCalculatedYearlyPrice(yearlyPrice1, Products ,modelSalesPricing.getCompaign());
			}
			if(NonOAMFlag == true){
				yearlyPrice = getCalculatedYearlyPrice(yearlyPrice1, Products, modelSalesPricing.getCompaign());
				if (jCIFlag == false) {
					yearlyPrice = yearlyPrice;
				}
				if((jCIFlag == true) && (jCIDiscount == "OptIn")){
					yearlyPrice = yearlyPrice - (12);
				}
				if((jCIFlag == true) && (jCIDiscount == "OptOut")){
					yearlyPrice = yearlyPrice;
				}
			}
		}

		return yearlyPrice;
	}

	// getting pricing after calculation
	public float getCalculatedYearlyPrice(String yearlyPrice, String Products,float Compaign){
		float yearlyPrc = 0;
		if(Products.contains("Homecare100") || Products.contains("Homecare200") || Products.contains("Homecare300") || Products.contains("Homecare400") ||  
				Products.contains("BoilerAndControl")  || Products.contains("centralHeating")){
			if (payFlag == true) {
				if(pay.contains("AnnualCard")){
					float YearlyPrice1 = Float.valueOf(yearlyPrice);
					yearlyPrc = (float) (YearlyPrice1 - (YearlyPrice1 * (Compaign)));
				} else {
					float YearlyPrice1 = Float.valueOf(yearlyPrice);
					yearlyPrc = (float) ((YearlyPrice1) - ((YearlyPrice1 ) * (Compaign)) -(6));
				}
			}
			else if(payFlag == false) {
				float YearlyPrice1 = Float.valueOf(yearlyPrice);
				yearlyPrc = (float) ((YearlyPrice1) - ((YearlyPrice1 ) * (Compaign)) -(6));
			}
		}
		else if(Products.contains("GAK")){
			float YearlyPrice1 = Float.valueOf(yearlyPrice);
			yearlyPrc = (float) (YearlyPrice1);
		}
		else{
			if (payFlag == true) {
				if (pay.contains("AnnualCard")) {
					float YearlyPrice1 = Float.valueOf(yearlyPrice);
					yearlyPrc = (float) (YearlyPrice1 - (YearlyPrice1 * (Compaign)));
				} else {
					float YearlyPrice1 = Float.valueOf(yearlyPrice);
					yearlyPrc = (float) ((YearlyPrice1) - ((YearlyPrice1 ) * (Compaign)));
				}
			} else if (payFlag == false) {
				float YearlyPrice1 = Float.valueOf(yearlyPrice);
				yearlyPrc = (float) ((YearlyPrice1) - ((YearlyPrice1) * (Compaign)));
			}
		}
		return yearlyPrc;
	}

	//Getting Primary Address from account overview
	public void gettingPrimaryAddr(){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.getAcctAddress"))){
			String address = browser.getTextByXpath(pageProperties.getProperty("ModelSalesPage.getAcctAddress"));
			String postCode = browser.getTextByXpath(pageProperties.getProperty("ModelSalesPage.getAcctPostcode"));
			addr = address + postCode ;
			Report.updateTestLog("Primary Addr of the customer is :" +addr , "Pass");
		}
		else{
			Report.updateTestLog("Primary Addr of the customer is not displayed", "Fail");
		}
	}



	//Entering Post code
	public void enteringPostCode(String postCode,ModelSalesProducts modelSalesProducts){
		if( customerType == "OAM"){
			//String text = browser.getTextByXpath(".//*[@id='servicesAlreadySupplied']/div[1]/div/div/div/div/div/div/div[3]/p[2]/span");
			if(browser.isElementVisibleWithXpath(".//*[@id='servicesAlreadySupplied']/div[1]/div/div/div/div/div/div/div[3]/p[2]/span")){
				for (int k =0 ; k <=11 ; k++){
					verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.ServiceOverlay"),"Service already provided overlay");         
					verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.changeAddrLink"),"Change Address Link");
					if (browser.isElementVisible(pageProperties.getProperty("ModelSalesPage.addressDropDown"))) {
						Select select = new Select(
								browser.getElementByID(pageProperties.getProperty("ModelSalesPage.addressDropDown")));
						select.selectByIndex(new Random().nextInt(1 + k));
						Report.updateTestLog("Address Selected from Dropdown", "Pass");
						nextButton();
					}
					if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.addressSelected"))){
						break;
					}
				}
				verifyingAddressSelected(modelSalesProducts);
			}
			else{
				verifyingPostalAddress(modelSalesProducts);
			}
		}
		else if((customerType == "New")){
			enterAndSelectaddress(postCode,modelSalesProducts);
			String text = browser.getTextByXpath(".//*[@id='continue']");
			if(browser.isElementVisibleWithXpath(".//*[@id='continue']")){
				for (int k = 0 ; k <=11 ; k++){
					verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.ServiceOverlay"),"Service already provided overlay");         
					verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.changeAddrLink"),"Change Address Link");
					if (browser.isElementVisible(pageProperties.getProperty("ModelSalesPage.addressDropDown"))) {
						Select select = new Select(browser.getElementByID(pageProperties.getProperty("ModelSalesPage.addressDropDown")));
						select.selectByIndex(new Random().nextInt(1 + k));
						Report.updateTestLog("Address Selected from Dropdown", "Pass");
						nextButton();
					}
					if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.addressSelected"))) {
						break;
					}
				}
			}
			else {
				System.out.println("******************************************* text " + text);
				if (browser.isElementVisible(pageProperties.getProperty("ModelSalesPage.addressDropDown"))) {
					Select select = new Select(browser.getElementByID(pageProperties.getProperty("ModelSalesPage.addressDropDown")));
					select.selectByIndex(new Random().nextInt(10));
					Report.updateTestLog("Address Selected from Dropdown", "Pass");
					nextButton();
				}

			}
			verifyingAddressSelected(modelSalesProducts);

		}

		process = process + " POSTCODE : " + postCode + " POSTCODE REGION : " + postCodeType;

	}

	public void enterAndSelectAddress(String PostCode , String Address ,ModelSalesProducts modelSalesProducts){
		if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.PostCode"))) {
			verifyAndInputByXpath(pageProperties.getProperty("ModelSalesPage.PostCode"),"Post Code", PostCode);
			verifyAndClick(pageProperties.getProperty("ModelSalesPage.FindButton"),"Find Button");
			browser.dynamicWaituntilClickablebyID(pageProperties.getProperty("ModelSalesPage.addressDropDown"));
		}
		if(browser.isElementVisible(pageProperties.getProperty("ModelSalesPage.addressDropDown"))){
			verifyAndSelectDropDownBox(pageProperties.getProperty("ModelSalesPage.addressDropDown"), "Address", Address);
			//browser.wait(7000);
			nextButton();
			browser.wait(5000);
		}
		verifyingPostalAddress(modelSalesProducts);
		process = process + " POSTCODE : " + PostCode + " POSTCODE REGION : " + postCodeType + " Address : " + Address;
	}

	// entering postCode and address

	public void enterAndSelectaddress(String postCode,ModelSalesProducts modelSalesProducts){
		if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.PostCode"))) {
			verifyAndInputByXpath(pageProperties.getProperty("ModelSalesPage.PostCode"),"Post Code", postCode);
			verifyAndClick(pageProperties.getProperty("ModelSalesPage.FindButton"),"Find Button");
			browser.dynamicWaituntilClickablebyID(pageProperties.getProperty("ModelSalesPage.addressDropDown"));
		}
		if (browser.isElementVisible(pageProperties.getProperty("ModelSalesPage.addressDropDown"))) {
			Select select = new Select(
					browser.getElementByID(pageProperties.getProperty("ModelSalesPage.addressDropDown")));
			select.selectByIndex(new Random().nextInt(10));
			Report.updateTestLog("Address Selected from Dropdown", "Pass");
			nextButton();
		}
	}


	public void verifyingAddressSelected(ModelSalesProducts modelSalesProducts){
		browser.dynamicWaituntilVisiblebyXpath(pageProperties.getProperty("ModelSalesPage.addressSelected"));
		if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.addressSelected"))) {
			String addrSelected = browser.getTextByXpath(pageProperties.getProperty("ModelSalesPage.addressSelected"));
			Report.updateTestLog("Selected Address: " + addrSelected+ " is displayed", "Pass");
		} else {
			Report.updateTestLog("Selected Address is not displayed","Fail");
		}
		pricingInPersonalisePage(modelSalesProducts);
		nextButton();
	}

	// verifying pricing in the personalise page

		String Type;
		public void pricingInPersonalisePage(ModelSalesProducts modelSalesProducts){
		String Excess = getHighestExcessValue(modelSalesProducts);
		String Product = modelSalesProducts.getProduct();
		if((modelSalesProducts.getProduct()).contains("GAC1") || (modelSalesProducts.getProduct()).contains("GAC2") ||
				(modelSalesProducts.getProduct()).contains("GAC3") || (modelSalesProducts.getProduct()).contains("KAC-3") || (modelSalesProducts.getProduct()).contains("KAC-5")
				|| (modelSalesProducts.getPackage()).contains("KAC-9")){
			Type = "Bundle";
		}
		else{
			Type = "Standalone";
		}
		if((modelSalesProducts.getProduct()).contains("KAC-1")){
			Product = "KAC-Microwave";
		}
		float yearlyPrice1 = getYearlyPricing(Product, Excess, postCodeType,Type);
		float monthlyPrice1 = (yearlyPrice1) / (12);
		BigDecimal yearlyPrice = truncateDecimal(yearlyPrice1+"", 2);
		BigDecimal monthlyPrice = truncateDecimal(monthlyPrice1+"", 2);
		///////// verifying monthly pricing ////////////
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.MonthlyPrice"))){
			String displayedMonthlyPrice = browser.getTextByXpath(pageProperties.getProperty("ModelSalesPage.MonthlyPrice"));
			if (displayedMonthlyPrice.contains(monthlyPrice + "")) {
				Report.updateTestLog("Monthly Prices in Personalise page are matched : Displayed price : " + displayedMonthlyPrice+ " Expected price : " + monthlyPrice,"Pass");
			} else {
				Report.updateTestLog("Monthly Prices Mismatch in Personalise page : Displayed price : " + displayedMonthlyPrice + " Expected price : " + monthlyPrice,"Fail");
			}
		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.YearlyPrice"))){
			String displayedYearlyPrice = browser.getTextByXpath(pageProperties.getProperty("ModelSalesPage.YearlyPrice"));
			if (displayedYearlyPrice.contains(yearlyPrice + "")) {
				Report.updateTestLog("Yearly Prices in Personalise page are matched : Displayed price : "+ displayedYearlyPrice + " Expected price : " + yearlyPrice,"Pass");
			} else {
				Report.updateTestLog("Yearly Prices Mismatch in Personalise page : Displayed price : "+ displayedYearlyPrice + " Expected price : " + yearlyPrice,"Fail");
			}
		}
	}
	// clicking next button
	public void nextButton(){
		verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.NextButton"),"Next Button");
	}
	// verifying Postal Address
	public void verifyingPostalAddress(ModelSalesProducts modelSalesProducts){
		if(jCIDiscount == "OptOut"){
			verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.jCIDiscount"), "JCI Discount OptOut");
		}
		pricingInPersonalisePage(modelSalesProducts);
		/*           }*/
		nextButton();

	}

	// selecting excess
	public void selectingExcess(ModelSalesProducts modelSalesProducts){
		browser.wait(5000);
		if(modelSalesProducts.getProduct().contains("GAK")){
			Report.updateTestLog("Excess section is not available for GAK", "Pass");
		}
		else{
			selectingExcessOfProducts(modelSalesProducts);
		}
		browser.wait(5000);

	}
	// selecting components excess
	public void selectingExcessOfProducts(ModelSalesProducts modelSalesProducts){
		if(((modelSalesProducts.getProduct()).contains("Homecare100")) || ((modelSalesProducts.getProduct()).contains("BoilerAndControl"))){
			selectBoilerExcess(modelSalesProducts);
		}
		else if(((modelSalesProducts.getProduct()).contains("Homecare200")) || ((modelSalesProducts.getProduct()).contains("centralHeating"))){
			selectCHCExcess(modelSalesProducts);
		}
		else if((modelSalesProducts.getProduct()).contains("Homecare300")){
			selectCHCExcess(modelSalesProducts);
			selectPDExcess(modelSalesProducts);
		}
		else if((modelSalesProducts.getProduct()).contains("Homecare400")){
			selectCHCExcess(modelSalesProducts);
			selectPDExcess(modelSalesProducts);
			selectHCEExcess(modelSalesProducts);
		}
		else if((modelSalesProducts.getProduct()).contains("PlumbingAndDrains")){
			selectPDExcess(modelSalesProducts);
		}
		else if((modelSalesProducts.getProduct()).contains("HomeElectrical")){
			selectHCEExcess(modelSalesProducts);
		}
		else if((modelSalesProducts.getPackage().contains("ApplianceCover"))){
			nextButton();
			browser.wait(5000);
			selectKACandGACExcess(modelSalesProducts);
		}              
		browser.wait(15000);
		verifyPricingInExcessPage(modelSalesProducts);
		nextButton();
	}

	// selecting boiler and control excess
	public void selectBoilerExcess(ModelSalesProducts modelSalesProducts){
		browser.wait(5000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.boilerDropDownBox"))){
			verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("ModelSalesPage.boilerDropDownBox"), "Boiler drop down",(modelSalesProducts.getBoilerAndControl()).replace("Excess", "£"));
			Report.updateTestLog("Boiler and Control Cover Excess :" +modelSalesProducts.getBoilerAndControl()+ " is selected from dropdown box", "Pass");
		}
		else{
			Report.updateTestLog("Boiler and Control Cover Excess :" +modelSalesProducts.getBoilerAndControl()+ " is not present in an application", "Fail");
		}
	}

	// selecting central heating cover excess
	public void selectCHCExcess(ModelSalesProducts modelSalesProducts){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.CHCDropDownBox"))){
			verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("ModelSalesPage.CHCDropDownBox"), "CHC drop down",(modelSalesProducts.getCentralHeating()).replace("Excess", "£"));
			Report.updateTestLog("Central Heating Cover Excess :" +modelSalesProducts.getCentralHeating()+ " is selected from dropdown box", "Pass");
		}
		else{
			Report.updateTestLog("Central Heating Cover Excess :" +modelSalesProducts.getCentralHeating()+ " is not present in an application", "Fail");
		}

		process = process + " CHC Excess : " + modelSalesProducts.getCentralHeating();
	}

	// selecting plumbing and Drains excess
	public void selectPDExcess(ModelSalesProducts modelSalesProducts){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.PDDropDownBox"))){
			verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("ModelSalesPage.PDDropDownBox"), "Plumbing and drain drop down",(modelSalesProducts.getPlumbingDrains()).replace("Excess", "£"));
			Report.updateTestLog("Plumbing and drain Excess :" +modelSalesProducts.getPlumbingDrains()+ " is selected from dropdown box", "Pass");
		}
		else{
			Report.updateTestLog("Plumbing and drain Excess :" +modelSalesProducts.getPlumbingDrains()+ " is not present in an application", "Fail");
		}

		process = process + " PD Excess : " + modelSalesProducts.getPlumbingDrains();
	}

	// selecting Home electrics excess
	public void selectHCEExcess(ModelSalesProducts modelSalesProducts){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.HomeElecDropDownBox"))){
			verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("ModelSalesPage.HomeElecDropDownBox"), "Home elctrics drop down",(modelSalesProducts.getHomeElectrical()).replace("Excess", "£"));
			Report.updateTestLog("Home Electrical Excess :" +modelSalesProducts.getHomeElectrical()+ " is selected from dropdown box", "Pass");
		}
		else{
			Report.updateTestLog("Home Electrical Excess :" +modelSalesProducts.getHomeElectrical()+ " is not present in an application", "Fail");
		}

		process = process + " HEC Excess : " + modelSalesProducts.getHomeElectrical();

	}
	// selecting Excess
	public void selectKACandGACExcess(ModelSalesProducts modelSalesProducts){
		if((modelSalesProducts.getProduct().contains("KAC-5")) || (modelSalesProducts.getProduct().contains("KAC-9")) || (modelSalesProducts.getProduct().contains("KAC-3")) ){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.Excess"))){
				verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("ModelSalesPage.Excess"),"KAC Excess drop down",(modelSalesProducts.getExcess()).replace("Excess", "£"));
				Report.updateTestLog(modelSalesProducts.getPackage() +" Excess :" + modelSalesProducts.getExcess() + " is selected from dropdown box", "Pass");
			}
			else{
				Report.updateTestLog(modelSalesProducts.getPackage() +" Excess :" + modelSalesProducts.getExcess() + " is not present in an application", "Fail");
			}
		}
		process = process + " APPLIANCE Exces : " + modelSalesProducts.getExcess();
	}
	// entering Boiler Details
	public void enteringBoilerDetails(ModelSalesProducts modelSalesProducts){
		if((modelSalesProducts.getPackage()).contains("ApplianceCover")){
			if(!modelSalesProducts.getProduct().contains("GAK")){
				System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
				enterKACandGACApplianceDetails(modelSalesProducts);
				enterKACAndGACMakeDetails(modelSalesProducts);    
			}
			else{
				enterBoilerDetails();
			}
		}
		else{
			enterBoilerDetails();
		}
	}

	public void enterBoilerDetails(){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.BoilerType"))){
			browser.wait(5000);
			verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("ModelSalesPage.BoilerType"),"Boiler Type","Warm Air Unit");
			browser.wait(5000);
			verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("ModelSalesPage.BoilerMake"),"Boiler Make","I don't know");
			browser.wait(7000);                                                                                      
			verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("ModelSalesPage.BoilerModel"),"Boiler Model","I don't know");
			browser.wait(5000);
			verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("ModelSalesPage.BoilerAge"),"Boiler Age","3");
			nextButton();
		}
	}

	public void enterAppliancesDetails(){
		browser.wait(5000);
		Select select = new Select(browser.getElementByXpath(pageProperties.getProperty("ModelSalesPage.BoilerMake")));
		select.selectByIndex(0);  
		browser.wait(5000);
		Select select1 = new Select(browser.getElementByXpath(pageProperties.getProperty("ModelSalesPage.BoilerModel")));
		select1.selectByIndex(0);
		browser.wait(5000);
		Select select2 = new Select(browser.getElementByXpath(pageProperties.getProperty("ModelSalesPage.BoilerAge")));
		select2.selectByIndex(0);
		browser.wait(5000);
		nextButton();
	}


	// entering KAC and GAC make details
	public void enterKACAndGACMakeDetails(ModelSalesProducts modelSalesProducts){
		if((modelSalesProducts.getProduct()).contains("KAC-1") || (modelSalesProducts.getProduct()).contains("GAC1")){
			for(int i=0 ; i<1; i++){
				enterAppliancesDetails();
			}
		}
		if((modelSalesProducts.getProduct()).contains("KAC-3") || (modelSalesProducts.getProduct()).contains("GAC3")){
			for(int i=0 ; i<3; i++){
				enterAppliancesDetails();
			}
		}
		if((modelSalesProducts.getProduct()).contains("GAC2")){                           
			for(int i=0 ; i<2; i++){
				enterAppliancesDetails();
			}
		}
		if((modelSalesProducts.getProduct()).contains("KAC-5")){                          
			for(int i=0 ; i<5; i++){
				enterAppliancesDetails();
			}
		}
		if((modelSalesProducts.getProduct()).contains("KAC-9")){
			for(int i=0 ; i<9; i++){
				enterAppliancesDetails();
			}
		}
	}

	/// entering KAC and GAC appliances 
	public void enterKACandGACApplianceDetails(ModelSalesProducts modelSalesProducts){
		String applianceNum;
		if((modelSalesProducts.getProduct()).contains("KAC-1")){
			for(int i=0 ; i<1; i++){
				applianceNum = "1";
				enterKACAppliances(modelSalesProducts,applianceNum, i+"");
			}
		}
		if((modelSalesProducts.getProduct()).contains("KAC-3")){
			applianceNum = "3";
			for(int i=0 ; i<3; i++){
				enterKACAppliances(modelSalesProducts,applianceNum, i+"");
			}
			verifyKACOptimizationLogic(TotalPrice,modelSalesProducts);
			nextButton();
		}
		if((modelSalesProducts.getProduct()).contains("KAC-5")){
			applianceNum = "5";
			for(int i=0 ; i<5; i++){
				enterKACAppliances(modelSalesProducts,applianceNum, i+"");
			}
			verifyKACOptimizationLogic(TotalPrice,modelSalesProducts);
			nextButton();
		}
		if((modelSalesProducts.getProduct()).contains("KAC-9")){
			applianceNum = "9";
			for(int i=0 ; i<9; i++){
				enterKACAppliances(modelSalesProducts,applianceNum, i+"");
			}
			verifyKACOptimizationLogic(TotalPrice,modelSalesProducts);
			nextButton();
		}
		if((modelSalesProducts.getProduct()).contains("GAC1")){
			for(int i=0 ; i<1; i++){
				System.out.println("ggggggggggggggggggggggggggggggggggggggggggggg");
				applianceNum = "1";
				enterGACAppliances(modelSalesProducts,applianceNum, i+"");
			}
		}
		if((modelSalesProducts.getProduct()).contains("GAC2")){
			System.out.println("ggggggggggggggggggggggggggggggggggggggggggggg");
			applianceNum = "2";
			for(int i=0 ; i<2; i++){
				enterGACAppliances(modelSalesProducts,applianceNum, i+"");
			}
			nextButton();
		}
		if((modelSalesProducts.getProduct()).contains("GAC3")){
			applianceNum = "3";
			for(int i=0 ; i<3; i++){
				enterGACAppliances(modelSalesProducts,applianceNum, i+"");
			}
			nextButton();
		}
	}

	// Selecting KAC appliances 
	public void enterKACAppliances(ModelSalesProducts modelSalesProducts,String applianceNum, String row){
		System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
		String product; 
		String Region = postCodeType; 
		String Excess = modelSalesProducts.getExcess();
		String Type = "Standalone"; 
		float price = 0;
		if((modelSalesProducts.getWashingDryer()).equalsIgnoreCase("yes") && WASHERDRYER == false){
			System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk 1");
			verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("ModelSalesPage.KACProducts").replace("appliNum",applianceNum).replace("row", row), "KACProduct", "Combined washer dryer");             
			WASHERDRYER = true;
			product = "KAC-WashingDryer";
			price = getYearlyPricing(product,Excess,Region,Type);   
			process = process + " KAC Products : " + product;
		}
		else if((modelSalesProducts.getWashingMachine()).equalsIgnoreCase("yes") && WASHINGMACHINE  == false){
			System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk 2"); 
			verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("ModelSalesPage.KACProducts").replace("appliNum",applianceNum).replace("row", row), "KACProduct", "Washing machine");           
			WASHINGMACHINE  = true;
			product = "KAC-WashingMachine";
			price = getYearlyPricing(product,Excess,Region,Type);   
			process = process + " KAC Products : " + product;
		}
		else if((modelSalesProducts.getDishwasher()).equalsIgnoreCase("yes") && DISHWASHER == false){
			System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk 3"); 
			verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("ModelSalesPage.KACProducts").replace("appliNum",applianceNum).replace("row", row), "KACProduct", "Dishwasher");       
			DISHWASHER = true;
			product = "KAC-Dishwasher";
			price = getYearlyPricing(product,Excess,Region,Type);
			process = process + " KAC Products : " + product;
		}
		else if((modelSalesProducts.getTumbleDryer()).equalsIgnoreCase("yes") && TUMBLEDRYER == false){
			System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk 4"); 
			verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("ModelSalesPage.KACProducts").replace("appliNum",applianceNum).replace("row", row), "KACProduct", "Tumble dryer");   
			TUMBLEDRYER = true;
			product = "KAC-TumbleDryer";
			price = getYearlyPricing(product,Excess,Region,Type);   
		}
		else if((modelSalesProducts.getCooker()).equalsIgnoreCase("yes") && COOKEROWEN == false){
			System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk 5"); 
			verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("ModelSalesPage.KACProducts").replace("appliNum",applianceNum).replace("row", row), "KACProduct", "Free standing gas cooker");            
			COOKEROWEN = true;
			product = "KAC-Cooker";
			price = getYearlyPricing(product,Excess,Region,Type);   
			process = process + " KAC Products : " + product;
		}
		else if((modelSalesProducts.getFridge()).equalsIgnoreCase("yes") && FRIDGE == false){
			System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk 6"); 
			verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("ModelSalesPage.KACProducts").replace("appliNum",applianceNum).replace("row", row), "KACProduct", "Fridge");  
			FRIDGE = true;
			product = "KAC-Fridge";
			price = getYearlyPricing(product,Excess,Region,Type);   
		}
		else if((modelSalesProducts.getMicrowave()).equalsIgnoreCase("yes") && MICROWAVE == false){
			System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk 7"); 
			verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("ModelSalesPage.KACProducts").replace("appliNum",applianceNum).replace("row", row), "KACProduct", "Microwave");        
			MICROWAVE = true;
			product = "KAC-Microwave";
			price = getYearlyPricing(product,Excess,Region,Type);   
			process = process + " KAC Products : " + product;
		}
		else if((modelSalesProducts.getHob()).equalsIgnoreCase("yes") && HOB == false){
			System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk 8"); 
			verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("ModelSalesPage.KACProducts").replace("appliNum",applianceNum).replace("row", row), "KACProduct", "Built in hob");        
			HOB = true;
			product = "KAC-Hob";
			price = getYearlyPricing(product,Excess,Region,Type);   
		}
		else if((modelSalesProducts.getOven()).equalsIgnoreCase("yes") && OWEN == false){
			System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk 9"); 
			verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("ModelSalesPage.KACProducts").replace("appliNum",applianceNum).replace("row", row), "KACProduct", "Built in oven");     
			OWEN = true;
			product = "KAC-Oven";
			price = getYearlyPricing(product,Excess,Region,Type);   
			process = process + " KAC Products : " + product;
		}
		else if((modelSalesProducts.getFridgeFreezer()).equalsIgnoreCase("yes") && FFR == false){
			System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk 9"); 
			verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("ModelSalesPage.KACProducts").replace("appliNum",applianceNum).replace("row", row), "KACProduct", "Fridge-freezer");     
			FFR = true;
			product = "KAC-Oven";
			price = getYearlyPricing(product,Excess,Region,Type);   
			process = process + " KAC Products : " + product;
		}
		TotalPrice = TotalPrice + price;
		System.out.println("hhhhhKACTotalPrice" + TotalPrice);
		price = Float.parseFloat(f.format(price));
	}

	public void verifyKACOptimizationLogic(float TotalPrice,ModelSalesProducts modelSalesProducts){
		if(modelSalesProducts.getProduct().contains("KAC-1")){
			TotalKACPrice = TotalPrice;
		}
		if(modelSalesProducts.getProduct().contains("KAC-3")){
			float BundlePrice = getYearlyPricing("KAC-3",modelSalesProducts.getExcess(),postCodeType,"Bundle");
			if(TotalPrice < BundlePrice){
				TotalKACPrice = TotalPrice;
			}
			else{
				TotalKACPrice = BundlePrice;
			}
			System.out.println("hhhhhKACTotalPrice" + TotalPrice + BundlePrice);
		}
		if(modelSalesProducts.getProduct().contains("KAC-5")){
			float BundlePrice = getYearlyPricing("KAC-5",modelSalesProducts.getExcess(),postCodeType,"Bundle");
			if(TotalPrice < BundlePrice){
				TotalKACPrice = TotalPrice;
			}
			else{
				TotalKACPrice = BundlePrice;
			}
		}
		if(modelSalesProducts.getProduct().contains("KAC-9")){
			float BundlePrice = getYearlyPricing("KAC-9",modelSalesProducts.getExcess(),postCodeType,"Bundle");
			if(TotalPrice < BundlePrice){
				TotalKACPrice = TotalPrice;
			}
			else{
				TotalKACPrice = BundlePrice;
			}
		}              
	}

	// Selecting GAC appliances
	public void enterGACAppliances(ModelSalesProducts modelSalesProducts,String applianceNum, String row){
		if((modelSalesProducts.getGasFire()).equalsIgnoreCase("yes") && FRE == false){
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1" + pageProperties.getProperty("ModelSalesPage.GACProducts").replace("appliNum",applianceNum).replace("row", row));
			verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("ModelSalesPage.GACProducts").replace("appliNum",applianceNum).replace("row", row), "GACProduct", "Gas Fire");             
			FRE = true;
			process = process + " GAC Products : Gas Fire";
		}
		else if((modelSalesProducts.getGasHob()).equalsIgnoreCase("yes") && HOB1 == false){
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa2");
			verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("ModelSalesPage.GACProducts").replace("appliNum",applianceNum).replace("row", row), "GACProduct", "Gas Hob");             
			HOB = true;
			process = process + " GAC Products : Gas Hob";
		}
		else if((modelSalesProducts.getCookerFreestanding()).equalsIgnoreCase("yes") && CKR == false){
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa3");
			verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("ModelSalesPage.GACProducts").replace("appliNum",applianceNum).replace("row", row), "GACProduct", "Cooker (gas) freestanding");         
			CKR = true; 
			process = process + " GAC Products : Cooker (gas) freestanding";
		}
		else if((modelSalesProducts.getMultipointWterHeater()).equalsIgnoreCase("yes") && MWH == false){
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa4");
			verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("ModelSalesPage.GACProducts").replace("appliNum",applianceNum).replace("row", row), "GACProduct", "Multipoint water heater");             
			MWH = true;
			process = process + " GAC Products : Multipoint water heater";
		}
		else if((modelSalesProducts.getWaterHeater()).equalsIgnoreCase("yes") && WH == false){
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa5");
			verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("ModelSalesPage.GACProducts").replace("appliNum",applianceNum).replace("row", row), "GACProduct", "Water Heater");  
			WH = true;
			process = process + " GAC Products : Water Heater";
		}
	}
	// select payment option
	public void selectingPaymentOption(ModelSalesProducts modelSalesProducts,String productConflictType){
		browser.wait(5000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.changePayOption"))){
			verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.changePayOption"),"Change payment Option");
		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage."+modelSalesProducts.getPayment()))){
			verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage."+modelSalesProducts.getPayment()),"Payment Option");
			Report.updateTestLog("Payment option : " +modelSalesProducts.getPayment() + "is selected successfully" , "Pass");
			pay = modelSalesProducts.getPayment();
		}
		else {
			Report.updateTestLog("Error in selecting payment options","Fail");
		}
		payFlag = true;
		pay = modelSalesProducts.getPayment();
		process = process + " PAYMENT TYPE : " + modelSalesProducts.getPayment();
		browser.wait(15000);
		PricingPaymentPage(modelSalesProducts);
		verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.addToBasket"),"Add To Basket");
		AddToBasket(modelSalesProducts,productConflictType);
		if(jCIDiscount == "OptIn"){
		jCIFlag = false;
		}
	}

	// Pricing in payment page 

	public void PricingPaymentPage(ModelSalesProducts modelSalesProducts){
		if(modelSalesProducts.getProduct().contains("KAC-1") || modelSalesProducts.getProduct().contains("KAC-3") || modelSalesProducts.getProduct().contains("KAC-5") ||
				modelSalesProducts.getProduct().contains("KAC-9")){
			TotalyearlyPrice = TotalPrice;
		}
		else{
			TotalyearlyPrice = getPricingInExcessPage(modelSalesProducts);
		}
		TotalmonthlyPrice = (TotalyearlyPrice)/(12);
		System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj" + TotalyearlyPrice + TotalmonthlyPrice);
		BigDecimal yearlyPrice = truncateDecimal(TotalyearlyPrice+"", 2);
		BigDecimal monthlyPrice = truncateDecimal(TotalmonthlyPrice+"", 2);  
		System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj" + TotalyearlyPrice + TotalmonthlyPrice);
		System.out.println("pppppppppppppppppppppppppppppppppppppppppp" + monthlyPrice + yearlyPrice);

		if((modelSalesProducts.getPayment()).contains("AnnualDD")){
			String displayedYearlyPrice = browser.getTextByXpath(pageProperties.getProperty("ModelSalesPage.YearlyPrice"));
			if(displayedYearlyPrice.contains(yearlyPrice+"")){
				Report.updateTestLog("Yearly Prices in payment page are matched : Displayed price : " + displayedYearlyPrice + " Expected price : " + yearlyPrice , "Pass");
			}
			else{
				Report.updateTestLog("Yearly Prices Mismatch in payment page : Displayed price : " + displayedYearlyPrice + " Expected price : " + yearlyPrice , "Fail");
			}
		}
		else if((modelSalesProducts.getPayment()).contains("MonthlyDD")){
			String displayedMonthlyPrice = browser.getTextByXpath(pageProperties.getProperty("ModelSalesPage.MonthlyPrice"));
			String displayedYearlyPrice = browser.getTextByXpath(pageProperties.getProperty("ModelSalesPage.YearlyPrice"));
			if(displayedYearlyPrice.contains(yearlyPrice+"")){
				Report.updateTestLog("Yearly Prices in payment page are matched : Displayed price : " + displayedYearlyPrice + " Expected price : " + yearlyPrice , "Pass");
			}
			else{
				Report.updateTestLog("Yearly Prices Mismatch in payment page : Displayed price : " + displayedYearlyPrice + " Expected price : " + yearlyPrice , "Fail");
			}
			if(displayedMonthlyPrice.contains(monthlyPrice+"")){
				Report.updateTestLog("Monthly Prices in payment page are matched : Displayed price : " + displayedMonthlyPrice + " Expected price : " + monthlyPrice , "Pass");
			}
			else{
				Report.updateTestLog("Monthly Prices Mismatch in payment page : Displayed price : " + displayedMonthlyPrice + " Expected price : " + monthlyPrice , "Fail");
			}
		}
		else if((modelSalesProducts.getPayment()).contains("AnnualCard")){
			String displayedYearlyPrice = browser.getTextByXpath(pageProperties.getProperty("ModelSalesPage.YearlyPrice"));
			if(displayedYearlyPrice.contains(yearlyPrice+"")){
				Report.updateTestLog("Yearly Prices in payment page are matched : Displayed price : " + displayedYearlyPrice + " Expected price : " + yearlyPrice , "Pass");
			}
			else{
				Report.updateTestLog("Yearly Prices Mismatch in payment page : Displayed price : " + displayedYearlyPrice + " Expected price : " + yearlyPrice , "Fail");
			}
		}

	}

	//Add to basket overlay
	public void addToBasketOverlay(){
		browser.dynamicWaituntilClickablebyXpath(pageProperties.getProperty("ModelSalesPage.ProceedToCheckOut"));
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.ProceedToCheckOut"))){                
			System.out.println("oooooooooooooooooooooooooooooooooooooooooooooo      add basket");
			browser.clickWithXpath(pageProperties.getProperty("ModelSalesPage.ProceedToCheckOut"));
			Report.updateTestLog("Proceed To Checkout Button is clicked Successfully", "Pass");
		}
		else{
			Report.updateTestLog("Proceed To Checkout Button is not present in the application", "Fail");
		}
	}
   
	//Your Basket Page
	public void yourBasketPage(){
		verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.termsAndConditions"),"Terms And Conditions");
		verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.assumptions"),"Assumption terms");
		verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.proceedToCheckoutPage"),"Proceed To Checkout Page");
	}

	// your details page

	public void yourDetailsPage(String BillingAddrType){
		if(BillingAddrType == "Diff Addr"){
			verifyAndClick(pageProperties.getProperty("ModelSalesPage.BillingAddrCheck"),"Billing Address Check box");
			verifyAndInputById(pageProperties.getProperty("ModelSalesPage.PostcodeField"),"Post Code field","tw18 3he");
			verifyAndClick(pageProperties.getProperty("ModelSalesPage.FindButton2"),"Find Button");
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.addressDropDownField"))){
				Select select = new Select(browser.getElementByXpath(pageProperties.getProperty("ModelSalesPage.addressDropDownField")));
				select.selectByIndex(2);
				Report.updateTestLog("Different billing Address :" +select+ "Selected from Dropdown", "Pass");
			}else Report.updateTestLog("Different billing Address is not Selected from Dropdown", "Fail");                
		}
		if(BillingAddrType == "Same Addr"){
			/*if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.billingAddress"))){
				String Addr= browser.getTextByXpath(pageProperties.getProperty("ModelSalesPage.billingAddress"));
				Report.updateTestLog("Billing Address : " + Addr + "is displayed in an application", "Warn");
			}
			else{
				Report.updateTestLog("Billing Address is not displayed in an application", "Fail");
			}*/
		}
		if((customerType == "New") || (customerType == "NON-OAM")){
			verifyAndSelectDropDownBox(pageProperties.getProperty("ModelSalesPage.Title"), "Title Name", "Ms");
			verifyAndInputById(pageProperties.getProperty("ModelSalesPage.firstName"), "First Name","New");
			verifyAndInputById(pageProperties.getProperty("ModelSalesPage.lastName"), "Last Name", "Name");
			int temp = new Random().nextInt(100);
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! " +temp);
			verifyAndInputById(pageProperties.getProperty("ModelSalesPage.EmailID"), "Email ID", temp+"msales@bgdigitaltest.co.uk");
			verifyAndSelectDropDownBox(pageProperties.getProperty("ModelSalesPage.EmailType"), "Email Type", "Work");
			verifyAndInputById(pageProperties.getProperty("ModelSalesPage.Telephone"), "Telephone", "01234567894");
			verifyAndSelectDropDownBox(pageProperties.getProperty("ModelSalesPage.TelephoneType"), "Telephone Type", "Work");
			email = temp+"msales@bgdigitaltest.co.uk";
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! " +email);
			Report.updateTestLog("About you Details are provided successfully", "WARN");              
		}
        browser.wait(3000);
		verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.DetailsNextButton"),"Next button of your Details page");
	}

	// payment page 
	public void yourPaymentsDetails(ModelSalesProducts modelSalesProducts){
		browser.wait(4000);
		if((modelSalesProducts.getPayment()).contains("MonthlyDD") || (modelSalesProducts.getPayment()).contains("AnnualDD")){
			verifyAndInputById(pageProperties.getProperty("ModelSalesPage.bankacctNum"), "Bank Account Number", "11049151");
			verifyAndInputById(pageProperties.getProperty("ModelSalesPage.bankSortCode1"), "Bank Sort Code1", "40");
			verifyAndInputById(pageProperties.getProperty("ModelSalesPage.bankSortCode2"), "Bank Sort Code2", "02");
			verifyAndInputById(pageProperties.getProperty("ModelSalesPage.bankSortCode3"), "Bank Sort Code3", "50");
			verifyAndInputById(pageProperties.getProperty("ModelSalesPage.AccountHolderName"), "Account Holder Name", "Testing");
			verifyAndSelectDropDownBox(pageProperties.getProperty("ModelSalesPage.PaymentDay"), "Payment Day", "2");
			verifyAndClick(pageProperties.getProperty("ModelSalesPage.termsAndConditions1"),"Terms and Conditions");
			Report.updateTestLog("Payment Details For Annual DD are provided successfully", "WARN");
		}
		if((modelSalesProducts.getPayment()).contains("AnnualCard")){
			verifyAndSelectDropDownBox(pageProperties.getProperty("ModelSalesPage.CardType"), "CardType", "MasterCard");
			verifyAndInputById(pageProperties.getProperty("ModelSalesPage.cardHolderName"), "Card Holder Name", "David");
			verifyAndInputById(pageProperties.getProperty("ModelSalesPage.cardHolderNum"), "Card Holder Number", "5453010000070888");
			verifyAndSelectDropDownBox(pageProperties.getProperty("ModelSalesPage.CardExpiryMonth"), "Card Expiry Month", "2");
			verifyAndSelectDropDownBox(pageProperties.getProperty("ModelSalesPage.CardExpiryYear"), "Card Expiry Year", "2015");
			verifyAndInputById(pageProperties.getProperty("ModelSalesPage.cVVNum"), "CCV Number", "143");
		}
		verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.PaymentNextButton"),"Next button of your Payment page");
	}

	// your account setting Page
	public void yourAccountSettingPage(String OAMReg){
		if((customerType == "New") || (customerType == "NON-OAM") ){
			if(OAMReg == "OAMReg-OptIn"){
				if(browser.isElementVisible(pageProperties.getProperty("ModelSalesPage.passWord"))){
					verifyAndInputById(pageProperties.getProperty("ModelSalesPage.passWord"),"password","password12");
					verifyAndInputById(pageProperties.getProperty("ModelSalesPage.confirmPassWord"),"Confirm password","password12");
					Report.updateTestLog("Password are entered successfully to create Online account", "Pass");
				}else{
					Report.updateTestLog("Password feild is not available to create Online account", "Fail");
				}
				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.marketingConsentLetter"))){
					verifyAndClick(pageProperties.getProperty("ModelSalesPage.marketingConsentLetter"),"marketing Consent Letter");
					verifyAndClick(pageProperties.getProperty("ModelSalesPage.marketingConsentEmail"),"marketing Consent Email");
					verifyAndClick(pageProperties.getProperty("ModelSalesPage.marketingConsentLandline"),"marketing Consent Landline");
					verifyAndClick(pageProperties.getProperty("ModelSalesPage.marketingConsentMobile"),"marketing Consent Mobile");
					verifyAndClick(pageProperties.getProperty("ModelSalesPage.marketingConsentSms"),"marketing Consent SMS");
				}
			}
			else if (OAMReg == "OAMReg-OptOut"){
				verifyAndClickWithXpath(".//*[@id='accountCheck']","Registration Check box");
			}

			verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.PaymentNextButton"),"Next button of Account setting page");
		}
		if(customerType == "OAM"){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.PaymentNextButton"))){
			verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.PaymentNextButton"),"Next button of Account setting page");
			}
		}
	}


	// Review your order page
	public void reviewYourOrderPage(){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.orderedProducts"))){
			String OrderedProducts = browser.getTextByXpath(pageProperties.getProperty("ModelSalesPage.orderedProducts"));
			Report.updateTestLog("Ordered Products: " + OrderedProducts + "is displayed sucessfully", "PASS");
		}
		else{
			Report.updateTestLog("Ordered Products is not displayed in review order Page", "Fail");
		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.discountDisplayed"))){
			String Discount = browser.getTextByXpath(pageProperties.getProperty("ModelSalesPage.discountDisplayed"));
			Report.updateTestLog("Discount Value :" + Discount + "is displayed successfully", "Pass");
		}else{
			Report.updateTestLog("Discount Value is not displayed in review order Page", "Fail");
		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.monthlyPay"))){
			String MonthlyPay = browser.getTextByXpath(pageProperties.getProperty("ModelSalesPage.monthlyPay"));
			Report.updateTestLog("Monthly Pay:" + MonthlyPay + "is displayed successfully", "Pass");
		}
		verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.submitButton"),"Submit button");
		browser.wait(20000);
		orderDate = new OnlineDBConnector().DBsysdate();
	}


	public void getHoldingComponents(ModelSalesProducts modelSalesProducts){
		if(modelSalesProducts.getCentralHeating() != "False"){
			CHCFlag = true;
		}
		if(modelSalesProducts.getPlumbingDrains() != "False"){
			PDFlag = true;
		}
		if(modelSalesProducts.getHomeElectrical() != "False"){
			HECFlag = true;
		}
		if(modelSalesProducts.getBoilerAndControl() != "False"){
			BoilerFlag = true;
		}
		if(modelSalesProducts.getAnnualService() == "Yes"){
			DefaultBoilerFlag = true;
		}
		if(modelSalesProducts.getGAK() != "False"){
			GAKFlag = true;
		}

	}

	public void productConflict(ModelSalesProducts modelSalesProducts, String productConflictType) {
		if ((CHCFlag == true) && ((modelSalesProducts.getCentralHeating()) != "False")
				|| (PDFlag == true) && ((modelSalesProducts.getPlumbingDrains()) != "False")
				|| (HECFlag == true) && ((modelSalesProducts.getHomeElectrical()) != "False")
				|| (((BoilerFlag == true) || (DefaultBoilerFlag == true)))&& ((modelSalesProducts.getBoilerAndControl()) != "False")
				|| (GAKFlag == true) && ((modelSalesProducts.getGAK()) != "False")) {
			Report.updateTestLog("**************** Conflict Scenario **********************", "PASS");
			/// verifying payment and product conflict
			PaymentAndProductConflict(modelSalesProducts, productConflictType);
		}

	}

	public void PaymentAndProductConflict(ModelSalesProducts modelSalesProducts, String productConflictType){
		String conflictMessage = browser.getTextByXpath(".//*[@id='ui-dialog-title-addedToBasket']");
		if(conflictMessage.contains("You can only have one payment method applied to the items in your basket.")){
			paymentConflict(modelSalesProducts);
			if(productConflictType == "AcceptChanges"){
				verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.AcceptChanges"),"Accept Changes");
				addingProductsInbasket(modelSalesProducts);
				swappingTheProducts();
			}
			else if(productConflictType == "CancelChanges"){
				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.CancelChanges"))){
					verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.CancelChanges"),"Cancel Changes");
					Report.updateTestLog("Cancel selection button is clicked successfully", "Pass");
				}
				else{
					Report.updateTestLog("Cancel selection button is not present ina an application", "Fail");
				}
			}
			process = process + " PAYMENT CONFLICT : " + productConflictType ;
		}
		else{
			productConflict(modelSalesProducts);
			if(productConflictType.contains("AcceptChanges")){
				verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.AcceptChanges"),"Accept Changes");
				removeProductInBasket(modelSalesProducts);
				applyingJCIForAcceptedProduct();
				addingProductsInbasket(modelSalesProducts);
				swappingTheProducts();
			}
			else if(productConflictType.contains("CancelChanges")){
				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.CancelChanges"))){
					verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.CancelChanges"),"Cancel Changes");
					Report.updateTestLog("Cancel selection button is clicked successfully", "Pass");
				}
				else{
					Report.updateTestLog("Cancel selection button is not present ina an application", "Fail");
				}
			}
			process = process + " PRODUCT CONFLICT : " + productConflictType ;
		}
	}

	public void applyingJCIForAcceptedProduct(){
		if((customerType == "OAM" || customerType == "NON-OAM")  && jCIDiscount == "OptIn"){
			System.out.println("lllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");
			TotalyearlyPrice = TotalyearlyPrice - (12);
		}
	}
	public void paymentConflict(ModelSalesProducts modelSalesProducts){
		Report.updateTestLog("***********************  Payment Conflict ******************************", "Pass");
		proInBasket = browser.getTextByXpath(pageProperties.getProperty("ModelSalesPage.productInBasket"));
		newProduct = browser.getTextByXpath(pageProperties.getProperty("ModelSalesPage.newProductInBasket"));
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.payInBasket"))){
			String payInBasket = browser.getTextByXpath(pageProperties.getProperty("ModelSalesPage.payInBasket"));
			String payInNewQuote = browser.getTextByXpath(pageProperties.getProperty("ModelSalesPage.payInNewQuote"));
			Report.updateTestLog("Payment Option in present already in Basket : " + payInBasket + "In new Quote : " + payInNewQuote , "Pass");
		}
		else {
			Report.updateTestLog("Payment Option are not present","Fail");
		}
	}

	public void productConflict(ModelSalesProducts modelSalesProducts){
		Report.updateTestLog("***********************  Product Conflict ******************************", "Pass");
		proInBasket = browser.getTextByXpath(pageProperties.getProperty("ModelSalesPage.productInBasket1"));
		newProduct = browser.getTextByXpath(pageProperties.getProperty("ModelSalesPage.newProductInBasket1"));
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.productInBasket"))){
			String   productInBasket = browser.getTextByXpath(pageProperties.getProperty("ModelSalesPage.productInBasket"));
			String   productInNewQuote = browser.getTextByXpath(pageProperties.getProperty("ModelSalesPage.productInNewQuote"));
			Report.updateTestLog("Product in present already in Basket : " + productInBasket + "In new Quote : " + productInNewQuote , "Pass");
		}
		else{
			Report.updateTestLog("Products Option are not present","Fail");
		}
	}

	public void AddToBasket(ModelSalesProducts modelSalesProducts,String productConflictType){
		//browser.dynamicWaituntilClickablebyXpath(pageProperties.getProperty("ModelSalesPage.ConflictOverlay"));
		if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.AcceptChanges"))) {
			productConflict(modelSalesProducts,productConflictType);
			viewProducts();
		}
		else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.ProceedToCheckOut"))){
			System.out.println("oooooooooooooooooooooooooooooooooooooooooooooo      proceed");
			productMorphing(modelSalesProducts);
		}
		Report.updateTestLog(" *********************** SUMMARY : " +  process   +"  *********************** " , "Pass");
	}

	public void viewProducts(){
		for(int i = 0 ; i <5 ; i++){
			for(int j = 0; j<2 ; j++){
			}
		}
	}
	public void addingProductsInbasket(ModelSalesProducts modelSalesProducts){
		// yearlyPriceInExcess + monthlyPriceInExcess
		while (basketProducts[i][j] != null) {
			i = i + 1;
		}
		basketProducts[i][j] = modelSalesProducts.getProduct();
		basketProducts[i][j + 1] = TotalyearlyPrice + "";
	}

	//public void

	public void productMorphing(ModelSalesProducts modelSalesProducts){
		if((HC200Flag == true) && (PDFlag == true)){
			MorphedProduct = "HomeCare300";
			addToBasketOverlay();
			removeAndAddMorphedProduct(MorphedProduct);
			Report.updateTestLog("Product Morphed : " + MorphedProduct + "is added to basket", "Pass");
		}
		else if((HC300Flag == true) && (HECFlag == true)){
			MorphedProduct = "HomeCare400";
			addToBasketOverlay();
			removeAndAddMorphedProduct(MorphedProduct);
			Report.updateTestLog("Product Morphed : " + MorphedProduct + "is added to basket", "Pass");
		}
		else{
			addToBasketOverlay();
			addingProductsInbasket(modelSalesProducts);
		}
	}

	public void getHoldingProducts(ModelSalesProducts modelSalesProducts){
		if(! modelSalesProducts.getPackage().contains("ApplianceCover")){
			getHoldingProductsOfProducts(modelSalesProducts);
		}
	}

	public void getHoldingProductsOfProducts(ModelSalesProducts modelSalesProducts){
		if((!modelSalesProducts.getCentralHeating().contains("False")) && (!modelSalesProducts.getPlumbingDrains().contains("False")) && (!modelSalesProducts.getHomeElectrical().contains("False")) 
				&& (modelSalesProducts.getBoilerAndControl().contains("False")) && (modelSalesProducts.getAnnualService().contains("Yes"))){
			Product = "HomeCare400";
			HC400Flag = true;
		}
		else if((!modelSalesProducts.getCentralHeating().contains("False"))  && (!modelSalesProducts.getPlumbingDrains().contains("False")) && (modelSalesProducts.getHomeElectrical().contains("False")) 
				&& (modelSalesProducts.getBoilerAndControl().contains("False")) && (modelSalesProducts.getAnnualService().contains("Yes"))){
			Product ="HomeCare300";
			HC300Flag = true;
		}
		else if((!modelSalesProducts.getCentralHeating().contains("False"))  && (modelSalesProducts.getPlumbingDrains().contains("False")) && (modelSalesProducts.getHomeElectrical().contains("False")) 
				&& (modelSalesProducts.getBoilerAndControl().contains("False")) && (modelSalesProducts.getAnnualService().contains("Yes"))){
			Product ="HomeCare200";
			HC200Flag = true;
		}
		else if((modelSalesProducts.getCentralHeating().contains("False"))  && (modelSalesProducts.getPlumbingDrains().contains("False")) && (modelSalesProducts.getHomeElectrical().contains("False")) 
				&& (!modelSalesProducts.getBoilerAndControl().contains("False")) && (modelSalesProducts.getAnnualService().contains("Yes"))){
			Product ="HomeCare100";
			HC100Flag = true;
		}
		else if((! modelSalesProducts.getCentralHeating().contains("False"))  && (modelSalesProducts.getPlumbingDrains().contains("False")) && (modelSalesProducts.getHomeElectrical() .contains("False")) 
				&& (modelSalesProducts.getBoilerAndControl().contains("False")) && (modelSalesProducts.getAnnualService().contains("No"))){
			Product ="CentralHeating";
		}
		else if((modelSalesProducts.getCentralHeating().contains("False"))  && (modelSalesProducts.getPlumbingDrains().contains("False")) && (modelSalesProducts.getHomeElectrical().contains("False")) 
				&& (! modelSalesProducts.getBoilerAndControl().contains("False")) && (modelSalesProducts.getAnnualService().contains("No"))){
			Product ="BoilerAndControl";
		}
		else if((modelSalesProducts.getCentralHeating().contains("False"))  && (modelSalesProducts.getPlumbingDrains().contains("False")) && (modelSalesProducts.getHomeElectrical().contains("False")) 
				&& (! modelSalesProducts.getBoilerAndControl().contains("False")) && (modelSalesProducts.getAnnualService().contains("No"))){
			Product ="HomeElectrical";
			HECFlag = true;
		}
		else if((modelSalesProducts.getCentralHeating().contains("False"))  && (!modelSalesProducts.getPlumbingDrains().contains("False")) && (modelSalesProducts.getHomeElectrical().contains("False")) 
				&& (modelSalesProducts.getBoilerAndControl().contains("False")) && (modelSalesProducts.getAnnualService().contains("No"))){
			Product ="PlumbingDrains";
		}
	}

	// getting highest excess value //
	public String getHighestExcessValue(ModelSalesProducts modelSalesProducts){
		String excess = null;
		if((modelSalesProducts.getProduct()).contains("GAK") || ((modelSalesProducts.getProduct()).contains("GAC1")) || ((modelSalesProducts.getProduct()).contains("KAC-1"))
				|| ((modelSalesProducts.getProduct()).contains("GAC2")) || ((modelSalesProducts.getProduct()).contains("GAC3"))){
			excess = "Excess0";
		}
		else if ((modelSalesProducts.getProduct()).contains("PlumbingAndDrains") || ((modelSalesProducts.getProduct()).contains("HomeElectrical")) ||
				((modelSalesProducts.getProduct()).contains("KAC-3")) || ((modelSalesProducts.getProduct()).contains("KAC-5")) || ((modelSalesProducts.getProduct()).contains("KAC-9")) ){
			excess = "Excess50";
		}
		else{
			excess ="Excess99";
		}
		return excess;
	}

	public float getPricingInExcessPage(ModelSalesProducts modelSalesProducts){
		String product,excess;
		if((modelSalesProducts.getProduct()).contains("Homecare400")){
			if((((modelSalesProducts.getCentralHeating()).contains("Excess0")) && ((modelSalesProducts.getPlumbingDrains()).contains("Excess0")) && 
					((modelSalesProducts.getHomeElectrical()).contains("Excess0"))) || (((modelSalesProducts.getCentralHeating()).contains("Excess50")) &&((modelSalesProducts.getPlumbingDrains()).contains("Excess50")) && 
							((modelSalesProducts.getHomeElectrical()).contains("Excess50"))) || (((modelSalesProducts.getCentralHeating()).contains("Excess99")) &&((modelSalesProducts.getPlumbingDrains()).contains("Excess99")) && 
									((modelSalesProducts.getHomeElectrical()).contains("Excess99")))){
				product = "Homecare400";
				excess = modelSalesProducts.getCentralHeating();
				yearlyPriceInExcess = getYearlyPricing(product,excess,postCodeType,"Standalone");
				float monthlyPrice1 = (yearlyPriceInExcess)/(12); 
				monthlyPriceInExcess = Float.parseFloat(f.format(monthlyPrice1));
			}
			else{
				// central Heating Prices
				product = "Homecare200";
				excess = modelSalesProducts.getCentralHeating();
				float yearlyPrice1 = getPriceValue(product,excess,postCodeType,"Standalone");
				// Plumbing drains prices
				product = "PlumbingAndDrains";
				excess = modelSalesProducts.getPlumbingDrains();
				float yearlyPrice2 = getPriceValue(product,excess,postCodeType,"Standalone");
				// Home electricals prices
				product = "HomeElectrical";
				excess = modelSalesProducts.getHomeElectrical();
				float yearlyPrice3 = getPriceValue(product,excess,postCodeType,"Standalone");

				yearlyPriceInExcess = yearlyPrice1 + yearlyPrice2 + yearlyPrice3;
				yearlyPriceInExcess = getPriceWithCampaign(yearlyPriceInExcess,modelSalesProducts);
				//yearlyPriceInExcess = getYearlyPricing(product,excess,postCodeType,"Standalone");
				float monthlyPrice1 = (yearlyPriceInExcess)/(12); 
				monthlyPriceInExcess = Float.parseFloat(f.format(monthlyPrice1));
			}                              

		}
		if((modelSalesProducts.getProduct()).contains("Homecare300")){
			if((((modelSalesProducts.getCentralHeating()).contains("Excess0")) &&((modelSalesProducts.getPlumbingDrains()).contains("Excess0"))) ||
					(((modelSalesProducts.getCentralHeating()).contains("Excess50")) &&((modelSalesProducts.getPlumbingDrains()).contains("Excess50"))) ||
					(((modelSalesProducts.getCentralHeating()).contains("Excess99")) &&((modelSalesProducts.getPlumbingDrains()).contains("Excess99")))){
				product = "Homecare300";
				excess = modelSalesProducts.getCentralHeating() ;
				yearlyPriceInExcess = getYearlyPricing(product,excess,postCodeType,"Standalone");
				float monthlyPrice1 = (yearlyPriceInExcess)/(12); 
				monthlyPriceInExcess = Float.parseFloat(f.format(monthlyPrice1));
			}
			else{
				// central Heating Prices
				product = "Homecare200";
				excess = modelSalesProducts.getCentralHeating();
				float yearlyPrice1 = getPriceValue(product,excess,postCodeType,"Standalone");
				// Plumbing drains prices
				product = "PlumbingAndDrains";
				excess = modelSalesProducts.getPlumbingDrains();
				float yearlyPrice2 = getPriceValue(product,excess,postCodeType,"Standalone");

				yearlyPriceInExcess = yearlyPrice1 + yearlyPrice2;
				yearlyPriceInExcess = getPriceWithCampaign(yearlyPriceInExcess,modelSalesProducts);
				//yearlyPriceInExcess = getYearlyPricing(product,excess,postCodeType,"Standalone");
				float monthlyPrice1 = (yearlyPriceInExcess)/(12); 
				monthlyPriceInExcess = Float.parseFloat(f.format(monthlyPrice1));
				System.out.println("4444444444444444444444444444444444444444444444444444" +  yearlyPrice1 + yearlyPrice2 + monthlyPriceInExcess + yearlyPriceInExcess);
			}
		}
		if((modelSalesProducts.getProduct()).contains("Homecare200")){
			product = "Homecare200";
			excess = modelSalesProducts.getCentralHeating();
			yearlyPriceInExcess = getYearlyPricing(product,excess,postCodeType,"Standalone");
			float monthlyPrice1 = (yearlyPriceInExcess)/(12); 
			monthlyPriceInExcess = Float.parseFloat(f.format(monthlyPrice1));
		}
		if((modelSalesProducts.getProduct()).contains("Homecare100")){
			product = "Homecare100";
			excess = modelSalesProducts.getBoilerAndControl();
			yearlyPriceInExcess = getYearlyPricing(product,excess,postCodeType,"Standalone");
			float monthlyPrice1 = (yearlyPriceInExcess)/(12); 
			monthlyPriceInExcess = Float.parseFloat(f.format(monthlyPrice1));
		}
		if((modelSalesProducts.getProduct()).contains("centralHeating")){
			product = "centralHeating";
			excess = modelSalesProducts.getCentralHeating();
			yearlyPriceInExcess = getYearlyPricing(product,excess,postCodeType,"Standalone");
			float monthlyPrice1 = (yearlyPriceInExcess)/(12); 
			monthlyPriceInExcess = Float.parseFloat(f.format(monthlyPrice1));
		}
		if((modelSalesProducts.getProduct()).contains("BoilerAndControl")){
			product = "BoilerAndControl";
			excess = modelSalesProducts.getBoilerAndControl();
			yearlyPriceInExcess = getYearlyPricing(product,excess,postCodeType,"Standalone");
			float monthlyPrice1 = (yearlyPriceInExcess)/(12); 
			monthlyPriceInExcess = Float.parseFloat(f.format(monthlyPrice1));
		}
		if((modelSalesProducts.getProduct()).contains("HomeElectrical")){
			product = "HomeElectrical";
			excess = modelSalesProducts.getHomeElectrical();
			yearlyPriceInExcess = getYearlyPricing(product,excess,postCodeType,"Standalone");
			float monthlyPrice1 = (yearlyPriceInExcess)/(12); 
			monthlyPriceInExcess = Float.parseFloat(f.format(monthlyPrice1));
		}
		if((modelSalesProducts.getProduct()).contains("PlumbingAndDrains")){
			product = "PlumbingAndDrains";
			excess = modelSalesProducts.getPlumbingDrains();
			yearlyPriceInExcess = getYearlyPricing(product,excess,postCodeType,"Standalone");
			float monthlyPrice1 = (yearlyPriceInExcess)/(12); 
			monthlyPriceInExcess = Float.parseFloat(f.format(monthlyPrice1));
		}
		if((modelSalesProducts.getProduct()).contains("GAC1")){
			product = "GAC1";
			excess = modelSalesProducts.getExcess();
			yearlyPriceInExcess = getYearlyPricing(product,excess,postCodeType,"Bundle");
			float monthlyPrice1 = (yearlyPriceInExcess)/(12); 
			monthlyPriceInExcess = Float.parseFloat(f.format(monthlyPrice1));
		}
		if((modelSalesProducts.getProduct()).contains("GAC2")){
			product = "GAC2";
			excess = modelSalesProducts.getExcess();
			yearlyPriceInExcess = getYearlyPricing(product,excess,postCodeType,"Bundle");
			float monthlyPrice1 = (yearlyPriceInExcess)/(12); 
			monthlyPriceInExcess = Float.parseFloat(f.format(monthlyPrice1));
		}
		if((modelSalesProducts.getProduct()).contains("GAC3")){
			product = "GAC3";
			excess = modelSalesProducts.getExcess();
			yearlyPriceInExcess = getYearlyPricing(product,excess,postCodeType,"Bundle");
			float monthlyPrice1 = (yearlyPriceInExcess)/(12); 
			monthlyPriceInExcess = Float.parseFloat(f.format(monthlyPrice1));
		}
		if((modelSalesProducts.getProduct()).contains("KAC-1")){
			product = "KAC-Microwave";
			excess = modelSalesProducts.getExcess();
			yearlyPriceInExcess = getYearlyPricing(product,excess,postCodeType,"Standalone");
			float monthlyPrice1 = (yearlyPriceInExcess)/(12); 
			monthlyPriceInExcess = Float.parseFloat(f.format(monthlyPrice1));
		}
		if((modelSalesProducts.getProduct()).contains("KAC-3")){
			product = "KAC-3";
			excess = modelSalesProducts.getExcess();
			yearlyPriceInExcess = getYearlyPricing(product,excess,postCodeType,"Bundle");
			float monthlyPrice1 = (yearlyPriceInExcess)/(12); 
			monthlyPriceInExcess = Float.parseFloat(f.format(monthlyPrice1));
		}
		if((modelSalesProducts.getProduct()).contains("KAC-5")){
			product = "KAC-5";
			excess = modelSalesProducts.getExcess();
			yearlyPriceInExcess = getYearlyPricing(product,excess,postCodeType,"Bundle");
			float monthlyPrice1 = (yearlyPriceInExcess)/(12); 
			monthlyPriceInExcess = Float.parseFloat(f.format(monthlyPrice1));
		}
		if((modelSalesProducts.getProduct()).contains("KAC-9")){
			product = "KAC-9";
			excess = modelSalesProducts.getExcess();
			yearlyPriceInExcess = getYearlyPricing(product,excess,postCodeType,"Bundle");
			float monthlyPrice1 = (yearlyPriceInExcess)/(12); 
			monthlyPriceInExcess = Float.parseFloat(f.format(monthlyPrice1));
		}
		if((modelSalesProducts.getProduct()).contains("GAK")){
			product = "GAK";
			excess = modelSalesProducts.getGAK();
			yearlyPriceInExcess = getYearlyPricing(product,excess,postCodeType,"Standalone");
			float monthlyPrice1 = (yearlyPriceInExcess)/(12); 
			monthlyPriceInExcess = Float.parseFloat(f.format(monthlyPrice1));
		}
		browser.wait(35000);
		yearlyPriceInExcess = Float.parseFloat(f.format(yearlyPriceInExcess));
		return yearlyPriceInExcess;

	}

	// verifing pricing in excess page

	public void verifyPricingInExcessPage(ModelSalesProducts modelSalesProducts){
		float yearlyPrice1 = getPricingInExcessPage(modelSalesProducts);
		float monthlyPrice1 = (yearlyPrice1)/(12);
		BigDecimal yearlyPrice = truncateDecimal(yearlyPrice1+"", 2);
		BigDecimal monthlyPrice = truncateDecimal(monthlyPrice1+"", 2);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.MonthlyPrice"))){
			String displayedMonthlyPrice = browser.getTextByXpath(pageProperties.getProperty("ModelSalesPage.MonthlyPrice")); 
			if(displayedMonthlyPrice.contains(monthlyPrice+"")){
				Report.updateTestLog("Monthly Prices in excess page are matched : Displayed price : " + displayedMonthlyPrice + " Expected price : " + monthlyPrice , "Pass");
			}
			else{
				Report.updateTestLog("Monthly Prices Mismatch in excess page : Displayed price : " + displayedMonthlyPrice + " Expected price : " + monthlyPrice , "Fail");
			}
		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.YearlyPrice"))){
			String displayedYearlyPrice = browser.getTextByXpath(pageProperties.getProperty("ModelSalesPage.YearlyPrice"));
			if(displayedYearlyPrice.contains(yearlyPrice+"")){
				Report.updateTestLog("Yearly Prices in excess page are matched : Displayed price : " + displayedYearlyPrice + " Expected price : " + yearlyPrice , "Pass");
			}
			else{
				Report.updateTestLog("Yearly Prices Mismatch in excess page : Displayed price : " + displayedYearlyPrice + " Expected price : " + yearlyPrice , "Fail");
			}
		}
	}

	// removing product from the basket

	public void removeProductInBasket(ModelSalesProducts modelSalesProducts){
		if((modelSalesProducts.getProduct()).contains("BoilerAndControl")){
			for( i= 0 ; i<=5 ; i++){
				if((basketProducts[i][j].contains("Homecare100")) || (basketProducts[i][j].contains("Homecare200")) || (basketProducts[i][j].contains("Homecare300"))
						|| (basketProducts[i][j].contains("Homecare400")) || (basketProducts[i][j].contains("BoilerAndControl")) || basketProducts[i][j].contains("centralHeating")){
					System.out.println("i value : " + i + " J Value : " + j );
					basketProducts[i][j] = null;
					viewProducts();
					basketProducts[i][j+1] = null;
					break;
				}         
			}

		}
		if((modelSalesProducts.getProduct()).contains("centralHeating")){
			for( i= 0 ; i<=5 ; i++){
				if(basketProducts[i][j].contains("Homecare200") || basketProducts[i][j].contains("Homecare300") || basketProducts[i][j].contains("Homecare100") 
						|| basketProducts[i][j].contains("Homecare400") || basketProducts[i][j].contains("centralHeating") || basketProducts[i][j].contains("BoilerAndControl")){
					basketProducts[i][j] = null;
					System.out.println("i value : " + i + " J Value : " + j );
					basketProducts[i][j+1] = null;
					break;
				}
			}

		}
		if((modelSalesProducts.getProduct()).contains("PlumbingAndDrains")){
			for( i= 0 ; i<=5 ; i++){
				if(basketProducts[i][j].contains("Homecare300") || basketProducts[i][j].contains("Homecare400") || basketProducts[i][j].contains("PlumbingAndDrains")){
					basketProducts[i][j] = null;
					basketProducts[i][j+1] = null;
					break;
				}
			}

		}
		if((modelSalesProducts.getProduct()).contains("HomeElectrical")){
			for( i= 0 ; i<=5 ; i++){
				if(basketProducts[i][j].contains("HomeElectrical") || basketProducts[i][j].contains("Homecare400")){
					basketProducts[i][j] = null;
					basketProducts[i][j+1] = null;
					break;
				}
			}

		}
		if((modelSalesProducts.getProduct()).contains("Homecare100")){
			for( i= 0 ; i<=5 ; i++){
				if(basketProducts[i][j].contains("Homecare100") || basketProducts[i][j].contains("Homecare200") || basketProducts[i][j].contains("Homecare400") 
						|| basketProducts[i][j].contains("Homecare300") || basketProducts[i][j].contains("BoilerAndControl")){
					basketProducts[i][j] = null;
					viewProducts();
					basketProducts[i][j+1] = null;
					break;
				}
			}
		}
		if((modelSalesProducts.getProduct()).contains("Homecare200")){
			for( i= 0 ; i<=5 ; i++){
				if(basketProducts[i][j].contains("Homecare100") || basketProducts[i][j].contains("Homecare200") || basketProducts[i][j].contains("Homecare400") 
						|| basketProducts[i][j].contains("Homecare300") || basketProducts[i][j].contains("BoilerAndControl") || basketProducts[i][j].contains("centralHeating")){
					basketProducts[i][j] = null;
					basketProducts[i][j+1] = null;
					break;
				}
			}

		}
		if((modelSalesProducts.getProduct()).contains("Homecare300")){
			for( i= 0 ; i<=5 ; i++){
				if(basketProducts[i][j].contains("Homecare100") || basketProducts[i][j].contains("Homecare200") || basketProducts[i][j].contains("Homecare400") 
						|| basketProducts[i][j].contains("Homecare300") || basketProducts[i][j].contains("BoilerAndControl") || basketProducts[i][j].contains("centralHeating")
						||  basketProducts[i][j].contains("PlumbingAndDrains")){
					basketProducts[i][j] = null;
					basketProducts[i][j+1] = null;
					break;
				}
			}


		}
		if((modelSalesProducts.getProduct()).contains("Homecare400")){
			for( i= 0 ; i<=5 ; i++){
				if(basketProducts[i][j].contains("Homecare100") || basketProducts[i][j].contains("Homecare200") || basketProducts[i][j].contains("Homecare400") 
						|| basketProducts[i][j].contains("Homecare300") || basketProducts[i][j].contains("BoilerAndControl") || basketProducts[i][j].contains("centralHeating")
						||  basketProducts[i][j].contains("PlumbingAndDrains") || basketProducts[i][j].contains("HomeElectrical")){
					basketProducts[i][j] = null;
					basketProducts[i][j+1] = null;
					break;
				}
			}

		}
		if((modelSalesProducts.getProduct()).contains("GAK")){
			for( i= 0 ; i<=5 ; i++){
				if(basketProducts[i][j].contains("GAK")){
					basketProducts[i][j] = null;
					basketProducts[i][j+1] = null;
					break;
				}
			}
		}

		if((modelSalesProducts.getProduct()).contains("GAC1")){
			for( i= 0 ; i<=5 ; i++){
				if(basketProducts[i][j].contains("GAC2") || basketProducts[i][j].contains("GAC3") || basketProducts[i][j].contains("GAC1")){
					basketProducts[i][j] = null;
					basketProducts[i][j+1] = null;
					break;
				}
			}
		}
		if((modelSalesProducts.getProduct()).contains("GAC2")){
			for( i= 0 ; i<=5 ; i++){
				if(basketProducts[i][j].contains("GAC1") || basketProducts[i][j].contains("GAC3") || basketProducts[i][j].contains("GAC2")){
					basketProducts[i][j] = null;
					basketProducts[i][j+1] = null;
					break;
				}
			}
		}
		if((modelSalesProducts.getProduct()).contains("GAC3")){
			for( i= 0 ; i<=5 ; i++){
				if(basketProducts[i][j].contains("GAC1") || basketProducts[i][j].contains("GAC2") || basketProducts[i][j].contains("GAC3")){
					basketProducts[i][j] = null;
					basketProducts[i][j+1] = null;
					break;
				}
			}
		}
		if((modelSalesProducts.getProduct()).contains("KAC1")){
			for( i= 0 ; i<=5 ; i++){
				if(basketProducts[i][j].contains("KAC3") || basketProducts[i][j].contains("KAC5") || basketProducts[i][j].contains("KAC9") ||
						basketProducts[i][j].contains("KAC1")){
					basketProducts[i][j] = null;
					basketProducts[i][j+1] = null;
					break;
				}
			}
		}
		if((modelSalesProducts.getProduct()).contains("KAC3")){
			for( i= 0 ; i<=5 ; i++){
				if(basketProducts[i][j].contains("KAC1") || basketProducts[i][j].contains("KAC5") || basketProducts[i][j].contains("KAC9") ||
						basketProducts[i][j].contains("KAC3")){
					basketProducts[i][j] = null;
					basketProducts[i][j+1] = null;
					break;
				}
			}
		}
		if((modelSalesProducts.getProduct()).contains("KAC5")){
			for( i= 0 ; i<=5 ; i++){
				if(basketProducts[i][j].contains("KAC3") || basketProducts[i][j].contains("KAC1") || basketProducts[i][j].contains("KAC9") ||
						basketProducts[i][j].contains("KAC5")){
					basketProducts[i][j] = null;
					basketProducts[i][j+1] = null;
					break;
				}
			}
		}
		if((modelSalesProducts.getProduct()).contains("KAC9")){
			for( i= 0 ; i<=5 ; i++){
				if(basketProducts[i][j].contains("KAC3") || basketProducts[i][j].contains("KAC5") || basketProducts[i][j].contains("KAC9") || 
						basketProducts[i][j].contains("KAC1")){
					basketProducts[i][j] = null;
					basketProducts[i][j+1] = null;
					break;
				}
			}
		}
		viewProducts();

	}

	// removing product and adding morphed product 

	public void removeAndAddMorphedProduct(String MorphedProduct){
		String yearlyPrice = null ,yearlyPrice1 = null, yearlyPrice2 = null;
		if(MorphedProduct == "Homecare300"){
			for( i= 0 ; i<=5 ; i++){
				for(j=0 ; j<=2 ;j++){
					if(basketProducts[i][j].contains("Homecare200")){
						yearlyPrice1 = basketProducts[i][j+1];
					}
					else if(basketProducts[i][j].contains("PlumbingAndDrains")){
						yearlyPrice2 = basketProducts[i][j+1];
					}
					yearlyPrice = yearlyPrice1 + yearlyPrice2;
				}
			}
			removeAndAddProducts(MorphedProduct , yearlyPrice);

		}
		if(MorphedProduct == "Homecare400"){
			for( i= 0 ; i<=5 ; i++){
				for(j=0 ; j<=2 ;j++){
					if(basketProducts[i][j].contains("Homecare300")){
						yearlyPrice1 = basketProducts[i][j+1];
					}
					else if(basketProducts[i][j].contains("HomeElectrical")){
						yearlyPrice2 = basketProducts[i][j+1];
					}
					yearlyPrice = yearlyPrice1 + yearlyPrice2;
				}
			}
			removeAndAddProducts(MorphedProduct , yearlyPrice);

		}
	}

	// removing and adding products

	public void removeAndAddProducts(String MorphedProduct , String yearlyPrice){
		int i , j;
		if(MorphedProduct == "Homecare300"){
			for( i= 0 ; i<=5 ; i++){
				for(j=0 ; j<=2 ;j++){
					if(basketProducts[i][j].contains("Homecare200")){
						basketProducts[i][j] = MorphedProduct;
						basketProducts[i][j+1] = yearlyPrice;                                      
					}
					else if(basketProducts[i][j].contains("PlumbingAndDrains")){
						while(basketProducts[i][j] != null){
							basketProducts[i][j] = basketProducts[i+1][j]; // swapping products
							basketProducts[i][j+1] = basketProducts[i+1][j+1]; // swapping prices
							i = i+1;
						}  
						break;
					}
				}
			}
		}

		if(MorphedProduct == "Homecare400"){
			for( i= 0 ; i<=5 ; i++){
				for(j=0 ; j<=2 ;j++){
					if(basketProducts[i][j].contains("Homecare300")){
						basketProducts[i][j] = MorphedProduct;
						basketProducts[i][j+1] = yearlyPrice;                                      
					}
					else if(basketProducts[i][j].contains("HomeElectrical")){
						while(basketProducts[i][j] != null){
							basketProducts[i][j] = basketProducts[i+1][j]; // swapping products
							basketProducts[i][j+1] = basketProducts[i+1][j+1]; // swapping prices
							i = i+1;
						}
						break;
					}
				}
			}
		}

	}


	// getting the final prices and products in the basket

	public void gettingFinalPricesInTheBasket(){
		float TotalPrice = 0;
		String Products = "0", Prices = "0";
		for (i = 0; i < 5; i++) {
			while (basketProducts[i][j] != null) {
				Products = Products + basketProducts[i][j];
				float Price = Float.parseFloat(basketProducts[i][j + 1]);
				TotalPrice = TotalPrice + Price;
				i = i + 1;
				System.out.println(" basket   =================="+ basketProducts[i][j]);
			}
		}
		viewProducts();
		System.out.println(" Final Value   ==================" + TotalPrice);
		System.out.println(" Final products   ==================" + Products);
		verifyPricingInTheMainBasket(TotalPrice);
	}

	// verifying products value in the main basket

	public void verifyPricingInTheMainBasket(float TotalPrice){
		float monthlyPrice = TotalPrice / (12);
		monthlyPrice = Float.parseFloat(f.format(monthlyPrice));
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.yearlyPriceInMainBasket"))){
			String totalPrice = browser.getTextByXpath(pageProperties.getProperty("ModelSalesPage.yearlyPriceInMainBasket"));
			if(totalPrice.contains(TotalPrice+"")){
				Report.updateTestLog("Yearly Price in the main Basket Expected Price : " + TotalPrice + "Displayed Price : " + totalPrice, "Pass");
			}
			else{
				Report.updateTestLog("Mismatch in Yearly Price in the main Basket Expected Price : " + TotalPrice + "Displayed Price : " + totalPrice, "Fail");
			}

		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.monthlyPriceInMainBasket"))){
			String totalmonthlyPrice = browser.getTextByXpath(pageProperties.getProperty("ModelSalesPage.monthlyPriceInMainBasket"));
			if(totalmonthlyPrice.contains(monthlyPrice+"")){
				Report.updateTestLog("Monthly Price in the main Basket Expected Price : " + monthlyPrice + "Displayed Price : " + totalmonthlyPrice, "Pass");
			}
			else{
				Report.updateTestLog("Mismatch in Monthly Price in the main Basket Expected Price : " + monthlyPrice + "Displayed Price : " + totalmonthlyPrice, "Fail");
			}

		}
	}

	// Confirmation page 

	public void confirmationPage(){
		browser.wait(50000);
		if (customerType == "New" || customerType == "NON-OAM") {
			if (browser.isElementVisibleWithXpath(".//*[@id='logintoAcc']")) {
				Report.updateTestLog("Contract is created succesfully", "Warn");
				verifyAndClickWithXpath(".//*[@id='logintoAcc']" ,"Login Button");
				//verifyAccountOverview();
			} 
			else if(browser.isElementVisibleWithXpath(".//*[@id='bookFirstApt']")){
				Report.updateTestLog("Contract is created succesfully", "Warn");
				verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.bookFirstVisit") ,"Book First Appointment");
				//verifyAccountOverview();
			}
			else if (browser.isElementVisibleWithXpath(".//*[@id='retnToHome']")){
				Report.updateTestLog("Contract is created succesfully", "Warn");
				verifyAndClickWithXpath(".//*[@id='retnToHome']" ,"Return Home Button");
			}
			else if (browser.isElementVisibleWithXpath(".//a/span[@class='primary-link-Boxview']")){
				Report.updateTestLog("Contract is created succesfully", "Warn");
				verifyAndClickWithXpath(".//a/span[@class='primary-link-Boxview']" ,"Return Home Button");
				//verifyAndClickWithXpath(".//*[@id='logoutMsg']/a" ,"Logout Button");
			}
			else{
				Report.updateTestLog("Contract creation failed", "Fail");
			}

		}
		if((customerType == "OAM")){
			if (browser.isElementVisibleWithXpath(".//*[@id='logintoAcc']")) {
				Report.updateTestLog("Contract is created succesfully", "Warn");
				verifyAndClickWithXpath(".//*[@id='logintoAcc']" ,"Login Button");
				//verifyAccountOverview();
			} 
			else if(browser.isElementVisibleWithXpath(".//*[@id='bookFirstApt']")){
				Report.updateTestLog("Contract is created succesfully", "Warn");
				verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.bookFirstVisit") ,"Book First Appointment");
				//verifyAccountOverview();
			}
			else if (browser.isElementVisibleWithXpath(".//*[@id='retnToHome']")){
				Report.updateTestLog("Contract is created succesfully", "Warn");
				verifyAndClickWithXpath(".//*[@id='retnToHome']","Return to home");
			}
			else if (browser.isElementVisibleWithXpath(".//a/span[@class='primary-link-Boxview']")){
				Report.updateTestLog("Contract is created succesfully", "Warn");
				verifyAndClickWithXpath(".//a/span[@class='primary-link-Boxview']" ,"Return Home Button");
				//verifyAndClickWithXpath(".//*[@id='logoutMsg']/a" ,"Logout Button");
			}
			else {
				Report.updateTestLog("Contract creation failed", "Warn");
			}
		}
		
		/*String leatID = new OnlineDBConnector().getLeadIDforUddingston();
		Report.updateTestLog("LEAD ID : " + leatID , "PASS");*/
		Flag =  payFlag = false; 
		jCIFlag = true;
	}

	// verifying Account Overview ///
	public void verifyAccountOverview(){
		if(browser.isElementVisibleWithXpath(".//*[@id='accountID1']")){
			String Account = browser.getTextByXpath(".//*[@id='accountID1']");
			Report.updateTestLog("Account is : " + Account + "is created Successfully", "Warn");
		}
		else{
			Report.updateTestLog("Error in Account creation", "Fail");
		}
		String AuditDetails = null;
		if((customerType == "New") || (customerType == "NON-OAM")){
			//AuditDetails =new OnlineDBConnector().getModelSalesAuditDetails(orderDate ,email);
			//Report.updateTestLog("Audit Details : " + AuditDetails ,"PASS");
		}
		verifyAndClickWithXpath(".//*[@id='logoutMsg']/a" ,"Logout Button");
	}

	public void navigateToAccountSummary(){
		String Account = browser.getTextByXpath(".//*[@id='accountID1']");
		verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.ManageAccount").replace("NUMBER", Account) ,"Manage Account");
	}

	// swapping the products

	public void swappingTheProducts(){
		int i= 0; int  j= 0;
		while (((basketProducts[i][j] != null) || (basketProducts[i+1][j] != null))){
			if(basketProducts[i][j] == null){
				basketProducts[i][j] = basketProducts[i+1][j];
				basketProducts[i+1][j] = null;
				basketProducts[i][j+1] = basketProducts[i+1][j+1];
				basketProducts[i+1][j+1] = null;
			}
			i = i+1;
		}
	}



	// verifying audit details //

	public void verifyTransactiondetails(UserProfile userProfile){
		String AuditDetails = null;
		if((customerType == "New") || (customerType == "NON-OAM")){
			AuditDetails =new OnlineDBConnector().getModelSalesAuditDetails(orderDate ,email);
		}
		if(customerType == "OAM"){
			AuditDetails =new OnlineDBConnector().getModelSalesAuditDetails(orderDate , userProfile.getEmail()); 
		}
		Report.updateTestLog("Audit Details : " + AuditDetails  , "Pass" );

	}

	public void closingOverlay(){
		verifyAndInputByXpath(pageProperties.getProperty("ModelSalesPage.PostCode"),"Post Code", "NG9 2PL");
		verifyAndClick(pageProperties.getProperty("ModelSalesPage.FindButton"),"Find Button");
		if (browser.isElementVisible(pageProperties.getProperty("ModelSalesPage.addressDropDown"))) {
			Select select = new Select(browser.getElementByID(pageProperties.getProperty("ModelSalesPage.addressDropDown")));
			select.selectByIndex(new Random().nextInt());
			Report.updateTestLog("Address Selected from Dropdown", "Pass");
			nextButton();
		}
		if(browser.isElementVisibleWithXpath("html/body/div[9]/div[1]/a")){
			System.out.println("oooooooooooo sowmya");
			verifyAndClickWithXpath("html/body/div[9]/div[1]/a" ,"Overlay");
		}
	}
	
	public void newPostCode(){
		String[] postCode = postCodes(); 
		for(int i = 0 ; i<=postCode.length ; i++){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.PostCode"))){
				verifyAndInputByXpath(pageProperties.getProperty("ModelSalesPage.PostCode"),"Post Code", postCode[i]);
				verifyAndClick(pageProperties.getProperty("ModelSalesPage.FindButton"),"Find Button");
				browser.dynamicWaituntilVisiblebyXpath(pageProperties.getProperty("ModelSalesPage.addressDropDownXpath"));
				ArrayList<String> address = new ArrayList<String>();
				address = browser.getFromDropBox("id", pageProperties.getProperty("ModelSalesPage.addressDropDown"));
				int j = 1;
				do{
					verifyAndSelectDropDownBox(pageProperties.getProperty("ModelSalesPage.addressDropDown"), "Address Dropdown",address.get(j));
					if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.mbox"))){
						verifyAndInputByXpath(pageProperties.getProperty("ModelSalesPage.mbox"),"Telephone Box","01234567891");
						Report.updateTestLog("Telephone Number is given as input", "Pass");
						}
						else{
							Report.updateTestLog("Telephone number is not entered", "Fail");
						}
					verifyAndClickWithXpath(".//*[@id='step']/div[2]/div/div[3]/button","Find Button");
					browser.wait(5000);
					if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.overlayProperties"))){
						verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.overlayProperties"),"Overlay");
						verifyAndClickWithXpath(".//*[@id='changeAddressLink']","Change Address");
					}
					else{
						break;
					}
					j++;
				}
				while(address.size() != 0);
				//verifyAndClickWithXpath(".//*[@id='step']/div[2]/div/div[3]/button","Find Button");
				break;
			}
		}
	}
	
	
	public void newPostCodeForMBox(String mBox){
		String[] postCode = postCodes(); 
		for(int i = 0 ; i<=postCode.length ; i++){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.PostCode"))){
				verifyAndInputByXpath(pageProperties.getProperty("ModelSalesPage.PostCode"),"Post Code", postCode[i]);
				verifyAndClick(pageProperties.getProperty("ModelSalesPage.FindButton"),"Find Button");
				browser.dynamicWaituntilVisiblebyXpath(pageProperties.getProperty("ModelSalesPage.addressDropDownXpath"));
				ArrayList<String> address = new ArrayList<String>();
				address = browser.getFromDropBox("id", pageProperties.getProperty("ModelSalesPage.addressDropDown"));
				int j = 1;
				do{
					verifyAndSelectDropDownBox(pageProperties.getProperty("ModelSalesPage.addressDropDown"), "Address Dropdown",address.get(j));
					mBoxFunctionForNew(mBox);
					verifyAndClickWithXpath(".//*[@id='step']/div[2]/div/div[3]/button","Find Button");
					browser.wait(5000);
					if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.overlayProperties"))){
						verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.overlayProperties"),"Overlay");
						verifyAndClickWithXpath(".//*[@id='changeAddressLink']","Change Address");
					}
					else{
						break;
					}
					j++;
				}
				while(address.size() != 0);
				//verifyAndClickWithXpath(".//*[@id='step']/div[2]/div/div[3]/button","Find Button");
				break;
			}
		}
	}
	
	public void selectNonOAMAddress(){
		if(customerType == "NON-OAM"){
			System.out.println("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
			verifyAndInputByXpath(pageProperties.getProperty("ModelSalesPage.PostCode"),"Post Code", "KT10 8NU");
			verifyAndClick(pageProperties.getProperty("ModelSalesPage.FindButton"),"Find Button");
			browser.dynamicWaituntilVisiblebyXpath(pageProperties.getProperty("ModelSalesPage.addressDropDownXpath"));
			Select select = new Select(browser.getElementByXpath(pageProperties.getProperty("ModelSalesPage.addressDropDownXpath")));
			select.selectByIndex(9);
		}
	}

	public void verifyingAddressAndPostcode(ModelSalesProducts modelSalesProducts){
		String[] postCode = postCodes(); 
		if(customerType == "New"){
			newPostCode();
		}
		if(customerType == "OAM" || customerType == "NON-OAM"){
			if(jCIDiscount == "OptOut"){
				System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
				verifyAndClickWithXpath(".//*[@id='energyDiscount']","JCI check box");
				browser.wait(5000);
			}
			
		}
		browser.wait(2000);
		pricingInPersonalisePage(modelSalesProducts);
		verifyAndClickWithXpath(".//*[@id='step']/div[2]/div/div[3]/button","Find Button");
	}
	
	public void verifyingMessageBox(ModelSalesProducts modelSalesProducts,String mbox){
		if(customerType == "New"){
			newPostCodeForMBox(mbox);
		}
		if(customerType == "OAM" || customerType == "NON-OAM"){
			selectNonOAMAddress();
			mBoxFunctionForNew(mbox);
			nextButton();
			mBoxFuntionality(mbox);			
		}
		NonOAMFlag = true;
		browser.wait(2000);
		System.out.println("ppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp" + NonOAMFlag);
		pricingInPersonalisePage(modelSalesProducts);
		verifyAndClickWithXpath(".//*[@id='step']/div[2]/div/div[3]/button","Find Button");
		//NonOAMFlag = true;
	}
	
	public void mBoxFunctionForNew(String mbox){
		if(mbox == "Mandatory"){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.mbox"))){
				verifyAndInputByXpath(pageProperties.getProperty("ModelSalesPage.mbox"),"Telephone Box","01234567891");
				Report.updateTestLog("Telephone Number is given as input", "Pass");
				}
				else{
					Report.updateTestLog("Telephone number is not entered", "Fail");
				}
		}
		if(mbox == "Off"){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.mbox"))){
				Report.updateTestLog("Telephone Number is given as input", "Fail");
				}
				else{
					Report.updateTestLog("Telephone number is not entered when mBox is off", "Pass");
				}
		}
		if(mbox == "Optional-Submit"){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.mbox"))){
				verifyAndInputByXpath(pageProperties.getProperty("ModelSalesPage.mbox"),"Telephone Box","01234567891");
				Report.updateTestLog("Telephone Number is given as input", "Warn");
				}
				else{
					Report.updateTestLog("Telephone number is not entered", "Fail");
				}
		}
		if(mbox == "Optional-Remove"){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.mbox"))){
				browser.clearValueByXpath(pageProperties.getProperty("ModelSalesPage.mbox"));
				Report.updateTestLog("Telephone Number is removed and Submitted", "Warn");
				}
				else{
					Report.updateTestLog("Telephone number is not Removed", "Fail");
				}
		}
	}
	
	public void mBoxFuntionality(String mbox){
		if(jCIDiscount == "OptOut"){
			browser.wait(5000);
			verifyAndClickWithXpath(".//*[@id='energyDiscount']","JCI check box");
			browser.wait(5000);
		}
		if(mbox == "Mandatory"){
			verifyAndClickWithXpath(".//*[@id='changeAddressLink']","Change Address");
			browser.dynamicWaituntilVisiblebyXpath(pageProperties.getProperty("ModelSalesPage.addressDropDownXpath"));
			Select select = new Select(browser.getElementByXpath(pageProperties.getProperty("ModelSalesPage.addressDropDownXpath")));
			select.selectByIndex(9);
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.mbox"))){
				verifyAndInputByXpath(pageProperties.getProperty("ModelSalesPage.mbox"),"Telephone Box","01234567891");
				Report.updateTestLog("Telephone Number is given as input", "Pass");
				}
				else{
					Report.updateTestLog("Telephone number is not entered", "Fail");
				}
			verifyAndClickWithXpath(".//*[@id='step']/div[2]/div/div[3]/button","Find Button");
		}
		if(mbox == "Off"){
			verifyAndClickWithXpath(".//*[@id='changeAddressLink']","Change Address");
			browser.dynamicWaituntilVisiblebyXpath(pageProperties.getProperty("ModelSalesPage.addressDropDownXpath"));
			Select select = new Select(browser.getElementByXpath(pageProperties.getProperty("ModelSalesPage.addressDropDownXpath")));
			select.selectByIndex(9);
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.mbox"))){
				Report.updateTestLog("Telephone Number is given as input", "Fail");
				}
				else{
					Report.updateTestLog("Telephone number is not entered when mBox is off", "Pass");
				}
			verifyAndClickWithXpath(".//*[@id='step']/div[2]/div/div[3]/button","Find Button");
		}
		if(mbox == "Optional-Submit"){
			verifyAndClickWithXpath(".//*[@id='changeAddressLink']","Change Address");
			browser.dynamicWaituntilVisiblebyXpath(pageProperties.getProperty("ModelSalesPage.addressDropDownXpath"));
			Select select = new Select(browser.getElementByXpath(pageProperties.getProperty("ModelSalesPage.addressDropDownXpath")));
			select.selectByIndex(9);
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.mbox"))){
				Report.updateTestLog("Telephone Number is prepopulated", "Warn");
				}
				else{
					Report.updateTestLog("Telephone number is not prepopulated", "Fail");
				}
			verifyAndClickWithXpath(".//*[@id='step']/div[2]/div/div[3]/button","Find Button");
		}
		if(mbox == "Optional-Remove"){
			verifyAndClickWithXpath(".//*[@id='changeAddressLink']","Change Address");
			browser.dynamicWaituntilVisiblebyXpath(pageProperties.getProperty("ModelSalesPage.addressDropDownXpath"));
			Select select = new Select(browser.getElementByXpath(pageProperties.getProperty("ModelSalesPage.addressDropDownXpath")));
			select.selectByIndex(9);
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.mbox"))){
				browser.clearValueByXpath(pageProperties.getProperty("ModelSalesPage.mbox"));
				Report.updateTestLog("Telephone Number is removed and Submitted", "Warn");
				}
				else{
					Report.updateTestLog("Telephone number is not Removed", "Fail");
				}
			verifyAndClickWithXpath(".//*[@id='step']/div[2]/div/div[3]/button","Find Button");
		}
	}
	

	public String[] postCodes(){
		String[] postCode = new String[10];
		if(postCodeType.contains("OutsideM25")){
			postCode[0] = "SS16 5QW";
			postCode[1] = "RM20 4AD";   
			postCode[2] = "CH66 1QW";
			postCode[3] = "TS13 4HD";
		}
		else if(postCodeType.contains("WithinM25")){
			postCode[0] ="KT10 8GH";
			postCode[1] ="HA8 9QW";
			postCode[2] ="IG10 8GH";
		}
		return postCode;
	}

	public void modelSalesFlow(int NoOfCombinations,String combinations){
		ModelSalesCombinationsProfile modelSales;
		ModelSalesProducts modelSalesProducts = null;
		for(int j = 1 ; j <= NoOfCombinations ; j++){
			try{
				modelSales = new TestDataHelper().getModelSalesCombinationsProfile(combinations+j);
				int ItemIncrement = 1; 
				while((modelSales.getProduct(ItemIncrement)) != ""){
					modelSalesProducts = new TestDataHelper().getModelSalesProducts(modelSales.getProduct(ItemIncrement));
					navigateToProductsAndServicesPage();
					selectingPackage(modelSalesProducts);
					selectingProduct(modelSalesProducts);
					navigateToGetAQuotePage();
					verifyingAddressAndPostcode(modelSalesProducts);
					selectingExcess(modelSalesProducts);
					enteringBoilerDetails(modelSalesProducts);
					selectingPaymentOption(modelSalesProducts,"AcceptChanges");
					ItemIncrement = ItemIncrement + 1;
				} 
				//fulfillmentJourney(modelSalesProducts);
			}
			catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}

	}
	
	public void GAQWizardJourney(ModelSalesProducts modelSalesProducts){
		removingProducts();
		navigateToProductsAndServicesPage();
		selectingPackage(modelSalesProducts);
		selectingProduct(modelSalesProducts);
		navigateToGetAQuotePage();
		verifyingAddressAndPostcode(modelSalesProducts);
		selectingExcess(modelSalesProducts);
		enteringBoilerDetails(modelSalesProducts);
		selectingPaymentOption(modelSalesProducts,"AcceptChanges");
	}

	public void removingProducts(){
		browser.open("https://10.224.70.50/products-and-services/your-basket/");
		if(browser.isElementVisibleWithXpath(".//*[@id='removeAllLink']")){
		verifyAndClickWithXpath(".//*[@id='removeAllLink']","Remove all products");
		verifyAndClickWithXpath(".//*[@id='removeAllBtn']","Remove button");
		browser.wait(5000);
		verifyAndClickWithXpath(".//a/span[@class='primary-link-Boxview']","Continue shopping");
		setFlag();
		}
	}
	public void fulfillmentJourney(ModelSalesProducts modelSalesProducts){
		yourBasketPage();
		yourDetailsPage("Same Addr");
		yourPaymentsDetails(modelSalesProducts);
		yourAccountSettingPage("OAMReg-OptIn");
		reviewYourOrderPage();
		confirmationPage();
		verifyAccountOverview();
	}

	public void changePremiseOfTheCustomer(){
		verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.changeAddress"),"Change Address Button");
		String text = browser.getTextByXpath(".//*[@id='quickAddressComponent']/div[3]/div/div[2]/div[1]/p/span[1]/label");
		verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.AddrDropDownBox"),"Address box");
		/* if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ModelSalesPage.AddrDropDownBox"))){
                                                ArrayList<String> address = new ArrayList<String>();
                                                address = browser.getFromDropBox("Xpath", pageProperties.getProperty("ModelSalesPage.AddrDropDownBox"));
                                                verifyAndSelectDropDownBox(pageProperties.getProperty("ModelSalesPage.AddrDropDownBox"), "Address Dropdown",address.get(2));
                                                                Report.updateTestLog("Address Selected from Dropdown", "Pass");
                                                }else {
                                                                Report.updateTestLog("Address is not Selected from Dropdown", "Fail");
                                }*/
		verifyAndClickWithXpath(pageProperties.getProperty("ModelSalesPage.useAddress"),"Use Address Button");
	}

	public void modelSalesFlowPricing(int NoOfCombinations,String combinations){
		ModelSalesCombinationsProfile modelSales;
		ModelSalesProducts modelSalesProducts;
		for(int j = 1; j <= NoOfCombinations ; j++){
			try{
				modelSales = new TestDataHelper().getModelSalesCombinationsProfile(combinations+j);
				int ItemIncrement = 1;
				removingProducts();
				while((modelSales.getProduct(ItemIncrement)) != ""){
					modelSalesProducts = new TestDataHelper().getModelSalesProducts(modelSales.getProduct(ItemIncrement));
					navigateToProductsAndServicesPage();
					selectingPackage(modelSalesProducts);
					selectingProduct(modelSalesProducts);
					navigateToGetAQuotePage();
					verifyingAddressAndPostcode(modelSalesProducts);
					selectingExcess(modelSalesProducts);
					enteringBoilerDetails(modelSalesProducts);
					selectingPaymentOption(modelSalesProducts,"AcceptChanges");
					// fulfillmentJourney(modelSalesProducts);
					ItemIncrement = ItemIncrement + 1;
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
	}

	public void setFlag(){
		payFlag = false;
		WASHERDRYER = false;
		WASHINGMACHINE  = false; 
		DISHWASHER = false ;
		TUMBLEDRYER = false;
		COOKEROWEN = false;
		FRIDGE = false;
		MICROWAVE = false;
		HOB = false;
		OWEN = false;
		FRE = false;
		HOB1 = false;
		CKR = false;
		MWH = false;
		WH = false;
		FFR = false;
		Flag = false;
		TotalPrice = 0;
	}
	
	
	
}
