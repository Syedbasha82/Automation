/**
 * 
 */
package bg.framework.app.functional.page.Slingshot;

import java.util.Arrays;
import java.util.Properties;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import static bg.framework.app.functional.entities.FunctionalCategory.BGBRegistration;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import static bg.framework.app.functional.entities.FunctionalCategory.Slingshot;
import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;
import bg.framework.app.functional.common.ApplicationConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import bg.framework.app.functional.action.Slingshot.ContactUsBusinessAction;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.TestDataHelper;
import bg.framework.common.functional.UIDriver;
import bg.framework.common.functional.WebDriverProvider;

/**
 * @author 208070
 *
 */
public class ConnectionsandMeteringPage extends BasePage {
	private final static String FILE_NAME1 = "resources/Slingshot/ConnectionsandMetering.Properties";
	private static Properties CMProperties = new PropertyLoader(FILE_NAME1).load();
	static String TelephoneNo;
	public void retrieveTelephoneNo(UserProfile userProfile) {
		verifyAndClickWithLinkText("Update your details", "Update your details");
		browser.wait(3000);
		verifyAndInputByXpath(CMProperties.getProperty("CM.MobileNo"), "TelephoneNumber", userProfile.getMobileNumber());
		verifyAndClickWithXpath(CMProperties.getProperty("CM.SaveChanges"),"Save Changes");
		}

	public void navigatetoConnectionsandMetering() {
		
		browser.open(ApplicationConfig.APP_BG_URL+"/business/connection-metering/requestacallback/your-details");
		
		//browser.clickWithXpath(CMProperties.getProperty("CM.Connetions&Metering"));
		browser.wait(10000);
		//verifyPageTitle("Connections and metering - British Gas Business");
		//verifyAndClickWithXpath(CMProperties.getProperty("CM.Callmebacklink"),"Call me back");
		browser.wait(getWaitTime());
		//verifyIsTextPresent("Request a callback");
		
	}

	
public void navigatetoConnectionsandMeteringNew() {
	browser.wait(2000);
	browser.open(ApplicationConfig.APP_BG_URL+"/business/gas-and-electricity/connections-and-metering");
		browser.wait(2000);
		//verifyPageTitle("Connections and metering - British Gas Business");
		verifyAndClickWithXpath(CMProperties.getProperty("CM.Callmebacklink"),"Call me back");
		browser.wait(getWaitTime());
		verifyIsTextPresent("Request a callback");
		
	}
	

	public void validateCMPageAnonymous(UserProfile userProfile,String strLink, String WR){
		verifyAndEnterCMPage(userProfile);
		verifyAndEnterrequestCMPage("Anonymous", userProfile, strLink, WR);
		verifyAndCloseThankYou("Anonymous", userProfile, strLink);
	}
	public void validateCMPageLoggedIn(String loggedIn, UserProfile userProfile,String strLink, String WR){
		verifyAndEnterrequestCMPage("LoggedIn", userProfile, strLink, WR);
		verifyAndCloseThankYou("LoggedIn", userProfile, strLink);
	}
	public void validateCMPageLoggedInNew(String loggedIn, UserProfile userProfile,String strLink, String WR){
		verifyAndEnterrequestCMPageNew("LoggedIn", userProfile, strLink, WR);
		verifyAndCloseThankYou("LoggedIn", userProfile, strLink);
	}

