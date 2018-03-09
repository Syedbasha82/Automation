package bg.framework.app.functional.page.sales;

import java.io.BufferedWriter;
import org.openqa.selenium.support.ui.*;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.NoSuchElementException;
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
	private boolean OverlayFlag = true;
	

    private final static String FILE_NAME = "resources/sales/CompareTariff.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
    
    public void navigateToGasAndElectricityPage(){ 
	verifyAndClickWithLinkText(pageProperties.getProperty("CompareTariff.GasElectricity"), "Gas and electricity");
    	//browser.open("http://10.224.70.32/content/britishgas/products-and-services/gas-and-electricity.html");
    }
    
    public void navigateToTariffInformationPage(){
    	browser.open(ApplicationConfig.APP_BG_URL+"products-and-services/gas-and-electricity/our-energy-tariffs/tariff-information.html");
    	   					   
    	//Click on gas and Electricity Link
    	//verifyAndClickWithLinkText(pageProperties.getProperty("CompareTariff.allTariffPostCode"), "Gas and Electricity Link");
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
    
    public void verifyCompareTariffPage(String meterType,String tariff, String payment, String postCode){
    			verifyAndInputByXpath(pageProperties.getProperty("CompareTariff.postCodeFeild"),"post code",postCode);
    			browser.wait(5000);
    			String region1 = postCode;
    			String Region = new TCRCalculationPage().getPostcode(region1);
    			verifyAndSelectDropDownBox(pageProperties.getProperty("CompareTariff.tariff"),"Tariff Name",tariff);
    			if(payment.contains("MDD")){
    				verifyAndSelectDropDownBox(pageProperties.getProperty("CompareTariff.paymentType"),"payment Type","Monthly Direct Debit");
    			}
    			if(payment.contains("QCC")){
    				verifyAndSelectDropDownBox(pageProperties.getProperty("CompareTariff.paymentType"),"payment Type","Quarterly Cash/Cheque");
    			}
    			if(payment.contains("PPM")){
    				verifyAndSelectDropDownBox(pageProperties.getProperty("CompareTariff.paymentType"),"payment Type","Pay As You Go");
    			}
    				selectMeter(meterType);
    				verifyAndClickWithXpath(pageProperties.getProperty("CompareTariff.viewInformation"),"View Tariff Information clicked successfully");
    				verifyTILforTariff(payment,Region,meterType,tariff,postCode);
    			
    		}

    	public void navigateToAllTariffPage(){
    		browser.open(ApplicationConfig.APP_BG_URL+"/products-and-services/gas-and-electricity/our-energy-tariffs/Tariffs-A-Z.html");
    		Report.updateTestLog("Navigated to Our tariff Page successfully", "Pass");
    	}
    	
    	public void verifyTariffInformation(){
    	final CompareTariff compareTariff = new TestDataHelper().getCompareTariffProfiles("TariffNames");
    	String[] Tariffs = new String[20];
    	int i = 0, RowCount=0;
    	String TariffText = "";
    	boolean TariffPresentFlag=false;
    	
    	//Storing the tariff names in Tariffs variable
    	while((compareTariff.getTariffName(i+1)) != ""){
    		Tariffs[i] = compareTariff.getTariffName(i+1);
    		i = i+1;
    	}
    
    	i=0;
    	while(Tariffs[i]!=null){
    		verifyAndClickWithXpath(pageProperties.getProperty("CompareTariff.TariffInformationLink").replace("TARIFF", Tariffs[i]),Tariffs[i]+ " Tariff Information");
    		verifyPopulatedTariffs(Tariffs[i]);
    		browser.browserBack();
    		i=i+1;
    	}
    		
    
    }
    	
    	   
    public void verifyPopulatedTariffs(String Tariff){
    	try{
    		Select SelectTariffElement;
        	String PopulatedTariff="";
        	if(OverlayFlag==true){
        		browser.wait(5000);
            	if(browser.isElementVisible(pageProperties.getProperty("CompareTariff.OverlayPostCode"))){
            		browser.wait(2000);
            		verifyAndInputById(pageProperties.getProperty("CompareTariff.OverlayPostCode"),"Overlay Post code","tw18 3he");
            		verifyAndClick(pageProperties.getProperty("CompareTariff.viewResultsButton"),"View Result Button");
            	}	
            	OverlayFlag = false;
        	}
        	browser.wait(7000);
        	SelectTariffElement = new Select(browser.getElementByXpath(pageProperties.getProperty("CompareTariff.SelectedTariff")));
        	PopulatedTariff = SelectTariffElement.getFirstSelectedOption().getText();
    		
        	if(Tariff.contains(PopulatedTariff.replace("&", "and"))){
        		Report.updateTestLog(PopulatedTariff+"is displayed on selected on the tariff in the Tariff Confirmation Page", "Pass");
        	}
        	else{
        		Report.updateTestLog(PopulatedTariff+"is displayed on selection of "+Tariff+"in the Tariff Information Page", "Fail");
        	}
    	}
    	catch(NoSuchElementException E){
    		
    	}
      	
    }
    
    public void selectMeter(String meterType){
    	if(meterType == "Economy7"){
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
    
    public void verifyTILforTariff(String payment, String Region, String meterType, String tariff, String postCode){
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CompareTariff.gasTCRValue"))){
    		verifyTILforGasTariff(payment,Region,meterType,tariff,postCode);
    	}
    	if (meterType == "Economy7"){
    		//verifyTILforElec2RTariff(payment,Region,meterType,tariff,postCode);
    	}
    	else {
    		verifyTILforElecSRTariff(payment,Region,meterType,tariff,postCode);
    	}
    	
    }
    
    public void verifyTILforGasTariff(String payment, String Region, String meterType, String tariff,String postCode){
    	meterType = "Gas";
    	String DualFuel = "N";
    	String Region1 = new TCRCalculationPage().getPostcode(postCode);
		String combination = tariff+meterType+payment+Region1+DualFuel;
    	String TCRValueOnScr = browser.getTextByXpath(pageProperties.getProperty("CompareTariff.gasTCRValue"));
    	String TCRValue = new TCRCalculationPage().verifyTCRForGasTariff(tariff,combination);
    	if(TCRValueOnScr.contains(TCRValue)){
    		Report.updateTestLog("The TCR value for Gas fuel Tariff Name:" +tariff+ "is displayed:" +TCRValueOnScr+ "and expected Value is:" +TCRValue , "PASS");
    	}else Report.updateTestLog("The TCR value for Gas fuel Tariff Name:" +tariff+ "is displayed:" +TCRValueOnScr+ "and expected Value is:" +TCRValue , "FAIL");
    }


    public void verifyTILforElecSRTariff(String payment, String Region, String meterType, String tariff,String postCode) {
    	meterType = "Elec SR";
    	String DualFuel = "N";
    	String Region1 = new TCRCalculationPage().getPostcode(postCode);
		String combination = tariff+meterType+payment+Region1+DualFuel;
    	String TCRValueOnScr = browser.getTextByXpath(pageProperties.getProperty("CompareTariff.elecSRTCRValue"));
    	String TCRValue = new TCRCalculationPage().verifyTCRForElectricitySRTariff(tariff,combination);
    	if(TCRValueOnScr.contains(TCRValue)){
    		Report.updateTestLog("The TCR value for Elctricity fuel Tariff Name:" +tariff+ "is displayed:" +TCRValueOnScr+ "and expected Value is:" +TCRValue , "PASS");
    	}else Report.updateTestLog("The TCR value for Elctricity fuel Tariff Name:" +tariff+ "is displayed:" +TCRValueOnScr+ "and expected Value is:" +TCRValue , "FAIL");
    	
       }

    public void verifyTILforElec2RTariff(String payment, String Region, String meterType,String tariff){
    	///// getting combination for Electricity SR tariffs /////
    	String Combination = tariff+meterType+payment+Region;
    	///// calculating TCR value /////
    	DecimalFormat df = new DecimalFormat("0.00");
    	String TCRValue = new TCRCalculationPage().verifyTCRForGasTariff(tariff, Combination);
    	float f = Float.parseFloat(TCRValue);
    	f = Float.parseFloat(df.format(f));
    	String TCRValue1 = String.valueOf(f);
    	///// getting TCR value on screen /////
    	String TCRValueOnScr = browser.getTextByXpath(pageProperties.getProperty("CompareTariff.TCRTariffTIL"));
    	if(TCRValueOnScr.contains(TCRValue1)){
    		Report.updateTestLog("The TCR value for electricity 2R fuel Tariff Name:" +tariff+ "is displayed:" +TCRValueOnScr+ "and expected Value is:" +TCRValue1 , "PASS");
    	}else Report.updateTestLog("The TCR value for electricity 2R fuel Tariff Name:" +tariff+ "is displayed:" +TCRValueOnScr+ "and expected Value is:" +TCRValue1 , "FAIL");
    }
    
    
    public void verifyTCRForGas(String tariff, String combination, String TCRValOnScreen){
  		String TCRValue = new TCRCalculationPage().verifyTCRForGasTariff(tariff,combination);
      	if(TCRValOnScreen.contains(TCRValue)){
      		Report.updateTestLog("TCR Value for gas of  tariff: " +tariff+ " is displayed successfully Expected value: " + TCRValue + "Displayed value: " +TCRValOnScreen , "PASS");
      	}
      	else {
      		Report.updateTestLog("TCR Value for gas of tariff: " +tariff+ " is not displayed successfully Expected value: " + TCRValue + "Displayed value: " +TCRValOnScreen , "FAIL");
      	}
      	
      }
      public void verifyTCRForElectricity(String tariff, String combination, String TCRValOnScreen){
      	String TCRValue = new TCRCalculationPage().verifyTCRForElectricitySRTariff(tariff,combination);
      	if(TCRValOnScreen.contains(TCRValue)){
      		Report.updateTestLog("TCR Value for electricity of Tariff " + tariff + "is displayed successfully Expected value: " + TCRValue + "Displayed value: " +TCRValOnScreen , "PASS");
      	}
      	else {
      		Report.updateTestLog("TCR Value for electricity of Tariff"  + tariff + " is not displayed successfully Expected value: " + TCRValue + "Displayed value: " +TCRValOnScreen , "FAIL");
      	}
      	
      }
      
     
}
