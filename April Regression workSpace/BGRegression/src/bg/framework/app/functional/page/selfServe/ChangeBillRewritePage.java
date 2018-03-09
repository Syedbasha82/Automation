package bg.framework.app.functional.page.selfServe;

import java.util.Properties;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class ChangeBillRewritePage extends BasePage {
	 private final static String FILE_NAME = "resources/selfServe/ChangeBillRewrite.properties";
	    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    
	public void changeDate(UserProfile userProfile){
		browser.wait(500);
		verifyAndClickWithXpath(pageProperties.getProperty("ChangeBill.ChangeBillLink"),"Change bill date link");
		browser.wait(10000);
		verifyAndSelectDropDownBox(pageProperties.getProperty("ChangeBill.ChangeBillDropdown"), "Dropdown box",userProfile.getDate());
		verifyAndClickWithXpath(pageProperties.getProperty("ChangeBill.Submit"),"Submit button");
		browser.wait(1000);
		if(browser.isTextPresent("You have changed your billing"))
		{
		Report.updateTestLog("Bill date changed successfully", "PASS");
		}
		else
		{
			Report.updateTestLog("Error occured", "FAIL");
		}
		verifyAndClickWithXpath(pageProperties.getProperty("ChangeBill.ReturntoAcc"),"Return to your account link");
	}
	

	public void dateVerification(UserProfile userProfile){
		String date = browser.getTextByXpath(pageProperties.getProperty("ChangeBill.NewDate"));
		if(date.contains(userProfile.getDate()))	
		{
			Report.updateTestLog("Bill date updated successfully","PASS");
		}
		else
		{
			Report.updateTestLog("Bill date updation failed","Fail");
		}
	}
}

