package bg.framework.app.functional.util;

import java.io.IOException;


import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import bg.framework.app.functional.common.ApplicationConfig; 
import bg.framework.app.functional.entities.Account;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.BankValidationDetailsProfile;
import bg.framework.app.functional.entities.BoilerReplaceProfile;
import bg.framework.app.functional.entities.CRMExecutionDataProfile;
import bg.framework.app.functional.entities.CompareTariff;
import bg.framework.app.functional.entities.KACPriceProfile;
import bg.framework.app.functional.entities.MakeAPaymentCardDetails;
import bg.framework.app.functional.entities.ModelSalesCombinationsProfile;
import bg.framework.app.functional.entities.ModelSalesPricing;
import bg.framework.app.functional.entities.ModelSalesProducts;
import bg.framework.app.functional.entities.PriceDetails;
import bg.framework.app.functional.entities.PriceFinderRMR;
import bg.framework.app.functional.entities.SiebelExecutionDataProfile;
import bg.framework.app.functional.entities.ContactUsQueue;
import bg.framework.app.functional.entities.CrmUserProfile;
import bg.framework.app.functional.entities.Ddcps; 
import bg.framework.app.functional.entities.GetAPrice;
import bg.framework.app.functional.entities.GetAPricePageProfile;
import bg.framework.app.functional.entities.BoilerTypeProfile;
import bg.framework.app.functional.entities.GetAQuoteDetails;
import bg.framework.app.functional.entities.HomeMove;
import bg.framework.app.functional.entities.InsuranceQuote;
import bg.framework.app.functional.entities.LandLord;
import bg.framework.app.functional.entities.MakeAPaymentProfile;
import bg.framework.app.functional.entities.PriceFinder;
import bg.framework.app.functional.entities.UnitRate;
import bg.framework.app.functional.entities.RegProfile;
import bg.framework.app.functional.entities.RegistrationProfile;
import bg.framework.app.functional.entities.SMRAccountDetails;
import bg.framework.app.functional.entities.SearchInvoiceProfile;
import bg.framework.app.functional.entities.TestData;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.entities.selfservedata;
import bg.framework.app.functional.entities.PredictNextBill;
import bg.framework.app.functional.entities.BAAProfile;
import bg.framework.app.functional.entities.Ddcps;
import bg.framework.app.functional.entities.EshopTariffProfile;


import com.thoughtworks.xstream.XStream;

//import bg.framework.app.functional.entities.BGB.RegistrationProfile;

public class TestDataHelper {
 
