package bg.framework.app.functional.page.selfServe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.RunQTP;

public class IBPage extends BasePage{
	private final static String SMR_FILE_NAME = "resources/reFactoring/IB.properties";
	private static Properties pageProperties = new PropertyLoader(SMR_FILE_NAME).load();
	
	String[] lstFaultItems = new String[3];
	
	public void navigateToIdentifyFault(int intFlag)
	{
		browser.wait(3000);

		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBSelectAppliance.HeadText"));
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBSelectAppliance.SelectText"));
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBSelectAppliance.SelectSlot"));		
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBSelectAppliance.EmergencyText"));		
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBSelectAppliance.AwaitingSelection"));		
		lstFaultItems = clickFaultItemCheck();
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBSelectAppliance.FaultyApplianceText"));
		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("ASVIBSelectAppliance.Continue"),
				"Continue Button");
		verifyAndClickWithXpath(
				pageProperties.getProperty("ASVIBSelectAppliance.Continue"),
				"Continue");
	}

	public void verifyFaultPage()
	{
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBSelectAppliance.HeadText"));
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBSelectAppliance.SelectText"));
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBSelectAppliance.SelectSlot"));		
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBSelectAppliance.EmergencyText"));		
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBSelectAppliance.AwaitingSelection"));			
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBSelectAppliance.FaultyApplianceText"));	
	}
	
	public void navigateToPriority()
	{
		
		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("ASVIBSelectAppliance.Continue"),
				"Continue Button");
		
		verifyAndClickWithXpath(
				pageProperties.getProperty("ASVIBSelectAppliance.Continue"),
				"Continue");
	}
	
	public void clickHomeAppliance() {

		verifyAndClickWithXpath(
				pageProperties.getProperty("ASVIBAccountSummary.homeAppliance")
						+ "/li[1]/a", "Home Electricals");

	}

	public String[] clickFaultItemCheck() {
		try {

			int itemCount = 3;
			int faultCount = 0;
			String strTemp = "";
			verifyIsElementVisibleWithXpath(
					pageProperties.getProperty("ASVIBSelectAppliance.ContinueDis"),
					"Continue Disabled Button");

			while (browser.isElementVisibleWithXpath(pageProperties
					.getProperty("ASVIBSelectAppliance.ContinueDis")) == true) 
			{
				System.out.println("--------------->"+pageProperties.getProperty("ASVIBAccountSummary.faultItem")
								.replace("3", "" + itemCount)
								.replace("0", "" + faultCount));
				
				/*strTemp = browser.getTextByXpath(pageProperties
						.getProperty("ASVIBAccountSummary.faultItem")
						.replace("3", "" + itemCount)
						.replace("0", "" + faultCount)
						.replace("input", "label"));*/

				
				if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ASVIBAccountSummary.faultItem")
						.replace("3", "" + itemCount)
						.replace("0", "" + faultCount)) == false) {
					itemCount = 3;
					faultCount = faultCount + 1;
					int catCount = faultCount+1;
					System.out.println("-------****************************************-------->"+pageProperties.getProperty("ASVIBIdentifyFault.Category").replace("i", ""+catCount));
					browser.clickWithXpath(
							pageProperties.getProperty("ASVIBIdentifyFault.Category").replace("[i]", "["+catCount+"]"));
				}
				System.out.println("--------------->"+pageProperties.getProperty("ASVIBAccountSummary.faultItem")
						.replace("3", "" + itemCount)
						.replace("0", "" + faultCount));
				browser.clickWithXpath(
						pageProperties.getProperty("ASVIBAccountSummary.faultItem")
								.replace("3", "" + itemCount)
								.replace("0", "" + faultCount));
				
				itemCount++;
				
				
				if (browser.isElementVisibleWithXpath(pageProperties
						.getProperty("ASVIBSelectAppliance.ContinueDis")) == false) {
					Report.updateTestLog(
							"" + strTemp + " appliance is clicked", "DONE");
				} else {
					Report.updateTestLog("" + strTemp
							+ " appliance is disabled", "DONE");
				}

			}
			// lstFaultItems.add(strTemp);
			if (lstFaultItems[0] == null) {
				lstFaultItems[0] = strTemp;
			} else if (lstFaultItems[1] == null) {
				lstFaultItems[1] = strTemp;
			} else if (lstFaultItems[2] == null) {
				lstFaultItems[2] = strTemp;
			}

			browser.wait(1000);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lstFaultItems;
	}
	
	public void clickFaultCategory(String strCategory)
	{
		if(browser.isTextPresent(strCategory))
		{
			for(int i = 1 ; i<= 4; i++)
			{
				if(browser.isElementVisibleWithXpath((pageProperties.getProperty("ASVIBIdentifyFault.Category")).replace("i", ""+i))&&browser.getTextByXpath(pageProperties.getProperty("ASVIBIdentifyFault.Category")).replace("i", ""+i).contains(strCategory))
				{
					verifyAndClickWithXpath(pageProperties.getProperty("ASVIBIdentifyFault.Category").replace("i", ""+i), "Category");
				}
			}
		}		
	}
	
	public String runVBS(UserProfile userProfile,String strType)
	{
		 String meterread = null;
		 String retVal = null;
		if(strType == "Priority")
		{
		 try {
			
			 File fileR = new File("C:\\Documents and Settings\\!raghavp2\\Desktop\\Banner\\CUSTID.txt");
			 File fileP = new File("C:\\Documents and Settings\\!raghavp2\\Desktop\\Banner\\PREMID.txt");
             FileWriter fw = new FileWriter(fileR);
             FileWriter fwP = new FileWriter(fileP);
          
             fw.write("0"+userProfile.getAccNumber().substring(0,8));
             fwP.write(userProfile.getAccNumber().substring(8, 15));
             fw.close();
             fwP.close();
	            Runtime.getRuntime().exec("wscript C:\\Test_wmis_Prior.vbs");
	            
	            browser.wait(90000);
	            
	            Runtime.getRuntime().exec("wscript C:\\Close.vbs");
	            
	            File file1 = new File("C:\\Documents and Settings\\!raghavp2\\Desktop\\Banner\\Priority.txt");
	            FileReader fr = new FileReader(file1);
	             BufferedReader br = new BufferedReader(fr);
	             meterread = br.readLine();
	             System.out.println("================= > "+meterread.trim());
	             System.out.println("LENGTH > "+meterread.length());
	             br.close();
	            retVal = meterread.trim();
	            
	        } catch (Exception i) {
	            System.err.println("" + i.toString());
	        }
		}
		if(strType == "Preference")
		{
			try
			{
			Runtime.getRuntime().exec("wscript C:\\Test_wmis.vbs");
            
            browser.wait(90000);
            
            Runtime.getRuntime().exec("wscript C:\\Close.vbs");
            File file1 = new File("C:\\Documents and Settings\\!raghavp2\\Desktop\\Banner\\Text1.txt");
            FileReader fr = new FileReader(file1);
             BufferedReader br = new BufferedReader(fr);
             meterread = br.readLine();
             System.out.println("================= > "+meterread.trim());
             System.out.println("LENGTH > "+meterread.length());
             
             br.close();
             retVal = meterread.trim();
			}
			catch (Exception i) {
	            System.err.println("" + i.toString());
	        }
			
		}
		return retVal;
		
	}

	public void navigatePriorityPage(int intFlag)
	{

		if(intFlag == 0)
		{
			verifyIsElementVisibleWithXpath(
					pageProperties.getProperty("ASVIBIdentifyFault.PopUpContinue"),
					"Continue button");
			verifyAndClickWithXpath(
					pageProperties.getProperty("ASVIBIdentifyFault.PopUpContinue"),
					"Continue Identify Fault");
			browser.wait(1000);
			verifyPriorityPage("2");
			verifyAndClickWithXpath(pageProperties.getProperty("IBPriority.No"), "No priority");
		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("IBIdentifyFault.Continue"),
				"Continue button");
		verifyAndClickWithXpath(
				pageProperties.getProperty("IBIdentifyFault.Continue"),
				"Continue");
		}
		if(intFlag == 1)
		{
			verifyIsElementVisibleWithXpath(
					pageProperties.getProperty("ASVIBIdentifyFault.PopUpContinue"),
					"Continue button");
			verifyAndClickWithXpath(
					pageProperties.getProperty("ASVIBIdentifyFault.PopUpContinue"),
					"Continue Identify Fault");
			browser.wait(1000);
			verifyPriorityPage("2");
			verifyAndClickWithXpath(pageProperties.getProperty("IBPriority.Yes"), "Yes priority");
			
			verifyIsElementVisibleWithXpath(
					pageProperties.getProperty("IBIdentifyFault.Continue"),
					"Continue button");
			verifyAndClickWithXpath(
					pageProperties.getProperty("IBIdentifyFault.Continue"),"Continue");
			
			
		}
		if(intFlag == 2)
		{
			
			browser.wait(1000);
			verifyPriorityPage("2");
			verifyAndClickWithXpath(pageProperties.getProperty("IBPriority.Yes"), "Yes priority");
			
			verifyIsElementVisibleWithXpath(
					pageProperties.getProperty("IBIdentifyFault.Continue"),
					"Continue button");
			verifyAndClickWithXpath(
					pageProperties.getProperty("IBIdentifyFault.Continue"),"Continue");
			
			
		}
		if(intFlag == 3)
		{
			
			browser.wait(1000);
			verifyIsElementVisibleWithXpath(
					pageProperties.getProperty("ASVIBIdentifyFault.PopUpContinue"),
					"Continue button");
			verifyAndClickWithXpath(
					pageProperties.getProperty("ASVIBIdentifyFault.PopUpContinue"),
					"Continue Identify Fault");
			browser.wait(1000);
		}
	}
	
	public void verifyPriorityPage(String intFlag)
	{
		if(intFlag == "1a")
		{
		verifyIsTextPresent(pageProperties.getProperty("ASVIBSelectAppliance.HeadText"));
		verifyIsTextPresent(pageProperties.getProperty("IBPriority.Question1"));
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("IBPriority.Yes"), "Yes priority");
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("IBPriority.No"), "No priority");
		}
		
		if(intFlag == "2")
		{
		verifyIsTextPresent(pageProperties.getProperty("ASVIBSelectAppliance.HeadText"));		
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("IBPriority.Yes"), "Yes priority");
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("IBPriority.No"), "No priority");
		}
		
		if(intFlag == "1b")
		{
		verifyIsTextPresent(pageProperties.getProperty("ASVIBSelectAppliance.HeadText"));
		verifyIsTextPresent(pageProperties.getProperty("IBPriority.Question2"));
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("IBPriority.Yes"), "Yes priority");
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("IBPriority.No"), "No priority");
		}
		
		if(intFlag == "0" )
		{
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("IBPriority.Yes")))
			{
				Report.updateTestLog("Priority Page is loaded", "FAIL");
			}
			else
			{
				Report.updateTestLog("Priority Page is not loaded", "PASS");
				verifyIsTextPresent(pageProperties
						.getProperty("ASVIBContactDetails.YourAppointmentText"));
				verifyIsTextPresent("Review details", "Review Details Page");
				
				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASVIBReview.GAC")))
				{
						verifyIsElementVisibleWithXpath(
						pageProperties.getProperty("ASVIBReview.GAC"), "GAC link");
				}
				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASVIBReview.COD")))
				{
				verifyIsElementVisibleWithXpath(
						pageProperties.getProperty("ASVIBReview.COD"), "COD");
				}
				verifyIsElementVisibleWithXpath(
						pageProperties.getProperty("ASVIBReview.MobileNumberRadio"),
						"Mobile Number radio button");
				verifyAndClickWithXpath(
						pageProperties.getProperty("ASVIBReview.HomeNumberRadio"),
						"Mobile Number");
				verifyIsElementVisibleWithXpath(
						pageProperties.getProperty("ASVIBReview.HomeNumberRadio"),
						"Mobile Number radio button");
				verifyIsElementVisibleWithXpath(
						pageProperties.getProperty("ASVIBReview.MobileNumberText"),
						"Mobile Number textbox");
				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASVIBReview.MobileNumberText")))
						{
					Report.updateTestLog("Contact Details Page is loaded", "PASS");
						}
				else
				{
					Report.updateTestLog("Contact Details Page is not loaded", "PASS");
				}
				
			}
			
		}
	}
	
	public void changeAppointment(int intOption) {
		browser.wait(1000);
		if (intOption == 1) {

			verifyIsElementVisibleWithXpath(
					pageProperties.getProperty("ASVIBReview.PopUpKeepAppointment"),
					"PopUp KeepAppointment button");
			verifyAndClickWithXpath(
					pageProperties.getProperty("ASVIBReview.PopUpKeepAppointment"),
					"Keep Appointment");
		}
		if (intOption == 2) {
			verifyIsElementVisibleWithXpath(
					pageProperties.getProperty("ASVIBReview.PopUpChangeAppointment"),
					"PopUp Change Appointment button");
			verifyAndClickWithXpath(
					pageProperties.getProperty("ASVIBReview.PopUpChangeAppointment"),
					"Change Appointment");
		}
	}
	
	public void selectAnAppointment(String strSlotType) {
		browser.wait(1000);
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBBookAppointment.MessageText"));
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBBookAppointment.SlotsAvailable"));
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBBookAppointment.DifferentAppointment"));
		String strRowNum = "0";
		if(strSlotType == "AllDay")
		{
			strRowNum = "4";
		}
		
		if(strSlotType == "AllDay")
		{
			if(browser.isTextPresent("All day 8am - 6pm"))
			{
				Report.updateTestLog("All Day slots available in the page", "PASS");
			}
			else
			{
				Report.updateTestLog("All Day slots is not available in the page", "FAIL");
			}
			strRowNum = "4";
		}
		
		if(strSlotType == "FF")
		{
			if(browser.isTextPresent("10am - 2pm"))
			{
				Report.updateTestLog("FF slots available in the page", "PASS");
			}
			else
			{
				Report.updateTestLog("FF slots is not available in the page", "FAIL");
			}
			strRowNum = "2";
		}
		
		if(strSlotType == "EVE")
		{
			if(browser.isTextPresent("6pm - 8pm"))
			{
				Report.updateTestLog("Eve slots available in the page", "PASS");
			}
			else
			{
				Report.updateTestLog("Eve slots is not available in the page", "FAIL");
			}
			strRowNum = "5";
		}
		
		if(strSlotType == "PM")
		{
			if(browser.isTextPresent("12pm - 6pm"))
			{
				Report.updateTestLog("PM slots available in the page", "PASS");
			}
			else
			{
				Report.updateTestLog("PM slots is not available in the page", "FAIL");
			}
			strRowNum = "3";
		}
		
		if(strSlotType == "PMElec")
		{
			if(browser.isTextPresent("4pm - 6pm"))
			{
				Report.updateTestLog("PM slots for elec (4pm - 6pm) available in the page", "PASS");
			}
			else
			{
				Report.updateTestLog("PM slots for elec (4pm - 6pm is not available in the page", "FAIL");
			}
			strRowNum = "3";
		}
		
		
		for (int i = 7; i > 0; i--) {

			if (browser.isElementVisibleWithXpath(pageProperties.getProperty(
					"ASVIBBookAppointment.LastAppointment").replace("COLS", "" + i).replace("ROWS", strRowNum))) {
				verifyIsElementVisibleWithXpath(
						".//*[@id='content-body']/div/div[3]/div[2]/div[2]/h2",
						"Book an appointment page");
				verifyAndClickWithXpath(
						pageProperties.getProperty(
								"ASVIBBookAppointment.LastAppointment").replace("COLS", "" + i).replace("ROWS", strRowNum),
						"Select a slot from available slots");
				verifyIsElementVisibleWithXpath(
						pageProperties.getProperty("ASVIBBookAppointment.Continue"),
						"Continue button");
				verifyAndClickWithXpath(
						pageProperties.getProperty("ASVIBBookAppointment.Continue"),
						"Book This Appointment");
				break;
			}
		}

	}
	
	public void selectNoAppointment(String strSlotType) {
		browser.wait(1000);
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBBookAppointment.MessageText"));
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBBookAppointment.SlotsAvailable"));
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBBookAppointment.DifferentAppointment"));
		String strRowNum = "0";
		if(strSlotType == "AllDay")
		{
			strRowNum = "4";
		}
		
		if(strSlotType == "AllDay")
		{
			if(browser.isTextPresent("All day 8am - 6pm"))
			{
				Report.updateTestLog("All Day slots available in the page", "FAIL");
			}
			else
			{
				Report.updateTestLog("All Day slots is not available in the page", "PASS");
			}
			strRowNum = "4";
		}
		
		if(strSlotType == "FF")
		{
			if(browser.isTextPresent("10am - 2pm"))
			{
				Report.updateTestLog("FF slots available in the page", "FAIL");
			}
			else
			{
				Report.updateTestLog("FF slots is not available in the page", "PASS");
			}
			strRowNum = "2";
		}
		
		if(strSlotType == "EVE")
		{
			if(browser.isTextPresent("6pm - 8pm"))
			{
				Report.updateTestLog("EVE slots available in the page", "FAIL");
			}
			else
			{
				Report.updateTestLog("EVE slots is not available in the page", "PASS");
			}
			strRowNum = "5";
		}
		
		if(strSlotType == "PM")
		{
			if(browser.isTextPresent("12pm - 6pm"))
			{
				Report.updateTestLog("PM slots available in the page", "PASS");
			}
			else
			{
				Report.updateTestLog("PM slots is not available in the page", "FAIL");
			}
			strRowNum = "3";
		}
		
		for (int i = 7; i > 0; i--) {

			if (browser.isElementVisibleWithXpath(pageProperties.getProperty(
					"ASVIBBookAppointment.LastAppointment").replace("COLS", "" + i).replace("ROWS", strRowNum))) {
				Report.updateTestLog( strSlotType+ " slots available in the page", "FAIL");
				break;
			}
			if(i == 1)
			{
				Report.updateTestLog( strSlotType+ " slots are not available in the page", "PASS");
			}
		}

	}
	
	public void selectAnAppointmentWeekend(String strSlotType) {
		browser.wait(1000);
		
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBBookAppointment.MessageText"));
		
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBBookAppointment.SlotsAvailable"));
		
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBBookAppointment.DifferentAppointment"));
		
		String strRowNum = "0";
		if(strSlotType == "AllDay")
		{
			strRowNum = "4";
		}
		
		if(strSlotType == "AllDay")
		{
			if(browser.isTextPresent("All day 8am - 6pm"))
			{
				Report.updateTestLog("All Day slots available in the page", "PASS");
			}
			else
			{
				Report.updateTestLog("All Day slots is not available in the page", "FAIL");
			}
			strRowNum = "4";
		}
		
		if(strSlotType == "FF")
		{
			if(browser.isTextPresent("10am - 2pm"))
			{
				Report.updateTestLog("FF slots available in the page", "PASS");
			}
			else
			{
				Report.updateTestLog("FF slots is not available in the page", "FAIL");
			}
			strRowNum = "2";
		}
		
		if(strSlotType == "4pm to 6pm")
		{
			if(browser.isTextPresent("4pm to 6pm"))
			{
				Report.updateTestLog("FF slots 4pm to 6pm available in the page", "PASS");
			}
			else
			{
				Report.updateTestLog("FF slots 4pm to 6pm is not available in the page", "FAIL");
			}
			strRowNum = "5";
		}
		
		if(strSlotType == "EVE")
		{
			if(browser.isTextPresent("6pm - 8pm"))
			{
				Report.updateTestLog("Eve slots available in the page", "PASS");
			}
			else
			{
				Report.updateTestLog("Eve slots is not available in the page", "FAIL");
			}
			strRowNum = "5";
		}
		
		if(strSlotType == "PM")
		{
			if(browser.isTextPresent("12pm - 4pm"))
			{
				Report.updateTestLog("PM slots available in the page", "PASS");
			}
			else
			{
				Report.updateTestLog("PM slots is not available in the page", "FAIL");
			}
			strRowNum = "3";
		}
		
		int rowStartNum = 0;
		int rowEndNum = 0;
		Calendar currentDate = Calendar.getInstance();
		new SimpleDateFormat("yyyy");
		int dayCount = currentDate.get(currentDate.DAY_OF_WEEK);
		switch(dayCount)
		{
		case 1:
		{
			rowStartNum = 7;
			rowEndNum = 6;
			break;
		}
		case 2:	
		{
			rowStartNum = 7;
			rowEndNum = 5;
			break;
		}
		case 3:
		{
			rowStartNum = 6;
			rowEndNum = 4;
			break;
		
		}
		case 4:
		{
			rowStartNum = 5;
			rowEndNum = 3;
			break;
		
		}
		case 5:
		{
			rowStartNum = 4;
			rowEndNum = 2;
			break;
		
		}
		case 6:
		{
			rowStartNum = 3;
			rowEndNum = 1;
			break;
		
		}
		case 7:
		{
			rowStartNum = 1;
			rowEndNum = 0;
			break;
		
		}
		}
		
		
	
		
		for (int i = rowStartNum; i > rowEndNum; i--) {

			if (browser.isElementVisibleWithXpath(pageProperties.getProperty(
					"ASVIBBookAppointment.LastAppointment").replace("COLS", "" + i).replace("ROWS", strRowNum))) {
				verifyIsElementVisibleWithXpath(
						".//*[@id='content-body']/div/div[3]/div[2]/div[2]/h2",
						"Book an appointment page");
				verifyAndClickWithXpath(
						pageProperties.getProperty(
								"ASVIBBookAppointment.LastAppointment").replace("COLS", "" + i).replace("ROWS", strRowNum),
						"Select a slot from available slots");
				verifyIsElementVisibleWithXpath(
						pageProperties.getProperty("ASVIBBookAppointment.Continue"),
						"Continue button");
				verifyAndClickWithXpath(
						pageProperties.getProperty("ASVIBBookAppointment.Continue"),
						"Book This Appointment");
				break;
			}
		}

	}
	
	public void selectAnyAppointment()
	{
		browser.wait(1000);
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBBookAppointment.MessageText"));
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBBookAppointment.SlotsAvailable"));
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBBookAppointment.DifferentAppointment"));
		for (int i = 7; i > 0; i--) {

			if (browser.isElementVisibleWithXpath(pageProperties.getProperty(
					"ASVIBBookAppointment.LastAppointment").replace("COLS", "" + i))) {
				verifyIsElementVisibleWithXpath(
						".//*[@id='content-body']/div/div[3]/div[2]/div[2]/h2",
						"Book an appointment page");
				verifyAndClickWithXpath(
						pageProperties.getProperty(
								"ASVIBBookAppointment.LastAppointment").replace(
								"COLS", "" + i),
						"Select a slot from available slots");
				verifyIsElementVisibleWithXpath(
						pageProperties.getProperty("ASVIBBookAppointment.Continue"),
						"Continue button");
				verifyAndClickWithXpath(
						pageProperties.getProperty("ASVIBBookAppointment.Continue"),
						"Book This Appointment");
				break;
			}
		}
	}
	
	public void verifyNoWeekendSlot(String strSlotType)
	{
		String strRowNum = "0";
		if(strSlotType == "AllDay")
		{
			strRowNum = "4";
		}
		
		if(strSlotType == "AllDay")
		{
			if(browser.isTextPresent("All day 8am - 6pm"))
			{
				Report.updateTestLog("All Day slots available in the page", "PASS");
			}
			else
			{
				Report.updateTestLog("All Day slots is not available in the page", "FAIL");
			}
			strRowNum = "4";
		}
		
		if(strSlotType == "FF")
		{
			if(browser.isTextPresent("10am - 2pm"))
			{
				Report.updateTestLog("FF slots available in the page", "PASS");
			}
			else
			{
				Report.updateTestLog("FF slots is not available in the page", "FAIL");
			}
			strRowNum = "3";
		}
		int rowStartNum = 0;
		int rowEndNum = 0;
		Calendar currentDate = Calendar.getInstance();
		int dayCount = currentDate.get(currentDate.DAY_OF_WEEK);
		switch(dayCount)
		{
		case 1:
		{
			rowStartNum = 7;
			rowEndNum = 6;
			break;
		}
		case 2:	
		{
			rowStartNum = 7;
			rowEndNum = 5;
			break;
		}
		case 3:
		{
			rowStartNum = 6;
			rowEndNum = 4;
			break;
		
		}
		case 4:
		{
			rowStartNum = 5;
			rowEndNum = 3;
			break;
		
		}
		case 5:
		{
			rowStartNum = 4;
			rowEndNum = 2;
			break;
		
		}
		case 6:
		{
			rowStartNum = 3;
			rowEndNum = 1;
			break;
		
		}
		case 7:
		{
			rowStartNum = 1;
			rowEndNum = 0;
			break;
		
		}
		}
		for (int i = rowStartNum; i > rowEndNum; i--) {

			if (browser.isElementVisibleWithXpath(pageProperties.getProperty(
					"ASVIBBookAppointment.LastAppointment").replace("COLS", "" + i).replace("ROWS", strRowNum))) {
				Report.updateTestLog(strSlotType+" are available in the weekend day", "FAIL");
				break;
			}
			else
			{
				Report.updateTestLog("Evening slots are not available in the weekend day", "PASS");
			}
		}
	}
	
	public void selectAnAppointmentWeekDay(String strSlotType) {
		browser.wait(1000);
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBBookAppointment.MessageText"));
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBBookAppointment.SlotsAvailable"));
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBBookAppointment.DifferentAppointment"));
		String strRowNum = "0";
		if(strSlotType == "AllDay")
		{
			strRowNum = "4";
		}
		
		if(strSlotType == "AllDay")
		{
			if(browser.isTextPresent("All day 8am - 6pm"))
			{
				Report.updateTestLog("All Day slots available in the page", "PASS");
			}
			else
			{
				Report.updateTestLog("All Day slots is not available in the page", "FAIL");
			}
			strRowNum = "4";
		}
		
		if(strSlotType == "2HR8to10")
		{
			if(browser.isTextPresent("8am - 10am"))
			{
				Report.updateTestLog("2Hr slots 8am - 10am available in the page", "PASS");
			}
			else
			{
				Report.updateTestLog("2Hr slots 8am - 10am is not available in the page", "FAIL");
			}
			strRowNum = "1";
		}
		
		if(strSlotType == "2HR4to6")
		{
			if(browser.isTextPresent("2pm - 4pm"))
			{
				Report.updateTestLog("2Hr slots 2pm - 4pm available in the page", "PASS");
			}
			else
			{
				Report.updateTestLog("2Hr slots 2pm - 4pm is not available in the page", "FAIL");
			}
			strRowNum = "4";
		}
		
		
		if(strSlotType == "FF")
		{
			if(browser.isTextPresent("10am - 2pm"))
			{
				Report.updateTestLog("FF slots available in the page", "PASS");
			}
			else
			{
				Report.updateTestLog("FF slots is not available in the page", "FAIL");
			}
			strRowNum = "2";
		}
		
		if(strSlotType == "EVE")
		{
			if(browser.isTextPresent("6pm - 8pm"))
			{
				Report.updateTestLog("Eve slots available in the page", "PASS");
			}
			else
			{
				Report.updateTestLog("Eve slots is not available in the page", "FAIL");
			}
			strRowNum = "5";
		}
		
		if(strSlotType == "PM")
		{
			if(browser.isTextPresent("12pm - 6pm"))
			{
				Report.updateTestLog("PM slots available in the page", "PASS");
			}
			else
			{
				Report.updateTestLog("PM slots is not available in the page", "FAIL");
			}
			strRowNum = "3";
		}
		
		int rowStartNum = 0;
		int rowEndNum = 0;
		Calendar currentDate = Calendar.getInstance();
		int dayCount = currentDate.get(currentDate.DAY_OF_WEEK);
		switch(dayCount)
		{
		case 1:
		{
			rowStartNum = 6;
			rowEndNum = 1;
			break;
		}
		case 2:	
		{
			rowStartNum = 5;
			rowEndNum = 0;
			break;
		}
		case 3:
		{
			rowStartNum = 4;
			rowEndNum = 0;
			break;
		
		}
		case 4:
		{
			rowStartNum = 3;
			rowEndNum = 0;
			break;
		
		}
		case 5:
		{
			rowStartNum = 2;
			rowEndNum = 0;
			break;
		
		}
		case 6:
		{
			rowStartNum = 7;
			rowEndNum = 3;
			break;
		
		}
		case 7:
		{
			rowStartNum = 7;
			rowEndNum = 2;
			break;
		
		}
		}
		
		
		for (int i = rowStartNum; i > rowEndNum; i--) {

			if (browser.isElementVisibleWithXpath(pageProperties.getProperty(
					"ASVIBBookAppointment.LastAppointment").replace("COLS", "" + i).replace("ROWS", strRowNum))) {
				verifyIsElementVisibleWithXpath(
						".//*[@id='content-body']/div/div[3]/div[2]/div[2]/h2",
						"Book an appointment page");
				verifyAndClickWithXpath(
						pageProperties.getProperty(
								"ASVIBBookAppointment.LastAppointment").replace("COLS", "" + i).replace("ROWS", strRowNum),
						"Select a slot from available slots");
				verifyIsElementVisibleWithXpath(
						pageProperties.getProperty("ASVIBBookAppointment.Continue"),
						"Continue button");
				verifyAndClickWithXpath(
						pageProperties.getProperty("ASVIBBookAppointment.Continue"),
						"Book This Appointment");
				break;
			}
		}

	}
	
	public void reviewDetailsPage() {

		
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBContactDetails.YourAppointmentText"));
		verifyIsTextPresent("Review details", "Review Details Page");
		
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASVIBReview.GAC")))
		{
				verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("ASVIBReview.GAC"), "GAC link");
		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASVIBReview.COD")))
		{
		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("ASVIBReview.COD"), "COD");
		}
		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("ASVIBReview.MobileNumberRadio"),
				"Mobile Number radio button");
		verifyAndClickWithXpath(
				pageProperties.getProperty("ASVIBReview.HomeNumberRadio"),
				"Mobile Number");
		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("ASVIBReview.HomeNumberRadio"),
				"Mobile Number radio button");
		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("ASVIBReview.MobileNumberText"),
				"Mobile Number textbox");

		
		verifyAndClickWithXpath(
				pageProperties.getProperty("ASVIBReview.MobileNumberRadio"),
				"Mobile Number");
		verifyAndInputByXpath(
				pageProperties.getProperty("ASVIBReview.MobileNumberText"),
				"Mobile Number Text", "0123465789");
	}
	
	public void navigateToConfirmation() {
		
		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("ASVIBReview.Continue"),
				"Continue button");

		verifyAndClickWithXpath(pageProperties.getProperty("ASVIBReview.Continue"),
				"Confirm");
		verifyConfirmationPage();
	}

	public void verifyConfirmationPage() {
	
		verifyIsTextPresent(
				pageProperties.getProperty("ASVIBConfirmation.LongMessageText"),
				"Text:We'll send a reminder nearer the time of your booking, and the engineer will call you on the day to let you know when they're on their way");
		verifyIsTextPresent(
				pageProperties.getProperty("ASVIBConfirmation.TrackCancelChange"),
				"TrackCancelChange link");
		

		if (browser.getTextByXpath(".//*[@id='h1']").contains(
				"Your annual service is booked")
				|| browser.getTextByXpath(".//*[@id='h1']").contains(
						"Your appointment has been rescheduled")|| browser.getTextByXpath(".//*[@id='h1']").contains(
								"Your engineer's visit is booked")) {
			Report.updateTestLog("Confirmation page is loaded", "PASS");
		} else {
			Report.updateTestLog("Confirmation page is not loaded", "FAIL");

		}
	}

	public void accountSummaryChange()
	{
		browser.wait(1000);
		verifyIsTextPresent(
				pageProperties.getProperty("ASVIBAccountSummary.Change"),
				"Change Appointment link");
		verifyAndClickWithLinkText(
				pageProperties.getProperty("ASVIBAccountSummary.Change"),
				"Change Appointment");
	}

	public void verifyEmergencyMessage(int intflag)
	{
		if(intflag == 0)
		{
		verifyIsTextPresent("Urgent situation");

		verifyIsTextPresent("If you, a member of your household, or your property are at immediate risk");
		
		verifyIsTextPresent("If you smell burning, or if there is smoke coming from your fuseboard, lights or sockets");
		verifyIsTextPresent("please call us immediately on");
		}
		if(intflag == 4)
		{
			verifyIsTextPresent("At immediate risk?");
			verifyIsTextPresent("If you or your propery is at immediate risk");	
		}

	}

	public void verifyAccountOverview(String strStatus)
	{
		if(strStatus == "Ideal")
		{
		/*browser.wait(getWaitTime());
		verifyIsTextPresent(pageProperties.getProperty("AccountOverview.VerifyFirstAvailableText"),"First available time slot text");
		checkDateFormat();
		verifyIsTextPresent(pageProperties.getProperty("AccountOverview.verifyBookThisApp"), "Book this appointment link");
		verifyIsTextPresent(pageProperties.getProperty("AccountOverview.VerifyviewAllSlot"), "View all available slots link");
		verifyIsTextPresent(pageProperties.getProperty("AccountOverview.VerifyInfoText"), "Information Text");
		verifyIsTextPresent(pageProperties.getProperty("AccountOverview.VerifyASVinfoText"), "Information Text");*/
			
		}
		if(strStatus == "Comp")
		{
			browser.wait(getWaitTime());
			
			if(browser.getTextByXpath(pageProperties.getProperty("ASVIBAccountSummary.YourAppointmentSection")).equalsIgnoreCase("Your appointment"))
			{
				Report.updateTestLog("Your Appointment Section Is Present", "PASS");
			}
			else
			{
				Report.updateTestLog("Your Appointment Section Is Not Present", "FAIL");
			}
			
			if(browser.getTextByXpath(pageProperties.getProperty("ASVIBAccountSummary.BookedStatusScetion")).equalsIgnoreCase("Your appointment status"))
			{
				Report.updateTestLog("Your appointment status Section Is Present", "PASS");
			}
			else
			{
				Report.updateTestLog("Your appointment status Section Is Not Present", "FAIL");
			}
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASVIBAccountSummary.CompletedStatus")))
			{
				Report.updateTestLog("Completed appointment status Section Is Present", "PASS");
			}
			else
			{
				Report.updateTestLog("Completed appointment status Section Is Not Present", "FAIL");
			}
			
			if(browser.getTextByXpath(pageProperties.getProperty("ASVIBAccountSummary.AllDone")).equalsIgnoreCase("All done"))
			{
				Report.updateTestLog("All Done status Section Is Present", "PASS");
			}
			else
			{
				Report.updateTestLog("All Done status Section Is Not Present", "FAIL");
			}
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("ASVIBAccountSummary.CalendarImg"),"Calendar Image");
			verifyIsTextPresent(pageProperties.getProperty("ASVIBContactDetails.YourAppointmentText"));
			checkDateFormat();
			verifyIsTextPresent(pageProperties.getProperty("ASVIBAccountSummary.Cancel"));
			verifyIsTextPresent(pageProperties.getProperty("ASVIBAccountSummary.Change"));
			verifyIsTextPresent(pageProperties.getProperty("ASVIBAccountSummary.AppointmentBookedFor"));
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("ASVIBAccountSummary.ASV"),"Booked ASV");
			
		}
		
		if(strStatus == "Site")
		{
			browser.wait(getWaitTime());
			
			if(browser.getTextByXpath(pageProperties.getProperty("ASVIBAccountSummary.YourAppointmentSection")).equalsIgnoreCase("Your appointment"))
			{
				Report.updateTestLog("Your Appointment Section Is Present", "PASS");
			}
			else
			{
				Report.updateTestLog("Your Appointment Section Is Not Present", "FAIL");
			}
			
			if(browser.getTextByXpath(pageProperties.getProperty("ASVIBAccountSummary.BookedStatusScetion")).equalsIgnoreCase("Your appointment status"))
			{
				Report.updateTestLog("Your appointment status Section Is Present", "PASS");
			}
			else
			{
				Report.updateTestLog("Your appointment status Section Is Not Present", "FAIL");
			}
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASVIBAccountSummary.CompletedStatus")))
			{
				Report.updateTestLog("Completed appointment status Section Is Present", "PASS");
			}
			else
			{
				Report.updateTestLog("Completed appointment status Section Is Not Present", "FAIL");
			}
			
			/*if(browser.getTextByXpath(pageProperties.getProperty("ASVIBAccountSummary.AllDone")).equalsIgnoreCase("All done"))
			{
				Report.updateTestLog("All Done status Section Is Present", "PASS");
			}
			else
			{
				Report.updateTestLog("All Done status Section Is Not Present", "FAIL");
			}*/
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("ASVIBAccountSummary.CalendarImg"),"Calendar Image");
			verifyIsTextPresent(pageProperties.getProperty("ASVIBContactDetails.YourAppointmentText"));
			checkDateFormat();
			verifyIsTextPresent(pageProperties.getProperty("ASVIBAccountSummary.Cancel"));
			verifyIsTextPresent(pageProperties.getProperty("ASVIBAccountSummary.Change"));
			verifyIsTextPresent(pageProperties.getProperty("ASVIBAccountSummary.AppointmentBookedFor"));
		//	verifyIsElementVisibleWithXpath(pageProperties.getProperty("ASVIBAccountSummary.ASV"),"Booked ASV");
			
		}
	}

@SuppressWarnings("static-access")
	public void checkDateFormat()
{
	Calendar currentDate = Calendar.getInstance();
	SimpleDateFormat oDateFormat = new SimpleDateFormat("MMM yyyy");
	for (int i = 0; i <= 6; i++) {
		String oStrDate = "";
		currentDate.add(Calendar.DATE, i);
		oStrDate = oDateFormat.format(currentDate.getTime());
		String dayName[] = new DateFormatSymbols().getWeekdays();
		String FinalDate = dayName[currentDate.get(currentDate.DAY_OF_WEEK)]
				.toString()
				+ " "
				+ currentDate.get(currentDate.DAY_OF_MONTH)
				+ " "
				+ oStrDate;

		if (browser.isTextPresent(FinalDate)) {
			Report.updateTestLog(
					"The date format is verified and the date " + FinalDate
							+ " is present", "PASS");
			break;
		} else {
			if (i == 6) {
				Report.updateTestLog(
						"The date format is verified and the date is not present",
						"FAIL");
			}
		}

	}
}

}
