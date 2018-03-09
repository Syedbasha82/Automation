package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("BoilerReplaceProfile")
public class BoilerReplaceProfile {
	private String BoilerMake;
	private String BoilerModel;
	private String GasCouncilNo;
	private String Rating;
	private String Efficient;
	private String PartsAvailable;
	private String iteration;
	
	public String getIteration(){
		return iteration;
	}
	public String getBoilerMake(){
		return BoilerMake;
	}
	
	public String getBoilerModel(){
		return BoilerModel;
	}
	
	public String getGasCouncilNo(){
		return GasCouncilNo;
	}
	
	public String getRating(){
		return Rating;
	}
	
	public String getEfficient(){
		return Efficient;
	}
	
	public String getPartsAvailable(){
		return PartsAvailable;
	}
}
