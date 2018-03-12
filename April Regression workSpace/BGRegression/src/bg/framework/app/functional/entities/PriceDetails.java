package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("PriceDetails")
public class PriceDetails {

	private String firstName;
	private String lastName;
	private String title;
	private String email;
	private String mobileNumber;
	private String phoneType;
	private String postCode;
	private String gasSpend;
	private String elecSpend;
	private String boilerAge;
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getboilerAge() {
		return boilerAge;
	}

	public void setboilerAge(String boilerAge) {
		this.boilerAge = boilerAge;
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	
	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	public String getGasSpend() {
		return gasSpend;
	}

	public void setGasSpend(String gasSpend) {
		this.gasSpend = gasSpend;
	}
	
	public String getElecSpend() {
		return elecSpend;
	}

	public void setElecSpend(String elecSpend) {
		this.elecSpend = elecSpend;
	}

	
}
