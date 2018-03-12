package bg.framework.app.functional.page.selfServe;

import bg.framework.app.functional.common.ApplicationConfig;
import org.openqa.selenium.support.ui.*;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.GlobalErrorMessages;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ContactUsPage extends BasePage {
    private final static String FILE_NAME = "resources/selfServe/ContactUsReFactoring.Properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    public ContactUsPage() {
    }

    public ContactUsPage(UserProfile userProfile) {
   
    }

    public void validateAnonymousErrorMessages(UserProfile userProfile) {
        validateEmptyFields();
        validateTitleError();
        validateFirstNameError();
        validateSurnameError();
        validateAccountNumber();
        validateHouseNumberError();
        validatePostCodeError();
        validateEmailAddressError();
        validatePhoneNumberError();
        validateContactMethod();
    }

    public void validateOAMErrorMessages(UserProfile userProfile) {
        validateOAMEmptyFields();
        validateEmailAddressError();
        validatePhoneNumberError();
        validateContactMethod();
    }

    public void submitForm(UserProfile userprofile,String strType) {
        List<String> enquiryDetails = getCategoryList();
            int iteration=1;
        for (int x = 1; x < enquiryDetails.size(); x++) {
            browser.wait(getWaitTime());
            if(browser.isElementVisible(pageProperties.getProperty("ContactUsPage.contactCategoryID"))){
            //browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.contactCategoryID"), enquiryDetails.get(x));
            	WebElement element = browser.getElementByXpath(pageProperties.getProperty("ContactUsPage.contactCategoryXpath"));
            	element.click();
            	element = browser.getElementByXpath(pageProperties.getProperty("ContactUsPage.contactCategoryXpathOption").replace("CATEGORYCOUNT", (x+1)+""));
            	element.click();
            }
            String cat = enquiryDetails.get(x);
            browser.wait(getWaitTime());
            Boolean a = browser.isElementVisible(pageProperties.getProperty("ContactUsPage.contactReasonID"));
            if (a) {
                List<String> category = browser.getFromDropBox("id", pageProperties.getProperty("ContactUsPage.contactReasonID"));
                for (int y = 1; y < category.size(); y++) {
                    browser.wait(getWaitTime());
                    //browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.contactCategoryID"), enquiryDetails.get(x));
                    WebElement element = browser.getElementByXpath(pageProperties.getProperty("ContactUsPage.contactCategoryXpath"));
                	element.click();
                	element = browser.getElementByXpath(pageProperties.getProperty("ContactUsPage.contactCategoryXpathOption").replace("CATEGORYCOUNT", (x+1)+""));
                	element.click();
                	
                	
                    browser.wait(getWaitTime());
                    //browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.contactReasonID"), category.get(y));
                    WebElement element1 = browser.getElementByXpath(pageProperties.getProperty("ContactUsPage.contactReasonXpath"));
                	element.click();
                	element = browser.getElementByXpath(pageProperties.getProperty("ContactUsPage.contactReasonXpathOptions").replace("CATEGORYCOUNT", (y+1)+""));
                	element.click();
                    
                    Report.updateTestLog("*********** Iteration  : '" + iteration + "' Started ***********", "Done");
                    Report.updateTestLog("Category  : " + cat, "Done");
                    String reas = category.get(y);
                    Report.updateTestLog("Reason    : " + reas, "Done");
                    //validateOverlay(cat + "," + reas,strType);
                    anonymousSubmitForm(userprofile,strType);
                    browser.wait(getWaitTime());
                    ContactUsConfPage confirmationPage = new ContactUsConfPage();
                    confirmationPage.VerifyContactUsConfirmationPage(userprofile, cat + "," + reas);
                    browser.wait(getWaitTime());
                    confirmationPage.navigateToContactUsPage();
                    iteration=iteration+1;
                }
            } else {
                Report.updateTestLog("*********** Iteration  : '" + iteration + "' Started ***********", "");
                Report.updateTestLog("Category  : " + cat, "Done");
                anonymousSubmitForm(userprofile,strType);
                browser.wait(getWaitTime());
                ContactUsConfPage confirmationPage = new ContactUsConfPage();
                confirmationPage.VerifyContactUsConfirmationPage(userprofile, cat);
                browser.wait(getWaitTime());
                confirmationPage.navigateToContactUsPage();
             iteration=iteration+1;
            }
            // Report.updateTestLog("******** Iteration :,"Done");
        }
        browser.wait(getWaitTime());
       /* ContactUsConfPage confirmationPage = new ContactUsConfPage();
        confirmationPage.runAutoCefBatch();*/
    }

    private List<String> getCategoryList() {
        return browser.getFromDropBox("id", pageProperties.getProperty("ContactUsPage.contactCategoryID"));
    }
    
    
    public void contactuspageValidation(){
    	//Emergency page link validation
    	//verifyAndClickWithXpath(pageProperties.getProperty("ContactUsPage.EmergencyNumbers"), "Emergency Numbers Link");
    	browser.wait(getWaitTime());
    	verifyAndClickWithLinkText("Emergency numbers","Emergency Numbers Link" );
    	Report.updateTestLog("Emergency numbers page ",browser.getTextByXpath(pageProperties.getProperty("ContactUsPage.Header")).contains("Emergency")? "Pass" : "Fail" );
    	browser.browserBack();
    	
    	//Contact telephone numbers page link validation
    	//verifyAndClickWithXpath(pageProperties.getProperty("ContactUsPage.ContactTelephone"), "ContactTelephone Link");
    	browser.wait(getWaitTime());
    	verifyAndClickWithLinkText("Contact telephone numbers","ContactTelephone Link" );
    	Report.updateTestLog("Contact telephone numbers",browser.getTextByXpath(pageProperties.getProperty("ContactUsPage.Header")).contains("telephone")? "Pass" : "Fail" );
    	browser.browserBack();
    	
    	//DID WE Call page link validation
    	browser.wait(getWaitTime());
    	verifyAndClickWithXpath(pageProperties.getProperty("ContactUsPage.Didwecallyou"), "Didwecallyou Link");
    	Report.updateTestLog("Didwecallyou ",browser.getTextByXpath(pageProperties.getProperty("ContactUsPage.Header")).contains("Did")? "Pass" : "Fail" );
    	browser.browserBack();
    	
    	//Make Complaint page link validation
    	browser.wait(getWaitTime());
    	verifyAndClickWithXpath(pageProperties.getProperty("ContactUsPage.MakeComplaint"), "MakeComplaint Link");
    	Report.updateTestLog("Make Complaint",browser.getTextByXpath(pageProperties.getProperty("ContactUsPage.Header")).contains("complaints")? "Pass" : "Fail" );
    	browser.browserBack();
    	
    	//Complaint Performance page link validation
    	browser.wait(getWaitTime());
    	verifyAndClickWithXpath(pageProperties.getProperty("ContactUsPage.ComplaintsPerformance"), "ComplaintsPerformance Link");
    	Report.updateTestLog("Complaints Performance",browser.getTextByXpath(pageProperties.getProperty("ContactUsPage.Header")).contains("Complaints")? "Pass" : "Fail" );
    	browser.browserBack();
    }

    private void anonymousSubmitForm(UserProfile userprofile,String strType) {
        browser.clearValue(pageProperties.getProperty("ContactUsPage.contactQuery"));
        String test ="just testing" ;
        		
        browser.input(pageProperties.getProperty("ContactUsPage.contactQuery"), test);
        int count = test.length();
        Report.updateTestLog("Tell Us More    ::"+count+" Characters entered", "PASS");
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ContactUsPage.title"))) {
        	WebElement element = browser.getElementByXpath(pageProperties.getProperty("ContactUsPage.title"));
        	element.click();
        	browser.wait(5000);
        	element = browser.getElementByXpath(pageProperties.getProperty("ContactUsPage.titleOption"));
        	element.click();
        	browser.wait(5000);
        	
            //browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.title"), userprofile.getTitle());
            Report.updateTestLog(userprofile.getTitle() + " Title Selected", "DONE");
        } else {
            //Report.updateTestLog("Title Not Selected", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.firstName"))) {
            browser.clearValue(pageProperties.getProperty("ContactUsPage.firstName"));
            browser.input(pageProperties.getProperty("ContactUsPage.firstName"), userprofile.getFirstName());
            Report.updateTestLog(userprofile.getFirstName() + " First Name Entered", "DONE");
        } else {
            //Report.updateTestLog("First Name Not Entered", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.lastName"))) {
            browser.clearValue(pageProperties.getProperty("ContactUsPage.lastName"));
            browser.input(pageProperties.getProperty("ContactUsPage.lastName"), userprofile.getLastName());
            Report.updateTestLog(userprofile.getLastName() + " Last Name Entered", "DONE");
        } else {
            //Report.updateTestLog("Last Name Not Entered", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.houseNumber"))) {
            browser.clearValue(pageProperties.getProperty("ContactUsPage.houseNumber"));
            browser.input(pageProperties.getProperty("ContactUsPage.houseNumber"),"12");
            Report.updateTestLog(userprofile.getHomeNumber() + " Home Number Entered", "DONE");
        } else {
            //Report.updateTestLog("Home Number Not Entered", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.postcode"))) {
            browser.clearValue(pageProperties.getProperty("ContactUsPage.postcode"));
            browser.input(pageProperties.getProperty("ContactUsPage.postcode"), "sw9 9lw");
            Report.updateTestLog("sw9 9lw PostCode Entered", "DONE");
        } else {
            //Report.updateTestLog("PostCode Not Entered", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.emailAddress"))) {
            browser.clearValue(pageProperties.getProperty("ContactUsPage.emailAddress"));
            browser.input(pageProperties.getProperty("ContactUsPage.emailAddress"), userprofile.getEmail());
            Report.updateTestLog(userprofile.getEmail() + " Email Address Entered", "DONE");
        } else {
            //Report.updateTestLog("Email Address Not Entered", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.confirmemailAddress"))) {
            browser.clearValue(pageProperties.getProperty("ContactUsPage.confirmemailAddress"));
            browser.input(pageProperties.getProperty("ContactUsPage.confirmemailAddress"), userprofile.getEmail());
            Report.updateTestLog(userprofile.getEmail() + " Confirm Email Address Entered", "DONE");
        } 
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.telephoneNumber"))) {
            browser.clearValue(pageProperties.getProperty("ContactUsPage.telephoneNumber"));
            browser.input(pageProperties.getProperty("ContactUsPage.telephoneNumber"), userprofile.getPhoneNumber());
            Report.updateTestLog(userprofile.getMobileNumber() + " TelePhone Number Entered", "DONE");
        } else {
            //Report.updateTestLog("TelePhone Number Not Entered", "FAIL");
        }      
        	if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ContactUsPage.InternationaltelephoneNumberlink"))) {
        	System.out.println("International phone number link enters");
        	browser.wait(3000);
        	browser.clickWithXpath(pageProperties.getProperty("ContactUsPage.InternationaltelephoneNumberlink"));
        	Report.updateTestLog(" International TelePhone Number Link Clicked", "PASS");
            browser.clearValue(pageProperties.getProperty("ContactUsPage.InternationaltelephoneNumber"));
            browser.input(pageProperties.getProperty("ContactUsPage.InternationaltelephoneNumber"), "wdfwfwf1232132134");
            Report.updateTestLog(" International TelePhone Number not Entered", "WARN");
            }       	
        	else {
            browser.clickWithXpath(pageProperties.getProperty("ContactUsPage.SEInternationaltelephoneNumberlink"));
        	Report.updateTestLog(" International TelePhone Number Link Clicked", "PASS");
            browser.clearValue(pageProperties.getProperty("ContactUsPage.InternationaltelephoneNumber"));
            browser.input(pageProperties.getProperty("ContactUsPage.InternationaltelephoneNumber"), "wdfwfwf1232132134");
            Report.updateTestLog(" wdfwfwf1232132134 International TelePhone Number Entered", "WARN");
    	}
        //} //else {
            //Report.updateTestLog("International TelePhone Number Not Entered", "FAIL");
        //}
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.smsContactPreference"))) {
        if (!browser.isSelected(pageProperties.getProperty("ContactUsPage.smsContactPreference"))) {
            browser.click(pageProperties.getProperty("ContactUsPage.smsContactPreference"));
            Report.updateTestLog(" SMS contact Preference selected", "PASS");
        }
        }
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.telephoneContactPreference"))) {
        if (!browser.isSelected(pageProperties.getProperty("ContactUsPage.telephoneContactPreference"))) {
            browser.click(pageProperties.getProperty("ContactUsPage.telephoneContactPreference"));
            Report.updateTestLog(" Telephone contact Preference selected", "PASS");
        }
        }
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.emailContactPreference"))) {
        if (!browser.isSelected(pageProperties.getProperty("ContactUsPage.emailContactPreference"))) {
            browser.click(pageProperties.getProperty("ContactUsPage.emailContactPreference"));
            Report.updateTestLog(" Email contact Preference selected", "PASS");
        }else {
        	Report.updateTestLog(" Email contact Preference selected default", "PASS");
        }
        }
        //Sprint 08 changes updated
        if(strType.equalsIgnoreCase("OAM")){
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ContactUsPage.MultipleAccount"))) {
        	/*Select CustomerReferenceElement = new Select(browser.getElementByXpath(pageProperties.getProperty("ContactUsPage.MultipleAccount")));
        	CustomerReferenceElement.selectByIndex(1);*/
        	WebElement element = browser.getElementByXpath(pageProperties.getProperty("ContactUsPage.MultipleAccount"));
        	element.click();
        	element = browser.getElementByXpath(pageProperties.getProperty("ContactUsPage.MultipleAccountOption"));
        	element.click();
        	Report.updateTestLog(userprofile.getAccNumber() + " Account Number Selected", "DONE");
        } 
        else{
        	Report.updateTestLog("Single account present", "Pass");
        }
        }
        
        
        verifyAndClick(pageProperties.getProperty("ContactUsPage.sendButton"), "Send Button");
        browser.wait(getWaitTime());
    }

    private void validateTitleError() {
        Report.updateTestLog("Validation Starts for Title Field", "DONE");

        browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.contactCategoryID"), "Gas/Electricity enquiries");
        browser.wait(getWaitTime());
        browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.contactReasonID"), "Refunds");
        verifyAndInputById(pageProperties.getProperty("ContactUsPage.contactQuery"), "Contact Us Query", "Just Testing");

        verifyAndInputById(pageProperties.getProperty("ContactUsPage.firstName"), "First Name", "test");
        verifyAndInputById(pageProperties.getProperty("ContactUsPage.lastName"), "Last Name", "test");
        verifyAndInputById(pageProperties.getProperty("ContactUsPage.houseNumber"), "House Number", "74");
        verifyAndInputById(pageProperties.getProperty("ContactUsPage.postcode"), "House Number", "se23 1ln");
        verifyAndInputById(pageProperties.getProperty("ContactUsPage.emailAddress"), "Email Address", "test@bgdigitaltest.com");
        verifyAndInputById(pageProperties.getProperty("ContactUsPage.telephoneNumber"), "Telephone Number", "0123456789");
        verifyAndSelectCheckBoxByID(pageProperties.getProperty("ContactUsPage.smsContactPreference"), "SMS Contact Preference");
        verifyAndSelectCheckBoxByID(pageProperties.getProperty("ContactUsPage.telephoneContactPreference"), "Telephone Contact Preference");
        verifyAndSelectCheckBoxByID(pageProperties.getProperty("ContactUsPage.emailContactPreference"), "Email Contact Preference");
        verifyAndClick(pageProperties.getProperty("ContactUsPage.sendButton"), "Contact Us Send Button");
        browser.wait(getWaitTime());
        //verifyIsElementVisibleWithXpath(pageProperties.getProperty("ContactUsPage.ErrorField"),"Title Field Validation Error Message ");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ErrorMSGHeader, "Error Message Header");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ErrorMSGSubHeader, "Error Message Sub Header");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_TITLE_ERROR, "Error Message for Title Field");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_TITLE_InLineERROR, "In Line Error Message for Title Field");
        Report.updateTestLog("Validation Ends for Title Field", "DONE");
    }

    private void validateFirstNameError() {
        String[] arrFristName;
        arrFristName = new String[3];
        arrFristName[0] = "";
        arrFristName[1] = "test#@12323";
        arrFristName[2] = "*&&@#$%";
        String error;
        Report.updateTestLog("Validation Starts for First name Field", "DONE");
        for (int i = 0; i < 3; i++) {
            browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.contactCategoryID"), "Gas/Electricity enquiries");
            browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.contactReasonID"), "Refunds");
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.contactQuery"), "Contact Us Query", "Just Testing");
            if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.title"))) {
                browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.title"), "Mr");
                Report.updateTestLog("Mr Title Selected", "DONE");
            } 
            if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.firstName"))) {
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.firstName"), "First Name", arrFristName[i]);
            }
            if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.lastName"))) {
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.lastName"), "Last Name", "test");
            }
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.houseNumber"), "House Number", "74");
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.postcode"), "House Number", "se23 1ln");
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.emailAddress"), "Email Address", "test@bgdigitaltest.com");
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.telephoneNumber"), "Telephone Number", "0123456789");
            verifyAndSelectCheckBoxByID(pageProperties.getProperty("ContactUsPage.smsContactPreference"), "SMS Contact Preference");
            verifyAndSelectCheckBoxByID(pageProperties.getProperty("ContactUsPage.telephoneContactPreference"), "Telephone Contact Preference");
            verifyAndSelectCheckBoxByID(pageProperties.getProperty("ContactUsPage.emailContactPreference"), "Email Contact Preference");
            verifyAndClick(pageProperties.getProperty("ContactUsPage.sendButton"), "Contact Us Send Button");
            verifyIsElementVisibleWithXpath(pageProperties.getProperty("ContactUsPage.ErrorField"), "First Name Field Validation Error Message ");
            verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ErrorMSGHeader, "Error Message Header");
            verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ErrorMSGSubHeader, "Error Message Sub Header");
            if (i == 0) {
                verifyIsTextPresent(GlobalErrorMessages.ReFactoring_FIRSTNAME_InLineERROR, "In Line Error Message for First Name Field");
                verifyIsTextPresent(GlobalErrorMessages.ReFactoring_FIRSTNAME_ERROR, "Error Message for FirstName Field");
            } else {
                verifyIsTextPresent(GlobalErrorMessages.ReFactoring_FIRSTNAMECondition_ERROR, "Error Message for FirstName Field");
                verifyIsTextPresent(GlobalErrorMessages.ReFactoring_FIRSTNAMECondition_InLineERROR, "In Line Error Message for First Name Field");
            }
        }
        Report.updateTestLog("Validation Ends for First Name Field", "DONE");
    }

    private void validateSurnameError() {
        String[] arrSurName;
        arrSurName = new String[3];
        arrSurName[0] = "";
        arrSurName[1] = "test12323";
        arrSurName[2] = "test@#@#@$";
        String error;
        Report.updateTestLog("Validation Starts for Sur name Field", "DONE");
        for (int i = 0; i < 3; i++) {

            browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.contactCategoryID"), "Gas/Electricity enquiries");
            browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.contactReasonID"), "Make a complaint");
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.contactQuery"), "Contact Us Query", "Just Testing");
            if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.title"))) {
                browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.title"), "Mr");
                Report.updateTestLog("Mr Title Selected", "DONE");
            } 
            if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.firstName"))) {
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.firstName"), "First Name", "Tester");
            }
            if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.lastName"))) {
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.lastName"), "Last Name", arrSurName[i]);
            }
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.houseNumber"), "House Number", "74");
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.postcode"), "House Number", "se23 1ln");
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.emailAddress"), "Email Address", "test@bgdigitaltest.com");
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.telephoneNumber"), "Telephone Number", "0123456789");
            verifyAndSelectCheckBoxByID(pageProperties.getProperty("ContactUsPage.smsContactPreference"), "SMS Contact Preference");
            verifyAndSelectCheckBoxByID(pageProperties.getProperty("ContactUsPage.telephoneContactPreference"), "Telephone Contact Preference");
            verifyAndSelectCheckBoxByID(pageProperties.getProperty("ContactUsPage.emailContactPreference"), "Email Contact Preference");
            verifyAndClick(pageProperties.getProperty("ContactUsPage.sendButton"), "Contact Us Send Button");

            /*if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ContactUsPage.ErrorField"))) {
            error = browser.getTextByXpath(pageProperties.getProperty("ContactUsPage.ErrorField"));
            Report.updateTestLog("Special characters LastName Field Validation  :" + error, "PASS");
            } else {
            Report.updateTestLog("Special characters LastName Field Validation", "FAIL");
            }*/
            verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ErrorMSGHeader, "Error Message Header");
            verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ErrorMSGSubHeader, "Error Message Sub Header");
            if (i == 0) {
                verifyIsTextPresent(GlobalErrorMessages.ReFactoring_LASTNAME_ERROR, "Error Message for LastName Field");
                verifyIsTextPresent(GlobalErrorMessages.ReFactoring_LASTNAME_InLineERROR, "In Line Error Message for Last Name");
            } else {
                verifyIsTextPresent(GlobalErrorMessages.ReFactoring_LASTNAMECondition_ERROR, "Error Message for LastName Field");
                verifyIsTextPresent(GlobalErrorMessages.ReFactoring_LASTNAMECondition_InLineERROR, "In Line Error Message for Last Name");
            }

        }
        Report.updateTestLog("Validation Ends for Sur name Field", "DONE");
    }

    private void validateAccountNumber() {

        String[] getAccNumber;
        getAccNumber = new String[7];
        getAccNumber[0] = "85qw1221";
        getAccNumber[1] = "85#@1212";
        getAccNumber[2] = "qwerty";
        getAccNumber[3] = "850000000";
        getAccNumber[4] = "850000";
        getAccNumber[5] = "0012468794";
        getAccNumber[6] = "85000012121212";
        Report.updateTestLog("Validation Starts for Account Number Field", "DONE");
        for (int i = 0; i < 6; i++) {
            browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.contactCategoryID"), "Gas/Electricity enquiries");
            browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.contactReasonID"), "Refunds");
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.contactQuery"), "Contact Us Query", "Just Testing");
            if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.title"))) {
                browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.title"), "Mr");
                Report.updateTestLog("Mr Title Selected", "DONE");
            } 
            if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.firstName"))) {
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.firstName"), "First Name", "Tester");
            }
            if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.lastName"))) {
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.lastName"), "Last Name", "test");
            }
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.accountNumber"), "Account Number ", getAccNumber[i]);

            verifyAndInputById(pageProperties.getProperty("ContactUsPage.houseNumber"), "House Number", "74");
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.postcode"), "House Number", "se23 1ln");
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.emailAddress"), "Email Address", "test@bgdigitaltest.com");
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.telephoneNumber"), "Telephone Number", "0123456789");
            verifyAndSelectCheckBoxByID(pageProperties.getProperty("ContactUsPage.smsContactPreference"), "SMS Contact Preference");
            verifyAndSelectCheckBoxByID(pageProperties.getProperty("ContactUsPage.telephoneContactPreference"), "Telephone Contact Preference");
            verifyAndSelectCheckBoxByID(pageProperties.getProperty("ContactUsPage.emailContactPreference"), "Email Contact Preference");
            verifyAndClick(pageProperties.getProperty("ContactUsPage.sendButton"), "Contact Us Send Button");

            verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ErrorMSGHeader, "Error Message Header");
            verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ErrorMSGSubHeader, "Error Message Sub Header");
            verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ReferenceNumber_ERROR, "Error Message for Customer Reference Field");
            verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ReferenceNumberInline_ERROR, "In Line Error Message for Customer Reference");
        }
        Report.updateTestLog("Validation Ends for Account Number field", "DONE");
    }

    private void validateHouseNumberError() {
        String[] arrHouseNum;
        arrHouseNum = new String[2];
        arrHouseNum[0] = "";
        arrHouseNum[1] = "@#$";
        Report.updateTestLog("Validation Starts for House No/Name  Field", "DONE");
        for (int i = 0; i < 2; i++) {
            browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.contactCategoryID"), "Gas/Electricity enquiries");
            browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.contactReasonID"), "Refunds");
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.contactQuery"), "Contact Us Query", "Just Testing");
            if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.title"))) {
                browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.title"), "Mr");
                Report.updateTestLog("Mr Title Selected", "DONE");
            } 
            if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.firstName"))) {
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.firstName"), "First Name", "Tester");
            }
            if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.lastName"))) {
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.lastName"), "Last Name", "test");
            }
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.houseNumber"), "House Number", arrHouseNum[i]);
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.postcode"), "House Number", "se23 1ln");
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.emailAddress"), "Email Address", "test@bgdigitaltest.com");
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.telephoneNumber"), "Telephone Number", "0123456789");
            verifyAndSelectCheckBoxByID(pageProperties.getProperty("ContactUsPage.smsContactPreference"), "SMS Contact Preference");
            verifyAndSelectCheckBoxByID(pageProperties.getProperty("ContactUsPage.telephoneContactPreference"), "Telephone Contact Preference");
            verifyAndSelectCheckBoxByID(pageProperties.getProperty("ContactUsPage.emailContactPreference"), "Email Contact Preference");
            verifyAndClick(pageProperties.getProperty("ContactUsPage.sendButton"), "Contact Us Send Button");

            verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ErrorMSGHeader, "Error Message Header");
            verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ErrorMSGSubHeader, "Error Message Sub Header");
            if (i == 0) {
                verifyIsTextPresent(GlobalErrorMessages.ReFactoring_HOUSE_ERROR, "Error Message for House No/Name Field");
                verifyIsTextPresent(GlobalErrorMessages.ReFactoring_HOUSE_InLineERROR, "In Line Error Message for House No/Name");
            } else {
                verifyIsTextPresent(GlobalErrorMessages.ReFactoring_HOUSECondition_ERROR, "Error Message for House No/Name Field");
                verifyIsTextPresent(GlobalErrorMessages.ReFactoring_HOUSECondition_InLineERROR, "In Line Error Message for House No/Name");
            }


        }
        Report.updateTestLog("Validation Ends for House No/Name Field", "DONE");
    }

    private void validatePostCodeError() {
        String[] arrPostCode;
        arrPostCode = new String[2];
        arrPostCode[0] = "";
        arrPostCode[1] = "@#$";
        Report.updateTestLog("Validation Starts for Postcode Field", "DONE");
        for (int i = 0; i < 2; i++) {
            browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.contactCategoryID"), "Gas/Electricity enquiries");
            browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.contactReasonID"), "Refunds");
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.contactQuery"), "Contact Us Query", "Just Testing");
            if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.title"))) {
                browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.title"), "Mr");
                Report.updateTestLog("Mr Title Selected", "DONE");
            } 
            if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.firstName"))) {
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.firstName"), "First Name", "Tester");
            }
            if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.lastName"))) {
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.lastName"), "Last Name", "test");
            }
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.firstName"), "First Name", "Tester");
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.lastName"), "Last Name", "test");
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.houseNumber"), "House Number", "74");
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.postcode"), "House Number", arrPostCode[i]);
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.emailAddress"), "Email Address", "test@bgdigitaltest.com");
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.telephoneNumber"), "Telephone Number", "0123456789");
            verifyAndSelectCheckBoxByID(pageProperties.getProperty("ContactUsPage.smsContactPreference"), "SMS Contact Preference");
            verifyAndSelectCheckBoxByID(pageProperties.getProperty("ContactUsPage.telephoneContactPreference"), "Telephone Contact Preference");
            verifyAndSelectCheckBoxByID(pageProperties.getProperty("ContactUsPage.emailContactPreference"), "Email Contact Preference");
            verifyAndClick(pageProperties.getProperty("ContactUsPage.sendButton"), "Contact Us Send Button");

            verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ErrorMSGHeader, "Error Message Header");
            verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ErrorMSGSubHeader, "Error Message Sub Header");
            if (i == 0) {
                verifyIsTextPresent(GlobalErrorMessages.ReFactoring_POSTCODE_ERROR, "Error Message for Post Code Field");
                verifyIsTextPresent(GlobalErrorMessages.ReFactoring_POSTCODE_InLineERROR, "In Line Error Message for Post Code");
            } else {
                verifyIsTextPresent(GlobalErrorMessages.ReFactoring_POSTCODECondition_ERROR, "Error Message for Post Code Field");
                verifyIsTextPresent(GlobalErrorMessages.ReFactoring_POSTCODECondition_InLineERROR, "In Line Error Message for Post Code");
            }
        }
        Report.updateTestLog("Validation Ends for Postcode Field", "DONE");
    }

    private void validateEmailAddressError() {
        String[] arrEmailID;
        arrEmailID = new String[3];
        arrEmailID[0] = "";
        arrEmailID[1] = "sgdg@sdvsdv@vszv";
        arrEmailID[2] = "!@*&$##!@123123";
        Report.updateTestLog("Validation Starts for Email Address Field", "DONE");
        for (int i = 0; i < 3; i++) {
            browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.contactCategoryID"), "Gas/Electricity enquiries");
            browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.contactReasonID"), "Refunds");
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.contactQuery"), "Contact Us Query", "Just Testing");
            if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.title"))) {
                browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.title"), "Mr");
                Report.updateTestLog("Mr Title Selected", "DONE");
            } 
            if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.firstName"))) {
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.firstName"), "First Name", "Tester");
            }
            if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.lastName"))) {
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.lastName"), "Last Name", "test");
            }
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.houseNumber"), "House Number", "74");
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.postcode"), "House Number", "tw46el");
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.emailAddress"), "Email Address", arrEmailID[i]);
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.telephoneNumber"), "Telephone Number", "0123456789");
            verifyAndSelectCheckBoxByID(pageProperties.getProperty("ContactUsPage.smsContactPreference"), "SMS Contact Preference");
            verifyAndSelectCheckBoxByID(pageProperties.getProperty("ContactUsPage.telephoneContactPreference"), "Telephone Contact Preference");
            verifyAndSelectCheckBoxByID(pageProperties.getProperty("ContactUsPage.emailContactPreference"), "Email Contact Preference");
            verifyAndClick(pageProperties.getProperty("ContactUsPage.sendButton"), "Contact Us Send Button");

            verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ErrorMSGHeader, "Error Message Header");
            verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ErrorMSGSubHeader, "Error Message Sub Header");

            verifyIsTextPresent(GlobalErrorMessages.ReFactoring_EMAIL_ERROR, "Error Message for Email Address Field");
            verifyIsTextPresent(GlobalErrorMessages.ReFactoring_EMAIL_InLineERROR, "In Line Error Message for  Email Address");

        }
        Report.updateTestLog("Validation Ends for Email Address Field", "DONE");
    }

    private void validatePhoneNumberError() {

        String[] getPhoneNumber;
        getPhoneNumber = new String[4];

        getPhoneNumber[0] = "";
        getPhoneNumber[1] = "123456789";
        getPhoneNumber[2] = "!@#$%^";
        getPhoneNumber[3] = "asdfvc";
        Report.updateTestLog("Validation Starts for Phone Number Field", "DONE");
        for (int i = 0; i < 4; i++) {
            browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.contactCategoryID"), "Gas/Electricity enquiries");
            browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.contactReasonID"), "Refunds");
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.contactQuery"), "Contact Us Query", "Just Testing");
            if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.title"))) {
                browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.title"), "Mr");
                Report.updateTestLog("Mr Title Selected", "DONE");
            } 
            if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.firstName"))) {
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.firstName"), "First Name", "Tester");
            }
            if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.lastName"))) {
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.lastName"), "Last Name", "test");
            }
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.houseNumber"), "House Number", "74");
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.postcode"), "House Number", "tw46el");
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.emailAddress"), "Email Address", "Test@centrica.com");
            verifyAndInputById(pageProperties.getProperty("ContactUsPage.telephoneNumber"), "Telephone Number", getPhoneNumber[i]);
            verifyAndSelectCheckBoxByID(pageProperties.getProperty("ContactUsPage.smsContactPreference"), "SMS Contact Preference");
            verifyAndSelectCheckBoxByID(pageProperties.getProperty("ContactUsPage.telephoneContactPreference"), "Telephone Contact Preference");
            verifyAndSelectCheckBoxByID(pageProperties.getProperty("ContactUsPage.emailContactPreference"), "Email Contact Preference");
            verifyAndClick(pageProperties.getProperty("ContactUsPage.sendButton"), "Contact Us Send Button");

            verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ErrorMSGHeader, "Error Message Header");
            verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ErrorMSGSubHeader, "Error Message Sub Header");

            if (i == 0) {
                verifyIsTextPresent(GlobalErrorMessages.ReFactoring_TELEPHONE_ERROR, "Error Message for Phone Number Field");
                verifyIsTextPresent(GlobalErrorMessages.ReFactoring_TELEPHONE_InLineERROR, "In Line Error Message for Phone Number");
            } else {
                verifyIsTextPresent(GlobalErrorMessages.ReFactoring_TELEPHONECondition_ERROR, "Error Message for Phone Number Field");
                verifyIsTextPresent(GlobalErrorMessages.ReFactoring_TELEPHONECondition_InLineERROR, "In Line Error Message for Phone Number");
            }

        }
        Report.updateTestLog("Validation Ends for Phone Number Field", "DONE");
    }

    private void validateContactMethod() {
        browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.contactCategoryID"), "Gas/Electricity enquiries");
        browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.contactReasonID"), "Refunds");
        verifyAndInputById(pageProperties.getProperty("ContactUsPage.contactQuery"), "Contact Us Query", "Just Testing");
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.title"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.title"), "Mr");
            Report.updateTestLog("Mr Title Selected", "DONE");
        } 
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.firstName"))) {
        verifyAndInputById(pageProperties.getProperty("ContactUsPage.firstName"), "First Name", "Tester");
        }
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.lastName"))) {
        verifyAndInputById(pageProperties.getProperty("ContactUsPage.lastName"), "Last Name", "test");
        }
        verifyAndInputById(pageProperties.getProperty("ContactUsPage.houseNumber"), "House Number", "74");
        verifyAndInputById(pageProperties.getProperty("ContactUsPage.postcode"), "House Number", "tw46el");
        verifyAndInputById(pageProperties.getProperty("ContactUsPage.emailAddress"), "Email Address", "Test@centrica.com");
        verifyAndInputById(pageProperties.getProperty("ContactUsPage.telephoneNumber"), "Telephone Number", "0123456789");
        if (browser.isSelected(pageProperties.getProperty("ContactUsPage.smsContactPreference"))) {
            browser.click(pageProperties.getProperty("ContactUsPage.smsContactPreference"));
        }
        if (browser.isSelected(pageProperties.getProperty("ContactUsPage.telephoneContactPreference"))) {
            browser.click(pageProperties.getProperty("ContactUsPage.telephoneContactPreference"));
        }
        if (browser.isSelected(pageProperties.getProperty("ContactUsPage.emailContactPreference"))) {
            browser.click(pageProperties.getProperty("ContactUsPage.emailContactPreference"));
        }
        verifyAndClick(pageProperties.getProperty("ContactUsPage.sendButton"), "Contact Us Send Button");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ErrorMSGHeader, "Error Message Header");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ErrorMSGSubHeader, "Error Message Sub Header");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ContactMethod_ERROR, "Error Message for Phone Number Field");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ContactMethodInline_ERROR, "In Line Error Message for Phone Number");
        browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.contactReasonID"), "Refunds");
        verifyAndInputById(pageProperties.getProperty("ContactUsPage.contactQuery"), "Contact Us Query", "Just Testing");
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.title"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.title"), "Mr");
            Report.updateTestLog("Mr Title Selected", "DONE");
        } 
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.firstName"))) {
        verifyAndInputById(pageProperties.getProperty("ContactUsPage.firstName"), "First Name", "Tester");
        }
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.lastName"))) {
        verifyAndInputById(pageProperties.getProperty("ContactUsPage.lastName"), "Last Name", "test");
        }
        verifyAndInputById(pageProperties.getProperty("ContactUsPage.houseNumber"), "House Number", "74");
        verifyAndInputById(pageProperties.getProperty("ContactUsPage.postcode"), "House Number", "tw46el");
        verifyAndInputById(pageProperties.getProperty("ContactUsPage.emailAddress"), "Email Address", "Test@centrica.com");
        verifyAndInputById(pageProperties.getProperty("ContactUsPage.telephoneNumber"), "Telephone Number", "0123456789");
        if (browser.isSelected(pageProperties.getProperty("ContactUsPage.smsContactPreference"))) {
            browser.click(pageProperties.getProperty("ContactUsPage.smsContactPreference"));
        }
        if (browser.isSelected(pageProperties.getProperty("ContactUsPage.telephoneContactPreference"))) {
            browser.click(pageProperties.getProperty("ContactUsPage.telephoneContactPreference"));
        }
        if (browser.isSelected(pageProperties.getProperty("ContactUsPage.emailContactPreference"))) {
            browser.click(pageProperties.getProperty("ContactUsPage.emailContactPreference"));
        }
        verifyAndClick(pageProperties.getProperty("ContactUsPage.sendButton"), "Contact Us Send Button");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ErrorMSGHeader, "Error Message Header");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ErrorMSGSubHeader, "Error Message Sub Header");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ContactMethod_ERROR, "Error Message for Phone Number Field");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ContactMethodInline_ERROR, "In Line Error Message for Phone Number");
    }

    private String[] getProdCategory(String BrandName) {
        if (BrandName.equalsIgnoreCase("BG")) {
            String[] categoryList = {"Please Select", "Gas/Electricity Enquiries", "Homecare/Engineer enquiries", "Boiler/Central heating installations", "Moving home or changing names(s)", "I want to join/have recently joined", "Pay as you go energy", "Website/Online account"};
            return categoryList;
        } else {
            String[] categoryList = {"Please Select", "Gas/Electricity Enquiries", "Moving home or changing name/s", "I want to join / recently joined", "Solar power", "Home insulation", "Website / online account", "Boiler / central heating installations"};
            return categoryList;
        }
    }

    private String[] getProdReason(int category, String BrandName) {
        if (BrandName.equalsIgnoreCase("BG")) {
            String[] category1 = {"Please Select", "Direct debit/Payment scheme", "Tariff/prices", "Bill enquiry/Meter reading", "Refunds", "Update my email/telephone number", "Other", "Make a complaint"};
            String[] category2 = {"Please Select", "Upgrade my agreement", "Amend or cancel an existing appointment", "Billing and payment enquiries", "Book an engineer or annual service", "Query on recent visit", "Make a complaint", "Other"};
            String[] category3 = {"Please Select", "Sales appointment/quotation queries", "Installation appointments", "Make a complaint", "Other"};
            String[] category6 = {"Please Select", "Gas Prepayment", "Electricity Prepayment", "Dual Fuel Prepayment", "Make a complaint"};
            String[] category4 = {};
            String[] category7 = {"Please Select", "Submit my meter reading", "Submit my payment", "I cannot register", "Access/understand my online bill", "Reset my password", "Change my personal details", "Other"};
            switch (category) {
                case 1:
                    return category1;
                case 2:
                    return category2;
                case 3:
                    return category3;
                case 6:
                    return category6;
                case 7:
                    return category7;
            }
            return category4;
        } else {

            String[] category1 = {"Please Select", "Direct debit / Payment scheme", "Tariff/prices", "Bill enquiry / Meter reading", "Update my email / telephone number", "Refunds", "Make a complaint", "Other"};
            String[] category6 = {"Please Select", "Submit my meter reading", "Submit my payment", "I cannot register", "Access / understand my Online bill", "Reset my password", "Change my personal details", "Other"};
            String[] category7 = {"Please Select", "Sales appointment / quotation queries", "Installation appointments", "Make a complaint", "Other"};
            String[] category2 = {};
            switch (category) {
                case 1:
                    return category1;
                case 6:
                    return category6;
                case 7:
                    return category7;
            }
            return category2;
        }
    }

    public void verifyDropDownList(String BrandName) {
        List<String> prodCat = new ArrayList<String>(Arrays.asList(getProdCategory(BrandName)));
        List<String> testCat = getCategoryList();
        if (prodCat.size() == testCat.size()) {
            Report.updateTestLog("Total number of Category expected : " + prodCat.size() + " Total number of Category Actual :" + testCat.size(), "PASS");
        } else {
            Report.updateTestLog("Total number of Category expected : " + prodCat.size() + " Total number of Category Actual :" + testCat.size(), "Fail");
        }

        for (int x = 0; x < prodCat.size(); x++) {
            String catx = prodCat.get(x);
            boolean catFound = false;
            for (int y = 0; y < testCat.size(); y++) {
                String caty = testCat.get(y);
                if (catx.trim().toString().equalsIgnoreCase(caty.trim().toString())) {
                    catFound = true;
                    Report.updateTestLog("Category " + catx + " found ", "PASS");
                    browser.selectfromDropBox("id", pageProperties.getProperty("ContactUsPage.contactCategoryID"), caty);
                    browser.wait(getWaitTime());
                    List<String> prodReason = new ArrayList<String>(Arrays.asList(getProdReason(x, BrandName)));
                    List<String> testReason = browser.getFromDropBox("id", pageProperties.getProperty("ContactUsPage.contactReasonID"));
                    if (prodReason.size() == testReason.size()) {
                        Report.updateTestLog("Total number of Reasons expected for category '" + caty + "': " + prodReason.size() + " Total number of reasons Actual :" + testReason.size(), "PASS");
                    } else {
                        Report.updateTestLog("Total number of Reasons expected for category '" + caty + "': " + prodReason.size() + " Total number of reasons Actual :" + testReason.size(), "Fail");
                    }
                    for (int a = 1; a < prodReason.size(); a++) {
                        String reasonx = prodReason.get(a).trim();
                        boolean reaFound = false;

                        for (int b = 1; b < testReason.size(); b++) {
                            if (reasonx.equalsIgnoreCase(testReason.get(b).trim())) {
                                reaFound = true;
                                break;
                            }
                        }
                        System.out.println("------------------------->");
                        System.out.println(prodReason.get(a));
                        System.out.println("------------------------->");
                        if (!reaFound) {
                            Report.updateTestLog("Reason " + prodReason.get(a) + " NOT found ", "FAIL");
                        } else {
                            Report.updateTestLog("Reason " + prodReason.get(a) + " found ", "PASS");
                        }
                    }
                }
            }
            if (!catFound) {
                Report.updateTestLog("The category present in production " + catx + "is not present in the testing site", "Fail");
            }
        }
    }

    private void validateEmptyFields() {
        Report.updateTestLog("Validation Starts for Blank Values", "DONE");
        verifyAndClick(pageProperties.getProperty("ContactUsPage.sendButton"), "Contact Us Send Button");

        browser.wait(getWaitTime());

        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ErrorMSGHeader, "Error Message Header");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ErrorMSGSubHeader, "Error Message Sub Header");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_CATEGORY_ERROR, "Error Message for Category Field");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_TELL_US_MORE_ERROR, "Error Message for Query Field");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_TITLE_ERROR, "Error Message for Title Field");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_FIRSTNAME_ERROR, "Error Message for FirstName Field");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_LASTNAME_ERROR, "Error Message for LastName Field");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_HOUSE_ERROR, "Error Message for House Number/Name");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_POSTCODE_ERROR, "Error Message for Postcode");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_EMAIL_ERROR, "Error Message for Email Field");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_TELEPHONE_ERROR, "Error Message for Telephone Field");

        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_CATEGORY_InLineERROR, "In Line Error Message for Category Field");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_TELL_US_MORE_InLineERROR, "In Line Error Message for Queries Field");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_TITLE_InLineERROR, "In Line Error Message for Title Field");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_FIRSTNAME_InLineERROR, "In Line Error Message for First Name Field");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_LASTNAME_InLineERROR, "In Line Error Message for Last Name");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_HOUSE_InLineERROR, "In Line Error Message for House No/Name");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_POSTCODE_InLineERROR, "In Line Error Message for Postcode Field");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_EMAIL_InLineERROR, "In Line Error Message for Email Field");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_TELEPHONE_InLineERROR, "In Line Error Message for Telephone Field");
        Report.updateTestLog("Validation Ends for Blank Values", "DONE");
    }

    private void validateOAMEmptyFields() {
        Report.updateTestLog("Validation Starts for Blank Values", "DONE");
        verifyAndInputById(pageProperties.getProperty("ContactUsPage.telephoneNumber"),"Phone Number","");
        verifyAndClick(pageProperties.getProperty("ContactUsPage.sendButton"), "Contact Us Send Button");
        browser.wait(getWaitTime());
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ErrorMSGHeader, "Error Message Header");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_ErrorMSGSubHeader, "Error Message Sub Header");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_CATEGORY_ERROR, "Error Message for Category Field");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_TELL_US_MORE_ERROR, "Error Message for Query Field");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_EMAIL_ERROR, "Error Message for Email Field");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_TELEPHONE_ERROR, "Error Message for Telephone Field");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_EMAIL_InLineERROR, "In Line Error Message for Email Field");
        verifyIsTextPresent(GlobalErrorMessages.ReFactoring_TELEPHONE_InLineERROR, "In Line Error Message for Telephone Field");
        Report.updateTestLog("Validation Ends for Blank Values", "DONE");
    }


    private void validateOverlay(String cat,String strType) {
        browser.wait(getWaitTime());
        System.out.print("Category : " + cat);
        boolean blnFqaLink = new TestDataHelper().getContactUsQueue(cat).getFaqLink();
        if (blnFqaLink) {
            if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ContactUsPage.FAQLink"))) {
                Report.updateTestLog("FAQ Link displayed", "PASS");
                browser.clickWithXpath(pageProperties.getProperty("ContactUsPage.FAQLink"));
                browser.wait(getWaitTime());
                String test;
               // System.out.println("OVERLAY----"+new TestDataHelper().getContactUsQueue(cat).getOverlay());
                //System.out.println("Actual-----"+browser.getTextByXpath(pageProperties.getProperty("ContactUsPage.overlaytext")));
                if (browser.getTextByXpath(pageProperties.getProperty("ContactUsPage.overlaytext")).contains(new TestDataHelper().getContactUsQueue(cat).getOverlay().substring(0, 5))) {
                    Report.updateTestLog("Text in overlay verified", "PASS");
                } else {
                    Report.updateTestLog("Text in overlay does not match expected", "FAIL");
                }
            } else {
                Report.updateTestLog("FAQ Link is not displayed in the application", "FAIL");
            }
            browser.wait(5000);
            if(strType.equalsIgnoreCase("Anonymous"))
            {
            if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ContactUsPage.CloseOverlayAnonymous"))){
            	browser.clickWithXpath(pageProperties.getProperty("ContactUsPage.CloseOverlayAnonymous"));
            }else if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ContactUsPage.CloseOverlayAnonymous1"))){
                browser.clickWithXpath(pageProperties.getProperty("ContactUsPage.CloseOverlayAnonymous1"));
            }
            }
            if(strType.equalsIgnoreCase("OAM"))
            {
            browser.clickWithXpath(pageProperties.getProperty("ContactUsPage.CloseOverlayOAM"));
            }
        } else {
            if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ContactUsPage.FAQLink"))) {
                Report.updateTestLog("FAQ Link is not expected for this category and Product", "FAIL");
            }

        }
        boolean blnFqaLink2 = new TestDataHelper().getContactUsQueue(cat).getFaqLink2();
        if (blnFqaLink2) {
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ContactUsPage.FAQLink2"))) {
            Report.updateTestLog("FAQ Link 2 displayed", "PASS");
            browser.clickWithXpath(pageProperties.getProperty("ContactUsPage.FAQLink2"));
            if (browser.getTextByXpath(pageProperties.getProperty("ContactUsPage.overlaytext")).contains(new TestDataHelper().getContactUsQueue(cat).getOverlay2().substring(0, 5))) {
                Report.updateTestLog("Text in overlay verified", "PASS");
            } else {
                Report.updateTestLog("Text in overlay does not match expected", "FAIL");
            }
        } else {
            Report.updateTestLog("FAQ Link is not displayed in the application", "FAIL");
        }
        if(strType.equalsIgnoreCase("OAM"))
        {
        browser.clickWithXpath(pageProperties.getProperty("ContactUsPage.CloseOverlay2OAM"));
        } else {
        	browser.clickWithXpath(pageProperties.getProperty("ContactUsPage.CloseOverlayAnonymous2"));
        }
        }
    }

    public void logInToYourAccount() {
        if (browser.isElementVisible(pageProperties.getProperty("ContactUsPage.contactCategoryID"))) {
           // browser.clickWithLinkText("log in to your account.");
    	browser.wait(1000);
    	browser.input("defaultMessage", "uuuu");
            verifyAndClickWithXpath(pageProperties.getProperty("ContactUsPage.LoginToYourAccount"), "as");
        	//browser.clickWithXpath(pageProperties.getProperty("ContactUsPage.LoginToYourAccount"));
            Report.updateTestLog("Log in to your account link clicked", "DONE");
        //} else {
          //  Report.updateTestLog("Log in to your account link does not exist", "FAIL");
        }
    }
