package bg.framework.app.functional.action.selfServe;

import bg.framework.app.functional.page.selfServe.HelpAndAdvicePage;
import bg.framework.app.functional.util.OnlineDBConnector;

public class HelpAndAdviceAction {

    public HelpAndAdviceAction() {

    }

    public HelpAndAdviceAction verifyLinksinPage() {
        HelpAndAdvicePage helpAndAdvicePage = new HelpAndAdvicePage();
        helpAndAdvicePage.verifyLinksHelpAndAdvicePage();
        helpAndAdvicePage.searchHelpandAdvice();
        helpAndAdvicePage.verifySubLandingPageLinks();
        helpAndAdvicePage.verifyLinksHeaderFooter();
        return this;
    }

    public HelpAndAdviceAction verifySublandingPage() {
        HelpAndAdvicePage helpAndAdvicePage = new HelpAndAdvicePage();
        helpAndAdvicePage.navigatetoSublandingPage();
        helpAndAdvicePage.verifySublandingPage();
        helpAndAdvicePage.verifyLinksHeaderFooter();
        return this;
    }

    public HelpAndAdviceAction getHelpandAdviceAuditType(String LeadType) {
        OnlineDBConnector onlineDBConn = new OnlineDBConnector();
        onlineDBConn.getHelpandAdviceAuditType(LeadType);
        return this;
    }
}
