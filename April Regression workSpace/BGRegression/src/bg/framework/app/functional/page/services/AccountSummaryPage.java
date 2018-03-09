package bg.framework.app.functional.page.services;

import java.util.Properties;

import bg.framework.app.functional.entities.LandLord;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;

public class AccountSummaryPage extends BasePage{
	private final static String FILE_NAME="resources/services/AccountSummary.properties";
	private static Properties pageProperties=new PropertyLoader(FILE_NAME).load();
	private LandLord landLord;
	
	public AccountSummaryPage(){
		
	}
	public AccountSummaryPage(LandLord landLord) {
		this.landLord=landLord;
	}

	public void clickBookAppointment(){
		browser.wait(2000);
		verifyAndClickWithXpath(pageProperties.getProperty("AccountSummary.bookAppointment"), "Book Appointment Link");
	}
	
	public void clickEngBookAppointment(){
		verifyAndClickWithXpath(pageProperties.getProperty("AccountSummary.bookEngAppointment"), "Book Engineer Link");
	}
	
	public void enterMobileNumber(){
		String mobileNo=browser.getAttribute(pageProperties.getProperty("AccountSummary.mobileNoText"),"value");
		if(mobileNo.isEmpty()){
			verifyAndInputById(pageProperties.getProperty("AccountSummary.mobileNoText"), "Mobile Number", "02365412589");
		}
	}
	public void clickContinueButton(){
		verifyAndClick(pageProperties.getProperty("AccountSummary.continueButton"), "Continue button");
	}
	public void firstStepAppointment(){
		bookNewAppointmentButton();
	}
	
	public void firstStepEng(){
		int count=browser.getChildElementsCountByXpath(pageProperties.getProperty("AccountSummary.homeAppliance"));
		if(!browser.isElementVisible("AccountSummary.faultItem")&& count>1){
			clickHomeAppliance();
			clickFaultItemCheck(2);
		}else{
			clickFaultItemCheck(1);
		}		
		browser.wait(2000);
		clickEngStep1Continue();
		continueWithBookingButton();
		browser.wait(2000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("AccountSummary.bookNewButton"))){
		bookNewAppointmentButton();
		browser.wait(2000);
		}		
	}
	
	public void secondStepEng(){
		clickAppointmentDate();
		clickStep2Continue();
	}
	
	public void thirdStepEng(){
	enterMobileNumber();
	clickContinueButton();
	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("AccountSummary.continueOverLay"))){
		browser.clickWithXpath(pageProperties.getProperty("AccountSummary.continueOverLay"));
	}
	if(browser.isElementVisible(pageProperties.getProperty("AccountSummary.payOverLay"))){
		enterPayDetails();
	}
	}
	 
	
	private void enterPayDetails(){
				verifyAndSelectDropDownBox(pageProperties.getProperty("AccountSummary.cardType"), "Card type", landLord.getCardType());
				verifyAndInputById(pageProperties.getProperty("AccountSummary.cardName"), "Name", landLord.getfName());				
				verifyAndInputById(pageProperties.getProperty("AccountSummary.cardNumber"),"Card Number",landLord.getCardNumber());
				verifyAndSelectDropDownBox(pageProperties.getProperty("AccountSummary.startDate"), "Start Month", landLord.getCardStartMonth());
				verifyAndSelectDropDownBox(pageProperties.getProperty("AccountSummary.startYear"), "Start Year", landLord.getCardStartYear());
				verifyAndSelectDropDownBox(pageProperties.getProperty("AccountSummary.endDate"), "End month", landLord.getCardExpiryMonth());
				verifyAndSelectDropDownBox(pageProperties.getProperty("AccountSummary.endYear"), "End Year", landLord.getCardExpiryYear());
				verifyAndInputById(pageProperties.getProperty("AccountSummaryAccountSummary.issueNumber"),"Issue Number",landLord.getIssueNumber());
				verifyAndInputById(pageProperties.getProperty("AccountSummary.securityCode"),"Security Number","744");
				verifyAndClickWithXpath(pageProperties.getProperty("AccountSummary.continueOverLay2"), "continue button");
				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("AccountSummary.ContinueOverLay3"))){
					browser.clickWithXpath(pageProperties.getProperty("AccountSummary.ContinueOverLay3"));
				}
	}
	
	public void annualBookingSucess(){
		browser.wait(2000);
		verifyIsTextPresent("Your annual service is booked");
	}
	public void engAppointmentsuccess(){
		browser.wait(2000);
		verifyIsTextPresent("Your engineer's visit is booked");
	}
	public void continueWithBookingButton(){
		verifyAndClickWithXpath(pageProperties.getProperty("AccountSummary.continueWithBooking"), "Continue with booking button");
	}
	
	public void bookNewAppointmentButton(){
		verifyAndClickWithXpath(pageProperties.getProperty("AccountSummary.bookNewButton"), "Book new appointment button");
	}
	
	public void verifyViewDairyLinks(){
		//verifyIsElementVisibleWithXpath(pageProperties.getProperty(""), "Reschedule your appointment Link");// verify
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("AccountSummary.viewDeatailsLink"), "View Dairy Link");
	}
	
	public void clickViewDairy(){
		verifyAndClickWithXpath(pageProperties.getProperty("AccountSummary.viewDeatailsLink"), "View dairy Link");
	}
	
	public void verifyViewDairy(){
		verifyIsTextPresent("Your appointment details are below");
	}
	public void clickAppointmentDate(){
		verifyAndClickWithXpath(pageProperties.getProperty("AccountSummary.appointmentDate"), "Appointment Date");
	}
	public void clickEngStep1Continue(){
		verifyAndClick(pageProperties.getProperty("AccountSummary.continueEngButton"), "Continue button");
	}
	public void clickStep2Continue(){
		verifyAndClick(pageProperties.getProperty("AccountSummary.continueEng2"), "Continue button in step 2");
	}
	
	public void clickHomeAppliance(){
		verifyAndClickWithXpath(pageProperties.getProperty("AccountSummary.homeAppliance")+"[2]/a", "Home Electricals");
	}
	
	public void clickFaultItemCheck(int count){
		verifyAndClickWithXpath(pageProperties.getProperty("AccountSummary.faultCheck").replace("COUNT", ""+count), "Fault Item");
	}
	
	public void clickUpCellHC300(){
		verifyAndClickWithXpath(pageProperties.getProperty("AccountSummary.upGradeHC300"), "Upgrade Homecare300");
		verifyIsTextPresent("HoneCare 100 to 200");
	}
	
	public void clickUpCellHC200(){
		verifyAndClickWithXpath(pageProperties.getProperty("AccountSummary.upGradeHC200"), "Upgrade Homecare300");
		verifyIsTextPresent("HoneCare 200 to 300");
	}
	public void clickUpCellHC400(){
		verifyAndClickWithXpath(pageProperties.getProperty("AccountSummary.upGradeHC400"), "Upgrade Homecare300");
		verifyIsTextPresent("HoneCare 300 to 400");
	}
	
	
}
