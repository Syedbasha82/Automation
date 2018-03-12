package bg.framework.app.functional.test.services;


import static bg.framework.app.functional.entities.FunctionalCategory.InProgress;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import static bg.framework.app.functional.entities.FunctionalCategory.SubmitMeterRead;
import bg.framework.app.functional.util.TestDataHelper;
import bg.framework.app.functional.entities.LandLord;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import org.testng.annotations.Test;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.action.services.LandlordActionNew;
import static bg.framework.app.functional.entities.FunctionalCategory.*;

public class LandlordTestNew extends TestBase{

	@Test(groups = { SubmitMeterRead,Regression,InProgress})
	public void verifyLandlordPostCode(){
		Report.createTestLogHeader("LandLord Journey", "Verify PostCode");
		new LandlordActionNew()
			.navigateLandLordPage()
			.verifyPostCodeErrorMessage();
	}
	
	
	@Test(groups = { SubmitMeterRead,Regression,InProgress })
	public void verifyLandlordMultipleProperty(){
		Report.createTestLogHeader("LandLord Journey", "Verify Multiple Properties");
		LandLord landLord= new TestDataHelper().getLandLord("single");
		String[] LandLordPackage = {"Gas Safety Check and Certificate","Landlord Essentials Plus","Landlord Pro","Landlord Basics","HomeCare 300™ & CP12"};
		for(int i=0;i<5;i++){
			new LandlordActionNew()
			.navigateLandLordPage()
			.verifyMultipleProperty("SelectAddress")
			.verifyMultiplePropertyPackageDetails(landLord,LandLordPackage[i])
			.fillContactSectionAnonymous("al7 4hd")
			.enterPaymentDetails(LandLordPackage[i])
			.enterTermsAndConditions(LandLordPackage[i])
			.verifyThankYouPage();
		}
	}
	
	
	@Test(groups = { SubmitMeterRead,Regression,InProgress })
	public void verifyLandlordEnterAddressManually(){
		Report.createTestLogHeader("LandLord Journey", "Verify Multiple Properties Apply All");
		LandLord landLord= new TestDataHelper().getLandLord("single");
		String[] LandLordPackage = {/*"Landlord Essentials",*/"Landlord Essentials Plus","Landlord Pro","Landlord Basics","HomeCare 300™ & CP12"};
		for(int i=0;i<4;i++){
			new LandlordActionNew()
				.navigateLandLordPage()
				.verifyMultipleProperty("ManualAddress")
				.verifyMultiplePropertyPackageDetails(landLord,LandLordPackage[i])
				.fillContactSectionAnonymous("al7 4hd")
				.enterPaymentDetails(LandLordPackage[i])
				.enterTermsAndConditions(LandLordPackage[i])
				.verifyThankYouPage();
		}
	}
		
	
	@Test(groups = { SubmitMeterRead,Regression,InProgress })
	public void verifyAnonymousNationalLandlordPackagePricingWithoutBoilerCover(){
		//a(false)
		Report.createTestLogHeader("LandLord Journey", "Verify Landlord Package Pricing without boiler");
		LandLord Landlord= new TestDataHelper().getLandLord("single");
		boolean BoilerCover = false;
		new LandlordActionNew()
			.navigateLandLordPage()
			.enterPostcodeDetails("al7 4hd")
			.verifyPackagePricing("National",BoilerCover)
			.fillPackageDetails(Landlord)
			.fillContactSectionAnonymous("al7 4hd")
			.enterPaymentDetails("")
			.enterTermsAndConditions("")
			.verifyThankYouPage();
	}
	
	@Test(groups = { SubmitMeterRead,Regression,InProgress })
	public void verifyAnonymousLondonLandlordPackagePricingWithoutBoilerCover(){
		Report.createTestLogHeader("LandLord Journey", "Verify Landlord Package London without boiler cover");
		LandLord Landlord= new TestDataHelper().getLandLord("single");
		boolean BoilerCover = false;
		new LandlordActionNew()
			.navigateLandLordPage()
			.enterPostcodeDetails("tw18 3he")
			.verifyPackagePricing("London",BoilerCover)
			.fillPackageDetails(Landlord)
			.fillContactSectionAnonymous("tw18 3he")
			.enterPaymentDetails("")
			.enterTermsAndConditions("")
			.verifyThankYouPage();
			
	}
	
