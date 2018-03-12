package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("SiebelExecutionDataProfile")
public class SiebelExecutionDataProfile {
	private String dayoftheyear;
    private String title;
    private String firtsname;
    private String lastname;
    private String homenumber;
    private String postcode;
    private String phonenumber;
    private String phonetype;
    private String ucrn;
    
	public String getDayofTheYear() {
		return dayoftheyear;
	}
	public void setDayofTheYear(String dayoftheyear) {
		this.dayoftheyear = dayoftheyear;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirtsname() {
		return firtsname;
	}
	public void setFirtsname(String firtsname) {
		this.firtsname = firtsname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getHomenumber() {
		return homenumber;
	}
	public void setHomenumber(String homenumber) {
		this.homenumber = homenumber;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getPhoneNumber() {
		return phonenumber;
	}
	public void setPhoneNumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPhoneType() {
		return phonetype;
	}
	public void setPhoneType(String phonetype) {
		this.phonetype = phonetype;
	}
	
	public String getUCRN() {
		return ucrn;
	}
	public void setUCRN(String ucrn) {
		this.ucrn = ucrn;
	}

}
