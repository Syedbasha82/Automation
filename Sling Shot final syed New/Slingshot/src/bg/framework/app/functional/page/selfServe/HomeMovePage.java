package bg.framework.app.functional.page.selfServe;

import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Calendar;

import com.jcraft.jsch.JSchException;

//import org.openqa.selenium.internal.selenesedriver.IsElementDisplayed;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.HomeMove;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.GlobalErrorMessages;
//import bg.framework.app.functional.page.services.OrderNowPage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SshClient;

public class HomeMovePage extends BasePage {
	 
	static Calendar now= Calendar.getInstance();
	static Calendar cldr;
	private final static String FILE_NAME = "resources/selfServe/HomeMove.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
    private HomeMove homeMove;

    public void navigateToMovingHome(String customerType)
	{
		if(browser.isTextPresent("Discover your account")){
			Report.updateTestLog("The Moving Home page is displayed", "PASS");
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.Discover"), "Discover");//--->comment coz running in 37, changed moving home property too
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.MovingHome"),"MovingHome");
		} else{
			Report.updateTestLog("The MovingHome page is not displayed", "FAIL");
		}
		if(customerType=="Existing")
		{
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.StartMoving"),"StartMovingHome");
	}
	}
	
	public void navigateToStartMovingHomeForAnonymous()
	{
		if(browser.isTextPresent("Moving home"))
		{
			Report.updateTestLog("The MovingHome page is displayed", "PASS");
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.StartMoving"),"StartMovingHome");	
		} else{
			Report.updateTestLog("The MoveOut page is not displayed", "FAIL");
		}
	}
		
	
	public ArrayList<Integer> gettingMovingDateFromCalendar(int day)
	{
		ArrayList<Integer> date=new ArrayList<Integer>();
		cldr=(Calendar)now.clone();
		cldr.add(Calendar.DATE,+day);
		int DateNow=cldr.get((Calendar.DATE));
		int MonthNow=cldr.get((Calendar.MONTH));
		int YearNow=cldr.get((Calendar.YEAR));
		
		date.add(DateNow);
		date.add(MonthNow);
		date.add(YearNow);
		assignDateToString(date);
		return date;
	}
	
	public ArrayList<String> assignDateToString(ArrayList<Integer> date2)
	{
		ArrayList<String> date1=new ArrayList<String>();
		String datestr;
		String month;
		String year;
		HashMap<Integer,String> monthstr=new HashMap<Integer,String>();
		monthstr.put(0, "January");
		monthstr.put(1, "February");
		monthstr.put(2, "March");
		monthstr.put(3, "April");
		monthstr.put(4, "May");
		monthstr.put(5, "June");
		monthstr.put(6, "July");
		monthstr.put(7, "August");
		monthstr.put(8, "September");
		monthstr.put(9, "October" );
		monthstr.put(10,"November");
		monthstr.put(11,"December");
		
		
		datestr=String.valueOf(date2.get(0));
		month=monthstr.get(date2.get(1));
		year=String.valueOf(date2.get(2));
		date1.add(datestr);
		date1.add(month);
		date1.add(year);
		
		return date1;
	}
	
	
	public void enterMoveOutDetails(HomeMove homeMove,int day)
	{      
		ArrayList<Integer> date=gettingMovingDateFromCalendar(day);
		ArrayList<String> date1=assignDateToString(date);
		if(browser.isTextPresent("Move out details")){ 
			Report.updateTestLog("The MoveOut details entry page is displayed", "PASS");
			verifyAndInputById(pageProperties.getProperty("HomeMove.MoveOutAccountNumber"),"AccountNumber", homeMove.getAccountNumber());
			verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.MoveOutDate"),"MoveOut Date", date1.get(0));
			verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.MoveOutMonth"),"MoveOut Month",date1.get(1));
			verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.MoveOutYear"),"MoveOut Year",date1.get(2));
			
			verifyAndInputById(pageProperties.getProperty("HomeMove.MoveOutPostCode"), "PostCode", homeMove.getPostCode());
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.MoveOutFindMyAddress"), "FindMyAddress");
			verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.AddressList"),"AddressList",homeMove.getAddress());
			
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.MoveOutAcceptAddress"), "AcceptAddress");
		} else{
			Report.updateTestLog("The MoveOut entry page page is not displayed", "FAIL");
		}
	}

	public void enterMoveOutDetailsForOAM(HomeMove homeMove,int day)
	{
		ArrayList<Integer> date=gettingMovingDateFromCalendar(day);
		ArrayList<String> date1=assignDateToString(date);
		
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.MoveOutDate"), "MoveOutDate", date1.get(0));
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.MoveOutMonth"), "MoveOutMonth", date1.get(1));
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.MoveOutYear"), "MoveOutYear",date1.get(2));
		
		String contactno= browser.getAttributeByXpath(pageProperties.getProperty("HomeMove.MoveOutContact"), "value");
		if(contactno.isEmpty()){
			Report.updateTestLog("The Contact information is not prepopulated", "PASS");
			verifyAndInputByXpath(pageProperties.getProperty("HomeMove.MoveOutContact"), "contactnumber", "01234567890");
		}
	}
	
	public void navigateToCloseAccountsPage()
	{
		verifyAndSelectCheckBoxByID(pageProperties.getProperty("HomeMove.NotResponsibleCheckBox"), "NotResponsible");
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.MoveOutContinue"), "Continue");
	}
	
	public void navigateToTransferAccountsPage()
	{
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.MoveOutContinue"), "Continue");
	}
	
	public void selectCloseAllAccounts()
	{
		if(browser.isTextPresent("Accounts to close")){
			Report.updateTestLog("The Accounts to close page is displayed", "PASS");
		}else{
			Report.updateTestLog("The Accounts to close page is not displayed", "FAIL");
		}
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.MoveOutCloseAll"), "close all");
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.MoveOutCloseAllContinue"), "Continue");
	}
	
