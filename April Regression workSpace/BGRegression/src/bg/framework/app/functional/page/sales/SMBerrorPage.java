package bg.framework.app.functional.page.sales;

import java.util.ArrayList;
import java.util.Properties;

import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.UserProfile;

import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.reFactoring.RegistrationPage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class SMBerrorPage extends BasePage{
	private final static String FILE_NAME = "resources/ReFactoring/BGAcquisition.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
    
	public void verifyBankdetailsSMBPage(UserProfile userProfile,ArrayList<String> errList){         
           
            String[] BankAccountNumber	= {"asrg",		"",			"01234567",			"01234567", 	"01234567", 	"01234567",	 	"01234567"};
            String[] SotrCodeNumber1 	= {"40",		"40",		"",	 				"qw", 			"40",			"40", 			"40"};
            String[] SotrCodeNumber2 	= {"40",		"40",		"",	 				"qw", 			"40",			"40", 			"40"};
            String[] SotrCodeNumber3 	= {"40",		"40",		"",	 				"qw", 			"40", 			"40", 			"40"};
            String[] AccountName 		= {"Diru",		"Diru",		"Diru",	 			"Diru", 		"",				"@@@@@@@@@@", 	"Diru"};
            //String[] Billdate 		= {"1",			"1", 		"1",				"1", 			"1",			 "1", 			"1"};
            
            for (int i=0;i<=6;i++){
            		          	
                browser.input(pageProperties.getProperty("Acquisition.BankAccountNumber"),BankAccountNumber[i]);
                browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber1"),SotrCodeNumber1[i]);                
                browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber2"),SotrCodeNumber2[i]);                
                browser.input(pageProperties.getProperty("Acquisition.SotrCodeNumber3"),SotrCodeNumber3[i]);                
                browser.input(pageProperties.getProperty("Acquisition.AccountName"),AccountName[i] );
                //browser.input(pageProperties.getProperty("SMB.Billdate"),Billdate[i]);
             //   String dropbilldate=browser.getTextByXpath(pageProperties.getProperty("SMB.Billdatevalue"));
            //    browser.selectfromDropBox("id", pageProperties.getProperty("SMB.Billdate"),dropbilldate);
                
                if (i==6)
                	{
                		verifyAndClick(pageProperties.getProperty("SMB.Confirm"), "Confirm Button");
                		// browser.clickWithXpath(pageProperties.getProperty("SMB.T&C"));
                		//browser.clickWithXpath(pageProperties.getProperty("SMB.T&C"));
                	}
                else                
                	{
                		browser.clickWithXpath(pageProperties.getProperty("SMB.T&C"));
                	  	verifyAndClick(pageProperties.getProperty("SMB.Confirm"), "Confirm Button");
                	}
                
                if(browser.isElementVisible(pageProperties.getProperty("SMB.MFDD"))) 
           			verifyAndClick(pageProperties.getProperty("SMB.MFDD"), "Confirm Click");
                
                new RegistrationPage().verifyErrorMsg(browser.getTextByXpath("//*[@class='error']/ul[1]")
    					,errList.get(i),"Bank Page Error");
            }
	}
	
	public void verifyPaymentdetailsSMBPage(UserProfile userProfile,ArrayList<String> errList){
		
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("SMB.Iwillpaythesenow"))&&browser.isElementVisibleWithXpath(pageProperties.getProperty("SMB.Includethisinmybill")))
		{
			verifyAndClickWithXpath(pageProperties.getProperty("SMB.Iwillpaythesenow"), "Pay Now By Payment Card");
		}
		
		String[] CardType 			= {"Select",			"Visa Debit",	"Visa Debit",			"Visa Debit",		"Visa Debit"};
        String[] Nameoncard 		= {"Test",				"Test",			"Test",					"Test",				"Test"};
        String[] CardNumber 		= {"4539791001730106",	"45397910",		"4539791001730106",		"4539791001730106",	"4539791001730106"};
        String[] StartDateMonth 	= {"11",				"11",			"11",					"11",				"11"};
        String[] StartDateYear 		= {"2008",				"2008",			"2013",					"2008",				"2008"};
        String[] ExpiryDateMonth	= {"3",					"3",			"3",					"3",				"3"};
        String[] ExpiryDateYear		= {"2014",				"2014",			"2013",					"2014",				"2014"};
        String[] CVVNumber 			= {"123",				"123",			"123",					"@#",				""};
        
        for (int i=0;i<CardType.length;i++){
        	//browser.input(pageProperties.getProperty("SMB.cleardebt"),dueamount[i] );        	
        	browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.CardType"),CardType[i]);
        	browser.input(pageProperties.getProperty("Acquisition.NameOnCard"),Nameoncard[i]);                
        	browser.input(pageProperties.getProperty("Acquisition.CardNumber"),CardNumber[i] );  
        	browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.StartDateMonth"),StartDateMonth[i]);
            browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.StartDateYear"),StartDateYear[i]);
            browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.ExpiryDateMonth"),ExpiryDateMonth[i]);
            browser.selectfromDropBox("id",pageProperties.getProperty("Acquisition.ExpiryDateYear"),ExpiryDateYear[i]);
            browser.input(pageProperties.getProperty("Acquisition.CVVNumber"),CVVNumber[i]);
           // browser.clickWithXpath(pageProperties.getProperty("SMB.T&C"));
            verifyAndClick(pageProperties.getProperty("SMB.Submit"), "Submit Button");
            browser.clearValue(pageProperties.getProperty("Acquisition.NameOnCard"));                
        	browser.clearValue(pageProperties.getProperty("Acquisition.CardNumber"));  
        	browser.clearValue(pageProperties.getProperty("Acquisition.CVVNumber"));
           		           
            new RegistrationPage().verifyErrorMsg(browser.getTextByXpath("//*[@class='error']/ul[1]")
					,errList.get(i),"Payment Page Error");
            }	
	}

	
	public void verifyRevieworderdetailsSMBPage(UserProfile userProfile,ArrayList<String> errList){
		
	// for (int i=0;i<1;i++){
		 
		// if(browser.isSelected(pageProperties.getProperty("Acquisition.TermsandConditions")))
     	/*{
         browser.click(pageProperties.getProperty("Acquisition.TermsandConditions"));
         browser.click(pageProperties.getProperty("Acquisition.TermsandConditions"));} */
		 verifyAndClick(pageProperties.getProperty("SMB.submitbutton"), "Submit Button");
                     
            new RegistrationPage().verifyErrorMsg(browser.getTextByXpath("//*[@class='error']/ul[1]")
					,errList.get(0),"Review Order Page Error");
            
	 }

	public void verifysupplyaddressSMB(UserProfile userProfile,ArrayList<String> errList){
		verifyIsElementVisibleById(pageProperties.getProperty("SMB.SelectAddress"), "Address drop down box");
    	if (browser.isElementVisible(pageProperties.getProperty("SMB.SelectAddress"))) {
   		
   	        Report.updateTestLog("Confirm address page is loaded successfully" , "PASS");
   	    } else {
   	        Report.updateTestLog("Confirm address page is not loaded successfully", "FAIL");
   	    }
    	
   		 String dropdata=browser.getTextByXpath(pageProperties.getProperty("SMB.Addressdropdowntest"));
   	        browser.selectfromDropBox("id", pageProperties.getProperty("SMB.SelectAddress"),dropdata);
   	     browser.click(pageProperties.getProperty("SMB.addresserror"));
   	  new RegistrationPage().verifyErrorMsg(browser.getTextByXpath("//*[@class='error']/ul[1]")
				,errList.get(0),"Supplyaddress page");
	}


	public void verifyforcelogindetailsSMBPage(UserProfile userProfile,ArrayList<String> errList){         
    
    String[] Email 		= {"asdf", 			"",				"kimhamilton@bgdigitaltest.co.uk" };
    String[] Password 	= {"password12",	"password12", 	""};
    
    	browser.clickWithXpath(pageProperties.getProperty("SMB.LogintoYourOnlineAccount"));
    	
    	    	
    for (int i=0;i<Email.length;i++){    	          	
    	browser.input(pageProperties.getProperty("Acquisition.LoginYourOrderPage"),Email[i]);
    	browser.input(pageProperties.getProperty("Acquisition.PasswordYourOrderPage"),Password[i]);                
        browser.click(pageProperties.getProperty("Acquisition.LoginButtonYourOrderPage"));
        browser.clearValue(pageProperties.getProperty("Acquisition.LoginYourOrderPage"));
    	browser.clearValue(pageProperties.getProperty("Acquisition.PasswordYourOrderPage"));
        new RegistrationPage().verifyErrorMsg(browser.getTextByXpath("//*[@class='error']/ul[1]")
				,errList.get(i),"Login Page Error");}
        }
	

	public void verifyforceregistrationdetailsSMBPage(UserProfile userProfile,ArrayList<String> errList){         
	    
	    String[] AccountNumberYourOrderPage 	= {"sd",							"850008193043", 					 "850008193043",				    "850008193043",		"850008193043"};
	    String[] TitleYourOrderPage 			= {"Mr",							"Mr",   							 "Mr",							    "Mr",				"Mr"};
	    String[] FirstNameYourOrderPage			= {"Kim",							"12",    						 "Kim",								"Kim",				"Kim"};
	    String[] LastNameYourOrderPage 			= {"Hamilton",						"Hamilton",   					 "",								"Hamilton",			"Hamilton"};
	    String[] EmailAddressYourOrderPage 		= {"kimhamilton@bgdigitaltest.co.uk","kimhamilton@bgdigitaltest.co.uk","kimhamilton@bgdigitaltest.co.uk", "kimhamilton@bgd",	"kimhamilton@bgdigitaltest.co.uk"};
	    String[] CreatePasswordYourOrderPage 	= {"password12",					 "password12", 					 "password12",						"password12",		"passwor"};
	    String[] RetypePasswordYourOrderPage 	= {"password12",					 "password12",  					 "password12",						"password12",		"passwor"};
	    
	    browser.clickWithXpath(pageProperties.getProperty("SMB.RegisterforOnlineAccount"));   
	   
	    for (int i=0;i<AccountNumberYourOrderPage.length;i++)
	    {
	    	browser.input(pageProperties.getProperty("Acquisition.AccountNumberYourOrderPage"),	AccountNumberYourOrderPage[i]);          	
	        browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.TitleYourOrderPage"),TitleYourOrderPage[i]);
	        browser.input(pageProperties.getProperty("Acquisition.FirstNameYourOrderPage"),FirstNameYourOrderPage[i]);
	        browser.input(pageProperties.getProperty("Acquisition.LastNameYourOrderPage"),LastNameYourOrderPage[i]);
	        browser.input(pageProperties.getProperty("Acquisition.EmailAddressYourOrderPage"),EmailAddressYourOrderPage[i]);
	        browser.input(pageProperties.getProperty("Acquisition.CreatePasswordYourOrderPage"),CreatePasswordYourOrderPage[i]);
	        browser.input(pageProperties.getProperty("Acquisition.RetypePasswordYourOrderPage"),RetypePasswordYourOrderPage[i]);
	       browser.clickWithXpath(pageProperties.getProperty("Acquisition.YourOrderContinueForcedRegistration"));
	       browser.clearValue(pageProperties.getProperty("Acquisition.AccountNumberYourOrderPage"));          	
	       //browser.clearValue(pageProperties.getProperty("Acquisition.TitleYourOrderPage"));
	        browser.clearValue(pageProperties.getProperty("Acquisition.FirstNameYourOrderPage"));
	        browser.clearValue(pageProperties.getProperty("Acquisition.LastNameYourOrderPage"));
	        browser.clearValue(pageProperties.getProperty("Acquisition.EmailAddressYourOrderPage"));
	        browser.clearValue(pageProperties.getProperty("Acquisition.CreatePasswordYourOrderPage"));
	        browser.clearValue(pageProperties.getProperty("Acquisition.RetypePasswordYourOrderPage"));
	        new RegistrationPage().verifyErrorMsg(browser.getTextByXpath("//*[@class='error']/ul[1]")
					,errList.get(i+3),"Registration Page Error");
	        }
		}
	}

            
            
	
