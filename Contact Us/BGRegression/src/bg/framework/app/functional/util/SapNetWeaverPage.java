package bg.framework.app.functional.util;

import java.io.*;

import java.util.Iterator;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.entities.CRMExecutionDataProfile;
import java.util.Calendar;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;



public class SapNetWeaverPage extends BasePage{ 
	 private static String DayofTheYear="", BusinessPartnerID="", Hour = "", Minute = "", homeNumber = "", Title = "", FirstName = "", LastName = "", PostCode = "", TelephoneNumber = "", TelephoneType ="" ; 
	 private static Boolean SapExecute = false;
	 private static String[] CRMDataXml = new String[200];
	 WebDriver popup = null;
	 static String ReturnUrl = null;
	 private final static String FILE_NAME = "resources/common/SapNetWeaverPage.Properties";
	 private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	 public final static String TitleNames[] = {"Mr ","Mrs ","Miss ","Ms ","Dr ","AC Marshall ","Admiral ","Air Commodore ","Baron ","Baroness ","Bishop ","Brigadier ","Captain ","Chief ",
		 										"Chief Rabbi ","Colonel ", "Colour Sergeant ","Commander ","Commodore ","Corporal ","Councillor ","Countess ","Dame ","Earl ","Father ","Flight Lt ",
		 										"General ","Group Captain ","Inspector ","Judge ","Lady ","Lance Corporal ","Lieutenant ","Lord ","Lt Colonel ","Lt Commander ","Lt General ","MP ",
		 										"Major ","Major General ","Mother Superior ","None ","P.C.","Prince ","Principal ","Private ","Professor ","Rabbi ","Rear Admiral ","Reverend ",
		 										"Reverend Mother","Right Reverend","Second Lt","Sergeant","Sheikh","Sir","Sister","Sister Superior","Squadron Leader","Staff Sergeant",
		 										"Sub-Lieutenant ","The ","The Right Hon ","Vice Admiral ","Viscount ","Viscountess ","Warrant Officer ","Wing Commander ","Mr & Mrs"};
	
	 
	 public boolean executeSAPCRM(UserProfile userProfile){
		 String TimeStamp="";
		 CRMExecutionDataProfile CRMExecutionData = new TestDataHelper().getCRMExecutionDataProfile(userProfile.getBusinessPartnerID());
		 TimeStamp = Calendar.getInstance().toString();
		 DayofTheYear = TimeStamp.substring(TimeStamp.indexOf("DAY_OF_YEAR"), TimeStamp.indexOf(",DAY_OF_WEEK")).replace("DAY_OF_YEAR=", "");
		 Hour = TimeStamp.substring(TimeStamp.indexOf("HOUR_OF_DAY="),TimeStamp.indexOf(",MINUTE")).replace("HOUR_OF_DAY=", "");
		 Minute = TimeStamp.substring(TimeStamp.indexOf("MINUTE="),TimeStamp.indexOf(",SECOND=")).replace("MINUTE=", "");
		 BusinessPartnerID = userProfile.getBusinessPartnerID();
		 if(BusinessPartnerID.equalsIgnoreCase(CRMExecutionData.getBusinessPartnerId()) && DayofTheYear.equalsIgnoreCase(CRMExecutionData.getDayofTheYear()) && getTimeCalculation(CRMExecutionData) == true){
			 SapExecute = false;
		 }
		 else
		 {
			 SapExecute = true;
		 }
		 return SapExecute;
	 }
	 
	 public boolean getTimeCalculation(CRMExecutionDataProfile CRMExecutionData){
		 boolean EqualHour;
		 int localHour,localMinute;
		 localHour = Integer.parseInt(Hour);
		 localMinute = Integer.parseInt(Minute);
		 if((localHour - Integer.parseInt(CRMExecutionData.getHour())) > 1) {
			 EqualHour = false;
		 }
		 else if((localHour - Integer.parseInt(CRMExecutionData.getHour())== 1 ) && (localMinute - Integer.parseInt(CRMExecutionData.getMinute()) > 0)){
			 EqualHour = false;
		 }
		 else{
			 EqualHour = true;
		 }
		 return EqualHour;
	 }
	 
