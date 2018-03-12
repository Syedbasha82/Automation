package bg.framework.app.functional.page.reFactoring;
import bg.framework.app.functional.entities.UserProfile;

import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.page.common.GlobalErrorMessages;
import org.openqa.selenium.WebElement;

import java.util.Properties;

public class SiteSearchPage extends BasePage {

	 private final static String FILE_NAME = "resources/ReFactoring/SiteSearch.Properties";
	 private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	 private final static String LOGIN_FILE_NAME = "resources/common/LoginPage.Properties";
	 private static Properties loginProperties = new PropertyLoader(LOGIN_FILE_NAME).load();
	 private final static String HOMEPAGE_FILE_NAME = "resources/common/FusionHomePage.Properties";
	 private static Properties homepageProperties = new PropertyLoader(HOMEPAGE_FILE_NAME).load();
	 	 
	 public SiteSearchPage(){
		   super();
	   }

// Login with appropriate user credentials
	 
	 public void loginUser(UserProfile userProfile) {
        final String expectedEmailAdd = new OnlineDBConnector().getUserEmail(userProfile.getUCRN());
        verifyAndInputById(loginProperties.getProperty("LoginPage.Email"), "Email Id", expectedEmailAdd);
        verifyAndInputById(loginProperties.getProperty("LoginPage.Password"), "Password", userProfile.getPassword());
        browser.clickWithXpath(loginProperties.getProperty("LoginPage.LoginSubmitClass"));
        browser.wait(getWaitTime());
	        
	  }
// Verify whether Site Search field exist in different pages(Boilers,Help and Advice,Products and Contact Us) 
	 	 	 
	 public void siteSearchValidation(){
		 final String[] searchText = {homepageProperties.getProperty("HomePage.ProductsId"),homepageProperties.getProperty("HomePage.HelpAndAdviceId"), 
				 					  homepageProperties.getProperty("HomePage.ContactUsId"),homepageProperties.getProperty("HomePage.AboutUsId"),
				 					  homepageProperties.getProperty("HomePage.EmergenciesId"),homepageProperties.getProperty("HomePage.TermsId"),
				 					  homepageProperties.getProperty("HomePage.PrivacyId"),homepageProperties.getProperty("HomePage.AccessibilityId"),
				 					  homepageProperties.getProperty("HomePage.AffiliatesId")};
		 for (int i = 0; i < searchText.length; i++) {
			 browser.wait(2000);			 
			 verifyAndClickWithXpath(searchText[i],"");
			 verifyIsElementVisibleWithXpath(pageProperties.getProperty("SiteSearch.SearchID"),"Site Search");
			 verifyAndClickWithXpath(pageProperties.getProperty("SiteSearch.BritishGasImage"), "British Gas Image");
		 }
		 
	 }
	 
// Enter the appropriate content to be searched in the Site Search field and click on Search option
	 
	 public void validateSiteSearchJourney(String searchText){
		 browser.dynamicWaituntilVisiblebyXpath(pageProperties.getProperty("SiteSearch.SearchID"));
		 verifyAndInputByXpath(pageProperties.getProperty("SiteSearch.SearchID"), "Site Search", searchText);
		 verifyAndClickWithXpath(pageProperties.getProperty("SiteSearch.SubmitID"), "Site Search");	 
	 }

// Select the appropriate search text link and check whether the appropriate page is navigated by capturing the displayed bread crumb 	 
	 public void verifySiteSearchResult(String SearchText){ 
		 verifyIsElementVisibleWithXpath(pageProperties.getProperty("SiteSearch.SearchText").replace("SEARCHVARIABLE", SearchText),"Search Result");
		 verifyAndClickWithXpath(pageProperties.getProperty("SiteSearch.SearchLink"), "First Search Result");
		 verifyIsElementVisibleWithXpath(pageProperties.getProperty("SiteSearch.BreadCrumbID"),"BreadCrumb Text");
		 verifyAndClickWithXpath(pageProperties.getProperty("SiteSearch.BritishGasImage"), "British Gas Image");
		}

// Validate the Site Search field by providing different invalid combinations and compare the displayed error message against the expected error message	 
	 
