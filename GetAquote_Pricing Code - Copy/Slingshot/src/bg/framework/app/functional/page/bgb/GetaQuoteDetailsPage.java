package bg.framework.app.functional.page.bgb;

import bg.framework.app.functional.action.bgb.GetAQuoteAction;
import bg.framework.app.functional.entities.GetAQuoteDetails;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

import java.util.Properties;

public class GetaQuoteDetailsPage extends BasePage {
	private final static String FILE_NAME = "resources/bgb/GetAQuote.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	public static double monthlyQuote;
	public static double annualQuote;
	public static double unitCharge;
	public static double standingCharge;
	public static double annualConsumption;
	public static double gasAnnualConsumption;
	public static double gasStandingCharge;
	public static double gasUnitCharge;
	public static double nightUnitCharge;
	public static boolean containsNightRate = false;
	public static String quoteReferenceId = "";

	/*
	 * *****************************************************************************
	 * Method :enterGetaQuoteDetails
	 * 
	 * Created On:01/23/2011 Description: This method enters the details under
	 * the details pane
	 * **********************************************************
	 * *******************
	 */
	
	public GetAQuoteAction enterGetaQuoteDetails(GetAQuoteDetails getDetails) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		browser.wait(getWaitTime());
		if (browser.isElementVisible(pageProperties.getProperty("GetAQuote.Title"))) {
			browser.wait(getWaitTime());
			browser.selectfromDropBox("id",
			        pageProperties.getProperty("GetAQuote.Title"), getDetails.getTitle());
			Report.updateTestLog("Title field exist and value got entered", "PASS");
		} else {

			Report.updateTestLog("Title field does not exist & value not  entered",
			        "FAIL");
		}
		if (browser.isElementVisible(pageProperties.getProperty("GetAQuote.Firstname"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQuote.Firstname"),
			        getDetails.getFirstName());
			Report.updateTestLog("First Name field exist and value got entered "+getDetails.getFirstName(), "DONE");
		} else {

			Report.updateTestLog("First Name  field does not exist & value not  entered",
			        "FAIL");
		}
		if (browser.isElementVisible(pageProperties.getProperty("GetAQuote.Surname"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQuote.Surname"),
			        getDetails.getLastName());
			Report.updateTestLog("Surname field exist and value got entered "+getDetails.getLastName(), "DONE");
		} else {
			Report.updateTestLog("Surname  field does not exist & value not  entered",
			        "FAIL");
		}
		if (browser
		        .isElementVisible(pageProperties.getProperty("GetAQuote.Businessname"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQuote.Businessname"),
			        getDetails.getbusinessname());
			Report.updateTestLog("Businessname field exist and value got entered  "+getDetails.getbusinessname(), "DONE");
		} else {
			Report.updateTestLog(
			        "Businessname  field does not exist & value not  entered", "FAIL");
		}
		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.Telephonenumber"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQuote.Telephonenumber"),
			        getDetails.gettelephone());
			Report.updateTestLog("Telephone field exist and value got entered "+getDetails.gettelephone(), "DONE");
		} else {
			Report.updateTestLog("Telephone field does not exist & value not  entered",
			        "FAIL");
		}
		if (browser.isElementVisible(pageProperties.getProperty("GetAQuote.Email"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQuote.Email"),
			        getDetails.getEmail());
			Report.updateTestLog("Email field exist and value got entered "+getDetails.getEmail(), "DONE");
		} else {
			Report.updateTestLog("Email field does not exist & value not  entered",
			        "FAIL");
		}
		return new GetAQuoteAction();

	}

	/*
	 * *****************************************************************************
	 * Method :enterElectricityAddress
	 * 
	 * Created On:06/13/2012
	 *  Description: This method enters the details under Supply post code
	 * **********************************************************
	 * *******************
	 */
	
	public GetAQuoteAction enterElectricityAddress(GetAQuoteDetails getDetails) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		browser.wait(getWaitTime());
		if (browser.isElementVisible(pageProperties.getProperty("GetAQuote.Postcode"))) {

			browser.input(pageProperties.getProperty("GetAQuote.Postcode"),
			        getDetails.getPostcode());

			Report.updateTestLog("Postcode field exist and value got entered", "PASS");
		} else {
			Report.updateTestLog("Postcode field does not exist & value not  entered",
			        "FAIL");
		}

