package bg.framework.app.functional.page.selfServe;

import bg.framework.app.functional.common.ApplicationConfig;





import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.util.OnlineDBConnector;
//import java.awt.Robot;

import java.util.Properties;

public class OpenMeterReadPage extends BasePage{

	 private final static String FILE_NAME = "resources/selfServe/OpenMeterRead.properties";
	    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	   
	public void navigatetoLoginSSO(){
		browser.wait(getWaitTime());
		verifyAndClickWithXpath(pageProperties.getProperty("OpenMeterRead.NavigateToLogin"), "Navigate to login");
	}
	
	public void loginSSO(UserProfile userProfile) {
		browser.wait(getWaitTime());
		verifyAndInputById(pageProperties.getProperty("OpenMeterRead.Email"), "Email Id", userProfile.getEmail());
		verifyAndInputById(pageProperties.getProperty("OpenMeterRead.Password"), "Password", userProfile.getPassword());
		verifyAndClickWithXpath(pageProperties.getProperty("OpenMeterRead.Login"), "Login");
		continueToMyAccount();
	}
	public void continueToMyAccount() {
		if (browser.isElementVisibleWithXpath(pageProperties.getProperty("LoginPage.WelcomeMessage"))) {
	        Report.updateTestLog("User logged in Successfully", "PASS");
	    }
		else {
			 Report.updateTestLog("User login unsuccessful", "Fail");
		}
	}
	public void navigateToSubmitMeterRead() {
		//
		//if(browser.isElementVisibleWithXpath("//*[@id='mega-menu']/ul/li[4]/a"))
		//{
			//verifyAndClickWithXpath(pageProperties.getProperty("OpenMeterRead.NavigateToSubmitMeterRead"), "Navigate To Submit Meter Read Page");
		//	browser.clickWithXpath(pageProperties.getProperty("OpenMeterRead.NavigateToSubmitMeterRead"));
		//}
			browser.wait(getWaitTime());
			browser.open(ApplicationConfig.APP_BG_URL+"youraccount/discover/submit-meter-reading.html");
			
	}
	
	public void navigateToSubmitOpenReading()
	{
		browser.wait(getWaitTime());
		verifyAndClickWithXpath(pageProperties.getProperty("OpenMeterRead.NavigateToSubmitOpenReading"), "Submit Open MeterReading");	
	}
	
	
	
	public void fillGasMeterRead() {
		browser.wait(getWaitTime());
		verifyAndInputById(pageProperties.getProperty("OpenMeterRead.GasMeterPointNumber"),"Gas Meter Point Number", "4267306503");
		verifyAndClickWithXpath(pageProperties.getProperty("OpenMeterRead.SubmitGasPointNumber"), "Submit Gas Point Number");
		browser.wait(getWaitTime());
		verifyAndInputById(pageProperties.getProperty("OpenMeterRead.EnterGasRead"), "Enter Gas Read", "2333");
		verifyAndClickWithXpath(pageProperties.getProperty("OpenMeterRead.SubmitGasRead"), "Submit Gas Read");
	}
	
	public void verifyWithOnlineDB(UserProfile userProfile) {
		String sysDate = new OnlineDBConnector().DBsysdate();
		//Report.updateTestLog(sysDate, "Fail");
		String AuditDetails = new OnlineDBConnector().verifyAuditDetailsEntryDB(userProfile.getEmail(),sysDate );
		String Entry1 = "OPEN_METER_READ_SUCCESS";
				
			if(AuditDetails.contains(Entry1))
			{
				Report.updateTestLog("Audit details updated in DB", "Pass");
			}
			else {
				Report.updateTestLog("Audit details not updated in DB", "Fail");
			}	
	
	}
	
	public void logout()
	{
		browser.wait(getWaitTime());
		verifyAndClickWithXpath(pageProperties.getProperty("OpenMeterRead.Logout"), "Logout");
	}
	
	
}