	public void verifyAndEnterCMPage(UserProfile userProfile){
		verifyAndSelectDropDownBoxByXpath(CMProperties.getProperty("CM.Title"), "Title", userProfile.getTitle());
		verifyAndInputByXpath(CMProperties.getProperty("CM.Firstname"), "FirstName", userProfile.getFirstName());
		verifyAndInputByXpath(CMProperties.getProperty("CM.Surname"), "SurName", userProfile.getLastName());
		verifyAndInputByXpath(CMProperties.getProperty("CM.BusinessName"), "BusinessName", userProfile.getCompanyName());
		verifyAndInputByXpath(CMProperties.getProperty("CM.TelephoneNo"), "TelephoneNumber", userProfile.getMobileNumber());
		verifyAndInputByXpath(CMProperties.getProperty("CM.email"), "Email", userProfile.getEmail());
		verifyAndInputByXpath(CMProperties.getProperty("CM.postCode"), "PostCode", userProfile.getPostCode());
		verifyAndClickWithXpath(CMProperties.getProperty("CM.BGBCustomer"),"NO - BGB Customer");
		
		browser.wait(getWaitTime());
	}
	
	
	public void updateCMPage(){
		/*if(UserLogin.equals("LoggedIn"))
		{
			verifyAndInputByXpath(CMProperties.getProperty("CM.TelephoneNo"), "TelephoneNumber", userProfile.getMobileNumber());
		}
		if(strLink=="Gas")
		{
			verifyAndClickWithXpath(CMProperties.getProperty("CM.Gas"),"Business Gas");
			verifyAndSelectDropDownBoxByXpath(CMProperties.getProperty("CM.GasRequest"), "Gas Work Request", "New gas supply pipework & meter");
			verifyAndClickWithXpath(CMProperties.getProperty("CM.GasWorkRequestWhatsThis"), "WorkRequest - What's this? Link");
			verifyIsTextPresent("Work request guide");
			verifyAndClickWithXpath(CMProperties.getProperty("CM.GasWorkRequestWhatsThisContentClose"), "WorkRequest - What's this? Close Link");
		}
		else if(strLink=="Electricity")
		{
			verifyAndClickWithXpath(CMProperties.getProperty("CM.Electricity"),"Business Electricity");
			verifyAndSelectDropDownBoxByXpath(CMProperties.getProperty("CM.ElectricityRequest"), "Electricity Work Request", WR);
			verifyAndClickWithXpath(CMProperties.getProperty("CM.ElecWorkRequestWhatsThis"), "WorkRequest - What's this? Link");
			verifyIsTextPresent("Work request guide");
			verifyAndClickWithXpath(CMProperties.getProperty("CM.ElecWorkRequestWhatsThisContentClose"), "WorkRequest - What's this? Close Link");
		}
		else if(strLink=="Both")
		{
			verifyAndClickWithXpath(CMProperties.getProperty("CM.Both"),"Both");
			verifyAndSelectDropDownBoxByXpath(CMProperties.getProperty("CM.GasRequest"), "Gas Work Request", "New gas supply pipework & meter");
			verifyAndSelectDropDownBoxByXpath(CMProperties.getProperty("CM.ElectricityRequest"), "Electricity Work Request", "New electricity supply cable & meter");
			verifyAndClickWithXpath(CMProperties.getProperty("CM.GasWorkRequestWhatsThis"), "WorkRequest - What's this? Link");
			verifyIsTextPresent("Work request guide");
			verifyAndClickWithXpath(CMProperties.getProperty("CM.GasWorkRequestWhatsThisContentClose"), "WorkRequest - What's this? Close Link");
			verifyAndClickWithXpath(CMProperties.getProperty("CM.ElecWorkRequestWhatsThis"), "WorkRequest - What's this? Link");
			verifyIsTextPresent("Work request guide");
			verifyAndClickWithXpath(CMProperties.getProperty("CM.ElecWorkRequestWhatsThisContentClose"), "WorkRequest - What's this? Close Link");
		}*/

		//verifyIsTextPresent("Select callback time");
		verifyAndClickWithXpath(CMProperties.getProperty("CM.Time"), "AM (9 -1)");
		verifyAndClickWithXpath(CMProperties.getProperty("CM.ConnectionMeter"), "Business Gas");
		verifyAndInputByXpath(CMProperties.getProperty("CM.PostCodeNew"), "Comments", "SL4 5GD");
     //verifyIsTextPresent("Calls will be made Monday to Friday excluding any Bank Holidays");
		verifyAndInputByXpath(CMProperties.getProperty("CM.comments"), "Comments", "Request a call back");
		//verifyAndClickWithXpath(CMProperties.getProperty("CM.contact"), "Products and other services");
		Report.updateTestLog("Gas And Electricity Meter Page", "WARN");
		verifyAndClickWithXpath(CMProperties.getProperty("CM.callmeback"), "Call me back button");
		browser.wait(getWaitTime());
		Report.updateTestLog("Confirmation Page is displayed", "WARN");
	}

