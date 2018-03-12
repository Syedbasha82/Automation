package bg.framework.app.functional.page.selfServe;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;

import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.page.selfServe.NectarPage;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.SapNetWeaverPage;
import bg.framework.app.functional.page.common.BasePage;

import java.util.Properties;

public class SubmitMeterReadPage extends BasePage {

	private final static String FILE_NAME = "resources/selfServe/SubmitMeterReadPage.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	private static final int selectAccountColumn = 4;
	private static final int accountNumberColumn = 1;
	public String currentMeterRead;

	public void selectAccount(String accountNumber) {
		int accountCount = browser.getRowCountByXpath(pageProperties
		        .getProperty("SubmitMeterRead.AccountTableXpath"));
		for (int i = 1; i <= accountCount; i++) {
			String currentAccount = browser.getCellValueByXpath(
			        pageProperties.getProperty("SubmitMeterRead.AccountTableXpath"), i,
			        accountNumberColumn);
			if (currentAccount.trim().equalsIgnoreCase(accountNumber)) {
				String selectAccountBox = pageProperties
				        .getProperty("SubmitMeterRead.AccountSelectXpath");
				selectAccountBox = selectAccountBox.replace("ROWNUM", i + "");
				selectAccountBox = selectAccountBox.replace("COLNUM", selectAccountColumn
				        + "");
				browser.clickWithXpath(selectAccountBox);

			}

		}

	}

