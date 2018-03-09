package bg.framework.app.functional.entities;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("PriceFinderRMR")
public class PriceFinderRMR {
       
	private String Tariff;
	private String Meter;
	private String Pay;
	private String Region;
	private String Rate;
	private String TariffComparisonRate;
	private String DualFuel;
	private String TotalGross;
	private String Tariff1;
	private String Tariff2;
	private String Tariff3;
	private String Tariff4;
	private String Tariff5;
	private String Tariff6;

	public PriceFinderRMR(){
		
	}
	
	public PriceFinderRMR(String Tariff, String Meter, String Pay, String Region,
		String Tariff1, String Tariff2, String Tariff3, String Tariff4, String Tariff5, String Tariff6,
		    String Rate,String DualFuel,String TariffComparisonRate,String TotalGross){
		this.Tariff = Tariff;
		this.Meter = Meter;
		this.Pay = Pay;
		this.Region = Region;
		this.Rate = Rate;
		this.TariffComparisonRate = TariffComparisonRate;
		this.TotalGross = TotalGross;
		this.DualFuel = DualFuel;
		this.Tariff1 = Tariff1;
		this.Tariff2 = Tariff2;
		this.Tariff3 = Tariff3;
		this.Tariff4 = Tariff4;
		this.Tariff5 = Tariff5;
		this.Tariff6 = Tariff6;
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
	public String getPay(){
		return Pay;
	}	
	public String getRegion(){
		return Region;
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
	public String getTotalGross(){
		return TotalGross;
	}
}
