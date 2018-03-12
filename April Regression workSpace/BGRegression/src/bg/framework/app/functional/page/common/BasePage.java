package bg.framework.app.functional.page.common;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.ErrorLabels;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.common.control.ControlProvider;
import bg.framework.common.control.FindById;
import bg.framework.common.control.FindByXpath;
import bg.framework.common.control.UIControl;
import bg.framework.common.functional.MessageVerification;
import bg.framework.common.functional.UIDriver;
import bg.framework.common.functional.UIOperation;

import bg.framework.common.functional.WebDriverProvider;


public class BasePage {

    public UIOperation browser;

/* Added for BGMO Start */
	private final static String Service_Order_FILE_NAME = "C:\\Documents and Settings\\mathuric\\Desktop\\workspace\\BGRegression\\src\\resources\\bgmo_oab\\booking\\ServiceOrderNumber.txt";
	// private static Properties pageProperties1 = new
	// PropertyLoader(Service_Order_FILE_NAME).load();

	File Sofile = new File(Service_Order_FILE_NAME);
private final static String FILE_NAME2 = "resources/selfServe/servicesUpgradeToSmartMeter.Properties";
	private static Properties pageProperties2 = new PropertyLoader(FILE_NAME2)
			.load();




    protected MessageVerification messageVerification;
    private final static String FILE_NAME = "resources/common/LoginPage.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();


    public BasePage() {
    	if(ApplicationConfig.Application_MakeAPayment.equalsIgnoreCase("false"))
    	{
        UIDriver uiDriver = WebDriverProvider.getCurrentDriver();
        browser = new UIOperation(uiDriver);
        browser.wait(getWaitTime());
        messageVerification = new MessageVerification(uiDriver);
//        verifyPageHasNoErrors();
    	}
    	
    }

    private void verifyPageHasNoErrors() {
        List<String> errorMessages = ErrorLabels.CRITICAL_ERROR_MESSAGES;
        for (String error : errorMessages) {
            messageVerification.failIfMessageExists(error);
        }
    }

    protected String getUnsignedBalance(String balance) {
        BigDecimal bigDecimalBalance = new BigDecimal(balance);
        StringBuilder unsignedBalance = new StringBuilder(bigDecimalBalance.abs().toString());

        if (bigDecimalBalance.compareTo(BigDecimal.ZERO) == -1) {
            unsignedBalance.append(" in credit");
        } else if (bigDecimalBalance.compareTo(BigDecimal.ZERO) == 1) {
            unsignedBalance.append(" in debit");
        }
        return unsignedBalance.toString();
    }

    public int getWaitTime() {
        return 10000;
    }

    /*
	 * Method : verifyAndSelectDropDownBox   Created by: Karthigai Priyan P   Created On: 22-02-2012
	 * Description: Method to verify and select the drop down value based in the id property
	 */
    public void verifyAndSelectDropDownBox(String property, String name, String value) {
        if (browser.isElementVisible(property)) {
            browser.selectfromDropBox("id", property, value);
            Report.updateTestLog(name + " field filled with the value : " + value, "Done");
        } else {
            Report.updateTestLog(name + " field not found in the application page", "FAIL");
        }
    }
    
    
    public void verifyAndSelectDropDownBoxByXpath(String property, String name, String value) {
        if (browser.isElementVisibleWithXpath(property)) {
            browser.selectfromDropBoxByXpath(property, value);
            Report.updateTestLog(name + " field filled with the value : " + value, "Done");
        } else {
            Report.updateTestLog(name + " field not found in the application page", "FAIL");
        }
    }
 

    /*
      * Method : verifyIsTextPresent   Created by: Karthigai Priyan P   Created On: 22-02-2012
      * Description: Method to verify the given text is present
      */
    public boolean verifyIsTextPresent(String value) {
        browser.wait(2000);
        if (browser.isTextPresent(value)) {
            Report.updateTestLog("'" + value + "' present in the application", "PASS");
            return true;
        } else {
            Report.updateTestLog("'" + value + "' not present in the application", "FAIL");
            return false;
        }
    }

