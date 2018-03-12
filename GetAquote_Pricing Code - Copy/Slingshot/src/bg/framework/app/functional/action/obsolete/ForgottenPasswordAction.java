package bg.framework.app.functional.action.obsolete;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.obsolete.ForgottenPasswordPage;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 22/02/12
 * Time: 07:43
 * To change this template use File | Settings | File Templates.
 */
public class ForgottenPasswordAction {

    public ForgottenPasswordAction verifyForgottenPasswordJourney(UserProfile userProfile) {
        new ForgottenPasswordPage()
                .validateForgottenPasswordJourney(userProfile);
        return new ForgottenPasswordAction();
    }

    public ForgottenPasswordAction verifyFieldLeverErrors(UserProfile userProfile) {
        new ForgottenPasswordPage()
                .validateErrorMessages(userProfile);
        return this;
    }
}
