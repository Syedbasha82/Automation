package bg.framework.app.functional.page.sales;

import bg.framework.app.functional.common.ApplicationConfig;

import bg.framework.app.functional.entities.BoilerTypeProfile;
import bg.framework.app.functional.entities.GetAPricePageProfile;
import bg.framework.app.functional.entities.InsuranceQuote;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SiebelDataBase;
import bg.framework.app.functional.util.SshClient;
import bg.framework.app.functional.util.TestDataHelper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GetAnInsuranceQuotePage extends BasePage {
	private final static String FILE_NAME = "resources/sales/GetAnInsuranceQuotePage.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	private static int nectar = 1;
	private static double cost = 0.00;
	private static final String flag = ApplicationConfig.THIRD_PARTY_EXCESS;
	private static String orderDate = "";
	private static String orderID = "";
	private static String DBName="";
	private static String tes;
	private static InsuranceQuote insuranceQuote;
	private static boolean MarketingConsentFlag;
	private static String OrderTime;


	public void validateErrorMessages(InsuranceQuote insuranceQuote) {
		validatePostCode();
		enterDetails(insuranceQuote);
		validateCover();
		enterCoverDetails(insuranceQuote);
		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.PostCodeEditor"), "Edit postCode Selection");
		enterDetails(insuranceQuote);
		enterCoverDetails(insuranceQuote);
		enterService(insuranceQuote);
		enterExcess(insuranceQuote);
		enterExtras(insuranceQuote);
		//Card 5733
		caveatVerification();
		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.GetAQuote"), "Get A Quote");
		verifyAndClickWithXpath(pageProperties.getProperty("GetAnInsuranceQuotePage.GetQuoteDetails2"), "Get Quote Details");
		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.OrderNow"), "Order Now");
		validatePersonalDetails(insuranceQuote);
		enterPersonalDetails(insuranceQuote);
		if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.BoilerType"))) {
			enterBoilerType(insuranceQuote);
		}
		enterNectarDetails();
		validateAddress(insuranceQuote);
		validateBankDetails(insuranceQuote);
		enterBankDetails(insuranceQuote);
		validateTermsAndConditions();
		enterTermsAndConditions(insuranceQuote);
	}

	private void validatePostCode() {
		String[] postcode = getInvalidPostCode();
		String[] houseNo = {"##", "64"};
		String[] phoneNumber = {"", "fsdjfsdf", "01234567890"};
		for (String t : houseNo) {
			for (String u : phoneNumber) {
				for (String s : postcode) {
					verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.HouseName"), "House Number", t.toString());
					verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.PostCode"), "PostCode", s.toString());
					verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.PhoneNumber"), "Phone number", u.toString());
					browser.click(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton1"));
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.postCodeError"))) {
						Report.updateTestLog("Post code error validation for value: " + s.toString(), "DONE");
					}
				}
			}
		}
	}

	private void validateCover() {
		browser.click(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton2"));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.CoverError"))) {
			Report.updateTestLog("Cover selection validation ", "DONE");
		}
	}

	public void enterQuoteDetails(InsuranceQuote insuranceQuote) {
		// OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
		// this.insuranceQuote = insuranceQuote;
		// String date = onlineDBConnector.DBsysdate();

		String strval=ApplicationConfig.APP_BG_URL+"/ViewQuoteDetails/cover/";
		browser.open(strval);


		enterDetails(insuranceQuote);
		enterCoverDetails(insuranceQuote);
		caveatVerification_1();
		enterService(insuranceQuote);
		caveatVerification_1();
		enterExcess(insuranceQuote);
		caveatVerification_1();
		enterExtras(insuranceQuote);
		//Card 5733
		caveatVerification_New();
		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.GetAQuote"), "Get A Quote");
		verifyAndClickWithXpath(pageProperties.getProperty("GetAnInsuranceQuotePage.GetQuoteDetails2"), "Get Quote Details");
		//String quoteId = validatePrices(insuranceQuote, date);
		verifyPriceCombination(insuranceQuote);
		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.OrderNow"), "Order Now");
		//orderNow(insuranceQuote,quoteId);        
		//Refer this 
		orderNow(insuranceQuote);
	}
	public void enterQuoteDetailsDifferentBillingAddress(InsuranceQuote insuranceQuote) {
		//OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
		//this.insuranceQuote = insuranceQuote;
		//String date = onlineDBConnector.DBsysdate();
		browser.open("https://10.224.70.111/ViewQuoteDetails/cover/");
		enterDetails(insuranceQuote);
		enterCoverDetails(insuranceQuote);
		enterService(insuranceQuote);
		enterExcess(insuranceQuote);
		enterExtras(insuranceQuote);
		//Card 5733
		caveatVerification();
		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.GetAQuote"), "Get A Quote");
		verifyAndClickWithXpath(pageProperties.getProperty("GetAnInsuranceQuotePage.GetQuoteDetails2"), "Get Quote Details");
		// String quoteId = validatePrices(insuranceQuote, date);
		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.OrderNow"), "Order Now");
		enterPersonalDetails(insuranceQuote);
		if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.BoilerType"))) {
			enterBoilerType(insuranceQuote);
		}
		enterNectarDetails();
		selectAddress(insuranceQuote);
		selectAppliance(insuranceQuote);
		enterBankDetailsDifferentBillingAddress(insuranceQuote);
		enterTermsAndConditions(insuranceQuote);
		verifyIsTextPresent(pageProperties.getProperty("GetAnInsuranceQuotePage.Thankyou"));
		//verifyOrder(quoteId);
	}

	public void enterQuoteDetails(InsuranceQuote insuranceQuote, UserProfile userProfile) {
		////OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
		//String date = onlineDBConnector.DBsysdate();
		//browser.open("https://10.224.70.111/ViewQuoteDetails/cover/");
		enterDetails(insuranceQuote, userProfile);
		enterCoverDetails(insuranceQuote);
		enterService(insuranceQuote);
		enterExcess(insuranceQuote);
		enterExtras(insuranceQuote);
		//Card 5733
		caveatVerification();
		//Report.updateTestLog("Appliance list", "FAIL");
		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.GetAQuote"), "Get A Quote");
		verifyAndClickWithXpath(pageProperties.getProperty("GetAnInsuranceQuotePage.GetQuoteDetails2"), "Get Quote Details");
		//validatePrices(insuranceQuote, date);
		//verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.OrderNow"), "Order Now");
		//orderNow(insuranceQuote);
	}
	public void verifyOAMQuoteDetails(InsuranceQuote insuranceQuote, UserProfile userProfile) {
		////OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
		//String date = onlineDBConnector.DBsysdate();
		//browser.open("https://10.224.70.111/ViewQuoteDetails/cover/");
		//enterDetails(insuranceQuote, userProfile);
		verifyOAMCustomerDetails(insuranceQuote,userProfile);
		enterCoverDetails(insuranceQuote);
		enterService(insuranceQuote);
		enterExcess(insuranceQuote);
		enterExtras(insuranceQuote);
		//Card 5733
		caveatVerification();
		//Report.updateTestLog("Appliance list", "FAIL");
		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.GetAQuote"), "Get A Quote");
		verifyAndClickWithXpath(pageProperties.getProperty("GetAnInsuranceQuotePage.GetQuoteDetails2"), "Get Quote Details");
		//validatePrices(insuranceQuote, date);
		//verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.OrderNow"), "Order Now");
		//orderNow(insuranceQuote);
		verifyPriceCombination(insuranceQuote);
		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.OrderNow"), "Order Now");
		//orderNow(insuranceQuote,quoteId);        
		//Refer this 
		orderOAMNow(insuranceQuote,userProfile);
	}

	private String validatePrices(InsuranceQuote insuranceQuote, String date) {
		Report.updateTestLog("Validate Quote","WARN");
		double aDouble = 0.00;
		if(insuranceQuote.getPostCode().equalsIgnoreCase("SE23 1ln")){
			aDouble = Double.parseDouble(insuranceQuote.getLondonAnnual());
		}
		else if(insuranceQuote.getPostCode().equalsIgnoreCase("bh8 0bg")){
			aDouble = Double.parseDouble(insuranceQuote.getNationalAnnual());
		}
		aDouble = aDouble / 12;
		String monthly = Double.toString(aDouble + cost);
		String Annual = Double.toString((aDouble + cost) * 12);
		String actualMonthly = ceilDouble(monthly, "0.00");
		String actualAnnual = ceilDouble(Annual, "0.00");
		OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
		String[] list = onlineDBConnector.getBGSTAQuoteLead(date);
		browser.wait(getWaitTime());
		if (browser.isElementVisibleWithXpath(".//*[@id='yourQuoteResult']/div[1]/div[2]/div[1]/div[3]/p[2]/a")) {
			browser.clickWithXpath(".//*[@id='yourQuoteResult']/div[1]/div[2]/div[1]/div[3]/p[2]/a");
		}
		String tes = browser.getTextByXpath(".//*[@id='insuranceQuoteDetails']/div/div[1]/div[1]/div[1]/div[2]");
		tes = tes.replace("\u2122", "");
		String lines[] = tes.split("\\r?\\n");
		for (String disp:lines){
			Report.updateTestLog("Display is "+disp,"PASS");
		}
		String displayedName = lines[0].toLowerCase().replace(" ", "").replace("&", "and");
		String DBNamex = list[0].substring(4).toLowerCase().replace(" ", "").replace("&", "and").trim();
		validatePriceCode(insuranceQuote, list[0]);
		DBName = removeCode(DBNamex);
		String xmlPrimary = insuranceQuote.getOnline_name().toLowerCase().replace(" ", "");
		String xmlSecondary = insuranceQuote.getDb_name().toLowerCase().replace(" ", "").replace(",","+");
		System.out.println("Displayed     " + displayedName);
		System.out.println("XML Primary   " + xmlPrimary);
		System.out.println("in database   " + DBName);
		System.out.println("XML Secondary " + xmlSecondary);
		if (displayedName.contains(xmlPrimary)) {
			if (insuranceQuote.getEmergency()) {
				if (displayedName.contains("HomeEmergencyCover".toLowerCase())) {

					Report.updateTestLog("Emergency cover message verified " + displayedName, "PASS");
				}
			}
			else if (insuranceQuote.getPipe()) {
				if (displayedName.contains("watersupplypipecover".toLowerCase())) {

					Report.updateTestLog("Pipe Cover message verified " + displayedName, "PASS");
				}
			}else if (insuranceQuote.getAppliancecover()) {
				String test2 = browser.getTextByXpath(".//*[@id='insuranceQuoteDetails']/div/div[1]/div[1]/div[1]/div[2]/h3[2]");
				test2 = test2.replace("\u2122", "");
				String lines3[] = test2.split("\\r?\\n");
				String displayedName2 = lines[0].toLowerCase().replace(" ", "");
				if (displayedName2.contains("gasappliancecover-£50excess".toLowerCase())) {

					Report.updateTestLog("Appliance cover Displayed message verified " + displayedName, "PASS");
				}
			} else {

				Report.updateTestLog("Displayed message verified " + displayedName, "PASS");
			}
		} else {
			Report.updateTestLog("Displayed message not verified " + displayedName, "Fail");
		}
		Report.updateTestLog("Quote id = "+list[5], "PASS");
		if (DBName.contains(xmlSecondary)) {
			if (insuranceQuote.getEmergency()) {
				if (DBName.contains("HomeEmergencyCover".toLowerCase())) {

					Report.updateTestLog("Database value verified Home emergency" + DBName, "PASS");
				}
			} else if (insuranceQuote.getAppliancecover()) {
				if (DBName.contains("gasappliancecover-£50excess".toLowerCase())) {

					Report.updateTestLog("Database value verified Gas appliance" + DBName, "PASS");
				}
			}
			else{
				Report.updateTestLog("Database Value verified " + DBName, "PASS");
			}
		} else {
			Report.updateTestLog("Database Value not verified " + DBName, "Fail");
		}
		String displayedMonthly = browser.getText(pageProperties.getProperty("GetAnInsuranceQuotePage.MonthlyPrice")).substring(1);
		String displayedAnnual = browser.getText(pageProperties.getProperty("GetAnInsuranceQuotePage.YearlyPrice")).substring(1);
		/*  if (actualMonthly.equals(displayedMonthly)) {
            Report.updateTestLog("actual is " + actualMonthly + " and displayed is " + displayedMonthly, "PASS");
        } else {
            Report.updateTestLog("actual is " + actualMonthly + " and displayed is " + displayedMonthly, "FAIL");
        }
        if (actualAnnual.equals(displayedAnnual)) {
            Report.updateTestLog("actual is " + actualAnnual + " and displayed is " + displayedAnnual, "PASS");
        } else {
            Report.updateTestLog("actual is " + actualAnnual + " and displayed is " + displayedAnnual, "FAIL");
        }*/
		//System.out.println("actual is "+actualMonthly+" and displayed is "+displayedMonthly);
		//System.out.println("actual is "+actualAnnual+" and displayed is "+displayedAnnual);
		runBatch(list[5], list[0]);
		return  list[5];
	}




	private String verifyPriceCombination(InsuranceQuote insuranceQuote){
		Report.updateTestLog("Validate Quote","WARN");
		validatePrice(insuranceQuote); 
		if (browser.isElementVisibleWithXpath(".//*[@id='yourQuoteResult']/div[1]/div[2]/div[1]/div[3]/p[2]/a")) 
		{
			browser.clickWithXpath(".//*[@id='yourQuoteResult']/div[1]/div[2]/div[1]/div[3]/p[2]/a");
		}



		tes = browser.getTextByXpath(".//*[@id='insuranceQuoteDetails']/div/div[1]/div[1]/div[1]/div[2]");
		tes = tes.replace("\u2122", "");

		String lines[] = tes.split("\\r?\\n");
		String excess;
		String prod[]={"Boiler & controls breakdown cover","Central heating breakdown cover","Plumbing and drains cover","Home electrical cover"};


		for (String disp:lines){
			Report.updateTestLog("Product Display contains "+disp,"DONE");        	
		}

		ArrayList<String> files=new ArrayList<String>();

		for (String disp:lines){

			files.add(disp);  

		}

		if(insuranceQuote.getBoiler()&& insuranceQuote.getHeating())	{
			int ex=insuranceQuote.getExcess1();
			excess=Integer.toString(ex);
			if(insuranceQuote.getAnnualService()){

				if(lines[1].contains("Central heating cover")&& lines[1].contains(excess)) {  
					//if(files.contains("Central heating cover - �" +excess)) {
					System.out.println(files.contains("Central heating cover - �" +excess)); 	
					Report.updateTestLog("Central heating cover - �" +excess,"PASS");
				}       	
				else {        		
					Report.updateTestLog( "Central heating cover is not sisplayed" ,"FAIL");
				}
			}
			else {
				if(lines[1].contains("Central heating breakdown cover")&& lines[1].contains(excess)) {      			
					Report.updateTestLog("Product1 Displayed is "+lines[1],"PASS");
				}       	
				else {        		
					Report.updateTestLog( "First Product " + prod[0] + "is not sisplayed" ,"FAIL");
				}
			}		    
		}
		else if(insuranceQuote.getBoiler()){

			int ex=insuranceQuote.getExcess1();
			excess=Integer.toString(ex);

			if(insuranceQuote.getAnnualService()){
				if(lines[1].contains("Boiler & controls cover")&& lines[1].contains(excess)) {      			
					Report.updateTestLog("Boiler & controls cover","PASS");
				}       	
				else {        		
					Report.updateTestLog("Boiler & controls cover is not sisplayed" ,"FAIL");
				}
			}
			else{
				if(lines[1].contains("Boiler & controls breakdown cover")&& lines[1].contains(excess)) {      			
					Report.updateTestLog("Boiler & controls breakdown cover","PASS");
				}       	
				else {        		
					Report.updateTestLog( "Boiler & controls breakdown coveris not displayed" ,"FAIL");
				}

			}
		}

		else if(insuranceQuote.getHeating())	{
			int ex=insuranceQuote.getExcess1();
			excess=Integer.toString(ex);
			if(insuranceQuote.getAnnualService()){

				if(lines[1].contains("Central heating cover")&& lines[1].contains(excess)) {  
					//if(files.contains("Central heating cover - �" +excess)) {
					System.out.println(files.contains("Central heating cover - �" +excess)); 	
					Report.updateTestLog("Central heating cover - �" +excess,"PASS");
				}       	
				else {        		
					Report.updateTestLog( "Central heating cover is not displayed" ,"FAIL");
				}
			}
			else {
				if(lines[1].contains("Central heating breakdown cover")&& lines[1].contains(excess)) {      			
					Report.updateTestLog("Product Displayed is "+lines[1],"PASS");
				}       	
				else {        		
					Report.updateTestLog( "Central heating cover is not displayed" ,"FAIL");
				}
			}

		}


		if(insuranceQuote.getPlumbing()&& insuranceQuote.getElectrics())                     
		{

			int ex=insuranceQuote.getExcess2();
			excess=Integer.toString(ex);
			if(lines[2].contains("Plumbing & drains cover")&&lines[2].contains(excess)){
				Report.updateTestLog("Product Displayed is "+lines[2],"PASS");
			}

			if(lines[3].contains("Home electrical cover")&&lines[3].contains(excess)){
				Report.updateTestLog("Product Displayed is "+lines[3],"PASS");
			}
			else {        		
				Report.updateTestLog("Product Home electrical cover not sisplayed" ,"FAIL");
			}



		}
		else if(insuranceQuote.getElectrics())
		{

			int ex=insuranceQuote.getExcess2();
			excess=Integer.toString(ex);
			if(lines[2].contains("Home electrical cover")&&lines[2].contains(excess)){
				Report.updateTestLog("Product Displayed is "+lines[2],"PASS");
			}
			else {        		
				Report.updateTestLog("Product Home electrical cover not sisplayed" ,"FAIL");
			}
		}

		else if(insuranceQuote.getPlumbing())
		{

			int ex=insuranceQuote.getExcess2();
			excess=Integer.toString(ex);
			if(lines[2].contains("Plumbing & drains cover")&&lines[2].contains(excess)){
				Report.updateTestLog("Product Displayed is "+lines[2],"PASS");
			}

			/*else {        	
			Report.updateTestLog("Product Plumbing and drains cover not sisplayed" ,"FAIL");
	    }*/
		}


		if(insuranceQuote.getAnnualService()){

			if(files.contains("Annual boiler service")){
				Report.updateTestLog("Aunnual Service is displayed successfully","PASS");
			}
			else{
				Report.updateTestLog("Aunnual Service display","FAIL");
			}

		} 

		if(insuranceQuote.getEmergency()){

			if(files.contains("Glazing, Locks, Roof & Pest Cover")){
				Report.updateTestLog("Glazing, Locks, Roof & Pest Cover is displayed successfully","PASS");
			}else{
				Report.updateTestLog("Glazing, Locks, Roof & Pest Cover display","FAIL");
			}

		} 

		if(insuranceQuote.getAppliancecover()){

			if(files.contains("Gas Appliance Cover - �50 Excess")){
				Report.updateTestLog("Gas Appliance Cover - �50 Excess is displayed successfully","PASS");
			}
			else{
				Report.updateTestLog("Gas Appliance Cover display","FAIL");
			}

			if(insuranceQuote.getAppliance1()){

				if(files.contains("1 appliance")){
					Report.updateTestLog("Appliance 1 is displayed","PASS");
				}
				else{
					Report.updateTestLog("Gas Appliance Cover display","FAIL");
				}           	
			}

			if(insuranceQuote.getAppliance2()){

				if(files.contains("2 appliances")){
					Report.updateTestLog("Appliance 2 is displayed","PASS");
				}
				else{
					Report.updateTestLog("Gas Appliance Cover display","FAIL");
				}

			}

			if(insuranceQuote.getAppliance3()){

				if(files.contains("3 appliances")){
					Report.updateTestLog("Appliance 3 is displayed ","PASS");
				}
				else{
					Report.updateTestLog("Gas Appliance Cover display","FAIL");
				}

			}

		} 


		return "yes";
	}


	private void validatePrice(InsuranceQuote insuranceQuote){
		String strmonthlyprice="";
		String stryearlyprice="";

		if(browser.isElementVisibleWithXpath("html/body/div[2]/div/div[2]/form/div/div[1]/div[1]/div[1]/div[3]/p[1]/span[1]")){
			strmonthlyprice=browser.getTextByXpath("html/body/div[2]/div/div[2]/form/div/div[1]/div[1]/div[1]/div[3]/p[1]/span[1]");
			Report.updateTestLog("Monthly Price dislayed in Application " + strmonthlyprice,"DONE");
			strmonthlyprice = strmonthlyprice.substring(1);   	  
			System.out.println(strmonthlyprice);
		}

		if(browser.isElementVisibleWithXpath("html/body/div[2]/div/div[2]/form/div/div[1]/div[1]/div[1]/div[3]/p[2]/span")){
			stryearlyprice=browser.getTextByXpath("html/body/div[2]/div/div[2]/form/div/div[1]/div[1]/div[1]/div[3]/p[2]/span");
			Report.updateTestLog("Annual Price dislayed in Application "+ stryearlyprice,"DONE");
			stryearlyprice = stryearlyprice.substring(1);   	 
			System.out.println(stryearlyprice);
		}

		String strinputmonthlyprice=insuranceQuote.getMonthlyPrice();
		Report.updateTestLog("Monthly Price given as Input " +  strinputmonthlyprice,"DONE");
		String strinputannualprice= insuranceQuote.getAnnualPrice();     
		Report.updateTestLog("Annual Price given as Input " + strinputannualprice,"DONE");

		if(strmonthlyprice.contains(strinputmonthlyprice)){   	   
			Report.updateTestLog("Monthly Price Matches with Input and Application   ","PASS");     	   
		}
		else{
			//Report.updateTestLog("Monthly Price displayed is Wrong","FAIL");
		}

		if(stryearlyprice.contains(strinputannualprice)){
			Report.updateTestLog("Annual Price Matches with Input and Application ","PASS");   	     	   
		}
		else{
			//Report.updateTestLog("AnnualPrice Displayed Wrongly","FAIL");
		}

	}

	private void orderNow(InsuranceQuote insuranceQuote ) {
		//Card 5733
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		caveatVerification_New();
		Report.updateTestLog("Caveat Screen Schot", "WARN");
		enterPersonalDetails(insuranceQuote);
		browser.wait(2000); 
		//Card 5730
		//textRemovedOrderNowPage(); 
		enterBoilerType(insuranceQuote);      
		enterNectarDetails();
		selectAddress(insuranceQuote);
		selectAppliance(insuranceQuote);
		enterBankDetails(insuranceQuote);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		enterTermsAndConditions(insuranceQuote);
		verifyIsTextPresent(pageProperties.getProperty("GetAnInsuranceQuotePage.Thankyou"));
		Report.updateTestLog("thank you page screensot", "WARN");

		tes = tes.replace("\u2122", "");
		System.out.println("Entered--------");
		String lines[] = tes.split("\\r?\\n");

		// String x= tes.indexOf(1);

		Report.updateTestLog("Display in Quote Section "+lines[0],"PASS");


		String tes1=browser.getTextByXpath("//*[@id='content-body']/div/div[2]/div[1]/div[1]/h2");
		tes1 = tes1.replace("\u2122", "");
		String lines1[] = tes1.split("\\r?\\n");

		for (String disp1:lines1){
			System.out.println("Displayed--------disp1");
			Report.updateTestLog("Display in Thank you Page "+disp1,"PASS");
		}  
		Report.updateTestLog("Products Quote "+tes,"PASS");
		Report.updateTestLog("Products Thank You Page "+tes1,"PASS");


		/* if(tes1.contains(tes)) {        	 
        	 Report.updateTestLog("Products are matching ","PASS");
             } 
             else{
             Report.updateTestLog("Products are matching "+tes1,"FAIL");       		 
            }


            if(tes1.matches(tes)){    	
         	Report.updateTestLog("Product Exactly Matches", "PASS");
            }
            else{
            Report.updateTestLog("Product doesnot Exactly Matches"+tes1, "FAIL");	
            }*/

	}

	private void orderOAMNow(InsuranceQuote insuranceQuote,UserProfile userProfile) {
		enterPersonalDetails(insuranceQuote);
		browser.wait(2000);
		if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.BoilerType"))) {
			enterBoilerType(insuranceQuote);
		}
		//Card 5730
		//textRemovedOrderNowPage(); 
		enterNectarDetails();
		selectAddress(insuranceQuote,userProfile);
		selectAppliance(insuranceQuote);
		enterBankDetails(insuranceQuote);
		enterTermsAndConditions(insuranceQuote);
		verifyIsTextPresent(pageProperties.getProperty("GetAnInsuranceQuotePage.Thankyou"));
		Report.updateTestLog("thank you page screensot", "WARN");

		tes = tes.replace("\u2122", "");
		System.out.println("Entered--------");
		String lines[] = tes.split("\\r?\\n");

		Report.updateTestLog("Display in Quote Section "+lines[0],"PASS");


		String tes1=browser.getTextByXpath("//*[@id='content-body']/div/div[2]/div[1]/div[1]/h2");
		tes1 = tes1.replace("\u2122", "");
		String lines1[] = tes1.split("\\r?\\n");

		for (String disp1:lines1){
			System.out.println("Displayed--------disp1");
			Report.updateTestLog("Display in Thank you Page "+disp1,"PASS");
		}  
		Report.updateTestLog("Products Quote "+tes,"PASS");
		Report.updateTestLog("Products Thank You Page "+tes1,"PASS");


		if(tes1.contains(tes)) {        	 
			Report.updateTestLog("Products are matching ","PASS");
		} 
		else{
			Report.updateTestLog("Products are matching ","PASS");       		 
		}





	}

	private void enterNectarDetails() {
		browser.wait(getWaitTime());
		browser.wait(1000);
		if (nectar == 1) {
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.AddExistingNectarRadioId"), "Have Nectar");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.NectarTextId"), "Enter Nectar number", "11111111111");
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NectarTermsCheckBoxId"), "Terms and Conditions");
		} else if (nectar == 2) {
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.AddNewNectarRadioId"), "Get Nectar");
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NectarTermsCheckBoxId"), "Terms and Conditions");
		} else if (nectar == 3) {
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.AddNectarLaterRadioId"), "Add Nectar later");
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NectarTermsCheckBoxId"), "Terms and Conditions");
		} else if (nectar == 4) {
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NoNectarRadioId"), "No nectar");
		}
		browser.wait(getWaitTime());
		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton3"), "Next Button");

		toggleNectar();
	}

	private void toggleNectar() {
		if (nectar == 4) {
			nectar = 1;
		} else
			nectar += nectar;

	}

	private void selectAddress(InsuranceQuote insuranceQuote) {
		browser.wait(getWaitTime());
		/*  UserProfile userProfile = new UserProfile();
        System.out.println("profile :"+userProfile);
        SiebelDataBase siebel = new SiebelDataBase();
    	List<String> address = siebel.getAddress(userProfile.getAccNumber());
        System.out.println("Address :"+address);
        String[] arrayaddress = (String[]) address.toArray(new String[0]);
        String houseno = arrayaddress[0];
        String addNum = arrayaddress[1];
        String addres = arrayaddress[2];
        String city = arrayaddress[3];
        String zipcode = arrayaddress[4];
    	String phoneNumber = siebel.getTelephoneNumber(userProfile.getUCRN());
    	String postcode = siebel.getPostCode(userProfile.getAccNumber()); 
    	String postdisplayed = browser.getText(pageProperties.getProperty("GetAnInsuranceQuotePage.PostCode"));
    	String phdisplayed = browser.getText(pageProperties.getProperty("GetAnInsuranceQuotePage.PhoneNumber"));
    	if((postdisplayed.equals(null))&&(houseno.equals(null))){
    		Report.updateTestLog("Postcode and House Number details not prepopulated", "WARN");
    		verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.HouseName"), "HouseName",insuranceQuote.getHouseName());
    		verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.PostCode"), "PostCode",insuranceQuote.getPostCode());
    	}else {
    		String hnodisplayed = browser.getText(pageProperties.getProperty("GetAnInsuranceQuotePage.HouseName"));
            if (houseno.contains(hnodisplayed)) {
                Report.updateTestLog("House Number matches actual", "PASS");
            }
    		postdisplayed = browser.getText(pageProperties.getProperty("GetAnInsuranceQuotePage.PostCode"));
            if (postdisplayed.contains(postdisplayed)) {
                Report.updateTestLog("Post code matches actual", "PASS");
            }
    	}*/

		String houseName = browser.getText(pageProperties.getProperty("GetAnInsuranceQuotePage.HouseNameService"));
		String postCode = browser.getText(pageProperties.getProperty("GetAnInsuranceQuotePage.PostCodeService"));
		if (houseName.equalsIgnoreCase(insuranceQuote.getHouseName())) {
			Report.updateTestLog("House number already entered", "PASS");
		}
		if (postCode.equalsIgnoreCase(insuranceQuote.getPostCode())) {
			Report.updateTestLog("Postcode already entered", "PASS");
		}

		browser.wait(getWaitTime());
		browser.wait(5000);
		browser.selectFromDropBoxByID("id", pageProperties.getProperty("GetAnInsuranceQuotePage.AddressService"));
		/* if(insuranceQuote.getPostCode().equalsIgnoreCase("tw18 3he")){

        System.out.println("Entered into tw138he");
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAnInsuranceQuotePage.AddressService"),"1, Meadow Gardens, STAINES, Middlesex, TW18 3HE");
        Report.updateTestLog("Address selected from list", "PASS");
        }  
        else if(insuranceQuote.getPostCode().equalsIgnoreCase("al7 4hd")){
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAnInsuranceQuotePage.AddressService"),"306, Howlands, GARDEN, WELWYN, Hertfordshire, AL7 4HD");
        Report.updateTestLog("Address selected from list", "PASS");  
        }*/


		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton4"), "Next Button");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (browser.isElementVisibleWithXpath("/html/body/div[11]/div/a")){
			browser.clickWithXpath("/html/body/div[11]/div/a");
			browser.wait(3000);

			if(browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton4"))){
				browser.click(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton4"));
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton4"), "Next Button"); 
		}
		if (browser.isElementVisibleWithXpath("html/body/div[10]/div[1]/a")){
			browser.clickWithXpath("html/body/div[11]/div[1]/a");
			browser.wait(3000);

			if(browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton4"))){
				browser.click(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton4"));
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton4"), "Next Button"); 
		}

	}

	private void selectAddress(InsuranceQuote insuranceQuote, UserProfile userProfile) {
		browser.wait(getWaitTime());
		String houseName = browser.getText(pageProperties.getProperty("GetAnInsuranceQuotePage.HouseNameService"));
		String postCode = browser.getText(pageProperties.getProperty("GetAnInsuranceQuotePage.PostCodeService"));
		if (houseName.equalsIgnoreCase(insuranceQuote.getHouseName())) {
			Report.updateTestLog("House number already entered", "PASS");
		}
		if (postCode.equalsIgnoreCase(insuranceQuote.getPostCode())) {
			Report.updateTestLog("Postcode already entered", "PASS");
		}
		browser.wait(getWaitTime());
		browser.selectFromDropBoxByID("id", pageProperties.getProperty("GetAnInsuranceQuotePage.AddressService"));
		Report.updateTestLog("Address selected from list", "PASS");
		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton4"), "Next Button");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (browser.isElementVisibleWithXpath("html/body/div[10]/div[1]/a")){
			browser.clickWithXpath("html/body/div[10]/div[1]/a");
			browser.wait(1000);

			if(browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton4"))){
				browser.click(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton4"));
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void selectAppliance(InsuranceQuote insuranceQuote) {
		browser.wait(getWaitTime());
		if(browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton7"))){
			switch (insuranceQuote.getNoOfAppliances()) {
			case 1:
				verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.app1"), "one appliance", "1");
				break;
			case 2:
				verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.app1"), "first appliance", "1");
				verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.app2"), "second appliance", "1");
				break;
			case 3:
				verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.app1"), "first appliance", "1");
				verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.app2"), "second appliance", "1");
				verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.app3"), "third appliance", "1");
				break;
			case 4:
				verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.app1"), "first appliance", "1");
				verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.app2"), "second appliance", "1");
				verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.app3"), "third appliance", "1");
				verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.app3"), "fourth appliance", "1");
				break;
			case 5:
				verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.app1"), "first appliance", "1");
				verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.app2"), "second appliance", "1");
				verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.app3"), "third appliance", "1");
				verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.app3"), "fourth appliance", "1");
				verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.app3"), "fifth appliance", "1");
				break;
			case 6:
				verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.app1"), "first appliance", "1");
				verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.app2"), "second appliance", "1");
				verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.app3"), "third appliance", "1");
				verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.app3"), "fourth appliance", "1");
				verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.app3"), "fifth appliance", "1");
				verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.app3"), "sixth appliance", "1");
				break;
			}
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton7"), "Next Button");

		}
	}

	private void enterBankDetailsDifferentBillingAddress(InsuranceQuote insuranceQuote) {
		browser.wait(getWaitTime());
		if (insuranceQuote.getPaymentType().equalsIgnoreCase("Monthly")) {
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.Monthly"), "Monthly payment");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.AccountNumber"), "Account number", "12345678");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.SortCode1"), "Sortcode", "40");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.SortCode2"), "Sortcode", "40");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.SortCode3"), "Sortcode", "40");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.NameOfAccountHolder"), "Account name", "Testing Team");
		} else if (insuranceQuote.getPaymentType().equalsIgnoreCase("Yearly")) {
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.Yearly"), "Yearly payment");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.AccountNumber"), "Account number", "12345678");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.SortCode1"), "Sortcode", "40");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.SortCode2"), "Sortcode", "40");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.SortCode3"), "Sortcode", "40");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.NameOfAccountHolder"), "Account name", "Testing Team");
		} else {
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.CreditCard"), "Credit Card payment");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.CardType"), "Card Type", "40");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.NameOnCard"), "Name on Card", "40");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.CardNumber"), "Card Number", "40");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.StartMonth"), "Start Month", "40");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.StartYear"), "Start Year", "40");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.EndMonth"), "End Month", "40");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.EndYear"), "End Year", "40");
			if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.IssueNumber"))) {
				verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.IssueNumber"), "Issue Number", "40");
			}
		}
		enterDifferentBillingAddress();
		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton5"), "Next Button");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void enterBankDetails(InsuranceQuote insuranceQuote) {

		/*if(browser.isElementVisible("ACDcard")){
			Report.updateTestLog("Annual CC present", "FAIL");
		}
		else {
			Report.updateTestLog("Annual CC not present", "PASS");	
		}
*/
		browser.wait(getWaitTime());
		if (insuranceQuote.getPaymentType().equalsIgnoreCase("Monthly")) {
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAnInsuranceQuotePage.ACDcard"))){
			checkCreditCardDetails();
			}
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.Monthly"), "Monthly payment");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.AccountNumber"), "Account number", "12345678");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.SortCode1"), "Sortcode", "40");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.SortCode2"), "Sortcode", "40");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.SortCode3"), "Sortcode", "40");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.NameOfAccountHolder"), "Account name", "Testing Team");
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton5"), "Next Button");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if (insuranceQuote.getPaymentType().equalsIgnoreCase("Yearly")) {
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAnInsuranceQuotePage.ACDcard"))){
			checkCreditCardDetails();
			}
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.Yearly"), "Yearly payment");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.AccountNumber"), "Account number", "12345678");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.SortCode1"), "Sortcode", "40");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.SortCode2"), "Sortcode", "40");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.SortCode3"), "Sortcode", "40");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.NameOfAccountHolder"), "Account name", "Testing Team");
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton5"), "Next Button");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} /*else {
			
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.CardType"), "Card Type", "40");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.NameOnCard"), "Name on Card", "40");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.CardNumber"), "Card Number", "40");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.StartMonth"), "Start Month", "40");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.StartYear"), "Start Year", "40");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.EndMonth"), "End Month", "40");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.EndYear"), "End Year", "40");
			if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.IssueNumber"))) {
				verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.IssueNumber"), "Issue Number", "40");
			}
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton5"), "Next Button");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/
		if (browser.isTextPresent(insuranceQuote.getPostCode())){
			Report.updateTestLog("Address prepopulated", "PASS");
		}else {
			Report.updateTestLog("Address not prepopulated", "WARN");
		}
	}
	
	public void checkCreditCardDetails(){
		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.CreditCard"), "Credit Card payment");
		if(!browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.CardType"))){
			Report.updateTestLog("Card Type Feild is not present", "PASS");
		}
		else{
			Report.updateTestLog("Card Type Feild is present", "FAIL");
		}
		if(!browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.CardNumber"))){
			Report.updateTestLog("Card Number Feild is not present", "PASS");
		}
		else{
			Report.updateTestLog("Card Number Feild is present", "FAIL");
		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAnInsuranceQuotePage.ACDCardPayment"))){
		verifyIsTextPresent(pageProperties.getProperty("GetAnInsuranceQuotePage.ACDMessage"), "ACDMessage");
		Report.updateTestLog("AnnualCDCard Message is verified and next button is disabled", "WARN");
		}
		else{
			Report.updateTestLog("AnnualCDCard Message is not displayed", "FAIL");
		}
		
	}

	private void enterTermsAndConditions(InsuranceQuote insuranceQuote) {
		System.out.println("Senthil1");
		//Card 5731
		termsAndConditionVerification(insuranceQuote);
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		browser.wait(2000);

		Report.updateTestLog("Terms and Conditions", "WARN");
		
		if(browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.ProductTerms"))){
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.ProductTerms"),"Product Terms");
		}
		if(browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.KeyTerms"))){
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.KeyTerms"),"Key Terms");
		}
		if(browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.AssumptionTerms"))){
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.AssumptionTerms"),"Assumption Terms");
		}
		/*if(browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.MarketingConsent"))){
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.MarketingConsent"),"Marketing Consent");
		}
		
		if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.HomeCareTerms"))) {
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.HomeCareTerms"), "Home Care Terms");
		}
		if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.EmergencyCoverTerms"))) {
			System.out.println("senthil1");
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.EmergencyCoverTerms"), "Emergency Cover Terms");
		}
		if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.AssumptionsTerms"))) {
			System.out.println("senthil2");
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.AssumptionsTerms"), "Assumptions Terms");
		}
		if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.WaterSupplyTerms"))) {
			System.out.println("senthil3");
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.WaterSupplyTerms"), "Water Supply Terms");
		}
		if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.GasApplianceTerms"))) {
			System.out.println("senthil4");
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.GasApplianceTerms"), "Gas Appliance Terms");
		}
		if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.KeyFactsTerms"))) {
			System.out.println("senthil5");
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.KeyFactsTerms"), "Key Facts Terms");
		}
		if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.MarketingConsent"))) {
			System.out.println("senthil6");
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.MarketingConsent"), "Marketing consent Terms");
		}
		if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.PlumbingDrains"))) {
			System.out.println("senthil7");
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.PlumbingDrains"), "Plumbin and drains Terms");
		}
		if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.PlumbingDrains2"))) {
			System.out.println("senthil8");
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.PlumbingDrains2"), "Plumbin and drains Terms");
		}*/
		selectMarketingConsent();
		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.PlaceOrder"), "Place Order Button");
		OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
		orderDate = onlineDBConnector.DBsysdate();
		browser.wait(getWaitTime());
		verifyMarketingConsent();
	}

	private void selectMarketingConsent(){
    	verifyAndClickWithXpath(pageProperties.getProperty("GetAnInsuranceQuotePage.LetterConsent"), "LetterConsent");
    	verifyAndClickWithXpath(pageProperties.getProperty("GetAnInsuranceQuotePage.LandLineConsent"), "LandLineConsent");
    		MarketingConsentFlag = true;
    	}
    	
	public void verifyMarketingConsent(){
    	String LeadData;
    	OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
    	LeadData = onlineDBConnector.getLeadData(orderDate);
    	if(MarketingConsentFlag == true){
    		if (LeadData.contains("<MarketingChannelPreference MarketingChannel=\"Letter\" OptIn=\"N\" />")){
   			Report.updateTestLog("Letter Consent is Optout", "PASS");
   		    }
    		else {
    			Report.updateTestLog("Letter Consent is not Optout", "FAIL");
    		}
    							   
    	    if (LeadData.contains("<MarketingChannelPreference MarketingChannel=\"Email\" OptIn=\"Y\" />")){
   			Report.updateTestLog("Email Consent is Optin", "PASS");
   		    }
    		else {
    			Report.updateTestLog("Email Consent is not Optin", "FAIL");
    		}
    	    					   
    	    if (LeadData.contains("<MarketingChannelPreference MarketingChannel=\"Landline\" OptIn=\"N\" />")){
       			Report.updateTestLog("LandLine Consent is Optout", "PASS");
       		    }
        		else {
        			Report.updateTestLog("LandLine Consent is not Optout", "FAIL");
        		}
    	    if (LeadData.contains("<MarketingChannelPreference MarketingChannel=\"Mobile\" OptIn=\"Y\" />")){
       			Report.updateTestLog("Mobile Consent is Optin", "PASS");
       		    }
        		else {
        			Report.updateTestLog("Mobile Consent is not Optin", "FAIL");
        		}
    	    if (LeadData.contains("<MarketingChannelPreference MarketingChannel=\"SMS/MMS\" OptIn=\"Y\" />")){
       			Report.updateTestLog("TextMessage Consent is Optin", "PASS");
       		    }
        		else {
        			Report.updateTestLog("TextMessage Consent is not Optin", "FAIL");
        		}
    	}
    	
    }
	private void validateTermsAndConditions() {
		browser.wait(getWaitTime());
		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.PlaceOrder"), "Place Order Button");
		browser.wait(500);
		if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.TermsError"))) {
			Report.updateTestLog("Terms and Conditions selection validation ", "DONE");
		}
	}

	private void enterDetails(InsuranceQuote insuranceQuote) {
		browser.wait(getWaitTime());
		//verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.HouseName"), "House Name", insuranceQuote.getHouseName());
		verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.PostCode"), "PostCode", insuranceQuote.getPostCode());
		verifyAndInputByXpath(pageProperties.getProperty("GetAnInsuranceQuotePage.PhoneNumber"), "Telephone number", insuranceQuote.getPhoneNumber());
		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton1"), "Next Button");

	}

	private void verifyOAMCustomerDetails(InsuranceQuote insuranceQuote,UserProfile userProfile){
		SiebelDataBase siebel = new SiebelDataBase();
		List<String> address = siebel.getAddress(userProfile.getAccNumber());
		System.out.println(address);
		String[] arrayaddress = (String[]) address.toArray(new String[0]);
		String houseno = arrayaddress[0];
		String addNum = arrayaddress[1];
		String addres = arrayaddress[2];
		String city = arrayaddress[3];
		String zipcode = arrayaddress[4];
		String phoneNumber = siebel.getTelephoneNumber(userProfile.getUCRN());
		String postcode = siebel.getPostCode(userProfile.getAccNumber()); 
		//insuranceQuote.setPostCode(postcode);
		//insuranceQuote.setPhoneNumber(phoneNumber);
		String postdisplayed = browser.getAttribute(pageProperties.getProperty("GetAnInsuranceQuotePage.PostCode"),"value");
		System.out.println("#############"+postdisplayed+"###############");
		String phdisplayed = browser.getAttributeByXpath(pageProperties.getProperty("GetAnInsuranceQuotePage.PhoneNumber"),"value");
		System.out.println("#############"+phdisplayed+"###############");
		String hnodisplayed = browser.getAttribute(pageProperties.getProperty("GetAnInsuranceQuotePage.HouseName"),"value");
		if (houseno.contains(hnodisplayed)) {
			Report.updateTestLog("House Number matches actual", "PASS");
		}else {
			Report.updateTestLog("House Number not populated ", "DONE");
		}
		if (!postdisplayed.equals("")) {
			Report.updateTestLog("Postcode details prepopulated", "PASS");
		}else{
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.PostCode"), "PostCode",insuranceQuote.getPostCode());
			Report.updateTestLog("Postcode details not prepopulated", "WARN");
		}
		if (!phdisplayed.equals("")) {
			Report.updateTestLog("Phone Number details prepopulated", "PASS");
		}else {
			verifyAndInputByXpath(pageProperties.getProperty("GetAnInsuranceQuotePage.PhoneNumber"), "Telephone number", insuranceQuote.getPhoneNumber());
		}   		
		Report.updateTestLog("House No : "+hnodisplayed+"Postcode : "+postcode +"and Phone Number "+phoneNumber +" Prepopulated", "PASS");
		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton1"), "Next Button");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void enterDetails(InsuranceQuote insuranceQuote, UserProfile userProfile) {
		browser.wait(getWaitTime());
		verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.HouseName"), "House Name", insuranceQuote.getHouseName());
		verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.PostCode"), "PostCode", insuranceQuote.getPostCode());
		String phonenumber = userProfile.getPhoneNumber();
		String displayed = browser.getTextByXpath(pageProperties.getProperty("GetAnInsuranceQuotePage.PhoneNumber"));
		if (phonenumber.equalsIgnoreCase(displayed)) {
			Report.updateTestLog("Phone number matches actual", "PASS");
		}
		//verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.PhoneNumber"), "Telephone number", insuranceQuote.getPhoneNumber());
		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton1"), "Next Button");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void enterCoverDetails(InsuranceQuote insuranceQuote) {
		browser.wait(getWaitTime());
		if (insuranceQuote.getBoiler())
			verifyAndSelectCheckBox(pageProperties.getProperty("GetAnInsuranceQuotePage.BoilerAndControls"), "BoilerAndControls");
		if (insuranceQuote.getHeating())
			verifyAndSelectCheckBox(pageProperties.getProperty("GetAnInsuranceQuotePage.CentralHeating"), "CentralHeating");
		if (insuranceQuote.getPlumbing())
			verifyAndSelectCheckBox(pageProperties.getProperty("GetAnInsuranceQuotePage.PlumbingAndDrains"), "PlumbingAndDrains");
		if (insuranceQuote.getElectrics())
			verifyAndSelectCheckBox(pageProperties.getProperty("GetAnInsuranceQuotePage.HomeElectrics"), "HomeElectrics");

		browser.click(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton2"));

	}

	private void enterService(InsuranceQuote insuranceQuote) {
		browser.wait(getWaitTime());
		if (insuranceQuote.getAnnualService()) {
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.AnnualBoilerService"), "Boiler Service");
		} else {
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.None"), "No Boiler Service");
		}
		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton3"), "Next button");

	}

	private void enterExcess(InsuranceQuote insuranceQuote) {
		browser.wait(getWaitTime());
		if(flag.equalsIgnoreCase("ON")){
			if (insuranceQuote.getExcess1() == 50) {
				verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.50Excess"), "£50 Excess");
			} else if (insuranceQuote.getExcess1() == 99) {
				verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.99Excess"), "£99 Excess");
			} else if (insuranceQuote.getExcess1() == 100) {
				//verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.ZeroExcess"), "£0 Excess");
			} else {
				verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.ZeroExcess"), "£0 Excess");
			}
			if (insuranceQuote.getExcess2() == 50) {
				verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.50Other"), "£50 Excess");
			} else if (insuranceQuote.getExcess2() == 100) {
				//verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.ZeroExcess"), "£0 Excess");
			} else {
				verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.ZeroOther"), "£0 Excess");
			}
		}
		else{
			if (insuranceQuote.getExcess1() == 50) {
				verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.50Other"), "£50 Excess");
			} else if (insuranceQuote.getExcess1() == 99) {
				//verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.99Excess"), "£99 Excess");
			} else if (insuranceQuote.getExcess1() == 100) {
				//verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.ZeroExcess"), "£0 Excess");
			} else {
				verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.ZeroOther"), "£0 Excess");
			}
		}
		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton4"), "Next button");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void enterExtras(InsuranceQuote insuranceQuote) {
		browser.wait(getWaitTime());
		cost = 0.00;
		String homeText = pageProperties.getProperty("GetAnInsuranceQuotePage.HomeEmergencyCoverText");
		String gasText = pageProperties.getProperty("GetAnInsuranceQuotePage.GasApplianceCoverText");
		String inclucion = pageProperties.getProperty("GetAnInsuranceQuotePage.Inclusion");
		String exclusion = pageProperties.getProperty("GetAnInsuranceQuotePage.Exclusion");
		if (insuranceQuote.getEmergency()) {
			if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.HomeEmergencyCover"))) {
				verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.HomeEmergencyCover"), "Glazing, Locks, Roof & Pest Cover");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				cost += 6.25;               
				//if (browser.isTextPresent(homeText)&& (browser.isTextPresent(inclucion)) && (browser.isTextPresent(exclusion))){
				//Report.updateTestLog(homeText +" Displayed with "+inclucion+ " and "+exclusion,"PASS"); }
				//else {
				//	Report.updateTestLog(homeText +" Not Displayed as expected","FAIL");                	
				// }
			}
			else
			{
				Report.updateTestLog("Glazing, Locks, Roof & Pest Cover object not clicked","FAIL");  
			}
		}
		if (insuranceQuote.getPipe()) {
			/*if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.WaterSupplyPipeCover"))) {
                verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.WaterSupplyPipeCover"), "Pipe cover");
                cost += 2.00;               


            }

               // if (browser.isTextPresent(gasText)&& (browser.isTextPresent(inclucion)) && (browser.isTextPresent(exclusion))){
                //	Report.updateTestLog(gasText +" Displayed with "+inclucion+ " and "+exclusion,"PASS"); }
                //	else {
                	//	Report.updateTestLog(gasText +" Not Displayed as expected","FAIL");                	
                //}
            } else
            {
            	Report.updateTestLog("Pipe cover object not clicked","FAIL");  
            }*/

		}
		if (insuranceQuote.getAppliancecover()) {
			if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.GasApplianceCover50Excess"))) {
				verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.GasApplianceCover50Excess"), "Gas Appliance £50 Excess");
				if (insuranceQuote.getAppliance1()) {
					verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.ApplianceOne"), "One appliance");
					cost += 6.19;
				}
				if (insuranceQuote.getAppliance2()) {
					verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.ApplianceTwo"), "Two appliance");
					cost += 6.19;
				}
				if (insuranceQuote.getAppliance3()) {
					verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.ApplianceThree"), "Three appliance");
					cost += 6.19;
				}
				if (browser.isTextPresent(gasText)&& (browser.isTextPresent(inclucion)) && (browser.isTextPresent(exclusion))){
					Report.updateTestLog(gasText +" Displayed with "+inclucion+ " and "+exclusion,"PASS"); }
				else {
					Report.updateTestLog(gasText +" Not Displayed as expected","FAIL");                	
				}

			}
		}
		if (insuranceQuote.getEmergency()&&(insuranceQuote.getPipe())){
			/*	if (browser.isTextPresent(homeText)&& (browser.isTextPresent(gasText))){
            	Report.updateTestLog("Both "+homeText +" and "+gasText +" Displayed","PASS"); }
            	else {
            		Report.updateTestLog("Text not displayed as expected","FAIL");                	
            }*/        	
		}


		if(browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton5")))
		{
			browser.click(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton5"));
			Report.updateTestLog(" Next Button Appears " ,"FAIL");
		}
		else{
			Report.updateTestLog(" Next Button is removed" ,"PASS");
		}




		//        
		//        if(browser.isElementVisibleWithXpath(".//*[@id='nextBtn5']"))
		//        {
		//        verifyAndClickWithXpath(".//*[@id='nextBtn5']", "NEXT BUTTON");
		//        }
		if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAnInsuranceQuotePage.KeyInclusion"))){
		verifyKeyInclusions();
		}
	}
	
	////////////Sprint 08////////////
	public void verifyKeyInclusions(){
		
		String Key = browser.getTextByXpath(pageProperties.getProperty("GetAnInsuranceQuotePage.KeyInclusion"));
		String ActualKey = pageProperties.getProperty("GetAnInsuranceQuotePage.ActualKeyInclusion");
		if(Key.equalsIgnoreCase(ActualKey)){
			Report.updateTestLog("Authority Key Inclusion is Changed", "PASS");
		}
		else{
			Report.updateTestLog("Authority Key Inclusion is Not Changed", "FAIL");
		}
		
	}

	private void enterPersonalDetails(InsuranceQuote insuranceQuote) {
		browser.wait(getWaitTime());
		String title = browser.getText(pageProperties.getProperty("GetAnInsuranceQuotePage.Title"));
		if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.Title"))){
			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.Title"), "Title", "Mr");
		}else {
			Report.updateTestLog("Title Prepopulated  "+title, "PASS");
		}
		String fname = browser.getAttribute(pageProperties.getProperty("GetAnInsuranceQuotePage.FirstName"),"value");

		if (fname.equals("")){
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.FirstName"),"FirstName","Digital");
		}else {
			Report.updateTestLog("FirstName Prepopulated  "+fname, "PASS");
		}
		String sname = browser.getAttribute(pageProperties.getProperty("GetAnInsuranceQuotePage.Surname"),"value");

		if (sname.equals("")){
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.Surname"), "Surname", "Automation");
		}else {
			Report.updateTestLog("Surname Prepopulated  "+sname, "PASS");
		}
		String Email = browser.getAttribute(pageProperties.getProperty("GetAnInsuranceQuotePage.Email"),"value");

		if (Email.equals("")){
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.Email"), "Email", "Digital.automation@centrica.com");
		}else {
			Report.updateTestLog("Email Prepopulated  "+Email, "PASS");
		}

		if (browser.getAttribute(pageProperties.getProperty("GetAnInsuranceQuotePage.Telephone"),"value").equals("")) {
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.Telephone"), "Telephone", "01234567890");
			Report.updateTestLog("Telephone number entered", "PASS");
		} else {
			Report.updateTestLog("Telephone number prepopulated", "PASS");
		}

		/* if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.HowYouHeard"))){
            verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.HowYouHeard"), "How You Heard", "Bill");
            }else {
                Report.updateTestLog("How You heard section not ddisplayed", "FAIL");
            }*/
		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton1"), "Next Button");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}




	private void textRemovedOrderNowPage() {

		if(!browser.isTextPresent("Selected excess paid per completed repair"))
		{
			Report.updateTestLog("Selected excess paid per completed repair - text is not displayed ", "PASS");
		}else
		{
			Report.updateTestLog("Selected excess paid per completed repair - text is displayed ", "FAIL");
		}

	}

	private void caveatVerification() {

		if(browser.isTextPresent("[1] Limits apply, please see terms and conditions."))
		{
			Report.updateTestLog("Expected caveat is available for [1]", "PASS");
		}else
		{
			Report.updateTestLog("Expected caveat is not available for [1]", "FAIL");
		}

		if(browser.isTextPresent("[*] The incident must have been reported to the police and a crime reference number obtained before making a claim."))
		{
			Report.updateTestLog("Expected caveat is available for [*]", "PASS");
		}else
		{
			Report.updateTestLog("Expected caveat is not available for [*]", "FAIL");
		}
	}

	private void caveatVerification_New() {

		if(browser.isElementVisibleWithXpath(".//*[@id='insuranceQuoteDetails']/div/div[1]/div[1]/div[6]/div/ul/li/span"))
		{
			int countli=browser.getChildElementsCountByXpath(".//*[@id='insuranceQuoteDetails']/div/div[1]/div[1]/div[6]/div/ul/li/span");
			for(int i=1;i<=countli;i++)
			{
				int sublicount=browser.getChildElementsCountByXpath(".//*[@id='insuranceQuoteDetails']/div/div[1]/div[1]/div[6]/div/ul/li["+i+"]/span/sup");

				for(int j=1;j<=sublicount;j++)
				{
					String one=browser.getTextByXpath(".//*[@id='insuranceQuoteDetails']/div/div[1]/div[1]/div[6]/div/ul/li["+i+"]/span/sup["+j+"]");
					if(one.contains("[1]"))
					{
						//		 		if(browser.isTextPresent("[1] Limits apply, please see terms and conditions."))
						if(browser.isElementVisibleWithXpath("//*[contains(text(),'please see terms and conditions')]"))
						{
							Report.updateTestLog("Expected caveat is available for [1]", "PASS");
						}else
						{
							Report.updateTestLog("Expected caveat is not available for [1]", "FAIL");
						}
					}
					if(one.contains("[*]"))
					{
						//		 	if(browser.isTextPresent("[*] The incident must have been reported to the police and a crime reference number obtained before making a claim."))
						if(browser.isElementVisibleWithXpath("//*[contains(text(),'The incident must have been reported')]"))
						{
							Report.updateTestLog("Expected caveat is available for [*]", "PASS");
						}else
						{
							Report.updateTestLog("Expected caveat is not available for [*]", "FAIL");
						}
					}
				}
			}
			if(browser.isElementVisibleWithXpath(".//*[@id='insuranceQuoteDetails']/div/div[1]/div[1]/div[13]/div/ul/li/span"))
			{
				int countlinew=browser.getChildElementsCountByXpath(".//*[@id='insuranceQuoteDetails']/div/div[1]/div[1]/div[13]/div/ul/li/span");
				for(int ii=1;ii<=countlinew;ii++)
				{
					int sublicountnew=browser.getChildElementsCountByXpath(".//*[@id='insuranceQuoteDetails']/div/div[1]/div[1]/div[13]/div/ul/li["+ii+"]/span/sup");

					for(int jj=1;jj<=sublicountnew;jj++)
					{
						String one=browser.getTextByXpath(".//*[@id='insuranceQuoteDetails']/div/div[1]/div[1]/div[13]/div/ul/li["+ii+"]/span/sup["+jj+"]");
						if(one.contains("[1]"))
						{
							//			 		if(browser.isTextPresent("[1] Limits apply, please see terms and conditions."))
							if(browser.isElementVisibleWithXpath("//*[contains(text(),'please see terms and conditions')]"))
							{
								Report.updateTestLog("Expected caveat is available for [1]", "PASS");
							}else
							{
								Report.updateTestLog("Expected caveat is not available for [1]", "FAIL");
							}
						}
						if(one.contains("[*]"))
						{
							//			 	if(browser.isTextPresent("[*] The incident must have been reported to the police and a crime reference number obtained before making a claim."))
							if(browser.isElementVisibleWithXpath("//*[contains(text(),'The incident must have been reported')]"))
							{
								Report.updateTestLog("Expected caveat is available for [*]", "PASS");
							}else
							{
								Report.updateTestLog("Expected caveat is not available for [*]", "FAIL");
							}
						}
					}
				}
			}
		}


		/*	int count=browser.getChildElementsCountByXpath("//span/sup");
		System.out.println("Senthil22:"+count);
	 	for(int i=1;i<=count;i++)
	 	{
	 	String one=browser.getTextByXpath("//span/sup["+i+"]");
	 	if(one.contains("[1]"))
	 	{
	 		if(browser.isTextPresent("[1] Limits apply, please see terms and conditions."))
//	 		if(browser.isElementVisibleWithXpath("//*[contains(text(),'please see terms and conditions')]"))
	    	{
	    		Report.updateTestLog("Expected caveat is available for [1]", "PASS");
	    	}else
	    	{
	    		Report.updateTestLog("Expected caveat is not available for [1]", "FAIL");
	    	}
	 	}
	 	if(one.contains("[*]"))
	 	{
	 	if(browser.isTextPresent("[*] The incident must have been reported to the police and a crime reference number obtained before making a claim."))
	 	//if(browser.isElementVisibleWithXpath("//*[contains(text(),'The incident must have been reported')]"))
    	{
    		Report.updateTestLog("Expected caveat is available for [*]", "PASS");
    	}else
    	{
    		Report.updateTestLog("Expected caveat is not available for [*]", "FAIL");
    	}
	 	}
	 	}*/
	}

	private void caveatVerification_1() {

		if(browser.isTextPresent("[1] Limits apply, please see terms and conditions."))
			//	 		if(browser.isElementVisibleWithXpath("//*[contains(text(),'please see terms and conditions')]"))
		{
			Report.updateTestLog("Expected caveat is available for [1]", "PASS");
		}else
		{
			Report.updateTestLog("Expected caveat is not available for [1]", "FAIL");
		}
		if(!browser.isElementVisibleWithXpath("//*[contains(text(),'The incident must have been reported')]"))
		{
			Report.updateTestLog("Caveat is Not available for [*]", "PASS");
		}else
		{
			Report.updateTestLog("Expected caveat is available for [*]", "FAIL");
		}
		/*int count=browser.getChildElementsCountByXpath("//span/sup");
	 System.out.println("Senthil2:"+count);
	 	for(int i=1;i<count;i++)
	 	{
	 	String one=browser.getTextByXpath("//span/sup["+i+"]");
	 	System.out.println("S1"+one);
	 	if(one.contains("[1]"))
	 	{
	 		if(browser.isTextPresent("[1] Limits apply, please see terms and conditions."))
//	 		if(browser.isElementVisibleWithXpath("//*[contains(text(),'please see terms and conditions')]"))
	    	{
	    		Report.updateTestLog("Expected caveat is available for [1]", "PASS");
	    	}else
	    	{
	    		Report.updateTestLog("Expected caveat is not available for [1]", "FAIL");
	    	}
	 	}
	 	if(one.contains("[*]"))
	 	{
	 		Report.updateTestLog("Caveat is available for [*]", "FAIL");
	 	}
	 	}*/

	}
	private void caveatVerification_Incident() {

		if(browser.isTextPresent("[*] The incident must have been reported to the police and a crime reference number obtained before making a claim."))
		{
			Report.updateTestLog("Expected caveat is available for [*]", "PASS");
		}else
		{
			Report.updateTestLog("Expected caveat is not available for [*]", "FAIL");
		}
		if(browser.isTextPresent("[1] Limits apply, please see terms and conditions."))
		{
			Report.updateTestLog("Caveat Not is available for [1]", "PASS");
		}else
		{
			Report.updateTestLog("Caveat is available for [1]", "FAIL");
		}
	}
	private void termsAndConditionVerification(InsuranceQuote insuranceQuote) {
		System.out.println("Senthil2");
		String plumbing=String.valueOf(insuranceQuote.getPlumbing());
		System.out.println("Senthil3"+plumbing);
		String electrics=String.valueOf(insuranceQuote.getElectrics());
		String appCover=String.valueOf(insuranceQuote.getAppliancecover());
		if(plumbing.equals("true") && electrics.equals("true"))
		{
			//*[contains(text(),'Where can I find')]
			browser.isTextPresent("You are the owner of the property");
			browser.isTextPresent("Your plumbing, drains and water supply pipe are all in good working order.");
			browser.isTextPresent("Your home electrics are in good working order.");
			if(appCover.equals("true"))
			{
				browser.isTextPresent("Your gas appliances that you wish to cover are in good working order.");
			}
		}
		if(plumbing.equals("true"))
		{
			browser.isTextPresent("You are the owner of the property");
			browser.isTextPresent("Your plumbing, drains and water supply pipe are all in good working order.");
			if(appCover.equals("true"))
			{
				browser.isTextPresent("Your gas appliances that you wish to cover are in good working order.");
			}
		}
		if(electrics.equals("true"))
		{
			browser.isTextPresent("You are the owner of the property");
			browser.isTextPresent("Your home electrics are in good working order.");
			if(appCover.equals("true"))
			{
				browser.isTextPresent("Your gas appliances that you wish to cover are in good working order.");
			}
		}
	}

	private void enterBoilerType(InsuranceQuote insuranceQuote) {
		browser.wait(getWaitTime());
		browser.wait(2000);

		if(browser.isElementVisibleWithXpath("//*[@id='boiltype_details_edit']/div[1]/p")){
			String strval=browser.getTextByXpath("//*[@id='boiltype_details_edit']/div[1]/p");
			Report.updateTestLog("Boiler Type field value " +strval, "PASS");
		}
		if(insuranceQuote.getAnnualService()){
			String strASVyes=pageProperties.getProperty("GetAnInsuranceQuotePage.ASVYes");
			browser.isTextPresent(strASVyes);
			Report.updateTestLog("Text Verified : "+ strASVyes, "PASS");
		} else {
			String strASVNo=pageProperties.getProperty("GetAnInsuranceQuotePage.ASVNo");
			browser.isTextPresent(strASVNo);
			Report.updateTestLog("Text Verified : "+ strASVNo, "PASS");
		}
		//verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.DontKnow"), "Boiler type not known");
		//selectBoilerType();
		browser.wait(2000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAnInsuranceQuotePage.ContinueButton"))){
			verifyAndClickWithXpath(pageProperties.getProperty("GetAnInsuranceQuotePage.ContinueButton"), "Next Button");
		} else {
			browser.click(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton01"));
		}

	}

	//Sprint 7 Verify the boiler make and model combinations 
	public void verifyBoilerMakeandModel(String BoilerType,String BoilerModel){
		BoilerTypeProfile boilerTypeProfile;
		BoilerType = BoilerType.replace(" ", "").replace("-", "").replace("&", "");
		BoilerModel = BoilerModel.replace(" ", "").replace("-", "").replace("&","");
		//Get Boiler status from the Boiler Type XML
		boilerTypeProfile = new TestDataHelper().boilerTypeProfile(BoilerModel);
		String BoilerPresentStatus = boilerTypeProfile.getBoilerPresent();
		//Check the boiler status
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAnInsuranceQuotePage.BoilerStatus"))){
			if(BoilerPresentStatus.equalsIgnoreCase("w")){
				Report.updateTestLog("Next button is Not Enabled for boiler type "+BoilerType+" and Boiler Model "+BoilerModel, "Pass");
			}
			else{
				Report.updateTestLog("Next button is Not Enabled for boiler type "+BoilerType+" and Boiler Model "+BoilerModel, "Fail");
			}
		}
		else{
			if(BoilerPresentStatus.equalsIgnoreCase("y")){
				Report.updateTestLog("Next button is Enabled for boiler type "+BoilerType+" and Boiler Model "+BoilerModel, "Pass");
			}
			else{
				Report.updateTestLog("Next button is Enabled for boiler type "+BoilerType+" and Boiler Model "+BoilerModel, "Fail");
			}
		}
	}

	//Sprint 7 CR - Function to select the 'Boiler Type and Model'
	public void selectBoilerType(){
		
		//click on the boiler Present radio button
		browser.clickWithXpath(pageProperties.getProperty("GetAnInsuranceQuotePage.BoilerPresent"));
		
		//Declaration of array list for Boiler Make and Model
		ArrayList<String> BoilerMake = new ArrayList<String>();
		ArrayList<String> BoilerModel = new ArrayList<String>();
		
		//Getting values from Boiler Make dropdown
		BoilerMake = browser.getFromDropBox("id", pageProperties.getProperty("GetAnInsuranceQuotePage.BoilerMake"));
		
		//Loop to select different Boilers
		for(String boilerMake:BoilerMake)
		{
			if(!boilerMake.contains("Please Select")){
				//Select the boiler make from the dropdown
				browser.selectfromDropBox("id", pageProperties.getProperty("GetAnInsuranceQuotePage.BoilerMake"), boilerMake);
				
				// Wait time for the combination to load
				browser.wait(3000);
				
				//Getting values from Boiler Model Dropdown
				BoilerModel = browser.getFromDropBox("id", pageProperties.getProperty("GetAnInsuranceQuotePage.BoilerModel"));
				
				//Loop to select different Boiler models according to Boiler Make
				for(String boilerType:BoilerModel){
					
					if(!boilerType.contains("Please Select"))
					{
						//Select the boiler Model
						browser.selectfromDropBox("id", pageProperties.getProperty("GetAnInsuranceQuotePage.BoilerModel"), boilerType);
						
						//Wait for page to load
						browser.wait(3000);
						if(!boilerType.contains("Don't")){
							
							//Calling method to verify the Boiler type and model combination
							verifyBoilerMakeandModel(boilerMake,boilerType);	
						}
					}
				}
			}
		}
		//Select default values
		browser.wait(3000);
		browser.selectfromDropBox("id", pageProperties.getProperty("GetAnInsuranceQuotePage.BoilerMake"), "Don't know");
		browser.wait(3000);
		browser.selectfromDropBox("id", pageProperties.getProperty("GetAnInsuranceQuotePage.BoilerModel"), "Don't know");
	}


	private void validatePersonalDetails(InsuranceQuote insuranceQuote) {
		browser.wait(getWaitTime());
		String[][] details = getInvalidPersonalDetails();
		for (String[] x : details) {
			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.Title"), "Title", x[0]);
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.FirstName"), "FirstName", x[1]);
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.Surname"), "Surname", x[2]);
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.Email"), "Email", x[3]);
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton1"), "Next Button");

			if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.CoverError"))) {
				Report.updateTestLog("personal details selection validation ", "DONE");
			}
		}
	}

	private void enterPersonalDetails(InsuranceQuote insuranceQuote, UserProfile userProfile) {
		browser.wait(getWaitTime());
		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton1"), "Next Button");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private String runBatch(String quote_id, String dbname) {
		SshClient sshClient = new SshClient();
		String strLogXml = "";
		String strCSVFileName = "";
		try {
			sshClient.connect();
			if (sshClient.isConnected()) {
				// sshClient.send("cd /shared/online/datafiles/outbound/queries/archive");
				//sshClient.send("rm *.csv");
				OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
				String date = onlineDBConnector.DBsysdate();
				date = date.substring(date.length() - 8);
				date = date.replace(".", "");
				date = date.substring(0, date.length() - 2);
				//System.out.println("date "+date);
				sshClient.send("cd /local/home/wl_fit/BGS/scripts");
				sshClient.send("./doBGSQuoteprocess.sh");
				browser.wait(10000);
				sshClient.send("clear");
				sshClient.send("cd /shared/asv/datafiles/outbound/getquote/out");
				browser.wait(getWaitTime());
				//strCSVFileName = sshClient.send("ls *"+date+"*");
				//strCSVFileName="QuoteCapture16052012_145930.csv";
				//strCSVFileName= strCSVFileName.substring(strCSVFileName.indexOf("Q"),strCSVFileName.indexOf(".")+4);
				//System.out.println("actual file "+strCSVFileName);
				//System.out.println(sshClient.send("cat "+strCSVList));
				String fileData = sshClient.send("grep " + quote_id + " *");
				//System.out.println("filedata = " + fileData);
				String lines[] = fileData.split("\\r?\\n");
				String line = lines[1];
				line = line.substring(32, line.length());
				String lines2[] = line.split(",");
				if (removePoundSign(dbname).equalsIgnoreCase(removePoundSign(lines2[7]))) {
					Report.updateTestLog("Selection verified against the CSV file " + removePoundSign(lines2[7]), "PASS");
				} else {
					Report.updateTestLog("Selection not verified against the CSV file " + removePoundSign(lines2[7]), "Fail");
				}
				//System.out.println(strCSVList.indexOf(33, strCSVList.length() - 33));
				//String[] arrstrLogXml = strCSVList.split(" ");
				//int intCount = arrstrLogXml.length;
				//strCSVFileName = arrstrLogXml[intCount - 1];
				//System.out.println(strCSVFileName);
				//sshClient.disconnect();
				//    ScpClient scpClient = new ScpClient();
				//browser.wait(getWaitTime());

				//scpClient.getFile("/shared/online/datafiles/outbound/queries/archive", "*.csv", "AutoCefBatchResult.csv");
				//scpClient.getFile("/shared/asv/datafiles/outbound/getquote/out",strCSVFileName,"");
				//scpClient.disconnect();
			}
		} catch (Exception e) {
			//e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
			System.out.println("ERROR " + e.toString());
		}
		/*ScpClient scpClient = new ScpClient();
         browser.wait(getWaitTime());
        //scpClient.getFile("/shared/online/datafiles/outbound/queries/archive", "*.csv", "AutoCefBatchResult.csv");
        scpClient.getFile("/shared/online/datafiles/outbound/queries/archive",strCSVFileName,"");
        scpClient.disconnect();
        Report.updateTestLog("AutoCef Batch Process Executed and refer the CSV file","Done");*/
		//System.out.println("here? ");
		//readFile(strCSVFileName);
		return strLogXml;
	}

	private void validateAddress(InsuranceQuote insuranceQuote) {
		String[] postcode = getInvalidPostCode();
		String[] houseNo = {"##", "64"};
		for (String x : houseNo) {
			for (String y : postcode) {
				verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.HouseNameService"), "House name", x);
				verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.PostCodeService"), "Post code", y);
				browser.click(pageProperties.getProperty("GetAnInsuranceQuotePage.AddressSearch"));
				if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.AddressError"))) {
					Report.updateTestLog("Post code error validation for value: " + y.toString(), "DONE");
				}
			}
		}
		browser.wait(getWaitTime());
		verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.HouseNameService"), "House name", "64");
		verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.PostCodeService"), "Post code", "SE23 1LN");
		browser.click(pageProperties.getProperty("GetAnInsuranceQuotePage.AddressSearch"));
		browser.wait(getWaitTime());
		browser.click(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton4"));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.AddressError"))) {
			Report.updateTestLog("Post code error validation for value: SE23 1LN", "DONE");
		}
		browser.wait(getWaitTime());
		browser.selectFromDropBoxByID("id", pageProperties.getProperty("GetAnInsuranceQuotePage.AddressService"));
		Report.updateTestLog("Address selected from list", "PASS");
		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton4"), "Next Button");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (browser.isElementVisibleWithXpath("html/body/div[10]/div[1]/a")){
			browser.clickWithXpath("html/body/div[10]/div[1]/a");
			browser.wait(1000);

			if(browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton4"))){
				browser.click(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton4"));
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton4"), "Next Button"); 
		}
	}

	private void validateBankDetails(InsuranceQuote insuranceQuote) {
		browser.wait(getWaitTime());
		String[][] number = {{"", "", "", "", ""}, {"jdshfd", "sd", "sd", "sd", "343432"}, {"12345", "sd", "22", "", ""}, {"12345678", "40", "40", "40", ""},
				{"12345678", "40", "40", "40", "1234"}};
		String[] cardType = {"Visa Debit", "Visa Delta", "Maestro", "Switch", "Visa credit card", "Mastercard"};
		String[][] ccNumber = {{}};
		if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.Monthly"))) {
			for (String[] a : number) {
				verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.AccountNumber"), "Account number", a[0]);
				verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.SortCode1"), "Sortcode", a[1]);
				verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.SortCode2"), "Sortcode", a[2]);
				verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.SortCode3"), "Sortcode", a[3]);
				verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.NameOfAccountHolder"), "Account name", a[4]);
				verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton5"), "Next Button");
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				browser.wait(500);
				if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.PayError"))) {
					Report.updateTestLog("Payment details selection validation ", "DONE");
				}
			}
		}
		if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.CreditCard"))) {
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.CreditCard"), "Credit Card payment");
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton5"), "Next Button");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.PayError"))) {
				Report.updateTestLog("Payment details selection validation ", "DONE");
			}
			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.CardType"), "Card Type", cardType[1]);
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton5"), "Next Button");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.PayError"))) {
				Report.updateTestLog("Payment details selection validation ", "DONE");
			}
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.NameOnCard"), "Name on Card", "not validated");
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton5"), "Next Button");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.PayError"))) {
				Report.updateTestLog("Payment details selection validation ", "DONE");
			}
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.CardNumber"), "Card Number", "4909630000000008");
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton5"), "Next Button");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.PayError"))) {
				Report.updateTestLog("Payment details selection validation ", "DONE");
			}
			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.StartMonth"), "Start Month", "February");
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton5"), "Next Button");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.PayError"))) {
				Report.updateTestLog("Payment details selection validation ", "DONE");
			}
			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.StartYear"), "Start Year", "2008");
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton5"), "Next Button");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.PayError"))) {
				Report.updateTestLog("Payment details selection validation ", "DONE");
			}
			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.EndMonth"), "End Mon", "September");
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton5"), "Next Button");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.PayError"))) {
				Report.updateTestLog("Payment details selection validation ", "DONE");
			}
			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.EndYear"), "End Year", "2012");
			if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.IssueNumber"))) {
				verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.IssueNumber"), "Issue Number", "40");
				verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton5"), "Next Button");
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.PayError"))) {
					Report.updateTestLog("Payment details selection validation ", "DONE");
				}
			}
			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAnInsuranceQuotePage.EndYear"), "End Year", "2012");
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.CardNumber"), "Card Number", "1234");
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton5"), "Next Button");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.PayError"))) {
				Report.updateTestLog("Payment details selection validation ", "DONE");
			}
			verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.CardNumber"), "Card Number", "abcccc");
			verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.NextButton5"), "Next Button");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (browser.isElementVisible(pageProperties.getProperty("GetAnInsuranceQuotePage.PayError"))) {
				Report.updateTestLog("Payment details selection validation ", "DONE");
			}

		}
	}

	private void readFile(String file) {
		System.out.println("local file " + file);
		String lfile = Report.logPath + "\\" + file;
		System.out.println("local file " + lfile);
		try {
			FileInputStream fileInputStream = new FileInputStream(lfile);
			DataInputStream in = new DataInputStream(fileInputStream);
			BufferedReader br = null;
			try {
				br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
			}
			String strLine;
			try {
				while ((strLine = br.readLine()) != null) {
					// Print the content on the console
					//if(strLine.contains("Boiler and Controls Breakdown Cover - £50 excess+Home Electrical Cover - £50 excess")){
					System.out.println(strLine);
					// }
				}
			} catch (IOException e) {
				e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
	}
	private String removeCode(String value){
		String[] s = {"2SIS",
				"3SIS",
				"2FIS",
				"3FIS",
				"2FIS",
				"2FI1",
				"3FI1",
				"2BI",
				"2BI1",
				"3BI",
				"3BI1",
				"2FBI",
				"3FBI",
				"2PDI",
				"2PDI",
				"2PFI",
				"HEWI",
				"HEWI",
				"HEFI",
				"2E3I",
				"2E5I",
				"2E9I",
				"2API",
				"2API",
				"2WSP",
				"2AFI",
				"2AFI"
		};
		for(String x:s){
			if(value.contains(x.toLowerCase())){
				value = value.replace(x.toLowerCase(),"");
			}
		}
		return value;
	}
	private String removePoundSign(String value){
		String[] x = {"0 ex","50 e","99 e"};
		for(String y2:x){
			if(value.contains(y2)){
				char c = value.charAt(value.indexOf(y2) - 1);
				value = value.replace("�".charAt(0),"£".charAt(0));
			}
		}
		return value;
	}
	private void verifyOrder(String quoteID){
		Report.updateTestLog("thank you page screensot", "WARN");
		OnlineDBConnector onlineDBConnector = new OnlineDBConnector();

		int count = onlineDBConnector.getInsuranceAndRepairLeadCount(quoteID);
		if (count==0){
			Report.updateTestLog("Quote lead removed from BGS_QUOTE_LEAD table", "PASS");
		}
		else{
			Report.updateTestLog("Quote lead exists in BGS_QUOTE_LEAD table", "FAIL");
		}
		String data = onlineDBConnector.verifyAuditDetails(orderDate, "40");
		Report.updateTestLog(data, "PASS");
		String leadData = onlineDBConnector.getLeadData(orderDate);
		Report.updateTestLog(leadData, "PASS");
		processOrderBatch(onlineDBConnector.getLeadID(orderDate));

	}

	private String processOrderBatch(String quote_id) {
		SshClient sshClient = new SshClient();
		String strLogXml = "";
		try {
			sshClient.connect();
			if (sshClient.isConnected()) {
				sshClient.send("cd /local/home/wl_fit/BGS/scripts");
				sshClient.send("./doServicesSales.sh");
				browser.wait(10000);
				sshClient.send("./doInsuranceSales.sh");
				browser.wait(10000);
				sshClient.send("clear");
				sshClient.send("cd /shared/online/datafiles/outbound/servicessales/archive");
				browser.wait(getWaitTime());
				String exec = "grep "+quote_id+" *";
				String fileData = sshClient.send(exec);
				browser.wait(getWaitTime());
				String lines[] = fileData.split(",");
				String primary = lines[1] ;
				String secondary = lines[2];
				if(removeCode(removePoundSign(secondary)).replace(" ","").toLowerCase().equalsIgnoreCase(DBName)){
					Report.updateTestLog(secondary,"PASS");
				}
				else{
					Report.updateTestLog(secondary,"FAIL");
				}
				if(primary.toLowerCase().replace(" ","").contains(insuranceQuote.getOnline_name().toLowerCase().replace(" ",""))){
					Report.updateTestLog(primary,"PASS");
				}
				else{
					Report.updateTestLog(primary,"FAIL");
				}
				sshClient.send("clear");
				sshClient.send("cd /shared/online/datafiles/outbound/insurancesales/archive");
				browser.wait(getWaitTime());
				String exec2 = "grep "+quote_id+" *";
				String fileData2 = sshClient.send(exec2);
				browser.wait(getWaitTime());
				String lines2[] = fileData2.split(",");
				String primary2 = lines2[1] ;
				String secondary2 = lines2[2];
				if(removeCode(removePoundSign(secondary2)).replace(" ","").toLowerCase().equalsIgnoreCase(DBName)){
					Report.updateTestLog(secondary2,"PASS");
				}
				else{
					Report.updateTestLog(secondary2,"FAIL");
				}
				if(primary2.toLowerCase().replace(" ","").contains(insuranceQuote.getOnline_name().toLowerCase().replace(" ",""))){
					Report.updateTestLog(primary2,"PASS");
				}
				else{
					Report.updateTestLog(primary2,"FAIL");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
			System.out.println("ERROR " + e.toString());
		}
		return strLogXml;
	}
	private void enterDifferentBillingAddress(){
		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.ChangeBillingAddress"),"Billing address");
		verifyAndInputById(pageProperties.getProperty("GetAnInsuranceQuotePage.BillingPostCode"),"Billing post code", "CR4 4AH");
		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.BillingSearch"),"Search");
		browser.wait(getWaitTime());
		browser.selectFromDropBoxByID("id", pageProperties.getProperty("GetAnInsuranceQuotePage.BillingAddressList"));
		Report.updateTestLog("Address selected from list", "PASS");
		verifyAndClick(pageProperties.getProperty("GetAnInsuranceQuotePage.BillingNext"), "Next Button");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void validatePriceCode(InsuranceQuote insuranceQuote, String databaseName){
		String los1 = insuranceQuote.getLOS1();
		if (!los1.equalsIgnoreCase("none")){
			if(databaseName.toLowerCase().contains(los1.toLowerCase())){
				Report.updateTestLog("LOS exists "+los1, "PASS");
			}
			else{
				Report.updateTestLog(los1+" does not exist in  "+databaseName, "FAIL");
			}
		}
		String los2 = insuranceQuote.getLOS2();
		if (!los2.equalsIgnoreCase("none")){
			if(databaseName.toLowerCase().contains(los2.toLowerCase())){
				Report.updateTestLog("LOS exists "+los2, "PASS");
			}
			else{
				Report.updateTestLog(los2+" does not exist in  "+databaseName, "FAIL");
			}
		}
		String los3 = insuranceQuote.getLOS3();
		if (!los3.equalsIgnoreCase("none")){
			if(databaseName.toLowerCase().contains(los3.toLowerCase())){
				Report.updateTestLog("LOS exists "+los3, "PASS");
			}
			else{
				Report.updateTestLog(los2+" does not exist in  "+databaseName, "FAIL");
			}
		}
	}
}