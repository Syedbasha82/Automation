package bg.framework.app.functional.test.selfServe;

import static bg.framework.app.functional.entities.FunctionalCategory.MakeAPayment;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;
import static bg.framework.app.functional.entities.FunctionalCategory.Smoke;

import org.testng.annotations.Test;

import bg.framework.app.functional.action.selfServe.MakeAPaymentAction;
import bg.framework.app.functional.entities.MakeAPaymentProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class MakeAPaymentTest extends TestBase{
	
	//Mandatory field : UCRN in userprofile 
	
	
	// Visa Debit Journey
	
    @Test(groups = {MakeAPayment,Regression})
    public void verifyPaymentForGasVisaDebit() throws Exception {
        Report.createTestLogHeader("", "");
        
        String strAccountType = "GasAccount";
        MakeAPaymentProfile makeAPaymentProfile = new TestDataHelper().getMakeAPaymentProfile("GasAccountForVisaDebit");
             
       Thread.sleep(4000);     
       
       new MakeAPaymentAction().loginMakeAPayment(makeAPaymentProfile,strAccountType)
       .navigateToMakeAPayment(makeAPaymentProfile,strAccountType)
       .selectAccountToMakeAPayment(makeAPaymentProfile,strAccountType)
       .enterDetailsToMakeAPayment(makeAPaymentProfile)
       .ConfirmSecurityCheck(makeAPaymentProfile);       
    }
    
    @Test(groups = {MakeAPayment,Regression})
    public void verifyPaymentForElectricityVisaDebit() throws Exception {
        Report.createTestLogHeader("", "");
        
        String strAccountType = "ElectricityAccount";
        MakeAPaymentProfile makeAPaymentProfile = new TestDataHelper().getMakeAPaymentProfile("ElectricityAccountForVisaDebit");
             
       Thread.sleep(4000);     
       
       new MakeAPaymentAction().loginMakeAPayment(makeAPaymentProfile,strAccountType)
       .navigateToMakeAPayment(makeAPaymentProfile,strAccountType)
       .selectAccountToMakeAPayment(makeAPaymentProfile,strAccountType)
       .enterDetailsToMakeAPayment(makeAPaymentProfile)
       .ConfirmSecurityCheck(makeAPaymentProfile);
       
    }
    
    @Test(groups = {Regression,MakeAPayment})
    public void verifyPaymentForJIAccountVisaDebit() throws Exception {
        Report.createTestLogHeader("", "");
        
        String strAccountType = "JIAccount";
        MakeAPaymentProfile makeAPaymentProfile = new TestDataHelper().getMakeAPaymentProfile("JIAccountForVisaDebit");
             
       Thread.sleep(4000);     
       
       new MakeAPaymentAction().loginMakeAPayment(makeAPaymentProfile,strAccountType)
       .navigateToMakeAPayment(makeAPaymentProfile,strAccountType)
       .selectAccountToMakeAPayment(makeAPaymentProfile,strAccountType)
       .enterDetailsToMakeAPayment(makeAPaymentProfile)
       .ConfirmSecurityCheck(makeAPaymentProfile);
    }
    
    //Mandatory : DD Customer with JI Account
    @Test(groups = {Regression,MakeAPayment})
    public void verifyPaymentForDDJIAccountVisaDebit() throws Exception {
        Report.createTestLogHeader("", "");
    
        String strAccountType = "Direct Debit-JIAccount";
        MakeAPaymentProfile makeAPaymentProfile = new TestDataHelper().getMakeAPaymentProfile("DDJIAccountForVisaDebit");
    
       Thread.sleep(4000);     
       
       new MakeAPaymentAction().loginMakeAPayment(makeAPaymentProfile,strAccountType)
       .navigateToMakeAPayment(makeAPaymentProfile,strAccountType)
       .selectAccountToMakeAPayment(makeAPaymentProfile,strAccountType)
       .enterDetailsToMakeAPayment(makeAPaymentProfile)
       .ConfirmSecurityCheck(makeAPaymentProfile);
    }
    
    
    @Test(groups = {MakeAPayment})
    public void verifyPaymentForDualAccountVisaDebit() throws Exception {
        Report.createTestLogHeader("", "");
        
        String strAccountType = "DualAccount";
        MakeAPaymentProfile makeAPaymentProfile = new TestDataHelper().getMakeAPaymentProfile("DualAccountForVisaDebit");
             
       Thread.sleep(4000);     
       
       new MakeAPaymentAction().loginMakeAPayment(makeAPaymentProfile,strAccountType)
       .navigateToMakeAPayment(makeAPaymentProfile,strAccountType)
       .selectAccountToMakeAPayment(makeAPaymentProfile,strAccountType)
       .enterDetailsToMakeAPayment(makeAPaymentProfile)
       .ConfirmSecurityCheck(makeAPaymentProfile);
    }
    
    @Test(groups = {MakeAPayment,Regression})
    public void verifyPaymentForGasMastercard() throws Exception {
        Report.createTestLogHeader("", "");
        
        String strAccountType = "GasAccount";
        MakeAPaymentProfile makeAPaymentProfile = new TestDataHelper().getMakeAPaymentProfile("GasAccountForMastercard");
             
       Thread.sleep(4000);     
       
       new MakeAPaymentAction().loginMakeAPayment(makeAPaymentProfile,strAccountType)
       .navigateToMakeAPayment(makeAPaymentProfile,strAccountType)
       .selectAccountToMakeAPayment(makeAPaymentProfile,strAccountType)
       .enterDetailsToMakeAPayment(makeAPaymentProfile)
       .ConfirmSecurityCheck(makeAPaymentProfile);       
    }
    
    
    
    @Test(groups = {MakeAPayment,Regression})
    public void verifyPaymentForElectricityMastercard() throws Exception {
        Report.createTestLogHeader("", "");
        
        String strAccountType = "ElectricityAccount";
        MakeAPaymentProfile makeAPaymentProfile = new TestDataHelper().getMakeAPaymentProfile("ElectricityAccountForMastercard");
             
       Thread.sleep(4000);     
       
       new MakeAPaymentAction().loginMakeAPayment(makeAPaymentProfile,strAccountType)
       .navigateToMakeAPayment(makeAPaymentProfile,strAccountType)
       .selectAccountToMakeAPayment(makeAPaymentProfile,strAccountType)
       .enterDetailsToMakeAPayment(makeAPaymentProfile)
       .ConfirmSecurityCheck(makeAPaymentProfile);
       
    }
    
    
    
    @Test(groups = {Regression,MakeAPayment})
    public void verifyPaymentForJIAccountMastercard() throws Exception {
        Report.createTestLogHeader("", "");
        
        String strAccountType = "JIAccount";
        MakeAPaymentProfile makeAPaymentProfile = new TestDataHelper().getMakeAPaymentProfile("JIAccountForMastercard");
             
       Thread.sleep(4000);     
       
       new MakeAPaymentAction().loginMakeAPayment(makeAPaymentProfile,strAccountType)
       .navigateToMakeAPayment(makeAPaymentProfile,strAccountType)
       .selectAccountToMakeAPayment(makeAPaymentProfile,strAccountType)
       .enterDetailsToMakeAPayment(makeAPaymentProfile)
       .ConfirmSecurityCheck(makeAPaymentProfile);
    }
    
    //Madatory : DD Cutsomer with JI Account
    @Test(groups = {Regression,MakeAPayment})
    public void verifyPaymentForDDJIAccountMastercard() throws Exception {
        Report.createTestLogHeader("", "");
    
        String strAccountType = "Direct Debit-JIAccount";
        MakeAPaymentProfile makeAPaymentProfile = new TestDataHelper().getMakeAPaymentProfile("DDJIAccountForMastercard");
    
       Thread.sleep(4000);     
       
       new MakeAPaymentAction().loginMakeAPayment(makeAPaymentProfile,strAccountType)
       .navigateToMakeAPayment(makeAPaymentProfile,strAccountType)
       .selectAccountToMakeAPayment(makeAPaymentProfile,strAccountType)
       .enterDetailsToMakeAPayment(makeAPaymentProfile)
       .ConfirmSecurityCheck(makeAPaymentProfile);
    }
    
    
    
    @Test(groups = {MakeAPayment})
    public void verifyPaymentForDualAccountMastercard() throws Exception {
        Report.createTestLogHeader("", "");
        
        String strAccountType = "DualAccount";
        MakeAPaymentProfile makeAPaymentProfile = new TestDataHelper().getMakeAPaymentProfile("DualAccountForMastercard");
             
       Thread.sleep(4000);     
       
       new MakeAPaymentAction().loginMakeAPayment(makeAPaymentProfile,strAccountType)
       .navigateToMakeAPayment(makeAPaymentProfile,strAccountType)
       .selectAccountToMakeAPayment(makeAPaymentProfile,strAccountType)
       .enterDetailsToMakeAPayment(makeAPaymentProfile)
       .ConfirmSecurityCheck(makeAPaymentProfile);
    }
    
    @Test(groups = {Regression,MakeAPayment})
    public void verifyPaymentForGasMaestro() throws Exception {
        Report.createTestLogHeader("", "");
        
        String strAccountType = "GasAccount";
        MakeAPaymentProfile makeAPaymentProfile = new TestDataHelper().getMakeAPaymentProfile("GasAccountForMaestro");
             
       Thread.sleep(4000);     
       
       new MakeAPaymentAction().loginMakeAPayment(makeAPaymentProfile,strAccountType)
       .navigateToMakeAPayment(makeAPaymentProfile,strAccountType)
       .selectAccountToMakeAPayment(makeAPaymentProfile,strAccountType)
       .enterDetailsToMakeAPayment(makeAPaymentProfile)
       .ConfirmSecurityCheck(makeAPaymentProfile);       
    }
    
    
    
    @Test(groups = {Regression,MakeAPayment})
    public void verifyPaymentForElectricityMaestro() throws Exception {
        Report.createTestLogHeader("", "");
        
        String strAccountType = "ElectricityAccount";
        MakeAPaymentProfile makeAPaymentProfile = new TestDataHelper().getMakeAPaymentProfile("ElectricityAccountForMaestro");
             
       Thread.sleep(4000);     
       
       new MakeAPaymentAction().loginMakeAPayment(makeAPaymentProfile,strAccountType)
       .navigateToMakeAPayment(makeAPaymentProfile,strAccountType)
       .selectAccountToMakeAPayment(makeAPaymentProfile,strAccountType)
       .enterDetailsToMakeAPayment(makeAPaymentProfile)
       .ConfirmSecurityCheck(makeAPaymentProfile);
       
    }
    
    
    
    @Test(groups = {Regression,MakeAPayment})
    public void verifyPaymentForJIAccountMaestro() throws Exception {
        Report.createTestLogHeader("", "");
        
        String strAccountType = "JIAccount";
        MakeAPaymentProfile makeAPaymentProfile = new TestDataHelper().getMakeAPaymentProfile("JIAccountForMaestro");
             
       Thread.sleep(4000);     
       
       new MakeAPaymentAction().loginMakeAPayment(makeAPaymentProfile,strAccountType)
       .navigateToMakeAPayment(makeAPaymentProfile,strAccountType)
       .selectAccountToMakeAPayment(makeAPaymentProfile,strAccountType)
       .enterDetailsToMakeAPayment(makeAPaymentProfile)
       .ConfirmSecurityCheck(makeAPaymentProfile);
    }
    
  //Madatory : DD Cutsomer with JI Account
    @Test(groups = {Regression,MakeAPayment})
    public void verifyPaymentForDDJIAccountMaestro() throws Exception {
        Report.createTestLogHeader("", "");
    
        String strAccountType = "Direct Debit-JIAccount";
        MakeAPaymentProfile makeAPaymentProfile = new TestDataHelper().getMakeAPaymentProfile("DDJIAccountForMaestro");
    
       Thread.sleep(4000);     
       
       new MakeAPaymentAction().loginMakeAPayment(makeAPaymentProfile,strAccountType)
       .navigateToMakeAPayment(makeAPaymentProfile,strAccountType)
       .selectAccountToMakeAPayment(makeAPaymentProfile,strAccountType)
       .enterDetailsToMakeAPayment(makeAPaymentProfile)
       .ConfirmSecurityCheck(makeAPaymentProfile);
    }
    
    @Test(groups = {MakeAPayment})
    public void verifyPaymentForDualAccountMaestro() throws Exception {
        Report.createTestLogHeader("", "");
        
        String strAccountType = "DualAccount";
        MakeAPaymentProfile makeAPaymentProfile = new TestDataHelper().getMakeAPaymentProfile("DualAccountForMaestro");
             
       Thread.sleep(4000);     
       
       new MakeAPaymentAction().loginMakeAPayment(makeAPaymentProfile,strAccountType)
       .navigateToMakeAPayment(makeAPaymentProfile,strAccountType)
       .selectAccountToMakeAPayment(makeAPaymentProfile,strAccountType)
       .enterDetailsToMakeAPayment(makeAPaymentProfile)
       .ConfirmSecurityCheck(makeAPaymentProfile);
    }

}
