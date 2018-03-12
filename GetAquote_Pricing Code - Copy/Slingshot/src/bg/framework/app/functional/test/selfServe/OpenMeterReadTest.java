package bg.framework.app.functional.test.selfServe;

import bg.framework.app.functional.action.selfServe.OpenMeterReadAction;


import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import bg.framework.app.functional.util.SiebelDataBase;
import org.testng.annotations.Test;

import static bg.framework.app.functional.entities.FunctionalCategory.ManagePersonalDetails;
import static bg.framework.app.functional.entities.FunctionalCategory.OpenMeterRead;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;

public class OpenMeterReadTest extends TestBase {
	@SuppressWarnings("unchecked")
	
	@Test(groups = {Regression, OpenMeterRead})
	public void verifyOAMOpenMeterReadJourney() {
		UserProfile userProfile = new TestDataHelper().getUserProfile("SSOAccount");
		Report.createTestLogHeader("Open Meter Read", "OAM user Open Meter Read Journey");		
        UserProfile userProfileReset = userProfile;
        try
        {
        	new OpenMeterReadAction()
        					.navigateToLoginSSO()
        					.loginSSO(userProfile)
        					.navigateToSubmitMeterRead()
        					.navigateToSubmitOpenReading()
        					.fillGasMeterRead()
        					.verifyWithOnlineDB(userProfile)
        					.logout();
        }
        finally {
        	
        }
	}
	
	
}
