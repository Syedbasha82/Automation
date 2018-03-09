package bg.framework.app.functional.page.selfServe;

import java.util.Properties;

import org.openqa.selenium.internal.selenesedriver.IsElementDisplayed;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class ComboRegisterYourInterestAndSmartMeterLandingPage extends BasePage {

	private final static String FILE_NAME = "resources/selfServe/ComboRegisterYourInterestAndSmartMeterLandingPage.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME)
			.load();

	public void navigateTocomboRegisterInterestSMlandingPage() {

		browser.open(ApplicationConfig.APP_BG_URL
				+ "/SmartMeter/Channel-Activation/");
		Report.updateTestLog(
				"Navigated to Combo Register your interest and Smart Meter Landing Page Successfully !!",
				"Pass");

	}

	public void selectYesOption() {

		verifyAndClick(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.YesOpetionId"),
				"British Gas Supplier Yes Option");
	}

	public void selectNoOption() {

		verifyAndClick(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.NoOpetionId"),
				"British Gas Supplier No Option");
	}

	public void verifyYesOption() {

		verifyIsElementVisibleById(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.LoginRadioID"),
				"Login Radio");

		verifyIsElementVisibleById(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.EmailFeildId"),
				"Email Feild");

		verifyIsElementVisibleById(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.PasswordFeildId"),
				"Password Feild");

		verifyIsElementVisibleById(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.LoginButtonId"),
				"Login Button");
		verifyIsElementVisibleById(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.RegistrationRadioId"),
				"Registration Radio");
	}

	public void verifyNoOption() {

		verifyIsElementVisibleById(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.TitleDropDownId"),
				"Title DropDown");

		verifyIsElementVisibleById(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.FirstNameId"),
				"First Name Feild");

		verifyIsElementVisibleById(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.SurNameId"),
				"Sur Name");

		verifyIsElementVisibleById(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.HouseNumberId"),
				"House Number Feild");
		verifyIsElementVisibleById(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.PostCodeId"),
				"Post Code Feild");
		verifyIsElementVisibleById(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.FindAddressButtonId"),
				"Find Address Button");

		verifyIsElementVisibleById(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.EmailFeildIdNew"),
				"Email Feild");

		verifyIsElementVisibleById(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.ConfirmEmailFeildId"),
				"Contact Number");

		verifyIsElementVisibleById(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.ContactNumberId"),
				"Login Button");
		verifyIsElementVisibleById(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.AlternateContactNumberId"),
				"Alternate Contact Number");
		verifyIsElementVisibleWithLinkText(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.CheckYourPropertiesSuitableLinkText"),
				"Check Your Properties Suitable Link");

	}

	public void fillDetailsForRegisterInterest(UserProfile userProfile) {

		/*
		 * if (browser.isElementVisible(pageProperties .getProperty(
		 * "ComboRegisterYourInterestAndSmartMeterLandingPage.TitleDropDownId"
		 * ))) {
		 * 
		 * try { browser.selectfromDropBox("id", pageProperties.getProperty(
		 * "ComboRegisterYourInterestAndSmartMeterLandingPage.TitleDropDownId"),
		 * userProfile.getTitle());
		 * 
		 * } catch (Exception e) { } Report.updateTestLog(
		 * "Personal Details Page Title field verification,Title field Exists and value entered is "
		 * + userProfile.getTitle(), "PASS"); }
		 */

		browser.wait(2000);

		/*
		 * browser.clickWithXpath(".//*[@id='title']"); if
		 * (browser.isElementVisibleWithXpath(".//*[@id='title']/option[2]")) {
		 * browser.clickWithXpath(".//*[@id='title']/option[2]"); }
		 */

		/*
		 * verifyAndSelectDropDownBox( pageProperties .getProperty(
		 * "ComboRegisterYourInterestAndSmartMeterLandingPage.TitleDropDownId"),
		 * "User Title", userProfile.getTitle());
		 */

		browser.execJS("document.getElementById('"
				+ pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.TitleDropDownId")
				+ "').selectedIndex=1");

		Report.updateTestLog("Title Drop Down Selected with Value : Mr", "Pass");

		verifyAndInputById(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.FirstNameId"),
				"First Name ", userProfile.getFirstName());

		verifyAndInputById(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.SurNameId"),
				"Sur Name", userProfile.getLastName());

		verifyAndInputById(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.PostCodeId"),
				"Post Code", userProfile.getPostCode());
		verifyAndClick(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.FindAddressButtonId"),
				"Find Address Button");
		while (!browser
				.isElementVisible(pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.DisplayAddressDropdownId"))) {

			browser.wait(2000);
		}

		verifyAndSelectDropDownBox(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.DisplayAddressDropdownId"),
				"Address", userProfile.getaddr());

		verifyAndInputById(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.EmailFeildIdNew"),
				"Email ", userProfile.getEmail());

		verifyAndInputById(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.ConfirmEmailFeildId"),
				"Confirm Email ", userProfile.getEmail());

		verifyAndInputById(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.ContactNumberId"),
				"Contact Number", userProfile.getMobileNumber());

	}

	public void answerScreeningQuestions(UserProfile userProfile) {

		if (userProfile.getAnswer1().equalsIgnoreCase("Yes")) {

			verifyAndClick(
					pageProperties
							.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.Question1YesOpetionId"),
					"Question1 Yes Option");

		} else {

			verifyAndClick(
					pageProperties
							.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.Question1NoOpetionId"),
					"Question1 No Option");

		}

		if (userProfile.getAnswer2().equalsIgnoreCase("Yes")) {

			verifyAndClick(
					pageProperties
							.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.Question2YesOpetionId"),
					"Question2 Yes Option");

		} else {

			verifyAndClick(
					pageProperties
							.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.Question2NoOpetionId"),
					"Question2 No Option");

		}

		if (userProfile.getAnswer3().equalsIgnoreCase("Yes")) {

			verifyAndClick(
					pageProperties
							.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.Question3YesOpetionId"),
					"Question3 Yes Option");

		} else {

			verifyAndClick(
					pageProperties
							.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.Question3NoOpetionId"),
					"Question3 No Option");

		}

		if (userProfile.getAnswer4().equalsIgnoreCase("Yes")) {

			verifyAndClick(
					pageProperties
							.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.Question4YesOpetionId"),
					"Question4 Yes Option");

		} else {

			verifyAndClick(
					pageProperties
							.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.Question4NoOpetionId"),
					"Question4 No Option");

		}

		if (userProfile.getAnswer5().equalsIgnoreCase("Yes")) {

			verifyAndClick(
					pageProperties
							.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.Question5YesOpetionId"),
					"Question5 Yes Option");

		} else {

			verifyAndClick(
					pageProperties
							.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.Question5NoOpetionId"),
					"Question5 No Option");

		}

	}

	public void checkPropertySuitability() {

		verifyAndClickWithLinkText(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.CheckYourPropertiesSuitableLinkText"),
				"Check Your Properties Suitable Link");

	}

	public void verifyRegisterYourInterestLinkAtSMLpage() {

		verifyIsElementVisibleWithLinkText(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.RegisterYourInterestLinkText"),
				"Register Your Interest Link");

	}

	public void navigateToRegisterYourInterestPage() {

		verifyAndClickWithLinkText(
				pageProperties
						.getProperty("ComboRegisterYourInterestAndSmartMeterLandingPage.RegisterYourInterestLinkText"),
				"Register Your Interest Link");

	}

}