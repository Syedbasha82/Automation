package com.ddtransform.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Reporter;
import org.testng.annotations.Test;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.apache.http.util.Asserts;
import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import com.centrica.Report;

public class HonourAmountAdjustment {
  private WebDriver driver;
  private String baseUrl;
  private String username;
  private String password;
  private String messageshow;  
  private String ddReviewMessage;
  private boolean failCount=false;
 
@Test
  public void setUp() throws Exception {
	Report.createTestLogPath();
	Report.createTestLogHeader("Screnario6", "RapidAmountAdjustment");
	driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    Report.updateTestLog("Open Browser", "PASS");
  }

@Test
@Parameters ({"baseUrl","username","password","initialAmount","finalAmount"})
  public void testIncrease(String baseUrl,String username,String password,String initialAmount,String finalAmount) throws Exception{
	
	
    try{
	  driver.get(baseUrl);
	  Report.updateTestLog("Open BG Homepage", "PASS");
    }
    catch(Exception e){
    	Report.updateTestLog("Open BG Homepage", "FAIL");
    	failCount=true;
    	testResult();
    }
    
    try {
    	driver.findElement(By.id("email")).clear();
    	driver.findElement(By.id("email")).sendKeys (username);
    	Report.updateTestLog("Enter Email ID", "PASS");
	} catch (Exception e) {
		Report.updateTestLog("Enter Email ID", "FAIL");
		failCount=true;
		testResult();
	}
    try {
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys (password);
    	Report.updateTestLog("Enter Password", "PASS");
	} catch (Exception e) {
		Report.updateTestLog("Enter Password", "FAIL");
		failCount=true;
		testResult();
	}
    try {
    	driver.findElement(By.id("login")).click();
    	Report.updateTestLog("Click Login Button", "PASS");
    	
	} catch (Exception e) {
		Report.updateTestLog("Click Login Button", "FAIL");
		failCount=true;
		testResult();
	}

    try {
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Manage account")).click();          
        Report.updateTestLog("Click Manage Account Link", "PASS");
    } catch (Exception e) {
		Report.updateTestLog("Click Manage Account Link", "FAIL");
		failCount=true;
		testResult();
	}
 
    try {
    	driver.findElement(By.linkText("Manage your Direct Debit")).click();         
        Report.updateTestLog("Manage your Direct Debit", "PASS");
    } catch (Exception e) {
		Report.updateTestLog("Manage your Direct Debit", "FAIL");
		failCount=true;
		testResult();
	}
    try {
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	ddReviewMessage=driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div[2]/div[3]/div/div[7]/div/div/div/div/div[3]/div/div/p/span")).getText();
        Assert.assertEquals("Your payments have changed", ddReviewMessage);
        Report.updateTestLog("Honoured Amount Adjustment Refelection", "PASS");
    } catch (Exception e) {
		Report.updateTestLog("Honoured Amount Adjustment Refelection", "FAIL");
		failCount=true;
		testResult();
	}
    
    try {
    	driver.findElement(By.linkText("Log out")).click();
    	Report.updateTestLog("Click Log Out", "PASS");
    }
   catch (Exception e) {
		Report.updateTestLog("Click Log Out", "FAIL");
		failCount=true;
		testResult();
	}
  testResult();
  }


public void testResult(){
	  if (failCount==true)
	    {
	    	Report.blnFailFlag=true;
	    	
	    }
	    else
	    {
	    	Report.blnFailFlag=false;
	    }
	    Report.updateTestSummary();
	    driver.close();
	    System.exit(0);
  }
}