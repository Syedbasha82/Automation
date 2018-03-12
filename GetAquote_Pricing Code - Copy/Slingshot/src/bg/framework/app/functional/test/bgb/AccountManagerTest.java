package bg.framework.app.functional.test.bgb;

import java.awt.AWTException;
import bg.framework.app.functional.action.bgb.SearchInvoicesAction;
import bg.framework.app.functional.entities.FunctionalCategory;
import bg.framework.app.functional.entities.RegistrationProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;
import static bg.framework.app.functional.entities.FunctionalCategory.RegresBGBMS;

public class AccountManagerTest extends TestBase {

	/*
	 * **************************************************************************
	 * Method :fieldValidation Description:This test is to validate the Account
	 * manager journey fields.
	 * ***************************************************
	 */
//	@Test(groups = { RegresBGBMS })
	public void fieldValidation() {
		Report.createTestLogHeader("BGB MultiSite",
		        "BGB MultiSite Field Validation");
		RegistrationProfile registrationProfile = new TestDataHelper()
        .getRegistrationProfile("searchbyaccno");
		// ///EMPTY FIELD VALIDATION////////////
		for (int i = 0; i <= 8; i++) {
		new SearchInvoicesAction(registrationProfile)
					.accountManagerInvaliddataTest(i);
		}
		// ///INVALID DATA VALIDATION////////////
		for (int i = 0; i <= 8; i++) {
		new SearchInvoicesAction(registrationProfile)
					.accountManagerInvaliddataTestNew(i);
		}
	}

	/*
	 * *************************************************************************
	 * Method :validateDateFieldAccountManager Description:This test is to
	 * validate the Account manager journey From and To Date fields.
	 * *************************************************************
	 */
//	 @Test(groups = {FunctionalCategory.RegresBGBMS})

	public void validateDateFieldAccountManager() {
		Report.createTestLogHeader(
				"Date Validation-Account Manager and System error Validation",
		        "Multisite SearchInvoices Date Validation");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("AccountManager");
		new SearchInvoicesAction(registrationProfile)
				.validateDateNew()
				.validateInvalidDateNew()
				.monthAndDateChange()
				.systemError();
	}

	/*
	 * ************************************************************************
	 * Method :searchAccountNumberContent Description:This test is to
	 * validate the Account manager journey --Search Account No with Content
	 * Check Mandatory Fields: File Name:Registration.xml 1) <accountNumber>
	 * *********************************************************************
	 */

//	 @Test(groups = {FunctionalCategory.RegresBGBMS})
	public void searchAccountNumberContent() {
		Report.createTestLogHeader("Valid Account Number Search Content Check",
		        "Multisite SearchInvoices Account No Search By Next link");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("AccountManager");
		new SearchInvoicesAction(registrationProfile)
				.searchAccNoAccountManager()
				.searchAccnoCusNameContractNo(0)
				.tableHeaderCheckAccountManager()
				.contentValidation();
	}

	/*
	 * *************************************************************************
	 * Method :searchCustomerName Description:This test is to validate the
	 * Account manager journey --Search customer name content check Mandatory
	 * Fields: File Name:Registration.xml 1) <firstName></firstName>
	 * *************************************************************
	 */

//	 @Test(groups = {RegresBGBMS})
	public void searchCustomerName() {
		Report.createTestLogHeader("Valid Customer name Search-Content Check",
		        "Multisite SearchInvoices using Customer Name");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("AccountManager");
		new SearchInvoicesAction(registrationProfile)
				.searchCusNameAccountManager()
				.searchAccnoCusNameContractNo(1)
				.tableHeaderCheckAccountManager()
				.contentValidation();
	}

	/*
	 * **************************************************************************
	 * Method :validateCustomerFullName Description:This test is to validate
	 * the Account manager journey --Search customer full name refined Mandatory
	 * Fields: File Name:Registration.xml 1) <firstName></firstName>
	 * **************************************************************
	 */