	public void updateCMPageAnonymous(UserProfile userProfile){
	
		browser.wait(1000);
		verifyAndClickWithXpath(CMProperties.getProperty("CM.ConnectionMeter"), "Business Gas"); 
		verifyAndSelectDropDownBoxByXpath(CMProperties.getProperty("CM.Title"), "Title", userProfile.getTitle());
		verifyAndInputByXpath(CMProperties.getProperty("CM.Firstname"), "FirstName", userProfile.getFirstName());
		verifyAndInputByXpath(CMProperties.getProperty("CM.Surname"), "SurName", userProfile.getLastName());
		verifyAndInputByXpath(CMProperties.getProperty("CM.TelephoneNo"), "TelephoneNumber", userProfile.getMobileNumber());
		verifyAndInputByXpath(CMProperties.getProperty("CM.email"), "Email", userProfile.getEmail());
		verifyAndInputByXpath(CMProperties.getProperty("CM.postCode"), "PostCode", userProfile.getPostCode());
		verifyAndClickWithXpath(CMProperties.getProperty("CM.Time"), "AM (9 -1)");
		verifyAndInputByXpath(CMProperties.getProperty("CM.comments"), "Comments", "Request a call back");
		Report.updateTestLog("Gas And Electricity Meter Page", "WARN");
		verifyAndClickWithXpath(CMProperties.getProperty("CM.callmeback"), "Call me back button");
		
		verifyAndClickWithXpath(CMProperties.getProperty("CM.callmebackcontinue"), "Call me back button");
		browser.wait(getWaitTime());
		Report.updateTestLog("Confirmation Page is displayed", "WARN");
	}
	
	
	
	public void verifyAndEnterrequestCMPage(String UserLogin, UserProfile userProfile,String strLink, String WR){
		if(UserLogin.equals("LoggedIn"))
		{
			verifyAndInputByXpath(CMProperties.getProperty("CM.TelephoneNo"), "TelephoneNumber", userProfile.getMobileNumber());
		}
		if(strLink=="Gas")
		{
			verifyAndClickWithXpath(CMProperties.getProperty("CM.Gas"),"Business Gas");
			verifyAndSelectDropDownBoxByXpath(CMProperties.getProperty("CM.GasRequest"), "Gas Work Request", "New gas supply pipework & meter");
			verifyAndClickWithXpath(CMProperties.getProperty("CM.GasWorkRequestWhatsThis"), "WorkRequest - What's this? Link");
			verifyIsTextPresent("Work request guide");
			verifyAndClickWithXpath(CMProperties.getProperty("CM.GasWorkRequestWhatsThisContentClose"), "WorkRequest - What's this? Close Link");
		}
		else if(strLink=="Electricity")
		{
			verifyAndClickWithXpath(CMProperties.getProperty("CM.Electricity"),"Business Electricity");
			verifyAndSelectDropDownBoxByXpath(CMProperties.getProperty("CM.ElectricityRequest"), "Electricity Work Request", WR);
			verifyAndClickWithXpath(CMProperties.getProperty("CM.ElecWorkRequestWhatsThis"), "WorkRequest - What's this? Link");
			verifyIsTextPresent("Work request guide");
			verifyAndClickWithXpath(CMProperties.getProperty("CM.ElecWorkRequestWhatsThisContentClose"), "WorkRequest - What's this? Close Link");
		}
		else if(strLink=="Both")
		{
			verifyAndClickWithXpath(CMProperties.getProperty("CM.Both"),"Both");
			verifyAndSelectDropDownBoxByXpath(CMProperties.getProperty("CM.GasRequest"), "Gas Work Request", "New gas supply pipework & meter");
			verifyAndSelectDropDownBoxByXpath(CMProperties.getProperty("CM.ElectricityRequest"), "Electricity Work Request", "New electricity supply cable & meter");
			verifyAndClickWithXpath(CMProperties.getProperty("CM.GasWorkRequestWhatsThis"), "WorkRequest - What's this? Link");
			verifyIsTextPresent("Work request guide");
			verifyAndClickWithXpath(CMProperties.getProperty("CM.GasWorkRequestWhatsThisContentClose"), "WorkRequest - What's this? Close Link");
			verifyAndClickWithXpath(CMProperties.getProperty("CM.ElecWorkRequestWhatsThis"), "WorkRequest - What's this? Link");
			verifyIsTextPresent("Work request guide");
			verifyAndClickWithXpath(CMProperties.getProperty("CM.ElecWorkRequestWhatsThisContentClose"), "WorkRequest - What's this? Close Link");
		}

		verifyIsTextPresent("Select callback time");
		verifyAndClickWithXpath(CMProperties.getProperty("CM.Time"), "AM (9 -1)");
		verifyIsTextPresent("Calls will be made Monday to Friday excluding any Bank Holidays");
		verifyAndInputByXpath(CMProperties.getProperty("CM.comments"), "Comments", "Request a call back");
		verifyAndClickWithXpath(CMProperties.getProperty("CM.contact"), "Products and other services");
		verifyAndClickWithXpath(CMProperties.getProperty("CM.callmeback"), "Call me back button");
		browser.wait(getWaitTime());
	}
	
