package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("LandLord")
public class LandLord {
	String houseNumber;
	String houseName;
	String address;
	String postalTown;
	String postCode;
	String lpostCode;
	String packageCover;
	String dueDate;
	String gasFireAdd;
	String gasCookerAdd; 
	String gasHobAdd;	
	String email;
	String password;
	String title;
	String fName;
	String surName;
	String companyName;
	String telephone;
	String mobile;
	String accountNumber;
	String sortCode1;
	String sortCode2;
	String sortCode3;
	String cardType;
	String payDate;
	
	String cardNumber;
	String cardStartMonth;
	String cardStartYear;
	String cardExpiryMonth;
	String cardExpiryYear;
	String issueNumber;
	
	float packageAmount;	
	float gasFire;
	float gasCooker;
	float gasHob;
	float annualDB;
	float annualFire;
	float annualCooker;
	float annualHob;
	
	
	

	public String getHouseNumber() {
		return houseNumber;
	}
	
	public String getHouseName() {
		return houseName;
	}

	public String getAddress() {
		return address;
	}

	public String getPostalTown() {
		return postalTown;
	}

	public String getPostCode() {
		return postCode;
	}	
	public String getLpostCode() {
		return lpostCode;
	}
	public String getPackageCover() {
		return packageCover;
	}
	public String getdueDate() {
		return dueDate;
	}
	public String getDueDate() {
		return dueDate;
	}
	public String getGasFireAdd() {
		return gasFireAdd;
	}
	public String getGasCookerAdd() {
		return gasCookerAdd;
	}
	public String getGasHobAdd() {
		return gasHobAdd;
	}	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	public String getTitle() {
		return title;
	}

	public String getfName() {
		return fName;
	}

	public String getSurName() {
		return surName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getMobile() {
		return mobile;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public String getSortCode1() {
		return sortCode1;
	}

	public String getSortCode2() {
		return sortCode2;
	}

	public String getSortCode3() {
		return sortCode3;
	}

	public String getCardType() {
		return cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getCardStartMonth() {
		return cardStartMonth;
	}

	public String getCardStartYear() {
		return cardStartYear;
	}

	public String getCardExpiryMonth() {
		return cardExpiryMonth;
	}

	public String getCardExpiryYear() {
		return cardExpiryYear;
	}

	public String getIssueNumber() {
		return issueNumber;
	}
		
	public String getPayDate() {
		return payDate;
	}

	public float getPackageAmount() {
		return packageAmount;
	}
	public float getGasFire() {
		return gasFire;
	}
	public float getGasCooker() {
		return gasCooker;
	}
	public float getGasHob() {
		return gasHob;
	}
	
	
	public float getAnnualDB() {
		return annualDB;
	}

	public float getAnnualFire() {
		return annualFire;
	}

	public void setAnnualFire(float annualFire) {
		this.annualFire = annualFire;
	}

	public float getAnnualCooker() {
		return annualCooker;
	}

	public void setAnnualCooker(float annualCooker) {
		this.annualCooker = annualCooker;
	}

	public float getAnnualHob() {
		return annualHob;
	}

	public void setAnnualHob(float annualHob) {
		this.annualHob = annualHob;
	}

	public void setAnnualDB(float annualDB) {
		this.annualDB = annualDB;
	}
	
	public void setPackageAmount(float packageAmount) {
		this.packageAmount = packageAmount;
	}
	public void setPackageCover(String packageCover) {
		this.packageCover = packageCover;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public void setGasFire(float gasFire) {
		this.gasFire = gasFire;
	}
	public void setGasCooker(float gasCooker) {
		this.gasCooker = gasCooker;
	}
	public void setGasHob(float gasHob) {
		this.gasHob = gasHob;
	}
	
}
