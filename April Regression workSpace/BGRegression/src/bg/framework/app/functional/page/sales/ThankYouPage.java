package bg.framework.app.functional.page.sales;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import bg.framework.app.functional.action.sales.AcquisitionAction;
import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.RunQTP;
import bg.framework.app.functional.util.SshClient;

import com.jcraft.jsch.JSchException;


public class ThankYouPage extends BasePage {
	//private final static String FILE_NAME = "resources/sales/"+ApplicationConfig.BRAND+"Acquisition.properties";
	private final static String FILE_NAME = "resources/ReFactoring/BGAcquisition.properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
   
    
    String date=new OnlineDBConnector().DBsysdate();
    OnlineDBConnector dbconnector = new OnlineDBConnector();
    
    
    private static String dataXml;

    public ThankYouPage() {
    }

    public ThankYouPage(Acquisition acquisition) {

    }

    public AcquisitionAction verifyThankYouPage(UserProfile userProfile) {
    	Report.updateTestLog("Thank You Page Order","WARN");
        browser.wait(getWaitTime());
        if (browser.isElementVisible(pageProperties.getProperty("Acquisition.ThankYouPage"))) {
            Report.updateTestLog("ThankYouPage Verification has been done Succesfully", "PASS");
        } else {
            Report.updateTestLog("ThankYouPage Verification has not been done successfully", "FAIL");
        }
        browser.wait(getWaitTime());         
        
        return new AcquisitionAction();
    }
    
    
/*    public AcquisitionAction verifyAuditTable(){
    String = dbconnector.*/
    
    
    
    
    
    public AcquisitionAction gobacktoaccountsummarypageSMB(UserProfile userProfile) {
    	        
        browser.clickWithLinkText(pageProperties.getProperty("SMB.backtoacntoverview"));
        verifyAndClickWithXpath((pageProperties.getProperty(
        "AccountOverviewPage.ManageAccountXPath").replace("USERACCOUNTNUMBER",
         		userProfile.getAccNumber())), "Account summary");
        browser.wait(1000);
        String accTypeInApp = browser.getTextByXpath(pageProperties.getProperty("AccountOverviewPage.FuelTypeXPath").replace("NUMBER",userProfile.getAccNumber()));
        
        return new AcquisitionAction();
    }

