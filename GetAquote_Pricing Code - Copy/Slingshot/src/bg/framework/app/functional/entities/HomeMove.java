package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;



@XStreamAlias("HomeMove")

public class HomeMove  {
	private String elecMeterType;
	private String elecMeterReading;
	private String elecNightReading;
	private String gasMeterType;
	private String gasMeterReading;
	private String postCode;
	private String address;
	private String forwardingAddress;
	private String address2;
	private String address3;
	private String address4;
	private String monthsLived;
	private String yearsLived;
	private String yearsLived2;
	private String YearsLived3;
	private String sortCode1;
	private String sortCode2;
	private String sortCode3;
	private String payDay;
	private String paymentType;
	private String cardNumber;
	private String cardType;
	private String bankAccountNumber;
	private String accHolderName;
	private String billingAddress;
	private String houseNumber;
	private String houseName;
	private String flatNumber;
	private String addressLine1;
	private String addressLine2;
	private String town;
	private String town2;
	private String country;
	private String title;
	private String firstName;
	private String middleName;
	private String surName;
	private String contactNo;
	private String contactType;
	private String dobDay;
	private String dobMonth;
	private String dobYear;
	private String eMail;
	private String cardName;
	
	private String issueNumber;
	private String startMonth;
	private String startYear;
	private String expiryMonth;
	private String expiryYear;
	private String accountNumber;
	private String personMovingOut;
	private String postCode2;
	private String postCode3;
	private String membershipNumber1;
	private String membershipNumber2;
	private String billPostCode;
	private String forwardingPostCode;
	
	private String companyName;
	private String supplyAddress1;
	private String supplyAddress2;
	private String supplyAddress3;
	private String accountToClose;
	private String accountToClose2;
	public HomeMove(){}
	
	
	public HomeMove(String billPostCode,String forwardingPostCode,String forwardingAddress,String cardName,String postCode2,String postCode3,String accountNumber,String cardType,String issueNumber,String startMonth,String startYear,String expiryMonth,String expiryYear,
			String elecMeterType,String elecMeterReading,String elecNightReading,String gasMeterType,String gasMeterReading,
			String title,String firstName,String middleName,String surName,String contactNo,String personMovingOut,
			String contactType,String dobDay,String dobMonth,String dobYear,String eMail,String country,String town,
			String town2,String addressLine2,String addressLine1,String flatNumber,String houseName,String postCode,
			String address,String address2,String address3,String address4,String billingAddress,String monthsLived,
			String yearsLived,String yearsLived2,String YearsLived3,String sortCode1,String sortCode2,String sortCode3,String payDay,
			String paymentType,String cardNumber,String bankAccountNumber,String accHolderName,
			String houseNumber,String membershipNumber1,String membershipNumber2,String companyName,String supplyAddress1,String supplyAddress2,String supplyAddress3,String accountToClose,String accountToClose2)
	{
		this.forwardingPostCode=forwardingPostCode;
		this.billPostCode=billPostCode;
		this.personMovingOut=personMovingOut;
		this.accountNumber=accountNumber;
		this.cardName=cardName;
		this.cardType=cardType;
		this.issueNumber=issueNumber;
		this.startMonth=startMonth;
		this.startYear=startYear;
		this.expiryMonth=expiryMonth;
		this.expiryYear=expiryYear;
		this.elecMeterType=elecMeterType;
		this.elecMeterReading=elecMeterReading;
		this.elecNightReading=elecNightReading;
		this.gasMeterType=gasMeterType;
		this.gasMeterReading=gasMeterReading;
		this.title=title;
		this.firstName=firstName;
		this.middleName=middleName;
		this.surName=surName;
		this.contactNo=contactNo;
		this.contactType=contactType;
		this.dobDay=dobDay;
		this.dobMonth=dobMonth;
		this.dobYear=dobYear;
		this.eMail=eMail;
		this.postCode=postCode;
		this.address=address;
		this.forwardingAddress=forwardingAddress;
		this.address2=address2;
		this.address3=address3;
		this.address4=address4;
		this.billingAddress=billingAddress;
		this.monthsLived=monthsLived;
		this.yearsLived=yearsLived;
		this.yearsLived2=yearsLived2;
		this.YearsLived3=YearsLived3;
		this.sortCode1=sortCode1;
		this.sortCode2=sortCode2;
		this.sortCode3=sortCode3;
		this.payDay=payDay;
		this.paymentType=paymentType;
		this.cardNumber=cardNumber;
		
		this.bankAccountNumber=bankAccountNumber;
		this.accHolderName=accHolderName;
		this.houseNumber=houseNumber;
		this.houseName=houseName;
		this.flatNumber=flatNumber;
		this.addressLine1=addressLine1;
		this.addressLine2=addressLine2;
		this.town=town;
		this.town2=town2;
		this.country=country;
		this.postCode2=postCode2;
		this.postCode3=postCode3;
		this.membershipNumber1=membershipNumber1;
		this.membershipNumber1=membershipNumber2;
		
		this.companyName=companyName;
		this.supplyAddress1=supplyAddress1;
		this.supplyAddress2=supplyAddress2;
		this.supplyAddress3=supplyAddress3;
		this.accountToClose=accountToClose;
		this.accountToClose2=accountToClose2;
	}
	public String getCompanyName()
	{
		return companyName;
	}
	public String getSupplyAddress1()
	{
		return supplyAddress1;
	}
	public String getSupplyAddress2()
	{
		return supplyAddress2;
	}
	public String getSupplyAddress3()
	{
		return supplyAddress3;
	}
	public String getMembershipNumber1()
	{
		return membershipNumber1;
	}
	public String getMembershipNumber2()
	{
		return membershipNumber2;
	}
	public String getForwardingPostCode()
	{
		return forwardingPostCode;
	}
	public String getForwardingAddress()
	{
		return forwardingAddress;
	}

