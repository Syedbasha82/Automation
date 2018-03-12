package bg.framework.app.functional.page.selfServe;

import bg.framework.app.functional.entities.UserProfile;



import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.SapNetWeaverPage;
import bg.framework.app.functional.util.SiebelDataBase;
import bg.framework.app.functional.util.Report;

import java.util.Properties;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 03/04/12
 * Time: 11:34
 * To change this template use File | Settings | File Templates.
 */
public class ManagePersonalDetailsPage extends BasePage {

    private final static String FILE_NAME = "resources/selfServe/ManagePersonalDetails.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
    private static String strEmail;
    
    public void fillValidDataInManagePersonalDetailsPage(UserProfile userProfile) {
        browser.wait(1000);
        //verifyIsElementVisibleWithXpath(pageProperties.getProperty("ManagePersonalDetails.WelcomeCustomerDetails"), "Manage Personal Details Welcome Header");

        int intRandomNumbers;
        Random random = new Random();
        intRandomNumbers = random.nextInt(1000);
        strEmail = "digital_test12" + intRandomNumbers + "@bgdigitaltest.co.uk";
        System.out.print("digital_test12" + intRandomNumbers + "@bgdigitaltest.co.uk");
        //userProfile.setEmail("automation_sele" + intRandomNumbers + "@bgdigitaltest.co.uk");
        userProfile.setEmail(strEmail);
       // verifyAndInputById(pageProperties.getProperty("ManagePersonalDetails.EmailAddress"), "Email Address Field", "automation_sele" + intRandomNumbers + "@bgdigitaltest.co.uk");
       // verifyAndInputById(pageProperties.getProperty("ManagePersonalDetails.ReEnterEmailAddress"), "ReEnterEmailAddress Field", "automation_sele" + intRandomNumbers + "@bgdigitaltest.co.uk");
        verifyAndInputById(pageProperties.getProperty("ManagePersonalDetails.EmailAddress"), "Email Address Field", strEmail);
        verifyAndInputById(pageProperties.getProperty("ManagePersonalDetails.ReEnterEmailAddress"), "ReEnterEmailAddress Field", strEmail);
        verifyAndInputById(pageProperties.getProperty("ManagePersonalDetails.NewPassword"), "NewPassword Field", "temp1234");
        verifyAndInputById(pageProperties.getProperty("ManagePersonalDetails.ConfirmNewPassword"), "ConfirmNewPassword Field", "temp1234");
        userProfile.setPassword("temp1234");
        if(browser.isElementVisible(pageProperties.getProperty("ManagePersonalDetails.MobileNumber"))){
        	verifyAndInputById(pageProperties.getProperty("ManagePersonalDetails.MobileNumber"), "MobileNumber Field", "07123456782");	
        }
        if(browser.isElementVisible(pageProperties.getProperty("ManagePersonalDetails.HomeNumber"))){
        	verifyAndInputById(pageProperties.getProperty("ManagePersonalDetails.HomeNumber"), "HomeNumber Field", "01234567143");	
        }
        if(browser.isElementVisible(pageProperties.getProperty("ManagePersonalDetails.WorkNumber"))){
        	verifyAndInputById(pageProperties.getProperty("ManagePersonalDetails.WorkNumber"), "WorkNumber Field", "01234567416");	
        }
        verifyAndClickWithXpath(pageProperties.getProperty("ManagePersonalDetails.SaveChangesBtn"), "Save Changes Button");

    }

    public void ClickSaveChangesButton() {

    }
    
    public void verifyFillDataWithDB(UserProfile userProfile) {
    	//verify Email with DB
    	String dbEmail;
    	
    	dbEmail = new OnlineDBConnector().getUserEmail(userProfile.getUCRN());
    	try
    	{
    	 if(strEmail.equals(dbEmail))
    	 {
    		Report.updateTestLog("Email address is Updated in DB", "Pass");
    	 }
    	}
    	catch(NullPointerException e)
    	{
    		Report.updateTestLog("Email address is updated in DB" , "Fail");
    	}
    	
    	   	
    }
    
