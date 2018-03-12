
package bg.framework.app.functional.page.Slingshot;

import java.util.Properties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import bg.framework.app.functional.action.Slingshot.ContactUsBusinessAction;
import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.SlingshotErrorMessages;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
/**
 * @author 208070
 *
 */
public class ContactUsCorporatePage extends BasePage{

	private final static String FILE_NAME = "resources/Slingshot/ContactUs.Properties";     
	private static Properties PageProperties = new PropertyLoader(FILE_NAME).load();
	
	public void navigatetoContactUsCorporatelink() {
		verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.Corporate"),"Corporate Link");
		verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.contactuslink"),"Contact Us Link");
		}
	public void verifyMyAccountandBilling() {
		verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.Account&Billing"),"My Account and Billing");
		if(ApplicationConfig.BRAND.equalsIgnoreCase("BG")){
			ArrayList<String> list = new ArrayList<String>();
			list.add("ContactUs.SubmitMeterRead");
			list.add("Submit meter read");
			list.add("ContactUs.RequestCopyBill");
			list.add("Copy Bill Request - British Gas Business");
			list.add("ContactUs.ManageAccount");
			list.add("Cheap Business Energy | Business Gas & Electricity - British Gas Corporate");
			list.add("ContactUs.RequestAcctStatement");
			list.add("Statement of Account - British Gas Business");
			list.add("ContactUs.CheckIfBillCorrect");
			list.add("Checking if your bill is correct");
			list.add("ContactUs.QueryingYourBill");
			list.add("Querying your bill");
			list.add("ContactUs.WrongAddress");
			list.add("My bills are going to the wrong address");	
			list.add("ContactUs.BillsToGoToDifferentAddress");
			list.add("I need my bills to go to a different address");
			list.add("ContactUs.PaymentOptions");
			list.add("Payment options");
			list.add("ContactUs.OurBankAccountDetails");
			list.add("Our bank account details");
			list.add("ContactUs.SendingMyPaymentCheque");
			list.add("Sending my payment cheque");
			list.add("ContactUs.SavingMoneywithDirectDebit");
			list.add("Saving money with Direct Debit");
			list.add("ContactUs.CreditBalance");
			list.add("Getting a refund on a credit balance");
			list.add("ContactUs.HelpWithPayingYourBill");
			list.add("Help with paying your bill");
			list.add("ContactUs.PreviousPaymentsNotShowninBill");
			list.add("My previous payments are not showing on my bill");
			list.add("ContactUs.ViewMoreHelp1");
			list.add("I need help with");
			for (int i=0;i<8;i=i+2) {
				System.out.println(list.get(i) + "       " + list.get(i+1));
				verifyLinksandTitle(list.get(i),list.get(i+1),"ContactUs.Account&Billing");
			}
			for (int i=8;i<list.size();i=i+2) {
				System.out.println(list.get(i) + "       " + list.get(i+1));
				verifyLinksandText(list.get(i),list.get(i+1),"ContactUs.Account&Billing");
			}
		}
	}
	private void verifyLinksandTitle(String link, String title, String Maintab) {
		int count =1, increment=1;
		String linkName = link.substring(link.indexOf('.') + 1, link.length());
		if(browser.isElementVisibleWithXpath(PageProperties.getProperty(link))) {
			Report.updateTestLog(linkName + " Link Exist", "PASS");
			browser.clickWithXpath(PageProperties.getProperty(link));
			do{
				getWaitTime();
				if(browser.getTitle().equalsIgnoreCase(title))
				{
					verifyPageTitle(title);
					break;
				}
				count++;
			}while(count<10);
			browser.browserBack();
			do{
				getWaitTime();
				if(browser.isElementVisibleWithXpath(PageProperties.getProperty(Maintab)))
				{
					browser.clickWithXpath(PageProperties.getProperty(Maintab));
					break;
				}
				increment++;
			}while(increment<10);
		 } 
		else {
			Report.updateTestLog(linkName + " Link not Exist", "FAIL");
		}
	 }
	private void verifyLinksandText(String link, String text, String Maintab) {
		int count =1, increment=1;
		String linkName = link.substring(link.indexOf('.') + 1, link.length());
		if(browser.isElementVisibleWithXpath(PageProperties.getProperty(link))) {
			Report.updateTestLog(linkName + " Link Exist", "PASS");
			browser.clickWithXpath(PageProperties.getProperty(link));
			do{
				getWaitTime();
				if(browser.isTextPresent(text.trim()))
				{
					verifyIsTextPresent(text.trim());
					break;
				}
				count++;
			}while(count<10);
			browser.browserBack();
			do{
				getWaitTime();
				if(browser.isElementVisibleWithXpath(PageProperties.getProperty(Maintab)))
				{
					browser.clickWithXpath(PageProperties.getProperty(Maintab));
					break;
				}
				increment++;
			}while(increment<10);
		} 
		else {
			Report.updateTestLog(linkName + " Link not Exist", "FAIL");
		}

	}
	
