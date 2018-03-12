package bg.framework.app.functional.action.sales;


import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.entities.Acquisition;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.sales.*;
import bg.framework.app.functional.page.selfServe.PaymentDetailsPage;
import bg.framework.app.functional.page.selfServe.PersonalDetailsPage;


/**
 * Created by IntelliJ IDEA.
 * User: !boobalas
 * Date: 14/12/11
 * Time: 06:50
 * To change this template use File | Settings | File Templates.
 */
public class AcquisitionAction {

    Acquisition acquisition;
    AcquisitionAction acquisitionaction;

    //NavigateToAcquisitionPage acquisitiondetailspage= new NavigateToAcquisitionPage();
    public AcquisitionAction() {

    }

    public AcquisitionAction(Acquisition acquisition) {
        this.acquisition = acquisition;
    }


    public AcquisitionAction validateYourOrder() {
        return new YourOrderPage().errorYourOrderPageFieldVerification();
    }
    
    public AcquisitionAction errorPaymentPage() {
        return new PaymentDetailsPage().errorPaymentPage();
    }
    
    public AcquisitionAction errorReviewOrder() {
        return new ReviewOrderPage().errorReviewOrder();
    }

    public AcquisitionAction yourOrderAnonymousNavigation(Acquisition acquisition,UserProfile userProfile) {
        AcquisitionAction acquisitionaction = new YourOrderPage().yourOrderPageAnonymousNavigation(acquisition,userProfile);
        return acquisitionaction;

    }
    
    public AcquisitionAction yourOrderPageAnonymousCreateLogin(Acquisition acquisition,UserProfile userProfile) {
        AcquisitionAction acquisitionaction = new YourOrderPage().yourOrderPageAnonymousCreateLogin(acquisition,userProfile);
        return acquisitionaction;

    }

    public AcquisitionAction energySmartAcquisitionYourOrderPage(Acquisition acquisition, UserProfile userProfile) {
        AcquisitionAction acquisitionaction = new YourOrderPage().energySmartAcquisitionYourOrderPage(acquisition, userProfile);
        return acquisitionaction;

    }


    public AcquisitionAction yourOrderGasBG(Acquisition acquisition) {
        AcquisitionAction acquisitionaction = new YourOrderPage().yourOrderPageGasBG(acquisition);
        return acquisitionaction;

    }

    public AcquisitionAction yourOrderElecBG(Acquisition acquisition) {
        AcquisitionAction acquisitionaction = new YourOrderPage().yourOrderElecBG(acquisition);
        return acquisitionaction;
    }

    public AcquisitionAction yourOrderDualBG(Acquisition acquisition) {
        AcquisitionAction acquisitionaction = new YourOrderPage().yourOrderDualBG(acquisition);
        return acquisitionaction;
    }

    public AcquisitionAction forcedLoginYourOrderPage(Acquisition acquisition, UserProfile userProfile) {
        AcquisitionAction acquisitionaction = new YourOrderPage().forcedLoginYourOrderPage(acquisition, userProfile);
        return acquisitionaction;
    }
    
    public AcquisitionAction forcedLoginOnly(Acquisition acquisition, UserProfile userProfile) {
        new YourOrderPage().forcedLoginOnly(acquisition, userProfile);
        return acquisitionaction;
    }
    
    public AcquisitionAction forcedRegistrationYourOrderPage(Acquisition acquisition,UserProfile userProfile) {
        AcquisitionAction acquisitionaction = new YourOrderPage().forcedRegistrationYourOrderPage(acquisition, userProfile);
        return acquisitionaction;
    }
    
    public AcquisitionAction forcedRegisrationOnly(Acquisition acquisition,UserProfile userProfile) {
        new YourOrderPage().forcedRegisrationOnly(acquisition, userProfile);
        return acquisitionaction;
    }
    
    public AcquisitionAction energySmartDifferentSupplyAddress(Acquisition acquisition) {
        new YourOrderPage().energySmartDifferentSupplyAddress(acquisition);
        return acquisitionaction;
    }

    public AcquisitionAction validatePersonalDetails(Acquisition acquisition) {
        AcquisitionAction acquisitionaction = new PersonalDetailsPage().errorpersonalDetailsPage(acquisition);
        return acquisitionaction;
    }

    public AcquisitionAction enterPersonalDetailsPage(Acquisition acquisition, UserProfile userProfile) {
        AcquisitionAction acquisitionaction = new PersonalDetailsPage().personalDetailsPageNavigation(acquisition, userProfile);
        return acquisitionaction;
    }
    
