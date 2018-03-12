package bg.framework.app.functional.page.sales;

import java.util.Properties;

import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.action.sales.AcquisitionAction;
import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;


public class FreeInsulationPage extends BasePage {
	  private final static String FILE_NAME = "resources/sales/FreeInsulation.properties";
	  private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	    
    public AcquisitionAction enterInsulation()
    {
    	
    	String strval=ApplicationConfig.APP_BG_URL+"/loftoffer/register/";
    	browser.open(strval);
    	
    	return new AcquisitionAction();
    	
    }
	  
	  
	public AcquisitionAction enterHomecareDetails(Acquisition acquisition,UserProfile userProfile)
	{
		verifyAndInputById(pageProperties.getProperty("FreeInsulation.ReferenceNumber")," Account Number ", userProfile.getAccNumber() );
		verifyAndSelectDropDownBox(pageProperties.getProperty("FreeInsulation.Title")," Title Section ",userProfile.getTitle());
		
		verifyAndInputById(pageProperties.getProperty("FreeInsulation.FirstName"),"ENTER First Name ",userProfile.getFirstName() );
		verifyAndInputById(pageProperties.getProperty("FreeInsulation.SurName"),"ENTER SurName ",userProfile.getLastName() );
		verifyAndInputById(pageProperties.getProperty("FreeInsulation.Email"),"ENTER Email ",userProfile.getEmail() );
		verifyAndInputById(pageProperties.getProperty("FreeInsulation.Telephone"),"ENTER Telephone ",userProfile.getPhoneNumber());
		verifyAndInputById(pageProperties.getProperty("FreeInsulation.postcode"),"ENTER Postcode ",acquisition.getPostcode());
		
		verifyAndClickWithXpath(pageProperties.getProperty("FreeInsulation.Search"),"Click Search Button");
		
		browser.wait(5000);
		
		 if (browser.isElementVisible(pageProperties.getProperty("FreeInsulation.SelectAddress"))) {
	      browser.selectfromDropBox("id", pageProperties.getProperty("FreeInsulation.SelectAddress"), acquisition.getAddress());
	        	Report.updateTestLog("AddressList field verification,Address List field Exists and value entered is" + acquisition.getAddress(), "PASS");
	     }
		
		 verifyAndClick(pageProperties.getProperty("FreeInsulation.Homeowner"),"Home Owner");
		 verifyAndClick(pageProperties.getProperty("FreeInsulation.Yes"),"Home Yes");
		 verifyAndClick(pageProperties.getProperty("FreeInsulation.Cavitywall"),"Cavity Wall");
		 verifyAndClick(pageProperties.getProperty("FreeInsulation.Acceptterms"),"Accept Terms");
		 
		 verifyAndClickWithXpath(pageProperties.getProperty("FreeInsulation.Submit"),"Click Submit Button");
		 return new AcquisitionAction();
		 
	}
	
	
}
