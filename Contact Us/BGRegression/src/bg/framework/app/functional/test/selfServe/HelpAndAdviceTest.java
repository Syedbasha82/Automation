package bg.framework.app.functional.test.selfServe;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;

import static bg.framework.app.functional.entities.FunctionalCategory.HelpAndAdvice;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;

public class HelpAndAdviceTest extends TestBase {

    @SuppressWarnings("unchecked")
    @Test(groups = {HelpAndAdvice,Smoke})
    public void verifyAnonymousJourney() {
        Report.createTestLogHeader("Help And Advice", "Anonymous Journey");
        new HomePageAction()
                .navigatetoHelpAndAdvicePage()
                .verifyLinksinPage();
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {HelpAndAdvice,Smoke})
    public void verifyOAMJourney() {
        Report.createTestLogHeader("Help And Advice", "OAM Journey");
        UserProfile userProfile = new TestDataHelper().getUserProfile("ElectricityAccount");
        getCustomerDetailsToUserProfileOAM(userProfile);
        new HomePageAction()
                .navigateToLogin()
                .login(userProfile);
        new HomePageAction()
                .navigatetoHelpAndAdvicePage()
                .verifyLinksinPage()
                .getHelpandAdviceAuditType(userProfile.getUCRN());
    }

    @SuppressWarnings("unchecked")
    @Test(groups = {HelpAndAdvice})
    public void verifyAnonymousSublandingPageJourney() {
        Report.createTestLogHeader("Help And Advice", "Sublanding Page Anonymous Journey");
        new HomePageAction()
                .navigatetoHelpAndAdvicePage()
                .verifySublandingPage();
    }

}
