package bg.framework.app.functional.page.sales;

import java.text.DecimalFormat;
import java.util.Properties;
import org.openqa.selenium.support.ui.*;
import bg.framework.app.functional.entities.BoilerReplaceProfile;
import bg.framework.app.functional.entities.EshopTariffProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;



public class BoilerReplacePage extends BasePage{
	private final static String FILE_NAME = "resources/sales/BoilerReplacePageProperties.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	
	public void navigateToBoilerReplacePage(){
		//navigating to products page
		verifyAndClickWithXpath(pageProperties.getProperty("BoilerReplacePage.ProductAndServices"), "Product & Services Button");
		
		browser.wait(3000);
		//navigate to new boilers page
		verifyAndClickWithXpath(pageProperties.getProperty("BoilerReplacePage.NewBoilersLink"), "New Boilers Link");
		
		browser.wait(3000);
		//navigate to BoilerReplace Link
		//verifyAndClickWithLinkText(pageProperties.getProperty("BoilerReplacePage.BoilerReplaceLink"), "BoilerReplace Link");
		//browser.open("http://10.224.70.76/content/britishgas/test/boiler-replacing.html");
		browser.open("http://10.224.70.111/products-and-services/boilers-and-central-heating/new-boilers/does-your-boiler-need-replacing.html");
	}
	
