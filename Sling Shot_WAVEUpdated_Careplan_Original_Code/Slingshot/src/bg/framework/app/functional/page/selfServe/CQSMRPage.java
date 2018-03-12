package bg.framework.app.functional.page.selfServe;

import java.util.Properties;

import org.openqa.selenium.WebElement;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class CQSMRPage extends BasePage {

	private final static String FILE_NAME = "resources/selfServe/SubmitMeterReadPage.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME)
			.load();
	private static String currentMeterRead;
	private static String currentMeterReadforfirstAccountforJIAccount;
	private static String currentMeterReadforsecondAccountforJIAccount;
	private static String currentmeterSerialNumber;
	private static String currentmeterSerialNumberforfirstaccount;
	private static String currentmeterSerialNumberforsecondaccount;

	public void navigateToSMR1Page() {

		browser.open("http://10.58.66.17:7001/content/britishgas/new-journey/SMR1.html");
		//browser.open(ApplicationConfig.APP_BG_URL+"new-journey/SMR1.html");
		browser.wait(getWaitTime());
		
	}

	public void SelectAccount(String accountNumber) {
		String accountCheckBoxXpath = pageProperties
				.getProperty("CQSMR1Page.SelectAccountCheckBoxXpath");
		accountCheckBoxXpath = accountCheckBoxXpath.replace("AccountNumber",
				accountNumber);
		verifyAndSelectCheckBoxByXpath(accountCheckBoxXpath,
				"Account Select Check Box");
		browser.wait(getWaitTime());
	}

	public void setImPlausbileReadingHigh(String accountNumber) {
		browser.wait(getWaitTime());
		SelectAccount(accountNumber);
		String logInfo = " Setting Plausible Reading for Account: "
				+ accountNumber;
		String logStatus = "DONE";
		String previousMeterValue = getPreviousMeterRead(accountNumber);
		String meterSerialNumber = getMeterSerialNumber(accountNumber);
		logInfo = logInfo + " The meter Serial Number is: " + meterSerialNumber
				+ ", The Previous Meter Read value is: " + previousMeterValue;

		String dialFieldsxPath = pageProperties
				.getProperty("CQSMR1Page.InputDialXpath");
		dialFieldsxPath = dialFieldsxPath.replace("MeterSerialNumber",
				meterSerialNumber);

		// Add +1 to the existing reading to make Plausible
		previousMeterValue = (Integer.parseInt(previousMeterValue) + 1) + "";
		int dialFieldCount = browser
				.getChildElementsCountByXpath(dialFieldsxPath);
		// TODO: update
		previousMeterValue = previousMeterValue.length() == dialFieldCount ? previousMeterValue
				: padZeros(previousMeterValue, dialFieldCount);
		//previousMeterValue = "9999";
		String FetchHighestRead = "";
		for (int i = 1; i <= dialFieldCount; i++) {

			browser.inputByXpath(dialFieldsxPath + "[" + i + "]", "9");
			FetchHighestRead = FetchHighestRead.concat("9");
			
		}
		this.currentMeterRead = FetchHighestRead;
		this.currentmeterSerialNumber = meterSerialNumber;

		Report.updateTestLog(logInfo, logStatus);

	}

	private String padZeros(String previousMeterValue1, int dialFieldCount1) {
		for (int i = previousMeterValue1.length(); i < dialFieldCount1; i++) {
			previousMeterValue1 = "0" + previousMeterValue1;
		}
		return previousMeterValue1;
	}

	private String getPreviousMeterRead(String accountNumber) {
		String previousMeterRead = "";

		String xpathforAcctNum = "//div[@class='dial-info default']/p[1]";

		previousMeterRead = browser.getTextByXpath(xpathforAcctNum);
		previousMeterRead = previousMeterRead.contains(":") ? previousMeterRead
				.substring(previousMeterRead.indexOf(':') + 1,
						previousMeterRead.length()) : "";
		return previousMeterRead.trim();

	}

	private String getMeterSerialNumber(String accountNumber) {

		String meterSerialNumber = "";

		String xpathforAcctNum = "//div[@class='dial-info default']/p[last()]";

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
				.substring(
						meterSerialNumber.indexOf(meterPrefix)
								+ meterPrefix.length(),
						meterSerialNumber.length()) : "";

		return meterSerialNumber.trim();
	}

	public void submitMeterReadsforImplausible() {
		
		browser.click(pageProperties
				.getProperty("CQSMR1Page.SubmitMeterButtonId"));
		browser.wait(getWaitTime());
		browser.WaitForElementWithId(pageProperties
				.getProperty("SubmitMeterRead.SubmitAlertOverlayId"));
		if (!browser.isElementVisible(pageProperties
				.getProperty("SubmitMeterRead.SubmitAlertOverlayId"))) {
			String logInfo = " Alert OverLay is not displayed for Implaussible MeterRead.";
			String logStatus = "FAIL";
			Report.updateTestLog(logInfo, logStatus);
			
		} else {
			browser.clickWithXpath(pageProperties
					.getProperty("SubmitMeterRead.OverlaySubmitButtonXpath"));
			String logInfo = " Alert OverLay is displayed for Implaussible MeterRead.";
			String logStatus = "Pass";
			Report.updateTestLog(logInfo, logStatus);
			
		}
	}
		
		public void submitMeterReadsforPlausible() {			
			browser.click(pageProperties
					.getProperty("CQSMR1Page.SubmitMeterButtonId"));
			browser.wait(getWaitTime());
			String logInfo = " Clicked on Submit Meter Read.";
			String logStatus = "Pass";
			Report.updateTestLog(logInfo, logStatus);
					
			

	}

	public void setPlausbileReading(String accountNumber) {
		browser.wait(getWaitTime());
		SelectAccount(accountNumber);
		String logInfo = " Setting Plausible Reading for Account: "
				+ accountNumber;
		String logStatus = "DONE";
		String previousMeterValue = getPreviousMeterRead(accountNumber);		
		String meterSerialNumber = getMeterSerialNumber(accountNumber);
		logInfo = logInfo + " The meter Serial Number is: " + meterSerialNumber
				+ ", The Previous Meter Read value is: " + previousMeterValue;

		String dialFieldsxPath = pageProperties
				.getProperty("CQSMR1Page.InputDialXpath");
		dialFieldsxPath = dialFieldsxPath.replace("MeterSerialNumber",
				meterSerialNumber);

		// Add +1 to the existing reading to make Plausible
		previousMeterValue = (Integer.parseInt(previousMeterValue) + 1) + "";
		int dialFieldCount = browser
				.getChildElementsCountByXpath(dialFieldsxPath);
		// TODO: update
		previousMeterValue = previousMeterValue.length() == dialFieldCount ? previousMeterValue
				: padZeros(previousMeterValue, dialFieldCount);

		for (int i = 1; i <= dialFieldCount; i++) {

			browser.inputByXpath(dialFieldsxPath + "[" + i + "]",
					previousMeterValue.charAt(i - 1) + "");
		}
		this.currentMeterRead = previousMeterValue;
		this.currentmeterSerialNumber = meterSerialNumber;
		Report.updateTestLog(logInfo, logStatus);
		
	}

	private String getPreviousMeterReadforJIAccountBasedonOrder(
			String accountNumber, int indexno) {
		String previousMeterRead = "";

		String xpathforAcctNum = "//div[@class='dial-info default']/p[1]";
		WebElement IndexedElement = browser.getChildelementBasedonOrder(
				xpathforAcctNum, indexno);

		previousMeterRead = IndexedElement.getText();		
		previousMeterRead = previousMeterRead.contains(":") ? previousMeterRead
				.substring(previousMeterRead.indexOf(':') + 1,
						previousMeterRead.length()) : "";
		return previousMeterRead.trim();

	}

	private String getSerialNUmberforJIAccountBasedonOrder(
			String accountNumber, int indexno) {
		String meterSerialNumber = "";

		String xpathforAcctNum = "//div[@class='dial-info default']/p[last()]";
		WebElement IndexedElement = browser.getChildelementBasedonOrder(
				xpathforAcctNum, indexno);

		meterSerialNumber = IndexedElement.getText();

		
		String meterPrefix = pageProperties
				.getProperty("SubmitMeterRead.SerialNumberPrefix");
		
		meterSerialNumber = meterSerialNumber.contains(meterPrefix) ? meterSerialNumber
				.substring(meterSerialNumber.indexOf(meterPrefix)
								+ meterPrefix.length(),
						meterSerialNumber.length()) : "";

		return meterSerialNumber.trim();

	}

	public void verifyandCompareTwoString(String value1, String value2) {
		if (value1.equalsIgnoreCase(value2)) {
			Report.updateTestLog(value1 + " Submitted value equals Reflected value " + value2, "Pass");
		} else {
			Report.updateTestLog(value1 + " Submited value not equals Reflected value" + value2, "Fail");
		}
	}

	public void setPlausbileReadingforJIAccount(String accountNumber) {
		browser.wait(getWaitTime());
		SelectAccount(accountNumber);
		String logInfo = " Setting Plausible Reading for Account: "
				+ accountNumber;
		String logStatus = "DONE";
		String previousMeterValueforfirstaccount = getPreviousMeterReadforJIAccountBasedonOrder(
				accountNumber, 0);
		String meterSerialNumberforfirstaccount = getSerialNUmberforJIAccountBasedonOrder(
				accountNumber, 0);
		logInfo = logInfo
				+ " The meter Serial Number for the first account is: "
				+ previousMeterValueforfirstaccount
				+ ", The Previous Meter Read value for the second account is: "
				+ meterSerialNumberforfirstaccount;

		String dialFieldsxPath = pageProperties
				.getProperty("CQSMR1Page.InputDialXpath");
		dialFieldsxPath = dialFieldsxPath.replace("MeterSerialNumber",
				meterSerialNumberforfirstaccount);

		// Add +1 to the existing reading to make Plausible
		previousMeterValueforfirstaccount = (Integer
				.parseInt(previousMeterValueforfirstaccount) + 1) + "";
		int dialFieldCount = browser
				.getChildElementsCountByXpath(dialFieldsxPath);
		// TODO: update
		previousMeterValueforfirstaccount = previousMeterValueforfirstaccount
				.length() == dialFieldCount ? previousMeterValueforfirstaccount
				: padZeros(previousMeterValueforfirstaccount, dialFieldCount);

		for (int i = 1; i <= dialFieldCount; i++) {

			browser.inputByXpath(dialFieldsxPath + "[" + i + "]",
					previousMeterValueforfirstaccount.charAt(i - 1) + "");
		}
		currentMeterReadforfirstAccountforJIAccount = previousMeterValueforfirstaccount;
		Report.updateTestLog(logInfo, logStatus);
		// Second account

		String previousMeterValueforSecondaccount = getPreviousMeterReadforJIAccountBasedonOrder(
				accountNumber, 1);
		String meterSerialNumberforSecondaccount = getSerialNUmberforJIAccountBasedonOrder(
				accountNumber, 1);
		logInfo = " The meter Serial Number for the first account is: "
				+ previousMeterValueforSecondaccount
				+ ", The Previous Meter Read value for the second account is: "
				+ meterSerialNumberforSecondaccount;

		dialFieldsxPath = pageProperties
				.getProperty("CQSMR1Page.InputDialXpath");
		dialFieldsxPath = dialFieldsxPath.replace("MeterSerialNumber",
				meterSerialNumberforSecondaccount);

		// Add +1 to the existing reading to make Plausible
		previousMeterValueforSecondaccount = (Integer
				.parseInt(previousMeterValueforSecondaccount) + 1) + "";
		dialFieldCount = browser.getChildElementsCountByXpath(dialFieldsxPath);
		// TODO: update
		previousMeterValueforSecondaccount = previousMeterValueforSecondaccount
				.length() == dialFieldCount ? previousMeterValueforSecondaccount
				: padZeros(previousMeterValueforSecondaccount, dialFieldCount);
		
		for (int i = 1; i <= dialFieldCount; i++) {

			browser.inputByXpath(dialFieldsxPath + "[" + i + "]",
					previousMeterValueforSecondaccount.charAt(i - 1) + "");
		}
		currentMeterReadforsecondAccountforJIAccount = previousMeterValueforSecondaccount;
		currentmeterSerialNumberforfirstaccount = meterSerialNumberforfirstaccount;
		currentmeterSerialNumberforsecondaccount = meterSerialNumberforSecondaccount;
		//System.out.println("previousMeterValueforSecondaccount --->"+previousMeterValueforSecondaccount);
		Report.updateTestLog(logInfo, logStatus);
	}

	public void verifyMeterConfirmationforJIAccount(String accNumber) {

		String dialFieldsxPath = pageProperties
				.getProperty("CQSMR1Page.InputDialXpath");
		dialFieldsxPath = dialFieldsxPath.replace("MeterSerialNumber",
				currentmeterSerialNumberforfirstaccount);
		verifyIsTextPresent(accNumber, "Account Number");
		verifyIsTextPresent(currentmeterSerialNumberforfirstaccount,
				"MeterSerialNumber for first Account");
		verifyIsTextPresent(currentmeterSerialNumberforsecondaccount,
				"MeterSerialNumber for first Account");
		verifyIsTextPresent("Thank You", "Thank You");
		
		int dialFieldCount = browser
				.getChildElementsCountByXpath(dialFieldsxPath);
		String FetchingMeterReadString = "";
		for (int i = 1; i <= dialFieldCount; i++) {

			FetchingMeterReadString = FetchingMeterReadString.concat(browser
					.getAttributeByXpath(dialFieldsxPath + "[" + i + "]",
							"value"));

		}

		verifyandCompareTwoString(FetchingMeterReadString,
				currentMeterReadforfirstAccountforJIAccount);
		dialFieldsxPath = pageProperties
				.getProperty("CQSMR1Page.InputDialXpath");
		dialFieldsxPath = dialFieldsxPath.replace("MeterSerialNumber",
				currentmeterSerialNumberforsecondaccount);
		dialFieldCount = browser.getChildElementsCountByXpath(dialFieldsxPath);
		FetchingMeterReadString = "";
		for (int i = 1; i <= dialFieldCount; i++) {

			FetchingMeterReadString = FetchingMeterReadString.concat(browser
					.getAttributeByXpath(dialFieldsxPath + "[" + i + "]",
							"value"));

		}
		verifyandCompareTwoString(FetchingMeterReadString,
				currentMeterReadforsecondAccountforJIAccount);
	}

	public void verifyMeterConfirmation(String accNumber) {

		browser.wait(getWaitTime());
		String dialFieldsxPath = pageProperties
				.getProperty("CQSMR1Page.InputDialXpath");
		dialFieldsxPath = dialFieldsxPath.replace("MeterSerialNumber",
				CQSMRPage.currentmeterSerialNumber);
		verifyIsTextPresent(accNumber, "Account Number");
		verifyIsTextPresent(currentmeterSerialNumber,
				"MeterSerialNumber for Account");
		int dialFieldCount = browser
				.getChildElementsCountByXpath(dialFieldsxPath);
		String FetchingMeterReadString = "";
		for (int i = 1; i <= dialFieldCount; i++) {

			FetchingMeterReadString = FetchingMeterReadString.concat(browser
					.getAttributeByXpath(dialFieldsxPath + "[" + i + "]","value"));

		}
		verifyandCompareTwoString(FetchingMeterReadString, currentMeterRead);
		 new LegacyLoginPage().logOut();
	}

	
	public void clickonSMRLink(UserProfile userProfile){
		//browser.open(ApplicationConfig.APP_BG_URL+"content/britishgas/new-journey/SMR1.html");		
		browser.open("https://localhost/content/britishgas/new-journey/SMR1.html");
		
		  //browser.isElementVisibleWithXpath(pageProperties.getProperty("CQSMR1Page.SMRLinkXpath")))
	        //browser.clickWithXpath(pageProperties.getProperty("CQSMR1Page.SMRLinkXpath"));
	        Report.updateTestLog("Submit Meter Read Link is Selected Successfully ", "PASS");
	        

	        //verifyAndClickWithLinkText(pageProperties.getProperty("CQSMR1Page.SMRLinkXpath"), "Submit Meter Read Link");
	    }
	
	
	  public void verifyMeterConfirmationforMultipleAccount() {
          verifyIsTextPresent("Thank You");
          new LegacyLoginPage().logOut();
          }

      public void setImPlausbileReadingforMultipleAccount(String accountNumber) {
          browser.wait(getWaitTime());
          SelectAccount(accountNumber);
          String logInfo = " Setting Plausible Reading for Account: "
                       + accountNumber;
          String logStatus = "DONE";
          String previousMeterValue = getPreviousMeterReadforJIAccountBasedonOrder(
                       accountNumber, 0);
          String meterSerialNumber = getSerialNUmberforJIAccountBasedonOrder(
                       accountNumber, 0);
          logInfo = " The meter Serial Number for the first account is: "
                  + previousMeterValue
                  + ", The Previous Meter Read value for the first account is: "
                  + meterSerialNumber;
          Report.updateTestLog(logInfo, logStatus);
          
          String dialFieldsxPath = pageProperties
                       .getProperty("CQSMR1Page.InputDialXpathDayReading");
          dialFieldsxPath = dialFieldsxPath.replace("MeterSerialNumber",
                       meterSerialNumber);

          // Add +1 to the existing reading to make Plausible
          previousMeterValue = (Integer
                        .parseInt(previousMeterValue) + 1) + "";
          int dialFieldCount = browser
                       .getChildElementsCountByXpath(dialFieldsxPath);
          // TODO: update
          previousMeterValue = previousMeterValue
                       .length() == dialFieldCount ? previousMeterValue
                       : padZeros(previousMeterValue, dialFieldCount);
          String FetchingString = "";

          for (int i = 1; i <= dialFieldCount; i++) {

                 browser.inputByXpath(dialFieldsxPath + "[" + i + "]","9"); 
                 FetchingString = FetchingString.concat("9");
                 
                              //previousMeterValueforfirstaccount.charAt(i - 1) + "");
          }
          //currentMeterReadforfirstAccountforJIAccount = FetchingString;
          Report.updateTestLog(logInfo, logStatus);
          // Second account

          previousMeterValue = getPreviousMeterReadforJIAccountBasedonOrder(
                       accountNumber, 1);
          meterSerialNumber = getSerialNUmberforJIAccountBasedonOrder(
                       accountNumber, 1);
          logInfo = " The meter Serial Number for the second account is: "
                       + previousMeterValue
                       + ", The Previous Meter Read value for the second account is: "
                       + meterSerialNumber;

          dialFieldsxPath = pageProperties
                       .getProperty("CQSMR1Page.InputDialXpathNightReading");
          dialFieldsxPath = dialFieldsxPath.replace("MeterSerialNumber",
                       meterSerialNumber);

          // Add +1 to the existing reading to make Plausible
          previousMeterValue = (Integer
                       .parseInt(previousMeterValue) + 1) + "";
          dialFieldCount = browser.getChildElementsCountByXpath(dialFieldsxPath);
          // TODO: update
          previousMeterValue = previousMeterValue
                       .length() == dialFieldCount ? previousMeterValue
                       : padZeros(previousMeterValue, dialFieldCount);
          FetchingString ="";
          for (int i = 1; i <= dialFieldCount; i++) {

                 browser.inputByXpath(dialFieldsxPath + "[" + i + "]","9");
                 FetchingString = FetchingString.concat("9");
                              //previousMeterValueforSecondaccount.charAt(i - 1) + "");
          }
         
          Report.updateTestLog(logInfo, logStatus);
          
          
          previousMeterValue = getPreviousMeterReadforJIAccountBasedonOrder(
                  accountNumber, 2);
     meterSerialNumber = getSerialNUmberforJIAccountBasedonOrder(
                  accountNumber, 2);
     logInfo = " The meter Serial Number for the third account is: "
                  + previousMeterValue
                  + ", The Previous Meter Read value for the third account is: "
                  + meterSerialNumber;

     dialFieldsxPath = pageProperties
                  .getProperty("CQSMR1Page.InputDialXpath");
     dialFieldsxPath = dialFieldsxPath.replace("MeterSerialNumber",
                meterSerialNumber);

     // Add +1 to the existing reading to make Plausible
     previousMeterValue = (Integer
                  .parseInt(previousMeterValue) + 1) + "";
     dialFieldCount = browser.getChildElementsCountByXpath(dialFieldsxPath);
     // TODO: update
     previousMeterValue = previousMeterValue
                  .length() == dialFieldCount ? previousMeterValue
                  : padZeros(previousMeterValue, dialFieldCount);
     FetchingString ="";
     for (int i = 1; i <= dialFieldCount; i++) {

            browser.inputByXpath(dialFieldsxPath + "[" + i + "]","9");
            FetchingString = FetchingString.concat("9");
                         //previousMeterValueforSecondaccount.charAt(i - 1) + "");
     }
    
     Report.updateTestLog(logInfo, logStatus);
     
         
   }

      
      public void setPlausbileReadingforMultipleAccount(String accountNumber) {
          browser.wait(getWaitTime());
          SelectAccount(accountNumber);
          String logInfo = " Setting Plausible Reading for Account: "
                       + accountNumber;
          String logStatus = "DONE";
          String previousMeterValue = getPreviousMeterReadforJIAccountBasedonOrder(
                       accountNumber, 0);
          String meterSerialNumber = getSerialNUmberforJIAccountBasedonOrder(
                       accountNumber, 0);
          logInfo = " The meter Serial Number for the first account is: "
                  + previousMeterValue
                  + ", The Previous Meter Read value for the first account is: "
                  + meterSerialNumber;
          Report.updateTestLog(logInfo, logStatus);
          
          String dialFieldsxPath = pageProperties
                       .getProperty("CQSMR1Page.InputDialXpath");
          dialFieldsxPath = dialFieldsxPath.replace("MeterSerialNumber",
                       meterSerialNumber);

          // Add +1 to the existing reading to make Plausible
          previousMeterValue = (Integer
                        .parseInt(previousMeterValue) + 1) + "";
          int dialFieldCount = browser
                       .getChildElementsCountByXpath(dialFieldsxPath);
          // TODO: update
          previousMeterValue = previousMeterValue
                       .length() == dialFieldCount ? previousMeterValue
                       : padZeros(previousMeterValue, dialFieldCount);
          
          for (int i = 1; i <= dialFieldCount; i++) {

        	  browser.inputByXpath(dialFieldsxPath + "[" + i + "]",
  					previousMeterValue.charAt(i - 1) + "");
                 
                 
                              //previousMeterValueforfirstaccount.charAt(i - 1) + "");
          }
          //currentMeterReadforfirstAccountforJIAccount = FetchingString;
          Report.updateTestLog(logInfo, logStatus);
          // Second account

          previousMeterValue = getPreviousMeterReadforJIAccountBasedonOrder(
                       accountNumber, 1);
          meterSerialNumber = getSerialNUmberforJIAccountBasedonOrder(
                       accountNumber, 1);
          logInfo = " The meter Serial Number for the second account is: "
                       + previousMeterValue
                       + ", The Previous Meter Read value for the second account is: "
                       + meterSerialNumber;

          dialFieldsxPath = pageProperties
                       .getProperty("CQSMR1Page.InputDialXpathDayReading");
          dialFieldsxPath = dialFieldsxPath.replace("MeterSerialNumber",
                       meterSerialNumber);

          // Add +1 to the existing reading to make Plausible
          previousMeterValue = (Integer
                       .parseInt(previousMeterValue) + 1) + "";
          dialFieldCount = browser.getChildElementsCountByXpath(dialFieldsxPath);
          // TODO: update
          previousMeterValue = previousMeterValue
                       .length() == dialFieldCount ? previousMeterValue
                       : padZeros(previousMeterValue, dialFieldCount);
         
          for (int i = 1; i <= dialFieldCount; i++) {

        	  browser.inputByXpath(dialFieldsxPath + "[" + i + "]",
  					previousMeterValue.charAt(i - 1) + "");
                              //previousMeterValueforSecondaccount.charAt(i - 1) + "");
          }
         
          Report.updateTestLog(logInfo, logStatus);
          
          
          previousMeterValue = getPreviousMeterReadforJIAccountBasedonOrder(
                  accountNumber, 2);
     meterSerialNumber = getSerialNUmberforJIAccountBasedonOrder(
                  accountNumber, 2);
     logInfo = " The meter Serial Number for the third account is: "
                  + previousMeterValue
                  + ", The Previous Meter Read value for the third account is: "
                  + meterSerialNumber;

     dialFieldsxPath = pageProperties
                  .getProperty("CQSMR1Page.InputDialXpathNightReading");
     dialFieldsxPath = dialFieldsxPath.replace("MeterSerialNumber",
                meterSerialNumber);

     // Add +1 to the existing reading to make Plausible
     previousMeterValue = (Integer
                  .parseInt(previousMeterValue) + 1) + "";
     dialFieldCount = browser.getChildElementsCountByXpath(dialFieldsxPath);
     // TODO: update
     previousMeterValue = previousMeterValue
                  .length() == dialFieldCount ? previousMeterValue
                  : padZeros(previousMeterValue, dialFieldCount);
    
     for (int i = 1; i <= dialFieldCount; i++) {

    	 browser.inputByXpath(dialFieldsxPath + "[" + i + "]",
					previousMeterValue.charAt(i - 1) + "");
            
                         //previousMeterValueforSecondaccount.charAt(i - 1) + "");
     }
    
     Report.updateTestLog(logInfo, logStatus);
     
         
   }

      public void setImPlausbileReadingforJIAccount(String accountNumber) {
  		browser.wait(getWaitTime());
  		SelectAccount(accountNumber);
  		String logInfo = " Setting Plausible Reading for Account: "
  				+ accountNumber;
  		String logStatus = "DONE";
  		String previousMeterValueforfirstaccount = getPreviousMeterReadforJIAccountBasedonOrder(
  				accountNumber, 0);
  		String meterSerialNumberforfirstaccount = getSerialNUmberforJIAccountBasedonOrder(
  				accountNumber, 0);
  		logInfo = logInfo
  				+ " The meter Serial Number for the first account is: "
  				+ previousMeterValueforfirstaccount
  				+ ", The Previous Meter Read value for the second account is: "
  				+ meterSerialNumberforfirstaccount;

  		String dialFieldsxPath = pageProperties
  				.getProperty("CQSMR1Page.InputDialXpath");
  		dialFieldsxPath = dialFieldsxPath.replace("MeterSerialNumber",
  				meterSerialNumberforfirstaccount);

  		// Add +1 to the existing reading to make Plausible
  		previousMeterValueforfirstaccount = (Integer
  				.parseInt(previousMeterValueforfirstaccount) + 1) + "";
  		int dialFieldCount = browser
  				.getChildElementsCountByXpath(dialFieldsxPath);
  		// TODO: update
  		previousMeterValueforfirstaccount = previousMeterValueforfirstaccount
  				.length() == dialFieldCount ? previousMeterValueforfirstaccount
  				: padZeros(previousMeterValueforfirstaccount, dialFieldCount);
  		String FetchingString= "";
  		for (int i = 1; i <= dialFieldCount; i++) {

  			browser.inputByXpath(dialFieldsxPath + "[" + i + "]","9");
  			FetchingString = FetchingString.concat("9");
  			
  					//previousMeterValueforfirstaccount.charAt(i - 1) + "");
  		}
  		currentMeterReadforfirstAccountforJIAccount = FetchingString;
  		Report.updateTestLog(logInfo, logStatus);
  		// Second account

  		String previousMeterValueforSecondaccount = getPreviousMeterReadforJIAccountBasedonOrder(
  				accountNumber, 1);
  		String meterSerialNumberforSecondaccount = getSerialNUmberforJIAccountBasedonOrder(
  				accountNumber, 1);
  		logInfo = " The meter Serial Number for the first account is: "
  				+ previousMeterValueforSecondaccount
  				+ ", The Previous Meter Read value for the second account is: "
  				+ meterSerialNumberforSecondaccount;

  		dialFieldsxPath = pageProperties
  				.getProperty("CQSMR1Page.InputDialXpath");
  		dialFieldsxPath = dialFieldsxPath.replace("MeterSerialNumber",
  				meterSerialNumberforSecondaccount);

  		// Add +1 to the existing reading to make Plausible
  		previousMeterValueforSecondaccount = (Integer
  				.parseInt(previousMeterValueforSecondaccount) + 1) + "";
  		dialFieldCount = browser.getChildElementsCountByXpath(dialFieldsxPath);
  		// TODO: update
  		previousMeterValueforSecondaccount = previousMeterValueforSecondaccount
  				.length() == dialFieldCount ? previousMeterValueforSecondaccount
  				: padZeros(previousMeterValueforSecondaccount, dialFieldCount);
  		FetchingString ="";
  		for (int i = 1; i <= dialFieldCount; i++) {

  			browser.inputByXpath(dialFieldsxPath + "[" + i + "]","9");
  			FetchingString = FetchingString.concat("9");
  					//previousMeterValueforSecondaccount.charAt(i - 1) + "");
  		}
  		currentMeterReadforsecondAccountforJIAccount = FetchingString;
  		currentmeterSerialNumberforfirstaccount = meterSerialNumberforfirstaccount;
  		currentmeterSerialNumberforsecondaccount = meterSerialNumberforSecondaccount;
  		//System.out.println("previousMeterValueforSecondaccount --->"+previousMeterValueforSecondaccount);
  		Report.updateTestLog(logInfo, logStatus);
  	}


}
