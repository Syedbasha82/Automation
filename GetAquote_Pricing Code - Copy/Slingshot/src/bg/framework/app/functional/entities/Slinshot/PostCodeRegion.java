package bg.framework.app.functional.entities.Slinshot;

import java.text.DecimalFormat;

import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.TestDataHelper;
import com.thoughtworks.xstream.annotations.XStreamAlias;


public class PostCodeRegion extends TestBase{

	public String getPostcode(String region1) {
		String Region = null;
		if(region1.contains("AL10 8UW")){
			Region = "Eastern";
		}
		else if(region1.contains("LE12 9LX")) {
			Region ="Power Gen";
		}
		else if(region1.contains("BR1 7YJ")) {
			Region = "London Electricity";
		}
		else if(region1.contains("L22 5QH")) {
			Region = "Man Web";
		}
		else if(region1.contains("B10 9JU")) {
			Region = "Midlands";
		}         
		else if(region1.contains("DH2 7GH")) {   
			Region = "Northern";
		}  
		else if(region1.contains("BB2 7DF")) {
			Region = "Nor Web";
		}  
		else if(region1.contains("AB14 7GH")) {
			Region = "Scottish Hydro";
		}  
		else if(region1.contains("DG10 7FG")) {
			Region = "Scottish Power";
		}         
		else if(region1.contains("KT17 3BH")) {
			Region = "Seeboard";
		}  
		else if(region1.contains("BH7 6WD")) {
			Region = "Southern";
		}   
		else if(region1.contains("CF10 6FG")) {
			Region = "Swalec";
		}   
		else if(region1.contains("BA3 7GH")) {
			Region = "Sweb";
		}  
		else if(region1.contains("WF10 3NA")) {
			Region = "Yorkshire Power";
		}  
		return Region;
	}
	
	
}
