package bg.framework.app.functional.page.selfServe;



import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import bg.framework.app.functional.entities.MakeAPaymentProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.common.functional.UIDriver;
import bg.framework.common.functional.WebDriverProvider;

public class MakeAPaymentPageNew extends BasePage{
	 private final static String FILE_NAME = "resources/selfServe/MakePaymentCardDetailsPage.properties";
	    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	    

	    
	    public void makeAPaymentJourney(MakeAPaymentProfile makeAPaymentProfile,int card)
	    
	    {
	    	try{
	    	String cardtype[]={"Visa Debit", "Mastercard", "Maestro"};
	    	verifyAndClickWithXpath(pageProperties.getProperty("MakePayment.ManageAccount"), "manage Account Link");
//	    	verifyAndClickWithXpath(".//*[@id='manageAccountsDiv10051776720320']/a", "manage Account Link");
	    	/*verifyAndClickWithXpath(pageProperties.getProperty("MakePayment.Payment"), "Payment Link");
			Thread.sleep(4000);
	    	verifyAndClickWithXpath(pageProperties.getProperty("MakePayment.MakePaymentLink"), "Make Payment Link");*/
			Thread.sleep(4000);
			browser.open("http://10.224.70.111/content/britishgas/youraccount/make-a-payment/paymentaccountselector.html");
			Thread.sleep(4000);
			Report.updateTestLog("MakeAPayment Page", "WARN");
	    	verifyAndClickWithName(pageProperties.getProperty("MakePayment.AccountSelection"), "Account Selection");
	    	Thread.sleep(7000);
	    	//verifyAndClickWithName(pageProperties.getProperty("MakePayment.AccountContinue"), "Account Continue");
	    	verifyAndClickWithXpath(".//*[@id='continuebutton']", "Continue");
	    	Thread.sleep(3000);
	    	Report.updateTestLog("Card Details Page", "WARN");
	    	if(cardtype[card].equals("Visa Debit"))
	    	{
	    		verifyAndInputById(pageProperties.getProperty("MakePayment.AmountToPay"),"", "10.00");
	    	}
	    	if(cardtype[card].equals("Mastercard"))
	    	{
	    		verifyAndInputById(pageProperties.getProperty("MakePayment.AmountToPay"),"", "11.00");
	    	}
	    	if(cardtype[card].equals("Maestro"))
	    	{
	    		verifyAndInputById(pageProperties.getProperty("MakePayment.AmountToPay"),"", "12.00");
	    	}
//     		verifyAndInputById(pageProperties.getProperty("MakePayment.AmountToPay"),"", "11.00");
     		Thread.sleep(3000);
	    	verifyAndSelectDropDownBox(pageProperties.getProperty("MakePayment.CardType"), "Master Card", cardtype[card]);
	    	Thread.sleep(2000);
	    	System.out.println("Senthil"+pageProperties.getProperty("MakePayment.CardName"));
//	    	verifyAndInputById(pageProperties.getProperty("MakePayment.CardName"),"Card Name", "Cat");
	    	verifyAndInputByXpath(pageProperties.getProperty("MakePayment.CardName"),"Card Name", "Cat");
	    	if(cardtype[card].equals("Visa Debit"))
	    	{
	    	verifyAndInputByXpath(pageProperties.getProperty("MakePayment.CardNumber"), "Card number","4539791001730106");
	    	verifyAndInputByXpath(pageProperties.getProperty("MakePayment.CVV"),"", "121");
	    	}
	    	if(cardtype[card].equals("Mastercard"))
	    	{
	    	verifyAndInputByXpath(pageProperties.getProperty("MakePayment.CardNumber"), "Card number","5573471234567898");
	    	verifyAndInputByXpath(pageProperties.getProperty("MakePayment.CVV"),"", "152");
	    	}
	    	if(cardtype[card].equals("Maestro"))
	    	{
	    	verifyAndInputByXpath(pageProperties.getProperty("MakePayment.CardNumber"), "Card number","6759950000000162");
	    	verifyAndInputByXpath(pageProperties.getProperty("MakePayment.CVV"),"", "242");
	    	}
	    	
	    	Thread.sleep(15000);
/*	    	verifyAndSelectDropDownBox(pageProperties.getProperty("MakePayment.StartMonth"),"","11");
	    	verifyAndSelectDropDownBox(pageProperties.getProperty("MakePayment.StartYear"),"","2008");
	    	verifyAndSelectDropDownBox(pageProperties.getProperty("MakePayment.EndMonth"),"","4");
	    	verifyAndSelectDropDownBox(pageProperties.getProperty("MakePayment.EndYear"),"","2013");*/
	    	verifyAndSelectDropDownBox(pageProperties.getProperty("MakePayment.EndMonth"),"","3");
	    	verifyAndSelectDropDownBox(pageProperties.getProperty("MakePayment.EndYear"),"","2014");
//	    	verifyAndInputByXpath(pageProperties.getProperty("MakePayment.CVV"),"", "121");
//	    	verifyAndInputByXpath(pageProperties.getProperty("MakePayment.CVV"),"", "152");
//	    	verifyAndInputByXpath(pageProperties.getProperty("MakePayment.CVV"),"", "242");
	    	Report.updateTestLog("card details submit page", "WARN");
	     	verifyAndClick(pageProperties.getProperty("MakePayment.Continue"), "MakeAPayment Continue");
	     	Report.updateTestLog("Payment Now Page", "WARN");
	     	verifyAndClick(pageProperties.getProperty("MakePayment.Paynow"), "PayNow Button");
	     	Thread.sleep(15000);
	     	
	     	masterCard(makeAPaymentProfile);

	    	} catch (Exception e) {
				e.printStackTrace();
			}
	    }


	    public void masterCard(MakeAPaymentProfile makeAPaymentProfile)
	    {
	    	try{
	    		     	
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
			Thread.sleep(8000);
			Alert alert =  driver.switchTo().alert();
			alert.accept();
			browser.swtichToDefaultContent();
			Thread.sleep(8000);
			//Report.updateTestLog("ThankYOuPage", "WARN");
			verifyIsTextPresent("Thank you for your payment");
			Report.updateTestLog("Thank you Page", "WARN");
			Thread.sleep(4000);
	    	} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    }
	    
}
