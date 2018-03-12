package bg.framework.app.functional.page.selfServe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;






import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.reFactoring.RegistrationPage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.RobotSendKeys;

public class PredictNextBillPage  extends BasePage{
	private final static String FILE_NAME="resources/selfServe/PredictNextBill.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	private UserProfile userProfile;
	public static String UnitRatePrice;
	public static String UnitRatePrice1;
	public static String StandingchargePrice;
	public static String StandingchargePrice1;
	public static String unitnumbers;
	public static String StandingPricenumbers;
	public static String UnitRatePricefinal;
	int x=0;
	 
	public PredictNextBillPage(UserProfile userProfile)
	 {
		this.userProfile=userProfile;
	 }
	 
	public PredictNextBillPage()
	 {}
	 
	public void navigateToPredictNextBill(String triggerPoint,UserProfile userProfile)
	{
		Report.updateTestLog("The account Summary page", "WARN");
		browser.wait(15000);
		if(triggerPoint=="Billing")
		{
			verifyAndClickWithLinkText(pageProperties.getProperty("PNB.BillingLinkLHN"),"Billing");
			browser.wait(5000);
			verifyAndClickWithXpath(pageProperties.getProperty("PNB.PNBViaBilling"),"PNBLink");
		}
		else if(triggerPoint=="MeterReadSection")
		{
			browser.wait(15000);
			//For Smart Meter Customer
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PNB.AccSummarySmart")))
			{
				verifyAndClickWithXpath(pageProperties.getProperty("PNB.AccSummarySmart"), "PNB via Meter Reading Section for smart meter customer");
			}
			//For EnergySmart Customer
			else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PNB.AccSummaryEnerSmart")))
			{
				verifyAndClickWithXpath(pageProperties.getProperty("PNB.AccSummaryEnerSmart"), "PNB via Meter Reading Section for Esmart meter customer");
			}
			
		}	
		
		else if(triggerPoint=="SMR")
		{
			browser.wait(4000);
			verifyAndClickWithXpath(pageProperties.getProperty("PNB.SubmitMeterRead"), "SMR link");
			
		}
		else if(triggerPoint=="EnergyUsage")
		{
			//verifyAndClickWithXpath(pageProperties.getProperty("PNB.EUSageInAcSum"), "EnergyUsage");
			browser.wait(2000);
			verifyAndClickWithXpath(pageProperties.getProperty("PNB.PNBLinkLHN01"),"PNB in LHN");
		}
		else if(triggerPoint=="deeplink")
		{
			browser.open("https://10.224.70.75/Account-History/Predict-Next-Bill/");
		}
		else if(triggerPoint=="AccSummaryCheck")
		{
			accSummaryMeterRead();
			verifyAndClickWithLinkText(pageProperties.getProperty("PNB.BillingLinkLHN"),"Billing");
			verifyAndClickWithLinkText(pageProperties.getProperty("PNB.PNBViaBilling"),"PNBLink");
		}
		
		if(triggerPoint!="SMR")
		{
			verifyPageTitle("Predict next bill");
		}
		Report.updateTestLog("The PNB page screenshot is taken", "WARN");
	}
	
	
	public void enterInputsForSMRJourney(String elecRead)
	{
		verifyAndSelectCheckBoxByID((pageProperties.getProperty("PNB.SMRCheckBox").replace("accountnumberSelect",userProfile.getAccNumber())),"Account Select Checkbox");
		//String meterReadInput[]=elecRead.split("");
		//String elecXpath=pageProperties.getProperty("PNB.SMRGasMeterDial").replace("number",userProfile.getAccNumber());
		String elecXpath=pageProperties.getProperty("PNB.SMRGasMeterDial");
		enterRead(elecXpath,elecRead);
	}
	
	public void enterInputsForSMRJourney(String gasRead,String elecRead)
	{
		verifyAndSelectCheckBoxByID((pageProperties.getProperty("PNB.SMRCheckBox").replace("number",userProfile.getAccNumber())),"Account Select Checkbox");
		//String gasMeterInput[]=gasRead.split("");
		//String elecMeterInput[]=elecRead.split("");
		
		//String gasXpath=pageProperties.getProperty("PNB.SMRGasMeterDial").replace("number",userProfile.getAccNumber());
		//String elecXpath=pageProperties.getProperty("PNB.SMRElecmeterDial").replace("number",userProfile.getAccNumber());
		String gasXpath=pageProperties.getProperty("PNB.SMRGasMeterDial");
		String elecXpath=pageProperties.getProperty("PNB.SMRElecmeterDial");
		enterRead(gasXpath,gasRead);
		enterRead(elecXpath,elecRead);
	}
	
