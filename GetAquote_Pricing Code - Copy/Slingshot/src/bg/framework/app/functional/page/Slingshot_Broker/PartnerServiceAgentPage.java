/**
 * 
 */
package bg.framework.app.functional.page.Slingshot_Broker;


import java.util.Arrays;
import java.util.Properties;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.Slingshot.Encryption;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;




/**
 * @author 208070
 *
 */
public class PartnerServiceAgentPage extends BasePage {

	private final static String PSAFILE_NAME = "resources/Slingshot_Broker/PartnerServiceAgent.Properties";     
	private static Properties PSAProperties = new PropertyLoader(PSAFILE_NAME).load();
	public static final String TIMESTAMP_FORMATTER= "dd MMMM, yyyy hh:mm:ss";
	public void navigateToPSARegistration() {
		browser.open(ApplicationConfig.APP_BG_URL+PSAProperties.getProperty("PSA.BrokerPSALink"));
		getWaitTime();
	}

	public void clickRegisteraUser(UserProfile userProfile) {
    	verifyAndClickWithXpath(PSAProperties.getProperty("PSA.RegisteraUser"), "Register a user");
    	getWaitTime();
    	verifyPageTitle("Register");
    	browser.wait(10000);
    	verifyAndInputByXpath(PSAProperties.getProperty("PSA.Email"), "Email Address",userProfile.getEmail());
    	verifyAndInputByXpath(PSAProperties.getProperty("PSA.ConfirmEmail"), "Confirm Email Address",userProfile.getEmail());
    	verifyAndClickWithXpath(PSAProperties.getProperty("PSA.RegisterBtn"), "Register Button");
    	verifyPageTitle("Registration link sent");
    	verifyIsTextPresent("Registration process started");
    	verifyIsTextPresent("An email has been sent to:"+userProfile.getEmail()+".");
    	verifyIsTextPresent("Please ask user to check their email address and follow the steps to complete registration");
       }

	public void clickLookUpUser(){
		verifyAndClickWithXpath(PSAProperties.getProperty("PSA.LookUpUser"), "LookUp User"); 
	}
	
	public void enterEmailIdInFindUser(UserProfile userProfile){
		verifyAndInputById(PSAProperties.getProperty("PSA.LookUpEmailAddress"), "Email Address",userProfile.getEmail());
	}

	public void clickFindUser() {
		verifyAndClickWithXpath(PSAProperties.getProperty("PSA.findUser"), "Find User Button");
	    }
	
