package bg.framework.app.functional.action.sales;

import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.EshopTariffProfile;
import bg.framework.app.functional.entities.GetAPrice;
import bg.framework.app.functional.entities.GetAPricePageProfile;
import bg.framework.app.functional.entities.PriceDetails;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.sales.EshopNewPage;

public class EshopActionNew {


	private static String Fuel; 
	private static String SalesType;
	private static String CustomerType;
	private static String AddressType;



	public EshopActionNew(String Fuel,String SalesType, String CustomerType, String AddressType){
		this.Fuel = Fuel;
		this.SalesType = SalesType;
		this.CustomerType = CustomerType;
		this.AddressType = AddressType;
	}   
	public EshopActionNew() {

	}
	public EshopActionNew selectTariff(String tariff,EshopTariffProfile eshopTariff){
		new EshopNewPage(Fuel,SalesType,CustomerType,AddressType).selectTariff(tariff,eshopTariff);
		return new EshopActionNew();
	}	
	public EshopActionNew fillOrderDetailsPage(Acquisition acquisition){
		new EshopNewPage(Fuel,SalesType,CustomerType,AddressType).fillOrderDetailsPage(acquisition);
		return new EshopActionNew();
	}
	public EshopActionNew JourneyType(String payment,Acquisition acquisition,UserProfile userProfile){
		new EshopNewPage(Fuel,SalesType,CustomerType,AddressType).JourneyType(payment, acquisition, userProfile);
		return new EshopActionNew();
	}
	public EshopActionNew verifyThankyouPage(){
		new EshopNewPage(Fuel,SalesType,CustomerType,AddressType).verifyThankyouPage();
		return new EshopActionNew();
	}
	public EshopActionNew verifyEshopLeadType(UserProfile userProfile){
		new EshopNewPage(Fuel,SalesType,CustomerType,AddressType).verifyEshopLeadType(userProfile);
		return new EshopActionNew();
	}
	public EshopActionNew verifyEshopLeadID(){
		new EshopNewPage(Fuel,SalesType,CustomerType,AddressType).verifyEshopLeadID();
		return new EshopActionNew();
	}
	public EshopActionNew logout(){
		new EshopNewPage(Fuel,SalesType,CustomerType,AddressType).logout();
		return new EshopActionNew();
	}
	public EshopActionNew ConversionJourney(){
		new EshopNewPage(Fuel,SalesType,CustomerType,AddressType).eshopConversionJourney();
		return new EshopActionNew();
	}
	public EshopActionNew verifyChangeInTariff(String tariff,String accNum){
		new EshopNewPage(Fuel,SalesType,CustomerType,AddressType).verifyChangeInTariff(tariff,accNum);
		return new EshopActionNew();
	}
}