	// @Test(groups = {FunctionalCategory.RegresBGBMS})
	public void validateCustomerFullName() {
		Report.createTestLogHeader("Validate Customer full name_Refined",
		        "Validate Customer full name_Refined");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("AccountManager");
		new SearchInvoicesAction(registrationProfile)
				.searchCusNameAccountManager()
				.searchAccNoCusNameContractNoRefined(1)
				.tableHeaderCheckAccountManager()
				.customerNameSearchValidate();
	}

	/*
	 * *********************************************************************
	 * Method :validateCustomerNamePartial Description:This test is to
	 * validate the Account manager journey --Search customer partial name
	 * Mandatory Fields: File Name:Registration.xml 1) <searchText>
	 * </searchText>
	 * *************************************************************
	 */

	// @Test(groups = {FunctionalCategory.RegresBGBMS})
	public void validateCustomerNamePartial() {
		Report.createTestLogHeader("Validate Customer name Partial",
		        "Multisite SearchInvoices Validate Customer name Partial");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("AccountManager");
		new SearchInvoicesAction(registrationProfile)
				.searchCusNameAccountManager()
				.searchAccnoCusNameContractNo(2)
				.tableHeaderCheckAccountManager()
				.customerNamePartialSearchValidate();
	}

	/*
	 * ***************************************************************************
	 * Method :contract Description:This test is to validate the Account
	 * manager journey --Search contract number Mandatory Fields: File
	 * Name:Registration.xml 1) <searchCriteria> </searchCriteria>
	 * ***********************************************************
	 */
	// @Test(groups = {FunctionalCategory.RegresBGBMS})

	public void contract() {
		Report.createTestLogHeader("Validate Contract Number",
		        "Multisite SearchInvoices Date Validation");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("AccountManager");
		new SearchInvoicesAction(registrationProfile)
				.searchContractNoAccountManager()
				.searchAccnoCusNameContractNo(3)
				.tableHeaderCheckAccountManager()
				.contentValidation();
	}

	/*
	 * ***************************************************************************
	 * Method :contractRefined Description:This test is to validate the
	 * Account manager journey --Search contract number refined Mandatory
	 * Fields: File Name:Registration.xml 1) <searchCriteria> </searchCriteria>
	 * ************************************************************************
	 */

	// @Test(groups = {FunctionalCategory.RegresBGBMS})
	public void contractRefined() {
		Report.createTestLogHeader("Validate Contract Number_Refined Search",
		        "Multisite SearchInvoices Date Validation Refined Search");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("AccountManager");
		new SearchInvoicesAction(registrationProfile)
				.searchContractNoAccountManager()
				.searchAccNoCusNameContractNoRefined(3)
				.tableHeaderCheckAccountManager()
				.contentValidation();
	}

	/*
	 * ***********************************************************************
	 * Method :readOnlyProfilePage Description:This test is to validate the
	 * Account manager journey --validate profile page Read only
	 * *********************************************************
	 */

	// @Test(groups = {FunctionalCategory.RegresBGBMS})

	public void readOnlyProfilePage() {
		Report.createTestLogHeader("Profile Page should be Readable",
		        "Multisite SearchInvoices Date Validation");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("AccountManager");
		new SearchInvoicesAction(registrationProfile)
				.readOnlyProfilePage()
				.tableContentEmpty()
				.hideFieldValidation()
				.accountManagerDetails();
	}

	/*
	 * *************************************************************************
	 * Method :accountNumberSearchPageNavigationButton Description:This test
	 * is to validate the Account manager journey --validate button
	 * (Pre-condition -Applicable only for max 10 pages only....If its >10 then it wont work)
	 * Mandatory Fields:
	 * File Name:Registration.xml 1) <accountNumber> </accountNumber> 2)
	 * <firstName> </firstName> 3) <searchText> </searchText> 4)
	 * <searchCriteria> </searchCriteria>
	 * **********************************************************************
	 */