	public void validateGCNBoilerReplace(){
		BoilerReplaceProfile boilerReplace = new TestDataHelper().getBoilerReplaceProfile("BoilerCount");
		int boilerCount = Integer.parseInt(boilerReplace.getIteration());
		Select BoilerMakeElement, BoilerModelElement;
		String BoilerMake, BoilerModel;
		String property[] = {"Bungalow","Detached","Flat or apartment","Semi-detached","Terraced"};
		
		//Iteration for different boiler type
		for(int i=1;i<=boilerCount;i++){
			//for(int i=1;i<=1;i++){
			boilerReplace = new TestDataHelper().getBoilerReplaceProfile("BoilerReplace"+i);
			
			//Set the gas council number
			verifyAndInputByXpath(pageProperties.getProperty("BoilerReplacePage.GasCouncilNo"), "Gas Council No",boilerReplace.getGasCouncilNo());
			
			//Click the Gas council button
			verifyAndClickWithXpath(pageProperties.getProperty("BoilerReplacePage.GasCouncilSubmitButton"), "Gas Council Button");
			
			browser.wait(2000);
			//Get Boiler Model
			BoilerMakeElement = new Select(browser.getElementByXpath(pageProperties.getProperty("BoilerReplacePage.BoilerMake")));
			BoilerMake = BoilerMakeElement.getFirstSelectedOption().getText();
			
			//Get BoilerModel
			BoilerModelElement = new Select(browser.getElementByXpath(pageProperties.getProperty("BoilerReplacePage.BoilerModel")));
			BoilerModel = BoilerModelElement.getFirstSelectedOption().getText();
		
			Report.updateTestLog("**************** Gas Council No  : "+boilerReplace.getGasCouncilNo()+" ******************", "pass");
			
			for(int j=0;j<property.length;j++){
				browser.wait(2000);
				verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("BoilerReplacePage.BoilerProperty"), "Boiler Property", property[j]);
				verifyBoilerReplaceValues(boilerReplace, BoilerMake, BoilerModel, property[j]);
			}
			
		}
		
	}
	
	
	public void validateBoilersReplace(){
		BoilerReplaceProfile boilerReplace = new TestDataHelper().getBoilerReplaceProfile("BoilerCount");
		int boilerCount = Integer.parseInt(boilerReplace.getIteration());
		Select BoilerMakeElement, BoilerModelElement;
		String BoilerMake, BoilerModel, GasCouncilNo;
		String property[] = {"Bungalow","Detached","Flat or apartment","Semi-Detached","Terraced"};
		
		//Iteration for different boiler type
		for(int i=1;i<=boilerCount;i++){
			boilerReplace = new TestDataHelper().getBoilerReplaceProfile("BoilerReplace"+i);
			BoilerMake = boilerReplace.getBoilerMake();
			BoilerModel = boilerReplace.getBoilerModel();
			GasCouncilNo = boilerReplace.getGasCouncilNo();
						
			//Select the Boiler Make
			verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("BoilerReplacePage.BoilerMake"), " Boiler Make - "+BoilerMake , BoilerMake);
			
			//Select the Boiler Model
			verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("BoilerReplacePage.BoilerModel"), "Boiler Model - "+BoilerModel, BoilerModel);
			
			//verify populated Text
			if(browser.getAttributeByXpath(pageProperties.getProperty("BoilerReplacePage.GasCouncilNo"), "value").contains(GasCouncilNo)){
				Report.updateTestLog("Gas Council Number "+GasCouncilNo, "Pass");
			}
			else{
				Report.updateTestLog("Gas Council Number Mismatch : Displayed "+browser.getAttributeByXpath(pageProperties.getProperty("BoilerReplacePage.GasCouncilNo"),"value")+" Input Given "+GasCouncilNo, "Fail");
			}
			
			for(int j=0;j<property.length;j++){
				browser.wait(2000);
				verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("BoilerReplacePage.BoilerProperty"), "Boiler Property", property[j]);
				verifyBoilerReplaceValues(boilerReplace, BoilerMake, BoilerModel, property[j]);
			}
			
		}
		
	}
	
	public void verifyBoilerReplaceValues(BoilerReplaceProfile boilerReplace, String BoilerMake, String BoilerModel, String Property){
		String Rating="", Efficiency="";
		double FUEL_BG=12.53, BOILER_LIFE = 15, EFFICIENT_BOILER = 0.87;
		double CurrentAnnualCost, UpgradedAnnualCost, AnnualSaving, LifeTimeSaving; 
		
		//verifying Boiler Make
		if(BoilerMake.contains(boilerReplace.getBoilerMake())){
			Report.updateTestLog("Boiler Make Populated successfully "+BoilerMake, "Pass");
		}
		else{
			Report.updateTestLog("Boiler Make Mismatch : Populated Value is : "+BoilerMake+" Input Value is : "+boilerReplace.getBoilerMake(), "Fail");
		}
		
		//verify Boiler Model
		if(BoilerModel.contains(boilerReplace.getBoilerModel())){
			Report.updateTestLog("Boiler Model Populated successfully "+BoilerModel, "Pass");
		}
		else{
			Report.updateTestLog("Boiler Model Mismatch : Populated Value is : "+BoilerModel+" Input Value is : "+boilerReplace.getBoilerModel(), "Fail");
		}
		
		//Rating and Efficiency Verification
		Rating = boilerReplace.getRating();
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BoilerReplacePage.Efficiency"+Rating))){
			Report.updateTestLog("Rating Displayed successfully : "+Rating, "Pass");
			Efficiency = boilerReplace.getEfficient();
			if(browser.getTextByXpath(pageProperties.getProperty("BoilerReplacePage.Efficiency"+Rating)).replace("%", "").contains(Efficiency)){
				Report.updateTestLog("Efficiency Displayed successfully "+Efficiency, "Pass");
			}
			else{
				Report.updateTestLog("Efficiency Displayed Mismatch, Efficiency displayed "+browser.getTextByXpath(pageProperties.getProperty("BoilerReplacePage.Efficiency"+Rating)).replace("%", "")+" Efficiency input sheet "+Efficiency, "Fail");
			}
		}
		else{
			Report.updateTestLog("Your Rating Section Mismatch : "+Rating, "Fail");
		}
		
		
		
		//Cost Verification
		DecimalFormat df = new DecimalFormat("0.00");
		double PropertyValue = selectProperty(Property);
		double EfficientValue = Double.parseDouble(boilerReplace.getEfficient());
		
		CurrentAnnualCost = (double)Math.round((PropertyValue/ ((double)EfficientValue / 100))* FUEL_BG *100)/100;
		CurrentAnnualCost = Double.parseDouble(df.format(CurrentAnnualCost));
		UpgradedAnnualCost = Double.parseDouble(df.format((double)Math.round((double)selectProperty(Property) / EFFICIENT_BOILER * FUEL_BG * 100) / 100));
		AnnualSaving = Double.parseDouble(df.format(CurrentAnnualCost - UpgradedAnnualCost));
		AnnualSaving = Math.round(AnnualSaving);
		LifeTimeSaving = Double.parseDouble(df.format(AnnualSaving * BOILER_LIFE));
		
		//Cost Saving not available for Rating A
		if(!boilerReplace.getRating().equalsIgnoreCase("A")){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BoilerReplacePage.AnnualSaving"))){
				Report.updateTestLog("Annual Savings and Life Time Savings displayed successfully", "Pass");
				
				//Annual Cost Verification
				if(AnnualSaving == Double.parseDouble(browser.getTextByXpath(pageProperties.getProperty("BoilerReplacePage.AnnualSaving"))) || (AnnualSaving - Double.parseDouble(browser.getTextByXpath(pageProperties.getProperty("BoilerReplacePage.AnnualSaving")))) == -1.0 || (AnnualSaving - Double.parseDouble(browser.getTextByXpath(pageProperties.getProperty("BoilerReplacePage.AnnualSaving")))) == 1.0){
					Report.updateTestLog("Annual Saving Price verified successfully : "+AnnualSaving, "Pass");
				}
				else{
					Report.updateTestLog("Annual Saving Price Mismatch Input Given : "+AnnualSaving+ "Price Displayed : "+browser.getTextByXpath(pageProperties.getProperty("BoilerReplacePage.AnnualSaving")), "Fail");
				}
				
				//Life Time Cost Verification
				if(LifeTimeSaving == Double.parseDouble(browser.getTextByXpath(pageProperties.getProperty("BoilerReplacePage.LifeTimeSaving"))) || (LifeTimeSaving - Double.parseDouble(browser.getTextByXpath(pageProperties.getProperty("BoilerReplacePage.LifeTimeSaving"))) == -15.0) || (LifeTimeSaving - Double.parseDouble(browser.getTextByXpath(pageProperties.getProperty("BoilerReplacePage.LifeTimeSaving"))) == 15.0)){
					Report.updateTestLog("LifeTime Saving Price verified successfully : "+LifeTimeSaving, "Pass");
				}
				else{
					Report.updateTestLog("LifeTime Saving Price Mismatch Input Given : "+LifeTimeSaving+ "Price Displayed : "+browser.getTextByXpath(pageProperties.getProperty("BoilerReplacePage.LifeTimeSaving")), "Fail");
				}
				
			}
			else{
				Report.updateTestLog("Annual Savings and Life TIme Savings not displayed", "WARN");
			}
		}
		
		
		//Parts Availability Verification
		verifyPartsAvailability(boilerReplace.getPartsAvailable());
		
	}
	
	public void verifyPartsAvailability(String PartType){
		if(PartType.equalsIgnoreCase("y")){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BoilerReplacePage.PartsAvailabilityy"))){
				if(browser.getTextByXpath(pageProperties.getProperty("BoilerReplacePage.PartsAvailabilityy")).contains("parts availability")){
					Report.updateTestLog("Parts Availability Section displayed", "Pass");
				}
			}
			else{
				Report.updateTestLog("Parts Available Section Error", "Fail");
			}
		}
		else if(PartType.equalsIgnoreCase("o")){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BoilerReplacePage.PartsAvailabilityo"))){
				if(browser.getTextByXpath(pageProperties.getProperty("BoilerReplacePage.PartsAvailabilityo")).contains("british")){
					Report.updateTestLog("Not a british gas service displayed", "Pass");
				}
			}
			else{
				Report.updateTestLog("Not a british gas service Section Error", "Fail");
			}
		}
		else if(PartType.equalsIgnoreCase("n")){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BoilerReplacePage.PartsAvailabilityn"))){
				if(browser.getTextByXpath(pageProperties.getProperty("BoilerReplacePage.PartsAvailabilityn")).contains("no")){
					Report.updateTestLog("no parts available displayed", "Pass");
				}
			}
			else{
				Report.updateTestLog("no parts available Section Error", "Fail");
			}
		}
		else if(PartType.equalsIgnoreCase("m")){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BoilerReplacePage.PartsAvailabilitym"))){
				if(browser.getTextByXpath(pageProperties.getProperty("BoilerReplacePage.PartsAvailabilitym")).contains("some")){
					Report.updateTestLog("some parts available displayed", "Pass");
				}
			}
			else{
				Report.updateTestLog("some parts available Section Error", "Fail");
			}
		}
	}
	
	
	public double selectProperty(String Property){
		double Bungalow = 43.6, Detached = 72.9, Flat = 33.3, SemiDetached = 51.5, Terraced = 45.4;
		if(Property.equalsIgnoreCase("Bungalow")){
			return Bungalow;
		}
		else if(Property.equalsIgnoreCase("Detached")){
			return Detached;
		}
		else if(Property.equalsIgnoreCase("Flat or apartment")){
			return Flat;
		}
		else if(Property.equalsIgnoreCase("Semi-Detached")){
			return SemiDetached;
		}
		else{
			return Terraced;
		}
	}
}
