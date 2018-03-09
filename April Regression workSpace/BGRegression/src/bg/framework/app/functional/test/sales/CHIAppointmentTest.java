package bg.framework.app.functional.test.sales;
import org.testng.annotations.Test;

import bg.framework.app.functional.action.sales.CHIAppointmentAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import static bg.framework.app.functional.entities.FunctionalCategory.CHIAppointment;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import static bg.framework.app.functional.entities.FunctionalCategory.SalesRegressionAnonymous;
import static bg.framework.app.functional.entities.FunctionalCategory.SalesRegressionOAM;
import static bg.framework.app.functional.entities.FunctionalCategory.RegressionAnonymous;
public class CHIAppointmentTest extends TestBase  {
	
	@Test( groups = {CHIAppointment,Regression , SalesRegressionAnonymous})
	public void verifyCHIAppointmentAnonymous() {

		 Report.createTestLogHeader("CHI Appointment Booking", "Anonymous");
	     UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");	        
	  //   //getCustomerDetailsToUserProfileOAM(userProfile);
	     new CHIAppointmentAction()
	     			.navigateToAppointmentBookingpage()
	     			.enterAppointmentBookingdetails()
	     			.enterPersonalDetails(userProfile)
	     			.verifyandConfirmAppointment();
	}
	
		@Test( groups = {CHIAppointment,Regression,SalesRegressionOAM})
	public void verifyCHIAppointmentOAMGas() {

		 Report.createTestLogHeader("CHI Appointment Booking", "OAM Gas Customer");
	     UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");	        
	     //getCustomerDetailsToUserProfileOAM(userProfile);
	     new CHIAppointmentAction()
	     			.loginUser(userProfile)
	     			.navigateToAppointmentBookingpage()
	     			.enterAppointmentBookingdetails()
	     			.enterOAMPersonalDetails(userProfile)
	     			.verifyandConfirmAppointment()
	     			.logout();
	}
		@Test( groups = {CHIAppointment,Regression,SalesRegressionOAM})
	public void verifyCHIAppointmentOAMElec() {

		 Report.createTestLogHeader("CHI Appointment Booking", "OAM Electricity Customer");
	     UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");	        
	     //getCustomerDetailsToUserProfileOAM(userProfile);
	     new CHIAppointmentAction()
	     			.loginUser(userProfile)
	     			.navigateToAppointmentBookingpage()
	     			.enterAppointmentBookingdetails()
	     			.enterOAMPersonalDetails(userProfile)
	     			.verifyandConfirmAppointment()
	     			.logout();
	}
	@Test( groups = {CHIAppointment,Regression, SalesRegressionOAM})
	public void verifyCHIAppointmentOAMJI() {

		 Report.createTestLogHeader("CHI Appointment Booking", "OAM JI Customer");
	     UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");	        
	    // //getCustomerDetailsToUserProfileOAM(userProfile);
	     new CHIAppointmentAction()
	     			.loginUser(userProfile)
	     			.navigateToAppointmentBookingpage()
	     			.enterAppointmentBookingdetails()
	     			.enterOAMPersonalDetails(userProfile)
	     			.verifyandConfirmAppointment()
	     			.logout();
	}
	
	//Mandatory Field: firname, surname, Title, mailid, date
	@Test( groups = {CHIAppointment,Regression, SalesRegressionOAM})
	public void verifyCHIAppointmentAnonymousEndtoEnd() {

		 Report.createTestLogHeader("CHI Appointment Anonymous End to End Journey", "Anonymous");
	     UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");	        
	     
	     new CHIAppointmentAction()
	     			.enterPersonalDetailsRequestCallBack(userProfile);
	}

		@Test( groups = {CHIAppointment,Regression , SalesRegressionAnonymous})
	public void verifyCHIBookAnAppointmentCancel() {

		 Report.createTestLogHeader("CHI Cancel Appointment Journey", "Anonymous");
	     UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");	        
	     
	     new CHIAppointmentAction()
	     			.enterPersonalDetailsBookApp(userProfile)
	     			.firstPage(userProfile)
	     			.secondPageCancel(userProfile);
	}
	
		//Mandatory Field: firname, surname, Title, mailid, addr
		@Test( groups = {CHIAppointment,Regression, SalesRegressionOAM})
		public void verifyCHIBookAnAppointmentNoTimeslot() {
	
			 Report.createTestLogHeader("CHI Appointment No Time slot", "Anonymous");
		     UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");	        
		     
		     new CHIAppointmentAction()
		     			.enterPersonalDetailsBookApp(userProfile)
		     			.firstPage(userProfile)
		     			.secondPagePersonalDetails(userProfile)
		     			.postCodeErrorMessage(userProfile);
		}
		