	 public void openSapCRM(UserProfile userProfile){
		ReturnUrl = browser.getURL();
		loginSAP();
		navigateToAgentWorkBench();
		handleBrowserAlert();
		handleSystemNewsPopup();
		enterBusinessPartnerDetails(userProfile);
	}
	
	public void loginSAP(){
		browser.open(ApplicationConfig.SAPCRMUrl);
		browser.wait(getWaitTime());
		if(browser.isElementVisible(pageProperties.getProperty("SapnetWeaverPage.SapUserId"))){
			browser.input(pageProperties.getProperty("SapnetWeaverPage.SapUserId"), ApplicationConfig.SAPNetweaverUserID);
		}
		if(browser.isElementVisible(pageProperties.getProperty("SapnetWeaverPage.SapPassword"))){
			browser.input(pageProperties.getProperty("SapnetWeaverPage.SapPassword"), ApplicationConfig.SAPNetweaverPWD);
		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("SapnetWeaverPage.SapLoginButton"))){
			browser.clickWithXpath(pageProperties.getProperty("SapnetWeaverPage.SapLoginButton"));
		}
	}
	
	public void handleBrowserAlert(){
		browser.wait(5000);
		handleModalDialog();
	}
	
	public void handleModalDialog(){
		browser.wait(5000);
		browser.closeAlert();
	}
	
	public void navigateToAgentWorkBench(){
		if(browser.isElementVisibleWithXpath(".//*[@id='delete-session-cb-img']")){
			verifyAndClickWithXpath(".//*[@id='delete-session-cb-img']", "Existing session checkbox");
		}
		
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("SapnetWeaverPage.CancelSession"))){
			verifyAndClickWithXpath(pageProperties.getProperty("SapnetWeaverPage.CancelContinueButton"), "Cancel Status button");
		}
		
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("SapnetWeaverPage.SystemMessageContinueButton"))){
			verifyAndClickWithXpath(pageProperties.getProperty("SapnetWeaverPage.SystemMessageContinueButton"), "Click Login");
		}
		
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("SapnetWeaverPage.ZAWBDesk"))){
			verifyAndClickWithXpath(pageProperties.getProperty("SapnetWeaverPage.ZAWBDesk"), "Click Login");
		}
	}
	
	
	public String getHomeNumber(){
		String CompleteAddress = "";
		
			String[] SplitAddress;
			browser.wait(getWaitTime());
			CompleteAddress = browser.getTextByXpath(pageProperties.getProperty("SapnetWeaverPage.CompleteAddress"));
			SplitAddress = CompleteAddress.split(" ");
			homeNumber = SplitAddress[0];
			try{
					Integer.parseInt(homeNumber);
			}
			catch(java.lang.NumberFormatException numberException){
				homeNumber = "";
			}
			
		return homeNumber;
	}
	
	public String getPostCode(){
		String CompleteAddress;
		String[] SplitAddress;
		CompleteAddress = browser.getTextByXpath(pageProperties.getProperty("SapnetWeaverPage.CompleteAddress"));
		SplitAddress = CompleteAddress.split(" ");
		PostCode = SplitAddress[SplitAddress.length - 2] + " " + SplitAddress[SplitAddress.length - 1];
		return PostCode;
	}
	
	public String getName(String NameType){
		String Name= "";
		String FullName="";
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("SapnetWeaverPage.Name1"))){
			FullName = browser.getTextByXpath(pageProperties.getProperty("SapnetWeaverPage.Name1"));	
		}
		FullName = FullName.trim();
		if(FullName.equals("") && browser.isElementVisibleWithXpath(pageProperties.getProperty("SapnetWeaverPage.Name2"))){
			FullName = browser.getTextByXpath(pageProperties.getProperty("SapnetWeaverPage.Name2"));
		}
		FullName = FullName.trim();
		if(FullName.equals("") && browser.isElementVisibleWithXpath(pageProperties.getProperty("SapnetWeaverPage.Name3"))){
			FullName = browser.getTextByXpath(pageProperties.getProperty("SapnetWeaverPage.Name3"));
		}
		if (NameType.equalsIgnoreCase("TITLE") && !FullName.equals("")){
			for(int i=0; i < TitleNames.length ; i++){
				if(FullName.contains(TitleNames[i])){
					Name = TitleNames[i];
					Title = Name;
				}
			}
		}
		else if(NameType.equalsIgnoreCase("FIRSTNAME") && !FullName.equals("")){
			for(int i=0; i < TitleNames.length ; i++){
				if(FullName.contains(TitleNames[i])){
					FullName = FullName.replace(TitleNames[i], "");
				}
			}
			Name = FullName.substring(0, FullName.indexOf(" "));
			FirstName = Name;
		}
		else if(NameType.equalsIgnoreCase("LASTNAME") && !FullName.equals("")){
			for(int i=0; i < TitleNames.length ; i++){
				if(FullName.contains(TitleNames[i])){
					FullName = FullName.replace(TitleNames[i], "");
				}
			}
			Name = FullName.substring(FullName.lastIndexOf(" "));
			LastName = Name;
		}
		return Name;
		
	}
	
	
	public String getTelephoneType(){
		String PhoneType = browser.getTextByXpath(pageProperties.getProperty("SapnetWeaverPage.PhoneType"));
		if(PhoneType.contains("Work")){
			TelephoneType =  "Work";
		}
		else if(PhoneType.contains("Home")){
			TelephoneType =  "Home";
		}
		return TelephoneType;
	}
	
	public String getTelephoneNumber(){
		String PhoneNumber = browser.getTextByXpath(pageProperties.getProperty("SapnetWeaverPage.PhoneNumber1"));
		if(PhoneNumber.contains("A")){
			PhoneNumber = browser.getTextByXpath(pageProperties.getProperty("SapnetWeaverPage.PhoneNumber2"));
		}
		if(PhoneNumber.contains("A")){
			PhoneNumber = "";
		}
		TelephoneNumber = PhoneNumber;
		return PhoneNumber;
	}
	
		
	public void handleSystemNewsPopup(){
		browser.wait(7000);
		String ParentWindowHandle = browser.getWindowHandle();
		Set s = browser.getWindowHandles();
		Iterator i = s.iterator();
		while(i.hasNext()){
			String WindowHandle = i.next().toString();
			popup = browser.selectWindow(WindowHandle);
			if(popup.getTitle().equals("System News")){
				popup.close();
			}
		}
		browser.selectWindow(ParentWindowHandle);
		
	}
	
	public void enterBusinessPartnerDetails(UserProfile userProfile){
		WebDriverWait wait;
		browser.selectWindowByName("CRMApplicationFrame");
		browser.selectWindowById(3);
		browser.selectWindowByName("CRMApplicationFrame");
		browser.selectWindowByName("FRAME_APPLICATION");
		browser.selectWindowByName("WorkAreaFrame1");
		wait = new WebDriverWait(browser.getDriver(), 5);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("C11_W39_V40_V42_referenceNumberInput")));
		browser.wait(3000);
		browser.clickWithXpath(pageProperties.getProperty("SapnetWeaverPage.SearchBy"));
		verifyAndInputById(pageProperties.getProperty("SapnetWeaverPage.ReferenceNumber"), "Enter Refernce Number", userProfile.getAccNumber());
		//verifyAndInputById(pageProperties.getProperty("SapnetWeaverPage.ReferenceNumber"), "Enter Refernce Number", "3600367290");
		browser.clickWithLinkText(pageProperties.getProperty("SapnetWeaverPage.SearchLink"));
		browser.wait(3000);
		browser.click("C11_W39_V40_V42_ZL_ZWBCUSTF_MAINVS_IMPL=>CO_BP_REF_NRSearch");
		browser.wait(3000);
		handleModalDialog();
		browser.wait(3000);
		handleModalDialog();
	}
	 
	public void returnUrl(){
		browser.open(ReturnUrl);
	}
	
	public void updateCRMExecutionData(UserProfile userProfile) throws IOException{
		String LogPath = System.getProperty("user.dir");
		String[] UserData = new String[20];
		String temp="";
		int i = 1, UserDataCount= 0, UserDetailLocation = 0,j=1;
		boolean UserDetailPresent = false, UserDetailSetFlag = false;
		UserData[1] = "<entry>";
		UserData[2] = "<string>"+userProfile.getBusinessPartnerID()+"</string>";
		UserData[3] = "<CRMExecutionDataProfile>";
		UserData[4] = "<businesspartnerid>"+userProfile.getBusinessPartnerID()+"</businesspartnerid>";
		UserData[5] = "<dayoftheyear>"+DayofTheYear+"</dayoftheyear>";
		UserData[6] = "<hour>"+Hour+"</hour>";
		UserData[7] = "<minute>"+Minute+"</minute>";
		UserData[8] = "<title>"+Title+"</title>";
		UserData[9] = "<firtsname>"+FirstName+"</firtsname>";
		UserData[10] = "<lastname>"+LastName+"</lastname>";
		UserData[11] = "<homenumber>"+homeNumber+"</homenumber>";
		UserData[12] = "<postcode>"+PostCode+"</postcode>";
		UserData[13] = "<phonenumber>"+TelephoneNumber+"</phonenumber>";
		UserData[14] = "<phonetype>"+TelephoneType+"</phonetype>";
		UserData[15] = "</CRMExecutionDataProfile>";
		UserData[16] = "</entry>";
		
		BufferedReader reader = new BufferedReader(new FileReader(LogPath+"\\src\\resources\\TestData\\bgr\\CRMExecutionData.xml"));
		
		//Reading Data From XML file
		while(reader.read() != -1){
			temp = reader.readLine();
			if(!temp.contains("map")){
				CRMDataXml[i] = "<"+temp;
				i++;
			}
			
		}
		UserDataCount = i-1;
		reader.close();
		
		
		//Flush out Expired Data
		for(i = 1; i<= (UserDataCount); i++){
			if(CRMDataXml[i].contains("<hour>")){
				if((!CRMDataXml[i-1].contains(DayofTheYear)) || (Integer.parseInt(Hour) - Integer.parseInt(CRMDataXml[i].replace("<hour>", "").replace("</hour>", "")) > 1) || 
						((Integer.parseInt(Hour) - Integer.parseInt(CRMDataXml[i].replace("<hour>", "").replace("</hour>", "")) == 1 && Integer.parseInt(Minute) - Integer.parseInt(CRMDataXml[i+1].replace("<minute>", "").replace("</minute>", ""))> 1))){
					flushExpired(i);
				}
			}
		}
		
		
		// Replace the Current User Data in the place of expired data
		for(i = 1; i <= UserDataCount;i++){
			if(CRMDataXml[i] == ""){
				if(j<17){
					CRMDataXml[i]= UserData[j];
					UserDetailSetFlag = true;
					j++;
				}
				
			}
		}
		
		
		// Replace the CurrentData with userdata when the store limit exceeds
		if(UserDetailSetFlag == false && UserDataCount >150){
			for(i=1;i<19;i++){
				CRMDataXml[i]= UserData[i];
				UserDetailSetFlag = true;
			}
		}
		
		// Appends the user data
		if(UserDetailSetFlag == false && UserDataCount < 150){
			j=1;
			for(i=UserDataCount+1;i<=UserDataCount+16;i++){
				CRMDataXml[i]= UserData[j];
				UserDetailSetFlag = true;
				j++;
			}
		}
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(LogPath+"\\src\\resources\\TestData\\bgr\\CRMExecutionData.xml"));
		writer.append("<map>");
		writer.newLine();
		for(i=1; i<=160;i++){
			if(CRMDataXml[i] != "" && CRMDataXml[i] != null){
				writer.append(CRMDataXml[i]);
				writer.newLine();
			}
		}
		writer.append("</map>");
		writer.close();
		
	}
	
	public void flushExpired(int hourLocation){
		for(int i =hourLocation - 5;i <=(hourLocation+10);i++){
			CRMDataXml[i] = "";
		}
	}
	
		
	// SAP VALIDATIONS
	
	public String[] sapJourneyValidation(String BP){
		loginSAP();
		navigateToAgentWorkBench();
		handleBrowserAlert();
		handleSystemNewsPopup();
		
		WebDriverWait wait;
		browser.selectWindowByName("CRMApplicationFrame");
		browser.selectWindowById(3);
		browser.selectWindowByName("CRMApplicationFrame");
		browser.selectWindowByName("FRAME_APPLICATION");
		browser.selectWindowByName("WorkAreaFrame1");
		wait = new WebDriverWait(browser.getDriver(), 5);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("C11_W39_V40_V42_referenceNumberInput")));
		verifyAndInputById(pageProperties.getProperty("SapnetWeaverPage.ReferenceNumber"), "Enter Refernce Number", "3006556946");
		browser.clickWithXpath(pageProperties.getProperty("SapnetWeaverPage.SearchBy"));
		browser.clickWithLinkText(pageProperties.getProperty("SapnetWeaverPage.SearchLink"));
		browser.wait(3000);
		browser.click("C11_W39_V40_V42_ZL_ZWBCUSTF_MAINVS_IMPL=>CO_BP_REF_NRSearch");
		browser.wait(5000);
		handleModalDialog();
		browser.wait(5000);
		handleModalDialog();
		
		getEmail();
		
		//Invoking contact history validation
		String[] ContactHistory = new String[7];
		ContactHistory = contactHistoryValidation();
		
		return ContactHistory;
	}
	
	public String[] contactHistoryValidation(){
		browser.selectWindowByName("INH_IFRAME");
		browser.wait(5000);
		
		//Navigating to the contact history section
		String[] ContactHistory = new String[7];
		browser.clickWithXpath("//table[contains(@class,'x-grid-table')]/tbody/tr[2]/td[4]/div/span");
		browser.swtichToDefaultContent();
		browser.selectWindowByName("CRMApplicationFrame");
		browser.selectWindowById(3);
		browser.selectWindowByName("CRMApplicationFrame");
		browser.selectWindowByName("FRAME_APPLICATION");
		browser.selectWindowByName("WorkAreaFrame1");
		
		//Getting information from contact history
		ContactHistory[0] = browser.getTextByXpath(pageProperties.getProperty("SapnetWeaverPage.ContactUser"));
		ContactHistory[1] = browser.getTextByXpath(pageProperties.getProperty("SapnetWeaverPage.ContactReason1"));
		ContactHistory[2] = browser.getTextByXpath(pageProperties.getProperty("SapnetWeaverPage.ContactReason2"));
		ContactHistory[3] = browser.getTextByXpath(pageProperties.getProperty("SapnetWeaverPage.ContactReason3"));
		ContactHistory[5] = browser.getTextByXpath(pageProperties.getProperty("SapnetWeaverPage.ContactDate"));
		ContactHistory[6] = browser.getTextByXpath(pageProperties.getProperty("SapnetWeaverPage.ContactTime"));
		
		ContactHistory[4] = browser.getAttributeByXpath(pageProperties.getProperty("SapnetWeaverPage.ContactText"), "value");
		
		browser.clickWithXpath(pageProperties.getProperty("SapnetWeaverPage.ContactClose"));
		return ContactHistory;
	}
	
	
	
	public String getEmail(){
		return browser.getTextByXpath(pageProperties.getProperty("SapnetWeaverPage.Email"));
	}
	
	
}