    private static final String userProfileXMLFile = "resources/TestData/bgr/UserProfiles.xml";
    private static final String regProfileXMLFile = "resources/TestData/bgb/Registration.xml";
    private static final String smrXMLFile = "resources/TestData/bgr/SMRAccounts.xml";
    private static final String PriceFinderTestDataXMLFile = "resources/TestData/config/PriceFinder2.xml";
   private static final String UnitRateTestDataXMLFile = "resources/TestData/config/UnitRates.xml";
    private static final String GetAQuoteDetailsXMLFile = "resources/TestData/bgb/GetAQuoteDetails.xml";
    private static final String bgbRegXMLFile = "resources/TestData/bgb/Registration.xml";
    private Map<String, RegistrationProfile> allRegistration = new HashMap<String, RegistrationProfile>();
    private static final String acquisitiondataXMLFile = "resources/TestData/bgr/Acquisition.xml";
    private static final String HomeMovedataXMLFile = "resources/TestData/bgr/HomeMove.xml";
    private static final String LoginXMLFile = "resources/TestData/bgr/CustomerInformation.xml";
    private static final String GetaPriceXMLFile = "resources/TestData/bgr/GetAPrice.xml";
  private static final String BoilerTypeXMLFile = "resources/TestData/bgr/BoilerType.xml";
    private static final String selfServeRegistrationXML = "resources/TestData/bgr/UserProfiles.xml";
    private static final String BGContactUsQueueXMLFile = "resources/TestData/config/BGContactUsQueue.xml";
    private static final String FusionContactUsQueueXMLFile = "resources/TestData/bgr/FusionContactUsQueue.xml";
    private static final String searchInvoiceXMLFile = "resources/TestData/bgb/SearchInvoice.xml";
    private static final String InsuranceQuoteXMLFile = "resources/TestData/bgr/InsuranceQuote.xml";
    private static final String landLordXMLFile="resources/TestData/services/LandLord.xml";
    private static final String makeAPaymentXMLFile = "resources/TestData/bgr/MakeAPayment.xml";
    private static final String ddcpsXMLFile="resources/TestData/bgr/Ddcps.xml";
  private static final String BAAXMLFile = "resources/TestData/bgr/BAA.xml";
    private static final String crmUserProfile = "resources/TestData/bgb/CrmUserProfile.xml";
    private static final String pnbXMLFile = "resources/TestData/bgr/PredictNextBill.xml";
    private static final String CRMExecutionDataXMLFile = "resources/TestData/bgr/CRMExecutionData.xml";
    private static final String SiebelExecutionDataXMLFile = "resources/TestData/bgr/SiebelExecutionData.xml";
    private Map<String, Ddcps> allDdcpsProfiles = new HashMap<String, Ddcps>(); 
    private static final String getAPricePageXMLFile = "resources/TestData/bgr/GetAPricePage.xml";
    private static final String BankValidationDetailsXMLFile = "resources/services/BankValidationDetails.xml";
    private static final String eshopTariffXMLFile = "resources/TestData/bgr/EshopTariff.xml";
    private static final String priceFinderXMLFile = "resources/TestData/bgr/PriceFinderRMR.xml";
    private static final String getAPriceDetailsXMLFile = "resources/TestData/bgr/GetAPriceNew.xml";
    private static final String CompareTariffXMLFile = "resources/TestData/bgr/CompareTariff.xml";
    private static final String boilerReplaceXMLFile = "resources/TestData/bgr/BoilerReplace.xml";
    private static final String kitchenApplianceXMLFile = "resources/TestData/bgr/KitchenAppliance.xml";
    private static final String gasApplianceCoverXMLFile = "resources/TestData/bgr/GasApplianceCoverData.xml";
    private static final String kacPriceSheetXMLFile = "resources/TestData/bgr/KACPriceSheet.xml"; 
    private static final String ModelSalesProductXMLFile = "resources/TestData/bgr/ModelSalesProducts.xml";
    private static final String KACProductXMLFile = "resources/TestData/bgr/KACProducts.xml";
    private static final String GACProductXMLFile = "resources/TestData/bgr/GACProducts.xml";
    private static final String ModelSalesPricingXMLFile = "resources/TestData/bgr/ModelSalesPricing.xml";
    private static final String ModelSalesCombinationXMLFile = "resources/TestData/bgr/ModelSalesCombinations.xml";
    private static final String ModelSalesTestDataXMLFile = "resources/TestData/bgr/ModelSalesTestData.xml";
    private static final String makeAPaymentCardDetailsXMLFile = "resources/TestData/bgr/MakeAPaymentCardDetails.xml";
    
    private Map<String, UserProfile> allUserProfiles = new HashMap<String, UserProfile>();
 private Map<String, UserProfile> allUserProfile = new HashMap<String, UserProfile>();
    //private Map<String, CrmUserProfile> allcrmUserProfile = new HashMap<String, CrmUserProfile>();
    private Map<String, RegProfile> allRegProfiles = new HashMap<String, RegProfile>();
    private Map<String, PriceFinderRMR> allPriceFinderRMR = new HashMap<String, PriceFinderRMR>();

