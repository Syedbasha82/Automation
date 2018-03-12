package bg.framework.app.functional.page.reFactoring;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.openqa.selenium.WebElement;

import net.sf.saxon.functions.CurrentDateTime;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SiebelDataBase;

public class ASVPage extends BasePage{
	private final static String SMR_FILE_NAME = "resources/selfServe/ASVIB.properties";
	private static Properties pageProperties = new PropertyLoader(SMR_FILE_NAME)
			.load();
	private static String dateTime;
	public void checkMobileNumber(UserProfile userProfile)
	{
		if(browser.getTextByXpath(pageProperties.getProperty("ASVIBReview.MobileNumberText"))!="")
		{
			Report.updateTestLog("The Mobile Number Field is not empty", "PASS");
		}
		else
		{
			Report.updateTestLog("The Mobile Number Field is empty", "FAIL");
		}			
		if(new SiebelDataBase().getTelephoneNumber(userProfile.getUCRN()).equalsIgnoreCase(userProfile.getPhoneNumber()))
		{
			Report.updateTestLog("Mobile number is same as in the siebel Database", "PASS");
		}
		else
		{
			Report.updateTestLog("Mobile number is not same as in the siebel Database", "FAIL");
		}
	}
	
	public void checkHomeNumber(UserProfile userProfile)
	{
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("ASVIBReview.HomeNumberText"), "Home Number Text Field");		
		if(browser.getTextByXpath(pageProperties.getProperty("ASVIBReview.HomeNumberText"))!="")
		{
			Report.updateTestLog("The Home Number Field is not empty", "PASS");
		}
		else
		{
			Report.updateTestLog("The Home Number Field is empty", "FAIL");
		}			
		if(new SiebelDataBase().getTelephoneNumber(userProfile.getUCRN()).equalsIgnoreCase(userProfile.getPhoneNumber()))
		{
			Report.updateTestLog("Home number is same as in the siebel Database", "PASS");
		}
		else
		{
			Report.updateTestLog("Home number is not same as in the siebel Database", "FAIL");
		}
	}
	
	public void modifyHomeNumber()
	{
		verifyAndInputByXpath(pageProperties.getProperty("ASVIBReview.HomeNumberText"), "Home Number Text", "0123456789");
	}
	
	public void checkNewMobileNumber(UserProfile userProfile)
	{
		if(browser.getTextByXpath(pageProperties.getProperty("ASVIBReview.MobileNumberText"))!="")
		{
			Report.updateTestLog("The Mobile Number Field is not empty", "PASS");
		}
		else
		{
			Report.updateTestLog("The Mobile Number Field is empty", "FAIL");
		}			
		if(browser.getTextByXpath(pageProperties.getProperty("ASVIBReview.MobileNumberText")).equalsIgnoreCase(userProfile.getMobileNumber()))
		{
			Report.updateTestLog("Mobile number is same as entered already", "PASS");
		}
		else
		{
			Report.updateTestLog("Mobile number is not same as entered already", "FAIL");
		}
	}

	public void verifyBookingDB(UserProfile userProfile,String strType)
	{
		String strAuditDet = null;	
		Calendar currentDate = Calendar.getInstance();
		String monthname[] = new DateFormatSymbols().getMonths();
		SimpleDateFormat oDateFormat = new SimpleDateFormat("yyyy");
		
			String oStrDate = "";			
			oStrDate = oDateFormat.format(currentDate.getTime());
			String monthName[] = new DateFormatSymbols().getMonths();
			if(strType != "Payment")
			{
			String FinalDate = currentDate.get(currentDate.DAY_OF_MONTH)
								+ "-"
								+monthName[currentDate.get(currentDate.MONTH)]
								+"-"
								+ oStrDate;
		
			strAuditDet = "CUSTOMER ID : "
						+userProfile.getAccNumber().substring(0, 8)
						+", APPOINTMENT DATE: "
						+FinalDate
						+", APPOINTMENT SLOT: ";
			}
			
			if(strType == "Payment")
			{
				strAuditDet = currentDate.get(currentDate.DAY_OF_MONTH)
						+ "-"
						+monthName[currentDate.get(currentDate.MONTH)].substring(0,3)
						+"-"
						+ oStrDate.substring(0,2);
			}
			
		int retVal = new OnlineDBConnector().getAuditDetailsCount(userProfile.getAccNumber().substring(8,15), strType, strAuditDet);
		if(retVal == 0)
		{
			Report.updateTestLog("The Value is not entered in the ASV_TA_AUDIT_DETAILS", "FAIL");			
		}
		else if(retVal == 1)
		{
			Report.updateTestLog("The Value is entered in the ASV_TA_AUDIT_DETAILS", "PASS");			
		}
	}
	public void navigateToAsvBookingPage(UserProfile userProfile){
		browser.wait(getWaitTime());
		System.out.println("ssssssssssssssssssssssssssssssssssssssssssss");
		browser.dynamicWaituntilClickablebyXpath(pageProperties.getProperty("ASV.BookASVLink").replace("ACCOUNTNUMBER", userProfile.getAccNumber()));
		System.out.println("ssssssssssssssssssssssssssssssssssssssssssss");
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.BookASVLink").replace("ACCOUNTNUMBER", userProfile.getAccNumber()))){
			Report.updateTestLog("Book An Annual Service Link is present in the Application", "WARN");
			verifyAndClickWithXpath(pageProperties.getProperty("ASV.BookASVLink").replace("ACCOUNTNUMBER", userProfile.getAccNumber()), "BookASVLink");
			
		}
		else{
			Report.updateTestLog("Book An Annual Service Link is present in the Application", "FAIL");
		}
		browser.wait(5000);
		 verifyContinueASVBookingOverlay();
				
	}
	public void navigateToFVBookingPage(UserProfile userProfile){
		browser.wait(5000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("FV.BookFVLink").replace("ACCOUNTNUMBER", userProfile.getAccNumber()))){
			Report.updateTestLog("Book A First Service Link is present in the Application", "WARN");
			verifyAndClickWithXpath(pageProperties.getProperty("FV.BookFVLink").replace("ACCOUNTNUMBER", userProfile.getAccNumber()), "Book FV Link");
			
		}
		else{
			Report.updateTestLog("Book A First Service Link is not present in the Application", "FAIL");
		}
		
		 
				
	}
	public void verifyContinueASVBookingOverlay(){
		
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.ContinueBookASVOverlay")))
		{
		Report.updateTestLog("Continue To Book An Annual Service Visit Overlay is present in the Application", "WARN");
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("ASV.combiningLink"), "Combining Link");
		verifyAndClickWithXpath(pageProperties.getProperty("ASV.ContinueASV"), "Continue to  ASV Booking");
		}
		else
		{
			Report.updateTestLog("Continue To Book An Annual Service Visit Overlay is not present in the Application", "FAIL");
		}
		
	}
	
	public void verifyChooseYourAppointmentPage(){
		//browser.wait(5000);
		//browser.open(ApplicationConfig.APP_BG_URL+"/bgs-app/show-slot/");
		browser.wait(5000);
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("ASV.FirstAvailableAppointmentSection"), "First Available Appointment Section");
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("ASV.DateandTime"), "Date and Time Text in First Available Appointment Section");
		//verifyIsElementVisibleWithXpath(pageProperties.rgetProperty("ASV.ViewCalendarSection"), "View Calendar Section");
		//verifyAndClickWithXpath(pageProperties.getPropety("ASV.ViewCalender"), "View Calendar");
		
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.ViewCalendarPanel"))){
			Report.updateTestLog("Appointments are displayed", "WARN");
		}
		else{
			Report.updateTestLog("Appointment are not displayed", "FAIL");
		}
		
		
		/*if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.ViewCalendarPanel"), "View Calendar Panel");
		Report.updateTestLog("Slots are displayed","WARN");
		else
		{
			Report.updateTestLog("Slots are displayed","FAIL");	
		}*/
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("ASV.BackLink"), "Back Link");
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("ASV.CancelLink"), "Cancel Link ");	

		}
		
		
	
	public void navigateToReviewYourAppointmentPageFirstAvailableAppointment(){
		
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.SelectThisAppointment"))){
				
			verifyAndClickWithXpath(pageProperties.getProperty("ASV.SelectThisAppointment"), "Select This Appointment");
			Report.updateTestLog("Select This Appointment is Present in the Application", "PASS");
		}
		else{
			Report.updateTestLog("Select This Appointment is not Present in the Application", "FAIL");
		}
		
	}
	public void navigateToReviewYourAppointmentPageThroughCalendar(){
		
		 for (int i = 3 ;i<15;i++){
			for (int j = 4 ; j <15 ; j++){
				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.availableSlots").replace("Row", ""+i).replace("Col", ""+j))){
					verifyAndClickWithXpath(pageProperties.getProperty("ASV.availableSlots").replace("Row", ""+i).replace("Col", ""+j),"Available Slots");
					browser.wait(3000);
					verifyAndClickWithXpath(".//*[@title='Select this appointment'][@id='']", "Select this appointment Button in Over Lay");
					Report.updateTestLog("Next available slot is clicked successfully","WARN");	
					break;
				}
			}
			break;
		  
		 }
		// verifyGasCertificateOverlay();
	}
	public void verifyGasCertificateOverlay(){
		browser.wait(3000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.gasCheckOverLay"))){
			verifyAndClickWithXpath(pageProperties.getProperty("ASV.keepThisAppointment"), "Keep This Appointment");
			
		}
	}
	public void verifyServiceOverviewPage(){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("FV.changeAppLink"))){
			Report.updateTestLog("Change Appointment Link is Present","Pass");	
		}
		else{
			Report.updateTestLog("Change Appointment Link is not Present","FAIL");	
		}
		verifyAndClickWithXpath(pageProperties.getProperty("FV.continueToReveiwDetails"), "Keep This Appointment");
	}
	public void verifyReviewYourAppointmentPage(UserProfile userProfile){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("FV.changeAppLink"))){
			Report.updateTestLog("Change Appointment Link is Present","Pass");	
		}
		else{
			Report.updateTestLog("Change Appointment Link is not Present","FAIL");	
		}
		verifyAddressSectionInReviewYourAppointmentPage();
		verifyYourAppointmentSectionInReviewYourAppointmentPage();
	/*	verifyCarbonMonoxideDetectorSection();*/
		/*verifyGasApplianceSafetyCheck();*/
		verifyTotalToPaySection();
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("ASV.BackLink"), "BackL ink");
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("ASV.CancelLink"), "Cancel Link");
		browser.open(ApplicationConfig.APP_BG_URL+"/bgs-app/confirm-appt-summary/");
		browser.wait(5000);
		browser.wait(getWaitTime());
		Report.updateTestLog("******************************","Pass");
		verifyAndInputById(pageProperties.getProperty("ASV.ContactNumber"), "Contact Number", userProfile.getPhoneNumber());
		//verifyAndInputByXpath(pageProperties.getProperty("ASV.ContactNumberNew"), "Contact Number", userProfile.getPhoneNumber());
		verifyAddressSectionInReviewYourAppointmentPage();
		
	}
	
	public void verifyAddressSectionInReviewYourAppointmentPage(){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.AddressSectionInReviewyourAppointment"))){
			Report.updateTestLog("Address Section is Present in the Application", "PASS");
		}
		else{
			Report.updateTestLog("Address Section is not Present in the Application", "FAIL");
		}
	}
	public void verifyYourAppointmentSectionInReviewYourAppointmentPage(){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.YourAppointmentSectionInReviewyourAppointment"))){
			Report.updateTestLog("Your Appointment Section is Present in the Application", "PASS");
		}
		else{
			Report.updateTestLog("Your Appointment Section is not Present in the Application", "FAIL");
		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.ChangelinkinYourAppointment"))){
			Report.updateTestLog("Change link in YourAppointment is Present in the Application", "PASS");
		}
		else{
			Report.updateTestLog("Change link in YourAppointment is not Present in the Application", "FAIL");
		}
		
	}
	public void verifyCarbonMonoxideDetectorSection(){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.CarbonMonoxideDetector"))){
			Report.updateTestLog("Why not add these at the same time as your Annual Service visit? Section is Present in the Application", "PASS");
		}
		else{
			Report.updateTestLog("Why not add these at the same time as your Annual Service visit? Section is not Present in the Application", "FAIL");
		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.AddCarbonMonoxideDetector"))){
			Report.updateTestLog("Add Link is Present in the Application", "PASS");
		}
		else{
			Report.updateTestLog("Add Link is is not Present in the Application", "FAIL");
		}
		
	}
	public void verifyGasApplianceSafetyCheck(){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.GasSafetyCheck"))){
			Report.updateTestLog("Gas appliance safety check Section is Present in the Application", "PASS");
		}
		else{
			Report.updateTestLog("Gas appliance safety check Section is not Present in the Application", "FAIL");
		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.RequestACallback"))){
			Report.updateTestLog("Request A Callback Section is Present in the Application", "PASS");
		}
		else{
			Report.updateTestLog("Request A Callback is not Present in the Application", "FAIL");
		}
	}
    public void verifyTotalToPaySection(){
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.TotalToPaySection"))){
			Report.updateTestLog("Total To PaySection Section is Present in the Application", "PASS");
		}
		else{
			Report.updateTestLog("Total To PaySection is not Present in the Application", "FAIL");
		}
    }
    public void navigateToConfirmationPage(){
    	
    	verifyAndClickWithXpath(pageProperties.getProperty("ASV.BookThisAppointment"), "Book This Appointment");
    	
    }
    public void verifySlots(){
    /*	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.ViewCalendarSection"))){
    		verifyAndClickWithXpath(pageProperties.getProperty("ASV.ViewCalender"), "View Calendar");
    		browser.wait(10000);
    		browser.clickWithXpath(pageProperties.getProperty("ASV.Click2hourSlots"));
    		browser.wait(10000);
    	    WebElement slotClick = browser.getElementByXpath(pageProperties.getProperty("ASV.Click4hourSlots"));
    	    slotClick.click();
    	    for(int i=3;i<9;i++){
    	    	browser.clickWithXpath(pageProperties.getProperty("ASV.ClickAnyDaySlots"));
    	    	browser.wait(10000);
    	    	WebElement slotDays = browser.getElementByXpath(pageProperties.getProperty("ASV.ClickalldaysSlots").replace("ALLDAYS","" + i ));
    	    	browser.wait(10000);
    	    	slotDays.click();
    	    }
    	}*/
    }
    public void verifyConfirmationPage(){
    	browser.wait(5000);
        String confirmationText=browser.getTextByXpath(pageProperties.getProperty("ASV.ConfirmationText"));
    	String textConfirmation="Your annual service is booked";
    	if(confirmationText.contains(textConfirmation)){
    		Report.updateTestLog("Confirmation Page is present in the application", "WARN");
    	}
    	else{
    		Report.updateTestLog("Confirmation Page is not present in the application", "FAIL"); 
    	}
    	verifyAppointmentSectioninConfirmationPage();
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.CancelRescheduleKeepTrack"))){
    		Report.updateTestLog("Cancel Reschedule KeepTrack Link is Present in the Confirmation Page", "WARN"); 
    		
    	}
    	else{
    		Report.updateTestLog("Cancel Reschedule KeepTrack Link is not Present in the Confirmation Page", "FAIL");
    	}
    	
    }
    
    public void verifyRescheduleConfirmationPage(){
    	verifyAppointmentSectioninConfirmationPage();
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.CancelRescheduleKeepTrack"))){
    		Report.updateTestLog("Cancel Reschedule KeepTrack Link is Present in the Confirmation Page", "WARN"); 
    		
    	}
    	else{
    		Report.updateTestLog("Cancel Reschedule KeepTrack Link is not Present in the Confirmation Page", "FAIL");
    	}
    }
    public void verifyConfirmationPageFV(){
    	browser.wait(5000);
    	String confirmationText=browser.getTextByXpath(pageProperties.getProperty("ASV.ConfirmationText"));
    	String textConfirmation="Your First Service is booked";
    	if(confirmationText.contains(textConfirmation)){
    		Report.updateTestLog("Confirmation Page is present in the application", "PASS"); 	
    	}
    	else{
    		Report.updateTestLog("Confirmation Page is not present in the application", "FAIL"); 
    	}
    	verifyAppointmentSectioninConfirmationPage();
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.CancelRescheduleKeepTrack"))){
    		Report.updateTestLog("Cancel Reschedule KeepTrack Link is Present in the Confirmation Page", "WARN"); 
    		
    	}
    	else{
    		Report.updateTestLog("Cancel Reschedule KeepTrack Link is not Present in the Confirmation Page", "FAIL");
    	}
    }
    public void verifyAppointmentSectioninConfirmationPage(){
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.AddressSectionInConfirmationPage"))){
    		Report.updateTestLog("Appointmaent Section is Present in the Confirmation Page", "PASS");	
    	}
    	else{
    		Report.updateTestLog("Appointmaent Section is not Present in the Confirmation Page", "FAIL");
    	}
    	dateTime= browser.getTextByXpath(pageProperties.getProperty("ASV.DateTimeInConfirmationPage"));
    }
    public void navigateToAccountSumaryPageFromConfirmationPage(){
    	
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.GoToAccountSummaryPage"))){
    		verifyAndClickWithXpath(pageProperties.getProperty("ASV.GoToAccountSummaryPage"), "Go To Account Summary Page");   		
    	}
    }
    public void verifyAccountSummaryPage(){
    	/*browser.open(ApplicationConfig.APP_BG_URL+"/bgs-app/confirm-booking-summary/");
    	browser.wait(5000);*/
    	
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.BookAnEngineerLink"))){
    		Report.updateTestLog("Book an Engineer Link is Present in the Account Summary Page", "PASS");	
    	}
    	else{
    		Report.updateTestLog("Book an Engineer Link is not Present in the Account Summary Page", "FAIL");
    	}
    	verifySlotDates();
    	verifyYourAppointmentSectionInAccSummaryPage();
    }
    public void verifySlotDates(){
       String accSumDate = browser.getTextByXpath(pageProperties.getProperty("AccountSummaryPage.SlotDate").trim());
   	   String tempdateTime=  dateTime.replace( "-", "");
   	   String tempAccSumDate = accSumDate.replace( "-", "");
   	   tempAccSumDate = tempAccSumDate.replaceAll("\\n"," " );
   	   tempdateTime =  tempdateTime.replaceAll("\\n"," " );
   	   System.out.println("7777777777777777777777777777777777777777777"+tempdateTime);
   	   System.out.println("8888888888888888888888888888888888888888888"+tempAccSumDate);
   	   if(tempdateTime.equalsIgnoreCase(tempAccSumDate)){
   		  Report.updateTestLog("Slot Date in ASV confirmation Page is same as that of in Account Summary Page ", "WARN");
   		  Report.updateTestLog("Slot Date Section is Present in the application", "WARN");
   	   }
   	   else{
   		  Report.updateTestLog("Slot Date in ASV confirmation Page is not same as that of in Account Summary Page ", "FAIL");   
   	   }
   	 
      }
    public void verifyYourAppointmentSectionInAccSummaryPage(){
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.AppointmentSection"))){
    		Report.updateTestLog("Appointment Section is Present in the Account Summary Page", "WARN");	
    	}
    	else{
    		Report.updateTestLog("Appointment Section is not Present in the Account Summary Page", "FAIL");
    	}
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.ChangeBookingLink"))){
    		Report.updateTestLog("Change Booking Link is Present in the Account Summary Page", "PASS");	
    	}
    	else{
    		Report.updateTestLog("Change Booking Link is not Present in the Account Summary Page", "FAIL");
    	}
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.CancelBookingLink"))){
    		Report.updateTestLog("Cancel Booking Link is Present in the Account Summary Page", "PASS");	
    	}
    	else{
    		Report.updateTestLog("Cancel Booking Link is not Present in the Account Summary Page", "FAIL");
    	}
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.ViewDetails"))){
    		Report.updateTestLog("View Details Link is Present in the Account Summary Page", "PASS");	
    	}
    	else{
    		Report.updateTestLog("View Details Link is not Present in the Account Summary Page", "FAIL");
    	}
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.YourAppointmentStatus"))){
    		Report.updateTestLog("Your Appointment Status Section is Present in the Account Summary Page", "PASS");	
    	}
    	else{
    		Report.updateTestLog("Your Appointment Status Section is not Present in the Account Summary Page", "FAIL");
    	}
    	
    }
     public void cancelBooking(){
    	 browser.wait(5000);
    	 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.CancelBookingLink"))){
    		verifyAndClickWithXpath(pageProperties.getProperty("ASV.CancelBookingLink"), "Cancel Booking");
     		Report.updateTestLog("Cancel Booking Link is Present in the Account Summary Page", "WARN");
     	}
     	else{
     		Report.updateTestLog("Cancel Booking Link is not Present in the Account Summary Page", "FAIL");
     	} 
    	 browser.wait(5000);
    	 verifyAndConfirmCancelation();
    	 cancelYourAppointmentLandlord();
     }
     public void cancelYourAppointmentLandlord(){
    	 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.landlordCancelbooking"))){
     		verifyAndClickWithXpath(pageProperties.getProperty("ASV.landlordCancelbooking"), "Cancel Booking");
      		Report.updateTestLog("Cancel Booking Link is Present in the Account Summary Page", "PASS");	
      	}
      	else{
      		Report.updateTestLog("Cancel Booking Link is not Present in the Account Summary Page", "FAIL");
      	} 
     }
     
     public void cancelBookingFV(){
    	 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.CancelBookingLink"))){
    		verifyAndClickWithXpath(pageProperties.getProperty("ASV.CancelBookingLink"), "Cancel Booking");
     		Report.updateTestLog("Cancel Booking Link is Present in the Account Summary Page", "PASS");	
     	}
     	else{
     		Report.updateTestLog("Cancel Booking Link is not Present in the Account Summary Page", "FAIL");
     	} 
    	 browser.wait(5000);
    	 verifyAndConfirmCancelationFV();
    	 
     }
     public void changeBooking(){
    	 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.ChangeBookingLink"))){
    		verifyAndClickWithXpath(pageProperties.getProperty("ASV.ChangeBookingLink"), "Change Booking Link");
     		Report.updateTestLog("Change Booking Link is Present in the Account Summary Page", "PASS");	
     	}
     	else{
     		Report.updateTestLog("Change Booking Link is not Present in the Account Summary Page", "FAIL");
     	} 
    	 
     }
     
     public void verifyAndConfirmCancelation(){
    	 
    	 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.VerifyCancelConfirmationOverLay"))){
     		Report.updateTestLog("Cancel Confirmation OverLay is Present in the Account Summary Page", "PASS");	
     	}
     	else{
     		Report.updateTestLog("Cancel Confirmation OverLay is not Present in the Account Summary Page", "FAIL");
     	}
    	 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.VerifyBackLinkinConfirmationOverLay"))){
      		Report.updateTestLog("Back Link is Present in the Cancelation overlay", "PASS");	
      	}
      	else{
      		Report.updateTestLog("Back Link is nor Present in the Cancelation overlay", "FAIL");
      	}
    	 
    	 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.ConfirmationCancel"))){
    		verifyAndClickWithXpath(pageProperties.getProperty("ASV.ConfirmationCancel"), "Confirmation Cancel");
      		Report.updateTestLog("Confirm Cancellation button is present", "PASS");	
      	}
      	else{
      		Report.updateTestLog("Confirm Cancellation button is not Present", "FAIL");
      	}
    	browser.wait(10000) ;
    	
     }
 public void verifyAndConfirmCancelationFV(){
    	 
    	 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.VerifyCancelConfirmationOverLay"))){
     		Report.updateTestLog("Cancel Confirmation OverLay is Present in the Account Summary Page", "PASS");	
     	}
     	else{
     		Report.updateTestLog("Cancel Confirmation OverLay is not Present in the Account Summary Page", "FAIL");
     	}
    	 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.VerifyBackLinkinConfirmationOverLay"))){
      		Report.updateTestLog("Back Link is Present in the Cancelation overlay", "PASS");	
      	}
      	else{
      		Report.updateTestLog("Back Link is nor Present in the Cancelation overlay", "FAIL");
      	}
    	 
    	 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.ConfirmationCancel"))){
    		verifyAndClickWithXpath(pageProperties.getProperty("ASV.ConfirmationCancel"), "Confirmation Cancel");
      		Report.updateTestLog("Confirm Cancellation button is present", "PASS");	
      	}
      	else{
      		Report.updateTestLog("Confirm Cancellation button is not Present", "FAIL");
      	}
    	 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.cancelAppointment"))){
     		verifyAndClickWithXpath(pageProperties.getProperty("ASV.cancelAppointment"), "Cancel Appointment");
       		Report.updateTestLog("Cancel Appointment button is present", "PASS");	
       	}
       	else{
       		Report.updateTestLog("Cancel Appointment button is not Present", "FAIL");
       	}
    	browser.wait(10000) ;
    	 
     }
     public void returnToYourAccount(){
    	 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.ReturnToYourAccount"))){
     		verifyAndClickWithXpath(pageProperties.getProperty("ASV.ReturnToYourAccount"), "Return To Your Account");
       		Report.updateTestLog("Return To Your Account Link is present", "PASS");	
       	}
       	else{
       		Report.updateTestLog("Return To Your Account Link is not Present", "FAIL");
       	}
    	 browser.wait(10000) ;
    	 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.BookThisAppointmentlink"))){
    		 
    		 Report.updateTestLog("Book This Appointment is Present in the Account Summary Page", "WARN");	 
    	 }
    	 else{
    		 Report.updateTestLog("Book This Appointment is not Present in the Account Summary Page", "FAIL");	  
    	 }
     }
     public void verifyCancelfunctionality(){
    	 
    	 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.CancelLink"))){
      		  verifyAndClickWithXpath(pageProperties.getProperty("ASV.CancelLink"), "Cancel Link");
        		Report.updateTestLog("Cancel Link is present", "PASS");	
        	}
        	else{
        		Report.updateTestLog("Cancel Link is not Present", "FAIL");
        	}
     	 browser.wait(10000) ;
     	 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.BookThisAppointmentlink"))){
     		 
     		 Report.updateTestLog("Book This Appointment is Present in the Account Summary Page", "WARN");	 
     	 }
     	 else{
     		 Report.updateTestLog("Book This Appointment is not Present in the Account Summary Page", "FAIL");	  
     	 }
    	 
     	 
     	
     		
     	}
