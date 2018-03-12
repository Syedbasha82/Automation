package bg.framework.app.functional.page.Slingshot;

import java.util.Properties;

import org.apache.bcel.verifier.VerifyDialog;


import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.entities.CrmUserProfile;

public class SapCrmPage extends BasePage {
    
	private final static String FILE_NAME="resources/Slingshot/SapCrm.properties";
	private static Properties pageProperties=new PropertyLoader(FILE_NAME).load();
	
	public void enterLoginDetails(CrmUserProfile crmuserProfile){
		
		browser.open("http://crmqalq7.uk.centricaplc.com:8000/sap/bc/bsp/sap/crm_ui_start/default.htm?sap-client=100&sap-sessioncmd=open");
		//browser.getText(pageProperties.getProperty("SapCrmPage.client"));
		System.out.println("Client value :"+crmuserProfile.getclient());
		
		verifyAndInputById(pageProperties.getProperty("SapCrmPage.client"), "Client", crmuserProfile.getclient());
		verifyAndInputById(pageProperties.getProperty("SapCrmPage.username"), "Username",crmuserProfile.getusername());
		verifyAndInputById(pageProperties.getProperty("SapCrmPage.password"), "Password",crmuserProfile.getpassword());
		//verifyAndSelectDropDownBox(pageProperties.getProperty("SapCrmPage.language"), "Language", crmuserProfile.getlanguage());
		
		verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.logon"), "Click-Submit");
		
		//verify title
		verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.logonContinue1"), "Click-Continue");
		verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.businessrole"), "Click-Agentworkbench");
		
		getWaitTime();
        browser.open("http://crmqalq7.uk.centricaplc.com:8000/sap/bc/bsp/sap/crm_ui_start/default.htm?sap-client=100&sap-sessioncmd=open"); 
		
	}
	
    public void fetchDetailsandInsert(CrmUserProfile crmuserProfile){
    	
    	System.out.println("Dynamic wait before");
    	dynamicWait(pageProperties.getProperty("SapCrmPage.SearchBy"), "xpath");
    	System.out.println("Dynamic wait after");
    	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.SearchBy"), "Click-SearchByDropdown");
    	browser.selectfromDropBoxByXpath(pageProperties.getProperty("SapCrmPage.SearchBy"), "Contact Business Partner ID");
    	verifyAndInputById(pageProperties.getProperty("SapCrmPage.ReferenceNumber"), "Reference Number", crmuserProfile.getreferencenumber());
    	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.Search"), "Click-Search");
    	
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
			
    		if(propertyname=="xpath"){
    			
				if(browser.isElementVisibleWithXpath(property))break;
				System.out.println("xpath-condition");
    		}else if(propertyname=="id"){
    			
    			if(browser.isElementVisible(property))break;
    			System.out.println("id-condition");
    		}    		   		
    		System.out.println("Count value"+count);	
    	}while (count>=10);
    	
    }
    
       }
