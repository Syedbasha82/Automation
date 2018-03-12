package bg.framework.app.functional.action.Slingshot_Broker;

import java.text.ParseException;

import bg.framework.app.functional.action.Slingshot.ViewBillAction;
import bg.framework.app.functional.entities.SMRAccountDetails;
import bg.framework.app.functional.page.Slingshot.ViewBillPage;
import bg.framework.app.functional.page.Slingshot_Broker.ViewBillPartnerPage;
import bg.framework.app.functional.page.common.LegacyHomePage;
import bg.framework.app.functional.page.common.LegacyLoginPage;

public class ViewBillPartnerAction {
	String[] SelectTerm={"Account number", "Bill number", "Meter point reference number"};
	
	public ViewBillPartnerAction navigateToPartnerLogin() {
		ViewBillPartnerPage PartnerLogin = new ViewBillPartnerPage();
		PartnerLogin.navigateToPartnerLogin(); 
		return this;
	}	
	public ViewBillPartnerAction PartnerloginDetails(SMRAccountDetails smrProfile) {
		ViewBillPartnerPage PartnerLogin = new ViewBillPartnerPage();
		PartnerLogin.PartnerloginDetails(smrProfile);
		return this;
	}	
	public ViewBillPartnerAction downloadAndVerifyBill(SMRAccountDetails smrProfile){
		String[] EnterSearchCriteria={smrProfile.getAccountNumber(), smrProfile.getBillNumber(), smrProfile.getMprn()};
		ViewBillPartnerPage viewbill=new ViewBillPartnerPage();
		viewbill.verifyPageTitle();
		for (int i=0;i<2;i++)
		{
		viewbill.selectTerm(SelectTerm[i]);
		viewbill.enterSearchCriteria(EnterSearchCriteria[i]);
		if(SelectTerm[i]!="Bill number")
		{
		viewbill.enterFromDate("3");
		viewbill.enterToDate("0");
		}
		viewbill.clickSearchBillSearchButton();
		viewbill.verifyBillTable();
		viewbill.selectCheckboxDownload();
		viewbill.clickSearchBillDownload();
		viewbill.saveFile();
		try {
			viewbill.openAndVerifyZipFile();
			viewbill.deleteFile();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return this;
		
	}	
}
