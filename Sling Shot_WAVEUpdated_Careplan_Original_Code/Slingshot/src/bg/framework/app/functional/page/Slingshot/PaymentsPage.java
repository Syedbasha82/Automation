/**
 * 
 */
package bg.framework.app.functional.page.Slingshot;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bg.framework.app.functional.action.Slingshot.ContactUsBusinessAction;
import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.SlingshotErrorMessages;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.RunQTP;
import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.common.functional.UIDriver;
import bg.framework.common.functional.WebDriverProvider;
/**
 * @author 208070
 *
 */
public class PaymentsPage extends BasePage{
	private final static String FILE_NAME = "resources/Slingshot/Payments.Properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	SlingshotErrorMessages errormsg = new SlingshotErrorMessages();
	UIDriver driver = WebDriverProvider.getCurrentDriver();
	private static String errormsgvalue = "null", errormsgvalue1="null",errormsgvalue2="null",errormsgvalue3="null",errormsgvalue4="null",errormsgvalue5="null",Balance="null";

	public void navigatetoPayments() {
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.paymentslink"), "Payments Link");
		browser.wait(4000);
		verifyPageTitle("Payments");
	}
	public void navigatetoMakeAPayment() {
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.MakeAPayment"), "Make A Payment Link");
		browser.wait(4000);
		verifyPageTitle("Payment details");
	}
	public void verifyLinks() {
		verifyIsTextPresent("Back to Your account");
		verifyIsTextPresent(browser.getTextByXpath(pageProperties.getProperty("Payments.PaymentsTitle")));
		verifyIsTextPresent("Make a payment for your energy usage");
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.MakeAPayment"), "Make A Payment Link");
		browser.wait(getWaitTime());
		verifyPageTitle("Payment details");
		browser.browserBack();
		browser.wait(getWaitTime());
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Payments.AmendDirectDebit")))
		{
			verifyAndClickWithXpath(pageProperties.getProperty("Payments.AmendDirectDebit"), "Amend Direct Debit");
			browser.wait(getWaitTime());
			if(browser.getTitle().equals("Amend Direct Debit"))
			{
				Report.updateTestLog("Amend Direct Debit - Page Title is Displayed", "Pass");
				browser.browserBack();
			}
			else
			{
				browser.wait(15000);
				verifyIsTextPresent("Direct Debit");
				verifyAndClickWithXpath(pageProperties.getProperty("Payments.AmendDirectDebitClose"), "Close Link");
				browser.browserBack();
			}
		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Payments.SetupDirectDebit")))
		{
			verifyAndClickWithXpath(pageProperties.getProperty("Payments.SetupDirectDebit"), "Set up Direct Debit");
			browser.wait(getWaitTime());
			verifyPageTitle("Set up Direct Debit");
			browser.browserBack();
		}
		browser.wait(getWaitTime());
		verifyIsTextPresent("We’re here to help…");
	
		verifyIsTextPresent("Chat to an agent online");
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.OnlineBanking"), "Online Banking");
		verifyIsTextPresent(browser.getTextByXpath(pageProperties.getProperty("Payments.OnlineBankingcontent")));
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.BACS"), "BACS");
		verifyIsTextPresent(browser.getTextByXpath(pageProperties.getProperty("Payments.BACScontent")));
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.Cash/Cheque"), "Cash/Cheque");
		verifyIsTextPresent(browser.getTextByXpath(pageProperties.getProperty("Payments.Cash/Chequecontent")));
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.PostOffice"), "Post Office");
		verifyIsTextPresent(browser.getTextByXpath(pageProperties.getProperty("Payments.PostOfficecontent")).trim());
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.Telephone"), "Telephone");
		verifyIsTextPresent(browser.getTextByXpath(pageProperties.getProperty("Payments.Telephonecontent")));
	}

	public void paymentDetails(UserProfile userProfile) {
		String CardType[]={"Visa Debit", "Visa Delta", "Visa credit card", "MasterCard"};
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.Cancel"), "Cancel Link");
		browser.wait(getWaitTime());
		verifyPageTitle("Account overview");
		browser.browserBack();
		browser.wait(getWaitTime());
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.Back"), "Back Link");
		browser.wait(getWaitTime());
		verifyPageTitle("Account summary");
		browser.browserBack();
		browser.wait(getWaitTime());
		verifyAndInputByXpath(pageProperties.getProperty("Payments.AmountToPay"), "Amount To Pay", "4");
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.Confirm"), "Confirm Link");
		verifyIsTextPresent(browser.getTextByXpath(pageProperties.getProperty("Payments.LessAmount")));
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.LessAmountClose"), "Close Link");
		Balance = browser.getTextByXpath(pageProperties.getProperty("Payments.Balance"));
		String Balance1=Balance.substring(1,(Balance.indexOf('.')));
		int BalanceInt = Integer.parseInt(Balance1)+1;
		Balance1=""+BalanceInt;
		verifyAndInputByXpath(pageProperties.getProperty("Payments.AmountToPay"), "Amount To Pay", Balance1);
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.Confirm"), "Confirm Link");
		String s= browser.getTextByXpath(pageProperties.getProperty("Payments.MoreAmount"));
		verifyIsTextPresent(browser.getTextByXpath(pageProperties.getProperty("Payments.MoreAmount")));
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.MoreAmountClose"), "Close Link");
		List<String> CardTypes = browser.getFromDropBox("id", pageProperties.getProperty("Payments.CardTypeDropdown"));
		for(int search=0;search<CardType.length;search++)
		{
			if(CardTypes.get(search+1).equals(CardType[search])){
				Report.updateTestLog(CardTypes.get(search+1) + " is available in the Query DropDown", "PASS");
			}
			else
			{
				Report.updateTestLog(CardTypes.get(search+1) + " is not available in the Query DropDown", "FAIL");
			}
		}
		verifyIsTextPresent("Ways you can pay");
		verifyIsTextPresent("Your payment is safe and protected by 3D secure");
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.morethanonepayment"), "Can I make more than one payment? Link");
		verifyIsTextPresent(browser.getTextByXpath(pageProperties.getProperty("Payments.morethanonepaymentOverlay")));
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.morethanonepaymentOverlayClose"), "Can I make more than one payment? Close Link");
		browser.wait(getWaitTime());
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.HelpandAdvice"), "Help & Advice Link");
		browser.wait(getWaitTime());
		verifyPageTitle("Help & advice - British Gas Business");
		browser.browserBack();browser.wait(getWaitTime());
		verifyAndInputByXpath(pageProperties.getProperty("Payments.AmountToPay"), "Amount To Pay", userProfile.getAmountToPay());
		browser.selectfromDropBox("id",pageProperties.getProperty("Payments.CardTypeDropdown"), userProfile.getCardtype());
		verifyAndInputById(pageProperties.getProperty("Payments.CardHolderName"), "Card Holder Name", userProfile.getCardHolderName());
		verifyAndInputById(pageProperties.getProperty("Payments.CardNumber"), "Card Number", userProfile.getCardNumber());
		browser.wait(getWaitTime());
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.CardNumWhatsThis"), "Card Number - What's this? Link");
		verifyIsTextPresent(browser.getTextByXpath(pageProperties.getProperty("Payments.CardNumWhatsThisContent")));
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.CardNumWhatsThisContentClose"), "Card Number - What's this? Close Link");
		browser.selectfromDropBox("id",pageProperties.getProperty("Payments.ExpiryMonth"), userProfile.getCardExpiryMonth());
		browser.selectfromDropBox("id",pageProperties.getProperty("Payments.ExpiryYear"), userProfile.getCardExpiryYear());
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.CVVWhatsThis"), "CVV - What's this? Link");
		verifyIsTextPresent(browser.getTextByXpath(pageProperties.getProperty("Payments.CVVWhatsThisContent")));
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.CVVWhatsThisContentClose"), "CVV - What's this? Close Link");
		verifyAndInputById(pageProperties.getProperty("Payments.CVV"), "CVV", userProfile.getCardCVV());
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.Confirm"), "Confirm Link");
		browser.wait(getWaitTime());
		verifyPageTitle("Confirm payment");
		verifyIsTextPresent("Our payment process includes the additional security of Verified by Visa and MasterCard SecureCode");
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.PayNow"), "PayNow Button");
		browser.wait(20000);
//		verifyPageTitle("Card security check");
//		verifyIsTextPresent("Our payment process includes the additional security of Verified by Visa and MasterCard SecureCode");
//		browser.wait(getWaitTime());
//		driver.switchTo().frame(driver.findElement(By.xpath(pageProperties.getProperty("Payments.Submit"))));
		//verifyAndClickWithXpath(pageProperties.getProperty("Payments.Submit"), "Submit Button");
		verifyPageTitle("Confirmation");
		verifyIsTextPresent("Thank you for your payment");
		verifyIsTextPresent("We will email you confirmation that your payment has gone through");
		verifyIsTextPresent("Your payment for account " +userProfile.getAccNumber()+ " has been successful.");
		verifyIsTextPresent("Transaction reference");
		verifyIsTextPresent("Your previous balance");
		String PrevBalance = browser.getTextByXpath(pageProperties.getProperty("Payments.previousBalance"));
		if(Balance.trim().equals(PrevBalance.trim()))
		{
			Report.updateTestLog("Previous Balance is displayed correctly - " + PrevBalance, "PASS");
		}
		else
		{
			Report.updateTestLog("Previous Balance is not displayed correctly - " + PrevBalance, "FAIL");
		}
		verifyIsTextPresent("Amount Paid");
		String Amtpaid = browser.getTextByXpath(pageProperties.getProperty("Payments.AmtPaid"));
		int AmtPaidInt = Integer.parseInt(Amtpaid.substring(1));
		System.out.println("Amt paid"+AmtPaidInt);
		verifyIsTextPresent("Your new balance");
		String NewBalance = browser.getTextByXpath(pageProperties.getProperty("Payments.NewBalance"));
		int NewBalanceInt = Integer.parseInt(NewBalance.substring(1,(NewBalance.indexOf('.'))));
		System.out.println("New Balance"+NewBalanceInt);
		int PrevBalanceInt = Integer.parseInt(PrevBalance.substring(1,(PrevBalance.indexOf('.'))));
		System.out.println("Previous Balance"+PrevBalanceInt);
		if((PrevBalanceInt-AmtPaidInt)==NewBalanceInt)
		{
			Report.updateTestLog("New Balance is displayed correctly - " + NewBalance, "PASS");
		}
		else
		{
			Report.updateTestLog("New Balance is not displayed correctly - " + NewBalance, "FAIL");
		}
		verifyAndClickWithLinkText("Submit meter read", "Submit meter read");
		browser.wait(getWaitTime());
		verifyPageTitle("Submit meter read");
		browser.browserBack();
		browser.wait(getWaitTime());
		verifyAndClickWithLinkText("View your account", "View your account");
		browser.wait(getWaitTime());
		verifyPageTitle("Account overview");
		browser.browserBack();
		browser.wait(getWaitTime());
		verifyAndClickWithLinkText("View your bills", "View your bills");
		browser.wait(getWaitTime());
		verifyPageTitle("Search bill");
		browser.browserBack();
		browser.wait(getWaitTime());
		verifyAndClickWithLinkText("Energy made simple", "Energy made simple");
		browser.wait(getWaitTime());
		verifyIsTextPresent("Energy Made Simple");
		browser.browserBack();
		browser.wait(getWaitTime());
		verifyAndClickWithLinkText("Back to your account", "Back to your account");
		browser.wait(getWaitTime());
		verifyPageTitle("Account overview");
//		String AcctBalance = browser.getTextByXpath(pageProperties.getProperty("Payments.AcctBalance"));
//		if(AcctBalance.trim().equals(NewBalance.trim()))
//		{
//			Report.updateTestLog("Account Balance is displayed correctly - " + AcctBalance, "PASS");
//		}
//		else
//		{
//			Report.updateTestLog("Account Balance is not displayed correctly - " + AcctBalance, "FAIL");
//		}
//	       String strRetreiveEmailQry="select BUSINESS_PARTNER_ORG_NUMBER from BG_BUSINESS_TA_CUSTOMER_REG" +
//                   " where email='emailid'";
//	       String query=strRetreiveEmailQry.replace("emailid",userProfile.getEmail().toLowerCase());
//	       if(new OnlineDBConnector().getColumn("BUSINESS_PARTNER_ORG_NUMBER", query).equals(null)){
//            Report.updateTestLog("BPORGNUMBER is null for the email"+userProfile.getEmail(), "Fail");
//            return;
//	       }
//	       String bpOrgNumber1=new OnlineDBConnector().getColumn("BUSINESS_PARTNER_ORG_NUMBER", query);
//	       RunQTP runQTP = new RunQTP();
//	       runQTP.runQTP("Slingshot\\src\\bg\\framework\\app\\functional\\util\\vbsScripts\\OnDemandBilling.vbs", bpOrgNumber1);
//	       browser.wait(15000);
//	       try {
//	    	   File file1 = new File("D:\\SAPData\\OnDemandBilling.txt");
//	    	   FileReader fr = new FileReader(file1);
//	    	   BufferedReader br = new BufferedReader(fr);
//	    	   br.readLine();
//	    	   br.readLine();
//	    	   br.readLine();
//	    	   String netBalance = br.readLine();
//	    	   String balance[] = netBalance.split("Total balance:");
//	    	   NewBalance=(NewBalance.substring(1));
//	    	   balance[1]= balance[1].replace(',', '.');
//	              if(NewBalance.equalsIgnoreCase(balance[1])){
//	                     Report.updateTestLog("Net balance in Application: "+NewBalance+"New Balance in ISU: "+balance[1], "PASS");
//
//	              }
//	              else{
//	                     Report.updateTestLog("Net balance in Application: "+NewBalance+"New Balance in ISU: "+balance[1], "FAIL");
//	              }
//	       }
//	       catch(Exception e){
//	              Report.updateTestLog("Exception occured : "+e, "FAIL");       
//	       }
		}

	public void errorValidation(UserProfile userProfile) {
		browser.selectfromDropBox("id",pageProperties.getProperty("Payments.CardTypeDropdown"), "Select");
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.Confirm"), "Confirm Link");
		browser.wait(getWaitTime());
		errormsgvalue=browser.getTextByXpath(pageProperties.getProperty("Payments.CardTypeError"));
		Report.updateTestLog("Error Msg in Table: Expected Result: "+errormsg.Payments_CardType+"Actual Result: "+errormsgvalue,errormsgvalue.contains(errormsg.Payments_CardType)?"Pass":"Fail");
		String[] CardNumber={"","Saadha!@34","545645","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"};
		String[] CVV={"ABC","!@1","","A5"};
		for(int i=0;i<CardNumber.length;i++){
		browser.selectfromDropBox("id",pageProperties.getProperty("Payments.CardTypeDropdown"), userProfile.getCardtype());
		verifyAndInputById(pageProperties.getProperty("Payments.CardHolderName"), "Card Holder Name",  userProfile.getCardHolderName());
		verifyAndInputById(pageProperties.getProperty("Payments.CardNumber"), "Card Number", CardNumber[i]);
		browser.selectfromDropBox("id",pageProperties.getProperty("Payments.StartMonth"), "3");
		browser.selectfromDropBox("id",pageProperties.getProperty("Payments.StartYear"), "2015");
		browser.selectfromDropBox("id",pageProperties.getProperty("Payments.ExpiryMonth"), "3");
		browser.selectfromDropBox("id",pageProperties.getProperty("Payments.ExpiryYear"), "2014");
		verifyAndInputById(pageProperties.getProperty("Payments.IssueNumber"), "Issue Number", "AB");
		verifyAndInputById(pageProperties.getProperty("Payments.CVV"), "CVV", CVV[i]);
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.Confirm"), "Confirm Link");
		verifyIsTextPresent("Sorry, we need you to look at the following areas of the form again");
		verifyIsTextPresent("We're missing or don't recognise some of the information in:");
		errormsgvalue1=browser.getTextByXpath(pageProperties.getProperty("Payments.CardNoError"));
		errormsgvalue2=browser.getTextByXpath(pageProperties.getProperty("Payments.CardStartDateError"));
		errormsgvalue3=browser.getTextByXpath(pageProperties.getProperty("Payments.CardExpiryDateError"));
		errormsgvalue4=browser.getTextByXpath(pageProperties.getProperty("Payments.CardSecurityCodeError"));
		errormsgvalue5=browser.getTextByXpath(pageProperties.getProperty("Payments.IssueNumberError"));
		Report.updateTestLog("Error Msg in Table: Expected Result: "+errormsg.Payments_CardNumber+"Actual Result: "+errormsgvalue1,errormsgvalue1.contains(errormsg.Payments_CardNumber)?"Pass":"Fail");
		Report.updateTestLog("Error Msg in Table: Expected Result: "+errormsg.Payments_CardStartDate+"Actual Result: "+errormsgvalue2,errormsgvalue2.contains(errormsg.Payments_CardStartDate)?"Pass":"Fail");
		//Report.updateTestLog("Error Msg in Table: Expected Result: "+errormsg.Payments_CardExpiryDate+"Actual Result: "+errormsgvalue3,errormsgvalue3.contains(errormsg.Payments_CardExpiryDate)?"Pass":"Fail");
		if(CVV[i]==""){
		Report.updateTestLog("Error Msg in Table: Expected Result: "+errormsg.Payments_CVVBlank+"Actual Result: "+errormsgvalue4,errormsgvalue4.contains(errormsg.Payments_CVVBlank)?"Pass":"Fail");
		}
		else{
		Report.updateTestLog("Error Msg in Table: Expected Result: "+errormsg.Payments_CVV+"Actual Result: "+errormsgvalue4,errormsgvalue4.contains(errormsg.Payments_CVV)?"Pass":"Fail");
		}
		
		Report.updateTestLog("Error Msg in Table: Expected Result: "+errormsg.Payments_IssueNumber+"Actual Result: "+errormsgvalue5,errormsgvalue5.contains(errormsg.Payments_IssueNumber)?"Pass":"Fail");
	}	
	}
	
	public void logOut() {
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.Logout"), "Logout Link");
	}
	
		
	public void TwoCardlimit(int increment, UserProfile userProfile) {
		verifyAndInputByXpath(pageProperties.getProperty("Payments.AmountToPay"), "Amount To Pay",userProfile.getAmountToPay() );
		browser.selectfromDropBox("id",pageProperties.getProperty("Payments.CardTypeDropdown"), userProfile.getCardtype());
		verifyAndInputById(pageProperties.getProperty("Payments.CardHolderName"), "Card Holder Name", userProfile.getCardHolderName());
		verifyAndInputById(pageProperties.getProperty("Payments.CardNumber"), "Card Number", userProfile.getCardNumber());
		browser.selectfromDropBox("id",pageProperties.getProperty("Payments.ExpiryMonth"), userProfile.getCardExpiryMonth());
		browser.selectfromDropBox("id",pageProperties.getProperty("Payments.ExpiryYear"), userProfile.getCardExpiryYear());
		verifyAndInputById(pageProperties.getProperty("Payments.CVV"), "CVV", userProfile.getCardCVV());
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.Confirm"), "Confirm Link");
		browser.wait(getWaitTime());
		verifyPageTitle("Confirm payment");
		verifyIsTextPresent("Our payment process includes the additional security of Verified by Visa and MasterCard SecureCode");
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.PayNow"), "PayNow Button");
		browser.wait(5000);
//		verifyPageTitle("Card security check");
//		verifyIsTextPresent("Our payment process includes the additional security of Verified by Visa and MasterCard SecureCode");
		verifyPageTitle("Confirmation");
		verifyIsTextPresent("Thank you for your payment");
		verifyIsTextPresent("We will email you confirmation that your payment has gone through");
		verifyAndClickWithLinkText("Back to your account", "Back to your account");
		browser.wait(getWaitTime());
		verifyPageTitle("Account overview");
		}
	
	public void navigatetoMakeAPaymentError() {
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.MakeAPayment"), "Make A Payment Link");
		browser.wait(6000);
		verifyIsTextPresent("Please call us");
		verifyIsTextPresent("Sorry, we have been unable to process your payment");
		verifyIsTextPresent("We were unable to take your payment. Please contact us on 0800 316 2010");
		verifyAndClickWithXpath(pageProperties.getProperty("Payments.NoPayment"), "Unable to make a Payment - Close button");
	}
		
}
