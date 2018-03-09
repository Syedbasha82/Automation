package bg.framework.app.functional.page.selfServe;

import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.internal.seleniumemulation.GetText;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SiebelDataBase;

/**
 * Created by IntelliJ IDEA. User: !jithendb Date: 23/03/12 Time: 10:16 To
 * change this template use File | Settings | File Templates.
 */
public class UpgradeToSmartMeterPage extends BasePage {

	private final static String FILE_NAME = "resources/selfServe/"
			+ ApplicationConfig.BRAND + "UpgradeToSmartMeter.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME)
			.load();

	public void navigateToAccountSummaryPage(UserProfile userProfile) {
		// browser.wait(getWaitTime());
		verifyAndClickWithXpath(
				(pageProperties.getProperty("AccountOverviewPage.ManageAccountXPath").replace(
						"<USERACCOUNTNUMBER>", userProfile.getAccNumber())),
				"Account summary");
	}

	public void navigateToUpgradeSmartMeterPage() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		verifyAndClickWithLinkText(
				pageProperties
						.getProperty("UpgradeToSmartMeter.UpgradeToSmartMeterLink"),
				"Upgrade Smart Meter link");

	}

	public void navigateToChooseAnAppointmentPage() {

		verifyAndSelectCheckBox(
				pageProperties
						.getProperty("UpgradeToSmartMeter.EligibleCheckbox"),
				"Eligible checkbox");
		verifyAndClickWithXpath(
				pageProperties
						.getProperty("UpgradeToSmartMeter.ContinueButton"),
				"Continue button");
	}

	public void checkAvailableBookingSlot() {

		checkAvailableSlotsMsg(
				pageProperties.getProperty("UpgradeToSmartMeter.LaterDate"),
				pageProperties.getProperty("UpgradeToSmartMeter.EarlierDate"));
	}

	public void navigateToReviewDetailsPage() {

		// checkAvailableSlotsMsg(pageProperties.getProperty("UpgradeToSmartMeter.LaterDate"));
		// selectSlotByValue("Friday 28 Jun 2013 between 10:00am - 2:00pm");

		// selectAppointmentSlot(pageProperties.getProperty("UpgradeToSmartMeter.AppointmentTime"),pageProperties.getProperty("UpgradeToSmartMeter.AppointmentDate"));
		selectFirstAppointmentSlot(pageProperties
				.getProperty("UpgradeToSmartMeter.FirstAppointment"));
		// verifyAndClickWithXpath(pageProperties.getProperty("UpgradeToSmartMeter.AvailableTimeSlot"),
		// "Available time slot");
		// verifyAndClickWithXpath(pageProperties.getProperty("UpgradeToSmartMeter.BookThisAppointmentButton"),
		// "Book this appointment button");

	}

	public void navigateToConfirmationPage(UserProfile userProfile) {
		verifyAndInputWithName(
				pageProperties
						.getProperty("UpgradeToSmartMeter.BestContactNumber"),
				"Best Contact Number", userProfile.getMobileNumber());
		verifyAndClick(
				pageProperties
						.getProperty("UpgradeToSmartMeter.ReadingInterval"),
				"Reading Interval");
		// verifyAndSelectCheckBox(pageProperties.getProperty("UpgradeToSmartMeter.EnergySavingAdviceFlag"),
		// "Energy saving advice flag");
		verifyAndClickWithXpath(
				pageProperties.getProperty("UpgradeToSmartMeter.SubmitButton"),
				"Submit button");
	}

	public void navigateToYourAccountPage() {
		try {
			Thread.sleep(3000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		verifyAndClickWithLinkText(
				pageProperties
						.getProperty("UpgradeToSmartMeter.GoToYourAccount"),
				"Go to your account");
	}

	public void verifyAppointmentDateAndTime() {
		VerifyAppointmentDate();
	}

	public void verifyAddressAndReferenceNo() {

		verifyIsElementVisibleWithXpath(
				pageProperties.getProperty("UpgradeToSmartMeter.AddressLast"),
				"Address at Confirmation Page");
		verifyTextPresent(
				pageProperties
						.getProperty("UpgradeToSmartMeter.ReferenceNumber"),
				"Reference Number");
	}

	public void verifyAvailableApoointments() {
		// String todayDate =
		// getTextById(pageProperties.getProperty("UpgradeToSmartMeter.TodayDate"),
		// "Todays date");
		verifyFirstAvailableSlot(
				pageProperties.getProperty("UpgradeToSmartMeter.AvailableDate"),
				"Available slot date");
	}

	public void verifyIsThisWrongAddressAlert() {
		verifyAndClickWithLinkText(
				pageProperties
						.getProperty("UpgradeToSmartMeter.WrongAddressLink"),
				"Is this the wrong address? ");
		verifyIsAlertVisibleWithXpath(
				pageProperties
						.getProperty("UpgradeToSmartMeter.AlertMessageXpath"),
				"Alert message");

	}

	public void verifyTimeoutAlert() {
		browser.wait(660000);
		verifyIsAlertVisibleWithXpath(
				pageProperties
						.getProperty("UpgradeToSmartMeter.TimeoutAlertMessageXpath"),
				"Time Out Alert message");

	}

	public void verifyCustomerAddress(String accountNumber) {
		SiebelDataBase siebelDatabase = new SiebelDataBase();
		List<String> address = siebelDatabase.getAddress(accountNumber);
		System.out.println(address);
		String[] arrayaddress = (String[]) address.toArray(new String[0]);
		String houseno = arrayaddress[0];
		String addNum = arrayaddress[1];
		String addres = arrayaddress[2];
		String city = arrayaddress[3];
		String zipcode = arrayaddress[4];
		String number = "";
		String fulladdress = "";
		if (!(houseno == null)) {
			number = houseno;
		} else if (!(addNum == null)) {
			number = addNum;
		}

		String dbAddress = number + " " + addNum + " " + addres + " " + city
				+ " " + zipcode;
		if (ApplicationConfig.BRAND.equalsIgnoreCase("BG")) {
			String addressOneAdd = null;
			String addressTwoAdd = null;
			int accountCount = browser
					.getChildElementsCountByXpath(pageProperties
							.getProperty("AccountOverviewPage.accountCount"));
			String expectedAccountNum = accountNumber;
			for (int i = 1; i <= accountCount; i++) {
				String currentAccountNum;
				if (browser.isElementVisibleWithXpath(pageProperties
						.getProperty("AccountOverviewPage.accountNumber")
						.replace("ACC_NUM", "" + i))) {
					currentAccountNum = browser.getTextByXpath(
							pageProperties.getProperty(
									"AccountOverviewPage.accountNumber")
									.replace("ACC_NUM", "" + i)).trim();
					if (currentAccountNum.equalsIgnoreCase(expectedAccountNum)) {
						addressOneAdd = browser.getTextByXpath(pageProperties
								.getProperty(
										"AccountOverviewPage.addressLineOne")
								.replace("ACC_NUM", "" + i));
						addressTwoAdd = browser.getTextByXpath(pageProperties
								.getProperty(
										"AccountOverviewPage.addressLineTwo")
								.replace("ACC_NUM", "" + i));
						fulladdress = addressOneAdd + addressTwoAdd;
					}
				} else {
					currentAccountNum = browser.getTextByXpath(
							pageProperties.getProperty(
									"AccountOverviewPage.accountNumberClose")
									.replace("ACC_NUM", "" + i)).trim();
					if (currentAccountNum.equalsIgnoreCase(expectedAccountNum)) {
						addressOneAdd = browser
								.getTextByXpath(pageProperties
										.getProperty(
												"AccountOverviewPage.addressLineOneClose")
										.replace("ACC_NUM", "" + i));
						addressTwoAdd = browser
								.getTextByXpath(pageProperties
										.getProperty(
												"AccountOverviewPage.addressLineTwoClose")
										.replace("ACC_NUM", "" + i));
						fulladdress = addressOneAdd + addressTwoAdd;
					}
				}

			}
			if (fulladdress.contains(number) && fulladdress.contains(addres)
					&& fulladdress.contains(city)
					&& fulladdress.contains(zipcode)) {
				Report.updateTestLog(
						"Address verification done with database successfull<br>"
								+ "Database address-<b>" + dbAddress
								+ "</b><br>Page address-<b>" + fulladdress
								+ "</b>", "PASS");
			} else {
				Report.updateTestLog(
						"Address verification done with database is not successfull<br>"
								+ "Database address-<b>" + dbAddress
								+ "</b><br>Page address-<b>" + fulladdress
								+ "</b>", "FAIL");
			}
		} else if (ApplicationConfig.BRAND.equalsIgnoreCase("Fusion")) {
			fulladdress = browser.getTextByXpath(pageProperties
					.getProperty("AccountOverviewPage.address"));
			System.out.println(fulladdress);
			if (fulladdress.contains(number) && fulladdress.contains(addres)
					&& fulladdress.contains(city)
					&& fulladdress.contains(zipcode)) {
				Report.updateTestLog(
						"Address verification done with database successfull<br>"
								+ "Database address-<b>" + dbAddress
								+ "</b><br>Page address-<b>" + fulladdress
								+ "</b>", "PASS");
			} else {
				Report.updateTestLog(
						"Address verification done with database is not successfull<br>"
								+ "Database address-<b>" + dbAddress
								+ "</b><br>Page address-<b>" + fulladdress
								+ "</b>", "FAIL");
			}
		} else if (ApplicationConfig.BRAND.equalsIgnoreCase("services")) {

			fulladdress = browser.getTextByXpath(pageProperties
					.getProperty("UpgradeToSmartMeter.address"));
			fulladdress=fulladdress.replace("(Is this the wrong address?)", "");
			System.out.println(fulladdress);
			if (fulladdress.contains(number) && fulladdress.contains(addres)
					&& fulladdress.contains(city)
					&& fulladdress.contains(zipcode)) {
				Report.updateTestLog(
						"Address verification done with database successfull<br>"
								+ "Database address-<b>" + dbAddress
								+ "</b><br>Page address-<b>" + fulladdress
								+ "</b>", "PASS");
			} else {
				Report.updateTestLog(
						"Address verification done with database is not successfull<br>"
								+ "Database address-<b>" + dbAddress
								+ "</b><br>Page address-<b>" + fulladdress
								+ "</b>", "FAIL");
			}

		}
	}
}