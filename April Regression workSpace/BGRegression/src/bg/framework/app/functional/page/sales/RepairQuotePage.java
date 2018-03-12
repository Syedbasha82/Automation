package bg.framework.app.functional.page.sales;

import java.util.Properties;

import org.openqa.selenium.support.ui.Select;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;

import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class RepairQuotePage extends BasePage {
	  private final static String FILE_NAME = "resources/sales/RepairQuote.properties";
	    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

	public void navigateToRepairQuotePage(){
		browser.open(ApplicationConfig.APP_BG_URL+"/ViewQuoteDetails/cover/");
	//	browser.open("https://10.224.70.111/ViewQuoteDetails/cover/");
		browser.wait(getWaitTime());
		verifyAndClickWithXpath(pageProperties.getProperty("RepairQuote.RepairQuote"),"Get a repair quote link" );
		}
	
	public void getServiceQuoteDetails(String ServiceType){
		if(ServiceType=="Boiler")
		{
			verifyAndClickWithXpath(pageProperties.getProperty("RepairQuote.Boiler"),"Boiler service radio button");
			verifyAndClickWithXpath(pageProperties.getProperty("RepairQuote.ServiceNext"),"Next button");
		}
		if(ServiceType=="GasAppliance"){
			verifyAndClickWithXpath(pageProperties.getProperty("RepairQuote.GasAppliance"),"Gas appliance radio button");
			verifyAndClickWithXpath(pageProperties.getProperty("RepairQuote.ServiceNext"),"Next button");
		}
	}
	
	public void getContactDetails(UserProfile userProfile,String ServiceType,String Customer){
		if (Customer=="Anonymous"){
		verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("RepairQuote.TitleDropdown"), "Title dropdown", userProfile.getTitle());
		verifyAndInputByXpath(pageProperties.getProperty("RepairQuote.FirstName"), "First Name ", userProfile.getFirstName());
		verifyAndInputByXpath(pageProperties.getProperty("RepairQuote.LasttName"), "Last Name ", userProfile.getLastName());
		verifyAndInputByXpath(pageProperties.getProperty("RepairQuote.EmailAddress"), "Email address ", userProfile.getEmail());
		verifyAndInputByXpath(pageProperties.getProperty("RepairQuote.Telephone"), "Telephone number ", userProfile.getPhoneNumber());
		verifyAndInputByXpath(pageProperties.getProperty("RepairQuote.PostCode"), "Postcode ", userProfile.getPostCode());
		verifyAndClickWithXpath(pageProperties.getProperty("RepairQuote.ContactNext"),"Next button");
		verifyAndClickWithXpath(pageProperties.getProperty("RepairQuote.GAQ"),"GAQ button");
		}
		if (Customer=="LoggedIn"){
			verifyAndInputByXpath(pageProperties.getProperty("RepairQuote.Telephone"), "Telephone number ", userProfile.getPhoneNumber());
			verifyAndClickWithXpath(pageProperties.getProperty("RepairQuote.ContactNext"),"Next button");
			verifyAndClickWithXpath(pageProperties.getProperty("RepairQuote.GAQ"),"GAQ button");
		}
		if(ServiceType=="GasAppliance"){
			browser.wait(1000);
			browser.isTextPresent("Your Quote Results");
		}
	}
	public void OrdernowPage(){
		verifyAndClickWithXpath(pageProperties.getProperty("RepairQuote.OrderNow"),"Order now link");
		verifyAndClickWithXpath(pageProperties.getProperty("RepairQuote.ContactNext"),"Next button");
		browser.wait(30000);
	//	browser.dynamicWaituntilVisiblebyXpath("RepairQuote.DropdownValue");
		browser.wait(30000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("RepairQuote.DropdownValue"))){
			browser.wait(30000);
            Select select = new Select(browser.getElementByXpath(pageProperties.getProperty("RepairQuote.DropdownValue")));
            select.selectByIndex(2);
            Report.updateTestLog("Address is selected from Dropdown", "Pass");  
          }
         else
         {
            Report.updateTestLog("Address is not Selected from Dropdown", "Fail");  
         } 
		verifyAndClickWithXpath(pageProperties.getProperty("RepairQuote.AddressNext"),"Next button");
		browser.wait(500);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("RepairQuote.Overlay"))){
			verifyAndClickWithXpath(pageProperties.getProperty("RepairQuote.Overlay"),"Overlay close button");
			verifyAndClickWithXpath(pageProperties.getProperty("RepairQuote.AddressNext"),"Next button");
		}
		}
	public void getPaymentDetails(UserProfile userProfile){
		browser.wait(1000);
		verifyAndInputByXpath(pageProperties.getProperty("RepairQuote.AccountNo"), "Account number", userProfile.getAccNumber());
		verifyAndInputByXpath(pageProperties.getProperty("RepairQuote.Sorcode1"), "Sortcode1", userProfile.getsortCode1());
		verifyAndInputByXpath(pageProperties.getProperty("RepairQuote.Sorcode2"), "Sortcode2", userProfile.getsortCode2());
		verifyAndInputByXpath(pageProperties.getProperty("RepairQuote.Sorcode3"), "Sortcode3", userProfile.getsortCode3());
		verifyAndInputByXpath(pageProperties.getProperty("RepairQuote.AccHolderName"), "Account holder name","AutomationTester");
		verifyAndClickWithXpath(pageProperties.getProperty("RepairQuote.PaymentNext"),"Next button");
		browser.dynamicWaituntilVisiblebyXpath(".//*[@id='icon-termsDetails']");
	}
	public void getTermsAndOrderDetails(){
		verifyAndClickWithXpath(pageProperties.getProperty("RepairQuote.TermsAndConditions"),"Terms and condition check box");
		verifyAndClickWithXpath(pageProperties.getProperty("RepairQuote.Mail"),"Mail marketing consent check box");
		verifyAndClickWithXpath(pageProperties.getProperty("RepairQuote.Email"),"EMail marketing consent check box");
		verifyAndClickWithXpath(pageProperties.getProperty("RepairQuote.Landline"),"Landline marketing consent check box");
		verifyAndClickWithXpath(pageProperties.getProperty("RepairQuote.Mobile"),"Mobile marketing consent check box"); 
		verifyAndClickWithXpath(pageProperties.getProperty("RepairQuote.Text"),"Text marketing consent check box");
		verifyAndClickWithXpath(pageProperties.getProperty("RepairQuote.PlaceOrder"),"Place order button");
		browser.wait(1000);
	//	browser.dynamicWaituntilVisiblebyXpath(".//*[@id='h1']");
		if(browser.isTextPresent("Thank you for your order"))
		{
			Report.updateTestLog("Order Successful", "PASS");
		}
		else
		{
			Report.updateTestLog("Order Unsuccessful", "FAIL");
		}
	}
	
	public void verifyLeadTabledata_GetquotesAudit(UserProfile userProfile){
        OnlineDBConnector dbFunctions = new OnlineDBConnector();
        String date=dbFunctions.DBsysdateDdmmyyhhmi();
        String QuoteStatus= dbFunctions.getQuoteStatus(date,userProfile.getEmail());       
        Report.updateTestLog("Audit id is made in audit table as expected and Quote Status"+QuoteStatus,"Pass");
        }

}