    public void verifyFillDataWithSiebel(UserProfile userProfile)
    {
    	String sbEmail,sbPhone;
    	//sbEmail = new SiebelDataBase().getEmailAddress(userProfile.getUCRN());
    	sbPhone = new SiebelDataBase().getTelephoneNumber(userProfile.getUCRN());
    		if(sbPhone.equals("+440112232679"))
    		{
    			Report.updateTestLog("Phone number is Updated in Siebel DB :"+sbPhone, "Pass");
    		}
    		
    	
    		//if(strEmail.equals(sbEmail))
    		//{
    		//	Report.updateTestLog("Email address is Updated in Siebel DB", "Pass");
    		//}
    		//else
    		//{
    		//	Report.updateTestLog(sbEmail , "Fail");
    		//}
   }
    
    public void VerifyConfirmationOverLayGotToMyAccount() {
    	verifyIsElementVisibleWithXpath(pageProperties.getProperty("ManagePersonalDetails.ConfirmationMSGHeader"), "Manage Personal Details Confirmation Message Header");
        verifyAndClickWithLinkText(pageProperties.getProperty("ManagePersonalDetails.GoToMyAccountLink"), "GoTo My Account Link");
    }

    public void verifyConfirmationOverLayAndClickLogin() {
    	//verifyIsElementVisibleWithXpath(pageProperties.getProperty("ManagePersonalDetails.ConfirmationMSGHeader"), "Manage Personal Details Confirmation Message Header");
    	browser.wait(getWaitTime());
        verifyAndClickWithLinkText(pageProperties.getProperty("ManagePersonalDetails.Login"), "Log in");
    }
    
    public void logout(){
    browser.wait(getWaitTime());	
    verifyAndClickWithXpath(pageProperties.getProperty("ManagePersonalDetails.Logout"), "Log in");
    
    }
    
