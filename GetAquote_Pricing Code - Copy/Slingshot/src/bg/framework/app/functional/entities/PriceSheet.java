package bg.framework.app.functional.entities;

import bg.framework.app.functional.util.TestDataHelper;

public class PriceSheet  {
	
	float packageAmount;	
	float gasFire;
	float gasCooker;
	float gasHob;
	
	public LandLord priceBuilder(LandLord landLord){
		String packageCover=landLord.getPackageCover().trim();
		String postCode=landLord.getPostCode().trim();
		System.out.println("PRICE SHEET: "+ landLord.getPackageCover());
		System.out.println("PRICE SHEET: "+ landLord.getPostCode());
		
		LandLord price=null;
	if(packageCover.equals("index=1")){	
		 price=new TestDataHelper().getLandLord("CP12");	
		 
	}else if(packageCover.equals("index=2")&& postCode.equalsIgnoreCase("tw18 3he")){
		 price=new TestDataHelper().getLandLord("HC100L");
				
	}else if(packageCover.equals("index=2")&& postCode.equalsIgnoreCase("sn3 4jj")){
		 price=new TestDataHelper().getLandLord("HC100");
	
	}
	if(packageCover.equals("index=3")&& postCode.equalsIgnoreCase("tw18 3he")){
		 price=new TestDataHelper().getLandLord("HC200L");
		
	}else if(packageCover.equals("index=3")&& postCode.equalsIgnoreCase("sn3 4jj")){
		price=new TestDataHelper().getLandLord("HC200");
		
	}
	if(packageCover.equals("index=4")&& postCode.equalsIgnoreCase("tw18 3he")){	
		 price=new TestDataHelper().getLandLord("HC300L");
				
	}else if(packageCover.equals("index=4")&& postCode.equalsIgnoreCase("sn3 4jj")){
		 price=new TestDataHelper().getLandLord("HC300");
		
	}
	if(packageCover.equals("index=5")&& postCode.equalsIgnoreCase("tw18 3he")){	
		 price=new TestDataHelper().getLandLord("HC400L");
		
	}else if(packageCover.equals("index=5")&& postCode.equalsIgnoreCase("sn3 4jj")){
		 price=new TestDataHelper().getLandLord("HC400");
		
	}
	landLord.setPackageAmount(price.getPackageAmount());		
	landLord.setGasFire(price.getGasFire());
	landLord.setGasCooker(price.getGasCooker());
	landLord.setGasHob(price.getGasHob());
	landLord.setAnnualCooker(price.getAnnualCooker());
	landLord.setAnnualFire(price.getAnnualFire());
	landLord.setAnnualHob(price.getAnnualHob());
	landLord.setAnnualDB(price.getAnnualDB());
	return landLord;
	}
//	{
//		landLord.setGasFire(4.58f);
//		landLord.setGasCooker(3.08f);
//		landLord.setGasHob(3.08f);
//	}
	
}
