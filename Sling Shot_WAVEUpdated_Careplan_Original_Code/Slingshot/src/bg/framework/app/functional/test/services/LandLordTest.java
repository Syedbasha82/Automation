package bg.framework.app.functional.test.services;


import static bg.framework.app.functional.entities.FunctionalCategory.Services;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;

import org.testng.annotations.Test;


import bg.framework.app.functional.action.services.GetAQuoteAction;
import bg.framework.app.functional.action.services.NavigationAction;
import bg.framework.app.functional.entities.LandLord;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;


public class LandLordTest extends TestBase {
	
	@Test(groups = { Regression,Services})
    public void singleValueEndtoEndTest() {
        Report.createTestLogHeader("LandLord", "Single address End to End for CP12");
       final LandLord landLord= new TestDataHelper().getLandLord("single");
        
             new NavigationAction(landLord)
             .navigateToLandLordAction()
             .singleEntryTellUsAction()
             .packageAction().selectAddOnAction(1)
             .nextPropertyAction().getAQuoteAction()
             .verifyTotalPriceAction();
    }
	
	@Test(groups = {Regression, Services})
    public void multiValueEndtoEndTest() {
        Report.createTestLogHeader("LandLord", "Multi address End to End for CP12");
        final LandLord landLord= new TestDataHelper().getLandLord("gas");
        new NavigationAction(landLord)
        .navigateToLandLordAction()
        .multiEntryTellUsAction(2)
        .endPackageAction();

	}
	
	// Accordian 1 - 02,03
	@Test(groups = {Regression,Services})
    public void postCodeErrorTest() {
        Report.createTestLogHeader("LandLord", "Accordian-1 02, 03- Postcode error message test");
        final LandLord landLord= new TestDataHelper().getLandLord("invalid");
        new NavigationAction(landLord)
        .navigateToLandLordAction()
        .postCodeInvalidAction()
        .selectionErrorAction();
	
	}
	
	
	// Accordian 1 - 07,10,13
	@Test(groups = {Regression,Services})
    public void editPropertyTest() {
        Report.createTestLogHeader("LandLord", "Accordian 1- 07, 10, 13- Postcode remove property test");
        final LandLord landLord= new TestDataHelper().getLandLord("gas");
        new NavigationAction(landLord)
        .navigateToLandLordAction()
        .multiEntryTellUsAction(9)
        .nextPropertyAction()
        .editPropertyAction().removeAndAddPropertyAction(9);
	}	
	//Accordian 1 - 14,11
	@Test(groups = {Regression,Services})
    public void manualPropertyTest() {
        Report.createTestLogHeader("LandLord", "Accordian 1- 14, 11- Error messages for manual entry property test");
        final LandLord landLord= new TestDataHelper().getLandLord("manual");
        new NavigationAction(landLord)
        .navigateToLandLordAction()
        .manualEntryAction();
	}
	
	//Accordian 2 - 02
	@Test(groups = {Regression,Services})
    public void whatsThisOverlayTest() {
        Report.createTestLogHeader("LandLord", "Accordian 2 - 02- What is this Over Lay test");
        final LandLord landLord= new TestDataHelper().getLandLord("manual");
        new NavigationAction(landLord)
        .navigateToLandLordAction()
        .singleEntryTellUsAction()
        .whatsThisOverLayAction();        
	}
	
	//Accordian 2 - 04
	@Test(groups = {Regression,Services})
    public void invalidDateErrorTest() {
        Report.createTestLogHeader("LandLord", "Accordian 2 - 04- Invalid date error message test");
        final LandLord landLord= new TestDataHelper().getLandLord("invalid");
        new NavigationAction(landLord)
        .navigateToLandLordAction()
        .singleEntryTellUsAction()
        .packageAction()
        .selectAddOnAction(1)
        .nextPropertyAction()
        .verifyInvalidDateAction();               
	}
	
	//Accordian 2 - 05
	@Test(groups = {Regression,Services})
    public void invalidPackageTest() {
        Report.createTestLogHeader("LandLord", "Accordian 2 - 05- Invalid Package error message test");
        final LandLord landLord= new TestDataHelper().getLandLord("invalid");
        new NavigationAction(landLord)
        .navigateToLandLordAction()
        .singleEntryTellUsAction()
        .nextPropertyAction()
        .verifyInvalidPackageAction();
	}
	
