/**
 * 
 */
package bg.framework.app.functional.page.tetris;

import java.util.Properties;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.TetrisErrorMessages;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

/**
 * @author 292238
 *
 */
public class CorporateTrainingContactUs extends BasePage{
	
	private final static String FILE_NAME = "resources/tetris/Common.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	
	public void openCorparateContactUspage(){
		browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("TrainingContactUs.Url"));
		getWaitTime();
	}
	public void entervalidData(UserProfile userProfile){
		verifyAndSelectDropDownBox(pageProperties.getProperty("CorporateContactUs.Title"), "Title", userProfile.getTitle());
		verifyAndInputById(pageProperties.getProperty("CorporateContactUs.firstname"), "First Name", userProfile.getFirstName());
		verifyAndInputById(pageProperties.getProperty("CorporateContactUs.surname"), "Last Name", userProfile.getLastName());
		verifyAndInputById(pageProperties.getProperty("CorporateContactUs.email"), "Email", userProfile.getEmail());
		verifyAndInputById(pageProperties.getProperty("CorporateContactUs.contactnumber"), "Contactnumber", userProfile.getPhoneNumber());
		verifyAndInputById(pageProperties.getProperty("TrainingContactUs.postaltown"), "Country", userProfile.getCountry());
		verifyAndInputById(pageProperties.getProperty("CorporateContactUs.Course"), "Course", "Functional");
		verifyAndSelectCheckBoxByID(pageProperties.getProperty("CorporateContactUs.marketingconsent"), "Marketing Consent");
		verifyAndClickWithXpath(pageProperties.getProperty("CorporateContactUs.submitButton"), "Submit");
	}
	 public void verifyThankYouPage(){
		// verifyIsElementVisibleWithXpath(pageProperties.getProperty("CorporateContactUs.ThankYouPage"),"Thank you page");
		 verifyIsTextPresent("Thank you");
	 }
	public void verifyLeadTable(UserProfile userProfile){
		OnlineDBConnector dbFunctions = new OnlineDBConnector();
		String date=dbFunctions.DBsysdateDdmmyyhhmi();
		String leadType[] = dbFunctions.verifyleadDBForLeadType(date,userProfile.getEmail(),"Training_Contact_Us");		
		Report.updateTestLog("Lead type is "+leadType[0] +". Hence email sent to both the customer and agent", leadType[0].equalsIgnoreCase("0")?"PASS":"FAIL");
		Report.updateTestLog("Lead status is "+leadType[1] +".", leadType[1].equalsIgnoreCase("Training_Contact_Us")?"PASS":"FAIL");
		Report.updateTestLog("Title validation is done."+leadType[2], leadType[2].equals(userProfile.getTitle())?"PASS":"FAIL");
		Report.updateTestLog("First name validation is done."+leadType[3], leadType[3].equals(userProfile.getFirstName())?"PASS":"FAIL");
		Report.updateTestLog("Sur name validation is done."+leadType[4], leadType[4].equals(userProfile.getLastName())?"PASS":"FAIL");
		Report.updateTestLog("Contact number validation is done."+leadType[6], leadType[6].equals(userProfile.getPhoneNumber())?"PASS":"FAIL");
		Report.updateTestLog("MARKETING_CONSENT validation is done."+leadType[8], leadType[8].equals("Y")?"PASS":"FAIL");
		Report.updateTestLog("Email address validation is done."+leadType[13], leadType[13].equals(userProfile.getEmail())?"PASS":"FAIL");
		Report.updateTestLog("Country validation is done."+leadType[14], leadType[14].equals(userProfile.getCountry())?"PASS":"FAIL");
		Report.updateTestLog("Course validation is done."+leadType[15], leadType[15].equals("Functional")?"PASS":"FAIL");
		
		/*String[] auditType = dbFunctions.getAuditEventTypeId(date, userProfile.getEmail());
		String data = dbFunctions.getAuditType(auditType[0]);	
		Report.updateTestLog("Audit id is made in audit table as expected. Audit id: "+auditType[0]+ " Audit event type is"+data, data.equalsIgnoreCase("CORPORATE_CONTACT_US_CUSTOMER_EMAIL_SENT_SUCCESS")?"PASS":"FAIL");
*/
	}
 public void validateFieldsInTrainingContactUs(UserProfile userProfile){
	   String[] town = {"","60045667567","abc!@#$det","600abcd456!@#%$^^&"};	   
	   String[] course = {"","functional!#%#$$^"};	   
	  	for(int i = 0; i<town.length;i++){
		switch(i){
		case 0:
			enterFieldValidationData(userProfile,town[i],course[i]);
			String errormsg[] = {TetrisErrorMessages.Tetris_EmptyTown,TetrisErrorMessages.Tetris_EmptyCourse};
			errorMessageComparison(errormsg);	    			
			break;
		case 1:
			enterFieldValidationData(userProfile,town[i],course[i]);
			String IncorrectErrormsg[] = {TetrisErrorMessages.Tetris_IncorrectTownName,TetrisErrorMessages.Tetris_IncorrectCourse};
			errorMessageComparison(IncorrectErrormsg);
			break;  		
		
	  	default:
	  		enterFieldValidationData(userProfile,town[i],"Functional");
				String IncorrectErrormsg1[] = {TetrisErrorMessages.Tetris_IncorrectTownName};
				errorMessageComparison(IncorrectErrormsg1);
				break; 	
			  	
		}
	
	}
}
//Capture the error message displayed and verify the actual and error message displayed by making a call to the verifyErrorMessage method
public void errorMessageComparison(final String expectedErrorMsg[]) {
	try{
		for(int i=0;i<expectedErrorMsg.length; i++){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("MarketingConsent.ErrorMsgPath"))){
		        final String displayedErrorMsg = browser.getTextByXpath(pageProperties.getProperty("MarketingConsent.ErrorMsgPath"));
		        verifyErrorMessage(displayedErrorMsg, expectedErrorMsg[i]);
		        }
			else{
				Report.updateTestLog("Error message is not displayed for this scenario", "FAIL");
			}
		       }
		}
	catch(Exception e){
		//Report.updateTestLog("Exception occured"+e, "FAIL");
	}
}


