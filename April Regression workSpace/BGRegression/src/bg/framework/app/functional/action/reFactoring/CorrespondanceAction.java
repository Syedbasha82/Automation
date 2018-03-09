package bg.framework.app.functional.action.reFactoring;


import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.action.selfServe.AccountSummaryAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.LegacyHomePage;
import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.page.reFactoring.CorrespondancePage;
import bg.framework.app.functional.page.selfServe.AccountOverviewPage;

public class CorrespondanceAction {

	public LoginAction navigateToLogin(){
		LegacyHomePage legacyHomePage = new LegacyHomePage();
        legacyHomePage.navigateToLoginPage();
        return new LoginAction();
	}
	
    public AccountOverviewAction Login(UserProfile userProfile){
    	LegacyLoginPage legacyLoginPage = new LegacyLoginPage();
        legacyLoginPage.loginUser(userProfile);
        return new AccountOverviewAction();   	
    }
    
    public AccountOverviewAction verifyLogin(String lastname, String accNumber){
    	new AccountOverviewPage().verifyLogin(lastname, accNumber);
    	return new AccountOverviewAction();
    }
    
    public CorrespondanceAction navigateToDocumentsLink(){
    	CorrespondancePage cPage = new CorrespondancePage();
    	cPage.navigateToDocumentsLink();
    	return new CorrespondanceAction();
    }
    
    public CorrespondanceAction optingForPaperlessBilling(String AcctType, String Type, UserProfile userProfile){
    	CorrespondancePage cPage = new CorrespondancePage();
    	cPage.optingForPaperlessBilling(AcctType,Type,userProfile);
    	return new CorrespondanceAction();
    }
    
    public CorrespondanceAction navigateToAccountSummaryPage(UserProfile userProfile) {
        new AccountOverviewPage().navigateToAccountSummaryPage(userProfile);
        return new CorrespondanceAction();
    }
    
    public CorrespondanceAction revertToPaper(){
    	CorrespondancePage cPage = new CorrespondancePage();
    	cPage.revertToPaper();
    	return new CorrespondanceAction();
    }
    
    public CorrespondanceAction logout(){
    	CorrespondancePage cPage = new CorrespondancePage();
    	cPage.CorrespondanceLogout();
    	return new CorrespondanceAction();
    }
    
    public CorrespondanceAction verifyVbsFile(String AcNumber){
    	CorrespondancePage cPage = new CorrespondancePage();
    	cPage.verifyVbsFile(AcNumber);
    	return new CorrespondanceAction();
    }
}
