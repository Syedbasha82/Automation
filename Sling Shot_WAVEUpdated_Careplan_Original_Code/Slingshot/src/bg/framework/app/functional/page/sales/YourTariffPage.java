package bg.framework.app.functional.page.sales;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * Created by IntelliJ IDEA.
 * User: !boobalas
 * Date: 02/02/12
 * Time: 07:05
 * To change this template use File | Settings | File Templates.
 */
public class YourTariffPage extends BasePage {

	private final static String FILE_NAME = "resources/ReFactoring/"+ApplicationConfig.BRAND+"Acquisition.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    public YourTariffPage() {

    }

    public YourTariffPage(Acquisition acquisition) {

    }

    public void gasBGEnergySmartyElectricityAcquisition(Acquisition acquisition) {

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.YourTariffPageElectricityTariff"))) {
        	List<String> tariff;
        	tariff= browser.getFromDropBox("id", pageProperties.getProperty("Acquisition.YourTariffPageElectricityTariff"));
        	
        	for  ( String tariff1:tariff){ 		
            Report.updateTestLog("Your Tariff Page Electricity selection Verification " + tariff1 + " Tariff is Displayed", "DONE");
        	}
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.YourTariffPageElectricityTariff"), tariff.get((2)));
            Report.updateTestLog("Your Tariff Page Electricity selection Verification " + tariff.get((4)) + "Is Selected", "PASS");

        }
        yourTariffPageContinueClick();

        browser.wait((getWaitTime()));
    }


    public void gasBGEnergySmartDualOrder(Acquisition acquisition) {

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.YourTariffPageswithElec"))) {
            browser.click(pageProperties.getProperty("Acquisition.YourTariffPageswithElec"));
            Report.updateTestLog("Your Tariff Page Checkswithelectricity checkbox is selected", "PASS");
        } else {
            Report.updateTestLog("Your Tariff Page Checkswithelectricity checkbox is not selected", "PASS");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.YourTariffPageDualTariff"))) {
            //browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.YourTariffPageDualTariff"), acquisition.getTarifffordual());
            Report.updateTestLog("Your Tariff Page Electricity selection Verification " + acquisition.getTarifffordual() + "Is Selected", "PASS");

        } else {
            Report.updateTestLog("Your Tariff Page Electricity selection is not done ", "FAIL");
        }

        yourTariffPageContinueClick();
    }

    public void gasBGEnergySmartGasConversion(Acquisition acquisition) {
        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.YourTariffPageGascanCheck"))) {
            browser.click(pageProperties.getProperty("Acquisition.YourTariffPageGascanCheck"));
            Report.updateTestLog("Your Tariff Page Checkswithelectricity checkbox is selected", "PASS");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.YourTariffPageGasTariff"))) {
        	List<String> tariff;
        	tariff= browser.getFromDropBox("id", pageProperties.getProperty("Acquisition.YourTariffPageGasTariff"));
        	for  ( String tariff1:tariff){ 		
                Report.updateTestLog("Your Tariff Page Electricity selection Verification " + tariff1 + " Tariff is Displayed", "DONE");
            	}
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.YourTariffPageGasTariff"), tariff.get((2)));
            Report.updateTestLog("Your Tariff Page Electricity selection Verification " + tariff.get((2)) + "Is Selected", "PASS");


        } 
        else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.YourTariffPageGasTariff1"))) {
        	List<String> tariff;
        	tariff= browser.getFromDropBox("id", pageProperties.getProperty("Acquisition.YourTariffPageGasTariff1"));
        	for  ( String tariff1:tariff){ 		
                Report.updateTestLog("Your Tariff Page Electricity selection Verification " + tariff1 + " Tariff is Displayed", "DONE");
            	}
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.YourTariffPageGasTariff1"), tariff.get((2)));
            Report.updateTestLog("Your Tariff Page Electricity selection Verification " + tariff.get((2)) + "Is Selected", "PASS");

        }
        	
        	
        yourTariffPageContinueClick();

    }

    public void elecBGEnergySmartGasAcquisition(Acquisition acquisition) {
    	
    	

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.YourTariffPageGasTariff"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.YourTariffPageGasTariff"), acquisition.getTariffforgas());
            Report.updateTestLog("Your Tariff Page Electricity selection Verification " + acquisition.getTariffforgas() + "Is Selected", "PASS");

        } else {
            Report.updateTestLog("Your Tariff Page Electricity selection is not done ", "FAIL");
        }

        yourTariffPageContinueClick();

    }

    public void elecBGEnergySmartElecConversion(Acquisition acquisition) {

        browser.wait((getWaitTime()));

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.YourTariffPageswithElec"))) {
            browser.click(pageProperties.getProperty("Acquisition.YourTariffPageswithElec"));
            Report.updateTestLog("Your Tariff Page Checkswithelectricity checkbox is selected", "PASS");
        } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.YourTariffPageswithElec1"))) {
            browser.click(pageProperties.getProperty("Acquisition.YourTariffPageswithElec1"));
            Report.updateTestLog("Your Tariff Page Checkswithelectricity checkbox is selected", "PASS");
        }


        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.YourTariffPageElectricityTariff"))) {
        	ArrayList<String> tariff= browser.getFromDropBox("id", pageProperties.getProperty("Acquisition.YourTariffPageElectricityTariff"));
        	for  ( String tariff1:tariff){ 		
                Report.updateTestLog("Your Tariff Page Electricity selection Verification " + tariff1 + " Tariff is Displayed", "DONE");
            	}
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.YourTariffPageElectricityTariff"), tariff.get((2)));
            Report.updateTestLog("Your Tariff Page Electricity selection Verification " + tariff.get((2)) + "Is Selected", "PASS");

        } else if (browser.isElementVisible(pageProperties.getProperty("Acquisition.YourTariffPageElectricityTariffConversion"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.YourTariffPageElectricityTariffConversion"), acquisition.getTariffforelectricity());
            Report.updateTestLog("Your Tariff Page Electricity selection Verification " + acquisition.getTariffforelectricity() + "Is Selected", "PASS");

        }


        yourTariffPageContinueClick();


    }

    public void inEligibleEnergySmartMessage() {

        browser.wait((getWaitTime()));

        String invalidEnergySmartMessage, invalidSmartMeterMessage;

        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.IneligibleEnergySmartMessage1"))) {
            invalidEnergySmartMessage = browser.getTextByXpath(pageProperties.getProperty("Acquisition.IneligibleEnergySmartMessage1"));
            Report.updateTestLog("Your Tariff Page IneligibleEnergySmartMessage  is Present" + invalidEnergySmartMessage, "PASS");
        } else {
            Report.updateTestLog("Your Tariff Page IneligibleEnergySmartMessage  is not Present", "Fail");
        }

        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.IneligibleEnergySmartMessage2"))) {
            invalidSmartMeterMessage = browser.getTextByXpath(pageProperties.getProperty("Acquisition.IneligibleEnergySmartMessage2"));
            Report.updateTestLog("Your Tariff Page IneligibleEnergySmartMessage  is Present" + invalidSmartMeterMessage, "PASS");
        } else {
            Report.updateTestLog("Your Tariff Page IneligibleEnergySmartMessage  is not Present", "Fail");
        }


    }

    public void elecBGEnergySmartDualOrder(Acquisition acquisition) {

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.YourTariffPageswithGas"))) {
            browser.click(pageProperties.getProperty("Acquisition.YourTariffPageswithGas"));
            Report.updateTestLog("Your Tariff Page Checkswithelectricity checkbox is selected", "PASS");
        } else {
            Report.updateTestLog("Your Tariff Page Checkswithelectricity checkbox is not selected", "PASS");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.YourTariffPageDualTariff"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.YourTariffPageDualTariff"), acquisition.getTarifffordual());
            Report.updateTestLog("Your Tariff Page Electricity selection Verification " + acquisition.getTarifffordual() + "Is Selected", "PASS");

        } else {
            Report.updateTestLog("Your Tariff Page Electricity selection is not done ", "FAIL");
        }

        yourTariffPageContinueClick();
    }

    public void yourTariffPageContinueClick() {

        browser.wait(getWaitTime());
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.YourTariffPageContinue"))) {
            browser.clickWithXpath(pageProperties.getProperty("Acquisition.YourTariffPageContinue"));
            Report.updateTestLog("YourTariff Page Continue Button is Clicked Successfully", "PASS");
        } else {
            Report.updateTestLog("YourTariff Page Continue Button is not Clicked Successfully", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void energySmartGasBGOrderDual(Acquisition acquisition) {

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.YourTariffPageElectricityTariff1"))) {
        	List<String> tariff;
        	tariff= browser.getFromDropBox("id", pageProperties.getProperty("Acquisition.YourTariffPageElectricityTariff1"));
        	
        	for  ( String tariff1:tariff){ 		
            Report.updateTestLog("Your Tariff Page Electricity selection Verification " + tariff1 + " Tariff is Displayed", "DONE");
        	}
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.YourTariffPageElectricityTariff1"),acquisition.getTariff());
            Report.updateTestLog("Your Tariff Page Electricity selection Verification " +acquisition.getTariff() + "Is Selected", "PASS");

        } else {
            Report.updateTestLog("Your Tariff Page Electricity selection is not done ", "FAIL");
        }
        browser.wait(getWaitTime());
        yourTariffPageContinueClick();

    }

    public void energySmartGasBGOrderGas(Acquisition acquisition) {

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.YourTariffgasESChecked"))) {
            browser.click(pageProperties.getProperty("Acquisition.YourTariffgasESChecked"));
            Report.updateTestLog("Your Tariff Page Checkswithelectricity checkbox is selected", "PASS");
        } else {
            Report.updateTestLog("Your Tariff Page Checkswithelectricity checkbox is not selected", "PASS");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.YourTariffPageGasToGas"))) {
        	List<String> tariff;
        	tariff= browser.getFromDropBox("id", pageProperties.getProperty("Acquisition.YourTariffPageGasToGas"));
        	
        	for  ( String tariff1:tariff){ 		
            Report.updateTestLog("Your Tariff Page Electricity selection Verification " + tariff1 + " Tariff is Displayed", "DONE");
        	}
        	
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.YourTariffPageGasToGas"), acquisition.getTariffforgas());
            Report.updateTestLog("Your Tariff Page Electricity selection Verification " + acquisition.getTariffforgas() + "Is Selected", "PASS");

        } else {
            Report.updateTestLog("Your Tariff Page Electricity selection is not done ", "FAIL");
        }
        browser.wait(getWaitTime());
        yourTariffPageContinueClick();
    }

    public void energySmartGasBGOrderElec(Acquisition acquisition) {

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.YourTariffPageElectricityTariff"))) {
        	
        	List<String> tariff;
        	tariff= browser.getFromDropBox("id", pageProperties.getProperty("Acquisition.YourTariffPageElectricityTariff"));
        	
        	for  ( String tariff1:tariff){ 		
            Report.updateTestLog("Your Tariff Page Electricity selection Verification " + tariff1 + " Tariff is Displayed", "DONE");
        	}
        	
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.YourTariffPageElectricityTariff"),tariff.get(3) );
            Report.updateTestLog("Your Tariff Page Electricity selection Verification " + tariff.get(3) + "Is Selected", "PASS");

        } else {
            Report.updateTestLog("Your Tariff Page Electricity selection is not done ", "FAIL");
        }
        browser.wait(getWaitTime());
        yourTariffPageContinueClick();
    }

    public void energySmartElecBGOrderDual(Acquisition acquisition) {

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.YourTariffPageGasTariff"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.YourTariffPageGasTariff"), acquisition.getTariffforgas());
            Report.updateTestLog("Your Tariff Page Gas selection Verification " + acquisition.getTariffforgas() + "Is Selected", "PASS");

        } else {
            Report.updateTestLog("Your Tariff Page Gas selection is not done ", "FAIL");
        }
        browser.wait(getWaitTime());
        yourTariffPageContinueClick();

    }

    public void energySmartElecBGOrderElec(Acquisition acquisition) {

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.YourTariffelecESChecked"))) {
            browser.click(pageProperties.getProperty("Acquisition.YourTariffelecESChecked"));
            Report.updateTestLog("Your Tariff Page Checkswithelectricity checkbox is selected", "PASS");
        } else {
            Report.updateTestLog("Your Tariff Page Checkswithelectricity checkbox is not selected", "PASS");
        }

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.YourTariffPageElecToElec"))) {
           //browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.YourTariffPageElecToElec"), acquisition.getTariffforelectricity());
            verifyAndSelectDropDownBox(pageProperties.getProperty("Acquisition.YourTariffPageElecToElec"), "tariff selection", (acquisition.getTariffforelectricity()).replace("*","&"));
            Report.updateTestLog("Your Tariff Page Electricity selection Verification " + (acquisition.getTariffforelectricity()).replace("*","&")+ "Is Selected", "PASS");

        }
        browser.wait(getWaitTime());
        yourTariffPageContinueClick();
    }

    public void energySmartElecBGOrderGas(Acquisition acquisition) {

        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.YourTariffPageGasTariff"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.YourTariffPageGasTariff"), acquisition.getTariffforgas());
            Report.updateTestLog("Your Tariff Page Gas selection Verification " + acquisition.getTariffforgas() + "Is Selected", "PASS");

        } else {
            Report.updateTestLog("Your Tariff Page Gas selection is not done ", "FAIL");
        }
        browser.wait(getWaitTime());
        yourTariffPageContinueClick();
    }

    public void dualEnergysmartOrderDual(Acquisition acquisition)
    {
    	if (browser.isElementVisible(pageProperties.getProperty("Acquisition.YourTariffPageDualTariff"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("Acquisition.YourTariffPageDualTariff"), (acquisition.getTarifffordual()).replace("*","&"));
            Report.updateTestLog("Your Tariff Page DUAL selection Verification " + (acquisition.getTarifffordual()).replace("*","&") + "Is Selected", "PASS");

        } else {
            Report.updateTestLog("Your Tariff Page DUAL selection is not done ", "FAIL");
        }

        yourTariffPageContinueClick();
    	
    }

}
