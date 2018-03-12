package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("BAAProfile")
public class BAAProfile {
    private String email;
    private String password;
    private String ucrn;
    private String firstName;
    private String lastName;
    private String flatNumber;
    private String HouseNumber;
    private String HouseName;
    private String AddressLine1;
    private String AddressLine2;
    private String mobileNumber;
    private String homeNumber;
    private String PostalTownCode;
    private String County;
    private String acceptTerms;
    private String nectarValue;
    private String elecAccount;
    private String gasAccount;
    private String bgsAccount;
    private String accNumber;
    private String addr;
    private String phoneNumber;
    private String phoneType;
    private String workNumber;
    
   
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

    public String getflatNumber() {
        return flatNumber;
    }

    public void setflatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getHouseNumber() {
        return HouseNumber;
    }

    public void setHouseNumber(String HouseNumber) {
        this.HouseNumber = HouseNumber;
    }

	public String getHouseName() {
        return HouseName;
    }

    public void setHouseName(String HouuseName) {
        this.HouseName = HouuseName;
    }
	
	
    public String getAddressLine1() {
        return AddressLine1;
    }

    public void setAddressLine1(String AddressLine1) {
        this.AddressLine1 = AddressLine1;
    }

    public String getAddressLine2() {
        return AddressLine2;
    }
    
    public void setAddressLine2(String AddressLine2) {
        this.AddressLine2 = AddressLine2;
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

    public String getCounty() {
        return County;
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
	
	public String getPhoneType() {
        return phoneType;
    }
    
    public void setCounty(String County) {
        this.County = County;
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

	 public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }
	
    public void setPostalTownCode(String PostalTownCode) {
        this.PostalTownCode = PostalTownCode;
    }

    public String getUcrn() {
		return ucrn;
	}

	public void setUcrn(String ucrn) {
		this.ucrn = ucrn;
	}

	public String getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setAcceptTerms(String acceptTerms) {
		this.acceptTerms = acceptTerms;
	}

	public void setElecAccount(String elecAccount) {
		this.elecAccount = elecAccount;
	}

	public void setGasAccount(String gasAccount) {
		this.gasAccount = gasAccount;
	}

	public void setBgsAccount(String bgsAccount) {
		this.bgsAccount = bgsAccount;
	}

	public void setWorkNumber(String workNumber) {
		this.workNumber = workNumber;
	}

	public String getPostalTownCode() {
        return PostalTownCode;
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

     public BAAProfile (){
    	 
     }

}
