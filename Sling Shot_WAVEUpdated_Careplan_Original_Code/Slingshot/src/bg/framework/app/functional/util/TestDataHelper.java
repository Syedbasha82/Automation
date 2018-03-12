package bg.framework.app.functional.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.Account;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.ContactUsQueue;
import bg.framework.app.functional.entities.CrmUserProfile;
import bg.framework.app.functional.entities.Ddcps;
import bg.framework.app.functional.entities.DirectDebit;
import bg.framework.app.functional.entities.GetAPrice;
import bg.framework.app.functional.entities.GetAPricePageProfile;
import bg.framework.app.functional.entities.GetAQuoteDetails;
import bg.framework.app.functional.entities.HomeMove;
import bg.framework.app.functional.entities.InsuranceQuote;
import bg.framework.app.functional.entities.LandLord;
import bg.framework.app.functional.entities.MakeAPaymentProfile;
import bg.framework.app.functional.entities.PriceFinder;
import bg.framework.app.functional.entities.RegProfile;
import bg.framework.app.functional.entities.RegistrationProfile;
import bg.framework.app.functional.entities.SMRAccountDetails;
import bg.framework.app.functional.entities.SearchInvoiceProfile;
import bg.framework.app.functional.entities.TestData;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.entities.selfservedata;
import bg.framework.app.functional.entities.Slinshot.CarePlanProfile;

import com.thoughtworks.xstream.XStream;

//import bg.framework.app.functional.entities.BGB.RegistrationProfile;

public class TestDataHelper {

    private static final String userProfileXMLFile = "resources/TestData/bgr/UserProfiles.xml";
    private static final String regProfileXMLFile = "resources/TestData/bgb/Registration.xml";
    private static final String smrXMLFile = "resources/TestData/bgr/SMRAccounts.xml";
    private static final String PriceFinderTestDataXMLFile = "resources/TestData/config/PriceFinder2.xml";
    private static final String GetAQuoteDetailsXMLFile = "resources/TestData/bgb/GetAQuoteDetails.xml";
    private static final String bgbRegXMLFile = "resources/TestData/bgb/Registration.xml";
    private Map<String, RegistrationProfile> allRegistration = new HashMap<String, RegistrationProfile>();
    private static final String acquisitiondataXMLFile = "resources/TestData/bgr/Acquisition.xml";
    private static final String HomeMovedataXMLFile = "resources/TestData/bgr/HomeMove.xml";
    private static final String LoginXMLFile = "resources/TestData/bgr/CustomerInformation.xml";
    private static final String GetaPriceXMLFile = "resources/TestData/bgr/GetAPrice.xml";
    private static final String selfServeRegistrationXML = "resources/TestData/bgr/UserProfiles.xml";
    private static final String BGContactUsQueueXMLFile = "resources/TestData/config/BGContactUsQueue.xml";
    private static final String FusionContactUsQueueXMLFile = "resources/TestData/config/FusionContactUsQueue.xml";
    private static final String searchInvoiceXMLFile = "resources/TestData/bgb/SearchInvoice.xml";
    private static final String InsuranceQuoteXMLFile = "resources/TestData/bgr/InsuranceQuote.xml";
    private static final String landLordXMLFile="resources/TestData/services/LandLord.xml";
    private static final String makeAPaymentXMLFile = "resources/TestData/bgr/MakeAPayment.xml";
    private static final String CarePlanProfileXMLFile = "resources/TestData/bgb/CarePlanProfile.xml";
    private static final String ddcpsXMLFile="resources/TestData/bgr/Ddcps.xml";
    private static final String BAAXMLFile = "resources/TestData/bgr/BAA.xml";
    private static final String crmUserProfile = "resources/TestData/bgb/CrmUserProfile.xml";
    private static final String DirectDebit = "resources/TestData/bgb/DirectDebit.xml";
    private static final String submitMeterRead = "resources/TestData/bgb/SubmitMeterRead.xml";
    
    private Map<String, Ddcps> allDdcpsProfiles = new HashMap<String, Ddcps>(); 
    private static final String getAPricePageXMLFile = "resources/TestData/bgr/GetAPricePage.xml";
    private Map<String, UserProfile> allUserProfiles = new HashMap<String, UserProfile>();
    private Map<String, UserProfile> allUserProfile = new HashMap<String, UserProfile>();
   // private Map<String, UserProfile> allCarePlanprofile = new HashMap<String, CarePlanProfile>();
    //private Map<String, CrmUserProfile> allcrmUserProfile = new HashMap<String, CrmUserProfile>();
    
