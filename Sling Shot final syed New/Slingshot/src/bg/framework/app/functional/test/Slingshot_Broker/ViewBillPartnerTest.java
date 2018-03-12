package bg.framework.app.functional.test.Slingshot_Broker;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import static bg.framework.app.functional.entities.FunctionalCategory.Slingshot_Broker;
import static bg.framework.app.functional.entities.FunctionalCategory.ViewBill;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.testng.annotations.Test;
import bg.framework.app.functional.action.Slingshot.SubmitMeterReadAction;
import bg.framework.app.functional.action.Slingshot.ViewBillAction;
import bg.framework.app.functional.action.Slingshot_Broker.ViewBillPartnerAction;
import bg.framework.app.functional.entities.SMRAccountDetails;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import bg.framework.app.functional.page.common.SlingshotErrorMessages;
import bg.framework.app.functional.test.common.TestBase;

public class ViewBillPartnerTest extends TestBase {
	
	@Test(groups ={Slingshot_Broker,Regression,ViewBill})
	public void downloadAndVerifyBill()  {
		Report.createTestLogHeader("Search bill journey", "Verify search bill page on clicking view bill link");
		SMRAccountDetails smrProfile = new TestDataHelper().getAllSMRUserProfile("ViewBillPartner");
		new ViewBillPartnerAction()
		.navigateToPartnerLogin()
		.PartnerloginDetails(smrProfile)
		.downloadAndVerifyBill(smrProfile);

	}
}
