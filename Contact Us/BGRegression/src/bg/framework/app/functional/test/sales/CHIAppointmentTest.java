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

public class CHIAppointmentTest extends TestBase  {
	
	@Test( groups = {CHIAppointment,Regression , SalesRegressionAnonymous})
	public void verifyCHIAppointmentAnonymous() {

		 Report.createTestLogHeader("CHI Appointment Booking", "Anonymous");
	     UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");	        
	  //   getCustomerDetailsToUserProfileOAM(userProfile);
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
	     getCustomerDetailsToUserProfileOAM(userProfile);
	     new CHIAppointmentAction()
	     			.loginUser(userProfile)
	     			.navigateToAppointmentBookingpage()
	     			.enterAppointmentBookingdetails()
	     			.enterPersonalDetails(userProfile)
	     			.verifyandConfirmAppointment()
	     			.logout();
	}
		@Test( groups = {CHIAppointment,Regression,SalesRegressionOAM})
	public void verifyCHIAppointmentOAMElec() {

		 Report.createTestLogHeader("CHI Appointment Booking", "OAM Electricity Customer");
	     UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");	        
	     getCustomerDetailsToUserProfileOAM(userProfile);
	     new CHIAppointmentAction()
	     			.loginUser(userProfile)
	     			.navigateToAppointmentBookingpage()
	     			.enterAppointmentBookingdetails()
	     			.enterPersonalDetails(userProfile)
	     			.verifyandConfirmAppointment()
	     			.logout();
	}
	@Test( groups = {CHIAppointment,Regression, SalesRegressionOAM})
	public void verifyCHIAppointmentOAMJI() {

		 Report.createTestLogHeader("CHI Appointment Booking", "OAM JI Customer");
	     UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");	        
	    // getCustomerDetailsToUserProfileOAM(userProfile);
	     new CHIAppointmentAction()
	     			.loginUser(userProfile)
	     			.navigateToAppointmentBookingpage()
	     			.enterAppointmentBookingdetails()
	     			.enterPersonalDetails(userProfile)
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
}
