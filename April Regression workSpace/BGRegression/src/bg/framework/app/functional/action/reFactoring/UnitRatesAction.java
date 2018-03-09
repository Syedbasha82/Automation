package bg.framework.app.functional.action.reFactoring;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.UnitRatesPage;




public class UnitRatesAction {
	public UnitRatesAction verifyUnitRates(UserProfile userProfile, String fuel) {
		UnitRatesPage verifyUnitRates=new UnitRatesPage();
		verifyUnitRates.verifyUnitRates(userProfile, fuel);
		return new UnitRatesAction();

	}
	public UnitRatesAction navigateToSeeUnitLink(String energy) {
		UnitRatesPage verifyUnitRates=new UnitRatesPage();
		verifyUnitRates.navigateToSeeUnitLink(energy);
		return new UnitRatesAction();
	}

	public void logout() {
		UnitRatesPage unitratespage = new UnitRatesPage();
		unitratespage.logout();

	}
	public UnitRatesAction navigatetoAccountoverview() {
		UnitRatesPage verifyUnitRates=new UnitRatesPage();
		verifyUnitRates.navigatetoAccountoverview();
		return new UnitRatesAction();

	}

}
