package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.SETariffInformationPage;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.Slinshot.CompareTariff;

public class SETariffInformationAction {
	
	public SETariffInformationAction navigateToSETariffInformationPage () {
		SETariffInformationPage SETariffInformationPage=new SETariffInformationPage();
		SETariffInformationPage.navigateToSETariffInformationPage();
		return this;	
		}
	public SETariffInformationAction enterPostCodeNew (CompareTariff CompareTariff) {
		SETariffInformationPage SETariffInformationPage=new SETariffInformationPage();
		SETariffInformationPage.enterPostCodeNew(CompareTariff);
		return this;	
		}
	public SETariffInformationAction SelectTariff(CompareTariff CompareTariff) {
		SETariffInformationPage SETariffInformationPage=new SETariffInformationPage();
		SETariffInformationPage.SelectTariff(CompareTariff);
		return this;	
		}
	public SETariffInformationAction SelectPaymentType(CompareTariff CompareTariff) {
		SETariffInformationPage SETariffInformationPage=new SETariffInformationPage();
		SETariffInformationPage.SelectPaymentType(CompareTariff);
		return this;	
		}
	public SETariffInformationAction VerifyFuelStatus(CompareTariff CompareTariff) {
		SETariffInformationPage SETariffInformationPage=new SETariffInformationPage();
		SETariffInformationPage.VerifyFuelStatus(CompareTariff);
		return this;	
		}

}
