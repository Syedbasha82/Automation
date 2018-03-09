package bg.framework.app.functional.test.reFactoring;

import static bg.framework.app.functional.entities.FunctionalCategory.Acquisition;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import bg.framework.app.functional.action.reFactoring.FeedInTarrifAction;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.entities.UserProfile;

public class FeedInTariffTest extends TestBase {
	@Test(groups = {Acquisition,Regression})
	public void FeedInTariffJourney(){
		Report.createTestLogHeader("FeedInTariff", "Feed In Tariff Journey");
		
		new FeedInTarrifAction()
		    .navigateToFeedInTariffPage();
		 
		
		
	}
	@Test(groups = {Acquisition,Regression})
	public void FeedInTariffJourneyGas(){
		Report.createTestLogHeader("FeedInTariff", "Feed In Tariff Journey for Gas");
		UserProfile userProfile = new TestDataHelper().getUserProfile("GasAccount");
		new HomePageAction()
        .navigateToLogin()
        .loginDetails(userProfile);
		new FeedInTarrifAction()
		    .navigateToFeedInTariffPage();
		new HomePageAction()
		    .logout();
		 
		
		
	}
	@Test(groups = {Acquisition,Regression})
	public void FeedInTariffJourneyElectricity(){
		Report.createTestLogHeader("FeedInTariff", "Feed In Tariff Journey for Electricity");
		UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
		new HomePageAction()
        .navigateToLogin()
        .loginDetails(userProfile);
		new FeedInTarrifAction()
		    .navigateToFeedInTariffPage();
		new HomePageAction()
		    .logout();
		 
		
		
	}
	@Test(groups = {Acquisition,Regression})
	public void FeedInTariffJourneyDual(){
		Report.createTestLogHeader("FeedInTariff", "Feed In Tariff Journey for Dual");
		 UserProfile userProfile = new TestDataHelper().getUserProfile("DualAccount");
		new HomePageAction()
        .navigateToLogin()
        .loginDetails(userProfile);
		new FeedInTarrifAction()
		    .navigateToFeedInTariffPage();
		new HomePageAction()
		    .logout();
		 
		
		
	}
	@Test(groups = {Acquisition,Regression})
	public void FeedInTariffJourneyJI(){
		Report.createTestLogHeader("FeedInTariff", "Feed In Tariff Journey for JI");
		UserProfile userProfile = new TestDataHelper().getUserProfile("JIAccount");
		new HomePageAction()
        .navigateToLogin()
        .loginDetails(userProfile);
		new FeedInTarrifAction()
		    .navigateToFeedInTariffPage();
		new HomePageAction()
		    .logout();
		 
		
		
	}

}
