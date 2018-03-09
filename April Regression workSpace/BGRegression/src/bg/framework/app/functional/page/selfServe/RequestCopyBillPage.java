package bg.framework.app.functional.page.selfServe;

import java.util.Properties;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class RequestCopyBillPage extends BasePage {
	
	private final static String File_Name= "resources/selfServe/RequestCopyBill.properties";
	private static Properties pageProperties = new PropertyLoader(File_Name).load();
	
	public void navigatetoBillingHistory(){
		verifyAndClickWithXpath(pageProperties.getProperty("RequestCopyBill.Billing"), "Billing");
		verifyAndClickWithXpath(pageProperties.getProperty("RequestCopyBill.History"), "BillingHistory");
	}
	
	public void verifyViewBills(){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("RequestCopyBill.BillTable"))){
			Report.updateTestLog("The Bill History Table is present in the application", "PASS");
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("RequestCopyBill.ViewBills").replace("COUNT",""+1)));
			{
				Report.updateTestLog("The Latest bill is present in the application", "PASS");
				verifyAndClickWithXpath(pageProperties.getProperty("RequestCopyBill.ViewBills").replace("COUNT",""+1), "latest Bill");
			}
		}
	}
	
	public void requestBillCopy(){
		if(browser.isTextPresent(pageProperties.getProperty("RequestCopyBill.CopyBill"))){
			verifyAndClickWithLinkText(pageProperties.getProperty("RequestCopyBill.CopyBill"), "Click Request a copy bill link");
			verifyRequestedBill();
		}
		else{
			Report.updateTestLog("Data Error : Request a copy bill section not found", "Fail");
		}
	}
	
	public void verifyRequestedBill(){
		if(browser.isTextPresent("We have received your request and a paper bill will be sent to you within 10 working days")){
			Report.updateTestLog("Request Bill Submitted Successfully", "Pass");
		}
		else{
			Report.updateTestLog("Request Bill not Submitted Successfully", "Fail");
		}
		
		if(browser.isTextPresent(pageProperties.getProperty("RequestCopyBill.CopyBill"))){
			Report.updateTestLog("Request a copy bill link is present after requesting copy bill", "Fail");
		}
		
	}
	
	public void logout(){
			verifyAndClickWithXpath(pageProperties.getProperty("RequestCopyBill.logout"), "Logout Button");
			browser.wait(5000);
	}
}
