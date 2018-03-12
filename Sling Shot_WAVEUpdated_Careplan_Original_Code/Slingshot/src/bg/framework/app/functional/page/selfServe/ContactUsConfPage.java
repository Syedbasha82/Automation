package bg.framework.app.functional.page.selfServe;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.ContactUsQueue;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.*;
import com.jcraft.jsch.JSchException;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 07/02/12
 * Time: 17:27
 * To change this template use File | Settings | File Templates.
 */

public class ContactUsConfPage extends BasePage {
    private final static String FILE_NAME = "resources/selfServe/ContactUsConfirmationPage.Properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
    private static final String BATCH = "./local/home/wl_fit/scripts/doqueries.sh";
    private static final String BATCH_OUTPUT = "/shared/online/datafiles/outbound/queries/out";
    private static final String filePathKANA = Report.createTxtFile("KANA");
    private static final String filePathAutoCef = Report.createTxtFile("AutoCef");

    public void VerifyContactUsConfirmationPage(UserProfile userprofile, String cat) {
        if(browser.isTextPresent("System error")){
            Report.updateTestLog("System error", "FAIL");
        }
        else{
        String referenceNo = "";
        browser.wait(getWaitTime());
        try{
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ContactUsConfirmationPage.ReferenceNo"))) {
        }}catch(NoSuchElementException e){
        	browser.isElementVisibleWithXpath(pageProperties.getProperty("ContactUsConfirmationPage.OAMReferenceNo"));
        }
            verifyAudit(userprofile);
            referenceNo = browser.getTextByXpath(pageProperties.getProperty("ContactUsConfirmationPage.ReferenceNo"));
            if (!(referenceNo=="")) {
                Report.updateTestLog("Reference Number :" + referenceNo + ",First Name :"+userprofile.getFirstName()+ "  Last Name :"+ userprofile.getLastName()+ "Verified in Confirmation Page", "PASS");
                Report.updateTestLog("Contact Us Confirmation Page Verified", "PASS");
                String strconftext = browser.getTextByXpath(pageProperties.getProperty("ContactUsConfirmationPage.Query"));
                int strconf = strconftext.length();
                Report.updateTestLog(strconf+"  Characters are displayed in Confirmation Page", "PASS");
           
            } else {
                Report.updateTestLog("Contact Us Confirmation Page Not Verified", "FAIL");
            }
            
        verifyAutoCefLead(referenceNo, cat);
        }
    }


    private void verifyAutoCefLead(String referenceNo, String text) {
        OnlineDBConnector dbconnector = new OnlineDBConnector();
        String leadType = dbconnector.verifyLeadDBforAutoCef(referenceNo);       
        String contact1 = "CONTACT_US";
        System.out.println("leaddtype: " + leadType);
        System.out.println("autocef or kana: " + autoCefOrKana(text));
        if (autoCefOrKana(text).equalsIgnoreCase("KANA")) {
            Report.updateFile(filePathKANA, referenceNo + " - " + text + " - " + extractXMLFromLogs(referenceNo));
            Report.updateFile(filePathKANA, " ");
            Report.updateFile(filePathKANA, " ");
        } else if (leadType.equals(contact1) && (autoCefOrKana(text).equalsIgnoreCase("Autocef"))) {
            Report.updateFile(filePathAutoCef, referenceNo + " - " + text + " - " + extractXMLFromLogs(referenceNo));
            Report.updateFile(filePathAutoCef, " ");
            Report.updateFile(filePathAutoCef, " ");
            Report.updateTestLog("Online DB AutoCef Lead Type exists in AutoCef table ", "PASS");
        } else if (leadType.equals(contact1) && (autoCefOrKana(text).equalsIgnoreCase("kana"))) {
            Report.updateTestLog("Online DB AutoCef Lead Type exists in AutoCef table for KANA", "FAIL");
        } else {
            Report.updateTestLog("Category And Product doesn't match with XML Values", "FAIL");
        }
    }

    private void verifyAudit(UserProfile userprofile) {
        OnlineDBConnector dbconnector = new OnlineDBConnector();
        int rowCount;
        rowCount = dbconnector.verifyAuditDBContactUs(userprofile.getEmail());
        if (rowCount > 0) {
            Report.updateTestLog("Customer details stored in Audit Details table ", "PASS");
        } else {
            Report.updateTestLog("Audit Details for contact us is failed ", "FAIL");
        }
    }

    public void navigateToContactUsPage() {
    	System.out.println("Enters return link");
        if (ApplicationConfig.BRAND.equalsIgnoreCase("BG")) {
            //browser.open(ApplicationConfig.APP_BG_URL+"/content/britishgas/youraccount/contactus/contactuspersonaldetails.html");
            browser.open(ApplicationConfig.APP_BG_URL + "/Help_Advice/ContactUs/");
        } else {
            //browser.open(ApplicationConfig.APP_FUSION_URL+"/content/britishgas/youraccount/contactus/contactuspersonaldetails.html");
            browser.open(ApplicationConfig.APP_FUSION_URL+"/Contactus/");
            //verifyAndClickWithXpath(pageProperties.getProperty("ContactUsConfirmationPage.BackToSEContactUs"), "Back To Contact Us Link");
        }
        /*if(browser.isTextPresent(pageProperties.getProperty("ContactUsConfirmationPage.BackToContactUsPage"))){
            browser.clickWithLinkText(pageProperties.getProperty("ContactUsConfirmationPage.BackToContactUsPage"));
            Report.updateTestLog( "Navigate to Contact us page", "PASS");
            browser.wait(200);
        }
        else{
            Report.updateTestLog( "Failed To Navigate To Contact Us Page", "FAIL");
        }*/
    }

    private String autoCefOrKana(String text) {
        System.out.println("text is: " + text);
        ContactUsQueue autoCefOrKana = new TestDataHelper().getContactUsQueue(text);
        return autoCefOrKana.getQueueName();
    }

    private String checkFAQLink(String text) {
        System.out.println("text is: " + text);
        ContactUsQueue autoCefOrKana = new TestDataHelper().getContactUsQueue(text);
        return autoCefOrKana.getQueueName();
    }

    private String extractXMLFromLogs(String ref) {
        SshClient sshClient = new SshClient();
        String strLogXml = "";
        try {
            sshClient.connect();
            if (sshClient.isConnected()) {
                sshClient.send("cd /local/home/wl_fit/domains/wl_fit/crx-quickstart/logs/");
                browser.wait(5000);
                strLogXml = sshClient.send("grep " + ref + " debug.log ");
                //System.out.println(strLogXml);
                sshClient.disconnect();
            }
        } catch (JSchException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return strLogXml;

    }

    public String runAutoCefBatch() {
        SshClient sshClient = new SshClient();
        String strLogXml = "";
        String strCSVFileName = "";
        try {
            sshClient.connect();
            if (sshClient.isConnected()) {
                // sshClient.send("cd /shared/online/datafiles/outbound/queries/archive");
                //sshClient.send("rm *.csv");

                sshClient.send("cd /local/home/wl_fit/scripts");
                sshClient.send("./doautocefqueries.sh");
                browser.wait(20000);
                sshClient.send("clear");
                sshClient.send("cd /shared/online/datafiles/outbound/queries/archive");
                browser.wait(1000);
                String strCSVList = sshClient.send("ls ");
                System.out.println(strCSVList);
                System.out.println(strCSVList.indexOf(33, strCSVList.length() - 33));
                String[] arrstrLogXml = strCSVList.split(" ");
                int intCount = arrstrLogXml.length;
                strCSVFileName = arrstrLogXml[intCount - 1];
                System.out.println(strCSVFileName);
                sshClient.disconnect();
            }
        } catch (JSchException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        /*ScpClient scpClient = new ScpClient();
         browser.wait(1000);
        //scpClient.getFile("/shared/online/datafiles/outbound/queries/archive", "*.csv", "AutoCefBatchResult.csv");
        scpClient.getFile("/shared/online/datafiles/outbound/queries/archive",strCSVFileName,"");
        scpClient.disconnect();
        Report.updateTestLog("AutoCef Batch Process Executed and refer the CSV file","Done");*/
        return strLogXml;
    }
}

