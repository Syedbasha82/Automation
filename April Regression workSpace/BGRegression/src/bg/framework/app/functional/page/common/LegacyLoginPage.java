package bg.framework.app.functional.page.common;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.sales.EshopNewPage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SshClient;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

import com.jcraft.jsch.JSchException;

public class LegacyLoginPage extends BasePage {

    private final static String FILE_NAME = "resources/common/LoginPage.properties";

    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
    private static String dataXml;
    public void loginUser(UserProfile userProfile) {
    	browser.wait(getWaitTime());
    	browser.wait(getWaitTime());
    //  final String expectedEmailAdd = new OnlineDBConnector().getUserEmail(userProfile.getUCRN());
      //verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id", expectedEmailAdd);
    	browser.Enterinput(userProfile.getEmail());
		browser.EnterPassword(userProfile.getPassword());
		//browser.ClickTabKey();
        browser.ClickEnterKey();
    	/*verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id", userProfile.getEmail());
        verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password", userProfile.getPassword());*/
        //browser.clickWithClass(pageProperties.getProperty("LoginPage.LoginSubmitClass"));
      /*  browser.clickWithXpath(pageProperties.getProperty("LoginPage.NewLoginSubmitXpath"));*/
       // verifyAndClick("Log in", "Login Submit Button");
        
      
       // continueToMyAccount();
        
     //closeInfoOverlay();
    }
    
    public void navigateToLoginServiceDeepLinkFV(){
        browser.open(ApplicationConfig.APP_BG_URL+"/asv?cid=dplnkoamasv");
        
      }

    //// For model sales ////
    public void loginWithEmailId(){
    	String Emailid = new EshopNewPage().getEmailId();
    	verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id",Emailid);
        verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password", "password12");
        verifyAndClick("login", "Login Submit Button");
    }

