package bg.framework.app.functional.page.Slingshot;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.GlobalErrorMessages;
import bg.framework.app.functional.page.selfServe.AccountOverviewPage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SiebelDataBase;
import org.openqa.selenium.NoSuchElementException;
import java.util.ArrayList;

import java.util.Properties;

public class RegistrationPage extends BasePage {

	private final static String File_RegPage = "resources/ReFactoring/RegistrationPageRewrite.properties";
    private static Properties regPageProperties = new PropertyLoader(File_RegPage).load();

    private final static String email_Domain = "bgdigitaltest.co.uk";
    private final static String confirm_EmailMismatchChar = "a";
    private final static String noNectarValue = "4";
    private final static String addNewNectarValue = "2";
    private final static String addExistingNectarValue = "1";
    private final static String acceptTermsValue = "Y";
    public static String curRegAcctnumber = "";
    public static String curRegEmailAddress = "";
    final String logPath = null;
    final String Pass_Str = "PASS";
    final String Fail_Str = "FAIL";
    
    public RegistrationPage() {

    }

    public void registerUpdateYourDetails(UserProfile selfRegisterData,
                                          String accountNumber) {
        String logInfo = "";
        String logStatus = "PASS";

        try {

            curRegAcctnumber = accountNumber;
            logInfo = logInfo + " Registering using Account number: <b>"+ curRegAcctnumber + " </b>. ";
            verifyAndInputById(regPageProperties.getProperty("RegisterationPage.AccNoText"),"Customer Account Number",curRegAcctnumber);
            verifyAndSelectDropDownBox(regPageProperties.getProperty("RegistrationPage.TitleSelectId"), "Title", selfRegisterData.getTitle());
            verifyAndInputById(regPageProperties.getProperty("RegistrationPage.FirstNameTextId"), "First Name", selfRegisterData.getFirstName());
            verifyAndInputById(regPageProperties.getProperty("RegistrationPage.LastNameTextId"),"Last Name",selfRegisterData.getLastName());
            browser.wait(3000);
            verifyAndClickWithXpath(regPageProperties.getProperty("RegistrationPage.Continue1Button"),"Register Button");

            String emailData = selfRegisterData.getEmail();
            String confirmEmailData = selfRegisterData.getEmail();
            String emailOnPage = browser.getAttribute(regPageProperties.getProperty("RegistrationPage.EmailTextId"),"value");
            if (emailOnPage.trim().length() > 0)
                logInfo = logInfo + " Email address prepopulated on PageLoad: "
                        + emailOnPage + ". \n";
            else
                logInfo = logInfo
                        + "<b> Email address field is not populated on page load. </b>"
                        + emailOnPage + ". \n";

            if (null != emailOnPage && !emailOnPage.trim().equals("") && emailOnPage.contains("@")) {
                emailOnPage = emailOnPage.substring(0, emailOnPage.indexOf('@'));

            } else if (null != emailOnPage && emailOnPage.trim().equals(""))
                emailOnPage = null;

            String emailAddress = emailOnPage == null ? emailData : emailOnPage + "@" + email_Domain;

            if (null == confirmEmailData || !confirmEmailData.trim().equalsIgnoreCase("invalid")) {
                confirmEmailData = emailAddress;
            } else {
                confirmEmailData = confirm_EmailMismatchChar + emailAddress;
            }

            browser.clearValue(regPageProperties.getProperty("RegistrationPage.EmailTextId"));
            verifyAndInputById(regPageProperties.getProperty("RegistrationPage.EmailTextId"),"Email Address",emailAddress);
            curRegEmailAddress = emailAddress;
            logInfo = logInfo + "Updating user email address as '" + emailAddress + "'. ";
            if (browser.getAttribute(regPageProperties.getProperty("RegistrationPage.ConfirmEmailTextId"),"value").length() > 0) {
                logInfo = logInfo + "<b> Confirm Email Text is not blank on Page Load.</b> The value is: "
                        + browser.getAttribute(regPageProperties.getProperty("RegistrationPage.ConfirmEmailTextId"),"value") + "\n ";
                logStatus = "FAIL";
            }
            verifyAndInputById(regPageProperties.getProperty("RegistrationPage.ConfirmEmailTextId"),"Confirm Email Address",confirmEmailData);
            verifyAndInputById(regPageProperties.getProperty("RegistrationPage.PasswordTextId"),"Password",selfRegisterData.getPassword());
            verifyAndInputById(regPageProperties.getProperty("RegistrationPage.ConfirmPasswordTextId"),"Confirm Password",selfRegisterData.getPassword());
            verifyAndInputById(regPageProperties.getProperty("RegistrationPage.PhoneTextId"),"Phone Number",selfRegisterData.getPhoneNumber());
            verifyAndSelectDropDownBox(regPageProperties.getProperty("RegistrationPage.PhoneTypeSelectId"),"Phone Type",selfRegisterData.getPhoneType());
            browser.wait(3000);
            //String acceptTerms = selfRegisterData.getAcceptTerms().toLowerCase();
            //if (acceptTerms.startsWith(acceptTermsValue.toLowerCase())) {
                browser.click(regPageProperties.getProperty("RegistrationPage.acceptTermsCheckBoxId"));//,"Accept Terms and Conditions");
            //}

            // Update Nectar InformationHere
            String nectarInput = selfRegisterData.getNectarValue();
            if (browser.isElementVisible(regPageProperties.getProperty("RegistrationPage.NoNectarRadioId"))) {
                if (nectarInput.trim().equalsIgnoreCase(noNectarValue)) {
                    verifyAndClick(regPageProperties.getProperty("RegistrationPage.NoNectarRadioId"),"No Nectar Options");
                    logInfo = logInfo + " No Nectar Needed option. ";
                } else if (nectarInput.trim().equalsIgnoreCase(addNewNectarValue)) {
                    verifyAndClick(regPageProperties.getProperty("RegistrationPage.AddNewNectarRadioId"),"Add New Nectar Card");
                    logInfo = logInfo + " Selected Add New Nectar Option. ";
                } else if (nectarInput.trim().equalsIgnoreCase(addExistingNectarValue)) {
                    verifyAndClick(regPageProperties.getProperty("RegistrationPage.card_number"),"Existing Nectar Card");
                    browser.input(regPageProperties.getProperty("RegistrationPage.NectarTextId"),selfRegisterData.getNectarValue());
                    logInfo = logInfo+ " Selected Add Existing Nectar Option. Added the Card: "+ selfRegisterData.getNectarValue() + ". ";
                }
                if (browser.isElementVisible(regPageProperties.getProperty("RegistrationPage.NectarTermsCheckBoxId"))){ 
                	browser.click(regPageProperties.getProperty("RegistrationPage.NectarTermsCheckBoxId"));
                }
                /*String acceptNectarTerms = selfRegisterData.getAcceptTerms().toLowerCase();
                if (browser.isElementVisible(regPageProperties.getProperty("RegistrationPage.NectarTermsCheckBoxId"))) {
                    if (acceptNectarTerms.startsWith(acceptTermsValue.toLowerCase())) {
                        verifyAndClick(regPageProperties.getProperty("RegistrationPage.NectarTermsCheckBoxId"),"Nectar Terms and Conditions");
                    }
                }*/
                }
            // Update Log if Nectar Option Not Found on Page.
            else {
                logInfo = logInfo + "<b>No Nectar Radio button Found on Page. </b>";

            }

            verifyAndClickWithXpath(regPageProperties.getProperty("RegistrationPage.Continue2ButtonXPath"),"Continue Registration");
            browser.wait(4000);
            getWaitTime();
            // Verify Registration Success Messsage
            if(browser.isTextPresent(regPageProperties.getProperty("RegistrationPage.SuccessMessage")))
             Report.updateTestLog("Thanks, you're now registered confirmation message verified",Pass_Str);
             else {
              Report.updateTestLog("Thanks, you're now registered not in application",Fail_Str);
            }
            verifyIsTextPresent(regPageProperties.getProperty("RegistrationPage.SuccessMessageText"),"Online Account setup verification");
                //logInfo = logInfo + " User Registration Completed.<b>Success Message found.</b> User is in Page: "
                        //+ browser.getTextByXpath("//title");
                //logStatus = "PASS";

            // Verify Nectar Confirmation Message.
            if (addNewNectarValue.trim().equalsIgnoreCase(selfRegisterData.getNectarValue().trim())
                    || addExistingNectarValue.trim().equalsIgnoreCase(selfRegisterData.getNectarValue().trim())) {
                if (browser.isTextPresent(regPageProperties.getProperty("RegistrationPage.NewNectarSuccessMessage")))
                    logInfo = logInfo
                            + " New Nectar Added Success Message found on Page. ";
                else {
                    logInfo = logInfo
                            + " <b>Nectar Success Message not found.</b> User is in Page: "
                            + browser.getTextByXpath("//title") + ". ";
                    logStatus = "FAIL";
                }

            }
        } catch (NoSuchElementException ex) {
            logInfo = logInfo + "Caught Exception: " + ex.getMessage() + ". \n";
            logStatus = "FAIL";

            ex.printStackTrace();
            Report.updateTestLog(logInfo, logStatus);

        }

    }

