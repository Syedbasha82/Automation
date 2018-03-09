package bg.framework.app.functional.page.selfServe;



import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Properties;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.MakeAPaymentProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import bg.framework.common.functional.UIDriver;
import bg.framework.common.functional.WebDriverProvider;
import bg.framework.app.functional.entities.MakeAPaymentCardDetails;

public class MakeAPaymentPageNew extends BasePage{
	 private final static String FILE_NAME = "resources/selfServe/MakePaymentCardDetailsPage.properties";
	    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	    

	    
	    public void makeAPaymentJourney(int card)
	    
	    {
	    	try{
	    	String cardtype[]={"Visa Debit", "Visa Delta", "Visa Credit Card","MasterCard"};
	    	if(cardtype[card].equals("Visa Debit"))
	    	{
	    		verifyAndInputById(pageProperties.getProperty("MakePayment.AmountToPay"),"", "10.00");
	    	}
	    	if(cardtype[card].equals("Visa Delta"))
	    	{
	    		verifyAndInputById(pageProperties.getProperty("MakePayment.AmountToPay"),"", "11.00");
	    	}
	    	if(cardtype[card].equals("Visa Credit Card"))
	    	{
	    		verifyAndInputById(pageProperties.getProperty("MakePayment.AmountToPay"),"", "12.00");
	    	}
	    	if(cardtype[card].equals("MasterCard"))
	    	{
	    		verifyAndInputById(pageProperties.getProperty("MakePayment.AmountToPay"),"", "13.00");
	    	}
            browser.wait(5000);
            verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("MakePayment.CardType"), "Master Card", cardtype[card]);
	    	System.out.println("88888888888888888888888888888888888888888888888888888888888888888888888888");
	    	verifyAndInputById(pageProperties.getProperty("MakePayment.CardName"),"Card Name", "Cat");
	    	if(cardtype[card].equals("Visa Debit"))
	    	{
	    	verifyAndInputById(pageProperties.getProperty("MakePayment.CardNumber"), "Card number","4485651824866517");
	    	//verifyAndInputById(pageProperties.getProperty("MakePayment.CVV_New"),"", "123");
	    	verifyAndInputByXpath(pageProperties.getProperty("MakePayment.CVV_New"),"", "123");
	    	}
	    	if(cardtype[card].equals("Visa Delta"))
	    	{
	    	verifyAndInputById(pageProperties.getProperty("MakePayment.CardNumber"), "Card number","4411763723987333");
	    	//verifyAndInputById(pageProperties.getProperty("MakePayment.CVV_New"),"", " 123");
	    	verifyAndInputByXpath(pageProperties.getProperty("MakePayment.CVV_New"),"", "123");
	    	}
	    	if(cardtype[card].equals("Visa Credit Card"))
	    	{
	    	verifyAndInputById(pageProperties.getProperty("MakePayment.CardNumber"), "Card number","4532386709727657");
	    	//verifyAndInputById(pageProperties.getProperty("MakePayment.CVV_New"),"", "123");
	    	verifyAndInputByXpath(pageProperties.getProperty("MakePayment.CVV_New"),"", "123");
	    	}
	    	if(cardtype[card].equals("MasterCard"))
	    	{
	    	verifyAndInputById(pageProperties.getProperty("MakePayment.CardNumber"), "Card number","5466144301991743");
	    	//verifyAndInputById(pageProperties.getProperty("MakePayment.CVV_New"),"", "772");
	    	verifyAndInputByXpath(pageProperties.getProperty("MakePayment.CVV_New"),"", "123");
	    	}
	    	System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSS");
	    	WebElement element = browser.getElementByXpath(pageProperties.getProperty("Payments.CVV"));
	    	MakeAPaymentCardDetails makeAPaymentCardDetails =new TestDataHelper().getMakeAPaymentCardDetails("Card8");
	    	verifyAndInputByXpath(pageProperties.getProperty("Payments.CVV"), "CVV", "123");
	    	
	    	//verifyAndInputByXpath(pageProperties.getProperty("MakePayment.CVV_New"),"", "123");
	    	//verifyAndSelectDropDownBox(pageProperties.getProperty("MakePayment.EndMonth"),"","8");
	    	//verifyAndSelectDropDownBox(pageProperties.getProperty("MakePayment.EndYear"),"","2019");
	    	Report.updateTestLog("Payment Details Page", "WARN");
	    	//verifyAndClickWithXpath(pageProperties.getProperty("Payments.saveCardToProfileCheckBox"),"Save Card ToP rofile Check Box");
	    	Report.updateTestLog("Payment Now Page", "WARN");
	    	verifyAndClickWithXpath(pageProperties.getProperty("MakePayment.Continue"), "MakeAPayment Continue");
	    	
	     	Report.updateTestLog("Payment Now Page", "WARN");
	    	} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    public void confirmYourPaymentPage(){
	    	browser.wait(3000);
	    	if(browser.isTextPresent("Review your payment details")){
	    		Report.updateTestLog("Confirm your payment Page is present in the Application", "WARN");
	    	}
	    	else{
	    		Report.updateTestLog("Confirm your payment is not present in the Application", "FAIL");
	    	}
	    	
	     	verifyAndClickWithXpath(pageProperties.getProperty("MakePayment.Paynow"), "PayNow Button");
	     
	    }	
	    public void verify3DSecurePage(){
	    	browser.selectWindowById(0);
	    	WebElement element = browser.getElementByXpath("//div[@id='CompanyLogo']");
	    	        element.click();
	    	        browser.wait(7000);
	    	        browser.swtichToDefaultContent();
	       
	    	
	    }
	    public void verifyConfirmationPage(){
	    	browser.wait(10000);
	    	if(browser.isElementVisibleWithLinkText(pageProperties.getProperty("MakePayment.MakeAnotherPayment"))){
	    		Report.updateTestLog("Confirmation Page is present in the Application", "WARN");
	    	}
	    	else{
	    		Report.updateTestLog("Confirmation Page is not present in the Application", "FAIL");
	    	}
	     
	    }	
	   
