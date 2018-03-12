package bg.framework.app.functional.page.Slingshot;

import java.util.ArrayList;
import java.util.Properties;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class QuoteAndSalesPage extends BasePage{
	private final static String FILE_NAME = "resources/Slingshot/GuoteAndSalesPage.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	
	public void openGuotePage(String contractType){
		browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("GetAQuotePage.GetAQuoteLink"));
		Report.updateTestLog("Get a quote landing page displayed as expected",browser.getTitle().equalsIgnoreCase("Get a quote")?"PASS":"FAIL");
		verifyAndClickWithXpath(pageProperties.getProperty("GetAQuoteAndSalesGasLink")+contractType, "Get a quote link");
		Report.updateTestLog("Get a quote gas landing page displayed as expected",browser.getTitle().equalsIgnoreCase("Get a quote - Gas")?"PASS":"FAIL");
	}
	public void enterYourContactDetailsPage(UserProfile userProfile){
		verifyAndSelectDropDownBox(pageProperties.getProperty("GetAQuotePage.Title"), "Title", userProfile.getTitle());
		verifyAndInputById(pageProperties.getProperty("GetAQuotePage.FirstName"), "First name", userProfile.getFirstName());
		verifyAndInputById(pageProperties.getProperty("GetAQuotePage.SurName"), "Sur name", userProfile.getLastName());
		verifyAndInputById(pageProperties.getProperty("GetAQuotePage.BusinessName"), "Business name", userProfile.getCompanyName());
		verifyAndInputById(pageProperties.getProperty("GetAQuotePage.Email"), "Email address", userProfile.getEmail());
		verifyAndInputById(pageProperties.getProperty("GetAQuotePage.TelephoneNumber"), "Telephone number", userProfile.getPhoneNumber());
	}
	public void clickNextButton(){
		verifyAndClickWithXpath(pageProperties.getProperty("GetAQuotePage.NextButton"), "Next button");
	}
	public void addSiteDetails(UserProfile userProfile){
		verifyAndInputById(pageProperties.getProperty("GetAQuotePage.BuildingName"), "Building name", userProfile.getCompanyName());
		verifyAndInputById(pageProperties.getProperty("GetAQuotePage.PostCode"), "Post code", userProfile.getPostCode());
		verifyAndClick(pageProperties.getProperty("GetAQuotePage.SearchButton"), "Search button");	
		verifyAndSelectCheckBox(pageProperties.getProperty("GetAQuotePage.YesButton"), "Yes");
		verifyAndInputById(pageProperties.getProperty("GetAQuotePage.Consumption"), "Consumption", "1000");
		verifyAndSelectDropDownBox(pageProperties.getProperty("GetAQuotePage.ConsumptionPeriod"), "Consumption period","Monthly");
	}
	public void selectGasInContract(String contract){
		if(contract.equalsIgnoreCase("Yes")){
			verifyAndClickWithXpath(pageProperties.getProperty("GetAQuotePage.GasContractYesOption"), "Gas contract-Yes");
		}
		else{
			verifyAndClickWithXpath(pageProperties.getProperty("GetAQuotePage.GasContractNoOption"), "Gas contract-No");
		}
		//GAS - 38 days from current date - 119 days from current date
		//Elec - 21 days from current date - 119 days from current date
		verifyAndInputWithName(pageProperties.getProperty("GetAQuotePage.ContractEndDate"), "End Date", "");
		verifyAndInputWithName(pageProperties.getProperty("GetAQuotePage.ContractStartDate"), "Start Date", "");
	}
	public void verifyConsumptionUnknown(){
		int flg=0;
		//String[] averageConsumption=null;
		//Electricity consumption values
	//	if(contract.equalsIgnoreCase("Elec")){
			String[] averageConsumption = {"£0 - £1,199","£1,200 - £3,799","£3,800 - £8,199","£8,200 - £28,000","More than £28,000"};
		//}
		//else{
			//Gas consumption values
			String[] averageConsumption1 = {"£0 - £1,199","£1,200 - £3,799","£3,800 - £8,199","£8,200 - £28,000","More than £28,000"};
			
		//}
		ArrayList<String> actualConsumption = browser.getFromDropBox("id", pageProperties.getProperty("GetAQuotePage.ConsumptionValues"));
	
		for(int i=0; i<averageConsumption.length;i++){
			if(actualConsumption.get(i).trim().equalsIgnoreCase(averageConsumption[i].trim())){
				flg= flg+1;
			}
			else{
				Report.updateTestLog("Expected consumption is not present.Actual:"+actualConsumption+"Expected:"+averageConsumption, "FAIL");
			}
			if(flg==5){
				Report.updateTestLog("Expected consumption is present.Actual:"+actualConsumption+"Expected:"+averageConsumption, "FAIL");

			}
		}
	}
	public void enterUnknownConsumption(){
		verifyAndSelectDropDownBox(pageProperties.getProperty("GetAQuotePage.Consumptionrange"), "Unknown consumption", "£0 - £1,199");
		verifyAndSelectDropDownBox(pageProperties.getProperty("GetAQuotePage.ConsumptionPeriod"), "Consumption period", "Month");
		verifyAndClickWithXpath(pageProperties.getProperty("GetAQuotePage.SaveSiteDetails"), "Save site details");
	}
	public void verifyLargeBusinessConfirmation(){
		verifyAndClickWithXpath(pageProperties.getProperty("GetAQuotePage.largeBusinessConfirmation"), "Large business confirmation");
		if(browser.getTitle().equalsIgnoreCase("Thank You")){
			Report.updateTestLog("Thank you page displayed for large business consumption", "PASS");
		}
		else{
			Report.updateTestLog("Thank you page displayed for large business consumption", "FAIL");
	
		}
	}
	public void verifyOffLineQuote(){
		if(browser.isTextPresent("We're unable to provide you with an online quote at this time.")){
			Report.updateTestLog("Qet quote is not able to proceed in online bcoz of MPAN/MPRN mismatches", "PASS");
		}
		else{
			Report.updateTestLog("Qet quote is not able to proceed in online bcoz of MPAN/MPRN mismatches", "FAIL");

		}
	}
	public void verifyBadDataMatch(){
		if(browser.isTextPresent("We're unable to provide you with an online quote at this time")){
			Report.updateTestLog("Qet quote is not able to proceed in online as its already started by offline", "PASS");
		}
		else{
			Report.updateTestLog("Qet quote is not able to proceed in online as its already started by offline", "FAIL");

		}
	}
	public void verifyEmailAddressMatches(){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAQuotePage.LoginPage"))){
			Report.updateTestLog("Login page displayed for email matches", "PASS");
			verifyAndClickWithXpath(pageProperties.getProperty("GetAQuotePage.LoginLink"), "Login link");
		}
		else{
			Report.updateTestLog("Login page displayed for email matches", "FAIL");

		}
	}
	public void verifyAddSiteDetailsUpto15(UserProfile userProfile){
		int flg=0;
		for(int i=0; i<15;i++){
			addSiteDetails(userProfile);
			flg=flg+1;
		}
		
		Report.updateTestLog("Upto 15 site address added", (flg==15)?"PASS":"FAIL");
	}
	
	public void clickGetAQuoteLink(){
		verifyAndClickWithXpath(pageProperties.getProperty("GetAQuotePage.QetAQuoteLink"), "Get a quote link");
	}
	public String verifyQuoteSummaryPage(){
		String quoteRefNumber=null;
		if(browser.getTitle().equalsIgnoreCase("Quote summary")){
			Report.updateTestLog("Quote summary page displayed as expected.", "PASS");
			String yearOfContract = browser.getTextByXpath(pageProperties.getProperty("GetAQuotePage.ContractYear"));
			quoteRefNumber = browser.getTextByXpath(pageProperties.getProperty("GetAQuotePage.QuoteRefNumber"));
			Report.updateTestLog("Quote summary page displayed with "+yearOfContract+" and reference number:"+quoteRefNumber, "PASS");

		}
		else{
			Report.updateTestLog("Quote summary page displayed as expected."+browser.getTitle(), "FAIL");

		}
		return quoteRefNumber;
	}
	public void clickSaveQuote(){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAQuotePage.SaveQuoteLink"))){
			verifyAndClickWithXpath(pageProperties.getProperty("GetAQuotePage.SaveQuoteLink"), "Save quote link");
			verifyAndClickWithXpath(pageProperties.getProperty("GetAQuotePage.SaveQuoteOverlay"), "Quote saved overlay- close button");
		}
	}
	public void verifyAuditsForQuote(UserProfile userProfile){
		OnlineDBConnector dbFunctions = new OnlineDBConnector();
		String date=dbFunctions.DBsysdateDdmmyyhhmi();
		String[] auditType = dbFunctions.getAuditEventTypeId(date, userProfile.getEmail(),"Quote success");
		String data = dbFunctions.getAuditType(auditType[0]);	
		Report.updateTestLog("Successfully Email Sent to Customer And Audit id is made in audit table as expected. Audit id: "+auditType[0]+ " Audit event type is"+data, data.equalsIgnoreCase("BGBUSINESS_ANONYMOUS_POST_SMR_SUCCESS")?"PASS":"FAIL");
		
	}
	public void retriveQetAQuoteForLoggedIn(String quoteNumber,UserProfile userProfile){
		verifyAndClickWithXpath(pageProperties.getProperty("GetAQuotePage.GetAQuoteLinkInAccountSummary"), " Get a quote link in account summary page");
		if(browser.isTextPresent("Retrive a quote")){
			verifyAndInputById(pageProperties.getProperty("GetAQuotePage.QuoteRefNumber"), "Quote ref number", quoteNumber);
			verifyAndInputById(pageProperties.getProperty("GetAQuotePage.EmailAddress"), "Quote Email address", userProfile.getEmail());
			verifyAndClick(pageProperties.getProperty("GetAQuotePage.RetriveMyQuote"), "Retrive My Quote link");
		}
	}
}