    public void goToYourAccount() {
        verifyAndClickWithXpath(regPageProperties.getProperty("RegistrationPage.GotoYourAccLnk"), "Go to your account");
    }

// Enter valid details to register a Account Number
    
    public void registerAccount(final UserProfile userProfile){
    	 final String strAccountNum = userProfile.getElecAccount();
    	 final String strTitle = new SiebelDataBase().getTitle(userProfile.getUCRN());
    	 final String firstName = new SiebelDataBase().getFirstName(userProfile.getUCRN());
         final String lastName = new SiebelDataBase().getLastName(userProfile.getUCRN());
         enterRegistrationData(strAccountNum,strTitle,firstName,lastName);
    }

// Enter valid details to register a Online Account
    
    public void registerOnlineAccount(final UserProfile userProfile){
   	 final String strAccountNum = new SiebelDataBase().getAccountNumber(userProfile.getUCRN());
   	 validateWhyIsThisNeeded();
    } 
    
// Validating the Error Message by providing different invalid input combinations for Account Number    
    
    public void accountNumberErrorMsgValidation(final UserProfile userProfile,ArrayList<String> errList){
    	 final String firstName = new SiebelDataBase().getFirstName(userProfile.getUCRN());
         final String lastName = new SiebelDataBase().getLastName(userProfile.getUCRN());
         final String strTitle = new SiebelDataBase().getTitle(userProfile.getUCRN());
        //final String[] customerNum = {""};
        final String[] customerNum = {"", "850000000000", "8500000000", "85aaac234"};
         for (int i = 0; i < customerNum.length; i++) {
             if (i == 0) {
           	 enterRegistrationData("", strTitle, firstName, lastName);
           	 errorMsgComparison(errList.get(10),"Account Number");
            } else if (i == 1) {
            	 enterRegistrationData(customerNum[i], strTitle, firstName, lastName);
             errorMsgComparison(errList.get(8),"Account Number");	
            } else if (i > 1 & i < 3) {
             System.out.println(errList.get(9));
            	 enterRegistrationData(customerNum[i], strTitle, firstName, lastName);
           	 errorMsgComparison(errList.get(9),"Account Number");
             }
         }

    }

