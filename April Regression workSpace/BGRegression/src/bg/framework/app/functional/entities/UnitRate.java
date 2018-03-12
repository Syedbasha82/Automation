package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("UnitRate")
public class UnitRate {
	
        private String Tariff;
	    private String Meter;
	    private String Reg;
	    private String Pay;
	    private String Regioncode;
	    private String Region;
	    private String Threshold;
	    private String SC;
	    private String T1;
	    private String T2;
	    private String N;
	    private String Monthly;
	    private String Quarterly;
	    private String Yearly;
	    
	    

	    public UnitRate() {
	    }

	    public UnitRate(String Tariff, String Meter, String Reg,String Pay, String Regioncode, String Region,
	                       String Threshold,
	                       String SC, String T1, String T2, String N, String Monthly, String Quarterly, String Yearly) {
	        this.Tariff = Tariff;
	        this.Meter = Meter;
	        this.Reg = Reg;
	        this.Pay = Pay;
	        this.Regioncode = Regioncode;
	        this.Region = Region;
	        this.Threshold = Threshold;
	        this.SC = SC;
	        this.T1 = T1;
	        this.T2 = T2;
	        this.N = N;
	        this.Monthly = Monthly;
	        this.Quarterly = Quarterly;
	        this.Yearly = Yearly;
	      }

	    public String getTariff() {
	        return Tariff;
	    }

	    public String getMeter() {
	        return Meter;
	    }

	    public String getPay() {
	        return Pay;
	    }

	    public String getReg() {
	        return Reg;
	    }
	    public String getRegioncode() {
	        return Regioncode;
	    }

	    public String getRegion() {
	        return Region;
	    }

	    public String getThreshold() {
	        return Threshold;
	    }

	    public String getSC() {
	        return SC;
	    }

	    public String getT1() {
	        return T1;
	    }

	    public String getT2() {
	        return T2;
	    }

	    public String getN() {
	        return N;
	    }

	    public String getMonthly() {
	        return Monthly;
	    }

	    public String getQuarterly() {
	        return Quarterly;
	    }
	    public String getYearly() {
	        return Yearly;
	    }
	        
	}

