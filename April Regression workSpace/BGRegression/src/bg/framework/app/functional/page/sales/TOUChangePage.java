package bg.framework.app.functional.page.sales;

import java.util.Properties;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class TOUChangePage extends BasePage {
	private final static String FILE_NAME = "resources/ReFactoring/TOUChange.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	private static String Customer;
	
	public void navigateToTOULandingPage(String Flow){
		if (Flow=="StandardMeter")
		{
		browser.open(ApplicationConfig.APP_BG_URL+"/content/britishgas/products-and-services/gas-and-electricity/our-energy-tariffs/free-saturdays-sundays-september-2015.html");
		}
		///products-and-services/free-saturday.html
		if(Flow=="Pros&Smart")
		{
	    browser.open(ApplicationConfig.APP_BG_URL+"/content/britishgas/products-and-services/gas-and-electricity/our-energy-tariffs/free-saturdays-sundays-september-2015.html");
		}
	//	browser.open(ApplicationConfig.APP_BG_URL+"/content/britishgas/products-and-services/gas-and-electricity/our-energy-tariffs/free-saturdays-sundays-september-2015.html");
	}
	//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ Select customer^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ //
	public void selectCustomer(String Customer){
		if(Customer=="newCustomer"){
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.newCustomer"),"New customer Radio button");
		}
		if(Customer=="standardBGmeter"){
			verifyAndClickWithXpath(pageProperties.getProperty("touChange.standardBGmeter"),"Standard BG meter radio button");
		}
		if(Customer=="smartmeter"){
			verifyAndClickWithXpath(pageProperties.getProperty("touChange.smartmeter"),"Smart meter radio button");
		}
		browser.wait(1000);
	}
	public void newCustomerContinue(){
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.ContinueButton"),"Continue button");
		browser.wait(10000);	
	}
	
	public void smartmeterContinue(){
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.SmartContinueButton"),"Continue button");
		browser.wait(10000);	
	}
	
	public void standardmeterContinue(){
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.StandardContinueButton"),"Continue button");
		browser.wait(10000);	
	}
	//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ New Customer - Screening Questions^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ //
	public void newCustScreeningQues(String PPMeter,String Eco7,String Flat,String FuseBox,String Smart){
		System.out.println("into new cust screening quests");
		Report.updateTestLog("into new cust screening quests", "PASS");
		
	if(PPMeter=="Yes")
	{
		if(browser.isElementVisible(pageProperties.getProperty("touChange.PrepaymentMeterYes")))
		{
			verifyAndClick(pageProperties.getProperty("touChange.PrepaymentMeterYes"), "Prepayment Meter Yes Check Box");
		} 
		else
		{
			Report.updateTestLog("Prepayment Meter Yes Check Box is not present", "FAIL");				
		}	
	}
	
		
	 if(PPMeter=="No")
	 {
			if(browser.isElementVisible(pageProperties.getProperty("touChange.PrepaymentMeterNo")))
			{
				verifyAndClick(pageProperties.getProperty("touChange.PrepaymentMeterNo"), "Prepayment Meter No Check Box");
			} 
			else
			{
				Report.updateTestLog("Prepayment Meter No Check Box is not present", "FAIL");				
			}	
	}
		
	
	if(Eco7=="Yes")
	{
	      if(browser.isElementVisible(pageProperties.getProperty("touChange.Eco7Yes")))
		  {
			 verifyAndClick(pageProperties.getProperty("touChange.Eco7Yes"), "Eco7 Yes Check Box");
		  }
	      else
	      {
			Report.updateTestLog("Eco7 Yes Check Box is not present", "FAIL");				
		  }	
}

	if(Eco7=="No")
	{
		if(browser.isElementVisible(pageProperties.getProperty("touChange.Eco7No")))
		{
		verifyAndClick(pageProperties.getProperty("touChange.Eco7No"), "Eco7 No Check Box");
		}
		else
		{
		Report.updateTestLog("Eco7 No Check Box is not present", "FAIL");				
		}	
	}
	
	if(Flat=="Yes")
	{
	if(browser.isElementVisible(pageProperties.getProperty("touChange.FlatYes")))
		{
			verifyAndClick(pageProperties.getProperty("touChange.FlatYes"), "Flat Yes Check Box");
		} 
	    else
		{
			Report.updateTestLog("Flat Yes Check Box is not present", "FAIL");				
		}	
}

	if(Flat=="No")
	{
		if(browser.isElementVisible(pageProperties.getProperty("touChange.FlatNo")))
		{
		verifyAndClick(pageProperties.getProperty("touChange.FlatNo"), "Flat No Check Box");
		}
		else
		{
		Report.updateTestLog("Flat No Check Box is not present", "FAIL");				
		}	
	}
	
	if(FuseBox=="Yes")
	{
		if(browser.isElementVisible(pageProperties.getProperty("touChange.FuseYes")))
			{
				verifyAndClick(pageProperties.getProperty("touChange.FuseYes"), "Fuse Yes Check Box");
			} 
		    else
		    {
				Report.updateTestLog("Fuse Yes Check Box is not present", "FAIL");				
			}	
		}

	if(FuseBox=="No")
	{
		if(browser.isElementVisible(pageProperties.getProperty("touChange.FuseNo")))
		{
		verifyAndClick(pageProperties.getProperty("touChange.FuseNo"), "Fuse No Check Box");
		}
		else
		{
		Report.updateTestLog("Fuse No Check Box is not present", "FAIL");				
		}	
	}
	if(Smart=="Yes")
	{
		if(browser.isElementVisible(pageProperties.getProperty("touChange.SmartYes")))
		{
			verifyAndClick(pageProperties.getProperty("touChange.SmartYes"), "Smart Yes Check Box");
		} 
		else
		{
			Report.updateTestLog("Smart Yes Check Box is not present", "FAIL");				
		}	
	}

	if(Smart=="No")
	{
		if(browser.isElementVisible(pageProperties.getProperty("touChange.SmartNo")))
		{
		verifyAndClick(pageProperties.getProperty("touChange.SmartNo"), "Smart No Check Box");
		}
		else
		{
		Report.updateTestLog("Smart No Check Box is not present", "FAIL");				
		}	
	
		}
			
	}
	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^New Customer - Screening continue button^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ //
	public void screeningContinue(){
		if(browser.isElementVisible(pageProperties.getProperty("touChange.gettingStarted")))
		{
		verifyAndClick(pageProperties.getProperty("touChange.gettingStarted"), "Getting started button");
		} 
		else
		{
		Report.updateTestLog("Getting started button is not present", "FAIL");				
		}	
	
		}
	
	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^New Customer - tellAbtYou^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ //
	public void tellAbtYou(UserProfile userProfile,String AddressDD){
		
		 if (browser.isElementVisible(pageProperties.getProperty("touChange.NewSelectTitle"))) {
   		 String dropdata=browser.getTextByXpath(pageProperties.getProperty("touChange.NewSelectTitleDropdown"));
   	        browser.selectfromDropBox("id", pageProperties.getProperty("touChange.NewSelectTitle"),dropdata);
   	        Report.updateTestLog("Title has been Entered successfully" , "PASS");
   	    }
		 else 
		 {
   	        Report.updateTestLog("Title has not been Entered successfully", "FAIL");
   	    }	
		verifyAndInputById(pageProperties.getProperty("touChange.NewFirstName"), "New First Name", userProfile.getFirstName() );
		verifyAndInputById(pageProperties.getProperty("touChange.NewSurName"), "New Sur Name",userProfile.getLastName());
		verifyAndInputById(pageProperties.getProperty("touChange.NewPostalCode"), "Postal Code",userProfile.getPostCode());
		verifyAndClick(pageProperties.getProperty("touChange.NewFindYourAddress"), "Find Address");
		browser.WaitForElementWithId(pageProperties.getProperty("touChange.NewSelectAddress"));
		
		 if (browser.isElementVisible(pageProperties.getProperty("touChange.NewSelectAddress"))) {
			 String add=pageProperties.getProperty("touChange.NewSelectAddressDD").replace("+i+", AddressDD);
			 System.out.println("dropdata Xpath *****************11111111111111 = "+add);
   		 String dropdata=browser.getTextByXpath(add);
   		 
   		 System.out.println("address value" +dropdata);
   	        browser.selectfromDropBox("id", pageProperties.getProperty("touChange.NewSelectAddress"),dropdata);
   	        Report.updateTestLog("Address has been Entered successfully" , "PASS");
   	    } 
		else
		{
   	        Report.updateTestLog("Address has not been Entered successfully", "FAIL");
   	        if(browser.isElementVisibleWithXpath(pageProperties.getProperty("touChange.PostalCodeError"))){
   	        	String PostalError=browser.getTextByXpath(pageProperties.getProperty("touChange.PostalCodeError"));
   	        	Report.updateTestLog("Postal code error = " +PostalError, "FAIL");
   	     }
   	    }      
   	  verifyAndInputById(pageProperties.getProperty("touChange.NewEmail"), "New Email", userProfile.getEmail());
   	  
   	  verifyAndSelectDropDownBox(pageProperties.getProperty("touChange.NewCustEmail"), "Email Type",  "Work");
   	  verifyAndInputById(pageProperties.getProperty("touChange.NewConfirmEmail"), "New Confirm Email", userProfile.getEmail());
   	  
   /*	  verifyAndInputById(pageProperties.getProperty("touChange.NewConfirmEmail"), "New Confirm Email", userProfile.getEmail());*/
   	  verifyAndInputById(pageProperties.getProperty("touChange.NewTeleNum"), "Phone number", userProfile.getPhoneNumber());
   	  
   	  if (browser.isElementVisible(pageProperties.getProperty("touChange.NewTeleNumType"))) {
   		  	    		  
	    		 /*String dropdata=browser.getTextByXpath(pageProperties.getProperty("touChange.NewTeleNumTypeDropdown"));
	    	        browser.selectfromDropBox("id", pageProperties.getProperty("touChange.NewTeleNumType"),dropdata);*/
   		  verifyAndSelectDropDownBox(pageProperties.getProperty("touChange.NewTeleNumType"), "Phone Type", userProfile.getPhoneType());
   		  
	    	        Report.updateTestLog("Tele num Type has been Entered successfully" , "PASS");
	    	    } 
   	  else
   	  {
	    	        Report.updateTestLog("Tele num Type has not been Entered successfully", "FAIL");
	    	    }	
		 verifyAndClick(pageProperties.getProperty("touChange.NewPDetailsSubmit"), "Submit");
		}
	
	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^New Customer - Confirmation through MVDD ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ //
	public void newCusFlowDeciderForMvdd(Acquisition acquisition,UserProfile userProfile,String AddressDD,String PayType,String MvddTariff, String Nectar,String Meter)
	{
		tellAbtYou(userProfile,AddressDD);
		browser.wait(50000);
	//	browser.dynamicWaituntilVisiblebyXpath(pageProperties.getProperty("touChange.newContinueToGAQ"));
	//	browser.wait(15000);
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("touChange.newContinueToGAQ"))){
				Report.updateTestLog("Continue to Get a Quoate Link Exists", "PASS");
			//	browser.dynamicWaituntilVisiblebyXpath(pageProperties.getProperty("touChange.newContinueToGAQ"));
			//	browser.wait(10000);
				verifyAndClickWithXpath(pageProperties.getProperty("touChange.newContinueToGAQ"), "Continue to Upgrade your smart meter");
				browser.wait(10000);
				GAQPage(userProfile);
				GAQPagePaymentType(userProfile, PayType);
				YourQuotePage();
				YourQuotePageForMvdd(MvddTariff);
				OrderEnergyPage();
				nectarDetails(Nectar);
				personalDetailsPage(userProfile,AddressDD);
				newMeterDetailsPage();
				meterSelection(Meter);
				newPaymentPage(acquisition);
				newReviewOrder();
				newValidateConfirmation();
			}
			else
			{
				Report.updateTestLog("Continue to Get a Quoate Link does not Exists", "FAIL");
			}
		}
	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^New Customer - Confirmation through CC ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ //
    public void newCusFlowDeciderForCC(Acquisition acquisition,UserProfile userProfile,String AddressDD,String PayType,String CCTariff,String Nectar,String Meter)
    {
		tellAbtYou(userProfile,AddressDD);
		browser.wait(50000);
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("touChange.newContinueToGAQ"))){
				Report.updateTestLog("Continue to Get a Quoate Link Exists", "PASS");
				browser.wait(50000);
				verifyAndClickWithXpath(pageProperties.getProperty("touChange.newContinueToGAQ"), "Continue to Upgrade your smart meter");
				browser.wait(10000);
				GAQPage(userProfile);
				GAQPagePaymentType(userProfile, PayType);
				YourQuotePage();
				YourQuotePageForCC(CCTariff);
				OrderEnergyPage();
				nectarDetails(Nectar);
				personalDetailsPage(userProfile,AddressDD);
				newMeterDetailsPage();
				meterSelection(Meter);
				newPaymentPageCC();
				newReviewOrder();
				newValidateConfirmation();
			}
			else
			{
				Report.updateTestLog("Continue to Get a Quoate Link does not Exists", "FAIL");
			}
		}
    
 // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^New Customer - Confirmation through PayAsYouGo ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ //
    public void newCusFlowDeciderForPayGo(Acquisition acquisition,UserProfile userProfile,String AddressDD,String PayType,String PayGoTariff,String Nectar,String Meter){
		tellAbtYou(userProfile,AddressDD);
		browser.wait(50000);
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("touChange.newContinueToGAQ"))){
				Report.updateTestLog("Continue to Get a Quoate Link Exists", "PASS");
				browser.wait(10000);
				verifyAndClickWithXpath(pageProperties.getProperty("touChange.newContinueToGAQ"), "Continue to Upgrade your smart meter");
				browser.wait(50000);
				GAQPage(userProfile);
				GAQPagePaymentType(userProfile, PayType);
				YourQuotePage();
				YourQuotePageForPayGo(PayGoTariff);
				OrderEnergyPage();
				nectarDetails(Nectar);
				personalDetailsPage(userProfile,AddressDD);
				newMeterDetailsPageForPayAsYouGo();
				meterSelection(Meter);
			//	newPaymentPage(acquisition);
				newReviewOrderForPAYGo();
				newValidateConfirmationForPAYGo();
			}
			else
			{
				Report.updateTestLog("Continue to Get a Quoate Link does not Exists", "FAIL");
			}
		}
    
 
	public void GAQPage(UserProfile userProfile){
		Report.updateTestLog("*************************Get A Quote Page************************", "WARN");		
		verifyAndClick(pageProperties.getProperty("touChange.newGAQPostCodeNext"), "GAQ Post Code Next");
		browser.wait(500);
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.newGAQEnergyType"), "GAQ energy Type");
		verifyAndClick(pageProperties.getProperty("touChange.newGAQFuelNext"), "GAQ Fuel Next");
	}
	public void GAQPagePaymentType(UserProfile userProfile,String PayType){
		if (PayType=="MVDD"){
			verifyAndClick(pageProperties.getProperty("touChange.newGAQPaymentDetails"), "GAQ Payment MVDD");
		}
		if (PayType=="CC"){
			verifyAndClick(pageProperties.getProperty("touChange.newGAQPaymentDetailsCC"), "GAQ Payment CC");
		}
		if (PayType=="PayAsYouGo"){
			verifyAndClick(pageProperties.getProperty("touChange.newGAQPaymentDetailsPAYGO"), "GAQ Payment Pay as you go");
		}
		verifyAndClick(pageProperties.getProperty("touChange.newGAQPaymentNext"), "GAQ Payment Next");
		verifyAndClick(pageProperties.getProperty("touChange.newGAQConsumptionYes"), "GAQ Consumption Yes");
		
					
		verifyAndInputById(pageProperties.getProperty("touChange.newGAQConsumptionGas"), "Gas Consumption", "100");
		verifyAndInputById(pageProperties.getProperty("touChange.newGAQConsumptionElec"), "Elec Consumption", "100");
		verifyAndClick(pageProperties.getProperty("touChange.newGAQConsptnNext"), "GAQ Consumption Next");
		
		verifyAndSelectDropDownBox(pageProperties.getProperty("touChange.newGAQPhoneType"), "Phone Type", userProfile.getPhoneType());
		verifyAndClick(pageProperties.getProperty("touChange.newGAQDetailsNext"), "GAQ Contact Details Next");
		
		browser.wait(3000);
		verifyAndClick(pageProperties.getProperty("touChange.newGAQGAQBtn"), "GAQ Get a Quoate Button");
	}
	
	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ Entering quote page ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ //
	public void YourQuotePage(){
		Report.updateTestLog("****************************Your Quote Page*****************************", "WARN");		
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("touChange.newYourDetailsDuel"))){
			String DuelText=browser.getTextByXpath(pageProperties.getProperty("touChange.newYourDetailsDuel"));
			Report.updateTestLog("Only Duel Fuel Text Exists in Your Details Page", "PASS");
		}
		else
		{
			Report.updateTestLog("Duel Fuel Text does not Exists in Your Details Page", "FAIL");
		}
	}
	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ Entering quote page for mvdd ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ //
	public void YourQuotePageForMvdd(String MvddTariff){
	if(MvddTariff=="First"){
		verifyAndClick(pageProperties.getProperty("touChange.firstTariff"), "First tariff");
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.FirstTariffSwitch"), "First Tariff Switch");
	}
	if(MvddTariff=="Second"){
		verifyAndClick(pageProperties.getProperty("touChange.secondTariff"), "Second tariff");
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.SecondTariffSwitch"), "Second Tariff Switch");
	}
	if(MvddTariff=="Third"){
		verifyAndClick(pageProperties.getProperty("touChange.thirdTariff"), "Third tariff");
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.ThirdTariffSwitch"), "Third Tariff Switch");
	}
	if(MvddTariff=="Fourth"){
		verifyAndClick(pageProperties.getProperty("touChange.fourthTariff"), "Fourth tariff");
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.FourthTariffSwitch"), "Fourth Tariff Switch");
	}
	}
	
	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ Entering quote page for cc ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ //
	public void YourQuotePageForCC(String CCTariff){
		if(CCTariff=="First"){
			verifyAndClick(pageProperties.getProperty("touChange.firstTariff"), "First tariff");
			verifyAndClickWithXpath(pageProperties.getProperty("touChange.FirstTariffSwitch"), "First Tariff Switch");
		}
		if(CCTariff=="Second"){
			verifyAndClick(pageProperties.getProperty("touChange.thirdTariff"), "Second tariff");
			verifyAndClickWithXpath(pageProperties.getProperty("touChange.SecondTariffSwitch"), "Second Tariff Switch");
		}
		if(CCTariff=="Third"){
			verifyAndClick(pageProperties.getProperty("touChange.fourthTariff"), "Third tariff");
			verifyAndClickWithXpath(pageProperties.getProperty("touChange.ThirdTariffSwitch"), "Third Tariff Switch");
		}
	}
	
	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ Entering quote page for paygo ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ //
	public void YourQuotePageForPayGo(String PayGoTariff){
		if(PayGoTariff=="First"){
			verifyAndClick(pageProperties.getProperty("touChange.firstTariff"), "First tariff");
			verifyAndClickWithXpath(pageProperties.getProperty("touChange.FirstTariffSwitch"), "First Tariff Switch");
		}
		if(PayGoTariff=="Second"){
			verifyAndClick(pageProperties.getProperty("touChange.thirdTariff"), "Second tariff");
			verifyAndClickWithXpath(pageProperties.getProperty("touChange.SecondTariffSwitch"), "Second Tariff Switch");
		}
		
	}
	
	
	
	

	public void OrderEnergyPage(){
		Report.updateTestLog("*********************************Order Detail Page******************************", "WARN");		
		 if (browser.isElementVisible(pageProperties.getProperty("touChange.NewGasSuplr")))
		 {
    		 String dropdata=browser.getTextByXpath(pageProperties.getProperty("touChange.NewGasSuplrDD"));
    	        browser.selectfromDropBox("id", pageProperties.getProperty("touChange.NewGasSuplr"),dropdata);
    	        Report.updateTestLog("Gas Supplier Entered successfully" , "PASS");
    	 }
		 else 
		 {
    	        Report.updateTestLog("Gas Supplier has not been Entered successfully", "FAIL");
    	 }	
		 if (browser.isElementVisible(pageProperties.getProperty("touChange.NewElecSuplr")))
		 {
    		 String dropdata=browser.getTextByXpath(pageProperties.getProperty("touChange.NewElecSuplrDD"));
    	        browser.selectfromDropBox("id", pageProperties.getProperty("touChange.NewElecSuplr"),dropdata);
    	        Report.updateTestLog("Elec Supplier Entered successfully" , "PASS");
    	 }
		 else
		 {
    	        Report.updateTestLog("Elec Supplier has not been Entered successfully", "FAIL");
         }	
		 
	}
	
	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ Nectar card details ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ //
	public void nectarDetails(String Nectar){
		if(Nectar=="No")
		{
		 verifyAndClick(pageProperties.getProperty("touChange.NewNectar"), "Nectar No Thanks");
		 verifyAndClick(pageProperties.getProperty("touChange.NewOrderP1Cont"), "Order Continue Button");
		}
		else if(Nectar=="AddCard")
		{
			verifyAndClick(pageProperties.getProperty("touChange.AddCard"), "Add Nectar card");
			verifyAndInputById(pageProperties.getProperty("touChange.CardValue"), "Card value","11111111111");
			verifyAndClick(pageProperties.getProperty("touChange.TermsAndConditions"), "Terms and conditions for nectar");
			verifyAndClick(pageProperties.getProperty("touChange.NewOrderP1Cont"), "Order Continue Button");
		}
		else if(Nectar=="SignUp")
		{
			verifyAndClick(pageProperties.getProperty("touChange.SignUp"), "Sign up");
			verifyAndClick(pageProperties.getProperty("touChange.TermsAndConditions"), "Terms and conditions for nectar");
			verifyAndClick(pageProperties.getProperty("touChange.NewOrderP1Cont"), "Order Continue Button");
		}
		else if(Nectar=="Later")
		{
			verifyAndClick(pageProperties.getProperty("touChange.Later"), "Later adding option");
			verifyAndClick(pageProperties.getProperty("touChange.TermsAndConditions"), "Terms and conditions for nectar");
			verifyAndClick(pageProperties.getProperty("touChange.NewOrderP1Cont"), "Order Continue Button");
		}
	}
	
	
	public void personalDetailsPage(UserProfile userProfile,String AddressDD){
		Report.updateTestLog("****************************Personal Details Page*****************************", "WARN");
		if (browser.isElementVisible(pageProperties.getProperty("touChange.NewDOBDay")))
		{
    		 String dropdata=browser.getTextByXpath(pageProperties.getProperty("touChange.NewDOBDayDD"));
    	        browser.selectfromDropBox("id", pageProperties.getProperty("touChange.NewDOBDay"),dropdata);
    	        Report.updateTestLog("DOB - Date Entered successfully" , "PASS");
        } 
		else 
		{
    	        Report.updateTestLog("DOB - Date has not been Entered successfully", "FAIL");
        }	
		 if (browser.isElementVisible(pageProperties.getProperty("touChange.NewDOBMonth")))
		 {
    		 String dropdata=browser.getTextByXpath(pageProperties.getProperty("touChange.NewDOBMonthDD"));
    	        browser.selectfromDropBox("id", pageProperties.getProperty("touChange.NewDOBMonth"),dropdata);
    	        Report.updateTestLog("DOB - Month Entered successfully" , "PASS");
    	 }
		 else
		 {
    	        Report.updateTestLog("DOB - Month has not been Entered successfully", "FAIL");
    	 }	
		 if (browser.isElementVisible(pageProperties.getProperty("touChange.NewDOBYear")))
		 {
    		 String dropdata=browser.getTextByXpath(pageProperties.getProperty("touChange.NewDOBYearDD"));
    	        browser.selectfromDropBox("id", pageProperties.getProperty("touChange.NewDOBYear"),dropdata);
    	        Report.updateTestLog("DOB - Year Entered successfully" , "PASS");
    	 }
		 else
		 {
    	        Report.updateTestLog("DOB - Year has not been Entered successfully", "FAIL");
    	 }	
		 	verifyAndSelectDropDownBox(pageProperties.getProperty("touChange.NewOrderEmailType"), "Email Type", "Work");
		 	verifyAndInputById(pageProperties.getProperty("touChange.PdetailsPWD"), "Password", userProfile.getPassword());
		 	verifyAndInputById(pageProperties.getProperty("touChange.PdetailsPWDCnfm"), "Confirm Password", userProfile.getPassword());
		 	
		 	verifyAndClick(pageProperties.getProperty("touChange.NewOrderAddressSearch"), "Address Search Button");
		 	browser.wait(5000);
		 	
		
			 if (browser.isElementVisible(pageProperties.getProperty("touChange.NewOrderHowLongYear")))
			 {
	    		 String dropdata=browser.getTextByXpath(pageProperties.getProperty("touChange.NewOrderHowLongYearDD"));
	    	        browser.selectfromDropBox("id", pageProperties.getProperty("touChange.NewOrderHowLongYear"),dropdata);
	    	        Report.updateTestLog("How Long Year Entered successfully" , "PASS");
	         } 
			 else 
			 {
	    	        Report.updateTestLog("How Long Year has not been Entered successfully", "FAIL");
	    	 }	
			 if (browser.isElementVisible(pageProperties.getProperty("touChange.NewOrderHowLongMonth")))
			 {
	    		 String dropdata=browser.getTextByXpath(pageProperties.getProperty("touChange.NewOrderHowLongMonthDD"));
	    	        browser.selectfromDropBox("id", pageProperties.getProperty("touChange.NewOrderHowLongMonth"),dropdata);
	    	        Report.updateTestLog("How Long month Entered successfully" , "PASS");
	    	 }
			 else
			 {
	    	        Report.updateTestLog("How Long Month has not been Entered successfully", "FAIL");
	    	 }
			 verifyAndClick(pageProperties.getProperty("touChange.NewOrderContinue"),"Order Page continue");
			 
			 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("touChange.ErrorPaymentDetailsAlRegsterd")))
			 {
				 String Error=browser.getTextByXpath(pageProperties.getProperty("touChange.ErrorPaymentDetailsAlRegsterd"));
				 Report.updateTestLog("Already Registered Error- "+Error, "FAIL");
				 
			 }
			 
	}
	
	public void newMeterDetailsPage()
	 {
			Report.updateTestLog("***************************Meter Details Page************************", "WARN");			
			verifyAndInputById(pageProperties.getProperty("touChange.NewOrderGasReadings"), "Gas Reading", "1234");
			verifyAndClick(pageProperties.getProperty("touChange.NewOrderSmartMeterGasNo"),"Smart Meter Gas - No");
			verifyAndInputById(pageProperties.getProperty("touChange.NewOrderElecReadings"), "Elec Reading", "1234");
			verifyAndClick(pageProperties.getProperty("touChange.NewOrderSmartMeterElecNo"),"Smart Meter Elec - No");
		//	verifyAndClick(pageProperties.getProperty("touChange.NewHalfFrequency"),"Meter Detail - Half Frequency");
		//	verifyAndClick(pageProperties.getProperty("touChange.NewMeterDetailsContinue"),"Meter Details Page - Continue");
	}
	
	public void newMeterDetailsPageForPayAsYouGo()
	 {
			Report.updateTestLog("***************************Meter Details Page************************", "WARN");			
			verifyAndInputById(pageProperties.getProperty("touChange.NewOrderGasReadings"), "Gas Reading", "1234");
	//		verifyAndClick(pageProperties.getProperty("touChange.NewOrderSmartMeterGasNo"),"Smart Meter Gas - No");
			verifyAndInputById(pageProperties.getProperty("touChange.NewOrderElecReadings"), "Elec Reading", "1234");
	//		verifyAndClick(pageProperties.getProperty("touChange.NewOrderSmartMeterElecNo"),"Smart Meter Elec - No");
	 }
	
	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ Meter type selection ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ //
	
	public void meterSelection(String Meter){
		if(Meter=="Half")
		{
			verifyAndClick(pageProperties.getProperty("touChange.HalfHourlyMeter"),"Half hourly meter option");
			verifyAndClick(pageProperties.getProperty("touChange.NewMeterDetailsContinue"),"Meter Details Page - Continue");
		}
		else if(Meter=="Daily")
		{
			verifyAndClick(pageProperties.getProperty("touChange.DailyMeter"),"Daily meter option");
			verifyAndClick(pageProperties.getProperty("touChange.NewMeterDetailsContinue"),"Meter Details Page - Continue");
		}
		else if(Meter=="Monthly")
		{
			verifyAndClick(pageProperties.getProperty("touChange.MonthlyMeter"),"Monthly meter option");
			verifyAndClick(pageProperties.getProperty("touChange.NewMeterDetailsContinue"),"Meter Details Page - Continue");
		}
	}
	public void newPaymentPage(Acquisition acquisition){
		Report.updateTestLog("***********************Payment Details Page**********************", "WARN");		
		verifyAndInputById(pageProperties.getProperty("touChange.NewBankAccount"), "Bank Account Number", acquisition.getPaymentAccountNumber());
		verifyAndInputById(pageProperties.getProperty("touChange.NewBankSort1"), "Bank Sort Code 1", acquisition.getSortCode1());
		verifyAndInputById(pageProperties.getProperty("touChange.NewBankSort2"), "Bank Sort Code 2", acquisition.getSortCode2());
		verifyAndInputById(pageProperties.getProperty("touChange.NewBankSort3"), "Bank Sort Code 3", acquisition.getSortCode3());
		verifyAndInputById(pageProperties.getProperty("touChange.NewBankAccountName"), "Bank Account Name", acquisition.getAccountName());
	
		
		if(browser.isElementVisible(pageProperties.getProperty("touChange.NewPaymentDetailPaymentDate")))
		{
    		
         String dropbilldate=browser.getTextByXpath(pageProperties.getProperty("touChange.NewPaymentDetailPaymentDateDD"));
              browser.selectfromDropBox("id", pageProperties.getProperty("touChange.NewPaymentDetailPaymentDate"),dropbilldate);
              Report.updateTestLog("Payment Options Page Monthly bill date value is selected","PASS");
     	}
		else
		{
     			  Report.updateTestLog("Payment Options Page Monthly bill date value is not selected","FAIL");
    	}
		
		
		verifyAndClick(pageProperties.getProperty("touChange.NewPaymentContinue"), "Payment Continue");
		
			
	}
				
	public void newPaymentPageCC(){
		verifyAndClick(pageProperties.getProperty("touChange.NewPaymentContinue"), "Payment Continue");
	}
	public void newReviewOrder(){
		Report.updateTestLog("**********************Review Order Page***********************", "WARN");		
		verifyAndClick(pageProperties.getProperty("touChange.NewReviewOrderSpecialNo"),"Special - No");
		verifyAndClick(pageProperties.getProperty("touChange.NewReviewOrderPaperless"),"PaperLess Yes");
		verifyAndClick(pageProperties.getProperty("touChange.NewReviewOrderTerms"),"Review Order Terms and conditions");
		verifyAndClick(pageProperties.getProperty("touChange.NewReviewPlaceOrder"),"Place Order");
	}
	
	public void newReviewOrderForPAYGo(){
		Report.updateTestLog("**********************Review Order Page***********************", "WARN");		
		verifyAndClick(pageProperties.getProperty("touChange.NewReviewOrderSpecialNo"),"Special - No");
	//	verifyAndClick(pageProperties.getProperty("touChange.NewReviewOrderPaperless"),"PaperLess Yes");
		verifyAndClick(pageProperties.getProperty("touChange.NewReviewOrderTerms"),"Review Order Terms and conditions");
		verifyAndClick(pageProperties.getProperty("touChange.NewReviewPlaceOrder"),"Place Order");
	}
	
	public void newValidateConfirmation(){
		Report.updateTestLog("***********************Sign up Validation**************************", "WARN");
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("touChange.NewSingedUpCnfm")))
		{
			Report.updateTestLog("New Customer Signed up Successfully", "PASS");				
		}
		else
		{
			Report.updateTestLog("New Customer is not Signed up Successfully", "FAIL");
		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("touChange.NewConfmPageLoginToAccount")))
		{
			verifyAndClickWithXpath(pageProperties.getProperty("touChange.NewConfmPageLoginToAccount"), "Login to your Account");
		}
	}
		public void newValidateConfirmationForPAYGo(){
			Report.updateTestLog("***********************Sign up Validation**************************", "WARN");
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("touChange.NewSingedUpCnfm")))
			{
				Report.updateTestLog("New Customer Signed up Successfully", "PASS");				
			}
			else
			{
				Report.updateTestLog("New Customer is not Signed up Successfully", "FAIL");
			}
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("touChange.ReturnToBGHome")))
		{
			verifyAndClickWithXpath(pageProperties.getProperty("touChange.ReturnToBGHome"), "Return to british gas home");
		}
		
		
	}
	
	public void verifySalesOrderCreation(){
		browser.wait(10000);
		verifyAndClick(pageProperties.getProperty("touChange.DontShowThisAgain"), "first time logging in Page");
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.ContinueToYourAccount"), "Continue to your Account");
		browser.dynamicWaituntilVisiblebyXpath(pageProperties.getProperty("touChange.WTP"));
		
		 if (browser.isElementVisibleWithXpath(pageProperties.getProperty("touChange.WTP"))) 
		 {
	   		/* String dropdata=browser.getTextByXpath(pageProperties.getProperty("touChange.WTP"));
	   	        browser.getTextByXpath(pageProperties.getProperty("touChange.WTP") + dropdata);*/
	   	        Report.updateTestLog("Sales Order Created successfully" , "PASS");
	     }
		 else
		 {
	   	        Report.updateTestLog("Problem with Sales Order", "FAIL");
	     }	
	}
	
	// Check for upgrade now / Switch now link link xpath in application before executing //
	public void upgradeNowLink(){
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.upgradeNowLink"), "Upgrade now link");
		browser.dynamicWaituntilVisiblebyXpath(pageProperties.getProperty("touChange.nextPageVerification"));
	}
	
	public void selectTariff(String Tariff){
		if(Tariff=="Saturday"){
			verifyAndClick(pageProperties.getProperty("touChange.saturdayTariffRadio"), "Saturday tariff radio button");
		    verifyAndClickWithXpath(pageProperties.getProperty("touChange.saturdayTariffSwitch"),"Saturday tariff switch now link");
		}
		if(Tariff=="Sunday"){
			verifyAndClick(pageProperties.getProperty("touChange.sundayTariffRadio"), "Sunday tariff radio button");
			verifyAndClickWithXpath(pageProperties.getProperty("touChange.sundayTariffSwitch"),"Sunday tariff switch now link");
		}
}

	
	public void orderFreeOverlay(){
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("touChange.orderFreeOverlay"),"Order free overlay verification");
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.overlayTermsAndConditions"),"Terms and conditions check box in overlay");
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.overlayPlaceOrderButton"),"Place order button");
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("touChange.OrderConfirmation"),"Confirmation page");
	}
	
	public void GAQPage(){
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.gasAndElec"),"Gas and electricity link in footer");
		browser.wait(2000);
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.GAQLink"),"GAQ link in LHN");
		browser.wait(1000);
		verifyAndClick(pageProperties.getProperty("touChange.newGAQPostCodeNext"), "Next postcode button");
		verifyAndClick(pageProperties.getProperty("touChange.newGAQGAQBtn"), "GAQ Get a Quoate Button");
		browser.wait(1000);
	}
	
	
	public void tariff(String GAQTariff){
		if(GAQTariff=="Saturday"){
			verifyAndClick(pageProperties.getProperty("touChange.saturdayTariffRadioForGAQ"), "Saturday tariff radio button");
		    verifyAndClickWithXpath(pageProperties.getProperty("touChange.saturdayGAQTariffSwitch"),"Saturday tariff switch now link");
		}
		if(GAQTariff=="Sunday"){
			verifyAndClick(pageProperties.getProperty("touChange.sundayTariffRadioForGAQ"), "Sunday tariff radio button");
			verifyAndClickWithXpath(pageProperties.getProperty("touChange.sundayGAQTariffSwitch"),"Sunday tariff switch now link");
		}
	}
	
	public void GAQFlow(){
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.ContinueGAQ"),"Continue Button");
		browser.dynamicWaituntilVisiblebyXpath(pageProperties.getProperty("touChange.nextPageVerification"));
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.GAQTermsAndConditions"),"Terms and conditions Check box");
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.GAQPlaceOrder"),"Place order button");
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("touChange.OrderConfirmation"),"Confirmation page");	
	}
	
	public void MIFlow(){
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.ManageAccount"),"Manage account link");
		browser.wait(1000);
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.EnergyUsage"),"Energy usage link in LHN");
		browser.wait(1000);
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.MiData"),"MI data link in LHN");
		browser.wait(1000);
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.RequestData"),"Request data link ");
	}
	
	public void MiTariff(String MITariff){
		if(MITariff=="Saturday"){
			verifyAndClick(pageProperties.getProperty("touChange.saturdayTariffRadio"), "Saturday tariff radio button");
		    verifyAndClickWithXpath(pageProperties.getProperty("touChange.saturdayTariffSwitch"),"Saturday tariff switch now link");
		    browser.wait(1000);
			verifyAndClickWithXpath(pageProperties.getProperty("touChange.MIContinue"),"MI continue button");
			verifyAndClickWithXpath(pageProperties.getProperty("touChange.GAQTermsAndConditions"),"Terms and conditions Check box");
			verifyAndClickWithXpath(pageProperties.getProperty("touChange.GAQPlaceOrder"),"Place order button");
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("touChange.OrderConfirmation"),"Confirmation page");

		}
		if(MITariff=="Sunday"){
			verifyAndClick(pageProperties.getProperty("touChange.sundayTariffRadio"), "Sunday tariff radio button");
			verifyAndClickWithXpath(pageProperties.getProperty("touChange.sundayMITariffSwitch"),"Sunday tariff switch now link");
			browser.wait(1000);
			verifyAndClickWithXpath(pageProperties.getProperty("touChange.MIContinue"),"MI continue button");
			verifyAndClickWithXpath(pageProperties.getProperty("touChange.GAQTermsAndConditions"),"Terms and conditions Check box");
			verifyAndClickWithXpath(pageProperties.getProperty("touChange.GAQPlaceOrder"),"Place order button");
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("touChange.OrderConfirmation"),"Confirmation page");
		}
	}
	
	
	public void cstLink(String CSTFlow){
		if(CSTFlow=="Ineligible"){
		//verifyAndClickWithXpath(pageProperties.getProperty("touChange.cstIneligible"),"Register your interest in smartmeter link");
			verifyAndClickWithLinkText(pageProperties.getProperty("touChange.cstIneligible"), "Register your interest in smartmeter link");
		browser.wait(500);
	}
		if(CSTFlow=="Eligible"){
		//	verifyAndClickWithXpath(pageProperties.getProperty("touChange.cstEligible"),"Free upgrade to smart meter link");
			verifyAndClickWithLinkText(pageProperties.getProperty("touChange.cstEligible"), "Register your interest in smartmeter link");
			browser.wait(500);
		}
	}
	
	public void ineligibleFlow(){
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.fuseboxCheckbox"),"Fusebox simple check question radio button");
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.propertyCheckbox"),"Property simple check question radio button");
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.CheckPropertyLink"),"Check your property is eligible link");
		browser.wait(500);
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.ReturnToAccount"),"Retrun to your account link");
		browser.wait(500);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("touChange.RegisterVerification")))
		{
			Report.updateTestLog("Register to Smart meter completed successfully", "PASS");
		}
		else
		{
			Report.updateTestLog("Failure in smart meter register process", "FAIL");
		}
	}
	
	public void eligibleFlow(){
		// if data is available with two questions use fusebox and property checkboxes link else if data is with only one question use meter radio link //
		
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.MeterRadio"),"Meter radio");
	//	verifyAndClickWithXpath(pageProperties.getProperty("touChange.fuseboxCheckbox"),"Fusebox simple check question radio button");
	//	verifyAndClickWithXpath(pageProperties.getProperty("touChange.propertyCheckbox"),"Property simple check question radio button");
		verifyAndClickWithXpath(pageProperties.getProperty("touChange.eligibleContinue"),"Continue button");
	    browser.wait(15000);
	//    verifyAndClickWithLinkText(pageProperties.getProperty("touChange.seleceAppointment"), "Select appointment button");
	//    verifyAndClickWithXpath(pageProperties.getProperty("touChange.seleceAppointment"),"Select appointment button");
	    verifyAndClick(pageProperties.getProperty("touChange.seleceAppointment"), "Select appointment button");
	    browser.wait(1000);
	    verifyAndInputByXpath(pageProperties.getProperty("touChange.phoneNumber"), "Best contact number", "01234567891");
	    verifyAndClick(pageProperties.getProperty("touChange.HalfHourlyMeter"),"Half hourly meter option");
	    verifyAndClick(pageProperties.getProperty("touChange.NewMeterDetailsContinue"),"Meter Details Page - Continue");
	    browser.wait(1000);
	    verifyAndClickWithXpath(pageProperties.getProperty("touChange.GoToYourAcc"),"Go to your account link");
	    browser.wait(1000);
	    if(browser.isElementVisibleWithXpath(pageProperties.getProperty("touChange.Appointment")))
		{
			Report.updateTestLog("Register to Smart meter completed successfully", "PASS");
		}
		else
		{
			Report.updateTestLog("Failure in smart meter register process", "FAIL");
		}
	}
	
}

