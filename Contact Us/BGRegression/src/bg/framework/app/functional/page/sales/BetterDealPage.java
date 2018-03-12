package bg.framework.app.functional.page.sales;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.PriceFinderRMR;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.GlobalErrorMessages;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SiebelDataBase;
import bg.framework.app.functional.util.TestDataHelper;

import org.ini4j.Profile;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.internal.seleniumemulation.IsTextPresent;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class BetterDealPage extends BasePage {
	
	private final static String File_AccPage = "resources/ReFactoring/BetterDeal.properties";
    private static Properties pageProperties = new PropertyLoader(File_AccPage).load();
    final String Pass_Str = "PASS";
    final String Fail_Str = "FAIL";
    
    public BetterDealPage() {

    }
    
    public void loginUrl(UserProfile userProfile) {
    	String deepUrl=ApplicationConfig.APP_BG_URL.toString();
    	    	browser.open(""+deepUrl+"Login/Login-Verify/");
    }
    
    public void betterDealUrl(UserProfile userProfile, String fualType) {
    	String deepUrl=ApplicationConfig.APP_BG_URL.toString();
    	if(fualType.equals("Dual"))
    	{
    	String eleacc=userProfile.getElecAccount();
    	String ele=eleacc.substring(8, 12);
    	String elegas=userProfile.getGasAccount();
    	String gas=elegas.substring(8, 12);
    	browser.open(""+deepUrl+"youraccount/betterdeal/?accountnumber="+ele+"|"+gas+"");
    	}
    	else
    	{
    		String accNo=userProfile.getAccNumber();
        	String acc=accNo.substring(8, 12);
        	browser.open(""+deepUrl+"youraccount/betterdeal/?accountnumber="+acc+"");
    	}
    	//browser.open("http://10.224.70.59/apps/britishgas/components/BetterDeal/GET.servlet?accountnumber=6998|0373");
    }
    
    public void deepUrl(UserProfile userProfile, String Dual) {
//    	String deepUrl=ApplicationConfig.APP_BG_URL.toString();
//    	browser.open(""+deepUrl+""+ele+"|"+gas+"");
    	String deepUrl=ApplicationConfig.APP_BG_URL.toString();
    	if(Dual.equals("Dual"))
    	{
    	String eleacc=userProfile.getElecAccount();
    	String ele=eleacc.substring(8, 12);
    	String elegas=userProfile.getGasAccount();
    	String gas=elegas.substring(8, 12);
    	browser.open(""+deepUrl+"youraccount/betterdeal/?accountnumber="+ele+"|"+gas+"");
    	}
    	else
    	{
    		String accNo=userProfile.getAccNumber();
        	String acc=accNo.substring(8, 12);
//        	browser.open("http://10.224.70.111/apps/britishgas/components/BetterDeal/GET.servlet?accountnumber="+acc+"");
        	browser.open(""+deepUrl+"youraccount/betterdeal/?accountnumber="+acc+"");
    	}
    	//browser.open("http://10.224.70.59/apps/britishgas/components/BetterDeal/GET.servlet?accountnumber=6998|0373");
    }
    
    public void deepUrlRegistartionErrorMessage(UserProfile userProfile) {
    	
        verifyAndClickWithXpath(pageProperties.getProperty("Better.RegisterNow"),"Register Now");
        String error=browser.getTextByXpath(pageProperties.getProperty("Better.ErrorNotRegistered"));
        if(error.trim().equals("Sorry, we need you to look at the following areas of the form again"))
    	{
      	   Report.updateTestLog("Expected error message is avalable: "+error, "PASS");
         }else{
      	   Report.updateTestLog("Expected error message is not avalable: "+error, "FAIL");
    	}
    }
    
    public void deepUrlRegistartion(UserProfile userProfile) {
    	
    	verifyAndInputByXpath(pageProperties.getProperty("Better.RegisterEmail"), "Enter Email", userProfile.getEmail());
    	verifyAndClickWithXpath(pageProperties.getProperty("Better.RegisterNow"),"Register Now");
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	browser.selectfromDropBoxByXpath(pageProperties.getProperty("Better.RegisterTitle"), userProfile.getTitle());
    	
    	verifyAndInputByXpath(pageProperties.getProperty("Better.RegisterFirstName"), "Enter FirstName", userProfile.getFirstName());
    	verifyAndInputByXpath(pageProperties.getProperty("Better.RegisterSurname"), "Enter Surname", userProfile.getLastName());
    	verifyAndInputByXpath(pageProperties.getProperty("Better.RegisterCustomerRefNo"), "Enter Acc No", userProfile.getAccNumber());
    	
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	verifyAndClickWithXpath(pageProperties.getProperty("Better.RegisterFindAccount"), "Find Account Button click");
       	try {
    			Thread.sleep(5000);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	verifyAndInputByXpath(pageProperties.getProperty("Better.RegisterPass"), "Enter Password", userProfile.getPassword());
    	verifyAndInputByXpath(pageProperties.getProperty("Better.RegisterCon"), "Enter ConfirmPass", userProfile.getPassword());
    	verifyAndClickWithXpath(pageProperties.getProperty("Better.RegisterCheck"), "Confirm Check box clicked");
    	verifyAndClickWithXpath(pageProperties.getProperty("Better.RegisterFinalSubmit"), "3rd submit button clicked");
    	try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}    	verifyAndClickWithXpath(pageProperties.getProperty("Better.RegisterGoto"), "Go to login Page");
		
       	try {
    			Thread.sleep(3000);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    }
    
    public void loginUserDetails(UserProfile userProfile) {
        //final String expectedEmailAdd = new OnlineDBConnector().getUserEmail(userProfile.getUCRN());
        verifyAndInputById(pageProperties.getProperty("BetterDeal.email"), "Email Id", userProfile.getEmail());
    	//verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id", userProfile.getEmail());
        verifyAndInputById(pageProperties.getProperty("BetterDeal.password"), "Password", userProfile.getPassword());
       // browser.clickWithXpath(pageProperties.getProperty("BetterDeal.login"));
        verifyAndClickWithXpath(pageProperties.getProperty("BetterDeal.login"), "Login Button Clicked");
    }
    
    public void betterDealHeading(UserProfile userProfile) {
    	String betterHeading=browser.getTextByXpath(pageProperties.getProperty("Better.Heading")); 
    	if(betterHeading.trim().equals("Your Better Deal choices")){
      	   Report.updateTestLog("Actual Title is "+betterHeading.trim()+ "  and Expected Title is: Your Better Deal choices", "PASS");
         }else{
      	   Report.updateTestLog("Actual Title is "+betterHeading.trim()+ "  and Expected Title is: Your Better Deal choices", "FAIL");
         }
    }
    
    public void saveMoneyQuestion(UserProfile userProfile) {
    	/*String saveMoney=browser.getTextByXpath(pageProperties.getProperty("Better.SaveMoney")); 
    	if(saveMoney.trim().equals("Can I save some money?")){
      	   Report.updateTestLog("Actual Question is "+saveMoney.trim()+ "  and Expected Question is: Can I save some money?", "PASS");
         }else{
      	   Report.updateTestLog("Actual Quastion is "+saveMoney.trim()+ "  and Expected Question is: Can I save some money?", "FAIL");
         }*/
    }
    
    public void saveMoneyAnswer(UserProfile userProfile) {
/*    	String expectedAnswer="We want to help you keep your energy bills as low as possible and ensure you're getting great value from us, so here you can check if there is a better deal for you. And if you register for an online account we'll also email you every 6 month to keep you if we think you're missing out.";
    	String saveMoneyAnswer=browser.getTextByXpath(pageProperties.getProperty("Better.Information")); 
    	saveMoneyAnswer = saveMoneyAnswer.replaceAll ("^[ |\t]*\n$", "");
    	System.out.println("display:         "+saveMoneyAnswer);
    	if(saveMoneyAnswer.trim().equals(expectedAnswer)){
      	   Report.updateTestLog("Actual Answer is "+saveMoneyAnswer.trim()+ "  and Expected Answer is: "+expectedAnswer+"", "PASS");
         }else{
      	   Report.updateTestLog("Actual Answer is "+saveMoneyAnswer.trim()+ "  and Expected Answer is: "+expectedAnswer+"", "FAIL");
         }*/
    }
    
    public void fualType(UserProfile userProfile, String fualtype) {
	/*    	 boolean status=browser.isElementVisibleWithXpath("Better.FualImage");
	    	 System.out.println("status"+status);
	    	if(status){
	      	   Report.updateTestLog("Expected Fual Image is available", "PASS");
	         }else{
	      	   Report.updateTestLog("Expected Fual Image is not available", "FAIL");
	         }*/
  
    	
    	String fualTitle=browser.getTextByXpath(pageProperties.getProperty("Better.FualTypeTitle")); 
    	if(fualTitle.trim().equals("Selected fuel type")){
      	   Report.updateTestLog("Actual Fual Title is: "+fualTitle.trim()+ "  and Expected Fual Title is : Selected fuel type", "PASS");
         }else{
      	   Report.updateTestLog("Actual Fual Title is: "+fualTitle.trim()+ "  and Expected Fual Title is : Selected fuel type", "FAIL");
         }
    	String FualType =browser.getTextByXpath(pageProperties.getProperty("Better.FualType")); 
    	if(fualtype.equals("Dual") && fualtype.equals("JI"))
    	{
    	if(FualType.trim().equals("Gas & Electricity")){
      	   Report.updateTestLog("Actual Selected Fual is: "+FualType.trim()+ "  and Expected Selected Fual is : Gas & Electricity", "PASS");
         }else{
      	   Report.updateTestLog("Actual Selected Fual is: "+FualType.trim()+ "  and Expected Selected Fual is : Gas & Electricity", "FAIL");
        }
    	}
    	if(fualtype.equals("Gas"))
    	{
    	if(FualType.trim().equals("Gas")){
      	   Report.updateTestLog("Actual Selected Fual is: "+FualType.trim()+ "  and Expected Selected Fual is : Gas", "PASS");
         }else{
      	   Report.updateTestLog("Actual Selected Fual is: "+FualType.trim()+ "  and Expected Selected Fual is : Gas", "FAIL");
        }
    	}
    	if(fualtype.equals("Electricity"))
    	{
    	if(FualType.trim().equals("Electricity")){
      	   Report.updateTestLog("Actual Selected Fual is: "+FualType.trim()+ "  and Expected Selected Fual is : Electricity", "PASS");
         }else{
      	   Report.updateTestLog("Actual Selected Fual is: "+FualType.trim()+ "  and Expected Selected Fual is : Electricity", "FAIL");
        }
    	}
    }	
    
    public void postCodeTitle(UserProfile userProfile) {
    	String postTitle =browser.getTextByXpath(pageProperties.getProperty("Better.SupplyCodeTitle")); 
    	if(postTitle.trim().equals("Your supply postcode")){
      	   Report.updateTestLog("Actual Post Code title is: "+postTitle.trim()+ "  and Expected Post Code title is : Your supply postcode", "PASS");
         }else{
      	   Report.updateTestLog("Actual Post code title is: "+postTitle.trim()+ "  and Expected Post Code title is : Your supply postcode", "FAIL");
        }
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	String accountNo=userProfile.getAccNumber();
		String postCodeExpected=new SiebelDataBase()
		     .getPostCode(accountNo);
    	String postcodeActual= browser.getTextByXpath(pageProperties.getProperty("Better.SupplyCode"));
    	if(postcodeActual.trim().equals(postCodeExpected))
    	{
    		Report.updateTestLog("Actual Post Code is: "+postcodeActual.trim()+ "  and Expected Post Code is : "+postCodeExpected, "PASS");
    	}else
    	{
    		Report.updateTestLog("Actual Post Code is: "+postcodeActual.trim()+ "  and Expected Post Code is : "+postCodeExpected, "FAIL");
    	}
    }
    
    public void currentTariff(UserProfile userProfile) {
    	String TariffTitle =browser.getTextByXpath(pageProperties.getProperty("Better.TariffTitle")); 
    	String currentSpend =browser.getTextByXpath(pageProperties.getProperty("Better.CurrentSpend")); 
    	if(TariffTitle.trim().contains("Your current tariff")){
      	   Report.updateTestLog("Expected Tariff Title is available: "+TariffTitle, "PASS");
         }else{
      	   Report.updateTestLog("Expected Tariff Title is not available: "+TariffTitle, "FAIL");
        }
    	System.out.println("HI"+pageProperties.getProperty("Better.TariffDoName"));
    	
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Better.TariffDoNameoriginal")))
    	{
	    	int countTName=browser.getChildElementsCountByXpath(pageProperties.getProperty("Better.TariffDoName"));
	    	for(int i=1;i<=countTName;i++)
	    	{
		    	String TariffName =browser.getTextByXpath(pageProperties.getProperty("Better.TariffDoubleName").replace("row", ""+i));
		    	if(i==1)
			    {
			    	String expectedTariff1 = userProfile.gettariffName1();
			    	if(TariffName.trim().contains(expectedTariff1)){
			       	   Report.updateTestLog("Expected Tariff Name is : "+expectedTariff1 +" available", "PASS");
			          }else{
			       	   Report.updateTestLog("Expected Tariff Name is : "+expectedTariff1 +" not available", "FAIL");
			         }
		    	}
		    	if(i==2)
		    	{
			    	String expectedTariff2 = userProfile.gettariffName2();
			    	if(TariffName.trim().contains(expectedTariff2)){
			      	   Report.updateTestLog("Expected Tariff Name is : "+expectedTariff2 +" available", "PASS");
			         }else{
			      	   Report.updateTestLog("Expected Tariff Name is : "+expectedTariff2 +" not available", "FAIL");
			        }
		    	}
	    	}
    	}
    	else
    	{
		    	String TariffName =browser.getTextByXpath(pageProperties.getProperty("Better.TariffSingleName"));
		    	
			    	String expectedTariff1 = userProfile.gettariffName1();
			    	if(TariffName.trim().contains(expectedTariff1)){
			       	   Report.updateTestLog("Expected Tariff Name is : "+expectedTariff1 +" available", "PASS");
			          }else{
			       	   Report.updateTestLog("Expected Tariff Name is : "+expectedTariff1 +" not available", "FAIL");
			         }
    	}
		    	
    }
    
   /* public void currentTariffnameDual(UserProfile userProfile) {
    	String TariffName =browser.getTextByXpath(pageProperties.getProperty("Better.Tariff")); 
    	if(TariffName.trim().equals("Standard")){
      	   Report.updateTestLog("Actual Tariff Name is: "+TariffName.trim()+ "  and Expected Tariff Name is : Standard", "PASS");
         }else{
      	   Report.updateTestLog("Actual Tariff Name is: "+TariffName.trim()+ "  and Expected Tariff Name is : Standard", "FAIL");
        }
    }*/
    
    public void currentSpendTitle(UserProfile userProfile) {
    	String CurrentSpendTitle =browser.getTextByXpath(pageProperties.getProperty("Better.CurrentSpendTitle")); 
    	if(CurrentSpendTitle.trim().equals("Your current spend")){
      	   Report.updateTestLog("Actual CurrentSpendTitle is: "+CurrentSpendTitle.trim()+ "  and Expected CurrentSpendTitle is : Your current spend", "PASS");
         }else{
      	   Report.updateTestLog("Actual CurrentSpendTitle is: "+CurrentSpendTitle.trim()+ "  and Expected CurrentSpendTitle is : Your current spend", "FAIL");
        }
    }
    
   /* public void currentSpendPound(UserProfile userProfile) {
    	
    	String pound =browser.getTextByXpath(pageProperties.getProperty("Better.CurrentSpend")); 
    	pound = pound.substring(0,1);
    	if(pound.trim().equals(""+'£')){
      	   Report.updateTestLog("Actual Pound symbol is: "+pound.trim()+ "  and Expected Pound symbol is : "+'£', "PASS");
         }else{
      	   Report.updateTestLog("Actual Pound symbol is: "+pound.trim()+ "  and Expected Pound symbol is : "+'£', "FAIL");
        }
    }*/
    
    public void currentSpendTimeSpan(UserProfile userProfile) {
    	String timeSpan =browser.getTextByXpath(pageProperties.getProperty("Better.CurrentSpendAnnualy")); 
    	if(timeSpan.trim().equals("Annually")){
      	   Report.updateTestLog("Actual Time Span is: "+timeSpan.trim()+ "  and Expected Time Span is : Annually", "PASS");
         }else{
      	   Report.updateTestLog("Actual Time Span is: "+timeSpan.trim()+ "  and Expected Time Span is : Annually", "FAIL");
        }
    }
    
   /* public void currentSpendCalculation(UserProfile userProfile) {
    	String forecast1 =browser.getTextByXpath(pageProperties.getProperty("Better.ForecastedCost1"));
    	forecast1 = forecast1.replaceAll("[^\\d(?!.)]", "");
    	String forecastsaving1 =browser.getTextByXpath(pageProperties.getProperty("Better.ForecastedCostSaving1")); 
    	forecastsaving1 = forecastsaving1.replaceAll("[^\\d(?!.)]", "");
    	String currentSpend =browser.getTextByXpath(pageProperties.getProperty("Better.CurrentSpend")); 
    	currentSpend = currentSpend.replaceAll("[^\\d(?!.)]", "");
    	double forecast=Double.valueOf(forecast1);
    	double forecastsaving=Double.valueOf(forecastsaving1);
    	double actual=Double.valueOf(currentSpend);
    	double expected=forecast + forecastsaving;
    	expected = Math.round(expected*100.0)/100.0;
    	if(actual==expected){
      	   Report.updateTestLog("Actual Spend is: "+actual+ "  and Expected Spend is : "+expected+"", "PASS");
         }else{
      	   Report.updateTestLog("Actual Spend is: "+actual+ "  and Expected Spend is : "+expected+"", "FAIL");
        }
    }*/
    
    public void tariffTableTextValidation(UserProfile userProfile, String fualtype) {
    	String tableHeading =browser.getTextByXpath(pageProperties.getProperty("Better.TariffTableTitle"));
    	if(tableHeading.trim().equals("Your tariff switch choice")){
       	   Report.updateTestLog("Actual Table Title is: "+tableHeading+ "  and Expected Table Title is : Your tariff switch choice", "PASS");
          }else{
       	   Report.updateTestLog("Actual Table Title is: "+tableHeading+ "  and Expected Table Title is : Your tariff switch choice", "FAIL");
         }
    	String tableColFirst =browser.getTextByXpath(pageProperties.getProperty("Better.TariffCol1Name"));
    	if(tableColFirst.trim().equals("Tariff")){
       	   Report.updateTestLog("Actual Table column 1st name is: "+tableColFirst+ "  and Expected is : Tariff ", "PASS");
          }else{
       	   Report.updateTestLog("Actual Table  column 1st name is: "+tableColFirst+ "  and Expected is : Tariff ", "FAIL");
         }
    	String tableColSecond =browser.getTextByXpath(pageProperties.getProperty("Better.TariffCol2Name"));
    	if(tableColSecond.trim().equals("Features & benefits")){
        	   Report.updateTestLog("Actual Table column 2nd name is: "+tableColSecond+ "  and Expected is : Features & benefits  ", "PASS");
           }else{
        	   Report.updateTestLog("Actual Table  column 2nd name is: "+tableColSecond+ "  and Expected is : Features & benefits  ", "FAIL");
          }
    	String tableColThird =browser.getTextByXpath(pageProperties.getProperty("Better.TariffCol3Name"));
    	if(tableColThird.trim().equals("Exit fee")){
        	   Report.updateTestLog("Actual Table column 3rd name is: "+tableColThird+ "  and Expected is : Exit fee ", "PASS");
           }else{
        	   Report.updateTestLog("Actual Table  column 3rd name is: "+tableColThird+ "  and Expected is : Exit fee  ", "FAIL");
          }
    	String tableColFourth =browser.getTextByXpath(pageProperties.getProperty("Better.TariffCol4Name"));
    	if(tableColFourth.trim().equals("Forecasted cost *")){
        	   Report.updateTestLog("Actual Table column 4th name is: "+tableColFourth+ "  and Expected is : Forecasted cost * ", "PASS");
           }else{
        	   Report.updateTestLog("Actual Table  column 4th name is: "+tableColFourth+ "  and Expected is : Forecasted cost *  ", "FAIL");
          }
/*    	String foteCasted =browser.getTextByXpath(pageProperties.getProperty("Better.ForecastedCost"));
    	if(foteCasted.trim().contains("6% discount compared to Cash/cheque is included in the unit rates")){
        	   Report.updateTestLog("Actual Text is: "+foteCasted+ "  and Expected Text is : " +
        	   		"[*]Forecasted cost includes any discounts, when choosing Direct Debit 6% discount compared to Cash/cheque is included in the unit rates", "PASS");
           }else{
        	   Report.updateTestLog("Actual Text is: "+foteCasted+ "  and Expected Text is : " +
           	   		"[*]Forecasted cost includes any discounts, when choosing Direct Debit 6% discount compared to Cash/cheque is included in the unit rates", "FAIL");
           }*/
    	/*if(browser.isTextPresent("smart")){
     	   Report.updateTestLog("Expected Text is available: " +
     	   		"* Forecasted costs is a rounded figure and is a quote based on the information provided by you on the 'Get a quote' page. Energy prices calculated on the date of comparison and are subject to change. 6% Direct Debit discount (when choosing Direct Debit compared to cash cheque) included within rounded unit rates. Where we supply gas and electricity to the same customer at the same property you'll receive one Dual Fuel discount. Where electricity is supplied through a credit meter, you'll receive a discount of £15 per year applied to your bill, pro-rated across your billing period.", "PASS");
        }else{
     	   Report.updateTestLog("Expected Text is not available: " +
        	   		"* Forecasted costs is a rounded figure and is a quote based on the information provided by you on the 'Get a quote' page. Energy prices calculated on the date of comparison and are subject to change. 6% Direct Debit discount (when choosing Direct Debit compared to cash cheque) included within rounded unit rates. Where we supply gas and electricity to the same customer at the same property you'll receive one Dual Fuel discount. Where electricity is supplied through a credit meter, you'll receive a discount of £15 per year applied to your bill, pro-rated across your billing period.", "FAIL");
        }*/
    	if(fualtype.equals("Dual"))
    	{
    	if(browser.isTextPresent("15 Dual Fuel discount")){
      	   Report.updateTestLog("Expected Text is available: " +
      	   		"[1] £15 Dual Fuel discount", "PASS");
         }else{
      	   Report.updateTestLog("Expected Text is not available: " +
         	   		"[1] £15 Dual Fuel discount", "FAIL");
         }   
    	}
    	String tableColFifth =browser.getTextByXpath(pageProperties.getProperty("Better.TariffCol5Name"));
    	if(tableColFifth.trim().equals("Forecasted savings")){
        	   Report.updateTestLog("Actual Table column 5th name is: "+tableColFifth+ "  and Expected is : Forecasted savings ", "PASS");
           }else{
        	   Report.updateTestLog("Actual Table  column 5th name is: "+tableColFifth+ "  and Expected is : Forecasted savings  ", "FAIL");
          }
     }
    
    public void tariffCount(UserProfile userProfile) {
    	
    	int count=browser.getChildElementsCountByXpath(pageProperties.getProperty("Better.TariffCount"));
    	//int countExpected=Integer.parseInt(userProfile.getTariff());
    	if(count>=1){
     	   Report.updateTestLog("Total no.of Tariff count is: "+count+ "" , "PASS");
        }else{
     	   Report.updateTestLog("Total no.of Tariff count is: "+count+ "", "FAIL");
       }
    	count=count+1;
    	for(int i=2;i<=count;i++)
		{
    		 String Tariffname=browser.getTextByXpath(pageProperties.getProperty("Better.TariffName").replace("row", ""+i));
    		 if(!Tariffname.equals("")){
    			 int j=i-1;
    	     	   Report.updateTestLog("Tariff "+j+" name is: "+Tariffname+ "" , "PASS");
    	        }else{
    	        int j=i-1;
    	     	   Report.updateTestLog("Tariff "+j+" name is: "+Tariffname+ "", "FAIL");
    	 }
		}
    }
    
    public void tariffCalculation(UserProfile userProfile) {
    	
    	int count=browser.getChildElementsCountByXpath(pageProperties.getProperty("Better.TariffCount"));
    	count=count+1;
    	for(int i=2;i<=count;i++)
		{
    		String forecast1 =browser.getTextByXpath(pageProperties.getProperty("Better.ForecastedCost1").replace("row", ""+i));
//    		String forecast1 =browser.getTextByXpath(".//*[@id='tariffsTable']/tr["+i+"]/td[4]/div[1]");
        	forecast1 = forecast1.replaceAll("[^\\d(?!.)]", "");
        	String forecastsaving1 =browser.getTextByXpath(pageProperties.getProperty("Better.ForecastedCostSaving1").replace("row", ""+i)); 
//        	String forecastsaving1 =browser.getTextByXpath(".//*[@id='tariffsTable']/tr["+i+"]/td[5]/p[2]/span"));
        	forecastsaving1 = forecastsaving1.replaceAll("[^\\d(?!.)]", "");
        	String currentSpend =browser.getTextByXpath(pageProperties.getProperty("Better.CurrentSpend")); 
        	currentSpend = currentSpend.replaceAll("[^\\d(?!.)]", "");
        	double forecast=Double.valueOf(forecast1);
        	double forecastsaving=Double.valueOf(forecastsaving1);
        	double actual=Double.valueOf(currentSpend);
        	double expected=actual-forecast;
        	expected = Math.round(expected*100.0)/100.0;
        	String expe=Double.toString(expected);
        	
     		String arr=forecast1.split("\\.")[1];
     		if(arr.matches("^[0-9]{2}$"))
     		{
     			String Tariffname=browser.getTextByXpath(pageProperties.getProperty("Better.TariffName").replace("row", ""+i));
    			 Report.updateTestLog("Expected 2 decimal is avaialable for ForeCasted cost for Tariff name"+Tariffname+" and the Forcasted cost is:"+forecast1 , "PASS");
 	   		 }else
 	   		 {
 	   			String Tariffname=browser.getTextByXpath(pageProperties.getProperty("Better.TariffName").replace("row", ""+i));
 	   			 Report.updateTestLog("Expected 2 decimal is not avaialable for ForeCasted cost for Tariff"+Tariffname+" and the Forcasted cost is:"+forecast1, "FAIL");
 	   		 }
     		String saveSplit=forecastsaving1.split("\\.")[1];
     		if(saveSplit.matches("^[0-9]{2}$"))
     		{
     			String Tariffname=browser.getTextByXpath(pageProperties.getProperty("Better.TariffName").replace("row", ""+i));
    			 Report.updateTestLog("Expected 2 decimal is avaialable for ForeCasted Saved for Tariff"+Tariffname+" and the Forcasted save cost is:"+forecastsaving1 , "PASS");
 	   		 }else
 	   		 {
 	   			String Tariffname=browser.getTextByXpath(pageProperties.getProperty("Better.TariffName").replace("row", ""+i));
 	   			 Report.updateTestLog("Expected 2 decimal is not avaialable for ForeCasted Saved for Tariff"+Tariffname+" and the Forcasted save cost is:"+forecastsaving1, "FAIL");
 	   		 }
        	if(expe.contains("-"))
        	{
        		String text=browser.getTextByXpath(pageProperties.getProperty("Better.SaveExpand").replace("row", ""+i));
        		if(text.trim().equals("Extra spend")){
        			String Tariffname=browser.getTextByXpath(pageProperties.getProperty("Better.TariffName").replace("row", ""+i));
        		 Report.updateTestLog("Actual Text is: "+text+ " for tariff name "+Tariffname+" and Expected text is : Extra spend and the Forcasted save cost is:"+forecastsaving1+"", "PASS");
	            }else{
	            	String Tariffname=browser.getTextByXpath(pageProperties.getProperty("Better.TariffName").replace("row", ""+i));
	         	   Report.updateTestLog("Actual Text is: "+text+" for tariff name "+Tariffname+"   and Expected text is : Extra spend and the Forcasted save cost is:"+forecastsaving1+"", "FAIL");
	           }
        	}else
        	{
        		String text=browser.getTextByXpath(pageProperties.getProperty("Better.SaveExpand").replace("row", ""+i));
        		if(text.trim().equals("Save")){
        			String Tariffname=browser.getTextByXpath(pageProperties.getProperty("Better.TariffName").replace("row", ""+i));
        		 Report.updateTestLog("Actual Text is: "+text+ " for tariff name "+Tariffname+"   and Expected text is : Save and the Forcasted save cost is:"+forecastsaving1+"", "PASS");
	            }else{
	            	String Tariffname=browser.getTextByXpath(pageProperties.getProperty("Better.TariffName").replace("row", ""+i));
	         	   Report.updateTestLog("Actual Text is: "+text+" for tariff name"+Tariffname+"   and Expected text is : Save and the Forcasted save cost is:"+forecastsaving1+"", "FAIL");
	           }
        	}
         String costperYear=browser.getTextByXpath(pageProperties.getProperty("Better.CostPerYear").replace("row", ""+i));
         if(costperYear.trim().equals("per year")){
        	 String Tariffname=browser.getTextByXpath(pageProperties.getProperty("Better.TariffName").replace("row", ""+i));
 		 Report.updateTestLog("Actual Text is: "+costperYear+ "  for forcasted cost tariff name"+Tariffname+"   and Expected text is : per year", "PASS");
         }else{
        	 String Tariffname=browser.getTextByXpath(pageProperties.getProperty("Better.TariffName").replace("row", ""+i));
      	   Report.updateTestLog("Actual Text is: "+costperYear+" for forcasted cost tariff name"+Tariffname+"  and Expected text is : per year", "FAIL");
        }
         String saveperYear=browser.getTextByXpath(pageProperties.getProperty("Better.SavingPerYear").replace("row", ""+i));
         if(saveperYear.trim().equals("per year")){
        	 String Tariffname=browser.getTextByXpath(pageProperties.getProperty("Better.TariffName").replace("row", ""+i));
 		 Report.updateTestLog("Actual Text is: "+saveperYear+ "  for forcasted Savings tariff name"+Tariffname+"   and Expected text is : per year", "PASS");
         }else{
        	 String Tariffname=browser.getTextByXpath(pageProperties.getProperty("Better.TariffName").replace("row", ""+i));
      	   Report.updateTestLog("Actual Text is: "+saveperYear+" for forcasted Savings tariff name"+Tariffname+" tariff and Expected text is : per year", "FAIL");
        }
    }
    }
    
    public void twoDecimalCurrentSpend(UserProfile userProfile) {
	    	String currentSpend =browser.getTextByXpath(pageProperties.getProperty("Better.CurrentSpend")); 
	    	currentSpend = currentSpend.replaceAll("[^\\d(?!.)]", "");
	    	//double actual=Double.valueOf(currentSpend);
    	    //String b=Double.toString(actual);
    		String arr=currentSpend.split("\\.")[1];
    		System.out.println(arr);
    		if(arr.matches("^[0-9]{2}$"))
    		{
   			 Report.updateTestLog("Expected 2 decimal is available for Current Spend: " + currentSpend, "PASS");
	   		 }else
	   		 {
	   			 Report.updateTestLog("Expected 2 decimal is not available  for Current Spend: " + currentSpend, "FAIL");
	   		 }
	    }
	    
	 public void betterBanner(UserProfile userProfile) {
			
		 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Better.Banner")))
		 {
			 String Tariffname=browser.getTextByXpath(pageProperties.getProperty("Better.TariffName").replace("row", ""+2));
			 Report.updateTestLog("Expected Better Deal banner is avaialable for the Tariff"+Tariffname, "PASS");
		 }else
		 {
			 String Tariffname=browser.getTextByXpath(pageProperties.getProperty("Better.TariffName").replace("row", ""+2));
			 Report.updateTestLog("Expected Better Deal banner is not avaialable for the Tariff"+Tariffname, "FAIL");
		 }
	    }
	 
	 public void switchNow(UserProfile userProfile) {
		 int count=browser.getChildElementsCountByXpath(pageProperties.getProperty("Better.TariffCount"));
	    	count=count+1;
	    	for(int i=2;i<=count;i++)
			{
	    		String Tariffname=browser.getTextByXpath(pageProperties.getProperty("Better.TariffName").replace("row", ""+i));
	    		verifyAndClickWithXpath(pageProperties.getProperty("Better.SwitchNow").replace("row", ""+i), "Switch Now Link Clicked");
	    		verifyAndClickWithXpath(pageProperties.getProperty("Better.cloaseLayout"), "Switch Now Close Layout for Tariff"+Tariffname);
//	    		browser.clickWithXpath(pageProperties.getProperty("Better.SwitchNow").replace("row", ""+i));
//	    		browser.clickWithXpath(pageProperties.getProperty("Better.cloaseLayout"));
	    		///////////verifyIsTextPresent("Energy Smart", "Expected Text is available");
	    		verifyAndClickWithXpath(pageProperties.getProperty("Better.SwitchNow").replace("row", ""+i), "Switch Now Link Clicked");
	    		if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Better.YES")))
	    		{
	    		Report.updateTestLog("Switch Now default selection is YES ", "PASS");
	    		verifyAndClickWithXpath(pageProperties.getProperty("Better.submitLayout"), "Switch Now Submit Layout clicked for Tariff"+Tariffname);
	    		}
//	    		browser.clickWithXpath(pageProperties.getProperty("Better.SwitchNow").replace("row", ""+i));
//	    		browser.clickWithXpath(pageProperties.getProperty("Better.submitLayout"));
	    		verifyIsTextPresent("EnergySmart");
	    		int j=i-1;
	    		browser.browserBack();
	    		verifyAndClickWithXpath(pageProperties.getProperty("Better.SwitchNow").replace("row", ""+i), "Switch Now No option Clicked for tariff"+Tariffname);
	    		verifyAndClickWithXpath(pageProperties.getProperty("Better.noThanks"), "Switch Now  Layout No option clicked for Tariff"+Tariffname);
	    		verifyAndClickWithXpath(pageProperties.getProperty("Better.submitLayout"), "Switch Now Submit Layout clicked for Tariff"+Tariffname);
//	    		browser.clickWithXpath(pageProperties.getProperty("Better.SwitchNow").replace("row", ""+i));
//	    		browser.clickWithXpath(pageProperties.getProperty("Better.noThanks"));
//	    		browser.clickWithXpath(pageProperties.getProperty("Better.submitLayout"));
	    		verifyIsTextPresent(Tariffname);
	    		browser.browserBack();
			}
	    }
 
	 public void findOutMore(UserProfile userProfile) {
	 	
		 int count=browser.getChildElementsCountByXpath(pageProperties.getProperty("Better.TariffCount"));
	    	count=count+1;
	    	for(int i=2;i<=count;i++)
			{
	    		 String Tariffname=browser.getTextByXpath(pageProperties.getProperty("Better.TariffName").replace("row", ""+i));
	    		 browser.clickWithXpath(pageProperties.getProperty("Better.findoutMore").replace("row", ""+i));
	    		 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Better.TariffNameSecondPage")))
		    		 {
			    		 String TariffnameSecondPage=browser.getTextByXpath(pageProperties.getProperty("Better.TariffNameSecondPage"));
			    		 if(Tariffname.trim().equals(TariffnameSecondPage))
			    		 {
			    			 Report.updateTestLog("Expected Tariff name is avaialable in FindOutMorePage: "+TariffnameSecondPage, "PASS");
			    		 }else
			    		 {
			    			 Report.updateTestLog("Expected Tariff name is avaialable in FindOutMorePage: "+ TariffnameSecondPage, "FAIL");
			    		 }
		    		 }
		    		 else
		    		 {
		    			 Report.updateTestLog("404 Not found for the Tariff: "+Tariffname, "FAIL");
		    		 }
	    	    browser.browserBack();
	    	    try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	    }
 
	 public void whatisthis(UserProfile userProfile) {
	 	
		 int count=browser.getChildElementsCountByXpath(pageProperties.getProperty("Better.TariffCount"));
	    	count=count+1;
	    	for(int i=2;i<=count;i++)
			{	
	    		try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	    		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Better.whatisthis").replace("row", ""+i)))
	    		{
	    			int j=i-1;
	    			String Tariffname=browser.getTextByXpath(pageProperties.getProperty("Better.TariffName").replace("row", ""+i));
	    			verifyAndClickWithXpath(pageProperties.getProperty("Better.whatisthis").replace("row", ""+i), "Overlay for What is this?  Tariff is:"+Tariffname);
//	    			verifyIsTextPresent("What is this?");
//	    			verifyIsTextPresent("What is this overlay link show");
	    			verifyAndClickWithXpath(pageProperties.getProperty("Better.whatLayoutClose").replace("row", ""+i), "Overlay close for What is this? Tariff is:"+Tariffname);
	    		} 
			}
	    	for(int i=2;i<=count;i++)
			{
	    		try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	    		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Better.UnitRateTariff").replace("row", ""+i)))
	    		{
	    			int j=i-1;
	    			String Tariffname=browser.getTextByXpath(pageProperties.getProperty("Better.TariffName").replace("row", ""+i));
	    			verifyAndClickWithXpath(pageProperties.getProperty("Better.UnitRateTariff").replace("row", ""+i),"Overlay for UnitRate Tariff is:"+Tariffname);
	    			try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	    			verifyAndClickWithXpath(pageProperties.getProperty("Better.UnitRateCloseLayout"),"Overlay close for Unit rate Tariff is:"+Tariffname);
	    		}
			}
	    }
	 
	 /*public void directDebit(UserProfile userProfile, String directDebitELE, String directDebitGAS) {
	 	if(directDebitELE.equals("DD")&&directDebitGAS.equals("CC"))
	 	{
		  String ddTitle=browser.getTextByXpath(pageProperties.getProperty("Better.ChangeTheWay"));
			if(ddTitle.trim().equals("Change the way you pay"))
			{
   			 Report.updateTestLog("Expected Direct Debit Title is available: "+ddTitle, "PASS");
	   		 }else
	   		 {
	   			 Report.updateTestLog("Expected Direct Debit Title is not available"+ddTitle, "FAIL");
	   		 }
		  String ddContent=browser.getTextByXpath(pageProperties.getProperty("Better.ChangeTheWayText"));
			if(ddContent.trim().contains("Switch to Direct Debit to recevice around"))
			{
   			 Report.updateTestLog("Expected Direct Debit Content is available: "+ddContent, "PASS");
	   		 }else
	   		 {
	   			 Report.updateTestLog("Expected Direct Debit Content is not available"+ddContent, "FAIL");
	   		 }
			String directDebitLink=browser.getTextByXpath(pageProperties.getProperty("Better.DDLink"));
			if(directDebitLink.trim().equals("Switch to Direct Debit"))
			{
  			 Report.updateTestLog("Expected DD link is available: "+directDebitLink, "PASS");
	   		 }else
	   		 {
	   			 Report.updateTestLog("Expected DD link is not available"+directDebitLink, "FAIL");
	   		 }	
	 	}
	 	
	 	if(directDebitELE.equals("DD")&&directDebitGAS.equals("DD") || directDebitELE.equals("VDD")&&directDebitGAS.equals("VDD"))
	 	{
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Better.ChangeTheWay")))
			{
  			 Report.updateTestLog("Direct Debit Title is available: ", "FAIL");
	   		 }else
	   		 {
	   			 Report.updateTestLog("Direct Debit Title is not available", "PASS");
	   		 }
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Better.ChangeTheWayText")))
			{
  			 Report.updateTestLog("Direct Debit Content is available: ", "FAIL");
	   		 }else
	   		 {
	   			 Report.updateTestLog("Direct Debit Content is not available", "PASS");
	   		 }
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Better.DDLink")))
			{
  			 Report.updateTestLog("Direct Debit link is available: ", "FAIL");
	   		 }else
	   		 {
	   			 Report.updateTestLog("Direct Debit link is not available", "PASS");
	   		 }
	 	}
	    }
*/ 
/*	 public void nector(UserProfile userProfile, String nectorRegistered) {
		 if(nectorRegistered.equals("NO"))
		 {			 
		  String nectorTitle=browser.getTextByXpath(pageProperties.getProperty("Better.NectorTitle"));
			if(nectorTitle.trim().equals("Collect Nectar points"))
			{
  			 Report.updateTestLog("Expected Nector Title is available: "+nectorTitle, "PASS");
	   		 }else
	   		 {
	   			 Report.updateTestLog("Expected Nector Title is not available"+nectorTitle, "FAIL");
	   		 }
		  String nectorContent=browser.getTextByXpath(pageProperties.getProperty("Better.NectorPoint"));
			if(nectorContent.trim().equals("Collect Nectar points when you manage your account and get your bill online."))
			{
  			 Report.updateTestLog("Expected Nector Content is available: "+nectorContent, "PASS");
	   		 }else
	   		 {
	   			 Report.updateTestLog("Expected Nector Content is not available"+nectorContent, "FAIL");
	   		 }
		  String nectorLink=browser.getTextByXpath(pageProperties.getProperty("Better.NectorLink"));
			if(nectorLink.trim().equals("Sign up for free today"))
			{
  			 Report.updateTestLog("Expected Nector link is available: "+nectorLink, "PASS");
	   		 }else
	   		 {
	   			 Report.updateTestLog("Expected Nector link is not available"+nectorLink, "FAIL");
	   		 }	
		 }
		 if(nectorRegistered.equals("YES"))
		 {			 
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Better.NectorTitle")))
			{
  			 Report.updateTestLog("Nector Title is available: ", "FAIL");
	   		 }else
	   		 {
	   			 Report.updateTestLog("Nector Title is not available", "PASS");
	   		 }
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Better.NectorPoint")))
			{
  			 Report.updateTestLog("Nector Content is available: ", "FAIL");
	   		 }else
	   		 {
	   			 Report.updateTestLog("Nector Content is not available", "PASS");
	   		 }
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Better.NectorLink")))
			{
  			 Report.updateTestLog("Nector link is available: ", "FAIL");
	   		 }else
	   		 {
	   			 Report.updateTestLog(" Nector link is not available", "PASS");
	   		 }	
		 }
	    }*/
	
	 public void directDebit(UserProfile userProfile, String directDebitELE, String directDebitGAS) {
		 	if((directDebitELE.equals("DD")&&directDebitGAS.equals("CC")) || directDebitELE.equals("CC")&&directDebitGAS.equals("DD")|| directDebitELE.equals("SO")&&directDebitGAS.equals("DD")
		 			|| directDebitELE.equals("VDD")&&directDebitGAS.equals("MC") || directDebitELE.equals("CC")&&directDebitGAS.equals("CC")
		 			|| directDebitELE.equals("CC")&&directDebitGAS.equals("DD"))
		 	{
		 		try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		 		 if(browser.isTextPresent("Change the way you pay"))
				 {
		  			 Report.updateTestLog("Expected DD Title is available for Direct debit promotion: Change the way you pay", "PASS");
			   		 }else
			   		 {
			   			 Report.updateTestLog("Expected DD Title is not available  for Direct debit promotion: Change the way you pay", "FAIL");
			   		 }
				 if(browser.isTextPresent("Switch to Direct Debit to recevice around"))
					{
		  			 Report.updateTestLog("Expected DD Content is available for Direct debit promotion", "PASS");
			   		 }else
			   		 {
			   			 Report.updateTestLog("Expected DD Content is not available for Direct debit promotion", "FAIL");
			   		 }
				 if(browser.isTextPresent("Switch to Direct Debit"))
					{
		  			 Report.updateTestLog("Expected DD link is available for Direct debit promotion: Switch to Direct Debit", "PASS");
			   		 }else
			   		 {
			   			 Report.updateTestLog("Expected DD link is not available for Direct debit promotion: Switch to Direct Debit", "FAIL");
			   		 }	
		 	}
		 	
		 	if((directDebitELE.equals("DD")&&directDebitGAS.equals("DD")) || (directDebitELE.equals("VDD")&&directDebitGAS.equals("VDD"))
		 			|| (directDebitELE.equals("VDD")&&directDebitGAS.equals("DD")) || (directDebitELE.equals("DD")&&directDebitGAS.equals("VDD")))
		 	{
		 		 if(!browser.isTextPresent("Change the way you pay"))
				 {
		  			 Report.updateTestLog("Expected DD Title is not available  for Direct debit promotion: Change the way you pay for Registered DD status- YES", "PASS");
			   		 }else
			   		 {
			   			 Report.updateTestLog("Expected DD Title is available for Direct debit promotion: Change the way you pay for Registered DD status- YES", "FAIL");
			   		 }
				 if(!browser.isTextPresent("Switch to Direct Debit to recevice around £67 discount a year off your energy bill."))
					{
		  			 Report.updateTestLog("Expected DD Content is not available for Direct debit promotion and Registered DD status- YES", "PASS");
			   		 }else
			   		 {
			   			 Report.updateTestLog("Expected DD Content is available for Registered DD status- YES", "FAIL");
			   		 }
				 if(!browser.isTextPresent("Switch to Direct Debit"))
					{
		  			 Report.updateTestLog("Expected DD link is not available: Switch to Direct Debit  for Direct debit promotion and Registered DD status- YES", "PASS");
			   		 }else
			   		 {
			   			 Report.updateTestLog("Expected DD link is available: Switch to Direct Debit  for Direct debit promotion for Direct debit promotion and Registered DD status- YES", "FAIL");
			   		 }	
		 	}
		    }
	 
	 public void directDebitSingle(UserProfile userProfile, String directDebit) {
		 	if(directDebit.equals("CC") || directDebit.equals("FD") || directDebit.equals("MC"))
		 	{
		 		try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		 		 if(browser.isTextPresent("Change the way you pay"))
				 {
		  			 Report.updateTestLog("Expected DD Title for Direct Debit Promotion is available: Change the way you pay", "PASS");
			   		 }else
			   		 {
			   			 Report.updateTestLog("Expected DD Title for Direct Debit Promotion is  not available: Change the way you pay", "FAIL");
			   		 }
				 if(browser.isTextPresent("Switch to Direct Debit to recevice around"))
					{
		  			 Report.updateTestLog("Expected DD Content for Direct Debit Promotion is available", "PASS");
			   		 }else
			   		 {
			   			 Report.updateTestLog("Expected DD Content for Direct Debit Promotion is not available", "FAIL");
			   		 }
				 if(browser.isTextPresent("Switch to Direct Debit"))
					{
		  			 Report.updateTestLog("Expected DD link for Direct Debit Promotion is available: Switch to Direct Debit", "PASS");
			   		 }else
			   		 {
			   			 Report.updateTestLog("Expected DD link for Direct Debit Promotion is not available: Switch to Direct Debit", "FAIL");
			   		 }	
		 	}
		 	
		 	if(directDebit.equals("DD") || directDebit.equals("VDD") )
		 	{
		 		 if(!browser.isTextPresent("Change the way you pay"))
				 {
		  			 Report.updateTestLog("Expected DD Title for Direct Debit Promotion is not available: Change the way you pay for Registered DD status- YES", "PASS");
			   		 }else
			   		 {
			   			 Report.updateTestLog("Expected DD Title for Direct Debit Promotion is available: Change the way you pay for Registered DD status- YES", "FAIL");
			   		 }
				 if(!browser.isTextPresent("Switch to Direct Debit to recevice around £67 discount a year off your energy bill."))
					{
		  			 Report.updateTestLog("Expected DD Content for Direct Debit Promotion is not available for Registered DD status- YES", "PASS");
			   		 }else
			   		 {
			   			 Report.updateTestLog("Expected DD Content for Direct Debit Promotion is available for Registered DD status- YES", "FAIL");
			   		 }
				 if(!browser.isTextPresent("Switch to Direct Debit"))
					{
		  			 Report.updateTestLog("Expected DD link for Direct Debit Promotion is not available: Switch to Direct Debit for Registered DD status- YES", "PASS");
			   		 }else
			   		 {
			   			 Report.updateTestLog("Expected DD link for Direct Debit Promotion is available: Switch to Direct Debit for Registered DD status- YES", "FAIL");
			   		 }	
		 	}
		    }

	 public void nector(UserProfile userProfile, String nectorRegistered) {
		 if(nectorRegistered.equals("NO"))
		 {	
			 if(browser.isTextPresent("Collect Nectar points"))
			 {
	  			 Report.updateTestLog("Expected Nector Title for Nector Promotion is available: Collect Nectar points", "PASS");
		   		 }else
		   		 {
		   			 Report.updateTestLog("Expected Nector Title for Nector Promotion is not available Collect Nectar points", "FAIL");
		   		 }
			 if(browser.isTextPresent("Collect Nectar points when you manage your account and get your bill online."))
				{
	  			 Report.updateTestLog("Expected Nector Content for Nector Promotion is available: Collect Nectar points when you manage your account and get your bill online.", "PASS");
		   		 }else
		   		 {
		   			 Report.updateTestLog("Expected Nector Content for Nector Promotion is not available: Collect Nectar points when you manage your account and get your bill online.", "FAIL");
		   		 }
			/* if(browser.isTextPresent("Sign up for free today"))
				{
	  			 Report.updateTestLog("Expected Nector link for Nector Promotion is available: Sign up for free today", "PASS");
		   		 }else
		   		 {
		   			 Report.updateTestLog("Expected Nector link for Nector Promotion is not available: Sign up for free today", "FAIL");
		   		 }	*/
		 }
		 if(nectorRegistered.equals("YES"))
		 {	
			 if(!browser.isTextPresent("Collect Nectar points"))
			 {
	  			 Report.updateTestLog("Collect Nectar points Title for Nector Promotion is not available-Nector Registered Status-YES", "PASS");
		   		 }else
		   		 {
		   			 Report.updateTestLog("Collect Nectar points Title for Nector Promotion is available-Nector Registered Status-YES", "FAIL");
		   		 }
			 if(!browser.isTextPresent("Collect Nectar points when you manage your account and get your bill online."))
				{
	  			 Report.updateTestLog("Collect Nectar Content for Nector Promotion is not available-Nector Registered Status-YES", "PASS");
		   		 }else
		   		 {
		   			 Report.updateTestLog("Collect Nectar Content for Nector Promotion is available-Nector Registered Status-YES", "FAIL");
		   		 }
			 /*if(!browser.isTextPresent("Sign up for free today"))
				{
	  			 Report.updateTestLog("Nectar link for Nector Promotion is not available-Nector Registered Status-YES", "PASS");
		   		 }else
		   		 {
		   			 Report.updateTestLog("Nectar link for Nector Promotion is available-Nector Registered Status-YES", "FAIL");
		   		 }	*/
		 }
	    }
	 
	 public void esmart(UserProfile userProfile, String esmartEle, String esmartGas) {
		  	
		 if((esmartEle.equals("NO")&& esmartGas.equals("NO")) || (esmartEle.equals("NO")&& esmartGas.equals("YES"))
			|| (esmartEle.equals("YES")&& esmartGas.equals("NO")))
		 {
			 if(browser.isTextPresent("Sign up to EnergySmart"))
				{
	  			 Report.updateTestLog("Sign up to EnergySmart for Esmart Promotion is available-Esmart Registered Status-NO", "PASS");
		   		 }else
		   		 {
		   			 Report.updateTestLog("Sign up to EnergySmart for Esmart Promotion is not available-Esmart Registered Status-NO", "FAIL");
		   		 }	
		 }
		  /*String esmartTitle=browser.getTextByXpath(pageProperties.getProperty("Better.Esmart"));
			if(esmartTitle.trim().equals("Esmart"))
			{
 			 Report.updateTestLog("Expected Esmart Title is available: "+esmartTitle , "PASS");
	   		 }else
	   		 {
	   			 Report.updateTestLog("Expected Esmart Title is not available"+esmartTitle , "FAIL");
	   		 }*/
		 
		/* if(!esmartEle.equals("YES")&& esmartGas.equals("YES"))
				 {
			 if(browser.isTextPresent("Sign up to EnergySmart"))
				{
	  			 Report.updateTestLog("Sign up to EnergySmart for Esmart Promotion is not available-Esmart Registered Status-YES", "PASS");
		   		 }else
		   		 {
		   			 Report.updateTestLog("Sign up to EnergySmart for Esmart Promotion is available-Esmart Registered Status-YES", "FAIL");
		   		 }
	    }*/
	 }
	 
	 public void esmartSingle(UserProfile userProfile, String esmart) {
		  	
		 if(esmart.equals("NO"))
		 {
			 if(browser.isTextPresent("Sign up to EnergySmart"))
				{
	  			 Report.updateTestLog("Sign up to EnergySmart for Esmart Promotion is available-Esmart Registered Status-NO", "PASS");
		   		 }else
		   		 {
		   			 Report.updateTestLog("Sign up to EnergySmart for Esmart Promotion is not available-Esmart Registered Status-NO", "FAIL");
		   		 }	
		 }
		 
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 /*if(esmart.equals("YES"))
				 {
			 if(!browser.isTextPresent("Sign up to EnergySmart"))
				{
	  			 Report.updateTestLog("Sign up to EnergySmart for Esmart Promotion is not available-Esmart Registered Status-YES", "PASS");
		   		 }else
		   		 {
		   			 Report.updateTestLog("Sign up to EnergySmart for Esmart Promotion is available-Esmart Registered Status-YES", "FAIL");
		   		 }
	    }*/
	 }
	 
	 public void errorMessage(UserProfile userProfile) {
	     String errorMessage=browser.getTextByXpath(pageProperties.getProperty("Better.ErrorMessage"));	
	     errorMessage = errorMessage.replaceAll("^[ |\t]*\n$", "");
	     System.out.println("out"+errorMessage);
		 if(errorMessage.trim().contains("re working hard to resolve this as soon as possible, so please come back and try later"))
		 {
			 Report.updateTestLog("Expected Error Message is avaialable: "+errorMessage, "PASS");
		 }else
		 {
			 Report.updateTestLog("Expected Error Message is not avaialable: "+errorMessage, "FAIL");
		 }
	    }
	 
	 public void loginErrorMessage(UserProfile userProfile) {
	     String errorMessage=browser.getTextByXpath(pageProperties.getProperty("Better.LoginErrorMessage"));	
	     System.out.println("out"+errorMessage);
		 if(errorMessage.trim().equals("Sorry, but there is a problem with some of the information you have submitted."))
		 {
			 Report.updateTestLog("Expected Error Message is avaialable: "+errorMessage, "PASS");
		 }else
		 {
			 Report.updateTestLog("Expected Error Message is not avaialable: "+errorMessage, "FAIL");
		 }
	    }
	 
	 // ********************************* RMR Changes *************************** //
	 
	 public void navigateToTariffCheckPage(){
		 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("Better.TariffCheck"))){
		 verifyAndClickWithXpath(pageProperties.getProperty("Better.TariffCheck"),"Your Tariff check link is clicked successfully");
		 Report.updateTestLog("Your Tariff link is clicked Successfully", "Pass");
		 }
		 else{
			 Report.updateTestLog("Your Tariff link is not clicked Successfully", "Fail");	 
		 }
		 
	 }
	 
	 public void verifyTCRValue(String fuelType, String payment,UserProfile userProfile){
		 if(fuelType == "Gas"){
			 verifyTCRValueForGas(fuelType,payment,userProfile);
		 }
		 if(fuelType == "Electricity"){
			 verifyTCRValueForElectricity(fuelType,payment,userProfile);
		 }
		 if(fuelType == "Dual"){
			 verifyTCRValueForGas(fuelType,payment,userProfile);
			 verifyTCRValueForElectricity(fuelType,payment,userProfile);
		 }
	 }
	 
	 public void verifyTCRValueForGas(String fuelType, String payment,UserProfile userProfile){
		 String postCode = userProfile.getaddr();
		 String Region = new TCRCalculationPage().getPostcode(postCode);
		 System.out.println("8888888888888888888888888888888888 Region" + Region);
		 String tariff;
		 int TariffIncrement=1;
		 int count1 = 2;
		 String count = Integer.toString(count1);
		 PriceFinderRMR priceFinder = new TestDataHelper().getPriceFinderRMR("ZuesTariffNames"); 
		 while((tariff = priceFinder.getTariff(TariffIncrement)) !="" ){
			 String tariffOnScr = browser.getTextByXpath(pageProperties.getProperty("Better.gasTariffOnScreen").replace("NUM", count));
			 System.out.println("8888888888888888888888888888888888 tariffOnScr" + tariffOnScr);
			 String Combination = tariff+fuelType+payment+Region;
			 System.out.println("8888888888888888888888888888888888 Combination" + Combination);
			 String TCRValue = new TCRCalculationPage().verifyTCRForGasTariff(tariff, Combination);
			 String TCRValueOnScr = browser.getTextByXpath(pageProperties.getProperty("Better.gasTCRValue").replace("NUM", count));
			 System.out.println("8888888888888888888888888888888888 Property" + pageProperties.getProperty("Better.gasTCRValue").replace("NUM", count));
			 if(TCRValue == TCRValueOnScr){
				 Report.updateTestLog("TCR Value for gas of tariff: " + tariff + "is verified Expected value: " +TCRValue+ "Displayed Value: " +TCRValueOnScr, "Pass");
			 }
			 else{ 
				 Report.updateTestLog("Error in TCR Value for gas of Tariff: " + tariff + " Expected value: " +TCRValue+ "Displayed Value: " +TCRValueOnScr, "Fail");
			 }
			 
			 count1 = Integer.valueOf(count);
			 count1=count1+2;
			 TariffIncrement++;
		 }
	 }
	 
	 public void verifyTCRValueForElectricity(String fuelType, String payment,UserProfile userProfile){
		 fuelType = "Elec SR";
		 String postCode = userProfile.getaddr();
		 String Region = new TCRCalculationPage().getPostcode(postCode);
		 String tariff;
		 int TariffIncrement=1;
		 int count1 = 2;
		 String count = Integer.toString(count1);
		 PriceFinderRMR priceFinder = new TestDataHelper().getPriceFinderRMR("ZuesTariffNames"); 
		 while((tariff = priceFinder.getTariff(TariffIncrement)) !="" ){
			 String tariffOnScr = browser.getTextByXpath(pageProperties.getProperty("Better.elecTariffOnScreen"));
			 if(tariff.contains(tariffOnScr)){
			 String Combination = tariff+fuelType+payment+Region;
			 String TCRValue = new TCRCalculationPage().verifyTCRForElectricitySRTariff(tariff, Combination);
			 String TCRValueOnScr = browser.getTextByXpath(pageProperties.getProperty("Better.electricityTCRValue").replace("NUM", count));
			 if(TCRValue == TCRValueOnScr){
				 Report.updateTestLog("TCR Value for electricity of Tariff : " + tariff + " is verified Expected value: " +TCRValue+ "Displayed Value: " +TCRValueOnScr, "Pass");
			 }
			 else Report.updateTestLog("Error in TCR Value for electricity of Tariff: " + tariff + " Expected value: " +TCRValue+ "Displayed Value: " +TCRValueOnScr, "Fail");
		 }
			 TariffIncrement++;
			 count1 = Integer.valueOf(count);
			 count1=count1+2;
		 }
	 }
	 
	 
	 
    }