    public void loginUserSMBNegative(UserProfile userProfile) {
        final String expectedEmailAdd = new OnlineDBConnector().getUserEmail(userProfile.getUCRN());
         verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id", expectedEmailAdd);
         //verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id", userProfile.getEmail());
         verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password", userProfile.getPassword());
         //browser.clickWithClass(pageProperties.getProperty("LoginPage.LoginSubmitClass"));
         browser.clickWithXpath(pageProperties.getProperty("LoginPage.NewLoginSubmitXpath"));
         browser.wait(getWaitTime());
         continueToMyAccountSMBNegative();
         //closeInfoOverlay();
     }
    public void continueToMyAccountSMBNegative(){
        browser.wait(3000);
        /*if(browser.isElementVisibleWithXpath(".//*[@id='splash_overlay']/div/div[3]/div[2]/div/p[6]/span/a")){
             browser.clickWithLinkText("Continue to my account");
        }*/
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("LoginPage.welcomeMessage"))) {
            Report.updateTestLog("User logged in Successfully", "PASS");
            browser.clickWithXpath(pageProperties.getProperty("LoginPage.welcomeMessage"));
            
         if(!browser.isElementVisibleWithXpath(pageProperties.getProperty("SMB.SMBLink"))){
        	 Report.updateTestLog("SMB Link is not displayed", "PASS");}
        	 else
        	 Report.updateTestLog("SMB Link is displayed", "FAIL");	 
         
        }
}
    public void loginUserSMB(UserProfile userProfile) {
        final String expectedEmailAdd = new OnlineDBConnector().getUserEmail(userProfile.getUCRN());
         verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id", expectedEmailAdd);
         //verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id", userProfile.getEmail());
         verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password", userProfile.getPassword());
         //browser.clickWithClass(pageProperties.getProperty("LoginPage.LoginSubmitClass"));
         browser.clickWithXpath(pageProperties.getProperty("LoginPage.NewLoginSubmitXpath"));
         browser.wait(getWaitTime());
         continueToMyAccountSMB();
         //closeInfoOverlay();
     }
    
    public void verifyMAPLoginPageCID(){
    	String CID="dplnkpayment";
    	String loginURL=browser.getURL();
    	System.out.println("33333333333333333333333333333333333333333333333"+loginURL);
    	if(loginURL.contains(CID)){
    		Report.updateTestLog("CID code Appended for Login Page Successfully", "PASS");
    	}
    	else{
    		Report.updateTestLog("CID code is not Appended for Login Page Successfully", "FAIL");
    	}
    	
    }
    public void continueToMyAccountSMB(){
        browser.wait(3000);
        /*if(browser.isElementVisibleWithXpath(".//*[@id='splash_overlay']/div/div[3]/div[2]/div/p[6]/span/a")){
             browser.clickWithLinkText("Continue to my account");
        }*/
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("LoginPage.welcomeMessage"))) {
            Report.updateTestLog("User logged in Successfully", "PASS");
            browser.clickWithXpath(pageProperties.getProperty("LoginPage.welcomeMessage"));
            verifyIsElementVisibleWithXpath(pageProperties.getProperty("SMB.SMBLink"), "Link");  
        }
}
    public void closeInfoOverlay(){
        if(browser.isElementVisible(pageProperties.getProperty("LoginPage.InfOverlay"))){       		
          if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LoginPage.closeOverlay"))){
        	browser.clickWithXpath(pageProperties.getProperty("LoginPage.closeOverlay"));
        	browser.wait(getWaitTime());
          }
        }
    }
    public void continueToMyAccount(){
        browser.wait(3000);
        
             browser.clickWithLinkText("Continue to your account");
       /* 
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("LoginPage.welcomeMessage"))) {
            Report.updateTestLog("User logged in Successfully", "PASS");
            browser.clickWithXpath(pageProperties.getProperty("LoginPage.welcomeMessage"));
        }*/
    }
    public void loginUserAutoDirectToContactUsPage(UserProfile userProfile) {
        loginUser(userProfile);

    }

    public void navigateToChangeEmailAddress() {
        verifyAndClickWithLinkText(pageProperties.getProperty("LoginPage.ChangeEmailAddressLink"), "Change My Email Address Link");
    }

    public void navigateToForgottenEmailAddress() {
        verifyAndClickWithLinkText(pageProperties.getProperty("LoginPage.ForgottenEmailAddressLink"), "I've Forgotten my Email Address Link");
        browser.wait(getWaitTime());
    }

    public void navigateToForgottenPassword() {
        verifyAndClickWithLinkText(pageProperties.getProperty("LoginPage.ForgottenPasswordLink"), "I've Forgotten My Password Link");
    }

    public void navigatetoForgotEmailPage() {
    	
    	     	   
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("LoginPage.ForgotEmailID"))) {
            browser.clickWithXpath(pageProperties.getProperty(("LoginPage.ForgotEmailID")));
            browser.wait(getWaitTime());
        }
    }

    public void navigatetoForgotEmailViaForgotPassword() {
        browser.clickWithXpath(pageProperties.getProperty("LoginPage.ForgotPasswordID"));
        browser.wait(getWaitTime());
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("LoginPage.ForgotEmailID"))) {
            browser.clickWithXpath("//a[contains(@title,'forgotten my')]");
        }
    }

    public void loginErrorForFreezedAccount(UserProfile userProfile) {
       
    	//String error=browser.getTextByXpath("//*[@id='errorList']/li");
    	String error=browser.getTextByXpath(pageProperties.getProperty("LoginPage.ErrorMessageDisplayed"));
    	if(error.contains("For security purposes, we have denied access to your online account."))
    	{
    		 Report.updateTestLog("Error validation is success for Freezed Account", "PASS");
    	}else
    	{
    		 Report.updateTestLog("Error validation is failed for Freezed Account", "FAIL");
    	}
    	
    }
    
    public void verifyAccountLock(UserProfile userProfile) {
        OnlineDBConnector onlinedbconnector = new OnlineDBConnector();
        onlinedbconnector.dbAccountunlock(userProfile.getUCRN());

        String[] password = new String[3];
        password[0] = "pass1";
        password[1] = "pass2";
        password[2] = "pass3";
        for (int i = 0; i < 1; i++) {
            browser.wait(1000);
            userProfile.setPassword("pass");
            loginUser(userProfile);
            if (verifyIsTextPresent(GlobalErrorMessages.NEW_NEW_BLUE_LOGINTRYCOUNT_1)) {
                Report.updateTestLog("invalid password login attempt 1", "PASS");
            }
            browser.wait(1000);
            loginUser(userProfile);
            if (verifyIsTextPresent(GlobalErrorMessages.NEW_NEW_BLUE_LOGINTRYCOUNT_2)) {
                Report.updateTestLog("invalid password login attempt 2", "PASS");
            }
            loginUser(userProfile);
            if (verifyIsTextPresent("Your account will be reactivated in 24 hours")) {
                Report.updateTestLog("Account is locked after 3 attempts", "PASS");
            } else {
                Report.updateTestLog("Account is not locked", "FAIL");
            }
        }
        int freeze_acct = onlinedbconnector.getLoginTryCount(userProfile.getUCRN());
        if (freeze_acct == 3) {
            Report.updateTestLog("DB Account Lock verification ", "PASS");
        } else {
            Report.updateTestLog("DB Account Lock verification ", "FAIL");
        }
    }

    public void loginErrorValidation(UserProfile userProfile) {
        String[] errormsg = new String[3];
        errormsg[0] = "We have not been able to match your details with the account in our system.";
        errormsg[1] = "A required field has not been completed";
        String[] EmailID = new String[3];
        EmailID[0] = "prathap898@centrica.com";
        EmailID[1] = "prathap898@centrica.com";
        EmailID[2] = userProfile.getEmail();
        String[] password = new String[3];
        password[0] = "pass1";
        password[1] = "";
        password[2] = userProfile.getPassword();
        for (int i = 0; i < 3; i++) {
            browser.wait(1000);
            browser.clearValue(pageProperties.getProperty("LoginPage.Email"));
            browser.input(pageProperties.getProperty("LoginPage.Email"), EmailID[i]);
            Report.updateTestLog("Login with email id:" + userProfile.getEmail(), "DONE");
            browser.clearValue(pageProperties.getProperty("LoginPage.Password"));
            browser.input(pageProperties.getProperty("LoginPage.Password"), password[i]);
            browser.clickWithXpath(pageProperties.getProperty("LoginPage.LoginSubmitClass"));
            browser.wait(1000);
            String expectedName = errormsg[i];
            if (i == 0) {
                String actualName1 = browser.getTextByXpath(pageProperties.getProperty("LoginPage.loginerror1"));
                if (actualName1.trim().contains(expectedName)) {
                    Report.updateTestLog("Login error by using wrong password and username", "PASS");
                } else {
                    Report.updateTestLog("Login error by using wrong password and username", "FAIL");
                }
            }
            if (i == 1) {

                String actualName2 = browser.getTextByXpath(pageProperties.getProperty("LoginPage.loginerror2"));
                System.out.println("senthil:"+actualName2);
                if (actualName2.trim().contains(expectedName)) {
                    Report.updateTestLog("Login error by using wrong password and username", "PASS");
                } else {
                    Report.updateTestLog("Login error by using wrong password and username", "FAIL");
                }
            }
        }
    }

    public void loginForInactiveAccount(UserProfile userProfile) {
        loginUser(userProfile);
        String expectedName;
        //errormsg[0]="Sorry, your online account is no longer active";
        //expectedName = "Your online account is no longer available as your account was closed over 6 months ago. If your account is still active, or you have a query or wish to return to British Gas, please";
        expectedName="This is because you haven't used it for over 6 months. Give us a call on 0800 048 0505 and we can get your account back online quickly and easily.";
        String actualName = browser.getTextByXpath(pageProperties.getProperty("LoginPage.logininactive1"));

        if (actualName.contains(expectedName)) {
            Report.updateTestLog("Error message while Login account inactive  pastdate greater than 6 mths", "PASS");
        } else {
            Report.updateTestLog("Error message while Login account inactive  pastdate greater than 6 mths", "FAIL");
        }


    }

    public void emailCheckBoxVerification(UserProfile userProfile) {
        browser.wait(1000);
        browser.input(pageProperties.getProperty("LoginPage.Email"),
        		userProfile.getEmail());
        Report.updateTestLog("Login with email id:" + userProfile.getEmail(), "DONE");
        browser.input(pageProperties.getProperty("LoginPage.Password"),
        		userProfile.getPassword());
        Report.updateTestLog("Login with password:" + userProfile.getPassword(), "DONE");
        browser.click(pageProperties.getProperty("LoginPage.EmailCheckBox"));
        Report.updateTestLog("Email check box is clicked", "DONE");
        browser.clickWithXpath(pageProperties.getProperty("LoginPage.LoginSubmitClass"));
        browser.wait(1000);
        verifyPageTitle("Account overview");
        continueToMyAccount();
        Report.updateTestLog("Login to application", "DONE");
        browser.wait(2000);
        String title=browser.getTextByXpath("//title");
        verifyPageTitle("Account overview");
        browser.clickWithXpath(pageProperties.getProperty("LoginPage.LogOut"));
        //browser.clickWithLinkText(pageProperties.getProperty("LoginPage.LogOut"));
        Report.updateTestLog("Logout of application", "DONE");

       
        String actualValue = browser.getAttribute(pageProperties.getProperty("LoginPage.Email"),"value");
        if (actualValue.contains(userProfile.getEmail())) {
            Report.updateTestLog("Email Populated in text box", "PASS");
        } else {
            Report.updateTestLog("Email is not Populated in text box", "FAIL");
        }
        browser.click(pageProperties.getProperty("LoginPage.EmailCheckBox"));


    }
    public void logOut(){
        verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.LogOut"),"Log out Link");
        getWaitTime();
        browser.wait(3000);
    }
    public void loginUserDetails(UserProfile userProfile) {
        /*final String expectedEmailAdd = new OnlineDBConnector().getUserEmail(userProfile.getUCRN());
        verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id", expectedEmailAdd);*/
    	//browser.wait(3000);
    	/*verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id", userProfile.getEmail());
        verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password", userProfile.getPassword());
        browser.clickWithXpath(pageProperties.getProperty("LoginPage.NewLoginSubmitXpath"));*/
        
    	browser.Enterinput(userProfile.getEmail());
		browser.EnterPassword(userProfile.getPassword());
        browser.wait(getWaitTime());
        browser.ClickEnterKey();
        //continueToMyAccount();
        
    }
    public void verifyLastLoginTimestampOverlay(){
    	if(browser.isElementVisible(pageProperties.getProperty("LoginPage.LastLoginsixmonthOverlay"))){
    		verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.updateMyDetailsButton"),"updateMyDetailsButtonUpdate My Details Button");
    		browser.wait(3000);
    		String strTitle = browser.getTextByXpath("//title");
    		if(strTitle.contains(pageProperties.getProperty("LoginPage.updateYourDetails"))){
    			
    		}
    		
    	}
    }
