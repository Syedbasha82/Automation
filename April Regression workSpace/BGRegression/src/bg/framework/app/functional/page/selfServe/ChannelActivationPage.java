package bg.framework.app.functional.page.selfServe;

import java.sql.Driver;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.util.PropertyLoader;
import bg.framework.app.functional.util.Report;

public class ChannelActivationPage extends BasePage {
	
	
    private final static String FILE_NAME = "resources/selfServe/ChannelActivationNew.Properties";
    private static Properties pageProperties = new PropertyLoader(FILE_NAME).load();
    private static String orderDate;
	
	
	/*************************************************************
	Created By          : Vishnu Prasad D
	Created Date        : 03/25/2014
	Method Functionality: TubeMap
	**************************************************************/
	
		public void verifyTubeMap(){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.WTPTubeMap"))){
				Report.updateTestLog("Tube Map is Present", "PASS");
			}else{
				Report.updateTestLog("Tube Map is not Present", "FAIL");				
					}
			}
		
		
		/*************************************************************
		Created By          : Vishnu Prasad D
		Created Date        : 03/25/2014
		Method Functionality: Open Channel Activation URL
		**************************************************************/
		
		public void openChanActURL(){
			
			browser.open(ApplicationConfig.APP_BG_URL+"/upgrade/smartmeter/");
			
		/*	browser.wait(3000);*/
			System.out.println("After URL Opened");
			
			/*browser.executeScript("$('#overridelink').click()");
			System.out.println("browserURL ################ - "+ApplicationConfig.APP_BG_URL+"/upgrade/smartmeter/" );*/
			/*if(browser.isElementVisible("overridelink")){*/
				/*verifyAndClickWithName("overridelink", "Override Link");*/
	/*		}*/
			/*verifyAndClickWithXpath("//*[contains(text(),'Continue to this website (not recommended)')]", "Link");*/
			/*System.out.println("aaaaaa");
			browser.IECertErrorClick();
			System.out.println("bbbbbbbbb");*/
			//browser.open(ApplicationConfig.APP_BG_URL+"/upgrade/smartmeter/");
	/*		browser.wait(3000);*/
				

		}
			
		
		/*************************************************************
		Created By          : Vishnu Prasad D
		Created Date        : 03/25/2014
		Method Functionality: New Customer - click on No Button
		**************************************************************/
		public void clickbritishgasno(){
			
			if(browser.isElementVisible(pageProperties.getProperty("ChannelActivation.britishgasno")))
			{
				verifyAndClick(pageProperties.getProperty("ChannelActivation.britishgasno"), "British Gas No");
				} else{
				Report.updateTestLog("British Gas No check box is not present", "FAIL");				
					}
			}
		/*************************************************************
		Created By          : Ragul M
		Created Date        : 03/25/2014
		Method Functionality: New Customer - click on No Button
		**************************************************************/
		public void selectbritishgasYes(){
			
			if(browser.isElementVisible(pageProperties.getProperty("ChannelActivation.britishgasyes")))
			{
				verifyAndClick(pageProperties.getProperty("ChannelActivation.britishgasyes"), "British Gas Yes");
				} else{
				Report.updateTestLog("British Gas Yes check box is not present", "FAIL");				
					}
			}
		/*************************************************************
		Created By          : Ragul M
		Created Date        : 19/11/2014
		Method Functionality: New Customer - Selecting Pre Pay Meter Type
		**************************************************************/
		public void selectPrePayMeter(){
			
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.SelectPrePaymeter")))
			{
				verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.SelectPrePaymeter"), "Select Pre Pay meter");
				} else{
				Report.updateTestLog("Pre Pay Meter Option is not Present ", "FAIL");				
					}
			}
		/*************************************************************
		Created By          : Ragul M
		Created Date        : 19/11/2014
		Method Functionality: New Customer - Selecting Credit Meter Type
		**************************************************************/
		public void selectCreditMeter(){
			
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.SelectCreditMeter")))
			{
				verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.SelectCreditMeter"), "Select Credit meter");
				} else{
				Report.updateTestLog("Credit Meter Option is not Present ", "FAIL");				
					}
			}
		
		/*************************************************************
		Created By          : Vishnu Prasad D
		Created Date        : 03/25/2014
		Method Functionality: New Customer - Clicking Smart Meter Upgrade Link
		**************************************************************/		
			public void clickNewUserPage1Next(){
				if(browser.isElementVisible(pageProperties.getProperty("ChannelActivation.SmartMeterUpgradeLink")))
				{
					verifyAndClick(pageProperties.getProperty("ChannelActivation.SmartMeterUpgradeLink"), "SmartMeterUpgradeLink");
					} else{
					Report.updateTestLog("Page 1 Next Button is not present", "FAIL");				
						}
				}
	  /*************************************************************
	   Created By          : Ragul M
	   Created Date        : 11/25/2014
	   Method Functionality: New Customer - Clicking Login Link
			**************************************************************/		
		    public void clickLoginLink(){
		    	browser.wait(3000);
				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.LoginLink")))
				{
					verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.LoginLink"), "Login Link");
					} else{
					Report.updateTestLog("Page 1 Next Button is not present", "FAIL");				
						}
				}

			
		/*************************************************************
		Created By          : Vishnu Prasad D
		Created Date        : 03/25/2014
		Method Functionality: New Customer - Continue Your Journey Button Button
		**************************************************************/		
			
			public void clickContinue(){
				browser.wait(3000);
				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.Continuejourney")))
				{
					verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.Continuejourney"), "Continue your Journey Button");
					} else{
					Report.updateTestLog("Continue your Journey Button is not present", "FAIL");				
						}
			
				}
			
		/*************************************************************
		Created By          : Vishnu Prasad D
		Created Date        : 03/25/2014
		Method Functionality: New Customer - Screening Questions
		**************************************************************/			
			
			public void newCustScreeningQues(String outstandingBalance,String Eco7,String Flat,String FuseBox,String Smart){
				System.out.println("into new cust screening quests");
				Report.updateTestLog("into new cust screening quests", "PASS");
				
				
			if(outstandingBalance=="Yes")
					{
				if(browser.isElementVisible(pageProperties.getProperty("ChannelActivation.OutstandingBalanceYes")))
						{
					verifyAndClick(pageProperties.getProperty("ChannelActivation.OutstandingBalanceYes"), "Outstanding Balance Yes Check Box");
						} else{
					Report.updateTestLog("Prepayment Meter Yes Check Box is not present", "FAIL");				
								}	
					}
			
				
			if(outstandingBalance=="No"){
				if(browser.isElementVisible(pageProperties.getProperty("ChannelActivation.OutstandingBalanceNo")))
				{
					verifyAndClick(pageProperties.getProperty("ChannelActivation.OutstandingBalanceNo"), "Outstanding Balance No Check Box");
				} else{
					Report.updateTestLog("Prepayment Meter No Check Box is not present", "FAIL");				
						}	
			}
		if (outstandingBalance == "Yes") {
			if (browser.isElementVisible(pageProperties.getProperty("ChannelActivation.OutstandingBalanceYes"))) {
				verifyAndClick(pageProperties.getProperty("ChannelActivation.OutstandingBalanceYes"),"Outstanding Balance Yes Check Box");
			} else {
				Report.updateTestLog("Prepayment Meter Yes Check Box is not present", "FAIL");
			}
		}

		if (outstandingBalance == "No") {
			if (browser.isElementVisible(pageProperties.getProperty("ChannelActivation.OutstandingBalanceNo"))) {
				verifyAndClick(pageProperties.getProperty("ChannelActivation.OutstandingBalanceNo"),"Outstanding Balance No Check Box");
			} else {
				Report.updateTestLog("Prepayment Meter No Check Box is not present", "FAIL");
			}
		}
				
			
			if(Eco7=="Yes")
			{
			if(browser.isElementVisible(pageProperties.getProperty("ChannelActivation.Eco7Yes")))
				{
					verifyAndClick(pageProperties.getProperty("ChannelActivation.Eco7Yes"), "Eco7 Yes Check Box");
				} else{
					Report.updateTestLog("Eco7 Yes Check Box is not present", "FAIL");				
					}	
		}
		
			if(Eco7=="No"){
				if(browser.isElementVisible(pageProperties.getProperty("ChannelActivation.Eco7No")))
				{
				verifyAndClick(pageProperties.getProperty("ChannelActivation.Eco7No"), "Eco7 No Check Box");
				} else{
				Report.updateTestLog("Eco7 No Check Box is not present", "FAIL");				
						}	
			}
			
			if(Flat=="Yes")
			{
			if(browser.isElementVisible(pageProperties.getProperty("ChannelActivation.FlatYes")))
				{
					verifyAndClick(pageProperties.getProperty("ChannelActivation.FlatYes"), "Flat Yes Check Box");
				} else{
					Report.updateTestLog("Flat Yes Check Box is not present", "FAIL");				
					}	
		}
		
			if(Flat=="No"){
				if(browser.isElementVisible(pageProperties.getProperty("ChannelActivation.FlatNo")))
				{
				verifyAndClick(pageProperties.getProperty("ChannelActivation.FlatNo"), "Flat No Check Box");
				} else{
				Report.updateTestLog("Flat No Check Box is not present", "FAIL");				
						}	
			}
			
			if(FuseBox=="Yes")
			{
				if(browser.isElementVisible(pageProperties.getProperty("ChannelActivation.FuseYes")))
					{
						verifyAndClick(pageProperties.getProperty("ChannelActivation.FuseYes"), "Fuse Yes Check Box");
					} else{
						Report.updateTestLog("Fuse Yes Check Box is not present", "FAIL");				
							}	
				}

			if(FuseBox=="No"){
				if(browser.isElementVisible(pageProperties.getProperty("ChannelActivation.FuseNo")))
				{
				verifyAndClick(pageProperties.getProperty("ChannelActivation.FuseNo"), "Fuse No Check Box");
				} else{
				Report.updateTestLog("Fuse No Check Box is not present", "FAIL");				
						}	
			}
			if(Smart=="Yes")
			{
				if(browser.isElementVisible(pageProperties.getProperty("ChannelActivation.SmartYes")))
				{
					verifyAndClick(pageProperties.getProperty("ChannelActivation.SmartYes"), "Smart Yes Check Box");
				} else{
					Report.updateTestLog("Smart Yes Check Box is not present", "FAIL");				
						}	
			}

			if(Smart=="No"){
				if(browser.isElementVisible(pageProperties.getProperty("ChannelActivation.SmartNo")))
				{
				verifyAndClick(pageProperties.getProperty("ChannelActivation.SmartNo"), "Smart No Check Box");
				} else{
				Report.updateTestLog("Smart No Check Box is not present", "FAIL");				
						}	
			
				}
					
			}
			
		/*************************************************************
		Created By          : Vishnu Prasad D
		Created Date        : 03/25/2014
		Method Functionality: New Customer - Screening continue button
		**************************************************************/	
		public void screeningContinue(){
			if(browser.isElementVisible(pageProperties.getProperty("ChannelActivation.screeningContinue")))
			{
			verifyAndClick(pageProperties.getProperty("ChannelActivation.screeningContinue"), "screening Continue button");
			} else{
			Report.updateTestLog("Screening Continue button is not present", "FAIL");				
			}				
			}
		/*************************************************************
		Created By          : Ragul M
		Created Date        : 11/20/2014
		Method Functionality: New Customer - JoinUs Link after Screening Questions
		**************************************************************/	
		public void screeningJoinUs(){
			browser.wait(3000);
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.screeningJoinus")))
			{
			verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.screeningJoinus"), "screening Join Us Link");
			} else{
			Report.updateTestLog("Screening Join Us Link is not present", "FAIL");				
			}				
		}
		/*************************************************************
		Created By          : Ragul M
		Created Date        : 11/20/2014
		Method Functionality: New Customer - JoinUs Link after Screening Questions
		**************************************************************/	
		public void screeningJoinUsWaitingPrority(){
			browser.wait(8000);
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.screeningJoinusWaitingPrority")))
			{
			Report.updateTestLog("Screening Join Us Link is present", "WARN");
			} else{
			Report.updateTestLog("Screening Join Us Link is not present", "FAIL");				
			}				
		}
		/*************************************************************
		Created By          : Ragul M
		Created Date        : 11/20/2014
		Method Functionality: New Customer - Join us Link after entering screening questions wrongly
		**************************************************************/	
		public void screeningGetAQuote(){
			browser.wait(5000);
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.screeningGetAQuote")))
			{
			verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.screeningGetAQuote"), "Screening Get A Quote");
			} else{
			Report.updateTestLog("Get A Quote is not present", "FAIL");				
			}				
		}
		/*************************************************************
		Created By          : Ragul M
		Created Date        : 11/20/2014
		Method Functionality: New Customer - Add to Waiting List
		**************************************************************/	
		public void verifyWeAreSorryPage(){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.notInterestedLink")))
			{
				Report.updateTestLog("Not Interested Link is present", "PASS");		
			} else{
			Report.updateTestLog("Not Interested Link is not present", "FAIL");				
			}	
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.registerYourInterestLink")))
			{
			verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.registerYourInterestLink"), "Register Your Interest Link");	
			} else{
			Report.updateTestLog("Register Your Interest Link is not present", "FAIL");				
			}		
			
		}
		
		
		/*************************************************************
		Created By          : Vishnu Prasad D
		Created Date        : 03/26/2014
		Method Functionality: New Customer - Add to Waiting List
		**************************************************************/	
		
		public void newCusFlowDecider(Acquisition acquisition,UserProfile userProfile,String AddressDD, String outstandingBalance,String Eco7,String Flat,String FuseBox,String Smart,String Tariff,String paymentType){
			
			if((outstandingBalance=="No")&&(Eco7=="No")&&(Flat=="No")&&(FuseBox=="Yes")&&(Smart=="No")){
				System.out.println("New Customer - Working Flow");
				
			    tellAbtYou(userProfile,AddressDD);
				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.newContinueToGAQ"))){
					Report.updateTestLog("Continue to Get a Quoate Link Exists", "PASS");
					browser.wait(10000);
					verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.newContinueToGAQ"), "Continue to Get a Quoate");
				}
				    browser.wait(10000);
					GAQPage(userProfile,paymentType);
					YourQuotePage(Tariff);
					OrderEnergyPage();
					personalDetailsPage(userProfile,AddressDD);
					newMeterDetailsPage(Tariff,paymentType);
					newPaymentPage(acquisition,paymentType);
					newReviewOrder(paymentType);
					newValidateConfirmation();
				
				
			}
			else{
				System.out.println("New Cust Not working flow");
				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.AddMeToWaitingList"))){
					Report.updateTestLog("Add Me to Waiting List Link - Present", "PASS");	
					verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.AddMeToWaitingList"), "Add Me to Waiting List Link");
					tellAbtYou(userProfile,AddressDD);
				}
								
			}
		}
		
		/*************************************************************
		Created By          : Vishnu Prasad D
		Created Date        : 03/26/2014
		Method Functionality: New Customer - tellAbtYou
		**************************************************************/	
		
		public void tellAbtYou(UserProfile userProfile,String AddressDD){
			
			 if (browser.isElementVisible(pageProperties.getProperty("ChannelActivation.NewSelectTitle"))) {
	    		 String dropdata=browser.getTextByXpath(pageProperties.getProperty("ChannelActivation.NewSelectTitleDropdown"));
	    	        browser.selectfromDropBox("id", pageProperties.getProperty("ChannelActivation.NewSelectTitle"),dropdata);
	    	        Report.updateTestLog("Title has been Entered successfully" , "PASS");
	    	    } else {
	    	        Report.updateTestLog("Title has not been Entered successfully", "FAIL");
	    	    }	
			verifyAndInputById(pageProperties.getProperty("ChannelActivation.NewFirstName"), "New First Name", userProfile.getFirstName() );
			verifyAndInputById(pageProperties.getProperty("ChannelActivation.NewSurName"), "New Sur Name",userProfile.getLastName());
			verifyAndInputById(pageProperties.getProperty("ChannelActivation.PostCodeNew"), "Postal Code",userProfile.getaddr());
			//verifyAndInputById(pageProperties.getProperty("ChannelActivation.PostCodeNew"), "Postal Code",userProfile.getPostCode());
			//verifyAndInputById(pageProperties.getProperty("ChannelActivation.PostCodeNew"), "Postal Code",acquisition.getPostcode());
			verifyAndClick(pageProperties.getProperty("ChannelActivation.NewFindYourAddress"), "Find Address");
			/*browser.wait(15000);*/
			browser.WaitForElementWithId(pageProperties.getProperty("ChannelActivation.NewSelectAddress"));
			
			 if (browser.isElementVisible(pageProperties.getProperty("ChannelActivation.NewSelectAddress"))) {
				 String add=pageProperties.getProperty("ChannelActivation.NewSelectAddressDD").replace("+i+", AddressDD);
				 System.out.println("dropdata Xpath *****************11111111111111 = "+add);
	    		 String dropdata=browser.getTextByXpath(add);
	    		 
	    				 //".//*[@id='displayaddr']/option[2]");
	    				 //
	    		 System.out.println("address value" +dropdata);
	    	        browser.selectfromDropBox("id", pageProperties.getProperty("ChannelActivation.NewSelectAddress"),dropdata);
	    	        Report.updateTestLog("Address has been Entered successfully" , "PASS");
	    	    } else {
	    	        Report.updateTestLog("Address has not been Entered successfully", "FAIL");
	    	        if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.PostalCodeError"))){
	    	        	String PostalError=browser.getTextByXpath(pageProperties.getProperty("ChannelActivation.PostalCodeError"));
	    	        	Report.updateTestLog("Postal code error = " +PostalError, "FAIL");
	    	      }
	    	    }      
	    	  verifyAndInputById(pageProperties.getProperty("ChannelActivation.NewEmail"), "New Email", userProfile.getEmail());
	    	  
	    	  verifyAndSelectDropDownBox(pageProperties.getProperty("ChannelActivation.NewCustEmail"), "Email Type",  "Work");
	    	  verifyAndInputById(pageProperties.getProperty("ChannelActivation.NewConfirmEmail"), "New Confirm Email", userProfile.getEmail());
	    	  
	    /*	  verifyAndInputById(pageProperties.getProperty("ChannelActivation.NewConfirmEmail"), "New Confirm Email", userProfile.getEmail());*/
	    	  verifyAndInputById(pageProperties.getProperty("ChannelActivation.NewTeleNum"), "Phone number", userProfile.getPhoneNumber());
	    	  verifyAndSelectDropDownBox(pageProperties.getProperty("ChannelActivation.TelephoneNumberType"), "Telephone Type",  "Work");
	    	  if (browser.isElementVisible(pageProperties.getProperty("ChannelActivation.NewTeleNumType"))) {
	    		  	    		  
		    		 /*String dropdata=browser.getTextByXpath(pageProperties.getProperty("ChannelActivation.NewTeleNumTypeDropdown"));
		    	        browser.selectfromDropBox("id", pageProperties.getProperty("ChannelActivation.NewTeleNumType"),dropdata);*/
	    		  verifyAndSelectDropDownBox(pageProperties.getProperty("ChannelActivation.NewTeleNumType"), "Phone Type", userProfile.getPhoneType());
	    		  
		    	        Report.updateTestLog("Tele num Type has been Entered successfully" , "PASS");
		    	    } else {
		    	        Report.updateTestLog("Tele num Type has not been Entered successfully", "FAIL");
		    	    }	
			 verifyAndClick(pageProperties.getProperty("ChannelActivation.NewPDetailsSubmit"), "Submit");
			 browser.wait(5000);
			}
		
		/*************************************************************
		Created By          : Vishnu Prasad D
		Created Date        : 03/26/2014
		Method Functionality: New Customer - Verify Negative flow confirmation
		**************************************************************/	
		
		public void newCustNegaConfirmtn(){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.NewCustNegConfmMsg"))){
			String newCustNegCnfMsg=browser.getTextByXpath(pageProperties.getProperty("ChannelActivation.NewCustNegConfmMsg"));
				Report.updateTestLog("New ineligible Customer Smart Meter Upgrade Confirmation Exists: "+newCustNegCnfMsg, "PASS");
			}else{
				Report.updateTestLog("New ineligible Customer Smart Meter Upgrade Confirmation does not Exists ", "FAIL");
			}			
		}
			
		
		/*************************************************************
		Created By          : Vishnu Prasad D
		Created Date        : 03/26/2014
		Method Functionality: Existing Customer - click on smart Meter link
		**************************************************************/	
		
		public void exclickSmartMeterLink(UserProfile userProfile,String Account){
		//	String JiXpath=".//*[@id='851000000131851000000130']/div[5]/a";
			
			String JiXpath1 =".//*[@id='"+userProfile.getAccNumber()+"']/div[5]/a";
			String JiXpath2 =".//*[@id='"+userProfile.getAccNumber()+userProfile.getAccNumber()+"']/div[5]/a";
			
			String JiXpath3 =".//*[@id='"+userProfile.getElecAccount()+userProfile.getGasAccount()+"']/div[4]/a";
			String JiXpath4 =".//*[@id='"+userProfile.getAccNumber()+userProfile.getAccNumber()+"']/div[5]/a[1]";
			
			
			String DualXpath1 =".//*[@id='"+userProfile.getElecAccount()+userProfile.getGasAccount()+"']/div[5]/a";
			String DualXpath2 =".//*[@id='"+userProfile.getElecAccount()+userProfile.getGasAccount()+"']/div[5]/a[1]";
			String DualXpath3 =".//*[@id='"+userProfile.getElecAccount()+userProfile.getGasAccount()+"']/div[4]/a";
			if(Account=="DUEL")	{							
				if(browser.isElementVisibleWithXpath(DualXpath1)){
				verifyAndClickWithXpath(DualXpath1, "Dual Smart Meter Link 1 ");	
				}
				else if(browser.isElementVisibleWithXpath(DualXpath2)){
					verifyAndClickWithXpath(DualXpath2, "Dual Smart Meter Link 2");	
					}
				else if(browser.isElementVisibleWithXpath(DualXpath3)){
					verifyAndClickWithXpath(DualXpath3, "Dual Smart Meter Link 2");	
					}else{
					Report.updateTestLog("Duel Smart Meter upgrade link is not present", "FAIL");
				}
			}
									
			
			if(Account=="JI"){	
				if(browser.isElementVisibleWithXpath(JiXpath1)){
					verifyAndClickWithXpath(JiXpath1, "Ji Smart Meter Link 1");
						}else if(browser.isElementVisibleWithXpath(JiXpath2)){
							verifyAndClickWithXpath(JiXpath2, "Ji Smart Meter Link 2");
							
						}
						else if(browser.isElementVisibleWithXpath(JiXpath3)){
							verifyAndClickWithXpath(JiXpath3, "Ji Smart Meter Link 3");
							System.out.println("JI link 3 :" +JiXpath3);
							
						}else if(browser.isElementVisibleWithXpath(JiXpath4)){
							verifyAndClickWithXpath(JiXpath4, "Ji Smart Meter Link 4");
							System.out.println("JI link 4 :" +JiXpath3);
							
						}else{
							Report.updateTestLog("Ji Smart Meter upgrade link is not present", "FAIL");
						}
					}
			browser.wait(5000);
			if(Account=="Single"){
			System.out.println("555555555555555555555555555555555555555555555555555555555555555");
			 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.UpgradeSmartMeter"))){
				verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.UpgradeSmartMeter"), "General Smart Meter Link");
			}	
			 else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.UpgradeSmartMeter1"))){
					verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.UpgradeSmartMeter1"), "General Smart Meter Link1");
				}
			 else if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.UpgradeSmartMeter2"))){
					verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.UpgradeSmartMeter2"), "General Smart Meter Link2");
				}
			}
		}
		
		
		
		
		/*************************************************************
		Created By          : Vishnu Prasad D
		Created Date        : 03/26/2014
		Method Functionality: Existing Customer - In Eligible
		**************************************************************/
		
		public void ineligibleCheckClick(){
			verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.CheckInEligible"), "Check your property is eligible ");
		}
		public void clickUpgradeToSmartMeterLink(){
			browser.wait(3000);
			verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.UpgradeToSmartMeterLink"), "Upgrade To Smart Meter Link is clicked");
		}
		public void clickRegisterYourSmartMeterInterestLink(){
			browser.wait(3000);
			verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.RegisterYourSmartMeterInterestLink"), "Register Your Smart Meter Interest Link");
		}
		
		/*************************************************************
		Created By          : Vishnu Prasad D
		Created Date        : 03/26/2014
		Method Functionality: Existing Customer - In Eligible Reasons Exists
		**************************************************************/
		
		
		public void inEligibleReasonExists(){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.InEligibleReasons"))){
				Report.updateTestLog("In Eligible Reasons Exists", "PASS");
				}else{
					Report.updateTestLog("In Eligible Reasons not Exists", "FAIL");
					}
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.InEligibleReasons1"))){
				verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.InEligibleReasons1"), "Check your property is eligible ");
				Report.updateTestLog("In Eligible Reasons1 Exists", "PASS");
				}else{
					Report.updateTestLog("In Eligible Reasons not Exists", "FAIL");
					}
			
		}
		/*************************************************************
		Created By          : Vishnu Prasad D
		Created Date        : 03/26/2014
		Method Functionality: Existing Customer - In Eligible ROI Check British Gas
		**************************************************************/
		public void checkBritishGasCheckBox(){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.BritishGasCheckBox"))){
				verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.BritishGasCheckBox"), "Checking British Gas Check Box");
				Report.updateTestLog("British Gas Check Box Checked", "PASS");
				}else{
					Report.updateTestLog("British Gas Check Box not Checked", "FAIL");
					}
			
		}
		
		
		/*************************************************************
		Created By          : Vishnu Prasad D
		Created Date        : 03/26/2014
		Method Functionality: Existing Customer - In Eligible Submit Return to Account
		**************************************************************/
		
			
		public void InEligibleSubmitReturn(){
			verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.InEligibleSubmitReturn"), "InEligible Submit Return to Account");
		}
		/*************************************************************
		Created By          : Vishnu Prasad D
		Created Date        : 03/26/2014
		Method Functionality: Existing Customer - In Eligible Customer Checking You are on our smart
		**************************************************************/
		
			
		public void InEligibleVerifyAccountOverview(){
			browser.wait(5000);
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.UpgradeSmartMeter1"))){
				
				Report.updateTestLog("Register for Interest Link Exsits", "PASS");
				}else{
					Report.updateTestLog("Register for Interest Link Exsits", "FAIL");
					}
			
		}
		
		/*************************************************************
		Created By          : Vishnu Prasad D
		Created Date        : 03/26/2014
		Method Functionality: Existing Customer - Screening Questions
		**************************************************************/	
		
		public void exScreeningQues(UserProfile userProfile,String ExQues1,String ExQues2){
			if(ExQues1=="YES"){
				if(browser.isElementVisible(pageProperties.getProperty("ChannelActivation.ExScreeningQues1Yes"))){
				verifyAndClick(pageProperties.getProperty("ChannelActivation.ExScreeningQues1Yes"), "Ex Cust Screening Ques 1 Yes");
				}else{
					Report.updateTestLog("Ques1 Yes does not exists", "FAIL");
					}
			}
			if(ExQues1=="NO"){
				if(browser.isElementVisible(pageProperties.getProperty("ChannelActivation.ExScreeningQues1No"))){
				verifyAndClick(pageProperties.getProperty("ChannelActivation.ExScreeningQues1No"), "Ex Cust Screening Ques 1 No");
					}else{
						Report.updateTestLog("Ques1 No does not exists", "FAIL");
						}
			}
			
			if(ExQues2=="YES"){
				if(browser.isElementVisible(pageProperties.getProperty("ChannelActivation.ExScreeningQues2Yes"))){
				verifyAndClick(pageProperties.getProperty("ChannelActivation.ExScreeningQues2Yes"), "Ex Cust Screening Ques 2 Yes");
					}
				else{
					Report.updateTestLog("Ques2 Yes does not exists", "FAIL");
					}
			}
			if(ExQues2=="NO"){
				if(browser.isElementVisible(pageProperties.getProperty("ChannelActivation.ExScreeningQues2No"))){
				verifyAndClick(pageProperties.getProperty("ChannelActivation.ExScreeningQues2No"), "Ex Cust Screening Ques 2 No");
					}
				else{
					Report.updateTestLog("Ques2 No does not exists", "FAIL");
					}
			}
			
		}
		
		
		/*************************************************************
		Created By          : Vishnu Prasad D
		Created Date        : 03/26/2014
		Method Functionality: Existing Customer - No Appointment validation
		**************************************************************/	
		
		
		
		
		
		/*************************************************************
		Created By          : Vishnu Prasad D
		Created Date        : 03/26/2014
		Method Functionality: Existing Customer - click on continue in confirm adress page
		**************************************************************/	
		public void exClickConfrmAddContinue(){
			orderDate=new OnlineDBConnector().DBsysdate();
			verifyAndClick(pageProperties.getProperty("ChannelActivation.ExCustCnfmAddressContinue"), "Confirm Address Continue");
		}
		
		/*************************************************************
		Created By          : Vishnu Prasad D
		Created Date        : 03/26/2014
		Method Functionality: Existing Customer - Select an Appointment
		**************************************************************/	
		
		public void exSelectAppointment(UserProfile userProfile){
			verifyAndClick(pageProperties.getProperty("ChannelActivation.EXSelectAptmnt1"), "Select Appointment");
			verifyAndInputById(pageProperties.getProperty("ChannelActivation.ExBestContNum"), "Best Contact Number", userProfile.getPhoneNumber());
			verifyAndClick(pageProperties.getProperty("ChannelActivation.ExMeterFreq"), "Half yearly Meter Frequency");
			verifyAndClick(pageProperties.getProperty("ChannelActivation.ExFinalCont"), "Final Continue button");
			}
		/*************************************************************
		Created By          : Ragul M
		Created Date        : 03/26/2014
		Method Functionality: Existing Customer - Verifying Choose An Appointment Page
		**************************************************************/	
		public void verifyChooseYourAppointmentPage(){
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.FirstAvailableAppointmentSection"), "First Available Appointment Section");
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.ViewCalendarSection"), "View Calendar Section");
			verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.ViewCalender"), "View Calendar");
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.ViewCalendarPanel"), "View Calendar Panel");
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.BackLink"), "BackL ink");
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.CancelLink"), "Cancel Link ");	
			}
		/*************************************************************
		Created By          : Ragul M
		Created Date        : 03/26/2014
		Method Functionality: Existing Customer - Selecting First Available Appointment
		**************************************************************/	
		public void navigateToReviewYourAppointmentPageFirstAvailableAppointment(){
			
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.SelectThisAppointment"))){
					
				verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.SelectThisAppointment"), "Select This Appointment");
				Report.updateTestLog("Select This Appointment is Present in the Application", "PASS");
			}
			else{
				Report.updateTestLog("Select This Appointment is not Present in the Application", "FAIL");
			}
			
		}
		/*************************************************************
		Created By          : Ragul M
		Created Date        : 03/26/2014
		Method Functionality: Existing Customer - Selecting Available Appointment Through Calendar
		**************************************************************/	
		public void navigateToReviewYourAppointmentPageThroughCalendar(){
			
			 for (int i = 1 ;i<15;i++){
				for (int j = 2 ; j <15 ; j++){
					if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.availableSlots").replace("Row", ""+i).replace("Col", ""+j))){
						verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.availableSlots").replace("Row", ""+i).replace("Col", ""+j),"Available Slots");
						browser.wait(5000);
						verifyAndClickWithXpath(".//*[@title='Select this appointment'][@id='']", "Select this appointment Button in Over Lay");
						Report.updateTestLog("Next available slot is clicked successfully","WARN");	
					
						break;
					}
				}
			
			 }
		}
		/*************************************************************
		Created By          : Ragul M
		Created Date        : 03/26/2014
		Method Functionality: Existing Customer - Verifying Review Details Page
		**************************************************************/	
		public void verifyRevieweDtailsPage(String meterReadFrequency){
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.AddressSection"), "Address Section Text in Your smart meter upgrade appointment section");
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.DateandTime"), "Date and Time Text in Your smart meter upgrade appointment section");
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.ChangeAppointment1"), "Change Appointment Link in Your smart meter upgrade appointment section");
			verifyAndInputById(pageProperties.getProperty("ChannelActivation.ExBestContNum"), "Best Contact Number","01234567899");
			//verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.IsThereWeNeedToKnow"), "Is There We Need To Know");
			verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.IsThereWeNeedToKnowNew"), "Is There We Need To Know");
			if(meterReadFrequency=="Half Hourly"){
				verifyAndClick(pageProperties.getProperty("ChannelActivation.NewHalfFrequency"),"Meter Detail - Half Frequency");				
			}
			if(meterReadFrequency=="Daily"){
			    verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.NewSeeMoreOptions1"),"See More Options Link");
			    browser.wait(3000);
				verifyAndClick(pageProperties.getProperty("ChannelActivation.NewDailyFrequency"),"Meter Detail - Daily Frequency");
				}
				if(meterReadFrequency=="Monthly"){
				verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.NewSeeMoreOptions1"),"See More Options Link");
				browser.wait(3000);
				verifyAndClick(pageProperties.getProperty("ChannelActivation.NewMonthlyFrequency"),"Meter Detail - Monthly Frequency");
				}
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.EnergySavingAdviceFlag"), "Energy Saving Advice Flag");	
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.BackLink"), "BackL ink");
			verifyIsElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.CancelLink"), "Cancel Link ");	
			}
		/*************************************************************
		Created By          : Ragul M
		Created Date        : 05/12/2014
		Method Functionality: Existing Customer -Navigating To Confirmation Page
		**************************************************************/	
		 public void navigateToConfirmationPage(){
		    	
		    	verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.ConfirmAppointment"), "Confirm Appointment");
		    	
		    }
		
		/*************************************************************
			Created By          : Vishnu Prasad D
			Created Date        : 03/26/2014
			Method Functionality: Existing Customer - Appointment Confirm
		**************************************************************/	
		
		public void exVerifyApnmtConfirm(UserProfile userProfile){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.ExConfirmation"))){
				String bookingNo=browser.getTextByXpath(pageProperties.getProperty("ChannelActivation.ExBookingNum"));
				Report.updateTestLog("Appointment has been Booked Successfully, "+bookingNo, "PASS");
				exvalidateAppointmentDoneDB(userProfile);
				exvalidateNotif(userProfile);
			}else{
				Report.updateTestLog("Appointment is not booked", "FAIL");
			}
		}
		
		public void exvalidateAppointmentDoneDB(UserProfile userProfile){
			OnlineDBConnector DB = new OnlineDBConnector();
			String AuditDetails=DB.getAuditDetailsIDCA(userProfile.getUCRN(),orderDate);
			Report.updateTestLog("Appointment Done - Audit Details = "+AuditDetails, "PASS");
		}
		
		
		public void exvalidateNotif(UserProfile userProfile){
			OnlineDBConnector DB = new OnlineDBConnector();
			String NotifDetails=DB.getNotifDetailsCA(orderDate);
			Report.updateTestLog("Notif Details Email Address= "+NotifDetails, "PASS");
		}
		
		/*************************************************************
			Created By          : Vishnu Prasad D
			Created Date        : 03/26/2014
			Method Functionality: Existing Customer - Return to Account - Click
		**************************************************************/	
		
		public void exClickGo2Account(){
			verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.GoToUrAccount"),"Go To Your Account");
		}
		
		/*************************************************************
		Created By          : Vishnu Prasad D
		Created Date        : 03/26/2014
		Method Functionality: Existing Customer - Validate Appointment Present in account overview page
	**************************************************************/	
		public void exAppointmentExistsValidn(){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.AppointmentExists"))){
				String ApnmntMsg=browser.getTextByXpath(pageProperties.getProperty("ChannelActivation.AppointmentExists"));
				Report.updateTestLog("Appoinment Exists in account overview page - "+ApnmntMsg, "PASS");
			}else{
				Report.updateTestLog("Appoinment does not Exists in account overview page", "FAIL");
			}
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.ChangeAppointment"))){
				Report.updateTestLog("Change Appoinment Exists in account overview page", "PASS");
			}else{
				Report.updateTestLog("Change Appoinment does not Exists in account overview page", "FAIL");
			}
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.CancelAppointment"))){
				Report.updateTestLog("Cancel Appoinment Exists in account overview page", "PASS");
			}else{
				Report.updateTestLog("Cancel Appoinment does not Exists in account overview page", "FAIL");
			}
		}
		
		
		/*************************************************************
			Created By          : Vishnu Prasad D
			Created Date        : 03/26/2014
			Method Functionality: Existing Customer - No Appointment validation
		**************************************************************/	
		
		public void exNoApntmntValidation(){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.ExApptmntNotAvailable"))){
				String NoApnmntMsg=browser.getTextByXpath(pageProperties.getProperty("ChannelActivation.ExApptmntNotAvailable"));
				Report.updateTestLog("No Appoinment Exists Error Msg Exists - "+NoApnmntMsg, "PASS");
			}else{
				Report.updateTestLog("No Appoinment Exists Error Msg does not Exists", "FAIL");
			}
		}
		
		
		/*************************************************************
			Created By          : Vishnu Prasad D
			Created Date        : 03/26/2014
			Method Functionality: Existing Customer - 
		**************************************************************/	
		public void exRegIntrestClick(){
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.ExRegIntrest"))){
				verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.ExRegIntrest"), "Register Intrest Link");
				}else{
				Report.updateTestLog("Register Your Interest link not exists", "FAIL");
			}
		}
		
		/*************************************************************
		Created By          : Vishnu Prasad D
		Created Date        : 03/26/2014
		Method Functionality: Existing Customer - Smart Updates
	 **************************************************************/	
		
		public void exClickSmartUpdates(){
			verifyAndClick(pageProperties.getProperty("ChannelActivation.SmartUpdatesCheckBox"), "Smart Updates Check box");
		}
		
		
		/*************************************************************
			Created By          : Vishnu Prasad D
			Created Date        : 03/26/2014
			Method Functionality: Existing Customer - Find out more link
		 **************************************************************/	
		
		public void exClickFindMoreLink(){
			verifyAndClick(pageProperties.getProperty("ChannelActivation.ExFindMoreLink"), "Find More Link");
			
		}
		
	/*	
		*//*************************************************************
			Created By          : Vishnu Prasad D
			Created Date        : 03/26/2014
			Method Functionality: Existing Customer - Change Appointment Link Click
		 **************************************************************//*	
		public void exChangeApntmntLinkClick(){
			verifyAndClick(pageProperties.getProperty("ChannelActivation.ChangeAppointmentLink"), "Change Appointment Link");
		}*/
		
		
		public void newContinueToGAQ(){
			verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.newContinueToGAQ"), "Continue Get A Quoate");
		}
		
		/*************************************************Get A Quoate Page**********************************************/
		
		public void newGAQPage(){
			verifyAndClick(pageProperties.getProperty("ChannelActivation.newGAQPostCodeNext"), "Post Code Next");
			verifyAndClick(pageProperties.getProperty("ChannelActivation.newGAQPostCodeNext"), "Post Code Next");
			
			
		}
		
		public void changeBooking(){
			clickChangeAppointment();
			changeSelectAppointment();
			changeVerifyApnmtConfirm();
			changeClickGo2Account();
			ChangeAppointmentExistsValidn();	
		}
		
		
		public void changeBookingHalf(){
			clickChangeAppointment();
			changeSelectAppointmentHalf();
			changeVerifyApnmtConfirm();
			changeClickGo2Account();
			ChangeAppointmentExistsValidn();	
		}
		
				
		public void changeBookingDaily(){
			clickChangeAppointment();
			changeSelectAppointmentDaily();
			changeVerifyApnmtConfirm();
			changeClickGo2Account();
			ChangeAppointmentExistsValidn();	
		}
		
		public void changeBookingMonthly(){
			clickChangeAppointment();
			changeSelectAppointmentMonthly();
			changeVerifyApnmtConfirm();
			changeClickGo2Account();
			ChangeAppointmentExistsValidn();	
		}
		
		
		/*************************************************************
			Created By          : Vishnu Prasad D
			Created Date        : 03/26/2014
			Method Functionality: Change Appointment - Change Appointment Link Click
		 **************************************************************/	
		
		public void clickChangeAppointment(){
			verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.ChangeAppointment"), "Change Appointment Link");
			
		}
		
	/*	*//*************************************************************
		Created By          : Vishnu Prasad D
		Created Date        : 03/26/2014
		Method Functionality: Existing Customer - Change Appointment Link Click
	 **************************************************************//*	
	
	public void clickChangeAppointment(){
		verifyAndClick(pageProperties.getProperty("ChannelActivation.ChangeAppointment"), "Change Appointment Link");
		
	}*/
	
	/*************************************************************
	Created By          : Vishnu Prasad D
	Created Date        : 03/26/2014
	Method Functionality: Change Appointment - Select an Appointment
	**************************************************************/	
	
	public void changeSelectAppointment(){
		browser.WaitForElementWithId(pageProperties.getProperty("ChannelActivation.ChangeSelectAppointment"));	
		/*verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.ChangeNextApntmnt"), "Next Appointment");*/
		verifyAndClick(pageProperties.getProperty("ChannelActivation.ChangeSelectAppointment"), "Select Appointment");
		
		verifyAndClick(pageProperties.getProperty("ChannelActivation.ChangeCont"), "Change Continue button");
		}
	

	/*************************************************************
	Created By          : Vishnu Prasad D
	Created Date        : 03/26/2014
	Method Functionality: Change Appointment - Select an Appointment
	**************************************************************/	
	
	public void changeSelectAppointmentHalf(){
		browser.wait(10000);
		verifyAndClick(pageProperties.getProperty("ChannelActivation.ChangeSelectAppointment"), "Select Appointment");
		changeHalfMeter();
		verifyAndClick(pageProperties.getProperty("ChannelActivation.ChangeCont"), "Change Continue button");
		
		}

	/*************************************************************
	Created By          : Vishnu Prasad D
	Created Date        : 03/26/2014
	Method Functionality: Change Appointment - Select an Appointment
	**************************************************************/	
	
	public void changeSelectAppointmentDaily(){
		browser.WaitForElementWithId(pageProperties.getProperty("ChannelActivation.ChangeSelectAppointment"));		
		verifyAndClick(pageProperties.getProperty("ChannelActivation.ChangeSelectAppointment"), "Select Appointment");
		changeDailyMeter();
		verifyAndClick(pageProperties.getProperty("ChannelActivation.ChangeCont"), "Change Continue button");
		}

	/*************************************************************
	Created By          : Vishnu Prasad D
	Created Date        : 03/26/2014
	Method Functionality: Change Appointment - Select an Appointment
	**************************************************************/	
	
	public void changeSelectAppointmentMonthly(){
		browser.WaitForElementWithId(pageProperties.getProperty("ChannelActivation.ChangeSelectAppointment"));	
		verifyAndClick(pageProperties.getProperty("ChannelActivation.ChangeSelectAppointment"), "Select Appointment");
		changeMonthlyMeter();
		verifyAndClick(pageProperties.getProperty("ChannelActivation.ChangeCont"), "Change Continue button");
		}
	
	/*************************************************************
	Created By          : Vishnu Prasad D
	Created Date        : 03/26/2014
	Method Functionality: Change Appointment - Half Yearly Verification
	**************************************************************/	
	
	public void changeDailyMeter(){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.ChangeMeterFreq"))){
			Report.updateTestLog("Daily Meter - Meter Frequency exists", "PASS");
			}else{
				Report.updateTestLog("Daily Meter - Meter Frequency does not exists", "FAIL");
			}
	}
	
	
	
	/*************************************************************
	Created By          : Vishnu Prasad D
	Created Date        : 03/26/2014
	Method Functionality: Change Appointment - Half Yearly Verification
	**************************************************************/	
	
	public void changeMonthlyMeter(){
		if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.ChangeMeterFreq"))){
			Report.updateTestLog("Monthly Meter - Meter Frequency exists", "PASS");
		}else{
			Report.updateTestLog("Monthly Meter - Meter Frequency does not exists", "FAIL");
		}
	}
	/*************************************************************
	Created By          : Vishnu Prasad D
	Created Date        : 03/26/2014
	Method Functionality: Change Appointment - Half Yearly Verification
	**************************************************************/	
	
	public void changeHalfMeter(){
		if(!browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.ChangeMeterFreq"))){
			Report.updateTestLog("Half Meter - Meter Frequency does not exists", "PASS");
			}else{
				Report.updateTestLog("Half Meter - Meter Frequency exists", "FAIL");
			}
	}
	
	
	/*************************************************************
	Created By          : Vishnu Prasad D
	Created Date        : 03/26/2014
	Method Functionality: Change Appointment - Appointment Confirm
**************************************************************/	

