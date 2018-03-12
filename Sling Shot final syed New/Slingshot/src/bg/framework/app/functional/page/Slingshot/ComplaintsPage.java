package bg.framework.app.functional.page.Slingshot;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.GlobalErrorMessages;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;



public class ComplaintsPage extends BasePage {
	private final static String FILE_NAME = "resources/Slingshot/Complaints.Properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    public void ComplaintsFindmore() {
    	browser.wait(getWaitTime());
    	Report.updateTestLog("Help & Advice Page ","WARN");
    	//verifyAndClickWithXpath(pageProperties.getProperty("Complaints.findmore"), "Find Out More Link");
    	browser.open(ApplicationConfig.APP_BG_URL+"/business/help-and-advice/business-complaints");
    	browser.wait(getWaitTime());
    }
    public void selectGasandEelctComplaint() {
    	browser.wait(getWaitTime());
    	Report.updateTestLog("compalints Page ","WARN");
    	browser.open(ApplicationConfig.APP_BG_URL+"/business/help-and-advice/business-complaints/gas-and-electricity-complaints");
    	//verifyAndClickWithXpath(pageProperties.getProperty("Complaints.Complainttype"), "Gas & Electricity Link");
    	browser.wait(getWaitTime());
    }
    public void selectCarePlanComplaint() {
    	browser.wait(getWaitTime());
    	Report.updateTestLog("compalints Page ","WARN");
    	verifyAndClickWithXpath(pageProperties.getProperty("Complaints.selectcareplan"), "CarePlan Link");
    	browser.wait(getWaitTime());
    	Report.updateTestLog("CarePlan Page", "WARN");
    }
    public void selectBoilerInstallation() {
    	browser.wait(getWaitTime());
    	Report.updateTestLog("compalints Page ","WARN");
    	verifyAndClickWithXpath(pageProperties.getProperty("Complaints.selectboilerinstallation"), "Boiler Installation Link");
    	browser.wait(getWaitTime());
    	Report.updateTestLog("Boiler Installation Page", "WARN");
    }
    
    
    public void RaiseGasElectComplaint(UserProfile userprofile)
    {
    	browser.wait(getWaitTime());
    	System.out.println("++++++++++++++++++++++++++++++++++++++++");
    	List<String> complaintList = getComplaintList();
    	System.out.println("complaints");
    	int iteration=1;
        for (int i = 1; i<complaintList.size();i++) {
            browser.wait(getWaitTime());
            if(browser.isElementVisible(pageProperties.getProperty("Complaints.SelectComplaintID"))){
            	
            	browser.selectfromDropBox("id", pageProperties.getProperty("Complaints.SelectComplaintID"), complaintList.get(i));
            	browser.wait(getWaitTime());
            	Report.updateTestLog("*********** Iteration : '" + iteration + "' selected ***********", "Done");
            	
            	SubmitForm(userprofile);  
            	GoBacktoComplaintpage();
            	selectGasandEelctComplaint();
            	iteration=iteration+1;
            }
        }    	
    }
    
    private List<String> getComplaintList() {
    	System.out.println("************************************");
        return browser.getFromDropBox("id", pageProperties.getProperty("Complaints.SelectComplaintID"));
        
    }
    
    private void SubmitForm(UserProfile userprofile) {
    	
    	//verifyAndSelectDropDownBox(pageProperties.getProperty("Complaints.title"),"Title", userprofile.getTitle());
    	browser.selectfromDropBox("id", pageProperties.getProperty("Complaints.title"), userprofile.getTitle());
   /* 	verifyAndInputByXpath(pageProperties.getProperty("Complaints.firstname"), "First Name", userprofile.getFirstName());
    	verifyAndInputByXpath(pageProperties.getProperty("Complaints.surname"), "Sur Name", userprofile.getLastName());
    	verifyAndInputByXpath(pageProperties.getProperty("Complaints.email"), "Email", userprofile.getEmail());
    	verifyAndInputByXpath(pageProperties.getProperty("Complaints.businessname"), "Business Name", userprofile.getbusinessname());
    	verifyAndInputByXpath(pageProperties.getProperty("Complaints.telephonenumber"), "Telephone", userprofile.getPhoneNumber());*/
    	verifyAndInputByXpath(pageProperties.getProperty("Complaints.postcode"), "Posting Code", userprofile.getPostCode());
    	verifyAndClickWithXpath(pageProperties.getProperty("Complaints.findaddress"), "Find address");
    	browser.wait(getWaitTime());
    	/*Select select = new Select(browser.getElementByXpath(pageProperties.getProperty("Complaints.selectaddress")));
		select.selectByIndex(3);*/
    	Select select = new Select(browser.getElementByXpath(pageProperties.getProperty("Complaints.selectaddress")));
		select.selectByIndex(3);
    	/*ArrayList<String> contact = browser.getFromDropBox("id", pageProperties.getProperty("Complaints.selectaddress"));
		verifyAndSelectDropDownBox(pageProperties.getProperty("Complaints.selectaddress"), "Preferred Contact ", contact.get(2));*/
    	
    	
		verifyAndClickWithXpath(pageProperties.getProperty("Complaints.confirmbutton"), "Confirm address");
		verifyAndInputByXpath(pageProperties.getProperty("Complaints.complaintdetail"), "Complaint Detail", "Testing");
		Report.updateTestLog("Enter the details successfully ","WARN");
		verifyAndClickWithXpath(pageProperties.getProperty("Complaints.submitbutton"), "submit button");
		browser.wait(getWaitTime());
            }
    public void GoBacktoComplaintpage() {
    	browser.wait(getWaitTime());
    	Report.updateTestLog("Compalints Register Confirmation Page ","WARN");
    	verifyAndClickWithXpath(pageProperties.getProperty("Complaints.backtocomplaints"), "Back to Complaints Link");
    	browser.wait(getWaitTime());
    }
    
    public void selectquery() {
    	browser.wait(getWaitTime());
    	Report.updateTestLog("compalints Page ","WARN");
    	//verifyAndClickWithXpath(pageProperties.getProperty("Complaints.gotquery"), "I've got a query Link");
    	verifyAndClickWithXpath(pageProperties.getProperty("Complaints.gotquerynew"), "I've got a query Link");
    	browser.wait(getWaitTime());
    	Report.updateTestLog("I've got Query Page", "WARN");
    }
	

}