    /*
      * Method : verifyIsTextPresent   Created by: Karthigai Priyan P   Created On: 22-02-2012
      * Description: Method to verify the given text is present
      */
    public boolean verifyIsTextPresent(String value, String Name) {
        browser.wait(2000);
        if (browser.isTextPresent(value)) {
            Report.updateTestLog("'" + Name + "' present in the application as : " + value, "PASS");
            return true;
        } else {
            Report.updateTestLog("'" + Name + "' is not present in the application", "Fail");
            return false;
        }
    }

    /*
      * Method : verifyIsElementVisibleById   Created by: Karthigai Priyan P   Created On: 22-02-2012
      * Description: Method to verify the existance of Element using id property
      */
    public void verifyIsElementVisibleById(String getWaitTime,String name) {
        if (browser.isElementVisible(getWaitTime)) {
            String webElementValue = browser.getText(getWaitTime);
            Report.updateTestLog(name + " is displayed in the application : " + webElementValue, "PASS");
        } else {
            Report.updateTestLog(name + " is not displayed in the application ", "FAIL");
        }
    }

    /*
      * Method : verifyIsElementVisibleWithXpath   Created by: Karthigai Priyan P   Created On: 22-02-2012
      * Description: Method to verify the existance of Element using Xpath property
      */
    public void verifyIsElementVisibleWithXpath(String property, String name) {
        if (browser.isElementVisibleWithXpath(property)) {
            String webElementValue = browser.getTextByXpath(property);
            Report.updateTestLog(name + " is displayed in the application : " + webElementValue, "PASS");
        } else {
            Report.updateTestLog(name + " is not displayed in the application ", "FAIL");
        }
    }

    /*
      * Method : verifyAndInputById   Created by: Karthigai Priyan P   Created On: 22-02-2012
      * Description: Method to verify and to enter the value in the field using id property
      */
    public void verifyAndSelectCheckBoxByID(String property, String name) {
        if (browser.isElementVisible(property)) {
            //browser.clearValue(property);
            if (!browser.isSelected(property)) {
                UIControl controlType = new ControlProvider().getControl(new FindById(property));
                controlType.setValue(property);
            }

            Report.updateTestLog(name + " Checkbox checked ", "Done");
        } else {
            Report.updateTestLog(name + " Checkbox NOT checked ", "Done");
        }
    }

    /*
      * Method : verifyAndInputById   Created by: Karthigai Priyan P   Created On: 22-02-2012
      * Description: Method to verify and to enter the value in the field using id property
      */
    public void verifyAndInputById(String property, String name, String value) {
        if (browser.isElementVisible(property)) {
            browser.clearValue(property);
            browser.input(property, value);
            Report.updateTestLog(name + " field filled with the value : " + value, "Done");
        } else {
            Report.updateTestLog(name + " field not found in the application page", "FAIL");
        }
    }

    /*
      * Method : verifyAndInputByName   Created by: Karthigai Priyan P   Created On: 22-02-2012
      * Description: Method to verify and to enter the value in the field using Name property
      */
    public void verifyAndInputByName(String property, String name, String value) {
        if (browser.isTextPresent(property)) {
            browser.clearValueByName(property);
            browser.inputByName(property, value);
            Report.updateTestLog(name + " field filled with the value : " + value, "Done");
        } else {
            Report.updateTestLog(name + " field not found in the application page", "FAIL");
        }
    }

    /*
      * Method : verifyAndInputByXpath   Created by: Karthigai Priyan P   Created On: 22-02-2012
      * Description: Method to verify and to enter the value in the field using Xpath property
      */
    public void verifyAndInputByXpath(String property, String name, String value) {
        if (browser.isElementVisibleWithXpath(property)) {
            browser.clearValueByXpath(property);
            browser.inputByXpath(property, value);
            Report.updateTestLog(name + " field filled with the value : " + value, "Done");
        } else {
            Report.updateTestLog(name + " field not found in the application page", "FAIL");
        }
    }