    public AcquisitionAction energySmartDifferentSupplyAddressGas(Acquisition acquisition) {

        AcquisitionAction acquisitionaction = new YourOrderPage().energySmartDifferentSupplyAddressGas(acquisition);
        return acquisitionaction;
    }

    public AcquisitionAction energySmartDifferentSupplyAddressElec(Acquisition acquisition) {

        AcquisitionAction acquisitionaction = new YourOrderPage().energySmartDifferentSupplyAddressElec(acquisition);
        return acquisitionaction;
    }

    public AcquisitionAction energySmartDifferentSupplyAddressDual(Acquisition acquisition) {

        AcquisitionAction acquisitionaction = new YourOrderPage().energySmartDifferentSupplyAddressDual(acquisition);
        return acquisitionaction;
    }


    public AcquisitionAction energySmartPersonalDetailsPage(Acquisition acquisition) {

        AcquisitionAction acquisitionaction = new PersonalDetailsPage().energySmartPersonalDetailsPage(acquisition);
        return acquisitionaction;
    }
    
    public AcquisitionAction energySmartEnterPassword(Acquisition acquisition) {

        new PersonalDetailsPage().passwordFieldSelection(acquisition);
        return new AcquisitionAction();
    }
    
    public AcquisitionAction energySmartEnterAddress(Acquisition acquisition) {

        new PersonalDetailsPage().addressSelection(acquisition);
        return new AcquisitionAction();
    }
    
    public AcquisitionAction energySmartEnterPersonalDetails(Acquisition acquisition,UserProfile userProfile) {

        new PersonalDetailsPage().selectPersonalDetails(acquisition,userProfile);;
        return new AcquisitionAction();
    }

    public AcquisitionAction energySmartAddressSelection(Acquisition acquisition) {
        AcquisitionAction acquisitionaction = new PersonalDetailsPage().addressSelection(acquisition);
        return acquisitionaction;
    }
    
    public AcquisitionAction onlineAccountPersonalDetailsPageNavigation(Acquisition acquisition,UserProfile userProfile) {
        AcquisitionAction acquisitionaction = new PersonalDetailsPage().onlineAccountPersonalDetailsPageNavigation(acquisition, userProfile);
        return acquisitionaction;
    }
    
    public AcquisitionAction energySmartonlineAccountPersonalDetailsPageNavigation(Acquisition acquisition,UserProfile userProfile) {
        AcquisitionAction acquisitionaction = new PersonalDetailsPage().energySmartonlineAccountPersonalDetailsPageNavigation(acquisition, userProfile);
        return acquisitionaction;
    }
    

    public AcquisitionAction validateCurrentServices() {
        CurrentServicesPage currentServicesPage = new CurrentServicesPage();
        currentServicesPage.errorCurrentServices();
        return acquisitionaction;
    }


    public AcquisitionAction enterCurrentServices(Acquisition acquisition) {

        AcquisitionAction acquisitionaction = new CurrentServicesPage().currentServicesPageNavigation(acquisition);
        return acquisitionaction;

    }

    public AcquisitionAction gasDefaultCurrentServicesPageNavigation(Acquisition acquisition) {

        AcquisitionAction acquisitionaction = new CurrentServicesPage().gasDefaultCurrentServicesPageNavigation(acquisition);
        return acquisitionaction;

    }
    
    public AcquisitionAction gasPrepaymentCurrentServicesPageNavigation(Acquisition acquisition) {

        AcquisitionAction acquisitionaction = new CurrentServicesPage().gasPrepayment(acquisition);
        return acquisitionaction;

    }


    public AcquisitionAction validatePaymentOptions(Acquisition acquisition) {

        PaymentDetailsPage paymentdetailspage = new PaymentDetailsPage();
        paymentdetailspage.accountNamevalidation(acquisition);
        paymentdetailspage.accountNumbervalidation(acquisition);

        return acquisitionaction;
    }

    public AcquisitionAction variableDirectDebitPayment(Acquisition acquisition) {
        AcquisitionAction acquisitionaction = new PaymentDetailsPage().variableDirectDebitPayment(acquisition);
        return acquisitionaction;

    }

    public AcquisitionAction enterPaymentOptions(Acquisition acquisition) {
        AcquisitionAction acquisitionaction = new PaymentDetailsPage().paymentPageNavigation(acquisition);
        return acquisitionaction;

    }
    
    public AcquisitionAction enterPaymentOptionsEE50(Acquisition acquisition) {
        AcquisitionAction acquisitionaction = new PaymentDetailsPage().paymentPageNavigationEE50(acquisition);
        return acquisitionaction;

    }
    
