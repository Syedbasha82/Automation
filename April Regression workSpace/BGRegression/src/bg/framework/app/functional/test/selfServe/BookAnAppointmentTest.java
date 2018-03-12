package bg.framework.app.functional.test.selfServe;

import javax.sql.DataSource;

import bg.framework.app.functional.action.common.HomePageAction;
//import bg.framework.app.functional.action.selfServe.BookAnAppointmentAction;
//import bg.framework.app.functional.action.selfServe.CQAdminPageAction;
import bg.framework.app.functional.action.selfServe.BookAnAppointmentAction;
import bg.framework.app.functional.action.selfServe.CQSMRPageAction;
import bg.framework.app.functional.action.selfServe.SMRAction;
//import bg.framework.app.functional.entities.BAAProfile;
import bg.framework.app.functional.entities.BAAProfile;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.RunQTP;
import bg.framework.app.functional.util.TestDataHelper;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.testng.annotations.Test;

import static bg.framework.app.functional.entities.FunctionalCategory.*;


public class BookAnAppointmentTest extends TestBase {
	
	@Test(groups = { RefactoringBookAnAppointment })
	 public void BookAnAppointment_ManualAddress(){
		
			Report.createTestLogPath();
			Report.createTestLogHeader("Book An Appointment", "Manual Address Entry");
						 BAAProfile BAAProfile = new TestDataHelper().getBAAProfile("BAAAnonymousUser");
			 new BookAnAppointmentAction().NavigatetoBAA().BAAFlow(BAAProfile);			
		} 
	
		@Test(groups = { RefactoringBookAnAppointment })
		public void BookAnAppointment_AutoAddressFlow(){


		Report.createTestLogHeader("Book An Appointment.", "Auto Search Entry");
		 BAAProfile userProfile = new TestDataHelper().getBAAProfile("BAAAnonymousUser"); 
		 new BookAnAppointmentAction().NavigatetoBAA().BAAFlowAutoSearch(userProfile);
	
		} 
	
	
	@Test(groups = { RefactoringBookAnAppointment })
	 public void BookAnAppointment_InvalidFlow(){
		Report.createTestLogPath();
		Report.createTestLogHeader("Book An Appointment.", "Invalid Flow");
		BAAProfile userProfile = new TestDataHelper().getBAAProfile("BAAAnonymousUser2"); 
		 new BookAnAppointmentAction().NavigatetoBAA().BAAFlowInvalidPostCode(userProfile);
			
		} 
	

	@Test(groups = { RefactoringBookAnAppointment })
	 public void BookAnAppointment_NotworkingBolierFlow(){
		
		Report.createTestLogPath();
		Report.createTestLogHeader("Book An Appointment.", "Non Working Boiler");
		 BAAProfile userProfile = new TestDataHelper().getBAAProfile("BAAAnonymousUser"); 
		 new BookAnAppointmentAction().NavigatetoBAA().BAANonWorkingBoilerQuote(userProfile);
			
		} 
	
	 @Test(groups = { RefactoringBookAnAppointment })
	 public void BookAnAppointment_CancelFlow(){
		
		Report.createTestLogPath();
		Report.createTestLogHeader("Book An Appointment.", "Non Boiler Quote");
		 BAAProfile userProfile = new TestDataHelper().getBAAProfile("BAAAnonymousUser"); 
		 new BookAnAppointmentAction().NavigatetoBAA().BAAFlowWithCancel(userProfile);
	
		} 
	
	

}
