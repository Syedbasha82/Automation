package bg.framework.app.functional.page.selfServe;
import java.util.Properties;

import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.RobotSendKeys;

public class BillHistoryPage extends BasePage{
	
	private final static String File_Name= "resources/selfServe/BillHistory.properties";
	private static Properties pageProperties = new PropertyLoader(File_Name).load();
	static int billsCount; 
	
	public void navigateToBillHistory(){
		
	verifyAndClickWithXpath(pageProperties.getProperty("BillHistory.BillingNew"), "Billing");
	browser.wait(1000);
	verifyAndClickWithXpath(pageProperties.getProperty("BillHistory.HistoryNew"), "BillingHistory");
	
	}

	public void verifyAndViewBills(){
        if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BillHistory.BillTable"))){
              Report.updateTestLog("The Bill History Table is present in the application", "PASS");
        
        
        billsCount = browser.getChildElementsCountByXpath(pageProperties.getProperty("BillHistory.BillTable"));
              if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BillHistory.ViewBills").replace("COUNT",""+1)));
              {
                    Report.updateTestLog("The Latest bill is present in the application", "PASS");
                    verifyAndClickWithXpath(pageProperties.getProperty("BillHistory.ViewBills").replace("COUNT",""+1), "latest Bill");
                    
              }
        verifyAndClickWithXpath(pageProperties.getProperty("BillHistory.DownloadStatement"),"Download Link For Latest Bill");
        saveBills();
        }
        else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BillHistory.BillUnavailable")))
        {
              Report.updateTestLog("The Bill History Table is not available for the account", "PASS");
        }
        
        verifyAndClickWithXpath(pageProperties.getProperty("BillHistory.YourAccount"),"YourAccount");
  }

	
	public void viewDifferentStatements(){
		
		for(int i=2;i<=billsCount;i++)
		{
			String BillDate=browser.getTextByXpath(pageProperties.getProperty("BillHistory.SelectDifferentStatement")
					.replace("BILLNO",""+i));
			verifyAndSelectDropDownBox(pageProperties.getProperty("BillHistory.ViewDifferentStatement"), "Different Statements",BillDate);
			verifyAndClickWithXpath(pageProperties.getProperty("BillHistory.ViewBillDifferent"), "View bill");
			verifyAndClickWithXpath(pageProperties.getProperty("BillHistory.DownloadStatement"),"Download Link For Latest Bill");
		
		browser.wait(1000);
		saveBills();
		browser.wait(1000);
		}
	}
	public void saveBills()
	{
	RobotSendKeys.typeenter();
    browser.wait(5000);
    
    RobotSendKeys.altS();
    browser.wait(5000);
    RobotSendKeys.typeenter();
    RobotSendKeys.altY();
    browser.wait(5000);
    RobotSendKeys.releseShift();
    browser.wait(5000);
	}
	}
