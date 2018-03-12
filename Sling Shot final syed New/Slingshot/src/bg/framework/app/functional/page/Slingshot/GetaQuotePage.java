package bg.framework.app.functional.page.Slingshot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.openqa.selenium.support.ui.Select;
import org.joda.time.DateTime;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.SlingshotErrorMessages;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.RunQTP;

public class GetaQuotePage extends BasePage {

	private final static String FILE_NAME = "resources/Slingshot/GetaQuote.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME)
			.load();
	SlingshotErrorMessages errormsg = new SlingshotErrorMessages();
	public static final String TIMESTAMP_FORMATTER = "dd MMMM, yyyy";
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Calendar cal = Calendar.getInstance();
	String functionResult;

	public void GetaquoteNavigation(String fueltype) {		
		if (fueltype.equals("Elec")) 
			{
			verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotepage.getaquoteelecNavigationLink"),"Get a Elec Quote");
		} else {
			verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotepage.getaquotegasNavigationLink"),"Get a gas Quote");
		}
	}
	public void GetaQuote(UserProfile userProfile) {
		verifyAndInputById(pageProperties.getProperty("GetaQuotepage.yourdetailsBusinessname"),"Business name", userProfile.getbusinessname());
		try {
			//String telephonevalue = browser.getTextByXpath(pageProperties.getProperty("GetaQuotepage.yourdetailstelephoneverify"));
			String telephonevalue =browser.getAttributeByXpath(pageProperties.getProperty("GetaQuotepage.yourdetailstelephoneverify"),"value");			
			System.out.println("telephonevalue" + telephonevalue);
			if (telephonevalue.equals("")) {
				System.out.println("i am in");
				verifyAndInputById(pageProperties.getProperty("GetaQuotepage.yourdetailstelephone"),"telephone", userProfile.getPhoneNumber());
				verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.yourdetailsnextbutton"),"Next");
				
			} 
			else if (telephonevalue != null) {
				verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.yourdetailsnextbutton"),"Next");
			}
		} catch (NullPointerException e) {
			System.out.println(e);
		}
	}
	public void validationsiteaddress(UserProfile userProfile, String Title) {
		verifyPageTitle(Title);
		verifyAndInputById(pageProperties.getProperty("GetaQuotePage.sitepageBuildingnumber"),"Buildingnameornumber",userProfile.getbuildingname());
		verifyAndInputById(pageProperties.getProperty("GetaQuotePage.sitepagepostcode"),"Postcode", userProfile.getPostCode());
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.FindAddressbutton"),"Find Address");
		browser.wait(3000);
		verifyAndSelectDropDownBoxbyindex(pageProperties.getProperty("GetaQuotePage.sitepageselectyouraddressdropdown"),1);
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.sitepageconfirmaddress"),"Confirm Address");
		browser.wait(2000);
		String Address = browser.getTextByXpath(pageProperties.getProperty("GetaQuotePage.sitepagefindaddress"));
		System.out.println("Address" + Address);
		if (Address.contains(userProfile.getPostCode())) {
			Report.updateTestLog("Building name /number and Postcode details are entered and populated as site address","PASS");
		} else {
			Report.updateTestLog("Building name /number and Postcode details are entered and populated as site address","Fail");
		}
		browser.wait(2000);
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.lastthreemonthsradioyes"),"Last three months yes");
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.gascontractradioyes"),"Gas Contract yes");
		if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetaQuotePage.startdateofnewcontract"))&&
				browser.isElementVisibleWithXpath(pageProperties.getProperty("GetaQuotePage.enddateofcurrentgascontract"))) {
			Report.updateTestLog("Gas contract 'Yes' is selected and Start date and End date options are Appears","Pass");
		} else {
			Report.updateTestLog("Gas contract 'Yes' is selected and Start date and End date options are Appears","Fail");
		}
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.gascontractradiono"),"Last three months no");
		if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetaQuotePage.startdateofnewcontract"))
				&& !browser.isElementVisibleWithXpath(pageProperties.getProperty("GetaQuotePage.enddateofcurrentgascontract"))) {
			Report.updateTestLog("Gas contract 'No' is selected  End date options are Appears","Pass");
		} else {
			Report.updateTestLog("Gas contract 'No' is selected   End date options are Appears","Fail");
		}
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.idontknowmygasconsumption"),"i dont know my gas consumption");
		if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetaQuotePage.Averagespend"))
				&& browser.isElementVisibleWithXpath(pageProperties.getProperty("GetaQuotePage.Every"))) {
			verifyAndSelectDropDownBox(pageProperties.getProperty("GetaQuotePage.Averagespend"),"Average spend", "£0 - £1,999");
			verifyAndSelectDropDownBox(pageProperties.getProperty("GetaQuotePage.Averagespend"),"every", "Quarter");
		}
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.canceliknowconsumptionlink"),"cancel i know consumption link");
		verifyAndInputById(pageProperties.getProperty("GetaQuotePage.consumptionunit"),"Consumption Unit", "23053");
		verifyAndSelectDropDownBoxbyindex(pageProperties.getProperty("GetaQuotePage.consumptioneverydropdown"),1);
		browser.wait(1000);
		enterFromDate(2);
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.quoteContinue"),"Continue");
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.removesitelink"),"Remove site link");
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.Back"), "Back link");
		}

	public void LargerbusinessOverlaydetails(UserProfile userProfile, String Title) {
		verifyPageTitle(Title);
		verifyAndInputById(pageProperties.getProperty("GetaQuotePage.sitepageBuildingnumber"),"Buildingnameornumber",userProfile.getbuildingname());
		verifyAndInputById(pageProperties.getProperty("GetaQuotePage.sitepagepostcode"),"Postcode", userProfile.getPostCode());
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.FindAddressbutton"),"Find Address");
		browser.wait(3000);
		verifyAndSelectDropDownBoxbyindex(pageProperties.getProperty("GetaQuotePage.sitepageselectyouraddressdropdown"),1);
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.sitepageconfirmaddress"),"Confirm Address");
		String Address = browser.getTextByXpath(pageProperties.getProperty("GetaQuotePage.sitepagefindaddress"));
		System.out.println("Address" + Address);
		if (Address.contains(userProfile.getPostCode())) {
			Report.updateTestLog("Building name /number and Postcode details are entered and populated as site address","PASS");
		} else {
			Report.updateTestLog("Building name /number and Postcode details are entered and populated as site address","Fail");
		}
		browser.wait(2000);
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.lastthreemonthsradioyes"),"Last three months yes");
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.gascontractradiono"),"Last three months no");
		verifyAndInputById(pageProperties.getProperty("GetaQuotePage.consumptionunit"),"Consumption Unit", "200000000000000");
		verifyAndSelectDropDownBoxbyindex(pageProperties.getProperty("GetaQuotePage.consumptioneverydropdown"),1);			
		enterFromDate(2);
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.quoteContinue"),"Continue");	
		}
	public void verifysiteaddress(UserProfile userProfile, String Title) {
		browser.wait(3000);
		verifyPageTitle(Title);
		verifyAndInputById(pageProperties.getProperty("GetaQuotePage.sitepageBuildingnumber"),"Buildingnameornumber", userProfile.getbuildingname());
		verifyAndInputById(pageProperties.getProperty("GetaQuotePage.sitepagepostcode"),"Postcode", userProfile.getPostCode());
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.FindAddressbutton"),"Find Address");
		browser.wait(3000);
		verifyAndSelectDropDownBoxbyindex(pageProperties.getProperty("GetaQuotePage.sitepageselectyouraddressdropdown"),1);
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.sitepageconfirmaddress"),"Confirm Address");
	}

	public void movedintosidelastthreemonths(UserProfile userProfile) {
		System.out.println("i am in method");
		browser.wait(2500);
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.lastthreemonthsradioyes"),"Last three months yes");
		browser.wait(1000);
		verifyAndInputById(pageProperties.getProperty("GetaQuotePage.consumptionunit"),"Consumption Unit",userProfile.getconsumptionunit());
		verifyAndSelectDropDownBoxbyindex(pageProperties.getProperty("GetaQuotePage.consumptioneverydropdown"),1);
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.gascontractradioyes"),"Gas Contract yes");
	}

	public void enterFromDate(int month) {
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.startdateofnewcontract"),"end date of your current contract");

		/*for (int i = 1; i <= month; i++) {
			System.out.println(" From Date Previous pickerclicked" + i);
			
			verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.PreviousDatePicker"),"PreviousDatePicker");
		}*/
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.NextdatepickerforFromdate"),"NextDatePicker");
		int days = DateTime.now().getDayOfMonth();
		String day = Integer.toString(days);
		calenderDate(day);
	}

	public String calenderDate(String day) {

		String result = "False";
		System.out.println("day"+day);
		browser.wait(4000);
		System.out.println(pageProperties.getProperty("GetaQuotePage.CalenderTable"));
		// int
		// rowcount=browser.getRowCountByXpath(pageProperties.getProperty("GetaQuotePage.CalenderTable"));
		int rowcount = 5;
		System.out.println("rowcount:" + rowcount);
		// int
		// columncount=browser.getColCountByXpath(pageProperties.getProperty("GetaQuotePage.CalenderTable"));
		int columncount = 7;
		System.out.println("columncount:" + columncount);

		for (int i = 1; i <= rowcount; i++) {

			for (int j = 1; j <= columncount; j++) {

				System.out.println(pageProperties.getProperty("GetaQuotePage.CalenderTable1")+ "//tr["+ i + "]/td[" + j + "]/a");
				if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetaQuotePage.CalenderTable1")+ "//tr["+ i + "]/td[" + j + "]/a")) {
					String dateThreeMonths = browser.getTextByXpath(pageProperties.getProperty("GetaQuotePage.CalenderTable1")+ "//tr[" + i + "]/td[" + j + "]/a");
					System.out.print("dateThreeMonths" + dateThreeMonths);
					System.out.print("i" + i);
					System.out.print("j" + j);
					;
					if (dateThreeMonths.equals(day)) {
						Report.updateTestLog("Day is matched:" + day, "pass");
						System.out.print(" matched i" + i);
						System.out.print("matched j" + j);
						System.out.print("date is matched");
						System.out.println(pageProperties.getProperty("GetaQuotePage.CalenderTable1")+ "/tr[" + i + "]/td[" + j + "]/a");
						browser.wait(5000);
						browser.clickWithXpath(pageProperties.getProperty("GetaQuotePage.CalenderTable1")+ "//tr[" + i + "]/td[" + j + "]/a");
						browser.wait(5000);
						result = "True";
						break;
					}
				}
			}
		}
		return result;
	}

	public void enterToDate() {
		int days = DateTime.now().getDayOfMonth();		
		System.out.println("days"+days);
		String day = Integer.toString(days);
		browser.wait(2000);
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.enddateofcurrentgascontract"),
				"Todate");
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.NextdatepickerforFromdate"),"NextDatePicker");
		calenderDate(day);
	}

	public void quotecontiue() {
		browser.wait(5000);
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.quoteContinue"),"Continue");
		
	}

	public void GetaQuoteLink() {
		browser.wait(10000);
		System.out.println("i am in GAQ buttton");
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.GetaQuotesubmit"),"Get a Quote");
		//browser.clickWithXpath(".//*[@id='getAQuoteSubmit']");
		System.out.println("i clicked GAQ");
		browser.wait(1000);
	}

	public void verifyManageAccountLink(UserProfile userProfile) {

		verifyAndClickWithXpath(
				pageProperties.getProperty("GetaQuotePage.ManageAccountLink")
						.replace("ACCOUNTNUMBER", userProfile.getAccNumber()),
				"Manage account link");
	}

	public void AnonymousGetaQuote(String fueltype) {
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetaQuotePage.GasandElec"),
				"Get a Submit");
		browser.wait(1000);
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetaQuotePage.Navigationlink"),
				"Get a Submit");
		
		
		if (fueltype.equals("Gas")) {
			verifyAndClickWithXpath(
					pageProperties
							.getProperty("GetaQuotepage.getaquotegasNavigationLink"),
					"Get a Gas Quote");
		} else if (fueltype.equals("Elec")) {
			verifyAndClickWithXpath(
					pageProperties
							.getProperty("GetaQuotepage.getaquoteelecNavigationLink"),
					"Get a Elec Quote");
		}
	}

	public void AnonymousGetaQuote_diffenv(String fueltype) {
		
		browser.wait(getWaitTime());
		browser.open(ApplicationConfig.APP_BG_URL+"/business/gas-and-electricity/get-a-quote");
		browser.wait(getWaitTime());
		//verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.GasandElec"),"Get a Submit");
		browser.wait(1000);		
		Report.updateTestLog("Get A Quote Page", "WARN");
		browser.wait(1000);		
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.GetaQuoteButtonNew"),"Get a Quote");
		browser.wait(1000);	
		Report.updateTestLog("Business Energy Quote Page Loaded", "WARN");
		browser.wait(1000);		
		//verifyIsElementVisibleWithXpath(pageProperties.getProperty("GetaQuotepage.getaquoteDual"),"i want a quote for both gas and electricity");
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("GetaQuotepage.getaquoteDualnew"),"i want a quote for both gas and electricity");
		
		//verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotepage.getaquotebutton"),"Get a Quote");
		
	if (fueltype.equals("Gas")) {
			//verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotepage.getaquotegasRHNlink"),"Get a Gas Quote");			
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotepage.GasRadiobutton"),"Get a Gas Quote");
		
		} else if (fueltype.equals("Elec")) {
			//verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotepage.getaquoteelecRHNlink"),"Get a Elec Quote");
			verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotepage.ElectRadiobutton"),"Get a Elec Quote");
		
		}
		else if (fueltype.equals("Dual")){
			
			verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotepage.getaquoteDual"),"Get a Dual Quote");
			
		}
		
		
	}
	public void enterFromDatereference(int month, int k) {
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetaQuotePage.startdateofnewcontractref")
						+ k + "']/fieldset/div/p/img",
				"Start date of your current contract");
		System.out.println("$%$$$$$$$$$$$$");
		System.out.println(pageProperties
				.getProperty("GetaQuotePage.startdateofnewcontractref")
				+ k
				+ "/fieldset/div/p/img");
		/*for (int i = 1; i <= month; i++) {
			System.out.println(" From Date Previous pickerclicked" + i);
			verifyAndClickWithXpath(
					pageProperties
							.getProperty("GetaQuotePage.PreviousDatePicker"),
					"PreviousDatePicker");
		}*/
		verifyAndClickWithXpath(
				pageProperties
						.getProperty("GetaQuotePage.NextdatepickerforFromdate"),
				"Nextmonthselector");
		int days = DateTime.now().getDayOfMonth();
		String day = Integer.toString(days);
		calenderDate(day);

	}

	public void AnonymousYourdetailspage(UserProfile userProfile) {
		//verifyAndSelectDropDownBoxbyindex(pageProperties.getProperty("GetaQuotePage.yourdetailstitle"), 1);
		/*verifyAndInputById(pageProperties.getProperty("GetaQuotePage.yourdetailsfirstname"),"Firstname", userProfile.getFirstName());
		verifyAndInputById(pageProperties.getProperty("GetaQuotePage.yourdetailssurname"),"last name", userProfile.getLastName());
		verifyAndInputById(pageProperties.getProperty("GetaQuotepage.yourdetailsBusinessname"),"Business name", userProfile.getbusinessname());
		verifyAndInputById(pageProperties.getProperty("GetaQuotePage.yourdetailsemail"),"Email", userProfile.getNewEmail());
		verifyAndInputById(pageProperties.getProperty("GetaQuotepage.yourdetailstelephone"),"telephone", userProfile.getPhoneNumber());*/
		browser.wait(1000);
		browser.wait(getWaitTime());
		System.out.println("GHHFGHDFHDFHDFHDFHDFh");
		/*verifyAndInputBycss(pageProperties.getProperty("GetaQuotePage.firstNameCSS"),"First Name", userProfile.getFirstName());
		verifyAndInputBycss(pageProperties.getProperty("GetaQuotePage.secondNameCSS"),"Last Name", userProfile.getLastName());
		verifyAndInputBycss(pageProperties.getProperty("GetaQuotePage.businessNameCSS"),"Business Name", userProfile.getbusinessname());
		verifyAndInputBycss(pageProperties.getProperty("GetaQuotePage.emailidCSS"),"Email ID", userProfile.getNewEmail());
		verifyAndInputBycss(pageProperties.getProperty("GetaQuotePage.telephoneCSS"),"Telephone Number", userProfile.getPhoneNumber());*/
		
		verifyAndInputByXpath(pageProperties.getProperty("GetaQuotePage.firstNameNew"),"Firstname", userProfile.getFirstName());
		verifyAndInputByXpath(pageProperties.getProperty("GetaQuotePage.secondNameNew"),"last name", userProfile.getLastName());
		verifyAndInputByXpath(pageProperties.getProperty("GetaQuotePage.businessNameNew"),"Business name", userProfile.getbusinessname());
		verifyAndInputByXpath(pageProperties.getProperty("GetaQuotePage.emailidNew"),"Email", userProfile.getNewEmail());
		verifyAndInputByXpath(pageProperties.getProperty("GetaQuotePage.telephoneNew"),"telephone", userProfile.getPhoneNumber());
		
		
		Report.updateTestLog("Details Entered Successfully", "WARN");
		//verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.yourdetailsnextbutton"),"Continue ");
		//Report.updateTestLog("Get a business energy quote details Page", "WARN");
		//Report.updateTestLog("Details are Optional", "WARN");
		
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.yourdetailsnextbuttonnew01"),"Continue button ");
		browser.wait(getWaitTime());
		browser.clickWithCss(pageProperties.getProperty("GetaQuotePage.CalculatemyquotebuttonNew"));
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		Report.updateTestLog("Quote summary Page","WARN");
		//String contractemail = browser.getTextByXpath(pageProperties.getProperty("GetaQuotePage.emailid"));
		/*String ReferenceNumber = browser.getTextByXpath(pageProperties.getProperty("GetaQuotePage.QuoteReferenceNumber"));
		Report.updateTestLog("In Get A Quote Reference Number is = "+ReferenceNumber, "PASS");*/
		browser.wait(getWaitTime());
	}
	public void Loggeddetailspage(UserProfile userProfile) {
		//verifyAndSelectDropDownBoxbyindex(pageProperties.getProperty("GetaQuotePage.yourdetailstitle"), 1);
		/*verifyAndInputById(pageProperties.getProperty("GetaQuotePage.yourdetailsfirstname"),"Firstname", userProfile.getFirstName());
		verifyAndInputById(pageProperties.getProperty("GetaQuotePage.yourdetailssurname"),"last name", userProfile.getLastName());
		verifyAndInputById(pageProperties.getProperty("GetaQuotepage.yourdetailsBusinessname"),"Business name", userProfile.getbusinessname());
		verifyAndInputById(pageProperties.getProperty("GetaQuotePage.yourdetailsemail"),"Email", userProfile.getNewEmail());
		verifyAndInputById(pageProperties.getProperty("GetaQuotepage.yourdetailstelephone"),"telephone", userProfile.getPhoneNumber());*/
		browser.wait(1000);
		browser.wait(getWaitTime());
		System.out.println("GHHFGHDFHDFHDFHDFHDFh");
		/*verifyAndInputBycss(pageProperties.getProperty("GetaQuotePage.firstNameCSS"),"First Name", userProfile.getFirstName());
		verifyAndInputBycss(pageProperties.getProperty("GetaQuotePage.secondNameCSS"),"Last Name", userProfile.getLastName());
		verifyAndInputBycss(pageProperties.getProperty("GetaQuotePage.businessNameCSS"),"Business Name", userProfile.getbusinessname());
		verifyAndInputBycss(pageProperties.getProperty("GetaQuotePage.emailidCSS"),"Email ID", userProfile.getNewEmail());
		verifyAndInputBycss(pageProperties.getProperty("GetaQuotePage.telephoneCSS"),"Telephone Number", userProfile.getPhoneNumber());*/
		
		/*verifyAndInputByXpath(pageProperties.getProperty("GetaQuotePage.firstNameNew"),"Firstname", userProfile.getFirstName());
		verifyAndInputByXpath(pageProperties.getProperty("GetaQuotePage.secondNameNew"),"last name", userProfile.getLastName());
		verifyAndInputByXpath(pageProperties.getProperty("GetaQuotePage.businessNameNew"),"Business name", userProfile.getbusinessname());
		verifyAndInputByXpath(pageProperties.getProperty("GetaQuotePage.emailidNew"),"Email", userProfile.getNewEmail());
		verifyAndInputByXpath(pageProperties.getProperty("GetaQuotePage.telephoneNew"),"telephone", userProfile.getPhoneNumber());*/
		
		
		Report.updateTestLog("Details Entered Successfully", "WARN");
		//verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.yourdetailsnextbutton"),"Continue ");
		//Report.updateTestLog("Get a business energy quote details Page", "WARN");
		//Report.updateTestLog("Details are Optional", "WARN");
		
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.yourdetailsnextbuttonnew01"),"Continue button ");
		browser.wait(getWaitTime());
		browser.clickWithCss(pageProperties.getProperty("GetaQuotePage.CalculatemyquotebuttonNew"));
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		Report.updateTestLog("Quote summary Page","WARN");
		//String contractemail = browser.getTextByXpath(pageProperties.getProperty("GetaQuotePage.emailid"));
		/*String ReferenceNumber = browser.getTextByXpath(pageProperties.getProperty("GetaQuotePage.QuoteReferenceNumber"));
		Report.updateTestLog("In Get A Quote Reference Number is = "+ReferenceNumber, "PASS");*/
		browser.wait(getWaitTime());
	}
	
	public void ContractYears() {
		browser.wait(getWaitTime());
		Select select = new Select(browser.getElementByXpath(pageProperties.getProperty("GetaQuotePage.Duration")));
		select.selectByIndex(1);
		browser.wait(getWaitTime());
		Report.updateTestLog("One Year contract is displayed Successfully", "WARN");
		browser.wait(getWaitTime());
		Select select1 = new Select(browser.getElementByXpath(pageProperties.getProperty("GetaQuotePage.Duration")));
		select1.selectByIndex(2);
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		Report.updateTestLog("Two Year contract is displayed Successfully", "WARN");
		browser.wait(getWaitTime());
		Select select2 = new Select(browser.getElementByXpath(pageProperties.getProperty("GetaQuotePage.Duration")));
		select2.selectByIndex(3);
		browser.wait(getWaitTime());
		Report.updateTestLog("Three Year contract is displayed Successfully", "WARN");

	}
	
	public void Sendmyquote() {
		browser.wait(getWaitTime());
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.Sendmyquote"),"Send My Quote");
		browser.wait(getWaitTime());
		Report.updateTestLog("Save Quote Screen is displayed Successfully", "WARN");
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.Savequote"),"Save Quote");
		browser.wait(getWaitTime());
		Report.updateTestLog("Quote has beed Saved Screen is displayed Successfully", "WARN");
	}
	
	
	
	public void verifyGasGetquotedetails(UserProfile userProfile) {
		Report.updateTestLog("Get a business energy quote details Page", "WARN");
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.yourdetailsnextbuttonnew"),"Continue button ");
		browser.wait(1000);
		SelectDate();
		browser.wait(getWaitTime());
	}
	
	
	public void SelectDate()
	{
		browser.wait(1000);
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotepage.DateContinuebutton"),"Continue button ");
	}
	public void SelectLoggedDate()
	{
		browser.wait(1000);
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.CalcContinue"),"Continue button ");
	}
		public void GAQsummary_saveaquote()
		{
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetaQuotePage.Loggedin"), "Log in");
		}
		public void validationsiteaddressnew01(UserProfile userProfile, String Title) {
			verifyPageTitle(Title);
			//verifyAndInputById(pageProperties.getProperty("GetaQuotePage.sitepageBuildingnumber"),"Buildingnameornumber",userProfile.getbuildingname());
			verifyAndInputById(pageProperties.getProperty("GetaQuotePage.sitepagepostcode"),"Postcode", userProfile.getPostCode());
			verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.FindAddressbutton"),"Find Address");
			browser.wait(getWaitTime());
			browser.wait(getWaitTime());
			//verifyAndSelectDropDownBoxbyindex(pageProperties.getProperty("GetaQuotePage.sitepageselectyouraddressdropdown"),1);
			Select select = new Select(browser.getElementByXpath(pageProperties.getProperty("GetaQuotePage.sitepageselectyouraddressdropdownnew")));
			select.selectByIndex(8);
			//verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.sitepageconfirmaddress"),"Confirm Address");
			browser.clickWithCss(pageProperties.getProperty("GetaQuotePage.sitepageconfirmaddressNew"));
			browser.wait(2000);
			browser.wait(2000);
			
			verifyAndInputByXpath(pageProperties.getProperty("GetaQuotePage.Consumption"),"Consumption Unit", "1000");
			Select selectnew = new Select(browser.getElementByXpath(pageProperties.getProperty("GetaQuotePage.EveryConsumptionNew")));
			selectnew.selectByIndex(3);
			browser.wait(1000);
			//enterFromDate(2);
			verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotepage.Continueenergybutton"),"Continue");
			//verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.removesitelink"),"Remove site link");
			//verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.Back"), "Back link");
			browser.wait(1000);
			browser.wait(1000);
			//verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotepage.Calculatemyquotebutton"),"Calculate my quote");
			browser.clickWithCss(pageProperties.getProperty("GetaQuotePage.CalculatemyquotebuttonNew"));
			browser.wait(getWaitTime());
			browser.wait(getWaitTime());
			browser.wait(getWaitTime());
			Report.updateTestLog("Quote summary Page","WARN");
			//String contractemail = browser.getTextByXpath(pageProperties.getProperty("GetaQuotePage.emailid"));
			String ReferenceNumber = browser.getTextByXpath(pageProperties.getProperty("GetaQuotePage.QuoteReferenceNumber"));
			Report.updateTestLog("In Get A Quote Reference Number is = "+ReferenceNumber, "PASS");
			
			}
		
		public void validationsiteaddressnew(UserProfile userProfile, String Title) {
			verifyPageTitle(Title);
			//verifyAndInputById(pageProperties.getProperty("GetaQuotePage.sitepageBuildingnumber"),"Buildingnameornumber",userProfile.getbuildingname());
			verifyAndInputById(pageProperties.getProperty("GetaQuotePage.sitepagepostcode"),"Postcode", userProfile.getPostCode());
			verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.FindAddressbutton"),"Find Address");
			browser.wait(getWaitTime());
			browser.wait(getWaitTime());
			//verifyAndSelectDropDownBoxbyindex(pageProperties.getProperty("GetaQuotePage.sitepageselectyouraddressdropdown"),1);
			Select select = new Select(browser.getElementByXpath(pageProperties.getProperty("GetaQuotePage.sitepageselectyouraddressdropdownnew")));
			select.selectByIndex(8);
			//verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.sitepageconfirmaddress"),"Confirm Address");
			browser.clickWithCss(pageProperties.getProperty("GetaQuotePage.sitepageconfirmaddressNew"));
			browser.wait(2000);
			browser.wait(2000);
			//verifyAndInputBycss(pageProperties.getProperty("GetaQuotePage.ConsumptionCSS"),"Consumption Unit", "1000");
			verifyAndInputByXpath(pageProperties.getProperty("GetaQuotePage.ConsumptionNew01"),"Consumption Unit", "1000");
			browser.wait(2000);
			Select selectnew = new Select(browser.getElementByXpath(pageProperties.getProperty("GetaQuotePage.ConsumptionEvery")));
			selectnew.selectByIndex(3);
			browser.wait(1000);
			//enterFromDate(2);
			verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotepage.Continueenergybutton"),"Continue");
			//verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.removesitelink"),"Remove site link");
			//verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.Back"), "Back link");
			browser.wait(1000);
			browser.wait(1000);
			//verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotepage.Calculatemyquotebutton"),"Calculate my quote");
			
			
			}
		
		public void validationmultiaddress(UserProfile userProfile, String Title) {
			
			browser.wait(getWaitTime());
			verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.AddAnothersite"),"Add Another Site");
			browser.wait(getWaitTime());
			verifyAndInputById(pageProperties.getProperty("GetaQuotePage.sitepagepostcode1"),"Postcode", userProfile.getPostCode1());
			verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.FindAddressbutton1"),"Find Address");
			browser.wait(getWaitTime());
			browser.wait(getWaitTime());
			
			Select select = new Select(browser.getElementByXpath(pageProperties.getProperty("GetaQuotePage.sitepageselectyouraddressdropdownnew1")));
			select.selectByIndex(8);
			
			browser.clickWithCss(pageProperties.getProperty("GetaQuotePage.sitepageconfirmaddressNew1"));
			browser.wait(2000);
			browser.wait(2000);
			//verifyAndInputBycss(pageProperties.getProperty("GetaQuotePage.ConsumptionCSS"),"Consumption Unit", "1000");
			verifyAndInputByXpath(pageProperties.getProperty("GetaQuotePage.ConsumptionNew02"),"Consumption Unit", "1000");
			browser.wait(2000);
			Select selectnew = new Select(browser.getElementByXpath(pageProperties.getProperty("GetaQuotePage.ConsumptionEvery")));
			selectnew.selectByIndex(3);
			browser.wait(1000);
			//enterFromDate(2);
			verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotepage.Continueenergybutton1"),"Continue");
			//verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.removesitelink"),"Remove site link");
			//verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.Back"), "Back link");
			browser.wait(1000);
			browser.wait(1000);
			//verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotepage.Calculatemyquotebutton"),"Calculate my quote");
			
			
			}

		public void Gasvalidationsiteaddressnew(UserProfile userProfile, String Title) {
			verifyPageTitle(Title);
			verifyAndInputById(pageProperties.getProperty("GetaQuotePage.sitepagepostcode"),"Postcode", userProfile.getPostCode());
			verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.FindAddressbutton"),"Find Address");
			browser.wait(getWaitTime());
			browser.wait(getWaitTime());
			//verifyAndSelectDropDownBoxbyindex(pageProperties.getProperty("GetaQuotePage.sitepageselectyouraddressdropdown"),1);
			Select select = new Select(browser.getElementByXpath(pageProperties.getProperty("GetaQuotePage.sitepageselectyouraddressdropdownnew")));
			select.selectByIndex(1);
			verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.sitepageconfirmaddress"),"Confirm Address");
			browser.wait(2000);
			browser.wait(2000);
			browser.wait(getWaitTime());
			verifyAndInputByXpath(pageProperties.getProperty("GetaQuotePage.Consumption"),"Consumption Unit", "1000");
			Select selectnew = new Select(browser.getElementByXpath(pageProperties.getProperty("GetaQuotePage.EveryConsumptionNew")));
			selectnew.selectByIndex(3);
			browser.wait(1000);
			//enterFromDate(2);
			verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotepage.Continueenergybutton"),"Continue");
			//verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.removesitelink"),"Remove site link");
			//verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.Back"), "Back link");
			browser.wait(1000);
			browser.clickWithCss(pageProperties.getProperty("GetaQuotePage.CalculatemyquotebuttonNew"));
			//verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotepage.Calculatemyquotebutton"),"Calculate my quote");
			browser.wait(getWaitTime());
			browser.wait(getWaitTime());
			Report.updateTestLog("Quote summary Page","WARN");
			}
		
	public void GetaQuotePageLoggedUser(UserProfile userProfile) {
		verifyPageTitle("Get A Quote");
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetaQuotePage.Loggedin"), "Log in");
		verifyAndInputById(pageProperties.getProperty("GetaQuotePage.Email"),
				"Email Id", userProfile.getNewEmail());
		verifyAndInputById(
				pageProperties.getProperty("GetaQuotePage.Password"),
				"Password", userProfile.getPassword());
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetaQuotePage.NewLoginSubmitXpath"),
				"Submit button");
		browser.clickWithXpath(pageProperties
				.getProperty("GetaQuotePage.logout"));
	}
	public void incompletesiteOverlay(UserProfile userProfile) {	
		browser.wait(2000);		
		//verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.addanothersite"),"Add another site");
		verifyAndClickWithLinkText("+ Add another site", "Add another site");
		verifyAndInputById(pageProperties.getProperty("GetaQuotePage.Buildingnamesecond"),"Buildingnameornumber", userProfile.getbuildingname());
		verifyAndInputById(pageProperties.getProperty("GetaQuotePage.postcodesecond"),"Postcode", userProfile.getPostCode());
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.findAddresssecond"),"Find Address");		
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.GetaQuotesubmit"),"Get a Submit");
		verifyIsTextPresent("You have an incomplete site");
		browser.wait(1000);
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.gobackandcompletesite"),"Go back and complete site");		
		browser.wait(2000);
		verifyAndSelectDropDownBoxbyindex(pageProperties.getProperty("GetaQuotePage.sitepageselectyouraddressdropdownsecond"),1);
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.sitepageconfirmaddresssecond"),"Confirm Address");
		 String jqueryToCloseOverlay=("$('ui-dialog-titlebar-close').trigger('click');");	 	
		 browser.executeScript(jqueryToCloseOverlay);
		}

	public void AddanothersitemaxiumGas(UserProfile userProfile) {
		int j, i,k;
		
		
		String buildingname[]={"24","88","86A","86B","HAY MANOR HOUSE","HAYTOR","BEECHES","KIELDER","WENLOCK","HOLLYOAK","OAKSFORD","THE OAKS","50","32","339","24"};
		String buildingpostcode[]={"B90 1PR","B90 1PS","B90 1PS","B90 1PS","B90 1PG","B90 1PP","B90 1PP","B90 1PP","B90 1PP","B90 1PP","B90 1PP","B90 1PP","B5 7UN","AB11 5BB","B5 7RY","B90 1PR"};			
		
		for (i = 1; i <= 16; i++) {
			j = i + 20;
			browser.wait(4000);
			verifyAndInputById(
					pageProperties.getProperty("GetaQuotePage.sitepageBuildingnumberref")
							+ i, "Buildingnameornumber",buildingname[i]);
			System.out.println(pageProperties
							.getProperty("GetaQuotePage.sitepageBuildingnumberref")
							+ i);
			verifyAndInputById(
					pageProperties.getProperty("GetaQuotePage.sitepagepostcoderef")
							+ i, "Postcode", buildingpostcode[i]);
			System.out.println(pageProperties
					.getProperty("GetaQuotePage.sitepagepostcoderef") + i);
			System.out.println(pageProperties.getProperty("GetaQuotePage.FindAddressbuttonref")
							+ i + "']");
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetaQuotePage.FindAddressbuttonref")
							+ i + "']", "Find Address");
			browser.wait(3000);
			verifyAndSelectDropDownBoxbyindex(
					pageProperties.getProperty("GetaQuotePage.sitepageselectyouraddressdropdownref")
							+ i, 1);
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetaQuotePage.sitepageconfirmaddressref")
							+ i + "']", "Confirm Address");
			browser.wait(2000);
			System.out.println(pageProperties
					.getProperty("GetaQuotePage.lastthreemonthsradioyesref")
					+ i + "']");
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetaQuotePage.lastthreemonthsradioyesref")
							+ i + "']", "Last three months yes");
			verifyAndInputById(
					pageProperties.getProperty("GetaQuotePage.consumptionunitref")
							+ i, "Consumption Unit", "1000");
			verifyAndSelectDropDownBoxbyindex(
					pageProperties.getProperty("GetaQuotePage.consumptioneverydropdownref")
							+ i, 1);
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetaQuotePage.gascontractradionoref")
							+ j + "']", "Gas Contract no");
			enterFromDatereference(2, i);
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetaQuotePage.quoteContinueref")
							+ i + "']", "Continue");
			browser.wait(4000);
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetaQuotePage.addanothersite"),
					"Add another site");
				}
		if (i == 16) {
			System.out.println("iiiiiiiiiiiii" + i);

			if (browser.isElementVisibleWithXpath(pageProperties
					.getProperty("GetaQuotePage.addanothersite"))) {
				Report.updateTestLog(
						"After the Successfull Addition of 15 sites Addsite option is disabled",
						"Fail");
			} else {
				Report.updateTestLog(
						"After the Successfull Addition of 15 sites Addsite option is disabled",
						"Pass");
			}
		
	}
	}
	public void AddanothersitemaxiumElec(UserProfile userProfile) {
		int j, i,k;		
		
		String buildingname[]={"25","15","2","54","4","117","96","5","98c","141","203","44","41","79","43","25"};
		String buildingpostcode[]={"B77 3JH","BN1 1ND","BN1 8RA","BN16 4DA","BN2 4FF","BH24 3AQ","BD8 8ES","BB7 9BY","BA16 0EN","B32 4ER","B31 3NS","B17 0RJ","B1 1DA","B12 0NH","B17 0AA","B77 3JH"};			
		
		for (i = 1; i <= 15; i++) {
			
			j = i + 20;
			browser.wait(4000);
			verifyAndInputById(
					pageProperties.getProperty("GetaQuotePage.sitepageBuildingnumberref")
							+ i, "Buildingnameornumber",buildingname[i]);
			System.out.println(pageProperties
							.getProperty("GetaQuotePage.sitepageBuildingnumberref")
							+ i);
			verifyAndInputById(
					pageProperties.getProperty("GetaQuotePage.sitepagepostcoderef")
							+ i, "Postcode", buildingpostcode[i]);
			System.out.println(pageProperties
					.getProperty("GetaQuotePage.sitepagepostcoderef") + i);
			System.out.println(pageProperties.getProperty("GetaQuotePage.FindAddressbuttonref")
							+ i + "']");
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetaQuotePage.FindAddressbuttonref")
							+ i + "']", "Find Address");
			browser.wait(3000);
			verifyAndSelectDropDownBoxbyindex(
					pageProperties.getProperty("GetaQuotePage.sitepageselectyouraddressdropdownref")
							+ i, 1);
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetaQuotePage.sitepageconfirmaddressref")
							+ i + "']", "Confirm Address");
			browser.wait(2000);
			System.out.println(pageProperties
					.getProperty("GetaQuotePage.lastthreemonthsradioyesref")
					+ i + "']");
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetaQuotePage.lastthreemonthsradioyesref")
							+ i + "']", "Last three months yes");
			verifyAndInputById(
					pageProperties.getProperty("GetaQuotePage.consumptionunitref")
							+ i, "Consumption Unit", "1000");
			verifyAndSelectDropDownBoxbyindex(
					pageProperties.getProperty("GetaQuotePage.consumptioneverydropdownref")
							+ i, 1);
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetaQuotePage.gascontractradionoref")
							+ j + "']", "Gas Contract no");
			enterFromDatereference(2, i);
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetaQuotePage.quoteContinueref")
							+ i + "']", "Continue");
			browser.wait(4000);
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetaQuotePage.addanothersite"),
					"Add another site");
			
		}
		if (i == 16) {
			System.out.println("iiiiiiiiiiiii" + i);

			if (browser.isElementVisibleWithXpath(pageProperties
					.getProperty("GetaQuotePage.addanothersite"))) {
				Report.updateTestLog(
						"After the Successfull Addition of 15 sites Addsite option is disabled",
						"Fail");
			} else {
				Report.updateTestLog(
						"After the Successfull Addition of 15 sites Addsite option is disabled",
						"Pass");
			}
		
	}
	}
	
	public void  requestcallbackLink()
	{
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetaQuotePage.requestacallback"),
				"Request a callback ");
	}

	public void requestcallbackdetailsPage(UserProfile userProfile) {
	
		verifyAndSelectDropDownBoxbyindex(
				pageProperties.getProperty("GetaQuotePage.title"), 1);
		verifyAndInputById(
				pageProperties.getProperty("GetaQuotePage.RCBfirstname"),
				"firstname", userProfile.getFirstName());
		verifyAndInputById(
				pageProperties.getProperty("GetaQuotePage.RCBlastname"),
				"lastname", userProfile.getLastName());
		verifyAndInputById(
				pageProperties.getProperty("GetaQuotePage.RCBemailAddress"),
				"email address", userProfile.getNewEmail());
		verifyAndInputById(
				pageProperties.getProperty("GetaQuotePage.RCBbusinessName"),
				"businessname", userProfile.getbusinessname());
		verifyAndInputById(
				pageProperties.getProperty("GetaQuotePage.RCBtelephoneNumber"),
				"telephone", userProfile.getPhoneNumber());
	/*	verifyAndInputById(
				pageProperties.getProperty("GetaQuotePage.RCBnoOfSites"),
				"no of sites", userProfile.getnoofsites());*/
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetaQuotePage.Callmeback"),
				"Call me back ");
	}
	public void requestcallbackdetailsPage_loggeduser(UserProfile userProfile) {
		
		verifyAndInputById(
				pageProperties.getProperty("GetaQuotePage.RCBbusinessName"),
				"businessname", userProfile.getbusinessname());
		verifyAndInputById(
				pageProperties.getProperty("GetaQuotePage.RCBtelephoneNumber"),
				"telephone", userProfile.getPhoneNumber());
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetaQuotePage.Callmeback"),
				"Call me back ");
		verifyPageTitle("Request a call back");
	}

	public void oneyearcontract() {
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.quoterefno_Savequote"),"Save a Quote ");
		browser.wait(2000);
		verifyIsTextPresent("Quote saved");		
		String jqueryToCloseOverlay=("$('a.ui-dialog-titlebar-close').trigger('click');");
		 browser.executeScript(jqueryToCloseOverlay);
		 Report.updateTestLog("Quote Saved Overlay is closed","Pass");	
		 browser.wait(3000);
	}
	public void twoyearcontract() {
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.twoyearcontract_tab"),"Two year contract ");
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.sitedetails_Savequotetwoyear"),"Save a Quote ");
		verifyIsTextPresent("Quote saved");		
		String jqueryToCloseOverlay=("$('a.ui-dialog-titlebar-close').trigger('click');");
		 browser.executeScript(jqueryToCloseOverlay);
		 Report.updateTestLog("Quote Saved Overlay is closed","Pass");		 
	}
	
	public void threeyearcontract() {
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.threeyearcontract_tab"),"Three year contract ");
		verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.sitedetails_Savequotethreeyear"),"Save a Quote ");
		verifyIsTextPresent("Quote saved");		
		String jqueryToCloseOverlay=("$('a.ui-dialog-titlebar-close').trigger('click');");
		 browser.executeScript(jqueryToCloseOverlay);
		 Report.updateTestLog("Quote Saved Overlay is closed","Pass");		 
	}

	public void verifyLeadTable_QuoteGenerationfornewEmail(
			UserProfile userProfile,String audittype,String trasactiontype) {
		
		try
		{
		OnlineDBConnector dbFunctions = new OnlineDBConnector();
		String date = dbFunctions.DBsysdateDdmmyyhhmi();
		String[] auditType = dbFunctions.getAuditEventTypeIdForGAQ(date,
				audittype,"Quote generated for the Email address",trasactiontype);
		System.out.println("auditType[0]" + auditType[0]);
		String data = dbFunctions.getAuditType(auditType[0]);
		Report.updateTestLog(
				"Audit id is made in audit table as expected. Audit id: "
						+ auditType[0] + " Audit event type is" + data,
				data.equalsIgnoreCase("BGBUSINESS_GET_A_QUOTE_SUCCESS") ? "PASS"
						: "FAIL");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void verifyLeadTable_Quoteunchangedstatuschangesuccess(
			UserProfile userProfile,String audittype,String trasactiontype) {
		try
		{
		OnlineDBConnector dbFunctions = new OnlineDBConnector();
		String date = dbFunctions.DBsysdateDdmmyyhhmi();
		String[] auditType = dbFunctions.getAuditEventTypeIdForGAQ(date,
				audittype,"Quote generated for the Email address",trasactiontype);
		System.out.println("auditType[0]" + auditType[0]);
		String data = dbFunctions.getAuditType(auditType[0]);
		Report.updateTestLog(
				"Audit id is made in audit table as expected. Audit id: "
						+ auditType[0] + " Audit event type is" + data,
				data.equalsIgnoreCase("BGBUSINESS_GET_A_QUOTE_UNSAVED_STATUS_CHANGE_SUCCESS") ? "PASS"
						: "FAIL");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void verifyLeadTable_Savequote(
			UserProfile userProfile,String email) {
		try
		{
		OnlineDBConnector dbFunctions = new OnlineDBConnector();
		String date = dbFunctions.DBsysdateDdmmyyhhmi();
		String[] auditType = dbFunctions.getAuditEventTypeIdForMUMV(date,
				email,
				"SAVE QUOTE :Success");
		System.out.println("auditType[0]" + auditType[0]);
		String data = dbFunctions.getAuditType(auditType[0]);
		Report.updateTestLog(
				"Audit id is made in audit table as expected. Audit id: "
						+ auditType[0] + " Audit event type is" + data,
				data.equalsIgnoreCase("BGBUSINESS_GET_A_QUOTE_SAVED_EMAIL_SENT_SUCCESS") ? "PASS"
						: "FAIL");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void verifyLeadTable_Journeyname(
			UserProfile userProfile,String email) {
		try
		{
		OnlineDBConnector dbFunctions = new OnlineDBConnector();
		String date = dbFunctions.DBsysdateDdmmyyhhmi();
		String[] auditType = dbFunctions.getAuditEventTypeIdForMUMV(date,
				email,
				"journyName:SAVED_LEAD;");
		System.out.println("auditType[0]" + auditType[0]);
		String data = dbFunctions.getAuditType(auditType[0]);
		Report.updateTestLog(
				"Audit id is made in audit table as expected. Audit id: "
						+ auditType[0] + " Audit event type is" + data,
				data.equalsIgnoreCase("BGBUSINESS_OPPORTUNITY_SUCCESS") ? "PASS"
						: "FAIL");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	public void verifyLeadTable_Unsavedstatuschangestatus(
						UserProfile userProfile,String email) {
		try
		{
		OnlineDBConnector dbFunctions = new OnlineDBConnector();
		String date = dbFunctions.DBsysdateDdmmyyhhmi();
		String[] auditType = dbFunctions.getAuditEventTypeIdForMUMV(date,
				email,
				"Quote generated for the Email address");
		System.out.println("auditType[0]" + auditType[0]);
		String data = dbFunctions.getAuditType(auditType[0]);
		Report.updateTestLog(
				"Audit id is made in audit table as expected. Audit id: "
						+ auditType[0] + " Audit event type is" + data,
				data.equalsIgnoreCase("BGBUSINESS_GET_A_QUOTE_UNSAVED_STATUS_CHANGE_SUCCESS") ? "PASS"
						: "FAIL");
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void verifyLeadTable_GAQ_opportinitystatus(UserProfile userProfile,String email) {
		try
		{
		OnlineDBConnector dbFunctions = new OnlineDBConnector();
		String date = dbFunctions.DBsysdateDdmmyyhhmi();
		String[] auditType = dbFunctions.getAuditEventTypeIdForMUMV(date,
				email, "UPDATE DETAILS :Success");
		System.out.println("auditType[0]" + auditType[0]);
		String data = dbFunctions.getAuditType(auditType[0]);
		Report.updateTestLog(
				"Audit id is made in audit table as expected. Audit id: "
						+ auditType[0] + " Audit event type is" + data,
				data.equalsIgnoreCase("BGBUSINESS_GET_A_QUOTE_UPDATE_DETAILS_SUCCESS") ? "PASS"
						: "FAIL");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		}

	public void verifyLeadTable_GAQcontactdetails(UserProfile userProfile,String email) {
		
		try
		{
		OnlineDBConnector dbFunctions = new OnlineDBConnector();
		String date = dbFunctions.DBsysdateDdmmyyhhmi();
		String[] auditType = dbFunctions.getAuditEventTypeIdForMUMV(date,
				email,
				"GetAQuoteContactDetailsSaving:success");
		System.out.println("auditType[0]" + auditType[0]);
		String data = dbFunctions.getAuditType(auditType[0]);
		Report.updateTestLog(
				"Audit id is made in audit table as expected. Audit id: "
						+ auditType[0] + " Audit event type is" + data,
				data.equalsIgnoreCase("BGBUSINESS_GET_A_QUOTE_SAVE_CONTACT_DETAILS_SUCCESS") ? "PASS"
						: "FAIL");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void verifyLeadTable_businesscreateprospect_status(
			UserProfile userProfile,String email) {
		browser.wait(5000);
		try
		{
		OnlineDBConnector dbFunctions = new OnlineDBConnector();
		String date = dbFunctions.DBsysdateDdmmyyhhmi();
		String[] auditType = dbFunctions.getAuditEventTypeIdForMUMV(date,
				email, "CREATE PROSPECT :Success");
		System.out.println("auditType[0]" + auditType[0]);
		String data = dbFunctions.getAuditType(auditType[0]);
		Report.updateTestLog(
				"Audit id is made in audit table as expected. Audit id: "
						+ auditType[0] + " Audit event type is" + data,
						data.equalsIgnoreCase("BGBUSINESS_CREATE_PROSPECT_SUCCESS") ? "PASS"
								: "FAIL");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public  String QuoteReferencenumber()
	{
		verifyPageTitle("Quote summary");
		String quoteno=browser.getTextByXpath(pageProperties.getProperty("GetaQuotePage.Quoteno"));
		System.out.println("quoteno"+quoteno);
		return quoteno;
	}
	public String Annualprice()
	{
		
		String annualpriceval=browser.getTextByXpath(pageProperties.getProperty("GetaQuotePage.Annualprice"));
		System.out.println("Annualprice"+annualpriceval);		
		return annualpriceval;	
	}
	
	public void Entersitedetails(UserProfile userProfile)
	{
		verifyAndInputById(
				pageProperties
						.getProperty("GetaQuotePage.sitepageBuildingnumber"),
				"Buildingnameornumber", userProfile.getbuildingname());
		verifyAndInputById(
				pageProperties.getProperty("GetaQuotePage.sitepagepostcode"),
				"Postcode", userProfile.getPostCode());
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetaQuotePage.FindAddressbutton"),
				"Find Address");
		browser.wait(3000);
		verifyAndSelectDropDownBoxbyindex(
				pageProperties
						.getProperty("GetaQuotePage.sitepageselectyouraddressdropdown"),
				1);
		verifyAndClickWithXpath(
				pageProperties
						.getProperty("GetaQuotePage.sitepageconfirmaddress"),
				"Confirm Address");
	}
    public void Deenergize()
    {
    	browser.wait(2000);
         	String displayedtext = browser.getTextByXpath(pageProperties.getProperty("GetaQuotePage.deenergisederrorpage")); 
         	System.out.println("displayedtext"+displayedtext);
    	if(displayedtext.contains(errormsg.GAQ_DeenergizedError))
    	{
    		Report.updateTestLog("De-energised error message is appears as expected","Pass");
    	}
    	else
    	{
    		Report.updateTestLog("De-energised error message is appears as expected","Fail");    		
    	}
    	
    }
    public void morefuelfound()
    {
         	String displayedtext = browser.getTextByXpath(".//*[contains(text(),'multiple meters')]"); 
          	System.out.println("displayedtext"+displayedtext);
    	if(displayedtext.contains(errormsg.GAQ_morefuelmeters))
    	{
    		Report.updateTestLog("Multiple meter error message is appears as expected","Pass");
    	}
    	else
    	{
    		Report.updateTestLog("Multiple meter error message is appears as expected","Fail");    		
    	}
    	
    }  
    public void verifybaddata()
    {    	
    	String displayedtext = browser.getTextByXpath(pageProperties.getProperty("GetaQuotePage.verifybaddatatext"));
    	System.out.println("displayedtext"+displayedtext);
    	if(displayedtext.equals(errormsg.GAQ_baddataError))
    	{
    		Report.updateTestLog("Bad data Error message is appears as expected","Pass");
    	}
    	else
    	{
    		Report.updateTestLog("Bad data Error message is appears as expected","Fail");    		
    	}    	
    }
    public void verifyhalfhourlymeterfound()
    {    	
    	browser.wait(2000);
    	String displayedtext = browser.getTextByXpath(pageProperties.getProperty("GetaQuotePage.verifyhalfhourmetererror")); 
    	System.out.println("displayedtext"+displayedtext);
    	if(displayedtext.equals(errormsg.GAQ_Halfhourlymeter))
    	{
    		
    		Report.updateTestLog("Half hourly meter found error message is appears as expected","Pass");
    	}
    	else
    	{
    		Report.updateTestLog("Half hourly meter found error message is appears as expected","Fail");    		
    	}    	
    }
    public void Requestcallback_GAQsummary(UserProfile userProfile)
    {
    	verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.Requestcallbacksummary"),"Request call back");
    	requestcallbackdetailsPage(userProfile);
    	verifyPageTitle("Request a call back");
    }
    
    public void largerbusinessOverlaycontinue()
    {
    	verifyIsTextPresent("Are you a larger Business?");    	
    	verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.contineuaslargebusienss"),"Continue as Large business");
    	verifyPageTitle("Get a quote");
    }
    public void largerbusinessOverlaycloseandeditvalues()
    {
    	browser.wait(1000);
    	verifyIsTextPresent("Are you a larger Business?");   
    	verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.closeandeditvalues")," close and edit values");
    	verifyAndInputById(pageProperties.getProperty("GetaQuotePage.consumptionunit"),"Consumption Unit", "2020");    	
    }
    
    public void Audit_GAQLeadTracking_Savelead(UserProfile userProfile,String quoterefno)
    {
    	browser.wait(3000);
    	try
    	{
    	OnlineDBConnector dbFunctions = new OnlineDBConnector();
		String date=dbFunctions.DBsysdateDdmmyyhhmi();		
		
		String data = dbFunctions.verifyAuditforGetAQTrading(date,userProfile.getNewEmail(),quoterefno);
		System.out.println("data"+data);
		Report.updateTestLog("Lead Status is made in Quote lead tracking table as expected and Quote Lead Status is"+data,data.equalsIgnoreCase("SAVED_LEAD")?"PASS":"FAIL");
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    }
    public void Audit_GAQLeadTracking_SaveleadLogged(UserProfile userProfile,String quoterefno)
    {
    	try
    	{
    	OnlineDBConnector dbFunctions = new OnlineDBConnector();
		String date=dbFunctions.DBsysdateDdmmyyhhmi();		
		
		String data = dbFunctions.verifyAuditforGetAQTrading(date,userProfile.getEmail(),quoterefno);
		System.out.println("data"+data);
		Report.updateTestLog("Lead Status is made in Quote lead tracking table as expected and Quote Lead Status is"+data,data.equalsIgnoreCase("SAVED_LEAD")?"PASS":"FAIL");
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    }
    
    public void GAQ_Anonyomousnavigatinlink()
    {    	
    	browser.clickGAQviamousemove();
    }
    public void GAQ_logged()
    {
    	verifyAndClickWithXpath(pageProperties.getProperty("GetaQuotePage.GAQlogged")," GAQ logged link");
    	
    }
    public void VerifySAPISU_GAQChange(UserProfile userProfile,String quoterefno,String annualprice){
	  	String Quoterefinapplication =quoterefno;
	  	System.out.println("Quoterefinapplication"+Quoterefinapplication);
	  	 String Annualpricelist=annualprice.substring(1,annualprice.length()-1);
	  	 System.out.println("Annualpricelist"+Annualpricelist);
	 // 	double Annualpricelistvalapp = Double.parseDouble(Annualpricelist);
	    
        String sapvaluestr1=Annualpricelist.replace(',',' ');
        String sapvaluespacestr1=sapvaluestr1.replace(" ","");      
        double Annualpricelistvalapp = Double.parseDouble(sapvaluespacestr1);
        System.out.println(Annualpricelistvalapp);
	  	System.out.println("FinalAnnualpriceEstimation for application"+Annualpricelistvalapp);
	  	
		RunQTP runQTP = new RunQTP();
	    System.out.println("Initiating QTP.............");
	   runQTP.runQTP("Slingshot\\src\\bg\\framework\\app\\functional\\util\\vbsScripts\\Renewal_price_vbscript.vbs", Quoterefinapplication);
	   System.out.println("QTP Process Over...........");

	   browser.wait(15000);
		try {
			System.out.println("*************************************");
			 File file1 = new File("D:\\Annualprice\\annualprice.txt");
             FileReader fr = new FileReader(file1);
             BufferedReader br = new BufferedReader(fr);
             String Annualprice = br.readLine();   
             System.out.println("Annualprice"+Annualprice);   
                     
         if(Annualprice.contains("Estimated Annual Price ")&& Annualprice.contains(":")){
                         String[] Annualpricevalue=Annualprice.split(":");
                         String AnnualEstimate=Annualpricevalue[1];
                         System.out.print("AnnualEstimate"+AnnualEstimate);
                         
                         String sapvaluestr=AnnualEstimate.replace(',',' ');
                         String sapvaluespacestr=sapvaluestr.replace(" ","");      
                         double appldouble = Double.parseDouble(sapvaluespacestr);
                         System.out.println(appldouble);
                         double sapval = appldouble;
                         double Finalestimationprice = sapval;
                         String str = String.format("%1.2f", Finalestimationprice);
                         Finalestimationprice = Double.valueOf(str);
                         System.out.println("Finalestimationprice"+Finalestimationprice);
                         
                         if(Annualpricelistvalapp== Finalestimationprice){
                                    Report.updateTestLog("Estimated Annual Price in Application"+Annualpricelistvalapp+"Estimated Annual Price in  SAP ISU :"+Finalestimationprice, "Pass");
                         }else{
                                    Report.updateTestLog("Estimated Annual Price in Application"+Annualpricelistvalapp+"Estimated Annual Price in  SAP ISU :"+Finalestimationprice, "Fail");
                         }
         }               				
			br.close();		
		  }
		     catch (IOException e) {
			        Report.updateTestLog("Exception while accessing the .txt file"+e, "Fail");
		}
}
    
}

