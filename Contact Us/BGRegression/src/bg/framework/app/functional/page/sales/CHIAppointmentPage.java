package bg.framework.app.functional.page.sales;

import java.util.Properties;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class CHIAppointmentPage extends BasePage {
	private final static String FILE_NAME = "resources/sales/CHIAppointment.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	
	public void navigateToAppointmentBookingpage(){
		browser.open(ApplicationConfig.APP_BG_URL+"/products-and-services/boilers-and-central-heating/new-boilers.html");
	}
	public void navigateBookthisAppointmenPage(){
		browser.clickWithXpath(pageProperties.getProperty("CHIAppointment.BookAppointmentLink"));
	}
	public void enterAppointmentBookingdetails(){
		browser.wait(3000);
		verifyAndClick(pageProperties.getProperty("CHIAppointment.Homeowner"),"Home Owner");
		verifyAndClick(pageProperties.getProperty("CHIAppointment.Heatinglpg"),"Central Heating System : Gas (Standard)");
		verifyAndClick(pageProperties.getProperty("CHIAppointment.boileryes"),"Boiler Status: Yes");
		verifyAndClick(pageProperties.getProperty("CHIAppointment.Continue"),"New Boiler page: Continue");
		browser.wait(3000);
	}
	
	public void enterPersonalDetails(UserProfile userProfile){
		verifyAndSelectDropDownBox(pageProperties.getProperty("CHIAppointment.Title"), "Title :"+userProfile.getTitle(), userProfile.getTitle());
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.Firstname"), "First Name :"+userProfile.getFirstName(),userProfile.getFirstName());
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.Surname"), "Sur Name :"+userProfile.getLastName(),userProfile.getLastName());
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.Postcode"), "Post Code : tw18 3he","tw18 3he");
		verifyAndClick(pageProperties.getProperty("CHIAppointment.Addrsrch"),"Search Address");
		browser.wait(10000);
		if (browser.isElementVisible(pageProperties.getProperty("CHIAppointment.selectAddress"))){
			browser.wait(5000);
			browser.selectfromDropBox("id", pageProperties.getProperty("CHIAppointment.selectAddress"), "1, Meadow Gardens, STAINES-UPON-THAMES, Middlesex, TW18 3HE");
			browser.wait(5000);
			verifyAndInputById(pageProperties.getProperty("CHIAppointment.Postcode"), "Post Code : tw18 3he","tw18 3he");
		}
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.EmailAddr"), "Email Address :"+userProfile.getEmail(),userProfile.getEmail());
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.Phone"), "Phone Number :"+userProfile.getPhoneNumber(),userProfile.getPhoneNumber());
		verifyAndSelectDropDownBox(pageProperties.getProperty("CHIAppointment.PhoneType"), "Phone Type :"+userProfile.getPhoneType(),userProfile.getPhoneType());
		verifyAndClickWithXpath(pageProperties.getProperty("CHIAppointment.Personaldetailscontinue"),"Personal details: Continue");
		browser.wait(3000);
		verifyIsTextPresent(userProfile.getTitle());
		verifyIsTextPresent(userProfile.getFirstName());
		verifyIsTextPresent(userProfile.getLastName());
		verifyIsTextPresent(userProfile.getEmail());
		verifyAndClick(pageProperties.getProperty("CHIAppointment.OverlayContinue"),"Overlay : Continue");
		browser.wait(3000);	
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
		//verifyAndClickWithXpath("//*[@id='displayaddr']/option[2]", "Address Selection");
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
	
	
}
