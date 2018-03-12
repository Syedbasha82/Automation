package bg.framework.app.functional.page.Slingshot;

import java.util.Properties;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.SlingshotErrorMessages;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.OnlineDBConnector;

public class CustomerServiceAgentPage extends BasePage {
	private final static String FILE_NAME = "resources/Slingshot/CustomerServiceAgent.properties";	    
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	SlingshotErrorMessages errormsg = new SlingshotErrorMessages();
	public static final String TIMESTAMP_FORMATTER= "dd MMM, yyyy hh:mm:ss";
	public void verifyCsaAgentScreen() {
		//browser.open("http://10.224.70.18/content/bgbusiness/youraccount/csa/AgentHomepage.html");
    	
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CustomerServiceAgent.LookUpUser"))){
    		Report.updateTestLog("Look up user link is displayed successfully", "Pass");
    	}else{
    		Report.updateTestLog("Look up user link is not displayed", "Fail");
    	}
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CustomerServiceAgent.RegisteraUser"))){
    		Report.updateTestLog("Register a user link is displayed successfully", "PASS");
    	}else{
    		Report.updateTestLog("Register a user link is not displayed", "Fail");
    	}
    	        
        browser.wait(getWaitTime());
    
    }
	
	public void clickRegisteraUser() {
    	
		verifyAndClickWithXpath(pageProperties.getProperty("CustomerServiceAgent.RegisteraUser"), "Register a user");    
    }
	
	public void clickLookUpUser(){
		verifyAndClickWithXpath(pageProperties.getProperty("CustomerServiceAgent.LookUpUser"), "LookUp User"); 
	}
   public void enterRegisterEmail(UserProfile userProfile) {
	   
	   verifyAndInputById(pageProperties.getProperty("CustomerServiceAgent.EmailAddress"), "Email Address",userProfile.getEmail());
    }
   public void clickRegisterButton() {
	   
	   verifyAndClickWithXpath(pageProperties.getProperty("CustomerServiceAgent.RegisterButton"), "Register Button");
    }
   public void clickFindUser() {
	   
	   verifyAndClickWithXpath(pageProperties.getProperty("CustomerServiceAgent.findUser"), "Find User Button");
    }
	public void verifyAfterRegistration(UserProfile userProfile) {
   
	   verifyPageTitle(pageProperties.getProperty("CustomerServiceAgent.PageAfterRegister"));
	   verifyIsTextPresent(userProfile.getEmail(), "Email address initiated");
	    }
	public String getErrorMsgLookUpUser(){
		String errormsgvalue="";
		try{
		 errormsgvalue=browser.getTextByXpath(pageProperties.getProperty("CustomerServiceAgent.ErrorMsg"));
		}catch(Exception e){
			Report.updateTestLog("Exception occured while retrieving error msg", "Fail");
		}
		return errormsgvalue;
	}
	
public void validateBpNumber(){
    	
    	String bpnumber[]={"","abvdfddf","12345!@","12345678910"};
    	
    	for(int iterate=0;iterate < bpnumber.length;iterate++){
    	verifyAndInputById(pageProperties.getProperty("CustomerServiceAgent.BpNumber"),"Customer BP Number",bpnumber[iterate]);
    	clickFindUser();
        browser.wait(2000);
        String errormsgvalue=getErrorMsgLookUpUser();
        switch(iterate){
          case 0:
        	  
        	  Report.updateTestLog("Expected Result: "+errormsg.Csa_EmptyBpNumber+" Actual Result: "+errormsgvalue,errormsgvalue.contains(errormsg.Csa_EmptyBpNumber)?"Pass":"Fail");
           break;
          case 1:
        	  
        	  Report.updateTestLog("Expected Result: "+errormsg.Csa_Alphabets+" Actual Result: "+errormsgvalue,errormsgvalue.contains(errormsg.Csa_Alphabets)?"Pass":"Fail");
           break;
          case 2:
        	  Report.updateTestLog("Expected Result: "+errormsg.Csa_SpecialCharacters+" Actual Result: "+errormsgvalue,errormsgvalue.contains(errormsg.Csa_SpecialCharacters)?"Pass":"Fail");
           break; 
          case 3:
        	  
        	  Report.updateTestLog("Expected Result: "+errormsg.Csa_NotInCrm+" Actual Result: "+errormsgvalue,errormsgvalue.contains(errormsg.Csa_NotInCrm)?"Pass":"Fail");
           break;
        }
    	}
    	
    }
