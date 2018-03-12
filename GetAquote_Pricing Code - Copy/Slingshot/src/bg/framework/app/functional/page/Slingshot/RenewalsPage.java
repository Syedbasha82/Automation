package bg.framework.app.functional.page.Slingshot;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import bg.framework.app.functional.entities.DirectDebit;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.RunQTP;

public class RenewalsPage extends BasePage {
	private final static String FILE_NAME1 = "resources/Slingshot/Renewals.Properties";
	private static Properties PageProperties = new PropertyLoader(FILE_NAME1).load();
	private static String Address;
	public static int dialsCount;

	public void energyPlanRenewalLink() {
		Address=browser.getTextByXpath(PageProperties.getProperty("Renewals.AccOverAddress"));
		System.out.println("Address in the Account Overview Screen: " + Address);
		verifyIsElementVisibleWithXpath(PageProperties.getProperty("Renewals.EnergyPlanDueLink"),"Your energy plan is due for renewal Link");
		verifyAndClickWithXpath(PageProperties.getProperty("Renewals.EnergyPlanDueLink"),"Your energy plan is due for renewal Link");
	}

	public void energyPlanRenewalPage() {
		verifyPageTitle("Energy plan renewal");
		verifyIsTextPresent("It's time to renew your energy plan");
		verifyIsElementVisibleWithXpath(PageProperties.getProperty("Renewals.RequestacallbackLink"),"Request a call back Link");
		verifyAndClickWithXpath(PageProperties.getProperty("Renewals.RequestacallbackLink"),"Request a call back Link");
		browser.wait(3000);
		verifyIsTextPresent("Request a call back");
		browser.browserBack();
		verifyAndClickWithXpath(PageProperties.getProperty("Renewals.Back"),"Back Link in Promo Page");
		browser.wait(3000);
		verifyPageTitle("Account overview");
		browser.browserBack();
		browser.wait(3000);
		verifyIsElementVisibleWithXpath(PageProperties.getProperty("Renewals.ViewFixedPriceLink"),"View Fixed Price Energy Plans Link");
		verifyAndClickWithXpath(PageProperties.getProperty("Renewals.ViewFixedPriceLink"),"View Fixed Price Energy Plans Link");
		browser.wait(7000);
		verifyPageTitle("Renewal quote");
		verifyIsTextPresent("Renewal quote");
	}

	public void energyPlanRenewalQuote(UserProfile userProfile, String Payment1CRM) {
		verifyIsTextPresent("Protect your business from future price rises with a fixed price energy plan."); 
		adressTypeEndDateDetails(userProfile, Payment1CRM);
		verifyIsTextPresent("I don't want to renew");
		verifyIsTextPresent("Renewal offer based on your current energy plan"); 
	}

	public void adressTypeEndDateDetails(UserProfile userProfile, String Payment1CRM)
	{
		String AccNum=browser.getTextByXpath(PageProperties.getProperty("Renewals.AccNum"));
		System.out.println(AccNum + "\n" + userProfile.getAccNumber());
		if(AccNum.equals(userProfile.getAccNumber()))
		{
			Report.updateTestLog("Account Number" + AccNum + " is displayed correctly", "PASS");
		}
		else
			Report.updateTestLog("Account Number" + AccNum + " is NOT displayed correctly", "FAIL");
		String AddressinQuote="Site address: " + browser.getTextByXpath(PageProperties.getProperty("Renewals.Address"));
		System.out.println(AddressinQuote + "\n" + Address);
		if(AddressinQuote.equals(Address))
		{
			Report.updateTestLog("Address " + AddressinQuote + " is displayed correctly", "PASS");
		}
		else
			Report.updateTestLog("Address " + AddressinQuote + " is NOT displayed correctly", "FAIL");
		String AccNumcol=browser.getTextByXpath(PageProperties.getProperty("Renewals.AccNumCol"));
		System.out.println(AccNumcol + "\n" + userProfile.getAccNumber());
		if(AccNumcol.equals(userProfile.getAccNumber()))
		{
			Report.updateTestLog("Account Number above the Payment Type " + AccNum + " is displayed correctly", "PASS");
		}
		else
			Report.updateTestLog("Account Number above the Payment Type " + AccNum + " is NOT displayed correctly", "FAIL");
		String paymentType=browser.getTextByXpath(PageProperties.getProperty("Renewals.Payment"));
		Report.updateTestLog("Payment Type in Screen: "+paymentType + "Payment Type  in CRM: "+Payment1CRM, paymentType.equalsIgnoreCase(Payment1CRM)?"PASS":"FAIL");
		verifyIsTextPresent("plan end date:");
	}

