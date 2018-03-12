package bg.framework.app.functional.action.sales;

import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.entities.EshopTariffProfile;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.AccountOverviewPage;
import bg.framework.app.functional.page.sales.BetterDealPage;
import bg.framework.app.functional.page.sales.EshopNewPage;


public class BetterDealAction {
	private UserProfile userProfile;

	private static String Fuel; 
	private static String SalesType;
	private static String CustomerType;
	private static String AddressType;
	public BetterDealAction(String Fuel,String SalesType, String CustomerType, String AddressType){
		this.Fuel = Fuel;
		this.SalesType = SalesType;
		this.CustomerType = CustomerType;
		this.AddressType = AddressType;
	}   
	public BetterDealAction(){
		
	}
	public BetterDealAction(UserProfile userProfile){
	this.userProfile=userProfile;	
	}
	

    
	
	public LoginAction logout() {
        new AccountOverviewPage().logout();
        return new LoginAction();
    } 
	
	public  BetterDealAction navigateToYourTariffCheckPage(){
		new BetterDealPage().navigateToYourTariffCheckPage();
		return new BetterDealAction();
	}
	public BetterDealAction verifyYourTariffCheckPage(String AccType) {
		new BetterDealPage().verifyYourTariffCheckPage(AccType);
		return new  BetterDealAction() ;
	}
	public BetterDealAction verifyBetterdealOverlayAndConfirm(UserProfile userProfile,String FuelType) {
		new BetterDealPage().verifyBetterdealOverlayAndConfirm(userProfile,FuelType);
		return new  BetterDealAction() ;
	}
	public BetterDealAction verifyThankyouPage() {
		new BetterDealPage().verifyThankyouPage();
		return new  BetterDealAction() ;
	}
	public BetterDealAction selectTariff(String tariff,EshopTariffProfile eshopTariff){
		new BetterDealPage(Fuel,SalesType,CustomerType,AddressType).selectTariff(tariff,eshopTariff);
		return new BetterDealAction();
	}	
	public BetterDealAction verifyChangedTariffInAccountSummaryPage(String tariff){
		new BetterDealPage(Fuel,SalesType,CustomerType,AddressType).verifyChangedTariffInAccountSummaryPage(tariff);
		return new BetterDealAction();
}
	public BetterDealAction verifyChangedTariffInAccountSummaryPageforDual(String tariff,String accNum){
		new BetterDealPage(Fuel,SalesType,CustomerType,AddressType).verifyChangedTariffInAccountSummaryPageforDual(tariff,accNum);
		return new BetterDealAction();
}
	public BetterDealAction verifyChangedTariffInAccountSummaryPageJI(String tariff){
		new BetterDealPage(Fuel,SalesType,CustomerType,AddressType).verifyChangedTariffInAccountSummaryPageJI(tariff);
		return new BetterDealAction();
}
}