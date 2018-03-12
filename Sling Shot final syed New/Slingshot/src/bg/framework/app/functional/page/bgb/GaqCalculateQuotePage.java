package bg.framework.app.functional.page.bgb;

import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;

import java.util.Properties;

//import bg.framework.common.functional.UIOperation;


public class GaqCalculateQuotePage extends BasePage {
    //String varBussiness;
    private final static String FILE_NAME = "resources/bgb/GetAQuote.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    public GaqQuotePage calculateQuote() {
        //GaqQuotePage gaqquote = new GaqQuotePage();
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAQuote.CalculateQuote"))) {
            browser.clickWithXpath(pageProperties.getProperty("GetAQuote.CalculateQuote"));
            browser.wait(getWaitTime());
        }
        return new GaqQuotePage();
    }

    public GaqQuotePage clickContinueQuotePage() {
        //GaqQuotePage gaqquote = new GaqQuotePage();
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAQuote.quotePageContinue"))) {
            browser.clickWithXpath(pageProperties.getProperty("GetAQuote.quotePageContinue"));
            browser.wait(getWaitTime());
        }
        return new GaqQuotePage();

    }

    public GaqQuotePage clickQuaterlyContinueQuotePage() {
        //GaqQuotePage gaqquote = new GaqQuotePage();
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAQuote.quaterlyQuotePageContinue"))) {
            browser.clickWithXpath(pageProperties.getProperty("GetAQuote.quaterlyQuotePageContinue"));
            browser.wait(getWaitTime());
        }


        return new GaqQuotePage();


    }

    /*
      ******************************************************************************
           Method :clickContinueSupplypage

         Created On:01/25/2011
         Description: This method clicks the continue button in the Supply page
      ******************************************************************************
      */
    public GaqQuotePage clickContinueSupplypage() {
//		if(browser.isElementVisible(pageProperties.getProperty("GetAQuote.Businessname"))){
//			browser.wait(getWaitTime());
//			browser.isTextPresent(text)
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAQuote.supplypageContinue"))) {
            browser.clickWithXpath(pageProperties.getProperty("GetAQuote.supplypageContinue"));
            browser.wait(getWaitTime());
        }
        return new GaqQuotePage();
    }
}
