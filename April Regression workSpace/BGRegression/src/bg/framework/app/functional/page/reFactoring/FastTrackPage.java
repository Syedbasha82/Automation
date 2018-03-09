package bg.framework.app.functional.page.reFactoring;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SiebelDataBase;
import bg.framework.common.functional.UIDriver;
import bg.framework.common.functional.WebDriverProvider;

public class FastTrackPage extends BasePage{
	private final static String SMR_FILE_NAME = "resources/reFactoring/FastTrack.properties";
	private static Properties pageProperties = new PropertyLoader(SMR_FILE_NAME).load();
	private static String accOvDate;
	private static String accSumDate;
	
	public void navigateToFastTrackPage(){
		browser.open(ApplicationConfig.APP_BG_URL+"/booking");
	}
		
	public void fastTrackASVLogin(UserProfile userProfile)
	{
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("FastTrack.LoginButton"))){
			Report.updateTestLog("Login Link is Present ", "PASS");
			
		}
		else{
			Report.updateTestLog("Login Link is not Present ", "PASS");
		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("FastTrack.RegisterButton"))){
			Report.updateTestLog("Login Link is Present ", "PASS");
			
		}
		else{
			Report.updateTestLog("Login Link is not Present ", "PASS");
		}
		verifyAndInputByXpath(pageProperties.getProperty("FastTrack.UserID"), "Unique Customer number field",userProfile.getBgsAccount());
		verifyAndInputByXpath(pageProperties.getProperty("FastTrack.PostCode"), "Postcode field",userProfile.getaddr());
		verifyAndClickWithXpath(pageProperties.getProperty("FastTrack.Continue"),"Continue object");
	}
	
	public void fastTrackConfirmAddressDetails(UserProfile userProfile)
	{		
		verifyAndClickWithXpath(pageProperties.getProperty("FastTrack.ConfirmContinue"), "Continue Button");
	}
	
	public void verifyNA2Message()
	{		
		verifyIsTextPresent(pageProperties.getProperty("FastTrack.NA2Head")); 
		verifyIsTextPresent(pageProperties.getProperty("FastTrack.NA2Message")); 
		verifyIsTextPresent(pageProperties.getProperty("FastTrack.Register")); 
		verifyIsTextPresent(pageProperties.getProperty("FastTrack.Login")); 
	}
	
	public void verifyNAWMessage()
	{		
		verifyIsTextPresent(pageProperties.getProperty("FastTrack.NA2Head")); 
		verifyIsTextPresent(pageProperties.getProperty("FastTrack.NA2Message")); 
		verifyIsTextPresent(pageProperties.getProperty("FastTrack.Register")); 
		verifyIsTextPresent(pageProperties.getProperty("FastTrack.Login")); 
	}
	
	public void fastTrackSelectAppointment(String strSlotType)
	{
		//verifyIsTextPresent(pageProperties.getProperty("FastTrack.BookPage"),"Choose an appointment page");
				verifyIsTextPresent(pageProperties.getProperty("FastTrack.BookPageSub"),"Choose an appointment page");
				
				
				if(strSlotType.equalsIgnoreCase("ALLDAY"))
				{
					if(browser.isTextPresent("All Day"))
					{
						Report.updateTestLog("All Day slots available in the page", "PASS");
					}
					else
					{
						Report.updateTestLog("All Day slots is not available in the page", "FAIL");
					}
						//verifyIsElementVisibleWithXpath(pageProperties.getProperty("FastTrack.BookLastSlot").replace("COL", ""+7).replace("ROW", ""+5),"All Day slots");
				
								int i=7;
								while(browser.isElementVisibleWithXpath(pageProperties.getProperty("FastTrack.BookContinue"))== false)
								{
									
								if(browser.isElementVisibleWithXpath(pageProperties.getProperty("FastTrack.BookLastSlot").replace("ROW", ""+i).replace("COL", ""+4)))
								{
									verifyAndClickWithXpath(pageProperties.getProperty("FastTrack.BookLastSlot").replace("ROW", ""+i).replace("COL", ""+4), "All Day Slots");
								}
								browser.wait(500);
								i = i - 1;
								if(i == 0)
								{
									break;
								}
								}
				}
				if(strSlotType.equalsIgnoreCase("FF"))
				{
					//verifyIsElementVisibleWithXpath(pageProperties.getProperty("FastTrack.BookLastSlot").replace("COL", ""+7).replace("ROW", ""+),"All Day slots");
						if(browser.isTextPresent("10am - 2pm"))
						{
							Report.updateTestLog("FF slots available in the page", "PASS");
						}
						else
						{
							Report.updateTestLog("FF slots is not available in the page", "FAIL");
						}
								int i=7;
								while(browser.isElementVisibleWithXpath(pageProperties.getProperty("FastTrack.BookContinue"))== false)
								{
									
									/*if(browser.isElementVisibleWithXpath(pageProperties.getProperty("FastTrack.BookLastSlot").replace("calendarRow", "calendarRow"+i).replace("COL", ""+2)))
									{
										verifyAndClickWithXpath(pageProperties.getProperty("FastTrack.BookLastSlot").replace("calendarRow", "calendarRow"+i).replace("COL", ""+2), "FF Day Slots");
									}*/
									
									if(browser.isElementVisibleWithXpath(pageProperties.getProperty("FastTrack.BookLastSlot").replace("ROW", ""+i).replace("COL", ""+2)))
									{
										verifyAndClickWithXpath(pageProperties.getProperty("FastTrack.BookLastSlot").replace("ROW", ""+i).replace("COL", ""+2), "FF Day Slots");
									}
								browser.wait(500);
								i = i - 1;
								if(i == 0)
								{
									
									break;
								}
								}
				}
								verifyAndClickWithXpath(pageProperties.getProperty("FastTrack.BookContinue"),"Continue button");
	}
	

	
	public void addCOD(UserProfile userProfile) {
		//browser.wait(1000);
		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("FastTrack.COD"), "COD");
		verifyAndClickWithXpath(pageProperties.getProperty("FastTrack.COD"),
				"Add COD");
		/*verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("FastTrack.ReviewContinue"),
				"Continue button ");*/
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("FastTrack.ReviewContinue"))){
			verifyAndClickWithXpath(pageProperties.getProperty("FastTrack.ReviewContinue"),
			"Confirm");
		}
		else{
			verifyAndClickWithXpath(pageProperties.getProperty("FastTrack.ReviewContinue1"),"********Continue Button Field**********");
		}
		

		browser.wait(5000);

		payment();

		browser.wait(1000);

		if (browser.getTextByXpath(".//*[@id='h1']").contains(
				"Your annual service is booked")
				|| browser.getTextByXpath(".//*[@id='h1']").contains(
						"Your appointment has been rescheduled")|| browser.getTextByXpath(".//*[@id='h1']").contains(
						"Your First Service is booked")) {
			Report.updateTestLog("Confirmation page is loaded", "PASS");
		} else {
			Report.updateTestLog("Confirmation page is not loaded", "FAIL");

		}
	}
	
	public void confirmButton(){
	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("FastTrack.ReviewContinue"))){
		verifyAndClickWithXpath(pageProperties.getProperty("FastTrack.ReviewContinue"),
		"Confirm");
	}
	else{
		verifyAndClickWithXpath(pageProperties.getProperty("FastTrack.ReviewContinue1"),"@@@@@@@@@@@@@@@@@@@@@Continue Button Field@@@@@@@@@@@@@@@@@@");
	}
	browser.wait(getWaitTime());
	}	
	
	public void payment() {
		/*verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("FastTrack.PopUp"), "Payment popup");

		verifyAndClickWithXpath(pageProperties.getProperty("FastTrack.PopUp"),
				"Payment Popup");*/
		browser.wait(5000);
		verifyIsElementVisibleById(
				pageProperties.getProperty("FastTrack.CardType"),
				"Payment card type");
		verifyAndSelectDropDownBox(
				pageProperties.getProperty("FastTrack.CardType"), "Card Type",
				"Visa Debit");

		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("FastTrack.CardName"),
				"Payment card Name");
		verifyAndInputByXpath(pageProperties.getProperty("FastTrack.CardName"),
				"Card Name", "Test");

		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("FastTrack.cardNumber"),
				"Payment card number");
		verifyAndInputByXpath(pageProperties.getProperty("FastTrack.cardNumber"),
				"Card Number", "4012001037141112");

		verifyIsElementVisibleById(
				pageProperties.getProperty("FastTrack.cardStartMonth"),
				"Payment card start month field");

		/*verifyAndSelectDropDownBox(
				pageProperties.getProperty("FastTrack.cardStartMonth"),
				"Start Month", "11");
		verifyIsElementVisibleById(
				pageProperties.getProperty("FastTrack.cardStartYear"),
				"Payment card start year field");
		verifyAndSelectDropDownBox(
				pageProperties.getProperty("FastTrack.cardStartYear"),
				"Card Start Year", "2008");*/

		verifyIsElementVisibleById(pageProperties.getProperty("FastTrack.cardExpiryMonth"),"Payment card end month field");
		verifyAndSelectDropDownBox(pageProperties.getProperty("FastTrack.cardExpiryMonth"),"Card Expiry Month", "8");
		verifyIsElementVisibleById(pageProperties.getProperty("FastTrack.cardExpiryYear"),"Payment card end year field");
		verifyAndSelectDropDownBox(pageProperties.getProperty("FastTrack.cardExpiryYear"),"Card Expiry Year", "2016");
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("FastTrack.cardCVV"),"Payment card CVV field");
		verifyAndInputByXpath(pageProperties.getProperty("FastTrack.cardCVV"),"Card CVV Number", "751");
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("FastTrack.submitButton"),"Payment submit field");
		Report.updateTestLog("Payment details submitted successfully ","WARN");
		verifyAndClickWithXpath(pageProperties.getProperty("FastTrack.submitButton"),"Submit Button");
		browser.wait(10000);

		/*browser.selectWindowById(0);
    	WebElement element = browser.getElementByXpath("//div[@id='CompanyLogo']");
    	        element.click();*/
    	        browser.wait(7000);
    	        browser.swtichToDefaultContent();
	}
	
	public void fastTrackNavigateToConfirmation()
	{
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("FastTrack.ReviewContinue1"),"--------------Continue Button Field-------------");
		verifyAndClickWithXpath(pageProperties.getProperty("FastTrack.ReviewContinue1"),"&&&&&&&&&&&&&Continue Button Field&&&&&&&&&&&&&&&&&&");
		
	}
	
	public void addGAC() {
		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("FastTrack.GAC"), "GAC link");
		//browser.wait(1000);
		verifyAndClickWithXpath(pageProperties.getProperty("FastTrack.GAC"), "GAC");
		

		/*verifyIsTextPresent(
				pageProperties.getProperty("FastTrack.GACaddedLink"),
				"Request Call Back");*/
	}
	


 
	public void navigateToAccountSummaryPage(UserProfile userProfile) {
		browser.wait(8000);
		
		verifyAndClickWithXpath(
				(pageProperties.getProperty("FastTrack.ManageAccountXPath").replace(
						"USERACCOUNTNUMBER", userProfile.getAccNumber())),
				"Account summary");
		browser.wait(1000);		

	}
	
	public void verifyWorkReq(String strWorkReq) {
		browser.wait(8000);
		
		verifyIsElementVisibleWithXpath("//a[contains(@href,'"+strWorkReq+"')]","Work Request Number From WMIS");
				
		browser.wait(1000);		

	}
	
	public void accountSummarycancelAppointment() {
		browser.wait(1000);
		
		
		verifyAndClickWithLinkText(
				pageProperties.getProperty("FastTrack.Cancel"),
				"Cancel link");
		int i =1;
		while (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("FastTrack.Confirm")) == false) {
			
			verifyAndClickWithLinkText(
					pageProperties.getProperty("FastTrack.Cancel"),
					"Cancel link");
			browser.wait(2000);
			i++;
			if(i>5)
			{
				Report.updateTestLog("No Cancel appointment link", "FAIL");
				break;
			}
		}
		confirmCancelAppointment();
	}
	
	public void confirmCancelAppointment() {
		browser.wait(2000);
		
		verifyAndClickWithXpath(
				pageProperties.getProperty("FastTrack.Confirm"),
				"Confirm Booking");

		browser.wait(2000);

	

		verifyAndClickWithLinkText(
				pageProperties.getProperty("FastTrack.Return"),
				"Return to Account Summary");
	}

	public void verifyBookedSlotPage() {
		browser.wait(2000);
		verifyIsTextPresent(pageProperties.getProperty("FastTrack.AlreadyBookedInfoMessage"));
		verifyIsTextPresent(pageProperties.getProperty("FastTrack.Register"));
		verifyIsTextPresent(pageProperties.getProperty("FastTrack.Login"));		
		verifyAndClickWithLinkText(pageProperties.getProperty("FastTrack.Register"), "Register Now");
		Report.updateTestLog("Screenshot of register page", "WARN");
		browser.browserBack();
		verifyAndClickWithLinkText(pageProperties.getProperty("FastTrack.Login"), "Login");
		Report.updateTestLog("Screenshot of Login Page", "WARN");
	}
	public void verifyAppointmentSelectionCalender(){
		//verifyIsElementVisibleWithXpath(pageProperties.getProperty("FastTrack.FirstAvailableAppointmentSection"), "First Available Appointment Section");
		//verifyIsElementVisibleWithXpath(pageProperties.getProperty("FastTrack.DateandTime"), "Date and Time Text in First Available Appointment Section");
		Report.updateTestLog("First availble appointments is displayed","WARN");	
		//verifyIsElementVisibleWithXpath(pageProperties.getProperty("FastTrack.ViewCalendarSection"), "View Calendar Section");
		/*verifyIsElementVisibleWithXpath(pageProperties.getProperty("FastTrack.ViewCalendarPanel"), "View Calendar Panel");*/
		//verifyIsElementVisibleWithXpath(pageProperties.getProperty("FastTrack.BackLink"), "BackL ink");
		//verifyIsElementVisibleWithXpath(pageProperties.getProperty("FastTrack.CancelLink1"), "Cancel Link ");
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("FastTrack.CancelBooking"), "Cancel Link ");
        Report.updateTestLog("Appointment Selection Page", "WARN");
        
          //verifyAndClickWithXpath(pageProperties.getProperty("FastTrack.ViewCalender"),"View calender Button");
           //browser.wait(3000);
           
           for (int i = 3 ;i<15;i++){
   			for (int j = 4 ; j <15 ; j++){
   				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("FastTrack.availableSlots").replace("Row", ""+i).replace("Col", ""+j))){
   					System.out.println("2222222222");
   					verifyAndClickWithXpath(pageProperties.getProperty("FastTrack.availableSlots").replace("Row", ""+i).replace("Col", ""+j),"Available Slots");
   					browser.wait(3000);
   					verifyAndClickWithXpath(".//*[@title='Select this appointment'][@id='']", "Select this appointment Button in Over Lay");
   					Report.updateTestLog("Next available slot is clicked successfully","WARN");	
   				
   					break;
   				}
   				break;
   			}
   		
   		 }

     }

      public void fastTrackReviewPageDetails(UserProfile userProfile)
   {
    	  //if(browser.isElementVisibleWithXpath(pageProperties.getProperty("FTASV.changeAppLink"))){
    	  if(browser.isElementVisibleWithXpath(pageProperties.getProperty("FastTrack.ChangeAppoitmentLink"))){
  			Report.updateTestLog("Change Appointment Link is Present","Pass");	
 
  		}
  		else{
  			Report.updateTestLog("Change Appointment Link is not Present","FAIL");	
  		}
    
     //browser.wait(2000);
     verifyIsTextPresent(pageProperties.getProperty("FastTrack.ReviewPage"),"Review Details Page text");
	 verifyIsTextPresent(pageProperties.getProperty("FastTrack.ReviewPage1"),"Review Details Page text ");
     verifyAndInputByXpath(pageProperties.getProperty("FastTrack.ReviewEmail"),"Email Field",userProfile.getEmail());
     verifyAndInputByXpath(pageProperties.getProperty("FastTrack.ReviewConfirmEmail"),"Confirm Email Field",userProfile.getEmail());
     verifyAndInputByXpath(pageProperties.getProperty("FastTrack.ReviewContactNumber"),"Contact Number Field",userProfile.getPhoneNumber());
     Report.updateTestLog("Review Deails Page", "WARN");
 
   
   }

      public void fastTrackConfirmationPage()
   {
    	verifyIsTextPresent(pageProperties.getProperty("FastTrack.ConfirmationPage"),"Confirmation Page text");
  		verifyIsTextPresent(pageProperties.getProperty("FastTrack.ConfirmationPage1"),"Confirmation Page text");
  		verifyIsTextPresent(pageProperties.getProperty("FastTrack.ConfirmationPage2"),"Confirmation Page text");
  		//verifyIsTextPresent(pageProperties.getProperty("FastTrack.ConfirmationPrint"),"Print Page Link");
  		//verifyIsTextPresent(pageProperties.getProperty("FastTrack.ConfirmationTrackAppointment"),"Track changes appointment link");				
  		//verifyAndClickWithLinkText(pageProperties.getProperty("FastTrack.ConfirmationTrackAppointment"),"Track Appointment");
        verifyIsTextPresent(pageProperties.getProperty("FastTrack.ConfirmationPage1"),"Confirmation Page text");
        Report.updateTestLog("Confirmation page is loaded", "WARN");

   }
      
     public void fastTrackOneClickRegistrationPage(UserProfile userProfile)
     
     {
   
    	browser.wait(1000);
    	if (browser.isElementVisibleWithXpath(pageProperties.getProperty("FastTrack.OneClickOVerlay"))){
        Report.updateTestLog("One Click Register Component is displayed","WARN");
    	}
    	else{
    	Report.updateTestLog("One Click Register Component is not displayed","FAIL");
    	}
    	
    	verifyAndInputByXpath(pageProperties.getProperty("FastTrack.EnterPassword"),"Enter Password",userProfile.getPassword());
    	//verifyAndInputByXpath(pageProperties.getProperty("FastTrack.Confirmpassword"),"Enter Confirm Password",userProfile.getPassword());
    	verifyAndClickWithXpath(pageProperties.getProperty("FastTrack.CheckBox"),"Check Box ");
    	verifyIsElementVisibleWithXpath(pageProperties.getProperty("FastTrack.CancelLink"),"Cancel link");
    	Report.updateTestLog("Creating an Online Account","WARN");
    	verifyAndClickWithXpath(pageProperties.getProperty("FastTrack.CreateAccoutButton"),"Create Account");
    	browser.wait(9000);
     }
     

      public void navigateToLoginPage()
  {
      verifyAndClickWithXpath(pageProperties.getProperty("FastTrack.ConfirmationPageLogin"),"Confirmation Page Login");
  }
      public void checkErrorMsgForInvalidDetails()
      {
       String errorMsg1=  browser.getTextByXpath(pageProperties.getProperty("FastTrack.errorMsg1"));
       System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+errorMsg1);
       String errorMsg =  "Please enter valid details.";
       if(errorMsg1.contains(errorMsg)){
    	   Report.updateTestLog("Error Message for Invalid Details:" +errorMsg+ " Displayed Successfully", "WARN");
       }
       else{
    	  Report.updateTestLog("Error Message for Invalid Details not Displayed Successfully", "Fail");
       }
       
      }
      public void checkErrorMsgForForSlotUnavailability()
      {
       String errorMsg2=  browser.getTextByXpath(pageProperties.getProperty("FastTrack.errorMsg2"));
       System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+errorMsg2);
       String errorMsg =  "Sorry, booking is unavailable.";
       if(errorMsg2.contains(errorMsg)){
    	   Report.updateTestLog("Error Message for Slot Unavailability:" +errorMsg+ " Displayed Successfully", "WARN");
       }
       else{
    	  Report.updateTestLog("Error Message for Slot Unavailability not Displayed Successfully", "Fail");
       }
       
      }

     public void loginUser(UserProfile userProfile) 
  {
     
     verifyAndInputById(pageProperties.getProperty("FastTrack.NewEmail"),
                 "Email Id", userProfile.getEmail());
     verifyAndInputById(pageProperties.getProperty("FastTrack.NewPassword"),
                 "Password", userProfile.getPassword());
     browser.clickWithXpath(pageProperties
                 .getProperty("FastTrack.NewLoginSubmitXpath"));
     browser.wait(getWaitTime());

   }

     public void verifyAppointmentSectioninAccountOverview(UserProfile userProfile)
   {

    	 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("AccountOverviewPage.SlotDate").replace("USERACCOUNTNUMBER",userProfile.getAccNumber()))){
             Report.updateTestLog("Slot Date Section is Present in Account OverViewPage", "WARN");      
          }
        else {
             Report.updateTestLog("Slot Date Section is not Present in the application", "FAIL");
          }

         /*accOvDate = browser.getTextByXpath(pageProperties.getProperty("AccountOverviewPage.SlotDate").replace("USERACCOUNTNUMBER",userProfile.getAccNumber()).trim());
         Report.updateTestLog("Slot Date Section is Present in the application", "WARN");
*/
          }

   public void navigateToAccountSummaryPageviaAppointmentLink()
   {
	browser.wait(10000);
    verifyAndClickWithXpath(pageProperties.getProperty("AccountOverviewPage.Appointmentlink"), "Appointment link");

   }
   public void verifyAppointmentSectioninAccountSummary()
   {

         if(browser.isElementVisibleWithXpath(pageProperties.getProperty("AccountSummaryPage.SlotDate"))){
             Report.updateTestLog("Slot Date Section is Present in the Account Summary Page", "WARN");      
          }
        else {
             Report.updateTestLog("Slot Date Section is not Present in the application", "FAIL");
          }

      
          }

   public void verifySlotDates(){

     accSumDate = browser.getTextByXpath(pageProperties.getProperty("AccountSummaryPage.SlotDate").trim());
     String tempAccOvDate=  accOvDate.replace( "-", "");
     String tempAccSumDate = accSumDate.replace( "-", "");
     tempAccSumDate = tempAccSumDate.replaceAll("\\n"," " );
       if(tempAccOvDate.equalsIgnoreCase(tempAccSumDate)){
           Report.updateTestLog("Slot Date in Account Overview Page is similar as that of in Account Summary Page ", "PASS"); 
        }
      else{
           Report.updateTestLog("Slot Date in Account Overview Page is not similar as that of in Account Summary Page ", "FAIL");   
       }
      Report.updateTestLog("Slot Date Section is Present in the application", "WARN");
       }
   public void AgainChooseApoitmnet()
   {
	   browser.wait(getWaitTime());
	   /*String bookingPage = browser.getTextByXpath(pageProperties.getProperty("AdjuseMonthlyPayment.ConfirmationPage"));
   	Report.updateTestLog(confirm+ "Content Is Populated", "WARN");*/
	   
	   verifyIsTextPresent("You already have an appointment booked for your annual service visit");
	   
   }
   public void ClickAccountSummary()
   {
	   browser.wait(getWaitTime());
	   /*String bookingPage = browser.getTextByXpath(pageProperties.getProperty("AdjuseMonthlyPayment.ConfirmationPage"));
   	Report.updateTestLog(confirm+ "Content Is Populated", "WARN");*/
	   
	   verifyAndClickWithXpath(pageProperties.getProperty("FastTrack.Accountsummarybutton"),"AccountSummary Option ");
	   
   }
   public void ClickCancelbutton()
   {
	   browser.wait(getWaitTime());
	   /*String bookingPage = browser.getTextByXpath(pageProperties.getProperty("AdjuseMonthlyPayment.ConfirmationPage"));
   	Report.updateTestLog(confirm+ "Content Is Populated", "WARN");*/
	   
	   verifyAndClickWithXpath(pageProperties.getProperty("FastTrack.Cancelbutton"),"AccountSummary Option ");
	   
   }
}


