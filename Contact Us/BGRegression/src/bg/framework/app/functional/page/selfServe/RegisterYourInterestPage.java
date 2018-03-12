package bg.framework.app.functional.page.selfServe;

import java.io.IOException;
import java.util.Properties;

import com.jcraft.jsch.JSchException;

import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.SshClient;

public class RegisterYourInterestPage extends BasePage {
	// private final static String FILE_NAME =
	// "resources/sales/"+ApplicationConfig.BRAND+"Acquisition.properties";
	private final static String FILE_NAME = "resources/selfServe/RegisterYourInterestPage.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME)
			.load();

	public RegisterYourInterestPage() {

	}

	public RegisterYourInterestPage(Acquisition acquisition) {
	}

	public RegisterYourInterestPage(UserProfile userProfile) {
	}

	public void registerInterest(UserProfile userProfile) {

		verifyAndSelectDropDownBox(
				pageProperties.getProperty("RegisterYourInterestPage.title"),
				"User Title", userProfile.getTitle());

		browser.wait(2000);

		verifyAndInputById(
				pageProperties
						.getProperty("RegisterYourInterestPage.firstName"),
				"First Name ", userProfile.getFirstName());

		verifyAndInputById(
				pageProperties.getProperty("RegisterYourInterestPage.surname"),
				"Sur Name", userProfile.getLastName());

		verifyAndInputById(
				pageProperties.getProperty("RegisterYourInterestPage.postcode"),
				"Post Code", userProfile.getPostCode());
		verifyAndClick(
				pageProperties
						.getProperty("RegisterYourInterestPage.searchaddr"),
				"Find Address Button");
		while (!browser.isElementVisible(pageProperties
				.getProperty("RegisterYourInterestPage.displayaddr"))) {

			browser.wait(2000);
		}

		verifyAndSelectDropDownBox(
				pageProperties
						.getProperty("RegisterYourInterestPage.displayaddr"),
				"Address", userProfile.getaddr());

		verifyAndInputById(
				pageProperties
						.getProperty("RegisterYourInterestPage.emailAddress"),
				"Email ", userProfile.getEmail());

		verifyAndInputById(
				pageProperties
						.getProperty("RegisterYourInterestPage.confirmemail"),
				"Confirm Email ", userProfile.getEmail());

		verifyAndInputById(
				pageProperties
						.getProperty("RegisterYourInterestPage.telephoneNumber"),
				"Contact Number", userProfile.getMobileNumber());

		verifyAndSelectDropDownBox(
				pageProperties
						.getProperty("RegisterYourInterestPage.ownProperty"),
				"ownProperty", userProfile.getAnswer1());

		verifyAndSelectDropDownBox(
				pageProperties
						.getProperty("RegisterYourInterestPage.paygMeter"),
				"paygMeter", userProfile.getAnswer2());

		verifyAndSelectDropDownBox(
				pageProperties
						.getProperty("RegisterYourInterestPage.eco7Meter"),
				"eco7Meter", userProfile.getAnswer3());

		verifyAndSelectDropDownBox(
				pageProperties
						.getProperty("RegisterYourInterestPage.propertyFlat"),
				"propertyFlat", userProfile.getAnswer4());

		verifyAndSelectDropDownBox(
				pageProperties
						.getProperty("RegisterYourInterestPage.meterInBaseOrCellar"),
				"meterInBaseOrCellar", userProfile.getAnswer5());

		if (userProfile.getAccNumber().isEmpty()) {

			verifyAndSelectDropDownBox(
					pageProperties
							.getProperty("RegisterYourInterestPage.existingBgCustomer"),
					"existingBgCustomer", "No");

			verifyAndSelectDropDownBox(
					pageProperties
							.getProperty("RegisterYourInterestPage.gasCurrentSupplier"),
					"gasCurrentSupplier", "EDF Energy");

			verifyAndSelectDropDownBox(
					pageProperties
							.getProperty("RegisterYourInterestPage.elecCurrentSupplier"),
					"elecCurrentSupplier", userProfile.getCurrentEnergySupplier());

		} else {

			verifyAndSelectDropDownBox(
					pageProperties
							.getProperty("RegisterYourInterestPage.existingBgCustomer"),
					"existingBgCustomer", "Yes");

			verifyAndSelectDropDownBox(
					pageProperties
							.getProperty("RegisterYourInterestPage.gasAccountNo"),
					"gasAccountNo", userProfile.getGasAccount());
			verifyAndSelectDropDownBox(
					pageProperties
							.getProperty("RegisterYourInterestPage.elecAccountNo"),
					"elecAccountNo", userProfile.getElecAccount());

		}

		verifyAndSelectDropDownBox(
				pageProperties
						.getProperty("RegisterYourInterestPage.whereDidYouHearAboutSmartMeters"),
				"whereDidYouHearAboutSmartMeters", "Facebook");

		verifyAndClick(
				pageProperties.getProperty("RegisterYourInterestPage.submit"),
				"submit button");

	}

	public void verifyInterestRegistration() {

		verifyPageTitle(pageProperties
				.getProperty("RegisterYourInterestPage.confirmTitle"));
		
	}

	public void runRegIntBatch() {

		SshClient sshClient = new SshClient();

		try {
			sshClient.connect();
			if (sshClient.isConnected()) {

				System.out.println(sshClient.send("cd scripts/"));

				System.out.println(sshClient.send("ls"));

				System.out.println(sshClient
						.send("./doextractsmartregisterinterest.sh"));

				// String strBatch="./doacquisitionmarsProcess.sh";
				browser.wait(70000);

				sshClient.send("clear");

				sshClient.disconnect();
			}
		} catch (JSchException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		} catch (IOException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		} catch (InterruptedException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
	
		
	}

}