    private Map<String, Acquisition> allAcqusitionProfiles = new HashMap<String, Acquisition>();
    private Map<String, HomeMove> allHomeMoveProfiles = new HashMap<String, HomeMove>();
    private Map<String, SMRAccountDetails> allSMRAccounts = new HashMap<String, SMRAccountDetails>();
    private Map<String, TestData> allTestData = new HashMap<String, TestData>();
    private Map<String, PriceFinder> allPFTestData = new HashMap<String, PriceFinder>();
    private Map<String, UnitRate> allUnitRateTestData = new HashMap<String, UnitRate>();
    private Map<String, GetAPrice> allGAPTestData = new HashMap<String, GetAPrice>();
    private Map<String, selfservedata> allSelfserveTestData = new HashMap<String, selfservedata>();
    private Map<String, SearchInvoiceProfile> allSearchInvoices = new HashMap<String, SearchInvoiceProfile>();
    private Map<String, GetAQuoteDetails> allGetAQuoteDetails = new HashMap<String, GetAQuoteDetails>();
    private Map<String, ContactUsQueue> allContactUsQueue = new HashMap<String, ContactUsQueue>();
    private Map<String, InsuranceQuote> allInsuranceQuoteDetails = new HashMap<String, InsuranceQuote>();
    private Map<String, LandLord> allLandLord=new HashMap<String, LandLord>();
    private Map<String, MakeAPaymentProfile> allMakeAPaymentProfiles = new HashMap<String, MakeAPaymentProfile>();
    private Map<String, GetAPricePageProfile> allGetAPricePageProfiles = new HashMap<String, GetAPricePageProfile>();
    private Map<String, BankValidationDetailsProfile> allBankValidationDetailsProfiles = new HashMap<String, BankValidationDetailsProfile>();
    private Map<String, BoilerReplaceProfile> allBoilerReplaceProfiles = new HashMap<String, BoilerReplaceProfile>();
    private Map<String, EshopTariffProfile> allEshopTariffProfiles = new HashMap<String, EshopTariffProfile>();
    private Map<String, PriceDetails> allPriceDetails = new HashMap<String, PriceDetails>();
    private Map<String, CompareTariff> allCompareTariffProfiles = new HashMap<String, CompareTariff>();
    private Map<String, BoilerTypeProfile> allBoilerTypeProfiles = new HashMap<String, BoilerTypeProfile>();
    private Map<String, CrmUserProfile> allcrmUserProfiles = new HashMap<String, CrmUserProfile>();
    private Map<String, PredictNextBill> allPNBProfiles= new HashMap<String,PredictNextBill>();
    private Map<String, CRMExecutionDataProfile> allCRMExecutionDataProfiles = new HashMap<String, CRMExecutionDataProfile>();
    private Map<String, SiebelExecutionDataProfile> allSiebelExecutionDataProfiles = new HashMap<String, SiebelExecutionDataProfile>();
    private Map<String, BAAProfile> allBAAProfiles = new HashMap<String, BAAProfile>();
    private Map<String, KACPriceProfile> allKACPriceProfile = new HashMap<String, KACPriceProfile>();
    private Map<String, ModelSalesProducts> allModelSalesProfile = new HashMap<String, ModelSalesProducts>();
    private Map<String, ModelSalesPricing> allModelSalesPricing = new HashMap<String, ModelSalesPricing>();
    private Map<String, ModelSalesCombinationsProfile> allModelSalesCombinationsProfile = new HashMap<String, ModelSalesCombinationsProfile>();
    private Map<String, MakeAPaymentCardDetails> allMakeAPaymentCardDetails=new HashMap<String, MakeAPaymentCardDetails>();
    
    private XStream xStream;

    public TestDataHelper() {
        xStream = new XStream();
        xStream.processAnnotations(TestData.class);
        xStream.processAnnotations(UserProfile.class);
 	 xStream.processAnnotations(CrmUserProfile.class);
        xStream.processAnnotations(PriceFinder.class);
	xStream.processAnnotations(UnitRate.class);	
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
	xStream.processAnnotations(EshopTariffProfile.class);
	xStream.processAnnotations(PriceDetails.class);
        xStream.processAnnotations(PredictNextBill.class);
        xStream.processAnnotations(CRMExecutionDataProfile.class);
        xStream.processAnnotations(SiebelExecutionDataProfile.class);
        xStream.processAnnotations(BAAProfile.class);
        xStream.processAnnotations(PriceFinderRMR.class);
        xStream.processAnnotations(CompareTariff.class); 
        xStream.processAnnotations(BankValidationDetailsProfile.class);
        xStream.processAnnotations(BoilerReplaceProfile.class);
        xStream.processAnnotations(KACPriceProfile.class);
        xStream.processAnnotations(ModelSalesProducts.class);
        xStream.processAnnotations(ModelSalesPricing.class);
        xStream.processAnnotations(ModelSalesCombinationsProfile.class);
    	xStream.processAnnotations(MakeAPaymentCardDetails.class);
      

    }