	public void logout(){
		verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.Logout"), "Log out link");
	}
	
	public void verifyMovingPremises() {
		verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.MovingPremises"),"Moving Premises");
		if(ApplicationConfig.BRAND.equalsIgnoreCase("BG")){
			ArrayList<String> list = new ArrayList<String>();
			list.add("ContactUs.MovingOutOfaProperty");
			list.add("Moving Premises - British Gas Business");
			list.add("ContactUs.MovingIntoaProperty");
			list.add("Moving Premises - British Gas Business");
			list.add("ContactUs.MovingOutOfSomeorAllYourPremises");
			list.add("What do I need to do before I move out of my premises?");
			list.add("ContactUs.SupplyEnergytoMyNewPremises");
			list.add("What should I do if I am moving into a new premise?");
			list.add("ContactUs.ViewMoreHelp4");
			list.add("I need help with...");
			for (int i=0;i<4;i=i+2) {
				System.out.println(list.get(i) + "       " + list.get(i+1));
				verifyLinksandTitle(list.get(i),list.get(i+1),"ContactUs.MovingPremises");
			}
			for (int i=4;i<list.size();i=i+2) {
				System.out.println(list.get(i) + "       " + list.get(i+1));
				verifyLinksandText(list.get(i),list.get(i+1),"ContactUs.MovingPremises");
			}
		}
		
	}
	
	public void verifyBreakdownandServices() {
		browser.wait(9000);
		verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.Breakdown&Servicing"),"Breakdown and Servicing");
		if(ApplicationConfig.BRAND.equalsIgnoreCase("BG")){
			ArrayList<String> list = new ArrayList<String>();
			list.add("ContactUs.BusinessHeatingCare");
			list.add("Boiler maintenance and repair - Annual Boiler Service - British Gas");
			list.add("ContactUs.GasServicing");
			list.add("Gas compliance - British Gas Business");
			list.add("ContactUs.GasBreakdowns");
			list.add("Boiler maintenance and repair - Annual Boiler Service - British Gas");
			list.add("ContactUs.GasInstallations");
			list.add("Gas installation – British Gas Corporate");
			list.add("ContactUs.ElectricityTestBill");
			list.add("Electrical compliance - British Gas Corporate");
			list.add("ContactUs.RemedialWorks&LightingMaintenance");
			list.add("Low cost maintenance and peace of mind - British Gas Corporate");
			list.add("ContactUs.ReactiveElectricalMaintenance");
			list.add("Electrical maintenance - British Gas Business");
			list.add("ContactUs.ElectricalEngineeringServices");
			list.add("Electrical Installation - British Gas Corporate");
			list.add("ContactUs.PayingforBusinessHeatingCare");
			list.add("Paying for Business Heating Care");
			list.add("ContactUs.BusinessHeatingCareContract");
			list.add("How long is a Business Heating Care contract?");
			list.add("ContactUs.BusinessHeatingCareHelpCorporate");
			list.add("Business Heating Care");
			list.add("ContactUs.StartContractandInspectSystem");
			list.add("Starting your contract and inspecting your system");
			list.add("ContactUs.BreakdownCallouts");
			list.add("Breakdown callouts");
			list.add("ContactUs.BusinessHeatingCareforallBoilers");
			list.add("Is BusinessCare available for all types of boilers?");
			list.add("ContactUs.ViewMoreHelp5");
			list.add("I need help with...");
			for (int i=0;i<16;i=i+2) {
				System.out.println(list.get(i) + "       " + list.get(i+1));
				verifyLinksandTitle(list.get(i),list.get(i+1),"ContactUs.Breakdown&Servicing");
			}
			for (int i=16;i<list.size();i=i+2) {
				System.out.println(list.get(i) + "       " + list.get(i+1));
				verifyLinksandText(list.get(i),list.get(i+1),"ContactUs.Breakdown&Servicing");
			}
		}

	}
	public void navigatetoEmailContactUsCorporatelink(String tab) {
		browser.wait(2000);
		//verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.GetinTouchwithBGCorporatelink"),"Do you want to get in touch with British Gas");
		String Number="0";
		if(tab=="MyAccountandBilling"){

			Number="1";
		}
		else if(tab=="SwitchingtoBG"){

			Number="2";
		}
		else if(tab=="MyMeterReadingsandMeter"){

			Number="3";
		}
		else if(tab=="MovingPremises"){

			Number="4";
		}
		else if(tab=="BreakdownandServices"){

			Number="5";
		}
		verifyAndClickWithXpath(PageProperties.getProperty("ContactUs.Emailcontactuslink").replace("NUM", Number),"Email Us");
		browser.wait(4000);
		verifyPageTitle("Email us");
	}
	
	
}
