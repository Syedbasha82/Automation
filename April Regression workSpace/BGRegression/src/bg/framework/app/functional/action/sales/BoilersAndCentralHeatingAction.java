package bg.framework.app.functional.action.sales;

import bg.framework.app.functional.page.sales.BoilersAndCentralHeatingPage;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 12/03/12
 * Time: 08:47
 * To change this template use File | Settings | File Templates.
 */
public class BoilersAndCentralHeatingAction {
    public GetAnInsuranceQuoteAction navigateToGetAnInsuranceQuote() {
        new BoilersAndCentralHeatingPage().navigateToGetAnInsuranceQuote();
        return new GetAnInsuranceQuoteAction();
    }
}
