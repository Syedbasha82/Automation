package bg.framework.app.functional.page.Slingshot_Broker;

import java.util.Properties;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.page.common.SlingshotErrorMessages;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class LoginAndPasswordPage extends BasePage {
	
	
	private final static String BGFILE_NAME = "resources/Slingshot/HomePage.properties";     
	private static Properties BGBpageProperties = new PropertyLoader(BGFILE_NAME).load();
	
	private final static String FILE_NAME = "resources/Slingshot_Broker/loginAndPasswordpro.Properties";
	private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
	
	SlingshotErrorMessages errormsg = new SlingshotErrorMessages();
	private final static int password_Link_Sent_Success= 200; 
	private final static int password_Link_Sent_Failure= 55;
	 private final static String FILE_NAME1 = "resources/Slingshot/ForgottenPassword.Properties";
	 private static Properties forgottenPasswordpageProperties = new PropertyLoader(FILE_NAME1).load();
	
	public void landingPageOverlayForLevelonetwothreeBroker()
	{
	
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BrokerLandingPage.welcometoportalOverlayTitle"))){			  	   
			   Report.updateTestLog("Welcome to your partner portal Overlay is verified", "PASS");
			   verifyAndClickWithXpath(pageProperties.getProperty("BrokerLandingPage.closeOverlay"), "Close Overlay");
			   
			   	   }
		   else{
			   Report.updateTestLog("Please check Why we need this link " , "WARN");
		   }	
		
	}
	public void welcometoBrokerPortalOverlay()
	{
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BrokerLandingPage.welcometoportalOverlayTitle"))){			  	   
			   Report.updateTestLog("Welcome to your partner portal Overlay is verified", "PASS");
			   verifyAndClickWithXpath(pageProperties.getProperty("BrokerLandingPage.Overlayclosebutton"), "Close Overlay");
			   
			   	   }
		   else{
			   Report.updateTestLog("Please check Why we need this link " , "WARN");
		   }
	}
	public void viewhistory()
	{
		verifyAndClickWithXpath(pageProperties.getProperty("BrokerLandingPage.ViewHistory"), "View History");		
		verifyPageTitle("A");
		browser.browserBack();
		
	}
	public void quotes()
	{
			verifyAndClickWithXpath(pageProperties.getProperty("BrokerLandingPage.quotes"), "quotes");
			verifyPageTitle("B");
			browser.browserBack();
		
		
	}
	public void tenders()
	{
			verifyAndClickWithXpath(pageProperties.getProperty("BrokerLandingPage.tenders"), "tenders");
			verifyPageTitle("C");
			browser.browserBack();
	
	}
	public void queries()
	{
			verifyAndClickWithXpath(pageProperties.getProperty("BrokerLandingPage.queries"), "queries");	
			verifyPageTitle("D");
			browser.browserBack();
	}
	public void reports()
	{
			verifyAndClickWithXpath(pageProperties.getProperty("BrokerLandingPage.reports"), "reports");	
			verifyPageTitle("E");
		
	}
	public void documents()
	{
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BrokerLandingPage.documents")))
		{
			verifyAndClickWithXpath(pageProperties.getProperty("BrokerLandingPage.documents"), "documents");	
			verifyPageTitle("F");	
			browser.browserBack();
		}
	}
	
	public void Partnerportaluserguide()
	{
		
			verifyAndClickWithXpath(pageProperties.getProperty("BrokerLandingPage.Partnerportaluserguide"), "Partnerportaluserguide");	
			verifyPageTitle("F");	
			browser.browserBack();
		
	}
	public void energyblog()
	{
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BrokerLandingPage.energyblog")))
		{
			verifyAndClickWithXpath(pageProperties.getProperty("BrokerLandingPage.energyblog"), "energyblog");	
			verifyPageTitle("F");	
			browser.browserBack();
		}
	}
	public void verifytheLandingPageforLevel123brokers()
	{
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BrokerLandingPage.ViewHistory")))
		{	viewhistory();		
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BrokerLandingPage.quotes")))
			{ 
				 quotes();
				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BrokerLandingPage.tenders")))
				{
					tenders();
					if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BrokerLandingPage.queries")))
					{
						queries();
						if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BrokerLandingPage.reports")))
						{
							reports();							
							if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BrokerLandingPage.documents")))
							{
								 documents();	
								 Report.updateTestLog("Verified the Welcome to Partner portal landing Page for Level 1,2 and 3 Brokers " ,"Pass");
							} 
						}
					}
				}
			}
		}
				
	}
	public void verifytheLandingPageforLevel4brokers()
	{
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BrokerLandingPage.ViewHistory")))
		{	viewhistory();		
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BrokerLandingPage.queries")))
			{ 
				queries();
				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BrokerLandingPage.reports")))
				{
					reports();
					if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BrokerLandingPage.documents")))
					{
						documents();
						if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BrokerLandingPage.reports")))
						{
							reports();							
							if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BrokerLandingPage.partnerportaluserguide")))
							{
								 Partnerportaluserguide();	
								 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("BrokerLandingPage.energyblog")))
									{
										 energyblog();
										 Report.updateTestLog("Verified the Welcome to Partner portal landing Page for Level 4 Brokers " ,"Pass");
									}
							} 
						}
					}
				}
			}
		}
	}
	
	
		public void mydetailslinknavigation()
		{
			verifyAndClickWithXpath(pageProperties.getProperty("BrokerLandingPage.breadcrumblink"), "breadcrumblink");
			verifyPageTitle(""); // update your details
			verifyAndClickWithXpath(pageProperties.getProperty("BrokerLandingPage.Backtohome"), "update your details");
			verifyPageTitle("");// have to update title name			
		}
		public void mydetails_editpage(UserProfile userProfile)
		{
			verifyAndClickWithXpath(pageProperties.getProperty("BrokerLandingPage.edit_Mydetails"), "Edit");
			verifyAndInputByXpath(pageProperties.getProperty("BrokerLandingPage.EditmydetailsTelephoneno"), "telephone number", userProfile.getFirstName());
			verifyAndInputByXpath(pageProperties.getProperty("BrokerLandingPage.mobileno"), "mobilenumber", userProfile.getFirstName());
			verifyAndClickWithXpath(pageProperties.getProperty("BrokerLandingPage.mydetails_Save"), "Save");
			verifyPageTitle("");		
		}
		public void mydetails_Cancel()
		{
			verifyAndClickWithXpath(pageProperties.getProperty("BrokerLandingPage.Mydetails_cancel"), "Cancel");		
			verifyPageTitle(""); // Have to update the title
		}
		
		// have to update the Audit
		 public void verifymobileandtelephoneUpdateAudit(UserProfile userProfile){
				OnlineDBConnector dbFunctions = new OnlineDBConnector();
				String date=dbFunctions.DBsysdateDdmmyyhhmi();			
				String[] auditType3 = dbFunctions.getAuditEventTypeId(date,userProfile.getEmail(),"Creation :Success");
				String data = dbFunctions.getAuditType(auditType3[0]);			
				Report.updateTestLog("Audit id is made in audit table as expected. Audit id: "+auditType3[0]+ " Audit event type is"+data,data.equalsIgnoreCase("BGBUSINESS_MULTIVIEW_CREATE_VIEW_SUCCESS")?"PASS":"FAIL");
				}
		
		 public void mydetailsconfirmationpage() // have to update the breadcrumb details and their page details
		 {
			 verifyAndClickWithXpath(pageProperties.getProperty("BrokerLandingPage.Mydetails_breadcrumb"), "breadcrumb");
			 verifyPageTitle("");
			 browser.browserBack();
			 verifyAndClickWithXpath(pageProperties.getProperty("BrokerLandingPage.Backtohome"), "Back to home");
			 verifyPageTitle("");
			 
		 }
		 public void BgbloginUser(UserProfile userProfile) {	
			 	System.out.println("After login page...................");
				browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("LoginPagebroker.LoginUrl"));
				browser.wait(getWaitTime());
				BgbLoginEmail(userProfile.getEmail());
				BgbLoginPassword(userProfile.getPassword());
				BgbLoginSubmit();
				browser.wait(getWaitTime());				
			}
		 public void BgbloginUser_password(UserProfile userProfile) {	
				browser.wait(getWaitTime());
				BgbLoginPassword(userProfile.getPassword());
				BgbLoginSubmit();
				browser.wait(getWaitTime());				
			}
		 public void BgbloginUserdetails(UserProfile userProfile) {	
				browser.wait(getWaitTime());
				BgbLoginEmail(userProfile.getEmail());
				BgbLoginPassword(userProfile.getPassword());
				BgbLoginSubmit();
				browser.wait(getWaitTime());				
			}
		 public void BgbloginUser_remembermails(UserProfile userProfile) {	
				browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("LoginPagebroker.LoginUrl"));
				browser.wait(getWaitTime());
				BgbLoginEmail(userProfile.getEmail());						
				BgbLoginPassword(userProfile.getPassword());
				verifyAndClickWithXpath(pageProperties.getProperty("LoginPagebroker.remembermyemail"), "check remember my email");	
				BgbLoginSubmit();
				browser.wait(getWaitTime());				
			}
		 public void csauserpage(UserProfile userProfile)
		 {
			 	
			 	browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("LoginPageBroker.Lookupuserpage"));
				browser.wait(7000);
				
				verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.Lookupuser"), "Lookup user");
				BgbLoginEmail(userProfile.getEmail());								
				browser.wait(getWaitTime());		 
		 }
		 public void enterPasswordIsCaseSensitive(UserProfile userProfile) {
				verifyAndInputById(pageProperties.getProperty("LoginPagebroker.Email"), "Email Id",userProfile.getEmail());
				String passwordcase=userProfile.getPassword();
				if (passwordcase != null){
					boolean isuppercase=Character.isUpperCase(passwordcase.charAt(0));
					if (isuppercase){
						String convertpassword=passwordcase.toLowerCase();
						verifyAndInputById(pageProperties.getProperty("LoginPagebroker.Password"), "Password",convertpassword); 
					}else{
						String convertpassword=passwordcase.toUpperCase();
						verifyAndInputById(pageProperties.getProperty("LoginPagebroker.Password"), "Password",convertpassword); 
					}
					verifyAndClickWithXpath(pageProperties.getProperty("LoginPagebroker.NewLoginSubmitXpath"), "Submit button");
					browser.wait(getWaitTime());
				}else{
					Report.updateTestLog("Password in the userprofile.xml file is null/Invalid :", "Fail");
				}
				verifyPageTitle("Log in to your account ");
			}
		 
		 public void bgclickFinduser()
		 {
			   verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.Finduser"), "Find user");
			   verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.active"), "Active");
			   verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.Finduser_submit"), "Find user submit");
		 }
		 
		 public void VerifyPrePopulateEmailorPass(UserProfile userProfile) {
				String prepopulate=browser.getAttribute(pageProperties.getProperty("LoginPagebroker.Email"),"value");
				if (prepopulate.equalsIgnoreCase(userProfile.getEmail())){
					Report.updateTestLog("Already Enrolled Email is Prepopulated(Remember Email)", "Pass");
				}else{
					Report.updateTestLog("Already Enrolled Email is not Prepopulated(Remember Email)"+"Prepopulated id is :"+prepopulate+"Given email is:"+userProfile.getEmail(), "Fail");
				}
			}
		 public void BgbLoginEmail(String email){
				verifyAndInputById(pageProperties.getProperty("LoginPagebroker.Email"), "Email Id", email);	
			}
			public void BgbLoginPassword(String password){
				verifyAndInputById(pageProperties.getProperty("LoginPagebroker.Password"), "Password", password);

			}
			public void BgbLoginSubmit(){
				verifyAndClickWithXpath(pageProperties.getProperty("LoginPagebroker.NewLoginSubmitXpath"), "Submit button");

			}
			  public void verifyLoginTimeStamp(UserProfile userProfile){
				   try{ 
					   OnlineDBConnector onlinedb = new OnlineDBConnector();
					   final String loginauditd = onlinedb.DBsysdateDdmmyyhhmi();
					   String entryCount=onlinedb.verifyLastLoginTimeStamp(loginauditd, userProfile.getEmail());
					   if(onlinedb.verifyLastLoginTimeStamp(loginauditd, userProfile.getEmail())!=null){
						  Report.updateTestLog("Expected Result : LoginTimestamp displayed","Pass");
					   }else{
						   Report.updateTestLog("Expected Result : LoginTimestamp is not displayed","Fail");
					   }
			        }catch(Exception e){
				    		Report.updateTestLog("Error message displayed is:"+e, "FAIL");	
				    }

			   }
			  
			  public void verifyAuditDetailsInDb(UserProfile userProfile,String eventid){
				   try{
				     	OnlineDBConnector onlinedb = new OnlineDBConnector();
				     	final String loginauditdate = onlinedb.DBsysdateDdmmyyhhmi();
				     	String auditeventtype=onlinedb.BgbverifyAuditDetails(loginauditdate, userProfile.getEmail());
				     	
				     	if(auditeventtype!=null){
				     		if(auditeventtype.trim().equals(eventid.trim())){   
				     		  Report.updateTestLog("Audit type displayed is matching : "+ auditeventtype, "Pass");
				     		}else{
				     		  Report.updateTestLog("Audit type displayed is not matching -"+"Expected Audit type is:"
				     		                        +eventid+"Displayed Audit type is:"+auditeventtype, "Fail");		
				     		}
				     	}else{
				     		Report.updateTestLog("Audit type is Null", "Fail");
				     	}}catch(Exception e){
				     		Report.updateTestLog("Error message displayed is:"+e, "FAIL");	
				     	}
				     	
			   }
			  
			  public void landingpage()
			  {
				 //verifyPageTitle("Landing page");	
				  verifyPageTitle("View customer bills");
			  }
			  
			  public void viewhistorypod()
			  {
				  verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.viewhistory"), "view history link");
				  verifyPageTitle("View history");
			  }
			  public void quotespod()
			  {
				  verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.quotes"), "Quotes link");
				  verifyPageTitle("Quotes");
			  }
			  public void tenderspod()
			  {
				  verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.tenders"), "tenders link");
				  verifyPageTitle("Tenders");
			  }
			  public void queriespod()
			  {
				  verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.queries"), "Queries link");
				  verifyPageTitle("Queries");
			  }
			  public void  reportspod()
			  {
				  verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.reports"), "Reports link");
				  verifyPageTitle("Reports");				  
			  }
			  public void  documentspod()
			  {
				  verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.documents"), "Documents link");
				  verifyPageTitle("Documents");				  
			  }
			  public void smrpod()
			  {
				  verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.submitmeterread"), "submitmeterread link");
				  verifyPageTitle("Submit meter read");
			  }
			  public void viewbillpod()
			  {
				  verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.LHNviewhistory"), "viewcustomerbill link");
				  verifyPageTitle("View bill");
			  }
			  public void leadspod()
			  {
				  verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.Leads"), "Leads link");
				  verifyPageTitle("Leads");
			  }
			  public void viewhistoryLHN()
			  {
				  verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.viewhistory"), "view history link");
				  verifyPageTitle("View history");
			  }
			  public void quotesLHN()
			  {
				  verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.LHNquotes"), "Quotes link");
				  verifyPageTitle("Quotes");
			  }
			  public void tendersLHN()
			  {
				  verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.LHNtenders"), "tenders link");
				  verifyPageTitle("Tenders");
			  }
			  public void queriesLHN()
			  {
				  verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.LHNqueries"), "Queries link");
				  verifyPageTitle("Queries");
			  }
			  public void  reportsLLHN()
			  {
				  verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.LHNreports"), "Reports link");
				  verifyPageTitle("Reports");				  
			  }
			  public void  documentsLHN()
			  {
				  verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.LHNdocuments"), "Documents link");
				  verifyPageTitle("Documents");				  
			  }
			  public void smrLHN()
			  {
				  verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.LHNsubmitmeterread"), "submitmeterread link");
				  verifyPageTitle("Submit meter read");
			  }
			  public void viewbillLHN()
			  {
				  verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.LHNviewcustomerbill"), "viewcustomerbill link");
				  verifyPageTitle("View bill");
			  }
			 
			  public void leadspodLHN()
			  {
				  verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.LHNleads"), "Leads link");
				  verifyPageTitle("Leads");
			  }
			  
			  public void browserback()
			  {
				  browser.browserBack();
			  }
			  public void level1and2accessiblejourney()
			  {
				  viewhistorypod(); browserback(); viewhistoryLHN(); browserback(); quotespod();browserback();quotesLHN(); browserback();tenderspod();browserback();
				  tendersLHN(); browserback(); queriespod();browserback(); queriesLHN();browserback(); reportspod(); browserback(); reportsLLHN();browserback();
				  documentspod();browserback();documentsLHN();browserback();smrpod();  browserback();smrLHN();browserback();viewbillpod();browserback();viewbillLHN();browserback();	
				 
			  }
			  public void level3accessiblejourney()
			  {
				  viewhistorypod();browserback();viewhistoryLHN();browserback(); quotespod();browserback();quotesLHN();browserback();tenderspod();browserback();tendersLHN();
				  browserback();queriespod();browserback();queriesLHN();browserback();viewbillpod();browserback();viewbillLHN();browserback();smrpod();browserback();smrLHN();
				  browserback();				  
			  }
			  public void level4accessiblejourney()
			  {
				  viewhistorypod();browserback();viewhistoryLHN();browserback();documentspod();browserback();documentsLHN();browserback();queriespod();browserback();queriesLHN();
				  browserback();viewbillpod();browserback();viewbillLHN();browserback();smrpod();browserback();smrLHN();browserback();
			  }
			  public void level5accessiblejourney()
			  {
				  reportspod();browserback();reportsLLHN();browserback();leadspod();browserback();leadspodLHN();browserback();documentspod();browserback();documentsLHN();
				  browserback();
			  }
			  
			 
			  
			  public void verifyLoginTryCountInDb(UserProfile userProfile,String recCount){
			    	getWaitTime();
			    	String loginTryCount = new OnlineDBConnector().verifyLoginTryCount(userProfile.getEmail());
			    	/*if(loginTryCount.equals("null")){
			    		loginTryCount="null"; 	
			    	}*/
			     	System.out.println("logincount:"+loginTryCount);
			     	
			     	if(loginTryCount!=null){
			     		Report.updateTestLog("Expected Trycount:"+recCount+"Actual Trycount :"+loginTryCount,loginTryCount.equals(recCount)? "Pass":"Fail");
			     	}else{
			     		if(recCount.equalsIgnoreCase("null")){
			     			Report.updateTestLog("Login trycount is null as expected","Pass");
			     		}else{
			     			Report.updateTestLog("Login trycount is not as expected","Fail");
			     		}		     		
			         } 	
			       }
			
			  public void logout(){
			    	verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.Logout"), "Log out link");
			    	//verifyIsTextPresent("Your account");
			    	//verifyIsTextPresent("Log in"); 
			    }
			  public void loginEmailErrorMessageValidation(UserProfile userProfile) {

					String[] email = new String[4];
					email[0]="";
					email[1]="qw2w3w3w@bgtest.co.uk";					
					String Email = "Emailvalidation";
					enterInvalidEmail(userProfile,email[0],Email);
					getErrorMsgLoginscreen(errormsg.Loginbroker_EmailEmpty);					;
					enterInvalidEmail(userProfile,email[1],Email);
					getErrorMsgLoginscreen(errormsg.Loginbroker_EmailInccorectFormat);
				}

				public void loginPasswordErrorMessageValidation(UserProfile userProfile) {
					String[] pass = new String[3];
					pass[0]="";
					pass[1]="qw2w3w3w@bgtest.co.uk";
					enterInvalidEmail(userProfile,pass[0],"Passwordvaldiation");
					getErrorMsgLoginscreen(errormsg.Login_PasswordEmpty);
					enterInvalidEmail(userProfile,userProfile.getEmail(),"Passwordvaldiation");
					getErrorMsgLoginscreen(errormsg.Loginbroker_PasswordIncorrect1);
					enterInvalidEmail(userProfile,userProfile.getEmail(),"Passwordvaldiation");
					getErrorMsgLoginscreen(errormsg.Loginbroker_PasswordIncorrect2);
					enterInvalidEmail(userProfile,userProfile.getEmail(),"Passwordvaldiation");
					getErrorMsgLoginscreen(errormsg.Loginbroker_PasswordIncorrect3);

				}
				public void enterInvalidEmail(UserProfile userProfile,String value,String Validation){
					if(Validation=="Emailvalidation"){
						if(value=="length60"){
							String emailInv="SmartinsightsmartinsightsmartinsightSmartinsight@bgtest.co.uk";	
							verifyAndInputById(pageProperties.getProperty("LoginPagebroker.Email"), "Email Id",emailInv);
						}else{
							verifyAndInputById(pageProperties.getProperty("LoginPagebroker.Email"), "Email Id",value);		
						}
						verifyAndInputById(pageProperties.getProperty("LoginPagebroker.Password"), "Password", userProfile.getPassword());
						browser.clickWithXpath(pageProperties.getProperty("LoginPagebroker.NewLoginSubmitXpath"));
					}else{
						verifyAndInputById(pageProperties.getProperty("LoginPagebroker.Email"), "Email Id",userProfile.getEmail());
						verifyAndInputById(pageProperties.getProperty("LoginPagebroker.Password"), "Password", value);
						browser.clickWithXpath(pageProperties.getProperty("LoginPagebroker.NewLoginSubmitXpath"));
					}
					getWaitTime();
				}
				public void getErrorMsgLoginscreen(String emailErrorMessage) {
					try{
						String errormsgvalue=browser.getTextByXpath(pageProperties.getProperty("LoginPageBroker.errormsg"));

						Report.updateTestLog("Login screen-Error msg Expected Result: "+emailErrorMessage+" Actual Result: "+errormsgvalue,errormsgvalue.contains(emailErrorMessage)?"Pass":"Fail");
					}catch(Exception e){
						Report.updateTestLog("Error locating xpath in error msg section :"+e, "Fail");
					}

				}
				public void passwordresetpage(UserProfile userProfile)
				{
					verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.forgetyourpassword"), "forget your password");
					verifyPageTitle("reset your password");
					verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.Cancel"), "cancel");
					browser.browserBack();
					verifyAndInputById(pageProperties.getProperty("LoginPagebroker.Email"), "Email Id",userProfile.getEmail());
					verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.continubutton"), "continue");
					verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.Login"), "Login");
					verifyPageTitle("");
					
				}
				public void passwordreminderset(UserProfile userProfile)
				{
					verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.forgetyourpassword"), "forget your password");
					verifyPageTitle("reset your password");				
					verifyAndInputById(pageProperties.getProperty("LoginPagebroker.Email"), "Email Id",userProfile.getEmail());
					verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.continubutton"), "continue");
					verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.Loginintopartnerportal"), "Login in to partner portal");
					verifyPageTitle("");					
				}		
				public void passwordreminderemail(UserProfile userProfile)
				{
					verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.forgetyourpassword"), "forget your password");
					verifyPageTitle("reset your password");				
					verifyAndInputById(pageProperties.getProperty("LoginPagebroker.Email"), "Email Id",userProfile.getEmail());
					verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.continubutton"), "continue");
					Report.updateTestLog("Password reset link sent to "+userProfile.getEmail(),"PASS");
				}
				public void Loginandpassword_breadcrumb()
				{
					verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.partnerportalbreadcrumb"), "partner portal link");
					verifyPageTitle("Partner Portal");
					browser.browserBack();
				}
				public void RHNnavigationlink()
				{
					verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.RHNLoginLink"), "Login link");
					verifyPageTitle("Login to your account");
					browser.browserBack();
				}
				public void loginPage()
				{
					browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("common.BgbLoginLink"));
					browser.wait(getWaitTime());
				}
			
				public void verifyPasswordRemainderSentPage(UserProfile userProfile){
					verifyPageTitle(pageProperties.getProperty("LoginPageBroker.PasswordRemainderSentHeader"));
					Report.updateTestLog("Password reset link sent to "+userProfile.getEmail(),"PASS");
					//verifyIsTextPresent(pageProperties.getProperty("ForgottenPasswordPage.BusinessHomeLink"));
				}
				/* public void verifyLeadTable_resetpasswordmailsent(UserProfile userProfile){
						OnlineDBConnector dbFunctions = new OnlineDBConnector();
						String date=dbFunctions.DBsysdateDdmmyyhhmi();			
						String[] auditType3 = dbFunctions.getAuditEventTypeIdForMUMV(date,userProfile.getNewEmail(),"EMAIL SENT STATUS:SUCCESS");
						System.out.println("auditType3[0]"+auditType3[0]);
						String data = dbFunctions.getAuditType(auditType3[0]);			
						Report.updateTestLog("Audit id is made in audit table as expected. Audit id: "+auditType3[0]+ " Audit event type is"+data,data.equalsIgnoreCase("BROKER_FORGOTTEN_PASSWORD_MAIL_SENT_SUCCESS")?"PASS":"FAIL");
						}*/
				 public void verifyLeadTable_newpasswordupdated(UserProfile userProfile){
						OnlineDBConnector dbFunctions = new OnlineDBConnector();
						String date=dbFunctions.DBsysdateDdmmyyhhmi();			
						String[] auditType3 = dbFunctions.getAuditEventTypeIdForMUMV(date,userProfile.getEmail(),"PASSWORD_UPDATED:Y");
						System.out.println("auditType3[0]"+auditType3[0]);
						String data = dbFunctions.getAuditType(auditType3[0]);			
						Report.updateTestLog("Audit id is made in audit table as expected. Audit id: "+auditType3[0]+ " Audit event type is"+data,data.equalsIgnoreCase("NEW_PASSWORD_UPDATE")?"PASS":"FAIL");
						}
				public void clickLoginLinkInEmailSentPage(){		
					verifyAndClickWithXpath(pageProperties.getProperty("ForgottenPasswordPage.LoginLinkInMailSentPage"), "Login link");
					browser.wait(getWaitTime());
				}
				public void verifyAuditDetails(final UserProfile userProfile) {     	
					OnlineDBConnector dbfunctions = new OnlineDBConnector();       
				    String sysDate = dbfunctions.DBsysdateDdmmyyhhmi();            
				    System.out.println(dbfunctions.getAuditTypeIdMs(userProfile.getEmail(), sysDate,password_Link_Sent_Success));
				    int getAudittype=dbfunctions.getAuditTypeIdMs(userProfile.getEmail(), sysDate, password_Link_Sent_Success);
				    if(getAudittype>=1){
				      Report.updateTestLog("Audit entry is made as expected: "+password_Link_Sent_Success, "PASS");
				      
				    }else{
				    	Report.updateTestLog("Audit entry is made as expected: "+password_Link_Sent_Success, "FAIL");
				    }
				} 
				public void loginWithNewPasswordbroker(String Pwd, UserProfile userProfile){
					if(browser.isTextPresent("Your account")){
						browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("LoginPageBroker.LoginUrl"));
						browser.wait(getWaitTime());
						if(browser.isTextPresent("Your account")){

						}
						else{
							browser.open(ApplicationConfig.APP_BG_URL); 
						}
						OnlineDBConnector onlinedbconnector = new OnlineDBConnector();
						String password=  onlinedbconnector.getPasswordUsingEmail(userProfile.getEmail());	
						verifyAndInputById(pageProperties.getProperty("LoginPagebroker.Email"), "Email Id", userProfile.getEmail());
						verifyAndInputById(pageProperties.getProperty("LoginPagebroker.Password"), "Password",userProfile.getPassword()); 
						verifyAndClickWithXpath(pageProperties.getProperty("LoginPagebroker.NewLoginSubmitXpath"), "Log in");
						browser.wait(getWaitTime()); 
					}
				}
				public void openResetPasswordUrl(){		
					//browser.open("https://10.224.70.18/business/new-password");
					browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("LoginPageBroker.NewPasswordUrl"));
					//browser.openTab(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("ForgottenPasswordPage.NewPasswordUrl"));
					browser.wait(getWaitTime());
					//verifyPageTitle(pageProperties.getProperty("ForgottenPasswordPage.PasswordResetHeader"));
				}
				public void enterNewPasswordFields(String newpwd,String confirmpwd){
					verifyAndInputById(pageProperties.getProperty("LoginPageBroker.NewPassword"), "New password ",newpwd);
					verifyAndInputById(pageProperties.getProperty("LoginPageBroker.ConfirmNewPassword"), "Confirm New password",confirmpwd);
					verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.ContinueButtonXpath"), "Continue Button");
					browser.wait(getWaitTime());
				}
				public void enterNewPasswordFields_pwd(UserProfile userProfile){
					verifyAndInputById(pageProperties.getProperty("LoginPageBroker.NewPassword"), "New password ",userProfile.getNewPassword());
					verifyAndInputById(pageProperties.getProperty("LoginPageBroker.ConfirmNewPassword"), "Confirm New password ",userProfile.getNewPassword());
					verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.ContinueButtonXpath"), "Continue Button");
					browser.wait(getWaitTime());
				}
				public void verifyPasswordResetSuccessPage(){
					verifyPageTitle("Password reset confirmation");
					verifyIsTextPresent(pageProperties.getProperty("ForgottenPasswordPage.PasswordResetSuccessHeader"), "Password reset success message ");
					//verifyIsTextPresent(pageProperties.getProperty("ForgottenPasswordPage.PasswordChangeSuccess"), "Security text");
				}
				public void clickLoginLinkInResetPasswordSuccessPage(){		
					verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.LoginLink"), "Login link");
					browser.wait(getWaitTime());
					verifyPageTitle("Log in to your account");
				}
				
				     			
				 public void errorMessageComparison(final String expectedErrorMsg) {
				    	try{
				        final String displayedErrorMsg = browser.getTextByXpath(pageProperties.getProperty("ForgottenPasswordPage.ErrorList"));
				        verifyErrorMessage(displayedErrorMsg, expectedErrorMsg);
				    	}
				    	catch(Exception e){
				    		Report.updateTestLog("Exception occured. Check password entered", "FAIL");
				    	}
				    }
				 public void verifyErrorMessage(final String displayedErrorMsg, final String expectedErrorMsg) {
			    	 System.out.println(displayedErrorMsg);
			    	 System.out.println(expectedErrorMsg);
			         if (displayedErrorMsg.trim().contains(expectedErrorMsg.trim())) {
			             Report.updateTestLog("Expected error message was displyed. Expected error message:" + expectedErrorMsg +"Actual error message:"+displayedErrorMsg, "PASS");
			         } else {
			             Report.updateTestLog("Expected error message was displyed. Expected error message:" + expectedErrorMsg +"Actual error message:"+displayedErrorMsg, "FAIL");
			         }
			     }  
				 public void BgbnavigateToLoginPage() {
						if(browser.isElementVisible(pageProperties.getProperty("LoginPageBroker.Logout"))) {
							browser.clickWithLinkText(pageProperties.getProperty("LoginPageBroker.Logout"));
							browser.wait(getWaitTime());
							browser.open(ApplicationConfig.APP_BG_URL);
						}
						System.out.println("login usrl ApplicationConfig.APP_BG_URL:"+ApplicationConfig.APP_BG_URL+"BGBpageProperties.getPropertycommon.BgbLoginLinkbroker:"+
								pageProperties.getProperty("common.BgbLoginLinkbroker"));
						browser.open(ApplicationConfig.APP_BG_URL+BGBpageProperties.getProperty("common.BgbLoginLinkbroker"));
						browser.wait(getWaitTime());

					}
				 public void verifyLoginErrorFreezeAccount(UserProfile userProfile){
						new OnlineDBConnector().updateFreezeAccountStatus(userProfile, "Y","INACTIVE");
						BgbloginUser(userProfile);
						getErrorMsgLoginscreen(SlingshotErrorMessages.Login_FreezeAccount);
						new OnlineDBConnector().updateFreezeAccountStatus(userProfile, "N","ACTIVE");
					}
				 public void loginpage()
				 {
					 	browser.open(ApplicationConfig.APP_BG_URL+BGBpageProperties.getProperty("common.BgbLoginLinkbroker"));
						browser.wait(getWaitTime());					 
				 }
				 public void verifyAndClickForgottenPasswordLink(){

						if(verifyIsTextPresent("Your account")){
							browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("LoginPagebroker.LoginUrl"));
							browser.wait(getWaitTime());
							if(verifyIsTextPresent("Log in")){
								verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.ForgottenPasswordLink"), "I've forgotten my password");
								browser.wait(getWaitTime());
							}
							else {
								Report.updateTestLog("Log in page is displayed", "FAIL");
								verifyIsElementVisibleWithXpath(pageProperties.getProperty("LoginPage.ForgottenPasswordLink"), "I've forgotten my password");
							}}
					}
				 public void verifyPageTitle1(){
						verifyPageTitle(pageProperties.getProperty("LoginPageBroker.ForgettenPasswordPageTitle"));
					}
					public void enterEmail(String email){		
						if(verifyIsTextPresent(pageProperties.getProperty("LoginPageBroker.Header"))){
							verifyAndInputById(pageProperties.getProperty("LoginPagebroker.Email"), "Email Address",email );
						}
						else{
							Report.updateTestLog("'Reset your password' page verification is done", "FAIL");
						}
					}
					
					public void clickContinueButton(){
						verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.ContinueButtonXpath"), "Continue button");
						browser.wait(getWaitTime());
					}
					public void verifyResetPasswordPageFields(){
						  verifyPageTitle(forgottenPasswordpageProperties.getProperty("ForgottenPasswordPage.Title"));
						  verifyIsElementVisibleWithXpath(pageProperties.getProperty("ForgotPasswordPage.ResetYourPasswordId"), "Reset your password");
						  verifyIsElementVisibleWithXpath(pageProperties.getProperty("ForgotPasswordPage.EmailFieldByXpath"), "Email Field");
						  verifyIsElementVisibleWithXpath(forgottenPasswordpageProperties.getProperty("ForgottenPasswordPage.ForgottenEmailLink"), "Forgotten email link");
						  verifyIsElementVisibleById(pageProperties.getProperty("ForgotPasswordPage.ContinueButtonId"), "continue");
						  verifyIsElementVisibleWithXpath(pageProperties.getProperty("ForgotPasswordPage.CancelButton"), "Cancel");
						     
					   }
					public void verifyPasswordChangeInDB(UserProfile userProfile){
				    	 OnlineDBConnector db = new OnlineDBConnector();
				    	 db.verifyPasswordChangebroker(userProfile.getEmail());
				     }
					public void loginWithNewPassword(String Pwd, UserProfile userProfile){
						if(browser.isTextPresent("Your account")){
							browser.open(ApplicationConfig.APP_BG_URL+pageProperties.getProperty("LoginPage.LoginUrl"));
							browser.wait(getWaitTime());
							if(browser.isTextPresent("Your account")){

							}
							else{
								browser.open(ApplicationConfig.APP_BG_URL); 
							}
							OnlineDBConnector onlinedbconnector = new OnlineDBConnector();
							String password=  onlinedbconnector.getPasswordUsingEmail(userProfile.getEmail());	
							verifyAndInputById(pageProperties.getProperty("LoginPage.Email"), "Email Id", userProfile.getEmail());
							verifyAndInputById(pageProperties.getProperty("LoginPage.Password"), "Password",Pwd); 
							verifyAndClickWithXpath(pageProperties.getProperty("LoginPage.LoginButtonXpath"), "Log in");
							browser.wait(getWaitTime()); 
						}
					}
				public void verifyLeadTable_Updateuserdetails(UserProfile userProfile){
				 	OnlineDBConnector dbFunctions = new OnlineDBConnector();
				 	String date=dbFunctions.DBsysdateDdmmyyhhmi();
					String[] auditType = dbFunctions.getAuditEventTypeIdForMUMV(date,userProfile.getNewEmail(),"BROKER_UPDATE_DETAILS_SUCCESS");
					System.out.println("auditType[0]"+auditType[0]);
					String data = dbFunctions.getAuditType(auditType[0]);	
					Report.updateTestLog("Audit id is made in audit table as expected. Audit id: "+auditType[0]+ " Audit event type is"+data,data.equalsIgnoreCase("UPDATE_BROKER_DETAILS_SUCCESS")?"PASS":"FAIL");
					}
					public void bactohomepage()
					{
						verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.backtohome"),"Back to home");
					}
					public void maximumupdatein_contactandteleno(UserProfile userProfile)
					{
						verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.updateyourdetails"),"update your details");
						verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.Editoption"), "Edit Button");
						verifyPageTitle("Edit my details");
						verifyAndInputByXpath(pageProperties.getProperty("LoginPageBroker.telephonenumber"), "Tele phonenumber", userProfile.getPhoneNumber());
						verifyAndInputByXpath(pageProperties.getProperty("LoginPageBroker.mobilenumber"), "mobile number", userProfile.getMobileNumber());
						verifyAndClickWithXpath(pageProperties.getProperty("LoginPageBroker.savebutton"), "Save Button");
						verifyPageTitle("Personal details updated");
					}
					
	}