	public void verifyAndEnterrequestCMPageNew(String UserLogin, UserProfile userProfile,String strLink, String WR){
		if(UserLogin.equals("LoggedIn"))
		{
			verifyAndInputByXpath(CMProperties.getProperty("CM.TelephoneNo"), "TelephoneNumber", userProfile.getMobileNumber());
			verifyAndInputByXpath(CMProperties.getProperty("CM.postCode"), "Post Code", userProfile.getPostCode());
			
		}
		if(strLink=="Gas")
		{
			verifyAndClickWithXpath(CMProperties.getProperty("CM.Gas"),"Business Gas");
			/*verifyAndSelectDropDownBoxByXpath(CMProperties.getProperty("CM.GasRequest"), "Gas Work Request", "New gas supply pipework & meter");
			verifyAndClickWithXpath(CMProperties.getProperty("CM.GasWorkRequestWhatsThis"), "WorkRequest - What's this? Link");
			verifyIsTextPresent("Work request guide");
			verifyAndClickWithXpath(CMProperties.getProperty("CM.GasWorkRequestWhatsThisContentClose"), "WorkRequest - What's this? Close Link");*/
		}
		else if(strLink=="Electricity")
		{
			verifyAndClickWithXpath(CMProperties.getProperty("CM.Electricity"),"Business Electricity");
			verifyAndSelectDropDownBoxByXpath(CMProperties.getProperty("CM.ElectricityRequest"), "Electricity Work Request", WR);
			verifyAndClickWithXpath(CMProperties.getProperty("CM.ElecWorkRequestWhatsThis"), "WorkRequest - What's this? Link");
			verifyIsTextPresent("Work request guide");
			verifyAndClickWithXpath(CMProperties.getProperty("CM.ElecWorkRequestWhatsThisContentClose"), "WorkRequest - What's this? Close Link");
		}
		else if(strLink=="Both")
		{
			verifyAndClickWithXpath(CMProperties.getProperty("CM.Both"),"Both");
			verifyAndSelectDropDownBoxByXpath(CMProperties.getProperty("CM.GasRequest"), "Gas Work Request", "New gas supply pipework & meter");
			verifyAndSelectDropDownBoxByXpath(CMProperties.getProperty("CM.ElectricityRequest"), "Electricity Work Request", "New electricity supply cable & meter");
			verifyAndClickWithXpath(CMProperties.getProperty("CM.GasWorkRequestWhatsThis"), "WorkRequest - What's this? Link");
			verifyIsTextPresent("Work request guide");
			verifyAndClickWithXpath(CMProperties.getProperty("CM.GasWorkRequestWhatsThisContentClose"), "WorkRequest - What's this? Close Link");
			verifyAndClickWithXpath(CMProperties.getProperty("CM.ElecWorkRequestWhatsThis"), "WorkRequest - What's this? Link");
			verifyIsTextPresent("Work request guide");
			verifyAndClickWithXpath(CMProperties.getProperty("CM.ElecWorkRequestWhatsThisContentClose"), "WorkRequest - What's this? Close Link");
		}

		verifyIsTextPresent("Select callback time");
		verifyAndClickWithXpath(CMProperties.getProperty("CM.Time"), "AM (9 -1)");
		verifyIsTextPresent("Calls will be made Monday to Friday excluding any Bank Holidays");
		verifyAndInputByXpath(CMProperties.getProperty("CM.comments"), "Comments", "Request a call back");
		verifyAndClickWithXpath(CMProperties.getProperty("CM.contact"), "Products and other services");
		verifyAndClickWithXpath(CMProperties.getProperty("CM.callmeback"), "Call me back button");
		browser.wait(getWaitTime());
	}
	
