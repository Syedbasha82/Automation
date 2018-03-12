package bg.framework.app.functional.test.bgb;

import bg.framework.app.functional.action.bgb.LoginMultiSiteAction;
import bg.framework.app.functional.action.bgb.SearchInvoicesAction;
import bg.framework.app.functional.entities.RegistrationProfile;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;
import org.testng.annotations.Test;

import static bg.framework.app.functional.entities.FunctionalCategory.RegresBGBMS;

public class SearchInvoicesTest extends TestBase {
	/*
	 * Method :SearchInvoicesEndtoEnd Description:This test is to verify whether
	 * end to end SearchInvoices journye works fine
	 */
	@SuppressWarnings("unchecked")
	// @Test(groups = {RegresBGBMS})
	public void searchInvoicesEndtoEnd() {
		Report.createTestLogHeader("BGB SearchInvoices",
		        "Multisite SearchInvoices End to End");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("searchbyaccno");
		new LoginMultiSiteAction(registrationProfile).login();
		new SearchInvoicesAction(registrationProfile).enterAllSearchDetailsAction()
		        .verifyResultsAction();
		new LoginMultiSiteAction(registrationProfile).clickLogoutAction();

	}

	/*
	 * Method :SearchInvoicesByAccno Description:This test is to verify whether
	 * end to end SearchInvoices journey works fine foe account no search
	 */
	@SuppressWarnings("unchecked")
//	@Test(groups = { RegresBGBMS })
	public void searchInvoicesByAccno() {

		Report.createTestLogHeader("BGB SearchInvoices",
		        "Multisite SearchInvoices by Account Number");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("searchbyaccno");
		new LoginMultiSiteAction(registrationProfile).login();
		new SearchInvoicesAction(registrationProfile)
		// .enterDiffSearchDetailsAction(0)
		// .verifyResultsAction()
		// .enterDiffSearchDetailsAction(1)
		// .verifyResultsAction()
		// .enterDiffSearchDetailsAction(2)
		// .verifyResultsAction()
		// .enterDiffSearchDetailsAction(3)
		// .verifyResultsAction()
		// .validateSearchbyAccNoAction(0)
		/*
		 * .verifyResultsAction().validateSearchbyAccNoAction(1)
		 * .verifyResultsAction()
		 */;

		new LoginMultiSiteAction(registrationProfile).clickLogoutAction();
	}

	@SuppressWarnings("unchecked")
	// @Test(groups = {RegresBGBMS})
	public void searchInvoicesByAccnoRefind() {
		Report.createTestLogHeader("BGB SearchInvoices",
		        "Multisite SearchInvoices by Account Number Refined");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("searchbyaccno");
		new LoginMultiSiteAction(registrationProfile).login();
		new SearchInvoicesAction(registrationProfile).refindSearchWithDateAction();
		new LoginMultiSiteAction().clickLogoutAction();

	}

	@SuppressWarnings("unchecked")
	// @Test(groups = {RegresBGBMS})
	public void searchInvoicesByCustomernoRefind() {
		Report.createTestLogHeader("BGB SearchInvoices",
		        "Multisite SearchInvoices by Customer Number Refined");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("searchbycustno");
		new LoginMultiSiteAction(registrationProfile).login();
		new SearchInvoicesAction(registrationProfile).refindSearchWithDateAction();
		new LoginMultiSiteAction().clickLogoutAction();

	}

	@SuppressWarnings("unchecked")
	// @Test(groups = {RegresBGBMS})
	public void searchInvoicesByInvoicenoRefind() {
		Report.createTestLogHeader("BGB SearchInvoices",
		        "Multisite SearchInvoices by Invoice Number Refined");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("searchbyinvoicenowithrevision");
		new LoginMultiSiteAction(registrationProfile).login();
		new SearchInvoicesAction(registrationProfile).refindSearchWithDateAction();
		new LoginMultiSiteAction(registrationProfile).clickLogoutAction();

	}

	@SuppressWarnings("unchecked")
	// @Test(groups = {RegresBGBMS})
	public void searchInvoicesBySitenoRefind() {
		Report.createTestLogHeader("BGB SearchInvoices",
		        "Multisite SearchInvoices by Site Number Refined");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("searchbysiteno");
		new LoginMultiSiteAction(registrationProfile).login();
		new SearchInvoicesAction(registrationProfile).refindSearchWithDateAction();
		new LoginMultiSiteAction(registrationProfile).clickLogoutAction();

	}

	@SuppressWarnings("unchecked")
	// @Test(groups = {RegresBGBMS})
	public void searchInvoicesByMpannoRefind() {
		Report.createTestLogHeader("BGB SearchInvoices",
		        "Multisite SearchInvoices by Mpan Number Refined");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("searchbympanno");
		new LoginMultiSiteAction(registrationProfile).login();
		new SearchInvoicesAction(registrationProfile).refindSearchWithDateAction();
		new LoginMultiSiteAction().clickLogoutAction();

	}

