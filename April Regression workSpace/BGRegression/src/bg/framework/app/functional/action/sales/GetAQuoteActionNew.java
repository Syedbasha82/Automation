package bg.framework.app.functional.action.sales;

import bg.framework.app.functional.entities.GetAPrice;
import bg.framework.app.functional.entities.PriceDetails;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.sales.GetAQuotePageNew;

public class GetAQuoteActionNew {
	private static String AddrType;
	private static String Fuel;
	private static String CustomerType;

	public GetAQuoteActionNew(String AddrType , String Fuel ,String CustomerType){
		this.AddrType = AddrType;
		this.Fuel = Fuel;
		this.CustomerType = CustomerType;
	}
	public GetAQuoteActionNew(){
		
	}
	
	public GetAQuoteActionNew logout(){
		new GetAQuotePageNew(AddrType,Fuel,CustomerType).logout(); 
		return new GetAQuoteActionNew();
	}
	
	public GetAQuoteActionNew enterPostCode(PriceDetails getAPrice){
		new GetAQuotePageNew(AddrType,Fuel,CustomerType).enterPostCode(getAPrice);
		return new GetAQuoteActionNew();
	}
	public GetAQuoteActionNew enteringPostCode(String postCode){
		new GetAQuotePageNew(AddrType,Fuel,CustomerType).enteringPostCode(postCode);
		return new GetAQuoteActionNew();
	}
	public GetAQuoteActionNew navigateToGetAQuotePage(){
		new GetAQuotePageNew(AddrType,Fuel,CustomerType).navigateToGetAQuotePage();
		return new GetAQuoteActionNew();
	}
	public GetAQuoteActionNew selectFuelType(){
		new GetAQuotePageNew(AddrType,Fuel,CustomerType).selectFuel();
		return new GetAQuoteActionNew();
	}
	
	public GetAQuoteActionNew selectPaymentType(String payment){
		new GetAQuotePageNew(AddrType,Fuel,CustomerType).selectPayment(payment);
		return new GetAQuoteActionNew();
	}
	
	public GetAQuoteActionNew EnterDetails(PriceDetails getAPrice,String energyUsage, String CustType){
		new GetAQuotePageNew(AddrType,Fuel,CustomerType).enterUsageAndPersonalDetails(getAPrice, energyUsage, CustType);
		return new GetAQuoteActionNew();
	}	
	
	public GetAQuoteActionNew verifyQuoteResultPage(){
		new GetAQuotePageNew(AddrType,Fuel,CustomerType).verifyQuoteResultPage();
		return new GetAQuoteActionNew();
	}
	
	public GetAQuoteActionNew selectAddress(){
		new GetAQuotePageNew(AddrType,Fuel,CustomerType).selectAddress();
		return new GetAQuoteActionNew();
	}
	public GetAQuoteActionNew verifyTCRValue(String fuel,String payment,String postCode){
		new GetAQuotePageNew(AddrType,Fuel,CustomerType).verifyTCRValue(fuel, payment, postCode);
		return new GetAQuoteActionNew();
	}
	
    
}
