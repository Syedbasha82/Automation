package bg.framework.app.functional.action.services;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.services.PasswordRestPage;

public class ForgotPasswordAction {

	public void verifyOneTimePwd(UserProfile userProfile){
		final PasswordRestPage reset=new PasswordRestPage();
		reset.navigateToOneTimePasswordPage(userProfile);
	}
}
