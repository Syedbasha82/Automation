package bg.framework.app.functional.page.selfServe;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import net.sf.saxon.functions.Parse;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class MessageCentrePage extends BasePage {
	 private final static String FILE_NAME = "resources/selfServe/MessageCentre.properties";
	    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	
	public void navigateToMessages()
	{
	  browser.open(ApplicationConfig.APP_BG_URL+"/Your_Account/Your-Messages/");
	}

	
	public void navigateToDefault2adhoc()
	{
	   verifyAndClickWithXpath(pageProperties.getProperty("HomePage.MessageLink"), "Message Link");
	}
	public void navigateToDefault1Message()
	{
	   verifyAndClickWithXpath(pageProperties.getProperty("MessageCentre.Default1Message"), "Default1Message");
	   verifyIsTextPresent("DEFAULT1");
	}
	public void navigateToDefault3Message()
	{
		verifyAndClickWithXpath(pageProperties.getProperty("MessageCentre.Default1Message"), "Default1Message");
		verifyIsTextPresent("DEFAULT3");
		
		}
	
	public void navigateToDefault2Message()
	{
		verifyAndClickWithXpath(pageProperties.getProperty("MessageCentre.Default1Message"), "Default1Message");
		verifyIsTextPresent("DEFAULT2");
	}
	public void navigateToDelete()
	{
	   verifyAndClickWithXpath(pageProperties.getProperty("MessageCentre.Delete"), "Delete");
	}
	public void chkUnreadMessages(UserProfile userProfile,String accType)
	{
		int  intTableCount =  browser.getChildElementsCountByXpath(pageProperties.getProperty("Messages.RowsCount"));
		if(new OnlineDBConnector().verifyMessageShowFlagAll(userProfile.getUCRN()).equalsIgnoreCase(""+intTableCount))
		{
			Report.updateTestLog("The number of messages is same as in PO_TA_UCRN_TREATMENTS:"+intTableCount, "PASS");
		}
		else
		{
			Report.updateTestLog("The number of messages is not same as in PO_TA_UCRN_TREATMENTS", "FAIL");
		}
		int  intUnreadount = 0;
		String strStatus = "";
		String strTreatmentCode = "";
		boolean flag = false;
		String strMandTreatment = "";
		if(accType == "SMART")
		{
			strMandTreatment = "PET0057";
		}
		if(accType == "HomeSerivcesAccount")
		{
			strMandTreatment = "PET0065";
		}
		if(accType == "SSOAccount")
		{
			strMandTreatment = "PET0326";
		}
		List rsTreatementId = new OnlineDBConnector().verifyTreatmentCode(userProfile.getUCRN());
		Iterator it = rsTreatementId.iterator();
		while(it.hasNext())
		{
			strTreatmentCode = it.next().toString();
			if(strTreatmentCode.contains(strMandTreatment)&& accType != "")
			{
				flag = true;
			}
		}
		if(flag == true)
		{
			Report.updateTestLog("The treatment code "+strMandTreatment+ "is Present", "PASS");
		}
		else
		{
			Report.updateTestLog("The treatment code "+strMandTreatment+ "is not Present", "FAIL");
		}
		for(int i = 1 ;i<=intTableCount ;i++)
		{
			if(browser.getTextByXpath(pageProperties.getProperty("Messages.status").replace("ROWS", ""+i)).trim().equalsIgnoreCase("Unread"))
			{	
				intUnreadount = intUnreadount +1;				
			}
			
			
		}
		if(new OnlineDBConnector().verifyMessageShowFlagUnread(userProfile.getUCRN()).equalsIgnoreCase(""+intUnreadount))
		{
			Report.updateTestLog("The number of unread messages is same as in PO_TA_UCRN_TREATMENTS:"+intUnreadount, "PASS");
		}
		else
		{
			Report.updateTestLog("The number of unread messages is not same as in PO_TA_UCRN_TREATMENTS", "FAIL");
		}
		
	}
	
	public void readUnreadMessages(UserProfile userProfile,String accType,String MessageType)
	{
		int flag = 0;
		int  intTableCount =  browser.getChildElementsCountByXpath(pageProperties.getProperty("Messages.RowsCount"));
		int intNewUnreadCount = 0;
		for(int i = 1 ;i<=intTableCount ;i++) 
		{
			if(browser.getTextByXpath(pageProperties.getProperty("Messages.status").replace("ROWS", ""+i)).contains("Read"))
			{
				
				verifyAndClickWithXpath(pageProperties.getProperty("Messages.ReadMessageLink").replace("ROWS", ""+i), "Open Message");
				
				browser.wait(1000);
				if(flag == 0)
				{
					if(MessageType == "Broadcast")
					{
						if(browser.isTextPresent("A message from British Gas"))
						{
							flag = 1;
							Report.updateTestLog("Message is present", "PASS");
							break;
							
						}
					}
				}
				
				verifyAndClickWithLinkText(pageProperties.getProperty("Inbox.BackToMessage"), "Back To Inbox");
				browser.wait(1000);				
				for(int j = 1 ;j<=intTableCount ;j++)
				{
					if(browser.getTextByXpath(pageProperties.getProperty("Messages.status").replace("ROWS", ""+j)).trim().equalsIgnoreCase("Unread"))
					{
						intNewUnreadCount = intNewUnreadCount +1;
					}
					
				}
				if(new OnlineDBConnector().verifyMessageShowFlagUnread(userProfile.getUCRN()).equalsIgnoreCase(""+intNewUnreadCount))
				{
					Report.updateTestLog("The number of unread messages is same as in PO_TA_UCRN_TREATMENTS:"+intNewUnreadCount, "PASS");
				}
				else
				{
					Report.updateTestLog("The number of unread messages is not same as in PO_TA_UCRN_TREATMENTS", "FAIL");
				}
				intNewUnreadCount = 0;
				
			}			
			
			
		}
		if(flag == 0 && MessageType == "Broadcast")
		{
			Report.updateTestLog("Message is not present", "FAIL");
		}
		
		
	}
	public void deleteMessage(UserProfile userProfile)
	{
		int  intTableCount =  browser.getChildElementsCountByXpath(pageProperties.getProperty("Messages.RowsCount"));
		
		for(int i = 1 ;i<=intTableCount ;i++)
		{
			
				verifyAndClickWithXpath(pageProperties.getProperty("Messages.ReadMessageLink").replace("ROWS", ""+i), "Open Message");
				browser.wait(2000);
				verifyAndClickWithLinkText(pageProperties.getProperty("Inbox.Delete"), "Delete ");
				browser.wait(1000);				
				intTableCount =  browser.getChildElementsCountByXpath(pageProperties.getProperty("Messages.RowsCount"));
			
				if(new OnlineDBConnector().verifyMessageShowFlagToShow(userProfile.getUCRN()).equalsIgnoreCase(""+intTableCount))
				{
					Report.updateTestLog("The number of messages is same as in PO_TA_UCRN_TREATMENTS:"+intTableCount, "PASS");
				}
				else
				{
					Report.updateTestLog("The number of messages is not same as in PO_TA_UCRN_TREATMENTS", "FAIL");
				}
				
				
					
		}
	}


}
