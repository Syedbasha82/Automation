package bg.framework.app.functional.action.reFactoring;

import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.action.selfServe.AccountOverviewAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.reFactoring.ForgotPasswordPage;
import bg.framework.app.functional.page.reFactoring.RegistrationPage;
import bg.framework.app.functional.page.selfServe.AccountOverviewPage;
import bg.framework.app.functional.util.OnlineDBConnector;

import java.util.ArrayList;

public class RegistrationAction {

    public static RegistrationPage selfRegisterPage = new RegistrationPage();


    public RegistrationAction registerUpdateYourDetails(final UserProfile selfRegisterData,
                                                                 final String acctNumber) {
    	selfRegisterPage.enterValidateEmailId(selfRegisterData.getEmail());
    	selfRegisterPage.registerCustomerDetails(selfRegisterData, acctNumber);
        selfRegisterPage.verifyOAMCustomerTable(selfRegisterData);
        selfRegisterPage.getRegistrationAuditEventID(selfRegisterData);
        selfRegisterPage.getRegistrationAuditDetails(selfRegisterData);
        return this;
    }

   public AccountOverviewAction goToYourAccount() {
	   
        new RegistrationPage().goToYourAccount();
        return new AccountOverviewAction();
   }
    
    public RegistrationAction registerAccountNum(UserProfile userProfile) {
    	new RegistrationPage().registerAccount(userProfile);
    	return this;
    }
    public RegistrationAction registerInvalidAccountNum(UserProfile userProfile) {
    	new RegistrationPage().enterInvalidAccountregistration(userProfile);
    	return this;
    }
    
    public RegistrationAction verifyAccountNumErrorMsg(UserProfile userProfile,ArrayList<String> errList) {
    	new RegistrationPage().accountNumberErrorMsgValidation(userProfile,errList);
    	return this;
    }
    
    public RegistrationAction verifyFirstNameErrorMsg(UserProfile userProfile,ArrayList<String> errList) {
    	new RegistrationPage().firstNameErrorMsgValidation(userProfile,errList);
    	return this;
    }
    
    public RegistrationAction verifyLastNameErrorMsg(UserProfile userProfile,ArrayList<String> errList) {
    	new RegistrationPage().lastNameErrorMsgValidation(userProfile,errList);
    	return this;
    }
    
    public RegistrationAction verifyEmailAddressErrorMsg(UserProfile userProfile) {
    	new RegistrationPage().emailAddressErrorMsgValidation(userProfile);
    	return this;
    }
    
    public RegistrationAction verifyPasswordErrorMsg(UserProfile userProfile) {
    	new RegistrationPage().passwordErrorMsgValidation(userProfile);
    	return this;
    }
    
    public RegistrationAction verifySecurityErrorMsg(UserProfile userProfile) {
    	//new RegistrationPage().securityErrorMsgValidation(userProfile);
    	return this;
    }
    
    public RegistrationAction verifyContactDetailsErrorMsg(UserProfile userProfile) {
    	//new RegistrationPage().contactDetailsErrorMsgValidation(userProfile);
    	return this;
    }
    
    public RegistrationAction verifyNectarCardErrorMsg(UserProfile userProfile) {
    	new RegistrationPage().nectarCardErrorMsgValidation(userProfile);
    	return this;
    }
    
    public RegistrationAction verifyAcceptTermsErrorMsg(UserProfile userProfile) {
    	new RegistrationPage().acceptTermsErrorMsgValidation(userProfile);
    	return this;
    }
     public RegistrationAction verifyBrowserback(UserProfile userProfile) {
    	new RegistrationPage().verifyBrowserback(userProfile);
    	return this;
    }
    public RegistrationAction verifyMissingAccount(UserProfile userProfile) {
    	new RegistrationPage().verifyAddMissingAccount(userProfile);
    	return this;
    }
    public RegistrationAction enterRegisterDetails(UserProfile userProfile) {
    	new RegistrationPage().enterRegistrationOnline(userProfile.getEmail(),userProfile.getEmail(),userProfile.getPassword(),userProfile.getPassword(),
                                userProfile.getPhoneNumber(),userProfile.getPhoneType(),userProfile.getNectarValue(),userProfile.getAcceptTerms());
    	new RegistrationPage().verifySecondaryUCRNTable(userProfile);
    	new RegistrationPage().verifyOAMCustomerTable(userProfile);
    	return this;
    }
    public RegistrationAction registerPrepaymentAccountNum(UserProfile userProfile) {
    	new RegistrationPage().enterPrepaymentAccountregistration(userProfile);
    	return this;
    }
    public RegistrationAction verifyFastrackRegCustomer(UserProfile userProfile) {
    	new RegistrationPage().verifyFastrackRegCustomer(userProfile.getEmail());
    	new RegistrationPage().verifyRegProfileTempCustomer(userProfile.getEmail());
    	return this;
    }
    public RegistrationAction verifyAlreadyRegisteredCustomer(final UserProfile selfRegisterData) {
		selfRegisterPage.enterValidateEmailId(selfRegisterData.getEmail());
		selfRegisterPage.loginUser(selfRegisterData);		
		return this;
    } 
    public RegistrationAction verifyAccountPresense(String accNumber) {
        new AccountOverviewPage().verifyAccountPresence(accNumber);
        new AccountOverviewPage().logout();
        return this;
    }
    public RegistrationAction verifyResetPassword(final UserProfile selfRegisterData) {
    	selfRegisterPage.enterValidateEmailId(selfRegisterData.getEmail());
		selfRegisterPage.enterResetPassword();	
		return this;
    } 
    public RegistrationAction verifyResetPwd(UserProfile userProfile) {
        new ForgotPasswordPage().navigateToOneTimePasswordPage(userProfile);
        new OnlineDBConnector().verifyAudit(userProfile.getEmail());
        return this;
    }
    public RegistrationAction enterEditEmailId(final UserProfile selfRegisterData) {
		selfRegisterPage.enterValidateEmailId(selfRegisterData.getEmail());
		selfRegisterPage.clickEditEmailAddress(selfRegisterData);		
		return this;
    } 
    public RegistrationAction registerYourDetails(final UserProfile selfRegisterData,
            final String acctNumber) {
		selfRegisterPage.enterValidateEmailId(selfRegisterData.getEmail());
		selfRegisterPage.registerCustomerDetails(selfRegisterData, acctNumber);
		return this;
    }
}
