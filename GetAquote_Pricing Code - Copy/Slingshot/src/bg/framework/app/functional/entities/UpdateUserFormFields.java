package bg.framework.app.functional.entities;

public class UpdateUserFormFields {

    private String email;
    private String confirmEmail;
    private String password;
    private String confirmPassword;
    private String mobileNumber;
    private String homeNumber;
    private String workNumber;
    private String gasMeterReading;
    private String electricityMeterReading;

    public UpdateUserFormFields(String email, String confirmEmail,
                                String password, String confirmPassword, String mobileNumber,
                                String workNumber, String homeNumber) {
        this.email = email;
        this.confirmEmail = confirmEmail;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.mobileNumber = mobileNumber;
        this.homeNumber = homeNumber;
        this.workNumber = workNumber;
    }

    public UpdateUserFormFields(String gasReading, String electricityReading) {
        this.gasMeterReading = gasReading;
        this.electricityMeterReading = electricityReading;
    }

    public String getEmail() {
        return email;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public String getGasReading() {
        return gasMeterReading;
    }

    public String getElectricityReading() {
        return gasMeterReading;
    }
}
