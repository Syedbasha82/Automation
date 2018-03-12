package bg.framework.app.functional.page.sales;

import java.util.List;
import java.util.Properties;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SiebelDataBase;

public class RollOffPage extends BasePage {

    private final static String FILE_NAME = "resources/Sales/RollOff.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
    private static String orderDate = new OnlineDBConnector().DBsysdate();
    final String  Pass_Str = "PASS";
    final String  Fail_Str = "FAIL";
    public RollOffPage() {
    }
    public void navigatetoRollOffLandingPage(){
    	browser.open(ApplicationConfig.APP_BG_URL+"/tariff-change/login-rolloff/price-promise-march-2013/");
    }
    public void verifybreadcrumb(){
		String bcrumb = browser.getTextByXpath(pageProperties.getProperty("Rolloff.breadcrumb"));
		if (bcrumb.contains("Roll off Landing")){
			Report.updateTestLog("Bread Crumb verified successfully "+bcrumb,Pass_Str);
	    } else {
	    Report.updateTestLog("Bread Crumb verification failed"+bcrumb,Fail_Str);			
		}
		Report.updateTestLog("Roll Off Landing Page", "WARN");
    }
	public void validateRollOffPage(UserProfile userProfile) {

        String firstName = new SiebelDataBase().getFirstName(userProfile.getUCRN());
        final String lastName = new SiebelDataBase().getLastName(userProfile.getUCRN());
        final String strTitle = new SiebelDataBase().getTitle(userProfile.getUCRN());
        final String telPhoneNum = new SiebelDataBase().getTelephoneNumber(userProfile.getUCRN());
        //System.out.println(telPhoneNum);
        final String EmailId = new OnlineDBConnector().getUserEmail(userProfile.getUCRN());
        String Name = strTitle +" "+ firstName +" "+ lastName;
       if(browser.isElementVisible(pageProperties.getProperty("Rolloff.EmailAddress"))){
        if(browser.isElementVisible(pageProperties.getProperty("Rolloff.Name"))){
        	String name = browser.getAttribute(pageProperties.getProperty("Rolloff.Name"),"value");
        	Report.updateTestLog("Name Pre Populated : "+name +" Database Name :"+Name,Pass_Str);
        }else {
        String stTtile = browser.getTextFromDropBox("id",pageProperties.getProperty("Rolloff.Title"));
        if (strTitle.contains(stTtile)){
            Report.updateTestLog("Title Pre Populated :"+stTtile + " Database Title :"+strTitle,Pass_Str);
            } else {
            Report.updateTestLog("Title not Pre Populated",Fail_Str);
        }
        String stFirstName = browser.getAttribute(pageProperties.getProperty("Rolloff.FirstName"),"value");
        if (firstName.contains(stFirstName)){
        	browser.input(pageProperties.getProperty("Rolloff.FirstName"),firstName+"a");
            Report.updateTestLog("First Name Pre Populated :"+stFirstName+ " Database Firstname :"+firstName,Pass_Str);
            } else {
            Report.updateTestLog("First Name not Pre Populated",Fail_Str);
        }
        String stSurname = browser.getAttribute(pageProperties.getProperty("Rolloff.Surname"),"value");
        if (lastName.contains(stSurname)){
            Report.updateTestLog("Last Name Pre Populated :"+stSurname+ " Database Surname :"+lastName,Pass_Str);
            } else {
            Report.updateTestLog("Last Name not Pre Populated",Fail_Str);
        }
        }
        String strEmail = browser.getAttribute(pageProperties.getProperty("Rolloff.EmailAddress"),"value");
        if (EmailId.contains(strEmail)){
            Report.updateTestLog("Email Address Pre Populated :"+strEmail+ " Database Email :"+EmailId,Pass_Str);
            } else {
            Report.updateTestLog("Email Address not Pre Populated",Fail_Str);
        }
        String strtel = browser.getAttribute(pageProperties.getProperty("Rolloff.TelephoneNumber"),"value");
        if (telPhoneNum.contains(strtel)){
            Report.updateTestLog("Telephone number Pre Populated :"+ strtel+ " Database TelephoneNumber :"+telPhoneNum,Pass_Str);
            } else {
            Report.updateTestLog("Telephone number not Pre Populated",Fail_Str);
        }
        SiebelDataBase siebelDatabase = new SiebelDataBase();
        List<String> address = siebelDatabase.getAddress(userProfile.getAccNumber());
        System.out.println(address);
        String[] arrayaddress = (String[]) address.toArray(new String[0]);
        String houseno = arrayaddress[0];
        String addNum = arrayaddress[1];
        String addres = arrayaddress[2];
        String city = arrayaddress[3];
        String zipcode = arrayaddress[4];
       String addr = browser.getTextByXpath(pageProperties.getProperty("Rolloff.Address"));
       if(addr.contains(userProfile.getAccNumber())){
    	   Report.updateTestLog("Account number Pre Populated :"+ userProfile.getAccNumber(),Pass_Str); 
       }else {
    	   Report.updateTestLog("Account number not Pre Populated :"+ userProfile.getAccNumber(),Fail_Str);
       }
       if (addr.contains(houseno)||addr.contains(zipcode)){
    	   Report.updateTestLog("Address Pre Populated :"+ houseno +","+addNum +","+addres +","+ city +","+ zipcode,Pass_Str);
       }
       if (addr.contains("Gas")){
    	   Report.updateTestLog("Gas Account with Address Pre Populated :"+ addr,Pass_Str);
       }else if(addr.contains("Electricity")){
    	   Report.updateTestLog("Electricity Account with Address Pre Populated :"+ addr,Pass_Str);
       }else if(addr.contains("Energy")){
    	   Report.updateTestLog("Energy Account with Address Pre Populated :"+ addr,Pass_Str);
       }
        verifyAndClick(pageProperties.getProperty("Rolloff.TermsAndConditions"), "Terms and Conditions");
        verifyAndClick(pageProperties.getProperty("Rolloff.Submit"), "Roll off Submit");
        getWaitTime();
        browser.wait(3000);
        if(browser.isTextPresent(pageProperties.getProperty("Rolloff.ConfirmationText"))){
        	Report.updateTestLog("Roll Off Confirmation Page Displayed",Pass_Str);
        }else{
     	   Report.updateTestLog("Roll Off Confirmation Page Not Displayed",Fail_Str);
        }
       }else{
    	   browser.isTextPresent("Tariff details are not available");
    	   Report.updateTestLog("Energy Customer doesnot have Roll Off Tariff", "FAIL");
       }
      }
	
	public void verifyAuditDetails(UserProfile userProfile){
		String auditdetails=new OnlineDBConnector().verifyAuditDetails(userProfile.getEmail());
  	   	System.out.println(auditdetails);
  	   	if (auditdetails.equals("0")){
  	   		Report.updateTestLog("Audit Details not as expected", "FAIL");      	   	
  	   	}
  	   	else{
  	   		Report.updateTestLog("Audit Details Generated is :"+auditdetails, "PASS");
  	   	}	  			
	}
	
}
