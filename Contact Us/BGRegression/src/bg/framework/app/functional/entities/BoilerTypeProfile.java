package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("BoilerTypeProfile")
public class BoilerTypeProfile {
	private String BoilerMake;
	private String BoilerModel;
	private String BoilerPresent;

	
	public String getBoilerMake(){
		return BoilerMake;
	}
	
	public String getBoilerModel(){
		return BoilerModel;
	}
	
	public String getBoilerPresent(){
		return BoilerPresent;
	}
	
}

