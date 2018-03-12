package bg.framework.app.functional.entities.builders;

import bg.framework.app.functional.entities.UpdateUserFormFields;

public class UpdateUserFormFieldsBuilder {

    private String email;
    private String confirmEmail;
    private String password;
    private String confirmPassword;
    private String mobileNumber;
    private String homeNumber;
    private String workNumber;
    private String gasMeterReading;
    private String electricityMeterReading;

    public UpdateUserFormFieldsBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UpdateUserFormFieldsBuilder withConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
        return this;
    }

    public UpdateUserFormFieldsBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UpdateUserFormFieldsBuilder withConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public UpdateUserFormFieldsBuilder withMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }

    public UpdateUserFormFieldsBuilder withHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
        return this;
    }

    public UpdateUserFormFieldsBuilder withWorkNumber(String workNumber) {
        this.workNumber = workNumber;
        return this;
    }

    public UpdateUserFormFieldsBuilder withGasMeterReading(String gasMeterReading) {
        this.gasMeterReading = gasMeterReading;
        return this;
    }

    public UpdateUserFormFieldsBuilder withElectricityMeterReading(String electricityMeterReading) {
        this.electricityMeterReading = electricityMeterReading;
        return this;
    }

    public UpdateUserFormFields build() {
        return new UpdateUserFormFields(email, confirmEmail, password, confirmPassword, mobileNumber, workNumber, homeNumber);
    }
}
