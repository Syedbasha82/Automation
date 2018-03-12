package bg.framework.app.functional.page.bgb;

import bg.framework.app.functional.action.bgb.RegistrationAction;
import bg.framework.app.functional.action.bgb.SearchInvoicesAction;
import bg.framework.app.functional.entities.RegistrationProfile;
import bg.framework.app.functional.entities.SearchInvoiceProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.RobotSendKeys;
import com.gnostice.pdfone.PdfDocument;
import com.gnostice.pdfone.PdfException;
import com.gnostice.pdfone.PdfReader;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SearchInvoicesPage extends BasePage {

    private final static String FILE_NAME = "resources/bgb/SearchInvoices.properties";

	private static Properties invoiceProperties = new PropertyLoader(FILE_NAME)
			.load();

    private RegistrationProfile registrationProfile;

    // Report report = new Report();
    // String logPath = null;

    public SearchInvoicesPage(RegistrationProfile registrationProfile) {

        this.registrationProfile = registrationProfile;
    }

    public SearchInvoicesPage() {

    }

    /*
	 * *****************************************************************************
	 * Method :enterRegisterationAccNum
	 * 
	 * 
	 * Description: This method enters Account Number.
	 * ***************************
	 * **************************************************
          */

    public void enterDetailsSearchInvoices() {

		searchInvoiceInput(registrationProfile.getSearchCriteria(),
				registrationProfile.getSearchText(),
				registrationProfile.getFromDate(),
				registrationProfile.getToDate());

    }

    public void verifyCopyInvoices() {

        if (browser.isTextPresent("Download Invoices")) {

			Report.updateTestLog(
					"Download Invoices Page is displayed correctly", "PASS");
        } else {

			Report.updateTestLog(
					"Download invoices Page  is not displayed correctly",
					"FAIL");
        }

    }

		// Field Validation With Empty Data
	public void accountManagerInvaliddataTest(int i) {
    verifySearchCriteriaDropDown();  // Validate Drop Down
		String criteria[] = { "Please select", "Account Number", "Site Number",
				"MPAN Number", "MPR Number", "Invoice Number",
				"Contract Number", "Customer Number", "Customer Name" };
		browser.selectfromDropBoxByXpath(
				invoiceProperties.getProperty("BGBSearchInv.dropdown"),
				criteria[i]);
		Report.updateTestLog("Drop Down Value:      " + criteria[i], "DONE");
		verifyAndClickWithXpath(
				invoiceProperties.getProperty("BGBSearchInv.searchbutton"),
				"Click Search Button");
    browser.wait(3000);

		switch (i) {
		    case 0:
			verifyErrorMsgSearchText1();
			verifyErrorMsgSearchText2();
			verifyErrorMsgSearchText3();
			verifyErrorMsgSearchText4();
			break;
		    case 1:
			verifyErrorMsgSearchText1();
			verifyErrorMsgSearchText2();
			verifyErrorMsgSearchText4();
		    break;
		    case 2:
			verifyErrorMsgSearchText1();
			verifyErrorMsgSearchText2();
			verifyErrorMsgSearchText4();
		    break;
		    case 3:
			verifyErrorMsgSearchText1();
			verifyErrorMsgSearchText2();
			verifyErrorMsgSearchText4();
		    break;
		    case 4:
			verifyErrorMsgSearchText1();
			verifyErrorMsgSearchText2();
			verifyErrorMsgSearchText4();
		    break;
		    case 5:
			verifyErrorMsgSearchText1();
			verifyErrorMsgSearchText2();
			verifyErrorMsgSearchText4();
		    break;
		    case 6:
			verifyErrorMsgSearchText1();
			verifyErrorMsgSearchText2();
			verifyErrorMsgSearchText4();
		    break;
		    case 7:
			verifyErrorMsgSearchText1();
			verifyErrorMsgSearchText2();
			verifyErrorMsgSearchText4();
		    break;
		    case 8:
			verifyErrorMsgSearchText1();
			verifyErrorMsgSearchText2();
		    break;
    	}

    }

	public void accountManagerInvaliddataTestNew(int i) {
		String criteria[] = { "Please select", "Account Number", "Site Number",
				"MPAN Number", "MPR Number", "Invoice Number",
				"Contract Number", "Customer Number", "Customer Name" };
		browser.selectfromDropBoxByXpath(
				invoiceProperties.getProperty("BGBSearchInv.dropdown"),
				criteria[i]);
		Report.updateTestLog("Drop Down Value:      " + criteria[i], "DONE");
		String testdata = "TEST%^5425435";
		verifyAndInputByXpath(
				invoiceProperties.getProperty("BGBSearchInv.textCategoryxpath"),
				"Enter Name or Number", testdata);
		verifyAndClick(invoiceProperties.getProperty("BGBSearchInv.searchBt"),
				"Click Search Button");
        browser.wait(9000);

		switch (i) {
	        case 0:
			verifyErrorMsgSearchText1();
			verifyErrorMsgSearchText2();
			verifyErrorMsgSearchText3();
			break;
	        case 1:
			verifyErrorMsgSearchText1();
			verifyErrorMsgSearchText2();
	        	verifyIsTextPresent("Enter name or number : Please enter a valid account number. This may start with an 'A'.");

	        break;
	        case 2:
			verifyErrorMsgSearchText1();
			verifyErrorMsgSearchText2();
	        	verifyIsTextPresent("Enter name or number : Please enter a valid site number. This may start with a 'S'.");

	        break;
	        case 3:
			verifyErrorMsgSearchText1();
			verifyErrorMsgSearchText2();
	        	verifyIsTextPresent("Enter name or number : Please enter a valid 13 digit Meter Point Administration Number.");
	        break;
	        case 4:
			verifyErrorMsgSearchText1();
			verifyErrorMsgSearchText2();
	        	verifyIsTextPresent("Enter name or number : Please enter a valid Meter Point Reference number.");
	        break;
	        case 5:
			verifyErrorMsgSearchText1();
			verifyErrorMsgSearchText2();
	        	verifyIsTextPresent("Enter name or number : Please enter a valid invoice number.");

	        break;
	        case 6:
			verifyErrorMsgSearchText1();
			verifyErrorMsgSearchText2();
	        	verifyIsTextPresent("Enter name or number : Please enter a valid contract number. This may start with a 'T'.");

	        break;
	        case 7:
			verifyErrorMsgSearchText1();
			verifyErrorMsgSearchText2();
	        	verifyIsTextPresent("Enter name or number : Please enter a valid Customer number. This may start with a 'C'.");

	        break;
	        case 8:
			verifyErrorMsgSearchText6();
			verifyErrorMsgSearchText7();
	        break;
        }
        }

	public void verifyErrorMsgSearchText1() {

		if (browser
				.isTextPresent("Sorry, we need you to look at the following areas of the form again")) {

			Report.updateTestLog(
					"Sorry, we need you to look at the following areas of the form again-Error Message available",
					"PASS");
        } else {
			Report.updateTestLog(
					"Sorry, we need you to look at the following areas of the form again-Error Message not available",
					"FAIL");
        }
    }

	public void verifyErrorMsgSearchText2() {

		if (browser
				.isTextPresent("We're missing or don't recognise some of the information in:")) {

			Report.updateTestLog(
					"We're missing or don't recognise some of the information in:-Error Message available",
					"PASS");
        } else {
			Report.updateTestLog(
					"We're missing or don't recognise some of the information in:-Error Message not available",
					"FAIL");
        }
    }

	public void verifyErrorMsgSearchText3() {

		if (browser
				.isTextPresent("Select criteria : Please select a search criteria.")) {
			Report.updateTestLog(
					"Select criteria : Please select a search criteria.-Error Message available",
					"PASS");
        } else {
			Report.updateTestLog(
					"Select criteria : Please select a search criteria.-Error Message not available",
					"FAIL");
        }

    }

	public void verifyErrorMsgSearchText4() {

		if (browser
				.isTextPresent("Enter name or number : Please enter your search criteria.")) {
			Report.updateTestLog(
					"Enter name or number : Please enter your search criteria.-Error Message available",
					"PASS");
        } else {
			Report.updateTestLog(
					"Enter name or number : Please enter your search criteria.-Error Message not available",
					"FAIL");
        }
    }

	public void verifyErrorMsgSearchText5() {

        if (browser.isTextPresent("System error")) {
            Report.updateTestLog("System error-Error Message available", "PASS");
        } else {
			Report.updateTestLog("System error-Error Message not available",
					"FAIL");
        }
    }

	public void verifyErrorMsgSearchText6() {

		if (browser
				.isTextPresent("We are sorry but there is a problem with some of the information you have submitted.")) {
			Report.updateTestLog(
					"We are sorry but there is a problem with some of the information you have submitted.-Error Message available",
					"PASS");
        } else {
			Report.updateTestLog(
					"We are sorry but there is a problem with some of the information you have submitted.-Error Message not available",
					"FAIL");
        }
    }

	public void verifyErrorMsgSearchText7() {

        if (browser.isTextPresent("Your search has returned no results.")) {
			Report.updateTestLog(
					"Your search has returned no results.-Error Message available",
					"PASS");
        } else {
			Report.updateTestLog(
					"Your search has returned no results.-Error Message not available",
					"FAIL");
        }
    }

	public void verifyErrorMsgSearchText8() {

		if (browser
				.isTextPresent("From (dd/mm/yyyy) : The date range you selected is not valid. Please ensure the 'To' date is later than the 'From' date.")) {
			Report.updateTestLog(
					"From (dd/mm/yyyy) : The date range you selected is not valid. Please ensure the 'To' date is later than the 'From' date.-Error Message available",
					"PASS");
        } else {
			Report.updateTestLog(
					"From (dd/mm/yyyy) : The date range you selected is not valid. Please ensure the 'To' date is later than the 'From' date.",
					"FAIL");
        }
    }

    public void verifySearchCriteriaDropDown() {
        List<String> searchCriteria;
		searchCriteria = browser.getFromDropBox("id",
				invoiceProperties.getProperty("BGBSearchInv.selectCategory"));
        String[] searchDropDown;
        searchDropDown = new String[9];
        searchDropDown[0] = "Please select";
        searchDropDown[1] = "Account number";
        searchDropDown[2] = "Site number";
        searchDropDown[3] = "MPAN number";
        searchDropDown[4] = "MPR number";
        searchDropDown[5] = "Invoice number";
        searchDropDown[6] = "Contract number";
        searchDropDown[7] = "Customer number";
        searchDropDown[8] = "Customer name";
        boolean flagExists = true;

        for (int x = 0; x < searchCriteria.size(); x++) {

            if (!(searchDropDown[x].equalsIgnoreCase(searchCriteria.get(x)))) {
                flagExists = false;
                break;
            }

        }
        if (flagExists) {
			Report.updateTestLog(
					"All Search critierias for invoices are displayed correctly",
					"PASS");

        } else {

			Report.updateTestLog(
					"All Search critierias for invoices are not displayed correctly",
					"FAIL");
        }

    }

    public void verifyErrorMsgSearchText() {

		if (browser
				.isTextPresent("Select Criteria : Please enter your search criteria.")) {

			Report.updateTestLog(
					"Error Message for invalid search Text is displayed correctly for copy invoice",
					"PASS");

        } else {

			Report.updateTestLog(
					"Error Message for invalid search text is not displayed correctly for copy invoice",
					"FAIL");
        }

    }

    public void enterSearchCriteria(final String searchCriteria) {

		browser.selectfromDropBox("id",
				invoiceProperties.getProperty("BGBSearchInv.selectCategory"),
				searchCriteria);
    }

    public void clearText() {
		browser.clearValue(invoiceProperties
				.getProperty("BGBSearchInv.textCategory"));
        browser.clearValue(invoiceProperties.getProperty("BGBSearchInv.toDate"));
		browser.clearValue(invoiceProperties
				.getProperty("BGBSearchInv.fromDate"));

    }

    public void enterSearchText(final String searchText) {

		browser.input(
				invoiceProperties.getProperty("BGBSearchInv.textCategory"),
				searchText);
    }

    public void enterFromDate(final String fromDate) {

		browser.input(invoiceProperties.getProperty("BGBSearchInv.fromDate"),
				fromDate);
    }

    public void enterToDate(final String toDate) {
		browser.input(invoiceProperties.getProperty("BGBSearchInv.toDate"),
				toDate);
    }

    public void clickOnSearch() {
        browser.click(invoiceProperties.getProperty("BGBSearchInv.searchBt"));
    }

    private String errorMessage() {
        String error = "no";
		error = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.refindError"));
        ArrayList<String> errorList = new ArrayList<String>();
        errorList.add(ErrorMessages.RESULT_EXCEEDED);
        errorList.add(ErrorMessages.TO_DATE_PATTERN_INVALID);
        errorList.add(ErrorMessages.TDDATE_INVALID);
        errorList.add(ErrorMessages.RESULT_NOT_FOUND);
        errorList.add(ErrorMessages.FROM_DATE_PATTERN_INVALID);
		boolean err = false;
        for (String s : errorList) {
            if (s.contains(error)) {
               Report.updateTestLog(s + " Error displayed", "PASS");
				err = false;
                break;
            }    else {
				err = true;
        }
        }
		if (err == true) {
			Report.updateTestLog("Error message is not displayed", "FAIL");
			error = "yes";
		}
        String strPIError = ErrorMessages.PI_SYSTEM_UNAVAILABLE;
        if (error.contains(strPIError)) {
            Report.updateTestLog(error + " Error displayed", "FAIL");
            error = "yes";
        }

        return error;
    }

	public void verifyResultsValidDate() {

    	 browser.wait(2000);
		int rowCount = browser.getChildElementsCountByXpath(invoiceProperties
				.getProperty("BGBSearchInv.Row"));
             if (rowCount >= 1) {
                 Report.updateTestLog("Results displayed correctly", "PASS");
			int colCount = browser
					.getChildElementsCountByXpath(invoiceProperties
							.getProperty("BGBSearchInv.Row1_th"));
                 if (colCount == 9) {
				Report.updateTestLog("All fields are displayed correctly",
						"PASS");
                 } else {
				Report.updateTestLog("All fields are not displayed correctly",
						"FAIL");
                 }
             }
    }

	public void accountNoDateSort(String fromdate, String todate) {
    			browser.wait(5000);
		String date1 = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.Row1"));
		long from = Date.parse(fromdate);
		long to = Date.parse(todate);
		long check1 = Date.parse(date1);
		if (check1 >= from && check1 <= to) {
			Report.updateTestLog(
					"Refined search Validation for date is successfully  From Date is:"
							+ fromdate + "  To Date is:  " + todate
							+ "  Difference is " + date1 + "", "PASS");
            } else {
			Report.updateTestLog(
					"Refined search Validation for date is Failure From Date is:"
							+ fromdate + "  To Date is:  " + todate
							+ "  Difference is " + date1 + "", "FAIL");
            }
    	     browser.wait(5000);
		browser.clickWithXpath(invoiceProperties
				.getProperty("BGBSearchInv.Row1_Sort"));
    	     browser.wait(1000);
		String date2 = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.Row1"));
		long check2 = Date.parse(date2);

		if (check2 <= to) {
			Report.updateTestLog(
					"Refined search Validation for date is successfully  From Date is:"
							+ fromdate + "  To Date is:  " + todate
							+ "  Difference is " + date2 + "", "PASS");
            } else {
			Report.updateTestLog(
					"Refined search Validation for date is Failure From Date is:"
							+ fromdate + "  To Date i:  " + todate
							+ "  Difference is " + date2 + "", "FAIL");
            }

   }

	public void verifyResultsInValidDate(int i, int j) {

		if (i == 2) {
			verifyErrorMsgSearchText1();
			verifyErrorMsgSearchText2();
			verifyErrorMsgSearchText8();

		} else {
			verifyErrorMsgSearchText6();
			verifyErrorMsgSearchText7();
    	}
   }

    public String verifyResults() {
        browser.wait(2000);
		final int rowCount = browser.getRowCountByXpath(invoiceProperties
				.getProperty("BGBSearchInv.tblResults"));
        String error = null;
		if (browser.isElementVisibleWithXpath(invoiceProperties
				.getProperty("BGBSearchInv.error"))) {
            error = errorMessage();
        } else {
            if (rowCount >= 1) {
				final int colCount = browser
						.getColCountByXpath(invoiceProperties
								.getProperty("BGBSearchInv.tblResults"));
                Report.updateTestLog("Results displayed correctly", "PASS");
                if (colCount == 9) {
					Report.updateTestLog("All fields are displayed correctly",
							"PASS");
                } else {
					Report.updateTestLog(
							"All fields are not displayed correctly", "FAIL");
                }
            } else {
				Report.updateTestLog("Results is not displayed correctly",
						"FAIL");
            }
            error = "no";
        }
        return error;
    }

    public SearchInvoicesAction enterDiffSearchDetailsPage(final int iteration) {
		final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(
				registrationProfile);
        searchInvoicesPage.verifyCopyInvoices();
        String searchText = null;
        switch (iteration) {
            case 0:
                searchText = "A" + registrationProfile.getSearchText();
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					searchText, registrationProfile.getFromDate(), "");
                break;
            case 1:
                searchText = "0" + registrationProfile.getSearchText();
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					searchText, registrationProfile.getFromDate(), "");
                break;
            case 2:
                searchText = " " + registrationProfile.getSearchText();
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					searchText, registrationProfile.getFromDate(), "");
                break;
            case 3:
                searchText = registrationProfile.getSearchText() + " ";
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					searchText, registrationProfile.getFromDate(), "");
                break;
            case 4:
			// Length '= 12 ' digits without the Revision no.
                final String srchText4 = registrationProfile.getSearchTextEqual12();
                final String[] srchTextNew = srchText4.split("/");
			// srchText4 = srchText4+" ";
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					srchTextNew[0], registrationProfile.getFromDate(), "");
                break;
            case 5:
			// Length '= 12 ' digits with the Revision no.
                final String srchText5 = registrationProfile.getSearchText();
			// String[] srchTextNew = srchText4.split("/");
			// srchText4 = srchText4+" ";
                // System.out.println("case 5");
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					srchText5, registrationProfile.getFromDate(), "");
                break;
            case 6:
			// Length '< 12 ' digits without the Revision no.
                final String srchText6 = registrationProfile.getSearchTextLess12();
                String[] srchTextNew1 = srchText6.split("/");
			// srchText4 = srchText4+" ";
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					srchTextNew1[0], registrationProfile.getFromDate(), "");
                break;
            case 7:
			// Length '<12 ' digits with the Revision no.
                final String srchText7 = registrationProfile.getSearchTextLess12();
			// String[] srchTextNew = srchText4.split("/");
			// srchText4 = srchText4+" ";
			// System.out.println("case 7");
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					srchText7, registrationProfile.getFromDate(), "");
                break;
            case 8:
			// Length '<12 ' digits with the Revision no.
			// String srchText8= registrationProfile.getsearchTextLess12();
                String srchText8 = " ";
			// String[] srchTextNew = srchText4.split("/");
			// srchText4 = srchText4+" ";
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					srchText8, "", "");
                break;
            case 9:
			// Length '<12 ' digits with the Revision no.
			// String srchText9= registrationProfile.getSearchText();
                String srchText9 = "%abc%";
			// String[] srchTextNew = srchText4.split("/");
			// srchText4 = srchText4+" ";
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					srchText9, registrationProfile.getFromDate(), "");
                break;
            case 11:
                searchText = "S" + registrationProfile.getSearchText();
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					searchText, registrationProfile.getFromDate(), "");
                break;
            case 12:
                searchText = "C" + registrationProfile.getSearchText();
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					searchText, registrationProfile.getFromDate(), "");
                break;

            default:
                searchText = registrationProfile.getSearchText();
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					searchText, registrationProfile.getFromDate(), "");
        }

        return new SearchInvoicesAction(registrationProfile);
    }

    public SearchInvoicesAction enterSearchDetailsPage(final int iteration) {
		final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(
				registrationProfile);
        searchInvoicesPage.verifyCopyInvoices();
        String searchText = null;
        String searchCriteria = null;
        switch (iteration) {
            case 0:
                searchText = "";
                searchCriteria = "Account Number";
			searchInvoiceInput(searchCriteria, searchText,
					registrationProfile.getFromDate(), "");
                break;
            case 1:
                searchText = "23@534";
                searchCriteria = "Account Number";
			searchInvoiceInput(searchCriteria, searchText,
					registrationProfile.getFromDate(), "");
                break;
            case 2:
                searchText = "@$2354";
                searchCriteria = "Site Number";
			searchInvoiceInput(searchCriteria, searchText,
					registrationProfile.getFromDate(), "");
                break;
            case 3:
                searchText = "@$2354";
                searchCriteria = "MPAN Number";
			searchInvoiceInput(searchCriteria, searchText,
					registrationProfile.getFromDate(), "");
                break;
            case 4:
                searchText = "345!23";
                searchCriteria = "MPR Number";
			searchInvoiceInput(searchCriteria, searchText,
					registrationProfile.getFromDate(), "");
                break;
            case 5:
                searchText = "546#56";
                searchCriteria = "Invoice Number";
			searchInvoiceInput(searchCriteria, searchText,
					registrationProfile.getFromDate(), "");
                break;
            case 6:
                searchText = "65345!23";
                searchCriteria = "Contract Number";
			searchInvoiceInput(searchCriteria, searchText,
					registrationProfile.getFromDate(), "");
                break;
            case 7:
                searchText = "erw!!34";
                searchCriteria = "Customer Number";
			searchInvoiceInput(searchCriteria, searchText,
					registrationProfile.getFromDate(), "");
                break;
            case 8:
                searchText = "this is to looooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooong name";
                searchCriteria = "Customer Name";
			searchInvoiceInput(searchCriteria, searchText,
					registrationProfile.getFromDate(), "");
                break;
            case 9:
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					registrationProfile.getSearchText(), "06/03/2012",
					"06/01/2012");
                break;
            case 10:
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					registrationProfile.getSearchText(), "06/03/2012",
					"02-04-2012");
                break;
            case 11:
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					registrationProfile.getSearchText(), "06-03-2012",
					"06/01/2012");
                break;

        }

        return new SearchInvoicesAction(registrationProfile);
    }

    public SearchInvoicesAction enterMinMaxSearchAccNo(final int iteration) {
		final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(
				registrationProfile);
        searchInvoicesPage.verifyCopyInvoices();
        String searchText = null;
        switch (iteration) {
            case 0:
                searchText = registrationProfile.getSearchText();
			String searchTextNew = searchText.substring(0, 2);
                searchTextNew = searchTextNew.trim();
			String strQuery = "Update bgb_synergy.dbo.T_account Set REF_EXT_ACCOUNT_IDENTIFIER = '"
					+ searchTextNew
					+ "' where REF_EXT_ACCOUNT_IDENTIFIER = '"
					+ searchText + "'";
                updateQuerySynergy(strQuery);

			// strQuery = "commit";
               // updateQuerySynergy(strQuery);
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					searchTextNew, registrationProfile.getFromDate(), "");
			strQuery = "Update bgb_synergy.dbo.T_account Set REF_EXT_ACCOUNT_IDENTIFIER = '"
					+ searchText
					+ "' where REF_EXT_ACCOUNT_IDENTIFIER = '"
					+ searchTextNew + "'";
                updateQuerySynergy(strQuery);
			// strQuery = "commit";
              //  updateQuerySynergy(strQuery);
                break;
            case 1:
        	searchText = registrationProfile.getSearchText();
			searchTextNew = "123456789012";
                searchTextNew = searchTextNew.trim();
			strQuery = "Update bgb_synergy.dbo.T_account Set REF_EXT_ACCOUNT_IDENTIFIER = '"
					+ searchTextNew
					+ "' where REF_EXT_ACCOUNT_IDENTIFIER = '"
					+ searchText + "'";
                updateQuerySynergy(strQuery);
			// strQuery = "commit";
              //  updateQuerySynergy(strQuery);
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					searchTextNew, registrationProfile.getFromDate(), "");
			strQuery = "Update bgb_synergy.dbo.T_account Set REF_EXT_ACCOUNT_IDENTIFIER = '"
					+ searchText
					+ "' where REF_EXT_ACCOUNT_IDENTIFIER = '"
					+ searchTextNew + "'";
              //  updateQuerySynergy(strQuery);
			// strQuery = "commit";
			// updateQuerySynergy(strQuery);
                break;

        }
        return new SearchInvoicesAction(registrationProfile);
    }

    public SearchInvoicesAction enterMinMaxSearchSiteNo(final int iteration) {
		final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(
				registrationProfile);
        searchInvoicesPage.verifyCopyInvoices();
        String searchText = null;
        switch (iteration) {
            case 0:
                searchText = registrationProfile.getSearchText();
			String searchTextNew = searchText.substring(0, 3);
			String strQuery = "Update bgb_synergy.dbo.T_site Set REF_EXT_SITE_IDENTIFIER = '"
					+ searchTextNew
					+ "' where REF_EXT_SITE_IDENTIFIER = '"
					+ searchText + "'";
                updateQuerySynergy(strQuery);
			// strQuery = "commit";
                updateQuerySynergy(strQuery);
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					searchTextNew, registrationProfile.getFromDate(), "");
			strQuery = "Update bgb_synergy.dbo.T_site Set REF_EXT_SITE_IDENTIFIER = '"
					+ searchTextNew
					+ "' where REF_EXT_SITE_IDENTIFIER = '"
					+ searchTextNew + "'";
                updateQuerySynergy(strQuery);
			// strQuery = "commit";
                updateQuerySynergy(strQuery);
                break;
            case 1:
        	searchText = registrationProfile.getSearchText();
			searchTextNew = "123456789012";
			strQuery = "Update bgb_synergy.dbo.T_site Set REF_EXT_SITE_IDENTIFIER = '"
					+ searchTextNew
					+ "' where REF_EXT_SITE_IDENTIFIER = '"
					+ searchText + "'";
                updateQuerySynergy(strQuery);
			// strQuery = "commit";
               // updateQuerySynergy(strQuery);
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					searchTextNew, registrationProfile.getFromDate(), "");
			strQuery = "Update bgb_synergy.dbo.T_site Set REF_EXT_SITE_IDENTIFIER = '"
					+ searchText
					+ "' where REF_EXT_SITE_IDENTIFIER = '"
					+ searchTextNew + "'";
                updateQuerySynergy(strQuery);
			// strQuery = "commit";
               // updateQuerySynergy(strQuery);
                break;

        }
        return new SearchInvoicesAction(registrationProfile);
    }

    public SearchInvoicesAction enterMinMaxSearchInvoiceNo(final int iteration) {
		final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(
				registrationProfile);
        searchInvoicesPage.verifyCopyInvoices();
        String searchText = null;
        switch (iteration) {
            case 0:
                searchText = registrationProfile.getSearchText();
			String searchTextNew = searchText.substring(0, 1);
			String strQuery = "Update bgb_synergy.dbo.T_Invoice Set REF_EXT_Invoice_IDENTIFIER = '"
					+ searchTextNew
					+ "' where REF_EXT_Invoice_IDENTIFIER = '"
					+ searchText + "'";
                updateQuerySynergy(strQuery);
			// strQuery = "commit";
               // updateQuerySynergy(strQuery);
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					searchTextNew, registrationProfile.getFromDate(), "");
			strQuery = "Update bgb_synergy.dbo.T_Invoice Set REF_EXT_Invoice_IDENTIFIER = '"
					+ searchText
					+ "' where REF_EXT_Invoice_IDENTIFIER = '"
					+ searchTextNew + "'";
                updateQuerySynergy(strQuery);
			// strQuery = "commit";
                updateQuerySynergy(strQuery);
                break;
            case 1:
        	searchText = registrationProfile.getSearchText();
			searchTextNew = "123456789012";
			strQuery = "Update bgb_synergy.dbo.T_Invoice Set REF_EXT_Invoice_IDENTIFIER = '"
					+ searchTextNew
					+ "' where REF_EXT_Invoice_IDENTIFIER = '"
					+ searchText + "'";
                updateQuerySynergy(strQuery);
			// strQuery = "commit";
               // updateQuerySynergy(strQuery);
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					searchTextNew, registrationProfile.getFromDate(), "");
			strQuery = "Update bgb_synergy.dbo.T_Invoice Set REF_EXT_Invoice_IDENTIFIER = '"
					+ searchText
					+ "' where REF_EXT_Invoice_IDENTIFIER = '"
					+ searchTextNew + "'";
                updateQuerySynergy(strQuery);
			// strQuery = "commit";
               // updateQuerySynergy(strQuery);
                break;

        }
        return new SearchInvoicesAction(registrationProfile);
    }

    public SearchInvoicesAction enterMinMaxSearchContractNo(final int iteration) {
		final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(
				registrationProfile);
        searchInvoicesPage.verifyCopyInvoices();
        String searchText = null;
        switch (iteration) {
            case 0:
                searchText = registrationProfile.getSearchText();
			String searchTextNew = searchText.substring(0, 1);
			String strQuery = "Update bgb_synergy.dbo.T_Contract Set REF_EXT_Contract_IDENTIFIER = '"
					+ searchTextNew
					+ "' where REF_EXT_Contract_IDENTIFIER = '"
					+ searchText + "'";
                updateQuerySynergy(strQuery);
			// strQuery = "commit";
               // updateQuerySynergy(strQuery);
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					searchTextNew, registrationProfile.getFromDate(), "");
			strQuery = "Update bgb_synergy.dbo.T_Contract Set REF_EXT_Contract_IDENTIFIER = '"
					+ searchText
					+ "' where REF_EXT_Contract_IDENTIFIER = '"
					+ searchTextNew + "'";
                updateQuerySynergy(strQuery);
			// strQuery = "commit";
			// // updateQuerySynergy(strQuery);
                break;
            case 1:
        	searchText = registrationProfile.getSearchText();
			searchTextNew = "123456789012";
			strQuery = "Update bgb_synergy.dbo.T_Contract Set REF_EXT_Contract_IDENTIFIER = '"
					+ searchTextNew
					+ "' where REF_EXT_Contract_IDENTIFIER = '"
					+ searchText + "'";
                updateQuerySynergy(strQuery);
			// strQuery = "commit";
			// updateQuerySynergy(strQuery);
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					searchTextNew, registrationProfile.getFromDate(), "");
			strQuery = "Update bgb_synergy.dbo.T_Contract Set REF_EXT_Contract_IDENTIFIER = '"
					+ searchText
					+ "' where REF_EXT_Contract_IDENTIFIER = '"
					+ searchTextNew + "'";
                updateQuerySynergy(strQuery);
			// strQuery = "commit";
			// updateQuerySynergy(strQuery);
                break;

        }
        return new SearchInvoicesAction(registrationProfile);
    }

    public SearchInvoicesAction enterMinMaxSearchCustNo(final int iteration) {
		final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(
				registrationProfile);
        searchInvoicesPage.verifyCopyInvoices();
        String searchText = null;
        switch (iteration) {
            case 0:
                searchText = registrationProfile.getSearchText();
			String searchTextNew = searchText.substring(0, 2);
			String strQuery = "Update bgb_synergy.dbo.T_Customer Set REF_EXT_Customer_IDENTIFIER = '"
					+ searchTextNew
					+ "' where REF_EXT_Customer_IDENTIFIER = '"
					+ searchText + "'";
                updateQuerySynergy(strQuery);
			// strQuery = "commit";
			// updateQuerySynergy(strQuery);
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					searchTextNew, registrationProfile.getFromDate(), "");
			strQuery = "Update bgb_synergy.dbo.T_Customer Set REF_EXT_Customer_IDENTIFIER = '"
					+ searchText
					+ "' where REF_EXT_Customer_IDENTIFIER = '"
					+ searchTextNew + "'";
                updateQuerySynergy(strQuery);
			// strQuery = "commit";
               // updateQuerySynergy(strQuery);
                break;
            case 1:
        	searchText = registrationProfile.getSearchText();
			searchTextNew = "123456789012";
			strQuery = "Update bgb_synergy.dbo.T_Customer Set REF_EXT_Customer_IDENTIFIER = '"
					+ searchTextNew
					+ "' where REF_EXT_Customer_IDENTIFIER = '"
					+ searchText + "'";
                updateQuerySynergy(strQuery);
			// strQuery = "commit";
               // updateQuerySynergy(strQuery);
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					searchTextNew, registrationProfile.getFromDate(), "");
			strQuery = "Update bgb_synergy.dbo.T_Customer Set REF_EXT_Customer_IDENTIFIER = '"
					+ searchText
					+ "' where REF_EXT_Customer_IDENTIFIER = '"
					+ searchTextNew + "'";
                updateQuerySynergy(strQuery);
			// strQuery = "commit";
               // updateQuerySynergy(strQuery);
                break;

        }
        return new SearchInvoicesAction(registrationProfile);
    }

    public SearchInvoicesAction enterMinMaxSearchCustName(final int iteration) {
		final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(
				registrationProfile);
        searchInvoicesPage.verifyCopyInvoices();
        String searchText = null;
        switch (iteration) {
            case 0:
                searchText = registrationProfile.getSearchText();
			String searchTextNew = searchText.substring(0, 1);
			String strQuery = "Update bgb_synergy.dbo.T_Customer Set TXT_CUSTOMER_NAME = '"
					+ searchTextNew
					+ "' where TXT_CUSTOMER_NAME = '"
					+ searchText + "'";
                updateQuerySynergy(strQuery);
			// strQuery = "commit";
               // updateQuerySynergy(strQuery);
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					searchTextNew, registrationProfile.getFromDate(), "");
			strQuery = "Update bgb_synergy.dbo.T_Customer Set TXT_CUSTOMER_NAME = '"
					+ searchText
					+ "' where TXT_CUSTOMER_NAME = '"
					+ searchTextNew + "'";
                updateQuerySynergy(strQuery);
			// strQuery = "commit";
               // updateQuerySynergy(strQuery);
                break;
            case 1:
        	searchText = registrationProfile.getSearchText();
			searchTextNew = "customernamewith54523452sfsdfffffsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr";
			strQuery = "Update bgb_synergy.dbo.T_Customer Set TXT_CUSTOMER_NAME = '"
					+ searchTextNew
					+ "' where TXT_CUSTOMER_NAME = '"
					+ searchText + "'";
                updateQuerySynergy(strQuery);
			// strQuery = "commit";
               // updateQuerySynergy(strQuery);
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					searchTextNew, registrationProfile.getFromDate(), "");
			strQuery = "Update bgb_synergy.dbo.T_Customer Set TXT_CUSTOMER_NAME = '"
					+ searchText
					+ "' where TXT_CUSTOMER_NAME = '"
					+ searchTextNew + "'";
                updateQuerySynergy(strQuery);
			// strQuery = "commit";
               // updateQuerySynergy(strQuery);
                break;

        }
        return new SearchInvoicesAction(registrationProfile);
    }

	// to be updated
    public SearchInvoicesAction enterMinMaxSearchMPANNo(final int iteration) {
		final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(
				registrationProfile);
        searchInvoicesPage.verifyCopyInvoices();
        String searchText = null;
        switch (iteration) {
            case 0:
                searchText = registrationProfile.getSearchText();
			String searchTextNew = "1234567890123";
			String strQuery = "Update bgb_synergy.dbo.T_Meter Set TXT_MPXN = '"
					+ searchTextNew + "' where TXT_MPXN = '" + searchText + "'";
                updateQuerySynergy(strQuery);
			// strQuery = "commit";
               // updateQuerySynergy(strQuery);
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					searchTextNew, registrationProfile.getFromDate(), "");
			strQuery = "Update bgb_synergy.dbo.T_Meter Set TXT_MPXN = '"
					+ searchText + "' where TXT_MPXN = '" + searchTextNew + "'";
                updateQuerySynergy(strQuery);
			// strQuery = "commit";
			// updateQuerySynergy(strQuery);
                break;

        }
        return new SearchInvoicesAction(registrationProfile);
    }

    public SearchInvoicesAction enterMinMaxSearchMPRNNo(final int iteration) {
		final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(
				registrationProfile);
        searchInvoicesPage.verifyCopyInvoices();
        String searchText = null;
        switch (iteration) {
            case 0:
                searchText = registrationProfile.getSearchText();
			String searchTextNew = "12";
			String strQuery = "Update bgb_synergy.dbo.T_Meter Set TXT_MPXN = '"
					+ searchTextNew + "' where TXT_MPXN = '" + searchText;
                updateQuerySynergy(strQuery);
			// strQuery = "commit";
               // updateQuerySynergy(strQuery);
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					searchText, registrationProfile.getFromDate(), "");
			strQuery = "Update bgb_synergy.dbo.T_Meter Set TXT_MPXN = '"
					+ searchText + "' where TXT_MPXN = '" + searchTextNew + "'";
                updateQuerySynergy(strQuery);
			// strQuery = "commit";
			// updateQuerySynergy(strQuery);
                break;
            case 1:
                searchText = registrationProfile.getSearchText();
			searchTextNew = "123456789012";
			strQuery = "Update T_Meter Set TXT_MPXN = '" + searchTextNew
					+ "' where TXT_MPXN = '" + searchText;
                updateQuerySynergy(strQuery);
			// //strQuery = "commit";
			// updateQuerySynergy(strQuery);
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					searchText, registrationProfile.getFromDate(), "");
			strQuery = "Update T_Meter Set TXT_MPXN = '" + searchText
					+ "' where TXT_MPXN = '" + searchTextNew + "'";
                updateQuerySynergy(strQuery);
			// //strQuery = "commit";
			// updateQuerySynergy(strQuery);
                break;

        }
        return new SearchInvoicesAction(registrationProfile);
    }

    public SearchInvoicesAction verifyInvoiceErrorMsg(final int iteration) {
		// final SearchInvoicesPage searchInvoicesPage = new
		// SearchInvoicesPage(registrationProfile);
        String strText = null;
        String error = null;
		error = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.refindError"));

        switch (iteration) {
            case 0:
                strText = ErrorMessages.TEXT_MANDATORY;
                if (error.contains(strText)) {
				Report.updateTestLog("Error Text " + strText
						+ " displayed correctly", "PASS");
                } else {
				Report.updateTestLog("Error Text " + strText
						+ " not displayed correctly", "FAIL");
                }
                break;
            case 1:
                strText = ErrorMessages.ACCOUNT_NO_INVALID;
                if (error.contains(strText)) {
				Report.updateTestLog("Error Text " + strText
						+ " displayed correctly", "PASS");
                } else {
				Report.updateTestLog("Error Text " + strText
						+ " not displayed correctly", "FAIL");
                }
                break;
            case 2:
                strText = ErrorMessages.SITE_NO_INVALID;
                if (error.contains(strText)) {
				Report.updateTestLog("Error Text " + strText
						+ " displayed correctly", "PASS");
                } else {
				Report.updateTestLog("Error Text " + strText
						+ " not displayed correctly", "FAIL");
                }
                break;
            case 3:
                strText = ErrorMessages.MPAN_INVALID;
                if (error.contains(strText)) {
				Report.updateTestLog("Error Text " + strText
						+ " displayed correctly", "PASS");
                } else {
				Report.updateTestLog("Error Text " + strText
						+ " not displayed correctly", "FAIL");
                }
                break;
            case 4:
                strText = ErrorMessages.MPRN_INVALID;
                if (error.contains(strText)) {
				Report.updateTestLog("Error Text " + strText
						+ " displayed correctly", "PASS");
                } else {
				Report.updateTestLog("Error Text " + strText
						+ " not displayed correctly", "FAIL");
                }
                break;
            case 5:
                strText = ErrorMessages.INVOICE_NO_INVALID;
                if (error.contains(strText)) {
				Report.updateTestLog("Error Text " + strText
						+ " displayed correctly", "PASS");
                } else {
				Report.updateTestLog("Error Text " + strText
						+ " not displayed correctly", "FAIL");
                }
                break;
            case 6:
                strText = ErrorMessages.CONTRACT_NO_INVALID;
                if (error.contains(strText)) {
				Report.updateTestLog("Error Text " + strText
						+ " displayed correctly", "PASS");
                } else {
				Report.updateTestLog("Error Text " + strText
						+ " not displayed correctly", "FAIL");
                }
                break;
            case 7:
                strText = ErrorMessages.CUSTOMER_NO_INVALID;
                if (error.contains(strText)) {
				Report.updateTestLog("Error Text " + strText
						+ " displayed correctly", "PASS");
                } else {
				Report.updateTestLog("Error Text " + strText
						+ " not displayed correctly", "FAIL");
                }
                break;
            case 8:
                strText = ErrorMessages.CUSTOMER_NAME_INVALID;
                if (error.contains(strText)) {
				Report.updateTestLog("Error Text " + strText
						+ " displayed correctly", "PASS");
                } else {
				Report.updateTestLog("Error Text " + strText
						+ " not displayed correctly", "FAIL");
                }
                break;
            case 9:
                strText = ErrorMessages.TDDATE_INVALID;
                if (error.contains(strText)) {
				Report.updateTestLog("Error Text " + strText
						+ " displayed correctly", "PASS");
                } else {
				Report.updateTestLog("Error Text " + strText
						+ " not displayed correctly", "FAIL");
                }
                break;
            case 10:
                strText = ErrorMessages.TO_DATE_PATTERN_INVALID;
                if (error.contains(strText)) {
				Report.updateTestLog("Error Text " + strText
						+ " displayed correctly", "PASS");
                } else {
				Report.updateTestLog("Error Text " + strText
						+ " not displayed correctly", "FAIL");
                }
                break;
            case 11:
                strText = ErrorMessages.FROM_DATE_PATTERN_INVALID;
                if (error.contains(strText)) {
				Report.updateTestLog("Error Text " + strText
						+ " displayed correctly", "PASS");
                } else {
				Report.updateTestLog("Error Text " + strText
						+ " not displayed correctly", "FAIL");
                }
                break;
        }
        return new SearchInvoicesAction(registrationProfile);
    }

	// to verify download invoice error msg without selecting the invoice
    public SearchInvoicesAction verifyErrorMsgSelect() {
        String strText;
        String error = null;
		error = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.refindError"));
        strText = ErrorMessages.SELECT_MANDATORY;
        if (error.contains(strText)) {
			Report.updateTestLog("Error Text " + strText
					+ " displayed correctly", "PASS");
        } else {
			Report.updateTestLog("Error Text " + strText
					+ " not displayed correctly", "FAIL");
        }
        return new SearchInvoicesAction(registrationProfile);
    }

    public String getTableSearchText() {
        String invoiceNoSearch = "";
        if (registrationProfile.getSearchText().contains("/")) {
            String invoiceNo[] = registrationProfile.getSearchText().split("/");
			invoiceNoSearch = "INV.REF_EXT_INVOICE_NUMBER='" + invoiceNo[0]
					+ "'";
			// invoiceNoSearch="INV.REF_EXT_INVOICE_NUMBER='"
			// +invoiceNo[0]+"' AND INV.REF_EXT_INVOICE_REVISION="
			// +invoiceNo[1];
        } else {
			invoiceNoSearch = "INV.REF_EXT_INVOICE_NUMBER='"
					+ registrationProfile.getSearchText() + "'";
        }
		String accountNoSearch = "Acc.REF_EXT_ACCOUNT_IDENTIFIER="
				+ registrationProfile.getSearchText();
		String siteNoSearch = "Site.REF_EXT_SITE_IDENTIFIER="
				+ registrationProfile.getSearchText();
		String customerNoSearch = "Cust.REF_EXT_CUSTOMER_IDENTIFIER="
				+ registrationProfile.getSearchText();
		String customerNameSearch = "Cust.TXT_CUSTOMER_NAME='"
				+ registrationProfile.getSearchText().replace("'", "''") + "'";

		String contractNoSearch = "Cont.REF_EXT_CONTRACT_IDENTIFIER="
				+ registrationProfile.getSearchText();
		String mpanSearch = "Mtr.TXT_MPXN='"
				+ registrationProfile.getSearchText() + "'";
		String mprSearch = "Mtr.TXT_MPXN='"
				+ registrationProfile.getSearchText() + "'";
        String tableSearchText = null;
        if (registrationProfile.getSearchCriteria().equals("Account Number")) {
            tableSearchText = accountNoSearch;
        }
        if (registrationProfile.getSearchCriteria().equals("Site Number")) {
            tableSearchText = siteNoSearch;
        }
        if (registrationProfile.getSearchCriteria().equals("Customer Number")) {
            tableSearchText = customerNoSearch;
        }
        if (registrationProfile.getSearchCriteria().equals("Customer Name")) {
            tableSearchText = customerNameSearch;
        }
        if (registrationProfile.getSearchCriteria().equals("Invoice Number")) {
            tableSearchText = invoiceNoSearch;
        }
        if (registrationProfile.getSearchCriteria().equals("MPAN Number")) {
            tableSearchText = mpanSearch;
        }
        if (registrationProfile.getSearchCriteria().equals("MPR Number")) {
            tableSearchText = mprSearch;
        }
        if (registrationProfile.getSearchCriteria().equals("Contract Number")) {
            tableSearchText = contractNoSearch;
        }
        return tableSearchText;
    }

    public void refindSearchDatePage(String tableSearchText) {
        String[] to_date = new String[3];
        String[] from_date = new String[3];
		from_date[0] = " "; // step 1
		from_date[1] = registrationProfile.getFromDate(); // step 2
		from_date[2] = " "; // step 3

		to_date[0] = " "; // step 1
		to_date[1] = " "; // step 2
		to_date[2] = currentDate(); // step 3

        for (int i = 0; i < 3; i++) {
            browser.wait(7000);
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					registrationProfile.getSearchText(), from_date[i],
					to_date[i]);
            String skip = verifyResults();
            if (skip.equals("yes")) {
                continue;
            }
			verifyDb(from_date[i], to_date[i], i, tableSearchText);

        }
    }

	public void verifyDb(String fromDate, String toDate, int iteration,
			String tableSearchText) {

        String currentDate = currentDate();
        String searchText = registrationProfile.getSearchCriteria();

		String one = "AND (INV.DT_INVOICE BETWEEN DATEADD(M,-12,'"
				+ currentDate + "') and '" + currentDate + "')";
        String two = "AND (INV.DT_INVOICE >= '" + fromDate + "')";
		String three = "AND (INV.DT_INVOICE BETWEEN DATEADD(M,-12,'"
				+ currentDate + "') and '" + toDate + "')";
        String sqlQuery = " ";
        String query = " ";
        String broker_query = " ";
		String broker_check = "SELECT [IND_BROKER] FROM [BGB_Synergy].[dbo].[T_ONLINE_USER] where TXT_ONLINE_USER_NAME = '"
				+ registrationProfile.getEmail() + "'";
        int broker = executeQuerySynergy(broker_check);
        if (broker == 0) {
			broker_query = " AND ((UserAcc.ContractDate BETWEEN DATEADD(M,-6, '"
					+ currentDate
					+ "') AND '"
					+ currentDate
					+ "') OR"
                    + " UserAcc.ContractDate >= '" + currentDate + "')";
        } else {
            broker_query = "AND UserAcc.LOA_Date >= '" + currentDate + "'";
        }

		if (searchText.equals("Account Number")
				|| searchText.equals("Site Number")
				|| searchText.equals("Customer Name")
				|| searchText.equals("Customer Number")
				|| searchText.equals("Invoice Number")) {
            query = "set dateformat dmy SELECT count(*)"
                    + " FROM BGB_synergy.dbo.T_INVOICE (NOLOCK) INV INNER JOIN BGB_synergy.dbo.T_Account (NOLOCK) Acc"
                    + " ON INV.FK_ID_ACCOUNT = Acc.ID_ACCOUNT "
                    + " AND Acc.IND_ACTIVE_STATUS ='Y' "
                    + " INNER JOIN BGB_synergy.dbo.T_SITE (NOLOCK) Site "
                    + " ON INV.FK_ID_SITE = Site.ID_SITE "
                    + " and Site.IND_ACTIVE_STATUS ='Y' "
                    + " INNER JOIN (SELECT Account,Broker,Source,BusinessSegment,ContractDate,LOA_Date "
					+ " FROM BGB_synergy.[PI_Reporting].[udf_GetAllUserAccountsByUserName]('"
					+ registrationProfile.getEmail() + "')) UserAcc"
                    + " ON Acc.REF_EXT_ACCOUNT_IDENTIFIER = UserAcc.Account "
                    + " AND UserAcc.[Source] = Acc.CD_EXT_ACCOUNT_SYSTEM"
                    + " INNER JOIN BGB_synergy.dbo.T_Customer (NOLOCK) Cust"
                    + " ON Cust.ID_CUSTOMER = Acc.FK_ID_CUSTOMER"
                    + " and Cust.IND_ACTIVE_STATUS ='Y'"
					+ " AND Cust.FK_CD_CUSTOMER_SEGMENT = 'MS'" + " WHERE "
					+ tableSearchText + " " + broker_query;
        }
        if (searchText.equals("MPAN Number") || searchText.equals("MPR Number")) {
            query = "set dateformat dmy SELECT count(*) FROM BGB_SYNERGY.dbo.T_INVOICE (NOLOCK) INV "
                    + "INNER JOIN BGB_SYNERGY.dbo.T_Account (NOLOCK) Acc "
                    + "ON INV.FK_ID_ACCOUNT = Acc.ID_ACCOUNT AND Acc.IND_ACTIVE_STATUS ='Y' "
                    + "INNER JOIN BGB_SYNERGY.dbo.T_SITE (NOLOCK) Site "
                    + "ON INV.FK_ID_SITE = Site.ID_SITE and Site.IND_ACTIVE_STATUS ='Y' "
                    + "INNER JOIN (SELECT Account,Broker,Source,BusinessSegment,ContractDate,LOA_Date "
					+ "FROM BGB_SYNERGY.[PI_Reporting].[udf_GetAllUserAccountsByUserName]('"
					+ registrationProfile.getEmail()
					+ "')) "
                    + "UserAcc ON Acc.REF_EXT_ACCOUNT_IDENTIFIER = UserAcc.Account	AND "
                    + "UserAcc.[Source] = Acc.CD_EXT_ACCOUNT_SYSTEM INNER JOIN BGB_SYNERGY.dbo.T_Customer (NOLOCK) Cust "
                    + "ON Cust.ID_CUSTOMER = Acc.FK_ID_CUSTOMER and Cust.IND_ACTIVE_STATUS ='Y' "
                    + "AND Cust.FK_CD_CUSTOMER_SEGMENT = 'MS' INNER JOIN BGB_SYNERGY.dbo.T_METER (NOLOCK) Mtr "
                    + "ON Mtr.FK_ID_SITE = Site.ID_SITE AND Mtr.IND_ACTIVE_STATUS = 'Y' "
                    + "WHERE " + tableSearchText + " " + broker_query;

        }

        if (searchText.equals("Contract Number")) {
            query = "set dateformat dmy SELECT count(*) FROM BGB_SYNERGY.dbo.T_INVOICE (NOLOCK) INV "
                    + "INNER JOIN BGB_SYNERGY.dbo.T_Account (NOLOCK) Acc ON INV.FK_ID_ACCOUNT = Acc.ID_ACCOUNT "
                    + "AND Acc.IND_ACTIVE_STATUS ='Y' INNER JOIN BGB_SYNERGY.dbo.T_SITE (NOLOCK) Site "
                    + "ON INV.FK_ID_SITE = Site.ID_SITE and Site.IND_ACTIVE_STATUS ='Y' "
                    + "INNER JOIN (SELECT Account,Broker,Source,BusinessSegment,ContractDate,LOA_Date "
					+ "FROM BGB_SYNERGY.[PI_Reporting].[udf_GetAllUserAccountsByUserName]('"
					+ registrationProfile.getEmail()
					+ "')) UserAcc "
                    + "ON Acc.REF_EXT_ACCOUNT_IDENTIFIER = UserAcc.Account AND UserAcc.[Source] = Acc.CD_EXT_ACCOUNT_SYSTEM "
                    + "INNER JOIN BGB_SYNERGY.dbo.T_Customer (NOLOCK) Cust ON Cust.ID_CUSTOMER = Acc.FK_ID_CUSTOMER "
                    + "and Cust.IND_ACTIVE_STATUS ='Y' AND Cust.FK_CD_CUSTOMER_SEGMENT = 'MS' "
                    + "INNER JOIN BGB_SYNERGY.dbo.T_CONTRACT_SITE (NOLOCK) ContSite ON ContSite.FK_ID_ACCOUNT = Acc.ID_ACCOUNT "
                    + "AND ContSite.FK_ID_SITE = Site.ID_SITE INNER JOIN BGB_SYNERGY.dbo.T_CONTRACT (NOLOCK) Cont "
                    + "ON ContSite.FK_ID_CONTRACT = Cont.ID_CONTRACT AND Cont.IND_ACTIVE_STATUS = 'Y' "
                    + "WHERE " + tableSearchText + " " + broker_query;
        }
        String report = "Database verification";
        if (iteration == 0) {
            sqlQuery = query + one;
            report = "Database verification- From Date and To Date blank";
        }
        if (iteration == 1) {
            sqlQuery = query + two;
            report = "Database verification- To Date Blank";
        }
        if (iteration == 2) {
            sqlQuery = query + three;
            report = "Database verification- From Date Blank";
        }

        int rowCount = executeQuerySynergy(sqlQuery);
        int totalResultInPage = totalRowsRetrived();
        if (rowCount == totalResultInPage) {
            Report.updateTestLog(report + " Successfull", "PASS");
        } else {
            Report.updateTestLog(report + " Un successfull", "FAIL");
        }

    }

    private static int executeQuerySynergy(String query) {
        int count = 0;
        Connection conn;
        Statement statement;
        ResultSet resultSet;
        String connectionString = "jdbc:sqlserver://wycvwappx040;user=MSOnline-developers;password=Slamm$R@ge";
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionString);
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return count;
    }

    private static void updateQuerySynergy(String query) {
        int count = 0;
        Connection conn;
        Statement statement;
        ResultSet resultSet;
        String connectionString = "jdbc:sqlserver://wycvwappx040;user=MSOnline-developers;password=Slamm$R@ge";
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionString);
            statement = conn.createStatement();
           // statement.executeQuery(query);
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
		// return count;
    }

	public RegistrationAction accountmanagerdetails() {

		String firstname = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.fname"));
		String surname = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.sname"));
		String email = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.email"));

		String str = "select count(*) from BGB_Synergy.dbo.T_EMployee where TXT_EMPLOYEE_FIRST_NAME='"
				+ firstname
				+ "' AND TXT_EMPLOYEE_EMAIL_ADDRESS='"
				+ email
				+ "' AND TXT_EMPLOYEE_SURNAME='" + surname + "'";
        int regRowCount = executeQuerySynergy(str);
		if (regRowCount >= 1) {
			Report.updateTestLog("FIrst Name:   " + firstname
					+ " and Sur name:  " + surname + " and Email Address:    "
					+ email + " available in the DB", "PASS");
		} else {
			Report.updateTestLog("FIrst Name:   " + firstname
					+ " and Sur name:  " + surname + " and Email Address:    "
					+ email + " not available in the DB", "FAIL");

        }

		return null;
    }

	public RegistrationAction dbViewCount(String rowtext1, String email) {

		String mail = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.email"));
		String MAIL = mail.trim();
		String strQuery_Status = "select count(*) from bgb_synergy.dbo.T_ONLINE_USER where TXT_ONLINE_USER_NAME = '"
				+ MAIL + "' and ind_broker=1";
    	 int regRowCount_Status = executeQuerySynergy(strQuery_Status);

		if (regRowCount_Status == 1)
    	 {
			String RC = rowtext1.trim();
			String strQuery = "with temp1 as(SELECT"
					+ "                     Usr.TXT_ONLINE_USER_NAME,"
					+ "                     Vw.TXT_ONLINE_VIEW_NAME,"
					+ "                     TAcc.ref_ext_account_identifier"
					+ "      FROM "
					+ "                     BGB_Synergy.dbo.T_ONLINE_USER Usr (NOLOCK)"
					+ "                     INNER JOIN BGB_Synergy.dbo.T_ONLINE_VIEW_USER VwUsr (NOLOCK) ON Usr.ID_ONLINE_USER = VwUsr.FK_ID_ONLINE_USER "
					+ "                     INNER JOIN BGB_Synergy.dbo.T_ONLINE_VIEW Vw (NOLOCK) ON VwUsr.FK_ID_ONLINE_VIEW = Vw.ID_ONLINE_VIEW "
					+ "                     INNER JOIN BGB_Synergy.dbo.T_ONLINE_VIEW_ACCOUNT  VwAcc (NOLOCK) ON Vw.ID_ONLINE_VIEW = VwAcc.FK_ID_ONLINE_VIEW "
					+ "                     INNER JOIN BGB_Synergy.dbo.T_Account TAcc (NOLOCK) ON VwAcc.FK_ID_ACCOUNT = TAcc.ID_ACCOUNT "
					+ "                     INNER JOIN BGB_Synergy.dbo.T_CONTRACT cont (NOLOCK) ON VwAcc.FK_ID_CONTRACT = cont.ID_CONTRACT "
					+ "                     INNER JOIN BGB_Synergy.dbo.T_Customer CU (NOLOCK) ON CU.ID_CUSTOMER = TAcc.FK_ID_CUSTOMER "
					+ "      WHERE "
					+ "                     Vw.IND_ACTIVE = 1"
					+ "                     AND VwAcc.IND_ACTIVE = 1 "
					+ "                     AND ISNULL(VwUsr.IsDeleted,0) = 0"
					+ "                     AND ISNULL(VwAcc.IsDeleted,0) = 0"
					+ "                     AND TAcc.IND_ACTIVE_STATUS = 'Y'"
					+ "                     AND Usr.TXT_ONLINE_USER_NAME = '"
					+ MAIL
					+ "'"
					+ "                     and Vw.TXT_ONLINE_VIEW_NAME='"
					+ rowtext1
					+ "'"
					+ "                     and Vwacc.DT_LOA_END >= CAST(GETDATE() AS DATE)) select count(*) from temp1";

        int regRowCount = executeQuerySynergy(strQuery);
			// int finaltest2=Integer.parseInt(final_test1);
			// String ROWCOUNT=new Integer(regRowCount).toString();

			if (regRowCount >= 1) {
				Report.updateTestLog("Views Name available in DB: " + rowtext1
						+ "", "PASS");

        } else {
				Report.updateTestLog("Views Name not available in DB_1: "
						+ rowtext1 + "", "FAIL");
        }
		} else {
			String RC = rowtext1.trim();
			String strQuery = "with temp1 as(SELECT"
					+ "                               Usr.TXT_ONLINE_USER_NAME,"
					+ "                               Vw.TXT_ONLINE_VIEW_NAME,"
					+ "                               Count (Vw.TXT_ONLINE_VIEW_NAME) as accnos"
					+ "                FROM "
					+ "                               BGB_Synergy.dbo.T_ONLINE_USER Usr (NOLOCK)"
					+ "                               INNER JOIN BGB_Synergy.dbo.T_ONLINE_VIEW_USER VwUsr (NOLOCK) ON Usr.ID_ONLINE_USER = VwUsr.FK_ID_ONLINE_USER "
					+ "                               INNER JOIN BGB_Synergy.dbo.T_ONLINE_VIEW Vw (NOLOCK) ON VwUsr.FK_ID_ONLINE_VIEW = Vw.ID_ONLINE_VIEW "
					+ "                               INNER JOIN BGB_Synergy.dbo.T_ONLINE_VIEW_ACCOUNT  VwAcc (NOLOCK) ON Vw.ID_ONLINE_VIEW = VwAcc.FK_ID_ONLINE_VIEW "
					+ "                               INNER JOIN BGB_Synergy.dbo.T_Account TAcc (NOLOCK) ON VwAcc.FK_ID_ACCOUNT = TAcc.ID_ACCOUNT "
					+ "                               INNER JOIN BGB_Synergy.dbo.T_CONTRACT cont (NOLOCK) ON VwAcc.FK_ID_CONTRACT = cont.ID_CONTRACT "
					+ "                               INNER JOIN BGB_Synergy.dbo.T_Customer CU (NOLOCK) ON CU.ID_CUSTOMER = TAcc.FK_ID_CUSTOMER "
					+ "                WHERE "
					+ "                               Vw.IND_ACTIVE = 1"
					+ "                               AND VwAcc.IND_ACTIVE = 1 "
					+ "                               AND ISNULL(VwUsr.IsDeleted,0) = 0"
					+ "                               AND ISNULL(VwAcc.IsDeleted,0) = 0"
					+ "                               AND TAcc.IND_ACTIVE_STATUS = 'Y'"
					+ "                               AND Usr.TXT_ONLINE_USER_NAME = '"
					+ MAIL
					+ "'"
					+ "                               AND Vw.TXT_ONLINE_VIEW_NAME= '"
					+ RC
					+ "'"
					+ "               GROUP BY"
					+ "								Usr.TXT_ONLINE_USER_NAME,"
					+ "								Vw.TXT_ONLINE_VIEW_NAME"
					+ "                 HAVING MAX(cont.DT_CONTRACT_END) >= CAST(GETDATE() AS DATE) OR MAX(cont.DT_CONTRACT_END) >= DATEADD(MM,-6,CAST(GETDATE() AS DATE)))select count(*) from temp1";

            int regRowCount = executeQuerySynergy(strQuery);

			if (regRowCount >= 1) {
				Report.updateTestLog("Views Name available in DB: " + rowtext1
						+ "", "PASS");

            } else {
				Report.updateTestLog("Views Name not available in DB_1: "
						+ rowtext1 + "", "FAIL");
            }

        }

        return new RegistrationAction();
    }

	public RegistrationAction dbViewCountAccount(String rowtext1, String test3) {
		String mail = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.email"));
		String MAIL = mail.trim();
		String strQuery_Status = "select count(*) from bgb_synergy.dbo.T_ONLINE_USER where TXT_ONLINE_USER_NAME = '"
				+ MAIL + "' and ind_broker=1";
   	 	int regRowCount_Status = executeQuerySynergy(strQuery_Status);

		if (regRowCount_Status == 1) {

			String RC = rowtext1.trim();
			String strQuery = "with temp1 as(SELECT"
					+ "                     Usr.TXT_ONLINE_USER_NAME,"
					+ "                     Vw.TXT_ONLINE_VIEW_NAME,"
					+ "                     TAcc.ref_ext_account_identifier"
					+ "      FROM "
					+ "                     BGB_Synergy.dbo.T_ONLINE_USER Usr (NOLOCK)"
					+ "                     INNER JOIN BGB_Synergy.dbo.T_ONLINE_VIEW_USER VwUsr (NOLOCK) ON Usr.ID_ONLINE_USER = VwUsr.FK_ID_ONLINE_USER "
					+ "                     INNER JOIN BGB_Synergy.dbo.T_ONLINE_VIEW Vw (NOLOCK) ON VwUsr.FK_ID_ONLINE_VIEW = Vw.ID_ONLINE_VIEW "
					+ "                     INNER JOIN BGB_Synergy.dbo.T_ONLINE_VIEW_ACCOUNT  VwAcc (NOLOCK) ON Vw.ID_ONLINE_VIEW = VwAcc.FK_ID_ONLINE_VIEW "
					+ "                     INNER JOIN BGB_Synergy.dbo.T_Account TAcc (NOLOCK) ON VwAcc.FK_ID_ACCOUNT = TAcc.ID_ACCOUNT "
					+ "                     INNER JOIN BGB_Synergy.dbo.T_CONTRACT cont (NOLOCK) ON VwAcc.FK_ID_CONTRACT = cont.ID_CONTRACT "
					+ "                     INNER JOIN BGB_Synergy.dbo.T_Customer CU (NOLOCK) ON CU.ID_CUSTOMER = TAcc.FK_ID_CUSTOMER "
					+ "      WHERE "
					+ "                     Vw.IND_ACTIVE = 1"
					+ "                     AND VwAcc.IND_ACTIVE = 1 "
					+ "                     AND ISNULL(VwUsr.IsDeleted,0) = 0"
					+ "                     AND ISNULL(VwAcc.IsDeleted,0) = 0"
					+ "                     AND TAcc.IND_ACTIVE_STATUS = 'Y'"
					+ "                     AND Usr.TXT_ONLINE_USER_NAME = '"
					+ MAIL
					+ "'"
					+ "                     and Vw.TXT_ONLINE_VIEW_NAME='"
					+ RC
					+ "'"
					+ "                     and Vwacc.DT_LOA_END >= CAST(GETDATE() AS DATE)) select count(*) from temp1";

        int regRowCount = executeQuerySynergy(strQuery);
			int finaltest2 = Integer.parseInt(test3);

			if (regRowCount == finaltest2) {
				Report.updateTestLog(
						"Total no.of Account Record is available in DB: "
								+ regRowCount + " Expected is " + finaltest2
								+ "", "PASS");

        } else {
				Report.updateTestLog(
						"Total no.of Account Record is not available in DB_2: "
								+ regRowCount + " Expected is " + finaltest2
								+ "", "FAIL");
        }

		} else {
			String mail1 = browser.getTextByXpath(invoiceProperties
					.getProperty("BGBSearchInv.email"));
			String MAIL1 = mail1.trim();
			String RC = rowtext1.trim();
   	        		String strQuery = "with temp as ("
					+ "                 SELECT "
					+ "                                count(tacc.ref_ext_account_identifier) as accountnos"
					+ "                 FROM "
					+ "                                BGB_Synergy.dbo.T_ONLINE_USER Usr (NOLOCK)"
					+ "                                INNER JOIN BGB_Synergy.dbo.T_ONLINE_VIEW_USER VwUsr (NOLOCK) ON Usr.ID_ONLINE_USER = VwUsr.FK_ID_ONLINE_USER "
					+ "                                INNER JOIN BGB_Synergy.dbo.T_ONLINE_VIEW Vw (NOLOCK) ON VwUsr.FK_ID_ONLINE_VIEW = Vw.ID_ONLINE_VIEW "
					+ "                                INNER JOIN BGB_Synergy.dbo.T_ONLINE_VIEW_ACCOUNT  VwAcc (NOLOCK) ON Vw.ID_ONLINE_VIEW = VwAcc.FK_ID_ONLINE_VIEW "
					+ "                                INNER JOIN BGB_Synergy.dbo.T_Account TAcc (NOLOCK) ON VwAcc.FK_ID_ACCOUNT = TAcc.ID_ACCOUNT "
					+ "                                INNER JOIN BGB_Synergy.dbo.T_CONTRACT cont (NOLOCK) ON VwAcc.FK_ID_CONTRACT = cont.ID_CONTRACT "
					+ "                                INNER JOIN BGB_Synergy.dbo.T_Customer CU (NOLOCK) ON CU.ID_CUSTOMER = TAcc.FK_ID_CUSTOMER "
					+ "                 WHERE "
					+ "                                Vw.IND_ACTIVE = 1"
					+ "                                AND VwAcc.IND_ACTIVE = 1 "
					+ "                                AND ISNULL(VwUsr.IsDeleted,0) = 0"
					+ "                                AND ISNULL(VwAcc.IsDeleted,0) = 0"
					+ "                                AND TAcc.IND_ACTIVE_STATUS = 'Y'"
					+ "                     AND Usr.TXT_ONLINE_USER_NAME = '"
					+ MAIL
					+ "'"
					+ "                     AND Vw.TXT_ONLINE_VIEW_NAME='"
					+ RC
					+ "'"
					+ "                GROUP BY"
					+ "								tacc.ref_ext_account_identifier"
					+ "                 HAVING MAX(cont.DT_CONTRACT_END) >= CAST(GETDATE() AS DATE) OR MAX(cont.DT_CONTRACT_END) >= DATEADD(MM,-6,CAST(GETDATE() AS DATE))"
					+ "                 )"
					+ "                 select count(*) from temp";

   	        OnlineDBConnector dbfunctions = new OnlineDBConnector();
   	        int regRowCount = executeQuerySynergy(strQuery);
			int finaltest2 = Integer.parseInt(test3);

			if (regRowCount == finaltest2) {
				Report.updateTestLog(
						"Total no.of Account Record is available in DB: "
								+ regRowCount + " Expected is " + finaltest2
								+ "", "PASS");

   	        } else {
				Report.updateTestLog(
						"Total no.of Account Record is not available in DB_2: "
								+ regRowCount + " Expected is " + finaltest2
								+ "", "FAIL");
   	        }
   	 	}
        return new RegistrationAction();
    }

	public RegistrationAction dbValidationForNormalUser() {

		String mail = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.email"));
		String MAIL = mail.trim();
		String FirstName = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.fname"));
		FirstName = FirstName.trim();
		String LastName = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.sname"));
		LastName = LastName.trim();
		String strQuery_Status = "select count(*) from bgb_synergy.dbo.T_ONLINE_USER where TXT_ONLINE_USER_NAME = '"
				+ MAIL
				+ "' and TXT_NAME='"
				+ FirstName
				+ "' and TXT_SURNAME='"
				+ LastName + "' and IND_SUPERUSER='0'";
    	 int regRowCount_Status = executeQuerySynergy(strQuery_Status);

		if (regRowCount_Status == 1) {
			Report.updateTestLog("Normal User Account is available in DB"
					+ MAIL + "", "PASS");

        } else {
			Report.updateTestLog("Normal User Account is not available in DB"
					+ MAIL + "", "FAIL");
        }

    	 return new RegistrationAction();
    }

	public RegistrationAction dbValidationForSuperUser() {

		String mail = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.email"));
		String MAIL = mail.trim();
		String FirstName = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.fname"));
		FirstName = FirstName.trim();
		String LastName = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.sname"));
		LastName = LastName.trim();
		String strQuery_Status = "select count(*) from bgb_synergy.dbo.T_ONLINE_USER where TXT_ONLINE_USER_NAME = '"
				+ MAIL
				+ "' and TXT_NAME='"
				+ FirstName
				+ "' and TXT_SURNAME='"
				+ LastName + "' and IND_SUPERUSER='1'";
    	 int regRowCount_Status = executeQuerySynergy(strQuery_Status);

		if (regRowCount_Status == 1) {
			Report.updateTestLog("Super User Account is available in DB" + MAIL
					+ "", "PASS");

        } else {
			Report.updateTestLog("Super User Account is not available in DB"
					+ MAIL + "", "FAIL");
        }

    	 return new RegistrationAction();
    }

    public void searchCustomerNameWildCard() {

        String[] searchText = new String[4];
        searchText[0] = registrationProfile.getFirstName();
		searchText[1] = registrationProfile.getFirstName() + " "
				+ registrationProfile.getLastName();
        searchText[2] = registrationProfile.getSearchText();
        searchText[3] = registrationProfile.getSearchText();
        for (int i = 0; i < 4; i++) {
            searchInvoiceInput(registrationProfile.getSearchCriteria(),
                    searchText[i], registrationProfile.getFromDate(),
                    registrationProfile.getToDate());
            verifyResults();
            browser.wait(5000);
        }
    }

    public void verifyRefineText() {
		// need to update properties one page comes
		String refine = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.refineSearchText"));
        String expRefine = "Please refine your search criteria";
        if (refine.equals(expRefine)) {
			Report.updateTestLog("Expected refine result displayed correctly",
					"PASS");
        } else {
			Report.updateTestLog("Expected refine result displayed correctly",
					"FAIL");
        }
    }

	private void searchInvoiceInput(String searchCriteria, String searchText,
			String fromDate, String toDate) {

        clearText();
        enterSearchCriteria(searchCriteria);
        enterSearchText(searchText);
        enterFromDate(fromDate);
        enterToDate(toDate);
        clickOnSearch();
		Report.updateTestLog("Input " + searchCriteria + ": " + searchText
				+ " is Entered", "Done");
    }

    public void verifyPaging() {
		int rowCount = browser.getRowCountByXpath(invoiceProperties
				.getProperty("BGBSearchInv.tblResults"));
		int colCount = browser.getColCountByXpath(invoiceProperties
				.getProperty("BGBSearchInv.tblResults"));
        int totalRows = totalRowsRetrived();
        int rowsInLastPage = totalRows % 10;
        int totalPagination = totalRows / 10;
        int linkIteration;

        if (rowsInLastPage > 0) {
            totalPagination = totalPagination + 1;
        }
        if (totalPagination <= 10) {
            linkIteration = totalPagination;
        } else {
            linkIteration = 10;
        }

        if (totalRows > 10) {
            if ((rowCount == 10) && (colCount == 9)) {
                Report.updateTestLog("All Results displayed correctly", "PASS");
				Report.updateTestLog("All fields are displayed correctly",
						"PASS");
            } else {
				Report.updateTestLog("All Results are not displayed correctly",
						"FAIL");
				Report.updateTestLog("All fields are not displayed correctly",
						"FAIL");
            }
        }
        for (int i = 1; i <= linkIteration; i++) {
            browser.wait(1000);
			if (browser.isElementVisibleWithXpath(invoiceProperties
					.getProperty("BGBSearchInv.paginationLink") + i + "]")) {
				Report.updateTestLog("Pagination Link " + i + " Existing",
						"PASS");

            } else {
				Report.updateTestLog("Pagination Link " + i + " Not Existing",
						"FAIL");
            }
        }
        if (totalPagination > 1) {

            browser.clickWithXpath("html/body/div[1]/div[2]/div/div/form[2]/div[4]/div[2]/span[4]/a");
			// browser.clickWithXpath(invoiceProperties.getProperty("BGBSearchInv.paginationNext"));
			rowCount = browser.getRowCountByXpath(invoiceProperties
					.getProperty("BGBSearchInv.tblResults"));

            if (rowCount == 10 || rowCount == rowsInLastPage) {
				Report.updateTestLog(
						"All Results are displayed in next page correctly",
						"PASS");
            } else {
				Report.updateTestLog(
						"All Results are not displayed in next page correctly",
						"FAIL");
            }
            browser.clickWithXpath("html/body/div[1]/div[2]/div/div/form[2]/div[4]/div[2]/span[2]/a");
			rowCount = browser.getRowCountByXpath(invoiceProperties
					.getProperty("BGBSearchInv.tblResults"));

            //	browser.clickWithXpath(invoiceProperties.getProperty("BGBSearchInv.paginationPrevious"));
            if (rowCount == 10) {
				Report.updateTestLog(
						"All Results are displayed in previous page correctly",
						"PASS");
            } else {
				Report.updateTestLog(
						"All Results are not displayed in previous page correctly",
						"FAIL");
            }
        }
    }

    public void clickSelectAllCheckBox() {
		browser.click(invoiceProperties
				.getProperty("BGBSearchInv.selectAllCheckBox"));
		final int rowCount = browser.getRowCountByXpath(invoiceProperties
				.getProperty("BGBSearchInv.tblResults"));
		boolean headCheck = browser.isSelected(invoiceProperties
				.getProperty("BGBSearchInv.selectAllCheckBox"));
        boolean dataCheck;
        for (int i = 1; i <= rowCount; i++) {
			dataCheck = browser.isSelectedByXpath(invoiceProperties
					.getProperty("BGBSearchInv.tableCheckBox")
					+ i
					+ "]/td[9]/input");
            if (headCheck == dataCheck) {
				Report.updateTestLog("Check box number " + i + " is selected",
						"PASS");
            } else {
				Report.updateTestLog("Check box number " + i
						+ " is not selected", "FAIL");
            }
        }
    }

    public void clickSelectCheckBox() {
        int count = browser.getRowCountByXpath("//table");
        if (count > 3) {
            count = 3;
        }
        for (int i = 1; i <= count; i++) {
			verifyAndClickWithXpath(
					invoiceProperties.getProperty("BGBSearchInv.tableCheckBox")
							+ i + "]/td[9]/input", "Check box of first result");
        }
    }

    public void validateDate() {
		String[] from_date = { registrationProfile.getFromDate(),
				registrationProfile.getFromDate(), "",
				registrationProfile.getToDate(), "2012/03/01", "" };
		String[] to_date = { "", registrationProfile.getFromDate(),
				registrationProfile.getToDate(),
				registrationProfile.getFromDate(), "", "2012/04/02" };
        for (int i = 0; i < from_date.length; i++) {
			searchInvoiceInput(registrationProfile.getSearchCriteria(),
					registrationProfile.getSearchText(), from_date[i],
					to_date[i]);
            verifyResults();

        }
    }

	public void pdfDownloadAndRead() throws AWTException {

		Calendar cal = new GregorianCalendar();
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		month = month + 1;
		String Todate = day + "/" + month + "/" + year;
		year = year - 1;
		day = day + 1;
		String Fromdate = day + "/" + month + "/" + year;

		String[] from_date = { Fromdate };
		String[] to_date = { Todate };
        for (int i = 0; i < from_date.length; i++) {

			searchAccNoAccountManager();
			searchAccnoCusNameContractNo(0);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", from_date[i]);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", to_date[i]);
			verifyAndClick(
					invoiceProperties.getProperty("BGBSearchInv.searchBt"),
					"Clicked Search Button");
            browser.wait(4000);
			pdfDownload(); // PDF download action.....
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.textCategory"),
					"Test Data", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", "");
        }
        for (int i = 0; i < from_date.length; i++) {

			searchContractNoAccountManager();
			searchAccnoCusNameContractNo(3);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", from_date[i]);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", to_date[i]);
			verifyAndClick(
					invoiceProperties.getProperty("BGBSearchInv.searchBt"),
					"Clicked Search Button");
            browser.wait(4000);
			pdfDownload(); // PDF download action.....
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.textCategory"),
					"Test Data", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", "");

        }
        for (int i = 0; i < from_date.length; i++) {

			searchCusNameAccountManager();
			searchAccnoCusNameContractNo(2);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", from_date[i]);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", to_date[i]);
			verifyAndClick(
					invoiceProperties.getProperty("BGBSearchInv.searchBt"),
					"Clicked Search Button");
            browser.wait(4000);
			pdfDownload(); // PDF download action.....
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.textCategory"),
					"Test Data", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", "");

        }
    }

	public void dbValidationACcountManager() throws AWTException {

		Calendar cal = new GregorianCalendar();
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		month = month + 1;
		String Todate = day + "/" + month + "/" + year;
		year = year - 1;
		day = day + 1;
		String Fromdate = day + "/" + month + "/" + year;
		String[] from_date = { Fromdate };
		String[] to_date = { Todate };
        for (int i = 0; i < from_date.length; i++) {

			searchAccNoAccountManager();
			searchAccnoCusNameContractNo(0);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", from_date[i]);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", to_date[i]);
			verifyAndClick(
					invoiceProperties.getProperty("BGBSearchInv.searchBt"),
					"Clicked Search Button");
            browser.wait(4000);
			String ACCNO = registrationProfile.getAccountNumber();
			int month1 = cal.get(Calendar.MONTH);
    		int year1 = cal.get(Calendar.YEAR);
			int day1 = cal.get(Calendar.DAY_OF_MONTH);
			month1 = month1 + 1;
			String Todate_ACC = year1 + "-" + month1 + "-" + day1;
			year1 = year1 - 1;
			day1 = day1 + 1;
			String Fromdate_ACC = year1 + "-" + month1 + "-" + day1;

			recordCountDBValidationAcc(Fromdate_ACC, Todate_ACC, ACCNO); // DB
																			// Validation
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.textCategory"),
					"Test Data", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", "");
        }
      for (int i = 0; i < from_date.length; i++) {

			searchContractNoAccountManager();
			searchAccnoCusNameContractNo(3);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", from_date[i]);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", to_date[i]);
			verifyAndClick(
					invoiceProperties.getProperty("BGBSearchInv.searchBt"),
					"Clicked Search Button");
            browser.wait(4000);
			String contractNo = registrationProfile.getSearchCriteria();
			int month1 = cal.get(Calendar.MONTH);
    		int year1 = cal.get(Calendar.YEAR);
			int day1 = cal.get(Calendar.DAY_OF_MONTH);
			month1 = month1 + 1;
			String Todate_ACC = year1 + "-" + month1 + "-" + day1;
			year1 = year1 - 1;
			day1 = day1 + 1;
			String Fromdate_ACC = year1 + "-" + month1 + "-" + day1;
			recordCountDBValidationCount(Fromdate_ACC, Todate_ACC, contractNo); // DB
																				// Validation
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.textCategory"),
					"Test Data", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", "");

		}
        for (int i = 0; i < from_date.length; i++) {

			searchCusNameAccountManager();
			searchAccnoCusNameContractNo(2);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", from_date[i]);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", to_date[i]);
			verifyAndClick(
					invoiceProperties.getProperty("BGBSearchInv.searchBt"),
					"Clicked Search Button");
            browser.wait(4000);
			String CusName = registrationProfile.getFirstName();
			int month1 = cal.get(Calendar.MONTH);
    		int year1 = cal.get(Calendar.YEAR);
			int day1 = cal.get(Calendar.DAY_OF_MONTH);
			month1 = month1 + 1;
			String Todate_ACC = year1 + "-" + month1 + "-" + day1;
			year1 = year1 - 1;
			day1 = day1 + 1;
			String Fromdate_ACC = year1 + "-" + month1 + "-" + day1;
			recordCountDBValidationCon(Fromdate_ACC, Todate_ACC, CusName); // DB
																			// Validation
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.textCategory"),
					"Test Data", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", "");

        }
    }

	public void validateDateNew() {

		Calendar cal = new GregorianCalendar();
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		month = month + 1;
		String Todate = day + "/" + month + "/" + year;
		year = year - 1;
		day = day + 1;
		String Fromdate = day + "/" + month + "/" + year;

		String[] from_date = { Fromdate, "", Fromdate };
		String[] to_date = { "", Todate, Todate };
        for (int i = 0; i < from_date.length; i++) {

			searchAccNoAccountManager();
			searchAccnoCusNameContractNo(0);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", from_date[i]);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", to_date[i]);
			verifyAndClick(
					invoiceProperties.getProperty("BGBSearchInv.searchBt"),
					"Clicked Search Button");
            browser.wait(4000);
			verifyResultsValidDate();
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.textCategory"),
					"Test Data", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", "");
        }
        for (int i = 0; i < from_date.length; i++) {

			searchContractNoAccountManager();
			searchAccnoCusNameContractNo(3);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", from_date[i]);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", to_date[i]);
			verifyAndClick(
					invoiceProperties.getProperty("BGBSearchInv.searchBt"),
					"Clicked Search Button");
            browser.wait(4000);
			verifyResultsValidDate();
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.textCategory"),
					"Test Data", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", "");

        }
        for (int i = 0; i < from_date.length; i++) {

			searchCusNameAccountManager();
			searchAccnoCusNameContractNo(2);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", from_date[i]);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", to_date[i]);
			verifyAndClick(
					invoiceProperties.getProperty("BGBSearchInv.searchBt"),
					"Clicked Search Button");
            browser.wait(4000);
			verifyResultsValidDate();
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.textCategory"),
					"Test Data", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", "");

        }
    }

	public void validateInvalidDateNew() {

		Calendar cal = new GregorianCalendar();
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		month = month + 1;
		year = year + 3;
		String Todate = day + "/" + month + "/" + year;
		year = year + 3;
		day = day + 1;
		String Fromdate = day + "/" + month + "/" + year;
		String[] from_date = { Fromdate, "", Fromdate };
		String[] to_date = { "", Todate, Todate };
        for (int i = 0; i < from_date.length; i++) {
			int j = from_date.length;
			searchAccNoAccountManager();
			searchAccnoCusNameContractNoNew(0);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", from_date[i]);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", to_date[i]);
			verifyAndClick(
					invoiceProperties.getProperty("BGBSearchInv.searchBt"),
					"Clicked Search Button");
            browser.wait(4000);
			verifyResultsInValidDate(i, j);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.textCategory"),
					"Test Data", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", "");
        }
        for (int i = 0; i < from_date.length; i++) {
			int j = from_date.length;
			searchContractNoAccountManager();
			searchAccnoCusNameContractNoNew(3);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", from_date[i]);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", to_date[i]);
			verifyAndClick(
					invoiceProperties.getProperty("BGBSearchInv.searchBt"),
					"Clicked Search Button");
            browser.wait(4000);
			verifyResultsInValidDate(i, j);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.textCategory"),
					"Test Data", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", "");

        }
        for (int i = 0; i < from_date.length; i++) {
			int j = from_date.length;
			searchCusNameAccountManager();
			searchAccnoCusNameContractNoNew(2);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", from_date[i]);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", to_date[i]);
			verifyAndClick(
					invoiceProperties.getProperty("BGBSearchInv.searchBt"),
					"Clicked Search Button");
            browser.wait(4000);
			verifyResultsInValidDate(i, j);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.textCategory"),
					"Test Data", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", "");

        }
    }

 public void monthanddatechange() {

		Calendar cal = new GregorianCalendar();
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		month = month + 1;
		// year=year+3;
		String Todate = day + "/" + month + "/" + year;
		// year=year+3;
		// day=day+1;
		String Fromdate = day + "/" + 31 + "/" + year;
		String[] from_date = { Fromdate, };
		String[] to_date = { Todate };

		String errormessage = "From (dd/mm/yyyy) : The date you entered is not valid. Please enter date as DD/MM/YYYY.";
        for (int i = 0; i < from_date.length; i++) {
			int j = from_date.length;
			searchAccNoAccountManager();
			searchAccnoCusNameContractNoNew(0);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", from_date[i]);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", to_date[i]);
			verifyAndClick(
					invoiceProperties.getProperty("BGBSearchInv.searchBt"),
					"Clicked Search Button");
            browser.wait(4000);
            verifyIsTextPresent(errormessage);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.textCategory"),
					"Test Data", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", "");
        }
        for (int i = 0; i < from_date.length; i++) {
			int j = from_date.length;
			searchContractNoAccountManager();
			searchAccnoCusNameContractNoNew(3);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", from_date[i]);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", to_date[i]);
			verifyAndClick(
					invoiceProperties.getProperty("BGBSearchInv.searchBt"),
					"Clicked Search Button");
            browser.wait(4000);
            verifyIsTextPresent(errormessage);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.textCategory"),
					"Test Data", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", "");

        }
        for (int i = 0; i < from_date.length; i++) {
			int j = from_date.length;
			searchCusNameAccountManager();
			searchAccnoCusNameContractNoNew(2);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", from_date[i]);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", to_date[i]);
			verifyAndClick(
					invoiceProperties.getProperty("BGBSearchInv.searchBt"),
					"Clicked Search Button");
            browser.wait(4000);
            verifyIsTextPresent(errormessage);
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.textCategory"),
					"Test Data", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.fromDate"),
					"From Date", "");
			verifyAndInputById(
					invoiceProperties.getProperty("BGBSearchInv.toDate"),
					"To Date", "");

        }
    }

	public void refinedDatevalidation() {

		Calendar cal = new GregorianCalendar();
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		month = month + 1;
		String Todate = day + "/" + month + "/" + year;
		year = year - 1;
		day = day + 1;
		String Fromdate = day + "/" + month + "/" + year;

		String[] from_date = { Fromdate };
		String[] to_date = { Todate };

		searchAccNoAccountManager();
		searchAccnoCusNameContractNo(0);
		verifyAndInputById(
				invoiceProperties.getProperty("BGBSearchInv.fromDate"),
				"From Date", from_date[0]);
		verifyAndInputById(
				invoiceProperties.getProperty("BGBSearchInv.toDate"),
				"To Date", to_date[0]);
		verifyAndClick(invoiceProperties.getProperty("BGBSearchInv.searchBt"),
				"Clicked Search Button");
         browser.wait(4000);
		accountNoDateSort(Fromdate, Todate);
		verifyAndInputById(
				invoiceProperties.getProperty("BGBSearchInv.textCategory"),
				"Test Data", "");
		verifyAndInputById(
				invoiceProperties.getProperty("BGBSearchInv.fromDate"),
				"From Date", "");
		verifyAndInputById(
				invoiceProperties.getProperty("BGBSearchInv.toDate"),
				"To Date", "");

		searchContractNoAccountManager();
		searchAccnoCusNameContractNo(3);
		verifyAndInputById(
				invoiceProperties.getProperty("BGBSearchInv.fromDate"),
				"From Date", from_date[0]);
		verifyAndInputById(
				invoiceProperties.getProperty("BGBSearchInv.toDate"),
				"To Date", to_date[0]);
		verifyAndClick(invoiceProperties.getProperty("BGBSearchInv.searchBt"),
				"Clicked Search Button");
        browser.wait(4000);
		accountNoDateSort(Fromdate, Todate);
		verifyAndInputById(
				invoiceProperties.getProperty("BGBSearchInv.textCategory"),
				"Test Data", "");
		verifyAndInputById(
				invoiceProperties.getProperty("BGBSearchInv.fromDate"),
				"From Date", "");
		verifyAndInputById(
				invoiceProperties.getProperty("BGBSearchInv.toDate"),
				"To Date", "");

		searchCusNameAccountManager();
		searchAccnoCusNameContractNo(2);
		verifyAndInputById(
				invoiceProperties.getProperty("BGBSearchInv.fromDate"),
				"From Date", from_date[0]);
		verifyAndInputById(
				invoiceProperties.getProperty("BGBSearchInv.toDate"),
				"To Date", to_date[0]);
		verifyAndClick(invoiceProperties.getProperty("BGBSearchInv.searchBt"),
				"Clicked Search Button");
        browser.wait(4000);
		accountNoDateSort(Fromdate, Todate);
		verifyAndInputById(
				invoiceProperties.getProperty("BGBSearchInv.textCategory"),
				"Test Data", "");
		verifyAndInputById(
				invoiceProperties.getProperty("BGBSearchInv.fromDate"),
				"From Date", "");
		verifyAndInputById(
				invoiceProperties.getProperty("BGBSearchInv.toDate"),
				"To Date", "");

 }

	public void systemError() {

		verifyAndClickWithXpath(
				invoiceProperties.getProperty("BGBSearchInv.logout"), "Logout");
    	browser.browserBack();
    	browser.wait(1000);
		verifyErrorMsgSearchText5();
  }

	public void searchAccNoAccountManager() {

		// String criteria[]={"Account Number","Customer Name"};
          // browser.selectFromDropBoxByID(invoiceProperties.getProperty("BGBSearchInv.selectCategory"),criteria[0]);
		browser.selectfromDropBoxByXpath(
				invoiceProperties.getProperty("BGBSearchInv.dropdown"),
				"Account Number");
		Report.updateTestLog("Drop Down Value:      " + "Account Number",
				"DONE");
    }

	public void searchAccNoCusnameContarctnoAccountManager(int i) {
		switch (i) {
    	case 0:
			browser.selectfromDropBoxByXpath(
					invoiceProperties.getProperty("BGBSearchInv.dropdown"),
					"Account Number");
			Report.updateTestLog("Drop Down Value:      " + "Account Number",
					"DONE");
         break;
    	case 1:
			browser.selectfromDropBoxByXpath(
					invoiceProperties.getProperty("BGBSearchInv.dropdown"),
					"Customer Name");
			Report.updateTestLog("Drop Down Value:      " + "Contract Number",
					"DONE");
         break;
    	case 2:
			browser.selectfromDropBoxByXpath(
					invoiceProperties.getProperty("BGBSearchInv.dropdown"),
					"Customer Name");
			Report.updateTestLog("Drop Down Value:      " + "Contract Number",
					"DONE");
         break;
    	case 3:
			browser.selectfromDropBoxByXpath(
					invoiceProperties.getProperty("BGBSearchInv.dropdown"),
					"Contract Number");
			Report.updateTestLog("Drop Down Value:      " + "Customer Name",
					"DONE");
	     break;

    	}
  }

    public void signonsuccessFailure() {
		String logout = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.logout"));
		if (logout.trim().equals("Logout")) {
         Report.updateTestLog("Account Manager SignOn Success", "PASS");
		} else {
  	     Report.updateTestLog("Account Manager SignOn Failure", "FAIL");

  	     }

		String url = "http://10.224.70.75/business/CAELogin/emailAddress=@saptestexch.local&firstName=CQMAccount&lastName=Manager1&isAccountExecutive=false";
  	     browser.open(url);
  	     browser.wait(1000);
		if (verifyIsTextPresent("Error"))

	     {
  		 Report.updateTestLog("Account Manager SignOn Failure", "PASS");
		} else {
	     Report.updateTestLog("Account Manager SignON Success", "FAIL");

	     }
  }

	public void searchContractNoAccountManager() {

		// String criteria[]={"Account Number","Customer Name"};
        // browser.selectFromDropBoxByID(invoiceProperties.getProperty("BGBSearchInv.selectCategory"),criteria[0]);
		browser.selectfromDropBoxByXpath(
				invoiceProperties.getProperty("BGBSearchInv.dropdown"),
				"Contract Number");
		Report.updateTestLog("Drop Down Value:      " + "Contract Number",
				"DONE");
  }

	public void searchCusNameAccountManager() {

		// String criteria[]={"Account Number","Customer Name"};
        // browser.selectFromDropBoxByID(invoiceProperties.getProperty("BGBSearchInv.selectCategory"),criteria[0]);
		browser.selectfromDropBoxByXpath(
				invoiceProperties.getProperty("BGBSearchInv.dropdown"),
				"Customer Name");
		Report.updateTestLog("Drop Down Value:      " + "Customer Name", "DONE");
  }

	public void readOnlyProfilePage() {

		verifyAndClickWithXpath(
				invoiceProperties.getProperty("BGBSearchInv.profilelink"),
				"Profile Link Clicked");
		String readonly1 = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.MyProfile"));
		if (readonly1.trim().equals("My Profile")) {
			Report.updateTestLog("Expected Text Available:  " + readonly1,
					"PASS");
        } else {
			Report.updateTestLog("Expected Text Not Available:" + readonly1,
					"FAIL");
        }
		String readonly2 = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.ViewACcountDetails"));
		if (readonly2.trim().equals("View account details")) {
			Report.updateTestLog("Expected Text Available:  " + readonly2,
					"PASS");
        } else {
			Report.updateTestLog("Expected Text Not Available:" + readonly2,
					"FAIL");
        }
		String readonly3 = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.ViewACcountDetailsText"));
		readonly3 = readonly3.replaceAll("\n", " ");
		if (readonly3
				.trim()
				.contains(
						"If you require any changes made to your account details, please contact your")) {
			Report.updateTestLog("Expected Text Available:  " + readonly3,
					"PASS");
        } else {
			Report.updateTestLog("Expected Text Not Available:" + readonly3,
					"FAIL");
        }
		String readonly4 = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.YourContactDetails"));
		if (readonly4.trim().equals("Your contact details")) {
			Report.updateTestLog("Expected Text Available:  " + readonly4,
					"PASS");
        } else {
			Report.updateTestLog("Expected Text Not Available:" + readonly4,
					"FAIL");
        }
		String readonly5 = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.FirstName"));
		if (readonly5.trim().equals("First name")) {
			Report.updateTestLog("Expected Text Available:  " + readonly5,
					"PASS");
        } else {
			Report.updateTestLog("Expected Text Not Available:" + readonly5,
					"FAIL");
        }
		String readonly6 = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.SurName"));
		if (readonly6.trim().equals("surname")) {
			Report.updateTestLog("Expected Text Available:  " + readonly6,
					"PASS");
        } else {
			Report.updateTestLog("Expected Text Not Available:" + readonly6,
					"FAIL");
        }
		String readonly7 = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.EmailAddress"));
		if (readonly7.trim().equals("Email address")) {
			Report.updateTestLog("Expected Text Available:  " + readonly7,
					"PASS");
        } else {
			Report.updateTestLog("Expected Text Not Available:" + readonly7,
					"FAIL");
        }
		String readonly8 = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.CreatenewPass"));
		if (readonly8.trim().equals("Create new password")) {
			Report.updateTestLog("Expected Text Available:  " + readonly8,
					"PASS");
        } else {
			Report.updateTestLog("Expected Text Not Available:" + readonly8,
					"FAIL");
        }
		String readonly9 = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.Passwordinstruction"));
		if (readonly9.trim().equals("(8 or more letters and numbers)")) {
			Report.updateTestLog("Expected Text Available:  " + readonly9,
					"PASS");
        } else {
			Report.updateTestLog("Expected Text Not Available:" + readonly9,
					"FAIL");
        }
		String readonly10 = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.RetypePassword"));
		if (readonly10.trim().equals("Re-enter new password")) {
			Report.updateTestLog("Expected Text Available:  " + readonly10,
					"PASS");
        } else {
			Report.updateTestLog("Expected Text Not Available:" + readonly10,
					"FAIL");
        }
		String readonly11 = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.YourView"));
		if (readonly11.trim().equals("Your views")) {
			Report.updateTestLog("Expected Text Available:  " + readonly11,
					"PASS");
        } else {
			Report.updateTestLog("Expected Text Not Available:" + readonly11,
					"FAIL");
        }
		String readonly12 = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.Views"));
		if (readonly12.trim().equals("Views")) {
			Report.updateTestLog("Expected Text Available:  " + readonly12,
					"PASS");
        } else {
			Report.updateTestLog("Expected Text Not Available:" + readonly12,
					"FAIL");
        }
		String readonly13 = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.Accounts"));
		if (readonly13.trim().equals("Accounts")) {
			Report.updateTestLog("Expected Text Available:  " + readonly13,
					"PASS");
        } else {
			Report.updateTestLog("Expected Text Not Available:" + readonly13,
					"FAIL");
        }

    }

	public void tableContentEmpty() {
		if (browser.isElementVisibleWithXpath(invoiceProperties
				.getProperty("BGBSearchInv.ProfileTableContent"))) {
	        Report.updateTestLog("Table is Not Empty:  ", "FAIL");
	    } else {
	        Report.updateTestLog("Table is Empty:   ", "PASS");
	    }
    }

	public void hideFieldValidation() {

		String pass1 = browser.getAttribute(
				invoiceProperties.getProperty("BGBSearchInv.password"),
				"disabled");
		if (pass1.equals("true")) {
			Report.updateTestLog("Create New Password Field is Read only  ",
					"PASS");
	    } else {
			Report.updateTestLog(
					"Create New Password Field is Not Read only   ", "FAIL");
	    }
		String pass2 = browser.getAttribute(
				invoiceProperties.getProperty("BGBSearchInv.confirmpassword"),
				"disabled");
		if (pass2.equals("true")) {
			Report.updateTestLog("Confirm Password Field is Read only  ",
					"PASS");
	    } else {
			Report.updateTestLog("Confirm Password Field is Not Read only   ",
					"FAIL");
	    }
		String Update = browser.getAttribute(
				invoiceProperties.getProperty("BGBSearchInv.confirmpassword"),
				"disabled");
		if (Update.equals("true")) {
	        Report.updateTestLog("Update button Hidden", "PASS");
	    } else {
	        Report.updateTestLog("Update button is not Hidden", "FAIL");
	    }
		String Preview = browser.getAttribute(
				invoiceProperties.getProperty("BGBSearchInv.profilePreview"),
				"class");
		if (Preview.trim().equals(
				"previous paginate_button paginate_button_disabled")) {
	        Report.updateTestLog("Previous Link is Hidden", "PASS");
	    } else {
	        Report.updateTestLog("Previous Link is not Hidden", "FAIL");
	    }
		String Next = browser.getAttribute(
				invoiceProperties.getProperty("BGBSearchInv.profileNext"),
				"class");
		if (Next.trim().equals("next paginate_button paginate_button_disabled")) {
	        Report.updateTestLog("Next Link is Hidden", "PASS");
	    } else {
	        Report.updateTestLog("Next Link is Not Hidden", "FAIL");
	    }
    }

	public void searchAccnoCusNameContractNoNew(int j) {

		String testdata[] = { registrationProfile.getAccountNumber(),
				registrationProfile.getFirstName(),
				registrationProfile.getSearchText(),
				registrationProfile.getSearchCriteria() };
		verifyAndInputById(
				invoiceProperties.getProperty("BGBSearchInv.textCategory"),
				"Test Data", testdata[j]);
        browser.wait(4000);

    }

	public void searchAccnoCusNameContractNo(int j) {

		String testdata[] = { registrationProfile.getAccountNumber(),
				registrationProfile.getFirstName(),
				registrationProfile.getSearchText(),
				registrationProfile.getSearchCriteria() };
		verifyAndInputById(
				invoiceProperties.getProperty("BGBSearchInv.textCategory"),
				"Test Data", testdata[j]);
		verifyAndClick(invoiceProperties.getProperty("BGBSearchInv.searchBt"),
				"Clicked Search Button");
        browser.wait(4000);

   	}

	public void searchAccNoCusNameContractNoRefined(int j) {

		String testdata[] = { registrationProfile.getAccountNumber(),
				registrationProfile.getFirstName(),
				registrationProfile.getSearchText(),
				registrationProfile.getSearchCriteria() };
		verifyAndInputById(
				invoiceProperties.getProperty("BGBSearchInv.textCategory"),
				"Test Data", testdata[j]);

		Calendar cal = new GregorianCalendar();
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		month = month + 1;
		String Currentdate = day + "/" + month + "/" + year;
		year = year - 1;
		day = day + 1;
		String Backdate = day + "/" + month + "/" + year;

		// verifyAndInputById(invoiceProperties.getProperty("BGBSearchInv.fromDate"),
		// "From Date", registrationProfile.getFromDate());
		// verifyAndInputById(invoiceProperties.getProperty("BGBSearchInv.toDate"),
		// "To Date", registrationProfile.getToDate());
		verifyAndInputById(
				invoiceProperties.getProperty("BGBSearchInv.fromDate"),
				"From Date", Backdate);
		verifyAndInputById(
				invoiceProperties.getProperty("BGBSearchInv.toDate"),
				"To Date", Currentdate);
		verifyAndClick(invoiceProperties.getProperty("BGBSearchInv.searchBt"),
				"Clicked Search Button");
        browser.wait(4000);

   	}

	public void tableHeaderCheckAccountManager() {

		for (int i = 1; i <= 8; i++) {
			// String
			// header1=browser.getTextByXpath(invoiceProperties.getProperty("BGBSearchInv.Header"));
			String header2 = browser.getTextByXpath(invoiceProperties
					.getProperty("BGBSearchInv.Header") + "th[" + i + "]");
			String header1 = header2.replaceAll("\n", " ");

			switch (i) {
        case 1:
				if (header1.trim().equals("Invoice Created Date")) {
					Report.updateTestLog("Header 1 Displayed successfully:  "
							+ header1, "PASS");
        } else {
					Report.updateTestLog("Header 1 Incorrect:  " + header1,
							"FAIL");
        }
        break;
        case 2:
				if (header1.trim().equals("Customer Number")) {
					Report.updateTestLog("Header 2 Displayed successfully:  "
							+ header1, "PASS");
            } else {
					Report.updateTestLog("Header 2 Incorrect:  " + header1,
							"FAIL");
            }
            break;
        case 3:
				if (header1.trim().equals("Customer Name")) {
					Report.updateTestLog("Header 3 Displayed successfully:  "
							+ header1, "PASS");
            } else {
					Report.updateTestLog("Header 3 Incorrect:  " + header1,
							"FAIL");
            }
            break;
        case 4:
				if (header1.trim().equals("Account Number")) {
					Report.updateTestLog("Header 4 Displayed successfully:  "
							+ header1, "PASS");
            } else {
					Report.updateTestLog("Header 4 Incorrect:  " + header1,
							"FAIL");
            }
            break;
        case 5:
				if (header1.trim().equals("Site Number")) {
					Report.updateTestLog("Header 5 Displayed successfully:  "
							+ header1, "PASS");
            } else {
					Report.updateTestLog("Header 5 Incorrect:  " + header1,
							"FAIL");
            }
            break;
        case 6:
				if (header1.trim().equals("Site Name")) {
					Report.updateTestLog("Header 6 Displayed successfully:  "
							+ header1, "PASS");
            } else {
					Report.updateTestLog("Header 6 Incorrect:  " + header1,
							"FAIL");
            }
            break;
        case 7:
				if (header1.trim().equals("Invoice Number")) {
					Report.updateTestLog("Header 7 Displayed successfully:  "
							+ header1, "PASS");
            } else {
					Report.updateTestLog("Header 7 Incorrect:  " + header1,
							"FAIL");
            }
            break;
        case 8:
				if (header1.trim().contains("Total Value")) {
					Report.updateTestLog("Header 8 Displayed successfully:  "
							+ header1, "PASS");
            } else {
					Report.updateTestLog("Header 8 Incorrect:  " + header1,
							"FAIL");
            }
            break;
        }
        }
		// browser.input(id,)

    }

	public void accountSearchValidate() {

		int count = browser.getChildElementsCountByXpath(invoiceProperties
				.getProperty("BGBSearchInv.Buttoncount"));
		for (int i = 1; i <= count; i++) {
			verifyAndClickWithXpath(
					invoiceProperties.getProperty("BGBSearchInv.Buttoncount")
							+ "[" + i + "]", "Button Clicked");
			int invoicecreatedDate_Count = browser
					.getChildElementsCountByXpath(invoiceProperties
							.getProperty("BGBSearchInv.Row_TD1"));
			// if(invoicecreatedDate_Count)
			for (int j = 1; j <= invoicecreatedDate_Count; j++) {

				String td4 = browser.getTextByXpath(invoiceProperties
						.getProperty("BGBSearchInv.RowAcc")
						+ "tr["
						+ j
						+ "]/td[4]");
				if (td4.trim().equals(registrationProfile.getAccountNumber())) {
					Report.updateTestLog("Account No Matches Correctly:  "
							+ td4 + " In Row : " + j
							+ " and Column: 4 and Page No  " + i + "", "PASS");
                } else {
					Report.updateTestLog("Account No Matches In Correctly:  "
							+ td4 + " In Row : " + j
							+ " and Column: 4 and Page No  " + i + "", "FAIL");
                }
        	}
        }
    }

	public void customerNameSearchValidate() {

		int count = browser.getChildElementsCountByXpath(invoiceProperties
				.getProperty("BGBSearchInv.Buttoncount"));
		for (int i = 1; i <= count; i++) {
			verifyAndClickWithXpath(
					invoiceProperties.getProperty("BGBSearchInv.Buttoncount")
							+ "[" + i + "]", "Button Clicked");
			int invoicecreatedDate_Count = browser
					.getChildElementsCountByXpath(invoiceProperties
							.getProperty("BGBSearchInv.Row_TD1"));
			// if(invoicecreatedDate_Count)
			for (int j = 1; j <= invoicecreatedDate_Count; j++) {

				String td4 = browser.getTextByXpath(invoiceProperties
						.getProperty("BGBSearchInv.RowAcc")
						+ "tr["
						+ j
						+ "]/td[3]");
				if (td4.trim().equals(registrationProfile.getFirstName())) {
					Report.updateTestLog("Account No Matches Correctly:  "
							+ td4 + " In Row : " + j
							+ " and Column: 3 and Page No:  " + i + "", "PASS");
            } else {
					Report.updateTestLog("Account No Matches In Correctly:  "
							+ td4 + " In Row : " + j
							+ " and Column: 3 and Page No:  " + i + "", "FAIL");
            }
    	}
    }
 }

	public void customerNamePartialSearchValidate() {

		int count = browser.getChildElementsCountByXpath(invoiceProperties
				.getProperty("BGBSearchInv.Buttoncount"));
		for (int i = 1; i <= count; i++) {
			verifyAndClickWithXpath(
					invoiceProperties.getProperty("BGBSearchInv.Buttoncount")
							+ "[" + i + "]", "Button Clicked");
			int invoicecreatedDate_Count = browser
					.getChildElementsCountByXpath(invoiceProperties
							.getProperty("BGBSearchInv.Row_TD1"));
			// if(invoicecreatedDate_Count)
			for (int j = 1; j <= invoicecreatedDate_Count; j++) {

				String td4 = browser.getTextByXpath(invoiceProperties
						.getProperty("BGBSearchInv.RowAcc")
						+ "tr["
						+ j
						+ "]/td[3]");
				if (td4.trim().contains(registrationProfile.getSearchText())) {
					Report.updateTestLog("Customer Name Matches Correctly:  "
							+ td4 + " In Row : " + j
							+ " and Column: 3 and Page No:  " + i + "", "PASS");
	            } else {
					Report.updateTestLog(
							"Customer Name Matches In Correctly:  " + td4
									+ " In Row : " + j
									+ " and Column: 3 and Page No:  " + i + "",
							"FAIL");
	            }
	    	}
	    }
	 }

	public void pageNavigationUsingButton() {

		int count = browser.getChildElementsCountByXpath(invoiceProperties
				.getProperty("BGBSearchInv.Buttoncount"));
		if (count >= 2) {
			for (int i = 1; i <= count; i++) {
				verifyAndClickWithXpath(
						invoiceProperties.getProperty("BGBSearchInv.Buttoncount")
								+ "[" + i + "]", "Button Clicked");
				String abc = browser.getAttributeByXpath(
						invoiceProperties
								.getProperty("BGBSearchInv.Buttoncount")
								+ "["
								+ i + "]", "class");
				// if(invoicecreatedDate_Count)
				if ("paginate_active".equals(abc.trim())) {
					Report.updateTestLog("Page navigation done successfully",
							"PASS");
             } else {
                 Report.updateTestLog("Page Navigation Failure", "FAIL");
             }
     }
		} else {
			Report.updateTestLog("Search data dont have mutiple pages: ",
					"FAIL");
     }

     }

	public void pageNavigationUsingLink() {

		int count = browser.getChildElementsCountByXpath(invoiceProperties
				.getProperty("BGBSearchInv.Buttoncount"));
		if (count >= 2) {

			String PreviousLink = browser.getAttributeByXpath(
					invoiceProperties.getProperty("BGBSearchInv.PreviousLink"),
					"class");
			String NextLink = browser.getAttributeByXpath(
					invoiceProperties.getProperty("BGBSearchInv.NextLink"),
					"class");
			// if(invoicecreatedDate_Count)
			if ("next paginate_button".equals(NextLink.trim())) {
                Report.updateTestLog("Next Button is Visible-Default", "PASS");
            } else {
				Report.updateTestLog("Next Button is Not visible-Default",
						"FAIL");
            }

			if ("previous paginate_button paginate_button_disabled"
					.equals(PreviousLink.trim())) {
				Report.updateTestLog("Previous Button is Not Visible-Default",
						"PASS");
            } else {
				Report.updateTestLog("Previous Button is Visible-Default",
						"FAIL");
            }
			String RecordCount = browser.getTextByXpath(invoiceProperties
					.getProperty("BGBSearchInv.RecordCount"));
			String split1[] = RecordCount.split("of");
			String intvalue[] = split1[1].split("transactions");
			String count_1 = intvalue[0].trim();
			int RecordCount_Total = Integer.parseInt(count_1);
			double pagecount = RecordCount_Total / 10;
			pagecount = Math.round(pagecount);
			for (int i = 1; i <= pagecount; i++) {
				verifyAndClickWithXpath(
						invoiceProperties.getProperty("BGBSearchInv.NextLink"),
						"Next Button Clicked");

			}
			//
			// for(int i=1;i<=count;i++)
			// {
			// verifyAndClickWithXpath(invoiceProperties.getProperty("BGBSearchInv.NextLink"),
			// "Next Button Clicked");
			// }
			String NextLink_1 = browser.getAttributeByXpath(
					invoiceProperties.getProperty("BGBSearchInv.NextLink"),
					"class");
			if ("next paginate_button paginate_button_disabled"
					.equals(NextLink_1.trim())) {
				Report.updateTestLog(
						"Next Button Navigation done successfully", "PASS");
	        } else {
	            Report.updateTestLog("Next Button Navigation Failure", "FAIL");
	        }
			String PreviousLink_1 = browser.getAttributeByXpath(
					invoiceProperties.getProperty("BGBSearchInv.PreviousLink"),
					"class");
			if ("previous paginate_button".equals(PreviousLink_1.trim())) {
	            Report.updateTestLog("Previous Button is Visible", "PASS");
	        } else {
	            Report.updateTestLog("Previous Button is Not visible", "FAIL");
	        }
			for (int i = 1; i <= pagecount; i++) {
				verifyAndClickWithXpath(
						invoiceProperties
								.getProperty("BGBSearchInv.PreviousLink"),
						"Previous Button Clicked");
		     }
			String PreviousLink_2 = browser.getAttributeByXpath(
					invoiceProperties.getProperty("BGBSearchInv.PreviousLink"),
					"class");
			if ("previous paginate_button paginate_button_disabled"
					.equals(PreviousLink_2.trim())) {
				Report.updateTestLog(
						"Previous Button Navigation done successfully", "PASS");
	        } else {
				Report.updateTestLog("Previous Button Navigation Failure",
						"FAIL");
	        }
			String NextLink_2 = browser.getAttributeByXpath(
					invoiceProperties.getProperty("BGBSearchInv.NextLink"),
					"class");
			if ("next paginate_button".equals(NextLink_2.trim())) {
		            Report.updateTestLog("Next Button is visible", "PASS");
		        } else {
		            Report.updateTestLog("Next Button is not visible", "FAIL");
		        }
		} else {
			Report.updateTestLog("Search data dont have more than one page: ",
					"FAIL");
	     }
	     }

	public void contentValidation() {

		String RecordCount = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.RecordCount"));
		String split1[] = RecordCount.split("of");
		String intvalue[] = split1[1].split("transactions");
		String count = intvalue[0].trim();
		int RecordCount_Total = Integer.parseInt(count);
		double pagecount = RecordCount_Total / 10;
		pagecount = Math.round(pagecount);
		// pagecount=pagecount-1;
		// int
		// count=browser.getChildElementsCountByXpath(invoiceProperties.getProperty("BGBSearchInv.Buttoncount"));
		for (int i = 1; i <= pagecount; i++) {
			// verifyAndClickWithXpath(invoiceProperties.getProperty("BGBSearchInv.Buttoncount")+"["+i+"]",
			// "Button Clicked");

			int invoicecreatedDate_Count = browser
					.getChildElementsCountByXpath(invoiceProperties
							.getProperty("BGBSearchInv.Row_TD1"));
			// if(invoicecreatedDate_Count)
			for (int j = 1; j <= invoicecreatedDate_Count; j++) {
				String td1 = browser.getTextByXpath(invoiceProperties
						.getProperty("BGBSearchInv.RowAcc")
						+ "tr["
						+ j
						+ "]/td[1]");
				if (td1.trim() != null) {
					Report.updateTestLog(
							"Invoice Created Date displayed successfully in ROW NO:"
									+ j + "COLUMN NO: " + 1 + "PAGE NO: " + i
									+ " " + td1, "PASS");
                } else {
					Report.updateTestLog(
							"Invoice Created Date  is empty in ROW NO:" + j
									+ "COLUMN NO: " + 1 + "PAGE NO: " + i + " "
									+ td1, "FAIL");
                }
				String td2 = browser.getTextByXpath(invoiceProperties
						.getProperty("BGBSearchInv.RowAcc")
						+ "tr["
						+ j
						+ "]/td[2]");
				if (td2.trim() != null) {
					Report.updateTestLog(
							"Customer No displayed successfully in ROW NO:" + j
									+ "COLUMN NO: " + 2 + "PAGE NO: " + i + " "
									+ td2, "PASS");
                } else {
					Report.updateTestLog("Customer No  is empty in ROW NO:" + j
							+ "COLUMN NO: " + 2 + "PAGE NO: " + i + " " + td2,
							"FAIL");
                }
				String td3 = browser.getTextByXpath(invoiceProperties
						.getProperty("BGBSearchInv.RowAcc")
						+ "tr["
						+ j
						+ "]/td[3]");
				if (td3.trim() != null) {
					Report.updateTestLog(
							"Customer Name displayed successfully in ROW NO:"
									+ j + "COLUMN NO: " + 3 + "PAGE NO: " + i
									+ " " + td3, "PASS");
                } else {
					Report.updateTestLog("Customer Name  is empty in ROW NO:"
							+ j + "COLUMN NO: " + 3 + "PAGE NO: " + i + " "
							+ td3, "FAIL");
                }
				String td4 = browser.getTextByXpath(invoiceProperties
						.getProperty("BGBSearchInv.RowAcc")
						+ "tr["
						+ j
						+ "]/td[4]");
				if (td4.trim() != null) {
					Report.updateTestLog(
							"Account No displayed successfully in ROW NO:" + j
									+ "COLUMN NO: " + 4 + "PAGE NO: " + i + " "
									+ td4, "PASS");
                } else {
					Report.updateTestLog("Account No  is empty in ROW NO:" + j
							+ "COLUMN NO: " + 4 + "PAGE NO: " + i + " " + td4,
							"FAIL");
                }
				String td5 = browser.getTextByXpath(invoiceProperties
						.getProperty("BGBSearchInv.RowAcc")
						+ "tr["
						+ j
						+ "]/td[5]");
				if (td5.trim() != null) {
					Report.updateTestLog(
							"Site No displayed successfully in ROW NO:" + j
									+ "COLUMN NO: " + 5 + "PAGE NO: " + i + " "
									+ td5, "PASS");
                } else {
					Report.updateTestLog("Site No  is empty in ROW NO:" + j
							+ "COLUMN NO: " + 5 + "PAGE NO: " + i + " " + td5,
							"FAIL");
                }
				String td6 = browser.getTextByXpath(invoiceProperties
						.getProperty("BGBSearchInv.RowAcc")
						+ "tr["
						+ j
						+ "]/td[6]");
				if (td6.trim() != null) {
					Report.updateTestLog(
							"Site Name displayed successfully in ROW NO:" + j
									+ "COLUMN NO: " + 6 + "PAGE NO: " + i + " "
									+ td6, "PASS");
                } else {
					Report.updateTestLog("Site Name  is empty in ROW NO:" + j
							+ "COLUMN NO: " + 6 + "PAGE NO: " + i + " " + td6,
							"FAIL");
                }
				String td7 = browser.getTextByXpath(invoiceProperties
						.getProperty("BGBSearchInv.RowAcc")
						+ "tr["
						+ j
						+ "]/td[7]");
				if (td7.trim() != null) {
					Report.updateTestLog(
							"Invoice No displayed successfully in ROW NO:" + j
									+ "COLUMN NO: " + 7 + "PAGE NO: " + i + " "
									+ td7, "PASS");
                } else {
					Report.updateTestLog("Invoice No  is empty in ROW NO:" + j
							+ "COLUMN NO: " + 7 + "PAGE NO: " + i + " " + td7,
							"FAIL");
                }
				String td8 = browser.getTextByXpath(invoiceProperties
						.getProperty("BGBSearchInv.RowAcc")
						+ "tr["
						+ j
						+ "]/td[8]");
				if (td8.trim() != null) {
					Report.updateTestLog(
							"Total Value displayed successfully in ROW NO:" + j
									+ "COLUMN NO: " + 8 + "PAGE NO: " + i + " "
									+ td8, "PASS");
                } else {
					Report.updateTestLog("Total value  is empty in ROW NO:" + j
							+ "COLUMN NO: " + 8 + "PAGE NO: " + i + " " + td8,
							"FAIL");
                }
				// browser.wait(500);
        	}
			if (i > pagecount) {
				Report.updateTestLog(
						"Page Navigation Completed Total no of pages:   " + i,
						"DONE");

			} else {
    		browser.wait(3000);
				verifyAndClickWithXpath(
						invoiceProperties
								.getProperty("BGBSearchInv.paginationNext"),
						"Next Button Clicked");
        	browser.wait(4000);
    		}

        }

    }

	public void recordCountDBValidationAcc(String fromdate, String todate,
			String acc_cus_cont) {
		String RecordCount = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.RecordCount"));
		String split1[] = RecordCount.split("of");
		String intvalue[] = split1[1].split("transactions");
		String count = intvalue[0].trim();
		int RecordCount_Total = Integer.parseInt(count);

		accountManagerRecordCountAcc(fromdate, todate, acc_cus_cont,
				RecordCount_Total);

    }

	public void recordCountDBValidationCount(String fromdate, String todate,
			String acc_cus_cont) {
		String RecordCount = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.RecordCount"));
		String split1[] = RecordCount.split("of");
		String intvalue[] = split1[1].split("transactions");
		String count = intvalue[0].trim();
		int RecordCount_Total = Integer.parseInt(count);

		accountManagerRecordCount(fromdate, todate, acc_cus_cont,
				RecordCount_Total);

    }

	public void recordCountDBValidationCon(String fromdate, String todate,
			String acc_cus_cont) {
		String RecordCount = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.RecordCount"));
		String split1[] = RecordCount.split("of");
		String intvalue[] = split1[1].split("transactions");
		String count = intvalue[0].trim();
		int RecordCount_Total = Integer.parseInt(count);

		accountManagerRecordCountNew(fromdate, todate, acc_cus_cont,
				RecordCount_Total);

    }

	public RegistrationAction accountManagerRecordCountAcc(String fromdate,
			String todate, String ACCNo, int RecordCount_Total) {

		String strQuery1 = "DROP TABLE Contract_Temp"
				+ "    			CREATE TABLE Contract_Temp ("
				+ "    						CONTRACT_NO				VARCHAR(50),"
				+ "    						CD_EXT_CONTRACT_SYSTEM	VARCHAR(50),"
				+ "    						FK_ID_ACCOUNT				BIGINT,"
				+ "    						FK_ID_SITE				    BIGINT,"
				+ "    						FK_ID_CUSTOMER				BIGINT	"
				+ "    					)"
				+ "    			INSERT INTO Contract_Temp "
				+ "    						(CONTRACT_NO,CD_EXT_CONTRACT_SYSTEM,FK_ID_ACCOUNT,FK_ID_SITE,FK_ID_CUSTOMER)"
				+ "    			SELECT "
				+ "    								MAX(Cont.REF_EXT_CONTRACT_IDENTIFIER) AS CONTRACT_NO,"
				+ "    								Cont.CD_EXT_CONTRACT_SYSTEM, Acc.ID_ACCOUNT as FK_ID_ACCOUNT, NULL AS FK_ID_SITE, NULL AS FK_ID_CUSTOMER "
				+ "    							FROM "
				+ "    							BGB_Synergy.dbo.T_CONTRACT_SITE (NOLOCK) ContSite"
				+ "    							INNER JOIN BGB_Synergy.dbo.T_CONTRACT (NOLOCK) Cont ON ContSite.FK_ID_CONTRACT = Cont.ID_CONTRACT AND Cont.IND_ACTIVE_STATUS = 'Y' "
				+ "    							INNER JOIN BGB_Synergy.dbo.T_Account Acc (NOLOCK) ON ContSite.FK_ID_ACCOUNT = Acc.ID_ACCOUNT AND Acc.IND_ACTIVE_STATUS ='Y'"
				+ "    							WHERE Acc.REF_EXT_ACCOUNT_IDENTIFIER = '" + ACCNo
				+ "'" + "    							GROUP BY "
				+ "    								Cont.CD_EXT_CONTRACT_SYSTEM ,Acc.ID_ACCOUNT	";
		String strQuery2 = "set dateformat ymd"
				+ "    			 SELECT "
				+ "    							count(*)  "
				+ "    						FROM "
				+ "    							BGB_Synergy.dbo.T_INVOICE INV (NOLOCK)"
				+ "    						INNER JOIN BGB_Synergy.dbo.T_Account Acc (NOLOCK) ON INV.FK_ID_ACCOUNT = Acc.ID_ACCOUNT AND Acc.IND_ACTIVE_STATUS ='Y'"
				+ "    						INNER JOIN BGB_Synergy.dbo.T_SITE Site (NOLOCK) ON INV.FK_ID_SITE = Site.ID_SITE AND Site.IND_ACTIVE_STATUS ='Y' "
				+ "    						INNER JOIN BGB_Synergy.dbo.T_Customer Cust (NOLOCK) ON Cust.ID_CUSTOMER = Acc.FK_ID_CUSTOMER AND Cust.IND_ACTIVE_STATUS ='Y'"
				+ "    								AND Cust.FK_CD_CUSTOMER_SEGMENT = 'MS' "
				+ "    						INNER JOIN Contract_Temp ContTemp ON ContTemp.FK_ID_ACCOUNT = Acc.ID_ACCOUNT INNER JOIN BGB_Synergy.dbo.T_CONTRACT (NOLOCK) Cont "
				+ "    						ON ContTemp.CONTRACT_NO = Cont.REF_EXT_CONTRACT_IDENTIFIER "
				+ "    							AND ContTemp.CD_EXT_CONTRACT_SYSTEM = Cont.CD_EXT_CONTRACT_SYSTEM  "
				+ "    							WHERE "
				+ "    							Acc.REF_EXT_ACCOUNT_IDENTIFIER = '" + ACCNo
				+ "' AND "
				+ "    							((Cont.DT_CONTRACT_END BETWEEN DATEADD(M,-6,'"
				+ todate + "') AND '" + todate + "') OR"
				+ "    																	Cont.DT_CONTRACT_END >= '" + todate
				+ "') AND " + "    						(INV.DT_INVOICE BETWEEN '" + fromdate
				+ "' AND '" + todate + "') AND (INV.DETAIL_COUNT > 0) AND"
				+ "    						 (Site.REF_EXT_SITE_IDENTIFIER <> 0) "
				+ "    			GROUP BY "
				+ "    					Acc.REF_EXT_ACCOUNT_IDENTIFIER ";

        		updateQuerySynergy(strQuery1);

       int regRowCount = executeQuerySynergy(strQuery2);
		if (regRowCount == RecordCount_Total) {
			Report.updateTestLog(
					"Records Count Matches successfully in DB Actual Count is: "
							+ RecordCount_Total + " and Expected count is "
							+ regRowCount + "", "PASS");
		} else {
			Report.updateTestLog(
					"Records Count Matches Failure Actual Count is: "
							+ RecordCount_Total + " and Expected count is "
							+ regRowCount + "", "FAIL");

        }

		return null;
    }

	public RegistrationAction accountManagerRecordCount(String fromdate,
			String todate, String contractNo, int RecordCount_Total) {

		String strQuery = " set dateformat ymd"
				+ " SELECT "
				+ "		count(*)"
				+ "	FROM "
				+ "		BGB_Synergy.dbo.T_INVOICE INV (NOLOCK)"
				+ "	INNER JOIN BGB_Synergy.dbo.T_Account Acc (NOLOCK) ON INV.FK_ID_ACCOUNT = Acc.ID_ACCOUNT AND Acc.IND_ACTIVE_STATUS ='Y'"
				+ "	INNER JOIN BGB_Synergy.dbo.T_SITE Site (NOLOCK) ON INV.FK_ID_SITE = Site.ID_SITE AND Site.IND_ACTIVE_STATUS ='Y' "
				+ "	INNER JOIN BGB_Synergy.dbo.T_Customer Cust (NOLOCK) ON Cust.ID_CUSTOMER = Acc.FK_ID_CUSTOMER AND Cust.IND_ACTIVE_STATUS ='Y'"
				+ "			AND Cust.FK_CD_CUSTOMER_SEGMENT = 'MS' INNER JOIN BGB_Synergy.dbo.T_CONTRACT_SITE ContSite (NOLOCK) "
				+ "					ON ContSite.FK_ID_ACCOUNT = ACC.ID_ACCOUNT "
				+ "							AND ContSite.FK_ID_SITE = Site.ID_SITE"
				+ "				   INNER JOIN BGB_Synergy.dbo.T_CONTRACT Cont (NOLOCK) "
				+ "						ON ContSite.FK_ID_CONTRACT = Cont.ID_CONTRACT   "
				+ "			WHERE "
				+ "			Cont.REF_EXT_CONTRACT_IDENTIFIER = '"
				+ contractNo
				+ "' AND"
				+ "			((Cont.DT_CONTRACT_END BETWEEN DATEADD(M,-6,'"
				+ todate
				+ "') AND '"
				+ todate
				+ "') OR Cont.DT_CONTRACT_END >= '"
				+ todate
				+ "') "
				+ "			AND (INV.DT_INVOICE BETWEEN '"
				+ fromdate
				+ "' AND '"
				+ todate
				+ "') "
				+ "			AND (INV.DETAIL_COUNT > 0) AND (Site.REF_EXT_SITE_IDENTIFIER <> 0) ";

        int regRowCount = executeQuerySynergy(strQuery);
		if (regRowCount == RecordCount_Total) {
			Report.updateTestLog(
					"Records Count Matches successfully in DB Actual Count is: "
							+ RecordCount_Total + " and Expected count is "
							+ regRowCount + "", "PASS");
		} else {
			Report.updateTestLog(
					"Records Count Matches Failure Actual Count is: "
							+ RecordCount_Total + " and Expected count is "
							+ regRowCount + "", "FAIL");

        }

		return null;
    }

	public RegistrationAction accountManagerRecordCountNew(String fromdate,
			String todate, String CusName, int RecordCount_Total) {

		String strQuery1 = "DROP table Contract_Temp "
				+ "         CREATE TABLE Contract_Temp ("
				+ "			CONTRACT_NO				VARCHAR(50),"
				+ "			CD_EXT_CONTRACT_SYSTEM	VARCHAR(50),"
				+ "			FK_ID_ACCOUNT				BIGINT,"
				+ "			FK_ID_SITE				    BIGINT,"
				+ "			FK_ID_CUSTOMER				BIGINT	"
				+ "		)"
				+ "INSERT INTO Contract_Temp "
				+ "			(CONTRACT_NO,CD_EXT_CONTRACT_SYSTEM,FK_ID_ACCOUNT,FK_ID_SITE,FK_ID_CUSTOMER)"
				+ "				SELECT "
				+ "					MAX(Cont.REF_EXT_CONTRACT_IDENTIFIER) AS CONTRACT_NO,"
				+ "					Cont.CD_EXT_CONTRACT_SYSTEM, NULL AS FK_ID_ACCOUNT, NULL AS FK_ID_SITE, Cust.ID_CUSTOMER as FK_ID_CUSTOMER "
				+ "				FROM "
				+ "				BGB_Synergy.dbo.T_CONTRACT_SITE (NOLOCK) ContSite"
				+ "				INNER JOIN BGB_Synergy.dbo.T_CONTRACT (NOLOCK) Cont ON ContSite.FK_ID_CONTRACT = Cont.ID_CONTRACT AND Cont.IND_ACTIVE_STATUS = 'Y' "
				+ "				INNER JOIN BGB_Synergy.dbo.T_Account Acc (NOLOCK) ON ContSite.FK_ID_ACCOUNT = Acc.ID_ACCOUNT AND Acc.IND_ACTIVE_STATUS ='Y' "
				+ "				INNER JOIN BGB_Synergy.dbo.T_Customer Cust  (NOLOCK) ON Cust.ID_CUSTOMER = Acc.FK_ID_CUSTOMER and Cust.IND_ACTIVE_STATUS ='Y' "
				+ "				WHERE " + "					Cust.TXT_CUSTOMER_NAME LIKE '" + CusName
				+ "' " + "				GROUP BY "
				+ "					Cont.CD_EXT_CONTRACT_SYSTEM ,Cust.ID_CUSTOMER";
		String strQuery2 = "set dateformat ymd "
				+ "SELECT"
				+ " count(*) "
				+ " FROM"
				+ " BGB_Synergy.dbo.T_INVOICE INV (NOLOCK)"
				+ " INNER JOIN BGB_Synergy.dbo.T_Account Acc (NOLOCK) ON INV.FK_ID_ACCOUNT = Acc.ID_ACCOUNT AND Acc.IND_ACTIVE_STATUS ='Y'"
				+ " INNER JOIN BGB_Synergy.dbo.T_SITE Site (NOLOCK) ON INV.FK_ID_SITE = Site.ID_SITE AND Site.IND_ACTIVE_STATUS ='Y'"
				+ " INNER JOIN BGB_Synergy.dbo.T_Customer Cust (NOLOCK) ON Cust.ID_CUSTOMER = Acc.FK_ID_CUSTOMER AND Cust.IND_ACTIVE_STATUS ='Y'"
				+ " AND Cust.FK_CD_CUSTOMER_SEGMENT = 'MS' INNER JOIN Contract_Temp ContTemp ON ContTemp.FK_ID_CUSTOMER = Cust.ID_CUSTOMER INNER JOIN BGB_Synergy.dbo.T_CONTRACT (NOLOCK) Cont"
				+ " ON ContTemp.CONTRACT_NO = Cont.REF_EXT_CONTRACT_IDENTIFIER"
				+ " AND ContTemp.CD_EXT_CONTRACT_SYSTEM = Cont.CD_EXT_CONTRACT_SYSTEM"
				+ " WHERE"
				+ " Cust.TXT_CUSTOMER_NAME='"
				+ CusName
				+ "' AND"
				+ " ((Cont.DT_CONTRACT_END BETWEEN DATEADD(M,-6,'"
				+ todate
				+ "') AND '"
				+ todate
				+ "') OR Cont.DT_CONTRACT_END >= '"
				+ todate
				+ "')"
				+ " AND (INV.DT_INVOICE BETWEEN '"
				+ fromdate
				+ "' AND '"
				+ todate
				+ "')"
				+ " AND (INV.DETAIL_COUNT > 0) AND (Site.REF_EXT_SITE_IDENTIFIER <> 0)";

        		updateQuerySynergy(strQuery1);

       int regRowCount = executeQuerySynergy(strQuery2);
		if (regRowCount == RecordCount_Total) {
			Report.updateTestLog(
					"Records Count Matches successfully in DB Actual Count is: "
							+ RecordCount_Total + " and Expected count is "
							+ regRowCount + "", "PASS");
		} else {
			Report.updateTestLog(
					"Records Count Matches Failure Actual Count is: "
							+ RecordCount_Total + " and Expected count is "
							+ regRowCount + "", "FAIL");

        }

		return null;
    }

	public void clickDownloadPDF() {
		verifyAndClick(
				invoiceProperties.getProperty("BGBSearchInv.downloadPDF"),
				"Download Invoice Button");

    }

	public void pdfDownload() throws AWTException {
		verifyAndClickWithXpath(
				invoiceProperties.getProperty("BGBSearchInv.Firstcheckbox"),
				"CheckBox Clicked");
		verifyAndClick(
				invoiceProperties.getProperty("BGBSearchInv.downloadPDF"),
				"Download Invoice Button");
		// if(verifyIsElementVisibleWithXpath("BGBSearchInv.PDFdownloaderror",
		// "PDFerror"))
		// String errormess=browser.get
		if (verifyIsTextPresent("We are sorry but there is a problem with some of the information you have submitted.")) {
    		Report.updateFile("Selected Record do not have PDF", "PASS");
		} else {
    	  Report.updateFile("PDF available for the selected Record", "PASS");
			Robot robot = new Robot();
    	 // robot.delay(5000);
			// robot.keyPress(KeyEvent.VK_DOWN);
    	 // robot.keyRelease(KeyEvent.VK_DOWN);
    	  robot.delay(5000);
    	  robot.keyPress(KeyEvent.VK_ENTER);
			// robot.keyRelease(KeyEvent.VK_ENTER);
    	  robot.delay(1000);

    	}
    }

    private int totalRowsRetrived() {
		String rowDetail = browser.getTextByXpath(invoiceProperties
				.getProperty("BGBSearchInv.totalTransAction"));
        String[] splitTotal = rowDetail.split(" ");
        return Integer.parseInt(splitTotal[5]);
    }

    private String currentDate() {
        SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return simple.format(calendar.getTime());
    }

    public String downloadInvoicePage() {
		// RobotSendKeys sendKeys = new RobotSendKeys();
        String testPath;// System.getProperty("user.dir");
        browser.wait(3000);
        testPath = "C:\\Invoice";
        RobotSendKeys.altS();
        browser.wait(3000);
        RobotSendKeys.typeenter();
        browser.wait(3000);
        RobotSendKeys.type(testPath);
        browser.wait(3000);
		// RobotSendKeys.typeenter();
        RobotSendKeys.altS();
        RobotSendKeys.altY();
        browser.wait(3000);
        RobotSendKeys.releseShift();
        browser.wait(3000);
        return testPath;

    }

    public void verifyPdfInvoice(String testPath) throws PdfException {
        PdfReader r;
        try {
            r = PdfReader.fileReader(testPath + ".pdf");
            PdfDocument d1 = new PdfDocument(r);
            String[] invoiceNo = new String[3];
            List textPdf = d1.extractText(1);
			if (textPdf.toString()
					.contains("This is a certified and true copy")) {
                Report.updateTestLog("Invoice PDF Saved successfully", "PASS");
            } else {
                Report.updateTestLog("Invoice PDF Saved successfully", "FAIL");
            }
            int count = browser.getRowCountByXpath("//table");
            if (count > 3) {
                count = 3;
            }
            for (int i = 0; i < count; i++) {
				invoiceNo[i] = browser.getCellValueByXpath(invoiceProperties
						.getProperty("BGBSearchInv.tblResults"), i + 1, 7);
                if (i == 0) {
                    if (textPdf.toString().contains(invoiceNo[i])) {
						Report.updateTestLog("Invoice no " + invoiceNo[i]
								+ " Exist in PDF", "PASS");
                    } else {
						Report.updateTestLog("Invoice no " + invoiceNo[i]
								+ " Not Exist in PDF", "FAIL");
                    }
                }
                if (i == 1 && count > 1) {
                    textPdf = d1.extractText(3);
                    if (textPdf.toString().contains(invoiceNo[i])) {
						Report.updateTestLog("Invoice no " + invoiceNo[i]
								+ " Exist in PDF", "PASS");
                    } else {
						Report.updateTestLog("Invoice no " + invoiceNo[i]
								+ " Not Exist in PDF", "FAIL");
                    }
                }

                if (i == 2 && count > 2) {
                    textPdf = d1.extractText(6);
                    if (textPdf.toString().contains(invoiceNo[i])) {
						Report.updateTestLog("Invoice no " + invoiceNo[i]
								+ " Exist in PDF", "PASS");
                    } else {
						Report.updateTestLog("Invoice no " + invoiceNo[i]
								+ " Not Exist in PDF", "FAIL");
                    }
                }

            }
            r.dispose();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void verifyDownloadPDFError() {
        browser.click(invoiceProperties.getProperty("BGBSearchInv.downloadPDF"));
		// Error verification yet to be done

    }
}
