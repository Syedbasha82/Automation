package bg.framework.app.functional.page.Slingshot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import bg.framework.app.functional.entities.DirectDebit;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.RobotSendKeys;
import bg.framework.app.functional.util.RunQTP;
import bg.framework.app.functional.page.common.SlingshotErrorMessages;
//
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.thoughtworks.selenium.*;

import org.openqa.selenium.By;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class ThankYouPage extends BasePage{
    
	private final static String FILE_NAME = "resources/Slingshot/Survey.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
    String timestamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	public void selectFeedbackOption(String option){
	 String feedbackOption=pageProperties.getProperty("ThankyouPage.FeedbackOption"); 	
	 System.out.println("Option value:"+feedbackOption+option+"']");
	 verifyAndClickWithXpath(feedbackOption+option+"']", "Radio button");		 
	}
	public void  feedbackReason(String reason){
		System.out.println("Reason :"+pageProperties.getProperty("ThankyouPage.FeedbackReason"));
		verifyAndInputById(pageProperties.getProperty("ThankyouPage.FeedbackReason"), "FeedbackReason",reason+timestamp);
	}
	public void clickFeedbackSendButton(){
		 
		 verifyAndClick(pageProperties.getProperty("ThankyouPage.FeedbackSend"),"Send button");		 
	}
	
	public void verifySurveyTableInDb(String emailid,String surveytype,String option,String surveytext){
	browser.wait(2000);	
	String[] surveydata=new OnlineDBConnector().getSurveyInfo(emailid,surveytype);
	 if(surveydata!=null){
		try{
			Report.updateTestLog("Expected Result: "+option+" Actual Result: "+surveydata[0],surveydata[0].equals(option)?"Pass":"Fail");
			Report.updateTestLog("Expected Result: "+surveytext+timestamp+" Actual Result: "+surveydata[1],surveydata[1].equals(surveytext+timestamp)?"Pass":"Fail");
		}catch(Exception e){
			Report.updateTestLog("Exception occured while fetching surveytable value"+e,"Fail");
		}
	  }
	
    }
	public void clickNpsFeedbackImage(){
		verifyAndClickWithXpath(pageProperties.getProperty("NPS.FeedbackImage"),"NPSFeedBack Image");
		getWaitTime();
		getWaitTime();
	}
	public void selectNpsFeedbackOption(String option){
		
	 String feedbackOption=pageProperties.getProperty("NPS.FeedbackOption"); 	
	 System.out.println("Option value:"+feedbackOption+option+"']");
	 verifyAndClickWithXpath(feedbackOption+option+"']", "Radio button");
	 
	}
	public void selectNpsFeedbackText(String reason){
		
		System.out.println("Reason :"+pageProperties.getProperty("NPS.FeedbackText"));
		verifyAndInputById(pageProperties.getProperty("NPS.FeedbackText"), "FeedbackReason",reason+timestamp);	
	}
	public void submitNpsSurvey(){
		
		verifyAndClick(pageProperties.getProperty("NPS.FeedbackSubmitButton"), "NpsSubmit button");
	}
	public void closeNpsSurveyOverlay(){
		
//		verifyAndClickWithXpath(pageProperties.getProperty("NPS.FeedbackCloseButton"),"Nps Close overlay");

		if(browser.isElementVisible(pageProperties.getProperty("NPS.FeedbackText"))){
		  RobotSendKeys.typeEsc();	
		}
		RobotSendKeys.typeEsc();
	}
    public void verifyNpsSurveySubmitted(){
		
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("NPS.FeedbackOption"))||browser.isElementVisibleWithXpath
				(pageProperties.getProperty("NPS.FeedbackText"))){
			Report.updateTestLog("Nps survey is not submitted succesfully", "Fail");		   	
		}else{
			Report.updateTestLog("Nps survey submitted succesfully", "Pass");
		}
	}
    
    public void closeThankYouOverlay(){
 		RobotSendKeys.typeenter();
 		
 	}
}