	public void verifyUpdateUserDetailsPage(){
		verifyPageTitle("Update user details");
		verifyIsTextPresent("Update user details");
		verifyIsTextPresent("Available action");
		verifyIsTextPresent("User account information");
		verifyIsTextPresent("Impersonate user");
		verifyIsTextPresent("Send forgot password link");
//		verifyIsElementVisibleById("100", PSAProperties.getProperty("PSA.SubmitButton"));
		Report.updateTestLog("Submit button- Expected Result: Submit button visible"+
	     " Actual Result: Submit button is not visible",browser.isElementVisible(PSAProperties.getProperty("PSA.SubmitButton"))?"Pass":"Fail");
		verifyIsElementVisibleById(PSAProperties.getProperty("PSA.ActiveRadioButton"), "Active radio button");
		verifyIsElementVisibleById(PSAProperties.getProperty("PSA.ActiveRadioButton"), "Locked radio button");
		if(browser.isElementVisible(PSAProperties.getProperty("PSA.ActiveRadioButton"))){	
			String isradio=browser.getAttribute(PSAProperties.getProperty("PSA.ActiveRadioButton"),"type");
			Report.updateTestLog("Radio button 'Active Account' - Expected Result: Type - radio"+" Actual Result: "+isradio,isradio.equalsIgnoreCase("radio")?"Pass":"Fail");		
		}else{
			Report.updateTestLog("Radio button for 'Active account' is not displayed","Fail");
		}
		if(browser.isElementVisible(PSAProperties.getProperty("PSA.LockedRadioButton"))){	
			String isradio=browser.getAttribute(PSAProperties.getProperty("PSA.LockedRadioButton"),"type");
			Report.updateTestLog("Radio button for 'Locked account'- Expected Result: Type - radio"+" Actual Result: "+isradio,isradio.equalsIgnoreCase("radio")?"Pass":"Fail");		
		}else{
			Report.updateTestLog("Radio button for 'Locked account' is not displayed","Fail");
		}
		if(browser.isElementVisible(PSAProperties.getProperty("PSA.FreezeAccountCheckBox"))){	
			String ischeck=browser.getAttribute(PSAProperties.getProperty("PSA.FreezeAccountCheckBox"),"type");
			Report.updateTestLog("Check box for Freeze account - Expected Result: Type - checkbox"+" Actual Result: "+ischeck,ischeck.equalsIgnoreCase("checkbox")?"Pass":"Fail");		
		}else{
			Report.updateTestLog("Check box for 'Freeze account' is not displayed","Fail");
		}
		
		/*if(browser.isElementVisible(PSAProperties.getProperty("PSA.PasswordCheckBox"))){	
			String ischeck=browser.getAttribute(PSAProperties.getProperty("PSA.PasswordCheckBox"),"type");
			Report.updateTestLog("Check box for Password link - Expected Result: Type - checkbox"+" Actual Result: "+ischeck,ischeck.equalsIgnoreCase("checkbox")?"Pass":"Fail");		
		}else{
			Report.updateTestLog("Check box for 'Password link' is not displayed","Fail");
		}
		if(browser.isElementVisible(PSAProperties.getProperty("PSA.PasswordSendLink"))){	
			String ischeck=browser.getAttribute(PSAProperties.getProperty("PSA.PasswordSendLink"),"type");
			Report.updateTestLog("Button for Password link - Expected Result: Type - radio"+" Actual Result: "+ischeck,ischeck.equalsIgnoreCase("button")?"Pass":"Fail");		
		}else{
			Report.updateTestLog("Button for 'Password link' is not displayed","Fail");
		}*/
		verifyIsTextPresent("Email address Validated");
		verifyIsTextPresent("Email address");
		verifyIsTextPresent("Last Login");
		verifyIsTextPresent("Current status");
	}
	public void verifyStatusInUi(UserProfile userProfile){
		String status=verifyProfileStatusInDb(userProfile);
		if(status.equalsIgnoreCase("ACTIVE")){
			boolean isradio=browser.isSelected(PSAProperties.getProperty("PSA.ActiveRadioButton"));
			Report.updateTestLog("ACTIVE Radio button :Expected Result: true Actual Result: "+isradio,true?"Pass":"Fail");
		 }else if(status.equalsIgnoreCase("LOCKED")){
			boolean isradio=browser.isSelected(PSAProperties.getProperty("PSA.LockedRadioButton"));
			Report.updateTestLog("LOCKED Radio button :Expected Result: true Actual Result: "+isradio,true?"Pass":"Fail");
		 }else if(status.equalsIgnoreCase("FREEZED")){
			 boolean ischecked=browser.isSelected(PSAProperties.getProperty("PSA.FreezeAccountCheckBox"));
			 Report.updateTestLog("FREEZED Check box :Expected Result: true Actual Result: "+ischecked,true?"Pass":"Fail");
		 }
	}

