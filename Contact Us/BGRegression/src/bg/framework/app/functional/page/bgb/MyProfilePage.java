package bg.framework.app.functional.page.bgb;

import bg.framework.app.functional.action.bgb.MyProfileAction;
import bg.framework.app.functional.action.bgb.RegistrationAction;
import bg.framework.app.functional.entities.RegistrationProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.common.functional.UIDriver;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//import com.sun.xml.internal.fastinfoset.sax.SystemIdResolver;

public class MyProfilePage extends BasePage {

    private final static String FILE_NAME = "resources/bgb/MyProfile.properties";
	private static final WebDriver WebDriver = null;
	private static Properties myProfProperties = new PropertyLoader(FILE_NAME)
			.load();

    private RegistrationProfile registrationProfile;
    // Report report = new Report();
    // String logPath = null;
    UIDriver web = new UIDriver(WebDriver);

    public MyProfilePage() {
    }

	// MyProfileAction regAction = new MyProfileAction(registrationProfile);

    public MyProfilePage(RegistrationProfile registrationProfile) {
        this.registrationProfile = registrationProfile;
    }

    /*
	 * *****************************************************************************
	 * Method :verifyMyProfileDetails Description: This method verifies
	 * MyProfileDetails
	 * **********************************************************
	 * *******************
    */
    public void verifyMyProfileDetails(RegistrationProfile registrationProfile) {
        browser.wait(2000);
        String expFname = registrationProfile.getFirstName();
        expFname = expFname.trim();
		// String actFname =
		// browser.getTextByXpath(regpageProperties.getProperty("BGBRegistration.FirstName"));
        if (browser.isTextPresent(expFname)) {
			Report.updateTestLog("First name " + expFname
					+ " is displayed correctly", "PASS");
        } else {
			Report.updateTestLog("First name " + expFname
					+ "  is not displayed correctly", "FAIL");
        }
        String expLname = registrationProfile.getLastName();
		// String actLname =
		// browser.getTextByXpath(regpageProperties.getProperty("BGBRegistration.LastName"));
        if (browser.isTextPresent(expLname)) {
			Report.updateTestLog("Last name " + expLname
					+ " is displayed correctly", "PASS");
        } else {
			Report.updateTestLog("Last name " + expLname
					+ "  is not displayed correctly", "FAIL");
        }

        String expEmail = registrationProfile.getEmail();
		// String actEmail =
		// browser.getTextByXpath(regpageProperties.getProperty("BGBRegistration.Email"));
        if (browser.isTextPresent(expEmail)) {
			Report.updateTestLog("Email " + expEmail
					+ " is displayed correctly", "PASS");
        } else {
			Report.updateTestLog("Email " + expEmail
					+ " is not displayed correctly", "FAIL");
        }
    }

    /*
	 * *****************************************************************************
	 * Method :verifyMyProfilePage
	 * 
	 * 
	 * Description: This method verifies MyProfileDetails
	 * ************************
	 * *****************************************************
     */

    public void verifyMyProfilePage() {
        browser.wait(1000);
        String expText1 = "My Profile";
        expText1 = expText1.trim();
		// String actFname =
		// browser.getTextByXpath(regpageProperties.getProperty("BGBRegistration.FirstName"));
        if (browser.isTextPresent(expText1)) {
			Report.updateTestLog(expText1 + " Title is displayed correctly",
					"PASS");
        } else {
			Report.updateTestLog(
					expText1 + " Title is not displayed correctly", "FAIL");
        }
        expText1 = "View account details";
        expText1 = expText1.trim();
		// String actFname =
		// browser.getTextByXpath(regpageProperties.getProperty("BGBRegistration.FirstName"));
        if (browser.isTextPresent(expText1)) {
			Report.updateTestLog(
					expText1 + " Sub Title is displayed correctly", "PASS");
        } else {
			Report.updateTestLog(expText1
					+ " Sub Title is not displayed correctly", "FAIL");
        }
    }