 // Validating the Error Message by providing different invalid input combinations for First Name

    public void firstNameErrorMsgValidation(final UserProfile userProfile,ArrayList<String> errList) {
        final String strAccountNum = new SiebelDataBase().getAccountNumber(userProfile.getUCRN());
        final String strLastName = new SiebelDataBase().getLastName(userProfile.getUCRN());
        final String strTitle = new SiebelDataBase().getTitle(userProfile.getUCRN());
        final String[] firstName = {"", "aa23", ".*a", "1234"};

        for (int i = 0; i < firstName.length; i++) {
            if (i == 0) {
            	enterRegistrationData(strAccountNum, strTitle, "", strLastName);
            	errorMsgComparison(errList.get(0),"First Name");
            } else if (i > 0) {
            	enterRegistrationData(strAccountNum, strTitle, firstName[i], strLastName);
            	errorMsgComparison(errList.get(1),"First Name");
            } 
        }

    }

// Validating the Error Message by providing different invalid input combinations for Last Name and finally
// select your account for navigation back to the Log In Page

    public void lastNameErrorMsgValidation(final UserProfile userProfile,ArrayList<String> errList) {
        final String strAccountNum = new SiebelDataBase().getAccountNumber(userProfile.getUCRN());
        final String strFirstName = new SiebelDataBase().getFirstName(userProfile.getUCRN());
        final String strTitle = new SiebelDataBase().getTitle(userProfile.getUCRN());
        final String[] lastName = {"", "aa23", ".*a", "1234"};

        for (int i = 0; i < lastName.length; i++) {
            if (i == 0) {
            	enterRegistrationData(strAccountNum, strTitle, strFirstName, "");
            	errorMsgComparison(errList.get(2),"Last Name");
            } else if (i > 0) {
            	enterRegistrationData(strAccountNum, strTitle, strFirstName, lastName[i]);
            	errorMsgComparison(errList.get(3),"Last Name");
            }
        }
        
    }

    
// Validating the Error Message by providing different invalid input combinations for Email Address and Confirm Email Address   
    
