package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import static org.apache.commons.lang.StringUtils.isNotEmpty;
import static org.apache.commons.lang.StringUtils.trim;

@XStreamAlias("TestData")
public class TestData {

    private String firstName;
    private String lastName;
    private String title;
    private String email;
    private String password;
    private String mobileNumber;
    private String homeNumber;
    private String workNumber;
    private String ucrn;
    private String newEmail;
    private String confirmEmail;
    private String newPassword;
    private String confirmPassword;
    private String newMobileNumber;
    private String newHomeNumber;
    private String newWorkNumber;

    public TestData() {
    }

    public TestData(String ucrn, String firstName, String lastName, String title, String email,
                    String password,
                    String mobileNumber, String homeNumber, String workNumber,
                    String newEmail, String confirmEmail, String newPassword, String confirmPassword,
                    String newMobileNumber, String newHomeNumber, String newWorkNumber) {
        this.ucrn = ucrn;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.homeNumber = homeNumber;
        this.workNumber = workNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.newEmail = newEmail;
        this.confirmEmail = confirmEmail;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
        this.newMobileNumber = newMobileNumber;
        this.newHomeNumber = newHomeNumber;
        this.newWorkNumber = newWorkNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
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

    public String getNewEmail() {
        return newEmail;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getNewMobileNumber() {
        return newMobileNumber;
    }

    public String getNewHomeNumber() {
        return newHomeNumber;
    }

    public String getNewWorkNumber() {
        return newWorkNumber;
    }

    public String getUcrn() {
        return ucrn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTitle() {
        return title;
    }

    public void updateWith(TestData td) {
        String oldEmail = td.email;
        String oldPassword = td.password;
        String oldMobile = td.mobileNumber;
        String oldHome = td.homeNumber;
        String oldWork = td.workNumber;
        if (isNotEmpty(td.getEmail())) {
            this.email = trim(td.getNewEmail());
        }
        if (isNotEmpty(td.getPassword())) {
            this.password = td.getNewPassword();
        }
        if (isNotEmpty(td.getMobileNumber())) {
            this.mobileNumber = td.getNewMobileNumber();
        }
        if (isNotEmpty(td.getWorkNumber())) {
            this.workNumber = td.getNewWorkNumber();
        }
        if (isNotEmpty(td.getHomeNumber())) {
            this.homeNumber = td.getNewHomeNumber();
        }
        this.newEmail = oldEmail;
        this.confirmEmail = oldEmail;
        this.newPassword = oldPassword;
        this.confirmPassword = oldPassword;
        this.newWorkNumber = oldWork;
        this.newMobileNumber = oldMobile;
        this.newHomeNumber = oldHome;
    }
}
