package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("KitchenApplianceCover")

public class KitchenApplianceCover {
	
	private String email;
	private String password;
	private String newemail;
	private String newpassword;
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
	private String businesspartnerid;
	private String accType;
	private String date;
	private String SalesNo;
	private String DDNo;
	private String letterConsent;
	private String emailConsent;
	private String landlineConsent;
	private String mobileConsent;
	private String textMessageConsent;
	private String initialSoStatus;
	private String postalCode;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private String answer5;
        private String dayOfBirth;
	private String monthOfBirth;
	private String yearOfBirth;
	private String gasSpendDuration;
	private String elecSpendDuration;
	private String sortCode1;
	private String sortCode2;
	private String sortCode3;
	private String annualGasSpendAmount;
	private String annualElecSpendAmount;
	private String yearAtAddress;
	private String monthAtAddress;
	private String currentEnergySupplier;
	private String currentEnergyPaymentMethod;
	private String currentEnergyTafiff;
	private String accNumber1,accNumber2,accNumber3,accNumber4;
	private String Addr1,Addr2,Addr3,Addr4;
	
	public String getInitialSoStatus() {
		return initialSoStatus;
	}

	public void setInitialSoStatus(String initialSoStatus) {
		this.initialSoStatus = initialSoStatus;
	}

	public String getSalesNo() {
		return SalesNo;
	}

	public String getDDNo() {
		return DDNo;
	}

	public String getNectarNumber() {
		return nectarNumber;
	}

	public void setNectarValue(String nectarValue) {
		this.nectarValue = nectarValue;
	}

	public String getaccType() {
		return accType;
	}

	public String getEmail() {
		return email;
	}

	public String getDate() {
		return date;
	}

	public String getNewEmail() {
		return email;
	}

