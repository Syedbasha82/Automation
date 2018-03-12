package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("KACPriceProfile")

public class KACPriceProfile {
     private String Appliances;
     private String Region;
     private String MonthlyPrice;
     private String AnnualPrice;
     private String SinglePayment;
    
     
     public String getAppliances(){
    	 return Appliances;
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
     public String getSinglePayment(){
    	 return SinglePayment;
     }
}
