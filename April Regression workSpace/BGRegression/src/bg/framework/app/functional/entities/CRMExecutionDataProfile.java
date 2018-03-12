package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("CRMExecutionDataProfile")
public class CRMExecutionDataProfile {
	private String businesspartnerid;
    private String dayoftheyear;
    private String hour;
    private String minute;
    private String title;
    private String firtsname;
    private String lastname;
    private String homenumber;
    private String postcode;
    private String phonenumber;
    private String phonetype;
    
	public String getMinute() {
		return minute;
	}
	public void setMinute(String minute) {
		this.minute = minute;
	}
	public String getBusinessPartnerId() {
		return businesspartnerid;
	}
	public void setBusinessPartnerId(String businesspartnerid) {
		this.businesspartnerid = businesspartnerid;
	}
	public String getDayofTheYear() {
		return dayoftheyear;
	}
	public void setDayofTheYear(String dayoftheyear) {
		this.dayoftheyear = dayoftheyear;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
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
    
    
}