	//Accordian 2 - 06,07
	@Test(groups = {Regression,Services})
    public void applyAllTest() {
        Report.createTestLogHeader("LandLord", "Accordian 2 - 06,07- Apply all and Edit  test");
        final LandLord landLord= new TestDataHelper().getLandLord("gas");
        new NavigationAction(landLord)
        .navigateToLandLordAction()
        .multiEntryTellUsAction(3)
        .packageAction()
        .selectAddOnAction(1)
        .applyAllAction()
        .nextPropertyAction()
        .verificationAfterApplyAllAction(2)
        .editPackageAction(1);
	}
	
	//Accordian 2 - 08, 24
	@Test(groups = {Regression,Services})
    public void editPackageTest() {
        Report.createTestLogHeader("LandLord", "Accordian 2 - 08, 24- Edit Package test");
        final LandLord landLord= new TestDataHelper().getLandLord("homecare");
        new NavigationAction(landLord)
        .navigateToLandLordAction()
        .multiEntryTellUsAction(2)
        .packageAction()
        .selectAddOnAction(1)
        .applyAllAction().nextPropertyAction()
        .verificationAfterApplyAllAction(1)        
        .editPackageAction(1)
        .applyAllAction().nextPropertyAction()
        .verificationAfterApplyAllAction(1);
	}
	
  //Accordian 2 - 25
	@Test(groups = {Regression,Services})
    public void deletePropertyTest() {
        Report.createTestLogHeader("LandLord", "Accordian 2 - 25- Delete property from the second section test");
        final LandLord landLord= new TestDataHelper().getLandLord("homecare");
        new NavigationAction(landLord)
        .navigateToLandLordAction()
        .multiEntryTellUsAction(2)
        .packageAction()
        .selectAddOnAction(1)
        .applyAllAction().nextPropertyAction()
        .verificationAfterApplyAllAction(1)       
        .editPropertyAction().removeAndAddPropertyAction(1)
        .singleEntryTellUsAction();
	}
	
	
	// Accordian 3 - 1 to 5
	@Test(groups = {Regression,Services})
    public void verifyGetAQuoteLondonTest() {
        Report.createTestLogHeader("LandLord", "Accordian 3 - 1 to 5- Get a Quote test for London Postcode");
        final LandLord landLord= new TestDataHelper().getLandLord("london");
        for(int iteration=1;iteration<=5;iteration++){
        	landLord.setPackageCover("index="+iteration);
        	new NavigationAction(landLord)
        	.navigateToLandLordAction()
            .singleEntryTellUsAction()
            .packageAction().selectAddOnAction(1)
            .nextPropertyAction()
            .getAQuoteAction().verifyTotalPriceAction();
        }        
	}
	
	// Accordian 3 - 6 to 10
		@Test(groups = {Regression,Services})
	    public void verifyGetAQuoteUKTest() {
	        Report.createTestLogHeader("LandLord", "Accordian 3 - 6 to 10- Get a Quote test for UK Postcode");
	        final LandLord landLord= new TestDataHelper().getLandLord("uk");
	        for(int iteration=1;iteration<=5;iteration++){
	        	landLord.setPackageCover("index="+iteration);
	        	new NavigationAction(landLord)
	        	.navigateToLandLordAction()
	            .singleEntryTellUsAction()
	            .packageAction().selectAddOnAction(1)
	            .nextPropertyAction()
	            .getAQuoteAction().verifyTotalPriceAction();
	        }        
		}
	
	// Accordian 3 - 11,12
	@Test(groups = {Regression,Services})
    public void editPackageGetAQuoteTest() {
        Report.createTestLogHeader("LandLord", "Accordian 3 - 11,12- Apply all check & Edit Package from Get a Quote section test");
        final LandLord landLord= new TestDataHelper().getLandLord("homecare");
        new NavigationAction(landLord)
        .navigateToLandLordAction()
        .multiEntryTellUsAction(9)
        .packageAction().selectAddOnAction(1)
        .applyAllAction().nextPropertyAction()
        .verificationAfterApplyAllAction(8)        
        .getAQuoteAction()
        .editPackageAction(1)
        .applyAllAction()
        .nextPropertyAction()
        .verificationAfterApplyAllAction(8)        
        .getAQuoteAction().verifyTotalPriceAction();
	}
	