	public void enterRead(String xPath,String read)
	{
		/*int readValue=Integer.parseInt(read);
		String latestMeterInputString=String.format("%0"+dialSize+"d",read);
		String input[]=read.split("");*/
		if(browser.isElementVisibleWithXpath(xPath))
		{
			int dialSize=browser.getChildElementsCountByXpath(xPath);
			int readValue=Integer.parseInt(read);
			String smrInputRead=String.format("%0"+dialSize+"d",readValue);
			String input[]=smrInputRead.split("");
			for(int i=1;i<=dialSize;i++)
			{
				verifyAndInputByXpath(xPath+"["+i+"]","input"+i,input[i]);
			}
		}
	}
	
	public void navigateToPNBAfterSMR()
	{
		if(browser.isElementVisible(pageProperties.getProperty("PNB.NectarNoThanks")))
		{
		verifyAndClick(pageProperties.getProperty("PNB.NectarNoThanks"),"Nectar No thanks");
		}
		verifyAndClick(pageProperties.getProperty("PNB.SubmitSMR"), "Submit");
		verifyAndClickWithLinkText(pageProperties.getProperty("PNB.PNBInSMR"), "PNB Link in SMR");
	}

	public void verifyPNBPageLinks()
	{
		//Description:Verifies 5links in PNB Page that occurs before and after PNB

		verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.ViewUsageHistoryLink"), "view your usage history(below average daily usage)");
		//verifyIsTextPresent(pageProperties.getProperty("PNB.CompareEnergyLink"),"See how you compare");
		//verifyIsTextPresent(pageProperties.getProperty("PNB.EnergySaverStoreLink"),"Energy Saver Store");

	//	verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.ViewUsageHistoryLink"), "view your usage history(below average daily usage)");
	//	verifyIsTextPresent(pageProperties.getProperty("PNB.CompareEnergyLink"),"See how you compare");
	//	verifyIsTextPresent(pageProperties.getProperty("PNB.EnergySaverStoreLink"),"Energy Saver Store");
		verifyIsTextPresent(pageProperties.getProperty("PNB.DownloadAppLink"),"Download our free app");
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.FindAbtOtherTariffs"),"Find out about other tarrifs");
		
	}
	
	public void verifyIntialPNBPage()
	{
		/*5 verification
		ACCtype,RefNum,SupplyAddress
		LastMeterRead
		LastBillAmount
		AverageConsumption*/		
		
		//Address part
		//verifyIsElementVisibleWithXpath((pageProperties.getProperty("PNB.CustomerAddress")).replace("number",userProfile.getAccNumber() ), "CustomerAddress");
		
		//Last Bill Amount section
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.InvoicePeriod"),"Last Bill Period");
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.LastBillAmount"), "Last Bill Amount");
		
		//Last Bill Read
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.LastBillRead"), "Last Bill Read");
	}
	
	public void verifyLIcallFailorWithoutBill(ArrayList<String> errList)
	{
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.LastBillAmountFail"), "LastBillAmountFail");
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.LastBillReadFail"), "LastBillReadFail");
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.AverageUseFail"), "AvgUsageFail");
		
	}
	
	public void verifyMIcallFail()
	{
		verifyIsElementVisibleWithXpath("//*[@id='journeyErrorDisplay']", "Manage Invoice call fail");
	}
	
	public void verifyMeterDials()
	{
		if(browser.isElementVisible(pageProperties.getProperty("PNB.GasDialId")))
		{
			Report.updateTestLog("The Gas dials are displayed", "PASS");
		}
		if(browser.isElementVisible(pageProperties.getProperty("PNB.EleDayDialId")))
		{
			if(browser.isElementVisible(pageProperties.getProperty("PNB.ElecNightDialId")))
			{
				Report.updateTestLog("The electricity dials for dual rate are displayed", "PASS");
			}
			else{
				Report.updateTestLog("The electricity dials are displayed", "PASS");
			}
		}
	}
	