    /*
      * Method : verifyAndInputWithName   Created by: Karthigai Priyan P   Created On: 22-02-2012
      * Description: Method to verify and to enter the value in the field with Name Property
      */
    public void verifyAndInputWithName(String property, String name, String value) {
        if (browser.isElementVisibleWithName(property)) {
            browser.clearValueByName(property);
            browser.inputWithName(property, value);
            Report.updateTestLog(name + " field filled with the value : " + value, "Done");
        } else {
            Report.updateTestLog(name + " field not found in the application page", "FAIL");
        }
    }

    /*
      * Method : verifyAndClickWithClass   Created by: Karthigai Priyan P   Created On: 22-02-2012
      * Description: Method to verify and click the web object using the class property
      */
    public void verifyAndClickWithClass(String property, String name) {
        if (browser.isElementVisibleWithClass(property)) {
            browser.clickWithClass(property);
            Report.updateTestLog(name + " object clicked ", "Done");
        } else {
            Report.updateTestLog(name + " object not found in the application page", "FAIL");
        }
    }

    public void verifyAndClick(String property, String name) {
        if (browser.isElementVisible(property)) {
            browser.click(property);
            Report.updateTestLog(name + " object clicked ", "Done");
        } else {
            Report.updateTestLog(name + " object not found in the application page", "FAIL");
        }
    }

    public void verifyAndSelectCheckBox(String property, String name) {
        if (!browser.isSelected(property)) {
            browser.click(property);
            Report.updateTestLog(name + " object clicked ", "Done");
        } else {
            Report.updateTestLog(name + " object already selected", "Done");
        }
    }

    /*
      * Method : verifyAndClickWithLinkText   Created by: Karthigai Priyan P   Created On: 22-02-2012
      * Description: Method to verify and click the link with the text value
      */
    public void verifyAndClickWithLinkText(String property, String name) {
        if (browser.isTextPresent(property)) {
            browser.clickWithLinkText(property);
            Report.updateTestLog(name + " object clicked ", "Done");
        } else {
            Report.updateTestLog(name + " object not found in the application page", "FAIL");
        }
    }

    /*
      * Method : verifyAndClickWithName   Created by: Karthigai Priyan P   Created On: 22-02-2012
      * Description: Method to verify and click the web object using Name property
      */
    public void verifyAndClickWithName(String property, String name) {
        if (browser.isElementVisibleWithName(property)) {
            browser.clickWithName(property);
            Report.updateTestLog(name + " object clicked ", "Done");
        } else {
            Report.updateTestLog(name + " object not found in the application page", "FAIL");
        }
    }

    /*
      * Method : verifyAndClickWithXpath   Created by: Karthigai Priyan P   Created On: 22-02-2012
      * Description: Method to verify and click the web object using Xpath property
      */
    public void verifyAndClickWithXpath(String property, String name) {
        browser.wait(500);
        if (browser.isElementVisibleWithXpath(property)) {
            browser.clickWithXpath(property);
            Report.updateTestLog(name + " object clicked ", "Done");
        } else {
            Report.updateTestLog(name + " object not found in the application page", "FAIL");
        }
    }
    
    public void verifyAndClickWithXpath(String property, String text, String name) {
        browser.wait(500);
        if (browser.isElementVisibleWithXpath(property)) {
            browser.clickWithXpath(property);
            Report.updateTestLog(text + name + " object clicked ", "Done");
        } else {
            Report.updateTestLog(text + name + " object not found in the application page", "FAIL");
        }
    }
    
    /*
     * Method : verifyPageTitle   
     * Description: Method to get title from page matches with given title
     */
    public void verifyPageTitle(String title){
    	browser.wait(500);
    	if(browser.getTitle().equals(title)){
    		 Report.updateTestLog("Expected title : <b>"+title + "</b> displayed.", "PASS");
    	}else{
    		Report.updateTestLog("Expected title : <b>"+title + "</b> not displayed. Actual title <b>"+browser.getTitle()+ "</b> ", "FAIL");
    	}
    }

