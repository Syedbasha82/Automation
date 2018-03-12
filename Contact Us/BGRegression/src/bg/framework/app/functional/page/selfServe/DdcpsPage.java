package bg.framework.app.functional.page.selfServe;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.ExecuteMethod;
import org.openqa.selenium.support.ui.Select;
import org.testng.reporters.JqReporter;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.Ddcps;
import bg.framework.app.functional.entities.PriceFinderRMR;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.sales.TCRCalculationPage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.RobotSendKeys;
import bg.framework.app.functional.util.TestDataHelper;

import bg.framework.common.functional.UIDriver;
import bg.framework.common.functional.WebDriverProvider;

public class DdcpsPage extends BasePage {
	protected static UIDriver uiDriver = WebDriverProvider.getCurrentDriver();
	private final static String File_Name= "resources/selfServe/Ddcps.properties";
	private static Properties PageProperties =new PropertyLoader(File_Name).load();
	private Ddcps ddcps;
	public static String accType;
	public DdcpsPage()
	{
		
	}
	public DdcpsPage(Ddcps ddcps )
	{
		this.ddcps=ddcps;
	}
	public void switchToDD()
	{
		verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.SwitchToDdcps"),"SwitchToDD");
		
	}
	
	public void selectAccountsForSwitchingToDD(UserProfile userProfile,String accType)
	{	
		String selectAccount="",selectAccountDual="";
		if(browser.isTextPresent("setting up a Direct Debit"))
		{
			Report.updateTestLog("The setup homepage is displayed in the application", "PASS");
		}
		verifyAndClick(PageProperties.getProperty("Ddcps.SettingUpCouldntBeEasier"), "SettingUp");
		if(accType=="Gas")
		{
			Report.updateTestLog("The account to be selected is Gas", "PASS");
			selectAccount=(PageProperties.getProperty("Ddcps.SelectAccount")+userProfile.getGasAccount()+"']");
		}
		else if(accType=="Electricity")
		{
			selectAccount=(PageProperties.getProperty("Ddcps.SelectAccount")+userProfile.getElecAccount()+"']");
		}
		else if(accType=="Energy")
		{
			selectAccount=(PageProperties.getProperty("Ddcps.SelectAccount")+userProfile.getAccNumber()+"']");
		}
		else if(accType=="Dual")
		{
			selectAccount=(PageProperties.getProperty("Ddcps.SelectAccount")+userProfile.getGasAccount()+"']");
			selectAccountDual=(PageProperties.getProperty("Ddcps.SelectAccount")+userProfile.getElecAccount()+"']");
			verifyAndClickWithXpath(selectAccountDual, "AccountCheckBoxDual");
		}
		
		if(browser.isSelectedByXpath(selectAccount))
				{
			Report.updateTestLog("The account is already selected", "PASS");
				}
		else{
			Report.updateTestLog("The account is not already selected", "PASS");
			verifyAndClickWithXpath(selectAccount, "AccountCheckBox");
		}
		
		if(browser.isElementVisible(PageProperties.getProperty("Ddcps.AddNectorLater")))
		{
			Report.updateTestLog("The Nector card detail entries are present in the application", "PASS");
			verifyAndClick(PageProperties.getProperty("Ddcps.AddNectorLater"), "Nector card");
			if(!browser.isSelected(PageProperties.getProperty("Ddcps.NectorTerms")))
			{
			verifyAndClick(PageProperties.getProperty("Ddcps.NectorTerms"), "Nector Terms");
			}
		}
		verifyAndClick(PageProperties.getProperty("Ddcps.ContinueToPaymentDate"), "Continue");
	}
	
