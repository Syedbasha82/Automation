package bg.framework.app.functional.page.reFactoring;

import bg.framework.app.functional.page.common.BasePage;

import java.util.List;
import java.util.Properties;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.entities.Slinshot.CompareTariff;
import bg.framework.app.functional.entities.Acquisition;

import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.*;
import com.thoughtworks.xstream.io.xml.*;

import org.openqa.selenium.support.ui.Select;

import java.util.Random;

import bg.framework.app.functional.entities.Slinshot.PostCodeRegion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SEGetAQuotePage extends BasePage {

	private final static String File_RegPage = "resources/ReFactoring/SEGetAQuote.properties";
	private static Properties SEGetAquoteProperties = new PropertyLoader(File_RegPage).load();
	
	float DayUnitXML;
	float NightUnitXML;
	float StandingchargeEconomyXML;
	float DiscountchargeXML;
	float StandardunitrateXML;
	float StandingchargeXML;
	float EstimatedannualcostXML;
	String PenaltyXML;
	String DuelfueldiscountXML;
	float TCRXML;
	String TariffNameXML;
	String TariffTypeXML;
	
	public void navigateToSEGetAquotePage () {

		browser.open(ApplicationConfig.APP_BG_URL+"/GetAQuote/#/details");
		browser.wait(2000);
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		}
	
	public void enterPostCodeNew(CompareTariff CompareTariff,UserProfile userProfile){
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		System.out.println("NBNEBNERN");
		/*String region1 = postCode;
		String Region = new PostCodeRegion().getPostcode(region1);*/
		
		//String ValidatePostcoderegion = CompareTariff.getRegion();
		//String PostCode = CompareTariff.getRegioncode();
		
		
		
		String valuidatePassRegionCode = CompareTariff.getRegioncode();
		System.out.println("FWEWEFWEGWEGWER");
		//System.out.println("Print the value of the Post code for the XML = "+ValidatePostcoderegion);
		
			//Report.updateTestLog("Post code Region *******************" + ValidatePostcoderegion  + "**********************", "Pass");
			//Report.updateTestLog("Post code  *******************" + valuidatePassRegionCode  + "**********************", "Pass");
			System.out.println("Printing the regions" );
			verifyAndInputByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.PostCode"),"Post Code", CompareTariff.getRegioncode());
			System.out.println("POOOOOOOOOOOOOOOOOOOSSSSSSSSSSSSTTTTTTTTTTTTTTT");
			verifyAndInputByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.TelephoneNumber"),"Telephone Number", userProfile.getMobileNumber());
		
	}
	
	public void VerifyFuelStatus(UserProfile userProfile,CompareTariff CompareTariff) {
		browser.wait(2000);
			System.out.println("NNNNNNNNNNNNNNNNGDFGDFGDFGF");
			if(CompareTariff.getDualFuel().contains("Y")){
				browser.wait(5000);
				DuelFuel(userProfile,CompareTariff);
				browser.wait(2000);
				
			}
			else
			{
				browser.wait(5000);
				System.out.println("Go To single fuel Account");
				SingleFuel(CompareTariff);
			}
			
		}
	
	public void DuelFuel(UserProfile userProfile,CompareTariff CompareTariff) {
		browser.wait(2000);
		verifyAndClickWithXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.GasandElectricity"), "Duel Fuel quote");
		browser.wait(2000);
		System.out.println("Verifying the Propotion Code#$%^^$%^$%^%$%^$%^");
		
		String PropCode = CompareTariff.getPropositionCode();
		String PropCodefinal = PropCode.substring(0, 1);
		
		System.out.println("************************"+PropCodefinal);
		if(PropCodefinal.contains("E")){
		
		//if(CompareTariff.getPropositionCode().contains("EJD")){
			browser.wait(5000);
			System.out.println("DDDDDDDDDDDDDDIIIIII1010101WWWWWWWWWWWWW");
		if(CompareTariff.getNOR().contains("0002"))
		{
			System.out.println("SEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLL");
			browser.wait(2000);
			Payenergy(CompareTariff);
			browser.wait(2000);
			Economymeterselect(CompareTariff);
			
			verifyAndInputByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.GasUsage"),"Gas consumption", userProfile.getGasconsumptionvalue());
			verifyAndInputByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.ElectricityUsage"),"Elect consumption", userProfile.getElectconsumptionvalue());
			
			//verifyAndInputByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.GasUsage"),"Gas consumption", "12000");
			//verifyAndInputByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.ElectricityUsage"),"Elect consumption", "3100");
			QuoteButton();
			browser.wait(5000);
			Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
			clickDuelElectInfo(CompareTariff);
			verifyPricingElect(CompareTariff);
			closeTariff();
			RefreshPage();
		
		}
		else if(CompareTariff.getNOR().contains("0001"))
		{
			System.out.println("00000001111111111SEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLL");
			Economymeter(CompareTariff);
			browser.wait(2000);
			Payenergy(CompareTariff);
			
			verifyAndInputByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.GasUsage"),"Gas consumption", userProfile.getGasconsumptionvalue());
			verifyAndInputByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.ElectricityUsage"),"Elect consumption", userProfile.getElectconsumptionvalue());
			
			/*verifyAndInputByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.GasUsage"),"Gas consumption", "12000");
			verifyAndInputByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.ElectricityUsage"),"Elect consumption", "3100");*/
			QuoteButton();
			browser.wait(5000);
			Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
			clickDuelElectInfo(CompareTariff);
			verifyPricing(CompareTariff);
			closeTariff();
			RefreshPage();
					
		}
	}
		
		System.out.println("************************"+PropCodefinal);
		if(PropCodefinal.contains("G")){
				
		//else if(CompareTariff.getPropositionCode().contains("GJD")){
			browser.wait(5000);
			System.out.println("GGGGGGGGGGGGGGGGGII1010101WWWWWWWWWWWWW");
		if(CompareTariff.getNOR().contains("0002"))
		{
			System.out.println("SEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLL");
			Economymeterselect(CompareTariff);
			browser.wait(2000);
			Payenergy(CompareTariff);
			
			verifyAndInputByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.GasUsage"),"Gas consumption", userProfile.getGasconsumptionvalue());
			verifyAndInputByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.ElectricityUsage"),"Elect consumption", userProfile.getElectconsumptionvalue());
			
			/*verifyAndInputByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.GasUsage"),"Gas consumption", "12000");
			verifyAndInputByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.ElectricityUsage"),"Elect consumption", "3100");*/
			//verifyAndClickWithXpath(SEGetAquoteProperties.getProperty("GetAQuotePage.Nothanks"), "No Thanks");
			QuoteButton();
			Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
			clickDuelGasInfo(CompareTariff);
			verifyPricing(CompareTariff);
			closeTariff();
			RefreshPage();
			/*clickDuelElectInfo(CompareTariff);
			verifyPricingElect(CompareTariff);
			closeTariff();*/
		
		}
		else if(CompareTariff.getNOR().contains("0001"))
		{
			System.out.println("00000001111111111SEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLL");
			Economymeter(CompareTariff);
			browser.wait(2000);
			Payenergy(CompareTariff);
			browser.wait(2000);
			verifyAndInputByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.GasUsage"),"Gas consumption", userProfile.getGasconsumptionvalue());
			verifyAndInputByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.ElectricityUsage"),"Elect consumption", userProfile.getElectconsumptionvalue());
			
			/*verifyAndInputByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.GasUsage"),"Gas consumption", "12000");
			verifyAndInputByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.ElectricityUsage"),"Elect consumption", "3100");*/
			//verifyAndClickWithXpath(SEGetAquoteProperties.getProperty("GetAQuotePage.Nothanks"), "No Thanks");

			
			QuoteButton();
			Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
			clickDuelGasInfo(CompareTariff);
			verifyPricing(CompareTariff);
			closeTariff();
			RefreshPage();
			
					
		}
	}
		
	}
	
public void SingleFuel(CompareTariff CompareTariff) {
		
	String PropCode = CompareTariff.getPropositionCode();
	String PropCodefinal = PropCode.substring(0, 1);
	
	System.out.println("************************"+PropCodefinal);
	if(PropCodefinal.contains("E")){	
	
	//if(CompareTariff.getPropositionCode().contains("EHM")){
			browser.wait(5000);
			System.out.println("NEWWWWWW010101010101010101WWWWWWWWWWWWW");
			verifyAndClickWithXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.Electricity"), "Electricity quote");
			browser.wait(2000);
			if(CompareTariff.getNOR().contains("0002"))
			{
				System.out.println("SEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLL");
				Economymeterselect(CompareTariff);
				browser.wait(2000);
				Payenergy(CompareTariff);
				verifyAndInputByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.ElectricityUsage"),"Elect consumption", CompareTariff.getAnnualConsumption());
				QuoteButton();
				Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
				clickInfo(CompareTariff);
				verifyPricingElect(CompareTariff);
				closeTariff();
				RefreshPage();
			
			}
			if(CompareTariff.getNOR().contains("0001"))
			{
				System.out.println("00000001111111111SEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLL");
				Economymeter(CompareTariff);
				browser.wait(2000);
				Payenergy(CompareTariff);
				verifyAndInputByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.ElectricityUsage"),"Elect consumption", CompareTariff.getAnnualConsumption());
				QuoteButton();
				Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
				clickInfo(CompareTariff);
				verifyPricing(CompareTariff);
				closeTariff();	
				RefreshPage();
			}
			
		}
	else if (PropCodefinal.contains("G")){	
	//else if(CompareTariff.getPropositionCode().contains("GHM")){
			browser.wait(3000);
			//GasQuoteVerification(CompareTariff);
			System.out.println("HELLLLLLLLLLLLLLO");
			verifyAndClickWithXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.Gas"), "Gas quote");
			Payenergy(CompareTariff);
			verifyAndInputByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.GasUsage"),"Gas consumption", CompareTariff.getAnnualConsumption());
			QuoteButton();
			Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
			clickInfo(CompareTariff);
			verifyPricing(CompareTariff);
			closeTariff();
			RefreshPage();
		}
		
	}
	
	public void Economymeterselect(CompareTariff CompareTariff) {
		
		System.out.println("DONNNNNNNNNNNNNNNEEEEEEEEEEEE");
		
	System.out.println("ECCCOOOOOOONNNNNNNNN");
	browser.wait(2000);
	if(CompareTariff.getNOR().equals("0002"))
	{	
		if(browser.isCheckBoxSelectedWithXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.Economy7")))
		{
			System.out.println("checkbox is Already Selected");
		}else{
				System.out.println("It should not select");
				browser.clickWithXpath((SEGetAquoteProperties.getProperty("SEGetAQuote.Economy7")));
		}
	
		
	}
		
	}
	
public void Economymeter(CompareTariff CompareTariff) {
		
		System.out.println("DEEEEEEEEEEEE");
		
	System.out.println("ECCCOOOMMMMMMMMMMMMM");
	browser.wait(2000);
			
		if(browser.isCheckBoxSelectedWithXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.Economy7")))
		{
			browser.clickWithXpath((SEGetAquoteProperties.getProperty("SEGetAQuote.Economy7")));
		}
	else
		{
			System.out.println("It is not selected");
			
		}
	}

	public void clickInfo(CompareTariff CompareTariff){
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		//verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.MoreInfoNew"), "More Info");
		verifyAndClickWithXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.FuelMoreInfo").replace("TariffName", CompareTariff.getTariff()), "More Info");
		
		browser.wait(getWaitTime());
	}
public void Payenergy(CompareTariff CompareTariff) {
		
		if(CompareTariff.getPaymentOption().contains("Direct debit - VDD")){
			browser.wait(5000);
			System.out.println("Direct Debit");
			//browser.clickWithCss(SEGetAquoteProperties.getProperty("SEGetAQuote.MonthlyDD01"));
			
		}
		else if(CompareTariff.getPaymentOption().contains("Cash or Cheque")){
			browser.wait(5000);
			System.out.println("Cash Or Cheque");
			browser.clickWithCss(SEGetAquoteProperties.getProperty("SEGetAQuote.CashOrCheque01"));
			//verifyAndClickWithXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.CashOrCheque01"),"Cash Or Cheque");
		}
		
	}
	
	
public void QuoteButton() {
	browser.wait(getWaitTime());
	browser.clickWithCss(SEGetAquoteProperties.getProperty("SEGetAQuote.UpdateQuote01"));
	
}

public void clickDuelElectInfo(CompareTariff CompareTariff){
	browser.wait(getWaitTime());
	browser.wait(getWaitTime());
	browser.wait(getWaitTime());
	browser.wait(getWaitTime());
	browser.wait(getWaitTime());
	verifyAndClickWithXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.duelElectFuelMoreInfo").replace("TariffName", CompareTariff.getTariff()), "Duel Elect More Info");
	browser.wait(getWaitTime());
	Report.updateTestLog("******************* Verify Elect Pricing **********************", "Pass");
}

public void verifyPricingElect(CompareTariff CompareTariff) {
	browser.wait(getWaitTime());

	String Estimatedannualcost= "";
	String Assumedannualconsumption ="";
	String Discountcharge="";
	String StandingchargeEconomy= "";
	String DayUnit ="";
	String NightUnit ="";
	String TariffName ="";
	String PaymentOption ="";
	String TCREconomy7 ="";
	String Penalty = "";
	String Discountcharges = "";
	String DuelfueldiscountInput ="";
	float EstimatedannualcostInput;
	float AssumedannualconsumptionInput;
	float DayUnitInput;
	float NightUnitInput;
	float StandingchargeEconomyInput;
	float TCRElectInput;
	String TariffNameInput="";
	
	
	
	DecimalFormat df=new DecimalFormat("0.00");
	
	    
			//////////////////////////////////////////////////////Verify Tariff Name //////////////////////////////////////////////////////////////////////////////////////
				
			if (browser.isElementVisibleWithXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.TariffName")))
			{
			TariffName =browser.getTextByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.TariffName"));
			Report.updateTestLog("Tariff Name in App= "+TariffName, "PASS");
			System.out.println("Tariff Name in App= "+TariffName);
			

			TariffNameInput = CompareTariff.getTariff(); 
			TariffNameXML = TariffNameInput;
			System.out.println("Tariff Name in XML"+ TariffNameXML);
			Report.updateTestLog("Tariff Name in XML= "+TariffNameXML, "PASS");
			if (TariffName.contains(TariffNameXML+"")){
			Report.updateTestLog("Tariff Name Matches with Input and Application Expected : " + TariffNameXML + " Displayed : " + TariffName , "PASS");
			}
			else {
			Report.updateTestLog("Tariff Comparison Rate Price displayed wrongly Expected : " + TariffNameXML + " Displayed : " + TariffName  , "FAIL");
			}
			}
	
			//////////////////////////////////////////////////////Verify Payment Method //////////////////////////////////////////////////////////////////////////////////////
						
			if (browser.isElementVisibleWithXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.Paymentmethod")))
			{
			PaymentOption =browser.getTextByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.Paymentmethod"));
			Report.updateTestLog("Payment method in App= "+PaymentOption, "PASS");
			System.out.println("Payment method in App= "+PaymentOption);
			
			if(CompareTariff.getPaymentOption().contains("Direct debit - VDD"))
			{
				if(PaymentOption.contains("Monthly Direct Debit"))
				{
					Report.updateTestLog("Payment Method Matches with Input and Application Expected : " + PaymentOption + " Displayed : " + CompareTariff.getPaymentOption() , "PASS");
				}
				else {
				Report.updateTestLog("Payment Method displaying wrongly : " + PaymentOption + " Displayed : " + CompareTariff.getPaymentOption()  , "FAIL");
				}	
					
				}
				
			}
			
			
//////////////////////////**********************  Verify Day Unit Price **********************  ///////////////////////////////////////////////
		if (browser.isElementVisibleWithXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.DayUnit")))
		{
			DayUnit=browser.getTextByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.DayUnit"));
			Report.updateTestLog("Day Unit Price in App= "+DayUnit, "PASS");
			System.out.println("Day Unit Price in App= "+DayUnit);
			DayUnitInput = ((Float.valueOf(CompareTariff.getRegister1Price()))); 
			DayUnitXML = Float.parseFloat(df.format(DayUnitInput));
			System.out.println("Day Unit Price in XML"+ DayUnitXML);
			Report.updateTestLog("Day Unit Price in XML= "+DayUnitXML, "PASS");
			if (DayUnit.contains(DayUnitXML+"")){
				Report.updateTestLog("Day Unit Price Matches with Input and Application Expected : " + DayUnitXML + " Displayed : " + DayUnit , "PASS");
			}
			else {
				Report.updateTestLog("Day Unit Price displayed wrongly Expected : " + DayUnitXML + " Displayed : " + DayUnit  , "FAIL");
			}
	}
//////////////////////////**********************  Verify Night Unit Price **********************  ///////////////////////////////////////////////
		if (browser.isElementVisibleWithXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.NightUnit")))
		{
			NightUnit=browser.getTextByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.NightUnit"));
			Report.updateTestLog("Night Unit Price in App= "+NightUnit, "PASS");
			System.out.println("Night Unit Price in App= "+NightUnit);
			NightUnitInput = ((Float.valueOf(CompareTariff.getRegister2Price()))); 
			NightUnitXML = Float.parseFloat(df.format(NightUnitInput));
			System.out.println("Night Unit Price in XML"+ NightUnitXML);
			Report.updateTestLog("Night Unit Price in XML= "+NightUnitXML, "PASS");
			if (NightUnit.contains(NightUnitXML+"")){
				Report.updateTestLog("Night Unit Price Matches with Input and Application Expected : " + NightUnitXML + " Displayed : " + NightUnit , "PASS");
			}
			else {
				Report.updateTestLog("Night Unit Price displayed wrongly Expected : " + NightUnitXML + " Displayed : " + NightUnit  , "FAIL");
			}
	}
//////////////////////////**********************  Verify Standing Charge **********************  ///////////////////////////////////////////////
		if (browser.isElementVisibleWithXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.StandingChargeEconomy7")))
		{
			StandingchargeEconomy=browser.getTextByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.StandingChargeEconomy7"));
			Report.updateTestLog("Standing Charge Economy Price in App= "+StandingchargeEconomy, "PASS");
			System.out.println("Standing Charge Economy Price in App= "+StandingchargeEconomy);
			StandingchargeEconomyInput = ((Float.valueOf(CompareTariff.getStandingCharge()))); 
			StandingchargeEconomyXML = Float.parseFloat(df.format(StandingchargeEconomyInput));
			System.out.println("Standing Charge Economy Price in XML"+ StandingchargeEconomyXML);
			Report.updateTestLog("Standing Charge Economy Price in XML= "+StandingchargeEconomyXML, "PASS");
			if (StandingchargeEconomy.contains(StandingchargeEconomyXML+"")){
				Report.updateTestLog("Standing charge Economy Price Matches with Input and Application Expected : " + StandingchargeEconomyXML + " Displayed : " + StandingchargeEconomy , "PASS");
			}
			else {
				Report.updateTestLog("Standing charge Economy Price displayed wrongly Expected : " + StandingchargeEconomyXML + " Displayed : " + StandingchargeEconomy  , "FAIL");
			}
	}
		
//////////////////////////**********************  Verify Estimated Annual Cost ( Annualy)  **********************  ///////////////////////////////////////////////
		
		if (browser.isElementVisibleWithXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.ECAAnnually")))
		{
		Estimatedannualcost =browser.getTextByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.ECAAnnually"));
		Report.updateTestLog("Estimated Annual cost Price ( Annually) in App= "+Estimatedannualcost, "PASS");
		System.out.println("Estimated Annual cost Price ( Annually) in App= "+Estimatedannualcost);
		
		//String ValidatePostcoderegion = CompareTariff.getRegion();
		//String PostCode = CompareTariff.getRegioncode();
		
		EstimatedannualcostInput = ((Float.valueOf(CompareTariff.getEstimatedAnnualCost()))); 
		EstimatedannualcostXML = Float.parseFloat(df.format(EstimatedannualcostInput));
		System.out.println("Estimated Annual cost Price ( Annually) in XML"+ EstimatedannualcostXML);
		Report.updateTestLog("Estimated Annual cost Price ( Annually) in XML= "+EstimatedannualcostXML, "PASS");
		if (Estimatedannualcost.contains(EstimatedannualcostXML+"")){
		Report.updateTestLog("Estimated Annual cost Price ( Annually) Matches with Input and Application Expected : " + EstimatedannualcostXML + " Displayed : " + Estimatedannualcost , "PASS");
		}
		else {
		Report.updateTestLog("Estimated Annual cost Price ( Annually) displayed wrongly Expected : " + EstimatedannualcostXML + " Displayed : " + Estimatedannualcost  , "FAIL");
		}
	}	
		
		
			//////////////////////////////////////////////////////Verify Penalty//////////////////////////////////////////////////////////////////////////////////////		
					
		if (browser.isElementVisibleWithXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.PenaltyEconomy7")))
		{
		Penalty =browser.getTextByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.PenaltyEconomy7"));
		Report.updateTestLog("Penalty Price in App= "+Penalty, "PASS");
		System.out.println("Penalty Price ="+ Penalty);
		/*penaltyInput = ((Float.valueOf(CompareTariff.getPenalty())));
		PenaltyXML = Float.parseFloat(df.format(penaltyInput));*/
		PenaltyXML = CompareTariff.getPenalty();;
		System.out.println("Penalty Price in XML"+ PenaltyXML);
		Report.updateTestLog("Penalty Price in XML= "+PenaltyXML, "PASS");
		if (Penalty.contains(PenaltyXML+"")){
		Report.updateTestLog("Penalty Price Matches with Input and Application Expected : " + PenaltyXML + " Displayed : " + Penalty , "PASS");
		}
		else {
		Report.updateTestLog("Penalty Price displayed wrongly Expected : " + PenaltyXML + " Displayed : " + Penalty  , "FAIL");
		}
		}
	
//////////////////////////********************** Verify TCR Price **********************  ///////////////////////////////////////////////
		
		if (browser.isElementVisibleWithXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.TCREconomy7")))
		{
			TCREconomy7=browser.getTextByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.TCREconomy7"));
			Report.updateTestLog("TCR Price in App= "+TCREconomy7, "PASS");
			System.out.println("TCR Price  in App= "+NightUnit);
			
			if (TCREconomy7.contains("Not applicable")){
				Report.updateTestLog("Economy7 Price Matches with Input and Application Expected : " + "Not applicable" + " Displayed : " + TCREconomy7 , "PASS");
			}
			else {
				Report.updateTestLog("Economy7 Price displayed wrongly Expected : " + "Not applicable" + " Displayed : " + TCREconomy7  , "FAIL");
			}
	}
		
//////////////////////////********************** Verify Discount Charge **********************  ///////////////////////////////////////////////
		
		if (browser.isElementVisibleWithXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.DiscountsEconomy7")))
		{
		Discountcharges =browser.getTextByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.DiscountsEconomy7"));
		Report.updateTestLog("Discount Charges in App= "+Discountcharges, "PASS");
		System.out.println("Discount Charges ="+ Discountcharges);
		//DuelfueldiscountInput = ((Float.valueOf(CompareTariff.getDualFuelDiscount())));
		//DuelfueldiscountXML = Float.parseFloat(df.format(DuelfueldiscountInput));
		DuelfueldiscountInput = CompareTariff.getDualFuelDiscount(); 
		DuelfueldiscountXML = DuelfueldiscountInput;
		
		System.out.println("Discount Price in XML"+ DuelfueldiscountXML);
		Report.updateTestLog("Discount Price in XML= "+DuelfueldiscountXML, "PASS");
		if (Discountcharges.contains(DuelfueldiscountXML+"")){
		Report.updateTestLog("Discount Price Matches with Input and Application Expected : " + DuelfueldiscountXML + " Displayed : " + Discountcharges , "PASS");
		}
		else {
		Report.updateTestLog("Discount Price displayed wrongly Expected : " + DuelfueldiscountXML + " Displayed : " + Discountcharges  , "FAIL");
		}
		}
		
		
}
public void closeTariff(){
	browser.wait(getWaitTime());
	verifyAndClickWithXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.closebutton"), "Close button");
	browser.wait(getWaitTime());
}


public void RefreshPage(){
	browser.wait(getWaitTime());
	browser.refreshpage();
	browser.wait(getWaitTime());
}


public void verifyPricing(CompareTariff CompareTariff){
	browser.wait(getWaitTime());

	String Standardunitrate = "";
	String Standingcharge= "";
	String Estimatedannualcost= "";
	String TCR= "";
	String Assumedannualconsumption ="";
	String TariffName ="";
	String TariffType ="";
	String PaymentOption ="";
	String Penalty = "";
	String Discountcharges = "";
	
	float StandardunitrateInput;
	float StandingchargeInput;
	float penaltyInput;
	float EstimatedannualcostInput;
	float AssumedannualconsumptionInput;
	float TCRInput;
	String TariffNameInput;
	String TarifftypeInput;
	String DuelfueldiscountInput;
	
	
	
	DecimalFormat df=new DecimalFormat("0.00");
	
	//////////////////////////////////////////////////////Verify Standard Unit Rate //////////////////////////////////////////////////////////////////////////////////////
	
	if (browser.isElementVisibleWithXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.DuelStandardunitrate")))
	{
		Standardunitrate=browser.getTextByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.DuelStandardunitrate"));
		Report.updateTestLog("Standard unit ratePrice in App= "+Standardunitrate, "PASS");
		System.out.println("Standard Unit Rate ="+ Standardunitrate);
		StandardunitrateInput = ((Float.valueOf(CompareTariff.getRegister1Price())));
		StandardunitrateXML = Float.parseFloat(df.format(StandardunitrateInput));
		System.out.println("Standard Unit Price in XML"+ StandardunitrateXML);
		Report.updateTestLog("Standard unit ratePrice in XML= "+StandardunitrateXML, "PASS");
		if (Standardunitrate.contains(StandardunitrateXML+"")){
			Report.updateTestLog("Standard Price Matches with Input and Application Expected : " + StandardunitrateXML + " Displayed : " + Standardunitrate , "PASS");
		}
		else {
			Report.updateTestLog("Standard Price displayed wrongly Expected : " + StandardunitrateXML + " Displayed : " + Standardunitrate  , "FAIL");
		}
		
		//////////////////////////////////////////////////////Verify Standing charge//////////////////////////////////////////////////////////////////////////////////////		
		
		if (browser.isElementVisibleWithXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.DuelStandingcharge")))
		{
			Standingcharge=browser.getTextByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.DuelStandingcharge"));
			Report.updateTestLog("Standard Charge Price in App= "+Standingcharge, "PASS");
			System.out.println("Standard Unit Rate ="+ Standingcharge);
			StandingchargeInput = ((Float.valueOf(CompareTariff.getStandingCharge())));
			StandingchargeXML = Float.parseFloat(df.format(StandingchargeInput));
			System.out.println("Standard Unit Price in XML"+ StandardunitrateXML);
			Report.updateTestLog("Standard unit ratePrice in XML= "+StandingchargeXML, "PASS");
			if (Standingcharge.contains(StandingchargeXML+"")){
				Report.updateTestLog("Standard Charge Price Matches with Input and Application Expected : " + StandingchargeXML + " Displayed : " + Standingcharge , "PASS");
			}
			else {
				Report.updateTestLog("Standard Price displayed wrongly Expected : " + StandingchargeXML + " Displayed : " + Standingcharge  , "FAIL");
			}
	}
		
			//////////////////////////////////////////////////////Verify Penalty//////////////////////////////////////////////////////////////////////////////////////		
					
			if (browser.isElementVisibleWithXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.Penalty")))
			{
			Penalty =browser.getTextByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.Penalty"));
			Report.updateTestLog("Penalty Price in App= "+Penalty, "PASS");
			System.out.println("Penalty Price ="+ Penalty);
			/*penaltyInput = ((Float.valueOf(CompareTariff.getPenalty())));
			PenaltyXML = Float.parseFloat(df.format(penaltyInput));*/
			PenaltyXML = CompareTariff.getPenalty();;
			System.out.println("Penalty Price in XML"+ PenaltyXML);
			Report.updateTestLog("Penalty Price in XML= "+PenaltyXML, "PASS");
			if (Penalty.contains(PenaltyXML+"")){
			Report.updateTestLog("Penalty Price Matches with Input and Application Expected : " + PenaltyXML + " Displayed : " + Penalty , "PASS");
			}
			else {
			Report.updateTestLog("Penalty Price displayed wrongly Expected : " + PenaltyXML + " Displayed : " + Penalty  , "FAIL");
			}
			}
			
		//////////////////////////////////////////////////////Verify Discount charges//////////////////////////////////////////////////////////////////////////////////////		
					
		if (browser.isElementVisibleWithXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.Discountcharges")))
		{
		Discountcharges =browser.getTextByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.Discountcharges"));
		Report.updateTestLog("Discount Charges in App= "+Discountcharges, "PASS");
		System.out.println("Discount Charges ="+ Discountcharges);
		//DuelfueldiscountInput = ((Float.valueOf(CompareTariff.getDualFuelDiscount())));
		//DuelfueldiscountXML = Float.parseFloat(df.format(DuelfueldiscountInput));
		DuelfueldiscountInput = CompareTariff.getDualFuelDiscount(); 
		DuelfueldiscountXML = DuelfueldiscountInput;
		
		System.out.println("Penalty Price in XML"+ DuelfueldiscountXML);
		Report.updateTestLog("Duel Fuel Price in XML= "+DuelfueldiscountXML, "PASS");
		if (Discountcharges.contains(DuelfueldiscountXML+"")){
		Report.updateTestLog("Discount Price Matches with Input and Application Expected : " + DuelfueldiscountXML + " Displayed : " + Discountcharges , "PASS");
		}
		else {
		Report.updateTestLog("Discount Price displayed wrongly Expected : " + DuelfueldiscountXML + " Displayed : " + Discountcharges  , "FAIL");
		}
		}
			
			//////////////////////////////////////////////////////Verify Tariff Name //////////////////////////////////////////////////////////////////////////////////////
					
			if (browser.isElementVisibleWithXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.TariffName")))
			{
			TariffName =browser.getTextByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.TariffName"));
			Report.updateTestLog("Tariff Name in App= "+TariffName, "PASS");
			System.out.println("Tariff Name in App= "+TariffName);
			
			//String ValidatePostcoderegion = CompareTariff.getRegion();
			//String PostCode = CompareTariff.getRegioncode();
			TariffNameInput = CompareTariff.getTariff(); 
			TariffNameXML = TariffNameInput;
			System.out.println("Tariff Name in XML"+ TariffNameXML);
			Report.updateTestLog("Tariff Name in XML= "+TariffNameXML, "PASS");
			if (TariffName.contains(TariffNameXML+"")){
			Report.updateTestLog("Tariff Name Matches with Input and Application Expected : " + TariffNameXML + " Displayed : " + TariffName , "PASS");
			}
			else {
			Report.updateTestLog("Tariff Comparison Rate Price displayed wrongly Expected : " + TariffNameXML + " Displayed : " + TariffName  , "FAIL");
			}
}
//////////////////////////////////////////////////////Verify Estimated Annual Cost//////////////////////////////////////////////////////////////////////////////////////
			
			if (browser.isElementVisibleWithXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.ECAAnnually")))
			{
			Estimatedannualcost =browser.getTextByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.ECAAnnually"));
			Report.updateTestLog("Estimated Annual cost Price ( Annually) in App= "+Estimatedannualcost, "PASS");
			System.out.println("Estimated Annual cost Price ( Annually) in App= "+Estimatedannualcost);
			
			//String ValidatePostcoderegion = CompareTariff.getRegion();
			//String PostCode = CompareTariff.getRegioncode();
			
			EstimatedannualcostInput = ((Float.valueOf(CompareTariff.getEstimatedAnnualCost()))); 
			EstimatedannualcostXML = Float.parseFloat(df.format(EstimatedannualcostInput));
			System.out.println("Estimated Annual cost Price ( Annually) in XML"+ EstimatedannualcostXML);
			Report.updateTestLog("Estimated Annual cost Price ( Annually) in XML= "+EstimatedannualcostXML, "PASS");
			if (Estimatedannualcost.contains(EstimatedannualcostXML+"")){
			Report.updateTestLog("Estimated Annual cost Price ( Annually) Matches with Input and Application Expected : " + EstimatedannualcostXML + " Displayed : " + Estimatedannualcost , "PASS");
			}
			else {
			Report.updateTestLog("Estimated Annual cost Price ( Annually) displayed wrongly Expected : " + EstimatedannualcostXML + " Displayed : " + Estimatedannualcost  , "FAIL");
			}
		}	
			
			
			//////////////////////////////////////////////////////Verify Payment Method //////////////////////////////////////////////////////////////////////////////////////
						
			if (browser.isElementVisibleWithXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.Paymentmethod")))
			{
			PaymentOption =browser.getTextByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.Paymentmethod"));
			Report.updateTestLog("Payment method in App= "+PaymentOption, "PASS");
			System.out.println("Payment method in App= "+PaymentOption);
			
			if(CompareTariff.getPaymentOption().contains("Direct debit - VDD"))
			{
			if(PaymentOption.contains("Monthly Direct Debit"))
			{
			Report.updateTestLog("Payment Method Matches with Input and Application Expected : " + PaymentOption + " Displayed : " + CompareTariff.getPaymentOption() , "PASS");
			}
			else {
			Report.updateTestLog("Tariff Comparison Rate Price displayed wrongly Expected : " + PaymentOption + " Displayed : " + CompareTariff.getPaymentOption()  , "FAIL");
			}	
			
			}
			
			}
	
	//////////////////////////////////////////////////////Verify Tariff comparision Rate //////////////////////////////////////////////////////////////////////////////////////
		
		if (browser.isElementVisibleWithXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.DuelTariffComparisonRate")))
		{
			TCR=browser.getTextByXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.DuelTariffComparisonRate"));
			Report.updateTestLog("Tariff Comparison Rate Price in App= "+TCR, "PASS");
			System.out.println("Tariff Comparison Rate Price in App= "+TCR);
			TCRInput = ((Float.valueOf(CompareTariff.getTariffComparisonRate()))); 
			TCRXML = Float.parseFloat(df.format(TCRInput));
			System.out.println("Tariff Comparison Rate Price in XML"+ TCRXML);
			Report.updateTestLog("Tariff Comparison Rate Price in XML= "+TCRXML, "PASS");
			if (TCR.contains(TCRXML+"")){
				Report.updateTestLog("Tariff Comparison Rate Price Matches with Input and Application Expected : " + TCRXML + " Displayed : " + TCR , "PASS");
			}
			else {
				Report.updateTestLog("Tariff Comparison Rate Price displayed wrongly Expected : " + TCRXML + " Displayed : " + TCR  , "FAIL");
			}
	}
}
	
}

public void clickDuelGasInfo(CompareTariff CompareTariff){
	browser.wait(getWaitTime());
	//verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.DuelGas"), "Duel Gas More Info");
	verifyAndClickWithXpath(SEGetAquoteProperties.getProperty("SEGetAQuote.FuelMoreInfo").replace("TariffName", CompareTariff.getTariff()), "Duel Gas More Info");
	browser.wait(getWaitTime());
	Report.updateTestLog("******************* Verify Gas Pricing **********************", "Pass");
}


}

	
	
	
	
	
	

