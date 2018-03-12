package bg.framework.app.functional.page.sales;

import bg.framework.app.functional.action.sales.AcquisitionAction;
import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;


import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class CurrentServicesPage extends BasePage {
	private final static String FILE_NAME = "resources/ReFactoring/BGAcquisition.properties";
//private final static String FILE_NAME = "resources/sales/"+ApplicationConfig.BRAND+"Acquisition.properties";
	
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();


    public CurrentServicesPage(final Acquisition acquisition) {

    }

    public CurrentServicesPage() {

    }

    public void errorCurrentServices() {


        browser.selectfromDropBoxByXpath(pageProperties.getProperty("Acquisition.CurrentServicesGasmetertype"), "Please Select");
        browser.selectfromDropBoxByXpath(pageProperties.getProperty("Acquisition.CurrentServicesElectricitymetertype"), "Please Select");
        currentServicesContinueClick();
        sorryMessageVerification();
        gasMeterTypeMessageVerification();
        ElectricityMeterTypeMessageVerification();
        

    }
    
    public void errorCurrentServicesCQ5(ArrayList<String> errList) {


        browser.selectfromDropBoxByXpath(pageProperties.getProperty("Acquisition.CurrentServicesGasmetertype"), "Please Select");
        browser.selectfromDropBoxByXpath(pageProperties.getProperty("Acquisition.CurrentServicesElectricitymetertype"), "Please Select");
        currentServicesContinueClick();
        sorryMessageVerificationCQ5(errList);
        gasMeterTypeMessageVerificationCQ5(errList);
        ElectricityMeterTypeMessageVerificationCQ5(errList);
        

    }

    


    public AcquisitionAction currentServicesPageNavigation(final Acquisition acquisition) 
    {

        selectGasMeter(acquisition);
        selectElectricityMeter(acquisition);
        currentServicesContinueClick();
        browser.wait(getWaitTime());

        return new AcquisitionAction();
    }

    public AcquisitionAction gasDefaultCurrentServicesPageNavigation(final Acquisition acquisition) 
    {

        selectGasMeterDefault(acquisition);
        selectElectricityMeter(acquisition);
        currentServicesContinueClick();
        browser.wait(getWaitTime());

        return new AcquisitionAction();
    }
    
    public AcquisitionAction gasPrepayment(final Acquisition acquisition) 
    {

    	gasPrepayment();
    	selectElectricityMeter(acquisition);
        currentServicesContinueClick();
        browser.wait(getWaitTime());

        return new AcquisitionAction();
    }

    public void selectGasMeter(final Acquisition acquisition)
    {
    	if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.CurrentServicesGasmetertype"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.CurrentServicesGasmetertype_old"), acquisition.getCurrentGasSupplier());
            Report.updateTestLog("CurrentServices Page Gas Meter field verification,Gas Meter Type field Exists and value entered is " + acquisition.getCurrentGasSupplier(), "PASS");
            //browser.input(pageProperties.getProperty("Acquisition.CurrentServicesGasmetertypesupply"), "123456789123456");
            gassmartmeter(acquisition);
        }
    	else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.CurrentServicesGasmetertype1"))) {
           String defaultGasType = browser.getText(pageProperties.getProperty("Acquisition.CurrentServicesGasmetertype_old"));
           Report.updateTestLog("CurrentServices Page Gas Meter field verification,Gas Meter Type field Exists and value entered is " + defaultGasType, "PASS");
           //browser.input(pageProperties.getProperty("Acquisition.CurrentServicesGasmetertypesupply"), "123456789123456");
           gassmartmeter(acquisition);
        }
    }
    
    public void selectGasMeterDefault(final Acquisition acquisition) 
    {
    	if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.CurrentServicesGasmetertype"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.CurrentServicesGasmetertype_old"), acquisition.getCurrentGasSupplier());
            Report.updateTestLog("CurrentServices Page Gas Meter field verification,Gas Meter Type field Exists and value entered is " + acquisition.getCurrentGasSupplier(), "PASS");
            gassmartmeter(acquisition);
        }
    	else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.CurrentServicesGasmetertype1"))) {
           String defaultGasType = browser.getText(pageProperties.getProperty("Acquisition.CurrentServicesGasmetertype_old"));
           Report.updateTestLog("CurrentServices Page Gas Meter field verification,Gas Meter Type field Exists and value entered is " + defaultGasType, "PASS");
           gassmartmeter(acquisition);
        }  	
    }
    
    public void gasPrepayment() {
        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.CurrentServicesGasmetertype_old"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.CurrentServicesGasmetertype_old"), "Prepayment Gas Meter");
            Report.updateTestLog("CurrentServices Page Gas Meter field verification,Gas Meter Type field Exists and value entered is Prepayment Gas Meter " , "PASS");
        }
    }

    public void selectElectricityMeter(final Acquisition acquisition) {
        browser.wait(getWaitTime());
       
        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.CurrentServicesElectricitymetertype"))) {
            String elecVal;
            List<String> elecSupplier;
            elecSupplier = browser.getFromDropBox("id", pageProperties.getProperty("Acquisition.CurrentServicesElectricitymetertype"));
            elecVal = elecSupplier.get(1);
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.CurrentServicesElectricitymetertype"),elecVal);
            if (elecVal.equals("Single Rate Credit")) {

                if (browser.isElementVisible(pageProperties.getProperty("Acquisition.CurrentServicesElectricitymetertype"))) {
                    browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.CurrentServicesElectricitymetertype"), acquisition.getCurrentElecSupplier());
                    Report.updateTestLog("CurrentServices PageCurrentServices Electricitymetertype field verification,CurrentServicesElectricitymetertype field Exists and value entered is " + acquisition.getCurrentElecSupplier(), "PASS");
                    //browser.input(pageProperties.getProperty("Acquisition.CurrentServicesElecmetertypesupply"), "12345");
                }
            } else if (elecVal.equals("Credit Meter")) {

                if (browser.isElementVisible(pageProperties.getProperty("Acquisition.CurrentServicesElectricitymetertype"))) {
                    browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.CurrentServicesElectricitymetertype"), "Credit Meter");
                    Report.updateTestLog("CurrentServices PageCurrentServices Electricitymetertype field verification,CurrentServicesElectricitymetertype field Exists and value entered is Single rate credit", "PASS");
                    //browser.input(pageProperties.getProperty("Acquisition.CurrentServicesElecmetertypesupply"), "12345");
                }           
                  
            }
            elecsmartmeter(acquisition);   
        }
        
        

    }

    public void twoWayEconomy(){
    	if (browser.isElementVisible(pageProperties.getProperty("Acquisition.CurrentServicesElectricitymetertype"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.CurrentServicesElectricitymetertype"), "Two Rate/Economy 7 Credit");
            Report.updateTestLog("CurrentServices PageCurrentServices Electricitymetertype field verification,CurrentServicesElectricitymetertype field Exists and value entered is  Two Rate/Economy 7 Credit", "PASS");
        }
    	
    }
    
    public void currentServicesContinueClick() {
    	
    	Report.updateTestLog("CurrentServicesPage","WARN");
    	
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.CurrentServicesContinue"))) {
            browser.clickWithXpath(pageProperties.getProperty("Acquisition.CurrentServicesContinue"));
            Report.updateTestLog("Current Services Page continue button is clicked successfully", "PASS");
        } else if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.CurrentServicesContinue1"))) {
            browser.clickWithXpath(pageProperties.getProperty("Acquisition.CurrentServicesContinue1"));
            Report.updateTestLog("Current Services Page continue button is clicked successfully", "PASS");
        } else if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.CurrentServicesContinueForEnergyShop"))) {
            browser.clickWithXpath(pageProperties.getProperty("Acquisition.CurrentServicesContinueForEnergyShop"));
            Report.updateTestLog("Current Services Page continue button is clicked successfully ", "PASS");
        } else if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.CurrentServicesContinueForEnergySmart"))) {
            browser.clickWithXpath(pageProperties.getProperty("Acquisition.CurrentServicesContinueForEnergySmart"));
            Report.updateTestLog("Current Services Page continue button is clicked successfully ", "PASS");
        } else {
            Report.updateTestLog("Current Services Page continue button is not clicked successfully ", "FAIL");
        }

    }
    
    public void sorryMessageVerification() 
    {
        String errorMessage;
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.SorryMessage"))) {
            errorMessage = browser.getTextByXpath(pageProperties.getProperty("Acquisition.SorryMessage"));
            Report.updateTestLog("Expected Error Message " + errorMessage, "PASS");
        } else {
            Report.updateTestLog("Sorry, we need you to look at the following areas of the form again' doesnot display", "FAIL");
        }
    }   
    
    public void sorryMessageVerificationCQ5(ArrayList<String> errList) {
        String errorMessage;
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.SorryMessage"))) {
        	Report.updateTestLog("Error label is present", "PASS");
        	
        } else {
            Report.updateTestLog("Sorry, we need you to look at the following areas of the form again' doesnot display", "FAIL");
        }
        if (browser.getTextByXpath(pageProperties.getProperty("Acquisition.SorryMessage")).trim().contains(errList.get(0).trim())) {
            errorMessage = browser.getTextByXpath(pageProperties.getProperty("Acquisition.SorryMessage"));
            Report.updateTestLog("Actual Error Message " + errorMessage +" is same as expected", "PASS");
        } else {
            Report.updateTestLog(""+errList.get(0)+" is not present instead "+browser.getTextByXpath(pageProperties.getProperty("Acquisition.SorryMessage"))+" is present", "FAIL");
        }
    }
    
    public void gasMeterTypeMessageVerification() 
    {
        String errorMessage;
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.ElecMeterTypeErrorMessage"))) {
            errorMessage = browser.getTextByXpath(pageProperties.getProperty("Acquisition.ElecMeterTypeErrorMessage"));
            Report.updateTestLog("Expected Error Message " + errorMessage, "PASS");
        } else {
            Report.updateTestLog("Sorry, we need you to look at the following areas of the form again' doesnot display", "FAIL");
        }
    }   
    
 public void gasMeterTypeMessageVerificationCQ5(ArrayList<String> errList) {
         
        
        String errorMessage;
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.ElecMeterTypeErrorMessage"))) {
        	Report.updateTestLog("Error label is present", "PASS");
        	
        } else {
            Report.updateTestLog("Error Label not present", "FAIL");
        }
        if (browser.getTextByXpath(pageProperties.getProperty("Acquisition.ElecMeterTypeErrorMessage")).trim().contains(errList.get(4).trim())) {
            errorMessage = browser.getTextByXpath(pageProperties.getProperty("Acquisition.ElecMeterTypeErrorMessage"));
            Report.updateTestLog("Actual Error Message " + errorMessage +" is same as expected", "PASS");
        } else {
            Report.updateTestLog(""+errList.get(4)+" is not present instead "+browser.getTextByXpath(pageProperties.getProperty("Acquisition.ElecMeterTypeErrorMessage"))+" is present", "FAIL");
        } 
    }
    
    public void ElectricityMeterTypeMessageVerification() 
    {
        String errorMessage;
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.GasMeterTypeErrorMessage"))) {
            errorMessage = browser.getTextByXpath(pageProperties.getProperty("Acquisition.GasMeterTypeErrorMessage"));
            Report.updateTestLog("Expected Error Message " + errorMessage, "PASS");
        } else {
            Report.updateTestLog("Sorry, we need you to look at the following areas of the form again' doesnot display", "FAIL");
        }
    }  
    
    public void ElectricityMeterTypeMessageVerificationCQ5(ArrayList<String> errList) 
    {
    	 String errorMessage;
         if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.GasMeterTypeErrorMessage"))) {
         	Report.updateTestLog("Error label is present", "PASS");
         	
         } else {
             Report.updateTestLog("Error Label not present", "FAIL");
         }
         if (browser.getTextByXpath(pageProperties.getProperty("Acquisition.ElecMeterTypeErrorMessage")).trim().contains(errList.get(5).trim())) {
             errorMessage = browser.getTextByXpath(pageProperties.getProperty("Acquisition.GasMeterTypeErrorMessage"));
             Report.updateTestLog("Actual Error Message " + errorMessage +" is same as expected", "PASS");
         } else {
             Report.updateTestLog(""+errList.get(5)+" is not present instead "+browser.getTextByXpath(pageProperties.getProperty("Acquisition.GasMeterTypeErrorMessage"))+" is present", "FAIL");
         } 
    }  
    
    public void gassmartmeter(Acquisition acquisition)
    {
    	
    	 String strsmartmeter=acquisition.getSmartMeterGasYes();
		  		  
        if (strsmartmeter.trim().equalsIgnoreCase("yes")) {
           browser.click(pageProperties.getProperty("Acquisition.SmartMeterGasYes"));
           Report.updateTestLog(" Smart Meter Type Gas - Yes  ","DONE");
      
           smatmeteroverlay();
       		
        } 
        
        if (strsmartmeter.trim().equalsIgnoreCase("no")) {
            browser.click(pageProperties.getProperty("Acquisition.SmartMeterGasNo"));
            Report.updateTestLog(" Smart Meter Type Gas - NO  ","DONE");       
       }
    }  
    
    public void elecsmartmeter(Acquisition acquisition)
    {
    	
   	  String strsmartmeter=acquisition.getSmartMeterElecYes();
		  		  
       if (strsmartmeter.trim().equalsIgnoreCase("yes")) {
          browser.click(pageProperties.getProperty("Acquisition.SmartMeterElecYes"));
          Report.updateTestLog(" Smart Meter Type Elec - Yes  ","DONE");
     
          smatmeteroverlay();           
       } 
       
       if (strsmartmeter.trim().equalsIgnoreCase("no")) {
           browser.click(pageProperties.getProperty("Acquisition.SmartMeterElecNo"));
           Report.updateTestLog(" Smart Meter Type Elec - NO  ","DONE");       
      }
   }  
    
    public void smatmeteroverlay()
    {
    	
    	   if(browser.isElementVisibleWithXpath("html/body/div[4]/div[1]/a")) {			
	        browser.clickWithXpath("html/body/div[4]/div[1]/a");
            }   
       		else  if(browser.isElementVisibleWithXpath("html/body/div[5]/div[1]/a")) {			
	        browser.clickWithXpath("html/body/div[5]/div[1]/a");
            } 
       		else  if(browser.isElementVisibleWithXpath("html/body/div[3]/div[1]/a")) {			
	        browser.clickWithXpath("html/body/div[3]/div[1]/a");
            } 
    	
    }
    
}