	@SuppressWarnings("unchecked")
	// @Test(groups = {RegresBGBMS})
	public void searchInvoicesByContractnoRefind() {
		Report.createTestLogHeader("BGB SearchInvoices",
		        "Multisite SearchInvoices by Contract Number Refined");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("searchbycontractno");
		new LoginMultiSiteAction(registrationProfile).login();
		new SearchInvoicesAction(registrationProfile).refindSearchWithDateAction();
		new LoginMultiSiteAction().clickLogoutAction();

	}

	@SuppressWarnings("unchecked")
	// @Test(groups = {RegresBGBMS})
	public void searchInvoicesByMprnoRefind() {
		Report.createTestLogHeader("BGB SearchInvoices",
		        "Multisite SearchInvoices by Mpr Number Refined");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("searchbymprno");
		new LoginMultiSiteAction(registrationProfile).login();
		new SearchInvoicesAction(registrationProfile).refindSearchWithDateAction();
		new LoginMultiSiteAction().clickLogoutAction();

	}

	@SuppressWarnings("unchecked")
	// @Test(groups = {RegresBGBMS})
	public void searchInvoicesByCustomerNameRefind() {
		Report.createTestLogHeader("BGB SearchInvoices",
		        "Multisite SearchInvoices by Customer Name refined");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("searchbycustname");
		new LoginMultiSiteAction(registrationProfile).login();
		new SearchInvoicesAction(registrationProfile).refindSearchWithDateAction();
		new LoginMultiSiteAction().clickLogoutAction();

	}

	/*
	 * Method :SearchInvoicesByCustno Description:This test is to verify whether
	 * end to end SearchInvoices journey works fine foe account no search
	 */
	@SuppressWarnings("unchecked")
	// @Test(groups = {RegresBGBMS})
	public void searchInvoicesByCustno() {

		Report.createTestLogHeader("BGB SearchInvoices",
		        "Multisite SearchInvoices by Customer no");

		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("searchbycustno");

		new LoginMultiSiteAction(registrationProfile).login();
		new SearchInvoicesAction(registrationProfile).enterDiffSearchDetailsAction(1)
		        .verifyResultsAction().enterDiffSearchDetailsAction(2)
		        .verifyResultsAction().enterDiffSearchDetailsAction(3)
		        .verifyResultsAction().enterDiffSearchDetailsAction(12)
		        .verifyResultsAction();
		new LoginMultiSiteAction(registrationProfile).clickLogoutAction();
	}

	@SuppressWarnings("unchecked")
	// @Test(groups = {RegresBGBMS})
	public void searchInvoicesByCustomerNameWildCard() {
		Report.createTestLogHeader("BGB SearchInvoices",
		        "Multisite SearchInvoices by customer name wild card");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("searchbycustname");
		new LoginMultiSiteAction(registrationProfile).login();
		new SearchInvoicesAction(registrationProfile).searchByCustomerNameAction();
		new LoginMultiSiteAction().clickLogoutAction();
	}

	/*
	 * Method :SearchInvoicesByCustno Description:This test is to verify whether
	 * end to end SearchInvoices journey works fine foe account no search
	 */
	@SuppressWarnings("unchecked")
	// @Test(groups = {RegresBGBMS})
	public void searchInvoicesByInvoiceno() {
		Report.createTestLogHeader("BGB SearchInvoices",
		        "Multisite SearchInvoices by Invoice No.");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("searchbyinvoicenowithrevision");
		new LoginMultiSiteAction(registrationProfile).login();
		new SearchInvoicesAction(registrationProfile).enterDiffSearchDetailsAction(1)
		        .verifyResultsAction().enterDiffSearchDetailsAction(2)
		        .verifyResultsAction().enterDiffSearchDetailsAction(3)
		        .verifyResultsAction().enterDiffSearchDetailsAction(4)
		        .verifyResultsAction().enterDiffSearchDetailsAction(5)
		        .verifyResultsAction().enterDiffSearchDetailsAction(6)
		        .verifyResultsAction().enterDiffSearchDetailsAction(7)
		        .verifyResultsAction();
		new LoginMultiSiteAction(registrationProfile).clickLogoutAction();

	}

	/*
	 * Method :SearchInvoicesBySiteno Description:This test is to verify whether
	 * end to end SearchInvoices journey works fine foe account no search
	 */
	@SuppressWarnings("unchecked")
	// @Test(groups = {RegresBGBMS})
	public void searchInvoicesBySiteno() {
		Report.createTestLogHeader("BGB SearchInvoices",
		        "Multisite SearchInvoices by Site No");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("searchbysiteno");
		new LoginMultiSiteAction(registrationProfile).login();
		new SearchInvoicesAction(registrationProfile).enterDiffSearchDetailsAction(1)
		        .verifyResultsAction().enterDiffSearchDetailsAction(2)
		        .verifyResultsAction().enterDiffSearchDetailsAction(3)
		        .verifyResultsAction().enterDiffSearchDetailsAction(7)
		        .verifyResultsAction().enterDiffSearchDetailsAction(11)
		        .verifyResultsAction();
		new LoginMultiSiteAction(registrationProfile).clickLogoutAction();

	}

