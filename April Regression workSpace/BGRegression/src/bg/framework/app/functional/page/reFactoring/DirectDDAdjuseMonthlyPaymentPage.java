package bg.framework.app.functional.page.reFactoring;

import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.sql.Array;
import java.util.ArrayList;
import java.lang.Float;
import java.lang.*;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import bg.framework.common.functional.UIDriver;
import bg.framework.common.functional.WebDriverProvider;


public class DirectDDAdjuseMonthlyPaymentPage extends BasePage {
	private final static String FILE_NAME = "resources/ReFactoring/AdjuseMonthlyPaymentPage.Properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
    
    public static String Directdebitamount;
    public static String MonthlyPayment;
    public static String Directdebitamountfinal;
    public static String MonthlyPaymentfinal;
    public static String NewPaymentAmount;
    public static String NewPaymentAmountfinal;
    public static int Directdebitint;
    public static int MonthlyPaymentint;
    public static int min;
    public static String Afteradjustment_Payment;
    public static String Afteradjustment_Year_Balance;
    
    public void navigatetoManageyourdirectdebitPage(){
    	browser.wait(5000);
    	Report.updateTestLog("Accout Page", "WARN");
    	verifyAndClickWithXpath(pageProperties.getProperty("AdjuseMonthlyPayment.Manageyourdirectdebit"), "Direct Debit");
    	Report.updateTestLog("Manage Your Direct Debit Page", "WARN");
        }
    public void navigatetoMonthlyPaymentPage(){
    	browser.wait(5000);
    	verifyAndClickWithXpath(pageProperties.getProperty("AdjuseMonthlyPayment.MonthlyPaymentPage"), "Adjust monthly payment");
    	Report.updateTestLog("Adjust monthly payment Page", "WARN");
    	}
    public void verifyPaymentAmount(){
    	browser.wait(5000);
    	Directdebitamount = browser.getTextByXpath(pageProperties.getProperty("AdjuseMonthlyPayment.directDebitAmount"));
    	Directdebitamountfinal = Directdebitamount.replaceAll("[^0-9.]", " ").trim();
    	Report.updateTestLog("Direct Debit amount is: "+ Directdebitamount, "PASS");
    	/*MonthlyPayment = browser.getTextByXpath(pageProperties.getProperty("AdjuseMonthlyPayment.MonthlyPayment"));
    	MonthlyPaymentfinal = MonthlyPayment.replaceAll("[^0-9.]", " ").trim();
    	Report.updateTestLog("Monthly Payment amount is: "+ MonthlyPaymentfinal, "PASS");*/
    	NewPaymentAmount = browser.getTextByXpath(pageProperties.getProperty("AdjuseMonthlyPayment.NewPaymentAmount"));
    	NewPaymentAmountfinal = NewPaymentAmount.replaceAll("[^0-9.]", " ").trim();
    	Report.updateTestLog("New Payment amount is: "+ NewPaymentAmountfinal, "PASS");
    }
    public void verifysmallnumber()
    {
    	System.out.println("**********************************");
    	float Directdebitamountfloat  = Float.parseFloat(Directdebitamountfinal);
    	System.out.println("The Direct Debit Amount is Converted into float is " +Directdebitamountfloat );
    	Directdebitint = (int)Math.round(Directdebitamountfloat);
    	System.out.println("The Direct Debit Amount is Converted into int is " +Directdebitint );
    	System.out.println("-------------------------------------");
    	/*float MonthlyPaymentfloat  = Float.parseFloat(MonthlyPaymentfinal);
    	System.out.println("The Direct Debit Amount is Converted into float is " +MonthlyPaymentfloat );
    	MonthlyPaymentint = (int)Math.round(MonthlyPaymentfloat);
    	System.out.println("The Monthly Payment Amount is Converted into int is " + MonthlyPaymentint );*/
    	
    	if (Directdebitint>MonthlyPaymentint)
    	{
    		min =  MonthlyPaymentint;
    		System.out.println("::::::::::::::::::");
    		System.out.println("@@@@@@@@@@@@@@@@ Smallest number is"+min );
    		Report.updateTestLog("Comparing the Smallest number between Direct Debit amount and Monthly Payment amount  is: "+ min, "PASS");
    	 }
    	if (Directdebitint<MonthlyPaymentint)
    	{
    		min =  Directdebitint;
    		System.out.println("&&&&&&&&&&&&&&&&&&&&&&& Smallest number is"+min );
    		Report.updateTestLog("Comparing the Smallest number between Direct Debit amount and Monthly Payment amount  is: "+ min, "PASS");
    	}	
    }
    public void ComparePaymentAmount(){
    	
    	float NewPaymentAmountfloat  = Float.parseFloat(NewPaymentAmountfinal);
    	System.out.println("The New Payment Amount is Converted into float is " +NewPaymentAmountfloat );
    	Float minimumfloat = new Float(min);
    	
    	
    	
    	if(NewPaymentAmountfloat==minimumfloat)
    	{
    		Report.updateTestLog("The New Payment amount is populating the smallest Amount "+minimumfloat, "PASS");
    	}
    	else
    	{
    		Report.updateTestLog("The New Payment amount is not populating correct Amount ","Fail");
    	}
    }
    public void EnterPaymentAmount()
    {
    	verifyAndInputByXpath(pageProperties.getProperty("AdjuseMonthlyPayment.EnterPaymentAmount"), "Enter the Payment amount", "70");
    	verifyAndClickWithXpath(pageProperties.getProperty("AdjuseMonthlyPayment.RecalculateButton"),"Recalculate Button");
    
    }
    public void ValidateAdjustmentAmount()
    {
    	browser.wait(5000);
    	Afteradjustment_Payment = browser.getTextByXpath(pageProperties.getProperty("AdjuseMonthlyPayment.After_Monthly_Payment"));
    	Report.updateTestLog("Monthly Payment amount After the Adjustment is: "+ Afteradjustment_Payment, "PASS");
    	Afteradjustment_Year_Balance = browser.getTextByXpath(pageProperties.getProperty("AdjuseMonthlyPayment.After_Endofyearbalance"));
    	Report.updateTestLog("Monthly Payment amount After the Adjustment is: "+ Afteradjustment_Year_Balance, "PASS"); 
    }
    public void VerifyConfirmationPage()
    {
    	browser.wait(5000);
    	verifyAndClickWithXpath(pageProperties.getProperty("AdjuseMonthlyPayment.SaveButton"),"Save Button");
    	browser.wait(1000);
    	verifyAndClickWithXpath(pageProperties.getProperty("AdjuseMonthlyPayment.SubmitButton"),"Continue Button");
    	browser.wait(getWaitTime());
    	String confirm = browser.getTextByXpath(pageProperties.getProperty("AdjuseMonthlyPayment.ConfirmationPage"));
    	Report.updateTestLog(confirm+ "Content Is Populated", "WARN");
    }
    
    
    
    
      	
    	
    }
    
    
    
   

    

