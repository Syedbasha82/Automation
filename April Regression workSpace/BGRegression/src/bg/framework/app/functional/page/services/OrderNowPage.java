package bg.framework.app.functional.page.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import com.gargoylesoftware.htmlunit.Page;
import com.jcraft.jsch.JSchException;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.LandLord;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SshClient;

public class OrderNowPage extends BasePage {
	private final static String FILE_NAME="resources/services/OrderNowPage.properties";
	private static Properties pageProperties=new PropertyLoader(FILE_NAME).load();
	private LandLord landLord;
	private static String orderDate;
	public OrderNowPage(){
		
	}
	public OrderNowPage(LandLord landLord) {
		this.landLord=landLord;
	}
	
	public void verifyOrderNowPage(){
		browser.wait(2000);
		verifyIsTextPresent("Order Now");
	}
	
	public void enterContactSection(){		
		System.out.println(landLord.getPostCode());
		enterContactUs(landLord.getTitle(),landLord.getfName(),landLord.getSurName(),
				 landLord.getCompanyName(),landLord.getEmail(),landLord.getTelephone(),landLord.getMobile(),
				 landLord.getHouseNumber(),landLord.getPostCode());
	}
	
	public void contactUsPerpolutatedCheck(){
		
		String fName=browser.getAttribute(pageProperties.getProperty("OrderNow.firstNameText"),"value");
		String lname=browser.getAttribute(pageProperties.getProperty("OrderNow.surNameText"),"value");
		String telephone=browser.getAttribute(pageProperties.getProperty("OrderNow.telephoneText"),"value");
		String email=browser.getAttribute(pageProperties.getProperty("OrderNow.emailText"),"value");		
			
			if(fName.equalsIgnoreCase(landLord.getfName())){
				Report.updateTestLog("First name "+ fName, "PASS");
			}else{
				Report.updateTestLog("First name not perpopulatated"+ fName, "FAIL");			
			}
			if(lname.equalsIgnoreCase(landLord.getSurName())){
				Report.updateTestLog("Surname "+ lname, "PASS");
			}else{
				Report.updateTestLog("Surname not "+ lname+" perpopulatated", "FAIL");			
			}
			if(telephone.equalsIgnoreCase(landLord.getTelephone())){
				Report.updateTestLog("Telephone "+telephone, "PASS");
			}else{
				Report.updateTestLog("Telephone "+telephone +" not perpopulatated", "FAIL");			
			}
			if(email.equalsIgnoreCase(landLord.getEmail())){
				Report.updateTestLog("Email "+email, "PASS");
			}else{
				Report.updateTestLog("Email "+email +" not perpopulatated", "FAIL");			
			}
	}
	
	public void contactUsErrorVerification(){		
		String fName[]={"","","Anna","Anna","%^^","Anna"};
		String surName[]={"","April","","April","","April"};		
		String email[]={"","Anna@bg.com","","Anna@bg.com","Annabg.com","8766"};
		String telephone[]={"","023651478952","023651478952","","023651478952","023651478952"};		
		String hno[]={"","1","","","","1"};	
		String contactErrorProperty="OrderNow.contactUsErrorBox";
		for(int i=0;i<fName.length;i++){
		enterContactUs(landLord.getTitle(), fName[i], surName[i], landLord.getCompanyName(), email[i], telephone[i], 
				landLord.getMobile(), hno[i], landLord.getPostCode());
		clickSearchButton();
		selectAddress(1);
		clickNextButton();
		verifyErrorMessage(contactErrorProperty);
		}
		enterContactUs(landLord.getTitle(), fName[2], surName[3], landLord.getCompanyName(), email[1], telephone[1], 
				landLord.getMobile(), hno[1], "");		
		clickSearchButton();
		verifyErrorMessage(contactErrorProperty);
		verifyAndInputById(pageProperties.getProperty("OrderNow.postCodeText"), "Post code", landLord.getPostCode());
		clickSearchButton();
		verifyAndClickWithXpath(pageProperties.getProperty("OrderNow.addressLink"), "Enter your address Link");
		clickNextButton();
		verifyErrorMessage(contactErrorProperty);
		yourAddressErrorVerification();
	}
	public void yourAddressErrorVerification(){
		String contactErrorProperty="OrderNow.contactUsErrorBox";
		String houseNo[]={"","1","1","1"};
		String address[]={"Meadows","","Meadows","Meadows"};	
		String postalTown[]={"Stains","Stains","","Stains"};
		String postCode[]={"tw16 3he","tw16 3he","tw16 3he",""};
		for(int i=0;i<houseNo.length;i++){
			enterYourContact(houseNo[i],address[i],postalTown[i],postCode[i]);
			clickNextButton();
			verifyErrorMessage(contactErrorProperty);
		}
	}
	private void enterYourContact(String houseNo,String address,String postalTown,String postCode){	
		verifyAndInputById(pageProperties.getProperty("OrderNow.yourHouseText"), "House number",houseNo);
		verifyAndInputById(pageProperties.getProperty("OrderNow.yourAddressText"), "Address", address);
		verifyAndInputById(pageProperties.getProperty("OrderNow.yourPostalText"), "Postal town", postalTown);
		verifyAndInputById(pageProperties.getProperty("OrderNow..yourPostcodeText"), "Post code", postCode);
		verifyAndSelectDropDownBox(pageProperties.getProperty("OrderNow.country"), "Country", "United Kingdom");
	}
	