public void calllogs_test(String strStatus, String intAccNumber, String intUCRN ){
    	
    	SshClient sshClient= new SshClient();
    	try {
			sshClient.connect(); 
    		//PrintWriter out = new PrintWriter("C:\\Documents and Settings\\!boobalas\\My Documents\\Check_Putty.txt");
        	if(sshClient.isConnected()){
        		System.out.println(sshClient.send("cd domains/wl_fit/crx-quickstart/logs"));
        		System.out.println(sshClient.send("cp error.log putty_current.txt"));
        		dataXml = sshClient.send("tail -n 1000 putty_current.txt");
        		System.out.println(dataXml);
        		
        		if (dataXml.contains(intUCRN)) {        
        	           System.out.println("UCRN Verification is successful and  UCRN is Present in Response log" + intUCRN); 
        	           Report.updateTestLog("UCRN Verification is successful and  UCRN Number is Present in Response log; UCRN Number = " + intUCRN, "PASS");
        	           
        	           if(dataXml.contains(intAccNumber)){
        	        	   System.out.println("Account Number Verification is successful and  Account Number is Present in Response log" + intAccNumber);
        	        	   Report.updateTestLog("Account Number Verification is successful and  Account Number is Present in Response log is " + intAccNumber, "PASS");
        	        	   }
        	           else{
        	        	   Report.updateTestLog("Account Number Verification is NOT successful", "Warning");
        	           }
        	           if(dataXml.contains(strStatus)){
        	        	   System.out.println("Account Status Verification is successful" + strStatus);
        	        	   Report.updateTestLog("Account Status Verification is successful; Status = " + strStatus, "PASS");
        	           }
        	           else{
        	        	   Report.updateTestLog("Account Status Verification is NOT successful " , "Warning");
        	           }       	          
        	        	   
        	       } 
        		   
        		  else {
        			  System.out.println("UCRN Verification is not present in Response log" + intUCRN);
        			  Report.updateTestLog("UCRN Verification is NOT successful ", "Warning");
        	       } 
        		//out.println(sshClient.send("cat putty_current.txt"));
        	}

			/*BufferedReader reader=new BufferedReader( new InputStreamReader(new FileInputStream("C:\\Documents and Settings\\!raghavp2\\My Documents\\nohup.out"))); 
			List<String> logContents=new ArrayList<String>(334130);
			
			for(String line;((line=reader.readLine())!=null);)
			{
				//System.out.println(line);
				logContents.add(line);
				
			}

//			Iterator<String> logIterator=logContents.listIterator();

			for(int i=logContents.size();i>=0;i--)
			{
				String currentLine=logContents.get(i);
				if(currentLine.contains("<ManufacturerSerialNumber>G4K18010820701</ManufacturerSerialNumber>"))
				{
					System.out.println("Found MeterSerial Number String");
					if(currentLine.contains("<code>7901</code>"))
					{
						System.out.println("Found code 7901 in the same line");
						List<String> sublLog=logContents.subList(i, logContents.size()-1);
						for(String currentSubLogLine:sublLog)
						{
							if(currentSubLogLine.contains("<BusinessDocumentProcessingResultCode>6</BusinessDocumentProcessingResultCode>")||currentSubLogLine.contains("<BusinessDocumentProcessingResultCode>7</BusinessDocumentProcessingResultCode>"))
							{
								System.out.println("Log Validated and Pass.");
								return;
							}
						}
					}
				}
			}*/
			System.out.println("Log validated did not find some contets.");
    	} catch (JSchException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

public void BgbloginUser(UserProfile userProfile) {
    //final String expectedEmailAdd = new OnlineDBConnector().getUserEmail(userProfile.getUCRN());
     verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id", userProfile.getEmail());
     verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password", userProfile.getPassword());
     //browser.clickWithClass(pageProperties.getProperty("LoginPage.LoginSubmitClass"));
//     verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.NewLoginSubmitXpath"),"Submit button")) ;
     verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.NewLoginSubmitXpath"), "Submit button");
     browser.wait(getWaitTime());
//     continueToMyAccount();
     //closeInfoOverlay();
 }

public void ClickGoToBusinessSite(UserProfile userProfile) {
	 verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.GotoBusinessLink"), "GoToBusinessSite");
     browser.wait(getWaitTime());
 }
public void EnterInvalidEmailorPass(UserProfile userProfile) {
	verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id","S3e4r5t6u@bgtest.co.uk");
    verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password", userProfile.getPassword());
    browser.clickWithXpath(pageProperties.getProperty("LoginPage.NewLoginSubmitXpath"));
    browser.wait(getWaitTime());
    /*final int loginTryCount = new OnlineDBConnector().verifyLoginTryCount(userProfile.getEmail());
    if (loginTryCount==2){
    	Report.updateTestLog("Login Try Count is set to '2'", "Pass");
     }
    else{
    	Report.updateTestLog("Login Try Count is not set to '2'", "Pass");
    }*/
}

public void VerifyPrePopulateEmailorPass(UserProfile userProfile) {
	String prepopulate=browser.getText(pageProperties.getProperty("LoginPage.Email"));
	if (prepopulate==userProfile.getEmail()){
		Report.updateTestLog("Prepopulate email id is displayed(Remember Email)", "Pass");
	}else{
		Report.updateTestLog("Prepopulate email id is not displayed(Remember Email)"+"Prepopulated id is :"+prepopulate+"Given email is:"+userProfile.getEmail(), "Fail");
	}
}

public void CheckRememberEmail(UserProfile userProfile) {
	verifyAndSelectCheckBoxByXpath(pageProperties.getProperty("LoginPage.Email"), "Remember Email Checkbox");
}

public void loginEmailErrorMessageValidation(UserProfile userProfile) {
	String email1="";
	String email2="qw2w3w3w@bgtest.co.uk";
	String email3="length60";
	String email4="smartinsight_25@smart@bgtest.co.uk";
	String error1="enter the email address";
	String error2="not been able to match your details"; //incorrect email address
	String error3="not been able to match your details"; //length above 60
	String error4="email address or your password are incorrec"; //incorrect format
	String Email = "Emailvalidation";
	enterInvalidEmail(userProfile,email1,Email);
	getErrorMsgLoginscreen(error1);
	enterInvalidEmail(userProfile,email2,Email);
	getErrorMsgLoginscreen(error2);
	enterInvalidEmail(userProfile,email3,Email);
	getErrorMsgLoginscreen(error3);
	enterInvalidEmail(userProfile,email4,Email);
	getErrorMsgLoginscreen(error4);
	browser.close();
}

public void loginPasswordErrorMessageValidation(UserProfile userProfile) {
	String pass1="";
	String pass2="qw2w3w3w@bgtest.co.uk";
	String pass3="Password12Password12Password12";
	String error1="Please enter your password";
	String error2="Your email address or password has not been recognised"; //incorrect email address
	String error3="Your email address or password has not been recognised"; //length above 60
	String Email = "Passwordvaldiation";
	enterInvalidEmail(userProfile,pass1,Email);
	getErrorMsgLoginscreen(error1);
	/*enterInvalidEmail(userProfile,pass2,Email);
	getErrorMsgLoginscreen(error2);*/
	/*enterInvalidEmail(userProfile,pass3,Email);
	getErrorMsgLoginscreen(error3);*/
	browser.close();
}
public void enterInvalidEmail(UserProfile userProfile,String value,String Validation){
	if(Validation=="Emailvalidation"){
		if(value=="length60"){
		  String emailInv="SmartinsightsmartinsightsmartinsightSmartinsight@bgtest.co.uk";	
		  verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id",emailInv);
		}else{
		  verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id",value);		
		}
	    verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password", userProfile.getPassword());
	    browser.clickWithXpath(pageProperties.getProperty("LoginPage.NewLoginSubmitXpath"));
	}else{
         verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id",userProfile.getEmail());
         verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password", value);
         browser.clickWithXpath(pageProperties.getProperty("LoginPage.NewLoginSubmitXpath"));
	}
}

public void getErrorMsgLoginscreen(String emailErrorMessage) {
	String errormsgvalue=browser.getTextByXpath(pageProperties.getProperty("LoginPage.ErrorMessageDisplayed"));
	if (errormsgvalue.contains(emailErrorMessage)){
		Report.updateTestLog("Valid error message :"+errormsgvalue+"-displayed", "Pass");
	}else{
		Report.updateTestLog("Valid error message :"+errormsgvalue+"-not displayed", "Fail");
	}
		
}

public void enterEmailCaseSensitive(UserProfile userProfile) {
    //final String expectedEmailAdd = new OnlineDBConnector().getUserEmail(userProfile.getUCRN());
     String emailCase=userProfile.getEmail();
     if ((emailCase != null) && (emailCase.contains("@") )){
    	 try{
    		 String[] emailsplit=emailCase.split("@");
		     boolean isuppercase=Character.isUpperCase(emailsplit[0].charAt(0));
		     if (isuppercase){
		    	 String convertEmaillower=emailsplit[0].toLowerCase();
		    	 verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id",convertEmaillower+"@"+emailsplit[1]); 
		     }else{
		    	 String convertEmaillower=emailsplit[0].toUpperCase();
		    	 verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id",convertEmaillower+"@"+emailsplit[1]); 
		     }
    	 }catch(Exception e){
    		 Report.updateTestLog("Exception when the string is converted to uppercase or lower case :"+e, "Fail");
    	 }
	    	 
	     verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password", userProfile.getPassword());
	     //browser.clickWithClass(pageProperties.getProperty("LoginPage.LoginSubmitClass"));
	     browser.clickWithXpath(pageProperties.getProperty("LoginPage.NewLoginSubmitXpath"));
	     browser.wait(getWaitTime());
	     continueToMyAccount();
     //closeInfoOverlay();
     }else{
    	 Report.updateTestLog("Email address in the userprofile.xml file is null/Invalid :"+emailCase, "Fail");
     }
    	 
 }

public void verifyBrowserBackPage(UserProfile userProfile) {
	browser.browserBack();
	verifyPageTitle("Login to Your Account - British Gas");	 
 }

public void closeBrowser() {
	browser.close();
	Report.updateTestLog("Browser Closed succesfully", "Pass");
	/*getWaitTime();
	if (browser.isElementVisibleWithXpath(pageProperties.getProperty("HomePage.LoginPageLink"))) {
		Report.updateTestLog("Browser not Closed succesfully", "Fail");
    } else{
    	Report.updateTestLog("Browser Closed succesfully", "Pass");
    }*/
 }


	public void validateNewPasswordField(UserProfile userProfile) {
		enterEmailAddress(userProfile,userProfile.getEmail());
	    final String dbPwd = new OnlineDBConnector().getPassword(userProfile.getUCRN());
	    String pwd = "password12";
	    new OnlineDBConnector().updateOneTimePassword(userProfile.getUCRN(),dbPwd);
	    browser.wait(1000);
	    String emailAddress = userProfile.getEmail();
	    if (ApplicationConfig.BRAND.equalsIgnoreCase("BG")) {
			browser.open(ApplicationConfig.APP_BG_URL
			        + "/Password-Reset/Password-Temporary-Entry/"+emailAddress+"/1/"+pwd+"/");
			} else {
			browser.open(ApplicationConfig.APP_FUSION_URL
			        + "/Password-Reset/Password-Temporary-Entry/"+emailAddress+"/2/"+pwd+"/");
			}
		browser.wait(getWaitTime());
	
	    
	    }
    
    public void enterEmailAddress(UserProfile userProfile,String emailAddress) {
    	if (browser.isElementVisible(pageProperties.getProperty("ForgottenPassword.EmailIDField"))){
    	verifyAndInputById(pageProperties.getProperty("ForgottenPassword.EmailIDField"), "Customer Email Address", emailAddress);
        verifyAndClickWithXpath(pageProperties.getProperty("ForgottenPassword.ContinueButton"), "Continue Button");
        browser.wait(1000);
        Report.updateTestLog("Email is triggered to reset your Password ","PASS");
    	}
      }
}
