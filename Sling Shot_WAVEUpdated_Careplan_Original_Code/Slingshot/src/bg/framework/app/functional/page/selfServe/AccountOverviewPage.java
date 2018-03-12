package bg.framework.app.functional.page.selfServe;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SiebelDataBase;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 23/03/12
 * Time: 10:16
 * To change this template use File | Settings | File Templates.
 */
public class AccountOverviewPage extends BasePage {

    private final static String FILE_NAME = "resources/selfServe/"+ApplicationConfig.BRAND+"AccountOverview.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    public void navigateToAccountSummaryPage(UserProfile userProfile) {
       // browser.wait(getWaitTime());
    	Report.updateTestLog("The account overview page", "WARN");
        verifyAndClickWithXpath((pageProperties.getProperty(
                "AccountOverviewPage.ManageAccountXPath").replace("USERACCOUNTNUMBER",
                		userProfile.getAccNumber())), "Account summary");
        browser.wait(1000);
        
        
    }
    
    
    public void navigateToContactUsPage() {
        browser.wait(1000);
        browser.clickWithLinkText(pageProperties.getProperty("AccountOverviewPage.ContactUs"));
        browser.wait(10000);
    }

    public void navigateToGetAPrice() {
        browser.wait(1000);
        //browser.clickWithXpath(pageProperties.getProperty("AccountOverviewPage.GetAPrice"));
        if (ApplicationConfig.BRAND.equalsIgnoreCase("BG")) {
            browser.open(ApplicationConfig.APP_BG_URL + "/GetAQuote/");
        } else {
            browser.open(ApplicationConfig.APP_FUSION_URL + "/GetAQuote/");
        }
        browser.wait(10000);
    }

    public void navigateToAllYourAccount(UserProfile userProfile) {

        verifyAndClickWithLinkText(pageProperties.getProperty("AccountOverviewPage.ManageAllAccount"), "All accounts");
    }

    public void verifyLogin(String lastName, String accNumver) {
        browser.wait(getWaitTime());
        String lastName2 = browser.getText(pageProperties.getProperty("AccountOverviewPage.Lastname"));
        if(lastName2.toLowerCase().contains(lastName.toLowerCase())){
          Report.updateTestLog("Lastname is present in application", "PASS");
        }
        else{
          Report.updateTestLog("Lastname not present in application", "FAIL");
        }
        verifyIsTextPresent(accNumver);
    }
    public void veifyCustomerAddress(UserProfile userProfile, String accountNumber) {
        SiebelDataBase siebelDatabase = new SiebelDataBase();
        List<String> address = siebelDatabase.getAddress(accountNumber);
        System.out.println(address);
        String[] arrayaddress = (String[]) address.toArray(new String[0]);
        String houseno = arrayaddress[0];
        String addNum = arrayaddress[1];
        String addres = arrayaddress[2];
        String city = arrayaddress[3];
        String zipcode = arrayaddress[4];
        String number = "";
        String fulladdress = "";
        //System.out.println("");
        if (!(houseno==null)) {
            number = houseno;
        } else if (!(addNum==null)) {
            number = addNum;
        }

        System.out.println(houseno + " " + addNum + " " + addres + " " + city + " " + zipcode + " " + number);
        if(ApplicationConfig.BRAND.equalsIgnoreCase("BG"))
        {
        	String addressOneAdd = null;
            String addressTwoAdd = null;

        	int accountCount = browser.getChildElementsCountByXpath(pageProperties.getProperty("AccountOverviewPage.accountCount"));
        	if(accountCount>2){
        		accountCount=2;
        	}
        	String expectedAccountNum = accountNumber;
        		for (int i = 1; i <= accountCount; i++) {
        			String currentAccountNum = browser.getTextByXpath(pageProperties.getProperty("AccountOverviewPage.accountNumber").replace("ACC_NUM", "" + i)).trim();
        				if (currentAccountNum.equalsIgnoreCase(expectedAccountNum)) {
        					addressOneAdd = browser.getTextByXpath(pageProperties.getProperty("AccountOverviewPage.addressLineOne").replace("ACC_NUM", "" + i));
        					addressTwoAdd = browser.getTextByXpath(pageProperties.getProperty("AccountOverviewPage.addressLineTwo").replace("ACC_NUM", "" + i));
        					fulladdress = addressOneAdd + addressTwoAdd;
        				}
        		}
        		if (fulladdress.contains(city) && fulladdress.contains(addres) && fulladdress.contains(zipcode) && fulladdress.contains(number)) {
        			Report.updateTestLog("Address verification done with database successfull", "PASS");
        		} else {
        			Report.updateTestLog("Address verification done with database is not successfull", "FAIL");
        		}
        }else if(ApplicationConfig.BRAND.equalsIgnoreCase("Fusion")){
        	fulladdress = browser.getTextByXpath(pageProperties.getProperty("AccountOverviewPage.address"));
        	System.out.println(fulladdress);
        	if(fulladdress.contains(number) && fulladdress.contains(addres )&& fulladdress.contains(city) && fulladdress.contains(zipcode)){
         	   Report.updateTestLog("Address verification done with database successfull", "PASS");
            }else{
         	   Report.updateTestLog("Address verification done with database is not successfull", "FAIL");
            }
        }
    }






    public void verifyAccountPresence(String account) {
    	account = account.trim();
        if (browser.isTextPresent(account)) {
            Report.updateTestLog("The Account Number: " + account
                    + " Is found on page: " + browser.getTextByXpath("//title"), "PASS");
        } else
            Report.updateTestLog(
                    "<b> The Account Number: " + account
                            + " is not found </b>.User is in page: "
                            + browser.getTextByXpath("//title"), "FAIL");

    }

    public void verifyAccountAbsence(String account) {
        if (!browser.isTextPresent(account)) {
            Report.updateTestLog("The Inactive Account Number: " + account
                    + " Is  found on page: " + browser.getTextByXpath("//title"),
                    "FAIL");
        } else
            Report.updateTestLog(
                    "<b> The Inactive Account Number: " + account
                            + " is not found </b>.User is in page: "
                            + browser.getTextByXpath("//title"), "PASS");

    }

    public void logout() {
    	//System.out.println("Selected logout called");
    	//browser.clickWithXpath(pageProperties.getProperty("AccountOverviewPage.Logout"));
    	if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AccountOverviewPage.Logout"))){
    		Report.updateTestLog("Account Overview Page", "WARN");
    		browser.clickWithXpath(pageProperties.getProperty("AccountOverviewPage.Logout"));
    	//verifyAndClickWithXpath(pageProperties.getProperty("AccountOverviewPage.Logout"), "logout");
    	System.out.println("Selected logout");
    	}
        //verifyAndClickWithXpath(pageProperties.getProperty("AccountOverviewPage.Logout"), "logout");
    }

    public void loginForInactiveLessThanSix() {
        String expectedName;
        expectedName = "These are your closed accounts";
        String actualName = browser.getTextByXpath(pageProperties
                .getProperty("AccountOverviewPage.inactivelessthansix"));
        if (expectedName.equalsIgnoreCase(actualName)) {
            Report.updateTestLog("Message while Login account inactive  pastdate less than 6 mths", "PASS");
        } else {
            Report.updateTestLog("Error message while Login account inactive  less greater than 6 mths", "FAIL");
        }
        if (browser.isTextPresent(pageProperties.getProperty("AccountOverviewPage.manageacct"))) {
            Report.updateTestLog("Manage Account Verification is displayed", "PASS");
        } else {
            Report.updateTestLog("Manage Account Verification is not displayed", "FAIL");
        }
    }

    public void navigateToProductsAndServicesPage() {
        browser.wait(getWaitTime());
        /*if (browser.isElementVisibleWithXpath(pageProperties.getProperty("AccountOverviewPage.ProductsAndServices"))) {
            browser.clickWithXpath(pageProperties.getProperty("AccountOverviewPage.ProductsAndServices"));

            Report.updateTestLog("Products and Services Link is clicked", "PASS");
        } else {
            Report.updateTestLog("Products and Services Link is not clicked", "FAIL");
        }*/
        
        verifyAndClickWithLinkText(pageProperties.getProperty("AccountOverviewPage.Energy"), "Energy page");

    }
    public void navigateTOGasAndElectricityPage() {
    	browser.wait(getWaitTime());
    	if(browser.isTextPresent(pageProperties.getProperty("AccountOverviewPage.Energy")))
    	{
    	verifyAndClickWithLinkText(pageProperties.getProperty("AccountOverviewPage.Energy"), "Energy page");
    	}
    	else 
    	{
    		verifyAndClickWithLinkText(pageProperties.getProperty("AccountOverviewPage.Energy"), "Energy page");
    	}
    	browser.wait(getWaitTime());
    
    }
    
    public void navigateTOAddElectrticityPage() {
    	//verifyAndClickWithXpath(pageProperties.getProperty("AccountOverviewPage.AddElectricity"), "Add Electricity page");
    	if(browser.isTextPresent("Add Electricity")){
    		verifyAndClickWithLinkText("Add Electricity","Add electricity");
    	}
    	else{
    	browser.open("https://10.224.70.74/New_Offer/Account_Summary/Tactical_Offer/orderType/ClearAndSimple/energyType/Elec");
    	}browser.wait(getWaitTime());
    }
    
    public void navigateTOAddDualPage() {
    	browser.open("https://10.224.70.74/New_Offer/Account_Summary/Tactical_Offer/orderType/ClearAndSimple/energyType/Dual");
    	browser.wait(getWaitTime());
    }
    
    
    public void navigateTOAddHomeCarePage() {
    	//verifyAndClickWithXpath(pageProperties.getProperty("AccountOverviewPage.AddHomeCare"), "Add Home care page");
    	
    	browser.open("http://10.224.70.111/products-and-services/boilers-and-central-heating/cover/homecare.html");
    	
    }
    
    public void navigateTOAddGasPage() {
    	//verifyAndClickWithXpath(pageProperties.getProperty("AccountOverviewPage.AddGas"), "Add Electricity page");
    	if(browser.isTextPresent("Add Gas"))
    	{
    		verifyAndClickWithLinkText("Add Gas", "Add Gas");
    	}
    	else{
    	browser.open("https://10.224.70.74/New_Offer/Account_Summary/Tactical_Offer/orderType/ClearAndSimple/energyType/Gas");
    	browser.wait(getWaitTime());}
    }
    public void navigateToBoilersAndHeating() {
        if (browser.isTextPresent(pageProperties
                .getProperty("AccountOverviewPage.BoilersAndHeating"))) {
            verifyAndClickWithLinkText(
                    pageProperties.getProperty("AccountOverviewPage.BoilersAndHeating"),
                    "Boilers & Heating");
            browser.wait(getWaitTime());
        }
    }

    public void navigateToOrderHomeCareHundred() {
    	verifyAndClickWithXpath(pageProperties.getProperty("AccountOverviewPage.OrderHomeCare100"), "Order Homecare page");
    }

  public void navigateToSeeUnitRates()
  {
	  verifyAndClickWithLinkText(pageProperties.getProperty("AccountOverviewPage.SeeUnitRates"),"SeeUnitRates");
	  browser.wait(1000);
	  if(browser.isTextPresent(pageProperties.getProperty("AccountOverviewPage.WhatAreTiers")))
			  {
	  verifyAndClickWithLinkText(pageProperties.getProperty("AccountOverviewPage.WhatAreTiers"),"WhatAreTiers");
			  }
	  verifyAndClickWithXpath(pageProperties.getProperty("AccountOverviewPage.CloseTarrifOverlay"), "CloseTarrifOverlay");
	  Report.updateTestLog("The tarrif overlay is displayed in the application", "PASS");
  }
  
  public void verifyCustomerAddress(UserProfile userProfile, String accountNumber) {
      SiebelDataBase siebelDatabase = new SiebelDataBase();
      List<String> address = siebelDatabase.getAddress(accountNumber);
      System.out.println(address);
      String[] arrayaddress = (String[]) address.toArray(new String[0]);
      String houseno = arrayaddress[0];
      String addNum = arrayaddress[1];
      String addres = arrayaddress[2];
      String city = arrayaddress[3];
      String zipcode = arrayaddress[4];
      String number = "";
      String fulladdress = "";
      if (!(houseno==null)) {
          number = houseno;
      } else if (!(addNum==null)) {
          number = addNum;
      }

      String dbAddress= number + " " + addNum + " " + addres + " " + city + " " + zipcode;
      if(ApplicationConfig.BRAND.equalsIgnoreCase("BG"))
      {
      	String addressOneAdd = null;
          String addressTwoAdd = null;
      	int accountCount = browser.getChildElementsCountByXpath(pageProperties.getProperty("AccountOverviewPage.accountCount"));        	        	
      	String expectedAccountNum = accountNumber;
      		for (int i = 1; i <= accountCount; i++) {
      			String currentAccountNum = browser.getTextByXpath(pageProperties.getProperty("AccountOverviewPage.accountNumber").replace("ACC_NUM", "" + i)).trim();
      			
      				if (currentAccountNum.equalsIgnoreCase(expectedAccountNum)) {
      					addressOneAdd = browser.getTextByXpath(pageProperties.getProperty("AccountOverviewPage.addressLineOne").replace("ACC_NUM", "" + i));
      					addressTwoAdd = browser.getTextByXpath(pageProperties.getProperty("AccountOverviewPage.addressLineTwo").replace("ACC_NUM", "" + i));
      					fulladdress = addressOneAdd + addressTwoAdd;        					
      				}
      		}
      		if(fulladdress.contains(number) && fulladdress.contains(addres )&& fulladdress.contains(city) && fulladdress.contains(zipcode)){
            	   Report.updateTestLog("Address verification done with database successfull<br>"+
           	"Database address-<b>"+dbAddress+"</b><br>Page address-<b>"+fulladdress+"</b>", "PASS");
               }else{
            	   Report.updateTestLog("Address verification done with database is not successfull<br>"+
           	"Database address-<b>"+dbAddress+"</b><br>Page address-<b>"+fulladdress+"</b>", "FAIL");
               }
      }else if(ApplicationConfig.BRAND.equalsIgnoreCase("Fusion")){
      	fulladdress = browser.getTextByXpath(pageProperties.getProperty("AccountOverviewPage.address"));
      	System.out.println(fulladdress);
      	if(fulladdress.contains(number) && fulladdress.contains(addres )&& fulladdress.contains(city) && fulladdress.contains(zipcode)){
       	   Report.updateTestLog("Address verification done with database successfull<br>"+
      	"Database address-<b>"+dbAddress+"</b><br>Page address-<b>"+fulladdress+"</b>", "PASS");
          }else{
       	   Report.updateTestLog("Address verification done with database is not successfull<br>"+
      	"Database address-<b>"+dbAddress+"</b><br>Page address-<b>"+fulladdress+"</b>", "FAIL");
          }
      }
  }
  
  
  public void verifyCrossSell(){
  	String accTypeText=null;
  	Set<String> accountType=new HashSet<String>();
  	int accountCount = browser.getChildElementsCountByXpath(pageProperties.getProperty("AccountOverviewPage.accountCount"));  
  	for(int count=1;count<=accountCount;count++){
  		accTypeText = browser.getTextByXpath(pageProperties.getProperty("AccountOverviewPage.AccountTypeID").replace("ACC_NUM", ""+count));
  		accountType.add(accTypeText.trim());
  	}
  	System.out.println("SET :"+accountType);
  	
  	if(accountType.contains("Gas") && accountType.contains("Electricity") && accountType.contains("Insurance & Repair")){
			otherOfferCheck(pageProperties.getProperty("AccountOverviewPage.crossCellEnergy"));
		}else
  	if(accountType.contains("Gas") && accountType.contains("Electricity")){
  		otherOfferCheck(pageProperties.getProperty("AccountOverviewPage.crossCellIns"));
  	}else
  		if(accountType.contains("Gas")){    		
  		otherOfferCheck(pageProperties.getProperty("AccountOverviewPage.crossCellEle"));
  		otherOfferCheck(pageProperties.getProperty("AccountOverviewPage.crossCellIns"));
  	}else
  		if(accountType.contains("Electricity")){    	
  		otherOfferCheck(pageProperties.getProperty("AccountOverviewPage.crossCellGas"));
  		otherOfferCheck(pageProperties.getProperty("AccountOverviewPage.crossCellIns"));
  	}else 
  		if(accountType.contains("Energy")){    		
      		otherOfferCheck(pageProperties.getProperty("AccountOverviewPage.crossCellIns"));
      }
  }
  private void otherOfferCheck(String type){
  	String link1="";    	
  	System.out.println("OFFER :"+type);
  	browser.wait(2000);
  	//if(browser.isElementVisibleWithXpath(AccPageProperties.getProperty("AccountOverviewPage.OptionTextID"))){
  		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("AccountOverviewPage.addAccountLink").replace("TYPE", type))){
  		link1=browser.getTextByXpath(pageProperties.getProperty("AccountOverviewPage.addAccountLink").replace("TYPE", type));
  		//link1=browser.getTextByXpath(AccPageProperties.getProperty("AccountOverviewPage.OptionTextID"));
  		if(link1.contains(type)){
  		System.out.println("LINK TEST "+link1);  
  		Report.updateTestLog("Link for add "+type+" displayed", "PASS");}
  		else{
			Report.updateTestLog("Link for add "+type+" is not displayed", "FAIL");
		}    	
  	}else{
  		Report.updateTestLog("Cross sell section not displayed", "FAIL");
  }
  }
  public void verifyCrossSell(UserProfile userProfile)
  {
  	String elecAccount= userProfile.getElecAccount();
  	String gasAccount= userProfile.getGasAccount();
  	System.out.println("elecAccount is------------------->"+elecAccount);
  	System.out.println("Gas Account i9s --------------------->"+gasAccount);
  	if(elecAccount.isEmpty()){
  		if(browser.isTextPresent("Add Electricity")){
  			Report.updateTestLog("Cross sell for Gas Account is present in the application", "PASS");
  			}  
  		else{
  			Report.updateTestLog("Cross sell for Gas Account is not present in the application", "FAIL");
  		}
  	}
  	if(gasAccount.isEmpty()){
  		if(browser.isTextPresent("Add Gas")){
  			Report.updateTestLog("Cross sell for Electricity Account  is present in the application", "PASS");
  		}
  		else{
  			Report.updateTestLog("Cross sell for Electricity Account  is not present in the application", "FAIL");
  		}
  	}
  	if(browser.isTextPresent("Add HomeCare")){
  		Report.updateTestLog("Cross sell for HomeCare Account  is present in the application", "PASS");
  	}
  }
  public void verifyUpSell(UserProfile userProfile){
	  String accTypeText=null;
	  	//Set<String> accountType=new HashSet<String>();
	  	int accountCount = browser.getChildElementsCountByXpath(pageProperties.getProperty("AccountOverviewPage.accountCount"));  
	  	System.out.println(accountCount);
	  	for(int count=1;count<=accountCount;count++){
	  		accTypeText = browser.getTextByXpath(pageProperties.getProperty("AccountOverviewPage.AccountTypeID").replace("ACC_NUM", ""+count));
	  		//accountType.add(accTypeText.trim());
	  		System.out.println("thE Account type of "+count+"is"+accTypeText);
	  		if(accTypeText.contains("Insurance"))
	  		{
	  			System.out.println("ENTERD insurance");
	  			if(browser.isTextPresent("Upgrade")){
	  			Report.updateTestLog("The Upsell for this account is present in the application", "PASS");
	  			}
	  			else{
	  				navigateToAccountSummaryPage(userProfile);
	  				String ServicePlan=browser.getTextByXpath("//*[@id='content-body']//strong/span");
	  				if(ServicePlan.contains("400"))
	  				{
	  				Report.updateTestLog("The Account is already Upgraded", "PASS");
	  				}else{
	  				Report.updateTestLog("The Upsell for this account is not present in the application", "FAIL");}
	  			}
	  		}
	  	}
  }
}