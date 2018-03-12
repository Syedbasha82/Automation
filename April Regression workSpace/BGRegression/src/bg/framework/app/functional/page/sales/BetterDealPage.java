package bg.framework.app.functional.page.sales;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.EshopTariffProfile;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.GlobalErrorMessages;
import bg.framework.app.functional.page.reFactoring.AccountOverviewPage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SiebelDataBase;
import org.ini4j.Profile;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.internal.seleniumemulation.IsTextPresent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class BetterDealPage extends BasePage {
	private static String Fuel;
	private static String SalesType;
	private static String CustomerType;
	private static String AddressType;
	/*static int count = 2;*/
	private final static String File_AccPage = "resources/ReFactoring/BetterDeal.properties";
	
    private static Properties pageProperties = new PropertyLoader(File_AccPage).load();
    final String Pass_Str = "PASS";
    final String Fail_Str = "FAIL";
    
    public BetterDealPage() {

    }
    
    public void navigateToYourTariffCheckPage(){
    /*	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BetterDeal.YourTariffCheck"))){
    		Report.updateTestLog("Your Tariff Check Link is Present", "WARN");
    		verifyAndClickWithXpath(pageProperties.getProperty("BetterDeal.YourTariffCheck"), "YourTariffCheck");
    	}
    	else{
    		Report.updateTestLog("Your Tariff Check Link is not Present", "FAIL");
    	}*/
    	browser.clickWithLinkText("Your Tariff Check");
    }
    public void verifyYourTariffCheckPage(String AccType){
       verifyIsTextPresent(pageProperties.getProperty("BetterDealPage.TariffPage"));
	  	
	  	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BetterDealPage.PPTable"))){
	  		Report.updateTestLog("Personal Projection Table is Present in the Application ", "PASS");
	  	}
	  	else{
	  		Report.updateTestLog("Personal Projection Table is not Present in the Application ", "FAIL");
	  	}
	  	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BetterDealPage.SignUpNectar"))){
	  		Report.updateTestLog("Signup Nectar is Present in the Application ", "PASS");
	  	}
	  	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BetterDealPage.SetUpDirectDebit"))){
	  		Report.updateTestLog("Signup Nectar is Present in the Application ", "PASS");
	  	}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BetterDealPage.SignUpToday"))){
	  		Report.updateTestLog("Sign Up today Link is Present in the Application ", "PASS");
	  	}
	  	else{
	  		Report.updateTestLog("Sign Up today Link not Present in the Application ", "FAIL");
	  	}
		 Report.updateTestLog("Your Tariff check Result Page is Present in the Application ", "WARN");
    	if(AccType=="Single"){
    	  
    	  	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BetterDealPage.GetAQuote"))){
    	  		Report.updateTestLog("Get A Quote Section is Present in the Application ", "PASS");
    	  	}
    	  	else{
    	  		Report.updateTestLog("Get A Quote Section is not Present in the Application ", "FAIL");
    	  	}
    	  	}	
 
    	
      }
    
    public void verifyBetterdealOverlayAndConfirm(UserProfile userProfile, String FuelType){
    	browser.dynamicWaituntilVisiblebyXpath(pageProperties.getProperty("BetterDealPage.BetterDealOverLay"));
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BetterDealPage.BetterDealOverLay"))){
    		Report.updateTestLog("Better Deal Overlay Page is Present in the Application", "WARN");
    	}
    	else{
    		Report.updateTestLog("Better Deal Overlay Page is not Present in the Application", "FAIL");
    	}
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BetterDealPage.CancelBDOverlay"))){
    		Report.updateTestLog("Cancel Link is present in the  Better Deal Overlay", "PASS");
    	}
    	else{
    		Report.updateTestLog("Cancel Link is not present in the  Better Deal Overlay", "FAIL");
    	}
    	String bdName= browser.getTextByXpath(pageProperties.getProperty("BetterDealPage.BDName"));
    	System.out.println("111111111111111111111111111111111111111"+bdName);
    	String bdEmailId= browser.getTextByXpath(pageProperties.getProperty("BetterDealPage.BDEmailId"));
    	System.out.println("222222222222222222222222222222222222222"+bdEmailId);
    	String bdAccountNo= browser.getTextByXpath(pageProperties.getProperty("BetterDealPage.AccountNo").replace("FUEL", FuelType));
    	System.out.println("3333333333333333333333333333333333333333"+bdAccountNo);
    	/*String bdHouseNum= browser.getTextByXpath(pageProperties.getProperty("BetterDealPage.HouseNum"));
    	System.out.println("44444444444444444444444444444444444444444"+ bdHouseNum);*/
    	String bdPostCode= browser.getTextByXpath(pageProperties.getProperty("BetterDealPage.PostCode"));
    	System.out.println("555555555555555555555555555555555555555555"+bdPostCode);
    	String fullName= (userProfile.getTitle()+" "+userProfile.getFirstName()+" "+userProfile.getLastName());
    	System.out.println("666666666666666666666666666666666666666666"+fullName);
    	
    	
    	if(bdName.equals(fullName)){
    		Report.updateTestLog("Customer Name is same as that of in AWB", "PASS");
    	}
    	else{
    		Report.updateTestLog("Customer Name is not same as that of in AWB", "FAIL");
    	}
    /*	if(bdHouseNum.equals(userProfile.getHomeNumber())){
    		Report.updateTestLog("House Number is same as that of in AWB", "PASS");
    	}
    	else{
    		Report.updateTestLog("House Number is not same as that of in AWB", "FAIL");
    	}*/
    	if(bdPostCode.equals(userProfile.getaddr())){
    		Report.updateTestLog("Post Code is same as that of in AWB", "PASS");
    	}
    	else{
    	   Report.updateTestLog("Post Code is not same as that of in AWB", "FAIL");
    	}
    	if(bdAccountNo.equals(userProfile.getAccNumber())){
    		
    		Report.updateTestLog("Account Number is same as that of in AWB", "PASS");
    	}
    	else{
    		
    		Report.updateTestLog("Account Number is not same as that of in AWB", "FAIL");
    	}
    	if(bdEmailId.equals(userProfile.getEmail())){
    		
    		Report.updateTestLog("Email is same as that of in AWB", "PASS");
    	
    	}
    	else{
    		Report.updateTestLog("Email is not same as that of in AWB", "PASS");
    	}
    	  confirmAndPlaceOrder();
    }
    public void confirmAndPlaceOrder(){
    	
    	verifyAndClickWithXpath(pageProperties.getProperty("BetterDealPage.ClickTermsAndConditions"), "Click Terms And Conditions");
    	verifyAndClickWithXpath(pageProperties.getProperty("BetterDealPage.Placeorder"), "Place order");
    }
	public void verifyThankyouPage(){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BetterDealPage.ThankYouPage"))){
			if(browser.getTextByXpath(pageProperties.getProperty("BetterDealPage.ThankYouPage")).contains("Thank you for ordering")){
				Report.updateTestLog(browser.getTextByXpath(pageProperties.getProperty("BetterDealPage.ThankYouPage")) + "Text Displayed successfully", "WARN");
			}
			else{
				Report.updateTestLog(browser.getTextByXpath(pageProperties.getProperty("BetterDealPage.ThankYouPage")) + "Text not Displayed successfully", "FAIL");
			}
		}
	}
	public  BetterDealPage(String Fuel, String SalesType, String CustomerType, String AddressType) {
		this.SalesType = SalesType;
		this.Fuel = Fuel;
		this.CustomerType = CustomerType;
		this.AddressType = AddressType;
	}

	public void selectTariff(String tariff, EshopTariffProfile eshopTariff){
		if(SalesType.equalsIgnoreCase("Eshop")){
			getTariffName(tariff,eshopTariff);		
		}
		
		
	}
	
	public void getTariffName(String tariff,EshopTariffProfile eshopTariff){
		if(Fuel.equalsIgnoreCase("Gas")){
			Fuel = "gas";
		}
		if(Fuel.equalsIgnoreCase("Elec")){
			Fuel = "electricity";
		}
		int count = 2;
		while((count) <= 11){
			String tariffOnScreen;
			String count1 = String.valueOf(count);
			///////////////// if fuel is not dual
			if((Fuel.equalsIgnoreCase("gas")) || (Fuel.equalsIgnoreCase("electricity"))){
				tariffOnScreen = browser.getTextByXpath(pageProperties.getProperty("BetterDealPage.tariffOnScreen").replace("NUM", count1).replace("FUEL", Fuel));
				
				
				System.out.println("   print   "   + tariffOnScreen);
				String tariffOnScreen1 = tariffOnScreen.replace("&", "and");
				System.out.println("5555555555555555555555555555555555"+tariff);
				if(tariffOnScreen1.contains(tariff)){	
					     System.out.println("5555555555555555555555555555555555"+tariff);
					     System.out.println("6666666666666666666666666666666666"+tariffOnScreen1);
					     System.out.println("7777777777777777777777777777777777"+Fuel);
					     //verifyAndClickWithXpath(pageProperties.getProperty("BetterDealPage.BetterdealswitchNow").replace("NUM", count1).replace("FUEL", Fuel),"Better Deal Switch Now Link is clicked");
					      verifyAndClickWithXpath(pageProperties.getProperty("BetterDealPage.BetterdealswitchNowNew").replace("TARIFF", tariff).replace("FUEL", Fuel),"Better Deal Switch Now Link is clicked");	
						  Report.updateTestLog("Switch now of tariff name:" +tariff+ "is selected", "PASS");
						  break;
				}
				else{
				Report.updateTestLog("Switch now of tariff name:" +tariff+ "is not selected", "FAIL");
				}			
			}
			if(Fuel.equalsIgnoreCase("Dual")){
				tariffOnScreen = browser.getTextByXpath(pageProperties.getProperty("BetterDealPage.DualtariffOnScreen").replace("NUM", count1));
				String tariffOnScreen1 = tariffOnScreen.replace("&", "and");
				if(tariffOnScreen1.contains(tariff)){
					/////////// if fuel is dual , clicking switch now /////////////
					verifyAndClickWithXpath(pageProperties.getProperty("BetterDealPage.TariffRadioButton").replace("NUM", count1),"Dual Fuel Tariff Radio Button");
					verifyAndClickWithXpath(pageProperties.getProperty("BetterDealPage.DualswitchNow").replace("NUM", count1),"Switch Now button is clicked");
					System.out.println("555555555555555555555555555555" +pageProperties.getProperty("BetterDealPage.DualswitchNow").replace("NUM", count1));
					Report.updateTestLog("Switch now of dual tariff name:" +tariff+ "is selected", "PASS");
					break;
				}else{
				Report.updateTestLog("Switch now of dual tariff name:" +tariff+ "is not selected", "FAIL");
				}
				
			}
			if(Fuel.equalsIgnoreCase("JI")){
				tariffOnScreen = browser.getTextByXpath(pageProperties.getProperty("BetterDealPage.DualtariffOnScreen").replace("NUM", count1));
				String tariffOnScreen1 = tariffOnScreen.replace("&", "and");
				System.out.println("8888888888888888888888888888888 tariffOnScreen" +tariffOnScreen +tariffOnScreen1);
				if(tariffOnScreen1.contains(tariff)){
					/////////// if fuel is JI , clicking switch now /////////////
					verifyAndClickWithXpath(pageProperties.getProperty("BetterDealPage.TariffRadioButton").replace("NUM", count1),"Dual Fuel Tariff Radio Button");
					verifyAndClickWithXpath(pageProperties.getProperty("BetterDealPage.DualswitchNow").replace("NUM", count1),"Switch Now button is clicked");
					System.out.println("555555555555555555555555555555" +pageProperties.getProperty("BetterDealPage.DualswitchNow").replace("NUM", count1));
					Report.updateTestLog("Switch now of dual tariff name:" +tariff+ "is selected", "PASS");
					break;
				}else{
				Report.updateTestLog("Switch now of dual tariff name:" +tariff+ "is not selected", "FAIL");
				}
				
			}
			count = count+3;
		}	
		
	}
	
	
	
    public void getSwitchNowRadioButton(String tariff,EshopTariffProfile eshopTariff){
      if(tariff.contains(eshopTariff.getTariff(1))){
    	  System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu" +eshopTariff.getTariff(1));
    	  verifyAndClickWithXpath(pageProperties.getProperty("BetterDealPage.Tariff1RadioButton"),"Dual Fuel Tariff1 Radio Button");
      }
      if(tariff.contains(eshopTariff.getTariff(2))){
    	  System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu" +eshopTariff.getTariff(2));
    	  verifyAndClickWithXpath(pageProperties.getProperty("BetterDealPage.Tariff2RadioButton"),"Dual Fuel Tariff2 Radio Button");
      }
      if(tariff.contains(eshopTariff.getTariff(3))){
    	  System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu" +eshopTariff.getTariff(3));
    	  verifyAndClickWithXpath(pageProperties.getProperty("BetterDealPage.Tariff3RadioButton"),"Dual Fuel Tariff3 Radio Button");
      }
      if(tariff.contains(eshopTariff.getTariff(4))){
    	  System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu" +eshopTariff.getTariff(4));
    	  verifyAndClickWithXpath(pageProperties.getProperty("BetterDealPage.Tariff4RadioButton"),"Dual Fuel Tariff4 Radio Button");
      }
    }
    public void getSwitchNowRadioButtonji(String tariff,EshopTariffProfile eshopTariff){
        if(tariff.contains(eshopTariff.getTariff(1))){
      	  System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu" +eshopTariff.getTariff(1));
      	  verifyAndClickWithXpath(pageProperties.getProperty("BetterDealPage.Tariff1RadioButtonJI"),"JI Tariff1 Radio Button");
        }
        if(tariff.contains(eshopTariff.getTariff(2))){
      	  System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu" +eshopTariff.getTariff(2));
      	  verifyAndClickWithXpath(pageProperties.getProperty("BetterDealPage.Tariff2RadioButtonJI"),"JI Tariff2 Radio Button");
        }
        if(tariff.contains(eshopTariff.getTariff(3))){
      	  System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu" +eshopTariff.getTariff(3));
      	  verifyAndClickWithXpath(pageProperties.getProperty("BetterDealPage.Tariff3RadioButtonJI"),"JI Tariff3 Radio Button");
        }
        if(tariff.contains(eshopTariff.getTariff(4))){
      	  System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu" +eshopTariff.getTariff(4));
      	  verifyAndClickWithXpath(pageProperties.getProperty("BetterDealPage.Tariff4RadioButtonJI"),"JI Tariff4 Radio Button");
        }
      }
    public void verifyChangedTariffInAccountSummaryPage(String tariff){
    	
    	String tariffInAccountSummaryPage = browser.getTextByXpath(pageProperties.getProperty("BetterDealPage.TariffInAccSumPage"));
    	String tariffInAccountSummaryPage1=tariffInAccountSummaryPage.replace("&", "and");
    	if( tariffInAccountSummaryPage1.contains(tariff)){
    		Report.updateTestLog("Tariff is switched to:" +tariff+"","WARN");
    	}
    	else{
    		Report.updateTestLog("Tariff is not switched to:" +tariff+"","WARN");
    	}
    	
    }
  public void verifyChangedTariffInAccountSummaryPageJI(String tariff){
    	
    	String tariffInAccountSummaryPageJI = browser.getTextByXpath(pageProperties.getProperty("BetterDealPage.TariffInAccSumPageJI"));
    	String tariffInAccountSummaryPageJI1=tariffInAccountSummaryPageJI.replace("&", "and");
    	if( tariffInAccountSummaryPageJI1.contains(tariff)){
    		Report.updateTestLog("Tariff is switched to:" +tariff+"for 1st Account","WARN");
    	}
    	else{
    		Report.updateTestLog("Tariff is not switched to:" +tariff+"for 1st Account","FAIL");
    	}
    	String tariffInAccountSummaryPageJI2 = browser.getTextByXpath(pageProperties.getProperty("BetterDealPage.TariffInAccSumPageJI1"));
    	String tariffInAccountSummaryPageJI3=tariffInAccountSummaryPageJI2.replace("&", "and");
    	if( tariffInAccountSummaryPageJI3.contains(tariff)){
    		Report.updateTestLog("Tariff is switched to:" +tariff+"for 2nd Account","WARN");
    	}
    	else{
    		Report.updateTestLog("Tariff is not switched to:" +tariff+"for 2nd Account","FAIL");
    	}
    	
    }
