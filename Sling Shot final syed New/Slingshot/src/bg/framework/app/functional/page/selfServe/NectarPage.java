package bg.framework.app.functional.page.selfServe;

import bg.framework.app.functional.page.common.BasePage;



import org.openqa.selenium.WebDriver;
import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import java.util.Properties;

import org.apache.xalan.lib.Redirect;


public class NectarPage extends BasePage{
	
	private final static String FILE_NAME = "resources/selfServe/NectarPage.properties";
	private static final WebDriver NULL = null;
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	
	public void navigateToProductAndServices(){
		browser.wait(getWaitTime());
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("NectarPage.NavigateToProductAndServices"))){
			verifyAndClickWithXpath(pageProperties.getProperty("NectarPage.NavigateToProductAndServices"), "Navigate to Product & Services Page");
			Report.updateTestLog("Product and Services link clicked successfully", "Pass");
		}
		
	}
	
	public void navigateToNectarPointsPage(){
		browser.wait(getWaitTime());
		if(browser.isElementVisibleWithClass(pageProperties.getProperty("NectarPage.NavigateToNectarPointsPage"))){
			verifyAndClickWithClass(pageProperties.getProperty("NectarPage.NavigateToNectarPointsPage"), "Navigate To Nectar Points Page");
			Report.updateTestLog("Navigated to Nectar Points Page successfully", "Pass");
		}
	}
	
	public void navigateToRegisterPage(){
		browser.deleteAllCookies();
		//browser.deleteAllCookies();
		browser.wait(getWaitTime());
		verifyAndClickWithXpath(pageProperties.getProperty("NectarPage.NavigateToRegisterPage1"), "Navigate To Nectar Registration Page");
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("NectarPage.NavigateToRegisterPage2"))){
			verifyAndClickWithXpath(pageProperties.getProperty("NectarPage.NavigateToRegisterPage2"), "Navigate To Nectar Registration Page");
			Report.updateTestLog("Register Page link clicked successfully", "Pass");
		}
	}

	public void fillRegisterDetails(String CRN){
		int Flag= 1;
		while(Flag<3){
			
		browser.wait(getWaitTime());
		verifyAndInputById(pageProperties.getProperty("NectarPage.CRN"), "Input Customer Reference Number", CRN);
		verifyAndSelectDropDownBox(pageProperties.getProperty("NectarPage.Title"), "Select Title", "Mr");
		verifyAndInputById(pageProperties.getProperty("NectarPage.FirstName"), "Input First Name", "Kelly");
		verifyAndInputById(pageProperties.getProperty("NectarPage.SurName"), "Input SurName", "Simpson");
		verifyAndInputById(pageProperties.getProperty("NectarPage.Email"), "Input Email", "kelly12@bgdigitaltest.co.uk");
		verifyAndInputById(pageProperties.getProperty("NectarPage.Phone"), "Input Phone", "01234567890");
		verifyAndInputById(pageProperties.getProperty("NectarPage.NectarCardNumber"), "Input NectarCardNumber", "11111111111");
		if(Flag == 2){
			verifyAndSelectCheckBox(pageProperties.getProperty("NectarPage.AcceptTerms"), "Select the Terms and Conditions");
		}
		verifyAndClickWithXpath(pageProperties.getProperty("NectarPage.Submit"), "Submit details");
		Flag = Flag+1;
	  }
	}
	
	public void verifyLeadWithDB(){
		OnlineDBConnector oldbc = new OnlineDBConnector();
		String sysDate = oldbc.DBsysdate();
		//Report.updateTestLog(oldbc.getLeadTypeNectar(), "Pass");
		if (oldbc.getLeadTypeNectar().contains("Registration")){
			Report.updateTestLog("Lead Type verified", "Pass");
		}
		
		if(oldbc.getLeadData(sysDate).contains("Nectar")){
			Report.updateTestLog("Lead Data verified", "Pass");
		}
		
		if (oldbc.getLeadStatusNectar() == "0"){
			Report.updateTestLog("Lead Status verified", "Pass");
		}
		}
			
	public void navigateToUpdateNectarCard(){
		browser.wait(getWaitTime());
		if(browser.isTextPresent(pageProperties.getProperty("NectarPage.UpdateNectarCard"))){
			verifyAndClickWithLinkText(pageProperties.getProperty("NectarPage.UpdateNectarCard"), "Update Your Nectar Card ");
			Report.updateTestLog("Update Nectar Card Link Clicked Successfully", "Pass");
		}
		
	}
	
	public void updateNectarCardNumber(){
		browser.wait(getWaitTime());
		verifyAndInputById(pageProperties.getProperty("NectarPage.NectarCardNumber"), "Update Nectar Card Number", "11111111111");
		verifyAndClickWithXpath(pageProperties.getProperty("NectarPage.UpdateCard"), "Submit Updated Nectar Card");
	}
	
	public void navigateToYourPointsPage(){
		browser.wait(getWaitTime());
		if(browser.isTextPresent("Your Nectar points")){
			verifyAndClickWithXpath(pageProperties.getProperty("NectarPage.YourPointsPage"), "Navigate To Your Points Page");
			Report.updateTestLog("Navigated to your points page successfully", "Pass");
		}
	}
	
	public void navigateToPreOamRegistration(String Email){
	
	//	browser.open(ApplicationConfig.APP_BG_URL+"Registration/Loyalty-Registration/Key/RcnFzUWQrN2QrZ21DTTljMWVJbHAwQT09fCN8NjA0MjYxNjkwR/Name/Brown/Email/"+Email+"/Batch/true/loyalty/true");
	//  browser.open("https://10.224.70.111/Registration/Loyalty-Registration/Key/RZzRDZHcweG1DSGdicHk2aXVyRW50QT09fCN8MTgwOTc5NTUyOQ%3D%3DR/Name/Brown/Email/vinothkumargurunathan@cognizant.com/Batch/true/loyalty/true");
		browser.open("https://10.224.70.111/Registration/Loyalty-Registration/Key/RRUZOUjhSaGtNNXp1RVo2Z2JHd1JIUT09fCN8MTY2MzAwMTEzMw%3D%3DR/Name/Stanley/Email/reg_ddvddji@bgdigitaltest.co.uk/Batch/true/loyalty/true");
	}
	
	public void navigateToRegistrationPage(){
		browser.wait(getWaitTime());
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("NectarPage.RegisterNow"))){
			verifyAndClickWithXpath(pageProperties.getProperty("NectarPage.RegisterNow"), "Navigate To Register Now");
		}
	}
	
	public void getNectarCard(){
		browser.wait(getWaitTime());
		verifyAndClickWithXpath(pageProperties.getProperty("NectarPage.NewCard"), "Select New Card From Radio button");
		verifyAndSelectCheckBoxByID(pageProperties.getProperty("NectarPage.TermsandConditions"), "Select Terms and Conditions");
		verifyAndClickWithXpath(pageProperties.getProperty("NectarPage.Join"), "Click the join button");
	}
	
	public void logout(){
		if(browser.isTextPresent("Log out")){
			verifyAndClickWithLinkText(pageProperties.getProperty("NectarPage.Logout"), "Logout");
			Report.updateTestLog("Logout Successful", "Pass");
		}
	}
	
	public void navigateToPointsHistoryPage()
	{
		if(browser.isTextPresent("Points history"))
		{
			verifyAndClickWithLinkText(pageProperties.getProperty("NectarPage.PointsHistory"), "Navigate to points history page");
			Report.updateTestLog("Navigate to Nectar Dashboard Successful", "Pass");
			browser.wait(3000);
		}
	}
	
	public void verifyNectarPointsPage(){
		if(browser.isTextPresent("Add a Nectar card") && browser.isTextPresent("There is no Nectar card associated with this rewards account")
				&& browser.isTextPresent("Points collected with British Gas") && browser.isTextPresent("Accounts linked to this Nectar card"))
		{
	//		verifyAndClickWithClass(pageProperties.getProperty("NectarPage.AdditionalInformation"), "Additional Information for Nectar");
			Report.updateTestLog("dd a Nectar page Verified Successful", "Pass");
		}
	}
	
	public void addNectarCard(){
		verifyAndClickWithLinkText(pageProperties.getProperty("NectarPage.AddNectarCard"), "Add a Nectar Card");
		verifyAndInputById(pageProperties.getProperty("NectarPage.AddNectarNumber"), "Add Nectar Number", "1111111111");
		verifyAndClickWithXpath(pageProperties.getProperty("NectarPage.SubmitAddNectarNumber"), "Submit a new nectar number");
	}
	
	public void enterAccountInformation(String lastname,String postcode)
	{
		browser.wait(3000);
		verifyAndInputById(pageProperties.getProperty("NectarPage.RegisterLastName"), "Enter Last Name", lastname);
		verifyAndInputById(pageProperties.getProperty("NectarPage.RegisterPostCode"), "Enter Postal Code", postcode);
		verifyAndClickWithXpath(pageProperties.getProperty("NectarPage.RegisterContinue"), "Submit Register information");
	}
	
	public void verifyYourPointsPage(){
		browser.wait(getWaitTime());
		if(browser.isTextPresent("Your Nectar points")){
			verifyIsElementVisibleWithXpath("html/body/div[1]/div/div[3]/div/form/div/div/div/div[3]/div[3]/div/div/div/div/div[2]/div[2]/div[1]/div[2]", "0");
				
			
		}
	}
	
	public void verifyNectarRegister(){
		if(browser.isTextPresent("Your Nectar card is on it's way")){
			Report.updateTestLog("Nectar Registration Successful", "Pass");
		}
	}
	
	public void verifyNonRegister(){
		if(!browser.isTextPresent("Your Nectar card is on it's way")){
			Report.updateTestLog("Nectar Cannot be registered for foreign address verified", "Pass");
		}

	}
}
