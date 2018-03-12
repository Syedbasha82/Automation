package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("UserProfile")
public class UserProfile {
    private String email;
    private String password;
    private String newemail;
    private String newpassword;
    private String ucrn;
    private String firstName;
    private String lastName;
    private String Gasconsumptionvalue;
    private String Electconsumptionvalue;
    
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
    private String NectarRegistered;
    private String esGas;
    private String esEle;
    private String paymentGas;
    private String paymentEle;
    private String currentMeterGas;
    private String tariffName1;
    private String tariffName2;
    private String tariff;
    private String street;
    private String localArea;
    private String city;
    private String country;
    private String bpnumber;
    private String invoiceNumber;
    private String postCode;
    private String billAddr;
    private String siteAddr;
    private String feedbackoption;
    private String feedbacktext;
    private String companyName;
    private String annualSpend;
    private String registerationNumber;
    private String query;
    private String UserType;
    private String viewname;
    private String billingAddr;
    private String Editview;
    private String mprn;   
    private String amountToPay;
    private String cardtype;
    private String cardHolderName;
    private String cardNumber;
    private String cardExpiryMonth;
    private String cardExpiryYear;
    private String cardCVV;
    private String pbstatus;
    private String businessname;
    private String noofsites;
    private String buildingname;
    private String consumptionunit;
    private String mpan;

    public String getpbstatus() {
        return pbstatus;
    }
    public String getNectarNumber() {
        return nectarNumber;
    }
    public String getmpan() {
        return mpan;
    }
    public String getviewname() {
        return viewname;
    }
    public String getBillingAddr() {
        return billingAddr;
    }
    public String getEditview() {
        return Editview;
    }
    public String getbusinessname() {
        return businessname;
    }
    public String getnoofsites() {
        return noofsites;
    }
    public String getbuildingname() {
        return buildingname;
    }
    public String getconsumptionunit() {
        return   consumptionunit;
    }
    public void setconsumptionunite(String  consumptionunit)    
    {
    	this.consumptionunit= consumptionunit;	
    }
    
    public void setbuildingname(String buildingname)    
    {
    	this.buildingname=buildingname;	
    }
      
    public void setnoofsites(String viewname)    
    {
    	this.noofsites=viewname;	
    }
   public void setbusinessname(String viewname)
    
    {
    	this.businessname=viewname;	
    }
    
    public void setNectarValue(String nectarValue)
    {
    	this.nectarValue=nectarValue;	
    }
    public void setviewname(String viewname)
    
    {
    	this.viewname=viewname;	
    }
public void setEditview(String Editview)
    
    {
    	this.Editview=Editview;	
    }
 public void setBillingAddr(String billingAddr)
    
    {
    	this.billingAddr=billingAddr;	
    }

    public String getGasconsumptionvalue() {
        return Gasconsumptionvalue;
    }
    
