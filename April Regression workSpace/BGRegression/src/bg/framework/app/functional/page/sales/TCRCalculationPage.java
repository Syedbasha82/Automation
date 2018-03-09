package bg.framework.app.functional.page.sales;

import java.text.DecimalFormat;


import bg.framework.app.functional.entities.PriceDetails;
import bg.framework.app.functional.entities.PriceFinderRMR;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.TestDataHelper;

public class TCRCalculationPage extends BasePage{

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
		else if(region1.contains("BB2 7DF")) {//AB14 7GH
			Region = "Nor Web";
		}  
		else if(region1.contains("AB14 7GH")) {
			Region = "Scottish Hydro";
		}  
		else if(region1.contains("DG10 7FG")) {
			Region = "Scottish Power";
		}         
		else if(region1.contains("KT17 3BH"))/*BN10 7PR*/ {
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

	public String getCombination(String combination1){
		String combination = null;
		PriceFinderRMR priceFinder2 = new TestDataHelper().getPriceFinderRMR(combination);	
		return combination;
	}

	public String verifyPPForGasTariff(String tariff,String Combination){
		PriceFinderRMR priceFinder2 = new TestDataHelper().getPriceFinderRMR(Combination);
		String PPValue = null;
		PPValue = priceFinder2.getTotalGross();
		return PPValue;
	}

	public String verifyPPForElectricityTariff(String tariff,String Combination){
		PriceFinderRMR priceFinder2 = new TestDataHelper().getPriceFinderRMR(Combination);
		String PPValue = null;
		PPValue = priceFinder2.getTotalGross();
		return PPValue;
	}


	public String verifyTCRForGasTariff(String tariff,String Combination){
		PriceFinderRMR priceFinder2 = new TestDataHelper().getPriceFinderRMR(Combination);
		String TCRValue1 = null;

		System.out.println("88888888888888888888888888888888888888888"  +Combination);
		System.out.println("00000000000000000000000000000000000000000"  +tariff);
		TCRValue1 = priceFinder2.getTariffComparisonRate();
		return TCRValue1;


	}

	public String verifyTCRForElectricitySRTariff(String tariff,String Combination){
		PriceFinderRMR priceFinder2 = new TestDataHelper().getPriceFinderRMR(Combination);
		String TCRValue1 = null;
		TCRValue1 = priceFinder2.getTariffComparisonRate();
		return TCRValue1;
	}

	public String verifyTCRForElectricity2RTariff(String tariff,String Combination){
		PriceFinderRMR priceFinder2 = new TestDataHelper().getPriceFinderRMR(Combination);
		String TCRValue1 = null;
		TCRValue1 = priceFinder2.getTariffComparisonRate();
		return TCRValue1;	
	}


}
