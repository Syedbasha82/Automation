package bg.framework.app.functional.page.Slingshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import bg.framework.app.functional.action.Slingshot.ContactUsBusinessAction;
import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.SlingshotErrorMessages;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

/**
 * @author 208070
 *
 */

public class ContactUsBusinessPage extends BasePage {

	private final static String FILE_NAME = "resources/Slingshot/ContactUs.Properties";     
	private static Properties PageProperties = new PropertyLoader(FILE_NAME).load();
	private static String Address;
	SlingshotErrorMessages errormsg = new SlingshotErrorMessages();

	public void navigatetoContactUslink() {
		verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.contactuslink"),"Contact Us");
	}

	public void verifyMyAccountandBilling() {
		browser.wait(9000);
		verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.Account&Billing"),"My Account and Billing");
		if(ApplicationConfig.BRAND.equalsIgnoreCase("BG")){
			ArrayList<String> list = new ArrayList<String>();
			list.add("ContactUs.SubmitMeterRead");
			list.add("Submit meter read");
			list.add("ContactUs.RequestCopyBill");
			list.add("Copy Bill Request - British Gas Business");
			list.add("ContactUs.ManageAccount");
			list.add("Your account - British Gas Business");
			list.add("ContactUs.RequestAcctStatement");
			list.add("Statement of Account - British Gas Business");
			list.add("ContactUs.UnderstandMyBill");
			list.add("How to Understand Your Bill - British Gas Business");
			list.add("ContactUs.ViewPaymentInfo");
			list.add("Ways To Pay your energy bill - British Gas Business");
			list.add("ContactUs.MovingPremise");
			list.add("Moving Premises - British Gas Business");
			list.add("ContactUs.SetupDD");
			list.add("Set up Direct Debit - British Gas Business");
			list.add("ContactUs.CheckIfBillCorrect");
			list.add("Checking if your bill is correct");
			list.add("ContactUs.WrongAddress");
			list.add("My bills are going to the wrong address");
			list.add("ContactUs.CreditBalance");
			list.add("Getting a refund on a credit balance");
			list.add("ContactUs.BillCalculated");
			list.add("How's my bill calculated?");
			list.add("ContactUs.PayBill");
			list.add("How can I pay my bill?");
			list.add("ContactUs.CreditNote");
			list.add("Why would I receive a credit note?");
			list.add("ContactUs.VATPayment");
			list.add("How much VAT am I paying?");
			list.add("ContactUs.ViewMoreHelp1");
			list.add("I need help with");
			for (int i=0;i<16;i=i+2) {
				System.out.println(list.get(i) + "       " + list.get(i+1));
				verifyLinksandTitle(list.get(i),list.get(i+1),"ContactUs.Account&Billing");
			}
			for (int i=16;i<list.size();i=i+2) {
				System.out.println(list.get(i) + "       " + list.get(i+1));
				verifyLinksandText(list.get(i),list.get(i+1),"ContactUs.Account&Billing");
			}
		}
	}
	private void verifyLinksandTitle(String link, String title, String Maintab) {
		int count =1, increment=1;
		String linkName = link.substring(link.indexOf('.') + 1, link.length());
		if(browser.isElementVisibleWithXpath(PageProperties.getProperty(link))) {
			Report.updateTestLog(linkName + " Link Exist", "PASS");
			browser.clickWithXpath(PageProperties.getProperty(link));
			do{
				getWaitTime();
				if(browser.getTitle().equalsIgnoreCase(title))
				{
					verifyPageTitle(title);
					break;
				}
				count++;
			}while(count<10);
			browser.browserBack();
			do{
				getWaitTime();
				if(browser.isElementVisibleWithXpath(PageProperties.getProperty(Maintab)))
				{
					browser.clickWithXpath(PageProperties.getProperty(Maintab));
					break;
				}
				increment++;
			}while(increment<10);
		 } 
		else {
			Report.updateTestLog(linkName + " Link not Exist", "FAIL");
		}
	}

