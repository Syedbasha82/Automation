package bg.framework.app.functional.page.Slingshot_Broker;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class LeadPage extends BasePage{
	private final static String FILE_NAME = "resources/Slingshot/LeadPage.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	OnlineDBConnector dbFunctions = new OnlineDBConnector();
	String date=dbFunctions.DBsysdateDdmmyyhhmi();
	
	public void loginLeadBroker(UserProfile userProfile){
		verifyAndInputById(pageProperties.getProperty(""), "Email address", userProfile.getEmail());
		verifyAndInputById(pageProperties.getProperty(""), "Password", userProfile.getPassword());
		verifyAndClick(pageProperties.getProperty(""), "Submit button");
	}
	public void clickLeadLink(){
		verifyAndClickWithXpath(pageProperties.getProperty(""), "Leads link");
	}
	public void verifyLeadPage(){
		verifyPageTitle("Leads");
		
	}
	public void verifyCreateNewLead(UserProfile userProfile){
		verifyAndClickWithXpath(pageProperties.getProperty(""), "Create New Lead link");
		verifyIsElementVisibleWithXpath(pageProperties.getProperty(""), "Create lead");
		verifyAndInputById(pageProperties.getProperty(""), "First name", userProfile.getFirstName());
		verifyAndInputById(pageProperties.getProperty(""), "last name", userProfile.getLastName());
		verifyAndInputById(pageProperties.getProperty(""), "Telephone number", userProfile.getMobileNumber());
		verifyAndInputById(pageProperties.getProperty(""), "Email address", userProfile.getEmail());
		verifyAndInputById(pageProperties.getProperty(""), "Business name", userProfile.getCompanyName());
		verifyAndInputById(pageProperties.getProperty(""), "Business Telephone number", userProfile.getPhoneNumber());
		verifyAndInputById(pageProperties.getProperty(""), "Business email", userProfile.getEmail());
		verifyAndClickWithXpath(pageProperties.getProperty(""), "Fuel type");
		verifyAndInputById(pageProperties.getProperty(""), "Number of sites", "");
		verifyAndInputById(pageProperties.getProperty(""), "Expected contract volume", "");
		verifyAndInputById(pageProperties.getProperty(""), "Expected close date", "");
		verifyAndInputById(pageProperties.getProperty(""), "Preferred start date", "");
		verifyAndSelectCheckBoxByID(pageProperties.getProperty(""), "Terms and Conditions");
		verifyAndClickWithXpath(pageProperties.getProperty(""), "Confirm button");
	}
	public void verifyConfirmation(){
		verifyIsTextPresent("Thank you, your lead has been submitted");
	}
	public void verifyAudits(UserProfile userProfile){
		
		String[] auditType = dbFunctions.getAuditEventTypeId(date, userProfile.getEmail(),"Leads_Confirmation");
		String data = dbFunctions.getAuditType(auditType[0]);	
		//String data1 = dbFunctions.getAuditType(auditType[1]);	
		System.out.println(Arrays.asList(auditType));
		Report.updateTestLog("Audit id is made in audit table as expected. Audit id: "+auditType[0]+ " Audit event type is"+data, data.trim().equalsIgnoreCase("LEADS_EMAIL_SENT_SUCCESS")?"PASS":"FAIL");
		Report.updateTestLog("Audit data is made in audit table as expected. Audit data: "+auditType[1],"PASS");
	}
	public String verifyViewLead(String leadId,UserProfile userProfile){
		verifyAndClickWithLinkText(pageProperties.getProperty(""), leadId);
		verifyIsTextPresent("Your lead details");
		Set<String> words = new HashSet<String>();
	     words.add(userProfile.getFirstName());
	     words.add(userProfile.getLastName());
	     words.add(userProfile.getCompanyName());
	     words.add(userProfile.getEmail());
	     words.add(userProfile.getPhoneNumber());

		String leadText = browser.getTextByXpath(pageProperties.getProperty(""));
		System.out.println("leadText$$$$$$$$$$$$$$$$$$"+leadText);
		System.out.println("Wrods$$$$$$$$$$$$$$$$$$$$$"+words);
		//String[] leadTextSplit = leadText.split(" ");
		for(String word : words){
			if(leadText.contains(word)){
				System.out.println("Sting matched:*********"+word);
				return word;
				
			}
		}
		return leadText;
	}
	
	public void verifyEditLead(){
		//Lead status should be open
		verifyAndClickWithXpath(pageProperties.getProperty(""), "Edit link");
		verifyAndClickWithXpath(pageProperties.getProperty(""), "Confirm");
		verifyPageTitle("Your lead amended successfully");
		verifyAndClickWithXpath(pageProperties.getProperty(""), "Back to leads");
	}
	public void verifyAmendLeadAudit(UserProfile userProfile){
		String[] auditType = dbFunctions.getAuditEventTypeId(date, userProfile.getEmail(),"Leads_Confirmation");
		String data = dbFunctions.getAuditType(auditType[0]);	
		//String data1 = dbFunctions.getAuditType(auditType[1]);	
		System.out.println(Arrays.asList(auditType));
		Report.updateTestLog("Audit id is made in audit table as expected. Audit id: "+auditType[0]+ " Audit event type is"+data, data.trim().equalsIgnoreCase("LEADS_AMEND_EMAIL_SENT_SUCCESS")?"PASS":"FAIL");
		Report.updateTestLog("Audit data is made in audit table as expected. Audit data: "+auditType[1],"PASS");
	
	}
}
