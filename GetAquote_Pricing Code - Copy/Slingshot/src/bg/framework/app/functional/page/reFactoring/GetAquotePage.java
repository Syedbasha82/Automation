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

public class GetAquotePage extends BasePage {
	
	private final static String File_RegPage = "resources/ReFactoring/GetAquote.properties";
	private static Properties GetAquoteProperties = new PropertyLoader(File_RegPage).load();
	
	float StandardunitrateXML;
	float StandingchargeXML;
	float EstimatedannualcostXML;
	float DayUnitXML;
	float NightUnitXML;
	float AssumedannualconsumptionXML;
	float StandingchargeEconomyXML;
	float TCRXML;
	float TCRElectXML;
	String TariffNameXML;
	String DuelfueldiscountXML;
	public void navigateToGetAquotePage () {

		browser.open(ApplicationConfig.APP_BG_URL+"/GetAQuote/#/details");
		//browser.open("https://10.224.70.50/GetAQuote/#/details");
		browser.wait(2000);
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		}
	
	public void selectOnlineAcct(){
		browser.wait(getWaitTime());
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.OnlineAccountYes"), "Select Yes");
	}
	
	public void enterPostCodeNew(CompareTariff CompareTariff,UserProfile userProfile){
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		String ValidatePostcoderegion = CompareTariff.getRegion();
		String PostCode = CompareTariff.getRegioncode();
		//System.out.println("Print the value of the Post code for the XML = "+ValidatePostcoderegion);
		//String region1 =postCode;
		/*System.out.println("Print the value of the Post code for the XML = "+region1);
		String Region1 = new PostCodeRegion().getPostcode(region1);
		System.out.println("Print the value of the Post code for  = "+Region1);*/
		/*if(ValidatePostcode.equals(Region1))
		{*/
			//String PostCodes = new PostCodeRegion().getPostcode(region1);
			Report.updateTestLog("Post code Region *******************" + ValidatePostcoderegion  + "**********************", "Pass");
			Report.updateTestLog("Post code  *******************" + PostCode  + "**********************", "Pass");
			System.out.println("Printing the regions" );
			verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.PostCode"),"Post Code", CompareTariff.getRegioncode());
			System.out.println("POOOOOOOOOOOOOOOOOOOSSSSSSSSSSSSTTTTTTTTTTTTTTT");
			verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.TelephoneNumber"),"Telephone Number", userProfile.getMobileNumber());
		//}
		
		
	}
	public void SelectNewProp(UserProfile userProfile){
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		System.out.println("NHNHNHNHNHHHHHHHHHHHHHHHHHHHHHHHHHH");
		//verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.NewProperty"), "Select New Property");
		browser.clickWithCss(GetAquoteProperties.getProperty("GetAQuotePage.NewProperty_New"));
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.PostCode"),"Post Code", userProfile.getPostCode());
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.TelephoneNumber"),"Telephone Number", userProfile.getMobileNumber());
						
	}
	public void enterTelephoneNumber(UserProfile userProfile){
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.TelephoneNumber")))
		{
			System.out.println("POOOOOOOOOOOOOOOOOOOSSSSSSSSSSSSTTTTTTTTTTTTTTT");
			verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.TelephoneNumber"),"Telephone Number", userProfile.getMobileNumber());	
		}
		
	}
	
	
	public void enterPostCode(UserProfile userProfile){
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.PostCode"),"Post Code", userProfile.getPostCode());
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.TelephoneNumber"),"Telephone Number", userProfile.getMobileNumber());
	}
	
	public void selectGasQuote(){
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.GasQuote"), "Gas quote");
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.GasConsumption"),"Gas consumption", "12500");
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.quotebutton"), "quote button");
		browser.wait(getWaitTime());
	}
	
	public void selectElectQuote(){
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectricityQuote"), "Electricity quote");
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectConsumption"),"Elect consumption", "3100");
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.quotebutton"), "quote button");
		browser.wait(getWaitTime());
	}
	
	public void SelectCompareTariff(String TariffList){
		
		if(TariffList.contains("HomeEnergy Connected Kit Jan 2018")){
			verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.MoreInfoNew"), "More Info");
			
		}
		
			browser.wait(getWaitTime());
			
	}
	
	
	public void clickInfo(CompareTariff CompareTariff){
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		//verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.MoreInfoNew"), "More Info");
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.MoreInfoFinal").replace("TariffName", CompareTariff.getTariff()), "More Info");
		
		browser.wait(getWaitTime());
	}
	
	public void Buynow(CompareTariff CompareTariff){
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		System.out.println("CCCCCCCCCCCCCLLLLLLLLLLLLLLLIIIIIIIIIIII");
		//verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.MoreInfoNew"), "More Info");
		//verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.BuytariffFinal").replace("TariffName", CompareTariff.getTariff()), "Buy Tariff");
		
		//verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.BuytariffFinal").replace("TariffName", CompareTariff.getTariff()), "Buy Tariff");

		String GetTariff = CompareTariff.getTariff();
		List<WebElement> tariffs = browser.getElementsByCSS(GetAquoteProperties.getProperty("GetaQuotePage.tarrifs"));
		List<WebElement> buttons = browser.getElementsByCSS(GetAquoteProperties.getProperty("GetaQuotePage.BuyNow_Btn"));
		outerloop:                
		for(WebElement tariff: tariffs)
		                {
		                     for(WebElement BuyNow_btn: buttons){
		                                                if(tariff.getText().equals(GetTariff)){
		                                                                BuyNow_btn.click();
		                                                                break outerloop;
		                                                                
		                                                               
		                                                }
		                                                
		                                              
		                                }
		                }
	
		
		browser.wait(getWaitTime());
	}
	
	public void clickDuelGasInfo(CompareTariff CompareTariff){
		browser.wait(getWaitTime());
		//verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.DuelGas"), "Duel Gas More Info");
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.DuelGasNew1").replace("TariffName", CompareTariff.getTariff()), "Duel Gas More Info");
		browser.wait(getWaitTime());
		Report.updateTestLog("******************* Verify Gas Pricing **********************", "Pass");
	}
	
