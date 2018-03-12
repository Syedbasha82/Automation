package bg.framework.app.functional.test.Slingshot;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.Slingshot.SapCrmAction;
import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.entities.CrmUserProfile;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;

import static bg.framework.app.functional.entities.FunctionalCategory.*;


public class SapCrmTest extends TestBase{

	   @Test(groups ={Slingshot})
	    public void GetDetailsFromSapCrm() {
	        Report.createTestLogHeader("Login Verification", "Login for Gas Account from Goto Business Site link");
	        CrmUserProfile crmuserProfile = new TestDataHelper().getCrmUserProfile("SlingshotCrmDetails");
	        UserProfile userProfile = new TestDataHelper().getUserProfile("BgbGasAccount");
	        new SapCrmAction()
	        .loginDetails(crmuserProfile)
	        .searchByAccountId(crmuserProfile,userProfile);	        
	    }   
	   
	   @Test(groups ={Slingshot})
	    public void GetDetailsFromSapCrmforpaperless() {
	        Report.createTestLogHeader("Login Verification", "Login for Gas Account from Goto Business Site link");
	        CrmUserProfile crmuserProfile = new TestDataHelper().getCrmUserProfile("CrmDetailsforpaperbilling");
	        UserProfile userProfile = new TestDataHelper().getUserProfile("MuMVforpaperbilling");
	        new SapCrmAction()
	        .loginDetailsforpaperbilling(crmuserProfile)
	        .SearchCRMFields_MPD(crmuserProfile,userProfile);	        
	    } 
	   /*@Test(groups ={Slingshot})
	    public void GetDetailsFromSapCrmforGAQ() {
	        Report.createTestLogHeader("Login Verification", "Login for Gas Account from Goto Business Site link");
	        CrmUserProfile crmuserProfile = new TestDataHelper().getCrmUserProfile("CrmDetailsforpaperbilling");
	        UserProfile userProfile = new TestDataHelper().getUserProfile("MuMVforpaperbilling");
	        new SapCrmAction()
	        .loginDetailsforpaperbilling(crmuserProfile)
	        .SearchCRMFields_GAQ(crmuserProfile,userProfile);	        
	    }*/
}