    private Map<String, RegProfile> allRegProfiles = new HashMap<String, RegProfile>();
    
    private Map<String, Acquisition> allAcqusitionProfiles = new HashMap<String, Acquisition>();
    private Map<String, HomeMove> allHomeMoveProfiles = new HashMap<String, HomeMove>();
    private Map<String, SMRAccountDetails> allSMRAccounts = new HashMap<String, SMRAccountDetails>();
    private Map<String, TestData> allTestData = new HashMap<String, TestData>();
    private Map<String, PriceFinder> allPFTestData = new HashMap<String, PriceFinder>();
    private Map<String, GetAPrice> allGAPTestData = new HashMap<String, GetAPrice>();
    private Map<String, selfservedata> allSelfserveTestData = new HashMap<String, selfservedata>();
    private Map<String, SearchInvoiceProfile> allSearchInvoices = new HashMap<String, SearchInvoiceProfile>();
    private Map<String, GetAQuoteDetails> allGetAQuoteDetails = new HashMap<String, GetAQuoteDetails>();
    private Map<String, ContactUsQueue> allContactUsQueue = new HashMap<String, ContactUsQueue>();
    private Map<String, InsuranceQuote> allInsuranceQuoteDetails = new HashMap<String, InsuranceQuote>();
    private Map<String, LandLord> allLandLord=new HashMap<String, LandLord>();
    private Map<String, MakeAPaymentProfile> allMakeAPaymentProfiles = new HashMap<String, MakeAPaymentProfile>();
    private Map<String, GetAPricePageProfile> allGetAPricePageProfiles = new HashMap<String, GetAPricePageProfile>();
    private Map<String, CrmUserProfile> allcrmUserProfiles = new HashMap<String, CrmUserProfile>();
    private Map<String, DirectDebit> allDirectDebitProfile = new HashMap<String, DirectDebit>();
    private Map<String, CarePlanProfile> allCarePlanProfileProfile = new HashMap<String, CarePlanProfile>();
    
    private XStream xStream;

    public TestDataHelper() {
        xStream = new XStream();
        xStream.processAnnotations(TestData.class);
        xStream.processAnnotations(UserProfile.class);
        xStream.processAnnotations(CrmUserProfile.class);
        xStream.processAnnotations(PriceFinder.class);
        xStream.processAnnotations(RegistrationProfile.class);
        xStream.processAnnotations(Acquisition.class);
        xStream.processAnnotations(HomeMove.class);
        xStream.processAnnotations(GetAQuoteDetails.class);
        xStream.processAnnotations(GetAPrice.class);
        xStream.processAnnotations(UserProfile.class);
        xStream.processAnnotations(ContactUsQueue.class);
        xStream.processAnnotations(InsuranceQuote.class);
        xStream.processAnnotations(LandLord.class);
        xStream.processAnnotations(MakeAPaymentProfile.class);
        xStream.processAnnotations(Ddcps.class);
        xStream.processAnnotations(GetAPricePageProfile.class);
        xStream.processAnnotations(DirectDebit.class);
        xStream.processAnnotations(SMRAccountDetails.class);
        xStream.processAnnotations(CarePlanProfile.class);
        
    }

    @SuppressWarnings(value = "unchecked")
    public Map<String, UserProfile> getAllUserProfiles(boolean reloadRequired) {
        if (allUserProfiles.isEmpty() || reloadRequired) {
            allUserProfiles = (Map<String, UserProfile>) xStream
                    .fromXML(readTestDataXml(userProfileXMLFile));
        }
        return allUserProfile;
    }
    
