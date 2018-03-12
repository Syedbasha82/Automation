package bg.framework.app.functional.page.Slingshot;
import java.util.Date;
import java.util.Properties;



import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.util.Properties;
import org.joda.time.DateTime;

public class AlertMessageCenterPage extends BasePage {
	
	 SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyy");	
	private final static String FILE_NAME = "resources/Slingshot/PaperlessBilling.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

	//pagno :23
	// global paperless not set up – displayed only to enterprise superusers or enterprise users who have paperless billing in the role profile
	
	public void yourMessages()
	{
		verifyIsTextPresent("Your messages");
		verifyIsTextPresent("Inbox");	    
	}
	 public int transcount()
	 {
		 System.out.println(" i am here in table"); 
		 browser.wait(4000);
		 String numberOfTransactions= browser.getTextByXpath(pageProperties.getProperty("AlertMessageCenterPage.Transactions"));
		 System.out.println(browser.getTextByXpath(pageProperties.getProperty("AlertMessageCenterPage.Transactions")));
		 System.out.println("rowcount"+numberOfTransactions);
		 String[] totalTransaction = numberOfTransactions.split("of");         
		 totalTransaction = totalTransaction[1].split(" ");
		  String numberOfTransactionsInAuditTable = totalTransaction[1];
		  System.out.println("numberOfTransactionsInAuditTable"+numberOfTransactionsInAuditTable);
         int numberofrows = Integer.parseInt(numberOfTransactionsInAuditTable);
         return numberofrows;
	 }
	public void YourMessagePagewithPagination()
 	{
		int i,count=0; 		
 	    int noofTransaction =transcount();
 		for(i=1;i<=noofTransaction;i++)
		 {
 			if(i<=20)
 			{
 				System.out.println("i"+i);
 				count= count+1;
 				System.out.println("count"+count); 				 
 			}
 			if((browser.isElementVisibleWithXpath(pageProperties.getProperty("AlertMessageCenterPage.MessagePageNext")) && (i>=21)))		 				
 			{
 				verifyAndClickWithXpath(pageProperties.getProperty("AlertMessageCenterPage.MessagePageNext"), "Next ");
 				verifyAndClickWithXpath(pageProperties.getProperty("AlertMessageCenterPage.MessagePagePrevious"), "Previous "); 						
 			} 			
 			
		  }
    }
	public void YourMessagePagewithoutPagination()
 	{
		int count=0,flag=1; 		
 	    int noofTransaction =transcount();
 			if(noofTransaction<=20)
 			{
 				System.out.println("noofTransaction"+noofTransaction);
 				count= count+1;
 				System.out.println("count"+count); 		
 				flag=2;
 			}
		 	
 			if(flag==2)
 			{
 				Report.updateTestLog("Your Messages Inbox is having Less than 20 messages .So No Pagination available" , "Pass");
 			}
 			else if((browser.isElementVisibleWithXpath(pageProperties.getProperty("AlertMessageCenterPage.MessagePageNext")) && (flag==1)))		 				
 			{
 				 Report.updateTestLog("Your Messages Inbox is having More than 20 messages and Pagination is Present" , "Fail");					
 			}			
 			
    }
	
	public void youhavenomessagesInbox()
	{
		verifyIsTextPresent("You have no messages to view");
	}
	public void inboxNavigation()
	{
		verifyAndClickWithXpath(pageProperties.getProperty("AlertMessageCenterPage.yourMessageInbox"), "Inbox "); 	
	}
	public void backtoyourAccount()
	{
		verifyAndClickWithXpath(pageProperties.getProperty("AlertMessageCenterPage.BacktoYourAcct"), "Back To Your Account "); 	
	}
	
