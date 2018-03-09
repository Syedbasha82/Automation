package bg.framework.app.functional.entities;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ModelSalesPricing")
public class ModelSalesPricing {
	
     private String Products;
     private String Excess;
     private String Region;
     private String MonthlyPrice;
     private String AnnualPrice;
     private String Type;
     private float Compaign;
     
     public String getProducts(){
    	 return Products;
     }
     
     public String getExcess(){
    	 return Excess;
     }
     
     public String getRegion(){
    	 return Region;
     }
     
     public String getMonthlyPrice(){
    	 return MonthlyPrice;
     }
     
     public String getAnnualPrice(){
    	 return AnnualPrice;
     }
     public String getType(){
    	 return Type;
     }
     public float getCompaign(){
    	 return Compaign;
     }
}
