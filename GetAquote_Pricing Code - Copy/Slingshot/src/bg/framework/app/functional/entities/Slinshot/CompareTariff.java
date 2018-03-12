package bg.framework.app.functional.entities.Slinshot;

import java.text.DecimalFormat;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("CompareTariff")
public class CompareTariff {

	private String Tariff;
	private String Tarifftype;
	private String PropositionCode;
	private String Regioncode;
	private String Region;
	private String Postcode;
	private String PaymentOption;
	private String NOR;
	private String DualFuel;
	private String Fuel;
	private String AnnualConsumption;
	private String TariffComparisonRate;
	private String EstimatedAnnualCost;
	private String StandingCharge;
	private String Register1Price;
	private String Register2Price;
	private String UniteRates;
	private String Tariff1;
	private String Tariff2;
	private String Penalty;
	private String DualFuelDiscount;
	
	
	
	
	
	public CompareTariff(String Tariff,String Tarifftype, String Regioncode, String Region, String PaymentOption, String NOR,String PropositionCode,
			String Register1Price,String Register2Price, String Fuel,String DualFuel,String TariffComparisonRate,String AnnualConsumption,String EstimatedAnnualCost,
			String UnitRates, String StandingCharge,String Penalty, String DualFuelDiscount, String Postcode )
	{
		this.Tariff = Tariff;
		this.Tarifftype = Tarifftype;
		this.PaymentOption = PaymentOption;
		this.Regioncode = Regioncode;
		this.Region = Region;
		this.Postcode = Postcode;
		this.TariffComparisonRate = TariffComparisonRate;
		this.EstimatedAnnualCost = EstimatedAnnualCost;
		this.DualFuel = DualFuel;
		this.StandingCharge = StandingCharge;
		this.Register1Price = Register1Price;
		this.Register2Price = Register2Price;
		this.NOR = NOR;
		this.Fuel = Fuel;
		this.Penalty = Penalty;
        this.PropositionCode = PropositionCode;
        this.AnnualConsumption = AnnualConsumption;
        this.UniteRates = UniteRates;
        this.StandingCharge = StandingCharge;
        this.DualFuelDiscount = DualFuelDiscount;
       
	}
	
        public String getTariff(int i){
    		String Tariff = "";
    		switch(i){
    		case 1:
    			Tariff = Tariff1;
    			break;
    		case 2:
    			Tariff = Tariff2;
    			break;
    		
    		}
    		return Tariff;
    	}
        
        public String getTariff(){
    		return Tariff;
    	}	
        public String getTarifftype(){
    		return Tarifftype;
    	}
    	public String getPaymentOption(){
    		return PaymentOption;
    	}	
    	public String getRegioncode(){
    		return Regioncode;
    	}	
    	public String getRegion(){
    		return Region;
    	}	
    	public String getPostcode(){
    		return Postcode;
    	}
    	
    	public String getDualFuel(){
    		return DualFuel;
    	}
    	public String getTariffComparisonRate(){
    		return TariffComparisonRate;
    	}
    	public String getUniteRates(){
    		return this.UniteRates;
    	}
    	public String getEstimatedAnnualCost(){
    		return EstimatedAnnualCost;
    	}
    	public String getDualFuelDiscount(){
    		return DualFuelDiscount;
    	}
    	public String getAnnualConsumption(){
    		return AnnualConsumption;
    	}
    	public String getNOR(){
    		return NOR;
    	}
    	public String getFuel(){
    		return Fuel;
    	}
    	public String getStandingCharge(){
    		return StandingCharge;
    	}
    	public String getPenalty(){
    		return Penalty;
    	}
    	public String getPropositionCode(){
    		return PropositionCode;
    	}
    	public String getRegister1Price(){
    		return Register1Price;
    	}
    	public String getRegister2Price(){
    		return Register2Price;
    	}
    	
        

	}
	
	
	
	
	