    /*
	 * *****************************************************************************
	 * Method :updatePassword
	 * 
	 * 
	 * Description: This method updates password
	 * *********************************
	 * ********************************************
     */

	public MyProfileAction updatePassword(String strPass)
			throws InterruptedException {

		verifyAndInputById(myProfProperties.getProperty("MyProfile.password"),
				"Password Text Box", strPass);

        return new MyProfileAction(registrationProfile);
    }

    /*
	 * *****************************************************************************
	 * Method :updateConfPassword
	 * 
	 * 
	 * Description: This method updates conf password
	 * ****************************
	 * *************************************************
    */
	public MyProfileAction updateConfPassword(String strConfPass)
			throws InterruptedException {
		verifyAndInputById(
				myProfProperties.getProperty("MyProfile.reenterPassword"),
				"Re-enter Password Text Box", strConfPass);
        return new MyProfileAction(registrationProfile);
    }

    /*
	 * *****************************************************************************
	 * Method :clickUpdateButton
	 * 
	 * 
	 * Description: This method clicks update button
	 * *****************************
	 * ************************************************
    */
    public void clickUpdateButton() {

		verifyAndClick(myProfProperties.getProperty("MyProfile.updateButton"),
				"Continue Button");
        browser.wait(4000);

    }

    /*
	 * *****************************************************************************
	 * Method :clickUpdateButton
	 * 
	 * 
	 * Description: This method clicks update button
	 * *****************************
	 * ************************************************
     */
     public void clickOkOverlayButton() {
	 browser.wait(1500);
		verifyAndClick(myProfProperties.getProperty("MyProfile.okButton"),
				"OK Button");

     }

     public void forceWaitAction() {
	 browser.wait(15000);
     }

    /*
	 * *****************************************************************************
	 * Method :verifyViewsPage
	 * 
	 * 
	 * Description: This method verifies Views in the myprofile page
	 * *************
	 * ****************************************************************
    */

    public void verifyViews() {
        String expText1 = "Your views";
        expText1 = expText1.trim();
		// String actFname =
		// browser.getTextByXpath(regpageProperties.getProperty("BGBRegistration.FirstName"));
        if (browser.isTextPresent(expText1)) {
            Report.updateTestLog(expText1 + "  is displayed correctly", "PASS");
        } else {
			Report.updateTestLog(expText1 + "  is not displayed correctly",
					"FAIL");
        }
		// verifyIsElementVisibleById(myProfProperties.getProperty("MyProfile.manageViewTble"),
		// "Your views table");

        String expText_1 = "Views";
		String expText_2 = browser.getTextByXpath(myProfProperties
				.getProperty("MyProfile.ViewTableHeader"));
		if (expText_2.equalsIgnoreCase(expText_1)) {

			Report.updateTestLog("Views Table Header is displayed correctly",
					"PASS");
		} else {

			Report.updateTestLog("Views Table Header not displayed correctly",
					"FAIL");
		}
    	String expText_3 = "Accounts";
		String expText_4 = browser.getTextByXpath(myProfProperties
				.getProperty("MyProfile.ViewAccountsHeader"));
		if (expText_4.equalsIgnoreCase(expText_3)) {

			Report.updateTestLog("Views Table Header is displayed correctly",
					"PASS");
		} else {

			Report.updateTestLog("Views Table Header not displayed correctly",
					"FAIL");
		}
    }

    /*
	 * *****************************************************************************
	 * Method :pwdInvalidationAction
	 * 
	 * Created On:12/03/2011 Description: This method validates password with
	 * number of invalid passwords.
	 * **********************************************
	 * *******************************
    */
	public MyProfileAction pwdInvalidationPage(String systemDate,
			String expAuditType) throws InterruptedException {
		LoginMultiSitePage bgLoginPage = new LoginMultiSitePage(
				registrationProfile);

		String[] pwd = { "xyz@centrica.com", "", "corrPassword1",
				"abcdpassword1", registrationProfile.getEmail() };
		String[] repwd = { "xyzs@centrica.com", "corrPassword1", "",
				"passwordCent", registrationProfile.getEmail() };

        for (int i = 0; i < pwd.length; i++) {
            updatePassword(pwd[i]);
            updateConfPassword(repwd[i]);
            clickUpdateButton();
			// bgLoginPage.verifyDbResetPass(registrationProfile.getEmail(),systemDate,
			// expAuditType);
            verifyErrorTextPassword(i);
        }

        return new MyProfileAction();
    }

