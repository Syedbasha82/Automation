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

public class SECompareEnergyTariffPage extends BasePage {
	
	private final static String File_RegPage = "resources/ReFactoring/SECompareEnergyTariff.properties";
	private static Properties SECompareTariffProperties = new PropertyLoader(File_RegPage).load();

	float DayUnitXML;
	float NightUnitXML;
	float StandingchargeEconomyXML;
	float DiscountchargeXML;
	float StandardunitrateXML;
	float StandingchargeXML;
	float TCRXML;	
	float AnnualconsumptionXML;
	float EstimatedannualcostInputXML;
	String TariffNameXML;
	String DuelfueldiscountXML;
	String PenaltyXML;
	float AssumedannualconsumptionXML;
	
	public void navigateToSEcompareTariffPage () {

		browser.open(ApplicationConfig.APP_BG_URL+"/products-and-services/energy/our-energy-tariffs/compare-energy-tariffs.html#gas-Standard-til");
		browser.wait(2000);
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		}
	
	public void enterPostCodeNew(CompareTariff CompareTariff){
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		
		String ValidatePostcoderegion = CompareTariff.getRegion();
		String PostCode = CompareTariff.getRegioncode();
		System.out.println("Print the value of the Post code for the XML = "+ValidatePostcoderegion);
			Report.updateTestLog("Post code Region *******************" + ValidatePostcoderegion  + "**********************", "Pass");
			Report.updateTestLog("Post code  *******************" + PostCode  + "**********************", "Pass");
			System.out.println("Printing the regions" );
			verifyAndInputByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.PostCode"),"Post Code", CompareTariff.getRegioncode());
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
			if(browser.isElementVisibleWithXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Paymenttype")))
			{
				System.out.println("Visssssssssssssble");
				verifyAndSelectDropDownBoxByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Paymenttype"),"payment Type","Cash/Cheque");
			//verifyAndSelectDropDownBox(SECompareTariffProperties.getProperty("CompareTariff.paymentType"),"payment Type","Monthly Direct Debit");
			//verifyAndSelectDropDownBoxbyindex_id(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Paymenttype"),2);
			}
		}
	}
	
	public void SelectfuelType(CompareTariff CompareTariff){
		browser.wait(getWaitTime());
		System.out.println("BFEGERGERGB");
		
		selectMeter(CompareTariff);
	}
	