	public void selectTransferAllAccounts()
	{
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.MoveOutTransferAll"), "Transfer all");
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.MoveOutTransferAllContinue"), "Continue");
	}
	public void selectAccountsToTransferAnonymous(HomeMove homeMove)
	{
		browser.selectfromDropBoxByXpath(pageProperties.getProperty("HomeMove.MissingProductSelect"), "HomeCare 100");
		verifyAndInputByXpath(pageProperties.getProperty("HomeMove.CustomerNumber"), "customer Membership Number", homeMove.getMembershipNumber1());
		verifyAndClick(pageProperties.getProperty("HomeMove.SpouseCheckBoxTransfer"),"Spouse Flag");
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.Transfer"),"Transfer");
		
		browser.selectfromDropBoxByXpath(pageProperties.getProperty("HomeMove.MissingProductSelect"), "HomeCare Flexi 100");
		verifyAndInputByXpath(pageProperties.getProperty("HomeMove.CustomerNumber"), "customer Membership Number", homeMove.getMembershipNumber2());
		verifyAndClick(pageProperties.getProperty("HomeMove.SpouseCheckBoxTransfer"),"Spouse Flag");
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.Transfer"),"Transfer");
		
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.MoveOutTransferAllContinue"), "Continue");
	}
	public void addMissingAccountsDetails(HomeMove homeMove)
	{
		browser.wait(2000);
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.MissingProducts"), "Missing Account");
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.MissingProducts"), "Missing Account");
		browser.wait(2000);
		browser.selectfromDropBoxByXpath(pageProperties.getProperty("HomeMove.MissingProductSelect"), "HomeCare 100");
		verifyAndInputByXpath(pageProperties.getProperty("HomeMove.CustomerNumber"), "customer Membership Number", homeMove.getMembershipNumber1());
		verifyAndClick(pageProperties.getProperty("HomeMove.SpouseCheckBoxTransfer"),"Spouse Flag");
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.AddMissingProducts"), "Add Product");
		
		browser.selectfromDropBoxByXpath(pageProperties.getProperty("HomeMove.MissingProductSelect"), "HomeCare Flexi 100");
		verifyAndInputByXpath(pageProperties.getProperty("HomeMove.CustomerNumber"), "customer Membership Number", homeMove.getMembershipNumber2());
		verifyAndClick(pageProperties.getProperty("HomeMove.SpouseCheckBoxTransfer"),"Spouse Flag");
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.AddMissingProducts"), "Add Product");
	}
	public void addAccountsToCloseForAnonymous(String accountTypeToClose,HomeMove homeMove)
	{
		browser.selectfromDropBoxByXpath(pageProperties.getProperty("HomeMove.MissingProductSelect"), accountTypeToClose);
		verifyAndInputByXpath(pageProperties.getProperty("HomeMove.CustomerNumber"), "AccountNumber", homeMove.getAccountsToClose());
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.CloseAccountAnonymous"),"Close");
	}
	public void navigateToMeterRead()
	{
		verifyAndClick(pageProperties.getProperty("HomeMove.ContinueCloseAcc"),"ContinueCloseAccounts");
	}
	public void enterMeterReading(String fuelType)
	{
		browser.wait(1000);
		String dialFieldsxPath="";
		if(fuelType=="Gas"||browser.isElementVisibleWithXpath(pageProperties.getProperty("HomeMove.DualGasMeterEntry"))){
			browser.wait(1000);
			dialFieldsxPath = pageProperties.getProperty("HomeMove.DualGasMeterDial");
			enterMoveOutMeterRead(dialFieldsxPath);
		}
		if(fuelType=="Electricity"||browser.isElementVisibleWithXpath(pageProperties.getProperty("HomeMove.DualElecMeterEntry"))){
			browser.wait(1000);
			dialFieldsxPath = pageProperties.getProperty("HomeMove.DualElecMeterDial");
			enterMoveOutMeterRead(dialFieldsxPath);
		}
		browser.wait(1000);
	}
	public void enterMoveOutMeterRead(String dialFieldsxPath)
	{
		int dialFieldCount = browser.getChildElementsCountByXpath(dialFieldsxPath);
		for (int i = 1; i <= dialFieldCount; i++) {
			if(browser.isElementVisibleWithXpath(dialFieldsxPath + "[" + i + "]"+"[@type='text']"))
			{
			verifyAndInputByXpath(dialFieldsxPath + "[" + i + "]"+"[@type='text']", "Fieldcount :"+i, "1");
			if(dialFieldCount==1)
			{
				browser.clearValueByXpath(dialFieldsxPath + "[" + i + "]"+"[@type='text']");
				verifyAndInputByXpath(dialFieldsxPath + "[" + i + "]"+"[@type='text']", "Fieldcount :"+i, "1234");
			}
			}	
		}	
	}
	
	public void selectRemindMeLaterForGasMeterRead()
	{
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.RemindLaterForGas"),"RemindLater" );
	}
	
	public void selectRemindMeLaterForElecMeterRead()
	{
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.RemindLaterForElectricity"),"RemindLater" );
		
	}
	
	public void navigateToForwardingAddressEntry()
	{
		if(browser.isElementVisible(pageProperties.getProperty("HomeMove.MeterReadContinue")))
		{
		verifyAndClick(pageProperties.getProperty("HomeMove.MeterReadContinue"), "Continue");
		}
	}
	
	public void enterForwardingAddressDetails(HomeMove homeMove)
	{
		verifyAndInputByXpath(pageProperties.getProperty("HomeMove.ForwardingPostCode"), "PostCode",homeMove.getForwardingPostCode());
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.ForwardingFindAddress"), "FindMyaddress");
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.MoveOutAddressList"), "Forwarding Address",homeMove.getForwardingAddress());
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.MoveOutAcceptAddress"), "Accept");
		
	}
	
	public void continueToAdditionalProductsPage()
	{
		browser.clickWithXpath(pageProperties.getProperty("HomeMove.ContinueMove"));
	}
	
