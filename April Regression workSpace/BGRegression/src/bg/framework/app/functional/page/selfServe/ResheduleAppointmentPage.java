package bg.framework.app.functional.page.selfServe;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SiebelDataBase;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 23/03/12
 * Time: 10:16
 * To change this template use File | Settings | File Templates.
 */
public class ResheduleAppointmentPage extends BasePage {

    private final static String FILE_NAME = "resources/selfServe/"+ApplicationConfig.BRAND+"ResheduleAppointment.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    public void navigateToAccountSummaryPage(UserProfile userProfile) {
       // browser.wait(getWaitTime());
        verifyAndClickWithXpath((pageProperties.getProperty(
                "AccountOverviewPage.ManageAccountXPath").replace("<USERACCOUNTNUMBER>",
                		userProfile.getAccNumber())), "Account summary");
    }
    
    public void navigateToUpgradeSmartMeterPage()
    {
    	verifyAndClickWithLinkText(pageProperties.getProperty("UpgradeToSmartMeter.UpgradeToSmartMeterLink"), "Upgrade Smart Meter link");        
        
    }
    public void navigateToCancelAnAppointmentPage()
    {
    	verifyAndClickWithLinkText(pageProperties.getProperty("CancelAnAppointment.CancelAppointmentLinkText"), "Cancel Appointment link");        
        
    }
    
    public void navigateToResheduleAnAppointmentPage()
    {
    	verifyAndClickWithLinkText(pageProperties.getProperty("ResheduleAppointmentLinkText"), "Reshedule Appointment link");        
        
    }    
    public void navigateToChooseAnAppointmentPage()
    {
    	verifyAndSelectCheckBox(pageProperties.getProperty("UpgradeToSmartMeter.EligibleCheckbox"), "Eligible checkbox");        
    	verifyAndClickWithXpath(pageProperties.getProperty("UpgradeToSmartMeter.ContinueButton"), "Continue button"); 
    }
    
    public void navigateToReviewDetailsPage()
    {
   
    	//selectSlotByValue("Friday 28 Jun 2013 between 10:00am - 2:00pm");
    	verifyAndClickWithXpath(pageProperties.getProperty("UpgradeToSmartMeter.AvailableTimeSlot"), "Available time slot"); 
    	verifyAndClickWithXpath(pageProperties.getProperty("UpgradeToSmartMeter.BookThisAppointmentButton"), "Book this appointment button");
        
    }

	public void navigateToConfirmationPage() {
		verifyAndInputWithName(pageProperties.getProperty("UpgradeToSmartMeter.BestContactNumber"),"Best Contact Number", "02071234562");
		verifyAndClick(pageProperties.getProperty("UpgradeToSmartMeter.ReadingInterval"),"Reading Interval");
		verifyAndSelectCheckBox(pageProperties.getProperty("UpgradeToSmartMeter.EnergySavingAdviceFlag"), "Energy saving advice flag");
		verifyAndClickWithXpath(pageProperties.getProperty("UpgradeToSmartMeter.SubmitButton"), "Submit button");
	}
	
	public void navigateToYourAccountPage()
    {
		verifyAndClickWithLinkText(pageProperties.getProperty("UpgradeToSmartMeter.GoToYourAccount"), "Go to your account"); 
    }
	public void cancelAppointment()
    {
		verifyAndClickWithLinkText(pageProperties.getProperty("CancelAnAppointment.CancelAppointmentLinkText"), "Cancel Appointment Link");
		verifyAndClickWithXpath(pageProperties.getProperty("CancelAnAppointment.ConfirmCancelAppointment"), "Confirm Cancel Appointment");
		
    }
	public void verifyAppointmentDateAndTime()
    {
		VerifyAppointmentDate(); 
    }
	public void verifyAppointmentCancelation()
    {
		VerifyAppointmentCancelation(); 
    }
}