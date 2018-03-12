/**
 * 
 */
package bg.framework.app.functional.action.tetris;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.tetris.CopyBillRequestPage;
import bg.framework.app.functional.page.tetris.CorporateCallback_GasElecPage;
import bg.framework.app.functional.page.tetris.LargeBusinessElectricityCallBackPage;
import bg.framework.app.functional.page.tetris.MeterReadRemainderPage;
import bg.framework.app.functional.page.tetris.StatementOfAccountPage;

/**
 * @author 292238
 *
 */
public class MeterReadRemainderAction {
	public MeterReadRemainderAction openMeterReadRemainderPage(UserProfile userProfile){
		MeterReadRemainderPage meterReadRemainderPage = new MeterReadRemainderPage();
		meterReadRemainderPage.openMeterReadRemainderPage();
		return this;	
	}
	public MeterReadRemainderAction verifyAndEntervalues(UserProfile userProfile){
		MeterReadRemainderPage meterReadRemainderPage = new MeterReadRemainderPage();
		meterReadRemainderPage.entervalidData(userProfile);
		return this;	
	}
	public MeterReadRemainderAction verifyThankYouPage(UserProfile userProfile){
		MeterReadRemainderPage meterReadRemainderPage = new MeterReadRemainderPage();
		meterReadRemainderPage.verifyThankYouPage();
		return this;	
	}
	public MeterReadRemainderAction verifyDBDetails(UserProfile userProfile){
		MeterReadRemainderPage meterReadRemainderPage = new MeterReadRemainderPage();
		meterReadRemainderPage.verifyLeadTable(userProfile);
		return this;	
	}
	public MeterReadRemainderAction validateFirstnameFields(UserProfile userProfile){
		MeterReadRemainderPage meterReadRemainderPage = new MeterReadRemainderPage();
		meterReadRemainderPage.validateFieldsInMeterReadReminderPage(userProfile);
		return this;
	}
	
}