	public void oneYearFixedRate(UserProfile userProfile, String UnitCharges, String SCCharges, int StandChargeValue1CRM, int UnitRate1CRM) {
		verifyIsTextPresent("1 year fixed rate");
		verifyIsTextPresent("price breakdown");
		String AccNum1=browser.getTextByXpath(PageProperties.getProperty("Renewals.AccNum1"));
		System.out.println(AccNum1 + "\n" + userProfile.getAccNumber());
		if(AccNum1.equals(userProfile.getAccNumber()))
		{
			Report.updateTestLog("Account Number " + AccNum1 + " is displayed correctly", "PASS");
		}
		else
			Report.updateTestLog("Account Number " + AccNum1 + " is NOT displayed correctly", "FAIL");
		if(UnitCharges.equals("Yes"))
		{
			if(browser.getTextByXpath(PageProperties.getProperty("Renewals.UnitCharge1")).equals("Unit Charge"))
			{
				Report.updateTestLog("Type is displayed correctly as Unit Charge ", "PASS");
			}
			else
				Report.updateTestLog("Type is NOT displayed correctly as Unit Charge", "FAIL");
			String UnitRate1=browser.getTextByXpath(PageProperties.getProperty("Renewals.UnitRate1"));
			UnitRate1=UnitRate1.replace("p /kWh","");
			Float UnitRateValue1 = Float.parseFloat(UnitRate1);
			int UnitRatesValuesScreen1=Math.round(UnitRateValue1);
			System.out.println(UnitRate1 + "\n" + UnitRatesValuesScreen1);
			Report.updateTestLog("Unit Rate in Screen: "+UnitRatesValuesScreen1 + " Unit Rate in CRM: "+UnitRate1CRM, UnitRatesValuesScreen1==(UnitRate1CRM)?"PASS":"FAIL");
		}
		if(browser.getTextByXpath(PageProperties.getProperty("Renewals.EstAnnualConsump1")).equals("Estimated annual consumption:"))
		{
			Report.updateTestLog("Estimated Annual Consumption Text is displayed correctly", "PASS");
		}
		else
			Report.updateTestLog("Estimated Annual Consumption Text is NOT displayed correctly", "FAIL");
		/*String EstAnnualConsumpValue1=browser.getTextByXpath(PageProperties.getProperty("Renewals.EstAnnualConsumpValue1"));
			System.out.println(EstAnnualConsumpValue1 + "\n" + EstAnnualConsumpValue1CRM);
			Report.updateTestLog("Estimated Annual Consumption Value in Screen: "+EstAnnualConsumpValue1 + " Estimated Annual Consumption Value in CRM: "+EstAnnualConsumpValue1CRM, EstAnnualConsumpValue1.equalsIgnoreCase(EstAnnualConsumpValue1CRM)?"PASS":"FAIL");*/
		if(SCCharges.equals("Yes"))
		{
			if(browser.getTextByXpath(PageProperties.getProperty("Renewals.StandCharge1")).equals("Standing charge:"))
			{
				Report.updateTestLog("Standing Charge Text is displayed correctly", "PASS");
			}
			else
				Report.updateTestLog("Standing Charge Text is NOT displayed correctly", "FAIL");
			String StandChargeValue1=browser.getTextByXpath(PageProperties.getProperty("Renewals.StandChargeValue1"));
			StandChargeValue1=StandChargeValue1.replace("p / day","");
			Float StandChargeValues1 = Float.parseFloat(StandChargeValue1);
			int StandChargeValuesScreen1=Math.round(StandChargeValues1);
			System.out.println(StandChargeValuesScreen1 + "\n" + StandChargeValue1CRM);
			Report.updateTestLog("Standing Charge Value in Screen: "+StandChargeValuesScreen1 + " Standing Charge Value in CRM: "+StandChargeValue1CRM, StandChargeValuesScreen1==(StandChargeValue1CRM)?"PASS":"FAIL");
			browser.wait(5000);
			verifyAndClickWithXpath(PageProperties.getProperty("Renewals.SCWhatsthis1"), "SCWhatsthis1");
			verifyIsTextPresent("There is a daily charge for the upkeep of your meter.");
			verifyAndClickWithXpath(PageProperties.getProperty("Renewals.SCWhatsthisClose1"), "SCWhatsthis1 Close Button");
		}
		verifyAndClickWithXpath(PageProperties.getProperty("Renewals.Terms&Cond1"),"Terms & Condition1");
		browser.wait(3000);
		Report.updateTestLog("Terms & Cond1 Link in browser: "+ browser.getURL() + "Terms & Cond1 Link as per SPEC: "+ "http://www.britishgas.co.uk/business/terms-and-conditions", browser.getURL().equalsIgnoreCase("http://www.britishgas.co.uk/business/terms-and-conditions")?"PASS":"FAIL");
		browser.browserBack();
		browser.wait(3000);
		String EstAnnualPrice1=browser.getTextByXpath(PageProperties.getProperty("Renewals.EstAnnualPrice1"));
		EstAnnualPrice1=EstAnnualPrice1.substring(1);
		if(EstAnnualPrice1.contains(","))
		{
			EstAnnualPrice1 = EstAnnualPrice1.replaceFirst(",", "");
		}
		System.out.println(EstAnnualPrice1 + "\n");
		Float EstAnnualPrices1 = Float.parseFloat(EstAnnualPrice1);
		int EstAnnualPrice1Screen=Math.round(EstAnnualPrices1);
		verifyDataThroughQTP(userProfile,EstAnnualPrice1Screen);
		//	Report.updateTestLog("Standing Charge Value in Screen: "+EstAnnualPrice1 + " Standing Charge Value in CRM: "+EstAnnualPrice1CRM, EstAnnualPrice1.equalsIgnoreCase(EstAnnualPrice1CRM)?"PASS":"FAIL");
	}

