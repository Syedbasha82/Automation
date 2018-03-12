package bg.framework.app.functional.page.selfServe;

import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

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

		for (int i = 1; i <= dialFieldCount; i++) {

			browser.inputByXpath(dialFieldsxPath + "[" + i + "]",
			        previousMeterValue.charAt(i - 1) + "");
		}
		this.currentMeterRead = previousMeterValue;
		Report.updateTestLog(logInfo, logStatus);
		submitMeterReads();
	}

	private String padZeros(String previousMeterValue, int dialFieldCount) {
		for (int i = previousMeterValue.length(); i <= dialFieldCount; i++) {
			previousMeterValue = "0" + previousMeterValue;
		}
		return previousMeterValue;
	}

	private String getPreviousMeterRead(String accountNumber) {
		String previousMeterRead = "";

		String xpathforAcctNum = "//div[@class='dial-info default']/p[1]";

		previousMeterRead = browser.getTextByXpath(xpathforAcctNum);
		previousMeterRead = previousMeterRead.contains(":") ? previousMeterRead
		        .substring(previousMeterRead.indexOf(':') + 1, previousMeterRead.length())
		        : "";
		return previousMeterRead.trim();

	}

	private String getMeterSerialNumber(String accountNumber) {

		String meterSerialNumber = "";

		String xpathforAcctNum = "//div[@class='dial-info default']/p[3]";

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

	public void verifyMeterConfirmation(String accountNumber) {
		verifyIsTextPresent("Your meter reading is complete");
		new LegacyLoginPage().logOut();

	}
}
