package bg.framework.app.functional.action.selfServe;

import bg.framework.app.functional.page.selfServe.NectarPage;



public class NectarAction {
	
	public NectarAction navigateToProductAndServices(){
		NectarPage nectarpage = new NectarPage();
		nectarpage.navigateToProductAndServices();
		return new NectarAction();
	}
	
	public NectarAction navigateToNectarPointsPage(){
		NectarPage nectarpage = new NectarPage();
		nectarpage.navigateToNectarPointsPage();
		return new NectarAction();
	}
	
	public NectarAction navigateToRegisterPage(){
		NectarPage nectarpage = new NectarPage();
		nectarpage.navigateToRegisterPage();
		return new NectarAction();
	}
	
	public NectarAction fillRegisterDetails(String CRN){
		NectarPage nectarpage = new NectarPage();
		nectarpage.fillRegisterDetails(CRN);
		return new NectarAction();
	}
	
	public NectarAction verifyLeadWithDB(){
		NectarPage nectarpage = new NectarPage();
		nectarpage.verifyLeadWithDB();
		return new NectarAction();
	}
	
	public NectarAction navigateToUpdateNectarCard(){
		NectarPage nectarpage = new NectarPage();
		nectarpage.navigateToUpdateNectarCard();
		return new NectarAction();
	}
	
	public NectarAction updateNectarCardNumber(){
		NectarPage nectarpage = new NectarPage();
		new NectarPage().updateNectarCardNumber();
		return new NectarAction();
	}
	
	public NectarAction navigateToYourPointsPage(){
		NectarPage nectarpage = new NectarPage();
		new NectarPage().navigateToYourPointsPage();
		return new NectarAction();
	}
	
	public NectarAction navigateToPreOamRegistration(String Email){
		NectarPage nectarpage = new NectarPage();
		new NectarPage().navigateToPreOamRegistration(Email);
		return new NectarAction();
	}
	
	public NectarAction navigateToRegistrationPage(){
		NectarPage nectarpage = new NectarPage();
		new NectarPage().navigateToRegistrationPage();
		return new NectarAction();
	}
	
	public NectarAction getNectarCard(){
		NectarPage nectarpage = new NectarPage();
		new NectarPage().getNectarCard();
		return new NectarAction();
	}
	
	public NectarAction logout(){
		NectarPage nectarpage = new NectarPage();
		new NectarPage().logout();
		return new NectarAction();
	}
	
	public NectarAction navigateToPointsHistoryPage(){
		NectarPage nectarpage = new NectarPage();
		new NectarPage().navigateToPointsHistoryPage();
		return new NectarAction();
	}
	
	public NectarAction verifyNectarPointsPage(){
		NectarPage nectarpage = new NectarPage();
		new NectarPage().verifyNectarPointsPage();
		return new NectarAction();
	}
	
	public NectarAction addNectarCard(){
		NectarPage nectarpage = new NectarPage();
		new NectarPage().addNectarCard();
		return new NectarAction();
	}
	
	public NectarAction enterAccountInformation(String lastname,String postcode){
		NectarPage nectarpage = new NectarPage();
		new NectarPage().enterAccountInformation(lastname,postcode);
		return new NectarAction();
	}
	
	public NectarAction verifyYourPointsPage(){
		NectarPage nectarpage = new NectarPage();
		new NectarPage().verifyYourPointsPage();
		return new NectarAction();
	}
	
	public NectarAction verifyNectarRegister(){
		NectarPage nectarpage = new NectarPage();
		new NectarPage().verifyNectarRegister();
		return new NectarAction();
	}
	
	public NectarAction verifyNonRegister(){
		NectarPage nectarpage = new NectarPage();
		new NectarPage().verifyNonRegister();
		return new NectarAction();
	}
}
