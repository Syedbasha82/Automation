package bg.framework.app.functional.action.selfServe;

import bg.framework.app.functional.action.sales.GetAPriceAction;
import bg.framework.app.functional.entities.GetAPrice;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.sales.GetAPricePage;

public class SSRVSmokeAction {

	public SSRVSmokeAction verifyAndEnterGAPDetails(GetAPrice getaPrice, UserProfile userProfile) {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.fillGAPDetails(getaPrice, userProfile);
        return this;               
	}
	
}
