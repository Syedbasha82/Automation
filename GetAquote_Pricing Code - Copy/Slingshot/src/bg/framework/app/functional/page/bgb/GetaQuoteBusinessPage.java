package bg.framework.app.functional.page.bgb;

import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

import java.util.Properties;

public class GetaQuoteBusinessPage extends BasePage {
    private final static String FILE_NAME = "resources/bgb/GetAQuote.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
    
    
    
    /*
	 ******************************************************************************
	  	Method :getaquoteClickElecquoteLink
		Created On:01/23/2011
		Description: This method clicks the Electricity link in the footer of Business Page
	 ******************************************************************************
	 */

    public GetaQuoteDetailsPage getclickCombinedEnergyLink() {
        if (browser.isTextPresent(pageProperties.getProperty("GetAQuote.ElectricityQuote"))) {
            browser.clickWithLinkText(pageProperties.getProperty("GetAQuote.ElectricityQuote"));
            browser.wait(getWaitTime());
            Report.updateTestLog("clicked Electricity quote link at the footer", "PASS");
        } else {
            Report.updateTestLog("Electricity quote linkdoes not exist at the footer", "FAIL");
        }
        return new GetaQuoteDetailsPage();
    }
    
    /*
	 ******************************************************************************
	  	Method :getaquoteClickElecquoteLink
		Created On:01/23/2011
		Description: This method clicks the Electricity link in the footer of Business Page
	 ******************************************************************************
	 */

    public GetaQuoteDetailsPage getaquoteClickElecquoteLink() {
        if (browser.isTextPresent(pageProperties.getProperty("GetAQuote.ElectricityQuote"))) {
            browser.clickWithLinkText(pageProperties.getProperty("GetAQuote.ElectricityQuote"));
            browser.wait(getWaitTime());
            Report.updateTestLog("clicked Electricity quote link at the footer", "PASS");
        } else {
            Report.updateTestLog("Electricity quote linkdoes not exist at the footer", "FAIL");
        }
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String title=browser.getTextByXpath(pageProperties.getProperty("GetAQuote.TitleLabel"));
        if(title.trim().equals("*Title"))
        {	
            Report.updateTestLog("Expected Label name is available: "+title.trim(), "PASS");
        } else {
            Report.updateTestLog("Expected Label name is not available: "+title.trim(), "FAIL");
        }
        String firstname=browser.getTextByXpath(pageProperties.getProperty("GetAQuote.FirstNameLabel"));
        if(firstname.trim().equals("*First name"))
        {	
            Report.updateTestLog("Expected Label name is available: "+firstname.trim(), "PASS");
        } else {
            Report.updateTestLog("Expected Label name is not available: "+firstname.trim(), "FAIL");
        }
        String Surname=browser.getTextByXpath(pageProperties.getProperty("GetAQuote.SurnameLabel"));
        if(Surname.trim().equals("*Surname"))
        {	
            Report.updateTestLog("Expected Label name is available: "+Surname.trim(), "PASS");
        } else {
            Report.updateTestLog("Expected Label name is not available: "+Surname.trim(), "FAIL");
        }
        String Businessname=browser.getTextByXpath(pageProperties.getProperty("GetAQuote.BussinessNameLabel"));
        if(Businessname.trim().equals("*Business name"))
        {	
            Report.updateTestLog("Expected Label name is available: "+Businessname.trim(), "PASS");
        } else {
            Report.updateTestLog("Expected Label name is not available: "+Businessname.trim(), "FAIL");
        }
        String TeleNo=browser.getTextByXpath(pageProperties.getProperty("GetAQuote.TelePhoneNoLabel"));
        if(TeleNo.trim().equals("*Telephone number"))
        {	
            Report.updateTestLog("Expected Label name is available: "+TeleNo.trim(), "PASS");
        } else {
            Report.updateTestLog("Expected Label name is not available: "+TeleNo.trim(), "FAIL");
        }
        String Email=browser.getTextByXpath(pageProperties.getProperty("GetAQuote.EmailAddressLabel"));
        if(Email.trim().contains("*Email address"))
        {	
            Report.updateTestLog("Expected Label name is available: "+Email.trim(), "PASS");
        } else {
            Report.updateTestLog("Expected Label name is not available: "+Email.trim(), "FAIL");
        }
        System.out.println("Email: " +Email);
        String Supplycode=browser.getTextByXpath(pageProperties.getProperty("GetAQuote.SupplyCodeLabel"));
        if(Supplycode.trim().equals("*Supply postcode"))
        {	
            Report.updateTestLog("Expected Label name is available: "+Supplycode.trim(), "PASS");
        } else {
            Report.updateTestLog("Expected Label name is not available: "+Supplycode.trim(), "FAIL");
        }
        System.out.println("Supplycode: " +Supplycode);
        String Consumption=browser.getTextByXpath(pageProperties.getProperty("GetAQuote.ConsumptionkWhLabel"));
        if(Consumption.trim().equals("Consumption kWh (optional)"))
        {	
            Report.updateTestLog("Expected Label name is available: "+Consumption.trim(), "PASS");
        } else {
            Report.updateTestLog("Expected Label name is not available: "+Consumption.trim(), "FAIL");
        }
        System.out.println("Consumption: " +Consumption);
        
        return new GetaQuoteDetailsPage();
    }
    /*
      ******************************************************************************
           Method :getaquoteClickGasquoteLink
         Created On:01/27/2011
         Description: This method clicks the GasQuote link in the footer of Business Page
      ******************************************************************************
      */

    public GetaQuoteDetailsPage getaquoteClickGasquoteLink() {
        if (browser.isTextPresent(pageProperties.getProperty("GetAQuote.GasQuote"))) {
            browser.clickWithLinkText(pageProperties.getProperty("GetAQuote.GasQuote"));
            browser.wait(2000);
            Report.updateTestLog("clicked Gas quote link at the footer", "PASS");
        } else {
            Report.updateTestLog("Gas quote link does not exist at the footer", "FAIL");
        }
        return new GetaQuoteDetailsPage();
    }
    /*
      ******************************************************************************
           Method :getaquoteClickDualquoteLink
         Created On:01/27/2011
         Description: This method clicks the DualQuote link in the footer of Business Page
      ******************************************************************************
      */

    public GetaQuoteDetailsPage getaquoteClickDualquoteLink() {
        if (browser.isTextPresent(pageProperties.getProperty("GetAQuote.DualFuelQuote"))) {
            browser.clickWithLinkText(pageProperties.getProperty("GetAQuote.DualFuelQuote"));
            browser.wait(getWaitTime());
            Report.updateTestLog("clicked Dual quote link at the footer", "PASS");
        } else {
            Report.updateTestLog("Dual quote link does not exist at the footer", "FAIL");
        }
        return new GetaQuoteDetailsPage();
    }
    
    /*
   	 ******************************************************************************
   	  	Method :getaquoteClickCompinedLink
   		Created On:04/06/2012
   		Description: This method clicks the Duel Link in the Business Page
   	 ******************************************************************************
   	 */


	public GetaQuoteDetailsPage getaquoteClickCompinedLink() {
		// TODO Auto-generated method stub
		 if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAQuote.CompinedEnergy"))) {
             browser.clickWithXpath(pageProperties.getProperty("GetAQuote.CompinedEnergy"));
             browser.wait(getWaitTime());
             Report.updateTestLog("Clicked GetAQuote Button in Compined Energey", "PASS");
         } else {
             Report.updateTestLog("GetAQuote Button does not exist at the footer", "FAIL");
         }
         return new GetaQuoteDetailsPage();
	}
       
}
