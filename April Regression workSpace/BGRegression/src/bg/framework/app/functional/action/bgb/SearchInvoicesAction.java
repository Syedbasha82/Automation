package bg.framework.app.functional.action.bgb;

import java.awt.AWTException;
import bg.framework.app.functional.entities.GetAQuoteDetails;
import bg.framework.app.functional.entities.RegistrationProfile;
import bg.framework.app.functional.page.bgb.SearchInvoicesPage;
import com.gnostice.pdfone.PdfException;


public class SearchInvoicesAction {

    private RegistrationProfile registrationProfile;

    public SearchInvoicesAction() {
    }

    public SearchInvoicesAction(RegistrationProfile registrationProfile) {
        this.registrationProfile = registrationProfile;
        
    }

    public SearchInvoicesAction enterAllSearchDetailsAction() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.verifyCopyInvoices();
        searchInvoicesPage.verifySearchCriteriaDropDown();
        searchInvoicesPage.enterDetailsSearchInvoices();
        searchInvoicesPage.clickOnSearch();
        return new SearchInvoicesAction();
    }
    
    public SearchInvoicesAction accountManagerInvaliddataTest(int i) {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.accountManagerInvaliddataTest(i);
        return new SearchInvoicesAction();
    }
    
    public SearchInvoicesAction accountManagerInvaliddataTestNew(int i) {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.accountManagerInvaliddataTestNew(i);
        return new SearchInvoicesAction();
    }
    
    public SearchInvoicesAction enterDiffSearchDetailsAction(final int iteration) {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        //searchInvoicesPage.verifyCopyInvoices();
        searchInvoicesPage.enterDiffSearchDetailsPage(iteration);
        return new SearchInvoicesAction(registrationProfile);
    }

    public SearchInvoicesAction enterSearchDetailsAction(final int iteration) {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        //searchInvoicesPage.verifyCopyInvoices();
        searchInvoicesPage.enterSearchDetailsPage(iteration);
        return new SearchInvoicesAction(registrationProfile);
    }

    public SearchInvoicesAction verifyResultsAction() {
        SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.verifyResults();
        return new SearchInvoicesAction(registrationProfile);
    }

    public SearchInvoicesAction verifyErrorAction(final int iteration) {
        SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.verifyInvoiceErrorMsg(iteration);
        return new SearchInvoicesAction(registrationProfile);
    }

    public SearchInvoicesAction verifyErrorInvTextAction() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.verifyErrorMsgSearchText();
        //searchInvoicesPage.verifyAndClickWithName("", "");
        return new SearchInvoicesAction(registrationProfile);
    }

    public SearchInvoicesAction validateSearchbyAccNoAction(final int iteration) {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.enterMinMaxSearchAccNo(iteration);
        return new SearchInvoicesAction();
    }
    
    public SearchInvoicesAction validateSearchbySiteNoAction(final int iteration) {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.enterMinMaxSearchSiteNo(iteration);
        return new SearchInvoicesAction();
    }
   
    public SearchInvoicesAction validateSearchbyInvoiceNoAction(final int iteration) {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.enterMinMaxSearchInvoiceNo(iteration);
        return new SearchInvoicesAction();
    }

    public SearchInvoicesAction searchByCustomerNameAction() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.searchCustomerNameWildCard();
        return this;
    }

    public SearchInvoicesAction refindSearchWithDateAction() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        final String tableSearchText = searchInvoicesPage.getTableSearchText();
        searchInvoicesPage.refindSearchDatePage(tableSearchText);
        return this;

    }

    public SearchInvoicesAction selectAllClickAction() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.clickSelectAllCheckBox();
        return this;
    }

    public SearchInvoicesAction verifyRefineAction() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.verifyRefineText();
        return this;
    }

    public SearchInvoicesAction verifyPagingAction() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.verifyPaging();
        return this;
    }

    public SearchInvoicesAction downLoadPDFAction() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.clickSelectCheckBox();
        searchInvoicesPage.clickDownloadPDF();
        //searchInvoicesPage.verifyErrorMsgSelect();
       // searchInvoicesPage.clickSelectCheckBox();
       // searchInvoicesPage.clickDownloadPDF();
        return this;
    }
    
    public SearchInvoicesAction pdfdownloadAndRead() throws AWTException {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.pdfDownloadAndRead();
        return this;
    }
    
    public SearchInvoicesAction dbValidationACcountManager() throws AWTException {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.dbValidationACcountManager();
        return this;
    }
    
    public void dateValidationAction() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.validateDate();
    }
    
    public SearchInvoicesAction validateDateNew() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.validateDateNew();
        return this;
    }

    public SearchInvoicesAction refinedDatevalidation() {
    final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
    searchInvoicesPage.refinedDatevalidation();
    return this;
}
    
    public SearchInvoicesAction validateInvalidDateNew() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.validateInvalidDateNew();
        return this;
    }
    
    public SearchInvoicesAction monthAndDateChange() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.monthanddatechange();
        return this;
    }
    
    public SearchInvoicesAction accountManagerDetails() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.accountmanagerdetails();
        return this;
    }
    
    public SearchInvoicesAction systemError() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.systemError();
        return this;
    }
    
    public SearchInvoicesAction searchAccnoCusNameContractNo(int j) {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.searchAccnoCusNameContractNo(j);
        return this;
    }
   
    public SearchInvoicesAction searchAccNoCusNameContractNoRefined(int j) {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.searchAccNoCusNameContractNoRefined(j);
        return this;
    }
    
    public SearchInvoicesAction tableHeaderCheckAccountManager() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.tableHeaderCheckAccountManager();
        return this;
    }
    
    public SearchInvoicesAction searchAccNoAccountManager() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.searchAccNoAccountManager();
        return this;
    }
    
    public SearchInvoicesAction searchAccNoCusnameContarctnoAccountManager(int i) {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.searchAccNoCusnameContarctnoAccountManager(i);
        return this;
    }
    
    public SearchInvoicesAction signonsuccessFailure() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.signonsuccessFailure();
        return this;
    }
    
    public SearchInvoicesAction searchContractNoAccountManager() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.searchContractNoAccountManager();
        return this;
    }
    
    public SearchInvoicesAction searchCusNameAccountManager() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.searchCusNameAccountManager();
        return this;
    }
    
    public SearchInvoicesAction readOnlyProfilePage() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.readOnlyProfilePage();
        return this;
    }
    
    public SearchInvoicesAction dbValidationForNormalUser() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.dbValidationForNormalUser();
        return this;
    }
    
    public SearchInvoicesAction dbValidationForSuperUser() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.dbValidationForSuperUser();
        return this;
    }
    
    public SearchInvoicesAction tableContentEmpty() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.tableContentEmpty();
        return this;
    }
    
    public SearchInvoicesAction hideFieldValidation() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.hideFieldValidation();
        return this;
    }
    
    public SearchInvoicesAction contentValidation() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.contentValidation();
        return this;
    }
    
    public SearchInvoicesAction pageNavigationUsingButton() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.pageNavigationUsingButton();
        return this;
    }
    
    public SearchInvoicesAction pageNavigationUsingLink() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.pageNavigationUsingLink();
        return this;
    }
    
    public SearchInvoicesAction accountSearchValidate() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.accountSearchValidate();
        return this;
    }
    
    public SearchInvoicesAction customerNameSearchValidate() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.customerNameSearchValidate();
        return this;
    }
    
    public SearchInvoicesAction customerNamePartialSearchValidate() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.customerNamePartialSearchValidate();
        return this;
    }
    
    public SearchInvoicesAction downLoadAction() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        String testPath = searchInvoicesPage.downloadInvoicePage();
        try {
            searchInvoicesPage.verifyPdfInvoice(testPath);
        } catch (PdfException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new SearchInvoicesAction();
    }

    public void verifyDownloadPDFAction() {
        final SearchInvoicesPage searchInvoicesPage = new SearchInvoicesPage(registrationProfile);
        searchInvoicesPage.verifyDownloadPDFError();
    }

}
