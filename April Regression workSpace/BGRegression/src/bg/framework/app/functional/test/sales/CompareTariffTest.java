package bg.framework.app.functional.test.sales;

import static bg.framework.app.functional.entities.FunctionalCategory.BG;
import static bg.framework.app.functional.entities.FunctionalCategory.CompareTariff;
import static bg.framework.app.functional.entities.FunctionalCategory.InsuranceQuote;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;

import java.io.IOException;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.sales.CompareTariffAction;
import bg.framework.app.functional.entities.CompareTariff;
import bg.framework.app.functional.entities.EshopTariffProfile;
import bg.framework.app.functional.entities.FunctionalCategory;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

import org.testng.annotations.Test;

public class CompareTariffTest extends TestBase{
	
	private int TariffIncrement;
	private int payIncrement;
	private String Tariff;
	private String pay;
	
	private String[] postCodes = {"AL10 8UW" , "LE12 9LX", "BR1 7YJ", "L22 5QH", "B10 9JU" , "DH2 7GH", "BB2 7DF" , "AB14 7GH",
            "DG10 7FG","KT17 3BH","BH7 6WD","CF10 6FG" , "BA3 7GH" ,"WF10 3NA"};
	
	/////////////////////// TC Num - TC_Comp_Tariff_anonymous_029 /////////////////////
	@Test(groups = { FunctionalCategory.Acquisition })
	public void verifyTariffInformationForAnonymous(){
		Report.createTestLogHeader("Tariff Information Page Journey", "Anonymous Journey");
		final CompareTariff compareTariff = new TestDataHelper().getCompareTariffProfiles("TariffNames"); 
		UserProfile userProfile = new TestDataHelper().getUserProfile("NewUser");
		for(String postCode : postCodes){
			Report.updateTestLog("*******************" + postCode  + "**********************", "Pass");
			TariffIncrement = 1;
			while((Tariff = compareTariff.getTariffName(TariffIncrement)) != ""){
				Report.updateTestLog("*********************    "+Tariff+"   **********************", "Pass");
				payIncrement = 1;
				while((pay = compareTariff.getPayment(TariffIncrement, payIncrement)) != ""){
					Report.updateTestLog("*********************    "+pay+"   **********************", "Pass");
					new CompareTariffAction()
					//.navigateToGasAndElecPage()
					//.navigateToOurTariffPage()
					.navigateToAllTariffPage()
					.enterPostCode("Anonymous", userProfile,postCode)
					.verifyCompareTariffPage("Normal",Tariff,pay, postCode);
					++payIncrement;
				}
				++TariffIncrement;
			}
		}

	}
	
	@Test(groups = { FunctionalCategory.Acquisition })
	public void verifyAllTariffInformation(){
		Report.createTestLogHeader("All Tariff Page", "Anonymous Journey");
		new CompareTariffAction()
		.navigateToAllTariffPage()
		.verifyTariffInformation();
	}

	
}