	private void verifyLinksandText(String link, String text, String Maintab) {
		int count =1, increment=1;
		String linkName = link.substring(link.indexOf('.') + 1, link.length());
		if(browser.isElementVisibleWithXpath(PageProperties.getProperty(link))) {
			Report.updateTestLog(linkName + " Link Exist", "PASS");
			browser.clickWithXpath(PageProperties.getProperty(link));
			do{
				getWaitTime();
				if(browser.isTextPresent(text.trim()))
				{
					verifyIsTextPresent(text.trim());
					break;
				}
				count++;
			}while(count<10);
			browser.browserBack();
			do{
				getWaitTime();
				if(browser.isElementVisibleWithXpath(PageProperties.getProperty(Maintab)))
				{
					browser.clickWithXpath(PageProperties.getProperty(Maintab));
					break;
				}
				increment++;
			}while(increment<10);
		} 
		else {
			Report.updateTestLog(linkName + " Link not Exist", "FAIL");
		}
	}

	public void verifySwitchingtoBritishGas() {
		browser.wait(9000);
		verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.SwitchtoBG"),"Switching to British Gas");
		if(ApplicationConfig.BRAND.equalsIgnoreCase("BG")){
			ArrayList<String> list = new ArrayList<String>();
			list.add("ContactUs.ElectricityQuote");
			list.add("Business Electricity Quote | Get a Quote Today - British Gas Business");
			list.add("ContactUs.GasQuote");
			list.add("Business Gas Quote | Get a Gas Quote Today - British Gas Business");
			list.add("ContactUs.DualFuelQuote");
			list.add("Online Business Energy Quote - British Gas Business");
			list.add("ContactUs.SMEwithMultipleSites");
			list.add("Get a Quote | Multi-Site Quote - British Gas Business");
			list.add("ContactUs.ViewOurProductsandServices");
			list.add("Online business energy quote - British Gas Business");
			list.add("ContactUs.ElectricitySwitchingProcess");
			list.add("Switching Process - British Gas Business");
			list.add("ContactUs.GasSwitchingProcess");
			list.add("Switching Process - British Gas Business");
			list.add("ContactUs.BritishGasBusiness");
			list.add("Terms and Conditions - British Gas Business");
			list.add("ContactUs.BecomeBGBCustomer");
			list.add("Becoming a British Gas Business customer");
			list.add("ContactUs.CurrentSupplierIntimation");
			list.add("Letting my current supplier know I'm moving to British Gas Business");
			list.add("ContactUs.ElectricityandGasSupplyNumbers");
			list.add("My electricity and gas supply numbers");
			list.add("ContactUs.AccountTransferTimes");
			list.add("Account transfer times");
			list.add("ContactUs.ViewMoreHelp2");
			list.add("I need help with");
			for (int i=0;i<16;i=i+2) {
				System.out.println(list.get(i) + "       " + list.get(i+1));
				verifyLinksandTitle(list.get(i),list.get(i+1),"ContactUs.SwitchtoBG");
			}
			for (int i=16;i<list.size();i=i+2) {
				System.out.println(list.get(i) + "       " + list.get(i+1));
				verifyLinksandText(list.get(i),list.get(i+1),"ContactUs.SwitchtoBG");
			}
		}
	}
	public void verifyMyMeterReadingsandMeter() {
		browser.wait(9000);
		verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.MyMeterReadings&Meter"),"My Meter Readings and Meter");
		if(ApplicationConfig.BRAND.equalsIgnoreCase("BG")){
			ArrayList<String> list = new ArrayList<String>();
			list.add("ContactUs.SubmitElectricityMeterReading");
			list.add("Electricity meter read – Your details");
			list.add("ContactUs.SubmitGasReading");
			list.add("Gas meter read – Your details");
			list.add("ContactUs.SignUpMeterReadReminders");
			list.add("Meter reading reminders - British Gas Business");
			list.add("ContactUs.HowtoReadGasMeter");
			list.add("How To Read Your Meter - Your account - British Gas Business");
			list.add("ContactUs.HowtoReadElectricityMeter");
			list.add("How To Read Your Meter - Your account - British Gas Business");
			list.add("ContactUs.SubmitIPhoneRead");
			list.add("Download our Smartphone App - British Gas Business");
			list.add("ContactUs.HowtoUnderstandBill");
			list.add("How to Understand Your Bill - British Gas Business");
			list.add("ContactUs.WhatsMySupplyNumber");
			list.add("What is my meter supply number and where can I find it?");
			list.add("ContactUs.CheckMyMeterAccurate");
			list.add("Checking your meter is accurate");
			list.add("ContactUs.UpdateMeterReadings");
			list.add("Updating your meter reading");
			list.add("ContactUs.ProblemswithSubmitMeterRead");
			list.add("Having problems submitting a meter reading");
			list.add("ContactUs.ServicesandInstallationOnNewSite");
			list.add("Arranging for services and installations on a new site");
			list.add("ContactUs.CostofConnectionsandMetering");
			list.add("The cost of connections and metering");
			list.add("ContactUs.Planning&PayingforConnection");
			list.add("Planning and paying for your connections");
			list.add("ContactUs.GettingaRefundOnCreditBalance");
			list.add("Getting a refund on a credit balance");
			list.add("ContactUs.ViewMoreHelp3");
			list.add("I need help with...");
			for (int i=0;i<14;i=i+2) {
				System.out.println(list.get(i) + "       " + list.get(i+1));
				verifyLinksandTitle(list.get(i),list.get(i+1),"ContactUs.MyMeterReadings&Meter");
			}
			for (int i=14;i<list.size();i=i+2) {
				System.out.println(list.get(i) + "       " + list.get(i+1));
				verifyLinksandText(list.get(i),list.get(i+1),"ContactUs.MyMeterReadings&Meter");
			}
		}
	}