    /*
      * Method : getMeterList   Created by: Bava  Created On: 22-02-2012
      * Description: Method to get the Meter list
      */
    public List<String> getMeterList(String webElement) {
        List<String> Meter = browser.getFromDropBox("id", webElement);
        return Meter;
    }

    /*
      * Method : getPostcode   Created by: Bava  Created On: 22-02-2012
      * Description: Method to get the post code
      */
    public String getPostcode(int region1) {
        String postcode = null;
        switch (region1) {
            case 0:
                postcode = "AL7 4hd";
                break;
            case 1:
                postcode = "LE12 9LX";
                break;
            case 2:
                postcode = "BR1 7yj";
                break;
            case 3:
                postcode = "CH4 7UH";
                break;
            case 4:
                postcode = "B10 9Ju";
                break;
            case 5:
                postcode = "DH2 7GH";
                break;
            case 6:
                postcode = "BB2 7DF";
                break;
            case 7:
                postcode = "AB14 7GH";
                break;
            case 8:
                postcode = "DG10 7FG";
                break;
            case 9:
                postcode = "BN10 7PR";
                break;
            case 10:
                postcode = "BH7 6VC";
                break;
            case 11:
                postcode = "CF10 6FG";
                break;
            case 12:
                postcode = "BA3 7GH";
                break;
            case 13:
                postcode = "BD10 5RT";
                break;
        }
        return postcode;
    }

    public static String ceilDouble(String value, String format) {
        double dbl = Double.parseDouble(value);
        DecimalFormat formatter = new DecimalFormat(format);
        if (value.contains(".")) {
            int charaftDot = value.length()
                    - value.indexOf(".");
            if (charaftDot
                    == 1) {
                formatter = new DecimalFormat("0.0");
            }
        }
        return formatter.format(dbl);
    }
    
        
    public void verifyAndSelectCheckBoxByXpath(String property, String name) {
        if (browser.isElementVisibleWithXpath(property)) {
            //browser.clearValue(property);
            if (!browser.isSelected(property)) {
                UIControl controlType = new ControlProvider().getControl(new FindByXpath(property));
                controlType.setValue(property);
            }

            Report.updateTestLog(name + " Checkbox checked ", "Done");
        } else {
            Report.updateTestLog(name + " Checkbox NOT checked ", "FAIL");
        }
    }
    


    public String[] getInvalidPostCode() {
        String[] array = {"","sm#*", "serre", "12346", "sm444eee", "sms444ee"};
        return array;
    }
    public String[][] getInvalidPersonalDetails(){
        String[][] details = {{"Please select","","",""},{"Mr","","",""},{"Mr","123","123","123"},{"Mr","Digital","123","123"},{"Mr","Digital","Automaiton","123"},
                {"Mr","Digital","Automation","abc@"},{"Mr","Digital","Automation","abc@bb"},{"Mr","Digital","Automation","abc@ab$c.com"}};
        return details;
    }
    
    public void waitUntilElementVisibleByXpath(String property,String name){
    	UIDriver driver = WebDriverProvider.getCurrentDriver();
    	new WebDriverWait(driver, 300)
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(property)));
    	if(browser.isElementVisibleWithXpath(property))
    	{
    		Report.updateTestLog("The "+name+" Element is found after wait","PASS");
    	}
    	else{
    		Report.updateTestLog("The "+name+" Element is not found and the wait ends","PASS");
    	}
    }
