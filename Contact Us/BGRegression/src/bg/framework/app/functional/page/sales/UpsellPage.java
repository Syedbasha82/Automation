package bg.framework.app.functional.page.sales;

import java.util.Properties;

import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class UpsellPage extends BasePage{
	private final static String File_AccPage = "resources/sales/UpsellPage.properties";
    private static Properties pageProperties = new PropertyLoader(File_AccPage).load();
    
    
    public void clickUpsellLink(String value){
    	verifyAndClickWithXpath(pageProperties.getProperty("UpsellPage.UpsellLink").replace("NUMBER", ""+(Integer.parseInt(value)-100)), "UpSell Link");
    }
    
    public void enterContactDetails(){
    	verifyAndInputByXpath(pageProperties.getProperty("UpsellPage.TelephoneNumber"), "Telephone Number", "01234567891");
    	verifyAndClickWithXpath(pageProperties.getProperty("UpsellPage.ContactNextButton"), "Next Button");
    }
    
    
    public void enterPaymentDetails(){
    	verifyAndClickWithXpath(pageProperties.getProperty("UpsellPage.PaymentNextButton"), "Next Button");
    }
    
    public void termsandConditions(){
    	verifyAndClickWithXpath(pageProperties.getProperty("UpsellPage.TermsCondition"), "Terms & Condition check box");
    	verifyAndClickWithXpath(pageProperties.getProperty("UpsellPage.Assumption"), "Assumption check box");
    }
    
    public void verifyThankYouPage(){
    	if(browser.isTextPresent("Upsell confirmation")){
    		Report.updateTestLog("Upsell confirmation page displayed", "Pass");
    	}
    	else{
    		Report.updateTestLog("Upsell confirmation page not displayed", "Fail");
    	}
    }
    
    public void verifyUpgradeCustomer(String value){
    	//for(int i=0;i<3;i++){
    		clickUpsellLink(value);
        	//browser.clickWithXpath("//table[@class='table-component']/tbody/tr["+(i+2)+"]/td[3]/a");
    		browser.clickWithXpath("//table[@class='table-component']/tbody/tr[2]/td[3]/a");
        	enterContactDetails();
        	enterPaymentDetails();
        	termsandConditions();
        	verifyAndClickWithXpath(pageProperties.getProperty("UpsellPage.PlaceOrder"), "Place Order button");
        	verifyThankYouPage();
        //	browser.clickWithXpath("//a[@title='Your account']");
    	//}
    }
    
    
   /* public void verifyUpgradeCustomer(String value){
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
     }*/
    
}
