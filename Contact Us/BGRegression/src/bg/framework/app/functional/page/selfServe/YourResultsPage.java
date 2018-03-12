package bg.framework.app.functional.page.selfServe;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.internal.selenesedriver.IsElementDisplayed;

import com.jcraft.jsch.JSchException;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SshClient;

public class YourResultsPage extends BasePage {

	public static final String orderDate = new OnlineDBConnector().DBsysdate();

	private final static String FILE_NAME = "resources/selfServe/YourResultsPage.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME)
			.load();

	public void verifyYourResultsPage() {

		if (browser.isTextPresent("Gas")
				&& browser.isTextPresent("Electricity")) {

			Report.updateTestLog("Gas & Electricity displayed", "Pass");
		}

		verifyIsElementVisibleById(
				pageProperties.getProperty("YourResultsPage.switchNowLinkId") + 1,
				"Switch Now Link");

	}

	public void switchNow(int tariff) {

		verifyAndClick(
				pageProperties.getProperty("YourResultsPage.switchNowLinkId")
						+ tariff, "Switch Now Link");

	}

	public void verifyGetAQuoteLeadCreation() {
		String leadid = new OnlineDBConnector().getQuoteId(orderDate);
		Report.updateTestLog("Quote ID Generated is " + leadid, "DONE");

	}

	public void verifyQuoteLeadStatusBefore() {
		String leadstatus = new OnlineDBConnector()
				.verifyLeadQuoteDB(orderDate);
		Report.updateTestLog("Quote Lead Status is " + leadstatus, "DONE");

	}

	public void runQuoteBatch() {
		SshClient sshClient = new SshClient();

		try {
			sshClient.connect();
			if (sshClient.isConnected()) {

				System.out.println(sshClient.send("cd scripts/"));

				System.out.println(sshClient.send("ls"));

				System.out.println(sshClient.send("./dogetquoteprocess.sh"));

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

	public void verifyQuoteLeadStatusAfter() {

		String leadid = new OnlineDBConnector().getQuoteId(orderDate);

		String leadstatus = new OnlineDBConnector()
				.verifyLeadQuoteAferBatch(leadid);
		Report.updateTestLog("Quote Lead Status is " + leadstatus, "DONE");

	}

}