    public void emailAddressErrorMsgValidation(final UserProfile userProfile){
    	 final String expectedEmailAdd = new OnlineDBConnector().getUserEmail(userProfile.getUCRN());
         final String[] emailAddress = {"", "@@@@", "1234", "nest@digi.co.uk.com","", "@@@@", "1234", "nest@digi.co.uk.com"};
                  
         for (int i = 0; i < emailAddress.length; i++) {
             if (i == 0 & i < 2) {
            	 enterRegistrationOnline(emailAddress[i],expectedEmailAdd, "12345678","12345678","0207123456","Mobile"
            			 				 ,"Yes","Yes");
            	 errorMsgComparison(GlobalErrorMessages.ReFactoring_EMAIL_ERROR,"Email Address");
             } else if (i == 2) {
            	 enterRegistrationOnline(emailAddress[i],expectedEmailAdd, "12345678","12345678","0207123456","Mobile"
            			 				 ,"Yes","Yes");
            	 errorMsgComparison(GlobalErrorMessages.ReFactoring_ReferenceNumberInline_ERROR,"Email Address");
             } else if (i > 2 & i < 7 ){
            	 enterRegistrationOnline(expectedEmailAdd,emailAddress[i], "12345678","12345678","0207123456","Mobile"
            			 				 ,"Yes","Yes");
            	 errorMsgComparison(GlobalErrorMessages.ReFactoring_EMAIL_ERROR,"Confirm Email Address");
             } else if (i == 7) {
            	 enterRegistrationOnline(expectedEmailAdd,emailAddress[i], "12345678","12345678", "0207123456","Mobile"
            			 				,"Yes","Yes");
            	 errorMsgComparison(GlobalErrorMessages.ReFactoring_ReferenceNumberInline_ERROR,"Confirm Email Address");
         }
        }
    }

//  Validating the Error Message by providing different invalid input combinations for Password and Retype Password
    
    public void passwordErrorMsgValidation(final UserProfile userProfile){
   	 	final String expectedEmailAdd = new OnlineDBConnector().getUserEmail(userProfile.getUCRN());
        final String[] password = {"", "@@@@", "1234", "1235@123","", "@@@@", "1234", "1235@123"};
                
        for (int i = 0; i < password.length; i++) {
              if (i == 0 & i < 2) {
           	 	enterRegistrationOnline(expectedEmailAdd,expectedEmailAdd, password[i],"12345678","0207123456","Mobile"
           	 							,"Yes","Yes");
           	 	errorMsgComparison(GlobalErrorMessages.ReFactoring_EMAIL_ERROR,"Password");
            } else if (i == 2) {
           	 	enterRegistrationOnline(expectedEmailAdd,expectedEmailAdd, password[i],"12345678","0207123456","Mobile"
           	 							,"Yes","Yes");
           	 	errorMsgComparison(GlobalErrorMessages.ReFactoring_ReferenceNumberInline_ERROR,"Password");
            } else if (i > 2 & i < 7 ){
	           	 enterRegistrationOnline(expectedEmailAdd,expectedEmailAdd, "12345678",password[i],"0207123456","Mobile"
	           			 				 ,"Yes","Yes");
	           	errorMsgComparison(GlobalErrorMessages.ReFactoring_EMAIL_ERROR,"Retype Password");
            } else if (i == 7) {
	        	 enterRegistrationOnline(expectedEmailAdd,expectedEmailAdd, "12345678",password[i],"0207123456","Mobile"
	        			 				 ,"Yes","Yes");
	        	 errorMsgComparison(GlobalErrorMessages.ReFactoring_ReferenceNumberInline_ERROR,"Retype Password");
            }
        }
      }

//  Validating the Error Message by providing different invalid input combinations for Password and Retype Password
    
   // public void securityErrorMsgValidation(final UserProfile userProfile){
   	 	//final String expectedEmailAdd = new OnlineDBConnector().getUserEmail(userProfile.getUCRN());
        //final String[] securityQuery = {"Please select", "Place of birth", "Name of first pet ", "Name of first school","Make of first car"};
        //final String[] securityAnswer = {"London", "@@@@", "1234", "123@art","as@123"};
        
