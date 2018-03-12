package bg.framework.app.functional.page.selfServe;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;

import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.util.OnlineDBConnector;
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
	private static final String String = null;
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
		//verifyAndSelectCheckBoxByID(accountNumber, "Select CheckBox");
		String logInfo = " Setting Plausible Reading for Account: " + accountNumber;
		String logStatus = "DONE";
		String previousMeterValue = getPreviousMeterRead(accountNumber);
		String meterSerialNumber = getMeterSerialNumber(accountNumber);
		logInfo = logInfo + " The meter Serial Number is: " + meterSerialNumber
		        + ", The Previous Meter Read value is: " + previousMeterValue;
		System.out.println("11111111111111111111111 "+meterSerialNumber);
		System.out.println("22222222222222222222222 "+previousMeterValue);
		String dialFieldsxPath = pageProperties
		        .getProperty("SubmitMeterRead.MeterInputFieldsXpath");
		dialFieldsxPath = dialFieldsxPath.replace("METERNAME", meterSerialNumber);
		System.out.println("33333333333333333333 "+dialFieldsxPath);
		
		// Add +1 to the existing reading to make Plausible
		previousMeterValue = (Integer.parseInt(previousMeterValue) + 1) + "";
		
		String DialsCountxPath = pageProperties.getProperty("SubmitMeterRead.MeterInputDialsXpath");
		DialsCountxPath = DialsCountxPath.replace("METERNAME", meterSerialNumber);
		int dialFieldCount = browser.getChildElementsCountByXpath(DialsCountxPath);	
		System.out.println("4444444444444444444444 "+dialFieldCount);
		// TODO: update
		previousMeterValue = previousMeterValue.length() == dialFieldCount ? previousMeterValue
		        : padZeros(previousMeterValue, dialFieldCount);
		System.out.println("5555555555555555555555"+previousMeterValue);
		previousMeterValue = "9999";
		for (int i = 0; i < dialFieldCount; i++) {
			browser.inputByXpath(dialFieldsxPath.replace("NUMBER",i+""), "9");
		}
		this.currentMeterRead = previousMeterValue;
		submitMeterReads();
		/*browser.clickWithXpath(pageProperties
		        .getProperty("SubmitMeterRead.OverlaySubmitButtonXpath"));*/
		/*if (!browser.isElementVisible(pageProperties
		        .getProperty("SubmitMeterRead.SubmitAlertOverlayId"))) {
			logInfo = logInfo
			        + " Alert OverLay is displayed for Implaussible MeterRead.";
			logStatus = "PASS";
			browser.clickWithXpath(pageProperties
			        .getProperty("SubmitMeterRead.OverlaySubmitButtonXpath"));
		} else {
			browser.clickWithXpath(pageProperties
			        .getProperty("SubmitMeterRead.OverlaySubmitButtonXpath"));
		}*/

		Report.updateTestLog(logInfo, logStatus);

	}
	public void setImPlausbileReadingLowElecDay(String accountNumber) {
		browser.wait(getWaitTime());
		//verifyAndSelectCheckBoxByID(accountNumber, "Select CheckBox");
		String logInfo = " Setting Plausible Reading for Account: " + accountNumber;
		String logStatus = "DONE";
		String previousMeterValue = getPreviousMeterReadElecDay(accountNumber);
		String meterSerialNumber = getMeterSerialNumberElecDay(accountNumber);
		logInfo = logInfo + " The meter Serial Number is: " + meterSerialNumber
		        + ", The Previous Meter Read value is: " + previousMeterValue;
		System.out.println("11111111111111111111111 "+meterSerialNumber);
		System.out.println("22222222222222222222222 "+previousMeterValue);
		String dialFieldsxPath = pageProperties
		        .getProperty("SubmitMeterRead.MeterInputFieldsXpath");
		dialFieldsxPath = dialFieldsxPath.replace("METERNAME", meterSerialNumber);
		System.out.println("33333333333333333333 "+dialFieldsxPath);
		
		// Add +1 to the existing reading to make Plausible
		previousMeterValue = (Integer.parseInt(previousMeterValue) + 1) + "";
		
		String DialsCountxPath = pageProperties.getProperty("SubmitMeterRead.MeterInputDialsXpath");
		DialsCountxPath = DialsCountxPath.replace("METERNAME", meterSerialNumber);
		int dialFieldCount = browser.getChildElementsCountByXpath(DialsCountxPath);	
		System.out.println("4444444444444444444444 "+dialFieldCount);
		// TODO: update
		previousMeterValue = previousMeterValue.length() == dialFieldCount ? previousMeterValue
		        : padZeros(previousMeterValue, dialFieldCount);
		System.out.println("5555555555555555555555"+previousMeterValue);
		previousMeterValue = "0000";
		
		
		//Electricity Dual Meter
		if(dialFieldCount == 10){
			for (int i = 0; i < 5; i++) {
				browser.inputByXpath(dialFieldsxPath.replace("NUMBER",i+""), "0");
			}
			for (int i = 0; i < 5; i++) {
				browser.inputByXpath(dialFieldsxPath.replace("NUMBER",i+"").replace("register0","register1"), "0");
			}

		}
		else{
			for (int i = 0; i < dialFieldCount; i++) {
				System.out.println("66666666666666666666");
				browser.inputByXpath(dialFieldsxPath.replace("dialNUMBER",i+""), "0");
			}
		}
		
		
		this.currentMeterRead = previousMeterValue;
		//setImPlausbileReadingLowElecNight(accountNumber);
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
	public void setImPlausbileReadingLowElecNight(String accountNumber) {
		browser.wait(getWaitTime());
		//verifyAndSelectCheckBoxByID(accountNumber, "Select CheckBox");
		String logInfo = " Setting Plausible Reading for Account: " + accountNumber;
		String logStatus = "DONE";
		String previousMeterValue = getPreviousMeterReadElecNight(accountNumber);
		String meterSerialNumber = getMeterSerialNumberElecNight(accountNumber);
		logInfo = logInfo + " The meter Serial Number is: " + meterSerialNumber
		        + ", The Previous Meter Read value is: " + previousMeterValue;
		System.out.println("11111111111111111111111 "+meterSerialNumber);
		System.out.println("22222222222222222222222 "+previousMeterValue);
		String dialFieldsxPath = pageProperties
		        .getProperty("SubmitMeterRead.MeterInputFieldsXpath");
		dialFieldsxPath = dialFieldsxPath.replace("METERNAME", meterSerialNumber);
		System.out.println("33333333333333333333 "+dialFieldsxPath);
		
		// Add +1 to the existing reading to make Plausible
		previousMeterValue = (Integer.parseInt(previousMeterValue) + 1) + "";
		
		String DialsCountxPath = pageProperties.getProperty("SubmitMeterRead.MeterInputDialsXpath");
		DialsCountxPath = DialsCountxPath.replace("METERNAME", meterSerialNumber);
		int dialFieldCount = browser.getChildElementsCountByXpath(DialsCountxPath);	
		System.out.println("4444444444444444444444 "+dialFieldCount);
		// TODO: update
		previousMeterValue = previousMeterValue.length() == dialFieldCount ? previousMeterValue
		        : padZeros(previousMeterValue, dialFieldCount);
		System.out.println("5555555555555555555555"+previousMeterValue);
		previousMeterValue = "0000";
		for (int i = 0; i < dialFieldCount; i++) {
			browser.inputByXpath(dialFieldsxPath.replace("dialNUMBER",i+""), "0");
		}
		this.currentMeterRead = previousMeterValue;

	}

	public void setPlausbileReadingMeterRead(String accountNumber) {
		browser.wait(getWaitTime());
		//verifyAndSelectCheckBoxByID(accountNumber, "Select CheckBox");
		//verifyAndClickWithXpath("//input[@value='"+accountNumber+"']", "Select CheckBox");
		
		String logInfo = " Setting Plausible Reading for Account: " + accountNumber;
		String logStatus = "DONE";
		String previousMeterValue = getPreviousMeterRead(accountNumber);
		String meterSerialNumber = getMeterSerialNumber(accountNumber);
		logInfo = logInfo + " The meter Serial Number is: " + meterSerialNumber
		        + ", The Previous Meter Read value is: " + previousMeterValue;

		String dialFieldsxPath = pageProperties.getProperty("SubmitMeterRead.MeterInputFieldsXpath");
		dialFieldsxPath = dialFieldsxPath.replace("METERNAME", meterSerialNumber);
		
		String DialsCountxPath = pageProperties.getProperty("SubmitMeterRead.MeterInputDialsXpath");
		DialsCountxPath = DialsCountxPath.replace("METERNAME", meterSerialNumber);
		// Add +1 to the existing reading to make Plausible
		previousMeterValue = (Integer.parseInt(previousMeterValue) + 1) + "";
		//int dialFieldCount = browser.getChildElementsCountByXpath(dialFieldsxPath);
		int dialFieldCount =browser.getChildElementsCountByXpath(DialsCountxPath);
		// TODO: update
		previousMeterValue = previousMeterValue.length() == dialFieldCount ? previousMeterValue
		        : padZeros(previousMeterValue, dialFieldCount);
		System.out.println("999999999999999999999999999999999999999999999999999"+previousMeterValue);
		
		
		for (int i = 1; i <= dialFieldCount; i++) {
			//browser.inputByXpath(dialFieldsxPath + "[" + i + "]",previousMeterValue.charAt(i - 1) + "");
			browser.inputByXpath(dialFieldsxPath.replace("NUMBER", ""+(i-1)), previousMeterValue.charAt(i - 1) + "");
		}
		this.currentMeterRead = previousMeterValue;
		Report.updateTestLog(logInfo, logStatus);
		submitMeterReads();
		
	}
	public void setPlausbileReadingMeterReadForDayReading(String accountNumber) {
		browser.wait(getWaitTime());
		//verifyAndSelectCheckBoxByID(accountNumber, "Select CheckBox");
		//verifyAndClickWithXpath("//input[@value='"+accountNumber+"']", "Select CheckBox");
		verifyIsTextPresent("Electricity Day Reading");
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
	public void setPlausbileReadingMeterReadForNightReading(String accountNumber) {
		browser.wait(getWaitTime());
		//verifyAndSelectCheckBoxByID(accountNumber, "Select CheckBox");
		//verifyAndClickWithXpath("//input[@value='"+accountNumber+"']", "Select CheckBox");
		verifyIsTextPresent("Electricity Night Reading");
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
		for (int i = previousMeterValue.length(); i < dialFieldCount; i++) {
			previousMeterValue = "0" + previousMeterValue;
		}
		return previousMeterValue;
	}

	private String getPreviousMeterRead(String accountNumber) {
		String previousMeterRead = "";

	//	String xpathforAcctNum = "//div[@class='dial-info default']/p[1]";
		String xpathforAcctNum = ".//*[@id='smrOverlayForm']//div[@class='dial-info default']/p[1]";
		previousMeterRead = browser.getTextByXpath(xpathforAcctNum);
		previousMeterRead = previousMeterRead.contains(":") ? previousMeterRead
		        .substring(previousMeterRead.indexOf(':') + 1, previousMeterRead.length())
		        : "";
		        System.out.println("7777777777777777777" +previousMeterRead.trim());
		return previousMeterRead.trim();

	}
	private String getPreviousMeterReadElecDay(String accountNumber) {
		String previousMeterRead = "";

	//	String xpathforAcctNum = "//div[@class='dial-info default']/p[1]";
		String xpathforAcctNum = ".//*[@id='smrOverlayForm']/div[4]/div[2]/div[2]/div/p[1]";
		previousMeterRead = browser.getTextByXpath(xpathforAcctNum);
		previousMeterRead = previousMeterRead.contains(":") ? previousMeterRead
		        .substring(previousMeterRead.indexOf(':') + 1, previousMeterRead.length())
		        : "";
		        System.out.println("7777777777777777777" +previousMeterRead.trim());
		return previousMeterRead.trim();

	}
	private String getPreviousMeterReadMixedElecDay(String accountNumber) {
		String previousMeterRead = "";

	//	String xpathforAcctNum = "//div[@class='dial-info default']/p[1]";
		String xpathforAcctNum = ".//*[@id='smrOverlayForm']/div[2]/div[2]/div[2]/div/p[1]";
		previousMeterRead = browser.getTextByXpath(xpathforAcctNum);
		previousMeterRead = previousMeterRead.contains(":") ? previousMeterRead
		        .substring(previousMeterRead.indexOf(':') + 1, previousMeterRead.length())
		        : "";
		        System.out.println("7777777777777777777" +previousMeterRead.trim());
		return previousMeterRead.trim();

	}
	private String getPreviousMeterReadElecNight(String accountNumber) {
		String previousMeterRead = "";

	//	String xpathforAcctNum = "//div[@class='dial-info default']/p[1]";
		String xpathforAcctNum = ".//*[@id='smrOverlayForm']/div[4]/div[2]/div[5]/div/p[1]";
		previousMeterRead = browser.getTextByXpath(xpathforAcctNum);
		previousMeterRead = previousMeterRead.contains(":") ? previousMeterRead
		        .substring(previousMeterRead.indexOf(':') + 1, previousMeterRead.length())
		        : "";
		        System.out.println("7777777777777777777" +previousMeterRead.trim());
		return previousMeterRead.trim();

	}
	private String getPreviousMeterReadMixedElecNight(String accountNumber) {
		String previousMeterRead = "";

	//	String xpathforAcctNum = "//div[@class='dial-info default']/p[1]";
		String xpathforAcctNum = ".//*[@id='smrOverlayForm']/div[2]/div[2]/div[5]/div/p[1]";
		previousMeterRead = browser.getTextByXpath(xpathforAcctNum);
		previousMeterRead = previousMeterRead.contains(":") ? previousMeterRead
		        .substring(previousMeterRead.indexOf(':') + 1, previousMeterRead.length())
		        : "";
		        System.out.println("7777777777777777777" +previousMeterRead.trim());
		return previousMeterRead.trim();

	}
	private String getPreviousMeterReadAnonymous(String accountNumber) {
		String previousMeterRead = "";


		String xpathforAcctNum = " .//*[@id='smrOverlayForm']/div[2]/div[2]/div[2]/div/p[1]";
		previousMeterRead = browser.getTextByXpath(xpathforAcctNum);
		previousMeterRead = previousMeterRead.contains(":") ? previousMeterRead
		        .substring(previousMeterRead.indexOf(':') + 1, previousMeterRead.length())
		        : "";
		        System.out.println("7777777777777777777" +previousMeterRead.trim());
		return previousMeterRead.trim();

	}
	private String getPreviousMeterReadAnonymousGas(String accountNumber) {
		String previousMeterRead = "";

	
		String xpathforAcctNum = ".//*[@id='smrOverlayForm']/div[2]/div[2]/div[2]/div/p[1]";
		previousMeterRead = browser.getTextByXpath(xpathforAcctNum);
		previousMeterRead = previousMeterRead.contains(":") ? previousMeterRead
		        .substring(previousMeterRead.indexOf(':') + 1, previousMeterRead.length())
		        : "";
		        System.out.println("7777777777777777777" +previousMeterRead.trim());
		return previousMeterRead.trim();

	}
	private String getPreviousMeterReadGas(String accountNumber) {
		String previousMeterRead = "";

	//	String xpathforAcctNum = "//div[@class='dial-info default']/p[1]";
		String xpathforAcctNum = ".//*[@id='smrOverlayForm']/div[2]/div[2]/div[2]/div/p[1]";
		previousMeterRead = browser.getTextByXpath(xpathforAcctNum);
		previousMeterRead = previousMeterRead.contains(":") ? previousMeterRead
		        .substring(previousMeterRead.indexOf(':') + 1, previousMeterRead.length())
		        : "";
		        System.out.println("7777777777777777777" +previousMeterRead.trim());
		return previousMeterRead.trim();

	}
	
	
	private String getPreviousMeterReadAnonymousDualElec(String accountNumber) {
		String previousMeterRead = "";

	//	String xpathforAcctNum = "//div[@class='dial-info default']/p[1]";
		String xpathforAcctNum = ".//*[@id='smrOverlayForm']/div[2]/div[2]/div[5]/div/p[1]";
		previousMeterRead = browser.getTextByXpath(xpathforAcctNum);
		previousMeterRead = previousMeterRead.contains(":") ? previousMeterRead
		        .substring(previousMeterRead.indexOf(':') + 1, previousMeterRead.length())
		        : "";
		        System.out.println("7777777777777777777" +previousMeterRead.trim());
		return previousMeterRead.trim();

	}
	private String getPreviousMeterReadElec(String accountNumber) {
		String previousMeterRead = "";

	//	String xpathforAcctNum = "//div[@class='dial-info default']/p[1]";
		String xpathforAcctNum = ".//*[@id='smrOverlayForm']/div[4]/div[2]/div[2]/div/p[1]";
		previousMeterRead = browser.getTextByXpath(xpathforAcctNum);
		previousMeterRead = previousMeterRead.contains(":") ? previousMeterRead
		        .substring(previousMeterRead.indexOf(':') + 1, previousMeterRead.length())
		        : "";
		        System.out.println("7777777777777777777" +previousMeterRead.trim());
		return previousMeterRead.trim();

	}
	private String getPreviousMeterReadAnonymousJIElec(String accountNumber) {
		String previousMeterRead = "";

	//	String xpathforAcctNum = "//div[@class='dial-info default']/p[1]";
		String xpathforAcctNum = ".//*[@id='smrOverlayForm']/div[2]/div[2]/div[5]/div/p[1]";
		previousMeterRead = browser.getTextByXpath(xpathforAcctNum);
		previousMeterRead = previousMeterRead.contains(":") ? previousMeterRead
		        .substring(previousMeterRead.indexOf(':') + 1, previousMeterRead.length())
		        : "";
		        System.out.println("7777777777777777777" +previousMeterRead.trim());
		return previousMeterRead.trim();

	}

	private String getMeterSerialNumber(String accountNumber) {

		String meterSerialNumber = "";

		//String xpathforAcctNum = "//div[@class='dial-info default']/p[3]";
		String xpathforAcctNum = ".//*[@id='smrOverlayForm']/div[2]//div[@class='dial-info default']/p[3]";
		
		meterSerialNumber = browser.getTextByXpath(xpathforAcctNum);
		/*
		 * meterSerialNumber = meterSerialNumber.contains(":") ?
		 * meterSerialNumber .substring(meterSerialNumber.indexOf(":") + 1,
		 * meterSerialNumber.indexOf("(actual")) : "";
		 */
		String meterPrefix = pageProperties.getProperty("SubmitMeterRead.SerialNumberPrefix");
		// Remove other Contents apart form Meter SerialNumber.

		meterSerialNumber = meterSerialNumber.contains(meterPrefix) ? meterSerialNumber
		        .substring(meterSerialNumber.indexOf(meterPrefix) + meterPrefix.length(),
		                meterSerialNumber.length()) : "";

		return meterSerialNumber.trim();
	}
	private String getMeterSerialNumberElecDay(String accountNumber) {

		String meterSerialNumber = "";

		//String xpathforAcctNum = "//div[@class='dial-info default']/p[3]";
		String xpathforAcctNum = ".//*[@id='smrOverlayForm']/div[4]/div[2]/div[2]/div/p[3]";
		
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
	private String getMeterSerialNumberMixedElecDay(String accountNumber) {

		String meterSerialNumber = "";

		//String xpathforAcctNum = "//div[@class='dial-info default']/p[3]";
		String xpathforAcctNum = ".//*[@id='smrOverlayForm']/div[2]/div[2]/div[2]/div/p[3]	";
		
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
	private String getMeterSerialNumberElecNight(String accountNumber) {

		String meterSerialNumber = "";

		//String xpathforAcctNum = "//div[@class='dial-info default']/p[3]";
		String xpathforAcctNum = " .//*[@id='smrOverlayForm']/div[4]/div[2]/div[5]/div/p[3]";
		
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
	private String getMeterSerialNumberMixedElecNight(String accountNumber) {

		String meterSerialNumber = "";

		//String xpathforAcctNum = "//div[@class='dial-info default']/p[3]";
		String xpathforAcctNum = ".//*[@id='smrOverlayForm']/div[2]/div[2]/div[5]/div/p[3]";
		
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
	private String getMeterSerialNumberDualElec(String accountNumber) {

		String meterSerialNumber = "";

		//String xpathforAcctNum = "//div[@class='dial-info default']/p[3]";
		String xpathforAcctNum = ".//*[@id='smrOverlayForm']/div[2]/div[2]/div[5]/div/p[3]";
		
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
	private String getMeterSerialNumberJIElec(String accountNumber) {

		String meterSerialNumber = "";

		//String xpathforAcctNum = "//div[@class='dial-info default']/p[3]";
		String xpathforAcctNum = ".//*[@id='smrOverlayForm']/div[2]/div[2]/div[5]/div/p[3]";
		
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
	private String getMeterSerialNumberAnonymous(String accountNumber) {

		String meterSerialNumber = "";

		//String xpathforAcctNum = "//div[@class='dial-info default']/p[3]";
		String xpathforAcctNum = ".//*[@id='smrOverlayForm']/div[2]/div[2]/div[2]/div/p[3]";
		
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
	private String getMeterSerialNumberGas(String accountNumber) {

		String meterSerialNumber = "";

		//String xpathforAcctNum = "//div[@class='dial-info default']/p[3]";
		String xpathforAcctNum = ".//*[@id='smrOverlayForm']/div[2]/div[2]/div[2]/div/p[3]";
		
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
	private String getMeterSerialNumberElec(String accountNumber) {

		String meterSerialNumber = "";

		//String xpathforAcctNum = "//div[@class='dial-info default']/p[3]";
		String xpathforAcctNum = ".//*[@id='smrOverlayForm']/div[4]/div[2]/div[2]/div/p[3]";
		
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
	private String getMeterSerialNumberAnonymousGas(String accountNumber) {

		String meterSerialNumber = "";

		//String xpathforAcctNum = "//div[@class='dial-info default']/p[3]";
		String xpathforAcctNum = ".//*[@id='smrOverlayForm']/div[2]/div[2]/div[2]/div/p[3]";
		
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
		//browser.WaitForElementWithId(pageProperties.getProperty("SubmitMeterRead.Submitoverlay"));
		if (browser.isElementVisible(pageProperties.getProperty("SubmitMeterRead.OverlaySubmitMeterButtonId"))){
			browser.click(pageProperties.getProperty("SubmitMeterRead.OverlaySubmitMeterButtonId"));	
		}
		Report.updateTestLog("OAM LITE SMR GAS CONFIRMATION", "WARN");

	}

	public void submitImplaussibleMeterRead() {
		String logInfo = "Submit Meter Read: ";
		String logStatus = "FAIL";
		if (browser.isElementVisible(pageProperties.getProperty("SubmitMeterRead.SubmitMeterButtonId"))){
		browser.click(pageProperties.getProperty("SubmitMeterRead.SubmitMeterButtonId"));
		}
		browser.wait(3000);
		if (browser.isElementVisible(pageProperties
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
		//new LegacyLoginPage().logOut();
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
	public void verifyMeterConfirmationAnonymous(String accountNumber, UserProfile userProfile) {
		verifyIsTextPresent("Meter reading submitted");
		//new LegacyLoginPage().logOut();
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
		//verifyAndClickWithXpath("//input[@value='"+accountNumber+"']", "Select CheckBox");
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
	public void navigateToSMRAnonymousPage(){
		//browser.open(ApplicationConfig.APP_BG_URL+"/youraccount/discover/Anonymous-read/findyouraccounts/");
		browser.open(ApplicationConfig.APP_BG_URL+"/youraccount/discover/Anonymous-read/findyouraccounts/");
	}
	public void navigateToSMRFromAccountOverview(){
		browser.wait(15000);
		browser.clickWithLinkText("Submit a meter read");
		
	}
	public void navigateToSMRFromAccountOverviewDualGas(UserProfile userProfile){
		
		//String SMR = browser.getTextByXpath(pageProperties.getProperty("SubmitMeterRead.SMRDual").replace("USERACCOUNTNUMBER",userProfile.getGasAccount()));
		
		System.out.println("+777777777777777777777777777777777777"+pageProperties.getProperty("SubmitMeterRead.SMRDual").replace("USERACCOUNTNUMBER",userProfile.getGasAccount()));
		browser.wait(15000);
		browser.dynamicWaituntilVisiblebyXpath(pageProperties.getProperty("SubmitMeterRead.SMRDual").replace("USERACCOUNTNUMBER",userProfile.getGasAccount()));
		verifyAndClickWithXpath(pageProperties.getProperty("SubmitMeterRead.SMRDual").replace("USERACCOUNTNUMBER",userProfile.getGasAccount()), "SMRDual");
		
			
	}
	
	public void navigateToSMRFromAccountOverviewDualElec(UserProfile userProfile){
		System.out.println("+8888888888888888888888888888888888888"+pageProperties.getProperty("SubmitMeterRead.SMRDual").replace("USERACCOUNTNUMBER",userProfile.getElecAccount()));
		browser.wait(15000);
		browser.dynamicWaituntilVisiblebyXpath(pageProperties.getProperty("SubmitMeterRead.SMRDual").replace("USERACCOUNTNUMBER",userProfile.getElecAccount()));		
		verifyAndClickWithXpath(pageProperties.getProperty("SubmitMeterRead.SMRDual").replace("USERACCOUNTNUMBER",userProfile.getElecAccount()), "SMRDual");
		
	}
    public void navigateToAccountOverview(){
    	
    	browser.open(ApplicationConfig.APP_BG_URL+"/Your_Account/Account_Details/");
	}
	
	public void findYourAccounts(UserProfile userProfile){
		
		browser.wait(5000);
		verifyAndSelectDropDownBox(pageProperties.getProperty("SubmitMeterRead.Title"), "Title",userProfile.getTitle());
		verifyAndInputById(pageProperties.getProperty("SubmitMeterRead.firstName"), "firstName",userProfile.getFirstName());
		verifyAndInputById(pageProperties.getProperty("SubmitMeterRead.lastName"), "lastName",userProfile.getLastName());
		verifyAndInputById(pageProperties.getProperty("SubmitMeterRead.email"), "email",userProfile.getEmail());
		//verifyAndClickWithXpath(pageProperties.getProperty("SubmitMeterRead.Yes"), "Yes");
		verifyAndInputById(pageProperties.getProperty("SubmitMeterRead.accnum"), "Account Number",userProfile.getAccNumber());
		verifyAndClickWithXpath(pageProperties.getProperty("SubmitMeterRead.Findmyacc"), "Find My Account");
		verifyIsTextPresent("Submit a meter reading");
		
		
	}
public void findYourAccountsByPostCode(UserProfile userProfile){
	
	    browser.wait(5000);
	    verifyAndSelectDropDownBox(pageProperties.getProperty("SubmitMeterRead.Title"), "Title",userProfile.getTitle());
		verifyAndInputById(pageProperties.getProperty("SubmitMeterRead.firstName"), "firstName",userProfile.getFirstName());
		verifyAndInputById(pageProperties.getProperty("SubmitMeterRead.lastName"), "lastName",userProfile.getLastName());
		verifyAndInputById(pageProperties.getProperty("SubmitMeterRead.email"), "email",userProfile.getEmail());
		verifyAndClickWithXpath(pageProperties.getProperty("SubmitMeterRead.AnotherForm"), "Another Form");
		verifyAndInputById(pageProperties.getProperty("SubmitMeterRead.PostCode"), "Post Code",userProfile.getaddr());
		verifyAndClickWithXpath(pageProperties.getProperty("SubmitMeterRead.Findmyacc"), "Find My Account");
		verifyIsTextPresent("Submit a meter reading");
		
		
	}
	public void setPlausibleReadingAnonymous(String accountNumber){
		String logInfo = " Setting Plausible Reading for Account: " + accountNumber;
		String logStatus = "DONE";
		String previousMeterValue = getPreviousMeterReadAnonymous(accountNumber);
		String meterSerialNumber = getMeterSerialNumberAnonymous(accountNumber);
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
		System.out.println("999999999999999999999999999999999999999999999999999"+previousMeterValue);
		
		
		for (int i = 1; i <= dialFieldCount; i++) {
			//browser.inputByXpath(dialFieldsxPath + "[" + i + "]",previousMeterValue.charAt(i - 1) + "");
			browser.inputByXpath(dialFieldsxPath.replace("NUMBER", ""+(i-1)), previousMeterValue.charAt(i - 1) + "");
		}
		this.currentMeterRead = previousMeterValue;
		Report.updateTestLog(logInfo, logStatus);
		submitMeterReads();
	}
	public void setPlausibleReadingAnonymousDual(String accountNumber){
		String logInfo = " Setting Plausible Reading for Account: " + accountNumber;
		String logStatus = "DONE";
		String previousMeterValue = getPreviousMeterReadAnonymous(accountNumber);
		String meterSerialNumber = getMeterSerialNumberAnonymous(accountNumber);
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
		System.out.println("999999999999999999999999999999999999999999999999999"+previousMeterValue);
		
		
		for (int i = 1; i <= dialFieldCount; i++) {
			//browser.inputByXpath(dialFieldsxPath + "[" + i + "]",previousMeterValue.charAt(i - 1) + "");
			browser.inputByXpath(dialFieldsxPath.replace("NUMBER", ""+(i-1)), previousMeterValue.charAt(i - 1) + "");
		}
		this.currentMeterRead = previousMeterValue;
		Report.updateTestLog(logInfo, logStatus);
		setPlausibleReadingAnonymousDualElec(accountNumber);
		submitMeterReads();
	}
	public void setPlausibleReadingsDual(String accountNumber){
		String logInfo = " Setting Plausible Reading for Account: " + accountNumber;
		String logStatus = "DONE";
		String previousMeterValue = getPreviousMeterReadGas(accountNumber);
		String meterSerialNumber = getMeterSerialNumberGas(accountNumber);
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
		System.out.println("999999999999999999999999999999999999999999999999999"+previousMeterValue);
		
		
		for (int i = 1; i <= dialFieldCount; i++) {
			//browser.inputByXpath(dialFieldsxPath + "[" + i + "]",previousMeterValue.charAt(i - 1) + "");
			browser.inputByXpath(dialFieldsxPath.replace("NUMBER", ""+(i-1)), previousMeterValue.charAt(i - 1) + "");
		}
		this.currentMeterRead = previousMeterValue;
		Report.updateTestLog(logInfo, logStatus);
		setPlausibleReadingElec(accountNumber);
		submitMeterReads();
	}
	public void setPlausibleReadingsDualE7(String accountNumber){
		String logInfo = " Setting Plausible Reading for Account: " + accountNumber;
		String logStatus = "DONE";
		String previousMeterValue = getPreviousMeterReadGas(accountNumber);
		String meterSerialNumber = getMeterSerialNumberGas(accountNumber);
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
		System.out.println("999999999999999999999999999999999999999999999999999"+previousMeterValue);
		
		
		for (int i = 1; i <= dialFieldCount; i++) {
			//browser.inputByXpath(dialFieldsxPath + "[" + i + "]",previousMeterValue.charAt(i - 1) + "");
			browser.inputByXpath(dialFieldsxPath.replace("NUMBER", ""+(i-1)), previousMeterValue.charAt(i - 1) + "");
		}
		this.currentMeterRead = previousMeterValue;
		Report.updateTestLog(logInfo, logStatus);
		setPlausibleReadingElecDay(accountNumber);
		submitMeterReads();
	}
	public void setPlausibleReadingsDualGas(String accountNumber){
		String logInfo = " Setting Plausible Reading for Account: " + accountNumber;
		String logStatus = "DONE";
		String previousMeterValue = getPreviousMeterReadGas(accountNumber);
		String meterSerialNumber = getMeterSerialNumberGas(accountNumber);
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
		System.out.println("999999999999999999999999999999999999999999999999999"+previousMeterValue);
		
		
		for (int i = 1; i <= dialFieldCount; i++) {
			//browser.inputByXpath(dialFieldsxPath + "[" + i + "]",previousMeterValue.charAt(i - 1) + "");
			browser.inputByXpath(dialFieldsxPath.replace("NUMBER", ""+(i-1)), previousMeterValue.charAt(i - 1) + "");
		}
		this.currentMeterRead = previousMeterValue;
		Report.updateTestLog(logInfo, logStatus);
		setPlausibleReadingElec(accountNumber);
		submitMeterReads();
	}
	public void setPlausibleReadingAnonymousJI(String accountNumber){
		String logInfo = " Setting Plausible Reading for Account: " + accountNumber;
		String logStatus = "DONE";
		String previousMeterValue = getPreviousMeterReadAnonymousGas(accountNumber);
		String meterSerialNumber = getMeterSerialNumberAnonymousGas(accountNumber);
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
		System.out.println("999999999999999999999999999999999999999999999999999"+previousMeterValue);
		
		
		for (int i = 1; i <= dialFieldCount; i++) {
			//browser.inputByXpath(dialFieldsxPath + "[" + i + "]",previousMeterValue.charAt(i - 1) + "");
			browser.inputByXpath(dialFieldsxPath.replace("NUMBER", ""+(i-1)), previousMeterValue.charAt(i - 1) + "");
		}
		this.currentMeterRead = previousMeterValue;
		Report.updateTestLog(logInfo, logStatus);
		setPlausibleReadingAnonymousJIElec(accountNumber);
		submitMeterReads();
	}
	public void setPlausibleReadingAnonymousDualElec(String accountNumber){
		String logInfo = " Setting Plausible Reading for Account: " + accountNumber;
		String logStatus = "DONE";
		String previousMeterValue = getPreviousMeterReadAnonymousDualElec(accountNumber);
		String meterSerialNumber = getMeterSerialNumberDualElec(accountNumber);
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
		System.out.println("999999999999999999999999999999999999999999999999999"+previousMeterValue);
		
		
		for (int i = 1; i <= dialFieldCount; i++) {
			//browser.inputByXpath(dialFieldsxPath + "[" + i + "]",previousMeterValue.charAt(i - 1) + "");
			browser.inputByXpath(dialFieldsxPath.replace("NUMBER", ""+(i-1)), previousMeterValue.charAt(i - 1) + "");
		}
		this.currentMeterRead = previousMeterValue;
		Report.updateTestLog(logInfo, logStatus);
		
		
	}
	public void setPlausibleReadingElec(String accountNumber){
		String logInfo = " Setting Plausible Reading for Account: " + accountNumber;
		String logStatus = "DONE";
		String previousMeterValue = getPreviousMeterReadElec(accountNumber);
		String meterSerialNumber = getMeterSerialNumberElec(accountNumber);
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
		System.out.println("999999999999999999999999999999999999999999999999999"+previousMeterValue);
		
		
		for (int i = 1; i <= dialFieldCount; i++) {
			//browser.inputByXpath(dialFieldsxPath + "[" + i + "]",previousMeterValue.charAt(i - 1) + "");
			browser.inputByXpath(dialFieldsxPath.replace("NUMBER", ""+(i-1)), previousMeterValue.charAt(i - 1) + "");
		}
		this.currentMeterRead = previousMeterValue;
		Report.updateTestLog(logInfo, logStatus);
		//submitMeterReads();
		
		
	}
	public void setPlausibleReadingAnonymousJIElec(String accountNumber){
		String logInfo = " Setting Plausible Reading for Account: " + accountNumber;
		String logStatus = "DONE";
		String previousMeterValue = getPreviousMeterReadAnonymousJIElec(accountNumber);
		String meterSerialNumber = getMeterSerialNumberJIElec(accountNumber);
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
		System.out.println("999999999999999999999999999999999999999999999999999"+previousMeterValue);
		
		
		for (int i = 1; i <= dialFieldCount; i++) {
			//browser.inputByXpath(dialFieldsxPath + "[" + i + "]",previousMeterValue.charAt(i - 1) + "");
			browser.inputByXpath(dialFieldsxPath.replace("NUMBER", ""+(i-1)), previousMeterValue.charAt(i - 1) + "");
		}
		this.currentMeterRead = previousMeterValue;
		Report.updateTestLog(logInfo, logStatus);
		
		
	}
	public void setPlausibleReadingElecDay(String accountNumber){
		String logInfo = " Setting Plausible Reading for Account: " + accountNumber;
		String logStatus = "DONE";
		String previousMeterValue = getPreviousMeterReadElecDay(accountNumber);
		String meterSerialNumber = getMeterSerialNumberElecDay(accountNumber);
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
		System.out.println("888888888888888888888888888888888888888888888888888"+dialFieldCount);
		previousMeterValue = previousMeterValue.length() == dialFieldCount ? previousMeterValue
		        : padZeros(previousMeterValue, dialFieldCount);
		System.out.println("222222222222222222222222222222222222222222222222222"+dialFieldsxPath);
		System.out.println("444444444444444444444444444444444444444444444444444"+DialsCountxPath);
		System.out.println("999999999999999999999999999999999999999999999999999"+previousMeterValue);
		if(dialFieldCount == 10){
			
			for (int i = 6; i<=10; i++){
			browser.inputByXpath(dialFieldsxPath.replace("NUMBER", ""+(i-6)), previousMeterValue.charAt(i-1) + "");
			}
			/*for (int i = 6; i <=10; i++){
			String previousMeterValueNight=getPreviousMeterReadElecNight(accountNumber);
			previousMeterValue = (Integer.parseInt(previousMeterValue) + 1) + "";
			previousMeterValue = previousMeterValue.length() == dialFieldCount ? previousMeterValue
			        : padZeros(previousMeterValue, dialFieldCount);
				
			browser.inputByXpath(dialFieldsxPath.replace("NUMBER", ""+(i-6)).replace("register0","register1"), previousMeterValue.charAt(i-1) + "");
			}*/
		}
			else{
			for (int i = 1; i <= dialFieldCount; i++) {					
						browser.inputByXpath(dialFieldsxPath.replace("NUMBER", ""+(i-1)), previousMeterValue.charAt(i-1) + "");
					}
			}
		
		this.currentMeterRead = previousMeterValue;
		Report.updateTestLog(logInfo, logStatus);
		setPlausibleReadingElecNight(accountNumber);
		//submitMeterReads();
	}
	public void setPlausibleReadingMiedElecDay(String accountNumber){
		String logInfo = " Setting Plausible Reading for Account: " + accountNumber;
		String logStatus = "DONE";
		String previousMeterValue = getPreviousMeterReadMixedElecDay(accountNumber);
		String meterSerialNumber = getMeterSerialNumberMixedElecDay(accountNumber);
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
		System.out.println("888888888888888888888888888888888888888888888888888"+dialFieldCount);
		previousMeterValue = previousMeterValue.length() == dialFieldCount ? previousMeterValue
		        : padZeros(previousMeterValue, dialFieldCount);
		System.out.println("222222222222222222222222222222222222222222222222222"+dialFieldsxPath);
		System.out.println("444444444444444444444444444444444444444444444444444"+DialsCountxPath);
		System.out.println("999999999999999999999999999999999999999999999999999"+previousMeterValue);
		if(dialFieldCount == 10){
			
			for (int i = 6; i<=10; i++){
			browser.inputByXpath(dialFieldsxPath.replace("NUMBER", ""+(i-6)), previousMeterValue.charAt(i-1) + "");
			}
			/*for (int i = 6; i <=10; i++){
			String previousMeterValueNight=getPreviousMeterReadElecNight(accountNumber);
			previousMeterValue = (Integer.parseInt(previousMeterValue) + 1) + "";
			previousMeterValue = previousMeterValue.length() == dialFieldCount ? previousMeterValue
			        : padZeros(previousMeterValue, dialFieldCount);
				
			browser.inputByXpath(dialFieldsxPath.replace("NUMBER", ""+(i-6)).replace("register0","register1"), previousMeterValue.charAt(i-1) + "");
			}*/
		}
			else{
			for (int i = 1; i <= dialFieldCount; i++) {					
						browser.inputByXpath(dialFieldsxPath.replace("NUMBER", ""+(i-1)), previousMeterValue.charAt(i-1) + "");
					}
			}
		
		this.currentMeterRead = previousMeterValue;
		Report.updateTestLog(logInfo, logStatus);
		setPlausibleReadingMixedElecNight(accountNumber);
		submitMeterReads();
	}
	public void setPlausibleReadingElecNight(String accountNumber){
		String logInfo = " Setting Plausible Reading for Account: " + accountNumber;
		String logStatus = "DONE";
		String previousMeterValue = getPreviousMeterReadElecNight(accountNumber);
		String meterSerialNumber = getMeterSerialNumberElecNight(accountNumber);
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
		System.out.println("999999999999999999999999999999999999999999999999999"+previousMeterValue);
		if(dialFieldCount == 10){
			for (int i = 6; i <=10; i++){
	        browser.inputByXpath(dialFieldsxPath.replace("NUMBER", ""+(i-6)).replace("register0","register1"), previousMeterValue.charAt(i-1) + "");
			}
		}
		else{
		for (int i = 1; i <= dialFieldCount; i++) {
			//browser.inputByXpath(dialFieldsxPath + "[" + i + "]",previousMeterValue.charAt(i - 1) + "");
			browser.inputByXpath(dialFieldsxPath.replace("NUMBER", ""+(i-1)), previousMeterValue.charAt(i - 1) + "");
		}
		}
		this.currentMeterRead = previousMeterValue;
		Report.updateTestLog(logInfo, logStatus);
		
		
	}
	public void setPlausibleReadingMixedElecNight(String accountNumber){
		String logInfo = " Setting Plausible Reading for Account: " + accountNumber;
		String logStatus = "DONE";
		String previousMeterValue = getPreviousMeterReadMixedElecNight(accountNumber);
		String meterSerialNumber = getMeterSerialNumberMixedElecNight(accountNumber);
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
		System.out.println("999999999999999999999999999999999999999999999999999"+previousMeterValue);
		if(dialFieldCount == 10){
			for (int i = 6; i <=10; i++){
	        browser.inputByXpath(dialFieldsxPath.replace("NUMBER", ""+(i-6)).replace("register0","register1"), previousMeterValue.charAt(i-1) + "");
			}
		}
		else{
		for (int i = 1; i <= dialFieldCount; i++) {
			//browser.inputByXpath(dialFieldsxPath + "[" + i + "]",previousMeterValue.charAt(i - 1) + "");
			browser.inputByXpath(dialFieldsxPath.replace("NUMBER", ""+(i-1)), previousMeterValue.charAt(i - 1) + "");
		}
		}
		this.currentMeterRead = previousMeterValue;
		Report.updateTestLog(logInfo, logStatus);
		
		
	}
	public void setPlausibleReadingAnonymousJIGas (String accountNumber){
		String logInfo = " Setting Plausible Reading for Account: " + accountNumber;
		String logStatus = "DONE";
		String previousMeterValue = getPreviousMeterReadAnonymousJIGas(accountNumber);
		String meterSerialNumber = getMeterSerialNumberAnonymousJIGas(accountNumber);
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
		/*System.out.println("222222222222222222222222222222222222222222222222222"+dialFieldsxPath);
		System.out.println("444444444444444444444444444444444444444444444444444"+DialsCountxPath);
		System.out.println("999999999999999999999999999999999999999999999999999"+previousMeterValue);*/
		
		
		for (int i = 1; i <= dialFieldCount; i++) {
			//browser.inputByXpath(dialFieldsxPath + "[" + i + "]",previousMeterValue.charAt(i - 1) + "");
			browser.inputByXpath(dialFieldsxPath.replace("NUMBER", ""+(i-1)), previousMeterValue.charAt(i - 1) + "");
		}
		this.currentMeterRead = previousMeterValue;
		Report.updateTestLog(logInfo, logStatus);
		setPlausibleReadingElecDay(accountNumber);
		submitMeterReads();
	}
	private String getPreviousMeterReadAnonymousJIGas(String accountNumber) {
		String previousMeterRead = "";

		//	String xpathforAcctNum = "//div[@class='dial-info default']/p[1]";
			String xpathforAcctNum = " .//*[@id='smrOverlayForm']/div[2]/div[2]/div[2]/div/p[1]";
			previousMeterRead = browser.getTextByXpath(xpathforAcctNum);
			previousMeterRead = previousMeterRead.contains(":") ? previousMeterRead
			        .substring(previousMeterRead.indexOf(':') + 1, previousMeterRead.length())
			        : "";
			        System.out.println("7777777777777777777" +previousMeterRead.trim());
			return previousMeterRead.trim();

		}
	
	private String getMeterSerialNumberAnonymousJIGas(String accountNumber) {

		String meterSerialNumber = "";

		//String xpathforAcctNum = "//div[@class='dial-info default']/p[3]";
		String xpathforAcctNum = ".//*[@id='smrOverlayForm']/div[2]/div[2]/div[2]/div/p[3]";
		
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
	public void  EnterRegistrationDetailas(){
		 
		
		verifyAndInputById(pageProperties.getProperty("SubmitMeterRead.Password"),"Password" , "password12");
		verifyAndInputById(pageProperties.getProperty("SubmitMeterRead.ConfirmPassword"),"confirm Password" , "password12");
		verifyAndClickWithXpath(pageProperties.getProperty("SubmitMeterRead.RegisterOnline"),"Create Account" );
		
	}
	public void verifyQuickRegisterOverlay(){
		browser.wait(9000);
		verifyAndInputByXpath(pageProperties.getProperty("SubmitMeterRead.Password"),"Password" , "password12");
		//verifyAndInputById(pageProperties.getProperty("SubmitMeterRead.ConfirmPassword"),"confirm Password" , "password12");
		verifyAndClickWithXpath(pageProperties.getProperty("SubmitMeterRead.TermsandConditions"),"Terms and Conditions" );
		verifyAndClickWithXpath(pageProperties.getProperty("SubmitMeterRead.RegisterOnline"),"Register Online" );
		browser.wait(9000);
		
	}
	public void verifyAccountPresence(){
	    browser.wait(9000);
        browser.dynamicWaituntilVisiblebyXpath(pageProperties.getProperty("SubmitMeterRead.YouAreNowRegistered"));
		
		if(browser.isTextPresent("You're now registered"))
		{
			
		Report.updateTestLog("Account is Been Created", "PASS");
			
		}
		else
		{
		Report.updateTestLog("Account is Been Created", "FAIL");	
		}
		
	}

		
		
	}

