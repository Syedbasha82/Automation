package bg.framework.app.functional.page.sales;

import java.util.Properties;


import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.jniwrapper.win32.ie.Browser;

public class CHIAppointmentPage extends BasePage {
	private final static String FILE_NAME = "resources/sales/CHIAppointment.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	private static String timeStamp;
	private static String postCode;
	public void navigateToAppointmentBookingpage(){
		browser.open(ApplicationConfig.APP_BG_URL+"/products-and-services/boilers-and-central-heating/new-boilers.html");
	}
	public void navigateToAppointmentBookingpageNew(){
		browser.open(ApplicationConfig.APP_BG_URL+"/products-and-services/boilers-and-central-heating/new-boilers/book-new-boiler-quote.html");
	}
	public void navigateBookthisAppointmenPage(){
		browser.clickWithXpath(pageProperties.getProperty("CHIAppointment.BookAppointmentLink"));
	}
	public void navigateBookthisAppointmenPageNew(){
		browser.clickWithXpath(pageProperties.getProperty("CHIAppointmentNew.StartLink"));
	}
	public void enterAppointmentBookingdetails(){
		browser.wait(3000);
		verifyAndClick(pageProperties.getProperty("CHIAppointment.Homeowner"),"Home Owner");
		verifyAndClick(pageProperties.getProperty("CHIAppointment.Heatinglpg"),"Central Heating System : Gas (Standard)");
		verifyAndClick(pageProperties.getProperty("CHIAppointment.boileryes"),"Boiler Status: Yes");
		verifyAndClick(pageProperties.getProperty("CHIAppointment.Continue"),"New Boiler page: Continue");
		browser.wait(3000);
	}
	
