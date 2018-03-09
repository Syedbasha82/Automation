package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.action.sales.OurTariffAction;
import bg.framework.app.functional.page.reFactoring.PriceFinderAZtariffPage;

public class PriceFinderAZtariffAction {

	public PriceFinderAZtariffAction navigateToAllTariff() {
		PriceFinderAZtariffPage OurTariff = new PriceFinderAZtariffPage();
		OurTariff.navigateToAllTariff();
        return new PriceFinderAZtariffAction();
	}

	public PriceFinderAZtariffAction VerifyAZTariffPage() {
		PriceFinderAZtariffPage Tariff = new PriceFinderAZtariffPage();
		Tariff.VerifyAZTariffPage();
		return new PriceFinderAZtariffAction();
		
	}

}
