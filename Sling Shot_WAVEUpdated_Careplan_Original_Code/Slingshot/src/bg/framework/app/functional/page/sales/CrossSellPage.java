package bg.framework.app.functional.page.sales;

import java.util.Properties;

import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;

public class CrossSellPage extends BasePage {
	  private final static String FILE_NAME = "resources/sales/CrossSell.properties";
	    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	public void enterHomecareDetails(Acquisition acquisition)
	{
		verifyAndInputById(pageProperties.getProperty("CrossSell.Telephone"),"ENTER TELEPHONE NO","0123456789" );
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Next1"),"Click Next Button");
		
		
		verifyAndInputById(pageProperties.getProperty("CrossSell.AccNum"),"ENTER Acct Num",acquisition.getPaymentAccountNumber() );
		verifyAndInputById(pageProperties.getProperty("CrossSell.Sort1"),"ENTER code1",acquisition.getSortCode1() );
		verifyAndInputById(pageProperties.getProperty("CrossSell.Sort2"),"ENTER code2",acquisition.getSortCode2() );
		verifyAndInputById(pageProperties.getProperty("CrossSell.Sort3"),"ENTER code3",acquisition.getSortCode3());
		verifyAndInputById(pageProperties.getProperty("CrossSell.AccName"),"ENTER Name",acquisition.getAccountName());
		verifyAndSelectDropDownBox(pageProperties.getProperty("CrossSell.MonthName"),"enter pay day",acquisition.getPayDay());
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Next2"),"Click Next Button");
		
		
		//verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Next3"),"CrossSell.Next3");
		//verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.TermsandCondition"),"Terms & conditions");
		//verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Next3"),"CrossSell.Next3");
	}
	
	public void enterNectaroptionone()
	{
	verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Nectar1"),"Click nectar option");
	verifyAndInputById(pageProperties.getProperty("CrossSell.cardText"),"ENTER card no","11111111111");
	//browser.wait(5000);
	verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.nectarTermsandcondition"),"Click Terms & Condition");
	}

	public void enterNectaroptiontwo()
	{
	verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Nectar2"),"Click nectar option");
	verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.nectarTermsandcondition"),"Click Terms & Condition");
	}
	
	public void enterNectaroptionthree()
	{
	verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Nectar3"),"Click nectar option");
	verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.nectarTermsandcondition"),"Click Terms & Condition");
	}
	
	public void enterNectaroptionfour()
	{
	verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Nectar4"),"Click nectar option");
	}
	
	public void enterConfirmOrder()
	{
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Next3"),"CrossSell.Next3");
		browser.wait(5000);
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.TermsandCondition"),"Terms & conditions");
		browser.wait(7000);
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Next4"),"CrossSell.Next3");
		browser.wait(7000);
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.Confirm")," Confirm button");
		
	}
	
	public void verifyHomecarehundred()
	
	{
		System.out.println("100");
		verifyIsTextPresent("You have ordered HomeCare 100","Home care 100 confirmation");	
	}
	
public void verifyHomecaretwohundred()
	
	{
		verifyIsTextPresent("You have ordered HomeCare 200","Home care 200 confirmation");	
	}

public void verifyHomecarethreehundred()

{
	verifyIsTextPresent("You have ordered HomeCare 300","Home care 300 confirmation");	
}

public void verifyHomecarefourhundred()

{
	verifyIsTextPresent("You have ordered HomeCare 400","Home care 400 confirmation");	
}

public void navigateHomecaretwohundred()
{
	verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.clickHomecare200"),"Navigate to Home care 200");	
	verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.ClickOrder"),"Navigate to Home care 200");
}

public void navigateHomecarethreehundred()
{
	verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.clickHomecare300"),"Navigate to Home care 300");
	verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.ClickOrder"),"Navigate to Home care 300");
}

public void navigateHomecarefourhundred()
{
	verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.clickHomecare400"),"Navigate to Home care 400");
	verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.ClickOrder"),"Navigate to Home care 400");
}
public void switchToElectricity()
{
	//verifyAndClick(pageProperties.getProperty("CrossSell.NoThanks"), "NoThanksEsmart");
	verifyAndClick(pageProperties.getProperty("CrossSell.SwitchNowElec"), "SwitchNowElectricity");
	}

public void switchToGas()
{
	if(browser.isElementVisible(pageProperties.getProperty("CrossSell.SwitchNowGas")))
	{
	//verifyAndClick(pageProperties.getProperty("CrossSell.NoThanks"), "NoThanksEsmart");
	verifyAndClick(pageProperties.getProperty("CrossSell.SwitchNowGas"), "SwitchNowGas");
	}
	else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("CrossSell.SwitchNowGas2")))
	{
		verifyAndClickWithXpath(pageProperties.getProperty("CrossSell.SwitchNowGas2"), "SwitchNowGas");
	}
}
}