	public void verifyAndCloseThankYou(String UserLogin, UserProfile userProfile, String strLink){
		browser.wait(getWaitTime());
		verifyPageTitle("Callback confirmation");
		verifyIsTextPresent("Thank you for contacting us");
		verifyIsTextPresent("A British Gas Business agent will call you as soon as possible.");
		verifyIsTextPresent("Your reference number:");
		verifyIsTextPresent("What happens next?");
		verifyIsTextPresent("A British Gas Business agent will contact you as soon as possible.");
		verifyIsTextPresent("What would you like to do next?");
		Report.updateTestLog("Confirmation Page is displayed", "WARN");
		/*verifyAndClickWithLinkText("Submit a meter read", "Submit a meter read");
		browser.wait(getWaitTime());
		verifyPageTitle("Submit meter read");
		browser.browserBack();
		browser.wait(getWaitTime());
		verifyAndClickWithLinkText("Request a copy statement", "Request a copy statement");
		browser.wait(getWaitTime());
		verifyPageTitle("Account overview");
		browser.browserBack();
		browser.wait(getWaitTime());
		verifyAndClickWithLinkText("Request copy bill", "Request copy bill");
		browser.wait(getWaitTime());
		verifyPageTitle("Search bill");
		browser.browserBack();
		browser.wait(getWaitTime());
		verifyAndClickWithLinkText("Set up a Direct Debit", "Set up a Direct Debit");
		browser.wait(getWaitTime());
		verifyPageTitle("");
		browser.browserBack();
		browser.wait(getWaitTime())*/;
		OnlineDBConnector dbFunctions = new OnlineDBConnector();
		String date=dbFunctions.DBsysdateDdmmyyhhmi();
		if(UserLogin.equals("Anonymous"))
		{
			String[] auditType = dbFunctions.getAuditEventTypeIdMany(date, userProfile.getEmail(),"connections and meterings");
			String data = dbFunctions.getAuditType(auditType[0]);	
			String data1 = dbFunctions.getAuditType(auditType[2]);
			System.out.println("asdasd"+Arrays.asList(auditType));
			Report.updateTestLog("Audit id is made in audit table as expected. Audit id: "+auditType[0]+ " Audit event type is"+data, data.equalsIgnoreCase("BGBUSINESS_CREATE_PROSPECT_SUCCESS")?"PASS":"FAIL");
			Report.updateTestLog("Audit id is made in audit table as expected. Audit id: "+auditType[2]+ " Audit event type is"+data1, data1.equalsIgnoreCase("BGBUSINESS_OPPORTUNITY_SUCCESS")?"PASS":"FAIL");
		}
		else
		{
			String[] auditType1 = dbFunctions.getAuditEventTypeId(date, userProfile.getEmail(),"connections and meterings");
			System.out.println("asdasaaaaaaaaaaaaaaaaaad"+Arrays.asList(auditType1));
			String data = dbFunctions.getAuditType(auditType1[0]);	
			System.out.println("Dataaaaaa"+data);
			Report.updateTestLog("Audit id is made in audit table as expected. Audit id: "+auditType1[0]+ " Audit event type is"+data, data.equalsIgnoreCase("BGBUSINESS_OPPORTUNITY_SUCCESS")?"PASS":"FAIL");
		}
		browser.browserBack();
	}

