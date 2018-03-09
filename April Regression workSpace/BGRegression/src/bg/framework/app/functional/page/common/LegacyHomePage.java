package bg.framework.app.functional.page.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Properties;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.page.reFactoring.RegistrationPage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

import java.util.ArrayList;
import java.util.Properties;

public class LegacyHomePage extends BasePage {
    private final static String FILE_NAME = "resources/common/" + ApplicationConfig.BRAND
           + "HomePage.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
      	File Sofile = new File(Service_Order_FILE_NAME);

	private final static String Service_Order_FILE_NAME = "C:\\Documents and Settings\\mathuric\\Desktop\\workspace\\BGRegression\\src\\resources\\bgmo_oab\\booking\\ServiceOrderNumber.txt";    

    public void navigateToLogout() {
        if(browser.isElementVisibleWithXpath(".//*[@id='loggedin']/div/p[3]/a/span")) {
            browser.clickWithXpath(".//*[@id='loggedin']/div/p[3]/a/span");
            browser.wait(getWaitTime());
            browser.open(ApplicationConfig.APP_BG_URL);
        }
        
        browser.wait(getWaitTime());
    
    }
    
    public void navigateToLoginMAPDeepLink(){
    	browser.open(ApplicationConfig.APP_BG_URL+"/makeapayment?cid=dplnkpayment");
    	
    }
    
	  public void logout(){
		  if(browser.isElementVisibleWithXpath("//*[@id='loggedin']/div/p[3]/span/a")) {
	          verifyAndClickWithXpath("//*[@id='loggedin']/div/p[3]/span/a","LogoutLink");
	          browser.wait(getWaitTime());
	      }
	  }
    
    
    public void navigateToLoginPage() {
    	/*//check whether logout link is available
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("HomePage.YourAccount"))){
    		verifyAndClickWithXpath(pageProperties.getProperty("HomePage.YourAccount"), "Logout Link Click");
    		Report.updateTestLog("Logout link Clicked", "Pass");
    	}
    	
    	//Click on the Login Link
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("HomePage.LoginPageLink"))){
    		verifyAndClickWithXpath(pageProperties.getProperty("HomePage.LoginPageLink"), "Login Link");
    		Report.updateTestLog("Login link clicked successfully", "Pass");
    	}
    	else{
    		Report.updateTestLog("Login link not Available", "Fail");
    	}*/
    	browser.open(ApplicationConfig.APP_BG_URL+"/Login/Login-Verify/");
    	browser.wait(getWaitTime());
    }
    
    public void navigateToLoginServiceDeepLink(){
    	browser.open(ApplicationConfig.APP_BG_URL+"/my-services/");
    	
    }
    public void navigateToLoginIBDeepLink(){
    	browser.open(ApplicationConfig.APP_BG_URL+"/breakdown/");
    	
    }
    public void navigateYourAccLoginPage(){
    	if (browser.isElementVisibleWithXpath(pageProperties.getProperty("HomePage.YourAccount"))) {
            browser.clickWithXpath(pageProperties.getProperty("HomePage.YourAccount"));
            Report.updateTestLog("Login Link is Selected Successfully ", "PASS");
        } 
        
        browser.wait(getWaitTime());
    }

    public void navigateToContactUsPage() {
        //if (browser.isTextPresent(pageProperties.getProperty("HomePage.ContactUs"))) {
        browser.clickWithXpath(pageProperties.getProperty("HomePage.ContactUs"));
        //}
        browser.wait(getWaitTime());
    }

    public void navigateToGetAQuotePage() {
        // browser.open(ApplicationConfig.GAP_URL);
        // if
        // (browser.isTextPresent(pageProperties.getProperty("HomePage.ContactUs"))){
        // browser.clickWithLinkText(pageProperties.getProperty("HomePage.ContactUs"));
        // }
        browser.wait(getWaitTime());
    }

