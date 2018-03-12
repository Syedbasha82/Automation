package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.ChangeEmailPage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.SiebelDataBase;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 14/03/12
 * Time: 10:17
 * To change this template use File | Settings | File Templates.
 */
public class ChangeEmailAction {

    public ChangeEmailAction changeEmailAddress(UserProfile userprofile) {
        ChangeEmailPage changeEmailpage = new ChangeEmailPage();
        changeEmailpage.validateChangeEmailAddressJourney(userprofile);
        return this;
    }

    public ChangeEmailAction validateErrorMessages(UserProfile userprofile) {
        ChangeEmailPage changeEmailpage = new ChangeEmailPage();
        changeEmailpage.validateErrorMessages(userprofile);
        return this;
    }

    public ChangeEmailAction changeInactive(UserProfile userprofile) {
        SiebelDataBase siebelDB = new SiebelDataBase();
        siebelDB.setAccountStatus(userprofile.getAccNumber(), -11);
        return this;
    }

    public ChangeEmailAction changelessInactive(UserProfile userprofile) {
        SiebelDataBase siebelDB = new SiebelDataBase();
        siebelDB.setAccountStatus(userprofile.getAccNumber(), -3);
        return this;
    }

    public ChangeEmailAction changeAccountlock(UserProfile userprofile) {
        OnlineDBConnector online = new OnlineDBConnector();
        online.dbAccountlock(userprofile.getUCRN());
        return this;
    }

    public ChangeEmailAction changeAccountUnlock(UserProfile userprofile) {
        OnlineDBConnector online = new OnlineDBConnector();
        online.dbAccountunlock(userprofile.getUCRN());
        return this;
    }

    public ChangeEmailAction changeWTPEmailAddress(UserProfile userprofile) {
        ChangeEmailPage changeEmailpage = new ChangeEmailPage();
        changeEmailpage.verifyWTPAccountError(userprofile);
        return this;
    }

    public ChangeEmailAction changeLockedAccEmailAddress(UserProfile userprofile) {
        ChangeEmailPage changeEmailpage = new ChangeEmailPage();
        changeEmailpage.verifyLockedAccountError(userprofile);
        return this;
    }
    public ChangeEmailAction changePrePaymentEmailAddress(UserProfile userprofile) {
        ChangeEmailPage changeEmailpage = new ChangeEmailPage();
        changeEmailpage.verifyPrePaymentAccountError(userprofile);
        return this;
    }
    public ChangeEmailAction changeSSOEmailAddress(UserProfile userprofile) {
        ChangeEmailPage changeEmailpage = new ChangeEmailPage();
        changeEmailpage.verifySSOAccountError(userprofile);
        return this;
    }

    public ChangeEmailAction backbuttonchangeEmail() {
        ChangeEmailPage changeEmailpage = new ChangeEmailPage();
        changeEmailpage.verifyBrowserBackbutton();
        return this;
    }
}