        //for (int i = 0; i < securityQuery.length; i++) {
             //if (i == 0) {
           	 	//enterRegistrationOnline(expectedEmailAdd,expectedEmailAdd, "12345678","12345678", securityQuery[i],securityAnswer[i],"0207123456",
           	 							//"Mobile","Yes","Yes");
           	 	//errorMsgComparison(GlobalErrorMessages.ReFactoring_EMAIL_ERROR,"Security ");
            //}else if (i > 0) {
           	 	//enterRegistrationOnline(expectedEmailAdd,expectedEmailAdd, "12345678","12345678", securityQuery[i],securityAnswer[i],"0207123456",
           	 							//"Mobile","Yes","Yes");
           	 	//errorMsgComparison(GlobalErrorMessages.ReFactoring_ReferenceNumberInline_ERROR,"Password");
            //}
        //}
    //}

//  Validating the Error Message by providing different invalid input combinations for Phone Number
    
    //public void contactDetailsErrorMsgValidation(final UserProfile userProfile){
   	 	//final String expectedEmailAdd = new OnlineDBConnector().getUserEmail(userProfile.getUCRN());
        //final String[] securityQuery = {"Please select", "Place of birth", "Name of first pet ", "Name of first school","Make of first car"};
        //final String[] securityAnswer = {"","London", "@@@@","123@art","1234","01234"};
        
        //for (int i = 0; i < securityQuery.length; i++) {
             //if (i == 0) {
           	 	//enterRegistrationOnline(expectedEmailAdd,expectedEmailAdd, "12345678","12345678", securityQuery[i],securityAnswer[i],"0207123456",
           	 							//"Mobile","Yes","Yes");
           	 	//errorMsgComparison(GlobalErrorMessages.ReFactoring_ContactDetails_InLineERROR,"Security ");
            //}else if (i > 0 & i < 4) {
           	 	//enterRegistrationOnline(expectedEmailAdd,expectedEmailAdd, "12345678","12345678", securityQuery[i],securityAnswer[i],"0207123456",
           	 							//"Mobile","Yes","Yes");
           	 	//errorMsgComparison(GlobalErrorMessages.ReFactoring_ContactDetails_ERROR,"Password");
            //}else if (i == 4) {
           	 	//enterRegistrationOnline(expectedEmailAdd,expectedEmailAdd, "12345678","12345678", securityQuery[i],securityAnswer[i],"0207123456",
							//"Mobile","Yes","Yes");
           	 	//errorMsgComparison(GlobalErrorMessages.ReFactoring_ContactDetailsCondition_ERROR,"Password");
            //}else if (i == 5) {
           	 	//enterRegistrationOnline(expectedEmailAdd,expectedEmailAdd, "12345678","12345678", securityQuery[i],securityAnswer[i],"0207123456",
							//"Mobile","Yes","Yes");
           	 	//errorMsgComparison(GlobalErrorMessages.ReFactoring_ContactDetailsCondition_InLineERROR,"Password");
            //}
      //}
    //}

// Validating the Error Message for Nectar Details
    
    public void nectarCardErrorMsgValidation(final UserProfile userProfile){
    	final String expectedEmailAdd = new OnlineDBConnector().getUserEmail(userProfile.getUCRN());
    	enterRegistrationOnline(expectedEmailAdd,expectedEmailAdd, "12345678","12345678","0207123456",
								"Mobile","Uncheck Nectar","No");
    	errorMsgComparison(GlobalErrorMessages.ReFactoring_NectarTermsError,"Nectar Terms");
    }
    
// Validating the Error Message for Accept Terms
    
    public void acceptTermsErrorMsgValidation(final UserProfile userProfile){
    	final String expectedEmailAdd = new OnlineDBConnector().getUserEmail(userProfile.getUCRN());
    	enterRegistrationOnline(expectedEmailAdd,expectedEmailAdd, "12345678","12345678","0207123456",
								"Mobile","Yes","No");
    	errorMsgComparison(GlobalErrorMessages.ReFactoring_AcceptTermsError,"Accept Terms");
    }
    
// Enter the appropriate details in the fields displayed in Registration Page
    
