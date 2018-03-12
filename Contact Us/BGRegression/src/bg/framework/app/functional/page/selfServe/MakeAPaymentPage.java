package bg.framework.app.functional.page.selfServe;

import static watij.finders.SymbolFactory.href;
import static watij.finders.SymbolFactory.id;
import static watij.finders.SymbolFactory.text;
import static watij.finders.SymbolFactory.title;
import static watij.finders.SymbolFactory.xpath;

import java.util.Properties;

import org.openqa.selenium.internal.seleniumemulation.IsTextPresent;

import watij.runtime.ie.IE;
import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.MakeAPaymentProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.RobotSendKeys;

public class MakeAPaymentPage extends BasePage{
	 private final static String FILE_NAME = "resources/selfServe/MakePaymentCardDetailsPage.properties";
	    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	    
	    
	    
	    IE ie;
	    String strAmountToPay  = "";
	    
	    /*
		 * Method : loginMakeAPayment   Created On: 19-06-2012
		 * Description: Method to navigate to login page and login to the application
		 */
	   
	    public void loginMakeAPayment(MakeAPaymentProfile makeAPaymentProfile,String strAccountType)
	    {
	    	try {
	    		Report.createTestLogHeader("Make A Payment - ".concat(makeAPaymentProfile.getCardType().toString()), strAccountType);		    	
		    		ie = new IE();
					//ie.start("http://10.224.70.111");
					ie.start(ApplicationConfig.APP_BG_URL.toString());
				
		    	ie.maximize();     
		         
		        
		        ie.focus();
		    	 
		        Thread.sleep(10000);	        
		        
		        RobotSendKeys.type(pageProperties.getProperty("Proxy.UserName").toString());
		        RobotSendKeys.type("\t");
		        RobotSendKeys.type(pageProperties.getProperty("Proxy.Password").toString());	        
		        RobotSendKeys.type("\t");
		        RobotSendKeys.typeenter();
 
		        
		        ie.focus();
		        
		        Thread.sleep(1000);
		        if(ie.link(text, pageProperties.getProperty("LoginLink").toString()).exists())
		        {
		        	
		        	Thread.sleep(1000);
		        	Report.updateTestLog("Login Link Present", "PASS");    			        	
		        ie.link(text, pageProperties.getProperty("LoginLink").toString()).click();		        
		        	Report.updateTestLog("Login Link Clicked", "DONE");
		        
		        
		        
		        }
		        else
		        {		        
		        Report.updateTestLog("Login Link Present", "FAIL");
		        Report.updateTestLog("Login Link Clicked", "FAIL");
		        }	   
		        
		        ie.link(text, pageProperties.getProperty("CertificateContinueLink").toString()).click();
		        
		        Thread.sleep(5000);
		      
		        if(ie.textField(id, pageProperties.getProperty("Login.UserName")).exists())
		        {
		        	Report.updateTestLog("UserName Field Present", "PASS");
		        ie.textField(id, pageProperties.getProperty("Login.UserName")).set(makeAPaymentProfile.getEmail());		        
		        Report.updateTestLog("Value Entered in UserName Field", "DONE");
		        }
		        else
		        {
		        	Report.updateTestLog("UserName Field Present", "FAIL");
			        Report.updateTestLog("Value Entered in UserName Field", "FAIL");
		        }
		        
		        if(ie.textField(id, pageProperties.getProperty("Login.Password").toString()).exists())
		        {
		        	Report.updateTestLog("Password Field Present", "PASS");
		        ie.textField(id, pageProperties.getProperty("Login.Password").toString()).set(makeAPaymentProfile.getPassword());		        
		        Report.updateTestLog("Value Entered  in Password Field", "DONE");
		        }
		        else
		        {
		        	Report.updateTestLog("Password Field Present", "FAIL");
		        	Report.updateTestLog("Value Entered  in Password Field", "FAIL");
		        }	        
		       
		        if(ie.button(title,pageProperties.getProperty("Login.Submit").toString()).exists())
		        {
		        	Report.updateTestLog("Login Button Present", "PASS");
		        ie.button(title,pageProperties.getProperty("Login.Submit").toString()).click();		        
		        Report.updateTestLog("Login Button Clicked", "DONE");
		        }
		        else
		        {
		        	Report.updateTestLog("Login Button Present", "FAIL");
		        	Report.updateTestLog("Login Button Clicked", "FAIL");
		        }
	    	} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
	    }
	    
