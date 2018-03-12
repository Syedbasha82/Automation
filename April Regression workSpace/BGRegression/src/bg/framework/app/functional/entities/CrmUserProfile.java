package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("CrmUserProfile")
public class CrmUserProfile {
	    private String client;
	    private String language;
	    private String username;
	    private String password;
	    private String searchby;
	    private String referencenumber;
	    
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


	    public CrmUserProfile() {
	    }

	    public CrmUserProfile(String client, String language, String username, String password, String searchby,
	                     String referencenumber) {
	        this.client = client;
	        this.language = language;
	        this.username = username;
	        this.password = password;
	        this.searchby = searchby;
	        this.referencenumber = referencenumber;
	        }

	    
		/*public static CrmUserProfile get(String profileKey) {
			// TODO Auto-generated method stub
			return null;
		}	    */

	    

	

}