	public void selectMeterTypeAndEnterRead(String tolerance,String gasinput,String elecinput,String elecdualinput) throws IOException
	{
		browser.wait(1000);
		String dialFieldsxPath="";
		//String lastRead ="";
		int gasRead=Integer.parseInt(gasinput);
		int elecRead=Integer.parseInt(elecinput);
		int elecdual=Integer.parseInt(elecdualinput);
		
		if(browser.isElementVisible(pageProperties.getProperty("PNB.EleDayDialId"))&&
				browser.isElementVisible(pageProperties.getProperty("PNB.GasDialId")))
		{
			Report.updateTestLog("The fuel Type is JI","PASS");
			//String gasLastMeter=browser.getTextByXpath(pageProperties.getProperty("PNB.GasJILastBillRead"));
			dialFieldsxPath = pageProperties.getProperty("PNB.GasDialId");
			enterMeterReadForPNB(dialFieldsxPath,tolerance,gasRead);
			dialFieldsxPath = pageProperties.getProperty("PNB.EleDayDialId");
			enterMeterReadForPNB(dialFieldsxPath,tolerance,elecRead);
			if(browser.isElementVisible(pageProperties.getProperty("PNB.ElecNightDialId"))){
				dialFieldsxPath= pageProperties.getProperty("PNB.ElecNightDialId");
				enterMeterReadForPNB(dialFieldsxPath,tolerance,elecdual);
			}
		}
		else{
			if(browser.isElementVisible(pageProperties.getProperty("PNB.GasDialId"))){
				browser.wait(1000);
				Report.updateTestLog("The fuel Type is Gas","PASS");
				dialFieldsxPath = pageProperties.getProperty("PNB.GasDialId");
				enterMeterReadForPNB(dialFieldsxPath,tolerance,gasRead);
			}
			if((browser.isElementVisible(pageProperties.getProperty("PNB.EleDayDialId")))
					&&(!browser.isElementVisible(pageProperties.getProperty("PNB.ElecNightDialId")))){
				browser.wait(1000);
				Report.updateTestLog("The fuel Type is Electricity","PASS");
				dialFieldsxPath = pageProperties.getProperty("PNB.EleDayDialId");
				enterMeterReadForPNB(dialFieldsxPath,tolerance,elecRead);
			}
			if(browser.isElementVisible(pageProperties.getProperty("PNB.ElecNightDialId"))){
				browser.wait(1000);
				Report.updateTestLog("The fuel Type is Electricity Dual","PASS");
				dialFieldsxPath = pageProperties.getProperty("PNB.ElecNightDialId");
				enterMeterReadForPNB(dialFieldsxPath,tolerance,elecdual);
				
				dialFieldsxPath = pageProperties.getProperty("PNB.EleDayDialId");
				enterMeterReadForPNB(dialFieldsxPath,tolerance,elecRead);
			}
		}
		browser.wait(1000);
		
	}
	
