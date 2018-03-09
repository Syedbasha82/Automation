package bg.framework.app.functional.page.sales;

import java.text.DecimalFormat;
import java.util.Properties;


import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.GetAPrice;
import bg.framework.app.functional.entities.PriceDetails;
import bg.framework.app.functional.entities.PriceFinderRMR;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class GetAQuotePageNew extends BasePage{
	
	private static String AddrType;
	private static String Fuel;
	private static String CustomerType;

	public final static String FILE_NAME = "resources/sales/GetAQuoteNew.properties";
	public static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	
	public GetAQuotePageNew(String AddrType,String Fuel,String CustomerType){
		this.AddrType = AddrType;
		this.Fuel = Fuel; 
		this.CustomerType = CustomerType;
		
	}

    public void navigateToGetAQuotePage(){
    	//verifyAndClickWithXpath(pageProperties.getProperty("GetAQuote.gasAndElec"),"Gas and Electricity");
    	browser.open(ApplicationConfig.APP_BG_URL+"/content/britishgas/products-and-services/gas-and-electricity.html");
    	//browser.open("http://10.224.70.15/products-and-services/gas-and-electricity.html");
    	browser.wait(15000);
    	verifyAndClickWithLinkText(pageProperties.getProperty("GetAQuote.GetAQuote"), "GetAQuote");
    }
	public void selectAddress(){
		if (AddrType == "New"){
			verifyAndClick(pageProperties.getProperty("GetAQuote.newProperty"),"Quote for New property is selected");
		}
		else if (AddrType == "Exist"){
			verifyAndClick(pageProperties.getProperty("GetAQuote.existProperty"),"Quote for Existing property is selected");
			verifyAndClick(pageProperties.getProperty("GetAQuote.nextButtonExist"),"Next Button of existing property");
		}
	}

	public void enterPostCode(PriceDetails getAPrice){
		if (AddrType == "New"){
		if(browser.isElementVisibleWithXpath("GetAQuote.postCode"));
		verifyAndInputById(pageProperties.getProperty("GetAQuote.postCode"),"Post code",getAPrice.getPostCode());
		verifyAndClick(pageProperties.getProperty("GetAQuote.NextButtonPostcode"),"Next Button of post code is clicked");
		browser.wait(5000);
		}
	}
	public void enteringPostCode(String postCode){
		if (AddrType == "New"){
		if(browser.isElementVisibleWithXpath("GetAQuote.postCode"));
		verifyAndInputById(pageProperties.getProperty("GetAQuote.postCode"),"Post code", postCode);
		verifyAndClick(pageProperties.getProperty("GetAQuote.NextButtonPostcode"),"Next Button of post code is clicked");
		browser.wait(5000);
		}
	}
	public void selectFuel(){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAQuote."+Fuel))){
		verifyAndClickWithXpath(pageProperties.getProperty("GetAQuote."+Fuel),"The FuelType:" +Fuel+ "is selected");
		}
		browser.wait(5000);
		
		//Select Current Supplier
		if(browser.isElementVisible(pageProperties.getProperty("GetAQuote.gasSupplier"))){
			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAQuote.gasSupplier"), "Current Gas Supplier", "npower");
			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAQuote.electricitySupplier"), "Current Electricity Supplier", "npower");
			verifyAndClick(pageProperties.getProperty("GetAQuote.NextButtonFuel"), "Next Button");
			Report.updateTestLog("Current supplier section selected successfully", "Pass");
		}
		else{
			Report.updateTestLog("Current supplier section not found in the Get A Quote Page", "Fail");
		}
		browser.wait(5000);
	}

	public void selectPayment(String payment){
		if((AddrType == "New") ||((AddrType == "Exist") && !(Fuel.contains(CustomerType)))){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAQuote."+payment))){
		verifyAndClickWithXpath(pageProperties.getProperty("GetAQuote."+payment),"The payment options:" +payment+ "is selected");
		verifyAndClick(pageProperties.getProperty("GetAQuote.NextButtonPayment"),"Next Button of payment is clicked");
		browser.wait(5000);
		}
		}
	}

	public void enterUsageAndPersonalDetails(PriceDetails getAPrice,String energyUsage, String CustType){
		if((AddrType == "New") ||((AddrType == "Exist") && !(Fuel.contains(CustomerType)))){	
		enterEnergyUsage(getAPrice,energyUsage);
		enterPersonalDetails(getAPrice,CustType);
		}
	}



	public void enterEnergyUsage(PriceDetails getAPrice,String energyUsage){
		if(energyUsage == "yes"){
			verifyAndClick(pageProperties.getProperty("GetAQuote.radioButtonYes"),"yes Radio Button is clicked successfully");
			browser.wait(5000);
			if(Fuel.contains("Dual")){
				verifyAndInputByXpath(pageProperties.getProperty("GetAQuote.gasSpend"),"gas Spend",getAPrice.getGasSpend());
				verifyAndInputByXpath(pageProperties.getProperty("GetAQuote.elecSpend"),"Electricity Spend",getAPrice.getElecSpend());
			}
		    if(Fuel.contains("Gas")){
				verifyAndInputByXpath(pageProperties.getProperty("GetAQuote.gasSpend"),"gas Spend",getAPrice.getGasSpend());
			}
			if(Fuel.contains("Elec")){
				verifyAndInputByXpath(pageProperties.getProperty("GetAQuote.elecSpend"),"Electricity Spend",getAPrice.getElecSpend());
			}
			browser.wait(5000);
			verifyAndClickWithXpath(pageProperties.getProperty("GetAQuote.NextButtonEnergy"),"Next Button of energy usage is clicked");
			browser.wait(20000);
		}
		if(energyUsage == "no"){
			verifyAndClick(pageProperties.getProperty("GetAQuote.radioButtonNo"),"No Radio Button is clicked successfully");
			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAQuote.propertyType"), "Property Name", "Flat");
			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAQuote.propertyAge"), "Age Of Property", "1995+");
			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAQuote.NoOfBedRooms"),"No of bedrooms","2");
			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAQuote.peopleOccupant"), "People Occupant", "2");
			if(browser.isElementVisible(pageProperties.getProperty("GetAQuote.elecUsed"))){
			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAQuote.elecUsed"),"Electricity used","Infrequent (e.g. second home)");
			}
			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAQuote.propertyHeated"), "Property Heated", "Gas room heating");
			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAQuote.boilerType"), "Boiler Type", "Combi");
			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAQuote.boilerAge"),"Boiler Age",getAPrice.getboilerAge());
			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAQuote.gasheatingBoiler"),"Heating boiler","Gas");
			browser.wait(5000);
		    verifyAndClickWithXpath(pageProperties.getProperty("GetAQuote.NextButtonEnergy"),"Next Button of energy usage is clicked");
		    browser.wait(20000);
		}
	}

	public void enterPersonalDetails(PriceDetails getAPrice, String CustType){
		if(CustType == "AnoyCust"){
		verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("GetAQuote.titleXpath"), "Title", getAPrice.getTitle());
		verifyAndInputById(pageProperties.getProperty("GetAQuote.firstNameId"),"First name",getAPrice.getFirstName());
		verifyAndInputById(pageProperties.getProperty("GetAQuote.lastNameId"),"Last name",getAPrice.getLastName());
		verifyAndInputById(pageProperties.getProperty("GetAQuote.emailId"),"Email Id",getAPrice.getEmail());
		verifyAndInputById(pageProperties.getProperty("GetAQuote.telephoneNumber"),"Telephone Number",getAPrice.getMobileNumber());
		verifyAndSelectDropDownBox(pageProperties.getProperty("GetAQuote.telephoneNumberType"),"Telephone Number type",getAPrice.getPhoneType());
		}
		else if(CustType == "OAM"){
			verifyAndInputById(pageProperties.getProperty("GetAQuote.firstNameId"),"First name",getAPrice.getFirstName());
			verifyAndInputById(pageProperties.getProperty("GetAQuote.emailId"),"Email Id",getAPrice.getEmail());
			verifyAndInputById(pageProperties.getProperty("GetAQuote.telephoneNumber"),"Telephone Number",getAPrice.getMobileNumber());
			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAQuote.telephoneNumberType"),"Telephone Number type",getAPrice.getPhoneType());
		}
		verifyAndClick(pageProperties.getProperty("GetAQuote.NextButton6"),"Next Button is clicked");
		browser.wait(3000);

	}

	public void verifyQuoteResultPage(){
		verifyAndClick(pageProperties.getProperty("GetAQuote.getAQuoteLink"),"Get A Quote Link is clicked successfully");
		browser.wait(20000);
		}

	public void logout(){
		verifyAndClickWithXpath(pageProperties.getProperty("GetAQuote.logoutLink"),"Logout Link is clicked successfully");
	}

	public void verifyTCRValue(String fuel, String payment, String postCode){
		PriceFinderRMR priceFinder = new TestDataHelper().getPriceFinderRMR("TariffNames"+fuel+payment);
		PriceDetails pricedetails = new TestDataHelper().getPriceDetails("Anonymous");
		String tariff;
		String region1;
		int tariffInc = 1;
		///// Getting region from GetAPriceNew.xml ///////
		region1 = postCode;
		String Region = new TCRCalculationPage().getPostcode(region1);
		Report.updateTestLog("*******************" + Region + "**************************" , "Pass");
		int tar = 2;
		while((tariff = priceFinder.getTariff(tariffInc)) != ""){
			String tar1 = Integer.toString(tar);
			if(fuel == "Gas"){
				String DualFuel = "N";
				String combination = tariff+fuel+payment+Region+DualFuel;
				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAQuote.GasTCRValOnscreen").replace("Row", tar1))){
					String TCRValOnScreen = browser.getTextByXpath(pageProperties.getProperty("GetAQuote.GasTCRValOnscreen").replace("Row", tar1));
					verifyTCRForGas(tariff,combination,TCRValOnScreen);
					String PPValOnScreen = browser.getTextByXpath(pageProperties.getProperty("GetAQuote.GasPPValOnScreen").replace("Row", tar+""));
					verifyPPForGas(tariff,combination,PPValOnScreen);
				}
			}
			if(fuel == "Elec"){
				String DualFuel = "N";
				String combination = tariff+"Elec SR"+payment+Region+DualFuel;
				String TCRValOnScreen = browser.getTextByXpath(pageProperties.getProperty("GetAQuote.ElectricityTCRValOnscreen").replace("Row", tar1));
				verifyTCRForElectricity(tariff,combination,TCRValOnScreen);
				String PPValOnScreen = browser.getTextByXpath(pageProperties.getProperty("GetAQuote.ElectricityPPValOnScreen").replace("Row", tar+""));
				verifyPPForElectricity(tariff,combination,PPValOnScreen);
			}
			if(fuel == "Dual"){
				String DualFuel = "Y";
				String combination = tariff+"Gas"+payment+Region+DualFuel;
				String TCRValOnScreen = browser.getTextByXpath(pageProperties.getProperty("GetAQuote.GasTCRValOnscreen").replace("Row", tar1));
				verifyTCRForGas(tariff,combination,TCRValOnScreen);
				String PPValOnScreen = browser.getTextByXpath(pageProperties.getProperty("GetAQuote.GasPPValOnScreen").replace("Row", tar+""));
				verifyPPForGas(tariff,combination,PPValOnScreen);
				String combination1 = tariff+"Elec SR"+payment+Region+DualFuel;
				String TCRValOnScreen1 = browser.getTextByXpath(pageProperties.getProperty("GetAQuote.ElectricityTCRValOnscreen").replace("Row", tar1));
				verifyTCRForElectricity(tariff,combination1,TCRValOnScreen1);
				String PPValOnScreen1 = browser.getTextByXpath(pageProperties.getProperty("GetAQuote.ElectricityPPValOnScreen").replace("Row", tar+""));
				verifyPPForElectricity(tariff,combination1,PPValOnScreen1);
			}
			tar = Integer.parseInt(tar1);
			tar = tar+2;
			tariffInc++;
		}

	}
	
	public void verifyPPForGas(String tariff,String Combination,String PPValOnScreen){
		String PPValue = new TCRCalculationPage().verifyPPForGasTariff(tariff, Combination);
		if(PPValOnScreen.contains(PPValue)){
    		Report.updateTestLog("PP Value for gas of  tariff: " +tariff+ " is displayed successfully Expected value: " + PPValue + "Displayed value: " +PPValOnScreen , "PASS");
    	}
    	else {
    		Report.updateTestLog("PP Value for gas of tariff: " +tariff+ " is not displayed successfully Expected value: " + PPValue + "Displayed value: " +PPValOnScreen , "FAIL");
    	}
	}
	
    public void verifyPPForElectricity(String tariff,String Combination,String PPValOnScreen){
    	String PPValue = new TCRCalculationPage().verifyPPForElectricityTariff(tariff, Combination);
    	if(PPValOnScreen.contains(PPValue)){
    		Report.updateTestLog("PP Value for Electricity of  tariff: " +tariff+ " is displayed successfully Expected value: " + PPValue + "Displayed value: " +PPValOnScreen , "PASS");
    	}
    	else {
    		Report.updateTestLog("PP Value for Electricity of tariff: " +tariff+ " is not displayed successfully Expected value: " + PPValue + "Displayed value: " +PPValOnScreen , "FAIL");
    	}
	}
    
    public String getPayment(){
    	String payment = null;
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAQuote.GasPaymentOnScreen"))){
        	payment = browser.getTextByXpath(pageProperties.getProperty("GetAQuote.GasPaymentOnScreen"));
    	}
    	else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAQuote.ElecPaymentOnScreen"))){
        	payment = browser.getTextByXpath(pageProperties.getProperty("GetAQuote.ElecPaymentOnScreen"));
    	}
     return payment;	
    }
       
    public void verifyTCRForGas(String tariff, String combination, String TCRValOnScreen){

		String TCRValue = new TCRCalculationPage().verifyTCRForGasTariff(tariff,combination);
    	if(TCRValOnScreen.contains(TCRValue)){
    		Report.updateTestLog("TCR Value for gas of  tariff: " +tariff+ " is displayed successfully Expected value: " + TCRValue + "Displayed value: " +TCRValOnScreen , "PASS");
    	}
    	else {
    		Report.updateTestLog("TCR Value for gas of tariff: " +tariff+ " is not displayed successfully Expected value: " + TCRValue + "Displayed value: " +TCRValOnScreen , "FAIL");
    	}
    	
    }
    public void verifyTCRForElectricity(String tariff, String combination, String TCRValOnScreen){
    	String TCRValue = new TCRCalculationPage().verifyTCRForElectricitySRTariff(tariff,combination);
    	if(TCRValOnScreen.contains(TCRValue)){
    		Report.updateTestLog("TCR Value for electricity of Tariff " + tariff + "is displayed successfully Expected value: " + TCRValue + "Displayed value: " +TCRValOnScreen , "PASS");
    	}
    	else {
    		Report.updateTestLog("TCR Value for electricity of Tariff"  + tariff + " is not displayed successfully Expected value: " + TCRValue + "Displayed value: " +TCRValOnScreen , "FAIL");
    	}
    	
    }
}