	public void verifyLinks() {
		verifyAndClickWithXpath(CMProperties.getProperty("CM.Gas&Elec"), "Gas & Electricity");
		browser.wait(getWaitTime());
		verifyIsTextPresent("Business energy", "Business energy");
		browser.browserBack();
		browser.wait(getWaitTime());
		verifyAndClickWithXpath(CMProperties.getProperty("CM.ConnecMetering"), "Connections & Metering");
		browser.wait(getWaitTime());
		verifyIsTextPresent("Connections & metering", "Connections & metering");
		browser.browserBack();
		browser.wait(getWaitTime());
		/*verifyAndClickWithXpath(CMProperties.getProperty("CM.ClickHere"), "Click Here");
		browser.wait(getWaitTime());
		verifyIsTextPresent("New Connections");
		browser.browserBack();*/
	}
	public void verifyTelephone(UserProfile userProfile){
		/*verifyAndInputByXpath(CMProperties.getProperty("CM.MobileNo"), "TelephoneNumber", userProfile.getMobileNumber());
		verifyAndSelectDropDownBox(CMProperties.getProperty("CM.Title"), "Title", userProfile.getTitle());
		verifyAndInputByXpath(CMProperties.getProperty("CM.Firstname"), "FirstName", userProfile.getFirstName());
		verifyAndInputByXpath(CMProperties.getProperty("CM.Surname"), "SurName", userProfile.getLastName());
		verifyAndInputByXpath(CMProperties.getProperty("CM.BusinessName"), "BusinessName", userProfile.getCompanyName());*/
		browser.wait(5000);
		String MobileNo=browser.getAttributeByXpath(CMProperties.getProperty("CM.TelephoneNo"),"value");
		System.out.println("sdfddddddddddddddddd" + MobileNo);
		Report.updateTestLog("Telephone Number prepopulated validation is done."+MobileNo, MobileNo.equals(userProfile.getMobileNumber())?"PASS":"FAIL");
		/*verifyAndInputByXpath(CMProperties.getProperty("CM.email"), "Email", userProfile.getEmail());
		verifyAndInputByXpath(CMProperties.getProperty("CM.postCode"), "PostCode", userProfile.getPostCode());
		verifyAndClickWithXpath(CMProperties.getProperty("CM.BGBCustomer"),"NO - BGB Customer");
		verifyAndClickWithXpath(CMProperties.getProperty("CM.ContinueButton"), "Continue button");
		browser.wait(getWaitTime());*/
	}
	public void verifyErrors(UserProfile userProfile, String string) {
		if(string=="No Options")
		{
			Report.updateTestLog("'Type of connection' is not selected", "Pass");
		}
		verifyAndClickWithXpath(CMProperties.getProperty("CM.callmeback"), "Call me back button");
		browser.wait(getWaitTime());
		verifyIsTextPresent("Please select Business gas, Business electricity or Both");
		verifyIsTextPresent("Please select a time for us to call you");
		verifyIsTextPresent("Please enter your message.");
		verifyAndClickWithXpath(CMProperties.getProperty("CM.Electricity"),"Business Electricity");
		verifyAndInputByXpath(CMProperties.getProperty("CM.comments"), "Comments", "Request a call back");
		verifyAndClickWithXpath(CMProperties.getProperty("CM.contact"), "Products and other services");
		verifyAndClickWithXpath(CMProperties.getProperty("CM.callmeback"), "Call me back button");
		verifyIsTextPresent("Please select your work request.");
	}

	public void verifyErrorinCM(UserProfile userProfile) 
	{
		verifyAndSelectDropDownBoxByXpath(CMProperties.getProperty("CM.Title"), "Title", userProfile.getTitle());
		verifyAndInputByXpath(CMProperties.getProperty("CM.Firstname"), "FirstName", userProfile.getFirstName());
		verifyAndInputByXpath(CMProperties.getProperty("CM.Surname"), "SurName", userProfile.getLastName());
		verifyAndInputByXpath(CMProperties.getProperty("CM.BusinessName"), "BusinessName", userProfile.getCompanyName());
		verifyAndInputByXpath(CMProperties.getProperty("CM.TelephoneNo"), "TelephoneNumber", userProfile.getMobileNumber());
		verifyAndInputByXpath(CMProperties.getProperty("CM.email"), "Email", userProfile.getEmail());
		verifyAndInputByXpath(CMProperties.getProperty("CM.postCode"), "PostCode", userProfile.getPostCode());
		//verifyAndClickWithXpath(CMProperties.getProperty("CM.BGBCustomer"),"NO - BGB Customer");
		verifyAndClickWithXpath(CMProperties.getProperty("CM.ContinueButton"), "Continue button");
		browser.wait(getWaitTime());
		verifyIsTextPresent("Please select yes or no.");
		
	}

	
	public void browserBack() {
		browser.wait(getWaitTime());
		verifyAndClickWithXpath(CMProperties.getProperty("CM.Back"), "Back button");
		verifyPageTitle("Request a callback");
		}

	public void ValidateinCRM() {
		verifyAndInputByXpath(CMProperties.getProperty("CM.CRMUsername"), "CRM Username", "sundarg1");
		verifyAndInputByXpath(CMProperties.getProperty("CM.CRMPassword"), "CRM Password", "welcome4");
		verifyAndClickWithXpath(CMProperties.getProperty("CM.opportunity"), "Opportunity button");
		verifyAndInputByXpath(CMProperties.getProperty("CM.opportunityID"), "Opportunity ID", "2w12w312" );
		
	}

	public void logout() {
		verifyAndClickWithXpath(CMProperties.getProperty("CM.Logout"), "Log out link");	
		
	}
}
