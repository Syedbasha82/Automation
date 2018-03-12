package bg.framework.app.functional.page.selfServe;

import java.util.Properties;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.BAAProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;



public class BookAnAppointmentPage extends BasePage{
	
	private final static String FILE_NAME = "resources/selfServe/BAA.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME)
			.load();
	
	public void SelectHomeOwnerStatus(String OwnerType){	
		
			String OwnerTypeXpath = pageProperties
					.getProperty("BookAnAppointment.OwnerTypeXpath");
			OwnerTypeXpath = OwnerTypeXpath.replace("OwnerType",
					OwnerType);
			verifyAndSelectCheckBoxByXpath(OwnerTypeXpath,
					"Select the owner Type");
			browser.wait(getWaitTime());			
	}
	
	
	public void SelectHeatingSystem(String HeatingSystemType){	
		
		String HeatingSystemTypeXpath = pageProperties.getProperty("BookAnAppointment.OwnerTypeXpath");
		HeatingSystemTypeXpath = HeatingSystemTypeXpath.replace("OwnerType",
				HeatingSystemType);
		verifyAndSelectCheckBoxByXpath(HeatingSystemTypeXpath,
				"Select the Heater  Type");
		browser.wait(getWaitTime());			
	}

	
	public void ClickonContinueButton(){
		//browser.clickWithXpath(pageProperties
				//.getProperty("BookAnAppointment.ContinueButtonXpath"));
		//browser.getChildelementBasedonOrder(pageProperties.getProperty("BookAnAppointment.ContinueButtonXpath"), 0).click();
		browser.wait(getWaitTime());
		String logInfo = " Clicked on Continue Button";
		String logStatus = "Pass";
		Report.updateTestLog(logInfo, logStatus);
		
	}
	
	public void EnterPersonalDetails(BAAProfile userprofile){
		//First Select Title
		
		verifyAndSelectDropDownBox("title","Title" , "Mrs");
		browser.wait(getWaitTime());
		
		// Second Title
		verifyAndInputByXpath(pageProperties.getProperty("BookAnAppointment.FirstNameXpath"),"First Name",userprofile.getFirstName());
		
		//Third Title
		verifyAndInputByXpath(pageProperties.getProperty("BookAnAppointment.SecondNameXpath"),"Second Name",userprofile.getLastName());
			
	}
	
	public void EnterAddressDetailManual(BAAProfile userprofile){
		
		verifyAndInputByXpath((pageProperties.getProperty("BookAnAppointment.PostCodeXpath")),"Post Code",userprofile.getaddr());
		verifyAndClick((pageProperties.getProperty("BookAnAppointment.SearchButtonID")),"Search Burron");
		//browser.WaitForElementWithId("displayaddr");
		verifyAndClickWithXpath((pageProperties.getProperty("BookAnAppointment.EnterManualAddressXpath")),"Search Button");
		browser.wait(getWaitTime());
		verifyAndInputByXpath((pageProperties.getProperty("BookAnAppointment.flatNumberXpath")),"Flat Number",userprofile.getflatNumber());
		verifyAndInputByXpath((pageProperties.getProperty("BookAnAppointment.HouseNumberXpath")),"House Number",userprofile.getHouseNumber());
		verifyAndInputByXpath((pageProperties.getProperty("BookAnAppointment.HouseNameXpath")),"House Name",userprofile.getHouseNumber());
		verifyAndInputByXpath((pageProperties.getProperty("BookAnAppointment.Address1Xpath")),"Address1",userprofile.getAddressLine1());
		verifyAndInputByXpath((pageProperties.getProperty("BookAnAppointment.Address2Xpath")),"Address2",userprofile.getAddressLine2());
		verifyAndInputByXpath((pageProperties.getProperty("BookAnAppointment.postaltownXpath")),"Postal Town",userprofile.getPostalTownCode());		
		//verifyAndInputByXpath((pageProperties.getProperty("BookAnAppointment.MPostCodeXpath")),"Post Code","4545");
		verifyAndSelectDropDownBox("county","Title" , "Ayrshire");
		verifyAndInputByXpath((pageProperties.getProperty("BookAnAppointment.MPostCodeXpath")),"Post Code",userprofile.getaddr());
		verifyAndInputByXpath((pageProperties.getProperty("BookAnAppointment.EmailAddressXpath")),"Email Address",userprofile.getEmail());
		//verifyAndSelectDropDownBox("telephoneNumber-telephoneType","Mobile" , "Mobile");
		
		verifyAndInputByXpath((pageProperties.getProperty("BookAnAppointment.TelephoneNumberXpath")),"Telepphone Number",userprofile.getMobileNumber());
		verifyAndClick((pageProperties.getProperty("BookAnAppointment.ContinueButtonId")),"Continue Button");
				
	}
	
