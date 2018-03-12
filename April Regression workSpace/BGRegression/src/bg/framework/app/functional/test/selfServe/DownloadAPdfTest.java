package bg.framework.app.functional.test.selfServe;

import java.awt.AWTException;
import java.awt.Robot;

import org.testng.annotations.Test;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.action.selfServe.DownloadAPdfAction;
import static bg.framework.app.functional.entities.FunctionalCategory.*;


public class DownloadAPdfTest extends TestBase{
	
	//Data : Gas Account, Bill generated
	@Test(groups = {Acquisition})
	public void verifyPDFDownloadOAMGas(){
		Report.createTestLogHeader("Download A PDF Test", "Verify Download A PDF For Gas Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile);
		new DownloadAPdfAction()
			.navigatetoLatestStatement()
			.downloadPDF()
			.verifyPDFDownload()
			.logout();
			
	}
	
	
	//Data : Electricity Account, Bill generated
	@Test(groups = {Acquisition})
	public void verifyPDFDownloadOAMElec(){
		Report.createTestLogHeader("Download A PDF Test", "Verify Download A PDF For Electricity Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile);
		new DownloadAPdfAction()
			.navigatetoLatestStatement()
			.downloadPDF()
			.verifyPDFDownload()
			.logout();
	}
	
	//Data : JI Account, Bill generated
	@Test(groups = {Acquisition})
	public void verifyPDFDownloadOAMJIaccount(){
		Report.createTestLogHeader("Download A PDF Test", "Verify Download A PDF For JI Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile);
		new DownloadAPdfAction()
			.navigatetoLatestStatement()
			.downloadPDF()
			.verifyPDFDownload()
			.logout();
	}
	
	//Data : Dual Account, Bill generated
	@Test(groups = {Acquisition})
	public void verifyPDFDownloadOAMDualaccount(){
		Report.createTestLogHeader("Download A PDF Test", "Verify Download A PDF For Dual Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile);
		new DownloadAPdfAction()
			.navigatetoLatestStatement()
			.downloadPDF()
			.verifyPDFDownload()
			.logout();
	}
		
	//Data : Gas Account, Statement generated
	@Test(groups = {Acquisition})
	public void verifyPDFDownloadOAMGasStatement(){
		Report.createTestLogHeader("Download A PDF Test", "Verify Download A PDF Statement For Gas Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile);
		new DownloadAPdfAction()
			.navigatetoLatestStatement()
			.downloadPDF()
			.verifyPDFDownload()
			.logout();
	}

	//Data : Electricity Account, Statement generated
	@Test(groups = {Acquisition})
	public void verifyPDFDownloadOAMElecStatement(){
		Report.createTestLogHeader("Download A PDF Test", "Verify Download A PDF Statement For Electricity Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile);
		new DownloadAPdfAction()
			.navigatetoLatestStatement()
			.downloadPDF()
			.verifyPDFDownload()
			.logout();
	}
	
	//Data : JI Account, Statement generated
	@Test(groups = {Acquisition})
	public void verifyPDFDownloadOAMJIStatement(){
		Report.createTestLogHeader("Download A PDF Test", "Verify Download A PDF Statement For JI Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile);
		new DownloadAPdfAction()
			.navigatetoLatestStatement()
			.downloadPDF()
			.verifyPDFDownload()
			.logout();
	}
		
	//Data : Dual Account, Statement generated
	@Test(groups = {Acquisition})
	public void verifyPDFDownloadOAMDualStatement(){
		Report.createTestLogHeader("Download A PDF Test", "Verify Download A PDF Statement For Dual Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile);
		new DownloadAPdfAction()
			.navigatetoLatestStatement()
			.downloadPDF()
			.verifyPDFDownload()
			.logout();
	}
	
	//Data : Gas Account, Bill generated in current date, cash/cheque customer
	@Test(groups = {Acquisition})
	public void verifyPDFDownloadOAMGasMessage(){
		Report.createTestLogHeader("Download A PDF Test", "Verify Download A PDF Message For Gas Account");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile);
		new DownloadAPdfAction()
			.navigatetoLatestStatement()
			.downloadPDF()
			.verifyPDFDownloadGasMessage()
			.logout();
	}
	
	//Data : Gas Account, Bill entry not found in bill response table
	@Test(groups = {Acquisition})
	public void verifyPDFDownloadOAMGasWithoutBillEntry(){
		Report.createTestLogHeader("Download A PDF Test", "Verify Download A PDF Message For Gas Account without bill entry");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		new HomePageAction()
			.navigateToLogin()
			.login(userProfile)
			.navigateToAccountSummaryPage(userProfile);
		new DownloadAPdfAction()
			.navigatetoLatestStatement()
			.downloadPDF()
			.verifyPDFDownloadBillEntry()
			.logout();
	}
	
}