	// Accordian 3 - 13,14,15(UK)                          have to exe
	@Test(groups = {Regression,Services})
	public void editPropertyGetAQuoteTest() {
	    Report.createTestLogHeader("LandLord", "Accordian 3 - 13,14,15- Apply all check & Edit Property from Get a Quote section test");
	    final LandLord landLord= new TestDataHelper().getLandLord("homecare");
	    new NavigationAction(landLord)
	    .navigateToLandLordAction()
	    .multiEntryTellUsAction(9)
	    .packageAction().selectAddOnAction(1).applyAllAction()
	    .nextPropertyAction()
	    .verificationAfterApplyAllAction(8)	    
	    .getAQuoteAction()
	    .editMyQuoteAction()
	    .removeAndAddPropertyAction(1)
	    .singleEntryTellUsAction().packageAction()
	    .selectAddOnAction(9)
	    .nextPropertyAction()
	    .getAQuoteAction();	        	   
		}
		
	//Accordian 2 - 20           
	@Test(groups = {Regression,Services})
	 public void allPackageLondonTest() {
	        Report.createTestLogHeader("LandLord", "Accordian 2- 20- Pricing combination for London");
	        final LandLord landLord= new TestDataHelper().getLandLord("london");
	        new NavigationAction(landLord)
	        .navigateToLandLordAction()
	        .multiEntryTellUsAction(5)
	        .multiPackageAction()
	        .addAnotherPropertyAction()
	        .verifySectionOne();
		}	
	
	//Accordian 2 -21(UK)
	@Test(groups = {Regression,Services})
	 public void allPackageUKTest() {
	        Report.createTestLogHeader("LandLord", "Accordian 2- 21- Pricing combination for UK");
	        final LandLord landLord= new TestDataHelper().getLandLord("uk");
	        new NavigationAction(landLord)
	        .navigateToLandLordAction()
	        .multiEntryTellUsAction(5)
	        .multiPackageAction()
	        .addAnotherPropertyAction()
	        .verifySectionOne();
	}
	
	//Accordian 2 - 22   Accordian 3 - 16,17,18,                                 
		@Test(groups = {Services})
		 public void allPackagePricingTest() {
		        Report.createTestLogHeader("LandLord", "Accordian 2- 22- Accordian 3-16,17,18 Pricing combination for London and UK");
		        final LandLord landLord= new TestDataHelper().getLandLord("homecare");
		        new NavigationAction(landLord)
		        .navigateToLandLordAction()
		        .multiEntryTellUsAction(9)
		        .multiPackageAction()		        
		        .editPropertyAction()
		        .removeAndAddPropertyAction(1)
		        .singleEntryTellUsAction()
		        .packageAction()
		        .selectAddOnAction(9)
		        .nextPropertyAction()
		        .getAQuoteAction().verifyTotalPriceAction();
			}
		
		// Accordian 3 - 19,20
				@Test(groups = {Services})
				 public void allPackageAndEditTest() {
				        Report.createTestLogHeader("LandLord", "Accordian 3-19,20 Pricing combination Edit Packages for London and UK");
				        final LandLord landLord= new TestDataHelper().getLandLord("homecare");
				        new NavigationAction(landLord)
				        .navigateToLandLordAction()
				        .multiEntryTellUsAction(9)
				        .multiPackageAction()
				        .editPackageAction(6)
				        .nextPropertyAction()
				        .editPackageAction(9)
				        .nextPropertyAction()
				        .getAQuoteAction().verifyTotalPriceAction();	
				}
		
