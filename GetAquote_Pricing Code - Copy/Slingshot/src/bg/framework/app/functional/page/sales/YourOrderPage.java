package bg.framework.app.functional.page.sales;

import bg.framework.app.functional.action.sales.AcquisitionAction;
import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import org.openqa.selenium.InvalidElementStateException;

import java.util.List;
import java.util.Properties;


public class YourOrderPage extends BasePage {
   
	//private final static String FILE_NAME = "resources/ReFactoring/"+ApplicationConfig.BRAND+"Acquisition.properties";
	private final static String FILE_NAME = "resources/ReFactoring/BGAcquisition.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
    private final static String noNectarValue = "4";
    private final static String addnectarLater = "3";
    private final static String addNewNectarValue = "2";
    private final static String addExistingNectarValue = "1";	
    private final static String acceptTermsValue = "Y";

    public YourOrderPage() {
    }

    public YourOrderPage(UserProfile userProfile) {

    }

    public AcquisitionAction errorYourOrderPageFieldVerification() {

        

        browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.GasSupplierList"), "Please select");
        Report.updateTestLog(" Gas Supplier Section - Please Select " , "PASS");
        browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.ElecSupplierList"), "Please select");
        Report.updateTestLog(" Elecrticity Supplier Section - Please Select  " , "PASS");
        yourOrderContinueClick();

        sorryMessageVerification();
        gasMessageVerification();
        elecMessageVerification();
        


        List<String> elecsupplier;
        elecsupplier = browser.getFromDropBox("id", pageProperties.getProperty("Acquisition.ElecSupplierList"));
        System.out.println(elecsupplier);
        Report.updateTestLog(" Electricity Supplier Section  Values  - " + elecsupplier   , "DONE");
        for (int x = 1; x < elecsupplier.size(); x++) {
           
            
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.ElecSupplierList"), elecsupplier.get(x));
            Report.updateTestLog(" Electricity Supplier Section  -  " + elecsupplier.get(x)  , "DONE");
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.GasSupplierList"), "Please select");
            Report.updateTestLog(" Gas Supplier Section - Please Select " , "DONE");
            yourOrderContinueClick();
            sorryMessageVerification();
            gasMessageVerification();

        }

        List<String> gassupplier;
        gassupplier = browser.getFromDropBox("id", pageProperties.getProperty("Acquisition.GasSupplierList"));
        Report.updateTestLog(" Gas Supplier Section Values -   " + gassupplier   , "DONE");
        for (int x = 1; x < gassupplier.size(); x++) {

            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.GasSupplierList"), gassupplier.get(x));
            Report.updateTestLog(" Gas Supplier Section - " + gassupplier.get(x)  , "DONE");
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.ElecSupplierList"), "Please select");
            Report.updateTestLog(" Elecrticity Supplier Section - Please Select  " , "DONE");
            
            yourOrderContinueClick();     
            sorryMessageVerification();
            elecMessageVerification();

        }
        return new AcquisitionAction();
    }


