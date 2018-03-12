package bg.framework.app.functional.test.bgb;

	import bg.framework.app.functional.action.bgb.LoginMultiSiteAction;
	import bg.framework.app.functional.action.bgb.MyProfileAction;
	import bg.framework.app.functional.action.bgb.SearchInvoicesAction;
	import bg.framework.app.functional.entities.RegistrationProfile;
	import bg.framework.app.functional.test.common.TestBase;
	import bg.framework.app.functional.util.OnlineDBConnector;
	import bg.framework.app.functional.util.Report;
	import bg.framework.app.functional.util.TestDataHelper;
	import org.testng.annotations.Test;
	import bg.framework.app.functional.entities.FunctionalCategory;
	import static bg.framework.app.functional.entities.FunctionalCategory.RegresBGBMS;

	public class MyProfileTest extends TestBase {
/*
***************************************************************************************************************	           
	               Method :MyProfileEndtoEndNormal
	               Description:This test is to verify whether end to end  My Profile journey works fine with Normal User with Update Password
	               Mandatory Fields:
	               File Name:Registration.xml
	               1) <email></email>
            	   2) <password></password>
                   3) <confPassword></confPassword>
***************************************************************************************************************
*/
//	    @Test(groups = {FunctionalCategory.RegresBGBMS})
		
	    public void myProfileEndtoEndNormal() throws InterruptedException {
	        Report.createTestLogHeader("BGB My Profile", "Multisite My Profile End to End Normal User-Update Password");
	        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("normal");        
	        new LoginMultiSiteAction(registrationProfile)
	                .login()
	                .verifyNormalAccountAction()
	                .navigateToMyProfileAction();
	        new MyProfileAction(registrationProfile)
	                .verifyMyProfileAction()
	                .updateMyProfileAction()	                	                
	                .verifyViewsAction();
	        new SearchInvoicesAction()
                    .dbValidationForNormalUser();
	        new LoginMultiSiteAction(registrationProfile)
                        .clickLogoutAction()
                        .openLoginPageAction()
                        .login()
                        .verifynameAction()
                        .clickLogoutAction()
                        .updateDefPassAction();
	   }
	    
/*
***************************************************************************************************************	           
            Method :MyProfileEndtoEndSuperUser
            Description:This test is to verify whether end to end  My Profile journey works fine with Super User with Update Password
            	   Mandatory Fields:
	               File Name:Registration.xml
	               1) <email></email>
            	   2) <password></password>
                   3) <confPassword></confPassword>
***************************************************************************************************************	           
*/
             @Test(groups = {FunctionalCategory.RegresBGBMS})
	    
             public void myProfileEndtoEndSuper() throws InterruptedException {
                 Report.createTestLogHeader("BGB My Profile", "Multisite My Profile End to End Super User-Update Password");
                 RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("superlogin");        
                 new LoginMultiSiteAction(registrationProfile)
                         .login()
	                .verifyNormalAccountAction()
                         .navigateToMyProfileAction();
                 new MyProfileAction(registrationProfile)
                         .verifyMyProfileAction()
                         .updateMyProfileAction()	                
                         .verifyViewsAction();
	        new SearchInvoicesAction()
                 		.dbValidationForSuperUser();
                 new LoginMultiSiteAction(registrationProfile)
                         .clickLogoutAction()
                         .openLoginPageAction()
                         .login()
                         .verifynameAction()
                         .clickLogoutAction()
                         .updateDefPassAction();
            }
             
/*
*****************************************************************************
	         Method :passwordvalidationNormalUser

	         Description:This test is to verify the positive flow for step 2 page by giving invalid passwords with normal user.
	         	   Mandatory Fields:
	               File Name:Registration.xml
	               1) <email></email>
            	   2) <password></password>
                   3) <confPassword></confPassword>
******************************************************************************
*/
//	    @Test(groups = {FunctionalCategory.RegresBGBMS})
             
	    public void passwordValidationNormalUser() throws InterruptedException {
	        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("normal");
	        Report.createTestLogHeader("BGB My Profile", "Multisite My Profile for PasswordvalidationValidValues");
	        OnlineDBConnector online = new OnlineDBConnector();
		 String systemDate = online.DBsysdate();
	        String expAuditType = "PASSWORD_RESET_FAILURE";
	        new LoginMultiSiteAction(registrationProfile)
                        .login()
                        .navigateToMyProfileAction();
	        new MyProfileAction(registrationProfile)
                	.verifyMyProfileAction()
                        .pwdInvalidationAction(systemDate,expAuditType)
		        .pwdLenInvalidationAction(systemDate,expAuditType);
	    }
	    
/*
*****************************************************************************
	          Method :passwordvalidationSuperUser

	         Description:This test is to verify the positive flow for step 2 page by giving invalid passwords with super user.
	         	   Mandatory Fields:
	               File Name:Registration.xml
	               1) <email></email>
            	   2) <password></password>
                   3) <confPassword></confPassword>
******************************************************************************
*/
//	    @Test(groups = {FunctionalCategory.RegresBGBMS})
	    
	    public void passwordValidationSuperUser() throws InterruptedException {
	        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("superlogin");
	        Report.createTestLogHeader("BGB My Profile", "Multisite My Profile for PasswordvalidationValidValues-SuperUser");
	        OnlineDBConnector online = new OnlineDBConnector();
		 String systemDate = online.DBsysdate();
	        String expAuditType = "PASSWORD_RESET_FAILURE";
	        new LoginMultiSiteAction(registrationProfile)
                       .login()
                       .navigateToMyProfileAction();
	        new MyProfileAction(registrationProfile)
               	.verifyMyProfileAction()
               	.pwdInvalidationAction(systemDate,expAuditType)
	        .pwdLenInvalidationAction(systemDate,expAuditType);
	    }
         
         
/*
*****************************************************************************
	          Method :MyProfileEndtoEndNormal_PasswordTwice

	         Description:Change password twice for normal user.
	         	   Mandatory Fields:
	               File Name:Registration.xml
	               1) <email></email>
            	   2) <password></password>
                   3) <confPassword></confPassword>
******************************************************************************
*/
//      @Test(groups = {FunctionalCategory.RegresBGBMS})
	    
	    public void myProfileEndtoEndNormalPasswordTwice() throws InterruptedException {
	        Report.createTestLogHeader("BGB My Profile", "Multisite My Profile End to End Normal User-Change Password twice");
             RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("normal");        
             new LoginMultiSiteAction(registrationProfile)
                     .login()
                     .verifyNormalAccountAction()
                     .navigateToMyProfileAction();
             new MyProfileAction(registrationProfile)
                     .verifyMyProfileAction()
                     .updateMyProfileAction()	                	                
	                .updateMyProfileAction()
                     .verifyViewsAction();
	        new SearchInvoicesAction()
                    .dbValidationForNormalUser();
             new LoginMultiSiteAction(registrationProfile)
                     .clickLogoutAction()
                     .openLoginPageAction()
                     .login()
                    .verifynameAction()
                    .clickLogoutAction()
                     .updateDefPassAction();
        }
	    
/*
*****************************************************************************
	          Method :MyProfileEndtoEndSuper_PasswordTwice

	         Description:Change password twice for Super user.
	         	   Mandatory Fields:
	               File Name:Registration.xml
	               1) <email></email>
            	   2) <password></password>
                   3) <confPassword></confPassword>
******************************************************************************
*/
//         @Test(groups = {FunctionalCategory.RegresBGBMS})
	    
	    public void myProfileEndtoEndSuperPasswordTwice() throws InterruptedException {
	        Report.createTestLogHeader("BGB My Profile", "Multisite My Profile End to End super User--Change Password twice");
	        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("superlogin");        
	        new LoginMultiSiteAction(registrationProfile)
	                .login()
	                .verifyNormalAccountAction()
	                .navigateToMyProfileAction();
	        new MyProfileAction(registrationProfile)
	                .verifyMyProfileAction()
	                .updateMyProfileAction()	                	                
	                .updateMyProfileAction()
	                .verifyViewsAction();
	        new SearchInvoicesAction()
                   	.dbValidationForSuperUser();
	        new LoginMultiSiteAction(registrationProfile)
                     .clickLogoutAction()
                     .openLoginPageAction()
                     .login()
                     .verifynameAction()
                     .clickLogoutAction()
                     .updateDefPassAction();
	   }
	    
	    
/*
*****************************************************************************
	          Method :UpdatePwdResetPwd

	         Description:Forgot Password Journey-NormalUser
	         	   Mandatory Fields:
	               File Name:Registration.xml
	               1) <email></email>
            	   2) <password></password>
                   3) <confPassword></confPassword>
******************************************************************************
*/
//      @Test(groups = {FunctionalCategory.RegresBGBMS})
	    
         public void updatePwdResetPwd() throws InterruptedException {
		             Report.createTestLogHeader("BGB My Profile", "Multisite My Profile End to End -Forgot Password Journey-NormalUser");
	        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("normal");        
		             String email=registrationProfile.getEmail();
	        new LoginMultiSiteAction(registrationProfile)
		            .clickforgotpasswordlink() //with DB
		            .openLoginPageAction()
		            .enterValidCredentialsNew()
		            .setNewPassword()
		            .loginwithResetPassword()
		    		.verifynameAction()
		    		.clickLogoutAction();
			new OnlineDBConnector()
			        .passwordreset(email);
	   }
         
         
/*
*****************************************************************************
	          Method :UpdatePwdTwice

	         Description:Change Forgot Password Journey-Super user
	         	   Mandatory Fields:
	               File Name:Registration.xml
	               1) <email></email>
            	   2) <password></password>
                   3) <confPassword></confPassword>
******************************************************************************
*/
//         @Test(groups = {FunctionalCategory.RegresBGBMS})
	    public void updatePwdTwice() throws InterruptedException  {
		            Report.createTestLogHeader("BGB My Profile", "Multisite My Profile End to End -Forgot Password Journey-SuperUser");
		            RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("superlogin");    
		            String email=registrationProfile.getEmail();
		        new LoginMultiSiteAction(registrationProfile)
		           .clickforgotpasswordlink() //with DB
		           .openLoginPageAction()
		           .enterValidCredentialsNew()
		           .setNewPassword()
		           .loginwithResetPassword()
		   		   .verifynameAction()
		   		   .clickLogoutAction();
			new OnlineDBConnector()
			        .passwordreset(email);
		   }
	    
/*
*****************************************************************************
	         Method :ViewsJourneyContentcheck_Normal
          	 Date : 06/07/2012
	         Description:This test is to verify the content of the Rows in DB, Count of Account in DB as well as frontend-Normal User
	   
	         	   Mandatory Fields:
	               File Name:Registration.xml
	               1) <email></email>
            	   2) <password></password>
                   3) <confPassword></confPassword>
******************************************************************************
*/
//   @Test(groups = {GetaQuoteSS})
	    public void viewsJourneyContentcheckNormal() throws InterruptedException {
	        Report.createTestLogHeader("BGB My Profile", "Multisite My Profile End to End -Profile Journey-normal User");
	        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("normal");        
	        new LoginMultiSiteAction(registrationProfile)
	                .login()
	                .verifyNormalAccountAction()
	                .navigateToMyProfileAction();
			new SearchInvoicesAction(registrationProfile)
					.readOnlyProfilePage();
	        new MyProfileAction(registrationProfile)
	                .verifyViewsAction()
	                .profileViewsTable(); 
	   }
	    
/*
*****************************************************************************
	         Method :ViewsJourneyContentcheck_Super
       	     Date : 06/07/2012
	         Description:This test is to verify the content of the Rows in DB, Count of Account in DB as well as frontend-Super User
	         	   Mandatory Fields:
	               File Name:Registration.xml
	               1) <email></email>
            	   2) <password></password>
                   3) <confPassword></confPassword>
******************************************************************************
*/
//	    @Test(groups = {GetaQuoteSS})
	   public void viewsJourneyContentcheckSuper() throws InterruptedException {
	        Report.createTestLogHeader("BGB My Profile", "Multisite My Profile End to End Profilr Journey Super User");
	        RegistrationProfile registrationProfile = new TestDataHelper().getRegistrationProfile("superlogin");        
       new LoginMultiSiteAction(registrationProfile)
               .login()
               .verifyNormalAccountAction()
               .navigateToMyProfileAction();
			new SearchInvoicesAction(registrationProfile)
					.readOnlyProfilePage();
       new MyProfileAction(registrationProfile)
               .verifyViewsAction()
	                .profileViewsTable(); 
  }
}