	public void verifyMovingPremises() {
		browser.wait(9000);
		verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.MovingPremises"),"Moving Premises");
		if(ApplicationConfig.BRAND.equalsIgnoreCase("BG")){
			ArrayList<String> list = new ArrayList<String>();
			list.add("ContactUs.MovingOutOfaProperty");
			list.add("Moving Premises - British Gas Business");
			list.add("ContactUs.MovingIntoaProperty");
			list.add("Moving Premises - British Gas Business");
			list.add("ContactUs.InformationRequiredWhenMovingPremises");
			list.add("What to do before I move");
			list.add("ContactUs.SupplyEnergytoMyNewPremises");
			list.add("How long will the moving premises process take?");
			list.add("ContactUs.MovingorSellingMySites");
			list.add("What if I need supply to both premises for a period of time during my move?");
			list.add("ContactUs.ViewMoreHelp4");
			list.add("I need help with...");
			for (int i=0;i<4;i=i+2) {
				System.out.println(list.get(i) + "       " + list.get(i+1));
				verifyLinksandTitle(list.get(i),list.get(i+1),"ContactUs.MovingPremises");
			}
			for (int i=4;i<list.size();i=i+2) {
				System.out.println(list.get(i) + "       " + list.get(i+1));
				verifyLinksandText(list.get(i),list.get(i+1),"ContactUs.MovingPremises");
			}
		}
	}


	public void verifyBreakdownandServices() {
		browser.wait(9000);
		verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.Breakdown&Servicing"),"Breakdown and Servicing");
		if(ApplicationConfig.BRAND.equalsIgnoreCase("BG")){
			ArrayList<String> list = new ArrayList<String>();
			list.add("ContactUs.BusinessHeatingCare");
			list.add("Boiler maintenance and repair - Annual Boiler Service - British Gas");
			list.add("ContactUs.GasServicing");
			list.add("Gas compliance - British Gas Business");
			list.add("ContactUs.GasBreakdowns");
			list.add("Boiler maintenance and repair - Annual Boiler Service - British Gas");
			list.add("ContactUs.GasInstallations");
			list.add("Gas installation – British Gas Business");
			list.add("ContactUs.ElectricityTestBill");
			list.add("Electrical compliance - British Gas Business");
			list.add("ContactUs.RemedialWorks&LightingMaintenance");
			list.add("Electrical maintenance - British Gas Business");
			list.add("ContactUs.ReactiveElectricalMaintenance");
			list.add("Electrical maintenance - British Gas Business");
			list.add("ContactUs.ElectricalEngineeringServices");
			list.add("Electrical Installation - British Gas Business");
			list.add("ContactUs.PayingforBusinessHeatingCare");
			list.add("Paying for BusinessCare");
			list.add("ContactUs.BusinessHeatingCareContract");
			list.add("How long is a BusinessCare contract?");
			list.add("ContactUs.BusinessHeatingCareHelp");
			list.add("BusinessCare");
			list.add("ContactUs.StartContractandInspectSystem");
			list.add("Starting your contract and inspecting your system");
			list.add("ContactUs.BreakdownCallouts");
			list.add("Breakdown callouts");
			list.add("ContactUs.BusinessHeatingCareforallBoilers");
			list.add("Is BusinessCare available for all types of boilers?");
			list.add("ContactUs.ViewMoreHelp5");
			list.add("I need help with...");
			for (int i=0;i<16;i=i+2) {
				System.out.println(list.get(i) + "       " + list.get(i+1));
				verifyLinksandTitle(list.get(i),list.get(i+1),"ContactUs.Breakdown&Servicing");
			}
			for (int i=16;i<list.size();i=i+2) {
				System.out.println(list.get(i) + "       " + list.get(i+1));
				verifyLinksandText(list.get(i),list.get(i+1),"ContactUs.Breakdown&Servicing");
			}
		}

	}

