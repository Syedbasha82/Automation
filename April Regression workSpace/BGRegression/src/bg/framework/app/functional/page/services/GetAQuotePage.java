package bg.framework.app.functional.page.services;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;

import bg.framework.app.functional.entities.BoilerTypeProfile;
import bg.framework.app.functional.entities.LandLord;
import bg.framework.app.functional.entities.PriceSheet;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;


public class GetAQuotePage extends BasePage{
	
	private final static String FILE_NAME="resources/services/GetAQuotePage.properties";
	private static Properties pageProperties=new PropertyLoader(FILE_NAME).load();
	private static float LandlordDiscountedPrice=0;
	private LandLord landLord;
	public GetAQuotePage(){
		
	}
	public GetAQuotePage(LandLord landLord){
		this.landLord=landLord;
	}
	
	
	public void enterTellUs(String postCode,String houseNumber){	
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("LandLord.houseNumberLabel"), "House nmber Label");
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("LandLord.postCodeLabel"), "Post code Label");
			verifyAndInputById(pageProperties.getProperty("LandLord.houseNumberText"), "House Number", houseNumber);
			browser.wait(5000);
			verifyAndInputById(pageProperties.getProperty("LandLord.postCodeText"), "Post Code", postCode);	
			browser.wait(5000);
			verifyAndClick(pageProperties.getProperty("LandLord.searchButton"), "Search Button");
			browser.wait(6000);
	}
	
	public void selectAddress(int count){
		browser.wait(5000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandLord.SingleaddressPostcode"))){
			Report.updateTestLog("Address Prepopulated", "WARN");
        	Report.updateTestLog("Single address postcode "+browser.getTextByXpath(pageProperties.getProperty("LandLord.SingleaddressPostcode"))+" is Present", "Pass");
        }
		else
		{
			
			String value=browser.getTextByXpath(pageProperties.getProperty("LandLord.addresCount")+"["+(count+1)+"]");
			browser.selectfromDropBoxByXpath(pageProperties.getProperty("LandLord.addressList"), value);
			/*if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandLord.errorBox"))
					|| !browser.isElementVisible(pageProperties.getProperty("LandLord.addressList")) ){			
				//tellUsErrorVerification();
				
			}else{
				if(browser.getChildElementsCountByXpath(pageProperties.getProperty("LandLord.addresCountAdded"))>=count){
					count=count+browser.getChildElementsCountByXpath(pageProperties.getProperty("LandLord.addresCountAdded")+1);
				}
			int searchCount=browser.getChildElementsCountByXpath(pageProperties.getProperty("LandLord.addresCount"));
			System.out.println("Entries "+searchCount);
				if(searchCount>=1){
					Report.updateTestLog("Address is displayed in list box", "PASS");
					String value=browser.getTextByXpath(pageProperties.getProperty("LandLord.addresCount")+"["+count+"]");
					verifyAndSelectDropDownBox(pageProperties.getProperty("LandLord.addressList"), "Address", value);										
				}
				else{
					Report.updateTestLog("Address is not displayed in list box", "FAIL");
				}
			}*/
		}
		
	}
	
	public void clickNextButton(){
		browser.wait(2000);
		verifyAndClick(pageProperties.getProperty("LandLord.nextButton"), "Next button");		
	}
	
	
	public void addExistingHomecare(){
		browser.wait(3000);
		verifyAndSelectDropDownBoxByXpath(pageProperties.getProperty("LandLord.ExistingHomecareContract"), "Existing homecare contract", "Yes");
	}
	
	
	public void verifyPostCode(){
		String postCode[]={"fr5tg"," ", landLord.getPostCode(),"tw18","&*^&","&*^&","","3he tw18"};
		String houseNo[]={" "," ","zr3d"," "," ","!@#$","!@#$",""};
		int i=0;
		for(String code:postCode){		
		enterTellUs(code,houseNo[i]);
		tellUsErrorVerification();
		i++;
		}
	}
	
	public void verifyUncoverPostCode(){
		ArrayList<String> postCode=new ArrayList<String>();
		postCode.add("BT28 7DT");
		postCode.add("BT15 5BB");
		postCode.add("HS3 3BG");
		postCode.add("HS2 0SN");
		postCode.add("KW14 8BN");
		postCode.add("KW8 6JA");
		postCode.add("ZE2 9EL");
		postCode.add("ZE1 0LU");
		postCode.add("GY5 7HB");
		postCode.add("GY1 3EY");
		postCode.add("JE1 1AA");
		postCode.add("JE5 0BL");
		postCode.add("IM1 2EX");
		for(String code:postCode){		
		enterTellUs(code,"");
		tellUsErrorVerification();		
		}		
	}
	
	
	private void tellUsErrorVerification(){
		ArrayList<String> errorList=new ArrayList<String>();		
		browser.wait(6000);
		errorList.add(ErrorMessage.HOUSE_NUMBER);
		errorList.add(ErrorMessage.INVALID_UK_POSTCODE);		
		errorList.add(ErrorMessage.INVALID_POSTCODE);
		errorList.add(ErrorMessage.SELECT_ADDRESS);
		errorList.add(ErrorMessage.DUPLICATE_ADDRESS);
		errorList.add(ErrorMessage.NON_AGREEMENT_UK);
		errorList.add(ErrorMessage.MAN_HOUSE_NUMBER);
		errorList.add(ErrorMessage.ENTER_ADDRESSS);
		errorList.add(ErrorMessage.POSTAL_TOWN);				
		errorList.add(ErrorMessage.INVALID_HOUSE);
		boolean error=false;
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandLord.errorBox"))||
				browser.isElementVisibleWithXpath(pageProperties.getProperty("LandLord.businessErrorBox"))){
			String pageError;
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandLord.errorBox"))){
			pageError=browser.getTextByXpath(pageProperties.getProperty("LandLord.errorBox"));}else{
				pageError=browser.getTextByXpath(pageProperties.getProperty("LandLord.businessErrorBox"));
			}
			System.out.println("************************");
			System.out.println(pageError);
			System.out.println("************************");
			for(String err:errorList){
				browser.wait(3000);
				if(pageError.contains(err)){
					Report.updateTestLog("Error message <b>" +err+ "</b> is displayed", "PASS");
					error=false;
				break;
				}else{
					error=true;
				}
			}
			browser.wait(3000);
			if(error==true){
				Report.updateTestLog("Expected error is not displayed", "FAIL");
			}
		}
		else{			
				Report.updateTestLog("Error messageis not displayed", "FAIL");				
		}		
	}
	private void packageErrorVerification(){
		ArrayList<String> errorList=new ArrayList<String>();	
		errorList.add(ErrorMessage.INVALID_DATE);
		errorList.add(ErrorMessage.INVALID_PACKAGE);
		boolean error=false;
		 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandLord.productErrorBox"))){
			String pageError=browser.getTextByXpath(pageProperties.getProperty("LandLord.productErrorBox"));			
			for(String err:errorList){
				if(pageError.contains(err)){
					Report.updateTestLog("Error message <b>" +err+ "</b>is displayed", "PASS");
					error=false;
				break;
				}else{
					error=true;
				}
			}
			if(error==true){
				Report.updateTestLog("Expected error is not displayed", "FAIL");
			}
		 }
		 else{			
				Report.updateTestLog("Error messageis not displayed", "FAIL");				
		}
	}
	public void selectAddressError(){
		for(int i=0;i<=1;i++){
			enterTellUs(landLord.getPostCode(),landLord.getHouseNumber());
			browser.wait(5000);			
			if(i==0){							
				clickNextButton();	
				System.out.println("INSIDE ONE");
			}
			if(i==1){				
				String value=browser.getTextByXpath(pageProperties.getProperty("LandLord.addresCount")+"["+i+"]");
				System.out.println("ADDRESS VALUE: "+i+" "+value);	
				verifyAndSelectDropDownBox(pageProperties.getProperty("LandLord.addressList"), "Address", value);
				verifyAndClick(pageProperties.getProperty("LandLord.addPropertyLink"), "Add property Link");	
				enterTellUs(landLord.getPostCode(),landLord.getHouseNumber());		
				browser.wait(5000);	
				verifyAndSelectDropDownBox(pageProperties.getProperty("LandLord.addressList"), "Address", value);
				clickNextButton();					
			}			
			tellUsErrorVerification();
		}
	}
	
	public void editProperty(){		
		verifyAndClick(pageProperties.getProperty("LandLord.editLink"), "Edit link of 1st section");
		verifyAddPropertyLink();		
	}
	
	public void removeProperty(int number){		
		verifyAndClickWithXpath(pageProperties.getProperty("LandLord.removeLink")
				.replace("number", ""+number),"Remove Link "+number+" clicked");		
		//clickNextButton();
	}
	
	
	
	public void enterMultiTellUs(int number){
		int count=0;
			for(count=1;count<=number;count++){				
				if(count>5){
					landLord.setPostCode(landLord.getLpostCode());
				}
				String PostCode = landLord.getPostCode();
				
				enterTellUs(PostCode,landLord.getHouseNumber());
				browser.wait(5000);
				selectAddress(count);
				addProperty();								
				System.out.println("oooooooooooooooooo  "+count);
			}			
	}
	
	public void clickEnterManualLink(){
		browser.wait(5000);
		verifyAndClickWithXpath(pageProperties.getProperty("LandLord.manualAddressLink"), "Enter manual Link");
	}
	
	public void verifyManualAddressError(){
        
		
		String hname[]={"","",landLord.getHouseName(),landLord.getHouseName()
				,landLord.getHouseName(),landLord.getHouseName(),landLord.getHouseName(),landLord.getHouseName()};
		String add[]={"",landLord.getAddress(),"",landLord.getAddress()
				,landLord.getAddress(),landLord.getAddress(),landLord.getAddress(),landLord.getAddress()};
		String postal[]={"",landLord.getPostalTown(),landLord.getPostalTown(),"",
				landLord.getPostalTown(),landLord.getPostalTown(),landLord.getPostalTown(),landLord.getPostalTown()};
		String pCode[]={"",landLord.getPostCode(),landLord.getPostCode(),landLord.getPostCode()
				,"","%$#","tw18 3","t18w he3"};
		for(int i=0;i<hname.length;i++){
			enterAddressManual(hname[i],add[i],postal[i],pCode[i]);
			clickNextButton();
			tellUsErrorVerification();
		}
	}
	
	public void verufyManualAddressSuccess(){
		enterAddressManual(landLord.getHouseName(),landLord.getAddress(),landLord.getPostalTown(),landLord.getPostCode());
		clickNextButton();
		int count=browser.getChildElementsCountByXpath(pageProperties.getProperty("LandLord.addresCountAdded"));
		if(count>0){
			Report.updateTestLog("Property added manually", "PASS");
		}else{
			Report.updateTestLog("Property not added manually", "FAIL");
		}
	}
	
	
	public void enterAddressManual(String houseName,String address,String postal,String pCode){
		browser.wait(5000);
		verifyAndInputById(pageProperties.getProperty("LandLord.manHouseNameText"), "House Name", houseName);
		verifyAndInputById(pageProperties.getProperty("LandLord.manAddOneText"), "Address", address);
		verifyAndInputById(pageProperties.getProperty("LandLord.manPostalText"), "Postal Town", postal);
		verifyAndInputById(pageProperties.getProperty("LandLord.manPostCode"), "Post Code", pCode);
	}
	
	public void clickCancelLink(int number){
		if(number<9){
			browser.wait(5000);
			verifyAndClick(pageProperties.getProperty("LanfLord.calcelLink"), "Cancel link");
		}
	}
	
	
	public void verifyWhatsThisOverLay(){
		verifyAndClick(pageProperties.getProperty("LandLord.whatsThisLink"), "What's This Linl");
		if(browser.isTextPresent("Our landlord packages can help you avoid the unexpected cost of broken boilers")){
			Report.updateTestLog("Over Lay displayed", "PASS");
		}
		else{
			Report.updateTestLog("Over Lay is not displayed", "FAIL");
		}
	}
	
	public void addProperty(){
	int count=browser.getChildElementsCountByXpath(pageProperties.getProperty("LandLord.addresCountAdded"));
		if(count<=8){
			if(browser.isElementVisible(pageProperties.getProperty("LandLord.addPropertyLink")))
				verifyAndClick(pageProperties.getProperty("LandLord.addPropertyLink"), "Add property");
		}
//		if(count<=8){
//			if(browser.isElementVisible(pageProperties.getProperty("LandLord.addPropertyLink"))){
//				browser.click(pageProperties.getProperty("LandLord.addPropertyLink"));	
//				Report.updateTestLog("Add another property lick clicked", "PASS");
//			}else{				
//				Report.updateTestLog("Add another property lick is not displayed", "FAIL");
//			}
//		}else{
//			Report.updateTestLog("Add another property lick is not displayed as 9 properties selected already", "PASS");
//		}
	}
	
	
	//Sprint 8 Selecting package
	public void selectPackage(){		
		landLord=new PriceSheet().priceBuilder(landLord);
	addExistingHomecare();
	verifyAndSelectDropDownBox(pageProperties.getProperty("LandLord.choosePackageDropList"), "Package drop down list", landLord.getPackageCover());
	//selectBoilerType();
	browser.wait(5000);
	if(!browser.getTextByXpath(pageProperties.getProperty("LandLord.NormalPrice")).isEmpty()){
		verifyDiscountedPrice();	
	}
	}
	
	
	//Sorint 8 verify the discounted price
	public void verifyDiscountedPrice(){
		float NormalPrice = Float.parseFloat(browser.getTextByXpath(pageProperties.getProperty("LandLord.NormalPrice")).replace("£", ""));
		float DiscountedPrice = Float.parseFloat(browser.getTextByXpath(pageProperties.getProperty("LandLord.DiscountedPrice")).replace("£", ""));
		LandlordDiscountedPrice = DiscountedPrice;
		float CalculatedPrice;
		CalculatedPrice = (NormalPrice*90)/100;
		
		if(DiscountedPrice == CalculatedPrice){
			Report.updateTestLog("The Discounted price "+CalculatedPrice+" is displayed successfully", "Pass");
		}
		else{
			Report.updateTestLog("The discounted price is not right"+CalculatedPrice, "Fail");
		}
				
	}
	
	//Sprint 8 Verify the boiler make and model combinations Landlord 
		public void verifyBoilerMakeandModel(String BoilerType,String BoilerModel){
			BoilerTypeProfile boilerTypeProfile;
			BoilerType = BoilerType.replace(" ", "").replace("-", "").replace("&", "");
			BoilerModel = BoilerModel.replace(" ", "").replace("-", "").replace("&","");
			//Get Boiler status from the Boiler Type XML
			boilerTypeProfile = new TestDataHelper().boilerTypeProfile(BoilerModel);
			String BoilerPresentStatus = boilerTypeProfile.getBoilerPresent();
			//Check the boiler status
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("GetAnInsuranceQuotePage.BoilerStatus"))){
				if(BoilerPresentStatus.equalsIgnoreCase("w")){
					Report.updateTestLog("Next button is Not Enabled for boiler type "+BoilerType+" and Boiler Model "+BoilerModel, "Pass");
				}
				else{
					Report.updateTestLog("Next button is Not Enabled for boiler type "+BoilerType+" and Boiler Model "+BoilerModel, "Fail");
				}
			}
			else{
				if(BoilerPresentStatus.equalsIgnoreCase("y")){
					Report.updateTestLog("Next button is Enabled for boiler type "+BoilerType+" and Boiler Model "+BoilerModel, "Pass");
				}
				else{
					Report.updateTestLog("Next button is Enabled for boiler type "+BoilerType+" and Boiler Model "+BoilerModel, "Fail");
				}
			}
		}

		//Sprint 8 CR - Function to select the 'Boiler Type and Model'
		public void selectBoilerType(){
			
			//Declaration of array list for Boiler Make and Model
			ArrayList<String> BoilerMake = new ArrayList<String>();
			ArrayList<String> BoilerModel = new ArrayList<String>();
			
			//Getting values from Boiler Make dropdown
			BoilerMake = browser.getFromDropBox("id", pageProperties.getProperty("LandLord.BoilerMake"));
			
			//Loop to select different Boilers
			for(String boilerMake:BoilerMake)
			{
				if(!boilerMake.contains("I don't know")){
					//Select the boiler make from the dropdown
					browser.selectfromDropBox("id", pageProperties.getProperty("LandLord.BoilerMake"), boilerMake);
					
					// Wait time for the combination to load
					browser.wait(3000);
					
					//Getting values from Boiler Model Dropdown
					BoilerModel = browser.getFromDropBox("id", pageProperties.getProperty("LandLord.BoilerModel"));
					
					//Loop to select different Boiler models according to Boiler Make
					for(String boilerType:BoilerModel){
						
						if(!boilerType.contains("Please Select"))
						{
							//Select the boiler Model
							browser.selectfromDropBox("id", pageProperties.getProperty("LandLord.BoilerModel"), boilerType);
							
							//Wait for page to load
							browser.wait(3000);
							if(!boilerType.contains("Don't")&&(!boilerType.contains("don't"))){
								//Calling method to verify the Boiler type and model combination
								verifyBoilerMakeandModel(boilerMake,boilerType);	
							}
						}
					}
				}
			}
			
			//Select default values
			browser.wait(3000);
			browser.selectfromDropBox("id", pageProperties.getProperty("LandLord.BoilerMake"), "Don't know");
			browser.wait(3000);
			browser.selectfromDropBox("id", pageProperties.getProperty("LandLord.BoilerModel"), "Don't know");
			browser.clickWithXpath(pageProperties.getProperty("LandLord.BoilerNext"));
		}

	
	
	//Selecting Add ons
	public double verifyPackagePrice(int index){
		String pagePrice;
		double pageAmount;
		double calPrice=0.00;
		int count=0;
		String postCode=browser.getTextByXpath(pageProperties.getProperty("LandLord.postCode").replace("NUM", ""+index));
		landLord.setPostCode(postCode.substring(postCode.lastIndexOf(',')+1, postCode.length()).trim());		
		new PriceSheet().priceBuilder(landLord);
		for(int i=0;i<=3;i++){
		  for(int j=0;j<=3;j++){
			for(int k=0;k<=3;k++){
				HashMap<Integer,String> applianceNo=new HashMap<Integer,String>();
				applianceNo.put(0, "Please select");
				applianceNo.put(1, "1");
				applianceNo.put(2, "2");
				applianceNo.put(3, "3");				
				selectAddOn(applianceNo.get(i),applianceNo.get(j),applianceNo.get(k));
				browser.wait(500);
				pagePrice=browser.getTextByXpath(pageProperties.getProperty("LandLord.priceLable"));
				pageAmount=Float.parseFloat(pagePrice.substring(1));
				calPrice=landLord.getPackageAmount()+ (i*landLord.getGasFire())+(j*landLord.getGasCooker())+(k*landLord.getGasHob());				
				String strCalPrice=ceilDouble(calPrice+"", "0.00");
				if(pagePrice.substring(1).equals(strCalPrice)){
				//if(pagePrice.contains(Float.toString(calPrice))){
					Report.updateTestLog("GasFire:<b>"+landLord.getGasFire()+ " * "+i+ "</b>GasCooker:<b>" +landLord.getGasCooker()
						+" * "+j+ "</b> GasHob:<b>"+landLord.getGasHob()+" * "+j+ "</b> Actual price:<b>"+strCalPrice+"</b>Price in page<b>"+pagePrice+"</b>", "PASS");
				}else{
					Report.updateTestLog("GasFire:<b>"+landLord.getGasFire()+ " * "+i+ "</b>GasCooker:<b>" +landLord.getGasCooker()
						+" * "+j+ "</b> GasHob:<b>"+landLord.getGasHob()+" * "+j+ "</b> Actual price:<b>"+strCalPrice+"</b>Price in page<b>"+pagePrice+"</b>", "FAIL");
					System.out.println(count+"-"+i+" "+j+" "+k+" --"+pagePrice+"Float Amount:"+strCalPrice);
				count++;				
				}
			}
		  }		
		}
		return calPrice;
	}
	
	
	public void selectMultiPackage(){
		int count=browser.getChildElementsCountByXpath("LandLord.addresCountAdded");
		System.out.println("Child count: "+count);
		boolean completeQuote=false;
		int index=1;
		while(completeQuote==false){			
			setPackageValue(index);
			selectPackage();			
			verifyPackagePrice(index);
			nextProperty();
			if(browser.isElementVisible(pageProperties.getProperty("LandLord.completeButton"))){
				completeQuote=true;				
			}
			index++;
		}
	}
	
	public void selectMultiAddPackage(){
		int count=browser.getChildElementsCountByXpath("LandLord.addresCountAdded");
		System.out.println("Child count: "+count);
		boolean completeQuote=false;
		int index=1;
		while(completeQuote==false){			
			setPackageValue(index);
			selectPackage();
			selectAdd(index);			
			nextProperty();
			if(browser.isElementVisible(pageProperties.getProperty("LandLord.completeButton"))){
				completeQuote=true;				
			}
			index++;
		}
	}
	private void setPackageValue(int index){
		if(index>=6){
			index=index%5;			
		}
		landLord.setPackageCover("index="+index);	
		System.out.println("122 :CoveR: "+landLord.getPackageCover());
	}
	
	public void selectAddOn(String gasFire,String cooker,String gasHob){		
		browser.selectfromDropBox("id", pageProperties.getProperty("LandLord.gasFireDropList"), gasFire);				
		browser.selectfromDropBox("id", pageProperties.getProperty("LandLord.gasCookerDropList"), cooker);				
		browser.selectfromDropBox("id", pageProperties.getProperty("LandLord.gasHobDropList"), gasHob);
		}
	
	public ArrayList<Object> verifyTotalPrice(int ch){
		ArrayList<Object> price=new ArrayList<Object>();		
		int count=browser.getChildElementsCountByXpath(pageProperties.getProperty("LandLord.priceCount"));
		System.out.println("Child count: "+count);
		float monthlyPrice=0.0f;
		float oneTimePrice=0.0f;
		String totalPriceText="";
		for(int i=1;i<=count;i++){
			String priceText=browser.getTextByXpath(pageProperties.getProperty("LandLord.priceTable").replace("PRICE", ""+((i*2)-1)));			
			if(priceText.contains("per month")){
				monthlyPrice=monthlyPrice+Float.parseFloat(priceText.substring(1,priceText.indexOf('\n')));								
			}else{
				oneTimePrice=oneTimePrice+Float.parseFloat(priceText.substring(1,priceText.indexOf('\n')));				
			}					
		}	
		browser.wait(1000);
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandLord.onePriceTotal1"))){
			totalPriceText=browser.getTextByXpath(pageProperties.getProperty("LandLord.onePriceTotal1"));	
			if(totalPriceText.contains(ceilDouble(""+oneTimePrice, "0.00"))){
			//if(totalPriceText.contains(Float.toString(oneTimePrice))){
				Report.updateTestLog("Total one off price displayed <b>Expected price - "+oneTimePrice
						+ "price in page - "+totalPriceText+"</b>" , "PASS");
			}
			else{
				Report.updateTestLog("Total onr off price is not displayed <b>Expected price - "+oneTimePrice
						+ "price in page - "+totalPriceText+"</b>" , "FAIL");
			}
		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandLord.onePriceTotal"))){
			totalPriceText=browser.getTextByXpath(pageProperties.getProperty("LandLord.onePriceTotal"));			
			if(totalPriceText.contains(ceilDouble(""+oneTimePrice, "0.00"))){
			//if(totalPriceText.contains(Float.toString(oneTimePrice))){
				Report.updateTestLog("Total one off price displayed <b>Expected price - "+oneTimePrice
						+ "price in page - "+totalPriceText+"</b>" , "PASS");
			}
			else{
				Report.updateTestLog("Total onr off price is not displayed <b>Expected price - "+oneTimePrice
						+ "price in page - "+totalPriceText+"</b>" , "FAIL");
			}
		}
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandLord.monthPriceTotal"))){			
			totalPriceText=browser.getTextByXpath(pageProperties.getProperty("LandLord.monthPriceTotal"));			
			if(totalPriceText.contains(ceilDouble(""+monthlyPrice, "0.00"))){
			//if(totalPriceText.contains(Float.toString(monthlyPrice))){
				Report.updateTestLog("Total monthly price displayed <b>Expected price - "+monthlyPrice
						+ "price in page - "+totalPriceText+"</b>" , "PASS");
			}
			else{
				Report.updateTestLog("Total monthly price is not displayed <b>Expected price - "+monthlyPrice
						+ "price in page - "+totalPriceText+"</b>" , "FAIL");
			}
		}
		if(ch==0){
		ArrayList<Float> totalPrice=annualAmount();
		price.add(oneTimePrice);
		price.add(monthlyPrice);
		price.add(totalPrice.get(0));
		price.add(totalPrice.get(1));
		}
		return price;
	}
	
	public void selectAdd(int index){
		
		String postCode=browser.getTextByXpath(pageProperties.getProperty("LandLord.postCode").replace("NUM", ""+index));
		landLord.setPostCode(postCode.substring(postCode.lastIndexOf(',')+1, postCode.length()).trim());		
		new PriceSheet().priceBuilder(landLord);
		
		browser.selectfromDropBox("id", pageProperties.getProperty("LandLord.gasFireDropList"), landLord.getGasFireAdd());
		browser.wait(3000);
		if(!browser.getTextByXpath(pageProperties.getProperty("LandLord.NormalPrice")).isEmpty()){
			verifyDiscountedPrice();	
		}
		browser.selectfromDropBox("id", pageProperties.getProperty("LandLord.gasCookerDropList"), landLord.getGasCookerAdd());
		browser.wait(3000);
		if(!browser.getTextByXpath(pageProperties.getProperty("LandLord.NormalPrice")).isEmpty()){
			verifyDiscountedPrice();	
		}
		browser.selectfromDropBox("id", pageProperties.getProperty("LandLord.gasHobDropList"), landLord.getGasHobAdd());
		browser.wait(3000);
		if(!browser.getTextByXpath(pageProperties.getProperty("LandLord.NormalPrice")).isEmpty()){
			verifyDiscountedPrice();	
		}
		
		int i=Integer.parseInt(landLord.getGasFireAdd());
		int j=Integer.parseInt(landLord.getGasCookerAdd());
		int k=Integer.parseInt(landLord.getGasHobAdd());
		float calPrice=landLord.getPackageAmount()+ (i*landLord.getGasFire())+(j*landLord.getGasCooker())+(k*landLord.getGasHob());		
		browser.wait(100);
		String strCalPrice=ceilDouble(calPrice+"", "0.00");
		String pagePrice=browser.getTextByXpath(pageProperties.getProperty("LandLord.priceLable"));
		/*if(pagePrice.contains(strCalPrice)){
			Report.updateTestLog("GasFire:<b>"+landLord.getGasFire()+ " * "+i+ "</b>GasCooker:<b>" +landLord.getGasCooker()
				+" * "+j+ "</b> GasHob:<b>"+landLord.getGasHob()+" * "+k+ "</b> Expected price:<b>"+strCalPrice+"</b>Price in page<b>"+pagePrice+"</b>", "PASS");
		}else{
			Report.updateTestLog("GasFire:<b>"+landLord.getGasFire()+ " * "+i+ "</b>GasCooker:<b>" +landLord.getGasCooker()
				+" * "+j+ "</b> GasHob:<b>"+landLord.getGasHob()+" * "+k+ "</b> Expected price:<b>"+strCalPrice+"</b>Price in page<b>"+pagePrice+"</b>", "FAIL");									
		}*/
	}
	
	public void nextProperty(){		
		verifyAndInputById(pageProperties.getProperty("LandLord.expiryDateText"), "Date text box", landLord.getdueDate());
		verifyAndClick(pageProperties.getProperty("LandLord.nextPropertyButton"), "Next property Button");
	}
	
	public void verifyInvalidDate(){
		packageErrorVerification();
	}
	public void verifyInvalidPackage(){
		packageErrorVerification();
	}
	
	public void clickCompleteQuote(){
		verifyAndClick(pageProperties.getProperty("LandLord.completeButton"), "Confirm my quote button");		
	}
	
	public void editPackage(int number){		
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("LandLord.packageEditLink").replace("number", ""+((number*2)-1)))){
			browser.clickWithXpath(pageProperties.getProperty("LandLord.packageEditLink").replace("number", ""+((number*2)-1)))	;
			Report.updateTestLog("Edit link clicked", "PASS");
		}else{
			Report.updateTestLog("Edit link is not clicked", "FAIL");
		}		
	}
	
	public void clickApplyAll(){		
		//verifyAndClickWithXpath(pageProperties.getProperty("LandLord.applyAllCheck"), "Apply all check box");
	}
	
	public void verifyAfterApplyAll(int count){
		for(int i=1;i<count;i++){			
			addOnCheck(i);			
		}		
	}
	
	
	public void verifyExpiryDateMessage(){
		if(browser.isTextPresent("Please enter the CP12 expiry date for this property.")){
			Report.updateTestLog("Expiry date message displayed", "PASS");
		}else{
			Report.updateTestLog("Expiry date message is not displayed", "FAIL");
		}
	}
	
	public void addOnCheck(int i){
		String fire=browser.getTextByXpath(pageProperties.getProperty("LandLord.gasFireCount").replace("NUM", ""+((i*2)-1))).substring(0, 1);
		String cooker=browser.getTextByXpath(pageProperties.getProperty("LandLord.gasCookerCount").replace("NUM", ""+((i*2)-1))).substring(0, 1);
		String hob=browser.getTextByXpath(pageProperties.getProperty("LandLord.gasHobCount").replace("NUM", ""+((i*2)-1))).substring(0, 1);	
		if(landLord.getGasFireAdd().equals(fire)
				&&landLord.getGasCookerAdd().equals(cooker)
				&&landLord.getGasHobAdd().equals(hob)){
			Report.updateTestLog("Same add-ons entered for next property", "PASS");
		}else{
			Report.updateTestLog("Add-ons are different for next property", "FAIL");
		}
	}
	
	public void verifyAddPropertyLink(){
		int count=browser.getChildElementsCountByXpath(pageProperties.getProperty("LandLord.addresCountAdded"));
		if(count==9){
			if(browser.isElementVisible(pageProperties.getProperty("LandLord.addPropertyGetLink"))){
				Report.updateTestLog("Add property link displayed after 9th property", "FAIL");
			}else{
				Report.updateTestLog("Add property link not displayed after 9th property", "PASS");
			}
		}
		
	}
	
	public void addPropertyfromGetAQuote(){
			verifyAndClick(pageProperties.getProperty("LandLord.addPropertyGetLink"), "Add another property link");					
	}
	
	public void verifySectionOne(){
		verifyIsElementVisibleById(pageProperties.getProperty("LandLord.postCodeText"), "Section one-Tell us");
	}
	public void verifyAmout(double price){
		browser.wait(1000);
		String priceText=browser.getTextByXpath(pageProperties.getProperty("LandLord.onePriceTotal"));
		System.out.println("From page :"+priceText);
		System.out.println("From Function :"+price);
		if(priceText.contains(Double.toString(price))){
			Report.updateTestLog("Total price displayed", "PASS");
		}else
		{
			Report.updateTestLog("Total price is not displayed", "FAIL");
		}
	}
	
	public void verfifyGetAQuote(){
		if(browser.isTextPresent("Your Quote")){
			Report.updateTestLog("GetAQuote Section displayed", "PASS");
		}else{
		//	Report.updateTestLog("GetAQuote Section is not displayed", "FAIL");
		}browser.wait(1000);
		ArrayList<String> link=new ArrayList<String>();
		
		link.add(pageProperties.getProperty("LandLord.editMyQuoteLink"));
		link.add(pageProperties.getProperty("LandLord.orderNowLink"));	
		for(int i=0;i<link.size();i++){
			linkVerification(link.get(i),"Link");
		}
		int count=browser.getChildElementsCountByXpath(pageProperties.getProperty("LandLord.addresCountAdded"));
		String packageName="";
		HashSet<String> packages=new HashSet<String>();
		for(int i=1;i<=count;i++){
			packageName=browser.getTextByXpath(pageProperties.getProperty("LandLord.packageName").replace("NUMBER", ""+((i*2)-1)));
			System.out.println(packageName);
			packages.add(packageName);
		}
		for(String text:packages){
			String termsLink="";
			String insuranceLink="";
			if(text.startsWith("HomeCare 100")){
			 termsLink=pageProperties.getProperty("LandLord.termsAndConditionLink")
					.replace("PACKAGE", text.substring(0,12).replace(" ", ""));
			 insuranceLink=pageProperties.getProperty("LandLord.aboutInsuranceLink")
					.replace("PACKAGE", text.substring(0,12).replace(" ", ""));
			}else if(text.contains("HomeCare ")){
				termsLink=pageProperties.getProperty("LandLord.termsAndConditionLink1")
						.replace("PACKAGE", text.substring(0,12).replace(" ", ""));
				insuranceLink=pageProperties.getProperty("LandLord.aboutInsuranceLink1")
						.replace("PACKAGE", text.substring(0,12).replace(" ", ""));
			}else if(text.startsWith("Gas")){
				termsLink=pageProperties.getProperty("LandLord.termsAndConditionLink1")
						.replace("PACKAGE", "CP12");
				insuranceLink=pageProperties.getProperty("LandLord.aboutInsuranceLink1")
						.replace("PACKAGE", "CP12");
			}
			linkVerification(termsLink,"Link of "+text);
			linkVerification(insuranceLink,"Link of "+text);			
		}		
	}
	
	private void linkVerification(String link,String name){
		//verifyIsElementVisibleWithXpath(link, name);
	}
	
	public void clickEditMyQuote(){
		verifyAndClickWithXpath(pageProperties.getProperty("LandLord.editMyQuoteLink"), "Edit My quote");
	}
	public void clickOrderNow(){
		browser.wait(5000);
		float DisplayedMonthlyPrice;
		if(browser.isElementVisibleWithXpath(browser.getTextByXpath(pageProperties.getProperty("LandLord.DisplayedMonthlyPrice")))){
			DisplayedMonthlyPrice = Float.parseFloat(browser.getTextByXpath(pageProperties.getProperty("LandLord.DisplayedMonthlyPrice")).replace("£", ""));
			if(DisplayedMonthlyPrice == LandlordDiscountedPrice){
				Report.updateTestLog("The Monthly price displayed is same as Discounted Price - "+DisplayedMonthlyPrice, "Pass");
			}
			else{
				Report.updateTestLog("The Monthly price "+DisplayedMonthlyPrice+" displayed is not same as Discounted Price "+LandlordDiscountedPrice, "Pass");
			}
		}
		verifyAndClickWithXpath(pageProperties.getProperty("LandLord.orderNowLink"), "Order now Link");
	}
	public void logout(){
		verifyAndClickWithLinkText(pageProperties.getProperty("LandLord.logout"), "Logout Link");
	}
	
	
	public void endMultiPackage(){
		int count=browser.getChildElementsCountByXpath("LandLord.addresCountAdded");
		System.out.println("Child count: "+count);
		
//		int index=1;			
//			setPackageValue(index);
			selectPackage();			
			endPackagePrice();					
		//	index++;
		
	}
	private ArrayList<Float> annualAmount(){
		int count=browser.getChildElementsCountByXpath(pageProperties.getProperty("LandLord.addresCountAdded"));
		float totalAnnual=0.0f;
		float totalAnnualCredit=0.0f;
	for(int i=1;i<=count;i++){
		String postCode=browser.getTextByXpath(pageProperties.getProperty("LandLord.postCode").replace("NUM", ""+i));
		landLord.setPostCode(postCode.substring(postCode.lastIndexOf(',')+1, postCode.length()).trim());		
		String packCover=browser.getTextByXpath(pageProperties.getProperty("LandLord.packageName").replace("NUMBER", ""+((i*2)-1)));		
		if(packCover.contains("HomeCare 100"))
			landLord.setPackageCover("index=2");
		if(packCover.contains("HomeCare 200"))
			landLord.setPackageCover("index=3");
		if(packCover.contains("HomeCare 300"))
			landLord.setPackageCover("index=4");
		if(packCover.contains("HomeCare 400"))
			landLord.setPackageCover("index=5");
		if(packCover.contains("Gas"))
			landLord.setPackageCover("index=1");
				
		new PriceSheet().priceBuilder(landLord);
				
		int addon=Integer.parseInt(browser.getTextByXpath(pageProperties.getProperty("LandLord.gasFireCount").replace("NUM", ""+((i*2)-1))).substring(0, 1));
		int addon1=Integer.parseInt(browser.getTextByXpath(pageProperties.getProperty("LandLord.gasCookerCount").replace("NUM", ""+((i*2)-1))).substring(0, 1));
		int addon2=Integer.parseInt(browser.getTextByXpath(pageProperties.getProperty("LandLord.gasHobCount").replace("NUM", ""+((i*2)-1))).substring(0, 1));
		
		totalAnnual=totalAnnual+landLord.getAnnualDB()+(addon*landLord.getAnnualFire())+(addon1*landLord.getAnnualCooker())+(addon2*landLord.getAnnualHob());
		totalAnnualCredit=totalAnnualCredit+(landLord.getAnnualDB()+6)+(addon*landLord.getAnnualFire())+(addon1*landLord.getAnnualCooker())
				+(addon2*landLord.getAnnualHob());
		}
		
	ArrayList<Float> totalPrice=new ArrayList<Float>();
	totalPrice.add(totalAnnual);
	totalPrice.add(totalAnnualCredit);
	return totalPrice;
	
	}
	public double endPackagePrice(){
		
		double calPrice=0.00;
		
		//String postCode=browser.getTextByXpath(pageProperties.getProperty("LandLord.postCode").replace("NUM", ""+index));
		//landLord.setPostCode(postCode.substring(postCode.lastIndexOf(',')+1, postCode.length()).trim());		
		new PriceSheet().priceBuilder(landLord);
		for(int i=0;i<=3;i++){
		  for(int j=0;j<=3;j++){
			for(int k=0;k<=3;k++){
				for(int l=0;l<=3;l++){
					for(int m=0;m<=3;m++){
						for(int n=0;n<=3;n++){
				HashMap<Integer,String> applianceNo=new HashMap<Integer,String>();
				applianceNo.put(0, "Please select");
				applianceNo.put(1, "1");
				applianceNo.put(2, "2");
				applianceNo.put(3, "3");				
				selectAddOn(applianceNo.get(i),applianceNo.get(j),applianceNo.get(k));
				browser.click(pageProperties.getProperty("LandLord.nextPropertyButton"));				
				browser.selectfromDropBox("id",pageProperties.getProperty("LandLord.choosePackageDropList"),  landLord.getPackageCover());				
				selectAddOn(applianceNo.get(l),applianceNo.get(m),applianceNo.get(n));
				browser.wait(1000);
				browser.click(pageProperties.getProperty("LandLord.nextPropertyButton"));
				browser.click(pageProperties.getProperty("LandLord.completeButton"));				
				verifyTotalPrice(1);
				editPackage(1);
				
			}}}}
		  }		
		}
		return calPrice;
	}
}