public void enterEmailIdInFindUser(UserProfile userProfile){
	verifyAndInputById(pageProperties.getProperty("CustomerServiceAgent.LookUpEmailAddress"), "Email Address",userProfile.getEmail());
}

public void verifyUpdateUserDetailsPage(){
	verifyPageTitle(pageProperties.getProperty("CustomerServiceAgent.Updatecustomerdetails"));
	verifyIsTextPresent("Update user details");
	verifyIsTextPresent("User account information");
	verifyIsTextPresent("Send forget password link");
//	verifyIsElementVisibleById("100", pageProperties.getProperty("CustomerServiceAgent.SubmitButton"));
	Report.updateTestLog("Submit button- Expected Result: Submit button visible"+
     " Actual Result: Submit button is not visible",browser.isElementVisible(pageProperties.getProperty("CustomerServiceAgent.SubmitButton"))?"Pass":"Fail");
	verifyIsElementVisibleById(pageProperties.getProperty("CustomerServiceAgent.ActiveRadioButton"), "Active radio button");
	verifyIsElementVisibleById(pageProperties.getProperty("CustomerServiceAgent.ActiveRadioButton"), "Locked radio button");
	if(browser.isElementVisible(pageProperties.getProperty("CustomerServiceAgent.ActiveRadioButton"))){	
		String isradio=browser.getAttribute(pageProperties.getProperty("CustomerServiceAgent.ActiveRadioButton"),"type");
		Report.updateTestLog("Radio button 'Active Account' - Expected Result: Type - radio"+" Actual Result: "+isradio,isradio.equalsIgnoreCase("radio")?"Pass":"Fail");		
	}else{
		Report.updateTestLog("Radio button for 'Active account' is not displayed","Fail");
	}
	if(browser.isElementVisible(pageProperties.getProperty("CustomerServiceAgent.LockedRadioButton"))){	
		String isradio=browser.getAttribute(pageProperties.getProperty("CustomerServiceAgent.LockedRadioButton"),"type");
		Report.updateTestLog("Radio button for 'Locked account'- Expected Result: Type - radio"+" Actual Result: "+isradio,isradio.equalsIgnoreCase("radio")?"Pass":"Fail");		
	}else{
		Report.updateTestLog("Radio button for 'Locked account' is not displayed","Fail");
	}
	if(browser.isElementVisible(pageProperties.getProperty("CustomerServiceAgent.FreezeAccountCheckBox"))){	
		String ischeck=browser.getAttribute(pageProperties.getProperty("CustomerServiceAgent.FreezeAccountCheckBox"),"type");
		Report.updateTestLog("Check box for Freeze account - Expected Result: Type - checkbox"+" Actual Result: "+ischeck,ischeck.equalsIgnoreCase("checkbox")?"Pass":"Fail");		
	}else{
		Report.updateTestLog("Check box for 'Freeze account' is not displayed","Fail");
	}
	
	if(browser.isElementVisible(pageProperties.getProperty("CustomerServiceAgent.PasswordCheckBox"))){	
		String ischeck=browser.getAttribute(pageProperties.getProperty("CustomerServiceAgent.PasswordCheckBox"),"type");
		Report.updateTestLog("Check box for Password link - Expected Result: Type - checkbox"+" Actual Result: "+ischeck,ischeck.equalsIgnoreCase("checkbox")?"Pass":"Fail");		
	}else{
		Report.updateTestLog("Check box for 'Password link' is not displayed","Fail");
	}
	if(browser.isElementVisible(pageProperties.getProperty("CustomerServiceAgent.PasswordSendLink"))){	
		String ischeck=browser.getAttribute(pageProperties.getProperty("CustomerServiceAgent.PasswordSendLink"),"type");
		Report.updateTestLog("Button for Password link - Expected Result: Type - radio"+" Actual Result: "+ischeck,ischeck.equalsIgnoreCase("button")?"Pass":"Fail");		
	}else{
		Report.updateTestLog("Button for 'Password link' is not displayed","Fail");
	}
	verifyIsTextPresent("Email address validated:");
	verifyIsTextPresent("Business Partner contact person:");
	verifyIsTextPresent("Email address:");
	verifyIsTextPresent("Last login:");
	verifyIsTextPresent("Current status:");
}