		if (browser.isElementVisible(pageProperties.getProperty("GetAQuote.FindAdress"))) {
			browser.wait(getWaitTime());
			browser.click(pageProperties.getProperty("GetAQuote.FindAdress"));
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Report.updateTestLog("Find Address Button exist and value got entered",
			        "PASS");
		} else {
			Report.updateTestLog(
			        "Find address field does not exist & value not  entered", "FAIL");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String supplydetails=browser.getTextByXpath(pageProperties.getProperty("GetAquote.GasFindAddressText"));
		if(supplydetails.trim().equals("Enter supply details manually"))
		{
			Report.updateTestLog("Expected Text is available:  "+supplydetails.trim(), "PASS");
		}
		else
		{
			Report.updateTestLog("Expected Text is not available:  "+supplydetails.trim(), "FAIL");
		}
		
		String callus=browser.getTextByXpath(pageProperties.getProperty("GetAquote.GasFindAddressTextTeleNo"));
		if(callus.trim().contains("or call us on 0845 026 4659"))
		{
			Report.updateTestLog("Expected Text is available:  "+callus.trim(), "PASS");
		}
		else
		{
			Report.updateTestLog("Expected Text is not available:  "+callus.trim(), "FAIL");
		}
		
		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.SelectAdressId"))) {
			
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			browser.click(pageProperties.getProperty("GetAQuote.SelectAdressId"));
			Report.updateTestLog("Address ID has been selected from the list", "PASS");
		} else {
			Report.updateTestLog("Address id does not exist", "FAIL");
		}
		String changeAddress=browser.getTextByXpath(pageProperties.getProperty("GetAquote.ChangeAddressText"));
		if(changeAddress.trim().contains("Change Address"))
		{
			Report.updateTestLog("Expected Text is available:  "+changeAddress.trim(), "PASS");
		}
		else
		{
			Report.updateTestLog("Expected Text is not available:  "+changeAddress.trim(), "FAIL");
		}
		
