package bg.framework.app.functional.action.sales;

import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.sales.TOUChangePage;

public class TOUChangeAction {
	
	public TOUChangeAction navigateToTOULandingPage(String Flow){
		new TOUChangePage().navigateToTOULandingPage(Flow); 
		return this;
	}
	
	public TOUChangeAction selectCustomer(String Customer){
		new TOUChangePage().selectCustomer(Customer); 
		return this;
	}
	
	public TOUChangeAction selectNectar(String Nectar){
		new TOUChangePage().nectarDetails(Nectar); 
		return this;
	}
	public TOUChangeAction newCustScreeningQues(String PPMeter,String Eco7,String Flat,String FuseBox,String Smart){
		new TOUChangePage().newCustScreeningQues(PPMeter , Eco7, Flat, FuseBox, Smart); 
		return this;
	}
	
	public TOUChangeAction screeningContinue(){
		new TOUChangePage().screeningContinue(); 
		return this;
	}
	
	public TOUChangeAction newCustomerContinue(){
		new TOUChangePage().newCustomerContinue(); 
		return this;
	}
	
	public TOUChangeAction smartmeterContinue(){
		new TOUChangePage().smartmeterContinue(); 
		return this;
	}
	
	public TOUChangeAction standardmeterContinue(){
		new TOUChangePage().standardmeterContinue(); 
		return this;
	}
	
	public TOUChangeAction tellAbtYou(UserProfile userProfile,String AddressDD){
		new TOUChangePage().tellAbtYou(userProfile, AddressDD); 
		return this;
	}
	
	public TOUChangeAction verifySalesOrderCreation(){
		new TOUChangePage().verifySalesOrderCreation(); 
		return this;
	}

	public TOUChangeAction newPaymentPageCC(){
		new TOUChangePage().newPaymentPageCC(); 
		return this;
	}
	
	public TOUChangeAction  newMeterDetailsPageForPayAsYouGo(){
		new TOUChangePage(). newMeterDetailsPageForPayAsYouGo(); 
		return this;
	}
	
	public TOUChangeAction  newReviewOrderForPAYGo(){
		new TOUChangePage(). newReviewOrderForPAYGo(); 
		return this;
	}
	
	public TOUChangeAction  newValidateConfirmationForPAYGo(){
		new TOUChangePage(). newValidateConfirmationForPAYGo(); 
		return this;
	}
	public TOUChangeAction newCusFlowDeciderForMvdd(Acquisition acquisition,UserProfile userProfile,String AddressDD,String PayType, String MvddTariff,String Nectar,String Meter){
		new TOUChangePage().newCusFlowDeciderForMvdd( acquisition, userProfile, AddressDD,PayType,MvddTariff,Nectar,Meter); 
		return this;
	}
	
	public TOUChangeAction newCusFlowDeciderForCC(Acquisition acquisition,UserProfile userProfile,String AddressDD,String PayType,String CCTariff,String Nectar,String Meter){
		new TOUChangePage().newCusFlowDeciderForCC( acquisition, userProfile, AddressDD,PayType,CCTariff,Nectar,Meter); 
		return this;
	}
	
	public TOUChangeAction newCusFlowDeciderForPayGo(Acquisition acquisition,UserProfile userProfile,String AddressDD,String PayType,String PayGoTariff,String Nectar,String Meter){
		new TOUChangePage().newCusFlowDeciderForPayGo( acquisition, userProfile, AddressDD,PayType,PayGoTariff,Nectar,Meter); 
		return this;
	}
		
	public TOUChangeAction  upgradeNowLink(){
		new TOUChangePage().upgradeNowLink(); 
		return this;
	}
	
	public TOUChangeAction selectTariff(String Tariff){
		new TOUChangePage().selectTariff(Tariff); 
		return this;
	}
	
	public TOUChangeAction  orderFreeOverlay(){
		new TOUChangePage().orderFreeOverlay(); 
		return this;
	}
	
	public TOUChangeAction  GAQPage(){
		new TOUChangePage().GAQPage(); 
		return this;
	}
	
	public TOUChangeAction tariff(String GAQTariff){
		new TOUChangePage().tariff(GAQTariff); 
		return this;
	}
	
	public TOUChangeAction GAQFlow(){
		new TOUChangePage().GAQFlow(); 
		return this;
	}
	
	public TOUChangeAction MIFlow(){
		new TOUChangePage().MIFlow(); 
		return this;
	}
	
	public TOUChangeAction MiTariff(String MiTariff){
		new TOUChangePage().MiTariff(MiTariff); 
		return this;
	}
	
	public TOUChangeAction cstLink(String CSTFlow){
		new TOUChangePage().cstLink(CSTFlow); 
		return this;
	}
	
	public TOUChangeAction ineligibleFlow(){
		new TOUChangePage().ineligibleFlow(); 
		return this;
	}
	
	public TOUChangeAction eligibleFlow(){
		new TOUChangePage().eligibleFlow(); 
		return this;
	}
}
