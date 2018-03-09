package bg.framework.app.functional.page.selfServe;

import java.util.Properties;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class SSOCRMstatusPage extends BasePage {
	
	private final static String FILE_NAME = "resources/selfServe/"+ApplicationConfig.BRAND+"AccountSummary.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();


    public void verifySSOAcquisitionRejection(){
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("AccountSummaryPage.SSOstatus"))){
    		if(browser.getTextByXpath(pageProperties.getProperty("AccountSummaryPage.SSOstatus")).contains("Energy Supply Start Date")){
    			Report.updateTestLog("The status message displayed is "+browser.getTextByXpath(pageProperties.getProperty("AccountSummaryPage.SSOstatus")), "Pass");
    		}
    		else
    		{
    			Report.updateTestLog("The SSO status message displayed is "+browser.getTextByXpath(pageProperties.getProperty("AccountSummaryPage.SSOstatus")), "Fail");
    		}
    	}
	}
    
    
    public void loginSSOErrorValidation(){
    	if(browser.isElementVisibleWithXpath(".//*[@id='errorList']/li/p")){
    		if(browser.getTextByXpath(".//*[@id='errorList']/li/p").contains("We're missing or don't recognise some of the information in")){
    			Report.updateTestLog("The status message displayed is : "+browser.getTextByXpath(".//*[@id='errorList']/li/p"), "Pass");
    		}
    		else{
    			Report.updateTestLog("The status message displayed is : "+browser.getTextByXpath(".//*[@id='errorList']/li/p"), "Fail");
    		}
    	}
    }
    
    
    public void verifySSOMeterReadOpen(){
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("AccountSummaryPage.SSOstatus"))){
    		if(browser.getTextByXpath(pageProperties.getProperty("AccountSummaryPage.SSOstatus")).contains("Meter reading required")){
    			Report.updateTestLog("The status message displayed is "+browser.getTextByXpath(pageProperties.getProperty("AccountSummaryPage.SSOstatus")), "Pass");
    		}
    		else
    		{
    			Report.updateTestLog("The SSO status message displayed is "+browser.getTextByXpath(pageProperties.getProperty("AccountSummaryPage.SSOstatus")), "Fail");
    		}
    	}
	}
    
    public void verifySSOPendingSecurityDeposit(){
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("AccountSummary.SSOConfirmationStatus"))){
    		Report.updateTestLog("The status of Pending Security Deposit is CONFIRMING YOUR ORDER", "Pass");
    	}
    	else{
    		Report.updateTestLog("The status of Pending Security Deposit is NOT CONFIRMING YOUR ORDER", "Fail");
    	}
    }
    
    public void verifySSOAcquisitionSent(){
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("AccountSummaryPage.SSOstatus"))){
    		if(browser.getTextByXpath(pageProperties.getProperty("AccountSummaryPage.SSOstatus")).contains("Your Energy supply Start Date")){
    			Report.updateTestLog("The status message displayed is "+browser.getTextByXpath(pageProperties.getProperty("AccountSummaryPage.SSOstatus")), "Pass");
    		}
    		else
    		{
    			Report.updateTestLog("The SSO status message displayed is "+browser.getTextByXpath(pageProperties.getProperty("AccountSummaryPage.SSOstatus")), "Fail");
    		}
    	}
    }
    
    public void verifySSOObjectionRaised(){
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("AccountSummaryPage.SSOstatus"))){
    		if(browser.getTextByXpath(pageProperties.getProperty("AccountSummaryPage.SSOstatus")).contains("Your Energy supply Start Date")){
    			Report.updateTestLog("The status message displayed is "+browser.getTextByXpath(pageProperties.getProperty("AccountSummaryPage.SSOstatus")), "Pass");
    		}
    		else
    		{
    			Report.updateTestLog("The SSO status message displayed is "+browser.getTextByXpath(pageProperties.getProperty("AccountSummaryPage.SSOstatus")), "Fail");
    		}
    	}
    }
    
    public void verifySSOObjectionwindowOpen(){
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("AccountSummaryPage.SSOstatus"))){
    		if(browser.getTextByXpath(pageProperties.getProperty("AccountSummaryPage.SSOstatus")).contains("Your Energy supply Start Date")){
    			Report.updateTestLog("The status message displayed is "+browser.getTextByXpath(pageProperties.getProperty("AccountSummaryPage.SSOstatus")), "Pass");
    		}
    		else
    		{
    			Report.updateTestLog("The SSO status message displayed is "+browser.getTextByXpath(pageProperties.getProperty("AccountSummaryPage.SSOstatus")), "Fail");
    		}
    	}
    }
    
    public void verifySSOPendingCooloff(){
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("AccountSummary.SSOConfirmationStatus"))){
    		Report.updateTestLog("The status of Pending Security Deposit is CONFIRMING YOUR ORDER", "Pass");
    	}
    	else{
    		Report.updateTestLog("The status of Pending Security Deposit is NOT CONFIRMING YOUR ORDER", "Fail");
    	}
    }
    	
    public void verifySSOSubmitted(){
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("AccountSummary.SSOEnergySupplyDateStatus"))){
    		Report.updateTestLog("The status of SSO Submitted is CONFIRMING YOUR ORDER", "Pass");
    	}
    	else{
    		Report.updateTestLog("The status of Pending Security Deposit is NOT CONFIRMING YOUR ORDER", "Fail");
    	}
    }
    
    public void logout(){
		if(browser.isTextPresent("Log out")){
			verifyAndClickWithLinkText(pageProperties.getProperty("AccountSummary.Logout"), "Logout");
			Report.updateTestLog("Logout Successful", "Pass");
		}
	}
}