	public void deleteUnreadMessages()
	{		
	 		int i,k=1,m=4;	
	 		String msgstatusreader=null;
	 	    int yourMsgcount =transcount();
	 		for(i=1;i<=yourMsgcount;i++)	 				 			
			 {
	 			if(i>=21)		 				
	 			{
	 				System.out.println("i crossed");
					verifyAndClickWithXpath(pageProperties.getProperty("AlertMessageCenterPage.MessagePageNextt"),"Next");	
					System.out.println("i clicked nxt");
					
					msgstatusreader=browser.getTextByXpath(pageProperties.getProperty("AlertMessageCenterPage.msgTablereader")+"//tr["+i+"]/td["+k+"]");
	 				 System.out.println("msgstatusreader"+msgstatusreader);	 				
	 				 if(msgstatusreader=="Unread")
	 				 {
	 					 verifyAndClickWithXpath(pageProperties.getProperty("AlertMessageCenterPage.messageSelection"), " Message checkbox "); 
	 					 verifyAndClickWithXpath(pageProperties.getProperty("AlertMessageCenterPage.DeleteSelected"), " Delete Selected "); 
	 					 Report.updateTestLog("In Inbox Unread message is deleted successfully" , "Pass");					
	 				 }
					
			 			
					}					
	 			}	
	 			if(i<=20)
	 			{
	 				 msgstatusreader=browser.getTextByXpath(pageProperties.getProperty("AlertMessageCenterPage.msgTablereader")+"//tr["+i+"]/td["+k+"]");
	 				 System.out.println("msgstatusreader"+msgstatusreader);	 				
	 				 if(msgstatusreader=="Unread")
	 				 {
	 					 verifyAndClickWithXpath(pageProperties.getProperty("AlertMessageCenterPage.messageSelection"), " Message checkbox "); 
	 					 verifyAndClickWithXpath(pageProperties.getProperty("AlertMessageCenterPage.DeleteSelected"), " Delete Selected "); 
	 					 Report.updateTestLog("In Inbox Unread message is deleted successfully" , "Pass");					
	 				 }
	 				 
	 }
	}		
	 	public void breadCrumbLink()
	 	{
	 		verifyAndClickWithXpath(pageProperties.getProperty("AlertMessageCenterPage.YourAccount"), "Your Account");
	 		browser.browserBack();
	 		verifyAndClickWithXpath(pageProperties.getProperty("AlertMessageCenterPage.AtHome"), "At Home");
	 		browser.browserBack();	 		
	 		verifyAndClickWithXpath(pageProperties.getProperty("AlertMessageCenterPage.ForCorporate"), "For Corporate");
	 		browser.browserBack();	
	 		verifyAndClickWithXpath(pageProperties.getProperty("AlertMessageCenterPage.Business"), "Business");
	 		browser.browserBack();
	 	}
	 	
	 	public void emailfunctionality()
	 	{
	 		verifyAndClickWithXpath(pageProperties.getProperty("AlertMessageCenterPage.backtoyourmessages"), "Back to your messages");
	 		browser.browserBack();
	 		verifyAndClickWithXpath(pageProperties.getProperty("AlertMessageCenterPage.delete"), "Delete");
	 	}
	 	public void backtoyourmessage()
	 	{
	 		verifyAndClickWithXpath(pageProperties.getProperty("AlertMessageCenterPage.backtoyourmessages"), "Back to your messages");
	 	}
	 	