	@Test(groups = { SubmitMeterRead,Regression,InProgress })
	public void verifyAnonymousNationalLandlordPackagePricingWithBoilerCover(){
		Report.createTestLogHeader("LandLord Journey", "Verify Anonymous National with Boiler Cover");
		LandLord Landlord= new TestDataHelper().getLandLord("single");
		boolean BoilerCover = true;
		new LandlordActionNew()
			.navigateLandLordPage()
			.enterPostcodeDetails("al7 4hd")
			.verifyPackagePricing("National",BoilerCover)
			.fillPackageDetails(Landlord)
			.fillContactSectionAnonymous("al7 4hd")
			.enterPaymentDetails("")
			.enterTermsAndConditions("")
			.verifyThankYouPage();
	}
	
	@Test(groups = { SubmitMeterRead,Regression,InProgress })
	public void verifyAnonymousLondonLandlordPackagePricingWithBoilerCover(){
		Report.createTestLogHeader("LandLord Journey", "Verify Anonymous London with boiler cover");
		LandLord Landlord= new TestDataHelper().getLandLord("single");
		boolean BoilerCover = true;
		new LandlordActionNew()
			.navigateLandLordPage()
			.enterPostcodeDetails("tw18 3he")
			.verifyPackagePricing("London",BoilerCover)
			.fillPackageDetails(Landlord)
			.fillContactSectionAnonymous("tw18 3he")
			.enterPaymentDetails("")
			.enterTermsAndConditions("")
			.verifyThankYouPage();
	}
	
	@Test(groups = { SubmitMeterRead,Regression,InProgress })
	public void verifyLoggedInLandlordShopExcessNational(){
		Report.createTestLogHeader("LandLord Journey", "Verify Logged in National for National postcode");
		LandLord Landlord= new TestDataHelper().getLandLord("single");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		boolean BoilerCover = true;
		new LoginAction()
    	.loginUserDetails(userProfile);
		new LandlordActionNew()
			.navigateLandLordPage()
			.enterPostcodeDetails("AL7 4hd")
			.verifyPackagePricing("National",BoilerCover)
			.fillPackageDetails(Landlord)
			.fillContactSectionLoggedIn("AL7 4hd")
			.enterPaymentDetails("")
			.enterTermsAndConditions("")
			.verifyThankYouPage(); 
	}
	
	@Test(groups = { SubmitMeterRead,Regression,InProgress })
	public void verifyLoggedInLandlordShopExcessLondon(){
		Report.createTestLogHeader("LandLord Journey", "Verify Logged in for London postcode"); 
		LandLord Landlord= new TestDataHelper().getLandLord("single");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		boolean BoilerCover = true;
		new LoginAction()
    	.loginUserDetails(userProfile);
		new LandlordActionNew()
			.navigateLandLordPage()
			.enterPostcodeDetails("BR1 7yj")
			.verifyPackagePricing("London",BoilerCover)
			.fillPackageDetails(Landlord)
			.fillContactSectionLoggedIn("BR1 7yj")
			.enterPaymentDetails("")
			.enterTermsAndConditions("")
			.verifyThankYouPage(); 
	}
////////////////////////////////////////////// Pricing region changes - Anonymous - HEMASUNDAR J /////////////////////////////////////////////////////////////////////
	
	@Test(groups = { SubmitMeterRead,Regression,InProgress })
	public void verifyAnonymousNationalPricingRegionChanges(){
		Report.createTestLogHeader("LandLord Journey", "Verify Pricing Region changes for London postcodes converting to National"); 
		LandLord Landlord= new TestDataHelper().getLandLord("single");
		boolean BoilerCover = true;
		String[] Postcode = {"CM11 4HD","CM12 4HD","CM13 4HD","CM14 4HD","CM15 4HD","DA10 4HD","DA11 4HD","DA12 4HD","DA13 4HD","DA3 4HD","DA4 4HD","DA9 4HD","HP3 4HD","KT23 4HD","KT24 4HD",
				"RM14 4HD","RM15 4HD","RM16 4HD","RM17 4HD","RM18 4HD","RM19 4HD","RM20 4HD","SS13 4HD","SS14 4HD","SS15 4HD","SS16 4HD","SS17 4HD","TN14 4HD","TN15 4HD","WD4 4HD",
				"NE10 4HD","TS13 4HD","BB8 4HD","CH66 4HD","CW8 4HD"};
		for(String postCodes : Postcode){
		new LandlordActionNew()
			.navigateLandLordPage()
			.enterPostcodeDetails(postCodes)
			.verifyPackagePricing("London",BoilerCover)
			/*.fillPackageDetails(Landlord)
			.fillContactSectionAnonymous(postCodes)
			.enterPaymentDetails("")
			.enterTermsAndConditions("")
			.verifyThankYouPage()*/;
	   }
	}
	
