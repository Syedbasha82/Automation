package bg.framework.app.functional.page.sales;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.KitchenApplianceCover;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;

import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.page.common.BasePage;
import org.openqa.selenium.support.ui.Select;
import bg.framework.app.functional.action.sales.KitchenApplianceCoverAction;

import java.util.Properties;

public class KitchenApplianceCoverPage extends BasePage {
	private final static String FILE_NAME = "resources/sales/KitchenApplianceCoverPage.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

   public void navigateToKitchenApplianceCoverPage(){
	   browser.open(ApplicationConfig.APP_BG_URL+"/ViewQuoteDetails/coverKitchen/");
	   if (browser.isTextPresent("Kitchen appliance cover"))
	   {
		   Report.updateTestLog("kitchen Appliance Cover Page Is present", "PASS");
	   }
	   else
	   {
		   Report.updateTestLog("kitchen Appliance Cover Page Is not present", "FAIL");
	   }
	   
	String value= "£12.50";

	  
   if (browser.getTextByXpath( ".//*[contains(text(),'£12.50')]").equalsIgnoreCase(value))
	      
   {
	   Report.updateTestLog("kitchen Appliance Cover value for three appliances is present ", "PASS");
   }
   else
   {
	   Report.updateTestLog("kitchen Appliance Cover value for three appliances is present", "FAIL");
   }
   String value1= "£11.50";

	  
   if (browser.getTextByXpath( "//*[contains(@Class,'prod-inner-rgt')]//*[contains(@Class,'currency-l txt-prim-color')]").equalsIgnoreCase(value1))
	      
   {
	   Report.updateTestLog("Value for Home Care 200 is present ", "PASS");
   }
   else
   {
	   Report.updateTestLog("Value for Home Care 200 is present", "FAIL");
   }
   
}
   /*public void navigateToWhatareYourContactDetailsSection(KitchenApplianceCover  kitchenAppliance){
	   verifyAndClickWithXpath(pageProperties.getProperty("KAC.Getaquote"), "Get a quote button");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.Title"),"Title", "Mr");
	   verifyAndInputById(pageProperties.getProperty("KAC.Firstname"), "First name",kitchenAppliance.getFirstName());
	   verifyAndInputById(pageProperties.getProperty("KAC.LastName"), "Last Name",kitchenAppliance.getLastName());
	   verifyAndInputById(pageProperties.getProperty("KAC.emailID"), "email ID",kitchenAppliance.getEmail());
	   verifyAndInputById(pageProperties.getProperty("KAC.Telephonenumber"), "Telephone number",kitchenAppliance.getPhoneNumber());
	   verifyAndInputById(pageProperties.getProperty("KAC.postCode"), "post Code",kitchenAppliance.getPostCode());
	   verifyAndClickWithXpath(pageProperties.getProperty("KAC.nextBtn1"), "next Btn 1");
	   
	   
	   
   }*/
   public void navigateToWhatareYourContactDetailsSection(){
	   verifyAndClickWithXpath(pageProperties.getProperty("KAC.Getaquote"), "Get a quote button");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.Title"),"Title", "Mr");
	   verifyAndInputById(pageProperties.getProperty("KAC.Firstname"), "First name","Automation");
	   verifyAndInputById(pageProperties.getProperty("KAC.LastName"), "Last Name","Testing");
	   verifyAndInputById(pageProperties.getProperty("KAC.emailID"), "email ID","automationtestingkac@bgdigitaltest.co.uk");
	   verifyAndInputById(pageProperties.getProperty("KAC.Telephonenumber"), "Telephone number","0207123456");
	   verifyAndInputById(pageProperties.getProperty("KAC.postCode"), "post Code","tw18 3he");
	   verifyAndClickWithXpath(pageProperties.getProperty("KAC.nextBtn1"), "next Btn 1");
	   
	   
	   
   }
   
