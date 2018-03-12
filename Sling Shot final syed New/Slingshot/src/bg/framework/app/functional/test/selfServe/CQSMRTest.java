package bg.framework.app.functional.test.selfServe;


import javax.sql.DataSource;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.selfServe.CQSMRPageAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.RunQTP;
import bg.framework.app.functional.util.TestDataHelper;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.testng.annotations.Test;

import static bg.framework.app.functional.entities.FunctionalCategory.*;


public class CQSMRTest extends TestBase {
	
	@Test(groups = { RefactoringSubmitMeterRead })	
	public void TC_001 (){
		
		// This Test Case is linked to TC_001 in Test Case Sheet 
		//Description: A Gas Account Holder submits the the meter read.
		
		 Report.createTestLogHeader("Submit Meter Read CQ 5.", "Plausible Gas Meter"); 
		 UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		 new CQSMRPageAction().resetMeterRead(userProfile.getAccNumber());	
		 new HomePageAction().navigateToLogin().login(userProfile).clickonSMRLink(userProfile).SetPossibleRead(userProfile).submitMeterReadsforPlausible().VerifyMeterConfirmationforSingleAccount(userProfile);
		
		
	}
	
	/*@Test(groups = { RefactoringSubmitMeterRead })	
	 public void TC_004 (){
			
			// This Test Case is linked to TC_004 in Test Case Sheet 
			//Description: A Gas Account Holder submits the the meter read.
			
			 Report.createTestLogHeader("Submit Meter Read CQ 5.", "Plausible JI Meter"); 
			 UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
			 new CQSMR1PageAction().resetMeterRead(userProfile.getAccNumber());	
			 new HomePageAction().navigateToLogin().login(userProfile).clickonSMRLink(userProfile).setPlausbileReadingforJIAccount(userProfile).submitMeterReadsforPlausible().VerifyMeterConfirmationforJIAccount(userProfile);
	} */
	
	/*@Test(groups = { RefactoringSubmitMeterRead })	
	 public void TC_005 (){
			
			// This Test Case is linked to TC_002 in Test Case Sheet 
			//Description: A Gas Account Holder submits the Implausible meter read.
			
			 Report.createTestLogHeader("Submit Meter Read CQ 5.", "ImPlausible Gas Meter"); 
			 UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
			 new CQSMR1PageAction().resetMeterRead(userProfile.getAccNumber());	
			 new HomePageAction().navigateToLogin().login(userProfile).clickonSMRLink(userProfile).setImPlausbileReadingHigh(userProfile).submitMeterReadsforImplausible().VerifyMeterConfirmationforSingleAccount(userProfile).VerifyMeterConfirmationforSingleAccount(userProfile);
	}
	
	@Test(groups = { RefactoringSubmitMeterRead })
	 public void TC_008 (){
			
			// This Test Case is linked to TC_002 in Test Case Sheet 
			//Description: A Gas Account Holder submits the Implausible meter read.
			
			 Report.createTestLogHeader("Submit Meter Read CQ 5.", "ImPlausible JI Meter"); 
			 UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
			 new CQSMR1PageAction().resetMeterRead(userProfile.getAccNumber());	
			 new HomePageAction().navigateToLogin().login(userProfile).clickonSMRLink(userProfile).setImPlausbileReadingforJIAccount(userProfile).submitMeterReadsforImplausible().VerifyMeterConfirmationforJIAccount(userProfile);
	}
	 
	@Test(groups = { RefactoringSubmitMeterRead })
	 public void TC_009 (){
			
			// This Test Case is linked to TC_009 in Test Case Sheet 
			//Description: A Gas Account Holder submits the the meter read.
			
			 Report.createTestLogHeader("Submit Meter Read CQ 5.", "Plausible Electricity Meter"); 
			 UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
			 new CQSMR1PageAction().resetMeterRead(userProfile.getAccNumber());	
			 new HomePageAction().navigateToLogin().login(userProfile).clickonSMRLink(userProfile).SetPossibleRead(userProfile).submitMeterReadsforPlausible().VerifyMeterConfirmationforSingleAccount(userProfile);
			
			
		} 
	/*
	 
	@Test(groups = { RefactoringSubmitMeterRead })
	 public void TC_010 (){
			
			// This Test Case is linked to TC_010 in Test Case Sheet 
			//Description: A Gas Account Holder submits the Implausible meter read.
			
			 Report.createTestLogHeader("Submit Meter Read CQ 5.", "ImPlausible Electricity Meter"); 
			 UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
			 new CQSMR1PageAction().resetMeterRead(userProfile.getAccNumber());	
			 new HomePageAction().navigateToLogin().login(userProfile).clickonSMRLink(userProfile).setImPlausbileReadingHigh(userProfile).submitMeterReadsforImplausible().VerifyMeterConfirmationforSingleAccount(userProfile).VerifyMeterConfirmationforSingleAccount(userProfile);
	} 
	 
	 
	 /*public void TC_022 (){
			
			// This Test Case is linked to TC_022 in Test Case Sheet 
			//Description: A Gas Account Holder submits the Implausible meter read.
			
			 Report.createTestLogHeader("Submit Meter Read CQ 5.", "Plausible Dual Rate JI Meter"); 
			 UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
			 new CQSMR1PageAction().resetMeterRead(userProfile.getAccNumber());	
			 new HomePageAction().navigateToLogin().login(userProfile).clickonSMRLink(userProfile).setPlausbileReadingforMultipleAccount(userProfile).submitMeterReadsforPlausible().verifyMeterConfirmationforMultipleAccount();
	}
	 
	 public void TC_023 (){
			
			// This Test Case is linked to TC_023 in Test Case Sheet 
			//Description: A Gas Account Holder submits the Implausible meter read.
			
			 Report.createTestLogHeader("Submit Meter Read CQ 5.", "ImPlausible Dual Rate JI Meter"); 
			 UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
			 new CQSMR1PageAction().resetMeterRead(userProfile.getAccNumber());	
			 new HomePageAction().navigateToLogin().login(userProfile).clickonSMRLink(userProfile).setPlausbileReadingforMultipleAccount(userProfile).submitMeterReadsforImplausible().verifyMeterConfirmationforMultipleAccount();
	}*/
}
