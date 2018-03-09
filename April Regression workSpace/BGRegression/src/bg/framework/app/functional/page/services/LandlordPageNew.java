package bg.framework.app.functional.page.services;

import java.text.DecimalFormat;

import java.util.ArrayList;
import java.util.List;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.BankValidationDetailsProfile;
import bg.framework.app.functional.entities.LandLord;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.openqa.selenium.WebElement;

public class LandlordPageNew extends BasePage{
	
	private final static String FILE_NAME = "resources/services/LandlordpageNew.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	public static String PackageName;
	public static int ToggleValue = 2;
	DecimalFormat f = new DecimalFormat("##.00");
	public void navigateLandLordPage(){
		
		//browser.open(ApplicationConfig.APP_BG_URL+"/products-and-services/landlords.html");
		browser.wait(10000);
		browser.open(ApplicationConfig.APP_BG_URL+"/get-a-landlord-quote/");
		//verifyAndClickWithLinkText(pageProperties.getProperty("LandlordPage.GetAQuoteLink"), "Get A Quote Link");
		//browser.open(ApplicationConfig.APP_BG_URL+"/get-a-landlord-quote/");
	}
	
	//verify the post code by entering wrong post code values
	public void verifyPostCodeErrorMessage(){
		String postCode[] = {"tw18 458","","tw18 3he","tw18 3h","tw1# 3he","BT"};
		String homeNumber[] = {"","","res","","",""};
		String ErrorMsg = "";
		
		//verifying error text by entering different post code and home number combinations
		for(int i = 0;i<6;i++){
			Report.updateTestLog("******************* Error Scenario "+(i+1)+" *******************", "Pass");
			verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.HouseNumber"), "Home Number "+homeNumber[i], homeNumber[i]);
			verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.PostCode"), "Post Code "+postCode[i], postCode[i]);
			verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.SearchButton"), "Search Button");
			browser.wait(3000);
					
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandlordPage.ErrorMessage"))){
				Report.updateTestLog("Header Error Message displayed in the application page", "Pass");	
			}
			else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandlordPage.PostCodeErrorVerification"))){
				Report.updateTestLog("Postcode Inline error message displayed in application page", "Pass");
			}
			else{
				Report.updateTestLog("Error Message not displayed for Postcode : "+postCode[i]+" Home Number : "+homeNumber[i], "Fail");
			}
		}
		
	}
	
	//verify Landlord by adding multiple property
	public void verifyMultipleProperty(String AddressType){
		List<String> AddressDetails;
		//Add upto 4 properties for landlord in London Postcode
		for(int i=0;i<4;i++){
			browser.wait(4000);
			verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.PostCode"), "Post Code : tw18 3he", "tw18 3he");
			verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.SearchButton"), "Search Button");
			browser.dynamicWaituntilClickablebyID(pageProperties.getProperty("LandlordPage.SelectAddress"));
			if(AddressType == "SelectAddress"){
				AddressDetails = browser.getFromDropBox("id", pageProperties.getProperty("LandlordPage.SelectAddress"));
				verifyAndSelectDropDownBox(pageProperties.getProperty("LandlordPage.SelectAddress"), "Select Address ", AddressDetails.get(i+1));
			}
			else if(AddressType == "ManualAddress"){
				enterAddressManually();
			}
			if(!browser.isElementVisibleWithXpath(pageProperties.getProperty("LandlordPage.ContactDetailsNextButton"))){
				Report.updateTestLog("Next Button not present", "Fail");
			}
			else{
				Report.updateTestLog("Address selection made successful", "Pass");
			}
			verifyAndClickWithLinkText(pageProperties.getProperty("LandlordPage.AddAnotherProperty"), "Add Another Property");
			
		}
		
		for(int i=0;i<4;i++){
			browser.wait(4000);
			verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.PostCode"), "Post Code : AL& 4HD", "al7 4hd");
			verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.SearchButton"), "Search Button");
			browser.dynamicWaituntilClickablebyID(pageProperties.getProperty("LandlordPage.SelectAddress"));
			if(AddressType == "SelectAddress"){
				AddressDetails = browser.getFromDropBox("id", pageProperties.getProperty("LandlordPage.SelectAddress"));
				verifyAndSelectDropDownBox(pageProperties.getProperty("LandlordPage.SelectAddress"), "Select Address ", AddressDetails.get(i+1));
			}
			else if(AddressType == "ManualAddress"){
				enterAddressManually();
			}
			
			verifyAndClickWithLinkText(pageProperties.getProperty("LandlordPage.AddAnotherProperty"), "Add Another Property");
			if(!browser.isElementVisibleWithXpath(pageProperties.getProperty("LandlordPage.ContactDetailsNextButton"))){
				Report.updateTestLog("Next Button not present", "Fail");
			}
			else{
				Report.updateTestLog("Address selection made successful", "Pass");
			}
		}
		
		//Adding 9th property for landlord
		browser.wait(3000);
		verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.PostCode"), "Post Code : tw18 3he", "tw18 3he");
		verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.SearchButton"), "Search Button");
		browser.dynamicWaituntilClickablebyID(pageProperties.getProperty("LandlordPage.SelectAddress"));
		AddressDetails = browser.getFromDropBox("id", pageProperties.getProperty("LandlordPage.SelectAddress"));
		verifyAndSelectDropDownBox(pageProperties.getProperty("LandlordPage.SelectAddress"), "Select Address ", AddressDetails.get(9));
		if(browser.isElementVisibleWithLinkText(pageProperties.getProperty("LandlordPage.AddAnotherProperty"))){
			Report.updateTestLog("Add another property is present after adding 9 properties", "Fail");
		}
		
		// Click the next button
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandlordPage.telephoneNumber"))){
			verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.telephoneNumber"), "Telephone Number", "01234567891");
		}
		verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.ContactDetailsNextButton"), "Next Button");
		verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.ContactDetailsNextButton"), "Next Button");
		
	}
	
	
	public void enterPackageDetails(LandLord Landlord){
		//enter the boiler details
		browser.dynamicWaituntilClickablebyXpath(pageProperties.getProperty("LandlordPage.BoilerCover"));
		verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("LandlordPage.BoilerCover"), "Boiler Cover", "Yes");
		
		//select the package
		browser.dynamicWaituntilClickablebyXpath(pageProperties.getProperty("LandlordPage.SelectPackage"));
		verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("LandlordPage.SelectPackage"), "Select Package","Landlord Pro");
		
		//select the appliances
		verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("LandlordPage.GasFire"), "Gas Fire Selected", ""+Landlord.getGasFire());
		verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("LandlordPage.GasCooker"), "Gas Cooker Selected",""+Landlord.getGasCooker());
		verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("LandlordPage.GasHob"), "Gas Hob Selected", ""+Landlord.getGasHob());
		
		//Enter Date
		verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.DueDate"), "Date Field ", Landlord.getDueDate());
		
		//Click the Apply All button
		verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.ApplyToAll"), "Next Button");
		
		//Click the Next Button
		verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.NextProperty"), "Next Button");
		
		//click confoirm button
		//Click the confirm quote button
		browser.dynamicWaituntilClickablebyXpath(pageProperties.getProperty("LandlordPage.ConfirmQuote"));
		verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.ConfirmQuote"), "Confirm Button");
		browser.wait(getWaitTime());
		//Click on the order now button  
		browser.dynamicWaituntilClickablebyXpath(pageProperties.getProperty("LandlordPage.OrderNow"));
		verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.OrderNow"), "Order now Button");
		
	}
	
	
	
	//Enter thye post code details
	public void enterPostcodeDetails(String Postcode){
		/*List<String> AddressDetails;
		browser.wait(3000);
		for(int i=1;i<10;i++)
		{
		browser.wait(4000);
		verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.PostCode"), "Post Code : tw18 3he", Postcode);
		verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.SearchButton"), "Search Button");
		browser.dynamicWaituntilClickablebyID(pageProperties.getProperty("LandlordPage.SelectAddress"));
		AddressDetails = browser.getFromDropBox("id", pageProperties.getProperty("LandlordPage.SelectAddress"));
		verifyAndSelectDropDownBox(pageProperties.getProperty("LandlordPage.SelectAddress"), "Select Address ", AddressDetails.get(i));
		
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandlordPage.AddAnotherProperty")))
		verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.AddAnotherProperty"), "Add another property link");
		else
		   {
			browser.dynamicWaituntilClickablebyXpath(pageProperties.getProperty("LandlordPage.ContactDetailsNextButton"));
			verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.ContactDetailsNextButton"), "Next Button");
		    }
			
		}*/
		List<String> AddressDetails;
		browser.wait(3000);
		browser.wait(4000);
		verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.PostCode"), "Post Code : tw18 3he", Postcode);
		verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.SearchButton"), "Search Button");
		browser.dynamicWaituntilClickablebyID(pageProperties.getProperty("LandlordPage.SelectAddress"));
		AddressDetails = browser.getFromDropBox("id", pageProperties.getProperty("LandlordPage.SelectAddress"));
		verifyAndSelectDropDownBox(pageProperties.getProperty("LandlordPage.SelectAddress"), "Select Address ", AddressDetails.get(1));
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandlordPage.telephoneNumber"))){
			verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.telephoneNumber"), "Telephone Number", "01234567891");
		}
		verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.ContactDetailsNextButton"), "Next Button");
	}
	

	//verify the Package Pricing
	public void	verifyPackagePricing(String Type, boolean BoilerCover){
		String PackageTypes[] = new String[5];
		//String Excess[] = {"Zero", "Fifty", "NintyNine"};
		String Excess[] = {"Zero", "Sixty"};
		
		if(Type == "National"){
			 PackageTypes[0] = "CP12";
			 PackageTypes[1] = "HC300";
			 PackageTypes[2] = "HC100";
			 PackageTypes[3] = "HC400";
			 PackageTypes[4] = "HC200";
		}
		else if(Type == "London"){
			 PackageTypes[0] = "CP12";
			 PackageTypes[1] = "HC300L";
			 PackageTypes[2] = "HC100L";
			 PackageTypes[3] = "HC400L";
			 PackageTypes[4] = "HC200L";
		}
				
		for(int i=0;i<PackageTypes.length;i++){
			
			LandLord landLord= new TestDataHelper().getLandLord(PackageTypes[i]);
			
			//select Package Name
			browser.dynamicWaituntilClickablebyXpath(pageProperties.getProperty("LandlordPage.SelectPackage"));
			verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("LandlordPage.SelectPackage"), "Select Package", getPackageName(PackageTypes[i]));
			
			if(!(PackageTypes[i] == "CP12")){
				for(int j=0;j<Excess.length;j++){
					//Select the Excess
					selectPackageExcess(Excess[j]);
					//Select the appliances
					BoilerCover = false;
					selectAppliances(landLord, BoilerCover, Excess[j]);
				}
			}
			else{
				//Select the appliances
				BoilerCover = false;
				selectAppliances(landLord, BoilerCover, "null");
			}
		    
		}
		
	}
	
	
		 //Excess Types
	      public void selectPackageExcess(String Excess){
		    if(Excess =="Zero"){
		    	verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.ZeroExcess"),"Zero excess"); 	
		    }
			/*if(Excess == "Fifty"){
				verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.FiftyExcess"),"Fifty excess"); 	
		    }
			if(Excess == "NintyNine"){
				verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.NintyExcess"),"NinetyNine excess");
			}*/
		    if(Excess == "Sixty"){
				verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.SixtyExcess"),"Sixty excess");
		    }
			
	
		
	}
	     
	
	public void selectAppliances(LandLord landLord, boolean BoilerCover, String Excess){
		String CompareCombinations[]= {"000","001","010","100","011","110","111","123","213","312","222","203","302","300","003","002","333","322","223","113","112","331","221"};
		//String CompareCombinations[]= {"000"};
		int GasFire, GasCooker, GasHob;
		for(int i=0; i<CompareCombinations.length; i++){
			// select Gas Fire
			if(CompareCombinations[i].charAt(0) == '0'){
				verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("LandlordPage.GasFire"), "Gas Fire Selected", "Please select");
				GasFire = 0;
			}
			else{
				verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("LandlordPage.GasFire"), "Gas Fire Selected", CompareCombinations[i].charAt(0)+"");
				GasFire = Integer.parseInt(CompareCombinations[i].charAt(0)+"");
			}
			
			//select Gas Cooker
			if(CompareCombinations[i].charAt(1) == '0'){
				verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("LandlordPage.GasCooker"), "Gas Cooker Selected", "Please select");
				GasCooker = 0;
			}
			else{
				verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("LandlordPage.GasCooker"), "Gas Cooker Selected", CompareCombinations[i].charAt(1)+"");
				GasCooker = Integer.parseInt(CompareCombinations[i].charAt(1)+"");	
			}
			
			
			//select Gas Hob
			if(CompareCombinations[i].charAt(2) == '0'){
				verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("LandlordPage.GasHob"), "Gas Hob Selected", "Please select");
				GasHob = 0;
			}
			else{
				verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("LandlordPage.GasHob"), "Gas Hob Selected", CompareCombinations[i].charAt(2)+"");
				GasHob = Integer.parseInt(CompareCombinations[i].charAt(2)+"");
			}
			
			//verify price Calculation
			priceVerification(BoilerCover, landLord, GasFire, GasCooker, GasHob, Excess);
			
			
		}
	}
	
	
	public String getPackageName(String PackageType){
		
		if(PackageType.equals("CP12")){
			PackageName="Gas Safety Check and Certificate";
		}
		else if(PackageType.equals("HC300") || PackageType.equals("HC300L")){
			//PackageName="Landlord Essentials Plus";
			PackageName= "HomeCare One with a Gas Safety Certificate";
			
		}
		else if(PackageType.equals("HC100") || PackageType.equals("HC100L")){
			//PackageName="Landlord Pro";	
			PackageName= "HomeCare Two with a Gas Safety Certificate";
		}
		else if(PackageType.equals("HC400") || PackageType.equals("HC400L")){
			//PackageName="Landlord Basics";
			PackageName= "HomeCare Three with a Gas Safety Certificate";
		}
		else if(PackageType.equals("HC200") || PackageType.equals("HC200L")){
			//PackageName="HomeCare 300™ & CP12";
			PackageName= "HomeCare Four with a Gas Safety Certificate";
		}
		
		return PackageName;
	}
	
	public float getLandLordPackageAmount(String Excess,LandLord landLord){
		float packageAmount;
		if(Excess == "Zero"){
			packageAmount = landLord.getPackageAmount();
		}
		/*else if(Excess == "Fifty"){
			packageAmount = landLord.getPackageAmountFifty();
		}
		else if(Excess == "NintyNine"){
			packageAmount = landLord.getPackageAmountNinetyNine();
		}*/
		else if(Excess == "Sixty"){
			packageAmount = landLord.getPackageAmountSixty();
		}
		else{
			packageAmount = landLord.getPackageAmount();
		}
		return packageAmount;
	}
		
	public void priceVerification(boolean BoilerCover, LandLord landLord, int GasFire, int GasCooker, int GasHob, String Excess){
		float LandlordGasFire;
		float LandlordGasCooker;
		float LandlordGasHob;
		float LandlordPackage = getLandLordPackageAmount(Excess,landLord);
		
		if(PackageName.equalsIgnoreCase("Gas Safety Check and Certificate")){
			LandlordGasFire = landLord.getAnnualFire();
			LandlordGasCooker = landLord.getAnnualCooker();
			LandlordGasHob = landLord.getAnnualHob();
		}
		else{
			LandlordGasFire = landLord.getGasFire();
			LandlordGasCooker = landLord.getGasCooker();
			LandlordGasHob = landLord.getGasHob();
		}
		
		float TotalPrice = LandlordPackage + (GasFire*LandlordGasFire) + (GasCooker*LandlordGasCooker) + (GasHob*LandlordGasHob);
		String PriceCheck="", UndiscountedPrice="";
		
		
		if(BoilerCover == false){
			//Get the text from the page
			browser.dynamicWaituntilVisiblebyXpath(pageProperties.getProperty("LandlordPage.PriceCheck"));
			PriceCheck = browser.getTextByXpath(pageProperties.getProperty("LandlordPage.PriceCheck")).substring(1);
					
			//Price Comparison
			TotalPrice = Float.parseFloat(f.format(TotalPrice));
			if(TotalPrice == Float.parseFloat(PriceCheck)){
				Report.updateTestLog("The displayed price is "+PriceCheck+" and the actual price is "+TotalPrice, "Pass");
			}
			else{
				Report.updateTestLog("The displayed price is "+PriceCheck+" and the actual price is "+TotalPrice, "Fail");
			}
	
		}
		else{
			float DiscountedPrice = TotalPrice - ((TotalPrice * 10)/100);
			DiscountedPrice = Float.parseFloat(f.format(DiscountedPrice));
						
			//Get price from the page
			browser.dynamicWaituntilVisiblebyXpath(pageProperties.getProperty("LandlordPage.PriceCheck"));
			PriceCheck = browser.getTextByXpath(pageProperties.getProperty("LandlordPage.PriceCheck")).substring(1);
			
			browser.dynamicWaituntilVisiblebyXpath(pageProperties.getProperty("LandlordPage.UnDiscountedPrice"));
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandlordPage.UnDiscountedPrice"))){
				UndiscountedPrice = browser.getTextByXpath(pageProperties.getProperty("LandlordPage.UnDiscountedPrice")).substring(1);
				
				//Price Comparison
				if(DiscountedPrice == Float.parseFloat(PriceCheck) && TotalPrice == Float.parseFloat(UndiscountedPrice)){
					Report.updateTestLog("The displayed price is "+PriceCheck+" and the actual price is "+DiscountedPrice, "Pass");
				}
				else{
					Report.updateTestLog("Price Mismatch : The displayed price is "+PriceCheck+" and the actual price is "+DiscountedPrice, "Fail");
				}
			}
			else{
				
				//Price Comparison
				TotalPrice = Float.parseFloat(f.format(TotalPrice));
				if(TotalPrice == Float.parseFloat(PriceCheck)){
					Report.updateTestLog("The displayed price is "+PriceCheck+" and the actual price is "+TotalPrice, "Pass");
				}
				else{
					Report.updateTestLog("The displayed price is "+PriceCheck+" and the actual price is "+TotalPrice, "Fail");
				}
				
			}
						
			
		}
	}
	
	
	public void fillPackageDetails(LandLord Landlord){
		//Enter Date
		verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.DueDate"), "Date Field ", Landlord.getDueDate());
		
		//Applying Same package for all selected properties
		//verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.ApplyToAllProperties"), "Apply to all selected properties check box");
		
		//Click the Next Button
		verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.NextProperty"), "Next Button");
		
		//Click the confirm quote button
		browser.dynamicWaituntilClickablebyXpath(pageProperties.getProperty("LandlordPage.ConfirmQuote"));
		verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.ConfirmQuote"), "Confirm Button");
		
		//Click on the order now button  
		browser.dynamicWaituntilClickablebyXpath(pageProperties.getProperty("LandlordPage.OrderNow"));
		verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.OrderNow"), "Order now Button");
	}
	
	
	public void fillContactSectionAnonymous(String PostCode){
		List<String> AddressDetails;
		//Entering the contact detail section
		browser.wait(getWaitTime());
		browser.dynamicWaituntilClickablebyXpath(pageProperties.getProperty("LandlordPage.ContactSearchButton"));
		browser.wait(getWaitTime());
		WebElement element = browser.getElementByXpath(pageProperties.getProperty("LandlordPage.Title"));
		//element.click();
		element = browser.getElementByXpath(pageProperties.getProperty("LandlordPage.TitleOptionSelect"));
		element.click();
		verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.FirstName"), "First Name", "David");
		verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.LastName"), "Last Name", "Finch");
		verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.Email"), "Email", "digitaltesting@britishgas.co.uk");
		verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.Telephone"), "Telephone", "01234567891");
		verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.PostCode"), "PostCode", PostCode);
		verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.ContactSearchButton"), "Search button");
		//select address
		browser.dynamicWaituntilClickablebyID(pageProperties.getProperty("LandlordPage.SelectAddress"));
		AddressDetails = browser.getFromDropBox("id", pageProperties.getProperty("LandlordPage.SelectAddress"));
		verifyAndSelectDropDownBox(pageProperties.getProperty("LandlordPage.SelectAddress"), "Select Address ", AddressDetails.get(1));
		
		//select Next buuton
		browser.dynamicWaituntilClickablebyXpath(pageProperties.getProperty("LandlordPage.OrderDetailsNextButton"));
		verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.OrderDetailsNextButton"), "Next button");
	}
	
	public void fillContactSectionLoggedIn(String PostCode){
		List<String> AddressDetails;
		verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.FirstName"), "First Name", "David");
		verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.Telephone"), "Telephone", "01234567891");
		verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.PostCode"), "PostCode", PostCode);
		verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.ContactSearchButton"), "Search button");
		
		//select address
		browser.dynamicWaituntilClickablebyID(pageProperties.getProperty("LandlordPage.SelectAddress"));
		AddressDetails = browser.getFromDropBox("id", pageProperties.getProperty("LandlordPage.SelectAddress"));
		verifyAndSelectDropDownBox(pageProperties.getProperty("LandlordPage.SelectAddress"), "Select Address ", AddressDetails.get(1));
		
		//select Next buuton
		browser.dynamicWaituntilClickablebyXpath(pageProperties.getProperty("LandlordPage.OrderDetailsNextButton"));
		verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.OrderDetailsNextButton"), "Next button");
		
	}
	
	public void enterPaymentDetails(String PackageDetail){
		
			//To Enter Single Bank Account
			enterSingleBankDetails(PackageDetail);
		
		
		//To Validate n number of Bank Account
		//enterMultipleBankDetails();
		
		
	}
	
	public void enterSingleBankDetails(String PackageDetail){
		browser.wait(getWaitTime());
		if(!PackageDetail.equalsIgnoreCase("Landlord Essentials")){
			//select Payment Type
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandlordPage.MonthlyDD"))){
				verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.MonthlyDD"), "Monthly DD");
			}
			else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandlordPage.AnnualDD"))){
				verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.AnnualDD"), "Annual Direct Debit");	
			}
		}
		
		
		//enter the account  number
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandlordPage.AccountNumber"))){
			verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.AccountNumber"), "Annual Account", "00003036");	
		}
		else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandlordPage.AccountNumber1"))){
			verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.AccountNumber1"), "Annual Account", "00003036");
		}
		
		//Enter the sort code
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandlordPage.SortCode1"))){
			verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.SortCode1"), "Sort Code 1", "07");
			verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.SortCode2"), "Sort Code 2", "01");
			verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.SortCode3"), "Sort Code 3", "16");
			verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.AccountName"), "Account Name", "Testing");
			if(!PackageDetail.equalsIgnoreCase("Gas Safety Check and Certificate")){
				//select Payment
				verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("LandlordPage.PaymentDate"), "Payment date", "4th");
			}
			verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.PaymentNext"), "Payment Next button");
		}
		else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandlordPage.SortCodeA1"))){
			verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.SortCodeA1"), "Sort Code 1", "07");
			verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.SortCodeA2"), "Sort Code 2", "01");
			verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.SortCodeA3"), "Sort Code 3", "16");
			verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.AccountName1"), "Account Name", "Testing");
			
			if(!PackageDetail.equalsIgnoreCase("Gas Safety Check and Certificate")){
				//select Payment
				verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("LandlordPage.PaymentDate"), "Payment date", "4th");
			}
			verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.PaymentNext1"), "Payment Next button");
		}
		browser.wait(3000);
			
	}
	
	
	public void enterMultipleBankDetails(){
		BankValidationDetailsProfile bankDetails = new TestDataHelper().BankValidationDetaisProfile("BankDetailsCount");
		int BankDetailsCount =Integer.parseInt(bankDetails.getBankValidationCount()); 
		for(int i=0;i<BankDetailsCount;i++){
			bankDetails = new TestDataHelper().BankValidationDetaisProfile("BankDetails"+(i+1));
			
			//select Payment Type
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandlordPage.MonthlyDD"))){
				verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.MonthlyDD"), "Monthly DD");
			}
			else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandlordPage.AnnualDD"))){
				verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.AnnualDD"), "Annual Direct Debit");	
			}
			
			//enter the account  number
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandlordPage.AccountNumber"))){
				verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.AccountNumber"), "Annual Account", bankDetails.getAccountNumber());	
			}
			else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandlordPage.AccountNumber1"))){
				verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.AccountNumber1"), "Annual Account", bankDetails.getAccountNumber());
			}
			
			//Enter the sort code
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandlordPage.SortCode1"))){
				verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.SortCode1"), "Sort Code 1", bankDetails.getSortCode1());
				verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.SortCode2"), "Sort Code 2", bankDetails.getSortCode2());
				verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.SortCode3"), "Sort Code 3", bankDetails.getSortCode3());
				verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.AccountName"), "Account Name", "Testing");
				//select Payment
				verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("LandlordPage.PaymentDate"), "Payment date", "4th");
				verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.PaymentNext"), "Payment Next button");
			}
			else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandlordPage.SortCodeA1"))){
				verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.SortCodeA1"), "Sort Code 1", bankDetails.getSortCode1());
				verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.SortCodeA2"), "Sort Code 2", bankDetails.getSortCode2());
				verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.SortCodeA3"), "Sort Code 3", bankDetails.getSortCode3());
				verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.AccountName1"), "Account Name", "Testing");
				//select Payment
				verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("LandlordPage.PaymentDate"), "Payment date", "4th");
				verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.PaymentNext1"), "Payment Next button");
			}
			browser.wait(3000);
			
			if(i<(BankDetailsCount-1)){
				if(browser.isElementVisibleWithXpath(".//*[@id='packagesPaymentEdit']/span")){
					Report.updateTestLog("Bank Details passed validation", "Pass");
					browser.clickWithXpath(".//*[@id='packagesPaymentEdit']/span");	
				}
				else{
					Report.updateTestLog("Bank Details combination Failed Validation", "Fail");
				}
					
			}

		}
		
	}
	
	
	public void enterTermsAndConditions(String PackageDetail){
		browser.dynamicWaituntilClickablebyXpath(pageProperties.getProperty("LandlordPage.PlaceOrder"));
		verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.TermsGas"), "Terms Gas Certificate");
		if(!PackageDetail.equalsIgnoreCase("Gas Safety Check and Certificate")){
			verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.TermsHomeCare"), "Terms Homecare");
			verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.TermsAssumptions"), "Terms Assumptions");
		}
		verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.PlaceOrder"), "Place Order");
	}
	
	
	public void verifyThankYouPage(){
		browser.dynamicWaituntilVisiblebyXpath(pageProperties.getProperty("LandlordPage.HeaderText"));
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandlordPage.HeaderText"))){
			if(browser.getTextByXpath(pageProperties.getProperty("LandlordPage.HeaderText")).contains("Thank you")){
				Report.updateTestLog("Thank you page displayed successfully", "Pass");
			}
			else{
				Report.updateTestLog("Thank you page text mismatch", "Fail");
			}
		}
		else{
			Report.updateTestLog("Thank you page not displayed successfully", "Fail");
		}
	}
	
	public void verifyMultiplePropertyPackageDetails(LandLord Landlord, String PackageDetail){
		// To verify check box Apply same package selection to all properties
		validateMultiplePropertySelection(Landlord,PackageDetail);
	}
	
	
	public void validateMultiplePropertySelection(LandLord Landlord, String PackageDetail){
		float DisplayedPriceLog = 0, InputPriceLog = 0, i = 1, TotalDisplayedPriceMonthly = 0;
		LandLord landLord; 
		
		//select first Package
		verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("LandlordPage.SelectPackage"), "Package Dropdown", PackageDetail);
		
		//select the Apply All Check box
		verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.ApplyToAll"), "Apply All Checkbox");
		
		//Click Next Property
		verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.NextProperty"), "Next Property");
		
		//Verify Price Changes
		while(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandlordPage.SelectedAddress").replace("DIVNUMBER", i+""))){
			if(browser.getTextByXpath(pageProperties.getProperty("LandlordPage.SelectedAddress").replace("DIVNUMBER", i+"")).contains("Meadow")){
				InputPriceLog = InputPriceLog + new TestDataHelper().getLandLord(getLondonPackage(PackageDetail)).getPackageAmount();
				DisplayedPriceLog = DisplayedPriceLog + Float.parseFloat(browser.getTextByXpath(pageProperties.getProperty("LandlordPage.PopulatedPrice").replace("DIVNUMBER", i+"")).replace("£", ""));
			}
			else if(browser.getTextByXpath(pageProperties.getProperty("LandlordPage.SelectedAddress").replace("DIVNUMBER", i+"")).contains("Howlands") || browser.getTextByXpath(pageProperties.getProperty("LandlordPage.SelectedAddress").replace("DIVNUMBER", i+"")).contains("Wellfield")){
				InputPriceLog = InputPriceLog + new TestDataHelper().getLandLord(getNationalPackage(PackageDetail)).getPackageAmount();
				DisplayedPriceLog = DisplayedPriceLog + Float.parseFloat(browser.getTextByXpath(pageProperties.getProperty("LandlordPage.PopulatedPrice").replace("DIVNUMBER", i+"")).replace("£", ""));
			}
			i = i+2;
		}
		
		//Click confirm Quote
		verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.ConfirmQuote"), "Confirm Quote");
		
		//Get the Total Displayed Price
		browser.dynamicWaituntilVisiblebyXpath(pageProperties.getProperty("LandlordPage.TotalDisplayedPriceMonthly"));
		
		System.out.println("1111111111111111111111111"+PackageDetail);
		if(PackageDetail.equalsIgnoreCase("Gas Safety Check and Certificate")){
			browser.wait(3000);
			System.out.println("gggggggggggggggggggggg" +browser.getTextByXpath(pageProperties.getProperty("LandlordPage.TotalDisplayedPriceMonthlyCP12")));
			TotalDisplayedPriceMonthly = Float.parseFloat(browser.getTextByXpath(pageProperties.getProperty("LandlordPage.TotalDisplayedPriceMonthlyCP12")).replace("£", ""));
		}
		else{
			browser.wait(3000);
			TotalDisplayedPriceMonthly = Float.parseFloat(browser.getTextByXpath(pageProperties.getProperty("LandlordPage.TotalDisplayedPriceMonthly")).replace("£", ""));	
		}
		
		DecimalFormat df = new DecimalFormat("#.##");
		TotalDisplayedPriceMonthly = Float.parseFloat(f.format(TotalDisplayedPriceMonthly));
		DisplayedPriceLog = Float.parseFloat(f.format(DisplayedPriceLog));
		InputPriceLog = Float.parseFloat(f.format(InputPriceLog));
	
		//Price Validation
		if(TotalDisplayedPriceMonthly == DisplayedPriceLog){
			Report.updateTestLog("Individual Displayed price and Final Calculated Monthly Sum Price are Same "+TotalDisplayedPriceMonthly, "Pass");
		}
		else{
			Report.updateTestLog("Individual Displayed price "+DisplayedPriceLog+" and Final Calculated Monthly Sum Price "+TotalDisplayedPriceMonthly+" Mismatch", "Fail");
		}
		
		if(TotalDisplayedPriceMonthly == InputPriceLog){
			Report.updateTestLog("Input Calculated price and Final Calculated Monthly Sum Price are Same : "+TotalDisplayedPriceMonthly, "Pass");
		}
		else{
			Report.updateTestLog("Input Calculated price "+InputPriceLog+" and Final Calculated Monthly Sum Price "+TotalDisplayedPriceMonthly+" Mismatch", "Fail");
		}
		
		if(InputPriceLog == DisplayedPriceLog){
			Report.updateTestLog("Input Calculated price and Individual Displayed Monthly Sum Price are Same "+InputPriceLog, "Pass");
		}
		else{
			Report.updateTestLog("Input Calculated price "+InputPriceLog+" and Individual Displayed Monthly Sum Price "+DisplayedPriceLog+" Mismatch", "Fail");
		}
		
		
		//Click on the order now button  
		browser.dynamicWaituntilClickablebyXpath(pageProperties.getProperty("LandlordPage.OrderNow"));
		verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.OrderNow"), "Order now Button");
	}
	
	
	public void enterAddressManually(){
		String[] AddressDetails = new String[7];
		 String Address1[]= {"Studio 103", "The Business Centre","61 Wellfield Road","Cardiff","England","CF24 3DG"};
		
		 //click on enter address manually
		verifyAndClickWithXpath(pageProperties.getProperty("LandlordPage.ManualAddressLink"), "Manua; Address Link");
		
		AddressDetails = Address1;
		
		//Enter House Number 
		verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.HouseNumber"), "House Number", AddressDetails[0]);
		
		//Enter House Name
		verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.HouseName"), "House Name", AddressDetails[1]);
		
		//Enter Flat Number
		verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.FlatNumber"), "Flat Name", AddressDetails[2]);
		
		//Enter Address
		verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.AddressOne"), "Address one", AddressDetails[3]);
		
		//Enter postal town
		verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.PostalTown"), "Postal town", AddressDetails[4]);
		
		//Enter Postal code
		verifyAndInputByXpath(pageProperties.getProperty("LandlordPage.ManualPostCode"), "Postal code", AddressDetails[5]);
		
		// Select County
		WebElement element = browser.getElementByXpath(pageProperties.getProperty("LandlordPage.CountyXpath"));
		element.click();
		element = browser.getElementByXpath(pageProperties.getProperty("LandlordPage.CountyOption").replace("VARIABLE", ToggleValue+""));
		element.click();
		browser.wait(5000);
		ToggleValue = ToggleValue + 1;
	}
	
	public String getNationalPackage(String Package){
		if(Package == "Gas Safety Check and Certificate"){
			return "CP12";
		}
		//else if(Package == "Landlord Essentials Plus"){
		else if(Package == "HomeCare One with a Gas Safety Certificate"){
			return "HC300";
		}
		//else if(Package == "Landlord Pro"){
		else if(Package == "HomeCare Two with a Gas Safety Certificate"){
			return "HC100";
		}
		//else if(Package == "Landlord Basics"){
		else if(Package == "HomeCare Three with a Gas Safety Certificate"){
			return "HC400";
		}
		//else if(Package == "HomeCare 300™ & CP12"){
		else if(Package == "HomeCare Four with a Gas Safety Certificate"){
			return "HC200";
		}
		else{
			return "";
		}
	}
	
	
	public String getLondonPackage(String Package){
		if(Package == "Gas Safety Check and Certificate"){
			return "CP12";
		}
		//else if(Package == "Landlord Essentials Plus"){
		else if(Package == "HomeCare One with a Gas Safety Certificate"){
			return "HC300L";
		}
		//else if(Package == "Landlord Pro"){
		else if(Package == "HomeCare Two with a Gas Safety Certificate"){
			return "HC100L";
		}
		//else if(Package == "Landlord Basics"){
		else if(Package == "HomeCare Three with a Gas Safety Certificate"){
			return "HC400L";
		}
		//else if(Package == "HomeCare 300™ & CP12"){
		else if(Package == "HomeCare Four with a Gas Safety Certificate"){
			return "HC200L";
		}
		else{
			return "";
		}
	}
	
}
