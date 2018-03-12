package bg.framework.app.functional.entities.builders;

import bg.framework.app.functional.entities.Account;

public class AccountBuilder {

    private String accountNumber;
    private boolean validForSubmittingMeterRead = true;
    private boolean jointAccount;
    private boolean dayAndNightMeterAccount;
    private boolean withMeterReadWarning;

    public AccountBuilder withAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public AccountBuilder invalidForSubmittingMeterRead() {
        this.validForSubmittingMeterRead = false;
        return this;
    }

    public AccountBuilder jointAccount() {
        this.jointAccount = true;
        return this;
    }

    public AccountBuilder dayAndNightMeterAccount() {
        this.dayAndNightMeterAccount = true;
        return this;
    }

    public Account build() {
        return new Account(accountNumber, validForSubmittingMeterRead, jointAccount, dayAndNightMeterAccount, withMeterReadWarning);
    }

    public AccountBuilder withMeterReadWarning() {
        this.withMeterReadWarning = true;
        return this;
    }
}