//Validation for Inappropriate data for the fields displayed in Forgot Email Compare the error message displayed in the application against the Expected data  	 
public void verifyErrorMessage(final String displayedErrorMsg, final String expectedErrorMsg) {
	
    if (displayedErrorMsg.trim().contains(expectedErrorMsg.trim())) {
        Report.updateTestLog("Error message validation. Expected message:" +expectedErrorMsg+" Actual message:"+ displayedErrorMsg, "PASS");
    } else {
   	 Report.updateTestLog("Error message validation. Expected message:" +expectedErrorMsg+" Actual message:"+ displayedErrorMsg, "FAIL");
    }
}
public void enterFieldValidationData(UserProfile userProfile,String town, String course){
	verifyAndSelectDropDownBox(pageProperties.getProperty("CorporateContactUs.Title"), "Title", userProfile.getTitle());
	verifyAndInputById(pageProperties.getProperty("CorporateContactUs.firstname"), "First Name", userProfile.getFirstName());
	verifyAndInputById(pageProperties.getProperty("CorporateContactUs.surname"), "Last Name", userProfile.getLastName());
	verifyAndInputById(pageProperties.getProperty("CorporateContactUs.email"), "Email", userProfile.getEmail());
	verifyAndInputById(pageProperties.getProperty("CorporateContactUs.contactnumber"), "Contactnumber", userProfile.getPhoneNumber());
	verifyAndInputById(pageProperties.getProperty("TrainingContactUs.postaltown"), "Country", town);
	verifyAndInputById(pageProperties.getProperty("CorporateContactUs.Course"), "Course",course);
	verifyAndSelectCheckBoxByID(pageProperties.getProperty("CorporateContactUs.marketingconsent"), "Marketing Consent");
	verifyAndClickWithXpath(pageProperties.getProperty("CorporateContactUs.submitButton"), "Submit");
}
}
