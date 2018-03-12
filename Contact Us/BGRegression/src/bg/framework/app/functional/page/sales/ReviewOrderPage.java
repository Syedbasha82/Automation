package bg.framework.app.functional.page.sales;

import bg.framework.app.functional.action.sales.AcquisitionAction;
import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.selfServe.PersonalDetailsPage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

import java.util.Properties;

public class ReviewOrderPage extends BasePage {
	//private final static String FILE_NAME = "resources/sales/"+ApplicationConfig.BRAND+"Acquisition.properties";
	private final static String FILE_NAME = "resources/ReFactoring/BGAcquisition.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
    private static String LeadData;
    private static String orderDate;
    private static boolean MarketingConsentFlag;
    UserProfile userProfile;

    public ReviewOrderPage() {
    }

    public ReviewOrderPage(Acquisition acquisition) {

    }


    public AcquisitionAction errorReviewOrder() {

        String reviewordererror;

        browser.click(pageProperties.getProperty("Acquisition.PlaceOrder"));

        /*if (browser.isElementVisible(pageProperties.getProperty("Acquisition.CurrentServicesError"))) {
            reviewordererror = browser.getText(pageProperties.getProperty("Acquisition.GasElecErrorMessage"));
            Report.updateTestLog("Supplier Field Validation" + reviewordererror, "PASS");
        } else {
            Report.updateTestLog("Supplier Field Validation", "FAIL");
        }*/
        return new AcquisitionAction();
    }