	/*
	 * Method :SearchInvoicesByMpanno Description:This test is to verify whether
	 * end to end SearchInvoices journey works fine foe account no search
	 */
	@SuppressWarnings("unchecked")
	// @Test(groups = {RegresBGBMS})
	public void searchInvoicesByMpanno() {
		Report.createTestLogHeader("BGB SearchInvoices",
		        "Multisite SearchInvoices by MPAN No");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("searchbympanno");
		new LoginMultiSiteAction(registrationProfile).login();
		new SearchInvoicesAction(registrationProfile).enterDiffSearchDetailsAction(1)
		        .verifyResultsAction().enterDiffSearchDetailsAction(2)
		        .verifyResultsAction().enterDiffSearchDetailsAction(3)
		        .verifyResultsAction().enterDiffSearchDetailsAction(10)
		        .verifyResultsAction();
		new LoginMultiSiteAction().clickLogoutAction();

	}

	/*
	 * Method :SearchInvoicesByContractno Description:This test is to verify
	 * whether end to end SearchInvoices journey works fine foe account no
	 * search
	 */
	@SuppressWarnings("unchecked")
	// @Test(groups = {RegresBGBMS})
	public void searchInvoicesByContractno() {
		// Report report = new Report();
		String logPath = null;

		Report.createTestLogHeader("BGB SearchInvoices",
		        "Multisite SearchInvoices by Contract No");

		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("searchbycontractno");
		// RegistrationAction regAction = new
		// RegistrationAction(registrationProfile, stubServiceResponses);
		new LoginMultiSiteAction(registrationProfile).login();
		new SearchInvoicesAction(registrationProfile).enterDiffSearchDetailsAction(1)
		        .verifyResultsAction().enterDiffSearchDetailsAction(2)
		        .verifyResultsAction().enterDiffSearchDetailsAction(3)
		        .verifyResultsAction().enterDiffSearchDetailsAction(7)
		        .verifyResultsAction();
		new LoginMultiSiteAction().clickLogoutAction();

	}

	/*
	 * Method :SearchInvoicesByMpro Description:This test is to verify whether
	 * end to end SearchInvoices journey works fine foe account no search
	 */
	@SuppressWarnings("unchecked")
	// @Test(groups = {RegresBGBMS})
	public void searchInvoicesByMprno() {
		Report.createTestLogHeader("BGB SearchInvoices",
		        "Multisite SearchInvoices by MPR No");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("searchbymprno");
		new LoginMultiSiteAction(registrationProfile).login();
		new SearchInvoicesAction(registrationProfile).enterDiffSearchDetailsAction(1)
		        .verifyResultsAction().enterDiffSearchDetailsAction(2)
		        .verifyResultsAction().enterDiffSearchDetailsAction(3)
		        .verifyResultsAction().enterDiffSearchDetailsAction(5)
		        .verifyResultsAction().enterDiffSearchDetailsAction(7)
		        .verifyResultsAction();
		new LoginMultiSiteAction(registrationProfile).clickLogoutAction();
	}

	/*
	 * Method :SearchInvoicesByCustName Description:This test is to verify
	 * whether end to end SearchInvoices journey works fine foe account no
	 * search
	 */
	@SuppressWarnings("unchecked")
	// @Test(groups = {RegresBGBMS})
	public void searchInvoicesByCustName() {
		Report.createTestLogHeader("BGB SearchInvoices",
		        "Multisite SearchInvoices by Customer Name");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("searchbycustname");
		new LoginMultiSiteAction(registrationProfile).login();
		new SearchInvoicesAction(registrationProfile).enterDiffSearchDetailsAction(8)
		        .verifyErrorInvTextAction().enterDiffSearchDetailsAction(9)
		        .verifyResultsAction().enterDiffSearchDetailsAction(10)
		        .verifyResultsAction();
		new LoginMultiSiteAction(registrationProfile).clickLogoutAction();

	}

	@SuppressWarnings("unchecked")
	// @Test(groups = {RegresBGBMS})
	public void searchInvoicesSelectAllCheck() {
		Report.createTestLogHeader("BGB SearchInvoices",
		        "Multisite SearchInvoices for Select All");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("nopaging");
		new LoginMultiSiteAction(registrationProfile).login();
		new SearchInvoicesAction(registrationProfile).enterAllSearchDetailsAction()
		        .selectAllClickAction().verifyResultsAction();
		new LoginMultiSiteAction(registrationProfile).clickLogoutAction();
	}

