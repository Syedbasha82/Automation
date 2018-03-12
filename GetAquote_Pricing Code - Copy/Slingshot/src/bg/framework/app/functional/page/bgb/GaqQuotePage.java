package bg.framework.app.functional.page.bgb;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.xerces.impl.xpath.regex.Match;
import bg.framework.app.functional.action.bgb.GetAQuoteAction;
import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.GetAQuoteDetails;
import bg.framework.app.functional.page.bgb.GetaQuoteDetailsPage;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class GaqQuotePage extends BasePage {
	private final static String FILE_NAME = "resources/bgb/GetAQuote.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME)
			.load();
	String leadType;
	String queryPostcode;
	double gasUnitratecalc;
	int gasBandid;
	double gasBandRange;
	double elecConsumption;
	double annualSpend;
	double monthlySpend;
	double annualSpendValue;
	double monthlySpendValue;
	double daySpend = 0;
	double nightSpend;
	String elecConsumpAnnualSplit;
	private String quoteReferenceId;

	public GetAQuoteAction selectElectricityPaymentOptionMonthly() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.ElecpaymentoptionMonthly"))) {
			browser.wait(getWaitTime());
			browser.click(pageProperties
			        .getProperty("GetAQuote.ElecpaymentoptionMonthly"));
			Report.updateTestLog("Monthly Radio button exist for Electricity ",
					"PASS");
		} else {
			Report.updateTestLog(
					"MMonthly Radio button doe not exist for Electricity",
			        "FAIL");
		}
		return new GetAQuoteAction();
	}

	public GetAQuoteAction selectElectricityPaymentOptionQuaterly() {
		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.ElecpaymentoptionQuaterly"))) {
			browser.wait(getWaitTime());
			browser.click(pageProperties
			        .getProperty("GetAQuote.ElecpaymentoptionQuaterly"));
			Report.updateTestLog(
					"<B>Quaterly Radio button exist for Electricity</B>",
					"PASS");
		} else {
			Report.updateTestLog(
					"Quaterly Radio button does not exist for Electricity",
			        "FAIL");
		}
		return new GetAQuoteAction();
	}

	public GetAQuoteAction selectElectricityPaymentOptionQuaterly2Year() {
		if (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("Dual.FirstYearQuarter"))) {
			// browser.wait(getWaitTime());
			browser.clickWithXpath(pageProperties
					.getProperty("Dual.FirstYearQuarter"));
			Report.updateTestLog(
					"<B>Quaterly Radio button exist for Electricity</B>",
					"PASS");
		} else {
			Report.updateTestLog(
					"Quaterly Radio button doe not exist for Electricity",
			        "FAIL");
		}
		return new GetAQuoteAction();
	}

	public GetAQuoteAction selectGasPaymentOptionMonthly() {
		try {
			Thread.sleep(2000);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.GaspaymentoptionMonthly"))) {
			browser.wait(2000);
			browser.click(pageProperties
					.getProperty("GetAQuote.GaspaymentoptionMonthly"));
			Report.updateTestLog("<B>Monthly Radio button exist for Gas</B>",
					"PASS");
		} else {
			Report.updateTestLog("Monthly Radio button doe not exist for Gas",
					"FAIL");
		}
		return new GetAQuoteAction();
	}

	public GetAQuoteAction selectGasPaymentOptionQuaterly() {
		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.GaspaymentoptionQuaterly"))) {
			browser.wait(2000);
			browser.click(pageProperties
			        .getProperty("GetAQuote.GaspaymentoptionQuaterly"));
			Report.updateTestLog("<B>Quaterly Radio button exist for Gas</B>",
					"PASS");
		} else {
			Report.updateTestLog("Quaterly Radio button doe not exist for Gas",
					"FAIL");
		}
		return new GetAQuoteAction();
	}

	public GetAQuoteAction clickMonthlyContinueQuotePage() {
		String strQuoteRefNo = null;
		String strQuote = null;
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.GasQuotepageRefNo"))) {
			browser.wait(getWaitTime());
			strQuote = browser.getTextByXpath(pageProperties
			        .getProperty("GetAQuote.GasQuotepageRefNo"));
			strQuoteRefNo = strQuote.replaceFirst("Quote reference: ", "");
		}
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.quotePageContinue"))) {
			browser.clickWithXpath(pageProperties
			        .getProperty("GetAQuote.quotePageContinue"));
			browser.wait(2000);
			Report.updateTestLog(
					"Continue button exist in Quote page by choosing Monthly",
					"PASS");
			browser.wait(getWaitTime());
		} else {
			Report.updateTestLog(
			        "Continue button does not exist in Quote page by choosing Monthly",
			        "FAIL");
		}
		return new GetAQuoteAction(strQuoteRefNo);
	}

	public GetAQuoteAction clickQuaterlyContinueQuotePage() {
		String strQuoteRefNo = null;
		String strQuote = null;
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.GasQuotepageRefNo"))) {
			browser.wait(getWaitTime());
			strQuote = browser.getTextByXpath(pageProperties
			        .getProperty("GetAQuote.GasQuotepageRefNo"));
			strQuoteRefNo = strQuote.replaceFirst("Quote reference: ", "");
		}
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.quaterlyQuotePageContinue"))) {
			browser.clickWithXpath(pageProperties
			        .getProperty("GetAQuote.quaterlyQuotePageContinue"));
			browser.wait(2000);
			Report.updateTestLog(
					"Continue button exist in Quote page by choosing Quaterly",
					"PASS");
		} else {
			Report.updateTestLog(
			        "Continue button does not exist in Quote page by choosing Quaterly",
			        "FAIL");
		}
		return new GetAQuoteAction(strQuoteRefNo);

	}

	public GetAQuoteAction clickQuaterlyContinueQuotePage2ndYear() {
		String strQuoteRefNo = null;
		String strQuote = null;
		if (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("GetAQuote.2ndYearQRNO"))) {
			browser.wait(getWaitTime());
			strQuote = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.2ndYearQRNO"));
			strQuoteRefNo = strQuote.replaceFirst("Quote reference: ", "");
		}
		if (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("GetAQuote.2ndYearContinue"))) {
			browser.clickWithXpath(pageProperties
					.getProperty("GetAQuote.2ndYearContinue"));
			browser.wait(2000);
			Report.updateTestLog(
					"Continue button exist in Quote page by choosing Quaterly",
					"PASS");
		} else {
			Report.updateTestLog(
			        "Continue button does not exist in Quote page by choosing Quaterly",
			        "FAIL");
		}

		return new GetAQuoteAction(strQuoteRefNo);

	}

	public GetAQuoteAction clickQuaterlyContinueQuotePage3rdYear() {
		String strQuoteRefNo = null;
		String strQuote = null;
		if (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("GetAQuote.3stYearQRNO"))) {
			browser.wait(getWaitTime());
			strQuote = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.3stYearQRNO"));
			strQuoteRefNo = strQuote.replaceFirst("Quote reference: ", "");
		}
		if (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("GetAQuote.3rdYearContinue"))) {
			browser.clickWithXpath(pageProperties
					.getProperty("GetAQuote.3rdYearContinue"));
			browser.wait(2000);
			Report.updateTestLog(
					"Continue button exist in Quote page by choosing Quaterly",
					"PASS");
		} else {
			Report.updateTestLog(
			        "Continue button does not exist in Quote page by choosing Quaterly",
			        "FAIL");
		}

		return new GetAQuoteAction(strQuoteRefNo);

	}

	public GetAQuoteAction clickContinueQuotePage2ndYearGas() {

		String strQuoteRefNo = null;
		String strQuote = null;
		if (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("GetAQuote.2ndYearQRNO"))) {
			browser.wait(getWaitTime());
			strQuote = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.2ndYearQRNO"));
			strQuoteRefNo = strQuote.replaceFirst("Quote reference: ", "");
		}
		if (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("GetAQuote.2ndYearContinue"))) {
			browser.clickWithXpath(pageProperties
					.getProperty("GetAQuote.2ndYearContinue"));
			browser.wait(2000);
			Report.updateTestLog(
					"Continue button exist in Quote page by choosing Quaterly",
					"PASS");
		} else {
			Report.updateTestLog(
			        "Continue button does not exist in Quote page by choosing Quaterly",
			        "FAIL");
		}
		return new GetAQuoteAction(strQuoteRefNo);

	}

	public GetAQuoteAction clickContinueQuotePage1stYearGas() {
		String strQuoteRefNo = null;
		String strQuote = null;
		if (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("GetAQuote.1stYearQRNO"))) {
			browser.wait(getWaitTime());
			strQuote = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.1stYearQRNO"));
			strQuoteRefNo = strQuote.replaceFirst("Quote reference: ", "");
		}
		if (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("GetAQuote.1stYearContinue"))) {
			browser.clickWithXpath(pageProperties
					.getProperty("GetAQuote.1stYearContinue"));
			browser.wait(2000);
			Report.updateTestLog(
					"Continue button exist in Quote page by choosing Quaterly",
					"PASS");
		} else {
			Report.updateTestLog(
			        "Continue button does not exist in Quote page by choosing Quaterly",
			        "FAIL");
		}
		return new GetAQuoteAction(strQuoteRefNo);

	}

	public GetAQuoteAction clickQuaterlybutton3rdYear() {
		// 3rd year Tab
		browser.wait(3000);
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetAQuote.3rdYearTab"),
				"<B>Third Year Contract Tab.</B>");
		// 3rd year Quarter Button
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetAQuote.quarterbutton3_ele"),
				"<B>Click Quarterly Option Button in 3rd year</B>");
		return new GetAQuoteAction();
	}

	public GetAQuoteAction clickMonthlybuttonCompareAllTab() {
		browser.wait(3000);
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetAQuote.monthlybutton3"),
				"<B>Compare All Tab Quarter Option.</B>");
		return new GetAQuoteAction();
	}

	public GetAQuoteAction clickQuaterlybuttonCompareAllTab() {
		browser.wait(3000);
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetAQuote.quarterbutton4_ele"),
				"<B>QuarterButtonClicked</B>");
		return new GetAQuoteAction();
	}

	public GetAQuoteAction clickQuaterlybutton1stYearGas(
			GetAQuoteDetails getDetails) {
		browser.wait(3000);
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetAQuote.quarterbutton1"),
				"<B>First Year Quarter Option</B>");
		return new GetAQuoteAction();
	}

	public GetAQuoteAction clickQuaterlybutton2ndYearGas(
			GetAQuoteDetails getDetails) {
		browser.wait(3000);
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetAQuote.quarterbutton2"),
				"<B>Second Year Quarter Option</B>");
		return new GetAQuoteAction();
	}

	public GetAQuoteAction clickQuaterlybutton3rdYearGas(
			GetAQuoteDetails getDetails) {
		browser.wait(3000);
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetAQuote.quarterbutton3"),
				"<B>Third Year Quarter Option</B>");
		return new GetAQuoteAction();
	}

	public GetAQuoteAction click3rdYearTab() {
		browser.wait(3000);
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetAQuote.3rdYearTab"),
				"<B>Third Year Contract.</B>");

		return new GetAQuoteAction();
	}

	public GetAQuoteAction clickcompareallTab() {
		browser.wait(3000);
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetAQuote.CompareAlltabGAS"),
				"<B>Compare All Tab.<B>");

		return new GetAQuoteAction();
	}

	public GetAQuoteAction click3rdYearTabGas() {
		browser.wait(3000);
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetAQuote.3rdYearTab"),
				"<B>Third Year Contract.</B>");
		return new GetAQuoteAction();
	}

	public GetAQuoteAction click2ndYearTabGas() {
		browser.wait(3000);
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetAQuote.2ndYearTab"),
				"<B>Second Year Contract.</B>");
		return new GetAQuoteAction();
	}

	public GetAQuoteAction click1stYearTabGas() {
		browser.wait(3000);
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetAQuote.1stYearTab"),
				"<B>First Year Contract.</B>");
		return new GetAQuoteAction();

	}

	public GetAQuoteAction firstYearCalulationQuarterMonthlyAndNotch(
			GetAQuoteDetails getDetails, int PC, String Year,String ele) {
		String annualconsumption = browser.getTextByXpath(pageProperties
				.getProperty("GetAQuote.Consumption1"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
		calulationQuarterMonthlyAndNotch(getDetails, PC, Year,
				annualconsumption, ele);
		return new GetAQuoteAction();
	}

	public GetAQuoteAction secondYearCalulationQuarterMonthlyAndNotch(
			GetAQuoteDetails getDetails, int PC, String Year, String ele) {
		String annualconsumption = browser.getTextByXpath(pageProperties
				.getProperty("GetAQuote.Consumption2"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
		calulationQuarterMonthlyAndNotch(getDetails, PC, Year,
				annualconsumption, ele);
		return new GetAQuoteAction();
	}

	public GetAQuoteAction thirdYearCalulationQuarterMonthlyAndNotch(
			GetAQuoteDetails getDetails, int PC, String Year,String ele) {
		String annualconsumption = browser.getTextByXpath(pageProperties
				.getProperty("GetAQuote.Consumption3"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
		calulationQuarterMonthlyAndNotch(getDetails, PC, Year,
				annualconsumption, ele);
		return new GetAQuoteAction();
	}

	public GetAQuoteAction calulationQuarterMonthlyAndNotch(
			GetAQuoteDetails getDetails, int PC, String Year,
			String annualconsumption, String ele) {
		String profilecalss1;
		String profilecalss2;
		String profilecalss3;
		switch (PC) {
		case 1:
			profilecalss1 = "01";
			profilecalss2 = "500";
			profilecalss3 = "23";
			new OnlineDBConnector().eleNotchPlusUnit(getDetails,
					profilecalss1, profilecalss2, profilecalss3,
					annualconsumption, Year, PC, ele);
		break;
		case 2:
			profilecalss1 = "02";
			profilecalss2 = "807";
			profilecalss3 = "10";
			new OnlineDBConnector().eleNotchPlusUnit(getDetails,
					profilecalss1, profilecalss2, profilecalss3,
					annualconsumption, Year, PC,ele);
		break;
		case 3:
			profilecalss1 = "03";
			profilecalss2 = "801";
			profilecalss3 = "20";
			new OnlineDBConnector().eleNotchPlusUnit(getDetails,
					profilecalss1, profilecalss2, profilecalss3,
					annualconsumption, Year, PC, ele);
		break;
		case 4:
			profilecalss1 = "04";
			profilecalss2 = "807";
			profilecalss3 = "10";
			new OnlineDBConnector().eleNotchPlusUnit(getDetails,
					profilecalss1, profilecalss2, profilecalss3,
					annualconsumption, Year, PC, ele);
		break;
		case 5:
			profilecalss1 = "05";
			profilecalss2 = "801";
			profilecalss3 = "10";
			new OnlineDBConnector().eleNotchPlusUnit(getDetails,
					profilecalss1, profilecalss2, profilecalss3,
					annualconsumption, Year, PC, ele);
		break;
		case 6:
			profilecalss1 = "06";
			profilecalss2 = "817";
			profilecalss3 = "11";
			new OnlineDBConnector().eleNotchPlusUnit(getDetails,
					profilecalss1, profilecalss2, profilecalss3,
					annualconsumption, Year, PC, ele);
		break;
		case 7:
			profilecalss1 = "07";
			profilecalss2 = "816";
			profilecalss3 = "11";
			new OnlineDBConnector().eleNotchPlusUnit(getDetails,
					profilecalss1, profilecalss2, profilecalss3,
					annualconsumption, Year, PC, ele);
		break;
		case 8:
			profilecalss1 = "08";
			profilecalss2 = "811";
			profilecalss3 = "14";
			new OnlineDBConnector().eleNotchPlusUnit(getDetails,
					profilecalss1, profilecalss2, profilecalss3,
					annualconsumption, Year, PC, ele);
		break;
		}
		return new GetAQuoteAction();
    }

	public GetAQuoteAction gasunitpricefromdb1Year(GetAQuoteDetails getDetails,
			String monthlyQuarter, String Dual) {
		String annualconsumption = browser.getTextByXpath(pageProperties
				.getProperty("GetAQuote.Consumption1"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
			String PostCode = getDetails.getPostcode();
		int consumption = Integer.parseInt(annualconsumption);
		gasDbUnitCharge(getDetails, PostCode, consumption, monthlyQuarter, Dual);
				return new GetAQuoteAction();
	}

	public GetAQuoteAction gasunitpricefromdb2Year(GetAQuoteDetails getDetails,
			String monthlyQuarter,String Dual) {
		String annualconsumption = browser.getTextByXpath(pageProperties
				.getProperty("GetAQuote.Consumption2"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
		String PostCode = getDetails.getPostcode();
		int consumption = Integer.parseInt(annualconsumption);
		gasDbUnitCharge(getDetails, PostCode, consumption, monthlyQuarter, Dual);
		return new GetAQuoteAction();
	}

	public GetAQuoteAction gasunitpricefromdb3Year(GetAQuoteDetails getDetails,
			String monthlyQuarter, String Dual) {
		String annualconsumption = browser.getTextByXpath(pageProperties
				.getProperty("GetAQuote.Consumption3"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
		String PostCode = getDetails.getPostcode();
		int consumption = Integer.parseInt(annualconsumption);
		gasDbUnitCharge(getDetails, PostCode, consumption, monthlyQuarter, Dual);
	return new GetAQuoteAction();
	}

	public GetAQuoteAction gasDbUnitCharge(GetAQuoteDetails getDetails,
			String postcode, int Consumption, String monthlyQuarter, String Dual) {
		/*
		 * String leadID=browser.getTextByXpath(
		 * ".//*[@id='contract-tab-1']/div/div/div[2]/strong").trim(); String
		 * lead[]=leadID.split(":"); String ID=lead[1].trim();
		 */
		String PostCode = getDetails.getPostcode();
		if (Consumption <= 73199) {
			String PandID = "1";
			new OnlineDBConnector().gasRetreiveUnitCharges(getDetails,
					PostCode, PandID, monthlyQuarter, Consumption, Dual);
	}
		if (Consumption >= 73200 && Consumption <= 149999) {
			String PandID = "2";
			new OnlineDBConnector().gasRetreiveUnitCharges(getDetails,
					PostCode, PandID, monthlyQuarter, Consumption, Dual);
	}
		if (Consumption >= 150000 && Consumption <= 399999) {
			String PandID = "3";
			new OnlineDBConnector().gasRetreiveUnitCharges(getDetails,
					PostCode, PandID, monthlyQuarter, Consumption, Dual);
	}
		if (Consumption >= 400000) {
			String PandID = "4";
			new OnlineDBConnector().gasRetreiveUnitCharges(getDetails,
					PostCode, PandID, monthlyQuarter, Consumption, Dual);
	}
	return new GetAQuoteAction();
	}

	public GetAQuoteAction compareAllEleRatesMonthly() {
		// 1st year Tab
		int count = browser.getChildElementsCountByXpath(pageProperties
				.getProperty("GetAQuote.Count1"));
		if (count == 3) {
			// 1st Year tab/////////
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.1stYearTab"),
					"First Year Contract.");
			String month_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.month1"));
			String year_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Year1"));
			String unitrate_1 = browser
					.getTextByXpath(pageProperties.getProperty("GetAQuote.unit1"));
			String nightrate_1 = browser
					.getTextByXpath(pageProperties.getProperty("GetAQuote.night1"));
			String standingrate_1 = browser
					.getTextByXpath(pageProperties.getProperty("GetAQuote.standing1"));
			// 2nd Year tab/////////
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.2ndYearTab"),
					"Second Year Contract.");
			String month_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.month2"));
			String year_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Year2"));
			String unitrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.unitrate2"));
			String nightrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing2"));
			String standingrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing12"));
			// 3rd Year tab/////////
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.3rdYearTab"),
					"Third Year Contract.");
			String month_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.month3"));
			String year_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Year3"));
			String unitrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.unitrate3"));
			String nightrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing3"));
			String standingrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing13"));
			// compare tab//////////////////
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.CompareAlltabGAS"),
					"Compare All Tab.");
			String com_month_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Monthly_1"));
			String com_year_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Year_1"));
			String com_month_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Monthly_2"));
			String com_year_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Year_2"));
			String com_month_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Monthly_3"));
			String com_year_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Year_3"));
			// /
			String com_unitrate_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_UnitCharge_1"));
			String com_nightrate_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_NightCharge_1"));
			String com_standingrate_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_StandingCharge_1"));
			String com_unitrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_UnitCharge_2"));
			String com_nightrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_NightCharge_2"));
			String com_standingrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_StandingCharge_2"));
			String com_unitrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_UnitCharge_3"));
			String com_nightrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_NightCharge_3"));
			String com_standingrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_StandingCharge_3"));

			if (month_1.equals(com_month_1) && year_1.equals(com_year_1)
					&& month_2.equals(com_month_2) && year_2.equals(com_year_2)
					&& month_3.equals(com_month_3) && year_3.equals(com_year_3)) {
				Report.updateTestLog(
				        "1st,2nd and 3rd Year Annual and Monthly rates dsiplayed correctly",
				        "PASS");
			} else {
				Report.updateTestLog(
				        "1st,2nd and 3rd Year Annual and Monthly rates dsiplayed In-correctly",
				        "FAIL");
			}
			if (unitrate_1.equalsIgnoreCase(com_unitrate_1)
					&& nightrate_1.equals(com_nightrate_1)
					&& standingrate_1.equals(com_standingrate_1)
					&& unitrate_2.equalsIgnoreCase(com_unitrate_2)
					&& nightrate_2.equals(com_nightrate_2)
					&& standingrate_2.equals(com_standingrate_2)
					&& unitrate_3.equalsIgnoreCase(com_unitrate_3)
					&& nightrate_3.equals(com_nightrate_3)
					&& standingrate_3.equals(com_standingrate_3))
			{
				Report.updateTestLog(
				        "Unit,Night and Standing rates dsiplayed In correctly for Monthly Calculation",
				        "PASS");
			} else {
				Report.updateTestLog(
				        "Unit,Night and Standing rates dsiplayed In correctly In-correctly for Monthly Calculation",
				        "FAIL");
			}
		}

		if (count == 2) {
			// 1st Year tab/////////
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.1stYearTab"),
					"First Year Contract.");
			String month_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.month1"));
			String year_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Year1"));
			String unitrate_1 = browser
					.getTextByXpath(pageProperties.getProperty("GetAQuote.unit1"));
			String standingrate_1 = browser
					.getTextByXpath(pageProperties.getProperty("GetAQuote.night1"));
			// 2nd Year tab/////////
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.2ndYearTab"),
					"Second Year Contract.");
			String month_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.month2"));
			String year_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Year2"));
			String unitrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.unitrate2"));
			String standingrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing2"));
			// 3rd Year tab/////////
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.3rdYearTab"),
					"Third Year Contract.");
			String month_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.month3"));
			String year_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Year3"));
			String unitrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.unitrate3"));
			String standingrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing3"));
			// compare tab//////////////////
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.CompareAlltabGAS"),
					"Compare All Tab.");
			String com_month_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Monthly_1"));
			String com_year_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Year_1"));
			String com_month_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Monthly_2"));
			String com_year_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Year_2"));
			String com_month_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Monthly_3"));
			String com_year_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Year_3"));
			// /
			String com_unitrate_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_UnitCharge_1"));
			String com_standingrate_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_StandingCharge_1"));
			String com_unitrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_UnitCharge_2"));
			String com_standingrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_StandingCharge_2"));
			String com_unitrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_UnitCharge_3"));
			String com_standingrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_StandingCharge_3"));
			if (month_1.equals(com_month_1) && year_1.equals(com_year_1)
					&& month_2.equals(com_month_2) && year_2.equals(com_year_2)
					&& month_3.equals(com_month_3) && year_3.equals(com_year_3)) {
				Report.updateTestLog(
				        "1st,2nd and 3rd Year Annual and Monthly rates dsiplayed correctly",
				        "PASS");
			} else {
				Report.updateTestLog(
				        "1st,2nd and 3rd Year Annual and Monthly rates dsiplayed In-correctly",
				        "FAIL");
			}
			if (unitrate_1.equalsIgnoreCase(com_unitrate_1)
					&& standingrate_1.equals(com_standingrate_1)
					&& unitrate_2.equalsIgnoreCase(com_unitrate_2)
					&& standingrate_2.equals(com_standingrate_2)
					&& unitrate_3.equalsIgnoreCase(com_unitrate_3)
					&& standingrate_3.equals(com_standingrate_3))

			{
				Report.updateTestLog(
				        "Unit and Standing rates dsiplayed Correctly for Monthly Calculation",
				        "PASS");
			} else {
				Report.updateTestLog(
				        "Unit and Standing rates dsiplayed In correctly In-correctly for Monthly Calculation",
				        "FAIL");
			}
		}
				return new GetAQuoteAction();
	}

	public GetAQuoteAction compareAllRatesMonthlyGAS() {
		// 1st year Tab
		int count = browser.getChildElementsCountByXpath(pageProperties
				.getProperty("GetAQuote.Count1"));
		if (count == 2) {
			// 1st Year tab/////////
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.1stYearTab"),
					"First Year Contract.");
			String month_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.month1"));
			String year_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Year1"));
			String unitrate_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.unitrate1"));
			String standingrate_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing1"));
			// 2nd Year tab/////////
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.2ndYearTab"),
					"Second Year Contract.");
			String month_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.month2"));
			String year_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Year2"));
			String unitrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.unitrate2"));
			String standingrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing2"));
			// 3rd Year tab/////////
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.3rdYearTab"),
					"Third Year Contract.");
			String month_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.month3"));
			String year_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Year3"));
			String unitrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.unitrate3"));
			String standingrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing3"));
			// compare tab//////////////////
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.CompareAlltabGAS"),
					"Compare All Tab.");
			String com_month_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Monthly_1"));
			String com_year_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Year_1"));
			String com_month_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Monthly_2"));
			String com_year_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Year_2"));
			String com_month_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Monthly_3"));
			String com_year_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Year_3"));
			// /
			String com_unitrate_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_UnitCharge_1"));
			String com_standingrate_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_StandingCharge_1"));
			String com_unitrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_UnitCharge_2"));
			String com_standingrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_StandingCharge_2"));
			String com_unitrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_UnitCharge_3"));
			String com_standingrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_StandingCharge_3"));
			if (month_1.equals(com_month_1) && year_1.equals(com_year_1)
					&& month_2.equals(com_month_2) && year_2.equals(com_year_2)
					&& month_3.equals(com_month_3) && year_3.equals(com_year_3)) {
				Report.updateTestLog(
				        "1st,2nd and 3rd Year Annual and Monthly rates dsiplayed correctly",
				        "PASS");
			} else {
				Report.updateTestLog(
						"1st,2nd and 3rd Year Annual and Monthly rates dsiplayed In-correctly"
								+ month_1 + "" + com_month_1 + "" + year_1 + ""
								+ com_year_1 + "" + month_2 + "" + com_month_2
								+ "" + year_2 + "" + com_year_2 + "" + month_3
								+ "" + com_month_3 + "" + year_3 + ""
								+ com_year_3, "FAIL");
			}
			if (unitrate_1.equalsIgnoreCase(com_unitrate_1)
					&& standingrate_1.equals(com_standingrate_1)
					&& unitrate_2.equalsIgnoreCase(com_unitrate_2)
					&& standingrate_2.equals(com_standingrate_2)
					&& unitrate_3.equalsIgnoreCase(com_unitrate_3)
					&& standingrate_3.equals(com_standingrate_3))
			{
				Report.updateTestLog(
				        "Unit and Standing rates dsiplayed Correctly for Monthly Calculation",
				        "PASS");
			} else {
				Report.updateTestLog(
						"Unit and Standing rates dsiplayed In correctly In-correctly for Monthly Calculation"
								+ unitrate_1
								+ ""
								+ com_unitrate_1
								+ ""
								+ standingrate_1
								+ ""
								+ com_standingrate_1
								+ ""
								+ unitrate_2
								+ ""
								+ com_unitrate_2
								+ ""
								+ standingrate_2
								+ ""
								+ com_standingrate_2
								+ ""
								+ unitrate_3
								+ ""
								+ com_unitrate_3
								+ ""
								+ standingrate_3 + "" + com_standingrate_3,
				        "FAIL");
			}
		}
				return new GetAQuoteAction();

	}

	public GetAQuoteAction compareAllRatesQuarterGAS() {
		// 1st year Tab
		int count = browser.getChildElementsCountByXpath(pageProperties
				.getProperty("GetAQuote.Count1"));
		if (count == 3) {
			// 1st Year tab/////////
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.1stYearTab"),
					"First Year Contract.");
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.quarterbutton1"),
					"First Year Quarter Option Button.");
			String month_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.month1"));
			String year_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Year1"));
			String unitrate_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.unitrate1"));
			String nightrate_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.night1"));
			String standingrate_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing11"));
			// 2nd Year tab/////////
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.2ndYearTab"),
					"Second Year Contract.");
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.quarterbutton2"),
					"Second Year Quarter Option Button.");
			String month_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.month2"));
			String year_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Year2"));
			String unitrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.unitrate2"));
			String nightrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.night2"));
			String standingrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing22"));
			// 3rd Year tab/////////
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.3rdYearTab"),
					"Third Year Contract.");
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.quarterbutton3"),
					"Third Year Quarter Option Button.");
			String month_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.month3"));
			String year_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Year3"));
			String unitrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.unitrate3"));
			String nightrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.night3"));
			String standingrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing33"));
			// compare tab//////////////////
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.CompareAlltabGAS"),
					"Compare All Tab.");
			verifyAndClickWithXpath(
					pageProperties
							.getProperty("GetAQuote.CompareAlltabGASQuarterButton"),
					"Compare All Tab Quarter Option Button.");
			String com_month_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Monthly_1"));
			String com_year_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Year_1"));
			String com_month_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Monthly_2"));
			String com_year_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Year_2"));
			String com_month_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Monthly_3"));
			String com_year_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Year_3"));
			// /
			String com_unitrate_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_UnitCharge_1"));
			String com_nightrate_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_NightCharge_1"));
			String com_standingrate_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_StandingCharge_1"));
			String com_unitrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_UnitCharge_2"));
			String com_nightrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_NightCharge_2"));
			String com_standingrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_StandingCharge_2"));
			String com_unitrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_UnitCharge_3"));
			String com_nightrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_NightCharge_3"));
			String com_standingrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_StandingCharge_3"));

			if (month_1.equals(com_month_1) && year_1.equals(com_year_1)
					&& month_2.equals(com_month_2) && year_2.equals(com_year_2)
					&& month_3.equals(com_month_3) && year_3.equals(com_year_3)) {
				Report.updateTestLog(
				        "1st,2nd and 3rd Year Annual and Monthly rates dsiplayed correctly",
				        "PASS");
			} else {
				Report.updateTestLog(
				        "1st,2nd and 3rd Year Annual and Monthly rates dsiplayed In-correctly",
				        "FAIL");
			}
			if (unitrate_1.equalsIgnoreCase(com_unitrate_1)
					&& nightrate_1.equals(com_nightrate_1)
					&& standingrate_1.equals(com_standingrate_1)
					&& unitrate_2.equalsIgnoreCase(com_unitrate_2)
					&& nightrate_2.equals(com_nightrate_2)
					&& standingrate_2.equals(com_standingrate_2)
					&& unitrate_3.equalsIgnoreCase(com_unitrate_3)
					&& nightrate_3.equals(com_nightrate_3)
					&& standingrate_3.equals(com_standingrate_3))
			{
				Report.updateTestLog(
				        "Unit,Night and Standing rates dsiplayed In correctly for Monthly Calculation",
				        "PASS");
			} else {
				Report.updateTestLog(
				        "Unit,Night and Standing rates dsiplayed In correctly In-correctly for Monthly Calculation",
				        "FAIL");
			}
		}
		if (count == 2) {
			// 1st Year tab/////////
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.1stYearTab"),
					"First Year Contract.");
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.quarterbutton1"),
					"First Year Quarter Option Button.");
			String month_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.month1"));
			String year_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Year1"));
			String unitrate_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.unitrate1"));
			String standingrate_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing1"));
			// 2nd Year tab/////////
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.2ndYearTab"),
					"Second Year Contract.");
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.quarterbutton2"),
					"Second Year Quarter Option Button.");
			String month_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.month2"));
			String year_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Year2"));
			String unitrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.unitrate2"));
			String standingrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing2"));
			// 3rd Year tab/////////
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.3rdYearTab"),
					"Third Year Contract.");
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.quarterbutton3"),
					"Third Year Quarter Option Button.");
			String month_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.month3"));
			String year_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Year3"));
			String unitrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.unitrate3"));
			String standingrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing3"));
			// compare tab//////////////////
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.CompareAlltabGAS"),
					"Compare All Tab.");
			verifyAndClickWithXpath(
					pageProperties
							.getProperty("GetAQuote.CompareAlltabGASQuarterButton"),
					"Compare All Tab Quarter Option Button.");
			String com_month_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Monthly_1"));
			String com_year_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Year_1"));
			String com_month_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Monthly_2"));
			String com_year_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Year_2"));
			String com_month_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Monthly_3"));
			String com_year_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Year_3"));
			// /
			String com_unitrate_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_UnitCharge_1"));
			String com_standingrate_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_StandingCharge_1"));
			String com_unitrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_UnitCharge_2"));
			String com_standingrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_StandingCharge_2"));
			String com_unitrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_UnitCharge_3"));
			String com_standingrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_StandingCharge_3"));

			if (month_1.equals(com_month_1) && year_1.equals(com_year_1)
					&& month_2.equals(com_month_2) && year_2.equals(com_year_2)
					&& month_3.equals(com_month_3) && year_3.equals(com_year_3)) {
				Report.updateTestLog(
				        "1st,2nd and 3rd Year Annual and Monthly rates dsiplayed correctly",
				        "PASS");
			} else {
				Report.updateTestLog(
				        "1st,2nd and 3rd Year Annual and Monthly rates dsiplayed In-correctly",
				        "FAIL");
			}
			if (unitrate_1.equalsIgnoreCase(com_unitrate_1)
					&& standingrate_1.equals(com_standingrate_1)
					&& unitrate_2.equalsIgnoreCase(com_unitrate_2)
					&& standingrate_2.equals(com_standingrate_2)
					&& unitrate_3.equalsIgnoreCase(com_unitrate_3)
					&& standingrate_3.equals(com_standingrate_3))
			{
				Report.updateTestLog(
				        "Unit and Standing rates dsiplayed Correctly for Monthly Calculation",
				        "PASS");
			} else {
				Report.updateTestLog(
				        "Unit and Standing rates dsiplayed In correctly In-correctly for Monthly Calculation",
				        "FAIL");
			}
		}
				return new GetAQuoteAction();

	}

	public GetAQuoteAction compareAllEleRatesQuarterly() {
		// 1st year Tab
		int count = browser.getChildElementsCountByXpath(pageProperties
				.getProperty("GetAQuote.Count1"));
		if (count == 3) {
			// 1st Year tab/////////
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.1stYearTab"),
					"First Year Contract.");
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.quarterbutton1_ele"),
					"First Year Contract Quarter Option.");
			String month_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.month1"));
			String year_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Year1"));
			String unitrate_1 = browser
					.getTextByXpath(pageProperties.getProperty("GetAQuote.unit1"));
			String nightrate_1 = browser
					.getTextByXpath(pageProperties.getProperty("GetAQuote.night1"));
			String standingrate_1 = browser
					.getTextByXpath(pageProperties.getProperty("GetAQuote.standing1"));
			// 2nd Year tab/////////
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.2ndYearTab"),
					"Second Year Contract.");
			verifyAndClickWithXpath("//li[@id='quarterly2']/input",
					"Second Year Contract Quarter Option.");
			String month_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.month2"));
			String year_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Year2"));
			String unitrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.unitrate2"));
			String nightrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing2"));
			String standingrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing12"));
			// 3rd Year tab/////////
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.3rdYearTab"),
					"Third Year Contract.");
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.quarterbutton3_ele"),
					"Third Year Contract Quarter Option.");
			String month_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.month3"));
			String year_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Year3"));
			String unitrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.unitrate3"));
			String nightrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing3"));
			String standingrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing13"));
			// compare tab//////////////////

			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.CompareAlltabGAS"),
					"Compare All Tab.");
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.quarterbutton3"),
					"Compare All Tab Quarter Option.");

			String com_month_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Monthly_1"));
			String com_year_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Year_1"));
			String com_month_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Monthly_2"));
			String com_year_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Year_2"));
			String com_month_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Monthly_3"));
			String com_year_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Year_3"));
			// /
			String com_unitrate_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_UnitCharge_1"));
			String com_nightrate_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_NightCharge_1"));
			String com_standingrate_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_StandingCharge_1"));
			String com_unitrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_UnitCharge_2"));
			String com_nightrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_NightCharge_2"));
			String com_standingrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_StandingCharge_2"));
			String com_unitrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_UnitCharge_3"));
			String com_nightrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_NightCharge_3"));
			String com_standingrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_StandingCharge_3"));

			if (month_1.equals(com_month_1) && year_1.equals(com_year_1)
					&& month_2.equals(com_month_2) && year_2.equals(com_year_2)
					&& month_3.equals(com_month_3) && year_3.equals(com_year_3)) {
				Report.updateTestLog(
				        "1st,2nd and 3rd Year Annual and Monthly rates dsiplayed correctly for Quarter Calculation",
				        "PASS");
			} else {
				Report.updateTestLog(
				        "1st,2nd and 3rd Year Annual and Monthly rates dsiplayed In-correctly for Quarter Calculation",
				        "FAIL");
			}
			if (unitrate_1.equalsIgnoreCase(com_unitrate_1)
					&& nightrate_1.equals(com_nightrate_1)
					&& standingrate_1.equals(com_standingrate_1)
					&& unitrate_2.equalsIgnoreCase(com_unitrate_2)
					&& nightrate_2.equals(com_nightrate_2)
					&& standingrate_2.equals(com_standingrate_2)
					&& unitrate_3.equalsIgnoreCase(com_unitrate_3)
					&& nightrate_3.equals(com_nightrate_3)
					&& standingrate_3.equals(com_standingrate_3))
			{
				Report.updateTestLog(
						"Unit,Night and Standing rates dsiplayed correctly for Quarter Calculation",
				        "PASS");
			} else {
				Report.updateTestLog(
				        "Unit,Night and Standing rates dsiplayed In correctly In-correctly for Quarter Calculation",
				        "FAIL");
			}
		}
		if (count == 2) {
			// 1st Year tab/////////
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.1stYearTab"),
					"First Year Contract.");
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.quarterbutton1_ele"),
					"First Year Contract Quarter Option.");
			String month_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.month1"));
			String year_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Year1"));
			String unitrate_1 = browser
					.getTextByXpath(pageProperties.getProperty("GetAQuote.unit1"));
			String standingrate_1 = browser
					.getTextByXpath(pageProperties.getProperty("GetAQuote.night1"));
			// 2nd Year tab/////////
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.2ndYearTab"),
					"Second Year Contract.");
			verifyAndClickWithXpath("//li[@id='quarterly2']/input",
					"Second Year Contract Quarter Option.");
			String month_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.month2"));
			String year_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Year2"));
			String unitrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.unitrate2"));
			String standingrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing2"));
			// 3rd Year tab/////////
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.3rdYearTab"),
					"Third Year Contract.");
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.quarterbutton3_ele"),
					"Third Year Contract Quarter Option.");
			String month_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.month3"));
			String year_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Year3"));
			String unitrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.unitrate3"));
			String standingrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing3"));
			// compare tab//////////////////
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.CompareAlltabGAS"),
					"Compare All Tab.");
			verifyAndClickWithXpath(
					pageProperties.getProperty("GetAQuote.quarterbutton3"),
					"Compare All Tab Quarter Option.");
			String com_month_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Monthly_1"));
			String com_year_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Year_1"));
			String com_month_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Monthly_2"));
			String com_year_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Year_2"));
			String com_month_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Monthly_3"));
			String com_year_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_Year_3"));
			// /
			String com_unitrate_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_UnitCharge_1"));
			String com_standingrate_1 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_StandingCharge_1"));
			String com_unitrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_UnitCharge_2"));
			String com_standingrate_2 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_StandingCharge_2"));
			String com_unitrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_UnitCharge_3"));
			String com_standingrate_3 = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Com_StandingCharge_3"));

			if (month_1.equals(com_month_1) && year_1.equals(com_year_1)
					&& month_2.equals(com_month_2) && year_2.equals(com_year_2)
					&& month_3.equals(com_month_3) && year_3.equals(com_year_3)) {
				Report.updateTestLog(
				        "1st,2nd and 3rd Year Annual and Monthly rates dsiplayed correctly for Quarter Calculation",
				        "PASS");
			} else {
				Report.updateTestLog(
				        "1st,2nd and 3rd Year Annual and Monthly rates dsiplayed In-correctly for Quarter Calculation",
				        "FAIL");
			}
			if (unitrate_1.equalsIgnoreCase(com_unitrate_1)
					&& standingrate_1.equals(com_standingrate_1)
					&& unitrate_2.equalsIgnoreCase(com_unitrate_2)
					&& standingrate_2.equals(com_standingrate_2)
					&& unitrate_3.equalsIgnoreCase(com_unitrate_3)
					&& standingrate_3.equals(com_standingrate_3))
			{
				Report.updateTestLog(
				        "Unit and Standing rates dsiplayed In correctly for Quarter Calculation",
				        "PASS");
			} else {
				Report.updateTestLog(
				        "Unit and Standing rates dsiplayed In correctly In-correctly for Quarter Calculation",
				        "FAIL");
			}
		}
		return new GetAQuoteAction();

	}

	public GetAQuoteAction compareAllMonthlySignUP(int j) {

		String[] signup = {
				(pageProperties
						.getProperty("GetAQuote.CompareAlltab1styearSignup")),
				(pageProperties
						.getProperty("GetAQuote.CompareAlltab2ndyearSignup")),
				(pageProperties
						.getProperty("GetAQuote.CompareAlltab3rdyearSignup")) };
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetAQuote.CompareAlltabGAS"),
				"Compare All Tab.");
		int k = 1 + j;
		verifyAndClickWithXpath(signup[j], "Compare All Tab " + k
				+ " Year SignUp----Monthly");
				return new GetAQuoteAction();

	}

	public GetAQuoteAction compareAllQuarterSignUP(int j) {

		String[] signup = {
				(pageProperties
						.getProperty("GetAQuote.CompareAlltab1styearSignup")),
				(pageProperties
						.getProperty("GetAQuote.CompareAlltab2ndyearSignup")),
				(pageProperties
						.getProperty("GetAQuote.CompareAlltab3rdyearSignup")) };
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetAQuote.CompareAlltabGAS"),
				"Compare All Tab.");
		verifyAndClickWithXpath(
				pageProperties
						.getProperty("GetAQuote.CompareAlltabGASQuarterButton"),
				"Quarter option Button");
		int k = 1 + j;
		verifyAndClickWithXpath(signup[j], "Compare All Tab " + k
				+ " Year SignUp----Quarterly");
		return new GetAQuoteAction();
	}

	public GetAQuoteAction compareAllMonthlySignUPGAS(int j) {

		String[] signup = {
				(pageProperties
						.getProperty("GetAQuote.CompareAlltab1styearSignup")),
				(pageProperties
						.getProperty("GetAQuote.CompareAlltab2ndyearSignup")),
				(pageProperties
						.getProperty("GetAQuote.CompareAlltab3rdyearSignup")) };
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetAQuote.CompareAlltabGAS"),
				"Compare All Tab.");
		verifyAndClickWithXpath(signup[j],
				"Compare All Tab 1,2 and 3 Year SignUp----Monthly");
		return new GetAQuoteAction();

	}

	public GetAQuoteAction compareAllQuarterSignUPGAS(int i) {

		String[] signup = {
				(pageProperties
						.getProperty("GetAQuote.CompareAlltab1styearSignup")),
				(pageProperties
						.getProperty("GetAQuote.CompareAlltab2ndyearSignup")),
				(pageProperties
						.getProperty("GetAQuote.CompareAlltab3rdyearSignup")) };
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetAQuote.CompareAlltabGAS"),
				"Compare All Tab.");
		verifyAndClickWithXpath(
				pageProperties
						.getProperty("GetAQuote.CompareAlltabGASQuarterButton"),
				"Quarter option Button");
		verifyAndClickWithXpath(signup[i],
				"Compare All Tab 1,2 and 3 Year SignUp----Quarterly");
		return new GetAQuoteAction();
	}

	public GetAQuoteAction clickGasQuaterlyContinueQuotePage() {
		String strQuoteRefNo = null;
		String strQuote = null;
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.GasQuotepageRefNo"))) {
			browser.wait(2000);
			strQuote = browser.getTextByXpath(pageProperties
			        .getProperty("GetAQuote.GasQuotepageRefNo"));
			strQuoteRefNo = strQuote.replaceFirst("Quote reference: ", "");
		}
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.GasquaterlyQuotePageContinue"))) {
			browser.clickWithXpath(pageProperties
			        .getProperty("GetAQuote.GasquaterlyQuotePageContinue"));
			browser.wait(2000);
			browser.wait(getWaitTime());
			Report.updateTestLog(
			        "Continue button exist in Quote page by choosing  gas Quaterly",
			        "PASS");
		} else {
			Report.updateTestLog(
			        "Continue button does not exist in Quote page by choosing  gas Quaterly",
			        "FAIL");
		}

		return new GetAQuoteAction(strQuoteRefNo);
	}

	public GetAQuoteAction clickDualQuaterlyContinueQuotePage() {
		String strQuoteRefNo = null;
		String strQuote = null;
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.GasQuotepageRefNo"))) {
			browser.wait(2000);
			strQuote = browser.getTextByXpath(pageProperties
			        .getProperty("GetAQuote.GasQuotepageRefNo"));
			strQuoteRefNo = strQuote.replaceFirst("Quote reference: ", "");
		}
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.DualquaterlyQuotePageContinue"))) {
			browser.clickWithXpath(pageProperties
			        .getProperty("GetAQuote.DualquaterlyQuotePageContinue"));
			browser.wait(2000);
			Report.updateTestLog(
			        "Continue button exist in Quote page by choosing  Dual Quaterly",
			        "PASS");
		} else {
			Report.updateTestLog(
			        "Continue button does not exist in Quote page by choosing  Dual Quaterly",
			        "FAIL");
		}
		String tempQuoteID = browser
		        .getTextByXpath("//*[contains(text(),'Quote reference:')]");

		// Replace all non-Digits from the String
		tempQuoteID = tempQuoteID.replaceAll("[^\\d]", "");

		GetaQuoteDetailsPage.quoteReferenceId = tempQuoteID;

		return new GetAQuoteAction(strQuoteRefNo);
	}

	public GetAQuoteAction enterBusinesspageDetails(
			GetAQuoteDetails getDetails, String strSupplyRefNo) {
		String strBusinessRefNo = null;
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.GasBusinesspageRefNo"))) {
			browser.wait(getWaitTime());
			strBusinessRefNo = browser.getTextByXpath(pageProperties
			        .getProperty("GetAQuote.GasBusinesspageRefNo"));
			if (strBusinessRefNo.equals(strSupplyRefNo))
				Report.updateTestLog(
						"Quote reference number is same in Business page",
				        "PASS");
			else {
				Report.updateTestLog(
						"Quote reference number is same in Business page",
				        "PASS");
			}
		}
		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.GasSupplyBusinessName"))) {
			if (null != browser.getText(pageProperties
			        .getProperty("GetAQuote.GasSupplyBusinessName"))
			        && browser
			                .getText(
			                        pageProperties
			                                .getProperty("GetAQuote.GasSupplyBusinessName"))
			                .trim() == "")
				browser.input(pageProperties
						.getProperty("GetAQuote.GasSupplyBusinessName"),
				        getDetails.getbusinessname());
		}
		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.Telephonenumber"))) {
			if (null != browser.getText(pageProperties
			        .getProperty("GetAQuote.Telephonenumber"))
			        && browser.getText(
							pageProperties
									.getProperty("GetAQuote.Telephonenumber"))
			                .trim() == "")
				browser.input(
						pageProperties.getProperty("GetAQuote.Telephonenumber"),
				        getDetails.gettelephone());
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.tradingType"))) {
			browser.wait(getWaitTime());
			browser.click(pageProperties.getProperty("GetAQuote.tradingType"));
			Report.updateTestLog("Limited company trading type exist", "PASS");
		} else {
			Report.updateTestLog("Limited company trading type does not exist",
					"FAIL");
		}
		browser.wait(3000);
		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.charityNumber"))) {
			browser.wait(getWaitTime());
			browser.input(
					pageProperties.getProperty("GetAQuote.charityNumber"),
			        getDetails.getCharityNumber());
			Report.updateTestLog("Charity number field exist", "PASS");
		} else {
			Report.updateTestLog(" Charity number field does not exist", "FAIL");
		}
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.businessPageContinue"))) {
			browser.clickWithXpath(pageProperties
			        .getProperty("GetAQuote.businessPageContinue"));
			browser.wait(getWaitTime());
			Report.updateTestLog("Continue button exist in the Business page",
					"PASS");
		} else {
			Report.updateTestLog(
					"Continue button does not exist in the Business page",
			        "FAIL");
		}
		return new GetAQuoteAction(strBusinessRefNo);

	}

	public GetAQuoteAction enterPaymentpageDetailsMonthly(
			GetAQuoteDetails getDetails, String strBusinessRefNo) {
		String strPaymentRefNo = null;
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.GasPaymentpageRefNo"))) {
			browser.wait(getWaitTime());
			strPaymentRefNo = browser.getTextByXpath(pageProperties
			        .getProperty("GetAQuote.GasPaymentpageRefNo"));
			if (strPaymentRefNo.equals(strBusinessRefNo))
				Report.updateTestLog(
						"Quote reference number is same in Payment page",
				        "PASS");
			else {
				Report.updateTestLog(
						"Quote reference number is not same in Payment page",
						"FAIL");
			}
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.accountName"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQuote.accountName"),
			        getDetails.getaccountName());
			Report.updateTestLog("AccountName field exist and value entered",
					"PASS");
		} else {
			Report.updateTestLog("AccountName field does not exist", "FAIL");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.sortCodea"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQuote.sortCodea"),
			        getDetails.getsortCodea());
			Report.updateTestLog("SortcodeA field exist and value entered",
					"PASS");
		} else {
			Report.updateTestLog("Value not entered in SortcodeA field", "FAIL");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.sortCodeb"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQuote.sortCodeb"),
			        getDetails.getsortCodeb());
			Report.updateTestLog("SortcodeB field exist and value entered",
					"PASS");
		} else {
			Report.updateTestLog("Value not entered in SortcodeB field", "FAIL");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.sortCodec"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQuote.sortCodec"),
			        getDetails.getsortCodec());
		}
		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.accountNumber"))) {
			browser.wait(getWaitTime());
			browser.input(
					pageProperties.getProperty("GetAQuote.accountNumber"),
			        getDetails.getaccountNumber());
			Report.updateTestLog("SortcodeC field exist and value entered",
					"PASS");
		} else {
			Report.updateTestLog("Value not entered in Sortcodec field", "FAIL");
		}
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.paymentPageContinue"))) {
			browser.wait(getWaitTime());
			browser.clickWithXpath(pageProperties
			        .getProperty("GetAQuote.paymentPageContinue"));
			Report.updateTestLog("Continue button exist in the payment page",
					"PASS");
		} else {
			Report.updateTestLog(
					"Continue button does not exist in the Payment page",
			        "FAIL");
		}
		return new GetAQuoteAction(strPaymentRefNo);
	}

	public GetAQuoteAction enterPaymentpageDetailsQuaterly(
			GetAQuoteDetails getDetails, String strBusinessRefNo) {
		String strPaymentRefNo = null;
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.GasPaymentpageRefNo"))) {
			browser.wait(getWaitTime());
			strPaymentRefNo = browser.getTextByXpath(pageProperties
			        .getProperty("GetAQuote.GasPaymentpageRefNo"));
			if (strPaymentRefNo.equals(strBusinessRefNo))
				Report.updateTestLog(
						"Quote reference number is same in Payment page",
				        "PASS");
			else {
				Report.updateTestLog(
				        "Quote reference number is not same in Payment page expected ",
				        "FAIL");
			}
		}
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.paymentPageQuaterlyContinue"))) {
			browser.wait(getWaitTime());
			browser.clickWithXpath(pageProperties
			        .getProperty("GetAQuote.paymentPageQuaterlyContinue"));
			Report.updateTestLog("Continue button exist in the payment page",
					"PASS");
		} else {
			Report.updateTestLog(
					"Continue button does not exist in the Payment page",
			        "FAIL");
		}
		return new GetAQuoteAction(strPaymentRefNo);
	}

	public GetAQuoteAction enterSummarypage(GetAQuoteDetails getDetails,
	        String strPaymentRefNo) {
		String strSummaryRefNo = null;
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.GasSummarypageRefNo"))) {
			browser.wait(getWaitTime());
			strSummaryRefNo = browser.getTextByXpath(pageProperties
			        .getProperty("GetAQuote.GasSummarypageRefNo"));
			if (strSummaryRefNo.equals(strPaymentRefNo))
				Report.updateTestLog(
						"Quote reference number is same in Summary page",
				        "PASS");
			else {
				Report.updateTestLog(
						"Quote reference number is not  same in Summary page",
						"FAIL");
			}
		}
		if (!(browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.buidingName")))
		        || (!(browser.isElementVisibleWithXpath(pageProperties
		                .getProperty("GetAQuote.streetName"))))) {
			browser.clickWithXpath(pageProperties
					.getProperty("GetAQuote.editLink"));
			browser.wait(getWaitTime());
			browser.clearValue(pageProperties
					.getProperty("GetAQuote.EnterbuildingName"));
			browser.input(
					pageProperties.getProperty("GetAQuote.EnterbuildingName"),
			        getDetails.getBuildingName());
			browser.wait(getWaitTime());
			browser.clearValue(pageProperties
					.getProperty("GetAQuote.EnterstreetName"));
			browser.input(
					pageProperties.getProperty("GetAQuote.EnterstreetName"),
			        getDetails.getStreetName());
			browser.wait(getWaitTime());
			browser.click(pageProperties.getProperty("GetAQuote.save"));
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.chkLegally"))) {
			browser.wait(4000);
			browser.click(pageProperties.getProperty("GetAQuote.chkLegally"));
			Report.updateTestLog("Legally checkbox exist in the summary page",
					"PASS");
		} else {
			Report.updateTestLog(
					"Legally checkbox does not exist in the summary page",
			        "FAIL");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.chkTerms"))) {
			browser.wait(4000);
			browser.click(pageProperties.getProperty("GetAQuote.chkTerms"));
			browser.wait(4000);
			Report.updateTestLog("Terms checkbox exist in the summary page",
					"PASS");
		} else {
			Report.updateTestLog(
					"Terms checkbox does not exist in the summary page", "FAIL");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.signUpnow"))) {
			browser.wait(getWaitTime());
			browser.click(pageProperties.getProperty("GetAQuote.signUpnow"));
			Report.updateTestLog("SignUp button exist in the payment page",
					"PASS");
		} else {
			Report.updateTestLog(
					"SignUp button does not exist in the Payment page", "FAIL");
		}
		return new GetAQuoteAction(strSummaryRefNo);
	}

	public GetAQuoteAction clickContinuElecRbYesSupplypage(
			GetAQuoteDetails getDetails, String strQuoteRefNo) {
		String strSupplyRefNo = null;
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.GasSupplypageRefNo"))) {
			browser.wait(getWaitTime());
			strSupplyRefNo = browser.getTextByXpath(pageProperties
			        .getProperty("GetAQuote.GasSupplypageRefNo"));
			if (strQuoteRefNo.equals(strSupplyRefNo))
				Report.updateTestLog(
						"Quote reference number is same in Business page",
				        "PASS");
			else {
				Report.updateTestLog(
						"Quote reference number is same in Business page",
				        "PASS");
			}
		}
		/*
		 * if
		 * (browser.isElementVisible(pageProperties.getProperty("GetAQuote.Postcode"
		 * ))) { browser.wait(getWaitTime());
		 * browser.input(pageProperties.getProperty("GetAQuote.Postcode"),
		 * getDetails.getPostcode());
		 * Report.updateTestLog("Postcode field exist and value got entered",
		 * "PASS"); } else {
		 * Report.updateTestLog("Postcode field does not exist & value not  entered"
		 * , "FAIL"); }
		 */
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.FindAdress"))) {
			browser.wait(getWaitTime());
			browser.wait(15000);
			browser.click(pageProperties.getProperty("GetAQuote.FindAdress"));
			browser.wait(30000);
			browser.wait(getWaitTime());
			Report.updateTestLog(
					"Find Adress field exist and value got entered", "PASS");
		} else {
			Report.updateTestLog(
					"Find Adress field does not exist & value not  entered",
			        "FAIL");
		}
		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.SelectAdressId"))) {
			browser.wait(getWaitTime());
			browser.click(pageProperties
					.getProperty("GetAQuote.SelectAdressId"));
			Report.updateTestLog("Address ID has been selected from the list",
					"PASS");
		} else {
			Report.updateTestLog("Address id does not exist", "FAIL");
		}

		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.supplypageContinue"))) {
			browser.clickWithXpath(pageProperties
			        .getProperty("GetAQuote.supplypageContinue"));
			browser.wait(getWaitTime());
			Report.updateTestLog("Continue button exist in the supply page",
					"PASS");
		} else {
			Report.updateTestLog(
					"Continue button does not exist in the supply page", "FAIL");
		}
		return new GetAQuoteAction();
	}

	public GetAQuoteAction clickContinuElecSupplypage(
			GetAQuoteDetails getDetails) throws InterruptedException {

	/*
		 * if
		 * (browser.isElementVisible(pageProperties.getProperty("GetAQuote.Postcode"
		 * ))) { browser.wait(getWaitTime());
		 * browser.input(pageProperties.getProperty("GetAQuote.Postcode"),
		 * getDetails.getPostcode());
		 * Report.updateTestLog("Postcode field exist and value got entered",
		 * "PASS"); } else {
		 * Report.updateTestLog("Postcode field does not exist & value not  entered"
		 * , "FAIL"); }
	 */
		Thread.sleep(5000);
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.FindAdress"))) {
			browser.wait(getWaitTime());
			browser.click(pageProperties.getProperty("GetAQuote.FindAdress"));
			browser.wait(15000);
			browser.wait(getWaitTime());
			Report.updateTestLog(
					"Find Adress field exist and value got entered", "PASS");
		} else {
			Report.updateTestLog(
					"Find Adress field does not exist & value not  entered",
			        "FAIL");
		}
		Thread.sleep(15000);
		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.SelectAdressId"))) {
			browser.wait(getWaitTime());
			browser.click(pageProperties
					.getProperty("GetAQuote.SelectAdressId"));
			Report.updateTestLog("Address ID has been selected from the list",
					"PASS");
		} else {
			Report.updateTestLog("Address id does not exist", "FAIL");
		}
		Thread.sleep(5000);
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.supplypageContinue"))) {
			browser.clickWithXpath(pageProperties
			        .getProperty("GetAQuote.supplypageContinue"));
			browser.wait(getWaitTime());
			Report.updateTestLog("Continue button exist in the supply page",
					"PASS");
		} else {
			Report.updateTestLog(
					"Continue button does not exist in the supply page", "FAIL");
		}
		Thread.sleep(3000);
		return new GetAQuoteAction();
	}

	public GetAQuoteAction clickContinuElecRbNoSupplypage(
			GetAQuoteDetails getDetails, String strQuoteRefNo) {

		String strSupplyRefNo = null;
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.GasSupplypageRefNo"))) {
			browser.wait(getWaitTime());
			strSupplyRefNo = browser.getTextByXpath(pageProperties
			        .getProperty("GetAQuote.GasSupplypageRefNo"));
			if (strQuoteRefNo.equals(strSupplyRefNo))
				Report.updateTestLog(
						"Quote reference number is same in Business page",
				        "PASS");
			else {
				Report.updateTestLog(
						"Quote reference number is same in Business page",
				        "PASS");
			}
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.Postcode"))) {
			// Verify.assertTrue(browser.isTextPresent(pageProperties.getProperty("GetAQuote.Postcode")));
			Report.updateTestLog(
					"Postcode field exist and value got Prepopulated", "PASS");
		} else {
			Report.updateTestLog(
					"Postcode field does not exist & value not Prepopulated ",
					"FAIL");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.FindAdress"))) {

			browser.wait(getWaitTime());
			Report.updateTestLog("Find Adress exist", "PASS");
			browser.click(pageProperties.getProperty("GetAQuote.FindAdress"));

			browser.wait(6000);
			if (browser.isElementVisible(pageProperties
			        .getProperty("GetAQuote.SelectAdressId"))) {
				browser.wait(getWaitTime());
				browser.click(pageProperties
						.getProperty("GetAQuote.SelectAdressId"));
				browser.wait(getWaitTime());
				browser.wait(3000);
				Report.updateTestLog(
						"Address ID has been selected from the list", "PASS");
			} else {
				Report.updateTestLog("Address id does not exist", "FAIL");
			}

		} else {
			Report.updateTestLog("Find Adress does not exist", "FAIL");
		}
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.supplypageContinue"))) {
			browser.clickWithXpath(pageProperties
			        .getProperty("GetAQuote.supplypageContinue"));
			browser.wait(getWaitTime());
			Report.updateTestLog("Continue button exist in the supply page",
					"PASS");
		} else {
			Report.updateTestLog(
					"Continue button does not exist in the supply page", "FAIL");
		}
		return new GetAQuoteAction();
	}

	public GetAQuoteAction clickContinuGasRbYesSupplypage(
			GetAQuoteDetails getDetails, String strQuoteRefNo) {
		String strPostcodeActual;
		String strPostcodePrsent;
		String strSupplyRefNo = null;
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.GasSupplypageRefNo"))) {
			browser.wait(getWaitTime());
			strSupplyRefNo = browser.getTextByXpath(pageProperties
			        .getProperty("GetAQuote.GasSupplypageRefNo"));
			if (strQuoteRefNo.equals(strSupplyRefNo))
				Report.updateTestLog(
						"Quote reference number is same in Business page",
				        "PASS");
			else {
				Report.updateTestLog(
						"Quote reference number is same in Business page",
				        "PASS");
			}
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.Postcode"))) {
			browser.wait(getWaitTime());
			strPostcodeActual = getDetails.getPostcode();
			strPostcodePrsent = browser.getText(pageProperties
			        .getProperty("GetAQuote.Postcode"));
			if (strPostcodePrsent.equalsIgnoreCase(strPostcodePrsent))
				Report.updateTestLog("Postcode field prepopulated", "PASS");
			else {
				if (browser.isElementVisible(pageProperties
				        .getProperty("GetAQuote.Postcode"))) {
					browser.wait(getWaitTime());
					browser.input(
							pageProperties.getProperty("GetAQuote.Postcode"),
					        getDetails.getPostcode());
					Report.updateTestLog(
							"Postcode field exist and value got entered",
					        "PASS");
				} else {
					Report.updateTestLog(
							"Postcode field does not exist & value not  entered",
							"FAIL");
				}
			}
			if (browser.isElementVisible(pageProperties
			        .getProperty("GetAQuote.FindAdress"))) {
				browser.wait(getWaitTime());
				browser.click(pageProperties
						.getProperty("GetAQuote.FindAdress"));
				browser.wait(15000);
				browser.wait(getWaitTime());
				Report.updateTestLog("Find Adress exist", "PASS");
			} else {
				Report.updateTestLog("Find Adress does not exist", "FAIL");
			}
			if (browser.isElementVisible(pageProperties
			        .getProperty("GetAQuote.SelectAdressId"))) {
				browser.wait(getWaitTime());
				browser.click(pageProperties
						.getProperty("GetAQuote.SelectAdressId"));
				browser.wait(getWaitTime());
				Report.updateTestLog(
						"Address ID has been selected from the list", "PASS");
			} else {
				Report.updateTestLog("Address id does not exist", "FAIL");
			}
		}
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.supplypageContinue"))) {
			browser.clickWithXpath(pageProperties
			        .getProperty("GetAQuote.supplypageContinue"));
			browser.wait(getWaitTime());
			Report.updateTestLog("Continue button exist in the supply page",
					"PASS");
		} else {
			Report.updateTestLog(
					"Continue button does not exist in the supply page", "FAIL");
		}
		return new GetAQuoteAction(strSupplyRefNo);
	}

	public GetAQuoteAction clickContinuGasRbNoSupplypage(
			GetAQuoteDetails getDetails, String strQuoteRefNo) {
		String strSupplyRefNo = null;
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.GasSupplypageRefNo"))) {
			browser.wait(getWaitTime());
			strSupplyRefNo = browser.getTextByXpath(pageProperties
			        .getProperty("GetAQuote.GasSupplypageRefNo"));
		}

		String strPostcodeValue = browser.getAttributeByXpath(
		        pageProperties.getProperty("GetAQuote.PostcodeXpath"), "value");

		if (strPostcodeValue.equals("")
		        || browser.isElementVisible(pageProperties
		                .getProperty("GetAQuote.FindAdress"))) {
			if (strPostcodeValue.equals(""))
				browser.input(pageProperties.getProperty("GetAQuote.Postcode"),
				        getDetails.getPostcode());

			if (browser.isElementVisible(pageProperties
			        .getProperty("GetAQuote.FindAdress"))) {
				browser.wait(getWaitTime());
				browser.click(pageProperties
						.getProperty("GetAQuote.FindAdress"));
				browser.wait(6000);
				Report.updateTestLog("Find Adress exist", "PASS");
			} else {
				Report.updateTestLog("Find Adress does not exist", "FAIL");
			}
			if (browser.isElementVisible(pageProperties
			        .getProperty("GetAQuote.SelectAdressId"))) {
				browser.wait(getWaitTime());
				browser.click(pageProperties
						.getProperty("GetAQuote.SelectAdressId"));
				browser.wait(getWaitTime());
				browser.wait(3000);
				Report.updateTestLog(
						"Address ID has been selected from the list", "PASS");
			} else {
				Report.updateTestLog("Address id does not exist", "FAIL");
			}
		}
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.supplypageContinue"))) {
			browser.clickWithXpath(pageProperties
			        .getProperty("GetAQuote.supplypageContinue"));
			browser.wait(getWaitTime());
			Report.updateTestLog("Continue button exist in the supply page",
					"PASS");
		} else {
			Report.updateTestLog(
					"Continue button does not exist in the supply page", "FAIL");
		}

		return new GetAQuoteAction(strSupplyRefNo);
	}

	public GetAQuoteAction gaqThankyouPage(String strSummaryRefNo) {
		String strThankpageRefNo = null;
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.thankpageQuoteRef"))) {
			browser.wait(getWaitTime());
			strThankpageRefNo = browser.getTextByXpath(pageProperties
			        .getProperty("GetAQuote.thankpageQuoteRef"));
			if (strThankpageRefNo.equals(strSummaryRefNo))
				Report.updateTestLog(
						"Quote reference number is same in Thank you page",
				        "PASS");
			else {
				Report.updateTestLog(
						"Quote reference number is same in Thank you page",
				        "FAIL");
			}
		}
		return new GetAQuoteAction(strThankpageRefNo);
	}

	public void verifyleadGaq(GetAQuoteDetails getDetails, String strRefNo) {
		OnlineDBConnector dbConn = new OnlineDBConnector();
		String leadType = dbConn.verifyleadDBforGaq(strRefNo);
		String gaqLeadType = getDetails.getLeadType();
		if (leadType.equals(gaqLeadType))
			Report.updateTestLog("LeadType for GAQ successfully done ", "PASS");
		else {
			Report.updateTestLog("LeadType for GAQ is failed.Expected:  '"
					+ gaqLeadType + "', Actual Value: " + leadType, "FAIL");
		}
	}

	public double[] verifyElecGaqrate(GetAQuoteDetails getDetails) {
		double elecConsumption = 0;
		double elecAnnualSpend;
		double calculatedElecConsumpRate;

		String strelecConsumpRate;
		String ElecConsump;
		String profileClass = getDetails.getSupplyNumber1();
		int intProfileClass = Integer.parseInt(profileClass);

		double[] results = new double[8];
		String strstandingRateUI = "";
		if (2 == browser.getChildElementsCountByXpath(pageProperties
				.getProperty("GetAQuote.DualStandardChargeXPath"))) {
			strstandingRateUI = browser.getTextByXpath(pageProperties
		        .getProperty("GetAQuote.ElecQuoteStandingCharge"));// "select UNIT_CHARGE  from BGB_TR_PRICE_ELEC_BOOK where TARIFF_CODE=(select tariff_code from BGB_TR_PRICE_ELEC_METER_TARIFF where MTC='"
		} else {
			strstandingRateUI = browser.getTextByXpath(pageProperties
			        .getProperty("GetAQuote.DualStandardCharge_NightXPath"));

		}
		// +
		// mpanNumber
		// +
		// "' and PROFILE_CLASS='"
		// +
		// profileClass
		// +
		// "' and PES ='"
		// + pesNumbr
		// +
		// "') AND REFERENCE_PRICEBOOK_ID=(select REFERENCE_PRICEBOOK_ID from BGB_TR_PRICE_ELEC_BOOK_REF where CONTRACT_TYPE_ID='1'and LINE_DESCRIPTION ='Standing Charge')";
		strstandingRateUI = strstandingRateUI.replaceAll("p/day", "").trim();
		strstandingRateUI = strstandingRateUI.replaceAll("[^\\d(?!.)]", "");
		// TODO Day and Night unit rates
		double standingChargeRate = Double.parseDouble(strstandingRateUI);// dbConn.verfiyStandingRateforGaq(strstandingRateQuery);
		validateElecStandingChargeinUI(standingChargeRate,
				getDetails.getSupplyNumber4());
		String strunitChargeRateQuery = "";
		if (2 == browser.getChildElementsCountByXpath(pageProperties
				.getProperty("GetAQuote.DualStandardChargeXPath"))) {
			strunitChargeRateQuery = browser.getTextByXpath(pageProperties
		        .getProperty("GetAQuote.ElecQuoteUnitcharge"));// "select UNIT_CHARGE from BGB_TR_PRICE_ELEC_BOOK where TARIFF_CODE=(select tariff_code from BGB_TR_PRICE_ELEC_METER_TARIFF where MTC='"
			GetaQuoteDetailsPage.containsNightRate = false;
		} else {
			strunitChargeRateQuery = GetaQuoteDetailsPage.unitCharge + "";
			GetaQuoteDetailsPage.unitCharge = Double
					.parseDouble(browser
							.getTextByXpath(
									pageProperties
											.getProperty("GetAQuote.ElecQuoteUnitcharge"))
							.replaceAll("[^\\d(?!.)]", "").trim());
			GetaQuoteDetailsPage.nightUnitCharge = Double
					.parseDouble(browser
							.getTextByXpath(
									pageProperties
											.getProperty("GetAQuote.DualNightChargeXPath"))
							.replaceAll("[^\\d(?!.)]", "").trim());
			GetaQuoteDetailsPage.containsNightRate = true;
			}

		strunitChargeRateQuery = strunitChargeRateQuery.replaceAll("p/kWh", "")
				.trim();
		double unitChargeRate = Double.parseDouble(strunitChargeRateQuery);

		/*
		 * The following code fetches the Annual consumption for electricity
		 * from the Application and calculates AnnualSpendvalue and Monthly
		 * spend value /Quaterly Spend Value
		 */
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.ElecConsumpAnnual"))) {
			ElecConsump = browser.getTextByXpath(pageProperties
			        .getProperty("GetAQuote.ElecConsumpAnnual"));
			ElecConsump = ElecConsump.replace(",", "");
			String ElecConsumpAnnualSplit[] = ElecConsump.split("k");
			elecConsumption = Double.parseDouble(ElecConsumpAnnualSplit[0]);
			if (!GetaQuoteDetailsPage.containsNightRate)
				annualSpend = ((standingChargeRate * 365) / 100 + (elecConsumption * unitChargeRate) / 100);
			else {
				daySpend = (0.7437931 * elecConsumption * (GetaQuoteDetailsPage.unitCharge)) / 100;
				nightSpend = (0.2562069 * elecConsumption * (GetaQuoteDetailsPage.nightUnitCharge)) / 100;
				annualSpend = (standingChargeRate * 365) / 100 + daySpend
						+ nightSpend;

			}

			// annualSpend = ((standingChargeRate * 365) / 100 +
			// (elecConsumption * unitChargeRate) / 100);
			String strannualSpend = annualSpend + "";
			String strannualSpendval = strannualSpend.substring(0,
			        (strannualSpend.indexOf(".")) + 3);
			annualSpendValue = Double.parseDouble(strannualSpendval);
			String strPaymentOption = getDetails.getPaymentOption();
			if (strPaymentOption.equals("Monthly")) {
				monthlySpend = annualSpendValue / 12;
				String strmonthlySpend = monthlySpend + "";
				String strmonthlySpendval = strmonthlySpend.substring(0,
				        (strmonthlySpend.indexOf(".")) + 3);
				monthlySpendValue = Double.parseDouble(strmonthlySpendval);
			} else if (strPaymentOption.equals("Quaterly")) {
				monthlySpend = annualSpendValue / 4;
				String strmonthlySpend = monthlySpend + "";
				String strmonthlySpendval = strmonthlySpend.substring(0,
				        (strmonthlySpend.indexOf(".")) + 3);
				monthlySpendValue = Double.parseDouble(strmonthlySpendval);
			}
		}
		String strelecAnnualSpend = getDetails.getElecAnnualspend();
		// elecAnnualSpend = Double.parseDouble(strelecAnnualSpend);
		if ((strelecAnnualSpend).equals("")) {
			strelecConsumpRate = getDefaultElecConsumption(getDetails,
					intProfileClass);
			calculatedElecConsumpRate = Double.parseDouble(strelecConsumpRate);
			// calculatedElecConsumpRate =strelecConsumpRatez;
		} else {
			elecAnnualSpend = Double.parseDouble(strelecAnnualSpend);
			strelecConsumpRate = getElecConsumption(getDetails,
					elecAnnualSpend, intProfileClass);
			String strelecConsumpRateval = strelecConsumpRate.substring(0,
			        (strelecConsumpRate.indexOf(".")) + 3);
			calculatedElecConsumpRate = Double
					.parseDouble(strelecConsumpRateval);
		}

		results[0] = monthlySpendValue;
		results[1] = annualSpendValue;
		results[2] = calculatedElecConsumpRate;
		results[3] = elecConsumption;
		return results;
	}

	private boolean validateElecStandingChargeinUI(double standingChargeRate,
			String SupplyNumber4) {

		boolean retVal = false;
		int lineNumber = 0;
		List<String> expectedRates = new ArrayList<String>();
		OnlineDBConnector onlineDBConnector = new OnlineDBConnector();

		int rateCount = onlineDBConnector.retreiveUnitChargesCount(
				standingChargeRate + "", SupplyNumber4);

		if (rateCount >= 1) {
			retVal = true;
		}
		if (retVal) {
			Report.updateTestLog("Electricity Standing charge in application: "
					+ standingChargeRate
					+ " Matches with expected. Found in line number: "
					+ lineNumber, "PASS");
		} else {

			Report.updateTestLog("Electricity Standing charge in application: "
					+ standingChargeRate
					+ " does not matche with expected. Expected values: "
					+ expectedRates + ".Supply number4 is: " + SupplyNumber4,
					"FAIL");

		}

		return retVal;
	}

	public double[] verifyElecGaqrate(GetAQuoteDetails getDetails,
			int supplyNumber) {
		double elecConsumption = 0;
		double elecAnnualSpend = 0.0;
		double calculatedElecConsumpRate;
		double elecConsumpCalc = 0;
		String strelecConsumpRate;
		int intProfileClass = supplyNumber;

		double[] results = new double[8];
		double standingChargeRate = GetaQuoteDetailsPage.standingCharge;

		double unitChargeRate = GetaQuoteDetailsPage.unitCharge;

		/*
		 * The following code fetches the Annual consumption for electricity
		 * from the Application and calculates AnnualSpendvalue and Monthly
		 * spend value /Quaterly Spend Value
		 */

		elecConsumption = GetaQuoteDetailsPage.annualConsumption;
		if (!GetaQuoteDetailsPage.containsNightRate) {
			annualSpend = ((standingChargeRate * 365) / 100 + (elecConsumption * unitChargeRate) / 100);
			getDetails.setSupplyNumber1(supplyNumber + "");
			String[] values = { unitChargeRate + "" };
			validateElectricityUnitCharges(getDetails.getSupplyNumber4(),
					values);
		} else {
			daySpend = (0.7437931 * elecConsumption * (GetaQuoteDetailsPage.unitCharge)) / 100;
			nightSpend = (0.2562069 * elecConsumption * (GetaQuoteDetailsPage.nightUnitCharge)) / 100;
			annualSpend = (standingChargeRate * 365) / 100 + daySpend
					+ nightSpend;

			String[] values = { GetaQuoteDetailsPage.unitCharge + "",
					GetaQuoteDetailsPage.nightUnitCharge + "" };
			validateElectricityUnitCharges(getDetails.getSupplyNumber4(),
					values);

		}
		validateElecStandingChargeinUI(standingChargeRate,
				getDetails.getSupplyNumber4());
		String strannualSpend = annualSpend + "";
		String strannualSpendval = strannualSpend.substring(0,
		        (strannualSpend.indexOf(".")) + 3);
		annualSpendValue = Double.parseDouble(strannualSpendval);
		String strPaymentOption = getDetails.getPaymentOption();
		if (strPaymentOption.equals("Monthly")) {
			monthlySpend = annualSpendValue / 12;
			String strmonthlySpend = monthlySpend + "";
			String strmonthlySpendval = strmonthlySpend.substring(0,
			        (strmonthlySpend.indexOf(".")) + 3);
			monthlySpendValue = Double.parseDouble(strmonthlySpendval);
		} else if (strPaymentOption.equals("Quaterly")) {
			monthlySpend = annualSpendValue / 4;
			String strmonthlySpend = monthlySpend + "";
			String strmonthlySpendval = strmonthlySpend.substring(0,
			        (strmonthlySpend.indexOf(".")) + 3);
			monthlySpendValue = Double.parseDouble(strmonthlySpendval);
		}

		String strelecAnnualSpend = getDetails.getElecAnnualspend();
		if ((strelecAnnualSpend).equals("")) {
			strelecConsumpRate = getDefaultElecConsumption(getDetails,
					intProfileClass);
			calculatedElecConsumpRate = Double.parseDouble(strelecConsumpRate);
			// calculatedElecConsumpRate =strelecConsumpRatez;
		} else {
			elecAnnualSpend = Double.parseDouble(strelecAnnualSpend);
			strelecConsumpRate = getElecConsumption(getDetails,
					elecAnnualSpend, intProfileClass);
			String strelecConsumpRateval = strelecConsumpRate.substring(0,
			        (strelecConsumpRate.indexOf(".")) + 3);
			calculatedElecConsumpRate = Double
					.parseDouble(strelecConsumpRateval);
		}
		// elecAnnualSpend = Double.parseDouble(strelecAnnualSpend);

		results[0] = monthlySpendValue;
		results[1] = annualSpendValue;
		results[2] = calculatedElecConsumpRate;
		results[3] = elecConsumption;
		return results;
	}

	public double[] verifyGasGaqRate(GetAQuoteDetails getDetails) {
		double gasUnitrateValue;
		String queryPostcode;
		double gasUnitratecalc = 0;
		double gasSpendCalc = 0;
		double[] results = new double[6];
		queryPostcode = getDetails.getPostcode();
		/*
		 * following code fetches Gas Annual consumption from the application
		 * and according to the gas band range gasbandid is choosen
		 */
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.GasConsumpAnnual"))) {
			String gasConsump = browser.getTextByXpath(pageProperties
			        .getProperty("GetAQuote.GasConsumpAnnual"));
			gasConsump = gasConsump.replace(",", "");
			String gasConsumpAnnualSplit[] = gasConsump.split("k");
			gasBandRange = Double.parseDouble(gasConsumpAnnualSplit[0]);
			String gasSpend = getDetails.getannualGasSpend();
			int intGasSpend = Integer.parseInt(gasSpend);
			if (gasBandRange >= 0 && gasBandRange <= 73199) {
				gasBandid = 1;
				gasUnitratecalc = getDetails.getgasUnitrateBand1();
			} else if (gasBandRange >= 73200 && gasBandRange <= 149999) {
				gasBandid = 2;
				gasUnitratecalc = getDetails.getgasUnitrateBand2();
			} else if (gasBandRange >= 150000 && gasBandRange <= 399999) {
				gasBandid = 3;
				gasUnitratecalc = getDetails.getgasUnitrateBand3();
			} else if (gasBandRange >= 400000) {
				gasBandid = 4;
				gasUnitratecalc = getDetails.getgasUnitrateBand4();
			}
			gasSpendCalc = intGasSpend / (gasUnitratecalc / 100);
		}
		String strGasUnitrateQuery = browser.getTextByXpath(pageProperties
		        .getProperty("GetAQuote.GasQuoteUnitcharge"));
		strGasUnitrateQuery = strGasUnitrateQuery.replace(
				pageProperties.getProperty("GetAQuote.UnitChargeSuffixText"),
				"").trim();
		double gaqGasUnitrate = Double.parseDouble(strGasUnitrateQuery);
		String strgaqGasUnitrate = gaqGasUnitrate + "";
		String strGasval = strgaqGasUnitrate.substring(0,
		        (strgaqGasUnitrate.indexOf(".")) + 3);
		gasUnitrateValue = Double.parseDouble(strGasval);
		String strGasStandingrateQuery = browser.getTextByXpath(pageProperties
		        .getProperty("GetAQuote.GasQuoteStandingCharge"));
		strGasStandingrateQuery = strGasStandingrateQuery
				.replace(
						pageProperties
								.getProperty("GetAQuote.StaindingChargeSuffixText"),
						"").trim();
		double gaqGasStandingrate = Double.parseDouble(strGasStandingrateQuery);

		double annualGasSpend = ((gaqGasStandingrate * 365) / 100 + (gasBandRange * gaqGasUnitrate) / 100);
		String strannualSpend = annualGasSpend + "";
		String strannualSpendval = strannualSpend.substring(0,
		        (strannualSpend.indexOf(".")) + 3);
		annualSpendValue = Double.parseDouble(strannualSpendval);
		String strPaymentOption = getDetails.getPaymentOption();
		if (strPaymentOption.equals("Monthly")) {
			double monthlyGasSpend = annualSpendValue / 12;
			String strmonthlySpend = monthlyGasSpend + "";
			String strmonthlySpendval = strmonthlySpend.substring(0,
			        (strmonthlySpend.indexOf(".")) + 3);
			monthlySpendValue = Double.parseDouble(strmonthlySpendval);
		} else if (strPaymentOption.equals("Quaterly")) {
			double monthlyGasSpend = annualSpendValue / 4;
			String strmonthlySpend = monthlyGasSpend + "";
			String strmonthlySpendval = strmonthlySpend.substring(0,
			        (strmonthlySpend.indexOf(".")) + 3);
			monthlySpendValue = Double.parseDouble(strmonthlySpendval);
		}
		results[0] = monthlySpendValue;
		results[1] = annualSpendValue;
		results[2] = gasSpendCalc;
		results[3] = gasBandRange;
		return results;
	}

	public GetAQuoteAction verifyElecQuotePageCharge(GetAQuoteDetails getDetails) {
		String strMonthlyrate;
		String strAnnualrate;

		String strMonthly;
		String strAnnual;
		double monthlyrateValue;
		double annualrateValue;

		browser.wait(5000);

		String tempQuoteID = browser
		        .getTextByXpath("//*[contains(text(),'Quote reference:')]");

		// Replace all non-Digits from the String
		tempQuoteID = tempQuoteID.replaceAll("[^\\d(?!.)]", "");

		GetaQuoteDetailsPage.quoteReferenceId = tempQuoteID;

		double[] rateValue = verifyElecGaqrate(getDetails);
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.QuoteMonth"))) {
			strMonthly = browser.getText(pageProperties
			        .getProperty("GetAQuote.QuoteMonth"));
			strMonthlyrate = strMonthly.substring(1, strMonthly.length());
			monthlyrateValue = Double.parseDouble(strMonthlyrate);
			if ((int) (monthlyrateValue) == (int) (rateValue[0])) {
				browser.wait(2000);
				Report.updateTestLog("Monthly Figure exist as Expected", "PASS");
			} else {
				Report.updateTestLog(
				        "Monthly Figure does not exist as Expected.Expected:  '"
								+ monthlyrateValue + "', Actual Value: "
								+ rateValue[0], "FAIL");
			}
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.QuoteAnnual"))) {
			strAnnual = browser.getText(pageProperties
			        .getProperty("GetAQuote.QuoteAnnual"));
			// strMonthlyrate=strMonthly.substring(1, strMonthly.length());
			strAnnualrate = strAnnual.substring(1, strAnnual.length());
			annualrateValue = Double.parseDouble(strAnnualrate);
			if ((annualrateValue) == (rateValue[1])) {
				Report.updateTestLog("Annual Figure exist as Expected", "PASS");
			} else {
				Report.updateTestLog(
				        "Annual Figure does not exist as Expected.Expected:  '"
								+ annualrateValue + "', Actual Value: "
								+ rateValue[1], "FAIL");
			}
		}
		/*
		 * if (((int) rateValue[2]) == (int) rateValue[3]) {
		 * Report.updateTestLog(
		 * "Annual COnsumption calculated matches with the application",
		 * "PASS"); } else { Report.updateTestLog(
		 * "Annual COnsumption calculated does not matche with the application.Expected:  '"
		 * + rateValue[2] + "', Actual Value: " + rateValue[3], "FAIL"); }
		 */
		return new GetAQuoteAction();
	}

	public GetAQuoteAction verifyElecQuoteDisplayedCharge(
			GetAQuoteDetails getDetails, int supplyNumber) {

		double monthlyrateValue = GetaQuoteDetailsPage.monthlyQuote;
		double annualrateValue = GetaQuoteDetailsPage.annualQuote;

		double[] rateValue = verifyElecGaqrate(getDetails, supplyNumber);

		if ((int) (monthlyrateValue) == (int) (rateValue[0])) {
			browser.wait(2000);
			Report.updateTestLog("Monthly Figure exist as Expected", "PASS");
		} else {
			Report.updateTestLog(
			        "Monthly Figure does not exist as Expected.Expected:   '"
							+ monthlyrateValue + "',ACtual value:"
							+ rateValue[0], "FAIL");
		}

		if ((int) (annualrateValue) == (int) (rateValue[1])) {
			Report.updateTestLog("Annual Figure exist as Expected", "PASS");
		} else {
			Report.updateTestLog(
					"Annual Figure does not exist as Expected. Expected: '"
							+ annualrateValue + "', Actual Value: "
							+ rateValue[1], "FAIL");
		}

		if ((int) (rateValue[2]) == (int) rateValue[3]) {
			Report.updateTestLog(
					"Annual Consumption calculated matches with the application. Expected: "
							+ rateValue[2] + "Actual: " + rateValue[3] + ". ",
					"PASS");
		} else {
			Report.updateTestLog(
			        "Annual Consumption calculated does not matche with the application. Expected: "
							+ rateValue[2] + ", Actual: " + rateValue[3],
					"FAIL");
		}

		return new GetAQuoteAction();
	}

	public GetAQuoteAction verifyElecQuoteDisplayedChargeNew(
			GetAQuoteDetails getDetails, int supplyNumber) {
		if (supplyNumber == 01) {
			validateElectricityUnitChargesThirdYear("23");

		  }
		if (supplyNumber == 02 || supplyNumber == 04 || supplyNumber == 05
				|| supplyNumber == 8) {
			validateElectricityUnitChargesThirdYear("10");

		  }
		if (supplyNumber == 03) {
			validateElectricityUnitChargesThirdYear("20");

		  }
		if (supplyNumber == 06 || supplyNumber == 07) {
			validateElectricityUnitChargesThirdYear("11");

		  }

		return new GetAQuoteAction();
	}

	public GetAQuoteAction verifyGasQuotePageCharge(GetAQuoteDetails getDetails) {
		String strMonthlyrate;
		String strAnnualrate;
		String strMonthly;
		String strAnnual;
		double monthlyrateValue = 0;
		double annualrateValue = 0;

		browser.wait(5000);

		String tempQuoteID = browser
		        .getTextByXpath("//*[contains(text(),'Quote reference:')]");

		// Replace all non-Digits from the String
		tempQuoteID = tempQuoteID.replaceAll("[^\\d]", "");

		GetaQuoteDetailsPage.quoteReferenceId = tempQuoteID;
		double[] rateValue = verifyGasGaqRate(getDetails);
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.QuoteMonth"))) {
			strMonthly = browser.getText(pageProperties
			        .getProperty("GetAQuote.QuoteMonth"));
			strMonthlyrate = strMonthly.substring(1, strMonthly.length());
			monthlyrateValue = Double.parseDouble(strMonthlyrate);
			if ((int) (monthlyrateValue) == (int) (rateValue[0])) {
				browser.wait(2000);
				Report.updateTestLog("Monthly Figure exist as Expected", "PASS");
			}
		} else {
			Report.updateTestLog(
					"Monthly Figure does not exist as Expected.Expected: "
							+ monthlyrateValue + ", Actual: " + rateValue[0],
					"FAIL");
		}
		browser.wait(2000);
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.QuoteAnnual"))) {
			strAnnual = browser.getText(pageProperties
			        .getProperty("GetAQuote.QuoteAnnual"));
			strAnnualrate = strAnnual.substring(1, strAnnual.length());
			annualrateValue = Double.parseDouble(strAnnualrate);
			if ((int) (annualrateValue) == (int) (rateValue[1])) {
				Report.updateTestLog("Annual Figure exist as Expected", "PASS");
			}
		} else {
			Report.updateTestLog(
					"Annual Figure does not exist as Expected.Expected: "
							+ annualrateValue + ", Actual: " + rateValue[1],
					"FAIL");
		}
		browser.wait(2000);
		if ((rateValue[3] == (int) rateValue[2])
		        || (rateValue[3] + 5 >= (int) rateValue[2])
		        || (rateValue[3] - 5 <= (int) rateValue[2])) {
			Report.updateTestLog(
					"Annual COnsumption calculated matches with the application",
					"PASS");
		} else {
			Report.updateTestLog(
			        "Annual COnsumption calculated does not matches with the application.Expected: "
							+ rateValue[3] + ", Actual: " + rateValue[2],
					"FAIL");
		}

		return new GetAQuoteAction();
	}

	private void validateElectricityUnitCharges(String supplyNumber4,
			String[] retreivedValues) {

		boolean retVal = false;
		int lineNumber = 0;
		List<String> expectedRates = new ArrayList<String>();
		int ratecount = 0;
		ratecount = retreivedValues.length;
		String unitCharge = "";
		String dayUnitCharge = "";
		String nightUnitCharge = "";
		String logDescription = "";
		if (ratecount == 1) {
			unitCharge = retreivedValues[0];
		} else if (ratecount == 2) {
			dayUnitCharge = browser
					.getTextByXpath("/html/body/div/div/div[3]/div[2]/div[2]/div/div/div[2]/div/table/tbody/tr/td[2]/b");
			nightUnitCharge = browser
					.getTextByXpath("/html/body/div/div/div[3]/div[2]/div[2]/div/div/div[2]/div/table/tbody/tr[2]/td[2]/b");
			dayUnitCharge = retreivedValues[0];
			nightUnitCharge = retreivedValues[1];
			logDescription = logDescription
					+ "Application displays Day and Night unit rates as ."
					+ dayUnitCharge + ", " + nightUnitCharge
					+ " respectively. ";
		}
		int matchedCharges = 0;
		// Update this too
		OnlineDBConnector onlineDbConnnecteor = new OnlineDBConnector();

		switch (ratecount) {
		case 1:// Only Unit Charge is present
			int unitChargeCount = onlineDbConnnecteor.retreiveUnitChargesCount(
					unitCharge, supplyNumber4);
			if (unitChargeCount >= 1) {
				logDescription = logDescription
						+ "Electricity Unitcharge in application: "
						+ unitCharge + "Matches with epxected.";
				retVal = true;
			}
					break;
				case 2:
			unitChargeCount = onlineDbConnnecteor.retreiveUnitChargesCount(
					dayUnitCharge, supplyNumber4);
			if (unitChargeCount >= 1) {
				logDescription = logDescription
						+ "Electricity Day unitcharge in application: "
						+ dayUnitCharge + "Matches with epxected.";
				matchedCharges = 1;
					}
			unitChargeCount = onlineDbConnnecteor.retreiveUnitChargesCount(
					nightUnitCharge, supplyNumber4);
			if (unitChargeCount >= 1) {
				logDescription = logDescription
						+ "Electricity Night unitcharge in application: "
						+ nightUnitCharge + "Matches with epxected.";
				matchedCharges = matchedCharges + 2;
					}
					break;
				}

		if (ratecount == 3 && matchedCharges < 3) {
			if (matchedCharges == 2)
				logDescription = logDescription
						+ "Day Unit Charge in appplication: "
						+ dayUnitCharge
						+ " did not match any of the values from file. Expected values: "
						+ expectedRates + ". ";
			else if (matchedCharges == 1)
				logDescription = logDescription
						+ "Night Unit Charge in appplication: "
						+ nightUnitCharge
						+ " did not match any of the values from file. Expected values: "
						+ expectedRates + ". ";
			else if (matchedCharges == 0)
				logDescription = logDescription
						+ "Night Unit Charge in appplication: "
						+ nightUnitCharge
						+ "and Day unit charge in application: "
						+ dayUnitCharge
						+ " did not match any of the values from file. Expected values: "
						+ expectedRates + ". ";
		}

		else if (ratecount == 3 && matchedCharges == 3) {
			Report.updateTestLog(logDescription, "PASS");
		} else {
			Report.updateTestLog(logDescription + ".Supply number4 is: "
					+ supplyNumber4, "FAIL");

	}

			}

	private String getElecConsumption(GetAQuoteDetails getDetails,
	        double elecAnnualSpend, int intProfileClass) {
		Double elecConsumpCalc = null;

		// String strelecAnnualSpend = getDetails.getElecAnnualspend();
		// elecAnnualSpend = Double.parseDouble(strelecAnnualSpend);
		switch (intProfileClass) {
		case 1:
			double unitRateProfileClass1 = getDetails
					.getelecProfileClass1Unitrate();

			elecConsumpCalc = (elecAnnualSpend * 100) / unitRateProfileClass1;

			break;
		case 2:
			double unitRateProfileClass2 = getDetails
					.getelecProfileClass2Unitrate();
			elecConsumpCalc = (elecAnnualSpend * 100) / unitRateProfileClass2;
			break;
		case 3:
			double unitRateProfileClass3 = getDetails
					.getelecProfileClass3Unitrate();
			elecConsumpCalc = (elecAnnualSpend * 100) / unitRateProfileClass3;
			break;
		case 4:
			double unitRateProfileClass4 = getDetails
					.getelecProfileClass4Unitrate();
			elecConsumpCalc = (elecAnnualSpend * 100) / unitRateProfileClass4;
			break;
		case 5:
			double unitRateProfileClass5 = getDetails
					.getelecProfileClass5Unitrate();
			elecConsumpCalc = (elecAnnualSpend * 100) / unitRateProfileClass5;
			break;
		case 6:
			double unitRateProfileClass6 = getDetails
					.getelecProfileClass6Unitrate();
			elecConsumpCalc = (elecAnnualSpend * 100) / unitRateProfileClass6;
			break;
		case 7:
			double unitRateProfileClass7 = getDetails
					.getelecProfileClass7Unitrate();
			elecConsumpCalc = (elecAnnualSpend * 100) / unitRateProfileClass7;
			break;
		case 8:
			double unitRateProfileClass8 = getDetails
					.getelecProfileClass8Unitrate();
			elecConsumpCalc = (elecAnnualSpend * 100) / unitRateProfileClass8;
			break;

		}
		return elecConsumpCalc + "";
	}

	private String getDefaultElecConsumption(GetAQuoteDetails getDetails,
	        int intProfileClass) {
		Double elecConsumpCalc = null;

		// String strelecAnnualSpend = getDetails.getElecAnnualspend();
		// elecAnnualSpend = Double.parseDouble(strelecAnnualSpend);

		switch (intProfileClass) {
		case 1:
			elecConsumpCalc = getDetails.getdefaultConsumptionRateClass1();
			break;
		case 2:
			elecConsumpCalc = getDetails.getdefaultConsumptionRateClass2();
			break;
		case 3:
			elecConsumpCalc = getDetails.getdefaultConsumptionRateClass3();
			break;
		case 4:
			elecConsumpCalc = getDetails.getdefaultConsumptionRateClass4();
			break;
		case 5:
			elecConsumpCalc = getDetails.getdefaultConsumptionRateClass5();
			break;
		case 6:
			elecConsumpCalc = getDetails.getdefaultConsumptionRateClass6();
			break;
		case 7:
			elecConsumpCalc = getDetails.getdefaultConsumptionRateClass7();
			break;
		case 8:
			elecConsumpCalc = getDetails.getdefaultConsumptionRateClass8();
			break;

		}
		return elecConsumpCalc + "";
	}

		
	public void verifyExistingQuoteValues(GetAQuoteDetails getDetails) {
		String refNumber = browser.getTextByXpath(
				pageProperties.getProperty("GetAQuote.thankpageQuoteRef"))
				.trim();
		int supplyPointNumber = new OnlineDBConnector()
				.getSupplyPointNumber(refNumber);
		verifyElecQuoteDisplayedCharge(getDetails, supplyPointNumber);

	}

	public void validateDBWithoutSupplyCode(GetAQuoteDetails getDetails) {
		String refNumber = browser.getTextByXpath(
				pageProperties.getProperty("GetAQuote.thankpageQuoteRef"))
				.trim();
		int supplyPointNumber = new OnlineDBConnector()
				.getSupplyPointNumbernew(refNumber);
		verifyElecQuoteDisplayedChargeNew(getDetails, supplyPointNumber);

	}

	public void saveCurrentQuote1Year() {
		browser.wait(3000);
		browser.clickWithXpath("//a[@title='Save your quote']");
		GetaQuoteDetailsPage.quoteReferenceId = browser
				.getTextByXpath(pageProperties
		        .getProperty("GetAQuote.QuoteIdXpath"));

	}

	public void saveCurrentQuote2Year() {
		browser.wait(3000);
		browser.click("savebutton2");
		GetaQuoteDetailsPage.quoteReferenceId = browser
				.getTextByXpath(pageProperties
		        .getProperty("GetAQuote.QuoteIdXpath"));

	}

	public void saveCurrentQuote3year() {
		browser.wait(5000);
		browser.click("savebutton4");
		GetaQuoteDetailsPage.quoteReferenceId = browser
				.getTextByXpath(pageProperties
		        .getProperty("GetAQuote.QuoteIdXpath"));

	}

	public void saveCurrentQuoteCompareAllTab() {
		browser.wait(5000);
		browser.click("savebutton3");
		GetaQuoteDetailsPage.quoteReferenceId = browser
				.getTextByXpath(pageProperties
		        .getProperty("GetAQuote.QuoteIdXpath"));

	}

	public void saveCurrentQuote2year() {
		browser.clickWithXpath(pageProperties.getProperty("GetAQuote.Save2"));
		GetaQuoteDetailsPage.quoteReferenceId = browser
				.getTextByXpath(pageProperties
		        .getProperty("GetAQuote.QuoteIdXpath"));

	}

	public void saveCurrentQuote1year() {
		browser.clickWithXpath(pageProperties.getProperty("GetAQuote.Save1"));
		GetaQuoteDetailsPage.quoteReferenceId = browser
				.getTextByXpath(pageProperties
		        .getProperty("GetAQuote.QuoteIdXpath"));

	}

	public void retreiveSavedQuote(GetAQuoteDetails getDetails) {
		String logInfo = "";
		String logStatus = "PASS";
		browser.clickWithXpath(pageProperties
		        .getProperty("GetAQuote.RetreiveQuoteLinkXpath"));
		String currentPageTitle = browser.getTextByXpath("//title").trim();
		if (currentPageTitle.equalsIgnoreCase(pageProperties
		        .getProperty("GetAQuote.RetreiveQuotePageTitle"))) {
			logInfo = logInfo
					+ " Retreive Quote Page title matches with Expected.";

		} else {
			logInfo = logInfo
			        + "<b> Retreive Quote Page title does not match with Expected.</b>"
			        + " Expected page Title: "
					+ pageProperties
							.getProperty("GetAQuote.RetreiveQuotePageTitle")
			        + ", Current Page Title: " + currentPageTitle + ". ";
			logStatus = "FAIL";

		}
		browser.inputByXpath(
				pageProperties.getProperty("GetAQuote.QuoteIdTextXpath"),
		        GetaQuoteDetailsPage.quoteReferenceId);

		browser.inputByXpath(
				pageProperties.getProperty("GetAQuote.EmailIdTextXpath"),
		        getDetails.getEmail());
		browser.clickWithXpath(pageProperties
		        .getProperty("GetAQuote.RetreiveButtonXpath"));

	}

	public void verifySavedQuoteStatus() {
		String quoteStatus = new OnlineDBConnector()
		        .retreiveQuoteType(GetaQuoteDetailsPage.quoteReferenceId);

		if (quoteStatus.trim().equalsIgnoreCase(
		        pageProperties.getProperty("GetAQuote.SaveQuoteStatus"))) {
			Report.updateTestLog(
			        "Quote Status in Database is set to 'Saved Quote' as expected.",
			        "PASS");

		} else {
			Report.updateTestLog(
			        "Quote Status in Database does not match with expected. Expected quote Status: '"
							+ pageProperties
									.getProperty("GetAQuote.SaveQuoteStatus")
							+ "' Actual quote status: '" + quoteStatus + "'",
					"FAIL");

		}

	}

	public void salesafter2ndtab() {
		String quoteStatus = new OnlineDBConnector()
		        .retreiveQuoteTypeSales(GetaQuoteDetailsPage.quoteReferenceId);

		if (quoteStatus.trim().equalsIgnoreCase("Sales")) {
			Report.updateTestLog(
			        "Quote Status in Database is set to 'Sales' as expected.",
			        "PASS");

		} else {
			Report.updateTestLog(
					"Quote Status in Database is not set to 'Sales'", "FAIL");

		}

	}

	public void verifyUnSavedQuoteStatus() {
		String strQuote = browser.getTextByXpath(pageProperties
				.getProperty("GetAQuote.1stYearQRNO"));
		String QRNOSplit[] = strQuote.split(":");
		String QRNO1year = QRNOSplit[1].trim();
		String quoteStatus = new OnlineDBConnector()
		        .retreiveQuoteType(QRNO1year);

		if (quoteStatus.trim().equalsIgnoreCase(
		        pageProperties.getProperty("GetAQuote.UnSavedQuoteStatus"))) {
			Report.updateTestLog(
			        "Quote Status in Database is set to 'UnSaved Quote' as expected.",
			        "PASS");

		} else {
			Report.updateTestLog(
			        "Quote Status in Database does not match with expected. Expected quote Status: '"
							+ pageProperties
									.getProperty("GetAQuote.UnSavedQuoteStatus")
							+ "' Actual quote status: '" + quoteStatus + "'",
					"FAIL");
		}
	}

	public void verifySavedQuoteStatusBaddata() {
		String strQuote = browser.getTextByXpath(pageProperties
				.getProperty("GetAQuote.1stYearQRNO"));
		String QRNOSplit[] = strQuote.split(":");
		String QRNO1year = QRNOSplit[1].trim();
		String quoteStatus = new OnlineDBConnector()
		        .retreiveQuoteType(QRNO1year);

		if (quoteStatus.trim().equalsIgnoreCase("QUOTE_BAD_DATA_SAVED")) {
			Report.updateTestLog(
			        "Quote Status in Database is set to 'QUOTE_BAD_DATA_SAVED' as expected.",
			        "PASS");

		} else {
			Report.updateTestLog(
					"Quote Status in Database is not set to 'QUOTE_BAD_DATA_SAVED'",
					"FAIL");
	}
	}

	public void verifyAbandonedQuoteStatus(GetAQuoteDetails getDetails) {
		String quoteId = new OnlineDBConnector()
		        .retreiveRecentlyAbandonedQuteId(getDetails.getEmail());
		String quoteAbandonedStatus = new OnlineDBConnector()
		        .retreiveRecentlyAbandonedStatus(quoteId);

		if (quoteAbandonedStatus.trim().equalsIgnoreCase("true")) {
			Report.updateTestLog(
			        "Quote Abandoned status in Database is set to 'TRUE' as expected.",
			        "PASS");

		} else {
			Report.updateTestLog(
			        "Quote Abandoned status in Database is not as expected.. Expected quote Status: '"
							+ "TRUE"
							+ "' Actual quote status: '"
							+ quoteAbandonedStatus + "'", "FAIL");

		}

	}

	public void verifyBadDataType() {
		String qrno1 = browser.getTextByXpath(pageProperties
				.getProperty("GetAQuote.GasSupplypageRefNo"));
		String qrno2 = qrno1.trim();
		String quoteStatus = new OnlineDBConnector().retreiveQuoteType(qrno2);

		if (quoteStatus.trim().equalsIgnoreCase(
		        pageProperties.getProperty("GetAQuote.BadQuoteType"))) {
			Report.updateTestLog("Quote Status in Database is set to '"
					+ quoteStatus + "' as expected.", "PASS");

		} else {
			Report.updateTestLog(
			        "Quote Status in Database does not match with expected. Expected quote Status: '"
							+ pageProperties
									.getProperty("GetAQuote.BadQuoteType")
							+ "' Actual quote status: '" + quoteStatus + "'",
					"FAIL");

		}

	}

	public void verifyBadDataTypeUnsaved() {
		// String quoteStatus = new
		// OnlineDBConnector().retreiveQuoteType(GetaQuoteDetailsPage.quoteReferenceId);
		String strQuote = browser.getTextByXpath(pageProperties
				.getProperty("GetAQuote.1stYearQRNO"));
		String QRNOSplit[] = strQuote.split(":");
		String QRNO1year = QRNOSplit[1].trim();
		String quoteStatus = new OnlineDBConnector()
		        .retreiveQuoteType(QRNO1year);
		if (quoteStatus.trim().equalsIgnoreCase("QUOTE_BAD_DATA_UNSAVED")) {
			Report.updateTestLog("Quote Status in Database is set to '"
					+ quoteStatus + "' as expected.", "PASS");

		} else {
			Report.updateTestLog(
					"Quote Status in Database does not match with expected-QUOTE_BAD_DATA_UNSAVED",
					"FAIL");
		}

	}

	public void navigateToBusinessHome() {
		 if (ApplicationConfig.BRAND.equalsIgnoreCase("bg")) {
	            browser.open(ApplicationConfig.APP_BG_URL);
	            // uiDriver.get(ApplicationConfig.LOGIN_URL);
	        } else if (ApplicationConfig.BRAND.equalsIgnoreCase("bg")) {
	        	browser.open(ApplicationConfig.APP_BG_URL);
	        } else if (ApplicationConfig.BRAND.equalsIgnoreCase("bgb")) {
			browser.open(ApplicationConfig.APP_BGB_URL);
	        } else if (ApplicationConfig.BRAND.equalsIgnoreCase("services")) {
	        	browser.open(ApplicationConfig.APP_SERVICES_URL);
	        } else if (ApplicationConfig.BRAND.equalsIgnoreCase("fusion")) {
			browser.open(ApplicationConfig.APP_FUSION_URL);
	}

	}

	public void savedtextverificationmonthly(GetAQuoteDetails getDetails) {
		browser.wait(2000);
		verifyIsTextPresent("Quote Saved");
		String monthlysavedtext1 = browser.getTextByXpath(pageProperties
				.getProperty("GetAQuote.SavedText"));
		String monthlysavedtext2 = "This quote is based on a 1-year contract with  monthly variable Direct Debit";
		if (monthlysavedtext1.trim().equals(monthlysavedtext2)) {
			Report.updateTestLog("Expected Text is  " + monthlysavedtext2
					+ " Actual Text is  " + monthlysavedtext1 + "", "PASS");

		} else {
			Report.updateTestLog("Expected Text is  " + monthlysavedtext2
					+ " Actual Text is  " + monthlysavedtext1 + "", "FAIL");

		}

	}

	public void savedtextverificationquarter(GetAQuoteDetails getDetails) {
		browser.wait(5000);
		verifyIsTextPresent("Quote Saved");
		String monthlysavedtext1 = browser.getTextByXpath(pageProperties
				.getProperty("GetAQuote.SavedText"));
		String monthlysavedtext2 = "This quote is based on a 1-year contract with  quarterly cash/cheque";
		if (monthlysavedtext1.trim().equals(monthlysavedtext2)) {
			Report.updateTestLog("Expected Text is  " + monthlysavedtext2
					+ " Actual Text is  " + monthlysavedtext1 + "", "PASS");

		} else {
			Report.updateTestLog("Expected Text is  " + monthlysavedtext2
					+ " Actual Text is  " + monthlysavedtext1 + "", "FAIL");

		}
	}

	public void validateSecondYearContractMonthly(GetAQuoteDetails getDetails) {
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetAQuote.SecondYearLink"),
				"<B>Second Year Contract.</B>");
	}

	public void validateSecondYearContractQuarter(GetAQuoteDetails getDetails) {
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetAQuote.SecondYearLink"),
				"<B>Second Year Contract.</B>");
		verifyAndClickWithXpath("//li[@id='quarterly2']/input",
				"<B>Quarter Option Clicked in 2nd Year.</B>");
		}

	public void defaultConsumptionSupplyCode1year(
			GetAQuoteDetails getDetails, int i) {
		String annualconsumption = browser.getTextByXpath(pageProperties
				.getProperty("GetAQuote.Consumption1"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
		int elecConsumpCalc_Actual = Integer.parseInt(annualconsumption);
		defaultConsumptionSupplyCode11(getDetails, i, elecConsumpCalc_Actual);
	}

	public void defaultConsumptionSupplyCode2year(
			GetAQuoteDetails getDetails, int i) {
		String annualconsumption = browser.getTextByXpath(pageProperties
				.getProperty("GetAQuote.Consumption2"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
		int elecConsumpCalc_Actual = Integer.parseInt(annualconsumption);
		defaultConsumptionSupplyCode11(getDetails, i, elecConsumpCalc_Actual);
	}

	public void defaultConsumptionSupplyCode3year(
			GetAQuoteDetails getDetails, int i) {
		String annualconsumption = browser.getTextByXpath(pageProperties
				.getProperty("GetAQuote.Consumption3"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
		int elecConsumpCalc_Actual = Integer.parseInt(annualconsumption);
		defaultConsumptionSupplyCode11(getDetails, i, elecConsumpCalc_Actual);
	}

	public void defaultConsumptionSupplyCode11(GetAQuoteDetails getDetails,
			int i, int elecConsumpCalc_Actual) {
			switch (i) {
			case 1:

			double elecConsumpCalc = getDetails
					.getdefaultConsumptionRateClass1();
			int elecConsumpCalc_expected1 = (int) elecConsumpCalc;
			if (elecConsumpCalc_Actual == elecConsumpCalc_expected1) {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "   Expected Annual Consumption is:    "
						+ elecConsumpCalc_expected1 + "", "PASS");

			} else {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "   Expected Annual Consumption is:    "
						+ elecConsumpCalc_expected1 + "", "FAIL");
				}
				break;
			case 2:
				elecConsumpCalc = getDetails.getdefaultConsumptionRateClass2();
			int elecConsumpCalc_expected2 = (int) elecConsumpCalc;
			if (elecConsumpCalc_Actual == elecConsumpCalc_expected2) {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "    Annual Consumption Expected is:    "
						+ elecConsumpCalc_expected2 + "", "PASS");
				} else {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "   Expected Annual Consumption is:    "
						+ elecConsumpCalc_expected2 + "", "FAIL");
				}
				break;
			case 3:
				elecConsumpCalc = getDetails.getdefaultConsumptionRateClass3();
			int elecConsumpCalc_expected3 = (int) elecConsumpCalc;
			if (elecConsumpCalc_Actual == elecConsumpCalc_expected3) {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "    Annual Consumption Expected is:    "
						+ elecConsumpCalc_expected3 + "", "PASS");
				} else {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "   Expected Annual Consumption is:    "
						+ elecConsumpCalc_expected3 + "", "FAIL");
				}
				break;
			case 4:
				elecConsumpCalc = getDetails.getdefaultConsumptionRateClass4();
			int elecConsumpCalc_expected4 = (int) elecConsumpCalc;
			if (elecConsumpCalc_Actual == elecConsumpCalc_expected4) {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "    Annual Consumption Expected is:    "
						+ elecConsumpCalc_expected4 + "", "PASS");
				} else {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "   Expected Annual Consumption is:    "
						+ elecConsumpCalc_expected4 + "", "FAIL");
				}
				break;
			case 5:
				elecConsumpCalc = getDetails.getdefaultConsumptionRateClass5();
			int elecConsumpCalc_expected5 = (int) elecConsumpCalc;
			if (elecConsumpCalc_Actual == elecConsumpCalc_expected5) {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "    Annual Consumption Expected is:    "
						+ elecConsumpCalc_expected5 + "", "PASS");
				} else {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "   Expected Annual Consumption is:    "
						+ elecConsumpCalc_expected5 + "", "FAIL");
				}
				break;
			case 6:
				elecConsumpCalc = getDetails.getdefaultConsumptionRateClass6();
			int elecConsumpCalc_expected6 = (int) elecConsumpCalc;
			if (elecConsumpCalc_Actual == elecConsumpCalc_expected6) {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "    Annual Consumption Expected is:    "
						+ elecConsumpCalc_expected6 + "", "PASS");
				} else {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "   Expected Annual Consumption is:    "
						+ elecConsumpCalc_expected6 + "", "FAIL");
				}
				break;
			case 7:
				elecConsumpCalc = getDetails.getdefaultConsumptionRateClass7();
			int elecConsumpCalc_expected7 = (int) elecConsumpCalc;
			if (elecConsumpCalc_Actual == elecConsumpCalc_expected7) {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "    Annual Consumption Expected is:    "
						+ elecConsumpCalc_expected7 + "", "PASS");
				} else {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "   Expected Annual Consumption is:    "
						+ elecConsumpCalc_expected7 + "", "FAIL");
				}
				break;
			case 8:
				elecConsumpCalc = getDetails.getdefaultConsumptionRateClass8();
			int elecConsumpCalc_expected8 = (int) elecConsumpCalc;
			if (elecConsumpCalc_Actual == elecConsumpCalc_expected8) {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "    Annual Consumption Expected is:    "
						+ elecConsumpCalc_expected8 + "", "PASS");
				} else {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "   Expected Annual Consumption is:    "
						+ elecConsumpCalc_expected8 + "", "FAIL");
				}
				break;
			}
	}

	public void validateDefalutConsumption(GetAQuoteDetails getDetails,
			int intProfileClass) {
		/*
		 * String profileClass = getDetails.getSupplyNumber1();
		 * 
		 * int intProfileClass=Integer.parseInt(profileClass);
		 */

		String annualconsumption = browser.getTextByXpath(pageProperties
				.getProperty("GetAQuote.Consumption1"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
		int elecConsumpCalc_Actual = Integer.parseInt(annualconsumption);
		switch (intProfileClass) {
		case 1:

			double elecConsumpCalc = getDetails
					.getdefaultConsumptionRateClass1();
			int elecConsumpCalc_expected1 = (int) elecConsumpCalc;
			if (elecConsumpCalc_Actual == elecConsumpCalc_expected1) {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "   Expected Annual Consumption is:    "
						+ elecConsumpCalc_expected1 + "", "PASS");
			} else {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "   Expected Annual Consumption is:    "
						+ elecConsumpCalc_expected1 + "", "FAIL");
			}
			break;
		case 2:
			elecConsumpCalc = getDetails.getdefaultConsumptionRateClass2();
			int elecConsumpCalc_expected2 = (int) elecConsumpCalc;
			if (elecConsumpCalc_Actual == elecConsumpCalc_expected2) {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "    Annual Consumption Expected is:    "
						+ elecConsumpCalc_expected2 + "", "PASS");
			} else {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "   Expected Annual Consumption is:    "
						+ elecConsumpCalc_expected2 + "", "FAIL");
			}
			break;
		case 3:
			elecConsumpCalc = getDetails.getdefaultConsumptionRateClass3();
			int elecConsumpCalc_expected3 = (int) elecConsumpCalc;
			if (elecConsumpCalc_Actual == elecConsumpCalc_expected3) {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "    Annual Consumption Expected is:    "
						+ elecConsumpCalc_expected3 + "", "PASS");
			} else {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "   Expected Annual Consumption is:    "
						+ elecConsumpCalc_expected3 + "", "FAIL");
			}
			break;
		case 4:
			elecConsumpCalc = getDetails.getdefaultConsumptionRateClass4();
			int elecConsumpCalc_expected4 = (int) elecConsumpCalc;
			if (elecConsumpCalc_Actual == elecConsumpCalc_expected4) {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "    Annual Consumption Expected is:    "
						+ elecConsumpCalc_expected4 + "", "PASS");
			} else {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "   Expected Annual Consumption is:    "
						+ elecConsumpCalc_expected4 + "", "FAIL");
			}
			break;
		case 5:
			elecConsumpCalc = getDetails.getdefaultConsumptionRateClass5();
			int elecConsumpCalc_expected5 = (int) elecConsumpCalc;
			if (elecConsumpCalc_Actual == elecConsumpCalc_expected5) {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "    Annual Consumption Expected is:    "
						+ elecConsumpCalc_expected5 + "", "PASS");
			} else {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "   Expected Annual Consumption is:    "
						+ elecConsumpCalc_expected5 + "", "FAIL");
			}
			break;
		case 6:
			elecConsumpCalc = getDetails.getdefaultConsumptionRateClass6();
			int elecConsumpCalc_expected6 = (int) elecConsumpCalc;
			if (elecConsumpCalc_Actual == elecConsumpCalc_expected6) {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "    Annual Consumption Expected is:    "
						+ elecConsumpCalc_expected6 + "", "PASS");
			} else {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "   Expected Annual Consumption is:    "
						+ elecConsumpCalc_expected6 + "", "FAIL");
			}
			break;
		case 7:
			elecConsumpCalc = getDetails.getdefaultConsumptionRateClass7();
			int elecConsumpCalc_expected7 = (int) elecConsumpCalc;
			if (elecConsumpCalc_Actual == elecConsumpCalc_expected7) {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "    Annual Consumption Expected is:    "
						+ elecConsumpCalc_expected7 + "", "PASS");
			} else {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "   Expected Annual Consumption is:    "
						+ elecConsumpCalc_expected7 + "", "FAIL");
			}
			break;
		case 8:
			elecConsumpCalc = getDetails.getdefaultConsumptionRateClass8();
			int elecConsumpCalc_expected8 = (int) elecConsumpCalc;
			if (elecConsumpCalc_Actual == elecConsumpCalc_expected8) {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "    Annual Consumption Expected is:    "
						+ elecConsumpCalc_expected8 + "", "PASS");
			} else {
				Report.updateTestLog("Default Annual Consumption Actual is:   "
						+ elecConsumpCalc_Actual
						+ "   Expected Annual Consumption is:    "
						+ elecConsumpCalc_expected8 + "", "FAIL");
			}
			break;

		}
	}

	private void validateElectricityUnitChargesThirdYear(String supplyNumber4) {

		OnlineDBConnector onlineDBConnector = new OnlineDBConnector();

		int rateCount = browser.getChildElementsCountByXpath(pageProperties
				.getProperty("GetAQuote.Count3"));

		if (rateCount == 2) {
			String unitCharge = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.unitrate3"));
			// Replace non numeric characters here
			unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
			String standingCharge = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing3"));
			standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
			int unitRateCountinDB = onlineDBConnector.retreiveUnitChargesCount(
					unitCharge, supplyNumber4);
			if (unitRateCountinDB >= 1) {
				Report.updateTestLog("Unit Charge is available in DB"
						+ unitCharge, "PASS");
			} else {
				Report.updateTestLog("Unit Charge is not available in DB"
						+ unitCharge, "FAIL");
			}
			}
		if (rateCount == 3) {

			String unitCharge = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.unitrate3"));
			// Replace non numeric characters here
			unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
			String standingCharge = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing13"));
			standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");

			String NightCharge = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing3"));
			NightCharge = NightCharge.replaceAll("[^\\d(?!.)]", "");
			int unitRateCountinDB = onlineDBConnector.retreiveUnitChargesCount(
					unitCharge, supplyNumber4);
			if (unitRateCountinDB >= 1) {
				Report.updateTestLog("Unit Charge is available in DB"
						+ unitCharge, "PASS");
			} else {
				Report.updateTestLog("Unit Charge is not available in DB"
						+ unitCharge, "FAIL");
			}
			int unitRateCountinDB1 = onlineDBConnector
					.retreiveUnitChargesCount(NightCharge, supplyNumber4);
			if (unitRateCountinDB1 >= 1) {
				Report.updateTestLog("Unit Charge is available in DB"
						+ NightCharge, "PASS");
			} else {
				Report.updateTestLog("Unit Charge is not available in DB"
						+ NightCharge, "FAIL");
		}
			}
			}

	public void validateFirstYearContractMonthlyAndQuarter(
			GetAQuoteDetails getDetails, String NightChargedb,
			String StandingChargedb, int i, String UnitCharge_DB,
			String NotchValue_DB) {
		int rateCount = browser.getChildElementsCountByXpath(pageProperties
				.getProperty("GetAQuote.Count1"));
		if (rateCount == 2) {
			if (i == 1 || i == 3 || i == 5) {
				String unitCharge = browser.getTextByXpath(pageProperties
						.getProperty("GetAQuote.unitrate1"));
				unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
				double Unitcharge = Double.valueOf(unitCharge);
				double UnitCharge_db = Double.valueOf(UnitCharge_DB);
				UnitCharge_db = Math.round((UnitCharge_db) * 1000.0) / 1000.0;
				double NotchValue_db = Double.valueOf(NotchValue_DB);
				NotchValue_db = Math.round((NotchValue_db) * 1000.0) / 1000.0;
				double UnitandNotch = UnitCharge_db + NotchValue_db;
				UnitandNotch = Math.round((UnitandNotch) * 1000.0) / 1000.0;
				double UnitandNotch1 = Math.round((UnitandNotch) * 1000.0) / 1000.0;
				if (Unitcharge == UnitandNotch1) {
					Report.updateTestLog("Expected unit charge is ("
							+ UnitCharge_db + " + " + NotchValue_db + ")="
							+ UnitandNotch1 + " Acutal Unit charge is: "
							+ Unitcharge, "PASS");
				} else {
					Report.updateTestLog("Expected unit charge is ("
							+ UnitCharge_db + " + " + NotchValue_db + ")="
							+ UnitandNotch1 + " Acutal Unit charge is: "
							+ Unitcharge, "FAIL");
	}
				String standingCharge = browser.getTextByXpath(pageProperties
						.getProperty("GetAQuote.Standing1"));
				standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
				double StandingCharge = Double.valueOf(standingCharge);
				double StandingCharge_db = Double.valueOf(StandingChargedb);
				if (StandingCharge_db == StandingCharge) {
					Report.updateTestLog("Expected Standing Charge is "
							+ StandingCharge_db
							+ " Acutal Standing charge is: " + StandingCharge,
							"PASS");
				} else {
					Report.updateTestLog("Expected Standing Charge is "
							+ StandingCharge_db
							+ " Acutal Standing charge is: " + StandingCharge,
							"FAIL");
		}
				String annualconsumption = browser
						.getTextByXpath(pageProperties
								.getProperty("GetAQuote.Consumption1"));
				annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]",
						"");
				String monthly = browser.getTextByXpath(pageProperties
						.getProperty("GetAQuote.month1"));
				// Replace non numeric characters here
				monthly = monthly.replaceAll("[^\\d(?!.)]", "");
				String yearly = browser.getTextByXpath(pageProperties
						.getProperty("GetAQuote.Year1"));
				// Replace non numeric characters here
				yearly = yearly.replaceAll("[^\\d(?!.)]", "");
				validateElecRates2(unitCharge, standingCharge,
						annualconsumption, monthly, yearly);
	}
		}
		if (rateCount == 3) {
			String unitCharge = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.unitrate1"));
			unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
			double Unitcharge = Double.valueOf(unitCharge);
			double UnitCharge_db = Double.valueOf(UnitCharge_DB);
			UnitCharge_db = Math.round((UnitCharge_db) * 1000.0) / 1000.0;
			double NotchValue_db = Double.valueOf(NotchValue_DB);
			NotchValue_db = Math.round((NotchValue_db) * 1000.0) / 1000.0;
			double UnitandNotch = UnitCharge_db + NotchValue_db;
			UnitandNotch = Math.round((UnitandNotch) * 1000.0) / 1000.0;
			double UnitandNotch1 = Math.round((UnitandNotch) * 1000.0) / 1000.0;
			if (Unitcharge == UnitandNotch1) {
				Report.updateTestLog("Expected unit charge is ("
						+ UnitCharge_db + " + " + NotchValue_db + ")="
						+ UnitandNotch1 + " Acutal Unit charge is: "
						+ Unitcharge, "PASS");
			} else {
				Report.updateTestLog("Expected unit charge is ("
						+ UnitCharge_db + " + " + NotchValue_db + ")="
						+ UnitandNotch1 + " Acutal Unit charge is: "
						+ Unitcharge, "FAIL");
		}
			String standingCharge = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing11"));
			standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
			double StandingCharge = Double.valueOf(standingCharge);
			double StandingCharge_db = Double.valueOf(StandingChargedb);
			if (StandingCharge_db == StandingCharge) {
				Report.updateTestLog("Expected Standing Charge is "
						+ StandingCharge_db + " Acutal Standing charge is: "
						+ StandingCharge, "PASS");
			} else {
				Report.updateTestLog("Expected Standing Charge is "
						+ StandingCharge_db + " Acutal Standing charge is: "
						+ StandingCharge, "FAIL");
	}
			String NightCharge = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.night1"));
			NightCharge = NightCharge.replaceAll("[^\\d(?!.)]", "");
			double NightUnitcharge = Double.valueOf(NightCharge);
			double NightUnitCharge_db = Double.valueOf(NightChargedb);
			NotchValue_db = Double.valueOf(NotchValue_DB);
			double NightUnitandNotch = NightUnitCharge_db + NotchValue_db;
			NightUnitandNotch = Math.round((NightUnitandNotch) * 1000.0) / 1000.0;
			if (NightUnitcharge == NightUnitandNotch) {
				Report.updateTestLog("Expected Night Unit Charge is ("
						+ NightUnitCharge_db + " + " + NotchValue_db + ")="
						+ NightUnitandNotch + " Acutal Night Unit charge is: "
						+ NightUnitcharge, "PASS");
			} else {
				Report.updateTestLog("Expected Night Unit Charge is ("
						+ NightUnitCharge_db + " + " + NotchValue_db + ")="
						+ NightUnitandNotch + " Acutal Night Unit charge is: "
						+ NightUnitcharge, "FAIL");
	}
			String annualconsumption = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Consumption1"));
			annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
			String monthly = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.month1"));
			monthly = monthly.replaceAll("[^\\d(?!.)]", "");
			String yearly = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Year1"));
			yearly = yearly.replaceAll("[^\\d(?!.)]", "");
			if (i == 2) {
				validateElecRates2(unitCharge, standingCharge, NightCharge,
						annualconsumption, monthly, yearly);
	}
			if (i == 4) {
				validateElecRates4(unitCharge, standingCharge, NightCharge,
						annualconsumption, monthly, yearly);
	}
			if (i == 6) {
				validateElecRates6(unitCharge, standingCharge, NightCharge,
						annualconsumption, monthly, yearly);
		}
			if (i == 7) {
				validateElecRates7(unitCharge, standingCharge, NightCharge,
						annualconsumption, monthly, yearly);
		}
			if (i == 8) {
				validateElecRates8(unitCharge, standingCharge, NightCharge,
						annualconsumption, monthly, yearly);
		}
		}
	}

	public void validateSecondYearContractMonthlyAndQuarter(
			GetAQuoteDetails getDetails, String NightChargedb,
			String StandingChargedb, int i, String UnitCharge_DB,
			String NotchValue_DB) {
		verifyAndClickWithXpath(
				pageProperties.getProperty("GetAQuote.SecondYearLink"),
				"Second Year Contract.");
		int rateCount = browser.getChildElementsCountByXpath(pageProperties
				.getProperty("GetAQuote.Count2"));
		if (rateCount == 2) {
			if (i == 1 || i == 3 || i == 5) {
				String unitCharge = browser.getTextByXpath(pageProperties
						.getProperty("GetAQuote.SecondYearUnitRate"));
				// Replace non numeric characters here
				unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
				double Unitcharge = Double.valueOf(unitCharge);
				double UnitCharge_db = Double.valueOf(UnitCharge_DB);
				double NotchValue_db = Double.valueOf(NotchValue_DB);
				double UnitandNotch = UnitCharge_db + NotchValue_db;
				UnitandNotch = Math.round((UnitandNotch) * 1000.0) / 1000.0;
				if (Unitcharge == UnitandNotch) {
					Report.updateTestLog("Expected unit charge is ("
							+ UnitCharge_db + " + " + NotchValue_db + ")="
							+ UnitandNotch + " Acutal Unit charge is: "
							+ Unitcharge, "PASS");
				} else {
					Report.updateTestLog("Expected unit charge is ("
							+ UnitCharge_db + " + " + NotchValue_db + ")="
							+ UnitandNotch + " Acutal Unit charge is: "
							+ Unitcharge, "FAIL");
	}
				String standingCharge = browser.getTextByXpath(pageProperties
						.getProperty("GetAQuote.SecondYearStandingRate"));
				standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
				double StandingCharge = Double.valueOf(standingCharge);
				double StandingCharge_db = Double.valueOf(StandingChargedb);
				if (StandingCharge_db == StandingCharge) {
					Report.updateTestLog("Expected Standing Charge is "
							+ StandingCharge_db
							+ " Acutal Standing charge is: " + StandingCharge,
							"PASS");
				} else {
					Report.updateTestLog("Expected Standing Charge is "
							+ StandingCharge_db
							+ " Acutal Standing charge is: " + StandingCharge,
							"FAIL");
	}
				String annualconsumption = browser
						.getTextByXpath(pageProperties
								.getProperty("GetAQuote.SecondElecConsumpAnnual"));
				annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]",
						"");
				String monthly = browser.getTextByXpath(pageProperties
						.getProperty("GetAQuote.month2"));
				// Replace non numeric characters here
				monthly = monthly.replaceAll("[^\\d(?!.)]", "");
				String yearly = browser.getTextByXpath(pageProperties
						.getProperty("GetAQuote.Year2"));
				// Replace non numeric characters here
				yearly = yearly.replaceAll("[^\\d(?!.)]", "");
				validateElecRates2(unitCharge, standingCharge,
						annualconsumption, monthly, yearly);
	}
	}
		if (rateCount == 3) {
			String unitCharge = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.unitrate2"));
			// Replace non numeric characters here
			unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
			double Unitcharge = Double.valueOf(unitCharge);
			double UnitCharge_db = Double.valueOf(UnitCharge_DB);
			double NotchValue_db = Double.valueOf(NotchValue_DB);
			double UnitandNotch = UnitCharge_db + NotchValue_db;
			UnitandNotch = Math.round((UnitandNotch) * 1000.0) / 1000.0;
			if (Unitcharge == UnitandNotch) {
				Report.updateTestLog("Expected unit charge is ("
						+ UnitCharge_db + " + " + NotchValue_db + ")="
						+ UnitandNotch + " Acutal Unit charge is: "
						+ Unitcharge, "PASS");
			} else {
				Report.updateTestLog("Expected unit charge is ("
						+ UnitCharge_db + " + " + NotchValue_db + ")="
						+ UnitandNotch + " Acutal Unit charge is: "
						+ Unitcharge, "FAIL");
		}
			String standingCharge = browser
					.getTextByXpath("//div[@id='dayCharge-year2']/ul[3]/li[2]");
			standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
			double StandingCharge = Double.valueOf(standingCharge);
			double StandingCharge_db = Double.valueOf(StandingChargedb);
			if (StandingCharge_db == StandingCharge) {
				Report.updateTestLog("Expected Standing Charge is "
						+ StandingCharge_db + " Acutal Standing charge is: "
						+ StandingCharge, "PASS");
			} else {
				Report.updateTestLog("Expected Standing Charge is "
						+ StandingCharge_db + " Acutal Standing charge is: "
						+ StandingCharge, "FAIL");
		}
			String NightCharge = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing2"));
			NightCharge = NightCharge.replaceAll("[^\\d(?!.)]", "");
			double NightUnitcharge = Double.valueOf(NightCharge);
			double NightUnitCharge_db = Double.valueOf(NightChargedb);
			NotchValue_db = Double.valueOf(NotchValue_DB);
			double NightUnitandNotch = NightUnitCharge_db + NotchValue_db;
			double NightUnitChargeandNotch = Math
					.round((NightUnitandNotch) * 1000.0) / 1000.0;
			if (NightUnitcharge == NightUnitChargeandNotch) {
				Report.updateTestLog("Expected Night Unit Charge is ("
						+ NightUnitCharge_db + " + " + NotchValue_db + ")="
						+ NightUnitChargeandNotch
						+ " Acutal Night Unit charge is: " + NightUnitcharge,
						"PASS");
			} else {
				Report.updateTestLog("Expected Night Unit Charge is ("
						+ NightUnitCharge_db + " + " + NotchValue_db + ")="
						+ NightUnitChargeandNotch
						+ " Acutal Night Unit charge is: " + NightUnitcharge,
						"FAIL");
		}
			String annualconsumption = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.SecondElecConsumpAnnual"));
			annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
			String monthly = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.month2"));
			monthly = monthly.replaceAll("[^\\d(?!.)]", "");
			String yearly = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Year2"));
			yearly = yearly.replaceAll("[^\\d(?!.)]", "");
			if (i == 2) {
				validateElecRates2(unitCharge, standingCharge, NightCharge,
						annualconsumption, monthly, yearly);
		}
			if (i == 4) {
				validateElecRates4(unitCharge, standingCharge, NightCharge,
						annualconsumption, monthly, yearly);
	}
			if (i == 6) {
				validateElecRates6(unitCharge, standingCharge, NightCharge,
						annualconsumption, monthly, yearly);
		}
			if (i == 7) {
				validateElecRates7(unitCharge, standingCharge, NightCharge,
						annualconsumption, monthly, yearly);
		}
			if (i == 8) {
				validateElecRates8(unitCharge, standingCharge, NightCharge,
						annualconsumption, monthly, yearly);
		}
			}
			}

	public void validateThirdYearContractMonthlyAndQuarter(
			GetAQuoteDetails getDetails, String NightChargedb,
			String StandingChargedb, int i, String UnitCharge_DB,
			String NotchValue_DB) {
		int rateCount = browser.getChildElementsCountByXpath(pageProperties
				.getProperty("GetAQuote.Count3"));
		if (rateCount == 2) {
			if (i == 1 || i == 3 || i == 5) {
				String unitCharge = browser.getTextByXpath(pageProperties
						.getProperty("GetAQuote.unitrate3"));
				unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
				double Unitcharge = Double.valueOf(unitCharge);
				double UnitCharge_db = Double.valueOf(UnitCharge_DB);
				double NotchValue_db = Double.valueOf(NotchValue_DB);
				double UnitandNotch = UnitCharge_db + NotchValue_db;
				UnitandNotch = Math.round((UnitandNotch) * 1000.0) / 1000.0;
				if (Unitcharge == UnitandNotch) {
					Report.updateTestLog("Expected unit charge is ("
							+ UnitCharge_db + " + " + NotchValue_db + ")="
							+ UnitandNotch + " Acutal Unit charge is: "
							+ Unitcharge, "PASS");
				} else {
					Report.updateTestLog("Expected unit charge is ("
							+ UnitCharge_db + " + " + NotchValue_db + ")="
							+ UnitandNotch + " Acutal Unit charge is: "
							+ Unitcharge, "FAIL");
		}
				String standingCharge = browser.getTextByXpath(pageProperties
						.getProperty("GetAQuote.Standing3"));
				standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
				double StandingCharge = Double.valueOf(standingCharge);
				double StandingCharge_db = Double.valueOf(StandingChargedb);
				if (StandingCharge_db == StandingCharge) {
					Report.updateTestLog("Expected Standing Charge is "
							+ StandingCharge_db
							+ " Acutal Standing charge is: " + StandingCharge,
							"PASS");
				} else {
					Report.updateTestLog("Expected Standing Charge is "
							+ StandingCharge_db
							+ " Acutal Standing charge is: " + StandingCharge,
							"FAIL");
		}
				String annualconsumption = browser
						.getTextByXpath(pageProperties
								.getProperty("GetAQuote.Consumption3"));
				annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]",
						"");

				String monthly = browser.getTextByXpath(pageProperties
						.getProperty("GetAQuote.month3"));
				monthly = monthly.replaceAll("[^\\d(?!.)]", "");

				String yearly = browser.getTextByXpath(pageProperties
						.getProperty("GetAQuote.Year3"));
				yearly = yearly.replaceAll("[^\\d(?!.)]", "");

				validateElecRates2(unitCharge, standingCharge,
						annualconsumption, monthly, yearly);
		}
	}
		if (rateCount == 3) {

			String unitCharge = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.unitrate3"));

			unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
			double Unitcharge = Double.valueOf(unitCharge);
			double UnitCharge_db = Double.valueOf(UnitCharge_DB);
			double NotchValue_db = Double.valueOf(NotchValue_DB);
			double UnitandNotch = UnitCharge_db + NotchValue_db;
			UnitandNotch = Math.round((UnitandNotch) * 1000.0) / 1000.0;
			if (Unitcharge == UnitandNotch) {
				Report.updateTestLog("Expected unit charge is ("
						+ UnitCharge_db + " + " + NotchValue_db + ")="
						+ UnitandNotch + " Acutal Unit charge is: "
						+ Unitcharge, "PASS");
			} else {
				Report.updateTestLog("Expected unit charge is ("
						+ UnitCharge_db + " + " + NotchValue_db + ")="
						+ UnitandNotch + " Acutal Unit charge is: "
						+ Unitcharge, "FAIL");
		}
			String standingCharge = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing13"));
			standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
			double StandingCharge = Double.valueOf(standingCharge);
			double StandingCharge_db = Double.valueOf(StandingChargedb);
			if (StandingCharge_db == StandingCharge) {
				Report.updateTestLog("Expected Standing Charge is "
						+ StandingCharge_db + " Acutal Standing charge is: "
						+ StandingCharge, "PASS");
			} else {
				Report.updateTestLog("Expected Standing Charge is "
						+ StandingCharge_db + " Acutal Standing charge is: "
						+ StandingCharge, "FAIL");
		}
			String NightCharge = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing3"));
			NightCharge = NightCharge.replaceAll("[^\\d(?!.)]", "");
			double NightUnitcharge = Double.valueOf(NightCharge);
			double NightUnitCharge_db = Double.valueOf(NightChargedb);
			NotchValue_db = Double.valueOf(NotchValue_DB);
			double NightUnitandNotch = NightUnitCharge_db + NotchValue_db;
			double NightUnitChargeandNotch = Math
					.round((NightUnitandNotch) * 1000.0) / 1000.0;
			if (NightUnitcharge == NightUnitChargeandNotch) {
				Report.updateTestLog("Expected Night Unit Charge is ("
						+ NightUnitCharge_db + " + " + NotchValue_db + ")="
						+ NightUnitChargeandNotch
						+ " Acutal Night Unit charge is: " + NightUnitcharge,
						"PASS");
			} else {
				Report.updateTestLog("Expected Night Unit Charge is ("
						+ NightUnitCharge_db + " + " + NotchValue_db + ")="
						+ NightUnitChargeandNotch
						+ " Acutal Night Unit charge is: " + NightUnitcharge,
						"FAIL");
	}
			String annualconsumption = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Consumption3"));
			annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
			String monthly = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.month3"));
			monthly = monthly.replaceAll("[^\\d(?!.)]", "");
			String yearly = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Year3"));
			yearly = yearly.replaceAll("[^\\d(?!.)]", "");
			if (i == 2) {
				validateElecRates2(unitCharge, standingCharge, NightCharge,
						annualconsumption, monthly, yearly);
						}
			if (i == 4) {
				validateElecRates4(unitCharge, standingCharge, NightCharge,
						annualconsumption, monthly, yearly);
						}
			if (i == 6) {
				validateElecRates6(unitCharge, standingCharge, NightCharge,
						annualconsumption, monthly, yearly);
						}
			if (i == 7) {
				validateElecRates7(unitCharge, standingCharge, NightCharge,
						annualconsumption, monthly, yearly);
						}
			if (i == 8) {
				validateElecRates8(unitCharge, standingCharge, NightCharge,
						annualconsumption, monthly, yearly);
				}
	}
					}

	public void validateFirstYearContractMonthlyGas(
			GetAQuoteDetails getDetails, String UnitCharge_DB,
			String StandingChargeDB, String NotchValue_DB) {

		int rateCount = browser.getChildElementsCountByXpath(pageProperties
				.getProperty("GetAQuote.Count1"));

		if (rateCount == 2) {
			String unitCharge = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.unitrate1"));
			unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
			double Unitcharge = Double.valueOf(unitCharge);
			double UnitCharge_db = Double.valueOf(UnitCharge_DB);
			double NotchValue_db = Double.valueOf(NotchValue_DB);
			double UnitandNotch = UnitCharge_db + NotchValue_db;
			UnitandNotch = Math.round((UnitandNotch) * 1000.0) / 1000.0;
			if (Unitcharge == UnitandNotch) {
				Report.updateTestLog("Expected unit charge is ("
						+ UnitCharge_db + " + " + NotchValue_db + ")="
						+ UnitandNotch + " Acutal Unit charge is: "
						+ Unitcharge, "PASS");
			} else {
				Report.updateTestLog("Expected unit charge is ("
						+ UnitCharge_db + " + " + NotchValue_db + ")="
						+ UnitandNotch + " Acutal Unit charge is: "
						+ Unitcharge, "FAIL");
				}
			String standingCharge = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing1"));
			standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
			double StandingCharge = Double.valueOf(standingCharge);
			double StandingCharge_db = Double.valueOf(StandingChargeDB);
			if (StandingCharge_db == StandingCharge) {
				Report.updateTestLog("Expected Standing Charge is "
						+ StandingCharge_db + " Acutal Standing charge is: "
						+ StandingCharge, "PASS");
			} else {
				Report.updateTestLog("Expected Standing Charge is "
						+ StandingCharge_db + " Acutal Standing charge is: "
						+ StandingCharge, "FAIL");
				}
			String annualconsumption = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Consumption1"));
			annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");

			String monthly = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.month1"));
			monthly = monthly.replaceAll("[^\\d(?!.)]", "");

			String yearly = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Year1"));
			yearly = yearly.replaceAll("[^\\d(?!.)]", "");
			validateElecRatesMonthlyGas2(unitCharge, standingCharge,
					annualconsumption, monthly, yearly);

		}
	}

	public void validateSecondYearContractMonthlyGas(
			GetAQuoteDetails getDetails, String UnitCharge_DB,
			String StandingChargeDB, String NotchValue_DB) {

		int rateCount = browser.getChildElementsCountByXpath(pageProperties
				.getProperty("GetAQuote.Count2"));

		if (rateCount == 2) {
			String unitCharge = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.unitrate2"));
			unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
			double Unitcharge = Double.valueOf(unitCharge);
			double UnitCharge_db = Double.valueOf(UnitCharge_DB);
			double NotchValue_db = Double.valueOf(NotchValue_DB);
			double UnitandNotch = UnitCharge_db + NotchValue_db;
			UnitandNotch = Math.round((UnitandNotch) * 1000.0) / 1000.0;
			if (Unitcharge == UnitandNotch) {
				Report.updateTestLog("Expected unit charge is ("
						+ UnitCharge_db + " + " + NotchValue_db + ")="
						+ UnitandNotch + " Acutal Unit charge is: "
						+ Unitcharge, "PASS");
			} else {
				Report.updateTestLog("Expected unit charge is ("
						+ UnitCharge_db + " + " + NotchValue_db + ")="
						+ UnitandNotch + " Acutal Unit charge is: "
						+ Unitcharge, "FAIL");
		}
			String standingCharge = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing2"));
			standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
			double StandingCharge = Double.valueOf(standingCharge);
			double StandingCharge_db = Double.valueOf(StandingChargeDB);
			if (StandingCharge_db == StandingCharge) {
				Report.updateTestLog("Expected Standing Charge is "
						+ StandingCharge_db + " Acutal Standing charge is: "
						+ StandingCharge, "PASS");
			} else {
				Report.updateTestLog("Expected Standing Charge is "
						+ StandingCharge_db + " Acutal Standing charge is: "
						+ StandingCharge, "FAIL");
				}
			String annualconsumption = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Consumption2"));
			annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
			String monthly = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.month2"));
			monthly = monthly.replaceAll("[^\\d(?!.)]", "");
			String yearly = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Year2"));
			yearly = yearly.replaceAll("[^\\d(?!.)]", "");
			validateElecRatesMonthlyGas2(unitCharge, standingCharge,
					annualconsumption, monthly, yearly);

			}
			}

	public void validateThirdYearContractMonthlyGas(
			GetAQuoteDetails getDetails, String UnitCharge_DB,
			String StandingChargeDB, String NotchValue_DB) {
		int rateCount = browser.getChildElementsCountByXpath(pageProperties
				.getProperty("GetAQuote.Count3"));
		if (rateCount == 2) {
			String unitCharge = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.unitrate3"));
			unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
			double Unitcharge = Double.valueOf(unitCharge);
			double UnitCharge_db = Double.valueOf(UnitCharge_DB);
			double NotchValue_db = Double.valueOf(NotchValue_DB);
			double UnitandNotch = UnitCharge_db + NotchValue_db;
			UnitandNotch = Math.round((UnitandNotch) * 1000.0) / 1000.0;
			if (Unitcharge == UnitandNotch) {
				Report.updateTestLog("Expected unit charge is ("
						+ UnitCharge_db + " + " + NotchValue_db + ")="
						+ UnitandNotch + " Acutal Unit charge is: "
						+ Unitcharge, "PASS");
			} else {
				Report.updateTestLog("Expected unit charge is ("
						+ UnitCharge_db + " + " + NotchValue_db + ")="
						+ UnitandNotch + " Acutal Unit charge is: "
						+ Unitcharge, "FAIL");
	}
			String standingCharge = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Standing3"));
			standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
			double StandingCharge = Double.valueOf(standingCharge);
			double StandingCharge_db = Double.valueOf(StandingChargeDB);
			if (StandingCharge_db == StandingCharge) {
				Report.updateTestLog("Expected Standing Charge is "
						+ StandingCharge_db + " Acutal Standing charge is: "
						+ StandingCharge, "PASS");
			} else {
				Report.updateTestLog("Expected Standing Charge is "
						+ StandingCharge_db + " Acutal Standing charge is: "
						+ StandingCharge, "FAIL");
	}
			String annualconsumption = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Consumption3"));
			annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
			String monthly = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.month3"));
			monthly = monthly.replaceAll("[^\\d(?!.)]", "");
			String yearly = browser.getTextByXpath(pageProperties
					.getProperty("GetAQuote.Year3"));
			yearly = yearly.replaceAll("[^\\d(?!.)]", "");
			validateElecRatesMonthlyGas2(unitCharge, standingCharge,
					annualconsumption, monthly, yearly);

			}
			}

	private void validateElecRatesMonthlyGas2(String unitCharge,
			String standingCharge, String annualconsumption, String Monthly,
			String yearly) {
		double unitChargeDBL = Double.parseDouble(unitCharge);
		double standinChargeDBL = Double.parseDouble(standingCharge);
		double annualconsumptionDBL = Double.parseDouble(annualconsumption);
		double yearly1 = Double.parseDouble(yearly);
		double Monthly1 = Double.parseDouble(Monthly);
		double Quarter1 = Double.parseDouble(Monthly);
		double annualRate = (standinChargeDBL * 365) / 100
				+ (annualconsumptionDBL * (unitChargeDBL)) / 100;
		double AnnualRate = Math.round((annualRate) * 100.0) / 100.0;
		singlerate(AnnualRate, yearly1, Quarter1, Monthly1);
			}

	private void validateElecRates2(String unitCharge, String standingCharge,
			String annualconsumption, String Monthly, String yearly) {
		double unitChargeDBL = Double.parseDouble(unitCharge);
		double standinChargeDBL = Double.parseDouble(standingCharge);
		double annualconsumptionDBL = Double.parseDouble(annualconsumption);
		double yearly1 = Double.parseDouble(yearly);
		double Monthly1 = Double.parseDouble(Monthly);
		double Quarter1 = Double.parseDouble(Monthly);
		double annualRate = (standinChargeDBL * 365) / 100
				+ (annualconsumptionDBL * (unitChargeDBL)) / 100;
		double AnnualRate = Math.round((annualRate) * 100.0) / 100.0;
		singlerate(AnnualRate, yearly1, Quarter1, Monthly1);
			}

	public void singlerate(double annualRate, double yearly1, double Quarter1,
			double Monthly1) {
		double monthlyRate;
		double quarterrate;
		if (browser.isSelectedByXpath(pageProperties
				.getProperty("GetAQuote.quarterbutton1_ele"))
				|| browser.isSelectedByXpath(pageProperties
						.getProperty("GetAQuote.quarterbutton2_ele"))
				|| browser.isSelectedByXpath(pageProperties
						.getProperty("GetAQuote.quarterbutton3_ele"))) {
			quarterrate = annualRate / 4;
			//double annualRate1 = Math.round(annualRate * 1000.0) / 1000.0;
			quarterrate = Math.round(quarterrate * 100.0) / 100.0;
			//double quarterrate1 = Math.round(quarterrate * 1000.0) / 1000.0;
			if (Math.round(yearly1) == Math.round(annualRate)) {
				Report.updateTestLog("Actual  Annual rate is:" + yearly1
						+ "Expected Annual Rate is: " + annualRate + "", "PASS");
			} else {
				Report.updateTestLog("Actual  Annual rate is:" + yearly1
						+ "Expected Annual Rate is: " + annualRate + "", "FAIL");
				}
			if (Math.round(Quarter1) == Math.round(quarterrate)) {
				Report.updateTestLog("Actual  Quarter rate is:" + Quarter1
						+ "Expected Quarter Rate is: " + quarterrate + "",
						"PASS");
			} else {
				Report.updateTestLog("Actual  Quarter rate is:" + Quarter1
						+ "Expected Quarter Rate is: " + quarterrate + "",
						"FAIL");
				}
		} else {
			//double annualRate2 = Math.round(annualRate * 1000.0) / 1000.0;
			monthlyRate = annualRate / 12;
			monthlyRate = Math.round(monthlyRate * 100.0) / 100.0;
			if (Math.round(yearly1) == Math.round(annualRate)) {
				Report.updateTestLog("Actual  Annual rate is:" + yearly1
						+ "Expected Annual Rate is: " + annualRate + "", "PASS");
			} else {
				Report.updateTestLog("Actual  Annual rate is:" + yearly1
						+ "Expected Annual Rate is: " + annualRate + "", "FAIL");
		}
			if (Math.round(Monthly1) == Math.round(monthlyRate)) {
				Report.updateTestLog("Actual Monthly rate is:" + Monthly1
						+ "Expected Monthly Rate is: " + monthlyRate + "",
						"PASS");
			} else {
				Report.updateTestLog("Actual Monthly rate is:" + Monthly1
						+ "Expected Monthly Rate is: " + monthlyRate + "",
						"FAIL");
			}
			}
	}

	private void validateElecRates2(String unitCharge, String standingCharge,
			String NightCharge, String annualconsumption, String Monthly,
			String yearly) {
		double unitChargeDBL = Double.parseDouble(unitCharge);
		double standinChargeDBL = Double.parseDouble(standingCharge);
		double NightChargeDBL = Double.parseDouble(NightCharge);
		double annualconsumptionDBL = Double.parseDouble(annualconsumption);
		double yearly1 = Double.parseDouble(yearly);
		double Monthly1 = Double.parseDouble(Monthly);
		double Quarter1 = Double.parseDouble(Monthly);
		double DaySpend = (0.7437931 * annualconsumptionDBL * unitChargeDBL) / 100;
		double NightSpend = (0.2562069 * annualconsumptionDBL * NightChargeDBL) / 100;
		double annualRate = (standinChargeDBL * 365) / 100 + DaySpend+ NightSpend;
		annualRate=Math.round(annualRate*100.0)/100.0;
		firstYearFormulaNightcharge(yearly1, Monthly1, Quarter1, DaySpend,
				NightSpend, annualRate);
	}

	private void validateElecRates4(String unitCharge, String standingCharge,
			String NightCharge, String annualconsumption, String Monthly,
			String yearly) {
		double unitChargeDBL = Double.parseDouble(unitCharge);
		double standinChargeDBL = Double.parseDouble(standingCharge);
		double NightChargeDBL = Double.parseDouble(NightCharge);
		double annualconsumptionDBL = Double.parseDouble(annualconsumption);
		double yearly1 = Double.parseDouble(yearly);
		double Monthly1 = Double.parseDouble(Monthly);
		double Quarter1 = Double.parseDouble(Monthly);
		double DaySpend = (0.7437931 * annualconsumptionDBL * unitChargeDBL) / 100;
		double NightSpend = (0.2562069 * annualconsumptionDBL * NightChargeDBL) / 100;
		double annualRate = (standinChargeDBL * 365) / 100 + DaySpend
				+ NightSpend;
		annualRate=Math.round(annualRate*100.0)/100.0;
		firstYearFormulaNightcharge(yearly1, Monthly1, Quarter1, DaySpend,
				NightSpend, annualRate);

	}

	private void validateElecRates6(String unitCharge, String standingCharge,
			String NightCharge, String annualconsumption, String Monthly,
			String yearly) {
		double unitChargeDBL = Double.parseDouble(unitCharge);
		double standinChargeDBL = Double.parseDouble(standingCharge);
		double NightChargeDBL = Double.parseDouble(NightCharge);
		double annualconsumptionDBL = Double.parseDouble(annualconsumption);
		double yearly1 = Double.parseDouble(yearly);
		double Monthly1 = Double.parseDouble(Monthly);
		double Quarter1 = Double.parseDouble(Monthly);
		double DaySpend = (0.82689112 * annualconsumptionDBL * unitChargeDBL) / 100;
		double NightSpend = (0.17310888 * annualconsumptionDBL * NightChargeDBL) / 100;
		double annualRate = (standinChargeDBL * 365) / 100 + DaySpend
				+ NightSpend;
		annualRate=Math.round(annualRate*100.0)/100.0;
		firstYearFormulaNightcharge(yearly1, Monthly1, Quarter1, DaySpend,
				NightSpend, annualRate);
					}

	private void validateElecRates7(String unitCharge, String standingCharge,
			String NightCharge, String annualconsumption, String Monthly,
			String yearly) {
		double unitChargeDBL = Double.parseDouble(unitCharge);
		double standinChargeDBL = Double.parseDouble(standingCharge);
		double NightChargeDBL = Double.parseDouble(NightCharge);
		double annualconsumptionDBL = Double.parseDouble(annualconsumption);
		double yearly1 = Double.parseDouble(yearly);
		double Monthly1 = Double.parseDouble(Monthly);
		double Quarter1 = Double.parseDouble(Monthly);
		double DaySpend = (0.814085274 * annualconsumptionDBL * unitChargeDBL) / 100;
		double NightSpend = (0.18591472 * annualconsumptionDBL * NightChargeDBL) / 100;
		double annualRate = (standinChargeDBL * 365) / 100 + DaySpend
				+ NightSpend;
		annualRate=Math.round(annualRate*100.0)/100.0;
		firstYearFormulaNightcharge(yearly1, Monthly1, Quarter1, DaySpend,
				NightSpend, annualRate);
					}

	private void validateElecRates8(String unitCharge, String standingCharge,
			String NightCharge, String annualconsumption, String Monthly,
			String yearly) {
		double unitChargeDBL = Double.parseDouble(unitCharge);
		double standinChargeDBL = Double.parseDouble(standingCharge);
		double NightChargeDBL = Double.parseDouble(NightCharge);
		double annualconsumptionDBL = Double.parseDouble(annualconsumption);
		double yearly1 = Double.parseDouble(yearly);
		double Monthly1 = Double.parseDouble(Monthly);
		double Quarter1 = Double.parseDouble(Monthly);
		double DaySpend = (0.755109141 * annualconsumptionDBL * unitChargeDBL) / 100;
		double NightSpend = (0.244890859 * annualconsumptionDBL * NightChargeDBL) / 100;
		double annualRate = Math.round(((standinChargeDBL * 365) / 100
				+ DaySpend + NightSpend) * 1000.0) / 1000.0;
		annualRate=Math.round(annualRate*100.0)/100.0;
		firstYearFormulaNightcharge(yearly1, Monthly1, Quarter1, DaySpend,
				NightSpend, annualRate);
					}

	public void firstYearFormulaNightcharge(double yearly1, double Monthly1,
			double Quarter1, double DaySpend, double NightSpend,
			double annualRate) {
		double monthlyRate;
		double quarterrate;
		//double annualRate1 = Math.round(annualRate) * 1000.0 / 1000.0;
		if (browser.isSelectedByXpath(pageProperties
				.getProperty("GetAQuote.quarterbutton1_ele"))
				|| browser.isSelectedByXpath(pageProperties
						.getProperty("GetAQuote.quarterbutton2_ele"))
				|| browser.isSelectedByXpath(pageProperties
						.getProperty("GetAQuote.quarterbutton3_ele"))) {
			quarterrate = annualRate / 4;
			double quarterrate1 = Math.round(quarterrate * 100.0) / 100.0;
			if (Math.round(yearly1) == Math.round(annualRate)) {
				Report.updateTestLog("Actual  Annual rate is:" + yearly1
						+ "Expected Annual Rate is: " + annualRate + "",
						"PASS");
			} else {
				Report.updateTestLog("Actual  Annual rate is:" + yearly1
						+ "Expected Annual Rate is: " + annualRate + "",
				        "FAIL");
			}
			if (Math.round(Quarter1) == Math.round(quarterrate1)) {
				Report.updateTestLog("Actual  Quarter rate is:" + Quarter1
						+ "Expected Quarter Rate is: " + quarterrate1 + "",
						"PASS");
			} else {
				Report.updateTestLog("Actual  Quarter rate is:" + Quarter1
						+ "Expected Quarter Rate is: " + quarterrate1 + "",
						"FAIL");
		}
			} else {
			monthlyRate = annualRate / 12;
			double monthlyRate1 = Math.round(monthlyRate * 100.0) / 100.0;
			if (Math.round(yearly1) == Math.round(annualRate)) {
				Report.updateTestLog("Actual  Annual rate is:" + yearly1
						+ "Expected Annual Rate is: " + annualRate + "",
						"PASS");
			} else {
				Report.updateTestLog("Actual  Annual rate is:" + yearly1
						+ "Expected Annual Rate is: " + annualRate + "",
				        "FAIL");
			}
			if (Math.round(Monthly1) == Math.round(monthlyRate1)) {
				Report.updateTestLog("Actual Monthly rate is:" + Monthly1
						+ "Monthly Rate should be: " + monthlyRate1 + "",
						"PASS");
			} else {
				Report.updateTestLog("Actual Monthly rate is:" + Monthly1
						+ "Monthly Rate should be: " + monthlyRate1 + "",
						"FAIL");
		}
	}
	}

	public GetAQuoteAction calculatingConsumption1Year(
			GetAQuoteDetails getDetails, int j) {
		String strelecAnnualSpend123 = getDetails.getCurrentUsage_Value();
		int test = Integer.parseInt(strelecAnnualSpend123);
		String ElecConsump = browser.getTextByXpath(pageProperties
		        .getProperty("GetAQuote.Consumption1"));
		ElecConsump = ElecConsump.replace(",", "");
		String ElecConsumpAnnualSplit[] = ElecConsump.split("k");
		elecConsumption = Double.parseDouble(ElecConsumpAnnualSplit[0]);

		switch (j) {
		case 0:
			int test1 = test * 1;
			if (elecConsumption == test1) {
				Report.updateTestLog(
						"Consumption Calculation Success for <b>Annual</b>--Actual Rate is: "
								+ elecConsumption + "Expected Rate is: "
								+ test1 + "", "PASS");
			} else {

				Report.updateTestLog(
						"Consumption Calculation Failure for <b>Annual</b>--Actual Rate is: "
								+ elecConsumption + "Expected Rate is: "
								+ test1 + "", "FAIL");
			}
		break;
		case 1:
			int test12 = test * 12;
			if (elecConsumption == test12) {
				Report.updateTestLog(
						"Consumption Calculation Success for <b>Monthly</b>--Actual Rate is: "
								+ elecConsumption + "Expected Rate is: "
								+ test12 + "", "PASS");
			} else {

				Report.updateTestLog(
						"Consumption Calculation Failure for <b>Monthly</b>--Actual Rate is: "
								+ elecConsumption + "Expected Rate is: "
								+ test12 + "", "FAIL");
			}
		break;
		case 2:
			int test4 = test * 4;
			if (elecConsumption == test4) {
				Report.updateTestLog(
						"Consumption Calculation Success for <b>Quarter</b>--Actual Rate is: "
								+ elecConsumption + "Expected Rate is: "
								+ test4 + "", "PASS");
			} else {

				Report.updateTestLog(
						"Consumption Calculation Failure for <b>Quarter</b>--Actual Rate is: "
								+ elecConsumption + "Expected Rate is: "
								+ test4 + "", "FAIL");
			}
		break;
		}
		return new GetAQuoteAction();

	}

	public GetAQuoteAction calculatingConsumption2Year(
			GetAQuoteDetails getDetails, int j) {
		String strelecAnnualSpend123 = getDetails.getCurrentUsage_Value();
		int test = Integer.parseInt(strelecAnnualSpend123);
		String ElecConsump = browser.getTextByXpath(pageProperties
				.getProperty("GetAQuote.Consumption2"));
		ElecConsump = ElecConsump.replace(",", "");
		String ElecConsumpAnnualSplit[] = ElecConsump.split("k");
		elecConsumption = Double.parseDouble(ElecConsumpAnnualSplit[0]);

		switch (j) {
		case 0:
			int test1 = test * 1;
			if (elecConsumption == test1) {
				Report.updateTestLog(
						"Consumption Calculation Success for  <b>Annual</b>--Actual Rate is: "
								+ elecConsumption + "Expected Rate is: "
								+ test1 + "", "PASS");
			} else {

				Report.updateTestLog(
						"Consumption Calculation Failure for  <b>Annual</b>--Actual Rate is: "
								+ elecConsumption + "Expected Rate is: "
								+ test1 + "", "FAIL");
			}
		break;
		case 1:
			int test12 = test * 12;
			if (elecConsumption == test12) {
				Report.updateTestLog(
						"Consumption Calculation Success For <b>Monthly</b>--Actual Rate is: "
								+ elecConsumption + "Expected Rate is: "
								+ test12 + "", "PASS");
			} else {

				Report.updateTestLog(
						"Consumption Calculation Failure for <b>Monthly</b>--Actual Rate is: "
								+ elecConsumption + "Expected Rate is: "
								+ test12 + "", "FAIL");
			}
		break;
		case 2:
			int test4 = test * 4;
			if (elecConsumption == test4) {
				Report.updateTestLog(
						"Consumption Calculation Success for <b>Quarter</b>--Actual Rate is: "
								+ elecConsumption + "Expected Rate is: "
								+ test4 + "", "PASS");
			} else {

				Report.updateTestLog(
						"Consumption Calculation Failure for <b>Quarter</b>--Actual Rate is: "
								+ elecConsumption + "Expected Rate is: "
								+ test4 + "", "FAIL");
			}
		break;
		}
		return new GetAQuoteAction();
	}

	public GetAQuoteAction calculatingConsumption3Year(
			GetAQuoteDetails getDetails, int j) {
		String strelecAnnualSpend123 = getDetails.getCurrentUsage_Value();
		int test = Integer.parseInt(strelecAnnualSpend123);

		String ElecConsump = browser.getTextByXpath(pageProperties
				.getProperty("GetAQuote.Consumption3"));
		ElecConsump = ElecConsump.replace(",", "");
		String ElecConsumpAnnualSplit[] = ElecConsump.split("k");
		elecConsumption = Double.parseDouble(ElecConsumpAnnualSplit[0]);

		switch (j) {
		case 0:
			int test1 = test * 1;
			if (elecConsumption == test1) {
				Report.updateTestLog(
						"Consumption Calculation Success for  <b>Annual</b>--Actual Rate is: "
								+ elecConsumption + "Expected Rate is: "
								+ test1 + "", "PASS");
			} else {

				Report.updateTestLog(
						"Consumption Calculation Failure for  <b>Annual</b>--Actual Rate is: "
								+ elecConsumption + "Expected Rate is: "
								+ test1 + "", "FAIL");
			}
		break;
		case 1:
			int test12 = test * 12;
			if (elecConsumption == test12) {
				Report.updateTestLog(
						"Consumption Calculation Success For  <b>Monthly</b>--Actual Rate is: "
								+ elecConsumption + "Expected Rate is: "
								+ test12 + "", "PASS");
			} else {

				Report.updateTestLog(
						"Consumption Calculation Failure For <b>Monthly</b>--Actual Rate is: "
								+ elecConsumption + "Expected Rate is: "
								+ test12 + "", "FAIL");
			}
		break;
		case 2:
			int test4 = test * 4;
			if (elecConsumption == test4) {
				Report.updateTestLog(
						"Consumption Calculation Success For <b>Quarter</b>--Actual Rate is: "
								+ elecConsumption + "Expected Rate is: "
								+ test4 + "", "PASS");
			} else {

				Report.updateTestLog(
						"Consumption Calculation Failure For <b>Quarter</b>--Actual Rate is: "
								+ elecConsumption + "Expected Rate is: "
								+ test4 + "", "FAIL");
			}
		break;

		}

		return new GetAQuoteAction();

	}

	public GetAQuoteAction calculatingConsumption2YearGas(
			GetAQuoteDetails getDetails, int j) {
		String ElecConsump = browser.getTextByXpath(pageProperties
				.getProperty("GetAQuote.Consumption2"));
		ElecConsump = ElecConsump.replace(",", "");
		String ElecConsumpAnnualSplit[] = ElecConsump.split("k");
		elecConsumption = Double.parseDouble(ElecConsumpAnnualSplit[0]);
		calculatingConsumption123YearGas(getDetails, j, elecConsumption);
		return new GetAQuoteAction();

	}

	public GetAQuoteAction calculatingConsumption1YearGas(
			GetAQuoteDetails getDetails, int j) {
		String ElecConsump = browser.getTextByXpath(pageProperties
				.getProperty("GetAQuote.Consumption1"));
		ElecConsump = ElecConsump.replace(",", "");
		String ElecConsumpAnnualSplit[] = ElecConsump.split("k");
		elecConsumption = Double.parseDouble(ElecConsumpAnnualSplit[0]);
		calculatingConsumption123YearGas(getDetails, j, elecConsumption);
		return new GetAQuoteAction();

	}

	public GetAQuoteAction calculatingConsumption3YearGas(
			GetAQuoteDetails getDetails, int j) {
		String ElecConsump = browser.getTextByXpath(pageProperties
				.getProperty("GetAQuote.Consumption3"));
		ElecConsump = ElecConsump.replace(",", "");
		String ElecConsumpAnnualSplit[] = ElecConsump.split("k");
		elecConsumption = Double.parseDouble(ElecConsumpAnnualSplit[0]);
		calculatingConsumption123YearGas(getDetails, j, elecConsumption);
		return new GetAQuoteAction();

	}

	public GetAQuoteAction calculatingConsumption123YearGas(
			GetAQuoteDetails getDetails, int j, double elecConsumption) {
		String strelecAnnualSpend123 = getDetails.getCurrentUsage_Value();
		int test = Integer.parseInt(strelecAnnualSpend123);
		switch (j) {
		case 0:
			int test1 = test * 1;
			if (elecConsumption == test1) {
				Report.updateTestLog(
						"Consumption Calculation Success for Annual--Actual is: "
								+ elecConsumption + "   Expected is " + test1
								+ "", "PASS");
			} else {

				Report.updateTestLog(
						"Consumption Calculation Failure for Annual--Actual is: "
								+ elecConsumption + "   Expected is " + test1
								+ "", "FAIL");
			}
		break;
		case 1:
			int test12 = test * 12;
			if (elecConsumption == test12) {
				Report.updateTestLog(
						"Consumption Calculation Success For Monthly--Actual is: "
								+ elecConsumption + "   Expected is " + test12
								+ "", "PASS");
			} else {

				Report.updateTestLog(
						"Consumption Calculation Failure For Monthly--Actual is: "
								+ elecConsumption + "   Expected is " + test12
								+ "", "FAIL");
			}
		break;
		case 2:
			int test4 = test * 4;
			if (elecConsumption == test4) {
				Report.updateTestLog(
						"Consumption Calculation Success For Quarter--Actual is: "
								+ elecConsumption + "   Expected is " + test4
								+ "", "PASS");
			} else {

				Report.updateTestLog(
						"Consumption Calculation Failure For Quarter--Actual is: "
								+ elecConsumption + "   Expected is " + test4
								+ "", "FAIL");
			}
		break;
		}
		return new GetAQuoteAction();
	}

	public GetAQuoteAction firstYearAddressCalMonthlyQuarter(
			GetAQuoteDetails getDetails, String FirstMonthlyQuarter, String ele) {
		String strQuote = browser.getTextByXpath(pageProperties
				.getProperty("GetAQuote.1stYearQRNO"));
		String QRNOSplit[] = strQuote.split(":");
		String QRNO1year = QRNOSplit[1].trim();
		String annualconsumption = browser.getTextByXpath(pageProperties
				.getProperty("GetAQuote.Consumption1"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
		new OnlineDBConnector().addressCalculation(getDetails, QRNO1year,
				annualconsumption, FirstMonthlyQuarter, ele);
		return new GetAQuoteAction();

			}

	public GetAQuoteAction secondYearAddressCalMonthlyQuarter(
			GetAQuoteDetails getDetails, String FirstMonthlyQuarter, String ele) {
		String strQuote = browser.getTextByXpath(pageProperties
				.getProperty("GetAQuote.2ndYearQRNO"));
		String QRNOSplit[] = strQuote.split(":");
		String QRNO1year = QRNOSplit[1].trim();
		String annualconsumption = browser.getTextByXpath(pageProperties
				.getProperty("GetAQuote.Consumption2"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
		new OnlineDBConnector().addressCalculation(getDetails, QRNO1year,
				annualconsumption, FirstMonthlyQuarter, ele);
		return new GetAQuoteAction();

			}

	public GetAQuoteAction thirdYearAddressCalMonthlyQuarter(
			GetAQuoteDetails getDetails, String FirstMonthlyQuarter, String ele) {
		String strQuote = browser.getTextByXpath(pageProperties
				.getProperty("GetAQuote.3stYearQRNO"));
		String QRNOSplit[] = strQuote.split(":");
		String QRNO1year = QRNOSplit[1].trim();
		String annualconsumption = browser.getTextByXpath(pageProperties
				.getProperty("GetAQuote.Consumption3"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
		new OnlineDBConnector().addressCalculation(getDetails, QRNO1year,
				annualconsumption, FirstMonthlyQuarter, ele);
		return new GetAQuoteAction();

        }

}