	@Test(groups = { SubmitMeterRead,Regression,InProgress })
	public void verifyAnonymousLondonPricingRegionChanges(){
		Report.createTestLogHeader("LandLord Journey", "Verify Pricing Region changes London postcodes"); 
		LandLord Landlord= new TestDataHelper().getLandLord("single");
		boolean BoilerCover = true;
		String[] Postcode = {"EC1A 4HD","N10 4HD","SE15 4HD","TW10 4HD","W13 4HD","BR4 4HD","CR5 4HD","DA14 4HD","HA1 4HD","IG10 4HD","KT10 4HD","RM6 4HD","TW12 4HD","UB10 4HD","WD18 4HD",
				"BR3 4HD","CR9 4HD","E17 4HD","HA8 4HD","IG114 HD","KT3 4HD","NW11 4HD","RM10 4HD","SW20 4HD"};
		for(String postCodes : Postcode){
		new LandlordActionNew()
			.navigateLandLordPage()
			.enterPostcodeDetails(postCodes)
			.verifyPackagePricing("London",BoilerCover)
			/*.fillPackageDetails(Landlord)
			.fillContactSectionAnonymous(postCodes)
			.enterPaymentDetails("")
			.enterTermsAndConditions("")
			.verifyThankYouPage()*/;
	   }
	}
	
//////////////////////////////////////////////Pricing region changes - Logged in - HEMASUNDAR J /////////////////////////////////////////////////////////////////////
	
	@Test(groups = { SubmitMeterRead,Regression,InProgress })
	public void verifyLoggedInNationalPricingRegionChanges(){
		Report.createTestLogHeader("LandLord Journey", "Verify Logged in National for National postcode Pricing region changes");
		LandLord Landlord= new TestDataHelper().getLandLord("single");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		boolean BoilerCover = true;
		String[] Postcode = {"CM11 4HD","CM12 4HD","CM13 4HD","CM14 4HD","CM15 4HD","DA10 4HD","DA11 4HD","DA12 4HD","DA13 4HD","DA3 4HD","DA4 4HD","DA9 4HD","HP3 4HD","KT23 4HD","KT24 4HD",
				"RM14 4HD","RM15 4HD","RM16 4HD","RM17 4HD","RM18 4HD","RM19 4HD","RM20 4HD","SS13 4HD","SS14 4HD","SS15 4HD","SS16 4HD","SS17 4HD","TN14 4HD","TN15 4HD","WD4 4HD",
				"NE10 4HD","TS13 4HD","BB8 4HD","CH66 4HD","CW8 4HD"};
		for(String postCodes : Postcode){
		new LoginAction()
    	.loginUserDetails(userProfile);
		new LandlordActionNew()
			.navigateLandLordPage()
			.enterPostcodeDetails(postCodes)
			.verifyPackagePricing("National",BoilerCover)
			/*.fillPackageDetails(Landlord)
			.fillContactSectionLoggedIn(postCodes)
			.enterPaymentDetails("")
			.enterTermsAndConditions("")
			.verifyThankYouPage()*/; 
		}
	}
	
	@Test(groups = { SubmitMeterRead,Regression,InProgress })
	public void verifyLoggedInLondonPricingRegionChanges(){
		Report.createTestLogHeader("LandLord Journey", "Verify Logged in for London postcode Pricing region changes"); 
		LandLord Landlord= new TestDataHelper().getLandLord("single");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		boolean BoilerCover = true;
		String[] Postcode = {"EC1A 4HD","N10 4HD","SE15 4HD","TW10 4HD","W13 4HD","BR4 4HD","CR5 4HD","DA14 4HD","HA1 4HD","IG10 4HD","KT10 4HD","RM6 4HD","TW12 4HD","UB10 4HD","WD18 4HD",
				"BR3 4HD","CR9 4HD","E17 4HD","HA8 4HD","IG114 HD","KT3 4HD","NW11 4HD","RM10 4HD","SW20 4HD"};
		for(String postCodes : Postcode){
		new LoginAction()
    	.loginUserDetails(userProfile);
		new LandlordActionNew()
			.navigateLandLordPage()
			.enterPostcodeDetails(postCodes)
			.verifyPackagePricing("London",BoilerCover)
			/*.fillPackageDetails(Landlord)
			.fillContactSectionLoggedIn(postCodes)
			.enterPaymentDetails("")
			.enterTermsAndConditions("")
			.verifyThankYouPage()*/; 
		}
	}
	
