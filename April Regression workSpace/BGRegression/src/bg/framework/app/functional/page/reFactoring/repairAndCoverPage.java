package bg.framework.app.functional.page.reFactoring;

import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.support.ui.Select;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.KACPriceProfile;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.selfServe.PersonalDetailsPage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class repairAndCoverPage extends BasePage{
	private final static String FILE_NAME = "resources/reFactoring/repairAndCover.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	private static String boilerType;
	private static String paymentType;
	private static String addrType;
	private static String custType;
	
	public repairAndCoverPage(String custType,String boilerType,String paymentType,String addrType){
		this.boilerType = boilerType;
		this.paymentType = paymentType;
		this.addrType = addrType;
		this.custType = custType;
	}
	public repairAndCoverPage(){
		
	}

	public void navigateToBoilerLandingPage(){
		browser.open(ApplicationConfig.APP_BG_URL+"/products-and-services/boilers-and-central-heating/boiler-repairs/boiler-repair-and-cover/");
	}
	public void navigateToHECLandingPage(){
		browser.open(ApplicationConfig.APP_BG_URL+"/products-and-services/home-electrics/home-electrics-repairs/home-electrics-repair-and-cover/");
	}
	public void navigateToKACLandingPage(){
		browser.open(ApplicationConfig.APP_BG_URL+"/products-and-services/home-appliances/kitchen-appliance-repairs/kitchen-appliance-repair-and-cover/");
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("repairAndCoverPage.porductDropDown"))){
		Select select = new Select(browser.getElementByXpath(pageProperties.getProperty("repairAndCoverPage.porductDropDown")));
		select.selectByIndex(5);
		Report.updateTestLog("KAC product Selected from Dropdown", "Pass");  
		}
		else{
			Report.updateTestLog("KAC product is not Selected from Dropdown", "Fail");
		}
		
	}
	public void navigateToLandlordLandingPage(){
		browser.open(ApplicationConfig.APP_BG_URL+"/products-and-services/landlords/landlords-repairs/landlords-boiler-repair-and-cover/");
		verifyAndClick(pageProperties.getProperty("repairAndCoverPage.cp12YesOption"),"CP12 Yes option");
	}
	
		
	///// Entering PostCode /////
	public void enterPostCode(Acquisition acquisition){
		verifyAndInputByXpath(pageProperties.getProperty("repairAndCoverPage.postCode"),"Post Code",acquisition.getPostcode());
		verifyAndClickWithXpath(pageProperties.getProperty("repairAndCoverPage.searchButton"),"Search Button");
		browser.wait(20000);
		browser.WaitForElementWithId(pageProperties.getProperty("repairAndCoverPage.addrDropDown"));
		if(browser.isElementVisible(pageProperties.getProperty("repairAndCoverPage.addrDropDown"))){
			Select select = new Select(browser.getElementByXpath(pageProperties.getProperty("repairAndCoverPage.addrDropDownXpath")));
			select.selectByIndex(acquisition.getIndexNo());
			Report.updateTestLog("Address Selected from Dropdown", "Pass");  
		}
		else{
			Report.updateTestLog("Address is not Selected from Dropdown", "Fail");  
		} 
		if(browser.isElementVisible(pageProperties.getProperty("repairAndCoverPage.viewAvailability"))){
			verifyAndClick(pageProperties.getProperty("repairAndCoverPage.viewAvailability"),"View Availability Button");
			Report.updateTestLog("View Availabilty Button is Clicked Successfully", "Warn");
		}
		else{
			Report.updateTestLog("View Availabilty Button is not Clicked Successfully","Fail");
		}
		browser.wait(6000);
	}

    public void verifyAndSelectAppointmentSlot(){
    	verifyAvailableSlot();
    	selectAppointmentSlot();
    }
    
    public void selectFirstAppointment(){
    	verifyAvailableSlot();
    	bookAppointmentSlot();
    }
    
	public void bookAppointmentSlot(){
		if(browser.isElementVisible(pageProperties.getProperty("repairAndCoverPage.selectFirstAppointment1"))){
			
			verifyAndClick(pageProperties.getProperty("repairAndCoverPage.selectFirstAppointment1"), "First Appointment");
		}else if(browser.isElementVisible(pageProperties.getProperty("repairAndCoverPage.selectFirstAppointment0"))){
			verifyAndClick(pageProperties.getProperty("repairAndCoverPage.selectFirstAppointment0"), "Before First Appointment");
		}else{
			Report.updateTestLog("appointment slot does not exists", "FAIL");
		}
		
		
	} 
	
	public void validateAddressPostCode(UserProfile userProfile){
		verifyAndInputByXpath(pageProperties.getProperty("repairAndCoverPage.postCode"),"Post Code", userProfile.getPostCode());
		verifyAndClickWithXpath(pageProperties.getProperty("repairAndCoverPage.searchButton"),"Search Button");
		browser.WaitForElementWithId(pageProperties.getProperty("repairAndCoverPage.addrDropDown"));
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("repairAndCoverPage.addrDropDownXpath"))){
			Select select = new Select(browser.getElementByXpath(pageProperties.getProperty("repairAndCoverPage.addrDropDownXpath")));
			int Size = select.getOptions().size();
			System.out.println("Size is : "+Size);
			for(int i=1;i<=Size;i++){
				String xpath=".//*[@id='displayaddr']/option["+i+"]";
				String dropData=browser.getTextByXpath(xpath);
				System.out.println("drop data value is "+i+""+dropData);
				String[] brwCode=dropData.split("Middlesex,");
				String brwCode1=brwCode[1].trim();
			if(brwCode1.equals("TW18 3HE")){
				Report.updateTestLog("Post Code "+i+" displayed is valid", "PASS");
			}else{
				Report.updateTestLog("Post Code "+i+" displayed is not valid", "FAIL");
			}
			}
			
		}
		
		
	}
	
	public void validateNoAppointment(UserProfile userProfile){
		verifyAndInputByXpath(pageProperties.getProperty("repairAndCoverPage.postCode"),"Post Code", userProfile.getPostCode());
		verifyAndClickWithXpath(pageProperties.getProperty("repairAndCoverPage.searchButton"),"Search Button");
	browser.WaitForElementWithXpath(pageProperties.getProperty("repairAndCoverPage.NoAppointmentError"));
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("repairAndCoverPage.NoAppointmentError"))){
		String errorMsg=browser.getTextByXpath(pageProperties.getProperty("repairAndCoverPage.NoAppointmentError"));
		Report.updateTestLog("No Appoinment Msg Exists "+errorMsg, "PASS");
	} else{
		Report.updateTestLog("No Appointmnet Msg Not exists", "FAIL");
	}
			
	}
	public void changeAddress(){
		verifyAndClick(pageProperties.getProperty("repairAndCoverPage.ChangeAddress"), "Change Address");
	}
	
	public void verifyAddressChange(){
		browser.WaitForElementWithId(pageProperties.getProperty("repairAndCoverPage.ChangeAddress"));
		if(browser.isElementVisible(pageProperties.getProperty("repairAndCoverPage.ChangeAddress"))){
			Report.updateTestLog("Address has been changed successfully", "PASS");
		}else{
			Report.updateTestLog("Address not changed Successfully", "FAIL");
		}
	}
	
	public void inputPostCode(Acquisition acquisition,UserProfile userProfile){
		verifyAndInputByXpath(pageProperties.getProperty("repairAndCoverPage.postCode"),"Post Code", userProfile.getPostCode());
		verifyAndClickWithXpath(pageProperties.getProperty("repairAndCoverPage.searchButton"),"Search Button");
		browser.WaitForElementWithId(pageProperties.getProperty("repairAndCoverPage.addrDropDown"));
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("repairAndCoverPage.addrDropDownXpath"))){
			String xpath=pageProperties.getProperty("repairAndCoverPage.addrDropDown1").replace("+i+", acquisition.getIndexNo()+"");
			System.out.println("address xpath is "+xpath);
			Report.updateTestLog("address xpath is "+xpath, "WARN");
			String dropData=browser.getTextByXpath(xpath);
			System.out.println("drop data value is "+dropData);
			Report.updateTestLog("Drop data value "+dropData, "PASS");
			verifyAndSelectDropDownBox(pageProperties.getProperty("repairAndCoverPage.addrDropDown"), "Address Dropdown", dropData);
			Report.updateTestLog("Address Selected from Dropdown", "Pass");  
		}
		else{
			Report.updateTestLog("Address is not Selected from Dropdown", "Fail");  
		} 
	}
	
	//// verifying available slots ////
	public void verifyAvailableSlot(){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("repairAndCoverPage.nextSlotDisplayed"))){
			String nextSlot = browser.getTextByXpath(pageProperties.getProperty("repairAndCoverPage.nextSlotDisplayed"));
			Report.updateTestLog("Next available slot is displayed on the Screen" + nextSlot , "Pass");
		}
		else {
			Report.updateTestLog("Next available slot is not displayed on the screen" ,"Fail"); 
		}
		verifyAndClick(pageProperties.getProperty("repairAndCoverPage.allAppointments"),"View all available appointments");
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("repairAndCoverPage.availableAppointmentsTable"))){
			Report.updateTestLog("Available appointments slots is displayed", "Pass");
		}
		else {
			Report.updateTestLog("Available appointments slots is not displayed", "Fail"); 
		}
	}

	//// Selecting First available Slot ////
	public void selectAppointmentSlot(){
		for (int i = 1 ; i < 5 ; i++){
			for (int j = 2 ; j < 15 ; j++){
				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("repairAndCoverPage.availableSlots").replace("Row", ""+i).replace("Col", ""+j))){
					verifyAndClickWithXpath(pageProperties.getProperty("repairAndCoverPage.availableSlots").replace("Row", ""+i).replace("Col", ""+j),"Available Slots");
					verifyAndClickWithXpath(pageProperties.getProperty("repairAndCoverPage.selectThisAppointment"),"Select this appointment Button");
					Report.updateTestLog("Next available slot is clicked successfully","Pass");	
					break;
				}
			}
		}	  
	}



	public void verifyRepairAndCoverPage(){
		//// verifying address on the screen ////
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("repairAndCoverPage.addressDisplayed"))){
			String addr = browser.getTextByXpath(pageProperties.getProperty("repairAndCoverPage.addressDisplayed"));
			Report.updateTestLog("Address is displayed on the screen:" +addr , "Pass");
		}
		else{
			Report.updateTestLog("Address is not displayed on the screen", "Fail"); 
		}

		//// verifying select appointment section ////
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("repairAndCoverPage.SlotDay"))){
			String day = browser.getTextByXpath(pageProperties.getProperty("repairAndCoverPage.SlotDay"));
			String time = browser.getTextByXpath(pageProperties.getProperty("repairAndCoverPage.SlotTime"));
			String selectedAppointment = day + time ;
			Report.updateTestLog("Selected appointment Displyed:" +selectedAppointment , "Pass");
		}
		else {
			Report.updateTestLog("Selected appointment is not Displyed", "Fail");
		}
	}
	//// navigating to Order Now Page ////
	public void navigateToOrderNowPage(){
		if(browser.isElementVisibleWithLinkText(pageProperties.getProperty("repairAndCoverPage.orderNowButton"))){
			verifyAndClickWithLinkText(pageProperties.getProperty("repairAndCoverPage.orderNowButton"),"Order Now Button is clicked");
			Report.updateTestLog("Order Now Button is clicked Successfully", "Pass");
		}
		else {
			Report.updateTestLog("Order Now Button is not clicked Successfully", "Fail");
		}
	}

	//// entering Contact details ////
	public void enteringContactDetails(UserProfile userProfile,Acquisition acquisition){
		if(custType =="Anonymous"){
			verifyAndSelectDropDownBox(pageProperties.getProperty("repairAndCoverPage.title"), "Title",userProfile.getTitle());
			verifyAndInputById(pageProperties.getProperty("repairAndCoverPage.firstName"), "First Name", userProfile.getFirstName());
			verifyAndInputById(pageProperties.getProperty("repairAndCoverPage.lastName"), "Last Name", userProfile.getLastName());
			verifyAndSelectDropDownBox(pageProperties.getProperty("repairAndCoverPage.Day"), "Day of DOB", acquisition.getDay());
			verifyAndSelectDropDownBox(pageProperties.getProperty("repairAndCoverPage.Month"), "Month of DOB", acquisition.getMonth());
			verifyAndSelectDropDownBox(pageProperties.getProperty("repairAndCoverPage.Year"), "Year of DOB", acquisition.getYear());
			verifyAndInputById(pageProperties.getProperty("repairAndCoverPage.telephoneNumber"), "Telephone Number", acquisition.getMobileNumber());
			verifyAndSelectDropDownBox(pageProperties.getProperty("repairAndCoverPage.telephoneType"), "Telephone Type", acquisition.getTelephonetype());
			verifyAndInputById(pageProperties.getProperty("repairAndCoverPage.email"), "Email",userProfile.getEmail());
			verifyAndSelectDropDownBox(pageProperties.getProperty("repairAndCoverPage.emailType"), "Email Type", acquisition.getEmailtype());
			 Report.updateTestLog("Card Details Entered", "WARN");
			verifyAndClick(pageProperties.getProperty("repairAndCoverPage.ContactNextButton"),"Contact Next Button"); 
		}
		if(custType == "LoggedIn"){
			verifyAndInputById(pageProperties.getProperty("repairAndCoverPage.telephoneNumber"), "Telephone Number", acquisition.getMobileNumber());
			verifyAndSelectDropDownBox(pageProperties.getProperty("repairAndCoverPage.telephoneType"), "Telephone Type", acquisition.getTelephonetype());
			verifyAndSelectDropDownBox(pageProperties.getProperty("repairAndCoverPage.emailType"), "Email Type", acquisition.getEmailtype());
			Report.updateTestLog("Card Details Entered", "WARN");
			verifyAndClick(pageProperties.getProperty("repairAndCoverPage.ContactNextButton"),"Contact Next Button"); 
		}
		String email = userProfile.getEmail();
		browser.wait(5000);
	}

	//// selecting Boiler Type ////
	public void selectingBoilerType(){
		browser.wait(getWaitTime());
		if(boilerType == "yes"){
			verifyAndClick(pageProperties.getProperty("repairAndCoverPage.applicableRadio"),"Applicable Radio is selected");
			browser.wait(getWaitTime());
            if(browser.isElementVisibleWithXpath(pageProperties.getProperty("repairAndCoverPage.boilerMake"))){
            	browser.wait(getWaitTime());
                            Select select = new Select(browser.getElementByXpath(pageProperties.getProperty("repairAndCoverPage.boilerMake")));
                            select.selectByIndex(2);
                            Report.updateTestLog("Boiler make is selected from Dropdown", "Pass");  
            }
            else{
                            Report.updateTestLog("Boiler make is not Selected from Dropdown", "Fail");  
            } 
            browser.wait(15000);
            browser.wait(getWaitTime());
            if(browser.isElementVisibleWithXpath(pageProperties.getProperty("repairAndCoverPage.boilerModel"))){
                            Select select = new Select(browser.getElementByXpath(pageProperties.getProperty("repairAndCoverPage.boilerModel")));
                            select.selectByIndex(1);
                            Report.updateTestLog("Boiler model is selected from Dropdown", "Pass");  
            }
            else{
                            Report.updateTestLog("Boiler model is not Selected from Dropdown", "Fail");  
            } 

		}
		if(boilerType == "no"){
			verifyAndClick(pageProperties.getProperty("repairAndCoverPage.notApplicableRadio"),"Not Applicable Radio is selected");
		}
		verifyAndClick(pageProperties.getProperty("repairAndCoverPage.boilerNextButton"),"Make and Model Button");
	}

	//// enter the card details for Repair Payment ////
	public void paymentForFixedPriceRepair(Acquisition acquisition){
        String ParentWindowHandle = browser.getWindowHandle();
        browser.selectWindowByName("repairPayiframe");
		verifyAndSelectDropDownBox(pageProperties.getProperty("repairAndCoverPage.cardType"),"Card Type",acquisition.getCardType());
		verifyAndInputById(pageProperties.getProperty("repairAndCoverPage.nameOnCard"), "Card Name", acquisition.getCardName());
		verifyAndInputById(pageProperties.getProperty("repairAndCoverPage.cardNumber"), "Card Number", acquisition.getCardNumber());
		//verifyAndInputByXpath(pageProperties.getProperty("repairAndCoverPage.cardNumberNew"), "Card Number", acquisition.getCardNumber());
		verifyAndSelectDropDownBox(pageProperties.getProperty("repairAndCoverPage.expireDay"),"Expire Day",acquisition.getExpiryMonth());
		verifyAndSelectDropDownBox(pageProperties.getProperty("repairAndCoverPage.expireYear"),"Expire Year",acquisition.getExpiryYear());
		//verifyAndInputByXpath(pageProperties.getProperty("repairAndCoverPage.cvvnew"), "CVV Number", acquisition.getCvvCode());
		verifyAndInputById(pageProperties.getProperty("repairAndCoverPage.cvvNumber"), "CVV Number", acquisition.getCvvCode());
		verifyAndInputById(pageProperties.getProperty("repairAndCoverPage.cvvnew"), "CVV Number", acquisition.getCvvCode());
		if(addrType == "sameAddr"){
			verifyAndClick(pageProperties.getProperty("repairAndCoverPage.sameAddr1"),"Same address for repair is selected");
		}
		if(addrType == "diffAddr"){
			verifyAndClick(pageProperties.getProperty("repairAndCoverPage.diffAddr1"),"Different address for repair is selected");
			verifyAndInputById(pageProperties.getProperty("repairAndCoverPage.billingPostCode1"), "Billing Post Code for repair", "TW18 3DW");
			verifyAndClick(pageProperties.getProperty("repairAndCoverPage.searchButton1"), "Search Button for repair Clicked");
			browser.wait(20000);
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("repairAndCoverPage.addrDropDownXpath"))){
				Select select = new Select(browser.getElementByXpath(pageProperties.getProperty("repairAndCoverPage.addrDropDownXpath")));
				select.selectByIndex(5);
				Report.updateTestLog("Address Selected from Dropdown", "Pass");  
			}
			else{
				Report.updateTestLog("Address is not Selected from Dropdown", "Fail");  
			}
		}
		verifyAndClick(pageProperties.getProperty("repairAndCoverPage.paymentNextButton"),"Next Button");
		browser.wait(5000);
		verifyAndClickWithXpath(".//*[@id='CompanyLogo']","Logic group");
		//verifyAndClickWithXpath(".//*[@id='btnSubmit']","3d submit Button");
        /*browser.selectWindow(ParentWindowHandle);*/
        browser.swtichToDefaultContent();
        browser.wait(5000);


	}

	public void paymentForMonthlyCover(Acquisition acquisition){
		browser.WaitForElementWithXpath(pageProperties.getProperty("repairAndCoverPage.monthlyDDXpath"));
		if(paymentType == "Monthly"){
			verifyAndClick(pageProperties.getProperty("repairAndCoverPage.monthlyDD"),"Monthly Direct Debit is selected");
		}
		if(paymentType == "Annual"){
			verifyAndClick(pageProperties.getProperty("repairAndCoverPage.annualDD"),"Annual Direct Debit is selected");
		}
		browser.wait(5000);
		///// entering payment Details ////
		verifyAndInputById(pageProperties.getProperty("repairAndCoverPage.acctNumber"),"Account Number",acquisition.getPaymentAccountNumber());
		verifyAndInputById(pageProperties.getProperty("repairAndCoverPage.sortCode1"),"Sort Code number1",acquisition.getSortCode1());
		verifyAndInputById(pageProperties.getProperty("repairAndCoverPage.sortCode2"),"Sort Code number2",acquisition.getSortCode2());
		verifyAndInputById(pageProperties.getProperty("repairAndCoverPage.sortCode3"),"Sort Code number3",acquisition.getSortCode3());
		verifyAndInputById(pageProperties.getProperty("repairAndCoverPage.acctHolderName"),"Account Holder Name",acquisition.getCardName());
		if(paymentType == "Monthly"){
		verifyAndSelectDropDownBox(pageProperties.getProperty("repairAndCoverPage.paymentDate"),"Payment Date",acquisition.getPayDay());
		}
		//// selecting billing address ////
		if(addrType == "sameAddr"){
			verifyAndClick(pageProperties.getProperty("repairAndCoverPage.sameAddr2"),"Same address for cover is selected");
		}
		if(addrType == "diffAddr"){
			verifyAndClick(pageProperties.getProperty("repairAndCoverPage.diffAddr2"),"Different address for cover is selected");
			verifyAndInputById(pageProperties.getProperty("repairAndCoverPage.billingPostCode2"), "Billing Post Code for cover", "NG9 2PU");
			verifyAndClick(pageProperties.getProperty("repairAndCoverPage.searchButton2"), "Search Button for cover Clicked");
			browser.WaitForElementWithXpath(pageProperties.getProperty("repairAndCoverPage.addrDropDownXpath"));
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("repairAndCoverPage.addrDropDownXpath"))){
				Select select = new Select(browser.getElementByXpath(pageProperties.getProperty("repairAndCoverPage.addrDropDownXpath")));
				select.selectByIndex(5);
				Report.updateTestLog("Address Selected from Dropdown", "Pass");  
			}
			else{
				Report.updateTestLog("Address is not Selected from Dropdown", "Fail");  
			}
		}
		verifyAndClick(pageProperties.getProperty("repairAndCoverPage.paymentNextButton1"),"Next Button");

	}
	
	public void enteringTermsAndConditions(UserProfile userProfile){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("repairAndCoverPage.homeCare200TandC"))){
			verifyAndClickWithXpath(pageProperties.getProperty("repairAndCoverPage.homeCare200TandC"),"Home care 200 terms and conditions clicked");
		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("repairAndCoverPage.oneOffRepairTandC"))){
			verifyAndClickWithXpath(pageProperties.getProperty("repairAndCoverPage.oneOffRepairTandC"),"One Off Repair terms and conditions clicked");
		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("repairAndCoverPage.assumptionsTandC"))){
			verifyAndClickWithXpath(pageProperties.getProperty("repairAndCoverPage.assumptionsTandC"),"Assumptions terms and conditions clicked");
		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("repairAndCoverPage.gasSafetyCertificationTandC"))){
			verifyAndClickWithXpath(pageProperties.getProperty("repairAndCoverPage.gasSafetyCertificationTandC"),"gasSafety Certification terms and conditions clicked");
		}
		selectMarketingConsent(userProfile);
		verifyAndClick(pageProperties.getProperty("repairAndCoverPage.placeOrder"),"Place order is clicked");
		browser.wait(20000);
		   browser.dynamicWaituntilVisiblebyXpath(pageProperties.getProperty("repairAndCoverPage.ThankYou"));
	}
	
	//Selecting Marketing Consent which are to be OptOut
    public void selectMarketingConsent(UserProfile userProfile){
    	 if(userProfile.getLetterConsent().equalsIgnoreCase("yes")){
    		 verifyAndClickWithXpath(pageProperties.getProperty("repairAndCoverPage.LetterConsent"), "Letter consent check box");
    	 }
    	 if(userProfile.getEmailConsent().equalsIgnoreCase("yes")){
    		 verifyAndClickWithXpath(pageProperties.getProperty("repairAndCoverPage.EmailConsent"), "Email consent check box"); 
    	 }
    	 if(userProfile.getLandlineConsent().equalsIgnoreCase("yes")){
    		 verifyAndClickWithXpath(pageProperties.getProperty("repairAndCoverPage.LandlineConsent"), "Landline consent check box");
    	 }
    	 if(userProfile.getMobileConsent().equalsIgnoreCase("yes")){
    		 verifyAndClickWithXpath(pageProperties.getProperty("repairAndCoverPage.MobileConsent"), "Mobile consent check box");
    	 }
    	 if(userProfile.getTextMessageConsent().equalsIgnoreCase("yes")){
    		 verifyAndClickWithXpath(pageProperties.getProperty("repairAndCoverPage.TextMessageConsent"), "TextMessage consent check box");
    	 }
    	 Report.updateTestLog("MarketingConsent Screenshot","WARN");  	    		
    }
	public void verifyThankYouPage(){
		browser.WaitForElementWithXpath(pageProperties.getProperty("repairAndCoverPage.accountNumber"));
		///// verifying confirmation message /////
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("repairAndCoverPage.confirmationMessage"))){
			String message = browser.getTextByXpath(pageProperties.getProperty("repairAndCoverPage.confirmationMessage"));
			Report.updateTestLog("Confirmation message:" +message+ "is displayed successfully", "Warn");
		}
		else{
			Report.updateTestLog("Error in Confirmation message", "Fail");
		}
		///// verifying Repair Address /////
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("repairAndCoverPage.repairAddrOnScreen"))){
			String repairAddr = browser.getTextByXpath(pageProperties.getProperty("repairAndCoverPage.repairAddrOnScreen"));
			Report.updateTestLog("Repair Address:" +repairAddr+ "is displayed successfully", "Pass");
		}
		else{
			Report.updateTestLog("Error in Repair Address", "Fail");
		}
		///// verifying Your appointment /////
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("repairAndCoverPage.yourAppointmentOnScreen"))){
			String appointment = browser.getTextByXpath(pageProperties.getProperty("repairAndCoverPage.yourAppointmentOnScreen"));
			String time = browser.getTextByXpath(pageProperties.getProperty("repairAndCoverPage.timeSlotOnScreen"));
			String apptTime = appointment+time;
			Report.updateTestLog("Repair Address:" +apptTime+ "is displayed successfully", "Pass");
		}
		else{
			Report.updateTestLog("Error in your appointment displayed", "Fail");
		} 
		//////// Printing account Number /////
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("repairAndCoverPage.accountNumber"))){
		String acctNum = browser.getTextByXpath(pageProperties.getProperty("repairAndCoverPage.accountNumber"));
		String displayedAcctNum[] = acctNum.split(" ");
		int length = displayedAcctNum.length;
		String dispAcctNum = displayedAcctNum[length-1];
		Report.updateTestLog("Account Number Created:" + dispAcctNum + "is displayed successfully", "Pass");
		}
		else {
			Report.updateTestLog("Account Number is not displayed successfully", "Fail");	
		}
	}
	public void anonymousAudit(UserProfile userProfile){
        String AuditDetails = new OnlineDBConnector().anonymousAudit(userProfile.getEmail());
        
               Report.updateTestLog("Audit Details = "+AuditDetails, "Pass");
        }
	
    public void verifyAnonymousRegis(){
    	browser.clickWithXpath("html/body/div[7]/div[1]/a");
        if(browser.isElementVisible("titleUserName")){
               Report.updateTestLog("Anonymous Customer has been registered succesfully", "WARN");
        }else{
               Report.updateTestLog("Anonymous Customer has not been registered succesfully", "Fail");
        }
        
 }

    
    public void anonymousRegistration(UserProfile userProfile){
        verifyAndClickWithXpath(pageProperties.getProperty("repairAndCoverPage.RegisterOnline"), "Register Online Link");
        verifyAndInputById(pageProperties.getProperty("repairAndCoverPage.custPassword"), "Password", userProfile.getPassword());
        verifyAndInputById(pageProperties.getProperty("repairAndCoverPage.custConfirmPassword"), "Password", userProfile.getPassword());
        verifyAndClick(pageProperties.getProperty("repairAndCoverPage.registerationTermsandcondition"), "registeration Terms and condition");
        verifyAndClick(pageProperties.getProperty("repairAndCoverPage.createaccount"), "Create Account");
        browser.wait(5000);
}
    
    public void loginVerification(){
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("repairAndCoverPage.AccountSummaryLink"))){
    		verifyAndClickWithXpath(pageProperties.getProperty("repairAndCoverPage.AccountSummaryLink"),"Account Summary Link");
    		Report.updateTestLog("Account Summary is clicked successfully", "WARN");
    	}
    	else{
    		Report.updateTestLog("Account Summary is not present in the application", "Fail");
    	}
    	//browser.clickWithXpath("html/body/div[7]/div[1]/a");
    	 if(browser.isElementVisibleWithXpath(".//*[@id='titleUserName']")){
             Report.updateTestLog("Customer Logged in succesfully", "WARN");
      }else{
             Report.updateTestLog("Customer is Not logged in succesfully", "Fail");
      }
    }



	
	public void verifyKACPriceValues(Acquisition acquisition){
		if (browser.isElementVisible(pageProperties.getProperty("repairAndCoverPage.ProductsFromDropBoxXpath"))){
			/*ArrayList<String> products = new ArrayList<String>();
			products = browser.getFromDropBox("id", pageProperties.getProperty("repairAndCoverPage.ProductsFromDropBoxXpath"));*/
			String products[] = {"Built-in electric hob","Built-in electric oven","Built-in gas hob","Built-in gas oven","Combined washer dryer","Dishwasher","Electric tumble dryer",
					"Free standing electric cooker","Free standing gas cooker","Fridge","Freezer","Fridge-freezer","Gas Tumble dryer","Microwave","Washing machine"};
			for(int i =1; i < products.length; i++){
				verifyAndSelectDropDownBox(pageProperties.getProperty("repairAndCoverPage.ProductsFromDropBoxXpath"),"KAC Products", products[i]);
				enterPostCode(acquisition);
				verifyAndSelectAppointmentSlot();
				String finalProduct =  products[i]+acquisition.getRegion();
				final KACPriceProfile kacPriceValue  = new TestDataHelper().getKACPriceProfile(finalProduct);
				//**************** monthly price verification *************** //
				String monthlyPrice = browser.getTextByXpath(pageProperties.getProperty("repairAndCoverPage.monthlyPayment"));
				if((kacPriceValue.getMonthlyPrice()).contains(monthlyPrice)){
					Report.updateTestLog("Monthly price verified Displayed :" + monthlyPrice + "expected:" + kacPriceValue.getMonthlyPrice() , "Pass");
				}
				else{
					Report.updateTestLog("Error in Monthly Price Displayed :" + monthlyPrice + "expected:" + kacPriceValue.getMonthlyPrice() , "Fail");
				}
				//*************** Annual price verification **************** //
				String annualPrice = browser.getTextByXpath(pageProperties.getProperty("repairAndCoverPage.annualPayment"));
				if((kacPriceValue.getAnnualPrice()).contains(annualPrice)){
					Report.updateTestLog("Annual price verified Displayed :" + annualPrice + "expected:" + kacPriceValue.getAnnualPrice() , "Pass");
				}
				else{
					Report.updateTestLog("Error in Annual Price Displayed :" + annualPrice + "expected:" + kacPriceValue.getAnnualPrice() , "Fail");
				}
				verifyAndClickWithXpath(pageProperties.getProperty("repairAndCoverPage.editAppointment"),"Edit Appointment");
				verifyAndClickWithXpath(pageProperties.getProperty("repairAndCoverPage.changeAddress"),"Change Address");
			}
		}
	}
	
	public void verifyLandlordPriceValues(Acquisition acquisition){
		String finalProduct =  "Landlord"+ acquisition.getRegion();
		final KACPriceProfile kacPriceValue  = new TestDataHelper().getKACPriceProfile(finalProduct);
		for(int i = 0; i<4 ;i++){
			for(int j = 0 ; j<4 ; j++){
				for(int k = 0;k<4 ; k++){
					verifyAndClick(pageProperties.getProperty("repairAndCoverPage.safetyYesOption"),"Gas Safety option yes");
					verifyAndSelectDropDownBox(pageProperties.getProperty("repairAndCoverPage.gasFire"),"Gas Fire", i+"");
					verifyAndSelectDropDownBox(pageProperties.getProperty("repairAndCoverPage.gasCooker"),"Gas Cooker", j+"");
					verifyAndSelectDropDownBox(pageProperties.getProperty("repairAndCoverPage.gasHob"),"Gas Hob", k+"");
					enterPostCode(acquisition);
					verifyAndSelectAppointmentSlot();
					/// ********************* Monthly price verification ********************* ///
					String monthlyPriceOnScr1 = browser.getTextByXpath(pageProperties.getProperty("repairAndCoverPage.monthlyPayment"));
					String monthlyPriceOnScr = monthlyPriceOnScr1.replace("£", "");    
					float monthlyPrice1 = Float.parseFloat(kacPriceValue.getMonthlyPrice());
					float monthlyPrice = (monthlyPrice1) + (float)((k * 2) + (j * 2) + (i * 3))+0;
					String monthlyPricing = String.valueOf(monthlyPrice)+0;
					Report.updateTestLog("***********  Products : 1 Boiler "  +i+"Gas Fire" +j+"Gas Cooker" +k+"Gas Hob" +"***********", "Pass");
					if(monthlyPricing.contains(monthlyPriceOnScr)){
						Report.updateTestLog("Monthly price verified Displayed :" + monthlyPriceOnScr + "expected:" + monthlyPricing , "Pass");
					}
					else{
						Report.updateTestLog("Error in Monthly Price Displayed :" + monthlyPriceOnScr + "expected:" + monthlyPricing , "Fail");
					}
					/// ********************* Annual price verification ********************* ///
					String annualPriceOnScr1 = browser.getTextByXpath(pageProperties.getProperty("repairAndCoverPage.annualPayment"));
					String annualPriceOnScr = annualPriceOnScr1.replace("£", "");  
					float annualPrice1 = Float.parseFloat(kacPriceValue.getAnnualPrice());
					float annualPrice2 = (annualPrice1) + (float)((k * 24) + (j * 24) + (i * 36))+0;
					String annualPricing = String.valueOf(annualPrice2)+0;
					if(annualPricing.contains(annualPriceOnScr)){
						Report.updateTestLog("Monthly price verified Displayed :" + annualPriceOnScr + "expected:" + annualPricing , "Pass");
					}
					else{
						Report.updateTestLog("Error in Monthly Price Displayed :" + annualPriceOnScr + "expected:" + annualPricing , "Fail");
					}
					verifyAndClickWithXpath(pageProperties.getProperty("repairAndCoverPage.editAppointment"),"Edit Appointment");
					verifyAndClickWithXpath(pageProperties.getProperty("repairAndCoverPage.changeAddress"),"Change Address");
					
				}
			}
		}
	}
}