////////////////////////////////////////////////////////////////////Landlord ASV Booking//////////////////////////////////////////////////  
     
     public void navigateToLandlordServiceOverviewPage(){	 
    	  /*if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.LandlordAddressSection"))){
     		Report.updateTestLog("Address Section is Present in the Service Overview Page", "PASS");	
    	  }*/
     	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.LandlordYourAppointmentSection"))){
         Report.updateTestLog("Your Appointment Details Section is Present in the Service Overview Page", "WARN");	
     	}
        else{
        Report.updateTestLog("Your Appointment Details Section is Present in the Service Overview Page", "Fail");
        }
     	
        if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.GasApplianceSection"))){
        Report.updateTestLog("Gas Appliance Section is Present in the Service Overview Page", "PASS");
        }
        if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.LandlordChangeAppointmentlink"))){
        Report.updateTestLog("Change Appointment Link is Present in the Service OverviewPage", "PASS");
        }    
                 
        if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.LandlordBackLink"))){
        Report.updateTestLog("Back To Your Appointment Link is Present in the Service Overview Page", "PASS"); 
        }
        if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.LandlordCancelLink"))){
        Report.updateTestLog("Cancel Appointment Link is Present in the Service Overview Page", "PASS"); 
        }
        if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.LandlordContinue"))){
        verifyAndClickWithXpath(pageProperties.getProperty("ASV.LandlordContinue"), "Continue Link"); 
        Report.updateTestLog("Continue to Review details link is clicked ", "PASS");
        }
        else{
        Report.updateTestLog("Continue Link is not clicked", "Fail");
        }
        }
                             
             
            
