package bg.framework.app.functional.page.selfServe;




import bg.framework.app.functional.action.sales.AcquisitionAction;
import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.common.functional.UIDriver;
import bg.framework.common.functional.WebDriverProvider;


import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

/**
 * Created by IntelliJ IDEA.
 * User: !boobalas
 * Date: 14/12/11
 * Time: 07:29
 * To change this template use File | Settings | File Templates.
 */
public class PaymentDetailsPage extends BasePage {
	//private final static String FILE_NAME = "resources/sales/"+ApplicationConfig.BRAND+"Acquisition.properties";
	private final static String FILE_NAME = "resources/ReFactoring/BGAcquisition.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    String logPath = null;



        public PaymentDetailsPage(){
        }
        public PaymentDetailsPage(Acquisition acquisition){

        }
        
    public AcquisitionAction paymentPageNavigation(Acquisition acquisition){

        String paymenttype=acquisition.getPaymentType();
        
        if (ApplicationConfig.BRAND.equalsIgnoreCase("bg")){
		if(browser.isElementVisible(pageProperties.getProperty("Acquisition.PaymentRadioButton"))){
	     browser.click(pageProperties.getProperty("Acquisition.PaymentRadioButton"));
         Report.updateTestLog("Payment  Details Page Payment selected is "+paymenttype, "PASS");
		}
        else{
         Report.updateTestLog("Payment  Details Page Payment selected is "+paymenttype, "FAIL");
        }
        }
        if(browser.isElementVisible(pageProperties.getProperty("Acquisition.billDay")))
        {
        	browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.billDay"), "03");
        }
        paymentDetails(acquisition);
        return new AcquisitionAction();
    }
    
    
    public AcquisitionAction paymentPageNavigationSMB(Acquisition acquisition, String debt,String accountType,String GasAccount, String Option){

    /*	 if(debt.equals("NO"))
    	 {
    		 verifyIsElementVisibleWithXpath(pageProperties.getProperty("xpath"), "Pay Now By Payment Card");
    		 verifyIsElementVisibleWithXpath(pageProperties.getProperty("xpath"), "Amount to be Taken");
    		 if(Option.equals("DDPayment"))
    		 {
    		 paymentPageNavigationSMBNoDebtSecondOption(acquisition);
    		 paymentOptionpageSMB(acquisition, GasAccount);
    		 accounttypeMFDD(acquisition, accountType);
    		 }if(Option.equals("CCPayment"))
    		 {
			 paymentPageNavigationSMBNoDebt(acquisition);
    		 paymentOptionpageSMB(acquisition, GasAccount);
    		 accounttypeMFDD(acquisition, accountType); 
    		 }
    	 }
    	 {*/
    	if(debt.equals("NO"))
    	{    		
    			if(!browser.isElementVisibleWithXpath(pageProperties.getProperty("SMB.Iwillpaythesenow"))&&!browser.isElementVisibleWithXpath(pageProperties.getProperty("SMB.Includethisinmybill")))
    			{
    			paymentOptionpageSMB(acquisition, GasAccount);
    			accounttypeMFDD(acquisition, accountType);	
    			}
    			else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("SMB.Iwillpaythesenow"))&&browser.isElementVisibleWithXpath(pageProperties.getProperty("SMB.Includethisinmybill")))
    			{
    			if(Option.equals("DDPayment"))
    			 {
    			 paymentPageNavigationSMBNoDebtSecondOption(acquisition);
    			 paymentOptionpageSMB(acquisition, GasAccount);
    			 accounttypeMFDD(acquisition, accountType);
    			 }
    			if(Option.equals("CCPayment"))
    			 {
    			verifyAndClickWithXpath(pageProperties.getProperty("SMB.Iwillpaythesenow"), "Pay Now By Payment Card");
    			 paymentPageNavigationSMBNoDebt(acquisition);
    			 paymentOptionpageSMB(acquisition, GasAccount);
    			 }    			
    			accounttypeMFDD(acquisition, accountType); 
    			}
    		}
		 
    	 if(debt.equals("YES"))
    	 {
    		 verifyIsElementVisibleWithXpath(pageProperties.getProperty("SMB.cleardebt"), "Pay Now By Payment Card");
    		/*if(!browser.isElementVisibleWithXpath(pageProperties.getProperty("SMB.cleardebt")))
    		{
    			Report.updateTestLog("Amount to be Taken Not present", "PASS");
    		}else
    		{
    			Report.updateTestLog("Amount to be Taken present", "FAIL");
    		}*/
    		paymentPageNavigationSMBNoDebt(acquisition);
    		paymentOptionpageSMB(acquisition, GasAccount);
   		 	accounttypeMFDD(acquisition, accountType);
    	 }
        return new AcquisitionAction();
        }
    
    
    public AcquisitionAction paymentPageNavigationSMBNoDebt(Acquisition acquisition){

      //verifyAndClickWithXpath(pageProperties.getProperty("SMB.Iwillpaythesenow"), "Pay Now By Payment Card");
   	        
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

         // if(browser.isElementVisible(pageProperties.getProperty("Acquisition.StartDateMonth"))){
         // browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.StartDateMonth"),acquisition.getStartMonth());
         // Report.updateTestLog("Payment Details Page Pay Day Field verification and value selected is "+acquisition.getStartMonth(), "PASS");
 		// }

        //  if(browser.isElementVisible(pageProperties.getProperty("Acquisition.StartDateYear"))){
          //browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.StartDateYear"),acquisition.getStartYear());
         // Report.updateTestLog("Payment Details Page Pay Day Field verification and value selected is "+acquisition.getStartYear(), "PASS");
 		// }

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
      verifyAndClick(pageProperties.getProperty("SMB.Submit"), "Submit Button");
      
      if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Ddcps.3dsecureiframe")))
		{
			UIDriver driver = WebDriverProvider.getCurrentDriver();
			driver.switchTo().frame(driver.findElement(By.xpath(pageProperties.getProperty("Ddcps.3dsecureiframe"))));
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Ddcps.3dSecureHtml")))
			{
			verifyAndClickWithXpath(pageProperties.getProperty("Ddcps.3dSecureHtml"),"Submit 3d secure");
			}
			else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Ddcps.3dSecureMaestro")))
			{
				//verifyAndInputByXpath(pageProperties.getProperty("Ddcps.3dSecureMaestro"), "Maestro Secure Code",acquisition.getthreedSecure());
				//browser.inputByXpath(pageProperties.getProperty("Ddcps.3dSecureMaestro"),acquisition.getthreedSecure());
				verifyAndClickWithXpath(pageProperties.getProperty("Ddcps.3dSecureMaeestrSubmit"), "Maestro Submit");
			}
			//browser.closeAlert();
			browser.swtichToDefaultContent();			
		}
    	  
      if(browser.isElementVisibleWithXpath(pageProperties.getProperty("SMB.Submit1"))){
    	  Report.updateTestLog("Debt has been paid", "WARN");
    	  browser.clickWithXpath(pageProperties.getProperty("SMB.Submit1"));
    	 }
       return new AcquisitionAction();
   }
    
    	
    public AcquisitionAction paymentPageNavigationSMBNoDebtSecondOption(Acquisition acquisition){
    	 verifyAndClickWithXpath(pageProperties.getProperty("SMB.Includethisinmybill"), "DirectDebit-Amount to be taken");
    	 verifyAndClick(pageProperties.getProperty("SMB.Submit"), "Submit Button");
         return new AcquisitionAction();
     }
    
    public AcquisitionAction paymentOptionpageSMB(Acquisition acquisition, String GasAccount){
        if(GasAccount.equals("CC")){
        	if(browser.isElementVisible(pageProperties.getProperty("Acquisition.BankAccountNumber"))){
                browser.input(pageProperties.getProperty("Acquisition.BankAccountNumber"),acquisition.getPaymentAccountNumber());
                Report.updateTestLog("Payment Details Page Account Number Field verification and value selected is "+acquisition.getPaymentAccountNumber(), "PASS");
       		}
               else if(browser.isElementVisible(pageProperties.getProperty("Acquisition.BankAccountNumber1"))){
                browser.input(pageProperties.getProperty("Acquisition.BankAccountNumber1"),acquisition.getPaymentAccountNumber());
                Report.updateTestLog("Payment Details Page Account Number Field verification and value selected is "+acquisition.getPaymentAccountNumber(), "PASS");
       		}
        	//browser.input(pageProperties.getProperty("SMB.BankAccountNumber"),"01234567" );
        
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
        
   			/*if(browser.isElementVisible(pageProperties.getProperty("SMB.Billdate"))){
            browser.input(pageProperties.getProperty("SMB.Billdate"),acquisition.getAccountName());
            //String dropbilldate=browser.getTextByXpath(pageProperties.getProperty("SMB.Billdatevalue"));
	        browser.selectfromDropBox("id", pageProperties.getProperty("SMB.Billdate"),"2");
            Report.updateTestLog("Payment Details Page Billdate Field verification and value selected is 2", "PASS");
   		}*/
   		//verifyAndSelectDropDownBoxByXpath("id", pageProperties.getProperty("SMB.Billdate"),"2");
   		if(browser.isElementVisible(pageProperties.getProperty("SMB.Billdate"))){
    		
            //  browser.input(pageProperties.getProperty("SMB.Billdate"),acquisition.getAccountName());
              String dropbilldate=browser.getTextByXpath(pageProperties.getProperty("SMB.Billdatevalue"));
              browser.selectfromDropBox("id", pageProperties.getProperty("SMB.Billdate"),dropbilldate);
  	       // browser.selectfromDropBox("id", pageProperties.getProperty("SMB.Billdatevalue"),dropbilldate);
              Report.updateTestLog("Payment Details Page Billdate Field verification and value is selected","PASS");
     		}
        verifyAndClickWithXpath(pageProperties.getProperty("SMB.T&C"), "Read And Understood DirectDebit Agreement");
        
        verifyAndClick(pageProperties.getProperty("SMB.Confirm"), "Confirm Button");
        }
        if(GasAccount.equals("DD"))
        {	
        	
     	//Select Check Box with drop down Box....
        	if(browser.isElementVisible(pageProperties.getProperty("SMB.Billdate"))){
        		
              //  browser.input(pageProperties.getProperty("SMB.Billdate"),acquisition.getAccountName());
                String dropbilldate=browser.getTextByXpath(pageProperties.getProperty("SMB.Billdatevalue"));
                browser.selectfromDropBox("id", pageProperties.getProperty("SMB.Billdate"),dropbilldate);
    	       // browser.selectfromDropBox("id", pageProperties.getProperty("SMB.Billdatevalue"),dropbilldate);
                Report.updateTestLog("Payment Details Page Billdate Field verification and value is selected","PASS");
       		}
        	//verifyAndSelectDropDownBox("id", pageProperties.getProperty("SMB.Billdate"),"2");
            /*--------------------------------------------------------------------------Vishnu added----------------------------------------------------- */
            
            if(GasAccount.equals("FDD")){
            	if(browser.isElementVisible(pageProperties.getProperty("SMB.BilldateMFDDTeztBox"))){
            		
            		String MFDDBillDate=browser.getTextByXpath(pageProperties.getProperty("SMB.BilldateMFDDTeztBox"));
            		Report.updateTestLog("Payment Details Page BillDate for MFDD Text Box verification and the value displayed is "+MFDDBillDate, "PASS");
            	}else{
            		Report.updateTestLog("Payment Details Page BillDate for MFDD Text Box verification and the value is not displayed", "FAIL");
            	}        	
            }      
            /*--------------------------------------------------------------------------Vishnu added----------------------------------------------------- */      
            
        	verifyAndClickWithXpath(pageProperties.getProperty("SMB.T&C"), "Read And Understood DirectDebit Agreement");
            verifyAndClick(pageProperties.getProperty("SMB.Confirm"), "Confirm Button");
        }
    	
                
         return new AcquisitionAction();
     }
      
    public AcquisitionAction accounttypeMFDD(Acquisition acquisition, String accountType){
        if(accountType.equals("MFDD"))
        {	
        verifyAndClick(pageProperties.getProperty("SMB.MFDD"), "Confirm Click");
        if(browser.isElementVisible(pageProperties.getProperty("SMB.MFDD")))
		{
        	verifyAndClick(pageProperties.getProperty("paymentchangewarningcontinue"),"payment change warning continue");
			Report.updateTestLog("Overlay is displayed for MFDD flow", "PASS");
		}else
		{
			Report.updateTestLog("Overlay is not displayed for MFDD fl1ow", "FAIL");
		}
        
        }
        
        if(accountType.equals("CCPAY"))
        {	
        if(browser.isElementVisible(pageProperties.getProperty("SMB.MFDD")))
		{
        	verifyAndClick(pageProperties.getProperty("paymentchangewarningcontinue"),"payment change warning continue");
			Report.updateTestLog("Overlay is displayed for CCPAY flow", "PASS");
		}else
		{
			Report.updateTestLog("Overlay is not displayed for CCPAY flow", "FAIL");
		}
        
        }
        if(accountType.equals("MVDD"))
        {	
        	if(!browser.isElementVisible(pageProperties.getProperty("SMB.MFDD")))
    		{
    			Report.updateTestLog("MVDD- Overlay is not displayed", "PASS");
    		}else
    		{
    			Report.updateTestLog("MVDD- Overlay is displayed", "FAIL");
    		}
        }
        
         return new AcquisitionAction();
     }
    
    public AcquisitionAction paymentPageNavigationNew(Acquisition acquisition){

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
        if(browser.isElementVisible(pageProperties.getProperty("Acquisition.billDay")))
        {
        	browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.billDay"), "03");
        }
        paymentDetails(acquisition);
        return new AcquisitionAction();
    }
    
    public AcquisitionAction paymentPageNavigationNewNew(Acquisition acquisition){

    	 int eventid1=new OnlineDBConnector().verifyCancelEntryCount();
 	   	System.out.println("senthil:"+eventid1);
 	   	
        String paymenttype=acquisition.getPaymentType();
        
/*        if (ApplicationConfig.BRAND.equalsIgnoreCase("bg")){
		if(browser.isElementVisible(pageProperties.getProperty("Acquisition."+paymenttype))){
	     browser.click(pageProperties.getProperty("Acquisition."+paymenttype));
         Report.updateTestLog("Payment  Details Page Payment selected is "+paymenttype, "PASS");
		}
        else{
         Report.updateTestLog("Payment  Details Page Payment selected is "+paymenttype, "FAIL");
        }
        }*/
        if(browser.isElementVisible(pageProperties.getProperty("Acquisition.billDay")))
        {
        	browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.billDay"), "03");
        }
        paymentDetails(acquisition);
        
//    	verifyAndClickWithXpath("//a[@title='Cancel']", "Cancel");     
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}    	
    	//verifyIsTextPresent("Our tariffs");
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	int eventid2=new OnlineDBConnector().verifyCancelEntryCount();
	   	System.out.println("senthil:"+eventid2);
	   	
    	if ((eventid1+1)==eventid2){
    	   	Report.updateTestLog("Cancel Entry is Successfully Updated in DB", "PASS");
    	   	}
    	   	else{
    	   	Report.updateTestLog("Cancel Entry is not Updated in DB", "FAIL");
    	   	}	
    	
        return new AcquisitionAction();
    }
    
  /*  public AcquisitionAction cancelReviewOrderPage(Acquisition acquisition){
     	int eventid1=new OnlineDBConnector().verifyCancelEntryCount();
	   	System.out.println("senthil:"+eventid1);
	   	
	   	
    	verifyAndClickWithXpath("//a[@title='Cancel']", "Cancel");     
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}    	
    	verifyIsTextPresent("Our tariffs");
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	int eventid2=new OnlineDBConnector().verifyCancelEntryCount();
	   	System.out.println("senthil:"+eventid2);
	   	
    	if ((eventid1+1)==eventid2){
    	   	Report.updateTestLog("Cancel Entry is Successfully Updated in DB", "PASS");
    	   	}
    	   	else{
    	   	Report.updateTestLog("Cancel Entry is not Updated in DB", "FAIL");
    	   	}	
    	
        return new AcquisitionAction();
    }*/
     
  
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

    public void setCardDetails(Acquisition acquisition,String card){
    	acquisition.setCardNumber(acquisition.getCardNumber());
		acquisition.setExpiryMonth(acquisition.getExpiryMonth());
		acquisition.setExpiryYear(acquisition.getExpiryYear());
		acquisition.setCvvCode(acquisition.getCvvCode());
    }
    public void payNowOnline(Acquisition acquisition){

    	//TODO remove comment
    	if(acquisition.getCardType()==acquisition.getVisaDebit())
    	{
    		acquisition.setCardNumber(acquisition.getcardNumberVDebit());
    		acquisition.setExpiryMonth(acquisition.getexpiryMonthVDebit());
    		acquisition.setExpiryYear(acquisition.getexpiryYearVDebit());
    		acquisition.setCvvCode(acquisition.getcvvCodeVDebit());
    	}
    	else if(acquisition.getCardType()==acquisition.getVisaDelta())
    	{
    		acquisition.setCardNumber(acquisition.getcardNumberVDelta());
    		acquisition.setExpiryMonth(acquisition.getexpiryMonthVDelta());
    		acquisition.setExpiryYear(acquisition.getexpiryYearVDelta());
    		acquisition.setCvvCode(acquisition.getcvvCodeVDelta());
    	}
    	else if(acquisition.getCardType()==acquisition.getMaestro())
    	{
    		acquisition.setCardNumber(acquisition.getcardNumberMaestro());
    		acquisition.setExpiryMonth(acquisition.getexpiryMonthMaestro());
    		acquisition.setExpiryYear(acquisition.getexpiryYearMaestro());
    		acquisition.setCvvCode(acquisition.getcvvCodeMaestro());
    	}
    	
    	else if(acquisition.getCardType()==acquisition.getMasterCard())
    	{
    		acquisition.setCardNumber(acquisition.getcardNumberMaster());
    		acquisition.setExpiryMonth(acquisition.getexpiryMonthMaster());
    		acquisition.setExpiryYear(acquisition.getexpiryYearMaster());
    		acquisition.setCvvCode(acquisition.getcvvCodeMaster());
    	}
    	
        /*if (browser.isTextPresent(pageProperties.getProperty("Acquisition.PayNowOnlineref")))
        {
            browser.clickWithLinkText(pageProperties.getProperty("Acquisition.PayNowOnlineref"));
            Report.updateTestLog("Navigate to Pay Now Online Page", "PASS");

            browser.wait(getWaitTime());*/
         if(browser.isElementVisible(pageProperties.getProperty("Acquisition.PayNowRadio")))
         {
        	 browser.click(pageProperties.getProperty("Acquisition.PayNowRadio"));
        	 Report.updateTestLog("Pay Now option is selected", "PASS");
         
         	browser.wait(getWaitTime());
         }

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
        else if(browser.isElementVisible(pageProperties.getProperty("Acquisition.PaymentOptionsContinue2"))){
            browser.click(pageProperties.getProperty("Acquisition.PaymentOptionsContinue1"));
            Report.updateTestLog("Payment Details Details Page continue button is clicked successfully", "PASS");
         }
         browser.wait(getWaitTime());
         
         //verified by visa submit button(occurs when the proxy is enabled)
         
         browser.wait(3000);
if(browser.isElementVisibleWithXpath(".//*[@id='message']/iframe"))
{
 		UIDriver driver = WebDriverProvider.getCurrentDriver();

 		driver.switchTo().frame(
 				driver.findElement(By.xpath(".//*[@id='message']/iframe")));
 		verifyIsElementVisibleWithXpath(
 				"html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/input",
 				"Security Check page");
 		verifyIsElementVisibleWithXpath(
 				"html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/input",
 				"Security Check submit field");
 		verifyAndClickWithXpath(
 				"html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/input",
 				"Security check submit button");
 		browser.wait(1000);
 		Alert alert =  driver.switchTo().alert();
		alert.accept();
 		browser.swtichToDefaultContent();
}
         /*if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.VerifiedVisaSubmit"))){
            browser.clickWithXpath(pageProperties.getProperty("Acquisition.VerifiedVisaSubmit"));
            Report.updateTestLog("Verification Submit button is clicked successfully", "PASS");
         }*/
 		

 		if(browser.isElementVisible(pageProperties.getProperty("Acquisition.PaymentOptionsContinue2"))){
            browser.click(pageProperties.getProperty("Acquisition.PaymentOptionsContinue1"));
            Report.updateTestLog("Payment Details Details Page continue button is clicked successfully", "PASS");
         }
   }
   
   public void payInNextMonth()
   {
   	if(browser.isElementVisible(pageProperties.getProperty("Acquisition.IncludeInMonthlyBill")))
   	{
   		browser.click(pageProperties.getProperty("Acquisition.IncludeInMonthlyBill"));
   	}
   	if(browser.isElementVisible(pageProperties.getProperty("Acquisition.PaymentOptionsContinue2"))){
           browser.click(pageProperties.getProperty("Acquisition.PaymentOptionsContinue2"));
           Report.updateTestLog("Payment Details Details Page continue button is clicked successfully", "PASS");
        }
   	
   	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.payLaterContinue"))){
           browser.clickWithXpath(pageProperties.getProperty("Acquisition.payLaterContinue"));
           Report.updateTestLog("Payment Details Details Page continue button is clicked successfully", "PASS");
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
        else if(browser.isElementVisible(pageProperties.getProperty("Acquisition.PayDay2"))){
            browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.PayDay2"),acquisition.getPayDay());
            Report.updateTestLog("Payment Details Page Pay Day Field verification and value selected is "+acquisition.getPayDay(), "PASS");
   		}
		
		/*if(browser.isElementVisible(pageProperties.getProperty("Acquisition.PaymentOptionsgasbillday"))){
	       browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.PaymentOptionsgasbillday"),"Monthly");
	       browser.input(pageProperties.getProperty("Acquisition.PaymentOptionsgasAmt"), "1500");
	       Report.updateTestLog("Payment Details Page Gas Bill Period Field verification and value selected is : Monthly 1500 ", "PASS");
		}
		if(browser.isElementVisible(pageProperties.getProperty("Acquisition.PaymentOptionselecbillday"))){
		   browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.PaymentOptionselecbillday"),"Monthly");
		   browser.input(pageProperties.getProperty("Acquisition.PaymentOptionselecamt"), "1500");
		   Report.updateTestLog("Payment Details Page Electricity Bill Period Field verification and value selected is : Monthly 1500 ", "PASS");
	    }*/
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
        
        if(browser.isElementVisible(pageProperties.getProperty("Acquisition.partTarifConfirmation"))){
        	browser.click(pageProperties.getProperty("Acquisition.partTarifConfirmation"));
        	Report.updateTestLog("Payment Type Change confirmation overlay button is clicked successfully", "PASS");
        	
        }
        if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.ChangePayment"))){
            browser.clickWithXpath(pageProperties.getProperty("Acquisition.ChangePayment"));
            Report.updateTestLog("Change Payment button is clicked successfully", "PASS");
         }
        
        browser.wait(getWaitTime());
        
        if(browser.isElementVisible(pageProperties.getProperty("Acquisition.payTypeConfirmOverlay")))
        {
        	browser.click(pageProperties.getProperty("Acquisition.payTypeConfirmOverlay"));
        	Report.updateTestLog("Payment Type change confirmation overlay button is clicked successfully", "PASS");
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
            browser.clickWithXpath(pageProperties.getProperty("Acquisition.PaymentOptionsContinue"));
            errorPaymentMessageVerification();
        
        }
        public void validateSortCodeOneNumber(){
            
            
            browser.click(pageProperties.getProperty("Acquisition.PaymentRadioButton"));
            browser.input(pageProperties.getProperty("Acquisition.BankAccountNumber"),"01234567" );
            browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber2"),"40" );
            browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber3"),"40" );
            browser.input(pageProperties.getProperty("Acquisition.AccountName"),"Dhiru" );
            browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.PayDay"),"7" );
            browser.clickWithXpath(pageProperties.getProperty("Acquisition.PaymentOptionsContinue"));
            errorPaymentMessageVerification();
           
        
        }
        public void validateSortCodetwoNumber(){
            
            
            browser.click(pageProperties.getProperty("Acquisition.PaymentRadioButton"));
            browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber1"),"40" );
            
            browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber3"),"40" );
            browser.input(pageProperties.getProperty("Acquisition.AccountName"),"Dhiru" );
            browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.PayDay"),"7" );
            browser.clickWithXpath(pageProperties.getProperty("Acquisition.PaymentOptionsContinue"));
            errorPaymentMessageVerification();
        
        }
        public void validateSortCodethreeNumber(){
            
           
            browser.click(pageProperties.getProperty("Acquisition.PaymentRadioButton"));
            browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber1"),"40" );
            browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber2"),"40" );
           
            browser.input(pageProperties.getProperty("Acquisition.AccountName"),"Dhiru" );
            browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.PayDay"),"7" );
            browser.clickWithXpath(pageProperties.getProperty("Acquisition.PaymentOptionsContinue"));
            errorPaymentMessageVerification();
        
        }
        public void validateAccountName(){
            
            
            browser.click(pageProperties.getProperty("Acquisition.PaymentRadioButton"));
            browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber1"),"40" );
            browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber2"),"40" );
            browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber3"),"40" );
            browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.PayDay"),"7" );
            browser.clickWithXpath(pageProperties.getProperty("Acquisition.PaymentOptionsContinue"));
            errorPaymentMessageVerification();
        
        }
        
        public void errorPaymentMessageVerification() {
        	String paymentMessage;
        	
        	if (browser.isTextPresent(pageProperties.getProperty("Acquisition.GasElecErrorMessage"))){
        		browser.isTextPresent(pageProperties.getProperty("Acquisition.GasElecErrorMessage"));
        		Report.updateTestLog("Payment Details Details Page Error Validation"+pageProperties.getProperty("Acquisition.GasElecErrorMessage"), "PASS");
            }
            else{
            	Report.updateTestLog("Payment Details Details Page Error Validation", "FAIL");
            }





        	
        }
}