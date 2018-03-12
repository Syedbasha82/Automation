package bg.framework.app.functional.action.reFactoring;


import  bg.framework.app.functional.page.reFactoring.FeedInTariffPage;
import bg.framework.app.functional.page.sales.KitchenApplianceCoverPage;

public class FeedInTarrifAction {
	
	public FeedInTarrifAction navigateToFeedInTariffPage() {
		FeedInTariffPage  feedInTariffPage = new  FeedInTariffPage();
		feedInTariffPage.navigateToFeedInTariff();
			return new  FeedInTarrifAction();
		}
	
	
}
