package bg.framework.app.functional.test.reFactoring;
import static bg.framework.app.functional.entities.FunctionalCategory.MeterReadHistory;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import org.testng.annotations.Test;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.action.selfServe.AccountSummaryAction;
import bg.framework.app.functional.action.reFactoring.MeterReadHistoryAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class MeterReadHistoryTest extends TestBase
{
	/* This method was created for TOU Project
	 * Mandatory Fields
	 * Email ID and Account Number in userprofile.xml
	 */
	@Test(groups = {Regression,MeterReadHistory})
	public void MeterReadHistoryForElectricity()
	{
		Report.createTestLogHeader("MeterReadHistory", "ElectricityAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("ElectricityAccount1");
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToMeterReadHistory()
		.verifylinks()
		.verifyMeterReadTable(userProfile.getAccNumber(),"Electricity")
		.logout();
	}
	/* This method was created for TOU Project
	 * Mandatory Fields
	 * Email ID and Account Number in userprofile.xml
	 */
	@Test(groups = {Regression,MeterReadHistory})
	public void MeterReadHistoryForGas()
	{
		Report.createTestLogHeader("MeterReadHistory", "GasAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("GasAccount");
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToMeterReadHistory()
		.verifylinks()
		.verifyMeterReadTable(userProfile.getAccNumber(),"Gas")
		.logout();
	}
	/* This method was created for TOU Project
	 * Mandatory Fields
	 * Email ID and Account Number in userprofile.xml
	 */
	@Test(groups = {Regression,MeterReadHistory})
	public void MeterReadHistoryForJI()
	{
		Report.createTestLogHeader("MeterReadHistory", "JIAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("JIAccount");
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToMeterReadHistory()
		.verifylinks()
		.verifyMeterReadTable(userProfile.getAccNumber(),"JI")
		.logout();	
	}
	/* This method was created for TOU Project
	 * Mandatory Fields
	 * Email ID and Account Number in userprofile.xml
	 */
	@Test(groups = {Regression,MeterReadHistory})
	public void MeterReadHistoryForDual()
	{
		Report.createTestLogHeader("MeterReadHistory", "DualAccount");
		UserProfile userProfile= new TestDataHelper().getUserProfile("DualAccount");
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.navigateToAccountSummaryPage(userProfile)
		.navigateToMeterReadHistory()
		.verifylinks()
		.verifyMeterReadTable(userProfile.getGasAccount(),"Gas")
		.navigatetoElec()
		.verifyMeterReadTable(userProfile.getElecAccount(),"Electricity")
		.logout();
	}

}
