package bg.framework.app.functional.action.selfServe;

import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.action.reFactoring.AccOverviewAction;
import bg.framework.app.functional.action.reFactoring.PBFlagAction;
import bg.framework.app.functional.action.reFactoring.PaymentHistoryAction;
import bg.framework.app.functional.action.sales.BoilersAndCentralHeatingAction;
import bg.framework.app.functional.action.sales.CrossSellAction;
import bg.framework.app.functional.action.sales.GasAndElectricityAction;
import bg.framework.app.functional.action.sales.GetAPriceAction;
import bg.framework.app.functional.action.sales.OnlineEnergyTariffAction;
import bg.framework.app.functional.action.sales.ProductAndServicesAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.common.LegacyLoginPage;
import bg.framework.app.functional.page.reFactoring.PBFlagPage;
import bg.framework.app.functional.page.reFactoring.PaymentHistoryPage;
import bg.framework.app.functional.page.sales.GetAPricePage;
import bg.framework.app.functional.page.selfServe.AccountOverviewPage;
import bg.framework.app.functional.page.selfServe.AccountSummaryPage;
import bg.framework.app.functional.page.selfServe.HomeMovePage;
import bg.framework.app.functional.page.selfServe.UpgradeToSmartMeterPage;
import bg.framework.app.functional.action.sales.AcquisitionAction;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 23/03/12
 * Time: 10:15
 * To change this template use File | Settings | File Templates.
 */

public class CancelAnAppointmentAction {
    private UserProfile userProfile;

    public CancelAnAppointmentAction(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public CancelAnAppointmentAction() {

    }

    public CancelAnAppointmentAction navigateToChooseAnAppointmentPage() {
        new UpgradeToSmartMeterPage().navigateToChooseAnAppointmentPage();
        return this;
    }
   
    public CancelAnAppointmentAction navigateToReviewDetailsPage() {
        new UpgradeToSmartMeterPage().navigateToReviewDetailsPage();
        return this;
    }
    
    public CancelAnAppointmentAction navigateToConfirmationPage() {
        new UpgradeToSmartMeterPage().navigateToConfirmationPage(userProfile);
        return this;
    }
    public AccountOverviewAction navigateToYourAccountPage() {
        new UpgradeToSmartMeterPage().navigateToYourAccountPage();
        return new AccountOverviewAction() ;
    }
    public CancelAnAppointmentAction verifyAppointmentDateAndTime() {
        new UpgradeToSmartMeterPage().verifyAppointmentDateAndTime();
        return this ;
    }
}
