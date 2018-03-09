package bg.framework.app.functional.common;

import java.util.Properties;


import bg.framework.app.functional.util.PropertyLoader;

public class ApplicationConfig {

    private final static String CONFIG_FILE_NAME = "resources/common/common.properties";
    private static Properties pageProperties = null;


    static {
        try {
            pageProperties = new PropertyLoader(CONFIG_FILE_NAME).load();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getConfigValue(String configKey) {
        return pageProperties.getProperty(configKey);
    }

    public final static String BROWSER = getConfigValue("common.browser");
    public final static String BRAND = getConfigValue("common.brand");
    public static final String SERVER_IP = getConfigValue("common.newblue-server");
    public static final String APP_BG_URL = getConfigValue("common.newblue-url");
    public static final String APP_BGB_URL = getConfigValue("common.bgb-url");
    public static final String APP_FUSION_URL = getConfigValue("common.fusion-url");
    public static final String APP_SERVICES_URL=getConfigValue("common.services-url");
    public static final String THIRD_PARTY_EXCESS = getConfigValue("sales.THIRDPARTYEXCESS");
    
    public static final String LOGIN_URL = APP_BG_URL
            + "/Login/Login-Verify/?loginarea=toploginbutton";
    public static final String NEW_LOGIN_URL = APP_BG_URL + "/content/britishgasnewstack/Login.html";
    public static final String NEW_MPD = APP_BG_URL
            + "/content/britishgasnewstack/managepersonaldetails.html";
    public static final String NEW_MPD2 = APP_BG_URL + "/Self-Service/Personal-Details-Entry/";
    public static final String NEW_SMR = APP_BG_URL
            + "/content/britishgasnewstack/SubmitMeterRead/AccountDetails.html";
    public static final String NEW_MP = APP_BG_URL
            + "/content/britishgasnewstack/Payment/AccountDetails.html";
    public static final String NEW_LOGIN = getConfigValue("common.new.stack.login");
    public static final String DATABASE_URL = getConfigValue("database.url");
    public static final String DATABASE_DRIVER = getConfigValue("database.driver");
    public static final String DATABASE_USERNAME = getConfigValue("database.username");
    public static final String DATABASE_PASSWORD = getConfigValue("database.password");
    public static final String STUB_URL = getConfigValue("common.stub-url");
    public static final String ENERGYSHOP_URL = APP_BG_URL
            + "/EnergyShop/EnergySales/orderType/StandardEnergy/energyType/Dual";
    public static final String NEW_BGB_URL = APP_BGB_URL
            + "/apps/britishgas/components/corporate/registration/registrationLinkValidation/GET.servlet?";
    public static final String NEW_BGB_INVALIDURL = APP_BGB_URL
            + "/apps/britishgas/components/corporate/registration/registrationLinkValidation/GET.servlet?";
    public static final String BGB_MS_LOGIN = APP_BGB_URL
            + "/content/britishgas/corporate/corporateLogin.html";
    public static final String BGBGAQSS_URL = APP_BGB_URL;
    public static final String SIEBEL_ENVIRONMENT = getConfigValue("siebel.environment");
    public static final String ContactUs_URL = "http://10.224.70.95/content/britishgas/youraccount/contactus/contactuspersonaldetails.html";
    //public static final String ContactUs_URL = "http://10.224.70.96/content/sainsbury/youraccount/contactus/contactuspersonaldetails.html";
    public static final String GAP_URL = APP_BG_URL;
    public static final String LAND_LORD=APP_SERVICES_URL+"/get-a-landlord-quote/";
    

    public static final String PreProd_BGURL = getConfigValue("common.preprodbg-url");
    public static final String PreProd_FusionURL = getConfigValue("common.preprodFusion-url");
    
    public static final String Application_MakeAPayment = getConfigValue("Application.MakeAPayment");
    public static final String SAPCRMUrl = getSAPCRMurl(getConfigValue("SAPCRM.Environment"));
    public static final String SAPNetweaverUserID = getConfigValue("SAPNetweaverUserID");
    public static final String SAPNetweaverPWD = getConfigValue("SAPNetweaverPWD");
    
    public static final String MLUDBUrl = getConfigValue("MLUDB.Url");
    public static final String MLUDBUsername = getConfigValue("MLUDB.Username");
    public static final String MLUDBPassword = getConfigValue("MLUDB.Password");
    
    
    public static String getSAPCRMurl(String JSD){
    	String SAPCRMurl = "";
    	if(JSD.equalsIgnoreCase("JSD ETE05")){
    		SAPCRMurl = "http://tcrmlqcqa.uk.centricaplc.com:8030/sap(bD1lbiZjPTEwMCZkPW1pbg==)/bc/bsp/sap/crm_ui_start/default.htm";
    	}
    	if(JSD.equalsIgnoreCase("JSD 99")){
    		SAPCRMurl = "http://crmqalq7.uk.centricaplc.com:8000/sap/bc/bsp/sap/crm_ui_start/default.htm";
    	}
    	if(JSD.equalsIgnoreCase("JSD ETE18")){
    		SAPCRMurl = "http://tcrmlqpqa.uk.centricaplc.com:8030/sap(bD1lbiZjPTEwMCZkPW1pbg==)/bc/bsp/sap/crm_ui_start/default.htm";
    	}
    	if(JSD.equalsIgnoreCase("JSD ETE03")){
    		SAPCRMurl = "http://tcrmlqaqa.uk.centricaplc.com:8030/sap(bD1lbiZjPTEwMCZkPW1pbg==)/bc/bsp/sap/crm_ui_start/default.htm";
    	}
    	if(JSD.equalsIgnoreCase("JSD ETE02")){
    		SAPCRMurl = "http://tcrmlqmqa.uk.centricaplc.com:8030/sap(bD1lbiZjPTEwMCZkPW1pbg==)/bc/bsp/sap/crm_ui_start/default.htm";
    	}
    	if(JSD.equalsIgnoreCase("JSD ETE17")){
    		SAPCRMurl = "http://tcrmlqnqa.uk.centricaplc.com:8030/sap(bD1lbiZjPTEwMCZkPW1pbg==)/bc/bsp/sap/crm_ui_start/default.htm";
    	}
    	if(JSD.equalsIgnoreCase("JSD ETE07")){
    		SAPCRMurl = "http://tcrmlqeqa.uk.centricaplc.com:8030/sap(bD1lbiZjPTEwMCZkPW1pbg==)/bc/bsp/sap/crm_ui_start/default.htm";
    	}
    	if(JSD.equalsIgnoreCase("JSD PREPROD")){
    		SAPCRMurl = "http://scrmls2ap01.uk.centricaplc.com:8030/sap/bc/bsp/sap/crm_ui_start/default.htm";
    	}
    	if(JSD.equalsIgnoreCase("JSD ETE16")){
    		SAPCRMurl = "http://tcrmlqmqa.uk.centricaplc.com:8030/sap/bc/bsp/sap/crm_ui_start/default.htm";
    	}
    	return SAPCRMurl;
    }
/* Added for BGMO Start */
public static final String FireFox_BinaryPath = getConfigValue("Application.FireFox_BinaryPath");
/* Added for BGMO End */
}