	@SuppressWarnings("unchecked")
	// @Test(groups = {RegresBGBMS})
	public void searchInvoicesMany() {
		Report.createTestLogHeader("BGB SearchInvoices", "Multisite SearchInvoices Many");
		RegistrationProfile[] registrationProfile = new RegistrationProfile[2];
		registrationProfile[0] = new TestDataHelper()
		        .getRegistrationProfile("manyInvoice");
		registrationProfile[1] = new TestDataHelper().getRegistrationProfile("noInvoice");
		new LoginMultiSiteAction(registrationProfile[0]).login();
		for (int i = 0; i < 2; i++) {
			new SearchInvoicesAction(registrationProfile[i])
			        .enterAllSearchDetailsAction().verifyResultsAction();
		}
		new LoginMultiSiteAction(registrationProfile[1]).clickLogoutAction();
	}

	@SuppressWarnings("unchecked")
	// @Test(groups = {RegresBGBMS})
	public void searchInvoicesPagination() {
		Report.createTestLogHeader("BGB SearchInvoices",
		        "Multisite searchInvoicesPagination");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("nopaging");
		new LoginMultiSiteAction(registrationProfile).login();
		new SearchInvoicesAction(registrationProfile).enterAllSearchDetailsAction()
		        .verifyPagingAction();
		new LoginMultiSiteAction().clickLogoutAction();

	}

	@SuppressWarnings("unchecked")
	// @Test(groups = {RegresBGBMS})
	public void validateDateField() {
		Report.createTestLogHeader("BGB SearchInvoices",
		        "Multisite SearchInvoices Date Validation");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("datevalidation");
		new LoginMultiSiteAction(registrationProfile).login();
		new SearchInvoicesAction(registrationProfile).dateValidationAction();
	}

	@SuppressWarnings("unchecked")
	// @Test(groups = {RegresBGBMS})
	public void downLoadPDF() {
		Report.createTestLogHeader("BGB SearchInvoices",
		        "Multisite SearchInvoices Download PDF");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("searchbyaccno");
		new LoginMultiSiteAction(registrationProfile).login();
		new SearchInvoicesAction(registrationProfile).enterAllSearchDetailsAction()
		        .verifyResultsAction().downLoadPDFAction().downLoadAction();
		// String testPath = System.getProperty("user.dir");
		// testPath = testPath
		// +"src\\bg\\framework\\app\\functional\\util\\vbsScripts\\openPdf.exe";
		//
		// try {
		//
		// Process Proc = Runtime.getRuntime().exec(testPath);
		//
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

	@SuppressWarnings("unchecked")
	// ////@Test(groups = {RegresBGBMS})
	public void overLayPDF() {
		Report.createTestLogHeader("BGB SearchInvoices",
		        "Multisite SearchInvoices overLayPDF");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("searchbyaccno");
		new LoginMultiSiteAction(registrationProfile).login();
		new SearchInvoicesAction(registrationProfile).enterAllSearchDetailsAction()
		        .verifyDownloadPDFAction();
	}

	/*
	 * Method :VerifyErrMsgsSearchInvoice Description:This test is to verify
	 * error messages in SearchInvoices
	 */
	@SuppressWarnings("unchecked")
	// @Test(groups = {RegresBGBMS})
	public void verifyErrMsgsSearchInvoice() {

		Report.createTestLogHeader("BGB SearchInvoices",
		        "Multisite SearchInvoices Error Messages Verification");
		RegistrationProfile registrationProfile = new TestDataHelper()
		        .getRegistrationProfile("searchbyaccno");
		new LoginMultiSiteAction(registrationProfile).login();
		new SearchInvoicesAction(registrationProfile).enterSearchDetailsAction(0)
		        .verifyErrorAction(0).enterSearchDetailsAction(1).verifyErrorAction(1)
		        .enterSearchDetailsAction(2).verifyErrorAction(2)
		        .enterSearchDetailsAction(3).verifyErrorAction(3)
		        .enterSearchDetailsAction(4).verifyErrorAction(4)
		        .enterSearchDetailsAction(5)
		        .verifyErrorAction(5)
		        .enterSearchDetailsAction(6)
		        .verifyErrorAction(6)
		        .enterSearchDetailsAction(7)
		        .verifyErrorAction(7)
		        // .enterSearchDetailsAction(8)
		        // .verifyErrorAction(8)
		        .enterSearchDetailsAction(9).verifyErrorAction(9)
		        .enterSearchDetailsAction(10).verifyErrorAction(10)
		        .enterSearchDetailsAction(11).verifyErrorAction(11);

		new LoginMultiSiteAction(registrationProfile).clickLogoutAction();
	}
}
