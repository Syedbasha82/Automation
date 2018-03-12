package bg.framework.app.functional.page.selfServe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.InvalidElementStateException;

import com.jcraft.jsch.JSchException;

import bg.framework.app.functional.action.sales.AcquisitionAction;
import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SshClient;

public class CAReviewOrderPage extends BasePage {

	public static final String orderDate = new OnlineDBConnector().DBsysdate();

	private final static String FILE_NAME = "resources/selfServe/CAReviewOrderPage.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME)
			.load();

	public void verifyAndConfirmOrder() {

		verifyAndClick(
				pageProperties
						.getProperty("CAReviewOrderPage.paperLesstermsAndCondtions"),
				"paperLess terms And Condtions");

		verifyAndClick(
				pageProperties
						.getProperty("CAReviewOrderPage.termsConditionsCheck"),
				"terms Conditions Check");

		verifyAndClick(
				pageProperties
						.getProperty("CAReviewOrderPage.marketingConsentEmail"),
				"marketing Consent Email");

		verifyAndClick(
				pageProperties
						.getProperty("CAReviewOrderPage.placeOrderButton"),
				"placeOrderButton");

		verifyIsTextPresent("Thank you");

		browser.open(ApplicationConfig.APP_BG_URL + "/Login/Login-Verify/");

	}

	public void verifyLeadCreation() {

		String leadid = new OnlineDBConnector().getEshopLeadID(orderDate);
		Report.updateTestLog("Lead ID Generated is " + leadid, "DONE");

	}

	public void verifyLeadType() {
		String leadtype = new OnlineDBConnector().getEshopLeadType(orderDate);
		System.out.println(leadtype);
		String strAcqLead = "ENERGY_ACQ";
		String strSmartLead = "ESMART_ACQ";
		if (leadtype.equals(strAcqLead)) {
			Report.updateTestLog("Lead Type Generated for Acquisition is "
					+ leadtype, "DONE");
		} else if (leadtype.contains(strSmartLead)) {
			Report.updateTestLog("Lead Type Generated for Esmart is "
					+ leadtype, "DONE");
		} else {
			Report.updateTestLog(
					"Lead Type not as expected, Lead Type Generated is :"
							+ leadtype, "FAIL");
		}
	}

	public void verifyLeadStatusBefore() {

		OnlineDBConnector oldbc = new OnlineDBConnector();
		String sysDate = oldbc.DBsysdate();
		// Report.updateTestLog(oldbc.getLeadTypeNectar(), "Pass");

		if (oldbc.getLeadStatusCA(orderDate).equals("0")) {
			Report.updateTestLog("Lead Status is =0 ", "Pass");
		}

	}

	public void verifyLeadStatusAfter() {

		OnlineDBConnector oldbc = new OnlineDBConnector();
		String sysDate = oldbc.DBsysdate();
		// Report.updateTestLog(oldbc.getLeadTypeNectar(), "Pass");

		if (oldbc.getLeadStatusCA(orderDate).equals("1")) {
			Report.updateTestLog("Lead Status is =1", "Pass");
		}

	}

	public void runAcqBatch() {
		SshClient sshClient = new SshClient();

		try {
			sshClient.connect();
			if (sshClient.isConnected()) {

				System.out.println(sshClient.send("cd scripts/"));

				System.out.println(sshClient.send("ls"));

				System.out.println(sshClient
						.send("./doacquisitionmarsProcess.sh"));

				Report.updateTestLog(
						"Batch doacquisitionmarsProcess.sh started", "Pass");

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

	public void runESmartBatch() {

		SshClient sshClient = new SshClient();

		try {
			sshClient.connect();
			if (sshClient.isConnected()) {

				System.out.println(sshClient.send("cd scripts/"));

				System.out.println(sshClient.send("ls"));

				System.out.println(sshClient
						.send("./doenergysmartmarssales.sh"));

				Report.updateTestLog("Batch doenergysmartmarssales.sh started",
						"Pass");

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