	public void ConfirmOverlay(){
		//browser.WaitForElementWithId(pageProperties.getProperty("BookAnAppointment.OverlayID"));
		verifyAndClickWithXpath((pageProperties.getProperty("BookAnAppointment.ConfirmOverlayXpath")),"Submit Button");
		
		
	}
	
	public void ConfirmAppointment(BAAProfile userprofile){
		
		 if (!browser.isElementVisible("ui-dialog-title-call_us-content"))
		 {
			verifyIsTextPresent(userprofile.getaddr());
		   //browser.WaitForElementWithId("calender-disp");
		   verifyIsTextPresent("Your appointment for a new boiler quote");
		   if (browser.getChildElementsCountByXpath(pageProperties.getProperty("BookAnAppointment.SlotXPath")) > 0)
				{		
		          //browser.getChildelementBasedonOrder(pageProperties.getProperty("BookAnAppointment.SlotRadioXPath"), 0).click();
		         verifyAndClickWithXpath("//button","Click Button");			
		         }
		  else
		     {
			System.out.println("Nothing");
		     }
		 }
		 else
		 {
			 verifyAndClickWithXpath("//input[@id='overlay-img-button']","Continue Button");
		 }
		 
		
		int b = browser.getChildElementsCountByXpath("//input[@type='radio']");
		//int a = browser.getChildElementsCountByXpath(pageProperties.getProperty("BookAnAppointment.SlotRadioXPath"));
		
	}
	
	
	public void ReviewandConfirm(BAAProfile userprofile){
		verifyIsTextPresent("Details of your new boiler quote appointment");
		verifyIsTextPresent(userprofile.getaddr());
		verifyAndClickWithXpath("//button","Confirm Button");
			}
	
	public void VerifyConfirmationPage(BAAProfile userprofile){
		verifyIsTextPresent("Booking confirmed");
		verifyIsTextPresent(userprofile.getaddr());
		
	}
	public void BAAFlow(BAAProfile userprofile){
		SelectHomeOwnerStatus("HOMEOWNER");
		SelectHeatingSystem("LPG");
		verifyAndSelectCheckBoxByXpath("//*[@value='YES']",
				"Select the Yes Option");
		ClickonContinueButton();
		EnterPersonalDetails(userprofile);
		EnterAddressDetailManual(userprofile);
		ConfirmOverlay();
		ConfirmAppointment(userprofile);
		ReviewandConfirm(userprofile);
		VerifyConfirmationPage(userprofile);
				
					
	}
	
	public void navigatetoBAAPage()
	{
		//browser.open("http://localhost/newJourneys/Empty/bookAnAppointment_BoilerDetails.html");
		browser.open(ApplicationConfig.APP_BGB_URL+"/content/britishgas/products-and-services/boilers-and-central-heating/book-boiler-appointment/bookAnAppointment_BoilerDetails.html");	
		//https://www.britishgas.co.uk/CHIBooking/gettingStarted/
		//browser.open("https://www.britishgas.co.uk/CHIBooking/gettingStarted/");
		browser.wait(getWaitTime());
	}
	
	
	public void BAAFlowAutoSearch(BAAProfile userprofile){
		SelectHomeOwnerStatus("HOMEOWNER");
		SelectHeatingSystem("LPG");
		verifyAndSelectCheckBoxByXpath("//*[@value='YES']",
				"Select the Yes Option");
		ClickonContinueButton();
		EnterPersonalDetails(userprofile);
		EnterAddressDetailAutoSearch(userprofile);
		ConfirmOverlay();
		ConfirmAppointment(userprofile);
		ReviewandConfirm(userprofile);
		VerifyConfirmationPage(userprofile);
			
	} 
	
