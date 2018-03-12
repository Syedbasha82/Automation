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
public class StatementOfAccountPage extends BasePage{
	private final static String FILE_NAME = "resources/tetris/StatementOfAccountPage.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	
	public void openStatementRequestPage(){
		browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("StatementOfAccount.URL"));
		getWaitTime();
	}
	
	public void entervalidData(UserProfile userProfile){
		//verifyAndSelectDropDownBox(pageProperties.getProperty("StatementOfAccount.Title"), "Title", userProfile.getTitle());		
		verifyAndInputById(pageProperties.getProperty("StatementOfAccount.fullname"), "Full Name", userProfile.getFirstName());
		//verifyAndInputById(pageProperties.getProperty("StatementOfAccount.surname"), "Last Name", userProfile.getLastName());
		verifyAndInputById(pageProperties.getProperty("StatementOfAccount.companyname"), "Company Name", userProfile.getCompanyName());
		verifyAndInputById(pageProperties.getProperty("StatementOfAccount.contactnumber"), "contactnumber", userProfile.getPhoneNumber());
		verifyAndInputById(pageProperties.getProperty("StatementOfAccount.email"), "Email", userProfile.getEmail());
		verifyAndInputById(pageProperties.getProperty("StatementOfAccount.accountNumber"), "Account number", userProfile.getAccNumber());
		verifyAndSelectCheckBoxByID(pageProperties.getProperty("StatementOfAccount.marketingconsent"), "Marketing Consent");
			}
	public void clickSubmitButton(){
		verifyAndClickWithXpath(pageProperties.getProperty("StatementOfAccount.submitButton"), "Submit");
		getWaitTime();
	}
	public void verifyThankYouPage(){
		  verifyIsTextPresent("Thank you");
	 }
	public void verifyLeadTable(UserProfile userProfile){
		OnlineDBConnector dbFunctions = new OnlineDBConnector();
		String date=dbFunctions.DBsysdateDdmmyyhhmi();
		String leadType[] = dbFunctions.verifyleadDBForLeadType(date,userProfile.getEmail(),"CopyStatement");		
		Report.updateTestLog("Lead type is "+leadType[0] +". Hence email sent to both the customer and agent", leadType[0].equalsIgnoreCase("0")?"PASS":"FAIL");
		Report.updateTestLog("Lead status is "+leadType[1] +".", leadType[1].equalsIgnoreCase("CopyStatement")?"PASS":"FAIL");
		//Report.updateTestLog("Title validation is done."+leadType[2], leadType[2].equals(userProfile.getTitle())?"PASS":"FAIL");
		//Report.updateTestLog("First name validation is done."+leadType[3], leadType[3].equals(userProfile.getFirstName())?"PASS":"FAIL");
		Report.updateTestLog("Full name validation is done."+leadType[4], leadType[4].equals(userProfile.getFirstName())?"PASS":"FAIL");
		Report.updateTestLog("Company name validation is done."+leadType[5], leadType[5].equals(userProfile.getCompanyName())?"PASS":"FAIL");
		Report.updateTestLog("Contact number validation is done."+leadType[6], leadType[6].equals(userProfile.getPhoneNumber())?"PASS":"FAIL");
		Report.updateTestLog("Email address validation is done."+leadType[13], leadType[13].equals(userProfile.getEmail())?"PASS":"FAIL");
		Report.updateTestLog("Account number validation is done."+leadType[16], leadType[16].equals(userProfile.getAccNumber())?"PASS":"FAIL");
		
		String[] auditType = dbFunctions.getAuditEventTypeId(date, userProfile.getEmail(),"CopyStatement");
		String data = dbFunctions.getAuditType(auditType[0]);	
		Report.updateTestLog("Audit id is made in audit table as expected. Audit id: "+auditType[0]+ " Audit event type is"+data, data.equalsIgnoreCase("COPYBILL_CUSTOMER_EMAIL_SENT_SUCCESS")?"PASS":"FAIL");
		}
	 public void verifyAddAnotherAccount(){
		 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("StatementOfAccount.AddAnotherAccount"))){
		 verifyAndClickWithXpath(pageProperties.getProperty("StatementOfAccount.AddAnotherAccount"), "Add another account");	 
		 }
	 }
	 public void verifyRequestedBill(){
		 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("StatementOfAccount.DisplayDiv1"))){
			 Report.updateTestLog("Copy statement 1 requested ", "PASS");
		 }
		 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("StatementOfAccount.DisplayDiv2"))){
			 Report.updateTestLog("Copy statement 2 requested ", "PASS");
		 }
	 }
}
