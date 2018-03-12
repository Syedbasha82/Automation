package bg.framework.app.functional.action.obsolete;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.obsolete.ChangeEmailAddressPage;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 21/02/12
 * Time: 12:14
 * To change this template use File | Settings | File Templates.
 */
public class ChangeEmailAddressAction {
    public ChangeEmailAddressAction verifyChangeEmailAddress(UserProfile userProfile) {
        new ChangeEmailAddressPage()
                .validateChangeEmailAddressJourney(userProfile);
        return this;
    }

    public ChangeEmailAddressAction verifyFieldLeverErrors(UserProfile userProfile) {
        new ChangeEmailAddressPage()
                .validateErrorMessages(userProfile);
        return this;
    }
}