	public void enterDetailsInYourPropertyPageYes(UserProfile userProfile){
		verifyAndInputById(pageProperties.getProperty("CHIAppointmentNew.Postcode"), "Post Code :"+userProfile.getaddr(),userProfile.getaddr());
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointmentNew.BolierYes"), "Bolier Yes");
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointmentNew.CheckAvailability"), "Check Availability");
	
	}
	public void enterDetailsInYourPropertyPageNo(UserProfile userProfile){
		verifyAndInputById(pageProperties.getProperty("CHIAppointmentNew.Postcode"), "Post Code :"+userProfile.getaddr(),userProfile.getaddr());
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointmentNew.BolierNo"), "Bolier No");
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointmentNew.CheckAvailability"), "Check Availability");
	
	}
	public void enterDetailsInYourPropertyPageOAMNo(){
		browser.wait(10000);
		postCode=browser.getAttributeByXpath(pageProperties.getProperty("CHIAppointmentNew.PostcodeXpath"),"value").trim();
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointmentNew.BolierNo"), "Bolier No");
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointmentNew.CheckAvailability"), "Check Availability");
		
	
	}
	public void enterDetailsInYourPropertyPageOAMNyes(){
		browser.wait(10000);
		postCode=browser.getAttributeByXpath(pageProperties.getProperty("CHIAppointmentNew.PostcodeXpath"),"value").trim();
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointmentNew.BolierYes"), "Bolier Yes");
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointmentNew.CheckAvailability"), "Check Availability");
		
	
	}
	public void verifyChooseYourAppointmentPage(){
		browser.wait(10000);
		String summaryPostcode=browser.getTextByXpath(pageProperties.getProperty("CHIAppointmentNew.SummaryPostcodeXpath")).trim();
		if(postCode.equals(summaryPostcode)){
			Report.updateTestLog("Post Code in Your Property Page is same as that of in Summary Section", "Pass");
		}
		else{
			Report.updateTestLog("Post Code in Your Property Page is not same as that of in Summary Section", "Pass");
		}
		browser.wait(5000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointmentNew.FirstAvailableAppointmentSection"))){
			Report.updateTestLog("First Available Appointment Section is Present in the Application", "Pass");	
		}
		else{
			Report.updateTestLog("First Available Appointment Section is not Present in the Application", "FAIL");
		}
		browser.wait(5000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointmentNew.ViewAllYourAppointment"))){
			Report.updateTestLog("View all your appointment Section is Present in the Application", "PASS");	
		}
		else{
			Report.updateTestLog("View all your appointment Section is not Present in the Application", "FAIL");
		}
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.ViewCalender"),"View calender Button");
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointment.ViewCalenderPanel"))){
			Report.updateTestLog("Calendar Panel is Present in the Application", "WARN");		
		}
		else{
			Report.updateTestLog("Calendar Panel is Present in the Application", "FAIL");	
		}

	}
	public void verifyChooseYourAppointmentPageandVerifySlotsfor8weeks(){
		browser.wait(10000);
		String summaryPostcode=browser.getTextByXpath(pageProperties.getProperty("CHIAppointmentNew.SummaryPostcodeXpath")).trim();
		if(postCode.equals(summaryPostcode)){
			Report.updateTestLog("Post Code in Your Property Page is same as that of in Summary Section", "Pass");
		}
		else{
			Report.updateTestLog("Post Code in Your Property Page is not same as that of in Summary Section", "Pass");
		}
		browser.wait(5000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointmentNew.FirstAvailableAppointmentSection"))){
			Report.updateTestLog("First Available Appointment Section is Present in the Application", "Pass");	
		}
		else{
			Report.updateTestLog("First Available Appointment Section is not Present in the Application", "FAIL");
		}
		browser.wait(5000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointmentNew.ViewAllYourAppointment"))){
			Report.updateTestLog("View all your appointment Section is Present in the Application", "PASS");	
		}
		else{
			Report.updateTestLog("View all your appointment Section is not Present in the Application", "FAIL");
		}
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.ViewCalender"),"View calender Button");
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointment.ViewCalenderPanel"))){
			Report.updateTestLog("Calendar Panel is Present in the Application", "WARN");		
		}
		else{
			Report.updateTestLog("Calendar Panel is Present in the Application", "FAIL");	
		}
		browser.wait(5000);
        for(int i=0;i<27;i++){
			
			verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointmentConfirmationPage.NextSlotNavigation"), "Next Slot Navigation");
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointment.ViewCalenderPanel"))){
				Report.updateTestLog("Calendar Panel is Present in the Application", "WARN");		
			}
			else{
				Report.updateTestLog("Calendar Panel is Present in the Application", "FAIL");	
			}
			
		}
	}
	public void verifyChooseYourAppointmentPageandVerifyEditFunctionality(){
		browser.wait(10000);
		String summaryPostcode=browser.getTextByXpath(pageProperties.getProperty("CHIAppointmentNew.SummaryPostcodeXpath")).trim();
		if(postCode.equals(summaryPostcode)){
			Report.updateTestLog("Post Code in Your Property Page is same as that of in Summary Section", "Pass");
		}
		else{
			Report.updateTestLog("Post Code in Your Property Page is not same as that of in Summary Section", "Pass");
		}
		browser.wait(5000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointmentNew.FirstAvailableAppointmentSection"))){
			Report.updateTestLog("First Available Appointment Section is Present in the Application", "Pass");	
		}
		else{
			Report.updateTestLog("First Available Appointment Section is not Present in the Application", "FAIL");
		}
		browser.wait(5000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointmentNew.ViewAllYourAppointment"))){
			Report.updateTestLog("View all your appointment Section is Present in the Application", "PASS");	
		}
		else{
			Report.updateTestLog("View all your appointment Section is not Present in the Application", "FAIL");
		}
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.ViewCalender"),"View calender Button");
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointment.ViewCalenderPanel"))){
			Report.updateTestLog("Calendar Panel is Present in the Application", "WARN");		
		}
		else{
			Report.updateTestLog("Calendar Panel is Present in the Application", "FAIL");	
		}
		browser.wait(5000);
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.SummaryEdit"),"Summary Edit");
		browser.wait(5000);
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.EditChangePostcode"),"Edit Change Postcode");
		browser.wait(20000);
		if(browser.isTextPresent(pageProperties.getProperty("CHIAppointmentConfirmationPage.AboutYourProperty"))){
			Report.updateTestLog("Customer is navigated to About Your Property Page", "WARN");
		}
		else{
			Report.updateTestLog("Customer is not navigated to About Your Property Page", "FAIL");
		}
	}
	public void verifyChooseYourAppointmentPageAndCancelAppointment(){
		browser.wait(10000);
		String summaryPostcode=browser.getTextByXpath(pageProperties.getProperty("CHIAppointmentNew.SummaryPostcodeXpath")).trim();
		if(postCode.equals(summaryPostcode)){
			Report.updateTestLog("Post Code in Your Property Page is same as that of in Summary Section", "Pass");
		}
		else{
			Report.updateTestLog("Post Code in Your Property Page is not same as that of in Summary Section", "Pass");
		}
		browser.wait(5000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointmentNew.FirstAvailableAppointmentSection"))){
			Report.updateTestLog("First Available Appointment Section is Present in the Application", "Pass");	
		}
		else{
			Report.updateTestLog("First Available Appointment Section is not Present in the Application", "FAIL");
		}
		browser.wait(5000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointmentNew.ViewAllYourAppointment"))){
			Report.updateTestLog("View all your appointment Section is Present in the Application", "PASS");	
		}
		else{
			Report.updateTestLog("View all your appointment Section is not Present in the Application", "FAIL");
		}
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.ViewCalender"),"View calender Button");
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointment.ViewCalenderPanel"))){
			Report.updateTestLog("Calendar Panel is Present in the Application", "WARN");		
		}
		else{
			Report.updateTestLog("Calendar Panel is Present in the Application", "FAIL");	
		}
		verifyCancelFunctionality();
		
	}
	public void verifyChooseYourAppointmentPageAndVerifyBackFunctionality(){
		browser.wait(10000);
		String summaryPostcode=browser.getTextByXpath(pageProperties.getProperty("CHIAppointmentNew.SummaryPostcodeXpath")).trim();
		if(postCode.equals(summaryPostcode)){
			Report.updateTestLog("Post Code in Your Property Page is same as that of in Summary Section", "Pass");
		}
		else{
			Report.updateTestLog("Post Code in Your Property Page is not same as that of in Summary Section", "Pass");
		}
		browser.wait(5000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointmentNew.FirstAvailableAppointmentSection"))){
			Report.updateTestLog("First Available Appointment Section is Present in the Application", "Pass");	
		}
		else{
			Report.updateTestLog("First Available Appointment Section is not Present in the Application", "FAIL");
		}
		browser.wait(5000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointmentNew.ViewAllYourAppointment"))){
			Report.updateTestLog("View all your appointment Section is Present in the Application", "PASS");	
		}
		else{
			Report.updateTestLog("View all your appointment Section is not Present in the Application", "FAIL");
		}
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.ViewCalender"),"View calender Button");
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointment.ViewCalenderPanel"))){
			Report.updateTestLog("Calendar Panel is Present in the Application", "WARN");		
		}
		else{
			Report.updateTestLog("Calendar Panel is Present in the Application", "FAIL");	
		}
		verifyBackFunctionality();
		
	}
	public void verifyBackFunctionality(){
		browser.wait(20000);
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.Back"),"Back");
		browser.wait(20000);
		if(browser.isTextPresent(pageProperties.getProperty("CHIAppointmentConfirmationPage.AboutYourProperty"))){
			Report.updateTestLog("Customer is navigated to About Your Property Page", "WARN");
		}
		else{
			Report.updateTestLog("Customer is not navigated to About Your Property Page", "FAIL");
		}
		
	}
	public void verifyCancelFunctionality(){
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.CancelAppointment"),"Cancel Appointment");
		browser.wait(20000);
		if(browser.isTextPresent(pageProperties.getProperty("CHIAppointmentConfirmationPage.Beforeyoustart"))){
			Report.updateTestLog("Customer is navigated to CHI Appointment Start Page", "WARN");
		}
		else{
			Report.updateTestLog("Customer is not navigated to CHI Appointment Start Page", "FAIL");
		}
		
	}

		
	
	public void verifyChooseYourAppointmentPageAnonymous(UserProfile userProfile){

		browser.wait(5000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointmentNew.FirstAvailableAppointmentSection"))){
			Report.updateTestLog("First Available Appointment Section is Present in the Application", "Pass");	
		}
		else{
			Report.updateTestLog("First Available Appointment Section is not Present in the Application", "FAIL");
		}
		browser.wait(5000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointmentNew.ViewAllYourAppointment"))){
			Report.updateTestLog("View all your appointment Section is Present in the Application", "PASS");	
		}
		else{
			Report.updateTestLog("View all your appointment Section is not Present in the Application", "FAIL");
		}
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.ViewCalender"),"View calender Button");
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointment.ViewCalenderPanel"))){
			Report.updateTestLog("Calendar Panel is Present in the Application", "WARN");		
		}
		else{
			Report.updateTestLog("Calendar Panel is Present in the Application", "FAIL");	
		}
	}
	public void selectFirtAvailableAppointment(){
		browser.wait(5000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointmentNew.FirstAvailableAppointmentSection"))){
			Report.updateTestLog("First Available Appointment Section is Present in the Application", "WARN");	
		}
		else{
			Report.updateTestLog("First Available Appointment Section is not Present in the Application", "FAIL");
		}
		browser.wait(5000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointmentNew.ViewAllYourAppointment"))){
			Report.updateTestLog("View all your appointment Section is Present in the Application", "WARN");	
		}
		else{
			Report.updateTestLog("View all your appointment Section is not Present in the Application", "FAIL");
		}
		
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointmentNew.SelectThisAppointment"), "SelectThisAppointment");
	}
	
	public void enterPersonalDetails(UserProfile userProfile){
		verifyAndSelectDropDownBox(pageProperties.getProperty("CHIAppointment.Title"), "Title :"+userProfile.getTitle(), userProfile.getTitle());
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.Firstname"), "First Name :"+userProfile.getFirstName(),userProfile.getFirstName());
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.Surname"), "Sur Name :"+userProfile.getLastName(),userProfile.getLastName());
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.EmailAddr"), "Email Address :"+userProfile.getEmail(),userProfile.getEmail());
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.Phone"), "Phone Number :"+userProfile.getPhoneNumber(),userProfile.getPhoneNumber());
		verifyAndSelectDropDownBox(pageProperties.getProperty("CHIAppointment.PhoneType"), "Phone Type :"+userProfile.getPhoneType(),userProfile.getPhoneType());
		selectAddress();
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.BookAppointment"),"Book Appointment");
		}
	public void enterPersonalDetailsAndChangePostCode(UserProfile userProfile){
		verifyAndSelectDropDownBox(pageProperties.getProperty("CHIAppointment.Title"), "Title :"+userProfile.getTitle(), userProfile.getTitle());
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.Firstname"), "First Name :"+userProfile.getFirstName(),userProfile.getFirstName());
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.Surname"), "Sur Name :"+userProfile.getLastName(),userProfile.getLastName());
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.EmailAddr"), "Email Address :"+userProfile.getEmail(),userProfile.getEmail());
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.Phone"), "Phone Number :"+userProfile.getPhoneNumber(),userProfile.getPhoneNumber());
		verifyAndSelectDropDownBox(pageProperties.getProperty("CHIAppointment.PhoneType"), "Phone Type :"+userProfile.getPhoneType(),userProfile.getPhoneType());
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.ChangePostcodeYourDetails"), "Change Postcode Your Details");
		browser.wait(5000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointment.ChangePostcodeYourDetails1"))){
			Report.updateTestLog("Change Post Code is present in the Application", "WARN");
		}
		else{
			Report.updateTestLog("Change Post Code is not present in the Application", "FAIL");
		}
		
		}
	public void enterPersonalDetailsAndCancel(UserProfile userProfile){
		verifyAndSelectDropDownBox(pageProperties.getProperty("CHIAppointment.Title"), "Title :"+userProfile.getTitle(), userProfile.getTitle());
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.Firstname"), "First Name :"+userProfile.getFirstName(),userProfile.getFirstName());
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.Surname"), "Sur Name :"+userProfile.getLastName(),userProfile.getLastName());
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.EmailAddr"), "Email Address :"+userProfile.getEmail(),userProfile.getEmail());
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.Phone"), "Phone Number :"+userProfile.getPhoneNumber(),userProfile.getPhoneNumber());
		verifyAndSelectDropDownBox(pageProperties.getProperty("CHIAppointment.PhoneType"), "Phone Type :"+userProfile.getPhoneType(),userProfile.getPhoneType());
		selectAddress();
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.CancelAppointmentYourDetailsPage"),"Cancel Appointment");
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointmentNew.StartLink"))){
			Report.updateTestLog("CHI Appointment Booking is Canceled", "WARN");
		}
		else{
			Report.updateTestLog("CHI Appointment Booking is not Canceled", "FAIL");
		}
		if(browser.isTextPresent(pageProperties.getProperty("CHIAppointment.BookAnAppointmentPage"))){
			Report.updateTestLog("Book an appointment page is Displayed", "WARN");
		}
		else{
			Report.updateTestLog("Book an appointment page is Displayed", "FAIL");
		}
		
		}

	public void selectAddress(){
		if(browser.isElementVisible(pageProperties.getProperty("CHIAppointment.Addrsrch"))){
			verifyAndClick(pageProperties.getProperty("CHIAppointment.Addrsrch"),"Search Button clicked");
		}
		browser.wait(30000);
		browser.dynamicWaituntilVisiblebyXpath(pageProperties.getProperty("CHIAppointment.selectAddress"));
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointment.selectAddress"))){
			browser.wait(30000);
			Select select = new Select(browser.getElementByXpath(pageProperties.getProperty("CHIAppointment.selectAddress")));
			select.selectByIndex(1);
			Report.updateTestLog("Address Selected from Dropdown", "Pass");
		}else Report.updateTestLog("Address is not Selected from Dropdown", "Fail");
		
	}
	public void enterOAMPersonalDetails(UserProfile userProfile){
		
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.Phone"), "Phone Number :"+userProfile.getPhoneNumber(),userProfile.getPhoneNumber());
		verifyAndSelectDropDownBox(pageProperties.getProperty("CHIAppointment.PhoneType"), "Phone Type :"+userProfile.getPhoneType(),userProfile.getPhoneType());
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.HouseNumber"), "HomeNumber :"+userProfile.getHomeNumber(),userProfile.getHomeNumber());
		selectAddress();
		Report.updateTestLog("OAM Personal Details Page", "WARN");	
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointment.BookAppointment"))){
			verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.BookAppointment"),"Book Appointment");
			
		}
	}
	
	public void verifyEditFunctionality(){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointment.SummaryDetails"))){
			verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.Summary"), "SummaryDetails");
			Report.updateTestLog("Summary Status is Present in the Your Contact Details Page", "PASS");
		}else{
			Report.updateTestLog("Summary Status is Present in the Your Contact Details Page", "FAIL");
		}
	}
	
	public void verifyandConfirmAppointment(){
		browser.wait(3000);
		if(browser.isElementVisible(pageProperties.getProperty("CHIAppointment.Calendar"))){
		verifyAndClick(pageProperties.getProperty("CHIAppointment.EarliestTime"),"Time : Earliest Time");
		String text=pageProperties.getProperty("CHIAppointment.AppointmentHeader");
		Report.updateTestLog(text + " verified", "Done");
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.AppointmentContinue"),"Appointment Confirmation : Continue");
		browser.wait(3000);
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.ConfirmAppointment"), "Confirm appoinment button");
		}
		browser.wait(3000);
		verifyIsTextPresent(pageProperties.getProperty("CHIAppointment.Bookingconfirmed"));	
	}
	public void verifyConfirmationPage(){
		
		if(browser.isTextPresent(pageProperties.getProperty("CHIAppointment.Bookingconfirmed"))){
			Report.updateTestLog("CHI Appointment Confiramtion Page is Present in the Application", "WARN");
		}
		else{
			Report.updateTestLog("CHI Appointment Confiramtion Page is not Present in the Application", "FAIL");
		}
		if(browser.isTextPresent(pageProperties.getProperty("CHIAppointmentConfirmationPage.Youraddress"))){
			Report.updateTestLog("Your address is Present in the CHI Appointment Confirmation Page", "PASS");
		}
		else{
			Report.updateTestLog("Your address is not Present in the CHI Appointment Confirmation Page", "FAIL");
		}
		if(browser.isTextPresent(pageProperties.getProperty("CHIAppointmentConfirmationPage.YourAppointment"))){
			Report.updateTestLog("Your Appointment is Present in the CHI Appointment Confirmation Page", "WARN");
		}
		else{
			Report.updateTestLog("Your Appointment is not Present in the CHI Appointment Confirmation Page", "FAIL");
		}
		if(browser.isTextPresent(pageProperties.getProperty("CHIAppointmentConfirmationPage.BookingReferenceNumber"))){
			Report.updateTestLog("Booking Reference Number is Present in the CHI Appointment Confirmation Page", "WARN");
		}
		else{
			Report.updateTestLog("Booking Reference Number is not Present in the CHI Appointment Confirmation Page", "FAIL");
		}
	}
	
	public void enterPersonalDetailsRequestCallBack(UserProfile userProfile){
		verifyAndSelectDropDownBox(pageProperties.getProperty("CHIAppointment.Title1"), "Title :"+userProfile.getTitle(), userProfile.getTitle());
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.Firstname1"), "First Name :"+userProfile.getFirstName(),userProfile.getFirstName());
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.Surname1"), "Sur Name :"+userProfile.getLastName(),userProfile.getLastName());
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.Telephone1"), "PTelePhone Number","0123456789");
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.EmailAddress1"), "Email Address",userProfile.getEmail());
		verifyAndSelectDropDownBox(pageProperties.getProperty("CHIAppointment.Day1"), "DaY selection", userProfile.getDate());
		verifyAndSelectDropDownBox(pageProperties.getProperty("CHIAppointment.Time1"), "Time Selection","3:00pm-4:00pm");
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.RequestButton"), "Request A Cakll back Button");
		verifyIsTextPresent("Thank you for requesting a Call back");
		}
	public void firstPage(UserProfile userProfile){
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.Heatingsys"), "Heating System Selection");
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.Workcondition"), "Boiler working Condition");
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.FirstContinue"), "First Page Continue");
	
	}
	
	public void secondPageCancel(UserProfile userProfile){
		
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.Cancel"), "Second Page cancel");
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.OverlayCancel"), "pverlay Cancel");
		verifyIsTextPresent("Book an appointment for a no-obligation quote");
	
	}
	
	public void secondPagePersonalDetails(UserProfile userProfile){
		String dropText ="";
		verifyAndSelectDropDownBox(pageProperties.getProperty("CHIAppointment.Title1"), "Title :"+userProfile.getTitle(), userProfile.getTitle());
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.Firstname2"), "First Name :"+userProfile.getFirstName(),userProfile.getFirstName());
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.Surname1"), "Sur Name :"+userProfile.getLastName(),userProfile.getLastName());
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.PostCode2nd"), "Post Code: "+userProfile.getaddr(), userProfile.getaddr());
	    browser.wait(4000);
		verifyAndClick(pageProperties.getProperty("CHIAppointment.PostCodeSearch"), "Post Code Search");
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		browser.wait(15000);
		dropText=browser.getTextByXpath("//*[@id='displayaddr']/option[2]");	
		verifyAndSelectDropDownBox(pageProperties.getProperty("CHIAppointment.AddressSelction"), "Address Selection", dropText);
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.PostCode2nd"), "Post Code: "+userProfile.getaddr(), userProfile.getaddr());
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.EmailAddress2"), "Email Address",userProfile.getEmail());
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.TelePhoneNumber2"), "PTelePhone Number","0123456789");
		 browser.wait(1000);
		verifyAndSelectDropDownBox(pageProperties.getProperty("CHIAppointment.Home"), "Home selection", "Home");
		 browser.wait(1000);
		verifyAndClick(pageProperties.getProperty("CHIAppointment.tick"), "Check box checked");
		verifyAndSelectDropDownBox(pageProperties.getProperty("CHIAppointment.AgeGroup"), "About Your Boiler", "0-5 years");
		verifyAndClick(pageProperties.getProperty("CHIAppointment.2ndPageNext"),"2nd Page Next button");
		
	}
	
	public void postCodeErrorMessage(UserProfile userProfile){
		
		
		String error=browser.getTextByXpath(pageProperties.getProperty("CHIAppointment.PostCodeerror"));
		if(error.contains("Postcode : Please enter a valid postcode"))
		{
			Report.updateTestLog("Error message diplayed correctly", "PASS");
		}
		else
		{
			Report.updateTestLog("Error message diplayed In correctly", "FAIL");
		}
		
	}
	 public void verifyAppointmentSelectionCalenderFFSlot(){
		 browser.wait(5000);
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointmentNew.FirstAvailableAppointmentSection"))){
				Report.updateTestLog("First Available Appointment Section is Present in the Application", "WARN");	
			}
			else{
				Report.updateTestLog("First Available Appointment Section is not Present in the Application", "FAIL");
			}
			
			verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.ViewCalender"),"View calender Button");
			    int i = 1 ;
				for (int j = 2 ; j <15 ; j++){
					if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointment.availableSlots").replace("Row", ""+i).replace("Col", ""+j))){
						verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.availableSlots").replace("Row", ""+i).replace("Col", ""+j),"Available Slots");
    					browser.wait(30000);
    					verifyAndClickWithXpath(".//*[@title='Select this appointment'][@id='']", "Select this appointment Button in Over Lay");
    					Report.updateTestLog("Next available slot is clicked successfully","WARN");	
    				
    					break;
					}
				}
			
			
		}
	 public void verifyAppointmentSelectionCalenderSecondSlot(){
		 browser.wait(5000);
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointmentNew.FirstAvailableAppointmentSection"))){
				Report.updateTestLog("First Available Appointment Section is Present in the Application", "WARN");	
			}
			else{
				Report.updateTestLog("First Available Appointment Section is not Present in the Application", "FAIL");
			}
			verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.ViewCalender"),"View calender Button");
			for (int i = 2 ; i < 9 ; i++){
				for (int j = 2 ; j <15 ; j++){
					if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointment.availableSlots").replace("Row", ""+i).replace("Col", ""+j))){
						verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.availableSlots").replace("Row", ""+i).replace("Col", ""+j),"Available Slots");
						verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.selectThisAppointmentoverlay"),"Select this appointment Button in Over Lay");
						Report.updateTestLog("Next available slot is clicked successfully","WARN");	
						break;
					}
				}	  
			}
		}
	 public void selectHalfDayAppointmentDay(){
		 browser.wait(5000);
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointmentNew.FirstAvailableAppointmentSection"))){
				Report.updateTestLog("First Available Appointment Section is Present in the Application", "WARN");	
			}
			else{
				Report.updateTestLog("First Available Appointment Section is not Present in the Application", "FAIL");
			}
			verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.ViewCalender"),"View calender Button");
			browser.wait(10000);
			    int halfDay=2;
				for (int j = 2 ; j <15 ; j++){
					if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointment.availableSlots").replace("Row", ""+halfDay).replace("Col", ""+j))){
						verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.availableSlots").replace("Row", ""+halfDay).replace("Col", ""+j),"Available Slots");
						browser.wait(30000);
						verifyAndClickWithXpath(".//*[@title='Select this appointment'][@id='']","Select this appointment Button in Over Lay");
						Report.updateTestLog("Next available slot is clicked successfully","WARN");	
						break;
					}
				}	  
			
		}
	 public void verifyAppointmentSelectionCalenderThirdSlot(){
		 browser.wait(5000);
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointmentNew.FirstAvailableAppointmentSection"))){
				Report.updateTestLog("First Available Appointment Section is Present in the Application", "WARN");	
			}
			else{
				Report.updateTestLog("First Available Appointment Section is not Present in the Application", "FAIL");
			}
			verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.ViewCalender"),"View calender Button");
			for (int i = 6 ; i < 9 ; i++){
				for (int j = 2 ; j <15 ; j++){
					if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointment.availableSlots").replace("Row", ""+i).replace("Col", ""+j)))
					{
						verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.availableSlots").replace("Row", ""+i).replace("Col", ""+j),"Available Slots");
						verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.selectThisAppointmentoverlay"),"Select this appointment Button in Over Lay");
						Report.updateTestLog("Next available slot is clicked successfully","WARN");	
						break;
					}
				}	  
			}
	 }

    public void selectAppointmentFromCalendar(String slotType,String timeSlot){
    	browser.wait(5000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointmentNew.FirstAvailableAppointmentSection"))){
			Report.updateTestLog("First Available Appointment Section is Present in the Application", "WARN");	
		}
		else{
			Report.updateTestLog("First Available Appointment Section is not Present in the Application", "FAIL");
		}
		 verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.ViewCalender"),"View calender Button");
		 browser.wait(3000);
		 if(slotType=="Morning" & timeSlot=="9:00am-11:00am"){
			 browser.wait(3000);
    	    	int firstRow =3;
    	    	for (int j = 2 ; j <15 ; j++){
    				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointment.availableSlots").replace("Row", ""+firstRow).replace("Col", ""+j))){
    					verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.availableSlots").replace("Row", ""+firstRow).replace("Col", ""+j),"Available Slots");
    					browser.wait(30000);
    					verifyAndClickWithXpath(".//*[@title='Select this appointment'][@id='']", "Select this appointment Button in Over Lay");
    					Report.updateTestLog("Next available slot is clicked successfully","WARN");	
    					break;
    				}}
    	    }
    	 
    	 if(slotType=="Morning" & timeSlot=="11:00am-1:00pm"){
 	    	browser.clickWithXpath(pageProperties.getProperty("CHIAppointment.ClickSlots"));
 	    	int secondRow =3;
 	    	for (int j = 2 ; j <15 ; j++){
 				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointment.availableSlots").replace("Row", ""+secondRow).replace("Col", ""+j))){
 					verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.availableSlots").replace("Row", ""+secondRow).replace("Col", ""+j),"Available Slots");
 					browser.wait(30000);
 					verifyAndClickWithXpath(".//*[@title='Select this appointment'][@id='']", "Select this appointment Button in Over Lay");
 					Report.updateTestLog("Next available slot is clicked successfully","WARN");	
 					break;
 				}}
 	    }
    	 
    	 if(slotType=="Evening" & timeSlot=="1:00pm-3:30pm"){
  	    	browser.clickWithXpath(pageProperties.getProperty("CHIAppointment.ClickSlots"));
  	    	browser.clickWithXpath(pageProperties.getProperty("CHIAppointment.EveningSlots"));
  	    	int thirdRow =3;
  	    	for (int j = 2 ; j <15 ; j++){
  				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointment.availableSlots").replace("Row", ""+thirdRow).replace("Col", ""+j))){
  					verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.availableSlots").replace("Row", ""+thirdRow).replace("Col", ""+j),"Available Slots");
  					browser.wait(30000);
  					verifyAndClickWithXpath(".//*[@title='Select this appointment'][@id='']", "Select this appointment Button in Over Lay");
  					Report.updateTestLog("Next available slot is clicked successfully","WARN");	
  					break;
  				}}
  	    }
    	 
    	 if(slotType=="Evening" & timeSlot=="3:30pm-5:30pm"){
    	    browser.wait(10000);
   	    	browser.clickWithXpath(pageProperties.getProperty("CHIAppointment.ClickSlots"));
   	    	browser.wait(10000);
   		    WebElement slotClick = browser.getElementByXpath(pageProperties.getProperty("CHIAppointment.EveningSlots"));
		    slotClick.click();
   	    	int fourthRow =6;
   	    	for (int j = 2 ; j <15 ; j++){
   				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointment.availableSlots").replace("Row", ""+fourthRow).replace("Col", ""+j))){
   					verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.availableSlots").replace("Row", ""+fourthRow).replace("Col", ""+j),"Available Slots");
   					browser.wait(30000);
   					verifyAndClickWithXpath(".//*[@title='Select this appointment'][@id='']", "Select this appointment Button in Over Lay");
   					Report.updateTestLog("Next available slot is clicked successfully","WARN");	
   					break;
   				}}
   	    }
    	 
    	 if(slotType=="Evening" & timeSlot=="5:30pm-7:00pm"){
    		    browser.wait(10000);
    	    	browser.clickWithXpath(pageProperties.getProperty("CHIAppointment.ClickSlots"));
    	    	browser.wait(10000);
    		    WebElement slotClick = browser.getElementByXpath(pageProperties.getProperty("CHIAppointment.EveningSlots"));
 		        slotClick.click();
    	    	int fifithRow =5;
    	    	for (int j = 2 ; j <15 ; j++){
    				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointment.availableSlots").replace("Row", ""+fifithRow).replace("Col", ""+j))){
    					verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.availableSlots").replace("Row", ""+fifithRow).replace("Col", ""+j),"Available Slots");
    					browser.wait(30000);
    					//verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.selectThisAppointmentoverlay"),"Select this appointment Button in Over Lay");
    					verifyAndClickWithXpath(".//*[@title='Select this appointment'][@id='']", "Select this appointment Button in Over Lay");
    					Report.updateTestLog("Next available slot is clicked successfully","WARN");	
    					break;
    				}}
    	    }
    	 if(slotType=="Evening" & timeSlot=="7:00-8:30pm"){
 		    browser.wait(10000);
 	    	browser.clickWithXpath(pageProperties.getProperty("CHIAppointment.ClickSlots"));
 	    	browser.wait(10000);
 		    WebElement slotClick = browser.getElementByXpath(pageProperties.getProperty("CHIAppointment.EveningSlots"));
		    slotClick.click();
 	    	int ninthRow =8;
 	    	for (int j = 2 ; j <15 ; j++){
 				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CHIAppointment.availableSlots").replace("Row", ""+ninthRow).replace("Col", ""+j))){
 					verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.availableSlots").replace("Row", ""+ninthRow).replace("Col", ""+j),"Available Slots");
 					browser.wait(30000);
 					verifyAndClickWithXpath(".//*[@title='Select this appointment'][@id='']", "Select this appointment Button in Over Lay");
 					Report.updateTestLog("Next available slot is clicked successfully","WARN");	
 					break;
 				}}
 	    }
	   
	   
    }
    
    public void checkSlotAvailabiltyForDifferentPostcodes(UserProfile userProfile){
    	
    	String i[]={"DT7 3HX","EX13 7TZ","TQ13 8AB","EX4 6PQ","TQ2 5AB"};
    	for(int j=0;j<5;j++){
    		verifyAndInputByXpath(pageProperties.getProperty("CHIAppointmentNew.PostcodeXpath"), "Post Code", i[j]);
    		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointmentNew.BolierNo"), "Bolier No");
    		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointmentNew.CheckAvailability"), "Check Availability");
    		browser.wait(10000);
    		verifyChooseYourAppointmentPageAnonymous(userProfile);
    		
    	}
    	
    	
    }
    }
    