	public void twoYearFixedRate(UserProfile userProfile, String UnitCharges, String SCCharges, int StandChargeValue2CRM, int UnitRate2CRM) {
		verifyIsTextPresent("2 year fixed rate");
		verifyIsTextPresent("price breakdown");
		String AccNum2=browser.getTextByXpath(PageProperties.getProperty("Renewals.AccNum2"));
		System.out.println(AccNum2 + "\n" + userProfile.getAccNumber());
		if(AccNum2.equals(userProfile.getAccNumber()))
		{
			Report.updateTestLog("Account Number" + AccNum2 + " is displayed correctly", "PASS");
		}
		else
			Report.updateTestLog("Account Number" + AccNum2 + " is NOT displayed correctly", "FAIL");
		if(UnitCharges.equals("Yes"))
		{
			if(browser.getTextByXpath(PageProperties.getProperty("Renewals.UnitCharge2")).equals("Unit Charge"))
			{
				Report.updateTestLog("Type is displayed correctly as Unit Charge ", "PASS");
			}
			else
				Report.updateTestLog("Type is NOT displayed correctly as Unit Charge", "FAIL");
			String UnitRate2=browser.getTextByXpath(PageProperties.getProperty("Renewals.UnitRate2"));
			UnitRate2=UnitRate2.replace("p /kWh","");
			Float UnitRateValue2 = Float.parseFloat(UnitRate2);
			int UnitRatesValuesScreen2=Math.round(UnitRateValue2);
			System.out.println(UnitRate2 + "\n" + UnitRatesValuesScreen2);
			Report.updateTestLog("Unit Rate in Screen: "+UnitRatesValuesScreen2 + " Unit Rate in CRM: "+UnitRate2CRM, UnitRatesValuesScreen2==(UnitRate2CRM)?"PASS":"FAIL");
		}
		if(browser.getTextByXpath(PageProperties.getProperty("Renewals.EstAnnualConsump2")).equals("Estimated annual consumption:"))
		{
			Report.updateTestLog("Estimated Annual Consumption Text is displayed correctly", "PASS");
		}
		else
			Report.updateTestLog("Estimated Annual Consumption Text is NOT displayed correctly", "FAIL");

		/*String EstAnnualConsumpValue1=browser.getTextByXpath(PageProperties.getProperty("Renewals.EstAnnualConsumpValue1"));
		System.out.println(EstAnnualConsumpValue1 + "\n" + EstAnnualConsumpValue1CRM);
		Report.updateTestLog("Estimated Annual Consumption Value in Screen: "+EstAnnualConsumpValue1 + " Estimated Annual Consumption Value in CRM: "+EstAnnualConsumpValue1CRM, EstAnnualConsumpValue1.equalsIgnoreCase(EstAnnualConsumpValue1CRM)?"PASS":"FAIL");*/
		if(SCCharges.equals("Yes"))
		{
			if(browser.getTextByXpath(PageProperties.getProperty("Renewals.StandCharge2")).equals("Standing charge:"))
			{
				Report.updateTestLog("Standing Charge Text is displayed correctly", "PASS");
			}
			else
				Report.updateTestLog("Standing Charge Text is NOT displayed correctly", "FAIL");
			String StandChargeValue2=browser.getTextByXpath(PageProperties.getProperty("Renewals.StandChargeValue2"));
			StandChargeValue2=StandChargeValue2.replace("p / day","");
			Float StandChargeValues2 = Float.parseFloat(StandChargeValue2);
			int StandChargeValuesScreen2=Math.round(StandChargeValues2);
			System.out.println(StandChargeValuesScreen2+ "\n" + StandChargeValue2CRM);
			Report.updateTestLog("Standing Charge Value in Screen: "+StandChargeValuesScreen2 + " Standing Charge Value in CRM: "+StandChargeValue2CRM, StandChargeValuesScreen2==(StandChargeValue2CRM)?"PASS":"FAIL");
			browser.wait(5000);
			verifyAndClickWithXpath(PageProperties.getProperty("Renewals.SCWhatsthis2"), "SCWhatsthis2");
			verifyIsTextPresent("There is a daily charge for the upkeep of your meter.");
			verifyAndClickWithXpath(PageProperties.getProperty("Renewals.SCWhatsthisClose2"), "SCWhatsthis2 Close Button");
		}
		verifyAndClickWithXpath(PageProperties.getProperty("Renewals.Terms&Cond2"),"Terms & Condition1");
		browser.wait(3000);
		Report.updateTestLog("Terms & Cond1 Link in browser: "+ browser.getURL() + "Terms & Cond1 Link as per SPEC: "+ "http://www.britishgas.co.uk/business/terms-and-conditions", browser.getURL().equalsIgnoreCase("http://www.britishgas.co.uk/business/terms-and-conditions")?"PASS":"FAIL");
		browser.browserBack();
		browser.wait(3000);
		String EstAnnualPrice2=browser.getTextByXpath(PageProperties.getProperty("Renewals.EstAnnualPrice2"));
		EstAnnualPrice2=EstAnnualPrice2.substring(1);
		if(EstAnnualPrice2.contains(","))
		{
			EstAnnualPrice2 = EstAnnualPrice2.replaceFirst(",", "");
		}
		System.out.println(EstAnnualPrice2 + "\n");
		Float EstAnnualPrices2 = Float.parseFloat(EstAnnualPrice2);
		int EstAnnualPrice2Screen=Math.round(EstAnnualPrices2);
		verifyDataThroughQTP(userProfile,EstAnnualPrice2Screen);
			}
	public void threeYearFixedRate(UserProfile userProfile, String UnitCharges, String SCCharges, int StandChargeValue3CRM, int UnitRate3CRM) {
		verifyIsTextPresent("3 year fixed rate");
		verifyIsTextPresent("price breakdown");
		String AccNum3=browser.getTextByXpath(PageProperties.getProperty("Renewals.AccNum3"));
		System.out.println(AccNum3 + "\n" + userProfile.getAccNumber());
		if(AccNum3.equals(userProfile.getAccNumber()))
		{
			Report.updateTestLog("Account Number" + AccNum3 + " is displayed correctly", "PASS");
		}
		else
			Report.updateTestLog("Account Number" + AccNum3 + " is NOT displayed correctly", "FAIL");
		if(UnitCharges.equals("Yes"))
		{
			if(browser.getTextByXpath(PageProperties.getProperty("Renewals.UnitCharge3")).equals("Unit Charge"))
			{
				Report.updateTestLog("Type is displayed correctly as Unit Charge ", "PASS");
			}
			else
				Report.updateTestLog("Type is NOT displayed correctly as Unit Charge", "FAIL");
			String UnitRate3=browser.getTextByXpath(PageProperties.getProperty("Renewals.UnitRate3"));
			UnitRate3=UnitRate3.replace("p /kWh","");
			Float UnitRateValue3 = Float.parseFloat(UnitRate3);
			int UnitRatesValuesScreen3=Math.round(UnitRateValue3);
			System.out.println(UnitRate3 + "\n" + UnitRatesValuesScreen3);
			Report.updateTestLog("Unit Rate in Screen: "+UnitRatesValuesScreen3 + " Unit Rate in CRM: "+UnitRate3CRM, UnitRatesValuesScreen3==(UnitRate3CRM)?"PASS":"FAIL");
		}
		if(browser.getTextByXpath(PageProperties.getProperty("Renewals.EstAnnualConsump3")).equals("Estimated annual consumption:"))
		{
			Report.updateTestLog("Estimated Annual Consumption Text is displayed correctly", "PASS");
		}
		else
			Report.updateTestLog("Estimated Annual Consumption Text is NOT displayed correctly", "FAIL");
		/*String EstAnnualConsumpValue1=browser.getTextByXpath(PageProperties.getProperty("Renewals.EstAnnualConsumpValue1"));
			System.out.println(EstAnnualConsumpValue1 + "\n" + EstAnnualConsumpValue1CRM);
			Report.updateTestLog("Estimated Annual Consumption Value in Screen: "+EstAnnualConsumpValue1 + " Estimated Annual Consumption Value in CRM: "+EstAnnualConsumpValue1CRM, EstAnnualConsumpValue1.equalsIgnoreCase(EstAnnualConsumpValue1CRM)?"PASS":"FAIL");*/
		if(SCCharges.equals("Yes"))
		{
			if(browser.getTextByXpath(PageProperties.getProperty("Renewals.StandCharge3")).equals("Standing charge:"))
			{
				Report.updateTestLog("Standing Charge Text is displayed correctly", "PASS");
			}
			else
				Report.updateTestLog("Standing Charge Text is NOT displayed correctly", "FAIL");
			String StandChargeValue3=browser.getTextByXpath(PageProperties.getProperty("Renewals.StandChargeValue3"));
			StandChargeValue3=StandChargeValue3.replace("p / day","");
			Float StandChargeValues3 = Float.parseFloat(StandChargeValue3);
			int StandChargeValuesScreen3=Math.round(StandChargeValues3);
			System.out.println(StandChargeValuesScreen3+ "\n" + StandChargeValue3CRM);
			Report.updateTestLog("Standing Charge Value in Screen: "+StandChargeValuesScreen3 + " Standing Charge Value in CRM: "+StandChargeValue3CRM, StandChargeValuesScreen3==(StandChargeValue3CRM)?"PASS":"FAIL");
			browser.wait(5000);
			verifyAndClickWithXpath(PageProperties.getProperty("Renewals.SCWhatsthis3"), "SCWhatsthis3");
			verifyIsTextPresent("There is a daily charge for the upkeep of your meter.");
			verifyAndClickWithXpath(PageProperties.getProperty("Renewals.SCWhatsthisClose3"), "SCWhatsthis3 Close Button");
		}
		verifyAndClickWithXpath(PageProperties.getProperty("Renewals.Terms&Cond3"),"Terms & Condition1");
		browser.wait(3000);
		Report.updateTestLog("Terms & Cond1 Link in browser: "+ browser.getURL() + "Terms & Cond1 Link as per SPEC: "+ "http://www.britishgas.co.uk/business/terms-and-conditions", browser.getURL().equalsIgnoreCase("http://www.britishgas.co.uk/business/terms-and-conditions")?"PASS":"FAIL");
		browser.browserBack();
		browser.wait(3000);
		String EstAnnualPrice3=browser.getTextByXpath(PageProperties.getProperty("Renewals.EstAnnualPrice3"));
		EstAnnualPrice3=EstAnnualPrice3.substring(1);
		if(EstAnnualPrice3.contains(","))
		{
			EstAnnualPrice3 = EstAnnualPrice3.replaceFirst(",", "");
		}
		System.out.println(EstAnnualPrice3 + "\n");
		Float EstAnnualPrices3 = Float.parseFloat(EstAnnualPrice3);
		int EstAnnualPrice3Screen=Math.round(EstAnnualPrices3);
		verifyDataThroughQTP(userProfile,EstAnnualPrice3Screen);
	}