    public void gasMessageVerification() {
        String errorMessage;
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.GasErrorMessage"))) {
            errorMessage = browser.getTextByXpath(pageProperties.getProperty("Acquisition.GasErrorMessage"));
            Report.updateTestLog(" Expected Error Message " + errorMessage, "PASS");
        } else {
            Report.updateTestLog(" Please specify your current supplier for Gas doesnot display", "FAIL");
        }
    }
    
    public void elecMessageVerification() {
        String errorMessage;
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.ElecErrorMessage"))) {
            errorMessage = browser.getTextByXpath(pageProperties.getProperty("Acquisition.ElecErrorMessage"));
            Report.updateTestLog(" Expected Error Message " + errorMessage, "PASS");
        } else {
            Report.updateTestLog(" Please specify your current supplier for Electricity doesnot display", "FAIL");
        }
    }
    
    public void sorryMessageVerification() {
        String errorMessage;
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.SorryMessage"))) {
            errorMessage = browser.getTextByXpath(pageProperties.getProperty("Acquisition.SorryMessage"));
            Report.updateTestLog("Expected Error Message " + errorMessage, "PASS");
        } else {
            Report.updateTestLog("Sorry, we need you to look at the following areas of the form again' doesnot display", "FAIL");
        }
    }




    public AcquisitionAction yourOrderPageAnonymousNavigation(Acquisition acquisition,UserProfile userProfile) {

        gasSelection(acquisition);
        elecSelection(acquisition);
        verifyandSelectNectarOptions(userProfile);
        yourOrderContinueClick();
        browser.wait(getWaitTime());
        return new AcquisitionAction();

    }
    
    public AcquisitionAction yourOrderPageAnonymousCreateLogin(Acquisition acquisition,UserProfile userProfile) {

        gasSelection(acquisition);
        elecSelection(acquisition);
        verifyandSelectNectarOptions(userProfile);
        createLogin(userProfile,acquisition);
        yourOrderContinueClick();
        browser.wait(getWaitTime());
        return new AcquisitionAction();

    }
    
    public void createLogin(UserProfile userProfile,Acquisition acquisition)
    {
    	verifyAndClick("registrationRadio", "Do not have an account");
    	browser.wait(1000);
    	verifyAndInputById("customerReferenceNumber", "Customer ID", userProfile.getUCRN());
    	verifyAndSelectDropDownBox("title", "Title select", userProfile.getTitle());
    	verifyAndInputById("firstName", "First Name", userProfile.getFirstName());
    	verifyAndInputById("surname", "Last Name", userProfile.getLastName());
    	verifyAndInputById("registerEmailAddress", "Email Address", userProfile.getEmail());
    	verifyAndInputById("registerPassword", "Password", userProfile.getPassword());
    	verifyAndInputById("confirmPassword", "Confirm Password", userProfile.getPassword());
    	
    }

    public AcquisitionAction yourOrderPageGasBG(Acquisition acquisition) {

        gasDefaultSelection();
        elecSelection(acquisition);
        addressVerification();
        yourOrderContinueClick();
        browser.wait(getWaitTime());
        return new AcquisitionAction();
    }

    public AcquisitionAction yourOrderElecBG(Acquisition acquisition) {

        gasSelection(acquisition);
        elecDefaultSelection();
        addressVerification();
        yourOrderContinueClick();
        browser.wait(getWaitTime());
        return new AcquisitionAction();

    }

    public AcquisitionAction yourOrderDualBG(Acquisition acquisition) {

        gasDefaultSelection();
        elecDefaultSelection();
        addressVerification();
        yourOrderContinueClick();
        return new AcquisitionAction();

    }

    public void forcedLoginOnly(Acquisition acquisition,UserProfile userProfile)
    {
    	if (ApplicationConfig.BRAND.equalsIgnoreCase("bg")){
            if (browser.isElementVisible(pageProperties.getProperty("Acquisition.GasSupplierList"))) {
                browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.GasSupplierList"), "British Gas");
                Report.updateTestLog("Select Existing Gas supplier", "PASS");

            } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.GasSupplierText"))) {
                browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.GasSupplierText"), "British Gas");
                Report.updateTestLog("Select Existing Gas supplier", "PASS");
            } else {
                Report.updateTestLog("Select Existing Gas supplier", "FAIL");
            }

            if (browser.isElementVisible(pageProperties.getProperty("Acquisition.ElecSupplierList"))) {
                browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.ElecSupplierList"), "British Gas");
                Report.updateTestLog("Select Existing Electricity supplier", "PASS");

            } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.ExistingElecSupplierList"))) {
                browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.ExistingElecSupplierList"), "British Gas");
                Report.updateTestLog("Select Existing Gas supplier", "PASS");
            } else {
                Report.updateTestLog("Select Existing Electricity supplier", "FAIL");
            }
        	}
       
        	
        	else{
        		
        		 if (browser.isElementVisible(pageProperties.getProperty("Acquisition.GasSupplierList"))) {
        	            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.GasSupplierList"), "Sainsbury's Energy");
        	            Report.updateTestLog("Select Existing Gas supplier", "PASS");

        	        } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.GasSupplierText"))) {
        	            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.GasSupplierText"), "Sainsbury's Energy");
        	            Report.updateTestLog("Select Existing Gas supplier", "PASS");
        	        } else {
        	            Report.updateTestLog("Select Existing Gas supplier", "FAIL");
        	        }

        	        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.ElecSupplierList"))) {
        	            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.ElecSupplierList"), "Sainsbury's Energy");
        	            Report.updateTestLog("Select Existing Electricity supplier", "PASS");

        	        } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.ExistingElecSupplierList"))) {
        	            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.ExistingElecSupplierList"), "Sainsbury's Energy");
        	            Report.updateTestLog("Select Existing Gas supplier", "PASS");
        	        } else {
        	            Report.updateTestLog("Select Existing Electricity supplier", "FAIL");
        	        }

        		
        	}
            if (browser.isElementVisible(pageProperties.getProperty("Acquisition.LoginYourOrderPage"))) {
                browser.input(pageProperties.getProperty("Acquisition.LoginYourOrderPage"), userProfile.getEmail());
                Report.updateTestLog("Email Address has been Successfully Entered ", "PASS");
            } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.LoginYourOrderPage1"))) {
                browser.input(pageProperties.getProperty("Acquisition.LoginYourOrderPage1"), userProfile.getEmail());
                Report.updateTestLog("Email Address has been Successfully Entered ", "PASS");
            } else {
                Report.updateTestLog("Email Address has not been Successfully Entered", "FAIL");
            }
            if (browser.isElementVisible(pageProperties.getProperty("Acquisition.PasswordYourOrderPage"))) {
                browser.input(pageProperties.getProperty("Acquisition.PasswordYourOrderPage"), acquisition.getPassword());
                Report.updateTestLog("Password has been Successfully Entered ", "PASS");
            } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.PasswordYourOrderPage1"))) {
                browser.input(pageProperties.getProperty("Acquisition.PasswordYourOrderPage1"), acquisition.getPassword());
                Report.updateTestLog("Password has been Successfully Entered ", "PASS");
            } else {
                Report.updateTestLog("Password has not been Successfully Entered", "FAIL");
            }

            if (browser.isElementVisible(pageProperties.getProperty("Acquisition.LoginButtonYourOrderPage"))) {
                browser.click(pageProperties.getProperty("Acquisition.LoginButtonYourOrderPage"));
                Report.updateTestLog("Login Button has been Successfully Clicked ", "PASS");
            } else {
                Report.updateTestLog("Login Button has not been Successfully Clicked", "FAIL");
            }
            browser.wait(getWaitTime());
            addressVerification();
    }
    
    public AcquisitionAction forcedLoginYourOrderPage(Acquisition acquisition, UserProfile userProfile) {
    	
    	
    	if (ApplicationConfig.BRAND.equalsIgnoreCase("bg")){
        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.GasSupplierList"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.GasSupplierList"), "British Gas");
            Report.updateTestLog("Select Existing Gas supplier", "PASS");

        } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.GasSupplierText"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.GasSupplierText"), "British Gas");
            Report.updateTestLog("Select Existing Gas supplier", "PASS");
        } else {
            Report.updateTestLog("Select Existing Gas supplier", "FAIL");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.ElecSupplierList"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.ElecSupplierList"), "British Gas");
            Report.updateTestLog("Select Existing Electricity supplier", "PASS");

        } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.ExistingElecSupplierList"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.ExistingElecSupplierList"), "British Gas");
            Report.updateTestLog("Select Existing Gas supplier", "PASS");
        } else {
            Report.updateTestLog("Select Existing Electricity supplier", "FAIL");
        }
    	}
   
    	
    	else{
    		
    		 if (browser.isElementVisible(pageProperties.getProperty("Acquisition.GasSupplierList"))) {
    	            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.GasSupplierList"), "Sainsbury's Energy");
    	            Report.updateTestLog("Select Existing Gas supplier", "PASS");

    	        } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.GasSupplierText"))) {
    	            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.GasSupplierText"), "Sainsbury's Energy");
    	            Report.updateTestLog("Select Existing Gas supplier", "PASS");
    	        } else {
    	            Report.updateTestLog("Select Existing Gas supplier", "FAIL");
    	        }

    	        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.ElecSupplierList"))) {
    	            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.ElecSupplierList"), "Sainsbury's Energy");
    	            Report.updateTestLog("Select Existing Electricity supplier", "PASS");

    	        } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.ExistingElecSupplierList"))) {
    	            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.ExistingElecSupplierList"), "Sainsbury's Energy");
    	            Report.updateTestLog("Select Existing Gas supplier", "PASS");
    	        } else {
    	            Report.updateTestLog("Select Existing Electricity supplier", "FAIL");
    	        }

    		
    	}
        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.LoginYourOrderPage"))) {
            browser.input(pageProperties.getProperty("Acquisition.LoginYourOrderPage"), userProfile.getEmail());
            Report.updateTestLog("Email Address has been Successfully Entered ", "PASS");
        } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.LoginYourOrderPage1"))) {
            browser.input(pageProperties.getProperty("Acquisition.LoginYourOrderPage1"), userProfile.getEmail());
            Report.updateTestLog("Email Address has been Successfully Entered ", "PASS");
        } else {
            Report.updateTestLog("Email Address has not been Successfully Entered", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.PasswordYourOrderPage"))) {
            browser.input(pageProperties.getProperty("Acquisition.PasswordYourOrderPage"), acquisition.getPassword());
            Report.updateTestLog("Password has been Successfully Entered ", "PASS");
        } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.PasswordYourOrderPage1"))) {
            browser.input(pageProperties.getProperty("Acquisition.PasswordYourOrderPage1"), acquisition.getPassword());
            Report.updateTestLog("Password has been Successfully Entered ", "PASS");
        } else {
            Report.updateTestLog("Password has not been Successfully Entered", "FAIL");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.LoginButtonYourOrderPage"))) {
            browser.click(pageProperties.getProperty("Acquisition.LoginButtonYourOrderPage"));
            Report.updateTestLog("Login Button has been Successfully Clicked ", "PASS");
        } else {
            Report.updateTestLog("Login Button has not been Successfully Clicked", "FAIL");
        }
        browser.wait(getWaitTime());

        addressVerification();

        yourOrderContinueClick();
        return new AcquisitionAction();
    }

    public void forcedRegisrationOnly(Acquisition acquisition,UserProfile userProfile)
    {
    	if (ApplicationConfig.BRAND.equalsIgnoreCase("bg")){
            if (browser.isElementVisible(pageProperties.getProperty("Acquisition.GasSupplierList"))) {
                browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.GasSupplierList"), "British Gas");
                Report.updateTestLog("Select Existing Gas supplier", "PASS");

            } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.GasSupplierText"))) {
                browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.GasSupplierText"), "British Gas");
                Report.updateTestLog("Select Existing Gas supplier", "PASS");
            } else {
                Report.updateTestLog("Select Existing Gas supplier", "FAIL");
            }

            if (browser.isElementVisible(pageProperties.getProperty("Acquisition.ElecSupplierList"))) {
                browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.ElecSupplierList"), "British Gas");
                Report.updateTestLog("Select Existing Electricity supplier", "PASS");

            } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.ExistingElecSupplierList"))) {
                browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.ExistingElecSupplierList"), "British Gas");
                Report.updateTestLog("Select Existing Gas supplier", "PASS");
            } else {
                Report.updateTestLog("Select Existing Electricity supplier", "FAIL");
            }
        	}
       
        	
        	else{
        		
        		 if (browser.isElementVisible(pageProperties.getProperty("Acquisition.GasSupplierList"))) {
        	            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.GasSupplierList"), "Sainsbury's Energy");
        	            Report.updateTestLog("Select Existing Gas supplier", "PASS");

        	        } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.GasSupplierText"))) {
        	            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.GasSupplierText"), "Sainsbury's Energy");
        	            Report.updateTestLog("Select Existing Gas supplier", "PASS");
        	        } else {
        	            Report.updateTestLog("Select Existing Gas supplier", "FAIL");
        	        }

        	        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.ElecSupplierList"))) {
        	            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.ElecSupplierList"), "Sainsbury's Energy");
        	            Report.updateTestLog("Select Existing Electricity supplier", "PASS");

        	        } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.ExistingElecSupplierList"))) {
        	            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.ExistingElecSupplierList"), "Sainsbury's Energy");
        	            Report.updateTestLog("Select Existing Gas supplier", "PASS");
        	        } else {
        	            Report.updateTestLog("Select Existing Electricity supplier", "FAIL");
        	        }

        		
        	}


       /* if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.IdontHaveAnOnlineLinkYourOrderPage"))) {
            browser.clickWithXpath(pageProperties.getProperty("Acquisition.IdontHaveAnOnlineLinkYourOrderPage"));
            Report.updateTestLog("I dont have an online account link has been clicked", "PASS");
        } else {
            Report.updateTestLog("I dont have an online account link has not been clicked", "FAIL");
        }*/
    	
    	
    	
    	 if (browser.isElementVisible(pageProperties.getProperty("Acquisition.ForcedRegister"))) {
    		 browser.click(pageProperties.getProperty("Acquisition.ForcedRegister"));
             Report.updateTestLog("I dont have an online account link has been clicked", "PASS");
         } else {

             Report.updateTestLog("I dont have an online account link has been clicked", "FAIL");
         }
         browser.wait(getWaitTime());

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.AccountNumberYourOrderPage"))) {
            browser.input(pageProperties.getProperty("Acquisition.AccountNumberYourOrderPage"), userProfile.getAccNumber());
            Report.updateTestLog("Account Number has been Entered Successfully " + userProfile.getAccNumber(), "PASS");
        } else {
            Report.updateTestLog("Account Number has not been Entered Successfully for forced Registration in Your Order Page ", "FAIL");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.TitleYourOrderPage"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.TitleYourOrderPage"), userProfile.getTitle());
            Report.updateTestLog("Title field has been Entered successfully " + userProfile.getTitle(), "PASS");
        } else {
            Report.updateTestLog("Title field has not been Entered successfully for forced Registration in Your Order Page ", "FAIL");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.FirstNameYourOrderPage"))) {
            browser.input(pageProperties.getProperty("Acquisition.FirstNameYourOrderPage"), userProfile.getFirstName());
            Report.updateTestLog("First Name Has been Entered Successfully " + userProfile.getFirstName(), "PASS");
        } else {
            Report.updateTestLog("First Name Has not been Entered Successfully for forced Registration in Your Order Page ", "FAIL");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.LastNameYourOrderPage"))) {
            browser.input(pageProperties.getProperty("Acquisition.LastNameYourOrderPage"), userProfile.getLastName());
            Report.updateTestLog("Last Name Has been Entered Successfully " + userProfile.getLastName(), "PASS");
        } else {
            Report.updateTestLog("Last Name Has not been Entered Successfully for forced Registration in Your Order Page", "FAIL");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.EmailAddressYourOrderPage"))) {
            browser.input(pageProperties.getProperty("Acquisition.EmailAddressYourOrderPage"), userProfile.getEmail());
            Report.updateTestLog("Email Address has been Entered successfully " + userProfile.getEmail(), "PASS");
        } else {
            Report.updateTestLog("Email Address has not been Entered successfully for forced Registration in your Order Page", "FAIL");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.CreatePasswordYourOrderPage"))) {
            browser.input(pageProperties.getProperty("Acquisition.CreatePasswordYourOrderPage"), acquisition.getCreatePassword());
            Report.updateTestLog("Create a Password Field has been Entered Successfully " + acquisition.getCreatePassword(), "PASS");
        } else {
            Report.updateTestLog("Create a Password Field has not been Entered Successfully", "FAIL");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.RetypePasswordYourOrderPage"))) {
            browser.input(pageProperties.getProperty("Acquisition.RetypePasswordYourOrderPage"), acquisition.getRetypePassword());
            Report.updateTestLog("Retype Password Field has been Entered Successfully " + acquisition.getRetypePassword(), "PASS");
        } else {
            Report.updateTestLog("Retype Password Field has not been Entered Successfully for forced Registration in your Order Page ", "FAIL");
        }

        /*if (browser.isElementVisible(pageProperties.getProperty("Acquisition.SecurityQuestionYourOrderPage"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.SecurityQuestionYourOrderPage"), acquisition.getSecurityQuestion());
            Report.updateTestLog("Security Question field has been Entered successfully " + acquisition.getSecurityQuestion(), "PASS");
        } else {
            Report.updateTestLog("Security Question field has not been Entered successfully for forced Registration in Your Order Page ", "FAIL");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.SecurityAnswerYourOrderPage"))) {
            browser.input(pageProperties.getProperty("Acquisition.SecurityAnswerYourOrderPage"), acquisition.getSecurityAnswer());
            Report.updateTestLog("Security Answer field has been Entered successfully " + acquisition.getSecurityAnswer(), "PASS");
        } else {
            Report.updateTestLog("Security Answer field has not been Entered successfully", "FAIL");
        }
*/
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.YourOrderContinueForcedRegistration"))) {
            browser.clickWithXpath(pageProperties.getProperty("Acquisition.YourOrderContinueForcedRegistration"));
            Report.updateTestLog("Continue button in your order page has been clicked", "PASS");
        } else {
            Report.updateTestLog("Continue button in your order page has been clicked", "FAIL");
        }
        
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.ForcedRegEmail"))) {
        	 browser.input(pageProperties.getProperty("Acquisition.ForcedRegEmail"), userProfile.getEmail());
            Report.updateTestLog("Continue button in your order page has been clicked", "PASS");
        } else {
            Report.updateTestLog("Continue button in your order page has been clicked", "FAIL");
        }
    }
    
    public AcquisitionAction forcedRegistrationYourOrderPage(Acquisition acquisition,UserProfile userProfile) {

    	if (ApplicationConfig.BRAND.equalsIgnoreCase("bg")){
            if (browser.isElementVisible(pageProperties.getProperty("Acquisition.GasSupplierList"))) {
                browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.GasSupplierList"), "British Gas");
                Report.updateTestLog("Select Existing Gas supplier", "PASS");

            } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.GasSupplierText"))) {
                browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.GasSupplierText"), "British Gas");
                Report.updateTestLog("Select Existing Gas supplier", "PASS");
            } else {
                Report.updateTestLog("Select Existing Gas supplier", "FAIL");
            }

            if (browser.isElementVisible(pageProperties.getProperty("Acquisition.ElecSupplierList"))) {
                browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.ElecSupplierList"), "British Gas");
                Report.updateTestLog("Select Existing Electricity supplier", "PASS");

            } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.ExistingElecSupplierList"))) {
                browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.ExistingElecSupplierList"), "British Gas");
                Report.updateTestLog("Select Existing Gas supplier", "PASS");
            } else {
                Report.updateTestLog("Select Existing Electricity supplier", "FAIL");
            }
        	}
       
        	
        	else{
        		
        		 if (browser.isElementVisible(pageProperties.getProperty("Acquisition.GasSupplierList"))) {
        	            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.GasSupplierList"), "Sainsbury's Energy");
        	            Report.updateTestLog("Select Existing Gas supplier", "PASS");

        	        } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.GasSupplierText"))) {
        	            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.GasSupplierText"), "Sainsbury's Energy");
        	            Report.updateTestLog("Select Existing Gas supplier", "PASS");
        	        } else {
        	            Report.updateTestLog("Select Existing Gas supplier", "FAIL");
        	        }

        	        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.ElecSupplierList"))) {
        	            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.ElecSupplierList"), "Sainsbury's Energy");
        	            Report.updateTestLog("Select Existing Electricity supplier", "PASS");

        	        } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.ExistingElecSupplierList"))) {
        	            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.ExistingElecSupplierList"), "Sainsbury's Energy");
        	            Report.updateTestLog("Select Existing Gas supplier", "PASS");
        	        } else {
        	            Report.updateTestLog("Select Existing Electricity supplier", "FAIL");
        	        }

        		
        	}


       /* if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.IdontHaveAnOnlineLinkYourOrderPage"))) {
            browser.clickWithXpath(pageProperties.getProperty("Acquisition.IdontHaveAnOnlineLinkYourOrderPage"));
            Report.updateTestLog("I dont have an online account link has been clicked", "PASS");
        } else {
            Report.updateTestLog("I dont have an online account link has not been clicked", "FAIL");
        }*/
    	
    	
    	
    	 if (browser.isElementVisible(pageProperties.getProperty("Acquisition.ForcedRegister"))) {
    		 browser.click(pageProperties.getProperty("Acquisition.ForcedRegister"));
             Report.updateTestLog("I dont have an online account link has been clicked", "PASS");
         } else {

             Report.updateTestLog("I dont have an online account link has been clicked", "FAIL");
         }
         browser.wait(getWaitTime());

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.AccountNumberYourOrderPage"))) {
            browser.input(pageProperties.getProperty("Acquisition.AccountNumberYourOrderPage"), userProfile.getAccNumber());
            Report.updateTestLog("Account Number has been Entered Successfully " + userProfile.getAccNumber(), "PASS");
        } else {
            Report.updateTestLog("Account Number has not been Entered Successfully for forced Registration in Your Order Page ", "FAIL");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.TitleYourOrderPage"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.TitleYourOrderPage"), userProfile.getTitle());
            Report.updateTestLog("Title field has been Entered successfully " + userProfile.getTitle(), "PASS");
        } else {
            Report.updateTestLog("Title field has not been Entered successfully for forced Registration in Your Order Page ", "FAIL");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.FirstNameYourOrderPage"))) {
            browser.input(pageProperties.getProperty("Acquisition.FirstNameYourOrderPage"), userProfile.getFirstName());
            Report.updateTestLog("First Name Has been Entered Successfully " + userProfile.getFirstName(), "PASS");
        } else {
            Report.updateTestLog("First Name Has not been Entered Successfully for forced Registration in Your Order Page ", "FAIL");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.LastNameYourOrderPage"))) {
            browser.input(pageProperties.getProperty("Acquisition.LastNameYourOrderPage"), userProfile.getLastName());
            Report.updateTestLog("Last Name Has been Entered Successfully " + userProfile.getLastName(), "PASS");
        } else {
            Report.updateTestLog("Last Name Has not been Entered Successfully for forced Registration in Your Order Page", "FAIL");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.EmailAddressYourOrderPage"))) {
            browser.input(pageProperties.getProperty("Acquisition.EmailAddressYourOrderPage"), userProfile.getEmail());
            Report.updateTestLog("Email Address has been Entered successfully " + userProfile.getEmail(), "PASS");
        } else {
            Report.updateTestLog("Email Address has not been Entered successfully for forced Registration in your Order Page", "FAIL");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.CreatePasswordYourOrderPage"))) {
            browser.input(pageProperties.getProperty("Acquisition.CreatePasswordYourOrderPage"), acquisition.getCreatePassword());
            Report.updateTestLog("Create a Password Field has been Entered Successfully " + acquisition.getCreatePassword(), "PASS");
        } else {
            Report.updateTestLog("Create a Password Field has not been Entered Successfully", "FAIL");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.RetypePasswordYourOrderPage"))) {
            browser.input(pageProperties.getProperty("Acquisition.RetypePasswordYourOrderPage"), acquisition.getRetypePassword());
            Report.updateTestLog("Retype Password Field has been Entered Successfully " + acquisition.getRetypePassword(), "PASS");
        } else {
            Report.updateTestLog("Retype Password Field has not been Entered Successfully for forced Registration in your Order Page ", "FAIL");
        }

        /*if (browser.isElementVisible(pageProperties.getProperty("Acquisition.SecurityQuestionYourOrderPage"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.SecurityQuestionYourOrderPage"), acquisition.getSecurityQuestion());
            Report.updateTestLog("Security Question field has been Entered successfully " + acquisition.getSecurityQuestion(), "PASS");
        } else {
            Report.updateTestLog("Security Question field has not been Entered successfully for forced Registration in Your Order Page ", "FAIL");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.SecurityAnswerYourOrderPage"))) {
            browser.input(pageProperties.getProperty("Acquisition.SecurityAnswerYourOrderPage"), acquisition.getSecurityAnswer());
            Report.updateTestLog("Security Answer field has been Entered successfully " + acquisition.getSecurityAnswer(), "PASS");
        } else {
            Report.updateTestLog("Security Answer field has not been Entered successfully", "FAIL");
        }
*/
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.YourOrderContinueForcedRegistration"))) {
            browser.clickWithXpath(pageProperties.getProperty("Acquisition.YourOrderContinueForcedRegistration"));
            Report.updateTestLog("Continue button in your order page has been clicked", "PASS");
        } else {
            Report.updateTestLog("Continue button in your order page has been clicked", "FAIL");
        }
        
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.ForcedRegEmail"))) {
        	 browser.input(pageProperties.getProperty("Acquisition.ForcedRegEmail"), userProfile.getEmail());
            Report.updateTestLog("Continue button in your order page has been clicked", "PASS");
        } else {
            Report.updateTestLog("Continue button in your order page has been clicked", "FAIL");
        }
        
        yourOrderContinueClick();
        return new AcquisitionAction();
    }

    public void yourOrderContinueClick() {
    	
    	 Report.updateTestLog("YourOrderPage","WARN");

        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.YourOrderContinue"))) {
            browser.clickWithXpath(pageProperties.getProperty("Acquisition.YourOrderContinue"));
            Report.updateTestLog("Continue button is pressed in YourOrder Page", "PASS");
        } else if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.YourOrderContinueForEnergyAcquisition"))) {
            browser.clickWithXpath(pageProperties.getProperty("Acquisition.YourOrderContinueForEnergyAcquisition"));
            Report.updateTestLog("Continue button is pressed in YourOrder Page", "PASS");
        } else if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.YourOrderContinueForcedRegistration"))) {
            browser.clickWithXpath(pageProperties.getProperty("Acquisition.YourOrderContinueForcedRegistration"));
            Report.updateTestLog("Continue button is pressed in YourOrder Page", "PASS");
        } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.Continue1"))) {
            browser.click(pageProperties.getProperty("Acquisition.Continue1"));
            Report.updateTestLog("Continue button is pressed in YourOrder Page", "PASS");
        } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.Continue"))) {
            browser.click(pageProperties.getProperty("Acquisition.Continue"));
            Report.updateTestLog("Continue button is pressed in YourOrder Page", "PASS");
        } else if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.YourOrderContinueForEnergyAcquisitionFusion"))) {
            browser.clickWithXpath(pageProperties.getProperty("Acquisition.YourOrderContinueForEnergyAcquisitionFusion"));
            Report.updateTestLog("Continue button is pressed in YourOrder Page", "PASS");

        }else if (browser.isElementVisibleWithXpath("//*[@id='regDetails']/div[3]/input")) {
            browser.clickWithXpath("//*[@id='regDetails']/div[3]/input");
            Report.updateTestLog("Continue button is pressed in YourOrder Page", "PASS");

        }else if (browser.isElementVisibleWithXpath("//*[@id='login']")) {
            browser.clickWithXpath("//*[@id='login']");
            Report.updateTestLog("Login button is pressed in YourOrder Page", "PASS");

        }  
        
        else if (browser.isElementVisibleWithXpath("html/body/div[1]/div[2]/div/div[3]/div[1]/form/div[8]/div[2]/input")) {
            browser.clickWithXpath("html/body/div[1]/div[2]/div/div[3]/div[1]/form/div[8]/div[2]/input");
            Report.updateTestLog("Login button is pressed in YourOrder Page", "PASS");

        }  
        else {
            Report.updateTestLog("Continue button  in your order page has not been clicked", "FAIL");
        }
        
        
        
        browser.wait((getWaitTime()));
        browser.wait((getWaitTime()));
        
        /*if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.CancellationCharge"))) {
	        browser.clickWithXpath(pageProperties.getProperty("Acquisition.YourOrderContinueForEnergyAcquisitionFusion"));
	        browser.clickWithXpath(pageProperties.getProperty("Acquisition.AgreementContinue"));
	        browser.wait((getWaitTime()));
	        Report.updateTestLog("Cancellation Charge window was displayed", "PASS");
        }*/
        
        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.AggrementBox"))) {
            browser.click(pageProperties.getProperty("Acquisition.AggrementBox"));
            Report.updateTestLog("Aggrement Box is selected", "PASS");
        }
        if (browser.isElementVisibleWithXpath("//*[@id='canceloverlaycontinue']")) {
            browser.clickWithXpath("//*[@id='canceloverlaycontinue']");
        }
    }

    public AcquisitionAction payAsYouGoYourOrderDetails(Acquisition acquisition) {
        String electricityMeter;

        electricityMeter = acquisition.getCurrentElecSupplier();

       /* if (browser.isElementVisible(pageProperties.getProperty("Acquisition.CurrentServicesGasmetertype_old"))) {
        	List <String> currentgas =browser.getFromDropBox("id", pageProperties.getProperty("Acquisition.CurrentServicesGasmetertype_old"));
        	browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.CurrentServicesGasmetertype_old"), currentgas.get(1));
            Report.updateTestLog("Your Order Page for Pay As You Go Energy , Gas Meter Type Selection  is Prepopulated", "PASS");
        }*/


        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.CurrentServicesElectricitymetertype"))) {
            List<String> currentElec;
            currentElec = browser.getFromDropBox("id", pageProperties.getProperty("Acquisition.CurrentServicesElectricitymetertype"));


            String[] defaultElec;
            defaultElec = new String[6];
            defaultElec[0] = "Prepayment (SmartCard)";
            defaultElec[1] = "Prepayment (Smartkey)";
            defaultElec[2] = "Prepayment (Token)";
            defaultElec[3] = "Prepayment Economy 7 (Smartcard)";
            defaultElec[4] = "Prepayment Economy 7 (Smartkey)";
            defaultElec[5] = "Prepayment Economy 7 (Token)";

            if (currentElec.get(1).equalsIgnoreCase(defaultElec[0])) {
                Report.updateTestLog("Your Order Page for Pay As You Go Energy , Gas Meter Type Selection " + defaultElec[0] + "is Present", "PASS");
            } else {
                Report.updateTestLog("Your Order Page for Pay As You Go Energy , Gas Meter Type Selection " + defaultElec[0] + "is not Present", "FAIL");
            }

            if (currentElec.get(2).equalsIgnoreCase(defaultElec[1])) {
                Report.updateTestLog("Your Order Page for Pay As You Go Energy , Gas Meter Type Selection " + defaultElec[1] + "is Present", "PASS");
            } else {
                Report.updateTestLog("Your Order Page for Pay As You Go Energy , Gas Meter Type Selection " + defaultElec[1] + "is not Present", "FAIL");
            }

            if (currentElec.get(3).equalsIgnoreCase(defaultElec[2])) {
                Report.updateTestLog("Your Order Page for Pay As You Go Energy , Gas Meter Type Selection " + defaultElec[2] + "is Present", "PASS");
            } else {
                Report.updateTestLog("Your Order Page for Pay As You Go Energy , Gas Meter Type Selection " + defaultElec[2] + "is not Present", "FAIL");
            }

            if (currentElec.get(4).equalsIgnoreCase(defaultElec[3])) {
                Report.updateTestLog("Your Order Page for Pay As You Go Energy , Gas Meter Type Selection " + defaultElec[3] + "is Present", "PASS");
            } else {
                Report.updateTestLog("Your Order Page for Pay As You Go Energy , Gas Meter Type Selection " + defaultElec[3] + "is not Present", "FAIL");
            }

            if (currentElec.get(5).equalsIgnoreCase(defaultElec[4])) {
                Report.updateTestLog("Your Order Page for Pay As You Go Energy , Gas Meter Type Selection " + defaultElec[4] + "is Present", "PASS");
            } else {
                Report.updateTestLog("Your Order Page for Pay As You Go Energy , Gas Meter Type Selection " + defaultElec[4] + "is not Present", "FAIL");
            }

            if (currentElec.get(6).equalsIgnoreCase(defaultElec[5])) {
                Report.updateTestLog("Your Order Page for Pay As You Go Energy , Gas Meter Type Selection " + defaultElec[5] + "is Present", "PASS");
            } else {
                Report.updateTestLog("Your Order Page for Pay As You Go Energy , Gas Meter Type Selection " + defaultElec[5] + "is not Present", "FAIL");
            }

            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.CurrentServicesElectricitymetertype"), currentElec.get(1));
        }


        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.SpecialNeeds"))) {
            browser.click(pageProperties.getProperty("Acquisition.SpecialNeeds"));
            Report.updateTestLog("SpecialNeeds Section is selected", "PASS");
        } else {
            Report.updateTestLog("SpecialNeeds is not selected", "FAIL");
        }

        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.PAYGContinue"))) {
            browser.clickWithXpath(pageProperties.getProperty("Acquisition.PAYGContinue"));
            Report.updateTestLog("Continue button is pressed in YourOrder Page", "PASS");
        } else if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.PAYGContinueElec"))) {
            browser.clickWithXpath(pageProperties.getProperty("Acquisition.PAYGContinueElec"));
            Report.updateTestLog("Continue button is pressed in YourOrder Page", "PASS");
        } else {
            Report.updateTestLog("Continue button is not pressed in YourOrder Page", "FAIL");
        }

        return new AcquisitionAction();

    }

    public AcquisitionAction energySmartAcquisitionYourOrderPage(Acquisition acquisition, UserProfile userProfile) {
    	browser.open("http://10.224.70.85/apps/britishgas/components/energyshop/GET.servlet?tariffName=clear-and-simple&fuelType=dual&journeyTrigger=1&quoteId=1&nextPage=/content/britishgas/products-and-services/gas-and-electricity/energy-smart/orderenergy.html");
        gasSelection(acquisition);
        elecSelection(acquisition);
        yourOrderContinueClick();
       // energySmartYourOrderPagefillUserDetails(acquisition, userProfile);
        return new AcquisitionAction();
    }

    public void energySmartYourOrderPagefillUserDetails(Acquisition acquisition, UserProfile userProfile) {


        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.Title"))) {
        	try{
		    browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.Title"), userProfile.getTitle());
            }
        	catch(Exception e) {
            }
           
            Report.updateTestLog("Personal Details Page Title field verification,Title field Exists and value entered is " + userProfile.getTitle(), "PASS");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.FirstName"))) {

            try {
            	browser.clearValue(pageProperties.getProperty("Acquisition.FirstName"));
                browser.input(pageProperties.getProperty("Acquisition.FirstName"), userProfile.getFirstName());
            } catch (InvalidElementStateException e) {
            }
            Report.updateTestLog("Personal Details Page First Name field verification,First Name field Exists and value entered is " + userProfile.getFirstName(), "PASS");
        } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.FirstName1"))) {

            try {         
            	browser.clearValue(pageProperties.getProperty("Acquisition.FirstName1"));
                browser.input(pageProperties.getProperty("Acquisition.FirstName1"), userProfile.getFirstName());
            } catch (InvalidElementStateException e) {
            }
            Report.updateTestLog("Personal Details Page First Name field verification,First Name field Exists and value entered is " + userProfile.getFirstName(), "PASS");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.LastName"))) {
        	try {  
        		browser.clearValue(pageProperties.getProperty("Acquisition.LastName"));
        		browser.input(pageProperties.getProperty("Acquisition.LastName"), userProfile.getLastName());
            } catch (InvalidElementStateException e) {
            }
            
            Report.updateTestLog("Personal Details Page Last Name field verification,Last Name Exists and value entered is " + userProfile.getLastName(), "PASS");
        } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.LastName1"))) {
        	try {       
        		browser.clearValue(pageProperties.getProperty("Acquisition.LastName1"));
        		browser.input(pageProperties.getProperty("Acquisition.LastName1"), userProfile.getLastName());
            } catch (InvalidElementStateException e) {
            }
            
            
            Report.updateTestLog("Personal Details  Last Name field verification,Last Name Exists and value entered is " + userProfile.getLastName(), "PASS");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.Day"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.Day"), acquisition.getDay());
            Report.updateTestLog("Personal Details  DOB Day field verification,Day field Exists and value entered is " + acquisition.getDay(), "PASS");
        }
        else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.Day1"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.Day1"), acquisition.getDay());
            Report.updateTestLog("Personal Details  DOB Day field verification,Day field Exists and value entered is " + acquisition.getDay(), "PASS");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.Month"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.Month"), acquisition.getMonth());
            Report.updateTestLog("Personal Details  DOB Month field verification,Month field Exists and value entered is " + acquisition.getMonth(), "PASS");
        }
        else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.Month1"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.Month1"), acquisition.getMonth());
            Report.updateTestLog("Personal Details  DOB Month field verification,Month field Exists and value entered is " + acquisition.getMonth(), "PASS");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.Year"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.Year"), acquisition.getYear());

            Report.updateTestLog("Personal Details  DOB Year field verification,Year field Exists and value entered is " + acquisition.getYear(), "PASS");
        }
        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.Year1"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.Year1"), acquisition.getYear());

            Report.updateTestLog("Personal Details  DOB Year field verification,Year field Exists and value entered is " + acquisition.getYear(), "PASS");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.TelephoneNumber"))) {
        	browser.clearValue(pageProperties.getProperty("Acquisition.TelephoneNumber"));
            browser.input(pageProperties.getProperty("Acquisition.TelephoneNumber"), acquisition.getMobileNumber());
            Report.updateTestLog("Personal Details Telephone Number field verification,Telephone Number Field Exists and value entered is" + acquisition.getMobileNumber(), "PASS");
        } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.TelephoneNumber1"))) {
        	browser.clearValue(pageProperties.getProperty("Acquisition.TelephoneNumber1"));
            browser.input(pageProperties.getProperty("Acquisition.TelephoneNumber1"), acquisition.getMobileNumber());
            Report.updateTestLog("Personal Details  Telephone Number field verification,Telephone Number Field Exists and value entered is" + acquisition.getMobileNumber(), "PASS");
        } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.TelephoneNumber2"))) {
        	browser.clearValue(pageProperties.getProperty("Acquisition.TelephoneNumber2"));
            browser.input(pageProperties.getProperty("Acquisition.TelephoneNumber2"), acquisition.getMobileNumber());
            Report.updateTestLog("Personal Details Telephone Number field verification,Telephone Number Field Exists and value entered is" + acquisition.getMobileNumber(), "PASS");
        } 
        
        else {
            Report.updateTestLog("Personal Details Page Telephone Number field verification,Telephone Number does not Exists and value is not entered ", "Fail");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.TelephoneType"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.TelephoneType"), acquisition.getTelephonetype());
            Report.updateTestLog("Personal Details Page Telephone Type field verification,Telephone Type field Exists and value entered is " + acquisition.getTelephonetype(), "PASS");
        }
        else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.TelephoneType1"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.TelephoneType1"), acquisition.getTelephonetype());
            Report.updateTestLog("Personal Details Page Telephone Type field verification,Telephone Type field Exists and value entered is " + acquisition.getTelephonetype(), "PASS");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.EmailAddress"))) {
        	try {       
        		browser.clearValue(pageProperties.getProperty("Acquisition.EmailAddress"));
        		browser.input(pageProperties.getProperty("Acquisition.EmailAddress"), userProfile.getEmail());
            } catch (InvalidElementStateException e) {
            }
            
            
            Report.updateTestLog("Personal Details Page Email Address field verification,Email Address Exists and value entered is " + userProfile.getEmail(), "PASS");
        } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.EmailAddress1"))) {
        	try {             
        		browser.clearValue(pageProperties.getProperty("Acquisition.EmailAddress1"));
        		browser.input(pageProperties.getProperty("Acquisition.EmailAddress1"), userProfile.getEmail());
            } catch (InvalidElementStateException e) {
            }
            
            
            Report.updateTestLog("Personal Details Page Email Address field verification,Email Address Exists and value entered is " + userProfile.getEmail(), "PASS");
        }


        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.EmailType"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.EmailType"), acquisition.getEmailtype());
            Report.updateTestLog("Personal Details Page Email Type field verification,Email Type field Exists and value entered is " + acquisition.getEmailtype(), "PASS");
        }


        yourOrderContinueClick();

        browser.wait(getWaitTime());

    }

    public void energySmartDifferentSupplyAddress(Acquisition acquisition) {

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.SelectSupplyAddressForm"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.SelectSupplyAddressForm"), "Please select");
            Report.updateTestLog("Address field Selection verification, prepopulated address is  " + "Please select", "PASS");
        } else {
            Report.updateTestLog("Address field Selection verification, address is not being selected Properly ", "FAIL");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.DifferentSupplyAddress"))) {
            browser.click(pageProperties.getProperty("Acquisition.DifferentSupplyAddress"));
            Report.updateTestLog("DifferentSupplyAddress Box is selected", "PASS");
        }
        yourOrderContinueClick();

    }

    public AcquisitionAction energySmartDifferentSupplyAddressGas(Acquisition acquisition) {

    	gasDefaultSelection();
        elecSelection(acquisition);
        energySmartDifferentSupplyAddress(acquisition);
        return new AcquisitionAction();
    }

    public AcquisitionAction energySmartDifferentSupplyAddressElec(Acquisition acquisition) {

    	elecDefaultSelection();
    	gasSelection(acquisition);
        energySmartDifferentSupplyAddress(acquisition);
        return new AcquisitionAction();
    }


    public AcquisitionAction energySmartDifferentSupplyAddressDual(Acquisition acquisition) {

        gasDefaultSelection();
        elecDefaultSelection();
        energySmartDifferentSupplyAddress(acquisition);

        return new AcquisitionAction();
    }


    public void gasSelection(Acquisition acquisition) {

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.GasSupplierList"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.GasSupplierList"), acquisition.getGasSupplier());
            Report.updateTestLog("Select Existing Gas supplier", "PASS");
        } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.GasSupplierText"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.GasSupplierText"), acquisition.getGasSupplier());
            Report.updateTestLog("Select Existing Gas supplier", "PASS");
        } else {
            Report.updateTestLog("Select Existing Gas supplier", "FAIL");
        }

    }

    public void elecSelection(Acquisition acquisition) {

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.ElecSupplierList"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.ElecSupplierList"), acquisition.getElecSupplier());
            Report.updateTestLog("Select Existing Electricity supplier", "PASS");
        } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.ExistingElecSupplierList"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.ExistingElecSupplierList"), acquisition.getElecSupplier());
            Report.updateTestLog("Select Existing Electricity supplier", "PASS");
        } else {
            Report.updateTestLog("Select Existing Electricity supplier", "FAIL");
        }


    }

    public void gasDefaultSelection() {

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.GasSupplierText"))) {
        	String strgassuplier = browser.getText(pageProperties.getProperty("Acquisition.GasSupplierText"));
            Report.updateTestLog("Current Supplier Selection for Gas Field Verification is PrePopulated with "+ strgassuplier, "PASS");
        } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.GasSupplierList"))) {
        	String strgassuplier = browser.getText(pageProperties.getProperty("Acquisition.GasSupplierList"));
            Report.updateTestLog("Current Supplier Selection for Gas Field Verification is PrePopulated with "+ strgassuplier, "PASS");
         } else {
            Report.updateTestLog("Current Supplier Selection for Gas Field Verification is not displayed ", "FAIL");
        }

    }

    public void elecDefaultSelection() {

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.ExistingElecSupplierList"))) {
        	String strelecsuplier = browser.getText(pageProperties.getProperty("Acquisition.ExistingElecSupplierList"));
            Report.updateTestLog("Current Supplier Selection for Elec Field Verification is PrePopulated with "+ strelecsuplier, "PASS");
        } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.ElecSupplierList"))) {
        	String strelecsuplier = browser.getText(pageProperties.getProperty("Acquisition.ElecSupplierList"));
            Report.updateTestLog("Current Supplier Selection for Elec Field Verification is PrePopulated with "+ strelecsuplier, "PASS");
       } else {
            Report.updateTestLog("Current Supplier Selection for Elec Field Verification is not displayed ", "FAIL");
        }

    }

    public void addressVerification() {

       
        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.AddressSectionforOAM"))) {
            
                	List<String> selectedAddress;
                	selectedAddress= browser.getFromDropBox("id", pageProperties.getProperty("Acquisition.AddressSectionforOAM"));
                	browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.AddressSectionforOAM"), selectedAddress.get(1));
                	Report.updateTestLog("Address field Selection verification, Selected address is  " + selectedAddress.get(1), "PASS");
               
               
        } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.AddressSectionforOAM1"))) {
          
        	List<String> selectedAddress;
        	selectedAddress= browser.getFromDropBox("id", pageProperties.getProperty("Acquisition.AddressSectionforOAM1"));
        	browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.AddressSectionforOAM1"), selectedAddress.get(0));
        	Report.updateTestLog("Address field Selection verification, Selected address is  " + selectedAddress.get(0), "PASS");
        } 

    }
    public void verifyandSelectNectarOptions(UserProfile userProfile){
    	String nectarInput = userProfile.getNectarValue();
        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.NoNectarRadioId"))) {
            if (nectarInput.trim().equalsIgnoreCase(noNectarValue)) {
                verifyAndClick(pageProperties.getProperty("Acquisition.Cardnever"),"No Nectar Options");
                Report.updateTestLog(" No Nectar Needed option selected . ","PASS");
            } else if (nectarInput.trim().equalsIgnoreCase(addNewNectarValue)) {
                verifyAndClick(pageProperties.getProperty("Acquisition.Cardlater"),"Add New Nectar Card");
                Report.updateTestLog("Selected Add New Nectar Option. ","PASS");
            } else if (nectarInput.trim().equalsIgnoreCase(addnectarLater)) {
                verifyAndClick(pageProperties.getProperty("Acquisition.Cardsignup"),"Add Nectar Card Later");
                Report.updateTestLog("Selected Add Nectar Later Option. ","PASS");    
            } else if (nectarInput.trim().equalsIgnoreCase(addExistingNectarValue)) {
                verifyAndClick(pageProperties.getProperty("Acquisition.AddExistingNectarRadioId"),"Existing Nectar Card");
                browser.input(pageProperties.getProperty("Acquisition.NectarTextId"),"11111111111");
                Report.updateTestLog("Selected Add Existing Nectar Option. Added the Card: 11111111111 . ","PASS");
            }
            if (browser.isElementVisible(pageProperties.getProperty("Acquisition.NectarTermsCheckBoxId"))){
            		verifyAndClick(pageProperties.getProperty("Acquisition.NectarTermsCheckBoxId"),"Nectar Terms and Conditions");
            }            
        }        
    }
    public AcquisitionAction verifyandclickBackbutton(){
    	if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.BackButton"))){
    		verifyAndClickWithXpath(pageProperties.getProperty("Acquisition.BackButton"),"Back Link");   		
        }
    	return new AcquisitionAction();
    }
    public AcquisitionAction verifyandclickCancelbutton(){
    	if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.CancelButton"))){
    		verifyAndClickWithXpath(pageProperties.getProperty("Acquisition.CancelButton"),"Cancel Link");    		
         }
    	return new AcquisitionAction();
    }

}
