public void verifyAccountStatus(UserProfile userProfile){
	
	String strRetreiveEmailQry="Select PROFILE_STATUS from BG_BUSINESS_TA_CUSTOMER_REG where " +
			"EMAIL="+userProfile.getEmail();
	String query=strRetreiveEmailQry.replace("emailid",userProfile.getEmail().toLowerCase());
	System.out.println("query is  :"+query);
	 String status=new OnlineDBConnector().getColumn("PROFILE_STATUS", query);
	 if(status.equalsIgnoreCase("ACTIVE")){
		boolean isradio=browser.isSelected(pageProperties.getProperty("CustomerServiceAgent.ActiveRadioButton"));
		Report.updateTestLog("Expected Result: status selected :"+status+" Actual Result: "+isradio,true?"Pass":"Fail");
	 }else if(status.equalsIgnoreCase("LOCKED")){
		boolean isradio=browser.isSelected(pageProperties.getProperty("CustomerServiceAgent.LockedRadioButton"));
		Report.updateTestLog("Expected Result: status selected :"+status+" Actual Result: "+isradio,true?"Pass":"Fail");
	 }else if(status.equalsIgnoreCase("FREEZED")){
		 boolean ischecked=browser.isSelected(pageProperties.getProperty("CustomerServiceAgent.FreezeAccountCheckBox"));
		 Report.updateTestLog("Expected Result: status selected :"+status+" Actual Result: "+ischecked,true?"Pass":"Fail");
	 }
}

public String verifyProfileStatusInDb(UserProfile userProfile){
	
	String strRetreiveEmailQry="Select PROFILE_STATUS from BG_BUSINESS_TA_CUSTOMER_REG where " +
			"EMAIL='"+userProfile.getEmail()+"'";
	String query=strRetreiveEmailQry.replace("emailid",userProfile.getEmail().toLowerCase());
	System.out.println("query is  :"+query);
	 String status=new OnlineDBConnector().getColumn("PROFILE_STATUS", query);
	 if(status!=null){
		 return status;
	 }else{
		 status="null";
		 return status; 
	 }
}

public String verifyFreezeStatus(UserProfile userProfile){
	
	String strRetreiveEmailQry="Select FREEZE_ACCOUNT_FLAG from BG_BUSINESS_TA_CUSTOMER_REG where " +
			"EMAIL='"+userProfile.getEmail()+"'";
	String query=strRetreiveEmailQry.replace("emailid",userProfile.getEmail().toLowerCase());
	System.out.println("query is  :"+query);
	 String status=new OnlineDBConnector().getColumn("FREEZE_ACCOUNT_FLAG", query);
	 if(status!=null){
		 return status;
	 }else{
		 status="null";
		 return status; 
	 }
}
public void verifyStatusInUi(UserProfile userProfile){
	String status=verifyProfileStatusInDb(userProfile);
	if(status.equalsIgnoreCase("ACTIVE")){
		boolean isradio=browser.isSelected(pageProperties.getProperty("CustomerServiceAgent.ActiveRadioButton"));
		Report.updateTestLog("ACTIVE Radio button :Expected Result: true Actual Result: "+isradio,true?"Pass":"Fail");
	 }else if(status.equalsIgnoreCase("LOCKED")){
		boolean isradio=browser.isSelected(pageProperties.getProperty("CustomerServiceAgent.LockedRadioButton"));
		Report.updateTestLog("LOCKED Radio button :Expected Result: true Actual Result: "+isradio,true?"Pass":"Fail");
	 }else if(status.equalsIgnoreCase("FREEZED")){
		 boolean ischecked=browser.isSelected(pageProperties.getProperty("CustomerServiceAgent.FreezeAccountCheckBox"));
		 Report.updateTestLog("FREEZED Check box :Expected Result: true Actual Result: "+ischecked,true?"Pass":"Fail");
	 }
}

