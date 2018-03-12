/*package bg.framework.app.functional.test.bgb;

import bg.framework.app.functional.action.bgb.GetAQuoteAction;
import bg.framework.app.functional.entities.GetAQuoteDetails;
import bg.framework.app.functional.test.common.TestBase;
import bg.framework.app.functional.util.Report;
import bg.framework.app.functional.util.TestDataHelper;

public class GetaquoteDualTest extends TestBase {

    @SuppressWarnings("unchecked")
    //@Test(groups = { GetaQuoteSSNE })
//@Test(groups = { GetaQuoteSSN })
    
      * This Function allows the user to get Dual quote anonymously By choosing
      * Monthly Direct Debit radio button and verifies Quote value
      
    public void dualquoteRbYesPaymentMonthly() {
        Report.createTestLogHeader("Get A Quote-DualQuote-RB Yes-Payment Monthly",
                "AnonymousJourney");
        GetAQuoteDetails getDetails = new TestDataHelper()
                .getallGetAQuoteDetails("gaqdetailsMonthly");
        new GetAQuoteAction()
                .clickDualquoteLink()
                .enterGetaQuoteDetails(getDetails)
                .elecSupplyDetailsYes(getDetails)
                .dualGasSupplyDetailsYes(getDetails)
                .clickCalculateQuoteForDual()
                .selectElectricityPaymentOptionMonthly()
                        // .verifyDualElecGaqrate(getDetails)
                        // .verifyDualGasGaqRate(getDetails)
                .verifyDualDbValue(getDetails).verifyDualElecQuotePageCharge(getDetails)
                .verifyDualGasQuotePageCharge(getDetails).clickMonthlyQuotepageContinue()
                .navigateToGasRbYesSupplypage(getDetails).businessPageDetails(getDetails)
                .paymentPageDetailsMonthly(getDetails).summaryPage(getDetails)
                .thankYouPage().gaqDBLeadVerify(getDetails);

    }

    @SuppressWarnings("unchecked")
//@Test(groups = { GetaQuoteSSN })
    
      * This Function allows the user to get Dual quote anonymously By choosing
      * Quaterly cash cheque radio button and verifies Quote value
      
    public void dualquoteRbYesPaymentQuaterly() {
        Report.createTestLogHeader("Get A Quote-Dual Quote-RB Yes-Payment Quaterly",
                "AnonymousJourney");
        GetAQuoteDetails getDetails = new TestDataHelper()
                .getallGetAQuoteDetails("gaqdetailsQuaterly");
        new GetAQuoteAction()
                .clickDualquoteLink()
                .enterGetaQuoteDetails(getDetails)
                .elecSupplyDetailsYes(getDetails)
                .dualGasSupplyDetailsYes(getDetails)
                .clickCalculateQuoteForDual()
                .selectElectricityPaymentOptionQuaterly()
                        // .verifyDualElecGaqrate(getDetails)
                        // .verifyDualGasGaqRate(getDetails)
                        // .verifyDualDbValue(getDetails)
                .verifyDualElecQuotePageCharge(getDetails)
                .verifyDualGasQuotePageCharge(getDetails)
                .clickDualQuaterlyQuotepageContinue()
                .navigateToGasRbYesSupplypage(getDetails).businessPageDetails(getDetails)
                .paymentPageDetailsQuaterly(getDetails).summaryPage(getDetails)
                .thankYouPage().gaqDBLeadVerify(getDetails);

    }

    @SuppressWarnings("unchecked")
//@Test(groups = { GetaQuoteSSN })
    
      * This Function allows the user to get Dual quote anonymously By choosing
      * Monthly Direct Debit radio button and verifies Quote value
      
    public void dualquoteRbNoPaymentMonthly() {
        Report.createTestLogHeader("Get A Quote-Dual Quote-RB No-Payment Monthly",
                "AnonymousJourney");
        GetAQuoteDetails getDetails = new TestDataHelper()
                .getallGetAQuoteDetails("gaqdetailsMonthly");
        new GetAQuoteAction().clickDualquoteLink().enterGetaQuoteDetails(getDetails)
                .elecSupplyDetailsNo(getDetails).dualGasSupplyDetailsNo(getDetails)
                .clickCalculateQuoteForDual().selectElectricityPaymentOptionMonthly()
                .retreiveDualQuotesUI().verifyDualGasQuotePageCharge(getDetails)

                .selectElectricityPaymentOptionMonthly().clickMonthlyQuotepageContinue()
                .navigateToGasRbNoSupplypage(getDetails).businessPageDetails(getDetails)
                .paymentPageDetailsMonthly(getDetails).summaryPage(getDetails)
                .thankYouPage().gaqDBLeadVerify(getDetails);
                //.verifyExistingDualQuoteValues(getDetails);
        // // .verifyDualNoDbValue(getDetails)
        // .verifyDualElecQuotePageCharge(getDetails)
        // .verifyDualGasQuotePageCharge(getDetails).clickMonthlyQuotepageContinue()
        // .navigateToGasRbYesSupplypage(getDetails).businessPageDetails(getDetails)
        // .paymentPageDetailsMonthly(getDetails).summaryPage(getDetails)
        // .thankYouPage().gaqDBLeadVerify(getDetails);

    }

    @SuppressWarnings("unchecked")
    //@Test(groups = { GetaQuoteSSN })
    
      * This Function allows the user to get Dual quote anonymously By choosing
      * Quaterly cash cheque radio button and verifies Quote value
      
    public void dualquoteRbNoPaymentQuaterly() {
        Report.createTestLogHeader("Get A Quote-DUAL Quote-RB No-Payment Quaterly",
                "AnonymousJourney");
        GetAQuoteDetails getDetails = new TestDataHelper()
                .getallGetAQuoteDetails("gaqdetailsQuaterly");
        new GetAQuoteAction().clickDualquoteLink().enterGetaQuoteDetails(getDetails)
                .elecSupplyDetailsNo(getDetails).dualGasSupplyDetailsNo(getDetails)
                .clickCalculateQuoteForDual().selectElectricityPaymentOptionQuaterly()
                .retreiveDualQuotesUI().verifyDualGasQuotePageCharge(getDetails)
                .clickDualQuaterlyQuotepageContinue()
                .navigateToGasRbNoSupplypage(getDetails).businessPageDetails(getDetails)
                .paymentPageDetailsQuaterly(getDetails).summaryPage(getDetails)
                .thankYouPage().gaqDBLeadVerify(getDetails);
                //.verifyExistingDualQuoteValues(getDetails);

    }

}
*/