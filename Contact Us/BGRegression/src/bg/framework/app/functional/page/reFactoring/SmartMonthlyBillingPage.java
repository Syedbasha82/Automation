package bg.framework.app.functional.page.reFactoring;

import java.util.ArrayList;
import java.util.Properties;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class SmartMonthlyBillingPage extends BasePage
{
private final static String FILE_NAME = "resources/ReFactoring/BGAcquisition.properties";
private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

	public void navigateToSMB(){
	//browser.open("http://10.224.70.104/content/britishgas/youraccount/smart-monthly-billing/smblandingpage.html");
    browser.open("http://10.224.70.104/smartmonthlybilling");
	//verifyAndClickWithXpath(pageProperties.getProperty("SMB.SMBLink"), "Link");
	}
	
	public void navigateToSMBnegativetemp(ArrayList<String> errList){
		browser.open("http://10.224.70.83/content/britishgas/youraccount/smart-monthly-billing/smblandingpage.html");
		verifyAndClickWithXpath(pageProperties.getProperty("SMB.SMBLink"), "Link");		
		//verifyIsElementVisibleById(pageProperties.getProperty("SMB.SelectAddress"), "Address drop down box");
    	
		if (!browser.isElementVisible(pageProperties.getProperty("SMB.SelectAddress"))) {
   		   	Report.updateTestLog("SMB link is not displayed" , "PASS");
   	    } else {
   	        Report.updateTestLog("SMB link is displayed", "FAIL");
   	    }
		new RegistrationPage().verifyErrorMsg(browser.getTextByXpath("//*[@class='error']/ul[1]")
				,errList.get(0),"Registration Page Error");
		}
		
	public void verifySMBLink()	{
		if(browser.isTextPresent("SmartMonthlyBilling")){
			Report.updateTestLog("SMB Link is Present", "FAIL");}
		else{
			Report.updateTestLog("SMB Link is not Present", "PASS");}	
	}


public void navigateToManageAccount(ArrayList<String> errList){
	verifyAndClickWithXpath(pageProperties.getProperty("SMB.SMBLink"), "Link");		
	//verifyIsElementVisibleById(pageProperties.getProperty("SMB.SelectAddress"), "Address drop down box");
	

}
	public void verifyTrilliantErrorMsg(){
		if (browser.isElementVisibleWithXpath(pageProperties.getProperty("SMB.TrillianErrorMessage"))) {
		   	Report.updateTestLog("Error Message is dispalyed" , "PASS");
	    } else {
	        Report.updateTestLog("Error Message is not dispalyed", "FAIL");
	    }
		
	}
	
	
//******************************** RMR changes *************************************//
	
	public void yourAddressPage(){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("SMB.SupplyAddress"))){
			Report.updateTestLog("Supply address is displayed" , "PASS");
		} else {
			Report.updateTestLog("Supply address is not displayed" , "FAIL");
		}	
		verifyAndClickWithXpath(pageProperties.getProperty("SMB.supplyAddressContinueButton"),"Supply address continue button");
	}
    public void paymentPage(String paymentType,Acquisition acquisition){
    	if(paymentType == "payNow"){
    		Report.updateTestLog("Can pay scenario" , "WARN");
    	    verifyAndClickWithXpath(pageProperties.getProperty("SMB.payNow"),"pay now is clicked");
    	    enterDetails(acquisition);
    	}
    	if(paymentType == "firstBill"){
    		Report.updateTestLog("Can pay scenario" , "WARN");
    		verifyAndClickWithXpath(pageProperties.getProperty("SMB.FirstBill"),"First bill Radio button is clicked");
    	}
    	if(paymentType == "mustPay"){
    		Report.updateTestLog("must pay scenario" , "WARN");
    	}
    	verifyAndClickWithXpath(pageProperties.getProperty("SMB.FirstBill"),"First bill Radio button is clicked");
    }
    
    public void enterDetails(Acquisition acquisition){
    	verifyAndSelectDropDownBox(pageProperties.getProperty("SMB.cardType"), "Card Type",acquisition.getCardType());
    	verifyAndInputById(pageProperties.getProperty("SMB.nameOfCard"), "Card Name", acquisition.getCardName());
    	verifyAndInputById(pageProperties.getProperty("SMB.cardNumber"), "Card Number", acquisition.getCardNumber());
    	verifyAndSelectDropDownBox(pageProperties.getProperty("SMB.expiryMonth"), "Expiry Month",acquisition.getExpiryMonth());
    	verifyAndSelectDropDownBox(pageProperties.getProperty("SMB.expiryYear"), "Expiry Year",acquisition.getExpiryYear());
    	verifyAndInputById(pageProperties.getProperty("SMB.cvvNumber"), "CVV Number", acquisition.getCvvCode());
    	verifyAndClick(pageProperties.getProperty("SMB.submitButton"),"Submit Button is clicked");
    }
   
}