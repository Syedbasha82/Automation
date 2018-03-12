package bg.framework.app.functional.page.Slingshot;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.bcel.verifier.VerifyDialog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

import com.thoughtworks.selenium.Selenium;


import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.entities.CrmUserProfile;
import bg.framework.common.functional.UIDriver;
import bg.framework.app.functional.util.RobotSendKeys;

public class SapCrmPage extends BasePage {
    String Payment=null;
	private final static String FILE_NAME="resources/Slingshot/SapCrm.properties";
	private static Properties pageProperties=new PropertyLoader(FILE_NAME).load();
	List<String> Acctnoarray = new ArrayList<String>();
	protected UIDriver uiDriver;
        DateFormat Dt = new SimpleDateFormat("dd.MM.yyyy");
	public void openCRMUrl(){
		//browser.open(ApplicationConfig.CRM_Url);
		
		browser.open("http://sapcr4ci.uk.centricaplc.com:8002/sap/bc/bsp/sap/crm_ui_start/default.htm?sap-client=300&sap-sessioncmd=open");		
    	browser.wait(getWaitTime());
	}
	
	public void enterLoginDetails(CrmUserProfile crmuserProfile){
		    	
		verifyAndInputById(pageProperties.getProperty("SapCrmPage.username"), "Username",crmuserProfile.getusername());
		verifyAndInputById(pageProperties.getProperty("SapCrmPage.password"), "Password",crmuserProfile.getpassword());
		
		verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.logon"), "Click-Submit");
		dynamicWait(pageProperties.getProperty("SapCrmPage.SearchFunctionId"), "id");
		//verify title
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("SapCrmPage.logonContinue1"))){
			verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.logonContinue1"), "Click-Continue");
		}
		
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("SapCrmPage.businessrole")))
		verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.businessrole"), "Click-Agentworkbench");
		
		/*getWaitTime();
        browser.open("http://crmqalq7.uk.centricaplc.com:8000/sap/bc/bsp/sap/crm_ui_start/default.htm?sap-client=100&sap-sessioncmd=open"); 
		*/
	}
	
	
    public void fetchDetailsandInsert(CrmUserProfile crmuserProfile){
    	
    	System.out.println("Dynamic wait before");
    	dynamicWait(pageProperties.getProperty("SapCrmPage.SearchBy"), "xpath");
    	System.out.println("Dynamic wait after");
    	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.SearchBy"), "Click-SearchByDropdown");
    	browser.selectfromDropBoxByXpath(pageProperties.getProperty("SapCrmPage.SearchBy"), "Contact Business Partner ID");
    	verifyAndInputById(pageProperties.getProperty("SapCrmPage.ReferenceNumber"), "Reference Number", crmuserProfile.getreferencenumber());
    	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.Search"), "Click-Search");
    	
	}
    
    public void searchByAccountId(CrmUserProfile crmuserProfile){
    	dynamicWait(pageProperties.getProperty("SapCrmPage.SearchFunctionId"), "id");
    	if(browser.isElementVisible(pageProperties.getProperty("SapCrmPage.SearchFunctionId"))){
    		System.out.println("Search Elelment is visible");
    		verifyAndInputById(pageProperties.getProperty("SapCrmPage.AccountNumberId"), "Account_Id",crmuserProfile.getaccountId());
    		verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.SearchXpath"),"Search button");
    	}
    	else{
    		Report.updateTestLog("Properties not correct", "FAIL");
    	}
    	verifyAndInputById(pageProperties.getProperty("SapCrmPage.AccountNumberId"), "Account_Id",crmuserProfile.getaccountId());
		verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.SearchXpath"),"Search button");
	
    }
    
    public void UserssearchByAccountId(CrmUserProfile crmuserProfile){
    	/*dynamicWait(pageProperties.getProperty("SapCrmPage.SearchFunctionId"), "id");
    	if(browser.isElementVisible(pageProperties.getProperty("SapCrmPage.SearchByAcctNo"))){
    		System.out.println("Search Elelment is visible");
    		verifyAndInputById(pageProperties.getProperty("SapCrmPage.SearchByAcctNo"), "Account_Id",crmuserProfile.getaccountId());
    		verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.SearchUsersByAcctno"),"Search button");
    	}
    	else{
    		Report.updateTestLog("Properties not correct", "FAIL");
    	}*/
    	verifyAndInputById(pageProperties.getProperty("SapCrmPage.SearchByAcctNo"), "Account_Id",crmuserProfile.getaccountId());
	     verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.SearchUsersByAcctno"),"Search button");
	
    }
    public void dynamicWait(String property,String propertyname){
    	int count=1;
    	do{
    		
				try {
					Thread.sleep(50000);
				} catch (InterruptedException e) {
					getWaitTime();
					e.printStackTrace();
				}
			
    		if(propertyname.equalsIgnoreCase("xpath")){
    			
				if(browser.isElementVisibleWithXpath(property))break;
				System.out.println("xpath-condition");
    		}else if(propertyname.equalsIgnoreCase("id")){
    			
    			if(browser.isElementVisible(property))break;
    			System.out.println("id-condition");
    		}    		   		
    		System.out.println("Count value"+count);	
    	}while (count>=10);
    	
    }
    public void verifyAndClickLoginContinue(){
    	try{
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("SapCrmPage.SESSION_QUERY_CONTINUE_BUTTONXpath"))){
    		browser.wait(getWaitTime());
    		verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.SESSION_QUERY_CONTINUE_BUTTONXpath"), "Continue");
    		System.out.println("Continue clicked1");
    		//browser.clickWithLinkText("Continue");
    		browser.wait(getWaitTime());
    	}
    	if(browser.isTextPresent("Continue")){
    		browser.wait(getWaitTime());
    		browser.clickWithLinkText("Continue");
    		browser.wait(getWaitTime());
    		System.out.println("Continue clicked2");
    		
    	}
    	}
    	catch (Exception e){
    		Report.updateTestLog("Unexpected exception occured" + e, "FAIL");
    	}
    	
    }  
    
    
    public void searchCrmFields(CrmUserProfile crmUserProfile,UserProfile userProfile){    	
    	try{
    		//WebDriverWait wait;
    		browser.selectWindowByName("CRMApplicationFrame");
    		browser.selectWindowById(3);
    		browser.selectWindowByName("CRMApplicationFrame");
    		browser.selectWindowByName("FRAME_APPLICATION");
    		browser.selectWindowByName("WorkAreaFrame1");        	
    		browser.clickWithXpath(pageProperties.getProperty("SapCrmPage.SearchOption"));
    		browser.wait(getWaitTime());
    		browser.clickWithLinkText("Find Business Partner");
    		browser.wait(getWaitTime());
	    	
	    	verifyAndInputById(pageProperties.getProperty("SapCrmPage.AccountNumberId"), "Account ID", crmUserProfile.getaccountId());
	    	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.SearchXpath"), "Search button");
	    	browser.wait(getWaitTime());
    	}
    	catch(Exception e){
    		System.out.println(e);
    		Report.updateTestLog("Exception occured: "+e, "FAIL");
    	}
    	
    	try{
    		browser.swtichToDefaultContent();
    		browser.selectWindowByName("CRMApplicationFrame");
    		browser.selectWindowById(3);
    		browser.selectWindowByName("CRMApplicationFrame");
    		browser.selectWindowByName("FRAME_APPLICATION");    	  		
    		browser.wait(getWaitTime());
        	browser.selectWindowByName("WorkAreaFrame2");
        	browser.wait(getWaitTime());
        	browser.clickWithXpath(pageProperties.getProperty("SapCrmPage.BusinessPartnerXpath"));
        	browser.wait(getWaitTime());        	
    	}
    	catch(Exception e){
    		System.out.println(e);
    		Report.updateTestLog("Exception occured: "+e, "FAIL");
    	}   
    	try{
    		String mobileNumber = browser.getTextByXpath(pageProperties.getProperty("SapCrmPage.TelephoneNumber"));
    	Report.updateTestLog("MobileNumber is updated in CRM. Mobile number: "+mobileNumber, (mobileNumber.equalsIgnoreCase(crmUserProfile.getMobileNumber())?"PASS":"FAIL"));
    	verifyIsElementVisibleWithXpath(pageProperties.getProperty("SapCrmPage.Email"), "Email Field");
    	String email = browser.getTextByXpath(pageProperties.getProperty("SapCrmPage.Email")); 
    	Report.updateTestLog("Email Address is updated in CRM . Email address: "+email,(email.equalsIgnoreCase("temp@cognizant.com")? "PASS":"FAIL"));
    	}
    	catch(Exception e){
    		Report.updateTestLog("Exception occured: "+e, "FAIL");
    	}
    } 
    
    
    public void searchCrmFieldsVerification(CrmUserProfile crmUserProfile,UserProfile userProfile){    	
    	try{
    		//WebDriverWait wait;
    		browser.selectWindowByName("CRMApplicationFrame");
    		browser.selectWindowById(3);
    		browser.selectWindowByName("CRMApplicationFrame");
    		browser.selectWindowByName("FRAME_APPLICATION");
    		browser.selectWindowByName("WorkAreaFrame1");        	
    		browser.wait(getWaitTime());
	    	
	    	verifyAndInputById(pageProperties.getProperty("SapCrmPage.SearchByAcctNo"), "Account ID", crmUserProfile.getaccountId());
	    	browser.wait(2000);
	    	browser.clickbutton("C4_W25_V26_searchtray1BTN_SEARCH");	    	
	    	browser.wait(10000);	    
	    	
	    	browser.clickWithXpath(".//*[contains(@id,'W39_V40_UTL-OVW')]");
	    	browser.wait(5000);
	    	verifyAndClickWithLinkText("Overview", "Overview button");
	    	browser.wait(5000);   	
	    	   	
	    	dynamicWait(" .//*[contains(@id,'W24_V59_Hier2_EXPANDER_2_link')]", "xpath");
	    	
	    	verifyAndClickWithXpath(".//*[contains(@id,'W24_V59_Hier2_EXPANDER_2_link')]", "Expander");
	    	browser.wait(5000);
	    	System.out.println("i am in");
	    	
	    	String Additionalinfo="";
	    	String bpcpnumber=" ";    				    	  		
	    	    	int i=3;					
	    	while(browser.isElementVisibleWithXpath(".//*[contains(@id,'W24_V59_ISUBOLTREE_Table["+i+"].COL3')]"))
	    	{		   System.out.println("i am in while");			
	    			   System.out.println(browser.getTextByXpath(".//*[contains(@id,'W24_V59_ISUBOLTREE_Table["+i+"].COL3')]"));	    			
	    			   
	    				if(browser.isElementVisibleWithXpath(".//*[contains(@id,'W24_V59_ISUBOLTREE_Table["+i+"].COL3')]"))
	    				{
	    						bpcpnumber=browser.getTextByXpath(".//*[contains(@id,'W24_V59_ISUBOLTREE_Table["+i+"].COL3')]");
	    						System.out.println("after bpcpnumber in true condition"+bpcpnumber);  						
	    										
	    						System.out.println("Additionalinfo"+Additionalinfo);
	    						System.out.println("if bpcpnumber in true condition"+bpcpnumber);
	    						Acctnoarray.add(bpcpnumber);	    						
	    	    			
	    				}
	    				if(i==15||i==30||i==45||i==60||i==75)
	    				{	
	    					browser.wait(3000);
	    					System.out.println("i am in");
	    					
	    					if(browser.isElementVisibleWithXpath(".//*[contains(@id,'W24_V59_Hier2_pag_fwd')]"))
	    					{
	    					//	browser.clickbutton("C26_W24_V59_Hier2_pag_fwd");
	    						verifyAndClickWithXpath(".//*[contains(@id,'W24_V59_Hier2_pag_fwd')]", "forward");
	    						System.out.println("forward button clicked");	
	    						browser.wait(3000);
	    					}
	    				}    		
	    		
	    				i++;
	    				System.out.println("i"+i);
	    				browser.wait(1000);
	    }
	    	  	
	    			
	    		String	NewUserBpcpdata=AddnewUser_CrmVerification(userProfile);
	    		System.out.println("NewUserBpcpdata"+NewUserBpcpdata);
	    		int len=Acctnoarray.size();
	    			for(int k=1;k<=len-1;k++)
	    			{
	    				
						System.out.println("Acctnoarray"+Acctnoarray.get(k));	
	    				if(NewUserBpcpdata.equals(Acctnoarray.get(k)))
	    					{
	    						Report.updateTestLog("New User Added is Successfully Verified in CRM "+NewUserBpcpdata, "Pass");
	    						System.out.println("Acctnoarray.get(k)"+Acctnoarray.get(k));
	    						System.out.println("bpcpnumber is matched");
	    						
	    					}	   									    			    	
	    					}   				
	        
    	}
	    			
	    	catch(Exception e){
	    		System.out.println(e);
	    		Report.updateTestLog("Exception occured: "+e, "FAIL");
	    	
	    		}   	
    	   	}
    public void verifyPaperLessStatus(CrmUserProfile crmUserProfile,UserProfile userProfile ){
        try{          
            browser.wait(20000);
            browser.selectWindowByName("CRMApplicationFrame");
            browser.selectWindowById(3);
            browser.selectWindowByName("CRMApplicationFrame");
            browser.selectWindowByName("FRAME_APPLICATION");
            browser.selectWindowByName("WorkAreaFrame1");  
            browser.wait(3000);
            verifyAndInputById("C4_W25_V26_V28_search_struct.buag", "Account ID","600850040");
            browser.wait(3000);
            browser.clickWithXpath(".//*[@id='C4_W25_V26_searchtray1BTN_SEARCH']");           
            browser.wait(13000);       
            verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.Morefields"), " More Fields");
        	browser.wait(getWaitTime());
        	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.BA"), "Business Agreement");
        	browser.wait(3000);
        	
        	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.ContractAccount").replace("NUM", userProfile.getAccNumber()), "ContractAccount button");
        	browser.wait(getWaitTime());
//            browser.clickWithXpath(".//*[@id='C5_W24_V59_ISUBOLTREE_Table[2].COL3']");        
            browser.wait(20000);  
            //browser.clickWithXpath(".//*[@id='C22_W80_V81_Edit']");              
            
            browser.wait(3000);               
            String Exactxpath= pageProperties.getProperty("SapCrmPage.pbstatus").replace("PBSTATUS",crmUserProfile.getPBstatus());           
            System.out.println("Exactpath"+Exactxpath);
            if(browser.isElementVisibleWithXpath(Exactxpath))
            {
                   System.out.println("Printed Invoice");
                   Report.updateTestLog("PB Status is Successfully Verified in CRM  as"+ crmUserProfile.getPBstatus(), "Pass");                        
            }                                  
            }      
     catch(Exception e){
            System.out.println(e);
            Report.updateTestLog("Exception occured: "+e, "FAIL");        
     }             
/*
    	browser.selectWindowByName("CRMApplicationFrame");
		browser.selectWindowById(3);
		browser.selectWindowByName("CRMApplicationFrame");
		browser.selectWindowByName("FRAME_APPLICATION");
		browser.selectWindowByName("WorkAreaFrame1");        	
		browser.wait(getWaitTime());
		verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.SearchFunctionId1"), "Search Function");
		verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.GeneralDetails"), "Business Partner by General Details");
		browser.selectWindowByName("CRMApplicationFrame");
		browser.selectWindowById(3);
		browser.selectWindowByName("CRMApplicationFrame");
		browser.selectWindowByName("FRAME_APPLICATION");
		browser.selectWindowByName("WorkAreaFrame1");        	
		browser.wait(getWaitTime());
		browser.inputByXpath(".//*[@id='C4_W25_V26_V72_builheadersearchnew_struct.partner']", "Vish");
							  
		browser.wait(2000);
		browser.selectWindowByName("CRMApplicationFrame");
		browser.selectWindowById(3);
		browser.selectWindowByName("CRMApplicationFrame");
		browser.selectWindowByName("FRAME_APPLICATION");
		browser.selectWindowByName("WorkAreaFrame1");
		verifyAndInputById(pageProperties.getProperty("SapCrmPage.AccountId1"),"Account ID", crmuserProfile.getaccountId());
		browser.wait(6000);
		RobotSendKeys.typeenter();
		browser.wait(6000);
		verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.ContractAccount").replace("NUM", crmuserProfile.getContractaccount()),"Contract Account");
		browser.wait(6000);
		verifyIsTextPresent("Paper Less Invoice");
       	browser.wait(6000);
    */
    }
    public void searchCrmFieldsforpaperbilling_acctspecific(CrmUserProfile crmUserProfile,UserProfile userProfile,String paperstatus){
    	
    	try{          
            browser.wait(20000);
            browser.selectWindowByName("CRMApplicationFrame");
            browser.selectWindowById(3);
            browser.selectWindowByName("CRMApplicationFrame");
            browser.selectWindowByName("FRAME_APPLICATION");
            browser.selectWindowByName("WorkAreaFrame1");  
            browser.wait(3000);
            verifyAndInputById("C4_W25_V26_V28_search_struct.buag", "Account ID",userProfile.getAccNumber());
            browser.wait(3000);
            browser.clickWithXpath(".//*[@id='C4_W25_V26_searchtray1BTN_SEARCH']");           
            browser.wait(13000);       
            verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.Morefields"), " More Fields");
              browser.wait(getWaitTime());
              verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.BA"), "Business Agreement");
              browser.wait(3000);
              
              verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.ContractAccount").replace("NUM", userProfile.getAccNumber()), "ContractAccount button");
              browser.wait(getWaitTime());
//            browser.clickWithXpath(".//*[@id='C5_W24_V59_ISUBOLTREE_Table[2].COL3']");        
            browser.wait(20000);  
            //browser.clickWithXpath(".//*[@id='C22_W80_V81_Edit']");              
            
            browser.wait(3000);       
            if(paperstatus=="PrintedInvoice")
            {
            String Exactxpath= pageProperties.getProperty("SapCrmPage.pbstatus");           
            System.out.println("Exactpath"+Exactxpath);
            if(browser.isElementVisibleWithXpath(Exactxpath))
            	{
                   System.out.println("Printed Invoice");
                   Report.updateTestLog("PB Status is Successfully Verified in CRM  as"+ "PrintedInvoice", "Pass");                        
            	}     
            }
            else if(paperstatus=="Paper Less Invoice")
            {
            String Exactxpath= pageProperties.getProperty("SSapCrmPage.pblessstatus");           
            System.out.println("Exactpath"+Exactxpath);
            if(browser.isElementVisibleWithXpath(Exactxpath))
            	{
                   System.out.println("Paper Less Invoice");
                   Report.updateTestLog("PB Status is Successfully Verified in CRM  as"+ "Paper Less Invoice", "Pass");                        
            	}     
            }
            }      
     catch(Exception e){
            System.out.println(e);
            Report.updateTestLog("Exception occured: "+e, "FAIL");        
     }   	
    } 

    public void SearchCRMFields_MPD(CrmUserProfile crmUserProfile,UserProfile userProfile){    	
    	try{  		
    		browser.wait(20000);
    		browser.selectWindowByName("CRMApplicationFrame");
    		browser.selectWindowById(3);
    		browser.selectWindowByName("CRMApplicationFrame");
    		browser.selectWindowByName("FRAME_APPLICATION");
    		browser.selectWindowByName("WorkAreaFrame1");  
        	browser.wait(3000);    	
    		verifyAndInputById("C4_W25_V26_V28_search_struct.buag", "Account ID","600539185");
    		browser.wait(3000);
    		browser.clickWithXpath(".//*[@id='C4_W25_V26_searchtray1BTN_SEARCH']");   		
    		browser.wait(13000);    	
    		browser.clickWithXpath(".//*[@id='C5_W24_V59_ISUBOLTREE_Table[1].COL3']");   	
    		browser.wait(20000);  
    		browser.clickWithXpath(".//*[@id='ContactView_nl1_1_mid']"); 
    		browser.wait(3000);  
      		browser.clickWithXpath(".//*[@id='C23_W81_V82_Change']");
    		browser.wait(3000);
    	//	browser.clickWithXpath(".//*[@id='C30_W116_V117_V118_V122_but1']");
    		browser.clickWithXpath("//a[contains(text(),'Mrs Debbie Johnston') and //*[starts-with(@id,'C31_W120_V121_builcontactperson')]]");
    		browser.clickWithXpath(".//*[@id='C30_W116_V117_V118_V122_but1']");
    		 uiDriver.findElement(By.xpath(".//*[@id='C30_W116_V117_V118_V122_but1']"));
    		/* int i = 0;
    		 i = i-1;
    		 browser.clickWithXpath(".//*[@id='C31_W120_V121_Table__"+i+"__1']/td[2]/a");
    		
    		 String Telephone=browser.getTextByXpath(".//*[@id='C30_W116_V117_V118_V122_contactpersonstdaddress_struct.telephonetel']");
    		 System.out.println("Telephone");
    		 if(Telephone.equals(userProfile.getMobileNumber()))
    		 {
    			 System.out.println("same..........");
    		 }
    		 String Mail=browser.getTextFromDropBox("id", "C32_W90_V91_customer_struct.zzoptin_st_m0001");
    		 System.out.println("Mail"+Mail);*/
    		   		      
   	
    	}

    	catch(Exception e){
    		System.out.println(e);
    		Report.updateTestLog("Exception occured: "+e, "FAIL");    	
    	}    
       }
    public void GetaQuote_CRM(CrmUserProfile crmUserProfile,UserProfile userProfile,String quoterefno){    	
    	try{  		
    		browser.wait(20000);
    		browser.selectWindowByName("CRMApplicationFrame");
    		browser.selectWindowById(3);
    		browser.selectWindowByName("CRMApplicationFrame");
    		browser.selectWindowByName("FRAME_APPLICATION");
    		browser.selectWindowByName("WorkAreaFrame1");  
        	browser.wait(3000);    	
        	browser.clickWithXpath(".//*[@id='C10_W39_V40_mainmenu']/li[9]/div");
        	browser.clickWithXpath(".//*[@id='C10_W39_V40_UTL-QUO-SR']");
        	browser.wait(4000);
        	verifyAndInputById("C22_W75_V76_V77_btqsrvconisu_parameters[1].VALUE1", "Quote Reference number",quoterefno);
        	//browser.clickWithXpath(".//*[@id='C22_W75_V76_Search']");
        	browser.hitEnterKeyxpath(".//*[@id='C22_W75_V76_V77_btqsrvconisu_parameters[1].VALUE1']");
        	browser.wait(20000);
        	String businessnameincrm=browser.getTextByXpath(".//*[@id='C25_W84_V86_V87_btpartnerset_soldto_name']");
        	if(businessnameincrm.equals(userProfile.getbusinessname()))
        		{
        			System.out.println("i am in");
        			browser.clickWithXpath(".//*[@id='C25_W84_V86_V87_btpartnerset_soldto_name']	");
        			browser.wait(5000);
        			Report.updateTestLog("Businessname <b>"+ businessnameincrm +"</b> is  Verified Successfully ", "Pass");    		
        		}
        		else
        		{
        			Report.updateTestLog("Businessname"+ businessnameincrm +"is  Verified Successfully ", "Fail");    	
        		}
        		String phonenumberincrm=browser.getTextByXpath(".//*[@id='C33_W131_V132_builaddress_table[1].phone']");
        		System.out.println("phonenumberincrm"+phonenumberincrm);
        		String trimphoneno=userProfile.getPhoneNumber().substring(1, userProfile.getPhoneNumber().length());
        		System.out.println("trimphoneo"+trimphoneno);        		
        		
        		if(phonenumberincrm.contains(trimphoneno))
        		{
        			Report.updateTestLog("Phonenumber"+ phonenumberincrm +" is verified Successfully", "Pass");    	
        		}
        		else
        		{
        			Report.updateTestLog("Phonenumber"+ phonenumberincrm +" is verified Successfully", "Fail");    	
        		}
        		
        		String emailincrm=browser.getTextByXpath(".//*[@id='C33_W131_V132_builaddress_table[1].e_mail']");
        		System.out.println("emailincrm"+emailincrm);
        		if(emailincrm.equals(userProfile.getNewEmail()))
        		{
        			Report.updateTestLog("Email"+ emailincrm +" is verified Successfully", "Pass");    	
        		}
        		else
        		{
        			Report.updateTestLog("Email"+ emailincrm +" is verified Successfully", "Fail");    	
        		}
        		String firstlastname=browser.getTextByXpath(".//*[@id='C35_W142_V143_builrelationship_table[1].fullname']");
        		System.out.println("firstlastname"+firstlastname);
        		String Fullname= userProfile.getFirstName()+" "+userProfile.getLastName();
        		System.out.println("Fullname"+Fullname);
        		if(firstlastname.contains(Fullname))
        		{
        			Report.updateTestLog("Firstname and lastname"+Fullname+" is verified Successfully", "Pass");    	
        		}
        		else
        		{
        			Report.updateTestLog("Firstname and lastname"+Fullname+" is verified Successfully", "Fail");    	
        		}    		
        		       		
    	}

    	catch(Exception e){
    		System.out.println(e);
    		Report.updateTestLog("Exception occured: "+e, "FAIL");    	
    	}    
       }
    
    public boolean isElementVisibleWithXpathnew(String xPath) {
        try {
            WebElement webElement;
            webElement = uiDriver.findElement(By.xpath(xPath));
            if (webElement.isDisplayed()) {
                return true;
            }

        } catch (NoSuchElementException ex) {
            return false;
        }
        
        return false;
    }
    public String AddnewUser_CrmVerification(UserProfile userProfile){
		OnlineDBConnector dbFunctions = new OnlineDBConnector();
		String NewUserBpcpdata = dbFunctions.getBpcpnumber(userProfile.getNewEmail());		
	 return NewUserBpcpdata;
	 
	}
    public void verifyPaperLessStatus(CrmUserProfile crmuserProfile){
    	browser.selectWindowByName("CRMApplicationFrame");
		browser.selectWindowById(3);
		browser.selectWindowByName("CRMApplicationFrame");
		browser.selectWindowByName("FRAME_APPLICATION");
		browser.selectWindowByName("WorkAreaFrame1");        	
		browser.wait(getWaitTime());
    	
    	verifyAndInputById(pageProperties.getProperty("SapCrmPage.SearchByAcctNo"), "Account ID", crmuserProfile.getaccountId());
    	browser.wait(2000);
    
    }
    public void verifyReminderAlertStatus(CrmUserProfile crmuserProfile){
    	browser.selectWindowByName("CRMApplicationFrame");
		browser.selectWindowById(3);
		browser.selectWindowByName("CRMApplicationFrame");
		browser.selectWindowByName("FRAME_APPLICATION");
		browser.selectWindowByName("WorkAreaFrame1");        	
		browser.wait(getWaitTime());
    	
    	verifyAndInputById(pageProperties.getProperty("SapCrmPage.SearchByAcctNo"), "Account ID", crmuserProfile.getaccountId());
    	browser.wait(2000);
    
    }
    public void verifyDetailsUpdation(CrmUserProfile crmuserProfile){
    	browser.selectWindowByName("CRMApplicationFrame");
		browser.selectWindowById(3);
		browser.selectWindowByName("CRMApplicationFrame");
		browser.selectWindowByName("FRAME_APPLICATION");
		browser.selectWindowByName("WorkAreaFrame1");        	
		browser.wait(getWaitTime());
    	
    	verifyAndInputById(pageProperties.getProperty("SapCrmPage.SearchByAcctNo"), "Account ID", crmuserProfile.getaccountId());
    	browser.wait(2000);
    
    }
 public String[] verify1YearFixedRate(CrmUserProfile crmUserProfile) throws ParseException {
    	String[] Data = new String[10];
    	int StandingCharges1=0, UnitCharges1=0;
		browser.selectWindowByName("CRMApplicationFrame");
		browser.selectWindowById(3);
		browser.selectWindowByName("CRMApplicationFrame");
		browser.selectWindowByName("FRAME_APPLICATION");
		browser.selectWindowByName("WorkAreaFrame1");        	
		browser.wait(getWaitTime());
		verifyAndInputById(pageProperties.getProperty("SapCrmPage.AccountIdNum"), "Account ID", crmUserProfile.getaccountId());
		browser.wait(getWaitTime());
		browser.clickWithXpath(".//*[@id='C4_W25_V26_searchtray1BTN_SEARCH']");      
		browser.wait(10000);
		verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.Morefields"), " More Fields");
    	browser.wait(getWaitTime());
    	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.BA"), "Business Agreement");
    	browser.wait(3000);
    	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.ID"), "ID button");
    	browser.wait(getWaitTime());
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("SapCrmPage.Payment")))
    	{
    	Payment=browser.getAttributeByXpath(pageProperties.getProperty("SapCrmPage.Payment"), "value");
    	if(Payment.equalsIgnoreCase("Direct Debit"))
    		Report.updateTestLog("Payment Type in SAP CRM - "+ Payment, "Pass");
       	}
    	else
		{	
    		Payment="Cash / Cheque";
			Report.updateTestLog("Payment Type in SAP CRM - "+ Payment, "Pass");}
    	
    	browser.wait(10000);  
		verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.EnergySalesCycle"), "Energy Sales Cycle button");
    	browser.wait(getWaitTime());
    	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.ContractMgmt"), "Contract Management button");
    	browser.wait(7000);
    	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.ContractID"), "Contract ID");
    	browser.wait(7000);
    	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.DocFlow"), "Document Flow");
    	browser.wait(getWaitTime());
    	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.Transac"), "Transaction");
    	browser.wait(7000);
    	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.OneYear"), "One Year");
    	browser.wait(getWaitTime());
        browser.wait(3000);
        String DateonSAP = browser.getTextByXpath(pageProperties.getProperty("SapCrmPage.Date"));
        Report.updateTestLog("Date in SAP CRM - "+ DateonSAP, "Pass");
        Date date = Dt.parse(DateonSAP);
        DateFormat DateonSAPFormatChange = new SimpleDateFormat("dd MMM yyyy");
        String DateonSAPNewFormat = DateonSAPFormatChange.format(date);
        Report.updateTestLog("Date in SAP CRM after Format Change - "+ DateonSAPNewFormat, "Pass");
        browser.wait(3000);
        if(browser.isElementVisibleWithXpath(pageProperties.getProperty("SapCrmPage.SC1")))
        {
        String SC1 = browser.getTextByXpath(pageProperties.getProperty("SapCrmPage.SC1"));
        SC1=SC1.replace(",", ".");
        Float StandingCharge1 = Float.parseFloat(SC1);
        System.out.println("StandingCharge1:" + StandingCharge1);
        StandingCharges1=Math.round(StandingCharge1);
        System.out.println("StandingCharge1:" + StandingCharges1);
        Report.updateTestLog("Standing Charge in SAP CRM - "+ StandingCharges1, "Pass");
        }
        else
        	Report.updateTestLog("Standing Charge is not Visible in the Screen ", "Pass");
        browser.wait(3000);
        if(browser.isElementVisibleWithXpath(pageProperties.getProperty("SapCrmPage.UC1")))
        {
        String UC1 = browser.getTextByXpath(pageProperties.getProperty("SapCrmPage.UC1"));
        UC1=UC1.replace(",", ".");
        Float UnitCharge1 = Float.parseFloat(UC1);
        System.out.println("UnitCharge1:" + UnitCharge1);
        UnitCharges1=Math.round(UnitCharge1);
        System.out.println("UnitCharges1:" + UnitCharges1);
        Report.updateTestLog("Unit Charges in SAP CRM - "+ UnitCharges1, "Pass");
        }
        else
        	Report.updateTestLog("Unit Charge is not Visible in the Screen ", "Pass");
        
        
        browser.wait(getWaitTime());
        browser.wait(3000);
		browser.open("https://10.224.70.18/business/your-account");
		browser.wait(3000);
		browser.closeCrmAlert();
		Data[0]=Payment;
		Data[1]= "" +StandingCharges1;
		Data[2]= "" + UnitCharges1;
		Data[3]= DateonSAPNewFormat;
		
		return Data;
    }
    public String[] verify2YearFixedRate(CrmUserProfile crmUserProfile) throws ParseException {
    	String[] Data = new String[10];
    	int StandingCharges1=0, UnitCharges1=0;
    	browser.selectWindowByName("CRMApplicationFrame");
		browser.selectWindowById(3);
		browser.selectWindowByName("CRMApplicationFrame");
		browser.selectWindowByName("FRAME_APPLICATION");
		browser.selectWindowByName("WorkAreaFrame1");        	
		browser.wait(getWaitTime());
		verifyAndInputById(pageProperties.getProperty("SapCrmPage.AccountIdNum"), "Account ID", crmUserProfile.getaccountId());
		browser.wait(getWaitTime());
		browser.clickWithXpath(".//*[@id='C4_W25_V26_searchtray1BTN_SEARCH']");      
		browser.wait(10000);
		verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.Morefields"), " More Fields");
    	browser.wait(getWaitTime());
    	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.BA"), "Business Agreement");
    	browser.wait(3000);
    	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.ID"), "ID button");
    	browser.wait(getWaitTime());
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("SapCrmPage.Payment")))
    	{
    	Payment=browser.getAttributeByXpath(pageProperties.getProperty("SapCrmPage.Payment"), "value");
    	if(Payment.equalsIgnoreCase("Direct Debit"))
    		Report.updateTestLog("Payment Type in SAP CRM - "+ Payment, "Pass");
       	}
    	else
		{	
    		Payment="Cash / Cheque";
			Report.updateTestLog("Payment Type in SAP CRM - "+ Payment, "Pass");}
    	
    	browser.wait(10000);  
		verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.EnergySalesCycle"), "Energy Sales Cycle button");
    	browser.wait(getWaitTime());
    	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.ContractMgmt"), "Contract Management button");
    	browser.wait(7000);
    	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.ContractID"), "Contract ID");
    	browser.wait(7000);
    	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.DocFlow"), "Document Flow");
    	browser.wait(getWaitTime());
    	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.Transac"), "Transaction");
    	browser.wait(7000);
    	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.TwoYear"), "Two Year");
    	browser.wait(getWaitTime());
        browser.wait(3000);
        String DateonSAP = browser.getTextByXpath(pageProperties.getProperty("SapCrmPage.Date"));
        Report.updateTestLog("Date in SAP CRM - "+ DateonSAP, "Pass");
        Date date = Dt.parse(DateonSAP);
        DateFormat DateonSAPFormatChange = new SimpleDateFormat("dd MMM yyyy");
        String DateonSAPNewFormat = DateonSAPFormatChange.format(date);
        Report.updateTestLog("Date in SAP CRM after Format Change - "+ DateonSAPNewFormat, "Pass");
        browser.wait(3000);
        if(browser.isElementVisibleWithXpath(pageProperties.getProperty("SapCrmPage.SC1")))
        {
        String SC1 = browser.getTextByXpath(pageProperties.getProperty("SapCrmPage.SC1"));
        SC1=SC1.replace(",", ".");
        Float StandingCharge1 = Float.parseFloat(SC1);
        System.out.println("StandingCharge1:" + StandingCharge1);
        StandingCharges1=Math.round(StandingCharge1);
        System.out.println("StandingCharge1:" + StandingCharges1);
        Report.updateTestLog("Standing Charge in SAP CRM - "+ StandingCharges1, "Pass");
        }
        else
        	Report.updateTestLog("Standing Charge is not Visible in the Screen ", "Pass");
        browser.wait(3000);
        if(browser.isElementVisibleWithXpath(pageProperties.getProperty("SapCrmPage.UC1")))
        {
        String UC1 = browser.getTextByXpath(pageProperties.getProperty("SapCrmPage.UC1"));
        UC1=UC1.replace(",", ".");
        Float UnitCharge1 = Float.parseFloat(UC1);
        System.out.println("UnitCharge1:" + UnitCharge1);
        UnitCharges1=Math.round(UnitCharge1);
        System.out.println("UnitCharges1:" + UnitCharges1);
        Report.updateTestLog("Unit Charges in SAP CRM - "+ UnitCharges1, "Pass");
        }
        else
        	Report.updateTestLog("Unit Charge is not Visible in the Screen ", "Pass");
        browser.wait(getWaitTime());
        browser.wait(3000);
		browser.open("https://10.224.70.18/business/your-account");
		browser.wait(3000);
		browser.closeCrmAlert();
		Data[0]=Payment;
		Data[1]= "" +StandingCharges1;
		Data[2]= "" + UnitCharges1;
		Data[3]= DateonSAPNewFormat;
		
		return Data;
    }
    public String[] verify3YearFixedRate(CrmUserProfile crmUserProfile) throws ParseException {
    	String[] Data = new String[10];
    	int StandingCharges1=0, UnitCharges1=0;
    	browser.selectWindowByName("CRMApplicationFrame");
		browser.selectWindowById(3);
		browser.selectWindowByName("CRMApplicationFrame");
		browser.selectWindowByName("FRAME_APPLICATION");
		browser.selectWindowByName("WorkAreaFrame1");        	
		browser.wait(getWaitTime());
		verifyAndInputById(pageProperties.getProperty("SapCrmPage.AccountIdNum"), "Account ID", crmUserProfile.getaccountId());
		browser.wait(getWaitTime());
		browser.clickWithXpath(".//*[@id='C4_W25_V26_searchtray1BTN_SEARCH']");      
		browser.wait(10000);
		verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.Morefields"), " More Fields");
    	browser.wait(getWaitTime());
    	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.BA"), "Business Agreement");
    	browser.wait(3000);
    	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.ID"), "ID button");
    	browser.wait(getWaitTime());
    	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("SapCrmPage.Payment")))
    	{
    	Payment=browser.getAttributeByXpath(pageProperties.getProperty("SapCrmPage.Payment"), "value");
    	if(Payment.equalsIgnoreCase("Direct Debit"))
    		Report.updateTestLog("Payment Type in SAP CRM - "+ Payment, "Pass");
       	}
    	else
		{	
    		Payment="Cash / Cheque";
			Report.updateTestLog("Payment Type in SAP CRM - "+ Payment, "Pass");}
    	
    	browser.wait(10000);  
		verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.EnergySalesCycle"), "Energy Sales Cycle button");
    	browser.wait(getWaitTime());
    	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.ContractMgmt"), "Contract Management button");
    	browser.wait(7000);
    	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.ContractID"), "Contract ID");
    	browser.wait(7000);
    	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.DocFlow"), "Document Flow");
    	browser.wait(getWaitTime());
    	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.Transac"), "Transaction");
    	browser.wait(7000);
    	verifyAndClickWithXpath(pageProperties.getProperty("SapCrmPage.ThreeYear"), "Three Year");
    	browser.wait(getWaitTime());
        browser.wait(3000);
        String DateonSAP = browser.getTextByXpath(pageProperties.getProperty("SapCrmPage.Date"));
        Report.updateTestLog("Date in SAP CRM - "+ DateonSAP, "Pass");
        Date date = Dt.parse(DateonSAP);
        DateFormat DateonSAPFormatChange = new SimpleDateFormat("dd MMM yyyy");
        String DateonSAPNewFormat = DateonSAPFormatChange.format(date);
        Report.updateTestLog("Date in SAP CRM after Format Change - "+ DateonSAPNewFormat, "Pass");
        browser.wait(3000);
        if(browser.isElementVisibleWithXpath(pageProperties.getProperty("SapCrmPage.SC1")))
        {
        String SC1 = browser.getTextByXpath(pageProperties.getProperty("SapCrmPage.SC1"));
        SC1=SC1.replace(",", ".");
        Float StandingCharge1 = Float.parseFloat(SC1);
        System.out.println("StandingCharge1:" + StandingCharge1);
        StandingCharges1=Math.round(StandingCharge1);
        System.out.println("StandingCharge1:" + StandingCharges1);
        Report.updateTestLog("Standing Charge in SAP CRM - "+ StandingCharges1, "Pass");
        }
        else
        	Report.updateTestLog("Standing Charge is not Visible in the Screen ", "Pass");
        browser.wait(3000);
        if(browser.isElementVisibleWithXpath(pageProperties.getProperty("SapCrmPage.UC1")))
        {
        String UC1 = browser.getTextByXpath(pageProperties.getProperty("SapCrmPage.UC1"));
        UC1=UC1.replace(",", ".");
        Float UnitCharge1 = Float.parseFloat(UC1);
        System.out.println("UnitCharge1:" + UnitCharge1);
        UnitCharges1=Math.round(UnitCharge1);
        System.out.println("UnitCharges1:" + UnitCharges1);
        Report.updateTestLog("Unit Charges in SAP CRM - "+ UnitCharges1, "Pass");
        }
        else
        	Report.updateTestLog("Unit Charge is not Visible in the Screen ", "Pass");
        browser.wait(getWaitTime());
        browser.wait(3000);
		browser.open("https://10.224.70.18/business/your-account");
		browser.wait(3000);
		browser.closeCrmAlert();
		Data[0]=Payment;
		Data[1]= "" +StandingCharges1;
		Data[2]= "" + UnitCharges1;
		Data[3]= DateonSAPNewFormat;
		return Data;
    }   
}