package bg.framework.app.functional.page.Slingshot;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.GlobalErrorMessages;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SiebelDataBase;

import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.internal.seleniumemulation.GetText;

public class ForgotEmailPage extends BasePage {

    private final static String FILE_NAME = "resources/Slingshot/ForgotEmail.Properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
    private final static String LOGIN_FILE_NAME = "resources/common/LoginPage.Properties";
    private static Properties loginProperties = new PropertyLoader(LOGIN_FILE_NAME).load();
    final String  Pass_Str = "PASS";
    final String  Fail_Str = "FAIL";
    private static String bname="";
    
    public ForgotEmailPage() {
        super();
    }

// Verify whether Forgot Email Link exists and if it exists click on the Forgot Email Link and check whether it navigates to the appropriate page    

    public void validateForgotEmail(final UserProfile userProfile) {
        final String EmailAddressText = browser.getTextByXpath(loginProperties.getProperty("LoginPage.RequiredFieldID"));
        if (EmailAddressText.trim().toLowerCase().contains("retrieve your email address")) {
            Report.updateTestLog("Displayed Email Address Text Is  :" + EmailAddressText, Pass_Str);
        } else {
            Report.updateTestLog("Expected Email Address Text Was Not Displayed ",Fail_Str);
        }
    }   

   public void verifyNavigateForgotEmailPage(){
//	   (pageProperties.getProperty("ForgotEmailPage.CustomerReferenceNumberID")
//	   getWaitTime();
//	   getWaitTime();
	   dynamicWait(pageProperties.getProperty("ForgotEmailPage.ForgottenEmaillink"),"xpath");
	   verifyAndClickWithXpath(pageProperties.getProperty("ForgotEmailPage.ForgottenEmaillink"), "I've forgotten my email");
	   getWaitTime(); 
	   verifyPageTitle(pageProperties.getProperty("ForgotEmailPage.Title"));
	   
   }
   
   public void validateForgotEmailaddress(UserProfile userProfile){
	   
	   verifyAndInputById(pageProperties.getProperty("ForgotEmailPage.CustomerReference"), "CustomerReference", userProfile.getAccNumber());
	   verifyAndSelectDropDownBox(pageProperties.getProperty("ForgotEmailPage.TitleDropdown"),"Title",userProfile.getTitle());
	   verifyAndInputById(pageProperties.getProperty("ForgotEmailPage.Firstname"), "Firstname", userProfile.getFirstName());
	   verifyAndInputById(pageProperties.getProperty("ForgotEmailPage.Lastname"), "Lastname", userProfile.getLastName());
	   verifyAndClickWithXpath(pageProperties.getProperty("ForgotEmailPage.GetEmailButton"), "Click-GetEmailAddress button");
	   verifyPageTitle("Email retrieval confirmation");
       try{
    	   String generatedemail = browser.getTextByXpath(pageProperties.getProperty("ForgotEmailPage.GeneratedEmail"));   
    	   if(generatedemail==userProfile.getEmail()){
    		   Report.updateTestLog("Generated email address is same as input(xml file)", "Pass");
    	   }else{
    		   Report.updateTestLog("Generated email address:"+generatedemail+"is not same as input(xml file):"+userProfile.getEmail(), "Pass");
    	   }
       }catch(Exception e){
  		 Report.updateTestLog("Submitted information for generated email is inccorect :"+e, "Fail");
  	 }
	   
	   
   }
   
   public void verifyClickLogintoAccount(UserProfile userProfile){
	   
	   verifyAndClickWithXpath(pageProperties.getProperty("ForgotEmailPage.Logintoyouraccount"), "Click-Login to your account button");
	   
   }
   
   public void verifyClickCancelLoginpage(){
	   verifyAndClickWithXpath(pageProperties.getProperty("ForgotEmailPage.Cancel"), "Click-Cancel button");
	   verifyPageTitle("Login to Your Account - British Gas");
   }
     
   public void dynamicWait(String property,String propertyname){
   	int count=1;
   	do{
			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				getWaitTime();
				e.printStackTrace();
			}
		System.out.println("Count value"+count);	
   		if(propertyname=="xpath"){
   			
				if(browser.isElementVisibleWithXpath(property)){
					System.out.println("xpath-condition");
					break;
				}
   		}else if(propertyname=="id"){
   			System.out.println("id value"+count);
   			if(browser.isElementVisible(property)){
   				System.out.println("id-condition");
   				break;
   			}  			
   		}    		   		
   		
   	}while (count>=10);
   	
   } 
}
 