	public void energy1YearFixedRate(UserProfile userProfile, String SC1, String UC1) {
		int StandCharge1=Integer.parseInt(SC1);
		int UnitCharge1=Integer.parseInt(UC1);
		oneYearFixedRate(userProfile, "Yes", "Yes", StandCharge1, UnitCharge1);
		verifyAndClickWithXpath(PageProperties.getProperty("Renewals.Continue1"), "Continue1");
	}
	public void energy1YearRenewalSummary(UserProfile userProfile, String paymentType, String SC1, String UC1) {
		browser.wait(5000);
		verifyPageTitle("Renewal summary");
		verifyIsTextPresent("Renewal summary");
		adressTypeEndDateDetails(userProfile, paymentType);
		int StandCharge1=Integer.parseInt(SC1);
		int UnitCharge1=Integer.parseInt(UC1);
		oneYearFixedRate(userProfile, "Yes", "Yes", StandCharge1, UnitCharge1);
		verifyAndClickWithXpath(PageProperties.getProperty("Renewals.RenewalsCheckbox"), "Renewals Checkbox");
		//verifyAndClickWithXpath(PageProperties.getProperty("Renewals.RenewNow"), "RenewNow Button");
	}
	public void energy2YearFixedRate(UserProfile userProfile, String SC2, String UC2) {
		int StandCharge2=Integer.parseInt(SC2);
		int UnitCharge2=Integer.parseInt(UC2);
		twoYearFixedRate(userProfile, "Yes", "Yes", StandCharge2, UnitCharge2);
		verifyAndClickWithXpath(PageProperties.getProperty("Renewals.Continue2"), "Select2");
	}
	public void energy2YearRenewalSummary(UserProfile userProfile, String paymentType, String SC2, String UC2) {
		verifyPageTitle("Renewal summary");
		verifyIsTextPresent("Renewal summary");
		adressTypeEndDateDetails(userProfile, paymentType);
		int StandCharge2=Integer.parseInt(SC2);
		int UnitCharge2=Integer.parseInt(UC2);
		twoYearFixedRate(userProfile, "Yes", "Yes", StandCharge2, UnitCharge2);
		verifyAndClickWithXpath(PageProperties.getProperty("Renewals.RenewalsCheckbox"), "Renewals Checkbox");
		//verifyAndClickWithXpath(PageProperties.getProperty("Renewals.RenewNow"), "RenewNow Button");
	}
	public void energy3YearFixedRate(UserProfile userProfile, String SC3, String UC3) {
		int StandCharge3=Integer.parseInt(SC3);
		int UnitCharge3=Integer.parseInt(UC3);
		threeYearFixedRate(userProfile, "Yes", "No", StandCharge3, UnitCharge3);
		verifyAndClickWithXpath(PageProperties.getProperty("Renewals.Continue3"), "Select3");


	}
	public void energy3YearRenewalSummary(UserProfile userProfile, String paymentType, String SC3, String UC3) {
		verifyPageTitle("Renewal summary");
		verifyIsTextPresent("Renewal summary");
		adressTypeEndDateDetails(userProfile, paymentType);
		int StandCharge3=Integer.parseInt(SC3);
		int UnitCharge3=Integer.parseInt(UC3);
		threeYearFixedRate(userProfile, "Yes", "No", StandCharge3, UnitCharge3);
		verifyAndClickWithXpath(PageProperties.getProperty("Renewals.RenewalsCheckbox"), "Renewals Checkbox");
		//verifyAndClickWithXpath(PageProperties.getProperty("Renewals.RenewNow"), "RenewNow Button");
	}