	public void navigatetoEmailContactUslink(String tab) {
	//	verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.GetinTouchwithBGlink"),"Do you want to get in touch with British Gas");
		String Number="0";
		if(tab=="MyAccountandBilling"){

			Number="1";
		}
		else if(tab=="SwitchingtoBG"){

			Number="2";
		}
		else if(tab=="MyMeterReadingsandMeter"){

			Number="3";
		}
		else if(tab=="MovingPremises"){

			Number="4";
		}
		else if(tab=="BreakdownandServices"){

			Number="5";
		}
		verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.Emailcontactuslink").replace("NUM", Number),"Email Us");
		browser.wait(4000);
		verifyPageTitle("Email us");
	}
	
	public void verifyEmailUs(String tab) {
		int Indicator=0;
		String MyAccountandBilling[]={"Meter read", "Balance", "Name and address change", "Billing", "Online", "Payments", "Copy bill", "Statement of account", "Refunds", "Letter of authority", "CRC statements", "Annual consumption", "All other queries"};
		String SwitchingtoBG[]={"Switching to us", "Switch - rates and tarriffs", "All other queries"};
		String MyMeterReadingsandMeter[]={"My readings", "Meter reading enquiry", "New meter", "Upgrades", "New supply", "All other queries"};
		String MovingPremises[]={"Moving out of my current premises", "Moving into a premises", "All other queries"};
		String BreakdownandServices[]={"Boiler", "Electrical breakdowns", "24/7 emergency call out", "All other queries"};
		String Alltabs[]=new String[15];
		if(tab=="MyAccountandBilling"){

			Alltabs=MyAccountandBilling;
		}
		else if(tab=="SwitchingtoBG"){

			Alltabs=SwitchingtoBG;
		}
		else if(tab=="MyMeterReadingsandMeter"){

			Alltabs=MyMeterReadingsandMeter;
		}
		else if(tab=="MovingPremises"){

			Alltabs=MovingPremises;
		}
		else if(tab=="BreakdownandServices"){

			Alltabs=BreakdownandServices;
		}
		List<String> Accounts = browser.getFromDropBox("id", PageProperties.getProperty("ContactUs.AcctNoEmailUs"));
		browser.selectfromDropBox("id",PageProperties.getProperty("ContactUs.AcctNoEmailUs"), Accounts.get(1));
		Report.updateTestLog(Accounts.get(1)+ " is Selected", "PASS");
		List<String> Query = browser.getFromDropBox("id", PageProperties.getProperty("ContactUs.QueryEmailUs"));
		for(int search=1;search<Query.size();search++)
		{
			for(int array=0;array<(Alltabs.length);array++)
			{
				if(Query.get(search).equals(Alltabs[array])){
					Report.updateTestLog(Query.get(search) + " is available in the Query DropDown", "PASS");
					Indicator=1;
					continue;
				}
			}
			if(Indicator!=1)
			{
				Report.updateTestLog(Query.get(search) + " is not available in the Query DropDown", "FAIL");
			}
		}
		browser.browserBack();
		browser.wait(2000);
	}

