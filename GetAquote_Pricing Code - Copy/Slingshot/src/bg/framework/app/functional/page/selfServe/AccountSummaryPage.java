package bg.framework.app.functional.page.selfServe;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

//import org.openqa.selenium.internal.selenesedriver.IsElementDisplayed;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.RobotSendKeys;
import bg.framework.app.functional.util.RunQTP;

public class AccountSummaryPage extends BasePage {

    private final static String FILE_NAME = "resources/selfServe/"+ApplicationConfig.BRAND+"AccountSummary.properties";
    private final static String SMR_FILE_NAME = "resources/selfServe/SubmitMeterReadPage.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();


    public AccountSummaryPage() {

    }

    public AccountSummaryPage(UserProfile userProfile) {
        UserProfile userProfile1 = userProfile;
    }

    /**
     * This Method will navigate the User from YouAccountPage to SubmitMeter
     * Read page. Will update the Log as 'PASS' if the Page Title in
     * SubmitMeterReadPage.properties matches with current page title.
     */
    public void navigateToSMR() {
        String logInfo = "";
        String logStatus = "PASS";
        browser.wait(2000);
        browser.clickWithXpath(pageProperties
                .getProperty("AccountSummaryPage.SMRLinkXPath"));
        String expectedPageTitle = new PropertyLoader(SMR_FILE_NAME).load().getProperty(
                "SubmitMeterRead.SelectMeterPageTitle");
        browser.wait(3000);
        String currentPageTitle = "Submit a meter read";
        if (!expectedPageTitle.equalsIgnoreCase(currentPageTitle)) {
            logInfo = logInfo
                    + " <b> Current page title does not match with expected.</b> Expected page title: ;"
                    + expectedPageTitle + "', Current Page";
            logStatus = "FAIL";
        } else
            logInfo = logInfo + " SelectMeterPageTitle Matches with expected. ";
        Report.updateTestLog(logInfo, logStatus);

    }

        public void verifyAccountSummaryPage(String accountNumber) {
       verifyPageTitle("Account Summary");
        if(ApplicationConfig.BRAND.equalsIgnoreCase("BG")){
        	ArrayList<String> link = new ArrayList<String>();
        	link.add("AccountSummaryPage.latestStatementLink");
        	link.add("AccountSummaryPage.whatsThisLink");
        	link.add("AccountSummaryPage.seeUnitLink");
        	link.add("AccountSummaryPage.compareTariffLink");
        	link.add("AccountSummaryPage.paymentHistoryLink");
        	link.add("AccountSummaryPage.meterReadingHistoryLink");
        	link.add("AccountSummaryPage.viewEnergyUsage");
        	link.add("AccountSummaryPage.compareEnergyUsage");
        	String s = link.toString();
        	System.out.println(s);
        	for (String i : link) {
        		System.out.println(i);
        		verifyLink(i);
        	}
        }
              verifyDataVerification(accountNumber);


    }
        public void navigateToAllAccountsPage(){
        	browser.clickWithXpath(pageProperties.getProperty("AccountSummaryPage.viewAllAccounts"));
        }
        
