package bg.framework.app.functional.entities;


import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Registration")
public class RegistrationProfile {

    private String accountNumber;
    private String firstName;
    private String lastName;
    private String title;
    private String password;
    private String confPassword;
    private String email;
    private String url;
    private String inurl;
    private String searchCriteria;
    private String searchText;
    private String searchTextLess12;
    private String searchTextEqual12;
    private String fromDate;
    private String toDate;


    public RegistrationProfile() {
    }

    public RegistrationProfile(String accountNumber, String firstName, String lastName, String title, String email,
                               String password,
                               String confPassword, String inurl, String url, String searchCriteria, String searchText, String searchTextLess12, String searchTextEqual12, String fromDate, String toDate) {
        this.accountNumber = accountNumber;
        this.email = email;
        this.password = password;
        this.confPassword = confPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.searchText = searchText;
        this.searchTextLess12 = searchTextLess12;
        this.searchTextEqual12 = searchTextEqual12;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.inurl = inurl;
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfPassword() {
        return confPassword;
    }

    public String getAccountNumber() {
        return accountNumber;
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

    public String getUrl() {
        return url;
    }

    public String getInValidUrl() {
        return inurl;
    }

    public String getSearchCriteria() {
        return searchCriteria;
    }

    public String getSearchText() {
        return searchText;
    }

    public String getSearchTextLess12() {
        return searchTextLess12;
    }

    public String getSearchTextEqual12() {
        return searchTextEqual12;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setConfPassword(String confpassword) {
        this.confPassword = confpassword;
    }
}
