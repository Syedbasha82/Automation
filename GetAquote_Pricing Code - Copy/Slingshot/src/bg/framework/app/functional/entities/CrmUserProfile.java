package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("CrmUserProfile")
public class CrmUserProfile {
	    private String client;
	    private String language;
	    private String username;
	    private String password;
	    private String searchby;
	    private String accountId;
	    private String Bpnumber;
	    private String referencenumber;
	    private String mobileNumber;
	    private String PBstatus;
	    
	    public String getPBstatus() {
	        return PBstatus;
	    }
	    public String getclient() {
	        return client;
	    }
        
	    public String getlanguage() {
	        return language;
	    }

	    public String getusername() {
	        return username;
	    }

	    public String getpassword() {
	        return password;
	    }
	    
	    public String getSearchby() {
	        return searchby;
	    }
	    
	    public String getreferencenumber() {
	        return referencenumber;
	    }
	    public String getaccountId(){
	    return accountId;	
	    }
	    public String getBpnumber(){
		    return Bpnumber;	
		    }
	    
	    
	    public String getMobileNumber(){
		    return mobileNumber;	
		    }
	    public CrmUserProfile() {
	    }

	    public CrmUserProfile(String client, String language, String username, String password, String searchby,
	                     String referencenumber,String accountId, String mobileNumber,String Bpnumber,String PBstatus) {
	        this.client = client;
	        this.language = language;
	        this.username = username;
	        this.password = password;
	        this.searchby = searchby;	        
	        this.referencenumber = referencenumber;
	        this.accountId = accountId;
	        this.mobileNumber = mobileNumber;
	        this.Bpnumber=Bpnumber;
	        this.PBstatus=PBstatus;
	        }

	    
		/*public static CrmUserProfile get(String profileKey) {
			// TODO Auto-generated method stub
			return null;
		}	    */

	    

	

}
