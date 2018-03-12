package bg.framework.app.functional.page.Slingshot_Broker;

import java.util.ArrayList;
import java.util.Properties;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.Slingshot.Encryption;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.SlingshotErrorMessages;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class RegistrationPage extends BasePage{
	private final static String FILE_NAME = "resources/Slingshot_Broker/RegistrationPage.Properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	public String openURL(UserProfile userProfile){
		String regURL = null;
		try {
			String Url=new Encryption().encryptAndSendData(userProfile,"BROKER");
			regURL = ApplicationConfig.APP_BG_URL+pageProperties.getProperty("common.ActivationEmail")+Url;
			System.out.println("Encrypt URL************"+ApplicationConfig.APP_BG_URL+pageProperties.getProperty("common.CsaEncryptUrl")+Url);
 			browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("common.CsaEncryptUrl")+Url);

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return regURL;
	}
	public void fillRegistrationDetails(UserProfile userProfile){
		try{
    		String strName = userProfile.getEmail();
            String displayedEmail=browser.getAttribute(pageProperties.getProperty("RegistrationPage.EmailIdEntered"),"value");
            System.out.println("Email displayed is:"+displayedEmail);
            if(displayedEmail.equalsIgnoreCase(userProfile.getEmail())){
           	 Report.updateTestLog(displayedEmail +"- Email address is prepopulated in Email address field", "PASS");
            }else{
            	Report.updateTestLog(strName+":"+displayedEmail+"- Email address is prepopulated in Email address field", "FAIL");
            	
            }
		verifyAndSelectDropDownBox(pageProperties.getProperty("RegistrationPage.Title"), "Title", userProfile.getTitle().trim());
	    verifyAndInputById(pageProperties.getProperty("RegistrationPage.FirstName"), "First Name", userProfile.getFirstName().trim());
	    verifyAndInputById(pageProperties.getProperty("RegistrationPage.LastName"),"Last name",userProfile.getLastName().trim());
	    verifyAndInputById(pageProperties.getProperty("RegistrationPage.PostCode"), "Post code", userProfile.getPostCode());
	    verifyAndInputById(pageProperties.getProperty("RegistrationPage.Password"),"Password",userProfile.getPassword().trim());
	    verifyAndInputById(pageProperties.getProperty("RegistrationPage.ConfirmPassword"),"Confirm Password",userProfile.getPassword().trim());
	    verifyAndClickWithXpath(pageProperties.getProperty("RegistrationPage.TermsandConditions"), "Checkbox");	   
	    verifyAndClick(pageProperties.getProperty("RegistrationPage.Continue"), "Continue button");
		}
		catch(Exception e){
			System.out.println("Exception : "+e);
		}
	}
	public void verifyThankYouPage(){
		Report.updateTestLog("Registration successful confirmation page is displayed after entering the mandatory details in the registration page and after clicking continue button", 
				(browser.isTextPresent("Thanks, you're now registered")?"PASS":"FAIL"));
		verifyIsTextPresent("Thanks, you're now registered");
	}
	public void clickLoginLink(){
	    verifyAndClickWithXpath(pageProperties.getProperty("RegistrationPage.LoginToYourAccountLink"), "Log in to your Partner Portal account");
	    
	    Report.updateTestLog("Broker login page is displayed."+browser.getTitle(),browser.getTitle().equalsIgnoreCase("Log in to your account")?"PASS":"FAIL");
	   	}
	public void verifyAuditEntry(UserProfile userProfile){
		OnlineDBConnector dbFunctions = new OnlineDBConnector();
		String date=dbFunctions.DBsysdateDdmmyyhhmi();
		String[] auditType = dbFunctions.getAuditEventTypeId(date, userProfile.getEmail(),"BROKERREGISTRATIONSUCCESS");
		String[] auditTypeForMail = dbFunctions.getAuditEventTypeId(date, userProfile.getEmail(),"BROKERREGISTRATIONCOMPLETEEMAILSENTSUCCESS");
		String data = dbFunctions.getAuditType(auditType[0]);
		String data1 = dbFunctions.getAuditType(auditTypeForMail[0]);	
		Report.updateTestLog("Registration successful email is sent to the respective user after the registration is successful", data1.equalsIgnoreCase("CSA_BROKER_REGISTRATION_COMPLETE_SENT_SUCCESS")?"PASS":"FAIL");
	    Report.updateTestLog("Audit entry is made for 'Registration success' in audit table as expected. Audit id: "+auditType[0]+ " Audit event type is"+data, data.equalsIgnoreCase("BGBUSINESS_BROKER_REGISTRATION_SUCCESS")?"PASS":"FAIL");
	    Report.updateTestLog("Audit entry is made for 'Email sent success' in audit table as expected. Audit id: "+auditTypeForMail[0]+ " Audit event type is"+data1, data1.equalsIgnoreCase("CSA_BROKER_REGISTRATION_COMPLETE_SENT_SUCCESS")?"PASS":"FAIL");

	}
	public RegistrationPage verifyEmailIdInDb(UserProfile userProfile){
		String emailAdress="";
		String strBP_CONTACT_PERSON_NUMBER=null;
		String strBUSINESS_PARTNER_ORG_NUMBER=null;
		String strRetreiveEmailQry="Select EMAIL from BG_BUSINESS_TA_CUSTOMER_REG where " +
				"email='emailid' and rownum=1";
		String strRetreiveBPCPQry="Select BP_CONTACT_PERSON_NUMBER from BG_BUSINESS_TA_CUSTOMER_REG where " +
		"email='emailid' and rownum=1";
		String strRetreiveBPOrgQry="Select BUSINESS_PARTNER_ORG_NUMBER from BG_BUSINESS_TA_CUSTOMER_REG where " +
		"email='emailid' and rownum=1";
		String query=strRetreiveEmailQry.replace("emailid",userProfile.getEmail().toLowerCase());
		String query1=strRetreiveBPCPQry.replace("emailid",userProfile.getEmail().toLowerCase());
		String query2=strRetreiveBPOrgQry.replace("emailid",userProfile.getEmail().toLowerCase());
		if(new OnlineDBConnector().getColumn("EMAIL", query)!=null){
			emailAdress=new OnlineDBConnector().getColumn("EMAIL", query);
			strBP_CONTACT_PERSON_NUMBER = new OnlineDBConnector().getColumn("BP_CONTACT_PERSON_NUMBER", query1);
			strBUSINESS_PARTNER_ORG_NUMBER = new OnlineDBConnector().getColumn("BUSINESS_PARTNER_ORG_NUMBER", query2);
		}else{
			emailAdress="null";	
		}		
		Report.updateTestLog("Email  - Expected Result: "+emailAdress.toLowerCase()+"Actual Result: "+emailAdress,Character.isLowerCase(emailAdress.charAt(0))?"Pass":"Fail");
		Report.updateTestLog("BP_CONTACT_PERSON_NUMBER  - Expected Result: "+strBP_CONTACT_PERSON_NUMBER.toLowerCase(),"PASS");
		Report.updateTestLog("BUSINESS_PARTNER_ORG_NUMBER  - Expected Result: "+strBUSINESS_PARTNER_ORG_NUMBER.toLowerCase(),"PASS");		
		return this;
	}
	 public void verifyRegistrationPageLinks(){
	 		ArrayList<String> list = new ArrayList<String>();
	 		
	 		list.add("RegistrationPage.Cancel");
	 		list.add(pageProperties.getProperty("RegistrationPage.CancelPage"));
	 		list.add("RegistrationPage.LHNLink");
	 		list.add(pageProperties.getProperty("RegistrationPage.LHNPage"));
	 		list.add("RegistrationPage.RHNLink");
	 		list.add(pageProperties.getProperty("RegistrationPage.RHNPage"));
	 		
	 		for (int i=0;i<list.size();i=i+2) {
	 			verifyLinksandText(list.get(i),list.get(i+1));
	 		}
	 	}
	 	
	 	private void verifyLinksandText(String link, String title) {
	 		String linkName = link.substring(link.indexOf('.') + 1, link.length());
	 		if(browser.isElementVisibleWithXpath(pageProperties.getProperty(link))) {
	 			Report.updateTestLog(linkName + " Link Exist", "PASS");
	 			browser.clickWithXpath(pageProperties.getProperty(link));
	 			browser.wait(2000);	
	 			verifyIsElementVisibleWithXpath(title, title);
	 			browser.wait(2000);	
	 		} 
	 		else {
	 			Report.updateTestLog(linkName + " Link not Exist", "FAIL");
	 		}
	 	}
	 	public void verifyExpiredLinkAfter28Days(){
	 		
	 	}
	 	public void verifyInvalidLink(UserProfile userProfile){

			try {
				String Url=new Encryption().encryptAndSendData(userProfile,"BROKER");
				System.out.println("Encrypt URL************"+ApplicationConfig.APP_BG_URL+pageProperties.getProperty("common.ActivationEmail")+Url);
	 			browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("common.ActivationEmail")+"Invalid"+Url);

			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	 	}
	 	public void verifyRegistrationInvalidPageLinks(){
	 		ArrayList<String> list = new ArrayList<String>();
	 		
	 		list.add("RegistrationPage.RHNLogin");
	 		list.add(pageProperties.getProperty("RegistrationPage.LoginPage"));
	 	/*	list.add("RegistrationPage.LHNLink");
	 		list.add(pageProperties.getProperty("RegistrationPage.LHNPage"));
	 		list.add("RegistrationPage.RHNLink");
	 		list.add(pageProperties.getProperty("RegistrationPage.RHNPage"));*/
	 		
	 		for (int i=0;i<list.size();i=i+2) {
	 			verifyLinksandText(list.get(i),list.get(i+1));
	 		}
	 	}
	 	public void verifyAlreadyRegisteredLink(String regURL){
 			browser.open(regURL);
 			Report.updateTestLog("Registration done already for this URL", browser.getTitle().equalsIgnoreCase("Already Registred")?"PASS":"FAIL");
	 	}
	 	public void validateLastNameErrorMessage(UserProfile userProfile){
	         final String[] lastName = {"", "Last*&^%12345", "Lastname123456789101Lastname123456789101AB", "L"};
	         for (int i = 0; i < lastName.length; i++) {
	        	   switch (i){
	        	   
	        	   case 0:enterRegistrationDetailsPage(userProfile, lastName[i]); 	        	
	               errorMessageComparison(SlingshotErrorMessages.SlingShot_LastNameEmpty);
	               break;
	        	   case 1:enterRegistrationDetailsPage(userProfile, lastName[i]); 	        	
	               errorMessageComparison(SlingshotErrorMessages.SlingShot_LastNameInvalid);
	               break;
	        	   case 2:enterRegistrationDetailsPage(userProfile, lastName[i]); 	        	
	               errorMessageComparison(SlingshotErrorMessages.SlingShot_Morethan40CharLastName);
	               break;
	        	   case 3:enterRegistrationDetailsPage(userProfile, lastName[i]); 	        	
	               errorMessageComparison(SlingshotErrorMessages.SlingShot_SingleCharLastNameInvalid);
	               break;
	        	   default:enterRegistrationDetailsPage(userProfile, lastName[i]); 	        	
	               errorMessageComparison(SlingshotErrorMessages.SlingShot_FirstNameWithSemicolon);
	        	   break;    		   
	        	   }
	           }
	 	}
	 	public void enterRegistrationDetailsPage(UserProfile userProfile,String lastname){
	 		verifyAndSelectDropDownBox(pageProperties.getProperty("RegistrationPage.Title"), "Title", userProfile.getTitle().trim());
		    verifyAndInputById(pageProperties.getProperty("RegistrationPage.FirstName"), "First Name", userProfile.getFirstName().trim());
		    verifyAndInputById(pageProperties.getProperty("RegistrationPage.Surname"),"Last name",lastname);
		    verifyAndInputById(pageProperties.getProperty("RegistrationPage.PostCode"), "Post code", userProfile.getPostCode());
		    verifyAndInputById(pageProperties.getProperty("RegistrationPage.Password"),"Password",userProfile.getPassword().trim());
		    verifyAndInputById(pageProperties.getProperty("RegistrationPage.ConfirmPassword"),"Confirm Password",userProfile.getPassword().trim());
		    verifyAndClickWithXpath(pageProperties.getProperty("RegistrationPage.TermsandConditions"), "Checkbox");	   
		    verifyAndClick(pageProperties.getProperty("RegistrationPage.Continue"), "Continue button");
	 	}
	 // Capture the error message displayed and verify the actual and error message displayed by making a call to the verifyErrorMessage method
	    public void errorMessageComparison(final String expectedErrorMsg) {
	        final String displayedErrorMsg = browser.getTextByXpath(pageProperties.getProperty("ForgotEmailPage.ErrorMessageValidationID"));
	        verifyErrorMessage(displayedErrorMsg, expectedErrorMsg);
	    }
	    

	//  Validation for Inappropriate data for the fields displayed in Forgot Email Compare the error message displayed in the 
	//  application against the Expected data  	 
	     public void verifyErrorMessage(final String displayedErrorMsg, final String expectedErrorMsg) {
	    	 System.out.println(displayedErrorMsg);
	    	 System.out.println(expectedErrorMsg);
	         if (displayedErrorMsg.trim().contains(expectedErrorMsg.trim())) {
	             Report.updateTestLog("Error message validation is done. Expected error message: "+ expectedErrorMsg+" Displayed error message: "+ displayedErrorMsg, "PASS");
	         } else {
	        	 Report.updateTestLog("Error message validation is done. Expected error message: "+ expectedErrorMsg+" Displayed error message: "+ displayedErrorMsg, "FAIL");
	         }
	     }
}
