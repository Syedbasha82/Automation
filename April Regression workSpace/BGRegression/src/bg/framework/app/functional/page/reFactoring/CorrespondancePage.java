package bg.framework.app.functional.page.reFactoring;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Properties;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.RobotSendKeys;
import bg.framework.app.functional.util.RunQTP;

public class CorrespondancePage extends BasePage {

	private final static String FILE_NAME = "resources/ReFactoring/Correspondance.properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

	//////// Navigating to your documents link //////////////////////
	public void navigateToDocumentsLink(){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CorrespondancePage.DocumentsLink"))){
			verifyAndClickWithXpath(pageProperties.getProperty("CorrespondancePage.DocumentsLink"),"DocumentsLink");
			Report.updateTestLog("Documents Link Clicked", "PASS");
		}
		else{
			Report.updateTestLog("Documents Link is not present in the application", "FAIL");
		}
	}

	public void optingForPaperlessBilling(String AcctType,String Type,UserProfile userProfile){
		if(AcctType=="paper"){
			verifyAndClickWithXpath(pageProperties.getProperty("CorrespondancePage.UpdatePreference"),"UpdatePreference");
			browser.wait(5000);
			verifyRevertLinkAfterClickingEditLink(Type,AcctType);
			updateToPaperless(Type,AcctType);
			viewPaperlessDocuments(userProfile);
		}
		else if(AcctType=="paperless"){
			viewPaperlessDocuments(userProfile);
			browser.wait(3000);
			verifyAndClickWithXpath(pageProperties.getProperty("CorrespondancePage.EditButton"),"Edit Button");
			verifyRevertLinkAfterClickingEditLink(Type,AcctType);
		}

		else if(AcctType=="partial"){
			viewPaperlessDocuments(userProfile);
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CorrespondancePage.EditButton"))){
				verifyAndClickWithXpath(pageProperties.getProperty("CorrespondancePage.EditButton"),"Edit Button");
				browser.wait(3000);
				Report.updateTestLog("Edit button clicked sucessfully", "WARN");
			}
			else{
				Report.updateTestLog("Edit button is not clicked sucessfully", "FAIL"); 
			}
			verifyRevertLinkAfterClickingEditLink(Type,AcctType);
			updateToPaperless(Type,AcctType);
			viewPaperlessDocuments(userProfile);
		}
	}


	/////////////////////// reverting to paper billing from paperless billing /////////////////////
	public void revertToPaper(){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CorrespondancePage.RevertToPaper"))){
			verifyAndClickWithXpath(pageProperties.getProperty("CorrespondancePage.RevertToPaper"),"RevertToPaper");
		}
		else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CorrespondancePage.RevertToPaperAcctsdual"))){
			verifyAndClickWithXpath(pageProperties.getProperty("CorrespondancePage.RevertToPaperAcctsdual"),"RevertToPaperAcctsdual");
		}
		else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CorrespondancePage.RevertToPaperMultipleAccts"))){
			verifyAndClickWithXpath(pageProperties.getProperty("CorrespondancePage.RevertToPaperMultipleAccts"),"RevertToMultipleAcctsPaper");   
		}
		verifyAndClickWithXpath(pageProperties.getProperty("CorrespondancePage.OverlayContinue"),"ContinueButton");
		verifyAndClickWithXpath(pageProperties.getProperty("CorrespondancePage.OverlayCloseButton"),"CloseButton");
		browser.wait(3000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CorrespondancePage.UpdatePreference"))){
			Report.updateTestLog("Reverted to paper Sucessfully","PASS");
		}
		else Report.updateTestLog("Reverted to paper is not processed sucessfully","FAIL");
	}

	public void CorrespondanceLogout(){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CorrespondancePage.Logout"))){
			verifyAndClickWithXpath(pageProperties.getProperty("CorrespondancePage.Logout"),"Logout link");
			Report.updateTestLog("Log out link clicked successfully", "PASS");
		}
		else {
			Report.updateTestLog("Log out link is not clicked successfully", "FAIL");
		}

	}

	/////////////// Updating to paperless billing ////////////////////if (Type == "Multiple")
	public void updateToPaperless(String Type,String AcctType){
		if (Type == "Multiple"){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CorrespondancePage.ReceiveDocumentsOnline"))){
				verifyAndClickWithXpath(pageProperties.getProperty("CorrespondancePage.ReceiveDocumentsOnline"),"ReceiveDocumentsOnlineForAllDocuments");
				Report.updateTestLog("Receive Documents Online For All Documents is clicked successfully", "PASS");
			}
			else{
				Report.updateTestLog("Receive Documents Online For All Documents is not clicked successfully", "FAIL");
			}
		}

		if(Type == "Single"& AcctType == "paperless"){
			if(!browser.isElementVisibleWithXpath(pageProperties.getProperty("CorrespondancePage.ReceiveDocumentsOnline"))){
				Report.updateTestLog("Receive Documents Online For All Documents button is not avaliable", "PASS");   
			}
			else{
				Report.updateTestLog("Receive Documents Online For All Documents button is available","FAIL");
			}	
		}	
		verifyAndClickWithXpath(pageProperties.getProperty("CorrespondancePage.SaveChanges"),"SaveChangesButton");
		Report.updateTestLog("Customer is Suceccfully opted for Paperless Billing", "WARN");
		verifyAndClickWithXpath(pageProperties.getProperty("CorrespondancePage.OverlayCloseButton"),"CloseButton"); 
	}


	/////// viewing documents /////////////////
	public void viewPaperlessDocuments(UserProfile userProfile){
		if (browser.isElementVisibleWithXpath(pageProperties.getProperty("CorrespondancePage.AccountFromDropBoxXpath"))){
			ArrayList<String> accounts = new ArrayList<String>();
			accounts = browser.getFromDropBox("id", pageProperties.getProperty("CorrespondancePage.AccountFromDropBox"));
			String postCode = browser.getTextByXpath(pageProperties.getProperty("CorrespondancePage.IntroAddress"));
			String postCode1[] = postCode.split(",");
			int lenght = postCode1.length;
			String pstCode = postCode1[lenght-1];
			///// checking is documents are available for multiple accounts //////
			for (int i=0;i < accounts.size(); i++ ){
				browser.wait(5000);
				String Acct = accounts.get(i);
				String Account[] = Acct.split("-");
				String AcctNum = Account[1];
				verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("CorrespondancePage.AccountFromDropBoxXpath"),"Drop downbox",Acct);
				////////////////////// Verfying address of each account //////////////////
				
					verifyCorrespondanceAccountAddress(Acct, userProfile);
				
				////////////////// Verifying documents /////////////////
				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CorrespondancePage.ViewCorrespondance"))){
					verifyIsElementVisibleWithXpath(pageProperties.getProperty("CorrespondancePage.ViewCorrespondance"),"View correspondance documents");
					Report.updateTestLog("Latest Documents Of" + AcctNum + "shown in the application ", "WARN");
				}
				else{
					Report.updateTestLog("Latest Documents Of" + AcctNum + "is not shown in the application ", "FAIL");  
				}
				//downloadDocuments();
			}
		}
		else {
			////////////// checking is documents available for single account //////////////
			if (browser.isElementVisibleWithXpath(pageProperties.getProperty("CorrespondancePage.AccountText"))){
				String AcctNum1 = browser.getTextByXpath(pageProperties.getProperty("CorrespondancePage.onePaperlessAddress"));
				String Acct[] = AcctNum1.split("-");
				String AccountNum = Acct[1];
				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CorrespondancePage.ViewCorrespondance"))){
					verifyIsElementVisibleWithXpath(pageProperties.getProperty("CorrespondancePage.ViewCorrespondance"),"View correspondance documents");
					Report.updateTestLog("Latest Documents Of" + AccountNum + "is shown in the application ", "PASS");
				}
				else{
					Report.updateTestLog("Latest Documents Of" + AccountNum + "is not shown in the application ", "FAIL");  
				}
				//downloadDocuments();
			}

		}
	}

	public void downloadDocuments(){
		if (browser.isElementVisibleWithXpath(pageProperties.getProperty("CorrespondancePage.DocumentsTable"))){
			Report.updateTestLog("Documents table is shown in the application ", "PASS");
		}
		else Report.updateTestLog("Documents table is not shown in the application ", "FAIL");
		int documents = browser.getChildElementsCountByXpath(pageProperties.getProperty("CorrespondancePage.DocumentsTable"));
		for (int i=1 ; i <= documents ; i++ ){		
			verifyAndClickWithXpath(pageProperties.getProperty("CorrespondancePage.Documents").replace("NUMBER",""+i),"Documents link");
			browser.wait(getWaitTime());
			browser.wait(5000);
			RobotSendKeys.altS();
			browser.wait(3000);
			RobotSendKeys.typeenter();
			browser.wait(3000);
			Report.updateTestLog("Pdf file get downloaded by clicking enter", "PASS");
		}
	}

	public void verifyRevertLinkAfterClickingEditLink(String Type,String AcctType){
		if(Type == "Single"& AcctType == "paperless" || Type == "Paper"){
			if(!browser.isElementVisibleWithXpath(pageProperties.getProperty("CorrespondancePage.RevertToPaperMultipleAccts"))){
				Report.updateTestLog("Revert to paper for all accounts is not present for single(paper & paperless) and paperless account","PASS");
			}
			else Report.updateTestLog("Revert to paper for all accounts is present for single(paper & paperless) and paperless account","FAIL");
		}
		if (Type == "Multiple"){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CorrespondancePage.RevertToPaperMultipleAccts"))){
				Report.updateTestLog("Revert to paper for all accounts is present for multiple(paperless) and partial account","PASS");
			}
			else Report.updateTestLog("Revert to paper for all accounts is not present for multiple(paperless) and partial account","FAIL");
		}
	}

	public void verifyCorrespondanceAccountAddress(String Acct, UserProfile userProfile){
		System.out.println(Acct);
		String ExpectedAddr = browser.getTextByXpath(pageProperties.getProperty("CorrespondancePage.IntroAddress"));
		if(Acct.contains(userProfile.getAccNumber1())){
			if(ExpectedAddr.equalsIgnoreCase(userProfile.getAddr1())){
				Report.updateTestLog("Address of account " + userProfile.getAccNumber1()+ " is shown successfully" , "PASS");
			}
			else {
				Report.updateTestLog("Address of account " + userProfile.getAccNumber1()+ " is not shown successfully" , "FAIL");
			}
		}
		else if(Acct.contains(userProfile.getAccNumber2())){
			if(ExpectedAddr.equalsIgnoreCase(userProfile.getAddr2())){
				Report.updateTestLog("Address of account " + userProfile.getAccNumber2()+ " is shown successfully" , "PASS");
			}
			else 
				{
				Report.updateTestLog("Address of account "+ userProfile.getAccNumber2()+ " is not shown successfully" , "FAIL");
				}
		}
		else if(Acct.contains(userProfile.getAccNumber3())){
			if(ExpectedAddr.equalsIgnoreCase(userProfile.getAddr3())){
				Report.updateTestLog("Address of account " + userProfile.getAccNumber3()+ " is shown successfully" , "PASS");
			}
			else{
				Report.updateTestLog("Address of account " + userProfile.getAccNumber3()+ " is not shown successfully" , "FAIL");
			}
		}
		else if(Acct.contains(userProfile.getAccNumber4())){
			if(ExpectedAddr.equalsIgnoreCase(userProfile.getAddr4())){
				Report.updateTestLog("Address of account " + userProfile.getAccNumber4()+ " is shown successfully" , "PASS");
			}
			else {
				Report.updateTestLog("Address of account " + userProfile.getAccNumber4()+ " is not shown successfully" , "FAIL");
			}
		}
	}

	public void verifyLinksInCorrespondancePageDefault(String AcctType, String Type){
		if(AcctType == "paper"){
			if(!browser.isElementVisibleWithXpath(pageProperties.getProperty("CorrespondancePage.RevertToPaper"))
					&& (!browser.isElementVisibleWithXpath(pageProperties.getProperty("CorrespondancePage.RevertToPaperMultipleAccts")))){
				Report.updateTestLog("Revert to paper link is not present for single(paper & paperless) and multiple paper accounts", "PASS");
			}
			else Report.updateTestLog("Revert to paper link is present for single(paper & paperless) and multiple paper accounts", "FAIL");
		}
		if(AcctType =="paper || paperless"){
			if(!browser.isElementVisibleWithXpath(pageProperties.getProperty("CorrespondancePage.ReceiveDocumentsOnline"))){
				Report.updateTestLog("Receive Documents Online button is not present for paper & paperless(single or multiple) accounts", "PASS");
			}
			else Report.updateTestLog("Receive Documents Online button is present for paper & paperless(single or multiple) accounts", "FAIL");
		}
	}


	public void verifyVbsFile(String AcNumber) {
		try{
		/* RunQTP runQTP = new RunQTP();

        runQTP.runQTP("C:\\Users\\375908\\Desktop\\Paperless.vbs", "");*/
        Runtime.getRuntime().exec("wscript.exe " + "C:\\Users\\375908\\Desktop\\Paperless2.vbs AcNumber");

		}
		catch(Exception e){
			System.out.println("Exception : "+e);
		}
	}
}

