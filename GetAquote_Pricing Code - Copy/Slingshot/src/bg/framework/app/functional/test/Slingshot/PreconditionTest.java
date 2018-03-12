package bg.framework.app.functional.test.Slingshot;

import static bg.framework.app.functional.entities.FunctionalCategory.BGBRegistration;
import static bg.framework.app.functional.entities.FunctionalCategory.Slingshot;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.Slingshot.PreconditionAction;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.entities.SMRAccountDetails;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class PreconditionTest extends TestBase{
	
	@Test(groups ={Slingshot})	
    public void verifyRegistration() throws Exception {

        Report.createTestLogHeader("Registration_01_46", "To Verify user perform registration Gas account");

        for(int i=1;i<=3;i++){

	        UserProfile userProfile = new TestDataHelper().getUserProfile("Testdata"+i);
	        System.out.println("Test data value:"+i);
	        new PreconditionAction()
	            .registerDetails(userProfile)
	           .verifyLogin(userProfile);
        }	
	}
	
	@Test(groups ={Slingshot})	
        
    public void verifyCsaRegistration() throws Exception {

        Report.createTestLogHeader("Registration_01_46", "To Verify user perform registration Gas account from the CSA Agent");

        for(int i=1;i<=9;i++){

        UserProfile userProfile = new TestDataHelper().getUserProfile("Testdata"+i);
        System.out.println("Test data value:"+i);
        new PreconditionAction()
            .registerCsaDetails(userProfile)
           .verifyLogin(userProfile);
        }
	
        }
//}
	/*
	/*@Test(groups ={Slingshot})	
    public void verifyLogin() throws Exception {

        Report.createTestLogHeader("Registration_01_46", "Verify login");
        for(int i=92;i<=119;i++){

        UserProfile userProfile = new TestDataHelper().getUserProfile("Testdadta"+i);
        System.out.println("Test data value:"+i);
        new PreconditionAction().verifyLogin(userProfile);
        }
	}*/

}