		// Accordion 3 - 21, 22
		@Test(groups = {Services})
		public void applyAllAndEditTest() {
			Report.createTestLogHeader("LandLord", "Accordion 3 - 21, 22- Selecting different packages & Edit Property from Get a Quote section test");
			final LandLord landLord= new TestDataHelper().getLandLord("homecare");
			new NavigationAction(landLord)
			.navigateToLandLordAction()
			.multiEntryTellUsAction(4)
			.packageAction().selectAddOnAction(1).applyAllAction()
			.nextPropertyAction().verificationAfterApplyAllAction(3)
			.getAQuoteAction().editMyQuoteAction().removeAndAddPropertyAction(1)
			.singleEntryTellUsAction().packageAction().selectAddOnAction(4)
			.nextPropertyAction().getAQuoteAction().verifyTotalPriceAction();
			}
				
		// Accordion 3 -  23 24
				@Test(groups = {Regression, Services})
				public void gasAndHCTest() {
					Report.createTestLogHeader("LandLord", "Accordion 3 - 23, 24- Selecting different packages & Edit Property from Get a Quote section test");
					final LandLord landLord= new TestDataHelper().getLandLord("homecare");
					new NavigationAction(landLord)
					.navigateToLandLordAction()
					.multiEntryTellUsAction(2)
					.multiPackageAction()				
					.getAQuoteAction().verifyTotalPriceAction();
					}
		// Accordian 3 - 26 to 30
		@Test(groups = {Regression,Services})
		public void getAQuoteDualTest() {
			Report.createTestLogHeader("LandLord", "Accordian 3 - 26- OAM Customer for Dual Account");
			final LandLord landLord= new TestDataHelper().getLandLord("Dual");
			new NavigationAction(landLord)
			.navigateToLoginPage()
			.loginAction(landLord)
			.navigateToLandLordAction()
			.multiEntryTellUsAction(4)
			.packageAction().selectAddOnAction(1)
			.applyAllAction().nextPropertyAction()
			.verificationAfterApplyAllAction(3)
			.getAQuoteAction().verifyTotalPriceAction();
			new GetAQuoteAction().logoutAction();			
		}
		
		// Accordian 3 - 27 to 30
		@Test(groups = {Regression,Services})
		public void getAQuoteJITest() {
			Report.createTestLogHeader("LandLord", "Accordian 3 - 27- OAM Customer for JI Account");
			final LandLord landLord= new TestDataHelper().getLandLord("JI");
			new NavigationAction(landLord)
			.navigateToLoginPage()
			.loginAction(landLord)
			.navigateToLandLordAction()
			.multiEntryTellUsAction(5)
			.packageAction().selectAddOnAction(1)
			.applyAllAction().nextPropertyAction()
			.verificationAfterApplyAllAction(4)
			.getAQuoteAction().verifyTotalPriceAction();
			new GetAQuoteAction().logoutAction();
			
		}
		
		@Test(groups = {Regression,Services})
		public void getAQuoteDualBGSTest() {
			Report.createTestLogHeader("LandLord", "Accordian 3 - 30- OAM Customer for DualBGS Account");
			final LandLord landLord= new TestDataHelper().getLandLord("DualBGS");
			new NavigationAction(landLord)
			.navigateToLoginPage()
			.loginAction(landLord)
			.navigateToLandLordAction()
			.multiEntryTellUsAction(9)
			.packageAction().selectAddOnAction(1)
			.applyAllAction().nextPropertyAction()
			.verificationAfterApplyAllAction(8)
			.getAQuoteAction().verifyTotalPriceAction();
			new GetAQuoteAction().logoutAction();			
		}
		
		@Test(groups = {Regression,Services})
		public void getAQuoteSingleFuelTest() {
			Report.createTestLogHeader("LandLord", "Accordian 3 - 25- OAM Customer for SingleFuel Account");
			final LandLord landLord= new TestDataHelper().getLandLord("SingleFuel");
			new NavigationAction(landLord)
			.navigateToLoginPage()
			.loginAction(landLord)
			.navigateToLandLordAction()
			.multiEntryTellUsAction(3)
			.packageAction().selectAddOnAction(1)
			.applyAllAction().nextPropertyAction()
			.verificationAfterApplyAllAction(2)
			.getAQuoteAction().verifyTotalPriceAction();
			new GetAQuoteAction().logoutAction();			
		}
		
		
}	