	    public void navigatetoPaymentsPage(){
	    	browser.wait(5000);
	    	verifyAndClickWithXpath(pageProperties.getProperty("AccountSummary.Payments"), "Payments");
	    	Report.updateTestLog("Payments Page", "PASS");
	    }
	    public void navigatetoPaymentsPageFromMAP(){
	    	browser.wait(5000);
	    	verifyAndClickWithXpath(pageProperties.getProperty("AccountSummary.PaymentsfromMAP"), "Payments");
	    }
	    public void navigatetoMakeAPaymentPage(){
	    	browser.wait(5000);
	    	verifyAndClickWithXpath(pageProperties.getProperty("Payments.MakeAPayment"), "Make A Payment");
	    	if(browser.isTextPresent("Make a payment")){
	    	 Report.updateTestLog("Make A Payment Page", "WARN");
	    	}
	    	else{
	    		 Report.updateTestLog("Make A Payment Page is not Present in the application", "FAIL");
	    	}
	    }  
	    public void navigateToManagePaymentCardDetailsPage(){
	    	browser.wait(5000);
	    	verifyAndClickWithXpath(pageProperties.getProperty("Payments.managePaymentCardLink"), "Manage Payment Card Link");
	    }
	    public void cardStorageFunctionality(){
	       for(int i=1;i<=10;i++){
	    	MakeAPaymentCardDetails makeAPaymentCardDetails =new TestDataHelper().getMakeAPaymentCardDetails("Card"+i);
	        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Payments.PaymentCardsSection"))){
	        	verifyAndClickWithXpath(pageProperties.getProperty("Payments.addANewPaymentCard"), "Add A New Payment Card");
	        	enterCardDetails(makeAPaymentCardDetails);		
		    }
		    else{
		    	enterCardDetails(makeAPaymentCardDetails); 
		    }
	        verifyPaymentCardSection(i);
	       
	    }
	       
	    }
	    public void enterCardDetails(MakeAPaymentCardDetails makeAPaymentCardDetails){
	    	verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("MakePayment.CardType"), "Master Card",makeAPaymentCardDetails.getCardType());
	    	verifyAndInputById(pageProperties.getProperty("MakePayment.CardName"),"Card Name", makeAPaymentCardDetails.getNameOnCard());
	    	verifyAndInputById(pageProperties.getProperty("MakePayment.CardNumber"), "Card number",makeAPaymentCardDetails.getCardNumber());
	    	verifyAndSelectDropDownBox(pageProperties.getProperty("MakePayment.EndMonth"),"End Month",makeAPaymentCardDetails.getExpiryMonth());
	    	verifyAndSelectDropDownBox(pageProperties.getProperty("MakePayment.EndYear"),"End Year",makeAPaymentCardDetails.getExpiryYear());
	    	verifyAndClickWithXpath(pageProperties.getProperty("MakePayment.DefaultCardCheckBox"),"Default Card Check Box");
	    	//verifyIsElementVisibleWithLinkText(pageProperties.getProperty("Payments.backlink"),"Back Link");
	        submitCard();
	    }
	    public void verifyPaymentCardSection(int i){
	    	String rowNumber=String.valueOf(i);
	    	if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Payments.RowsAdded").replace("NUM", rowNumber))){
		    	Report.updateTestLog("Card Details Updated", "WARN");	
		    }
		    else{
		    	Report.updateTestLog("Card Details not Updated", "FAIL");	
		    }
	    	if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Payments.RowsAddedwithDefault"))){
		    	Report.updateTestLog("Card Details Updated with Default", "PASS");	
		    }
		    else{
		    	Report.updateTestLog("Card Details not Updated with Default", "FAIL");	
		    }
	    }
	    public void verifyMakeAPaymentPage(MakeAPaymentCardDetails makeAPaymentCardDetails,int i){
	    	
	    	browser.open(ApplicationConfig.APP_BG_URL+"/Make-A-Payment/Account-Details-Display/");
	    	if(i==1){
	    	String onScreenCardNumber=	browser.getAttributeByXpath(pageProperties.getProperty("MakePayment.cardNumberXpath"),"value");
	        System.out.println("33333333333333333333333333333"+onScreenCardNumber);  
	    	if(onScreenCardNumber.contains(makeAPaymentCardDetails.getCardNumber())){
	    		Report.updateTestLog("Card Number is same as Default", "PASS");	
	    		String onscreenCardType= browser.getAttributeByXpath(pageProperties.getProperty("MakePayment.onscreenCardType"),"value");
		    	System.out.println("5555555555555555555555555555555555555"+onscreenCardType);
		    	String onscreenCardName= browser.getAttributeByXpath(pageProperties.getProperty("MakePayment.onscreenCardName"),"value");
		    	System.out.println("6666666666666666666666666666666666666"+onscreenCardName);
		    	String onscreenCardMonth= browser.getAttributeByXpath(pageProperties.getProperty("MakePayment.onscreenCardMonth"),"value");
		    	System.out.println("777777777777777777777777777777777777"+onscreenCardMonth);
		    	String onscreenCardYear= browser.getAttributeByXpath(pageProperties.getProperty("MakePayment.onscreenCardYear"),"value");
		    	System.out.println("8888888888888888888888888888888888888"+onscreenCardYear);

		    	
		    	if(onscreenCardType.equals(makeAPaymentCardDetails.getCardType())){
		    		Report.updateTestLog("Card Type is same as Default", "PASS");	
		    	}
		    	else{
		    		Report.updateTestLog("Card Type is not same as Default", "FAIL");
		    	}
		    	if(onscreenCardName.equals(makeAPaymentCardDetails.getNameOnCard())){
		    		Report.updateTestLog("Card Name is same as Default", "PASS");	
		    	}
		    	else{
		    		Report.updateTestLog("Card Name is not same as Default", "FAIL");
		    	}
		    	if(onscreenCardMonth.equals(makeAPaymentCardDetails.getExpiryMonth())){
		    		Report.updateTestLog("Card Month is same as Default", "PASS");	
		    	}
		    	else{
		    		Report.updateTestLog("Card Month is not Same as Default", "FAIL");
		    	}
		    	if(onscreenCardYear.equals(makeAPaymentCardDetails.getExpiryYear())){
		    		Report.updateTestLog("Card Year is same as Default", "PASS");	
		    	}
		    	else{
		    		Report.updateTestLog("Card Year is not same as Default", "FAIL");
		    	}
	    	}
	    	else{
	    		Report.updateTestLog("Card Number is not same as Default", "FAIL");
	    	}
	    		
	    	}
	    	
	    	
	    	
	    }
	    public void navigateToManagePaymentCardDetailsFromMAPPage(){
	    	verifyAndClickWithXpath(pageProperties.getProperty("Payments.paymentLink"), "Payment Link");
	    	verifyAndClickWithXpath(pageProperties.getProperty("Payments.managePaymentCardLink"), "Manage Payment Card Link");
	    }
	    public void addAPaymentCard(MakeAPaymentCardDetails makeAPaymentCardDetails){
	    	verifyAndClickWithXpath(pageProperties.getProperty("Payments.addAPaymentCardLink"), "Add A Payment Card Link");
	    	verifyAndInputById(pageProperties.getProperty("MakePayment.AmountToPay"),"", "15.00");
	    	verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("MakePayment.CardType"), "Master Card",makeAPaymentCardDetails.getCardType());
	    	verifyAndInputById(pageProperties.getProperty("MakePayment.CardName"),"Card Name", makeAPaymentCardDetails.getNameOnCard());
	    	verifyAndInputById(pageProperties.getProperty("MakePayment.CardNumber"), "Card number",makeAPaymentCardDetails.getCardNumber());
	    	verifyAndSelectDropDownBox(pageProperties.getProperty("MakePayment.EndMonth"),"End Month",makeAPaymentCardDetails.getExpiryMonth());
	    	verifyAndSelectDropDownBox(pageProperties.getProperty("MakePayment.EndYear"),"End Year",makeAPaymentCardDetails.getExpiryYear());
	    	verifyAndInputById(pageProperties.getProperty("MakePayment.CVV"),"",makeAPaymentCardDetails.getSecurityCode() );
	    	verifyAndClickWithXpath(pageProperties.getProperty("Payments.saveCardToProfileCheckBox"), "Save Card To Profile CheckBox");
	    	verifyAndClickWithXpath(pageProperties.getProperty("MakePayment.Continue"), "MakeAPayment Continue");
	    	navigatetoPaymentsPageFromMAP();
	    	navigateToManagePaymentCardDetailsPage();
	    	browser.wait(5000);
	    	
	    	
	    }
	    
	    public void submitCard(){
	    	verifyAndClickWithXpath(pageProperties.getProperty("Payments.submitCard"), "Submit Card");
	    }
	    public void cardStorageFunctionalityE2E(){
	    	for(int i=1;i<=2;i++){
	    		MakeAPaymentCardDetails makeAPaymentCardDetails =new TestDataHelper().getMakeAPaymentCardDetails("Card"+i);
	    		if(i==1){
	    			if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Payments.PaymentCardsSection"))){
	    	        	verifyAndClickWithXpath(pageProperties.getProperty("Payments.addANewPaymentCard"), "Add A New Payment Card");
	    	        	enterCardDetails(makeAPaymentCardDetails);
	    	        	verifyPaymentCardSection(i);
	    	        	verifyMakeAPaymentPage(makeAPaymentCardDetails,i);
	    	        	
	    		    }
	    		    else{
	    		    	enterCardDetails(makeAPaymentCardDetails); 
	    		    	verifyPaymentCardSection(i);
	    		    	verifyMakeAPaymentPage(makeAPaymentCardDetails,i);
	    		    }	
	    			
	    		}
	    		else{
	    			addAPaymentCard(makeAPaymentCardDetails);
	    			verifyPaymentCardSection(i);
    	        	verifyMakeAPaymentPage(makeAPaymentCardDetails,i);
	    			
	    			
	    		}
	    	}
	    }  
	    public void verifyMAPManageSection(){
	    	/*browser.open(ApplicationConfig.APP_BG_URL+"/manage-payment-cards/retrieve-cards/");
	    	browser.wait(5000);*/
	    	if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Payments.RowsAddedwithDefault"))){
		    	Report.updateTestLog("Card Details Updated with Default", "WARN");	
		    }
		    else{
		    	Report.updateTestLog("Card Details not Updated with Default", "FAIL");	
		    }
	    	
	    }
	    public void deleteCard(){
	    	verifyAndClickWithXpath(pageProperties.getProperty("Payments.deletePaymentCard"), "Delete Payment Card");
	    	verifyIsTextPresent(pageProperties.getProperty("Payments.confirmAndDeletion"));
	    	verifyIsElementVisibleWithXpath(pageProperties.getProperty("Payments.deletionNoButton"), "Delete Payment Card");
	    	verifyAndClickWithXpath(pageProperties.getProperty("Payments.deletionYesButton"), "Delete Payment Card");
	    	verifyAddANewCardPage();
	    }
	    public void verifyAddANewCardPage(){
	    	verifyIsTextPresent(pageProperties.getProperty("Payments.addANewCard"));
	    	
	    }
	    public void editCard(){
	    	verifyAndClickWithXpath(pageProperties.getProperty("Payments.editPaymentCard"), "Edit Payment Card");
	    	browser.dynamicWaituntilClickablebyID(pageProperties.getProperty("Payments.editCardHolderName"));
	    	verifyAndInputById(pageProperties.getProperty("MakePayment.CardName"),"Card Name","Ramdin");
	    	verifyAndSelectDropDownBox(pageProperties.getProperty("MakePayment.EndMonth"),"","8");
	    	verifyAndSelectDropDownBox(pageProperties.getProperty("MakePayment.EndYear"),"","2016");
	    	verifyAndClickWithXpath(pageProperties.getProperty("Payments.submitCard"), "Submit Card");
	    	
	    	
	    }
	    public void verifyEditedDetails(){
	    	String editName="Ramdin";
	    	String cardName=browser.getTextByXpath(pageProperties.getProperty("MakePayment.CardNameText"));
	    	System.out.println("5555555555555555555555555555555555"+cardName);
	    	if(editName.equals(cardName)){
	    		Report.updateTestLog("The name got edited Successfully", "WARN");
	    	}
	    	else{
	    		Report.updateTestLog("The name not got edited Successfully", "FAIL");
	    	}
	    	String editExpiryDate="08/2016";
	    	String expiryDate=browser.getTextByXpath(pageProperties.getProperty("MakePayment.CardExpiryDateText"));
	    	System.out.println("666666666666666666666666666666666666666"+expiryDate);
	    	if(editExpiryDate.equals(expiryDate)){
	    		Report.updateTestLog("The Expiry Date got edited Successfully", "PASS");
	    	}
	    	else{
	    		Report.updateTestLog("The Expiry Date not got edited Successfully", "FAIL");
	    	}
	    }
