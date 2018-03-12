package bg.framework.app.functional.test.reFactoring;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.reFactoring.PriceFinderAZtariffAction;
import bg.framework.app.functional.entities.PriceFinder;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import static bg.framework.app.functional.entities.FunctionalCategory.*;

public class PriceFinderAZtariffTest extends TestBase {
	
	/*
	 * Verify the updated PriceFinder.XML is available. 
	 */ 
	@Test(groups = {PriceFinder, Regression, BG})
	public void verifyAZTariffPriceFinder() {
        Report.createTestLogHeader("Price Finder", "A - Z Page");
        new PriceFinderAZtariffAction()
                .navigateToAllTariff()
                .VerifyAZTariffPage();
	}

}