	public void selectMarketingConsent()
	{
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("HomeMove.MarketingConsent")))
		{
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.MarketingConsent"), "MarketingConsent");
		}
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.MoveOutSubmit"), "Continue");
	}
	
	public void navigateToSubmitMoveOut()
	{
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.MoveOutSubmit"), "Continue");
	}
	
	public void navigateToMovingInOnly()
	{	
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("HomeMove.MovingInAnonymous"))){
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.MovingInAnonymous"),"MovingInOnly");
		Report.updateTestLog("The Movein object for Anonymous customer is clicked successfully", "PASS");
		}else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("HomeMove.MovingInOnly"))){
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.MovingInOnly"),"MovingInOnly");
		Report.updateTestLog("The Movein object for OAM customer is clicked successfully", "PASS");
		}else{
		Report.updateTestLog("The Movein object for OAM customer is not clicked", "FAIL");
		}
	}
	
	public void navigateToMovingInForAnonymousCustomer()
	{
		if(ApplicationConfig.BRAND.equalsIgnoreCase("BG"))	{
			browser.open(ApplicationConfig.APP_BG_URL+"/HomeMove/Home-Move-Services");
		} else {
			browser.open(ApplicationConfig.APP_FUSION_URL+"/HomeMove/Home-Move-Services");
		}
	}
	
	public void enterPersonalDetailsForAnonymousCustomer(HomeMove homeMove)
	{
		if(browser.isTextPresent("Your Personal details")){
			Report.updateTestLog("The personal details page is opened", "PASS");
		}else{
			Report.updateTestLog("The personal details page is not opened", "FAIL");
			}
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.PersonalTitle"),"Title",homeMove.getTitle());
		verifyAndInputById(pageProperties.getProperty("HomeMove.PersonalFirstName"),"FirstName",homeMove.getFirstName());
		verifyAndInputById(pageProperties.getProperty("HomeMove.PersonalMiddleName"),"MiddleName",homeMove.getMiddleName());
		verifyAndInputById(pageProperties.getProperty("HomeMove.PersonalSurName"),"SurName",homeMove.getSurName());
		verifyAndInputById(pageProperties.getProperty("HomeMove.PersonalContactNo"),"ContactNo",homeMove.getContactNo());
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.PersonalContactType"),"ContactType",homeMove.getContactType());
		verifyAndClickWithLinkText(pageProperties.getProperty("HomeMove.WhyINeedThis"),"Why do i need this");
		browser.wait(1000);
		if(browser.isElementVisible(pageProperties.getProperty("HomeMove.Notes"))){
			Report.updateTestLog("TheWhy do we need this notes is displayed","PASS");
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.NotesClose"), "Close Notes");
		}else{
			Report.updateTestLog("The why do we need this notes is not displayed", "FAIL");
			}
		browser.selectfromDropBoxByXpath(pageProperties.getProperty("HomeMove.PersonalDobDay"), homeMove.getDOBDay());
		browser.selectfromDropBoxByXpath(pageProperties.getProperty("HomeMove.PersonalDobMonth"), homeMove.getDOBMonth());
		browser.selectfromDropBoxByXpath(pageProperties.getProperty("HomeMove.PersonalDobYear"), homeMove.getDOBYear());
		verifyAndInputById(pageProperties.getProperty("HomeMove.PersonalEmail"),"EMail",homeMove.getEMail());
		verifyAndClick(pageProperties.getProperty("HomeMove.PersonalContinue"),"continue");
			
	}
	
	public void selectProductsCreateBundle()
	{
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("HomeMove.CreateBundle"))){
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.CreateBundle"),"CreateBundle");
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.BundleDual"),"DualBundle");
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.HomeCaref100"),"HomeCare's flexi100");
			browser.click(pageProperties.getProperty("HomeMove.SelectOrder"));
			Report.updateTestLog("The bundle details are selected successfully","Pass");
		} else {
            Report.updateTestLog("Select Bundle object is not Present in the application", "FAIL");
		}
	}
	
	public void enterMovingInDetails(HomeMove homeMove,int day)
	{
		ArrayList<Integer> date=gettingMovingDateFromCalendar(day);
		ArrayList<String> date1=assignDateToString(date);

		verifyAndSelectDropDownBox( pageProperties.getProperty("HomeMove.DayCheckBox"),"Date",date1.get(0));
		verifyAndSelectDropDownBox( pageProperties.getProperty("HomeMove.MonthCheckBox"),"month",date1.get(1));
		verifyAndSelectDropDownBox( pageProperties.getProperty("HomeMove.YearCheckBox"),"year",date1.get(2));
		Report.updateTestLog("The date of move is entered" ,"Pass");	
		verifyAndInputById(pageProperties.getProperty("HomeMove.PostCode"),"Postcode",homeMove.getPostCode());
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.MoveInFindAddress"),"FindAddress");
	}

	public void errorMessageForMoveInDateOutOfLimit()
	{
		if(browser.isElementVisible(pageProperties.getProperty("HomeMove.ErrorMsg"))){
			Report.updateTestLog("The Move In date out of limit error message is displayed", "PASS");
		} else{
			Report.updateTestLog("The Move In date out of limit error message is Not displayed", "FAIL");	
			}
	}
	
	public void selectMoveInAddress(HomeMove homeMove)
	{
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.AddressList"), "AddressList",homeMove.getAddress());
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.AcceptAddress"),"AcceptAddress");
		browser.clickWithXpath(pageProperties.getProperty("HomeMove.ContinueMove"));
	}

	public void selectMoveInAddressWithDifferentBillAddress(HomeMove homeMove)
	{
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.AddressList"), "AddressList",homeMove.getAddress());
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.AcceptAddress"),"AcceptAddress");
	}
		
	public void homeMoveaddressNotListed(HomeMove homeMove){
		browser.clickWithLinkText("If you can't see your address above, click here.");
		Report.updateTestLog("The personal details page is opened successfully" ,"Pass");
		verifyAndInputById(pageProperties.getProperty("HomeMove.HouseNumber"), "HouseNumber", homeMove.getHouseNumber());
		verifyAndInputById(pageProperties.getProperty("HomeMove.HouseName"),"HouseName", homeMove.getHouseName());
		verifyAndInputById(pageProperties.getProperty("HomeMove.FlatName"),"FlatNumber", homeMove.getFlatNumber());
		verifyAndInputById(pageProperties.getProperty("HomeMove.AddressLine1"),"AddressLine1", homeMove.getAddressLine1());
		verifyAndInputById(pageProperties.getProperty("HomeMove.AddressLine2"), "AddressLine2",homeMove.getAddressLine2());
		
		verifyAndInputById(pageProperties.getProperty("HomeMove.City"),"City/Town" ,homeMove.getTown());
		browser.selectfromDropBoxByXpath(pageProperties.getProperty("HomeMove.Country"), homeMove.getCountry());
		verifyAndInputById(pageProperties.getProperty("HomeMove.PostCodeSearch"),"Postcode" ,homeMove.getPostCode());
		Report.updateTestLog("The address is entered successfully" ,"Pass");
		verifyAndClick(pageProperties.getProperty("HomeMove.SubmitAddress"),"Continue");
		
		browser.clickWithXpath(pageProperties.getProperty("HomeMove.ContinueMove"));
	}
		
	public void previousAddressNotListed(HomeMove homeMove,int noPrevAddress){
		int count=0;
		do
		{
			if(count==1){
				homeMove.setPostCode(homeMove.getPostCode2());
				enterPreviousAddressHistory(homeMove);
			} else if(count==2){
				homeMove.setPostCode(homeMove.getPostCode3());
				enterPreviousAddressHistory(homeMove);
			}		
			browser.wait(1000);
			browser.clickWithLinkText("If you can't see your address above, click here.");
			browser.wait(1000);	
			Report.updateTestLog("The personal details page is opened successfully" ,"Pass");
			verifyAndInputById(pageProperties.getProperty("HomeMove.HouseNumber"), "HouseNumber", homeMove.getHouseNumber());
			verifyAndInputById(pageProperties.getProperty("HomeMove.HouseName"),"HouseName", homeMove.getHouseName());
			verifyAndInputById(pageProperties.getProperty("HomeMove.FlatName"),"FlatNumber", homeMove.getFlatNumber());
			verifyAndInputById(pageProperties.getProperty("HomeMove.AddressLine1"),"AddressLine1", homeMove.getAddressLine1());
			verifyAndInputById(pageProperties.getProperty("HomeMove.AddressLine2"), "AddressLine2",homeMove.getAddressLine2());
			
			verifyAndInputById(pageProperties.getProperty("HomeMove.City"),"City/Town" ,homeMove.getTown2());
			browser.selectfromDropBoxByXpath(pageProperties.getProperty("HomeMove.Country"),homeMove.getCountry());
			verifyAndInputById(pageProperties.getProperty("HomeMove.PostCodeSearch"),"Postcode" ,homeMove.getPostCode());
			Report.updateTestLog("The address is entered successfully" ,"Pass");
			verifyAndClick(pageProperties.getProperty("HomeMove.SubmitAddress"),"Continue");
			
			count++;
	
			switch(noPrevAddress)
			{
			case 1:
				verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.YearsLived"),"YearsLived",homeMove.getYearsLived());
				verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.monthsLived"),"MonthsLived",homeMove.getMonthsLived());
				break;
			case 2:
				verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.YearsLived"),"YearsLived",homeMove.getYearsLived2());
				verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.monthsLived"),"MonthsLived",homeMove.getMonthsLived());
				break;
			case 3:
				verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.YearsLived"),"YearsLived",homeMove.getYearsLived3());
				verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.monthsLived"),"MonthsLived",homeMove.getMonthsLived());
				break;
			default:
				break;
			}	
			
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("HomeMove.AddressHistoryContinue"))){
				verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.AddressHistoryContinue"),"AddressHistoryContinue");
			} else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("HomeMove.AddressHistoryContinue2"))){
				verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.AddressHistoryContinue2"),"AddressHistoryContinue2");
				}
		}while(browser.isTextPresent("Your address history"));
	}
	

	
	public void sendBillToAntherAddress(HomeMove homeMove){
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.SendToAnother"),"SendbilltoAnotherAddress");
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.AdditionalInfo"),"PersonNameMovingOut");
		verifyAndInputById(pageProperties.getProperty("HomeMove.PersonMovingOut"), "PersonName", homeMove.getPersonMovingOut());
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.ContinueMove"),"Continue");
		verifyAndInputById(pageProperties.getProperty("HomeMove.BillPostCode"),"Postcode",homeMove.getBillPostCode());
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.BillFindAddress"),"FindAddress");
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.AddressList"),"BillingAddress",homeMove.getBillingAddress());
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.BillAcceptAddress"),"AcceptAddress");
		
		Report.updateTestLog("The billing address is selected and accepted" ,"Pass");
		verifyAndClick(pageProperties.getProperty("HomeMove.BillContinue"), "Continue");
	}
		
	public void enterPreviousAddressHistory(HomeMove homeMove){
		browser.inputByXpath(pageProperties.getProperty("HomeMove.HistoryPostCode"), homeMove.getPostCode());
		
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.HistoryFindAddress"),"FindAddress");
		Report.updateTestLog("Find my address Object for address history is clicked successfully" ,"Pass");
	}

	public void selectNumberPreviousAddresses(HomeMove homeMove,int noaddress){
		for(int i=0;i<noaddress;i++)
		{
			switch(i)
			{
			case 0:
				browser.wait(1000);
				verifyAndSelectDropDownBox( pageProperties.getProperty("HomeMove.AddressList"),"AddressList",homeMove.getAddress2());
				break;
			case 1:
				enterPreviousAddressHistory(homeMove);
				browser.wait(1000);
				verifyAndSelectDropDownBox( pageProperties.getProperty("HomeMove.AddressList"),"AddressList",homeMove.getAddress3());
				break;
			case 2:
				enterPreviousAddressHistory(homeMove);
				browser.wait(1000);
				verifyAndSelectDropDownBox( pageProperties.getProperty("HomeMove.AddressList"),"AddressList",homeMove.getAddress4());
				break;
			default:
				break;
			}
			
			if(noaddress==3){
				verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.YearsLived"),"YearsLived",homeMove.getYearsLived3());
				verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.monthsLived"),"MonthsLived",homeMove.getMonthsLived());
				}
			else if(noaddress==2){
				verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.YearsLived"),"YearsLived",homeMove.getYearsLived2());
				verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.monthsLived"),"MonthsLived",homeMove.getMonthsLived());
				}
			else if(noaddress==1){
				verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.YearsLived"),"YearsLived",homeMove.getYearsLived());
				verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.monthsLived"),"MonthsLived",homeMove.getMonthsLived());
				}
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.AddressHistoryContinue"),"AddressHistoryContinue");
		}
	}
	
	public void unselectContactExistingSuppliers()
	{
		if(browser.isSelected(pageProperties.getProperty("HomeMove.ContactSupplier"))){
			Report.updateTestLog("The contact existing suppliers checkbox is Present", "PASS");
			browser.click(pageProperties.getProperty("HomeMove.ContactSupplier"));
		}
		else{
			Report.updateTestLog("The contact existing suppliers checkbox is already in unchecked state", "FAIL");
		}
	}
	
	
	public void selectProductsMovingInBundle()
	{
		if(browser.isTextPresent("Moving In bundle"))
		{
			Report.updateTestLog("The select products page is displayed", "PASS");
			if(browser.isSelected(pageProperties.getProperty("HomeMove.ContactSupplier")))
			{Report.updateTestLog("The contact existing suppliers checkbox is checked", "PASS");}
			else
			{Report.updateTestLog("The contact existing suppliers checkbox is unchecked", "PASS");}
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.OrderNow"),"MovingInBundle");			
			}
		else{
			Report.updateTestLog("The select products page is not displayed", "FAIL");
		}
	}
	
		
	public void selectPaymentTypeDirectDebit(){
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.PaymentDebit"),"Direct Debit");
		Report.updateTestLog("The PaymentPreference DIRECT DEBIT is given successfully", "PASS");
		browser.click(pageProperties.getProperty("HomeMove.PaymentOptionContinue"));
	}
	
	public void selectDirectDebitAndunselectPaperLessBilling(){
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.PaymentDebit"),"Direct Debit");
		Report.updateTestLog("The PaymentPreference DIRECT DEBIT is given successfully", "PASS");
		if(browser.isSelectedByXpath(pageProperties.getProperty("HomeMove.PaperlessBilling"))){
			browser.wait(2000);
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.PaperlessBilling"),"PaperLessBilling");
			} else{
			Report.updateTestLog("The PaperlessBillingIsNotSelected","FAIL");
			}
			browser.wait(1000);
			browser.click(pageProperties.getProperty("HomeMove.PaymentOptionContinue"));
	}
	
	public void selectPaymentTypeDifferentPayment(){
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.PaymentDiffernt"),"Different payment option");
		Report.updateTestLog("The PaymentPreference DIFFERENT PAYMENT OPTION is selected successfully", "PASS");
		browser.click(pageProperties.getProperty("HomeMove.PaymentOptionContinue"));
	}
	
	public void paymentOptionsForDualAndHomeServices(){
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.PayDualQuarterlyDirect"),"QuarterlyDirect");
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.PayHomeServicesMonthlyDirect"),"MonthlyDirect");
		browser.click(pageProperties.getProperty("HomeMove.CustomizedBundleContinue"));
	}
	
	public void paymentOptionsForGasElectricityAndHomeservices(){
		if(browser.isTextPresent("Payment options")){
			Report.updateTestLog("Payment options entry page is displayed", "PASS");
			}else{
			Report.updateTestLog("Payment options entry page is displayed", "PASS");}
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.PayGasMonthlyDirect"),"Monthly direct");
			
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.PayElectricityMonthlyDirect"),"Monthly direct");
			
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.PayHomeServicesAnnualCreditCard"),"MonthlyDirect");
			browser.wait(1000);
			verifyAndClick(pageProperties.getProperty("HomeMove.CustomizedBundleContinue"),"Continue");
	}
		
	public void enterMeterReadingForPostMoveCustomer(HomeMove homeMove){
		if(browser.isTextPresent("Your electricity meter")){
			verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.ElecMeterType"), "Electricity Meter Type", homeMove.getElecMeterType());
			verifyAndInputById(pageProperties.getProperty("HomeMove.ElecMeterReading"), "Electricity Reading", homeMove.getElecMeterReading());
			verifyAndInputById(pageProperties.getProperty("HomeMove.ElecMeterNightReading"), "Electricity Night Reading", homeMove.getElecNightReading());
			verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.GasMeterType"), "Gas Meter Type", homeMove.getGasMeterType());
			verifyAndInputById(pageProperties.getProperty("HomeMove.GasMeterReading"), "Gas Meter Reading", homeMove.getGasMeterReading());
			verifyAndClick(pageProperties.getProperty("HomeMove.MeterReadingContinue"), "Continue");
			} else{
			Report.updateTestLog("The meter Reading entering page is not displayed", "FAIL");
			}
	}
		
	public void enterBankDetailsForPayment(HomeMove homeMove){
			
  			while(browser.isElementVisible(pageProperties.getProperty("HomeMove.BankAccNumber"))){
  				verifyAndInputById(pageProperties.getProperty("HomeMove.BankAccNumber"),"BankAccountNumber", homeMove.getBankAccountNumber());
  				verifyAndInputById(pageProperties.getProperty("HomeMove.Sortcodea"),"Sortcode1",homeMove.getSortCode1());
  				verifyAndInputById(pageProperties.getProperty("HomeMove.Sortcodeb"),"SortCode2",homeMove.getSortCode2());
  				verifyAndInputById(pageProperties.getProperty("HomeMove.Sortcodec"),"SortCode3",homeMove.getSortCode3());
  				verifyAndInputById(pageProperties.getProperty("HomeMove.AccHolderName"),"AccountholderName",homeMove.getAccHolderName());
  				if(browser.isElementVisible(pageProperties.getProperty("HomeMove.PayDay"))){
				verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.PayDay"),"PaymentDate",homeMove.getPayDay());
  				}
  				verifyAndClick(pageProperties.getProperty("HomeMove.SecureContinue"),"Continue");
			}
			Report.updateTestLog("The Bank Account details are entered successfully", "PASS");		
	}
		
	public void enterAnnualCreditCardDetails(HomeMove homeMove){
			if(browser.isTextPresent("Annual Credit / Debit card for Home Services")){
				Report.updateTestLog("Credit/Debit Details entry page is displayed", "PASS");
				verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.AnnualCreditCardType"), "CardType", homeMove.getCardType());
				
				verifyAndInputById(pageProperties.getProperty("HomeMove.AnnualCreditHolderName"),"CardName",homeMove.getCardName());
				verifyAndInputById(pageProperties.getProperty("HomeMove.AnnualCreditCardNumber"),"CardNumber",homeMove.getCardNumber());
				verifyAndInputById(pageProperties.getProperty("HomeMove.AnnualCreditIssueNumber"),"IssueNumber",homeMove.getIssueNumber());
				
				
				verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.AnnualCreditStartMonth"),"StartMonth",homeMove.getStartMonth());
				verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.AnnualCreditStartYear"),"StartYear",homeMove.getStartYear());
				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("HomeMove.AnnualCreditExpiryMonth"))){
					Report.updateTestLog("The Expiry year and month are present in the application", "PASS");
					browser.selectfromDropBoxByXpath(pageProperties.getProperty("HomeMove.AnnualCreditExpiryMonth"), homeMove.getExpiryMonth());
					browser.selectfromDropBoxByXpath(pageProperties.getProperty("HomeMove.AnnualCreditExpiryYear"), homeMove.getExpiryYear());
				}
				
				verifyAndClick(pageProperties.getProperty("HomeMove.AnnualCreditContinue"), "Continue");
			} else{
				Report.updateTestLog("The Annual Credit/Debit Card detaisl entry page is not opened", "FAIL");
			}
	}
		
	public void enterUpgradingDetails(int flexiVal){
		if(flexiVal==200){
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.Flexi200"), "HomeCareFlexi200");
			} else if(flexiVal==300){
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.Flexi300"), "HomeCareFlexi300");
			}else if(flexiVal==400){
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.Flexi400"), "HomeCareFlexi400");
			}else if(flexiVal==0){
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.DontUpgrade"), "DontUpgrade");
			}
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.UpgradeContinue"), "Continue");
	}
	
	public void navigateToConfirmationPage(){
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.TermsCondition"),"Terms");
		verifyAndClick(pageProperties.getProperty("HomeMove.Submit"),"Submit");
		Report.updateTestLog("Home Move activity is done successfully", "PASS");
	}
		
	public void bankAccountDetailsErrorValidation(){
		String bankaccno[]={"","!@#","01234567","01234567","01234567","01234567","01234567","01234567"};
		String sortcode1[]={"40","40","","f","40","40","40","40"};
		String sortcode2[]={"40","40","","e","40","40","40","40"};
		String sortcode3[]={"40","40","","","40","40","40","40"};
		String accholdername[]={"dhiru","dhiru","dhiru","dhiru","","1@#","dhiru","dhiru"};
		String payDay[]={"9","27","9","9","9","9","Day","9"};
		
		for (int i=0;i<bankaccno.length;i++)
		{
			bankErrorDetailsEntry(bankaccno[i],sortcode1[i],sortcode2[i],sortcode3[i],accholdername[i],payDay[i]);
			verifyAndClick(pageProperties.getProperty("HomeMove.SecureContinue"), "Continue");
		
			switch(i)
			{
			case 0:
				verifyIsTextPresent(GlobalErrorMessages.Homemove_AccountNumberEmpty);
				break;
			case 1:
				verifyIsTextPresent(GlobalErrorMessages.Homemove_InvalidAccountNumber);
				break;
			case 2:
				verifyIsTextPresent(GlobalErrorMessages.Homemove_SortCodeEmpty);
				break;
			case 3:
				verifyIsTextPresent(GlobalErrorMessages.Homemove_InvalidSortCode);
				break;
			case 4:
				verifyIsTextPresent(GlobalErrorMessages.Homemove_AccountHolderNameEmpty);
				break;
			case 5:
				verifyIsTextPresent(GlobalErrorMessages.Homemove_InvalidAccountHolderName);
				break;
			case 6:
				verifyIsTextPresent(GlobalErrorMessages.Homemove_PreferredDayEmpty);
				break;
			case 7:
				break;
			
			default:
				break;
			}
		
		}
	}
	
	private void bankErrorDetailsEntry(String bankaccno,String sortcode1,String sortcode2,String sortcode3,String accholdername,String payDay){
		verifyAndInputById(pageProperties.getProperty("HomeMove.BankAccNumber"), "Account Number",bankaccno);
		verifyAndInputById(pageProperties.getProperty("HomeMove.Sortcodea"), "Sort Code",sortcode1);
		verifyAndInputById(pageProperties.getProperty("HomeMove.Sortcodeb"), "Sort Code",sortcode2);
		verifyAndInputById(pageProperties.getProperty("HomeMove.Sortcodec"), "Sort Code",sortcode3);
		verifyAndInputById(pageProperties.getProperty("HomeMove.AccHolderName"), "Account holder name",accholdername);
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.PayDay"),"Preferred payment day",payDay);
	}

	public void changeMoveOutDate(int changeDate,HomeMove homeMove){
			ArrayList<Integer> date=gettingMovingDateFromCalendar(changeDate);
			ArrayList<String> date1=assignDateToString(date);
			browser.open(ApplicationConfig.APP_BG_URL+"/HomeMove/MoveHomeTransferConfirmation/ChangeResponsibilityDates/");
//			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.ChangeMoveOutDate1"),"Change MoveOut Date");
			verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.MoveOutDate"),"MoveOut Date", date1.get(0));
			verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.MoveOutMonth"),"MoveOut Month",date1.get(1));
			verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.MoveOutYear"),"MoveOut Year",date1.get(2));
			
			navigateToTransferAccountsPage();
			selectTransferAllAccounts();
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.MoveOutContinue"),"Continue");
			verifyAndInputById(pageProperties.getProperty("HomeMove.BillPostCode"),"Postcode",homeMove.getBillPostCode());
			
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.BillFindAddress"),"FindAddress");
			verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMove.AddressList"),"BillingAddress",homeMove.getBillingAddress());
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.BillAcceptAddress"),"AcceptAddress");
			
			verifyAndClick(pageProperties.getProperty("HomeMove.BillContinue"), "Continue");
	}
	
	public void logoutHomeMovePage(){	
		
		verifyAndClickWithLinkText(pageProperties.getProperty("HomeMove.logoutLink"), "Logout");
			//verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.logout"),"Logout");
			Report.updateTestLog("Logout successfull", "PASS");
	}
	
	public void navigateToHome(){
		browser.wait(2000);
		if(browser.isTextPresent("Thank you")){
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.HomeLogo"), "HomeLogo");
			Report.updateTestLog("The back to home page object is clicked successfully", "PASS");
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("HomeMove.HelpLogout")))
			{
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.HelpLogout"),"Logout");
			}
		}else if(browser.isTextPresent("Complete another home move"))
		{
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.HomeLogo"), "HomeLogo");
			Report.updateTestLog("The back to home page object is clicked successfully", "PASS");
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("HomeMove.HelpLogout")))
			{
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.HelpLogout"),"Logout");
			}
		}
		else{
			Report.updateTestLog("The back to home page object is not clicked", "FAIL");
			}
	}
	
		