		//Mandatory Field: firname, surname, Title, mailid, addr
				@Test( groups = {CHIAppointment,Regression})
				public void verifyCHIBookAnAppointmentDiffTimeslot() {
			
					 Report.createTestLogHeader("CHI Appointment apply different Time slot", "Anonymous");
				     UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");	        
				     
				     new CHIAppointmentAction()
				     			.enterPersonalDetailsBookApp(userProfile)
				     			.firstPage(userProfile)
				     			.secondPagePersonalDetails(userProfile);
				}

////////////////////////////////////CHI APPOINTMENT REWRITE/////////////////////////////////////////////////////

@Test( groups = {CHIAppointment,Regression , SalesRegressionAnonymous})
public void verifyCHIAppointmentAnonymousNewYes() {
   /////////// Select Yes for Is your boiler currently working ? in Your Property Page/////////////////
	
	Report.createTestLogHeader("CHI Appointment New Booking", "Anonymous");
    UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");	        
    new CHIAppointmentAction()
    			.navigateToYourPropertyPage()
    			.enterDetailsInYourPropertyPageYes(userProfile)
    			.selectFirtAvailableAppointment()
    			.enterPersonalDetails(userProfile)
    			.verifyConfirmationPage();
    		
}
@Test( groups = {CHIAppointment,Regression , SalesRegressionAnonymous})
public void verifyCHIAppointmentAnonymousNewMorningSlot() {
   /////////// Select Yes for Is your boiler currently working ? in Your Property Page && Select the any other available appointment ( 9-11:00 AM) available appointment/////////////////
	String slotType= "Morning";
	String  timeSlot="9:00am-11:00am";
	
	Report.createTestLogHeader("CHI Appointment New Booking", "Anonymous");
    UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");	        
    new CHIAppointmentAction()
    			.navigateToYourPropertyPage()
    			.enterDetailsInYourPropertyPageNo(userProfile)
    			.selectAppointmentFromCalendar(slotType,timeSlot)
                .enterPersonalDetails(userProfile)
    			.verifyConfirmationPage();
    		
}
@Test( groups = {CHIAppointment,Regression , SalesRegressionAnonymous})
public void verifyCHIAppointmentAnonymousEveningSlot1() {
   /////////// Select Yes for Is your boiler currently working ? in Your Property Page && Select the any other available appointment (3:30pm-5:30pm) available appointment/////////////////
	String slotType= "Evening";
	String  timeSlot="3:30pm-5:30pm";
	
	Report.createTestLogHeader("CHI Appointment New Booking", "Anonymous");
    UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");	        
    new CHIAppointmentAction()
    			.navigateToYourPropertyPage()
    			.enterDetailsInYourPropertyPageYes(userProfile)
    			.selectAppointmentFromCalendar(slotType,timeSlot)
    			.enterPersonalDetails(userProfile)
    			.verifyConfirmationPage();
    		
}
@Test( groups = {CHIAppointment,Regression , SalesRegressionAnonymous})
public void verifyCHIAppointmentAnonymousEveningSlot2() {
	   /////////// Select Yes for Is your boiler currently working ? in Your Property Page && Select the any other available appointment (7:00-8:30pm) available appointment/////////////////
		String slotType= "Evening";
		String  timeSlot="7:00-8:30pm";
		
		Report.createTestLogHeader("CHI Appointment New Booking", "Anonymous");
	    UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");	        
	    new CHIAppointmentAction()
	    			.navigateToYourPropertyPage()
	    			.enterDetailsInYourPropertyPageYes(userProfile)
	    			.selectAppointmentFromCalendar(slotType,timeSlot)
	    			.enterPersonalDetails(userProfile)
	    			.verifyConfirmationPage();
	    		
	}

@Test( groups = {CHIAppointment,Regression , SalesRegressionAnonymous})
public void verifyCHIAppointmentAnonymousNewNo() {

	/////////// Select No for Is your boiler currently working ? in Your Property Page/////////////////
	
	Report.createTestLogHeader("CHI Appointment New Booking", "Anonymous");
    UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");	        
    new CHIAppointmentAction()
    			.navigateToYourPropertyPage()
    			.enterDetailsInYourPropertyPageNo(userProfile)
    			.verifyAppointmentSelectionCalenderFFSlot()
    			.enterPersonalDetails(userProfile)
    			.verifyConfirmationPage();
    		
}

@Test( groups = {CHIAppointment,Regression , SalesRegressionAnonymous})
public void verifyCHIAppointmentAnonymousNewNoSlotsVerification() {

	/////////// Select No for Is your boiler currently working ? in Your Property Page/////////////////
	/////////// To verify whether the user is displayed with other available slots of 8 weeks in future for booking in the " Choose an appointment page".//////////
	Report.createTestLogHeader("CHI Appointment New Booking", "Anonymous");
    UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");	        
    new CHIAppointmentAction()
    			.navigateToYourPropertyPage()
    			.enterDetailsInYourPropertyPageNo(userProfile)
    			.verifyChooseYourAppointmentPageAnonymous(userProfile);

}
@Test( groups = {CHIAppointment,Regression , SalesRegressionAnonymous})
public void verifyCHIAppointmentAnonymousNewNoChangePostcode() {

	/////////// Select No for Is your boiler currently working ? in Your Property Page/////////////////
	////////////To verify the functionality when change postcode is clicked in the your details page address section////////////////////
	Report.createTestLogHeader("CHI Appointment New Booking", "Anonymous");
    UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");	        
    new CHIAppointmentAction()
    			.navigateToYourPropertyPage()
    			.enterDetailsInYourPropertyPageNo(userProfile)
    			.selectFirtAvailableAppointment()
    			.enterPersonalDetailsAndChangePostCode(userProfile);
    			
    		
}
@Test( groups = {CHIAppointment,Regression , SalesRegressionAnonymous})
public void verifyCHIAppointmentAnonymousNewCancel() {

	/////////// Select YES for Is your boiler currently working ? in Your Property Page/////////////////
   ////////// To Verify Whether Anonymous Customer can Cancel the Appointment//////////////////////////
	Report.createTestLogHeader("CHI Appointment New Booking", "Anonymous");
    UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");	        
    new CHIAppointmentAction()
    			.navigateToYourPropertyPage()
    			.enterDetailsInYourPropertyPageYes(userProfile)
    			.selectFirtAvailableAppointment()
    			.enterPersonalDetailsAndCancel(userProfile);
    			
    		
}
@Test( groups = {CHIAppointment,Regression,SalesRegressionOAM})
public void verifyCHIAppointmentNewOAMEdit() {
/////////To verify whether the functionality when Edit is clicked in the appointment details of RHN in the your details page.//////////////
/////////To verify whether the user is navigated to the Your property page when EDIT present in the RHN of choose an appointment is clicked.//////////////
	 Report.createTestLogHeader("CHI Appointment New Booking", "OAM Gas Customer");
     UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");	        
     new CHIAppointmentAction()
     			.loginUser(userProfile)
     			.navigateToYourPropertyPage()
     			.enterDetailsInYourPropertyPageOAMNo()
     			.verifyChooseYourAppointmentPageandVerifyEditFunctionality()
     			.logout();
     		
}
@Test( groups = {CHIAppointment,Regression,SalesRegressionOAM})
public void verifyCHIAppointmentNewOAMYesE2E() {
/////////To verify CHI Appointment OAM journey END To END//////////////

	 Report.createTestLogHeader("CHI Appointment New Booking", "JI Gas Customer");
     UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");	        
     new CHIAppointmentAction()
     			.loginUser(userProfile)
     			.navigateToYourPropertyPage()
     			.enterDetailsInYourPropertyPageOAMNyes()
     			.selectFirtAvailableAppointment()
     			.enterOAMPersonalDetails(userProfile)
     			.verifyConfirmationPage()
     			.logout();
     		
}
@Test( groups = {CHIAppointment,Regression,SalesRegressionOAM})
public void verifyCHIAppointmentNewOAMNoE2E() {
/////////To verify CHI Appointment OAM journey END To END//////////////

	 Report.createTestLogHeader("CHI Appointment New Booking", "OAM Gas Customer");
     UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");	        
     new CHIAppointmentAction()
     			.loginUser(userProfile)
     			.navigateToYourPropertyPage()
     			.enterDetailsInYourPropertyPageOAMNo()
     			.selectFirtAvailableAppointment()
     			.enterOAMPersonalDetails(userProfile)
     			.verifyConfirmationPage()
     			.logout();
     		
}
@Test( groups = {CHIAppointment,Regression,SalesRegressionOAM})
public void verifyCHIAppointmentNewOAMYesE2EforHalfDaySlot() {
/////////To verify CHI Appointment OAM journey END To END//////////////

	 Report.createTestLogHeader("CHI Appointment New Booking", "OAM Gas Customer");
     UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");	        
     new CHIAppointmentAction()
     			.loginUser(userProfile)
     			.navigateToYourPropertyPage()
     			.enterDetailsInYourPropertyPageOAMNyes()
     			.selectHalfDayAppointmentDay()
     			.enterOAMPersonalDetails(userProfile)
     			.verifyConfirmationPage()
     			.logout();
     		
}
@Test( groups = {CHIAppointment,Regression,SalesRegressionOAM})
public void verifyCHIAppointmentNewOAMYesE2EMorningSlot4() {
/////////To verify CHI Appointment OAM journey END To END//////////////
	String slotType= "Morning";
	String  timeSlot="11:00am-1:00pm";

	 Report.createTestLogHeader("CHI Appointment New Booking", "OAM Gas Customer");
     UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");	        
     new CHIAppointmentAction()
     			.loginUser(userProfile)
     			.navigateToYourPropertyPage()
     			.enterDetailsInYourPropertyPageOAMNyes()
     			.selectAppointmentFromCalendar(slotType,timeSlot)
     			.enterOAMPersonalDetails(userProfile)
     			.verifyConfirmationPage()
     			.logout();
     		
}
@Test( groups = {CHIAppointment,Regression,SalesRegressionOAM})
public void verifyCHIAppointmentNewMultipleSupplyAddressNOE2E() {
/////////To verify CHI Appointment Multiple Supply Address Customer journey END To END//////////////


	 Report.createTestLogHeader("CHI Appointment New Booking", "OAM Gas Customer");
     UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");	        
     new CHIAppointmentAction()
     			.loginUser(userProfile)
     			.navigateToYourPropertyPage()
     			.enterDetailsInYourPropertyPageNo(userProfile)
     			.selectFirtAvailableAppointment()
     			.enterOAMPersonalDetails(userProfile)
     			.verifyConfirmationPage()
     			.logout();
     		
}
@Test( groups = {CHIAppointment,Regression,SalesRegressionOAM})
public void verifyCHIAppointmentNewOAMYesE2EViewCalendar() {
/////////To verify CHI Appointment OAM journey END To END//////////////
/////////TO verify Whether User Can Select First Available Time slot from Calendar//////////////////////
	 Report.createTestLogHeader("CHI Appointment New Booking", "OAM Gas Customer");
     UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");	        
     new CHIAppointmentAction()
     			.loginUser(userProfile)
     			.navigateToYourPropertyPage()
     			.enterDetailsInYourPropertyPageOAMNyes()
     			.verifyAppointmentSelectionCalenderFFSlot()
     			.logout();
     		
}
@Test( groups = {CHIAppointment,Regression,SalesRegressionOAM})
public void verifyCHIAppointmentNewOAMCancelAppointment() {
//////////To Verify Whether OMA Customer can Cancel the Appointment from Your Appointment Page//////////////////////////
	
 Report.createTestLogHeader("CHI Appointment New Booking", "OAM Gas Customer");
 UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");	        
 new CHIAppointmentAction()
 			.loginUser(userProfile)
 			.navigateToYourPropertyPage()
 			.enterDetailsInYourPropertyPageOAMNo()
 			.verifyChooseYourAppointmentPageAndCancelAppointment()
 			.logout();
 			
 		
}
@Test( groups = {CHIAppointment,Regression,SalesRegressionOAM})
public void verifyCHIAppointmentNewOAMVerifyBackFuctionality(){
//////////To Verify the Back button Functionality in Your Appointment Page//////////////////////////
	
Report.createTestLogHeader("CHI Appointment New Booking", "OAM Gas Customer");
UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");	        
new CHIAppointmentAction()
			.loginUser(userProfile)
			.navigateToYourPropertyPage()
			.enterDetailsInYourPropertyPageOAMNo()
			.verifyChooseYourAppointmentPageAndVerifyBackFunctionality()
            .logout();
		
}
@Test( groups = {CHIAppointment,Regression,SalesRegressionOAM})
public void verifyCHIAppointmentNewOAMVerify8weekSlots() {
//////////To Verify Customer Can View all available 8 weeks slots //////////////////////////
	
Report.createTestLogHeader("CHI Appointment New Booking", "OAM Gas Customer");
UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");	        
new CHIAppointmentAction()
		.loginUser(userProfile)
		.navigateToYourPropertyPage()
		.enterDetailsInYourPropertyPageOAMNo()
		.verifyChooseYourAppointmentPageandVerifySlotsfor8weeks();
		
	
}
@Test( groups = {CHIAppointment,Regression,SalesRegressionOAM})
public void verifyCHIAppointmentNewOAMGas() {

	 Report.createTestLogHeader("CHI Appointment New Booking", "OAM Gas Customer");
     UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");	        
     new CHIAppointmentAction()
     			.loginUser(userProfile)
     			.navigateToYourPropertyPage()
     			.enterAppointmentBookingdetails()
     			.enterOAMPersonalDetails(userProfile)
     			.verifyConfirmationPage()
     			.logout();
}
}