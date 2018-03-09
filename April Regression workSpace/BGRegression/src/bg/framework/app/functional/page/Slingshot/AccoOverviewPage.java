package bg.framework.app.functional.page.Slingshot;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.GlobalErrorMessages;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.SiebelDataBase;
import org.openqa.selenium.NoSuchElementException;

import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class AccoOverviewPage extends BasePage {
	
	private final static String File_AccPage = "resources/Slingshot/AccountOverview.properties";
    private static Properties AccPageProperties = new PropertyLoader(File_AccPage).load();
    final String Pass_Str = "PASS";
    final String Fail_Str = "FAIL";
    
    public AccoOverviewPage() {

    }

// Verifying the values in the Bread Crumb in Account Overview Page

    public void verifyingForgotEmailBreadCrumb() {
        final String strBreadCrumbText = browser.getTextByXpath(AccPageProperties.getProperty("AccoOverviewPage.BreadCrumbID"));
        Report.updateTestLog("Displayed Bread Crumb Is  :" + strBreadCrumbText,Pass_Str);
    }

 // Verifying whether appropriate text is displayed in Account Overview Page once after logging with appropriate User Credentials
    
    public void verifyingMyAccount(UserProfile userProfile) {
    	accountOverviewTitleVerification();
    	//accountOverviewLogInUserValidation(userProfile);
    	//validateAccOverviewContents(userProfile);
//        final String strMyAccText = browser.getTextByXpath(AccPageProperties.getProperty("AccoOverviewPage.MyAccountID"));
//        System.out.println(strMyAccText);
//        if (strMyAccText.trim().equals("Your accounts")){
//        	Report.updateTestLog("Expected Text was displayed : "+strMyAccText, Pass_Str);
//        }
//        else{
//        	Report.updateTestLog("Expected Text was not displayed", Fail_Str);
       // }
    }
    private void accountOverviewTitleVerification(){
    	browser.wait(2000);
    	String accountOverview= browser.getTextByXpath("//title");
    	if(accountOverview.trim().contains("Account overview")){
    		Report.updateTestLog("Account overview page displayed ", Pass_Str);
    	}else{
    		Report.updateTestLog("Account overview page not displayed ", Fail_Str);
    	}
    }
    public void AccountOverViewVerification(UserProfile userProfile){
    	//accountOverviewTitleVerification();
    	verifyPageTitle("accountSummary");
    	loggeduserVerification(userProfile.getUCRN());
    	crosscellVerification();
    }
    
// Verify whether logged in User's Last Name is displayed in Account Overview Page by validating against the Siebel database 
//  for the appropriate UCRN
    
    public void accountOverviewLogInUserValidation(UserProfile userProfile){
    	//verifyingForgotEmailBreadCrumb();
    	verifyPageTitle("Account overview");
    	verifyingMyAccount(userProfile);
    	loggeduserVerification(userProfile.getUCRN());    	
   	    String AccNumber = userProfile.getAccNumber();
    	verifyCustomerAddress( AccNumber);
    	validateAccOverviewContents(userProfile);
    	//verifyCQ5();
    }
    
    public void loggeduserVerification(String email){
    	browser.wait(1000);
    	final String strLastName = new SiebelDataBase().getLastName(email);
    	String loggedInUserName = browser.getTextByXpath(AccPageProperties.getProperty("AccoOverviewPage.UserId"));
    	String loggedInUserNameArray[] = loggedInUserName.split(" ");
    	if (loggedInUserNameArray[2].equalsIgnoreCase(strLastName)){
    		Report.updateTestLog("Expected Logged In User is displayed and the User Name Is: "+loggedInUserName, Pass_Str);
        }
        else{
        	Report.updateTestLog("Expected Logged In User "+strLastName+" was not displayed", Fail_Str);
        }
    }

// Verify the contents displayed in Account Overview Page 
    private void otherOfferCheck(String type){
    	String link1="";    	
    	browser.wait(2000);
    	if(browser.isElementVisibleWithXpath(AccPageProperties.getProperty("AccoOverviewPage.addAccountLink").replace("TYPE", type))){
    		link1=browser.getTextByXpath(AccPageProperties.getProperty("AccoOverviewPage.addAccountLink").replace("TYPE", type));    	
    		if(link1.contains(type)){    		
    		Report.updateTestLog("Link for add "+type+" displayed", "PASS");}
    		else{
			Report.updateTestLog("Link for add "+type+" is not displayed", "FAIL");
		}    	
    	}else{
    		Report.updateTestLog("Cross sell section not displayed", "FAIL");
    	}
    }
    
    public void crosscellVerification(){
    	String accTypeText=null;
    	Set<String> accountType=new HashSet<String>();
    	int accountCount = browser.getChildElementsCountByXpath(AccPageProperties.getProperty("AccoOverviewPage.accountCount"));  
    	for(int count=1;count<=accountCount;count++){
    		accTypeText = browser.getTextByXpath(AccPageProperties.getProperty("AccoOverviewPage.AccountTypeID").replace("ACC_NUM", ""+count));
    		accountType.add(accTypeText.trim());
    	}
    	System.out.println(accountType);
    	if(accountType.contains("Gas") && accountType.contains("Elect`ricity") && accountType.contains("Insurance & Repair")){
			otherOfferCheck(AccPageProperties.getProperty("AccoOverviewPage.crossCellEnergy"));
		}else
			if(accountType.contains("Gas") && accountType.contains("Electricity")){
    		otherOfferCheck(AccPageProperties.getProperty("AccoOverviewPage.crossCellIns"));
    	}else
    		if(accountType.contains("Gas")){    		
    		otherOfferCheck(AccPageProperties.getProperty("AccoOverviewPage.crossCellEle"));
    			otherOfferCheck(AccPageProperties.getProperty("AccoOverviewPage.crossCellIns"));
    			System.out.println("FI");
    	}else
    		if(accountType.contains("Electricity")){    	
    		otherOfferCheck(AccPageProperties.getProperty("AccoOverviewPage.crossCellGas"));
    		otherOfferCheck(AccPageProperties.getProperty("AccoOverviewPage.crossCellIns"));
    			System.out.println("FII");
    	}else 
    		if(accountType.contains("Energy")){    		
        		otherOfferCheck(AccPageProperties.getProperty("AccoOverviewPage.crossCellIns"));
        }else
        	if(!accountType.contains("Gas") && !accountType.contains("Electricity")){
        		otherOfferCheck(AccPageProperties.getProperty("AccoOverviewPage.crossCellEle"));
        		otherOfferCheck(AccPageProperties.getProperty("AccoOverviewPage.crossCellGas"));
        		System.out.println("FIII");
        }
    		

    	
    	
    }
    public void validateAccOverviewContents(UserProfile userProfile){
    	final String expectedEmailAdd = new OnlineDBConnector().getUserEmail(userProfile.getUCRN());
    	final String accountNum = new SiebelDataBase().getAccountNumber(userProfile.getUCRN());
    	String nectarText = browser.getTextByXpath(AccPageProperties.getProperty("AccoOverviewPage.NectarTextID"));
    	//String accTypeText="";
    	String manageAccText = browser.getTextByXpath(AccPageProperties.getProperty("AccoOverviewPage.ManageAccID"));
    	String optionText = browser.getTextByXpath(AccPageProperties.getProperty("AccoOverviewPage.OptionTextID"));
    	//String readOurText = browser.getTextByXpath(AccPageProperties.getProperty("AccoOverviewPage.ArticleTextID"));
    	//String tariffText = browser.getTextByXpath(AccPageProperties.getProperty("AccoOverviewPage.TariffTextID"));
    	//String offerText = browser.getTextByXpath(AccPageProperties.getProperty("AccoOverviewPage.OfferID"));
    	String energySaverText = browser.getTextByXpath(AccPageProperties.getProperty("AccoOverviewPage.EnergySaverID"));
    	
    	final String[] AccOverviewContents = {nectarText,  manageAccText, energySaverText, 
    										  optionText};
    	    	for (int i=0; i < AccOverviewContents.length ; i++){
    		Report.updateTestLog("Displayed Accont Overview Text Is: "+AccOverviewContents[i], Pass_Str);    		
    	}
    	    	if(nectarText.toLowerCase().contains("Register".toLowerCase())){
        			verifyAndClickWithLinkText(nectarText, "Register link");
        			verifyPageTitle("Your Nectar points - British Gas");
        			browser.browserBack();
        		}
        		if(nectarText.toLowerCase().contains("Your Nectar points".toLowerCase())){
        			verifyAndClickWithLinkText(nectarText, "Your Nectar points");
        			verifyPageTitle("Your Nectar Points -British Gas");
        			browser.browserBack();
        		}
        		if(nectarText.toLowerCase().contains("Collect Nectar points".toLowerCase())){
        			verifyAndClickWithLinkText(nectarText, "Collect Nectar points");
        			verifyPageTitle("Collect");
        			browser.browserBack();
        		}
    	int AccTable = browser.getChildElementsCountByXpath(AccPageProperties.getProperty("AccoOverviewPage.CountID"));
    	System.out.println(AccTable+1);
    	for (int i=1; i < AccTable+1; i++){
    		String AccName = browser.getTextByXpath(AccPageProperties.getProperty("AccoOverviewPage.AccountName").replace("NUM", ""+i));
    		System.out.println(AccName);
        	Report.updateTestLog("Displayed Account Is: "+AccName, Pass_Str);
    	}
    	verifyAddMissingAccount();
    	//verifyAndClickWithXpath(AccPageProperties.getProperty("AccoOverviewPage.MissingAccID"), "Missing Account Link");
    	//verifyAndInputByXpath(AccPageProperties.getProperty("AccoOverviewPage.CustRefNum"), "FirstName", "admin");
    	//verifyAndClickWithXpath(AccPageProperties.getProperty("AccoOverviewPage.WhereCanIFindID"), "Missing Account Text");
//    	String toolTipText = browser.getTextByXpath(AccPageProperties.getProperty("AccoOverviewPage.MyAccountID"));
//    	
//    	if (toolTipText.trim() == "customer reference"){
//    		Report.updateTestLog("Expected Text was displayed : "+toolTipText, Pass_Str);
//    	} else {
//    		Report.updateTestLog("Expected Text was not displayed: "+toolTipText, Fail_Str);
//    	}
    	
    	//verifyAndClickWithXpath(AccPageProperties.getProperty("AccoOverviewPage.CloseButtonID"), "Missing Account close button");
    	
    	verifyAndClickWithXpath(AccPageProperties.getProperty("AccoOverviewPage.CompleteEnergyID"), "Energy Savers report");
    	 verifyPageTitle("Energy Savers Report - Save Energy - British Gas");
    	
    	//verifyAndClickWithXpath(AccPageProperties.getProperty("AccoOverviewPage.LogOutID"), "Log Out");
    	
    
    	
    }
    
  /*  public void verifyCQ5(){
    	verifyAndClickWithXpath(AccPageProperties.getProperty("AccoOverviewPage.CQLoginId"), "Login");
    	verifyAndInputByXpath(AccPageProperties.getProperty("AccoOverviewPage.CQLoginName"), "FirstName", "admin");
        verifyAndInputByXpath(AccPageProperties.getProperty("AccoOverviewPage.CQLoginPwd"), "LastName","admin");
    	verifyAndClickWithXpath(AccPageProperties.getProperty("AccoOverviewPage.CQOKButton"), "OK");
    	browser.wait(30000);
    	verifyAndClickWithXpath(AccPageProperties.getProperty("AccoOverviewPage.CQEtc"), "Etc");
    	browser.wait(1000);
    	verifyAndClickWithXpath(AccPageProperties.getProperty("AccoOverviewPage.CQCentricaTools"), "Centrica Tools");
    	browser.wait(1000);
    	//browser.doubleClick(AccPageProperties.getProperty("AccoOverviewPage.CQErrorMsgMaint"));
    	browser.wait(30000);
    	
    	verifyAndClickWithXpath(AccPageProperties.getProperty("AccoOverviewPage.CQOKButton"), "OK");
    	
    	verifyAndInputByXpath(AccPageProperties.getProperty("AccoOverviewPage.CQUserId"), "FirstName", "admin");
        verifyAndInputByXpath(AccPageProperties.getProperty("AccoOverviewPage.CQPassword"), "LastName","admin");
    	verifyAndClickWithXpath(AccPageProperties.getProperty("AccoOverviewPage.CQOK"), "OK");
    	int a = browser.getRowCountByXpath("//form[contains(@action,'errormessageoverrides')]//table");
    	int b = browser.getColCountByXpath("//form[contains(@action,'errormessageoverrides')]//table");
    	System.out.println(a);
    	System.out.println(b);
    	for (int i = 1; i < a; i++) {
    		String errorKey = browser.getTextByXpath("//form[contains(@action,'errormessageoverrides')]//table//tbody//tr["+i+"]//td[1]");
    		//System.out.println(errorKey);
    		if (errorKey.trim().equalsIgnoreCase("eshop.middleinitial.invalid")){
    			String errorKey1 = browser.getTextByXpath("//form[contains(@action,'errormessageoverrides')]//table//tbody//tr["+i+"]//td[2]");
    			System.out.println(errorKey1);
    			browser.inputByXpath("//form[contains(@action,'errormessageoverrides')]//table//tbody//tr["+i+"]//td[3]/textarea","thanks"); 
    		}
        
    }}*/
    
   
   
    public void verifyCustomerAddress(String accountNumber) {
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
       // if(ApplicationConfig.BRAND.equalsIgnoreCase("BG")){
        	String addressOneAdd = null;
            String addressTwoAdd = null;
        	int accountCount = browser.getChildElementsCountByXpath(AccPageProperties.getProperty("AccoOverviewPage.accountCount"));        	        	
        	String expectedAccountNum = accountNumber;
        		for (int i = 1; i <= accountCount; i++) {
        			String currentAccountNum ;
        			if(browser.isElementVisibleWithXpath(AccPageProperties.getProperty("AccoOverviewPage.accountNumber").replace("ACC_NUM", "" + i))){
        				currentAccountNum = browser.getTextByXpath(AccPageProperties.getProperty("AccoOverviewPage.accountNumber").replace("ACC_NUM", "" + i)).trim();
        				if (currentAccountNum.equalsIgnoreCase(expectedAccountNum)) {
        					addressOneAdd = browser.getTextByXpath(AccPageProperties.getProperty("AccoOverviewPage.addressLineOne").replace("ACC_NUM", "" + i));
        					addressTwoAdd = browser.getTextByXpath(AccPageProperties.getProperty("AccoOverviewPage.addressLineTwo").replace("ACC_NUM", "" + i));
        					fulladdress = addressOneAdd + addressTwoAdd;        					
        				}
                 }else{
        				currentAccountNum = browser.getTextByXpath(AccPageProperties.getProperty("AccoOverviewPage.accountNumberClose").replace("ACC_NUM", "" + i)).trim();
        				if (currentAccountNum.equalsIgnoreCase(expectedAccountNum)) {
        					addressOneAdd = browser.getTextByXpath(AccPageProperties.getProperty("AccoOverviewPage.addressLineOneClose").replace("ACC_NUM", "" + i));
        					addressTwoAdd = browser.getTextByXpath(AccPageProperties.getProperty("AccoOverviewPage.addressLineTwoClose").replace("ACC_NUM", "" + i));
        					fulladdress = addressOneAdd + addressTwoAdd;        					
                 }
        			}        	        		
        				
        		}
        	if(fulladdress.contains(number) && fulladdress.contains(addres )&& fulladdress.contains(city) && fulladdress.contains(zipcode)){
         	   Report.updateTestLog("Address verification done with database successfull<br>"+
        	"Database address-<b>"+dbAddress+"</b><br>Page address-<b>"+fulladdress+"</b>", "PASS");
            }else{
         	   Report.updateTestLog("Address verification done with database is not successfull<br>"+
        	"Database address-<b>"+dbAddress+"</b><br>Page address-<b>"+fulladdress+"</b>", "FAIL");
            }
      //  }
//        else if(ApplicationConfig.BRAND.equalsIgnoreCase("Fusion")){
//        	fulladdress = browser.getTextByXpath(AccPageProperties.getProperty("AccoOverviewPage.address"));
//        	System.out.println(fulladdress);
//        	if(fulladdress.contains(number) && fulladdress.contains(addres )&& fulladdress.contains(city) && fulladdress.contains(zipcode)){
//         	   Report.updateTestLog("Address verification done with database successfull<br>"+
//        	"Database address-<b>"+dbAddress+"</b><br>Page address-<b>"+fulladdress+"</b>", "PASS");
//            }else{
//         	   Report.updateTestLog("Address verification done with database is not successfull<br>"+
//        	"Database address-<b>"+dbAddress+"</b><br>Page address-<b>"+fulladdress+"</b>", "FAIL");
//            }
       // }
        }
  
    public void logout() {
    	getWaitTime();
    	if(browser.isElementVisibleWithXpath(AccPageProperties.getProperty("AccoOverviewPage.Logout"))){
    	browser.clickWithXpath(AccPageProperties.getProperty("AccoOverviewPage.Logout"));
    	Report.updateTestLog("User Logged out Successfully","PASS");	
    	}else{
    		Report.updateTestLog("Log out Unsuccessfull","FAIL");
    	}
//    	verifyAndClickWithXpath(AccPageProperties.getProperty("AccountOverviewPage.Logout"), "Log out");
    	verifyPageTitle("Login to Your Account - British Gas");
    }
    public void verifyAddMissingAccount(){
    	browser.clickWithXpath(AccPageProperties.getProperty("AccoOverviewPage.MissingAccID"));
    	browser.wait(3000);
    	if(browser.isElementVisibleWithXpath(AccPageProperties.getProperty("AccoOverviewPage.MissingAccOverlay"))){
    		Report.updateTestLog("Add a Missing Account overlay displayed","PASS");	
    	}else{
    		Report.updateTestLog("Add a Missing Account overlay not displayed","FAIL");
    	}
    	browser.clickWithXpath(AccPageProperties.getProperty("AccoOverviewPage.MissingAccOverlayclose"));    	
    }
    public void verifyBrowserback(){
        browser.browserBack();
      if (browser.isElementVisible(AccPageProperties.getProperty("AccoOverviewPage.MissingAccID"))){
            Report.updateTestLog("Account Overview page exists, Browser back working as expected","PASS");
        }else {
            Report.updateTestLog("Account Overview page not exists, page navigated to back page","FAIL");
      }
    }
    public void registerNectarPage() {
    	browser.clickWithXpath(AccPageProperties.getProperty("AccoOverviewPage.nectarregisterlink"));
    	if (browser.isElementVisibleWithXpath(AccPageProperties.getProperty("AccoOverviewPage.NectarPage"))){
            Report.updateTestLog("Nectar register page exists","PASS");
        }else {
            Report.updateTestLog("Nectar register page not exists","FAIL");
      }
    }
    
    public void verifyLogin(String lastName, String accNumver) {
        browser.wait(getWaitTime());
        String lastName2 = browser.getText(AccPageProperties.getProperty("AccoOverviewPage.Lastname"));
        if(lastName2.toLowerCase().contains(lastName.toLowerCase())){
          Report.updateTestLog("Lastname is present in application", "PASS");
        }
        else{
          Report.updateTestLog("Lastname not present in application", "FAIL");
        }
        
        verifyIsTextPresent(accNumver);
        
    }
    
    
}
