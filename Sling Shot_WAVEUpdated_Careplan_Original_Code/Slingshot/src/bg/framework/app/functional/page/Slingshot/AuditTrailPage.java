/**
 * 
 */
package bg.framework.app.functional.page.Slingshot;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.SlingshotErrorMessages;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.RobotSendKeys;

/**
 * @author sundarg1
 *
 */
public class AuditTrailPage extends BasePage {
	private final static String File_AuditPage = "resources/Slingshot/AuditDetailsPage.properties";
	private static Properties auditPageProperties = new PropertyLoader(File_AuditPage).load();
	OnlineDBConnector dbfunctions = new OnlineDBConnector();
	public void verifyAuditTrailDetailsEmail(UserProfile userProfile){	
		
			if(browser.isTextPresent(auditPageProperties.getProperty("AuditDetailsPage.AuditPageHeader"))){
				verifyAndInputByXpath(auditPageProperties.getProperty("AuditDetailsPage.EmailField"), "Email id", userProfile.getEmail());
				verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditEndDateCalender"), "End Date picker");
				DateFormat dateformat = new SimpleDateFormat();
				Date date= new Date();
				Calendar cal = Calendar.getInstance();
				System.out.println("cal"+cal.getInstance().getTime());
				System.out.println("date"+date.getDate());
				int currentDate = date.getDate(); 
				verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.CurrentDate")+currentDate+"')]", "Current date");
				String endDate = browser.getAttributeByXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditEndDate"),"value");
				Report.updateTestLog("From date seleted as : "+endDate, "DONE");
				verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditToDateCalender"), "To Date picker");
				verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.ToDate")+currentDate+"')]", "Start date");
				String startDate = browser.getAttributeByXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditStartDate"),"value");			
				Report.updateTestLog("To date seleted as : "+startDate, "DONE");
				verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.SubmitButton"), "Submit");
				verifyPageTitle("Audit Table");
			}
		}
	public void verifyAuditTrailDetailsBpOrg(UserProfile userProfile){	
		
		if(browser.isTextPresent(auditPageProperties.getProperty("AuditDetailsPage.AuditPageHeader"))){
			verifyAndInputByXpath(auditPageProperties.getProperty("AuditDetailsPage.BPNumber"), "Bp Org Number", userProfile.getBpnumber());
			verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditEndDateCalender"), "End Date picker");
			DateFormat dateformat = new SimpleDateFormat();
			Date date= new Date();
			Calendar cal = Calendar.getInstance();
			System.out.println("cal"+cal.getInstance().getTime());
			System.out.println("date"+date.getDate());
			int currentDate = date.getDate(); 
			verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.CurrentDate")+currentDate+"')]", "Current date");
			String endDate = browser.getAttributeByXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditEndDate"),"value");
			Report.updateTestLog("From date seleted as : "+endDate, "DONE");
			verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditToDateCalender"), "To Date picker");
			verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.ToDate")+currentDate+"')]", "Start date");
			String startDate = browser.getAttributeByXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditStartDate"),"value");			
			Report.updateTestLog("To date seleted as : "+startDate, "DONE");
			verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.SubmitButton"), "Submit");
			verifyPageTitle("Audit Table");
		}
	}
public void verifyDateRangeValue(UserProfile userProfile){	
		
		if(browser.isTextPresent(auditPageProperties.getProperty("AuditDetailsPage.AuditPageHeader"))){
			verifyAndInputByXpath(auditPageProperties.getProperty("AuditDetailsPage.BPNumber"), "Bp Org Number", userProfile.getBpnumber());
			verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditEndDateCalender"), "End Date picker");
			DateFormat dateformat = new SimpleDateFormat();
			Date date= new Date();
			Calendar cal = Calendar.getInstance();
			System.out.println("cal"+cal.getInstance().getTime());
			System.out.println("date"+date.getDate());
			int currentDate = date.getDate(); 		
			
			verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.CurrentDate")+currentDate+"')]", "Current date");
			String endDate = browser.getAttributeByXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditEndDate"),"value");
			Report.updateTestLog("From date seleted as : "+endDate, "DONE");
			verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditToDateCalender"), "To Date picker");
			//verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.ToDate")+currentDate+"')]", "Start date");
			verifyAndInputByXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditStartDate"), "Start date", "21/10/2012");
			String startDate = browser.getAttributeByXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditStartDate"),"value");			
			Report.updateTestLog("To date seleted as : "+startDate, "DONE");
			verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.SubmitButton"), "Submit");
			 getErrorMsgLoginscreen(SlingshotErrorMessages.DateRangeMorethan3Months);
			//verifyPageTitle("Audit Table");
		}
	}
	