	/* As the account type can be of Gas or Elec or dual and the dial size can vary ,they are handled 
	 * */
	public void enterMeterReadForPNB(String dialFieldsxPath,String tolerance,int meterRead)throws IOException
	{
		int dialSize=1;
		//String latest=browser.getTextByXpath(pageProperties.getProperty("PNB.LatestMeterRead"));
		//String last=browser.getTextByXpath(pageProperties.getProperty("PNB.LastBillRead"));
		//String lastMeterInputs=lastRead.replace("\n","");
		//int readLength=lastMeterInputs.length();
		int read=meterRead;
		if(tolerance=="plausible")
		{
			read=meterRead;
		}
		else if(tolerance=="impHigh")
		{
			read=read+8000;
		}
		else if(tolerance=="impLow")
		{
			read=read-100;
		}
		
		
		for(int i=2;i<=6;i++)
		{
			if(browser.isElementVisible(dialFieldsxPath+""+i))
			{
				dialSize++;
			}
		}
		if(meterRead==1)
		{
			for(int j=1;j<=dialSize;j++) 
			{
				for(int dialNumber=1;dialNumber<=dialSize;dialNumber++)
				{
					if(j!=dialNumber)
					{
						if(dialNumber==1)
						{
							verifyAndInputById(dialFieldsxPath,"Meterdial"+dialNumber,"1");
						}
						else
						{
						verifyAndInputById(dialFieldsxPath+""+dialNumber,"Meterdial"+dialNumber,"1");
						}
					}
				}
				verifyAndClickWithXpath(pageProperties.getProperty("PNB.PredictMyBillButton"),"PredictTheBill Button");
			}
		}
		else{
		String latestMeterInputString=String.format("%0"+dialSize+"d",read);
		System.out.println("latestMeterInputString"+latestMeterInputString);
		String meterReadInputArray[]=latestMeterInputString.split("");
		for(int dialNumber=1;dialNumber<=dialSize;dialNumber++) 
		{
			if(dialNumber==1)
			{
				verifyAndInputById(dialFieldsxPath,"Meterdial"+dialNumber,meterReadInputArray[dialNumber]);
			}
			else
			{
			verifyAndInputById(dialFieldsxPath+""+dialNumber,"Meterdial"+dialNumber,meterReadInputArray[dialNumber]);
			}
		}}
		
	}
	
	
	public void verifyWhatsThisLink()
	{
		verifyAndClickWithXpath(pageProperties.getProperty("PNB.WhatsThisHeading"), "What's This");
		RobotSendKeys.typeenter();
		
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PNB.WhatsThisLast")))
		{
			verifyAndClickWithXpath(pageProperties.getProperty("PNB.WhatsThisLast"),"What's This on last meter read");
			RobotSendKeys.typeenter();
			
		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PNB.WhatsThisLatest")))
		{
			verifyAndClickWithXpath(pageProperties.getProperty("PNB.WhatsThisLatest"), "What's This on latest meter Read");
			RobotSendKeys.typeenter();
		}
	}
	
	public void clickPredictNextBill()
	{
		verifyAndClickWithXpath(pageProperties.getProperty("PNB.PredictMyBillButton"),"PredictTheBill Button");
		browser.wait(5000);
	}
	
	public void verifyImpausibleErrorMessageImplausible(ArrayList<String> errList)
	{
		//verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.ImplausErr"),"Error Message");
		String implErr=browser.getTextByXpath(pageProperties.getProperty("PNB.ImplausErr"));
		new RegistrationPage().verifyErrorMsg(implErr, errList.get(22),"Implausible Error message" );
		/*if(implErr.contains("exceptionally"))
		{
			Report.updateTestLog("the error message displayed is "+implErr+" for implausible", "PASS");
		}
		else{
			Report.updateTestLog("the error message displayed is "+implErr+" not for implausible", "FAIL");
		}*/
	}
	
	public void errorMessageWithoutMeterRead(ArrayList<String> errList)
	{
		//verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.ErrMessageOnNoEntry"),"Error message");
		new RegistrationPage().verifyErrorMsg(browser.getTextByXpath(pageProperties.getProperty("PNB.ErrMessageOnNoEntry")),errList.get(19) , "Meter dial validation");
		Report.updateTestLog("The Error Message screenshot", "WARN");
	}
	
	public void verifyPredictedBillPage()
	{
		Report.updateTestLog("The Predicted Next bill Page", "WARN");
		//5 verification
		/*SpendToDate
		PredictedNextBillAmount
		breakdown
		Tier rates
		averageDialyUsage*/
		//STD
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.PeriodTillDate"), "STDPeriod");
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.SpendToDatAmount"), "STDAmount");
		//Predicted amount
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.NextBillPeriod"), "Next Bill Period");
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.PredictedValue"), "Predicted value");
		//ViewBreakDown
		//verifyAndClickWithXpath(pageProperties.getProperty("PNB.ViewBreakdownLink"),"ViewBreakdown link");
		verifyAndClickWithLinkText(pageProperties.getProperty("PNB.ViewBDLink"),"view breakdown");
		if(browser.isTextPresent(pageProperties.getProperty("PNB.verifyText")))
		{
			
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.BrkDwnVAT"), "VAT amount");
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.TotalAmount"), "TotalAmount");
		}
		RobotSendKeys.typeenter();
		
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PNB.GasTier1Value")))
		{
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.GasTier1Value"), "GasTier1");
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.GasTier2Value"), "GasTier2");
		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PNB.ElecTier1Value")))
		{
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.ElecTier1Value"), "ElecTier1");
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.ElecTier2Value"), "ElecTier2");
		}
		
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PNB.ElecNightTier1")))
		{
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.ElecNightTier1"), "ElecNightTier1");
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.ElecNightTier2"), "ElecNightTier2");
		}
		
		//Avg daily usage
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PNB.GasAvgUsageLastQuarter")))
		{
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.GasAvgUsageLastQuarter"), "AvgUsageLastQuarter");
		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PNB.GasAvgUsageThisMonth")))
		{
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.GasAvgUsageThisMonth"), "AvgUsageGasThisMonth");
		}	
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PNB.ElecAvgUsageLastQuarter")))
		{
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.ElecAvgUsageLastQuarter"), "AvgUsageElecLastQuarter");
		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PNB.ElecAvgUsageThisMonth")))
		{
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.ElecAvgUsageThisMonth"), "AvgUsageElecThisMonth");
		}
	}

	public void serviceCalls()
	{
		//for Esmart & dump----->if SAP is down then PNB page will not be displayed.
		//for smart meter------->if ManageInvoice call fails PNB page will not be displayed.
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PNB.SAPDownErrMsg")))
		{
			Report.updateTestLog("SAP is down cannot proceed PNB","PASS");
			
		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PNB.SmartMeterMICallFailErrMsg")))
		{
			Report.updateTestLog("Manage Invoice call fails cannot proceed PNB","PASS");
		}
		
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PNB.LatestInvoiceCallFailErrorMsg")))
		{
			Report.updateTestLog("Latest Invoice call fails but still can proceed PNB","PASS");
		}
	}
	
	public void resetPNBValue()
	{
		verifyAndClickWithXpath(pageProperties.getProperty("PNB.ResetValues"),"Reset Value");
		browser.wait(3000);
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.PredictMyBillButton"),"Predict Bill Button After Reset");
		Report.updateTestLog("After Reset", "WARN");
	}
	
	public void verifydropDownBoxForDualCusomer()
	{
		verifyIsElementVisibleById(pageProperties.getProperty("PNB.OtherAccountsDropDown"),"Drop Down box to choose different customer");
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.ViewAllAcountsDDBox"),"View All Accounts");
		verifyAndClickWithXpath(pageProperties.getProperty("PNB.ViewAllAcountsDDBox"), "View All Your Accounts link");
		verifyPageTitle("Account overview");
	}
	
	public void accountSelect(String accNum)
	{
			ArrayList<String> accountList = new ArrayList<String>();   
	    	if(browser.isElementVisible(pageProperties.getProperty("PNB.OtherAccountsDropDown")))
	    	{
	    		 accountList=(browser.getFromDropBox("id", pageProperties.getProperty("PNB.OtherAccountsDropDown")));
	    	}
	    	int sizeOfDDBox=accountList.size();
	    	if(sizeOfDDBox>2)
	    	{
	    		//if any account has size greater than 2 then need a rework.
	    	}
	    	for(String s:accountList)
	    	{
	    		if(s.contains(accNum))
	    		{
	    			verifyAndSelectDropDownBox(pageProperties.getProperty("PNB.OtherAccountsDropDown"),"AccountDetails"+s,s);
	    			break;
	    		}
	    	}
	    	browser.click("go_url");
	  }
	
	public void pnbLogout()
	{
		verifyAndClickWithXpath(pageProperties.getProperty("PNB.Logout"), "Logout");
	}
	
	public void accSummaryMeterRead()
	{
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PNB.AccSumRead1")))
		{
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.AccSumRead1"), "Read1");
		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PNB.AccSumReadJI2")))
		{
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.AccSumReadJI2"), "Read2");
		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PNB.AccSumRead2")))
		{
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("PNB.AccSumRead2"), "Read3");
		}	
	}

	public void verifyErrorMessage() {
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PNB.ErrorMessageTOU"))){
			Report.updateTestLog("Error Message is displayed", "Pass");}
		else{
			Report.updateTestLog("Error Message is NOT displayed", "Fail");
		}
		
	}
	public void verifyUnitRatePrice()
	{
		browser.wait(getWaitTime());
		UnitRatePrice = "";
		UnitRatePrice = browser.getTextByXpath(pageProperties.getProperty("PNB.UnitRates"));
			System.out.println("Unit Price in with the Characters   "+UnitRatePrice);
		browser.wait(getWaitTime());
		unitnumbers = UnitRatePrice.replaceAll("[^0-9.]", " ");
		System.out.println("After the characters are removed"+unitnumbers);
		System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
		System.out.println("Now Verify the digits");
		String digitnum = unitnumbers;
		int i = digitnum.lastIndexOf('.');
		if(i != -1 && digitnum.substring(i + 1).length() == 2) {
		    System.out.println("The numbers " + digitnum + " has two digits after dot");
		    Report.updateTestLog("Unit Price is having only 2 digit is available after the dot","Warn");
		}
		else{
			Report.updateTestLog("Unit Price is having more than 2 digit is available after the dot", "Fail");
	
		}
		
	}
	public void verifyGasTariffUnitRatePrice()
	{
		browser.wait(getWaitTime());
		UnitRatePrice = "";
		UnitRatePrice = browser.getTextByXpath(pageProperties.getProperty("PNB.GasTariffUnitRates"));
			System.out.println("Unit Price in with the Characters   "+UnitRatePrice);
		unitnumbers = UnitRatePrice.replaceAll("[^0-9.]", " ").trim();
		System.out.println("After the characters are removed"+unitnumbers);
		browser.wait(getWaitTime());
		String digitnum = unitnumbers;
		int i = digitnum.lastIndexOf('.');
		if(i != -1 && digitnum.substring(i + 1).length() == 2) {
		    System.out.println("The numbers " + digitnum + " has two digits after dot");
		    Report.updateTestLog("Unit Price is having only 2 digit is available after the dot", "Warn");
		}
		else{
			Report.updateTestLog("Unit Price is having more than 2 digit is available after the dot", "Fail");
	
		}
	}
		
	public void StandingchargePrice()
	{
		browser.wait(getWaitTime());
		StandingchargePrice = "";
		StandingchargePrice = browser.getTextByXpath(pageProperties.getProperty("PNB.Standingcharge"));
		System.out.println("StandingchargePrice in with the Characters   "+StandingchargePrice);
		StandingPricenumbers = StandingchargePrice.replaceAll("[^0-9.]", " ");
		System.out.println("After the characters are removed"+StandingPricenumbers);
		browser.wait(getWaitTime());
		String digitnum = StandingPricenumbers;
		int i = digitnum.lastIndexOf('.');
		if(i != -1 && digitnum.substring(i + 1).length() == 2) {
		    System.out.println("The numbers " + digitnum + " has two digits after dot");
		    Report.updateTestLog("Standing Price is having only 2 digit is available after the dot","Warn");
		}
		else{
			Report.updateTestLog("Standing Price is having more than 2 digit is available after the dot", "Fail");
	
		}	
		
	}
	public void VerifyGasTariffStandingchargePrice()
	{
		browser.wait(getWaitTime());
		StandingchargePrice = "";
		StandingchargePrice = browser.getTextByXpath(pageProperties.getProperty("PNB.Standingcharge"));
		System.out.println("StandingchargePrice in with the Characters   "+StandingchargePrice);
		
		StandingPricenumbers = StandingchargePrice.replaceAll("[^0-9.]", " ").trim();
		System.out.println("After the characters are removed"+StandingPricenumbers);
		browser.wait(getWaitTime());
		String digitnum = StandingPricenumbers;
		int i = digitnum.lastIndexOf('.');
		if(i != -1 && digitnum.substring(i + 1).length() == 2) {
		    System.out.println("The numbers " + digitnum + " has two digits after dot");
		    Report.updateTestLog("Standing Price is having only 2 digit is available after the dot", "Warn");
		}
		else{
			Report.updateTestLog("Standing Price is having more than 2 digit is available after the dot", "Fail");
	
		}
		
	}	
		//StandingchargePrice = browser.getTextByXpath(pageProperties.getProperty("PNB.GasTariffstandingRates"));
	
	public void ClickElecttarifflink()
	{
		browser.wait(getWaitTime());
		verifyAndClickWithXpath(pageProperties.getProperty("PNB.ElectricityLink"), "Click Tariff Link");
		browser.wait(getWaitTime());
		verifyAndClickWithXpath(pageProperties.getProperty("PNB.TariffInfo"), "Tariff Details");
	}
	public void ClickGastarifflink()
	{
		browser.wait(getWaitTime());
		verifyAndClickWithXpath(pageProperties.getProperty("PNB.GasTariffInfo"), "Click Gas Tariff Link");
		browser.wait(getWaitTime());
		verifyAndClickWithXpath(pageProperties.getProperty("PNB.GasTariffselect"), "Tariff Details");	
	}
	public void verifyElecTariffUnitRatePrice()
	{
		browser.wait(getWaitTime());
		UnitRatePrice = "";
		UnitRatePrice1 ="";
		UnitRatePrice = browser.getTextByXpath(pageProperties.getProperty("PNB.TariffElectUnitRates"));
			System.out.println("Unit Price in with the Characters   "+UnitRatePrice);
		unitnumbers = UnitRatePrice.replaceAll("[^0-9.]", " ").trim();
		System.out.println("After the characters are removed in the Unit Tarriff Price"+unitnumbers);
		browser.wait(getWaitTime());
		String digitnum = unitnumbers;
		int i = digitnum.lastIndexOf('.');
		if(i != -1 && digitnum.substring(i + 1).length() == 2) {
		    System.out.println("The numbers " + digitnum + " has two digits after dot");
		    Report.updateTestLog("Unit Price is having only 2 digit is available after the dot", "Warn");
		}
		else{
			Report.updateTestLog("Unit Price is having more than 2 digit is available after the dot", "Fail");
	
		}
	}
	
	
	
	public void TariffStandingchargePrice()
	{
		browser.wait(getWaitTime());
		StandingchargePrice = "";
		StandingchargePrice1 = "";
		StandingchargePrice = browser.getTextByXpath(pageProperties.getProperty("PNB.TariffElectstandingRates"));
		System.out.println("StandingchargePrice in with the Characters   "+StandingchargePrice);
		
		StandingPricenumbers = StandingchargePrice.replaceAll("[^0-9.]", " ").trim();
		
	
		
		System.out.println("After the characters are removed"+StandingPricenumbers);
		browser.wait(getWaitTime());
		String digitnum = StandingPricenumbers;
		int i = digitnum.lastIndexOf('.');
		if(i != -1 && digitnum.substring(i + 1).length() == 2) {
		    System.out.println("The numbers " + digitnum + " has two digits after dot");
		    Report.updateTestLog("Standing Price is having only 2 digit is available after the dot", "Warn");
		}
		else{
			Report.updateTestLog("Standing Price is having more than 2 digit is available after the dot", "Fail");
	
		}
		
	}	
	public void verifyElectUnitRatePrice()
	{
		browser.wait(getWaitTime());
		UnitRatePrice = "";
		UnitRatePrice = browser.getTextByXpath(pageProperties.getProperty("PNB.ElectUnitRates"));
			System.out.println("Unit Price in with the Characters   "+UnitRatePrice);
		browser.wait(getWaitTime());
		unitnumbers = UnitRatePrice.replaceAll("[^0-9.]", " ");
		System.out.println("After the characters are removed"+unitnumbers);
		System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
		System.out.println("Now Verify the digits");
		String digitnum = unitnumbers;
		int i = digitnum.lastIndexOf('.');
		if(i != -1 && digitnum.substring(i + 1).length() == 2) {
		    System.out.println("The numbers " + digitnum + " has two digits after dot");
		    Report.updateTestLog("Unit Price is having only 2 digit is available after the dot","Warn");
		}
		else{
			Report.updateTestLog("Unit Price is having more than 2 digit is available after the dot", "Fail");
	
		}
		
	}
	public void VerifyElectStandingchargePrice()
	{
		browser.wait(getWaitTime());
		StandingchargePrice = "";
		StandingchargePrice = browser.getTextByXpath(pageProperties.getProperty("PNB.ElectStandingRates"));
		System.out.println("StandingchargePrice in with the Characters   "+StandingchargePrice);
		StandingPricenumbers = StandingchargePrice.replaceAll("[^0-9.]", " ");
		System.out.println("After the characters are removed"+StandingPricenumbers);
		browser.wait(getWaitTime());
		String digitnum = StandingPricenumbers;
		int i = digitnum.lastIndexOf('.');
		if(i != -1 && digitnum.substring(i + 1).length() == 2) {
		    System.out.println("The numbers " + digitnum + " has two digits after dot");
		    Report.updateTestLog("Standing Price is having only 2 digit is available after the dot","Warn");
		}
		else{
			Report.updateTestLog("Standing Price is having more than 2 digit is available after the dot", "Fail");
	
		}	
		
	}
	
	public void closeCurrentTariff()
	{
		browser.wait(getWaitTime());
		
		//WebElement element =browser.getTextByXpath(pageProperties.getProperty("PNB.ElectStandingRates"));
		//element.click();
		//element.sendKeys(Keys.ESCAPE);
		browser.clickWithXpath(pageProperties.getProperty("PNB.Closewindow"));
		
	}
	
}

