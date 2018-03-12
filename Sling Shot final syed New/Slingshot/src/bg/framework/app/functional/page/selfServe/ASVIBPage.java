package bg.framework.app.functional.page.selfServe;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.RobotSendKeys;
import bg.framework.common.functional.UIDriver;
import bg.framework.common.functional.WebDriverProvider;

public class ASVIBPage extends BasePage {
	
	private final static String SMR_FILE_NAME = "resources/selfServe/ASVIB.properties";
	private static Properties pageProperties = new PropertyLoader(SMR_FILE_NAME)
			.load();

	public ASVIBPage() {

	}

	String[] lstFaultItems = new String[3];

	// List lstFaultItems;
	public ASVIBPage(UserProfile userProfile) {
	}

	
	public void navigateToAccountSummary(UserProfile userProfile) {
		browser.wait(5000);

		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty(
						"ASVIBAccountOverviewPage.ManageAccLink").replace(
						"USERACCOUNTNUMBER",
						userProfile.getAccNumber().toString()),
				"Manage Account Link");
		verifyAndClickWithXpath(
				pageProperties.getProperty("ASVIBAccountOverviewPage.ManageAccLink")
						.replace("USERACCOUNTNUMBER",
								userProfile.getAccNumber().toString()),
				"Manage Account");
		browser.wait(1000);
		//verifyIsTextPresent("Your accounts", "Account summary page");
	}

	public void bookAnEngineer(UserProfile userProfile, String strType) {
		browser.wait(6000);		
	verifyAddress(userProfile);
		if (strType.equalsIgnoreCase("ASV")) {
			verifyIsTextPresent(
					pageProperties
							.getProperty("ASVIBAccountSummary.BookAnAppointment"),
					"Book an appointment");
			verifyAndClickWithLinkText(
					pageProperties
							.getProperty("ASVIBAccountSummary.BookAnAppointment"),
					"Book An Appointment");
		} else {
			verifyIsTextPresent(
					pageProperties.getProperty("ASVIBAccountSummary.BookAnEngineer"),
					"Book An Engineer");
			verifyAndClickWithLinkText(
					pageProperties.getProperty("ASVIBAccountSummary.BookAnEngineer"),
					"Book AN Engineer");
			browser.wait(2000);
		}
		verifyAddress(userProfile);
	}

	public void navigateToIdentifyFault() {

		browser.wait(3000);

		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBSelectAppliance.HeadText"));
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBSelectAppliance.SelectText"));
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBSelectAppliance.SelectSlot"));
		
		/*verifyIsTextPresent(pageProperties
				.getProperty("ASVIBSelectAppliance.EmergencyText"));*/
		
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBSelectAppliance.AwaitingSelection"));

		new IBPage().clickFaultItemCheck();

		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBSelectAppliance.FaultyApplianceText"));		

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
					"Continue Button");

			while (browser.isElementVisibleWithXpath(pageProperties
					.getProperty("ASVIBSelectAppliance.ContinueDis")) == true) {
				verifyAndClickWithXpath(
						pageProperties.getProperty("ASVIBAccountSummary.faultItem")
								.replace("3", "" + itemCount)
								.replace("0", "" + faultCount), "Fault Item");
				strTemp = browser.getTextByXpath(pageProperties
						.getProperty("ASVIBAccountSummary.faultItem")
						.replace("3", "" + itemCount)
						.replace("0", "" + faultCount)
						.replace("input", "label"));

				itemCount++;
				if (browser.isElementVisibleWithXpath(pageProperties
						.getProperty("ASVIBAccountSummary.faultItem").replace("3",
								"" + itemCount)) == false) {
					itemCount = 3;
					faultCount = faultCount + 1;
				}
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

	public void navigateToReview(int intFlag) {
		browser.wait(1000);				
		
		if(intFlag==2)
		{
//			
//			browser.open("https://10.224.70.85/reschedule/show-slot-priority/?OAMMRApptType=ASV%20and%20IB&OAMMRBarType=Gas");
			verifyAndClickWithXpath(pageProperties.getProperty("ASVIBIdentifyFault.Continue"),"Continue");
			//verifyAndClickWithXpath(pageProperties.getProperty("ASVIBIdentifyFault.RescheduleContinue1"),"Continue");
			/*RobotSendKeys.type('\t');
			RobotSendKeys.typeenter();*/
		}
		else
{
	
		if (intFlag == 1) {
		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("ASVIBIdentifyFault.PopUpContinue"),
				"Navigated to Book an engineer to fix a fault  page");
		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("ASVIBIdentifyFault.PopUpContinue"), "Popup page");

		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBIdentifyFault.HeaderText"));

		if (intFlag == 1) {
			verifyIsElementVisibleWithXpath(
					pageProperties.getProperty("ASVIBIdentifyFault.PopUpContinue"),
					"Continue button");
			verifyAndClickWithXpath(
					pageProperties.getProperty("ASVIBIdentifyFault.PopUpContinue"),
					"Continue Identify Fault");
		}

		browser.wait(1000);	

		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("ASVIBIdentifyFault.Continue"),
				"Continue button");
		verifyAndClickWithXpath(
				pageProperties.getProperty("ASVIBIdentifyFault.Continue"),
				"Continue");
}

}
}

	public void verifyAddress(UserProfile userProfile)
	{
		/*List<String> lstAddr =  new SiebelDataBase().getAddress(userProfile.getAccNumber());
		Iterator iteAddr = lstAddr.iterator();
		String strIteAddress = "";
		while(iteAddr.hasNext())
		{
			try
			{
			strIteAddress = iteAddr.next().toString();
			System.out.println("================{Address}=========================>>>"+strIteAddress);
			verifyIsTextPresent(strIteAddress);
			}
			catch(Exception ex)
			{
				
			}
		}*/
		
		verifyIsTextPresent(userProfile.getHomeNumber(),"House Number");
		verifyIsTextPresent(userProfile.getStreet(), "Street Name");
		verifyIsTextPresent(userProfile.getLocalArea(), "Local Area");
		verifyIsTextPresent(userProfile.getCity(),"City");
		verifyIsTextPresent(userProfile.getCountry(),"Country");
	}

	public void navigateToConfirmation(UserProfile userProfile, int intOption) {
		browser.wait(4000);

		if (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("ASVIBIdentifyFault.Continue"))) {
			verifyIsElementVisibleWithXpath(
					pageProperties.getProperty("ASVIBIdentifyFault.Continue"),
					"Continue button");
		}

		if (browser.isTextPresent("Book an annual service visit")) {
			verifyIsTextPresent("Book an annual service visit");

		} else if (browser.isTextPresent("Book an engineer to fix a fault")) {
			verifyIsTextPresent("Book an engineer to fix a fault");
		} else {
			Report.updateTestLog("The Header text is not present", "FAIL");
		}

		if (intOption == 1) {
			verifyIsElementVisibleWithXpath(
					pageProperties
							.getProperty("ASVIBBookAppointment.BookThisAppointment"),
					"Book This Appointment button");
			verifyAndClickWithXpath(
					pageProperties
							.getProperty("ASVIBBookAppointment.BookThisAppointment"),
					"Book This Appointment");
		}

		if (intOption == 2) {
			verifyIsElementVisibleWithXpath(
					pageProperties.getProperty("ASVIBBookAppointment.Continue"),
					"Continue button");
			verifyAndClickWithXpath(
					pageProperties.getProperty("ASVIBBookAppointment.Continue"),
					"Book This Appointment");
		}
		browser.wait(1000);

		if (intOption == 3) {
			verifyIsElementVisibleWithXpath(
					pageProperties
							.getProperty("ASVIBBookAppointment.BookThisAppointment"),
					"Book This Appointment button");
			verifyAndClickWithXpath(
					pageProperties
							.getProperty("ASVIBBookAppointment.BookThisAppointment"),
					"Book This Appointment");
			browser.wait(1000);
		}
		verifyAddress(userProfile);
		
		reviewDetailsPage();

		if (intOption == 3) {
			browser.wait(1000);
			addCOD(userProfile);
		} else {

			if (browser.isElementVisibleWithXpath(pageProperties
					.getProperty("ASVIBReview.Continue"))) {
				verifyAndClickWithXpath(
						pageProperties.getProperty("ASVIBReview.Continue"),
						"Confirm");
			}
			browser.wait(1000);
			
			if (browser.isElementVisibleWithXpath(pageProperties
					.getProperty("ASVIBPayment.PopUp"))) {
				verifyIsElementVisibleWithXpath(
						pageProperties.getProperty("ASVIBPayment.PopUp"), "popup");
				Report.updateTestLog("Payment popup is displayed", "Done");
				payment();
			}
			verifyAddress(userProfile);
			verifyConfirmationPage();

		}
		browser.wait(1000);

		browser.wait(1000);

	

	}

	public void navigateToConfirmation() {
		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("ASVIBReview.Continue"),
				"Continue button");

		verifyAndClickWithXpath(pageProperties.getProperty("ASVIBReview.Continue"),
				"Confirm");
		if (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("ASVIBPayment.PopUp"))) {
			verifyIsElementVisibleWithXpath(
					pageProperties.getProperty("ASVIBPayment.PopUp"), "popup");
			Report.updateTestLog("Payment popup is displayed", "Done");
			payment();
		}
		verifyConfirmationPage();
	}

	public void verifyConfirmationPage() {
	
		verifyIsTextPresent(
				pageProperties.getProperty("ASVIBConfirmation.LongMessageText"),
				"Text:We'll send a reminder nearer the time of your booking, and the engineer will call you on the day to let you know when they're on their way");
		verifyIsTextPresent(
				pageProperties.getProperty("ASVIBConfirmation.TrackCancelChange"),
				"TrackCancelChange link");
	

		dateCheck();

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
	
	public void confirmationImageCheck()
	{
		if(!browser.isElementVisibleWithXpath(pageProperties.getProperty("ASVIBConfirmation.Image")))
		{
			Report.updateTestLog("Static image is not found", "PASS");
		}
		else
		{
			Report.updateTestLog("Static image is found", "FAIL");
		}
	}

	public void dateCheck() {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat oDateFormat = new SimpleDateFormat("yyyy");
		for (int i = 0; i <= 6; i++) {
			String oStrDate = "";
			currentDate.add(Calendar.DATE, i);
			oStrDate = oDateFormat.format(currentDate.getTime());
			String monthName[] = new DateFormatSymbols().getMonths();
			String dayName[] = new DateFormatSymbols().getWeekdays();
			String FinalDate = dayName[currentDate.get(currentDate.DAY_OF_WEEK)]
					.toString()
					+ " "
					+ currentDate.get(currentDate.DAY_OF_MONTH)
					+ " "
					+ monthName[currentDate.get(currentDate.MONTH)].toString()
					+ " " + oStrDate;

			/*if (browser.getTextByXpath(
					pageProperties.getProperty("ASVIBReview.SelectedDate"))
					.equalsIgnoreCase(FinalDate)) {
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
			}*/

		}
	}

	public void reviewDetailsPage() {

		dateCheck();
		/*
		 * Verification of Text
		 */
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

		/*
		 * Accessing Elements
		 */
		verifyAndClickWithXpath(
				pageProperties.getProperty("ASVIBReview.MobileNumberRadio"),
				"Mobile Number");
		verifyAndInputByXpath(
				pageProperties.getProperty("ASVIBReview.MobileNumberText"),
				"Mobile Number Text", "0123465789");
	}

	public void clickGAC() {
		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("ASVIBReview.GAC"), "GAC link");
		browser.wait(1000);
		verifyAndClickWithXpath(pageProperties.getProperty("ASVIBReview.GAC"), "GAC");

		verifyIsTextPresent(
				pageProperties.getProperty("ASVIBContactDetails.GACaddedLink"),
				"Request Call Back");
	}

	public void addGAC() {
		clickGAC();
		navigateToConfirmation();
	}

	public void addCOD(UserProfile userProfile) {
		browser.wait(1000);
		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("ASVIBReview.COD"), "COD");
		verifyAndClickWithXpath(pageProperties.getProperty("ASVIBReview.COD"),
				"Add COD");
		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("ASVIBReview.Continue"),
				"Continue button ");
		verifyAndClickWithXpath(pageProperties.getProperty("ASVIBReview.Continue"),
				"Confirm");

		browser.wait(5000);

		payment();

		browser.wait(1000);

		if (browser.getTextByXpath(".//*[@id='h1']").contains(
				"Your annual service is booked")
				|| browser.getTextByXpath(".//*[@id='h1']").contains(
						"Your appointment has been rescheduled")) {
			Report.updateTestLog("Confirmation page is loaded", "PASS");
		} else {
			Report.updateTestLog("Confirmation page is not loaded", "FAIL");

		}
		
		browser.wait(1000);
		verifyAddress(userProfile);
	}

	public void payment() {
		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("ASVIBPayment.PopUp"), "Payment popup");

		verifyAndClickWithXpath(pageProperties.getProperty("ASVIBPayment.PopUp"),
				"Payment Popup");
		browser.wait(5000);
		verifyIsElementVisibleById(
				pageProperties.getProperty("ASVIBPayment.CardType"),
				"Payment card type");
		verifyAndSelectDropDownBox(
				pageProperties.getProperty("ASVIBPayment.CardType"), "Card Type",
				"Visa Debit");

		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("ASVIBPayment.CardName"),
				"Payment card Name");
		verifyAndInputByXpath(pageProperties.getProperty("ASVIBPayment.CardName"),
				"Card Name", "Test");

		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("ASVIBPayment.cardNumber"),
				"Payment card number");
		verifyAndInputByXpath(pageProperties.getProperty("ASVIBPayment.cardNumber"),
				"Card Number", "4539791001730106");

		verifyIsElementVisibleById(
				pageProperties.getProperty("ASVIBPayment.cardStartMonth"),
				"Payment card start month field");

		verifyAndSelectDropDownBox(
				pageProperties.getProperty("ASVIBPayment.cardStartMonth"),
				"Start Month", "11");
		verifyIsElementVisibleById(
				pageProperties.getProperty("ASVIBPayment.cardStartYear"),
				"Payment card start year field");
		verifyAndSelectDropDownBox(
				pageProperties.getProperty("ASVIBPayment.cardStartYear"),
				"Card Start Year", "2008");

		verifyIsElementVisibleById(
				pageProperties.getProperty("ASVIBPayment.cardExpiryMonth"),
				"Payment card end month field");
		verifyAndSelectDropDownBox(
				pageProperties.getProperty("ASVIBPayment.cardExpiryMonth"),
				"Card Expiry Month", "3");

		verifyIsElementVisibleById(
				pageProperties.getProperty("ASVIBPayment.cardExpiryYear"),
				"Payment card end year field");
		verifyAndSelectDropDownBox(
				pageProperties.getProperty("ASVIBPayment.cardExpiryYear"),
				"Card Expiry Year", "2013");

		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("ASVIBPayment.cardCVV"),
				"Payment card CVV field");
		verifyAndInputByXpath(pageProperties.getProperty("ASVIBPayment.cardCVV"),
				"Card CVV Number", "123");

		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("ASVIBPayment.submitButton"),
				"Payment submit field");
		verifyAndClickWithXpath(
				pageProperties.getProperty("ASVIBPayment.submitButton"),
				"Submit Button");

		browser.wait(10000);

		UIDriver driver = WebDriverProvider.getCurrentDriver();

		driver.switchTo().frame(
				driver.findElement(By.xpath(".//*[@id='message']/iframe")));
		verifyIsElementVisibleWithXpath(
				"html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/input",
				"Security Check page");
		verifyIsElementVisibleWithXpath(
				"html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/input",
				"Security Check submit field");
		verifyAndClickWithXpath(
				"html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/input",
				"Security check submit button");
		Alert alert =  driver.switchTo().alert();
		alert.accept();
		browser.swtichToDefaultContent();
	}

	public void accountOverviewBookAnEngineer() {
		browser.wait(2000);
		verifyIsTextPresent(
				pageProperties
						.getProperty("ASVIBAccountOverviewPage.BookAnEngineer"),
				"Book an engineeer link");
		verifyAndClickWithLinkText(
				pageProperties
						.getProperty("ASVIBAccountOverviewPage.BookAnEngineer"),
				"Book An Engineer");
	}

	public void navigateTrackCancelChange() {
		browser.wait(1000);
		/*verifyIsTextPresent(
				pageProperties.getProperty("ASVIBConfirmation.TrackCancelChange"),
				"TrackCancelChange link");
		verifyAndClickWithLinkText(
				pageProperties.getProperty("ASVIBConfirmation.TrackCancelChange"),
				"TrackCancelChange");*/
		
			verifyIsTextPresent(
					pageProperties.getProperty("ASVIBConfirmation.ReturnConfirmation"),
					"TrackCancelChange link");
			verifyAndClickWithLinkText(
					pageProperties.getProperty("ASVIBConfirmation.ReturnConfirmation"),
					"TrackCancelChange");

		browser.wait(500);
		// verifyIsElementVisibleWithXpath(pageProperties
		// .getProperty("AccountSummary.ViewAllAppointments"),"Booked Appointment");

	}

	public void viewDetails() {
		browser.wait(1000);
		verifyIsTextPresent("View details", "ViewDetails link");
		verifyAndClickWithXpath(
				pageProperties.getProperty("ASVIBAccountSummary.ViewDetails"),
				"View Details");	
		
	}
	
	public void viewDetailsCompletePage(UserProfile userProfile) {
		browser.wait(1000);
		verifyIsTextPresent("View details", "ViewDetails link");
		verifyAndClickWithXpath(
				pageProperties.getProperty("ASVIBAccountSummary.ViewDetails"),
				"View Details");
		browser.wait(2000);
		verifyIsTextPresent(pageProperties.getProperty("ASVIBViewDetails.Change"));
		verifyIsTextPresent(pageProperties.getProperty("ASVIBViewDetails.Cancel")); 
		String strAppointment = browser.getTextByXpath("ASVIBViewDetails.AppointmentSection");
		if(strAppointment.contains(pageProperties.getProperty("ASVIBViewDetails.Header")))
		{
			verifyIsTextPresent(pageProperties.getProperty("ASVIBViewDetails.Header"));
		}
		verifyAddress(userProfile);
		String strContact = browser.getTextByXpath("ASVIBViewDetails.ContactSection");
		if(strAppointment.contains(pageProperties.getProperty("ASVIBViewDetails.ContactHead")))
		{
			verifyIsTextPresent(pageProperties.getProperty("ASVIBViewDetails.ContactHead"));
			verifyIsTextPresent(pageProperties.getProperty("ASVIBViewDetails.ContactHead"));
			verifyIsTextPresent(pageProperties.getProperty("ASVIBViewDetails.EmailText"));
			verifyIsTextPresent(userProfile.getEmail()); 
			verifyIsTextPresent(pageProperties.getProperty("ASVIBViewDetails.PhoneText"));
			verifyIsTextPresent(userProfile.getMobileNumber());
		}
		
	}

	public void verifyPrint() {
		browser.wait(1000);
		verifyIsTextPresent("printlink", "Print page link");
		verifyAndClickWithLinkText(
				pageProperties.getProperty("ASVIBTrackCancelChange.Print"),
				"Print page");
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

	public void continueWithASV() {
		browser.wait(10000);
		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("ASVIBBookAppointment.ContinueWithASV"),
				"Continue with ASV button");
		verifyAndClickWithXpath(
				pageProperties.getProperty("ASVIBBookAppointment.ContinueWithASV"),
				"Continue With ASV");
	}

	public void accountSummaryChangeAppointment() {
		browser.wait(1000);
		
		browser.wait(1000);
		verifyIsTextPresent(
				pageProperties.getProperty("ASVIBViewDetails.Change"),
				"Change Appointment link");
		/*verifyAndClickWithLinkText(
				pageProperties.getProperty("ASVIBAccountSummary.Change"),
				"Change Appointment");*/
		verifyAndClickWithLinkText(
				pageProperties.getProperty("ASVIBViewDetails.Change"),
				"Change Appointment in viewdetail");
	}

	public void accountSummarycancelAppointment() {
		browser.wait(1000);
		// verifyAndClickWithXpath(pageProperties.getProperty("ASVIBAccountSummary.Cancel"),
		// "Cancel Appointment");
		verifyIsTextPresent(
				pageProperties.getProperty("ASVIBAccountSummary.Cancel"),
				"Account summary page");
		verifyIsTextPresent(
				pageProperties.getProperty("ASVIBAccountSummary.Cancel"),
				"Cancel Appointment link");
		browser.wait(1000);
		verifyAndClickWithLinkText(
				pageProperties.getProperty("ASVIBAccountSummary.Cancel"),
				"Cancel link");
		browser.wait(2000);
			verifyAndClickWithLinkText(
					pageProperties.getProperty("ASVIBAccountSummary.Cancel"),
					"Cancel link");
			
		
		confirmCancelAppointment();
	}

	public void asvBookedCheck() {

	}

	public void confirmCancelAppointment() {
		browser.wait(2000);
		
		verifyAndClickWithXpath(
				pageProperties.getProperty("ASVIBCancelBooking.Confirm"),
				"Confirm Booking");		
	
		browser.wait(4000);		

		/*verifyAndClickWithLinkText(
				pageProperties.getProperty("ASVIBCancelBooking.Return"),
				"Return to Account Summary");*/
	}
	
	public void confirmCancelAppointmentViewDetail() {
		browser.wait(2000);
		
		verifyAndClickWithXpath(
				pageProperties.getProperty("ASVIBCancelBookingViewDetail.Cancel"),
				"Confirm Booking");
		browser.wait(2000);		

		verifyAndClickWithLinkText(
				pageProperties.getProperty("ASVIBCancelBooking.Return"),
				"Return to Account Summary");
	}

	public void verifyErrorMessage() {
		browser.wait(1000);
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBNoTimeSlot.ErrorMessage"));
	}
	
	public void verifyPiCallErrorMessage() {
		browser.wait(1000);
		verifyIsTextPresent(pageProperties
				.getProperty("ASVIBNoTimeSlot.PICallErrorMessage"));
	}

	public void navigateToASVFromOverviewPage() {
		browser.wait(1000);
		verifyIsTextPresent(pageProperties.getProperty("ASVIBAccountOverview.ASV"),
				"Return to Account Summary link");
		verifyAndClickWithLinkText(
				pageProperties.getProperty("ASVIBAccountOverview.ASV"),
				"AccountOverview.ASV");
	}
	
	public void noSlotAvailable()
	{
		verifyIsTextPresent(pageProperties.getProperty("ASVIBAccountSummary.NoSlot"));		
	}

	public void navigateToViewAllAppointments() {
		browser.wait(500);
		verifyAndClickWithLinkText(
				pageProperties
						.getProperty("ASVIBAccountSummary.ViewAllAppointments"),
				"View All Time Slots");
	}

	public void selectAnAppointment() {
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

	public void selectAnAppointmentBookingCtrlOff() {
		browser.wait(1000);
		if(!browser.isTextPresent(pageProperties
				.getProperty("ASVIBBookAppointment.MessageText")))
		{
			Report.updateTestLog("The Book this appointment is not present", "PASS");
		}
		else
		{
			Report.updateTestLog("The Book this appointment is present", "FAIL");
		}
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

	public void loginUser(UserProfile userProfile) {
		/*
		 * final String expectedEmailAdd = new OnlineDBConnector()
		 * .getUserEmail(userProfile.getUCRN());
		 */
		verifyAndInputById(pageProperties.getProperty("ASVIBLoginPage.NewEmail"),
				"Email Id", userProfile.getEmail());
		verifyAndInputById(pageProperties.getProperty("ASVIBLoginPage.NewPassword"),
				"Password", userProfile.getPassword());
		// browser.clickWithClass(pageProperties.getProperty("ASVIBLoginPage.LoginSubmitClass"));
		browser.clickWithXpath(pageProperties
				.getProperty("ASVIBLoginPage.NewLoginSubmitXpath"));
		browser.wait(getWaitTime());
		// continueToMyAccount();
	}

	public void continueToMyAccount() {
		if (browser.isElementVisible("Continue to my account")) {
			browser.clickWithLinkText("Continue to my account");
		}
		if (browser
				.isElementVisibleWithXpath(".//*[@id='splash_overlay']/div/div[3]/div[2]/div/p[6]/span/a")) {
			browser.clickWithLinkText("Continue to my account");
		}
		if (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("ASVIBLoginPage.welcomeMessage"))) {
			Report.updateTestLog("User logged in Successfully", "PASS");
			browser.clickWithXpath(pageProperties
					.getProperty("ASVIBLoginPage.welcomeMessage"));
		}
	}

	public void navigateToAccountSummaryPage(UserProfile userProfile) {
		browser.wait(2000);
		if (browser.isElementVisibleWithXpath("html/body/div[4]/div[1]/a")) {
			verifyAndClickWithXpath("html/body/div[4]/div[1]/a",
					"Service Update Overlay");
		}

		browser.wait(8000);
		verifyAndClickWithXpath(
				(pageProperties.getProperty("ASVIBAccountOverviewPage.ManageAccountXPath").replace(
						"USERACCOUNTNUMBER", userProfile.getAccNumber())),
				"Account summary");
		browser.wait(1000);
		if(browser.isTextPresent("Your annual service is due"))
		{
		verifyIsTextPresent("Your annual service is due", "ASV due text");
		}
		if(browser.isTextPresent("First available time slot"))
		{
		verifyIsTextPresent("First available time slot",
				"First available time slot text");
		verifyIsTextPresent(
				pageProperties
						.getProperty("ASVIBAccountSummary.ViewAllAppointments"),
				"View All Time Slots link");
		verifyIsTextPresent(
				pageProperties.getProperty("ASVIBAccountSummary.BookAnAppointment"),
				"Book An Appointment link");
		
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat oDateFormat = new SimpleDateFormat("MMM yyyy");
		for (int i = 0; i <= 100; i++) {
			String oStrDate = "";
			currentDate.add(Calendar.DATE, 1);
			oStrDate = oDateFormat.format(currentDate.getTime());
			String dayName[] = new DateFormatSymbols().getWeekdays();
			String FinalDate = dayName[currentDate.get(currentDate.DAY_OF_WEEK)]
					.toString().subSequence(0, 3)
					+ " "
					+ currentDate.get(currentDate.DAY_OF_MONTH)
					+ " "
					+ oStrDate;
System.out.println(FinalDate);
			if (browser.isTextPresent(FinalDate)) {
				Report.updateTestLog(
						"The date format is verified and the date " + FinalDate
								+ " is correct", "PASS");
				break;
			} else {
				if (i == 99) {
					Report.updateTestLog(
							"The date format is verified and the date is not correct",
							"FAIL");
				}
			}

		}
		}

	}

	public void fastTrackASVnavigateToLogin() {
		browser.open("http://10.224.70.74/booking");
	}

	public void fastTrackASVLogin() {
		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("FASV.UserID"),
				"Unique Customer number field");
		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("FASV.PostCode"), "Postcode field");
		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("FASV.Continue"), "Continue object");

		verifyAndInputByXpath(pageProperties.getProperty("FASV.UserID"),
				"Unique Customer number field",
				pageProperties.getProperty("FASV.UserIDValue"));
		verifyAndInputByXpath(pageProperties.getProperty("FASV.PostCode"),
				"Postcode field",
				pageProperties.getProperty("FASV.PostCodeValue"));
		verifyAndClickWithXpath(pageProperties.getProperty("FASV.Continue"),
				"Continue object");
	}

	public void fastTrackConfirmAddressDetails() {
		verifyIsTextPresent(pageProperties.getProperty("FASV.yourDetails"),
				"Confirm Address Page");
		verifyIsTextPresent(pageProperties.getProperty("FASV.HeadText"),
				"Confirm Address Page");
		verifyIsTextPresent(
				pageProperties.getProperty("FASV.PostCodeValueReal"),
				"Pincode in the confirm address page");
		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("FASV.ConfirmContinue"),
				"Continue Button");

		verifyAndClickWithXpath(
				pageProperties.getProperty("FASV.ConfirmContinue"),
				"Continue Button");
	}

	public void fastTrackSelectAppointment() {
		verifyIsTextPresent(pageProperties.getProperty("FASV.BookPage"),
				"Choose an appointment page");
		verifyIsTextPresent(pageProperties.getProperty("FASV.BookPageSub"),
				"Choose an appointment page");

		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("FASV.BookLastSlot").replace("COL",
						"" + 1), "Available slots");

		int i = 0;
		while (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("FASV.BookContinue")) == false) {

			verifyAndClickWithXpath(
					pageProperties.getProperty("FASV.BookLastSlot").replace(
							"COL", "" + i), "Available slots");
			browser.wait(500);
			i = i + 1;
		}
		verifyAndClickWithXpath(
				pageProperties.getProperty("FASV.BookContinue"),
				"Continue button");
	}

	public void fastTrackReviewPageDetails(UserProfile userProfile) {
		verifyIsTextPresent(pageProperties.getProperty("FASV.ReviewPage"),
				"Review Details Page text");
		verifyIsTextPresent(pageProperties.getProperty("FASV.ReviewPage1"),
				"Review Details Page text ");
		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("FASV.ReviewEmail"), "Email Field");
		verifyAndInputByXpath(pageProperties.getProperty("FASV.ReviewEmail"),
				"Email Field", userProfile.getEmail());
		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("FASV.ReviewConfirmEmail"),
				"Confirm Email Field");
		verifyAndInputByXpath(
				pageProperties.getProperty("FASV.ReviewConfirmEmail"),
				"Confirm Email Field", userProfile.getEmail());
		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("FASV.ReviewContactNumber"),
				"Contact Number Field");
		verifyAndInputByXpath(
				pageProperties.getProperty("FASV.ReviewContactNumber"),
				"Contact Number Field", userProfile.getMobileNumber());
		verifyAddress(userProfile);
		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("FASV.ReviewContinue"),
				"Continue Button Field");
		verifyAndClickWithXpath(
				pageProperties.getProperty("FASV.ReviewContinue"),
				"Continue Button Field");
		
	}

	public void fastTrackConfirmationPage() {
		verifyIsTextPresent(
				pageProperties.getProperty("FASV.ConfirmationPage"),
				"Confirmation Page text");
		verifyIsTextPresent(
				pageProperties.getProperty("FASV.ConfirmationPage1"),
				"Confirmation Page text");
		verifyIsTextPresent(
				pageProperties.getProperty("FASV.ConfirmationPage2"),
				"Confirmation Page text");
		verifyIsTextPresent(
				pageProperties.getProperty("FASV.ConfirmationPrint"),
				"Print Page Link");
		verifyIsTextPresent(
				pageProperties.getProperty("FASV.ConfirmationTrackAppointment"),
				"Track changes appointment link");

		verifyAndClickWithLinkText(
				pageProperties.getProperty("FASV.ConfirmationTrackAppointment"),
				"Print Page Link");
	}

	public void viewAppointmentviewDetails() {
		verifyIsTextPresent(
				pageProperties.getProperty("FASV.ConfirmationPage"),
				"Confirmation Page text");
		verifyIsTextPresent(
				pageProperties.getProperty("FASV.ConfirmationPage1"),
				"Confirmation Page text");
		verifyIsTextPresent(
				pageProperties.getProperty("FASV.ConfirmationPage2"),
				"Confirmation Page text");
		verifyIsTextPresent(
				pageProperties.getProperty("FASV.ConfirmationPrint"),
				"Print Page Link");
		verifyIsTextPresent(
				pageProperties.getProperty("FASV.ConfirmationTrackAppointment"),
				"Track changes appointment link");

		verifyAndClickWithLinkText(
				pageProperties.getProperty("FASV.ConfirmationTrackAppointment"),
				"Print Page Link");
	}

	public void accountSummarycancelAppointmentViewDetail() {
		browser.wait(1000);	
		verifyAndClickWithLinkText(pageProperties.getProperty("ASVIBViewDetails.Cancel"), "Cancel Appointment");
		
		confirmCancelAppointmentViewDetail();
	}

	
}
