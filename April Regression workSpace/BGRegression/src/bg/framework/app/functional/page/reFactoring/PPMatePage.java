package bg.framework.app.functional.page.reFactoring;

import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import java.util.Random;

import bg.framework.app.functional.entities.MakeAPaymentCardDetails;
import bg.framework.app.functional.entities.MakeAPaymentProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.common.functional.UIDriver;
import bg.framework.common.functional.WebDriverProvider;
import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.TestDataHelper;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;



public class PPMatePage extends BasePage{

private final static String FILE_NAME = "resources/ReFactoring/PPMate.properties";
private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
private static String strEmail;
private static String frequencycontent;
private static String actualcontent;

	
public void navigateToAccountSummaryPage(){
	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PPMate.manageAccount"))){
	verifyAndClickWithXpath(pageProperties.getProperty("PPMate.manageAccount"),"Manage Account");
	Report.updateTestLog("Manage Account Button is clicked successfully", "Pass");
	}
	else{
		Report.updateTestLog("Manage Account Button is not present in an application", "Fail");
	}
}

// verify Account Overview Page //
public void verifyAccountOverviewPage(){
	
}

// Navigating to Top up yourself Page //
public void navigateToTopupPage(){
	browser.wait(getWaitTime());
	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PPMate.TopupYourselfLink"))){
		verifyAndClickWithXpath(pageProperties.getProperty("PPMate.TopupYourselfLink"),"Topup Yourself Link");
		Report.updateTestLog("Topup Yourself Link is clicked successfully", "WARN");
	}
	else{
		Report.updateTestLog("Topup Yourself Link is not present in an application", "Fail");
	}
}
//Enter Topup amount manually 
public void EnterTopupamount(){
	browser.wait(getWaitTime());
	verifyAndInputByXpath(pageProperties.getProperty("PPMate.EnterAmount"), "TopUpAmount", "9");
	
}

//provide details in Top and Pay Page

public void AddPaymentCard(){
	browser.wait(getWaitTime());
	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PPMate.AddPaymentCard"))){
		verifyAndClickWithXpath(pageProperties.getProperty("PPMate.AddPaymentCard"),"Add a Payment Card Link");
		Report.updateTestLog("Add a Payment Card Link is clicked successfully", "WARN");
	}
	else{
		Report.updateTestLog("Add a Payment Card Link is not present in an application", "Fail");
	}
	
}

// provide details in Top and Pay Page
public void topAndPayPageDetails(){
	browser.wait(getWaitTime());
	verifyAndClickWithXpath(pageProperties.getProperty("PPMate.dropdownRadioButton"),"Dropdown Radio Button");
	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PPMate.selectAmountFromDropDown"))){
		verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("PPMate.selectAmountFromDropDown"), "Amount", "£10");
	}
	verifyAndInputByXpath(pageProperties.getProperty("PPMate.CVVNumber"), "CSVNumber", "123");
	verifyAndClickWithXpath(pageProperties.getProperty("PPMate.submitButton"),"Submit Button");
}

// verify Review and confirm page
public void verifyReviewAndConfirmPage(){
	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PPMate.AmountTopUp"))){
		Report.updateTestLog("Review and Confirm Page", "WARN");
	}
	browser.clickWithXpath(".//span[@class='smartPPVeditIcon']/a");
	browser.inputByXpath(".//*[@name='emailPlaceholder']", "Sowmya@bgdigitaltest01.co.uk");
	verifyAndClickWithXpath(pageProperties.getProperty("PPMate.submitButton"),"Submit Button");
	browser.wait(10000);
	//browser.selectWindowById(0);
	//verifyAndClickWithXpath(".//*[@id='CompanyLogo']","Logic group");
	//browser.swtichToDefaultContent();
	browser.wait(15000);
	Report.updateTestLog("Confirmation Page", "WARN");
}



