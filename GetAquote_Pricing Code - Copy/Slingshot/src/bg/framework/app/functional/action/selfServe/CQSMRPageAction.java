package bg.framework.app.functional.action.selfServe;

import java.util.ArrayList;

import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.action.reFactoring.ChangeEmailAction;
import bg.framework.app.functional.action.reFactoring.ForgotEmailAction;
import bg.framework.app.functional.action.reFactoring.ForgotPasswordAction;
import bg.framework.app.functional.action.reFactoring.RegistrationAction;
import bg.framework.app.functional.action.sales.*;
import bg.framework.app.functional.action.selfServe.ContactUsAction;
import bg.framework.app.functional.action.selfServe.HelpAndAdviceAction;
import bg.framework.app.functional.action.selfServe.SelfServeRegistrationAction;
//import bg.framework.app.functional.page.common.LegacyHomePage;

import bg.framework.app.functional.page.selfServe.CQSMRPage;
import bg.framework.app.functional.util.OnlineDBConnector;
import bg.framework.app.functional.entities.UserProfile;


public class CQSMRPageAction {
                
                
                public CQSMRPageAction navigateToSMR1() {
                                CQSMRPage CQSMRPage = new CQSMRPage();
                                CQSMRPage.navigateToSMR1Page();
                                   return new CQSMRPageAction();
                	}
                
                public CQSMRPageAction SelectAccount(UserProfile userprofile){
                  CQSMRPage CQSMRPage = new CQSMRPage();
                  CQSMRPage.SelectAccount(userprofile.getAccNumber());
                  return new CQSMRPageAction();
                	}
                
               
                public CQSMRPageAction resetMeterRead(String accountNumber) {
            		new OnlineDBConnector().resetMeterReadCount(accountNumber);
            		return this;
            	}
                public CQSMRPageAction SetPossibleRead(UserProfile userprofile){
                    CQSMRPage CQSMRPage = new CQSMRPage();
                    CQSMRPage.setPlausbileReading(userprofile.getAccNumber());
                    return new CQSMRPageAction();
                  	}
                  
                public CQSMRPageAction setImPlausbileReadingHigh(UserProfile userprofile) {
                	CQSMRPage CQSMRPage = new CQSMRPage();
                    CQSMRPage.setImPlausbileReadingHigh(userprofile.getAccNumber());
            		return new CQSMRPageAction();
            	} 
                
               
                public CQSMRPageAction setPlausbileReadingforJIAccount(UserProfile userprofile) {
                	CQSMRPage CQSMRPage = new CQSMRPage();              
					CQSMRPage.setPlausbileReadingforJIAccount(userprofile.getAccNumber());
            		return new CQSMRPageAction();
            	} 
                
                public CQSMRPageAction VerifyMeterConfirmationforJIAccount(UserProfile userprofile) {
                	CQSMRPage CQSMRPage = new CQSMRPage();              
					CQSMRPage.verifyMeterConfirmationforJIAccount(userprofile.getAccNumber());
            		return new CQSMRPageAction();
            	} 
                  
                public CQSMRPageAction VerifyMeterConfirmationforSingleAccount(UserProfile userprofile) {
                	CQSMRPage CQSMRPage = new CQSMRPage();              
					CQSMRPage.verifyMeterConfirmation(userprofile.getAccNumber());
            		return new CQSMRPageAction();
            	} 
                
                
                public CQSMRPageAction submitMeterReadsforImplausible() {
                	CQSMRPage CQSMRPage = new CQSMRPage();              
					CQSMRPage.submitMeterReadsforImplausible();
            		return new CQSMRPageAction();
            	} 
                
                public CQSMRPageAction setPlausbileReadingforMultipleAccount(UserProfile userprofile) {
                	CQSMRPage CQSMRPage = new CQSMRPage();              
					CQSMRPage.setPlausbileReadingforMultipleAccount(userprofile.getAccNumber());
            		return new CQSMRPageAction();
            	} 
                
                public CQSMRPageAction setImPlausbileReadingforMultipleAccount(UserProfile userprofile) {
                	CQSMRPage CQSMRPage = new CQSMRPage();              
					CQSMRPage.setImPlausbileReadingforMultipleAccount(userprofile.getAccNumber());
            		return new CQSMRPageAction();
            	} 
                
                public CQSMRPageAction verifyMeterConfirmationforMultipleAccount() {
                	CQSMRPage CQSMRPage = new CQSMRPage();              
					CQSMRPage.verifyMeterConfirmationforMultipleAccount();
            		return new CQSMRPageAction();
            	} 
                
                public CQSMRPageAction submitMeterReadsforPlausible() {
                	CQSMRPage CQSMRPage = new CQSMRPage();              
					CQSMRPage.submitMeterReadsforPlausible();
            		return new CQSMRPageAction();
            	} 
                public CQSMRPageAction setImPlausbileReadingforJIAccount(UserProfile userprofile) {
                	CQSMRPage CQSMRPage = new CQSMRPage();              
					CQSMRPage.setImPlausbileReadingforJIAccount(userprofile.getAccNumber());
            		return new CQSMRPageAction();
            	} 
                
                }
