package bg.framework.app.functional.page.bgb;

import bg.framework.app.functional.action.bgb.GetAQuoteAction;
import bg.framework.app.functional.action.bgb.GetaquoteCombinedEnergyAction;
import bg.framework.app.functional.entities.GetAQuoteDetails;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.services.GetAQuotePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

import java.util.Properties;

public class GetaquoteCombinedEnergyPage extends BasePage {
    
	double elecConsumption;
    
	private final static String FILE_NAME = "resources/bgb/GetAQuote.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME)
			.load();

    public GetaQuoteDetailsPage getclickCombinedEnergyLink() {
		if (browser.isTextPresent(pageProperties
				.getProperty("GetAQuote.ElectricityQuote"))) {
			browser.clickWithLinkText(pageProperties
					.getProperty("GetAQuote.ElectricityQuote"));
            browser.wait(getWaitTime());
			Report.updateTestLog(
					"clicked Electricity quote link at the footer", "PASS");
        } else {
			Report.updateTestLog(
					"Electricity quote linkdoes not exist at the footer",
					"FAIL");
        }
        return new GetaQuoteDetailsPage();
    }

    public GetaQuoteDetailsPage getaquoteClickElecquoteLink() {
		if (browser.isTextPresent(pageProperties
				.getProperty("GetAQuote.ElectricityQuote"))) {
			browser.clickWithLinkText(pageProperties
					.getProperty("GetAQuote.ElectricityQuote"));
            browser.wait(getWaitTime());
			Report.updateTestLog(
					"clicked Electricity quote link at the footer", "PASS");
        } else {
			Report.updateTestLog(
					"Electricity quote linkdoes not exist at the footer",
					"FAIL");
        }
        return new GetaQuoteDetailsPage();
    }

    public GetaQuoteDetailsPage getaquoteClickGasquoteLink() {
		if (browser.isTextPresent(pageProperties
				.getProperty("GetAQuote.GasQuote"))) {
			browser.clickWithLinkText(pageProperties
					.getProperty("GetAQuote.GasQuote"));
            browser.wait(2000);
            Report.updateTestLog("clicked Gas quote link at the footer", "PASS");
        } else {
			Report.updateTestLog("Gas quote link does not exist at the footer",
					"FAIL");
        }
        return new GetaQuoteDetailsPage();
    }

    public GetaQuoteDetailsPage getaquoteClickDualquoteLink() {
		if (browser.isTextPresent(pageProperties
				.getProperty("GetAQuote.DualFuelQuote"))) {
			browser.clickWithLinkText(pageProperties
					.getProperty("GetAQuote.DualFuelQuote"));
            browser.wait(getWaitTime());
			Report.updateTestLog("clicked Dual quote link at the footer",
					"PASS");
        } else {
			Report.updateTestLog(
					"Dual quote link does not exist at the footer", "FAIL");
        }
        return new GetaQuoteDetailsPage();
    }

	public GetaQuoteDetailsPage getaquoteClickCompinedLink() {
		browser.wait(5000);
		verifyAndClickWithXpath(pageProperties.getProperty("Dual.DualLink"),
				"Dual Link Clicked");
         return new GetaQuoteDetailsPage();
	}