public void verifyUserAccountInfoInDb(UserProfile userProfile){
	String[] status=new OnlineDBConnector().verifyUserAccountInfo(userProfile.getEmail().toLowerCase());
	if(status!=null){
		try{						
		String emailvalidated=browser.getTextByXpath(pageProperties.getProperty("CustomerServiceAgent.Emailvalidated"));	
		String bpcp=browser.getTextByXpath(pageProperties.getProperty("CustomerServiceAgent.BpcpNumber"));
		String email=browser.getTextByXpath(pageProperties.getProperty("CustomerServiceAgent.EmailDisplayed"));
		String lastlogin=browser.getTextByXpath(pageProperties.getProperty("CustomerServiceAgent.LastLogin"));
		String currentstatus=browser.getTextByXpath(pageProperties.getProperty("CustomerServiceAgent.CurrentStatus"));
		Report.updateTestLog("UserAccountInfo-Email validated-Expected Result: "+status[0]+"  Actual Result: "+emailvalidated,emailvalidated.contains(status[0])?"Pass":"Fail");
		Report.updateTestLog("UserAccountInfo-Business Partner number-Expected Result: "+status[1]+"  Actual Result: "+bpcp,bpcp.equals(status[1])?"Pass":"Fail");
		Report.updateTestLog("UserAccountInfo-Email Address-Expected Result: "+status[2]+"  Actual Result: "+email,email.contains(status[2])?"Pass":"Fail");
		Report.updateTestLog("UserAccountInfo-Profile status-Expected Result: "+status[4]+"  Actual Result: "+currentstatus,currentstatus.contains(status[4])?"Pass":"Fail");
		System.out.println("status(3)"+status[3]);
		DateTimeFormatter parser = DateTimeFormat.forPattern("yyyy-mm-dd hh:mm:ss.SSS");
		DateTime readate = parser.parseDateTime(status[3]);
		System.out.println("readate:"+readate);
		String readDate=readate.toString(TIMESTAMP_FORMATTER);
        System.out.println("readdate"+readDate);
		Report.updateTestLog("UserAccountInfo-Last login-Expected Result: "+readDate+"  Actual Result: "+lastlogin,lastlogin.contains(readDate)?"Pass":"Fail");
	
		}catch(Exception e){
			Report.updateTestLog("Exception occured while retrieving value in UI"+e,"Fail");
		}
		
	}
	
}

public void updateStatusInUi(UserProfile userProfile,String status){
	
   if(status.equalsIgnoreCase("FREEZED")){	
     verifyAndSelectCheckBoxByID(pageProperties.getProperty("CustomerServiceAgent.FreezeAccountCheckBox"), "Freeze Account Checkbox");
//     verifyCheckBoxSelectedWithXpath(pageProperties.getProperty("CustomerServiceAgent.FreezeAccountCheckBox"), "Freeze Account Checkbox");
   }else if(status.equalsIgnoreCase("ACTIVE")){
	 verifyAndClick(pageProperties.getProperty("CustomerServiceAgent.ActiveRadioButton"), "ActiveRadioButton");  
   }else if(status.equalsIgnoreCase("LOCKED")){
	 verifyAndClick(pageProperties.getProperty("CustomerServiceAgent.LockedRadioButton"), "LockedRadioButton");  
   }
   verifyAndClick(pageProperties.getProperty("CustomerServiceAgent.SubmitButton"), "Submit button");
   verifyPageTitle(pageProperties.getProperty("CustomerServiceAgent.TitleAfterStatusUpdate"));
   
   }