public void verifyChangedTariffInAccountSummaryPageforDual(String tariff,String accNum){
    	
    	String tariffInAccountSummaryPageGas = browser.getTextByXpath(pageProperties.getProperty("BetterDealPage.TariffInAccSumPage"));
    	String tariffInAccountSummaryPageGas1=tariffInAccountSummaryPageGas.replace("&", "and");
    	if( tariffInAccountSummaryPageGas1.contains(tariff)){
    		Report.updateTestLog("Tariff is switched to:" +tariff+"for Gas","WARN");
    	}
    	else{
    		Report.updateTestLog("Tariff is not switched to:" +tariff+"for Gas","FAIL");
    	}

		ArrayList<String> accountList = new ArrayList<String>();   
    	if(browser.isElementVisible(pageProperties.getProperty("BetterDealPage.OtherAccountsDropDown")))
    	{
    		 accountList=(browser.getFromDropBox("id", pageProperties.getProperty("BetterDealPage.OtherAccountsDropDown")));
    	}
    	int sizeOfDDBox=accountList.size();
    	if(sizeOfDDBox>2)
    	{
    		//if any account has size greater than 2 then need a rework.
    	}
    	for(String s:accountList)
    	{
    		if(s.contains(accNum))
    		{
    			verifyAndSelectDropDownBox(pageProperties.getProperty("BetterDealPage.OtherAccountsDropDown"),"AccountDetails"+s,s);
    			break;
    		}
    	}
    	browser.click("go_url");
    	
    	String tariffInAccountSummaryPageElec = browser.getTextByXpath(pageProperties.getProperty("BetterDealPage.TariffInAccSumPage"));
    	String tariffInAccountSummaryPageElec1=tariffInAccountSummaryPageElec.replace("&", "and");
    	if( tariffInAccountSummaryPageElec1.contains(tariff)){
    		Report.updateTestLog("Tariff is switched to:" +tariff+"for Electricity","WARN");
    	}
    	else{
    		Report.updateTestLog("Tariff is not switched to:" +tariff+"for Electricity","FAIL");
    	}

  }


    }

    
    
