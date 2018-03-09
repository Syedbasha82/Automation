package bg.framework.app.functional.action.selfServe;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.selfServe.SelfRegistrationPage;

public class SelfServeRegistrationAction {

    public static SelfRegistrationPage selfRegisterPage = new SelfRegistrationPage();


    public SelfServeRegistrationAction registerUpdateYourDetails(final UserProfile selfRegisterData,
                                                                 final String acctNumber) {
        selfRegisterPage.registerUpdateYourDetails(selfRegisterData, acctNumber);
        return this;
    }

    public AccountOverviewAction goToYourAccount() {
        new SelfRegistrationPage().goToYourAccount();
        return new AccountOverviewAction();
    }
}