    public void verifyFieldValidation() {
    	
    	 browser.wait(1000);
         verifyIsElementVisibleWithXpath(pageProperties.getProperty("ManagePersonalDetails.WelcomeCustomerDetails"), "Manage Personal Details Welcome Header");

         
    	String[] EmailAdd = new String[10];
    	String[] ReEmailAdd = new String[10];
    	String[] Password = new String[10];
    	String[] ConfirmPassword = new String[10];
    	String[] MobileNumber = new String[10];
    	String[] HomeNumber = new String[10];
    	String[] WorkNumber = new String[10];
    	
    	EmailAdd[0] = "";
    	ReEmailAdd[0] = "";
    	Password[0] = "";
    	ConfirmPassword[0] = "";
    	MobileNumber[0] = "";
    	HomeNumber[0] = "";
    	WorkNumber[0] = "";
    	
    	EmailAdd[1] = "automation_sele";
    	ReEmailAdd[1] = "automation_sele";
    	Password[1] = "Temp123";
    	ConfirmPassword[1] = "Temp123";
    	MobileNumber[1] = "0123456789";
    	HomeNumber[1] = "0123456789";
    	WorkNumber[1] = "0123456789";
    	
    	EmailAdd[2] = "automation_sele580@bgdigitaltest.co.uk";
    	ReEmailAdd[2] = "automation_sele@bgdigitaltest.co.uk";
    	Password[2] = "Temp123";
    	ConfirmPassword[2] = "Temp123";
    	MobileNumber[2] = "0123456789";
    	HomeNumber[2] = "0123456789";
    	WorkNumber[2] = "0123456789";
    	    	    	
    	EmailAdd[3] = "cearw38@bgdigitaltest.co.uk";
    	ReEmailAdd[3] = "cearw38@bgdigitaltest.co.uk";
    	Password[3] = "Temp123";
    	ConfirmPassword[3] = "Temp123";
    	MobileNumber[3] = "0123456789";
    	HomeNumber[3] = "0123456789";
    	WorkNumber[3] = "0123456789";
    	
    	EmailAdd[4] = "automation_sele680@bgdigitaltest.co.uk";
    	ReEmailAdd[4] = "automation_sele680@bgdigitaltest.co.uk";
    	Password[4] = "Temp123#$%^";
    	ConfirmPassword[4] = "Temp123#$%^";
    	MobileNumber[4] = "0123456789";
    	HomeNumber[4] = "0123456789";
    	WorkNumber[4] = "0123456789";
    	
    	EmailAdd[5] = "automation_sele680@bgdigitaltest.co.uk";
    	ReEmailAdd[5] = "automation_sele680@bgdigitaltest.co.uk";
    	Password[5] = "Temp1234";
    	ConfirmPassword[5] = "Temp123";
    	MobileNumber[5] = "0123456789";
    	HomeNumber[5] = "0123456789";
    	WorkNumber[5] = "0123456789";
    	
    	EmailAdd[6] = "automation_sele680@bgdigitaltest.co.uk";
    	ReEmailAdd[6] = "automation_sele680@bgdigitaltest.co.uk";
    	Password[6] = "Temp123";
    	ConfirmPassword[6] = "Temp123";
    	MobileNumber[6] = "0123456789";
    	HomeNumber[6] = "0123456789";
    	WorkNumber[6] = "0123456789";
    	
    	EmailAdd[7] = "automation_sele680@bgdigitaltest.co.uk";
    	ReEmailAdd[7] = "automation_sele680@bgdigitaltest.co.uk";
    	Password[7] = "";
    	ConfirmPassword[7] = "";
    	MobileNumber[7] = "01234567895262";
    	HomeNumber[7] = "0123456789";
    	WorkNumber[7] = "0123456789";
    	
    	for(int i=0; i<7;i++)
    	{
    		 
    	        verifyAndInputById(pageProperties.getProperty("ManagePersonalDetails.EmailAddress"), "Email Address Field", EmailAdd[i]);
    	        verifyAndInputById(pageProperties.getProperty("ManagePersonalDetails.ReEnterEmailAddress"), "ReEnterEmailAddress Field", ReEmailAdd[i]);
    	        verifyAndInputById(pageProperties.getProperty("ManagePersonalDetails.NewPassword"), "NewPassword Field", Password[i]);
    	        verifyAndInputById(pageProperties.getProperty("ManagePersonalDetails.ConfirmNewPassword"), "ConfirmNewPassword Field", ConfirmPassword[i]);
    	        verifyAndInputById(pageProperties.getProperty("ManagePersonalDetails.MobileNumber"), "MobileNumber Field", MobileNumber[i]);
    	        verifyAndInputById(pageProperties.getProperty("ManagePersonalDetails.HomeNumber"), "HomeNumber Field", HomeNumber[i]);
    	        verifyAndInputById(pageProperties.getProperty("ManagePersonalDetails.WorkNumber"), "WorkNumber Field", WorkNumber[i]);
    	        verifyAndClickWithXpath(pageProperties.getProperty("ManagePersonalDetails.SaveChangesBtn"), "Save Changes Button");
    	        verifyIsElementVisibleWithXpath(pageProperties.getProperty("ManagePersonalDetails.ErrMsg"), "Update details Error Text");
    	        
    	}
    }
    
    public void verifyMPDSapNetweaver(UserProfile userProfile){
    	String[] ContactText = new String[5];
		if(TestBase.CustomerData.equals("SAPCRM")){
			SapNetWeaverPage sapNetWeaverPage = new SapNetWeaverPage();
			sapNetWeaverPage.openSapCRM(userProfile);
			Report.updateTestLog("The Updated Email in CRM : "+ sapNetWeaverPage.getEmail(), "Pass");
			ContactText = sapNetWeaverPage.contactHistoryValidation();
			Report.updateTestLog("Transaction agent : "+ContactText[0]+"Date and Time of Transaction : "+ContactText[5]+" , "+ContactText[6], "Pass");
			if(ContactText[4].contains("E-Mail") && ContactText[4].contains("changed")){
				Report.updateTestLog("Details have been updated in SAP with text :"+ContactText[4], "Pass");
			}
			else{
				Report.updateTestLog("Details have not been updated in SAP", "Fail");
			}
		}
    }
}