	public void contactUsEditVerification(){
		enterContactUs(landLord.getTitle(),landLord.getfName(),landLord.getSurName(),
				 landLord.getCompanyName(),landLord.getEmail(),landLord.getTelephone(),landLord.getMobile(),
				 landLord.getHouseNumber(),landLord.getPostCode());
		clickSearchButton();
		selectAddress(1);
		clickNextButton();
		verifyAndClick(pageProperties.getProperty("OrderNow.editLink"), "Edit Link");
		enterContactUs(landLord.getTitle(),landLord.getfName(),landLord.getSurName(),
				 landLord.getCompanyName(),landLord.getEmail(),landLord.getTelephone(),landLord.getMobile(),
				 landLord.getHouseNumber(),landLord.getPostCode());
		clickSearchButton();
		selectAddress(1);
		clickNextButton();
		verifyAndClickWithXpath(pageProperties.getProperty("OrderNow.backToQuateLink"), "Back to quote survey");
	}
	
	private void verifyErrorMessage(String property){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty(property))){
			String pageError=browser.getTextByXpath(pageProperties.getProperty(property));
			String res=new ErrorMessage().e(pageError);
			if(res.equals("N")){
				Report.updateTestLog("Error message displayed in the application was incorrect", "FAIL");
			}else{
				Report.updateTestLog("Error message<b> "+res+" </b>displayed in the application", "PASS");
			}
		}else{
			Report.updateTestLog("Error message not box displayed", "FAIL");
		}
	}
	
	private void enterContactUs(String title,String fName,String surName,String company,String email,
			String telephone,String mobile,String hno,String postcode){
		verifyAndSelectDropDownBox(pageProperties.getProperty("OrderNow.titleSelect"), "Title", title);	
		verifyAndInputById(pageProperties.getProperty("OrderNow.firstNameText"), "First name",fName);
		verifyAndInputById(pageProperties.getProperty("OrderNow.surNameText"), "Surname", surName);
		verifyAndInputById(pageProperties.getProperty("OrderNow.companyNameText"), "Company Name", company);
		verifyAndInputById(pageProperties.getProperty("OrderNow.emailText"), "Email", email);
		verifyAndInputById(pageProperties.getProperty("OrderNow.telephoneText"), "Telephone Number",telephone);
		verifyAndInputById(pageProperties.getProperty("OrderNow.mobileText"), "Mobile Number", mobile);
		verifyAndInputById(pageProperties.getProperty("OrderNow.houseText"), "House Number", hno);
		verifyAndInputById(pageProperties.getProperty("OrderNow.postCodeText"), "Postcode",postcode );				
	}
	public void clickSearchButton(){
		verifyAndClick(pageProperties.getProperty("OrderNow.searchButton"), "Search Button");
		browser.wait(10000);
	}
	
	public void selectAddress(int count){
	int searchCount=browser.getChildElementsCountByXpath(pageProperties.getProperty("OrderNow.addressCount"));
	System.out.println("Entries "+searchCount);
		if(searchCount>=1){
			Report.updateTestLog("Address is displayed in list box", "PASS");
			String value=browser.getTextByXpath(pageProperties.getProperty("OrderNow.addressCount")+"["+(count+1)+"]");
			verifyAndSelectDropDownBox(pageProperties.getProperty("OrderNow.addressList"), "Address", value);										
		}
		else{
			Report.updateTestLog("Address is not displayed in list box", "FAIL");
		}
	}
	
	public void clickNextButton(){
		verifyAndClick(pageProperties.getProperty("OrderNow.nextButton"), "Next button");
		//browser.clickWithXpath(".//*[@id='KnowBoilerTypeButton']");
	}
	
	public void clickCP12DirectDebit(){
		verifyAndClick(pageProperties.getProperty("OrderNow.DirectDebit"), "Direct Debit Radio Button");
	}
	
	public void clickCP12CreditDebit(){
		verifyAndClick(pageProperties.getProperty("OrderNow.CreditDebit"), "Credit Debit Radio Button");
	}
	
	public void clickHCMonthlyDebit(){
		verifyAndClick(pageProperties.getProperty("OrderNow.hcMonthlyDirect"), "Monthly Debit Radio Button");
	}
	
	public void clickHCAnualDebit(){
		verifyAndClick(pageProperties.getProperty("OrderNow.hcAnnualDirect"), "Annual Debit Radio Button");
	}
	public void clickHCAnnualCredit(){
		verifyAndClick(pageProperties.getProperty("OrderNow.hcAnnualCredit"), "Credit Debit Radio Button");
	}
	
	private void enterDebitCardDetails(String accountNumber,String sort1,String sort2,String sort3,String name){
		ArrayList<String> property=setProperty();
		System.out.println(property.get(1));
		verifyAndInputById(pageProperties.getProperty(property.get(0)), "Account Number",accountNumber);
		verifyAndInputById(pageProperties.getProperty(property.get(1)), "Sort code1", sort1);
		verifyAndInputById(pageProperties.getProperty(property.get(2)), "Sort code2", sort2);
		verifyAndInputById(pageProperties.getProperty(property.get(3)), "Sort code3", sort3);
		verifyAndInputById(pageProperties.getProperty(property.get(4)), "Name", name);
	}
	
	private void enterCreditCardDetails(String cType,String name,String cNumber,String startMon,String startYear
			,String endMon,String endYear,String issueNo){
		/*ArrayList<String> property=setProperty();
		verifyAndSelectDropDownBox(pageProperties.getProperty(property.get(0)), "Card type",cType );
		verifyAndInputById(pageProperties.getProperty(property.get(1)), "Name as in card",name );
		verifyAndInputById(pageProperties.getProperty(property.get(2)), "Card number",cNumber);
		verifyAndSelectDropDownBox(pageProperties.getProperty(property.get(3)), "Card start month",startMon );
		verifyAndSelectDropDownBox(pageProperties.getProperty(property.get(4)), "Card start year", startYear);
		verifyAndSelectDropDownBox(pageProperties.getProperty(property.get(5)), "Card expiry month", endMon);
		verifyAndSelectDropDownBox(pageProperties.getProperty(property.get(6)), "Card expiry year", endYear);
		if(browser.isElementVisible(pageProperties.getProperty(property.get(7)))){
			verifyAndInputById(pageProperties.getProperty(property.get(7)), "Issue Number",issueNo );
		}
		 */
		//Enter the Direct Debit Details
		browser.wait(5000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("OrderNow.CreditNext"))){
			Report.updateTestLog("Error message displayed for credit transactions", "Pass");
			verifyAndClick(pageProperties.getProperty("OrderNow.hcMonthlyDirect"), "Direct debit button");
			enterDebitCardDetails(landLord.getAccountNumber(), landLord.getSortCode1(), landLord.getSortCode2(), landLord.getSortCode3(), landLord.getfName());
		}
		else{
			Report.updateTestLog("Error Message not displayed", "Fail");
		}
	}
	
	public void enterStandAloneDebitDetail(){		
		enterDebitCardDetails(landLord.getAccountNumber(), landLord.getSortCode1(), landLord.getSortCode2(), landLord.getSortCode3(), landLord.getfName());
	}
	
	public void enterPayForHomeAnnualDebitDetail(){
		enterDebitCardDetails(landLord.getAccountNumber(), landLord.getSortCode1(), landLord.getSortCode2(), landLord.getSortCode3(), landLord.getfName());		
	}
	
	public void enterPayForHomeDebitDetail(){
		enterDebitCardDetails(landLord.getAccountNumber(), landLord.getSortCode1(), landLord.getSortCode2(), landLord.getSortCode3(), landLord.getfName());
		if(browser.isElementVisible(pageProperties.getProperty("OrderNow.hcMonthlyPayList"))){
			verifyAndSelectDropDownBox(pageProperties.getProperty("OrderNow.hcMonthlyPayList"), "Payment day of month", landLord.getPayDate());
		}
	}
	
	public void enterStandAloneCreditDetail(){	
		enterCreditCardDetails(landLord.getCardType(), landLord.getfName(), landLord.getCardNumber(),
				landLord.getCardStartMonth(), landLord.getCardStartYear(), landLord.getCardExpiryMonth(), landLord.getCardExpiryYear(), landLord.getIssueNumber());
	}
	
	public void enterPayForHomeCreditDetail(){	
		enterCreditCardDetails(landLord.getCardType(), landLord.getfName(), landLord.getCardNumber(),
		landLord.getCardStartMonth(), landLord.getCardStartYear(), landLord.getCardExpiryMonth(), landLord.getCardExpiryYear(), landLord.getIssueNumber());
	}		
	
	private ArrayList<String> setProperty(){
	
		if(browser.isSelected(pageProperties.getProperty("OrderNow.DirectDebit")) 
				&& browser.isElementVisible(pageProperties.getProperty("OrderNow.DirectDebit"))){
			ArrayList<String> property=new ArrayList<String>();
			property.add("OrderNow.accountNumberText");
			property.add("OrderNow.sortCode1Text");
			property.add("OrderNow.sortCode2Text");
			property.add("OrderNow.sortCode3Text");
			property.add("OrderNow.accHolderNameText");
		return property;
		}
		
		if(browser.isSelected(pageProperties.getProperty("OrderNow.hcMonthlyDirect"))
				&& browser.isElementVisible(pageProperties.getProperty("OrderNow.hcMonthlyDirect"))){
			ArrayList<String> propertyHCMonth=new ArrayList<String>();
			propertyHCMonth.add("OrderNow.hcAccountNumberText");
			propertyHCMonth.add("OrderNow.hcSortCode1Text");
			propertyHCMonth.add("OrderNow.hcSortCode2Text");
			propertyHCMonth.add("OrderNow.hcSortCode3Text");
			propertyHCMonth.add("OrderNow.hcaccHolderNameText");
			return propertyHCMonth;
		}
		
		if(browser.isSelected(pageProperties.getProperty("OrderNow.hcAnnualDirect"))
				&& browser.isElementVisible(pageProperties.getProperty("OrderNow.hcAnnualDirect"))){
			ArrayList<String> propertyHCAnnual=new ArrayList<String>();
			propertyHCAnnual.add("OrderNow.hcAccountNumberAnnualText");
			propertyHCAnnual.add("OrderNow.hcSortCode1AnnualText");
			propertyHCAnnual.add("OrderNow.hcSortCode2AnnualText");
			propertyHCAnnual.add("OrderNow.hcSortCode3AnnualText");
			propertyHCAnnual.add("OrderNow.hcaccHolderNameAnnualText");
			return propertyHCAnnual;
		}
		if(browser.isSelected(pageProperties.getProperty("OrderNow.CreditDebit"))
				&& browser.isElementVisible(pageProperties.getProperty("OrderNow.CreditDebit"))){
			ArrayList<String> propertyCPCredit=new ArrayList<String>();
			propertyCPCredit.add("OrderNow.cardTypeList");
			propertyCPCredit.add("OrderNow.creditAccNameText");
			propertyCPCredit.add("OrderNow.creditNumberText");
			propertyCPCredit.add("OrderNow.creditStartMonthList");
			propertyCPCredit.add("OrderNow.creditStartYearList");
			propertyCPCredit.add("OrderNow.creditExpiryMonthList");
			propertyCPCredit.add("OrderNow.creditExpiryYearList");
			propertyCPCredit.add("OrderNow.issueNumberText"); 
			return propertyCPCredit;
		
		}
		if(browser.isSelected(pageProperties.getProperty("OrderNow.hcAnnualCredit"))
				&& browser.isElementVisible(pageProperties.getProperty("OrderNow.hcAnnualCredit"))){
			ArrayList<String> propertyHCCreditAnnual=new ArrayList<String>();
			propertyHCCreditAnnual.add("OrderNow.hcCardTypeList");
			propertyHCCreditAnnual.add("OrderNow.hcCreditAccNameText");
			propertyHCCreditAnnual.add("OrderNow.hcCreditNumberText");
			propertyHCCreditAnnual.add("OrderNow.hcCreditStartMonthList");
			propertyHCCreditAnnual.add("OrderNow.hcCreditStartYearList");
			propertyHCCreditAnnual.add("OrderNow.hcCreditExpiryMonthList");
			propertyHCCreditAnnual.add("OrderNow.hcCreditExpiryYearList");
			propertyHCCreditAnnual.add("OrderNow.hcIssueNumberText");
			return propertyHCCreditAnnual;
		}
		return null;
	}				
	
	public void verifyPopulatedPrice(ArrayList<Object> price){
		
		System.out.println("Price one-"+price.get(0)+" Price mon-"+price.get(1));
		if(browser.isElementVisible(pageProperties.getProperty("OrderNow.cp12DebitPrice"))){			
			populatedPrice("OrderNow.cp12DebitPrice", Float.parseFloat(price.get(0).toString()));	
		}else if(browser.isElementVisible(pageProperties.getProperty("OrderNow.cp12CreditPrice"))){			
			populatedPrice("OrderNow.cp12CreditPrice", Float.parseFloat(price.get(0).toString()));			
		}else if(browser.isElementVisible(pageProperties.getProperty("OrderNow.hcMonthlyDebitPrice"))){				
			populatedPrice("OrderNow.hcMonthlyDebitPrice", Float.parseFloat(price.get(1).toString()));	
		}else if(browser.isElementVisible(pageProperties.getProperty("OrderNow.hcAnnualDebitPrice"))){
			populatedPrice("OrderNow.hcAnnualDebitPrice", Float.parseFloat(price.get(2).toString()));	
		}else if(browser.isElementVisible(pageProperties.getProperty("OrderNow.hcAnnualCreditPrice"))){
			populatedPrice("OrderNow.hcAnnualCreditPrice", Float.parseFloat(price.get(3).toString()));	
		}
	}
	private void populatedPrice(String property,float price){
		if(browser.getText(pageProperties.getProperty(property)).contains(""+price)){
			Report.updateTestLog("Get a quote price "+ price +" is displayed", "PASS");
		}
		else{
			Report.updateTestLog("Get a quote price "+ price +" is not displayed", "FAIL");
		}
	}
	
	public void clickStandAloneNextButton(){
		//verifyAndClick(pageProperties.getProperty("OrderNow.standAloneNextButton"), "Next button in stand alone section");
		verifyAndClickWithXpath(pageProperties.getProperty("OrderNow.CreditNext"), "Next button in stand alone section");
	}
	public void clickPayNextButton(){
		verifyAndClick(pageProperties.getProperty("OrderNow.payButton"), "Next button in pay for package");
	}
	
	public void clickCP12TermsCondition(){
		
		if(browser.isElementVisible(pageProperties.getProperty("OrderNow.gasTerms"))){
			verifyAndClick(pageProperties.getProperty("OrderNow.gasTerms"), "Gas CP12 Terms & Condition");
			}
			if(browser.isElementVisible(pageProperties.getProperty("OrderNow.homecareTerms"))){
				verifyAndClick(pageProperties.getProperty("OrderNow.homecareTerms"),"Home care terms & condition");
			}
			if(browser.isElementVisible(pageProperties.getProperty("OrderNow.boilerTerms1"))){
				verifyAndClick(pageProperties.getProperty("OrderNow.boilerTerms1"),"Boiler terms1 & condition");
			}
			if(browser.isElementVisible(pageProperties.getProperty("OrderNow.boilerTerms2"))){
				verifyAndClick(pageProperties.getProperty("OrderNow.boilerTerms2"),"Boiler terms2 & condition");
			}
			if(browser.isElementVisible(pageProperties.getProperty("OrderNow.boilerTerms3"))){
				verifyAndClick(pageProperties.getProperty("OrderNow.boilerTerms3"),"Boiler terms3 & condition");
			}
			if(browser.isElementVisible(pageProperties.getProperty("OrderNow.boilerTerms4"))){
				verifyAndClick(pageProperties.getProperty("OrderNow.boilerTerms4"),"Boiler terms4 & condition");
			}
		

		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("OrderNow.AssumptionTerms"))){
			verifyAndClickWithXpath(pageProperties.getProperty("OrderNow.AssumptionTerms"), "Assumption Terms and conditions");
		}
		
		
	}

	
	public void optOutCheck(){
		if(browser.isSelected(pageProperties.getProperty("OrderNow.contactTerms"))){
			Report.updateTestLog("Check box already selected", "PASS");
		}else{
			Report.updateTestLog("Check box is npt selected selected", "FAIL");
		}
	}
	
	public void verifyDebitCardError(){
		String errorProperty="";
		if(browser.isSelected(pageProperties.getProperty("OrderNow.DirectDebit"))){
		errorProperty="OrderNow.standAloneErrorBox";
		}else {
			errorProperty="OrderNow.payForPackErrorBox";
		}
		String accountNumber[]={"",landLord.getAccountNumber(),landLord.getAccountNumber(),landLord.getAccountNumber(),landLord.getAccountNumber()
				,"#$^@",landLord.getAccountNumber(),landLord.getAccountNumber(),landLord.getAccountNumber(),landLord.getAccountNumber(),"00003555"};
		String sortNumber1[]={landLord.getSortCode1(),"",landLord.getSortCode1(),landLord.getSortCode1(),landLord.getSortCode1()
				,landLord.getSortCode1(),"@#*&^",landLord.getSortCode1(),landLord.getSortCode1(),landLord.getSortCode1(),landLord.getSortCode1()};
		String sortNumber2[]={landLord.getSortCode2(),landLord.getSortCode2(),"",landLord.getSortCode2(),landLord.getSortCode2()
				,landLord.getSortCode2(),landLord.getSortCode2(),"(&^$*",landLord.getSortCode2(),landLord.getSortCode2(),landLord.getSortCode2()};
		String sortNumber3[]={landLord.getSortCode3(),landLord.getSortCode3(),landLord.getSortCode3(),"",landLord.getSortCode3()
				,landLord.getSortCode2(),landLord.getSortCode2(),landLord.getSortCode2(),"*^&^%",landLord.getSortCode2(),landLord.getSortCode2()};
		String accountName[]={landLord.getfName(),landLord.getfName(),landLord.getfName(),landLord.getfName(),""
				,landLord.getfName(),landLord.getfName(),landLord.getfName(),landLord.getfName(),"(&*^$",landLord.getfName()};
		for(int i=0;i<accountNumber.length;i++){
			enterDebitCardDetails(accountNumber[i], sortNumber1[i], sortNumber2[i], sortNumber3[i], accountName[i]);			
			if(browser.isSelected(pageProperties.getProperty("OrderNow.DirectDebit"))){
				clickStandAloneNextButton();
				}else {
				clickPayNextButton();
			}
			verifyErrorMessage(errorProperty);
			if(browser.isElementVisible(pageProperties.getProperty("OrderNow.packageEditLink"))){
				browser.click(pageProperties.getProperty("OrderNow.packageEditLink"));
			}else if(browser.isElementVisible(pageProperties.getProperty("OrderNow.standAloneEditLink"))){
				browser.click(pageProperties.getProperty("OrderNow.standAloneEditLink"));
			}
		}		
	}
	
	public void verifyCreditCardError(){
		String errorProperty="";
		if(browser.isSelected(pageProperties.getProperty("OrderNow.CreditDebit"))){
		errorProperty="OrderNow.standAloneErrorBox";
		}else {
			errorProperty="OrderNow.payForPackErrorBox";
		}
		String cType[]={"Please select",landLord.getCardType(),landLord.getCardType(),landLord.getCardType(),landLord.getCardType()
				,landLord.getCardType()};
		String name[]={landLord.getfName(),"",landLord.getfName(),landLord.getfName(),landLord.getfName()
				,landLord.getfName()};
		String cNumber[]={landLord.getCardNumber(),landLord.getCardNumber(),"",landLord.getCardNumber(),landLord.getCardNumber()
				,"5301 2500 7000 0052"};
		String startMon[]={landLord.getCardStartMonth(),landLord.getCardStartMonth(),landLord.getCardStartMonth()
				,"Please select",landLord.getCardStartMonth(),landLord.getCardStartMonth()};
		String startYear[]={landLord.getCardStartYear(),landLord.getCardStartYear(),landLord.getCardStartYear()
				,"Please select",landLord.getCardStartYear(),landLord.getCardStartYear()};
		String endMon[]={landLord.getCardExpiryMonth(),landLord.getCardExpiryMonth(),landLord.getCardExpiryMonth()
				,landLord.getCardExpiryMonth(),"Please select",landLord.getCardExpiryMonth()};
		String endYear[]={landLord.getCardExpiryYear(),landLord.getCardExpiryYear(),landLord.getCardExpiryYear()
		,landLord.getCardExpiryYear(),"Please select",landLord.getCardExpiryYear()};
		String issueNo[]={landLord.getIssueNumber(),landLord.getIssueNumber(),landLord.getIssueNumber()
				,landLord.getIssueNumber(),landLord.getIssueNumber(),landLord.getIssueNumber()};		
		for(int i=0;i<cType.length;i++){
			enterCreditCardDetails(cType[i], name[i], cNumber[i], startMon[i], startYear[i], endMon[i], endYear[i], issueNo[i]);
			if(browser.isSelected(pageProperties.getProperty("OrderNow.CreditDebit"))){
				clickStandAloneNextButton();
				}else {
				clickPayNextButton();
			}			
			verifyErrorMessage(errorProperty);
			if(browser.isElementVisible(pageProperties.getProperty("OrderNow.packageEditLink"))){
				browser.click(pageProperties.getProperty("OrderNow.packageEditLink"));
			}else if(browser.isElementVisible(pageProperties.getProperty("OrderNow.standAloneEditLink"))){
				browser.click(pageProperties.getProperty("OrderNow.standAloneEditLink"));
			}
		}
	}
	
	public void clickContactTermsCondition(){
		//verifyAndClick(pageProperties.getProperty("OrderNow.contactTerms"), "Use contact information Terms");

		if(browser.isElementVisible(pageProperties.getProperty("OrderNow.contactTerms"))){
			verifyAndClick(pageProperties.getProperty("OrderNow.contactTerms"), "Use contact information Terms");
			}
			selectMartekingConsent();
		}
	
