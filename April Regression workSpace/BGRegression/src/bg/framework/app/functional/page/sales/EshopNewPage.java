package bg.framework.app.functional.page.sales;

import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.support.ui.Select;

import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.EshopTariffProfile;
import bg.framework.app.functional.entities.PriceDetails;
import bg.framework.app.functional.entities.PriceFinderRMR;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.selfServe.PersonalDetailsPage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class EshopNewPage extends BasePage {
	private static String LeadData;
	private static boolean MarketingConsentFlag;
	private static String orderDate;
	private static String Fuel;
	private static String SalesType;
	private static String CustomerType;
	private static String AddressType;
	public static String email;
	private static boolean flag = true;
	private static int dap = 1; 

	public final static String FILE_NAME = "resources/sales/EshopNew.Properties";
	public static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
  
	public EshopNewPage(String Fuel, String SalesType, String CustomerType, String AddressType) {
		this.SalesType = SalesType;
		this.Fuel = Fuel;
		this.CustomerType = CustomerType;
		this.AddressType = AddressType;
	}
  
    public EshopNewPage() {
		// TODO Auto-generated constructor stub
	}
	public void selectTariff(String tariff, EshopTariffProfile eshopTariff){
		if(SalesType.equalsIgnoreCase("Eshop")){
			getTariffName(tariff,eshopTariff);		
		}
		
		if(SalesType.equalsIgnoreCase("Esmart")){
			getEsmartTariffName(tariff,eshopTariff);
		}
	}
	
	public void getTariffName(String tariff,EshopTariffProfile eshopTariff){
		if(Fuel.equalsIgnoreCase("Gas")){
			Fuel = "gas";
		}
		if(Fuel.equalsIgnoreCase("Elec")){
			Fuel = "electricity";
		}
		int count = 2;
		while((count) < 12){
			String tariffOnScreen;
			String count1 = String.valueOf(count);
			///////////////// if fuel is not dual
			if((Fuel.equalsIgnoreCase("gas")) || (Fuel.equalsIgnoreCase("electricity"))){
				tariffOnScreen = browser.getTextByXpath(pageProperties.getProperty("EshopPage.tariffOnScreen").replace("NUM", count1).replace("FUEL", Fuel));
				String tariffOnScreen1 = tariffOnScreen.replace("&", "and");
				if(tariffOnScreen1.contains(tariff)){
					if(browser.isElementVisibleWithXpath(pageProperties.getProperty("EshopPage.BetterdealswitchNow").replace("NUM", count1).replace("FUEL", Fuel))){
						   verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.BetterdealswitchNow").replace("NUM", count1).replace("FUEL", Fuel),"Better Deal Switch Now Link is clicked");	
						}else{
						verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.switchNow").replace("NUM", count1).replace("FUEL", Fuel),"Eshop Switch Now button is clicked");
						Report.updateTestLog("Switch now of tariff name:" +tariff+ "is selected", "PASS");
						break;
					}	
			}
			}
			if(Fuel.equalsIgnoreCase("Dual")){
				tariffOnScreen = browser.getTextByXpath(pageProperties.getProperty("EshopPage.DualtariffOnScreen").replace("NUM", count1));
				String tariffOnScreen1 = tariffOnScreen.replace("&", "and");
				if(tariffOnScreen1.contains(tariff)){
					/////////// if fuel is dual , clicking switch now //////////
					verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.TariffRadioButton").replace("NUM", count1),"Dual Fuel Tariff Radio Button");
					verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.DualswitchNow").replace("NUM", count1),"Switch Now button is clicked");
					Report.updateTestLog("Switch now of dual tariff name:" +tariff+ "is selected", "PASS");
					break;
				}
			}
			count = count+3;
			}
	}
	
	public String getEmailId(){
		String emailID = email;
		return emailID;
	}

	
	public void getEsmartTariffName(String tariff,EshopTariffProfile eshopTariff){
		if(Fuel.equalsIgnoreCase("Gas")){
			Fuel = "gas";
		}
		if(Fuel.equalsIgnoreCase("Elec")){
			Fuel = "electricity";
		}
		int count = 2;
		while((count) < 12){
			String tariffOnScreen;
			String count1 = String.valueOf(count);
			///////////////// if fuel is not dual
			if((Fuel.equalsIgnoreCase("gas")) || (Fuel.equalsIgnoreCase("electricity"))){
				tariffOnScreen = browser.getTextByXpath(pageProperties.getProperty("EshopPage.tariffOnScreen").replace("NUM", count1).replace("FUEL", Fuel));
				String tariffOnScreen1 = tariffOnScreen.replace("&", "and");
				if(tariffOnScreen1.contains(tariff)){
					verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.EsmartswitchNow").replace("NUM", count1).replace("FUEL", Fuel),"Esmart Switch Now button is clicked");
					Report.updateTestLog("Switch now of tariff name:" +tariff+ "is selected", "PASS");
					break;
				}			
			}
			if(Fuel.equalsIgnoreCase("Dual")){
				tariffOnScreen = browser.getTextByXpath(pageProperties.getProperty("EshopPage.DualtariffOnScreen").replace("NUM", count1));
				String tariffOnScreen1 = tariffOnScreen.replace("&", "and");
					if(tariffOnScreen1.contains(tariff)){
					verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.TariffRadioButton").replace("NUM", count1),"Dual Fuel Tariff Radio Button");
					browser.wait(15000);
					/////////// if fuel is dual , clicking switch now /////////////
					verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.DualEsmartswitchNow").replace("NUM", count1),"Esmart Switch Now button is clicked");
					Report.updateTestLog("Switch now of dual tariff name:" +tariff+ "is selected", "PASS");
					break;
				}
			}
			count = count+3;
		}
	}
	
	public void fillOrderDetailsPage(Acquisition acquisition){
		selectGasSupplierType(acquisition);
		selectElectricitySupplierType(acquisition);
		if(browser.isElementVisible(pageProperties.getProperty("EshopPage.nectorSelection"))){
		verifyAndClick(pageProperties.getProperty("EshopPage.nectorSelection"),"Nector selection not selected");
		}
		verifyAndClick(pageProperties.getProperty("EshopPage.orderPageContinue"),"continue button of order page is clicked successfully");
	}

	public void JourneyType(String payment,Acquisition acquisition,UserProfile userProfile){
		if(SalesType == "Eshop"){
			eshopJourney(payment,acquisition,userProfile);
		}
		if(SalesType == "Esmart"){
			esmartJourney(payment,acquisition,userProfile);
		}
	}
	
	public void eshopJourney(String payment,Acquisition acquisition,UserProfile userProfile){
		
		if((AddressType == "Exist") && (Fuel.contains(CustomerType))){
			Report.updateTestLog("*************** Conversion Journey ********************", "Pass");
			eshopConversionJourney();
		}
		else{
		AcquisitionJourney(acquisition,userProfile,payment);
		}
	}
	
	public void esmartJourney(String payment,Acquisition acquisition,UserProfile userProfile){
		if((AddressType == "Exist") && (Fuel.contains(CustomerType))){
			Report.updateTestLog("*************** Conversion Journey ********************", "Pass");
			esmartConversionJourney(userProfile,acquisition,payment);
		}
		else{
			AcquisitionJourney(acquisition,userProfile,payment);
			}
	}

	public void AcquisitionJourney(Acquisition acquisition,UserProfile userProfile,String payment){
		fillPersonalDetails(acquisition);
		enterMeterDetails(acquisition);
		enterPaymentDetails(acquisition,payment);
		reviewOrderPage(userProfile,payment);
		verifyThankyouPage();
	}

	public void eshopConversionJourney(){
		conversionReviewOrderPage();
		verifyConversionThankyouPage();
	}

	public void selectGasSupplierType(Acquisition acquisition){
		if(browser.isElementVisible(pageProperties.getProperty("EshopPage.GasSupplier"))){
			verifyAndSelectDropDownBox(pageProperties.getProperty("EshopPage.GasSupplier"), "gas Supplier", acquisition.getGasSupplier());
		}
	}

	public void selectElectricitySupplierType(Acquisition acquisition){
		if(browser.isElementVisible(pageProperties.getProperty("EshopPage.ElecSupplier"))){
			verifyAndSelectDropDownBox(pageProperties.getProperty("EshopPage.ElecSupplier"), "Elec Supplier", acquisition.getElecSupplier());
		}
	}

	public void fillPersonalDetails(Acquisition acquisition){
		enterCustomerDetails(acquisition);
		selectAddress(acquisition);
	}

	public void enterCustomerDetails(Acquisition acquisition){
		//// Entering Date of Birth ////
		if(browser.isElementVisible(pageProperties.getProperty("EshopPage.Day"))){
		verifyAndSelectDropDownBox(pageProperties.getProperty("EshopPage.Day"), "date  ", acquisition.getDay());
		Report.updateTestLog("Date of birth details entered successfully", "Pass");
		}
		else{
			Report.updateTestLog("Date of birth details is not entered successfully", "Fail");
		}
		
		if(browser.isElementVisible(pageProperties.getProperty("EshopPage.Month"))){
		verifyAndSelectDropDownBox(pageProperties.getProperty("EshopPage.Month"), "Month  ", acquisition.getMonth());
		Report.updateTestLog("Month of birth details entered successfully", "Pass");
		}
		else{
			Report.updateTestLog("Month of birth details is not entered successfully", "Fail");
		}
		if(browser.isElementVisible(pageProperties.getProperty("EshopPage.Year"))){
		verifyAndSelectDropDownBox(pageProperties.getProperty("EshopPage.Year"), "Year  ", acquisition.getYear());
		Report.updateTestLog("Year of birth details entered successfully", "Pass");
		}
		else{
		Report.updateTestLog("Year of birth details is not entered successfully", "Fail");
		}
		
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("EshopPage.TelephoneNumber"))){
			verifyAndInputByXpath(pageProperties.getProperty("EshopPage.TelephoneNumber"), "Telephone Number ", acquisition.getMobileNumber());
			verifyAndSelectDropDownBox(pageProperties.getProperty("EshopPage.TelephoneType"), "telephone type ", acquisition.getTelephonetype());
			Report.updateTestLog("Telephone details entered successfully", "Pass");
		}
		else{
			Report.updateTestLog("Telephone details is not entered successfully", "Fail");
		}
		
		//// Entering email id ////
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("EshopPage.EmailID"))){
			int temp = new Random().nextInt(1000);
			verifyAndInputByXpath(pageProperties.getProperty("EshopPage.EmailID"), "Enter email id", temp+"ms@bgdigitaltest.co.uk");
			email = temp+"ms@bgdigitaltest.co.uk";
			Report.updateTestLog("Email Id is entered successfully", "Pass");
		}
		else{
			Report.updateTestLog("Email Id is not entered successfully", "Fail");
		}
	

		///// Entering email type /////
		if(browser.isElementVisible(pageProperties.getProperty("EshopPage.EmailType"))){
			verifyAndSelectDropDownBox(pageProperties.getProperty("EshopPage.EmailType"), "Email type ", acquisition.getEmailtype());
			Report.updateTestLog("Email Type selected successfully", "Pass");
		}
		else{
			Report.updateTestLog("Email Type is not selected successfully", "Fail");
		}

		if(CustomerType.equalsIgnoreCase("AnonymousCust")){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("EshopPage.EsmartPassword"))){
			verifyAndInputByXpath(pageProperties.getProperty("EshopPage.EsmartPassword"), "Enter password", "password12");
			verifyAndInputByXpath(pageProperties.getProperty("EshopPage.EsmartConfirmPassword"), "Enter password", "password12");
			Report.updateTestLog("Password Details entered for anonymous customer", "Pass");
		}
	}


	}

	public void selectAddress(Acquisition acquisition){
		////// selecting addr //////
		if(browser.isElementVisible(pageProperties.getProperty("EshopPage.AddressSearch"))){
			verifyAndClick(pageProperties.getProperty("EshopPage.AddressSearch"),"Search Button clicked");
		}
		browser.wait(15000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("EshopPage.AddrDropDown"))){
			Select select = new Select(browser.getElementByXpath(pageProperties.getProperty("EshopPage.AddrDropDown")));
			select.selectByIndex(1);
			Report.updateTestLog("Address Selected from Dropdown", "Pass");
		}else Report.updateTestLog("Address is not Selected from Dropdown", "Fail");

		/////////// entering month and year ///////
		if(browser.isElementVisible(pageProperties.getProperty("EshopPage.YearLived"))){
			verifyAndSelectDropDownBox(pageProperties.getProperty("EshopPage.YearLived"), "Year Lived ", acquisition.getYearsLived());
			verifyAndSelectDropDownBox(pageProperties.getProperty("EshopPage.MonthLived"), "Month Lived ", acquisition.getMonthsLived());
		}
		verifyAndClick(pageProperties.getProperty("EshopPage.personalPageContinue"),"Continue button of personal page is clicked");
	}

	public void enterMeterDetails(Acquisition acquisition){
		if(Fuel.equalsIgnoreCase("Gas")){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("EshopPage.GasSmartMeterEnabled"))){
			verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.GasSmartMeterEnabled"), "Gas Smart Meter disabled");
			}
		}
		if(Fuel.equalsIgnoreCase("Elec")){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("EshopPage.ElecSmartMeterEnabled"))){
			verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.ElecSmartMeterEnabled"), "Elec Smart Meter disabled");
			}
		}
		if(Fuel.equalsIgnoreCase("Dual")){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("EshopPage.GasSmartMeterEnabled"))){
			verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.GasSmartMeterEnabled"), "Gas Smart Meter disabled");
			verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.ElecSmartMeterEnabled"), "Elec Smart Meter Disabled");
			}
		}
		verifyAndClick(pageProperties.getProperty("EshopPage.meterPageContinue"),"Continue button of meter details page is clicked");
	}

	public void enterPaymentDetails(Acquisition acquisition, String payment){
		if(payment == "MDD"){
		//Enter Back Account Details
		verifyAndInputByXpath(pageProperties.getProperty("EshopPage.BankAccountNumber"), "Bank account number ", acquisition.getPaymentAccountNumber());
		verifyAndInputByXpath(pageProperties.getProperty("EshopPage.SortCode1"), "SortCode 1 ", acquisition.getSortCode1());
		verifyAndInputByXpath(pageProperties.getProperty("EshopPage.SortCode2"), "SortCode 2 ", acquisition.getSortCode2());
		verifyAndInputByXpath(pageProperties.getProperty("EshopPage.SortCode3"), "SortCode 3 ", acquisition.getSortCode3());
		verifyAndInputByXpath(pageProperties.getProperty("EshopPage.AccountHolderName"), "AccountHolderName ", acquisition.getAccountName());
		verifyAndSelectDropDownBox(pageProperties.getProperty("EshopPage.PaymentDate"), "Payment date ", acquisition.getPayDay());
		}


		//Enter Gas Details
		if(browser.isElementVisible(pageProperties.getProperty("EshopPage.GasBillPeriod"))){
			verifyAndSelectDropDownBox(pageProperties.getProperty("EshopPage.GasBillPeriod"), "Bill Period", "Monthly");
		}

		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("EshopPage.GasBillAmount"))){
			verifyAndInputByXpath(pageProperties.getProperty("EshopPage.GasBillAmount"), "Bill Amount", "4");
		}

		//Enter Electricity Details
		if(browser.isElementVisible(pageProperties.getProperty("EshopPage.ElectricityBillPeriod"))){
			verifyAndSelectDropDownBox(pageProperties.getProperty("EshopPage.ElectricityBillPeriod"), "Bill Period", "Monthly");
		}

		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("EshopPage.ElectricityBillAmount"))){
			verifyAndInputByXpath(pageProperties.getProperty("EshopPage.ElectricityBillAmount"), "Bill Amount", "4");
		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("EshopPage.meterContinueButton"))){		
		verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.meterContinueButton"),"Continue button");
		}

	}

	public void reviewOrderPage(UserProfile userProfile, String payment){
		verifySpecialNeeds();
		selectMarketingConsent(userProfile);
		verifyDeptAssignProtocol(userProfile,payment);
	}
	
	public void verifyDeptAssignProtocol(UserProfile userProfile,String payment){
		if(payment == "PPM"){
			if(dap == 1){
				// verifying journey proceeds after selecting DAP as YES
				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("EshopPage.dapYesButton"))){
					verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.dapYesButton"),"DAP Yes Button");
				}
				verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.placeOrder"),"place order button");
				Report.updateTestLog("Proceed Journey successfully when DAP yes is selected", "WARN");
			}
			if(dap == 2){
				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("EshopPage.dapNoButton"))){
					verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.dapNoButton"),"DAP No Button");
					verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.placeOrder"),"place order button");
				}	
				// verifying error message when DAP is selected as No
				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("EshopPage.errorMessage"))){
					Report.updateTestLog("Error Message is displayed successfully", "WARN");
					selectMarketingConsent(userProfile);
					// Selecting and verifying when DAP is selected as YES after verifying error message
					if(browser.isElementVisibleWithXpath(pageProperties.getProperty("EshopPage.dapYesButton"))){
						verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.dapYesButton"),"DAP Yes Button");
					}
					verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.placeOrder"),"place order button");
					Report.updateTestLog("Proceed Journey successfully when DAP yes is selected", "WARN");

				}
				else{
					Report.updateTestLog("Error Message is not displayed successfully", "Fail");
				}
			}
			toggleDAP();
		}
		else{
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("EshopPage.placeOrder"))){
			verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.placeOrder"),"place order button");
			}
		}
		
	}
	
	private void toggleDAP(){
		if(dap == 1){
			dap = 2;
		}
		else{
			dap = 1;
		}
	}
	
	public void conversionReviewOrderPage(){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("EshopPage.termAndConditions"))){
			verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.termAndConditions"), "Terma And Conditions");
		}
		verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.placeOrder"),"place order button is clicked");
		browser.wait(5000);
	}

	public void verifySpecialNeeds(){
			//Click the special needs
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("EshopPage.SpecialNeeds"))){
				verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.SpecialNeeds"),"Special Needs");

				//Select the special needs
				verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.HeartCondition"), "Health Condition Checkbox");
				verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.WheelChair"), "WheelChair Checkbox");

			}
		
	}

	//Selecting Marketing Consent which are to be OptOut
	public void selectMarketingConsent(UserProfile userProfile){
	    if(browser.isElementVisibleWithXpath(pageProperties.getProperty("EshopPage.termAndConditions"))){
			verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.termAndConditions"), "Terma And Conditions");
		}
		if(userProfile.getLetterConsent().equalsIgnoreCase("yes")){
			verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.LetterConsent"), "Letter consent check box");
		}
		if(userProfile.getEmailConsent().equalsIgnoreCase("yes")){
			verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.EmailConsent"), "Email consent check box"); 
		}
		if(userProfile.getLandlineConsent().equalsIgnoreCase("yes")){
			verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.LandlineConsent"), "Landline consent check box");
		}
		if(userProfile.getMobileConsent().equalsIgnoreCase("yes")){
			verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.MobileConsent"), "Mobile consent check box");
		}
		if(userProfile.getTextMessageConsent().equalsIgnoreCase("yes")){
			verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.TextMessageConsent"), "TextMessage consent check box");
		}
		Report.updateTestLog("MarketingConsent Screenshot","WARN");
		browser.wait(5000);

	}

	//Verifying which Marketing Consent are OptOut and OptIn  
	public void verifyMarketingConsent(UserProfile userProfile){
		userProfile = PersonalDetailsPage.userProfileStat;
		LeadData = new OnlineDBConnector().getEshopLeadData(orderDate);
		if(MarketingConsentFlag == true)
			if(userProfile.getLetterConsent().equalsIgnoreCase("yes")){
				if(LeadData.contains("<MarketingChannelPreference MarketingChannel=\"Letter\" OptIn=\"N\"/>")){
					Report.updateTestLog("Letter Consent is Optout", "PASS");
				}
				else{
					Report.updateTestLog("Letter Consent is not Optout", "FAIL");
				}
			}
			else if(!userProfile.getLetterConsent().equalsIgnoreCase("yes")){
				if(LeadData.contains("<MarketingChannelPreference MarketingChannel=\"Letter\" OptIn=\"Y\"/>")){
					Report.updateTestLog("Letter Consent is Optin", "PASS");
				}
				else{
					Report.updateTestLog("Letter Consent is not Optin", "FAIL");
				}
			}
		if(userProfile.getEmailConsent().equalsIgnoreCase("yes")){
			if(LeadData.contains("<MarketingChannelPreference MarketingChannel=\"Email\" OptIn=\"N\"/>")){
				Report.updateTestLog("Email Consent is Optout", "PASS");
			}
			else{
				Report.updateTestLog("Email Consent is not Optout", "FAIL");
			}
		}
		else if(!userProfile.getEmailConsent().equalsIgnoreCase("yes")){
			if(LeadData.contains("<MarketingChannelPreference MarketingChannel=\"Email\" OptIn=\"Y\"/>")){
				Report.updateTestLog("Email Consent is Optin", "PASS");
			}
			else{
				Report.updateTestLog("Email Consent is not Optin", "FAIL");
			}
		}
		if(userProfile.getLandlineConsent().equalsIgnoreCase("yes")){
			if(LeadData.contains("<MarketingChannelPreference MarketingChannel=\"Landline\" OptIn=\"N\"/>")){
				Report.updateTestLog("LandLine Consent is Optout", "PASS");
			}
			else{
				Report.updateTestLog("LandLine Consent is not Optout", "FAIL");
			}
		}
		else if(!userProfile.getLandlineConsent().equalsIgnoreCase("yes")){
			if(LeadData.contains("<MarketingChannelPreference MarketingChannel=\"Landline\" OptIn=\"Y\"/>")){
				System.out.println("");
				Report.updateTestLog("LandLine Consent is Optin", "PASS");
			}
			else{
				Report.updateTestLog("LandLine Consent is not Optin", "FAIL");
			}
		}
		if(userProfile.getMobileConsent().equalsIgnoreCase("yes")){
			if(LeadData.contains("<MarketingChannelPreference MarketingChannel=\"Mobile\" OptIn=\"N\"/>")){
				Report.updateTestLog("Mobile Consent is Optout", "PASS");
			}
			else{
				Report.updateTestLog("Mobile Consent is not Optout", "FAIL");
			}
		}
		else if(!userProfile.getMobileConsent().equalsIgnoreCase("yes")){
			if(LeadData.contains("<MarketingChannelPreference MarketingChannel=\"Mobile\" OptIn=\"Y\"/>")){
				Report.updateTestLog("Mobile Consent is Optin", "PASS");
			}
			else{
				Report.updateTestLog("Mobile Consent is not Optin", "FAIL");
			}
		}
		if(userProfile.getTextMessageConsent().equalsIgnoreCase("yes")){
			if(LeadData.contains("<MarketingChannelPreference MarketingChannel=\"SMS/MMS\" OptIn=\"N\"/>")){
				Report.updateTestLog("TextMessage Consent is Optout", "PASS");
			}
			else{
				Report.updateTestLog("TextMessage Consent is not Optout", "FAIL");
			}
		}
		else if(!userProfile.getTextMessageConsent().equalsIgnoreCase("yes")){
			if(LeadData.contains("<MarketingChannelPreference MarketingChannel=\"SMS/MMS\" OptIn=\"Y\"/>")){
				Report.updateTestLog("TextMessage Consent is Optin", "PASS");
			}
			else{
				Report.updateTestLog("TextMessage Consent is not Optin", "FAIL");
			}
		}


	}
	public void verifyEshopLeadID(){
		String leadid=new OnlineDBConnector().getEshopLeadID(orderDate);
	   	Report.updateTestLog("Lead ID Generated is "+leadid, "DONE");
	   	
	}
	
	public void verifyEshopLeadType(UserProfile userProfile){
		String leadtype=new OnlineDBConnector().getEshopLeadType(orderDate);
	   	System.out.println(leadtype);
	   	String strAcqLead = "ENERGY_ACQ";
	   	String strConvLead = "ENERGY_CONV";
	   	if (leadtype.equals(strAcqLead)){
	   		Report.updateTestLog("Lead Type Generated for Acquisition is " + leadtype, "DONE");
	   		}
	   	else if(leadtype.contains(strConvLead)){
	   		Report.updateTestLog("Lead Type Generated for Conversion is " + leadtype, "DONE");
	   	}
	   	else{
	   	Report.updateTestLog("Lead Type not as expected, Lead Type Generated is :" + leadtype, "FAIL");
	   	}  
	   	if(MarketingConsentFlag == true){
		   	verifyMarketingConsent(userProfile);
		   	}
	}

	public void verifyThankyouPage(){
		browser.wait(5000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("EshopPage.PlacedOrder"))){
			if(browser.getTextByXpath(pageProperties.getProperty("EshopPage.PlacedOrder")).contains("Thank you for ordering")){
				Report.updateTestLog(browser.getTextByXpath(pageProperties.getProperty("EshopPage.PlacedOrder")) + "Text Displayed successfully", "Warn");
			}
			else{
				Report.updateTestLog("Confirmation page text error "+browser.getTextByXpath(pageProperties.getProperty("EshopPage.PlacedOrder")) , "Fail");
			}
		}
	}
	public void verifyConversionThankyouPage(){
		browser.wait(5000);
			if(browser.getTextByXpath(pageProperties.getProperty("EshopPage.convPlacedOrder")).contains("Thank you for ordering")){
				Report.updateTestLog(browser.getTextByXpath(pageProperties.getProperty("EshopPage.convPlacedOrder")) + "Text Displayed successfully", "Warn");
			}
			else{
				Report.updateTestLog("Confirmation page text error "+browser.getTextByXpath(pageProperties.getProperty("EshopPage.PlacedOrder")) , "Fail");
			}
	}
	  public void verifyChangedTariffInAccountSummaryPage(String tariff){
	    	
	    	String tariffInAccountSummaryPage = browser.getTextByXpath(pageProperties.getProperty("EshopPage.TariffInAccSumPage"));
	    	String tariffInAccountSummaryPage1=tariffInAccountSummaryPage.replace("&", "and");
	    	if( tariffInAccountSummaryPage1.contains(tariff)){
	    		Report.updateTestLog("Tariff is switched to:" +tariff+"","WARN");
	    	}
	    	else{
	    		Report.updateTestLog("Tariff is not switched to:" +tariff+"","FAIL");
	    	}
	    	
	    }
	  public void verifyChangedTariffInAccountSummaryPageJI(String tariff){
	    	
	    	String tariffInAccountSummaryPageJI = browser.getTextByXpath(pageProperties.getProperty("EshopPage.TariffInAccSumPageJI"));
	    	String tariffInAccountSummaryPageJI1=tariffInAccountSummaryPageJI.replace("&", "and");
	    	if( tariffInAccountSummaryPageJI1.contains(tariff)){
	    		Report.updateTestLog("Tariff is switched to:" +tariff+"for 1st Account","WARN");
	    	}
	    	else{
	    		Report.updateTestLog("Tariff is not switched to:" +tariff+"for 1st Account","FAIL");
	    	}
	    	String tariffInAccountSummaryPageJI2 = browser.getTextByXpath(pageProperties.getProperty("EshopPage.TariffInAccSumPageJI1"));
	    	String tariffInAccountSummaryPageJI3=tariffInAccountSummaryPageJI2.replace("&", "and");
	    	if( tariffInAccountSummaryPageJI3.contains(tariff)){
	    		Report.updateTestLog("Tariff is switched to:" +tariff+"for 2nd Account","WARN");
	    	}
	    	else{
	    		Report.updateTestLog("Tariff is not switched to:" +tariff+"for 2nd Account","FAIL");
	    	}
	    	
	    }
	public void verifyChangedTariffInAccountSummaryPageforDual(String tariff,String accNum){
	    	
	    	String tariffInAccountSummaryPageGas = browser.getTextByXpath(pageProperties.getProperty("EshopPage.TariffInAccSumPage"));
	    	String tariffInAccountSummaryPageGas1=tariffInAccountSummaryPageGas.replace("&", "and");
	    	if( tariffInAccountSummaryPageGas1.contains(tariff)){
	    		Report.updateTestLog("Tariff is switched to:" +tariff+"for Gas","WARN");
	    	}
	    	else{
	    		Report.updateTestLog("Tariff is not switched to:" +tariff+"for Gas","FAIL");
	    	}

			ArrayList<String> accountList = new ArrayList<String>();   
	    	if(browser.isElementVisible(pageProperties.getProperty("EshopPage.OtherAccountsDropDown")))
	    	{
	    		 accountList=(browser.getFromDropBox("id", pageProperties.getProperty("EshopPage.OtherAccountsDropDown")));
	    	}
	    	int sizeOfDDBox=accountList.size();
	    	if(sizeOfDDBox>2)
	    	{
	    		//if any account has size greater than 2 then need a rework.
	    	}
	    	for(String s:accountList)
	    	{
	    		if(s.contains(accNum))
	    		{
	    			verifyAndSelectDropDownBox(pageProperties.getProperty("EshopPage.OtherAccountsDropDown"),"AccountDetails"+s,s);
	    			break;
	    		}
	    	}
	    	browser.click("go_url");
	    	
	    	String tariffInAccountSummaryPageElec = browser.getTextByXpath(pageProperties.getProperty("EshopPage.TariffInAccSumPage"));
	    	String tariffInAccountSummaryPageElec1=tariffInAccountSummaryPageElec.replace("&", "and");
	    	if( tariffInAccountSummaryPageElec1.contains(tariff)){
	    		Report.updateTestLog("Tariff is switched to:" +tariff+"for Electricity","WARN");
	    	}
	    	else{
	    		Report.updateTestLog("Tariff is not switched to:" +tariff+"for Electricity","FAIL");
	    	}

	  }
	public void logout(){
		verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.logout"),"Logout");
		browser.wait(5000);
	}
	public void esmartConversionJourney(UserProfile userProfile,Acquisition acquisition,String payment){
		tariffPage(acquisition);
		selectPaymentType();
		reviewOrderPage(userProfile,payment);
		verifyThankyouPage();
	}
	
	public void tariffPage(Acquisition acquisition){
		if(flag = true){
		verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.tariffConfirmation"),"Tariff Confirmation check box is checked in");
		flag = false;
		}
		if(browser.isElementVisible(pageProperties.getProperty("EshopPage.Day"))){
			verifyAndSelectDropDownBox(pageProperties.getProperty("EshopPage.Day"), "date  ", acquisition.getDay());
			}
			if(browser.isElementVisible(pageProperties.getProperty("EshopPage.Month"))){
			verifyAndSelectDropDownBox(pageProperties.getProperty("EshopPage.Month"), "Month  ", acquisition.getMonth());
			}
			if(browser.isElementVisible(pageProperties.getProperty("EshopPage.Year"))){
			verifyAndSelectDropDownBox(pageProperties.getProperty("EshopPage.Year"), "Year  ", acquisition.getYear());
			}
			Report.updateTestLog("Date of birth details entered successfully", "Pass");
			verifyAndInputByXpath(".//*[@id='firstName']","Name","Jai");
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("EshopPage.TelephoneNumber"))){
				verifyAndInputByXpath(pageProperties.getProperty("EshopPage.TelephoneNumber"), "Telephone Number ", acquisition.getMobileNumber());
				verifyAndSelectDropDownBox(pageProperties.getProperty("EshopPage.TelephoneType"), "telephone type ", acquisition.getTelephonetype());
				Report.updateTestLog("Telephone details entered successfully", "Pass");
			}
		verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.meterContinueButton"),"Continue button in meter page is clicked");
		
	}
	
	public void selectPaymentType(){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("EshopPage.meterContinueButton"))){
		verifyAndClickWithXpath(pageProperties.getProperty("EshopPage.meterContinueButton"),"Continue button");
		Report.updateTestLog("Continue Button in Meter Page is clicked", "Pass");
		}
	}
	public void verifyChangeInTariff(String tariff,String accNum){
		if(Fuel.equalsIgnoreCase(CustomerType)){
			if(Fuel.contains("Dual")){
				verifyChangedTariffInAccountSummaryPageforDual(tariff,accNum);
			}
			else{
				verifyChangedTariffInAccountSummaryPage(tariff);
			}
		}
	}

}