    public void navigateToOurTariffsPage() {
        System.out.println(pageProperties.getProperty("HomePage.CompareTariffs"));
        if (browser.isTextPresent(pageProperties.getProperty("HomePage.CompareTariffs"))) {
            browser.clickWithLinkText(pageProperties
                    .getProperty("HomePage.CompareTariffs"));
            Report.updateTestLog("Navigate to our tariff page", "PASS");
        } else {
            Report.updateTestLog("Navigate to our tariff page", "FAIL");
        }
        browser.wait(getWaitTime());
    }

    public void navigateToNewBoilers() {
    	
    	verifyAndClickWithXpath(pageProperties.getProperty("HomePage.ProductsAndServices"), "Product and Services link");
    	try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
		}
    	verifyAndClickWithLinkText(pageProperties.getProperty("HomePage.NewBoilerLink"), "New Boilers link");
    	   	
       
    }
    
	 public void navigateToRequestCallBack() {
	    	
			verifyAndClickWithXpath(pageProperties.getProperty("HomePage.RequestACallBack"), "Request A Call Back Link");
	       
	    }
	 public void navigateToBookApp() {
	    	
		 verifyAndClickWithLinkText(pageProperties.getProperty("HomePage.BookAnApp"), "Book Appoinment Link");
	       
	    }
    public void navigateToProductsAndServicesPage() {
        browser.wait(getWaitTime());
        
        if (ApplicationConfig.BRAND.equalsIgnoreCase("fusion")) {
        	
        	if (browser.isElementVisibleWithXpath(pageProperties.getProperty("HomePage.ProductsAndServices"))) {
                browser.clickWithXpath(pageProperties.getProperty("HomePage.ProductsAndServices"));
                Report.updateTestLog("Products And Services Link is Selected Successfully ", "PASS");
            } else {
                Report.updateTestLog("Navigate to Gas and Elecrticity page", "FAIL");	
        
            }
        }
        
        else if (ApplicationConfig.BRAND.equalsIgnoreCase("bg")) {
           	
      	  if (browser.isTextPresent(pageProperties.getProperty("HomePage.Energy"))) {
                browser.clickWithLinkText(pageProperties.getProperty("HomePage.Energy"));

                Report.updateTestLog("Navigate to Energy tariff page", "PASS");
            } else {

                Report.updateTestLog("Navigate to Energy tariff page", "FAIL");
            }
            }      
        
    }

    public void navigateTOGasAndElectricityPage() {
    	if (ApplicationConfig.BRAND.equalsIgnoreCase("BG")) {
        verifyAndClickWithLinkText(pageProperties.getProperty("HomePage.Energy"), "Energy page");}
    		//verifyAndClickWithXpath(pageProperties.getProperty("HomePage.Energy"), "Energy page");}
    	else {
    		//verifyAndClickWithLinkText(pageProperties.getProperty("HomePage.Energy"), "Energy page");
    		verifyAndClickWithXpath(pageProperties.getProperty("HomePage.Energy"), "Energy page");}
    	//browser.open("http://10.224.70.85/apps/britishgas/components/energyshop/GET.servlet?tariffName=clear-and-simple&fuelType=dual&journeyTrigger=1&quoteId=1&nextPage=/content/britishgas/products-and-services/gas-and-electricity/energy-smart/orderenergy.html");
    }
    

    public void navigateToGetAPricePage() {

        if (ApplicationConfig.BRAND.equalsIgnoreCase("BG")) {
            if (browser.isTextPresent(pageProperties.getProperty("HomePage.GetAPrice"))) {
                browser.clickWithLinkText(pageProperties.getProperty("HomePage.GetAPrice"));
            }
            browser.wait(getWaitTime());
        } else {
            browser.open(ApplicationConfig.APP_FUSION_URL
                    + "/GetAQuote/");
        }
    }

    
    public void BgrnavigateToLoginPage() {
		browser.open(ApplicationConfig.APP_BG_URL+"/Login/Login-Verify/");
		
		browser.wait(getWaitTime());

	}
    public void navigateToSelfServeRegistrationPage() {
    	//if(browser.isElementVisibleWithLinkText("Register now")){
    	browser.open(ApplicationConfig.APP_BG_URL+"/identity/#/registration/details/email");
    		//verifyAndClickWithLinkText(pageProperties.getProperty("HomePage.RegisterationLink"), "Register now");
    //	}
    	/*else{
    		browser.open(ApplicationConfig.APP_BG_URL+"/Registration/Account-Details-Entry/Link/ID/Register/");
    	}*/
    }
    
    
    public void navigateToSelfServeRegistrationPageNew() {
            verifyAndClickWithXpath(pageProperties.getProperty("HomePage.Registernow"), "Register now");
    }

    public void navigateToHelpandAdvicePage() {
        if (browser.isElementVisibleWithXpath(pageProperties
                .getProperty("HomePage.HelpAndAdviceLink"))) {
            browser.clickWithXpath(pageProperties
                    .getProperty("HomePage.HelpAndAdviceLink"));
            Report.updateTestLog("Home page Help & Advice Link Click", "PASS");
            browser.wait(getWaitTime());
        }
    }

    public void navigateToBoilersAndHeating() {
        if (browser.isTextPresent(pageProperties
                .getProperty("HomePage.BoilersAndHeating"))) {
            verifyAndClickWithLinkText(
                    pageProperties.getProperty("HomePage.BoilersAndHeating"),
                    "Boilers & Heating");
            browser.wait(getWaitTime());
        }
    }

    public void navigateToChangeEmailAddressPage() {
        if (browser.isTextPresent(pageProperties
                .getProperty("HomePage.ChangeEmailAddress"))) {
            verifyAndClickWithLinkText(
                    pageProperties.getProperty("HomePage.ChangeEmailAddress"),
                    "Change Email Address");
            browser.wait(getWaitTime());
        }
    }
    public void navigateToForgottenPassword() {
        verifyAndClickWithLinkText(pageProperties.getProperty("HomePage.ForgottenPasswordLink"), "I've Forgotten My Password Link");
    }
    public void navigatetoForgotEmailPage() {
    	browser.wait(getWaitTime());
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("HomePage.ForgotEmail1"))) {
            browser.clickWithXpath(pageProperties.getProperty(("HomePage.ForgotEmail1")));
            browser.wait(getWaitTime());
        }
    }
    public void navigatetoForgotEmailViaForgotPassword() {
        browser.clickWithXpath(pageProperties.getProperty("HomePage.ForgotPasswordID"));
        browser.wait(getWaitTime());
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("HomePage.ForgotEmailID"))) {
            browser.clickWithXpath(pageProperties.getProperty("HomePage.ForgotEmailID"));
        }
    }
    
    public ArrayList<String> navigateToCQ5LoginPageList(String[] strErrorCode){
    	browser.open(ApplicationConfig.APP_BG_URL+":9002/etc/centrica-tools/errormessages-maintenance.html");
    	RegistrationPage registrationPage=new RegistrationPage();
    	ArrayList<String> a1=registrationPage.openCQ5List(strErrorCode);
    	return a1;
    	
    }
    
    public ArrayList<String> navigateToCQ5LoginPage(){
    	browser.open(ApplicationConfig.APP_BG_URL+":9002/etc/centrica-tools/errormessages-maintenance.html");
    	RegistrationPage registrationPage=new RegistrationPage();
    	ArrayList<String> a1=registrationPage.openCQ5();
    	return a1;
    	
    }
    
    
    public void BgbnavigateToLoginPage() {
        if(browser.isElementVisible(pageProperties.getProperty("HomePage.Logout"))) {
            browser.clickWithLinkText(pageProperties.getProperty("HomePage.Logout"));
            browser.wait(getWaitTime());
            browser.open(ApplicationConfig.APP_BG_URL);
        }
        
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("HomePage.LoginPageLink"))) {
            browser.clickWithXpath(pageProperties.getProperty("HomePage.LoginPageLink"));
            Report.updateTestLog("Login Link is Selected Successfully ", "PASS");
        } 
        
        browser.wait(getWaitTime());
    
    }
    
    public void loginfromNewRegPage() {
    	
    	//browser.open(ApplicationConfig.LoginFromNewRegPage);
    	browser.wait(getWaitTime());
    	
        /*if(browser.isElementVisible(pageProperties.getProperty("HomePage.Logout"))) {
            browser.clickWithLinkText(pageProperties.getProperty("HomePage.Logout"));
            browser.wait(getWaitTime());
            browser.open(ApplicationConfig.APP_BG_URL);
        }
        
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("HomePage.LoginPageLink"))) {
            browser.clickWithXpath(pageProperties.getProperty("HomePage.LoginPageLink"));
            Report.updateTestLog("Login Link is Selected Successfully ", "PASS");
        } 
        
        browser.wait(getWaitTime());*/
    
    }
    
    public void openUrlVerifyLandingPage(){
    
    BasePage basep=new BasePage();
    //OpenBasePage();
    getWaitTime();
//    browser.open("http://10.224.70.76");
//    browser.open(ApplicationConfig.APP_BG_URL);
    if (browser.isElementVisibleWithXpath(pageProperties.getProperty("HomePage.LoginPageLink"))) {
        Report.updateTestLog("Login Page displayed successfully", "Pass");
    } else{
    	Report.updateTestLog("Login Page not displayed successfully", "Fail");
    }
    
}
    
    
    public void navigateToSMRDeepLink(){
    	if(ApplicationConfig.APP_BG_URL.endsWith("/")){
    		browser.open(ApplicationConfig.APP_BG_URL+"SubmitMeterRead");
    	}
    	else{
    		browser.open(ApplicationConfig.APP_BG_URL+"/SubmitMeterRead");
    	}
    }

