package bg.framework.app.functional.page.selfServe;




import bg.framework.app.functional.action.sales.AcquisitionAction;
import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;


import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: !boobalas
 * Date: 14/12/11
 * Time: 07:29
 * To change this template use File | Settings | File Templates.
 */
public class PaymentDetailsPage extends BasePage {
	private final static String FILE_NAME = "resources/sales/"+ApplicationConfig.BRAND+"Acquisition.properties";
	//private final static String FILE_NAME = "resources/ReFactoring/BGAcquisition.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    String logPath = null;



        public PaymentDetailsPage(){
        }
        public PaymentDetailsPage(Acquisition acquisition){

        }
        
    public AcquisitionAction paymentPageNavigation(Acquisition acquisition){

        String paymenttype=acquisition.getPaymentType();
        
        if (ApplicationConfig.BRAND.equalsIgnoreCase("bg")){
		if(browser.isElementVisible(pageProperties.getProperty("Acquisition."+paymenttype))){
	     browser.click(pageProperties.getProperty("Acquisition."+paymenttype));
         Report.updateTestLog("Payment  Details Page Payment selected is "+paymenttype, "PASS");
		}
        else{
         Report.updateTestLog("Payment  Details Page Payment selected is "+paymenttype, "FAIL");
        }
        }
        paymentDetails(acquisition);
        return new AcquisitionAction();
    }
    
    public AcquisitionAction paymentPageNavigationEE50(Acquisition acquisition){

		if(browser.isElementVisible(pageProperties.getProperty("Acquisition.MonthlyDD"))){
	     browser.click(pageProperties.getProperty("Acquisition.MonthlyDD"));
         Report.updateTestLog("Payment  Details Page Payment selected is Monthly Direct Debit ", "PASS");
		}
        else{
         Report.updateTestLog("Payment  Details Page Payment selected is Monthly Direct Debit ", "FAIL");
        }
		selectEE50();
        paymentDetails(acquisition);
        return new AcquisitionAction();
    }

    public AcquisitionAction variableDirectDebitPayment(Acquisition acquisition)   {

         if(browser.isElementVisible(pageProperties.getProperty("Acquisition.MonthlyVariableDirectDebit"))){
	     browser.click(pageProperties.getProperty("Acquisition.MonthlyVariableDirectDebit"));
         Report.updateTestLog("Payment  Details Page Payment selected  ", "PASS");
		 }
         else{
         Report.updateTestLog("Payment  Details Page Payment selected  ", "FAIL");
         }
         paymentDetails(acquisition);
         changingPaymentMethodOverlay();
         payNowOnline(acquisition);
         return new AcquisitionAction();

    }
    
    public AcquisitionAction QuarterlyCashCheque(Acquisition acquisition)   {
    	if (ApplicationConfig.BRAND.equalsIgnoreCase("bg")){
    		
        if(browser.isElementVisible(pageProperties.getProperty("Acquisition.QuarterlyCashCheque"))){
	     browser.click(pageProperties.getProperty("Acquisition.QuarterlyCashCheque"));
        Report.updateTestLog("Payment  Details Page Payment selected is Quarterly Cash Cheque ", "PASS");
		 }
        else{
        Report.updateTestLog("Payment  Details Page Payment selected is ", "FAIL");
        }
    	}
        paymentDetails(acquisition);
        return new AcquisitionAction();

   }
    
    
    public AcquisitionAction QuarterlyCashChequeEE50(Acquisition acquisition)   {

        if(browser.isElementVisible(pageProperties.getProperty("Acquisition.QuarterlyCashCheque"))){
	     browser.click(pageProperties.getProperty("Acquisition.QuarterlyCashCheque"));
        Report.updateTestLog("Payment  Details Page Payment selected is Quarterly Cash Cheque ", "PASS");
		 }
        else{
        Report.updateTestLog("Payment  Details Page Payment selected is ", "FAIL");
        }
        selectEE50();
        paymentDetails(acquisition);
        return new AcquisitionAction();

   }