    public void enterRegistrationData(final String CustomerNumber, final String CustomerTitle, final String FirstName, final String SurName){
    	verifyAndInputById(regPageProperties.getProperty("RegisterationPage.AccNoText"),"CustomerReferenceNumber",CustomerNumber);
    	verifyAndSelectDropDownBox(regPageProperties.getProperty("RegistrationPage.TitleSelectId"),"Title",CustomerTitle);
    	verifyAndInputById(regPageProperties.getProperty("RegistrationPage.FirstNameTextId"), "FirstName", FirstName);
    	verifyAndInputById(regPageProperties.getProperty("RegistrationPage.LastNameTextId"), "SurName", SurName);
        browser.wait(3000);
        verifyAndClickWithXpath(regPageProperties.getProperty("RegistrationPage.Continue1Button"),"Register Button");
    }

    public void enterInvalidAccountregistration(UserProfile userProfile){
        final String strAccountNum = userProfile.getElecAccount();
    	final String strTitle = new SiebelDataBase().getTitle(userProfile.getUCRN());
    	final String firstName = new SiebelDataBase().getFirstName(userProfile.getUCRN());
        final String lastName = new SiebelDataBase().getLastName(userProfile.getUCRN());
        enterRegistrationData(strAccountNum,strTitle,firstName,lastName);
        browser.wait(4000);
        if(browser.isElementVisible(regPageProperties.getProperty("RegistrationPage.EmailTextId"))){
        	Report.updateTestLog("Customer is able to register", Pass_Str);
        }else{
        Report.updateTestLog("Customer is not able to register", Pass_Str);
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_RegistrationInvalidAccountError);
        }
    }

    public void enterRegistrationOnline(final String EmailAddress, final String ConfirmEmail, final String Pwd, final String RetypePwd,
                                        final String PhoneNumber,final String PhoneType,final String NectarTerms,final String AcceptTerms){
    	verifyAndInputById(regPageProperties.getProperty("RegistrationPage.EmailTextId"),"Email",EmailAddress);
    	verifyAndInputById(regPageProperties.getProperty("RegistrationPage.ConfirmEmailTextId"),"Confirm Email",ConfirmEmail);
    	verifyAndInputById(regPageProperties.getProperty("RegistrationPage.PasswordTextId"),"Password Text",Pwd);
    	verifyAndInputById(regPageProperties.getProperty("RegistrationPage.ConfirmPasswordTextId"),"Confirm Password",RetypePwd);
    	//verifyAndSelectDropDownBox(regPageProperties.getProperty("RegistrationPage.Security_questionSelectId"),"Security",SecurityQuery);
    	//verifyAndInputById(regPageProperties.getProperty("RegistrationPage.Security_answerTextId"),"Security Answer",SecurityAnswer);
    	verifyAndInputById(regPageProperties.getProperty("RegistrationPage.PhoneTextId"),"Phone Number",PhoneNumber);
    	verifyAndSelectDropDownBox(regPageProperties.getProperty("RegistrationPage.PhoneTypeSelectId"),"Phone",PhoneType);
    	if (NectarTerms == "Yes"){ 
    		verifyAndClick(regPageProperties.getProperty("RegistrationPage.AddNectarLaterRadioId"),"Nectar Card");
    		if (browser.isElementVisible(regPageProperties.getProperty("RegistrationPage.NectarTermsCheckBoxId"))){
    			verifyAndSelectCheckBoxByID(regPageProperties.getProperty("RegistrationPage.NectarTermsCheckBoxId"),"Nectar Terms");
    		}
    	}else if (NectarTerms == "No"){ 
    		verifyAndClick(regPageProperties.getProperty("RegistrationPage.NoNectarRadioId"),"Nectar Card");
    		if (browser.isElementVisible(regPageProperties.getProperty("RegistrationPage.NectarTermsCheckBoxId"))){
    			Report.updateTestLog("Nectar Terms Option should not be visible when No Nectar Id is Selected" ,Fail_Str);
    		}else{
    			Report.updateTestLog("Nectar Terms Option is not displayed which is expected" ,Pass_Str);
    		}
    	}else if (NectarTerms == "Uncheck Nectar"){ 
    		verifyAndClick(regPageProperties.getProperty("RegistrationPage.AddNectarLaterRadioId"),"Nectar Card");
    		if (browser.isElementVisible(regPageProperties.getProperty("RegistrationPage.NectarTermsCheckBoxId"))){
    		}
    	}	
    	
    	///if (AcceptTerms == "Yes"){
    		verifyAndSelectCheckBoxByID(regPageProperties.getProperty("RegistrationPage.acceptTermsCheckBoxId"),"Accept Terms");
    	//}else if (AcceptTerms == "Uncheck Nectar"){	
    		//verifyAndSelectCheckBoxByID(regPageProperties.getProperty("RegistrationPage.NectarTermsCheckBoxId"),"Accept Terms");
    	//}	
    	verifyAndClickWithXpath(regPageProperties.getProperty("RegistrationPage.Continue2ButtonXPath"),"Continue");
    }


 // Validating the contents displayed in Why Is This Needed Option Dialog Box and close it
    
    public void validateWhyIsThisNeeded(){
    if (browser.isElementVisibleWithXpath(regPageProperties.getProperty("RegistrationPage.OnlineRegMsg"))) {
        verifyAndClickWithXpath(regPageProperties.getProperty("RegistrationPage.OnlineRegMsg"), "WhereCanIFindID");
        verifyIsTextPresent("We request your telephone number");
        if (browser.isElementVisibleWithXpath(regPageProperties.getProperty("RegistrationPage.CloseButtonID"))) {
            verifyAndClickWithXpath(regPageProperties.getProperty("RegistrationPage.CloseButtonID"), "Close Button");
        }
      }
   }
    
