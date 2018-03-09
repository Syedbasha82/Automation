package bg.framework.app.functional.page.selfServe;

import java.util.Properties;

import org.openqa.selenium.WebElement;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.MakeAPaymentProfile;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.RobotSendKeys;

 public class CQMakeAPaymentPage extends BasePage{
	 
	 private final static String FILE_NAME = "resources/selfServe/MakeAPayment.properties";
	 private static Properties pageProperties = new PropertyLoader(FILE_NAME)
				.load();
	
	 public void SelectAccount(String accountNumber) {
			String accountCheckBoxXpath = pageProperties
					.getProperty("MakeAPayment.AccountXpath");
			accountCheckBoxXpath = accountCheckBoxXpath.replace("AccountNumber",
					accountNumber);
			verifyAndSelectCheckBoxByXpath(accountCheckBoxXpath,
					"Account Select Check Box");
			browser.wait(getWaitTime());
		}
	 
	 public void navigateToMAPPage() {

			//browser.open("http://localhost/newJourneys/make-a-payment/makeapayment1.html");
			browser.open("http://10.58.66.7:7001/content/britishgas/newJourneys/make-a-payment/makeapayment1.html");
			//browser.open(ApplicationConfig.APP_BG_URL+"new-journey/SMR1.html");
			browser.wait(getWaitTime());
			
		}
	 
	 public void ClickonContinue(){
		 browser.clickWithXpath(pageProperties.getProperty("MakeAPayment.ContinueButtonXpath"));
		 	 }

	 public void EnterAmount(){		 
		browser.getChildelementBasedonOrder(pageProperties.getProperty("MakeAPayment.AmountToPayInPUTXpath"), 0).clear();		
		 browser.inputByXpath(pageProperties.getProperty("MakeAPayment.AmountToPayInPUTXpath"), pageProperties.getProperty("MakeAPayment.AmountToPay"));
		 
	 }

	 
	 public void EnterCardDetails(MakeAPaymentProfile makeAPaymentProfile){
		 
		 verifyAndSelectDropDownBox("cardType","Card Type" ,makeAPaymentProfile.getCardType());
		 verifyAndInputByXpath((pageProperties.getProperty("MakeAPayment.NameInPUTXpath")),"Name on Card",makeAPaymentProfile.getFirstName());
		 verifyAndInputByXpath((pageProperties.getProperty("MakeAPayment.CardNumberXpath")),"Card Number",makeAPaymentProfile.getCardNumber());
		 verifyAndSelectDropDownBox("cardStartMonth","Start Month" ,makeAPaymentProfile.getCardStartMonth());
		 verifyAndSelectDropDownBox("cardStartYear","Start Year" ,makeAPaymentProfile.getCardStartYear());
		 verifyAndSelectDropDownBox("cardExpiryMonth","Card Expiry Month" ,makeAPaymentProfile.getCardEndMonth());
		 verifyAndSelectDropDownBox("cardExpiryYear","Card Expiry Year" ,makeAPaymentProfile.getCardEndYear());	
		 verifyAndInputByXpath((pageProperties.getProperty("MakeAPayment.CardIssueNumberXpath")),"Card Issue Number",makeAPaymentProfile.getCardIssueNumber());
		 verifyAndInputByXpath((pageProperties.getProperty("MakeAPayment.CardSecurityNumberXpath")),"Card Securty Number",makeAPaymentProfile.getcardSecurityNumber());
		 browser.clickWithXpath(pageProperties.getProperty("MakeAPayment.ContinueButtonXpath"));
		 
	 }
	 
 public void EnterCardDetailsWithNoCardSecurtityNumber(MakeAPaymentProfile makeAPaymentProfile){
		 
		 verifyAndSelectDropDownBox("cardType","Card Type" ,makeAPaymentProfile.getCardType());
		 verifyAndInputByXpath((pageProperties.getProperty("MakeAPayment.NameInPUTXpath")),"Name on Card",makeAPaymentProfile.getFirstName());
		 verifyAndInputByXpath((pageProperties.getProperty("MakeAPayment.CardNumberXpath")),"Card Number",makeAPaymentProfile.getCardNumber());
		 verifyAndSelectDropDownBox("cardStartMonth","Start Month" ,makeAPaymentProfile.getCardStartMonth());
		 verifyAndSelectDropDownBox("cardStartYear","Start Year" ,makeAPaymentProfile.getCardStartYear());
		 verifyAndSelectDropDownBox("cardExpiryMonth","Card Expiry Month" ,makeAPaymentProfile.getCardEndMonth());
		 verifyAndSelectDropDownBox("cardExpiryYear","Card Expiry Year" ,makeAPaymentProfile.getCardEndYear());	
		 //verifyAndInputByXpath((pageProperties.getProperty("MakeAPayment.CardIssueNumberXpath")),"Card Issue Number",makeAPaymentProfile.getCardIssueNumber());
		 verifyAndInputByXpath((pageProperties.getProperty("MakeAPayment.CardSecurityNumberXpath")),"Card Securty Number",makeAPaymentProfile.getcardSecurityNumber());
		 browser.clickWithXpath(pageProperties.getProperty("MakeAPayment.ContinueButtonXpath"));
		 
	 }
	 
	 public void VerifyCardConfirmation(MakeAPaymentProfile makeAPaymentProfile){
		 
		 //verifyIsElementVisibleWithXpath(pageProperties.getProperty("MakeAPayment.ContinueButtonXpath"),"Amount To Pay Button");
		 //verifyIsTextPresent(makeAPaymentProfile.getFirstName());
		 //verifyIsTextPresent(makeAPaymentProfile.getCardNumber());
		 //verifyIsTextPresent(makeAPaymentProfile.getCardName());
		 //verifyIsTextPresent(pageProperties.getProperty("MakeAPayment.AmountToPay"));		 
		 //browser.clickWithXpath(pageProperties.getProperty("MakeAPayment.ContinueButtonXpath"));
		 browser.selectWindowById(0);
		 browser.clickWithXpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/input[1]");
		 //RobotSendKeys.typeenter();
		 browser.closeAlert();
		 browser.swtichToDefaultContent();
		 		 
	 }
	 
	 public void VerifyConfirmationLastCheck(MakeAPaymentProfile makeAPaymentProfile){
		 verifyIsTextPresent("Your previous balance");
		 verifyIsTextPresent("Amount Paid");
		 verifyIsTextPresent("Your Current Balance");
		 verifyIsTextPresent("Thank you");
		 verifyIsTextPresent(pageProperties.getProperty("MakeAPayment.AmountToPay"));
		 
	 }
	 
	 public void Verify3DSecurePage(MakeAPaymentProfile makeAPaymentProfile){
		 //
		 //verifyIsElementVisibleWithXpath(pageProperties.getProperty("MakeAPayment.3DSecurePasswordXpath"),"Amount To Pay Button");
		 browser.selectWindowById(0);
		 //RobotSendKeys.type("\t");
		 //RobotSendKeys.type("dog33cat");
		 verifyAndInputByXpath((pageProperties.getProperty("MakeAPayment.3DSecurePasswordXpath")),"Security Answer",makeAPaymentProfile.getSecurityAnswer());
		 browser.clickWithXpath(pageProperties.getProperty("MakeAPayment.3DSecureSubmitButtonXpath"));
		 browser.closeAlert();
		 browser.swtichToDefaultContent();
		 
		 //		 		 
	 }
	 
	 public void navigateToLoginPageMAP() {
	        if(browser.isElementVisible(pageProperties.getProperty("HomePage.Logout"))) {
	            browser.clickWithLinkText(pageProperties.getProperty("HomePage.Logout"));
	            browser.wait(getWaitTime());
	            browser.open(ApplicationConfig.APP_BG_URL);
	        }
	        
	        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("HomePage.LoginPageLink"))) {
	            browser.clickWithXpath(pageProperties.getProperty("HomePage.LoginPageLink"));
	            Report.updateTestLog("Login Link is Selected Successfully ", "PASS");
	        } 
	        
	        browser.wait(getWaitTime());
	    
	    }
	 public void loginUser(MakeAPaymentProfile makeAPaymentProfile) {
	       final String expectedEmailAdd = new OnlineDBConnector().getUserEmail(makeAPaymentProfile.getUCRN());
	        verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id", expectedEmailAdd);
	        //verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id", makeAPaymentProfile.getEmail());
	        verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password", makeAPaymentProfile.getPassword());
	        //browser.clickWithClass(pageProperties.getProperty("LoginPage.LoginSubmitClass"));
	        browser.clickWithXpath(pageProperties.getProperty("LoginPage.NewLoginSubmitXpath"));
	        browser.wait(getWaitTime());
	        continueToMyAccount();
	        //closeInfoOverlay();
	    }

	    public void continueToMyAccount(){
            if(browser.isElementVisible("Continue to my account")){
            	browser.clickWithLinkText("Continue to my account");
            }
            if(browser.isElementVisibleWithXpath(".//*[@id='splash_overlay']/div/div[3]/div[2]/div/p[6]/span/a")){
         browser.clickWithLinkText("Continue to my account");
            }
            if (browser.isElementVisibleWithXpath(pageProperties.getProperty("LoginPage.welcomeMessage"))) {
            	Report.updateTestLog("User logged in Successfully", "PASS");
            	browser.clickWithXpath(pageProperties.getProperty("LoginPage.welcomeMessage"));
            }
}
	 
	 
	 
	 }
	 
	 
 
 
