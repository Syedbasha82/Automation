package bg.framework.app.functional.action.bgb;


import bg.framework.app.functional.entities.RegistrationProfile;
import bg.framework.app.functional.page.bgb.LoginMultiSitePage;
import bg.framework.app.functional.page.bgb.MyProfilePage;


public class MyProfileAction {

    private RegistrationProfile registrationProfile;


    public MyProfileAction() {
    }

    public MyProfileAction(RegistrationProfile registrationProfile) {
        this.registrationProfile = registrationProfile;

    }

    /*
    ******************************************************************************
         Method :verifyMyProfileAction

       Created On:12/02/2011
       Description: This method enters input for first page.
    ******************************************************************************
    */
    public MyProfileAction verifyMyProfileAction() {
    //System.out.println("test");
        MyProfilePage myProfilePage = new MyProfilePage(registrationProfile);
        myProfilePage.verifyMyProfilePage();
        //myProfilePage.verifyMyProfileDetails(registrationProfile);
        return this;
    }

    /*
    ******************************************************************************
         Method :updateMyProfileAction

       Created On:12/02/2011
       Description: This method enters input in second page.
    ******************************************************************************
    */
    public MyProfileAction updateMyProfileAction() throws InterruptedException {
        MyProfilePage myProfilePage = new MyProfilePage(registrationProfile);
//  	
        myProfilePage.updatePassword(registrationProfile.getConfPassword());
        myProfilePage.updateConfPassword(registrationProfile.getConfPassword());
        myProfilePage.clickUpdateButton();
        myProfilePage.clickOkOverlayButton();
        registrationProfile.setPassword(registrationProfile.getConfPassword());
      //  registrationProfile.setPassword(registrationProfile.getConfPassword());
        return new MyProfileAction(registrationProfile);
    }
    /*
     ******************************************************************************
          Method :updateMyProfileAction

        Created On:12/02/2011
        Description: This method enters input in second page.
     ******************************************************************************
     */
     public MyProfileAction updatePwdAction() throws InterruptedException {
         MyProfilePage myProfilePage = new MyProfilePage(registrationProfile);
 //  	
         myProfilePage.updatePassword(registrationProfile.getConfPassword());
         myProfilePage.updateConfPassword(registrationProfile.getConfPassword());
         myProfilePage.clickUpdateButton();
         myProfilePage.clickOkOverlayButton();
         registrationProfile.setPassword(registrationProfile.getPassword());
         myProfilePage.forceWaitAction();
         
       //  registrationProfile.setPassword(registrationProfile.getConfPassword());
         return new MyProfileAction(registrationProfile);
     }
     
    
   

    /*
    ******************************************************************************
         Method :updateMyProfileAction

       Created On:12/02/2011
       Description: This method enters input in second page.
    ******************************************************************************
    */
    public MyProfileAction verifyViewsAction() throws InterruptedException {
        MyProfilePage myProfilePage = new MyProfilePage(registrationProfile);
// 	
        myProfilePage.verifyViews();
        return new MyProfileAction(registrationProfile);
       
    }

    /*
    ******************************************************************************
         Method :pwdInvalidationAction

       Description: This method validates password with number of invalid passwords.
    ******************************************************************************
    */
    public MyProfileAction pwdInvalidationAction(String systemDate,String expAuditType) throws InterruptedException {
        MyProfilePage myProfilePage = new MyProfilePage(registrationProfile);
        myProfilePage.pwdInvalidationPage(systemDate,expAuditType);
        return new MyProfileAction(registrationProfile);
    }

    /*
    ******************************************************************************
         Method :pwdInvalidationAction

       Description: This method validates password with number of invalid passwords.
    ******************************************************************************
    */
    public MyProfileAction pwdLenInvalidationAction(String systemDate,String expAuditType) throws InterruptedException {
        MyProfilePage myProfilePage = new MyProfilePage(registrationProfile);
        myProfilePage.pwdLenInvalidationPage(systemDate,expAuditType);
        return new MyProfileAction(registrationProfile);
    }
    /*
    ******************************************************************************
         Method :ProfileViewsTable

       Description: This method validates Table Views
    ******************************************************************************
    */
    public MyProfileAction profileViewsTable() throws InterruptedException {
        MyProfilePage myProfilePage = new MyProfilePage(registrationProfile);
        myProfilePage.profileViewsTable();
        return new MyProfileAction(registrationProfile);
    }
    /*
    ******************************************************************************
         Method :AccountValue

       Description: This method validates AccountValue count
    ******************************************************************************
    */
    public MyProfileAction accountValueCount() throws InterruptedException {
        MyProfilePage myProfilePage = new MyProfilePage(registrationProfile);
        myProfilePage.accountValueCount();
        return new MyProfileAction(registrationProfile);
    }

    
    
    /*
     ******************************************************************************
          Method :verifyDBViewsCount

        Description: This method validates Views count in DB
     ******************************************************************************
     */
     	   public MyProfileAction verifyDBViewCount() {
     		   MyProfilePage bgLoginPage = new MyProfilePage(registrationProfile);
     			bgLoginPage.verifyDBViewCount();
     			return new MyProfileAction(registrationProfile);
     		    }
     	    
  /*
 ******************************************************************************
Method :DBViewCount

Description: This method validates Views count in DB
******************************************************************************
*/
     	 public MyProfileAction dbViewCount(int button3,String email) {
     	    MyProfilePage bgLoginPage = new MyProfilePage(registrationProfile);
     	    bgLoginPage.dbViewCount(button3,email);
     	    return new MyProfileAction(registrationProfile);
     	    }
     	     	        	   
     	  
    /*
    ******************************************************************************
         Method :verifyDBAccountCount

       Description: This method validates AccountValue count in DB
    ******************************************************************************
    */
    	   public MyProfileAction verifyDBAccountCount(String final_test1,String email) {
    		   MyProfilePage bgLoginPage = new MyProfilePage(registrationProfile);
    			bgLoginPage.verifyDBAccountCount(final_test1,email);
    			return new MyProfileAction(registrationProfile);
    		    }
    
    
    /*
     ******************************************************************************
          Method :PreviewNextButton

        Description: This method validates PreviewNextButton
     ******************************************************************************
     */
     public MyProfileAction previewNextButton() throws InterruptedException {
         MyProfilePage myProfilePage = new MyProfilePage(registrationProfile);
         myProfilePage.previewNextButton();
         return new MyProfileAction(registrationProfile);
     }
     

     
     /*
      ******************************************************************************
           Method :AcsendingDesendingButton

         Description: This method validates AcsendingDesendingButton
      ******************************************************************************
      */
      public MyProfileAction acsendingDesendingButton() throws InterruptedException {
          MyProfilePage myProfilePage = new MyProfilePage(registrationProfile);
          myProfilePage.acsendingDesendingButton();
          return new MyProfileAction(registrationProfile);
      }
     
}