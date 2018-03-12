package bg.framework.app.functional.entities;


import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("SMRAccountDetails")
public class SMRAccountDetails {

    private String address;
    private String accountType;
    private String lastMeterRead;
    private String afterSubmitMeterRead;
    private String meterSerialNumber;
    private String actualReadOn;
    private String lastMeterReadDay;
    private String lastMeterReadNight;
    private String previousBalance;
    private String lastMeterReadElectricity;
    private String lastMeterReadGas;
    private String meterSerialNumberElectricity;
    private String meterSerialNumberGas;
    private String auditDetails;
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String accountNumber;
    private String password;
    private String mpan;
    private String mpan1;
    private String mprn;
    private String mprn1;
    private String feedbackoption;
    private String feedbacktext;
    private String billNumber;
    private String siteAddress;
    private String sitePostcode;
    private String bpnumber;
    private String SupplyNumber;
    private String billAddr;
    private String siteAddr;
    

    public SMRAccountDetails() {
    }

    public String getAddress() {
        return address;
    } 
    public String getAccountType() {
        return accountType;
    }

    public String getLastMeterRead() {
        return lastMeterRead;
    }

    public String getAfterSubmitMeterRead() {
        return afterSubmitMeterRead;
    }

    public String getMeterSerialNumber() {
        return meterSerialNumber;
    }
    

    public String getActualReadOn() {
        return actualReadOn;
    }

    public String getLastMeterReadDay() {
        return lastMeterReadDay;
    }

    public String getLastMeterReadNight() {
        return lastMeterReadNight;
    }

    public String getPreviousBalance() {
        return previousBalance;
    }

    public String getLastMeterReadElectricity() {
        return lastMeterReadElectricity;
    }

    public String getLastMeterReadGas() {
        return lastMeterReadGas;
    }

    public String getMeterSerialNumberElectricity() {
        return meterSerialNumberElectricity;
    }

    public String getMeterSerialNumberGas() {
        return meterSerialNumberGas;
    }

    public String getAuditDetails() {
        return auditDetails;
    }

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getMpan() {
		return mpan;
	}
	
	public void setMpan(String mpan) {
		this.mpan = mpan;
	}
	
	public String getMprn() {
		return mprn;
	}

	public void setlastMeterRead(String lastMeterRead) {
		this.lastMeterRead = lastMeterRead;
	}
	public void setafterSubmitMeterRead(String afterSubmitMeterRead) {
		this.afterSubmitMeterRead = afterSubmitMeterRead;
	}
    public String getfeedbackoption(){
    	return feedbackoption;
    }
    public String getFeedbacktext(){
    	return feedbacktext;
    }

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
        public String getMprn1() 
        {
		return mprn1;
	}
	public void setsitePostcode(String sitePostcode) {
		this.sitePostcode = sitePostcode;
	}
	public void setbpnumber(String bpnumber) {
		this.bpnumber = bpnumber;
	}
	public void setSupplyNumber(String SupplyNumber) {
		this.SupplyNumber = SupplyNumber;
	}
	public void setsiteAdress(String siteAddress) {
		this.siteAddress = siteAddress;
	}
        public String getMpan1()
	{
		return mpan1;
	}
        public void setMpan1(String mpan1)
        {
		this.mpan1= mpan1;
	}
        public String getsiteAddr() 
        {
            return siteAddr;
        }
        public String getsiteAddress() 
        {
           return siteAddress;
        }
        public String getBillingAddr() 
        {
          return billAddr;
        }
	public void setsiteAddr(String siteAddr) {
		this.siteAddr = siteAddr;
	}
	public void setBillingAddr(String billAddr) {
		this.billAddr = billAddr;
	}
        public String getSupplyNumber() 
        {
            return SupplyNumber;
         }
        public String getsitePostcode() 
        {
           return sitePostcode;
         }
        public String getbpnumber() 
        {
            return bpnumber;
        }
}