     private void verifyDataVerification(String accountNumber){
    	 System.out.println("RUN QTP");
         RunQTP runQTP = new RunQTP();

         runQTP.runQTP("BGRegression\\src\\bg\\framework\\app\\functional\\util\\vbsScripts\\Sample.vbs", accountNumber);

         browser.wait(15000);
         
         String meterread = null;
         String meterdate = null;
         String tarrif =null;
         
         String balance = null;

         try {
             File file1 = new File("C:\\SAPData\\meterread.txt");
             File file = new File("C:\\SAPData\\balance.txt");
             File file2 = new File("C:\\SAPData\\tarrif.txt");
             
             FileReader fr = new FileReader(file1);
             BufferedReader br = new BufferedReader(fr);
             FileReader fr1 = new FileReader(file);
             BufferedReader br1 = new BufferedReader(fr1);
             FileReader fr2 = new FileReader(file2);
             BufferedReader br2 = new BufferedReader(fr2);
             
             
             meterread = br.readLine();
             meterdate = br.readLine();
             tarrif  = br2.readLine();
             tarrif  = br2.readLine();
             
//             System.out.println("..............................................................."+meterread);
//           System.out.println("..............................................................."+tarrif);
             System.out.println("LENGTH > "+meterdate.length());
             if(meterdate.length()>1)
             meterdate = meterdate.substring(0, 2) + " " + meterdate.substring(2, 5) + " " + meterdate.substring(5);
             balance = br1.readLine();
            
             if (balance.contains("-")) {
            	 
            	if(browser.isTextPresent("credit"))
            	{Report.updateTestLog("CREDIT is present in the application", "PASS");
            		}
            	else{Report.updateTestLog("CREDIT is not present in the application", "FAIL");}
            	 
                 balance = balance.substring(0, balance.indexOf('-'));
             }else if(browser.isTextPresent("debit"))
            	 {Report.updateTestLog("DEBIT is present in the application", "PASS");
            	 }
             else{Report.updateTestLog("ZERO balance account is present in the application", "PASS");}
             
             br.close();
             br1.close();
             br2.close();
             } catch (IOException e) {
             System.out.println("bad"+e);
         }
         String meterText= browser.getTextByXpath(pageProperties.getProperty("AccountSummaryPage.meterRead"));
//         int meterCount=browser.getChildElementsCountByXpath(pageProperties.getProperty("AccountSummaryPage.meterRead"));
//         System.out.println(meterCount);
//         if(meterCount==2){
//          meterText = meterText+" "+browser.getTextByXpath(pageProperties.getProperty("AccountSummaryPage.meterRead")+"[2]");
//         }
         System.out.println(meterText);
         if (meterText.contains(meterdate)) {
             Report.updateTestLog("Meter Date " + meterdate + " is displayed", "PASS");
         } else {
             Report.updateTestLog("Meter Date " + meterdate + " is not displayed", "FAIL");
         }
         meterText=meterText.replaceAll("\n", " ");
         if(ApplicationConfig.BRAND.equalsIgnoreCase("fusion")){
        	 meterText=meterText.replaceAll(" ", "");
         }
         System.out.println(meterText);
         if (meterText.contains(meterread)) {
             Report.updateTestLog("Meter Read " + meterread + " is displayed", "PASS");
         } else {
             Report.updateTestLog("Meter Read " + meterread + " is not displayed", "FAIL");
         }
         

         if (browser.isTextPresent(balance)) {
             Report.updateTestLog("Balance amount " + balance + " is displayed", "PASS");
         } else {
             Report.updateTestLog("Balance amount " + balance + " is not displayed", "FAIL");
         }
         String paymentType = browser.getTextByXpath(pageProperties.getProperty("AccountSummaryPage.payType1"));
        
         if (paymentType.contains("Direct Debits")) {
             paymentType = "Direct Debit";
         }
         if (paymentType.contains("Credit/Debit card")) {
             paymentType = "Credit/Debit card";
         }
         System.out.println(paymentType);
         if (browser.getTextByXpath(pageProperties.getProperty("AccountSummaryPage.payType1")).contains(paymentType)) {
             Report.updateTestLog("Payment type " + paymentType + " is displayed", "PASS");
         } else if (browser.getTextByXpath(pageProperties.getProperty("AccountSummaryPage.payType1")).contains(paymentType)) {
             Report.updateTestLog("Payment type " + paymentType + " is displayed", "PASS");
         } else {
             Report.updateTestLog("Payment type " + paymentType + " is not displayed", "FAIL");
         }
         
         String tarrifinPage=browser.getTextByXpath(pageProperties.getProperty("AccountSummaryPage.tarrif"));
         if(tarrifinPage.trim().contains(tarrif))
         {
        	 Report.updateTestLog("The tarrif  " + tarrif + " is displayed", "PASS"); 
         }else
         {
         Report.updateTestLog("The tarrif  " + tarrif + " is not displayed", "FAIL");
         }
         }
    public void verifyWTPAccount(){
    	ArrayList<String> link=new ArrayList<String>();
    	link.add("AccountSummaryPage.ConfirmOrder");
    	link.add("AccountSummaryPage.EnergySupplyDate");
    	link.add("AccountSummaryPage.OpeningMeterReading");
    	link.add("AccountSummaryPage.AccountComplete");
        for (String i : link) {
            System.out.println(i);
            verifyLink(i);
        }
    }
    public void verifyBGSAccount(){
    	ArrayList<String> link=new ArrayList<String>();
       	link.add("AccountSummaryPage.BookEngineer");
       	for (String i : link) {
            System.out.println(i);
            verifyLink(i);
        }
    }