    public AcquisitionAction reviewOrderNavigation() {
    	
    	orderDate=new OnlineDBConnector().DBsysdate();
    	
        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.AggrementBox"))) {
            browser.click(pageProperties.getProperty("Acquisition.AggrementBox"));
            Report.updateTestLog("Aggrement Box is selected", "PASS");
        }
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.AggrementContinue"))) {
            browser.clickWithXpath(pageProperties.getProperty("Acquisition.AggrementContinue"));
        }


        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.TermsandConditions"))) {
        	if(!browser.isSelected(pageProperties.getProperty("Acquisition.TermsandConditions")))
        	{
            browser.click(pageProperties.getProperty("Acquisition.TermsandConditions"));
            Report.updateTestLog("TermsandConditions is selected", "PASS");
        	}
            
        }
        else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.TermsandConditions2"))) {
        	if(!browser.isSelected(pageProperties.getProperty("Acquisition.TermsandConditions2")))
        	{
            browser.click(pageProperties.getProperty("Acquisition.TermsandConditions2"));
            Report.updateTestLog("TermsandConditions is selected", "PASS");
        	}
            
        }
        else {
            Report.updateTestLog("TermsandConditions is not selected", "FAIL");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.MarketingConsent"))) {
            browser.click(pageProperties.getProperty("Acquisition.MarketingConsent"));
            Report.updateTestLog("Marketing Consent is selected", "PASS");
        }
        else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.MarketingConsent2"))) {
            browser.click(pageProperties.getProperty("Acquisition.MarketingConsent2"));
            Report.updateTestLog("Marketing Consent is selected", "PASS");
        }
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.newMarketingConsent"))){
        	MarketingConsentFlag = true;
        selectMarketingConsent();//calling MarketingConsent method
        }
        browser.click(pageProperties.getProperty("Acquisition.PlaceOrder"));
        Report.updateTestLog("Place Order is selected", "PASS");
        Report.updateTestLog("Place Order","WARN");
        orderDate = new OnlineDBConnector().DBsysdateless();
        browser.wait(30000);
        browser.wait(getWaitTime());
        verifyMarketingConsent();
        return new AcquisitionAction();


    }
    
    //Selecting Marketing Consent which are to be OptOut
    public void selectMarketingConsent(){
    	userProfile = PersonalDetailsPage.userProfileStat;//calling static userProfile from PersonalDetails page
    	 if(userProfile.getLetterConsent().equalsIgnoreCase("yes")){
    		 verifyAndClickWithXpath(pageProperties.getProperty("Acquisition.LetterConsent"), "Letter consent check box");
    	 }
    	 if(userProfile.getEmailConsent().equalsIgnoreCase("yes")){
    		 verifyAndClickWithXpath(pageProperties.getProperty("Acquisition.EmailConsent"), "Email consent check box"); 
    	 }
    	 if(userProfile.getLandlineConsent().equalsIgnoreCase("yes")){
    		 verifyAndClickWithXpath(pageProperties.getProperty("Acquisition.LandlineConsent"), "Landline consent check box");
    	 }
    	 if(userProfile.getMobileConsent().equalsIgnoreCase("yes")){
    		 verifyAndClickWithXpath(pageProperties.getProperty("Acquisition.MobileConsent"), "Mobile consent check box");
    	 }
    	 if(userProfile.getTextMessageConsent().equalsIgnoreCase("yes")){
    		 verifyAndClickWithXpath(pageProperties.getProperty("Acquisition.TextMessageConsent"), "TextMessage consent check box");
    	 }
    	 Report.updateTestLog("MarketingConsent Screenshot","WARN");
    	
    	 
    		
    }
    //Verifying which Marketing Consent are OptOut and OptIn  
    public void verifyMarketingConsent(){
    	userProfile = PersonalDetailsPage.userProfileStat;
    	LeadData = new OnlineDBConnector().getEshopLeadData(orderDate);
		System.out.println(LeadData);//getting Lead Data from OnlineDBconnector.
	if(MarketingConsentFlag == true)
   	 if(userProfile.getLetterConsent().equalsIgnoreCase("yes")){
   		 if(LeadData.contains("<MarketingChannelPreference MarketingChannel=\"Letter\" OptIn=\"N\"/>")){
   			Report.updateTestLog("Letter Consent is Optout", "PASS");
   		}
   		else{
   			Report.updateTestLog("Letter Consent is not Optout", "FAIL");
   		}
    }
   	 else if(!userProfile.getLetterConsent().equalsIgnoreCase("yes")){
   		if(LeadData.contains("<MarketingChannelPreference MarketingChannel=\"Letter\" OptIn=\"Y\"/>")){
   			Report.updateTestLog("Letter Consent is Optin", "PASS");
   		}
   		else{
   			Report.updateTestLog("Letter Consent is not Optin", "FAIL");
   		}
   	 }
   	 if(userProfile.getEmailConsent().equalsIgnoreCase("yes")){
   		 if(LeadData.contains("<MarketingChannelPreference MarketingChannel=\"Email\" OptIn=\"N\"/>")){
   			Report.updateTestLog("Email Consent is Optout", "PASS");
   		}
   		else{
   			Report.updateTestLog("Email Consent is not Optout", "FAIL");
   		}
    }
   	 else if(!userProfile.getEmailConsent().equalsIgnoreCase("yes")){
   		if(LeadData.contains("<MarketingChannelPreference MarketingChannel=\"Email\" OptIn=\"Y\"/>")){
   			Report.updateTestLog("Email Consent is Optin", "PASS");
   		}
   		else{
   			Report.updateTestLog("Email Consent is not Optin", "FAIL");
   		}
   	 }
   	if(userProfile.getLandlineConsent().equalsIgnoreCase("yes")){
  		 if(LeadData.contains("<MarketingChannelPreference MarketingChannel=\"Landline\" OptIn=\"N\"/>")){
  			Report.updateTestLog("LandLine Consent is Optout", "PASS");
  		}
  		else{
  			Report.updateTestLog("LandLine Consent is not Optout", "FAIL");
  		}
   }
  	 else if(!userProfile.getLandlineConsent().equalsIgnoreCase("yes")){
  		if(LeadData.contains("<MarketingChannelPreference MarketingChannel=\"Landline\" OptIn=\"Y\"/>")){
  			System.out.println("");
  			Report.updateTestLog("LandLine Consent is Optin", "PASS");
  		}
  		else{
  			Report.updateTestLog("LandLine Consent is not Optin", "FAIL");
  		}
  	 }
   	if(userProfile.getMobileConsent().equalsIgnoreCase("yes")){
 		 if(LeadData.contains("<MarketingChannelPreference MarketingChannel=\"Mobile\" OptIn=\"N\"/>")){
 			Report.updateTestLog("Mobile Consent is Optout", "PASS");
 		}
 		else{
 			Report.updateTestLog("Mobile Consent is not Optout", "FAIL");
 		}
  }
 	 else if(!userProfile.getMobileConsent().equalsIgnoreCase("yes")){
 		if(LeadData.contains("<MarketingChannelPreference MarketingChannel=\"Mobile\" OptIn=\"Y\"/>")){
 			Report.updateTestLog("Mobile Consent is Optin", "PASS");
 		}
 		else{
 			Report.updateTestLog("Mobile Consent is not Optin", "FAIL");
 		}
 	 }
   	if(userProfile.getTextMessageConsent().equalsIgnoreCase("yes")){
		 if(LeadData.contains("<MarketingChannelPreference MarketingChannel=\"SMS/MMS\" OptIn=\"N\"/>")){
			Report.updateTestLog("TextMessage Consent is Optout", "PASS");
		}
		else{
			Report.updateTestLog("TextMessage Consent is not Optout", "FAIL");
		}
 }
	 else if(!userProfile.getTextMessageConsent().equalsIgnoreCase("yes")){
		if(LeadData.contains("<MarketingChannelPreference MarketingChannel=\"SMS/MMS\" OptIn=\"Y\"/>")){
			Report.updateTestLog("TextMessage Consent is Optin", "PASS");
		}
		else{
			Report.updateTestLog("TextMessage Consent is not Optin", "FAIL");
		}
	 }
  	
   	 
   }
 
    
