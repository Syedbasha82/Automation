package bg.framework.app.functional.page.sales;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.WebElement;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.CompareTariff;
import bg.framework.app.functional.entities.PriceFinderRMR;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class CompareTariffPage extends BasePage {
	
	private int tariffIncrement;
	private String tariff;
	private boolean flag = false;
	

    private final static String FILE_NAME = "resources/sales/CompareTariff.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
    
    public void navigateToGasAndElectricityPage(){ 
	verifyAndClickWithLinkText(pageProperties.getProperty("CompareTariff.GasElectricity"), "Gas and electricity");
    	//browser.open("http://10.224.70.32/content/britishgas/products-and-services/gas-and-electricity.html");
    }
    
    public void navigateToAllTariffPage(){
    	//verifyAndClickWithLinkText(pageProperties.getProperty("CompareTariff.allTariffPage"), "All Tariff Page");
    	//verifyAndClickWithLinkText(pageProperties.getProperty("CompareTariff.tariffInformationDetails"), "Tariff Information Details");
    	browser.open("https://10.224.70.111/products-and-services/gas-and-electricity/our-energy-tariffs/tariff-information.html");
    	//browser.open("https://10.224.70.111/products-and-services/gas-and-electricity/our-energy-tariffs/tariff-information.html");
    	//browser.open("http://10.224.70.32/content/britishgas/products-and-services/gas-and-electricity/our-energy-tariffs/Tariffs-A-Z.html");
    }
    
    public void enterDetailsinAllTariffPage(UserProfile userProfile){
    	verifyAndInputById(pageProperties.getProperty("CompareTariff.allTariffPostCode"),"Post code",userProfile.getPostCode());
        verifyAndSelectDropDownBox(pageProperties.getProperty("CompareTariff.TariffName"), "Tariff Name", "Discount Variable February 2014");
        verifyAndSelectDropDownBox(pageProperties.getProperty("CompareTariff.allTariffPaymentType"), "Payment Type", "Monthly Direct Debit");
        verifyAndClickWithXpath(pageProperties.getProperty("CompareTariff.updateRates"),"update my rates clicked successfully"); 
    }
    
    public void verifyPostCodePrepopulated(UserProfile userProfile){
    	String postCodeOnScr = browser.getTextByXpath(pageProperties.getProperty("CompareTariff.postCodeFeild"));
    	if(postCodeOnScr == userProfile.getPostCode()){
    		Report.updateTestLog("PostCode is verified", "PASS");
    	} else Report.updateTestLog("PostCode is not verified", "FAIL");
    }
	
    public void navigateToCompareTariff(){
    	verifyAndClickWithLinkText(pageProperties.getProperty("CompareTariff.CompareTariffPage"),"Compare Tariff page is clicked successfully");
	}
    
    public void enterPostcode(String custType, UserProfile userProfile, String postCode){
    	if (custType=="Anonymous"){
    		if(browser.isElementVisible(pageProperties.getProperty("CompareTariff.OverlayPostCode"))){
    		browser.wait(2000);
    		verifyAndInputById(pageProperties.getProperty("CompareTariff.OverlayPostCode"),"Overlay Post code",postCode);
    		verifyAndClick(pageProperties.getProperty("CompareTariff.viewResultsButton"),"View Result Button");
    		}
    	}
    	if (custType=="OAM"){
    		verifyAndClick(pageProperties.getProperty("CompareTariff.OverlayLoginButton"),"Login button");
    		new LegacyLoginPage().loginUser(userProfile);
    		navigateToGasAndElectricityPage();
    		navigateToCompareTariff();
    	}
    }
    
    public void verifyCompareTariffPage(String Registers,String tariff, String payment, String postCode,String DualFuel){
    			verifyAndInputByXpath(pageProperties.getProperty("CompareTariff.postCodeFeild"),"post code",postCode);
    			browser.wait(5000);
    			String region1 = postCode;
    			String Region = new TCRCalculationPage().getPostcode(region1);
    			verifyAndSelectDropDownBox(pageProperties.getProperty("CompareTariff.tariff"),"Tariff Name",tariff);
    			if(payment.contains("Direct debit - VDD")){
    				verifyAndSelectDropDownBox(pageProperties.getProperty("CompareTariff.paymentType"),"payment Type","Monthly Direct Debit");
    			}
    			if(payment.contains("Cash or Cheque")){
    				verifyAndSelectDropDownBox(pageProperties.getProperty("CompareTariff.paymentType"),"payment Type","Cash/Cheque");
    			}
    			if(payment.contains("Prepayment")){
    				verifyAndSelectDropDownBox(pageProperties.getProperty("CompareTariff.paymentType"),"payment Type","Prepayment");
    			}
    				selectMeter(Registers);
    				if(DualFuel == "Y"){
    					if(flag == false){
    					verifyAndClickWithXpath(pageProperties.getProperty("CompareTariff.showDualFuel"),"Show Dual Fuel");
    					flag = true;
    					}
    		    	}else if(DualFuel == "N" && flag == true){
    		    		verifyAndClickWithXpath(pageProperties.getProperty("CompareTariff.showDualFuel"),"Show Dual Fuel");
    		    		flag = false;
    		    	}
    				verifyAndClickWithXpath(pageProperties.getProperty("CompareTariff.viewInformation"),"View Tariff Information clicked successfully");
    				verifyTILforTariff(payment,Region,Registers,tariff,postCode,DualFuel);
    			
    		}

    	

    
    
    public void selectMeter(String Registers){
    	if(Registers == "0002"){
    		verifyAndClickWithXpath(pageProperties.getProperty("CompareTariff.economy7"),"Economy 7 is checked in");
    	}
    }
    public void navigateToGAQ(){
    	verifyAndClick(pageProperties.getProperty("CompareTariff.GetAQuoteButton"),"Get a Quote button");
    	Report.updateTestLog("Get A Quote button is clicked successfully", "PASS");
    	if(browser.isTextVisible("Get A Quote")){
    		Report.updateTestLog("Customer is successfully navigated to Get A Quote page", "PASS");
    	}else Report.updateTestLog("Customer is successfully navigated to Get A Quote page", "FAIL");
    }
    
    public void verifyTILforTariff(String payment, String Region, String Registers, String tariff, String postCode,String DualFuel){
    	Report.updateTestLog("*********************    Dual Fuel "+DualFuel+"   **********************", "Pass");	
    	if (Registers == "0002"){
    		verifyTILforElec2RTariff(payment,Region,Registers,tariff,postCode,DualFuel);
    	}
    	else {
    		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CompareTariff.gasTCRValue"))){
    			//verifyTILforGasTariff(payment,Region,Registers,tariff,postCode,DualFuel);
    		}
    		verifyTILforElecSRTariff(payment,Region,Registers,tariff,postCode,DualFuel);
    	}
    	
    }
    
    public void verifyTILforGasTariff(String payment, String Region, String Registers, String tariff,String postCode,String DualFuel){
    	String Fuel = "02";
    	String Region1 = new TCRCalculationPage().getPostcode(postCode);
		String combination = tariff+Fuel+payment+Region1+DualFuel+Registers;
    	String TCRValueOnScr = browser.getTextByXpath(pageProperties.getProperty("CompareTariff.gasTCRValue"));
    	String TCRValue = new TCRCalculationPage().verifyTCRForGasTariff(tariff,combination);
    	System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyy" + TCRValue);
    	if(TCRValueOnScr.contains(TCRValue)){
    		Report.updateTestLog("The TCR value for Gas fuel Tariff Name: " +tariff+ " is displayed: " +TCRValueOnScr+ " and expected Value is: " +TCRValue , "WARN");
    	}else Report.updateTestLog("The TCR value for Gas fuel Tariff Name: " +tariff+ " is displayed: " +TCRValueOnScr+ " and expected Value is: " +TCRValue , "FAIL");
    	///// verify estimated annual cost /////
    	String estimatedCostOnScr = browser.getTextByXpath(pageProperties.getProperty("CompareTariff.estimatedGasValue"));
    	String estimatedAnnualCost = new TCRCalculationPage().verifyPPValue(tariff, combination);
    	if(estimatedCostOnScr.contains(estimatedAnnualCost)){
    		Report.updateTestLog("The Estimated Annual cost for Gas fuel Tariff Name: " +tariff+ " is displayed: " +estimatedCostOnScr+ " and expected Value is: " +estimatedAnnualCost , "PASS");
    	}else{
    		Report.updateTestLog("Error in Estimated Annual cost for Gas fuel Tariff Name: " +tariff+ " is displayed:" +estimatedCostOnScr+ " and expected Value is: " +estimatedAnnualCost , "FAIL");
    	}
    	///// verifying standing charges /////
    	String standingChargeOnScr = browser.getTextByXpath(pageProperties.getProperty("CompareTariff.standingChargeGas"));
    	String standingCharge = new TCRCalculationPage().verifyStandingChargeValue(tariff, combination);
    	/*float standingCharge2 = Float.parseFloat(standingCharge1);
    	DecimalFormat myFormatter = new DecimalFormat("0.00");
    	String standingCharge = myFormatter.format(standingCharge2);*/
    	if(standingChargeOnScr.contains(standingCharge)){
    		Report.updateTestLog("Standing charge value for Gas fuel Tariff Name: " +tariff+ " is displayed: " +standingChargeOnScr+ " and expected Value is: " +standingCharge , "PASS");
    	}else{
    		Report.updateTestLog("Error in Standing charge value for Gas fuel Tariff Name: " +tariff+ " is displayed: " +standingChargeOnScr+ " and expected Value is: " +standingCharge , "FAIL");
    	}
    	
    	///// verifying unit rates /////
    	String untinRatesOnScr = browser.getTextByXpath(pageProperties.getProperty("CompareTariff.unitRatesGas"));
    	String unitRates = new TCRCalculationPage().verifyUnitRates(tariff, combination);
    	if(untinRatesOnScr.contains(unitRates)){
    		Report.updateTestLog("Unit Rates for Gas fuel Tariff Name: " +tariff+ " is displayed: " +untinRatesOnScr+ " and expected Value is: " +unitRates , "PASS");
    	}else{
    		Report.updateTestLog("Error in Unit Rates for Gas fuel Tariff Name: " +tariff+ " is displayed: " +untinRatesOnScr+ " and expected Value is: " +unitRates , "FAIL");
    	}
    }


    public void verifyTILforElecSRTariff(String payment, String Region, String Registers, String tariff,String postCode,String DualFuel) {
    	String Fuel = "01";
    	String Region1 = new TCRCalculationPage().getPostcode(postCode);
		String combination = tariff+Fuel+payment+Region1+DualFuel+Registers;
		System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW" + combination);
    	String TCRValueOnScr = browser.getTextByXpath(pageProperties.getProperty("CompareTariff.elecSRTCRValue"));
    	String TCRValue = new TCRCalculationPage().verifyTCRForElectricitySRTariff(tariff,combination);
    	if(TCRValueOnScr.contains(TCRValue)){
    		Report.updateTestLog("The TCR value for Elctricity fuel Tariff Name:" +tariff+ "is displayed:" +TCRValueOnScr+ "and expected Value is:" +TCRValue , "WARN");
    	}else Report.updateTestLog("The TCR value for Elctricity fuel Tariff Name:" +tariff+ "is displayed:" +TCRValueOnScr+ "and expected Value is:" +TCRValue , "FAIL");
        
    	///// verify estimated annual cost /////
    	String estimatedCostOnScr = browser.getTextByXpath(pageProperties.getProperty("CompareTariff.estimatedElecValue"));
    	String estimatedAnnualCost = new TCRCalculationPage().verifyPPValue(tariff, combination);
    	if(estimatedCostOnScr.contains(estimatedAnnualCost)){
    		Report.updateTestLog("The Estimated Annual cost for Elec fuel Tariff Name: " +tariff+ " is displayed: " +estimatedCostOnScr+ " and expected Value is: " +estimatedAnnualCost , "PASS");
    	}else{
    		Report.updateTestLog("Error in Estimated Annual cost for Elec fuel Tariff Name: " +tariff+ " is displayed:" +estimatedCostOnScr+ " and expected Value is: " +estimatedAnnualCost , "FAIL");
    	}
    	///// verifying standing charges /////
    	String standingChargeOnScr = browser.getTextByXpath(pageProperties.getProperty("CompareTariff.standingChargeElec"));
    	String standingCharge = new TCRCalculationPage().verifyStandingChargeValue(tariff, combination);
    	/*DecimalFormat myFormatter = new DecimalFormat("0.00");
    	float standingCharge2 = Float.parseFloat(standingCharge1);
    	String standingCharge = myFormatter.format(standingCharge2);*/
    	if(standingChargeOnScr.contains(standingCharge)){
    		Report.updateTestLog("Standing charge value for Elec fuel Tariff Name: " +tariff+ " is displayed: " +standingChargeOnScr+ " and expected Value is: " +standingCharge , "PASS");
    	}else{
    		Report.updateTestLog("Error in Standing charge value for Elec fuel Tariff Name: " +tariff+ " is displayed: " +standingChargeOnScr+ " and expected Value is: " +standingCharge , "FAIL");
    	}
    	
    	///// verifying unit rates /////
    	String untinRatesOnScr = browser.getTextByXpath(pageProperties.getProperty("CompareTariff.unitRatesElec"));
    	String unitRates = new TCRCalculationPage().verifyUnitRates(tariff, combination);
    	if(untinRatesOnScr.contains(unitRates)){
    		Report.updateTestLog("Unit Rates for Elec fuel Tariff Name: " +tariff+ " is displayed: " +untinRatesOnScr+ " and expected Value is: " +unitRates , "PASS");
    	}else{
    		Report.updateTestLog("Error in Unit Rates for Elec fuel Tariff Name: " +tariff+ " is displayed: " +untinRatesOnScr+ " and expected Value is: " +unitRates , "FAIL");
    	}
       }

    public void verifyTILforElec2RTariff(String payment, String Region, String Registers, String tariff,String postCode,String DualFuel){
    	String Fuel = "01";
    	String Region1 = new TCRCalculationPage().getPostcode(postCode);
    	///// getting combination for Electricity SR tariffs /////
    	String combination = tariff+Fuel+payment+Region1+DualFuel+Registers;
    	///// getting TCR value on screen /////
    	String TCRValue1 = "N/A";
    	String TCRValueOnScr = browser.getTextByXpath(pageProperties.getProperty("CompareTariff.TCRTariffTIL"));
    	if(TCRValueOnScr.contains(TCRValue1)){
    		Report.updateTestLog("The TCR value for electricity 2R fuel Tariff Name:" +tariff+ "is displayed:" +TCRValueOnScr+ "and expected Value is:" +TCRValue1 , "WARN");
    	}else Report.updateTestLog("Error in TCR value for electricity 2R fuel Tariff Name:" +tariff+ "is displayed:" +TCRValueOnScr+ "and expected Value is:" +TCRValue1 , "FAIL");
       
    ///// verifying standing charges /////
    	String standingChargeOnScr = browser.getTextByXpath(pageProperties.getProperty("CompareTariff.standingChargeElec2R"));
    	String standingCharge = new TCRCalculationPage().verifyStandingChargeValue(tariff, combination);
    	/*DecimalFormat myFormatter = new DecimalFormat("0.00");
    	String standingCharge = myFormatter.format(standingCharge1);*/
    	if(standingChargeOnScr.contains(standingCharge)){
    		Report.updateTestLog("Standing charge value for Elec 2R fuel Tariff Name: " +tariff+ " is displayed: " +standingChargeOnScr+ " and expected Value is: " +standingCharge , "PASS");
    	}else{
    		Report.updateTestLog("Error in Standing charge value for Elec 2R fuel Tariff Name: " +tariff+ " is displayed: " +standingChargeOnScr+ " and expected Value is: " +standingCharge , "FAIL");
    	}
    	
    	///// verifying day unit rates /////
    	String untinRatesOnScr = browser.getTextByXpath(pageProperties.getProperty("CompareTariff.dayUnitRatesElec2R"));
    	String unitRates = new TCRCalculationPage().verifyUnitRates(tariff, combination);
    	if(untinRatesOnScr.contains(unitRates)){
    		Report.updateTestLog("Day Unit Rates for Elec 2R fuel Tariff Name: " +tariff+ " is displayed: " +untinRatesOnScr+ " and expected Value is: " +unitRates , "PASS");
    	}else{
    		Report.updateTestLog("Error in Day Unit Rates for Elec 2R fuel Tariff Name: " +tariff+ " is displayed: " +untinRatesOnScr+ " and expected Value is: " +unitRates , "FAIL");
    	}

    ///// verifying Night unit rates /////
    String untinRatesOnScr2 = browser.getTextByXpath(pageProperties.getProperty("CompareTariff.nightUnitRatesElec2R"));
    String unitRates2 = new TCRCalculationPage().verifyUnitRates2(tariff, combination);
    if(untinRatesOnScr2.contains(unitRates2)){
    	Report.updateTestLog("Night Unit Rates for Elec 2R fuel Tariff Name: " +tariff+ " is displayed: " +untinRatesOnScr2+ " and expected Value is: " +unitRates2 , "PASS");
    }else{
    	Report.updateTestLog("Error in Night Unit Rates for Elec 2R fuel Tariff Name: " +tariff+ " is displayed: " +untinRatesOnScr2+ " and expected Value is: " +unitRates2 , "FAIL");
    }
   }
    
    
 
}