	 	public void validate30daysmessagesininbox()
	 	{
	 		
	 		int i=1,k=1,m=4,j=1;
	 		String lastestmessagedate=null;
	 		String endmessagedate=null;
	 		
	 	    int yourMsgcount =transcount();
	 	    lastestmessagedate= browser.getTextByXpath(pageProperties.getProperty("AlertMessageCenterPage.msgTablereader")+"//tr["+i+"]/td["+k+"]");
	 		for(i=2;i<=yourMsgcount;i++)	 				 			
			 {
	 			if(i==21|i==41|i==61|i==81|i==101|i==121|i==141|i==161|i==181|i==201)	
	 			{
	 				verifyAndClickWithXpath(pageProperties.getProperty("AlertMessageCenterPage.MessagePageNextt"),"Next"); 			
	 			}
	 			
	 			if(i>=21)		 				
	 			{
	 				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("AlertMessageCenterPage.msgtablecontent")+"//tr["+i+"]/td["+j+"]"))					
					{
	 					endmessagedate=browser.getTextByXpath(pageProperties.getProperty("AlertMessageCenterPage.msgtablecontent")+"//tr["+i+"]/td["+k+"]");
	 					System.out.println("endmessagedate"+endmessagedate);					
	 				
			 			
					}					
	 			}	
	 			if(i<=20)
	 			{
	 				
	 				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("AlertMessageCenterPage.msgtablecontent")+"//tr["+i+"]/td["+j+"]"))					
					{
				 		endmessagedate=browser.getTextByXpath(pageProperties.getProperty("AlertMessageCenterPage.msgtablecontent")+"//tr["+i+"]/td["+k+"]");
	 					 System.out.println("endmessagedate"+endmessagedate);	
					}
	 			
	 			}
	 		}
	 	  
	 	   String msgstartdate=format.format(new Date(lastestmessagedate));
	 	  String msgenddate=format.format(new Date(endmessagedate));
	 	  monthdifference(msgstartdate,msgenddate);
	 	}
	 			
	 	
	 	//have to fully update
	 	 public void verifySortingyourmessageTable(){
	 		   
	 		   String dateField1="";
	 		   String dateField2="";	   
	 		   try{
	 			   int rowcount=browser.getRowCountByXpath(pageProperties.getProperty("SearchBill.Table"));
	 			   
	 			   System.out.println("rowcount:"+rowcount);
	 			   if(rowcount==1){
	 				   Report.updateTestLog("Search Date table row count is less than 2 , Test data error","Warn");
	 			   }
	 			   verifyAndClickWithXpath((pageProperties.getProperty("SearchBill.Table"))+"//tr/th[1]/strong", "Billing date");
	 			   for(int i=1;i<rowcount;i++){
	 				   System.out.println("First for loop:"+i);
	 				   dateField1=browser.getTextByXpath(pageProperties.getProperty("SearchBill.Table")+"/tbody/tr["+i+"]/td[1]/p");
	 				   System.out.println("xpath value is:"+pageProperties.getProperty("SearchBill.Table")+"/tbody/tr["+i+"]/td[1]/p");
	 				   System.out.println("dateField1:"+dateField1);
	 				   String lastmod=format.format(new Date(dateField1));
	 				   System.out.println("lastmod:"+lastmod);
	 				   Date date1=format.parse(lastmod);
	 				   System.out.println("Before date displayed");
	 				   System.out.println("date1:"+date1);
	 				   for(int j=i+1;j<rowcount;j++){
	 					   System.out.println("Second for loop");
	 					   dateField2=browser.getTextByXpath(pageProperties.getProperty("SearchBill.Table")+"/tbody/tr["+j+"]/td[1]/p");
	 					   System.out.println("xpath value is:"+pageProperties.getProperty("SearchBill.Table")+"/tbody/tr["+j+"]/td[1]/p");
	 					   System.out.println("dateField2:"+dateField2);
	 					   String lastmod1=format.format(new Date(dateField2));
	 					   Date date2=format.parse(lastmod1);
	 					   System.out.println("date2:"+date2);
	 					   if(date1.compareTo(date2)>0){
	 						   //Report.updateTestLog("Date ("+"i"+")value is :"+date1+"Date ("+"j"+") value is :"+date2,"Pass");
	 					   }else{
	 						   //Report.updateTestLog("Date ("+"i"+")value is :"+date1+"Date ("+"j"+") value is :"+date2,"Pass");
	 					   }
	 				   }   
	 			   }   
	 		   }catch(Exception e){
	 			   Report.updateTestLog("Exception while trying to fetch the value in application:"+e,"Fail");
	 		   } 	   
	 	   }
	 	public String Dateformatconvertor(String ActualReadDate)
		{
			 try
			    {
				 
			      //create SimpleDateFormat object with source string date format
			      SimpleDateFormat sdfSource = new SimpleDateFormat("dd-MMM-yyyy");
			      
			      //parse the string into Date object
			      Date date = sdfSource.parse(ActualReadDate);
			      
			      //create SimpleDateFormat object with desired date format
			      SimpleDateFormat sdfDestination = new SimpleDateFormat("dd.MM.yyyy");
			      
			      //parse the date into another format
			      ActualReadDate = sdfDestination.format(date);
			      
			      System.out.println("Date is converted from dd/MM/yy format to dd.MM.yyyy");
			      System.out.println("Converted date is : " + ActualReadDate);
			      
			    }
			    catch(ParseException pe)
			    { 
			      System.out.println("Parse Exception : " + pe);
			    }
			return ActualReadDate;
		}
	 	public void monthdifference(String fromdate,String Todate)
	 	{
	 		 DateFormat formatter ; 
	 		 Date date1,date2 ; 
	 		 try
	 		 {
	 		  formatter = new SimpleDateFormat("dd/MM/yyyy");
	 		  date1 = (Date)formatter.parse(fromdate);
	 		  date2 = (Date)formatter.parse(Todate);  
	 		  System.out.println("Today is " +date1 );
	 		  long milliseconds1 = date1.getTime();
	 		  long milliseconds2 = date2.getTime();
	 		  long diff = milliseconds2 - milliseconds1;
	 		  long diffDays = diff / (24 * 60 * 60 * 1000); 			
	 	
	 			if(diffDays<=30)
	 			{
	 				Report.updateTestLog(" Your Message box is exactly having less than or equal to messages","PASS");
	 			}
	 			else
	 			{
	 				Report.updateTestLog(" Your Message box is exactly having more than or equal to messages","FAIL");
	 			}		
	 						
	 		} catch (Exception e) {
	 			e.printStackTrace();
	 		}
	 		
	 	}
	 	
	 	public void npssurvey()
	 	{
	 	verifyIsTextPresent("npssurvery");
	 	}
	 	
	 	public void viewmessagesfully()
	 	{
	 		
	 		System.out.println("view messages"); // after the application received have to verify the view message fully scenario
	 	}
 	}