   public void navigateToAddAny2ExtrasSection(){
	   verifyAndClickWithXpath(pageProperties.getProperty("KAC.Cover2"),"Cover2" );
	   verifyAndClickWithXpath(pageProperties.getProperty("KAC.nextBtn3"), "next Btn 3");
   }
   public void selectNone(){
	   verifyAndClickWithXpath(pageProperties.getProperty("KAC.nextBtn3"), "next Btn 3");
   }
   
   public void navigateToAddAny6ExtrasSection(){
	   verifyAndClickWithXpath(pageProperties.getProperty("KAC.Cover6"),"Cover6" );
	   verifyAndClickWithXpath(pageProperties.getProperty("KAC.nextBtn3"), "next Btn 3");
   }
   
   public void navigateTo2ApplianceSection(){
	   
	   //verifyIsTextPresent("Your cover includes 5 appliances");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.app1"),"Free standing gas cooker", "2");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.app2"),"Built in hob", "1");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.app3"),"Fridge", "2");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.app4"),"Freezer", "1");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.app5"),"Dishwasher", "1");
	   verifyAndClickWithXpath(pageProperties.getProperty("KAC.nextBtn4"), "next Btn 4");
	   verifyIsTextPresent("Sorry, we need you to look at the following areas of the form again");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.app1"),"Free standing gas cooker", "1");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.app2"),"Built in hob", "1");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.app3"),"Fridge", "1");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.app4"),"Freezer", "1");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.app5"),"Dishwasher", "1");
	   verifyAndClickWithXpath(pageProperties.getProperty("KAC.nextBtn4"), "next Btn 4");
	   
   }
 public void navigateTo6ApplianceSection(){
	   
	   //verifyIsTextPresent("Your cover includes 5 appliances");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.app1"),"Free standing gas cooker", "2");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.app2"),"Built in hob", "2");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.app3"),"Fridge", "2");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.app4"),"Freezer", "3");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.app5"),"Dishwasher", "2");
	   verifyAndClickWithXpath(pageProperties.getProperty("KAC.nextBtn4"), "next Btn 4");
	   verifyIsTextPresent("Sorry, we need you to look at the following areas of the form again");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.app1"),"Free standing gas cooker", "2");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.app2"),"Built in hob", "2");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.app3"),"Fridge", "2");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.app4"),"Freezer", "2");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.app5"),"Dishwasher", "1");
	   verifyAndClickWithXpath(pageProperties.getProperty("KAC.nextBtn4"), "next Btn 4");
   }
 public void navigateToApplianceSection(){
	   
	   //verifyIsTextPresent("Your cover includes 5 appliances");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.app1"),"Free standing gas cooker", "2");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.app2"),"Built in hob", "1");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.app3"),"Fridge", "1");
	   verifyAndClickWithXpath(pageProperties.getProperty("KAC.nextBtn4"), "next Btn 4");
	   verifyIsTextPresent("Sorry, we need you to look at the following areas of the form again");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.app1"),"Free standing gas cooker", "1");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.app2"),"Built in hob", "1");
	   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.app3"),"Fridge", "1");
	   verifyAndClickWithXpath(pageProperties.getProperty("KAC.nextBtn4"), "next Btn 4");
	   
 }
   public void verifyEditLink(){
	   verifyAndClickWithXpath(pageProperties.getProperty("KAC.edit1"), "edit 1");
	   verifyAndClickWithXpath(pageProperties.getProperty("KAC.nextBtn1"), "nextBtn1");
	   verifyAndClickWithXpath(pageProperties.getProperty("KAC.nextBtn3"), "next Btn 3");
	   verifyAndClickWithXpath(pageProperties.getProperty("KAC.edit2"), "edit 2");
	   verifyAndClickWithXpath(pageProperties.getProperty("KAC.nextBtn3"), "next Btn 3");
	   verifyAndClickWithXpath(pageProperties.getProperty("KAC.nextBtn4"), "next Btn 4");
	   verifyAndClickWithXpath(pageProperties.getProperty("KAC.edit3"), "edit 3");
	   verifyAndClickWithXpath(pageProperties.getProperty("KAC.nextBtn4"), "next Btn 4");
	   verifyAndClickWithXpath(pageProperties.getProperty("KAC.GetAQuoteButton"), "Get A Quote Button");
   }
  public void verifyOrderNowPagefor3Appliances(){
	    String value= "£12.50";

	   if (browser.getTextByXpath( ".//*[contains(text(),'£12.50')]").equalsIgnoreCase(value))
		      
	   {
		   Report.updateTestLog("kitchen Appliance Cover value for three appliances is present ", "PASS");
	   }
	   else
	   {
		   Report.updateTestLog("kitchen Appliance Cover value for three appliances is present", "FAIL");
	   }
	
	    verifyAndClickWithXpath(pageProperties.getProperty("KAC.OrderNowButton"),"OrderNowButton" ) ;
	   // verifyIsElementVisibleWithLinkText(pageProperties.getProperty("KAC.EditMyQuote"), "Edit My Quote");
	    verifyAndClickWithXpath(pageProperties.getProperty("KAC.StartYourOrderNowButton"),"Start Your Order Now Button" ) ;
	   
  }
  public void verifyOrderNowPagefor5Appliances(){
	    String value= "£16.00";

	   if (browser.getTextByXpath( ".//*[contains(text(),'£16.00')]").equalsIgnoreCase(value))
		      
	   {
		   Report.updateTestLog("kitchen Appliance Cover value for five appliances is present ", "PASS");
	   }
	   else
	   {
		   Report.updateTestLog("kitchen Appliance Cover value for five appliances is present", "FAIL");
	   }
	
	    verifyAndClickWithXpath(pageProperties.getProperty("KAC.OrderNowButton"),"OrderNowButton" ) ;
	   // verifyIsElementVisibleWithLinkText(pageProperties.getProperty("KAC.EditMyQuote"), "Edit My Quote");
	    verifyAndClickWithXpath(pageProperties.getProperty("KAC.StartYourOrderNowButton"),"Start Your Order Now Button" ) ;
	   
}
  public void verifyOrderNowPagefor9Appliances(){
	    String value= "£20.00 ";

	   if (browser.getTextByXpath( ".//*[contains(text(),'£20.00 ')]").equalsIgnoreCase(value))
		      
	   {
		   Report.updateTestLog("kitchen Appliance Cover value for nine appliances is present ", "PASS");
	   }
	   else
	   {
		   Report.updateTestLog("kitchen Appliance Cover value for nine appliances is present", "FAIL");
	   }
	
	    verifyAndClickWithXpath(pageProperties.getProperty("KAC.OrderNowButton"),"OrderNowButton" ) ;
	   // verifyIsElementVisibleWithLinkText(pageProperties.getProperty("KAC.EditMyQuote"), "Edit My Quote");
	    verifyAndClickWithXpath(pageProperties.getProperty("KAC.StartYourOrderNowButton"),"Start Your Order Now Button" ) ;
	   
}

  
  public void verifyContactDetailsSection(){
	 
	  verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.selectoption"),"SelectOption", "TV Advert");
	  verifyAndClickWithXpath(pageProperties.getProperty("KAC.nextBtn1"), "next Btn 1");
	  
  }
  public void verifyNectarPointsSection(){
	  verifyAndClickWithXpath(pageProperties.getProperty("KAC.NoThanks"),"No Thanks");
	  verifyAndClickWithXpath(pageProperties.getProperty("KAC.nextBtn3"), "next Btn 3");
  }
  
  public void verifyEnterYourAddressSection(){
	  
	  browser.dynamicWaituntilVisiblebyXpath(".//*[@id='serviceAddressList1']");
	  /*//verifyAndClickWithXpath(pageProperties.getProperty("KAC.search"), "Search button");
	  //verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("KAC.SelectAddress"),"Select Address" , "0");
	  browser.selectfromDropBoxByXpath(".//*[@id='serviceAddressList1']", "1, Meadow Gardens, STAINES-UPON-THAMES, Middlesex, TW18 3HE");
	  if(browser.isElementVisibleWithXpath(pageProperties.getProperty("KAC.SelectAddress"))){
		    Select select = new Select(browser.getElementByXpath(pageProperties.getProperty("KAC.SelectAddress")));
			select.selectByIndex(1);
			Report.updateTestLog("Address Selected from Dropdown", "Pass");
		}
		else{
			Report.updateTestLog("Address not getting populated from Dropdown", "Fail");
		}	*/
	  browser.selectfromDropBoxByXpath(".//*[@id='serviceAddressList1']", "1, Meadow Gardens, STAINES-UPON-THAMES, Middlesex, TW18 3HE");
	  verifyAndClickWithXpath(pageProperties.getProperty("KAC.nextBtn4"), "next Btn 4");
	  	  	
  }
  
  public void verifyEnterPaymentDetails(){
	  
		  verifyAndClickWithXpath(pageProperties.getProperty("KAC.MonthlyFixedDirectDebit"), "Monthly Fixed Direct Debit");
		  
		  verifyAndInputByXpath(pageProperties.getProperty("KAC.BankAccountNumber"), "Bank account number ", "11049151");
		  //verifyAndInputByXpath(pageProperties.getProperty("KAC.BankAccountNumber"), "Bank account number ", acquisition.getPaymentAccountNumber());
			verifyAndInputByXpath(pageProperties.getProperty("KAC.SortCode1"), "SortCode 1 ", "40");
			verifyAndInputByXpath(pageProperties.getProperty("KAC.SortCode2"), "SortCode 2 ", "02");
			verifyAndInputByXpath(pageProperties.getProperty("KAC.SortCode3"), "SortCode 3 ", "50");
			verifyAndInputByXpath(pageProperties.getProperty("KAC.AccountHolderName"), "AccountHolderName ", "automation");
			verifyAndSelectDropDownBox(pageProperties.getProperty("KAC.PaymentDate"), "Payment date ","5th");
			verifyAndClickWithXpath(pageProperties.getProperty("KAC.nextBtn5"), "next Btn 5");
  }
  public void verifyTermsAndConditions(){
	  
	  verifyAndClickWithXpath(pageProperties.getProperty("KAC.orderTerms"), "Order Terms");
	  verifyAndClickWithXpath(pageProperties.getProperty("KAC.AssumptionTerms"), "Assumption Terms");
	  checkMarketingConsent();
	  verifyAndClickWithXpath(pageProperties.getProperty("KAC.PlaceOrder"), "Place Order");
  }
  public void checkMarketingConsent(){
	  verifyAndClickWithXpath(pageProperties.getProperty("KAC.Mail"), "Mail");
	  verifyAndClickWithXpath(pageProperties.getProperty("KAC.Email"), "Email");
	  verifyAndClickWithXpath(pageProperties.getProperty("KAC.Landline"), "Landline");
	  verifyAndClickWithXpath(pageProperties.getProperty("KAC.Mobile"), "Mobile");
	  verifyAndClickWithXpath(pageProperties.getProperty("KAC.Text"), "Text");
  }
  public void verifyThankYouPage(){
	  if(browser.isTextPresent("Thank you for your order")){
		  Report.updateTestLog("Thank you page is displayed", "PASS");
		 
	  }
	  else{
		  Report.updateTestLog("Thank you page is not displayed", "FAIL"); 
	  }
	  if(browser.isTextPresent("You have ordered Kitchen Appliance Cover")){
		  Report.updateTestLog("You have ordered Kitchen Appliance Cover  is displayed", "PASS");
		 
	  }
	  else{
		  Report.updateTestLog("You have ordered Kitchen Appliance Cover  is not displayed", "FAIL"); 
	  }
  }
}