    public String getElectconsumptionvalue() {
        return Electconsumptionvalue;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getNewEmail() {
        return newemail;
    }
    public String getUserType() {
        return UserType;
    }
    public String getNewPassword() {
        return newpassword;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public void setUserType(String UserType) {
        this.UserType = UserType;
    }
    public void Setpbstatus(String pbstatus) {
        this.pbstatus = pbstatus;
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

    public String getNectarRegistered() {
    	return NectarRegistered;
    }
    
    public String getEsGas() {
    	return esGas;
    }
    
    public String getEsEle() {
    	return esEle;
    }
    
    public String getPaymentGas() {
    	return paymentGas;
    }
    
    public String getPaymentEle() {
    	return paymentEle;
    }
    
    public String getCurrentMeterGas() {
    	return currentMeterGas;
    }
    
    public String gettariffName1() {
    	return tariffName1;
    }
    
    public String gettariffName2() {
    	return tariffName2;
    }
    public String getTariff() {
        return tariff;
    }
    public String getBpnumber(){
    	return bpnumber;
    }
    public String getInvoiceNumber(){
    	
    	return invoiceNumber;
    }
    public String getPostCode(){
    	
    	return postCode;
    }
    public String getStreet() {
        return street;
    }
    public String getLocalArea() {
        return localArea;
    }
    public String getCity() {
        return city;
    }
    public String getCountry() {
        return country;
    }
    
    public UserProfile() {
    }

    public UserProfile(String email, String password,String newemail,String  newpassword, String ucrn, String Electconsumptionvalue, String Gasconsumptionvalue, String firstName,String viewname,String billingAddr,String Editview,
                       String lastName, String title, String securityQuestion,String UserType,
                       String securityAnswer, String phoneNumber, String phoneType,
                       String mobileNumber, String homeNumber, String workNumber,
                       String acceptTerms, String nectarValue, String nectarNumber,
                       String elecAccount, String gasAccount, String bgsAccount, String accNumber,String pbstatus,
                       String addr,String NectarRegistered, String esGas, String esEle,String paymentGas,String businessname,
                       String paymentEle,String currentMeterGas, String tariffName1, String tariffName2,String tariff,String street,String localArea,String city,String country,String bpnumber,String invoiceNumber,String postCode,String billAddr,String siteAddr, String mprn) {
        this.email = email;
        this.Gasconsumptionvalue = Gasconsumptionvalue;
        this.Electconsumptionvalue = Electconsumptionvalue;
        this.password = password;
        this.pbstatus=pbstatus;
        this.billingAddr=billingAddr;
        this.viewname=viewname;
        this.businessname=businessname;
        this.Editview=Editview;
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
        this.NectarRegistered = NectarRegistered;
        this.esGas = esGas;
        this.esEle = esEle;
        this.paymentGas = paymentGas;
        this.paymentEle = paymentEle;
        this.currentMeterGas = currentMeterGas;
        this.tariffName1 = tariffName1;
        this.tariffName2 = tariffName2;
        this.tariff = tariff;
        this.newemail = newemail;
        this.newpassword = newpassword;
        this.street = street;
        this.localArea = localArea;
        this.city = city;
        this.country = country;
        this.bpnumber=bpnumber;
        this.invoiceNumber = invoiceNumber;
        this.postCode = postCode;
        this.billAddr = billAddr;
        this.siteAddr = siteAddr;
        this.UserType = UserType;
        this.mprn = mprn;
    }
	public String getBillAddr() {
		return billAddr;
	}
	public void setBillAddr(String billAddr) {
		this.billAddr = billAddr;
	}
	public String getSiteAddr() {
		return siteAddr;
	}
	public void setSiteAddr(String siteAddr) {
		this.siteAddr = siteAddr;
	}
	public void setBpnumber(String bpnumber){
		this.bpnumber=bpnumber;
	}
	public void setFeedbackoption(String feedbackoption) {
		this.feedbackoption = feedbackoption;
	}
	public String getFeedbackoption() {
		return feedbackoption;
	}
	public void setFeedbacktext(String feedbacktext) {
		this.feedbacktext = feedbacktext;
	}
	public String getFeedbacktext() {
		return feedbacktext;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAnnualSpend() {
		return annualSpend;
	}
	public void setAnnualSpend(String annualSpend) {
		this.annualSpend = annualSpend;
	}
	public String getRegisterationNumber() {
		return registerationNumber;
	}
	public void setRegisterationNumber(String registerationNumber) {
		this.registerationNumber = registerationNumber;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getMprn() {
		return mprn;
	}
	public void setMprn(String Mprn) {
		this.mprn = Mprn;
	}
	public void setAmountToPay(String amountToPay) {
		this.amountToPay = amountToPay;
	}
	public String getAmountToPay() {
		return amountToPay;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardExpiryMonth(String cardExpiryMonth) {
		this.cardExpiryMonth = cardExpiryMonth;
	}
	public String getCardExpiryMonth() {
		return cardExpiryMonth;
	}
	public void setCardExpiryYear(String cardExpiryYear) {
		this.cardExpiryYear = cardExpiryYear;
	}
	public String getCardExpiryYear() {
		return cardExpiryYear;
	}
	public void setCardCVV(String cardCVV) {
		this.cardCVV = cardCVV;
	}
	public String getCardCVV() {
		return cardCVV;
	}
}