	public void selectMyAccountandBillingtab() {
		verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.Account&Billing"),"My Account and Billing");
	}
	public void selectSwitchingtoBGtab() {
		verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.SwitchtoBG"),"Switching to British Gas");
	}
	public void selectMyMeterReadingsandMetertab() {
		verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.MyMeterReadings&Meter"),"My Meter Readings and Meter");
	}
	public void selectMovingPremisestab() {
		verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.MovingPremises"),"Moving Premises");
	}
	public void selectBreakdownandServicestab() {
		verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.Breakdown&Servicing"),"Breakdown and Servicing");
	}
	public void logout(){
		verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.Logout"), "Log out link");
	}

	public void selectTab(String tab) {
		if(tab=="MyAccountandBilling"){
			verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.Account&Billing"),"My Account and Billing");
		}
		else if(tab=="SwitchingtoBG"){
			verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.SwitchtoBG"),"Switching to British Gas");
		}
		else if(tab=="MyMeterReadingsandMeter"){
			verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.MyMeterReadings&Meter"),"My Meter Readings and Meter");
		}
		else if(tab=="MovingPremises"){
			verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.MovingPremises"),"Moving Premises");
		}
		else if(tab=="BreakdownandServices"){
			verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.Breakdown&Servicing"),"Breakdown and Servicing");
		}
		
	}
	public void SearchFuctionality(String search, String content, String tab) {
		String value="0";
		if(tab=="MyAccountandBilling"){
			value="1";
		}
		else if(tab=="SwitchingtoBG"){
			value="2";
		}
		else if(tab=="MyMeterReadingsandMeter"){
			value="3";
		}
		else if(tab=="MovingPremises"){
			value="4";
		}
		else if(tab=="BreakdownandServices"){
			value="5";
		}
		verifyIsTextPresent("What are you looking for?");
		if(browser.isElementVisibleWithXpath(PageProperties.getProperty("ContactUs.SearchTextbox").replace("NUM", value))){
			verifyAndInputByXpath(PageProperties.getProperty("ContactUs.SearchTextbox").replace("NUM", value),"Search Text Field", search);
			verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.SearchButton").replace("NUM", value), "Search button");
			browser.wait(1000);
			verifyIsTextPresent(content);
		}
		else
		{
			Report.updateTestLog("Search Text Box is not available in the Screen", "FAIL");	
		}
		browser.browserBack();
	}

	public void verifyLHN() {
		browser.wait(getWaitTime());
		//verifyIsTextPresent(PageProperties.getProperty("ContactUs.EmailUslink"), "Email Us");
		verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.BusinessComplaintLink"), "Making a Business Complaint");
		browser.wait(getWaitTime());
		verifyPageTitle("Making a business complaint");
	}

	public void verifyWhereCanIFindThisLink() {
		verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.Wherecanifindthis"), "Where Can I Find This?");
		verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.Close"), "Close");
	}

	public void AddressCapturing() {
		Address=browser.getTextByXpath(PageProperties.getProperty("ContactUs.Address"));
		System.out.println("Address in the Account Overview Screen: " + Address);
	}

	public void verifyAddressinEmailUs(UserProfile userprofile) {
		int Increment=0;
		Address=(Address.substring(Address.indexOf(":")+1,Address.length())).trim();
		System.out.println("Address after Trim: " + Address);
		String AddressAcctOverview[]= Address.split(",");
		System.out.println("Address in array: " + Arrays.asList(AddressAcctOverview));
		browser.selectfromDropBox("id",PageProperties.getProperty("ContactUs.AcctNoEmailUs"), userprofile.getAccNumber());
		for(int i=0;i<AddressAcctOverview.length;i++)
		{
			String AddressEmailUs = browser.getTextByXpath(PageProperties.getProperty("ContactUs.AddressEmailUs").replace("NUM", ""+(i+1)));
			System.out.println("Address in screen: " + AddressEmailUs);
			if((AddressAcctOverview[i].trim()).contains((AddressEmailUs).trim()))
			{
				System.out.println("Address in the Account Overview Screen: " + AddressAcctOverview[i] + "Address in the Email Us Screen: " + AddressEmailUs );
				Increment++;
			}
		}
		if(Increment==AddressAcctOverview.length)
		{
			Report.updateTestLog("Address is displayed correctly on the Screen :" + Arrays.asList(AddressAcctOverview) , "PASS");	
		}
		else
		{
			Report.updateTestLog("Address is not displayed correctly on the Screen", "FAIL");	
		}
	}

