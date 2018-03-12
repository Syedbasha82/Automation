package bg.framework.app.functional.page.sales;

import java.util.Properties;

import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class UpsellPage extends BasePage{
	private final static String File_AccPage = "resources/sales/UpsellPage.properties";
    private static Properties pageProperties = new PropertyLoader(File_AccPage).load();
    
    public void verifyUpgradeCustomer(String value){
    	browser.wait(2000);
    	String link;
    	if(browser.isElementVisible(pageProperties.getProperty("UpsellPage.UpsellSection"))){
    		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("UpsellPage.UpgradeTextXpath").replace("NUMBER", value))){
    		 link=browser.getTextByXpath(pageProperties.getProperty("UpsellPage.UpgradeTextXpath").replace("NUMBER", value)); 
    		Report.updateTestLog("Link for Upsell Customer "+link+" displayed", "PASS");}
    		else{
    			Report.updateTestLog("Link for Upsell Customer is not displayed", "FAIL");
    		}  
    	}  
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("UpsellPage.FindoutMorelink").replace("NUMBER", value))){
        String link1=browser.getTextByXpath(pageProperties.getProperty("UpsellPage.FindoutMorelink").replace("NUMBER",value));
		verifyAndClickWithXpath(pageProperties.getProperty("UpsellPage.FindoutMorelink").replace("NUMBER", ""),value);
		Report.updateTestLog("Link for Upgrade"+link1+" displayed", "PASS");}
		else{
		Report.updateTestLog("Link for Upgrade is not displayed", "FAIL");
		}
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("UpsellPage.HomeCareHeader"))){
            String text=browser.getTextByXpath(pageProperties.getProperty("UpsellPage.HomeCareHeader"));
    		Report.updateTestLog("Page"+text+" displayed", "PASS");}
    		else{
    		Report.updateTestLog("Payment Option Page not displayed", "FAIL");
    	  }
    	verifyAndClickWithXpath(pageProperties.getProperty("UpsellPage.ApplyNow"),"Apply Now");
    	browser.wait(3000);
    	verifyAndClickWithXpath(pageProperties.getProperty("UpsellPage.ExistingPaymenttype"),"Existing Payment type");
    	verifyAndClickWithXpath(pageProperties.getProperty("UpsellPage.Continue"),"Continue");
    	verifyAndClickWithXpath(pageProperties.getProperty("UpsellPage.Continue"),"Continue");
    	//Address verify
    	verifyAndClickWithXpath(pageProperties.getProperty("UpsellPage.TermsandConditions"),"Terms and Conditions");
    	verifyAndClickWithXpath(pageProperties.getProperty("UpsellPage.Continue"),"Continue");
    	if(browser.isTextPresent(pageProperties.getProperty("UpsellPage.ConfirmationText"))){
            String text=browser.getTextByXpath(pageProperties.getProperty("UpsellPage.ConfirmationText"));
            if (text.contains(pageProperties.getProperty("UpsellPage.ConfirmationText")))
    		Report.updateTestLog("Page"+text+" displayed", "PASS");}
    		else{
    		Report.updateTestLog("Confirmation Page not displayed", "FAIL");
    	  }
     }
    
}
