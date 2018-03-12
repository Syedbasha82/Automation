package bg.framework.app.functional.action.sales;

import bg.framework.app.functional.entities.GetAPrice;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.sales.GetAPricePage;

/**
 * Method: GetAPriceAction
 */
public class GetAPriceAction {

    public GetAPriceAction verifyAndEnterGAPAnonymousDetails(GetAPrice getaPrice) {
        GetAPricePage getaPricePage = new GetAPricePage();
       // getaPricePage.fillGAPAnonymousDetails()
        getaPricePage.elecloop(getaPrice);
        return this;
    }

    public GetAPriceAction verifyAndEnterGAPDetails(GetAPrice getaPrice, UserProfile userProfile) {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.fillGAPDetails(getaPrice, userProfile);
        return this;
    }

    public GetAPriceAction verifyAndEnterOAMGAPDetails(GetAPrice getaPrice,UserProfile userProfile) {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.fillOAMGAPDetails(getaPrice,userProfile);
        return this;
    }

    public GetAPriceAction verifyErrorValidationsGAPDetails(GetAPrice getaPrice) {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.verifyGAPErrorValidations(getaPrice);
        return this;
    }

    public GetAPriceAction verifyAllGasSupplierGAPDetails(GetAPrice getaPrice) {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.verifyAllGasSupplierDetails(getaPrice);
        return this;
    }

    public GetAPriceAction verifyAllElecSupplierGAPDetails(GetAPrice getaPrice) {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.verifyAllElectricitySupplierDetails(getaPrice);
        return this;
    }

    public GetAPriceAction verifyAllDualSupplierGAPDetails(GetAPrice getaPrice) {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.verifyAllDualSupplierDetails(getaPrice);
        return this;
    }

    public AcquisitionAction switchTariff(GetAPrice getaPrice) {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.clickSwitchtoTariff(getaPrice);
        return new AcquisitionAction();
    }
    
    public AcquisitionAction switchTariff(String strTariff) {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.switchTariff(strTariff);
        return new AcquisitionAction();
    }
    
    public GetAPriceAction navigateToGetAQuotePage() {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.navigateToGetAQuotePage();
        return new GetAPriceAction();
    }
    
    public GetAPriceAction enterGAPAnonymousDetails() {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.enterGAPAnonymousDetails();
        return new GetAPriceAction();
    } 
    
    public GetAPriceAction enterAnonymousDetails() {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.enterAnonymousDetails();
        return new GetAPriceAction();
    }
    
    public GetAPriceAction enterGAPAnonymousDetailsEntire(String tariff,String flowType) {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.enterGAPAnonymousDetailsEntire(tariff,flowType);
        return new GetAPriceAction();
    }
    
    public GetAPriceAction enterGAPDualAnonymousDetailsEntire(String tariff,String flowType) {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.enterGAPDualAnonymousDetailsEntire(tariff,flowType);
        return new GetAPriceAction();
    }
    
    public GetAPriceAction enterOAMGAPDetails(UserProfile userProfile) {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.enterOAMGAPDetails(userProfile);
        return new GetAPriceAction();
    }
    
    public GetAPriceAction enterOAMGAPPayAsYouGoDetails(UserProfile userProfile) {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.enterOAMGAPPayAsYouGoDetails(userProfile);
        return new GetAPriceAction();
    }
    
    public GetAPriceAction enterOAMGAPGasDetails(UserProfile userProfile) {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.enterOAMGAPGasDetails(userProfile);
        return new GetAPriceAction();
    }
    
    public GetAPriceAction enterOAMGAPGasPayAsYouGoDetails(UserProfile userProfile) {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.enterOAMGAPGasPayAsYouGoDetails(userProfile);
        return new GetAPriceAction();
    }
    
    
    public GetAPriceAction enterOAMGAPDualDetails(UserProfile userProfile) {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.enterOAMGAPDualDetails(userProfile);
        return new GetAPriceAction();
    }
    
    public GetAPriceAction enterOAMGAPDualPayAsYouGoDetails(UserProfile userProfile) {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.enterOAMGAPDualPayAsYouGoDetails(userProfile);
        return new GetAPriceAction();
    }
    
    public GetAPriceAction newVerifyAllGasSupplierGAPDetails(GetAPrice getaPrice) {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.newVerifyAllGasSupplierDetails(getaPrice);
        return this;
    }
    
    public GetAPriceAction newVerifyAllGasSupplierGAPPayAsYouGoDetails(GetAPrice getaPrice) {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.newVerifyAllGasSupplierPayAsYouGoDetails(getaPrice);
        return this;
    }
    public GetAPriceAction newVerifyAllElecSupplierGAPDetails(GetAPrice getaPrice) {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.newVerifyAllElecSupplierGAPDetails(getaPrice);
        return this;
    }
    
    public GetAPriceAction newVerifyAllElecSupplierPayAsYouGoGAPDetails(GetAPrice getaPrice) {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.newVerifyAllElecSupplierPayAsYouGoGAPDetails(getaPrice);
        return this;
    }
    
    public GetAPriceAction newVerifyAllDualSupplierGAPDetails(GetAPrice getaPrice) {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.newVerifyAllDualSupplierGAPDetails(getaPrice);
        return this;
    }
    
    public GetAPriceAction newVerifyAllDualSupplierPayAsYouGoGAPDetails(GetAPrice getaPrice) {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.newVerifyAllDualSupplierPayAsYouGoGAPDetails(getaPrice);
        return this;
    }
    
    public GetAPriceAction verifyAndEnterGAQAnonymousDetails() {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.verifyAndEnterGAQAnonymousDetails();
        return this;
    }
    
    public GetAPriceAction runBatchGetAQuote() {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.runBatchGetAQuote();
        return this;
    }
    
    public GetAPriceAction verifyLeadDB() {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.verifyLeadDB();
        return this;
    }
    
    public GetAPriceAction logout() {
        GetAPricePage getaPricePage = new GetAPricePage();
        getaPricePage.logout();
        return this;
    }
    
    public String getTariffsEndTOEnd(int tariffCount, String supplier) {
        GetAPricePage getaPricePage = new GetAPricePage();
        return getaPricePage.getTariffsEndTOEnd(tariffCount,supplier);
        
    }
    
}