 ///////////////////////////////////////////////////////////////////////CarePlanProfile///////////////////////////////////////////////////////////////////////////////
    @SuppressWarnings(value = "unchecked")
    public Map<String, CarePlanProfile> getAllCarePlanProfile(boolean reloadRequired) {
        if (allCarePlanProfileProfile.isEmpty() || reloadRequired) {
        	allCarePlanProfileProfile = (Map<String, CarePlanProfile>) xStream.fromXML(readTestDataXml(CarePlanProfileXMLFile));
        }
        return allCarePlanProfileProfile;
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
	@SuppressWarnings(value = "unchecked")
    public Map<String, GetAPricePageProfile> getAllGetAPricePageProfiles(boolean reloadRequired) {
        if (allGetAPricePageProfiles.isEmpty() || reloadRequired) {
            allGetAPricePageProfiles = (Map<String, GetAPricePageProfile>) xStream
                    .fromXML(readTestDataXml(getAPricePageXMLFile));
        }
        return allGetAPricePageProfiles;
    }
	
	
    
	@SuppressWarnings(value = "unchecked")
    	public Map<String, MakeAPaymentProfile> getAllMakeAPaymentProfiles(boolean reloadRequired) {
        if (allMakeAPaymentProfiles.isEmpty() || reloadRequired) {
        	allMakeAPaymentProfiles = (Map<String, MakeAPaymentProfile>) xStream
                    .fromXML(readTestDataXml(makeAPaymentXMLFile));
        }
        return allMakeAPaymentProfiles;
    }
    @SuppressWarnings(value = "unchecked")
    public Map<String, PriceFinder> getAllPFdata(boolean reloadRequired) {
        if (allPFTestData.isEmpty() || reloadRequired) {
            allPFTestData = (Map<String, PriceFinder>) xStream
                    .fromXML(readTestDataXml(PriceFinderTestDataXMLFile));
        }
        return allPFTestData;
    }

    @SuppressWarnings(value = "unchecked")
    public Map<String, SMRAccountDetails> getAllSMRAccountDetails(boolean reloadRequired) {
        if (allSMRAccounts.isEmpty() || reloadRequired) {
            allSMRAccounts = (Map<String, SMRAccountDetails>) xStream
                    .fromXML(readTestDataXml(submitMeterRead));
        }
        return allSMRAccounts;
    }

    @SuppressWarnings(value = "unchecked")
    public Map<String, GetAQuoteDetails> getallGetAQuoteDetails(boolean reloadRequired) {
        if (allGetAQuoteDetails.isEmpty() || reloadRequired) {
            allGetAQuoteDetails = (Map<String, GetAQuoteDetails>) xStream
                    .fromXML(readTestDataXml(GetAQuoteDetailsXMLFile));
        }
        return allGetAQuoteDetails;
    }

    @SuppressWarnings(value = "unchecked")
    public Map<String, InsuranceQuote> getAllInsuranceQuoteDetails(boolean reloadRequired) {
        if (allInsuranceQuoteDetails.isEmpty() || reloadRequired) {
            allInsuranceQuoteDetails = (Map<String, InsuranceQuote>) xStream
                    .fromXML(readTestDataXml(InsuranceQuoteXMLFile));
        }
        return allInsuranceQuoteDetails;
    }

    public Map<String, ContactUsQueue> getAllContactUsQueue(boolean reloadRequired) {
        if (allContactUsQueue.isEmpty() || reloadRequired) {
            if (ApplicationConfig.BRAND.equalsIgnoreCase("bg")) {
                allContactUsQueue = (Map<String, ContactUsQueue>) xStream
                        .fromXML(readTestDataXml(BGContactUsQueueXMLFile));
            } else {
                allContactUsQueue = (Map<String, ContactUsQueue>) xStream
                        .fromXML(readTestDataXml(FusionContactUsQueueXMLFile));
            }
        }
        return allContactUsQueue;
    }

    // Banu's map file
    @SuppressWarnings(value = "unchecked")
    public Map<String, selfservedata> getAllSelfserveData(boolean reloadRequired) {

        if (allSelfserveTestData.isEmpty() || reloadRequired) {
            allSelfserveTestData = (Map<String, selfservedata>) xStream
                    .fromXML(readTestDataXml(LoginXMLFile));
        }
        return allSelfserveTestData;
    }

    @SuppressWarnings(value = "unchecked")
    public Map<String, RegistrationProfile> getallRegistration(boolean reloadRequired) {
        if (allRegistration.isEmpty() || reloadRequired) {
            allRegistration = (Map<String, RegistrationProfile>) xStream
                    .fromXML(readTestDataXml(bgbRegXMLFile));
        }
        return allRegistration;
    }

    @SuppressWarnings(value = "unchecked")
    public Map<String, SearchInvoiceProfile> getallSearchInvoice(boolean reloadRequired) {
        if (allSearchInvoices.isEmpty() || reloadRequired) {
            allSearchInvoices = (Map<String, SearchInvoiceProfile>) xStream
                    .fromXML(readTestDataXml(searchInvoiceXMLFile));
        }
        return allSearchInvoices;
    }
    
    @SuppressWarnings(value="unchecked")
    public Map<String, LandLord> getallLandLord(boolean reloadRequired){
    	if(allLandLord.isEmpty() || reloadRequired){
    		allLandLord=(Map<String, LandLord>) xStream.fromXML(readTestDataXml(landLordXMLFile));
    	}
    	return allLandLord;
    }

    @SuppressWarnings(value = "unchecked")
    public Map<String, UserProfile> getallSelfServeRegistration(boolean reloadRequired) {
        if (allUserProfile.isEmpty() || reloadRequired) {
            allUserProfile = (Map<String, UserProfile>) xStream
                    .fromXML(readTestDataXml(selfServeRegistrationXML));
        }
        return allUserProfile;
    }

   

    public RegistrationProfile getRegistrationProfile(String profileKey) {

        if (allRegistration.isEmpty()) {
            getallRegistration(false);
        }
        return allRegistration.get(profileKey);
    }
    public CarePlanProfile getCarePlanProfile(String profileKey) {

        if (allCarePlanProfileProfile.isEmpty()) {
        	getAllCarePlanProfile(false);
        }
        return allCarePlanProfileProfile.get(profileKey);
    }

    public SearchInvoiceProfile getSearchInvoiceProfile(String profileKey) {

        if (allSearchInvoices.isEmpty()) {
            getallRegistration(false);
        }
        return allSearchInvoices.get(profileKey);
    }
    
    public LandLord getLandLord(String profileKey){
    	if(allLandLord.isEmpty()){
    		getallLandLord(false);
    	}
    	return allLandLord.get(profileKey);
    }

    public PriceFinder getPFdata(String profileKey) {
        if (allPFTestData.isEmpty()) {
            getAllPFdata(false);
        }
        return allPFTestData.get(profileKey);
    }

    public UserProfile getUserProfile(String profileKey) {
        if (allUserProfiles.isEmpty()) {
            getAllUserProfiles(false);
        }
        return allUserProfiles.get(profileKey);
        
    }
    
    @SuppressWarnings(value = "unchecked")
    public Map<String, RegProfile> getAllRegProfiles(boolean reloadRequired) {
        if (allRegProfiles.isEmpty() || reloadRequired) {
            allRegProfiles = (Map<String, RegProfile>) xStream
                    .fromXML(readTestDataXml(regProfileXMLFile));
        }
        return allRegProfiles;
    }

    public RegProfile getRegProfile(String profileKey) {
        if (allRegProfiles.isEmpty()) {
            getAllRegProfiles(false);
        }
        return allRegProfiles.get(profileKey);
    }

    @SuppressWarnings(value = "unchecked")
    public Map<String, Acquisition> getAllAcqusitionDetails(boolean reloadRequired) {
        if (allAcqusitionProfiles.isEmpty() || reloadRequired) {
            allAcqusitionProfiles = (Map<String, Acquisition>) xStream
                    .fromXML(readTestDataXml(acquisitiondataXMLFile));
        }
        return allAcqusitionProfiles;
    }
    
    
    @SuppressWarnings(value = "unchecked")
    public Map<String, HomeMove> getAllHomeMoveDetails(boolean reloadRequired) {
        if (allHomeMoveProfiles.isEmpty() || reloadRequired) {
            allHomeMoveProfiles = (Map<String, HomeMove>) xStream
                    .fromXML(readTestDataXml(HomeMovedataXMLFile));
        }
        return allHomeMoveProfiles;
    }

    @SuppressWarnings(value = "unchecked")
    public Map<String, GetAPrice> getAllGAPData(boolean reloadRequired) {
        if (allGAPTestData.isEmpty() || reloadRequired) {
            allGAPTestData = (Map<String, GetAPrice>) xStream
                    .fromXML(readTestDataXml(GetaPriceXMLFile));
        }
        return allGAPTestData;
    }

    public GetAPrice getGetAPriceData(String profileKey) {
        if (allGAPTestData.isEmpty()) {
            getAllGAPData(false);
        }
        return allGAPTestData.get(profileKey);
    }

    public Acquisition getAcquisitionData(String profileKey) {
        if (allAcqusitionProfiles.isEmpty()) {
            getAllAcqusitionDetails(false);
        }
        return allAcqusitionProfiles.get(profileKey);
    }
    public HomeMove getHomeMoveData(String profileKey) {
        if (allHomeMoveProfiles.isEmpty()) {
            getAllHomeMoveDetails(false);
        }
        return allHomeMoveProfiles.get(profileKey);
    }

    public SMRAccountDetails getAccountDetails(Account account) {
        xStream.processAnnotations(SMRAccountDetails.class);
        if (allSMRAccounts.isEmpty()) {
            getAllSMRAccountDetails(false);
        }
        return allSMRAccounts.get(account.getNumber());
    }

    public ContactUsQueue getContactUsQueue(String profileKey) {
        if (allContactUsQueue.isEmpty()) {
            getAllContactUsQueue(false);
        }
        return allContactUsQueue.get(profileKey);
    }

    public GetAQuoteDetails getallGetAQuoteDetails(String profileKey) {
        if (allGetAQuoteDetails.isEmpty()) {
            getallGetAQuoteDetails(false);
        }
        return allGetAQuoteDetails.get(profileKey);
    }

    public InsuranceQuote getInsuranceQuoteDetails(String profileKey) {
        if (allInsuranceQuoteDetails.isEmpty()) {
            getAllInsuranceQuoteDetails(false);
        }
        return allInsuranceQuoteDetails.get(profileKey);
    }

    private String readTestDataXml(String testDataXMLFile) {
        System.out.println("Test Data At: " + testDataXMLFile);
        String testDataXMLAsString = "";
        try {
            testDataXMLAsString = IOUtils.toString(TestDataHelper.class.getClassLoader()
                    .getResourceAsStream(testDataXMLFile));
            //System.out.println(testDataXMLAsString);
        } catch (IOException e) {
        }
        return testDataXMLAsString;
    }
	public MakeAPaymentProfile getMakeAPaymentProfile(String profileKey) {
        if (allMakeAPaymentProfiles.isEmpty()) {
            getAllMakeAPaymentProfiles(false);
        }
        return allMakeAPaymentProfiles.get(profileKey);
    }
    
	@SuppressWarnings(value = "unchecked")
	public Map<String, Ddcps> getAllDdcpsDetails(boolean reloadRequired) {
        if (allDdcpsProfiles.isEmpty() || reloadRequired) {
        	allDdcpsProfiles = (Map<String,Ddcps>) xStream
                    .fromXML(readTestDataXml(ddcpsXMLFile));
        }
        return allDdcpsProfiles;
    }
	
	public Ddcps getDdcpsData(String profileKey) {
        if (allDdcpsProfiles.isEmpty()) {
        	getAllDdcpsDetails(false);
        }
        return allDdcpsProfiles.get(profileKey);
    }
	public GetAPricePageProfile getAPricePageProfile(String profileKey) {
        if (allGetAPricePageProfiles.isEmpty()) {
            getAllGetAPricePageProfiles(false);
        }
        return allGetAPricePageProfiles.get(profileKey);
    }
	
	public UserProfile putUserProfile(UserProfile profileKey) {
        
        return allUserProfiles.put("addrees@uk.com", profileKey);
        
        
    }
	
	@SuppressWarnings(value = "unchecked")
    public Map<String, CrmUserProfile> getAllCrmUserProfiles(boolean reloadRequired) {
    	System.out.println("Going to TestDataHelper.java-getAllCrmUserProfiles");
        if (allcrmUserProfiles.isEmpty() || reloadRequired) {
        	allcrmUserProfiles = (Map<String, CrmUserProfile>) xStream
                    .fromXML(readTestDataXml(crmUserProfile));
        }
        return allcrmUserProfiles;
    }
	
	 //Bgb - Slingshot
    public CrmUserProfile getCrmUserProfile(String profileKey) {
        if (allcrmUserProfiles.isEmpty()) {
        	System.out.println("Going to TestDataHelper.java-if condition");
        	getAllCrmUserProfiles(false);
        }
        System.out.println("Going to TestDataHelper.java-condition");
        return allcrmUserProfiles.get(profileKey);
    }
    //Bgb - Slingshot
	
	@SuppressWarnings(value = "unchecked")
    public Map<String, DirectDebit> getAllDirectDebitProfiles(boolean reloadRequired) {
    	System.out.println("Going to TestDataHelper.java-getAllDirectDebitProfiles");
        if (allDirectDebitProfile.isEmpty() || reloadRequired) {
        	allDirectDebitProfile = (Map<String, DirectDebit>) xStream
                    .fromXML(readTestDataXml(DirectDebit));
        }
        return allDirectDebitProfile;
    }
	
	//Bgb - Slingshot
    public DirectDebit getDirectDebitUserProfile(String profileKey) {
        if (allDirectDebitProfile.isEmpty()) {
        	System.out.println("Going to TestDataHelper.java-if condition");
        	getAllDirectDebitProfiles(false);
        }
        System.out.println("Going to TestDataHelper.java-condition");
        return allDirectDebitProfile.get(profileKey);
    }
    
    
    
  //Bgb - Slingshot
    
    public SMRAccountDetails getAllSMRUserProfile(String profileKey) {
        if (allSMRAccounts.isEmpty()) {
        	getAllSMRAccountDetails(false);
        }
        return allSMRAccounts.get(profileKey);
    }

}
