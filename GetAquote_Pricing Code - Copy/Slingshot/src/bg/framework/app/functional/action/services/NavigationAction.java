package bg.framework.app.functional.action.services;

import bg.framework.app.functional.entities.LandLord;

import bg.framework.app.functional.page.services.AccountOverViewPage;
import bg.framework.app.functional.page.services.AccountSummaryPage;
import bg.framework.app.functional.page.services.HomePage;
import bg.framework.app.functional.page.services.LoginPage;

public class NavigationAction {
	private LandLord landLord;
	public NavigationAction(){
		
	}
	public NavigationAction(LandLord landLord){
		this.landLord=landLord;
	}
	
	
	public GetAQuoteAction navigateToLandLordAction(){
		final HomePage homePage=new HomePage();
		homePage.navigateToLandLordPage();
		return new GetAQuoteAction(landLord);
	}
	
	public NavigationAction navigateToLoginPage(){
		final HomePage homePage=new HomePage();
		homePage.navigateToLoginPage();
		return this;
	}
	
	public NavigationAction loginAction(LandLord landLord){
		final LoginPage loginPage=new LoginPage();
		loginPage.login(landLord);
		loginPage.verifyLoginSuccessPage();
		return this;
	}
	
	public ForgotPasswordAction navigateToForgotPasswordAction(){
		final LoginPage loginPage=new LoginPage();
		loginPage.clickForgotPasswordLink();
		return new ForgotPasswordAction();
	}
	
	public RegistrationAction navigateToRegisterNowAction(){
		final HomePage homePage=new HomePage();
		homePage.clickRegisterNowLink();
		return new RegistrationAction(landLord);
	}	
	
	public AccountOverViewAction verifyAccountOverViewAction(){
		final AccountOverViewPage accountOverViewPage=new AccountOverViewPage();
		accountOverViewPage.verifyAccountOverViewPage();
		return new AccountOverViewAction();
	}
}
