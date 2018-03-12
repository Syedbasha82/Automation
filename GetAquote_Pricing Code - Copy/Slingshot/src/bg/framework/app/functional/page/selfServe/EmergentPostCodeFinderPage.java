package bg.framework.app.functional.page.selfServe;

import java.util.Properties;

import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class EmergentPostCodeFinderPage extends BasePage {
	private final static String FILE_NAME = "resources/selfServe/EmergentPostCodeFinder.Properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
    
    public void navigateToEmergencies()
    {
    	browser.wait(1000);
    	verifyAndClickWithXpath(pageProperties.getProperty("HomePage.Emergencies"), "Emergency Link");
    }
    
    public void enterThePostCode()
    {
    	
    	 browser.wait(3000);
    	 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Emergencies.EmergencyNumbersDropDown")))
    	 {
    		 
    	 }
         verifyAndClickWithXpath(pageProperties.getProperty("Emergencies.EmergencyNumbersDropDown"), "Expand Table");
         
         browser.wait(3000);
    	
      browser.wait(1000);
      String[] addPostCode = {"AL7 4hd","LE12 9LX","CH4 7UH","B10 9Ju","BB2 7DF"};
      for(int i = 0; i< addPostCode.length;i++)
      {
    	  browser.wait(1000);
      verifyAndInputByXpath(pageProperties.getProperty("Emergencies.Postcode"), "Post Code Field", addPostCode[i]);
      verifyAndClickWithXpath(pageProperties.getProperty("Emergencies.Continue"), "Continue");
      
      browser.wait(3000);
      verifyIsElementVisibleWithXpath(pageProperties.getProperty("Emergencies.DisplayedValue"), "Displayed Phone Number");
      if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Emergencies.DisplayedValue")))
      {
      String strGetValue = browser.getTextByXpath(pageProperties.getProperty("Emergencies.DisplayedValue"));
      String strTemp = "";
      boolean isPresent = false;
      for(int j = 1;j<=14;j++)
      {    	  
    	
    	  strTemp = browser.getTextByXpath(pageProperties.getProperty("Emergencies.PostCodeTable").replace("ROWS", ""+j));
    	 
    	if(strTemp.trim().equalsIgnoreCase(strGetValue.trim()))  
    	{
    		Report.updateTestLog(""+strGetValue+" is displayed and is present in the table ", "PASS"); 
    		isPresent = true;
    		break;
    	}
      }
      if(isPresent == false)
      {
        Report.updateTestLog(""+strGetValue+" is displayed but not present in the table ", "FAIL");
      }
      browser.wait(1000);
      }
      }
    }

}
