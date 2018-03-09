package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.EshopPage;

public class EshopAction {
	
	private static String Fuel; 
	private static String SalesType;
	private static String CustomerType;
	
	public EshopAction(){
		
	}
	
	public EshopAction(String Fuel){
		this.Fuel = Fuel;
	}
	
	public EshopAction(String Fuel,String SalesType, String CustomerType){
		this.Fuel = Fuel;
		this.SalesType = SalesType;
		this.CustomerType = CustomerType;
	}

	
	public EshopAction navigateToGasandElectricityPage(){
	 new EshopPage(Fuel,SalesType,CustomerType).navigateToGasandElectricityPage();
	 return new EshopAction();	
	}
	
	public EshopAction navigateToOurTariffsPage(){
	 new EshopPage(Fuel,SalesType,CustomerType).navigateToOurTariffsPage();
	 return new EshopAction();	
	}
	
	public EshopAction selectTariff(String Tariff){
	 new EshopPage(Fuel,SalesType,CustomerType).selectTariff(Tariff);
	 return new EshopAction();	
	}
	
	public EshopAction selectFuel(String Fuel){
	 new EshopPage(this.Fuel).selectFuel(Fuel);
	 return new EshopAction();	
	}
	
	public EshopAction fillYourOrderPageDetails(Acquisition acquisition,String AddrSelect,String JourneyType){
	 new EshopPage(this.Fuel).fillYourOrderPageDetails(acquisition,AddrSelect,JourneyType);
	 return new EshopAction();	
	}	
	
	
	/*public EshopAction fillYourOrderPageDetails(Acquisition acquisition,String Fuel, String TariffFuel){
		 new EshopPage(this.Fuel).fillYourOrderPageDetails(acquisition,Fuel,TariffFuel);
		 return new EshopAction();	
	}*/	
	
	public EshopAction enterPersonalDetails(Acquisition acquisition,UserProfile userProfile,String AddrSelect, String JourneyType){
	 new EshopPage(this.Fuel).enterPersonalDetails(acquisition,userProfile,AddrSelect,JourneyType);
	 return new EshopAction();	
	}
	
	public EshopAction enterCurrentMeterDetails(Acquisition acquisition,String Fuel){
	 new EshopPage(this.Fuel).enterCurrentMeterDetails(acquisition,Fuel);
	 return new EshopAction();	
	}
	
	public EshopAction enterPaymentDetails(Acquisition acquisition){
	 new EshopPage(Fuel,SalesType,CustomerType).enterPaymentDetails(acquisition);
	 return new EshopAction();	
	}
	
	public EshopAction enterReviewOrderDetails(){
	 new EshopPage(Fuel,SalesType,CustomerType).enterReviewOrderDetails();
	 return new EshopAction();	
	}
	
	public EshopAction verifyThankyouPage(String Fuel){
	 new EshopPage(this.Fuel).verifyThankyouPage(Fuel);
	 return new EshopAction();	
	}
	
	public EshopAction verifyEshopLeadType(){
	 new EshopPage(Fuel,SalesType,CustomerType).verifyEshopLeadType();
	 return new EshopAction();	
	}
	
	public EshopAction verifyEshopLeadID(){
	 new EshopPage(Fuel,SalesType,CustomerType).verifyEshopLeadID();
	 return new EshopAction();	
	}
	
	public EshopAction backToHomepage(){
		new EshopPage(Fuel,SalesType,CustomerType).backToHomepage();
		 return new EshopAction();	
	}
	
	public EshopAction logout(){
		new EshopPage(Fuel,SalesType,CustomerType).logout();
		 return new EshopAction();	
	}
	
	public EshopAction fillConversionYourOrderPageDetails(Acquisition acquisition){
		new EshopPage(Fuel,SalesType,CustomerType).fillConversionYourOrderPageDetails(acquisition);
		 return new EshopAction();	
	}
	
	public EshopAction fillPartAcqAndPartConversionYourOrderPageDetails(Acquisition acquisition, String Fuel){
		new EshopPage(Fuel,SalesType,CustomerType).fillPartAcqAndPartConversionYourOrderPageDetails(acquisition);
		return new EshopAction();
	}

	public EshopAction verifyErrorMessage() {
		new EshopPage(Fuel,SalesType,CustomerType).verifyErrorMessage();
		return new EshopAction();
		
	}
}