    @SuppressWarnings(value = "unchecked")
    public Map<String, UserProfile> getAllUserProfiles(boolean reloadRequired) {
        if (allUserProfiles.isEmpty() || reloadRequired) {
            allUserProfiles = (Map<String, UserProfile>) xStream
                    .fromXML(readTestDataXml(userProfileXMLFile));
        }
        return allUserProfile;
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
    
    @SuppressWarnings(value = "unchecked")
    public Map<String, GetAPricePageProfile> getAllGetAPricePageProfiles(boolean reloadRequired) {
        if (allGetAPricePageProfiles.isEmpty() || reloadRequired) {
            allGetAPricePageProfiles = (Map<String, GetAPricePageProfile>) xStream
                    .fromXML(readTestDataXml(getAPricePageXMLFile));
        }
        return allGetAPricePageProfiles;
    }
    
    @SuppressWarnings(value = "unchecked")
    public Map<String, BankValidationDetailsProfile> getAllBankValidationDetailsProfiles(boolean reloadRequired) {
        if (allBankValidationDetailsProfiles.isEmpty() || reloadRequired) {
            allBankValidationDetailsProfiles = (Map<String, BankValidationDetailsProfile>) xStream
                    .fromXML(readTestDataXml(BankValidationDetailsXMLFile));
        }
        return allBankValidationDetailsProfiles;
    }
    @SuppressWarnings(value = "unchecked")
    public Map<String, BoilerReplaceProfile> getAllBoilerReplaceProfiles(boolean reloadRequired) {
        if (allBoilerReplaceProfiles.isEmpty() || reloadRequired) {
            allBoilerReplaceProfiles = (Map<String, BoilerReplaceProfile>) xStream
                    .fromXML(readTestDataXml(boilerReplaceXMLFile));
        }
        return allBoilerReplaceProfiles;
    }
    
    @SuppressWarnings(value = "unchecked")
    public Map<String, KACPriceProfile> getKACPriceProfile(boolean reloadRequired) {
        if (allKACPriceProfile.isEmpty() || reloadRequired) {
        	allKACPriceProfile = (Map<String, KACPriceProfile>) xStream
                    .fromXML(readTestDataXml(kacPriceSheetXMLFile));
        }
        return allKACPriceProfile;
    }
    
    @SuppressWarnings(value = "unchecked")
    public Map<String, ModelSalesProducts> getModelSalesProfile(boolean reloadRequired) {
        if (allModelSalesProfile.isEmpty() || reloadRequired) {
        	allModelSalesProfile = (Map<String, ModelSalesProducts>) xStream
                    .fromXML(readTestDataXml(ModelSalesProductXMLFile));
        }
        return allModelSalesProfile;
    }
    
    @SuppressWarnings(value = "unchecked")
    public Map<String, ModelSalesPricing> getModelSalesPricing(boolean reloadRequired) {
        if (allModelSalesPricing.isEmpty() || reloadRequired) {
        	allModelSalesPricing = (Map<String, ModelSalesPricing>) xStream
                    .fromXML(readTestDataXml(ModelSalesPricingXMLFile));
        }
        return allModelSalesPricing;
    }
    
    @SuppressWarnings(value = "unchecked")
    public Map<String, ModelSalesCombinationsProfile> getModelSalesCombinationsProfile(boolean reloadRequired) {
        if (allModelSalesCombinationsProfile.isEmpty() || reloadRequired) {
        	allModelSalesCombinationsProfile = (Map<String, ModelSalesCombinationsProfile>) xStream
                    .fromXML(readTestDataXml(ModelSalesCombinationXMLFile));
        }
        return allModelSalesCombinationsProfile;
    }
    
   
    
   
    @SuppressWarnings(value = "unchecked")
    public Map<String, EshopTariffProfile> getAllEshopTariffProfiles(boolean reloadRequired) {
        if (allEshopTariffProfiles.isEmpty() || reloadRequired) {
            allEshopTariffProfiles = (Map<String, EshopTariffProfile>) xStream
                    .fromXML(readTestDataXml(eshopTariffXMLFile));
        }
        return allEshopTariffProfiles;
    }

    
    @SuppressWarnings(value = "unchecked")
    public Map<String, PriceDetails> getallGetAPriceDetails(boolean reloadRequired){
        if (allPriceDetails.isEmpty() || reloadRequired) {
        	allPriceDetails = (Map<String, PriceDetails>) xStream
                    .fromXML(readTestDataXml(getAPriceDetailsXMLFile));
        }
        return allPriceDetails;
    }
    
    
    @SuppressWarnings(value = "unchecked")
    public Map<String, CompareTariff> getallCompareTariffProfiles(boolean reloadRequired){
        if (allCompareTariffProfiles.isEmpty() || reloadRequired) {
        	allCompareTariffProfiles = (Map<String, CompareTariff>) xStream
                    .fromXML(readTestDataXml(CompareTariffXMLFile));
        }
        return allCompareTariffProfiles;
    }

    
    @SuppressWarnings(value = "unchecked")
    public Map<String, PriceFinderRMR> getallPriceFinderRMR(boolean reloadRequired){
        if (allPriceFinderRMR.isEmpty() || reloadRequired) {
        	allPriceFinderRMR = (Map<String, PriceFinderRMR>) xStream
                    .fromXML(readTestDataXml(priceFinderXMLFile));
        }
        return allPriceFinderRMR;
    }
    
    
   
@SuppressWarnings(value = "unchecked")
    public Map<String, BoilerTypeProfile> getAllBoilerTypeProfiles(boolean reloadRequired) {
        if (allBoilerTypeProfiles.isEmpty() || reloadRequired) {
            allBoilerTypeProfiles = (Map<String, BoilerTypeProfile>) xStream
                    .fromXML(readTestDataXml(BoilerTypeXMLFile));
        }
        return allBoilerTypeProfiles;
    }
	
	
	@SuppressWarnings(value = "unchecked")
    public Map<String, CRMExecutionDataProfile> getAllCRMExecutionDataProfiles(boolean reloadRequired) {
        if (allCRMExecutionDataProfiles.isEmpty() || reloadRequired) {
        	allCRMExecutionDataProfiles = (Map<String, CRMExecutionDataProfile>) xStream
                    .fromXML(readTestDataXml(CRMExecutionDataXMLFile));
        }
        return allCRMExecutionDataProfiles;
    }
    
	
	@SuppressWarnings(value = "unchecked")
    public Map<String, SiebelExecutionDataProfile> getAllSiebelExecutionDataProfiles(boolean reloadRequired) {
        if (allSiebelExecutionDataProfiles.isEmpty() || reloadRequired) {
        	allSiebelExecutionDataProfiles = (Map<String, SiebelExecutionDataProfile>) xStream
                    .fromXML(readTestDataXml(SiebelExecutionDataXMLFile));
        }
        return allSiebelExecutionDataProfiles;
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
    public Map<String, UnitRate> getAllUnitRatedata(boolean reloadRequired) {
        if (allUnitRateTestData.isEmpty() || reloadRequired) {
        	allUnitRateTestData = (Map<String, UnitRate>) xStream
                    .fromXML(readTestDataXml(UnitRateTestDataXMLFile));
        }
        return allUnitRateTestData;
    }

    @SuppressWarnings(value = "unchecked")
    public Map<String, SMRAccountDetails> getAllSMRAccountDetails(boolean reloadRequired) {
        if (allSMRAccounts.isEmpty() || reloadRequired) {
            allSMRAccounts = (Map<String, SMRAccountDetails>) xStream
                    .fromXML(readTestDataXml(smrXMLFile));
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

 @SuppressWarnings(value = "unchecked")
    public Map<String, BAAProfile> getallBAAProfiles(boolean reloadRequired) {
        if (allBAAProfiles.isEmpty() || reloadRequired) {
        	allBAAProfiles = (Map<String, BAAProfile>) xStream
                    .fromXML(readTestDataXml(BAAXMLFile));
        	
        }
        
		return allBAAProfiles;
    }
    public RegistrationProfile getRegistrationProfile(String profileKey) {

        if (allRegistration.isEmpty()) {
            getallRegistration(false);
        }
        return allRegistration.get(profileKey);
    }
    
    public BankValidationDetailsProfile BankValidationDetaisProfile(String profileKey) {
        if (allBankValidationDetailsProfiles.isEmpty()) {
            getAllBankValidationDetailsProfiles(false);
        }
        return allBankValidationDetailsProfiles.get(profileKey);
    }
    
    public BoilerReplaceProfile getBoilerReplaceProfile(String profileKey) {
        if (allBoilerReplaceProfiles.isEmpty()) {
            getAllBoilerReplaceProfiles(false);
        }
        return allBoilerReplaceProfiles.get(profileKey);
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
 	public UnitRate getUnitRatedata(String profileKey) {
        if (allUnitRateTestData.isEmpty()) {
            getAllUnitRatedata(false);
        }
        return allUnitRateTestData.get(profileKey);
    }	

    public UserProfile getUserProfile(String profileKey) {
        if (allUserProfiles.isEmpty()) {
            getAllUserProfiles(false);
        }
        return allUserProfiles.get(profileKey);
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
	
public BoilerTypeProfile boilerTypeProfile(String profileKey) {
        if (allBoilerTypeProfiles.isEmpty()) {
            getAllBoilerTypeProfiles(false);
        }
        return allBoilerTypeProfiles.get(profileKey);
    }
	
	
	@SuppressWarnings(value = "unchecked")
	public Map<String, PredictNextBill> getAllPNBDetails(boolean reloadRequired) {
	        if (allPNBProfiles.isEmpty() || reloadRequired) {
	        	allPNBProfiles = (Map<String, PredictNextBill>) xStream
	                    .fromXML(readTestDataXml(pnbXMLFile));
	        }
	        return allPNBProfiles;
	    }
	 
	public PredictNextBill getPNBData(String profileKey) {
	        if (allPNBProfiles.isEmpty()) {
	            getAllPNBDetails(false);
	        }
	        return allPNBProfiles.get(profileKey);
	    }

	public CRMExecutionDataProfile getCRMExecutionDataProfile(String profileKey) {
        if (allCRMExecutionDataProfiles.isEmpty()) {
            getAllCRMExecutionDataProfiles(false);
        }
        return allCRMExecutionDataProfiles.get(profileKey);
    }
	
	public SiebelExecutionDataProfile getSiebelExecutionDataProfile(String profileKey) {
        if (allSiebelExecutionDataProfiles.isEmpty()) {
            getAllSiebelExecutionDataProfiles(false);
        }
        return allSiebelExecutionDataProfiles.get(profileKey);
    }

	public BAAProfile getBAAProfile(String profileKey) {
        if (allBAAProfiles.isEmpty()) {
        	getallBAAProfiles(false);
        }
        return allBAAProfiles.get(profileKey);
    }
	
	public EshopTariffProfile getEshopTariffProfile(String profileKey) {
        if (allEshopTariffProfiles.isEmpty()) {
            getAllEshopTariffProfiles(false);
        }
        return allEshopTariffProfiles.get(profileKey);
    }
	
	public PriceDetails getPriceDetails(String profileKey){
		if (allPriceDetails.isEmpty()){
			getallGetAPriceDetails(false);
		}
		return allPriceDetails.get(profileKey);
	}
	
	public PriceFinderRMR getPriceFinderRMR(String profileKey){
		if (allPriceFinderRMR.isEmpty()){
			getallPriceFinderRMR(false);
		}
		return allPriceFinderRMR.get(profileKey);
	}
	
	public  CompareTariff getCompareTariffProfiles(String profileKey){
		if (allCompareTariffProfiles.isEmpty()){
			getallCompareTariffProfiles(false);
		}
		return allCompareTariffProfiles.get(profileKey);
	}
	
	public GetAQuoteDetails getGetAQuoteDetails (String profileKey) {
        if (allGetAQuoteDetails.isEmpty()) {
            getallGetAQuoteDetails(false);
        }
        return allGetAQuoteDetails.get(profileKey);
    }
	public KACPriceProfile getKACPriceProfile (String profileKey) {
        if (allKACPriceProfile.isEmpty()) {
        	getKACPriceProfile(false);
        }
        return allKACPriceProfile.get(profileKey);
    }
	
	public ModelSalesProducts getModelSalesProducts(String profileKey){
		if(allModelSalesProfile.isEmpty()){
			getModelSalesProfile(false);
		}
		return allModelSalesProfile.get(profileKey);
	}
	public ModelSalesPricing getModelSalesPricing(String profileKey){
		if(allModelSalesPricing.isEmpty()){
			getModelSalesPricing(false);
		}
		return allModelSalesPricing.get(profileKey);
	}
	
	public ModelSalesCombinationsProfile getModelSalesCombinationsProfile(String profileKey){
		if(allModelSalesCombinationsProfile.isEmpty()){
			getModelSalesCombinationsProfile(false);
		}
		return allModelSalesCombinationsProfile.get(profileKey);
	}
	 @SuppressWarnings(value="unchecked")
	    public Map<String, MakeAPaymentCardDetails> getallMakeAPaymentCardDetails(boolean reloadRequired){
	    	if(allMakeAPaymentCardDetails.isEmpty() || reloadRequired){
	    		allMakeAPaymentCardDetails=(Map<String, MakeAPaymentCardDetails>) xStream.fromXML(readTestDataXml(makeAPaymentCardDetailsXMLFile));
	    	}
	    	return allMakeAPaymentCardDetails;
	    }
	 public MakeAPaymentCardDetails getMakeAPaymentCardDetails(String profileKey){
	    	if(allMakeAPaymentCardDetails.isEmpty()){
	    		getallMakeAPaymentCardDetails(false);
	    	}
	    	return allMakeAPaymentCardDetails.get(profileKey);
	    }

	
}