	public void EnterAddressDetailAutoSearch(BAAProfile userprofile){
		verifyAndInputByXpath((pageProperties.getProperty("BookAnAppointment.PostCodeXpath")),"Post Code Button",userprofile.getaddr());
		verifyAndClick((pageProperties.getProperty("BookAnAppointment.SearchButtonID")),"Search Button");
		//browser.WaitForElementWithId("displayaddr");
		//browser.selectfromDropBoxByXpath(pageProperties.getProperty("BookAnAppointment.AddressFieldXpath"), value)
		browser.selectFromDropBoxByID("id", "displayaddr");
		//select the first option
		verifyAndInputByXpath((pageProperties.getProperty("BookAnAppointment.EmailAddressXpath")),"Email Address",userprofile.getEmail());
		//verifyAndSelectDropDownBox("telephoneNumber-telephoneType","Mobile" , "Mobile");
		verifyAndInputByXpath((pageProperties.getProperty("BookAnAppointment.PostCodeXpath")),"Post Code Button",userprofile.getaddr());
		
		verifyAndInputByXpath((pageProperties.getProperty("BookAnAppointment.TelephoneNumberXpath")),"Telepphone Number",userprofile.getMobileNumber());
		verifyAndClick((pageProperties.getProperty("BookAnAppointment.ContinueButtonId")),"Continue Button");
		
	}

	public void VerifyBookingConfirmed(BAAProfile userprofile){
		verifyIsTextPresent(userprofile.getaddr(),"Post Code");
		verifyIsTextPresent("Your Booking is confirmed","Booking COnfirmation Message");
		verifyIsTextPresent("Time Slot is as confirmed","Time slots are as expected");	
		
	}

	public void BAANonBoilerQuote(BAAProfile userprofile){
		SelectHomeOwnerStatus("LANDLORD");
		browser.wait(getWaitTime());
		//browser.WaitForElementWithId("overlay-landlord-link");
		//SelectHeatingSystem("LPG");
		//verifyAndSelectCheckBoxByXpath("//*[@value='Yes']",
				//"Select the Yes Option");		
		verifyIsTextPresent("Residential status");		
		//ClickonContinueButton();
		//verifyOverlay
		
	}
	
	public void BAAFlowInvalidPostCode(BAAProfile userprofile){
		SelectHomeOwnerStatus("HOMEOWNER");
		SelectHeatingSystem("LPG");
		verifyAndSelectCheckBoxByXpath("//*[@value='YES']",
				"Select the Yes Option");
		ClickonContinueButton();
		EnterPersonalDetails(userprofile);
		InvalidPostCode(userprofile);		
		
	}

		
	
	public void BAANonWorkingBoilerQuote(BAAProfile userprofile){
		SelectHomeOwnerStatus("HOMEOWNER");
		SelectHeatingSystem("LPG");
		browser.wait(getWaitTime());
		verifyAndSelectCheckBoxByXpath("//*[@value='NO']",
				"Select the Yes Option");
		//ClickonContinueButton();
		//browser.WaitForElementWithId("ui-dialog-title-overlay-currentboiler-link");
		//verifyIsElementVisibleById("500","ui-dialog-title-overlay-currentboiler-link");
		verifyIsTextPresent("Boiler condition");
		
		//verifyOverlay
		
	}

	public void InvalidPostCode(BAAProfile userprofile){
		verifyAndInputByXpath((pageProperties.getProperty("BookAnAppointment.PostCodeXpath")),"Post Code",userprofile.getaddr());
		verifyAndClick((pageProperties.getProperty("BookAnAppointment.SearchButtonID")),"Search Burron");
		browser.wait(getWaitTime());
		verifyIsTextPresent("The post code you have entered is not valid. Please check and try again");	
		
	}

	
	public void SelectAppointmentSlot(){
		//
	}
	
	public void BAAFlowWithCancel(BAAProfile userprofile){
		SelectHomeOwnerStatus("HOMEOWNER");
		SelectHeatingSystem("LPG");
		verifyAndSelectCheckBoxByXpath("//*[@value='YES']",
				"Select the Yes Option");
		ClickonContinueButton();
		EnterPersonalDetails(userprofile);
		//EnterAddressDetailAutoSearch(userprofile);
		EnterAddressDetailManual(userprofile);
		ConfirmOverlay();
		ConfirmAppointment(userprofile);
		ReviewandCancel(userprofile);
		//VerifyConfirmationPage(userprofile);
				
					
	}
	

public void ReviewandCancel(BAAProfile userprofile){
	verifyIsTextPresent("Details of your new boiler quote appointment");
	verifyIsTextPresent(userprofile.getaddr());
	verifyAndClickWithXpath("//*[@title='Cancel']","Cancel Button");
	//browser.WaitForElementWithId("basic-modal-content");
	verifyAndClickWithXpath("//*[@id='continue']","Cancel Button");
	//browser.isElementVisibleWithXpath();
	verifyIsTextPresent("Landlord");
	
	

		}	
}
	
	
	
