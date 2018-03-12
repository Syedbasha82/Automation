package com.ddtransform.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Reporter;
import org.testng.annotations.Test;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;

import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import com.centrica.Report;

public class PeriodicSummaryReview {
  private WebDriver driver;
  private String baseUrl;
  private String username;
  private String password;
  private String messageshow;
    
  private boolean failCount=false;
 
@Test
  public void setUp() throws Exception {
	Report.createTestLogPath();
	Report.createTestLogHeader("Screnario1", "PeriodicSummaryReview");
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
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Manage account")).click();          
        Report.updateTestLog("Click Manage Account Link", "PASS");
    } catch (Exception e) {
		Report.updateTestLog("Click Manage Account Link", "FAIL");
		failCount=true;
		testResult();
	}
    try {
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	messageshow=driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div[2]/div[3]/div[2]/div/div[4]/div[3]/p")).getText();
    	Assert.assertEquals("We've changed your monthly payments from �"+ initialAmount +" to �"+ finalAmount +".", messageshow);
        Report.updateTestLog("Peridic Amount Adjustment", "PASS");
    } catch (Exception e) {
		Report.updateTestLog("Peridic Amount Adjustment", "FAIL");
		failCount=true;
		testResult();
	}
    
    try {
    	driver.findElement(By.linkText("Log out")).click();
    	driver.close();
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
	    //driver.close();
	    System.exit(0);
  }
}