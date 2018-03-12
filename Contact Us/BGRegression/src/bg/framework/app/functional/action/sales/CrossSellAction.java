package bg.framework.app.functional.action.sales;

import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.UserProfile;

import bg.framework.app.functional.page.sales.CrossSellPage;
import bg.framework.app.functional.page.selfServe.AccountOverviewPage;

public class CrossSellAction {
	 CrossSellPage crossSellPage=new CrossSellPage();
	 
	 public CrossSellAction enterHomecareDetails(Acquisition acquisition) {
			 crossSellPage.enterHomecareDetails(acquisition);
	             return this;
	    }
	 
	 
	 public CrossSellAction enterNectaroptionone() {
		 crossSellPage.enterNectaroptionone();
             return this;
    }
	 
	 public CrossSellAction enterNectaroptiontwo() {
		 crossSellPage.enterNectaroptiontwo();
             return this;
    }
	 
	 public CrossSellAction enterNectaroptionthree() {
		 crossSellPage.enterNectaroptionthree();
             return this;
    }
	 
	 
	 public CrossSellAction enterNectaroptionfour() {
		 crossSellPage.enterNectaroptionfour();
             return this;
    }
	 
	 public CrossSellAction enterConfirmOrder() {
		 crossSellPage.enterConfirmOrder();
             return this;
    }
	 
	 
	 public CrossSellAction verifyHomecarehundred() {
		 crossSellPage.verifyHomecarehundred();
             return this;
    }
	 
	 
	 public CrossSellAction verifyHomecaretwohundred() {
		 crossSellPage.verifyHomecaretwohundred();
             return this;
    }
	 
	 public CrossSellAction verifyHomecarethreehundred() {
		 crossSellPage.verifyHomecarethreehundred();
             return this;
    }
	 
	 
	 public AccountOverviewAction verifyHomecarefourhundred() {
		 crossSellPage.verifyHomecarefourhundred();
             return new AccountOverviewAction();
    }
	 
	 public CrossSellAction navigateHomecaretwohundred() {
		 crossSellPage.navigateHomecaretwohundred();
             return this;
    }
	 
	 
	 public CrossSellAction navigateHomecarethreehundred() {
		 crossSellPage.navigateHomecarethreehundred();
             return this;
    }
	 
	 
	 public CrossSellAction navigateHomecarefourhundred() {
		 crossSellPage.navigateHomecarefourhundred();
             return this;
    }
	 
	 public CrossSellAction loginErrorForClosedAccount() {
		 crossSellPage.loginErrorForClosedAccount();
             return this;
    }
	 public CrossSellAction CrossCellCheck1() {
		 crossSellPage.CrossCellCheck1();
             return this;
    }
	 
	 public CrossSellAction CrossCellCheck2() {
		 crossSellPage.CrossCellCheck2();
             return this;
    }
	 public CrossSellAction verifyandclickExcess0() {
		 crossSellPage.verifyandclickExcess0();
             return this;  
    }
	 public CrossSellAction verifyandclickExcess50() {
		 crossSellPage.verifyandclickExcess50();
             return this;  
    }
	 public CrossSellAction verifyandclickExcess99() {
		 crossSellPage.verifyandclickExcess99();
             return this;  
    }
	 public CrossSellAction orderHomecare100() {
		 crossSellPage.orderHomecare100();
             return this;  
    }
	 public CrossSellAction orderHomecare200() {
		 crossSellPage.orderHomecare200();
             return this;  
    }
	 public CrossSellAction orderHomecare300() {
		 crossSellPage.orderHomecare300();
             return this;  
    }
	 public CrossSellAction orderHomecare400() {
		 crossSellPage.orderHomecare400();
             return this;  
    }
	 public CrossSellAction verifyCrossSellEndToEnd(UserProfile userProfile,Acquisition acquisition){
		 crossSellPage.verifyCrossSellEndToEnd(userProfile,acquisition);
         return this; 
	 }
	 public CrossSellAction logout() {
	        new AccountOverviewPage().logout();
	        /*crossSellPage.getServicesLeadType();
	        crossSellPage.getServicesLeadData();*/
	        return this;
	    }
	 public CrossSellAction getServicesLeadType() {
		 crossSellPage.getServicesLeadType();
         return this; 
	 }
     public CrossSellAction getServicesLeadData() {
         crossSellPage.getServicesLeadData();
         return this; 
     }
	 
}
