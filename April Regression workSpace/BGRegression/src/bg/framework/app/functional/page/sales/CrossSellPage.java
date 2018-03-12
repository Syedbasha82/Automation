package bg.framework.app.functional.page.sales;

import java.util.Properties;

import bg.framework.app.functional.action.sales.AcquisitionAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class CrossSellPage extends BasePage {
	  private final static String FILE_NAME = "resources/sales/CrossSell.properties";
	    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	    private static String orderDate;
	    private static boolean MarketingConsentFlag;
	
	public void enterHomecareDetails(Acquisition acquisition)
	{
		verifyAndInputById(pageProperties.getProperty("CrossSell.Telephone"),"ENTER TELEPHONE NO","0123456789" );
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Next1"),"Click Next Button");
		
		
		verifyAndInputById(pageProperties.getProperty("CrossSell.AccNum"),"ENTER Acct Num",acquisition.getPaymentAccountNumber() );
		verifyAndInputById(pageProperties.getProperty("CrossSell.Sort1"),"ENTER code1",acquisition.getSortCode1() );
		verifyAndInputById(pageProperties.getProperty("CrossSell.Sort2"),"ENTER code2",acquisition.getSortCode2() );
		verifyAndInputById(pageProperties.getProperty("CrossSell.Sort3"),"ENTER code3",acquisition.getSortCode3());
		verifyAndInputById(pageProperties.getProperty("CrossSell.AccName"),"ENTER Name",acquisition.getAccountName());
		//verifyAndSelectDropDownBox(pageProperties.getProperty("CrossSell.MonthName"),"enter pay day",acquisition.getPayDay());
		verifyAndSelectDropDownBox(pageProperties.getProperty("CrossSell.MonthName"), "enter pay day", "7th");
		
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Next2"),"Click Next Button");
		
		
		//verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Next3"),"CrossSell.Next3");
		//verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.TermsandCondition"),"Terms & conditions");
		//verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Next3"),"CrossSell.Next3");
	}
	
	public void enterNectaroptionone()
	{
	verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Nectar1"),"Click nectar option");
	verifyAndInputById(pageProperties.getProperty("CrossSell.cardText"),"ENTER card no","11111111111");
	//browser.wait(5000);
	verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.nectarTermsandcondition"),"Click Terms & Condition");
	}

	public void enterNectaroptiontwo()
	{
	verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Nectar2"),"Click nectar option");
	verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.nectarTermsandcondition"),"Click Terms & Condition");
	}
	
	public void enterNectaroptionthree()
	{
	verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Nectar3"),"Click nectar option");
	verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.nectarTermsandcondition"),"Click Terms & Condition");
	}
	
	public void enterNectaroptionfour()
	{
	verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Nectar4"),"Click nectar option");
	}
	
	public void enterConfirmOrder()
	{
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Next3"),"CrossSell.Next3");
		browser.wait(5000);
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.TermsandCondition"),"Terms & conditions");
		browser.wait(7000);
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Next4"),"CrossSell.Next3");
		browser.wait(7000);
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Confirm")," Confirm button");
		
	}
	
	public void verifyHomecarehundred()
	
	{
		System.out.println("100");
		verifyIsTextPresent("You have ordered HomeCare 100","Home care 100 confirmation");	
	}
		
	public void verifyHomecaretwohundred()
		
		{
			verifyIsTextPresent("You have ordered HomeCare 200","Home care 200 confirmation");	
		}
	
	public void verifyHomecarethreehundred()
	
	{
		verifyIsTextPresent("You have ordered HomeCare 300","Home care 300 confirmation");	
	}
	
	public void verifyHomecarefourhundred()
	
	{
		verifyIsTextPresent("You have ordered HomeCare 400","Home care 400 confirmation");	
	}
	
	public void navigateHomecaretwohundred()
	{
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.clickHomecare200"),"Navigate to Home care 200");	
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.ClickOrder"),"Navigate to Home care 200");
	}
	
	public void navigateHomecarethreehundred()
	{
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.clickHomecare300"),"Navigate to Home care 300");
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.ClickOrder"),"Navigate to Home care 300");
	}
	
	public void navigateHomecarefourhundred()
	{
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.clickHomecare400"),"Navigate to Home care 400");
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.ClickOrder"),"Navigate to Home care 400");
	}
	public void switchToElectricity()
	{
		//verifyAndClick(pageProperties.getProperty("CrossSell.NoThanks"), "NoThanksEsmart");
		verifyAndClick(pageProperties.getProperty("CrossSell.SwitchNowElec"), "SwitchNowElectricity");
		}
	
	public void switchToGas()
	{
		if(browser.isElementVisible(pageProperties.getProperty("CrossSell.SwitchNowGas")))
		{
		//verifyAndClick(pageProperties.getProperty("CrossSell.NoThanks"), "NoThanksEsmart");
		verifyAndClick(pageProperties.getProperty("CrossSell.SwitchNowGas"), "SwitchNowGas");
		}
		else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CrossSell.SwitchNowGas2")))
		{
			verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.SwitchNowGas2"), "SwitchNowGas");
		}
	}
	
	public void navigateToDualOrderPage(){
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.NavigateToDualOrder"),"Navigate to dual order");
	}
	
	public void loginErrorForClosedAccount() {
	    
		//String error=browser.getTextByXpath("//*[@id='errorList']/li");
		String error=browser.getTextByXpath(pageProperties.getProperty("Acquisition.ErrorMessageDisplayed"));
		if(error.contains("This is because you haven't used it for over 6 months"))
		{
			 Report.updateTestLog("Error validation is success for Freezed Account", "PASS");
		}else
		{
			 Report.updateTestLog("Error validation is failed for Freezed Account", "FAIL");
		}
	}
	public void CrossCellCheck1() {
	    
		//String error=browser.getTextByXpath("//*[@id='errorList']/li");
		String Account=browser.getTextByXpath("//*[@id='accountsOverviewForm']/div[2]/div[1]/div[3]/div[2]/div/div[2]/div/h3");
		
		
		if(Account.equals("Gas"))
		{
			verifyAndClickWithLinkText("Add Electricity", "Electricity Link Clicked");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			AddElectricityEndtoEnd();
		}
		if(Account.equals("Electricity"))
		{
			verifyAndClickWithLinkText("Add Gas", "Gas Link Clicked");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
public void CrossCellCheck2() {
	    
		//String error=browser.getTextByXpath("//*[@id='errorList']/li");
		String Account=browser.getTextByXpath(pageProperties.getProperty("CrossCell.AccType"));
		
		
		if(Account.equals("Gas"))
		{
			verifyAndClickWithXpath(pageProperties.getProperty("CrossCell.HomeCareLink"), "HomeCare Link Clicked");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			HomeCareEndtoEnd();
		}
		if(Account.equals("Electricity"))
		{
			verifyAndClickWithXpath(pageProperties.getProperty("CrossCell.HomeCareLink"), "HomeCare Link Clicked");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			HomeCareEndtoEnd();
		}
	}
	
	public void AddElectricityEndtoEnd() {

		
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.OrederButton1"), "Oreder Button");
		String dropText=browser.getTextByXpath(pageProperties.getProperty("CrossSell.DropText1"));
		verifyAndSelectDropDownBox("elecCurrentSupplier", "Electricity Supplier", dropText);
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Continue1"), "Continue Button");
		
		verifyAndSelectDropDownBox("day", "DAY", "1");
		verifyAndSelectDropDownBox("month", "MONTH", "March");
		verifyAndSelectDropDownBox("year", "YEAR", "1986");
		
		verifyAndInputByXpath(pageProperties.getProperty("CrossSell.PostCode1"), "Post Code", "DH12 2PY");
		
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.SearchPost"), "Post Code Search");
		try {
			Thread.sleep(16000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String dropText1=browser.getTextByXpath(pageProperties.getProperty("CrossSell.DropText2"));
		verifyAndSelectDropDownBox("displayaddr", "Post Code Selection", dropText1);
		verifyAndSelectDropDownBox("addrYear", "Yesr Selection", "3");
		verifyAndSelectDropDownBox("addrMonth", "Month Selection", "6");
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Continue1"), "Continue Button");
		
		verifyAndSelectDropDownBox("elecmetertype", "Electricity Meter Selection", "Single Rate Credit");
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.ClickNo"), "Click NO Option");
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Continue1"), "Continue Button");
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Continue1"), "Continue Button");
		
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Check1"), "Check Box 1");
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.PlaceOrder"), "Place Order Button Clicked");
		verifyIsTextPresent("Thank you for ordering");
		
	}

	public void HomeCareEndtoEnd() {
	    
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.OrederButton"), "Order Button clicked");
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.ApplyButton"), "Apply Next Button");
		verifyAndInputByXpath(pageProperties.getProperty("CrossSell.AccNo"), "Account No", "11111111");
		verifyAndInputByXpath(pageProperties.getProperty("CrossSell.SOrtCode1"), "Sort Code 1", "11");
		verifyAndInputByXpath(pageProperties.getProperty("CrossSell.SOrtCode2"), "Sort Code 2", "11");
		verifyAndInputByXpath(pageProperties.getProperty("CrossSell.SOrtCode3"), "Sort Code 3", "11");
		verifyAndInputByXpath(pageProperties.getProperty("CrossSell.AccName"), "Name of Account", "Saving");
		String dropText=browser.getTextByXpath(pageProperties.getProperty("CrossSell.DropText"));
		verifyAndSelectDropDownBox(pageProperties.getProperty("CrossSell.DropSelctrion"), "Like to Pay Drop Down", dropText);
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.NextButton"), "Next Button");
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.NectarPointOption"), "Nectar Point Option");
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.NectctarPointNext"), "Nectar Point Next button");
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.TCCheck1"), "Teram and Condition Checkbox1");
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.TCCheck2"), "Teram and Condition Checkbox2");
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.TCCheckNext"), "Teram and Condition Next Button");
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Confirm"), "Confirm Order Button");
		verifyIsTextPresent("Thank you for your order");
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.HomePage"),"Back to Home Order Page");
	}
	
	public void verifyandclickExcess0(){
		verifyAndClick(pageProperties.getProperty("CrosssellPage.ExcessZero"),"Excess 0");
	}
	public void verifyandclickExcess50(){
		verifyAndClick(pageProperties.getProperty("CrosssellPage.ExcessFifty"),"Excess 50");
	}
	public void verifyandclickExcess99(){
		verifyAndClick(pageProperties.getProperty("CrosssellPage.Excess99"),"Excess 99");
	}
	public void orderHomecare100(){
		verifyAndClickWithXpath(pageProperties.getProperty("CrosssellPage.AddHomeCare100"),"AddHomeCare 100");
	}
	public void orderHomecare200(){
		verifyAndClickWithXpath(pageProperties.getProperty("CrosssellPage.AddHomeCare200"),"AddHomeCare 200");
	}
	public void orderHomecare300(){
		verifyAndClickWithXpath(pageProperties.getProperty("CrosssellPage.AddHomeCare300"),"AddHomeCare 300");
	}
	public void orderHomecare400(){
		verifyAndClickWithXpath(pageProperties.getProperty("CrosssellPage.AddHomeCare400"),"AddHomeCare 400");
	}
 public void verifyCrossSellEndToEnd(UserProfile userProfile,Acquisition acquisition) {
	    browser.wait(5000);
	    orderDate = new OnlineDBConnector().DBsysdate();
	    browser.isTextPresent(userProfile.getFirstName());
	    browser.isTextPresent(userProfile.getLastName());
	    browser.isTextPresent(userProfile.getEmail());
	    browser.isTextPresent(userProfile.getPhoneNumber());
	    
	    if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CrossCell.TeleNum"))){
	    	verifyAndInputByXpath(pageProperties.getProperty("CrossCell.TeleNum"),"Telephone Number","01234567891");
	    }
	    if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CrossCell.personalNextButton"))){
	    	verifyAndClickWithXpath(pageProperties.getProperty("CrossCell.personalNextButton"),"Personal Details Next Button");
	    }
	    
	    //click boiler type next button
	    verifyAndClickWithXpath(pageProperties.getProperty("CrossCell.BoilerNext"), "Boiler Continue Button");
	    
		verifyAndClick(pageProperties.getProperty("CrosssellPage.xsellMonthlyDDOption"), "MonthlyDD payment option clicked");
		
		verifyAndInputById(pageProperties.getProperty("CrosssellPage.contractsMonthlyDDaccountNumber"), "Account No",acquisition.getPaymentAccountNumber());
		verifyAndInputById(pageProperties.getProperty("CrosssellPage.contractsMonthlyDDsortCode1"), "Sort Code 1", acquisition.getSortCode1());
		verifyAndInputById(pageProperties.getProperty("CrosssellPage.contractsMonthlyDDsortCode2"), "Sort Code 2", acquisition.getSortCode2());
		verifyAndInputById(pageProperties.getProperty("CrosssellPage.contractsMonthlyDDsortCode3"), "Sort Code 3", acquisition.getSortCode3());
		verifyAndInputById(pageProperties.getProperty("CrosssellPage.contractsMonthlyDDaccholderName"), "Name of Account", "Saving");
		//String dropText=browser.getTextByXpath(pageProperties.getProperty("CrosssellPage.contractsMonthlyDDmonthlyPayment"));
		//verifyAndSelectDropDownBox(pageProperties.getProperty("CrosssellPage.contractsMonthlyDDmonthlyPayment"), "Like to Pay Drop Down", dropText);
		verifyAndClick(pageProperties.getProperty("CrosssellPage.xsellOrderPaymentdetailsButton"), "Next Button");
		browser.wait(3000);
		if(browser.isElementVisible(pageProperties.getProperty("CrosssellPage.card_never"))){
			verifyAndClick(pageProperties.getProperty("CrosssellPage.card_never"), "Nectar Point No Option");
			verifyAndClick(pageProperties.getProperty("CrosssellPage.nectarPointsButton"), "Nectar Point Next button");	
		}
		else{
			Report.updateTestLog("Nectar Section not displayed since the customer has already registered.", "Pass");
		}
		
		verifyAndClick(pageProperties.getProperty("CrosssellPage.xsellorderTerms1"), "Terms and Condition Checkbox1 for HomeCare Product");
		verifyAndClick(pageProperties.getProperty("CrosssellPage.xsellorderassumption"), "x-sell order assumption");
		//verifyAndClick(pageProperties.getProperty("CrosssellPage.xsellorderTerms3"), "Terms and Condition ");
		selectMarketingConsent();
		verifyAndClick(pageProperties.getProperty("CrosssellPage.termsAndconditionsButton"), "Confirm Order Button");
		browser.wait(3000);
		verifyIsTextPresent("Thank you for your order");
		//verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.HomePage"),"Back to Home Order Page");
	}
 
 private void selectMarketingConsent(){
 	verifyAndClickWithXpath(pageProperties.getProperty("CrosssellPage.LetterConsent"), "LetterConsent");
 	verifyAndClickWithXpath(pageProperties.getProperty("CrosssellPage.LandLineConsent"), "LandLineConsent");
 		MarketingConsentFlag = true;
 	}
 	
	public void verifyMarketingConsent(){
 	String LeadData;
 	OnlineDBConnector onlineDBConnector = new OnlineDBConnector();
 	LeadData = onlineDBConnector.getServicesLeadData(orderDate);
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
 	    					   
 	    if (LeadData.contains("<MarketingChannelPreference MarketingChannel=\"LandLine\" OptIn=\"N\" />")){
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
 public  void getServicesLeadType(){	   	
	   	String leadtype=new OnlineDBConnector().getServicesLeadType(orderDate);
	   	System.out.println(leadtype);
	   	String strAcqLead = "SERVICES_HOMECARE";
	   	if (leadtype.equals(strAcqLead)){
	   		Report.updateTestLog("Lead Type Generated for Acquisition is " + leadtype, "DONE");
	   		}
	   	else{
	   	Report.updateTestLog("Lead Type not as expected, Lead Type Generated is :" + leadtype, "FAIL");
	   	}   		   	
	    	
	   }
 public  void getServicesLeadData(){	   	
	   	String leadtype=new OnlineDBConnector().getServicesLeadData(orderDate);
	   	System.out.println(leadtype);
	   	if(leadtype.equals(null)){
	   		Report.updateTestLog("Lead Type not as expected, Lead Data Generated is :" + leadtype, "FAIL");
	   	}
	   	else{
	   		Report.updateTestLog("Lead Data Generated for Cross sell is " + leadtype, "DONE");
	   	}   		 
	   	verifyMarketingConsent();
	   }
}