	public void emailErrorMessageValidation() {
        String[] email = new String[3];
        email[0]="";
        email[1]="qw2w3w3w@bgtest.co.uk";
        email[2]="smartinsight_25@smart@bgtest.co.uk";
        enterInvalidEmail(email[0]);
        getErrorMsgLoginscreen(SlingshotErrorMessages.Audit_EmailEmpty);
        enterInvalidEmail(email[1]);
        getErrorMsgLoginscreen(SlingshotErrorMessages.Audit_EmailNotRegistered);
        enterInvalidEmail(email[2]);
        getErrorMsgLoginscreen(SlingshotErrorMessages.Audit_EmailInccorectFormat);
  }
  public void enterInvalidEmail(String value){
	  try{
       // browser.open("https://10.224.70.18/business/agent/audit-details");
        browser.open(ApplicationConfig.APP_BG_URL+auditPageProperties.getProperty("AuditTrial.AuditPageUrl"));
		browser.wait(getWaitTime());
        verifyAndInputByXpath(auditPageProperties.getProperty("AuditDetailsPage.EmailField"), "Email Id",value);
        verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditEndDateCalender"), "End Date picker");
        DateFormat dateformat = new SimpleDateFormat();
		Date date= new Date();
		Calendar cal = Calendar.getInstance();
		System.out.println("cal"+cal.getInstance().getTime());
		System.out.println("date"+date.getDate());
		int currentDate = date.getDate(); 
		verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.CurrentDate")+currentDate+"')]", "Current date");
		String endDate = browser.getAttributeByXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditEndDate"),"value");
		Report.updateTestLog("From date seleted as : "+endDate, "DONE");
		verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditToDateCalender"), "To Date picker");
		verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.ToDate")+currentDate+"')]", "Start date");
		String startDate = browser.getAttributeByXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditStartDate"),"value");			
		Report.updateTestLog("To date seleted as : "+startDate, "DONE");
		verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.SubmitButton"), "Submit");
	  }
	  catch(Exception e){
		  Report.updateTestLog("Error locating xpath in error msg section :"+e, "Fail");
	  }
  }
  public void getErrorMsgLoginscreen(String emailErrorMessage) {
        try{
        String errormsgvalue=browser.getTextByXpath(auditPageProperties.getProperty("AuditDetailsPage.ErrorMessage"));             
        Report.updateTestLog("Audit Login screen-Error msg Expected Result: "+emailErrorMessage+" Actual Result: "+errormsgvalue,errormsgvalue.contains(emailErrorMessage)?"Pass":"Fail");
        }catch(Exception e){
              Report.updateTestLog("Error locating xpath in error msg section :"+e, "Fail");
        }
              
  }
  public void bpnumberErrorMessageValidation() {
        String[] bpnumber = new String[4];
        bpnumber[0]="";
        bpnumber[1]="9999999999";
        bpnumber[2]="99999999!@";
        bpnumber[3]="99999999ab";
        enterInvalidBpnumber(bpnumber[0]);
        getErrorMsgLoginscreen(SlingshotErrorMessages.Audit_BPEmpty);
        enterInvalidBpnumber(bpnumber[1]);
        getErrorMsgLoginscreen(SlingshotErrorMessages.Audit_BPNotRegistered);
        enterInvalidBpnumber(bpnumber[2]);
        getErrorMsgLoginscreen(SlingshotErrorMessages.Audit_BPInccorectFormat);
        enterInvalidBpnumber(bpnumber[3]);
        getErrorMsgLoginscreen(SlingshotErrorMessages.Audit_BPInccorectFormat);
  }
  public void enterInvalidBpnumber(String value){
        browser.open(ApplicationConfig.APP_BG_URL+auditPageProperties.getProperty("AuditTrial.AuditPageUrl"));
        verifyAndInputByXpath(auditPageProperties.getProperty("AuditDetailsPage.BPNumber"), "Bpnumber",value);
        verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditEndDateCalender"), "End Date picker");
        DateFormat dateformat = new SimpleDateFormat();
		Date date= new Date();
		Calendar cal = Calendar.getInstance();
		System.out.println("cal"+cal.getInstance().getTime());
		System.out.println("date"+date.getDate());
		int currentDate = date.getDate(); 
		verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.CurrentDate")+currentDate+"')]", "Current date");
		String endDate = browser.getAttributeByXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditEndDate"),"value");
		Report.updateTestLog("From date seleted as : "+endDate, "DONE");
		verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditToDateCalender"), "To Date picker");
		verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.ToDate")+currentDate+"')]", "Start date");
		String startDate = browser.getAttributeByXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditStartDate"),"value");			
		Report.updateTestLog("To date seleted as : "+startDate, "DONE");
		verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.SubmitButton"), "Submit");
        getWaitTime();
  }
  