	public void energy1YearRenewalConfirmation(UserProfile userProfile) {
		verifyPageTitle("Renewal confirmation");
		verifyIsTextPresent("Renewal confirmation");
		verifyIsTextPresent("Thank you for renewing with British Gas");
		/*String Energyplanrenewaldate=browser.getTextByXpath(PageProperties.getProperty("Renewals.Energyplanrenewaldate"));
		Report.updateTestLog("On Screen: "+Energyplanrenewaldate + " As per Content SPEC: "+"Energy plan renewal date", Energyplanrenewaldate.equalsIgnoreCase("Energy plan renewal date")?"PASS":"FAIL");
		String EnergyplanrenewalDT=browser.getTextByXpath(PageProperties.getProperty("Renewals.Energyplanrenewaldt"));
		Report.updateTestLog("On Screen: "+EnergyplanrenewalDT + " renewal date from CRM  "+ to be filled, EnergyplanrenewalDT.equalsIgnoreCase("Energy plan renewal date")?"PASS":"FAIL");
		String Energyplanenddate=browser.getTextByXpath(PageProperties.getProperty("Renewals.Energyplanenddate"));
		Report.updateTestLog("On Screen: "+Energyplanenddate + " As per Content SPEC: "+"Energy plan end date", Energyplanenddate.equalsIgnoreCase("Energy plan end date")?"PASS":"FAIL");
		String EnergyplanendDT=browser.getTextByXpath(PageProperties.getProperty("Renewals.Energyplanenddt"));
		Report.updateTestLog("On Screen: "+EnergyplanendDT + " renewal date from CRM  "+ to be filled, EnergyplanendDT.equalsIgnoreCase("Energy plan renewal date")?"PASS":"FAIL");*/
		verifyIsTextPresent("What happens next?");
		verifyIsTextPresent("We�ll email you to confirm the details of your renewal.");
		verifyIsTextPresent("We will send your new energy plan through the post which will arrive within 10 days.");
		verifyIsTextPresent("You don�t need to do anything else.");

	}

