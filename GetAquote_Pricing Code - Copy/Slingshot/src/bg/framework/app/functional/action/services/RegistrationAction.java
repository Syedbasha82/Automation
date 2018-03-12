package bg.framework.app.functional.action.services;

import bg.framework.app.functional.entities.LandLord;
import bg.framework.app.functional.page.services.RegistrationPage;

public class RegistrationAction {
	private LandLord landLord;
	public RegistrationAction(LandLord landLord) {
		this.landLord=landLord;
	}

	public RegistrationAction registrationFirstStepAction(){
		final RegistrationPage registrationPage=new RegistrationPage(landLord);
		registrationPage.registrationFirstPageSuccess();
		registrationPage.enterPersonalDetails();
		registrationPage.clickRegisterButton();
		return this;
	}
	
	public RegistrationAction registrationSecondStepAction(){
		final RegistrationPage registrationPage=new RegistrationPage(landLord);
		registrationPage.registrationSecondPageSuccess();
		registrationPage.enterLoginDetails();
		registrationPage.clickTermsCheckBox();
		registrationPage.clickContinueButton();
		registrationPage.registrationSuccess();
		return this;
	}
}