    public AcquisitionAction logoutThankYouPage() {

        browser.wait(getWaitTime());
        //if (browser.isTextPresent(pageProperties.getProperty("Acquisition.Logout1"))) {
            //browser.clickWithLinkText(pageProperties.getProperty("Acquisition.Logout1"));
        //}
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.Logout"))) {
            browser.clickWithXpath(pageProperties.getProperty("Acquisition.Logout"));
        }
        browser.wait(getWaitTime());
        return new AcquisitionAction();

    }

    public AcquisitionAction backToHomePage() {
    	
        browser.wait(getWaitTime());
        if (browser.isElementVisibleWithXpath(pageProperties.getProperty("Acquisition.BackToHomePage"))) {
            browser.clickWithXpath(pageProperties.getProperty("Acquisition.BackToHomePage"));

        }
       
        else  if (browser.isTextPresent(pageProperties.getProperty("Acquisition.Home"))) {
            browser.clickWithLinkText(pageProperties.getProperty("Acquisition.Home"));
        }
    	
        browser.wait(getWaitTime());

        return new AcquisitionAction();
    }

    public AcquisitionAction energySmart(String accountNumber) {
       
        
        RunQTP runQTP = new RunQTP();

        //runQTP.runQTP("ChangeTariff.vbs", accountNumber);

        return new AcquisitionAction();
    }
    
    
    public static void main(String ar[]) throws InterruptedException
    {
   	    System.out.println("Entered");    	 
        RunQTP runQTP = new RunQTP();
        System.out.println("Before Invocation");
        Thread.sleep(5000);
        runQTP.runQTP("BGRegression\\src\\bg\\framework\\app\\functional\\util\\vbsScripts\\Smart.vbs", "850013914965");
        System.out.println("Final");
    }

    public AcquisitionAction deRegisterEsmart(String accountNumber)
    {
   	    System.out.println("Entered");    	 
        RunQTP runQTP = new RunQTP();
        System.out.println("Before Invocation");
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        runQTP.runQTP("BGRegression\\src\\bg\\framework\\app\\functional\\util\\vbsScripts\\Smart.vbs", accountNumber);
        System.out.println("Final");
        //850013914965
        return new AcquisitionAction();  
    }
        
    public AcquisitionAction changeTariff (String accountNumber){
    	 
    	 System.out.println("Entered");    	 
         RunQTP runQTP = new RunQTP();
         System.out.println("Before Invocation");
         browser.wait(5000);
         runQTP.runQTP("BGRegression\\src\\bg\\framework\\app\\functional\\util\\vbsScripts\\ChangeTariff.vbs", accountNumber);
         
         browser.wait(10000);
         String tariffcode = null;
         String tariff = null;

         try {
             
             File file = new File("C:\\SAPData\\balance.txt");
             
             FileReader fr1 = new FileReader(file);
             BufferedReader br1 = new BufferedReader(fr1);

             
             tariffcode = br1.readLine();
             tariff = br1.readLine();
             System.out.println(tariff);
             System.out.println(tariffcode);
             
             if (tariffcode.equals("G98") && tariff.equalsIgnoreCase("Clear & Simple")){
            	 Report.updateTestLog(" Tariff code Updated in SAP for " +tariff  + " is " +tariffcode ,"PASS");
            	 
             }else if (tariffcode.equals("E98") && tariff.equalsIgnoreCase("Clear & Simple")){
            	 Report.updateTestLog(" Tariff code Updated in SAP for " +tariff  + " is " +tariffcode ,"PASS");
            	 
             }else if (tariffcode.equals("G99") && tariff.equalsIgnoreCase("Fixed Price May 2014")){
            	 Report.updateTestLog(" Tariff code Updated in SAP for " +tariff  + " is " +tariffcode ,"PASS");
            	 
             }else if (tariffcode.equals("E99") && tariff.equalsIgnoreCase("Fixed Price May 2014")){
            	 Report.updateTestLog(" Tariff code Updated in SAP for " +tariff  + " is " +tariffcode ,"PASS");
            	 
             }else if (tariffcode.equals("G8L")){
            	 Report.updateTestLog(" Tariff code Updated in SAP for " +tariff  + " is " +tariffcode ,"PASS");
            	 
             }else if (tariffcode.equals("E8L")){
            	 Report.updateTestLog(" Tariff code Updated in SAP for " +tariff  + " is " +tariffcode ,"PASS");
            	 
             }
             else{
            	 Report.updateTestLog(" Tariff code not Updated in SAP " ,"FAIL");
            	 
             }
             
             br1.close();
             } catch (IOException e) {
             
         }
         
         return new AcquisitionAction();  
         
    }

    public AcquisitionAction domarssalesRunBatch(String batch){
    	
    	 SshClient sshClient = new SshClient();
    	 
    	 try {
             sshClient.connect();
             if(sshClient.isConnected()){
            	 
                  System.out.println(sshClient.send("cd scripts/"));
                  
                  System.out.println(sshClient.send("ls"));
                         
                  String strBatch=batch;
                  System.out.println(strBatch);
                  
                  if (ApplicationConfig.BRAND.equalsIgnoreCase("bg")){                                 
                  System.out.println(sshClient.send(strBatch));
                  }                  
                  else
                  {
                	  System.out.println(sshClient.send("./doacquisitionmarsProcess.sh"));
                  }
                  
                  browser.wait(70000);
                
                  
                  sshClient.send("clear");
                  
                  if (ApplicationConfig.BRAND.equalsIgnoreCase("bg")){
                	  		if(strBatch.equals("./doacquisitionmarsProcess.sh")){
        	  				System.out.println("Entered into Energy Shop"); 
        	  				sshClient.send("cd /shared/online/datafiles/outbound/mars/out");  
                            }
                            else {
                	 		System.out.println("Entered into Energy Smart Batch"); 
                	 		sshClient.send("cd /shared/online/datafiles/outbound/mars/out");	 
                             }
                  }
                  else{
                	  System.out.println("Entered into Fusion Energy Shop"); 
                	  sshClient.send("cd /shared/online/datafiles/outbound/fusionmars/archive");
                  }
                  
                  browser.wait(40000);
              
                 
                  String strCSVList=sshClient.send("ls -l").toString();
                  System.out.println(strCSVList);
                
                  String[] arrstrLogXml =  strCSVList.split("\n");
                  ArrayList<String> xmlFiles=new ArrayList<String>();
                  

                  for(String fileName: arrstrLogXml){
                	  fileName=fileName.trim();   
                	  
                	  if(fileName.endsWith("xml"))
                	  {
                		 xmlFiles.add(fileName);                		 
                	  }
                  }
                  
                  if (ApplicationConfig.BRAND.equalsIgnoreCase("bg")){
                  String xml=xmlFiles.get(xmlFiles.size()-1).substring(xmlFiles.get(xmlFiles.size()-1).indexOf('H'));              
                  System.out.println(xmlFiles.get(xmlFiles.size()-1));
                  dataXml=sshClient.send("cat " + xml);
                  System.out.println(dataXml);
                  
                    
                 Report.updateTestLog("Log file has been generated Succesfully " +dataXml, "PASS");
                  }
                  
                  else{
                	  System.out.println(xmlFiles+" Is the file list :::::::::::::::::::::::::::::::::::::::::::::");
                	  String xml=xmlFiles.get(xmlFiles.size()-1).substring(xmlFiles.get(xmlFiles.size()-1).indexOf('B'));              
                      System.out.println(xmlFiles.get(xmlFiles.size()-1));
                      dataXml=sshClient.send("cat " + xml);
                      System.out.println(dataXml);                                            
                     Report.updateTestLog("Log file has been generated Succesfully " +dataXml, "PASS"); 
                  }
                 sshClient.disconnect();
             }    
         } catch (JSchException e) {
             e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
         } catch (IOException e) {
             e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
         } catch (InterruptedException e) {
             e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
         }
    		      
    	 return new AcquisitionAction();    	 
    	
    }
    
    
   public AcquisitionAction checkMediaCode(String mediaCode){	   	   
	   System.out.println(dataXml);
	   
	   if (dataXml.contains(mediaCode)) {
           Report.updateTestLog("Media Code Verification  " + mediaCode+ " is Present in Extracted Batch XML", "PASS");
       } 
	   
	   
	  else {
           Report.updateTestLog("Media Code Verification  " + mediaCode + " is not Present in Extracted Batch XML", "FAIL");
       } 	
	   
	   return new AcquisitionAction();
	   
   }
    
    public AcquisitionAction deleteWTP(UserProfile userProfile){
    	
    	String strEmail;
        strEmail=userProfile.getEmail();
       
    	new OnlineDBConnector().deleteWTP(strEmail);
    	Report.updateTestLog("WTP Account is Deleted Successfully " +strEmail, "PASS");
    	return new AcquisitionAction();
    	
    }
    
    
    public AcquisitionAction goToGasFixandFallNovember(){
    	
    	//browser.open("https://10.224.70.95/EnergyFeature/EnergySales/orderType/FixedPriceMay2014/feature/EnergySmart/energyType/Gas/");
    	browser.open(ApplicationConfig.APP_BG_URL+"/EnergyShop/EnergySales/orderType/FixAndFallNovember2013/energyType/Gas/");
    	Report.updateTestLog("Navigation To Fix and Fall November 2013 Energy Gas Page", "Pass");
    	return new AcquisitionAction();
    }
    
    public AcquisitionAction goToElecFixandFallNovember(){
    	
    	//browser.open("https://10.224.70.95/EnergyFeature/EnergySales/orderType/FixedPriceMay2014/feature/EnergySmart/energyType/Elec/");
    	browser.open(ApplicationConfig.APP_BG_URL+"/EnergyShop/EnergySales/orderType/FixAndFallNovember2013/energyType/Elec/");
    	Report.updateTestLog("Navigation To Fix and Fall November 2013 Energy Electricity Page", "Pass");
    	return new AcquisitionAction();
    }
    
    public AcquisitionAction goToDualFixandFallNovember(){
	
	//browser.open("https://10.224.70.95/EnergyFeature/EnergySales/orderType/FixedPriceMay2014/feature/EnergySmart/energyType/Dual/");
    browser.open(ApplicationConfig.APP_BG_URL+"/EnergyShop/OrderDetails/tariffName/fix-and-fall-november-2013/fuelType/gas");
	Report.updateTestLog("Navigation To Fix and Fall November 2013 Dual Page", "Pass");
	return new AcquisitionAction();
    }
    
    
   public AcquisitionAction goToGasFixAndFallMarch(){
    	
    	//browser.open("https://10.224.70.95/EnergyFeature/EnergySales/orderType/OnlineVariableAugust2013/feature/EnergySmart/energyType/Gas/");
    	browser.open(ApplicationConfig.APP_BG_URL+"/EnergyShop/EnergySales/orderType/FixAndFallMarch2014/energyType/Gas/ ");
    	Report.updateTestLog("Navigation to Fix And Fall March 2014 Gas Page", "Pass");
    	return new AcquisitionAction();
    }
    public AcquisitionAction goToElecFixAndFallMarch(){
    	
    	//browser.open("https://10.224.70.95/EnergyFeature/EnergySales/orderType/OnlineVariableAugust2013/feature/EnergySmart/energyType/Elec/");
    	browser.open(ApplicationConfig.APP_BG_URL+"/EnergyShop/EnergySales/orderType/FixAndFallMarch2014/energyType/Elec/");
    	Report.updateTestLog("Navigation to Fix And Fall March 2014 Electricity  Page", "Pass");
    	return new AcquisitionAction();
    }
    public AcquisitionAction goToDualFixAndFallMarch(){
	
	//browser.open("https://10.224.70.95/EnergyFeature/EnergySales/orderType/OnlineVariableAugust2013/feature/EnergySmart/energyType/Dual/");
	browser.open(ApplicationConfig.APP_BG_URL+"/EnergyShop/EnergySales/orderType/FixAndFallMarch2014/energyType/Dual/");
	Report.updateTestLog("Navigation to Fix And Fall March 2014 Dual Page", "Pass");
	return new AcquisitionAction();
    }
    
    
