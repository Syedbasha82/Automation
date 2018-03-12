package bg.framework.app.functional.entities;

public enum CreditCards {

    VISA1112("Visa credit card", "Mr Visa", "4012001037141112", "February", "2008", "September", "2012", "754", ""),
    MAESTRO6780("Maestro", "Mr Maestro", "6007930123456780", "February", "2008", "September", "2012", "551", "dog33cat"),
    MAESTRO6780_MISSING_NAME("Maestro", "", "6007930123456780", "February", "2008", "September", "2012", "551", "dog33cat");

    public String type;
    public String holderName;
    public String number;
    public String startMonth;
    public String startYear;
    public String expiryMonth;
    public String expiryYear;
    public String cvvCode;
    public String secureCode;

    CreditCards(String type, String holderName, String number, String startMonth, String startYear, String expiryMonth, String expiryYear, String cvvCode, String secureCode) {
        this.type = type;
        this.holderName = holderName;
        this.number = number;
        this.startMonth = startMonth;
        this.startYear = startYear;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.cvvCode = cvvCode;
        this.secureCode = secureCode;

    }

    public String getType() {
        return type;
    }

    public String getHolderName() {
        return holderName;
    }

    public String getNumber() {
        return number;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public String getStartYear() {
        return startYear;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public String getCvvCode() {
        return cvvCode;
    }

    public String getSecureCode() {
        return secureCode;
    }
}