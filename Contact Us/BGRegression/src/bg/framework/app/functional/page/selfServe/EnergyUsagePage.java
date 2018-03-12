package bg.framework.app.functional.page.selfServe;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.reFactoring.RegistrationPage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

import java.util.ArrayList;
import java.util.Properties;

public class EnergyUsagePage extends BasePage {
    private final static String FILE_NAME = "resources/selfServe/EnergyUsage.Properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();

    
    
    public static void main(String ar[])
    {
    	System.out.println(pageProperties.getProperty(
	                "EnergyPage.link"));
    }
    
    public void navigateToReduceBill() {
        
    	verifyAndClickWithLinkText("Energy usage", "Energy usage Link");
    	browser.wait(3000);
    	verifyAndClickWithLinkText("Reduce your bill", "Energy usage Link");
    
    }
    
    public void navigateToEnergyLink() {
        
    	verifyAndClickWithLinkText("Energy usage", "Energy usage Link");
    	browser.wait(3000);
    
    }
 
    public void reduceYourBillValidation() {
	        
    	//verifyPageTitle("");
		String Heading=browser.getText(pageProperties.getProperty("EnergyPage.heading"));
	 	System.out.println("Senthil:"+Heading);
	 	if(Heading.equals("Reduce your bill"))
	 	{
	 		Report.updateTestLog("Expected Heading is available:" +Heading, "PASS");
	 	}else
	 	{
	 		Report.updateTestLog("Expected Heading is not available:" +Heading, "FAIL");
	 	}
    	String Slider=browser.getText(pageProperties.getProperty("EnergyPage.SliderValue"));
    	System.out.println("Senthil:"+Slider);
    	if(Slider.equals("12%"))
    	{
    		Report.updateTestLog("Expected value is available:" +Slider, "PASS");
    	}else
    	{
    		Report.updateTestLog("Expected value is not available:" +Slider, "FAIL");
    	}
    	
    	String kwh=browser.getTextByXpath(pageProperties.getProperty("EnergyPage.kwh"));
    	System.out.println("Senthil:"+kwh);
    	if(kwh.equals("kWh / year"))
    	{
    		Report.updateTestLog("Expected value is available:" +kwh, "PASS");
    	}else
    	{
    		Report.updateTestLog("Expected value is not available:" +kwh, "FAIL");
    	}
    	
    	String year=browser.getTextByXpath(pageProperties.getProperty("EnergyPage.AYear"));
    	System.out.println("Senthil:"+year);
    	if(year.equals("A year"))
    	{
    		Report.updateTestLog("Expected value is available:" +year, "PASS");
    	}else
    	{
    		Report.updateTestLog("Expected value is not available:" +year, "FAIL");
    	}
    			
    }
    public void dragAndDrop() {
        
    	String kwhValue=browser.getText("gasSaving1");
    	int kwh1=Integer.parseInt(kwhValue);
    	String year=browser.getText("gasSaving2");
    	int Year1=Integer.parseInt(year);
    	verifyAndClick(pageProperties.getProperty("EnergyPage.DragButton"), "Drag Button");
    	String Slider=browser.getText(pageProperties.getProperty("EnergyPage.SliderValue"));
    	if(Slider.equals("13%"))
    	{
    		Report.updateTestLog("Expected value is available:" +Slider, "PASS");
    	}else
    	{
    		Report.updateTestLog("Expected value is not available:" +Slider, "FAIL");
    	}
    	kwhValue=browser.getText("gasSaving1");
    	int kwh2=Integer.parseInt(kwhValue);
    	
    	if(kwh1<kwh2)
    	{
    		Report.updateTestLog("Trag and Drop validation is Success for Kwh/Year: " +kwh1+"<"+kwh2+"", "PASS");
    	}else
    	{
    		Report.updateTestLog("Trag and Drop validation is Failure: " +kwh1+"<"+kwh2+"", "FAIL");
    	}
    	year=browser.getText("gasSaving2");
    	int Year2=Integer.parseInt(year);
    	if(Year1<Year2)
    	{
    		Report.updateTestLog("Trag and Drop validation is Success for Year: " +Year1+"<"+Year2+"", "PASS");
    	}else
    	{
    		Report.updateTestLog("Trag and Drop validation is Failure: " +Year1+"<"+Year2+"", "FAIL");
    	}
    }
    