//------------------------------------------------------------LandLord-----------------------------------------------//
	public void navigateToLandlordMovingHome()
	{
		browser.open(ApplicationConfig.APP_BG_URL+"/HomeMove/StartHomeMoveagents/");
		//verifyAndClickWithXpath(pageProperties.getProperty("HomeMove.StartMovingLandLord"),"StartMovingHomeLandlord");
	}
	
	public void navigateToLandLordBusinessNature()
	{
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMoveLandLord.NatureBusiness"),"Select Landlord" ,"Landlords");
	}
	public void navigateToLettingAgentsBusinessNature()
	{
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMoveLandLord.NatureBusiness"),"Select Landlord" ,"Letting agents/Developers");
	}
	public void enterYourDetailsInLandLordMovingHome(HomeMove homeMove)
	{
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.CompanyName"), "CompanyName", homeMove.getCompanyName());
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMoveLandLord.Title"), "Title", homeMove.getTitle());
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.FirstName"), "FirstName", homeMove.getFirstName());
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.SurName"),"SurName",homeMove.getSurName());
		
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.CompanyAdd1"),"AddressLine 1",homeMove.getAddress());
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.CompanyAdd2"),"AddressLine 2",homeMove.getAddress2());
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.CompanyAdd3"),"AddressLine 3",homeMove.getAddress3());
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.PostCode"),"PostCode",homeMove.getPostCode());
		
		String emailPrepopulated=browser.getAttribute(pageProperties.getProperty("HomeMoveLandLord.Email"), "value");
		String PhonePrepopulated=browser.getAttribute(pageProperties.getProperty("HomeMoveLandLord.Phone"), "value");
		
		if(emailPrepopulated.isEmpty()){
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.Email"),"Email",homeMove.getEMail());
		}
		if(PhonePrepopulated.isEmpty()){
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.Phone"),"Phone",homeMove.getContactNo());
		}
		
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMoveLandLord.HMLLContinue"),"Continue");
	}
		
	public void enterSupplyAddressDetails(HomeMove homeMove)
	{
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.SupplyAddress1"),"SupplyAddress1",homeMove.getSupplyAddress1());
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.SupplyAddress2"),"SupplyAddress2",homeMove.getSupplyAddress2());
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.SupplyAddress3"),"SupplyAddress3",homeMove.getSupplyAddress3());
		
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.PostCode"),"PostCode",homeMove.getPostCode());
		
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMoveLandLord.HMLLContinue"),"Continue");
		
	}
	public void enterMoveHomeDetailsForLandLord(String ReadingType,int day,HomeMove homeMove)
	{
		ArrayList<Integer> date=gettingMovingDateFromCalendar(day);
		ArrayList<String> date1=assignDateToString(date);
		
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.CustomerReferenceNumber"),"CustomerReference",homeMove.getAccountNumber());
		if(!browser.isSelected(pageProperties.getProperty("HomeMoveLandLord.MoveOutUseBusinessDetails")))
		{
		verifyAndClick(pageProperties.getProperty("HomeMoveLandLord.MoveOutUseBusinessDetails"), "MovingOutBusinessDetails");
		}
		verifyandClickMOAddAccountHolder();
		enterYourDetailsMOAccountOne(homeMove);
		verifyandClickMOAddAccountHolder();
		enterYourDetailsMOAccountTwo(homeMove);
		verifyandClickMOAddAccountHolder();
		enterYourDetailsMOAccountThree(homeMove);
		
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMoveLandLord.MoveDate"), "Date", date1.get(0));
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMoveLandLord.MoveMonth"), "Month", date1.get(1));
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMoveLandLord.MoveYear"), "Year", date1.get(2));
		
		
		if(ReadingType=="Gas")
		{
			verifyAndClick(pageProperties.getProperty("HomeMoveLandLord.EnergySuppliedGas"), "GasOnly");
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.GasReading"),"GasReading",homeMove.getGasMeterReading());
		}
		if(ReadingType=="Electricity")
		{
			verifyAndClick(pageProperties.getProperty("HomeMoveLandLord.EnergySuppliedElec"), "ElectricityOnly");
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.ElecDayReading"),"ElecDayReading",homeMove.getElecMeterReading());
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.ElecNightReading"),"ElecNightReading",homeMove.getElecNightReading());
		}
		if(ReadingType=="Dual")
		{
			verifyAndClick(pageProperties.getProperty("HomeMoveLandLord.EnergySuppliedDual"), "Gas&Electricity");
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.GasReading"),"GasReading",homeMove.getGasMeterReading());
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.ElecDayReading"),"ElecDayReading",homeMove.getElecMeterReading());
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.ElecNightReading"),"ElecNightReading",homeMove.getElecNightReading());
		}
		
		if(!browser.isSelected(pageProperties.getProperty("HomeMoveLandLord.MoveInUseBusinessDetails")))
		{
		verifyAndClick(pageProperties.getProperty("HomeMoveLandLord.MoveInUseBusinessDetails"), "MovingInBusinessDetails");
		}
		verifyandClickMIAddAccountHolder();
		enterYourDetailsMIAccountOne(homeMove);
		verifyandClickMIAddAccountHolder();
		enterYourDetailsMIAccountTwo(homeMove);
		verifyandClickMIAddAccountHolder();
		enterYourDetailsMIAccountThree(homeMove);
		
		
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMoveLandLord.HMLLContinue"),"Continue");
		
	}
	public void enterDoubleAddAccountForLandLord(String ReadingType,int day,HomeMove homeMove)
	{
		ArrayList<Integer> date=gettingMovingDateFromCalendar(day);
		ArrayList<String> date1=assignDateToString(date);
		
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.CustomerReferenceNumber"),"CustomerReference",homeMove.getAccountNumber());
		if(!browser.isSelected(pageProperties.getProperty("HomeMoveLandLord.MoveOutUseBusinessDetails")))
		{
		verifyAndClick(pageProperties.getProperty("HomeMoveLandLord.MoveOutUseBusinessDetails"), "MovingOutBusinessDetails");
		}
		verifyandClickMOAddAccountHolder();
		enterYourDetailsMOAccountOne(homeMove);
		verifyandClickMOAddAccountHolder();
		enterYourDetailsMOAccountTwo(homeMove);
		
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMoveLandLord.MoveDate"), "Date", date1.get(0));
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMoveLandLord.MoveMonth"), "Month", date1.get(1));
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMoveLandLord.MoveYear"), "Year", date1.get(2));
		
		
		if(ReadingType=="Gas")
		{
			verifyAndClick(pageProperties.getProperty("HomeMoveLandLord.EnergySuppliedGas"), "GasOnly");
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.GasReading"),"GasReading",homeMove.getGasMeterReading());
		}
		if(ReadingType=="Electricity")
		{
			verifyAndClick(pageProperties.getProperty("HomeMoveLandLord.EnergySuppliedElec"), "ElectricityOnly");
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.ElecDayReading"),"ElecDayReading",homeMove.getElecMeterReading());
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.ElecNightReading"),"ElecNightReading",homeMove.getElecNightReading());
		}
		if(ReadingType=="Dual")
		{
			verifyAndClick(pageProperties.getProperty("HomeMoveLandLord.EnergySuppliedDual"), "Gas&Electricity");
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.GasReading"),"GasReading",homeMove.getGasMeterReading());
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.ElecDayReading"),"ElecDayReading",homeMove.getElecMeterReading());
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.ElecNightReading"),"ElecNightReading",homeMove.getElecNightReading());
		}
		
		if(!browser.isSelected(pageProperties.getProperty("HomeMoveLandLord.MoveInUseBusinessDetails")))
		{
		verifyAndClick(pageProperties.getProperty("HomeMoveLandLord.MoveInUseBusinessDetails"), "MovingInBusinessDetails");
		}
		verifyandClickMIAddAccountHolder();
		enterYourDetailsMIAccountOne(homeMove);
		verifyandClickMIAddAccountHolder();
		enterYourDetailsMIAccountTwo(homeMove);
		
		
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMoveLandLord.HMLLContinue"),"Continue");
		
	}
	
	public void enterSingleAddAccountForLandLord(String ReadingType,int day,HomeMove homeMove)
	{
		ArrayList<Integer> date=gettingMovingDateFromCalendar(day);
		ArrayList<String> date1=assignDateToString(date);
		
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.CustomerReferenceNumber"),"CustomerReference",homeMove.getAccountNumber());
		if(!browser.isSelected(pageProperties.getProperty("HomeMoveLandLord.MoveOutUseBusinessDetails")))
		{
		verifyAndClick(pageProperties.getProperty("HomeMoveLandLord.MoveOutUseBusinessDetails"), "MovingOutBusinessDetails");
		}
		verifyandClickMOAddAccountHolder();
		enterYourDetailsMOAccountOne(homeMove);
		
		
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMoveLandLord.MoveDate"), "Date", date1.get(0));
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMoveLandLord.MoveMonth"), "Month", date1.get(1));
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMoveLandLord.MoveYear"), "Year", date1.get(2));
		
		
		if(ReadingType=="Gas")
		{
			verifyAndClick(pageProperties.getProperty("HomeMoveLandLord.EnergySuppliedGas"), "GasOnly");
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.GasReading"),"GasReading",homeMove.getGasMeterReading());
		}
		if(ReadingType=="Electricity")
		{
			verifyAndClick(pageProperties.getProperty("HomeMoveLandLord.EnergySuppliedElec"), "ElectricityOnly");
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.ElecDayReading"),"ElecDayReading",homeMove.getElecMeterReading());
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.ElecNightReading"),"ElecNightReading",homeMove.getElecNightReading());
		}
		if(ReadingType=="Dual")
		{
			verifyAndClick(pageProperties.getProperty("HomeMoveLandLord.EnergySuppliedDual"), "Gas&Electricity");
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.GasReading"),"GasReading",homeMove.getGasMeterReading());
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.ElecDayReading"),"ElecDayReading",homeMove.getElecMeterReading());
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.ElecNightReading"),"ElecNightReading",homeMove.getElecNightReading());
		}
		
		if(!browser.isSelected(pageProperties.getProperty("HomeMoveLandLord.MoveInUseBusinessDetails")))
		{
		verifyAndClick(pageProperties.getProperty("HomeMoveLandLord.MoveInUseBusinessDetails"), "MovingInBusinessDetails");
		}
		verifyandClickMIAddAccountHolder();
		enterYourDetailsMIAccountOne(homeMove);
		
		
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMoveLandLord.HMLLContinue"),"Continue");
		
	}
	
	public void enterThreeAddAccountWithoutMOMIForLandLord(String ReadingType,int day,HomeMove homeMove)
	{
		ArrayList<Integer> date=gettingMovingDateFromCalendar(day);
		ArrayList<String> date1=assignDateToString(date);
		
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.CustomerReferenceNumber"),"CustomerReference",homeMove.getAccountNumber());
		
		verifyandClickMOAddAccountHolder();
		enterYourDetailsMOAccountOne(homeMove);
		verifyandClickMOAddAccountHolder();
		enterYourDetailsMOAccountTwo(homeMove);
		verifyandClickMOAddAccountHolder();
		enterYourDetailsMOAccountThree(homeMove);
		
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMoveLandLord.MoveDate"), "Date", date1.get(0));
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMoveLandLord.MoveMonth"), "Month", date1.get(1));
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMoveLandLord.MoveYear"), "Year", date1.get(2));
		
		
		if(ReadingType=="Gas")
		{
			verifyAndClick(pageProperties.getProperty("HomeMoveLandLord.EnergySuppliedGas"), "GasOnly");
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.GasReading"),"GasReading",homeMove.getGasMeterReading());
		}
		if(ReadingType=="Electricity")
		{
			verifyAndClick(pageProperties.getProperty("HomeMoveLandLord.EnergySuppliedElec"), "ElectricityOnly");
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.ElecDayReading"),"ElecDayReading",homeMove.getElecMeterReading());
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.ElecNightReading"),"ElecNightReading",homeMove.getElecNightReading());
		}
		if(ReadingType=="Dual")
		{
			verifyAndClick(pageProperties.getProperty("HomeMoveLandLord.EnergySuppliedDual"), "Gas&Electricity");
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.GasReading"),"GasReading",homeMove.getGasMeterReading());
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.ElecDayReading"),"ElecDayReading",homeMove.getElecMeterReading());
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.ElecNightReading"),"ElecNightReading",homeMove.getElecNightReading());
		}
		
		
		verifyandClickMIAddAccountHolder();
		enterYourDetailsMIAccountOne(homeMove);
		verifyandClickMIAddAccountHolder();
		enterYourDetailsMIAccountTwo(homeMove);
		verifyandClickMIAddAccountHolder();
		enterYourDetailsMIAccountThree(homeMove);
		
		
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMoveLandLord.HMLLContinue"),"Continue");
		
	}
	public void enterDoubleAddAccountWithoutMOMIForLandLord(String ReadingType,int day,HomeMove homeMove)
	{
		ArrayList<Integer> date=gettingMovingDateFromCalendar(day);
		ArrayList<String> date1=assignDateToString(date);
		
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.CustomerReferenceNumber"),"CustomerReference",homeMove.getAccountNumber());
		
		verifyandClickMOAddAccountHolder();
		enterYourDetailsMOAccountOne(homeMove);
		verifyandClickMOAddAccountHolder();
		enterYourDetailsMOAccountTwo(homeMove);
		
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMoveLandLord.MoveDate"), "Date", date1.get(0));
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMoveLandLord.MoveMonth"), "Month", date1.get(1));
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMoveLandLord.MoveYear"), "Year", date1.get(2));
		
		
		if(ReadingType=="Gas")
		{
			verifyAndClick(pageProperties.getProperty("HomeMoveLandLord.EnergySuppliedGas"), "GasOnly");
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.GasReading"),"GasReading",homeMove.getGasMeterReading());
		}
		if(ReadingType=="Electricity")
		{
			verifyAndClick(pageProperties.getProperty("HomeMoveLandLord.EnergySuppliedElec"), "ElectricityOnly");
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.ElecDayReading"),"ElecDayReading",homeMove.getElecMeterReading());
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.ElecNightReading"),"ElecNightReading",homeMove.getElecNightReading());
		}
		if(ReadingType=="Dual")
		{
			verifyAndClick(pageProperties.getProperty("HomeMoveLandLord.EnergySuppliedDual"), "Gas&Electricity");
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.GasReading"),"GasReading",homeMove.getGasMeterReading());
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.ElecDayReading"),"ElecDayReading",homeMove.getElecMeterReading());
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.ElecNightReading"),"ElecNightReading",homeMove.getElecNightReading());
		}
		
		
		verifyandClickMIAddAccountHolder();
		enterYourDetailsMIAccountOne(homeMove);
		verifyandClickMIAddAccountHolder();
		enterYourDetailsMIAccountTwo(homeMove);
		
		
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMoveLandLord.HMLLContinue"),"Continue");
		
	}
	
	public void enterSingleAddAccountWithoutMOMIForLandLord(String ReadingType,int day,HomeMove homeMove)
	{
		ArrayList<Integer> date=gettingMovingDateFromCalendar(day);
		ArrayList<String> date1=assignDateToString(date);
		
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.CustomerReferenceNumber"),"CustomerReference",homeMove.getAccountNumber());
		
		verifyandClickMOAddAccountHolder();
		enterYourDetailsMOAccountOne(homeMove);
		
		
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMoveLandLord.MoveDate"), "Date", date1.get(0));
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMoveLandLord.MoveMonth"), "Month", date1.get(1));
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMoveLandLord.MoveYear"), "Year", date1.get(2));
		
		
		if(ReadingType=="Gas")
		{
			verifyAndClick(pageProperties.getProperty("HomeMoveLandLord.EnergySuppliedGas"), "GasOnly");
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.GasReading"),"GasReading",homeMove.getGasMeterReading());
		}
		if(ReadingType=="Electricity")
		{
			verifyAndClick(pageProperties.getProperty("HomeMoveLandLord.EnergySuppliedElec"), "ElectricityOnly");
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.ElecDayReading"),"ElecDayReading",homeMove.getElecMeterReading());
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.ElecNightReading"),"ElecNightReading",homeMove.getElecNightReading());
		}
		if(ReadingType=="Dual")
		{
			verifyAndClick(pageProperties.getProperty("HomeMoveLandLord.EnergySuppliedDual"), "Gas&Electricity");
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.GasReading"),"GasReading",homeMove.getGasMeterReading());
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.ElecDayReading"),"ElecDayReading",homeMove.getElecMeterReading());
			verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.ElecNightReading"),"ElecNightReading",homeMove.getElecNightReading());
		}
		
		verifyandClickMIAddAccountHolder();
		enterYourDetailsMIAccountOne(homeMove);
		
		
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMoveLandLord.HMLLContinue"),"Continue");
		
	}
	
	public void editDetailsForLandLordHomeMove(HomeMove homeMove,int moveOutDate,String detailsToEdit)
	{
		if(detailsToEdit=="YourDetails"||detailsToEdit=="EditAll")
		{
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMoveLandLord.EditYourDetails"), "EditYourDetails");
			if(browser.isTextPresent("Landlords & letting agents"))
			{
				Report.updateTestLog("The your Details page is displayed in the application", "PASS");
			}else{
				Report.updateTestLog("The your Details page is not displayed in the application", "FAIL");
			}
			enterYourDetailsInLandLordMovingHome(homeMove);
			enterSupplyAddressDetails(homeMove);
			enterMoveHomeDetailsForLandLord("Electricity",moveOutDate,homeMove);
		}
		
		if(detailsToEdit=="SupplyAddress"||detailsToEdit=="EditAll")
		{
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMoveLandLord.EditSupplyAddress"), "EditSupplyAddress");
			if(browser.isTextPresent("Please enter the details of the property where the move took place"))
			{
				Report.updateTestLog("The SupplyAddress is displayed in the application", "PASS");
			}else{
				Report.updateTestLog("The SupplyAddress is not displayed in the application", "FAIL");
			}
			enterSupplyAddressDetails(homeMove);
			enterMoveHomeDetailsForLandLord("Electricity",moveOutDate,homeMove);
		}
		if(detailsToEdit=="MovingOut"||detailsToEdit=="EditAll")
		{
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMoveLandLord.EditMovingOut"), "EditMovingOut");
			if(browser.isTextPresent("Energy supplied to address you're leaving"))
			{
				Report.updateTestLog("The MovingOut Details page is displayed in the application", "PASS");
			}else{
				Report.updateTestLog("The MovingOut Details page is not displayed in the application", "FAIL");
			}
			enterMoveHomeDetailsForLandLord("Electricity",moveOutDate,homeMove);
		}
		if(detailsToEdit=="ForwardingAddress"||detailsToEdit=="EditAll")
		{
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMoveLandLord.EditForwardingAddress"), "EditForwardingAddress");
			if(browser.isTextPresent("Your forwarding address"))
			{
				Report.updateTestLog("The ForwardingAddress is displayed in the application", "PASS");
			}else{
				Report.updateTestLog("The ForwardingAddress is not displayed in the application", "FAIL");
			}
			enterMoveHomeDetailsForLandLord("Electricity",moveOutDate,homeMove);
		}
		if(detailsToEdit=="DateOfMove"||detailsToEdit=="EditAll")
		{
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMoveLandLord.EditDateOfMove"), "EditDateOfMove");
			if(browser.isTextPresent("Date of move"))
			{
				Report.updateTestLog("The DateOfMove is displayed in the application", "PASS");
			}else{
				Report.updateTestLog("The DateOfMove is not displayed in the application", "FAIL");
			}
			enterMoveHomeDetailsForLandLord("Electricity",moveOutDate,homeMove);
		}
		if(detailsToEdit=="MovingIn"||detailsToEdit=="EditAll")
		{
			verifyAndClickWithXpath(pageProperties.getProperty("HomeMoveLandLord.EditMovingIn"), "EditMovingIn");
			if(browser.isTextPresent("Moving in"))
			{
				Report.updateTestLog("The MovingIn Details page is displayed in the application", "PASS");
			}else{
				Report.updateTestLog("The MovingIn Details page is not displayed in the application", "FAIL");
			}
			enterMoveHomeDetailsForLandLord("Electricity",moveOutDate,homeMove);
		}
	}
	
	public void homeMoveLandLordConfirmationPage()
	{
		verifyAndClick(pageProperties.getProperty("HomeMoveLandLord.TermsAgree"),"Terms Agree");
		verifyAndClickWithXpath(pageProperties.getProperty("HomeMoveLandLord.HMLLContinue"),"Continue");
		
	} 
	public void runBatch(String sysdate,String batchType,UserProfile userProfile)
	{
		SshClient sshClient=new SshClient();
		int iteration=0;
		
		do{
			try {
			sshClient.connect();
				if(sshClient.isConnected())
				{
					sshClient.send("cd scripts");
					Thread.sleep(10000);
					if(iteration==0)
					{
						sshClient.send("./doenergyhomemove.sh");
						Thread.sleep(25000);
						sshClient.send("clear");
						Thread.sleep(5000);
						sshClient.send("cd /shared/online/datafiles/outbound/energyhomemove/archive");
						
					}else if(iteration==1)
					{
						sshClient.send("./doservicesmovein.sh");
						Thread.sleep(25000);
						sshClient.send("clear");
						Thread.sleep(5000);
						sshClient.send("cd /shared/online/datafiles/outbound/servicesmovein/archive");
					}
			
			
					String directoryFiles=sshClient.send("ls -l").toString();
					String listDirFiles[]=directoryFiles.split("\n");
					
					Thread.sleep(10000);
					ArrayList<String> csvFiles=new ArrayList<String>();
					for(String file:listDirFiles)
					{
						file=file.trim();
						if(file.endsWith("csv"))
						{
							csvFiles.add(file);
						}
					}
					Thread.sleep(10000);
					String fileName=csvFiles.get(csvFiles.size()-1);
			
					if(iteration==0){
						fileName=fileName.substring(fileName.indexOf("eforms"));
						
					}else if(iteration==1)
					{fileName=fileName.substring(fileName.indexOf("2012"));}
					Thread.sleep(10000);
					String fileContent=sshClient.send("cat "+fileName);
					Thread.sleep(10000);
					if(fileContent.contains("Lead Id"))
					{
						Report.updateTestLog("The energyhomemove Batch File is opened and the data are being verified ", "PASS");
						csvFileVerification(fileContent,userProfile.getFirstName(),"FirstName");
						csvFileVerification(fileContent,userProfile.getEmail(),"Email");
						csvFileVerification(fileContent,userProfile.getPhoneNumber(),"PhoneNumber");
					}
					else if(fileContent.contains("Product Required"))
					{
						Report.updateTestLog("The serviceshomemove Batch File is opened and the data are being verified ", "PASS");
						csvFileVerification(fileContent,userProfile.getFirstName(),"FirstName");
						csvFileVerification(fileContent,userProfile.getEmail(),"Email");
						csvFileVerification(fileContent,userProfile.getUCRN(),"UCRN");
					}
					else
					{
						Report.updateTestLog("The Batch File is not opened", "FAIL");
					}
			
				}}
				
		catch (JSchException e) { 
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}iteration++;
			}while(iteration<2&&batchType=="moveIn");
	}
	
	
	
	private void csvFileVerification(String fileContent,String value,String valueType){
		if(fileContent.contains(value)){
				Report.updateTestLog(valueType+" <b>"+value+"</b> is present in batch file", "PASS");
		}
	}
	
	public void verifyandClickMOAddAccountHolder(){
		if (browser.isElementVisible(pageProperties.getProperty("HomeMoveLandLord.MoveOutAddAccount"))){
		verifyAndClick(pageProperties.getProperty("HomeMoveLandLord.MoveOutAddAccount"),"Move Out - Add Account Holder");
		}
	}
	public void verifyandClickMIAddAccountHolder(){
		if (browser.isElementVisible(pageProperties.getProperty("HomeMoveLandLord.MoveInAddAccount"))){
		verifyAndClick(pageProperties.getProperty("HomeMoveLandLord.MoveInAddAccount"),"Move In - Add Account Holder");
		}
	}
	public void enterYourDetailsMOAccountOne(HomeMove homeMove)
	{
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMoveLandLord.MoveDetailsTitle1"), "Title", homeMove.getTitle());
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.MoveOutFirstName1"), "FirstName", homeMove.getFirstName());
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.MoveOutSurName1"),"SurName",homeMove.getSurName());
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.MoveOutPhone1"),"Phone Number","0123456789");
	}
	public void enterYourDetailsMOAccountTwo(HomeMove homeMove)
	{
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMoveLandLord.MoveDetailsTitle2"), "Title", homeMove.getTitle());
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.MoveOutFirstName2"), "FirstName", homeMove.getFirstName());
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.MoveOutSurName2"),"SurName",homeMove.getSurName());
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.MoveOutPhone2"),"Phone Number","0125436789");
	}
	public void enterYourDetailsMOAccountThree(HomeMove homeMove)
	{
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMoveLandLord.MoveDetailsTitle3"), "Title", homeMove.getTitle());
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.MoveOutFirstName3"), "FirstName", homeMove.getFirstName());
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.MoveOutSurName3"),"SurName",homeMove.getSurName());
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.MoveOutPhone3"),"Phone Number","0125438769");
	}
	public void enterYourDetailsMIAccountOne(HomeMove homeMove)
	{
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMoveLandLord.MoveInDetailsTitle1"), "Title", homeMove.getTitle());
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.MoveInFirstName1"), "FirstName", homeMove.getFirstName());
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.MoveInSurName1"),"SurName",homeMove.getSurName());
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.MoveInPhone1"),"Phone Number","0213456789");
	}
	public void enterYourDetailsMIAccountTwo(HomeMove homeMove)
	{
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMoveLandLord.MoveInDetailsTitle2"), "Title", homeMove.getTitle());
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.MoveInFirstName2"), "FirstName", homeMove.getFirstName());
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.MoveInSurName2"),"SurName",homeMove.getSurName());
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.MoveInPhone2"),"Phone Number","0515436789");
	}
	public void enterYourDetailsMIAccountThree(HomeMove homeMove)
	{
		verifyAndSelectDropDownBox(pageProperties.getProperty("HomeMoveLandLord.MoveInDetailsTitle3"), "Title", homeMove.getTitle());
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.MoveInFirstName3"), "FirstName", homeMove.getFirstName());
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.MoveInSurName3"),"SurName",homeMove.getSurName());
		verifyAndInputById(pageProperties.getProperty("HomeMoveLandLord.MoveInPhone3"),"Phone Number","0915438769");
	}
}
	