    public void changingPaymentMethodOverlay(){

        if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.ChangingYourPaymentText"))){
           if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.ChangingYourPaymentContinue"))){
           browser.clickWithXpath(pageProperties.getProperty("Acquisition.ChangingYourPaymentContinue"));
           }
           Report.updateTestLog("Payment Details Details Page ChangingYourPaymentContinue button is clicked successfully", "PASS");
        }

    }
    
    public void selectEE50(){
    
    	if(browser.isElementVisible(pageProperties.getProperty("Acquisition.EE50"))){
           browser.click(pageProperties.getProperty("Acquisition.EE50"));
           Report.updateTestLog("EE50 Addon is selected Successfully", "PASS");
   		 }
    	
    	else if(browser.isElementVisible(pageProperties.getProperty("Acquisition.EE50Quarterly"))){
            browser.click(pageProperties.getProperty("Acquisition.EE50Quarterly"));
            Report.updateTestLog("EE50 Addon is selected Successfully", "PASS"); 
    				
    	}
    	else {
    	   Report.updateTestLog("EE50 Addon is not selected Successfully", "FAIL");
    	}
    	
    }

    public void payNowOnline(Acquisition acquisition){

        if (browser.isTextPresent(pageProperties.getProperty("Acquisition.PayNowOnlineref"))) {
            browser.clickWithLinkText(pageProperties.getProperty("Acquisition.PayNowOnlineref"));
            Report.updateTestLog("Navigate to Pay Now Online Page", "PASS");

         browser.wait(getWaitTime());

         if(browser.isElementVisible(pageProperties.getProperty("Acquisition.CardType"))){
         browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.CardType"),acquisition.getCardType());
         Report.updateTestLog("Payment Details Page Pay Day Field verification and value selected is "+ acquisition.getCardType(), "PASS");
		 }

         if(browser.isElementVisible(pageProperties.getProperty("Acquisition.NameOnCard"))){
         browser.input(pageProperties.getProperty("Acquisition.NameOnCard"),acquisition.getCardName());
         Report.updateTestLog("Payment Details Page Account Number Field verification and value selected is "+acquisition.getCardName(), "PASS");
		 }

         if(browser.isElementVisible(pageProperties.getProperty("Acquisition.CardNumber"))){
         browser.input(pageProperties.getProperty("Acquisition.CardNumber"),acquisition.getCardNumber());
         Report.updateTestLog("Payment Details Page Account Number Field verification and value selected is "+acquisition.getCardNumber(), "PASS");
		 }

         if(browser.isElementVisible(pageProperties.getProperty("Acquisition.StartDateMonth"))){
         browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.StartDateMonth"),acquisition.getStartMonth());
         Report.updateTestLog("Payment Details Page Pay Day Field verification and value selected is "+acquisition.getStartMonth(), "PASS");
		 }

         if(browser.isElementVisible(pageProperties.getProperty("Acquisition.StartDateYear"))){
         browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.StartDateYear"),acquisition.getStartYear());
         Report.updateTestLog("Payment Details Page Pay Day Field verification and value selected is "+acquisition.getStartYear(), "PASS");
		 }

         if(browser.isElementVisible(pageProperties.getProperty("Acquisition.ExpiryDateMonth"))){
         browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.ExpiryDateMonth"),acquisition.getExpiryMonth());
         Report.updateTestLog("Payment Details Page Pay Day Field verification and value selected is "+acquisition.getExpiryMonth(), "PASS");
		 }

         if(browser.isElementVisible(pageProperties.getProperty("Acquisition.ExpiryDateYear"))){
         browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.ExpiryDateYear"),acquisition.getExpiryYear());
         Report.updateTestLog("Payment Details Page Pay Day Field verification and value selected is "+acquisition.getExpiryYear(), "PASS");
		 }

         if(browser.isElementVisible(pageProperties.getProperty("Acquisition.CVVNumber"))){
         browser.input(pageProperties.getProperty("Acquisition.CVVNumber"),acquisition.getCvvCode());
         Report.updateTestLog("Payment Details Page Account Number Field verification and value selected is "+acquisition.getCvvCode(), "PASS");
		 }

         if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.SubmitPayNowOnline"))){
           browser.clickWithXpath(pageProperties.getProperty("Acquisition.SubmitPayNowOnline"));
           Report.updateTestLog("Payment Details Details Page continue button is clicked successfully", "PASS");
        }
        browser.wait(getWaitTime());

         if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.PaymentOptionsContinue"))){
           browser.clickWithXpath(pageProperties.getProperty("Acquisition.PaymentOptionsContinue"));
           Report.updateTestLog("Payment Details Details Page continue button is clicked successfully", "PASS");
        }
        else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.PaymentOptionsContinueForEnergyShop"))){
           browser.clickWithXpath(pageProperties.getProperty("Acquisition.PaymentOptionsContinueForEnergyShop"));
           Report.updateTestLog("Payment Details Page continue button is clicked successfully", "PASS");
        }
        else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.PaymentOptionsContinue1"))){
           browser.clickWithXpath(pageProperties.getProperty("Acquisition.PaymentOptionsContinue1"));
           Report.updateTestLog("Payment Details Details Page continue button is clicked successfully", "PASS");
        }
        browser.wait(getWaitTime());
        }
    }

    public void paymentDetails(Acquisition acquisition){

		if(browser.isElementVisible(pageProperties.getProperty("Acquisition.BankAccountNumber"))){
         browser.input(pageProperties.getProperty("Acquisition.BankAccountNumber"),acquisition.getPaymentAccountNumber());
         Report.updateTestLog("Payment Details Page Account Number Field verification and value selected is "+acquisition.getPaymentAccountNumber(), "PASS");
		}
        else if(browser.isElementVisible(pageProperties.getProperty("Acquisition.BankAccountNumber1"))){
         browser.input(pageProperties.getProperty("Acquisition.BankAccountNumber1"),acquisition.getPaymentAccountNumber());
         Report.updateTestLog("Payment Details Page Account Number Field verification and value selected is "+acquisition.getPaymentAccountNumber(), "PASS");
		}
		if(browser.isElementVisible(pageProperties.getProperty("Acquisition.SotrCodeNumber1"))){
         browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber1"),acquisition.getSortCode1());
         Report.updateTestLog("Payment Details PagegetSortCode1 Field verification and value selected is "+acquisition.getSortCode1(), "PASS");
		}
        else if(browser.isElementVisible(pageProperties.getProperty("Acquisition.SotrCodeNumber1a"))){
         browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber1a"),acquisition.getSortCode1());
         Report.updateTestLog("Payment Details PagegetSortCode1 Field verification and value selected is "+acquisition.getSortCode1(), "PASS");
		}
		if(browser.isElementVisible(pageProperties.getProperty("Acquisition.SotrCodeNumber2"))){
         browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber2"),acquisition.getSortCode2() );
         Report.updateTestLog("Payment Details Page SotrCodeNumber2 Field verification and value selected is "+acquisition.getSortCode2(), "PASS");
		}
		if(browser.isElementVisible(pageProperties.getProperty("Acquisition.SotrCodeNumber3"))){
         browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber3"),acquisition.getSortCode3() );
         Report.updateTestLog("Payment Details Page SotrCodeNumber3 Field verification and value selected is "+acquisition.getSortCode3(), "PASS");
		}
		if(browser.isElementVisible(pageProperties.getProperty("Acquisition.AccountName"))){
         browser.input(pageProperties.getProperty("Acquisition.AccountName"),acquisition.getAccountName() );
         Report.updateTestLog("Payment Details Page AccountName Field verification and value selected is "+acquisition.getAccountName(), "PASS");
		}
        else if(browser.isElementVisible(pageProperties.getProperty("Acquisition.AccountName1"))){
         browser.input(pageProperties.getProperty("Acquisition.AccountName1"),acquisition.getAccountName() );
         Report.updateTestLog("Payment Details Page AccountName Field verification and value selected is "+acquisition.getAccountName(), "PASS");
		}
		if(browser.isElementVisible(pageProperties.getProperty("Acquisition.PayDay"))){
         browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.PayDay"),acquisition.getPayDay());
         Report.updateTestLog("Payment Details Page Pay Day Field verification and value selected is "+acquisition.getPayDay(), "PASS");
		}
        else if(browser.isElementVisible(pageProperties.getProperty("Acquisition.PayDay1"))){
         browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.PayDay1"),acquisition.getPayDay());
         Report.updateTestLog("Payment Details Page Pay Day Field verification and value selected is "+acquisition.getPayDay(), "PASS");
		}
		if(browser.isElementVisible(pageProperties.getProperty("Acquisition.PaymentOptionsgasbillday"))){
	       browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.PaymentOptionsgasbillday"),"Monthly");
	       browser.input(pageProperties.getProperty("Acquisition.PaymentOptionsgasAmt"), "1500");
	       Report.updateTestLog("Payment Details Page Gas Bill Period Field verification and value selected is : Monthly 1500 ", "PASS");
		}
		if(browser.isElementVisible(pageProperties.getProperty("Acquisition.PaymentOptionselecbillday"))){
		   browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.PaymentOptionselecbillday"),"Monthly");
		   browser.input(pageProperties.getProperty("Acquisition.PaymentOptionselecamt"), "1500");
		   Report.updateTestLog("Payment Details Page Electricity Bill Period Field verification and value selected is : Monthly 1500 ", "PASS");
	    }
        if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.PaymentOptionsContinue"))){
           browser.clickWithXpath(pageProperties.getProperty("Acquisition.PaymentOptionsContinue"));
           Report.updateTestLog("Payment Details Details Page continue button is clicked successfully", "PASS");
        }
        else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.PaymentOptionsContinueForEnergyShop"))){
           browser.clickWithXpath(pageProperties.getProperty("Acquisition.PaymentOptionsContinueForEnergyShop"));
           Report.updateTestLog("Payment Details Page continue button is clicked successfully", "PASS");
        }
        else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.PaymentOptionsContinue1"))){
           browser.clickWithXpath(pageProperties.getProperty("Acquisition.PaymentOptionsContinue1"));
           Report.updateTestLog("Payment Details Details Page continue button is clicked successfully", "PASS");
        }
        else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.PaymentSubmit2"))){
            browser.clickWithXpath(pageProperties.getProperty("Acquisition.PaymentSubmit2"));
            Report.updateTestLog("Payment Details Details Page continue button is clicked successfully", "PASS");
         }
        
        browser.wait(getWaitTime());

        
    }
        
        
        
        
        public AcquisitionAction accountNumbervalidation(Acquisition acquisition){
        
        String[] getBankAccNumber;
        getBankAccNumber = new String[4];
        getBankAccNumber[0] = "85qw1221";
        getBankAccNumber[1] = "#$%^&";
        getBankAccNumber[2] = "abcde";
        getBankAccNumber[3] = "1234";
       
        for (int i=0;i<4;i++){
        	
       final String paymenttype=acquisition.getPaymentType();	  	
    		if(browser.isElementVisible(pageProperties.getProperty("Acquisition."+paymenttype))){	
    	         browser.click(pageProperties.getProperty("Acquisition."+paymenttype));
    		}
    		browser.clearValue(pageProperties.getProperty("Acquisition.BankAccountNumber"));
        	browser.input(pageProperties.getProperty("Acquisition.BankAccountNumber"),getBankAccNumber[i] );
        	browser.clearValue(pageProperties.getProperty("Acquisition.SotrCodeNumber1"));
            browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber1"),"40" );
            browser.clearValue(pageProperties.getProperty("Acquisition.SotrCodeNumber2"));
            browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber2"),"40" );
            browser.clearValue(pageProperties.getProperty("Acquisition.SotrCodeNumber3"));
            browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber3"),"40" );
            browser.clearValue(pageProperties.getProperty("Acquisition.AccountName"));
            browser.input(pageProperties.getProperty("Acquisition.AccountName"),"Dhiru" );
            browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.PayDay"),"7" );
            
            if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.PaymentOptionsContinue"))){
               browser.clickWithXpath(pageProperties.getProperty("Acquisition.PaymentOptionsContinue"));
            }
            else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.PaymentOptionsContinueForError"))){
           	   browser.clickWithXpath(pageProperties.getProperty("Acquisition.PaymentOptionsContinueForError"));             	
            }
            errorPaymentMessageVerification();
        }
        return new AcquisitionAction();
        
        }
       
        
        
        
        public AcquisitionAction accountNamevalidation(Acquisition acquisition){
            
            String[] getBankAccName;
            getBankAccName = new String[3];
            getBankAccName[0] = "85qw1221";
            getBankAccName[1] = "#$%^&";
            getBankAccName[2] = "1234";
           
            for (int i=0;i<3;i++){
            	
            final String paymenttype=acquisition.getPaymentType();	  	
        		if(browser.isElementVisible(pageProperties.getProperty("Acquisition."+paymenttype))){	
        	         browser.click(pageProperties.getProperty("Acquisition."+paymenttype));
        		}
        		browser.clearValue(pageProperties.getProperty("Acquisition.BankAccountNumber"));
                browser.input(pageProperties.getProperty("Acquisition.BankAccountNumber"),"01234567" );
                browser.clearValue(pageProperties.getProperty("Acquisition.SotrCodeNumber1"));
                browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber1"),"40" );
                browser.clearValue(pageProperties.getProperty("Acquisition.SotrCodeNumber2"));
                browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber2"),"40" );
                browser.clearValue(pageProperties.getProperty("Acquisition.SotrCodeNumber3"));
                browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber3"),"40" );
                browser.clearValue(pageProperties.getProperty("Acquisition.AccountName"));
                browser.input(pageProperties.getProperty("Acquisition.AccountName"),getBankAccName[i] );
                browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.PayDay"),"7" );
                
                if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.PaymentOptionsContinue"))){
                   browser.clickWithXpath(pageProperties.getProperty("Acquisition.PaymentOptionsContinue"));
                 }
                else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.PaymentOptionsContinueForError"))){
            	   browser.clickWithXpath(pageProperties.getProperty("Acquisition.PaymentOptionsContinueForError"));                   	
                 }
                errorPaymentMessageVerification();
            }
            return new AcquisitionAction();
            }
        
        
        
        
        public AcquisitionAction errorPaymentPage(){
        	
           
        	validateAccountNumber();
        	validateSortCodeOneNumber();
        	validateSortCodetwoNumber();
        	validateSortCodethreeNumber();
        	validateAccountName();
        	return new AcquisitionAction();
        }
        
        
        public void validateAccountNumber(){
           
           
            browser.click(pageProperties.getProperty("Acquisition.PaymentRadioButton"));
            browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber1"),"40" );
            browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber2"),"40" );
            browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber3"),"40" );
            browser.input(pageProperties.getProperty("Acquisition.AccountName"),"Dhiru" );
            browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.PayDay"),"7" );
            browser.click(pageProperties.getProperty("Acquisition.PaymentOptionsContinue"));
            errorPaymentMessageVerification();
        
        }
        public void validateSortCodeOneNumber(){
            
            
            browser.click(pageProperties.getProperty("Acquisition.PaymentRadioButton"));
            browser.input(pageProperties.getProperty("Acquisition.BankAccountNumber"),"01234567" );
            browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber2"),"40" );
            browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber3"),"40" );
            browser.input(pageProperties.getProperty("Acquisition.AccountName"),"Dhiru" );
            browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.PayDay"),"7" );
            browser.click(pageProperties.getProperty("Acquisition.PaymentOptionsContinue"));
            errorPaymentMessageVerification();
           
        
        }
        public void validateSortCodetwoNumber(){
            
            
            browser.click(pageProperties.getProperty("Acquisition.PaymentRadioButton"));
            browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber1"),"40" );
            
            browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber3"),"40" );
            browser.input(pageProperties.getProperty("Acquisition.AccountName"),"Dhiru" );
            browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.PayDay"),"7" );
            browser.click(pageProperties.getProperty("Acquisition.PaymentOptionsContinue"));
            errorPaymentMessageVerification();
        
        }
        public void validateSortCodethreeNumber(){
            
           
            browser.click(pageProperties.getProperty("Acquisition.PaymentRadioButton"));
            browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber1"),"40" );
            browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber2"),"40" );
           
            browser.input(pageProperties.getProperty("Acquisition.AccountName"),"Dhiru" );
            browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.PayDay"),"7" );
            browser.click(pageProperties.getProperty("Acquisition.PaymentOptionsContinue"));
            errorPaymentMessageVerification();
        
        }
        public void validateAccountName(){
            
            
            browser.click(pageProperties.getProperty("Acquisition.PaymentRadioButton"));
            browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber1"),"40" );
            browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber2"),"40" );
            browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber3"),"40" );
            browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.PayDay"),"7" );
            browser.click(pageProperties.getProperty("Acquisition.PaymentOptionsContinue"));
            errorPaymentMessageVerification();
        
        }
        
        public void errorPaymentMessageVerification() {
        	String paymentMessage;
        	
        	if (browser.isElementVisible(pageProperties.getProperty("Acquisition.GasElecErrorMessage"))){
        		paymentMessage = browser.getText(pageProperties.getProperty("Acquisition.GasElecErrorMessage"));
        		Report.updateTestLog("Payment Details Details Page Error Validation"+paymentMessage, "PASS");
            }
            else{
            	Report.updateTestLog("Payment Details Details Page Error Validation", "FAIL");
            }





        	
        }
}