// verify confirmation page
public void verifyTopUpConfirmationPage(){
	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PPMate.TopUpAmountDisplayed"))){
		String topUpAmountDisplayed = browser.getTextByXpath(pageProperties.getProperty("PPMate.TopUpAmountDisplayed"));
		Report.updateTestLog("Top Up Amount Displayed :  " + topUpAmountDisplayed + "  Successfully", "PASS");
	}
	else{
		Report.updateTestLog("Top Up Amount is not displayed successfully", "FAIL");
	}
	
	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PPMate.TopUpCode"))){
		String topUpCode = browser.getTextByXpath(pageProperties.getProperty("PPMate.TopUpCode"));
		Report.updateTestLog("Top Up Code Displayed :  " + topUpCode + "  Successfully", "WARN");
	}
	else{
		Report.updateTestLog("Top Up Code is not displayed successfully", "FAIL");
	}
}
// Verify Left Hand navigation Link 
public void verifyLHNLinksInAccountSummaryPage(){
	String Links[] = {"Topup" ,"TopupHistory", "ManagePaymentCards","MovingHome" ,"SmartData" ,"MoreFromBritishGas"};
	for (int i = 0 ; i <= Links.length; i++){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PPMate."+Links[i]))){
			verifyAndClickWithXpath(pageProperties.getProperty("PPMate."+Links[i]),"LHS Link : " + Links[i]);
			browser.browserBack();
			Report.updateTestLog("LHN Link : " + Links[i] +  " is present in an application", "Pass");
		}
	}
}

// Verify Top up History
public void verifyTopupHistory(){
	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PPMate.TopupHistory"))){
		Report.updateTestLog("Top Up History is displayed successfully in Account Summary Page", "Pass");
	}
	else{
		Report.updateTestLog("Top Up History is not displayed successfully in Account Summary Page", "Fail");
	}
	// navigating to Top up history page
	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PPMate.viewTopupHistory"))){
		verifyAndClickWithXpath(pageProperties.getProperty("PPMate.viewTopupHistory"),"View Top up History Link");
		Report.updateTestLog("View Top up History Link is Clicked successfully", "Pass");
	}
	else{
		Report.updateTestLog("View top up History link is not present in an application", "Fail");
	}
	
}

// verifying my payment cards section

public void verifyMyPaymentCardsSection(){
	
	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PPMate.paymentCardsTable"))){
    WebElement table;
	table = browser.getElementByXpath(pageProperties.getProperty("PPMate.paymentCardsTable"));
	table.getSize();
	System.out.println("11111111111111111111111111111111" + table.getSize());
	}
}


public void navigateToAccountSummaryPage(UserProfile userProfile) {
       /* browser.wait(getWaitTime());*/
    	Report.updateTestLog("The account overview page", "WARN");
        verifyAndClickWithXpath((pageProperties.getProperty("PPMate.ManageAccountXPath").replace("AcctNum", userProfile.getAccNumber())), "Account summary");
        
    }


// Update your details Page
public void Meterreadfrequency() {
    
	verifyAndClickWithXpath(pageProperties.getProperty("PPMate.MeterFrequencycheckBox"), "Your meter read frequency Check box");
	Report.updateTestLog("Your meter read frequency Check box is selected successfully", "WARN");
	browser.wait(3000);
	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PPMate.submitButton"))){
		verifyAndClickWithXpath(pageProperties.getProperty("PPMate.submitButton"),"Submit Button");
		Report.updateTestLog("Submit Button is clicked successfully", "Pass");
	}
	else{
		Report.updateTestLog("Submit Button is not present in an application", "Fail");
	}
	     
 }

public void updateDetails() {
    
	Report.updateTestLog("Your details have been updated page is displayed", "WARN");
	browser.wait(3000);
	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PPMate.Gotouraccount"))){
		verifyAndClickWithXpath(pageProperties.getProperty("PPMate.Gotouraccount"),"Go to ur Button");
		Report.updateTestLog("Go to ur Button is clicked successfully", "Pass");
	}
	else{
		Report.updateTestLog("Go to ur Button is not present in an application", "Fail");
	}
	     
 }


public void contentVerification()
{
	frequencycontent = "Your meter read frequency is set to Half Hourly";
	actualcontent = browser.getTextByXpath(pageProperties.getProperty("PPMate.FrequeuecyContent"));
if (frequencycontent.trim().contains(frequencycontent.trim())) {
    Report.updateTestLog("Expected content is : "+frequencycontent +"it is correct", "Warn");
} else {
    Report.updateTestLog("Expected Email Address "+frequencycontent+" is Not correct", "Fail");
   }
}

public void navigateToUpdateDetailsPage() {
    
	browser.open(ApplicationConfig.APP_BG_URL+"/Self-Service/Personal-Details-Entry/");
	
     
 }

