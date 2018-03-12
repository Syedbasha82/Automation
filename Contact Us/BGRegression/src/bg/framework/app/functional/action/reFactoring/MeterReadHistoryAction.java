package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.page.reFactoring.MeterReadHistoryPage;

public class MeterReadHistoryAction {
//	public MeterReadHistoryAction navigateToMeterReadHistory(){
//		MeterReadHistoryPage viewmeterreadpage=new MeterReadHistoryPage();
//		viewmeterreadpage.navigateToMeterReadHistory();
//		return new MeterReadHistoryAction();
//	}

	public MeterReadHistoryAction verifylinks() {
		MeterReadHistoryPage verifylinks=new MeterReadHistoryPage();
		verifylinks.verifylinks();
		return new MeterReadHistoryAction();
		}

	public MeterReadHistoryAction verifyMeterReadTable(String accountNumber, String Fuel) {
		MeterReadHistoryPage verifyMR=new MeterReadHistoryPage();
		verifyMR.verifyMeterReadTable(accountNumber, Fuel);
		return new MeterReadHistoryAction();
	}

	public void logout() {
		MeterReadHistoryPage Logout=new MeterReadHistoryPage();
		Logout.logout();
	}

	public MeterReadHistoryAction navigatetoElec() {
		MeterReadHistoryPage verifyAdd=new MeterReadHistoryPage();
		verifyAdd.navigatetoElec();
		return new MeterReadHistoryAction();
		
	}
}