public void selectMartekingConsent(){
		
		verifyAndClickWithXpath(pageProperties.getProperty("OrderNow.LetterConsent"), "LetterConsent");
    	verifyAndClickWithXpath(pageProperties.getProperty("OrderNow.LandLineConsent"), "LandLineConsent");
    	verifyAndClickWithXpath(pageProperties.getProperty("OrderNow.TextMessageConsent"), "TextMessageConsent");
    	

	}
	public void verifyMarketingConsent(){
		String leadData=new OnlineDBConnector().leadOfLandLord(orderDate);
    	System.out.println(leadData);
    	
    		if (leadData.contains("YES,N,Y,N,Y,N,N,N")){
   			Report.updateTestLog("Letter Consent,LandLine Consent and TextMessage Consent are Optout & Email Consent and Mobile Consent are Optin", "PASS");
   		    }
    		else {
    			Report.updateTestLog("Letter Consent,LandLine Consent and TextMessage Consent are not Optout & Email Consent and Mobile Consent are not Optin", "FAIL");
    		}
    							    
    	}	
	
	public void clickPlaceOrderButton(){
		
		browser.wait(2000);
		orderDate=new OnlineDBConnector().DBsysdate();
		verifyAndClick(pageProperties.getProperty("OrderNow.placeOrder"), "Place order button");
		browser.wait(2000);
		verifyMarketingConsent();
	}
	public void verifyPaymentSuccess(String date){		
		verifyIsTextPresent("Thank you for your order");
		verifyIsTextPresent("Your order is being processed");
		//leadDataBeforeBatch(date);
	}
	
	public void leadDataBeforeBatch(String date){
		OnlineDBConnector online=new OnlineDBConnector();		
		int status=online.leadDataOfLandLord(date);
		if(status==0){
			Report.updateTestLog("Lead status in database before batch is "+status, "PASS");
		}else{
			Report.updateTestLog("Lead statuc in database before batch is "+status, "FAIL");
		}
	}
	
	public void leadDataAfterBatch(String date){
		OnlineDBConnector online=new OnlineDBConnector();		
		int status=online.leadDataOfLandLord(date);
		if(status==1){
			Report.updateTestLog("Lead statuc in database after batch is "+status, "PASS");
		}else{
			Report.updateTestLog("Lead status in database aftet batch is "+status, "FAIL");
		}
	}
	
	public void runBatch(String date){
		System.out.println("BATCH");
		SshClient sshClient = new SshClient();
		OnlineDBConnector online=new OnlineDBConnector();
    	 try {
             sshClient.connect();
             if(sshClient.isConnected()){              	 
            	 sshClient.send("cd scripts");   
            	 sshClient.send("ls");            	 
            	 sshClient.send("./dolandlordsorderprocess.sh");  
            	 browser.wait(25000);
            	 sshClient.send("clear");
            	 browser.wait(5000);  
            	 sshClient.send("cd /shared/online/datafiles/outbound/landlords/archive");
            	 String directoryFiles=sshClient.send("ls -l").toString();
            	  
            	 String arrstrLogCSV[]=directoryFiles.split("\n"); 
            	 
            	 ArrayList<String> csvFiles=new ArrayList<String>();
            	 for(String file:arrstrLogCSV){
            		 file=file.trim();
            		 if(file.endsWith("csv")){
            			 csvFiles.add(file);
            		 }
            	 }
            	 
            	 String fileName=csvFiles.get(csvFiles.size()-1);
            	 
            	 fileName=fileName.substring(fileName.indexOf("2012"));
            	 sshClient.send("clear");
            	 String fileContent=sshClient.send("cat "+fileName);
            	 
            	 int leadID =online.leadIDOfLandLord(date);
            	 String fileContent1=fileContent.substring(fileContent.indexOf(""+leadID));
            	 
            	 if(fileContent1.contains(""+leadID)){            	 
               	  Report.updateTestLog("Log file has been generated Succesfully for user<br>"+fileContent1, "PASS");
            	 }else{
            	  Report.updateTestLog("Log file not generated Succesfully<br>"+fileContent1, "FAIL");
            	 }
            	 
            	 csvFileVerification(fileContent1,landLord.getEmail(),"Email");      
            	 csvFileVerification(fileContent1,landLord.getfName(),"First name");
            	 csvFileVerification(fileContent1,landLord.getSurName(),"Surname");
            	 csvFileVerification(fileContent1,landLord.getTelephone(),"Telephone number");
	}
    	 }catch(JSchException e) {
             e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
         } catch (IOException e) {
             e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
         } catch (InterruptedException e) {
             e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
         }
    	 catch(Exception e){
    		 
    	 }
    	 
    	 }
	private void csvFileVerification(String fileContent,String value,String valueType){
		if(fileContent.contains(landLord.getfName())){
				Report.updateTestLog(valueType+" <b>"+value+"</b> is present in batch file", "PASS");
		}else{
			Report.updateTestLog(valueType+" <b>"+value+"</b> is not present in batch file", "FAIL");
		}
	}
	public static void main(String a[]){
		OrderNowPage o=new OrderNowPage();
		o.runBatch("29-05-12 14.16.07");
	}
}