    /*
	 * *****************************************************************************
	 * Method :pwdLenInvalidationAction
	 * 
	 * Created On:12/03/2011 Description: This method validates length of
	 * password.
	 * *****************************************************************
	 * ************
    */
	public void pwdLenInvalidationPage(String systemDate, String expAuditType)
			throws InterruptedException {
		LoginMultiSitePage bgLoginPage = new LoginMultiSitePage(
				registrationProfile);
		String[] pwd = { "corrPas",
				"corrPassword1corrPassword1corrPassword1corrPassword1" };
		String[] repwd = { "corrPas",
				"corrPassword1corrPassword1corrPassword1corrPassword1" };
        for (int i = 0; i < pwd.length; i++) {
            updatePassword(pwd[i]);
            updateConfPassword(repwd[i]);
            clickUpdateButton();
			// bgLoginPage.verifyDbResetPass(registrationProfile.getEmail(),systemDate,
			// expAuditType);
            verifyErrorTextPassword(0);
        }
		// pwd[0] = "corrPassword1";
		// repwd[0] = "corrPassword1";
		// updatePassword(pwd[0]);
		// updateConfPassword(repwd[0]);
		// verifyUpdateSuccessPage();
    }

    public void verifyErrorTextPassword(int i) {
        switch (i) {
            case 0:
                passwordError(ErrorMessages.PASSWORD_INVALID);
                break;
            case 1:
                passwordError(ErrorMessages.PASSWORD_EMPTY);
                break;
            case 2:
                passwordError(ErrorMessages.CONFIRM_PASSWORD_EMPTY);
                break;
            case 3:
                passwordError(ErrorMessages.CONFIRM_PASSWORD_NOT_MATCH);
                break;
            case 4:
                passwordError(ErrorMessages.PASSWORD_SAME_AS_EMAIL);
                break;
        }
    }

    private void passwordError(String error) {
        browser.wait(4000);
		String error1 = error.replaceAll("\n", " ");
        if (browser.isTextPresent(error1.trim())) {
			Report.updateTestLog("Error message <b>" + error1
					+ "</b> is displayed correctly", "PASS");
        } else {
			Report.updateTestLog("Error message <b>" + error1
					+ "</b> is not displayed correctly", "FAIL");

        }
    }

    /*
	 * *****************************************************************************
	 * Method :ProfileViewsTable
	 * 
	 * Created On:06/07/2012 Description: This method validates Tables
	 * ***********
	 * ******************************************************************
     */

