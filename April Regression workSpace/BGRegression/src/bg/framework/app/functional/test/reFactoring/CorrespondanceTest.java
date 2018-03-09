package bg.framework.app.functional.test.reFactoring;


import static bg.framework.app.functional.entities.FunctionalCategory.AccountSummary;
import static bg.framework.app.functional.entities.FunctionalCategory.Refactoring;

import org.testng.annotations.Test;




import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.reFactoring.CorrespondanceAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class CorrespondanceTest extends TestBase {

	/////// single account - paperless /////////////
	@Test(groups = {AccountSummary,Refactoring})	    
	public void HC100ViewPaperlessDocuments() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether HC100 user can able to opt for paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare100Account");  
		String AcctType = "paperless";
		String Type = "Single";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.optingForPaperlessBilling(AcctType,Type,userProfile)
		.logout();        
	}
	
/////// single account - paperless /////////////
	@Test(groups = {AccountSummary,Refactoring})	    
	public void GACUpdateToPaperless() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether HC100 user can able to opt for paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasApplianceCoverWithL1Account");  
		String AcctType = "paperless";
		String Type = "Single";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.optingForPaperlessBilling(AcctType,Type,userProfile)
		.logout();        
	}
	
	//////////// single account - paper //////////////////
	@Test(groups = {AccountSummary,Refactoring})	    
	public void HC200UpdateToPaperless() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether HC200 user can able to opt for paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare200Account");  
		String AcctType = "paper";
		String Type = "Single";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()   
		.navigateToDocumentsLink()
		.optingForPaperlessBilling(AcctType,Type,userProfile)
		.logout();        
	}
	/////////////// Multiple  paperless (3 accounts) ///////////////////
	@Test(groups = {AccountSummary,Refactoring})	    
	public void SOAndHCViewPaperlessDocuments() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether SO and HC user can able to see paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("SOKACAndHC400FlexiAccount");  
		String AcctType = "paperless";
		String Type = "Multiple";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.optingForPaperlessBilling(AcctType,Type,userProfile)
		.logout();        
	}

	///////////////// Multiple paper (4 accounts) ////////////////////
	@Test(groups = {AccountSummary,Refactoring})	    
	public void multipleUpdateToPaperlessDocuments() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether Multiple Homecare accounts can able to opt for paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC100HC200KACAndHECAccount");  
		String AcctType = "paper";
		String Type = "Multiple";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.optingForPaperlessBilling(AcctType,Type,userProfile)
		.logout();        
	}

	///////////////// Single account paperless  ///////////////////////
	@Test(groups = {AccountSummary,Refactoring})	    
	public void HC300FlexiViewPaperlessDocuments() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether HC300 Flexi Account user can able to opt for paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC300FlexiAccount");  
		String AcctType = "paperless";
		String Type = "Single";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.optingForPaperlessBilling(AcctType,Type,userProfile)
		.logout();        
	}

	//////////////// Multiple paper (2 accounts) ///////////////
	@Test(groups = {AccountSummary,Refactoring})	    
	public void HC100GACUpdateToPaperless() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether HC300 Flexi Account user can able to opt for paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC100AndGACAccount");  
		String AcctType = "paper";
		String Type = "Multiple";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.optingForPaperlessBilling(AcctType,Type,userProfile)
		.logout();        
	}



	////////////////Multiple paper(3 accounts) ///////////////
	@Test(groups = {AccountSummary,Refactoring})	    
	public void KACHC200HECUpdateToPaperless() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether KAC HC200 HEC Account user can able to opt for paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("KACHC200HECAccount");  
		String AcctType = "paperless";
		String Type = "Multiple";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.optingForPaperlessBilling(AcctType,Type,userProfile)
		.logout();        
	}

	////////////////////// 1 paper 1 paperless ///////////////////////
	@Test(groups = {AccountSummary,Refactoring})	    
	public void partialAccountUpdateToPaperless() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether HC100(paper) and GAC(paperless) Account user can able to opt for paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC100AndGACAccount");  
		String AcctType = "partial";
		String Type = "Multiple";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.optingForPaperlessBilling(AcctType,Type,userProfile)
		.logout();        
	}

	///////////////// 1 paper 2 paperless ///////////////////////

	@Test(groups = {AccountSummary,Refactoring})	    
	public void partial2AccountUpdateToPaperless() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether HC200(paper), HEC(paperless) and KAC(paperless) Account user can able to opt for paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("KACHC200HECAccount");  
		String AcctType = "partial";
		String Type = "Multiple";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.optingForPaperlessBilling(AcctType,Type,userProfile)
		.logout();        
	}

	//////////////////////////// 2 paper 2 paperless //////////////////////
	@Test(groups = {AccountSummary,Refactoring})	    
	public void partial3AccountUpdateToPaperless() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether HC100(paper), HC200(paper), HEC(paperless) and KAC(paperless) Account user can able to opt for paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC100HC200KACAndHECAccount");  
		String AcctType = "partial";
		String Type = "Multiple";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.optingForPaperlessBilling(AcctType,Type,userProfile)
		.logout();        
	}

	////////////////// 2 paper 1 paperless //////////////////
	@Test(groups = {AccountSummary,Refactoring})	    
	public void partial4AccountUpdateToPaperless() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether KAC(paper), HEC(paper) and GAC(paperless) Account user can able to opt for paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HECKACAndGACAccount");  
		String AcctType = "partial";
		String Type = "Multiple";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.optingForPaperlessBilling(AcctType,Type,userProfile)
		.logout();        
	}

	////////////////// 1 paper 3 paperless ///////////////////

	@Test(groups = {AccountSummary,Refactoring})	    
	public void HC100HC200HC300AndHC400AccountUpdateToPaperless() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether HC100(paper) HC200(paperless) HC300(paperless) And HC400(paperless) Account user can able to opt for paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC100HC200HC300AndHC400Account");  
		String AcctType = "partial";
		String Type = "Multiple";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.optingForPaperlessBilling(AcctType,Type,userProfile)
		.logout();        
	}

	/////////////////// 2 paperless ///////////////////////

	@Test(groups = {AccountSummary,Refactoring})	    
	public void HC100AndHC200AccountUpdateToPaperless() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether HC100(paperless) And HC200(paperless) Account user can able to opt for paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC100AndHC200Account");  
		String AcctType = "paperless";
		String Type = "Multiple";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.optingForPaperlessBilling(AcctType,Type,userProfile)
		.logout();        
	}

	//////////////////// 4 paperless ////////////////////////

	@Test(groups = {AccountSummary,Refactoring})	    
	public void HC100HC200KACAndHECAccountViewPaperlessDocuments() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether HC100(paperless) HC200(paperless) KAC(paperless) And HEC(paperless) Account can able to see paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC100HC200KACAndHECAccount");  
		String AcctType = "paperless";
		String Type = "Multiple";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.optingForPaperlessBilling(AcctType,Type,userProfile)
		.logout();        
	}


	////////////////// 1 paperless 3 paper ///////////////////////

	@Test(groups = {AccountSummary,Refactoring})	    
	public void HC100HC200KACAndHECAccountOptToPaperlessDocuments() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether HC100(paperless) HC200(paper) KAC(paper) And HEC(paper) Account can able to see paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC100HC200KACAndHECAccount");  
		String AcctType = "partial";
		String Type = "Multiple";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.optingForPaperlessBilling(AcctType,Type,userProfile)
		.logout();        
	}

	//////////////////Single account - paperless - revert to paper ///////////////
	@Test(groups = {AccountSummary,Refactoring})	    
	public void HC300RevertToPaper() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether HC300 Account user can able to revert for paper billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare300Account");  
		String AcctType = "paperless";
		String Type = "Single";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.revertToPaper()
		.logout();        
	}

	////////////////////// Multiple paperless(2 accounts)  - revert to paper //////////////////
	@Test(groups = {AccountSummary,Refactoring})	    
	public void HC100GACRevertToPaper() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether HC100 and GAC Account user can able to revert for paper billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC100AndGACAccount");  
		String AcctType = "paperless";
		String Type = "Multiple";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.revertToPaper()
		.logout();        
	}

	/////// single account - paperless /////////////
	@Test(groups = {AccountSummary,Refactoring})	    
	public void HC100RevertToPaper() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether HC100 user can able to opt for paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HomeCare100Account");  
		String AcctType = "paperless";
		String Type = "Single";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.revertToPaper()
		.logout();        
	}

	/////////////// Multiple  paperless (3 accounts) ///////////////////
	@Test(groups = {AccountSummary,Refactoring})	    
	public void SOAndHCRevertToPaper() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether SO and HC user can able to see paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("SOKACAndHC400FlexiAccount");  
		String AcctType = "paperless";
		String Type = "Multiple";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.revertToPaper()
		.logout();        
	}

	///////////////// Single account paperless  ///////////////////////
	@Test(groups = {AccountSummary,Refactoring})	    
	public void HC300FlexiRevertToPaper() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether HC300 Flexi Account user can able to opt for paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC300FlexiAccount");  
		String AcctType = "paperless";
		String Type = "Single";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.revertToPaper()
		.logout();        
	}

	//////////////////////1 paper 1 paperless ///////////////////////
	@Test(groups = {AccountSummary,Refactoring})	    
	public void partialAccountRevertToPaper() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether HC100(paper) and GAC(paperless) Account user can able to opt for paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC100AndGACAccount");  
		String AcctType = "partial";
		String Type = "Multiple";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.revertToPaper()
		.logout();        
	}

	///////////////// 1 paper 2 paperless ///////////////////////

	@Test(groups = {AccountSummary,Refactoring})	    
	public void partial2AccountRevertToPaper() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether HC200(paper), HEC(paperless) and KAC(paperless) Account user can able to opt for paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("KACHC200HECAccount");  
		String AcctType = "partial";
		String Type = "Multiple";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.revertToPaper()
		.logout();        
	}

	//////////////////////////// 2 paper 2 paperless //////////////////////
	@Test(groups = {AccountSummary,Refactoring})	    
	public void partial4AccountRevertToPaper() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether HC100(paper), HC200(paper), HEC(paperless) and KAC(paperless) Account user can able to opt for paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC100HC200KACAndHECAccount");  
		String AcctType = "partial";
		String Type = "Multiple";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.revertToPaper()
		.logout();        
	}

	////////////////// 2 paper 1 paperless //////////////////
	@Test(groups = {AccountSummary,Refactoring})	    
	public void partial3AccountRevertToPaper() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether KAC(paper), HEC(paper) and GAC(paperless) Account user can able to opt for paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HECKACAndGACAccount");  
		String AcctType = "partial";
		String Type = "Multiple";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.revertToPaper()
		.logout();        
	}

	////////////////// 1 paper 3 paperless ///////////////////

	@Test(groups = {AccountSummary,Refactoring})	    
	public void HC100HC200HC300AndHC400AccountRevertToPaper() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether HC100(paper) HC200(paperless) HC300(paperless) And HC400(paperless) Account user can able to opt for paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC100HC200HC300AndHC400Account");  
		String AcctType = "partial";
		String Type = "Multiple";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.revertToPaper()
		.logout();        
	}

	/////////////////// 2 paperless ///////////////////////

	@Test(groups = {AccountSummary,Refactoring})	    
	public void HC100AndHC200AccountRevertToPaper() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether HC100(paperless) And HC200(paperless) Account user can able to opt for paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC100AndHC200Account");  
		String AcctType = "paperless";
		String Type = "Multiple";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.revertToPaper()
		.logout();        
	}

	//////////////////// 4 paperless ////////////////////////

	@Test(groups = {AccountSummary,Refactoring})	    
	public void HC100HC200KACAndHECAccountPaperlessRevertToPaper() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether HC100(paperless) HC200(paperless) KAC(paperless) And HEC(paperless) Account can able to see paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC100HC200KACAndHECAccount");  
		String AcctType = "paperless";
		String Type = "Multiple";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.revertToPaper()
		.logout();        
	}


	////////////////// 1 paperless 3 paper ///////////////////////

	@Test(groups = {AccountSummary,Refactoring})	    
	public void HC100HC200KACAndHECAccountRevertToPaper() {
		Report.createTestLogHeader("Correspondance Page", "Verify Whether HC100(paperless) HC200(paper) KAC(paper) And HEC(paper) Account can able to see paperless billing");
		UserProfile userProfile = new TestDataHelper().getUserProfile("HC100HC200KACAndHECAccount");  
		String AcctType = "partial";
		String Type = "Multiple";
		new HomePageAction()
		.navigateToLogin()
		.login(userProfile)
		.verifyLogin(userProfile.getLastName(), userProfile.getAccNumber())
		.navigateToAccountSummaryPage(userProfile);
		new CorrespondanceAction()     
		.navigateToDocumentsLink()
		.revertToPaper()
		.logout();        
	}


	@Test(groups = {AccountSummary,Refactoring})
	public void vbsFileTest(){
		Report.createTestLogHeader("VBS File","Checking parameters");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		String AcNumber = userProfile.getAccNumber();
		new CorrespondanceAction()
		.verifyVbsFile(AcNumber);
		
	}
}