    public void ReduceBillNonES() {
    	    	
    	String Heading=browser.getText(pageProperties.getProperty("EnergyPage.heading"));
	 	System.out.println("Senthil:"+Heading);
	 	if(Heading.equals("Reduce your bill"))
	 	{
	 		Report.updateTestLog("Expected Heading is available:" +Heading, "PASS");
	 	}else
	 	{
	 		Report.updateTestLog("Expected Heading is not available:" +Heading, "FAIL");
	 	}
    	verifyIsElementVisibleWithXpath("//*[@id='rybNotEligible']/div[2]/div/div[2]/button", "Find Out More about Energy Smart Option Button");
    	
    }
    

    
 public void esClose() {
    	
	 verifyAndClickWithXpath(pageProperties.getProperty("EnergyPage.Close"), "Close Button");
	 try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	 verifyAndClickWithXpath(pageProperties.getProperty("EnergyPage.Open"), "Option Button");
    	
    }
 
    public void energyUsageES() {
    	
    	int Timedisplay=browser.getChildElementsCountByXpath(pageProperties.getProperty("EnergyPage.DropData"));
    	if(Timedisplay==2)
    	{
    		Report.updateTestLog("Expected Drop Down Count is available", "PASS");
	 	}else
	 	{
	 		Report.updateTestLog("Expected Drop Down Count is available", "FAIL");
	 	}
    	
    	String drop1=browser.getTextByXpath(pageProperties.getProperty("EnergyPage.DropData1"));
    	if(drop1.equals("Monthly"))
    	{
    		Report.updateTestLog("Expected Drop Down data is available: "+drop1, "PASS");
	 	}else
	 	{
	 		Report.updateTestLog("Expected Drop Down data is available: "+drop1, "FAIL");
	 	}
    	String drop2=browser.getTextByXpath(pageProperties.getProperty("EnergyPage.DropData2"));
    	if(drop1.equals("Quarterly"))
    	{
    		Report.updateTestLog("Expected Drop Down data is available: "+drop2, "PASS");
	 	}else
	 	{
	 		Report.updateTestLog("Expected Drop Down data is available: "+drop2, "FAIL");
	 	}
    	verifyIsElementVisibleWithXpath(pageProperties.getProperty("EnergyPage.DropDownBillDate"), "Bill Date Drop Down is available");
    	String billdate=browser.getTextByXpath(pageProperties.getProperty("EnergyPage.DropDownBillDate1"));
    	if(billdate.equals("Latest"))
    	{
    		Report.updateTestLog("Default Text is available "+billdate, "PASS");
	 	}else
	 	{
	 		Report.updateTestLog("Default Text is available "+billdate, "FAIL");
	 	}
    	verifyIsElementVisibleWithXpath(pageProperties.getProperty("EnergyPage.EnergyUnit"), "Bill Date Drop Down is available");
    	String EUnit=browser.getTextByXpath(pageProperties.getProperty("EnergyPage.EnergyUnit1"));
    	if(EUnit.equals("kWh"))
    	{
    		Report.updateTestLog("Expected Text is available "+EUnit, "PASS");
	 	}else
	 	{
	 		Report.updateTestLog("Expected Text is available "+EUnit, "FAIL");
	 	}
    	String EUnit1=browser.getTextByXpath(pageProperties.getProperty("EnergyPage.EnergyUnit2"));
    	if(EUnit1.contains("Cost"))
    	{
    		Report.updateTestLog("Expected Text is available "+EUnit1, "PASS");
	 	}else
	 	{
	 		Report.updateTestLog("Expected Text is available "+EUnit1, "FAIL");
	 	}
    }
    
    public void energyUsageSubmit() {
	    verifyAndClick(pageProperties.getProperty("EnergyPage.ComapreCheckBox"), "Compare CheckBox");
		verifyAndClick(pageProperties.getProperty("EnergyPage.ShowUse"), "Show Use Button");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		verifyIsElementVisibleWithXpath(pageProperties.getProperty("EnergyPage.graph"), "Graph Display");
    }
    
    public void tableView() {
	    verifyAndClick(pageProperties.getProperty("EnergyPage.table"), "Table View Button");
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    verifyIsElementVisibleWithXpath(pageProperties.getProperty("EnergyPage.tableView"), "Table View");
		
    }
    
}