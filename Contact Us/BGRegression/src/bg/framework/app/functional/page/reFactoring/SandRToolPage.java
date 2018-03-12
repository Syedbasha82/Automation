package bg.framework.app.functional.page.reFactoring;

import java.util.Properties;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.RobotSendKeys;
import bg.framework.app.functional.page.common.BasePage;

public class SandRToolPage extends BasePage implements Runnable{
	private final static String FILE_NAME = "resources/ReFactoring/SandRTool.properties";
	private static Properties PageProperties = new PropertyLoader(FILE_NAME).load();
	Thread th = new Thread(this);
	
	public void selectQuoteStatus(){
		
		th.start();
		
		System.out.println("2222222222222222222222222222");
		System.out.println("In Functio");
		browser.open("http://10.221.30.51:1349/");
		
		
		
		browser.wait(5000);
		//th.stop();
		verifyAndSelectDropDownBox(PageProperties.getProperty("SR.quoteStatus"), "Quote status", "Accepted");
		enterDates();
	}
	@Override
	public void run()
	{
		System.out.println("thread start");
    try {
    	
		System.out.println("thread start");		
		System.out.println("1111111111111111111111111111");
		Thread.sleep(70000);
			RobotSendKeys robot = new RobotSendKeys();
			robot.typeenter();
			System.out.println("End");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	/*public void startThread(){
		Thread th = new Thread(this);
		th.start();
		try {
			th.sleep(5000);
			System.out.println("1111111111111111111111111111");
			RobotSendKeys robot = new RobotSendKeys();
			robot.typeenter();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	public void enterDates(){
		verifyAndClickWithXpath(PageProperties.getProperty("SR.startDate"),"Start Date");
		//verifyAndClickWithXpath(PageProperties.getProperty("SR.startDateSelect"),"Select Start date");
		verifyAndClickWithLinkText(PageProperties.getProperty("SR.startDateLink"), "Start Date link");
		verifyAndClickWithXpath(PageProperties.getProperty("SR.lastDate"),"Last Date");
		//verifyAndClickWithXpath(PageProperties.getProperty("SR.lastDateSelect"),"Select Last date");
		verifyAndClickWithLinkText(PageProperties.getProperty("SR.lastDateLink"), "Start Date link");
		verifyAndClick(PageProperties.getProperty("SR.searchButton"),"Search Button");
		browser.wait(5000);
	}
	
	public void navigateToSummaryPage(){
		verifyAndClickWithXpath(PageProperties.getProperty("SR.detailsPage"),"Details page is clicked");
		browser.wait(5000);
	}
	
	public void navigateToWaitAdvicePage(){
		verifyAndClickWithXpath(PageProperties.getProperty("SR.waitAdviceButton"),"Wait Advice Button is clicked");
		browser.wait(5000);
		enterDetailsInWaitPage();
	}
	
	public void enterDetailsInWaitPage(){
		verifyAndClick(PageProperties.getProperty("SR.callDate"),"Call Date");
		verifyAndClickWithXpath(PageProperties.getProperty("SR.callDateSelect"),"Select call date");
		verifyAndSelectDropDownBox(PageProperties.getProperty("SR.callTime"), "Time To Call Back", "12:00 to 14:00");
		verifyAndInputById(PageProperties.getProperty("SR.commentPage"), "Comment Page", "Aware of Dogs");
		verifyAndClickWithXpath(PageProperties.getProperty("SR.saveButton"), "Save Button");
	}
	
	public void navigateToScheduledPage(){
		verifyAndClickWithXpath(PageProperties.getProperty("SR.scheduledPage"),"Scheduled Page");
		verifyAndInputById(PageProperties.getProperty("SR.wmisJobReference"), "Wmis Job Reference Number", "1523678958");
		verifyAndInputById(PageProperties.getProperty("SR.allocatedEngineer"), "Allocated Engineer", "1523675");
		verifyAndInputById(PageProperties.getProperty("SR.materialsComment"), "Materials Comment", "Flexible");
		verifyAndClickWithXpath(PageProperties.getProperty("SR.submitButton"),"Submit Button");
	}
}