	public void verifyLinksinRenewalsQuote() {
		energyPlanRenewalLink();
		verifyIsElementVisibleWithXpath(PageProperties.getProperty("Renewals.ViewFixedPriceLink"),"View Fixed Price Energy Plans Link");
		verifyAndClickWithXpath(PageProperties.getProperty("Renewals.ViewFixedPriceLink"),"View Fixed Price Energy Plans Link");
		browser.wait(3000);
		verifyAndClickWithXpath(PageProperties.getProperty("Renewals.Back"),"Back Link in Promo Page");
		browser.wait(3000);
		verifyPageTitle("Energy plan renewal");
		browser.browserBack();
		browser.wait(3000);
		verifyIsElementVisibleWithXpath(PageProperties.getProperty("Renewals.RequestacallbackLink"),"Request a call back Link");
		verifyAndClickWithXpath(PageProperties.getProperty("Renewals.RequestacallbackLink"),"Request a call back Link");
		browser.wait(4000);
		verifyIsTextPresent("Request a call back");
		browser.browserBack();
		browser.wait(4000);
		verifyAndClickWithXpath(PageProperties.getProperty("Renewals.Cancel"),"Cancel Link in Promo Page");
		browser.wait(4000);
		verifyPageTitle("Account overview");
		browser.browserBack();
		browser.wait(3000);
	}