	public void meterReadOverlay(String accType)
	{	
		if(browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.ReadOverlay")))
		{
		Report.updateTestLog("The meter Read overlay is displayed for the account", "PASS");
		//TODO for ElecDualRate
		String prevReadText = null;
		if(browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.PreReading")))
		{
			prevReadText = browser.getTextByXpath(PageProperties.getProperty("Ddcps.PreReading"));
		}
		else if(browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.PreReadingJI1")))
		{
			prevReadText = browser.getTextByXpath(PageProperties.getProperty("Ddcps.PreReadingJI1"));
		}
		int read=Integer.parseInt(prevReadText);
		read=read+1;
		String newMeterRead=String.format("%05d",read);
		String meterRead[]=newMeterRead.split("");
		
		for(int j=1;j<=5;j++)
		{	
			verifyAndInputByXpath((PageProperties.getProperty("Ddcps.DualGasDial")+"["+j+"]"), "meterRead", meterRead[j]);
		}
		if(browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.PreReadDualElec")))
		{
			String prevElecDualRead= browser.getTextByXpath(PageProperties.getProperty("Ddcps.PreReadDualElec"));
			int readElec=Integer.parseInt(prevElecDualRead);
			readElec=readElec+1;
			String newElecDualMeterRead=String.format("%05d",readElec);
			String meterReadDual[]=newElecDualMeterRead.split("");
			for(int i=1;i<=5;i++)
			{	
				browser.wait(1000);
				verifyAndInputByXpath((PageProperties.getProperty("Ddcps.DualElecDial")+"["+i+"]"), "meterReadElec", meterReadDual[i]);
			}
			
		}
		
		verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.ContinueSubmitReading"), "Continue");
	}
	else{
		Report.updateTestLog("The meter Read overlay is not displayed for the account", "PASS");
	}
	}
	
	public void enterPaymentDateForQuarterlyCustomer()
	{
		if(browser.isElementVisible(PageProperties.getProperty("Ddcps.ContinueToPaymentDate")))
		{
			Report.updateTestLog("ThePayment Date entry is present in the application", "PASS");
			verifyAndClick(PageProperties.getProperty("Ddcps.DDPaymentDate"),"PaymentDate");
			selectDataFromDropDownBox(ddcps.getPaymentDay());
			verifyAndClick(PageProperties.getProperty("Ddcps.DDSelectDateContinue"), "ContinueToPaymentAmount");
		}
		else{
			Report.updateTestLog("ThePayment Date entry is not present in the application", "FAIL");
		}
	}
	public void selectDataFromDropDownBox(String dropDownString)
	{
		int dropDownValue=Integer.parseInt(dropDownString);
		for(int value=1;value<=dropDownValue;value++) 
		{
			RobotSendKeys.downArrow();
			RobotSendKeys.typeenter();
		}
	}
	public void selectDataFromDropDownBox(int dropDownValue)
	{
		for(int value=1;value<=dropDownValue;value++) 
		{
			RobotSendKeys.downArrow();
			RobotSendKeys.typeenter();
		}
	}
	public void paymentAmountAndCreditRefund()
	{
		if(browser.isElementVisible(PageProperties.getProperty("Ddcps.RefundCheckBox")))
		{
			Report.updateTestLog("The Account has credit amount and Refund is possible", "PASS");
			verifyAndClick(PageProperties.getProperty("Ddcps.RefundCheckBox"), "RefundCheckBox");
		}
		else{
			Report.updateTestLog("The Account has no credit amount","PASS");
		}
		if(browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.PayDue")))
		{
			Report.updateTestLog("The Account has Debit amount and payment is needed", "PASS");
			verifyAndInputByXpath(PageProperties.getProperty("Ddcps.PayDue"), "PayAmount", ddcps.getpayDueAmount());
			verifyAndClick(PageProperties.getProperty("Ddcps.RecalculateDue"), "Recalculate");
			browser.wait(2000);
			
		}
		verifyAndClick(PageProperties.getProperty("Ddcps.ContinuePaymentAmount"), "Continue");
	}
	
	public void setUpDDMakeAPayment()
	{
		if(browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.MakeAPaymentOverlay")))
				{
				verifyAndClick(PageProperties.getProperty("Ddcps.SetupMKPCardType"),"cardType");
				selectDataFromDropDownBox(ddcps.getCardType());
				verifyAndInputById(PageProperties.getProperty("Ddcps.SetupMKPCardHolder"), "nameOnCard",ddcps.getCardHolderName());
				verifyAndInputById(PageProperties.getProperty("Ddcps.SetupMKPCardNo"), "CardNumber",ddcps.getCardNumber());
				verifyAndClick(PageProperties.getProperty("Ddcps.SetupMKPStartDate"),"CardStartMonth");
				selectDataFromDropDownBox(ddcps.getCardStartMonth());
				verifyAndClick(PageProperties.getProperty("Ddcps.SetupMKPStartYear"),"CardStartYear");
				selectDataFromDropDownBox(ddcps.getCardStartYear());
				verifyAndClick(PageProperties.getProperty("Ddcps.SetupMKPExpiryDate"),"CardExpiryMonth");
				selectDataFromDropDownBox(ddcps.getCardEndMonth());
				verifyAndClick(PageProperties.getProperty("Ddcps.SetupMKPExpiryYear"),"CardExpiryYear");
				selectDataFromDropDownBox(ddcps.getCardEndYear());
				verifyAndInputById(PageProperties.getProperty("Ddcps.SetupMKPCvv"), "CVV",ddcps.getCardCVV());
				
				verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.ContinuePayOverlay"), "Continue");
				verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.SubmitVVisa"),"SubmitMKPDetails");
				
				}
	}
	
	public void enterBankDetailsForQuarterlyCustomer()
	{
		verifyAndInputByXpath(PageProperties.getProperty("Ddcps.BankDetailsFName"), "FirstName", ddcps.getBankFirstName());
		verifyAndInputByXpath(PageProperties.getProperty("Ddcps.BankDetailsLName"), "LastName",ddcps.getBankLastName() );
		
		verifyAndClick(PageProperties.getProperty("Ddcps.BankDetailsDOB"),"DateOfBirth");
		selectDataFromDropDownBox(ddcps.getDateOfBirth());
		verifyAndClick(PageProperties.getProperty("Ddcps.BankDetailsMOB"), "MonthOfBirth");
		selectDataFromDropDownBox(ddcps.getMonthOfBirh());
		verifyAndClick(PageProperties.getProperty("Ddcps.BankDetailsYOB"), "YearOfBirth");
		selectDataFromDropDownBox(ddcps.getYearOfBirth());
		
		verifyAndInputByXpath(PageProperties.getProperty("Ddcps.BankSortCode1"), "SortCode1",ddcps.getSortCode1());        
		verifyAndInputByXpath(PageProperties.getProperty("Ddcps.BankSortCode2"), "SortCode2",ddcps.getSortCode2());
		verifyAndInputByXpath(PageProperties.getProperty("Ddcps.BankSortCode3"), "SortCode3",ddcps.getSortCode3() );
		verifyAndInputByXpath(PageProperties.getProperty("Ddcps.BankAccountNumber"), "BankAccountNumber",ddcps.getBankAccountNumber());
		verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.DDGuaranteeTerms"), "Terms");
		verifyAndClick(PageProperties.getProperty("Ddcps.SubmitBankDetails"), "ContinueToReview");
	}
	
	public void reviewAndConfirmDDSetUp()
	{
		verifyAndClick(PageProperties.getProperty("Ddcps.ReviewAndConfirmSetup"), "Confirm");
	}
	
	public void enterReadingMonthlyCustomer(String accType)
	{
		//TODO for dual and JI
		String meterReadDial="",elecDayDial="",elecNightDial="";
		browser.wait(1000);
		if(browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.MeterReadDial")))
		{
			Report.updateTestLog("The meter Read dial is displayed in the application", "PASS");
		}
		else{
			Report.updateTestLog("The meter Read dial page is not displayed in the application", "FAIL");
		}
		browser.wait(1000);
		
		meterReadDial=PageProperties.getProperty("Ddcps.MeterReadDial");
		int meterDialCount=browser.getChildElementsCountByXpath(meterReadDial);
		meterDialEntry(meterDialCount,meterReadDial);
		
		 
		if(accType=="DualRate")
		{
			elecDayDial=PageProperties.getProperty("Ddcps.DualElecDayDial");
			int elecDayDialCount=browser.getChildElementsCountByXpath(elecDayDial);
			meterDialEntry(elecDayDialCount,elecDayDial);
			
			
			if(browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.DualElecNightDial")))
			{
				Report.updateTestLog("The customer has a Dual Rate Electricity Account", "PASS");
				elecNightDial=PageProperties.getProperty("Ddcps.DualElecNightDial");
				int elecNightDialCount=browser.getChildElementsCountByXpath(elecNightDial);
				meterDialEntry(elecNightDialCount,elecNightDial);
				
			}else
			{
				Report.updateTestLog("The customer has a Single Rate Electricity Account", "PASS");
			}
			
		}
		
		verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.ContinueToPayment"), "ContinueTopayment");
	}
	
	public void meterDialEntry(int dialCount,String meterReadXpath)
	{
		for(int i=1;i<=dialCount;i++)
		{
			if(browser.isElementVisibleWithXpath(dialCount+"["+i+"]"))
				{
				verifyAndInputByXpath(meterReadXpath+"["+i+"]","dial"+i,"1" );
				}
		}
		
	}
	
	public void confirmationOverlay()
	{
		if(browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.OverlayConfirm")))
				{
			Report.updateTestLog("The overlay appears in the application", "PASS");
			browser.wait(1000);
			String prevRead=browser.getTextByXpath(PageProperties.getProperty("Ddcps.OverlayPrevRead"));
			verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.OverlayConfirm"), "ConfirmRead");
				}
	}
	
	
	public void navigateToPayBalanceNow()
	{
		if(browser.isElementVisible(PageProperties.getProperty("Ddcps.PayBalanceNow")))
		{
			Report.updateTestLog("The options for paying balance are displayed in the application","PASS");
			verifyAndClick(PageProperties.getProperty("Ddcps.PayBalanceNow"), "PayNow");
			verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.ContinueToBankDetails"), "ContinueToBankDetails");	
			
			//TODO Card Type
			verifyAndClick(PageProperties.getProperty("Ddcps.PayCardType"),"CardType");
			selectDataFromDropDownBox("2");
			verifyAndInputById(PageProperties.getProperty("Ddcps.PayCardHolder"), "HolderName", ddcps.getCardHolderName());
			verifyAndInputById(PageProperties.getProperty("Ddcps.PayCardNumber"), "CardNumber", ddcps.getCardNumber());
			
			
			verifyAndClick(PageProperties.getProperty("Ddcps.StartMonth"), "StartMonth");
			selectDataFromDropDownBox(ddcps.getCardStartMonth());
			verifyAndClick(PageProperties.getProperty("Ddcps.StartYear"), "StartYear");
			selectDataFromDropDownBox(ddcps.getCardStartYear());
			verifyAndClick(PageProperties.getProperty("Ddcps.ExpiryMonth"), "ExpiryMonth");
			selectDataFromDropDownBox(ddcps.getCardEndMonth());
			verifyAndClick(PageProperties.getProperty("Ddcps.ExpiryYear"), "ExpiryYear");
			selectDataFromDropDownBox(ddcps.getCardEndYear());
			verifyAndInputById(PageProperties.getProperty("Ddcps.PayCvv"), "CVV", ddcps.getCardCVV());
			verifyAndClick(PageProperties.getProperty("Ddcps.PaymentSubmit"), "Continue");
			browser.wait(1000);
			verifyAndClick(PageProperties.getProperty("Ddcps.PayComplete"), "PayComplete");
			browser.wait(1000);
			verifyAndClick(PageProperties.getProperty("Ddcps.SubmitPay"), "Submit");
		}
		else{
			Report.updateTestLog("The Customer has Credit Balance","PASS");
		}
	}
	
	public void navigateToBankDetailsPayBalanceLater()
	{
		if(browser.isElementVisible(PageProperties.getProperty("Ddcps.PayBalanceNextTime")))
		{
			Report.updateTestLog("The options for paying balance are displayed in the application","PASS");
			verifyAndClick(PageProperties.getProperty("Ddcps.PayBalanceNextTime"), "PayWithNextBill");
			verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.ContinueToBankDetails"), "ContinueToBankDetails");	
		}
		else{
			Report.updateTestLog("The Customer has Credit Balance","PASS");
		}
	}
	
	public void enterBankDetailsForMonthlyCustomer()
	{
		if(browser.isElementVisible(PageProperties.getProperty("Ddcps.AccountNumber")))
		{
			Report.updateTestLog("The Bank Details page is displayed in the application","PASS");
			verifyAndInputById(PageProperties.getProperty("Ddcps.AccountNumber"),"Account Number",ddcps.getBankAccountNumber());
			verifyAndInputById(PageProperties.getProperty("Ddcps.SortCode1"),"SortCode1", ddcps.getSortCode1());
			verifyAndInputById(PageProperties.getProperty("Ddcps.SortCode2"),"SortCode2",  ddcps.getSortCode2());
			verifyAndInputById(PageProperties.getProperty("Ddcps.SortCode3"),"SortCode3",  ddcps.getSortCode3());
			verifyAndInputById(PageProperties.getProperty("Ddcps.AccHolderName"),"Account Holder", ddcps.getCardHolderName());
			verifyAndSelectDropDownBox(PageProperties.getProperty("Ddcps.PreferredDay"),"Prefered day","5");
			/*if()
			{
				to add when nector details are present
			}*/
			verifyAndClick(PageProperties.getProperty("Ddcps.ContinueToSummary"),"ContinueToSummary");
		
		}
		else{
			Report.updateTestLog("The Bank Details page is not displayed in the application","FAIL");
		}
	}
	
	public void confirmDetailsAndPrivacyPolicy()
	{
		if(browser.isElementVisible(PageProperties.getProperty("Ddcps.TermsCheck")))
			{
			Report.updateTestLog("The summary page is displayed in the application", "PASS");
			verifyAndSelectCheckBoxByID(PageProperties.getProperty("Ddcps.TermsCheck"),"PrivacyPolicy");
			verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.SubmitToConfirmation"),"Submit");
			}
		else{
			Report.updateTestLog("The summary page is not displayed in the application", "FAIL");
		}
	}
	public void navigateToYourAccount()
	{
		if(browser.isTextPresent("Confirmation"))
		{
			Report.updateTestLog("The Confirmation Page is displayed in the application", "PASS");
			verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.BackToAccount"), "Your Account");
		}
		else{
			Report.updateTestLog("The Confirmation Page is not displayed in the application", "FAIL");
		}
		
	}
	
						//----------------------------DD DashBoard-----------------------------//
	
	
	public void navigateToManageDD()
	{
		verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.ManageDD"),"ManagaeDD");
		browser.wait(1000);
		verifyPageTitle("Manage your Direct Debit");
	}
	
	public void detailedPlanBreakDown()
	{
		verifyAndClickWithLinkText(PageProperties.getProperty("Ddcps.PlanBreakDownLink"),"PlanBreakDown");
		//verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.PlanBreakDown"), "PlanBreakDown");
		browser.wait(1000);
		verifyPageTitle("British Gas - Detailed plan breakdown");
		if(browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.PaymentsBreakDown")))
		{
			Report.updateTestLog("The detailed plan breakdown is displayed in the application", "PASS");
		}
		else
		{
			Report.updateTestLog("The detailed plan breakdown is not displayed in the application", "FAIL");
		}
		verifyAndClickWithLinkText(PageProperties.getProperty("Ddcps.BackToManageDDLink"), "BackToManageDD");
	}
	
	public void adjustMonthlyPayment()
	{
		verifyAndClickWithLinkText(PageProperties.getProperty("Ddcps.AdjustMonthlyPaymentLink"), "AdjustMonthlyPayment");
		//verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.AdjustMonthlyPayment"), "AdjustMonthlyPayment");
		verifyAndInputById(PageProperties.getProperty("Ddcps.NewAmount"), "NewMonthlyAmount",ddcps.getAdjustMonthlyAmount() );
		browser.wait(1000);
		verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.Recalculate"),"RecalculateNewAmount");
		browser.wait(2000);
		verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.SaveNewAmount"),"SaveNewAmount");
		if(browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.ConfirmAdjustPayOveralay")))
		{
			verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.ConfirmAdjustPayOveralay"),"ConfirmPayOverlay");
		}
		verifyPageTitle("British Gas - Manage Direct Debit Confirmation");
		browser.wait(1000);
		verifyAndClickWithLinkText(PageProperties.getProperty("Ddcps.BackToManageDDLink"), "BackToManageDD");
	}
	
	public void makeAPaymentManageDD()
	{
		verifyAndClickWithLinkText(PageProperties.getProperty("Ddcps.MakeAPaymentLink"), "MakeAPayment");
		//verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.MakeAPayment"), "MakeAPayment");
		
		verifyAndInputById(PageProperties.getProperty("Ddcps.MKPayAmount"), "Amount", ""+ddcps.getMkpAmount());
		verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.RecalculatePay"), "Recalculate");
		browser.wait(10000);
		verifyAndClick(PageProperties.getProperty("Ddcps.MakePaymentCardType"), "CardTypeDropDown");
		selectDataFromDropDownBox("2");
		verifyAndInputById(PageProperties.getProperty("Ddcps.NameOnCard"),"NameOnCard",ddcps.getCardHolderName());
		
		verifyAndInputById(PageProperties.getProperty("Ddcps.CardNumber"),"CardNumber" ,ddcps.getCardNumber());
		verifyAndClick(PageProperties.getProperty("Ddcps.CardStartMonth"),"CardStartMonth");
		selectDataFromDropDownBox(ddcps.getCardStartMonth());
		verifyAndClick(PageProperties.getProperty("Ddcps.CardStartYear"),"CardStartYear");
		selectDataFromDropDownBox(ddcps.getCardStartYear());
		verifyAndClick(PageProperties.getProperty("Ddcps.CardExpiryMonth"),"CardExpiryMonth");
		selectDataFromDropDownBox(ddcps.getCardEndMonth());
		verifyAndClick(PageProperties.getProperty("Ddcps.CardExpiryYear"),"CardExpiryYear");
		selectDataFromDropDownBox(ddcps.getCardEndYear());
		verifyAndInputById(PageProperties.getProperty("Ddcps.CardSecurityNumber"),"CardSecurityNumber" , ddcps.getCardCVV());
		verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.SubmitToMakePayment"), "MakePayment");
		
		if(browser.isTextPresent("Payment Summary"))
		{
			Report.updateTestLog("The Bank Card details are given and the Payment Summary Page is displayed","PASS");
		}
		else
		{
			Report.updateTestLog("The Payment Summary Page is not displayed","FAIL");
		}
		verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.ManagePayComplete"), "PayNow");
		verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.SubmitVisa"), "SubmitVisa");
		browser.wait(3000);
		
		verifyPageTitle("British Gas - Manage Direct Debit Confirmation");
		
		verifyAndClickWithLinkText(PageProperties.getProperty("Ddcps.BackToManageDDLink"), "BackToManageDD");
	}
	
	public void manageDDCreditRefund()
	{
		verifyAndClickWithLinkText(PageProperties.getProperty("Ddcps.GetCreditRefundLink"), "CreditRefund");
		
		//verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.GetCreditRefund"), "CreditRefund");
		
		if(browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.RefundAmount")))
		{
			Report.updateTestLog("The Credit Refund page is displayed in the application", "PASS");
			verifyAndInputByXpath(PageProperties.getProperty("Ddcps.RefundAmount"), "Amount",ddcps.getRefundAmount());
			browser.wait(1000);
			verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.RecalculateRefund"), "Recalculate");
			browser.wait(5000);
			verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.RefundButton"), "GetRefund");
			
			if(browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.ConfirmRefundOverlay")))
					{
				Report.updateTestLog("The Confirm Refund Overlay is displayed", "PASS");
				verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.ConfirmRefundOverlay"), "ConfirmOverlay");
					}
			else{
				Report.updateTestLog("The Confirm Refund Overlay is not displayed", "PASS");
			}
			browser.wait(1000);
			verifyPageTitle("British Gas - Manage Direct Debit Confirmation");
			
			verifyAndClickWithLinkText(PageProperties.getProperty("Ddcps.BackToManageDDLink"), "BackToManageDD");
		}
	}
	
	public void manageDDUpdatebankDetails()
	{
		verifyAndClickWithLinkText(PageProperties.getProperty("Ddcps.UpdateBankDetailsLink"), "UpdateBankDetails");
		//verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.UpdateBankDetails"), "UpdateBankDetails");
		
		if(browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.UpdateFirstName")))
		{
			Report.updateTestLog("The Update Bank Details Page is displayed in the application","PASS");
			verifyAndInputByXpath(PageProperties.getProperty("Ddcps.UpdateFirstName"), "UpdateFirstName",ddcps.getUpdateFirstName());
			verifyAndInputByXpath(PageProperties.getProperty("Ddcps.UpdateLastName"), "UpdateLastName",ddcps.getUpdateLastName());
			
		
			verifyAndClick(PageProperties.getProperty("Ddcps.UpdateDateOfBirth"), "DateOfBirth");
			selectDataFromDropDownBox(ddcps.getUpdateDOB());
			verifyAndClick(PageProperties.getProperty("Ddcps.UpdateMonthOfBirth"), "MonthOfBirth");
			selectDataFromDropDownBox(ddcps.getUpdateMOB());
			verifyAndClick(PageProperties.getProperty("Ddcps.UpdateYearOfBirth"), "YearOfBirth");
			selectDataFromDropDownBox(ddcps.getUpdateYOB());
			
			verifyAndInputByXpath(PageProperties.getProperty("Ddcps.UpdateSortCode1"), "UpdateSortCode1",ddcps.getUpdateSortCode1());
			verifyAndInputByXpath(PageProperties.getProperty("Ddcps.UpdateSortCode2"), "UpdateSortCode2",ddcps.getUpdateSortCode2());
			verifyAndInputByXpath(PageProperties.getProperty("Ddcps.UpdateSortCode3"), "UpdateSortCode3",ddcps.getUpdateSortCode3());
			verifyAndInputByXpath(PageProperties.getProperty("Ddcps.UpdateBankAccountNumber"), "UpdateAccountNumber",ddcps.getUpdateAccountNumber() );
			
			verifyAndClick(PageProperties.getProperty("Ddcps.UpdateDDTerms"),"DDGuarenteeTerms");
			
			verifyAndClick(PageProperties.getProperty("Ddcps.SubmitUpdate"), "SaveBankDetails");
			
			verifyPageTitle("British Gas - Manage Direct Debit Confirmation");
			verifyAndClickWithLinkText(PageProperties.getProperty("Ddcps.BackToManageDDLink"), "BackToManageDD");
			
		}
		else
		{
			Report.updateTestLog("The Update Bank Details Page is not displayed in the application","FAIL");
		}
	}
	
	public void manageDDFlexiPaymentPlan()
	{
		verifyAndClickWithLinkText(PageProperties.getProperty("Ddcps.FlexiPaymentPlan"), "FlexiPaymentPlan");
		String Amount=null;
		int i=1;
		do
		{
			if(browser.isElementVisibleWithXpath("//div["+i+"]"+PageProperties.getProperty("DdcpsFlexi.UnpaidAmountMonth")))
			{
				Amount=browser.getAttributeByXpath("//div["+i+"]"+PageProperties.getProperty("DdcpsFlexi.UnpaidAmountMonth"),  "value");
				if(Amount!="0")
				{
					verifyAndClick(PageProperties.getProperty("DdcpsFlexi.PayBreak1"), "PayBreak1");
					selectDataFromDropDownBox(i);
					browser.wait(1000);
				}
			}
			i++;
		}while(Amount=="0"||Amount==null);
		
		do
		{
			if(browser.isElementVisibleWithXpath("//div["+i+"]"+PageProperties.getProperty("DdcpsFlexi.UnpaidAmountMonth")))
			{
				Amount=browser.getAttributeByXpath("//div["+i+"]"+PageProperties.getProperty("DdcpsFlexi.UnpaidAmountMonth"),  "value");
				if(Amount!="0")
				{
				verifyAndClick(PageProperties.getProperty("DdcpsFlexi.PayBreak2"), "PayBreak2");
				selectDataFromDropDownBox(i);
					browser.wait(1000);
				}}
			i++;
		}while(Amount=="0");
		
		
		verifyIsElementVisibleById(PageProperties.getProperty("DdcpsFlexi.PlanChangeTable"), "Plan Change Overview");
		verifyAndClick(PageProperties.getProperty("DdcpsFlexi.FlexiTerms"), "FlexiTerms");
		verifyAndClickWithXpath(PageProperties.getProperty("DdcpsFlexi.ChangePlan"), "ChangePlan");
		
		if(browser.isElementVisible(PageProperties.getProperty("DdcpsFlexi.Overlay")))
				{
			verifyAndClickWithXpath(PageProperties.getProperty("DdcpsFlexi.SaveChange"), "Save");
				}
		verifyAndClickWithLinkText(PageProperties.getProperty("Ddcps.BackToManageDDLink"), "BackToManageDD");	
	}
	
	
	public void submitMeterReadInManageDD()
	{
		//TODO done for GAS only,, check for elec,Dual and  JI
		//verifyAndClickWithLinkText(PageProperties.getProperty("Ddcps.SMRLink"),"SubmitMeterReading");
		verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.SMRLinkClass"), "SubmitMeterReading");
		
		if(browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.SMROverlay")))
		{
			Report.updateTestLog("The Submit Meter OVerlay is displayed", "PASS");
			String prevSMRText = browser.getTextByXpath(PageProperties.getProperty("Ddcps.SMRPrevReading"));
			int meterDigits=prevSMRText.length();
			int smrRead=Integer.parseInt(prevSMRText);
			smrRead=smrRead+1;
			String newSMRRead=String.format("%0"+meterDigits+"d",smrRead);
			String SMRRead[]=newSMRRead.split("");
			
			for(int j=1;j<=meterDigits;j++)
			{	
				verifyAndInputByXpath((PageProperties.getProperty("Ddcps.SMRGasMeterDial")+"["+j+"]"), "meterRead", SMRRead[j]);
			}
			
			verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.SMRSubmitReading"), "Submit");
			
		}
		else
		{
			Report.updateTestLog("The Submit Meter Overlay is not displayed", "FAIL");
		}
	}
	
	public void nextInstallmentDetailsVerification()
	{
		verifyIsElementVisibleWithXpath(PageProperties.getProperty("Ddcps.NextInsDay"), "Next installment Day");
		verifyIsElementVisibleWithXpath(PageProperties.getProperty("Ddcps.NextInsMonth"), "Next Installment Month");
		verifyIsElementVisibleWithXpath(PageProperties.getProperty("Ddcps.NextInsAmount"), "Next Installment Amount");
		verifyIsElementVisibleWithXpath(PageProperties.getProperty("Ddcps.NextInsFullDate"), "Next Installment Full Date");
		verifyIsElementVisibleWithXpath(PageProperties.getProperty("Ddcps.NextInsBalAmt"), "Account Balance");
		verifyIsTextPresent(PageProperties.getProperty("Ddcps.detailedbreakdownLink"), "BreakDown Link");
	}
	public void navigatetoDirectDebit() {
		verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.DirectDebit"), "Direct Debit Link");
		
	}
	public void SignUpDD(){
		browser.wait(3000);
		verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.SignupDD"), "Sign Up Direct Debit Link");
		browser.wait(3000);
	}
	public void CreateOnlineAccount() {
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		browser.wait(3000);
		verifyPageTitle("Set up Direct Debit");
		browser.wait(3000);
		verifyAndClick(PageProperties.getProperty("Ddcps.createacct"), "Create Online Account");
		verifyAndInputById(PageProperties.getProperty("Ddcps.CustNo"), "Customer No", ddcps.getCustNo());
		uiDriver.findElement(By.id("titleSelect1_input")).click();
		uiDriver.findElement(By.id("titleSelect1_input_Mr")).click();
		verifyAndInputById(PageProperties.getProperty("Ddcps.firstname"), "First Name",ddcps.getFirstName());
		verifyAndInputById(PageProperties.getProperty("Ddcps.lastname"), "Last Name",ddcps.getLastName());
		verifyAndInputById(PageProperties.getProperty("Ddcps.email"), "Email Address",ddcps.getEmailadd());
		verifyAndInputById(PageProperties.getProperty("Ddcps.password"), "Password",ddcps.getPassword());
		verifyAndInputById(PageProperties.getProperty("Ddcps.repeatpass"), "Repeat Password",ddcps.getPassword());
		browser.wait(3000);
		uiDriver.findElement(By.id("securityQuestion1_input")).click();
		uiDriver.findElement(By.id("securityQuestion1_input_Place of birth")).click();
		verifyAndInputById(PageProperties.getProperty("Ddcps.securityAns"), "Security Answer",ddcps.getSecurityAnswer());
		if(!browser.isSelected(PageProperties.getProperty("Ddcps.checkbox")))
		{
		verifyAndClick(PageProperties.getProperty("Ddcps.checkbox"), "Terms & Cond");
		}
		verifyAndClick(PageProperties.getProperty("Ddcps.continue"), "Continue");
		}
	
	public void verifyErrorMessage() {
		if(browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.ErrorMessageTOU")))
		{
			Report.updateTestLog("Error Message is displayed", "PASS");
		}
		else
		{
			Report.updateTestLog("Error Message is NOT displayed", "FAIL");
		}
	}
	
	//// ************************* RMR changes ********************** ///
	
	public void fixedDDSetupJourney(String CustType,UserProfile userProfile){
		yourAccountsPage();
		enterMeterReadings(CustType);
		yourPaymentDatePage();
		yourPaymentAmount(userProfile);
		bankDetails();
		ReviewPage(userProfile,CustType);
		ConfirmationPage();	
	}
	
	public void yourAccountsPage(){
		if(browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.gasAccount"))){
			verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.gasAccount"),"Gas account selected");
		}
		if(browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.electricityAccount"))){
			verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.electricityAccount"),"Electricity account selected");
		}
		//// continue button of set up DD ////
		if (browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.SetUpContinueButton"))){
			verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.SetUpContinueButton"),"Continue Button of Set up is clicked");
		}
		//// Clicking Nectar term and conditions /////
		if(browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.NectarTermsAndConditions"))){
			verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.NectarTermsAndConditions"),"Nectar terms and conditions");
		}
		
		ContinueButton();
		browser.wait(15000);
		ContinueButton();	
		
	}
	
	public void ContinueButton(){
		if(browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.yourAccountContinue"))){
			verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.yourAccountContinue"),"Continue button of your accounts page is clicked");
		}
	}
	
	public void enterMeterReadings(String CustType){
		if(CustType == "Gas"){
			enterGasReadings();
		}
		if(CustType == "ElecSR"){
			enterElecSRReadings();
		}
		if(CustType == "Elec2R"){
			enterElec2RReadings();
		}
		if(CustType == "Dual" &&  CustType == "JI"){
			if(browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.gasMeterReading"))){
				enterGasReadings();
			}
			if(browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.elecSRMeterReading"))){
				enterElecSRReadings();
			}
			if(browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.elec2RMeterReading"))){
				enterElec2RReadings();
			}
		}
		if(browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.OverlayContinue"))){
			verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.OverlayContinue"),"Overlay Continue is clicked successfully");
		}
	}
    
	public void enterElec2RReadings(){
		String prevDayReading = browser.getTextByXpath(PageProperties.getProperty("Ddcps.elecDayReading"));
		String prevNightReading = browser.getTextByXpath(PageProperties.getProperty("Ddcps.elecNightReading"));
		String dayReading = (Integer.parseInt(prevDayReading) + 1) +"" ;
		String nightReading = (Integer.parseInt(prevNightReading) + 1) + "" ;
		for(int i =1 ; i<=5 ; i++){
			browser.inputByXpath(PageProperties.getProperty("Ddcps.elecDayDails".replace("[NUM]", i+"")), dayReading.charAt(i -1)+"");
		}
		
		for(int j = 1 ; j<=5 ; j++){
			browser.inputByXpath(PageProperties.getProperty("Ddcps.elecNightDails".replace("[NUM]", j+"")), nightReading.charAt(j -1)+"");
		}
	}
	
	public void enterGasReadings(){
		String prevGasReading = browser.getTextByXpath(PageProperties.getProperty("Ddcps.gasReading"));
		String gasReading = (Integer.parseInt(prevGasReading) + 1) +"" ;
		for(int i=1 ; 1<=5 ; i++){
			browser.inputByXpath(PageProperties.getProperty("Ddcps.gasDails".replace("[NUM]", i+"")), gasReading.charAt(i -1)+"");
		}
	}
	public void enterElecSRReadings(){
		String prevElecReading = browser.getTextByXpath(PageProperties.getProperty("Ddcps.elecSRReading"));
		String gasReading = (Integer.parseInt(prevElecReading) + 1) +"" ;
		for(int i=1 ; 1<=5 ; i++){
			browser.inputByXpath(PageProperties.getProperty("Ddcps.elecSRDails".replace("[NUM]", i+"")), gasReading.charAt(i -1)+"");
		}
	}
	public void yourPaymentDatePage(){
		if(browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.paymentDate"))){
			verifyAndSelectDropDownBoxByXpath(PageProperties.getProperty("Ddcps.paymentDate"), "Payment Option", "2");
		}
		ContinueButton();
	}
	
	public void yourPaymentAmount(UserProfile userProfile){
		verifyIsTextPresent(userProfile.getAccNumber());
		
	}
	
	public void bankDetails(){
		final Ddcps ddcps=new TestDataHelper().getDdcpsData("DdcpsTestData");
		if(browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.CreateBankAccount"))){
			verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.CreateBankAccount"),"Create new Bank account");
		}
		verifyAndInputByXpath(PageProperties.getProperty("Ddcps.FirstName"), "First Name", ddcps.getBankFirstName());
		verifyAndInputByXpath(PageProperties.getProperty("Ddcps.LastName"), "Last Name", ddcps.getBankLastName());
	    verifyAndSelectDropDownBox(PageProperties.getProperty("Ddcps.Date"), "Date", ddcps.getDateOfBirth());
	    verifyAndSelectDropDownBox(PageProperties.getProperty("Ddcps.Month"), "Month", ddcps.getMonthOfBirh());
	    verifyAndSelectDropDownBox(PageProperties.getProperty("Ddcps.Year"), "Year", ddcps.getYearOfBirth());
	    verifyAndInputById(PageProperties.getProperty("Ddcps.SortNum1"), "Sort Num1", ddcps.getSortCode1());
	    verifyAndInputById(PageProperties.getProperty("Ddcps.SortNum2"), "Sort Num2", ddcps.getSortCode2());
	    verifyAndInputById(PageProperties.getProperty("Ddcps.SortNum3"), "Sort Num3", ddcps.getSortCode3());
	    verifyAndInputById(PageProperties.getProperty("Ddcps.AcctNum"), "Account Number", ddcps.getBankAccountNumber());
	    verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.TermsAndConditions"),"Terms and conditions check box");
	    verifyAndClick(PageProperties.getProperty("Ddcps.ContinueButton"),"Continue Button is clicked successfully");
	}
	
	public void ReviewPage(UserProfile userProfile, String CustType){
		String region1 = userProfile.getPostCode();
		String Region = new TCRCalculationPage().getPostcode(region1);
		String tariff1 = browser.getTextByXpath(PageProperties.getProperty("Ddcps.TariffName"));
		String[] tariffval = new String[2];
		String tariff = tariffval[1];
		System.out.println("666666666666666666666666666666666 +Tariff Name:" +tariff);
		if(CustType == "Gas"){
			verifyTCRValueForGas(Region,tariff);
			verifyStandingChargeAndUnitRatesForGas(Region,tariff);
		}
		if(CustType == "ElecSR"){
			verifyTCRValueForElecSR(Region,tariff);
			verifyStandingChargeAndUnitRatesForElecSR(Region,tariff);
		}
		if(CustType == "Elec2R"){
			//verifyTCRValueForElec2R(Region,tariff);
			verifyStandingChargeAndUnitRatesForElec2R(Region,tariff);
		}
		if(CustType == "Dual" && CustType == "JI"){
			verifyTCRValueForGas(Region,tariff);
			verifyStandingChargeAndUnitRatesForGas(Region,tariff);
			verifyTCRValueForElecSR(Region,tariff);
			verifyStandingChargeAndUnitRatesForElecSR(Region,tariff);
		}
		
	}
	
	public void ConfirmationPage(){
		if(browser.isTextPresent("Your Direct Debit is now set up")){
		Report.updateTestLog("Direct Debit is set up successfully", "PASS");
		}
		else Report.updateTestLog("Direct Debit is not set up successfully", "FAIL");
	}
	public void verifyTCRValueForGas(String Region, String tariff) {
		String combination = "Gas"+tariff+"MDD"+Region;
		String TCRValue = new TCRCalculationPage().verifyTCRForGasTariff(tariff,combination);
		String TCROnScr = browser.getTextByXpath(PageProperties.getProperty("Ddcps.GastcrValue"));
		if( TCRValue.contains(TCRValue)){
			Report.updateTestLog("TCR value of Gas displayed: " +TCROnScr+ " Expected value: " +TCRValue , "PASS");
		}else{
			Report.updateTestLog("Error in TCR value of Gas displayed: " +TCROnScr+ " Expected value: " +TCRValue , "FAIL");
		}
	}
	
	public void verifyStandingChargeAndUnitRatesForGas(String Region, String tariff){
		String combination = "Gas"+tariff+"MDD"+Region;
		PriceFinderRMR priceFinder = new TestDataHelper().getPriceFinderRMR(combination);
		String SC = priceFinder.getSC();
		String SCOnScr = browser.getTextByXpath(PageProperties.getProperty("Ddcps.GasSCValue"));
		if(SCOnScr.contains(SC)){
			Report.updateTestLog("Standing Charge of Gas value displayed: " +SCOnScr+ " Expected value: " +SC , "PASS");
		}else Report.updateTestLog("Error in Standing Charge of Gas value displayed: " +SCOnScr+ " Expected value: " +SC , "FAIL");
		
		String UnitRates = priceFinder.getT1();
		String UnitsOnScr = browser.getTextByXpath(PageProperties.getProperty("Ddcps.GasUnitRates"));
		if(UnitsOnScr.contains(UnitRates)){
			Report.updateTestLog("Unit Rates of Gas value displayed: " +UnitsOnScr+ " Expected value: " +UnitRates , "PASS");
		}else Report.updateTestLog("Error in Unit Rates of Gas value displayed: " +UnitsOnScr+ " Expected value: " +UnitRates , "FAIL");
	}
	
	public void verifyTCRValueForElecSR(String Region, String tariff){
		String combination = "ElecSR"+tariff+"MDD"+Region;
		String TCRValue = new TCRCalculationPage().verifyTCRForElectricitySRTariff(tariff,combination);
		String TCROnScr = browser.getTextByXpath(PageProperties.getProperty("Ddcps.ElecSRtcrValue"));
		if( TCRValue.contains(TCRValue)){
			Report.updateTestLog("TCR value of ElecSR displayed: " +TCROnScr+ " Expected value: " +TCRValue , "PASS");
		}else{
			Report.updateTestLog("Error in TCR value of ElecSR displayed: " +TCROnScr+ " Expected value: " +TCRValue , "FAIL");
		}
	}
	public void verifyStandingChargeAndUnitRatesForElecSR(String Region,String tariff){
		String combination = "ElecSR"+tariff+"MDD"+Region;
		PriceFinderRMR priceFinder = new TestDataHelper().getPriceFinderRMR(combination);
		String SC = priceFinder.getSC();
		String SCOnScr = browser.getTextByXpath(PageProperties.getProperty("Ddcps.ElecSRSCValue"));
		if(SCOnScr.contains(SC)){
			Report.updateTestLog("Standing Charge of ElecSR value displayed: " +SCOnScr+ " Expected value: " +SC , "PASS");
		}else Report.updateTestLog("Error in Standing Charge of ElecSR value displayed: " +SCOnScr+ " Expected value: " +SC , "FAIL");
		
		String UnitRates = priceFinder.getT1();
		String UnitsOnScr = browser.getTextByXpath(PageProperties.getProperty("Ddcps.ElecSRUnitRates"));
		if(UnitsOnScr.contains(UnitRates)){
			Report.updateTestLog("Unit Rates of ElecSR value displayed: " +UnitsOnScr+ " Expected value: " +UnitRates , "PASS");
		}else Report.updateTestLog("Error in Unit Rates of ElecSR value displayed: " +UnitsOnScr+ " Expected value: " +UnitRates , "FAIL");
	}
	
	/*public void verifyTCRValueForElec2R(String Region, String tariff){
		String combination = "Elec2R"+tariff+"MDD"+Region;
		String TCRValue = new TCRCalculationPage().verifyTCRForElectricity2RTariff(tariff,"MDD",Region);
		String TCROnScr = browser.getTextByXpath(PageProperties.getProperty("Ddcps.Elec2RtcrValue"));
		if( TCRValue.contains(TCRValue)){
			Report.updateTestLog("TCR value of Elec2R displayed: " +TCROnScr+ " Expected value: " +TCRValue , "PASS");
		}else{
			Report.updateTestLog("Error in TCR value of Elec2R displayed: " +TCROnScr+ " Expected value: " +TCRValue , "FAIL");
		}
	}*/
	public void verifyStandingChargeAndUnitRatesForElec2R(String Region,String tariff){
		String combination = "Elec2R"+tariff+"MDD"+Region;
		PriceFinderRMR priceFinder = new TestDataHelper().getPriceFinderRMR(combination);
		String SC = priceFinder.getSC();
		String SCOnScr = browser.getTextByXpath(PageProperties.getProperty("Ddcps.Elec2RSCValue"));
		if(SCOnScr.contains(SC)){
			Report.updateTestLog("Standing Charge of Elec2R value displayed: " +SCOnScr+ " Expected value: " +SC , "PASS");
		}else Report.updateTestLog("Error in Standing Charge of Elec2R value displayed: " +SCOnScr+ " Expected value: " +SC , "FAIL");
		
		String UnitRates = priceFinder.getT1();
		String UnitsOnScr = browser.getTextByXpath(PageProperties.getProperty("Ddcps.Elec2RUnitRates"));
		if(UnitsOnScr.contains(UnitRates)){
			Report.updateTestLog("Unit Rates of Elec2R value displayed: " +UnitsOnScr+ " Expected value: " +UnitRates , "PASS");
		}else Report.updateTestLog("Error in Unit Rates of Elec2R value displayed: " +UnitsOnScr+ " Expected value: " +UnitRates , "FAIL");
	}
	public void navigateToDirectDebitPage(){
		browser.open(ApplicationConfig.APP_BG_URL+"/youraccount/discover/you-are-in-control-with-direct-debit.html");
		verifyAndClickWithLinkText(PageProperties.getProperty("Ddcps.SignUpDD"),"Sign up for Direct Debit");
	}
	
	public void journeyType(String ddType, UserProfile userProfile){
		if(ddType == "Login"){
			verifyAndInputByXpath(PageProperties.getProperty("Ddcps.loginEmailId"),"Email id",userProfile.getEmail());
			verifyAndInputByXpath(PageProperties.getProperty("Ddcps.passwordFeild"),"Password feild",userProfile.getPassword());
		}
		if(ddType == "ForcedReg"){
			verifyAndClick(PageProperties.getProperty("Ddcps.ForcedReg"),"Forced login is selected");
			verifyAndInputById(PageProperties.getProperty("Ddcps.CustomerNum"),"Customer Number", userProfile.getAccNumber());
			verifyAndSelectDropDownBox(PageProperties.getProperty("Ddcps.title"),"Customer Title", userProfile.getTitle());
			verifyAndInputById(PageProperties.getProperty("Ddcps.FirstName"),"First Name", userProfile.getFirstName());
			verifyAndInputById(PageProperties.getProperty("Ddcps.LastName"),"Last Name", userProfile.getLastName());
			verifyAndInputById(PageProperties.getProperty("Ddcps.LastName"),"Last Name", userProfile.getLastName());
			verifyAndInputById(PageProperties.getProperty("Ddcps.emailId"),"Email Id", userProfile.getEmail());
			verifyAndInputById(PageProperties.getProperty("Ddcps.password"),"Password", userProfile.getPassword());
			verifyAndInputById(PageProperties.getProperty("Ddcps.Resetpassword"),"Reset Password", userProfile.getPassword());
			verifyAndSelectDropDownBox(PageProperties.getProperty("Ddcps.SecurityQues"),"Security question", "Place of birth");
			verifyAndInputById(PageProperties.getProperty("Ddcps.SecurityAnswer"),"Security Answer", "Chennai");
			verifyAndClick(PageProperties.getProperty("Ddcps.terms"),"Terms and conditions is selected");
			ContinueButton();
		}
	}
	public void navigateToVariableDirectDebit(){
		browser.wait(5000);
		verifyAndClickWithXpath(PageProperties.getProperty("Ddcps.VDD"),"Variable Direct Debit is selected");
	}
	public void yourMeterReading(){
		if(browser.isElementVisibleWithXpath(PageProperties.getProperty("Ddcps.VDDGasPrevReading"))){
			
		}
	}
}