////////////////////////////////////////////////////To Verify Contact us Single Iteration//////////////////////////////////////////////
    
    public void verifyContactusJourney(){
 	   
 	 /////Selecting Main Category  
 	 verifyAndSelectDropDownBoxbyindex(pageProperties.getProperty("ContactUsPage.MainCategory"), 1);
 	 browser.wait(3000);
 	 /////Selecting Sub Category
 	 verifyAndSelectDropDownBoxbyindex(pageProperties.getProperty("ContactUsPage.SubCategory"), 1);  
 	 //////Entering Query Text
 	 browser.clearValue(pageProperties.getProperty("ContactUsPage.contactQuery"));
      String test ="just testing" ;  		
      browser.input(pageProperties.getProperty("ContactUsPage.contactQuery"), test);
      int count = test.length();
      Report.updateTestLog("Tell Us More    ::"+count+" Characters entered", "PASS");
      //////Filling Up Contact Details
      if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ContactUsPage.title"))) {
      	WebElement element = browser.getElementByXpath(pageProperties.getProperty("ContactUsPage.title"));
      	element.click();
      	browser.wait(5000);
      	element = browser.getElementByXpath(pageProperties.getProperty("ContactUsPage.titleOption"));
      	element.click();
      	browser.wait(5000);
          Report.updateTestLog(" Title Selected", "WARN");
      } else {
          Report.updateTestLog("Title Not Selected", "FAIL");
      }
    
      browser.input(pageProperties.getProperty("ContactUsPage.firstName"), "Smoke");
      browser.input(pageProperties.getProperty("ContactUsPage.lastName"), "Testing");
      browser.input(pageProperties.getProperty("ContactUsPage.houseNumber"),"12");
      browser.input(pageProperties.getProperty("ContactUsPage.postcode"), "sw9 9lw");
      browser.input(pageProperties.getProperty("ContactUsPage.emailAddress"), "SmokeTesting@bgdigitaltest.co.uk");
      browser.input(pageProperties.getProperty("ContactUsPage.confirmemailAddress"), "SmokeTesting@bgdigitaltest.co.uk");
      browser.input(pageProperties.getProperty("ContactUsPage.telephoneNumber"), "01234567899");
      ///////Clicking Submit button
      verifyAndClick(pageProperties.getProperty("ContactUsPage.sendButton"), "Send Button");
     ////////Verifying confirmation page
      verifyconfirmationPage();
 	    
    }
    public void verifyconfirmationPage(){
 	   
 	   if(browser.isTextPresent("System error")){
            Report.updateTestLog("System error", "FAIL");
        }
        else{
        String referenceNo = "";
        browser.wait(getWaitTime());
        try{
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("ContactUsConfirmationPage.ReferenceNo"))) {
        }}catch(NoSuchElementException e){
        	browser.isElementVisibleWithXpath(pageProperties.getProperty("ContactUsConfirmationPage.OAMReferenceNo"));
        }
            //verifyAudit(userprofile);
            if (ApplicationConfig.BRAND.equalsIgnoreCase("BG")){
            referenceNo = browser.getTextByXpath(pageProperties.getProperty("ContactUsConfirmationPage.ReferenceNo"));
            } else {
            	referenceNo = browser.getTextByXpath(pageProperties.getProperty("ContactUsConfirmationPage.SEReferenceNo"));	
            }
            if (!(referenceNo=="")) {
                Report.updateTestLog("Reference Number :" + referenceNo + "Verified in Confirmation Page", "WARN");
                Report.updateTestLog("Contact Us Confirmation Page Verified", "PASS");
                String strconftext = browser.getTextByXpath(pageProperties.getProperty("ContactUsConfirmationPage.Query"));
                int strconf = strconftext.length();
                Report.updateTestLog(strconf+"  Characters are displayed in Confirmation Page", "PASS");
           
            } else {
                Report.updateTestLog("Contact Us Confirmation Page Not Verified", "FAIL");
            }
 	   
    }
    }
    
    
    
    
    
    
}