// verifying 
public void navigateToManagePaymentCardsPage() {
	Report.updateTestLog("The account overview page", "WARN");
	verifyAndClickWithXpath(pageProperties.getProperty("PP.Managepaymentcard"), "Manage Payment Card");
     
 }

  public void cardStorageFunctionality(){
       for(int i=1;i<=2;i++){
    	MakeAPaymentCardDetails makeAPaymentCardDetails =new TestDataHelper().getMakeAPaymentCardDetails("Card"+i);
        /*if (browser.isElementVisibleWithXpath(pageProperties.getProperty("PPMate.addANewPaymentCard"))){
        	verifyAndClickWithXpath(pageProperties.getProperty("PPMate.addANewPaymentCard"), "Add A New Payment Card");*/
    	if (browser.isElementVisibleWithXpath(pageProperties.getProperty("PPMate.AddaNewCard"))){
        	verifyAndClickWithXpath(pageProperties.getProperty("PPMate.AddaNewCard"), "Add A New Payment Card");
        	enterCardDetails(makeAPaymentCardDetails);		
	    }
        else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PPMate.paymentCardLHN"))){
        	verifyAndClickWithXpath(pageProperties.getProperty("PPMate.paymentCardLHN"), "Manage Payment Card LHN Link");
        	enterCardDetails(makeAPaymentCardDetails);	
        }
        verifyPaymentCardSection(i);
       
    }
  }
  public void AddPaymentcardFunctionality(){
	  verifyAndInputByXpath(pageProperties.getProperty("PPMate.CardNumber"), "CardNumber", "4916700543081178");
	  verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("PPMate.CardType"), "Card Type", "Visa Debit");
	  verifyAndInputByXpath(pageProperties.getProperty("PPMate.CardHolderName"), "cardHolderName", "Testing");
	  verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("PPMate.ExpiryMonth"), "Expiry Month", "5");
	  verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("PPMate.ExpiryYear"), "Expiry Year", "2020");
	  verifyAndInputByXpath(pageProperties.getProperty("PP.Mate.CVV"), "CVV", "143");
	  if(browser.isElementVisibleWithXpath(pageProperties.getProperty("PPMate.submitButton"))){
			verifyAndClickWithXpath(pageProperties.getProperty("PPMate.submitButton"),"Submit Button");
			Report.updateTestLog("Submit Button is clicked successfully", "WARN");
		}
		else{
			Report.updateTestLog("Submit Button is not present in an application", "Fail");
		}

      
   
 }
  
  
  
  public void enterCardDetails(MakeAPaymentCardDetails makeAPaymentCardDetails){
    	verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("PPMate.CardType"), "Master Card",makeAPaymentCardDetails.getCardType());
    	verifyAndInputById(pageProperties.getProperty("PPMate.CardName"),"Card Name", makeAPaymentCardDetails.getNameOnCard());
    	browser.wait(3000);
    	//verifyAndInputById(pageProperties.getProperty("PPMate.CardNumber"), "Card number",makeAPaymentCardDetails.getCardNumber());
    	verifyAndInputByXpath(pageProperties.getProperty("PPMate.CardNumber"), "Card number",makeAPaymentCardDetails.getCardNumber());
    	verifyAndSelectDropDownBox(pageProperties.getProperty("PPMate.EndMonth"),"End Month",makeAPaymentCardDetails.getExpiryMonth());
    	verifyAndSelectDropDownBox(pageProperties.getProperty("PPMate.EndYear"),"End Year",makeAPaymentCardDetails.getExpiryYear());
    	//verifyAndClickWithXpath(pageProperties.getProperty("PPMate.DefaultCardCheckBox"),"Default Card Check Box");
    	//verifyIsElementVisibleWithLinkText(pageProperties.getProperty("Payments.backlink"),"Back Link");
        submitCard();
    }

  public void verifyPaymentCardSection(int i){
	  verifyAndClickWithXpath(".//*[@id='manageCardLinkDiv']/div/p/a/span","Manage Saved Cards");
    	String rowNumber=String.valueOf(i);
    	if (browser.isElementVisibleWithXpath(pageProperties.getProperty("PPMate.RowsAdded").replace("NUM", rowNumber))){
	    	Report.updateTestLog("Card Details Updated", "WARN");	
	    }
	    else{
	    	Report.updateTestLog("Card Details not Updated", "FAIL");	
	    }
    	if (browser.isElementVisibleWithXpath(pageProperties.getProperty("PPMate.RowsAddedwithDefault").replace("NUMBER", rowNumber))){
	    	Report.updateTestLog("Card Details Updated with Default", "PASS");	
	    }
	    else{
	    	Report.updateTestLog("Card Details not Updated with Default", "FAIL");	
	    }
    	verifyAndClickWithXpath(pageProperties.getProperty("PPMate.BackToSummaryPageButton"),"Back To Your Account");
    }
  
  public void submitCard(){
    	verifyAndClickWithXpath(pageProperties.getProperty("PPMate.submitCard"), "Submit Card");
    }
  
  public void verifyDeletedRow(int i){
    	String rowNumber=String.valueOf(i);
    	if (browser.isElementVisibleWithXpath(pageProperties.getProperty("PPMate.DeletedCardNumber").replace("NUM", rowNumber))){
	    	Report.updateTestLog("Card Details not Deleted", "FAIL");	
	    }
	    else{
	    	Report.updateTestLog("Card Details is Deleted", "WARN");	
	    }
    	
    	verifyAndClickWithXpath(pageProperties.getProperty("PPMate.BackToSummaryPageButton"),"Back To Your Account");
    }
  
  
  public void deleteCardFunctionality(){
       for(int i=1;i<=2;i++){
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("PPMate.deleteCard").replace("NUMBER", i+""))){
        	verifyAndClickWithXpath(pageProperties.getProperty("PPMate.deleteCard").replace("NUMBER", i+""), "Delete Card");
        	verifyAndClickWithXpath(pageProperties.getProperty("PPMate.deleteYesButton"),"Delete Yes Button");
        	verifyDeletedRow(i);
	    }
       
    }
  }
      
  public void updateCustomerDetails(UserProfile userProfile){
	  navigateToUpdateYourDetails();
	  updateDetailsInManagePersonalDetails(userProfile);
	  updateCommunicationPreference();
	  goToYourAccountPage();
  }
  
  public void navigateToUpdateYourDetails(){
	  browser.open(ApplicationConfig.APP_BG_URL+"/Self-Service/Personal-Details-Entry/");
  }
  
  public void updateDetailsInManagePersonalDetails(UserProfile userProfile){
	  browser.wait(1000);
        int intRandomNumbers;
        Random random = new Random();
        intRandomNumbers = random.nextInt(1000);
        strEmail = "digital_test" + intRandomNumbers + "@bgdigitaltest.co.uk";
        System.out.print("digital_test" + intRandomNumbers + "@bgdigitaltest.co.uk");
        userProfile.setEmail(strEmail);
        verifyAndInputById(pageProperties.getProperty("PPMate.EmailAddress"), "Email Address Field", strEmail);
        verifyAndInputById(pageProperties.getProperty("PPMate.ReEnterEmailAddress"), "ReEnterEmailAddress Field", strEmail);
        verifyAndInputById(pageProperties.getProperty("PPMate.NewPassword"), "NewPassword Field", "temp1234");
        verifyAndInputById(pageProperties.getProperty("PPMate.ConfirmNewPassword"), "ConfirmNewPassword Field", "temp1234");
        userProfile.setPassword("temp1234");
        if(browser.isElementVisible(pageProperties.getProperty("PPMate.MobileNumber"))){
        	verifyAndInputById(pageProperties.getProperty("PPMate.MobileNumber"), "MobileNumber Field", "07123456782");	
        }
        if(browser.isElementVisible(pageProperties.getProperty("PPMate.HomeNumber"))){
        	verifyAndInputById(pageProperties.getProperty("PPMate.HomeNumber"), "HomeNumber Field", "01234567143");	
        }
        if(browser.isElementVisible(pageProperties.getProperty("PPMate.WorkNumber"))){
        	verifyAndInputById(pageProperties.getProperty("PPMate.WorkNumber"), "WorkNumber Field", "01234567416");	
        }
        verifyAndClickWithXpath(pageProperties.getProperty("PPMate.SaveChangesBtn"), "Save Changes Button");
  }
  
  public void updateCommunicationPreference(){
	  verifyAndClickWithXpath(pageProperties.getProperty("PPMate.smsPreference"), "SMS preference CheckBox");
	  verifyAndClickWithXpath(pageProperties.getProperty("PPMate.SaveChangesBtn"), "Save Changes Button");
  }
  
  public void goToYourAccountPage(){
	  verifyAndClickWithXpath(pageProperties.getProperty("PPMate.goToYourAccount"), "Go To Your Account Link");
  }

}
