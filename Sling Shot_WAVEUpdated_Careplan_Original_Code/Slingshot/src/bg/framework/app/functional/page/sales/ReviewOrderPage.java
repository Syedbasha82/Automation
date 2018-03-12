package bg.framework.app.functional.page.sales;

import bg.framework.app.functional.action.sales.AcquisitionAction;
import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

import java.util.Properties;

public class ReviewOrderPage extends BasePage {
	//private final static String FILE_NAME = "resources/sales/"+ApplicationConfig.BRAND+"Acquisition.properties";
	private final static String FILE_NAME = "resources/ReFactoring/BGAcquisition.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
    
    private static String orderDate;

    public ReviewOrderPage() {
    }

    public ReviewOrderPage(Acquisition acquisition) {

    }


    public AcquisitionAction errorReviewOrder() {

        String reviewordererror;

        browser.click(pageProperties.getProperty("Acquisition.PlaceOrder"));

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.CurrentServicesError"))) {
            reviewordererror = browser.getText(pageProperties.getProperty("Acquisition.GasElecErrorMessage"));
            Report.updateTestLog("Supplier Field Validation" + reviewordererror, "PASS");
        } else {
            Report.updateTestLog("Supplier Field Validation", "FAIL");
        }
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
            browser.click(pageProperties.getProperty("Acquisition.TermsandConditions"));
            Report.updateTestLog("TermsandConditions is selected", "PASS");
        } else {
            Report.updateTestLog("TermsandConditions is not selected", "FAIL");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.MarketingConsent"))) {
            browser.click(pageProperties.getProperty("Acquisition.MarketingConsent"));
            Report.updateTestLog("Marketing Consent is selected", "PASS");
        }


        browser.click(pageProperties.getProperty("Acquisition.PlaceOrder"));
        Report.updateTestLog("Place Order is selected", "PASS");
        Report.updateTestLog("Place Order","WARN");
        browser.wait(getWaitTime());
        browser.wait(30000);
        return new AcquisitionAction();


    }
    
    public AcquisitionAction verifyLeadData(){
    	
    	String leadData=new OnlineDBConnector().getLeadData(orderDate);
    	System.out.println(leadData);
    	
    	Report.updateTestLog("Lead Data Generated is "+leadData, "PASS");
    	
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
   	
   	Report.updateTestLog("Lead Data Generated is "+leadData, "PASS");
   	
   	return new AcquisitionAction();
   } 	
   public AcquisitionAction getEshopLeadID(){
   	
   	String leadid=new OnlineDBConnector().getEshopLeadID(orderDate);
   	System.out.println(leadid);
   	
   	Report.updateTestLog("Lead ID Generated is "+leadid, "DONE");
   	
   	return new AcquisitionAction();  	
   }
   public AcquisitionAction getEshopLeadType(){	   	
	   	String leadtype=new OnlineDBConnector().getEshopLeadType(orderDate);
	   	System.out.println(leadtype);
	   	String strAcqLead = "ENERGY_ACQ";
	   	String strConvLead = "ENERGY_CONV";
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
   public AcquisitionAction getAuditEventID(UserProfile userProfile){
	   	String eventid=new OnlineDBConnector().getAuditEventID(orderDate,userProfile.getEmail());
	   	System.out.println(eventid);
	   	String strActID = "50";
	   	if (eventid.equals(strActID)){
	   	Report.updateTestLog("Audit Event ID Generated is :"+eventid, "PASS");
	   	}
	   	else{
	   	Report.updateTestLog("Audit Event ID not as expected, Audit Event ID Generated is :"+eventid, "FAIL");
	   	}	
	   	new OnlineDBConnector().deleteWTP(userProfile.getEmail());
	   	return new AcquisitionAction();  	
		}
}





        