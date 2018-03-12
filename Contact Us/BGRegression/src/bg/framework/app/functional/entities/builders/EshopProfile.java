package bg.framework.app.functional.entities.builders;





	public class EshopProfile {
	private String tariff1;
	private String tariff2;
	private String tariff3;
	private String tariff4;
	private String fuel11;
	private String fuel12;
	private String fuel13;
	private String fuel21;
	private String fuel22;
	private String fuel23;
	private String fuel31;
	private String fuel32;
	private String fuel33;
	private String fuel41;
	private String fuel42;
	private String fuel43;
	
    public String getTariff(int i){
    	String tariff ="";
    	switch(i)
    	{
    	case 1:
    		tariff = tariff1;
    		break;
    	case 2:
    		tariff = tariff2;
    		break;
    	case 3:
    		tariff = tariff3;
    		break;
    	case 4:
    		tariff = tariff4;
    		break;
    	}
    	return tariff;
    }
    
    public String getFuel(int i,int j){
    	String fuel ="";
    	int k = Integer.parseInt(i+""+j);
    	switch(k)
    	{
    	case 11:
    		fuel = fuel11;
    		break;
    	case 12:
    		fuel = fuel12;
    		break;
    	case 13:
    		fuel = fuel13;
    		break;
    	case 21:
    		fuel = fuel21;
    		break;
    	case 22:
    		fuel = fuel22;
    		break;
    	case 23:
    		fuel = fuel23;
    	    break;
    	case 31:
    		fuel = fuel31;
    		break;
    	case 32:
    		fuel = fuel32;
    		break;
    	case 33:
    		fuel = fuel33;
    		break;
    	case 41:
    		fuel = fuel41;
    		break;
    	case 42:
    		fuel = fuel42;
    		break;
    	case 43:
    		fuel = fuel43;
    		break;
    	}
    	return fuel;
    }
	}