public AcquisitionAction goToGasFixandFallNovemberesmart(){
    	
    	//browser.open("https://10.224.70.95/EnergyFeature/EnergySales/orderType/FixedPriceMay2014/feature/EnergySmart/energyType/Gas/");
    	browser.open(ApplicationConfig.APP_BG_URL+"/EnergyFeature/EnergySales/orderType/FixAndFallNovember2013/feature/EnergySmart/energyType/Gas/");
    	Report.updateTestLog("Navigation To Fix and Fall November 2013 E-Smart Gas Page", "Pass");
    	return new AcquisitionAction();
    }
    
    public AcquisitionAction goToElecFixandFallNovemberesmart(){
    	
    	//browser.open("https://10.224.70.95/EnergyFeature/EnergySales/orderType/FixedPriceMay2014/feature/EnergySmart/energyType/Elec/");
    	browser.open(ApplicationConfig.APP_BG_URL+"/EnergyFeature/EnergySales/orderType/FixAndFallNovember2013/feature/EnergySmart/energyType/Elec/");
    	Report.updateTestLog("Navigation To Fix and Fall November 2013  E-Smart Electricity Page", "Pass");
    	return new AcquisitionAction();
    }
    
    public AcquisitionAction goToDualFixandFallNovemberesmart(){
	
	//browser.open("https://10.224.70.95/EnergyFeature/EnergySales/orderType/FixedPriceMay2014/feature/EnergySmart/energyType/Dual/");
    browser.open(ApplicationConfig.APP_BG_URL+"/EnergyFeature/EnergySales/orderType/FixAndFallNovember2013/feature/EnergySmart/energyType/Dual/");
	Report.updateTestLog("Navigation To Fix and Fall November 2013 E-Smart Dual Page", "Pass");
	return new AcquisitionAction();
    }
    
    
   public AcquisitionAction goToGasFixAndFallMarchesmart(){
    	
    	//browser.open("https://10.224.70.95/EnergyFeature/EnergySales/orderType/OnlineVariableAugust2013/feature/EnergySmart/energyType/Gas/");
    	browser.open(ApplicationConfig.APP_BG_URL+"/EnergyFeature/EnergySales/orderType/FixAndFallMarch2014/feature/EnergySmart/energyType/Gas/");
    	Report.updateTestLog("Navigation to Fix And Fall March 2014 E-Smart Gas Page", "Pass");
    	return new AcquisitionAction();
    }
    public AcquisitionAction goToElecFixAndFallMarchesmart(){
    	
    	//browser.open("https://10.224.70.95/EnergyFeature/EnergySales/orderType/OnlineVariableAugust2013/feature/EnergySmart/energyType/Elec/");
    	browser.open(ApplicationConfig.APP_BG_URL+"/EnergyFeature/EnergySales/orderType/FixAndFallMarch2014/feature/EnergySmart/energyType/Elec/");
    	Report.updateTestLog("Navigation to Fix And Fall March 2014 E-Smart Electricity  Page", "Pass");
    	return new AcquisitionAction();
    }
    public AcquisitionAction goToDualFixAndFallMarchesmart(){
	
	
	browser.open(ApplicationConfig.APP_BG_URL+"/EnergyFeature/EnergySales/orderType/FixAndFallMarch2014/feature/EnergySmart/energyType/Dual/");
	Report.updateTestLog("Navigation to Fix And Fall March 2014 E-Smart Dual Page", "Pass");
	return new AcquisitionAction();
    }
    
    
    
   public AcquisitionAction goToGasClearAndSimplesmart(){
    	
    	//browser.open("https://10.224.70.95/EnergyFeature/EnergySales/orderType/ClearAndSimple/feature/EnergySmart/energyType/Gas/");
    	browser.open(ApplicationConfig.APP_BG_URL+"/EnergyShop/EnergySales/orderType/ClearAndSimple/energyType/Gas/");
    	Report.updateTestLog("Navigation to ClearAndSimple GasPage", "Pass");
    	return new AcquisitionAction();
    }
    public AcquisitionAction goToElecClearAndSimplesmart(){
    	
    	//browser.open("https://10.224.70.95/EnergyFeature/EnergySales/orderType/ClearAndSimple/feature/EnergySmart/energyType/Elec/");
    	browser.open(ApplicationConfig.APP_BG_URL+"/EnergyShop/EnergySales/orderType/ClearAndSimple/energyType/Elec/");
    	Report.updateTestLog("Navigation to ClearAndSimple Elec Page", "Pass");
    	return new AcquisitionAction();
    }
    public AcquisitionAction goToDualClearAndSimplesmart(){
	
	//browser.open("https://10.224.70.18/EnergyFeature/EnergySales/orderType/ClearAndSimple/feature/EnergySmart/energyType/Dual/");
    browser.open(ApplicationConfig.APP_BG_URL+"/EnergyShop/EnergySales/orderType/ClearAndSimple/energyType/Dual/");
	Report.updateTestLog("Navigation to ClearAndSimple DualPage", "Pass");
	return new AcquisitionAction();
    }
    
    public AcquisitionAction goToSEDualpricepledgenovember(){
    	
    	//browser.open("https://10.224.70.18/EnergyFeature/EnergySales/orderType/ClearAndSimple/feature/EnergySmart/energyType/Dual/");
        browser.open(ApplicationConfig.APP_BG_URL+"/EnergyShop/OrderDetails/tariffName/price-pledge-november-2013/fuelType/Dual");
    	Report.updateTestLog("Navigation to Price Pledge November 2013 DualPage", "Pass");
    	return new AcquisitionAction();
        } 
    public AcquisitionAction verifyInAccountSummaryPage()
    {
    	/*if(browser.isTextPresent("Account overview"))
    	{
    		browser.clickWithLinkText("Account overview");
    	}*/
    	
    	return new AcquisitionAction();
    }
    
    
    
}
