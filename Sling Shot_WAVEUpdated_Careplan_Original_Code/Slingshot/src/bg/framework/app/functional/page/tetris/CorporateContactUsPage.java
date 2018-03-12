package bg.framework.app.functional.page.tetris;

import java.util.Properties;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.SlingshotErrorMessages;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class CorporateContactUsPage extends BasePage{
	private final static String FILE_NAME = "resources/tetris/Common.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	//SlingshotErrorMessages errormsg = new SlingshotErrorMessages();
	public void openCorparateContactUspage(){
		browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("CorporateContactUs.URL"));
		getWaitTime();
	}
	public void entervalidData(UserProfile userProfile){
		verifyAndSelectDropDownBox(pageProperties.getProperty("CorporateContactUs.Title"), "Title", userProfile.getTitle());
		verifyAndInputById(pageProperties.getProperty("CorporateContactUs.firstname"), "First Name", userProfile.getFirstName());
		verifyAndInputById(pageProperties.getProperty("CorporateContactUs.surname"), "Last Name", userProfile.getLastName());
		verifyAndInputById(pageProperties.getProperty("CorporateContactUs.companyname"), "Company Name", userProfile.getCompanyName());
		verifyAndInputById(pageProperties.getProperty("CorporateContactUs.email"), "Email", userProfile.getEmail());
		verifyAndInputById(pageProperties.getProperty("CorporateContactUs.contactnumber"), "contactnumber", userProfile.getPhoneNumber());
		verifyAndInputById(pageProperties.getProperty("CorporateContactUs.postcodeid"), "postcode", userProfile.getPostCode());
		verifyAndInputById(pageProperties.getProperty("CorporateContactUs.annualspend"), "annualspend", userProfile.getAnnualSpend());
		verifyAndInputById(pageProperties.getProperty("CorporateContactUs.companyregistrationnumber"), "companyregistrationnumber", userProfile.getRegisterationNumber());
		verifyAndSelectDropDownBox(pageProperties.getProperty("CorporateContactUs.comments"), "comments", "Energy supply");
		verifyAndClickWithXpath(pageProperties.getProperty("CorporateContactUs.submitButton"), "Submit");
	}
	public void verifyLeadTable(UserProfile userProfile){
		OnlineDBConnector dbFunctions = new OnlineDBConnector();
		String date=dbFunctions.DBsysdateDdmmyyhhmi();
		String leadType[] = dbFunctions.verifyleadDBForLeadType(date,userProfile.getEmail(),"Corporate_Contact_Us");	
		Report.updateTestLog("Title validation is done."+leadType[2], leadType[2].equals(userProfile.getTitle())?"PASS":"FAIL");
		Report.updateTestLog("First name validation is done."+leadType[3], leadType[3].equals(userProfile.getFirstName())?"PASS":"FAIL");
		Report.updateTestLog("Sur name validation is done."+leadType[4], leadType[4].equals(userProfile.getLastName())?"PASS":"FAIL");
		Report.updateTestLog("Contact number validation is done."+leadType[6], leadType[6].equals(userProfile.getPhoneNumber())?"PASS":"FAIL");
		Report.updateTestLog("Email address validation is done."+leadType[13], leadType[13].equals(userProfile.getEmail())?"PASS":"FAIL");
		Report.updateTestLog("Post code validation is done."+leadType[7], leadType[7].equals(userProfile.getPostCode())?"PASS":"FAIL");
		Report.updateTestLog("TOTAL_ANNUAL_SPEND validation is done."+leadType[9], leadType[9].equals(userProfile.getAnnualSpend())?"PASS":"FAIL");		
		Report.updateTestLog("Lead type is "+leadType[0] +". Hence email sent to both the customer and agent", leadType[0].equalsIgnoreCase("0")?"PASS":"FAIL");
		Report.updateTestLog("Lead status is "+leadType[1] +".", leadType[1].equalsIgnoreCase("Corporate_Contact_Us")?"PASS":"FAIL");
		String[] auditType = dbFunctions.getAuditEventTypeId(date, userProfile.getEmail(),"Corporate_Contact_Us");
		String data = dbFunctions.getAuditType(auditType[0]);	
		Report.updateTestLog("Audit id is made in audit table as expected. Audit id: "+auditType[0]+ " Audit event type is "+data, data.equalsIgnoreCase("SERVICECALLBACK_CUSTOMER_EMAIL_SENT_SUCCESS")?"PASS":"FAIL");
			}
}
