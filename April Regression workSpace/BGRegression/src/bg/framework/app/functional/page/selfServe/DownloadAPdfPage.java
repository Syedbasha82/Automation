package bg.framework.app.functional.page.selfServe;

import java.util.Properties;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.RobotSendKeys;

public class DownloadAPdfPage extends BasePage{
	
	private final static String File_Name= "resources/selfServe/RequestCopyBill.properties";
	private static Properties pageProperties = new PropertyLoader(File_Name).load();
	
	public void navigatetoLatestStatement(){
		verifyAndClickWithLinkText(pageProperties.getProperty("DownloadAPdf.LatestStatement"), "Click Latest Statement Bill");
	}
	
	public void downloadPDF(){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("DownloadAPdf.DownloadPDF"))){
			verifyAndClickWithXpath(pageProperties.getProperty("DownloadAPdf.DownloadPDF"), "Download PDF link clicked");
		}
	}
	
	public void verifyPDFDownload(){
		if(browser.isTextPresent("We're sorry, your PDF bill/statement isn't ready just yet.")){
			Report.updateTestLog("Data Issue : PDF statement could not be downloaded", "Fail");
		}
		else{
			Report.updateTestLog("PDF statement Downloaded", "Pass");
			saveBills();
		}
	}
	
	public void verifyPDFDownloadGasMessage(){
		if(browser.isTextPresent("We're sorry, your PDF bill/statement isn't ready just yet.")){
			Report.updateTestLog("PDF Download Bill generation message displayed successfully", "Pass");
		}
		else{
			Report.updateTestLog("PDF Download Bill generation message not displayed","Fail");
		}
	}
	
	public void verifyPDFDownloadBillEntry(){
		if(browser.isTextPresent("We're sorry, but due to technical reasons we have been unable to complete your request.")){
			Report.updateTestLog("PDF Download Error Message displayed successfully for customer without bill entry", "Pass");
		}
		else{
			Report.updateTestLog("Pdf Download error message not displayed successfully", "Fail");
		}
	}
	
	public void logout(){
			verifyAndClickWithXpath(pageProperties.getProperty("RequestCopyBill.logout"), "Logout Button");
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
