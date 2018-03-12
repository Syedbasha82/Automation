package bg.framework.app.functional.entities;


import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("AddAdditionalAccounts")

public class AddAdditionalAccounts {

    private String Accountnumber;
    private String Billnumber;
    private String Postcode;
   
   public String getAccountnumber() {
        return Accountnumber;
    } 
    public String getBillnumber() {
        return Billnumber;
    }
    public String getPostcode() 
    {
       return Postcode;
     }
    
    public void setAccountnumber(String Accountnumber) {
		this.Accountnumber = Accountnumber;
	}
    public void setBillnumber(String Billnumber) {
		this.Billnumber = Billnumber;
	}
    public void Postcode(String Postcode) {
		this.Postcode = Postcode;
	}

   
	
}
