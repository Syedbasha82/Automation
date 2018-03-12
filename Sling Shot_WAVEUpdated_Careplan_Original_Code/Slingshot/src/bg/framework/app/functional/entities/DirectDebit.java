package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("DirectDebit")
public class DirectDebit {
		private String email;
	    private String password;
	    private String accNumber;
	    private String accountholdername;
	    private String sortcode1;
	    private String sortcode2;
	    private String sortcode3;
	    private String bankaccountnumber;
	    private String feedbackoption;
	    private String feedbacktext;
	    
	    public String getEmail() {
	        return email;
	    }
	    
	    public String getPassword() {
	        return password;
	    }
	    
	    public String getAccNumber(){
		    return accNumber;	
		    }
	    public String getAccountHolderName(){
	    	return accountholdername;
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
	    public String getBankAccountnumber(){
	    	return bankaccountnumber;
	    }
	    public String getfeedbackoption(){
	    	return feedbackoption;
	    }
	    public String getFeedbacktext(){
	    	return feedbacktext;
	    }
	    public DirectDebit() {
	    }

	    public DirectDebit(String email, String password,String accNumber,String accountholdername,String sortcode1,String sortcode2,String sortcode3,String bankaccountnumber,String feedbackoption,String feedbacktext) {
	    	this.email=email;
	    	this.password=password;	        
	        this.accNumber=accNumber;
	        this.accountholdername=accountholdername;
	        this.sortcode1=sortcode1;
	        this.sortcode2=sortcode2;
	        this.sortcode3=sortcode3;
	        this.bankaccountnumber=bankaccountnumber;
	        this.feedbackoption=feedbackoption;
	        this.feedbacktext=feedbacktext;
	        }

	    
		/*public static CrmUserProfile get(String profileKey) {
			// TODO Auto-generated method stub
			return null;
		}	    */

	    

	

}