	public void clickDuelElectInfo(CompareTariff CompareTariff){
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		browser.wait(getWaitTime());
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.DuelElectNew1").replace("TariffName", CompareTariff.getTariff()), "Duel Elect More Info");
		browser.wait(getWaitTime());
		Report.updateTestLog("******************* Verify Elect Pricing **********************", "Pass");
	}
	
	public void verifyPricing(CompareTariff CompareTariff){
		browser.wait(getWaitTime());

		String Standardunitrate = "";
		String Standingcharge= "";
		String Estimatedannualcost= "";
		String TCR= "";
		String Assumedannualconsumption ="";
		String TariffName ="";
		String PaymentOption ="";
		String TariffNameInput="";
		float StandardunitrateInput;
		float StandingchargeInput;
		float EstimatedannualcostInput;
		float AssumedannualconsumptionInput;
		float TCRInput;
		String Discountcharges = "";
		String DuelfueldiscountInput ="";
		
		
		DecimalFormat df=new DecimalFormat("0.00");
		
		//////////////////////////////////////////////////////Verify Tariff Name //////////////////////////////////////////////////////////////////////////////////////
		
		if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectE7TariffName")))
		{
		TariffName =browser.getTextByXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectE7TariffName"));
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
						
		if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectE7Paymentmethod")))
		{
		PaymentOption =browser.getTextByXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectE7Paymentmethod"));
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
		
		else if(CompareTariff.getPaymentOption().contains("Prepayment"))
		{
		if(PaymentOption.contains("Pay As You Go"))
		{
		Report.updateTestLog("Payment Method Matches with Input and Application Expected : " + PaymentOption + " Displayed : " + CompareTariff.getPaymentOption() , "PASS");
		}
		else {
		Report.updateTestLog("Payment Method displaying wrongly : " + PaymentOption + " Displayed : " + CompareTariff.getPaymentOption()  , "FAIL");
		}	
		
		} 
		else if(CompareTariff.getPaymentOption().contains("Cash Or Cheque"))
		{
		if(PaymentOption.contains("Cash Or Cheque"))
		{
		Report.updateTestLog("Payment Method Matches with Input and Application Expected : " + PaymentOption + " Displayed : " + CompareTariff.getPaymentOption() , "PASS");
		}
		else {
		Report.updateTestLog("Payment Method displaying wrongly : " + PaymentOption + " Displayed : " + CompareTariff.getPaymentOption()  , "FAIL");
		}	
		
		} 
		
		}
		
		///////////////////////////////////////////// Verify Unit Rate ///////////////////////////////////////////////////////////////////////////
		
		if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Standardunitrate")))
		{
			Standardunitrate=browser.getTextByXpath(GetAquoteProperties.getProperty("GetAQuotePage.Standardunitrate"));
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
			
			///////////////////////////////////////////// Verify Standing Charge ///////////////////////////////////////////////////////////////////////////
			
			if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Standingcharge")))
			{
				Standingcharge=browser.getTextByXpath(GetAquoteProperties.getProperty("GetAQuotePage.Standingcharge"));
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
			
				//////////////////////////********************** Verify Discount Charge **********************  ///////////////////////////////////////////////
							
				/*if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectDiscountscharges")))
				{
				Discountcharges =browser.getTextByXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectDiscountscharges"));
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
				}*/
			///////////////////////////////////////////// Verify Estimated Annual cost ///////////////////////////////////////////////////////////////////////////
			
			if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Estimatedannualcost")))
			{
				Estimatedannualcost=browser.getTextByXpath(GetAquoteProperties.getProperty("GetAQuotePage.Estimatedannualcost"));
				Report.updateTestLog("Estimated Annual Cost in App= "+Estimatedannualcost, "PASS");
				System.out.println("Estimated Annual Cost in App= "+Estimatedannualcost);
				EstimatedannualcostInput = ((Float.valueOf(CompareTariff.getEstimatedAnnualCost()))); 
				EstimatedannualcostXML = Float.parseFloat(df.format(EstimatedannualcostInput));
				System.out.println("Estimated Annual Cost Price in XML"+ EstimatedannualcostXML);
				Report.updateTestLog("Estimated Annual Cost Price in XML= "+EstimatedannualcostXML, "PASS");
				if (Estimatedannualcost.contains(EstimatedannualcostXML+"")){
					Report.updateTestLog("Estimated Annual Cost Price Matches with Input and Application Expected : " + EstimatedannualcostXML + " Displayed : " + Estimatedannualcost , "PASS");
				}
				else {
					Report.updateTestLog("Estimated Annual Cost displayed wrongly Expected : " + EstimatedannualcostXML + " Displayed : " + Estimatedannualcost  , "FAIL");
				}
		}
		
			///////////////////////////////////////////// Verify annual consumption ///////////////////////////////////////////////////////////////////////////
			if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Assumedannualconsumption")))
			{
				Assumedannualconsumption=browser.getTextByXpath(GetAquoteProperties.getProperty("GetAQuotePage.Assumedannualconsumption"));
				
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
		
			///////////////////////////////////////////// Verify TCR Rate ///////////////////////////////////////////////////////////////////////////
			if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.TariffComparisonRate")))
			{
				TCR=browser.getTextByXpath(GetAquoteProperties.getProperty("GetAQuotePage.TariffComparisonRate"));
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
	
	
	public void verifyPricingElect(CompareTariff CompareTariff) {
		browser.wait(getWaitTime());

		String Estimatedannualcost= "";
		String Assumedannualconsumption ="";
		String TCRElect="";
		String StandingchargeEconomy= "";
		String DayUnit ="";
		String NightUnit ="";
		String TariffName ="";
		String PaymentOption ="";;
		String Discountcharges = "";
		float EstimatedannualcostInput;
		float AssumedannualconsumptionInput;
		float DayUnitInput;
		float NightUnitInput;
		float StandingchargeEconomyInput;
		float TCRElectInput;
		String TariffNameInput="";
		String DuelfueldiscountInput ="";
		
		DecimalFormat df=new DecimalFormat("0.00");
		
		
				//////////////////////////////////////////////////////Verify Tariff Name //////////////////////////////////////////////////////////////////////////////////////
						
				if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectE7TariffName")))
				{
				TariffName =browser.getTextByXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectE7TariffName"));
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
								
				if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectE7Paymentmethod")))
				{
				PaymentOption =browser.getTextByXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectE7Paymentmethod"));
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
				
				else if(CompareTariff.getPaymentOption().contains("Prepayment"))
				{
				if(PaymentOption.contains("Pay As You Go"))
				{
				Report.updateTestLog("Payment Method Matches with Input and Application Expected : " + PaymentOption + " Displayed : " + CompareTariff.getPaymentOption() , "PASS");
				}
				else {
				Report.updateTestLog("Payment Method displaying wrongly : " + PaymentOption + " Displayed : " + CompareTariff.getPaymentOption()  , "FAIL");
				}	
				
				} 
				else if(CompareTariff.getPaymentOption().contains("Cash Or Cheque"))
				{
				if(PaymentOption.contains("Cash Or Cheque"))
				{
				Report.updateTestLog("Payment Method Matches with Input and Application Expected : " + PaymentOption + " Displayed : " + CompareTariff.getPaymentOption() , "PASS");
				}
				else {
				Report.updateTestLog("Payment Method displaying wrongly : " + PaymentOption + " Displayed : " + CompareTariff.getPaymentOption()  , "FAIL");
				}	
				
				} 
				
				}
		    ////////////////////////// **********************  Verify Estimated Annual Cost **********************  ///////////////////////////////////////////////
			
			if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Estimatedannualcost")))
			{
				Estimatedannualcost=browser.getTextByXpath(GetAquoteProperties.getProperty("GetAQuotePage.Estimatedannualcost"));
				Report.updateTestLog("Estimated Annual Cost in App= "+Estimatedannualcost, "PASS");
				System.out.println("Estimated Annual Cost in App= "+Estimatedannualcost);
				EstimatedannualcostInput = ((Float.valueOf(CompareTariff.getEstimatedAnnualCost()))); 
				EstimatedannualcostXML = Float.parseFloat(df.format(EstimatedannualcostInput));
				System.out.println("Estimated Annual Cost Price in XML"+ EstimatedannualcostXML);
				Report.updateTestLog("Estimated Annual Cost Price in XML= "+EstimatedannualcostXML, "PASS");
				if (Estimatedannualcost.contains(EstimatedannualcostXML+"")){
					Report.updateTestLog("Estimated Annual Cost Price Matches with Input and Application Expected : " + EstimatedannualcostXML + " Displayed : " + Estimatedannualcost , "PASS");
				}
				else {
					Report.updateTestLog("Estimated Annual Cost displayed wrongly Expected : " + EstimatedannualcostXML + " Displayed : " + Estimatedannualcost  , "FAIL");
				}
		}
			 ////////////////////////// **********************  Verify Assumed annual consumption **********************  ///////////////////////////////////////////////
		
			if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Assumedannualconsumption")))
			{
				Assumedannualconsumption=browser.getTextByXpath(GetAquoteProperties.getProperty("GetAQuotePage.Assumedannualconsumption"));
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
//////////////////////////**********************  Verify Day Unit Price **********************  ///////////////////////////////////////////////
			if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Dayunitrate")))
			{
				DayUnit=browser.getTextByXpath(GetAquoteProperties.getProperty("GetAQuotePage.Dayunitrate"));
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
			if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Nightunitrate")))
			{
				NightUnit=browser.getTextByXpath(GetAquoteProperties.getProperty("GetAQuotePage.Nightunitrate"));
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
			if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Standingcharge_Economy")))
			{
				StandingchargeEconomy=browser.getTextByXpath(GetAquoteProperties.getProperty("GetAQuotePage.Standingcharge_Economy"));
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
		
			
			//////////////////////////********************** Verify Discount Charge **********************  ///////////////////////////////////////////////
						
			/*if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectE7Discountscharges")))
			{
			Discountcharges =browser.getTextByXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectE7Discountscharges"));
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
			}*/
//////////////////////////********************** Verify Tariff Comparison Rate Electricity **********************  ///////////////////////////////////////////////
			if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.TariffComparisonRateElect")))
			{
				TCRElect=browser.getTextByXpath(GetAquoteProperties.getProperty("GetAQuotePage.TariffComparisonRateElect"));
				Report.updateTestLog("Tariff Comparison Rate Price in App= "+TCRElect, "PASS");
				System.out.println("Tariff Comparison Rate Price in App= "+TCRElect);
				TCRElectInput = ((Float.valueOf(CompareTariff.getTariffComparisonRate()))); 
				TCRElectXML = Float.parseFloat(df.format(TCRElectInput));
				System.out.println("Tariff Comparison Rate Price in XML"+ TCRElectXML);
				Report.updateTestLog("Tariff Comparison Rate Price in XML= "+TCRElectXML, "PASS");
				String TCRelect1 = "Not applicable";
				if (TCRElect.contains(TCRelect1)){
					Report.updateTestLog("Tariff Comparison Rate Price Matches with Input and Application Expected : " + TCRelect1 + " Displayed : " + TCRElect , "PASS");
				}
				else {
					Report.updateTestLog("Tariff Comparison Rate Price displayed wrongly Expected : " + TCRelect1 + " Displayed : " + TCRElect  , "FAIL");
				}
		}
			
			
			
	}
		

	
	
	
	public void closeTariff(){
		browser.wait(getWaitTime());
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.CloseTariffNew"), "Close button");
		browser.wait(getWaitTime());
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

public void VerifyDuelFuelStatus(UserProfile userProfile,CompareTariff CompareTariff) {
	browser.wait(2000);
		System.out.println("NNNNNNNNNNNNNNNNGDFGDFGDFGF");
		if(CompareTariff.getDualFuel().contains("Y")){
			browser.wait(5000);
			DuelFuel(userProfile,CompareTariff);
			browser.wait(2000);
			
		}
		
		
	}

public void VerifyFuelStatus_Buy(CompareTariff CompareTariff, UserProfile userProfile) {
	browser.wait(2000);
		System.out.println("NNNNNNNNNNNNNNNNGDFGDFGDFGF");
		if(CompareTariff.getDualFuel().contains("Y")){
			browser.wait(5000);
			DuelFuel_BuyNow(CompareTariff, userProfile);
			browser.wait(2000);
			
		}
		else
		{
			browser.wait(5000);
			System.out.println("Go To single fuel Account");
			SingleFuelBuynow(CompareTariff, userProfile);
		}
		
	}

public void BuyTariff(CompareTariff CompareTariff, UserProfile userProfile ) {
	browser.wait(2000);
		System.out.println("TTTTTTTTTTTTTTTTTTTTTGDFGDFGF");
		/*verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.GasConsumption"),"Gas consumption", "12500");
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectConsumption"),"Elect consumption", "3100");
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Nothanks"), "No Thanks");
		QuoteButton();
		Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");*/
		Buynow(CompareTariff);
		Buyorder(userProfile);
		YourAddress(userProfile);
		
		
	}

public void BuyElectTariff(CompareTariff CompareTariff, UserProfile userProfile ) {
	browser.wait(2000);
		System.out.println("TTTTTTTTTTTTTTTTTTTTTGDFGDFGF");
		//verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.GasConsumption"),"Gas consumption", "12500");
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectConsumption"),"Elect consumption", "3100");
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Nothanks"), "No Thanks");
		QuoteButton();
		Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
		Buynow(CompareTariff);
		Placeorder(userProfile);
		YourAddress(userProfile);
		
		
	}

public void BuyGasTariff(CompareTariff CompareTariff, UserProfile userProfile ) {
	browser.wait(2000);
		System.out.println("TTTTTTTTTTTTTTTTTTTTTGDFGDFGF");
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.GasConsumption"),"Gas consumption", "12500");
		//verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectConsumption"),"Elect consumption", "3100");
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Nothanks"), "No Thanks");
		QuoteButton();
		Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
		Buynow(CompareTariff);
		Placeorder(userProfile);
		YourAddress(userProfile);
		
		
	}

public void Buyorder(UserProfile userProfile) {
	browser.wait(2000);
		System.out.println("TTTTTTTTTTTTTTTTTTTTTGDFGDFGF");
		
		//verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.title"),"Title",userProfile.getTitle());
		
		//verifyAndSelectDropDownBox(GetAquoteProperties.getProperty("GetAQuotePage.title"),"Title", "Mr");
		Select select = new Select(browser.getElementByXpath(GetAquoteProperties.getProperty("GetAQuotePage.title")));
		select.selectByIndex(1);
		
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.FirstName"),"First Name", userProfile.getFirstName());
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.LastName"),"Last Name", userProfile.getLastName());
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.BirthDate"),"Birth Date", "10");
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.BirthMonth"),"Birth Month", "05");
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.BirthYear"),"Birth Year", "1995");
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.email"),"Email", userProfile.getEmail());
		Report.updateTestLog("Details updated successfully","WARN");
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.addressbutton"), "Your Address");
			
		
	}

public void Placeorder(UserProfile userProfile) {
	browser.wait(2000);
		System.out.println("TTTTTTTTTTTTTTTTTTTTTGDFGDFGF");
		
		//verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.title"),"Title",userProfile.getTitle());
		
		//verifyAndSelectDropDownBox(GetAquoteProperties.getProperty("GetAQuotePage.title"),"Title", "Mr");
		Select select = new Select(browser.getElementByXpath(GetAquoteProperties.getProperty("GetAQuotePage.title")));
		select.selectByIndex(1);
		
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.FirstName"),"First Name", userProfile.getFirstName());
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.LastName"),"Last Name", userProfile.getLastName());
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.BirthDate"),"Birth Date", "10");
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.BirthMonth"),"Birth Month", "05");
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.BirthYear"),"Birth Year", "1995");
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.email"),"Email", userProfile.getEmail());
		Report.updateTestLog("Details updated successfully","WARN");
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.addressbutton"), "Your Address");
			
		
	}

public void YourAddress(UserProfile userProfile) {
	browser.wait(2000);
		System.out.println("TTTTTTTTTTTTTTTTTTTTTGDFGDFGF");
		
		Select select = new Select(browser.getElementByXpath(GetAquoteProperties.getProperty("GetAQuotePage.AddressDropdown")));
		select.selectByIndex(1);
		
		//verifyAndSelectDropDownBoxbyindex(GetAquoteProperties.getProperty("GetAQuotePage.AddressDropdown"),2);
		Select select1 = new Select(browser.getElementByXpath(GetAquoteProperties.getProperty("GetAQuotePage.AddressYear")));
		select1.selectByIndex(6);
		//verifyAndSelectDropDownBoxbyindex(GetAquoteProperties.getProperty("GetAQuotePage.AddressYear"),6);
		Select select2 = new Select(browser.getElementByXpath(GetAquoteProperties.getProperty("GetAQuotePage.AddressMonth")));
		select2.selectByIndex(4);
		browser.wait(2000);
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Aware"), "Aware");
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.YourPaymentAddressNew"),"Your Payment Button");
		browser.wait(2000);
		if(browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Password"))){
			verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.Password"),"Password", userProfile.getPassword());	
		}
		if(browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.YourPayment"))){
			verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.YourPayment"), "Your Payment");	
		}
		
		browser.wait(2000);
	}

public void PaymentDetail(Acquisition acquisition) {
	browser.wait(2000);
		System.out.println("TTTTTTTTTTTTTTTTTTTTTGDFGDFGF");
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.AccountNumber"),"Account Number",acquisition.getPaymentAccountNumber());
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.SortCode1"),"Account Number",acquisition.getSortCode1());
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.SortCode2"),"Sort Code1",acquisition.getSortCode2());
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.SortCode3"),"Sort Code2",acquisition.getSortCode3());
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.SortCode3"),"Sort Code3",acquisition.getSortCode3());
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.HolderName"),"Card Holder Name",acquisition.getAccountName());
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.CheckOrder"), "Check Order");
		browser.wait(2000);
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.CheckBox"), "Terms and Conditions");
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.PlaceOrder"), "Place Order");
		confirmationPage();
	}

public void confirmationPage() {
	browser.wait(2000);
		System.out.println("TTTTTTTTTTTTTTTTTTTTTGDFGDFGF");
		verifyIsTextPresent(GetAquoteProperties.getProperty("GetAQuotePage.ConfirmationPageTitle"));
		String OrderNumber="";
		OrderNumber=browser.getTextByXpath(GetAquoteProperties.getProperty("GetAQuotePage.OrderNumber"));
		Report.updateTestLog("******************"+OrderNumber+"******************", "WARN");
		
		
	}


	


	
public void SingleFuel(CompareTariff CompareTariff) {
		
	String PropCode = CompareTariff.getPropositionCode();
	String PropCodefinal = PropCode.substring(0, 1);
	
	
	//String PropCode = CompareTariff.getPropositionCode();
	
	System.out.println("************************"+PropCodefinal);
	if(PropCodefinal.contains("E")){
			browser.wait(5000);
			System.out.println("************Single Electricity Fuel*******");
			verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectricityQuote"), "Electricity quote");
			browser.wait(2000);
			if(CompareTariff.getNOR().contains("0002"))
			{
				System.out.println("SEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLL");
				//Economymeterselect(CompareTariff);
				Economymeterselectfinal();
				browser.wait(2000);
				Payenergy(CompareTariff);
				browser.wait(2000);
				//QuoteButton();
				browser.wait(2000);
				verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.KnowKwh"), "I Know");
				browser.wait(2000);
				browser.ClickTabKey();
				browser.ClickTabKey();
				verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectConsumption"),"Electricity Consumption", CompareTariff.getAnnualConsumption());
				
				/*browser.CopytoClipboard1("3100");
				browser.ClickTabKey();
				browser.ClickTabKey();
				browser.wait(2000);
				browser.PasteClipboardContent();*/
				if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.NothanksNew01")))
				{
				verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.NothanksNew01"), "No Thanks");
				}
				
				/*if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Flat")))
				{*/
				browser.ClickTabKey();
				browser.ClickTabKey();
				browser.ClickTabKey();
				browser.ClickEnterKey();
				browser.ClickTabKey();
				browser.ClickTabKey();		
				browser.ClickTabKey();
				browser.ClickEnterKey();
				browser.ClickTabKey();
				browser.ClickTabKey();
				browser.ClickTabKey();
				browser.ClickEnterKey();
				browser.ClickTabKey();
				browser.ClickTabKey();
				browser.ClickTabKey();
				browser.ClickEnterKey();
				browser.ClickTabKey();
				browser.ClickEnterKey();
				//}
				QuoteButton();
				Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
				clickInfo(CompareTariff);
				verifyPricingElect(CompareTariff);
				closeTariff();
			
			}
			if(CompareTariff.getNOR().contains("0001"))
			{
				System.out.println("00000001111111111SEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLL");
				//Economymeter(CompareTariff);
				browser.wait(2000);
				Payenergy(CompareTariff);
				browser.wait(2000);
				//QuoteButton();
				browser.wait(2000);
				verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.KnowKwh"), "I Know");
				browser.wait(2000);
				browser.ClickTabKey();
				browser.ClickTabKey();
				verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectConsumption"),"Electricity Consumption", CompareTariff.getAnnualConsumption());
				/*browser.CopytoClipboard1("3100");
				browser.ClickTabKey();
				browser.ClickTabKey();
				browser.wait(2000);
				browser.PasteClipboardContent();
				browser.wait(2000);*/
				if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.NothanksNew01")))
				{
				verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.NothanksNew01"), "No Thanks");
				}
				
				/*if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Flat")))
				{*/
				browser.ClickTabKey();
				browser.ClickTabKey();
				browser.ClickTabKey();
				browser.ClickEnterKey();
				browser.ClickTabKey();
				browser.ClickTabKey();
				browser.ClickTabKey();
				browser.ClickEnterKey();
				browser.ClickTabKey();
				browser.ClickTabKey();
				browser.ClickTabKey();
				browser.ClickEnterKey();
				browser.ClickTabKey();
				browser.ClickTabKey();
				browser.ClickTabKey();
				browser.ClickEnterKey();
				browser.ClickTabKey();
				browser.ClickEnterKey();
				//}
				QuoteButton();
				Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
				clickInfo(CompareTariff);
				verifyPricing(CompareTariff);
				closeTariff();		
			}
			
		}
	
	//else if(CompareTariff.getPropositionCode().contains(PropCode)){
	else if(PropCodefinal.contains("G")){
			browser.wait(3000);
			//GasQuoteVerification(CompareTariff);
			System.out.println("Gas Single Fuel");
			verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.GasQuote"), "Gas quote");
			Payenergy(CompareTariff);
			browser.wait(2000);
			//QuoteButton();
			browser.wait(2000);
			verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.KnowKwh"), "I Know");
			browser.wait(2000);
			browser.ClickTabKey();
			browser.ClickTabKey();
			verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.GasConsumption"),"Gas Consumption", CompareTariff.getAnnualConsumption());
			/*browser.CopytoClipboard("12500");
			browser.ClickTabKey();
			browser.wait(2000);
			browser.ClickTabKey();
			browser.PasteClipboardContent();
			browser.wait(2000);*/
			verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.NothanksNew"), "No Thanks");
			//verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.GasConsumption"),"Gas consumption", "12500");
			QuoteButton();
			Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
			clickInfo(CompareTariff);
			verifyPricing(CompareTariff);
			closeTariff();
		}
		
	}

public void SingleFuelBuynow(CompareTariff CompareTariff, UserProfile userProfile) {
	
	if(CompareTariff.getPropositionCode().contains("GSD")){
		browser.wait(5000);
		System.out.println("NEWWWWWW010101010101010101WWWWWWWWWWWWW");
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectricityQuote"), "Electricity quote");
		browser.wait(2000);
		if(CompareTariff.getNOR().contains("0002"))
		{
			System.out.println("SEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLL");
			Economymeterselect(CompareTariff);
			browser.wait(2000);
			Payenergy(CompareTariff);
			verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectConsumption"),"Elect consumption", CompareTariff.getAnnualConsumption());
			QuoteButton();
			Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
			BuyTariff(CompareTariff,userProfile );
			/*clickInfo(CompareTariff);
			verifyPricingElect(CompareTariff);
			closeTariff();*/
		
		}
		if(CompareTariff.getNOR().contains("0001"))
		{
			System.out.println("00000001111111111SEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLL");
			Economymeter(CompareTariff);
			browser.wait(2000);
			Payenergy(CompareTariff);
			verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectConsumption"),"Elect consumption", CompareTariff.getAnnualConsumption());
			QuoteButton();
			Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
			BuyTariff(CompareTariff,userProfile );
			/*clickInfo(CompareTariff);
			verifyPricing(CompareTariff);
			closeTariff();	*/	
		}
		
	}
	else if(CompareTariff.getPropositionCode().contains("ESD")){
		browser.wait(3000);
		//GasQuoteVerification(CompareTariff);
		System.out.println("HELLLLLLLLLLLLLLO");
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.GasQuote"), "Gas quote");
		Payenergy(CompareTariff);
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.GasConsumption"),"Gas consumption", CompareTariff.getAnnualConsumption());
		QuoteButton();
		Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
		BuyTariff(CompareTariff,userProfile );
		/*clickInfo(CompareTariff);
		verifyPricing(CompareTariff);
		closeTariff();*/
	}
	
}

public void DuelFuel(UserProfile userProfile,CompareTariff CompareTariff) {
	browser.wait(2000);
	verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Duelfuel"), "Duel Fuel quote");
	browser.wait(2000);
	System.out.println("Verifying the Propotion Code#$%^^$%^$%^%$%^$%^");
	
	String PropCode = CompareTariff.getPropositionCode();
	String PropCodefinal = PropCode.substring(0, 1);
	
	System.out.println("************************"+PropCodefinal);
	if(PropCodefinal.contains("E")){
	
	//if(CompareTariff.getPropositionCode().contains(PropCode)){
		browser.wait(2000);
		System.out.println("DDDDDDDDDDDDDDIIIIII1010101WWWWWWWWWWWWW");
	if(CompareTariff.getNOR().contains("0002"))
	{
		System.out.println("SEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLL");
		//Economymeterselect(CompareTariff);
		
		browser.wait(2000);
		Payenergy(CompareTariff);
		Economymeterselectfinal();
		browser.wait(2000);
		//QuoteButton();
		browser.wait(2000);
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.KnowKwh"), "I Know");
		browser.wait(2000);
		/*browser.CopytoClipboard("12500");
		browser.wait(2000);
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.PasteClipboardContent();
		//browser.ClickTabKey();
		browser.wait(2000);
		browser.CopytoClipboard1("3100");
		browser.ClickTabKey();
		browser.wait(2000);
		browser.PasteClipboardContent();*/
		browser.ClickTabKey();
		browser.ClickTabKey();
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.GasConsumption"),"Gas consumption", "12000");
		browser.ClickTabKey();
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectConsumption"),"Elect consumption", "3100");
		if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.NothanksNew01")))
		{
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.NothanksNew01"), "No Thanks");
		}
		
		/*if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Flat")))
		{*/
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickEnterKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickEnterKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickEnterKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickEnterKey();
		browser.ClickTabKey();
		browser.ClickEnterKey();
		
		/*browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickEnterKey();*/
		//}
		QuoteButton();
		Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
		browser.wait(2000);
		/*clickDuelGasInfo(CompareTariff);
		verifyPricing(CompareTariff);
		closeTariff();*/
		clickDuelElectInfo(CompareTariff);
		verifyPricingElect(CompareTariff);
		closeTariff();
	
	}
	else if(CompareTariff.getNOR().contains("0001"))
	{
		System.out.println("00000001111111111SEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLL");
		//Economymeter(CompareTariff);
		browser.wait(2000);
		Payenergy(CompareTariff);
		browser.wait(2000);
		//QuoteButton();
		browser.wait(2000);
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.KnowKwh"), "I Know");
		browser.wait(2000);
		/*browser.CopytoClipboard("12500");
		browser.wait(2000);
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.PasteClipboardContent();
		//browser.ClickTabKey();
		browser.wait(2000);
		browser.CopytoClipboard1("3100");
		browser.ClickTabKey();
		browser.wait(2000);
		browser.PasteClipboardContent();*/
		browser.ClickTabKey();
		browser.ClickTabKey();
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.GasConsumption"),"Gas consumption", "12000");
		browser.ClickTabKey();
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectConsumption"),"Elect consumption", "3100");
		if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.NothanksNew01")))
		{
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.NothanksNew01"), "No Thanks");
		}
		
		/*if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Flat")))
		{*/
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickEnterKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickEnterKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickEnterKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickEnterKey();
		browser.ClickTabKey();
		browser.ClickEnterKey();
		
		/*browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickEnterKey();*/
		//}
		QuoteButton();
		Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
		browser.wait(2000);
		/*clickDuelGasInfo(CompareTariff);
		verifyPricing(CompareTariff);
		closeTariff();*/
		clickDuelElectInfo(CompareTariff);
		verifyPricing(CompareTariff);
		closeTariff();
				
	}
}
	else if(PropCodefinal.contains("G")){
	//else if(CompareTariff.getPropositionCode().contains(PropCode)){
		browser.wait(5000);
		System.out.println("GGGGGGGGGGGGGGGGGII1010101WWWWWWWWWWWWW");
	if(CompareTariff.getNOR().contains("0002"))
	{
		System.out.println("SEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLL");
		//Economymeterselect(CompareTariff);
		Economymeterselectfinal();
		browser.wait(2000);
		Payenergy(CompareTariff);
		browser.wait(2000);
		//QuoteButton();
		browser.wait(2000);
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.KnowKwh"), "I Know");
		browser.wait(2000);
		/*browser.CopytoClipboard("12500");
		browser.wait(2000);
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.PasteClipboardContent();
		//browser.ClickTabKey();
		browser.wait(2000);
		browser.CopytoClipboard1("3100");
		browser.ClickTabKey();
		browser.wait(2000);
		browser.PasteClipboardContent();*/
		browser.ClickTabKey();
		browser.ClickTabKey();
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.GasConsumption"),"Gas consumption", "12000");
		browser.ClickTabKey();
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectConsumption"),"Elect consumption", "3100");
		if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.NothanksNew01")))
		{
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.NothanksNew01"), "No Thanks");
		}
		
		/*if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Flat")))
		{*/
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickEnterKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickEnterKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickEnterKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickEnterKey();
		
		/*browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickEnterKey();*/
		//}
		QuoteButton();
		Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
		//verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.NothanksNew01"), "No Thanks");
		browser.wait(2000);
		clickDuelGasInfo(CompareTariff);
		verifyPricing(CompareTariff);
		closeTariff();
		/*clickDuelElectInfo(CompareTariff);
		verifyPricingElect(CompareTariff);
		closeTariff();*/
	
	}
	else if(CompareTariff.getNOR().contains("0001"))
	{
		System.out.println("00000001111111111SEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLL");
		//Economymeter(CompareTariff);
		browser.wait(2000);
		Payenergy(CompareTariff);
		browser.wait(2000);
		//QuoteButton();
		browser.wait(2000);
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.KnowKwh"), "I Know");
		browser.wait(2000);
		/*browser.CopytoClipboard("12500");
		browser.wait(2000);
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.PasteClipboardContent();
		//browser.ClickTabKey();
		browser.wait(2000);
		browser.CopytoClipboard1("3100");
		browser.ClickTabKey();
		browser.wait(2000);
		browser.PasteClipboardContent();*/
		browser.ClickTabKey();
		browser.ClickTabKey();
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.GasConsumption"),"Gas consumption", "12000");
		browser.ClickTabKey();
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectConsumption"),"Elect consumption", "3100");
		if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.NothanksNew01")))
		{
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.NothanksNew01"), "No Thanks");
		}
		
		/*if (browser.isElementVisibleWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Flat")))
		{*/
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickEnterKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickEnterKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickEnterKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickEnterKey();
		
		/*browser.ClickTabKey();
		browser.ClickTabKey();
		browser.ClickEnterKey();*/
		//}
		QuoteButton();
		Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
		browser.wait(2000);
		clickDuelGasInfo(CompareTariff);
		verifyPricing(CompareTariff);
		closeTariff();
		/*clickDuelElectInfo(CompareTariff);
		verifyPricing(CompareTariff);
		closeTariff();*/
				
	}
}
	
	
	
}

public void DuelFuel_BuyNow(CompareTariff CompareTariff, UserProfile userProfile) {
	
	verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Duelfuel"), "Duel Fuel quote");
	browser.wait(2000);
	if(CompareTariff.getPropositionCode().contains("ESD")){
		browser.wait(5000);
		System.out.println("DDDDDDDDDDDDDDIIIIII1010101WWWWWWWWWWWWW");
	if(CompareTariff.getNOR().contains("0002"))
	{
		System.out.println("SEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLL");
		Economymeterselect(CompareTariff);
		browser.wait(2000);
		Payenergy(CompareTariff);
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.GasConsumption"),"Gas consumption", "12500");
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectConsumption"),"Elect consumption", "3100");
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Nothanks"), "No Thanks");
		QuoteButton();
		Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
		BuyTariff(CompareTariff,userProfile );
		
		/*clickDuelGasInfo();
		verifyPricing(CompareTariff);
		closeTariff();
		clickDuelElectInfo();
		verifyPricingElect(CompareTariff);
		closeTariff();*/
	
	}
	else if(CompareTariff.getNOR().contains("0001"))
	{
		System.out.println("00000001111111111SEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLL");
		Economymeter(CompareTariff);
		browser.wait(2000);
		Payenergy(CompareTariff);

		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.GasConsumption"),"Gas consumption", "12500");
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectConsumption"),"Elect consumption", "3100");
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Nothanks"), "No Thanks");
		QuoteButton();
		Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
		BuyTariff(CompareTariff,userProfile );
		/*clickDuelGasInfo();
		verifyPricing(CompareTariff);
		closeTariff();
		clickDuelElectInfo();
		verifyPricing(CompareTariff);
		closeTariff();*/
				
	}
}
	
	else if(CompareTariff.getPropositionCode().contains("GSD")){
		browser.wait(5000);
		System.out.println("GGGGGGGGGGGGGGGGGII1010101WWWWWWWWWWWWW");
	if(CompareTariff.getNOR().contains("0002"))
	{
		System.out.println("SEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLL");
		Economymeterselect(CompareTariff);
		browser.wait(2000);
		Payenergy(CompareTariff);
		
		
		
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.GasConsumption"),"Gas consumption", "12500");
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectConsumption"),"Elect consumption", "3100");
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Nothanks"), "No Thanks");
		QuoteButton();
		Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
		BuyTariff(CompareTariff,userProfile );
		/*clickDuelGasInfo();
		verifyPricing(CompareTariff);
		closeTariff();
		clickDuelElectInfo();
		verifyPricingElect(CompareTariff);
		closeTariff();*/
	
	}
	else if(CompareTariff.getNOR().contains("0001"))
	{
		System.out.println("00000001111111111SEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLL");
		Economymeter(CompareTariff);
		browser.wait(2000);
		Payenergy(CompareTariff);

		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.GasConsumption"),"Gas consumption", "12500");
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectConsumption"),"Elect consumption", "3100");
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Nothanks"), "No Thanks");

		
		QuoteButton();
		Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
		BuyTariff(CompareTariff,userProfile );
		/*clickDuelGasInfo();
		verifyPricing(CompareTariff);
		closeTariff();
		clickDuelElectInfo();
		verifyPricing(CompareTariff);
		closeTariff();*/
				
	}
}
	
	
	
}

public void GasQuotePricing(CompareTariff CompareTariff)
    {
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.GasQuote"), "Gas quote");
		Payenergy(CompareTariff);
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.GasConsumption"),"Gas consumption", CompareTariff.getAnnualConsumption());
		QuoteButton();
		Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
		clickInfo(CompareTariff);
		verifyPricing(CompareTariff);
		closeTariff();

    }

public void ElectQuotePricing(CompareTariff CompareTariff)
{
	if(CompareTariff.getNOR().contains("0002"))
	{
		System.out.println("SEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLL");
		Economymeterselect(CompareTariff);
		browser.wait(2000);
		Payenergy(CompareTariff);
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectConsumption"),"Elect consumption", CompareTariff.getAnnualConsumption());
		QuoteButton();
		Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
		clickInfo(CompareTariff);
		verifyPricingElect(CompareTariff);
		closeTariff();
	
	}
	if(CompareTariff.getNOR().contains("0001"))
	{
		System.out.println("00000001111111111SEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLL");
		Economymeter(CompareTariff);
		browser.wait(2000);
		Payenergy(CompareTariff);
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectConsumption"),"Elect consumption", CompareTariff.getAnnualConsumption());
		QuoteButton();
		Report.updateTestLog("Details updated successfully and quote button is Clicked ","WARN");
		clickInfo(CompareTariff);
		verifyPricing(CompareTariff);
		closeTariff();		
	}

}


public void GasQuoteVerification(CompareTariff CompareTariff) {
	
	verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.GasQuote"), "Gas quote");
	browser.wait(2000);
	Payenergy(CompareTariff);
	verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.GasConsumption"),"Gas consumption", "12500");
	
	/*if(CompareTariff.getPropositionCode().contains("GFO")){
		browser.wait(3000);
		System.out.println("HELLLLLLLLLLLLLLO");
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.GasQuote"), "Gas quote");
		Payenergy(CompareTariff);
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.GasConsumption"),"Gas consumption", "12500");
	}*/
	verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.quotebutton"), "quote button");
	
}

public void QuoteButton() {
	
	verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.quotebutton"), "quote button");
	
	
}

public void ElectQuoteVerification(CompareTariff CompareTariff) {
	
		System.out.println("HELLLLLLLLLLLLLLO");
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectricityQuote"), "Elect quote");
		Payenergy(CompareTariff);
		verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.GasConsumption"),"Gas consumption", "3100");
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.quotebutton"), "quote button");
	
}

public void Economymeter(CompareTariff CompareTariff) {
	
System.out.println("DEEEEEEEEEEEEEEEEECCCOOOOOOONNNNNNNNN");

if(browser.getElementByXpath((GetAquoteProperties.getProperty("GetAQuotePage.Economymeter"))).getAttribute("class").equals("ember-view input-checkbox fa fa-check __input-checkbox__6ccfe checked")){
	
	browser.clickWithXpath((GetAquoteProperties.getProperty("GetAQuotePage.Economymeter")));
}
				
else
{
	System.out.println("It should not select");
}

System.out.println("DONNNNNNNNNNNNNNNEEEEEEEEEEEE");
	
		
		//	verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Economymeter"), "Economy 7 is checked in");	
	
	
}

public void Economymeterselect(CompareTariff CompareTariff) {
	
	System.out.println("ECCCOOOOOOONNNNNNNNN");
	browser.wait(2000);
	

	if(browser.getElementByXpath((GetAquoteProperties.getProperty("GetAQuotePage.Economymeter"))).getAttribute("class").equals("ember-view input-checkbox fa fa-check __input-checkbox__6ccfe checked")){
		System.out.println("It is already selected");
	}
					//verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Economymeter"), "Economy 7 is checked in");
	else
	{
		browser.clickWithXpath((GetAquoteProperties.getProperty("GetAQuotePage.Economymeter")));
	}
	
	
	
}


			public void Economymeterselectfinal() {
				
				System.out.println("ECCCOOOOOOONNNNNNNNNFFFFFINNNNNNNNNAAAAAAAAALLLLLLLLLL");
				browser.wait(2000);
				
			//verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Elect7EconomyMeterFinal"), "Economy 7 is checked in");
			
			verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Multi-Rate"), "Economy 7 is checked in");
			browser.wait(1000);
			verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Elect7EconomyMeterFinal01"), "Economy 7 is checked in");
				
				
			}

	
	public void TariffpricingVerification(CompareTariff CompareTariff) {
		
		if(CompareTariff.getPropositionCode().contains("EFO")){
			browser.wait(5000);
			System.out.println("NEWWWWWW010101010101010101WWWWWWWWWWWWW");
			verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectricityQuote"), "Electricity quote");
			browser.wait(2000);
			Payenergy(CompareTariff);
			verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.ElectConsumption"),"Elect consumption", "3100");
		}
		else if(CompareTariff.getPropositionCode().contains("GFO")){
			browser.wait(3000);
			System.out.println("HELLLLLLLLLLLLLLO");
			verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.GasQuote"), "Gas quote");
			Payenergy(CompareTariff);
			verifyAndInputByXpath(GetAquoteProperties.getProperty("GetAQuotePage.GasConsumption"),"Gas consumption", "12500");
		}
		verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.quotebutton"), "quote button");
		
	}
	
public void Payenergy(CompareTariff CompareTariff) {
		
		if(CompareTariff.getPaymentOption().contains("Direct debit - VDD")){
			browser.wait(5000);
			System.out.println("Direct Debit");
			verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.MonthlyDD"), "Monthly Direct Debit");
			
			
		}
		else if(CompareTariff.getPaymentOption().contains("Cash or Cheque")){
			System.out.println("++++++++++++++++++++++");
			verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.CashorCheque"),"cash Or Cheque");
		}
		else if(CompareTariff.getPaymentOption().contains("Prepayment")){
			System.out.println("++++++++++++++++++++++");
			
			verifyAndClickWithXpath(GetAquoteProperties.getProperty("GetAQuotePage.Prepayment"),"PrePayment");
		}
		
	}







	
	
}
