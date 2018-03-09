package bg.framework.app.functional.page.reFactoring;

import java.util.Properties;
import java.util.List;
import java.util.Iterator;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

  
public class FeedInTariffPage extends BasePage {
	//private final static String FILE_NAME = "resources/selfServe/FeedInTariff.properties";
	private final static String FILE_NAME = "resources/ReFactoring/FeedInTariff.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
   
   
    
    public void navigateToFeedInTariff ()
   
    
    {
    	String i[] = {"1","12","123","1234","12345","123456","1234567","12345678","123456789"};
        int j;
        for (j=0;j<9;j++){
    	
    	browser.open(ApplicationConfig.APP_BG_URL+"/fitreads");
    	if(browser.isElementVisibleWithName("installationId"))
    		 
               verifyAndInputByXpath(pageProperties.getProperty("FeedInTariff.InstallationID"), "InstallationIDasdasda","950000000123");
    	       verifyAndInputByXpath(pageProperties.getProperty("FeedInTariff.Meterserialnumber"), "Meterserialnumber","1755113626035");

               Report.updateTestLog("InstallationID & Meterserialnumber entered", "PASS");

               verifyAndSelectDropDownBox(pageProperties.getProperty("FeedInTariff.MeterreadingDate"), "MeterreadingDate","4");
               verifyAndSelectDropDownBox(pageProperties.getProperty("FeedInTariff.MeterreadingMonth"), "MeterreadingMonth","January");
               verifyAndSelectDropDownBox(pageProperties.getProperty("FeedInTariff.MeterreadingYear"), "MeterreadingYear","2013");

               Report.updateTestLog("Meterreading Date,Month & Year Entered", "PASS");
             
               
               verifyAndInputByXpath(pageProperties.getProperty("FeedInTariff.Reading"), "Reading",i[j]); 
             
               
             
              Report.updateTestLog("Meterreading Entered", "PASS");
              browser.wait(5000);
              verifyAndInputByXpath(pageProperties.getProperty("FeedInTariff.Emailaddress"), "Emailaddress","automation@bgdigitaltest.co.uk");

              Report.updateTestLog("Emailaddress Entered", "PASS");

              verifyAndClickWithXpath(pageProperties.getProperty("FeedInTariff.checkbox"), "checkbox");

              Report.updateTestLog("Checkbox Checked", "PASS");
              Report.updateTestLog("Checkbox Checked", "WARN");

              verifyAndClickWithXpath(pageProperties.getProperty("FeedInTariff.Submityourdetails"), "Submityourdetails");

              Report.updateTestLog( "Feed In Tariff Page is Present","WARN");

              verifyIsTextPresent("Thank you for your Feed-in Tariff meter reading");

              browser.wait(2000);
              if (browser.isTextPresent("Thank you for your Feed-in Tariff meter reading"))
              {
	             Report.updateTestLog( "Thank you for your Feed-in Tariff meter reading is present in the application","PASS");
	             Report.updateTestLog( "Thank you for your Feed-in Tariff meter reading is present in the application","WARN");
                }
            else {
	            Report.updateTestLog("Thank you for your Feed-in Tariff meter reading is not present in the application", "FAIL");
	
                }
        }       
    }
    }
