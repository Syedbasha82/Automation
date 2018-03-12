package bg.framework.app.functional.page.Slingshot_Broker;

import bg.framework.app.functional.page.common.BasePage;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.util.Properties;
import org.joda.time.DateTime;
import com.gnostice.pdfone.PdfDocument;
import com.gnostice.pdfone.PdfReader;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.SMRAccountDetails;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.SlingshotErrorMessages;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.RobotSendKeys;

public class ViewBillPartnerPage extends BasePage {

	DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
    Calendar cal=Calendar.getInstance();
    
    SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyy");
	private final static String FILE_NAME = "resources/Slingshot_Broker/ViewBillPartner.Properties";	    
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	SlingshotErrorMessages errormsg = new SlingshotErrorMessages();
	
	public void navigateToPartnerLogin() {
		if(browser.isElementVisible(pageProperties.getProperty("Viewbillpartner.Logout"))) {
			browser.click(pageProperties.getProperty("Viewbillpartner.Logout"));
			browser.wait(getWaitTime());
			browser.open(ApplicationConfig.APP_BG_URL);
		}
		System.out.println("login usrl ApplicationConfig.APP_BG_URL:"+ApplicationConfig.APP_BG_URL+"pageProperties.getPropertyViewbillpartner.PartnerLink:"+
				pageProperties.getProperty("Viewbillpartner.PartnerLink"));
		browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("Viewbillpartner.PartnerLink"));
		browser.wait(getWaitTime());

	}
	public void PartnerloginDetails(SMRAccountDetails smrProfile){
		verifyAndInputById(pageProperties.getProperty("Viewbillpartner.Email"), "Email Id", smrProfile.getEmail());	
		verifyAndInputById(pageProperties.getProperty("Viewbillpartner.Password"), "Password", smrProfile.getPassword());
		verifyAndClickWithXpath(pageProperties.getProperty("Viewbillpartner.Submit"), "Submit button");
		browser.wait(getWaitTime());
	}
	public void verifyPageTitle(){
		browser.wait(getWaitTime());
		verifyPageTitle("View customer bills");
		verifyIsTextPresent("View customer bills");
	}
	
	public void selectTerm(String Accountnumber){
		try{
		    verifyAndSelectDropDownBox(pageProperties.getProperty("Viewbillpartner.SearchKey"),"Search Dropdown", Accountnumber);
		}catch(Exception e){
			Report.updateTestLog("Error selecting value in the select term drop down"+e, "Fail");
		}
	}
	public void enterSearchCriteria(String SearchCriteria){
		
		verifyAndInputById(pageProperties.getProperty("Viewbillpartner.SearchCriteria"), "Search Criteria", SearchCriteria);
		}
	
	public void enterFromDate(String FromDate){

		int days=DateTime.now().getDayOfMonth();
		String day=Integer.toString(days);
		System.out.println("joda day is:"+day);
//		int d=cal.add(Calendar.MONTH,-3);
		if(FromDate.equalsIgnoreCase("3")){
           cal.add(Calendar.MONTH,-3);
		}else{
			
		}
		verifyAndClickWithXpath(pageProperties.getProperty("Viewbillpartner.FromDate"), "FromDate");
		for(int i=1;i<4;i++){
			verifyAndClickWithXpath(pageProperties.getProperty("Viewbillpartner.PreviousDatePicker"), "PreviousDatePicker");
			browser.wait(500);
		}
//		verifyAndClickWithXpath(pageProperties.getProperty("SearchBill.PreviousDate"), "3 Months date");
		String result=calenderDate(day);
		if(result.equals("False")){
		   verifyAndClickWithXpath(pageProperties.getProperty("Viewbillpartner.NextDatePicker"), "NextDatePicker");	
		   calenderDate(day);
		}
		
	}
	 public void enterToDate(String ToDate){
			Calendar cal=Calendar.getInstance();
			int currentday=cal.get(Calendar.DATE);		
			verifyAndClickWithXpath(pageProperties.getProperty("Viewbillpartner.ToDate"),"Todate");
//			browser.clickWithXpath("//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[2]/a");
			verifyAndClickWithXpath(pageProperties.getProperty("Viewbillpartner.TodaysDate")+currentday+"')]", "TodaysDate");		
		}
	public String calenderDate(String day){
		String result="False";
		int rowcount=browser.getRowCountByXpath(pageProperties.getProperty("Viewbillpartner.CalenderTable"));
		int columncount=browser.getColCountByXpath(pageProperties.getProperty("Viewbillpartner.CalenderTable"));
		System.out.println("rowcount:"+rowcount);
		System.out.println("columncount:"+columncount);
		for(int i=1;i<=rowcount;i++){
			for(int j=1;j<=columncount;j++){
				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Viewbillpartner.CalenderTable")+"//tr["+i+"]/td["+j+"]"+
						"[contains(@class,'disabled')]")){
					System.out.println("empty xpath is");
				}else{
					if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Viewbillpartner.CalenderTable")+"//tr["+i+"]/td["+j+"]/a")){						
					String dateThreeMonths=browser.getTextByXpath(pageProperties.getProperty("Viewbillpartner.CalenderTable")+"//tr["+i+"]/td["+j+"]/a");
					if(dateThreeMonths.equals(day)){
						Report.updateTestLog("Day is matched:"+day,"pass");
						browser.clickWithXpath(pageProperties.getProperty("Viewbillpartner.CalenderTable")+"//tr["+i+"]/td["+j+"]/a");
						result="True";
						break;
					}
				 }
				}
			}
			
		}
		return result;
	}
	public void clickSearchBillSearchButton(){
			verifyAndClick(pageProperties.getProperty("Viewbillpartner.SearchButton"), "SearchButton");
		}
	 public void verifyBillTable(){
		   if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Viewbillpartner.Table"))){
			   Report.updateTestLog("Bill displayed in the table", "Pass");
			   int rowcount=browser.getRowCountByXpath(pageProperties.getProperty("Viewbillpartner.Table"));
			   int columncount=browser.getColCountByXpath(pageProperties.getProperty("Viewbillpartner.Table"));
			   Report.updateTestLog("Number of rows displayed in the table is :"+rowcount+"Number of Columns displayed" +
			   		"in the table :"+columncount, "Done");		   
		   }else{
			   Report.updateTestLog("Bill not displayed in the table", "Fail");
		   }
		   
	   }
	 public void selectCheckboxDownload(){
		   String checkbox=pageProperties.getProperty("Viewbillpartner.TableData").replace("Row", "1").replace("Column", "7")+"/p/input";
		   verifyAndSelectCheckBoxByXpath(checkbox, "Checkbox");
	   }
	 public void clickSearchBillDownload(){	 
		 	browser.wait(5000);	
		    verifyAndClick(pageProperties.getProperty("Viewbillpartner.downloadBtn"), "Download");
			browser.wait(10000);	
	   }
	 public void saveFile() {
		  RobotSendKeys.downArrow();
		  RobotSendKeys.altS();
		  RobotSendKeys.altS();
		  RobotSendKeys.typeenter();
		  browser.wait(10000);
	 }
	 public void openAndVerifyZipFile() throws ParseException{
		   File folderExisting = new File(pageProperties.getProperty("Viewbillpartner.DownLoadFolder")); 
	       if (folderExisting.exists()){ 
	    	   Report.updateTestLog("Download folder exist", "DONE");
	    	   try{
	    	   File[] listOfFiles = folderExisting.listFiles();  
	    	   System.out.println(Arrays.asList(listOfFiles));
	    	   for(int i =0; i<listOfFiles.length; i++){
	    		   System.out.println("listOfFiles.length "+listOfFiles.length);
	    		   if(listOfFiles[i].getName().contains(pageProperties.getProperty("Viewbillpartner.DownLoadZipFile"))){
	    			   System.out.println("Folder contains zip file");
	    			   Report.updateTestLog("Download folder contains the "+pageProperties.getProperty("Viewbillpartner.DownLoadZipFile")+" file", "PASS");
	    		   }    		   
	    	   } 
	    	   }
	    	   catch(Exception e){
	    		   Report.updateTestLog("Exception occured "+e, "FAIL");
	    	   }
	       }
	       else{
	    	   Report.updateTestLog("File does not exist in specified folder"+ pageProperties.getProperty("Viewbillpartner.DownLoadFolder"), "FAIL");
	       }
	       
	   }
	public void deleteFile() { 
		 File folderExisting1 = new File(pageProperties.getProperty("Viewbillpartner.DownLoadZipFilepath")); 
		 folderExisting1.delete();
		 
	}
	
	}