public void verifyStatusInDbAfterUpdated(UserProfile userProfile,String status){
	if(status.equalsIgnoreCase("Y")){
	String statusDb=verifyFreezeStatus(userProfile);
	Report.updateTestLog("Freezed account Status - Expected Result: "+status+" Actual Result: "+statusDb,statusDb.equalsIgnoreCase("Y")?"Pass":"Fail");
	}else if(status.equalsIgnoreCase("LOCKED")){
	String profilestatus=verifyProfileStatusInDb(userProfile);	
	Report.updateTestLog("Locked account Status - Expected Result: "+status+" Actual Result: "+profilestatus,profilestatus.equalsIgnoreCase(status)?"Pass":"Fail");
	}
}

public void updateOrRevertProfileStatusInDb(UserProfile userProfile,int state,String valdiation){
	
	new OnlineDBConnector().updateorRevertProfileRegistration(userProfile,state,valdiation);	
}

public void registerEmailErrorMessageValidation(UserProfile userProfile) {
	
	String[] email = new String[3];
	email[0]="";
	email[1]="qw2w3@w3w@bgtest.co.uk";
	email[2]=userProfile.getEmail();
	enterInvalidEmail(userProfile,email[0]);
	getErrorMsgRegisterScreen(errormsg.Csa_RegisterEmailEmpty);
	enterInvalidEmail(userProfile,email[1]);
	getErrorMsgRegisterScreen(errormsg.Csa_RegisterEmailIncorrectFormat);
	enterInvalidEmail(userProfile,email[2]);
	getErrorMsgRegisterScreen(errormsg.Csa_RegisterExistingEmail);
	
}

public void enterInvalidEmail(UserProfile userProfile,String value){
	
	verifyAndInputById(pageProperties.getProperty("CustomerServiceAgent.EmailAddress"), "Email Id",value);		
	clickRegisterButton();
    getWaitTime();
}

public void getErrorMsgRegisterScreen(String emailErrorMessage) {
	try{
	String errormsgvalue=browser.getTextByXpath(pageProperties.getProperty("CustomerServiceAgent.RegisterPageError"));
	Report.updateTestLog("Error Message - Expected Result: "+emailErrorMessage+" Actual Result: "+errormsgvalue,errormsgvalue.contains(emailErrorMessage)?"Pass":"Fail");
	}catch(Exception e){
		Report.updateTestLog("Error locating xpath in error msg section :"+e, "Fail");
		browser.browserBack();
	}
		
}

public void lookupEmailErrorMessageValidation(UserProfile userProfile) {
	
	String[] email = new String[2];
	email[0]="qw2w3@w3@w@bgtest.co.uk";
	email[1]="";
	enterInvalidEmailLookUp(userProfile,email[0]);
	getErrorMsgRegisterScreen(errormsg.Csa_LookupEmailIncorrectFormat);
	enterInvalidEmailLookUp(userProfile,email[1]);
	getErrorMsgRegisterScreen(errormsg.Csa_RegisterEmailEmpty);
}

public void enterInvalidEmailLookUp(UserProfile userProfile,String value){
	
	verifyAndInputById(pageProperties.getProperty("CustomerServiceAgent.EmailAddress"), "Email Id",value);		
	clickFindUser();
    getWaitTime();
}

public void clickCsaLoginInThankYouPage(){
	
	verifyAndClickWithXpath(pageProperties.getProperty("CustomerServiceAgent.CsaLoginInThankYouPage"), "CSA Login");		

}

public void checkPasswordResetLink(){
	
	verifyAndClickWithXpath(pageProperties.getProperty("CustomerServiceAgent.CsaLoginInThankYouPage"), "CSA Login");		

}


public void checkPasswordReset(){
	verifyAndSelectCheckBoxByID(pageProperties.getProperty("CustomerServiceAgent.PasswordCheckBox"), "Password");
	verifyAndClick(pageProperties.getProperty("CustomerServiceAgent.PasswordSendLink"),"Send Link");
}

public void verifyPasswordResetPage(){
	verifyPageTitle("Confirmation");
}