    public AcquisitionAction QuarterlyCashCheque(Acquisition acquisition) {
        AcquisitionAction acquisitionaction = new PaymentDetailsPage().QuarterlyCashCheque(acquisition);
        return acquisitionaction;

    }
    
    public AcquisitionAction QuarterlyCashChequeEE50(Acquisition acquisition) {
        AcquisitionAction acquisitionaction = new PaymentDetailsPage().QuarterlyCashChequeEE50(acquisition);
        return acquisitionaction;

    }

    public AcquisitionAction validateReviewOrder() {

        AcquisitionAction acquisitionaction = new ReviewOrderPage().errorReviewOrder();
        return acquisitionaction;

    }

    public AcquisitionAction reviewOrderPageNavigation() {
        AcquisitionAction acquisitionaction = new ReviewOrderPage().reviewOrderNavigation();
        return acquisitionaction;

    }
    
    /*public AcquisitionAction editreviewOrderPageNavigation() {
        //AcquisitionAction acquisitionaction = new ReviewOrderPage().editreviewOrder();
        return acquisitionaction;

    }*/

    public AcquisitionAction gasBgEnergySmartElectricityAcquisition(Acquisition acquisition) {
        YourTariffPage oyourtariffpage = new YourTariffPage();
        oyourtariffpage.gasBGEnergySmartyElectricityAcquisition(acquisition);
        return this;
    }

    public AcquisitionAction gasBGEnergySmartDualOrder(Acquisition acquisition) {
        YourTariffPage oyourtariffpage = new YourTariffPage();
        oyourtariffpage.gasBGEnergySmartDualOrder(acquisition);
        return this;
    }

    public AcquisitionAction gasBGEnergySmartGasConversion(Acquisition acquisition) {
        YourTariffPage oyourtariffpage = new YourTariffPage();
        oyourtariffpage.gasBGEnergySmartGasConversion(acquisition);
        return this;
    }

    public AcquisitionAction elecBGEnergySmartDualOrder(Acquisition acquisition) {
        YourTariffPage oyourtariffpage = new YourTariffPage();
        oyourtariffpage.elecBGEnergySmartDualOrder(acquisition);
        return this;
    }

    public AcquisitionAction elecBGEnergySmartElecConversion(Acquisition acquisition) {
        YourTariffPage oyourtariffpage = new YourTariffPage();
        oyourtariffpage.elecBGEnergySmartElecConversion(acquisition);
        return this;
    }

    public AcquisitionAction elecBGEnergySmartGasAcquisition(Acquisition acquisition) {
        YourTariffPage oyourtariffpage = new YourTariffPage();
        oyourtariffpage.elecBGEnergySmartGasAcquisition(acquisition);
        return this;
    }

    public AcquisitionAction inEligibleEnergySmartMessage() {
        YourTariffPage oyourtariffpage = new YourTariffPage();
        oyourtariffpage.inEligibleEnergySmartMessage();
        return this;
    }

    public AcquisitionAction energySmartGasBGOrderDual(Acquisition acquisition) {
        YourTariffPage oyourtariffpage = new YourTariffPage();
        oyourtariffpage.energySmartGasBGOrderDual(acquisition);
        return this;
    }

    public AcquisitionAction energySmartGasBGOrderGas(Acquisition acquisition) {
        YourTariffPage oyourtariffpage = new YourTariffPage();
        oyourtariffpage.energySmartGasBGOrderGas(acquisition);
        return this;
    }

    public AcquisitionAction energySmartGasBGOrderElec(Acquisition acquisition) {
        YourTariffPage oyourtariffpage = new YourTariffPage();
        oyourtariffpage.energySmartGasBGOrderElec(acquisition);
        return this;
    }

    public AcquisitionAction energySmartElecBGOrderDual(Acquisition acquisition) {
        YourTariffPage oyourtariffpage = new YourTariffPage();
        oyourtariffpage.energySmartElecBGOrderDual(acquisition);
        return this;
    }

    public AcquisitionAction energySmartElecBGOrderElec(Acquisition acquisition) {
        YourTariffPage oyourtariffpage = new YourTariffPage();
        oyourtariffpage.energySmartElecBGOrderElec(acquisition);
        return this;
    }

    public AcquisitionAction energySmartElecBGOrderGas(Acquisition acquisition) {
        YourTariffPage oyourtariffpage = new YourTariffPage();
        oyourtariffpage.energySmartElecBGOrderGas(acquisition);
        return this;
    }

    public AcquisitionAction verifyThankYouPage(UserProfile userProfile) {
        AcquisitionAction acquisitionaction = new ThankYouPage().verifyThankYouPage(userProfile);
        return new AcquisitionAction();
    }

