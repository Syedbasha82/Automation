package bg.framework.app.functional.page.reFactoring;

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


public class SEProductLandingPage extends BasePage {
	
	private final static String File_RegPage = "resources/ReFactoring/SEProductLanding.properties";
	private static Properties SEProductLandingProperties = new PropertyLoader(File_RegPage).load();
	
	float DayUnitXML;
	float NightUnitXML;
	float StandingchargeEconomyXML;
	float EstimatedannualcostXML;
	float DiscountchargeXML;
	float StandardunitrateXML;
	float StandingchargeXML;
	float TCRXML;	
	String AnnualconsumptionXML;
	String PenaltyXML;
	float EstimatedannualcostInputXML;
	String TariffNameXML;
	String DuelfueldiscountXML;
	public static String unitnumbers;
	float AssumedannualconsumptionXML;
	
	public void navigateToSEProductLandingPage() {

		browser.open(ApplicationConfig.APP_BG_URL+"/products-and-services/energy/our-energy-tariffs.html");
		browser.wait(2000);
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		}
	
	public void SelectTariff(CompareTariff CompareTariff) {
		browser.wait(getWaitTime());
		//verifyAndClickWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.SelectTariff").replace("TariffName", CompareTariff.getTariff()), "Tariff");
		verifyAndClickWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.Tarifffinal"),"Tariff Click");
		browser.wait(2000);
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		}
	
	public void enterPostCodeNew(CompareTariff CompareTariff){
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		
		//String ValidatePostcoderegion = CompareTariff.getRegion();
		String PostCode = CompareTariff.getRegioncode();
		//System.out.println("Print the value of the Post code for the XML = "+ValidatePostcoderegion);
//			Report.updateTestLog("Post code Region *******************" + ValidatePostcoderegion  + "**********************", "Pass");
			Report.updateTestLog("Post code  *******************" + PostCode  + "**********************", "Pass");
			System.out.println("Printing the regions" );
			verifyAndInputByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.PostCode"),"Post Code", CompareTariff.getRegioncode());
			System.out.println("POOOOOOOOOOOOOOOOOOOSSSSSSSSSSSSTTTTTTTTTTTTTTT");
		
	}
	
	public void SelectPaymentType(CompareTariff CompareTariff){
		browser.wait(getWaitTime());
		System.out.println("BFEGERGERGB");
		if(CompareTariff.getPaymentOption().equals("Direct debit - VDD"))
		{
			System.out.println("GERTERTERTYERY");
			
			
			//verifyAndSelectDropDownBox(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Paymenttype"),"payment Type","Monthly Direct Debit");
			
		}
		if(CompareTariff.getPaymentOption().equals("Cash or Cheque"))
		{
			System.out.println("NCVNCVNDSDVSD");
			
			System.out.println("Clllllccccikkkeddddddddd");
			browser.wait(1000);
			if(browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.PaymentType")))
			{
				System.out.println("Visssssssssssssble");
				verifyAndSelectDropDownBoxByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.PaymentType"),"payment Type","Cash/Cheque");
			//verifyAndSelectDropDownBox(SECompareTariffProperties.getProperty("CompareTariff.paymentType"),"payment Type","Monthly Direct Debit");
			//verifyAndSelectDropDownBoxbyindex_id(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Paymenttype"),2);
			}
		}
	}
	
	public void VerifyFuelStatus(CompareTariff CompareTariff) {
		browser.wait(2000);
			System.out.println("NNNNNNNNNNNNNNNNGDFGDFGDFGF");
			if(CompareTariff.getDualFuel().contains("Y")){
				browser.wait(5000);
				DuelFuel(CompareTariff);
				browser.wait(2000);
				
			}
			else
			{
				browser.wait(5000);
				System.out.println("Go To single fuel Account");
				SingleFuel(CompareTariff);
				browser.wait(2000);
			}
			
		}
	public void DuelFuel(CompareTariff CompareTariff) {
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
			SelectPaymentType(CompareTariff);
			browser.wait(2000);
			Economymeterselect(CompareTariff);
			DuelFuelPrice(CompareTariff);
			UpdateMyrateButton();
			browser.wait(5000);
			Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
			verifyPricingElect(CompareTariff);
			
			
		
		}
		else if(CompareTariff.getNOR().contains("0001"))
		{
			System.out.println("00000001111111111SEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLL");
			
			browser.wait(2000);
			SelectPaymentType(CompareTariff);
			browser.wait(2000);
			Economymeter(CompareTariff);
			DuelFuelPrice(CompareTariff);
			UpdateMyrateButton();
			browser.wait(5000);
			Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
			verifyElectPricing(CompareTariff);
			
					
		}
	}
		
