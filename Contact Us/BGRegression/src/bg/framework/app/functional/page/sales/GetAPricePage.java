package bg.framework.app.functional.page.sales;


import bg.framework.app.functional.common.ApplicationConfig;


import bg.framework.app.functional.entities.GetAPrice;
import bg.framework.app.functional.entities.GetAPricePageProfile;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SshClient;
import bg.framework.app.functional.util.TestDataHelper;
import bg.framework.app.functional.util.OnlineDBConnector;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/*Function   : GetAPricePage
  Description: Function which contains all the methods related to Get A Price Page
               Scenarios like Anonymous Journey,OAM Journey and Negative Scenarios Covered
*/

public class GetAPricePage extends BasePage {
    private final static String FILE_NAME = "resources/sales/GetAPriceNewBlue.Properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
    private static String RefactorConfirmPrice = "";
    private String selectTariff = "";
    private static String RefactorFixedTariffPrice = "";
    private static String RefactorOnlineEnergyTariffPrice = "";
    private static String RefactorStandardTariffPrice = "";
    private static String RefactorPayAsYouGoTariffPrice = "";
    private static String BGTariff1 = "Fixed Price June 2013";
    private static String BGTariff2 = "Online Energy";
    private static String BGTariff3 = "Standard";
    private static String BGTariff4 = "Standard Pay As You Go";
    private static String FusionTariff1 = "Online Price Freeze June 2013";
    private static String FusionTariff2 = "Online Energy";
    private static String FusionTariff3 = "Standard";
    private static int toggleValue = 3;
    private static int toggleSpend = 5;
    private static int spendv = 50;
    private static int xx = 0;
    private static String sysDate = ""; 
    private static String QuoteLeadId = "";
    private static String inputPostCode="";
    private static String inputQuotefor="";
    private static String inputMeterKind="";
    private static String inputSupplier="";
    private static String inputUsage="";
    private static String inputCurrentPay="";
    private static String inputCurrentTariff="";
    private static boolean flagOverlay = true;
    private static String cheapestTariff="";
    private static String inputSelectTariff = "";
    private static String inputPaymentType = "";

    public GetAPricePage() {
    }

    public void fillGAPDetails(GetAPrice getAPrice, UserProfile userProfile) {
        //enterPostcode(getAPrice);
        selectFuelType(getAPrice);
        verifyandEnterGasElecUsage(getAPrice);
        verifyandEnterPersonalDetails(getAPrice,userProfile);
        verifyGetaQuoteDetails(getAPrice);
    }

    public void fillGAPAnonymousDetails() {
        toggleValue = 3;
        toggleSpend = 5;
        final String fuel = "Gas";
        inputUsage = fuel;
        //enterPostCode();
        enterFuelType(fuel);
        //toggleSpendValue();
        //enterSpend(fuel);
        List<String> listGasMeterKind = getMeterLind(fuel);
        for (int intMeterKind = 0; intMeterKind < getMeterType(fuel); intMeterKind++) {
           // enterCurrentMeterType(listGasMeterKind, intMeterKind + 1, fuel);
            String strCurrentSupplier = "British Gas";
            String selectCurrentPayment = enterEnergyDetails(fuel, strCurrentSupplier);
            enterPersonalDetails();
            verifyAndClick(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"), "Get a Quote Button");
            browser.wait(getWaitTime());
            validateConfirmationPage(listGasMeterKind.get(intMeterKind + 1), strCurrentSupplier, selectTariff, selectCurrentPayment);
            verifyAndClickWithLinkText(pageProperties.getProperty("GetAPricePage.GetANewQuote"), "New Quote");
            enterPostCode();
            enterFuelType(fuel);
            toggleSpendValue();
            enterSpend(fuel);
        }
    }

    public void fillOAMGAPDetails(GetAPrice getAPrice,UserProfile userProfile) {
        toggleValue = 3;
        toggleSpend = 5;
        final String fuel = "Gas";
        enterPostCode();
        enterFuelType(fuel);
        toggleSpendValue();
        enterSpend(fuel);
        List<String> listGasMeterKind = getMeterLind(fuel);
        for (int intMeterKind = 0; intMeterKind < getMeterType(fuel); intMeterKind++) {
            enterCurrentMeterType(listGasMeterKind, intMeterKind + 1, fuel);
            String strCurrentSupplier = "British Gas";
            String selectCurrentPayment = enterEnergyDetails(fuel, strCurrentSupplier);
           // verifyandEnterPersonalDetails(getaPrice,userProfile);
            verifyAndClick(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"), "Get a Quote Button");
            browser.wait(getWaitTime());
            validateConfirmationPage(listGasMeterKind.get(intMeterKind + 1), strCurrentSupplier, selectTariff, selectCurrentPayment);
            verifyAndClickWithLinkText(pageProperties.getProperty("GetAPricePage.GetANewQuote"), "New Quote");
            enterPostCode();
            enterFuelType(fuel);
            toggleSpendValue();
            enterSpend(fuel);
        }
    }

    public void verifyGAPErrorValidations(GetAPrice getAPrice) {
        verifyErrorPostcode();
        verifyErrorFueltype(getAPrice);
        verifyErrorSupplierDetails(getAPrice);
        verifyErrorPersonalDetails(getAPrice);
    }

    public void verifyAllGasSupplierDetails(GetAPrice getAPrice) {
        toggleValue = 3;
        toggleSpend = 5;
        final String fuel = "Gas";
        enterPostCode();
        enterFuelType(fuel);
        toggleSpendValue();
        enterSpend(fuel);
        List<String> listGasMeterKind = getMeterLind(fuel);
        for (int intMeterKind = 0; intMeterKind < getMeterType(fuel); intMeterKind++) {
            List<String> listCurrentGasSupplier = getCurrentSupplier(fuel);
            for (int intCurrentSupplier = 1; intCurrentSupplier < listCurrentGasSupplier.size(); intCurrentSupplier++) {
                enterCurrentMeterType(listGasMeterKind, intMeterKind + 1, fuel);
                String strCurrentSupplier = listCurrentGasSupplier.get(intCurrentSupplier);
                String selectCurrentPayment = enterEnergyDetails(fuel, strCurrentSupplier);
                enterPersonalDetails();
                verifyAndClick(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"), "Get a Quote Button");
                browser.wait(getWaitTime());
                validateConfirmationPage(listGasMeterKind.get(intMeterKind + 1), strCurrentSupplier, selectTariff, selectCurrentPayment);
                verifyAndClickWithLinkText(pageProperties.getProperty("GetAPricePage.GetANewQuote"), "New Quote");
                enterPostCode();
                enterFuelType(fuel);
                toggleSpendValue();
                enterSpend(fuel);
            }
        }
    }

    public void verifyAllElectricitySupplierDetails(GetAPrice getAPrice) {
        toggleValue = 3;
        toggleSpend = 5;
        final String fuel = "Electricity";
        enterPostCode();
        enterFuelType(fuel);
        toggleSpendValue();
        enterSpend(fuel);
        List<String> listGasMeterKind = getMeterLind(fuel);
        for (int intMeterKind = 0; intMeterKind < getMeterType(fuel); intMeterKind++) {
            //enterCurrentMeterType(listGasMeterKind, intMeterKind+1, fuel);
            List<String> listCurrentGasSupplier = getCurrentSupplier(fuel);
            for (int intCurrentSupplier = 1; intCurrentSupplier < listCurrentGasSupplier.size(); intCurrentSupplier++) {
                enterCurrentMeterType(listGasMeterKind, intMeterKind + 1, fuel);
                String strCurrentSupplier = listCurrentGasSupplier.get(intCurrentSupplier);
                String selectCurrentPayment = enterEnergyDetails(fuel, strCurrentSupplier);
                enterPersonalDetails();
                verifyAndClick(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"), "Get a Quote Button");
                browser.wait(getWaitTime());
                validateConfirmationPage(listGasMeterKind.get(intMeterKind + 1), strCurrentSupplier, selectTariff, selectCurrentPayment);
                verifyAndClickWithLinkText(pageProperties.getProperty("GetAPricePage.GetANewQuote"), "New Quote");
                enterPostCode();
                enterFuelType(fuel);
                toggleSpendValue();
                enterSpend(fuel);
            }
        }
    }

    public void verifyAllDualSupplierDetails(GetAPrice getAPrice) {
        toggleValue = 3;
        toggleSpend = 5;
        final String fuel = "Dual";
        final String fuel1 = "Gas";
        final String fuel2 = "Electricity";
        final String[] listCurrentElecSupplier = {"British Gas", "Sainsbury's Energy", "Atlantic Electric and Gas", "British Gas", "Atlantic Electric and Gas", "Sainsbury's Energy", "Atlantic Electric and Gas", "Ecotricity"};
        final String[] listCurrentGasSupplier = {"British Gas", "Sainsbury's Energy", "Atlantic Electric and Gas", "Atlantic Electric and Gas", "British Gas", "Atlantic Electric and Gas", "Sainsbury's Energy", "EBICo"};

        enterPostCode();
        enterFuelType(fuel);
        for (int intMeterKind = 0; intMeterKind < 8; intMeterKind++) {
            toggleSpendValue();
            if (ApplicationConfig.BRAND.equalsIgnoreCase("BG")) {
                verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + fuel1 + "Meter"), "Meter Drop Down", "Credit Meter");
            }
            enterSpend(fuel1);
            String selectCurrentGasPayment = enterEnergyDetails(fuel1, listCurrentGasSupplier[intMeterKind]);
            enterSpend(fuel2);
            verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + fuel2 + "Meter"), "Meter Drop Down", "Credit Meter");
            String selectCurrentElecPayment = enterEnergyDetails(fuel2, listCurrentElecSupplier[intMeterKind]);
            enterPersonalDetails();
            verifyAndClick(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"), "Get a Quote Button");
            browser.wait(getWaitTime());
            validateConfirmationPage("Credit Meter", listCurrentElecSupplier[intMeterKind], selectTariff, selectCurrentGasPayment);
            verifyAndClickWithLinkText(pageProperties.getProperty("GetAPricePage.GetANewQuote"), "New Quote");
            enterPostCode();
            enterFuelType(fuel);
        }
    }

    private void enterPostcode(GetAPrice getaPrice) {

        if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.PostCode"))) {
        	verifyAndInputById(pageProperties.getProperty("GetAPricePage.PostCode"), "Post Code",  getaPrice.getpostcode());
            //browser.input(pageProperties.getProperty("GetAPricePage.PostCode"), getaPrice.getpostcode());
            Report.updateTestLog("PostCode Entered " + getaPrice.getpostcode(), "PASS");
        } else {
            Report.updateTestLog("PostCode Not Entered", "FAIL");
        }
        browser.click(pageProperties.getProperty("GetAPricePage.PostCodeNext"));
        Report.updateTestLog("GAP Page Screen Shot", "WARN");
    }

