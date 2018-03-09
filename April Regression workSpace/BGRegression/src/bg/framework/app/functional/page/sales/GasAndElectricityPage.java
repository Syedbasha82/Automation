package bg.framework.app.functional.page.sales;

import java.util.Properties;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 25/01/12
 * Time: 16:48
 * To change this template use File | Settings | File Templates.
 */
public class GasAndElectricityPage extends BasePage {
    private final static String FILE_NAME = "resources/sales/GasAndElectricityPage.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    public void navigateToOurTariffsPage() {
    	
    	browser.wait(getWaitTime());

    	if (ApplicationConfig.BRAND.equalsIgnoreCase("fusion")) {
        	
      	   if (browser.isTextPresent(pageProperties.getProperty("GasAndElectricityPage.Compareourtariffs"))) {
               browser.clickWithLinkText(pageProperties.getProperty("GasAndElectricityPage.Compareourtariffs"));

               Report.updateTestLog("Navigate to Compare our tariffs tariff page", "PASS");
             } 
      	   
      	   else if (browser.isTextPresent(pageProperties.getProperty("GasAndElectricityPage.EnergyTariffs"))) {
                browser.clickWithLinkText(pageProperties.getProperty("GasAndElectricityPage.EnergyTariffs"));

                Report.updateTestLog("Navigate to Compare our tariffs tariff page", "PASS");
              }
           }
         
    	
    	else if (ApplicationConfig.BRAND.equalsIgnoreCase("bg")) {
    		browser.wait(getWaitTime());	
    	if (browser.isTextPresent(pageProperties.getProperty("GasAndElectricityPage.ourTariffs"))) {
            browser.clickWithLinkText(pageProperties.getProperty("GasAndElectricityPage.ourTariffs"));
            Report.updateTestLog("Our Tariffs Link ", "PASS");
        } 
         }
    	


        browser.wait(getWaitTime());
    }
    
    
    public void navigateToOurTariffsFromCrossellPage() {
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GasAndElectricityPage.CrosssellOurTariffs"))) {
            browser.clickWithXpath(pageProperties.getProperty("GasAndElectricityPage.CrosssellOurTariffs"));

            Report.updateTestLog("Our Tariffs Link is Successful", "PASS");
        } else {
            Report.updateTestLog("Our Tariffs Link is not Successful", "FAIL");
        }
        browser.wait(getWaitTime());
    }
    

    public void navigateToEnergySmartPage() {
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GasAndElectricityPage.EnergySmart"))) {
            browser.clickWithXpath(pageProperties.getProperty("GasAndElectricityPage.EnergySmart"));

            Report.updateTestLog("navigateToEnergySmartPage Link is Successful", "PASS");
        } else {
            Report.updateTestLog("navigateToEnergySmartPage Link is not Successful", "FAIL");
        }
        browser.wait(getWaitTime());
    }
    public void navigateToGetAPricePage(){
        verifyAndClickWithLinkText(pageProperties.getProperty("GasAndElectricityPage.GetAPrice"), "Get a quote");
    	//browser.open("https://10.224.70.17/New_Offer/Account_Summary/Tactical_Offer/GetAQuote");
        browser.wait(getWaitTime());
    }
    public void navigateToEnergyGetAPricePage(){
    	/*if(ApplicationConfig.BRAND.equalsIgnoreCase("BG")){
    		browser.clickWithLinkText(pageProperties.getProperty("GetAPricePage.NewEnergyPage"));
    	}else{
    		browser.clickWithLinkText(pageProperties.getProperty("GetAPricePage.NewEnergySEPage"));
    	}*/
    	 browser.clickWithLinkText(pageProperties.getProperty("GetAPricePage.NewGetAQuotePage"));
        browser.wait(getWaitTime());
    }
}