public void makeAPaymentJourneyNew(int card)
	    
	    {
	    	try{
	    	String cardtype[]={"Visa Debit", "Visa Delta", "Visa Credit Card","MasterCard"};
	    	if(cardtype[card].equals("Visa Debit"))
	    	{
	    		verifyAndInputById(pageProperties.getProperty("MakePayment.AmountToPay"),"", "10.00");
	    		verifyAndInputById(pageProperties.getProperty("MakePayment.CVV_New"),"", "751");
	    		
	    	}
	    	if(cardtype[card].equals("Visa Delta"))
	    	{
	    		verifyAndInputById(pageProperties.getProperty("MakePayment.AmountToPay"),"", "11.00");
	    	}
	    	if(cardtype[card].equals("Visa Credit Card"))
	    	{
	    		verifyAndInputById(pageProperties.getProperty("MakePayment.AmountToPay"),"", "12.00");
	    	}
	    	if(cardtype[card].equals("MasterCard"))
	    	{
	    		verifyAndInputById(pageProperties.getProperty("MakePayment.AmountToPay"),"", "13.00");
	    	}
            browser.wait(5000);
            verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("MakePayment.CardType"), "Master Card", cardtype[card]);
	    	System.out.println("88888888888888888888888888888888888888888888888888888888888888888888888888");
	    	verifyAndInputById(pageProperties.getProperty("MakePayment.CardName"),"Card Name", "Cat");
	    	if(cardtype[card].equals("Visa Debit"))
	    	{
	    	verifyAndInputById(pageProperties.getProperty("MakePayment.CVV"),"", "751");
	    	}
	    	if(cardtype[card].equals("Visa Delta"))
	    	{
	    	verifyAndInputById(pageProperties.getProperty("MakePayment.CardNumber"), "Card number","4411763723987333");
	    	verifyAndInputById(pageProperties.getProperty("MakePayment.CVV"),"", " 722");
	    	}
	    	if(cardtype[card].equals("Visa Credit Card"))
	    	{
	    	verifyAndInputById(pageProperties.getProperty("MakePayment.CardNumber"), "Card number","4532386709727657");
	    	verifyAndInputById(pageProperties.getProperty("MakePayment.CVV"),"", "152");
	    	}
	    	if(cardtype[card].equals("MasterCard"))
	    	{
	    	verifyAndInputById(pageProperties.getProperty("MakePayment.CardNumber"), "Card number","5466144301991743");
	    	verifyAndInputById(pageProperties.getProperty("MakePayment.CVV"),"", "772");
	    	}
	    	verifyAndInputById(pageProperties.getProperty("MakePayment.CVV"),"", "123");
	    	verifyAndSelectDropDownBox(pageProperties.getProperty("MakePayment.EndMonth"),"","8");
	    	verifyAndSelectDropDownBox(pageProperties.getProperty("MakePayment.EndYear"),"","2019");
	    	Report.updateTestLog("Payment Details Page", "WARN");
	    	verifyAndClickWithXpath(pageProperties.getProperty("Payments.saveCardToProfileCheckBox"),"Save Card ToP rofile Check Box");
	    	Report.updateTestLog("Payment Now Page", "WARN");
	    	verifyAndClickWithXpath(pageProperties.getProperty("MakePayment.Continue"), "MakeAPayment Continue");
	    	
	     	Report.updateTestLog("Payment Now Page", "WARN");
	    	} catch (Exception e) {
				e.printStackTrace();
			}
	    }
}