	public void verifyConfirmationinEmailUsLoggedInCust(UserProfile userprofile) {
		verifyAndSelectDropDownBox(PageProperties.getProperty("ContactUs.AcctNoEmailUs"), "Account Number", userprofile.getAccNumber());
		verifyAndSelectDropDownBox(PageProperties.getProperty("ContactUs.QueryEmailUs"), "Query regarding", "Balance");
		verifyAndInputById(PageProperties.getProperty("ContactUs.yourquery"),"Description","Test Mail");
		verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.submit"), "Submit");
		verifyConfirmationinPage(userprofile);
	}

	public void verifyConfirmationinPage(UserProfile userprofile) {
		browser.wait(5000);
		verifyPageTitle("Confirmation");
		verifyIsTextPresent("Thank you for contacting us");
		verifyIsTextPresent(userprofile.getAccNumber());
		verifyIsTextPresent("A member of our team will contact you within one working day");
		//	verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.SubmitMeterRead"), "Submit Meter Read");
		//	browser.wait(2000);
		//	verifyPageTitle("Submit meter read");
		//	browser.browserBack();
		//	verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.MakeAPayment"), "Make A Payment");
		//	browser.wait(2000);
		//	verifyPageTitle("Submit meter read");
		//	browser.browserBack();
		//	verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.ViewYourBills"), "View Your Bills");
		//	browser.wait(2000);
		//	verifyPageTitle("Submit meter read");
		//	browser.browserBack();
		//	verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.DirectDebit"), "Direct Debit");
		//	browser.wait(2000);
		//	verifyPageTitle("Set up Direct Debit");
		//	browser.browserBack();
		//	verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.BacktoContactUs"), "Back to Contact Us");
		//	browser.wait(2000);
		//	verifyPageTitle("Email us");
		//	browser.browserBack();
		OnlineDBConnector dbFunctions = new OnlineDBConnector();
		String date=dbFunctions.DBsysdateDdmmyyhhmi();
		String[] auditType = dbFunctions.getAuditEventTypeIdMany(date, userprofile.getEmail(),"contactus");
		String data = dbFunctions.getAuditType(auditType[0]);	
		String data1 = dbFunctions.getAuditType(auditType[2]);	
		System.out.println(Arrays.asList(auditType));
		Report.updateTestLog("Audit id is made in audit table as expected. Audit id: "+auditType[0]+ " Audit event type is"+data, data.equalsIgnoreCase("BGB_CONTACTUS_COMPLAINTS_EMAIL_SENT_SUCCESS")?"PASS":"FAIL");
		Report.updateTestLog("Audit id is made in audit table as expected. Audit id: "+auditType[2]+ " Audit event type is"+data1, data1.equalsIgnoreCase("BGB_CONTACTUS_COMPLAINTS_SUCCESS")?"PASS":"FAIL");
	}
	