		/*////////Remove it as per ID 540////////
		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.EleSubmitAddress"))) {
			
			browser.wait(getWaitTime());
			browser.click(pageProperties.getProperty("GetAQuote.EleSubmitAddress"));
			Report.updateTestLog("Address ID has been selected from the list", "PASS");
		} else {
			Report.updateTestLog("Address id does not exist", "FAIL");
		}
		//////////////////////////////////////
		*/
		return new GetAQuoteAction();

	}
	
	/*
	 * *****************************************************************************
	 * Method :enterConsumptionForEle
	 * 
	 * Created On:06/13/2012
	 *  Description: This method enters Consumption for Electricity
	 * **********************************************************
	 * *******************
	 */
	
	public GetAQuoteAction enterConsumptionForEle(GetAQuoteDetails getDetails,int j) {
		
		String spend[]={"Annual","Monthly","Quarterly"};
		
		/*if(spend[1].equals("Annual Spend") )
		{
			browser.open("https://10.224.70.76/business/get-a-quote-personal-details-dualfuel-2/?BGBhomeid=bgblink195");
		}*/
		browser.wait(getWaitTime());
		if (browser.isElementVisible(pageProperties.getProperty("GetAQuote.ElectricityUsage"))) {
			browser.wait(getWaitTime());
			browser.selectfromDropBox("id",
			        pageProperties.getProperty("GetAQuote.ElectricityUsage"), spend[j]);
			Report.updateTestLog("Title field exist and value got entered", "PASS");
		} else {

			Report.updateTestLog("Title field does not exist & value not  entered",
			        "FAIL");
		}
		if (browser.isElementVisible(pageProperties.getProperty("GetAQuote.ElectricityValue"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQuote.ElectricityValue"),
			        getDetails.getCurrentUsage_Value());
			Report.updateTestLog("First Name field exist and value got entered", "PASS");
		} else {

			Report.updateTestLog("First Name  field does not exist & value not  entered",
			        "FAIL");
		}
		
		return new GetAQuoteAction();

	} 
	
	/*
	 * *****************************************************************************
	 * Method :enterConsumptionForEle
	 * 
	 * Created On:06/13/2012
	 *  Description: This method enters Consumption for Electricity
	 * **********************************************************
	 * *******************
	 */
	
	public GetAQuoteAction enterConsumptionForGas(GetAQuoteDetails getDetails,int j) {
		
		String spend[]={"Annual","Monthly","Quarterly"};
		
		/*if(spend[1].equals("Annual Spend") )
		{
			browser.open("https://10.224.70.76/business/get-a-quote-personal-details-dualfuel-2/?BGBhomeid=bgblink195");
		}*/
		browser.wait(getWaitTime());
		if (browser.isElementVisible("gas-usage")) {
			browser.wait(getWaitTime());
			browser.selectfromDropBox("id", "gas-usage", spend[j]);
			Report.updateTestLog("DropBox Selected Successfully", "PASS");
		} else {

			Report.updateTestLog("DropBox object not found", "FAIL");
		}
		if (browser.isElementVisible("lastyearconsumptionID")) {
			browser.wait(getWaitTime());
			browser.input("lastyearconsumptionID",getDetails.getCurrentUsage_Value());
			Report.updateTestLog("Consumption Value got entered", "PASS");
		} else {

			Report.updateTestLog("Consumption object not found",
			        "FAIL");
		}
		
		return new GetAQuoteAction();

	} 
	
public GetAQuoteAction clickGasMeterOptionNO() {
		
		verifyAndClickWithXpath(pageProperties.getProperty("GetAquote.GasmeterNo"), "ClickGasMeterOptionNO");
		return new GetAQuoteAction();

	} 

	public GetAQuoteAction gasMeterYESandNO(GetAQuoteDetails getDetails) throws InterruptedException {
		
		if(browser.isSelectedByXpath(pageProperties.getProperty("GetAquote.GasmeterYes")))	
		{
			browser.inputByXpath(pageProperties.getProperty("GetAquote.GasMprno"), getDetails.getgasmeterRefnumber());
			browser.inputByXpath(pageProperties.getProperty("GetAquote.GasPostcode"), getDetails.getPostcode());
			Thread.sleep(9000);
			verifyAndClickWithXpath(pageProperties.getProperty("GetAquote.GasContinue"), "Details Page Continue Button");
			Thread.sleep(9000);
		}else
		{
			browser.inputByXpath(pageProperties.getProperty("GetAquote.GasPostcode"), getDetails.getPostcode());
			Thread.sleep(10000);
			verifyAndClickWithXpath(pageProperties.getProperty("GetAquote.GasFindAddress"), "Click Find Address Button");
			Thread.sleep(35000);
			verifyAndClickWithXpath(pageProperties.getProperty("GetAquote.GasAddressID"), "First Address Clicked");
			Thread.sleep(8000);
			verifyAndClickWithXpath(pageProperties.getProperty("GetAquote.GasContinue"), "Details Page Continue Button");
			Thread.sleep(5000);
		}
		return new GetAQuoteAction();

	} 
	

	/*
	 * *****************************************************************************
	 * Method :electricitySupplyDetailsClickRbYes
	 * 
	 * Created On:01/23/2011 Description: This method enters the electricity
	 * supply details by selecting Radio button Yes under the electricity
	 * details pane
	 * **************************************************************
	 * ***************
	 */

	public GetAQuoteAction electricitySupplyDetailsClickRbYes(GetAQuoteDetails getDetails) {

		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.Supplynumberoption1"))) {
			browser.wait(getWaitTime());
			browser.click(pageProperties.getProperty("GetAQuote.Supplynumberoption1"));
			Report.updateTestLog("Radio button exist and selected option1", "PASS");
		} else {
			Report.updateTestLog("Radio Button does not exist", "FAIL");
		}
		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.AnnualElectricitySpend"))) {
			browser.wait(2000);
			browser.input(pageProperties.getProperty("GetAQuote.AnnualElectricitySpend"),
			        getDetails.getElecAnnualspend());
			Report.updateTestLog("Electricity spend exist and value got entered", "PASS");
		} else {
			Report.updateTestLog("Electricity spend does not exist", "FAIL");
		}

		if (browser.isElementVisible(pageProperties.getProperty("GetAQUote.mpan1"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQUote.mpan1"),
			        getDetails.getSupplyNumber1());
			Report.updateTestLog("SupplyNumber1 field exist and value got entered",
			        "PASS");
		} else {
			Report.updateTestLog(
			        "SupplyNumber1 field does not exist & value not  entered", "FAIL");
		}

		if (browser.isElementVisible(pageProperties.getProperty("GetAQUote.mpan2"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQUote.mpan2"),
			        getDetails.getSupplyNumber2());
			Report.updateTestLog("SupplyNumber2 field exist and value got entered",
			        "PASS");
		} else {
			Report.updateTestLog(
			        "SupplyNumber2 field does not exist & value not  entered", "FAIL");
		}
		if (browser.isElementVisible(pageProperties.getProperty("GetAQUote.mpan3"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQUote.mpan3"),
			        getDetails.getSupplyNumber3());
			Report.updateTestLog("SupplyNumber3 field exist and value got entered",
			        "PASS");
		} else {
			Report.updateTestLog(
			        "SupplyNumber3 field does not exist & value not  entered", "FAIL");
		}

		if (browser.isElementVisible(pageProperties.getProperty("GetAQUote.mpan4"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQUote.mpan4"),
			        getDetails.getSupplyNumber4());
			Report.updateTestLog("SupplyNumber4 field exist and value got entered",
			        "PASS");
		} else {
			Report.updateTestLog(
			        "SupplyNumber4 field does not exist & value not  entered", "FAIL");
		}

		if (browser.isElementVisible(pageProperties.getProperty("GetAQUote.mpan5"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQUote.mpan5"),
			        getDetails.getSupplyNumber5());
			Report.updateTestLog("SupplyNumber5 field exist and value got entered",
			        "PASS");
		} else {
			Report.updateTestLog(
			        "SupplyNumber5 field does not exist & value not  entered", "FAIL");
		}
		if (browser.isElementVisible(pageProperties.getProperty("GetAQUote.mpan6"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQUote.mpan6"),
			        getDetails.getSupplyNumber6());
			Report.updateTestLog("SupplyNumber6 field exist and value got entered",
			        "PASS");
		} else {
			Report.updateTestLog(
			        "SupplyNumber6 field does not exist & value not  entered", "FAIL");
		}
		if (browser.isElementVisible(pageProperties.getProperty("GetAQUote.mpan7"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQUote.mpan7"),
			        getDetails.getSupplyNumber7());
			Report.updateTestLog("SupplyNumber7 field exist and value got entered",
			        "PASS");
		} else {
			Report.updateTestLog(
			        "SupplyNumber7 field does not exist & value not  entered", "FAIL");
		}

		return new GetAQuoteAction();
	}

	/*
	 * *****************************************************************************
	 * Method :electricitySupplyDetailsClickRbNo Created On:01/23/2011
	 * Description: This method enters the electricity supply details by
	 * selecting Radio button No under the electricity details pane
	 * **************
	 * ***************************************************************
	 */
	public GetAQuoteAction electricitySupplyDetailsClickRbNo(GetAQuoteDetails getDetails) {
		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.Supplynumberoption2"))) {
			browser.wait(getWaitTime());
			browser.click(pageProperties.getProperty("GetAQuote.Supplynumberoption2"));
			Report.updateTestLog("Radio button exist and selected option2", "PASS");
		} else {
			Report.updateTestLog("Radio Button does not exist", "FAIL");
		}
		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.AnnualElectricitySpend"))) {

			browser.input(pageProperties.getProperty("GetAQuote.AnnualElectricitySpend"),
			        getDetails.getElecAnnualspend());
			Report.updateTestLog("Electricity spend exist and value got entered", "PASS");
		} else {
			Report.updateTestLog("Electricity spend does not exist", "FAIL");
		}
		if (browser.isElementVisible(pageProperties.getProperty("GetAQuote.Postcode"))) {

			browser.input(pageProperties.getProperty("GetAQuote.Postcode"),
			        getDetails.getPostcode());

			Report.updateTestLog("Pastcode field exist and value got entered", "PASS");
		} else {
			Report.updateTestLog("Postcode field does not exist & value not  entered",
			        "FAIL");
		}

		if (browser.isElementVisible(pageProperties.getProperty("GetAQuote.FindAdress"))) {
			browser.wait(getWaitTime());
			browser.wait(10000);
			browser.click(pageProperties.getProperty("GetAQuote.FindAdress"));
			
			Report.updateTestLog("Find Address Button exist and value got entered",
			        "PASS");
		} else {
			Report.updateTestLog(
			        "Find address field does not exist & value not  entered", "FAIL");
		}
		
		browser.wait(20000);
		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.SelectAdressId"))) {
			
			browser.wait(getWaitTime());
			browser.click(pageProperties.getProperty("GetAQuote.SelectAdressId"));
			Report.updateTestLog("Address ID has been selected from the list", "PASS");
		} else {
			Report.updateTestLog("Address id does not exist", "FAIL");
		}
		return new GetAQuoteAction();
	}

	/*
	 * *****************************************************************************
	 * Method :gasSupplyDetailsClickRbYes Created On:01/23/2011 Description:This
	 * method enters the electricity supply details by selecting Radio button No
	 * under the Gas details pane
	 * ************************************************
	 * *****************************
	 */
	public GetAQuoteAction gasSupplyDetailsClickRbYes(GetAQuoteDetails getDetails) {

		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.annualGasSpend"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQuote.annualGasSpend"),
			        getDetails.getannualGasSpend());
			Report.updateTestLog("Gas spend field exist and value got entered", "PASS");
		} else {
			Report.updateTestLog("Gas spend field does not exist & value not  entered",
			        "FAIL");
		}
		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.Supplynumberoption1"))) {
			browser.wait(getWaitTime());
			browser.click(pageProperties.getProperty("GetAQuote.Supplynumberoption1"));
			Report.updateTestLog("Radio button  field exist and selected option 1",
			        "PASS");
		} else {
			Report.updateTestLog("Radio button field does not exist", "FAIL");
		}
		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.gasmeterRefnumber"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQuote.gasmeterRefnumber"),
			        getDetails.getgasmeterRefnumber());
			Report.updateTestLog("GasREfNumber field exist and value got entered", "PASS");
		} else {
			Report.updateTestLog(
			        "Gasrefnumber field does not exist & value not  entered", "FAIL");
		}
		if (browser.isElementVisible(pageProperties.getProperty("GetAQuote.Postcode"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQuote.Postcode"),
			        getDetails.getPostcode());
			Report.updateTestLog("Postcode field exist and value got entered", "PASS");
		} else {
			Report.updateTestLog("Postcode field does not exist & value not  entered",
			        "FAIL");
		}
		return new GetAQuoteAction();
	}

	/*
	 * *****************************************************************************
	 * Method :dualGasSupplyDetailsClickRbYes Created On:01/23/2011
	 * Description:This method enters the Gas supply details by selecting Radio
	 * button yes under the Gas details pane
	 * *************************************
	 * ****************************************
	 */
	public GetAQuoteAction dualGasSupplyDetailsClickRbYes(GetAQuoteDetails getDetails) {

		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.DualannualGasSpend"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQuote.DualannualGasSpend"),
			        getDetails.getannualGasSpend());
			Report.updateTestLog("Gas spend field exist and value got entered", "PASS");
		} else {
			Report.updateTestLog("Gas spend field does not exist & value not  entered",
			        "FAIL");
		}
		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.DualgasmeterRefnumber"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQuote.DualgasmeterRefnumber"),
			        getDetails.getgasmeterRefnumber());
			Report.updateTestLog("GasREfNumber field exist and value got entered", "PASS");
		} else {
			Report.updateTestLog(
			        "Gasrefnumber field does not exist & value not  entered", "FAIL");
		}
		if (browser.isElementVisible(pageProperties.getProperty("GetAQuote.Postcode"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQuote.Postcode"),
			        getDetails.getPostcode());
			Report.updateTestLog("Postcode field exist and value got entered", "PASS");
		} else {
			Report.updateTestLog("Postcode field does not exist & value not  entered",
			        "FAIL");
		}
		return new GetAQuoteAction();
	}

	/*
	 * *****************************************************************************
	 * Method :gasSupplyDetailsClickRbNo Created On:01/30/2011 Description:This
	 * method enters the Gas supply details by selecting Radio button No under
	 * the Gas details pane
	 * ******************************************************
	 * ***********************
	 */
	public GetAQuoteAction gasSupplyDetailsClickRbNo(GetAQuoteDetails getDetails) {
		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.annualGasSpend"))) {

			browser.input(pageProperties.getProperty("GetAQuote.annualGasSpend"),
			        getDetails.getannualGasSpend());
			Report.updateTestLog("Gas spend field exist and value got entered", "PASS");
		} else {
			Report.updateTestLog("Gas spend field does not exist & value not  entered",
			        "FAIL");
		}
		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.Supplynumberoption2"))) {

			browser.click(pageProperties.getProperty("GetAQuote.Supplynumberoption2"));
			Report.updateTestLog("Radio button  field exist and selected option 2",
			        "PASS");
		} else {
			Report.updateTestLog("Radio button field does not exist", "FAIL");
		}

		if (browser.isElementVisible(pageProperties.getProperty("GetAQuote.Postcode"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQuote.Postcode"),
			        getDetails.getPostcode());
			Report.updateTestLog("Postcode field exist and value got entered", "PASS");
		} else {
			Report.updateTestLog("Postcode field does not exist & value not  entered",
			        "FAIL");
		}
		if (browser.isElementVisible(pageProperties.getProperty("GetAQuote.FindAdress"))) {
			browser.wait(getWaitTime());
			browser.click(pageProperties.getProperty("GetAQuote.FindAdress"));
			browser.wait(10000);
			Report.updateTestLog("Find Adress field exist and value got entered", "PASS");
		} else {
			Report.updateTestLog("Find Adress field does not exist & value not  entered",
			        "FAIL");
		}
		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.SelectAdressId"))) {
			browser.wait(getWaitTime());
			browser.click(pageProperties.getProperty("GetAQuote.SelectAdressId"));
			browser.wait(2000);
			Report.updateTestLog("Address ID has been selected from the list", "PASS");
		} else {
			Report.updateTestLog("Address id does not exist", "FAIL");
		}
		return new GetAQuoteAction();
	}

	/*
	 * *****************************************************************************
	 * Method :dualGasSupplyDetailsClickRbNo Created On:01/30/2011
	 * Description:This method enters the Gas supply details by selecting Radio
	 * button No under the Gas details pane
	 * **************************************
	 * ***************************************
	 */
	public GetAQuoteAction dualGasSupplyDetailsClickRbNo(GetAQuoteDetails getDetails) {
		if (!browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.DualElecSelectAdressID")))
		browser.wait(20000);
		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.DualElecSelectAdressID"))) {
			
			browser.wait(getWaitTime());
			browser.click(pageProperties.getProperty("GetAQuote.DualElecSelectAdressID"));
			Report.updateTestLog(
			        "Address ID has been selected from the Electricity deatils pane",
			        "PASS");
		} else {
			Report.updateTestLog(
			        "Address id does not exist in the Electricity Details Pane", "FAIL");
		}
		if (browser.isElementVisible(pageProperties
		        .getProperty("GetAQuote.DualannualGasSpend"))) {
			browser.wait(getWaitTime());
			browser.input(pageProperties.getProperty("GetAQuote.DualannualGasSpend"),
			        getDetails.getannualGasSpend());
			Report.updateTestLog("Gas spend field exist and value got entered", "PASS");
		} else {
			Report.updateTestLog("Gas spend field does not exist & value not  entered",
			        "FAIL");
		}
		return new GetAQuoteAction();
	}

	/*
	 * *****************************************************************************
	 * Method :calculateQuoteForElec Created On:01/30/2011 Description:This
	 * method Clicks the calculate Quote button while doing Electricity quote
	 * ****
	 * *************************************************************************
	 */
	public GetAQuoteAction calculateQuoteForElec() {
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.CalculateQuote"))) {
			browser.clickWithXpath(pageProperties.getProperty("GetAQuote.CalculateQuote"));
			browser.wait(getWaitTime());
			Report.updateTestLog("CalculateQuote image  exist", "PASS");
		} else {
			Report.updateTestLog("CalculateQuote image does not exist", "FAIL");
		}

		return new GetAQuoteAction();
	}

	public void retreiveElecQuotesUI()

	{

		String textinUI = browser.getText(
		        pageProperties.getProperty("GetAQuote.QuoteMonth")).trim();
		monthlyQuote = Double.parseDouble(textinUI.substring(1, textinUI.length()));
		textinUI = browser.getText(pageProperties.getProperty("GetAQuote.QuoteAnnual"))
		        .trim();
		annualQuote = Double.parseDouble(textinUI.substring(1, textinUI.length()));
		textinUI = browser.getTextByXpath(
		        pageProperties.getProperty("GetAQuote.ElecQuoteUnitcharge")).trim();
		textinUI = textinUI.replace(
		        pageProperties.getProperty("GetAQuote.UnitChargeSuffixText"), "").trim();
		unitCharge = Double.parseDouble(textinUI);
		int unitRateCount = browser.getChildElementsCountByXpath(pageProperties
		        .getProperty("GetAQuote.StandardChargeXPath"));
		if (unitRateCount == 3) {
			containsNightRate = true;
			textinUI = browser.getTextByXpath(
			        pageProperties.getProperty("GetAQuote.NightChargeXPath")).trim();
			textinUI = textinUI.replaceAll(
			        pageProperties.getProperty("GetAQuote.UnitChargeSuffixText"), "")
			        .trim();
			nightUnitCharge = Double.parseDouble(textinUI);

			textinUI = browser.getTextByXpath(
			        pageProperties.getProperty("GetAQuote.DualStandardCharge_NightXPath"))
			        .trim();
			textinUI = textinUI
			        .replace(
			                pageProperties
			                        .getProperty("GetAQuote.StaindingChargeSuffixText"),
			                "").trim();
			standingCharge = Double.parseDouble(textinUI);

		} else if (unitRateCount == 2) {
			textinUI = browser.getTextByXpath(
			        pageProperties.getProperty("GetAQuote.ElecQuoteStandingCharge"))
			        .trim();
			textinUI = textinUI
			        .replace(
			                pageProperties
			                        .getProperty("GetAQuote.StaindingChargeSuffixText"),
			                "").trim();
			standingCharge = Double.parseDouble(textinUI);
		}

		textinUI = browser.getTextByXpath(
		        pageProperties.getProperty("GetAQuote.ElecConsumpAnnual")).trim();
		textinUI = textinUI.replace(
		        pageProperties.getProperty("GetAQuote.ElecAnnualConsumpSuffixText"), "")
		        .trim();
		if (textinUI.contains(",")) {
			textinUI = textinUI.replaceAll(",", "");
		}
		annualConsumption = Double.parseDouble(textinUI);

	}

	