	public void profileViewsTable() {

		int button_count = browser
				.getChildElementsCountByXpath(myProfProperties
						.getProperty("MyProfile.button"));
		for (int i = 1; i <= button_count; i++) {
			browser.clickWithXpath(myProfProperties
					.getProperty("MyProfile.buttonclick") + "[" + i + "]");
			int row_count1 = browser
					.getChildElementsCountByXpath(myProfProperties
							.getProperty("MyProfile.rowcount"));
			for (int j = 1; j <= row_count1; j++) {
				String Rowtext1 = browser
						.getTextByXpath(myProfProperties
								.getProperty("MyProfile.rowtext")
								+ "["
								+ j
								+ "]/td[1]");
				if (Rowtext1 != null && Rowtext1.length() > 0) {
					Report.updateTestLog("Views Name Dsiplayed correctly:  "
							+ Rowtext1, "PASS");
    	        } else {
					Report.updateTestLog("Views name is empty:    " + Rowtext1,
							"FAIL");

    	        }
				String Rowtext2 = browser
						.getTextByXpath(myProfProperties
								.getProperty("MyProfile.rowtext")
								+ "["
								+ j
								+ "]/td[2]");
				if (Rowtext1 != null && Rowtext1.length() > 0) {
					Report.updateTestLog("Views Name Dsiplayed correctly:  "
							+ Rowtext2, "PASS");
       	        } else {
					Report.updateTestLog("Views name is empty:    " + Rowtext2,
							"FAIL");

       	        }
				String email = registrationProfile.getEmail();
				new SearchInvoicesPage().dbViewCount(Rowtext1, email);

				String Rowtext22 = browser
						.getTextByXpath(myProfProperties
								.getProperty("MyProfile.rowtext")
								+ "["
								+ j
								+ "]/td[2]");

				if (Rowtext22.endsWith(")")) {
					String RP = Rowtext2.replace("(", "-");
					String[] test1 = RP.split("-");
					int test2 = test1[1].length();
					String test3 = test1[1].substring(0, test2 - 1);
					int finaltest = Integer.parseInt(test3);
					String ss = registrationProfile.getEmail();
    		    	new SearchInvoicesPage()
							.dbViewCountAccount(Rowtext1, test3);
				} else {
					String Rcount = "1";
					new SearchInvoicesPage().dbViewCountAccount(Rowtext1,
							Rcount);
    		    }
    		 }
		}

     }

     /*
	 * *****************************************************************************
	 * Method :AccountValueCountDB
	 * 
	 * Created On:06/08/2012 Description: This method validates AccountValue
	 * Count in DB
	 * ***************************************************************
	 * **************
      */

	public RegistrationAction dbViewCount(int buttion3, String email) {
		String strQuery = "Select count(*) from BG_BUSINESS_TA_CUSTOMER_REG Where EMAIL = '"
				+ registrationProfile.getEmail() + "'";

         OnlineDBConnector dbfunctions = new OnlineDBConnector();
         int regRowCount = dbfunctions.getRegDBCount(strQuery);
		// int finaltest2=Integer.parseInt(final_test1);
         if (regRowCount == buttion3) {
			Report.updateTestLog(
					"Views count matched successfully in DB-Actual is: "
							+ buttion3 + " Expected is " + regRowCount + "",
					"PASS");

         } else {
			Report.updateTestLog("Views count Mis-matched in DB-Actual is: "
					+ buttion3 + " Expected is " + regRowCount + "", "FAIL");
         }
         return new RegistrationAction();
     }

     /*
	 * *****************************************************************************
	 * Method :AccountValueCount
	 * 
	 * Created On:06/07/2012 Description: This method validates AccountValue in
	 * multiple Table
	 * ************************************************************
	 * *****************
	 */

      public void verifyDBViewCount() {


		int button_count = browser
				.getChildElementsCountByXpath(myProfProperties.getProperty("MyProfile.buttonclick"));

		if (button_count >= 2) {
			int button1 = button_count - 1;
			int button2 = button1 * 5;
			browser.clickWithXpath(myProfProperties.getProperty("MyProfile.DyButton").replace("0", ""+button_count)); //
			int row_count1 = browser
					.getChildElementsCountByXpath(myProfProperties.getProperty("MyProfile.rowcount"));
			int button3 = button2 + row_count1;
			String email = registrationProfile.getEmail();
			// new MyProfileAction(registrationProfile)
			// new SearchInvoicesPage()
			// .DBViewCount(button3, email);
		} else {
     			// browser.clickWithXpath(".//*[@id='dt-white-header_paginate']/span[3]/span["+button_count+"]");
			int button3 = browser
					.getChildElementsCountByXpath(myProfProperties.getProperty("MyProfile.rowcount"));
			// int button3=button2+row_count1;
			String email = registrationProfile.getEmail();
			// new MyProfileAction(registrationProfile)
			// new SearchInvoicesPage()
			// .DBViewCount(button3, email);
     	    }

      }

     /*
	 * *****************************************************************************
	 * Method :AccountValueCountDB
	 * 
	 * Created On:06/08/2012 Description: This method validates AccountValue
	 * Count in DB
	 * ***************************************************************
	 * **************
      */

