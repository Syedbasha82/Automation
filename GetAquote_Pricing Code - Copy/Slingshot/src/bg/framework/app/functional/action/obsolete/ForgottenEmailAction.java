package bg.framework.app.functional.action.obsolete;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.obsolete.ForgottenEmailPage;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 22/02/12
 * Time: 07:43
 * To change this template use File | Settings | File Templates.
 */
public class ForgottenEmailAction {

    public ForgottenEmailAction verifyForgottenEmailJourney(UserProfile userProfile) {
        new ForgottenEmailPage()
                .validateForgottenEmailAddressJourney(userProfile);
        return new ForgottenEmailAction();
    }

    public ForgottenEmailAction verifyFieldLeverErrors(UserProfile userProfile) {
        new ForgottenEmailPage()
                .validateErrorMessages(userProfile);
        return this;
    }
}