	public void confirmAccountSelection() {
		String logInfo = "";
		String logStatus = "PASS";
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("SubmitMeterRead.confirmAccountSelectionXpath"))) {
		browser.clickWithXpath(pageProperties
		        .getProperty("SubmitMeterRead.confirmAccountSelectionXpath"));
		}
		/*
		 * String expectedPageTitle = pageProperties.getProperty(
		 * "SubmitMeterRead.yourReading.Title").trim(); if
		 * (!expectedPageTitle.equalsIgnoreCase
		 * (browser.getTextByXpath("//title"))) { logInfo = logInfo +
		 * " Your Reading Page title does not match with expected. Expected page Title: '"
		 * + expectedPageTitle + "', Actual page Title: <b> " +
		 * browser.getTextByXpath("//title") + "'</b>. "; logStatus = "FAIL"; }
		 * else { logInfo = logInfo +
		 * "Your Reading Page title matches with expected. "; // NOPMD // by //
		 * !boobalas // on // 14/03/12 // 12:51 }
		 */
		Report.updateTestLog(logInfo, logStatus);

	}

	public void setImPlausbileReadingHigh(String accountNumber) {
		browser.wait(getWaitTime());
		verifyAndSelectCheckBoxByID(accountNumber, "Select CheckBox");
		String logInfo = " Setting Plausible Reading for Account: " + accountNumber;
		String logStatus = "DONE";
		String previousMeterValue = getPreviousMeterRead(accountNumber);
		String meterSerialNumber = getMeterSerialNumber(accountNumber);
		logInfo = logInfo + " The meter Serial Number is: " + meterSerialNumber
		        + ", The Previous Meter Read value is: " + previousMeterValue;

		String dialFieldsxPath = pageProperties
		        .getProperty("SubmitMeterRead.MeterInputFieldsXpath");
		dialFieldsxPath = dialFieldsxPath.replace("METERNAME", meterSerialNumber);

		// Add +1 to the existing reading to make Plausible
		previousMeterValue = (Integer.parseInt(previousMeterValue) + 1) + "";
		int dialFieldCount = browser.getChildElementsCountByXpath(dialFieldsxPath);
		// TODO: update
		previousMeterValue = previousMeterValue.length() == dialFieldCount ? previousMeterValue
		        : padZeros(previousMeterValue, dialFieldCount);
		previousMeterValue = "9999";
		for (int i = 1; i <= dialFieldCount; i++) {

			browser.inputByXpath(dialFieldsxPath + "[" + i + "]", "9");
		}
		this.currentMeterRead = previousMeterValue;
		submitMeterReads();
		if (!browser.isElementVisible(pageProperties
		        .getProperty("SubmitMeterRead.SubmitAlertOverlayId"))) {
			logInfo = logInfo
			        + " Alert OverLay is displayed for Implaussible MeterRead.";
			logStatus = "PASS";
			browser.clickWithXpath(pageProperties
			        .getProperty("SubmitMeterRead.OverlaySubmitButtonXpath"));
		} else {
			browser.clickWithXpath(pageProperties
			        .getProperty("SubmitMeterRead.OverlaySubmitButtonXpath"));
		}

		Report.updateTestLog(logInfo, logStatus);

	}

	public void setPlausbileReading(String accountNumber) {
		browser.wait(getWaitTime());
		//verifyAndSelectCheckBoxByID(accountNumber, "Select CheckBox");
		verifyAndClickWithXpath("//input[@value='"+accountNumber+"']", "Select CheckBox");
		
		String logInfo = " Setting Plausible Reading for Account: " + accountNumber;
		String logStatus = "DONE";
		String previousMeterValue = getPreviousMeterRead(accountNumber);
		String meterSerialNumber = getMeterSerialNumber(accountNumber);
		logInfo = logInfo + " The meter Serial Number is: " + meterSerialNumber
		        + ", The Previous Meter Read value is: " + previousMeterValue;

		String dialFieldsxPath = pageProperties
		        .getProperty("SubmitMeterRead.MeterInputFieldsXpath");
		dialFieldsxPath = dialFieldsxPath.replace("METERNAME", meterSerialNumber);
		
		String DialsCountxPath = pageProperties
		        .getProperty("SubmitMeterRead.MeterInputDialsXpath");
		DialsCountxPath = DialsCountxPath.replace("METERNAME", meterSerialNumber);
		// Add +1 to the existing reading to make Plausible
		previousMeterValue = (Integer.parseInt(previousMeterValue) + 1) + "";
		//int dialFieldCount = browser.getChildElementsCountByXpath(dialFieldsxPath);
		int dialFieldCount =browser.getChildElementsCountByXpath(DialsCountxPath);
		// TODO: update
		previousMeterValue = previousMeterValue.length() == dialFieldCount ? previousMeterValue
		        : padZeros(previousMeterValue, dialFieldCount);
		
		
		for (int i = 1; i <= dialFieldCount; i++) {
			//browser.inputByXpath(dialFieldsxPath + "[" + i + "]",previousMeterValue.charAt(i - 1) + "");
			browser.inputByXpath(dialFieldsxPath.replace("NUMBER", ""+(i-1)), previousMeterValue.charAt(i - 1) + "");
		}
		this.currentMeterRead = previousMeterValue;
		Report.updateTestLog(logInfo, logStatus);
		submitMeterReads();
	}

	public void setPlausbileReadingNectar(String accountNumber) {
		browser.wait(getWaitTime());
		//verifyAndSelectCheckBoxByID(accountNumber, "Select CheckBox");
		verifyAndClickWithXpath("//input[@value='"+accountNumber+"']", "Select CheckBox");
		
		String logInfo = " Setting Plausible Reading for Account: " + accountNumber;
		String logStatus = "DONE";
		String previousMeterValue = getPreviousMeterRead(accountNumber);
		String meterSerialNumber = getMeterSerialNumber(accountNumber);
		logInfo = logInfo + " The meter Serial Number is: " + meterSerialNumber
		        + ", The Previous Meter Read value is: " + previousMeterValue;

		String dialFieldsxPath = pageProperties
		        .getProperty("SubmitMeterRead.MeterInputFieldsXpath");
		dialFieldsxPath = dialFieldsxPath.replace("METERNAME", meterSerialNumber);
		
		String DialsCountxPath = pageProperties
		        .getProperty("SubmitMeterRead.MeterInputDialsXpath");
		DialsCountxPath = DialsCountxPath.replace("METERNAME", meterSerialNumber);
		// Add +1 to the existing reading to make Plausible
		previousMeterValue = (Integer.parseInt(previousMeterValue) + 1) + "";
		//int dialFieldCount = browser.getChildElementsCountByXpath(dialFieldsxPath);
		int dialFieldCount =browser.getChildElementsCountByXpath(DialsCountxPath);
		// TODO: update
		previousMeterValue = previousMeterValue.length() == dialFieldCount ? previousMeterValue
		        : padZeros(previousMeterValue, dialFieldCount);
		
		
		for (int i = 1; i <= dialFieldCount; i++) {
			//browser.inputByXpath(dialFieldsxPath + "[" + i + "]",previousMeterValue.charAt(i - 1) + "");
			browser.inputByXpath(dialFieldsxPath.replace("NUMBER", ""+(i-1)), previousMeterValue.charAt(i - 1) + "");
		}
		this.currentMeterRead = previousMeterValue;
		Report.updateTestLog(logInfo, logStatus);
	}

	public void nectarSignUp(){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("SubmitMeterRead.NectarSignup"))){
			browser.clickWithXpath(pageProperties.getProperty("SubmitMeterRead.NectarSignup"));
			browser.clickWithXpath(pageProperties.getProperty("SubmitMeterRead.NectarTermsandConditions"));
		}
		else{
			Report.updateTestLog("Nectar Options not found in the application page", "Fail");
		}
	}
	
	private String padZeros(String previousMeterValue, int dialFieldCount) {
		for (int i = previousMeterValue.length(); i <= dialFieldCount; i++) {
			previousMeterValue = "0" + previousMeterValue;
		}
		return previousMeterValue;
	}

	private String getPreviousMeterRead(String accountNumber) {
		String previousMeterRead = "";

	//	String xpathforAcctNum = "//div[@class='dial-info default']/p[1]";
		String xpathforAcctNum = "//div[@class='mtr-ipt-group']/input[contains(@class,'"+accountNumber+"')]/../div[@class='dial-info default']/p[1]";
		previousMeterRead = browser.getTextByXpath(xpathforAcctNum);
		previousMeterRead = previousMeterRead.contains(":") ? previousMeterRead
		        .substring(previousMeterRead.indexOf(':') + 1, previousMeterRead.length())
		        : "";
		return previousMeterRead.trim();

	}

	private String getMeterSerialNumber(String accountNumber) {

		String meterSerialNumber = "";

		//String xpathforAcctNum = "//div[@class='dial-info default']/p[3]";
		String xpathforAcctNum = "//div[@class='mtr-ipt-group']/input[contains(@class,'"+accountNumber+"')]/../div[@class='dial-info default']/p[3]";
		
		meterSerialNumber = browser.getTextByXpath(xpathforAcctNum);
		/*
		 * meterSerialNumber = meterSerialNumber.contains(":") ?
		 * meterSerialNumber .substring(meterSerialNumber.indexOf(":") + 1,
		 * meterSerialNumber.indexOf("(actual")) : "";
		 */
		String meterPrefix = pageProperties
		        .getProperty("SubmitMeterRead.SerialNumberPrefix");
		// Remove other Contents apart form Meter SerialNumber.

		meterSerialNumber = meterSerialNumber.contains(meterPrefix) ? meterSerialNumber
		        .substring(meterSerialNumber.indexOf(meterPrefix) + meterPrefix.length(),
		                meterSerialNumber.length()) : "";

		return meterSerialNumber.trim();
	}

	public void submitMeterReads() {

		// browser.click(pageProperties.getProperty("SubmitMeterRead.NotNowNectarId"));
		if (browser.isElementVisible(pageProperties.getProperty("SubmitMeterRead.SubmitMeterButtonId"))){
		browser.click(pageProperties.getProperty("SubmitMeterRead.SubmitMeterButtonId"));
		}
		

	}

	public void submitImplaussibleMeterRead() {
		String logInfo = "Submit Meter Read: ";
		String logStatus = "FAIL";
		if (browser.isElementVisible(pageProperties.getProperty("SubmitMeterRead.SubmitMeterButtonId"))){
		browser.click(pageProperties.getProperty("SubmitMeterRead.SubmitMeterButtonId"));
		}
		browser.wait(3000);
		if (!browser.isElementVisible(pageProperties
		        .getProperty("SubmitMeterRead.SubmitAlertOverlayId"))) {
			logInfo = logInfo
			        + " Alert OverLay is not displayed for Implaussible MeterRead.";
			logStatus = "FAIL";
		} else {
			browser.clickWithXpath(pageProperties
			        .getProperty("SubmitMeterRead.OverlaySubmitButtonXpath"));
		}
	}


	public void verifyMeterConfirmation(String accountNumber, UserProfile userProfile) {
		verifyIsTextPresent("Your meter reading is complete");
		new LegacyLoginPage().logOut();
		String[] ContactText = new String[5];
		if(TestBase.CustomerData.equals("SAPCRM")){
		SapNetWeaverPage sapNetWeaverPage = new SapNetWeaverPage();
		sapNetWeaverPage.openSapCRM(userProfile);
		ContactText = sapNetWeaverPage.contactHistoryValidation();
		Report.updateTestLog("Transaction agent : "+ContactText[0], "Pass");
		if(ContactText[1].contains("Meter Reading") && ContactText[2].contains("Receive Meter Reading ")){
			Report.updateTestLog("Details have been updated in SAP with text :"+ContactText[4], "Pass");
		}
		else{
			Report.updateTestLog("Details have not been updated in SAP", "Fail");
			}
		}
	    
	}


	public void verifyMeterConfirmation(String accountNumber) {
		verifyIsTextPresent("Your meter reading is complete");
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("SubmitMeterRead.ViewAccount"))){
			Report.updateTestLog("View Account link found in the SMR confirmation page", "Pass");
			verifyAndClickWithXpath(pageProperties.getProperty("SubmitMeterRead.ViewAccount"), "View account");
			browser.browserBack();
		}
		else{
			Report.updateTestLog("View ACcount link not found in the SMR Confirmation page", "Fail");
		}
		
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("SubmitMeterRead.PredictNextBill"))){
			browser.clickWithXpath(pageProperties.getProperty("SubmitMeterRead.PredictNextBill"));
			if(browser.getTextByXpath(pageProperties.getProperty("SubmitMeterRead.AccountOverviewHeader")).equalsIgnoreCase("Predict next bill")){
				Report.updateTestLog("Predict Next Bill link in SMR page navigated to Predict next bill page", "Pass");
			}
			else{
				Report.updateTestLog("Predict Next Bill link in SMR page not navigated to Predict next bill page", "Fail");
			}
			browser.browserBack();
		}
		else{
			Report.updateTestLog("Predict Next bill link not found in the application page", "Fail");
		}
		
		new LegacyLoginPage().logOut();

	}
	
	public void verifyNectarConfirmation(){
		String NectarCardNumber = browser.getTextByXpath(pageProperties.getProperty("SubmitMeterRead.NectarCardNumber"));
		Report.updateTestLog("The Nectar Card Number generated is "+NectarCardNumber, "Pass");
		browser.clickWithXpath(pageProperties.getProperty("SubmitMeterRead.YourAccount"));
		NectarPage nectarpage = new NectarPage();
		nectarpage.verifyYourPointsPage();
	}
	
	public void verifyFinallyBilledMsg(){
		if(browser.getTextByXpath(pageProperties.getProperty("SubmitMeterRead.FinallyBilledMessage")).contains("we are unable to provide the total usage costs since your last bill")){
			Report.updateTestLog("Finally billed customer message display : "+browser.getTextByXpath(pageProperties.getProperty("SubmitMeterRead.FinallyBilledMessage")), "Pass");
		}
		else{
			Report.updateTestLog("Finally billed customer error message not displayed", "Fail");
		}
	}
	
	public void submitFinallyBilledReadings(String accountNumber){
		browser.wait(getWaitTime());
		verifyAndClickWithXpath("//input[@value='"+accountNumber+"']", "Select CheckBox");
		verifyAndInputById(pageProperties.getProperty("SubmitMeterRead.DayMeterReading").replace("NUMBER", accountNumber), "Enter Day Meter Read", "100");
		verifyAndInputById(pageProperties.getProperty("SubmitMeterRead.NightMeterReading").replace("NUMBER", accountNumber), "Enter Night Meter Read", "100");
	}
	
	public void verifyClosedAccountSMR(String accountNumber){
		Report.updateTestLog("Submit Meter reading page", "WARN");
		if (browser.isElementVisibleWithXpath("//input[@value='"+accountNumber+"']")){
			Report.updateTestLog("Closed Account Displayed in SMR  "+ accountNumber, "FAIL");
		} else {
			Report.updateTestLog("Closed Account Not Displayed in SMR  "+ accountNumber, "PASS");
			
		}
		String errText;
		if (browser.isElementVisibleWithXpath(".//*[@id='primary-content-medium']/div/div/div/div[1]/p[1]")){
			 errText = browser.getTextByXpath(".//*[@id='primary-content-medium']/div/div/div/div[1]/p[1]");
			Report.updateTestLog("Expected error message Displayed for SMR Closed Account "+ errText, "PASS");
		} else {
			Report.updateTestLog("Closed Account displayed in SMR", "FAIL");
		}
	}
			
	public void navigateToAccountOverviewPage() {
		verifyAndClickWithLinkText(
				pageProperties.getProperty("SubmitMeterRead.YourAccount"),
				"Your account");
	}
}