public void LandlordAsvDueOverlay(){
	
	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.LandlordAsvDueOverlay")))
	{
	Report.updateTestLog("Keep This Appointment Overlay is present in the Application", "WARN");
	verifyIsElementVisibleWithXpath(pageProperties.getProperty("ASV.LandlordKeepThisAppointment"), "LandlordKeepThisAppointment");
	verifyAndClickWithXpath(pageProperties.getProperty("ASV.LandlordKeepThisAppointment"), "LandlordKeepThisAppointment");
	}
	else
	{
		Report.updateTestLog("Keep This Appointment Overlay is present in the Application", "FAIL");
	}
	
}
public void verifyLandlordCalendarPage(){
	
	 for (int i = 3 ;i<15;i++){
		for (int j = 4 ; j <15 ; j++){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.availableSlots").replace("Row", ""+i).replace("Col", ""+j))){
				verifyAndClickWithXpath(pageProperties.getProperty("ASV.availableSlots").replace("Row", ""+i).replace("Col", ""+j),"Available Slots");
				browser.wait(3000);
				verifyAndClickWithXpath(".//*[@title='Select this appointment'][@id='']", "Select this appointment Button in Over Lay");
				
				Report.updateTestLog("Next available slot is clicked successfully","WARN");	
			
				break;
			}
			
		}
		break;
	 }   
	 browser.wait(5000);
	 LandlordAsvDueOverlay();
	 
} 	 
///////////////////////////////////////////////////////Track An Engineer Deeplink/////////////////////////////////////////////////////////////
public void trackAnEngineer(){
	browser.open(ApplicationConfig.APP_BG_URL+"/trackanengineer");
}
public void verifyTrackAnEnginerrAppointmentSection(){
	
	browser.wait(2000);
	
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.AppointmentSection"))){
    		Report.updateTestLog("Appointment Section is Present in the Account Summary Page", "WARN");	
    	}
    	else{
    		Report.updateTestLog("Appointment Section is not Present in the Account Summary Page", "FAIL");
    	}
    	
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.ChangeBookingLink"))){
    		Report.updateTestLog("Change Booking Link is Present in the Account Summary Page", "PASS");	
    	}
    	else{
    		Report.updateTestLog("Change Booking Link is not Present in the Account Summary Page", "FAIL");
    	}
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.slotdate"))){
    		Report.updateTestLog("Slots date are displayed in the application","PASS");
    	}
    	else{
    		Report.updateTestLog("Slot date are not present in the application","FAIL");
    	}
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.CancelBookingLink"))){
    		Report.updateTestLog("Cancel Booking Link is Present in the Account Summary Page", "PASS");	
    	}
    	else{
    		Report.updateTestLog("Cancel Booking Link is not Present in the Account Summary Page", "FAIL");
    	}
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.ViewDetails"))){
    		Report.updateTestLog("View Details Link is Present in the Account Summary Page", "PASS");	
    	}
    	else{
    		Report.updateTestLog("View Details Link is not Present in the Account Summary Page", "FAIL");
    	}
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ASV.YourAppointmentStatus"))){
    		Report.updateTestLog("Your Appointment Status Section is Present in the Account Summary Page", "PASS");	
    	}
    	else{
    		Report.updateTestLog("Your Appointment Status Section is not Present in the Account Summary Page", "FAIL");
    	}	
}



     }
    