public void changeVerifyApnmtConfirm(){
	if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.ChangeConfirmation"))){
		String bookingNo=browser.getTextByXpath(pageProperties.getProperty("ChannelActivation.ChangeBookingNum"));
		Report.updateTestLog("Appointment has been changed Successfully, "+bookingNo, "PASS");
		}else{
		Report.updateTestLog("Appointment is not changed booked", "FAIL");
	}
}				
					/*************************************************************
					Created By          : Vishnu Prasad D
					Created Date        : 03/26/2014
					Method Functionality: Change Appointment - Appointment Confirm
			 		**************************************************************/

			public void changeClickGo2Account(){
						verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.ChangeGoToUrAccount"),"Go To Your Account");
					}
			
			/*************************************************************
			Created By          : Vishnu Prasad D
			Created Date        : 03/26/2014
			Method Functionality: change Appointment - Validate Appointment Present in account overview page
		**************************************************************/	
			public void ChangeAppointmentExistsValidn(){
				if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.ChangeAppointmentExists"))){
					String ApnmntMsg=browser.getTextByXpath(pageProperties.getProperty("ChannelActivation.ChangeAppointmentExists"));
					Report.updateTestLog("Appoinment Exists in account overview page - "+ApnmntMsg, "PASS");
				}else{
					Report.updateTestLog("Appoinment does not Exists in account overview page", "FAIL");
				}
				
			}
	
		
		/*************************************************************
		Created By          : Vishnu Prasad D
		Created Date        : 03/26/2014
		Method Functionality: New Customer - Valid Flow
	 **************************************************************/	
		
		public void GAQPage(UserProfile userProfile,String paymentType){
			Report.updateTestLog("*************************Get A Quote Page************************", "WARN");		
			verifyAndClick(pageProperties.getProperty("ChannelActivation.newGAQPostCodeNext"), "GAQ Post Code Next");
			verifyAndClick(pageProperties.getProperty("ChannelActivation.newGAQEnergyType"), "GAQ energy Type");
			browser.wait(3000);
			 if (browser.isElementVisible(pageProperties.getProperty("ChannelActivation.NewGasSuplr"))) {
	    		 String dropdata=browser.getTextByXpath(pageProperties.getProperty("ChannelActivation.NewGasSuplrDD"));
	    	        browser.selectfromDropBox("id", pageProperties.getProperty("ChannelActivation.NewGasSuplr"),dropdata);
	    	        Report.updateTestLog("Gas Supplier Entered successfully" , "PASS");
	    	    } else {
	    	        Report.updateTestLog("Gas Supplier has not been Entered successfully", "FAIL");
	    	    }	
			 if (browser.isElementVisible(pageProperties.getProperty("ChannelActivation.NewElecSuplr"))) {
	    		 String dropdata=browser.getTextByXpath(pageProperties.getProperty("ChannelActivation.NewElecSuplrDD"));
	    	        browser.selectfromDropBox("id", pageProperties.getProperty("ChannelActivation.NewElecSuplr"),dropdata);
	    	        Report.updateTestLog("Elec Supplier Entered successfully" , "PASS");
	    	    } else {
	    	        Report.updateTestLog("Elec Supplier has not been Entered successfully", "FAIL");
	    	    }	
			
			verifyAndClick(pageProperties.getProperty("ChannelActivation.newGAQFuelNext"), "GAQ Fuel Next");
			if(paymentType=="MVDD"){
			verifyAndClick(pageProperties.getProperty("ChannelActivation.newGAQPaymentDetails"), "GAQ Payment MVDD");
			}
			if(paymentType=="Cash/Cheque"){
			verifyAndClick(pageProperties.getProperty("ChannelActivation.newGAQPaymentDetails1"), "GAQ Payment Cash/Cheque");
			}
			if(paymentType=="Pay As You Go"){
			verifyAndClick(pageProperties.getProperty("ChannelActivation.newGAQPaymentDetails2"), "GAQ Payment Pay As You Go");
			}
			verifyAndClick(pageProperties.getProperty("ChannelActivation.newGAQPaymentNext"), "GAQ Payment Next");
			verifyAndClick(pageProperties.getProperty("ChannelActivation.newGAQConsumptionYes"), "GAQ Consumption Yes");
			
						
			verifyAndInputById(pageProperties.getProperty("ChannelActivation.newGAQConsumptionGas"), "Gas Consumption", "100");
			verifyAndInputById(pageProperties.getProperty("ChannelActivation.newGAQConsumptionElec"), "Elec Consumption", "100");
			verifyAndClick(pageProperties.getProperty("ChannelActivation.newGAQConsptnNext"), "GAQ Consumption Next");
			
			//verifyAndSelectDropDownBox(pageProperties.getProperty("ChannelActivation.newGAQPhoneType"), "Phone Type", userProfile.getPhoneType());
			verifyAndClick(pageProperties.getProperty("ChannelActivation.newGAQDetailsNext"), "GAQ Contact Details Next");
			
			browser.wait(3000);
			verifyAndClick(pageProperties.getProperty("ChannelActivation.newGAQGAQBtn"), "GAQ Get a Quoate Button");
		}
		
		/*************************************************************
		Created By          : Vishnu Prasad D
		Created Date        : 03/26/2014
		Method Functionality: After GAQ - your Quote Page
		Changes Occur       : Need To Change Properties According To The Tariff Listed
	 **************************************************************/	
		
		public void YourQuotePage(String Tariff){	
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.newYourDetailsDuel"))){
				String DuelText=browser.getTextByXpath(pageProperties.getProperty("ChannelActivation.newYourDetailsDuel"));
				Report.updateTestLog("Only Duel Fuel Text Exists in Your Details Page", "PASS");
			}else{
				Report.updateTestLog("Duel Fuel Text does not Exists in Your Details Page", "FAIL");
			}
			if(Tariff=="A"){
			verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.NewGasQuoteSwitch"), "GAS Switch");
			}
			if(Tariff=="B"){
			verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.NewGasQuoteSwitchTariffBBtn"), "Switch To Tariff B Button");
			verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.NewGasQuoteSwitchTariffBLink"), "Switch To Tariff B Link");				
			}
			if(Tariff=="C"){
			verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.NewGasQuoteSwitchTariffCBtn"), "Switch To Tariff C Button");
			verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.NewGasQuoteSwitchTariffCLink"), "Switch To Tariff C Link");		
			}
			if(Tariff=="D"){
			verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.NewGasQuoteSwitchTariffDBtn"), "Switch To Tariff D Button");
			verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.NewGasQuoteSwitchTariffDLink"), "Switch To Tariff D Link");		
			}
		}
		
			/*************************************************************
				Created By          : Vishnu Prasad D
				Created Date        : 03/26/2014
				Method Functionality: Ne Cust -After GAQ - your Quote Page
			 **************************************************************/	
		
		public void OrderEnergyPage(){
			//Report.updateTestLog("*********************************Order Detail Page******************************", "WARN");		
			 verifyAndClick(pageProperties.getProperty("ChannelActivation.NewNectar"), "Nectar No Thanks");
			 verifyAndClick(pageProperties.getProperty("ChannelActivation.NewOrderP1Cont"), "Order Continue Button");
			}
		
					/*************************************************************
						Created By          : Vishnu Prasad D
						Created Date        : 03/26/2014
						Method Functionality: Personal Details
					 **************************************************************/	
		
		public void personalDetailsPage(UserProfile userProfile,String AddressDD){
			Report.updateTestLog("****************************Personal Details Page*****************************", "WARN");
			if (browser.isElementVisible(pageProperties.getProperty("ChannelActivation.NewDOBDay"))) {
	    		 String dropdata=browser.getTextByXpath(pageProperties.getProperty("ChannelActivation.NewDOBDayDD"));
	    	        browser.selectfromDropBox("id", pageProperties.getProperty("ChannelActivation.NewDOBDay"),dropdata);
	    	        Report.updateTestLog("DOB - Date Entered successfully" , "PASS");
	    	    } else {
	    	        Report.updateTestLog("DOB - Date has not been Entered successfully", "FAIL");
	    	    }	
			 if (browser.isElementVisible(pageProperties.getProperty("ChannelActivation.NewDOBMonth"))) {
	    		 String dropdata=browser.getTextByXpath(pageProperties.getProperty("ChannelActivation.NewDOBMonthDD"));
	    	        browser.selectfromDropBox("id", pageProperties.getProperty("ChannelActivation.NewDOBMonth"),dropdata);
	    	        Report.updateTestLog("DOB - Month Entered successfully" , "PASS");
	    	    } else {
	    	        Report.updateTestLog("DOB - Month has not been Entered successfully", "FAIL");
	    	    }	
			 if (browser.isElementVisible(pageProperties.getProperty("ChannelActivation.NewDOBYear"))) {
	    		 String dropdata=browser.getTextByXpath(pageProperties.getProperty("ChannelActivation.NewDOBYearDD"));
	    	        browser.selectfromDropBox("id", pageProperties.getProperty("ChannelActivation.NewDOBYear"),dropdata);
	    	        Report.updateTestLog("DOB - Year Entered successfully" , "PASS");
	    	    } else {
	    	        Report.updateTestLog("DOB - Year has not been Entered successfully", "FAIL");
	    	    }	
			 	verifyAndSelectDropDownBox(pageProperties.getProperty("ChannelActivation.NewOrderEmailType"), "Email Type", "Work");
			 	verifyAndInputById(pageProperties.getProperty("ChannelActivation.PdetailsPWD"), "Password", userProfile.getPassword());
			 	verifyAndInputById(pageProperties.getProperty("ChannelActivation.PdetailsPWDCnfm"), "Confirm Password", userProfile.getPassword());
			 	
			 	verifyAndClick(pageProperties.getProperty("ChannelActivation.NewOrderAddressSearch"), "Address Search Button");
			 	browser.wait(5000);
			 	
			 	if (browser.isElementVisible(pageProperties.getProperty("ChannelActivation.NewOrderAddress"))) {
			 		
			 		String add=pageProperties.getProperty("ChannelActivation.NewOrderAddressDD").replace("+i+", AddressDD);
			 		 
			 		System.out.println("dropdata Xpath *****************2222222222222222222222 = "+add);
		    		 String dropdata=browser.getTextByXpath(add);
		    		     		 
		    	        browser.selectfromDropBox("id", pageProperties.getProperty("ChannelActivation.NewOrderAddress"),dropdata);
		    	        Report.updateTestLog("Personal Details Address Entered successfully" , "PASS");
		    	    } 
				 if (browser.isElementVisible(pageProperties.getProperty("ChannelActivation.NewOrderHowLongYear"))) {
		    		 String dropdata=browser.getTextByXpath(pageProperties.getProperty("ChannelActivation.NewOrderHowLongYearDD"));
		    	        browser.selectfromDropBox("id", pageProperties.getProperty("ChannelActivation.NewOrderHowLongYear"),dropdata);
		    	        Report.updateTestLog("How Long Year Entered successfully" , "PASS");
		    	    } else {
		    	        Report.updateTestLog("How Long Year has not been Entered successfully", "FAIL");
		    	    }	
				 if (browser.isElementVisible(pageProperties.getProperty("ChannelActivation.NewOrderHowLongMonth"))) {
		    		 String dropdata=browser.getTextByXpath(pageProperties.getProperty("ChannelActivation.NewOrderHowLongMonthDD"));
		    	        browser.selectfromDropBox("id", pageProperties.getProperty("ChannelActivation.NewOrderHowLongMonth"),dropdata);
		    	        Report.updateTestLog("How Long month Entered successfully" , "PASS");
		    	    } else {
		    	        Report.updateTestLog("How Long Month has not been Entered successfully", "FAIL");
		    	     }
				 verifyAndClick(pageProperties.getProperty("ChannelActivation.NewOrderContinue"),"Order Page continue");
				 
				 if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.ErrorPaymentDetailsAlRegsterd"))){
					 String Error=browser.getTextByXpath(pageProperties.getProperty("ChannelActivation.ErrorPaymentDetailsAlRegsterd"));
					 Report.updateTestLog("Already Registered Error- "+Error, "FAIL");
					 
				 }
			 	
		}
		
				/*************************************************************
					Created By          : Vishnu Prasad D
					Created Date        : 03/26/2014
					Method Functionality: Personal Details
				 **************************************************************/	
		
		public void newMeterDetailsPage(String Tariff,String paymentType){
			Report.updateTestLog("***************************Meter Details Page************************", "WARN");			
			verifyAndInputById(pageProperties.getProperty("ChannelActivation.NewOrderGasReadings"), "Gas Reading", "1234");
			if(paymentType=="MVDD"){
			verifyAndClick(pageProperties.getProperty("ChannelActivation.NewOrderSmartMeterGasNo"),"Smart Meter Gas - No");
			}
			verifyAndInputById(pageProperties.getProperty("ChannelActivation.NewOrderElecReadings"), "Elec Reading", "1234");
			if(paymentType=="MVDD"){
			verifyAndClick(pageProperties.getProperty("ChannelActivation.NewOrderSmartMeterElecNo"),"Smart Meter Elec - No");
			}
			if(Tariff=="A"){
			verifyAndClick(pageProperties.getProperty("ChannelActivation.NewHalfFrequency"),"Meter Detail - Half Frequency");
			}
			if(Tariff=="D"){
			verifyAndClick(pageProperties.getProperty("ChannelActivation.NewHalfFrequency"),"Meter Detail - Half Frequency");
			}
			if(Tariff=="B"){
		    verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.NewSeeMoreOptions"),"See More Options Link");
		    browser.wait(3000);
			verifyAndClick(pageProperties.getProperty("ChannelActivation.NewDailyFrequency"),"Meter Detail - Daily Frequency");
			}
			if(Tariff=="C"){
			verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.NewSeeMoreOptions"),"See More Options Link");
			browser.wait(3000);
			verifyAndClick(pageProperties.getProperty("ChannelActivation.NewMonthlyFrequency"),"Meter Detail - Monthly Frequency");
			}
			verifyAndClick(pageProperties.getProperty("ChannelActivation.NewMeterDetailsContinue"),"Meter Details Page - Continue");
			}
		
		
		public void newPaymentPage(Acquisition acquisition,String paymentType){
			Report.updateTestLog("***********************Payment Details Page**********************", "WARN");	
			if(paymentType=="MVDD"){
			verifyAndInputById(pageProperties.getProperty("ChannelActivation.NewBankAccount"), "Bank Account Number", acquisition.getPaymentAccountNumber());
			verifyAndInputById(pageProperties.getProperty("ChannelActivation.NewBankSort1"), "Bank Sort Code 1", acquisition.getSortCode1());
			verifyAndInputById(pageProperties.getProperty("ChannelActivation.NewBankSort2"), "Bank Sort Code 2", acquisition.getSortCode2());
			verifyAndInputById(pageProperties.getProperty("ChannelActivation.NewBankSort3"), "Bank Sort Code 3", acquisition.getSortCode3());
			verifyAndInputById(pageProperties.getProperty("ChannelActivation.NewBankAccountName"), "Bank Account Name", acquisition.getAccountName());
			verifyAndClick(pageProperties.getProperty("ChannelActivation.NewPaymentContinue"), "Payment Continue");
		    }
			
			/*if(browser.isElementVisible(pageProperties.getProperty("ChannelActivation.NewPaymentDetailPaymentDate"))){
	    		
	         String dropbilldate=browser.getTextByXpath(pageProperties.getProperty("ChannelActivation.NewPaymentDetailPaymentDateDD"));
	              browser.selectfromDropBox("id", pageProperties.getProperty("ChannelActivation.NewPaymentDetailPaymentDate"),dropbilldate);
	              Report.updateTestLog("Payment Options Page Monthly bill date value is selected","PASS");
	     		}else{
	     			  Report.updateTestLog("Payment Options Page Monthly bill date value is not selected","FAIL");
	     		}
			
			if(browser.isElementVisible(pageProperties.getProperty("ChannelActivation.NewGasBillPeriod"))){
	    		
		         String dropdata=browser.getTextByXpath(pageProperties.getProperty("ChannelActivation.NewGasBillPeriodDD"));
		              browser.selectfromDropBox("id", pageProperties.getProperty("ChannelActivation.NewGasBillPeriod"),dropdata);
		              Report.updateTestLog("Gas Bill Period value is selected","PASS");
		     		}else{
		     			  Report.updateTestLog("Gas Bill Period value is not selected","FAIL");
		     		}
			verifyAndInputById(pageProperties.getProperty("ChannelActivation.NewGasAnnualAmount"), "Gas Anual Amount", "100");
			
			if(browser.isElementVisible(pageProperties.getProperty("ChannelActivation.NewElecBillPeriod"))){
	    		
		         String dropdata=browser.getTextByXpath(pageProperties.getProperty("ChannelActivation.NewElecBillPeriodDD"));
		              browser.selectfromDropBox("id", pageProperties.getProperty("ChannelActivation.NewElecBillPeriod"),dropdata);
		              Report.updateTestLog("Elec Bill Period value is selected","PASS");
		     		}else{
		     			  Report.updateTestLog("Elec Bill Period value is not selected","FAIL");
		     		}
			
			verifyAndInputById(pageProperties.getProperty("ChannelActivation.NewElecSpentAmount"), "Elec Anual Amount", "100");*/
		
				
		}
					
		
		public void newReviewOrder(String paymentType){
			Report.updateTestLog("**********************Review Order Page***********************", "WARN");		
			verifyAndClick(pageProperties.getProperty("ChannelActivation.NewReviewOrderSpecialNo"),"Special - No");
			if(paymentType=="MVDD"){
			verifyAndClick(pageProperties.getProperty("ChannelActivation.NewReviewOrderPaperless"),"PaperLess Yes");
			}
			verifyAndClick(pageProperties.getProperty("ChannelActivation.DAPYes"),"DAP Yes");
			verifyAndClick(pageProperties.getProperty("ChannelActivation.NewReviewOrderTerms"),"Review Order Terms and conditions");
			verifyAndClick(pageProperties.getProperty("ChannelActivation.NewMarketingConsentMail"),"Marketing Consent-Mail");
			verifyAndClick(pageProperties.getProperty("ChannelActivation.NewMarketingConsentMobile"),"Marketing Consent-Mobile");
			verifyAndClick(pageProperties.getProperty("ChannelActivation.NewReviewPlaceOrder"),"Place Order");
		}
		
		public void newValidateConfirmation(){
			Report.updateTestLog("***********************Sign up Validation**************************", "WARN");
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.NewSingedUpCnfm"))){
				Report.updateTestLog("New Customer Signed up Successfully", "PASS");				
			}else{
				Report.updateTestLog("New Customer is not Signed up Successfully", "FAIL");
			}
			if(browser.isElementVisibleWithXpath(pageProperties.getProperty("ChannelActivation.NewConfmPageLoginToAccount"))){
				verifyAndClickWithXpath(pageProperties.getProperty("ChannelActivation.NewConfmPageLoginToAccount"), "Login to your Account");
			}
			
		}
}		

				


		

	
	

