package bg.framework.app.functional.test.selfServe;

import static bg.framework.app.functional.entities.FunctionalCategory.MakeAPayment;
import static bg.framework.app.functional.entities.FunctionalCategory.Regression;

import javax.sql.DataSource;

import bg.framework.app.functional.action.common.HomePageAction;
import static bg.framework.app.functional.entities.FunctionalCategory.RefactoringMakeAPayment;
import bg.framework.app.functional.action.selfServe.CQMakeAPaymentAction;
import bg.framework.app.functional.action.selfServe.CQSMRPageAction;
import bg.framework.app.functional.action.selfServe.SMRAction;
import bg.framework.app.functional.entities.MakeAPaymentProfile;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.RunQTP;
import bg.framework.app.functional.util.TestDataHelper;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.testng.annotations.Test;

public class CQMakeAPaymentTest extends TestBase {
	
	 @Test(groups = {RefactoringMakeAPayment})
	public void MakeAPayment_EnergyAccountMaestro(){
	
	Report.createTestLogHeader("Make A Payment", "EnergyAccountForMaestro");
	MakeAPaymentProfile makeAPaymentProfile = new TestDataHelper().getMakeAPaymentProfile("EnergyAccountForMaestro");
	new CQMakeAPaymentAction().navigateToLoginPageMAP().loginUser(makeAPaymentProfile).navigateToMAPPage().SelectAccount(makeAPaymentProfile).ClickonContinue().EnterAmount().EnterCardDetails(makeAPaymentProfile).ClickonContinue().Verify3DSecurePage(makeAPaymentProfile).VerifyConfirmationLastCheck(makeAPaymentProfile);
		
	}
	 
	@Test(groups = {RefactoringMakeAPayment})
		public void MakeAPayment_ElectricityAccountVisaDebit(){
		
		Report.createTestLogHeader("Make A Payment", "ElectricityAccountForVisaDebit");
		MakeAPaymentProfile makeAPaymentProfile = new TestDataHelper().getMakeAPaymentProfile("ElectricityAccountForVisaDebit");
		new CQMakeAPaymentAction().navigateToLoginPageMAP().loginUser(makeAPaymentProfile).navigateToMAPPage().SelectAccount(makeAPaymentProfile).ClickonContinue().EnterAmount().EnterCardDetails(makeAPaymentProfile).ClickonContinue().VerifyCardConfirmation(makeAPaymentProfile).VerifyConfirmationLastCheck(makeAPaymentProfile);
			
	}
	
	
	 @Test(groups = {RefactoringMakeAPayment})
		public void MakeAPayment_GasAccountForMaestro(){		
		
		Report.createTestLogHeader("Make A Payment", "GasAccountForMaestro");
		MakeAPaymentProfile makeAPaymentProfile = new TestDataHelper().getMakeAPaymentProfile("GasAccountForMastercard");
		new CQMakeAPaymentAction().navigateToLoginPageMAP().loginUser(makeAPaymentProfile).navigateToMAPPage().SelectAccount(makeAPaymentProfile).ClickonContinue().EnterAmount().EnterCardDetails(makeAPaymentProfile).ClickonContinue().Verify3DSecurePage(makeAPaymentProfile).VerifyConfirmationLastCheck(makeAPaymentProfile);
				
		}
	 
	 @Test(groups = {RefactoringMakeAPayment})
		public void MakeAPayment_DualFuelAccountForVisaDebit(){
		
		 Report.createTestLogHeader("Make A Payment", "DualFuelAccountForVisaDebit");
			MakeAPaymentProfile makeAPaymentProfile = new TestDataHelper().getMakeAPaymentProfile("DualFuelAccountForVisaDebit");
			new CQMakeAPaymentAction().navigateToLoginPageMAP().loginUser(makeAPaymentProfile).navigateToMAPPage().SelectAccount(makeAPaymentProfile).ClickonContinue().EnterAmount().EnterCardDetails(makeAPaymentProfile).ClickonContinue().VerifyCardConfirmation(makeAPaymentProfile).VerifyConfirmationLastCheck(makeAPaymentProfile);
			
		}
	 
	 @Test(groups = {RefactoringMakeAPayment})
		public void MakeAPayment_ElectricityAccountMasterCard(){
		
		Report.createTestLogHeader("Make A Payment", "ElectricityAccountForMastercard");
		MakeAPaymentProfile makeAPaymentProfile = new TestDataHelper().getMakeAPaymentProfile("ElectricityAccountForMastercard");
		new CQMakeAPaymentAction().navigateToLoginPageMAP().loginUser(makeAPaymentProfile).navigateToMAPPage().SelectAccount(makeAPaymentProfile).ClickonContinue().EnterAmount().EnterCardDetails(makeAPaymentProfile).ClickonContinue().Verify3DSecurePage(makeAPaymentProfile).VerifyConfirmationLastCheck(makeAPaymentProfile);
			
		}  
	 
	 

}