	public void verifyLinksinDontRenew() {
		energyPlanRenewalLink();
		verifyIsElementVisibleWithXpath(PageProperties.getProperty("Renewals.ViewFixedPriceLink"),"View Fixed Price Energy Plans Link");
		verifyAndClickWithXpath(PageProperties.getProperty("Renewals.ViewFixedPriceLink"),"View Fixed Price Energy Plans Link");
		browser.wait(3000);
		verifyIsElementVisibleWithXpath(PageProperties.getProperty("Renewals.DontWantRenew"),"I don't want to renew Link");
		verifyAndClickWithXpath(PageProperties.getProperty("Renewals.DontWantRenew"),"I don't want to renew Link");
		browser.wait(3000);
		verifyIsTextPresent("What happens if I don't renew?");
		verifyIsElementVisibleWithXpath(PageProperties.getProperty("Renewals.RequestacallbackLink"),"Request a call back Link");
		verifyAndClickWithXpath(PageProperties.getProperty("Renewals.RequestacallbackLink"),"Request a call back Link");
		browser.wait(4000);
		verifyIsTextPresent("Request a call back");
		browser.browserBack();
		verifyAndClickWithXpath(PageProperties.getProperty("Renewals.Back"),"Back Link in Promo Page");
		browser.wait(3000);
		verifyPageTitle("Renewal quote");
	}

	public void verifyDataThroughQTP(UserProfile userProfile, int EstAnnualPrice ){
		String strRetreiveEmailQry="select BUSINESS_PARTNER_ORG_NUMBER from BG_BUSINESS_TA_CUSTOMER_REG" + " where email='emailid'";
		String query=strRetreiveEmailQry.replace("emailid",userProfile.getEmail().toLowerCase());
		if(new OnlineDBConnector().getColumn("BUSINESS_PARTNER_ORG_NUMBER", query).equals(null)){
			Report.updateTestLog("BPORGNUMBER is null for the email"+userProfile.getEmail(), "Fail");
			return;
		}
		String bpOrgNumber=new OnlineDBConnector().getColumn("BUSINESS_PARTNER_ORG_NUMBER", query);
		System.out.println("RUN QTP"+bpOrgNumber);
		String Acctno=userProfile.getAccNumber();
		bpOrgNumber =bpOrgNumber.concat("-").concat(Acctno);
		System.out.print("bpOrgNumber"+bpOrgNumber);    
		/*RunQTP runQTP = new RunQTP();
	runQTP.runQTP("Slingshot\\src\\bg\\framework\\app\\functional\\util\\vbsScripts\\renewal_price.vbs", bpOrgNumber);
	browser.wait(15000);*/
		try {
			File file1 = new File("D:\\Annualprice\\annualprice.txt");
			FileReader fr = new FileReader(file1);
			BufferedReader br = new BufferedReader(fr);
			Float AnnualPrice1;
			int AnnualPrice2=0;
			String AnnualPrice = br.readLine();
			if(AnnualPrice.contains("Estimated Price")&& AnnualPrice.contains(":") ){
				String[] AnnualPrices=AnnualPrice.split(":");
				String AnnualPrices1=AnnualPrices[1];
				AnnualPrices1=AnnualPrices1.replace(",", ".");
				AnnualPrice1 = Float.parseFloat(AnnualPrices1);
				AnnualPrice2=Math.round(AnnualPrice1);
				if(AnnualPrice2==(EstAnnualPrice)){
					Report.updateTestLog("EstAnnualPrice in Application :"+EstAnnualPrice+"EstAnnualPrice in ISU :"+AnnualPrice2, "Pass");
				}else{
					Report.updateTestLog("EstAnnualPrice in the Application :"+EstAnnualPrice+"EstAnnualPrice in ISU :"+AnnualPrice2, "Fail");
				}    
			}else{
				Report.updateTestLog("EstAnnualPrice is not written in the text file"+AnnualPrice2, "Fail");                   
			}
		}catch (IOException e) {
			System.out.println("bad"+e);
		}
	}