	@Test(groups = { SubmitMeterRead,Regression,InProgress })
    public void verifyOAMNationalLandlordPackagePricingWithoutBoilerCover(){
           Report.createTestLogHeader("LandLord Journey", "Verify OAM Landlord Package Pricing without boiler");
           LandLord Landlord= new TestDataHelper().getLandLord("single");
           UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
           boolean BoilerCover = false;
             new HomePageAction()
       .navigateToLogin()
       .login(userProfile);
           new LandlordActionNew()
                  .navigateLandLordPage()
                  .enterPostcodeDetails("al7 4hd")
                  .verifyPackagePricing("National",BoilerCover)
                  .fillPackageDetails(Landlord)
                  .fillContactSectionAnonymous("al7 4hd")
                  .enterPaymentDetails("")
                  .enterTermsAndConditions("")
                  .verifyThankYouPage();
           new HomePageAction()
		 	.logout(); 
    }
    
    
    @Test(groups = { SubmitMeterRead,Regression,InProgress })
    public void verifyOAMLondonLandlordPackagePricingWithoutBoilerCover(){
           Report.createTestLogHeader("LandLord Journey", "Verify OAM Landlord Package London without boiler cover");
           LandLord Landlord= new TestDataHelper().getLandLord("single");
           UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
           boolean BoilerCover = false;
             new HomePageAction()
       .navigateToLogin()
       .login(userProfile);
           new LandlordActionNew()
                  .navigateLandLordPage()
                  .enterPostcodeDetails("tw18 3he")
                  .verifyPackagePricing("London",BoilerCover)
                  .fillPackageDetails(Landlord)
                  .fillContactSectionAnonymous("tw18 3he")
                  .enterPaymentDetails("")
                  .enterTermsAndConditions("")
                  .verifyThankYouPage();
           new HomePageAction()
		 	.logout(); 
    }

    @Test(groups = { SubmitMeterRead,Regression,InProgress })
    public void verifyOAMNationalLandlordPackagePricingWithBoilerCover(){
           Report.createTestLogHeader("LandLord Journey", "Verify Anonymous National with Boiler Cover");
           LandLord Landlord= new TestDataHelper().getLandLord("single");
           UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
           boolean BoilerCover = true;
             new HomePageAction()
       .navigateToLogin()
       .login(userProfile);
           new LandlordActionNew()
                  .navigateLandLordPage()
                  .enterPostcodeDetails("al7 4hd")
                  .verifyPackagePricing("National",BoilerCover)
                  .fillPackageDetails(Landlord)
                  .fillContactSectionAnonymous("al7 4hd")
                  .enterPaymentDetails("")
                  .enterTermsAndConditions("")
                  .verifyThankYouPage();
           new HomePageAction()
		 	.logout(); 
    }
    
    @Test(groups = { SubmitMeterRead,Regression,InProgress })
    public void verifyOAMLondonLandlordPackagePricingWithBoilerCover(){
           Report.createTestLogHeader("LandLord Journey", "Verify Anonymous London with boiler cover");
           LandLord Landlord= new TestDataHelper().getLandLord("single");
           UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
           boolean BoilerCover = true;
             new HomePageAction()
       .navigateToLogin()
       .login(userProfile);
           new LandlordActionNew()
                  .navigateLandLordPage()
                  .enterPostcodeDetails("tw18 3he")
                  .verifyPackagePricing("London",BoilerCover)
                  .fillPackageDetails(Landlord)
                  .fillContactSectionAnonymous("tw18 3he")
                  .enterPaymentDetails("")
                  .enterTermsAndConditions("")
                  .verifyThankYouPage();
           new HomePageAction()
		 	.logout(); 
    }

}
