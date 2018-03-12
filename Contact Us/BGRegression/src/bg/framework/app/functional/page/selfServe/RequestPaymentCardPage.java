package bg.framework.app.functional.page.selfServe;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.internal.selenesedriver.IsElementDisplayed;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class RequestPaymentCardPage extends BasePage{
	
	private final static String FILE_NAME = "resources/selfServe/RequestPaymentCard.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	
	public boolean verifyPaymentCard(){
		
		String PaymentText = "Payment Card"; 
	//	verifyIsElementVisibleWithXpath(pageProperties.getProperty("RequestPaymentCard.PaymentCardText"), "Payment Card Text");
		if(PaymentText.equalsIgnoreCase(browser.getTextByXpath(pageProperties.getProperty("RequestPaymentCard.PaymentCardText"))))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public void navigateToOrderNewPaymentCard(){
		browser.wait(getWaitTime());
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("RequestPaymentCard.OrderNewPayment"))){
			verifyAndClickWithXpath(pageProperties.getProperty("RequestPaymentCard.OrderNewPayment"), "Order A New Payment");
		}
				
	}
	
	public void enterDiffDeliveryAddress(){
		browser.wait(getWaitTime());
		
		verifyAndSelectCheckBoxByID(pageProperties.getProperty("RequestPaymentCard.DeliveryAddresschkbox"), "Delivery Address Checkbox");
		verifyAndInputWithName(pageProperties.getProperty("RequestPaymentCard.DeliveryAddress1"), "Delivery Address 1", "2  Beech Grove Hose,");
		verifyAndInputWithName(pageProperties.getProperty("RequestPaymentCard.DeliveryAddress2"), "Delivery Address 2", "Bury,");
		verifyAndInputWithName(pageProperties.getProperty("RequestPaymentCard.DeliveryAddress3"), "Delivery Address 3", "Lancashire,");
		verifyAndInputWithName(pageProperties.getProperty("RequestPaymentCard.PostCode"), "Post Code", "BL9 6ES");
		
	}
	
	public void submitYourDetails(){
		browser.wait(getWaitTime()); 
		//verifyAndClickWithXpath(pageProperties.getProperty("RequestPaymentCard.SubmitYourDetails"), "Submit Your Details");
		verifyAndClickWithClass(pageProperties.getProperty("RequestPaymentCard.SubmitYourDetails"), "Submit Your Details");
	}

	public void verifyElecPaymentConfirmation(){
		browser.wait(getWaitTime());
		verifyIsTextPresent("Thank you for ordering an Electricity payment card");
		
	}
	
	public void verifyGasPaymentConfirmation(){
		browser.wait(getWaitTime());
		verifyIsTextPresent("Thank you for ordering a Gas payment card");
		
		
	}
}