	    /*
		 * Method : navigateToMakeAPayment   Created On: 19-06-2012
		 * Description: Method to navigate to Make a payment page 
		 */
	    
	    public void navigateToMakeAPayment(MakeAPaymentProfile makeAPaymentProfile,String strAccountType)
	    {
	    	try
	    	{
	    		Thread.sleep(10000);	        
	    		
	    		
	    		if(strAccountType.equalsIgnoreCase("GasAccount"))
	    		{		       
	    			if(ie.link(xpath,pageProperties.getProperty("AccountSummaryPage.ManageAccLinkx").replace("USERACCOUNTNUMBER",makeAPaymentProfile.getGasAccount())).exists())
			        {
	    				Report.updateTestLog("Manage Account Link Present", "PASS");
	    				ie.link(xpath,pageProperties.getProperty("AccountSummaryPage.ManageAccLinkx").replace("USERACCOUNTNUMBER",makeAPaymentProfile.getGasAccount())).click();
	    			
			        Report.updateTestLog("Manage Account Link Clicked", "DONE");
			        }
			        else
			        {
			        	Report.updateTestLog("Manage Account Link not Present", "FAIL");
			        	Report.updateTestLog("Manage Account Link Clicked", "FAIL");
			        }
	    		}
	    		
	    		
	    		if(strAccountType.equalsIgnoreCase("ElectricityAccount"))
	    		{
		         if(ie.link(xpath,pageProperties.getProperty("AccountSummaryPage.ManageAccLinkx").toString().replace("USERACCOUNTNUMBER", makeAPaymentProfile.getElecAccount())).exists())
		         {
		        	 Report.updateTestLog("Manage Account Link Present", "PASS");
		         ie.link(xpath, pageProperties.getProperty("AccountSummaryPage.ManageAccLinkx").toString().replace("USERACCOUNTNUMBER", makeAPaymentProfile.getElecAccount())).click();	
		         		         Report.updateTestLog("Manage Account Link Clicked", "DONE");
		         }
		         else
		         {
		        	Report.updateTestLog("Manage Account Link Present", "FAIL");
		        	Report.updateTestLog("Manage Account Link Clicked", "FAIL");
		         }
	    		}
	    		
	    		
	    		if(strAccountType.equalsIgnoreCase("JIAccount"))
	    		{
	    			if(ie.link(xpath,pageProperties.getProperty("AccountSummaryPage.ManageAccLinkx").toString().replace("USERACCOUNTNUMBER", makeAPaymentProfile.getAccNumber())).exists())
			        {
	    				Report.updateTestLog("Manage Account Link Present", "PASS");
			        ie.link(xpath, pageProperties.getProperty("AccountSummaryPage.ManageAccLinkx").toString().replace("USERACCOUNTNUMBER", makeAPaymentProfile.getAccNumber())).click();	
			        			        Report.updateTestLog("Manage Account Link Clicked", "DONE");
			        }
			        else
			        {
			        	Report.updateTestLog("Manage Account Link Present", "FAIL");
			        	Report.updateTestLog("Manage Accounsecbecky1		" +
			        			"t Link Clicked", "FAIL");
			        }
	    			
	    		}
	    		if(strAccountType.equalsIgnoreCase("Direct Debit-JIAccount"))
	    		{
	    			if(ie.link(xpath,pageProperties.getProperty("AccountSummaryPage.ManageAccLinkx").toString().replace("USERACCOUNTNUMBER", makeAPaymentProfile.getAccNumber())).exists())
			        {
	    				Report.updateTestLog("Manage Account Link Present", "PASS");
			        ie.link(xpath, pageProperties.getProperty("AccountSummaryPage.ManageAccLinkx").toString().replace("USERACCOUNTNUMBER", makeAPaymentProfile.getAccNumber())).click();	
			        			        Report.updateTestLog("Manage Account Link Clicked", "DONE");
			        }
			        else
			        {
			        	Report.updateTestLog("Manage Account Link Present", "FAIL");
			        	Report.updateTestLog("Manage Accounsecbecky1		" +
			        			"t Link Clicked", "FAIL");
			        }
	    		}
	    		
	    		
	    		if(strAccountType.equalsIgnoreCase("DualAccount"))
	    		{
	    			if(ie.link(xpath,pageProperties.getProperty("AccountSummaryPage.ManageAccLinkx").toString().replace("USERACCOUNTNUMBER", makeAPaymentProfile.getElecAccount())).exists())
			        {
	    				Report.updateTestLog("Manage Account Link Present", "PASS");
			        ie.link(xpath, pageProperties.getProperty("AccountSummaryPage.ManageAccLinkx").toString().replace("USERACCOUNTNUMBER", makeAPaymentProfile.getElecAccount())).click();	
			        			        Report.updateTestLog("Manage Account Link Clicked", "DONE");
			        }
			        else
			        {
			        	Report.updateTestLog("Manage Account Link Present", "FAIL");
			        	Report.updateTestLog("Manage Account Link Clicked", "FAIL");
			        }
	    		}
	    		
	    				        
		        Thread.sleep(4000);
		        
		        if(ie.link(text, pageProperties.getProperty("AccountOverviewPage.PaymentsLink").toString()).exists())
		        {
		        	Report.updateTestLog("Payment Link Present", "PASS");
		        ie.link(text, pageProperties.getProperty("AccountOverviewPage.PaymentsLink").toString()).click();
		        		        Report.updateTestLog("Payment Link Clicked", "DONE");
		        }
		        else
		        {
		        	Report.updateTestLog("Payment Link Present", "FAIL");
		        	Report.updateTestLog("Payment Link Clicked", "FAIL");
		        }
		        
		        Thread.sleep(3000);
		        
		        if(ie.link(text, pageProperties.getProperty("AccountPayments.MakeAPaymentLink").toString()).exists())
		        {
		        	Report.updateTestLog("Make A Payment Link Present", "PASS");
		        ie.link(text, pageProperties.getProperty("AccountPayments.MakeAPaymentLink").toString()).click();
		        		        Report.updateTestLog("Make A Payment Link Clicked", "DONE");
		        }
		        else
		        {
		        	Report.updateTestLog("Make A Payment Link Present", "FAIL");
		        	Report.updateTestLog("Make A Payment Link Clicked", "FAIL");
		        }   
		        
	    	}
	     catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
	    }
	    