	// @Test(groups = {FunctionalCategory.RegresBGBMS})
	public void accountNumberSearchPageNavigationButton() {
		Report.createTestLogHeader("AccountNumberSearch_PageNavigation_Button",
		        "Button Validation");
		for (int i = 0; i <= 3; i++) {
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("AccountManager");
		new SearchInvoicesAction(registrationProfile)
					.searchAccNoCusnameContarctnoAccountManager(i)
					.searchAccnoCusNameContractNo(i)
					.tableHeaderCheckAccountManager()
					.pageNavigationUsingButton();
		}
	}

	/*
	 * ****************************************************************************
	 * Method :accountNumberSearchPageNavigationLink Description:This test is
	 * to validate the Account manager journey --validate next and previous link
	 * Mandatory Fields: File Name:Registration.xml 1) <accountNumber>
	 * </accountNumber> 2) <firstName> </firstName> 3) <searchText>
	 * </searchText> 4) <searchCriteria> </searchCriteria>
	 * ***************************************************
	 */

	// @Test(groups = {FunctionalCategory.RegresBGBMS})

	public void accountNumberSearchPageNavigationLink() {
		Report.createTestLogHeader("AccountNumberSearch_PageNavigation_Link",
		        "Preview and Next Link Validation");
		for (int i = 0; i <= 3; i++) {
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("AccountManager");
		new SearchInvoicesAction(registrationProfile)
					.searchAccNoCusnameContarctnoAccountManager(i)
					.searchAccnoCusNameContractNo(i)
					.tableHeaderCheckAccountManager()
					.pageNavigationUsingLink();
		}
	}

	/*
	 * **************************************************************************
	 * Method :signOnSuccessFailure Description:ACcount manager journey-Sign on
	 * success and sign On failure
	 * ***************************************************************
	 */

	// @Test(groups = {FunctionalCategory.RegresBGBMS})

	public void signOnSuccessFailure() {
		Report.createTestLogHeader(
				"AccountNumberSearch_PageNavigation_Link-Sign on Success and failure",
        "Preview and Next Link Validation");
		RegistrationProfile registrationProfile = new TestDataHelper()
		.getRegistrationProfile("AccountManager");
	    new SearchInvoicesAction(registrationProfile)
		.signonsuccessFailure();
	}

	/*
	 * **************************************************************************
	 * Method :dbValidation Description:This test is to validate the Account
	 * manager journey --DB record count Mandatory Fields: File
	 * Name:Registration.xml 1) <accountNumber> </accountNumber> 2) <firstName>
	 * </firstName> 3) <searchText> </searchText> 4) <searchCriteria>
	 * </searchCriteria>
	 * *********************************************************
	 */

//	 @Test(groups = {RegresBGBMS})

	public void dbValidation() throws AWTException   {
		Report.createTestLogHeader(
				"AccountNumberSearch_PageNavigation_Link_DB Count",
				"Preview and Next Link Validation");
		RegistrationProfile registrationProfile = new TestDataHelper()
				.getRegistrationProfile("AccountManager");
		new SearchInvoicesAction(registrationProfile)
				.dbValidationACcountManager();

	}

	/*
	 * ************************************************************************
	 * Method :RefinedDateValidation Description:This test is to validate the
	 * Account manager journey --Refined Search Date Validation Mandatory
	 * Fields: File Name:Registration.xml 1) <accountNumber> </accountNumber> 2)
	 * <firstName> </firstName> 3) <searchText> </searchText> 4)
	 * <searchCriteria> </searchCriteria>
	 * **********************************************************************
	 */

	// @Test(groups = {FunctionalCategory.RegresBGBMS})
	public void refinedDateValidation() throws AWTException {
		Report.createTestLogHeader(
				"Refined search Date validation for Account,CustomerName,COntractNumber",
				"Refined search Date validation for Account,CustomerName,COntractNumber");
		RegistrationProfile registrationProfile = new TestDataHelper()
				.getRegistrationProfile("AccountManager");
		new SearchInvoicesAction(registrationProfile)
				.refinedDatevalidation();

	}
}