	 public void validateSiteSearchErrorMsgs(){
		 final String[] searchText = {"Search1", "", "a*a"};
         for (int i = 0; i < searchText.length; i++) {
        		 validateSiteSearchJourney(searchText[i]);
        		 errorMessageComparison(GlobalErrorMessages.ReFactoring_FirstSiteSearchError);
        	}
	 }

// Validate the site search field by entering a valid search text and check whether the appropriate page gets displayed	 
	 
	 public void validateSiteSearch(String SearchText){
		 validateSiteSearchJourney(SearchText);
		 verifySiteSearchResult(SearchText);
	 }
	 
// Capture the error message displayed and verify the actual and error message displayed by making a call to the verifyErrorMessage method	 
	 
	 public void errorMessageComparison(final String expectedErrorMsg) {
	        final String displayedErrorMsg = browser.getTextByXpath(pageProperties.getProperty("SiteSearch.ErrorMessageValidationID"));
	        verifyErrorMessage(displayedErrorMsg, expectedErrorMsg);
	    }

// Validation for Inappropriate data for the fields displayed in Search Result Page and compare the error message displayed in the 
// application against the Expected data  	   

	 public void verifyErrorMessage(final String displayedErrorMsg, final String expectedErrorMsg) {
	        if (displayedErrorMsg.trim().contains(expectedErrorMsg.trim())) {
	            Report.updateTestLog("Displayed Error Message Validation Is  :" + displayedErrorMsg, "PASS");
	        } else {
	            Report.updateTestLog("Expected Error Message Validation Was Not Displayed", "FAIL");
	        }
	    }
	 
	 public void validateDisplayedResults(String SearchText){
		 //Enter the search item
		 verifyAndInputByXpath(pageProperties.getProperty("SiteSearch.SearchTermLarge"), "Search Text Field", SearchText);
		 verifyAndClickWithXpath(pageProperties.getProperty("SiteSearch.SearchButton"), "SearchButton");
		 browser.dynamicWaituntilVisiblebyXpath(pageProperties.getProperty("SiteSearch.SearchResultHeader"));
		 if(browser.getTextByXpath(pageProperties.getProperty("SiteSearch.SearchResultHeader")).contains("Search")){
			 Report.updateTestLog("Search Result Page Displayed successfully", "Pass");
			 
			 //verify the 5 results per page
			 verifySearchResults(10);
		 }
		 else{
			 Report.updateTestLog("Search result Page not loaded, Execution Terminated", "Fail");
		 }
		
	 }
	 
	 public void verifySearchResults(int Iteration){
		 //select the results per page
		 //verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("SiteSearch.ResultsDropDown"), "Results Option", Iteration+"");
		 WebElement dpElement = browser.getElementByXpath(pageProperties.getProperty("SiteSearch.ResultsDropDown"));
		 dpElement.click();
		 dpElement = browser.getElementByXpath(pageProperties.getProperty("SiteSearch.SearchResultDisplay").replace("OPTIONVALUE", Iteration+""));
		 dpElement.click();
		 
		 browser.wait(10000);
		 //Click and verify Results page
		 for(int i=1;i<=Iteration; i++){
			 verifyAndClickWithXpath(pageProperties.getProperty("SiteSearch.ResultSelect").replace("ROW", i+""), "Search Result Option "+i);
			 browser.browserBack();
		 }
		 
		 //Check for additional results
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("SiteSearch.ResultSelect").replace("ROW", (Iteration+1)+""))){
			Report.updateTestLog("Search results present more than expected value : "+(Iteration+1), "Fail");
		}
		else{
			Report.updateTestLog("Search results Displayed Successfully ", "Pass");
		}
	 }
	 
}