	 public void selectMeter(CompareTariff CompareTariff){
	    	if(CompareTariff.getNOR().equals("0002")){
	    		verifyAndClickWithXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Economy7"),"Economy 7 is checked in");
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
			if(CompareTariff.getPropositionCode().contains("EH9")){
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
				clickDuelElectInfo(CompareTariff);
				verifyPricingElect(CompareTariff);
				clickDuelElectInfo(CompareTariff);
				
			
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
				clickDuelElectInfo(CompareTariff);
				verifyElectPricing(CompareTariff);
				clickDuelElectInfo(CompareTariff);
						
			}
		}
			
			else if(CompareTariff.getPropositionCode().contains("GH9")){
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
				clickDuelGasInfo(CompareTariff);
				verifyGasPricing(CompareTariff);
				clickDuelGasInfo(CompareTariff);
				
			
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
				clickDuelGasInfo(CompareTariff);
				verifyGasPricing(CompareTariff);
				clickDuelGasInfo(CompareTariff);
				
						
			}
		}
			
		}
	 public void SingleFuel(CompareTariff CompareTariff) {
			
			if(CompareTariff.getPropositionCode().contains("EG6")){
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
					clickDuelElectInfo(CompareTariff);
					verifyPricingElect(CompareTariff);
					clickDuelElectInfo(CompareTariff);
					
				
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
					clickDuelElectInfo(CompareTariff);
					verifyElectPricing(CompareTariff);
					clickDuelElectInfo(CompareTariff);
				}
				
			}
			
			else if(CompareTariff.getPropositionCode().contains("GG6")){
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
				clickDuelGasInfo(CompareTariff);
				verifyGasPricing(CompareTariff);
				clickDuelGasInfo(CompareTariff);
			
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
				clickDuelGasInfo(CompareTariff);
				verifyGasPricing(CompareTariff);
				clickDuelGasInfo(CompareTariff);
			}
		}
			
		}
	 public void Economymeterselect(CompareTariff CompareTariff) {
			
			System.out.println("DONNNNNNNNNNNNNNNEEEEEEEEEEEE");
			
		System.out.println("ECCCOOOOOOONNNNNNNNN");
		browser.wait(2000);
		if(CompareTariff.getNOR().equals("0002"))
		{	
			if(browser.isCheckBoxSelectedWithXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Economy7")))
			{
				System.out.println("checkbox is Already Selected");
			}else{
					System.out.println("It should not select");
					browser.clickWithXpath((SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Economy7")));
			}
		
			
		}
			
		}	
	 public void DuelFuelPrice(CompareTariff CompareTariff) {
			
			System.out.println("DONNNNNNNNNNNNNNNEEEEEEEEEEEE");
			
		System.out.println("DUEEEEEEEEEEEEELLLLLLLLLL FUUUUUUUUUUUUUUUEEEEEEEEEELLLLLLLLLLLL");
		browser.wait(2000);
		if(CompareTariff.getDualFuel().contains("Y"))
		{	
			if(browser.isCheckBoxSelectedWithXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.DuelFuel")))
			{
				System.out.println("checkbox is Already Selected");
			}else{
					System.out.println("It should not select");
					browser.clickWithXpath((SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.DuelFuel")));
			}
		
			
		}
			
		}	
	 
	 public void UpdateMyrateButton() {
			browser.wait(getWaitTime());
			browser.clickWithCss(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Updaterate01"));
			
		}

	 public void clickDuelElectInfo(CompareTariff CompareTariff){
			browser.wait(getWaitTime());
			browser.wait(getWaitTime());
			verifyAndClickWithXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.ElectTariff").replace("TariffName", CompareTariff.getTariff()), "Your Tariff Info");
			browser.wait(getWaitTime());
			Report.updateTestLog("Pricing is displayed successfully","WARN");
			Report.updateTestLog("********************Verify Electricity Pricing ***************","PASS");
			
		}
	 
	 public void clickDuelGasInfo(CompareTariff CompareTariff){
			browser.wait(getWaitTime());
			browser.wait(getWaitTime());
			verifyAndClickWithXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.GasTariff").replace("TariffName", CompareTariff.getTariff()), "Your Tariff Info");
			browser.wait(getWaitTime());
			
			
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
			String PaymentOption ="";
			float EstimatedannualcostInput;
			float AssumedannualconsumptionInput;
			float DayUnitInput;
			float NightUnitInput;
			float StandingchargeEconomyInput;
			float AnnualconsumptionInput;
			float TCRElectInput;
			String Discountcharges = "";
			String DuelfueldiscountInput ="";
			String Penalty = "";
			String TCR= "";
			float TCRInput;
			
			DecimalFormat df=new DecimalFormat("0.00");
			
			//////////////////////////////////////////////////////Verify Tariff Name //////////////////////////////////////////////////////////////////////////////////////
						
			/*if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectTariffName")))
			{*/
			TariffName =browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Elect7TariffName").replace("TariffName", CompareTariff.getTariff()));
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
			//}
			
			//////////////////////////////////////////////////////Verify Payment Method //////////////////////////////////////////////////////////////////////////////////////
			
			/*if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectPaymentOption")))
			{*/
			PaymentOption =browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Elect7PaymentOption").replace("TariffName", CompareTariff.getTariff()));
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
			
			//}
			
			//////////////////////////********************** Verify Discount Charge **********************  ///////////////////////////////////////////////
			
			/*if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectE7Discountcharges")))
			{*/
			Discountcharges =browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Elect7Discountcharges").replace("TariffName", CompareTariff.getTariff()));
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
			//}
			
			
			//////////////////////////////////////////////////////Verify Penalty//////////////////////////////////////////////////////////////////////////////////////		
			
			/*if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectE7Penalty")))
			{*/
			Penalty =browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Elect7Penalty").replace("TariffName", CompareTariff.getTariff()));
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
		//	}

		//////////////////////////**********************  Verify Day Unit Price **********************  ///////////////////////////////////////////////
			System.out.println("*******************////////RGERERGERGHERH******************");
			
				/*if (browser.isElementVisibleWithXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Elect7DayUnitrate")))
				{*/
					System.out.println("VERVERGTERGHERHERHERGHERGERHGERHER");
	DayUnit=browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Elect7DayUnitrate01").replace("TariffName", CompareTariff.getTariff()));
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
			//}
					
					
					
					
		//////////////////////////**********************  Verify Night Unit Price **********************  ///////////////////////////////////////////////
				/*if (browser.isElementVisibleWithXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Elect7NightUnitrate")))
				{*/
					NightUnit=browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Elect7NightUnitrate01").replace("TariffName", CompareTariff.getTariff()));
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
			//}
		//////////////////////////**********************  Verify Standing Charge **********************  ///////////////////////////////////////////////
				/*if (browser.isElementVisibleWithXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Elect7Standingcharge")))
				{*/
					StandingchargeEconomy=browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Elect7Standingcharge01").replace("TariffName", CompareTariff.getTariff()));
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
			//}

			///////////////////////////////////////////// Verify Estimated Annual cost ///////////////////////////////////////////////////////////////////////////
				
					/*if (browser.isElementVisibleWithXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.ElectSingleEstimatedAnnualCost")))
					 {*/
						 Estimatedannualcost=browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.ElectSingleEstimatedAnnualCost").replace("TariffName", CompareTariff.getTariff()));
						 Report.updateTestLog("Annual consumption Price in App= "+Estimatedannualcost, "PASS");
						 System.out.println("Annual consumption Price in App= "+Estimatedannualcost);
						 String AnnualconsumptionXMLNew = CompareTariff.getEstimatedAnnualCost();
						 System.out.println("Estimated Annual cost Price in XML"+ AnnualconsumptionXMLNew);
						 Report.updateTestLog("Estimated Annual cost Price in XML= "+AnnualconsumptionXMLNew, "PASS");
						 if (Estimatedannualcost.contains("Not applicable")){
							 Report.updateTestLog("Estimated Annual cost Matches with Input and Application Expected :  " + "Not applicable" + " Displayed : " + Estimatedannualcost , "PASS");
						 }
						 else {
							 Report.updateTestLog("Estimated Annual cost Price displayed wrongly Expected : " + "Not applicable" + " Displayed : " + Estimatedannualcost  , "FAIL");
						 }
					// }		
					
///////////////////////////////////////////// Verify TCR ///////////////////////////////////////////////////////////////////////////
						 TCR=browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Elect7TCR").replace("TariffName", CompareTariff.getTariff()));
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
						 
			///////////////////////////////////////////// Verify annual consumption ///////////////////////////////////////////////////////////////////////////
			/*if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.E7annualconsumption")))
			{*/
			Assumedannualconsumption=browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Elect7annualconsumption").replace("TariffName", CompareTariff.getTariff()));
			
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
			
			/*if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.E7TariffComparisonRate")))
			{*/
			
			//}			
					

		
	 public void Economymeter(CompareTariff CompareTariff) {
			
			System.out.println("NOOOOOOOOOORRRRRRRRRR00000000000000011111111111111");
		
		browser.wait(2000);
				
			if(browser.isCheckBoxSelectedWithXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Economy7")))
			{
				browser.clickWithXpath((SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Economy7")));
			}
		else
			{
				System.out.println("It is not selected");
				
			}
		}
	 public void verifyGasPricing(CompareTariff CompareTariff){
			browser.wait(getWaitTime());

			String Standardunitrate = "";
			String Standingcharge= "";
			String Estimatedannualcost= "";
			String TCR= "";
			String Assumedannualconsumption ="";
			String Annualconsumption;
			
			
			float StandardunitrateInput;
			float StandingchargeInput;
			float EstimatedannualcostInput;
			float AssumedannualconsumptionInput;
			float AnnualconsumptionInput;
			float TCRInput;
			String TariffName ="";
			String TariffNameInput="";
			String PaymentOption ="";
			String Discountcharges = "";
			String DuelfueldiscountInput ="";
			String Penalty = "";
			
			DecimalFormat df=new DecimalFormat("0.00");
			
				//////////////////////////////////////////////////////Verify Tariff Name //////////////////////////////////////////////////////////////////////////////////////
							
				/*if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectTariffName")))
				{*/
				TariffName =browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.GasTariffName").replace("TariffName", CompareTariff.getTariff()));
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
				//}
				
				//////////////////////////////////////////////////////Verify Payment Method //////////////////////////////////////////////////////////////////////////////////////
				
				/*if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectPaymentOption")))
				{*/
				PaymentOption =browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.GasPaymentOption").replace("TariffName", CompareTariff.getTariff()));
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
				
				//}
				
				//////////////////////////********************** Verify Discount Charge **********************  ///////////////////////////////////////////////
				
				/*if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectE7Discountcharges")))
				{*/
				Discountcharges =browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Gasdiscountcharges").replace("TariffName", CompareTariff.getTariff()));
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
				//}
				
				
				//////////////////////////////////////////////////////Verify Penalty//////////////////////////////////////////////////////////////////////////////////////		
				
				/*if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectE7Penalty")))
				{*/
				Penalty =browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.GasPenalty").replace("TariffName", CompareTariff.getTariff()));
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

			
			
			//////////////////////////////////////////////////////Verify Unit Rate //////////////////////////////////////////////////////////////////////////////////////
			Report.updateTestLog("******************* Verify Pricing **********************", "Pass");
			/*if (browser.isElementVisibleWithXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.GasUnitRate")))
			{*/
				Standardunitrate=browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.GasUnitRate").replace("TariffName", CompareTariff.getTariff()));
				Report.updateTestLog("Unit rate Price in App= "+Standardunitrate, "PASS");
				System.out.println("Unit Rate ="+ Standardunitrate);
				StandardunitrateInput = ((Float.valueOf(CompareTariff.getRegister1Price())));
				StandardunitrateXML = Float.parseFloat(df.format(StandardunitrateInput));
				System.out.println("Standard Unit Price in XML"+ StandardunitrateXML);
				Report.updateTestLog("Unit ratePrice in XML= "+StandardunitrateXML, "PASS");
				if (Standardunitrate.contains(StandardunitrateXML+"")){
					Report.updateTestLog("Unit Price Matches with Input and Application Expected : " + StandardunitrateXML + " Displayed : " + Standardunitrate , "PASS");
				}
				else {
					Report.updateTestLog("Unit Price displayed wrongly Expected : " + StandardunitrateXML + " Displayed : " + Standardunitrate  , "FAIL");
				}
				
				//////////////////////////////////////////////////////Verify Standing charge//////////////////////////////////////////////////////////////////////////////////////		
				
				/*if (browser.isElementVisibleWithXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.GasStandingCharge")))
				{*/
					Standingcharge=browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.GasStandingCharge").replace("TariffName", CompareTariff.getTariff()));
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
			//}
				
			//////////////////////////////////////////////////////Verify Tariff comparision Rate //////////////////////////////////////////////////////////////////////////////////////
				
				/*if (browser.isElementVisibleWithXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.GasTCR")))
				{*/
					TCR=browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.GasTCR").replace("TariffName", CompareTariff.getTariff()));
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
			//}
		//}
//////////////////////////////////////////////////////Verify Annual consumption Rate //////////////////////////////////////////////////////////////////////////////////////
			
					Assumedannualconsumption=browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Gasannualconsumption").replace("TariffName", CompareTariff.getTariff()));
					
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
			
		
//////////////////////////////////////////////////////Verify Estimated Annual cost//////////////////////////////////////////////////////////////////////////////////////
	 /*if (browser.isElementVisibleWithXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.GasSetimatedannualcost")))
	 {*/
		 Estimatedannualcost=browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.GasSetimatedannualcost").replace("TariffName", CompareTariff.getTariff()));
		 Report.updateTestLog("Annual consumption Price in App= "+Estimatedannualcost, "PASS");
		 System.out.println("Annual consumption Price in App= "+Estimatedannualcost);
		 /*EstimatedannualcostInput = ((Float.valueOf(CompareTariff.getEstimatedAnnualCost()))); 
		 AnnualconsumptionXML = Float.parseFloat(df.format(EstimatedannualcostInput));*/
		 String AnnualconsumptionXMLNew = CompareTariff.getEstimatedAnnualCost();
		 System.out.println("Estimated Annual cost Price in XML"+ AnnualconsumptionXMLNew);
		 Report.updateTestLog("Estimated Annual cost Price in XML= "+AnnualconsumptionXMLNew, "PASS");
		 if (Estimatedannualcost.contains(AnnualconsumptionXMLNew+"")){
			 Report.updateTestLog("Estimated Annual cost Matches with Input and Application Expected : " + AnnualconsumptionXMLNew + " Displayed : " + Estimatedannualcost , "PASS");
		 }
		 else {
			 Report.updateTestLog("Estimated Annual cost Price displayed wrongly Expected : " + AnnualconsumptionXMLNew + " Displayed : " + Estimatedannualcost  , "FAIL");
		 }
	 }

	//}
	 public void verifyElectPricing(CompareTariff CompareTariff){
			browser.wait(getWaitTime());

			String Standardunitrate = "";
			String Standingcharge= "";
			String Estimatedannualcost= "";
			String TCR= "";
			String Assumedannualconsumption ="";
			String Annualconsumption;
			String TariffName ="";
			String TariffNameInput="";
			String PaymentOption ="";
			String Discountcharges = "";
			String DuelfueldiscountInput ="";
			String Penalty = "";
			
			float StandardunitrateInput;
			float StandingchargeInput;
			float EstimatedannualcostInput;
			float AssumedannualconsumptionInput;
			float AnnualconsumptionInput;
			float TCRInput;
			
			
			DecimalFormat df=new DecimalFormat("0.00");
			
			//////////////////////////////////////////////////////Verify Tariff Name //////////////////////////////////////////////////////////////////////////////////////
						
			/*if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectTariffName")))
			{*/
			TariffName =browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Elect7TariffName").replace("TariffName", CompareTariff.getTariff()));
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
			//}
			
			//////////////////////////////////////////////////////Verify Payment Method //////////////////////////////////////////////////////////////////////////////////////
			
			/*if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectPaymentOption")))
			{*/
			PaymentOption =browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Elect7PaymentOption").replace("TariffName", CompareTariff.getTariff()));
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
			
			//}
			
			//////////////////////////********************** Verify Discount Charge **********************  ///////////////////////////////////////////////
			
			/*if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectE7Discountcharges")))
			{*/
			Discountcharges =browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.ElectDiscount").replace("TariffName", CompareTariff.getTariff()));
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
			//}
			
			
			//////////////////////////////////////////////////////Verify Penalty//////////////////////////////////////////////////////////////////////////////////////		
			
			/*if (browser.isElementVisibleWithXpath(SEProductLandingProperties.getProperty("SEProductLandingPage.ElectE7Penalty")))
			{*/
			Penalty =browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.ElectPenalty").replace("TariffName", CompareTariff.getTariff()));
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
			
			
			//////////////////////////////////////////////////////Verify Unit Rate //////////////////////////////////////////////////////////////////////////////////////
			Report.updateTestLog("******************* Verify Pricing **********************", "Pass");
			/*if (browser.isElementVisibleWithXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.ElectSingleUnitPrice")))
			{*/
				Standardunitrate=browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.ElectSingleUnitPrice").replace("TariffName", CompareTariff.getTariff()));
				Report.updateTestLog("Unit rate Price in App= "+Standardunitrate, "PASS");
				System.out.println("Unit Rate ="+ Standardunitrate);
				StandardunitrateInput = ((Float.valueOf(CompareTariff.getRegister1Price())));
				StandardunitrateXML = Float.parseFloat(df.format(StandardunitrateInput));
				System.out.println("Standard Unit Price in XML"+ StandardunitrateXML);
				Report.updateTestLog("Unit ratePrice in XML= "+StandardunitrateXML, "PASS");
				if (Standardunitrate.contains(StandardunitrateXML+"")){
					Report.updateTestLog("Unit Price Matches with Input and Application Expected : " + StandardunitrateXML + " Displayed : " + Standardunitrate , "PASS");
				}
				else {
					Report.updateTestLog("Unit Price displayed wrongly Expected : " + StandardunitrateXML + " Displayed : " + Standardunitrate  , "FAIL");
				}
				
				//////////////////////////////////////////////////////Verify Standing charge//////////////////////////////////////////////////////////////////////////////////////		
				
				/*if (browser.isElementVisibleWithXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.ElectSingleStandingcharge")))
				{*/
					Standingcharge=browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.ElectSingleStandingcharge").replace("TariffName", CompareTariff.getTariff()));
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
		//	}
				
			//////////////////////////////////////////////////////Verify Tariff comparision Rate //////////////////////////////////////////////////////////////////////////////////////
				
				/*if (browser.isElementVisibleWithXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.ElectSingleTCR")))
				{*/
					TCR=browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.ElectSingleTCR").replace("TariffName", CompareTariff.getTariff()));
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
		//	}
	//	}
//////////////////////////////////////////////////////Verify Estimated Annual cost//////////////////////////////////////////////////////////////////////////////////////		
					Estimatedannualcost=browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.ElectSingleEstimatedAnnualCost").replace("TariffName", CompareTariff.getTariff()));
					 Report.updateTestLog("Annual consumption Price in App= "+Estimatedannualcost, "PASS");
					 System.out.println("Annual consumption Price in App= "+Estimatedannualcost);
					 /*EstimatedannualcostInput = ((Float.valueOf(CompareTariff.getEstimatedAnnualCost()))); 
					 AnnualconsumptionXML = Float.parseFloat(df.format(EstimatedannualcostInput));*/
					 String AnnualconsumptionXMLNew = CompareTariff.getEstimatedAnnualCost();
					 System.out.println("Estimated Annual cost Price in XML"+ AnnualconsumptionXMLNew);
					 Report.updateTestLog("Estimated Annual cost Price in XML= "+AnnualconsumptionXMLNew, "PASS");
					 if (Estimatedannualcost.contains(AnnualconsumptionXMLNew+"")){
						 Report.updateTestLog("Estimated Annual cost Matches with Input and Application Expected : " + AnnualconsumptionXMLNew + " Displayed : " + Estimatedannualcost , "PASS");
					 }
					 else {
						 Report.updateTestLog("Estimated Annual cost Price displayed wrongly Expected : " + AnnualconsumptionXMLNew + " Displayed : " + Estimatedannualcost  , "FAIL");
					 }
//////////////////////////////////////////////////////Verify Annual consumption Rate //////////////////////////////////////////////////////////////////////////////////////
					
					
					Assumedannualconsumption=browser.getTextByXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.Elect7annualconsumption").replace("TariffName", CompareTariff.getTariff()));
					
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
			
		

	 /*if (browser.isElementVisibleWithXpath(SECompareTariffProperties.getProperty("SECompareEnergyTariffPage.ElectSingleEstimatedAnnualCost")))
	 {*/
		 
	 //}

	//}

	
}