    private void verifyLink(String link) {
        String linkName = link.substring(link.indexOf('.') + 1, link.length());
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty(link))) {
            Report.updateTestLog(linkName + " Link Exist", "PASS");
        } else {
            Report.updateTestLog(linkName + " Link not Exist", "FAIL");
        }
    }

    public void navigateToAllYourAccount() {

        browser.clickWithLinkText("View all your accounts");
    }

    public void navigateToProductsAndServicesPage() {
        browser.wait(getWaitTime());
        if (browser.isElementVisibleWithXpath(pageProperties
                .getProperty("YourAccountPage.ProductAndServices"))) {
            // System.out.println("link text: "+pageProperties.getProperty("YourAccountPage.ProductAndServices"));
            browser.clickWithXpath(pageProperties
                    .getProperty("YourAccountPage.ProductAndServices"));
            browser.wait(getWaitTime());
            Report.updateTestLog("Products and Services Link is clicked", "PASS");
        } else {
            Report.updateTestLog("Products and Services Link is not clicked", "FAIL");
        }

    }

    public void navigateToGetAPricePage() {
        browser.wait(getWaitTime());
        if (browser.isElementVisibleWithXpath(pageProperties
                .getProperty("YourAccountPage.ProductAndServices"))) {
            // System.out.println("link text: "+pageProperties.getProperty("YourAccountPage.ProductAndServices"));
            browser.clickWithXpath(pageProperties
                    .getProperty("YourAccountPage.ProductAndServices"));
            browser.wait(getWaitTime());
            Report.updateTestLog("Products and Services Link is clicked", "PASS");
        } else {
            Report.updateTestLog("Products and Services Link is not clicked", "FAIL");
        }

    }

    public void navigateToContactUsPage() {
        //browser.open(ApplicationConfig.ContactUs_URL);
        //if
         //       (browser.isTextPresent(pageProperties.getProperty("YourAccountPage.ContactUs"))) {
        //    browser.clickWithLinkText(pageProperties.getProperty("YourAccountPage.ContactUs"));
        //}
        //.wait(getWaitTime());
    	//verifyAndClickWithLinkText(pageProperties.getProperty("AccountSummaryPage.ContactUsPage"), "Contact us Page Link");
    	verifyAndClickWithXpath(pageProperties.getProperty("AccountSummaryPage.ContactUsPage"), "Contact us Page Link");
    	browser.wait(getWaitTime());
    	verifyIsElementVisibleWithXpath(pageProperties.getProperty("AccountSummaryPage.BreadCrum"), "Bread Crum changed");
    }

    public void navigateToContactUs() {
        verifyAndClickWithXpath(pageProperties.getProperty("AccountSummaryPage.ContactUsPage"), "Contact us Page Link");
    	browser.wait(getWaitTime());
    	verifyIsElementVisibleWithXpath(pageProperties.getProperty("AccountSummaryPage.BreadCrum"), "Bread Crum changed");
    	browser.browserBack();
    }

    public void navigateToMovingHomePage() {
    	//verifyAndClickWithXpath(pageProperties.getProperty("AccountSummaryPage.MovingHome"), "Moving Home Page");
    	//verifyAndClickWithName(pageProperties.getProperty("AccountSummaryPage.MovingHome"), "Moving Home Page");
    	browser.wait(getWaitTime());
    	verifyAndClickWithLinkText(pageProperties.getProperty("AccountSummaryPage.MovingHome"), "Moving Home Page");
    	browser.wait(getWaitTime());
    	browser.browserBack();
    }

    public void navigateToManagePersonalDetailsPage() {
    	browser.wait(getWaitTime());
        verifyAndClickWithLinkText(pageProperties.getProperty("AccountSummaryPage.ManagePersonalDetailsPage"), "Manage Personal Details Page Link");
        browser.wait(getWaitTime());
    }
    
   
    public void navigateToAccount() {
        String logInfo = "";
        String logStatus = "DONE";

        if (browser.isElementVisibleWithXpath(pageProperties
                .getProperty("YourAccountPage.Overlay.ContinueToAcctXpath"))) {
            browser.clickWithXpath(pageProperties
                    .getProperty("YourAccountPage.Overlay.ContinueToAcctXpath"));
            logInfo = logInfo + "Selected Continue to Account in the Overlay";
        }
        Report.updateTestLog(logInfo, logStatus);

    }
    
    public void logoutPage(){
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("AccountSummaryPage.logout")))
    	{
    	verifyAndClickWithXpath(pageProperties.getProperty("AccountSummaryPage.logout"), "Log out Link");
    }
    	else if(browser.isTextPresent("Log out"))
    	{
    		verifyAndClickWithLinkText("Log out", "Logout");
    	}
    }
    public void setAccountNumber(String accNumber,UserProfile userProfile){
    	userProfile.setAccNumber(accNumber);
    }
    public void viewPaymentHistory(){
    	verifyAndClickWithLinkText(pageProperties.getProperty("AccountSummaryPage.AccountHistory"), "ViewPaymentHistory");
    	browser.wait(1000);
    	if (browser.isTextPresent(pageProperties.getProperty("AccountSummaryPage.HistoryUnavailable")))
    	{
    		Report.updateTestLog("User's account history is not available", "PASS");
    	}
    	verifyAndClickWithLinkText(pageProperties.getProperty("AccountSummaryPage.DownloadTransaction"),"DownloadPDF");
    	
        RobotSendKeys.typeenter();
        browser.wait(5000);
        
        RobotSendKeys.altS();
        browser.wait(5000);
        RobotSendKeys.altY();
        browser.wait(5000);
        RobotSendKeys.releseShift();
        browser.wait(5000);    	
    }
    
    public void clickSeeYourStatementLink(){
    	//browser.open("https://10.224.70.83/Your_Account/Update-PbFlag/");
    	browser.wait(2000);
    	String link=browser.getTextByXpath(pageProperties.getProperty("AccountSummary.seeYourStatementLink").replace("NUMBER",""+1));
		verifyAndClickWithXpath(pageProperties.getProperty("AccountSummary.seeYourStatementLink").replace("NUMBER", ""+1), link);		
    }
    
    public void clickGoPaperLessLink(){
    	verifyAndClickWithXpath(pageProperties.getProperty("AccountSummary.goPaperLessLink"), "Go Paperless link");
    }
    
    public void pbFlagLinkNonExistverification(){
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("AccountSummary.goPaperLessLink"))){
    		Report.updateTestLog("Go Paperless link exist in page", "FAIL");
    	}else{
    		Report.updateTestLog("Go Paperless link not exist in page", "PASS");
    	}
    	
    }
}