///////////////////retreiveElectricityQuotesUI//////////////////////////////////////	
	public void retreiveElectricityQuotesUI()

	{

		String textinUI = browser.getText(
		        pageProperties.getProperty("GetAQuote.QuoteMonth")).trim();
		monthlyQuote = Double.parseDouble(textinUI.substring(1, textinUI.length()));
		textinUI = browser.getText(pageProperties.getProperty("GetAQuote.QuoteAnnual"))
		        .trim();
		annualQuote = Double.parseDouble(textinUI.substring(1, textinUI.length()));
		textinUI = browser.getTextByXpath(
		        pageProperties.getProperty("GetAQuote.ElecQuoteUnitcharge")).trim();
		textinUI = textinUI.replace(
		        pageProperties.getProperty("GetAQuote.UnitChargeSuffixText"), "").trim();
		unitCharge = Double.parseDouble(textinUI);
		int unitRateCount = browser.getChildElementsCountByXpath(pageProperties
		        .getProperty("GetAQuote.StandardChargeXPath"));
		if (unitRateCount == 3) {
			containsNightRate = true;
			textinUI = browser.getTextByXpath(
			        pageProperties.getProperty("GetAQuote.NightChargeXPath")).trim();
			textinUI = textinUI.replaceAll(
			        pageProperties.getProperty("GetAQuote.UnitChargeSuffixText"), "")
			        .trim();
			nightUnitCharge = Double.parseDouble(textinUI);

			textinUI = browser.getTextByXpath(
			        pageProperties.getProperty("GetAQuote.DualStandardCharge_NightXPath"))
			        .trim();
			textinUI = textinUI
			        .replace(
			                pageProperties
			                        .getProperty("GetAQuote.StaindingChargeSuffixText"),
			                "").trim();
			standingCharge = Double.parseDouble(textinUI);

		} else if (unitRateCount == 2) {
			textinUI = browser.getTextByXpath(
			        pageProperties.getProperty("GetAQuote.ElecQuoteStandingCharge"))
			        .trim();
			textinUI = textinUI
			        .replace(
			                pageProperties
			                        .getProperty("GetAQuote.StaindingChargeSuffixText"),
			                "").trim();
			standingCharge = Double.parseDouble(textinUI);
		}

		textinUI = browser.getTextByXpath(
		        pageProperties.getProperty("GetAQuote.ElecConsumpAnnual")).trim();
		textinUI = textinUI.replace(
		        pageProperties.getProperty("GetAQuote.ElecAnnualConsumpSuffixText"), "")
		        .trim();
		if (textinUI.contains(",")) {
			textinUI = textinUI.replaceAll(",", "");
		}
		annualConsumption = Double.parseDouble(textinUI);

	}


	public void retreiveDualQuotesUI()

	{
		String textinUI = browser.getText(
		        pageProperties.getProperty("GetAQuote.QuoteMonth")).trim();
		monthlyQuote = Double.parseDouble(textinUI.substring(1, textinUI.length()));
		textinUI = browser.getText(pageProperties.getProperty("GetAQuote.QuoteAnnual"))
		        .trim();
		annualQuote = Double.parseDouble(textinUI.substring(1, textinUI.length()));
		textinUI = browser.getTextByXpath(
		        pageProperties.getProperty("GetAQuote.DualElecUnitcharge")).trim();
		textinUI = textinUI.replace(
		        pageProperties.getProperty("GetAQuote.UnitChargeSuffixText"), "").trim();
		unitCharge = Double.parseDouble(textinUI);
		int unitRateCount = browser.getChildElementsCountByXpath(pageProperties
		        .getProperty("GetAQuote.DualStandardChargeXPath"));
		if (unitRateCount == 3) {
			containsNightRate = true;
			textinUI = browser.getTextByXpath(
			        pageProperties.getProperty("GetAQuote.DualNightChargeXPath")).trim();
			textinUI = textinUI.replaceAll(
			        pageProperties.getProperty("GetAQuote.UnitChargeSuffixText"), "")
			        .trim();
			nightUnitCharge = Double.parseDouble(textinUI);

			textinUI = browser.getTextByXpath(
			        pageProperties.getProperty("GetAQuote.StandardCharge_NightXPath"))
			        .trim();
			textinUI = textinUI
			        .replace(
			                pageProperties
			                        .getProperty("GetAQuote.StaindingChargeSuffixText"),
			                "").trim();
			standingCharge = Double.parseDouble(textinUI);

		} else if (unitRateCount == 2) {
			textinUI = browser.getTextByXpath(
			        pageProperties.getProperty("GetAQuote.DualStandardCharge")).trim();
			textinUI = textinUI
			        .replace(
			                pageProperties
			                        .getProperty("GetAQuote.StaindingChargeSuffixText"),
			                "").trim();
			standingCharge = Double.parseDouble(textinUI);
		}

		textinUI = browser.getTextByXpath(
		        pageProperties.getProperty("GetAQuote.DualElecConsumpAnnual")).trim();
		textinUI = textinUI.replace(
		        pageProperties.getProperty("GetAQuote.ElecAnnualConsumpSuffixText"), "")
		        .trim();
		if (textinUI.contains(",")) {
			textinUI = textinUI.replaceAll(",", "");
		}
		annualConsumption = Double.parseDouble(textinUI);

		textinUI = browser.getTextByXpath(pageProperties
		        .getProperty("GetAQuote.DualGasStandingcharge"));
		textinUI = textinUI.replaceAll(
		        pageProperties.getProperty("GetAQuote.StaindingChargeSuffixText"), "")
		        .trim();
		gasStandingCharge = Double.parseDouble(textinUI);

		textinUI = browser.getTextByXpath(pageProperties
		        .getProperty("GetAQuote.DualGasUnitcharge"));
		textinUI = textinUI.replaceAll(
		        pageProperties.getProperty("GetAQuote.UnitChargeSuffixText"), "").trim();
		gasUnitCharge = Double.parseDouble(textinUI);

		textinUI = browser.getTextByXpath(pageProperties
		        .getProperty("GetAQuote.DualGasConsumpAnnual"));
		textinUI = textinUI.replaceAll(
		        pageProperties.getProperty("GetAQuote.ElecAnnualConsumpSuffixText"), "")
		        .trim();
		textinUI = textinUI.replace(",", "");
		gasAnnualConsumption = Double.parseDouble(textinUI);

	}

	/*
	 * *****************************************************************************
	 * Method :calculateQuoteForGasquote Created On:01/30/2011 Description:This
	 * method clicks the Calculate button while doing Gas quote
	 * ******************
	 * ***********************************************************
	 */
	public GetAQuoteAction calculateQuoteForGasquote() {
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.GasCalculateQuote"))) {
			browser.clickWithXpath(pageProperties
			        .getProperty("GetAQuote.GasCalculateQuote"));
			browser.wait(getWaitTime());
			Report.updateTestLog("CalculateQuote image  exist", "PASS");
		} else {
			Report.updateTestLog("CalculateQuote image does not exist", "FAIL");
		}
		return new GetAQuoteAction();
	}

	/*
	 * *****************************************************************************
	 * Method :calculateQuoteForDualquote Created On:01/30/2011 Description:This
	 * method clicks the Calculate button while doing Dual quote
	 * *****************
	 * ************************************************************
	 */
	public GetAQuoteAction calculateQuoteForDualquote() {
		if (browser.isElementVisibleWithXpath(pageProperties
		        .getProperty("GetAQuote.DualCalculateQuote"))) {
			browser.wait(getWaitTime());
			browser.clickWithXpath(pageProperties
			        .getProperty("GetAQuote.DualCalculateQuote"));
			Report.updateTestLog("CalculateQuote image  exist", "PASS");
		} else {
			Report.updateTestLog("CalculateQuote image does not exist", "FAIL");
		}
		return new GetAQuoteAction();
	}
	
}