    public AcquisitionAction verifyLeadData() {
        AcquisitionAction acquisitionaction = new ReviewOrderPage().verifyLeadData();
        return new AcquisitionAction();
    }
    
    public AcquisitionAction getLeadID() {
        AcquisitionAction acquisitionaction = new ReviewOrderPage().getLeadID();
        return new AcquisitionAction();
    }
    public AcquisitionAction domarssalesRunBatch(String batch) {
        //AcquisitionAction acquisitionaction = new ThankYouPage().domarssalesRunBatch(batch);
        return new AcquisitionAction();
    }
    public AcquisitionAction deleteWTP(UserProfile userProfile) {
        AcquisitionAction acquisitionaction = new ThankYouPage().deleteWTP(userProfile);
        return new AcquisitionAction();
    }


    public HomePageAction backToHomePage() {
        AcquisitionAction acquisitionaction = new ThankYouPage().backToHomePage();
        AcquisitionAction acquisitionaction2 = new ThankYouPage().verifyInAccountSummaryPage();
        return new HomePageAction();
    }
    
    public AcquisitionAction checkMediaCode(String mediaCode){
    	//AcquisitionAction acquisitionaction = new ThankYouPage().checkMediaCode(mediaCode);
        return new AcquisitionAction();
 
    	
    }

    public HomePageAction logoutFromThankYouPage() {
        AcquisitionAction acquisitionaction = new ThankYouPage().logoutThankYouPage();
        return new HomePageAction();
    }
    public AcquisitionAction logoutFromConvThankYouPage() {
        AcquisitionAction acquisitionaction = new ThankYouPage().logoutThankYouPage();
        return new AcquisitionAction();
    }

    public AcquisitionAction payAsYouGoYourOrderDetails(Acquisition acquisition) {
        AcquisitionAction acquisitionaction = new YourOrderPage().payAsYouGoYourOrderDetails(acquisition);
        return acquisitionaction;
    }

    public AcquisitionAction energySmartDeregister(String accountNumber) {
        AcquisitionAction acquisitionaction = new ThankYouPage().energySmart(accountNumber);
        return new AcquisitionAction();
    }
    
    public AcquisitionAction changeTariff(String accountNumber){
    	 //AcquisitionAction acquisitionaction = new ThankYouPage().changeTariff(accountNumber);
    	 return new AcquisitionAction();
    }

    public AcquisitionAction freeInsulation(){
     	 AcquisitionAction acquisitionaction = new FreeInsulationPage().enterInsulation();
     	 return new AcquisitionAction();
     }
    
    public AcquisitionAction enterfreeInsulation(Acquisition acquisition,UserProfile userProfile){
    	 AcquisitionAction acquisitionaction = new FreeInsulationPage().enterHomecareDetails(acquisition, userProfile);
    	 return new AcquisitionAction();
    }
    
    public AcquisitionAction goToDualFixAndFallMarch(){
   	 AcquisitionAction acquisitionaction = new ThankYouPage().goToDualFixAndFallMarch();
   	 return new AcquisitionAction();
   }
    public AcquisitionAction goToElecFixAndFallMarch(){
   	 AcquisitionAction acquisitionaction = new ThankYouPage().goToElecFixAndFallMarch();
   	 return new AcquisitionAction();
   }
    public AcquisitionAction goToGasFixAndFallMarch(){
   	 AcquisitionAction acquisitionaction = new ThankYouPage().goToGasFixAndFallMarch();
   	 return new AcquisitionAction();
   }
    
    public AcquisitionAction goToDualFixAndFallMarchesmart(){
      	 AcquisitionAction acquisitionaction = new ThankYouPage().goToDualFixAndFallMarchesmart();
      	 return new AcquisitionAction();
      }
       public AcquisitionAction goToElecFixAndFallMarchesmart(){
      	 AcquisitionAction acquisitionaction = new ThankYouPage().goToElecFixAndFallMarchesmart();
      	 return new AcquisitionAction();
      }
       public AcquisitionAction goToGasFixAndFallMarchesmart(){
      	 AcquisitionAction acquisitionaction = new ThankYouPage().goToGasFixAndFallMarchesmart();
      	 return new AcquisitionAction();
      }
    