    private void selectFuelType(GetAPrice getaPrice) {
    	String fuelType = getaPrice.getfuelType();
        if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage." + getaPrice.getfuelType()))) {
            browser.click(pageProperties.getProperty("GetAPricePage." + getaPrice.getfuelType()));
              
            if (fuelType.equalsIgnoreCase("Dual")) {
            	
            	if(getaPrice.getDualType().equalsIgnoreCase("yes")){
            	  
            	if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.Dualyes"))) {
                    browser.click(pageProperties.getProperty("GetAPricePage.Dualyes"));
            	} 
            	}else {
            		browser.click(pageProperties.getProperty("GetAPricePage.Dualno"));
            	}
            }
            browser.click(pageProperties.getProperty("GetAPricePage.FuelTypeNext"));
            Report.updateTestLog("Fuel Type Entered " + getaPrice.getfuelType(), "PASS");
        } else {
            Report.updateTestLog("Fuel Type Not Entered", "FAIL");
        }
    }

    /* Function   : verifyandEnterGasElecUsage
       Description: Function to select and enter the fuel usages type for Get A Price Page
    */
    private void verifyandEnterGasElecUsage(GetAPrice getaPrice) {

        String fuelType = getaPrice.getfuelType();
        
        if (fuelType.equalsIgnoreCase("Gas")) {
            String gasSpendValue = getaPrice.getgasSpend();
            if (!gasSpendValue.equals("")) {
                browser.click(pageProperties.getProperty("GetAPricePage.GasSpend"));
                browser.clearValue(pageProperties.getProperty("GetAPricePage.GasSpendValue"));
                browser.input(pageProperties.getProperty("GetAPricePage.GasSpendValue"), gasSpendValue);
                browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasSpendType"), getaPrice.getgasSpendType());
                Report.updateTestLog("Gas Spend Value Entered  :" + gasSpendValue, "PASS");
            }
            

            String gasAnnConsump = getaPrice.getgasAnnConsump();
            if (!gasAnnConsump.equals("")) {
                browser.click(pageProperties.getProperty("GetAPricePage.GasAnnConsump"));
                browser.input(pageProperties.getProperty("GetAPricePage.GasAnnConsumpValue"), gasAnnConsump);
                Report.updateTestLog("Gas Annual Consumption Entered  :" + gasAnnConsump, "PASS");
                Report.updateTestLog("Gas Annual Consumption Not Entered", "FAIL");
            }

            
           
            Report.updateTestLog("Fuel Type Prepopulate Screen shot  :", "WARN");
            
            if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.GasBrand"))) {
              //  browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasMeter"), getaPrice.getgasMeter());
            	List<String> supplier = browser.getFromDropBox("xpath", pageProperties.getProperty("GetAPricePage.GasBrand"));
            	
            	System.out.println(supplier.get(0));
            	if(supplier.get(0).equals("Please select")){
            		browser.selectfromDropBoxByXpath(pageProperties.getProperty("GetAPricePage.GasBrand"), getaPrice.getgasSupplier());  
            		Report.updateTestLog("Current Supplier Selected is  : " + getaPrice.getgasSupplier(), "DONE");
            	}
            	else{
            		Report.updateTestLog("Current Supplier by default  : " + supplier.get(0), "DONE");
            	}
            
                browser.wait(3000);
                             
                
            	List<String> payment = browser.getFromDropBox("id", pageProperties.getProperty("GetAPricePage.GasPayment"));
            	System.out.println(payment.get(0));
            	if(payment.get(0).equals("Please select")){
            		browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasPayment"), getaPrice.getgasPayment());  
            		Report.updateTestLog("Current Supplier Selected is  : " + getaPrice.getgasPayment(), "DONE");
            	}
            	else{
            		Report.updateTestLog("Current Supplier by default  : " + payment.get(0), "DONE");
            	} 
                
                
            	 List<String> tariff = browser.getFromDropBox("id", pageProperties.getProperty("GetAPricePage.GasTariff"));
             	System.out.println(tariff.get(0));
             	if(tariff.get(0).equals("Please select")){
             		browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasTariff"), getaPrice.getgasTariff());  
             		Report.updateTestLog("Current Supplier Selected is  : " + getaPrice.getgasTariff(), "DONE");
             	}
             	else{
             		Report.updateTestLog("Current Supplier by default  : " + tariff.get(0), "DONE");
             	}
            	
               // browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasPreferredPaymentType"), getaPrice.getGasPreferredPayment());
                browser.click(pageProperties.getProperty("GetAPricePage.GasNext"));
                
               // Report.updateTestLog("Fuel Supplier :" + getaPrice.getgasSupplier() + "," + "Tariff  :" + getaPrice.getgasTariff() +
                       // "," + "Payment Type  :" + getaPrice.getgasPayment(), "PASS");
            } else {
                Report.updateTestLog(" Gas Supplier,Tariff and Payment Type Property Not selected", "FAIL");
            }
        }

        if (fuelType.equalsIgnoreCase("Electricity")) {
            String elecSpendValue = getaPrice.getelecSpend();
            System.out.println("elce spend: " + elecSpendValue);
            
            //else{
            //    Report.updateTestLog("Electricity Annual Consumption Not Entered", "FAIL");
            //}

            
            browser.wait(getWaitTime());
            Report.updateTestLog("Fuel Type Prepopulate Screen shot  :", "WARN");
            //if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.ElectricityMeter"))) {
              //  browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.ElectricityMeter"), getaPrice.getelecMeter());
                browser.selectfromDropBoxByXpath(pageProperties.getProperty("GetAPricePage.ElectricityBrand"), getaPrice.getelecSupplier());
                browser.wait(3000);
               
                browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.Economy"), getaPrice.getEconomy());
                browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.ElectricityPayment"), getaPrice.getelecPayment());
                browser.wait(1000);
                browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.ElectricityTariff"), getaPrice.getelecTariff());
               // browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.ElectricityPreferredPaymentType"), getaPrice.getElecPreferredPayment());
                
                Report.updateTestLog("Fuel Supplier :" + getaPrice.getelecSupplier() + "," + "Tariff  :" + getaPrice.getelecTariff() +
                        "," + "Payment Type  :" + getaPrice.getelecPayment(), "PASS");
           // }
                
                
                if (!elecSpendValue.equals("")) {
                    browser.click(pageProperties.getProperty("GetAPricePage.ElectricitySpend"));
                    browser.clearValue(pageProperties.getProperty("GetAPricePage.ElectricitySpendValue"));
                    browser.input(pageProperties.getProperty("GetAPricePage.ElectricitySpendValue"), elecSpendValue);
                    browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.ElectricitySpendType"), getaPrice.getelecSpendType());
                    Report.updateTestLog("Electricity Spend Value Entered  :" + elecSpendValue, "PASS");
                }
                

                String elecAnnConsump = getaPrice.getelecAnnConsump();
                if (!elecAnnConsump.equals("")) {
                    browser.click(pageProperties.getProperty("GetAPricePage.ElectricityAnnConsump"));
                    browser.input(pageProperties.getProperty("GetAPricePage.ElectricityAnnConsumpValue"), elecAnnConsump);
                    Report.updateTestLog("Electricity Annual Consumption Entered  :" + elecAnnConsump, "PASS");
                }
           
                browser.click(pageProperties.getProperty("GetAPricePage.GasNext"));
                
        }
        if (fuelType.equalsIgnoreCase("Dual")) {
        	Report.updateTestLog("Fuel Type Prepopulate Screen shot  :", "WARN");
            if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.GasBrand"))) {
               // browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasMeter"), getaPrice.getgasMeter());
                browser.selectfromDropBoxByXpath(pageProperties.getProperty("GetAPricePage.GasBrand"), getaPrice.getgasSupplier());
                browser.wait(3000);
                browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasTariff"), getaPrice.getgasTariff());
                
                browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasPayment"), getaPrice.getgasPayment());
               // browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasPreferredPaymentType"), getaPrice.getGasPreferredPayment());
                //browser.click(pageProperties.getProperty("GetAPricePage.GasNext"));
                Report.updateTestLog("Fuel Supplier :" + getaPrice.getgasSupplier() + "," + "Tariff  :" + getaPrice.getgasTariff() +
                        "," + "Payment Type  :" + getaPrice.getgasPayment(), "PASS");
            }
           
            
            Report.updateTestLog("Fuel Type Prepopulate Screen shot  :", "WARN");
               // browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.ElectricityMeter"), getaPrice.getelecMeter());
                browser.selectfromDropBoxByXpath(pageProperties.getProperty("GetAPricePage.ElectricityBrand"), getaPrice.getelecSupplier());
                browser.wait(3000);
               // browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.ElectricityTariff"), getaPrice.getelecTariff());
                browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.Economy"), getaPrice.getEconomy());
                browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.ElectricityPayment"), getaPrice.getelecPayment());
                browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.ElectricityTariff"), getaPrice.getelecTariff());
                //browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.ElectricityPreferredPaymentType"), getaPrice.getElecPreferredPayment());
                //browser.click(pageProperties.getProperty("GetAPricePage.ElectricityNext"));
                Report.updateTestLog("Fuel Supplier :" + getaPrice.getelecSupplier() + "," + "Tariff  :" + getaPrice.getelecTariff() +
                        "," + "Payment Type  :" + getaPrice.getelecPayment(), "PASS");
            
            
            
            String gasSpendValue = getaPrice.getgasSpend();
            if (!gasSpendValue.equals("")) {
                browser.click(pageProperties.getProperty("GetAPricePage.GasSpend"));
                browser.clearValue(pageProperties.getProperty("GetAPricePage.GasSpendValue"));
                browser.input(pageProperties.getProperty("GetAPricePage.GasSpendValue"), gasSpendValue);
                browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasSpendType"), getaPrice.getgasSpendType());
                Report.updateTestLog("Gas Spend Value Entered  :" + gasSpendValue, "PASS");
            }
            

            String gasAnnConsump = getaPrice.getgasAnnConsump();
            if (!gasAnnConsump.equals("")) {
                browser.click(pageProperties.getProperty("GetAPricePage.GasAnnConsump"));
                browser.input(pageProperties.getProperty("GetAPricePage.GasAnnConsumpValue"), gasAnnConsump);
                Report.updateTestLog("Gas Annual Consumption Entered  :" + gasAnnConsump, "PASS");
            }
           

            
            String elecSpendValue = getaPrice.getelecSpend();
            if (!elecSpendValue.equals("")) {
                browser.click(pageProperties.getProperty("GetAPricePage.ElectricitySpend"));
                browser.clearValue(pageProperties.getProperty("GetAPricePage.ElectricitySpendValue"));
                browser.input(pageProperties.getProperty("GetAPricePage.ElectricitySpendValue"), elecSpendValue);
                browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.ElectricitySpendType"), getaPrice.getelecSpendType());
                Report.updateTestLog("Electricity Spend Value Entered  :" + elecSpendValue, "PASS");
            }
            
            String elecAnnConsump = getaPrice.getelecAnnConsump();
            if (!elecAnnConsump.equals("")) {
                browser.click(pageProperties.getProperty("GetAPricePage.ElectricityAnnConsump"));
                browser.input(pageProperties.getProperty("GetAPricePage.ElectricityAnnConsumpValue"), elecAnnConsump);
                Report.updateTestLog("Electricity Annual Consumption Entered  :" + elecAnnConsump, "PASS");
            }
            

            
            browser.click(pageProperties.getProperty("GetAPricePage.GasNext"));          
            
        }
    }

    /* Function   : verifyandEnterPersonalDetails
       Description: Function to  enter the Personal details for Get A Price Page
    */
    private void verifyandEnterPersonalDetails(GetAPrice getaPrice,UserProfile userProfile) {
    	Report.updateTestLog("Personal Details Section screen Shot", "WARN");
    	
    	if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.PostCode"))) {
    		browser.clearValue(pageProperties.getProperty("GetAPricePage.PostCode"));
            browser.input(pageProperties.getProperty("GetAPricePage.PostCode"), getaPrice.getpostcode());
            Report.updateTestLog("PostCode Entered " + getaPrice.getpostcode(), "PASS");
        } else {
            Report.updateTestLog("PostCode Not Entered", "FAIL");
        }
         	
        if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.Title"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.Title"), userProfile.getTitle());
          
            
            verifyAndInputById(pageProperties.getProperty("GetAPricePage.FirstName"), "first name",userProfile.getFirstName().concat("aa"));
            verifyAndInputById(pageProperties.getProperty("GetAPricePage.LastName"),"Last Name", userProfile.getLastName());
            verifyAndInputById(pageProperties.getProperty("GetAPricePage.Email"),"Enter Email", userProfile.getEmail());
            verifyAndInputById(pageProperties.getProperty("GetAPricePage.Phone"), "Enter Phone",userProfile.getPhoneNumber());
            
            
            browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.PhoneType"), userProfile.getPhoneType());
            Report.updateTestLog("Your Details : Title  :" + userProfile.getTitle() + "," + "FirstName  :" +
                    "," + "LastName :" + userProfile.getLastName() + "," + "Email ID :" + userProfile.getEmail() +
                    "," + "Phone Number :" + userProfile.getMobileNumber() + "," + "Phone Number Type :" + userProfile.getPhoneType(), "PASS");
        } else {
            Report.updateTestLog(" Your Details prepopulated", "PASS");
            
        }
        Report.updateTestLog("Personal Details Section after entering details screen Shot", "WARN");
        
        if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.YourDetailsNext"))) {
            browser.click(pageProperties.getProperty("GetAPricePage.YourDetailsNext"));
            Report.updateTestLog(" Personal details entered", "PASS");
        } else {
            //Report.updateTestLog("Problem with personal details", "FAIL");
        }
        
        browser.click(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"));
    }
    
    private void newVerifyandEnterPersonalDetails(UserProfile userProfile) {
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.TitleCheck"))){
    		browser.wait(10000);
			Report.updateTestLog("Your Personal Details not PrePopulated", "Pass");
			browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.Title"), userProfile.getTitle());
			verifyAndInputById(pageProperties.getProperty("GetAPricePage.FirstName"), "Firstname", userProfile.getFirstName());
    //        browser.input(pageProperties.getProperty("GetAPricePage.FirstName"), userProfile.getFirstName());
			verifyAndInputById(pageProperties.getProperty("GetAPricePage.LastName"), "Last Name", userProfile.getLastName());
           // browser.input(pageProperties.getProperty("GetAPricePage.LastName"), userProfile.getLastName());
			verifyAndInputById(pageProperties.getProperty("GetAPricePage.Email"), "Email",userProfile.getEmail());
          //  browser.input(pageProperties.getProperty("GetAPricePage.Email"), userProfile.getEmail());
			verifyAndInputById(pageProperties.getProperty("GetAPricePage.Phone"), "Phone Type", userProfile.getPhoneNumber());
         //   browser.input(pageProperties.getProperty("GetAPricePage.Phone"), userProfile.getPhoneNumber());
          //  browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.PhoneType"), userProfile.getPhoneType());
			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.PhoneType"), "Phone Type", "Home");
            Report.updateTestLog("Your Details : Title  :" + userProfile.getTitle() + "," + "FirstName  :" +
                    "," + "LastName :" + userProfile.getLastName() + "," + "Email ID :" + userProfile.getEmail() +
                    "," + "Phone Number :" + userProfile.getMobileNumber() + "," + "Phone Number Type :" + userProfile.getPhoneType(), "PASS");
       
	 
    if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.YourDetailsNext"))) {
        browser.click(pageProperties.getProperty("GetAPricePage.YourDetailsNext"));
        Report.updateTestLog(" Personal details entered", "PASS");
    } else {
        //Report.updateTestLog("Problem with personal details", "FAIL");
    }

 //   browser.click(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"));
    	}
    	browser.wait(10000);
    	if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.Title"))){
    			Report.updateTestLog("Your Personal Details not PrePopulated", "Pass");
    			browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.Title"), userProfile.getTitle());
    			verifyAndInputById(pageProperties.getProperty("GetAPricePage.FirstName"), "Firstname", userProfile.getFirstName());
        //        browser.input(pageProperties.getProperty("GetAPricePage.FirstName"), userProfile.getFirstName());
    			verifyAndInputById(pageProperties.getProperty("GetAPricePage.LastName"), "Last Name", userProfile.getLastName());
               // browser.input(pageProperties.getProperty("GetAPricePage.LastName"), userProfile.getLastName());
    			verifyAndInputById(pageProperties.getProperty("GetAPricePage.Email"), "Email",userProfile.getEmail());
              //  browser.input(pageProperties.getProperty("GetAPricePage.Email"), userProfile.getEmail());
    			verifyAndInputById(pageProperties.getProperty("GetAPricePage.Phone"), "Phone Type", userProfile.getPhoneNumber());
             //   browser.input(pageProperties.getProperty("GetAPricePage.Phone"), userProfile.getPhoneNumber());
              //  browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.PhoneType"), userProfile.getPhoneType());
    			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.PhoneType"), "Phone Type", "Home");
                Report.updateTestLog("Your Details : Title  :" + userProfile.getTitle() + "," + "FirstName  :" +
                        "," + "LastName :" + userProfile.getLastName() + "," + "Email ID :" + userProfile.getEmail() +
                        "," + "Phone Number :" + userProfile.getMobileNumber() + "," + "Phone Number Type :" + userProfile.getPhoneType(), "PASS");
           
    	}
        if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.YourDetailsNext"))) {
            browser.click(pageProperties.getProperty("GetAPricePage.YourDetailsNext"));
            Report.updateTestLog(" Personal details entered", "PASS");
        } else {
            //Report.updateTestLog("Problem with personal details", "FAIL");
        }

     //   browser.click(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"));
    }


    /* Function   : verifyGetaQuoteDetails
       Description: Function to  verify the Quote details for Get A Price Confirmation Page
    */
    private void verifyGetaQuoteDetails(GetAPrice getaPrice) {
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.QuoteDetails"))) {
            String strVerify = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.QuoteDetails"));
            Report.updateTestLog(strVerify + " Quote Details are Verified", "PASS");
        } else {
            Report.updateTestLog("Quote Details are not Verified", "FAIL");
        }
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.QuoteDetails[1]"))) {
            String strTariff = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.QuoteDetails[1]"));
            String strTariff1 = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.QuoteDetails[2]"));
            Report.updateTestLog(strTariff + " Tariff Details Verified" + strTariff1 + " Quote Details Verified", "PASS");
        } //else {
         //   Report.updateTestLog("Tariff Details not Verified", "FAIL");

       // }
        if (browser.isTextPresent(getaPrice.getpostcode())) {
            browser.isTextPresent(getaPrice.getpostcode());
            browser.isTextPresent(getaPrice.getfuelType());
            Report.updateTestLog(" PostCode :" + getaPrice.getpostcode() + "," + "Fuel Type :" + getaPrice.getfuelType() + "are Verified", "PASS");
        } 
        
        Report.updateTestLog("Quote Section Screen Shot", "WARN");
        
        /*if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.OnlinePrices"))) {
            String strValue = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.OnlinePrices"));
            Report.updateTestLog(strValue + "Tariff Details Verified", "PASS");
        }
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.OtherPrices"))) {
            String strValue = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.OtherPrices"));
            Report.updateTestLog(strValue + "Tariff Details Verified", "PASS");
        }
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.StandardPrices"))) {
            String strValue = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.StandardPrices"));
            Report.updateTestLog(strValue + "Tariff Details Verified", "PASS");
        }*/
    }

    /* Function   : clickGAQButton
       Description: Function to  click the Get A Quote button for Get A Price Page
    */
    private void clickGAQButton() {
        if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"))) {
            browser.click(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"));
        }
    }

    public void verifyErrorPostcode() {
        String[] getPostcode;
        getPostcode = new String[4];

        getPostcode[0] = "abcdef";
        getPostcode[1] = "123456789";
        getPostcode[2] = "!@#$%^";
        getPostcode[3] = "sw9 9lw";

        for (int i = 0; i < 4; i++) {
            if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.PostCode"))) {
                browser.clearValue(pageProperties.getProperty("GetAPricePage.PostCode"));
                browser.input(pageProperties.getProperty("GetAPricePage.PostCode"), getPostcode[i]);
                Report.updateTestLog("Invalid PostCode Entered :" + getPostcode[i], "PASS");
            } else {
                Report.updateTestLog("PostCode Not Entered", "FAIL");
            }
            browser.click(pageProperties.getProperty("GetAPricePage.PostCodeNext"));
            String error;
            if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.PreProdPostCode"))) {
                error = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.PostcodeErrorField"));
                Report.updateTestLog("Invalid PostCode Format Field Validation  :" + error, "PASS");
            } else {
                Report.updateTestLog("Invalid PostCode Format Field Validation", "FAIL");
            }
        }
    }

    public void verifyErrorFueltype(GetAPrice getaPrice) {
       // browser.input(pageProperties.getProperty("GetAPricePage.PostCode"), "sw9 9lw");
       // browser.click(pageProperties.getProperty("GetAPricePage.PostCodeNext"));
    /*    if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage." + getaPrice.getfuelType()))) {
            browser.click(pageProperties.getProperty("GetAPricePage.FuelTypeNext"));
            String error;
            if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.FuelErrorField"))) {
                error = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.FuelErrorField"));
                Report.updateTestLog("Fuel type Field Validation  :" + error, "PASS");
            } else {
                Report.updateTestLog("Fuel type not Verified", "FAIL");
            }
        }*/
     //   browser.click(pageProperties.getProperty("GetAPricePage." + getaPrice.getfuelType()));
    	browser.click(pageProperties.getProperty("GetAPricePage.Gas"));
        browser.click(pageProperties.getProperty("GetAPricePage.FuelTypeNext"));
    }

    public void verifyErrorSupplierDetails(GetAPrice getaPrice) {
       // browser.input(pageProperties.getProperty("GetAPricePage.PostCode"), "sw9 9lw");
        //browser.click(pageProperties.getProperty("GetAPricePage.PostCodeNext"));
      //  if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage." + getaPrice.getfuelType()))) {
       //     browser.click(pageProperties.getProperty("GetAPricePage." + getaPrice.getfuelType()));
       //     browser.click(pageProperties.getProperty("GetAPricePage.FuelTypeNext"));
      //  }
        browser.click(pageProperties.getProperty("GetAPricePage.GasSpend"));
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasBrand"), getaPrice.getgasSupplier());
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasTariff"), getaPrice.getgasTariff());
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasPayment"), getaPrice.getgasPayment());
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.PreferredPaymentType"), getaPrice.getGasPreferredPayment());
        browser.click(pageProperties.getProperty("GetAPricePage.GasNext"));
        String error;
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.SupplierErrorField"))) {
            error = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.SupplierErrorField"));
            Report.updateTestLog("Gas Spend Details Field Validation  :" + error, "PASS");
        } else {
            Report.updateTestLog("Gas Spend Details not Verified", "FAIL");
        }
        browser.clearValue(pageProperties.getProperty("GetAPricePage.PostCode"));
        browser.input(pageProperties.getProperty("GetAPricePage.PostCode"), "sw9 9lw");
        browser.click(pageProperties.getProperty("GetAPricePage.PostCodeNext"));
        if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage." + getaPrice.getfuelType()))) {
            browser.click(pageProperties.getProperty("GetAPricePage." + getaPrice.getfuelType()));
            browser.click(pageProperties.getProperty("GetAPricePage.FuelTypeNext"));
        }
        browser.click(pageProperties.getProperty("GetAPricePage.GasAnnConsump"));
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasBrand"), getaPrice.getgasSupplier());
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasTariff"), getaPrice.getgasTariff());
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasPayment"), getaPrice.getgasPayment());
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.PreferredPaymentType"), getaPrice.getGasPreferredPayment());
        browser.click(pageProperties.getProperty("GetAPricePage.GasNext"));
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.SupplierErrorField"))) {
            error = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.SupplierErrorField"));
            Report.updateTestLog("Annual Consumption Field Validation  :" + error, "PASS");
        } else {
            Report.updateTestLog("Annual Consumption Details not Verified", "FAIL");
        }
        browser.clearValue(pageProperties.getProperty("GetAPricePage.PostCode"));
        browser.input(pageProperties.getProperty("GetAPricePage.PostCode"), "sw9 9lw");
        browser.click(pageProperties.getProperty("GetAPricePage.PostCodeNext"));
        if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage." + getaPrice.getfuelType()))) {
            browser.click(pageProperties.getProperty("GetAPricePage." + getaPrice.getfuelType()));
            browser.click(pageProperties.getProperty("GetAPricePage.FuelTypeNext"));
        }
        browser.click(pageProperties.getProperty("GetAPricePage.GasBedrooms"));
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasBrand"), getaPrice.getgasSupplier());
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasTariff"), getaPrice.getgasTariff());
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasPayment"), getaPrice.getgasPayment());
        browser.click(pageProperties.getProperty("GetAPricePage.GasNext"));
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.SupplierErrorField"))) {
            error = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.SupplierErrorField"));
            Report.updateTestLog("Bed room Details Field Validation  :" + error, "PASS");
        } else {
            Report.updateTestLog("Bed room Details not Verified", "FAIL");
        }
        browser.clearValue(pageProperties.getProperty("GetAPricePage.PostCode"));
        browser.input(pageProperties.getProperty("GetAPricePage.PostCode"), "sw9 9lw");
        browser.click(pageProperties.getProperty("GetAPricePage.PostCodeNext"));
        if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage." + getaPrice.getfuelType()))) {
            browser.click(pageProperties.getProperty("GetAPricePage." + getaPrice.getfuelType()));
            browser.click(pageProperties.getProperty("GetAPricePage.FuelTypeNext"));
        }
        browser.click(pageProperties.getProperty("GetAPricePage.GasBedrooms"));
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasBedroomsValue"), getaPrice.getgasBedrooms());
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasTariff"), getaPrice.getgasTariff());
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasPayment"), getaPrice.getgasPayment());
        browser.click(pageProperties.getProperty("GetAPricePage.GasNext"));
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.SupplierErrorField"))) {
            error = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.SupplierErrorField"));
            Report.updateTestLog("Supplier Details Brand Field Validation  :" + error, "PASS");
        } else {
            Report.updateTestLog("Supplier Details Brand not Verified", "FAIL");
        }
        browser.clearValue(pageProperties.getProperty("GetAPricePage.PostCode"));
        browser.input(pageProperties.getProperty("GetAPricePage.PostCode"), "sw9 9lw");
        browser.click(pageProperties.getProperty("GetAPricePage.PostCodeNext"));
        if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage." + getaPrice.getfuelType()))) {
            browser.click(pageProperties.getProperty("GetAPricePage." + getaPrice.getfuelType()));
            browser.click(pageProperties.getProperty("GetAPricePage.FuelTypeNext"));
        }
        browser.click(pageProperties.getProperty("GetAPricePage.GasBedrooms"));
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasBedroomsValue"), getaPrice.getgasBedrooms());
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasBrand"), getaPrice.getgasSupplier());
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasPayment"), getaPrice.getgasPayment());
        browser.click(pageProperties.getProperty("GetAPricePage.GasNext"));
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.SupplierErrorField"))) {
            error = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.SupplierErrorField"));
            Report.updateTestLog("Supplier Details Tariff Field Validation  :" + error, "PASS");
        } else {
            Report.updateTestLog("Supplier Details Tariff not Verified", "FAIL");
        }
        browser.clearValue(pageProperties.getProperty("GetAPricePage.PostCode"));
        browser.input(pageProperties.getProperty("GetAPricePage.PostCode"), "sw9 9lw");
        browser.click(pageProperties.getProperty("GetAPricePage.PostCodeNext"));
        if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage." + getaPrice.getfuelType()))) {
            browser.click(pageProperties.getProperty("GetAPricePage." + getaPrice.getfuelType()));
            browser.click(pageProperties.getProperty("GetAPricePage.FuelTypeNext"));
        }
        browser.click(pageProperties.getProperty("GetAPricePage.GasBedrooms"));
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasBedroomsValue"), getaPrice.getgasBedrooms());
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasBrand"), getaPrice.getgasSupplier());
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasTariff"), getaPrice.getgasTariff());
        browser.click(pageProperties.getProperty("GetAPricePage.GasNext"));
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.SupplierErrorField"))) {
            error = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.SupplierErrorField"));
            Report.updateTestLog("Supplier Details Payment Field Validation  :" + error, "PASS");
        } else {
            Report.updateTestLog("Supplier Details Payment not Verified", "FAIL");
        }
        browser.clearValue(pageProperties.getProperty("GetAPricePage.PostCode"));
        browser.input(pageProperties.getProperty("GetAPricePage.PostCode"), "sw9 9lw");
        browser.click(pageProperties.getProperty("GetAPricePage.PostCodeNext"));
        if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage." + getaPrice.getfuelType()))) {
            browser.click(pageProperties.getProperty("GetAPricePage." + getaPrice.getfuelType()));
            browser.click(pageProperties.getProperty("GetAPricePage.FuelTypeNext"));
        }
        browser.click(pageProperties.getProperty("GetAPricePage.GasBedrooms"));
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasBedroomsValue"), getaPrice.getgasBedrooms());
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasBrand"), getaPrice.getgasSupplier());
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasTariff"), getaPrice.getgasTariff());
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasPayment"), getaPrice.getgasPayment());
        browser.click(pageProperties.getProperty("GetAPricePage.GasNext"));

    }

    public void verifyErrorPersonalDetails(GetAPrice getaPrice) {
        if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.Title"))) {
            browser.input(pageProperties.getProperty("GetAPricePage.FirstName"), "");
            browser.input(pageProperties.getProperty("GetAPricePage.LastName"), "");
            browser.input(pageProperties.getProperty("GetAPricePage.Email"), "");
            browser.input(pageProperties.getProperty("GetAPricePage.Phone"), "");

        }
        browser.click(pageProperties.getProperty("GetAPricePage.YourDetailsNext"));
        String error;
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.DetailsErrorField"))) {
            error = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.DetailsErrorField"));
            Report.updateTestLog("Field Validation  :" + error, "PASS");
        } else {
            Report.updateTestLog("Field not Verified", "FAIL");
        }

        if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.Title"))) {
            browser.input(pageProperties.getProperty("GetAPricePage.FirstName"), getaPrice.getFirstName());
            browser.input(pageProperties.getProperty("GetAPricePage.LastName"), getaPrice.getLastName());
            browser.input(pageProperties.getProperty("GetAPricePage.Email"), getaPrice.getEmail());
            browser.input(pageProperties.getProperty("GetAPricePage.Phone"), getaPrice.getMobileNumber());
            browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.PhoneType"), getaPrice.getMobileType());
        }
        browser.click(pageProperties.getProperty("GetAPricePage.YourDetailsNext"));

        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.DetailsErrorField"))) {
            error = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.DetailsErrorField"));
            Report.updateTestLog("Title Field Validation  :" + error, "PASS");
        } else {
            Report.updateTestLog("Title not Verified", "FAIL");
        }

        if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.Title"))) {
            String[] getfirstname;
            getfirstname = new String[4];

            getfirstname[0] = " ";
            getfirstname[1] = "123456789";
            getfirstname[2] = "!@#$%^";
            getfirstname[3] = "123!@#asdf";

            for (int i = 0; i < 4; i++) {
                browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.Title"), getaPrice.getTitle());
                browser.input(pageProperties.getProperty("GetAPricePage.FirstName"), getfirstname[i]);
                browser.input(pageProperties.getProperty("GetAPricePage.LastName"), getaPrice.getLastName());
                browser.input(pageProperties.getProperty("GetAPricePage.Email"), getaPrice.getEmail());
                browser.input(pageProperties.getProperty("GetAPricePage.Phone"), getaPrice.getMobileNumber());
                browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.PhoneType"), getaPrice.getMobileType());

                browser.click(pageProperties.getProperty("GetAPricePage.YourDetailsNext"));

                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.DetailsErrorField"))) {
                    error = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.DetailsErrorField"));
                    Report.updateTestLog("First name Field Validation  :" + error, "PASS");
                } else {
                    Report.updateTestLog("First name not Verified", "FAIL");
                }
            }
        }
        if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.Title"))) {
            String[] getlastname;
            getlastname = new String[4];

            getlastname[0] = " ";
            getlastname[1] = "123456789";
            getlastname[2] = "!@#$%^";
            getlastname[3] = "123!@#asdf";

            for (int i = 0; i < 4; i++) {
                browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.Title"), getaPrice.getTitle());
                browser.input(pageProperties.getProperty("GetAPricePage.FirstName"), getaPrice.getFirstName());
                browser.input(pageProperties.getProperty("GetAPricePage.LastName"), getlastname[i]);
                browser.input(pageProperties.getProperty("GetAPricePage.Email"), getaPrice.getEmail());
                browser.input(pageProperties.getProperty("GetAPricePage.Phone"), getaPrice.getMobileNumber());
                browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.PhoneType"), getaPrice.getMobileType());

                browser.click(pageProperties.getProperty("GetAPricePage.YourDetailsNext"));

                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.DetailsErrorField"))) {
                    error = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.DetailsErrorField"));
                    Report.updateTestLog("Last name Field Validation  :" + error, "PASS");
                } else {
                    Report.updateTestLog("Last name Field not Verified", "FAIL");
                }
            }
        }
        if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.Title"))) {
            String[] getemail;
            getemail = new String[4];

            getemail[0] = " ";
            getemail[1] = "asdf@asdf@asd";
            getemail[2] = "asd123!@#!@#";
            getemail[3] = "123456889";

            for (int i = 0; i < 4; i++) {
                browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.Title"), getaPrice.getTitle());
                browser.input(pageProperties.getProperty("GetAPricePage.FirstName"), getaPrice.getFirstName());
                browser.input(pageProperties.getProperty("GetAPricePage.LastName"), getaPrice.getLastName());
                browser.input(pageProperties.getProperty("GetAPricePage.Email"), getemail[i]);
                browser.input(pageProperties.getProperty("GetAPricePage.Phone"), getaPrice.getMobileNumber());
                browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.PhoneType"), getaPrice.getMobileType());

                browser.click(pageProperties.getProperty("GetAPricePage.YourDetailsNext"));

                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.DetailsErrorField"))) {
                    error = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.DetailsErrorField"));
                    Report.updateTestLog("Email Address Field Validation  :" + error, "PASS");
                } else {
                    Report.updateTestLog("Email Address Field  not Verified", "FAIL");
                }
            }
        }
        if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.Title"))) {
            String[] getPhone;
            getPhone = new String[4];

            getPhone[0] = " ";
            getPhone[1] = "asdfasdfasd";
            getPhone[2] = "asd123!@#!@#";
            getPhone[3] = "1234568";

            for (int i = 0; i < 4; i++) {
                browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.Title"), getaPrice.getTitle());
                browser.input(pageProperties.getProperty("GetAPricePage.FirstName"), getaPrice.getFirstName());
                browser.input(pageProperties.getProperty("GetAPricePage.LastName"), getaPrice.getLastName());
                browser.input(pageProperties.getProperty("GetAPricePage.Email"), getaPrice.getEmail());
                browser.input(pageProperties.getProperty("GetAPricePage.Phone"), getPhone[i]);
                browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.PhoneType"), getaPrice.getMobileType());

                browser.click(pageProperties.getProperty("GetAPricePage.YourDetailsNext"));

                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.DetailsErrorField"))) {
                    error = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.DetailsErrorField"));
                    Report.updateTestLog("Email Address Field Validation  :" + error, "PASS");
                } else {
                    Report.updateTestLog("Email Address Field  not Verified", "FAIL");
                }
            }
        }
        if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.Title"))) {
            browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.Title"), getaPrice.getTitle());
            browser.input(pageProperties.getProperty("GetAPricePage.FirstName"), getaPrice.getFirstName());
            browser.input(pageProperties.getProperty("GetAPricePage.LastName"), getaPrice.getLastName());
            browser.input(pageProperties.getProperty("GetAPricePage.Email"), getaPrice.getEmail());
            browser.input(pageProperties.getProperty("GetAPricePage.Phone"), getaPrice.getMobileNumber());
            browser.click(pageProperties.getProperty("GetAPricePage.YourDetailsNext"));

            if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.DetailsErrorField"))) {
                error = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.DetailsErrorField"));
                Report.updateTestLog("Phone Type Field Validation  :" + error, "PASS");
            } else {
                Report.updateTestLog("Phone Type Field  not Verified", "FAIL");
            }
        }

    }

    public void clickSwitchtoTariff(GetAPrice getaPrice) {
    	
    	
    	browser.open(ApplicationConfig.APP_BG_URL+"/EnergyShop/EnergySales/orderType/online-variable-august-2014/energyType/Elec/GetAQuote");
    }

    public void switchTariff(String strTariff)
    {
    	if(strTariff == "ClearAndSimple")
    	{
    	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.SwitchClear"), "Switch to Clear And Simple");
    	}
    	if(strTariff == "OnlineVariable")
    	{
    	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.SwitchOnline"), "Switch to Online Variable");
    	}
    	if(strTariff == "FixAndFall")
    	{
    	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.SwitchFix"), "Switch to Fix And Fall");
    	}
    	browser.wait(500);
    	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.EnergySmartLinkOverlay"),"Add energy smart overlay radio button");
    	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.EnergySmartButton"),"Add energy smart overlay Continue button");
    }
    
    public void validateTariffs(String meterKind) {
        RefactorConfirmPrice = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.ConfirmationPageSpendNow"));
        if (ApplicationConfig.BRAND.equalsIgnoreCase("BG")) {
            if (meterKind.equalsIgnoreCase("Credit Meter")) {
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.ConfirmationPageTarriff").replace("TarriffName", BGTariff1))) {
                    RefactorFixedTariffPrice = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.ConfirmationPageTarriff").replace("TarriffName", BGTariff1));
                    Report.updateTestLog(BGTariff1 + " Tariff is displayed in the confirmation screen", "Pass");
                } else {
                    RefactorFixedTariffPrice = "No Tariff Displayed";
                    Report.updateTestLog(BGTariff1 + " tariff is not displayed in the confirmation screen", "Warn");
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.ConfirmationPageTarriff").replace("TarriffName", BGTariff2))) {
                    RefactorOnlineEnergyTariffPrice = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.ConfirmationPageTarriff").replace("TarriffName", BGTariff2));
                    Report.updateTestLog(BGTariff2 + " Tariff is displayed in the confirmation screen", "Pass");
                } else {
                    RefactorOnlineEnergyTariffPrice = "No Tariff Displayed";
                    Report.updateTestLog(BGTariff2 + " Tariff is not displayed in the confirmation screen", "Warn");
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.ConfirmationPageTarriff").replace("TarriffName", BGTariff3))) {
                    RefactorStandardTariffPrice = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.ConfirmationPageTarriff").replace("TarriffName", BGTariff3));
                    Report.updateTestLog(BGTariff3 + " Tariff is displayed in the confirmation screen", "Pass");
                } else {
                    RefactorStandardTariffPrice = "No Tariff Displayed";
                    Report.updateTestLog(BGTariff3 + " Tariff is not displayed in the confirmation screen", "Warn");
                }
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.ConfirmationPagePayAsYouGoTarriff").replace("TarriffName", BGTariff4))) {
                    RefactorPayAsYouGoTariffPrice = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.ConfirmationPagePayAsYouGoTarriff").replace("TarriffName", BGTariff4));
                    Report.updateTestLog(BGTariff4 + " Tariff is displayed in the confirmation screen", "Fail");
                }
            } else {
                if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.ConfirmationPagePayAsYouGoTarriff").replace("TarriffName", BGTariff4))) {
                    RefactorPayAsYouGoTariffPrice = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.ConfirmationPagePayAsYouGoTarriff").replace("TarriffName", BGTariff4));
                    Report.updateTestLog(BGTariff4 + " Tariff is displayed in the confirmation screen", "Pass");
                } else {
                    RefactorPayAsYouGoTariffPrice = "No Tariff Displayed";
                    Report.updateTestLog(BGTariff4 + " Tariff is not displayed in the confirmation screen for Prepayment Meter Type", "Fail");
                }
            }
        } else {
            if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.ConfirmationPageTarriff").replace("TarriffName", FusionTariff1))) {
                RefactorFixedTariffPrice = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.ConfirmationPageTarriff").replace("TarriffName", FusionTariff1));
                Report.updateTestLog(FusionTariff1 + " Tariff is displayed in the confirmation screen", "Pass");
            } else {
                RefactorFixedTariffPrice = "No Tariff Displayed";
                Report.updateTestLog(FusionTariff1 + " tariff is not displayed in the confirmation screen", "Warn");
            }
            if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.ConfirmationPageTarriff").replace("TarriffName", FusionTariff2))) {
                RefactorOnlineEnergyTariffPrice = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.ConfirmationPageTarriff").replace("TarriffName", FusionTariff2));
                Report.updateTestLog(FusionTariff2 + " Tariff is displayed in the confirmation screen", "Pass");
            } else {
                RefactorOnlineEnergyTariffPrice = "No Tariff Displayed";
                Report.updateTestLog(FusionTariff2 + " Tariff is not displayed in the confirmation screen", "Warn");
            }
            if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.ConfirmationPageTarriff").replace("TarriffName", FusionTariff3))) {
                RefactorStandardTariffPrice = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.ConfirmationPageTarriff").replace("TarriffName", FusionTariff3));
                Report.updateTestLog(FusionTariff3 + " Tariff is displayed in the confirmation screen", "Pass");
            } else {
                RefactorStandardTariffPrice = "No Tariff Displayed";
                Report.updateTestLog(FusionTariff3 + " Tariff is not displayed in the confirmation screen", "Warn");
            }
        }
    }

    private void togglePaymentType() {
        if (toggleValue == 3)
            toggleValue = 1;
        else
            toggleValue = 3;
    }

    private void enterSpend(String energy) {
        browser.wait(getWaitTime());
        switch (toggleSpend) {
            case 1:
                verifyAndClick(pageProperties.getProperty("GetAPricePage." + energy + "Spend"), energy + " spend");
                verifyAndInputById(pageProperties.getProperty("GetAPricePage." + energy + "SpendValue"), energy + " spend", Integer.toString(spendv));
                verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + energy + "SpendType"), energy + " spend", "Monthly");
                break;
            case 2:
                //verifyAndSelectCheckBox(pageProperties.getProperty("GetAPricePage." + energy + "Spend"), energy + " spend");
                verifyAndInputById(pageProperties.getProperty("GetAPricePage." + energy + "SpendValue"), energy + " spend", Integer.toString(spendv * 3));
                verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + energy + "SpendType"), energy + " spend", "Quarterly");
                break;
            case 3:
                //verifyAndSelectCheckBox(pageProperties.getProperty("GetAPricePage." + energy + "Spend"), energy + " spend");
                verifyAndInputById(pageProperties.getProperty("GetAPricePage." + energy + "SpendValue"), energy + " spend", Integer.toString(spendv * 12));
                verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + energy + "SpendType"), energy + " spend", "Annually");
                break;
            case 4:
                verifyAndClick(pageProperties.getProperty("GetAPricePage." + energy + "AnnConsump"), energy + " Consumption");
                verifyAndInputById(pageProperties.getProperty("GetAPricePage." + energy + "AnnConsumpValue"), energy + " Annual Consumption Field", "1500");
                break;
           /* case 5:
                verifyAndClick(pageProperties.getProperty("GetAPricePage." + energy + "Bedrooms"), energy + " Bedrooms");
                verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + energy + "BedroomsValue"), "bedrooms", "3 bedroom property");
                break;*/
        }
    }

    private void toggleSpendValue() {
        if (toggleSpend == 1)
            toggleSpend = 2;
        else if (toggleSpend == 2)
            toggleSpend = 3;
        else if (toggleSpend == 3)
            toggleSpend = 1;
        
    }

    private void validateConfirmationPage(String meterKind, String strCurrentSupplier, String selectTariff, String selectCurrentPayment) {

        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.ConfirmationPageSpendNow"))) {
            validateTariffs(meterKind);
            String annualSpend = browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.CurrentSpend"));
            annualSpend = annualSpend.substring(1, annualSpend.indexOf("."));
            System.out.println("annual spend " + annualSpend);
            if (toggleSpend == 1 || toggleSpend == 2 || toggleSpend == 3) {
                if (Integer.parseInt(annualSpend) == spendv * 12) {
                    Report.updateTestLog("annual spend displayed correctly ", "PASS");
                } else if (Integer.parseInt(annualSpend) == spendv * 24) {
                    Report.updateTestLog("annual spend displayed correctly ", "PASS");
                } else {
                    Report.updateTestLog("annual spend displayed incorrectly ", "FAIL");
                }
            }
        } else {
            Report.updateTestLog("The Supplier :" + strCurrentSupplier + ", Tariff :" + selectTariff + " and Current Payment Type :" + selectCurrentPayment + " Combination failed. Confirmation Page is not displayed ", "FAIL");
        }
    }

    private void enterPersonalDetails() {
        browser.wait(getWaitTime());
        
       Report.updateTestLog("Personal Details Section screen Shot", "WARN");
    	
    	if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.PostCode"))) {
    		browser.clearValue(pageProperties.getProperty("GetAPricePage.PostCode"));
            browser.input(pageProperties.getProperty("GetAPricePage.PostCode"), "rm38xb");
            Report.updateTestLog("PostCode Entered " , "PASS");
        } else {
            Report.updateTestLog("PostCode Not Entered", "FAIL");
        }
        if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.Title"))) {
            verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.Title"), "Title", "Mr");
            verifyAndInputById(pageProperties.getProperty("GetAPricePage.FirstName"), "First Name", "Digital");
            verifyAndInputById(pageProperties.getProperty("GetAPricePage.LastName"), "Last Name", "Automation");
            verifyAndInputById(pageProperties.getProperty("GetAPricePage.Email"), "Email ID", "Digital.Automation@centrica.com");
            verifyAndInputById(pageProperties.getProperty("GetAPricePage.Phone"), "Phone", "01234567891");
            verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.PhoneType"), "Phone Type", "Home");
            if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.YourDetailsNext"))) {
                browser.click(pageProperties.getProperty("GetAPricePage.YourDetailsNext"));
                browser.wait(getWaitTime());
                Report.updateTestLog(" Personal details entered", "PASS");
            } else {
                Report.updateTestLog("Problem with personal details", "FAIL");
            }
        }
    }

    private void enterPostCode() {
        browser.wait(getWaitTime());
        String postcode[] = {"tw18 3he", "al7 4hd"};
        verifyAndInputById(pageProperties.getProperty("GetAPricePage.PostCode"), "Post Code Field", postcode[xx]);
        inputPostCode = postcode[xx];
        browser.wait(getWaitTime());
        verifyAndClick(pageProperties.getProperty("GetAPricePage.PostCodeNext"), "Next Button");
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        if (xx == 0) {
            xx = 1;
        } else if (xx == 1) {
            xx = 0;
        }
    }

    private void enterFuelType(String fuel) {
        browser.wait(getWaitTime());
        verifyAndClick(pageProperties.getProperty("GetAPricePage." + fuel.replace("1", "").replace("2", "")), "Fuel Type : "+fuel+" is selected");
        if(fuel.equalsIgnoreCase("Dual1")){
        	verifyAndClick(pageProperties.getProperty("GetAPricePage.Dualyes"), "Dual Fuel yes Radio button");
        }
        else if(fuel.equalsIgnoreCase("Dual2")){
        	verifyAndClick(pageProperties.getProperty("GetAPricePage.Dualno"), "Dual Fuel no Radio button");
        }
        verifyAndClick(pageProperties.getProperty("GetAPricePage.FuelTypeNext"), "Next Button");
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

    private List<String> getMeterLind(String fuel) {
        browser.wait(getWaitTime());
        List<String> listGasMeterKind = new ArrayList<String>();
        if (ApplicationConfig.BRAND.equalsIgnoreCase("BG")) {
            listGasMeterKind = browser.getFromDropBox("id", pageProperties.getProperty("GetAPricePage." + fuel + "Meter"));
            return listGasMeterKind;
        } else if (ApplicationConfig.BRAND.equalsIgnoreCase("Fusion") && fuel.equalsIgnoreCase("Electricity")) {
            listGasMeterKind = browser.getFromDropBox("id", pageProperties.getProperty("GetAPricePage." + fuel + "Meter"));
            return listGasMeterKind;
        } else {
            listGasMeterKind.add("Please select");
            listGasMeterKind.add("Credit Meter");
            return listGasMeterKind;
        }
    }

    private List<String> getCurrentSupplier(String fuel) {
        List<String> listCurrentGasSupplier = browser.getFromDropBox("id", pageProperties.getProperty("GetAPricePage." + fuel + "Brand"));
        return listCurrentGasSupplier;
    }

    private int getMeterType(String brand) {
        if (brand.equalsIgnoreCase("Gas") && (ApplicationConfig.BRAND.equalsIgnoreCase("BG"))) {
            return 2;
        } else if (brand.equalsIgnoreCase("Electricity") && (ApplicationConfig.BRAND.equalsIgnoreCase("BG"))) {
            return 3;
        } else if (brand.equalsIgnoreCase("Electricity") && (ApplicationConfig.BRAND.equalsIgnoreCase("Fusion"))) {
            return 2;
        } else
            return 1;
    }

    private void enterCurrentMeterType(List<String> listGasMeterKind, int intMeterKind, String fuel) {
        browser.wait(getWaitTime());
        if (ApplicationConfig.BRAND.equalsIgnoreCase("BG")) {
            verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + fuel + "Meter"), "Meter Drop Down", listGasMeterKind.get(intMeterKind));
        } else if (ApplicationConfig.BRAND.equalsIgnoreCase("Fusion") && fuel.equalsIgnoreCase("Electricity")) {
            verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + fuel + "Meter"), "Meter Drop Down", listGasMeterKind.get(intMeterKind));
        }
    }

    private void enterPreferredPaymentMethod(String fuel) {
        if (ApplicationConfig.BRAND.equalsIgnoreCase("BG")) {
            String selectPrefPayment = "";
            if (browser.getFromDropBox("id", pageProperties.getProperty("GetAPricePage." + fuel + "PreferredPaymentType")).get(0).toString().equalsIgnoreCase("Please select")) {
                selectPrefPayment = browser.getFromDropBox("id", pageProperties.getProperty("GetAPricePage." + fuel + "PreferredPaymentType")).get(toggleValue).toString();
                togglePaymentType();
                verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + fuel + "PreferredPaymentType"), "Preferred Payment type", selectPrefPayment);
            }
        }
    }

    private String enterEnergyDetails(String fuel, String strCurrentSupplier) {
        verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + fuel + "Brand"), fuel + " Supplier Name", strCurrentSupplier);
        browser.wait(getWaitTime());
        selectTariff = browser.getFromDropBox("id", pageProperties.getProperty("GetAPricePage." + fuel + "Tariff")).get(1);
        verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + fuel + "Tariff"), fuel + " Tariff", selectTariff);
        browser.wait(getWaitTime());
        String selectCurrentPayment = "";
        if (browser.getFromDropBox("id", pageProperties.getProperty("GetAPricePage." + fuel + "Payment")).get(0).equalsIgnoreCase("Please select")) {
            selectCurrentPayment = browser.getFromDropBox("id", pageProperties.getProperty("GetAPricePage." + fuel + "Payment")).get(1);
            verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + fuel + "Payment"), "Current Payment type", selectCurrentPayment);
        }
        
        
                browser.click(pageProperties.getProperty("GetAPricePage.GasSpend"));
                browser.clearValue(pageProperties.getProperty("GetAPricePage.GasSpendValue"));
                browser.input(pageProperties.getProperty("GetAPricePage.GasSpendValue"), "500");
                browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasSpendType"), "Monthly");
                Report.updateTestLog("Gas Spend Value Entered  :" , "PASS");
            
            
        
        browser.click(pageProperties.getProperty("GetAPricePage." + fuel + "Next"));
        Report.updateTestLog(fuel + " Details Entered Successfully", "Done");
        return selectCurrentPayment;
    }

    private void navigateToGetAQuote() {
        browser.clickWithLinkText("Energy");
        browser.clickWithLinkText("Get a quote");
    }
    
    public void navigateToGetAQuotePage(){
    	browser.deleteAllCookies();
    	browser.wait(getWaitTime());
    	if(ApplicationConfig.BRAND.equalsIgnoreCase("BG")){
    		//browser.clickWithLinkText("Gas & Electricity");
    		 verifyAndClickWithLinkText(pageProperties.getProperty("GetAPricePage.NewEnergyPage"), "Gas and electricity button");
    		 browser.wait(getWaitTime());
    		 browser.wait(getWaitTime());
    		 verifyAndClickWithLinkText(pageProperties.getProperty("GetAPricePage.NewGetAQuotePage"), "Get A Quote button");
    	}
    	else{
    		verifyAndClickWithLinkText(pageProperties.getProperty("GetAPricePage.NewEnergySEPage"), "Gas and electricity button");
    		browser.wait(getWaitTime());
   		 	verifyAndClickWithLinkText(pageProperties.getProperty("GetAPricePage.NewGetAQuotePage"), "Get A Quote button");
    	}
    }
    
    public String getTariffsEndTOEnd(int tariffCount, String supplier){
    	String tariff="";
    	GetAPricePageProfile getAPricePageProfile = null;
    	
    	if (supplier == "BG"){
    		getAPricePageProfile = new TestDataHelper().getAPricePageProfile("BGENDTOEND");
    	}
    	else if(supplier == "SE"){
    		getAPricePageProfile = new TestDataHelper().getAPricePageProfile("SEENDTOEND");
    	}
    	
    	switch(tariffCount){
    		case 1:
    			tariff=getAPricePageProfile.getTariff1();
    		break;
    		case 2:
    			tariff=getAPricePageProfile.getTariff2();
    		break;
    		case 3:
    			tariff=getAPricePageProfile.getTariff3();
    		break;
    		case 4:
    			tariff=getAPricePageProfile.getTariff4();
    		break;
    		case 5:
    			tariff=getAPricePageProfile.getTariff5();
    		break;
    		case 6:
    			tariff=getAPricePageProfile.getTariff6();
    		break;
    		case 7:
    			tariff=getAPricePageProfile.getTariff7();
    		break;
    		case 8:
    			tariff=getAPricePageProfile.getTariff8();
    		break;
    		case 9:
    			tariff=getAPricePageProfile.getTariff9();
    		break;
    		
    	}
    	
    	return tariff;
    }
    
    public void enterGAPAnonymousDetailsEntire(String tariff, String flowType){
    	toggleValue = 3;
        toggleSpend = 4;
        final String fuel = "Gas";
       String PaymentType = "Monthly Direct Debit";
        inputUsage = fuel;
      enterFuelType(fuel);
 	   sysDate = new OnlineDBConnector().DBsysdate();
 	   inputPaymentType = PaymentType;
 	   newEnterEnergyDetails(fuel,PaymentType);
 	   toggleSpendValue();
        enterSpend(fuel);
        verifyAndClick(pageProperties.getProperty("GetAPricePage.GasNext"), "Next Button");
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        enterPersonalDetails();
        if(browser.isElementVisible(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"))){
        	browser.click(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"));
        	try {
    					Thread.sleep(10000);
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
        	Report.updateTestLog("Get A Quote Button Clicked Successfully", "Pass");
        }
        else{
        	Report.updateTestLog("Get A Quote Button Not present in Application Page", "Fail");
        }
        verifyCaveat(fuel,PaymentType);
        verifyFilterPresent(PaymentType);
        verifyRadioButtonsPresent(PaymentType);
        browser.wait(getWaitTime());
        verifyLeadOnlineDB(sysDate);
        verifyPersonaliseTariffFilterEntire(fuel,tariff, flowType);
    }
    
    public void enterGAPDualAnonymousDetailsEntire(String tariff, String flowType){
    	
    	toggleValue = 3;
        toggleSpend = 5;
        String SysDate="";
        String meterKind1="",meterKind2="";
        final String fuel = "Dual";
        final String fuel1 = "Gas";
        final String fuel2 = "Electricity";
        inputUsage = fuel;
        int iteration = 1;
        String strCurrentSupplier = "British Gas";
      
        	enterPostCode();
            enterFuelType(fuel);
            toggleSpendValue();
            SysDate = new OnlineDBConnector().DBsysdate();
            enterSpend(fuel1);
       	  		 meterKind1 = "Credit Meter";
          		 meterKind2 = "Credit Meter";
         	verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + fuel1 + "Meter"), "Meter Drop Down", meterKind1);
            String selectCurrentPayment1 = newEnterEnergyDetails(fuel1,meterKind1);
            enterSpend(fuel2);
            verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + fuel2 + "Meter"), "Meter Drop Down", meterKind2);
            String selectCurrentPayment2 = newEnterEnergyDetails(fuel2,meterKind2);
            enterPersonalDetails();
            
           // verifyAndClick(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"), "Get a Quote Button");
            if(browser.isElementVisible(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"))){
             	browser.click(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"));
             	try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
             	Report.updateTestLog("Get A Quote Button Clicked Successfully", "Pass");
             }
             else{
             	Report.updateTestLog("Get A Quote Button Not present in Application Page", "Fail");
             }
            
           
            verifyFilterPresent(meterKind1);
            verifyRadioButtonsPresent();
            verifyCaveat(fuel,meterKind1);
            browser.wait(getWaitTime());
            verifyLeadOnlineDB(SysDate);
    	
            verifyPersonaliseTariffFilterEntire(fuel,tariff, flowType);
    }
    
    
    
    public void enterAnonymousDetails(){
    	String[] fuelTypes = {"Gas","Electricity","Dual1"}; 
    	ArrayList<String> currentSupply = new ArrayList<String>();
    	String paymentType = "Monthly Direct Debit";
    	toggleValue = 2;
        toggleSpend = 3;
        for(String fuel : fuelTypes){
        	Report.updateTestLog("********************  "+fuel+"  *******************" , "Pass");
        	enterFuelType(fuel);
        	currentSupply = browser.getFromDropBox("xpath", pageProperties.getProperty("GetAPricePage." + fuel.replace("1", "") + "Brand"));	
        	for(String currentSupplier : currentSupply){
        		try{
        			if(browser.isElementVisible(pageProperties.getProperty("GetAPricePage." + fuel.replace("1", "").replace("2", "")))){
            			enterFuelType(fuel);
            		}
            		if(currentSupplier.equalsIgnoreCase("please select") || currentSupplier.equalsIgnoreCase("None")){
            			continue;
            		}
            		System.out.println("1111111111111111111"+currentSupplier);
            		newEnterCurrentSupplierDetails(fuel, paymentType, currentSupplier);
            		if(fuel == "Dual1"){
            			toggleSpendValue();
            			enterSpend("Gas");
                        toggleSpendValue();
                        enterSpend("Electricity");
            		}
            		else{
            			toggleSpendValue();
                		enterSpend(fuel);
            		}	
            		verifyAndClick(pageProperties.getProperty("GetAPricePage.GasNext"), "Next Button");
            		enterPersonalDetails();
            		browser.click(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"));
            		try{
            			clickEsmartOverlay();
            		}
            		catch(org.openqa.selenium.NoSuchElementException e){
            			Report.updateTestLog("Supplier "+currentSupplier+" and Tariff combination failed", "WARN");
            			browser.open(browser.getURL());
            			continue;
            		}
            		verifyPopulatedCurrentSupply(fuel,currentSupplier);
            		verifyAndClickWithLinkText(pageProperties.getProperty("GetAPricePage.GetANewQuote"), "Get a new Quote");
        		}
        		catch(Exception e){
        			continue;
        		}
        	}
        }
     	  
    }
    
    public void clickEsmartOverlay(){
    	browser.clickWithXpath(pageProperties.getProperty("GetAPricePage.ReCalculate"));
    	browser.clickWithXpath(pageProperties.getProperty("GetAPricePage.SwitchNow1"));
    	browser.clickWithXpath(pageProperties.getProperty("GetAPricePage.EnergySmartLinkOverlay"));
    	browser.clickWithXpath(pageProperties.getProperty("GetAPricePage.EnergySmartButton"));
    }
    
    public void verifyPopulatedCurrentSupply(String fuel,String currentSupplier){
    	browser.wait(3000);
    	try{
    		if(browser.getTextByXpath(".//select[@id='"+fuel.replace("1", "").replace("tricity", "").toLowerCase()+"CurrentSupplier']/option[@selected='selected']").equalsIgnoreCase(currentSupplier)){
        		Report.updateTestLog("Current Supplier "+currentSupplier+" successfully populated", "Pass");
        	}
        	else{
        		Report.updateTestLog("Current Supplier "+currentSupplier+" Mismatch", "Fail");
        	}
    	}
    	catch(org.openqa.selenium.NoSuchElementException e){
    		Report.updateTestLog("Current Supplier "+currentSupplier+" not selected in the your Order Page", "Fail");
    	}
    	browser.browserBack();
    	browser.wait(4000);
    }
    
        public void enterGAPAnonymousDetails(){
        	toggleValue = 3;
            toggleSpend = 4;
            final String fuel = "Gas";
            String PaymentType[] = {"Monthly Direct Debit","Quarterly Direct Debit","Cash/Debit/Credit Card"};
            inputUsage = fuel;
            for(int iteration = 0; iteration<PaymentType.length;iteration++){
         	   enterFuelType(fuel);
         	   sysDate = new OnlineDBConnector().DBsysdate();
         	   inputPaymentType = PaymentType[iteration];
         	   newEnterEnergyDetails(fuel,PaymentType[iteration]);
         	   toggleSpendValue();
                enterSpend(fuel);
                verifyAndClick(pageProperties.getProperty("GetAPricePage.GasNext"), "Next Button");
                try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
                enterPersonalDetails();
                if(browser.isElementVisible(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"))){
                	browser.click(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"));
                	try {
    					Thread.sleep(10000);
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
                	Report.updateTestLog("Get A Quote Button Clicked Successfully", "Pass");
                }
                else{
                	Report.updateTestLog("Get A Quote Button Not present in Application Page", "Fail");
                }
                verifyCaveat(fuel,PaymentType[iteration]);
                verifyFilterPresent(PaymentType[iteration]);
                verifyRadioButtonsPresent(PaymentType[iteration]);
                browser.wait(getWaitTime());
                verifyLeadOnlineDB(sysDate);
             
                if (ApplicationConfig.BRAND.equalsIgnoreCase("BG")) {
               		 verifyPersonaliseTariffFilter(fuel);
                }
                else{
                	verifySEPersonaliseTariffFilter(fuel);
                }
                verifyAndClickWithLinkText(pageProperties.getProperty("GetAPricePage.GetANewQuote"), "Get a new Quote");
            }
    }
    
    public void enteronlyGAPAnonymousDetails(){
        
   	 toggleValue = 3;
        toggleSpend = 5;
        int iteration = 5;
        String meterKind="";
        final String fuel = "Gas";
        
        inputUsage = fuel;
        String strCurrentSupplier = "British Gas";
        if (ApplicationConfig.BRAND.equalsIgnoreCase("BG")){
       	iteration = 10;
        }
        for (int Supply=0;Supply<iteration;Supply++){
       	 enterPostCode();
            enterFuelType(fuel);
            sysDate = new OnlineDBConnector().DBsysdate();
            toggleSpendValue();
            enterSpend(fuel);
            meterKind = "Credit Meter";
            if (ApplicationConfig.BRAND.equalsIgnoreCase("BG")){  
       	meterKind = "Prepayment Gas Meter";
       	 if(Supply < 5){
       		 meterKind = "Credit Meter";
       	 }
            }
       		 inputMeterKind = meterKind;
       	 verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + fuel + "Meter"), "Meter Drop Down", meterKind);
            String selectCurrentPayment = newEnterEnergyDetails(fuel,meterKind);
            enterPersonalDetails();
            
           // verifyAndClick(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"), "Get a Quote Button");
            if(browser.isElementVisible(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"))){
             	browser.click(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"));
            	try {
        					Thread.sleep(10000);
        				} catch (InterruptedException e) {
        					e.printStackTrace();
        				}
             	Report.updateTestLog("Get A Quote Button Clicked Successfully", "Pass");
             }
             else{
             	Report.updateTestLog("Get A Quote Button Not present in Application Page", "Fail");
             }
            verifyCaveat(fuel,meterKind);
            verifyFilterPresent(meterKind);
            verifyRadioButtonsPresent();
            browser.wait(getWaitTime());
            verifyLeadOnlineDB(sysDate);
           
            if (ApplicationConfig.BRAND.equalsIgnoreCase("BG")) {
           	 if((!meterKind.equals("Prepayment Gas Meter")) && (!meterKind.equals("Prepayment Electricity Meter"))){
           		 verifyPersonaliseTariffFilter(fuel);
           	 }
           	 else{
           		 verifyPersonaliseTariffFilterPayAsYouGo(fuel);
           	 }
            }
            else{
            	verifySEPersonaliseTariffFilter(fuel);
            }
            if (ApplicationConfig.BRAND.equalsIgnoreCase("BG")){
           	 if(Supply < 9){
           		 
           		 browser.clickWithLinkText(pageProperties.getProperty("GetAPricePage.NewGetAQuotePage"));
           	 }
            }
           if (ApplicationConfig.BRAND.equalsIgnoreCase("FUSION")){
           	if(Supply < 4){
              	 
           		browser.clickWithLinkText(pageProperties.getProperty("GetAPricePage.NewGetAQuotePage"));
               }
              
           }
        }
       browser.wait(getWaitTime());
       
       
   }
    
    
    public void enterOAMGAPDetails(UserProfile userProfile){
    	toggleValue = 3;
        toggleSpend = 4;
        final String fuel = "Electricity";
        String PaymentType[] = {"Monthly Direct Debit","Quarterly Direct Debit","Cash/Debit/Credit Card"};
        inputUsage = fuel;
        for(int iteration = 0; iteration<PaymentType.length;iteration++){
     	   enterFuelType(fuel);
     	   sysDate = new OnlineDBConnector().DBsysdate();
     	   inputPaymentType = PaymentType[iteration];
     	   newEnterEnergyDetails(fuel,PaymentType[iteration]);
     	   toggleSpendValue();
            enterSpend(fuel);
            verifyAndClick(pageProperties.getProperty("GetAPricePage.GasNext"), "Next Button");
            try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//            enterPersonalDetails();
            
            if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.PostCode"))) {
           		browser.clearValue(pageProperties.getProperty("GetAPricePage.PostCode"));
                   browser.input(pageProperties.getProperty("GetAPricePage.PostCode"), "rm38xb");
                   Report.updateTestLog("PostCode Entered " , "PASS");
               } else {
                   Report.updateTestLog("PostCode Not Entered", "FAIL");
               }
               
                   if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.YourDetailsNext"))) {
                       browser.click(pageProperties.getProperty("GetAPricePage.YourDetailsNext"));
                       browser.wait(getWaitTime());
                       Report.updateTestLog(" Personal details entered", "PASS");
                   } else {
                       Report.updateTestLog("Problem with personal details", "FAIL");
                   }
                   
            if(browser.isElementVisible(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"))){
            	browser.click(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"));
            	try {
        					Thread.sleep(10000);
        				} catch (InterruptedException e) {
        					e.printStackTrace();
        				}
            	Report.updateTestLog("Get A Quote Button Clicked Successfully", "Pass");
            }
            else{
            	Report.updateTestLog("Get A Quote Button Not present in Application Page", "Fail");
            }
            verifyCaveat(fuel,PaymentType[iteration]);
            verifyFilterPresent(PaymentType[iteration]);
            verifyRadioButtonsPresent(PaymentType[iteration]);
            browser.wait(getWaitTime());
            verifyLeadOnlineDB(sysDate);
         
            if (ApplicationConfig.BRAND.equalsIgnoreCase("BG")) {
           		 verifyPersonaliseTariffFilter(fuel);
            }
            else{
            	verifySEPersonaliseTariffFilter(fuel);
            }
            verifyAndClickWithLinkText(pageProperties.getProperty("GetAPricePage.GetANewQuote"), "Get a new Quote");
        }
        
    }
    
    
    public void enterOAMGAPPayAsYouGoDetails(UserProfile userProfile){
    	toggleValue = 3;
        toggleSpend = 4;
        final String fuel = "Electricity";
        String PaymentType[] = {"Pay As You Go Energy™"};
        inputUsage = fuel;
        for(int iteration = 0; iteration<PaymentType.length;iteration++){
     	   enterFuelType(fuel);
     	   sysDate = new OnlineDBConnector().DBsysdate();
     	   inputPaymentType = PaymentType[iteration];
     	   newEnterEnergyDetails(fuel,PaymentType[iteration]);
     	   toggleSpendValue();
            enterSpend(fuel);
            verifyAndClick(pageProperties.getProperty("GetAPricePage.GasNext"), "Next Button");
            try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//            enterPersonalDetails();
            
            if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.PostCode"))) {
        		browser.clearValue(pageProperties.getProperty("GetAPricePage.PostCode"));
                browser.input(pageProperties.getProperty("GetAPricePage.PostCode"), "rm38xb");
                Report.updateTestLog("PostCode Entered " , "PASS");
            } else {
                Report.updateTestLog("PostCode Not Entered", "FAIL");
            }
            
                if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.YourDetailsNext"))) {
                    browser.click(pageProperties.getProperty("GetAPricePage.YourDetailsNext"));
                    browser.wait(getWaitTime());
                    Report.updateTestLog(" Personal details entered", "PASS");
                } else {
                    Report.updateTestLog("Problem with personal details", "FAIL");
                }
                
            if(browser.isElementVisible(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"))){
            	browser.click(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"));
            	try {
        					Thread.sleep(10000);
        				} catch (InterruptedException e) {
        					e.printStackTrace();
        				}
            	Report.updateTestLog("Get A Quote Button Clicked Successfully", "Pass");
            }
            else{
            	Report.updateTestLog("Get A Quote Button Not present in Application Page", "Fail");
            }
            verifyCaveat(fuel,PaymentType[iteration]);
            verifyFilterPresent(PaymentType[iteration]);
            verifyRadioButtonsPresent(PaymentType[iteration]);
            browser.wait(getWaitTime());
            verifyLeadOnlineDB(sysDate);
            verifyPersonaliseTariffFilterPayAsYouGo(fuel);
            verifyAndClickWithLinkText(pageProperties.getProperty("GetAPricePage.GetANewQuote"), "Get a new Quote");
        }
     }
    
    
   public void enterOAMGAPGasDetails(UserProfile userProfile){
	   toggleValue = 3;
       toggleSpend = 4;
       final String fuel = "Gas";
       String PaymentType[] = {"Monthly Direct Debit","Quarterly Direct Debit","Cash/Debit/Credit Card"};
       inputUsage = fuel;
       for(int iteration = 0; iteration<PaymentType.length;iteration++){
    	   enterFuelType(fuel);
    	   sysDate = new OnlineDBConnector().DBsysdate();
    	   inputPaymentType = PaymentType[iteration];
    	   newEnterEnergyDetails(fuel,PaymentType[iteration]);
    	   toggleSpendValue();
           enterSpend(fuel);
           verifyAndClick(pageProperties.getProperty("GetAPricePage.GasNext"), "Next Button");
           try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//           enterPersonalDetails();
           if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.PostCode"))) {
          		browser.clearValue(pageProperties.getProperty("GetAPricePage.PostCode"));
                  browser.input(pageProperties.getProperty("GetAPricePage.PostCode"), "rm38xb");
                  Report.updateTestLog("PostCode Entered " , "PASS");
              } else {
                  Report.updateTestLog("PostCode Not Entered", "FAIL");
              }
              
                  if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.YourDetailsNext"))) {
                      browser.click(pageProperties.getProperty("GetAPricePage.YourDetailsNext"));
                      browser.wait(getWaitTime());
                      Report.updateTestLog(" Personal details entered", "PASS");
                  } else {
                      Report.updateTestLog("Problem with personal details", "FAIL");
                  }
           if(browser.isElementVisible(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"))){
           	browser.click(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"));
        	try {
    					Thread.sleep(10000);
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
           	Report.updateTestLog("Get A Quote Button Clicked Successfully", "Pass");
           }
           else{
           	Report.updateTestLog("Get A Quote Button Not present in Application Page", "Fail");
           }
           verifyCaveat(fuel,PaymentType[iteration]);
           verifyFilterPresent(PaymentType[iteration]);
           verifyRadioButtonsPresent(PaymentType[iteration]);
           browser.wait(getWaitTime());
           verifyLeadOnlineDB(sysDate);
        
           if (ApplicationConfig.BRAND.equalsIgnoreCase("BG")) {
          		 verifyPersonaliseTariffFilter(fuel);
           }
           else{
           	verifySEPersonaliseTariffFilter(fuel);
           }
           verifyAndClickWithLinkText(pageProperties.getProperty("GetAPricePage.GetANewQuote"), "Get a new Quote");
       }
       
     }
   
   
   public void enterOAMGAPGasPayAsYouGoDetails(UserProfile userProfile){
	   toggleValue = 3;
       toggleSpend = 4;
       final String fuel = "Gas";
       String PaymentType[] = {"Pay As You Go Energy™"};
       inputUsage = fuel;
       for(int iteration = 0; iteration<PaymentType.length;iteration++){
    	   enterFuelType(fuel);
    	   sysDate = new OnlineDBConnector().DBsysdate();
    	   inputPaymentType = PaymentType[iteration];
    	   newEnterEnergyDetails(fuel,PaymentType[iteration]);
    	   toggleSpendValue();
           enterSpend(fuel);
           verifyAndClick(pageProperties.getProperty("GetAPricePage.GasNext"), "Next Button");
           try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//           enterPersonalDetails();
           
           if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.PostCode"))) {
       		browser.clearValue(pageProperties.getProperty("GetAPricePage.PostCode"));
               browser.input(pageProperties.getProperty("GetAPricePage.PostCode"), "rm38xb");
               Report.updateTestLog("PostCode Entered " , "PASS");
           } else {
               Report.updateTestLog("PostCode Not Entered", "FAIL");
           }
           
               if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.YourDetailsNext"))) {
                   browser.click(pageProperties.getProperty("GetAPricePage.YourDetailsNext"));
                   browser.wait(getWaitTime());
                   Report.updateTestLog(" Personal details entered", "PASS");
               } else {
                   Report.updateTestLog("Problem with personal details", "FAIL");
               }
               
           if(browser.isElementVisible(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"))){
           	browser.click(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"));
        	try {
    					Thread.sleep(10000);
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
           	Report.updateTestLog("Get A Quote Button Clicked Successfully", "Pass");
           }
           else{
           	Report.updateTestLog("Get A Quote Button Not present in Application Page", "Fail");
           }
           verifyCaveat(fuel,PaymentType[iteration]);
           verifyFilterPresent(PaymentType[iteration]);
           verifyRadioButtonsPresent(PaymentType[iteration]);
           browser.wait(getWaitTime());
           verifyLeadOnlineDB(sysDate);
           verifyPersonaliseTariffFilterPayAsYouGo(fuel);
           verifyAndClickWithLinkText(pageProperties.getProperty("GetAPricePage.GetANewQuote"), "Get a new Quote");
       }
    }
    
   public void enterOAMGAPDualDetails(UserProfile userProfile){
	   toggleValue = 3;
       toggleSpend = 4;
       String fuel = "Dual1";
       String PaymentType[] = {"Monthly Direct Debit","Quarterly Direct Debit","Cash/Debit/Credit Card"};
       inputUsage = fuel;
       for(int DualIteration = 0; DualIteration<2; DualIteration++){
       	if(DualIteration == 1){
       		fuel = "Dual2";
       	}
       	for(int iteration = 0; iteration<PaymentType.length;iteration++){
         	   enterFuelType(fuel);
         	   sysDate = new OnlineDBConnector().DBsysdate();
         	   inputPaymentType = PaymentType[iteration];
         	   newEnterEnergyDetails(fuel,PaymentType[iteration]);
         	   toggleSpendValue();
                enterSpend("Gas");
                toggleSpendValue();
                enterSpend("Electricity");
                verifyAndClick(pageProperties.getProperty("GetAPricePage.GasNext"), "Next Button");
                try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//                enterPersonalDetails();
                
                if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.PostCode"))) {
               		browser.clearValue(pageProperties.getProperty("GetAPricePage.PostCode"));
                       browser.input(pageProperties.getProperty("GetAPricePage.PostCode"), "rm38xb");
                       Report.updateTestLog("PostCode Entered " , "PASS");
                   } else {
                       Report.updateTestLog("PostCode Not Entered", "FAIL");
                   }
                   
                       if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.YourDetailsNext"))) {
                           browser.click(pageProperties.getProperty("GetAPricePage.YourDetailsNext"));
                           browser.wait(getWaitTime());
                           Report.updateTestLog(" Personal details entered", "PASS");
                       } else {
                           Report.updateTestLog("Problem with personal details", "FAIL");
                       }
                       
                       
                if(browser.isElementVisible(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"))){
                	browser.click(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"));
                	try {
    					Thread.sleep(10000);
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
                	Report.updateTestLog("Get A Quote Button Clicked Successfully", "Pass");
                }
                else{
                	Report.updateTestLog("Get A Quote Button Not present in Application Page", "Fail");
                }
                verifyCaveat(fuel,PaymentType[iteration]);
                verifyFilterPresent(PaymentType[iteration]);
                verifyRadioButtonsPresent(PaymentType[iteration]);
                browser.wait(getWaitTime());
                verifyLeadOnlineDB(sysDate);
             
                if (ApplicationConfig.BRAND.equalsIgnoreCase("BG")) {
               		 verifyPersonaliseTariffFilter("Dual");
                }
                else{
                	verifySEPersonaliseTariffFilter("Dual");
                }
                verifyAndClickWithLinkText(pageProperties.getProperty("GetAPricePage.GetANewQuote"), "Get a new Quote");
            }
       }
      }
   
   
   public void enterOAMGAPDualPayAsYouGoDetails(UserProfile userProfile){
	   toggleValue = 3;
       toggleSpend = 4;
       String fuel = "Dual1";
       String PaymentType[] = {"Pay As You Go Energy™"};
       inputUsage = fuel;
       for(int DualIteration = 0; DualIteration<2; DualIteration++){
       	if(DualIteration == 1){
       		fuel = "Dual2";
       	}
       	for(int iteration = 0; iteration<PaymentType.length;iteration++){
         	   enterFuelType(fuel);
         	   sysDate = new OnlineDBConnector().DBsysdate();
         	   inputPaymentType = PaymentType[iteration];
         	   newEnterEnergyDetails(fuel,PaymentType[iteration]);
         	   toggleSpendValue();
                enterSpend("Gas");
                toggleSpendValue();
                enterSpend("Electricity");
                verifyAndClick(pageProperties.getProperty("GetAPricePage.GasNext"), "Next Button");
                try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//                enterPersonalDetails();
                
                
                if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.PostCode"))) {
            		browser.clearValue(pageProperties.getProperty("GetAPricePage.PostCode"));
                    browser.input(pageProperties.getProperty("GetAPricePage.PostCode"), "rm38xb");
                    Report.updateTestLog("PostCode Entered " , "PASS");
                } else {
                    Report.updateTestLog("PostCode Not Entered", "FAIL");
                }
                
                    if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.YourDetailsNext"))) {
                        browser.click(pageProperties.getProperty("GetAPricePage.YourDetailsNext"));
                        browser.wait(getWaitTime());
                        Report.updateTestLog(" Personal details entered", "PASS");
                    } else {
                        Report.updateTestLog("Problem with personal details", "FAIL");
                    }
                
                if(browser.isElementVisible(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"))){
                	browser.click(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"));
                	try {
    					Thread.sleep(10000);
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
                	Report.updateTestLog("Get A Quote Button Clicked Successfully", "Pass");
                }
                else{
                	Report.updateTestLog("Get A Quote Button Not present in Application Page", "Fail");
                }
                verifyCaveat(fuel,PaymentType[iteration]);
                verifyFilterPresent(PaymentType[iteration]);
                verifyRadioButtonsPresent(PaymentType[iteration]);
                browser.wait(getWaitTime());
                verifyLeadOnlineDB(sysDate);
                verifyPersonaliseTariffFilterPayAsYouGo("Dual");
                verifyAndClickWithLinkText(pageProperties.getProperty("GetAPricePage.GetANewQuote"), "Get a new Quote");
            }
       }
       
      }
   
   
   public void newVerifyAllGasSupplierDetails(GetAPrice getaPrice){
	   toggleValue = 3;
       toggleSpend = 4;
       final String fuel = "Gas";
       String PaymentType[] = {"Monthly Direct Debit","Quarterly Direct Debit","Cash/Debit/Credit Card"};
       inputUsage = fuel;
       for(int iteration = 0; iteration<PaymentType.length;iteration++){
    	   enterFuelType(fuel);
    	   sysDate = new OnlineDBConnector().DBsysdate();
    	   inputPaymentType = PaymentType[iteration];
    	   newEnterEnergyDetails(fuel,PaymentType[iteration]);
    	   toggleSpendValue();
           enterSpend(fuel);
           verifyAndClick(pageProperties.getProperty("GetAPricePage.GasNext"), "Next Button");
           try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
           enterPersonalDetails();
           if(browser.isElementVisible(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"))){
           	browser.click(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"));
        	try {
    					Thread.sleep(10000);
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
           	Report.updateTestLog("Get A Quote Button Clicked Successfully", "Pass");
           }
           else{
           	Report.updateTestLog("Get A Quote Button Not present in Application Page", "Fail");
           }
           verifyCaveat(fuel,PaymentType[iteration]);
           verifyFilterPresent(PaymentType[iteration]);
           verifyRadioButtonsPresent(PaymentType[iteration]);
           browser.wait(getWaitTime());
           verifyLeadOnlineDB(sysDate);
        
           if (ApplicationConfig.BRAND.equalsIgnoreCase("BG")) {
          		 verifyPersonaliseTariffFilter(fuel);
           }
           else{
           	verifySEPersonaliseTariffFilter(fuel);
           }
           verifyAndClickWithLinkText(pageProperties.getProperty("GetAPricePage.GetANewQuote"), "Get a new Quote");
       }
       
   }
  
   
    public void newVerifyAllGasSupplierPayAsYouGoDetails(GetAPrice getaPrice){
    	 toggleValue = 3;
         toggleSpend = 4;
         final String fuel = "Gas";
         String PaymentType[] = {"Pay As You Go Energy™"};
         inputUsage = fuel;
         for(int iteration = 0; iteration<PaymentType.length;iteration++){
      	   enterFuelType(fuel);
      	   sysDate = new OnlineDBConnector().DBsysdate();
      	   inputPaymentType = PaymentType[iteration];
      	   newEnterEnergyDetails(fuel,PaymentType[iteration]);
      	   toggleSpendValue();
             enterSpend(fuel);
             verifyAndClick(pageProperties.getProperty("GetAPricePage.GasNext"), "Next Button");
             try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
             enterPersonalDetails();
             if(browser.isElementVisible(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"))){
             	browser.click(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"));
            	try {
        					Thread.sleep(10000);
        				} catch (InterruptedException e) {
        					e.printStackTrace();
        				}
             	Report.updateTestLog("Get A Quote Button Clicked Successfully", "Pass");
             }
             else{
             	Report.updateTestLog("Get A Quote Button Not present in Application Page", "Fail");
             }
             verifyCaveat(fuel,PaymentType[iteration]);
             verifyFilterPresent(PaymentType[iteration]);
             verifyRadioButtonsPresent(PaymentType[iteration]);
             browser.wait(getWaitTime());
             verifyLeadOnlineDB(sysDate);
             verifyPersonaliseTariffFilterPayAsYouGo(fuel);
             verifyAndClickWithLinkText(pageProperties.getProperty("GetAPricePage.GetANewQuote"), "Get a new Quote");
         }
    }
    
    
    public void newVerifyAllElecSupplierGAPDetails(GetAPrice getaPrice){
    	toggleValue = 3;
        toggleSpend = 4;
        final String fuel = "Electricity";
        String PaymentType[] = {"Monthly Direct Debit","Quarterly Direct Debit","Cash/Debit/Credit Card"};
        inputUsage = fuel;
        for(int iteration = 0; iteration<PaymentType.length;iteration++){
     	   enterFuelType(fuel);
     	   sysDate = new OnlineDBConnector().DBsysdate();
     	   inputPaymentType = PaymentType[iteration];
     	   newEnterEnergyDetails(fuel,PaymentType[iteration]);
     	   toggleSpendValue();
            enterSpend(fuel);
            verifyAndClick(pageProperties.getProperty("GetAPricePage.GasNext"), "Next Button");
            try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            enterPersonalDetails();
            if(browser.isElementVisible(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"))){
            	browser.click(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"));
            	try {
        					Thread.sleep(10000);
        				} catch (InterruptedException e) {
        					e.printStackTrace();
        				}
            	Report.updateTestLog("Get A Quote Button Clicked Successfully", "Pass");
            }
            else{
            	Report.updateTestLog("Get A Quote Button Not present in Application Page", "Fail");
            }
            verifyCaveat(fuel,PaymentType[iteration]);
            verifyFilterPresent(PaymentType[iteration]);
            verifyRadioButtonsPresent(PaymentType[iteration]);
            browser.wait(getWaitTime());
            verifyLeadOnlineDB(sysDate);
         
            if (ApplicationConfig.BRAND.equalsIgnoreCase("BG")) {
           		 verifyPersonaliseTariffFilter(fuel);
            }
            else{
            	verifySEPersonaliseTariffFilter(fuel);
            }
            verifyAndClickWithLinkText(pageProperties.getProperty("GetAPricePage.GetANewQuote"), "Get a new Quote");
        }
        
    }
    
    
    public void newVerifyAllElecSupplierPayAsYouGoGAPDetails(GetAPrice getaPrice){
    	toggleValue = 3;
        toggleSpend = 4;
        final String fuel = "Electricity";
        String PaymentType[] = {"Pay As You Go Energy™"};
        inputUsage = fuel;
        for(int iteration = 0; iteration<PaymentType.length;iteration++){
     	   enterFuelType(fuel);
     	   sysDate = new OnlineDBConnector().DBsysdate();
     	   inputPaymentType = PaymentType[iteration];
     	   newEnterEnergyDetails(fuel,PaymentType[iteration]);
     	   toggleSpendValue();
            enterSpend(fuel);
            verifyAndClick(pageProperties.getProperty("GetAPricePage.GasNext"), "Next Button");
            try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            enterPersonalDetails();
            if(browser.isElementVisible(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"))){
            	browser.click(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"));
            	try {
        					Thread.sleep(10000);
        				} catch (InterruptedException e) {
        					e.printStackTrace();
        				}
            	Report.updateTestLog("Get A Quote Button Clicked Successfully", "Pass");
            }
            else{
            	Report.updateTestLog("Get A Quote Button Not present in Application Page", "Fail");
            }
            verifyCaveat(fuel,PaymentType[iteration]);
            verifyFilterPresent(PaymentType[iteration]);
            verifyRadioButtonsPresent(PaymentType[iteration]);
            browser.wait(getWaitTime());
            verifyLeadOnlineDB(sysDate);
            verifyPersonaliseTariffFilterPayAsYouGo(fuel);
            verifyAndClickWithLinkText(pageProperties.getProperty("GetAPricePage.GetANewQuote"), "Get a new Quote");
        }
    }
    
   
    public void newVerifyAllDualSupplierGAPDetails(GetAPrice getaPrice){
    	toggleValue = 3;
        toggleSpend = 4;
        String fuel = "Dual1";
        String PaymentType[] = {"Monthly Direct Debit","Quarterly Direct Debit","Cash/Debit/Credit Card"};
        inputUsage = fuel;
        for(int DualIteration = 0; DualIteration<2; DualIteration++){
        	if(DualIteration == 1){
        		fuel = "Dual2";
        	}
        	for(int iteration = 0; iteration<PaymentType.length;iteration++){
          	   enterFuelType(fuel);
          	   sysDate = new OnlineDBConnector().DBsysdate();
          	   inputPaymentType = PaymentType[iteration];
          	   newEnterEnergyDetails(fuel,PaymentType[iteration]);
          	   toggleSpendValue();
                 enterSpend("Gas");
                 toggleSpendValue();
                 enterSpend("Electricity");
                 verifyAndClick(pageProperties.getProperty("GetAPricePage.GasNext"), "Next Button");
                 try {
 					Thread.sleep(10000);
 				} catch (InterruptedException e) {
 					e.printStackTrace();
 				}
                 enterPersonalDetails();
                 if(browser.isElementVisible(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"))){
                 	browser.click(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"));
                	try {
    					Thread.sleep(10000);
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
                 	Report.updateTestLog("Get A Quote Button Clicked Successfully", "Pass");
                 }
                 else{
                 	Report.updateTestLog("Get A Quote Button Not present in Application Page", "Fail");
                 }
                 verifyCaveat(fuel,PaymentType[iteration]);
                 verifyFilterPresent(PaymentType[iteration]);
                 verifyRadioButtonsPresent(PaymentType[iteration]);
                 browser.wait(getWaitTime());
                 verifyLeadOnlineDB(sysDate);
              
                 if (ApplicationConfig.BRAND.equalsIgnoreCase("BG")) {
                		 verifyPersonaliseTariffFilter("Dual");
                 }
                 else{
                 	verifySEPersonaliseTariffFilter("Dual");
                 }
                 verifyAndClickWithLinkText(pageProperties.getProperty("GetAPricePage.GetANewQuote"), "Get a new Quote");
             }
        }
        
    }
    
  /*  public void newVerifyAllDualSupplierGAPDetails(GetAPrice getaPrice){
    	toggleValue = 3;
        toggleSpend = 5;
        String SysDate="";
        String meterKind1="",meterKind2="";
        final String fuel = "Dual";
        final String fuel1 = "Gas";
        final String fuel2 = "Electricity";
        inputUsage = fuel;
        int iteration = 10;
        String strCurrentSupplier = "British Gas";
        for (int Supply=0;Supply<iteration;Supply++){
        	enterPostCode();
            enterFuelType(fuel);
            toggleSpendValue();
            SysDate = new OnlineDBConnector().DBsysdate();
            enterSpend(fuel1);
       	
          	 if(Supply < 5){
          		 meterKind1 = "Credit Meter";
          		 meterKind2 = "Credit Meter";
          	 }
          	 if(Supply > 4){
          		meterKind1 = "Credit Meter";
          		 meterKind2 = "Two Rate / Economy 7 Credit";
          	 }
     	
     		inputMeterKind = meterKind1;
       	 	verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + fuel1 + "Meter"), "Meter Drop Down", meterKind1);
            String selectCurrentPayment1 = newEnterEnergyDetails(fuel1,meterKind1);
            enterSpend(fuel2);
            verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + fuel2 + "Meter"), "Meter Drop Down", meterKind2);
            String selectCurrentPayment2 = newEnterEnergyDetails(fuel2,meterKind2);
            enterPersonalDetails();
            
           // verifyAndClick(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"), "Get a Quote Button");
            if(browser.isElementVisible(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"))){
             	browser.click(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"));
             	Report.updateTestLog("Get A Quote Button Clicked Successfully", "Pass");
             }
             else{
             	Report.updateTestLog("Get A Quote Button Not present in Application Page", "Fail");
             }
            
           
            verifyFilterPresent(meterKind1);
            verifyRadioButtonsPresent();
            verifyCaveat(fuel,meterKind1);
            browser.wait(getWaitTime());
            verifyLeadOnlineDB(SysDate);
            
            if (ApplicationConfig.BRAND.equalsIgnoreCase("BG")) {
             		verifyPersonaliseTariffFilter(fuel);
             }
             else{
             	verifySEPersonaliseTariffFilter(fuel);
             }
            
           	 if(Supply < 9){
           		browser.clickWithLinkText(pageProperties.getProperty("GetAPricePage.NewGetAQuotePage"));
           	 }
            
         }
     }*/
    
    public void newVerifyAllDualSupplierPayAsYouGoGAPDetails(GetAPrice getaPrice){
    	toggleValue = 3;
        toggleSpend = 4;
        String fuel = "Dual1";
        String PaymentType[] = {"Pay As You Go Energy™"};
        inputUsage = fuel;
        for(int DualIteration = 0; DualIteration<2; DualIteration++){
        	if(DualIteration == 1){
        		fuel = "Dual2";
        	}
        	for(int iteration = 0; iteration<PaymentType.length;iteration++){
          	   enterFuelType(fuel);
          	   sysDate = new OnlineDBConnector().DBsysdate();
          	   inputPaymentType = PaymentType[iteration];
          	   newEnterEnergyDetails(fuel,PaymentType[iteration]);
          	   toggleSpendValue();
                 enterSpend("Gas");
                 toggleSpendValue();
                 enterSpend("Electricity");
                 verifyAndClick(pageProperties.getProperty("GetAPricePage.GasNext"), "Next Button");
                 try {
 					Thread.sleep(10000);
 				} catch (InterruptedException e) {
 					e.printStackTrace();
 				}
                 enterPersonalDetails();
                 if(browser.isElementVisible(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"))){
                 	browser.click(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"));
                	try {
    					Thread.sleep(10000);
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
                 	Report.updateTestLog("Get A Quote Button Clicked Successfully", "Pass");
                 }
                 else{
                 	Report.updateTestLog("Get A Quote Button Not present in Application Page", "Fail");
                 }
                 verifyCaveat(fuel,PaymentType[iteration]);
                 verifyFilterPresent(PaymentType[iteration]);
                 verifyRadioButtonsPresent(PaymentType[iteration]);
                 browser.wait(getWaitTime());
                 verifyLeadOnlineDB(sysDate);
                 verifyPersonaliseTariffFilterPayAsYouGo("Dual");
                 verifyAndClickWithLinkText(pageProperties.getProperty("GetAPricePage.GetANewQuote"), "Get a new Quote");
             }
        }
        
    }
    
    
    /*public void newVerifyAllDualSupplierPayAsYouGoGAPDetails(GetAPrice getaPrice){
    	toggleValue = 3;
        toggleSpend = 5;
        String SysDate="";
        String meterKind1="",meterKind2="";
        final String fuel = "Dual";
        final String fuel1 = "Gas";
        final String fuel2 = "Electricity";
        inputUsage = fuel;
        int iteration = 5;
        String strCurrentSupplier = "British Gas";
        for (int Supply=0;Supply<iteration;Supply++){
        	enterPostCode();
            enterFuelType(fuel);
            SysDate = new OnlineDBConnector().DBsysdate();
            toggleSpendValue();
            enterSpend(fuel1);
       		meterKind1 = "Prepayment Gas Meter";
           	meterKind2 = "Prepayment Electricity Meter";
       		inputMeterKind = meterKind1;
       	 	verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + fuel1 + "Meter"), "Meter Drop Down", meterKind1);
            String selectCurrentPayment1 = newEnterEnergyDetails(fuel1,meterKind1);
            enterSpend(fuel2);
            verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + fuel2 + "Meter"), "Meter Drop Down", meterKind2);
            String selectCurrentPayment2 = newEnterEnergyDetails(fuel2,meterKind2);
            enterPersonalDetails();
            
            //verifyAndClick(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"), "Get a Quote Button");
            if(browser.isElementVisible(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"))){
             	browser.click(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"));
             	Report.updateTestLog("Get A Quote Button Clicked Successfully", "Pass");
             }
             else{
             	Report.updateTestLog("Get A Quote Button Not present in Application Page", "Fail");
             }
            verifyFilterPresent(meterKind1);
            verifyRadioButtonsPresent();
            verifyCaveat(fuel,meterKind1);
            browser.wait(getWaitTime());
            verifyLeadOnlineDB(SysDate);
            verifyPersonaliseTariffFilterPayAsYouGo(fuel);
             if(Supply < 4){
           		browser.clickWithLinkText(pageProperties.getProperty("GetAPricePage.NewGetAQuotePage"));
           	 }
            
         }
     }*/
    
    
    
    private String newEnterEnergyDetails(String fuel, String PaymentType) {
    	
    	if(fuel == "Gas"){
    		browser.wait(5000);
    		verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("GetAPricePage." + fuel + "Brand"), fuel + " Supplier Name", "npower");
    		//verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + fuel + "Brand"), fuel + " Supplier Name", "npower");
    		verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + fuel + "Payment"), "Current Payment type", PaymentType);
            inputCurrentPay = PaymentType;
            verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + fuel + "Tariff"), fuel + " Tariff","Standard");
        	inputCurrentTariff = "Standard";
        }
    	
    	if(fuel == "Electricity"){
    		verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + fuel + "Brand"), fuel + " Supplier Name", "npower");
    		verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + fuel + "Payment"), "Current Payment type", PaymentType);
    		if(PaymentType.equals("Monthly Direct Debit")){
    			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.Economy7Select"), "Economy 7 tariff", "Yes");
    		}
    		else if(!PaymentType.contains("Pay As You Go")){
    			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.Economy7Select"), "Economy 7 tariff", "No");
    		}
    		inputCurrentPay = PaymentType;
            verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + fuel + "Tariff"), fuel + " Tariff","Standard");
        	inputCurrentTariff = "Standard";
        }
    	
    	if(fuel == "Dual1"){
    		verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.EnergyBrand"), fuel + " Supplier Name", "npower");
    		verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.EnergyPayment"), "Current Payment type", PaymentType);
    		if(PaymentType.equals("Monthly Direct Debit")){
    			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.EnergyEconomy7Select"), "Economy 7 tariff", "Yes");
    		}
    		else if(!PaymentType.contains("Pay As You Go")){
    			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.EnergyEconomy7Select"), "Economy 7 tariff", "No");
    		}
    		inputCurrentPay = PaymentType;
            verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.EnergyTariff"), fuel + " Tariff","Standard");
        	inputCurrentTariff = "Standard";
    	}
    	
    	if(fuel == "Dual2"){
    		verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.GasBrand"), fuel + " Supplier Name", "npower");
    		verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.GasPayment"), "Current Payment type", PaymentType);
            inputCurrentPay = PaymentType;
            verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.GasTariff"), fuel + " Tariff","Standard");
        	inputCurrentTariff = "Standard";
        	
    		verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.ElectricityBrand"), fuel + " Supplier Name", "npower");
    		verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.ElectricityPayment"), "Current Payment type", PaymentType);
    		if(PaymentType.equals("Monthly Direct Debit")){
    			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.Economy7Select"), "Economy 7 tariff", "Yes");
    		}
    		else if(!PaymentType.contains("Pay As You Go")){
    			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.Economy7Select"), "Economy 7 tariff", "No");
    		}
    		inputCurrentPay = PaymentType;
            verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.ElectricityTariff"), fuel + " Tariff","Standard");
        	inputCurrentTariff = "Standard";
    	}
   	
    	
    	return "";
    }
    
    
    private String newEnterCurrentSupplierDetails(String fuel, String PaymentType, String currentSupplier) {
    	ArrayList<String> currentTariff = new ArrayList<String>();
    	if(fuel == "Gas"){
    		browser.wait(5000);
    		verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("GetAPricePage." + fuel + "Brand"), fuel + " Supplier Name", currentSupplier);
    		verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + fuel + "Payment"), "Current Payment type", PaymentType);
            inputCurrentPay = PaymentType;
            currentTariff = browser.getFromDropBox("id", pageProperties.getProperty("GetAPricePage." + fuel + "Tariff"));
            verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + fuel + "Tariff"), fuel + " Tariff",currentTariff.get(1));
        	inputCurrentTariff = "Standard";
        }
    	
    	if(fuel == "Electricity"){
    		browser.wait(2000);
    		verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("GetAPricePage." + fuel + "Brand"), fuel + " Supplier Name", currentSupplier);
    		verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + fuel + "Payment"), "Current Payment type", PaymentType);
    		if(PaymentType.equals("Monthly Direct Debit")){
    			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.Economy7Select"), "Economy 7 tariff", "Yes");
    		}
    		else if(!PaymentType.contains("Pay As You Go")){
    			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.Economy7Select"), "Economy 7 tariff", currentSupplier);
    		}
    		inputCurrentPay = PaymentType;
    		currentTariff = browser.getFromDropBox("id", pageProperties.getProperty("GetAPricePage." + fuel + "Tariff"));
    		System.out.println("qqqqqqqqqqqqqqqqqqqqq"+currentTariff);
            verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + fuel + "Tariff"), fuel + " Tariff",currentTariff.get(1));
        	inputCurrentTariff = "Standard";
        }
    	
    	if(fuel == "Dual1"){
    		verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.EnergyBrand"), fuel + " Supplier Name", currentSupplier);
    		verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.EnergyPayment"), "Current Payment type", PaymentType);
    		if(PaymentType.equals("Monthly Direct Debit")){
    			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.EnergyEconomy7Select"), "Economy 7 tariff", "Yes");
    		}
    		else if(!PaymentType.contains("Pay As You Go")){
    			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.EnergyEconomy7Select"), "Economy 7 tariff", "No");
    		}
    		inputCurrentPay = PaymentType;
    		currentTariff = browser.getFromDropBox("id", pageProperties.getProperty("GetAPricePage.EnergyTariff"));
            verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.EnergyTariff"), fuel + " Tariff",currentTariff.get(1));
        	inputCurrentTariff = "Standard";
    	}
    	
    	if(fuel == "Dual2"){
    		verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.GasBrand"), fuel + " Supplier Name", currentSupplier);
    		verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.GasPayment"), "Current Payment type", PaymentType);
            inputCurrentPay = PaymentType;
            verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.GasTariff"), fuel + " Tariff","Standard");
        	inputCurrentTariff = "Standard";
        	
    		verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.ElectricityBrand"), fuel + " Supplier Name", "npower");
    		verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.ElectricityPayment"), "Current Payment type", PaymentType);
    		if(PaymentType.equals("Monthly Direct Debit")){
    			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.Economy7Select"), "Economy 7 tariff", "Yes");
    		}
    		else if(!PaymentType.contains("Pay As You Go")){
    			verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.Economy7Select"), "Economy 7 tariff", "No");
    		}
    		inputCurrentPay = PaymentType;
    		currentTariff = browser.getFromDropBox("id", pageProperties.getProperty("GetAPricePage." + fuel + "Tariff"));
            verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.ElectricityTariff"), fuel + " Tariff",currentTariff.get(1));
        	inputCurrentTariff = "Standard";
    	}
   	
    	
    	return "";
    }
    
    
    public void verifyGAQFields(){
    	if(browser.isTextPresent("Please enter the postcode")){
    		if(browser.isElementVisibleWithName(pageProperties.getProperty("GetAPricePage.PreProdPostCode"))){
    			if(browser.isElementVisibleWithName(pageProperties.getProperty("GetAPricePage.PostCodeNext"))){
    				Report.updateTestLog("Post code Field Verified", "Pass");
    			}
    		}
    	}
    	
    	if(!browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.FieldValidation1")))
    	{
    		if(!browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.FieldValidation2")))
    		{
    			if(!browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.FieldValidation3")))
    			{
    				if(!browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.FieldValidation4"))){
    					Report.updateTestLog("All Fields nVerified", "Pass");
    				}
    			}
    		}
    	
    	}
    	
    }
    
    public void verifyFieldsAfterPostCode()
    {
    	if((browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.editPostCode")))&&(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.nextFuelType")))){
    		Report.updateTestLog("Edit option is enabled for PostCode,Fuel Type Enabled ", "Pass");
    		
    	}
    	else{
    		Report.updateTestLog("Edit option is not enabled for PostCode,Fuel Type not Enabled ", "Fail");
    	}
    }
    
    public void verifyFieldsAfterFuelType()
    {
    	if((browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.editfuelType")))){
    		Report.updateTestLog("Edit option is enabled for Fuel ", "Pass");
    		if((browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.GasNext")))){
        		Report.updateTestLog("Fields are displayed for Fuel Supplier", "Pass");
    		}
    	}
    		else{
    		Report.updateTestLog("Edit option is not enabled for Fuel", "Fail");
    	}
    }
    
    
    public void verifyFieldsAfterSupply()
    {
    	if((browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.FieldValidation1")))){
    		Report.updateTestLog("Edit option is enabled for Supplier ", "Pass");
    		if((browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.FieldValidation4")))){
        		Report.updateTestLog("Fields are displayed for Personal Details", "Pass");
    		}
    	}
    		else{
    		Report.updateTestLog("Edit option is not enabled for Supplier", "Fail");
    	}
    }
    
    public void verifyFieldsAfterPersonalDetails()
    {
    	if((browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.edit-details")))){
    		Report.updateTestLog("Edit option is enabled for Personal Details ", "Pass");
    		if((browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.GetAQuoteButton")))){
        		Report.updateTestLog("Get A Quote Button is displayed", "Pass");
    		}
    	}
    		else{
    		Report.updateTestLog("Edit option is not enabled for Supplier", "Fail");
    	}
    }
    
    
    public void verifyAndEnterGAQAnonymousDetails(){
    	enterFuelType("Gas");
    	verifyFieldsAfterFuelType();
    	newEnterEnergyDetails("Gas","Monthly Direct Debit");
    	toggleSpend = 1;
    	enterSpend("Gas");
    	verifyAndClick(pageProperties.getProperty("GetAPricePage.GasNext"), "Next Button");
    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        verifyFieldsAfterSupply();
        verifyGAQFields();
        enterPersonalDetails();
        verifyFieldsAfterPersonalDetails();
        verifyAndClick(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"), "Get a Quote Button");
        verifyOverlayPresent();
    }
    
    private String newEnterCurrentMeterType(List<String> listGasMeterKind, int intMeterKind, String fuel) {
        browser.wait(getWaitTime());
        if (ApplicationConfig.BRAND.equalsIgnoreCase("BG")) {
            verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + fuel + "Meter"), "Meter Drop Down", listGasMeterKind.get(intMeterKind));
        } else if (ApplicationConfig.BRAND.equalsIgnoreCase("Fusion") && fuel.equalsIgnoreCase("Electricity")) {
            verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage." + fuel + "Meter"), "Meter Drop Down", listGasMeterKind.get(intMeterKind));
        }
        return listGasMeterKind.get(intMeterKind);
    }
    
    public void verifyOverlayPresent(){
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.FixedWhatsThis"))){
    		Report.updateTestLog("What's this link Found for Fixed tariff", "Pass");
    		verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.FixedWhatsThis"), "Fixed Tariff What's this overlay");
    		Report.updateTestLog("What's this overlay displayed for Fixed tariff", "Pass");
    		verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.FixedOverlayClose"), "Fixed Tariff What's this overlay closed");
    	}
    	
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.VariableWhatsThis"))){
    		Report.updateTestLog("What's this link Found for Variable tariff", "Pass");
    		verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.VariableWhatsThis"), "Variable Tariff What's this overlay");
    		Report.updateTestLog("What's this overlay displayed for Variable tariff", "Pass");
    		verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.VariableOverlayClose"), "Variable Tariff What's this overlay closed");
    	}
    	
    	
    }
    
    public void overlayValidation(String fuel,String payment,String tariff,String contract,String display,int count){
/*    	String SwitchNow[] ={"SwitchNow1","SwitchNow2","SwitchNow3","SwitchNow4","SwitchNow5","SwitchNow6","SwitchNow7","SwitchNow8","SwitchNow9","SwitchNow10","SwitchNow11","SwitchNow12","SwitchNow13","SwitchNow14","SwitchNow15"};
    	String SwitchNowPayAsYouGo[] = {"SwitchNowPayAsYouGo1","SwitchNowPayAsYouGo2","SwitchNowPayAsYouGo3","SwitchNowPayAsYouGo4","SwitchNowPayAsYouGo5","SwitchNowPayAsYouGo6","SwitchNowPayAsYouGo7","SwitchNowPayAsYouGo8","SwitchNowPayAsYouGo9","SwitchNowPayAsYouGo10","SwitchNowPayAsYouGo11","SwitchNowPayAsYouGo12","SwitchNowPayAsYouGo13","SwitchNowPayAsYouGo14","SwitchNowPayAsYouGo15"};
    	if(ApplicationConfig.BRAND.equalsIgnoreCase("bg")){
    		if(inputPaymentType.contains("Pay As You Go")){
    			if(tariff.equalsIgnoreCase("ShowAll") && contract.equalsIgnoreCase("ShowAllContract")){
    				for(int i=0;i<count;i++){
            				Report.updateTestLog("Switch Now is selected for "+browser.getCellValueByXpath(pageProperties.getProperty("GetAPricePage.Table"), i+2, 1), "Pass");
            				cheapestTariff = browser.getCellValueByXpath(pageProperties.getProperty("GetAPricePage.Table"), 2, 1);
            				verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage."+SwitchNowPayAsYouGo[i]), "Switch now button clicked");
            				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.EnergySmartButton"))){
            					Report.updateTestLog("Overlay Present for Pay As You Go Tariff", "Fail");
            				}
            				browser.browserBack();
            	}
    		}
    	}
    		else{
    			if((payment.equalsIgnoreCase("DirectDebit") && tariff.equalsIgnoreCase("ShowAll") && contract.equalsIgnoreCase("ShowAllContract") && display.equalsIgnoreCase("Monthly")) ||
            			(payment.equalsIgnoreCase("ReceiptBill") && tariff.equalsIgnoreCase("ShowAll") && contract.equalsIgnoreCase("ShowAllContract") && display.equalsIgnoreCase("Monthly"))){
            		for(int i=0;i<count;i++){
            			for(int j=0;j<2;j++){
            				Report.updateTestLog("Switch Now is selected for "+browser.getCellValueByXpath(pageProperties.getProperty("GetAPricePage.Table"), i+2, 1), "Pass");
            				cheapestTariff = browser.getCellValueByXpath(pageProperties.getProperty("GetAPricePage.Table"), 2, 1);
            				verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage."+SwitchNow[i]), "Switch now button clicked");
            				j = energySmartOverlay(j);
            			}
            		}
            		verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage."+inputSelectTariff), inputSelectTariff+" Payment Selected");
        		}
    		}
    		
    	}
    	else{
    		if(tariff.equalsIgnoreCase("ShowAll") && contract.equalsIgnoreCase("ShowAllContract") && display.equalsIgnoreCase("Monthly")){
    			for(int i=0;i<count;i++){
    						cheapestTariff = browser.getCellValueByXpath(pageProperties.getProperty("GetAPricePage.Table"), 2, 1);
        					Report.updateTestLog("Switch Now is selected for "+browser.getCellValueByXpath(pageProperties.getProperty("GetAPricePage.Table"), i+2, 1), "Pass");
        					verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage."+chooseOverlay(browser.getCellValueByXpath(pageProperties.getProperty("GetAPricePage.Table"), i+2, 1))), "Switch now button clicked");
        					browser.browserBack();
        				
        		}
    		}
    	}*/
    }
    	
      
    
    public int energySmartOverlay(int temp){
    	
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.EnergySmartButton"))){
    		Report.updateTestLog("Overlay Present, Energy Smart Page displayed", "Pass");
    	
    		if(browser.isSelected(pageProperties.getProperty("GetAPricePage.EnergySmartLinkOverlay"))){
    			Report.updateTestLog("Energy Smart Radio button is selected by default", "Pass");
    		}
    		if(flagOverlay == true){
    			verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.EnergySmartButton"), "Continue Button clicked");
    			flagOverlay = false;
    		}
    		else{
    			verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.NoEnergySmart"), "No Energy Smart Radio Option Clicked");
    			verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.EnergySmartButton"), "Continue Button clicked");
    			flagOverlay = true;
    		}
    	}
    	else{
    		
    		if(browser.isTextPresent("Your order details")){
        		Report.updateTestLog("Overlay Not Present", "Pass");
        	}
    		else{
    			Report.updateTestLog("Overlay Not Present", "Pass");
    			Report.updateTestLog("Error Page found", "Fail");
    		}
    		browser.browserBack();
    		return 2;
    	}
    	browser.browserBack();
    	return temp;
    }
    
    public void verifyPersonaliseTariffFilterEntire(String fuel,String tariff, String flowType){
    	if(ApplicationConfig.BRAND.equalsIgnoreCase("BG")){
    		if(flowType.equalsIgnoreCase("EnergySmart")){
    			if(tariff.equalsIgnoreCase("OnlineVariableAugust2014")){
            		verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.ReCalculate"), "Click ReCalculate Button");
                	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.SwitchNow1"), "Select Switch Now");
                	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.EnergySmartLinkOverlay"), "Energy Smart Radio Option Clicked");
                	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.EnergySmartButton"), "Continue Button clicked");
            	}
            	else if(tariff.equalsIgnoreCase("ClearSimple")){
            		verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.ReCalculate"), "Click ReCalculate Button");
                	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.SwitchNow2"), "Select Switch Now");
                	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.EnergySmartLinkOverlay"), "Energy Smart Radio Option Clicked");
                	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.EnergySmartButton"), "Continue Button clicked");
            	}
            	else if(tariff.equalsIgnoreCase("PricePromiseJuly2014")){
            		verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.ReCalculate"), "Click ReCalculate Button");
                	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.SwitchNow3"), "Select Switch Now");
                	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.EnergySmartLinkOverlay"), "Energy Smart Radio Option Clicked");
                	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.EnergySmartButton"), "Continue Button clicked");
            	}
            	else if(tariff.equalsIgnoreCase("PricePromiseApril2015")){
            		verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.ReCalculate"), "Click ReCalculate Button");
                	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.SwitchNow4"), "Select Switch Now");
                	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.EnergySmartLinkOverlay"), "Energy Smart Radio Option Clicked");
                	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.EnergySmartButton"), "Continue Button clicked");
            	}
    		}
    		else if(flowType.equalsIgnoreCase("EnergyShop")){
    			if(tariff.equalsIgnoreCase("OnlineVariableAugust2014")){
            		verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.ReCalculate"), "Click ReCalculate Button");
                	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.SwitchNow1"), "Select Switch Now");
                	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.NoEnergySmart"), "No Energy Smart Radio Option Clicked");
                	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.EnergySmartButton"), "Continue Button clicked");
            	}
            	else if(tariff.equalsIgnoreCase("ClearSimple")){
            		verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.ReCalculate"), "Click ReCalculate Button");
                	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.SwitchNow2"), "Select Switch Now");
                	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.NoEnergySmart"), "No Energy Smart Radio Option Clicked");
                	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.EnergySmartButton"), "Continue Button clicked");
            	}
            	else if(tariff.equalsIgnoreCase("PricePromiseJuly2014")){
            		verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.ReCalculate"), "Click ReCalculate Button");
                	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.SwitchNow3"), "Select Switch Now");
                	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.NoEnergySmart"), "No Energy Smart Radio Option Clicked");
                	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.EnergySmartButton"), "Continue Button clicked");
            	}
            	else if(tariff.equalsIgnoreCase("PricePromiseApril2015")){
            		verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.ReCalculate"), "Click ReCalculate Button");
                	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.SwitchNow4"), "Select Switch Now");
                	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.NoEnergySmart"), "No Energy Smart Radio Option Clicked");
                	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.EnergySmartButton"), "Continue Button clicked");
            	}
    		}
    		
    	}
    	else{
    		 if(tariff.equalsIgnoreCase("ClearSimple")){
    			verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.ReCalculate"), "Click ReCalculate Button");
             	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.SwitchClear"), "Select Switch Now");
    		 }
    		 else if(tariff.equalsIgnoreCase("FixedpriceMay2014")){
    			verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.ReCalculate"), "Click ReCalculate Button");
              	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.SwitchFixed"), "Select Switch Now");
    		 }
    		 else if(tariff.equalsIgnoreCase("OnlineVariableSeptember2013")){
     			verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.ReCalculate"), "Click ReCalculate Button");
               	verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.SwitchOnline"), "Select Switch Now");
     		 }
    	}
    	
    	
    }
    
    
    public void verifyPersonaliseTariffFilter(String fuel){
    	String Payment[]={"DirectDebit","ReceiptBill"};
    	String TariffType[]={"ShowAll","Fixed","Variable"};
    	String ContractLength[] = {"ShowAllContract","Upto16Months","None"};
     	String DisplayFigure[] = {"Monthly","Quartely","Annually"};
     	
     	for(int pay=0;pay<2;pay++){
     		inputSelectTariff = Payment[pay];
     		 verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage."+inputSelectTariff), Payment[pay]+"Payment Selected");
    		for(int tariff=0;tariff<3;tariff++){
    			verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage."+TariffType[tariff]), TariffType[tariff]+" Tariff Selected");
    			for(int contract=0;contract<3;contract++){
    				verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage."+ContractLength[contract]), ContractLength[contract]+" Contract Selected");
    				for(int display=0;display<3;display++){
    					verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage."+DisplayFigure[display]), DisplayFigure[display]+" Display Selected");
    					verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.ReCalculate"), "Click ReCalculate Button");
    					verifyTariffPresent(fuel,Payment[pay],TariffType[tariff],ContractLength[contract],DisplayFigure[display]);
    					try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
    					
    					Report.updateTestLog("Current Spend ="+browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.CurrentSpend"))+" for "+DisplayFigure[display]+" display.", "Pass");
    					
    					
    				}
    			}
    		}
    			
    	}
    }
    
    public void verifySEPersonaliseTariffFilter(String fuel){
    	String tariffType[]={"ShowAll","Fixed","Variable"};
    	String contractLength[] = {"ShowAllContract","Upto16Months","None"};
     	String displayFigure[] = {"Monthly","Quartely","Annually"};
     	
     	Report.updateTestLog("Current Spend ="+browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.CurrentSpend"))+" per month", "Pass");
     	//verifySEDefaultFilterSelection(tariffType[0],contractLength[0],displayFigure[0]);
     	
     	for(int tariff=0;tariff<3;tariff++){
			verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage."+tariffType[tariff]), tariffType[tariff]+" Tariff Selected");
			for(int contract=0;contract<3;contract++){
				verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage."+contractLength[contract]), contractLength[contract]+" Contract Selected");
				for(int display=0;display<3;display++){
					verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage."+displayFigure[display]), displayFigure[display]+" Display Selected");
					
					verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.ReCalculate"), "Click ReCalculate Button");
					//verifySETariffPresent(fuel,TariffType[tariff],ContractLength[contract],DisplayFigure[display]);
					verifyTariffPresent(fuel,"",tariffType[tariff],contractLength[contract],displayFigure[display]);
				}
			}
		}
			
    }
    
    public void verifyPersonaliseTariffFilterPayAsYouGo(String fuel){
    	String TariffType[]={"ShowAll","Fixed","Variable"};
    	String ContractLength[] = {"ShowAllContract","Upto12Months","PayAsYouGoUpto16Months","PayAsYouGoNone"};
    	
    	Report.updateTestLog("Current Spend ="+browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.CurrentSpend"))+" per month", "Pass");
    	//payAsYouGoCheckDefaultFilterSelection(TariffType[0],ContractLength[0]);
    	
    	for(int tariff=0;tariff<3;tariff++){
			verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage."+TariffType[tariff]), TariffType[tariff]+" Tariff Selected");
			for(int contract=0;contract<4;contract++){
				verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage."+ContractLength[contract]), ContractLength[contract]+" Contract Selected");
				verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.ReCalculate"), "Click ReCalculate Button");
				verifyTariffPresent(fuel,"PayAsYouGo",TariffType[tariff],ContractLength[contract],"");
			}
    	}
    }
    
    public void verifyTariffPresent(String fuel,String Payment,String Tariff,String Contract, String display){
    	try
    	{
    	String displayfig="",content="", displayForecastCost="", displayForecastSave="", displayCurrentSpend="";
    	int count=0;
    	double ForecastCost=0,ForecastSave=0,CurrentSpend=0;
    	String[] tariffs = new String[20];
    	String[] exitFee = new String[20];
    	boolean flag=true,tariffflag = true;
    	if(display.equalsIgnoreCase("Monthly")){
    		displayfig = "month";
    	}
    	if(display.equalsIgnoreCase("Quartely")){
    		displayfig = "quarter";
    	}
    	if(display.equalsIgnoreCase("Annually")){
    		displayfig = "year";
    	}
    	if(Payment.equalsIgnoreCase("PayAsYouGo")){
    		displayfig = "month";
    	}
    	//Get Tariffs and their exit fee
    	 GetAPricePageProfile getAPricePageProfile = new TestDataHelper().getAPricePageProfile(fuel+Payment+Tariff+Contract); 
    	tariffs[1]=getAPricePageProfile.getTariff1();
    	tariffs[2]=getAPricePageProfile.getTariff2();
    	tariffs[3]=getAPricePageProfile.getTariff3();
    	tariffs[4]=getAPricePageProfile.getTariff4();
    	tariffs[5]=getAPricePageProfile.getTariff5();
    	tariffs[6]=getAPricePageProfile.getTariff6();
    	tariffs[7]=getAPricePageProfile.getTariff7();
    	tariffs[8]=getAPricePageProfile.getTariff8();
    	tariffs[9]=getAPricePageProfile.getTariff9();
    	tariffs[10]=getAPricePageProfile.getTariff10();
    	tariffs[11]=getAPricePageProfile.getTariff11();
    	tariffs[12]=getAPricePageProfile.getTariff12();
    	tariffs[13]=getAPricePageProfile.getTariff13();
    	tariffs[14]=getAPricePageProfile.getTariff14();
    	tariffs[15]=getAPricePageProfile.getTariff15();
    	exitFee[1]=getAPricePageProfile.getExitFee1();
    	exitFee[2]=getAPricePageProfile.getExitFee2();
    	exitFee[3]=getAPricePageProfile.getExitFee3();
    	exitFee[4]=getAPricePageProfile.getExitFee4();
    	exitFee[5]=getAPricePageProfile.getExitFee5();
    	exitFee[6]=getAPricePageProfile.getExitFee6();
    	exitFee[7]=getAPricePageProfile.getExitFee7();
    	exitFee[8]=getAPricePageProfile.getExitFee8();
    	exitFee[9]=getAPricePageProfile.getExitFee9();
    	exitFee[10]=getAPricePageProfile.getExitFee10();
    	exitFee[11]=getAPricePageProfile.getExitFee11();
    	exitFee[12]=getAPricePageProfile.getExitFee12();
    	exitFee[13]=getAPricePageProfile.getExitFee13();
    	exitFee[14]=getAPricePageProfile.getExitFee14();
    	exitFee[15]=getAPricePageProfile.getExitFee15();
    	
//    	 Count for the tariffs
    	
    	
    	for(int tariffcount = 1;tariffcount < 16; tariffcount++){
    		if(tariffs[tariffcount] != ""){
    			count = count+1;
    		}
    		else{
    			break;
    		}
    	}
    	
    	if(count == 0){
    		if(browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.NoDataAvailableSE")).equalsIgnoreCase("No data available")||
    				browser.getTextByXpath(pageProperties.getProperty("GetAPricePage.NoDataAvailableSE")).equalsIgnoreCase("Please amend your selected options")){
    			Report.updateTestLog("No Tariffs available for "+Tariff+","+Contract, "Pass");
    			Report.updateTestLog("Please amend your selected options", "Pass");
    			tariffflag = false;
    		}
    	}
    
    	
    	
    	// call for overlay validation
    	overlayValidation(fuel,Payment,Tariff, Contract,display,count);
    	
    	if(displayfig.equalsIgnoreCase("month")){
    		Report.updateTestLog("The Number of Tariffs displayed for "+fuel+" Fuel for Payment "+Payment+", Tariff "+Tariff+", Contract"+Contract+" is "+count+ "("+tariffs[1]+" "+tariffs[2]+" "+tariffs[3]+" "+tariffs[4]+" "+tariffs[5]+" "+tariffs[6]+" "+tariffs[7]+" "+tariffs[8]+" "+tariffs[9]+" "+tariffs[10]+")", "Pass");
    	}
    	
    	for(int i=1;i<(count+1);i++){
    		for(int j=1;j<(count+1);j++){
    			// verify tariffs and exit fee
    			if((browser.getCellValueByXpath(pageProperties.getProperty("GetAPricePage.Table"), i+1, 1).replace(" ", "").replace("&", "").equalsIgnoreCase(tariffs[j]))){
    				Report.updateTestLog(browser.getCellValueByXpath(pageProperties.getProperty("GetAPricePage.Table"), i+1, 1)+ " tariff is verified for "+Payment+", "+Tariff+", "+Contract+", "+display, "Pass");
    				if(cheapestTariff.replace(" ", "").replace("&", "").equalsIgnoreCase(tariffs[j])){
    					Report.updateTestLog(cheapestTariff+" tariff is verified as cheapest tariff", "Pass");
    				}
    				if(browser.getCellValueByXpath(pageProperties.getProperty("GetAPricePage.Table"), i+1, 3).replace(" ", "").replace("/", "").contains(exitFee[j])){
    					Report.updateTestLog("Exit Fee : "+browser.getCellValueByXpath(pageProperties.getProperty("GetAPricePage.Table"), i+1, 3)+" is present for "+browser.getCellValueByXpath(pageProperties.getProperty("GetAPricePage.Table"), i+1, 1), "Pass");
    				}
    				else{
    					Report.updateTestLog("Exit fee mismatch", "Fail");
    				}
    				//verify Price and display figure
    				for(int k=4;k<6;k++){
    					 content = browser.getCellValueByXpath(pageProperties.getProperty("GetAPricePage.Table"), i+1, k);
    					 if(!content.contains(displayfig)){
    	    					flag = false;
    	    				}
    	    				if(!content.contains("Save") && !content.contains("Extra")){
    	    				//	String decimalForecastCost = content.substring(1,content.indexOf("\n"));
    	    					
    	    					displayForecastCost = content.replaceAll("[^\\d(?!.)]","");
    	    					
    	    					ForecastCost = Double.parseDouble(content.replaceAll("[^\\d(?!.)]",""));
    	    				}
    	    				else{
    	    					//ForecastSave = Double.parseDouble(content.replace("Save", "").replace("Extra spend", "").replace("per month", "").replace("per quarter", "").replace("per annual", "").replace("per year", "").substring(2).trim());
    	    					ForecastSave = Double.parseDouble(content.replaceAll("[^\\d(?!.)]",""));
    	    					displayForecastSave = content.replaceAll("[^\\d(?!.)]","");
    	    					
    	    				}
    				}	    	       			
    	    		//	CurrentSpend = Double.parseDouble(browser.getTextByXpath("//*[@id='annual-amt']/span[1]").substring(1,5));
    	    			//CurrentSpend = Float.parseFloat(browser.getTextByXpath("//*[@id='annual-amt']/span[1]").substring(1));
    					CurrentSpend = Double.parseDouble(browser.getTextByXpath("//*[@id='annual-amt']/span[1]").replaceAll("[^\\d(?!.)]",""));
    					displayCurrentSpend = browser.getTextByXpath("//*[@id='annual-amt']/span[1]").replaceAll("[^\\d(?!.)]","");
    					
    	    			if((ForecastSave == Double.parseDouble(new DecimalFormat("0.##").format(CurrentSpend - ForecastCost)))){
	    						Report.updateTestLog("Tariff price for "+browser.getCellValueByXpath(pageProperties.getProperty("GetAPricePage.Table"), i+1, 1)+" verified", "Pass");
	    						Report.updateTestLog(display+"display : Current Spend is £"+displayCurrentSpend+", Forecasted cost is £"+displayForecastCost+", Forecasted Saving is £"+displayForecastSave, "Pass");
	    						verifyDecimalPoints(displayForecastCost,"ForecastCost ");
	    						verifyDecimalPoints(displayForecastSave,"ForecastSave ");
	    						verifyDecimalPoints(displayCurrentSpend,"CurrentSpend ");
    	    				}
    	    		   	else if((ForecastSave == Double.parseDouble(new DecimalFormat("0.##").format(ForecastCost - CurrentSpend)))){
    	    		   		Report.updateTestLog("Tariff price for "+browser.getCellValueByXpath(pageProperties.getProperty("GetAPricePage.Table"), i+1, 1)+" verified", "Pass");
    						Report.updateTestLog(display+"display : Current Spend is £"+displayCurrentSpend+", Forecasted cost is £"+displayForecastCost+", Extra Spend is £"+displayForecastSave, "Pass");
    						verifyDecimalPoints(displayForecastCost,"ForecastCost ");
    						verifyDecimalPoints(displayForecastSave,"ForecastSave ");
    						verifyDecimalPoints(displayCurrentSpend,"CurrentSpend ");
    	    		   	}
    	    			else{
    	    					Report.updateTestLog("Tariff Prices Mismatch for "+browser.getCellValueByXpath(pageProperties.getProperty("GetAPricePage.Table"), i+1, 1), "Fail");
    	    			}
    				
    	    		if (flag == true){
    	    			Report.updateTestLog("Display Type per "+displayfig+" verified in Current Spend, Forecasted Cost and Forecasted Saving for "+browser.getCellValueByXpath(pageProperties.getProperty("GetAPricePage.Table"), i+1, 1), "Pass");
    	    		}
    	
    			}
    		}
    	}
    }
    	catch(org.openqa.selenium.NoSuchElementException e){
    		Report.updateTestLog("Check for Tariff changes", "Fail");
    	}
    	catch(java.lang.NumberFormatException n){
    		Report.updateTestLog("Abnormal Tariff prices displayed", "Fail");
    	}
    }
    
  
    
    
   public void verifyLeadOnlineDB(String date){
	  try{
	   OnlineDBConnector oldb = new OnlineDBConnector();
	   String LeadStatus = oldb.verifyLeadQuoteDB(date);
	   QuoteLeadId = oldb.getQuoteId(date);
	   if(LeadStatus.equals("0")){
		   Report.updateTestLog("Lead Status in Online DB verified as 0 and the Lead ID is"+QuoteLeadId, "Pass");
		   Report.updateTestLog("Lead Data : "+oldb.getQuoteLeadData(QuoteLeadId), "Pass");
		   Report.updateTestLog("Title: Mr, First Name: Digital, Last Name: Automation, Email ID: Digital.Automation@centrica.com, Phone :0123456789, Phone Type: Home, PostCode: "+inputPostCode+", MeterKind: "+inputMeterKind+", CurrentPay: "+inputCurrentPay+" Usage: "+inputUsage+", Current Supplier: British Gas, Tariff: "+inputCurrentTariff, "Pass");
	   }
	  }
	  catch(Exception e){
		  Report.updateTestLog("Lead Verification Failed", "Fail");
	  }
	  
	}
   
   public void runBatchGetAQuote(){
	   OnlineDBConnector oldb = new OnlineDBConnector();
	     SshClient sshClient=new SshClient();
		try {
				sshClient.connect();
				if(sshClient.isConnected())
				{
					sshClient.send("cd scripts");
					Thread.sleep(10000);
					sshClient.send("chmod 777 ./dogetquoteprocess.sh");
					sshClient.send("dos2unix ./dogetquoteprocess.sh");
					sshClient.send("chmod 777 ./dogetquoteprocess.sh");
					System.out.println(sshClient.send("./dogetquoteprocess.sh"));
					Thread.sleep(25000);
					Report.updateTestLog("Batch Run Successful", "Pass");
				}
			}
		catch(Exception e){
			
		}
		
   }
   
   public void verifyLeadDB(){
	   try{
		   OnlineDBConnector oldb = new OnlineDBConnector();
		   String leadStatus = oldb.verifyLeadQuoteAferBatch(QuoteLeadId);
		   if(leadStatus.equals("1")){
			   Report.updateTestLog("Lead Status in Online DB After Batch run verified as 1", "Pass");
		   }
		   else if(leadStatus.equals("0")){
			   Report.updateTestLog("Lead Status in Online DB After Batch run verified as 0", "Fail");
		   }
	   }
	   catch(Exception e){
		   Report.updateTestLog("Lead Verification Failed", "Fail");
	   }
	   
	   
   }
   
   void checkDefaultFilterSelection(){
	    if(browser.isSelectedByXpath(pageProperties.getProperty("GetAPricePage.DirectDebit")) &&
			   browser.isSelectedByXpath(pageProperties.getProperty("GetAPricePage.ShowAll")) &&
			   		browser.isSelectedByXpath(pageProperties.getProperty("GetAPricePage.ShowAllContract")) &&
			   			browser.isSelectedByXpath(pageProperties.getProperty("GetAPricePage.Monthly"))){
		   	Report.updateTestLog("The default filter selections are DirectDebit, ShowAll, ShowAllContract,Monthly ", "Pass");
	   }
	   else{
			Report.updateTestLog("The default filter selections mismatch", "Fail");
	   }
   }
   
   void payAsYouGoCheckDefaultFilterSelection(){
	 
	   if(browser.isSelectedByXpath(pageProperties.getProperty("GetAPricePage.ShowAll")) &&
			   browser.isSelectedByXpath(pageProperties.getProperty("GetAPricePage.ShowAllContract"))){
			Report.updateTestLog("The default filter selections are ShowAll, ShowAllContract", "Pass");
	   }
	   else{
		   Report.updateTestLog("The default filter selections are mismatched", "Fail");
	   }
   }
   
   void verifySEDefaultFilterSelection(){
	  /*if(browser.isSelectedByXpath(pageProperties.getProperty("GetAPricePage."+tariff)) &&
			  browser.isSelectedByXpath(pageProperties.getProperty("GetAPricePage."+contract)) &&
  					browser.isSelectedByXpath(pageProperties.getProperty("GetAPricePage."+month))){
		  					Report.updateTestLog("The default filter selections are "+tariff+", "+contract+", "+month, "Pass");
	  			}
	  else{
		  		Report.updateTestLog("The default filter selections are  "+tariff+", "+contract+", "+month, "Fail");
	  	}*/
	   if(browser.isSelectedByXpath(pageProperties.getProperty("GetAPricePage.ShowAll")) &&
				  browser.isSelectedByXpath(pageProperties.getProperty("GetAPricePage.ShowAllContract")) &&
	  					browser.isSelectedByXpath(pageProperties.getProperty("GetAPricePage.Monthly"))){
			  					Report.updateTestLog("The default filter selections are ShowAll,ShowAllContract, Monthly", "Pass");
		  			}
	   else{
			  		Report.updateTestLog("The default filter selections are Mismatched", "Fail");
	 }
   }
   
   
   public void verifyFilterPresent(String PaymentType){
	   if(ApplicationConfig.BRAND.equalsIgnoreCase("BG")){
		   if(!PaymentType.contains("Pay As You Go")){
			   if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.DirectDebit")) && browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.ShowAll")) && browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.ShowAllContract")) && browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.Monthly"))){
				   Report.updateTestLog("All 4 filters are present", "Pass");
				   checkDefaultFilterSelection();
			   }
			   else{
				   Report.updateTestLog("Filter section mismatch", "Fail");
			   }
		   }
		   else{
			   if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.ShowAll")) && browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.ShowAllContract"))){
				   if(!browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.DirectDebit")) && !browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.Monthly"))){
					   Report.updateTestLog("tariff and contract filters are present", "Pass");
					   payAsYouGoCheckDefaultFilterSelection();
				   }
				   else{
					   Report.updateTestLog("more than 2 filters present", "Fail");
				   }
			   }
		   }
	   }
	   else{
		   if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.ShowAll")) && browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.ShowAllContract")) && browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.Monthly"))){
			   if(!browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.DirectDebit"))){
				   Report.updateTestLog("tariff, contract and display filters are present", "Pass");
				   verifySEDefaultFilterSelection();
			   }
			   else{
				   Report.updateTestLog("Filter section mismatch.", "Fail");
			   }
		   }
	   }
   }
   
   
   public void verifyCaveat(String Fuel,String PaymentType){
	   
	   if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.StaticCaveat"))){
		   Report.updateTestLog("Caveat Present: Forecasted cost includes any discounts, when choosing Direct Debit 6% discount compared to Cash/cheque is included in the unit rates.", "Pass");
	   }
	   else{
		   Report.updateTestLog("Static caveat: Forecasted cost not present", "Fail");
	   }
	   if(Fuel.equalsIgnoreCase("dual")){
		   if(PaymentType.contains("Pay As You Go")){
			   Report.updateTestLog("Dual Fuel Caveat not Present","Fail");
		   }
		   else{
			   if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.DynamicCaveat"))){
				   Report.updateTestLog("Dual Fuel Caveat Present :£15 dual fuel discount ", "Pass");
			   }
			   else{
				   Report.updateTestLog("Dual Fuel Caveat not Present","Fail"); 
			   }
		   }
	   
	   }
	   if(Fuel.equalsIgnoreCase("dual")){
		   if(PaymentType.equalsIgnoreCase("Pay As You Go")){
			   if(!browser.isTextPresent("£15 dual fuel discount")){
				   Report.updateTestLog("Dual Fuel Caveat not Present","Fail");   
			   }
		   	}
		   else{
			   if(browser.isTextPresent("dual fuel discount")){
				   Report.updateTestLog("Dual Fuel Caveat Present :£15 dual fuel discount ", "Pass");
			   }
			   else{
				   Report.updateTestLog("Dual Fuel Caveat not Present","Fail"); 
			   }
		   }
			   
	   }
   }
   
   public void verifyRadioButtonsPresent(){
	   
   }
   
   public void verifyRadioButtonsPresent(String PaymentType){
	   if(ApplicationConfig.BRAND.equalsIgnoreCase("bg")){
		   if(!PaymentType.contains("Pay As You Go")){
			   if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.DirectDebit")) && 
					   browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.ReceiptBill"))){
				   Report.updateTestLog("Direct Debit and Receipt Bill Radio buttons present in Payment Filter", "Pass");
			   }
			   else{
				   Report.updateTestLog("Radio buttons mismatch under payment filter section", "Fail");
			   }
		   }
		}
	   if((ApplicationConfig.BRAND.equalsIgnoreCase("bg") && (!PaymentType.contains("Pay As You Go"))) 
			   ||ApplicationConfig.BRAND.equalsIgnoreCase("fusion")){
		   if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.Monthly")) && 
				   browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.Quartely")) &&
				   		browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.Annually"))){
			   Report.updateTestLog("Monthly, Quartely and Annually Radio buttons are present in display figure section", "Pass");
		   }
		   else{
			   Report.updateTestLog("Radio buttons mismatch under display figure filter section", "Fail");
		   }
	   }
	   
	   if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.ShowAll")) && 
			   browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.Fixed")) &&
			   		browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.Variable"))){
		   Report.updateTestLog("Show All, Fixed and Variable Radio buttons are present in Tariff filter section", "Pass");
	   }
	   else{
		   Report.updateTestLog("Radio buttons mismatch under Tariff filter section", "Fail");
	   }
	   
	   if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.ShowAllContract")) && 
			   browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.Upto16Months")) &&
			   			browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAPricePage.None"))){
		   
		   Report.updateTestLog("Show All Contract, Upto 16 months Contract and None Radio buttons are present in Contract filter section", "Pass");
		  // Report.updateTestLog("Show All Contract, Between 1 and 2 Year, Between 2 and 3 Year and None Radio buttons are present in Contract filter section", "Pass");
	   }
	   else{
		   Report.updateTestLog("Radio buttons mismatch under Contract filter section", "Fail");
	   }
	
   }
   
   
   public void verifyDecimalPoints(String temp, String value){
	   if(temp.contains(".")){
		   temp = temp.substring(temp.indexOf(".")+1);
		   if(temp.length() < 2){
			   Report.updateTestLog(value+" is not correct to 2 decimal places", "Fail");
		   }
	   }
	   else{
		   Report.updateTestLog(value+" is not correct to 2 decimal places", "Fail");
	   }
   }
   
   public String chooseOverlay(String temp){
	   if(temp.contains("Clear")){
		   return "SwitchClear";
	   }
	   else if(temp.contains("Check")){
		   return "SwitchCheck";
	   }
	   else if(temp.contains("Online")){
		   return "SwitchOnline";
	   }
	   else if(temp.contains("Pledge")){
		   return "SwitchPledge";
	   }   
	   return temp;
   }
   
   public void logout(){
	   verifyAndClickWithXpath(pageProperties.getProperty("GetAPricePage.Logout"), "Log out Button Clicked");
   }
   
   
   public void gasloop(GetAPrice getaPrice) {
                
           Report.updateTestLog("Fuel Type Prepopulate Screen shot  :", "WARN");
           
           
            browser.click(pageProperties.getProperty("GetAPricePage." + getaPrice.getfuelType()));        
            browser.click(pageProperties.getProperty("GetAPricePage.FuelTypeNext"));
                  	
       		browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasBrand"), getaPrice.getgasSupplier());  
       		Report.updateTestLog("Current Supplier Selected is  : " + getaPrice.getgasSupplier(), "DONE");          	          
            browser.wait(3000);     
            browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasPayment"), getaPrice.getgasPayment());
            List<String> tariff;       
            tariff = browser.getFromDropBox("id", pageProperties.getProperty("GetAPricePage.GasTariff"));
            System.out.println(tariff);
            Report.updateTestLog(" Gas Supplier Section  Values  - " + tariff   , "DONE");
            for (int x = 1; x < tariff.size(); x++) {
            
            browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasTariff"), tariff.get(x));  
       		Report.updateTestLog("Current Supplier Selected is  : " + tariff.get(x), "DONE");            
       		  
       		Report.updateTestLog("Current Supplier Selected is  : " + getaPrice.getgasPayment(), "DONE");
            
            browser.clearValue(pageProperties.getProperty("GetAPricePage.GasSpendValue"));
            browser.input(pageProperties.getProperty("GetAPricePage.GasSpendValue"), "500");
            browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasSpendType"), getaPrice.getgasSpendType());
            browser.click(pageProperties.getProperty("GetAPricePage.GasNext"));
            Report.updateTestLog("Personal Details Section screen Shot", "WARN");
        	
        	if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.PostCode"))) {
        		browser.clearValue(pageProperties.getProperty("GetAPricePage.PostCode"));
                browser.input(pageProperties.getProperty("GetAPricePage.PostCode"), "rm38xb");
                Report.updateTestLog("PostCode Entered " , "PASS");
            } 
            if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.Title"))) {
                verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.Title"), "Title", "Mr");
                verifyAndInputById(pageProperties.getProperty("GetAPricePage.FirstName"), "First Name", "Digital");
                verifyAndInputById(pageProperties.getProperty("GetAPricePage.LastName"), "Last Name", "Automation");
                verifyAndInputById(pageProperties.getProperty("GetAPricePage.Email"), "Email ID", "Digital.Automation@centrica.com");
                verifyAndInputById(pageProperties.getProperty("GetAPricePage.Phone"), "Phone", "0123456789");
                verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.PhoneType"), "Phone Type", "Home");
                if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.YourDetailsNext"))) {
                    browser.click(pageProperties.getProperty("GetAPricePage.YourDetailsNext"));
                    browser.wait(getWaitTime());
                    Report.updateTestLog(" Personal details entered", "PASS");
                } 
            }
            
            browser.click(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"));
            Report.updateTestLog("Fuel Type Prepopulate Screen shot  :", "WARN");
            
            if (browser.isElementVisible("recalculate")){
            	
            	Report.updateTestLog("Quote Details  for tariff.get(x) :", "PASS");
            }
            else{
            	Report.updateTestLog("Quote Details  :", "FAIL");
            }
            
            
            browser.open("https://10.224.70.76/GetAQuote/");
            
            browser.click(pageProperties.getProperty("GetAPricePage." + getaPrice.getfuelType()));        
            browser.click(pageProperties.getProperty("GetAPricePage.FuelTypeNext"));
       		browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasBrand"), getaPrice.getgasSupplier());  
       		Report.updateTestLog("Current Supplier Selected is  : " + getaPrice.getgasSupplier(), "DONE");         
       		browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasPayment"), getaPrice.getgasPayment());
            browser.wait(3000);  
            }   
            
          
   }
   
   
   public void elecloop(GetAPrice getaPrice) {
       
       Report.updateTestLog("Fuel Type Prepopulate Screen shot  :", "WARN");
       
       
        browser.click(pageProperties.getProperty("GetAPricePage." + getaPrice.getfuelType()));        
        browser.click(pageProperties.getProperty("GetAPricePage.FuelTypeNext"));
              	
   		browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.ElectricityBrand"), getaPrice.getelecSupplier());  
   		Report.updateTestLog("Current Supplier Selected is  : " + getaPrice.getelecSupplier(), "DONE");          	          
        browser.wait(3000);   
        
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.ElectricityPayment"), getaPrice.getelecPayment());
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.Economy"), getaPrice.getEconomy());
        List<String> tariff;       
        tariff = browser.getFromDropBox("id", pageProperties.getProperty("GetAPricePage.ElectricityTariff"));
        System.out.println(tariff);
        Report.updateTestLog(" Electricity Supplier Section  Values  - " + tariff   , "DONE");
        for (int x = 1; x < tariff.size(); x++) {
        
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.ElectricityTariff"), tariff.get(x));  
   		Report.updateTestLog("Current Supplier Selected is  : " + tariff.get(x), "DONE");            
   		  
   		Report.updateTestLog("Current Supplier Selected is  : " + getaPrice.getelecPayment(), "DONE");
        
        browser.clearValue(pageProperties.getProperty("GetAPricePage.ElectricitySpendValue"));
        browser.input(pageProperties.getProperty("GetAPricePage.ElectricitySpendValue"), "500");
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.ElectricitySpendType"), getaPrice.getelecSpendType());
        browser.click(pageProperties.getProperty("GetAPricePage.GasNext"));
        Report.updateTestLog("Personal Details Section screen Shot", "WARN");
    	
    	if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.PostCode"))) {
    		browser.clearValue(pageProperties.getProperty("GetAPricePage.PostCode"));
            browser.input(pageProperties.getProperty("GetAPricePage.PostCode"), "rm38xb");
            Report.updateTestLog("PostCode Entered " , "PASS");
        } 
        if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.Title"))) {
            verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.Title"), "Title", "Mr");
            verifyAndInputById(pageProperties.getProperty("GetAPricePage.FirstName"), "First Name", "Digital");
            verifyAndInputById(pageProperties.getProperty("GetAPricePage.LastName"), "Last Name", "Automation");
            verifyAndInputById(pageProperties.getProperty("GetAPricePage.Email"), "Email ID", "Digital.Automation@centrica.com");
            verifyAndInputById(pageProperties.getProperty("GetAPricePage.Phone"), "Phone", "0123456789");
            verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.PhoneType"), "Phone Type", "Home");
            if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.YourDetailsNext"))) {
                browser.click(pageProperties.getProperty("GetAPricePage.YourDetailsNext"));
                browser.wait(getWaitTime());
                Report.updateTestLog(" Personal details entered", "PASS");
            } 
        }
        
        browser.click(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"));
        Report.updateTestLog("Fuel Type Prepopulate Screen shot  :", "WARN");
        
        if(ApplicationConfig.BRAND.equalsIgnoreCase("bg")){
        
        if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.ReCalculate"))){
        	
        	Report.updateTestLog("Quote Details  :", "PASS");
        }
        else{
        	Report.updateTestLog("Quote Details  :", "FAIL");
        }
        }
        else if(ApplicationConfig.BRAND.equalsIgnoreCase("Fusion")){
        	
        	 if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.SwitchNowSE1"))){
            	
            	Report.updateTestLog("Quote Details  :", "PASS");
            }
            else{
            	Report.updateTestLog("Quote Details  :", "FAIL");
            }	
        	
        }
        
        browser.open("https://10.224.70.76/GetAQuote/");
        
        browser.click(pageProperties.getProperty("GetAPricePage." + getaPrice.getfuelType()));        
        browser.click(pageProperties.getProperty("GetAPricePage.FuelTypeNext"));
   		browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.ElectricityBrand"), getaPrice.getelecSupplier());  
   		Report.updateTestLog("Current Supplier Selected is  : " + getaPrice.getelecSupplier(), "DONE");         
   		browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.ElectricityPayment"), getaPrice.getelecPayment());
        browser.wait(3000);  
        }   
        
      
}

   
   public void gasoldloop(GetAPrice getaPrice) {
       
       Report.updateTestLog("Fuel Type Prepopulate Screen shot  :", "WARN");
       
       if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.PostCode"))) {
   		browser.clearValue(pageProperties.getProperty("GetAPricePage.PostCode"));
        browser.input(pageProperties.getProperty("GetAPricePage.PostCode"), "rm38xb");
        verifyAndClick(pageProperties.getProperty("GetAPricePage.PostCodeNext"), "Next Button");
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
           Report.updateTestLog("PostCode Entered " , "PASS");
       } 
       
        browser.click(pageProperties.getProperty("GetAPricePage." + getaPrice.getfuelType()));        
        browser.click(pageProperties.getProperty("GetAPricePage.FuelTypeNext"));
        
        browser.clearValue(pageProperties.getProperty("GetAPricePage.GasSpendValue"));
        browser.input(pageProperties.getProperty("GetAPricePage.GasSpendValue"), "500");
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasSpendType"), getaPrice.getgasSpendType());
        
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasMeter"), getaPrice.getgasMeter());
   		browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasBrand"), getaPrice.getgasSupplier());  
   		Report.updateTestLog("Current Supplier Selected is  : " + getaPrice.getgasSupplier(), "DONE");          	          
        browser.wait(3000);     
        
        List<String> tariff;       
        tariff = browser.getFromDropBox("id", pageProperties.getProperty("GetAPricePage.GasTariff"));
        System.out.println(tariff);
        Report.updateTestLog(" Gas Supplier Section  Values  - " + tariff   , "DONE");
        for (int x = 1; x < tariff.size(); x++) {
        
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasTariff"), tariff.get(x));  
   		Report.updateTestLog("Current Supplier Selected is  : " + tariff.get(x), "DONE");    
   		
   		browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasPayment"), getaPrice.getgasPayment()); 
   		browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasPreferredPaymentType"), getaPrice.getGasPreferredPayment());
   		Report.updateTestLog("Current Supplier Selected is  : " + getaPrice.getgasPayment(), "DONE");
        
       
        browser.click(pageProperties.getProperty("GetAPricePage.GasNext"));
        Report.updateTestLog("Personal Details Section screen Shot", "WARN");
    	
    	
        if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.Title"))) {
            verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.Title"), "Title", "Mr");
            verifyAndInputById(pageProperties.getProperty("GetAPricePage.FirstName"), "First Name", "Digital");
            verifyAndInputById(pageProperties.getProperty("GetAPricePage.LastName"), "Last Name", "Automation");
            verifyAndInputById(pageProperties.getProperty("GetAPricePage.Email"), "Email ID", "Digital.Automation@centrica.com");
            verifyAndInputById(pageProperties.getProperty("GetAPricePage.Phone"), "Phone", "0123456789");
            verifyAndSelectDropDownBox(pageProperties.getProperty("GetAPricePage.PhoneType"), "Phone Type", "Home");
            if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.YourDetailsNext"))) {
                browser.click(pageProperties.getProperty("GetAPricePage.YourDetailsNext"));
                browser.wait(getWaitTime());
                Report.updateTestLog(" Personal details entered", "PASS");
            } 
        }
        
        browser.click(pageProperties.getProperty("GetAPricePage.GetAQuoteButton"));
        Report.updateTestLog("Fuel Type Prepopulate Screen shot  :", "WARN");
        
        if (browser.isElementVisible("recalculate")){        	
        	Report.updateTestLog("Quote Details  :", "PASS");
        }
        else{
        	Report.updateTestLog("Quote Details  :", "FAIL");
        }
        
        
        
        browser.open("https://10.224.70.84/GetAQuote/");
        
        if (browser.isElementVisible(pageProperties.getProperty("GetAPricePage.PostCode"))) {
       		browser.clearValue(pageProperties.getProperty("GetAPricePage.PostCode"));
            browser.input(pageProperties.getProperty("GetAPricePage.PostCode"), "rm38xb");
            verifyAndClick(pageProperties.getProperty("GetAPricePage.PostCodeNext"), "Next Button");
            try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
               Report.updateTestLog("PostCode Entered " , "PASS");
           } 
        
        browser.click(pageProperties.getProperty("GetAPricePage." + getaPrice.getfuelType()));        
        browser.click(pageProperties.getProperty("GetAPricePage.FuelTypeNext"));
        browser.clearValue(pageProperties.getProperty("GetAPricePage.GasSpendValue"));
        browser.input(pageProperties.getProperty("GetAPricePage.GasSpendValue"), "500");
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasSpendType"), getaPrice.getgasSpendType());
        
        browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasMeter"), getaPrice.getgasMeter());
   		browser.selectfromDropBox("id", pageProperties.getProperty("GetAPricePage.GasBrand"), getaPrice.getgasSupplier());  
   		Report.updateTestLog("Current Supplier Selected is  : " + getaPrice.getgasSupplier(), "DONE");         
   		  
        }                   
}
   
}