// Capture the error message displayed and verify the actual and error message displayed by making a call to the verifyErrorMessage method   

    public void errorMsgComparison(final String expectedErrorMsg,final String fieldValidation) {
        final String displayedErrorMsg = browser.getTextByXpath(regPageProperties.getProperty("RegistrationPage.ErrorMessageValidationID"));
        verifyErrorMsg(displayedErrorMsg, expectedErrorMsg,fieldValidation);
    }

    
// Validation for Inappropriate data for the fields displayed in Registration Page and compare the error message displayed in the application against 
// the Expected data  	   

     public void verifyErrorMsg(final String displayedErrorMsg, final String expectedErrorMsg, final String fieldValidation) {
         System.out.println("DisplayedErrorMsg is: "+displayedErrorMsg);
         System.out.println("ExpectedErrorMsg is: "+expectedErrorMsg);
         
         if (displayedErrorMsg.trim().contains(expectedErrorMsg.trim())) {
             Report.updateTestLog("Displayed Error Message Validation For "+ fieldValidation + " Is  :" + displayedErrorMsg, Pass_Str);
         } else {
             Report.updateTestLog("Expected Error Message Validation Was Not Displayed For "+ fieldValidation, Fail_Str);
         }
     }
     public void verifyBrowserback(UserProfile userProfile){
         browser.browserBack();
       if (browser.isElementVisible(regPageProperties.getProperty("RegisterationPage.AccNoText"))){
             Report.updateTestLog("Account Number field exists, Browser back working as expected","PASS");
         }else {
             Report.updateTestLog("Account Number field not available, page navigated to back page","FAIL");
       }
        registerAccount(userProfile);
        browser.browserBack();
         if (browser.isElementVisible(regPageProperties.getProperty("RegistrationPage.EmailTextId"))){
             Report.updateTestLog("Email Address field exists,Browser back working as expected","PASS");
         }else {
             Report.updateTestLog("Email Address field not available,page navigated to back page","FAIL");
         }
         new AccountOverviewPage().logout();
     }
     public void verifyAddMissingAccount(UserProfile userProfile){
    	 browser.wait(2000);
         verifyAndClick(regPageProperties.getProperty("RegistrationPage.AddaMissingAcc"),"Add a missing Account");
         browser.wait(2000);
         verifyAndInputById(regPageProperties.getProperty("RegistrationPage.MissingAccntnumber"),"Missing Account Number",userProfile.getAccNumber());
         verifyAndClick(regPageProperties.getProperty("RegistrationPage.FindId"),"Find Button");
         browser.wait(2000);
         verifyAndClick(regPageProperties.getProperty("RegistrationPage.FindId"),"Find Button");
     }
     
     public void verifySecondaryUCRNTable(UserProfile userProfile){
    	 String leadData=new OnlineDBConnector().getPrimaryUCRN(userProfile.getUCRN());
     	 if(!leadData.isEmpty()){    	
     	 Report.updateTestLog("Primary UCRN updated in PO_TA_SECONDARY_UCRN table  :"+leadData, "PASS");
     	 }else{
     		Report.updateTestLog("Primary UCRN not updated in PO_TA_SECONDARY_UCRN table ","FAIL");	 
     	 }
     }
     	public void verifyOAMCustomerTable(UserProfile userProfile){
       	 String leadData=new OnlineDBConnector().getUserEmail(userProfile.getUCRN());
        	 if(!leadData.isEmpty()){    	
        	 Report.updateTestLog("Registered Data updated in PO_TA_OAM_CUSTOMER table  :"+leadData, "PASS");
        	 }else{
        		Report.updateTestLog("Registered Data not updated in PO_TA_OAM_CUSTOMER table","FAIL");	 
        	 }
     }
     public ArrayList<String> openCQ5(){
    	 //browser.open("http://10.224.70.17:9002/etc/centrica-tools/errormessages-maintenance.html"); 
    	 ArrayList<String> a1= verifyCQ5("Account Number");
    	 //browser.close();
    	 browser.browserBack();
    	 browser.browserBack();
    	 System.out.println("Outside For Loop " +a1.get(0));
    	 browser.wait(10000);
    	 System.out.println("Outside For Loop " +a1.get(1));
    	 System.out.println("Outside For Loop " +a1.get(2));
    	 System.out.println("Outside For Loop " +a1.get(3));
    	 System.out.println("Outside For Loop " +a1.get(4));
    	 System.out.println("Outside For Loop " +a1.get(5));
    	 System.out.println("Outside For Loop " +a1.get(6));
    	 System.out.println("Outside For Loop " +a1.get(7));
    	 System.out.println("Outside For Loop " +a1.get(8));
    	 System.out.println("Outside For Loop " +a1.get(9));
    	 return a1;
    	     	 
     }
     
     public ArrayList<String> verifyCQ5(String fieldType){
    	verifyAndInputByXpath(regPageProperties.getProperty("RegistrationPage.CQLoginName"), "FirstName", "admin");
        verifyAndInputByXpath(regPageProperties.getProperty("RegistrationPage.CQLoginPwd"), "LastName","admin");
     	verifyAndClickWithXpath(regPageProperties.getProperty("RegistrationPage.CQOKButton"), "OK");
     	int a = browser.getRowCountByXpath("//form[contains(@action,'errormessageoverrides')]//table");
     	System.out.println("COUNT ROW: "+a);
     	ArrayList<String> a1= new ArrayList<String>();
     	int j =0;
     	//String[] errorcode=GlobalErrorMessages.ReFactoring_CUSTOMER_Reference_ErrorCode;
     	String[] errorcode=GlobalErrorMessages.ReFactoring_CUSTOMER_Reference_ErrorCode;
     	     	
       	loops:
     	for (int i = 0; i < a; i++) {
   		String errorKey = browser.getTextByXpath("//form[contains(@action,'errormessageoverrides')]//table//tbody//tr["+(i+1)+"]//td[1]");
   		int errorCodeSize = errorcode.length; 
   		errorCodeSize = errorCodeSize - 1;
   		     		
   		if (j <= errorCodeSize) {
   			browser.wait(100);
     		if (errorKey.trim().equalsIgnoreCase(errorcode[j])){
    			String errorKey1 = browser.getTextByXpath("//form[contains(@action,'errormessageoverrides')]//table//tbody//tr["+(i+1)+"]//td[2]");
     			System.out.println("ErrorKEYY11 :"+i+" "+errorKey1);
//    			browser.inputByXpath("//form[contains(@action,'errormessageoverrides')]//table//tbody//tr["+i+"]//td[3]/textarea","thanks");
     			a1.add(errorKey1);
     			System.out.println("Inside For Loop " +errorKey);
        		System.out.println("Inside For Loop " +errorcode[j]);
         		j = j+1;
         		i = 0;
            	continue loops;
     		  }
     		}
     	}
    	return a1;
		    
     }
     public void enterPrepaymentAccountregistration(UserProfile userProfile){
         final String strAccountNum = userProfile.getAccNumber();
     	final String strTitle = new SiebelDataBase().getTitle(userProfile.getUCRN());
     	final String firstName = new SiebelDataBase().getFirstName(userProfile.getUCRN());
         final String lastName = new SiebelDataBase().getLastName(userProfile.getUCRN());
         enterRegistrationData(strAccountNum,strTitle,firstName,lastName);
         browser.wait(4000);
         if(browser.isElementVisible(regPageProperties.getProperty("RegistrationPage.EmailTextId"))){
         	Report.updateTestLog("Customer is able to register", Pass_Str);
         }else{
         Report.updateTestLog("Customer is not able to register", Pass_Str);
         verifyIsTextPresent(GlobalErrorMessages.ReFactoring_PrePayment_Error);
         }
     }
}


