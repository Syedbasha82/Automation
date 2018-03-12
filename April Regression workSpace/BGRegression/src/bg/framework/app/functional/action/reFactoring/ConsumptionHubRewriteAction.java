package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.ConsumptionHubRewritePage;

public class ConsumptionHubRewriteAction {

	
	public ConsumptionHubRewriteAction updateLocationBy(String filter,String fuelType)
	{
		ConsumptionHubRewritePage findALocation= new ConsumptionHubRewritePage();
		findALocation.updateLocationBy(filter,fuelType);
		return this;
	}
	
	public ConsumptionHubRewriteAction changeCities(String energyType)
	{
		ConsumptionHubRewritePage changeCities= new ConsumptionHubRewritePage();
		changeCities.changeCities(energyType);
		return this;
	}
	
	
	public ConsumptionHubRewriteAction multiCityOverlay()
	{
		ConsumptionHubRewritePage multiCity= new ConsumptionHubRewritePage();
		multiCity.multiCityOverlay();
		return this;
	}
	
	public ConsumptionHubRewriteAction cityResultsPageNavigation()
	{
		ConsumptionHubRewritePage pageNavigation= new ConsumptionHubRewritePage();
		pageNavigation.cityResultsPageNavigation();
		return this;
	}
	
	public ConsumptionHubRewriteAction updateLocationErrorMessage(String filter,String fuelType)
	{
		ConsumptionHubRewritePage updateLocErr= new ConsumptionHubRewritePage();
		updateLocErr.updateLocationErrorMessage(filter,fuelType);
		return this;
	}
	
	public ConsumptionHubRewriteAction selectAccount(String AccountNumber){
		new ConsumptionHubRewritePage().selectAccount(AccountNumber);
		return this;
	}
	
	public ConsumptionHubRewriteAction enterRefineComparisonDetails(String Property,String Bedroom,String occupants,String AgeofProperty){
		new ConsumptionHubRewritePage().enterRefineComparisonDetails(Property,Bedroom,occupants,AgeofProperty);
		return this;
	}
	
	public ConsumptionHubRewriteAction logout(){
		new ConsumptionHubRewritePage().logout();
		return this;
	}
	
	public ConsumptionHubRewriteAction verifyComparisonDetails(){
		new ConsumptionHubRewritePage().verifyComparisonDetails();
		return this;
	}
	
	public ConsumptionHubRewriteAction verifyUpdatePremiseData(){
		new ConsumptionHubRewritePage().verifyUpdatePremiseData();
		return this;
	}
	
	public ConsumptionHubRewriteAction verifySavedData(){
    	new ConsumptionHubRewritePage().verifySavedData();
    	return new ConsumptionHubRewriteAction();
    }
	
	public ConsumptionHubRewriteAction EnterCityDetails(){
    	new ConsumptionHubRewritePage().EnterCityDetails();
    	return new ConsumptionHubRewriteAction();
    }
	
	public ConsumptionHubRewriteAction EnterPostCodeDetails(){
    	new ConsumptionHubRewritePage().EnterPostCodeDetails();
    	return new ConsumptionHubRewriteAction();
    }
	
	public ConsumptionHubRewriteAction verifyIncorrectPostcode(){
    	new ConsumptionHubRewritePage().verifyIncorrectPostcode();
    	return new ConsumptionHubRewriteAction();
    }
	
	public ConsumptionHubRewriteAction enterRefineDetails(){
    	new ConsumptionHubRewritePage().enterRefineDetails();
    	return new ConsumptionHubRewriteAction();
    }
	
	public ConsumptionHubRewriteAction verifySessionData(){
    	new ConsumptionHubRewritePage().verifySessionData();
    	return new ConsumptionHubRewriteAction();
    }
	
	 public ConsumptionHubRewriteAction verifyErrorMessage(){
    	new ConsumptionHubRewritePage().verifyErrorMessage();
    	return new ConsumptionHubRewriteAction();
	 }
	 
	 public ConsumptionHubRewriteAction verifyUnderstandYourUsageData(String UserType){
		 new ConsumptionHubRewritePage().verifyUnderstandYourUsageData(UserType);
		 return new ConsumptionHubRewriteAction();
	 }
	 
	 public ConsumptionHubRewriteAction enterNewRefineDetails(){
		 new ConsumptionHubRewritePage().enterNewRefineDetails();
		 return new ConsumptionHubRewriteAction();
	 }
	 
	 public ConsumptionHubRewriteAction verifyNewSavedData(){
		 new ConsumptionHubRewritePage().verifyNewSavedData();
		 return new ConsumptionHubRewriteAction();
	 }
	 
	 public ConsumptionHubRewriteAction verifyPostcodeandCity(){
		 new ConsumptionHubRewritePage().verifyPostcodeandCity();
		 return new ConsumptionHubRewriteAction();
	 }
	 
	 public ConsumptionHubRewriteAction verifyErrorTextExtremeValues(){
		 new ConsumptionHubRewritePage().verifyErrorTextExtremeValues();
		 return new ConsumptionHubRewriteAction();
	 }
	 
	 public ConsumptionHubRewriteAction enterCityDetails(){
		 new ConsumptionHubRewritePage().enterCityDetails();
		 return new ConsumptionHubRewriteAction();
	 }
	 
	 public ConsumptionHubRewriteAction verifyErrorMessageNewCustomer(){
		 new ConsumptionHubRewritePage().verifyErrorMessageNewCustomer();
		 return new ConsumptionHubRewriteAction();
	 }
	 
	 public ConsumptionHubRewriteAction verifyPostCodeLogic(){
		 new ConsumptionHubRewritePage().verifyPostCodeLogic();
		 return new ConsumptionHubRewriteAction();
	 }
	 
	 public ConsumptionHubRewriteAction verifyFuelToggle(){
		 new ConsumptionHubRewritePage().verifyFuelToggle();
		 return new ConsumptionHubRewriteAction();
	 }
	 
	 public ConsumptionHubRewriteAction verifyCitySelection(){
		 new ConsumptionHubRewritePage().verifyCitySelection();
		 return new ConsumptionHubRewriteAction();
	 }
	 
	 public ConsumptionHubRewriteAction verifySortOrderCity(String SortingOrder){
		 new ConsumptionHubRewritePage().verifySortOrderCity(SortingOrder);
		 return new ConsumptionHubRewriteAction();
	 }
}
