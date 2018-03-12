package bg.framework.app.functional.test.sales;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.sales.GetAnInsuranceQuoteAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.InsuranceQuote;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;

import static bg.framework.app.functional.entities.FunctionalCategory.*;

public class InsuranceQuoteTest extends TestBase {
    public void QetInsuranceQuote() {

    }

    @SuppressWarnings("unchecked")
    @Test(groups = {InsuranceQuote, BG, Regression})
    public void verifyErrors() {
        InsuranceQuote insuranceQuote = new TestDataHelper().getInsuranceQuoteDetails("Boiler And controls breakdown1");
        Report.createTestLogHeader("Insurance Quote Error validation", "Anonymous");
        new HomePageAction()
                .navigateToBoilersAndCentralHeating()
                .navigateToGetAnInsuranceQuote()
                .validateErrorMessages(insuranceQuote);
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {InsuranceQuote, BG, Regression,SalesRegressionAnonymous })
    public void BoilerAndControlsExcessZero() {

        for (String x : zeroExcess()) {
            try {
                InsuranceQuote insuranceQuote = new TestDataHelper().getInsuranceQuoteDetails(x);
                if ((insuranceQuote.getExcess1() == 0 && insuranceQuote.getExcess2() == 0) || (insuranceQuote.getExcess1() == 0 && insuranceQuote.getExcess2() == 100)) {
                    Report.createTestLogHeader(x.substring(0, x.length()) + " Insurance Quote for zero excess", "Anonymous");
                    new GetAnInsuranceQuoteAction()
                           // .navigateToBoilersAndCentralHeating()
                           // .navigateToGetAnInsuranceQuote()
                            .getAnInsuranceQuote(insuranceQuote);
                }
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }
    
   
   
    @SuppressWarnings("unchecked")
    @Test(groups = {InsuranceQuote, BG, Regression,SalesRegressionAnonymous})
    public void BoilerAndControlsExcessFiftyAndZero() {
         for (String x : fiftyExcess()) {
            try {
                InsuranceQuote insuranceQuote = new TestDataHelper().getInsuranceQuoteDetails(x);
                if ((insuranceQuote.getExcess1() == 50 && insuranceQuote.getExcess2() == 0) || (insuranceQuote.getExcess1() == 50 && insuranceQuote.getExcess2() == 100)) {
                    Report.createTestLogHeader(x.substring(0, x.length()) + " Insurance Quote for Excess 50 and Zero", "Anonymous");
                    new GetAnInsuranceQuoteAction()
                            //.navigateToBoilersAndCentralHeating()
                            //.navigateToGetAnInsuranceQuote()
                            .getAnInsuranceQuote(insuranceQuote);
                }
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {InsuranceQuote, BG, Regression,SalesRegressionAnonymous})
    public void BoilerAndControlsExcess99andZero() {

        for (String x : nineZeroExcess()) {
            try {
                InsuranceQuote insuranceQuote = new TestDataHelper().getInsuranceQuoteDetails(x);

                if ((insuranceQuote.getExcess1() == 99 && insuranceQuote.getExcess2() == 0) || (insuranceQuote.getExcess1() == 99 && insuranceQuote.getExcess2() == 100)) {
                    Report.createTestLogHeader(x.substring(0, x.length()) + " Insurance Quote excess 99 and Zero", "Anonymous");
                    new GetAnInsuranceQuoteAction()
                           // .navigateToBoilersAndCentralHeating()
                           // .navigateToGetAnInsuranceQuote()
                            .getAnInsuranceQuote(insuranceQuote);
                }
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {InsuranceQuote, BG, Regression,SalesRegressionAnonymous})
    public void BoilerAndControlsExcessZeroAndFifty() {
        for (String x : zeroAndFiftyExcess()) {
            try {
                InsuranceQuote insuranceQuote = new TestDataHelper().getInsuranceQuoteDetails(x);
                if ((insuranceQuote.getExcess1() == 0 && insuranceQuote.getExcess2() == 50)) {
                    Report.createTestLogHeader(x.substring(0, x.length()) + " Insurance Quote for Zero excess and 50", "Anonymous");
                    new GetAnInsuranceQuoteAction()
                           // .navigateToBoilersAndCentralHeating()
                           // .navigateToGetAnInsuranceQuote()
                            .getAnInsuranceQuote(insuranceQuote);
                }
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {InsuranceQuote, BG, Regression,SalesRegressionAnonymous})
    public void BoilerAndControlsExcessFifty() {
        for (String x : excessFifty()) {
            try {
                InsuranceQuote insuranceQuote = new TestDataHelper().getInsuranceQuoteDetails(x);
                if (insuranceQuote.getExcess1() == 50) {
                    Report.createTestLogHeader(x.substring(0, x.length()) + " Insurance Quote for 50 Excess", "Anonymous");
                    new GetAnInsuranceQuoteAction()
                           // .navigateToBoilersAndCentralHeating()
                           // .navigateToGetAnInsuranceQuote()
                            .getAnInsuranceQuote(insuranceQuote);
                }
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {InsuranceQuote, BG, Regression,SalesRegressionAnonymous})
    public void BoilerAndControlsExcess99AndFifty() {
        for (String x : ninenineAnd50Excess()) {
            try {
                InsuranceQuote insuranceQuote = new TestDataHelper().getInsuranceQuoteDetails(x);
                if ((insuranceQuote.getExcess1() == 99 && insuranceQuote.getExcess2() == 50)) {
                    Report.createTestLogHeader(x.substring(0, x.length()) + " Insurance Quote for 99 and 50", "Anonymous");
                    new GetAnInsuranceQuoteAction()
                         //   .navigateToBoilersAndCentralHeating()
                         //   .navigateToGetAnInsuranceQuote()
                            .getAnInsuranceQuote(insuranceQuote);
                }
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {InsuranceQuote, BG, Regression})
    public void BoilerAndControlsElecOAM() {
        String[] xx = {        		
        		/*"Boiler And controls breakdown1",*/
    			"Boiler And controls breakdown2",
    			/*"Boiler And controls breakdown3",
    			"Boiler And controls breakdown And HEC7"*/       		        		
        };
        for (String x : xx) {
            try {
            	UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
                Report.createTestLogHeader(x.substring(0, x.length()) + " Insurance Quote for Electricity Account", "OAM");
                InsuranceQuote insuranceQuote = new TestDataHelper().getInsuranceQuoteDetails(x);                
                getCustomerDetailsToUserProfileOAM(userProfile);
                new HomePageAction()
                        .navigateToLogin()
                        .login(userProfile)
                        .navigateToBoilersAndCentralHeating()
                        .navigateToGetAnInsuranceQuote()
                        .getAnOAMInsuranceQuote(insuranceQuote, userProfile)
                        .logout();

            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }
    @SuppressWarnings("unchecked")
    @Test(groups = {InsuranceQuote, BG, Regression})
    public void BoilerAndControlsGasOAM() {
        String[] xx = {        		
        		"Boiler And controls breakdown1",
    			/*"Boiler And controls breakdown2",
    			"Boiler And controls breakdown3",
    			"Boiler And controls breakdown And HEC7" */      		        		
        };
        for (String x : xx) {
            try {
            	UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
                Report.createTestLogHeader(x.substring(0, x.length()) + " Insurance Quote for Gas Account", "OAM");
                InsuranceQuote insuranceQuote = new TestDataHelper().getInsuranceQuoteDetails(x);                
                getCustomerDetailsToUserProfileOAM(userProfile);
                new HomePageAction()
                        .navigateToLogin()
                        .login(userProfile)
                        .navigateToBoilersAndCentralHeating()
                        .navigateToGetAnInsuranceQuote()
                        .getAnOAMInsuranceQuote(insuranceQuote, userProfile)
                        .logout();

            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }
    @SuppressWarnings("unchecked")
    @Test(groups = {InsuranceQuote, BG, Regression})
    public void BoilerAndControlsJIOAM() {
        String[] xx = {        		
        		"Boiler And controls breakdown1",
    			/*"Boiler And controls breakdown2",
    			"Boiler And controls breakdown3",
    			"Boiler And controls breakdown And HEC7" */      		        		
        };
        for (String x : xx) {
            try {
            	UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
                Report.createTestLogHeader(x.substring(0, x.length()) + " Insurance Quote for JI Account", "OAM");
                InsuranceQuote insuranceQuote = new TestDataHelper().getInsuranceQuoteDetails(x);                
                getCustomerDetailsToUserProfileOAM(userProfile);
                new HomePageAction()
                        .navigateToLogin()
                        .login(userProfile)
                        .navigateToBoilersAndCentralHeating()
                        .navigateToGetAnInsuranceQuote()
                        .getAnOAMInsuranceQuote(insuranceQuote, userProfile)
                        .logout();

            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }
    @SuppressWarnings("unchecked")
    @Test(groups = {InsuranceQuote, BG, Regression})
    public void BoilerAndControlsDualOAM() {
        String[] xx = {        		
        		"Boiler And controls breakdown1",
    			/*"Boiler And controls breakdown2",
    			"Boiler And controls breakdown3",
    			"Boiler And controls breakdown And HEC7"*/       		        		
        };
        for (String x : xx) {
            try {
            	UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount1");
                Report.createTestLogHeader(x.substring(0, x.length()) + " Insurance Quote for Dual Account", "OAM");
                InsuranceQuote insuranceQuote = new TestDataHelper().getInsuranceQuoteDetails(x);                
                getCustomerDetailsToUserProfileOAM(userProfile);
                new HomePageAction()
                        .navigateToLogin()
                        .login(userProfile)
                        .navigateToBoilersAndCentralHeating()
                        .navigateToGetAnInsuranceQuote()
                        .getAnOAMInsuranceQuote(insuranceQuote, userProfile)
                        .logout();

            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    @Test(groups = {InsuranceQuote, BG, Regression})
    public void BoilerAndControlsServicesOAM() {
        String[] xx = {        		
        		"Boiler And controls breakdown1",
    			/*"Boiler And controls breakdown2",
    			"Boiler And controls breakdown3",
    			"Boiler And controls breakdown And HEC7"  */     		        		
        };
        for (String x : xx) {
            try {
            	UserProfile userProfile = new TestDataHelper().getUserProfile("HomeServicesAccountIB");
                Report.createTestLogHeader(x.substring(0, x.length()) + " Insurance Quote for Services Account", "OAM");
                InsuranceQuote insuranceQuote = new TestDataHelper().getInsuranceQuoteDetails(x);                
                getCustomerDetailsToUserProfileOAM(userProfile);
                new HomePageAction()
                        .navigateToLogin()
                        .login(userProfile)
                        .navigateToBoilersAndCentralHeating()
                        .navigateToGetAnInsuranceQuote()
                        .getAnOAMInsuranceQuote(insuranceQuote, userProfile)
                        .logout();

            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {InsuranceQuote, BG, Regression})
    public void BoilerAndControlsDifferentBillingAddress() {
        String[] list = {
        		
        		"HomeCare 200 And PAndD And HEC256",
    			/*"Boiler And controls breakdown And PAndD And HEC316",
    			"Cental heating breakdown And PAndD336",*/
        		
        };
        for (String x : list) {
            try {
                Report.createTestLogHeader(x.substring(0, x.length()) + " Insurance Quote with different billing address", "Anonymous");
                InsuranceQuote insuranceQuote = new TestDataHelper().getInsuranceQuoteDetails(x);
                new GetAnInsuranceQuoteAction()
                       // .navigateToBoilersAndCentralHeating()
                       // .navigateToGetAnInsuranceQuote()
                        .getAnInsuranceQuoteWithDifferentBillingAddress(insuranceQuote);

            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    
   

    
   
    
    private String[] fullRegression() {
        String[] xxx = {"Boiler And controls breakdown1",
    			"Boiler And controls breakdown2",
    			"Boiler And controls breakdown3"
        		    		
               };
        return xxx;
    }
    
    
    
    
    
private String[] fiftyExcess(){
    	
    	String [] aaa ={
    			
    			"Boiler And controls breakdown And PAndD5",
    			"Boiler And controls breakdown And HEC8",
    			"Boiler And controls breakdown And HEC11",
    			"Boiler And controls breakdown And PAndD And HEC21",
    			"Boiler And controls breakdown And PAndD And HEC22",
    			"Boiler And controls breakdown And PAndD And HEC23",
    			"Boiler And controls breakdown And PAndD And HEC24",
    			"Boiler And controls breakdown And PAndD And HEC25",
    			"Boiler And controls breakdown And PAndD And HEC26",
    			"Boiler And controls breakdown And PAndD And HEC27",
    			"Cental heating breakdown And PAndD And HEC71",
    			"Cental heating breakdown And PAndD And HEC72",
    			"Cental heating breakdown And PAndD And HEC73",
    			"Cental heating breakdown And PAndD And HEC74",
    			"Cental heating breakdown And PAndD And HEC75",
    			"Cental heating breakdown And PAndD And HEC76",
    			"Cental heating breakdown And PAndD And HEC77",
    			"HomeCare 100 And PAndD120",
    			"HomeCare 100 And PAndD121",
    			"HomeCare 100 And PAndD122",
    			"HomeCare 100 And HEC142",
    			"HomeCare 100 And HEC143",
    			"HomeCare 100 And HEC144",
    			"HomeCare 100 And HEC145",
    			"HomeCare 100 And PAndD And HEC165",
    			"HomeCare 100 And PAndD And HEC166",
    			"HomeCare 100 And PAndD And HEC167",
    			"HomeCare 200 And PAndD183",
    			"HomeCare 200 And PAndD184",
    			"HomeCare 200 And PAndD185",
    			"HomeCare 200 And HEC205",
    			"HomeCare 200 And HEC206",
    			"HomeCare 200 And HEC207",
    			"HomeCare 200 And HEC208",
    			"HomeCare 200 And PAndD And HEC236",
    			"HomeCare 200 And PAndD And HEC237",
    			"HomeCare 200 And PAndD And HEC238",
    			"HomeCare 200 And PAndD And HEC239",
    			"HomeCare 200 And PAndD And HEC240",
    			"HomeCare 200 And PAndD And HEC241",
    			"HomeCare 200 And PAndD And HEC242",
    			"Boiler And controls breakdown And PAndD And HEC301",
    			"Boiler And controls breakdown And PAndD And HEC302",
    			"Boiler And controls breakdown And PAndD And HEC303",
    			"Boiler And controls breakdown And PAndD And HEC304",
    			"Boiler And controls breakdown And PAndD And HEC305",
    			"Boiler And controls breakdown And PAndD And HEC306",
    			"Boiler And controls breakdown And PAndD And HEC307",
    			"Boiler And controls breakdown And PAndD And HEC308",
    			"Cental heating breakdown And PAndD335",
    			"Cental heating breakdown And HEC338",
    			"Cental heating breakdown And HEC341",
    			"Cental heating breakdown And PAndD And HEC351",
    			"Cental heating breakdown And PAndD And HEC352",
    			"Cental heating breakdown And PAndD And HEC353",
    			"Cental heating breakdown And PAndD And HEC354",
    			"Cental heating breakdown And PAndD And HEC355",
    			"Cental heating breakdown And PAndD And HEC356",
    			"Cental heating breakdown And PAndD And HEC357",
    			"HomeCare 100 And PAndD400",
    			"HomeCare 100 And PAndD401",
    			"HomeCare 100 And PAndD402",
    			"HomeCare 100 And HEC422",
    			"HomeCare 100 And HEC423",
    			"HomeCare 100 And HEC424",
    			"HomeCare 100 And HEC425",
    			"HomeCare 100 And PAndD And HEC445",
    			"HomeCare 100 And PAndD And HEC446",
    			"HomeCare 100 And PAndD And HEC447",
    			"HomeCare 200 And PAndD463",
    			"HomeCare 200 And PAndD464",
    			"HomeCare 200 And PAndD465",
    			"HomeCare 200 And HEC485",
    			"HomeCare 200 And HEC486",
    			"HomeCare 200 And HEC487",
    			"HomeCare 200 And HEC488",
    			"HomeCare 200 And PAndD And HEC516",
    			"HomeCare 200 And PAndD And HEC517",
    			"HomeCare 200 And PAndD And HEC518",
    			"HomeCare 200 And PAndD And HEC519",
    			"HomeCare 200 And PAndD And HEC520",
    			"HomeCare 200 And PAndD And HEC521",
    			"HomeCare 200 And PAndD And HEC522",

			
    	};
    			
    			    	
    	
    	return aaa;
    	
    	}



private String[] nineZeroExcess(){
	
	String [] aaa ={
			
			"Boiler And controls breakdown And PAndD6",
			"Boiler And controls breakdown And HEC9",
			"Boiler And controls breakdown And HEC12",
			"Boiler And controls breakdown And PAndD And HEC36",
			"Boiler And controls breakdown And PAndD And HEC37",
			"Boiler And controls breakdown And PAndD And HEC38",
			"Boiler And controls breakdown And PAndD And HEC39",
			"Boiler And controls breakdown And PAndD And HEC40",
			"Boiler And controls breakdown And PAndD And HEC41",
			"Boiler And controls breakdown And PAndD And HEC42",
			"Cental heating breakdown And PAndD And HEC86",
			"Cental heating breakdown And PAndD And HEC87",
			"Cental heating breakdown And PAndD And HEC88",
			"Cental heating breakdown And PAndD And HEC89",
			"Cental heating breakdown And PAndD And HEC90",
			"Cental heating breakdown And PAndD And HEC91",
			"Cental heating breakdown And PAndD And HEC92",
			"HomeCare 100 And PAndD127",
			"HomeCare 100 And PAndD128",
			"HomeCare 100 And PAndD129",
			"HomeCare 100 And HEC150",
			"HomeCare 100 And HEC151",
			"HomeCare 100 And HEC152",
			"HomeCare 100 And HEC153",
			"HomeCare 100 And PAndD And HEC172",
			"HomeCare 100 And PAndD And HEC173",
			"HomeCare 100 And PAndD And HEC174",
			"HomeCare 200 And PAndD190",
			"HomeCare 200 And PAndD191",
			"HomeCare 200 And PAndD192",
			"HomeCare 200 And HEC213",
			"HomeCare 200 And HEC214",
			"HomeCare 200 And HEC215",
			"HomeCare 200 And HEC216",
			"HomeCare 200 And PAndD And HEC251",
			"HomeCare 200 And PAndD And HEC252",
			"HomeCare 200 And PAndD And HEC253",
			"HomeCare 200 And PAndD And HEC254",
			"HomeCare 200 And PAndD And HEC255",
			"HomeCare 200 And PAndD And HEC256",
			"HomeCare 200 And PAndD And HEC257",
			"Boiler And controls breakdown And PAndD And HEC316",
			"Boiler And controls breakdown And PAndD And HEC317",
			"Boiler And controls breakdown And PAndD And HEC318",
			"Boiler And controls breakdown And PAndD And HEC319",
			"Boiler And controls breakdown And PAndD And HEC320",
			"Boiler And controls breakdown And PAndD And HEC321",
			"Boiler And controls breakdown And PAndD And HEC322",
			"Boiler And controls breakdown And PAndD And HEC323",
			"Cental heating breakdown And PAndD336",
			"Cental heating breakdown And HEC339",
			"Cental heating breakdown And HEC342",
			"Cental heating breakdown And PAndD And HEC366",
			"Cental heating breakdown And PAndD And HEC367",
			"Cental heating breakdown And PAndD And HEC368",
			"Cental heating breakdown And PAndD And HEC369",
			"Cental heating breakdown And PAndD And HEC370",
			"Cental heating breakdown And PAndD And HEC371",
			"Cental heating breakdown And PAndD And HEC372",
			"HomeCare 100 And PAndD407",
			"HomeCare 100 And PAndD408",
			"HomeCare 100 And PAndD409",
			"HomeCare 100 And HEC430",
			"HomeCare 100 And HEC431",
			"HomeCare 100 And HEC432",
			"HomeCare 100 And HEC433",
			"HomeCare 100 And PAndD And HEC452",
			"HomeCare 100 And PAndD And HEC453",
			"HomeCare 100 And PAndD And HEC454",
			"HomeCare 200 And PAndD470",
			"HomeCare 200 And PAndD471",
			"HomeCare 200 And PAndD472",
			"HomeCare 200 And HEC493",
			"HomeCare 200 And HEC494",
			"HomeCare 200 And HEC495",
			"HomeCare 200 And HEC496",
			"HomeCare 200 And PAndD And HEC531",
			"HomeCare 200 And PAndD And HEC532",
			"HomeCare 200 And PAndD And HEC533",
			"HomeCare 200 And PAndD And HEC534",
			"HomeCare 200 And PAndD And HEC535",
			"HomeCare 200 And PAndD And HEC536",
			"HomeCare 200 And PAndD And HEC537",


		
	};
			
			    	
	
	return aaa;
	
	}

private String[] zeroAndFiftyExcess(){
	
	String [] aaa ={
			"Boiler And controls breakdown And PAndD And HEC13",
			"Boiler And controls breakdown And PAndD And HEC14",
			"Boiler And controls breakdown And PAndD And HEC15",
			"Boiler And controls breakdown And PAndD And HEC16",
			"Boiler And controls breakdown And PAndD And HEC17",
			"Boiler And controls breakdown And PAndD And HEC18",
			"Boiler And controls breakdown And PAndD And HEC19",
			"Boiler And controls breakdown And PAndD And HEC20",
			"Cental heating breakdown And PAndD54",
			"Cental heating breakdown And HEC57",
			"Cental heating breakdown And HEC60",
			"Cental heating breakdown And PAndD And HEC63",
			"Cental heating breakdown And PAndD And HEC64",
			"Cental heating breakdown And PAndD And HEC65",
			"Cental heating breakdown And PAndD And HEC66",
			"Cental heating breakdown And PAndD And HEC67",
			"Cental heating breakdown And PAndD And HEC68",
			"Cental heating breakdown And PAndD And HEC69",
			"Cental heating breakdown And PAndD And HEC70",
			"HomeCare 100 And PAndD116",
			"HomeCare 100 And PAndD117",
			"HomeCare 100 And PAndD118",
			"Boiler And controls breakdown And HEC9",
			"HomeCare 100 And HEC138",
			"HomeCare 100 And HEC139",
			"HomeCare 100 And HEC140",
			"HomeCare 100 And HEC141",
			"HomeCare 100 And PAndD And HEC161",
			"HomeCare 100 And PAndD And HEC162",
			"HomeCare 100 And PAndD And HEC163",
			"HomeCare 100 And PAndD And HEC164",
			"HomeCare 200 And PAndD179",
			"HomeCare 200 And PAndD180",
			"HomeCare 200 And PAndD181",
			"HomeCare 200 And PAndD182",
			"HomeCare 200 And HEC201",
			"HomeCare 200 And HEC202",
			"HomeCare 200 And HEC203",
			"HomeCare 200 And HEC204",
			"HomeCare 200 And PAndD And HEC228",
			"HomeCare 200 And PAndD And HEC229",
			"HomeCare 200 And PAndD And HEC230",
			"HomeCare 200 And PAndD And HEC231",
			"HomeCare 200 And PAndD And HEC232",
			"HomeCare 200 And PAndD And HEC233",
			"HomeCare 200 And PAndD And HEC234",
			"HomeCare 200 And PAndD And HEC235",
			"Boiler And controls breakdown And PAndD285",
			"Boiler And controls breakdown And HEC288",
			"Boiler And controls breakdown And HEC291",
			"Boiler And controls breakdown And PAndD And HEC294",
			"Boiler And controls breakdown And PAndD And HEC295",
			"Boiler And controls breakdown And PAndD And HEC296",
			"Boiler And controls breakdown And PAndD And HEC297",
			"Boiler And controls breakdown And PAndD And HEC298",
			"Boiler And controls breakdown And PAndD And HEC299",
			"Boiler And controls breakdown And PAndD And HEC300",
			"Cental heating breakdown And PAndD And HEC343",
			"Cental heating breakdown And PAndD And HEC344",
			"Cental heating breakdown And PAndD And HEC345",
			"Cental heating breakdown And PAndD And HEC346",
			"Cental heating breakdown And PAndD And HEC347",
			"Cental heating breakdown And PAndD And HEC348",
			"Cental heating breakdown And PAndD And HEC349",
			"Cental heating breakdown And PAndD And HEC350",
			"HomeCare 100 And PAndD396",
			"HomeCare 100 And PAndD397",
			"HomeCare 100 And PAndD398",
			"HomeCare 100 And PAndD399",
			"HomeCare 100 And HEC418",
			"HomeCare 100 And HEC419",
			"HomeCare 100 And HEC420",
			"HomeCare 100 And HEC421",
			"HomeCare 100 And PAndD And HEC441",
			"HomeCare 100 And PAndD And HEC442",
			"HomeCare 100 And PAndD And HEC443",
			"HomeCare 100 And PAndD And HEC444",
			"HomeCare 200 And PAndD459",
			"HomeCare 200 And PAndD460",
			"HomeCare 200 And PAndD461",
			"HomeCare 200 And PAndD462",
			"HomeCare 200 And HEC481",
			"HomeCare 200 And HEC482",
			"HomeCare 200 And HEC483",
			"HomeCare 200 And HEC484",
			"HomeCare 200 And PAndD And HEC508",
			"HomeCare 200 And PAndD And HEC509",
			"HomeCare 200 And PAndD And HEC510",
			"HomeCare 200 And PAndD And HEC511",
			"HomeCare 200 And PAndD And HEC512",
			"HomeCare 200 And PAndD And HEC513",
			"HomeCare 200 And PAndD And HEC514",
			"HomeCare 200 And PAndD And HEC515",


	};
	return aaa;
	
	}  

private String[] excessFifty(){
	
	String [] aaa ={
			"Boiler And controls breakdown And PAndD And HEC28",
			"Boiler And controls breakdown And PAndD And HEC29",
			"Boiler And controls breakdown And PAndD And HEC30",
			"Boiler And controls breakdown And PAndD And HEC31",
			"Boiler And controls breakdown And PAndD And HEC32",
			"Boiler And controls breakdown And PAndD And HEC33",
			"Boiler And controls breakdown And PAndD And HEC34",
			"Boiler And controls breakdown And PAndD And HEC35",
			"Cental heating breakdown And PAndD55",
			"Cental heating breakdown And HEC58",
			"Cental heating breakdown And HEC61",
			"Cental heating breakdown And PAndD And HEC78",
			"Cental heating breakdown And PAndD And HEC79",
			"Cental heating breakdown And PAndD And HEC80",
			"Cental heating breakdown And PAndD And HEC81",
			"Cental heating breakdown And PAndD And HEC82",
			"Cental heating breakdown And PAndD And HEC83",
			"Cental heating breakdown And PAndD And HEC84",
			"Cental heating breakdown And PAndD And HEC85",
			"HomeCare 100 And PAndD123",
			"HomeCare 100 And PAndD124",
			"HomeCare 100 And PAndD125",
			"HomeCare 100 And PAndD126",
			"HomeCare 100 And HEC146",
			"HomeCare 100 And HEC147",
			"HomeCare 100 And HEC148",
			"HomeCare 100 And HEC149",
			"HomeCare 100 And PAndD And HEC168",
			"HomeCare 100 And PAndD And HEC169",
			"HomeCare 100 And PAndD And HEC170",
			"HomeCare 100 And PAndD And HEC171",
			"HomeCare 200 And PAndD186",
			"HomeCare 200 And PAndD187",
			"HomeCare 200 And PAndD188",
			"HomeCare 200 And PAndD189",
			"HomeCare 200 And HEC209",
			"HomeCare 200 And HEC210",
			"HomeCare 200 And HEC211",
			"HomeCare 200 And HEC212",
			"HomeCare 200 And PAndD And HEC243",
			"HomeCare 200 And PAndD And HEC244",
			"HomeCare 200 And PAndD And HEC245",
			"HomeCare 200 And PAndD And HEC246",
			"HomeCare 200 And PAndD And HEC247",
			"HomeCare 200 And PAndD And HEC248",
			"HomeCare 200 And PAndD And HEC249",
			"HomeCare 200 And PAndD And HEC250",
			"Boiler And controls breakdown And PAndD286",
			"Boiler And controls breakdown And HEC289",
			"Boiler And controls breakdown And HEC292",
			"Boiler And controls breakdown And PAndD And HEC309",
			"Boiler And controls breakdown And PAndD And HEC310",
			"Boiler And controls breakdown And PAndD And HEC311",
			"Boiler And controls breakdown And PAndD And HEC312",
			"Boiler And controls breakdown And PAndD And HEC313",
			"Boiler And controls breakdown And PAndD And HEC314",
			"Boiler And controls breakdown And PAndD And HEC315",
			"Cental heating breakdown And PAndD And HEC358",
			"Cental heating breakdown And PAndD And HEC359",
			"Cental heating breakdown And PAndD And HEC360",
			"Cental heating breakdown And PAndD And HEC361",
			"Cental heating breakdown And PAndD And HEC362",
			"Cental heating breakdown And PAndD And HEC363",
			"Cental heating breakdown And PAndD And HEC364",
			"Cental heating breakdown And PAndD And HEC365",
			"HomeCare 100 And PAndD403",
			"HomeCare 100 And PAndD404",
			"HomeCare 100 And PAndD405",
			"HomeCare 100 And PAndD406",
			"HomeCare 100 And HEC426",
			"HomeCare 100 And HEC427",
			"HomeCare 100 And HEC428",
			"HomeCare 100 And HEC429",
			"HomeCare 100 And PAndD And HEC448",
			"HomeCare 100 And PAndD And HEC449",
			"HomeCare 100 And PAndD And HEC450",
			"HomeCare 100 And PAndD And HEC451",
			"HomeCare 200 And PAndD466",
			"HomeCare 200 And PAndD467",
			"HomeCare 200 And PAndD468",
			"HomeCare 200 And PAndD469",
			"HomeCare 200 And HEC489",
			"HomeCare 200 And HEC490",
			"HomeCare 200 And HEC491",
			"HomeCare 200 And HEC492",
			"HomeCare 200 And PAndD And HEC523",
			"HomeCare 200 And PAndD And HEC524",
			"HomeCare 200 And PAndD And HEC525",
			"HomeCare 200 And PAndD And HEC526",
			"HomeCare 200 And PAndD And HEC527",
			"HomeCare 200 And PAndD And HEC528",
			"HomeCare 200 And PAndD And HEC529",
			"HomeCare 200 And PAndD And HEC530",

	};
	return aaa;
	
	}  

private String[] ninenineAnd50Excess(){
	
	String [] aaa ={
			"Boiler And controls breakdown And PAndD And HEC43",
			"Boiler And controls breakdown And PAndD And HEC44",
			"Boiler And controls breakdown And PAndD And HEC45",
			"Boiler And controls breakdown And PAndD And HEC46",
			"Boiler And controls breakdown And PAndD And HEC47",
			"Boiler And controls breakdown And PAndD And HEC48",
			"Boiler And controls breakdown And PAndD And HEC49",
			"Boiler And controls breakdown And PAndD And HEC50",
			"Cental heating breakdown And PAndD56",
			"Cental heating breakdown And HEC59",
			"Cental heating breakdown And HEC62",
			"Cental heating breakdown And PAndD And HEC93",
			"Cental heating breakdown And PAndD And HEC94",
			"Cental heating breakdown And PAndD And HEC95",
			"Cental heating breakdown And PAndD And HEC96",
			"Cental heating breakdown And PAndD And HEC97",
			"Cental heating breakdown And PAndD And HEC98",
			"Cental heating breakdown And PAndD And HEC99",
			"Cental heating breakdown And PAndD And HEC100",
			"HomeCare 100 And PAndD130",
			"HomeCare 100 And PAndD131",
			"HomeCare 100 And PAndD132",
			"HomeCare 100 And PAndD133",
			"HomeCare 100 And HEC154",
			"HomeCare 100 And HEC155",
			"HomeCare 100 And HEC156",
			"HomeCare 100 And HEC157",
			"HomeCare 100 And PAndD And HEC175",
			"HomeCare 100 And PAndD And HEC176",
			"HomeCare 100 And PAndD And HEC177",
			"HomeCare 100 And PAndD And HEC178",
			"HomeCare 200 And PAndD193",
			"HomeCare 200 And PAndD194",
			"HomeCare 200 And PAndD195",
			"HomeCare 200 And PAndD196",
			"HomeCare 200 And HEC217",
			"HomeCare 200 And HEC218",
			"HomeCare 200 And HEC219",
			"HomeCare 200 And HEC220",
			"HomeCare 200 And PAndD And HEC258",
			"HomeCare 200 And PAndD And HEC259",
			"HomeCare 200 And PAndD And HEC260",
			"HomeCare 200 And PAndD And HEC261",
			"HomeCare 200 And PAndD And HEC262",
			"HomeCare 200 And PAndD And HEC263",
			"HomeCare 200 And PAndD And HEC264",
			"HomeCare 200 And PAndD And HEC265",
			"Boiler And controls breakdown And PAndD287",
			"Boiler And controls breakdown And HEC290",
			"Boiler And controls breakdown And HEC293",
			"Boiler And controls breakdown And PAndD And HEC324",
			"Boiler And controls breakdown And PAndD And HEC325",
			"Boiler And controls breakdown And PAndD And HEC326",
			"Boiler And controls breakdown And PAndD And HEC327",
			"Boiler And controls breakdown And PAndD And HEC328",
			"Boiler And controls breakdown And PAndD And HEC329",
			"Boiler And controls breakdown And PAndD And HEC330",
			"Cental heating breakdown And PAndD And HEC373",
			"Cental heating breakdown And PAndD And HEC374",
			"Cental heating breakdown And PAndD And HEC375",
			"Cental heating breakdown And PAndD And HEC376",
			"Cental heating breakdown And PAndD And HEC377",
			"Cental heating breakdown And PAndD And HEC378",
			"Cental heating breakdown And PAndD And HEC379",
			"Cental heating breakdown And PAndD And HEC380",
			"HomeCare 100 And PAndD410",
			"HomeCare 100 And PAndD411",
			"HomeCare 100 And PAndD412",
			"HomeCare 100 And PAndD413",
			"HomeCare 100 And HEC434",
			"HomeCare 100 And HEC435",
			"HomeCare 100 And HEC436",
			"HomeCare 100 And HEC437",
			"HomeCare 100 And PAndD And HEC455",
			"HomeCare 100 And PAndD And HEC456",
			"HomeCare 100 And PAndD And HEC457",
			"HomeCare 100 And PAndD And HEC458",
			"HomeCare 200 And PAndD473",
			"HomeCare 200 And PAndD474",
			"HomeCare 200 And PAndD475",
			"HomeCare 200 And PAndD476",
			"HomeCare 200 And HEC497",
			"HomeCare 200 And HEC498",
			"HomeCare 200 And HEC499",
			"HomeCare 200 And HEC500",
			"HomeCare 200 And PAndD And HEC538",
			"HomeCare 200 And PAndD And HEC539",
			"HomeCare 200 And PAndD And HEC540",
			"HomeCare 200 And PAndD And HEC541",
			"HomeCare 200 And PAndD And HEC542",
			"HomeCare 200 And PAndD And HEC543",
			"HomeCare 200 And PAndD And HEC544",
			"HomeCare 200 And PAndD And HEC545",


	};
	return aaa;
	
	}  


    private String[] zeroExcess(){
    	
    	String [] aaa ={

    			
    			"Boiler And controls breakdown1",
    			"Boiler And controls breakdown And PAndD4",
    			"Boiler And controls breakdown And HEC7",
    			"Boiler And controls breakdown And HEC10",
    			"Central heating breakdown52",
    			"HomeCare 100101",
    			"HomeCare 100102",
    			"HomeCare 100103",
    			"HomeCare 100104",
    			"HomeCare 100 And PAndD113",
    			"HomeCare 100 And PAndD114",
    			"HomeCare 100 And PAndD115",
    			"HomeCare 100 And HEC134",
    			"HomeCare 100 And HEC135",
    			"HomeCare 100 And HEC136",
    			"HomeCare 100 And HEC137",
    			"HomeCare 100 And PAndD And HEC158",
    			"HomeCare 100 And PAndD And HEC159",
    			"HomeCare 100 And PAndD And HEC160",
    			"HomeCare 200 And HEC197",
    			"HomeCare 200 And HEC198",
    			"HomeCare 200 And HEC199",
    			"HomeCare 200 And HEC200",
    			"HomeCare 200 And PAndD And HEC221",
    			"HomeCare 200 And PAndD And HEC222",
    			"HomeCare 200 And PAndD And HEC223",
    			"HomeCare 200 And PAndD And HEC224",
    			"HomeCare 200 And PAndD And HEC225",
    			"HomeCare 200 And PAndD And HEC226",
    			"HomeCare 200 And PAndD And HEC227",
    			"HomeCare 200266",
    			"HomeCare 200267",
    			"HomeCare 200268",
    			"HomeCare 200269",
    			"Boiler And controls breakdown283",
    			"Central heating breakdown331",
    			"Cental heating breakdown And PAndD334",
    			"Cental heating breakdown And HEC337",
    			"Cental heating breakdown And HEC340",
    			"HomeCare 100381",
    			"HomeCare 100382",
    			"HomeCare 100383",
    			"HomeCare 100384",
    			"HomeCare 100 And PAndD393",
    			"HomeCare 100 And PAndD394",
    			"HomeCare 100 And PAndD395",
    			"HomeCare 100 And HEC414",
    			"HomeCare 100 And HEC415",
    			"HomeCare 100 And HEC416",
    			"HomeCare 100 And HEC417",
    			"HomeCare 100 And PAndD And HEC438",
    			"HomeCare 100 And PAndD And HEC439",
    			"HomeCare 100 And PAndD And HEC440",
    			"HomeCare 200 And HEC477",
    			"HomeCare 200 And HEC478",
    			"HomeCare 200 And HEC479",
    			"HomeCare 200 And HEC480",
    			"HomeCare 200 And PAndD And HEC501",
    			"HomeCare 200 And PAndD And HEC502",
    			"HomeCare 200 And PAndD And HEC503",
    			"HomeCare 200 And PAndD And HEC504",
    			"HomeCare 200 And PAndD And HEC505",
    			"HomeCare 200 And PAndD And HEC506",
    			"HomeCare 200 And PAndD And HEC507",
    			"HomeCare 200546",
    			"HomeCare 200547",
    			"HomeCare 200548",
    			"HomeCare 200549",

			
    	};
    			

    			


    			    	
    	
    	return aaa;
    	
    	}
    

    private String[] halfRegression() {
    	
    	String[] xxxx = {"Boiler And controls breakdown1",
    			"Boiler And controls breakdown2",
    			"Boiler And controls breakdown3",
    			"Boiler And controls breakdown4",
   			    "Boiler And controls breakdown5",
    			"Boiler And controls breakdown6",
    			"Boiler And controls breakdown And PAndD7",
    			"Boiler And controls breakdown And PAndD8",
    			"Boiler And controls breakdown And PAndD9",
    			"Boiler And controls breakdown And PAndD10",
    			"Boiler And controls breakdown And PAndD11",
    			"Boiler And controls breakdown And PAndD12",
    			"Boiler And controls breakdown And PAndD13",
    			"Boiler And controls breakdown And PAndD14",
    			"Boiler And controls breakdown And PAndD15",
    			"Boiler And controls breakdown And PAndD16",
    			"Boiler And controls breakdown And PAndD17",
    			"Boiler And controls breakdown And PAndD18",
    			"Boiler And controls breakdown And HEC19",
    			"Boiler And controls breakdown And HEC20",
    			"Boiler And controls breakdown And HEC21",
    			"Boiler And controls breakdown And HEC22",
    			"Boiler And controls breakdown And HEC23",
    	       	"Boiler And controls breakdown And HEC24",
    			"Boiler And controls breakdown And HEC25",
    			"Boiler And controls breakdown And HEC26",
    			"Boiler And controls breakdown And HEC27",
    			"Boiler And controls breakdown And HEC28",
    			"Boiler And controls breakdown And HEC29",
    			"Boiler And controls breakdown And HEC30",
    			"Boiler And controls breakdown And PAndD And HEC31",
    			"Boiler And controls breakdown And PAndD And HEC32",
    			"Boiler And controls breakdown And PAndD And HEC33",
    			"Boiler And controls breakdown And PAndD And HEC34",
    			"Boiler And controls breakdown And PAndD And HEC35",
    			"Boiler And controls breakdown And PAndD And HEC36",
    			"Boiler And controls breakdown And PAndD And HEC37",
    			"Boiler And controls breakdown And PAndD And HEC38",
    			"Boiler And controls breakdown And PAndD And HEC39",
    			"Boiler And controls breakdown And PAndD And HEC40",
    			"Boiler And controls breakdown And PAndD And HEC41",
    			"Boiler And controls breakdown And PAndD And HEC42",
    			"Boiler And controls breakdown And PAndD And HEC43",
    			"Boiler And controls breakdown And PAndD And HEC44",
    			"Boiler And controls breakdown And PAndD And HEC45",
    			"Boiler And controls breakdown And PAndD And HEC46",
    			"Boiler And controls breakdown And PAndD And HEC47",
    			"Boiler And controls breakdown And PAndD And HEC48",
    			"Boiler And controls breakdown And PAndD And HEC49",
    			"Boiler And controls breakdown And PAndD And HEC50",
    			"Boiler And controls breakdown And PAndD And HEC51",
    			"Boiler And controls breakdown And PAndD And HEC52",
    			"Boiler And controls breakdown And PAndD And HEC53",
    			"Boiler And controls breakdown And PAndD And HEC54",
    			"Boiler And controls breakdown And PAndD And HEC55",
    			"Boiler And controls breakdown And PAndD And HEC56",
    			"Boiler And controls breakdown And PAndD And HEC57",
    			"Boiler And controls breakdown And PAndD And HEC58",
    			"Boiler And controls breakdown And PAndD And HEC59",
    			"Boiler And controls breakdown And PAndD And HEC60",
    			"Boiler And controls breakdown And PAndD And HEC61",
    			"Boiler And controls breakdown And PAndD And HEC62",
    			"Boiler And controls breakdown And PAndD And HEC63",
    			"Boiler And controls breakdown And PAndD And HEC64",
    			"Boiler And controls breakdown And PAndD And HEC65",
    			"Boiler And controls breakdown And PAndD And HEC66",
    			"Boiler And controls breakdown And PAndD And HEC67",

    			"Boiler And controls breakdown And PAndD And HEC68",

    			"Boiler And controls breakdown And PAndD And HEC69",

    			"Boiler And controls breakdown And PAndD And HEC70",

    			"Boiler And controls breakdown And PAndD And HEC71",

    			"Boiler And controls breakdown And PAndD And HEC72",

    			"Boiler And controls breakdown And PAndD And HEC73",

    			"Boiler And controls breakdown And PAndD And HEC74",

    			"Boiler And controls breakdown And PAndD And HEC75",

    			"Boiler And controls breakdown And PAndD And HEC76",

    			"Boiler And controls breakdown And PAndD And HEC77",

    			"Boiler And controls breakdown And PAndD And HEC78",

    			"Boiler And controls breakdown And PAndD And HEC79",

    			"Boiler And controls breakdown And PAndD And HEC80",

    			"Boiler And controls breakdown And PAndD And HEC81",

    			"Boiler And controls breakdown And PAndD And HEC82",

    			"Boiler And controls breakdown And PAndD And HEC83",

    			"Boiler And controls breakdown And PAndD And HEC84",

    			"Boiler And controls breakdown And PAndD And HEC85",

    			"Boiler And controls breakdown And PAndD And HEC86",

    			"Boiler And controls breakdown And PAndD And HEC87",

    			"Boiler And controls breakdown And PAndD And HEC88",

    			"Boiler And controls breakdown And PAndD And HEC89",

    			"Boiler And controls breakdown And PAndD And HEC90",

    			"Boiler And controls breakdown And PAndD And HEC91",

    			"Boiler And controls breakdown And PAndD And HEC92",

    			"Boiler And controls breakdown And PAndD And HEC93",

    			"Boiler And controls breakdown And PAndD And HEC94",

    			"Boiler And controls breakdown And PAndD And HEC95",

    			"Boiler And controls breakdown And PAndD And HEC96",

    			"Boiler And controls breakdown And PAndD And HEC97",

    			"Boiler And controls breakdown And PAndD And HEC98",

    			"Boiler And controls breakdown And PAndD And HEC99",

    			"Boiler And controls breakdown And PAndD And HEC100",

    			"Boiler And controls breakdown And PAndD And HEC101",

    			"Boiler And controls breakdown And PAndD And HEC102",

    			"Boiler And controls breakdown And PAndD And HEC103",

    			"Boiler And controls breakdown And PAndD And HEC104",

    			"Boiler And controls breakdown And PAndD And HEC105",

    			"Boiler And controls breakdown And PAndD And HEC106",

    			"Boiler And controls breakdown And PAndD And HEC107",

    			"Boiler And controls breakdown And PAndD And HEC108",

    			"Boiler And controls breakdown And PAndD And HEC109",

    			"Boiler And controls breakdown And PAndD And HEC110",

    			"Boiler And controls breakdown And PAndD And HEC111",

    			"Central heating breakdown112",

    			"Central heating breakdown113",

    			"Central heating breakdown114",

    			"Central heating breakdown115",

    			"Central heating breakdown116",

    			"Central heating breakdown117",

    			"Cental heating breakdown And PAndD118",

    			"Cental heating breakdown And PAndD119",

    			"Cental heating breakdown And PAndD120",

    			"Cental heating breakdown And PAndD121",

    			"Cental heating breakdown And PAndD122",

    			"Cental heating breakdown And PAndD123",

    			"Cental heating breakdown And PAndD124",

    			"Cental heating breakdown And PAndD125",

    			"Cental heating breakdown And PAndD126",

    			"Cental heating breakdown And PAndD127",

    			"Cental heating breakdown And PAndD128",

    			"Cental heating breakdown And PAndD129",

    			"Cental heating breakdown And HEC130",

    			"Cental heating breakdown And HEC131",

    			"Cental heating breakdown And HEC132",

    			"Cental heating breakdown And HEC133",

    			"Cental heating breakdown And HEC134",

    			"Cental heating breakdown And HEC135",

    			"Cental heating breakdown And HEC136",

    			"Cental heating breakdown And HEC137",

    			"Cental heating breakdown And HEC138",

    			"Cental heating breakdown And HEC139",

    			"Cental heating breakdown And HEC140",

    			"Cental heating breakdown And HEC141",

    			"Cental heating breakdown And PAndD And HEC142",

    			"Cental heating breakdown And PAndD And HEC143",

    			"Cental heating breakdown And PAndD And HEC144",

    			"Cental heating breakdown And PAndD And HEC145",

    			"Cental heating breakdown And PAndD And HEC146",

    			"Cental heating breakdown And PAndD And HEC147",

    			"Cental heating breakdown And PAndD And HEC148",

    			"Cental heating breakdown And PAndD And HEC149",

    			"Cental heating breakdown And PAndD And HEC150",

    			"Cental heating breakdown And PAndD And HEC151",

    			"Cental heating breakdown And PAndD And HEC152",

    			"Cental heating breakdown And PAndD And HEC153",

    			"Cental heating breakdown And PAndD And HEC154",

    			"Cental heating breakdown And PAndD And HEC155",

    			"Cental heating breakdown And PAndD And HEC156",

    			"Cental heating breakdown And PAndD And HEC157",

    			"Cental heating breakdown And PAndD And HEC158",

    			"Cental heating breakdown And PAndD And HEC159",

    			"Cental heating breakdown And PAndD And HEC160",

    			"Cental heating breakdown And PAndD And HEC161",

    			"Cental heating breakdown And PAndD And HEC162",

    			"Cental heating breakdown And PAndD And HEC163",

    			"Cental heating breakdown And PAndD And HEC164",

    			"Cental heating breakdown And PAndD And HEC165",

    			"Cental heating breakdown And PAndD And HEC166",

    			"Cental heating breakdown And PAndD And HEC167",

    			"Cental heating breakdown And PAndD And HEC168",

    			"Cental heating breakdown And PAndD And HEC169",

    			"Cental heating breakdown And PAndD And HEC170",

    			"Cental heating breakdown And PAndD And HEC171",

    			"Cental heating breakdown And PAndD And HEC172",

    			"Cental heating breakdown And PAndD And HEC173",

    			"Cental heating breakdown And PAndD And HEC174",

    			"Cental heating breakdown And PAndD And HEC175",

    			"Cental heating breakdown And PAndD And HEC176",

    			"Cental heating breakdown And PAndD And HEC177",

    			"Cental heating breakdown And PAndD And HEC178",

    			"Cental heating breakdown And PAndD And HEC179",

    			"Cental heating breakdown And PAndD And HEC180",

    			"Cental heating breakdown And PAndD And HEC181",

    			"Cental heating breakdown And PAndD And HEC182",

    			"Cental heating breakdown And PAndD And HEC183",

    			"Cental heating breakdown And PAndD And HEC184",

    			"Cental heating breakdown And PAndD And HEC185",

    			"Cental heating breakdown And PAndD And HEC186",

    			"Cental heating breakdown And PAndD And HEC187",

    			"Cental heating breakdown And PAndD And HEC188",

    			"Cental heating breakdown And PAndD And HEC189",

    			"Cental heating breakdown And PAndD And HEC190",

    			"Cental heating breakdown And PAndD And HEC191",

    			"Cental heating breakdown And PAndD And HEC192",

    			"Cental heating breakdown And PAndD And HEC193",

    			"Cental heating breakdown And PAndD And HEC194",

    			"Cental heating breakdown And PAndD And HEC195",

    			"Cental heating breakdown And PAndD And HEC196",

    			"Cental heating breakdown And PAndD And HEC197",

    			"Cental heating breakdown And PAndD And HEC198",

    			"Cental heating breakdown And PAndD And HEC199",

    			"Cental heating breakdown And PAndD And HEC200",

    			"Cental heating breakdown And PAndD And HEC201",

    			"Cental heating breakdown And PAndD And HEC202",

    			"Cental heating breakdown And PAndD And HEC203",

    			"Cental heating breakdown And PAndD And HEC204",

    			"Cental heating breakdown And PAndD And HEC205",

    			"Cental heating breakdown And PAndD And HEC206",

    			"Cental heating breakdown And PAndD And HEC207",

    			"Cental heating breakdown And PAndD And HEC208",

    			"Cental heating breakdown And PAndD And HEC209",

    			"Cental heating breakdown And PAndD And HEC210",

    			"Cental heating breakdown And PAndD And HEC211",

    			"Cental heating breakdown And PAndD And HEC212",

    			"Cental heating breakdown And PAndD And HEC213",

    			"Cental heating breakdown And PAndD And HEC214",

    			"Cental heating breakdown And PAndD And HEC215",

    			"Cental heating breakdown And PAndD And HEC216",

    			"Cental heating breakdown And PAndD And HEC217",

    			"Cental heating breakdown And PAndD And HEC218",

    			"Cental heating breakdown And PAndD And HEC219",

    			"Cental heating breakdown And PAndD And HEC220",

    			"Cental heating breakdown And PAndD And HEC221",

    			"Cental heating breakdown And PAndD And HEC222",

    			"HomeCare 100223",

    			"HomeCare 100224",

    			"HomeCare 100225",

    			"HomeCare 100226",

    			"HomeCare 100227",

    			"HomeCare 100228",

    			"HomeCare 100229",

    			"HomeCare 100230",

    			"HomeCare 100231",

    			"HomeCare 100232",

    			"HomeCare 100233",

    			"HomeCare 100234",

    			"HomeCare 100235",

    			"HomeCare 100236",

    			"HomeCare 100237",

    			"HomeCare 100238",

    			"HomeCare 100239",

    			"HomeCare 100240",

    			"HomeCare 100241",

    			"HomeCare 100242",

    			"HomeCare 100243",

    			"HomeCare 100244",

    			"HomeCare 100245",

    			"HomeCare 100246",

    			"HomeCare 100 And PAndD247",

    			"HomeCare 100 And PAndD248",

    			"HomeCare 100 And PAndD249",

    			"HomeCare 100 And PAndD250",

    			"HomeCare 100 And PAndD251",

    			"HomeCare 100 And PAndD252",

    			"HomeCare 100 And PAndD253",

    			"HomeCare 100 And PAndD254",

    			"HomeCare 100 And PAndD255",

    			"HomeCare 100 And PAndD256",

    			"HomeCare 100 And PAndD257",

    			"HomeCare 100 And PAndD258",

    			"HomeCare 100 And PAndD259",

    			"HomeCare 100 And PAndD260",

    			"HomeCare 100 And PAndD261",

    			"HomeCare 100 And PAndD262",

    			"HomeCare 100 And PAndD263",

    			"HomeCare 100 And PAndD264",

    			"HomeCare 100 And PAndD265",

    			"HomeCare 100 And PAndD266",

    			"HomeCare 100 And PAndD267",

    			"HomeCare 100 And PAndD268",

    			"HomeCare 100 And PAndD269",

    			"HomeCare 100 And PAndD270",

    			"HomeCare 100 And PAndD271",

    			"HomeCare 100 And PAndD272",

    			"HomeCare 100 And PAndD273",

    			"HomeCare 100 And PAndD274",

    			"HomeCare 100 And PAndD275",

    			"HomeCare 100 And PAndD276",

    			"HomeCare 100 And PAndD277",

    			"HomeCare 100 And PAndD278",

    			"HomeCare 100 And PAndD279",

    			"HomeCare 100 And PAndD280",

    			"HomeCare 100 And PAndD281",

    			"HomeCare 100 And PAndD282",

    			"HomeCare 100 And PAndD283",

    			"HomeCare 100 And PAndD284",

    			"HomeCare 100 And PAndD285",

    			"HomeCare 100 And PAndD286",

    			"HomeCare 100 And PAndD287",

    			"HomeCare 100 And PAndD288",

    			"HomeCare 100 And PAndD289",

    			"HomeCare 100 And PAndD290",

    			"HomeCare 100 And PAndD291",

    			"HomeCare 100 And PAndD292",

    			"HomeCare 100 And PAndD293",

    			"HomeCare 100 And PAndD294",

    			"HomeCare 100 And HEC295",

    			"HomeCare 100 And HEC296",

    			"HomeCare 100 And HEC297",

    			"HomeCare 100 And HEC298",

    			"HomeCare 100 And HEC299",

    			"HomeCare 100 And HEC300",

    			"HomeCare 100 And HEC301",

    			"HomeCare 100 And HEC302",

    			"HomeCare 100 And HEC303",

    			"HomeCare 100 And HEC304",

    			"HomeCare 100 And HEC305",

    			"HomeCare 100 And HEC306",

    			"HomeCare 100 And HEC307",

    			"HomeCare 100 And HEC308",

    			"HomeCare 100 And HEC309",

    			"HomeCare 100 And HEC310",

    			"HomeCare 100 And HEC311",

    			"HomeCare 100 And HEC312",

    			"HomeCare 100 And HEC313",

    			"HomeCare 100 And HEC314",

    			"HomeCare 100 And HEC315",

    			"HomeCare 100 And HEC316",

    			"HomeCare 100 And HEC317",

    			"HomeCare 100 And HEC318",

    			"HomeCare 100 And HEC319",

    			"HomeCare 100 And HEC320",

    			"HomeCare 100 And HEC321",

    			"HomeCare 100 And HEC322",

    			"HomeCare 100 And HEC323",

    			"HomeCare 100 And HEC324",

    			"HomeCare 100 And HEC325",

    			"HomeCare 100 And HEC326",

    			"HomeCare 100 And HEC327",

    			"HomeCare 100 And HEC328",

    			"HomeCare 100 And HEC329",

    			"HomeCare 100 And HEC330",

    			"HomeCare 100 And HEC331",

    			"HomeCare 100 And HEC332",

    			"HomeCare 100 And HEC333",

    			"HomeCare 100 And HEC334",

    			"HomeCare 100 And HEC335",

    			"HomeCare 100 And HEC336",

    			"HomeCare 100 And HEC337",

    			"HomeCare 100 And HEC338",

    			"HomeCare 100 And HEC339",

    			"HomeCare 100 And HEC340",

    			"HomeCare 100 And HEC341",

    			"HomeCare 100 And HEC342",

    			"HomeCare 100 And PAndD And HEC343",

    			"HomeCare 100 And PAndD And HEC344",

    			"HomeCare 100 And PAndD And HEC345",

    			"HomeCare 100 And PAndD And HEC346",

    			"HomeCare 100 And PAndD And HEC347",

    			"HomeCare 100 And PAndD And HEC348",

    			"HomeCare 100 And PAndD And HEC349",

    			"HomeCare 100 And PAndD And HEC350",

    			"HomeCare 100 And PAndD And HEC351",

    			"HomeCare 100 And PAndD And HEC352",

    			"HomeCare 100 And PAndD And HEC353",

    			"HomeCare 100 And PAndD And HEC354",

    			"HomeCare 100 And PAndD And HEC355",

    			"HomeCare 100 And PAndD And HEC356",

    			"HomeCare 100 And PAndD And HEC357",

    			"HomeCare 100 And PAndD And HEC358",

    			"HomeCare 100 And PAndD And HEC359",

    			"HomeCare 100 And PAndD And HEC360",

    			"HomeCare 100 And PAndD And HEC361",

    			"HomeCare 100 And PAndD And HEC362",

    			"HomeCare 100 And PAndD And HEC363",

    			"HomeCare 100 And PAndD And HEC364",

    			"HomeCare 100 And PAndD And HEC365",

    			"HomeCare 100 And PAndD And HEC366",

    			"HomeCare 100 And PAndD And HEC367",

    			"HomeCare 100 And PAndD And HEC368",

    			"HomeCare 100 And PAndD And HEC369",

    			"HomeCare 100 And PAndD And HEC370",

    			"HomeCare 100 And PAndD And HEC371",

    			"HomeCare 100 And PAndD And HEC372",

    			"HomeCare 100 And PAndD And HEC373",

    			"HomeCare 100 And PAndD And HEC374",

    			"HomeCare 100 And PAndD And HEC375",

    			"HomeCare 100 And PAndD And HEC376",

    			"HomeCare 100 And PAndD And HEC377",

    			"HomeCare 100 And PAndD And HEC378",

    			"HomeCare 100 And PAndD And HEC379",

    			"HomeCare 100 And PAndD And HEC380",

    			"HomeCare 100 And PAndD And HEC381",

    			"HomeCare 100 And PAndD And HEC382",

    			"HomeCare 100 And PAndD And HEC383",

    			"HomeCare 100 And PAndD And HEC384",

    			"HomeCare 100 And PAndD And HEC385",

    			"HomeCare 100 And PAndD And HEC386",

    			"HomeCare 100 And PAndD And HEC387",

    			"HomeCare 100 And PAndD And HEC388",

    			"HomeCare 100 And PAndD And HEC389",

    			"HomeCare 100 And PAndD And HEC390",

    			"HomeCare 200 And PAndD391",

    			"HomeCare 200 And PAndD392",

    			"HomeCare 200 And PAndD393",

    			"HomeCare 200 And PAndD394",

    			"HomeCare 200 And PAndD395",

    			"HomeCare 200 And PAndD396",

    			"HomeCare 200 And PAndD397",

    			"HomeCare 200 And PAndD398",

    			"HomeCare 200 And PAndD399",

    			"HomeCare 200 And PAndD400",

    			"HomeCare 200 And PAndD401",

    			"HomeCare 200 And PAndD402",

    			"HomeCare 200 And PAndD403",

    			"HomeCare 200 And PAndD404",

    			"HomeCare 200 And PAndD405",

    			"HomeCare 200 And PAndD406",

    			"HomeCare 200 And PAndD407",

    			"HomeCare 200 And PAndD408",

    			"HomeCare 200 And PAndD409",

    			"HomeCare 200 And PAndD410",

    			"HomeCare 200 And PAndD411",

    			"HomeCare 200 And PAndD412",

    			"HomeCare 200 And PAndD413",

    			"HomeCare 200 And PAndD414",

    			"HomeCare 200 And PAndD415",

    			"HomeCare 200 And PAndD416",

    			"HomeCare 200 And PAndD417",

    			"HomeCare 200 And PAndD418",

    			"HomeCare 200 And PAndD419",

    			"HomeCare 200 And PAndD420",

    			"HomeCare 200 And PAndD421",

    			"HomeCare 200 And PAndD422",

    			"HomeCare 200 And PAndD423",

    			"HomeCare 200 And PAndD424",

    			"HomeCare 200 And PAndD425",

    			"HomeCare 200 And PAndD426",

    			"HomeCare 200 And PAndD427",

    			"HomeCare 200 And PAndD428",

    			"HomeCare 200 And PAndD429",

    			"HomeCare 200 And PAndD430",

    			"HomeCare 200 And PAndD431",

    			"HomeCare 200 And HEC432",

    			"HomeCare 200 And HEC433",

    			"HomeCare 200 And HEC434",

    			"HomeCare 200 And HEC435",

    			"HomeCare 200 And HEC436",

    			"HomeCare 200 And HEC437",

    			"HomeCare 200 And HEC438",

    			"HomeCare 200 And HEC439",

    			"HomeCare 200 And HEC440",

    			"HomeCare 200 And HEC441",

    			"HomeCare 200 And HEC442",

    			"HomeCare 200 And HEC443",

    			"HomeCare 200 And HEC444",

    			"HomeCare 200 And HEC445",

    			"HomeCare 200 And HEC446",

    			"HomeCare 200 And HEC447",

    			"HomeCare 200 And HEC448",

    			"HomeCare 200 And HEC449",

    			"HomeCare 200 And HEC450",

    			"HomeCare 200 And HEC451",

    			"HomeCare 200 And HEC452",

    			"HomeCare 200 And HEC453",

    			"HomeCare 200 And HEC454",

    			"HomeCare 200 And HEC455",

    			"HomeCare 200 And HEC456",

    			"HomeCare 200 And HEC457",

    			"HomeCare 200 And HEC458",

    			"HomeCare 200 And HEC459",

    			"HomeCare 200 And HEC460",

    			"HomeCare 200 And HEC461",

    			"HomeCare 200 And HEC462",

    			"HomeCare 200 And HEC463",

    			"HomeCare 200 And HEC464",

    			"HomeCare 200 And HEC465",

    			"HomeCare 200 And HEC466",

    			"HomeCare 200 And HEC467",

    			"HomeCare 200 And HEC468",

    			"HomeCare 200 And HEC469",

    			"HomeCare 200 And HEC470",

    			"HomeCare 200 And HEC471",

    			"HomeCare 200 And HEC472",

    			"HomeCare 200 And HEC473",

    			"HomeCare 200 And HEC474",

    			"HomeCare 200 And HEC475",

    			"HomeCare 200 And HEC476",

    			"HomeCare 200 And HEC477",

    			"HomeCare 200 And HEC478",

    			"HomeCare 200 And HEC479",

    			"HomeCare 200 And PAndD And HEC480",

    			"HomeCare 200 And PAndD And HEC481",

    			"HomeCare 200 And PAndD And HEC482",

    			"HomeCare 200 And PAndD And HEC483",

    			"HomeCare 200 And PAndD And HEC484",

    			"HomeCare 200 And PAndD And HEC485",

    			"HomeCare 200 And PAndD And HEC486",

    			"HomeCare 200 And PAndD And HEC487",

    			"HomeCare 200 And PAndD And HEC488",

    			"HomeCare 200 And PAndD And HEC489",

    			"HomeCare 200 And PAndD And HEC490",

    			"HomeCare 200 And PAndD And HEC491",

    			"HomeCare 200 And PAndD And HEC492",

    			"HomeCare 200 And PAndD And HEC493",

    			"HomeCare 200 And PAndD And HEC494",

    			"HomeCare 200 And PAndD And HEC495",

    			"HomeCare 200 And PAndD And HEC496",

    			"HomeCare 200 And PAndD And HEC497",

    			"HomeCare 200 And PAndD And HEC498",

    			"HomeCare 200 And PAndD And HEC499",

    			"HomeCare 200 And PAndD And HEC500",

    			"HomeCare 200 And PAndD And HEC501",

    			"HomeCare 200 And PAndD And HEC502",

    			"HomeCare 200 And PAndD And HEC503",

    			"HomeCare 200 And PAndD And HEC504",

    			"HomeCare 200 And PAndD And HEC505",

    			"HomeCare 200 And PAndD And HEC506",

    			"HomeCare 200 And PAndD And HEC507",

    			"HomeCare 200 And PAndD And HEC508",

    			"HomeCare 200 And PAndD And HEC509",

    			"HomeCare 200 And PAndD And HEC510",

    			"HomeCare 200 And PAndD And HEC511",

    			"HomeCare 200 And PAndD And HEC512",

    			"HomeCare 200 And PAndD And HEC513",

    			"HomeCare 200 And PAndD And HEC514",

    			"HomeCare 200 And PAndD And HEC515",

    			"HomeCare 200 And PAndD And HEC516",

    			"HomeCare 200 And PAndD And HEC517",

    			"HomeCare 200 And PAndD And HEC518",

    			"HomeCare 200 And PAndD And HEC519",

    			"HomeCare 200 And PAndD And HEC520",

    			"HomeCare 200 And PAndD And HEC521",

    			"HomeCare 200 And PAndD And HEC522",

    			"HomeCare 200 And PAndD And HEC523",

    			"HomeCare 200 And PAndD And HEC524",

    			"HomeCare 200 And PAndD And HEC525",

    			"HomeCare 200 And PAndD And HEC526",

    			"HomeCare 200 And PAndD And HEC527",

    			"HomeCare 200 And PAndD And HEC528",

    			"HomeCare 200 And PAndD And HEC529",

    			"HomeCare 200 And PAndD And HEC530",

    			"HomeCare 200 And PAndD And HEC531",

    			"HomeCare 200 And PAndD And HEC532",

    			"HomeCare 200 And PAndD And HEC533",

    			"HomeCare 200 And PAndD And HEC534",

    			"HomeCare 200 And PAndD And HEC535",

    			"HomeCare 200 And PAndD And HEC536",

    			"HomeCare 200 And PAndD And HEC537",

    			"HomeCare 200 And PAndD And HEC538",

    			"HomeCare 200 And PAndD And HEC539",

    			"HomeCare 200 And PAndD And HEC540",

    			"HomeCare 200 And PAndD And HEC541",

    			"HomeCare 200 And PAndD And HEC542",

    			"HomeCare 200 And PAndD And HEC543",

    			"HomeCare 200 And PAndD And HEC544",

    			"HomeCare 200 And PAndD And HEC545",

    			"HomeCare 200 And PAndD And HEC546",

    			"HomeCare 200 And PAndD And HEC547",

    			"HomeCare 200 And PAndD And HEC548",

    			"HomeCare 200 And PAndD And HEC549",

    			"HomeCare 200 And PAndD And HEC550",

    			"HomeCare 200 And PAndD And HEC551",

    			"HomeCare 200 And PAndD And HEC552",

    			"HomeCare 200 And PAndD And HEC553",

    			"HomeCare 200 And PAndD And HEC554",

    			"HomeCare 200 And PAndD And HEC555",

    			"HomeCare 200 And PAndD And HEC556",

    			"HomeCare 200 And PAndD And HEC557",

    			"HomeCare 200 And PAndD And HEC558",

    			"HomeCare 200 And PAndD And HEC559",

    			"HomeCare 200 And PAndD And HEC560",

    			"HomeCare 200 And PAndD And HEC561",

    			"HomeCare 200 And PAndD And HEC562",

    			"HomeCare 200 And PAndD And HEC563",

    			"HomeCare 200 And PAndD And HEC564",

    			"HomeCare 200 And PAndD And HEC565",

    			"HomeCare 200 And PAndD And HEC566",

    			"HomeCare 200 And PAndD And HEC567",

    			"HomeCare 200 And PAndD And HEC568",

    			"HomeCare 200 And PAndD And HEC569",

    			"HomeCare 200 And PAndD And HEC570",

    			"HomeCare 200 And PAndD And HEC571",

    			"HomeCare 200 And PAndD And HEC572",

    			"HomeCare 200 And PAndD And HEC573",

    			"HomeCare 200 And PAndD And HEC574",

    			"HomeCare 200 And PAndD And HEC575",

    			"HomeCare 200576",

    			"HomeCare 200577",

    			"HomeCare 200578",

    			"HomeCare 200579",

    			"HomeCare 200580",

    			"HomeCare 200581",

    			"HomeCare 200582",

    			"HomeCare 200583",

    			"HomeCare 200584",

    			"HomeCare 200585",

    			"HomeCare 200586",

    			"HomeCare 200587",

    			"HomeCare 200588",

    			"HomeCare 200589",

    			"HomeCare 200590",

    			"HomeCare 200591",

    			"HomeCare 200592",

    			"HomeCare 200593",

    			"HomeCare 200594",

    			"HomeCare 200595",

    			"HomeCare 200596",

    			"HomeCare 200597",

    			"HomeCare 200598",

    			"HomeCare 200599",

    			"Plumbing and drains1600",

    			"Plumbing and drains1601",

    			"Plumbing and drains2602",

    			"Plumbing and drains2603",

    			"Plumbing and drains And Home electrics1604",

    			"Plumbing and drains And Home electrics1605",

    			"Plumbing and drains And Home electrics2606",

    			"Plumbing and drains And Home electrics2607",
    			"Home electrics1608",
    			"Home electrics1609",
    			"Home electrics2610",
    			"Home electrics2611"};
               
        return xxxx();
    }

    private String[] xxxx() {

        String[] xxx = {"Boilexr And controls breakdown1",
                "Boiler And controls breakdown2",
                "Boiler And controls breakdown3",
                "Boiler And controls breakdown And PAndD1",
                "Boiler And controls breakdown And PAndD2",
                "Boiler And controls breakdown And PAndD3",
                "Boiler And controls breakdown And PAndD4",
                "Boiler And controls breakdown And PAndD5",
                "Boiler And controls breakdown And PAndD6",
                "Boiler And controls breakdown And HEC1",
                "Boiler And controls breakdown And HEC2",
                "Boiler And controls breakdown And HEC3",
                "Boiler And controls breakdown And HEC4",
                "Boiler And controls breakdown And HEC5",
                "Boiler And controls breakdown And HEC6",
                "Boiler And controls breakdown And PAndD And HEC1",
                "Boiler And controls breakdown And PAndD And HEC2",
                "Boiler And controls breakdown And PAndD And HEC3",
                "Boiler And controls breakdown And PAndD And HEC4",
                "Boiler And controls breakdown And PAndD And HEC5",
                "Boiler And controls breakdown And PAndD And HEC6",
                "Boiler And controls breakdown And PAndD And HEC7",
                "Boiler And controls breakdown And PAndD And HEC8",
                "Boiler And controls breakdown And PAndD And HEC9",
                "Boiler And controls breakdown And PAndD And HEC10",
                "Boiler And controls breakdown And PAndD And HEC11",
                "Boiler And controls breakdown And PAndD And HEC12",
                "Boiler And controls breakdown And PAndD And HEC13",
                "Boiler And controls breakdown And PAndD And HEC14",
                "Boiler And controls breakdown And PAndD And HEC15",
                "Boiler And controls breakdown And PAndD And HEC16",
                "Boiler And controls breakdown And PAndD And HEC17",
                "Boiler And controls breakdown And PAndD And HEC18",
                "Boiler And controls breakdown And PAndD And HEC19",
                "Boiler And controls breakdown And PAndD And HEC20",
                "Boiler And controls breakdown And PAndD And HEC21",
                "Boiler And controls breakdown And PAndD And HEC22",
                "Boiler And controls breakdown And PAndD And HEC23",
                "Boiler And controls breakdown And PAndD And HEC24",
                "Boiler And controls breakdown And PAndD And HEC25",
                "Boiler And controls breakdown And PAndD And HEC26",
                "Boiler And controls breakdown And PAndD And HEC27",
                "Boiler And controls breakdown And PAndD And HEC28",
                "Boiler And controls breakdown And PAndD And HEC29",
                "Boiler And controls breakdown And PAndD And HEC30",
                "Boiler And controls breakdown And PAndD And HEC31",
                "Boiler And controls breakdown And PAndD And HEC32",
                "Boiler And controls breakdown And PAndD And HEC33",
                "Boiler And controls breakdown And PAndD And HEC34",
                "Boiler And controls breakdown And PAndD And HEC35",
                "Boiler And controls breakdown And PAndD And HEC36",
                "Boiler And controls breakdown And PAndD And HEC37",
                "Boiler And controls breakdown And PAndD And HEC38",
                "Boiler And controls breakdown And PAndD And HEC39",
                "HomeCare 1001",
                "HomeCare 1002",
                "HomeCare 1003",
                "HomeCare 100 And PAndD1",
                "HomeCare 100 And PAndD2",
                "HomeCare 100 And PAndD3",
                "HomeCare 100 And PAndD4",
                "HomeCare 100 And PAndD5",
                "HomeCare 100 And PAndD6",
                "HomeCare 100 And HEC1",
                "HomeCare 100 And HEC2",
                "HomeCare 100 And HEC3",
                "HomeCare 100 And HEC4",
                "HomeCare 100 And HEC5",
                "HomeCare 100 And HEC6",
                "HomeCare 100 And PAndD And HEC1",
                "HomeCare 100 And PAndD And HEC2",
                "HomeCare 100 And PAndD And HEC3",
                "HomeCare 100 And PAndD And HEC4",
                "HomeCare 100 And PAndD And HEC5",
                "HomeCare 100 And PAndD And HEC6",
                "Central heating breakdown1",
                "Central heating breakdown2",
                "Central heating breakdown3",
                "Cental heating breakdown And PAndD1",
                "Cental heating breakdown And PAndD2",
                "Cental heating breakdown And PAndD3",
                "Cental heating breakdown And PAndD4",
                "Cental heating breakdown And PAndD5",
                "Cental heating breakdown And PAndD6",
                "Cental heating breakdown And HEC1",
                "Cental heating breakdown And HEC2",
                "Cental heating breakdown And HEC3",
                "Cental heating breakdown And HEC4",
                "Cental heating breakdown And HEC5",
                "Cental heating breakdown And HEC6",
                "Cental heating breakdown And PAndD And HEC1",
                "Cental heating breakdown And PAndD And HEC2",
                "Cental heating breakdown And PAndD And HEC3",
                "Cental heating breakdown And PAndD And HEC4",
                "Cental heating breakdown And PAndD And HEC5",
                "Cental heating breakdown And PAndD And HEC6",
                "HomeCare 2001",
                "HomeCare 2002",
                "HomeCare 2003",
                "HomeCare 200 And PAndD1",
                "HomeCare 200 And PAndD2",
                "HomeCare 200 And PAndD3",
                "HomeCare 200 And PAndD4",
                "HomeCare 200 And PAndD5",
                "HomeCare 200 And PAndD6",
                "HomeCare 200 And HEC1",
                "HomeCare 200 And HEC2",
                "HomeCare 200 And HEC3",
                "HomeCare 200 And HEC4",
                "HomeCare 200 And HEC5",
                "HomeCare 200 And HEC6",
                "HomeCare 200 And PAndD And HEC1",
                "HomeCare 200 And PAndD And HEC2",
                "HomeCare 200 And PAndD And HEC3",
                "HomeCare 200 And PAndD And HEC4",
                "HomeCare 200 And PAndD And HEC5",
                "HomeCare 200 And PAndD And HEC6",
                "HomeCare 200 And PAndD And HEC7",
                "HomeCare 200 And PAndD And HEC8",
                "HomeCare 200 And PAndD And HEC9",
                "HomeCare 200 And PAndD And HEC10",
                "HomeCare 200 And PAndD And HEC11",
                "HomeCare 200 And PAndD And HEC12",
                "HomeCare 200 And PAndD And HEC13",
                "HomeCare 200 And PAndD And HEC14",
                "HomeCare 200 And PAndD And HEC15",
                "HomeCare 200 And PAndD And HEC16",
                "HomeCare 200 And PAndD And HEC17",
                "HomeCare 200 And PAndD And HEC18",
                "HomeCare 200 And PAndD And HEC19",
                "HomeCare 200 And PAndD And HEC20",
                "HomeCare 200 And PAndD And HEC21",
                "HomeCare 200 And PAndD And HEC22",
                "HomeCare 200 And PAndD And HEC23",
                "HomeCare 200 And PAndD And HEC24",
                "HomeCare 200 And PAndD And HEC25",
                "HomeCare 200 And PAndD And HEC26",
                "HomeCare 200 And PAndD And HEC27",
                "HomeCare 200 And PAndD And HEC28",
                "HomeCare 200 And PAndD And HEC29",
                "HomeCare 200 And PAndD And HEC30",
                "HomeCare 200 And PAndD And HEC31",
                "HomeCare 200 And PAndD And HEC32",
                "HomeCare 200 And PAndD And HEC33",
                "HomeCare 200 And PAndD And HEC34",
                "HomeCare 200 And PAndD And HEC35",
                "HomeCare 200 And PAndD And HEC36",
                "HomeCare 200 And PAndD And HEC37",
                "HomeCare 200 And PAndD And HEC38",
                "HomeCare 200 And PAndD And HEC39",
                "Plumbing and drains1",
                "Plumbing and drains2",
                "Plumbing and drains And Home electrics1",
                "Plumbing and drains And Home electrics2",
                "Home electrics1",
                "Home electrics2"};
        return xxx;
    }
}
