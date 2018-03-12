/**
 * 
 */
package bg.framework.app.functional.page.tetris;

import java.util.Properties;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

/**
 * @author 292238
 *
 */
public class DirectDebitSetupPage extends BasePage{
	private final static String FILE_NAME = "resources/tetris/DirectDebitSetup.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	
	public void openDirectDebitSetupPage(){
		browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("DirectDebitPage.Url"));
		getWaitTime();
	}
	
	public void entervalidData(UserProfile userProfile){
		verifyAndInputById(pageProperties.getProperty("DirectDebitPage.firstname"), "First Name", userProfile.getFirstName());
		verifyAndInputById(pageProperties.getProperty("DirectDebitPage.surname"), "Last Name", userProfile.getLastName());
		verifyAndInputById(pageProperties.getProperty("DirectDebitPage.AccountNumber"), "Account number", userProfile.getAccNumber());
		verifyAndInputById(pageProperties.getProperty("DirectDebitPage.companyname"), "Company Name", userProfile.getCompanyName());
		verifyAndInputById(pageProperties.getProperty("DirectDebitPage.email"), "Email", userProfile.getEmail());
		verifyAndInputById(pageProperties.getProperty("DirectDebitPage.contactnumber"), "contactnumber", userProfile.getPhoneNumber());
		verifyAndSelectCheckBoxByID(pageProperties.getProperty("DirectDebitPage.marketingconsent"), "Marketing Consent");
		verifyAndClickWithXpath(pageProperties.getProperty("DirectDebitPage.submitButton"), "Submit");
	}
	
	public void verifyThankYouPage(){
		// verifyIsElementVisibleWithXpath(pageProperties.getProperty("DirectDebitPage.ThankYou"),"Thank you page");
		 verifyIsTextPresent("Thank you");
	 }
	public void verifyLeadTable(UserProfile userProfile){
		OnlineDBConnector dbFunctions = new OnlineDBConnector();
		String date=dbFunctions.DBsysdateDdmmyyhhmi();
		String leadType[] = dbFunctions.verifyleadDBForLeadType(date,userProfile.getEmail(),"Setting_Up_DD");		
		Report.updateTestLog("Lead type is "+leadType[0] +". Hence email sent to both the customer and agent", leadType[0].equalsIgnoreCase("0")?"PASS":"FAIL");
		Report.updateTestLog("Lead status is "+leadType[1] +".", leadType[1].equalsIgnoreCase("Setting_Up_DD")?"PASS":"FAIL");
		Report.updateTestLog("First name validation is done."+leadType[3], leadType[3].equals(userProfile.getFirstName())?"PASS":"FAIL");
		Report.updateTestLog("Sur name validation is done."+leadType[4], leadType[4].equals(userProfile.getLastName())?"PASS":"FAIL");
		Report.updateTestLog("Company name validation is done."+leadType[5], leadType[5].equals(userProfile.getCompanyName())?"PASS":"FAIL");
		Report.updateTestLog("Contact number validation is done."+leadType[6], leadType[6].equals(userProfile.getPhoneNumber())?"PASS":"FAIL");
		Report.updateTestLog("MARKETING_CONSENT validation is done."+leadType[8], leadType[8].equals("Y")?"PASS":"FAIL");
		Report.updateTestLog("Email address validation is done."+leadType[13], leadType[13].equals(userProfile.getEmail())?"PASS":"FAIL");
		
		String[] auditType = dbFunctions.getAuditEventTypeId(date, userProfile.getEmail(),"Setting_Up_DD");
		String data = dbFunctions.getAuditType(auditType[0]);	
		Report.updateTestLog("Audit id is made in audit table as expected. Audit id: "+auditType[0]+ " Audit event type is"+data, data.equalsIgnoreCase("SERVICECALLBACK_CUSTOMER_EMAIL_SENT_SUCCESS")?"PASS":"FAIL");
		
	}
}
