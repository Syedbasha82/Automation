package bg.framework.app.functional.action.selfServe;


import bg.framework.app.functional.entities.MakeAPaymentProfile;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.selfServe.MakeAPaymentPage;
import bg.framework.app.functional.page.selfServe.MakeAPaymentPageNew;

public class MakeAPaymentActionNew {
	private MakeAPaymentProfile makeAPaymentProfile;
	
	public MakeAPaymentActionNew(MakeAPaymentProfile makeAPaymentProfile) {
        this.makeAPaymentProfile = makeAPaymentProfile;
    }

    public MakeAPaymentActionNew() {
    	
    }
    MakeAPaymentPageNew makeAPaymentPage = new MakeAPaymentPageNew();
    
    public MakeAPaymentActionNew makeAPaymentJourney(int cardtype){    	
    	makeAPaymentPage.makeAPaymentJourney(cardtype);
    	return this;
    }
    public MakeAPaymentActionNew navigateToManagePaymentCardDetailsPage(){    	
    	makeAPaymentPage.navigateToManagePaymentCardDetailsPage();
    	return this;
    }
    public MakeAPaymentActionNew navigatetoPaymentsPageFromMAP(){    	
    	makeAPaymentPage.navigatetoPaymentsPageFromMAP();
    	return this;
    }
    public MakeAPaymentActionNew cardStorageFunctionality(){    	
    	makeAPaymentPage.cardStorageFunctionality();
    	return this;
    }
    public MakeAPaymentActionNew cardStorageFunctionalityE2E(){    	
    	makeAPaymentPage.cardStorageFunctionalityE2E();
    	return this;
    }
    public MakeAPaymentActionNew confirmYourPaymentPage(){    	
    	makeAPaymentPage.confirmYourPaymentPage();
    	return this;
    }
    public MakeAPaymentActionNew verify3DSecurePage(){    	
    	makeAPaymentPage.verify3DSecurePage();
    	return this;
    }
    public MakeAPaymentActionNew verifyConfirmationPage(){    	
    	makeAPaymentPage.verifyConfirmationPage();
    	return this;
    }
    public MakeAPaymentActionNew navigatetoPaymentsPage(){    	
    	makeAPaymentPage.navigatetoPaymentsPage();
    	return this;
    }
    public MakeAPaymentActionNew verifyMAPManageSection(){    	
    	makeAPaymentPage.verifyMAPManageSection();
    	return this;
    }
    public MakeAPaymentActionNew editCard(){    	
    	makeAPaymentPage.editCard();
    	return this;
    }
    public MakeAPaymentActionNew deleteCard(){    	
    	makeAPaymentPage.deleteCard();
    	return this;
    }
    public MakeAPaymentActionNew verifyEditedDetails(){    	
    	makeAPaymentPage.verifyEditedDetails();
    	return this;
    }
    public MakeAPaymentActionNew navigatetoMakeAPaymentPage(){    	
    	makeAPaymentPage.navigatetoMakeAPaymentPage();
    	return this;
    }
}