	public ContactUsBusinessPage validateFirstName(UserProfile userProfile, String Cust, String Wordings) {
		String[] firstname={"","1212","first12345","firstname*","fistrtname;","!qwer23", "		"};
		for(int i=0;i<firstname.length;i++){

			verifyAndSelectDropDownBox(PageProperties.getProperty("ContactUs.QueryEmailUs"), "Query Regarding", "Balance");
			verifyAndInputById(PageProperties.getProperty("ContactUs.FirstName"), "First Name", firstname[i]);
			verifyAndInputById(PageProperties.getProperty("ContactUs.SurName"),"Surname",userProfile.getLastName().trim());
			verifyAndInputById(PageProperties.getProperty("ContactUs.BusinessName"),"BusinessName","BG Agency");
			verifyAndInputById(PageProperties.getProperty("ContactUs.EmailAddress"),"EmailAddress",userProfile.getEmail().trim());
			verifyAndInputById(PageProperties.getProperty("ContactUs.TelephoneNumber"),"MobileNo",userProfile.getMobileNumber().trim());
			verifyAndClick(PageProperties.getProperty("ContactUs."+Cust), Wordings);
			verifyAndInputById(PageProperties.getProperty("ContactUs.Postcode"),"Postcode",userProfile.getPostCode().trim());
			verifyAndClick(PageProperties.getProperty("ContactUs.FindAddress"), "Find Address Button");
			waitForObjectExistance(PageProperties.getProperty("ContactUs.EnterAddressManually"),"id");
			List<String> Address = browser.getFromDropBox("id", PageProperties.getProperty("ContactUs.SelectAddress"));
			System.out.println(Arrays.asList(Address));
			browser.selectfromDropBox("id",PageProperties.getProperty("ContactUs.SelectAddress"), Address.get(1));
			verifyAndInputById(PageProperties.getProperty("ContactUs.AcctNoEmailUs"),"Account Number",userProfile.getAccNumber().trim());
			verifyAndInputById(PageProperties.getProperty("ContactUs.yourquery"),"Description","Test Mail");
			verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.submit"), "Submit");
			validateFirstnameError(userProfile,i);
			Address.clear();
		}
		return this;
	}
	public ContactUsBusinessPage validateFirstnameError(UserProfile userProfile,int status){
		String errormsgvalue = "null", errormsgvalue1="null";
		browser.wait(4000);
		verifyIsTextPresent("Sorry, we need you to look at the following areas of the form again");
		verifyIsTextPresent("We're missing or don't recognise some of the information in:");
		try{
			errormsgvalue=browser.getTextByXpath(PageProperties.getProperty("ContactUs.ErrorinTable"));
			System.out.println(errormsgvalue);
			errormsgvalue=(errormsgvalue.substring(errormsgvalue.indexOf(":")+1,errormsgvalue.length())).trim();
			System.out.println(errormsgvalue);
			errormsgvalue1=browser.getTextByXpath(PageProperties.getProperty("ContactUs.ErrorRegisterPage"));
			System.out.println(errormsgvalue1);
		}catch(Exception e){
			Report.updateTestLog("Unable to locate the Error msg Xpath :"+e,"Fail");	
		}
		switch (status){

		case 0:
			Report.updateTestLog("Error Msg in Table: Expected Result: "+errormsg.EmailUs_FirstnameEmpty+"Actual Result: "+errormsgvalue,errormsgvalue.contains(errormsg.EmailUs_FirstnameEmpty)?"Pass":"Fail");
			Report.updateTestLog("Error Msg by Field: Expected Result: "+errormsg.EmailUs_FirstnameEmpty+"Actual Result: "+errormsgvalue1,errormsgvalue1.contains(errormsg.EmailUs_FirstnameEmpty)?"Pass":"Fail");
			break;
		case 1:
			Report.updateTestLog("Error Msg in Table: Expected Result: "+errormsg.EmailUs_FirstnameNumeric+"Actual Result: "+errormsgvalue,errormsgvalue.contains(errormsg.EmailUs_FirstnameNumeric)?"Pass":"Fail");
			Report.updateTestLog("Error Msg by Field: Expected Result: "+errormsg.EmailUs_FirstnameNumeric+"Actual Result: "+errormsgvalue1,errormsgvalue1.contains(errormsg.EmailUs_FirstnameNumeric)?"Pass":"Fail");
			break;
		case 2:
			Report.updateTestLog("Error Msg in Table: Expected Result: "+errormsg.EmailUs_FirstnameAplhanumeric+"Actual Result: "+errormsgvalue,errormsgvalue.contains(errormsg.EmailUs_FirstnameAplhanumeric)?"Pass":"Fail");
			Report.updateTestLog("Error Msg by Field: Expected Result: "+errormsg.EmailUs_FirstnameAplhanumeric+"Actual Result: "+errormsgvalue1,errormsgvalue1.contains(errormsg.EmailUs_FirstnameAplhanumeric)?"Pass":"Fail");
			break;
		case 3:	
			Report.updateTestLog("Error Msg in Table: Expected Result: "+errormsg.EmailUs_FirstnameStar+"Actual Result: "+errormsgvalue,errormsgvalue.contains(errormsg.EmailUs_FirstnameStar)?"Pass":"Fail");
			Report.updateTestLog("Error Msg by Field: Expected Result: "+errormsg.EmailUs_FirstnameStar+"Actual Result: "+errormsgvalue1,errormsgvalue1.contains(errormsg.EmailUs_FirstnameStar)?"Pass":"Fail");
			break;
		case 4:
			Report.updateTestLog("Error Msg in Table: Expected Result: "+errormsg.EmailUs_FirstnameSemi+"Actual Result: "+errormsgvalue,errormsgvalue.contains(errormsg.EmailUs_FirstnameSemi)?"Pass":"Fail");
			Report.updateTestLog("Error Msg by Field: Expected Result: "+errormsg.EmailUs_FirstnameSemi+"Actual Result: "+errormsgvalue1,errormsgvalue1.contains(errormsg.EmailUs_FirstnameSemi)?"Pass":"Fail");
			break;

		case 5:
			Report.updateTestLog("Error Msg in Table: Expected Result: "+errormsg.EmailUs_FirstnameSpecAlphaNum+"Actual Result: "+errormsgvalue,errormsgvalue.contains(errormsg.EmailUs_FirstnameSpecAlphaNum)?"Pass":"Fail");
			Report.updateTestLog("Error Msg by Field: Expected Result: "+errormsg.EmailUs_FirstnameSpecAlphaNum+"Actual Result: "+errormsgvalue1,errormsgvalue1.contains(errormsg.EmailUs_FirstnameSpecAlphaNum)?"Pass":"Fail");
			break;
		case 6:
			Report.updateTestLog("Error Msg in Table: Expected Result: "+errormsg.EmailUs_FirstnameTabs+"Actual Result: "+errormsgvalue,errormsgvalue.contains(errormsg.EmailUs_FirstnameTabs)?"Pass":"Fail");
			Report.updateTestLog("Error Msg by Field: Expected Result: "+errormsg.EmailUs_FirstnameTabs+"Actual Result: "+errormsgvalue1,errormsgvalue1.contains(errormsg.EmailUs_FirstnameTabs)?"Pass":"Fail");
			break;
		}

		return this;
	}