/* Added for BGMO Start */
	public void getSONumber() {
		FileReader fr = null;
		String soNumber = "", msg = "";
		try {
			Sofile = new File(Service_Order_FILE_NAME);
			fr = new FileReader(Sofile);
			BufferedReader br = new BufferedReader(fr);
    
			String[] so = br.readLine().split("=");
			soNumber = so[1];
			so = br.readLine().split("=");
			msg = so[1];
        
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			Report.updateTestLog("Unable to get Service Order Number ", "Fail");
    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
    }
    
		getSONumber(soNumber, msg);
    
}
    
	public void getSONumberForCancelOrReschedule() {
		getSONumberForCancelOrReschedule1(Sofile);
    	}

	public void navigateToSMLandingPage() {
		// TODO Auto-generated method stub

		if (ApplicationConfig.APP_BG_URL.endsWith("/")) {
			browser.open(ApplicationConfig.APP_BG_URL
					+ "content/britishgas/smarter-living/control-energy/smart-meters.html");
		} else {
			browser.open(ApplicationConfig.APP_BG_URL
					+ "/content/britishgas/smarter-living/control-energy/smart-meters.html");
		}

		Report.updateTestLog("Navigated to smart meter landing page.", "Pass");

	}

	public void navigateToOurNewTariffsPage() {
		// TODO Auto-generated method stub

		/*
		 * browser.open(ApplicationConfig.APP_BG_URL +
		 * "/content/britishgas/products-and-services/gas-and-electricity/our-energy-tariffs.html"
		 * );
		 */
		browser.open(ApplicationConfig.APP_BG_URL
				+ "/products-and-services/gas-and-electricity/our-energy-tariffs/clear-and-simple.html");

		Report.updateTestLog("Navigated to   clear and simple tariff page.", "Pass");

	}

	public void getSONumberForChannelActivation() {
	getSONumberForChannelActivation(Sofile);
		
	}

	public void navigateToLoginServiceDeepLinkFV() {
		  browser.open(ApplicationConfig.APP_BG_URL+"/asv?cid=dplnkoamasv");
	}
	
	
}
