package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.SECompareEnergyTariffPage;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.Slinshot.CompareTariff;

public class SECompareEnergyTariffAction {

	public SECompareEnergyTariffAction navigateToSEcompareTariffPage () {
		SECompareEnergyTariffPage SECompareEnergyTariffPage=new SECompareEnergyTariffPage();
		SECompareEnergyTariffPage.navigateToSEcompareTariffPage();
		return this;	
		}
	
	public SECompareEnergyTariffAction enterPostCodeNew(CompareTariff CompareTariff) {
		SECompareEnergyTariffPage SECompareEnergyTariffPage=new SECompareEnergyTariffPage();
		SECompareEnergyTariffPage.enterPostCodeNew(CompareTariff);
		return this;	
		}
	
	public SECompareEnergyTariffAction SelectPaymentType(CompareTariff CompareTariff) {
		SECompareEnergyTariffPage SECompareEnergyTariffPage=new SECompareEnergyTariffPage();
		SECompareEnergyTariffPage.SelectPaymentType(CompareTariff);
		return this;	
		}
	
	public SECompareEnergyTariffAction VerifyFuelStatus(CompareTariff CompareTariff) {
		SECompareEnergyTariffPage SECompareEnergyTariffPage=new SECompareEnergyTariffPage();
		SECompareEnergyTariffPage.VerifyFuelStatus(CompareTariff);
		return this;	
		}
	
	
}