  public void verifyAuditTableUsingEmail(String email){  
	  int i = 0;	 
	  if(browser.isElementVisibleWithXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditTable"))){
		  int auditTrailCount = 0;
		  if(browser.isElementVisibleWithXpath(auditPageProperties.getProperty("AuditDetailsPage.NumberOfRecords"))){
		  String numberOfTransactions = browser.getTextByXpath(auditPageProperties.getProperty("AuditDetailsPage.NumberOfRecords"));
		  //verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditDataAndTimestamp"), "Audit data and time stamp");
		  browser.wait(2000);
		  System.out.println("XPATH:"+auditPageProperties.getProperty("AuditDetailsPage.AuditDataAndTimestamp"));
		  try{
		  browser.clickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditDataAndTimestamp"));
		  }catch(NullPointerException e){
		  browser.clickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditDataAndTimestamp1"));}
		  System.out.println("numberOfTransactions        "+numberOfTransactions);
		  String[] totalTransaction = numberOfTransactions.split("of");
		  String[] itemsPerPage = totalTransaction[0].split("-");
		  String itemsPerPage1 = itemsPerPage[1].trim();
		  int itemsperPage = Integer.parseInt(itemsPerPage1);
		  Report.updateTestLog("Items per page in Audit table is : "+itemsPerPage1, "PASS");
		  totalTransaction = totalTransaction[1].split(" ");
		  System.out.println("totalTransaction[0]     "+totalTransaction[0]+"totalTransaction[1]      "+totalTransaction[1]);
		  String numberOfTransactionsInAuditTable = totalTransaction[1];	
		  auditTrailCount = Integer.parseInt(numberOfTransactionsInAuditTable);
		  Report.updateTestLog("Number of transaction displaying in Audit table is "+totalTransaction[1], "PASS");
		  int dbCount = getAuditDetailsDBUsingEmail(email);	
		  System.out.println("dbCount     "+dbCount);
		  Report.updateTestLog("Number of transactions made in  DB and auditTrail table is same: "+auditTrailCount, (auditTrailCount == dbCount)?"PASS":"FAIL");
		  if(auditTrailCount == dbCount){
			  int paginationCount = 0;
			  try{
			  paginationCount = auditTrailCount/itemsperPage;
			  Report.updateTestLog("Number of pagination available : "+paginationCount,"PASS");}
			  
			  catch(Exception e){
				  
			  }
			  System.out.println(paginationCount);
			  for( i=1;i<=auditTrailCount;i++){
				  if(browser.isElementVisibleWithXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditEventType")+i+"]/td[4]")){
				  String auditType = browser.getTextByXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditEventType")+i+"]/td[4]")  ;
				  //String auditActual = getAudittype(emailid2);
				  String date = dbfunctions.DBsysdateDdmmyy();
					System.out.println("getaudittype.email id is:"+email);
					String[] value=dbfunctions.getAuditEventId(date, email);					
					System.out.println("LIST VALUE ="+value[i-1]);
					String[] value1=value[i-1].split("=");
					value1 = value1[1].split("}");
					String auditTypeDB = dbfunctions.getAuditType(value1[0]);
					System.out.println("auditType"+auditType+"value[1]"+value1[0]);					
				  System.out.println("auditType"+auditType+"auditActualDB"+auditTypeDB);
				  if(auditType.equalsIgnoreCase(auditTypeDB)){
						System.out.println("verification done");
						Report.updateTestLog("Audit Values displaying in DB and Audit table are same."+" AuditTable value: "+auditType+" AuditValue in DB: "+auditTypeDB,"PASS");
					}
					else{
						Report.updateTestLog("Audit Values displaying in DB and Audit table are same."+" AuditTable value: "+auditType+" AuditValue in DB: "+auditTypeDB,"FAIL");
						System.out.println("verification done failed");
					}
			  }
			  
			  else{
				  if(browser.isElementVisibleWithXpath(auditPageProperties.getProperty("AuditDetailsPage.PaginationLink"))){ 
					  browser.clickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.PaginationLink"));
					  Report.updateTestLog("Pagination link clciked and its working fine as expected", "PASS");
				  }
				  else{
					  
				  }
			  }
				  }
			  Report.updateTestLog("Audit table verification is done for "+i+" records.", "PASS");
		  }
		  }
		  else{
			  Report.updateTestLog("There is no transaction made for the search criteria", "FAIL");
		  }
		 
	  }	  
  }
  public void verifyAuditTableUsingBpOrg(String BpNumber){  
	  int i = 0;	 
	  if(browser.isElementVisibleWithXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditTable"))){
		  int auditTrailCount = 0;
		  if(browser.isElementVisibleWithXpath(auditPageProperties.getProperty("AuditDetailsPage.NumberOfRecords"))){
		  String numberOfTransactions = browser.getTextByXpath(auditPageProperties.getProperty("AuditDetailsPage.NumberOfRecords"));
		  //verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditDataAndTimestamp"), "Audit data and time stamp");
		  browser.wait(2000);
		  System.out.println("XPATH:"+auditPageProperties.getProperty("AuditDetailsPage.AuditDataAndTimestamp"));
		  try{
		  browser.clickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditDataAndTimestamp"));
		  }catch(NullPointerException e){
		  browser.clickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditDataAndTimestamp1"));}
		  System.out.println("numberOfTransactions        "+numberOfTransactions);
		  String[] totalTransaction = numberOfTransactions.split("of");
		  String[] itemsPerPage = totalTransaction[0].split("-");
		  String itemsPerPage1 = itemsPerPage[1].trim();
		  int itemsperPage = Integer.parseInt(itemsPerPage1);
		  Report.updateTestLog("Items per page in Audit table is : "+itemsPerPage1, "PASS");
		  totalTransaction = totalTransaction[1].split(" ");
		  System.out.println("totalTransaction[0]     "+totalTransaction[0]+"totalTransaction[1]      "+totalTransaction[1]);
		  String numberOfTransactionsInAuditTable = totalTransaction[1];	
		  auditTrailCount = Integer.parseInt(numberOfTransactionsInAuditTable);
		  Report.updateTestLog("Number of transaction displaying in Audit table is "+totalTransaction[1], "PASS");
		  int dbCount = getAuditDetailsDBUsingBp(BpNumber);	
		  System.out.println("dbCount     "+dbCount);
		  Report.updateTestLog("Number of transactions made in  DB and auditTrail table is same: "+auditTrailCount, (auditTrailCount == dbCount)?"PASS":"FAIL");
		  if(auditTrailCount == dbCount){
			  int paginationCount = 0;
			  try{
			  paginationCount = auditTrailCount/itemsperPage;
			  Report.updateTestLog("Number of pagination available : "+paginationCount,"PASS");}
			  
			  catch(Exception e){
				  
			  }
			  System.out.println(paginationCount);
			  for( i=1;i<=auditTrailCount;i++){
				  if(browser.isElementVisibleWithXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditEventType")+i+"]/td[4]")){
				  String auditType = browser.getTextByXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditEventType")+i+"]/td[4]")  ;
				  //String auditActual = getAudittype(emailid2);
				  String date = dbfunctions.DBsysdateDdmmyy();
					System.out.println("getaudittype.email id is:"+BpNumber);
					String[] value=dbfunctions.getAuditEventIdUsingBp(date, BpNumber);	
					if(value!=null){
					System.out.println("LIST VALUE ="+value[i-1]);
					String[] value1=value[i-1].split("=");
					value1 = value1[1].split("}");
					String auditTypeDB = dbfunctions.getAuditType(value1[0]);
					System.out.println("auditType"+auditType+"value[1]"+value1[0]);					
				  System.out.println("auditType"+auditType+"auditActualDB"+auditTypeDB);
				  if(auditType.equalsIgnoreCase(auditTypeDB)){
						System.out.println("verification done");
						Report.updateTestLog("Audit Values displaying in DB and Audit table are same."+" AuditTable value: "+auditType+" AuditValue in DB: "+auditTypeDB,"PASS");
					}
					else{
						Report.updateTestLog("Audit Values displaying in DB and Audit table are same."+" AuditTable value: "+auditType+" AuditValue in DB: "+auditTypeDB,"FAIL");
						System.out.println("verification done failed");
					}}
			  }
			  
			  else{
				  if(browser.isElementVisibleWithXpath(auditPageProperties.getProperty("AuditDetailsPage.PaginationLink"))){ 
					  browser.clickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.PaginationLink"));
					  Report.updateTestLog("Pagination link clciked and its working fine as expected", "PASS");
				  }
				  else{
					  
				  }
			  }
				  }
			  Report.updateTestLog("Audit table verification is done for "+i+" records.", "PASS");
		  }
		  }
		  else{
			  Report.updateTestLog("There is no transaction made for the search criteria", "FAIL");
		  }
		 
	  }	  
  }
	public void openViewAuditTrailPage(){
		System.out.println(ApplicationConfig.APP_BG_URL+auditPageProperties.getProperty("AuditDetailsPage.Url"));
		browser.open(ApplicationConfig.APP_BG_URL+auditPageProperties.getProperty("AuditDetailsPage.Url"));
		browser.wait(getWaitTime());
		if(browser.isElementVisibleWithXpath(auditPageProperties.getProperty("AuditDetailsPage.ViewAuditTrailLink"))){
		verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.ViewAuditTrailLink"),"View audit trail");
		verifyPageTitle(auditPageProperties.getProperty("AuditDetailsPage.AuditPageTitle"));
		}
		else{
			Report.updateTestLog("Please check view audit trail link", "FAIL");
		}
	}
	public int getAuditDetailsDBUsingEmail(String email){
		//String date = dbfunctions.DBsysdate();
		String date = dbfunctions.DBsysdateDdmmyy();
		int dbCount = dbfunctions.getAuditCountUsingEmail(email, date);
		System.out.println("dbCount   "+dbCount);
		
		return dbCount;
	}
	public int getAuditDetailsDBUsingBp(String BpNumber){
		//String date = dbfunctions.DBsysdate();
		String date = dbfunctions.DBsysdateDdmmyy();
		int dbCount = dbfunctions.getAuditCountUsingBp(BpNumber, date);
		System.out.println("dbCount   "+dbCount);
		
		return dbCount;
	}
	public String getAudittype(String email){
		
		String auditType=null;
		
		return auditType;
	}
	public void checkForFutureDateSelection(){
		verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditEndDateCalender"), "End Date picker");
		DateFormat dateformat = new SimpleDateFormat();
		Date date= new Date();
		Calendar cal = Calendar.getInstance();
		System.out.println("cal"+cal.getInstance().getTime());
		System.out.println("date"+date.getDate());
		int currentDate = date.getDate(); 
		if(!browser.isElementVisibleWithXpath(auditPageProperties.getProperty("AuditDetailsPage.CurrentDate")+(currentDate+1)+"')]")){
			Report.updateTestLog("Future dates are not able to select in start start field", "PASS");
		}
		else
		{
			Report.updateTestLog("Future dates are not able to select in start start field", "FAIL");
		}
		verifyAndClickWithXpath(auditPageProperties.getProperty("AuditDetailsPage.AuditToDateCalender"), "To Date picker");
		if(!browser.isElementVisibleWithXpath(auditPageProperties.getProperty("AuditDetailsPage.ToDate")+(currentDate+1)+"')]")){
			Report.updateTestLog("Future dates are not able to select in end date field", "PASS");
		}
		else{
			Report.updateTestLog("Future dates are not able to select in end date field", "FAIL");
		}
	}
}