	public String getPostCode2()
	{
		return postCode2;
	}
	public String getPostCode3()
	{
		return postCode3;
	}
	public String getPersonMovingOut()
	{
		return personMovingOut;
	}
	public String getAccountNumber()
	{
		return accountNumber;
	}
	public String getCardType()
	{
		return cardType;
	}
	public String getCardName()
	{
		return cardName;
	}
	public String getIssueNumber()
	{
		return issueNumber;
	}
	public String getStartYear()
	{
		return startYear;
	}
	public String getExpiryMonth()
	{
		return expiryMonth;
	}
	public String getExpiryYear()
	{
		return expiryYear;
	}
	public String getStartMonth()
	{
		return startMonth;
	}
	public String getElecMeterType()
	{
		return elecMeterType;
	}
	public String getElecMeterReading()
	{
		return elecMeterReading;
	}
	public String getElecNightReading()
	{
		return elecNightReading;
	}
	public String getGasMeterType()
	{
		return gasMeterType;
	}
	public String getGasMeterReading()
	{
		return gasMeterReading;
	}
	public String getTitle()
	{
		return title;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getMiddleName()
	{
		return middleName;
	}
	public String getSurName()
	{
		return surName;
	}
	public String getContactType()
	{
		return contactType;
	}
	public String getContactNo()
	{
		return contactNo;
	}
	public String getDOBDay()
	{
		return dobDay;
	}
	public String getDOBMonth()
	{
		return dobMonth;
	}
	public String getDOBYear()
	{
		return dobYear;
	}
	public String getEMail()
	{
		return eMail;
	}
	public String getCountry()
	{
		return country;
	}
	public String getTown()
	{
		return town;
	}
	public String getTown2()
	{
		return town2;
	}
	public String getAddressLine2()
	{
		return addressLine2;
	}
	public String getAddressLine1()
	{
		return addressLine1;
	}
	public String getHouseNumber()
	{
		return houseNumber;
	}
	public String getFlatNumber()
	{
		return flatNumber;
	}
	public String getHouseName()
	{
		return houseName;
	}
	public String getPostCode()
	{
		return postCode;
	}
	public String getBillPostCode()
	{
		return billPostCode;
	}
	
	public String getAddress()
	{
		return address;
	}
	public String getAddress2()
	{
		return address2;
	}
	public String getAddress3()
	{
		return address3;
	}
	public String getAddress4()
	{
		return address4;
	}
	public String getBillingAddress()
	{
		return billingAddress;
	}
	
	public String getMonthsLived()
	{
		return monthsLived;
	}
	public String getYearsLived()
	{
		return yearsLived;
	}
	public String getYearsLived2()
	{
		return yearsLived2;
	}
	public String getYearsLived3()
	{
		return YearsLived3;
	}
	public String getSortCode1()
	{
		return sortCode1;
	}
	public String getSortCode2()
	{
		return sortCode2;
	}
	public String getSortCode3()
	{
		return sortCode3;
	}
	public String getPayDay()
	{
		return payDay;
	}
	public String getPaymentType()
	{
		return paymentType;
	}
	public String getCardNumber()
	{
		return cardNumber;
	}
	
	public String getBankAccountNumber()
	{
		return bankAccountNumber;
	}
	public String getAccHolderName()
	{
		return accHolderName;
	}
	public void setPostCode(String postCode)
	{
		this.postCode=postCode;
	}
	public String getAccountsToClose()
	{
		return accountToClose;
	}
	public String getAccountsToClose2()
	{
		return accountToClose2;
	}
}