	public RegistrationAction verifyDBAccountCount(String final_test1,
			String email) {
		String strQuery = "Select count(*) from BG_BUSINESS_TA_CUSTOMER_REG Where EMAIL = '"
				+ registrationProfile.getEmail() + "'";

         OnlineDBConnector dbfunctions = new OnlineDBConnector();
         int regRowCount = dbfunctions.getRegDBCount(strQuery);
		int finaltest2 = Integer.parseInt(final_test1);
         if (regRowCount == finaltest2) {
			Report.updateTestLog("Account count matched successfully in DB",
					"PASS");

         } else {
             Report.updateTestLog("Account count Mis-matched in DB", "FAIL");
         }
         return new RegistrationAction();
     }

	public void accountValueCount() {
     
		int button_count = browser
				.getChildElementsCountByXpath(myProfProperties.getProperty("MyProfile.button"));
		if (browser
				.isElementVisibleWithXpath(myProfProperties.getProperty("MyProfile.button"))) {

			for (int i = 1; i <= button_count; i++) {
				browser.clickWithXpath(myProfProperties.getProperty("MyProfile.DyButton").replace("0", ""+i));
				new MyProfilePage().resuse();
     		 }
		} else {
			new MyProfilePage().resuse();
    	  }
		if (button_count >= 10) {
			browser.clickWithXpath(myProfProperties.getProperty("Myprofile.clickbutton"));

    	  }

      }

	public void resuse() {

		int row_count1 = browser
				.getChildElementsCountByXpath(myProfProperties.getProperty("Myprofile.rowcount"));

		for (int k = 1; k <= row_count1; k++) {
			String Rowtext1 = browser
					.getTextByXpath(myProfProperties.getProperty("MyProfile.Row1").replace("0", ""+k));
			String Rowtext2 = browser
					.getTextByXpath(myProfProperties.getProperty("MyProfile.Row2").replace("0", ""+k));

			if (Rowtext2.endsWith(")")) {
				String RP = Rowtext2.replace("(", "-");
				String[] test1 = RP.split("-");
				int test2 = test1[1].length();
				String test3 = test1[1].substring(0, test2 - 1);
				int finaltest2 = Integer.parseInt(test3);
				String finaltest1 = Rowtext2.trim();
				String email = registrationProfile.getEmail();
				new MyProfileAction(registrationProfile).verifyDBAccountCount(
						finaltest1, email);
  		    }
  		    }
  		 }

     /*
	 * *****************************************************************************
	 * Method :PreviewNextButton
	 * 
	 * Created On:06/07/2012 Description: This method validates
	 * PreviewNextButton
	 * *********************************************************
	 * ********************
	 */

	public void previewNextButton() {

		int button_count = browser
				.getChildElementsCountByXpath(myProfProperties.getProperty("MyProfile.button"));
		if (button_count >= 2) {
			browser.clickWithXpath(myProfProperties.getProperty("Myprofile.clickbutton"));
     	   browser.wait(2000);
			browser.clickWithXpath(myProfProperties.getProperty("Myprofile.clickbuttonPrevious"));
			Report.updateTestLog(
					"Next and Previous button clicked successfully", "PASS");

		} else {
			Report.updateTestLog(
					"Next and Previous button not available in the page",
					"FAIL");
        }
      }

	public void acsendingDesendingButton() {

		int row_count = browser
				.getChildElementsCountByXpath(myProfProperties.getProperty("Myprofile.rowcount"));
		if (row_count >= 2) {
			verifyAndClickWithXpath(
					myProfProperties.getProperty("Myprofile.Ascending"),
					"AcsendingOrder");
      	   browser.wait(2000);
			verifyAndClickWithXpath(
					myProfProperties.getProperty("MyProfile.Desending"),
					"DesendingOrder");
			Report.updateTestLog(
					"Acsending and Desending Order button clicked successfully",
					"PASS");
		} else {
			Report.updateTestLog(
					"Acsending and Desending button not available in the page",
					"FAIL");
         }
       }
}