public void enterNewPassword(){
	//browser.open("http://10.224.70.18/content/bgbusiness/your-account/login/forgotten-password/new-password.html");
	browser.open("https://10.224.70.18/business/new-password");
	verifyPageTitle("Password reset");
    verifyAndInputById(pageProperties.getProperty("CustomerServiceAgent.NewPassword"), "NewPassword", "passwor123");
    verifyAndInputById(pageProperties.getProperty("CustomerServiceAgent.ConfirmPassword"), "ConfirmPassword", "passwor123");
    verifyAndClick(pageProperties.getProperty("CustomerServiceAgent.PasswordContinueButton"), "Continue");
    verifyPageTitle("Password reset success");
}

public void resetOldPassword(UserProfile userProfile){
	//new OnlineDBConnector().updatePassword(userProfile, "EMKPnPBmhZXUXBCQp7Sirpjt+lg=");
}

public void verifyResetPasswordFlag(UserProfile userProfile){
	
	String strRetreiveEmailQry="Select PASSWORD_RESET_REQUEST_FLAG from BG_BUSINESS_TA_CUSTOMER_REG where " +
			"EMAIL='emailid'";
	String query=strRetreiveEmailQry.replace("emailid",userProfile.getEmail());
	System.out.println("query is  :"+query);
	if(new OnlineDBConnector().getColumn("PASSWORD_RESET_REQUEST_FLAG", query)!=null){
		String status=new OnlineDBConnector().getColumn("PASSWORD_RESET_REQUEST_FLAG", query);
		Report.updateTestLog("Password reset request flag - Expected Result: Y"+" Actual Result: "+status,status.equalsIgnoreCase("Y")?"Pass":"Fail");
	}else{
		Report.updateTestLog("PASSWORD_RESET_REQUEST_FLAG value is Null","Fail");
	}
	
	
}

public void enterBpNumberFindUser(UserProfile userProfile){
	
	String strRetreiveEmailQry="Select BP_CONTACT_PERSON_NUMBER from BG_BUSINESS_TA_CUSTOMER_REG where " +
			"EMAIL='emailid'";
	String query=strRetreiveEmailQry.replace("emailid",userProfile.getEmail());
	System.out.println("query is  :"+query);
	if(new OnlineDBConnector().getColumn("BP_CONTACT_PERSON_NUMBER", query)!=null){
		String status=new OnlineDBConnector().getColumn("BP_CONTACT_PERSON_NUMBER", query);
		verifyAndInputById(pageProperties.getProperty("CustomerServiceAgent.BpNumber"), "BpNumber",status);
	}else{
		Report.updateTestLog("BP_CONTACT_PERSON_NUMBER value is Null","Fail");
	}
	
}

public void checkStatus(UserProfile userProfile,String status){
	if(status.equalsIgnoreCase("FREEZED")){	
		verifyAndClick(pageProperties.getProperty("CustomerServiceAgent.FreezeAccountCheckBox"), "Freeze Account Checkbox");
	   }else if(status.equalsIgnoreCase("ACTIVE")){
		 verifyAndClick(pageProperties.getProperty("CustomerServiceAgent.ActiveRadioButton"), "ActiveRadioButton");  
	   }else if(status.equalsIgnoreCase("LOCKED")){
		 verifyAndClick(pageProperties.getProperty("CustomerServiceAgent.LockedRadioButton"), "LockedRadioButton");  
	   }
	   verifyAndClick(pageProperties.getProperty("CustomerServiceAgent.SubmitButton"), "Submit button");
}

public void verifyErrorMsg(){
	
	try{
		String getError=browser.getTextByXpath((pageProperties.getProperty("CustomerServiceAgent.ErrorMsg")));
		Report.updateTestLog("Un Freeze status - Expected Result:"+errormsg.Csa_UnfreezeError+" Actual Result: "+getError,getError.contains(errormsg.Csa_UnfreezeError)?"Pass":"Fail");
		
	}catch(Exception e){
		Report.updateTestLog("Exception occured while fetching the error message :"+e,"Fail");
	}
}
}