public AcquisitionAction reviewOrderNavigationSMB() {
    	
    	orderDate=new OnlineDBConnector().DBsysdate();
    	
    	   	
          if (browser.isElementVisible(pageProperties.getProperty("Acquisition.TermsandConditions"))) {
        	if(!browser.isSelected(pageProperties.getProperty("Acquisition.TermsandConditions")))
        	{
            browser.click(pageProperties.getProperty("Acquisition.TermsandConditions"));
            Report.updateTestLog("TermsandConditions is selected", "PASS");
        	}
            
        }
        else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.TermsandConditions2"))) {
        	if(!browser.isSelected(pageProperties.getProperty("Acquisition.TermsandConditions2")))
        	{
            browser.click(pageProperties.getProperty("Acquisition.TermsandConditions2"));
            Report.updateTestLog("TermsandConditions is selected", "PASS");
        	}
            
        }
        else {
            Report.updateTestLog("TermsandConditions is not selected", "FAIL");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.MarketingConsent"))) {
            browser.click(pageProperties.getProperty("Acquisition.MarketingConsent"));
            Report.updateTestLog("Marketing Consent is selected", "PASS");
        }
        else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.MarketingConsent2"))) {
            browser.click(pageProperties.getProperty("Acquisition.MarketingConsent2"));
            Report.updateTestLog("Marketing Consent is selected", "PASS");
        }


        browser.click(pageProperties.getProperty("SMB.submitbutton"));
        Report.updateTestLog("Place Order is selected", "PASS");
        Report.updateTestLog("Place Order","WARN");
        browser.wait(getWaitTime());
        browser.wait(30000);
        return new AcquisitionAction();}


 
    
    public AcquisitionAction verifyLeadData(){
    	
    	String leadData=new OnlineDBConnector().getLeadData(orderDate);
    	System.out.println(leadData);
    	
    	Report.updateTestLog("Lead Data Generated is "+leadData, "PASS");
    	
    	return new AcquisitionAction();
    	
    	
    }
    
 public AcquisitionAction verifyTransActionID(){
    	
    	String transactionID=new OnlineDBConnector().getTransActionID(orderDate);
    	System.out.println(transactionID);
    	int id=transactionID.indexOf("<TransactionID>");
    	String exactID=transactionID.substring(id+15, id+27);
    	System.out.println(exactID);
    	
    	if(exactID.matches("^[0-9]{12}$"))
    	{
    		Report.updateTestLog("TransACtion ID is available in DB:"+ exactID, "PASS");
    	}else
    	{
    		Report.updateTestLog("TransACtion ID is not available in DB:"+ exactID, "FAIL");
    	}
    	return new AcquisitionAction();
    	
    	
    }
    
   public AcquisitionAction getLeadID(){
    	
    	String leadid=new OnlineDBConnector().getLeadID(orderDate);
    	System.out.println(leadid);
    	
    	Report.updateTestLog("Lead ID Generated is "+leadid, "DONE");
    	
    	return new AcquisitionAction();
    	
    	
    }
   public AcquisitionAction verifyEshopLeadData(){
   	
   	String leadData=new OnlineDBConnector().getEshopLeadData(orderDate);
   	System.out.println(leadData);
   	LeadData = leadData;
   	Report.updateTestLog("Lead Data Generated is "+leadData, "PASS");
    verifyMarketingConsent();
   	return new AcquisitionAction();
   } 	
   public AcquisitionAction getEshopLeadID(){
   	
   	String leadid=new OnlineDBConnector().getEshopLeadID(orderDate);
   	System.out.println(leadid);
   	
   	Report.updateTestLog("Lead ID Generated is "+leadid, "DONE");
   	
   	return new AcquisitionAction();  	
   }
   public AcquisitionAction getEshopLeadIDSMB(UserProfile userProfile){
	   
	 
	   
	   	String leadid=new OnlineDBConnector().getEshopLeadIDSMB(orderDate);
	   	System.out.println(leadid);	   	
	   	Report.updateTestLog("Lead ID Generated is "+leadid, "DONE");
	   	
	   	//return new AcquisitionAction();
	   	
	   	String notificationdetails=new OnlineDBConnector().getEshopNotificationDetailsSMB(orderDate);
	   	System.out.println(notificationdetails);	   	
	   	Report.updateTestLog("Notification Details Generated is "+notificationdetails, "DONE");
	   	
	   	//return new AcquisitionAction(); 
	   	
	   	String auditdetails=new OnlineDBConnector().getEshopAuditDetailsSMB(orderDate,userProfile.getAccNumber());
	   	System.out.println(auditdetails);	   	
	   	Report.updateTestLog("Audit Details Generated is "+auditdetails, "DONE");
	   	
	   	String auditeventtypeid=new OnlineDBConnector().getEshopAuditEventTypeSMB(orderDate,userProfile.getAccNumber());
	   	System.out.println(auditeventtypeid);	   	
	   	Report.updateTestLog("Audit Event Type ID Generated is "+auditeventtypeid, "DONE");
	   	
	   	String transactiontypeid=new OnlineDBConnector().getEshopTransactionTypeSMB(orderDate,userProfile.getAccNumber());
	   	System.out.println(transactiontypeid);	   	
	   	Report.updateTestLog("Transaction Type ID Generated is "+transactiontypeid, "DONE");
	   	return new AcquisitionAction(); 
	   	  	
   }
   
   public AcquisitionAction getOAMdetailsSMB(UserProfile userProfile){
	   	
	   	String UCRN=new OnlineDBConnector().getOAMdetailsSMB(userProfile.getEmail());
	   	System.out.println(UCRN);	   	
	   	Report.updateTestLog("UCRN Generated is "+UCRN, "DONE");
	   	
	   	String email=new OnlineDBConnector().getOAMdetailsemailSMB(userProfile.getUCRN());
	   	System.out.println(email);	   	
	   	Report.updateTestLog("Email Generated is "+email, "DONE");
	   	
	   	String customeridinOAMCustomer=new OnlineDBConnector().getOAMcustomeriddetailsemailSMB(userProfile.getUCRN());
	   	System.out.println(customeridinOAMCustomer);	   	
	   	Report.updateTestLog("Customer ID in OAM Customer table is "+customeridinOAMCustomer, "DONE");
	   	
		String customeridinOAMCustomerBrands=new OnlineDBConnector().getCustomerIdSMB(customeridinOAMCustomer);
	   	System.out.println(customeridinOAMCustomerBrands);	   	

	   	if(customeridinOAMCustomer.equals(customeridinOAMCustomerBrands))
	   	{
	   		Report.updateTestLog("Customer ID is same in Both OAM_CUSTOMER_BRANDS and PO_TA_OAM_CUSTOMER Tables", "PASS");
	   	}else
	   	{
	   		Report.updateTestLog("Customer ID is not same in Both OAM_CUSTOMER_BRANDS and PO_TA_OAM_CUSTOMER Tables", "FAIL");
	   	}
	   	
	   	String customeridinOAMCustomerBrandsId=new OnlineDBConnector().getBrandIdSMB(customeridinOAMCustomer);
	   	System.out.println(customeridinOAMCustomerBrands);	   	

	   	if(customeridinOAMCustomerBrandsId.equals("1"))
	   	{
	   		Report.updateTestLog("Brand ID is available as 1", "PASS");
	   	}else
	   	{
	   		Report.updateTestLog("Brand ID is not available as 1", "FAIL");
	   	}
	   	return new AcquisitionAction();   	
   }
   public AcquisitionAction getEsmartLeadType(){	   	
	   	String leadtype=new OnlineDBConnector().getEshopLeadType(orderDate);
	   	System.out.println(leadtype);
	   	String strAcqLead = "ESMART_ACQ";
	   	String strConvLead = "ESMART_CONV";
	   	if (leadtype.equals(strAcqLead)){
	   		Report.updateTestLog("Lead Type Generated for Acquisition is " + leadtype, "DONE");
	   		}
	   	else if(leadtype.contains(strConvLead)){
	   		Report.updateTestLog("Lead Type Generated for Conversion is " + leadtype, "DONE");
	   	}
	   	else{
	   	Report.updateTestLog("Lead Type not as expected, Lead Type Generated is :" + leadtype, "FAIL");
	   	}   		   	
	   	return new AcquisitionAction();  	
	   }
   public AcquisitionAction getEshopLeadType(){	   	
	   	String leadtype=new OnlineDBConnector().getEshopLeadType(orderDate);
	   	System.out.println(leadtype);
	   	String strAcqLead = "ENERGY_ACQ";
	   	String strConvLead = "ENERGY_CONV";
	   	String strEsmartLead = "ESMART_ACQ";
	   	String strEsmartConvLead = "ESMART_CONV";
	   	/*String strAcqLead = "SMARTMETER_FUSION_CONV_GAS";
	   	String strConvLead = "FUSION_ENERGY_ACQ";
	   	*/
	   	if (leadtype.equals(strAcqLead)){
	   		Report.updateTestLog("Lead Type Generated for Acquisition is " + leadtype, "DONE");
	   		}
	   	else if(leadtype.contains(strConvLead)){
	   		Report.updateTestLog("Lead Type Generated for Conversion is " + leadtype, "DONE");
	   	}
		else if(leadtype.contains(strEsmartLead)){
	   		Report.updateTestLog("Lead Type Generated for ESmart Acquisition is " + leadtype, "DONE");
	   	}
	   	else if(leadtype.contains(strEsmartConvLead)){
	   		Report.updateTestLog("Lead Type Generated for ESmart Conversion is " + leadtype, "DONE");
	   	}
	   	else{
	   	Report.updateTestLog("Lead Type not as expected, Lead Type Generated is :" + leadtype, "FAIL");
	   	}   		   	
	   	verifyMarketingConsent();
	   	
	   	return new AcquisitionAction(); 
	    
	   }
   
   public AcquisitionAction getAuditEventID(UserProfile userProfile){
	   boolean AuditFlag;
	   try{
		    String eventid=new OnlineDBConnector().getAuditEventID(orderDate,userProfile.getEmail());
		   	System.out.println(eventid);
		   	String strActID = "50";
		   	if (eventid.equals(strActID)){
		   	Report.updateTestLog("Audit Event ID Generated is :"+eventid, "PASS");
		   	}
		   	else{
		   	Report.updateTestLog("Audit Event ID not as expected, Audit Event ID Generated is :"+eventid, "FAIL");
		   	}	   
	   }
	   catch(org.springframework.dao.EmptyResultDataAccessException exp){
		   Report.updateTestLog("Audit Event ID returned NULL", "Fail");
	   }
	   	
	   	new OnlineDBConnector().deleteWTP(userProfile.getEmail());
	   	return new AcquisitionAction();  	
		}
}