		else if(PropCodefinal.contains("G")){
		//else if(CompareTariff.getPropositionCode().contains("GJD")){
			browser.wait(5000);
			System.out.println("GGGGGGGGGGGGGGGGGII1010101WWWWWWWWWWWWW");
		if(CompareTariff.getNOR().contains("0002"))
		{
			System.out.println("SEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLL");
			browser.wait(2000);
			SelectPaymentType(CompareTariff);
			browser.wait(2000);
			DuelFuelPrice(CompareTariff);
			browser.wait(2000);
			Economymeterselect(CompareTariff);
			browser.wait(2000);
			UpdateMyrateButton();
			browser.wait(5000);
			Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
			verifyGasPricing(CompareTariff);
			
			
		
		}
		else if(CompareTariff.getNOR().contains("0001"))
		{
			System.out.println("00000001111111111SEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLL");
			browser.wait(2000);
			SelectPaymentType(CompareTariff);
			browser.wait(2000);
			DuelFuelPrice(CompareTariff);
			browser.wait(2000);
			Economymeter(CompareTariff);
			UpdateMyrateButton();
			Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
			verifyGasPricing(CompareTariff);
			
			
					
		}
	}
		
	}
	
	public void Economymeterselect(CompareTariff CompareTariff) {
		
		System.out.println("DONNNNNNNNNNNNNNNEEEEEEEEEEEE");
		
	System.out.println("ECCCOOOOOOONNNNNNNNN");
	browser.wait(2000);
	if(CompareTariff.getNOR().equals("0002"))
	{	
		if(browser.isCheckBoxSelectedWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.Economy7meter")))
		{
			System.out.println("checkbox is Already Selected");
		}else{
				System.out.println("It should not select");
				browser.clickWithXpath((SEProductLandingProperties.getProperty("SEProductLandingPage.Economy7meter")));
		}
	
		
	}
		
	}	
	
	public void DuelFuelPrice(CompareTariff CompareTariff) {
		
		System.out.println("DONNNNNNNNNNNNNNNEEEEEEEEEEEE");
		
	System.out.println("DUEEEEEEEEEEEEELLLLLLLLLL FUUUUUUUUUUUUUUUEEEEEEEEEELLLLLLLLLLLL");
	browser.wait(2000);
	if(CompareTariff.getDualFuel().contains("Y"))
	{	
		if(browser.isCheckBoxSelectedWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.DuelFuel")))
		{
			System.out.println("checkbox is Already Selected");
		}else{
				System.out.println("It should not select");
				browser.clickWithXpath((SEProductLandingProperties.getProperty("SEProductLandingPage.DuelFuel")));
		}
	
		
	}
		
	}

	public void UpdateMyrateButton() {
		browser.wait(getWaitTime());
		//browser.clickWithCss(SEProductLandingProperties.getProperty("SEProductLandingPage.Updatemyrates"));
		verifyAndClickWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.Updatemyrates"), "Tariff Info");
		
	}
	
	 public void verifyPricingElect(CompareTariff CompareTariff) {
			browser.wait(getWaitTime());

			String Estimatedannualcost= "";
			String Assumedannualconsumption ="";
			String Discountcharge="";
			String StandingchargeEconomy= "";
			String Annualconsumption;
			String DayUnit ="";
			String NightUnit ="";
			String TariffName ="";
			String TariffNameInput="";
			float EstimatedannualcostInput;
			float AssumedannualconsumptionInput;
			float DayUnitInput;
			float NightUnitInput;
			float StandingchargeEconomyInput;
			float AnnualconsumptionInput;
			float TCRElectInput;
			String PaymentOption ="";
			String Discountcharges = "";
			String DuelfueldiscountInput ="";
			String Penalty = "";
			float TCRInput;
			String TCR= "";
			DecimalFormat df=new DecimalFormat("0.00");
			
			
			//////////////////////////////////////////////////////Verify Tariff Name //////////////////////////////////////////////////////////////////////////////////////
						
			if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectTariffName")))
			{
			TariffName =browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectTariffName"));
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
			
			if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectPaymentOption")))
			{
			PaymentOption =browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectPaymentOption"));
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
			
			//////////////////////////********************** Verify Discount Charge **********************  ///////////////////////////////////////////////
						
				if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectE7Discountcharges")))
				{
				Discountcharges =browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectE7Discountcharges"));
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
				
			
				//////////////////////////////////////////////////////Verify Penalty//////////////////////////////////////////////////////////////////////////////////////		
								
				if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectE7Penalty")))
				{
				Penalty =browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectE7Penalty"));
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
			
			
		//////////////////////////**********************  Verify Day Unit Price **********************  ///////////////////////////////////////////////
			System.out.println("*******************////////RGERERGERGHERH******************");
			
			if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.Elect7DayUnit")))
			{
				DayUnit=browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.Elect7DayUnit"));
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
			
			if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.Elect7NightUnit")))
			{
				NightUnit=browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.Elect7NightUnit"));
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
			
			
			///////////////////////////////////////////// Verify Estimated Annual cost ///////////////////////////////////////////////////////////////////////////
						
			if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.E7EstimatedAnnualCost")))
			{
			Estimatedannualcost=browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.E7EstimatedAnnualCost"));
			Report.updateTestLog("Estimated Annual Cost in App= "+Estimatedannualcost, "PASS");
			System.out.println("Estimated Annual Cost in App= "+Estimatedannualcost);
			EstimatedannualcostInput = ((Float.valueOf(CompareTariff.getEstimatedAnnualCost()))); 
			EstimatedannualcostXML = Float.parseFloat(df.format(EstimatedannualcostInput));
			System.out.println("Estimated Annual Cost Price in XML"+ EstimatedannualcostXML);
			Report.updateTestLog("Estimated Annual Cost Price in XML= "+EstimatedannualcostXML, "PASS");
			if (Estimatedannualcost.contains("Not applicable")){
			Report.updateTestLog("Estimated Annual Cost Price Matches with Input and Application Expected : " + EstimatedannualcostXML + " Displayed : " + Estimatedannualcost , "PASS");
			}
			else {
			Report.updateTestLog("Estimated Annual Cost displayed wrongly Expected : " + EstimatedannualcostXML + " Displayed : " + Estimatedannualcost  , "FAIL");
			}
			}
			
			///////////////////////////////////////////// Verify annual consumption ///////////////////////////////////////////////////////////////////////////
			if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.E7annualconsumption")))
			{
			Assumedannualconsumption=browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.E7annualconsumption"));
			
			String Assumedannualconsumptionoutput = Assumedannualconsumption.replace(",", "");
			
			
			Report.updateTestLog("Assumed annual consumption Price in App= "+Assumedannualconsumption, "PASS");
			System.out.println("Assumed annual consumption in App= "+Assumedannualconsumption);
			AssumedannualconsumptionInput = ((Float.valueOf(CompareTariff.getAnnualConsumption()))); 
			AssumedannualconsumptionXML = Float.parseFloat(df.format(AssumedannualconsumptionInput));
			
			int Assumedannualconsumptionint = Math.round(AssumedannualconsumptionXML);
			
			
			System.out.println("Assumed annual consumption Price in XML"+ AssumedannualconsumptionXML);
			Report.updateTestLog("Assumed annual consumption Price in XML= "+AssumedannualconsumptionXML, "PASS");
			Report.updateTestLog("Assumed annual consumption Price after round = "+Assumedannualconsumptionint, "PASS");
			//if (Assumedannualconsumption.contains(AssumedannualconsumptionXML+"")){
			if (Assumedannualconsumptionoutput.contains(Assumedannualconsumptionint+"")){
			
			Report.updateTestLog("Assumed Annual Consumption Price Matches with Input and Application Expected : " + AssumedannualconsumptionXML + " Displayed : " + Assumedannualconsumption , "PASS");
			}
			else {
			Report.updateTestLog("Assumed Annual Cost displayed wrongly Expected : " + AssumedannualconsumptionXML + " Displayed : " + Assumedannualconsumption  , "FAIL");
			}
			}
			
			///////////////////////////////////////////// Verify Tariff Comparison Rate ///////////////////////////////////////////////////////////////////////////
			
			if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.E7TariffComparisonRate")))
			{
				TCR=browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.E7TariffComparisonRate"));
				Report.updateTestLog("Tariff Comparison Rate Price in App= "+TCR, "PASS");
				System.out.println("Tariff Comparison Rate Price in App= "+TCR);
				TCRInput = ((Float.valueOf(CompareTariff.getTariffComparisonRate()))); 
				TCRXML = Float.parseFloat(df.format(TCRInput));
				System.out.println("Tariff Comparison Rate Price in XML"+ TCRXML);
				Report.updateTestLog("Tariff Comparison Rate Price in XML= "+TCRXML, "PASS");
				if (TCR.contains("N/A")){
					Report.updateTestLog("Tariff Comparison Rate Price Matches with Input and Application Expected : " + TCRXML + " Displayed : " + TCR , "PASS");
				}
				else {
					Report.updateTestLog("Tariff Comparison Rate Price displayed wrongly Expected : " + TCRXML + " Displayed : " + TCR  , "FAIL");
				}
		}

			
		//////////////////////////**********************  Verify Standing Charge **********************  ///////////////////////////////////////////////
			
			if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.Elect7StandingCharge")))
			{
				StandingchargeEconomy=browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.Elect7StandingCharge"));
				Report.updateTestLog("Standing Charge Economy Price in App= "+DayUnit, "PASS");
				System.out.println("Standing Charge Economy Price in App= "+DayUnit);
				StandingchargeEconomyInput = ((Float.valueOf(CompareTariff.getStandingCharge()))); 
				StandingchargeEconomyXML = Float.parseFloat(df.format(StandingchargeEconomyInput));
				System.out.println("Standing Charge Economy Price in XML"+ DayUnitXML);
				Report.updateTestLog("Standing Charge Economy Price in XML= "+DayUnitXML, "PASS");
				if (StandingchargeEconomy.contains(StandingchargeEconomyXML+"")){
					Report.updateTestLog("Standing charge Economy Price Matches with Input and Application Expected : " + StandingchargeEconomyXML + " Displayed : " + StandingchargeEconomy , "PASS");
				}
				else {
					Report.updateTestLog("Standing charge Economy Price displayed wrongly Expected : " + StandingchargeEconomyXML + " Displayed : " + StandingchargeEconomy  , "FAIL");
				}
		}
	}
	 public void Economymeter(CompareTariff CompareTariff) {
			
			System.out.println("NOOOOOOOOOORRRRRRRRRR00000000000000011111111111111");
		
		browser.wait(2000);
				
			if(browser.isCheckBoxSelectedWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.Economy7meter")))
			{
				browser.clickWithXpath((SEProductLandingProperties.getProperty("SEProductLandingPage.Economy7meter")));
			}
		else
			{
				System.out.println("It is not selected");
				
			}
		}
	 public void verifyElectPricing(CompareTariff CompareTariff){
			browser.wait(getWaitTime());

			String Standardunitrate = "";
			String Standingcharge= "";
			String Estimatedannualcost= "";
			String TCR= "";
			String Assumedannualconsumption ="";
			String TariffName ="";
			String TariffNameInput="";
			float StandardunitrateInput;
			float StandingchargeInput;
			float EstimatedannualcostInput;
			float AssumedannualconsumptionInput;
			float TCRInput;
			String PaymentOption ="";
			String Discountcharges = "";
			String DuelfueldiscountInput ="";
			String Penalty = "";
			String PenaltyXML;
			
			
			DecimalFormat df=new DecimalFormat("0.00");
			
			////////////////////////////////////////////////////// Verify Tariff Name //////////////////////////////////////////////////////////////////////////////////////
						
			if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectTariffName")))
			{
			TariffName =browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectTariffName"));
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
			
			if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectPaymentOption")))
			{
			PaymentOption =browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectPaymentOption"));
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
			
			//////////////////////////********************** Verify Discount Charge **********************  ///////////////////////////////////////////////
			
			if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectDiscountcharges")))
			{
			Discountcharges =browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectDiscountcharges"));
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
			
			
			//////////////////////////////////////////////////////Verify Penalty//////////////////////////////////////////////////////////////////////////////////////		
			
			if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectPenalty")))
			{
			Penalty =browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectPenalty"));
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
			
			//////////////////////////////////////////////////////Verify Standard Unit Rate //////////////////////////////////////////////////////////////////////////////////////
			
			if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectUnitRate")))
			{
				Standardunitrate=browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectUnitRate"));
				Report.updateTestLog("Standard unit ratePrice in App= "+Standardunitrate, "PASS");
				System.out.println("Standard Unit Rate ="+ Standardunitrate);
				StandardunitrateInput = ((Float.valueOf(CompareTariff.getRegister1Price())));
				StandardunitrateXML = Float.parseFloat(df.format(StandardunitrateInput));
				System.out.println("Standard Unit Price in XML"+ StandardunitrateXML);
				Report.updateTestLog("Standard unit ratePrice in XML= "+StandardunitrateXML, "PASS");
				if (Standardunitrate.contains(StandardunitrateXML+"")){
					Report.updateTestLog("Unit Price Matches with Input and Application Expected : " + StandardunitrateXML + " Displayed : " + Standardunitrate , "PASS");
				}
				else {
					Report.updateTestLog("Unit Price displayed wrongly Expected : " + StandardunitrateXML + " Displayed : " + Standardunitrate  , "FAIL");
				}
				
				//////////////////////////////////////////////////////Verify Standing charge//////////////////////////////////////////////////////////////////////////////////////		
				
				if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectStandingCharge")))
				{
					Standingcharge=browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectStandingCharge"));
					Report.updateTestLog("Standard Charge Price in App= "+Standingcharge, "PASS");
					System.out.println("Standard Unit Rate ="+ Standingcharge);
					StandingchargeInput = ((Float.valueOf(CompareTariff.getStandingCharge())));
					StandingchargeXML = Float.parseFloat(df.format(StandingchargeInput));
					System.out.println("Standard Unit Price in XML"+ StandingchargeXML);
					Report.updateTestLog("Standard unit ratePrice in XML= "+StandingchargeXML, "PASS");
					if (Standingcharge.contains(StandingchargeXML+"")){
						Report.updateTestLog("Standard Charge Price Matches with Input and Application Expected : " + StandingchargeXML + " Displayed : " + Standingcharge , "PASS");
					}
					else {
						Report.updateTestLog("Standard Price displayed wrongly Expected : " + StandingchargeXML + " Displayed : " + Standingcharge  , "FAIL");
					}
			}
				
			//////////////////////////////////////////////////////Verify Tariff comparision Rate //////////////////////////////////////////////////////////////////////////////////////
				
				if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectTCRValue")))
				{
					TCR=browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectTCRValue"));
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
				
		//////////////////////////**********************  Verify Assumed annual consumption **********************  ///////////////////////////////////////////////
						
			if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectAssumedannualconsumption")))
			{
				Assumedannualconsumption=browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectAssumedannualconsumption"));
				/*NumberFormat format = NumberFormat.getCurrencyInstance();
				Number number = format.parse(Assumedannualconsumption);*/
				String Assumedannualconsumptionoutput = Assumedannualconsumption.replace(",", "");
				Report.updateTestLog("Assumed annual consumption Price in App= "+Assumedannualconsumption, "PASS");
				System.out.println("Assumed annual consumption in App= "+Assumedannualconsumption);
				AssumedannualconsumptionInput = ((Float.valueOf(CompareTariff.getAnnualConsumption()))); 
				AssumedannualconsumptionXML = Float.parseFloat(df.format(AssumedannualconsumptionInput));
				
				int Assumedannualconsumptionint = Math.round(AssumedannualconsumptionXML);
				
				
				System.out.println("Assumed annual consumption Price in XML"+ AssumedannualconsumptionXML);
				Report.updateTestLog("Assumed annual consumption Price in XML= "+AssumedannualconsumptionXML, "PASS");
				
				Report.updateTestLog("Assumed annual consumption Price after round = "+Assumedannualconsumptionint, "PASS");
				
				if (Assumedannualconsumptionoutput.contains(Assumedannualconsumptionint+"")){
					Report.updateTestLog("Assumed Annual Consumption Price Matches with Input and Application Expected : " + AssumedannualconsumptionXML + " Displayed : " + Assumedannualconsumption , "PASS");
				}
				else {
					Report.updateTestLog("Assumed Annual Cost displayed wrongly Expected : " + AssumedannualconsumptionXML + " Displayed : " + Assumedannualconsumption  , "FAIL");
				}
		}
		 //////////////////////////////////////////////////////Verify Estimated Annual Cost //////////////////////////////////////////////////////////////////////////////////////
				
				if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectEstimatedAnnualCost")))
				{
					Estimatedannualcost=browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectEstimatedAnnualCost"));
					Report.updateTestLog("Estimated Annual cost in App= "+Estimatedannualcost, "PASS");
					System.out.println("Estimated Annual cost in App= "+Estimatedannualcost);
					EstimatedannualcostInput = ((Float.valueOf(CompareTariff.getEstimatedAnnualCost()))); 
					EstimatedannualcostInputXML = Float.parseFloat(df.format(EstimatedannualcostInput));
					System.out.println("Tariff Comparison Rate Price in XML"+ EstimatedannualcostInputXML);
					Report.updateTestLog("Tariff Comparison Rate Price in XML= "+EstimatedannualcostInputXML, "PASS");
					if (Estimatedannualcost.contains(EstimatedannualcostInputXML+"")){
						Report.updateTestLog("Estimated Annual cost Matches with Input and Application Expected : " + EstimatedannualcostInputXML + " Displayed : " + Estimatedannualcost , "PASS");
					}
					else {
						Report.updateTestLog("Estimated Annual cost Price displayed wrongly Expected : " + EstimatedannualcostInputXML + " Displayed : " + Estimatedannualcost  , "FAIL");
					}
				}
}
		}
	 
	 
	 
	 public void verifyGasPricing(CompareTariff CompareTariff){
			browser.wait(getWaitTime());

			String Standardunitrate = "";
			String Standingcharge= "";
			String Estimatedannualcost= "";
			String TCR= "";
			String Assumedannualconsumption ="";
			String TariffName ="";
			String PaymentOption ="";
			float StandardunitrateInput;
			float StandingchargeInput;
			float EstimatedannualcostInput;
			float AssumedannualconsumptionInput;
			float TCRInput;
			String TariffNameInput="";
			String Penalty = "";
			String PenaltyXML;
			String Discountcharges = "";
			String DuelfueldiscountInput ="";
			
			
			DecimalFormat df=new DecimalFormat("0.00");
			
		//////////////////////////////////////////////////////Verify Tariff Name //////////////////////////////////////////////////////////////////////////////////////
					
		if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.GasTariffName")))
		{
		TariffName =browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.GasTariffName"));
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
		
		if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.GasPaymentmethod")))
		{
		PaymentOption =browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.GasPaymentmethod"));
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
			
			//////////////////////////////////////////////////////Verify Standard Unit Rate //////////////////////////////////////////////////////////////////////////////////////
			
			if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.GasUnitPrice")))
			{
				Standardunitrate=browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.GasUnitPrice"));
				Report.updateTestLog("Standard unit ratePrice in App= "+Standardunitrate, "PASS");
				System.out.println("Standard Unit Rate ="+ Standardunitrate);
				StandardunitrateInput = ((Float.valueOf(CompareTariff.getRegister1Price())));
				StandardunitrateXML = Float.parseFloat(df.format(StandardunitrateInput));
				System.out.println("Standard Unit Price in XML"+ StandardunitrateXML);
				Report.updateTestLog("Standard unit ratePrice in XML= "+StandardunitrateXML, "PASS");
				if (Standardunitrate.contains(StandardunitrateXML+"")){
					Report.updateTestLog("Unit Price Matches with Input and Application Expected : " + StandardunitrateXML + " Displayed : " + Standardunitrate , "PASS");
				}
				else {
					Report.updateTestLog("Unit Price displayed wrongly Expected : " + StandardunitrateXML + " Displayed : " + Standardunitrate  , "FAIL");
				}
				
				//////////////////////////////////////////////////////Verify Standing charge//////////////////////////////////////////////////////////////////////////////////////		
				
				if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.GasStandingCharge")))
				{
					Standingcharge=browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.GasStandingCharge"));
					Report.updateTestLog("Standard Charge Price in App= "+Standingcharge, "PASS");
					System.out.println("Standard Unit Rate ="+ Standingcharge);
					StandingchargeInput = ((Float.valueOf(CompareTariff.getStandingCharge())));
					StandingchargeXML = Float.parseFloat(df.format(StandingchargeInput));
					System.out.println("Standard Unit Price in XML"+ StandingchargeXML);
					Report.updateTestLog("Standard unit ratePrice in XML= "+StandingchargeXML, "PASS");
					if (Standingcharge.contains(StandingchargeXML+"")){
						Report.updateTestLog("Standard Charge Price Matches with Input and Application Expected : " + StandingchargeXML + " Displayed : " + Standingcharge , "PASS");
					}
					else {
						Report.updateTestLog("Standard Price displayed wrongly Expected : " + StandingchargeXML + " Displayed : " + Standingcharge  , "FAIL");
					}
			}
				
			//////////////////////////////////////////////////////Verify Penalty//////////////////////////////////////////////////////////////////////////////////////		
							
			if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.GasPenalty")))
			{
			Penalty =browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.GasPenalty"));
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
				
			
			//////////////////////////********************** Verify Discount Charge **********************  ///////////////////////////////////////////////
						
			if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.GasDiscount")))
			{
			Discountcharges =browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.GasDiscount"));
			Report.updateTestLog("Discount Charges in App= "+Discountcharges, "PASS");
			System.out.println("Discount Charges ="+ Discountcharges);
			
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
			
			//////////////////////////////////////////////////////Verify Tariff comparision Rate //////////////////////////////////////////////////////////////////////////////////////
				
				if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.GasTCR")))
				{
					TCR=browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.GasTCR"));
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
				
				//////////////////////////////////////////////////////Verify Assumed annual consumption //////////////////////////////////////////////////////////////////////////////////////
								
				
				if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.GasAssumedannualconsumption")))
				{
				Assumedannualconsumption=browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.GasAssumedannualconsumption"));
				
				String Assumedannualconsumptionoutput = Assumedannualconsumption.replace(",", "");
				
				
				Report.updateTestLog("Assumed annual consumption Price in App= "+Assumedannualconsumption, "PASS");
				System.out.println("Assumed annual consumption in App= "+Assumedannualconsumption);
				AssumedannualconsumptionInput = ((Float.valueOf(CompareTariff.getAnnualConsumption()))); 
				AssumedannualconsumptionXML = Float.parseFloat(df.format(AssumedannualconsumptionInput));
				
				int Assumedannualconsumptionint = Math.round(AssumedannualconsumptionXML);
				
				
				System.out.println("Assumed annual consumption Price in XML"+ AssumedannualconsumptionXML);
				Report.updateTestLog("Assumed annual consumption Price in XML= "+AssumedannualconsumptionXML, "PASS");
				Report.updateTestLog("Assumed annual consumption Price after round = "+Assumedannualconsumptionint, "PASS");
				//if (Assumedannualconsumption.contains(AssumedannualconsumptionXML+"")){
				if (Assumedannualconsumptionoutput.contains(Assumedannualconsumptionint+"")){
				
				Report.updateTestLog("Assumed Annual Consumption Price Matches with Input and Application Expected : " + AssumedannualconsumptionXML + " Displayed : " + Assumedannualconsumption , "PASS");
				}
				else {
				Report.updateTestLog("Assumed Annual Cost displayed wrongly Expected : " + AssumedannualconsumptionXML + " Displayed : " + Assumedannualconsumption  , "FAIL");
				}
				}
				
		 //////////////////////////////////////////////////////Verify Estimated Annual Cost //////////////////////////////////////////////////////////////////////////////////////
				
				if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.GasEstimatedAnnualCost")))
				{
					Estimatedannualcost=browser.getTextByXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.GasEstimatedAnnualCost"));
					Report.updateTestLog("Estimated Annual cost in App= "+Estimatedannualcost, "PASS");
					System.out.println("Estimated Annual cost in App= "+Estimatedannualcost);
					EstimatedannualcostInput = ((Float.valueOf(CompareTariff.getEstimatedAnnualCost()))); 
					EstimatedannualcostInputXML = Float.parseFloat(df.format(EstimatedannualcostInput));
					System.out.println("Estimated Annual cost in XML"+ EstimatedannualcostInputXML);
					Report.updateTestLog("Estimated Annual cost in XML= "+EstimatedannualcostInputXML, "PASS");
					if (Estimatedannualcost.contains(EstimatedannualcostInputXML+"")){
						Report.updateTestLog("Estimated Annual cost Matches with Input and Application Expected : " + EstimatedannualcostInputXML + " Displayed : " + Estimatedannualcost , "PASS");
					}
					else {
						Report.updateTestLog("Estimated Annual cost Price displayed wrongly Expected : " + EstimatedannualcostInputXML + " Displayed : " + Estimatedannualcost  , "FAIL");
					}
				}
}
		}
	 
	 public void SingleFuel(CompareTariff CompareTariff) {
			
		 String PropCode = CompareTariff.getPropositionCode();
			String PropCodefinal = PropCode.substring(0, 1);
			
			System.out.println("************************"+PropCodefinal);
			if(PropCodefinal.contains("E")){
			//if(CompareTariff.getPropositionCode().contains("EG6")){
				browser.wait(5000);
				System.out.println("NEWWWWWW010101010101010101WWWWWWWWWWWWW");
				if(CompareTariff.getNOR().contains("0002"))
				{
					System.out.println("SEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLL");
					browser.wait(2000);
					SelectPaymentType(CompareTariff);
					Economymeterselect(CompareTariff);
					browser.wait(2000);
					UpdateMyrateButton();
					Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
					System.out.println("^%^%^%^%^%^%^%^%^%^%^%^");
					verifyPricingElect(CompareTariff);
					
					
				
				}
				if(CompareTariff.getNOR().contains("0001"))
				{
					System.out.println("00000001111111111SEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLL");
					browser.wait(2000);
					SelectPaymentType(CompareTariff);
					browser.wait(2000);
					Economymeter(CompareTariff);
					browser.wait(2000);
					UpdateMyrateButton();
					Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
					verifyElectPricing(CompareTariff);
					
				}
				
			}
			
			else if(PropCodefinal.contains("G")){
			
			//else if(CompareTariff.getPropositionCode().contains("GG6")){
				browser.wait(5000);
				System.out.println("GGGGGGGGGGGGGGGGGII1010101WWWWWWWWWWWWW");
			if(CompareTariff.getNOR().contains("0002"))
			{
				System.out.println("SEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLL");
				browser.wait(2000);
				SelectPaymentType(CompareTariff);
				browser.wait(2000);
				browser.wait(2000);
				Economymeterselect(CompareTariff);
				browser.wait(2000);
				UpdateMyrateButton();
				browser.wait(5000);
				Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
				verifyGasPricing(CompareTariff);
				
			
			}
			
			else if(CompareTariff.getNOR().contains("0001")){
				browser.wait(3000);
				//GasQuoteVerification(CompareTariff);
				System.out.println("HELLLLLLLLLLLLLLO");
				browser.wait(2000);
				SelectPaymentType(CompareTariff);
				browser.wait(2000);
				//Economymeter(CompareTariff);
				browser.wait(2000);
				UpdateMyrateButton();
								
				Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
				verifyGasPricing(CompareTariff);
				
			}
		}
			
		}

}