	public void verifyUserAccountInfoInDb(UserProfile userProfile){
		String[] status=new OnlineDBConnector().verifyUserAccountInfo(userProfile.getEmail().toLowerCase());
		if(status!=null){
			try{						
			String emailvalidated=browser.getTextByXpath(PSAProperties.getProperty("PSA.Emailvalidated"));	
			String email=browser.getTextByXpath(PSAProperties.getProperty("PSA.EmailDisplayed"));
			String lastlogin=browser.getTextByXpath(PSAProperties.getProperty("PSA.LastLogin"));
			String currentstatus=browser.getTextByXpath(PSAProperties.getProperty("PSA.CurrentStatus"));
			Report.updateTestLog("UserAccountInfo-Email validated-Expected Result: "+status[0]+"  Actual Result: "+emailvalidated,emailvalidated.contains(status[0])?"Pass":"Fail");
			Report.updateTestLog("UserAccountInfo-Email Address-Expected Result: "+status[2]+"  Actual Result: "+email,email.contains(status[2])?"Pass":"Fail");
			Report.updateTestLog("UserAccountInfo-Profile status-Expected Result: "+status[4].toUpperCase()+"  Actual Result: "+currentstatus.toUpperCase(),currentstatus.toUpperCase().contains(status[4].toUpperCase())?"Pass":"Fail");
			System.out.println("status(3)"+status[3]);
			System.out.println("status()"+ Arrays.asList(status));
			if(status[3]!="")
			{
			DateTimeFormatter parser = DateTimeFormat.forPattern("yyyy-MM-dd hh:mm:ss.SSS");
			DateTime readate = parser.parseDateTime("2014-09-06 10:25:36.247");
			System.out.println("Read Date:"+readate);
			String readDate=readate.toString(TIMESTAMP_FORMATTER);
			System.out.println("Read Date..."+readDate);
			Report.updateTestLog("UserAccountInfo-Last login-Expected Result: "+ readDate +"  Actual Result: "+lastlogin,lastlogin.contains(readDate)?"Pass":"Fail");
			}
			else{
			Report.updateTestLog("UserAccountInfo-Last login-Expected Result: "+ "" +"  Actual Result: "+lastlogin,lastlogin.contains(status[3])?"Pass":"Fail");
			}
			
			}catch(Exception e){
				Report.updateTestLog("Exception occured while retrieving value in UI"+e,"Fail");
			}
			
		}
		
	}
	public void updateStatusInUi(UserProfile userProfile,String status){
		
		   if(status.equalsIgnoreCase("FREEZED")){	
		     verifyAndSelectCheckBoxByID(PSAProperties.getProperty("PSA.FreezeAccountCheckBox"), "Freeze Account Checkbox");
//		     verifyCheckBoxSelectedWithXpath(PSAProperties.getProperty("PSA.FreezeAccountCheckBox"), "Freeze Account Checkbox");
		   }else if(status.equalsIgnoreCase("ACTIVE")){
			 verifyAndClick(PSAProperties.getProperty("PSA.ActiveRadioButton"), "ActiveRadioButton");  
		   }else if(status.equalsIgnoreCase("LOCKED")){
			 verifyAndClick(PSAProperties.getProperty("PSA.LockedRadioButton"), "LockedRadioButton");  
		   }
		   browser.wait(3000);
		   verifyAndClick(PSAProperties.getProperty("PSA.SubmitButton"), "Submit button");
		   verifyPageTitle(PSAProperties.getProperty("PSA.TitleAfterStatusUpdate"));
		   
		   }
	public void verifyStatusInDbAfterUpdated(UserProfile userProfile,String status){
		if(status.equalsIgnoreCase("Y")){
		String statusDb=verifyFreezeStatus(userProfile);
		verifyIsTextPresent("The account for " + userProfile.getEmail() + " is now active and deactivated");
		Report.updateTestLog("Freezed account Status - Expected Result: "+status+" Actual Result: "+statusDb,statusDb.equalsIgnoreCase("Y")?"Pass":"Fail");
		}else if(status.equalsIgnoreCase("LOCKED")){
		String profilestatus=verifyProfileStatusInDb(userProfile);	
		verifyIsTextPresent("The account for " + userProfile.getEmail() + " is now locked and reactivated");
		Report.updateTestLog("Locked account Status - Expected Result: "+status+" Actual Result: "+profilestatus,profilestatus.equalsIgnoreCase(status)?"Pass":"Fail");
		}
		else if(status.equalsIgnoreCase("ACTIVE")){
			String profilestatus=verifyProfileStatusInDb(userProfile);	
			verifyIsTextPresent("The account for " + userProfile.getEmail() + " is now active and reactivated");
			Report.updateTestLog("Locked account Status - Expected Result: "+status+" Actual Result: "+profilestatus,profilestatus.equalsIgnoreCase(status)?"Pass":"Fail");
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
	public void updateOrRevertProfileStatusInDb(UserProfile userProfile,int state,String valdiation){
		
		new OnlineDBConnector().updateorRevertProfileRegistration(userProfile,state,valdiation);	
	}
	public void clickCsaLoginInThankYouPage(){
		
		verifyAndClickWithXpath(PSAProperties.getProperty("PSA.CsaLoginInThankYouPage"), "CSA Login");		

	}
	public void verifyAfterRegistration(UserProfile userProfile) {
		   
		   verifyPageTitle(PSAProperties.getProperty("PSA.PageAfterRegister"));
		   verifyIsTextPresent(userProfile.getEmail(), "Email address initiated");
		    }

	public void verifyAuditTrail(UserProfile userProfile) {
		verifyAndClickWithLinkText(("View audit trail"),"View audit trail Link");
		verifyPageTitle("Audit login");
		verifyAndInputById(PSAProperties.getProperty("PSA.LookUpEmailAddress"), "Email Address",userProfile.getEmail());
		int days=DateTime.now().getDayOfMonth();
        String day=Integer.toString(days);
        System.out.println("joda day is:"+day);
        verifyAndClickWithXpath(PSAProperties.getProperty("PSA.AuditEndDate"), "AuditEndDate button");
		calenderDate(day);
		verifyAndClickWithXpath(PSAProperties.getProperty("PSA.AuditStartDate"), "AuditStartDate button");
		calenderDate(day);
		verifyAndClickWithXpath(PSAProperties.getProperty("PSA.Submit"), "Submit button");
		verifyPageTitle("Audit table");
		verifyAndInputByXpath(PSAProperties.getProperty("PSA.Search"), "Search", "asdf");
		verifyAndClickWithXpath(PSAProperties.getProperty("PSA.SearchButton"), "Search button");
		verifyIsTextPresent("No results were found that matched your search");
	}
	public String calenderDate(String day){
        String result="False";
        int rowcount=browser.getRowCountByXpath(".//*[@id='ui-datepicker-div']/table");
        int columncount=browser.getColCountByXpath(PSAProperties.getProperty("PSA.CalenderTable"));
        System.out.println("rowcount:"+rowcount);
        System.out.println("columncount:"+columncount);
        for(int i=1;i<=5;i++){
              for(int j=1;j<=7;j++){
                    if(browser.isElementVisibleWithXpath(PSAProperties.getProperty("PSA.CalenderTable")+"//tr["+i+"]/td["+j+"]"+
                                "[contains(@class,'disabled')]")){
                          System.out.println("empty xpath is");
                    }else{
                          if(browser.isElementVisibleWithXpath(PSAProperties.getProperty("PSA.CalenderTable")+"//tr["+i+"]/td["+j+"]/a")){                                    
                          String dateThreeMonths=browser.getTextByXpath(PSAProperties.getProperty("PSA.CalenderTable")+"//tr["+i+"]/td["+j+"]/a");
                          System.out.println("dateThreeMonths " + dateThreeMonths);
                          if(dateThreeMonths.equals(day)){
                                Report.updateTestLog("Day is matched:"+day,"pass");
                                browser.clickWithXpath(PSAProperties.getProperty("PSA.CalenderTable")+"//tr["+i+"]/td["+j+"]/a");
                                result="True";
                                System.out.println("result = " + result);
                                break;
                          }
                    }
                    }
              }
              
        }
        return result;
	}
	public void checkPasswordReset(){
		verifyAndClick(PSAProperties.getProperty("PSA.PasswordSendLink"),"Send Link");
	}

	public void verifyPasswordResetPage(UserProfile userProfile){
		verifyPageTitle("Forgot password link sent");
		verifyIsTextPresent("Forgot password link sent");
    	verifyIsTextPresent("An email has been sent to:  ");
    	verifyIsTextPresent("Please ask user to check their email address and follow the steps to complete resetting their password");
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
	public void checkImpersonateLink() {
		verifyAndClick(PSAProperties.getProperty("PSA.ImpersonateUserLink"),"Send Link");
		browser.wait(10000);
		browser.handleMultipleWindows("View customer bills");
	}
}
