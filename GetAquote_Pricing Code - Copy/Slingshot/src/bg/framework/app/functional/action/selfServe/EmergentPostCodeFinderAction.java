package bg.framework.app.functional.action.selfServe;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.selfServe.EmergentPostCodeFinderPage;

public class EmergentPostCodeFinderAction {
	
	public  EmergentPostCodeFinderAction navigateToEmergencies()
	{
		EmergentPostCodeFinderPage emergencyPostCode = new EmergentPostCodeFinderPage();
		emergencyPostCode.navigateToEmergencies();	
		return this;
	}
	
	public EmergentPostCodeFinderAction enterThePostCode()
	{
		EmergentPostCodeFinderPage emergencyPostCode = new EmergentPostCodeFinderPage();
		emergencyPostCode.enterThePostCode();
		return this;
	}
	
	public EmergentPostCodeFinderAction navigateToLogin(UserProfile userProfile)
	{
	   new HomePageAction().navigateToLoginPage();
	   return this;
	}
	
	public EmergentPostCodeFinderAction logOut()
	{
	   new AccountOverviewAction().logout();
	   return this;
	}
	
	public EmergentPostCodeFinderAction loginUser(UserProfile userProfile)
	{
		new LoginAction().login(userProfile);
		return this;
	}

}
