package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("EshopTariffProfile")
public class EshopTariffProfile {
	private String tariff1;
	private String tariff2;
	private String tariff3;
	private String tariff4;
	private String tariff5;
	private String tariff6;
	private String tariff7;
	private String fueltariff11;
	private String fueltariff12;
	private String fueltariff13;
	private String fueltariff21;
	private String fueltariff22;
	private String fueltariff23;
	private String fueltariff31;
	private String fueltariff32;
	private String fueltariff33;
	private String fueltariff41;
	private String fueltariff42;
	private String fueltariff43;
	private String fueltariff51;
	private String fueltariff52;
	private String fueltariff53;
	private String fueltariff61;
	private String fueltariff62;
	private String fueltariff63;
	private String fueltariff71;
	private String fueltariff72;
	private String fueltariff73;
	
	public String getTariff(int i){
		String temp="";
		switch(i)
		{
			case 1:
				temp = tariff1;
				break;
			case 2:
				temp = tariff2;
				break;
			case 3:
				temp = tariff3;
				break;
			case 4:
				temp = tariff4;
				break;
			case 5:
				temp = tariff5;
				break;
			case 6:
				temp = tariff6;
				break;
			case 7:
				temp = tariff7;
				break;
		}
		return temp;
	}
	
	
	public String getFueltariff(int i, int j){
		String temp="";
		int k = Integer.parseInt(i+""+j);
		switch(k)
		{
			case 11:
				temp = fueltariff11;
				break;
			case 12:
				temp = fueltariff12;
				break;
			case 13:
				temp = fueltariff13;
				break;
			case 21:
				temp = fueltariff21;
				break;
			case 22:
				temp = fueltariff22;
				break;
			case 23:
				temp = fueltariff23;
				break;
			case 31:
				temp = fueltariff31;
				break;
			case 32:
				temp = fueltariff32;
				break;
			case 33:
				temp = fueltariff33;
				break;
			case 41:
				temp = fueltariff41;
				break;
			case 42:
				temp = fueltariff42;
				break;
			case 43:
				temp = fueltariff43;
				break;
			case 51:
				temp = fueltariff51;
				break;
			case 52:
				temp = fueltariff52;
				break;
			case 53:
				temp = fueltariff53;
				break;
			case 61:
				temp = fueltariff61;
				break;
			case 62:
				temp = fueltariff62;
				break;
			case 63:
				temp = fueltariff63;
				break;
			case 71:
				temp = fueltariff71;
				break;
			case 72:
				temp = fueltariff72;
				break;
			case 73:
				temp = fueltariff73;
				break;
		}
		return temp;
		
	}
}
