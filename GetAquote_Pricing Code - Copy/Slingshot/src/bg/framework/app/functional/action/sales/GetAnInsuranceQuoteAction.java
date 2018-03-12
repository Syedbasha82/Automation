package bg.framework.app.functional.action.sales;

import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.entities.InsuranceQuote;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.sales.GetAnInsuranceQuotePage;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 28/02/12
 * Time: 07:33
 * To change this template use File | Settings | File Templates.
 */
public class GetAnInsuranceQuoteAction {
    public void getAnInsuranceQuote(InsuranceQuote iq) {
        GetAnInsuranceQuotePage getAnInsuranceQuotePage = new GetAnInsuranceQuotePage();
        getAnInsuranceQuotePage.enterQuoteDetails(iq);
    }
    public void getAnInsuranceQuoteWithDifferentBillingAddress(InsuranceQuote iq) {
        GetAnInsuranceQuotePage getAnInsuranceQuotePage = new GetAnInsuranceQuotePage();
        getAnInsuranceQuotePage.enterQuoteDetailsDifferentBillingAddress(iq);
    }
    public AccountOverviewAction getAnInsuranceQuote(InsuranceQuote iq, UserProfile userProfile) {
        GetAnInsuranceQuotePage getAnInsuranceQuotePage = new GetAnInsuranceQuotePage();
        getAnInsuranceQuotePage.enterQuoteDetails(iq, userProfile);
        return new AccountOverviewAction(userProfile);
    }
    public void validateErrorMessages(InsuranceQuote iq) {
        GetAnInsuranceQuotePage getAnInsuranceQuotePage = new GetAnInsuranceQuotePage();
        getAnInsuranceQuotePage.validateErrorMessages(iq);
    }
}