	public String getNewPassword() {
		return password;
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

	public String getLetterConsent() {
		return letterConsent;
	}

	public String getEmailConsent() {
		return emailConsent;
	}

	public String getLandlineConsent() {
		return landlineConsent;
	}

	public String getMobileConsent() {
		return mobileConsent;
	}

	public String getTextMessageConsent() {
		return textMessageConsent;
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
	
	public String getAccNumber1() {
		return accNumber1;
	}
	
	public String getAccNumber2() {
		return accNumber2;
	}
	
	public String getAccNumber3() {
		return accNumber3;
	}
	
	public String getAccNumber4() {
		return accNumber4;
	}
	
	public String getAddr1(){
		return Addr1;
	}
	
	public String getAddr2(){
		return Addr2;
	}
	
	public String getAddr3(){
		return Addr3;
	}
	
	public String getAddr4(){
		return Addr4;
	}

	public void setPhoneNumber(String number) {
		System.out.println(number);
		if (number.length() == 14) {
			number = number.replace("+440", "0");
			this.phoneNumber = number;
			System.out.println(number);
		} else if (number.length() == 11) {
			this.phoneNumber = number;
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
			// type = type.substring(0, type.length() - 1);
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

	public String getBusinessPartnerID() {
		return businesspartnerid;
	}

	public void setBusinessPartnerID(String businesspartnerid) {
		this.businesspartnerid = businesspartnerid;
	}

	public void setDayOfBirth(String dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	public void setMonthOfBirth(String monthOfBirth) {
		this.monthOfBirth = monthOfBirth;
	}

	public void setYearOfBirth(String yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public void setElecSpendDuration(String elecSpendDuration) {
		this.elecSpendDuration = elecSpendDuration;
	}

	public KitchenApplianceCover() {
	}

	public KitchenApplianceCover(String email, String password, String newemail,
			String newpassword, String ucrn, String firstName, String lastName,
			String title, String securityQuestion, String securityAnswer,
			String phoneNumber, String phoneType, String mobileNumber,
			String homeNumber, String workNumber, String acceptTerms,
			String nectarValue, String nectarNumber, String elecAccount,
			String gasAccount, String bgsAccount, String accNumber,
			String addr, String NectarRegistered, String esGas, String esEle,
			String paymentGas, String paymentEle, String currentMeterGas,
			String tariffName1, String tariffName2, String tariff,
			String street, String localArea, String city, String country,
			String businesspartnerid, String SalesNo, String DDNo,
			String initialSoStatus, String postalCode, String answer1,
			String answer2, String answer3, String answer4, String answer5,
			String dayOfBirth, String monthOfBirth, String yearOfBirth,
			String gasSpendDuration, String elecSpendDuration,
			String sortCode1, String sortCode2, String sortCode3,
			String annualGasSpendAmount, String annualElecSpendAmount,
			String yearAtAddress, String monthAtAddress,
			String currentEnergySupplier, String currentEnergyPaymentMethod,
			String currentEnergyTafiff,
			String accNumber1, String accNumber2, String accNumber3, String accNumber4, String Addr1, String Addr2,
			String Addr3, String Addr4) {		
			this.SalesNo = SalesNo;
		this.DDNo = DDNo;
		this.accType = accType;
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
		this.NectarRegistered = NectarRegistered;
		this.esGas = esGas;
		this.esEle = esEle;
		this.paymentGas = paymentGas;
		this.paymentEle = paymentEle;
		this.currentMeterGas = currentMeterGas;
		this.tariffName1 = tariffName1;
		this.tariffName2 = tariffName2;
		this.tariff = tariff;
		this.street = street;
		this.localArea = localArea;
		this.city = city;
		this.country = country;
		this.newemail = newemail;
		this.newpassword = newpassword;
		this.businesspartnerid = businesspartnerid;
		this.date = date;
		this.initialSoStatus = initialSoStatus;
		this.postalCode = postalCode;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.answer5 = answer5;
	this.dayOfBirth = dayOfBirth;
		this.monthOfBirth = monthOfBirth;
		this.yearOfBirth = yearOfBirth;
		this.gasSpendDuration = gasSpendDuration;
		this.elecSpendDuration = elecSpendDuration;
		this.sortCode1 = sortCode1;
		this.sortCode2 = sortCode2;
		this.sortCode3 = sortCode3;

		this.annualGasSpendAmount = annualGasSpendAmount;
		this.annualElecSpendAmount = annualElecSpendAmount;

		this.yearAtAddress = yearAtAddress;
		this.monthAtAddress = monthAtAddress;
		this.currentEnergySupplier = currentEnergySupplier;
		this.currentEnergyPaymentMethod = currentEnergyPaymentMethod;
		this.currentEnergyTafiff = currentEnergyTafiff;
		this.accNumber1 = accNumber1;
		this.accNumber2 = accNumber2;
		this.accNumber3 = accNumber3;
		this.accNumber4 = accNumber4;
		this.Addr1 = Addr1;
		this.Addr2 = Addr2;
		this.Addr3 = Addr3;
		this.Addr4 = Addr4;

	}

	public String getPostCode() {
		// TODO Auto-generated method stub

		return postalCode;

	}

	public String getAnswer1() {
		// TODO Auto-generated method stub
		return answer1;
	}

	public String getAnswer2() {
		// TODO Auto-generated method stub
		return answer2;
	}

	public String getAnswer3() {
		// TODO Auto-generated method stub
		return answer3;
	}

	public String getAnswer4() {
		// TODO Auto-generated method stub
		return answer4;
	}

	public String getAnswer5() {
		// TODO Auto-generated method stub
		return answer5;
	}
	public String getDayOfBirth() {
		// TODO Auto-generated method stub
		return dayOfBirth;
	}

	public String getMonthOfBirth() {
		// TODO Auto-generated method stub
		return monthOfBirth;
	}

	public String getYearOfBirth() {
		// TODO Auto-generated method stub
		return yearOfBirth;
	}

	public String getGasSpendDuration() {
		// TODO Auto-generated method stub

		return gasSpendDuration;
	}

	public String getElecSpendDuration() {
		return elecSpendDuration;
	}

	public String getsortCode1() {

		return sortCode1;
	}

	public String getsortCode2() {

		return sortCode2;
	}

	public String getsortCode3() {

		return sortCode3;
	}

	public String getannualGasSpendAmount() {
		return annualGasSpendAmount;
	}

	public String getannualElecSpendAmount() {
		return annualElecSpendAmount;
	}

	public String getYearAtAddress() {
		return yearAtAddress;
	}

	public String getMonthAtAddress() {
		return monthAtAddress;
	}

	public String getCurrentEnergySupplier() {

		return currentEnergySupplier;
	}

	public String getCurrentEnergyPaymentMethod() {

		return currentEnergyPaymentMethod.trim();
	}

	public String getCurrentEnergyTafiff() {
		return currentEnergyTafiff;
	}

}