	    /*
		 * Method : selectAccountToMakeAPayment   Created On: 19-06-2012
		 * Description: Method to select the account to make a payment
		 */
	    
	    public void selectAccountToMakeAPayment(MakeAPaymentProfile makeAPaymentProfile,String strAccountType)
	    {
	     try
	     {
	    	 Thread.sleep(3000);
	    	 String str1 = ".//*[@value='";
	    	 if(strAccountType.equalsIgnoreCase("GasAccount"))
	    	 {
	    	 str1 = str1.concat(makeAPaymentProfile.getGasAccount());
	    	 }
	    	 else if(strAccountType.equalsIgnoreCase("ElectricityAccount"))
	    	 {
	    		 str1 = str1.concat(makeAPaymentProfile.getElecAccount());
	    	 }
	    	 else if(strAccountType.equalsIgnoreCase("JIAccount"))
	    	 {
	    		 str1 = str1.concat(makeAPaymentProfile.getAccNumber());
	    	 }
	    	 else if(strAccountType.equalsIgnoreCase("Direct Debit-JIAccount"))
	    	 {
	    		 str1 = str1.concat(makeAPaymentProfile.getAccNumber());
	    	 }
	    	 else if(strAccountType.equalsIgnoreCase("DualAccount"))
	    	 {
	    		 str1 = str1.concat(makeAPaymentProfile.getElecAccount());
	    	 }
	    	 
	    	 str1 = str1.concat("']");
	    	 
	    	 
	    	 
	    	    if(ie.radio(xpath, str1).exists())
	    	    {
	    	    	Report.updateTestLog("Select Account Radio Button Present", "PASS");
		        ie.radio(xpath, str1).click();
		        		        Report.updateTestLog("Select Account Radio Button Clicked", "DONE");
	    	    }
	    	    else
	    	    {
	    	    	Report.updateTestLog("Select Account Radio Button Present", "FAIL");
	    	    	Report.updateTestLog("Select Account Radio Button Clicked", "FAIL");
	    	    }
	    	    
		        Thread.sleep(3000);
		        
		        if(ie.button(title, pageProperties.getProperty("MakeAPaymentPage.Continue").toString()).exists())
		        {
		        	Report.updateTestLog("Continue Button Present", "PASS");
		        ie.button(title, pageProperties.getProperty("MakeAPaymentPage.Continue").toString()).click();
		        		        Report.updateTestLog("Continue Button Clicked", "DONE");
		        }
		        else
		        {
		        	Report.updateTestLog("Continue Button Present", "FAIL");
		        	Report.updateTestLog("Continue Button Clicked", "FAIL");
		        }
		        
		        Thread.sleep(3000);
	     }
	     catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
	    	    
	    
	    /*
		 * Method : enterDetailsToMakeAPayment   Created On: 19-06-2012
		 * Description: Method to enter the details to the payment page
		 */
	    public void enterDetailsToMakeAPayment(MakeAPaymentProfile makeAPaymentProfile)
	    {
	    	try
	    	{
	    		
	    		Thread.sleep(3000);
	    		
	    		if(ie.textField(id, pageProperties.getProperty("cardAmount").toString()).exists())
	    		{
	    			Report.updateTestLog("Amount To Pay Is Present", "PASS");
	    		ie.textField(id, pageProperties.getProperty("cardAmount").toString()).set("10.00");
	    			    		Report.updateTestLog("Value Entered in Amount To Pay Field", "PASS");
	    		}
	    		else
	    		{
	    			Report.updateTestLog("Amount To Pay Is Present", "FAIL");
	    			Report.updateTestLog("Value Entered in Amount To Pay Field", "FAIL");
	    		}
	    		
	    		
	    		
		        strAmountToPay = ie.textField(id, pageProperties.getProperty("cardAmount").toString()).text().toString();
		        
		        
		            
		       
		        if(ie.selectList(id, pageProperties.getProperty("cardType").toString()).exists())
		        {
		        	Report.updateTestLog("Select Card Type Is Present", "PASS");
		        	try
		        	{
		        ie.selectList(id, pageProperties.getProperty("cardType").toString()).select(makeAPaymentProfile.getCardType().toString());
		        		        Report.updateTestLog("Value Selected in Card Type Field", "DONE");
		        	}
		        	catch (Exception e) {
						// TODO: handle exception
		        		Report.updateTestLog("Value Selected in Card Type Field", "FAIL");
					}
		        }
		        else
		        {
		        	Report.updateTestLog("Select Card Type Is Present", "FAIL");
		        	Report.updateTestLog("Value Selected in Card Type Field", "FAIL");
		        }        
		        
		        
		        
		        if(ie.textField(id, pageProperties.getProperty("cardName").toString()).exists())
		        {
		        	Report.updateTestLog("Card Name Field Present", "PASS");
		        	try
		        	{
		        ie.textField(id, pageProperties.getProperty("cardName").toString()).set(makeAPaymentProfile.getCardName().toString());
		        		        Report.updateTestLog("Value Entered in Card Name Field", "DONE");
		        	
		        }
	        	catch (Exception e) {
					// TODO: handle exception
	        		Report.updateTestLog("Value Entered in Card Name Field", "FAIL");
				}
		        }
		        else
		        {
		        	Report.updateTestLog("Card Name Field Present", "FAIL");
		        	
		        }
		        if(ie.textField(id, pageProperties.getProperty("cardNumber").toString()).exists())
		        {
		        	Report.updateTestLog("Card Number Is Present", "PASS");
		        	try
		        	{
		        ie.textField(id, pageProperties.getProperty("cardNumber").toString()).set(makeAPaymentProfile.getCardNumber().toString());
		        		        Report.updateTestLog("Value Entered in Card Number Is Present", "DONE");
		        	}
		        	catch (Exception e) {
						// TODO: handle exception
		        		Report.updateTestLog("Value Entered in Card Number Is Present", "FAIL");
					}
			        
		        	
		        }
		        else
		        {
		        	Report.updateTestLog("Card Number Is Present", "FAIL");
		        	
		        }
		        
		        if(makeAPaymentProfile.getCardType().toString() == "Visa Debit")
		        {
		        if(ie.selectList(id, pageProperties.getProperty("cardStartMonth").toString()).exists())
		        {
		        	Report.updateTestLog("Card Start Month Select Is Present", "PASS");
		        ie.selectList(id, pageProperties.getProperty("cardStartMonth").toString()).select(makeAPaymentProfile.getCardStartMonth().toString());
		        		        Report.updateTestLog("Value Selected in Card Start Month Select Field", "DONE");
		        }
		        else
		        {
		        	Report.updateTestLog("Card Start Month Select Is Present", "FAIL");
		        	Report.updateTestLog("Value Selected in Card Start Month Select Field", "FAIL");
		        }
		        	
		        if(ie.selectList(id, pageProperties.getProperty("cardStartYear").toString()).exists())
		        {
		        	Report.updateTestLog("Card Start Year Is Present", "PASS");
		        ie.selectList(id, pageProperties.getProperty("cardStartYear").toString()).select(makeAPaymentProfile.getCardStartYear().toString());
		        		        Report.updateTestLog("Value Selected in Card Start Year Select Field", "DONE");
		        }
		        else
		        {
		        	Report.updateTestLog("Card Start Year Select Is Present", "FAIL");
		        	Report.updateTestLog("Value Selected in Card Start Year Select Field", "FAIL");
		        }
		        }
		        
		        
		        if(ie.selectList(id, pageProperties.getProperty("cardExpiryMonth").toString()).exists())
		        {
		        	Report.updateTestLog("Card Expiry Month Select Is Present", "PASS");
		        ie.selectList(id, pageProperties.getProperty("cardExpiryMonth").toString()).select(makeAPaymentProfile.getCardEndMonth().toString());
		        		        Report.updateTestLog("Value Selected in Card Expiry Month Select Field", "DONE");
		        }
		        else
		        {
		        	Report.updateTestLog("Card End Month Select Is Present", "FAIL");
		        	Report.updateTestLog("Value Selected in Card End Month Select Field", "FAIL");
		        }
		        if(ie.selectList(id, pageProperties.getProperty("cardExpiryYear").toString()).exists())
		        {
		        	Report.updateTestLog("Card Expiry Year Select Is Present", "PASS");
		        ie.selectList(id, pageProperties.getProperty("cardExpiryYear").toString()).select(makeAPaymentProfile.getCardEndYear().toString());
		        		        Report.updateTestLog("Value Selected in Card Expiry Year Select Field", "DONE");
		        }
		        else
		        {
		        	Report.updateTestLog("Card Expiry Year Select Is Present", "FAIL");
		        	Report.updateTestLog("Value Selected in Card Expiry Year Select Field", "FAIL");
		        }
		        if(ie.textField(id, pageProperties.getProperty("cardCVV").toString()).exists())
		        {
		        	Report.updateTestLog("Card CVV Number Field Is Present", "PASS");
		        ie.textField(id, pageProperties.getProperty("cardCVV").toString()).set(makeAPaymentProfile.getcardCVV().toString());
		        		        Report.updateTestLog("Value Entered in Card CVV Number Field", "DONE");
		        }
		        else
		        {
		        	Report.updateTestLog("Card CVV Number Field Is Present", "FAIL");
		        	Report.updateTestLog("Value Entered in Card CVV Number Field", "FAIL");
		        }	        
		        
		        
		        if(ie.button(title, pageProperties.getProperty("MakeAPaymentPage.Continue").toString()).exists())
		        {
		        	Report.updateTestLog("Continue Button Is Present", "PASS");
		        ie.button(title, pageProperties.getProperty("MakeAPaymentPage.Continue").toString()).click();
		        		        Report.updateTestLog("Continue Button Is Clicked", "DONE");
		        }
		        else
		        {
		        	Report.updateTestLog("Continue Button Is Present", "FAIL");
		        	Report.updateTestLog("Continue Button Is Clicked", "FAIL");
		        }		        
		        
	    	}
	    	catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    
	    /*
		 * Method : ConfirmSecurityCheck   Created On: 19-06-2012
		 * Description: Method to Verify the security check page
		 */
	    public void ConfirmSecurityCheck(MakeAPaymentProfile makeAPaymentProfile)
	    {
	    	try
	    	{
	    		Thread.sleep(3000);
	    		
	    		if(ie.button(title, pageProperties.getProperty("ConfirmationPage.PayNowLink").toString()).exists())
	    		{
	    			Report.updateTestLog("PayNow Button Is Present", "PASS");
		        ie.button(title, pageProperties.getProperty("ConfirmationPage.PayNowLink").toString()).click();
		        		        Report.updateTestLog("PayNow Button Is Clicked", "DONE");
	    		}
	    		else
	    		{
	    			Report.updateTestLog("PayNow Button Is Present", "FAIL");
	    			Report.updateTestLog("PayNow Button Is Clicked", "FAIL");
	    		}
		        Thread.sleep(15000);
		        System.out.print(makeAPaymentProfile.getcardSecurityNumber().toString());
		        if(makeAPaymentProfile.getCardType().toString().equalsIgnoreCase("Visa Debit"))
		        {
		        	
		        ie.link(text, pageProperties.getProperty("SecurityCheckPage.BookMark").toString()).focus();
		        
		        
		        /*try
		        {
		        if(ie.button(xpath, pageProperties.getProperty("SecurityCheckPage.Submit")).exists())
	        	{
	        		Report.updateTestLog("Submit Button Is Present", "PASS");
	        		Report.updateTestLog("Submit Button Is Clicked", "DONE");
	        	}
	        	else
	        	{
	        		Report.updateTestLog("Submit Button Is Present", "FAIL");
	        		Report.updateTestLog("Submit Button Is Clicked", "FAIL");
	        	}
		        }
		        catch (Exception e) {
					// TODO: handle exception
				}*/
		        RobotSendKeys.type("\t");
		        RobotSendKeys.type("\t");
		        RobotSendKeys.type("\t");
		        RobotSendKeys.typeenter();
		        }
		        else if(makeAPaymentProfile.getCardType().toString().equalsIgnoreCase("Maestro"))
		        {
		        	RobotSendKeys.type(makeAPaymentProfile.getcardSecurityNumber().toString());
		        	Report.updateTestLog("Security Number Is Entered", "DONE");
			        RobotSendKeys.type("\t");
			        RobotSendKeys.type("\t");
			        RobotSendKeys.typeenter();
			        Report.updateTestLog("Submit Button Is Clicked", "DONE");
		        }
		        else if(makeAPaymentProfile.getCardType().toString().equalsIgnoreCase("MasterCard"))
		        {
                    RobotSendKeys.type(makeAPaymentProfile.getcardSecurityNumber().toString());
                    Report.updateTestLog("Security Number Is Entered", "DONE");
			        RobotSendKeys.type("\t");
			        RobotSendKeys.type("\t");
			        RobotSendKeys.typeenter();
			        Report.updateTestLog("Submit Button Is Clicked", "DONE");
		        }
		        System.out.print(makeAPaymentProfile.getcardSecurityNumber().toString());
		        Thread.sleep(15000);
		        
		        try
		        {
		        	System.out.println(strAmountToPay);
		        	//ie.html().contains(strAmountToPay)
		        if(browser.isTextPresent("Thank you for your payment"))
		        	{
		        if(ie.html().contains(strAmountToPay))
		        {
		        	Report.updateTestLog("Correct Amount Is Paid", "PASS");
		        }
		        else
		        {
		        	Report.updateTestLog("Correct Amount Is Paid", "FAIL");
		        }
		        	}else
		        	{
		        		Report.updateTestLog("COnfirmation page is not Loaded", "FAIL");
		        	}
		        }
		        catch (Exception e) {					
		        	
				}
		        
		        ie.link(text, "Log out").click();
		        
		        Thread.sleep(1000);
		        ie.close();
		    }
	    	catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    
	   
	    
	    
	    
}
