package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;


@XStreamAlias("Acquisition")
public class AcquisitionData {

    private String firstName;
    private String lastName;
    private String title;
    private String email;
    private String password;
    private String phone;
    private String accno;
    private String phonetype;
    private String secQues;
    private String secAns;
    private String ucrn;
    private String postcode;


    public AcquisitionData() {
    }

    public AcquisitionData(String ucrn, String firstName, String lastName, String title, String email,
                           String password,
                           String phone, String accno, String phonetype, String secQues, String secAns, String postcode) {
        this.ucrn = ucrn;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.phonetype = phonetype;
        this.secQues = secQues;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.secAns = secAns;
        this.accno = accno;
        this.postcode = postcode;

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getPhonetype() {
        return phonetype;
    }

    public String getAccno() {
        return accno;
    }

    public String getSecQues() {
        return secQues;
    }

    public String getSecAns() {
        return secAns;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getTitle() {
        return title;
    }

    public String getUcrn() {
        return ucrn;
    }

    public String getPostcode() {
        return postcode;
    }


}
