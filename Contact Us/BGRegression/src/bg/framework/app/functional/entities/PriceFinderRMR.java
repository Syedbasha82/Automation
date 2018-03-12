package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("PriceFinderRMR")
public class PriceFinderRMR {
       
	private String Tariff;
	private String Meter;
	private String PaymentOption;
	private String RegionCode;
	private String Region;
	private String Register;
	private String Th;
	private String SC;
	private String T1;
	private String T2;
	private String Rate;
	private String TariffComparisonRate;
	private String DualFuel;
	private String EstimatedAnnualCost;
	private String Tariff1;
	private String Tariff2;
	private String Tariff3;
	private String Tariff4;
	private String Tariff5;
	private String Tariff6;
	private String StandingCharge;
	private String Register1Price;
	private String Register2Price;
	private String NOR;
	private String Fuel;
	private String PropositionCode;
	private String AnnualConsumption;


	public PriceFinderRMR(String Tariff, String Meter, String Pay, String Regioncode, String Region,
			String Th, String SC, String T1, String T2,String Tariff1, String Tariff2, String Tariff3, String Tariff4, String Tariff5, String Tariff6,
		    String DayT1,String DayT2, String NightT1,String NightT2,String Register,String Rate,String DualFuel,String TariffComparisonRate,String TotalGross, String UnitRates, String StandingCharge){
		this.Tariff = Tariff;
		this.Meter = Meter;
		this.PaymentOption = PaymentOption;
		this.RegionCode = RegionCode;
		this.Region = Region;
		this.Th = Th;
		this.SC = SC;
		this.T1 = T1;
		this.T2 = T2;
		this.Rate = Rate;
		this.TariffComparisonRate = TariffComparisonRate;
		this.EstimatedAnnualCost = EstimatedAnnualCost;
		this.DualFuel = DualFuel;
		this.Tariff1 = Tariff1;
		this.Tariff2 = Tariff2;
		this.Tariff3 = Tariff3;
		this.Tariff4 = Tariff4;
		this.Tariff5 = Tariff5;
		this.Tariff6 = Tariff6;
		this.Register = Register;
		this.StandingCharge = StandingCharge;
		this.Register1Price = Register1Price;
		this.Register2Price = Register2Price;
		this.NOR = NOR;
		this.Fuel = Fuel;
        this.PropositionCode = PropositionCode;
        this.AnnualConsumption = AnnualConsumption;

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
		case 3:
			Tariff = Tariff3;
			break;
		case 4:
			Tariff = Tariff4;
			break;
		case 5:
			Tariff = Tariff5;
			break;
		case 6:
			Tariff = Tariff6;
		    break;
		}
		return Tariff;
	}
	
	public String getTariff(){
		return Tariff;
	}	
	public String getMeter(){
		return Meter;
	}	
	public String PaymentOption(){
		return PaymentOption;
	}	
	public String getRegioncode(){
		return RegionCode;
	}	
	public String getRegion(){
		return Region;
	}	
	public String getThershold(){
		return Th;
	}
	public String getT1(){
		return T1;
	}	
	public String getSC(){
		return SC;
	}	
	public String getT2(){
		return T2;
	}	
	public String getRegister(){
		return Register;
	}
	public String getRate(){
		return Rate;
	}
	public String getDualFuel(){
		return DualFuel;
	}
	public String getTariffComparisonRate(){
		return TariffComparisonRate;
	}
	public String getEstimatedAnnualCost(){
		return EstimatedAnnualCost;
	}
	public String getStandingCharge(){
		return StandingCharge;
	}
	public String getRegister1Price(){
		return Register1Price;
	}
	public String getRegister2Price(){
		return Register2Price;
	}
}
