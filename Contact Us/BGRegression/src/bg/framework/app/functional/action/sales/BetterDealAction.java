package bg.framework.app.functional.action.sales;

import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.AccountOverviewPage;
import bg.framework.app.functional.page.sales.BetterDealPage;


public class BetterDealAction {
	private UserProfile userProfile;
	
	public BetterDealAction(){
		
	}
	public BetterDealAction(UserProfile userProfile){
	this.userProfile=userProfile;	
	}
	
	public BetterDealAction loginUserDetails(UserProfile userProfile) {
        BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.loginUserDetails(userProfile);
        return new BetterDealAction(userProfile);
    }
	
	public BetterDealAction betterDealUrl(UserProfile userProfile, String fualType) {
        BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.betterDealUrl(userProfile, fualType);
        return new BetterDealAction(userProfile);
    }
	
	public BetterDealAction deepUrl(UserProfile userProfile, String Dual) {
        BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.deepUrl(userProfile, Dual);
        return new BetterDealAction(userProfile);
    }

	public BetterDealAction loginUrl(UserProfile userProfile) {
        BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.loginUrl(userProfile);
        return new BetterDealAction(userProfile);
    }	
	
	public BetterDealAction deepUrlRegistartion(UserProfile userProfile) {
        BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.deepUrlRegistartion(userProfile);
        return new BetterDealAction(userProfile);
    }	
	
	public LoginAction logout() {
        new AccountOverviewPage().logout();
        return new LoginAction();
    } 
	
	public BetterDealAction betterDealHeading(UserProfile userProfile) {
		     BetterDealPage legacyLoginPage = new BetterDealPage();        
	        legacyLoginPage.betterDealHeading(userProfile);
	        return new BetterDealAction();
	    }
	
	public BetterDealAction saveMoneyQuestion(UserProfile userProfile) {
	     BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.saveMoneyQuestion(userProfile);
        return new BetterDealAction();
    }
	
	 public BetterDealAction saveMoneyAnswer(UserProfile userProfile) {
	     BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.saveMoneyAnswer(userProfile);
        return new BetterDealAction();
    }
	 
	 public BetterDealAction fualType(UserProfile userProfile, String fualtype) {
	     BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.fualType(userProfile, fualtype);
        return new BetterDealAction();
    }
	 
	 
	 public BetterDealAction postCodeTitle(UserProfile userProfile) {
	     BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.postCodeTitle(userProfile);
        return new BetterDealAction();
    }
	 
	 public BetterDealAction currentTariff(UserProfile userProfile) {
	     BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.currentTariff(userProfile);
        return new BetterDealAction();
    }
	 
	 public BetterDealAction currentSpendTitle(UserProfile userProfile) {
	     BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.currentSpendTitle(userProfile);
        return new BetterDealAction();
    }
	 
/*	 public BetterDealAction currentSpendPound(UserProfile userProfile) {
	     BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.currentSpendPound(userProfile);
        return new BetterDealAction();
    }*/
	 
	 public BetterDealAction currentSpendTimeSpan(UserProfile userProfile) {
	     BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.currentSpendTimeSpan(userProfile);
        return new BetterDealAction();
    }

	/* public BetterDealAction currentSpendCalculation(UserProfile userProfile) {
	     BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.currentSpendCalculation(userProfile);
        return new BetterDealAction();
    }*/
	 
	 public BetterDealAction tariffTableTextValidation(UserProfile userProfile, String fualtype) {
	     BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.tariffTableTextValidation(userProfile, fualtype);
        return new BetterDealAction();
    }
	 public BetterDealAction tariffCount(UserProfile userProfile) {
	     BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.tariffCount(userProfile);
        return new BetterDealAction();
    }
	 public BetterDealAction tariffCalculation(UserProfile userProfile) {
	     BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.tariffCalculation(userProfile);
        return new BetterDealAction();
    } 
	 public BetterDealAction betterBanner(UserProfile userProfile) {
	     BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.betterBanner(userProfile);
        return new BetterDealAction();
    } 
	 
	 public BetterDealAction findOutMore(UserProfile userProfile) {
	     BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.findOutMore(userProfile);
        return new BetterDealAction();
    } 
	 
	 public BetterDealAction whatisthis(UserProfile userProfile) {
	     BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.whatisthis(userProfile);
        return new BetterDealAction();
    } 
	 public BetterDealAction twoDecimalCurrentSpend(UserProfile userProfile) {
	     BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.twoDecimalCurrentSpend(userProfile);
        return new BetterDealAction();
    } 
	 public BetterDealAction nector(UserProfile userProfile, String nectorRegistered) {
	     BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.nector(userProfile, nectorRegistered);
        return new BetterDealAction();
    } 
	 public BetterDealAction directDebit(UserProfile userProfile, String directDebitELE,  String directDebitGAS) {
	     BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.directDebit(userProfile, directDebitELE, directDebitGAS);
        return new BetterDealAction();
    } 
	 public BetterDealAction directDebitSingle(UserProfile userProfile, String directDebitSingle) {
	     BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.directDebitSingle(userProfile, directDebitSingle);
        return new BetterDealAction();
    } 
	 
	 public BetterDealAction esmart(UserProfile userProfile, String esmartEle,  String esmartGas) {
	     BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.esmart(userProfile, esmartEle, esmartGas);
        return new BetterDealAction();
    }
	 public BetterDealAction esmartSingle(UserProfile userProfile, String esmart) {
	     BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.esmartSingle(userProfile, esmart);
        return new BetterDealAction();
    }
	 
	 public BetterDealAction switchNow(UserProfile userProfile) {
	     BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.switchNow(userProfile);
        return new BetterDealAction();
    }
	 public BetterDealAction errorMessage(UserProfile userProfile) {
	     BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.errorMessage(userProfile);
        return new BetterDealAction();
    } 
	 public BetterDealAction loginErrorMessage(UserProfile userProfile) {
	     BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.loginErrorMessage(userProfile);
        return new BetterDealAction();
    } 
	 
	 public BetterDealAction deepUrlRegistartionErrorMessage(UserProfile userProfile) {
	     BetterDealPage legacyLoginPage = new BetterDealPage();        
        legacyLoginPage.deepUrlRegistartionErrorMessage(userProfile);
        return new BetterDealAction();
    } 
	 
	// ********************* RMR Changes ******************* //
	 public BetterDealAction verifyTCRValue(String fuelType, String payment,UserProfile userProfile){
		 new BetterDealPage().verifyTCRValue(fuelType, payment, userProfile);
		 return new BetterDealAction();
	 }
	 
	 public BetterDealAction navigateToTariffCheckPage(){
		 new BetterDealPage().navigateToTariffCheckPage();
		 return new BetterDealAction();
	 }
	 
}