	public void validateEnterAddressManually(UserProfile userProfile, String Cust, String Wordings) {
		verifyAndSelectDropDownBox(PageProperties.getProperty("ContactUs.QueryEmailUs"), "Query Regarding", "Balance");
		verifyAndInputById(PageProperties.getProperty("ContactUs.FirstName"), "First Name", userProfile.getFirstName().trim());
		verifyAndInputById(PageProperties.getProperty("ContactUs.SurName"),"Surname",userProfile.getLastName().trim());
		verifyAndInputById(PageProperties.getProperty("ContactUs.BusinessName"),"BusinessName","BG Agency");
		verifyAndInputById(PageProperties.getProperty("ContactUs.EmailAddress"),"EmailAddress",userProfile.getEmail().trim());
		verifyAndInputById(PageProperties.getProperty("ContactUs.TelephoneNumber"),"MobileNo",userProfile.getMobileNumber().trim());
		verifyAndClick(PageProperties.getProperty("ContactUs."+ Cust), Wordings);
		verifyAndInputById(PageProperties.getProperty("ContactUs.Postcode"),"Postcode",userProfile.getPostCode().trim());
		verifyAndClick(PageProperties.getProperty("ContactUs.FindAddress"), "Find Address Button");
		waitForObjectExistance(PageProperties.getProperty("ContactUs.EnterAddressManually"),"id");
		verifyAndClick(PageProperties.getProperty("ContactUs.EnterAddressManually"), "Enter Your Address Manually");
		verifyAndInputById(PageProperties.getProperty("ContactUs.FlatNumber"),"Flat Number","Unit 5");
		verifyAndInputById(PageProperties.getProperty("ContactUs.Address1"),"Address 1","Greenfield Farm Industrial Estate");
		verifyAndInputById(PageProperties.getProperty("ContactUs.PostalTown"),"Postal Town","CONGLETON");
		browser.selectfromDropBox("id",PageProperties.getProperty("ContactUs.County"), "Cheshire");
		verifyAndInputById(PageProperties.getProperty("ContactUs.PostCode"),"PostCode","CW12 4TR");
		verifyAndInputById(PageProperties.getProperty("ContactUs.AcctNoEmailUs"),"Account Number",userProfile.getAccNumber().trim());
		verifyAndInputById(PageProperties.getProperty("ContactUs.yourquery"),"Description","Test Mail");
		verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.submit"), "Submit");
		verifyConfirmationinPage(userProfile);

	}


}
