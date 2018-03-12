package bg.framework.app.functional.page.selfServe;

import java.util.Properties;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.internal.seleniumemulation.WaitForPageToLoad;

import bg.framework.app.functional.action.sales.AcquisitionAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class CAPersonalDetailsPage extends BasePage {
	// private final static String FILE_NAME =
	// "resources/sales/"+ApplicationConfig.BRAND+"Acquisition.properties";
	/*
	 * private final static String FILE_NAME =
	 * "resources/ReFactoring/BGAcquisition.properties"; private static
	 * Properties pageProperties = new PropertyLoader(FILE_NAME) .load();
	 */

	private final static String FILE_NAME = "resources/selfServe/CAPersonalDetailsPage.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME)
			.load();

	public CAPersonalDetailsPage() {

	}

	public CAPersonalDetailsPage(Acquisition acquisition) {
	}

	public CAPersonalDetailsPage(UserProfile userProfile) {
	}

	public AcquisitionAction errorpersonalDetailsPage(Acquisition acquisition) {

		validateTitlePersonalDetailsPage(acquisition);
		validateFirstNamePersonalDetailsPage();
		validateLastNamePersonalDetailsPage();
		validateDayPersonalDetailsPage();
		validateMonthPersonalDetailsPage();
		validateYearPersonalDetailsPage();
		validateTelephoneNumberPersonalDetailsPage();
		validateTelephoneTypePersonalDetailsPage();
		validateEmailAddressPersonalDetailsPage();
		validateEmailTypePersonalDetailsPage();
		validatePostCodePersonalDetailsPage();
		validateYearsLivedPersonalDetailsPage();
		validateMonthsLivedPersonalDetailsPage();
		return new AcquisitionAction();
	}

	public void validateTitlePersonalDetailsPage(final Acquisition acquisition) {

		String titleerror;

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.FirstName"))) {
			browser.input(pageProperties.getProperty("Acquisition.FirstName"),
					acquisition.getFirstName());
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.LastName"))) {
			browser.input(pageProperties.getProperty("Acquisition.LastName"),
					acquisition.getLastName());
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Day"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Day"),
					acquisition.getDay());
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Month"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Month"),
					acquisition.getMonth());
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Year"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Year"),
					acquisition.getYear());
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.TelephoneNumber"))) {
			browser.input(
					pageProperties.getProperty("Acquisition.TelephoneNumber"),
					acquisition.getMobileNumber());
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.TelephoneType"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.TelephoneType"),
					acquisition.getTelephonetype());
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.EmailAddress"))) {
			browser.input(
					pageProperties.getProperty("Acquisition.EmailAddress"),
					acquisition.getEmail());
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.EmailType"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.EmailType"),
					acquisition.getEmailtype());
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Postcode"))) {
			browser.input(pageProperties.getProperty("Acquisition.Postcode"),
					acquisition.getPostcode());
		}
		if (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("Acquisition.SearchLink"))) {
			browser.clickWithXpath(pageProperties
					.getProperty("Acquisition.SearchLink"));
		}
		try {
			Thread.sleep(5000);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		if (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("Acquisition.AddressList"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.AddressList"),
					acquisition.getAddress());
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.MonthsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.MonthsLived"),
					acquisition.getMonthsLived());
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.YearsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.YearsLived"),
					acquisition.getYearsLived());
		}
		browser.clickWithXpath(pageProperties
				.getProperty("Acquisition.PersonalDetailsContinue"));

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Error"))) {
			titleerror = browser.getText(pageProperties
					.getProperty("Acquisition.Error"));
			Report.updateTestLog("Supplier Field Validation" + titleerror,
					"PASS");
		} else {
			Report.updateTestLog("Supplier Field Validation", "FAIL");
		}

	}

	public void validateFirstNamePersonalDetailsPage() {
		String firstname;
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Title"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Title"), "Mr");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.LastName"))) {
			browser.input(pageProperties.getProperty("Acquisition.LastName"),
					"tester");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Day"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Day"), "3");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Month"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Month"), "January");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Year"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Year"), "1989");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.TelephoneNumber"))) {
			browser.input(
					pageProperties.getProperty("Acquisition.TelephoneNumber"),
					"0123456789");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.TelephoneType"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.TelephoneType"),
					"1989");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.EmailAddress"))) {
			browser.input(
					pageProperties.getProperty("Acquisition.EmailAddress"),
					"rudhraaan@bgdigitaltest.co.uk");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.EmailType"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.EmailType"), "Work");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Postcode"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Postcode"),
					"rm38xb");
		}
		browser.click(pageProperties.getProperty("Acquisition.SearchLink"));
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.AddressList"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.AddressList"),
					"Andrew Mark Aluminium, 1-2, Langley Close, ROMFORD, Essex, RM3 8XB");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.YearsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.YearsLived"), "5");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.MonthsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.MonthsLived"), "3");
		}
		browser.click(pageProperties
				.getProperty("Acquisition.PersonalDetailsContinue"));

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Error"))) {
			firstname = browser.getText(pageProperties
					.getProperty("Acquisition.Error"));
			Report.updateTestLog("Supplier Field Validation" + firstname,
					"PASS");
		} else {
			Report.updateTestLog("Supplier Field Validation", "FAIL");
		}
	}

	public void validateLastNamePersonalDetailsPage() {
		String lastNameError;
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Title"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Title"), "Mr");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.FirstName"))) {
			browser.input(pageProperties.getProperty("Acquisition.FirstName"),
					"tester");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Day"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Day"), "3");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Month"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Month"), "January");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Year"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Year"), "1989");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.TelephoneNumber"))) {
			browser.input(
					pageProperties.getProperty("Acquisition.TelephoneNumber"),
					"0123456789");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.TelephoneType"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.TelephoneType"),
					"1989");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.EmailAddress"))) {
			browser.input(
					pageProperties.getProperty("Acquisition.EmailAddress"),
					"rudhraaan@bgdigitaltest.co.uk");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.EmailType"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.EmailType"), "Work");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Postcode"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Postcode"),
					"rm38xb");
		}
		browser.click(pageProperties.getProperty("Acquisition.SearchLink"));
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.AddressList"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.AddressList"),
					"Andrew Mark Aluminium, 1-2, Langley Close, ROMFORD, Essex, RM3 8XB");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.YearsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.YearsLived"), "5");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.MonthsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.MonthsLived"), "3");
		}
		browser.click(pageProperties
				.getProperty("Acquisition.PersonalDetailsContinue"));
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Error"))) {
			lastNameError = browser.getText(pageProperties
					.getProperty("Acquisition.Error"));
			Report.updateTestLog("Supplier Field Validation" + lastNameError,
					"PASS");
		} else {
			Report.updateTestLog("Supplier Field Validation", "FAIL");
		}
	}

	public void validateDayPersonalDetailsPage() {
		String Dayerrorcapture;
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Title"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Title"), "Mr");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.FirstName"))) {
			browser.input(pageProperties.getProperty("Acquisition.FirstName"),
					"tester");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.LastName"))) {
			browser.input(pageProperties.getProperty("Acquisition.LastName"),
					"tester");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Month"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Month"), "January");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Year"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Year"), "1989");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.TelephoneNumber"))) {
			browser.input(
					pageProperties.getProperty("Acquisition.TelephoneNumber"),
					"0123456789");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.TelephoneType"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.TelephoneType"),
					"1989");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.EmailAddress"))) {
			browser.input(
					pageProperties.getProperty("Acquisition.EmailAddress"),
					"rudhraaan@bgdigitaltest.co.uk");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.EmailType"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.EmailType"), "Work");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Postcode"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Postcode"),
					"rm38xb");
		}
		browser.click(pageProperties.getProperty("Acquisition.SearchLink"));
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.AddressList"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.AddressList"),
					"Andrew Mark Aluminium, 1-2, Langley Close, ROMFORD, Essex, RM3 8XB");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.YearsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.YearsLived"), "5");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.MonthsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.MonthsLived"), "3");
		}
		browser.click(pageProperties
				.getProperty("Acquisition.PersonalDetailsContinue"));
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Error"))) {
			Dayerrorcapture = browser.getText(pageProperties
					.getProperty("Acquisition.Error"));
			Report.updateTestLog("Supplier Field Validation" + Dayerrorcapture,
					"PASS");
		} else {
			Report.updateTestLog("Supplier Field Validation", "FAIL");
		}
	}

	public void validateMonthPersonalDetailsPage() {
		String Montherrorcapture;
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Title"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Title"), "Mr");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.FirstName"))) {
			browser.input(pageProperties.getProperty("Acquisition.FirstName"),
					"tester");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.LastName"))) {
			browser.input(pageProperties.getProperty("Acquisition.LastName"),
					"tester");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Day"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Day"), "3");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Year"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Year"), "1989");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.TelephoneNumber"))) {
			browser.input(
					pageProperties.getProperty("Acquisition.TelephoneNumber"),
					"0123456789");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.TelephoneType"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.TelephoneType"),
					"1989");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.EmailAddress"))) {
			browser.input(
					pageProperties.getProperty("Acquisition.EmailAddress"),
					"rudhraaan@bgdigitaltest.co.uk");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.EmailType"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.EmailType"), "Work");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Postcode"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Postcode"),
					"rm38xb");
		}
		browser.click(pageProperties.getProperty("Acquisition.SearchLink"));
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.AddressList"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.AddressList"),
					"Andrew Mark Aluminium, 1-2, Langley Close, ROMFORD, Essex, RM3 8XB");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.YearsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.YearsLived"), "5");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.MonthsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.MonthsLived"), "3");
		}
		browser.click(pageProperties
				.getProperty("Acquisition.PersonalDetailsContinue"));
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Error"))) {
			Montherrorcapture = browser.getText(pageProperties
					.getProperty("Acquisition.Error"));
			Report.updateTestLog("Supplier Field Validation"
					+ Montherrorcapture, "PASS");
		} else {
			Report.updateTestLog("Supplier Field Validation", "FAIL");
		}
	}

	public void validateYearPersonalDetailsPage() {
		String Yearerrorcapture;
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Title"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Title"), "Mr");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.FirstName"))) {
			browser.input(pageProperties.getProperty("Acquisition.FirstName"),
					"tester");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.LastName"))) {
			browser.input(pageProperties.getProperty("Acquisition.LastName"),
					"tester");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Day"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Day"), "3");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Month"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Month"), "January");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.TelephoneNumber"))) {
			browser.input(
					pageProperties.getProperty("Acquisition.TelephoneNumber"),
					"0123456789");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.TelephoneType"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.TelephoneType"),
					"1989");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.EmailAddress"))) {
			browser.input(
					pageProperties.getProperty("Acquisition.EmailAddress"),
					"rudhraaan@bgdigitaltest.co.uk");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.EmailType"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.EmailType"), "Work");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Postcode"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Postcode"),
					"rm38xb");
		}
		browser.click(pageProperties.getProperty("Acquisition.SearchLink"));
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.AddressList"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.AddressList"),
					"Andrew Mark Aluminium, 1-2, Langley Close, ROMFORD, Essex, RM3 8XB");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.YearsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.YearsLived"), "5");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.MonthsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.MonthsLived"), "3");
		}
		browser.click(pageProperties
				.getProperty("Acquisition.PersonalDetailsContinue"));
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Error"))) {
			Yearerrorcapture = browser.getText(pageProperties
					.getProperty("Acquisition.Error"));
			Report.updateTestLog(
					"Supplier Field Validation" + Yearerrorcapture, "PASS");
		} else {
			Report.updateTestLog("Supplier Field Validation", "FAIL");
		}
	}

	public void validateTelephoneNumberPersonalDetailsPage() {
		String Yearerrorcapture;
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Title"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Title"), "Mr");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.FirstName"))) {
			browser.input(pageProperties.getProperty("Acquisition.FirstName"),
					"tester");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.LastName"))) {
			browser.input(pageProperties.getProperty("Acquisition.LastName"),
					"tester");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Day"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Day"), "3");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Month"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Month"), "January");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Year"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Year"), "1989");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.TelephoneType"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.TelephoneType"),
					"1989");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.EmailAddress"))) {
			browser.input(
					pageProperties.getProperty("Acquisition.EmailAddress"),
					"rudhraaan@bgdigitaltest.co.uk");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.EmailType"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.EmailType"), "Work");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Postcode"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Postcode"),
					"rm38xb");
		}
		browser.click(pageProperties.getProperty("Acquisition.SearchLink"));
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.AddressList"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.AddressList"),
					"Andrew Mark Aluminium, 1-2, Langley Close, ROMFORD, Essex, RM3 8XB");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.YearsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.YearsLived"), "5");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.MonthsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.MonthsLived"), "3");
		}
		browser.click(pageProperties
				.getProperty("Acquisition.PersonalDetailsContinue"));
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Error"))) {
			Yearerrorcapture = browser.getText(pageProperties
					.getProperty("Acquisition.Error"));
			Report.updateTestLog(
					"Supplier Field Validation" + Yearerrorcapture, "PASS");
		} else {
			Report.updateTestLog("Supplier Field Validation", "FAIL");
		}
	}

	public void validateTelephoneTypePersonalDetailsPage() {
		String telephoneerror;
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Title"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Title"), "Mr");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.FirstName"))) {
			browser.input(pageProperties.getProperty("Acquisition.FirstName"),
					"tester");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.LastName"))) {
			browser.input(pageProperties.getProperty("Acquisition.LastName"),
					"tester");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Day"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Day"), "3");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Month"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Month"), "January");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Year"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Year"), "1989");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.TelephoneNumber"))) {
			browser.input(
					pageProperties.getProperty("Acquisition.TelephoneNumber"),
					"0123456789");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.EmailAddress"))) {
			browser.input(
					pageProperties.getProperty("Acquisition.EmailAddress"),
					"rudhraaan@bgdigitaltest.co.uk");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.EmailType"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.EmailType"), "Work");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Postcode"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Postcode"),
					"rm38xb");
		}
		browser.click(pageProperties.getProperty("Acquisition.SearchLink"));
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.AddressList"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.AddressList"),
					"Andrew Mark Aluminium, 1-2, Langley Close, ROMFORD, Essex, RM3 8XB");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.YearsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.YearsLived"), "5");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.MonthsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.MonthsLived"), "3");
		}
		browser.click(pageProperties
				.getProperty("Acquisition.PersonalDetailsContinue"));
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Error"))) {
			telephoneerror = browser.getText(pageProperties
					.getProperty("Acquisition.Error"));
			Report.updateTestLog("Supplier Field Validation" + telephoneerror,
					"PASS");
		} else {
			Report.updateTestLog("Supplier Field Validation", "FAIL");
		}
	}

	public void validateEmailAddressPersonalDetailsPage() {
		String emailerrormessage;
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Title"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Title"), "Mr");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.FirstName"))) {
			browser.input(pageProperties.getProperty("Acquisition.FirstName"),
					"tester");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.LastName"))) {
			browser.input(pageProperties.getProperty("Acquisition.LastName"),
					"tester");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Day"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Day"), "3");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Month"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Month"), "January");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Year"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Year"), "1989");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.TelephoneNumber"))) {
			browser.input(
					pageProperties.getProperty("Acquisition.TelephoneNumber"),
					"0123456789");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.TelephoneType"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.TelephoneType"),
					"1989");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.EmailType"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.EmailType"), "Work");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Postcode"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Postcode"),
					"rm38xb");
		}
		browser.click(pageProperties.getProperty("Acquisition.SearchLink"));
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.AddressList"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.AddressList"),
					"Andrew Mark Aluminium, 1-2, Langley Close, ROMFORD, Essex, RM3 8XB");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.YearsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.YearsLived"), "5");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.MonthsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.MonthsLived"), "3");
		}
		browser.click(pageProperties
				.getProperty("Acquisition.PersonalDetailsContinue"));
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Error"))) {
			emailerrormessage = browser.getText(pageProperties
					.getProperty("Acquisition.Error"));
			Report.updateTestLog("Supplier Field Validation"
					+ emailerrormessage, "PASS");
		} else {
			Report.updateTestLog("Supplier Field Validation", "FAIL");
		}
	}

	public void validateEmailTypePersonalDetailsPage() {
		String emailTypeerror;
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Title"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Title"), "Mr");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.FirstName"))) {
			browser.input(pageProperties.getProperty("Acquisition.FirstName"),
					"tester");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.LastName"))) {
			browser.input(pageProperties.getProperty("Acquisition.LastName"),
					"tester");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Day"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Day"), "3");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Month"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Month"), "January");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Year"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Year"), "1989");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.TelephoneNumber"))) {
			browser.input(
					pageProperties.getProperty("Acquisition.TelephoneNumber"),
					"0123456789");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.TelephoneType"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.TelephoneType"),
					"1989");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.EmailAddress"))) {
			browser.input(
					pageProperties.getProperty("Acquisition.EmailAddress"),
					"rudhraaan@bgdigitaltest.co.uk");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Postcode"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Postcode"),
					"rm38xb");
		}
		browser.click(pageProperties.getProperty("Acquisition.SearchLink"));
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.AddressList"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.AddressList"),
					"Andrew Mark Aluminium, 1-2, Langley Close, ROMFORD, Essex, RM3 8XB");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.YearsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.YearsLived"), "5");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.MonthsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.MonthsLived"), "3");
		}
		browser.click(pageProperties
				.getProperty("Acquisition.PersonalDetailsContinue"));
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Error"))) {
			emailTypeerror = browser.getText(pageProperties
					.getProperty("Acquisition.Error"));
			Report.updateTestLog("Supplier Field Validation" + emailTypeerror,
					"PASS");
		} else {
			Report.updateTestLog("Supplier Field Validation", "FAIL");
		}
	}

	public void validatePostCodePersonalDetailsPage() {
		String postCodeError;
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Title"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Title"), "Mr");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.FirstName"))) {
			browser.input(pageProperties.getProperty("Acquisition.FirstName"),
					"tester");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.LastName"))) {
			browser.input(pageProperties.getProperty("Acquisition.LastName"),
					"tester");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Day"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Day"), "3");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Month"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Month"), "January");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Year"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Year"), "1989");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.TelephoneNumber"))) {
			browser.input(
					pageProperties.getProperty("Acquisition.TelephoneNumber"),
					"0123456789");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.TelephoneType"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.TelephoneType"),
					"1989");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.EmailAddress"))) {
			browser.input(
					pageProperties.getProperty("Acquisition.EmailAddress"),
					"rudhraaan@bgdigitaltest.co.uk");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.EmailType"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.EmailType"), "Work");
		}
		browser.click(pageProperties.getProperty("Acquisition.SearchLink"));
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.AddressList"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.AddressList"),
					"Andrew Mark Aluminium, 1-2, Langley Close, ROMFORD, Essex, RM3 8XB");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.YearsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.YearsLived"), "5");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.MonthsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.MonthsLived"), "3");
		}
		browser.click(pageProperties
				.getProperty("Acquisition.PersonalDetailsContinue"));
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Error"))) {
			postCodeError = browser.getText(pageProperties
					.getProperty("Acquisition.Error"));
			Report.updateTestLog("Supplier Field Validation" + postCodeError,
					"PASS");
		} else {
			Report.updateTestLog("Supplier Field Validation", "FAIL");
		}
	}

	public void validateMonthsLivedPersonalDetailsPage() {
		String monthsLived;
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Title"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Title"), "Mr");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.FirstName"))) {
			browser.input(pageProperties.getProperty("Acquisition.FirstName"),
					"tester");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.LastName"))) {
			browser.input(pageProperties.getProperty("Acquisition.LastName"),
					"tester");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Day"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Day"), "3");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Month"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Month"), "January");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Year"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Year"), "1989");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.TelephoneNumber"))) {
			browser.input(
					pageProperties.getProperty("Acquisition.TelephoneNumber"),
					"0123456789");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.TelephoneType"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.TelephoneType"),
					"1989");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.EmailAddress"))) {
			browser.input(
					pageProperties.getProperty("Acquisition.EmailAddress"),
					"rudhraaan@bgdigitaltest.co.uk");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.EmailType"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.EmailType"), "Work");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Postcode"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Postcode"),
					"rm38xb");
		}
		browser.click(pageProperties.getProperty("Acquisition.SearchLink"));
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.AddressList"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.AddressList"),
					"Andrew Mark Aluminium, 1-2, Langley Close, ROMFORD, Essex, RM3 8XB");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.YearsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.YearsLived"), "5");
		}
		browser.click(pageProperties
				.getProperty("Acquisition.PersonalDetailsContinue"));
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Error"))) {
			monthsLived = browser.getText(pageProperties
					.getProperty("Acquisition.Error"));
			Report.updateTestLog("Supplier Field Validation" + monthsLived,
					"PASS");
		} else {
			Report.updateTestLog("Supplier Field Validation", "FAIL");
		}
	}

	public void validateYearsLivedPersonalDetailsPage() {
		String yearsLivederror;
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Title"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Title"), "Mr");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.FirstName"))) {
			browser.input(pageProperties.getProperty("Acquisition.FirstName"),
					"tester");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.LastName"))) {
			browser.input(pageProperties.getProperty("Acquisition.LastName"),
					"tester");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Day"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Day"), "3");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Month"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Month"), "January");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Year"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Year"), "1989");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.TelephoneNumber"))) {
			browser.input(
					pageProperties.getProperty("Acquisition.TelephoneNumber"),
					"0123456789");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.TelephoneType"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.TelephoneType"),
					"1989");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.EmailAddress"))) {
			browser.input(
					pageProperties.getProperty("Acquisition.EmailAddress"),
					"rudhraaan@bgdigitaltest.co.uk");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.EmailType"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.EmailType"), "Work");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Postcode"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Postcode"),
					"rm38xb");
		}
		browser.click(pageProperties.getProperty("Acquisition.SearchLink"));
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.AddressList"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.AddressList"),
					"Andrew Mark Aluminium, 1-2, Langley Close, ROMFORD, Essex, RM3 8XB");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.MonthsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.MonthsLived"), "3");
		}
		browser.click(pageProperties
				.getProperty("Acquisition.PersonalDetailsContinue"));
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Error"))) {
			yearsLivederror = browser.getText(pageProperties
					.getProperty("Acquisition.Error"));
			Report.updateTestLog("Supplier Field Validation" + yearsLivederror,
					"PASS");
		} else {
			Report.updateTestLog("Supplier Field Validation", "FAIL");
		}
	}

	public AcquisitionAction personalDetailsPageNavigation(
			Acquisition acquisition, UserProfile userProfile) {

		selectPersonalDetails(acquisition, userProfile);
		passwordFieldSelection(acquisition);
		addressSelection(acquisition);

		browser.wait(getWaitTime());
		return new AcquisitionAction();
	}

	public AcquisitionAction personalDetailsPagePrevAddrNavigation(
			Acquisition acquisition, UserProfile userProfile) {

		selectPersonalDetails(acquisition, userProfile);
		previousYearAddressSelection(acquisition);
		browser.wait(getWaitTime());
		return new AcquisitionAction();
	}

	public AcquisitionAction personalDetailsPageLessthanTwoPrevAddr(
			Acquisition acquisition, UserProfile userProfile) {

		selectPersonalDetails(acquisition, userProfile);
		previousTwoYearAddressSelection(acquisition);
		browser.wait(getWaitTime());
		return new AcquisitionAction();
	}

	public AcquisitionAction energySmartPersonalDetailsPage(
			Acquisition acquisition) {

		passwordFieldSelection(acquisition);
		addressSelection(acquisition);

		browser.wait(getWaitTime());
		return new AcquisitionAction();

	}

	public AcquisitionAction onlineAccountPersonalDetailsPageNavigation(
			Acquisition acquisition, UserProfile userProfile) {
		selectPersonalDetails(acquisition, userProfile);
		passwordFieldSelection(acquisition);
		addressSelection(acquisition);
		browser.wait(getWaitTime());
		return new AcquisitionAction();

	}

	public AcquisitionAction energySmartonlineAccountPersonalDetailsPageNavigation(
			Acquisition acquisition, UserProfile userProfile) {

		passwordFieldSelection(acquisition);
		addressSelection(acquisition);
		browser.wait(getWaitTime());
		return new AcquisitionAction();

	}

	public AcquisitionAction addressSelection(Acquisition acquisition) {

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Postcode"))) {
			browser.clearValue(pageProperties
					.getProperty("Acquisition.Postcode"));
			browser.input(pageProperties.getProperty("Acquisition.Postcode"),
					acquisition.getPostcode());
			Report.updateTestLog(
					"Personal Details Page Postcode field verification,Postcode field Exists and value entered is "
							+ acquisition.getPostcode(), "PASS");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.SearchLink"))) {
			browser.click(pageProperties.getProperty("Acquisition.SearchLink"));
			Report.updateTestLog(
					"Personal Details Page Search link field verification,Search Link  Exists and Clicked",
					"PASS");
		} else if (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("Acquisition.SearchLinkForPAPC"))) {
			browser.clickWithXpath(pageProperties
					.getProperty("Acquisition.SearchLinkForPAPC"));
			Report.updateTestLog(
					"Personal Details Page Search link field verification,Search Link  Exists and Clicked",
					"PASS");
		} else if (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("Acquisition.EnergySmartSearchLink"))) {
			browser.clickWithXpath(pageProperties
					.getProperty("Acquisition.EnergySmartSearchLink"));
			Report.updateTestLog(
					"Personal Details Page Search link field verification,Search Link  Exists and Clicked",
					"PASS");
		} else if (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("Acquisition.OnlineAccountSearchLink"))) {
			browser.clickWithXpath(pageProperties
					.getProperty("Acquisition.OnlineAccountSearchLink"));
			Report.updateTestLog(
					"Personal Details Page Search link field verification,Search Link  Exists and Clicked",
					"PASS");
		} else if (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("Acquisition.PAPCSearchLink"))) {
			browser.clickWithXpath(pageProperties
					.getProperty("Acquisition.PAPCSearchLink"));
			Report.updateTestLog(
					"Personal Details Page Search link field verification,Search Link  Exists and Clicked",
					"PASS");
		}

		browser.wait(getWaitTime());
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {

		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.AddressList"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.AddressList"),
					acquisition.getAddress());
			// browser.selectfromDropBoxByXpath(pageProperties.getProperty("Acquisition.AddressList"),
			// acquisition.getAddress());
			// browser.selectfromDropBoxByXpath(pageProperties.getProperty("Acquisition.AddressList"),
			// "Stronghold Works 4, Stronghold Works, 4, Langley Close, ROMFORD, Essex, RM3 8XB");
			// browser.clickWithXpath(pageProperties.getProperty("Acquisition.AddressList"));
			Report.updateTestLog(
					"Personal Details Page AddressList field verification,Address List field Exists and value entered is"
							+ acquisition.getAddress(), "PASS");
		}// else{
			// Report.updateTestLog("Personal Details Page AddressList field verification,Address List field does not Exist"
			// , "FAIL");
		// }

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.MonthsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.MonthsLived"),
					acquisition.getMonthsLived());
			Report.updateTestLog(
					"Personal Details Page Months Lived field verification,Months Lived field Exists and value entered is"
							+ acquisition.getMonthsLived(), "PASS");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.YearsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.YearsLived"),
					acquisition.getYearsLived());
			Report.updateTestLog(
					"Personal Details Page Years Lived field verification,Years Lived Exists and value entered is"
							+ acquisition.getYearsLived(), "PASS");
		}
		pesonalDetailsContinue();
		browser.wait(getWaitTime());
		return new AcquisitionAction();
	}

	public void verifyAddressDetails(Acquisition acquisition) {
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Postcode"))) {
			browser.clearValue(pageProperties
					.getProperty("Acquisition.Postcode"));
			browser.input(pageProperties.getProperty("Acquisition.Postcode"),
					acquisition.getPostcode());
			Report.updateTestLog(
					"Personal Details Page Postcode field verification,Postcode field Exists and value entered is "
							+ acquisition.getPostcode(), "PASS");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.SearchLink"))) {
			browser.click(pageProperties.getProperty("Acquisition.SearchLink"));
			Report.updateTestLog(
					"Personal Details Page Search link field verification,Search Link  Exists and Clicked",
					"PASS");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.AddressList"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.AddressList"),
					acquisition.getAddress());
			Report.updateTestLog(
					"Personal Details Page AddressList field verification,Address List field Exists and value entered is"
							+ acquisition.getAddress(), "PASS");

		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.MonthsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.MonthsLived"),
					acquisition.getMonthsLived());
			Report.updateTestLog(
					"Personal Details Page Months Lived field verification,Months Lived field Exists and value entered is"
							+ acquisition.getMonthsLived(), "PASS");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.YearsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.YearsLived"),
					acquisition.getYearsLived());
			Report.updateTestLog(
					"Personal Details Page Years Lived field verification,Years Lived Exists and value entered is"
							+ acquisition.getYearsLived(), "PASS");
		}
		pesonalDetailsContinue();
	}

	public void pesonalDetailsContinue() {

		if (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("Acquisition.PersonalDetailsContinue"))) {
			browser.clickWithXpath(pageProperties
					.getProperty("Acquisition.PersonalDetailsContinue"));
			Report.updateTestLog(
					"Personal Details Page continue button is clicked successfully",
					"PASS");
		} else if (browser
				.isElementVisibleWithXpath(pageProperties
						.getProperty("Acquisition.PersonalDetailsPartAcquisitionContinue"))) {
			browser.clickWithXpath(pageProperties
					.getProperty("Acquisition.PersonalDetailsPartAcquisitionContinue"));
			Report.updateTestLog(
					"Personal Details Page continue button is clicked successfully",
					"PASS");
		} else if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.PersonalDetailsctn"))) {
			browser.click(pageProperties
					.getProperty("Acquisition.PersonalDetailsctn"));
			Report.updateTestLog(
					"Personal Details Page continue button is clicked successfully",
					"PASS");
		} else if (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("Acquisition.CurrentServicesContinue"))) {
			browser.clickWithXpath(pageProperties
					.getProperty("Acquisition.CurrentServicesContinue"));
			Report.updateTestLog(
					"Personal Details Page continue button is clicked successfully",
					"PASS");
		} else if (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("Acquisition.CurrentServicesContinue1"))) {
			browser.clickWithXpath(pageProperties
					.getProperty("Acquisition.CurrentServicesContinue1"));
			Report.updateTestLog(
					"Personal Details Page continue button is clicked successfully",
					"PASS");
		} else if (browser
				.isElementVisibleWithXpath(pageProperties
						.getProperty("Acquisition.CurrentServicesContinueForEnergyShop"))) {
			browser.clickWithXpath(pageProperties
					.getProperty("Acquisition.CurrentServicesContinueForEnergyShop"));
			Report.updateTestLog(
					"Personal Details Page continue button is clicked successfully ",
					"PASS");
		} else if (browser
				.isElementVisibleWithXpath(pageProperties
						.getProperty("Acquisition.CurrentServicesContinueForEnergySmart"))) {
			browser.clickWithXpath(pageProperties
					.getProperty("Acquisition.CurrentServicesContinueForEnergySmart"));
			Report.updateTestLog(
					"Personal Details Page continue button is clicked successfully ",
					"PASS");
		} else if (browser
				.isElementVisibleWithXpath("//*[@id='register']/div[7]/input")) {
			browser.clickWithXpath("//*[@id='register']/div[7]/input");
			Report.updateTestLog(
					"Personal Details Page continue button is clicked successfully ",
					"PASS");
		}

		else {
			Report.updateTestLog(
					"Personal Details Page Continue is not pressed", "Fail");
		}

	}

	public void passwordFieldSelection(Acquisition acquisition) {

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.CreatePasswordYourOrderPage"))) {
			browser.input(pageProperties
					.getProperty("Acquisition.CreatePasswordYourOrderPage"),
					acquisition.getCreatePassword());
			Report.updateTestLog(
					"Create a Password Field has been Entered Successfully "
							+ acquisition.getCreatePassword(), "PASS");
		} else if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.CreatePasswordYourOrderPage1"))) {
			browser.input(pageProperties
					.getProperty("Acquisition.CreatePasswordYourOrderPage1"),
					acquisition.getCreatePassword());
			Report.updateTestLog(
					"Create a Password Field has been Entered Successfully "
							+ acquisition.getCreatePassword(), "PASS");
		} else if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.CreatePasswordPersonalDetailsPage"))) {
			browser.input(
					pageProperties
							.getProperty("Acquisition.CreatePasswordPersonalDetailsPage"),
					acquisition.getCreatePassword());
			Report.updateTestLog(
					"Create a Password Field has been Entered Successfully "
							+ acquisition.getCreatePassword(), "PASS");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.RetypePasswordYourOrderPage"))) {
			browser.input(pageProperties
					.getProperty("Acquisition.RetypePasswordYourOrderPage"),
					acquisition.getRetypePassword());
			Report.updateTestLog(
					"Retype Password Field has been Entered Successfully "
							+ acquisition.getRetypePassword(), "PASS");
		} else if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.RetypePasswordYourOrderPage1"))) {
			browser.input(pageProperties
					.getProperty("Acquisition.RetypePasswordYourOrderPage1"),
					acquisition.getRetypePassword());
			Report.updateTestLog(
					"Retype Password Field has been Entered Successfully "
							+ acquisition.getRetypePassword(), "PASS");
		} else if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.RetypePasswordPersonalDetailsPage"))) {
			browser.input(
					pageProperties
							.getProperty("Acquisition.RetypePasswordPersonalDetailsPage"),
					acquisition.getRetypePassword());
			Report.updateTestLog(
					"Retype Password Field has been Entered Successfully "
							+ acquisition.getRetypePassword(), "PASS");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.SecurityQuestionYourOrderPage"))) {
			browser.selectfromDropBox("id", pageProperties
					.getProperty("Acquisition.SecurityQuestionYourOrderPage"),
					acquisition.getSecurityQuestion());
			Report.updateTestLog(
					"Security Question field has been Entered successfully "
							+ acquisition.getSecurityQuestion(), "PASS");
		} else if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.SecurityQuestionYourOrderPage1"))) {
			browser.selectfromDropBox("id", pageProperties
					.getProperty("Acquisition.SecurityQuestionYourOrderPage1"),
					acquisition.getSecurityQuestion());
			Report.updateTestLog(
					"Security Question field has been Entered successfully "
							+ acquisition.getSecurityQuestion(), "PASS");
		} else if (browser
				.isElementVisible(pageProperties
						.getProperty("Acquisition.SecurityQuestionPersonalDetailsPage"))) {
			browser.selectfromDropBox(
					"id",
					pageProperties
							.getProperty("Acquisition.SecurityQuestionPersonalDetailsPage"),
					acquisition.getSecurityQuestion());
			Report.updateTestLog(
					"Security Question field has been Entered successfully "
							+ acquisition.getSecurityQuestion(), "PASS");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.SecurityAnswerYourOrderPage"))) {
			browser.input(pageProperties
					.getProperty("Acquisition.SecurityAnswerYourOrderPage"),
					acquisition.getSecurityAnswer());
			Report.updateTestLog(
					"Security Answer field has been Entered successfully "
							+ acquisition.getSecurityAnswer(), "PASS");
		} else if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.SecurityAnswerYourOrderPage1"))) {
			browser.input(pageProperties
					.getProperty("Acquisition.SecurityAnswerYourOrderPage1"),
					acquisition.getSecurityAnswer());
			Report.updateTestLog(
					"Security Answer field has been Entered successfully "
							+ acquisition.getSecurityAnswer(), "PASS");
		} else if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.SecurityAnswerPersonalDetailsPage"))) {
			browser.input(
					pageProperties
							.getProperty("Acquisition.SecurityAnswerPersonalDetailsPage"),
					acquisition.getSecurityAnswer());
			Report.updateTestLog(
					"Security Answer field has been Entered successfully "
							+ acquisition.getSecurityAnswer(), "PASS");
		}

	}

	public void selectPersonalDetails(Acquisition acquisition,
			UserProfile userProfile) {

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Title"))) {

			try {
				browser.selectfromDropBox("id",
						pageProperties.getProperty("Acquisition.Title"),
						userProfile.getTitle());

			} catch (Exception e) {
			}
			Report.updateTestLog(
					"Personal Details Page Title field verification,Title field Exists and value entered is "
							+ userProfile.getTitle(), "PASS");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.FirstName"))) {

			String strfirstname = userProfile.getFirstName();
			String strappend = strfirstname + "aa";
			System.out.println(strappend);

			try {
				browser.clearValue(pageProperties
						.getProperty("Acquisition.FirstName"));
				browser.input(
						pageProperties.getProperty("Acquisition.FirstName"),
						strappend);
			} catch (Exception e) {
			}
			Report.updateTestLog(
					"Personal Details Page First Name field verification,First Name field Exists and value entered is "
							+ strappend, "PASS");
		} else if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.FirstName1"))) {
			// if(null!=browser.getText(pageProperties.getProperty("Acquisition.FirstName"))&&browser.getText(pageProperties.getProperty("Acquisition.FirstName")).trim()=="")
			try {
				browser.clearValue(pageProperties
						.getProperty("Acquisition.FirstName1"));
				browser.input(
						pageProperties.getProperty("Acquisition.FirstName1"),
						userProfile.getFirstName());
			} catch (InvalidElementStateException e) {
			}
			Report.updateTestLog(
					"Personal Details Page First Name field verification,First Name field Exists and value entered is "
							+ userProfile.getFirstName(), "PASS");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.LastName"))) {
			// if(null!=browser.getText(pageProperties.getProperty("Acquisition.LastName"))&&browser.getText(pageProperties.getProperty("Acquisition.LastName")).trim()=="")
			try {
				browser.clearValue(pageProperties
						.getProperty("Acquisition.LastName"));
				browser.input(
						pageProperties.getProperty("Acquisition.LastName"),
						userProfile.getLastName());

			} catch (InvalidElementStateException e) {
			}
			Report.updateTestLog(
					"Personal Details Page Last Name field verification,Last Name Exists and value entered is "
							+ userProfile.getLastName(), "PASS");
		} else if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.LastName1"))) {
			// if(null!=browser.getText(pageProperties.getProperty("Acquisition.LastName"))&&browser.getText(pageProperties.getProperty("Acquisition.LastName")).trim()=="")
			try {
				browser.clearValue(pageProperties
						.getProperty("Acquisition.LastName1"));
				browser.input(
						pageProperties.getProperty("Acquisition.LastName1"),
						userProfile.getLastName());

			} catch (InvalidElementStateException e) {
			}
			Report.updateTestLog(
					"Personal Details Page Last Name field verification,Last Name Exists and value entered is "
							+ userProfile.getLastName(), "PASS");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Day"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Day"),
					acquisition.getDay());
			Report.updateTestLog(
					"Personal Details Page DOB Day field verification,Day field Exists and value entered is "
							+ acquisition.getDay(), "PASS");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Month"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Month"),
					acquisition.getMonth());
			Report.updateTestLog(
					"Personal Details Page DOB Month field verification,Month field Exists and value entered is "
							+ acquisition.getMonth(), "PASS");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Year"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.Year"),
					acquisition.getYear());

			Report.updateTestLog(
					"Personal Details Page DOB Year field verification,Year field Exists and value entered is "
							+ acquisition.getYear(), "PASS");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.TelephoneNumber"))) {
			// if(null!=browser.getText(pageProperties.getProperty("Acquisition.TelephoneNumber"))&&browser.getText(pageProperties.getProperty("Acquisition.TelephoneNumber")).trim()=="")
			browser.clearValue(pageProperties
					.getProperty("Acquisition.TelephoneNumber"));
			browser.input(
					pageProperties.getProperty("Acquisition.TelephoneNumber"),
					acquisition.getMobileNumber());
			Report.updateTestLog(
					"Personal Details Page Telephone Number field verification,Telephone Number Field Exists and value entered is"
							+ acquisition.getMobileNumber(), "PASS");
		} else if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.TelephoneNumber1"))) {
			// if(null!=browser.getText(pageProperties.getProperty("Acquisition.TelephoneNumber"))&&browser.getText(pageProperties.getProperty("Acquisition.TelephoneNumber")).trim()=="")
			browser.clearValue(pageProperties
					.getProperty("Acquisition.TelephoneNumber1"));
			browser.input(
					pageProperties.getProperty("Acquisition.TelephoneNumber1"),
					acquisition.getMobileNumber());
			Report.updateTestLog(
					"Personal Details Page Telephone Number field verification,Telephone Number Field Exists and value entered is"
							+ acquisition.getMobileNumber(), "PASS");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.TelephoneType"))) {

			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.TelephoneType"),
					acquisition.getTelephonetype());
			Report.updateTestLog(
					"Personal Details Page Telephone Type field verification,Telephone Type field Exists and value entered is "
							+ acquisition.getTelephonetype(), "PASS");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.EmailAddress"))) {
			// if(null!=browser.getText(pageProperties.getProperty("Acquisition.EmailAddress"))&&browser.getText(pageProperties.getProperty("Acquisition.EmailAddress")).trim()=="")
			browser.clearValue(pageProperties
					.getProperty("Acquisition.EmailAddress"));
			browser.input(
					pageProperties.getProperty("Acquisition.EmailAddress"),
					userProfile.getEmail());
			Report.updateTestLog(
					"Personal Details Page Email Address field verification,Email Address Exists and value entered is "
							+ userProfile.getEmail(), "PASS");
		} else if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.EmailAddress1"))) {
			// if(null!=browser.getText(pageProperties.getProperty("Acquisition.EmailAddress"))&&browser.getText(pageProperties.getProperty("Acquisition.EmailAddress")).trim()=="")
			browser.clearValue(pageProperties
					.getProperty("Acquisition.EmailAddress1"));
			browser.input(
					pageProperties.getProperty("Acquisition.EmailAddress1"),
					userProfile.getEmail());
			Report.updateTestLog(
					"Personal Details Page Email Address field verification,Email Address Exists and value entered is "
							+ userProfile.getEmail(), "PASS");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.EmailType"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.EmailType"),
					acquisition.getEmailtype());
			Report.updateTestLog(
					"Personal Details Page Email Type field verification,Email Type field Exists and value entered is "
							+ acquisition.getEmailtype(), "PASS");
		}

	}

	public AcquisitionAction previousYearAddressSelection(
			Acquisition acquisition) {
		addressSelection(acquisition);
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Postcode1"))) {
			browser.clearValue(pageProperties
					.getProperty("Acquisition.Postcode1"));
			browser.input(pageProperties.getProperty("Acquisition.Postcode1"),
					"al7 4hd");
			Report.updateTestLog(
					"Personal Details Page Previous Year Postcode field verification,Postcode field Exists and value entered is al7 4hd",
					"PASS");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.SearchLink1"))) {
			browser.click(pageProperties.getProperty("Acquisition.SearchLink1"));
			Report.updateTestLog(
					"Personal Details Page Search link field verification,Search Link  Exists and Clicked",
					"PASS");
		}
		browser.wait(getWaitTime());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {

		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.AddressList1"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.AddressList1"),
					"310, Howlands, WELWYN GARDEN CITY, Hertfordshire, AL7 4HD");
			Report.updateTestLog(
					"Personal Details Page Previous Year AddressList field verification,Address List field Exists and value entered is 310, Howlands, WELWYN GARDEN CITY, Hertfordshire, AL7 4HD",
					"PASS");

		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.MonthsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.MonthsLived"), "6");
			Report.updateTestLog(
					"Personal Details Page Months Lived field verification,Months Lived field Exists and value entered is 6 Months",
					"PASS");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.YearsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.YearsLived"), "0");
			Report.updateTestLog(
					"Personal Details Page Years Lived field verification,Years Lived Exists and value entered is 0 Years",
					"PASS");
		}
		pesonalDetailsContinue();
		browser.wait(getWaitTime());
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Postcode2"))) {
			browser.clearValue(pageProperties
					.getProperty("Acquisition.Postcode2"));
			browser.input(pageProperties.getProperty("Acquisition.Postcode2"),
					"al7 4hd");
			Report.updateTestLog(
					"Personal Details Page Previous Year Postcode field verification,Postcode field Exists and value entered is al7 4hd",
					"PASS");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.SearchLink2"))) {
			browser.click(pageProperties.getProperty("Acquisition.SearchLink2"));
			Report.updateTestLog(
					"Personal Details Page Search link field verification,Search Link  Exists and Clicked",
					"PASS");
		}
		browser.wait(getWaitTime());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {

		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.AddressList2"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.AddressList2"),
					"314, Howlands, WELWYN GARDEN CITY, Hertfordshire, AL7 4HD");
			Report.updateTestLog(
					"Personal Details Page Previous Year AddressList field verification,Address List field Exists and value entered is 314, Howlands, WELWYN GARDEN CITY, Hertfordshire, AL7 4HD",
					"PASS");

		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.MonthsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.MonthsLived"), "6");
			Report.updateTestLog(
					"Personal Details Page Months Lived field verification,Months Lived field Exists and value entered is 6 Months",
					"PASS");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.YearsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.YearsLived"), "0");
			Report.updateTestLog(
					"Personal Details Page Years Lived field verification,Years Lived Exists and value entered is 0 Years",
					"PASS");
		}
		pesonalDetailsContinue();
		return new AcquisitionAction();
	}

	public AcquisitionAction previousTwoYearAddressSelection(
			Acquisition acquisition) {
		addressSelection(acquisition);
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Postcode1"))) {
			browser.clearValue(pageProperties
					.getProperty("Acquisition.Postcode1"));
			browser.input(pageProperties.getProperty("Acquisition.Postcode1"),
					"al7 4hd");
			Report.updateTestLog(
					"Personal Details Page Previous Year Postcode field verification,Postcode field Exists and value entered is al7 4hd",
					"PASS");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.SearchLink1"))) {
			browser.click(pageProperties.getProperty("Acquisition.SearchLink1"));
			Report.updateTestLog(
					"Personal Details Page Search link field verification,Search Link  Exists and Clicked",
					"PASS");
		}
		browser.wait(getWaitTime());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {

		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.AddressList1"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.AddressList1"),
					"310, Howlands, WELWYN GARDEN CITY, Hertfordshire, AL7 4HD");
			Report.updateTestLog(
					"Personal Details Page Previous Year AddressList field verification,Address List field Exists and value entered is 310, Howlands, WELWYN GARDEN CITY, Hertfordshire, AL7 4HD",
					"PASS");

		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.MonthsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.MonthsLived"), "6");
			Report.updateTestLog(
					"Personal Details Page Months Lived field verification,Months Lived field Exists and value entered is 6 Months",
					"PASS");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.YearsLived"))) {
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Acquisition.YearsLived"), "1");
			Report.updateTestLog(
					"Personal Details Page Years Lived field verification,Years Lived Exists and value entered is 0 Years",
					"PASS");
		}
		pesonalDetailsContinue();
		browser.wait(getWaitTime());
		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.Postcode2"))) {
			browser.clearValue(pageProperties
					.getProperty("Acquisition.Postcode2"));
			browser.input(pageProperties.getProperty("Acquisition.Postcode2"),
					"al7 4hd");
			Report.updateTestLog(
					"Personal Details Page Previous Year Postcode field verification,Postcode field Exists and value entered is al7 4hd",
					"PASS");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("Acquisition.SearchLink2"))) {
			browser.click(pageProperties.getProperty("Acquisition.SearchLink2"));
			Report.updateTestLog(
					"Personal Details Page Search link field verification,Search Link  Exists and Clicked",
					"PASS");
		}
		browser.wait(getWaitTime());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
		return new AcquisitionAction();
	}

	public void continueToMeterDetailsPageEsmart(UserProfile userProfile) {

		verifyAndInputById(
				pageProperties.getProperty("CAPersonalDetailPage.FirstNameId"),
				"First Name ", userProfile.getFirstName());

		verifyAndInputById(
				pageProperties.getProperty("CAPersonalDetailPage.SurNameId"),
				"Sur Name", userProfile.getLastName());

		browser.execJS("document.getElementById('"
				+ pageProperties
						.getProperty("CAPersonalDetailPage.TitleDropDownId")
				+ "').selectedIndex=1");

		Report.updateTestLog("Title Drop Down Selected with Value : Mr", "Pass");

		verifyAndSelectDropDownBox(
				pageProperties.getProperty("CAPersonalDetailPage.DOBDay"),
				"Day of Birth", userProfile.getDayOfBirth());
		verifyAndSelectDropDownBox(
				pageProperties.getProperty("CAPersonalDetailPage.DOBMonth"),
				"Month of Birth", userProfile.getMonthOfBirth());
		verifyAndSelectDropDownBox(
				pageProperties.getProperty("CAPersonalDetailPage.DOBYear"),
				"Year of Birth", userProfile.getYearOfBirth());

		browser.execJS("document.getElementById('"
				+ pageProperties
						.getProperty("CAPersonalDetailPage.ContactNumberId")
				+ "').setAttribute('value','" + userProfile.getMobileNumber()
				+ "');");
		Report.updateTestLog("Contact Number Feild filled with Value:"
				+ userProfile.getMobileNumber(), "Done");

		/*
		 * verifyAndInputById( pageProperties
		 * .getProperty("CAPersonalDetailPage.ContactNumberId"),
		 * "Contact Number", userProfile.getMobileNumber());
		 */

		verifyAndSelectDropDownBox(
				pageProperties
						.getProperty("CAPersonalDetailPage.telephoneNumber-telephoneType"),
				"Telephone number Type", "Mobile");

		verifyAndInputById(
				pageProperties
						.getProperty("CAPersonalDetailPage.EmailFeildIdNew"),
				"Email ", userProfile.getEmail());
		verifyAndSelectDropDownBox(
				pageProperties
						.getProperty("CAPersonalDetailPage.emailAddress-type"),
				"Email Type", "Work");

		verifyAndInputById(
				pageProperties.getProperty("CAPersonalDetailPage.password"),
				"password", userProfile.getPassword());

		verifyAndInputById(
				pageProperties
						.getProperty("CAPersonalDetailPage.confirmPassword"),
				"confirm Password", userProfile.getPassword());

		/*
		 * verifyAndInputById(
		 * pageProperties.getProperty("CAPersonalDetailPage.housenumber"),
		 * "house nubmer", "52");
		 */

		verifyAndInputById(
				pageProperties.getProperty("CAPersonalDetailPage.postcode"),
				"post code", userProfile.getPostCode());

		verifyAndClick(
				pageProperties
						.getProperty("CAPersonalDetailPage.searchaddressButton"),
				"search address");

		while (!browser.isElementVisible(pageProperties
				.getProperty("CAPersonalDetailPage.DisplayAddressDropdownId"))) {

			browser.wait(2000);
		}

		verifyAndSelectDropDownBox(
				pageProperties
						.getProperty("CAPersonalDetailPage.DisplayAddressDropdownId"),
				"Address", userProfile.getaddr());

		browser.wait(10);

		verifyAndSelectDropDownBox(
				pageProperties.getProperty("CAPersonalDetailPage.addrYear"),
				"Year at address", userProfile.getYearAtAddress());
		verifyAndSelectDropDownBox(
				pageProperties.getProperty("CAPersonalDetailPage.addrMonth"),
				"month at address", userProfile.getMonthAtAddress());

		if (Integer.parseInt(browser.getTextFromDropBox("id",
				pageProperties.getProperty("CAPersonalDetailPage.addrYear"))) < 3) {

			verifyAndClick(
					pageProperties
							.getProperty("CAPersonalDetailPage.continueButton"),
					"continuew button");

			verifyIsElementVisibleById(
					pageProperties.getProperty("CAPersonalDetailPage.postcode"),
					"Another Address Field");
			verifyAndInputById(
					pageProperties.getProperty("CAPersonalDetailPage.postcode"),
					"post code", userProfile.getPostCode());

			verifyAndClick(
					pageProperties
							.getProperty("CAPersonalDetailPage.searchaddressButton"),
					"search address");

			while (!browser
					.isElementVisible(pageProperties
							.getProperty("CAPersonalDetailPage.DisplayAddressDropdownId"))) {

				browser.wait(2000);
			}

			verifyAndSelectDropDownBox(
					pageProperties
							.getProperty("CAPersonalDetailPage.DisplayAddressDropdownId"),
					"Address", "index=2");

			browser.wait(10);

			verifyAndSelectDropDownBox(
					pageProperties.getProperty("CAPersonalDetailPage.addrYear"),
					"Year at address", userProfile.getYearAtAddress());
			verifyAndSelectDropDownBox(
					pageProperties
							.getProperty("CAPersonalDetailPage.addrMonth"),
					"month at address", userProfile.getMonthAtAddress());
		}

		verifyAndClick(
				pageProperties
						.getProperty("CAPersonalDetailPage.continueButton"),
				"continuew button");

	}

	public void continueToMeterDetailsPage(UserProfile userProfile) {

		verifyAndSelectDropDownBox(
				pageProperties.getProperty("CAPersonalDetailPage.DOBDay"),
				"Day of Birth", userProfile.getDayOfBirth());
		verifyAndSelectDropDownBox(
				pageProperties.getProperty("CAPersonalDetailPage.DOBMonth"),
				"Month of Birth", userProfile.getMonthOfBirth());
		verifyAndSelectDropDownBox(
				pageProperties.getProperty("CAPersonalDetailPage.DOBYear"),
				"Year of Birth", userProfile.getYearOfBirth());

		verifyAndSelectDropDownBox(
				pageProperties
						.getProperty("CAPersonalDetailPage.emailAddress-type"),
				"Email Type", "Work");

		verifyAndInputById(
				pageProperties.getProperty("CAPersonalDetailPage.password"),
				"password", userProfile.getPassword());

		verifyAndInputById(
				pageProperties
						.getProperty("CAPersonalDetailPage.confirmPassword"),
				"confirm Password", userProfile.getPassword());

		/*
		 * verifyAndInputById(
		 * pageProperties.getProperty("CAPersonalDetailPage.housenumber"),
		 * "house nubmer", "52");
		 */

		verifyAndInputById(
				pageProperties.getProperty("CAPersonalDetailPage.postcode"),
				"post code", userProfile.getPostCode());

		verifyAndClick(
				pageProperties
						.getProperty("CAPersonalDetailPage.searchaddressButton"),
				"search address");

		while (!browser.isElementVisible(pageProperties
				.getProperty("CAPersonalDetailPage.DisplayAddressDropdownId"))) {

			browser.wait(2000);
		}

		verifyAndSelectDropDownBox(
				pageProperties
						.getProperty("CAPersonalDetailPage.DisplayAddressDropdownId"),
				"Address", userProfile.getaddr());

		browser.wait(10);

		verifyAndSelectDropDownBox(
				pageProperties.getProperty("CAPersonalDetailPage.addrYear"),
				"Year at address", userProfile.getYearAtAddress());
		verifyAndSelectDropDownBox(
				pageProperties.getProperty("CAPersonalDetailPage.addrMonth"),
				"month at address", userProfile.getMonthAtAddress());

		if (Integer.parseInt(browser.getTextFromDropBox("id",
				pageProperties.getProperty("CAPersonalDetailPage.addrYear"))) < 3) {

			verifyAndClick(
					pageProperties
							.getProperty("CAPersonalDetailPage.continueButton"),
					"continuew button");

			verifyIsElementVisibleById(
					pageProperties.getProperty("CAPersonalDetailPage.postcode"),
					"Another Address Field");
			verifyAndInputById(
					pageProperties.getProperty("CAPersonalDetailPage.postcode"),
					"post code", userProfile.getPostCode());

			verifyAndClick(
					pageProperties
							.getProperty("CAPersonalDetailPage.searchaddressButton"),
					"search address");

			while (!browser
					.isElementVisible(pageProperties
							.getProperty("CAPersonalDetailPage.DisplayAddressDropdownId"))) {

				browser.wait(2000);
			}

			verifyAndSelectDropDownBox(
					pageProperties
							.getProperty("CAPersonalDetailPage.DisplayAddressDropdownId"),
					"Address", "index=2");

			browser.wait(10);

			verifyAndSelectDropDownBox(
					pageProperties.getProperty("CAPersonalDetailPage.addrYear"),
					"Year at address", userProfile.getYearAtAddress());
			verifyAndSelectDropDownBox(
					pageProperties
							.getProperty("CAPersonalDetailPage.addrMonth"),
					"month at address", userProfile.getMonthAtAddress());
		}

		verifyAndClick(
				pageProperties
						.getProperty("CAPersonalDetailPage.continueButton"),
				"continuew button");

	}
}
