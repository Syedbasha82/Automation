package bg.framework.app.functional.entities.Slinshot;

import com.thoughtworks.xstream.annotations.XStreamAlias;


@XStreamAlias("CarePlanProfile")
public class CarePlanProfile {
	private String ApplianceCategory;
	private String Appliance;
	private String ApplianceSize;
	private String CustomersLocation;
	private String ExistingBGBcustomer;
	private String CareplanOptions;
	private String AnnualPriceNET;
	private String MonthlyPriceNET;
	private String AnnualPriceVAT;
	private String MonthlyPriceVAT;
	private String ProductID;
	
	 public String getApplianceCategory() {
	        return ApplianceCategory;
	    }
	 public String getProductID() {
	        return ProductID;
	    }
	 public String getAppliance() {
	        return Appliance;
	    }
	 public String getApplianceSize() {
	        return ApplianceSize;
	    }
	 public String getCustomersLocation() {
	        return CustomersLocation;
	    }
	 public String getExistingBGBcustomer() {
	        return ExistingBGBcustomer;
	    }
	 public String getCareplanOptions() {
	        return CareplanOptions;
	    }
	 public String getAnnualPriceNET(){
	        return AnnualPriceNET;
	    }
	 public String getMonthlyPriceNET(){
	        return MonthlyPriceNET;
	    }
	 
	 public String getAnnualPriceVAT(){
	        return AnnualPriceVAT;
	    }
	 
	 public String getMonthlyPriceVAT(){
	        return MonthlyPriceVAT;
	    }
	 
	 

}
