package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("MakeAPaymentProfile")
public class MakeAPaymentProfile {
	private String email;
    private String password;
    private String ucrn;
    private String firstName;
    private String lastName;
    private String title;
    private String securityQuestion;
    private String securityAnswer;
    private String phoneNumber;
    private String phoneType;
    private String mobileNumber;
    private String homeNumber;
    private String nectarNumber;
    private String workNumber;
    private String acceptTerms;
    private String nectarValue;
    private String elecAccount;
    private String gasAccount;
    private String bgsAccount;
    private String accNumber;
    private String addr;
    private String cardType;
    private String cardName;
    private String cardNumber;
    private String cardStartMonth;
    private String cardStartYear;
    private String cardEndMonth;
    private String cardEndYear;
    private String cardIssueNumber;
    private String cardCVV;
    private String cardSecurityNumber;
    
    public String getNectarNumber() {
        return nectarNumber;
    }
    public void setNectarValue(String nectarValue)
    {
    	this.nectarValue=nectarValue;	
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUCRN() {
        return ucrn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String number) {
        System.out.println(number);
        if (number.length() == 14) {
            number = number.replace("+440", "0");
            this.phoneNumber = number;
            System.out.println(number);
        } else {
            this.phoneNumber = "01234567890";
        }
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String type) {
        if (type.equalsIgnoreCase("") || type.isEmpty()) {
            this.phoneType = "Home";
        } else {
            System.out.println(type);
            type = type.substring(0, type.length() - 10);
            System.out.println(type);
            this.phoneType = type;
        }
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public String getAcceptTerms() {
        return acceptTerms;
    }

    public String getNectarValue() {
        if (nectarValue == null || nectarValue.trim().equals(""))

        {
            nectarValue = "4";
        }
        return nectarValue;
    }

    public String getaddr() {
        return addr;
    }

    public void setPostCode(String postCode) {
        this.addr = postCode;
    }

    public String getGasAccount() {
        return gasAccount;
    }

    public String getElecAccount() {
        return elecAccount;
    }

    public String getBgsAccount() {
        return bgsAccount;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }
    
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
    
    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardType = cardName;
    }
    
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardType = cardNumber;
    }
    
    public String getCardStartMonth() {
        return cardStartMonth;
    }

    public void setCardStartMonth(String cardStartMonth) {
    	 this.cardStartMonth = cardStartMonth;
    }
    
    public String getCardStartYear() {
        return cardStartYear;
    }

    public void setCardStartYear(String cardStartYear) {
    	 this.cardStartYear = cardStartYear;
    }
    
    public String getCardEndMonth() {
        return cardEndMonth;
    }

    public void setCardEndMonth(String cardEndMonth) {
    	 this.cardEndMonth = cardEndMonth;
    }
    
    public String getCardEndYear() {
        return cardEndYear;
    }

    public void setCardEndYear(String cardEndYear) {
    	 this.cardEndYear = cardEndYear;
    }
    
    public String getCardIssueNumber() {
        return cardIssueNumber;
    }

    public void setCardIssueNumber(String cardIssueNumber) {
    	 this.cardIssueNumber = cardIssueNumber;
    }
    
    public String getcardCVV() {
        return cardCVV;
    }

    public void setcardCVV(String cardCVV) {
    	 this.cardCVV = cardCVV;
    }
    
    public String getcardSecurityNumber() {
        return cardSecurityNumber;
    }

    public void setcardSecurityNumber(String cardSecurityNumber) {
    	 this.cardSecurityNumber = cardSecurityNumber;
    }
    
    public MakeAPaymentProfile() {
    }

    public MakeAPaymentProfile(String email, String password, String ucrn, String firstName,
                       String lastName, String title, String securityQuestion,
                       String securityAnswer, String phoneNumber, String phoneType,
                       String mobileNumber, String homeNumber, String workNumber,
                       String acceptTerms, String nectarValue, String nectarNumber,
                       String elecAccount, String gasAccount, String bgsAccount, String accNumber,
                       String addr,String cardType,String cardName,String cardNumber,
                       String cardStartMonth,String cardStartYear,String cardEndMonth,String cardEndYear,
                       String cardIssueNumber,String cardCVV, String cardSecurityNumber) {
        this.email = email;
        this.password = password;
        this.ucrn = ucrn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
        this.phoneNumber = phoneNumber;
        this.phoneType = phoneType;
        this.mobileNumber = mobileNumber;
        this.homeNumber = homeNumber;
        this.workNumber = workNumber;
        this.acceptTerms = acceptTerms;
        this.nectarValue = nectarValue;
        this.elecAccount = elecAccount;
        this.gasAccount = gasAccount;
        this.bgsAccount = bgsAccount;
        this.accNumber = accNumber;
        this.addr = addr;
        this.cardType = cardType;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.cardStartMonth = cardStartMonth;
        this.cardStartYear = cardStartYear;
        this.cardEndMonth = cardEndMonth;
        this.cardEndYear = cardEndYear;
        this.cardIssueNumber = cardIssueNumber;
        this.cardCVV = cardCVV;
        this.cardSecurityNumber = cardSecurityNumber;
    }
}