    public AcquisitionAction goToSEDualpricepledgenovember(){
      	 AcquisitionAction acquisitionaction = new ThankYouPage().goToSEDualpricepledgenovember();
      	 return new AcquisitionAction();
      }
    public AcquisitionAction goToDualClearAndSimplesmart(){
      	 AcquisitionAction acquisitionaction = new ThankYouPage().goToDualClearAndSimplesmart();
      	 return new AcquisitionAction();
      }
       public AcquisitionAction goToElecClearAndSimplesmart(){
      	 AcquisitionAction acquisitionaction = new ThankYouPage().goToElecClearAndSimplesmart();
      	 return new AcquisitionAction();
      }
       public AcquisitionAction goToGasClearAndSimplesmart(){
      	 AcquisitionAction acquisitionaction = new ThankYouPage().goToGasClearAndSimplesmart();
      	 return new AcquisitionAction();
      }
       
       public AcquisitionAction goToDualFixandFallNovember(){
    	   	 AcquisitionAction acquisitionaction = new ThankYouPage().goToDualFixandFallNovember();
    	   	 return new AcquisitionAction();
    	   }
    	    public AcquisitionAction goToElecFixandFallNovember(){
    	   	 AcquisitionAction acquisitionaction = new ThankYouPage().goToElecFixandFallNovember();
    	   	 return new AcquisitionAction();
    	   }
    	    public AcquisitionAction goToGasFixandFallNovember(){
    	   	 AcquisitionAction acquisitionaction = new ThankYouPage().goToGasFixandFallNovember();
    	   	 return new AcquisitionAction();
    	   }
    	    
    	    
    	    public AcquisitionAction goToDualFixandFallNovemberesmart(){
       	   	 AcquisitionAction acquisitionaction = new ThankYouPage().goToDualFixandFallNovemberesmart();
       	   	 return new AcquisitionAction();
       	   }
       	    public AcquisitionAction goToElecFixandFallNovemberesmart(){
       	   	 AcquisitionAction acquisitionaction = new ThankYouPage().goToElecFixandFallNovemberesmart();
       	   	 return new AcquisitionAction();
       	   }
       	    public AcquisitionAction goToGasFixandFallNovemberesmart(){
       	   	 AcquisitionAction acquisitionaction = new ThankYouPage().goToGasFixandFallNovemberesmart();
       	   	 return new AcquisitionAction();
       	   }
    
    	    public AcquisitionAction verifyEshopLeadData() {
    	        AcquisitionAction acquisitionaction = new ReviewOrderPage().verifyEshopLeadData();
    	        //acquisitionaction = new ReviewOrderPage().getEshopLeadType();
    	        return new AcquisitionAction();
    	    }
    	    public AcquisitionAction verifyAuditEventID(UserProfile userProfile) {
    	    	 AcquisitionAction acquisitionaction = new ReviewOrderPage().getAuditEventID(userProfile);
				return acquisitionaction;
    	    }
    	    public AcquisitionAction getEshopLeadID() {
    	        AcquisitionAction acquisitionaction = new ReviewOrderPage().getEshopLeadID();
    	        return new AcquisitionAction();
    	    }
    	    public AcquisitionAction verifyandClickBackbutton(){
       	   	 AcquisitionAction acquisitionaction = new YourOrderPage().verifyandclickBackbutton();
       	   	 return new AcquisitionAction();
       	   }
    	    public AcquisitionAction verifyandClickCancelbutton(){
          	   	 AcquisitionAction acquisitionaction = new YourOrderPage().verifyandclickCancelbutton();
          	   	 return new AcquisitionAction();
          	}
    	    public AcquisitionAction enterPersonalDetailsPagePrevAddr(Acquisition acquisition, UserProfile userProfile) {

    	        AcquisitionAction acquisitionaction = new PersonalDetailsPage().personalDetailsPagePrevAddrNavigation(acquisition, userProfile);
    	        return acquisitionaction;
    	    }
    	    public AcquisitionAction enterPersonalDetailsPageTwoPrevAddr(Acquisition acquisition, UserProfile userProfile) {

    	        AcquisitionAction acquisitionaction = new PersonalDetailsPage().personalDetailsPageLessthanTwoPrevAddr(acquisition, userProfile);
    	        return acquisitionaction;
    	    }
    	    
    	    public AcquisitionAction switchToElectricity()
    	    {
    	    	CrossSellPage switchToElec=new CrossSellPage();
    	    	switchToElec.switchToElectricity();
    	    	return this;
    	    }
    	    public AcquisitionAction switchToGas()
    	    {
    	    	CrossSellPage switchToGas=new CrossSellPage();
    	    	switchToGas.switchToGas();
    	    	return this;
    	    	
    	    }

    	    public AcquisitionAction dualEnergysmartOrderDual(Acquisition acquisition)
    	    {
    	    	YourTariffPage dualToDual=new YourTariffPage();
    	    	dualToDual.dualEnergysmartOrderDual(acquisition);
    	    	return new AcquisitionAction();
    	    }
}