/*added for BGMO */
    	public void selectSlotByValue(String time, String date) {

		browser.selectAppointmentSlot(time, date);
	}

	public void VerifyAppointmentDate() {
		String date = browser.getText("appslot-date");
		String time = browser.getText("appslot-time");
		if (pageProperties2.getProperty("UpgradeToSmartMeter.AppointmentDate")
				.contains(date)) {
			Report.updateTestLog(" Appointment Date ", "Pass");
		} else
			Report.updateTestLog(" Appointment Date ", "Fail");
		if (pageProperties2.getProperty("UpgradeToSmartMeter.AppointmentTime")
				.contains(time)) {
			Report.updateTestLog(" Appointment Time ", "Pass");
		} else
			Report.updateTestLog(" Appointment Time ", "Fail");
	}

     public void VerifyAppointmentCancelation() {
		try {
			if (browser.isTextPresent("Cancel your booking")) {
				Report.updateTestLog(
						" Appointment Not Cancelled Successfully!!! ", "Fail");
			} else {
				Report.updateTestLog(" Appointment Cancelled Successfully!!! ",
						"Pass");
			}
		} catch (Exception e) {

		}
	}
public void selectAppointmentSlot(String time, String date) {
		browser.selectAppointmentSlot(time, date);
		Report.updateTestLog(" Appointment" + time + " &  " + date, "Done");
	}

	public void selectFirstAppointmentSlot(String link) {
		browser.clickWithLinkText(link);
		Report.updateTestLog(" First available appointment", "Done");
	}

	public void verifyTextPresent(String property, String name) {
		String ReferenceNo = browser.getTextByXpath(property);
		/*
		 * String FILE_NAME3 =
		 * "resources/bgmo_oab/booking/ServiceOrderNumber.Properties";
		 * Properties pageProperties3 = new PropertyLoader(FILE_NAME3).load();
		 */
		/*
		 * String SONumber = pageProperties3 .getProperty("ServiceOrderNumber");
		 */

		FileReader fr = null;
		String soNumber = "";
		try {
			fr = new FileReader(Sofile);
			BufferedReader br = new BufferedReader(fr);

			String[] so = br.readLine().split("=");
			soNumber = so[1];
			so = br.readLine().split("=");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// StringTokenizer str = new StringTokenizer(ReferenceNo,":");
		// String ReferenceNoVal = str.nextToken();
		// = ReferenceNoVal.trim();
		if (ReferenceNo.contains(soNumber)) {
			Report.updateTestLog(" Referenece number: " + ReferenceNo
					+ " is same as service order number: " + soNumber, "Pass");
		} else
			Report.updateTestLog(" Referenece number: " + ReferenceNo
					+ " is not same as service order number: " + soNumber,
					"Fail");
		// if
		// Report.updateTestLog(" Appointment"+time+" &  "+date, "Done");
	}
	public void verifyIsElementVisibleWithLinkText(String property, String name) {
		if (browser.isElementVisibleWithLinkText(property)) {
			Report.updateTestLog(name + " is displayed in the application ",
					"PASS");
		} else {
			Report.updateTestLog(
					name + " is not displayed in the application ", "FAIL");
		}
	}

	public void verifyIsElementNotVisibleWithLinkText(String property,
			String name) {
		if (!browser.isElementVisibleWithLinkText(property)) {
			Report.updateTestLog(
					name + " is not displayed in the application ", "PASS");
		} else {
			Report.updateTestLog(name + " is displayed in the application ",
					"FAIL");
		}
	}

	public void checkAvailableSlotsMsg(String property1, String property2) {
		browser.wait(500);

		while (true) {
			if (browser
					.isElementVisibleWithXpath(".//*[@id='noSuitableAppointmentAvailOverlay']")) {
				browser.clickWithXpath("html/body/div[3]/div[1]/a");
				Report.updateTestLog(
						" No more slots message displayed successfully ",
						"Pass");
				browser.wait(500);
				while (browser.getAttribute("prev", "class").equals("prev")) {
					browser.click("prev");
					browser.wait(500);
				}

				break;
			}
			browser.clickWithXpath(property1);
			browser.wait(500);
		}

	}

	public String getTextById(String property, String name) {
		if (browser.isElementVisible(property)) {
			Report.updateTestLog(name + " is displayed in the application "
					+ browser.getText(property), "PASS");
		} else {
			Report.updateTestLog(
					name + " is not displayed in the application ", "FAIL");
		}
		return browser.getText(property);
	}


	public void verifyFirstAvailableSlot(String property, String name) {

		Calendar c = Calendar.getInstance(); // starts with today's date and
												// time
		c.add(Calendar.DAY_OF_YEAR, 3); // advances day by 2
		Date date = c.getTime();

		String sdate = date.toString();
		if (sdate.contains("Sat")) {

			c.add(Calendar.DAY_OF_YEAR, 2);
		} else if (sdate.contains("Sun")) {
			c.add(Calendar.DAY_OF_YEAR, 1);
		}
		date = c.getTime();
		sdate = date.toString();
		String slot = browser.getTextByXpath(property);
		StringTokenizer stk = new StringTokenizer(slot);

		if (browser.isElementVisibleWithXpath(property)
				&& sdate.contains(stk.nextToken())
				&& sdate.contains(stk.nextToken())
				&& sdate.contains(stk.nextToken())) {
			Report.updateTestLog(name + slot
					+ " is displayed in the application " + date, "PASS");
		} else {
			Report.updateTestLog(name + slot
					+ " is not displayed in the application " + date, "FAIL");
		}
	}

	public void getSONumber(String soNumber, String message) {
		if (soNumber.isEmpty()) {
			// if (soNumber.contains("")) {
			Report.updateTestLog("Service order was not created due to error: "
					+ message, "Fail");
		} else {
			Report.updateTestLog(soNumber + " is created ", "Done");
		}

	}

	public void getSONumberForCancelOrReschedule1(File file) {
		String so = browser.getAttributeByCSS("a.fourth-level-link.fleft");
		StringTokenizer stk = new StringTokenizer(so, "'");
		stk.nextToken();
		so = stk.nextToken();
		Report.updateTestLog("  SO Number is :" + so, "Done");
		try {
			/*
			 * File file = new File(
			 * "BGRegressionNew/src/resources/bgmo_oab/booking/ServiceOrder.properties"
			 * );
			 */
			/*
			 * File file = new File(
			 * "/BGRegression/src/resources/bgmo_oab/booking/ServiceOrderNumber.txt"
			 * );
			 */
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write("ServiceOrderNumber = " + so);
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void verifyIsAlertVisibleWithXpath(String property, String name) {
		if (browser.isElementVisibleWithXpath(property)) {
			String webElementValue = browser.getTextByXpath(property);
			Report.updateTestLog(name + " is displayed in the application : "
					+ webElementValue, "PASS");
			browser.inputByXpath(property, "" + Keys.ESCAPE);
		} else {
			Report.updateTestLog(
					name + " is not displayed in the application ", "FAIL");
		}
	}
/*added for BGMO End*/
	
	public void getSONumberForChannelActivation(File file) {
		String so = browser.getAttributeByCSS("a.fourth-level-link.fleft");
		StringTokenizer stk = new StringTokenizer(so, "'");
		stk.nextToken();
		so = stk.nextToken();
		Report.updateTestLog("  SO Number is :" + so, "Done");
		try {
			/*
			 * File file = new File(
			 * "BGRegressionNew/src/resources/bgmo_oab/booking/ServiceOrder.properties"
			 * );
			 */
			/*
			 * File file = new File(
			 * "/BGRegression/src/resources/bgmo_oab/booking/ServiceOrderNumber.txt"
			 * );
			 */
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write("ServiceOrderNumber = " + so);
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.updateTestLog("Unable to get Service Order Number ", "Fail");
			

			//System.exit(0);
		}

	}
	
	 public void verifyAndSelectDropDownBoxbyindex(String property, int value) {
	        if (browser.isElementVisible(property)) {
	           browser.selectdropdownoptionbyindex(property,value);
	            Report.updateTestLog("User type" + " field filled with the value :"+value, "Done");
	        } else {
	            Report.updateTestLog("User type" + " field filled with the value :"+value, "FAIL");
	        }
	    }
}
