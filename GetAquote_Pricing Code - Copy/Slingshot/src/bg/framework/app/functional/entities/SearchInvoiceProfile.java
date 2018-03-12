package bg.framework.app.functional.entities;


import com.thoughtworks.xstream.annotations.XStreamAlias;


@XStreamAlias("Invoice")
public class SearchInvoiceProfile {


    private String searchCriteria;
    private String searchText;
    private String fromDate;
    private String toDate;
    private String password;
    private String email;


    public SearchInvoiceProfile() {
    }

    public SearchInvoiceProfile(String searchCriteria, String searchText, String fromDate, String toDate, String email,
                                String password) {
        this.searchCriteria = searchCriteria;
        this.email = email;
        this.password = password;
        this.searchText = searchText;
        this.fromDate = fromDate;
        this.toDate = toDate;

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getSearchCriteria() {
        return searchCriteria;
    }

    public String getSearchText() {
        return searchText;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }


}
