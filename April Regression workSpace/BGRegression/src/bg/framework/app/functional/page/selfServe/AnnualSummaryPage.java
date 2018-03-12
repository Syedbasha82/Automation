package bg.framework.app.functional.page.selfServe;

import java.util.List;
import java.util.Properties;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;

import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.RobotSendKeys;

 

public class AnnualSummaryPage extends BasePage{
	public static int AnnualSummary;
	
	public final static String FILE_NAME = "resources/Selfserve/AnnualSummary.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	
	public void navigateToAnnualSummaryPage() {
		verifyAndClickWithXpath(pageProperties.getProperty("AnnualSummary.navigate"), "Annual Summary");
		Report.updateTestLog("Annual Summary link is present in the application", "PASS");
		
		browser.wait(5000);
		
	}
	
	public void navigateToAnnualSummaryThroughDeepLink(){
		browser.open(ApplicationConfig.APP_BG_URL+"/annualsummary");
	}
	
	public void clickViewPDFLink(UserProfile userprofile){
		verifyAndClickWithXpath(pageProperties.getProperty("AnnualSummary.viewPDF").replace("ACCTNUM", userprofile.getGasAccount()),"View PDF Link");
		Report.updateTestLog("Overlay is displayed","WARN");
	}
public void verifyAnnualSummarypage() {
		verifyIsTextPresent("Annual summary");
		Report.updateTestLog("Annual Summary is  present in the application","Pass");
		}
public void verifyAndViewAnnualSummaryPdf() {
		if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AnnualSummary.table")));
		Report.updateTestLog("Annual Summary PDF is present in the application", "WARN");
		
		AnnualSummary = browser.getChildElementsCountByXpath(pageProperties.getProperty("AnnualSummary.table"));
		System.out.println("Annual Summary="+AnnualSummary);
       for (int i=1; i<=AnnualSummary; i++)
	{
		verifyAndClickWithXpath(pageProperties.getProperty("AnnualSummary.DownloadStatement").replace("ROW", i+""),"Download Link For Annual Summary");
		
		
		browser.wait(10000);
	    saveBills();
		//browser.wait(1000);
	}
	}
	
public void saveBills() {
		RobotSendKeys.typeenter();
		Report.updateTestLog("Enter button clicked Sucessfuly", "WARN");
	    browser.wait(10000);
	    Report.updateTestLog("Annual Summary PDF is Saved Sucessfuly", "PASS");
	}
public void verifyBillHistoryLink () {
		verifyAndClickWithXpath(pageProperties.getProperty("AnnualSummary.BillHistoryLink"),"Bill History link");
		browser.wait(5000);
		verifyIsTextPresent("Bill history");
		
		
		}
	
	
///////////////////////////////////////////////////////Account Type Selector////////////////////////////////////////////		
	public void annualSumaryVerification(String AccountType) { 
	
		if (AccountType.equals("Dual"))
		{
			verifyAnnualSummaryForDual();
		}
		else {
			verifyAndViewAnnualSummaryPdf ();
			verifyBillHistoryLink();
		}
	}
		
/////////////////////////////////////////////////////////////For Dual Account///////////////////////////////////
	public void verifyAnnualSummaryForDual () {
			List<String> Accounts = browser.getFromDropBox("id", pageProperties.getProperty("AnnualSummary.AccoutSelector"));
			System.out.println("gggggggggggggggggggggggggg" + Accounts.size());
			for (int x = 0; x < Accounts.size(); x++) {
				System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrr" + Accounts.get(x));
				browser.selectfromDropBox("id",pageProperties.getProperty("AnnualSummary.AccoutSelector"), Accounts.get(x));
				Report.updateTestLog(Accounts.get(x)+ " is Selected", "PASS");
				verifyAndClickWithXpath(pageProperties.getProperty("AnnualSummary.Go"), "Go");
				browser.wait(2000);
				verifyAndViewAnnualSummaryPdf();
				verifyBillHistoryLink();
				browser.browserBack();
		}	
		}
	public void navigateToBillHistory(){
		
		verifyAndClickWithXpath(pageProperties.getProperty("AnnualSummary.Billing"), "Billing");
		browser.wait(1000);
		
		
		}	

	}

