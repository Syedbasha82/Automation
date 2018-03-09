package bg.framework.app.functional.test.selfServe;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.sales.AcquisitionAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.action.selfServe.EnergyUsageAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SiebelDataBase;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;

import static bg.framework.app.functional.entities.FunctionalCategory.*;

public class EnergyUsageTest extends TestBase {

	SiebelDataBase siebelDB = new SiebelDataBase();
	//Mandatory field : UCRN in userprofile
    @Test(groups = {Regression,Complex,Login})
    public void reduceYourBillES() {
        Report.createTestLogHeader("ReduceBill Page Verfication ES", "Reduce Your Bill verification for Energy Smart Customer");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount1");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
                .navigateToAccountSummaryPage(userProfile);
        new EnergyUsageAction()        
	        	.navigateToReduceBill()
	        	.reduceYourBillValidation()
	        	.dragAndDrop();
        new AccountOverviewAction()
        		.logout();
             
    }
    
    @Test(groups = {Regression,Complex,Login})
    public void reduceYourBillNonES() {
        Report.createTestLogHeader("ReduceBill Page Verfication NonES", "Reduce Your Bill verification for Non Energy Smart Customer");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount2");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
                .navigateToAccountSummaryPage(userProfile);
        new EnergyUsageAction()        
	        	.navigateToReduceBill()
	        	.ReduceBillNonES();
        new AccountOverviewAction()
				.logout();
    }
    
    
    @Test(groups = {Regression,Complex,Login})
    public void energyUsageESCustomer() {
        Report.createTestLogHeader("EnergyUsage Page Verfication ES", "Energy Usage Page verification for Energy Smart Customer");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount3");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile)
                .verifyLogin(userProfile.getLastName(), userProfile.getElecAccount())
                .navigateToAccountSummaryPage(userProfile);
        new EnergyUsageAction()        
	        	.navigateToEnergyLink()
	        	.esClose()
	        	.energyUsageES()
	        	.energyUsageSubmit()
	        	.tableView();
        new AccountOverviewAction()
				.logout();
    }
    
}