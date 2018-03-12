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
		verifyAndInputById(pageProperties.getProperty("CHIAppointment.Postcode"), "Post Code : al7 4hd","al7 4hd");
		verifyAndClick(pageProperties.getProperty("CHIAppointment.Addrsrch"),"Search Address");
		browser.wait(5000);
		if (browser.isElementVisible(pageProperties.getProperty("CHIAppointment.selectAddress"))) {
			browser.wait(5000);
            browser.selectfromDropBox("id", pageProperties.getProperty("CHIAppointment.selectAddress"),"308, Howlands, WELWYN GARDEN CITY, Hertfordshire, AL7 4HD");            
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
		}
		verifyIsTextPresent(pageProperties.getProperty("CHIAppointment.Bookingconfirmed"));	
	}
}