	public GetAQuoteAction enterGetaQuoteDetails(GetAQuoteDetails getDetails) {

		browser.wait(getWaitTime());
		if (browser.isElementVisible(pageProperties.getProperty("Dual.Title"))) {
			browser.wait(getWaitTime());
			browser.selectfromDropBox("id",
					pageProperties.getProperty("Dual.Title"),
					getDetails.getTitle());
			Report.updateTestLog("Title field exist and value got entered",
					"PASS");
		} else {
			Report.updateTestLog(
					"Title field does not exist & value not  entered", "FAIL");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.Firstname"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQuote.Firstname"),
			        getDetails.getFirstName());
			Report.updateTestLog(
					"First Name field exist and value got entered", "PASS");
		} else {
			Report.updateTestLog(
					"First Name  field does not exist & value not  entered",
			        "FAIL");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.Surname"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQuote.Surname"),
			        getDetails.getLastName());
			Report.updateTestLog("Surname field exist and value got entered",
					"PASS");
		} else {
			Report.updateTestLog(
					"Surname  field does not exist & value not  entered",
			        "FAIL");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.Businessname"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQuote.Businessname"),
			        getDetails.getbusinessname());
			Report.updateTestLog(
					"Businessname field exist and value got entered: "+getDetails.getbusinessname(), "PASS");
		} else {
			Report.updateTestLog(
					"Businessname  field does not exist & value not  entered: "+getDetails.getbusinessname(),
					"FAIL");
		}
		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.Telephonenumber"))) {
			browser.wait(getWaitTime());
			browser.input(
					pageProperties.getProperty("GetAQuote.Telephonenumber"),
			        getDetails.gettelephone());
			Report.updateTestLog("Telephone field exist and value got entered "+getDetails.gettelephone(),
					"PASS");
		} else {
			Report.updateTestLog(
					"Telephone field does not exist & value not  entered "+getDetails.gettelephone(),
			        "FAIL");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.Email"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQuote.Email"),
			        getDetails.getEmail());
			Report.updateTestLog("Email field exist and value got entered",
					"PASS");
		} else {
			Report.updateTestLog(
					"Email field does not exist & value not  entered", "FAIL");
		}
		return new GetAQuoteAction();

	}

	public GetAQuoteAction enterElectricityAddressAndUsage(
			GetAQuoteDetails getDetails) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		browser.wait(getWaitTime());
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.Postcode"))) {

			browser.input(pageProperties.getProperty("GetAQuote.Postcode"),
			        getDetails.getPostcode());

			Report.updateTestLog("Pastcode field exist and value got entered",
					"PASS");
		} else {
			Report.updateTestLog(
					"Postcode field does not exist & value not  entered",
			        "FAIL");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.FindAdress"))) {
			browser.wait(getWaitTime());
			browser.wait(10000);
			browser.click(pageProperties.getProperty("GetAQuote.FindAdress"));
			Report.updateTestLog(
					"Find Address Button exist and value got entered", "PASS");
		} else {
			Report.updateTestLog(
					"Find address field does not exist & value not  entered",
					"FAIL");
		}
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Dual.EleAddressID"))) {

			browser.wait(getWaitTime());
			browser.click(pageProperties
					.getProperty("Dual.EleAddressID"));
			Report.updateTestLog("Address ID has been selected from the list",
					"PASS");
		} else {
			Report.updateTestLog("Address id does not exist", "FAIL");
		}
		return new GetAQuoteAction();

	}

	public GetAQuoteAction enterSupplycodeMannualyElectricity(
			GetAQuoteDetails getDetails) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		browser.wait(getWaitTime());
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.Postcode"))) {

			browser.input(pageProperties.getProperty("GetAQuote.Postcode"),
			        getDetails.getPostcode());

			Report.updateTestLog("Pastcode field exist and value got entered",
					"PASS");
		} else {
			Report.updateTestLog(
					"Postcode field does not exist & value not  entered",
			        "FAIL");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.FindAdress"))) {
			browser.wait(getWaitTime());
			browser.click(pageProperties.getProperty("GetAQuote.FindAdress"));
			Report.updateTestLog(
					"Find Address Button exist and value got entered", "PASS");
		} else {
			Report.updateTestLog(
					"Find address field does not exist & value not  entered",
					"FAIL");
		}
		try {
			Thread.sleep(35000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (browser.isTextPresent(pageProperties
		        .getProperty("GetAQuote.SupplyDetails"))) {

			browser.wait(getWaitTime());
			browser.clickWithLinkText(pageProperties
					.getProperty("GetAQuote.SupplyDetails"));
			Report.updateTestLog(
					"Enter supply details manually successfully selected",
					"PASS");
		} else {
			Report.updateTestLog(
					"Enter supply details manually does not exist", "FAIL");
		}
		return new GetAQuoteAction();
	}

	public GetAQuoteAction enterSupplycodeMannualyGas(
			GetAQuoteDetails getDetails) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		browser.wait(getWaitTime());
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.gasPostCode"))) {
			browser.input(pageProperties.getProperty("GetAQuote.gasPostCode"),
			        getDetails.getPostcode());
			Report.updateTestLog("Pastcode field exist and value got entered",
					"PASS");
		} else {
			Report.updateTestLog(
					"Postcode field does not exist & value not  entered",
			        "FAIL");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.GasFindAdress"))) {
			browser.wait(getWaitTime());
			browser.wait(10000);
			browser.click(pageProperties.getProperty("GetAQuote.GasFindAdress"));
			Report.updateTestLog(
					"Find Address Button exist and value got entered", "PASS");
		} else {
			Report.updateTestLog(
					"Find address field does not exist & value not  entered",
					"FAIL");
		}
		if (browser.isTextPresent(pageProperties
		        .getProperty("GetAQuote.SupplyDetails"))) {

			browser.wait(getWaitTime());
			browser.clickWithLinkText(pageProperties
					.getProperty("GetAQuote.SupplyDetails"));
			Report.updateTestLog(
					"Enter supply details manually successfully selected",
					"PASS");
		} else {
			Report.updateTestLog(
					"Enter supply details manually does not exist", "FAIL");
		}
		return new GetAQuoteAction();

	}

	public GetAQuoteAction elecSupplyDetailsManuall(GetAQuoteDetails getDetails) {

		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQUote.mpan1"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQUote.mpan1"),
			        getDetails.getSupplyNumber1());
			Report.updateTestLog(
					"SupplyNumber1 field exist and value got entered", "PASS");
		} else {
			Report.updateTestLog(
					"SupplyNumber1 field does not exist & value not  entered",
					"FAIL");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQUote.mpan2"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQUote.mpan2"),
			        getDetails.getSupplyNumber2());
			Report.updateTestLog(
					"SupplyNumber2 field exist and value got entered", "PASS");
		} else {
			Report.updateTestLog(
					"SupplyNumber2 field does not exist & value not  entered",
					"FAIL");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQUote.mpan3"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQUote.mpan3"),
			        getDetails.getSupplyNumber3());
			Report.updateTestLog(
					"SupplyNumber3 field exist and value got entered", "PASS");
		} else {
			Report.updateTestLog(
					"SupplyNumber3 field does not exist & value not  entered",
					"FAIL");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQUote.mpan4"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQUote.mpan4"),
			        getDetails.getSupplyNumber4());
			Report.updateTestLog(
					"SupplyNumber4 field exist and value got entered", "PASS");
		} else {
			Report.updateTestLog(
					"SupplyNumber4 field does not exist & value not  entered",
					"FAIL");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQUote.mpan5"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQUote.mpan5"),
			        getDetails.getSupplyNumber5());
			Report.updateTestLog(
					"SupplyNumber5 field exist and value got entered", "PASS");
		} else {
			Report.updateTestLog(
					"SupplyNumber5 field does not exist & value not  entered",
					"FAIL");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQUote.mpan6"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQUote.mpan6"),
			        getDetails.getSupplyNumber6());
			Report.updateTestLog(
					"SupplyNumber6 field exist and value got entered", "PASS");
		} else {
			Report.updateTestLog(
					"SupplyNumber6 field does not exist & value not  entered",
					"FAIL");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQUote.mpan7"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQUote.mpan7"),
			        getDetails.getSupplyNumber7());
			Report.updateTestLog(
					"SupplyNumber7 field exist and value got entered", "PASS");
		} else {
			Report.updateTestLog(
					"SupplyNumber7 field does not exist & value not  entered",
					"FAIL");
		}
		return new GetAQuoteAction();
	}

	public GetaquoteCombinedEnergyAction click1stYearTabDual(
			GetAQuoteDetails getDetails) {
		browser.wait(3000);
		verifyAndClickWithXpath(
				pageProperties.getProperty("Dual.1stYearTabDual"),
				"<B>First Year Tab Dual</B>");
		return new GetaquoteCombinedEnergyAction();
	}

	public GetaquoteCombinedEnergyAction click2ndYearTabDual(
			GetAQuoteDetails getDetails) {
		browser.wait(3000);
		verifyAndClickWithXpath(
				pageProperties.getProperty("Dual.2ndYearTabDual"),
				"<B>Second Year Tab Dual</B>");
		return new GetaquoteCombinedEnergyAction();
	}
	
	public GetaquoteCombinedEnergyAction click3rdYearTabDual(
			GetAQuoteDetails getDetails) {
		browser.wait(3000);
		verifyAndClickWithXpath(
				pageProperties.getProperty("Dual.3rdYearTabDual"),
				"<B>Third Year Tab Dual</B>");
		return new GetaquoteCombinedEnergyAction();
	}
	
	public GetaquoteCombinedEnergyAction clickCompreTabDual(
			GetAQuoteDetails getDetails) {
		browser.wait(3000);
		verifyAndClickWithXpath(
				pageProperties.getProperty("Dual.compareAllTabDual"),
				"<B>Compare Tab Dual</B>");
		return new GetaquoteCombinedEnergyAction();
	}
	
	public GetaquoteCombinedEnergyAction clickCompareTabDualQuarter(
			GetAQuoteDetails getDetails) {
		browser.wait(3000);
		verifyAndClickWithXpath(
				pageProperties.getProperty("Dual.compareAllTabDual"),
				"<B>CompareTab Dual</B>");
		verifyAndClickWithXpath(
				pageProperties.getProperty("Dual.compareAllTabQuarter"),
				"<B>Click Quarterly Option Button COmpare All tab</B>");
		return new GetaquoteCombinedEnergyAction();
	}
	
	public GetaquoteCombinedEnergyAction click3rdYearTabDualQuarter(
			GetAQuoteDetails getDetails) {
		browser.wait(3000);
		verifyAndClickWithXpath(
				pageProperties.getProperty("Dual.3rdYearTabDual"),
				"<B>Third Year Tab Dual</B>");
		verifyAndClickWithXpath(
				pageProperties.getProperty("Dual.3rdYearQuarterOption"),
				"<B>Click Quarterly Option Button in 3rd year</B>");
		return new GetaquoteCombinedEnergyAction();
	}
	
	public void validateSecondYearContractQuarter(GetAQuoteDetails getDetails) {
		verifyAndClickWithXpath(
				pageProperties.getProperty("Dual.2ndYearTabDual"),
				"<B>Second Year Contract.</B>");
		verifyAndClickWithXpath(pageProperties.getProperty("GetAQuote.quarterbutton2_ele"),
				"<B>Quarter Option Clicked in 2nd Year.</B>");
	}

	public void updateSupplypointValues(int i) {
		String SupplyNumber1;
		String SupplyNumber2;
		String SupplyNumber3;
		String SupplyNumber4;
		String SupplyNumber5;
		String SupplyNumber6;
		String SupplyNumber7;
		switch (i) {
		case 1:
			Report.updateTestLog("<b>Profile Class :  01</b>", "DONE");
			SupplyNumber1 = "01";
			SupplyNumber2 = "500";
			SupplyNumber3 = "100";
			SupplyNumber4 = "23";
			SupplyNumber5 = "6090";
			SupplyNumber6 = "3179";
			SupplyNumber7 = "112";
			elecSupplyDetailsManuallPrice(SupplyNumber1, SupplyNumber2,
					SupplyNumber3, SupplyNumber4, SupplyNumber5, SupplyNumber6,
					SupplyNumber7);
			break;
		case 2:
			Report.updateTestLog("<b>Profile Class :  02</b>", "DONE");
			SupplyNumber1 = "02";
			SupplyNumber2 = "807";
			SupplyNumber3 = "007";
			SupplyNumber4 = "10";
			SupplyNumber5 = "1290";
			SupplyNumber6 = "5804";
			SupplyNumber7 = "624";
			elecSupplyDetailsManuallPrice(SupplyNumber1, SupplyNumber2,
					SupplyNumber3, SupplyNumber4, SupplyNumber5, SupplyNumber6,
					SupplyNumber7);
			break;
		case 3:
			Report.updateTestLog("<b>Profile Class :  03</b>", "DONE");
			SupplyNumber1 = "03";
			SupplyNumber2 = "801";
			SupplyNumber3 = "126";
			SupplyNumber4 = "20";
			SupplyNumber5 = "0000";
			SupplyNumber6 = "3717";
			SupplyNumber7 = "196";
			elecSupplyDetailsManuallPrice(SupplyNumber1, SupplyNumber2,
					SupplyNumber3, SupplyNumber4, SupplyNumber5, SupplyNumber6,
					SupplyNumber7);
			break;
		case 4:
			Report.updateTestLog("<b>Profile Class :  04</b>", "DONE");
			SupplyNumber1 = "04";
			SupplyNumber2 = "807";
			SupplyNumber3 = "242";
			SupplyNumber4 = "10";
			SupplyNumber5 = "1236";
			SupplyNumber6 = "8756";
			SupplyNumber7 = "693";
			elecSupplyDetailsManuallPrice(SupplyNumber1, SupplyNumber2,
					SupplyNumber3, SupplyNumber4, SupplyNumber5, SupplyNumber6,
					SupplyNumber7);
			break;
		case 5:
			Report.updateTestLog("<b>Profile Class :  05</b>", "DONE");
			SupplyNumber1 = "05";
			SupplyNumber2 = "801";
			SupplyNumber3 = "250";
			SupplyNumber4 = "10";
			SupplyNumber5 = "1456";
			SupplyNumber6 = "9927";
			SupplyNumber7 = "760";
			elecSupplyDetailsManuallPrice(SupplyNumber1, SupplyNumber2,
					SupplyNumber3, SupplyNumber4, SupplyNumber5, SupplyNumber6,
					SupplyNumber7);
			break;
		case 6:
			Report.updateTestLog("<b>Profile Class :  06</b>", "DONE");
			SupplyNumber1 = "06";
			SupplyNumber2 = "817";
			SupplyNumber3 = "081";
			SupplyNumber4 = "11";
			SupplyNumber5 = "0003";
			SupplyNumber6 = "9241";
			SupplyNumber7 = "568";
			elecSupplyDetailsManuallPrice(SupplyNumber1, SupplyNumber2,
					SupplyNumber3, SupplyNumber4, SupplyNumber5, SupplyNumber6,
					SupplyNumber7);
			break;
		case 7:
			Report.updateTestLog("<b>Profile Class :  07</b>", "DONE");
			SupplyNumber1 = "07";
			SupplyNumber2 = "816";
			SupplyNumber3 = "081";
			SupplyNumber4 = "11";
			SupplyNumber5 = "0003";
			SupplyNumber6 = "9206";
			SupplyNumber7 = "670";
			elecSupplyDetailsManuallPrice(SupplyNumber1, SupplyNumber2,
					SupplyNumber3, SupplyNumber4, SupplyNumber5, SupplyNumber6,
					SupplyNumber7);
			break;
		case 8:
			Report.updateTestLog("<b>Profile Class :  08</b>", "DONE");
			SupplyNumber1 = "08";
			SupplyNumber2 = "811";
			SupplyNumber3 = "021";
			SupplyNumber4 = "14";
			SupplyNumber5 = "2908";
			SupplyNumber6 = "5000";
			SupplyNumber7 = "003";
			elecSupplyDetailsManuallPrice(SupplyNumber1, SupplyNumber2,
					SupplyNumber3, SupplyNumber4, SupplyNumber5, SupplyNumber6,
					SupplyNumber7);
			break;
		}

	}

	public GetAQuoteAction elecSupplyDetailsManuallPrice(String PC, String MTC,
			String LLF, String PES, String MeterPoint_1, String MeterPoint_2,
			String Checkdigit) {

		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQUote.mpan1"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQUote.mpan1"), PC);
			Report.updateTestLog(
					"SupplyNumber1 field exist and value got entered:  " + PC,
			        "PASS");
		} else {
			Report.updateTestLog(
					"SupplyNumber1 field does not exist & value not  entered:  "
							+ PC, "FAIL");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQUote.mpan2"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQUote.mpan2"), MTC);
			Report.updateTestLog(
					"SupplyNumber2 field exist and value got entered:  " + MTC,
			        "PASS");
		} else {
			Report.updateTestLog(
					"SupplyNumber2 field does not exist & value not  entered:  "
							+ MTC, "FAIL");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQUote.mpan3"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQUote.mpan3"), LLF);
			Report.updateTestLog(
					"SupplyNumber3 field exist and value got entered: " + LLF,
			        "PASS");
		} else {
			Report.updateTestLog(
					"SupplyNumber3 field does not exist & value not  entered: "
							+ LLF, "FAIL");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQUote.mpan4"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQUote.mpan4"), PES);
			Report.updateTestLog(
					"SupplyNumber4 field exist and value got entered: " + PES,
			        "PASS");
		} else {
			Report.updateTestLog(
					"SupplyNumber4 field does not exist & value not  entered: "
							+ PES, "FAIL");
		}

		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQUote.mpan5"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQUote.mpan5"),
					MeterPoint_1);
			Report.updateTestLog(
					"SupplyNumber5 field exist and value got entered: "
							+ MeterPoint_1, "PASS");
		} else {
			Report.updateTestLog(
					"SupplyNumber5 field does not exist & value not  entered: "
							+ MeterPoint_1, "FAIL");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQUote.mpan6"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQUote.mpan6"),
					MeterPoint_2);
			Report.updateTestLog(
					"SupplyNumber6 field exist and value got entered: "
							+ MeterPoint_2, "PASS");
		} else {
			Report.updateTestLog(
					"SupplyNumber6 field does not exist & value not  entered: "
							+ MeterPoint_2, "FAIL");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQUote.mpan7"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQUote.mpan7"),
					Checkdigit);
			Report.updateTestLog(
					"SupplyNumber7 field exist and value got entered: "
							+ Checkdigit, "PASS");
		} else {
			Report.updateTestLog(
					"SupplyNumber7 field does not exist & value not  entered: "
							+ Checkdigit, "FAIL");
		}
		return new GetAQuoteAction();
	}
		
	public GetAQuoteAction gascSupplyDetailsManually(GetAQuoteDetails getDetails) {
			browser.wait(getWaitTime());
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.gasPostCode"))) {

			browser.input(pageProperties.getProperty("GetAQuote.gasPostCode"),
					getDetails.getPostcode());

			Report.updateTestLog("Pastcode field exist and value got entered",
			        "PASS");
		} else {
			Report.updateTestLog(
					"Postcode field does not exist & value not  entered",
					"FAIL");
		}
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
	}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.GasFindAdress"))) {
			browser.wait(getWaitTime());
	
			browser.click(pageProperties.getProperty("GetAQuote.GasFindAdress"));
			Report.updateTestLog(
					"Find Address Button exist and value got entered", "PASS");
		} else {
			Report.updateTestLog(
					"Find address field does not exist & value not  entered",
					"FAIL");
		}
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        verifyAndClickWithXpath(pageProperties.getProperty("Dual.gasAddress"),"Enter Gas meter");
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.gasmeterRefnumber"))) {
		browser.wait(getWaitTime());
			browser.input(
					pageProperties.getProperty("GetAQuote.gasmeterRefnumber"),
					getDetails.getgasmeterRefnumber());
			Report.updateTestLog(
					"SupplyNumber1 field exist and value got entered", "PASS");
		} else {
			Report.updateTestLog(
					"SupplyNumber1 field does not exist & value not  entered",
					"FAIL");
		}
		return new GetAQuoteAction();
	}

	public GetAQuoteAction enterConsumptionForEle(GetAQuoteDetails getDetails,
			int i) {
		String spend[] = { "Annually", "Monthly", "Quarterly" };
			browser.wait(getWaitTime());
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.ElectricityUsage"))) {
			browser.wait(getWaitTime());
			browser.selectfromDropBox("id",
					pageProperties.getProperty("GetAQuote.ElectricityUsage"),
					spend[i]);
			Report.updateTestLog("Consumption got selected", "PASS");
		} else {

			Report.updateTestLog("Consumption Not selected", "FAIL");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Dual.EnterConsumptionEle"))) {
			browser.wait(getWaitTime());
			browser.input(
					pageProperties.getProperty("Dual.EnterConsumptionEle"),
			        getDetails.getCurrentUsage_Value());
			Report.updateTestLog(
					"First Name field exist and value got entered", "PASS");
		} else {
			Report.updateTestLog(
					"First Name  field does not exist & value not  entered",
			        "FAIL");
		}
		return new GetAQuoteAction();

	}

	public GetAQuoteAction enterGasAddressAndUsage(GetAQuoteDetails getDetails) {
		browser.wait(getWaitTime());
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.gasPostCode"))) {
			browser.input(pageProperties.getProperty("GetAQuote.gasPostCode"),
					getDetails.getPostcode());
			Report.updateTestLog("Pastcode field exist and value got entered",
					"PASS");
		} else {
			Report.updateTestLog(
					"Postcode field does not exist & value not  entered",
					"FAIL");
		}
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.GasFindAdress"))) {
		browser.wait(getWaitTime());
			
			browser.click(pageProperties.getProperty("GetAQuote.GasFindAdress"));
			Report.updateTestLog(
					"Find Address Button exist and value got entered", "PASS");
		} else {
			Report.updateTestLog(
					"Find address field does not exist & value not  entered",
					"FAIL");
		}
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("Dual.GasAddressID"))) {
			browser.wait(getWaitTime());
			browser.click(pageProperties
					.getProperty("Dual.GasAddressID"));
			Report.updateTestLog("Address ID has been selected from the list",
					"PASS");
		} else {
			Report.updateTestLog("Address id does not exist", "FAIL");
		}
		return new GetAQuoteAction();

	}

	public GetAQuoteAction enterConsumptionForGas(GetAQuoteDetails getDetails,
			int i) {
		String spend[] = { "Annually", "Monthly", "Quarterly" };
		browser.wait(getWaitTime());
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.GasUsage"))) {
			browser.wait(getWaitTime());
			browser.selectfromDropBox("id",
					pageProperties.getProperty("GetAQuote.GasUsage"), spend[i]);
			Report.updateTestLog("Title field exist and value got entered",
					"PASS");
		} else {
			Report.updateTestLog(
					"Title field does not exist & value not  entered", "FAIL");
		}
		if (browser.isElementVisible(pageProperties
				.getProperty("GetAQuote.GasValue"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQuote.GasValue"),
					getDetails.getCurrentUsage_Value());
			Report.updateTestLog(
					"First Name field exist and value got entered", "PASS");
		} else {
			Report.updateTestLog(
					"First Name  field does not exist & value not  entered",
			        "FAIL");
		}
		return new GetAQuoteAction();

	}

	public GetAQuoteAction calculateQuoteForElec() {
		if (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("GetAQuote.DualCalculateQuote"))) {
			browser.clickWithXpath(pageProperties
					.getProperty("GetAQuote.DualCalculateQuote"));
			browser.wait(getWaitTime());
			Report.updateTestLog("CalculateQuote image  exist", "PASS");
		} else {
			Report.updateTestLog("CalculateQuote image does not exist", "FAIL");
		}
		return new GetAQuoteAction();
	}

	public GetAQuoteAction firstYearTextVerify(GetAQuoteDetails getDetails) {
		String header = browser.getTextByXpath(pageProperties
				.getProperty("Dual.FirstYearHeading"));
		if (header.trim().equals("1-year contract combined energy quote")) {
			Report.updateTestLog(
					"Expected Text is available in the 1st Year Page" + header,
			        "PASS");
		} else {
			Report.updateTestLog(
					"Expected Text is not available in the 1st Year Page"
							+ header, "FAIL");
		}
		String businessname1 = browser.getTextByXpath(pageProperties
				.getProperty("Dual.BussinessName"));
		String businessname2 = getDetails.getbusinessname();
		if (businessname1.trim().equals(businessname2)) {
			Report.updateTestLog(
					"Expected Business name is available in the 1st Year Page"
							+ businessname1, "PASS");
		} else {
			Report.updateTestLog(
					"Expected Business name is not available in the 1st Year Page"
							+ businessname1, "FAIL");
		}
		String howiscal = browser.getTextByXpath(pageProperties
				.getProperty("Dual.Howiscalculated"));
		if (howiscal.trim().equals("How this is Calculated:")) {
			Report.updateTestLog(
					"Expected Text is available in the 1st Year Page"
							+ howiscal, "PASS");
		} else {
			Report.updateTestLog(
					"Expected Text is not available in the 1st Year Page"
							+ howiscal, "FAIL");
		}
		String charges = browser.getTextByXpath(pageProperties
				.getProperty("Dual.Charges"));
		if (charges.trim().equals("Charges")) {
			Report.updateTestLog(
					"Expected Text is available in the 1st Year Page" + charges,
					"PASS");
		} else {
			Report.updateTestLog(
					"Expected Text is not available in the 1st Year Page"
							+ charges, "FAIL");
		}
		String electricity = browser.getTextByXpath(pageProperties
				.getProperty("Dual.Eelectricity"));
		if (electricity.trim().equals("Electricity")) {
			Report.updateTestLog(
					"Expected Text is available in the 1st Year Page"
							+ electricity, "PASS");
		} else {
			Report.updateTestLog(
					"Expected Text is not available in the 1st Year Page"
							+ electricity, "FAIL");
		}
		String gas = browser.getTextByXpath(pageProperties
				.getProperty("Dual.Gas"));
		if (gas.trim().equals("Gas")) {
			Report.updateTestLog(
					"Expected Text is available in the 1st Year Page" + gas,
					"PASS");
		} else {
			Report.updateTestLog(
					"Expected Text is not available in the 1st Year Page" + gas,
					"FAIL");
		}
		String DayUnitChargeText = browser.getTextByXpath(pageProperties
				.getProperty("Dual.DayUnitChargeText"));
		if (DayUnitChargeText.trim().equals("Day Unit Charge")) {
			Report.updateTestLog(
					"Expected Text is available in the 1st Year Page"
							+ DayUnitChargeText, "PASS");
		} else {
			Report.updateTestLog(
					"Expected Text is not available in the 1st Year Page"
							+ DayUnitChargeText, "FAIL");
		}
		String NightUnitChargeText = browser.getTextByXpath(pageProperties
				.getProperty("Dual.NightUnitChargeText"));
		if (NightUnitChargeText.trim().equals("Night Unit Charge")) {
			Report.updateTestLog(
					"Expected Text is available in the 1st Year Page"
							+ NightUnitChargeText, "PASS");
		} else {
			Report.updateTestLog(
					"Expected Text is not available in the 1st Year Page"
							+ NightUnitChargeText, "FAIL");
		}
		String StandingChargeText = browser.getTextByXpath(pageProperties
				.getProperty("Dual.StandingChargeText"));
		if (StandingChargeText.trim().equals("Standing Charge")) {
			Report.updateTestLog(
					"Expected Text is available in the 1st Year Page"
							+ StandingChargeText, "PASS");
		} else {
			Report.updateTestLog(
					"Expected Text is not available in the 1st Year Page"
							+ StandingChargeText, "FAIL");
		}
		String ConsumptionTextEle = browser.getTextByXpath(pageProperties
				.getProperty("Dual.ConsumptionTextEle"));
		if (ConsumptionTextEle.trim().contains(
				"Quote based on annual electricity consumption of")) {
			Report.updateTestLog(
					"Expected Text is available in the 1st Year Page"
							+ ConsumptionTextEle, "PASS");
		} else {
			Report.updateTestLog(
					"Expected Text is not available in the 1st Year Page"
							+ ConsumptionTextEle, "FAIL");
		}
		String ConsumptionTextGas = browser.getTextByXpath(pageProperties
				.getProperty("Dual.ConsumptionTextGas"));
		if (ConsumptionTextGas.trim().contains(
				"Quote based on annual gas consumption of")) {
			Report.updateTestLog(
					"Expected Text is available in the 1st Year Page"
							+ ConsumptionTextGas, "PASS");
		} else {
			Report.updateTestLog(
					"Expected Text is not available in the 1st Year Page"
							+ ConsumptionTextGas, "FAIL");
		}
		return new GetAQuoteAction();
	}
		
	public GetAQuoteAction firstYearAddressCalMonthlyQuarter(
			GetAQuoteDetails getDetails, String FirstMonthlyQuarter, String Dual) {
		String strQuote = browser.getTextByXpath(pageProperties
				.getProperty("Dual.QRno"));
		String QRNOSplit[] = strQuote.split(":");
		String QRNO1year = QRNOSplit[1].trim();
		String annualconsumption = browser.getTextByXpath(pageProperties
				.getProperty("Dual.ConsumptionEle"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
		new OnlineDBConnector().addressCalculation(getDetails, QRNO1year,
				annualconsumption, FirstMonthlyQuarter, Dual);
		return new GetAQuoteAction();
	}
			
	public GetAQuoteAction firstYearCalculationForGasEle(GetAQuoteDetails getDetails, String FirstMonthly) {
		String strQuote = browser.getTextByXpath(pageProperties
				.getProperty("Dual.QRno"));
		String QRNOSplit[] = strQuote.split(":");
		String QRNO1year = QRNOSplit[1].trim();
		String annualconsumption = browser.getTextByXpath(pageProperties
				.getProperty("Dual.ConsumptionEle"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
		new OnlineDBConnector().findProfileClass(getDetails, QRNO1year, FirstMonthly);
		return new GetAQuoteAction();
	}

	public GetAQuoteAction secondYearAddressCalMonthlyQuarter(
			GetAQuoteDetails getDetails, String FirstMonthlyQuarter, String Dual) {
		String strQuote = browser.getTextByXpath(pageProperties
				.getProperty("Dual.QrnNo2ndTab"));
		String QRNOSplit[] = strQuote.split(":");
		String QRNO1year = QRNOSplit[1].trim();
		String annualconsumption = browser.getTextByXpath(pageProperties
				.getProperty("Dual.consumption2ndYearEle"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
		new OnlineDBConnector().addressCalculation(getDetails, QRNO1year,
				annualconsumption, FirstMonthlyQuarter, Dual);
		return new GetAQuoteAction();
	}
	
	public GetAQuoteAction secondYearcalculationForGasEle(GetAQuoteDetails getDetails, String FirstMonthly) {
		String strQuote = browser.getTextByXpath(pageProperties
				.getProperty("Dual.QrnNo2ndTab"));
		String QRNOSplit[] = strQuote.split(":");
		String QRNO1year = QRNOSplit[1].trim();
		String annualconsumption = browser.getTextByXpath(pageProperties
				.getProperty("Dual.ConsumptionEle"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
		new OnlineDBConnector().findProfileClass(getDetails, QRNO1year, FirstMonthly);
		return new GetAQuoteAction();
	}
	
	public GetAQuoteAction thirdYearAddressCalMonthlyQuarter(
			GetAQuoteDetails getDetails, String FirstMonthlyQuarter, String Dual) {
		String strQuote = browser.getTextByXpath(pageProperties
				.getProperty("Dual.QrnNo3rdTab"));
		String QRNOSplit[] = strQuote.split(":");
		String QRNO1year = QRNOSplit[1].trim();
		String annualconsumption = browser.getTextByXpath(pageProperties
				.getProperty("Dual.consumption3rdYearEle"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
		new OnlineDBConnector().addressCalculation(getDetails, QRNO1year,
				annualconsumption, FirstMonthlyQuarter, Dual);
		return new GetAQuoteAction();

	}
	
	public GetAQuoteAction thirdYearcalculationForGasEle(GetAQuoteDetails getDetails, String FirstMonthly) {
		String strQuote = browser.getTextByXpath(pageProperties
				.getProperty("Dual.QrnNo3rdTab"));
		String QRNOSplit[] = strQuote.split(":");
		String QRNO1year = QRNOSplit[1].trim();
		String annualconsumption = browser.getTextByXpath(pageProperties
				.getProperty("Dual.ConsumptionEle"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
		new OnlineDBConnector().findProfileClass(getDetails, QRNO1year, FirstMonthly);
		return new GetAQuoteAction();
	}
	
	public void firstYearDual(String profileClass, GetAQuoteDetails getDetails) {
		int pc=Integer.parseInt(profileClass);
		switch(pc)
		{
			case 1:
				firstYearCalculationDualProfileClass0103And05(getDetails);
				break;
			case 2:
				firstYearCalculationDualProfileClass02and04(getDetails);
				break;
			case 3:
				firstYearCalculationDualProfileClass0103And05(getDetails);
				break;
			case 4:
				firstYearCalculationDualProfileClass02and04(getDetails);
				break;
			case 5:
				firstYearCalculationDualProfileClass0103And05(getDetails);
				break;	
			case 6:
				firstYearCalculationDualProfileClass06(getDetails);
				break;
			case 7:
				firstYearCalculationDualProfileClass07(getDetails);
				break;
			case 8:
				firstYearCalculationDualProfileClass08(getDetails);
				break;
		}

	}
	
	public GetAQuoteAction firstYearCalculationDualProfileClass0103And05(GetAQuoteDetails getDetails) {
		
		//ELE
		String unitCharge = browser.getTextByXpath(pageProperties
				.getProperty("Dual.DayUnitChargeEle"));
		unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
		double UnitchargeEle = Double.valueOf(unitCharge);
		String standingCharge = browser.getTextByXpath(pageProperties
				.getProperty("Dual.StandingChargeEle"));
		standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
		double StandingChargeEle = Double.valueOf(standingCharge);
		String annualconsumption = browser
				.getTextByXpath(pageProperties
						.getProperty("Dual.ConsumptionEle"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]",	"");
		double annualconsumptionEle = Double.valueOf(annualconsumption);
		
		double annualRateEle =(StandingChargeEle * 365) / 100+ (annualconsumptionEle * (UnitchargeEle)) / 100;
		annualRateEle=Math.round(annualRateEle*100.0)/100.0;
		//GAS
		String unitChargeGas = browser.getTextByXpath(pageProperties
				.getProperty("Dual.DayUnitChargeGas"));
		unitChargeGas = unitChargeGas.replaceAll("[^\\d(?!.)]", "");
		double unitchargeGas = Double.valueOf(unitChargeGas);
		String standingChargeGas = browser.getTextByXpath(pageProperties
				.getProperty("Dual.StandingChargeGas"));
		standingChargeGas = standingChargeGas.replaceAll("[^\\d(?!.)]", "");
		double StandingCharge = Double.valueOf(standingChargeGas);
		String annualconsumptionGas = browser.getTextByXpath(pageProperties
				.getProperty("Dual.ConsumptionGas"));
		annualconsumptionGas = annualconsumptionGas.replaceAll("[^\\d(?!.)]", "");
		double annualConsumptionGas = Double.valueOf(annualconsumptionGas);
		double annualRateGas =(StandingCharge * 365) / 100+ (annualConsumptionGas * (unitchargeGas)) / 100;
		annualRateGas=Math.round(annualRateGas*100.0)/100.0;
		String yearly = browser.getTextByXpath(pageProperties
				.getProperty("Dual.Annually"));
		yearly = yearly.replaceAll("[^\\d(?!.)]", "");
		double annualEleGas = Double.valueOf(yearly);
		double annualGasEle=annualRateEle + annualRateGas;
		String monthly = browser.getTextByXpath(pageProperties
				.getProperty("Dual.Month"));
		monthly = monthly.replaceAll("[^\\d(?!.)]", "");
		double monthly1 = Double.valueOf(monthly);
		double Quarter1 = Double.valueOf(monthly);
		singlerate(annualGasEle, annualEleGas, Quarter1, monthly1);
		return new GetAQuoteAction();
	}
	
	public GetAQuoteAction firstYearCalculationDualProfileClass02and04(GetAQuoteDetails getDetails) {
		
		//ELE
		String unitCharge = browser.getTextByXpath(pageProperties
				.getProperty("Dual.DayUnitChargeEle"));
		unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
		double UnitchargeEle = Double.valueOf(unitCharge);
		String standingCharge = browser.getTextByXpath(pageProperties
				.getProperty("Dual.StandingChargeEle"));
		standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
		double StandingChargeEle = Double.valueOf(standingCharge);
		String annualconsumption = browser
				.getTextByXpath(pageProperties
						.getProperty("Dual.ConsumptionEle"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]",	"");
		double annualconsumptionEle = Double.valueOf(annualconsumption);
		String nightCharge = browser.getTextByXpath(pageProperties.getProperty("Dual.NightUnitChargeEle"));
		nightCharge = nightCharge.replaceAll("[^\\d(?!.)]", "");
		double NightChargeDBL = Double.valueOf(nightCharge);
		double DaySpend = (0.7437931 * annualconsumptionEle * UnitchargeEle) / 100;
		double NightSpend = (0.2562069 * annualconsumptionEle * NightChargeDBL) / 100;
		double annualRateEle = (StandingChargeEle * 365) / 100 + DaySpend + NightSpend;
		annualRateEle=Math.round(annualRateEle*100.0)/100.0;
		//GAS
		String unitChargeGas = browser.getTextByXpath(pageProperties
				.getProperty("Dual.DayUnitChargeGas"));
		unitChargeGas = unitChargeGas.replaceAll("[^\\d(?!.)]", "");
		double unitchargeGas = Double.valueOf(unitChargeGas);
		String standingChargeGas = browser.getTextByXpath(pageProperties
				.getProperty("Dual.StandingChargeGas"));
		standingChargeGas = standingChargeGas.replaceAll("[^\\d(?!.)]", "");
		double StandingCharge = Double.valueOf(standingChargeGas);
		String annualconsumptionGas = browser.getTextByXpath(pageProperties
				.getProperty("Dual.ConsumptionGas"));
		annualconsumptionGas = annualconsumptionGas.replaceAll("[^\\d(?!.)]", "");
		double annualConsumptionGas = Double.valueOf(annualconsumptionGas);
		double annualRateGas =(StandingCharge * 365) / 100+ (annualConsumptionGas * (unitchargeGas)) / 100;
		annualRateGas=Math.round(annualRateGas*100.0)/100.0;
		String yearly = browser.getTextByXpath(pageProperties
				.getProperty("Dual.Annually"));
		yearly = yearly.replaceAll("[^\\d(?!.)]", "");
		double annualEleGas = Double.valueOf(yearly);
		double annualGasEle=annualRateEle + annualRateGas;
		String monthly = browser.getTextByXpath(pageProperties
				.getProperty("Dual.Month"));
		monthly = monthly.replaceAll("[^\\d(?!.)]", "");
		double monthly1 = Double.valueOf(monthly);
		double Quarter1 = Double.valueOf(monthly);
		singlerate(annualGasEle, annualEleGas, Quarter1, monthly1);
		return new GetAQuoteAction();
	}

	public GetAQuoteAction firstYearCalculationDualProfileClass06(GetAQuoteDetails getDetails) {
		//ELE
		String unitCharge = browser.getTextByXpath(pageProperties
				.getProperty("Dual.DayUnitChargeEle"));
		unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
		double UnitchargeEle = Double.valueOf(unitCharge);
		String standingCharge = browser.getTextByXpath(pageProperties
				.getProperty("Dual.StandingChargeEle"));
		standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
		double StandingChargeEle = Double.valueOf(standingCharge);
		String annualconsumption = browser
				.getTextByXpath(pageProperties
						.getProperty("Dual.ConsumptionEle"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]",	"");
		double annualconsumptionEle = Double.valueOf(annualconsumption);
		String nightCharge = browser.getTextByXpath(pageProperties.getProperty("Dual.NightUnitChargeEle"));
		nightCharge = nightCharge.replaceAll("[^\\d(?!.)]", "");
		double NightChargeDBL = Double.valueOf(nightCharge);
		double DaySpend = (0.82689112 * annualconsumptionEle * UnitchargeEle) / 100;
		double NightSpend = (0.17310888 * annualconsumptionEle * NightChargeDBL) / 100;
		double annualRateEle = (StandingChargeEle * 365) / 100 + DaySpend + NightSpend;
		annualRateEle=Math.round(annualRateEle*100.0)/100.0;
		//GAS
		String unitChargeGas = browser.getTextByXpath(pageProperties
				.getProperty("Dual.DayUnitChargeGas"));
		unitChargeGas = unitChargeGas.replaceAll("[^\\d(?!.)]", "");
		double unitchargeGas = Double.valueOf(unitChargeGas);
		String standingChargeGas = browser.getTextByXpath(pageProperties
				.getProperty("Dual.StandingChargeGas"));
		standingChargeGas = standingChargeGas.replaceAll("[^\\d(?!.)]", "");
		double StandingCharge = Double.valueOf(standingChargeGas);
		String annualconsumptionGas = browser.getTextByXpath(pageProperties
				.getProperty("Dual.ConsumptionGas"));
		annualconsumptionGas = annualconsumptionGas.replaceAll("[^\\d(?!.)]", "");
		double annualConsumptionGas = Double.valueOf(annualconsumptionGas);
		double annualRateGas =(StandingCharge * 365) / 100+ (annualConsumptionGas * (unitchargeGas)) / 100;
		annualRateGas=Math.round(annualRateGas*100.0)/100.0;
		String yearly = browser.getTextByXpath(pageProperties
				.getProperty("Dual.Annually"));
		yearly = yearly.replaceAll("[^\\d(?!.)]", "");
		double annualEleGas = Double.valueOf(yearly);
		double annualGasEle=annualRateEle + annualRateGas;
		String monthly = browser.getTextByXpath(pageProperties
				.getProperty("Dual.Month"));
		monthly = monthly.replaceAll("[^\\d(?!.)]", "");
		double monthly1 = Double.valueOf(monthly);
		double Quarter1 = Double.valueOf(monthly);
		singlerate(annualGasEle, annualEleGas, Quarter1, monthly1);
		return new GetAQuoteAction();

	}

	public GetAQuoteAction firstYearCalculationDualProfileClass07(GetAQuoteDetails getDetails) {
		//ELE
		String unitCharge = browser.getTextByXpath(pageProperties
				.getProperty("Dual.DayUnitChargeEle"));
		unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
		double UnitchargeEle = Double.valueOf(unitCharge);
		String standingCharge = browser.getTextByXpath(pageProperties
				.getProperty("Dual.StandingChargeEle"));
		standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
		double StandingChargeEle = Double.valueOf(standingCharge);
		String annualconsumption = browser
				.getTextByXpath(pageProperties
						.getProperty("Dual.ConsumptionEle"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]",	"");
		double annualconsumptionEle = Double.valueOf(annualconsumption);
		String nightCharge = browser.getTextByXpath(pageProperties.getProperty("Dual.NightUnitChargeEle"));
		nightCharge = nightCharge.replaceAll("[^\\d(?!.)]", "");
		double NightChargeDBL = Double.valueOf(nightCharge);
		double DaySpend = (0.814085274 * annualconsumptionEle * UnitchargeEle) / 100;
		double NightSpend = (0.18591472 * annualconsumptionEle * NightChargeDBL) / 100;
		double annualRateEle = (StandingChargeEle * 365) / 100 + DaySpend + NightSpend;
		annualRateEle=Math.round(annualRateEle*100.0)/100.0;
		//GAS
		String unitChargeGas = browser.getTextByXpath(pageProperties
				.getProperty("Dual.DayUnitChargeGas"));
		unitChargeGas = unitChargeGas.replaceAll("[^\\d(?!.)]", "");
		double unitchargeGas = Double.valueOf(unitChargeGas);
		String standingChargeGas = browser.getTextByXpath(pageProperties
				.getProperty("Dual.StandingChargeGas"));
		standingChargeGas = standingChargeGas.replaceAll("[^\\d(?!.)]", "");
		double StandingCharge = Double.valueOf(standingChargeGas);
		String annualconsumptionGas = browser.getTextByXpath(pageProperties
				.getProperty("Dual.ConsumptionGas"));
		annualconsumptionGas = annualconsumptionGas.replaceAll("[^\\d(?!.)]", "");
		double annualConsumptionGas = Double.valueOf(annualconsumptionGas);
		double annualRateGas =(StandingCharge * 365) / 100+ (annualConsumptionGas * (unitchargeGas)) / 100;
		annualRateGas=Math.round(annualRateGas*100.0)/100.0;
		String yearly = browser.getTextByXpath(pageProperties
				.getProperty("Dual.Annually"));
		// Replace non numeric characters here
		yearly = yearly.replaceAll("[^\\d(?!.)]", "");
		double annualEleGas = Double.valueOf(yearly);
		double annualGasEle=annualRateEle + annualRateGas;
		String monthly = browser.getTextByXpath(pageProperties
				.getProperty("Dual.Month"));
		monthly = monthly.replaceAll("[^\\d(?!.)]", "");
		double monthly1 = Double.valueOf(monthly);
		double Quarter1 = Double.valueOf(monthly);
		singlerate(annualGasEle, annualEleGas, Quarter1, monthly1);
		return new GetAQuoteAction();
	}

	public GetAQuoteAction firstYearCalculationDualProfileClass08(GetAQuoteDetails getDetails) {
		//ELE
		String unitCharge = browser.getTextByXpath(pageProperties
				.getProperty("Dual.DayUnitChargeEle"));
		unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
		double UnitchargeEle = Double.valueOf(unitCharge);
		String standingCharge = browser.getTextByXpath(pageProperties
				.getProperty("Dual.StandingChargeEle"));
		standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
		double StandingChargeEle = Double.valueOf(standingCharge);
		String annualconsumption = browser
				.getTextByXpath(pageProperties
						.getProperty("Dual.ConsumptionEle"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]",	"");
		double annualconsumptionEle = Double.valueOf(annualconsumption);
		String nightCharge = browser.getTextByXpath(pageProperties.getProperty("Dual.NightUnitChargeEle"));
		nightCharge = nightCharge.replaceAll("[^\\d(?!.)]", "");
		double NightChargeDBL = Double.valueOf(nightCharge);
		double DaySpend = (0.755109141 * annualconsumptionEle * UnitchargeEle) / 100;
		double NightSpend = (0.244890859 * annualconsumptionEle * NightChargeDBL) / 100;
		double annualRateEle = (StandingChargeEle * 365) / 100 + DaySpend + NightSpend;
		annualRateEle=Math.round(annualRateEle*100.0)/100.0;
		//GAS
		String unitChargeGas = browser.getTextByXpath(pageProperties
				.getProperty("Dual.DayUnitChargeGas"));
		unitChargeGas = unitChargeGas.replaceAll("[^\\d(?!.)]", "");
		double unitchargeGas = Double.valueOf(unitChargeGas);
		String standingChargeGas = browser.getTextByXpath(pageProperties
				.getProperty("Dual.StandingChargeGas"));
		standingChargeGas = standingChargeGas.replaceAll("[^\\d(?!.)]", "");
		double StandingCharge = Double.valueOf(standingChargeGas);
		String annualconsumptionGas = browser.getTextByXpath(pageProperties
				.getProperty("Dual.ConsumptionGas"));
		annualconsumptionGas = annualconsumptionGas.replaceAll("[^\\d(?!.)]", "");
		double annualConsumptionGas = Double.valueOf(annualconsumptionGas);
		double annualRateGas =(StandingCharge * 365) / 100+ (annualConsumptionGas * (unitchargeGas)) / 100;
		annualRateGas=Math.round(annualRateGas*100.0)/100.0;
		String yearly = browser.getTextByXpath(pageProperties
				.getProperty("Dual.Annually"));
		yearly = yearly.replaceAll("[^\\d(?!.)]", "");
		double annualEleGas = Double.valueOf(yearly);
		double annualGasEle=annualRateEle + annualRateGas;
		String monthly = browser.getTextByXpath(pageProperties
				.getProperty("Dual.Month"));
		monthly = monthly.replaceAll("[^\\d(?!.)]", "");
		double monthly1 = Double.valueOf(monthly);
		double Quarter1 = Double.valueOf(monthly);
		singlerate(annualGasEle, annualEleGas, Quarter1, monthly1);
		return new GetAQuoteAction();
	}

	public void secondYearDual(String profileClass, GetAQuoteDetails getDetails) {
	int pc=Integer.parseInt(profileClass);
	switch(pc)
	{
		case 1:
			secondYearCalculationDualProfileClass0103And05(getDetails);
			break;
		case 2:
			secondYearCalculationDualProfileClass02and04(getDetails);
			break;
		case 3:
			secondYearCalculationDualProfileClass0103And05(getDetails);
			break;
		case 4:
			secondYearCalculationDualProfileClass02and04(getDetails);
			break;
		case 5:
			secondYearCalculationDualProfileClass0103And05(getDetails);
			break;	
		case 6:
			secondYearCalculationDualProfileClass06(getDetails);
			break;
		case 7:
			secondYearCalculationDualProfileClass07(getDetails);
			break;
		case 8:
			secondYearCalculationDualProfileClass08(getDetails);
			break;
	}
}
	
	public GetAQuoteAction secondYearCalculationDualProfileClass0103And05(GetAQuoteDetails getDetails) {
	//ELE
	String unitCharge = browser.getTextByXpath(pageProperties
			.getProperty("Dual.unitcharge2ndYearEle"));
	unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
	double UnitchargeEle = Double.valueOf(unitCharge);
	String standingCharge = browser.getTextByXpath(pageProperties
			.getProperty("Dual.standingCharge2ndYearEle"));
	standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
	double StandingChargeEle = Double.valueOf(standingCharge);
	String annualconsumption = browser
			.getTextByXpath(pageProperties
					.getProperty("Dual.consumption2ndYearEle"));
	annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]",	"");
	double annualconsumptionEle = Double.valueOf(annualconsumption);
	double annualRateEle = (StandingChargeEle * 365) / 100+ (annualconsumptionEle * (UnitchargeEle)) / 100;
	annualRateEle=Math.round(annualRateEle*100.0)/100.0;
	//GAS
	String unitChargeGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.unitcharge2ndYearGas"));
	unitChargeGas = unitChargeGas.replaceAll("[^\\d(?!.)]", "");
	double unitchargeGas = Double.valueOf(unitChargeGas);
	String standingChargeGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.standingCharge2ndYearGas"));
	standingChargeGas = standingChargeGas.replaceAll("[^\\d(?!.)]", "");
	double StandingCharge = Double.valueOf(standingChargeGas);
	String annualconsumptionGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.consumption2ndYearGas"));
	annualconsumptionGas = annualconsumptionGas.replaceAll("[^\\d(?!.)]", "");
	double annualConsumptionGas = Double.valueOf(annualconsumptionGas);
	double annualRateGas =(StandingCharge * 365) / 100+ (annualConsumptionGas * (unitchargeGas)) / 100;
	annualRateGas=Math.round(annualRateGas*100.0)/100.0;
	String yearly = browser.getTextByXpath(pageProperties
			.getProperty("Dual.annualy2ndYear"));
	yearly = yearly.replaceAll("[^\\d(?!.)]", "");
	double annualEleGas = Double.valueOf(yearly);
	double annualGasEle=annualRateEle + annualRateGas;
	String monthly = browser.getTextByXpath(pageProperties
			.getProperty("Dual.monthQuarter2ndYear"));
	monthly = monthly.replaceAll("[^\\d(?!.)]", "");
	double monthly1 = Double.valueOf(monthly);
	double Quarter1 = Double.valueOf(monthly);
	singlerate(annualGasEle, annualEleGas, Quarter1, monthly1);
	return new GetAQuoteAction();
}

	public GetAQuoteAction secondYearCalculationDualProfileClass02and04(GetAQuoteDetails getDetails) {
	//ELE
	String unitCharge = browser.getTextByXpath(pageProperties
			.getProperty("Dual.unitcharge2ndYearEle"));
	unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
	double UnitchargeEle = Double.valueOf(unitCharge);
	String standingCharge = browser.getTextByXpath(pageProperties
			.getProperty("Dual.standingCharge2ndYearEle"));
	standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
	double StandingChargeEle = Double.valueOf(standingCharge);
	String annualconsumption = browser
			.getTextByXpath(pageProperties
					.getProperty("Dual.consumption2ndYearEle"));
	annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]",	"");
	double annualconsumptionEle = Double.valueOf(annualconsumption);
	String nightCharge = browser.getTextByXpath(pageProperties.getProperty("Dual.nightCharge2ndYearEle"));
	nightCharge = nightCharge.replaceAll("[^\\d(?!.)]", "");
	double NightChargeDBL = Double.valueOf(nightCharge);
	double DaySpend = (0.7437931 * annualconsumptionEle * UnitchargeEle) / 100;
	double NightSpend = (0.2562069 * annualconsumptionEle * NightChargeDBL) / 100;
	double annualRateEle = (StandingChargeEle * 365) / 100 + DaySpend + NightSpend;
	annualRateEle=Math.round(annualRateEle*100.0)/100.0;
	//GAS
	String unitChargeGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.unitcharge2ndYearGas"));
	unitChargeGas = unitChargeGas.replaceAll("[^\\d(?!.)]", "");
	double unitchargeGas = Double.valueOf(unitChargeGas);
	String standingChargeGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.standingCharge2ndYearGas"));
	standingChargeGas = standingChargeGas.replaceAll("[^\\d(?!.)]", "");
	double StandingCharge = Double.valueOf(standingChargeGas);
	String annualconsumptionGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.consumption2ndYearGas"));
	annualconsumptionGas = annualconsumptionGas.replaceAll("[^\\d(?!.)]", "");
	double annualConsumptionGas = Double.valueOf(annualconsumptionGas);
	double annualRateGas =(StandingCharge * 365) / 100+ (annualConsumptionGas * (unitchargeGas)) / 100;
	annualRateGas=Math.round(annualRateGas*100.0)/100.0;
	String yearly = browser.getTextByXpath(pageProperties
			.getProperty("Dual.annualy2ndYear"));
	yearly = yearly.replaceAll("[^\\d(?!.)]", "");
	double annualEleGas = Double.valueOf(yearly);
	double annualGasEle=annualRateEle + annualRateGas;
	String monthly = browser.getTextByXpath(pageProperties
			.getProperty("Dual.monthQuarter2ndYear"));
	monthly = monthly.replaceAll("[^\\d(?!.)]", "");
	double monthly1 = Double.valueOf(monthly);
	double Quarter1 = Double.valueOf(monthly);
	singlerate(annualGasEle, annualEleGas, Quarter1, monthly1);
	return new GetAQuoteAction();
}

	public GetAQuoteAction secondYearCalculationDualProfileClass06(GetAQuoteDetails getDetails) {
	//ELE
	String unitCharge = browser.getTextByXpath(pageProperties
			.getProperty("Dual.unitcharge2ndYearEle"));
	unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
	double UnitchargeEle = Double.valueOf(unitCharge);
	String standingCharge = browser.getTextByXpath(pageProperties
			.getProperty("Dual.standingCharge2ndYearEle"));
	standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
	double StandingChargeEle = Double.valueOf(standingCharge);
	String annualconsumption = browser
			.getTextByXpath(pageProperties
					.getProperty("Dual.consumption2ndYearEle"));
	annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]",	"");
	double annualconsumptionEle = Double.valueOf(annualconsumption);
	String nightCharge = browser.getTextByXpath(pageProperties.getProperty("Dual.nightCharge2ndYearEle"));
	nightCharge = nightCharge.replaceAll("[^\\d(?!.)]", "");
	double NightChargeDBL = Double.valueOf(nightCharge);
	double DaySpend = (0.82689112 * annualconsumptionEle * UnitchargeEle) / 100;
	double NightSpend = (0.17310888 * annualconsumptionEle * NightChargeDBL) / 100;
	double annualRateEle = (StandingChargeEle * 365) / 100 + DaySpend + NightSpend;
	annualRateEle=Math.round(annualRateEle*100.0)/100.0;
	//GAS
	String unitChargeGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.unitcharge2ndYearGas"));
	unitChargeGas = unitChargeGas.replaceAll("[^\\d(?!.)]", "");
	double unitchargeGas = Double.valueOf(unitChargeGas);
	String standingChargeGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.standingCharge2ndYearGas"));
	standingChargeGas = standingChargeGas.replaceAll("[^\\d(?!.)]", "");
	double StandingCharge = Double.valueOf(standingChargeGas);
	String annualconsumptionGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.consumption2ndYearGas"));
	annualconsumptionGas = annualconsumptionGas.replaceAll("[^\\d(?!.)]", "");
	double annualConsumptionGas = Double.valueOf(annualconsumptionGas);
	double annualRateGas =(StandingCharge * 365) / 100+ (annualConsumptionGas * (unitchargeGas)) / 100;
	annualRateGas=Math.round(annualRateGas*100.0)/100.0;
	String yearly = browser.getTextByXpath(pageProperties
			.getProperty("Dual.annualy2ndYear"));
	yearly = yearly.replaceAll("[^\\d(?!.)]", "");
	double annualEleGas = Double.valueOf(yearly);
	double annualGasEle=annualRateEle + annualRateGas;
	String monthly = browser.getTextByXpath(pageProperties
			.getProperty("Dual.monthQuarter2ndYear"));
	monthly = monthly.replaceAll("[^\\d(?!.)]", "");
	double monthly1 = Double.valueOf(monthly);
	double Quarter1 = Double.valueOf(monthly);
	singlerate(annualGasEle, annualEleGas, Quarter1, monthly1);
	return new GetAQuoteAction();
}

	public GetAQuoteAction secondYearCalculationDualProfileClass07(GetAQuoteDetails getDetails) {
	//ELE
	String unitCharge = browser.getTextByXpath(pageProperties
			.getProperty("Dual.unitcharge2ndYearEle"));
	unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
	double UnitchargeEle = Double.valueOf(unitCharge);
	String standingCharge = browser.getTextByXpath(pageProperties
			.getProperty("Dual.standingCharge2ndYearEle"));
	standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
	double StandingChargeEle = Double.valueOf(standingCharge);
	String annualconsumption = browser
			.getTextByXpath(pageProperties
					.getProperty("Dual.consumption2ndYearEle"));
	annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]",	"");
	double annualconsumptionEle = Double.valueOf(annualconsumption);
	String nightCharge = browser.getTextByXpath(pageProperties.getProperty("Dual.nightCharge2ndYearEle"));
	nightCharge = nightCharge.replaceAll("[^\\d(?!.)]", "");
	double NightChargeDBL = Double.valueOf(nightCharge);
	double DaySpend = (0.814085274 * annualconsumptionEle * UnitchargeEle) / 100;
	double NightSpend = (0.18591472 * annualconsumptionEle * NightChargeDBL) / 100;
	double annualRateEle = (StandingChargeEle * 365) / 100 + DaySpend + NightSpend;
	annualRateEle=Math.round(annualRateEle*100.0)/100.0;
	//GAS
	String unitChargeGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.unitcharge2ndYearGas"));
	unitChargeGas = unitChargeGas.replaceAll("[^\\d(?!.)]", "");
	double unitchargeGas = Double.valueOf(unitChargeGas);
	String standingChargeGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.standingCharge2ndYearGas"));
	standingChargeGas = standingChargeGas.replaceAll("[^\\d(?!.)]", "");
	double StandingCharge = Double.valueOf(standingChargeGas);
	String annualconsumptionGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.consumption2ndYearGas"));
	annualconsumptionGas = annualconsumptionGas.replaceAll("[^\\d(?!.)]", "");
	double annualConsumptionGas = Double.valueOf(annualconsumptionGas);
	double annualRateGas =(StandingCharge * 365) / 100+ (annualConsumptionGas * (unitchargeGas)) / 100;
	annualRateGas=Math.round(annualRateGas*100.0)/100.0;
	String yearly = browser.getTextByXpath(pageProperties
			.getProperty("Dual.annualy2ndYear"));
	// Replace non numeric characters here
	yearly = yearly.replaceAll("[^\\d(?!.)]", "");
	double annualEleGas = Double.valueOf(yearly);
	double annualGasEle=annualRateEle + annualRateGas;
	String monthly = browser.getTextByXpath(pageProperties
			.getProperty("Dual.monthQuarter2ndYear"));
	monthly = monthly.replaceAll("[^\\d(?!.)]", "");
	double monthly1 = Double.valueOf(monthly);
	double Quarter1 = Double.valueOf(monthly);
	singlerate(annualGasEle, annualEleGas, Quarter1, monthly1);
	return new GetAQuoteAction();

}

	public GetAQuoteAction secondYearCalculationDualProfileClass08(GetAQuoteDetails getDetails) {
	//ELE
	String unitCharge = browser.getTextByXpath(pageProperties
			.getProperty("Dual.unitcharge2ndYearEle"));
	unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
	double UnitchargeEle = Double.valueOf(unitCharge);
	String standingCharge = browser.getTextByXpath(pageProperties
			.getProperty("Dual.standingCharge2ndYearEle"));
	standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
	double StandingChargeEle = Double.valueOf(standingCharge);
	String annualconsumption = browser
			.getTextByXpath(pageProperties
					.getProperty("Dual.consumption2ndYearEle"));
	annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]",	"");
	double annualconsumptionEle = Double.valueOf(annualconsumption);
	String nightCharge = browser.getTextByXpath(pageProperties.getProperty("Dual.nightCharge2ndYearEle"));
	nightCharge = nightCharge.replaceAll("[^\\d(?!.)]", "");
	double NightChargeDBL = Double.valueOf(nightCharge);
	double DaySpend = (0.755109141 * annualconsumptionEle * UnitchargeEle) / 100;
	double NightSpend = (0.244890859 * annualconsumptionEle * NightChargeDBL) / 100;
	double annualRateEle = (StandingChargeEle * 365) / 100 + DaySpend + NightSpend;
	annualRateEle=Math.round(annualRateEle*100.0)/100.0;
	//GAS
	String unitChargeGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.unitcharge2ndYearGas"));
	unitChargeGas = unitChargeGas.replaceAll("[^\\d(?!.)]", "");
	double unitchargeGas = Double.valueOf(unitChargeGas);
	String standingChargeGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.standingCharge2ndYearGas"));
	standingChargeGas = standingChargeGas.replaceAll("[^\\d(?!.)]", "");
	double StandingCharge = Double.valueOf(standingChargeGas);
	String annualconsumptionGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.consumption2ndYearGas"));
	annualconsumptionGas = annualconsumptionGas.replaceAll("[^\\d(?!.)]", "");
	double annualConsumptionGas = Double.valueOf(annualconsumptionGas);
	double annualRateGas =(StandingCharge * 365) / 100+ (annualConsumptionGas * (unitchargeGas)) / 100;
	annualRateGas=Math.round(annualRateGas*100.0)/100.0;
	String yearly = browser.getTextByXpath(pageProperties
			.getProperty("Dual.annualy2ndYear"));
	yearly = yearly.replaceAll("[^\\d(?!.)]", "");
	double annualEleGas = Double.valueOf(yearly);
	double annualGasEle=annualRateEle + annualRateGas;
	String monthly = browser.getTextByXpath(pageProperties
			.getProperty("Dual.monthQuarter2ndYear"));
	// Replace non numeric characters here
	monthly = monthly.replaceAll("[^\\d(?!.)]", "");
	double monthly1 = Double.valueOf(monthly);
	double Quarter1 = Double.valueOf(monthly);
	singlerate(annualGasEle, annualEleGas, Quarter1, monthly1);
	return new GetAQuoteAction();
}

	public void thirdYearDual(String profileClass, GetAQuoteDetails getDetails) {
	int pc=Integer.parseInt(profileClass);
	switch(pc)
	{
		case 1:
			thirdYearCalculationDualProfileClass0103And05(getDetails);
			break;
		case 2:
			thirdYearCalculationDualProfileClass02and04(getDetails);
			break;
		case 3:
			thirdYearCalculationDualProfileClass0103And05(getDetails);
			break;
		case 4:
			thirdYearCalculationDualProfileClass02and04(getDetails);
			break;
		case 5:
			thirdYearCalculationDualProfileClass0103And05(getDetails);
			break;	
		case 6:
			thirdYearCalculationDualProfileClass06(getDetails);
			break;
		case 7:
			thirdYearCalculationDualProfileClass07(getDetails);
			break;
		case 8:
			thirdYearCalculationDualProfileClass08(getDetails);
			break;
	}

}

	public GetAQuoteAction thirdYearCalculationDualProfileClass0103And05(GetAQuoteDetails getDetails) {
	
	//ELE
	String unitCharge = browser.getTextByXpath(pageProperties
			.getProperty("Dual.unitcharge3rdYearEle"));
	unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
	double UnitchargeEle = Double.valueOf(unitCharge);
	String standingCharge = browser.getTextByXpath(pageProperties
			.getProperty("Dual.standingCharge3rdYearEle"));
	standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
	double StandingChargeEle = Double.valueOf(standingCharge);
	String annualconsumption = browser
			.getTextByXpath(pageProperties
					.getProperty("Dual.consumption3rdYearEle"));
	annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]",	"");
	double annualconsumptionEle = Double.valueOf(annualconsumption);
	
	double annualRateEle = (StandingChargeEle * 365) / 100+ (annualconsumptionEle * (UnitchargeEle)) / 100;
	annualRateEle=Math.round(annualRateEle*100.0)/100.0;
	//GAS
	String unitChargeGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.unitcharge3rdYearGas"));
	unitChargeGas = unitChargeGas.replaceAll("[^\\d(?!.)]", "");
	double unitchargeGas = Double.valueOf(unitChargeGas);
	String standingChargeGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.standingCharge3rdYearGas"));
	standingChargeGas = standingChargeGas.replaceAll("[^\\d(?!.)]", "");
	double StandingCharge = Double.valueOf(standingChargeGas);
	String annualconsumptionGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.consumption3rdYearGas"));
	annualconsumptionGas = annualconsumptionGas.replaceAll("[^\\d(?!.)]", "");
	double annualConsumptionGas = Double.valueOf(annualconsumptionGas);
	double annualRateGas =(StandingCharge * 365) / 100+ (annualConsumptionGas * (unitchargeGas)) / 100;
	annualRateGas=Math.round(annualRateGas*100.0)/100.0;
	String yearly = browser.getTextByXpath(pageProperties
			.getProperty("Dual.annualy3rdYear"));
	yearly = yearly.replaceAll("[^\\d(?!.)]", "");
	double annualEleGas = Double.valueOf(yearly);
	double annualGasEle=annualRateEle + annualRateGas;
	String monthly = browser.getTextByXpath(pageProperties
			.getProperty("Dual.monthQuarter3rdYear"));
	monthly = monthly.replaceAll("[^\\d(?!.)]", "");
	double monthly1 = Double.valueOf(monthly);
	double Quarter1 = Double.valueOf(monthly);
	singlerate(annualGasEle, annualEleGas, Quarter1, monthly1);
	return new GetAQuoteAction();
}

	public GetAQuoteAction thirdYearCalculationDualProfileClass02and04(GetAQuoteDetails getDetails) {
	
	//ELE
	String unitCharge = browser.getTextByXpath(pageProperties
			.getProperty("Dual.unitcharge3rdYearEle"));
	unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
	double UnitchargeEle = Double.valueOf(unitCharge);
	String standingCharge = browser.getTextByXpath(pageProperties
			.getProperty("Dual.standingCharge3rdYearEle"));
	standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
	double StandingChargeEle = Double.valueOf(standingCharge);
	String annualconsumption = browser
			.getTextByXpath(pageProperties
					.getProperty("Dual.consumption3rdYearEle"));
	annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]",	"");
	double annualconsumptionEle = Double.valueOf(annualconsumption);
	String nightCharge = browser.getTextByXpath(pageProperties.getProperty("Dual.nightCharge3rdYearEle"));
	nightCharge = nightCharge.replaceAll("[^\\d(?!.)]", "");
	double NightChargeDBL = Double.valueOf(nightCharge);
	double DaySpend = (0.7437931 * annualconsumptionEle * UnitchargeEle) / 100;
	double NightSpend = (0.2562069 * annualconsumptionEle * NightChargeDBL) / 100;
	double annualRateEle = (StandingChargeEle * 365) / 100 + DaySpend + NightSpend;
	annualRateEle=Math.round(annualRateEle*100.0)/100.0;
	//GAS
	String unitChargeGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.unitcharge3rdYearGas"));
	unitChargeGas = unitChargeGas.replaceAll("[^\\d(?!.)]", "");
	double unitchargeGas = Double.valueOf(unitChargeGas);
	String standingChargeGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.standingCharge3rdYearGas"));
	standingChargeGas = standingChargeGas.replaceAll("[^\\d(?!.)]", "");
	double StandingCharge = Double.valueOf(standingChargeGas);
	String annualconsumptionGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.consumption3rdYearGas"));
	annualconsumptionGas = annualconsumptionGas.replaceAll("[^\\d(?!.)]", "");
	double annualConsumptionGas = Double.valueOf(annualconsumptionGas);
	double annualRateGas =(StandingCharge * 365) / 100+ (annualConsumptionGas * (unitchargeGas)) / 100;
	annualRateGas=Math.round(annualRateGas*100.0)/100.0;
	String yearly = browser.getTextByXpath(pageProperties
			.getProperty("Dual.annualy3rdYear"));
	yearly = yearly.replaceAll("[^\\d(?!.)]", "");
	double annualEleGas = Double.valueOf(yearly);
	double annualGasEle=annualRateEle + annualRateGas;
	String monthly = browser.getTextByXpath(pageProperties
			.getProperty("Dual.monthQuarter3rdYear"));
	monthly = monthly.replaceAll("[^\\d(?!.)]", "");
	double monthly1 = Double.valueOf(monthly);
	double Quarter1 = Double.valueOf(monthly);
	singlerate(annualGasEle, annualEleGas, Quarter1, monthly1);
	return new GetAQuoteAction();
}

	public GetAQuoteAction thirdYearCalculationDualProfileClass06(GetAQuoteDetails getDetails) {
	//ELE
	String unitCharge = browser.getTextByXpath(pageProperties
			.getProperty("Dual.unitcharge3rdYearEle"));
	unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
	double UnitchargeEle = Double.valueOf(unitCharge);
	String standingCharge = browser.getTextByXpath(pageProperties
			.getProperty("Dual.standingCharge3rdYearEle"));
	standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
	double StandingChargeEle = Double.valueOf(standingCharge);
	String annualconsumption = browser
			.getTextByXpath(pageProperties
					.getProperty("Dual.consumption3rdYearEle"));
	annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]",	"");
	double annualconsumptionEle = Double.valueOf(annualconsumption);
	String nightCharge = browser.getTextByXpath(pageProperties.getProperty("Dual.nightCharge3rdYearEle"));
	nightCharge = nightCharge.replaceAll("[^\\d(?!.)]", "");
	double NightChargeDBL = Double.valueOf(nightCharge);
	double DaySpend = (0.82689112 * annualconsumptionEle * UnitchargeEle) / 100;
	double NightSpend = (0.17310888 * annualconsumptionEle * NightChargeDBL) / 100;
	double annualRateEle = (StandingChargeEle * 365) / 100 + DaySpend + NightSpend;
	annualRateEle=Math.round(annualRateEle*100.0)/100.0;
	//GAS
	String unitChargeGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.unitcharge3rdYearGas"));
	unitChargeGas = unitChargeGas.replaceAll("[^\\d(?!.)]", "");
	double unitchargeGas = Double.valueOf(unitChargeGas);
	String standingChargeGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.standingCharge3rdYearGas"));
	standingChargeGas = standingChargeGas.replaceAll("[^\\d(?!.)]", "");
	double StandingCharge = Double.valueOf(standingChargeGas);
	String annualconsumptionGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.consumption3rdYearGas"));
	annualconsumptionGas = annualconsumptionGas.replaceAll("[^\\d(?!.)]", "");
	double annualConsumptionGas = Double.valueOf(annualconsumptionGas);
	double annualRateGas =(StandingCharge * 365) / 100+ (annualConsumptionGas * (unitchargeGas)) / 100;
	annualRateGas=Math.round(annualRateGas*100.0)/100.0;
	String yearly = browser.getTextByXpath(pageProperties
			.getProperty("Dual.annualy3rdYear"));
	yearly = yearly.replaceAll("[^\\d(?!.)]", "");
	double annualEleGas = Double.valueOf(yearly);
	double annualGasEle=annualRateEle + annualRateGas;
	String monthly = browser.getTextByXpath(pageProperties
			.getProperty("Dual.monthQuarter3rdYear"));
	monthly = monthly.replaceAll("[^\\d(?!.)]", "");
	double monthly1 = Double.valueOf(monthly);
	double Quarter1 = Double.valueOf(monthly);
	singlerate(annualGasEle, annualEleGas, Quarter1, monthly1);
	return new GetAQuoteAction();

}

	public GetAQuoteAction thirdYearCalculationDualProfileClass07(GetAQuoteDetails getDetails) {
	//ELE
	String unitCharge = browser.getTextByXpath(pageProperties
			.getProperty("Dual.unitcharge3rdYearEle"));
	unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
	double UnitchargeEle = Double.valueOf(unitCharge);
	String standingCharge = browser.getTextByXpath(pageProperties
			.getProperty("Dual.standingCharge3rdYearEle"));
	standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
	double StandingChargeEle = Double.valueOf(standingCharge);
	String annualconsumption = browser
			.getTextByXpath(pageProperties
					.getProperty("Dual.consumption3rdYearEle"));
	annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]",	"");
	double annualconsumptionEle = Double.valueOf(annualconsumption);
	String nightCharge = browser.getTextByXpath(pageProperties.getProperty("Dual.nightCharge3rdYearEle"));
	nightCharge = nightCharge.replaceAll("[^\\d(?!.)]", "");
	double NightChargeDBL = Double.valueOf(nightCharge);
	double DaySpend = (0.814085274 * annualconsumptionEle * UnitchargeEle) / 100;
	double NightSpend = (0.18591472 * annualconsumptionEle * NightChargeDBL) / 100;
	double annualRateEle = (StandingChargeEle * 365) / 100 + DaySpend + NightSpend;
	annualRateEle=Math.round(annualRateEle*100.0)/100.0;
	//GAS
	String unitChargeGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.unitcharge3rdYearGas"));
	unitChargeGas = unitChargeGas.replaceAll("[^\\d(?!.)]", "");
	double unitchargeGas = Double.valueOf(unitChargeGas);
	String standingChargeGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.standingCharge3rdYearGas"));
	standingChargeGas = standingChargeGas.replaceAll("[^\\d(?!.)]", "");
	double StandingCharge = Double.valueOf(standingChargeGas);
	String annualconsumptionGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.consumption3rdYearGas"));
	annualconsumptionGas = annualconsumptionGas.replaceAll("[^\\d(?!.)]", "");
	double annualConsumptionGas = Double.valueOf(annualconsumptionGas);
	double annualRateGas =(StandingCharge * 365) / 100+ (annualConsumptionGas * (unitchargeGas)) / 100;
	annualRateGas=Math.round(annualRateGas*100.0)/100.0;
	String yearly = browser.getTextByXpath(pageProperties
			.getProperty("Dual.annualy3rdYear"));
	// Replace non numeric characters here
	yearly = yearly.replaceAll("[^\\d(?!.)]", "");
	double annualEleGas = Double.valueOf(yearly);
	double annualGasEle=annualRateEle + annualRateGas;
	String monthly = browser.getTextByXpath(pageProperties
			.getProperty("Dual.monthQuarter3rdYear"));
	monthly = monthly.replaceAll("[^\\d(?!.)]", "");
	double monthly1 = Double.valueOf(monthly);
	double Quarter1 = Double.valueOf(monthly);
	singlerate(annualGasEle, annualEleGas, Quarter1, monthly1);
	return new GetAQuoteAction();

}

	public GetAQuoteAction thirdYearCalculationDualProfileClass08(GetAQuoteDetails getDetails) {
	//ELE
	String unitCharge = browser.getTextByXpath(pageProperties
			.getProperty("Dual.unitcharge3rdYearEle"));
	unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
	double UnitchargeEle = Double.valueOf(unitCharge);
	String standingCharge = browser.getTextByXpath(pageProperties
			.getProperty("Dual.standingCharge3rdYearEle"));
	standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
	double StandingChargeEle = Double.valueOf(standingCharge);
	String annualconsumption = browser
			.getTextByXpath(pageProperties
					.getProperty("Dual.consumption3rdYearEle"));
	annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]",	"");
	double annualconsumptionEle = Double.valueOf(annualconsumption);
	String nightCharge = browser.getTextByXpath(pageProperties.getProperty("Dual.nightCharge3rdYearEle"));
	nightCharge = nightCharge.replaceAll("[^\\d(?!.)]", "");
	double NightChargeDBL = Double.valueOf(nightCharge);
	double DaySpend = (0.755109141 * annualconsumptionEle * UnitchargeEle) / 100;
	double NightSpend = (0.244890859 * annualconsumptionEle * NightChargeDBL) / 100;
	double annualRateEle = (StandingChargeEle * 365) / 100 + DaySpend + NightSpend;
	annualRateEle=Math.round(annualRateEle*100.0)/100.0;
	//GAS
	String unitChargeGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.unitcharge3rdYearGas"));
	unitChargeGas = unitChargeGas.replaceAll("[^\\d(?!.)]", "");
	double unitchargeGas = Double.valueOf(unitChargeGas);
	String standingChargeGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.standingCharge3rdYearGas"));
	standingChargeGas = standingChargeGas.replaceAll("[^\\d(?!.)]", "");
	double StandingCharge = Double.valueOf(standingChargeGas);
	String annualconsumptionGas = browser.getTextByXpath(pageProperties
			.getProperty("Dual.consumption3rdYearGas"));
	annualconsumptionGas = annualconsumptionGas.replaceAll("[^\\d(?!.)]", "");
	double annualConsumptionGas = Double.valueOf(annualconsumptionGas);
	double annualRateGas =(StandingCharge * 365) / 100+ (annualConsumptionGas * (unitchargeGas)) / 100;
	annualRateGas=Math.round(annualRateGas*100.0)/100.0;
	String yearly = browser.getTextByXpath(pageProperties
			.getProperty("Dual.annualy3rdYear"));
	yearly = yearly.replaceAll("[^\\d(?!.)]", "");
	double annualEleGas = Double.valueOf(yearly);
	double annualGasEle=annualRateEle + annualRateGas;
	String monthly = browser.getTextByXpath(pageProperties
			.getProperty("Dual.monthQuarter3rdYear"));
	// Replace non numeric characters here
	monthly = monthly.replaceAll("[^\\d(?!.)]", "");
	double monthly1 = Double.valueOf(monthly);
	double Quarter1 = Double.valueOf(monthly);
	singlerate(annualGasEle, annualEleGas, Quarter1, monthly1);
	return new GetAQuoteAction();
}

	public void validateFirstYearContractMonthlyAndQuarter(
			GetAQuoteDetails getDetails, String NightChargedb,
			String StandingChargedb, int i, String UnitCharge_DB,
			String NotchValue_DB) {
		if (i == 1 || i == 3 || i == 5) {
				String unitCharge = browser.getTextByXpath(pageProperties
						.getProperty("Dual.DayUnitChargeEle"));
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
					Report.updateTestLog("Ele-Expected unit charge is ("
							+ UnitCharge_db + " + " + NotchValue_db + ")="
							+ UnitandNotch1 + " Acutal Unit charge is: "
							+ Unitcharge, "PASS");
		} else {
					Report.updateTestLog("Ele-Expected unit charge is ("
							+ UnitCharge_db + " + " + NotchValue_db + ")="
							+ UnitandNotch1 + " Acutal Unit charge is: "
							+ Unitcharge, "FAIL");

		}
				String standingCharge = browser.getTextByXpath(pageProperties
						.getProperty("Dual.StandingChargeEle"));
				standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
				double StandingCharge = Double.valueOf(standingCharge);
				double StandingCharge_db = Double.valueOf(StandingChargedb);
				if (StandingCharge_db == StandingCharge) {
					Report.updateTestLog("Ele-Expected Standing Charge is "
							+ StandingCharge_db
							+ " Acutal Standing charge is: " + StandingCharge,
							"PASS");
				} else {
					Report.updateTestLog("Ele-Expected Standing Charge is "
							+ StandingCharge_db
							+ " Acutal Standing charge is: " + StandingCharge,
							"FAIL");
				}
				String annualconsumption = browser
						.getTextByXpath(pageProperties
								.getProperty("Dual.ConsumptionEle"));
				annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]",
						"");
				String monthly = browser.getTextByXpath(pageProperties
						.getProperty("Dual.Month"));
				// Replace non numeric characters here
				monthly = monthly.replaceAll("[^\\d(?!.)]", "");
				String yearly = browser.getTextByXpath(pageProperties
						.getProperty("Dual.Annually"));
				// Replace non numeric characters here
				yearly = yearly.replaceAll("[^\\d(?!.)]", "");
			}
			else{
			String unitCharge = browser.getTextByXpath(pageProperties
					.getProperty("Dual.DayUnitChargeEle"));
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
				Report.updateTestLog("Ele-Expected unit charge is ("
						+ UnitCharge_db + " + " + NotchValue_db + ")="
						+ UnitandNotch1 + " Acutal Unit charge is: "
						+ Unitcharge, "PASS");
			} else {
				Report.updateTestLog("Ele-Expected unit charge is ("
						+ UnitCharge_db + " + " + NotchValue_db + ")="
						+ UnitandNotch1 + " Acutal Unit charge is: "
						+ Unitcharge, "FAIL");
			}
			String standingCharge = browser.getTextByXpath(pageProperties
					.getProperty("Dual.StandingChargeEle"));
			standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
			double StandingCharge = Double.valueOf(standingCharge);
			double StandingCharge_db = Double.valueOf(StandingChargedb);
			if (StandingCharge_db == StandingCharge) {
				Report.updateTestLog("Ele-Expected Standing Charge is "
						+ StandingCharge_db + " Acutal Standing charge is: "
						+ StandingCharge, "PASS");
			} else {
				Report.updateTestLog("Ele-Expected Standing Charge is "
						+ StandingCharge_db + " Acutal Standing charge is: "
						+ StandingCharge, "FAIL");
			}
			String NightCharge = browser.getTextByXpath(pageProperties
					.getProperty("Dual.NightUnitChargeEle"));
			NightCharge = NightCharge.replaceAll("[^\\d(?!.)]", "");
			double NightUnitcharge = Double.valueOf(NightCharge);
			double NightUnitCharge_db = Double.valueOf(NightChargedb);
			NotchValue_db = Double.valueOf(NotchValue_DB);
			double NightUnitandNotch = NightUnitCharge_db + NotchValue_db;
			NightUnitandNotch = Math.round((NightUnitandNotch) * 1000.0) / 1000.0;
			if (NightUnitcharge == NightUnitandNotch) {
				Report.updateTestLog("Ele-Expected Night Unit Charge is ("
						+ NightUnitCharge_db + " + " + NotchValue_db + ")="
						+ NightUnitandNotch + " Acutal Night Unit charge is: "
						+ NightUnitcharge, "PASS");
			} else {
				Report.updateTestLog("Ele-Expected Night Unit Charge is ("
						+ NightUnitCharge_db + " + " + NotchValue_db + ")="
						+ NightUnitandNotch + " Acutal Night Unit charge is: "
						+ NightUnitcharge, "FAIL");
			}
			String annualconsumption = browser.getTextByXpath(pageProperties
					.getProperty("Dual.ConsumptionEle"));
			annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
			String monthly = browser.getTextByXpath(pageProperties
					.getProperty("Dual.Month"));
			monthly = monthly.replaceAll("[^\\d(?!.)]", "");
			String yearly = browser.getTextByXpath(pageProperties
					.getProperty("Dual.Annually"));
			yearly = yearly.replaceAll("[^\\d(?!.)]", "");
			}
	}
		
	public void validateSecondYearContractMonthlyAndQuarter(
			GetAQuoteDetails getDetails, String NightChargedb,
			String StandingChargedb, int i, String UnitCharge_DB,
			String NotchValue_DB) {

//		int rateCount = browser.getChildElementsCountByXpath(pageProperties
//				.getProperty("GetAQuote.Count1"));

		if (i == 1 || i == 3 || i == 5) {
				String unitCharge = browser.getTextByXpath(pageProperties
						.getProperty("Dual.unitcharge2ndYearEle"));
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
					Report.updateTestLog("Ele-Expected unit charge is ("
							+ UnitCharge_db + " + " + NotchValue_db + ")="
							+ UnitandNotch1 + " Acutal Unit charge is: "
							+ Unitcharge, "PASS");
				} else {
					Report.updateTestLog("Ele-Expected unit charge is ("
							+ UnitCharge_db + " + " + NotchValue_db + ")="
							+ UnitandNotch1 + " Acutal Unit charge is: "
							+ Unitcharge, "FAIL");
				}
				String standingCharge = browser.getTextByXpath(pageProperties
						.getProperty("Dual.standingCharge2ndYearEle"));
				standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
				double StandingCharge = Double.valueOf(standingCharge);
				double StandingCharge_db = Double.valueOf(StandingChargedb);
				if (StandingCharge_db == StandingCharge) {
					Report.updateTestLog("Ele-Expected Standing Charge is "
							+ StandingCharge_db
							+ " Acutal Standing charge is: " + StandingCharge,
							"PASS");
				} else {
					Report.updateTestLog("Ele-Expected Standing Charge is "
							+ StandingCharge_db
							+ " Acutal Standing charge is: " + StandingCharge,
							"FAIL");
				}
			}
			else{
			String unitCharge = browser.getTextByXpath(pageProperties
					.getProperty("Dual.unitcharge2ndYearEle"));
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
				Report.updateTestLog("Ele-Expected unit charge is ("
						+ UnitCharge_db + " + " + NotchValue_db + ")="
						+ UnitandNotch1 + " Acutal Unit charge is: "
						+ Unitcharge, "PASS");
			} else {
				Report.updateTestLog("Ele-Expected unit charge is ("
						+ UnitCharge_db + " + " + NotchValue_db + ")="
						+ UnitandNotch1 + " Acutal Unit charge is: "
						+ Unitcharge, "FAIL");
			}
			String standingCharge = browser.getTextByXpath(pageProperties
					.getProperty("Dual.standingCharge2ndYearEle"));
			standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
			double StandingCharge = Double.valueOf(standingCharge);
			double StandingCharge_db = Double.valueOf(StandingChargedb);
			if (StandingCharge_db == StandingCharge) {
				Report.updateTestLog("Ele-Expected Standing Charge is "
						+ StandingCharge_db + " Acutal Standing charge is: "
						+ StandingCharge, "PASS");
			} else {
				Report.updateTestLog("Ele-Expected Standing Charge is "
						+ StandingCharge_db + " Acutal Standing charge is: "
						+ StandingCharge, "FAIL");
			}
			String NightCharge = browser.getTextByXpath(pageProperties
					.getProperty("Dual.nightCharge2ndYearEle"));
			NightCharge = NightCharge.replaceAll("[^\\d(?!.)]", "");
			double NightUnitcharge = Double.valueOf(NightCharge);
			double NightUnitCharge_db = Double.valueOf(NightChargedb);
			NotchValue_db = Double.valueOf(NotchValue_DB);
			double NightUnitandNotch = NightUnitCharge_db + NotchValue_db;
			NightUnitandNotch = Math.round((NightUnitandNotch) * 1000.0) / 1000.0;
			if (NightUnitcharge == NightUnitandNotch) {
				Report.updateTestLog("Ele-Expected Night Unit Charge is ("
						+ NightUnitCharge_db + " + " + NotchValue_db + ")="
						+ NightUnitandNotch + " Acutal Night Unit charge is: "
						+ NightUnitcharge, "PASS");
			} else {
				Report.updateTestLog("Ele-Expected Night Unit Charge is ("
						+ NightUnitCharge_db + " + " + NotchValue_db + ")="
						+ NightUnitandNotch + " Acutal Night Unit charge is: "
						+ NightUnitcharge, "FAIL");
			}
			}
	}

	public void validateThirdYearContractMonthlyAndQuarter(
			GetAQuoteDetails getDetails, String NightChargedb,
			String StandingChargedb, int i, String UnitCharge_DB,
			String NotchValue_DB) {
		if (i == 1 || i == 3 || i == 5) {
				String unitCharge = browser.getTextByXpath(pageProperties
						.getProperty("Dual.unitcharge3rdYearEle"));
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
					Report.updateTestLog("Ele-Expected unit charge is ("
							+ UnitCharge_db + " + " + NotchValue_db + ")="
							+ UnitandNotch1 + " Acutal Unit charge is: "
							+ Unitcharge, "PASS");
				} else {
					Report.updateTestLog("Ele-Expected unit charge is ("
							+ UnitCharge_db + " + " + NotchValue_db + ")="
							+ UnitandNotch1 + " Acutal Unit charge is: "
							+ Unitcharge, "FAIL");
				}
				String standingCharge = browser.getTextByXpath(pageProperties
						.getProperty("Dual.standingCharge3rdYearEle"));
				standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
				double StandingCharge = Double.valueOf(standingCharge);
				double StandingCharge_db = Double.valueOf(StandingChargedb);
				if (StandingCharge_db == StandingCharge) {
					Report.updateTestLog("Ele-Expected Standing Charge is "
							+ StandingCharge_db
							+ " Acutal Standing charge is: " + StandingCharge,
							"PASS");
				} else {
					Report.updateTestLog("Ele-Expected Standing Charge is "
							+ StandingCharge_db
							+ " Acutal Standing charge is: " + StandingCharge,
							"FAIL");
				}
			}
			else{
			String unitCharge = browser.getTextByXpath(pageProperties
					.getProperty("Dual.unitcharge3rdYearEle"));
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
				Report.updateTestLog("Ele-Expected unit charge is ("
						+ UnitCharge_db + " + " + NotchValue_db + ")="
						+ UnitandNotch1 + " Acutal Unit charge is: "
						+ Unitcharge, "PASS");
			} else {
				Report.updateTestLog("Ele-Expected unit charge is ("
						+ UnitCharge_db + " + " + NotchValue_db + ")="
						+ UnitandNotch1 + " Acutal Unit charge is: "
						+ Unitcharge, "FAIL");
			}
			String standingCharge = browser.getTextByXpath(pageProperties
					.getProperty("Dual.standingCharge3rdYearEle"));
			standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
			double StandingCharge = Double.valueOf(standingCharge);
			double StandingCharge_db = Double.valueOf(StandingChargedb);
			if (StandingCharge_db == StandingCharge) {
				Report.updateTestLog("Ele-Expected Standing Charge is "
						+ StandingCharge_db + " Acutal Standing charge is: "
						+ StandingCharge, "PASS");
			} else {
				Report.updateTestLog("Ele-Expected Standing Charge is "
						+ StandingCharge_db + " Acutal Standing charge is: "
						+ StandingCharge, "FAIL");
			}
			String NightCharge = browser.getTextByXpath(pageProperties
					.getProperty("Dual.nightCharge3rdYearEle"));
			NightCharge = NightCharge.replaceAll("[^\\d(?!.)]", "");
			double NightUnitcharge = Double.valueOf(NightCharge);
			double NightUnitCharge_db = Double.valueOf(NightChargedb);
			NotchValue_db = Double.valueOf(NotchValue_DB);
			double NightUnitandNotch = NightUnitCharge_db + NotchValue_db;
			NightUnitandNotch = Math.round((NightUnitandNotch) * 1000.0) / 1000.0;
			if (NightUnitcharge == NightUnitandNotch) {
				Report.updateTestLog("Ele-Expected Night Unit Charge is ("
						+ NightUnitCharge_db + " + " + NotchValue_db + ")="
						+ NightUnitandNotch + " Acutal Night Unit charge is: "
						+ NightUnitcharge, "PASS");
			} else {
				Report.updateTestLog("Ele-Expected Night Unit Charge is ("
						+ NightUnitCharge_db + " + " + NotchValue_db + ")="
						+ NightUnitandNotch + " Acutal Night Unit charge is: "
						+ NightUnitcharge, "FAIL");
			}
			}
	}
			
	private void singlerate(double annualRate, double yearly1, double Quarter1,
			double Monthly1) {
		double monthlyRate;
		double quarterrate;
		if (browser.isSelectedByXpath(pageProperties
				.getProperty("GetAQuote.quarterbutton1_ele"))
				|| browser.isSelectedByXpath(pageProperties
						.getProperty("GetAQuote.quarterbutton2_ele"))
				|| browser.isSelectedByXpath(pageProperties
						.getProperty("Dual.3rdYearQuarterOption"))) {
			quarterrate = Math.round(annualRate / 4* 100.0) / 100.0;
			//double annualRate1 = Math.round(annualRate * 100.0) / 100.0;
			//quarterrate = Math.round(quarterrate * 100.0) / 100.0;
			double quarterrate1 = Math.round(quarterrate * 100.0) / 100.0;
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
			//double annualRate2 = Math.round(annualRate * 100.0) / 100.0;
			monthlyRate = Math.round(annualRate / 12* 100.0) / 100.0;
			//double monthlyRate1 = Math.round(monthlyRate * 100.0) / 100.0;
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

	public void firstYearFormulaNightcharge(double yearly1, double Monthly1,
			double Quarter1, double DaySpend, double NightSpend,
			double annualRate) {
		double monthlyRate;
		double quarterrate;
		double annualRate1 = Math.round(annualRate) * 1000.0 / 1000.0;
		if (browser.isSelectedByXpath(pageProperties
				.getProperty("GetAQuote.quarterbutton1_ele"))
				|| browser.isSelectedByXpath(pageProperties
						.getProperty("GetAQuote.quarterbutton2_ele"))
				|| browser.isSelectedByXpath(pageProperties
						.getProperty("GetAQuote.quarterbutton3_ele"))) {
			quarterrate = annualRate1 / 4;
			double quarterrate1 = Math.round(quarterrate) * 1000.0 / 1000.0;
			if (Math.round(yearly1) == Math.round(annualRate1)) {
				Report.updateTestLog("Actual  Annual rate is:" + yearly1
						+ "Expected Annual Rate is: " + annualRate1 + "",
						"PASS");
			} else {
				Report.updateTestLog("Actual  Annual rate is:" + yearly1
						+ "Expected Annual Rate is: " + annualRate1 + "",
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
			monthlyRate = annualRate1 / 12;
			double monthlyRate1 = Math.round(monthlyRate) * 1000.0 / 1000.0;
			if (Math.round(yearly1) == Math.round(annualRate1)) {
				Report.updateTestLog("Actual  Annual rate is:" + yearly1
						+ "Expected Annual Rate is: " + annualRate1 + "",
						"PASS");
			} else {
				Report.updateTestLog("Actual  Annual rate is:" + yearly1
						+ "Expected Annual Rate is: " + annualRate1 + "",
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
		
	public GetAQuoteAction calculatingConsumption1YearEle(
			GetAQuoteDetails getDetails, int j) {
		String strelecAnnualSpend123 = getDetails.getCurrentUsage_Value();
		int test = Integer.parseInt(strelecAnnualSpend123);
		String ElecConsump = browser.getTextByXpath(pageProperties
				.getProperty("Dual.ConsumptionEle"));
		ElecConsump = ElecConsump.replace(",", "");
		String ElecConsumpAnnualSplit[] = ElecConsump.split("k");
		elecConsumption = Double.parseDouble(ElecConsumpAnnualSplit[0]);
		calculatingConsumptionEle(getDetails, j, test, elecConsumption);
		return new GetAQuoteAction();
	}
	
	public GetAQuoteAction calculatingConsumption1YearGas(
			GetAQuoteDetails getDetails, int j) {
		String strelecAnnualSpend123 = getDetails.getCurrentUsage_Value();
		int test = Integer.parseInt(strelecAnnualSpend123);
		String ElecConsump = browser.getTextByXpath(pageProperties
				.getProperty("Dual.ConsumptionGas"));
		ElecConsump = ElecConsump.replace(",", "");
		String ElecConsumpAnnualSplit[] = ElecConsump.split("k");
		elecConsumption = Double.parseDouble(ElecConsumpAnnualSplit[0]);
		calculatingConsumptionGas(getDetails, j, test, elecConsumption);
		return new GetAQuoteAction();
	}
	
	public GetAQuoteAction calculatingConsumption2YearEle(
			GetAQuoteDetails getDetails, int j) {
		String strelecAnnualSpend123 = getDetails.getCurrentUsage_Value();
		int test = Integer.parseInt(strelecAnnualSpend123);
		String ElecConsump = browser.getTextByXpath(pageProperties
				.getProperty("Dual.consumption2ndYearEle"));
		ElecConsump = ElecConsump.replace(",", "");
		String ElecConsumpAnnualSplit[] = ElecConsump.split("k");
		elecConsumption = Double.parseDouble(ElecConsumpAnnualSplit[0]);
		calculatingConsumptionEle(getDetails, j, test, elecConsumption);
		return new GetAQuoteAction();

	}
	
	public GetAQuoteAction calculatingConsumption2YearGas(
			GetAQuoteDetails getDetails, int j) {
		String strelecAnnualSpend123 = getDetails.getCurrentUsage_Value();
		int test = Integer.parseInt(strelecAnnualSpend123);
		String gasConsump = browser.getTextByXpath(pageProperties
				.getProperty("Dual.consumption2ndYearGas"));
		gasConsump = gasConsump.replace(",", "");
		String gasConsumpAnnualSplit[] = gasConsump.split("k");
		elecConsumption = Double.parseDouble(gasConsumpAnnualSplit[0]);
		calculatingConsumptionGas(getDetails, j, test, elecConsumption);
		return new GetAQuoteAction();
	}
	
	public GetAQuoteAction calculatingConsumption3YearEle(
			GetAQuoteDetails getDetails, int j) {
		String strelecAnnualSpend123 = getDetails.getCurrentUsage_Value();
		int test = Integer.parseInt(strelecAnnualSpend123);
		String ElecConsump = browser.getTextByXpath(pageProperties
				.getProperty("Dual.consumption3rdYearEle"));
		ElecConsump = ElecConsump.replace(",", "");
		String ElecConsumpAnnualSplit[] = ElecConsump.split("k");
		elecConsumption = Double.parseDouble(ElecConsumpAnnualSplit[0]);
		calculatingConsumptionEle(getDetails, j, test, elecConsumption);
		return new GetAQuoteAction();
	}
		
	public GetAQuoteAction calculatingConsumption3YearGas(
			GetAQuoteDetails getDetails, int j) {
		String strelecAnnualSpend123 = getDetails.getCurrentUsage_Value();
		int test = Integer.parseInt(strelecAnnualSpend123);
		String gasConsump = browser.getTextByXpath(pageProperties
				.getProperty("Dual.consumption3rdYearGas"));
		gasConsump = gasConsump.replace(",", "");
		String gasConsumpAnnualSplit[] = gasConsump.split("k");
		elecConsumption = Double.parseDouble(gasConsumpAnnualSplit[0]);
		calculatingConsumptionGas(getDetails, j, test, elecConsumption);
		return new GetAQuoteAction();
	}
		
	public GetAQuoteAction calculatingConsumptionEle(GetAQuoteDetails getDetails, int j, int test, double elecConsumption) {
	switch (j) {
	case 0:
		int test1 = test * 1;
		if (elecConsumption == test1) {
			Report.updateTestLog(
					"Ele-Consumption Calculation Success for <b>Annual</b>--Actual Rate is: "
							+ elecConsumption + "Expected Rate is: "
							+ test1 + "", "PASS");
		} else {
			Report.updateTestLog(
					"Ele-Consumption Calculation Failure for <b>Annual</b>--Actual Rate is: "
							+ elecConsumption + "Expected Rate is: "
							+ test1 + "", "FAIL");
		}
		break;
	case 1:
		int test12 = test * 12;
		if (elecConsumption == test12) {
			Report.updateTestLog(
					"Ele-Consumption Calculation Success for <b>Monthly</b>--Actual Rate is: "
							+ elecConsumption + "Expected Rate is: "
							+ test12 + "", "PASS");
		} else {
			Report.updateTestLog(
					"Ele-Consumption Calculation Failure for <b>Monthly</b>--Actual Rate is: "
							+ elecConsumption + "Expected Rate is: "
							+ test12 + "", "FAIL");
		}
		break;
	case 2:
		int test4 = test * 4;
		if (elecConsumption == test4) {
			Report.updateTestLog(
					"Ele-Consumption Calculation Success for <b>Quarter</b>--Actual Rate is: "
							+ elecConsumption + "Expected Rate is: "
							+ test4 + "", "PASS");
		} else {

			Report.updateTestLog(
					"Ele-Consumption Calculation Failure for <b>Quarter</b>--Actual Rate is: "
							+ elecConsumption + "Expected Rate is: "
							+ test4 + "", "FAIL");
		}
		break;
	}
	return new GetAQuoteAction();
}
	
	public GetAQuoteAction calculatingConsumptionGas(GetAQuoteDetails getDetails, int j, int test, double elecConsumption) {
	switch (j) {
	case 0:
		int test1 = test * 1;
		if (elecConsumption == test1) {
			Report.updateTestLog(
					"Gas-Consumption Calculation Success for <b>Annual</b>--Actual Rate is: "
							+ elecConsumption + "Expected Rate is: "
							+ test1 + "", "PASS");
		} else {

			Report.updateTestLog(
					"Gas-Consumption Calculation Failure for <b>Annual</b>--Actual Rate is: "
							+ elecConsumption + "Expected Rate is: "
							+ test1 + "", "FAIL");
		}
		break;
	case 1:
		int test12 = test * 12;
		if (elecConsumption == test12) {
			Report.updateTestLog(
					"Gas-Consumption Calculation Success for <b>Monthly</b>--Actual Rate is: "
							+ elecConsumption + "Expected Rate is: "
							+ test12 + "", "PASS");
		} else {

			Report.updateTestLog(
					"Gas-Consumption Calculation Failure for <b>Monthly</b>--Actual Rate is: "
							+ elecConsumption + "Expected Rate is: "
							+ test12 + "", "FAIL");
		}
		break;
	case 2:
		int test4 = test * 4;
		if (elecConsumption == test4) {
			Report.updateTestLog(
					"Gas-Consumption Calculation Success for <b>Quarter</b>--Actual Rate is: "
							+ elecConsumption + "Expected Rate is: "
							+ test4 + "", "PASS");
		} else {

			Report.updateTestLog(
					"Gas-Consumption Calculation Failure for <b>Quarter</b>--Actual Rate is: "
							+ elecConsumption + "Expected Rate is: "
							+ test4 + "", "FAIL");
		}
		break;
	}
	return new GetAQuoteAction();

}	
	
	public GetAQuoteAction clickMonthlyContinueQuotePage1stYear() {
		String strQuoteRefNo = null;
		String strQuote = null;
		if (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("Dual.QRno"))) {
		browser.wait(getWaitTime());
			strQuote = browser.getTextByXpath(pageProperties
					.getProperty("Dual.QRno"));
			strQuoteRefNo = strQuote.replaceFirst("Quote reference: ", "");
		}
		if (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("Dual.FirstYearContinue"))) {
			browser.clickWithXpath(pageProperties
					.getProperty("Dual.FirstYearContinue"));
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
	
	public GetAQuoteAction clickMonthlyContinueQuotePage2ndYear() {
		
		if (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("Dual.SecondYearContinue"))) {
			browser.clickWithXpath(pageProperties
					.getProperty("Dual.SecondYearContinue"));
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
		return new GetAQuoteAction();
	}
	
	public GetAQuoteAction clickMonthlyContinueQuotePage3rdYear() {
		
		if (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("Dual.ThirdYearContinue"))) {
			browser.clickWithXpath(pageProperties
					.getProperty("Dual.ThirdYearContinue"));
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
		return new GetAQuoteAction();
	}
	
	public GetAQuoteAction clickContinueCompareAllTab() {
		
		if (browser.isElementVisibleWithXpath(pageProperties
				.getProperty("Dual.ThirdYearContinue"))) {
			browser.clickWithXpath(pageProperties
					.getProperty("Dual.ThirdYearContinue"));
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
		return new GetAQuoteAction();
	}
	public GetAQuoteAction gasunitpricefromdb1stYear(GetAQuoteDetails getDetails,
			String monthlyQuarter, String Dual) {
		String annualconsumption = browser.getTextByXpath(pageProperties
				.getProperty("Dual.ConsumptionGas"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
		String PostCode = getDetails.getPostcode();
		int consumption = Integer.parseInt(annualconsumption);
		gasDbUnitCharge(getDetails, PostCode, consumption, monthlyQuarter, Dual);
		return new GetAQuoteAction();
	}
	
	public GetAQuoteAction gasunitpricefromdb2ndYear(GetAQuoteDetails getDetails,
			String monthlyQuarter, String Dual) {
		String annualconsumption = browser.getTextByXpath(pageProperties
				.getProperty("Dual.consumption2ndYearGas"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
		String PostCode = getDetails.getPostcode();
		int consumption = Integer.parseInt(annualconsumption);
		gasDbUnitCharge(getDetails, PostCode, consumption, monthlyQuarter, Dual);
		return new GetAQuoteAction();
	}
	
	public GetAQuoteAction gasunitpricefromdb3rdYear(GetAQuoteDetails getDetails,
			String monthlyQuarter, String Dual) {
		String annualconsumption = browser.getTextByXpath(pageProperties
				.getProperty("Dual.consumption3rdYearGas"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
		String PostCode = getDetails.getPostcode();
		int consumption = Integer.parseInt(annualconsumption);
		gasDbUnitCharge(getDetails, PostCode, consumption, monthlyQuarter, Dual);
		return new GetAQuoteAction();
	}
	
	public GetAQuoteAction gasDbUnitCharge(GetAQuoteDetails getDetails,
			String postcode, int Consumption, String monthlyQuarter, String Dual) {
		
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
	
	public void validateFirstYearContractMonthlyGas(
			GetAQuoteDetails getDetails, String UnitCharge_DB,
			String StandingChargeDB, String NotchValue_DB) {
			String unitCharge = browser.getTextByXpath(pageProperties
					.getProperty("Dual.DayUnitChargeGas"));
			unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
			double Unitcharge = Double.valueOf(unitCharge);
			double UnitCharge_db = Double.valueOf(UnitCharge_DB);
			double NotchValue_db = Double.valueOf(NotchValue_DB);
			double UnitandNotch = UnitCharge_db + NotchValue_db;
			UnitandNotch = Math.round((UnitandNotch) * 1000.0) / 1000.0;
			if (Unitcharge == UnitandNotch) {
				Report.updateTestLog("Gas-Expected unit charge is ("
						+ UnitCharge_db + " + " + NotchValue_db + ")="
						+ UnitandNotch + " Acutal Unit charge is: "
						+ Unitcharge, "PASS");
			} else {
				Report.updateTestLog("Gas-Expected unit charge is ("
						+ UnitCharge_db + " + " + NotchValue_db + ")="
						+ UnitandNotch + " Acutal Unit charge is: "
						+ Unitcharge, "FAIL");
			}
			String standingCharge = browser.getTextByXpath(pageProperties
					.getProperty("Dual.StandingChargeGas"));
			standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
			double StandingCharge = Double.valueOf(standingCharge);
			double StandingCharge_db = Double.valueOf(StandingChargeDB);
			if (StandingCharge_db == StandingCharge) {
				Report.updateTestLog("Gas-Expected Standing Charge is "
						+ StandingCharge_db + " Acutal Standing charge is: "
						+ StandingCharge, "PASS");
			} else {
				Report.updateTestLog("Gas-Expected Standing Charge is "
						+ StandingCharge_db + " Acutal Standing charge is: "
						+ StandingCharge, "FAIL");
			}
	}
	
	public void validateSecondYearContractMonthlyGas(
			GetAQuoteDetails getDetails, String UnitCharge_DB,
			String StandingChargeDB, String NotchValue_DB) {
			String unitCharge = browser.getTextByXpath(pageProperties
					.getProperty("Dual.unitcharge2ndYearGas"));
			unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
			double Unitcharge = Double.valueOf(unitCharge);
			double UnitCharge_db = Double.valueOf(UnitCharge_DB);
			double NotchValue_db = Double.valueOf(NotchValue_DB);
			double UnitandNotch = UnitCharge_db + NotchValue_db;
			UnitandNotch = Math.round((UnitandNotch) * 1000.0) / 1000.0;
			if (Unitcharge == UnitandNotch) {
				Report.updateTestLog("Gas-Expected unit charge is ("
						+ UnitCharge_db + " + " + NotchValue_db + ")="
						+ UnitandNotch + " Acutal Unit charge is: "
						+ Unitcharge, "PASS");
			} else {
				Report.updateTestLog("Gas-Expected unit charge is ("
						+ UnitCharge_db + " + " + NotchValue_db + ")="
						+ UnitandNotch + " Acutal Unit charge is: "
						+ Unitcharge, "FAIL");
			}
			String standingCharge = browser.getTextByXpath(pageProperties
					.getProperty("Dual.standingCharge2ndYearGas"));
			standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
			double StandingCharge = Double.valueOf(standingCharge);
			double StandingCharge_db = Double.valueOf(StandingChargeDB);
			if (StandingCharge_db == StandingCharge) {
				Report.updateTestLog("Gas-Expected Standing Charge is "
						+ StandingCharge_db + " Acutal Standing charge is: "
						+ StandingCharge, "PASS");
			} else {
				Report.updateTestLog("Gas-Expected Standing Charge is "
						+ StandingCharge_db + " Acutal Standing charge is: "
						+ StandingCharge, "FAIL");
			}
	}
	
	public void validateThirdYearContractMonthlyGas(
			GetAQuoteDetails getDetails, String UnitCharge_DB,
			String StandingChargeDB, String NotchValue_DB) {
			String unitCharge = browser.getTextByXpath(pageProperties
					.getProperty("Dual.unitcharge3rdYearGas"));
			unitCharge = unitCharge.replaceAll("[^\\d(?!.)]", "");
			double Unitcharge = Double.valueOf(unitCharge);
			double UnitCharge_db = Double.valueOf(UnitCharge_DB);
			double NotchValue_db = Double.valueOf(NotchValue_DB);
			double UnitandNotch = UnitCharge_db + NotchValue_db;
			UnitandNotch = Math.round((UnitandNotch) * 1000.0) / 1000.0;
			if (Unitcharge == UnitandNotch) {
				Report.updateTestLog("Gas-Expected unit charge is ("
						+ UnitCharge_db + " + " + NotchValue_db + ")="
						+ UnitandNotch + " Acutal Unit charge is: "
						+ Unitcharge, "PASS");
			} else {
				Report.updateTestLog("Gas-Expected unit charge is ("
						+ UnitCharge_db + " + " + NotchValue_db + ")="
						+ UnitandNotch + " Acutal Unit charge is: "
						+ Unitcharge, "FAIL");
			}
			String standingCharge = browser.getTextByXpath(pageProperties
					.getProperty("Dual.standingCharge3rdYearGas"));
			standingCharge = standingCharge.replaceAll("[^\\d(?!.)]", "");
			double StandingCharge = Double.valueOf(standingCharge);
			double StandingCharge_db = Double.valueOf(StandingChargeDB);
			if (StandingCharge_db == StandingCharge) {
				Report.updateTestLog("Gas-Expected Standing Charge is "
						+ StandingCharge_db + " Acutal Standing charge is: "
						+ StandingCharge, "PASS");
			} else {
				Report.updateTestLog("Gas-Expected Standing Charge is "
						+ StandingCharge_db + " Acutal Standing charge is: "
						+ StandingCharge, "FAIL");
			}
	}
	
	public GetAQuoteAction clickQuaterlybutton1stYearGas(
			GetAQuoteDetails getDetails) {
		browser.wait(3000);
		verifyAndClickWithXpath(
				pageProperties.getProperty("Dual.FirstYearQuarter"),
				"<B>First Year Quarter Option</B>");
		return new GetAQuoteAction();
	}
	
	public GetAQuoteAction clickQuaterlybutton1stYear(
			GetAQuoteDetails getDetails) {
		browser.wait(3000);
		verifyAndClickWithXpath(pageProperties.getProperty("Dual.1stYearTabDual"), "First Year Tab Quarter Option");
		verifyAndClickWithXpath(
				pageProperties.getProperty("Dual.FirstYearQuarter"),
				"<B>First Year Quarter Option</B>");
		return new GetAQuoteAction();
	}
	
	public void defaultConsumptionSupplyCode1year(
			GetAQuoteDetails getDetails, int i) {
		String annualconsumption = browser.getTextByXpath(pageProperties
				.getProperty("Dual.ConsumptionEle"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
		int elecConsumpCalc_Actual = Integer.parseInt(annualconsumption);
		new GaqQuotePage()
		   .defaultConsumptionSupplyCode11(getDetails, i, elecConsumpCalc_Actual);
	}
	
	public void defaultConsumptionSupplyCode2year(
			GetAQuoteDetails getDetails, int i) {
		String annualconsumption = browser.getTextByXpath(pageProperties
				.getProperty("Dual.consumption2ndYearEle"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
		int elecConsumpCalc_Actual = Integer.parseInt(annualconsumption);
		new GaqQuotePage()
		   .defaultConsumptionSupplyCode11(getDetails, i, elecConsumpCalc_Actual);
	}
	
	public void defaultConsumptionSupplyCode3year(
			GetAQuoteDetails getDetails, int i) {
		String annualconsumption = browser.getTextByXpath(pageProperties
				.getProperty("Dual.consumption3rdYearEle"));
		annualconsumption = annualconsumption.replaceAll("[^\\d(?!.)]", "");
		int elecConsumpCalc_Actual = Integer.parseInt(annualconsumption);
		new GaqQuotePage()
		   .defaultConsumptionSupplyCode11(getDetails, i, elecConsumpCalc_Actual);
	}
	
	public void verifyBadDataTypeUnsaved() {
		String strQuote = browser.getTextByXpath(pageProperties
				.getProperty("Dual.QRno"));
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
	
	public void verifySavedQuoteStatusBaddata() {
		String strQuote = browser.getTextByXpath(pageProperties
				.getProperty("Dual.QRno"));
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
	
	public void verifyBadDataType() {
		String qrno1 = browser.getTextByXpath(pageProperties
				.getProperty("Dual.paymentQrnNo"));
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
	
	public void verifyUnSavedQuoteStatus(String Qrnno) {
		String strQuote = browser.getTextByXpath(pageProperties
				.getProperty("Dual.QRno"+Qrnno));
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
}
