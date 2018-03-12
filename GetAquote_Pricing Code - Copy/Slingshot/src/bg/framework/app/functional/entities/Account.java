package bg.framework.app.functional.entities;

/**
 * Created by IntelliJ IDEA.
 * User: bhushanr
 * Date: 07/07/11
 * Time: 06:25
 * To change this template use File | Settings | File Templates.
 */
public class Account {
    private String number;
    private boolean valid;
    private boolean dayAndNightMeterAccount;
    private boolean shouldDisplayWarningForSMR;
    private boolean jointAccount;

    public Account(String number, boolean isValid, boolean isJointAccount, boolean isDayAndNightMeterAccount, boolean withMeterReadWarning) {
        this.number = number;
        valid = isValid;
        shouldDisplayWarningForSMR = withMeterReadWarning;
        dayAndNightMeterAccount = isDayAndNightMeterAccount;
        jointAccount = isJointAccount;
    }

    public boolean isValid() {
        return valid;
    }

    public String getNumber() {
        return number;
    }

    public boolean shouldDisplayWarningForSMR() {
        return shouldDisplayWarningForSMR;  //To change body of created methods use File | Settings | File Templates.
    }

    public boolean isDayAndNightMeterAccount() {
        return dayAndNightMeterAccount;
    }

    public boolean isJointAccount() {
        return jointAccount;
    }

}
