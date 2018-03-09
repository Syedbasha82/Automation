package bg.framework.app.functional.test.sales;


import org.testng.annotations.Test;
import bg.framework.app.functional.action.sales.UpsellAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import static bg.framework.app.functional.entities.FunctionalCategory.Upsell;

public class UpsellTest extends TestBase  {
	
	@Test( groups = {Upsell})
	public void verifyUpsellUpgrade200() {

		 Report.createTestLogHeader("Upsell Test ", "Home Care 200");
	     UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare200Account");	        
	     getCustomerDetailsToUserProfileOAM(userProfile);
	     String value ="200";
	     new UpsellAction()
	                 .loginUser(userProfile)
	                 .verifyUpgradeCustomer(value)
	                 .logout();
	   }
	@Test(groups = {Upsell})
	public void verifyUpsellUpgrade300() {

		 Report.createTestLogHeader("Upsell Test ", " Upgrade To 300");
	     UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare200Account");	        
	    // getCustomerDetailsToUserProfileOAM(userProfile);
	     String value ="300";
	     new UpsellAction()
	                 .loginUser(userProfile)
	                 .verifyUpgradeCustomer300(value)
	                 .logout();
	    }
	
 @Test(groups = {Upsell})
	public void verifyUpsellUpgrade400() {

		 Report.createTestLogHeader("Upsell Test ", "Upgrade To 400");
	     UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare300Account");	        
	   //  getCustomerDetailsToUserProfileOAM(userProfile);
	     String value ="400";
	     new UpsellAction()
	                 .loginUser(userProfile)
	                 .verifyUpgradeCustomer400(value)
	                 .logout();
	    }
	
//	 @Test(groups = {Upsell})
	public void verifyUpsellUpgradeFlexi200() {

		 Report.createTestLogHeader("Upsell Test ", "Home Care Flexi 200");
	     UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCareFlexi200Account");	        
	     getCustomerDetailsToUserProfileOAM(userProfile);
	     String value ="200";
	     new UpsellAction()
	                 .loginUser(userProfile)
	                 .verifyUpgradeCustomer(value)
	                 .logout();
	    }
	
	 @Test(groups = {Upsell})
	public void verifyUpsellUpgradeFlexi300() {

		 Report.createTestLogHeader("Upsell Test ", "Home Care Flexi 300");
	     UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare200Account");	        
	    // getCustomerDetailsToUserProfileOAM(userProfile);
	     String value ="300";
	     new UpsellAction()
	                 .loginUser(userProfile)
	                 .verifyUpgradeCustomer300flexi(value)
	                 .logout();
	    }
	
//	 @Test(groups = {Upsell})
	public void verifyUpsellUpgradeFlexi400() {

		 Report.createTestLogHeader("Upsell Test ", "Home Care Flexi 400");
	     UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCareFlexi400Account");	        
	     getCustomerDetailsToUserProfileOAM(userProfile);
	     String value ="400";
	     new UpsellAction()
	                 .loginUser(userProfile)
	                 .verifyUpgradeCustomer(value)
	                 .logout();
	    }
	                
}