	public void energy2YearRenewalConfirmation() {
		verifyPageTitle("Renewal confirmation");
		verifyIsTextPresent("Renewal confirmation");
		verifyIsTextPresent("Thank you for renewing with British Gas");
		/*String Energyplanrenewaldate=browser.getTextByXpath(PageProperties.getProperty("Renewals.Energyplanrenewaldate"));
		Report.updateTestLog("On Screen: "+Energyplanrenewaldate + " As per Content SPEC: "+"Energy plan renewal date", Energyplanrenewaldate.equalsIgnoreCase("Energy plan renewal date")?"PASS":"FAIL");
		String EnergyplanrenewalDT=browser.getTextByXpath(PageProperties.getProperty("Renewals.Energyplanrenewaldt"));
		Report.updateTestLog("On Screen: "+EnergyplanrenewalDT + " renewal date from CRM  "+ to be filled, EnergyplanrenewalDT.equalsIgnoreCase("Energy plan renewal date")?"PASS":"FAIL");
		String Energyplanenddate=browser.getTextByXpath(PageProperties.getProperty("Renewals.Energyplanenddate"));
		Report.updateTestLog("On Screen: "+Energyplanenddate + " As per Content SPEC: "+"Energy plan end date", Energyplanenddate.equalsIgnoreCase("Energy plan end date")?"PASS":"FAIL");
		String EnergyplanendDT=browser.getTextByXpath(PageProperties.getProperty("Renewals.Energyplanenddt"));
		Report.updateTestLog("On Screen: "+EnergyplanendDT + " renewal date from CRM  "+ to be filled, EnergyplanendDT.equalsIgnoreCase("Energy plan renewal date")?"PASS":"FAIL");*/
		verifyIsTextPresent("What happens next?");
		verifyIsTextPresent("We�ll email you to confirm the details of your renewal.");
		verifyIsTextPresent("We will send your new energy plan through the post which will arrive within 10 days.");
		verifyIsTextPresent("You don�t need to do anything else.");
		
	}

	public void energy3YearRenewalConfirmation() {
		verifyPageTitle("Renewal confirmation");
		verifyIsTextPresent("Renewal confirmation");
		verifyIsTextPresent("Thank you for renewing with British Gas");
		/*String Energyplanrenewaldate=browser.getTextByXpath(PageProperties.getProperty("Renewals.Energyplanrenewaldate"));
		Report.updateTestLog("On Screen: "+Energyplanrenewaldate + " As per Content SPEC: "+"Energy plan renewal date", Energyplanrenewaldate.equalsIgnoreCase("Energy plan renewal date")?"PASS":"FAIL");
		String EnergyplanrenewalDT=browser.getTextByXpath(PageProperties.getProperty("Renewals.Energyplanrenewaldt"));
		Report.updateTestLog("On Screen: "+EnergyplanrenewalDT + " renewal date from CRM  "+ to be filled, EnergyplanrenewalDT.equalsIgnoreCase("Energy plan renewal date")?"PASS":"FAIL");
		String Energyplanenddate=browser.getTextByXpath(PageProperties.getProperty("Renewals.Energyplanenddate"));
		Report.updateTestLog("On Screen: "+Energyplanenddate + " As per Content SPEC: "+"Energy plan end date", Energyplanenddate.equalsIgnoreCase("Energy plan end date")?"PASS":"FAIL");
		String EnergyplanendDT=browser.getTextByXpath(PageProperties.getProperty("Renewals.Energyplanenddt"));
		Report.updateTestLog("On Screen: "+EnergyplanendDT + " renewal date from CRM  "+ to be filled, EnergyplanendDT.equalsIgnoreCase("Energy plan renewal date")?"PASS":"FAIL");*/
		verifyIsTextPresent("What happens next?");
		verifyIsTextPresent("We�ll email you to confirm the details of your renewal.");
		verifyIsTextPresent("We will send your new energy plan through the post which will arrive within 10 days.");
		verifyIsTextPresent("You don�t need to do anything else.");
		
	}

	/*
	 * 
	 * Zeeshan Ahamed
	 * ********************************Renewals BGB WAVE 2015 ****************************************************************************
	 * 
	 * 
	 */
	
	 public void energyPlanIsDueForUpgrade () {
		 dialsCount = browser.getChildElementsCountByXpath(PageProperties.getProperty("Renewals.DialsCount"));
		  System.out.println("dialsCount "+dialsCount);
		  for (int i = 1 ;i <=dialsCount;i++ ){
			  //System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
			  System.out.println("xpath="+PageProperties.getProperty("Renewals.EnergyPlanModelOverlay").replace("dialsCount",i+""));
			  verifyAndClickWithXpath(PageProperties.getProperty("Renewals.EnergyPlanModelOverlay").replace("dialsCount",i+""), "Renewals link");
			  Report.updateTestLog("Your Energy Plan is due for upgrade displayed", "WARN");
			  
		  }
		 
		 
	 }
	
	
}