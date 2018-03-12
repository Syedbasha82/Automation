package bg.framework.app.functional.page.sales;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.GasApplianceCover;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;

import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.page.common.BasePage;
import org.openqa.selenium.support.ui.Select;
import bg.framework.app.functional.action.sales.GasApplianceCoverAction;

import java.util.Properties;

public class GasApplianceCoverPage extends BasePage {
	private final static String FILE_NAME = "resources/sales/GasApplianceCoverPage.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	
	
	public void navigateToGasApplianceCoverPage(){
		   browser.open(ApplicationConfig.APP_BG_URL+"/ViewQuoteDetails/coverGas/");
		   if (browser.isTextPresent("Gas appliance cover"))
		   {
			   Report.updateTestLog("Gas Appliance Cover Page Is present", "PASS");
		   }
		   else
		   {
			   Report.updateTestLog("Gas Appliance Cover Page Is not present", "FAIL");
		   }
	   
	   if (browser.isTextPresent("£9.98"))
		   
	   {
		   Report.updateTestLog("Gas Appliance Cover value for three appliances is present ", "PASS");
	   }
	   else
	   {
		   Report.updateTestLog("Gas Appliance Cover value for three appliances is present", "FAIL");
	   }
	}
	   /*public void navigateToWhatareYourContactDetailsSection(GasApplianceCover  GasAppliance){
		   verifyAndClickWithXpath(pageProperties.getProperty("GAC.Getaquote"), "Get a quote button");
		   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("GAC.Title"),"Title", "Mr");
		   verifyAndInputById(pageProperties.getProperty("GAC.Firstname"), "First name",GasAppliance.getFirstName());
		   verifyAndInputById(pageProperties.getProperty("GAC.LastName"), "Last Name",GasAppliance.getLastName());
		   verifyAndInputById(pageProperties.getProperty("GAC.emailID"), "email ID",GasAppliance.getEmail());
		   verifyAndInputById(pageProperties.getProperty("GAC.Telephonenumber"), "Telephone number",GasAppliance.getPhoneNumber());
		   verifyAndInputById(pageProperties.getProperty("GAC.postCode"), "post Code",GasAppliance.getPostCode());
		   verifyAndClickWithXpath(pageProperties.getProperty("GAC.nextBtn1"), "next Btn 1");
		   
		   
		   
	   }*/
	   public void navigateToWhatareYourContactDetailsSection(){
		   verifyAndClickWithXpath(pageProperties.getProperty("GAC.Getaquote"), "Get a quote button");
		   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("GAC.Title"),"Title", "Mr");
		   verifyAndInputById(pageProperties.getProperty("GAC.Firstname"), "First name","Automation");
		   verifyAndInputById(pageProperties.getProperty("GAC.LastName"), "Last Name","Testing");
		   verifyAndInputById(pageProperties.getProperty("GAC.emailID"), "email ID","automationtestingGAC@bgdigitaltest.co.uk");
		   verifyAndInputById(pageProperties.getProperty("GAC.Telephonenumber"), "Telephone number","0207123456");
		   verifyAndInputById(pageProperties.getProperty("GAC.postCode"), "post Code","tw18 3he");
		   verifyAndClickWithXpath(pageProperties.getProperty("GAC.nextBtn1"), "next Btn 1");
		   
		   
		   
	   }
	   
	   public void navigateToAddAny2ExtrasSection(){
		   verifyAndClickWithXpath(pageProperties.getProperty("GAC.Cover2"),"Cover2" );
		   verifyAndClickWithXpath(pageProperties.getProperty("GAC.nextBtn3"), "next Btn 3");
	   }
	   public void selectNone(){
		   verifyAndClickWithXpath(pageProperties.getProperty("GAC.nextBtn3"), "next Btn 3");
	   }
	   
	   public void navigateToAddAny6ExtrasSection(){
		   verifyAndClickWithXpath(pageProperties.getProperty("GAC.Cover6"),"Cover6" );
		   verifyAndClickWithXpath(pageProperties.getProperty("GAC.nextBtn3"), "next Btn 3");
	   }
	   
	   public void navigateToApplianceSection(){
		   
		   //verifyIsTextPresent("Your cover includes 5 appliances");
		   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("GAC.app1"),"Free standing gas cooker", "1");
		   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("GAC.app2"),"Built in hob", "1");
		   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("GAC.app3"),"Fridge", "1");
		   verifyAndClickWithXpath(pageProperties.getProperty("GAC.nextBtn4"), "next Btn 4");
		   
	   }
	   public void navigateTo6ApplianceSection(){
		   
		   //verifyIsTextPresent("Your cover includes 5 appliances");
		   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("GAC.app1"),"Free standing gas cooker", "2");
		   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("GAC.app2"),"Built in hob", "2");
		   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("GAC.app3"),"Fridge", "2");
		   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("GAC.app4"),"Freezer", "2");
		   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("GAC.app5"),"Dishwasher", "1");
		   verifyAndClickWithXpath(pageProperties.getProperty("GAC.nextBtn4"), "next Btn 4");
		   
	   }
	   public void navigateTo2ApplianceSection(){
		   
		   //verifyIsTextPresent("Your cover includes 5 appliances");
		   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("GAC.app1"),"Free standing gas cooker", "1");
		   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("GAC.app2"),"Built in hob", "1");
		   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("GAC.app3"),"Fridge", "1");
		   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("GAC.app4"),"Freezer", "1");
		   verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("GAC.app5"),"Dishwasher", "1");
		   verifyAndClickWithXpath(pageProperties.getProperty("GAC.nextBtn4"), "next Btn 4");
		   
	   }
	   public void verifyEditLink(){
		   verifyAndClickWithXpath(pageProperties.getProperty("GAC.edit1"), "edit 1");
		   verifyAndClickWithXpath(pageProperties.getProperty("GAC.nextBtn1"), "nextBtn1");
		   verifyAndClickWithXpath(pageProperties.getProperty("GAC.nextBtn3"), "next Btn 3");
		   verifyAndClickWithXpath(pageProperties.getProperty("GAC.edit2"), "edit 2");
		   verifyAndClickWithXpath(pageProperties.getProperty("GAC.nextBtn3"), "next Btn 3");
		   verifyAndClickWithXpath(pageProperties.getProperty("GAC.nextBtn4"), "next Btn 4");
		   verifyAndClickWithXpath(pageProperties.getProperty("GAC.edit3"), "edit 3");
		   verifyAndClickWithXpath(pageProperties.getProperty("GAC.nextBtn4"), "next Btn 4");
		   verifyAndClickWithXpath(pageProperties.getProperty("GAC.GetAQuoteButton"), "Get A Quote Button");
	   }
	  public void verifyOrderNowPage(){
		  /*if(browser.isElementVisibleWithXpath(".//*[@id='monthlyPrice']")){
			  
			 Report.updateTestLog("Monthly Price for extra 2 appliance is present", "PASS") ;
			
		  }
		  else
		  {
			  Report.updateTestLog("Monthly Price for extra 2 appliance is not present", "FAIL") ;
		  }
		  if (browser.isTextVisible("£16.00"))
		  {
			  Report.updateTestLog("Monthly Price for extra 2 appliance is Visible", "PASS");
		  }
		  else
		  {
			  Report.updateTestLog("Monthly Price for extra 2 appliance is not Visible", "Fail");
		  }
		  if(browser.isElementVisibleWithXpath(".//*[@id='yearlyPrice']"))
		  {
			  
			  Report.updateTestLog("Yearly Price for extra 2 appliance is present", "PASS") ;	
		  }
		  else
		  {
			  Report.updateTestLog("Yearly Price for extra 2 appliance is not present", "FAIL") ;
			  }
		  if (browser.isTextVisible("£192.00"))
		  {
			  Report.updateTestLog("Yearly Price for extra 2 appliance is Visible", "PASS");
		  }
		  else
		  {
			  Report.updateTestLog("Yearly Price for extra 2 appliance is not Visible", "Fail");
		  }
		  */
		    verifyAndClickWithXpath(pageProperties.getProperty("GAC.OrderNowButton"),"OrderNowButton" ) ;
		    verifyIsElementVisibleWithLinkText(pageProperties.getProperty("GAC.EditMyQuote"), "Edit My Quote");
		    verifyAndClickWithXpath(pageProperties.getProperty("GAC.StartYourOrderNowButton"),"Start Your Order Now Button" ) ;
		   
	  }
	  
	  public void verifyContactDetailsSection(){
		 
		  verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("GAC.selectoption"),"SelectOption", "TV Advert");
		  verifyAndClickWithXpath(pageProperties.getProperty("GAC.nextBtn1"), "next Btn 1");
		  
	  }
	  public void verifyNectarPointsSection(){
		  verifyAndClickWithXpath(pageProperties.getProperty("GAC.NoThanks"),"No Thanks");
		  verifyAndClickWithXpath(pageProperties.getProperty("GAC.nextBtn3"), "next Btn 3");
	  }
	  
	  public void verifyEnterYourAddressSection(){
		  
		  browser.dynamicWaituntilVisiblebyXpath(".//*[@id='serviceAddressList1']");
		  /*//verifyAndClickWithXpath(pageProperties.getProperty("GAC.search"), "Search button");
		  //verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("GAC.SelectAddress"),"Select Address" , "0");
		  browser.selectfromDropBoxByXpath(".//*[@id='serviceAddressList1']", "1, Meadow Gardens, STAINES-UPON-THAMES, Middlesex, TW18 3HE");
		  if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GAC.SelectAddress"))){
			    Select select = new Select(browser.getElementByXpath(pageProperties.getProperty("GAC.SelectAddress")));
				select.selectByIndex(1);
				Report.updateTestLog("Address Selected from Dropdown", "Pass");
			}
			else{
				Report.updateTestLog("Address not getting populated from Dropdown", "Fail");
			}	*/
		  browser.selectfromDropBoxByXpath(".//*[@id='serviceAddressList1']", "1, Meadow Gardens, STAINES-UPON-THAMES, Middlesex, TW18 3HE");
		  verifyAndClickWithXpath(pageProperties.getProperty("GAC.nextBtn4"), "next Btn 4");
		  	  	
	  }
	  
	  public void verifyEnterPaymentDetails(){
		  
		  verifyAndClickWithXpath(pageProperties.getProperty("GAC.MonthlyFixedDirectDebit"), "Monthly Fixed Direct Debit");
		  
		  verifyAndInputByXpath(pageProperties.getProperty("GAC.BanGACcountNumber"), "Bank account number ", "11049151");
		  //verifyAndInputByXpath(pageProperties.getProperty("GAC.BanGACcountNumber"), "Bank account number ", acquisition.getPaymentAccountNumber());
			verifyAndInputByXpath(pageProperties.getProperty("GAC.SortCode1"), "SortCode 1 ", "40");
			verifyAndInputByXpath(pageProperties.getProperty("GAC.SortCode2"), "SortCode 2 ", "02");
			verifyAndInputByXpath(pageProperties.getProperty("GAC.SortCode3"), "SortCode 3 ", "50");
			verifyAndInputByXpath(pageProperties.getProperty("GAC.AccountHolderName"), "AccountHolderName ", "automation");
			verifyAndSelectDropDownBox(pageProperties.getProperty("GAC.PaymentDate"), "Payment date ","5th");
			verifyAndClickWithXpath(pageProperties.getProperty("GAC.nextBtn5"), "next Btn 5");
	  }
	  public void verifyTermsAndConditions(){
		  
		  verifyAndClickWithXpath(pageProperties.getProperty("GAC.orderTerms"), "Order Terms");
		  verifyAndClickWithXpath(pageProperties.getProperty("GAC.AssumptionTerms"), "Assumption Terms");
		  checkMarketingConsent();
		  verifyAndClickWithXpath(pageProperties.getProperty("GAC.PlaceOrder"), "Place Order");
	  }
	  public void checkMarketingConsent(){
		  verifyAndClickWithXpath(pageProperties.getProperty("GAC.Mail"), "Mail");
		  verifyAndClickWithXpath(pageProperties.getProperty("GAC.Email"), "Email");
		  verifyAndClickWithXpath(pageProperties.getProperty("GAC.Landline"), "Landline");
		  verifyAndClickWithXpath(pageProperties.getProperty("GAC.Mobile"), "Mobile");
		  verifyAndClickWithXpath(pageProperties.getProperty("GAC.Text"), "Text");
	  }
	  public void verifyThankYouPage(){
		  if(browser.isTextPresent("Thank you for your order")){
			  Report.updateTestLog("Thank you page is displayed", "PASS");
			 
		  }
		  else{
			  Report.updateTestLog("Thank you page is not displayed", "FAIL"); 
		  }
		  if(browser.isTextPresent("You have ordered Gas Appliance Cover")){
			  Report.updateTestLog("You have ordered Gas Appliance Cover  is displayed", "PASS");
			 
		  }
		  else{
			  Report.updateTestLog("You have ordered Gas Appliance Cover  is not displayed", "FAIL"); 
		  }
	  }
	

}
