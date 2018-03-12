package bg.framework.app.functional.action.sales;

import java.io.IOException;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.sales.CompareTariffPage;

public class CompareTariffAction {

	public CompareTariffAction navigateToGasAndElecPage(){
		new CompareTariffPage().navigateToGasAndElectricityPage();
		return new CompareTariffAction();
	}
	
	public CompareTariffAction navigateToOurTariffPage(){
		new GasAndElectricityAction().navigateToOurTariffsPage();
		return new CompareTariffAction();
	}
	
	public CompareTariffAction navigateToCompareTariffPage(){
		new CompareTariffPage().navigateToCompareTariff();
		return new CompareTariffAction();
	}
	
	public CompareTariffAction verifyCompareTariffPage(String Registers,String tariff, String payment ,String postCode,String DualFuel){
		new CompareTariffPage().verifyCompareTariffPage(Registers,tariff,payment,postCode,DualFuel);
		return new CompareTariffAction();
	}
	
	public CompareTariffAction enterPostCode(String custType, UserProfile userProfile,String postCode){
		new CompareTariffPage().enterPostcode(custType, userProfile, postCode);
		return new CompareTariffAction();
	}
	
	public CompareTariffAction navigateToAllTariffPage(){
		new CompareTariffPage().navigateToAllTariffPage();
		return new CompareTariffAction();
	}
	
	public CompareTariffAction enterDetailsinAllTariffPage(UserProfile userProfile){
		new CompareTariffPage().enterDetailsinAllTariffPage(userProfile);
		return new CompareTariffAction();
	}
	
	public CompareTariffAction verifyPostCodePrepopulated(UserProfile userProfile){
		new CompareTariffPage().verifyPostCodePrepopulated(userProfile);
		return new CompareTariffAction();
	}
	
	public CompareTariffAction navigateToGAQ(){
		new CompareTariffPage().navigateToGAQ();
		return new CompareTariffAction();
	}
	
}
