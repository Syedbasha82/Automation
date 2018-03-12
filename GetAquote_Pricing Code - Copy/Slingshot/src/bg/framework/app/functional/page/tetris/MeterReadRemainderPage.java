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
public class MeterReadRemainderPage extends BasePage{
	private final static String FILE_NAME = "resources/tetris/MeterReadRemainderPage.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	
	public void openMeterReadRemainderPage(){
		browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("MeterReadRemainder.URL"));
		browser.wait(getWaitTime());
		verifyAndClickWithXpath(pageProperties.getProperty("MeterReadRemainder.OverlayLink"),"Overlay link");
		browser.wait(getWaitTime());
	}
	
	public void entervalidData(UserProfile userProfile){		
		verifyAndInputById(pageProperties.getProperty("MeterReadRemainder.Name"), "Name", userProfile.getFirstName());
		verifyAndInputById(pageProperties.getProperty("MeterReadRemainder.email"), "Email", userProfile.getEmail());
		verifyAndInputById(pageProperties.getProperty("MeterReadRemainder.accountNumber"), "Account number", userProfile.getAccNumber());
		verifyAndInputById(pageProperties.getProperty("MeterReadRemainder.remainderbpnumber"), "Site number", userProfile.getBpnumber());
		verifyAndClickWithXpath(pageProperties.getProperty("MeterReadRemainder.submitButton"), "Submit");
	}
	public void verifyThankYouPage(){
		  verifyIsTextPresent("Thank you");
	 }
	public void verifyLeadTable(UserProfile userProfile){
		OnlineDBConnector dbFunctions = new OnlineDBConnector();
		try{
		String date=dbFunctions.DBsysdateDdmmyyhhmi();
		String leadType[] = dbFunctions.verifyMeterRemainderTable(date,userProfile.getEmail());		
		Report.updateTestLog("LEAD_STATUS verification."+"Lead status is: "+leadType[4] +". Hence email sent to both the customer and agent", leadType[4].equalsIgnoreCase("0")?"PASS":"FAIL");
		Report.updateTestLog("ACCOUNT_NUMBER verification. Expected : "+userProfile.getAccNumber()+"Actual : "+leadType[0] +".", leadType[0].equalsIgnoreCase(userProfile.getAccNumber())?"PASS":"FAIL");
		Report.updateTestLog("SITE_NUMBER verification. Expected : "+userProfile.getBpnumber()+"Actual : "+leadType[1] +".", leadType[1].equalsIgnoreCase(userProfile.getBpnumber())?"PASS":"FAIL");
		Report.updateTestLog("CUSTOMER_NAME verification. Expected : "+userProfile.getFirstName()+"Actual : "+leadType[2] +".", leadType[2].equalsIgnoreCase(userProfile.getFirstName())?"PASS":"FAIL");
		Report.updateTestLog("EMAIL_ADDRESS verification. Expected : "+userProfile.getEmail()+"Actual : "+leadType[3] +".", leadType[3].equalsIgnoreCase(userProfile.getEmail())?"PASS":"FAIL");
		String[] auditType = dbFunctions.getAuditEventTypeId(date, userProfile.getEmail(),"");
		String data = dbFunctions.getAuditType(auditType[0]);	
		Report.updateTestLog("Audit id is made in audit table as expected. Audit id: "+auditType[0]+ " Audit event type is"+data, data.equalsIgnoreCase("METER_REMINDER_EMAIL_SENT_SUCCESS")?"PASS":"FAIL");
		if(auditType[1].contains(userProfile.getEmail())&&auditType[1].contains(userProfile.getAccNumber())&&auditType[1].contains(userProfile.getBpnumber())&&auditType[1].contains(userProfile.getFirstName())){
			Report.updateTestLog("Audit data is made in audit table as expected. Audit entry: "+auditType[1],"PASS");			
		}
		else{
			Report.updateTestLog("Audit data is made in audit table as expected. Audit entry: "+auditType[1],"FAIL");
		}}
		catch(Exception e){
			Report.updateTestLog("Exception occured"+e, "FAIL");
		}
		}
	public void validateFieldsInMeterReadReminderPage(UserProfile userProfile){
		   String[] siteNum = {"","abcdefgh","%^&*!@#$","1234"};	  
		   
		  	for(int i = 0; i<siteNum.length;i++){
		
				enterFieldValidationData(userProfile,siteNum[i]);
				String errormsg[] = {TetrisErrorMessages.Tetris_EmptySiteNumber};
				errorMessageComparison(errormsg);
		
		}
	}
	//Capture the error message displayed and verify the actual and error message displayed by making a call to the verifyErrorMessage method
	public void errorMessageComparison(final String expectedErrorMsg[]) {
		try{
			for(int i=0;i<expectedErrorMsg.length; i++){
				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("MeterReadRemainder.ErrorMsgPath"))){
			        final String displayedErrorMsg = browser.getTextByXpath(pageProperties.getProperty("MeterReadRemainder.ErrorMsgPath"));
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
	public void enterFieldValidationData(UserProfile userProfile,String siteNumber){
		verifyAndInputById(pageProperties.getProperty("MeterReadRemainder.Name"), "Name", userProfile.getFirstName());
		verifyAndInputById(pageProperties.getProperty("MeterReadRemainder.email"), "Email", userProfile.getEmail());
		verifyAndInputById(pageProperties.getProperty("MeterReadRemainder.accountNumber"), "Account number", userProfile.getAccNumber());
		verifyAndInputById(pageProperties.getProperty("MeterReadRemainder.remainderbpnumber"), "Site number", siteNumber);
		verifyAndClickWithXpath(pageProperties.getProperty("MeterReadRemainder.submitButton"), "Submit");
	
	}
}
