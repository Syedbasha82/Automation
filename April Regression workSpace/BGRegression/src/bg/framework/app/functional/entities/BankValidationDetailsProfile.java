package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("BankValidationDetailsProfile")
public class BankValidationDetailsProfile {
	private String accountnumber;
	private String sortcode1;
	private String sortcode2;
	private String sortcode3;
	private String BankValidationCount;
	
	public String getAccountNumber(){
		return accountnumber;
	}
	
	public String getSortCode1(){
		return sortcode1;
	}
	
	public String getSortCode2(){
		return sortcode2;
	}
	
	public String getSortCode3(){
		return sortcode3;
	}
	
	public String getBankValidationCount(){
		return BankValidationCount;
	}
}
